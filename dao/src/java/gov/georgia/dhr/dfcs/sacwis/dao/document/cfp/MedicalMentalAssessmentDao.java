package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;

public class MedicalMentalAssessmentDao extends BaseDao {
  public static final String TRACE_TAG = "MedicalMentalAssessmentDao";
  public static final String ID_PRINCIPAL = "ID_PRINCIPAL";
  public static final String ID_EVENT = "ID_EVENT";

  public MedicalMentalAssessmentDao(Connection connection) {
    super(connection);
  }

  /** Returns list of Maps containing ID_EVENT and ID_PRINCIPAL associated with this caseId/stageId */
  @SuppressWarnings({"deprecation"})
  public List<Map<String, Object>> getMedicalMentalEventPrincipalPairs(int caseId, int stageId) throws SQLException {
    String query = "select pa.id_person_principal as " + ID_PRINCIPAL + ", \n" +
                   "       pa.id_event as " + ID_EVENT + "\n" +
                   "from professional_assmt pa,\n" +
                   "     event e\n" +
                   "where pa.id_event = e.id_event\n";
    if (stageId != 0) {
      query += "  and e.id_event_stage = ?\n";
    } else {
      query += "  and e.id_case = ?\n";
    }
    query += "order by pa.id_person_principal\n";
    Connection connection = super.getConnection();
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement(query);
      if (stageId != 0) {
        preparedStatement.setInt(1, stageId);
      } else {
        preparedStatement.setInt(1, caseId);
      }
      return SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      cleanup(preparedStatement);
    }
  }
}
