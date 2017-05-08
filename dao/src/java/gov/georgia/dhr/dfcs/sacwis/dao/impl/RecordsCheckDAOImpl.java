package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 *  
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  08/04/08  arege      STGAP00009440 Modified updateRecordsCheckIdStage()
 *                       to prevent DataException when save and close intake 
 *                       that have multiple people with records check.
 *  06/23/09  bgehlot    STGAP00014329: Added the method findCompletedRecordsCheckByIdRecCheckPerson, 
 *                       findCompletedRecordsCheckByIdRecCheckPersonOverAge18
 *  08/18/2010 bgehlot   SMS 66380 MR-072 Added method findCompletedRecordsCheckByIdRecCheckPersonOverAge17, findCompletedRecordsCheckByIdRecCheckPersonUnderAge17
 *  09/08/2010 bgehlot   SMS 69955 Added method findCompletedRecordsCheckNewCodesByIdRecCheckPerson
 *  02/28/11  hnguyen    SMS#97850: Added method findLatestCompletedRecordsCheckByIdRecCheckPersonByCdRecCheckCheckType(idPerson, cdRecCheckType).
 *  06/17/11  cwells     SMS 112159: updated findCompletedRecordsCheckByIdRecCheckPerson to include new codes table value SR. 
 * </pre>
 */
public class RecordsCheckDAOImpl extends BaseDAOImpl implements RecordsCheckDAO {
  
