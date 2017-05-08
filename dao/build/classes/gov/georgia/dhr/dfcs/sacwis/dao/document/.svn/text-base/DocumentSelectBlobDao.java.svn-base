package gov.georgia.dhr.dfcs.sacwis.dao.document;

// -- java classes --

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.base.NoDataReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.ResultSetHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Column;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.ColumnType;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class DocumentSelectBlobDao extends BaseDao {

  public DocumentSelectBlobDao(Connection connection) {
    super(connection);
  }

  public NewUsingDocumentValueBean selectBlobDocument(DocumentMetaData documentMetaData) throws
                                                                                         NoDataReturnedException,
                                                                                         TooManyRowsReturnedException,
                                                                                         SQLException, IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".selectDocument");

    //Initialize variables for the calling the sql
    PreparedStatement selectQuery = null;
    NewUsingDocumentValueBean newUsingDocumentValueBean = new NewUsingDocumentValueBean();
    try {
      GrndsTrace.msg(TRACE_TAG, 7, "Creating the statement");
      ResultSet resultSet = null;
      Connection connection = super.getConnection();
      String sql = this.getSql(documentMetaData);
      selectQuery = this.createPreparedStatement(documentMetaData, sql, connection);

      GrndsTrace.msg(TRACE_TAG, 7, "Executing the statement");
      resultSet = selectQuery.executeQuery();
      int y = 0;

      while (resultSet.next()) {
        y = y + 1;
        // documentMetaData.setDocumentExists(true);
        newUsingDocumentValueBean.setDocumentData(resultSet.getBinaryStream(
                documentMetaData.getTableMetaData().getNarrativeColumn()));
        newUsingDocumentValueBean.setTemplateId(ResultSetHelper.getInt(resultSet, "ID_DOCUMENT_TEMPLATE"));
      }

      if (y == 0) {
        //Throw the NoDataReturnedException
        throw new NoDataReturnedException("No records found");
      } else if (y > 1) {
        //Throw the TooManyRowsReturnedException
        throw new TooManyRowsReturnedException("dlfjslkdfj");
      }
    }
    finally {
      cleanup(selectQuery);
      GrndsTrace.exitScope();
    }

    return newUsingDocumentValueBean;

  }

  private String getSql(DocumentMetaData documentMetaData) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSql");
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT ID_DOCUMENT_TEMPLATE, ");
    sql.append(documentMetaData.getTableMetaData().getNarrativeColumn());
    sql.append(" FROM ");
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
    GrndsTrace.msg(TRACE_TAG, 7, "Creating prepared statement");
    selectQuery = connection.prepareStatement(sql);

    GrndsTrace.msg(TRACE_TAG, 7, "Setting parameters");
    int tempCounter = 1;
    for (int x = 0; x < documentMetaData.getTableMetaData().getTableFields().getColumnCount(); x++) {
      Column column = documentMetaData.getTableMetaData().getTableFields().getColumn(x);
      GrndsTrace.msg(TRACE_TAG, 7, "column:" + column.getName());
      GrndsTrace.msg(TRACE_TAG, 7, "column content: " + column.getContent());
      String tempName = column.getName().toUpperCase();

      if (!"DT_LAST_UPDATE".equals(tempName)) {
        if (column.getType().getType() == ColumnType.NUMBER.getType()) {
          Integer tempInteger = new Integer(column.getContent());
          super.setInt(tempCounter, tempInteger, selectQuery);
        } else if (column.getType().getType() == ColumnType.TEXT.getType()) {
          super.setString(tempCounter, column.getContent(), selectQuery);
        }
        GrndsTrace.msg(TRACE_TAG, 7, "Value of tempCounter:" + tempCounter);
        GrndsTrace.msg(TRACE_TAG, 7, "Value of variable:" + column.getContent());
        tempCounter = tempCounter + 1;
      }
    }

    GrndsTrace.exitScope();
    return selectQuery;
  }

  private static final String TRACE_TAG = "DocumentSelectBlobDao";
  private static final String DATE_TIME_FORMAT = "M/d/yyyy H:m:s";
}




