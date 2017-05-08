package gov.georgia.dhr.dfcs.sacwis.dao.document;

// -- java classes --

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.DuplicateRecordException;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoRowsUpdatedException;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType;

/**
 * Dao used to delete documents from narrative tables.
 *
 * @author Stephen Roberts
 *         <p/>
 *         <pre>
 *                 Change History:
 *         <p/>
 *                 Date      User         Description
 *                 -------   ---------    -----------------------------------------------
 *                 7/22/05   ROBERTSW     SIR 23728 - As part of enabling contacts on MPS a
 *                                        method to delete contacts was added.
 *         <p/>
 *                 </pre>
 */

public class DocumentDeleteDao extends BaseDao {

  public DocumentDeleteDao(Connection connection) {
    super(connection);
  }

  public void deleteDocument(DocumentMetaData documentMetaData) throws
                                                                DuplicateRecordException, NoRowsUpdatedException,
                                                                SQLException {

    GrndsTrace.enterScope(TRACE_TAG + ".deleteDocument");
    //Initialize variables for the calling the sql
    PreparedStatement deleteQuery;
    GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
    Connection connection = super.getConnection();
    String sql = this.getSql(documentMetaData);

    deleteQuery = this.createPreparedStatement(documentMetaData, sql, connection);

    GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");
    try {
      int x = executeUpdate(deleteQuery);
      GrndsTrace.msg(TRACE_TAG, 7, "Number of rows affected:" + String.valueOf(x));
    }
    catch (DuplicateRecordException de) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_DUPLICATE_DOCS);
      throw new DuplicateRecordException(message, de);
    }
    catch (NoRowsUpdatedException ne) {
      String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_TIMESTAMP_MISMATCH);
      throw new NoRowsUpdatedException(message, ne);
    }
    finally {
      cleanup(deleteQuery);
    }
  }

  private String getSql(DocumentMetaData documentMetaData) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("DELETE FROM ");
    sql.append(documentMetaData.getTableMetaData().getTableName());
    sql.append(" WHERE ");

    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);

      if (x != 0) {
        sql.append(" AND ");
      }
      sql.append(column.getName());
      String tempName = column.getName().toUpperCase();
      if ("DT_LAST_UPDATE".equals(tempName)) {
        if (column.getFormat() != null) {
          sql.append(" = to_date( ? , '");
          sql.append(column.getFormat());
          sql.append("')");
        } else {
          sql.append(" = to_date( ? ,'MM/DD/YYYY HH24:MI:SS')");
        }
      } else {
        sql.append(" = ? ");
      }
    }

    GrndsTrace.msg(TRACE_TAG, 7, "Delete SQL: " + sql.toString());
    GrndsTrace.exitScope();
    return sql.toString();
  }

  private PreparedStatement createPreparedStatement(DocumentMetaData documentMetaData,
                                                    String sql, Connection connection)
          throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".createPreparedStatement");

    PreparedStatement deleteQuery;
    deleteQuery = connection.prepareStatement(sql);

    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      GrndsTrace.msg(TRACE_TAG, 7, "Testing type of column");

      GrndsTrace.msg(TRACE_TAG, 7, "number of bind var:" + x);
      GrndsTrace.msg(TRACE_TAG, 7, "value of bind var:" + column.getContent());
      if (column.getType().getType() == ColumnType.NUMBER.getType()) {
        GrndsTrace.msg(TRACE_TAG, 7, "Setting number in prepared statement");
        Integer tempInteger = new Integer(column.getContent());
        GrndsTrace.msg(TRACE_TAG, 7, "value of temp Integer" + tempInteger);
        setInt(x + 1, tempInteger, deleteQuery);
      } else {
        setString(x + 1, column.getContent(), deleteQuery);
      }

    }
    GrndsTrace.exitScope();
    return deleteQuery;
  }

  /**
   * This method deletes the narrative on the CONTACT_NARRATIVE table without checking the timestamp.  It should only be
   * used on MPS b/c there is only one user on the application.  Using this method in IMPACT will throw an exception.
   *
   * @param eventId
   */
  public void deleteContactNarrative(int eventId) {
    PreparedStatement deleteQuery = null;
    Connection connection = super.getConnection();

    if (PlatformConstants.MOBILE_IMPACT) {
      try {
        deleteQuery = connection.prepareStatement(DELETE_CNCT_NARRATIVE_SQL);
        List<Object> list = new ArrayList<Object>();
        list.add(eventId);
        addBindVariablesToStatement(deleteQuery, list);
        deleteQuery.executeUpdate();
      }
      catch (SQLException se) {
        throw new RuntimeWrappedException(se);
      }
      finally {
        cleanup(deleteQuery);
      }
    } else {
      throw new IllegalStateException("Trying to delete contact narrative in IMPACT.");
    }

  }

  private static final String DELETE_CNCT_NARRATIVE_SQL = " DELETE FROM CONTACT_NARRATIVE \n " +
                                                          " WHERE ID_EVENT = ? ";

  private static final String TRACE_TAG = "DocumentDeleteDao";
}
