package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;

public class AdoptionAssistanceEligibilityDocumentationDao extends BaseDao {
  public static final String TRACE_TAG = "AdoptionAssistanceEligibilityDocumentationDao";

  public AdoptionAssistanceEligibilityDocumentationDao(Connection connection) {
    super(connection);
  }

  /** Returns Array of Adoption_Subsidy ids from the sub_elig_narr table */
  public int[] getAdoptionSubsidyIds(int caseId, int stageId) throws SQLException {
    Connection connection = super.getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      String query = "select distinct \n" +
                     "       narrative.id_adpt_sub \n" +
                     "from  \n" +
                     "     sub_elig_narr narrative, \n" +
                     "     event \n" +
                     "where narrative.id_case = event.id_case \n" +
                     "  and event.cd_event_type = 'ADP' \n" +
                     "  and narrative.id_case = ? \n" +
                     "  and event.id_case = ? \n";

      if (stageId != 0) {
        query += "  and event.id_event_stage = ? \n";
      }

      statement = connection.prepareStatement(query);
      statement.setInt(1, caseId);
      statement.setInt(2, caseId);

      if (stageId != 0) {
        statement.setInt(3, stageId);
      }

      GrndsTrace.msg(TRACE_TAG,
                     7,
                     ".getAdoptionSubsidyIds sql: \n" + query + "\n" +
                     "\t caseId: " + caseId + "\n" +
                     "\t stageId: " + stageId);

      List<Integer> vector = new ArrayList<Integer>();
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        vector.add(resultSet.getInt(1));
      }
      int[] adoptionSubsidyIds = new int[vector.size()];
      for (int i = 0; i < adoptionSubsidyIds.length; i++) {
        adoptionSubsidyIds[i] = vector.get(i);
      }
      return adoptionSubsidyIds;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }
}


