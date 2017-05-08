package gov.georgia.dhr.dfcs.sacwis.dao.document;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType;

public class DocumentInsertDao extends BaseDao {

  private static final String TRACE_TAG = "DocumentInsertDao";

  public DocumentInsertDao(Connection connection) {
    super(connection);
  }

  public void insertDocument(DocumentMetaData documentMetaData, byte[] documentData)
          throws DuplicateRecordException, NoRowsUpdatedException, SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".insertDocument");
    GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
    Connection connection = super.getConnection();
    String sql = this.getSql(documentMetaData);
    PreparedStatement saveQuery = null;
    try {
      GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");
      saveQuery = this.createPreparedStatement(documentMetaData, sql, documentData, connection);
      int x = executeUpdate(saveQuery);
      GrndsTrace.msg(TRACE_TAG, 7, "Number of rows affected:" + String.valueOf(x));
    } catch (DuplicateRecordException de) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_DUPLICATE_DOCS);
      throw new DuplicateRecordException(message, de);
    } catch (NoRowsUpdatedException ne) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_TIMESTAMP_MISMATCH);
      throw new DuplicateRecordException(message, ne);
    } finally {
      cleanup(saveQuery);
      GrndsTrace.exitScope();
    }

  }

  private String getSql(DocumentMetaData documentMetaData) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO ");
    sql.append(documentMetaData.getTableMetaData().getTableName());

    sql.append(" (");
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      if (!"DT_LAST_UPDATE".equals(column.getName().toUpperCase())) {
        sql.append(column.getName());
        sql.append(", ");
      }
    }

    if (documentMetaData.getLegacy() == false) {
      sql.append("ID_DOCUMENT_TEMPLATE, ");
    }

    sql.append(documentMetaData.getTableMetaData().getNarrativeColumn());
    sql.append(")");
    sql.append(" values (");

    // construct the query parameters
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      if (!"DT_LAST_UPDATE".equals(column.getName().toUpperCase())) {
        sql.append("?, ");
      }
    }

    if (documentMetaData.getLegacy() == false) {
      sql.append("?, ");
    }

    sql.append("?)");

    GrndsTrace.msg(TRACE_TAG, 7, "Insert SQL: " + sql.toString());
    GrndsTrace.exitScope();
    return sql.toString();
  }

  private PreparedStatement createPreparedStatement(DocumentMetaData documentMetaData, String sql, byte[] documentData,
                                                    Connection connection)
          throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".createPreparedStatement");

    PreparedStatement saveQuery = connection.prepareStatement(sql);
    int tempCounter = 0;
    GrndsTrace.msg(TRACE_TAG, 7, "Setting the variables in prepared statement");
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      if (!"DT_LAST_UPDATE".equals(column.getName().toUpperCase())) {
        tempCounter += 1;

        GrndsTrace.msg(TRACE_TAG, 7, "column type to string:" + column.getType().getType());
        GrndsTrace.msg(TRACE_TAG, 7, "Number type to string:" + ColumnType.NUMBER.getType());
        if (column.getType().getType() == ColumnType.NUMBER.getType()) {
          Integer tempInteger = new Integer(column.getContent());
          setInt(tempCounter, tempInteger, saveQuery);
          GrndsTrace.msg(TRACE_TAG, 7, "bind variable:" + tempCounter);
          GrndsTrace.msg(TRACE_TAG, 7, "Setting value:" + column.getContent());
        } else if (column.getType().getType() == ColumnType.TEXT.getType()) {
          setString(tempCounter, column.getContent(), saveQuery);
          GrndsTrace.msg(TRACE_TAG, 7, "bind variable:" + tempCounter);
          GrndsTrace.msg(TRACE_TAG, 7, "Setting value:" + column.getContent());
        } else {
          GrndsTrace.msg(TRACE_TAG, 7, "Bind variable not set");
        }

      }
    }

    if (documentMetaData.getLegacy() == false) {
      tempCounter += 1;
      Integer tempInteger = documentMetaData.getActualTemplateVersion();
      GrndsTrace.msg(TRACE_TAG, 7, "bind variable:" + tempCounter);
      GrndsTrace.msg(TRACE_TAG, 7, "Setting template id:" + documentMetaData.getActualTemplateVersion());
      setInt(tempCounter, tempInteger, saveQuery);
    }

    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(documentData);
    //noinspection IOResourceOpenedButNotSafelyClosed
    BufferedInputStream buffInputStream = new BufferedInputStream(byteArrayInputStream);
    tempCounter += 1;
    GrndsTrace.msg(TRACE_TAG, 7, "bind variable:" + tempCounter);
    saveQuery.setBinaryStream(tempCounter, buffInputStream, documentData.length);
    GrndsTrace.exitScope();
    return saveQuery;
  }
}
