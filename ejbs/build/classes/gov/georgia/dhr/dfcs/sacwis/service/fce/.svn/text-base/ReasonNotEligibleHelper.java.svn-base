package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReasonNotEligibleHelper implements Serializable {

  protected static void copyReasonsNotEligible(Connection connection, long oldIdFceEligibility,
                                               long newIdFceEligibility)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement =
              connection.prepareStatement("insert into fce_reason_not_eligible (id_fce_reason_not_eligible, \n" +
                                          "                                     id_fce_eligibility, \n" +
                                          "                                     cd_reason_not_eligible) \n" +
                                          "select seq_fce_reason_not_eligible.nextval, \n" +
                                          "       ?, \n" +
                                          "       cd_reason_not_eligible \n" +
                                          "from fce_reason_not_eligible \n" +
                                          "where id_fce_eligibility = ? \n");
      preparedStatement.setLong(1, newIdFceEligibility);
      preparedStatement.setLong(2, oldIdFceEligibility);
      preparedStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  protected static void createReasonsNotEligible(List reasonNotEligibleCodes, long idFceEligibility,
                                                 Fce fceService) {
    Iterator iterator = reasonNotEligibleCodes.iterator();
    while (iterator.hasNext()) {
      String cdReasonNotEligible = (String) iterator.next();

      createReasonNotEligible(cdReasonNotEligible, idFceEligibility, fceService);
    }
  }

  private static FceReasonNotEligibleDB createReasonNotEligible(String cdReasonNotEligible, long idFceEligibility,
                                                                Fce fce) {
    //using intermediate object because ejb create signature is code gen'd
    //and ordering of parameters may change
    FceReasonNotEligibleDB fceReasonNotEligibleDB = new FceReasonNotEligibleDB();
    fceReasonNotEligibleDB.setCdReasonNotEligible(cdReasonNotEligible);
    fceReasonNotEligibleDB.setIdFceEligibility(idFceEligibility);

    fce.saveFceReasonNotEligible(fceReasonNotEligibleDB);
    return fceReasonNotEligibleDB;
  }

  protected static void deleteReasonsNotEligible(Connection connection, long idFceEligibility) throws SQLException {
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("delete from fce_reason_not_eligible " +
                                                      "where id_fce_eligibility = ?");
      preparedStatement.setLong(1, idFceEligibility);
      preparedStatement.executeUpdate();
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
  }

  @SuppressWarnings({"deprecation"})
  protected static List<FceReasonNotEligibleDB> findReasonsNotEligible(Connection connection, long idFceEligibility)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    List<FceReasonNotEligibleDB> output;
    List list;
    try {
      preparedStatement = connection.prepareStatement("select * \n" +
                                                      "from fce_reason_not_eligible \n" +
                                                      "where id_fce_eligibility = ? \n" +
                                                      "order by cd_reason_not_eligible \n");
      preparedStatement.setLong(1, idFceEligibility);
      output = new ArrayList<FceReasonNotEligibleDB>();
      list = SqlHelper.createListFromQuery(preparedStatement);
    } finally {
      SqlHelper.cleanup(preparedStatement);
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Map map = (Map) iterator.next();
      FceReasonNotEligibleDB fceReasonNotEligibleDB = new FceReasonNotEligibleDB();
      FceReasonNotEligibleDB.populateWithMap(fceReasonNotEligibleDB, map);
      output.add(fceReasonNotEligibleDB);
    }
    return output;
  }
}