  @SuppressWarnings( { "unchecked" })
  public Map findRecordsChecksByIdRecChecks(Collection<Integer> idRecCheckList) {
    Query query = getSession().createQuery(
                "select new map(idRecCheck as idRecCheck, r as recordsCheck)"
                  + "from RecordsCheck r "
                  + "  where r.idRecCheck in (:idRecCheckList) ");
                                                           
    query.setParameterList("idRecCheckList", idRecCheckList);
    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<RecordsCheck> findRecordsChecksByDtStageStartPersonsType(Date dtStageStart, Collection<Integer> idPersonList, List<String> nonLegTypesList) {
    Query query = getSession().createQuery(
                  "from RecordsCheck r "
                    + "  where r.dtRecCheckRequest >= :dtStageStart"
                    + "  and r.personByIdRecCheckPerson.idPerson in (:idPersonList)"
                    + "  and r.cdRecCheckCheckType in (:nonLegTypesList)"
                    + "  order by r.personByIdRecCheckPerson.idPerson");

    query.setDate("dtStageStart", dtStageStart);
    query.setParameterList("idPersonList", idPersonList);
    query.setParameterList("nonLegTypesList", nonLegTypesList);
    return (List<RecordsCheck>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<RecordsCheck> findRecordsChecksByIdPersonsType(Collection<Integer> idPersonList, List<String> legTypesList) {
    Query query = getSession().createQuery(
                "from RecordsCheck r "
                  + "  where r.personByIdRecCheckPerson.idPerson in (:idPersonList) "
                  + "  and r.cdRecCheckCheckType in (:legTypesList)"
                  + "  order by r.personByIdRecCheckPerson.idPerson");
                                                           
    query.setParameterList("idPersonList", idPersonList);
    query.setParameterList("legTypesList", legTypesList);
    return (List<RecordsCheck>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findRecordsCheck(int personByIdRecCheckPerson, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("  select rc, " +
                                           "         p.nmPersonFull " +
                                           "    from RecordsCheck rc " +
                                           "    join rc.personByIdRecCheckRequestor p " +
                                           "   where rc.personByIdRecCheckPerson.idPerson = :personByIdRecCheckPerson " +
                                           "order by rc.dtRecCheckRequest desc");
    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }

  public void saveRecordsCheck(RecordsCheck recordsCheck) {
    getSession().saveOrUpdate(recordsCheck);
  }

  public int deleteRecordsCheck(int idRecCheck, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete RecordsCheck " +
                                           " where idRecCheck = :idRecCheck " +
                                           "   and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idRecCheck", idRecCheck);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }  
   
  //STGAP00009440 Modified to prevent DataException when save and close intake 
  //              that have multiple people with records check.
  public int updateRecordsCheckIdStage(int stage) {
    Query query = getSession().createQuery(
                                           "update RecordsCheck s " + " set s.stage = NULL "
                                                           + "where s.personByIdRecCheckPerson IN "
                                                           + "(select distinct personByIdRecCheckPerson"
                                                           + "  from RecordsCheck" + "  where stage = :stage)");

    query.setInteger("stage", stage);
    return query.executeUpdate();
  }
    
  //STGAP00014329: Retrieves completed records check for idPerson
  public String findCompletedRecordsCheckByIdRecCheckPerson(int personByIdRecCheckPerson) {
    Query query = getSession().createSQLQuery("   select distinct (case when (select count(*) from " +
                                              "  (select distinct rc.cd_Rec_Check_Check_Type from Records_Check rc " +
                                              "  where rc.id_rec_check_person = :personByIdRecCheckPerson " +
                                              "  and (rc.dt_Rec_Check_Completed is not null and rc.dt_Rec_Check_Completed != :maxDate) " +
                                              "  and rc.cd_rec_check_check_type in ('SC', 'CF', 'SR', 'DC', 'BP'))) = 5 THEN 'Y' " + "" +
                                              "  else 'N' " +
                                              "  end) from Records_Check ");
    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (String)query.uniqueResult().toString();
  }
  
  //STGAP00014329: Retrieves completed records check for idPerson who are over 18 years
  public String findCompletedRecordsCheckByIdRecCheckPersonOverAge18(int personByIdRecCheckPerson) {
    Query query = getSession().createSQLQuery("   select distinct (case when (select count(*) from " +
                                              "  (select distinct rc.cd_Rec_Check_Check_Type from Records_Check rc, Person a " +
                                              "  where rc.id_rec_check_person = :personByIdRecCheckPerson " +
                                              "  and rc.id_rec_check_person = a.id_Person " +
                                              "  and (rc.dt_Rec_Check_Completed is not null and rc.dt_Rec_Check_Completed != :maxDate) " +
                                              "  and rc.cd_rec_check_check_type in ('SC', 'CF', 'SO', 'DC', 'BP', 'GC') " +
                                              "  and months_between(sysdate,nvl(a.dt_Person_Birth,sysdate)) >= 216 )) = 6 THEN 'Y' " +
                                              "  else 'N' " +
                                              "  end) from Records_Check ");
    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return query.uniqueResult().toString();
  }
  
  /**
   * MR-072 Return Y if all the ten type of records check are done for person equal or over 17 years of age who is principal or
   * member of PK household
   * @param personByIdRecCheckPerson
   * @return
   */
  public String findCompletedRecordsCheckByIdRecCheckPersonOverAge17(int personByIdRecCheckPerson) {
    Query query = getSession().createSQLQuery("   select distinct (case when (select count(*) from " +
                                              "  (select distinct rc.cd_Rec_Check_Check_Type from Records_Check rc, Person a " +
                                              "  where rc.id_rec_check_person = :personByIdRecCheckPerson " +
                                              "  and rc.id_rec_check_person = a.id_Person " +                               
                                              "  and (rc.dt_Rec_Check_Completed is not null and rc.dt_Rec_Check_Completed != :maxDate) " +
                                              "  and rc.cd_rec_check_check_type in ('BP','CF','DC','SC','GS','PS','IM','IC','SR','GH') " +
                                              "  )) = 10 THEN 'Y' " +
                                              "  else 'N' " +
                                              "  end) from Records_Check ");
    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return query.uniqueResult().toString();
  }
  
  /**
   * MR-072 Return Y if all the ten type of records check are done for person under 17 years of age who is principal or
   * member of PK household
   * @param personByIdRecCheckPerson
   * @return
   */
  public String findCompletedRecordsCheckByIdRecCheckPersonUnderAge17(int personByIdRecCheckPerson) {
    Query query = getSession().createSQLQuery("   select distinct (case when (select count(*) from " +
                                              "  (select distinct rc.cd_Rec_Check_Check_Type from Records_Check rc, Person a " +
                                              "  where rc.id_rec_check_person = :personByIdRecCheckPerson " +
                                              "  and rc.id_rec_check_person = a.id_Person " +                               
                                              "  and (rc.dt_Rec_Check_Completed is not null and rc.dt_Rec_Check_Completed != :maxDate) " +
                                              "  and rc.cd_rec_check_check_type in ('CF','SC','GS','PS','IM','IC','GH') " +
                                              "  )) = 7 THEN 'Y' " +
                                              "  else 'N' " +
                                              "  end) from Records_Check ");
    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return query.uniqueResult().toString();
  }
  
  /**
   * SMS 69955 Use new Records Check to see if records check are completed for submitting Safety REsource
   * @param personByIdRecCheckPerson
   * @return
   */
  public String findCompletedRecordsCheckNewCodesByIdRecCheckPerson(int personByIdRecCheckPerson) {
    Query query = getSession().createSQLQuery("   select distinct (case when (select count(*) from " +
                                              "  (select distinct rc.cd_Rec_Check_Check_Type from Records_Check rc " +
                                              "  where rc.id_rec_check_person = :personByIdRecCheckPerson " +
                                              "  and (rc.dt_Rec_Check_Completed is not null and rc.dt_Rec_Check_Completed != :maxDate) " +
                                              "  and rc.cd_rec_check_check_type in ('SC', 'CF', 'SR', 'DC', 'BP'))) = 5 THEN 'Y' " + "" +
                                              "  else 'N' " +
                                              "  end) from Records_Check ");
    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (String)query.uniqueResult().toString();
  }
  
  public RecordsCheck findLatestCompletedRecordsCheckByIdRecCheckPersonByCdRecCheckCheckType(int personByIdRecCheckPerson, String cdRecCheckCheckType) {
    Query query = getSession().createQuery("  from RecordsCheck rc " +
                                           "   where rc.personByIdRecCheckPerson.idPerson = :personByIdRecCheckPerson " +
                                           "   and (rc.dtRecCheckCompleted is not null " +
                                           "   and rc.dtRecCheckCompleted != :maxDate) " +
                                           "   and rc.cdRecCheckCheckType = :cdRecCheckCheckType " +
                                           "   order by rc.dtRecCheckCompleted desc");

    query.setInteger("personByIdRecCheckPerson", personByIdRecCheckPerson);
    query.setString("cdRecCheckCheckType", cdRecCheckCheckType);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (RecordsCheck) firstResult(query);
  }
  
}
