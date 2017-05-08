package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonHomeRemoval;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
11/05/08    mxpatel           STGAP00009009:  replaced the hibernate queries with
                              SQL queries in deletePersonHomeRemoval method.
*/

public class PersonHomeRemovalDAOImpl extends BaseDAOImpl implements PersonHomeRemovalDAO {
  public PersonHomeRemoval findPersonHmRemovByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery("  from PersonHomeRemoval p " +
                                           " where p.id.idPersHmRemoval = :idPerson " +
                                           "   and p.capsCase.idCase = :idCase");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (PersonHomeRemoval) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<PersonHomeRemoval> findPersonHomeRemovalByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from PersonHomeRemoval p" +
                                           "  where p.id.idRemovalEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<PersonHomeRemoval>) query.list();
  }

  public long countPersonHomeRemovalByIdPersMerge(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from PersonHomeRemoval p1 , " +
                                           "        PersonHomeRemoval p2 , " +
                                           "        Event e , " +
                                           "        Stage s " +
                                           "  where p1.person.idPerson = :idPersMergeForward " +
                                           "    and p2.person.idPerson =  :idPersMergeClosed " +
                                           "    and p1.event.idEvent = p2.event.idEvent " +
                                           "    and p1.event.idEvent = e.idEvent " +
                                           "    and e.stage.idStage =  s.idStage " +
                                           "    and s.dtStageClose is null ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (Long) query.uniqueResult();
  }

  public void savePersonHomeRemoval(PersonHomeRemoval personHomeRemoval) {
    getSession().saveOrUpdate(personHomeRemoval);
   
  }

  public void insertPersonHomeRemoval(int sysIdNewEvent, int idEvent) {
    SQLQuery query = getSession().createSQLQuery(" INSERT INTO PERSON_HOME_REMOVAL " +
                                                 "            ( ID_PERS_HM_REMOVAL, DT_LAST_UPDATE, ID_REMOVAL_EVENT )  " +
                                                 "             SELECT ID_PERS_HM_REMOVAL , " +
                                                 "                    DT_LAST_UPDATE, " +
                                                 "                    :sysIdNewEvent " +
                                                 "               FROM PERSON_HOME_REMOVAL " +
                                                 "              WHERE ID_REMOVAL_EVENT = :idEvent ");
    query.setInteger("sysIdNewEvent", sysIdNewEvent);
    query.setInteger("idEvent", idEvent);
    query.executeUpdate();
  }

  public int updatePersonHomeRemoval(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery(" update PersonHomeRemoval " +
                                           "    set person.idPerson = :idPersMergeForward " +
                                           "  where person.idPerson = :idPersMergeClosed " +
                                           "    and event.idEvent = :idEvent ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  //public void deletePersonHomeRemoval(PersonHomeRemoval personHomeRemoval) {//mxpatel commented this out for defect #9009
  public void deletePersonHomeRemoval(int idRemovalEvent, int idPersonHmRemoval) {//mxpatel added this for defect #9009
    //getSession().delete(personHomeRemoval); //mxpatel commented this out for defect #9009
    // mxpatel replaced the hibernate query with the SQL query for defect #9009
    Query query = getSession().createSQLQuery(
                                              " delete from PERSON_HOME_REMOVAL"
                                                              + " where ID_REMOVAL_EVENT = :idRemovalEvent"
                                                              + " and ID_PERS_HM_REMOVAL = :idPersonHmRemoval");
    query.setInteger("idRemovalEvent", idRemovalEvent);
    query.setInteger("idPersonHmRemoval", idPersonHmRemoval);
    query.executeUpdate();
  }
}
