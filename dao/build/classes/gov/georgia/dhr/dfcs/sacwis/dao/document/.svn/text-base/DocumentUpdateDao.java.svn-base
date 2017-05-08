package gov.georgia.dhr.dfcs.sacwis.dao.document;

// -- java classes --

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentUpdateDao extends BaseDao {

  public DocumentUpdateDao(Connection connection) {
    super(connection);
  }

  public void updateDocument(DocumentMetaData documentMetaData,
                             byte[] documentData) throws
                                                  DuplicateRecordException, NoRowsUpdatedException,
                                                  SQLException {

    GrndsTrace.enterScope(TRACE_TAG + ".updateDocument");
    //Initialize variables for the calling the sql
    PreparedStatement saveQuery = null;
    GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
    Connection connection = super.getConnection();
    String sql = this.getSql(documentMetaData);
    saveQuery = this.createPreparedStatement(documentMetaData, sql, documentData, connection);

    GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");
    try {
      int x = super.executeUpdate(saveQuery);
      GrndsTrace.msg(TRACE_TAG, 7, "Number of rows affected:" + String.valueOf(x));
    }
    catch (DuplicateRecordException de) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_DUPLICATE_DOCS);
      throw new DuplicateRecordException(message, de);
    }
    catch (NoRowsUpdatedException ne) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_TIMESTAMP_MISMATCH);
      throw new DuplicateRecordException(message, ne);
    }
    finally {
      cleanup(saveQuery);
    }
  }

  private String getSql(DocumentMetaData documentMetaData) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("UPDATE ");
    sql.append(documentMetaData.getTableMetaData().getTableName());
    sql.append(" SET ");
    sql.append(documentMetaData.getTableMetaData().getNarrativeColumn());
    sql.append(" = ? , ID_DOCUMENT_TEMPLATE = ? WHERE ");

    int y = 0;
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);

      if (y != 0) {
        sql.append(" AND ");
      }
      sql.append(column.getName());
      String tempName = column.getName().toUpperCase();
      sql.append(" = ? ");
      y = y + 1;
      /*if( tempName.equals( "DT_LAST_UPDATE" ) )
      {
        if( column.getFormat() != null )
        {
          sql.append( " = to_date( ? , '" );
          sql.append( column.getFormat() );
          sql.append( "')" );
        }
        else
        {
          sql.append( " = to_date( ? ,'MM/DD/YYYY HH24:MI:SS')" );
        }
      }
      else
      {
        sql.append( " = ? " );
      }
      */

    }

    GrndsTrace.msg(TRACE_TAG, 7, "Update SQL: " + sql.toString());
    GrndsTrace.exitScope();
    return sql.toString();
  }

  private PreparedStatement createPreparedStatement(DocumentMetaData documentMetaData,
                                                    String sql, byte[] documentData,
                                                    Connection connection) throws
                                                                           SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".createPreparedStatement");

    PreparedStatement saveQuery = null;
    saveQuery = connection.prepareStatement(sql);

    int tempCounter = 0;

    ByteArrayInputStream byteInput = new ByteArrayInputStream(documentData);
    BufferedInputStream buffInput = new BufferedInputStream(byteInput);

    tempCounter = tempCounter + 1;
    GrndsTrace.msg(TRACE_TAG, 7, "number of bind var:" + tempCounter);
//    saveQuery.setBytes(tempCounter, byteStream.toByteArray());

    saveQuery.setBinaryStream(tempCounter, buffInput, documentData.length);
    tempCounter = tempCounter + 1;

    if (documentMetaData.getLegacy()) {
      GrndsTrace.msg(TRACE_TAG, 7, "Document is legacy");
      super.setString(tempCounter, null, saveQuery);
    } else {
      GrndsTrace.msg(TRACE_TAG, 7, "Document is not legacy");
      Integer tempInteger = documentMetaData.getActualTemplateVersion();
      super.setInt(tempCounter, tempInteger, saveQuery);

    }
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      tempCounter = tempCounter + 1;
      GrndsTrace.msg(TRACE_TAG, 7, "Testing type of column");

      if (column.getType().getType() == ColumnType.NUMBER.getType()) {
        GrndsTrace.msg(TRACE_TAG, 7, "number of bind var:" + tempCounter);
        GrndsTrace.msg(TRACE_TAG, 7, "Setting number in prepared statement");
        Integer tempInteger = new Integer(column.getContent());
        GrndsTrace.msg(TRACE_TAG, 7, "value of bind var:" + tempInteger);
        super.setInt(tempCounter, tempInteger, saveQuery);
      } else if (column.getType().getType() == ColumnType.DATE.getType()) {
        try {
          Timestamp tempDate = new Timestamp(DateHelper.toJavaDate(column.getContent(),
                                                                   DateHelper.SQL_DATE_FORMAT).getTime());
          super.setTimestamp(tempCounter, tempDate, saveQuery);
        }
        catch (Exception ex) {
          throw new RuntimeWrappedException(ex);
        }
      } else {
        super.setString(tempCounter, column.getContent(), saveQuery);
      }

    }
    GrndsTrace.exitScope();
    return saveQuery;
  }

  private static final String TRACE_TAG = "DocumentUpdateDao";
}
