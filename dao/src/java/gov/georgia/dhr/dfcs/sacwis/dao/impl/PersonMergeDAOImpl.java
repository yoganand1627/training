package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonMerge;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PersonMergeDAOImpl extends BaseDAOImpl implements PersonMergeDAO {
  @SuppressWarnings({"unchecked"})
  public List<PersonMerge> findPersonMergeFromMergeInvalidAndMergeForward(String indPersMergeInvalid,
                                                                          int idPersMergeForward) {
    Query query = getSession()
            .createQuery(
                    " from PersonMerge"
                    + " where indPersMergeInvalid = :indPersMergeInvalid"
                    + " and personByIdPersMergeForward.idPerson = :idPersMergeForward ");
    query.setString("indPersMergeInvalid", indPersMergeInvalid);
    query.setInteger("idPersMergeForward", idPersMergeForward);
    return (List<PersonMerge>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findPersonMerge(int idPrimaryClient) {
    Query query = getSession()
            .createQuery(
                    " select personByIdPersMergeForward.idPerson"
                    + " from   PersonMerge"
                    //+ " where  personByIdPersMergeForward.idPerson = :idPrimaryClient"
                    + " where  personByIdPersMergeClosed.idPerson = :idPrimaryClient"
                    + " and (dtPersMergeSplit is null"
                    + " or dtPersMergeSplit = :maxDate"
                    + " or indPersMergeInvalid = 'N')");
    query.setInteger("idPrimaryClient", idPrimaryClient);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Integer>) query.list();
  }

  public long countPersonMergeForwardOrClosedByIdPerson(int idPerson) {
    Query query = getSession()
            .createQuery(
                    "select count(*)"
                    + "   from PersonMerge p"
                    + "  where p.personByIdPersMergeForward.idPerson = :idPerson"
                    + "     or p.personByIdPersMergeClosed.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Integer> findPersonMergeForwardOrClosedByPersonList(Collection<Integer> idPersons) {
    Query query = getSession()
            .createQuery(
                    " SELECT p.idPerson FROM Person p " +
                    " WHERE p.idPerson IN (:idPersons) AND " +
                    " 0 < (select count(*)"
                    + "   from PersonMerge pm"
                    + "  where pm.personByIdPersMergeForward.idPerson = p.idPerson"
                    + "     or pm.personByIdPersMergeClosed.idPerson = p.idPerson)");
    
    query.setParameterList("idPersons", idPersons);
    return (List<Integer>) query.list();
  }

  public void savePersonMerge(PersonMerge personMerge) {
    getSession().saveOrUpdate(personMerge);
  }

  public int updatePersonMerge(int idPersonMerge, int idPersMergeForward, int idPersMergeClosed, int idPersMergeWrkr,
                               int idPersMergeSplitWrkr, String indPersMergeInvalid, Date dtPersMergeSplit,
                               Date lastUpdate) {
    Query query = getSession()
            .createQuery(
                    " update PersonMerge "
                    + "    set idPersonMerge = :idPersonMerge, "
                    + "        personByIdPersMergeForward.idPerson = :idPersMergeForward, "
                    + "        personByIdPersMergeClosed.idPerson = :idPersMergeClosed, "
                    + "        personByIdPersMergeWrkr.idPerson = :idPersMergeWrkr, "
                    + "        personByIdPersMergeSplitWrkr.idPerson = :idPersMergeSplitWrkr, "
                    + "        indPersMergeInvalid = :indPersMergeInvalid, "
                    + "        dtPersMergeSplit = :dtPersMergeSplit "
                    + "  where dtLastUpdate = :lastUpdate "
                    + "    and idPersonMerge = :idPersonMerge ");
    query.setInteger("idPersonMerge", idPersonMerge);
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idPersMergeWrkr", idPersMergeWrkr);
    query.setInteger("idPersMergeSplitWrkr", idPersMergeSplitWrkr);
    query.setString("indPersMergeInvalid", indPersMergeInvalid);
    query.setTimestamp("dtPersMergeSplit", dtPersMergeSplit);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }
  
  public int updatePersonMerge(int idPersonMerge, int idPersMergeForward, int idPersMergeClosed, int idPersMergeWrkr,
                               String indPersMergeInvalid, Date dtPersMergeSplit,
                               Date lastUpdate) {
    Query query = getSession()
            .createQuery(
                    " update PersonMerge "
                    + "    set idPersonMerge = :idPersonMerge, "
                    + "        personByIdPersMergeForward.idPerson = :idPersMergeForward, "
                    + "        personByIdPersMergeClosed.idPerson = :idPersMergeClosed, "
                    + "        personByIdPersMergeWrkr.idPerson = :idPersMergeWrkr, "                   
                    + "        indPersMergeInvalid = :indPersMergeInvalid, "
                    + "        dtPersMergeSplit = :dtPersMergeSplit "
                    + "  where dtLastUpdate = :lastUpdate "
                    + "    and idPersonMerge = :idPersonMerge ");
    query.setInteger("idPersonMerge", idPersonMerge);
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idPersMergeWrkr", idPersMergeWrkr);   
    query.setString("indPersMergeInvalid", indPersMergeInvalid);
    query.setTimestamp("dtPersMergeSplit", dtPersMergeSplit);
    query.setTimestamp("lastUpdate", lastUpdate);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findPersonMergeByIdPersMergeForward(int idPerson, int pageNbr, int pageSize) {
    SQLQuery query = getSession()
            .createSQLQuery(
                    "SELECT PM2.ID_PERSON_MERGE AS ID_PERSON_MERGE,"
                    + "       PM2.DT_LAST_UPDATE AS DT_LAST_UPDATE,"
                    + "       PM2.ID_PERS_MERGE_FORWARD AS ID_PERS_MERGE_FORWARD,"
                    + "       P1.NM_PERSON_FULL AS NM_PERSON_FULL, "
                    + "       P1.NM_PERSON_FIRST AS NM_PERSON_FIRST,"
                    + "       P1.NM_PERSON_MIDDLE AS NM_PERSON_MIDDLE, "
                    + "       P1.NM_PERSON_LAST AS NM_PERSON_LAST, "
                    + "       PM2.ID_PERS_MERGE_CLOSED AS ID_PERS_MERGE_CLOSED, "
                    + "       P2.NM_PERSON_FULL AS P2_NM_PERSON_FULL,"
                    + "       P2.NM_PERSON_FIRST AS P2_NM_PERSON_FIRST,"
                    + "       P2.NM_PERSON_MIDDLE AS P2_NM_PERSON_MIDDLE, "
                    + "       P2.NM_PERSON_LAST AS P2_NM_PERSON_LAST, "
                    + "       PM2.ID_PERS_MERGE_WRKR AS ID_PERS_MERGE_WRKR,"
                    + "       E1.NM_EMPLOYEE_LAST AS NM_EMPLOYEE_LAST, "
                    + "       E1.NM_EMPLOYEE_FIRST AS NM_EMPLOYEE_FIRST, "
                    + "       E1.NM_EMPLOYEE_MIDDLE AS NM_EMPLOYEE_MIDDLE, "
                    + "       PM2.ID_PERS_MERGE_SPLIT_WRKR AS ID_PERS_MERGE_SPLIT_WRKR, "
                    + "       E2.NM_EMPLOYEE_LAST AS E2_NM_EMPLOYEE_LAST, "
                    + "       E2.NM_EMPLOYEE_FIRST AS E2_NM_EMPLOYEE_FIRST, "
                    + "       E2.NM_EMPLOYEE_MIDDLE AS E2_NM_EMPLOYEE_MIDDLE, "
                    + "       PM2.IND_PERS_MERGE_INVALID AS IND_PERS_MERGE_INVALID, "
                    + "       PM2.DT_PERS_MERGE_SPLIT AS DT_PERS_MERGE_SPLIT, "
                    + "       PM2.DT_PERS_MERGE  AS DT_PERS_MERGE "
                    + "  FROM PERSON P1, "
                    + "       PERSON P2, "
                    + "       EMPLOYEE E1, "
                    + "       EMPLOYEE E2, "
                    + "       PERSON_MERGE PM2 "
                    + " WHERE PM2.ID_PERS_MERGE_FORWARD = :idPerson "
                    + "   AND NVL(PM2.ID_PERS_MERGE_FORWARD, - 1) <> NVL(PM2.ID_PERS_MERGE_CLOSED, - 2) "
                    + "   AND PM2.ID_PERS_MERGE_FORWARD IN (SELECT DISTINCT (PM1.ID_PERS_MERGE_FORWARD) "
                    + "  FROM PERSON_MERGE PM1 "
                    + " WHERE PM2.ID_PERS_MERGE_FORWARD = PM1.ID_PERS_MERGE_CLOSED (+) ) "
                    //+ " ) "
                    + "   AND PM2.ID_PERS_MERGE_FORWARD = P1.ID_PERSON (+) "
                    + "   AND PM2.ID_PERS_MERGE_CLOSED = P2.ID_PERSON (+) "
                    + "   AND PM2.ID_PERS_MERGE_FORWARD = P1.ID_PERSON (+) "
                    + "   AND PM2.ID_PERS_MERGE_CLOSED = P2.ID_PERSON (+) "
                    + "   AND PM2.ID_PERS_MERGE_WRKR = E1.ID_PERSON (+) "
                    + "   AND PM2.ID_PERS_MERGE_SPLIT_WRKR = E2.ID_PERSON (+) "
                    + "ORDER BY PM2.IND_PERS_MERGE_INVALID ASC, "
                    + "       PM2.DT_PERS_MERGE DESC, "
                    + "       PM2.DT_PERS_MERGE_SPLIT DESC");
    query.setInteger("idPerson", idPerson);
    query.addScalar("ID_PERSON_MERGE", Hibernate.INTEGER);
    // query.addScalar("DT_LAST_UPDATE", Hibernate.DATE);
    query.addScalar("DT_LAST_UPDATE", Hibernate.TIMESTAMP);
    query.addScalar("ID_PERS_MERGE_FORWARD", Hibernate.INTEGER);
    query.addScalar("NM_PERSON_FULL", Hibernate.STRING);
    query.addScalar("NM_PERSON_FIRST", Hibernate.STRING);
    query.addScalar("NM_PERSON_MIDDLE", Hibernate.STRING);
    query.addScalar("NM_PERSON_LAST", Hibernate.STRING);
    query.addScalar("ID_PERS_MERGE_CLOSED", Hibernate.INTEGER);
    query.addScalar("P2_NM_PERSON_FULL", Hibernate.STRING);
    query.addScalar("P2_NM_PERSON_FIRST", Hibernate.STRING);
    query.addScalar("P2_NM_PERSON_MIDDLE", Hibernate.STRING);
    query.addScalar("P2_NM_PERSON_LAST", Hibernate.STRING);
    query.addScalar("ID_PERS_MERGE_WRKR", Hibernate.INTEGER);
    query.addScalar("NM_EMPLOYEE_LAST", Hibernate.STRING);
    query.addScalar("NM_EMPLOYEE_FIRST", Hibernate.STRING);
    query.addScalar("NM_EMPLOYEE_MIDDLE", Hibernate.STRING);
    query.addScalar("ID_PERS_MERGE_SPLIT_WRKR", Hibernate.INTEGER);
    query.addScalar("E2_NM_EMPLOYEE_LAST", Hibernate.STRING);
    query.addScalar("E2_NM_EMPLOYEE_FIRST", Hibernate.STRING);
    query.addScalar("E2_NM_EMPLOYEE_MIDDLE", Hibernate.STRING);
    query.addScalar("IND_PERS_MERGE_INVALID", Hibernate.STRING);
    // query.addScalar("DT_PERS_MERGE_SPLIT", Hibernate.DATE);
    // query.addScalar("DT_PERS_MERGE", Hibernate.DATE);
    query.addScalar("DT_PERS_MERGE_SPLIT", Hibernate.TIMESTAMP);
    query.addScalar("DT_PERS_MERGE", Hibernate.TIMESTAMP);

    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }
}
