package gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

/** This class is used to record information about an exception and the application state when it occurred. */
public class ImpactExceptionLogRecord extends LogRecord {
  // Store information about the request in LinkedLists with subtypes of AbstractNameValueXMLPair
  private final List<NameValuesXMLPair> requestHeaders = new LinkedList<NameValuesXMLPair>();
  private final List<NameValuesXMLPair> requestParameters = new LinkedList<NameValuesXMLPair>();
  private final List<NameValueXMLPair> requestAttributes = new LinkedList<NameValueXMLPair>();
  private final List<NameValueXMLPair> stateAttributes = new LinkedList<NameValueXMLPair>();
  private final List<NameValueXMLPair> globalData = new LinkedList<NameValueXMLPair>();
  private final List<NameValueXMLPair> stateContextParameters = new LinkedList<NameValueXMLPair>();
  private final List<NameValueXMLPair> sessionAttributes = new LinkedList<NameValueXMLPair>();

  // Store the user and throwable objects raw becuase they are guaranteed to be serializable
  private UserProfile user = null;
  private String sourceFileName = null;
  private int sourceLineNumber = 0;
  private boolean isWritten = false;

  // Store the ID_ERROR associated with this record after it is written to the DB
  private int idError = 0;

  /**
   * The only constructor has protected visibility because, generally, only classes in this package should use it.
   *
   * @param level
   * @param msg
   */
  protected ImpactExceptionLogRecord(Level level, String msg) {
    super(level, msg);
  }

  public UserProfile getUser() {
    return user;
  }

  protected void setUser(UserProfile user) {
    this.user = user;
  }

  public int getSourceLineNumber() {
    return sourceLineNumber;
  }

  public void setSourceLineNumber(int sourceLineNumber) {
    this.sourceLineNumber = sourceLineNumber;
  }

  public String getSourceFileName() {
    return sourceFileName;
  }

  public void setSourceFileName(String sourceFileName) {
    this.sourceFileName = sourceFileName;
  }

  public int getIdError() {
    return idError;
  }

  public void setIdError(int idError) {
    this.idError = idError;
  }

  public boolean isWritten() {
    return isWritten;
  }

  public void setWritten(boolean written) {
    isWritten = written;
  }

  public Object[] getParameters() {
    Object[] parameters;
    try {
      // 14 is twice the number of sections; this gives us enough room to add section open and close tags
      int parametersSize = 14 + requestHeaders.size() + requestParameters.size() + requestAttributes.size()
                           + stateAttributes.size() + globalData.size() + stateContextParameters.size() +
                           sessionAttributes.size();
      parameters = new Object[parametersSize];
      int i = 0;
      parameters[i++] = "<request_headers>";
      for (Iterator iterator = requestHeaders.iterator(); iterator.hasNext();) {
        NameValuesXMLPair nameValuesXMLPair = (NameValuesXMLPair) iterator.next();
        parameters[i++] = nameValuesXMLPair.toString();
      }
      parameters[i++] = "</request_headers>";
      parameters[i++] = "<request_parameters>";
      for (Iterator iterator = requestParameters.iterator(); iterator.hasNext();) {
        NameValuesXMLPair nameValuesXMLPair = (NameValuesXMLPair) iterator.next();
        parameters[i++] = nameValuesXMLPair.toString();
      }
      parameters[i++] = "</request_parameters>";
      parameters[i++] = "<request_attributes>";
      for (Iterator iterator = requestAttributes.iterator(); iterator.hasNext();) {
        NameValueXMLPair nameValueXMLPair = (NameValueXMLPair) iterator.next();
        parameters[i++] = nameValueXMLPair.toString();
      }
      parameters[i++] = "</request_attributes>";
      parameters[i++] = "<state_attributes>";
      for (Iterator iterator = stateAttributes.iterator(); iterator.hasNext();) {
        NameValueXMLPair nameValueXMLPair = (NameValueXMLPair) iterator.next();
        parameters[i++] = nameValueXMLPair.toString();
      }
      parameters[i++] = "</state_attributes>";
      parameters[i++] = "<global_data>";
      for (Iterator iterator = globalData.iterator(); iterator.hasNext();) {
        NameValueXMLPair nameValueXMLPair = (NameValueXMLPair) iterator.next();
        parameters[i++] = nameValueXMLPair.toString();
      }
      parameters[i++] = "</global_data>";
      parameters[i++] = "<state_context_parameters>";
      for (Iterator iterator = stateContextParameters.iterator(); iterator.hasNext();) {
        NameValueXMLPair nameValueXMLPair = (NameValueXMLPair) iterator.next();
        parameters[i++] = nameValueXMLPair.toString();
      }
      parameters[i++] = "</state_context_parameters>";
      parameters[i++] = "<session_attributes>";
      for (Iterator iterator = sessionAttributes.iterator(); iterator.hasNext();) {
        NameValueXMLPair nameValueXMLPair = (NameValueXMLPair) iterator.next();
        parameters[i++] = nameValueXMLPair.toString();
      }
      parameters[i] = "</session_attributes>";
    }
    catch (Throwable throwable) {
      parameters = new Object[] {"<error name=\"getParameters\" message=\"" + throwable.getMessage() + "\"/>"};
    }
    return parameters;
  }

  public void setParameters(Object[] parameters) {
    throw new UnsupportedOperationException(
            "Please use the methods beginning with add* to add the appropriate parameters.");
  }

