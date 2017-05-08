package gov.georgia.dhr.dfcs.sacwis.dao.document;

// -- java classes --

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentSelectDao extends BaseDao {

  public DocumentSelectDao(Connection connection) {
    super(connection);
  }

  public void selectDocument(DocumentMetaData documentMetaData) throws
                                                                NoDataReturnedException, TooManyRowsReturnedException,
                                                                SQLException, ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace("DocumentSelectDao", "selectDocument");
    performanceTrace.enterScope();

    //Initialize variables for the calling the sql
    PreparedStatement selectQuery = null;

    GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
    ResultSet resultSet = null;
    try {
      Connection connection = super.getConnection();
      String sql = this.getSql(documentMetaData);
      selectQuery = this.createPreparedStatement(documentMetaData, sql, connection);

      GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");

      resultSet = selectQuery.executeQuery();
      GrndsTrace.msg(TRACE_TAG, 7, "Finished Executing the statement");
      int y = 0;
      // Get the value of DT_LAST_UPDATE
      while (resultSet.next()) {
        y = y + 1;
        documentMetaData.setDocumentExists(true);
        // Set the new new time stamp
        for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
          Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
          String tempName = column.getName().toUpperCase();
          if ("DT_LAST_UPDATE".equals(tempName)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DASH_DATE_TIME_FORMAT);
            try {
              Date tempDate = sdf.parse(resultSet.getString("DT_LAST_UPDATE"));
              sdf = new SimpleDateFormat(SLASH_DATE_TIME_FORMAT);
              String dateString = sdf.format(tempDate);
              column.setContent(dateString);
            }
            catch (ParseException e) {
              sdf = new SimpleDateFormat(SLASH_DATE_TIME_FORMAT);
              Date tempDate = sdf.parse(resultSet.getString("DT_LAST_UPDATE"));
              String dateString = sdf.format(tempDate);
              column.setContent(dateString);
            }
          }
        }
      }

      if (y == 0) {
        //Throw the NoDataReturnedException
        String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_DATA_ACCESSOR_NARRATIVE_NOT_FOUND);
        throw new NoDataReturnedException(message);
      } else if (y > 1) {
        //Throw the TooManyRowsReturnedException
        String message = MessageLookup.getMessageByNumber(Messages.ARC_DOCS_ERR_DATA_ACCESSOR_MULTIPLE_DOCS);
        throw new TooManyRowsReturnedException(message);
      }
    }
    finally {
      cleanup(selectQuery);
    }
    performanceTrace.exitScope();
  }

  private String getSql(DocumentMetaData documentMetaData) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT DT_LAST_UPDATE FROM ");
    sql.append(documentMetaData.getTableMetaData().getTableName());
    sql.append(" WHERE ");
    //Get the table columns
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      String tempName = column.getName().toUpperCase();
      if (!"DT_LAST_UPDATE".equals(tempName)) {
        if (x != 0) {
          sql.append(" AND ");
        }
        sql.append(column.getName());
        sql.append(" = ?");
      }
    }

    GrndsTrace.exitScope();

    GrndsTrace.msg(TRACE_TAG, 7, "Query is:" + sql.toString());
    return sql.toString();
  }

  private PreparedStatement createPreparedStatement(DocumentMetaData documentMetaData,
                                                    String sql, Connection connection)
          throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".createPreparedStatement");
    PreparedStatement selectQuery = null;
    selectQuery = connection.prepareStatement(sql);
    int tempCounter = 1;
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      String tempName = column.getName().toUpperCase();
      if (!"DT_LAST_UPDATE".equals(tempName)) {
        if (column.getType().getType() == ColumnType.NUMBER.getType()) {
          Integer tempInteger = new Integer(column.getContent());
          super.setInt(tempCounter, tempInteger, selectQuery);
        } else if (column.getType().getType() == ColumnType.TEXT.getType()) {
          super.setString(tempCounter, column.getContent(), selectQuery);
        }
        tempCounter = tempCounter + 1;
        GrndsTrace.msg(TRACE_TAG, 7, "Bind Variable " + String.valueOf(tempCounter) + ": " + column.getContent());
      }
    }
    GrndsTrace.exitScope();
    return selectQuery;
  }

  private static final String TRACE_TAG = "DocumentSelectDao";
  private static final String DASH_DATE_TIME_FORMAT = "yyyy-M-d H:m:s.S";
  private static final String SLASH_DATE_TIME_FORMAT = "M/d/yyyy H:m:s";

}
