/**
 * Created on Dec 10, 2006 at 7:01:55 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.MultiSchemaHelper;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class LoadDocumentTemplatesTask extends UpdateDatabaseTask {

  private static final String SELECT_DOCUMENT_TEMPLATE_SQL = "SELECT id_document_template,\n" +
                                                             "       id_document_template_type,\n" +
                                                             "       nbr_major_version,\n" +
                                                             "       nbr_minor_version,\n" +
                                                             "       nbr_revision,\n" +
                                                             "       txt_version_string,\n" +
                                                             "       txt_short_description,\n" +
                                                             "       txt_long_description, \n" +
                                                             "       ind_active, \n" +
                                                             "       txt_html\n" +
                                                             "  FROM caps.document_template\n" +
                                                             "FOR UPDATE";

  private static final String SELECT_DOCUMENT_TEMPLATE_TYPE_SQL = "SELECT id_document_template_type,\n" +
                                                                  "       txt_name,\n" +
                                                                  "       nm_document\n" +
                                                                  "  FROM caps.document_template_type";

  private static final String ID_DOCUMENT_TEMPLATE = "id_document_template";
  private static final String ID_DOCUMENT_TEMPLATE_TYPE = "id_document_template_type";
  private static final String TXT_VERSION_STRING = "txt_version_string";
  private static final String NBR_MAJOR_VERSION = "nbr_major_version";
  private static final String NBR_MINOR_VERSION = "nbr_minor_version";
  private static final String NBR_REVISION = "nbr_revision";
  private static final String TXT_HTML = "txt_html";
  private static final String TXT_LONG_DESCRIPTION = "txt_long_description";
  private static final String TXT_SHORT_DESCRIPTION = "txt_short_description";
  private static final String IND_ACTIVE = "ind_active";
  private static final String TXT_NAME = "txt_name";
  private static final String NM_DOCUMENT = "nm_document";

  private static final String SEQ_DOCUMENT_TEMPLATE_TYPE = "caps.seq_document_template_type";

  private static final String TEMPLATE_EXTENSION = ".htm";

  private File metadata;
  private File templateDir;

  public void setMetadata(File metadata) {
    this.metadata = metadata;
  }

  public void setTemplateDir(File templateDir) {
    this.templateDir = templateDir;
  }

  public void execute() throws BuildException {
    if (metadata == null) {
      throw new BuildException("Document metadata file not set.");
    } else if (!metadata.isFile()) {
      throw new BuildException("Document metadata file '" + metadata.getAbsolutePath() + "' does not exist.");
    }
    if (templateDir == null) {
      throw new BuildException("Document template dir not set.");
    } else if (!templateDir.isDirectory()) {
      throw new BuildException("Document template dir '" + templateDir.getAbsolutePath() + "' does not exist.");
    }
    // Parse the document meta data into RAM for easy lookup.
    Map<String, Type> nmDocumentTypeMap = new HashMap<String, Type>();
    Map<String, Template> filenameTemplateMap = new HashMap<String, Template>();
    parseXmlMetaData(nmDocumentTypeMap, filenameTemplateMap);
    Connection conn = null;
    Set<String> schemas;
    try {
      conn = getConnection();
      schemas = MultiSchemaHelper.getSchemaList(conn);
    } catch (SQLException e) {
      throw new BuildException("Failed to retrieve schema list.", e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
    }
    // Execute on the default schema first.
    updateDocumentTemplatesForSchema(nmDocumentTypeMap, filenameTemplateMap, MultiSchemaHelper.DEFAULT_SCHEMA);
    // Now, execute on the list of schemas
    for (Iterator<String> it = schemas.iterator(); it.hasNext();) {
      updateDocumentTemplatesForSchema(nmDocumentTypeMap, filenameTemplateMap, it.next());
    }
  }

  private void updateDocumentTemplatesForSchema(Map<String, Type> nmDocumentTypeMap,
                                                Map<String, Template> filenameTemplateMap,
                                                String schema) {
    Connection conn = null;
    try {
      conn = createConnection();
      Map<Integer, Type> idTypeMap = updateDocumentTemplateTypes(nmDocumentTypeMap, conn, schema);
      updateDocumentTemplates(idTypeMap, filenameTemplateMap, conn, schema);
      conn.commit();
    } catch (SQLException e) {
      rollback(conn);
      throw new BuildException("Failure interacting with database.", e);
    } catch (IOException e) {
      rollback(conn);
      throw new BuildException("Failure interacting with file system.", e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          log("Failed to close DB conneciton.", Project.MSG_WARN);
        }
      }
    }
  }

  private void rollback(Connection conn) {
    try {
      conn.rollback();
    } catch (SQLException e1) {
      log("Failed to explicity set rollback.", Project.MSG_WARN);
    }
  }

  private void updateDocumentTemplates(Map<Integer, Type> idTypeMap, Map<String, Template> filenameTemplateMap,
                                       Connection conn, String schema) throws SQLException, IOException {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      String sql = DEFAULT_SCHEMA_PATTERN.matcher(SELECT_DOCUMENT_TEMPLATE_SQL).replaceAll(schema + ".");
      stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      rs = stmt.executeQuery();
      // Loop over the results and change anything that needs to be change.  Let the JDBC driver do the update.
      while (rs.next()) {
        int idDocumentTemplateType = rs.getInt(ID_DOCUMENT_TEMPLATE_TYPE);
        String txtVersionString = rs.getString(TXT_VERSION_STRING);
        Type type = idTypeMap.get(idDocumentTemplateType);
        if (type == null) {
          log("Ignoring template '" + txtVersionString + "' because no associated type could be found.");
          continue;
        }
        String nmDocument = type.getNmDocument();
        int nbrMajorVersion = rs.getInt(NBR_MAJOR_VERSION);
        int nbrMinorVersion = rs.getInt(NBR_MINOR_VERSION);
        int nbrRevision = rs.getInt(NBR_REVISION);
        // Look for an existing template
        String filename = getTemplateFilename(nmDocument, nbrMajorVersion, nbrMinorVersion, nbrRevision);
        Template template = filenameTemplateMap.remove(filename);
        if (template == null) {
          log("Ignoring template '" + txtVersionString + "' because no metatdata found.", Project.MSG_WARN);
          continue;
        }
        Blob txtHtmlBlob = rs.getBlob(TXT_HTML);
        byte[] txtHtmlBytes;
        if (txtHtmlBlob != null) {
          long blobLength = txtHtmlBlob.length();
          if (blobLength > (long) Integer.MAX_VALUE) {
            throw new IndexOutOfBoundsException("Document blob size is too large: " + blobLength + " bytes");
          }
          log("Blob size is: " + blobLength, Project.MSG_DEBUG);
          txtHtmlBytes = txtHtmlBlob.getBytes(1l, (int) blobLength);
        } else {
          // Use an empty array to prevent NPE's
          txtHtmlBytes = new byte[0];
        }
        byte[] templateFileBytes = getTemplateFileBytes(template);
        boolean rowUpdated = false;
        if (!Arrays.equals(txtHtmlBytes, templateFileBytes)) {
          rowUpdated = true;
          log("The html bytes were different for: " + template.getFullVersionString(), Project.MSG_DEBUG);
          rs.updateBinaryStream(TXT_HTML, new ByteArrayInputStream(templateFileBytes), templateFileBytes.length);
        }
        String fullVersionString = template.getFullVersionString();
        if (!fullVersionString.equals(txtVersionString)) {
          rowUpdated = true;
          log("The full version string was  different for: " + template.getFullVersionString(), Project.MSG_DEBUG);
          rs.updateString(TXT_VERSION_STRING, fullVersionString);
        }
        String txtLongDescription = rs.getString(TXT_LONG_DESCRIPTION);
        if (txtLongDescription == null ?
            template.getLongDesc() != null : !txtLongDescription.equals(template.getLongDesc())) {
          rowUpdated = true;
          log("The long description was different for: " + template.getFullVersionString(), Project.MSG_DEBUG);
          rs.updateString(TXT_LONG_DESCRIPTION, template.getLongDesc());
        }
        String txtShortDescription = rs.getString(TXT_SHORT_DESCRIPTION);
        if (txtShortDescription == null ?
            template.getShortDesc() != null : !txtShortDescription.equals(template.getShortDesc())) {
          rowUpdated = true;
          log("The html short description was different for: " + template.getFullVersionString(), Project.MSG_DEBUG);
          rs.updateString(TXT_SHORT_DESCRIPTION, template.getShortDesc());
        }
        String indActive = rs.getString(IND_ACTIVE);
        if (indActive == null || !indActive.equals(template.getIndActive())) {
          rowUpdated = true;
          log("The active indicator was different for: " + template.getFullVersionString(), Project.MSG_DEBUG);
          rs.updateString(IND_ACTIVE, template.getIndActive());
        }
        if (rowUpdated) {
          log("Updating: " + template.getFullVersionString(), Project.MSG_INFO);
          rs.updateRow();
        } else {
          log("Skipping: " + template.getFullVersionString(), Project.MSG_VERBOSE);
        }
      }
      // Check for insertions and add them
      if (!filenameTemplateMap.isEmpty()) {
        for (Iterator<String> it = filenameTemplateMap.keySet().iterator(); it.hasNext();) {
          rs.moveToInsertRow();
          String filename = it.next();
          Template template = filenameTemplateMap.get(filename);
          Type type = template.getType();
          // Set the primary id to 0 to let the trigger automatically update it.
          rs.updateInt(ID_DOCUMENT_TEMPLATE, 0);
          rs.updateInt(ID_DOCUMENT_TEMPLATE_TYPE, type.getId());
          rs.updateInt(NBR_MAJOR_VERSION, template.getMajorVersion());
          rs.updateInt(NBR_MINOR_VERSION, template.getMinorVersion());
          rs.updateInt(NBR_REVISION, template.getRevision());
          rs.updateString(TXT_VERSION_STRING, template.getFullVersionString());
          rs.updateString(TXT_SHORT_DESCRIPTION, template.getShortDesc());
          rs.updateString(TXT_LONG_DESCRIPTION, template.getLongDesc());
          rs.updateString(IND_ACTIVE, template.getIndActive());
          byte[] txtHtmlBytes = getTemplateFileBytes(template);
          rs.updateBinaryStream(TXT_HTML, new ByteArrayInputStream(txtHtmlBytes), txtHtmlBytes.length);
          log("Inserting row for: " + template.getFullVersionString(), Project.MSG_INFO);
          rs.insertRow();
        }
      }
    } finally {
      cleanup(rs);
      cleanup(stmt);
    }
  }

  private byte[] getTemplateFileBytes(Template template) throws IOException {
    String templateFilename = getTemplateFilename(template);
    File templateFile = new File(templateDir, templateFilename);
    if (!templateFile.isFile()) {
      throw new BuildException("Template file not found: " + templateFile.getAbsolutePath());
    }
    // Check to see if the BLOB is identitcal to the file.
    long templateFileLength = templateFile.length();
    if ((2L * templateFileLength) > (long) Integer.MAX_VALUE) {
      throw new IndexOutOfBoundsException("Document template file size is too large: " + templateFileLength + " bytes");
    }
    byte[] templateFileBytes = new byte[2 * (int) templateFileLength];
    BufferedInputStream bis = null;
    int counter = 0;
    int previous = 0;
    try {
      FileInputStream is = new FileInputStream(templateFile);
      bis = new BufferedInputStream(is, (int) templateFileLength);
      int current;
      while ((current = bis.read()) > 0) {
        if (previous != (int) '\r') {
          if (current == (int) '\n') {
            templateFileBytes[counter++] = (byte) '\r';
          }
        }
        templateFileBytes[counter++] = (byte) current;
        previous = current;
      }
    } finally {
      if (bis != null) {
        bis.close();
      }
    }
    byte[] transformedTemplateFileBytes = new byte[counter];
    System.arraycopy(templateFileBytes, 0, transformedTemplateFileBytes, 0, counter);
    return transformedTemplateFileBytes;
  }

  private Map<Integer, Type> updateDocumentTemplateTypes(Map<String, Type> nmDocumentTypeMap, Connection conn,
                                                         String schema)
          throws SQLException {
    // First, run through the list of types, update descriptions, and cache ids.
    PreparedStatement updateStmt = null;
    PreparedStatement selectStmt = null;
    ResultSet updateRS = null;
    ResultSet selectRS = null;
    // Make a copy of the input map so we can modify it without modifying the passed in verison.
    Map<String, Type> localNmDocumentTypeMap = new HashMap<String, Type>(nmDocumentTypeMap.size());
    localNmDocumentTypeMap.putAll(nmDocumentTypeMap);
    try {
      String sql = DEFAULT_SCHEMA_PATTERN.matcher(SELECT_DOCUMENT_TEMPLATE_TYPE_SQL).replaceAll(schema + ".");
      updateStmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
      updateRS = updateStmt.executeQuery();
      Map<Integer, Type> idTypeMap = new HashMap<Integer, Type>(nmDocumentTypeMap.size());
      while (updateRS.next()) {
        int idDocumentTemplateType = updateRS.getInt(ID_DOCUMENT_TEMPLATE_TYPE);
        String txtName = updateRS.getString(TXT_NAME);
        String nmDocument = updateRS.getString(NM_DOCUMENT);
        Type type = localNmDocumentTypeMap.remove(nmDocument);
        if (type == null) {
          log("Ignoring type '" + nmDocument + "' becuase no metadata found.");
          continue;
        }
        type.setId(idDocumentTemplateType);
        idTypeMap.put(idDocumentTemplateType, type);
        if (txtName == null || !txtName.equals(type.getName())) {
          updateRS.updateString(TXT_NAME, type.getName());
          log("Updating row for: " + nmDocument, Project.MSG_INFO);
          updateRS.updateRow();
        }
        idTypeMap.put(idDocumentTemplateType, type);
      }
      // Add types not in the DB right now
      if (!localNmDocumentTypeMap.isEmpty()) {
        for (Iterator<Type> it = localNmDocumentTypeMap.values().iterator(); it.hasNext();) {
          updateRS.moveToInsertRow();
          Type type = it.next();
          // Set the ID to 0 to force the trigger to update it.
          int idDocumentTemplateType = getNextInSequence(SEQ_DOCUMENT_TEMPLATE_TYPE, conn);
          log("id_document_template_type: " + idDocumentTemplateType, Project.MSG_DEBUG);
          updateRS.updateInt(ID_DOCUMENT_TEMPLATE_TYPE, idDocumentTemplateType);
          log("txt_name: " + type.getName(), Project.MSG_DEBUG);
          updateRS.updateString(TXT_NAME, type.getName());
          log("nm_document: " + idDocumentTemplateType, Project.MSG_DEBUG);
          updateRS.updateString(NM_DOCUMENT, type.getNmDocument());
          log("Inserting row for: " + type.getNmDocument(), Project.MSG_INFO);
          updateRS.insertRow();
          type.setId(idDocumentTemplateType);
          idTypeMap.put(idDocumentTemplateType, type);
        }
      }
      return idTypeMap;
    } finally {
      cleanup(selectRS);
      cleanup(selectStmt);
      cleanup(updateRS);
      cleanup(updateStmt);
    }
  }

  private int getNextInSequence(String sequenceName, Connection conn) throws SQLException {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = conn.prepareStatement("SELECT " + sequenceName + ".nextval FROM dual");
      rs = stmt.executeQuery();
      if (!rs.next()) {
        throw new IllegalStateException("Failed to retrieve sequence value for sequence: " + sequenceName);
      }
      return rs.getInt(1);
    } finally {
      cleanup(rs);
      cleanup(stmt);
    }
  }

  private void cleanup(PreparedStatement stmt) {
    if (stmt != null) {
      try {
        stmt.close();
      } catch (SQLException e) {
        log("Failed to close DB statement.", Project.MSG_WARN);
      }
    }
  }

  private void cleanup(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        log("Failed to close DB result set.", Project.MSG_WARN);
      }
    }
  }

  private void parseXmlMetaData(Map<String, Type> nmDocumentTypeMap, Map<String, Template> filenameTemplateMap)
          throws BuildException {
    try {
      SAXReader reader = new SAXReader(true);
      Document document = reader.read(metadata);
      Element root = document.getRootElement();
      for (Iterator it = root.elementIterator("type"); it.hasNext();) {
        Element type = (Element) it.next();
        String id = type.attributeValue("id");
        nmDocumentTypeMap.put(id, new Type(id, type.attributeValue("name")));
      }
      for (Iterator it = root.elementIterator("template"); it.hasNext();) {
        Element templateElement = (Element) it.next();
        Type type = nmDocumentTypeMap.get(templateElement.attributeValue("type"));
        Template template = new Template(type,
                                         templateElement.attributeValue("version"),
                                         Integer.valueOf(templateElement.attributeValue("major")),
                                         Integer.valueOf(templateElement.attributeValue("minor")),
                                         Integer.valueOf(templateElement.attributeValue("revision")),
                                         Boolean.valueOf(templateElement.attributeValue("active")));
        // Do this check here so we can get the full version string generated easily.
        if (type == null) {
          throw new BuildException("Invalid type found for: " + template.getFullVersionString());
        }
        Element shortDescriptionElement = templateElement.element("shortDescription");
        if (shortDescriptionElement != null) {
          template.setShortDesc(shortDescriptionElement.getTextTrim());
        }
        Element longDescriptionElement = templateElement.element("longDescription");
        if (longDescriptionElement != null) {
          template.setLongDesc(longDescriptionElement.getTextTrim());
        }
        filenameTemplateMap.put(getTemplateFilename(template), template);
      }
    } catch (DocumentException e) {
      throw new BuildException("Document metatdata file: " + metadata.getAbsolutePath(), e);
    }
  }

  private static String getTemplateFilename(Template template) {
    return getTemplateFilename(template.getType().getNmDocument(), template.getMajorVersion(),
                               template.getMinorVersion(), template.getRevision());
  }

  private static String getTemplateFilename(String name, int major, int minor, int revision) {
    return name + "-" + major + "." + minor + "." + revision + TEMPLATE_EXTENSION;
  }

  private static class Type {
    int id;
    String nmDocument;
    String name;

    public Type(String name, String description) {
      this.nmDocument = name;
      this.name = description;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getNmDocument() {
      return nmDocument;
    }

    public String getName() {
      return name;
    }
  }

  private static class Template {

    private Type type;
    private String versionString;
    private int majorVersion;
    private int minorVersion;
    private int revision;
    private boolean active;
    private String longDesc;
    private String shortDesc;

    public Template(Type type, String name, int major, int minor, int revision, boolean active) {
      this.type = type;
      this.versionString = name;
      this.majorVersion = major;
      this.minorVersion = minor;
      this.revision = revision;
      this.active = active;
    }

    public Type getType() {
      return type;
    }

    public String getVersionString() {
      return versionString;
    }

    private String getFullVersionString() {
      return getVersionString() + " " + getMajorVersion() + "." + getMinorVersion() + "." + getRevision();
    }

    public int getMajorVersion() {
      return majorVersion;
    }

    public int getMinorVersion() {
      return minorVersion;
    }

    public int getRevision() {
      return revision;
    }

    public String getIndActive() {
      // The ind_active column uses 1 for true and 0 for false.
      return active ? "1" : "0";
    }

    public void setLongDesc(String longDesc) {
      this.longDesc = longDesc;
    }

    public String getLongDesc() {
      return longDesc;
    }

    public void setShortDesc(String shortDesc) {
      this.shortDesc = shortDesc;
    }

    public String getShortDesc() {
      return shortDesc;
    }
  }
}