  protected void addRequestHeader(String name, Enumeration values) {
    try {
      this.requestHeaders.add(new NameValuesXMLPair("request_header", name, values));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  protected void addRequestParameter(String name, String[] values) {
    try {
      this.requestParameters.add(new NameValuesXMLPair("request_parameter", name, values));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  protected void addRequestAttribute(String name, Object value) {
    try {
      this.requestAttributes.add(new NameValueXMLPair("request_attribute", name, value));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  protected void addStateAttribute(String name, Object value) {
    try {
      this.stateAttributes.add(new NameValueXMLPair("state_attribute", name, value));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  protected void addGlobalData(String name, Object value) {
    try {
      this.globalData.add(new NameValueXMLPair("global_data", name, value));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  protected void addStateContextParameter(String name, Object value) {
    try {
      this.stateContextParameters.add(new NameValueXMLPair("state_context_parameter", name, value));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  protected void addSessionAttribute(String name, Object value) {
    try {
      this.sessionAttributes.add(new NameValueXMLPair("session_attribute", name, value));
    }
    catch (Throwable throwable) {
      // do nothing; we just NEVER want to throw an exception here
    }
  }

  // An abstract super class that has utilties for encoding pairs in XML
  private abstract static class AbstractXMLPair implements Serializable {
    public AbstractXMLPair() {
      // to support serializatoin
    }

    protected AbstractXMLPair(String tagName, String name) {
      if (tagName == null || name == null) {
        throw new IllegalArgumentException("None of the parameters may be null.");
      }
      setTagName(tagName);
      setName(name);
    }

    public String getPairType() {
      return pairType;
    }

    protected void setTagName(String pairType) {
      this.pairType = pairType;
    }

    public String getName() {
      return name;
    }

    protected void setName(String name) {
      this.name = name;
    }

    public String toString() {
      try {
        String pairType = getPairType();
        String name = getName();
        // Guess a good buffer size
        StringBuilder sb = new StringBuilder(28 + (2 * (pairType.length() + name.length())) + 100);
        sb.append("<").append(pairType).append(" name=\"");
        ImpactExceptionLoggingUtility.encodeForXml(name, sb);
        sb.append("\">");
        writeValueXML(sb);
        sb.append("</").append(pairType).append(">");
        return sb.toString();
      }
      catch (Throwable throwable) {
        return "<error type=\"" + getPairType() + "\""
               + "name=\"" + getName() + "\""
               + "message=\"" + throwable.getMessage() + "\"/>";
      }
    }

    protected abstract StringBuilder writeValueXML(StringBuilder sb);

    private String pairType = "NO_TAG_NAME_SET";
    private String name = null;
  }

  // An inner class used to store pairs that have one value for each key
  private static class NameValueXMLPair extends AbstractXMLPair {
    public NameValueXMLPair() {
      // to support serialization
    }

    public NameValueXMLPair(String tagName, String name, Object value) {
      super(tagName, name);
      setValue(value);
    }

    public Object getValue() {
      return value;
    }

    public void setValue(Object value) {
      //noinspection AssignmentToNull
      this.value = value != null ? value.toString() : null;
    }

    public void setValue(XmlValueBean xmlValueBean) {
      this.value = xmlValueBean;
    }

    protected StringBuilder writeValueXML(StringBuilder sb) {
      sb.append("<value>");
      Object value = getValue();
      if (value instanceof XmlValueBean) {
        sb.append(value.toString());
      } else {
        ImpactExceptionLoggingUtility.encodeForXml(String.valueOf(value), sb);
      }
      sb.append("</value>");
      return sb;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      // We have to call defaultWriteObject first.
      out.defaultWriteObject();
      out.writeObject(value != null ? value.toString() : null);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      // We have to call defaultReadObject first.
      in.defaultReadObject();
      value = in.readObject();
    }

    transient Object value = null;
  }

  // An inner class used to store pairs that can have multiple values
  private static class NameValuesXMLPair extends AbstractXMLPair {
    public NameValuesXMLPair() {
      // to support serialization
    }

    private NameValuesXMLPair(String tagName, String name, Enumeration values) {
      super(tagName, name);
      if (values == null) {
        throw new IllegalArgumentException("None of the parameters may be null.");
      }
      setValues(values);
    }

    public NameValuesXMLPair(String tagName, String name, String[] values) {
      super(tagName, name);
      if (values == null) {
        throw new IllegalArgumentException("None of the parameters may be null.");
      }
      setValues(values);
    }

    protected String[] enumerationToArray(Enumeration enumeration) {
      List<String> valueList = new LinkedList<String>();
      while (enumeration.hasMoreElements()) {
        String value = (String) enumeration.nextElement();
        valueList.add(value);
      }
      return valueList.toArray(new String[valueList.size()]);
    }

    protected StringBuilder writeValueXML(StringBuilder sb) {
      String[] values = getValues();
      int valuesLength = values.length;
      for (int i = 0; i < valuesLength; i++) {
        String value = values[i];
        sb.append("<value>");
        ImpactExceptionLoggingUtility.encodeForXml(value, sb);
        sb.append("</value>");
      }
      return sb;
    }

    public String[] getValues() {
      return values;
    }

    protected void setValues(String[] values) {
      this.values = values;
    }

    protected void setValues(Enumeration valuesEnumeration) {
      this.values = enumerationToArray(valuesEnumeration);
    }

    private String[] values = null;
  }
}
