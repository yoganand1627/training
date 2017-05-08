package gov.georgia.dhr.dfcs.sacwis.dao.document;

// -- java classes --

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.StatusType;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentSaveCheckEventStatusDao extends BaseDao {

  public DocumentSaveCheckEventStatusDao(Connection connection) {
    super(connection);
  }

  public DocumentEventValueBean checkEventStatus(DocumentMetaData documentMetaData) throws
                                                                                    SQLException,
                                                                                    InvalidDocumentStatusException {
    GrndsTrace.enterScope(TRACE_TAG + ".checkEventStatus");

    //Initialize variables for the calling the sql
    PreparedStatement selectQuery = null;
    DocumentEventValueBean documentEventValueBean = null;
    GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
    ResultSet resultSet = null;
    Connection connection = super.getConnection();
    String sql = this.getSql();
    selectQuery = this.createPreparedStatement(documentMetaData, sql, connection);

    GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");
    resultSet = selectQuery.executeQuery();

    // Compare event status
    while (resultSet.next()) {

      // Get the status of the event
      GrndsTrace.msg(TRACE_TAG, 7, "Getting the value bean");
      documentEventValueBean = new DocumentEventValueBean(resultSet);
      String eventStatus = resultSet.getString("CD_EVENT_STATUS");
      if (eventStatus != null) {
        eventStatus = eventStatus.toUpperCase();

        boolean updateSafe = false;
        // For each valid status
        if (documentMetaData.getValidEventStatus() != null) {
          for (int x = 0; x < documentMetaData.getValidEventStatus().getValidStatusCount(); x++) {
            StatusType status = documentMetaData.getValidEventStatus().getValidStatus(x);
            String tempValidStatus = status.toString().toUpperCase();
            if (eventStatus.equals(tempValidStatus)) {
              //The status on the event is valid
              updateSafe = true;
              break;
            }
          }

          GrndsTrace.msg(TRACE_TAG, 7, "Testing updateSafe");
          if (updateSafe == false) {
            String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_INVALID_STATUS);
            throw new InvalidDocumentStatusException(message);
          }
        }
      }
    }

    cleanup(selectQuery);
    GrndsTrace.exitScope();

    return documentEventValueBean;
  }

  private String getSql() {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT ID_EVENT, ID_EVENT_STAGE, ID_CASE, ID_EVENT_PERSON, ");
    sql.append("CD_EVENT_TYPE, CD_TASK, TXT_EVENT_DESCR, CD_EVENT_STATUS, ");
    sql.append("DT_EVENT_OCCURRED, DT_LAST_UPDATE FROM EVENT WHERE ID_EVENT = ?");
    GrndsTrace.exitScope();
    return sql.toString();
  }

  private PreparedStatement createPreparedStatement(DocumentMetaData documentMetaData, String sql,
                                                    Connection connection) throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".createPreparedStatement");

    PreparedStatement selectQuery = null;

    selectQuery = connection.prepareStatement(sql);
    int tempCounter = 0;
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      String tempName = column.getName().toUpperCase();
      if ("ID_EVENT".equals(tempName)) {
        GrndsTrace.msg(TRACE_TAG, 7, "Value of id event:" + column.getContent() + ":");
        Integer tempInteger = new Integer(column.getContent());
        super.setInt(1, tempInteger, selectQuery);
      }
    }
    GrndsTrace.exitScope();
    return selectQuery;
  }

  private static final String TRACE_TAG = "DocumentSaveCheckEventStatusDao";
  public static final String EVENT_ID_COLUMN = "ID_EVENT";
  public static final String CASE_ID_COLUMN = "ID_CASE";
  public static final String STAGE_ID_COLUMN = "ID_EVENT_STAGE";
  public static final String PERSON_ID_COLUMN = "ID_EVENT_PERSON";
  public static final String TASK_CODE_COLUMN = "CD_TASK";
  public static final String EVENT_DESCRIPTION_COLUMN = "TXT_EVENT_DESCR";
  public static final String DATE_OCCURRED_COLUMN = "DT_EVENT_OCCURRED";
  public static final String DATE_LAST_UPDATE_COLUMN = "DT_LAST_UPDATE";
  public static final String EVENT_TYPE_COLUMN = "CD_EVENT_TYPE";
  public static final String EVENT_STATUS_COLUMN = "CD_EVENT_STATUS";

}