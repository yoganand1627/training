package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;

/** Interfaces with CFP metadata tables */
public class DocumentTypeDao extends BaseDao {

  public static final String TRACE_TAG = "DocumentTypeDao";

  public DocumentTypeDao(Connection connection) {
    super(connection);
  }

  /** Gets all documentTypes in order for a program, stage, and stageType */
  public DocumentTypeDB[] getDocumentOrder(String program, String stage, String stageType) throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".getDocumentOrder: \n" +
                          "\t program: " + program + "\n " +
                          "\t stage: " + stage + "\n " +
                          "\t stageType: " + stageType + "\n ");
    Connection connection = null;
    PreparedStatement statement1 = null;
    PreparedStatement statement2 = null;
    PreparedStatement statement3 = null;
    PreparedStatement statement4 = null;
    ResultSet resultSet = null;
    ResultSet resultSet1 = null;
    ResultSet resultSet2 = null;
    ResultSet resultSet3 = null;
    ResultSet resultSet4 = null;
    try {
      if (stage == null) {
        String sql = getSql(program, null, null);
        statement1 = connection.prepareStatement(sql);
        resultSet1 = statement1.executeQuery();
        if (!resultSet1.next()) {
          throw new IllegalStateException("expected results: \n" + sql);
        }
        resultSet = resultSet1;
      } else if (stageType != null) {
        String sql = getSql(program, stage, stageType);
        statement2 = connection.prepareStatement(sql);
        resultSet2 = statement2.executeQuery();
        if (resultSet2.next()) {
          resultSet = resultSet2;
        } else {
          sql = getSql(program, stage, null);
          statement3 = connection.prepareStatement(sql);
          resultSet3 = statement3.executeQuery();
          if (resultSet3.next()) {
            resultSet = resultSet3;
          } else {
            sql = getSql(program, null, null);
            statement4 = connection.prepareStatement(sql);
            resultSet4 = statement4.executeQuery();
            if (!resultSet4.next()) {
              throw new IllegalStateException("expected results: \n" + sql);
            }
            resultSet = resultSet4;
          }
        }
      }
      List<DocumentTypeDB> list = new ArrayList<DocumentTypeDB>();
      do {
        DocumentTypeDB documentType = new DocumentTypeDB();
        documentType.setSortOrder(resultSet.getInt(1));
        documentType.setOutputName(resultSet.getString(2));
        documentType.setOutputCode(resultSet.getString(3));
        list.add(documentType);
      }
      while (resultSet.next());
      DocumentTypeDB[] array = new DocumentTypeDB[list.size()];
      array = list.toArray(array);
      return array;
    } finally {
      cleanup(resultSet1);
      cleanup(resultSet2);
      cleanup(resultSet3);
      cleanup(resultSet4);
      cleanup(statement1);
      cleanup(statement2);
      cleanup(statement3);
      cleanup(statement4);
      GrndsTrace.exitScope();
    }
  }

  /** Obtains all metadata about how to generate reports/forms for a given outputCode (ie. C010) */
  public DocumentGenerationMetaDataDB getDocumentGenerationMetaData(String outputCode) throws SQLException {
    Connection connection = getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      String sql = "select " +
                   "       TXT_NAME as OutputName, \n" +
                   "       NM_DOCUMENT as DocType, \n" +
                   "       TXT_GENERATE_METHOD as GenerateMethod, \n" +
                   "       TXT_FOR_EACH as ForEach \n" +
                   "from cfp_document \n" +
                   "where CD_OUTPUT = ? \n";
      statement = connection.prepareStatement(sql);
      statement.setString(1, outputCode);
      GrndsTrace.msg(TRACE_TAG, 7, "getDocumentGenerationMetaData: \n" + sql +
                                   "\t CD_OUTPUT: " + outputCode);
      resultSet = statement.executeQuery();
      if (resultSet.next() == false) {
        throw new IllegalStateException("expected a row with\n" + sql);
      }
      int column = 0;
      DocumentGenerationMetaDataDB metaData = new DocumentGenerationMetaDataDB();
      metaData.setOutputCode(outputCode);
      metaData.setOutputName(resultSet.getString(++column));
      metaData.setDocType(resultSet.getString(++column));
      metaData.setGenerateMethod(resultSet.getString(++column));
      metaData.setForEach(resultSet.getString(++column));
      return metaData;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }

  /** produce a sql statement for examining the cfp_document table with a program, stage, stageType */
  protected static String getSql(String program, String stage, String stageType) {
    String select = "select cfp_document.NBR_SORT_ORDER, \n" +
                    "       cfp_document.TXT_NAME, \n" +
                    "       cfp_document.CD_OUTPUT \n";
    String from = "from cfp_document\n";
    if (stage != null) {
      from = "from cfp_document, cfp_document_stage\n";
    }
    String where = "where cfp_document.CD_STAGE_PROGRAM = '" + program + "'\n";
    if (stage != null) {
      where += "  and cfp_document.ID_CFP_DOCUMENT = cfp_document_stage.ID_CFP_DOCUMENT\n" +
               "  and cfp_document_stage.CD_STAGE = '" + stage + "'\n";
      if (stageType != null) {
        where += "  and cfp_document_stage.CD_STAGE_TYPE = '" + stageType + "'\n";
      } else {
        where += "  and cfp_document_stage.CD_STAGE_TYPE is null \n";
      }
    }
    String orderBy = "order by cfp_document.NBR_SORT_ORDER \n";
    String sql = select + from + where + orderBy;
    GrndsTrace.msg(TRACE_TAG, 7, "DocumentTypeDao.getSql: \n" + sql);
    return sql;
  }
}
