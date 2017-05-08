package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class FcePersonDAOImpl extends BaseDAOImpl implements FcePersonDAO {

  public int updateFcePersonIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage) {
    Query query = getSession().createQuery(" update FcePerson" +
                                           "    set person.idPerson = :idPersMergeForward" +
                                           "  where person.idPerson = :idPersMergeClosed" +
                                           "    and fceEligibility.idFceEligibility in (select idFceEligibility" +
                                           "                                              from FceEligibility" +
                                           "                                             where stage.idStage = :idStage)");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public FcePerson findFcePersonByIdPerson(long idPerson) {
    Query query = getSession().createQuery(" from FcePerson " +
                                           "where person.idPerson = :idPerson");
    query.setLong("idPerson", idPerson);
    return (FcePerson) firstResult(query);
  }

  public FcePerson findFcePersonByIdFceEPerson(long idFcePerson) {
    Query query = getSession().createQuery(" from FcePerson " +
                                           "  where idFcePerson = :idFcePerson");
    query.setLong("idFcePerson", idFcePerson);
    return (FcePerson) firstResult(query);
  }

  public FcePerson findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson) {
    Query query = getSession().createQuery(" from FcePerson fp " +
                                           " where fp.person.idPerson = :idPerson" +
                                           " and fp.fceEligibility.idFceEligibility = :idFceEligibility");
    query.setLong("idPerson", idPerson);
    query.setLong("idFceEligibility", idFceEligibility);
    return (FcePerson) firstResult(query);
  }

  public void saveFcePerson(FcePerson fcePerson) {
    getSession().saveOrUpdate(fcePerson);
  }

  public int saveFcePersonByIdPersonIdFceEligAndCdRelInt(long idFcePerson, long idFceEligibility, long idPerson,
                                                         String cdRelInt) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO FCE_PERSON " +
                                                 "           (ID_FCE_PERSON, " +
                                                 "            ID_FCE_ELIGIBILITY, " +
                                                 "            ID_PERSON, " +
                                                 "            CD_REL_INT) " +
                                                 "     VALUES(:idFcePerson, " +
                                                 "            :idFceEligibility, " +
                                                 "            :idPerson, " +
                                                 "            :cdRelInt)");
    query.setLong("idFcePerson", idFcePerson);
    query.setLong("idFceEligibility", idFceEligibility);
    query.setLong("idPerson", idPerson);
    query.setString("cdRelInt", cdRelInt);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findcdRelIntbyIdPerson(long idFceEligibility) {
    SQLQuery query = getSession().createSQLQuery("SELECT CD_STAGE_PERS_REL_INT " +
                                                 "  FROM STAGE_PERSON_LINK " +
                                                 " WHERE STAGE_PERSON_LINK.ID_PERSON IN" +
                                                 "       (SELECT ID_PERSON " +
                                                 "          FROM FCE_PERSON " +
                                                 "         WHERE ID_FCE_ELIGIBILITY = :idFceEligibility) " +
                                                 "   AND STAGE_PERSON_LINK.CD_STAGE_PERS_TYPE = 'PRN' " +
                                                 "   AND STAGE_PERSON_LINK.ID_STAGE IN " +
                                                 "       (SELECT ID_STAGE " +
                                                 "          FROM FCE_ELIGIBILITY " +
                                                 "         WHERE ID_FCE_ELIGIBILITY = :idFceEligibility)");
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<String>) query.list();
  }

  public String ifEventExists(long idStage, long idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_EVENT\n" +
                                                 "  FROM FCE_APPLICATION\n" +
                                                 " WHERE ID_STAGE = :idStage\n" +
                                                 "   AND CD_APPLICATION LIKE 'A'\n" +
                                                 "   AND DT_LAST_UPDATE = " +
                                                 "       (SELECT MIN(DT_LAST_UPDATE)\n" +
                                                 "          FROM FCE_APPLICATION\n" +
                                                 "         WHERE ID_STAGE = (SELECT ID_STAGE\n" +
                                                 "                             FROM FCE_APPLICATION\n" +
                                                 "                            WHERE ID_EVENT = :idEvent)\n" +
                                                 "           AND CD_APPLICATION LIKE 'A')");
    query.setLong("idStage", idStage);
    query.setLong("idEvent", idEvent);
    return (String) firstResult(query);
  }

  public void updateByCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, String indLegalCustodian) {
    Query query = getSession().createQuery("update FcePerson p " +
                                           "   set p.cdRelInt = :cdRelInt, " +
                                           "       p.indLegalCustodian = :indLegalCustodian " +
                                           " where p.idFcePerson = :idFcePerson ");
    query.setString("cdRelInt", cdRelInt);
    query.setString("indLegalCustodian", indLegalCustodian);
    query.setLong("idFcePerson", idFcePerson);
    query.executeUpdate();
  }

  public void updateFcePersonIndThirdPartyIns(long idPerson, String indThirdPartyIns) {
    Query query = getSession().createQuery("update FcePerson fp " +
                                           "   set fp.indThirdPartyInsurance = :indThirdPartyIns " +
                                           " where fp.person.idPerson = :idPerson");
    query.setString("indThirdPartyIns", indThirdPartyIns);
    query.setLong("idPerson", idPerson);
    query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<FcePerson> findPrincipals(long idFceEligibility){
    Query query = getSession().createQuery("from FcePerson fp " +
                                           " where fp.fceEligibility.idFceEligibility = :idFceEligibility");
    query.setLong("idFceEligibility", idFceEligibility);
    return (List<FcePerson>) query.list();
  }
}


