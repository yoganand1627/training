package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.StffAsgnmtHistoryDAO;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class StffAsgnmtHistoryDAOImpl extends BaseDAOImpl implements StffAsgnmtHistoryDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findStffAsgnmtHistoryByIdCase(int idCase) {
    Query query = getSession().createQuery("select new map(a.idStffAsgnmtHstry as idStffAsgnmtHstry, " +
                                           "               a.employeeByIdFromPerson.person.nmPersonFull as nmFromPerson, " +
                                           "               a.employeeByIdFromPerson.office.mailCode.addrMailCodeCounty as cdFromPersonCounty, " +
                                           "               a.employeeByIdToPerson.person.nmPersonFull as nmToPerson, " +
                                           "               a.employeeByIdToPerson.office.mailCode.addrMailCodeCounty as cdToPersonCounty, " +
                                           "               a.employeeByIdEnteredByPerson.person.nmPersonFull as nmEnteredByPerson, " +
                                           "               a.stage.idStage as idStage, " +
                                           "               a.stage.cdStage as cdStage, " +
                                           "               a.dtLastUpdate as dtLastUpdate) " +
                                           "     from StffAsgnmtHistory a" +
                                           "     where a.capsCase.idCase = :idCase " +
                                           "     order by a.dtLastUpdate desc ");
    query.setInteger("idCase", idCase);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public int insertStffAsgnmtHistory(int idFromPerson, int idToPerson, int idEnteredByPerson, int idStage, int idCase) {
    SQLQuery query = getSession().createSQLQuery("  INSERT INTO STFF_ASGNMT_HISTORY( " +
                                                 "      ID_STFF_ASGNMT_HSTRY, " +
                                                 "      ID_FROM_PERSON, " +
                                                 "      ID_TO_PERSON, " +
                                                 "      ID_ENTERED_BY_PERSON, " +
                                                 "      ID_STAGE, " +
                                                 "      ID_CASE ) " +
                                                 "      VALUES( 0, " +
                                                 "      :idFromPerson, " +
                                                 "      :idToPerson, " +
                                                 "      :idEnteredByPerson, " +
                                                 "      :idStage, " +
                                                 "      :idCase)");

    query.setInteger("idFromPerson", idFromPerson);
    query.setInteger("idToPerson", idToPerson);
    query.setInteger("idEnteredByPerson", idEnteredByPerson);
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    return query.executeUpdate();
  }//end insertStffAsgnmtHistory  
}
