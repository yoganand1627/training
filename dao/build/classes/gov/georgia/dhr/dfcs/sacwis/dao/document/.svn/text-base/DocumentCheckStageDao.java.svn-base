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
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentCheckStageDao extends BaseDao {

  public DocumentCheckStageDao(Connection connection) {
    super(connection);
  }

  public void checkStage(DocumentMetaData documentMetaData) throws
                                                            DocumentStageNotFoundException,
                                                            DocumentStageClosedException, SQLException {

    GrndsTrace.enterScope(TRACE_TAG + ".checkStage");

    //Initialize variables for the calling the sql
    PreparedStatement selectQuery = null;

    GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
    ResultSet resultSet = null;
    Connection connection = super.getConnection();
    String sql = this.getSql();
    selectQuery = this.createPreparedStatement(documentMetaData, sql, connection);

    GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");
    resultSet = selectQuery.executeQuery();

    // Determine if stage was closed
    int y = 0;
    while (resultSet.next()) {
      String dateStageClosed = null;
      String indStageClosed = null;

      GrndsTrace.msg(TRACE_TAG, 7, "Getting values from resultset");
      dateStageClosed = resultSet.getString("DT_STAGE_CLOSE");
      indStageClosed = resultSet.getString("IND_STAGE_CLOSE");
      GrndsTrace.msg(TRACE_TAG, 7, "Checking values");
      if ("Y".equals(indStageClosed)) {
        String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_STAGE_CLOSED);
        throw new DocumentStageClosedException(message);
      }
      y = y + 1;
    }

    if (y == 0) {
      //String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_INVALID_STATUS);
      String message = "The document did not save.  The stage that contains the document could not be found.";
      throw new DocumentStageNotFoundException("The specified stage could not be found:" + String.valueOf(
              documentMetaData.getCheckStage()));
    }

    cleanup(selectQuery);
    GrndsTrace.exitScope();

  }

  private String getSql() {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT DT_STAGE_CLOSE, IND_STAGE_CLOSE FROM STAGE WHERE ID_STAGE = ?");
    GrndsTrace.exitScope();
    return sql.toString();
  }

  private PreparedStatement createPreparedStatement(DocumentMetaData documentMetaData, String sql,
                                                    Connection connection) {
    GrndsTrace.enterScope(TRACE_TAG + ".createPreparedStatement");

    PreparedStatement selectQuery = null;
    try {
      selectQuery = connection.prepareStatement(sql);
      Integer tempInt = documentMetaData.getCheckStage();
      super.setInt(1, tempInt, selectQuery);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Unknown Exception:" + e.getMessage());
    }
    GrndsTrace.exitScope();
    return selectQuery;
  }

  private static final String TRACE_TAG = "DocumentCheckStageDao";
}













