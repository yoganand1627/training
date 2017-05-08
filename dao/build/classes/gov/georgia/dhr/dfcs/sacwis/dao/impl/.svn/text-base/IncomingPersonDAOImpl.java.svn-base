package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.IncomingPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingPerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IncomingPersonDAOImpl extends BaseDAOImpl implements IncomingPersonDAO {

  public IncomingPerson findIncomingPersonByIdPersonAndIdStage(int idPerson, int idStage) {
    Query query = getSession().createQuery("  from IncomingPerson i " +
                                           " where i.person.idPerson = :idPerson " +
                                           "   and i.stage.idStage  = :idStage ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (IncomingPerson) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<IncomingPerson> findIncomingPersonByIdStage(int idStage) {
    Query query = getSession().createQuery("  from IncomingPerson i " +
                                           "   where i.stage.idStage  = :idStage ");
    query.setInteger("idStage", idStage);
    return (List<IncomingPerson>) query.list();
  }

  public Integer findIncomingPersonIdIncmgPerson(int idPerson, int idStage) {
    Query query = getSession().createQuery(" select ip.idIncmgPerson " +
                                           "   from IncomingPerson ip " +
                                           "  where ip.person.idPerson = :idPerson " +
                                           "    and ip.stage.idStage = :idStage ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public int insertIncomingPersonWithoutIndInfoSwap(int idIncomingPerson,
                                                    int idRelatedPerson,
                                                    int idPerson,
                                                    int idStage) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO INCOMING_PERSON (   ID_INCMG_PERSON,ID_STAGE," +
                                                 "  ID_PERSON,NBR_INCMG_PERS_AGE," +
                                                 "  DT_INCMG_PERS_DEATH," +
                                                 "  DT_INCMG_PERS_BIRTH," +
                                                 "  CD_INCMG_PERS_DEATH," +
                                                 "  CD_INCMG_PERS_MARITL_STAT," +
                                                 "  CD_INCMG_PERS_LANGUAGE," +
                                                 "  CD_INCMG_PERS_SEX," +
                                                 "  CD_INCMG_PERS_ETHNIC," +
                                                 "  NM_INCMG_PERS_FULL," +
                                                 "  IND_INCMG_PERS_DOB_APPROX )" +
                                                 " SELECT :idIncomingPerson," +
                                                 "        B.ID_STAGE," +
                                                 "        :idRelatedPerson," +
                                                 "        A.NBR_PERSON_AGE," +
                                                 "        A.DT_PERSON_DEATH," +
                                                 "        A.DT_PERSON_BIRTH," +
                                                 "        A.CD_PERSON_DEATH," +
                                                 "        A.CD_PERSON_MARITAL_STATUS," +
                                                 "        A.CD_PERSON_LANGUAGE," +
                                                 "        A.CD_PERSON_SEX," +
                                                 "        A.CD_PERSON_ETHNIC_GROUP," +
                                                 "        A.NM_PERSON_FULL," +
                                                 "        A.IND_PERSON_DOB_APPROX" +
                                                 "   FROM STAGE_PERSON_LINK B," +
                                                 "        PERSON A" +
                                                 "  WHERE A.ID_PERSON = :idPerson" +
                                                 "    AND B.ID_PERSON = A.ID_PERSON" +
                                                 "    AND B.ID_STAGE = :idStage");
    query.setInteger("idIncomingPerson", idIncomingPerson);
    query.setInteger("idRelatedPerson", idRelatedPerson);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int deleteIncomingPerson(int idPerson, int idStage) {
    SQLQuery query = getSession().createSQLQuery("CALL COMPLEX_DELETE.DELETE_INCOMING_PERSON(:idPerson, :idStage)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
}
