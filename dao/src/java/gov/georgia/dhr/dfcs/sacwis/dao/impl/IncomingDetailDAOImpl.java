package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;


/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 *   06/09/2011  Corey Harden      SMS#109631 findIncomingDetailProviderAllegByIdResource(int idResource)                         
 *                                 
 **/


public class IncomingDetailDAOImpl extends BaseDAOImpl implements IncomingDetailDAO {
  
  @SuppressWarnings("unchecked")
  public List<Map> findIncomingDetailProviderAllegByIdResource(int idResource){
    Query query = getSession().createQuery(
                                           "select new map(s.idStage as idStage, id.dtIncomingCall as dateOfCall, " +
                                                   "id.cdIncomingDisposition as disposition, s.cdStageScroutReason " +
                                                   "as screenOut, id.indIncmgMaltreatInCare as isMic, s.capsCase.nmCase as nmCase, " +
                                                   "s.capsCase.idCase as idCase) from IncomingFacility i, IncomingDetail id, Stage s " +
                                                   "where i.idStage = id.stage.idStage and id.stage.idStage = s.idStage " +
                                                   "and i.capsResource.idResource = :idResource " +
                                                   "order by id.dtIncomingCall desc ");

    query.setInteger("idResource", idResource);
    return (List<Map>) query.list();
  }
  
  public Date findIncomingDetailDtByIdStage(int idStage) {
    Query query = getSession().createQuery("select dtIncomingCall " +
                                           "  from IncomingDetail " +
                                           " where idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (Date) firstResult(query);
  }

  public IncomingDetail findIncomingDetailFromAnyIdStage(int idStage) {
    String cdStage = CodesTables.CSTAGES_INT;
    Query query = getSession().createQuery("select id " +
                                           "  from IncomingDetail id, " +
                                           "       Stage s1, " +
                                           "       Stage s2 " +
                                           " where s1.capsCase.idCase = s2.capsCase.idCase " +
                                           "   and s2.idStage = :idStage and s1.cdStage = :cdStage " +
                                           "   and s1.idStage = id.stage.idStage  " +
                                           "   and s1.dtStageStart = (select min(s3.dtStageStart) " +
                                           "                            from Stage s3" +
                                           "                            where s3.cdStage = s1.cdStage" +
                                           "                            and s3.capsCase.idCase in (s1.capsCase.idCase, s2.capsCase.idCase)" +
                                           "                          )" +
                                           " order by s2.dtStageStart asc");
    query.setInteger("idStage", idStage);
    query.setString("cdStage", cdStage);
    return (IncomingDetail) firstResult(query);
  }

  // SMS#49902 Added new method to get Incoming Detail corresponding to given INV stage
  public IncomingDetail findIncomingDetailFromINVIdStage(int idStage) {
    Query query = getSession().createQuery(
                                           "select id " + "  from IncomingDetail id, StageLink sl  "
                                                           + "  where sl.stageByIdPriorStage.idStage = id.idStage "
                                                           + "  and sl.stageByIdStage.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (IncomingDetail) firstResult(query);
  }
  
  public Date findIncomingDetailDtByIdCase(int idCase) {
    Query query = getSession().createQuery("select min(i.dtIncomingCall) " +
                                           "  from Stage s, " +
                                           "       IncomingDetail i " +
                                           " where s.capsCase.idCase = :idCase " +
                                           "   and s.cdStage = 'INT' " +
                                           "   and i.idStage = s.idStage");
    query.setInteger("idCase", idCase);
    return (Date) firstResult(query);
  }
  
  public Date findEarliestIncomingDetailDtByIdCase(int idCase) {
    Query query = getSession().createQuery("select max(i.dtIncomingCall) " +
                                           "  from Stage s, " +
                                           "       IncomingDetail i " +
                                           " where s.capsCase.idCase = :idCase " +
                                           "   and s.cdStage = 'INT' " +
                                           "   and i.idStage = s.idStage");
    query.setInteger("idCase", idCase);
    return (Date) firstResult(query);
  }

  public IncomingDetail findIncomingDetailByIdStage(int idStage) {
    Query query = getSession().createQuery(" from IncomingDetail " +
                                           "where idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (IncomingDetail) firstResult(query);
  }

  public Object[] findIncomingDetailAndDtEventOccurred(int idStage) {
    Query query = getSession().createQuery("         select i, " +
                                           "                e.dtEventOccurred, " +
                                           "                emp.cdEmpBjnEmp, " +
                                           "                s.txtStagePriorityCmnts " +
                                           "           from IncomingDetail i " +
                                           "left join fetch i.stage s " +
                                           "           join i.employee emp " +
                                           "      left join i.eventsForIdStage e " +
                                           "           with e.cdEventType = :cdEventType " +
                                           "          where i.idStage = :idStage " +
                                           // NOTE: This breaks DB-compatibility!!!! but is necessary to guarantee 1 row
                                           "            and rownum < 2");
    query.setString("cdEventType", CodesTables.CEVNTTYP_NOT);
    query.setInteger("idStage", idStage);
    // Hibernate bug HH-951 prevents us from limiting the number of results the normal way, but it's done manually
    // above, so this syntax is fine.
    List list = query.list();
    return (Object[]) (list.size() > 0 ? list.get(0) : null);
  }
/**
 * STGAP00009311 - Per Carina, Intake date incoming call and Intake id stage that should be returned so returning id stage 
 * from Incoming_Detail table instead of Stage_Link id prior stage to prevent id stage prior found but date incoming call 
 * returns null in case of Diversion progression to Investigation.
 */
  public Object[] findDtIncomingCallIdPriorStageByIdStage(int idStage) {
    SQLQuery query = getSession().createSQLQuery("SELECT I.DT_INCOMING_CALL, " +
                                                 "        I.ID_STAGE  " +
                                                 "  FROM STAGE_LINK L, " +
                                                 "       INCOMING_DETAIL I " +
                                                 " WHERE L.ID_PRIOR_STAGE = I.ID_STAGE " +
                                                 "   AND L.ID_STAGE  = :idStage");
    query.setInteger("idStage", idStage);
    query.addScalar("DT_INCOMING_CALL", Hibernate.DATE);
    query.addScalar("ID_STAGE", Hibernate.INTEGER);
    return (Object[]) firstResult(query);
  }

  public int updateIncomingDetailIndIncmgIntInvClsReclassByIdStage(int idStage, String indIncmgIntInvClsReclass) {
    Query query = getSession().createQuery("update IncomingDetail i " +
                                           "   set i.indIncmgIntInvClsReclass = :indIncmgIntInvClsReclass " +
                                           " where i.idStage = (select sl.stageByIdStage " +
                                           "                      from StageLink sl " +
                                           "                     where sl.stageByIdPriorStage.idStage = :idStage) ");
    query.setInteger("idStage", idStage);
    query.setString("indIncmgIntInvClsReclass", indIncmgIntInvClsReclass);
    return query.executeUpdate();
  }

  public int updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToY(int idStage) {
    Query query = getSession().createQuery("update IncomingDetail " +
                                           "   set indIncmgIntInvClsReclass = 'y'" +
                                           " where idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIncomingDetailIndIncmgIndIncmgIntInvClsReclassToN(int idStage) {
    Query query = getSession().createQuery("update IncomingDetail " +
                                           "   set indIncmgIntInvClsReclass = 'n'" +
                                           " where idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public void saveIncomingDetail(IncomingDetail incomingDetail) {
    getSession().saveOrUpdate(incomingDetail);
  }

  public int updateIncomingDetailIdEvent(int idStage) {
    Query query = getSession().createQuery("update IncomingDetail i " +
                                           "   set i.event.idEvent = null " +
                                           " where i.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIncomingDetail(String cdIncmgStatus, int idStage, Date dtLastUpdate) {
    Query query = getSession().createQuery("update IncomingDetail i " +
                                           "   set i.cdIncmgStatus = :cdIncmgStatus " +
                                           " where i.idStage = :idStage " +
                                           "   and i.dtLastUpdate = :dtLastUpdate ");
    query.setString("cdIncmgStatus", cdIncmgStatus);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
  
  
  public int updateIncomingDetailStatus(String cdIncmgStatus, int idStage) {
    Query query = getSession().createQuery("update IncomingDetail i " +
                                           "   set i.cdIncmgStatus = :cdIncmgStatus " +
                                           " where i.idStage = :idStage ");
    query.setString("cdIncmgStatus", cdIncmgStatus);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
  // Added for STGAP00008086
  public int updateIncomingDetailDisposition(String cdIncomingDisposition, int idStage, Date dtLastUpdate) {
    Query query = getSession().createQuery("update IncomingDetail i " +
                                           "   set i.cdIncomingDisposition = :cdIncomingDisposition " +
                                           " where i.idStage = :idStage " +
                                           "   and i.dtLastUpdate = :dtLastUpdate ");
    query.setString("cdIncomingDisposition", cdIncomingDisposition);
    query.setInteger("idStage", idStage);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }
  
  public int updateIncomingDtlMaltreatInCare(int idStage, String indIncmgMaltreatInCare) {
    Query query = getSession().createQuery("update IncomingDetail i " +
                                           "   set i.indIncmgMaltreatInCare = :indIncmgMaltreatInCare " +
                                           " where i.idStage = :idStage ");
    query.setString("indIncmgMaltreatInCare", indIncmgMaltreatInCare);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int deleteIncomingDetail(int idStage) {
    SQLQuery query = getSession().createSQLQuery("CALL COMPLEX_DELETE.DELETE_INCOMING_DETAIL(:idStage)");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findIncomingDetailByIdStage(int pageNbr, int pageSize, int idStage) {
    Query query = getSession().createQuery(
            "select distinct new map(a.nmIncomingCallerFirst as nmIncomingCallerFirst, " +
            "                        a.nmIncomingCallerMiddle as nmIncomingCallerMiddle, " +
            "                        a.nmIncomingCallerLast as nmIncomingCallerLast, " +
            "                        a.cdIncomingDisposition as cdIncomingDisposition, " +
            "                        a.dtIncomingCall as dtIncomingCall, " +
            "                        a.cdIncomingCallerCounty as cdIncomingCallerCounty, " +
            "                        a.addrIncomingCallerCity as addrIncomingCallerCity, " +
            "                        a.nmIncmgWorkerName as nmIncmgWorkerName, " +
            "                        a.idStage as idStage, " +
            "                        a.employee.idPerson as idIncomingWorker, " +
            "                        a.indIncmgSensitive as indIncmgSensitive, " +
            "                        a.indIncmgIntInvClsReclass as indIncmgIntInvClsReclass) " +
            "  from IncomingDetail a " +
            " where a.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<IncomingDetail> findPriorScreenedOutIncomingDtlsByidPerson(int idPerson, Date dtPriorInt) {

    Query query = getSession().createQuery(" select id from IncomingDetail id " +
                                             "  join id.stage s " +
                                             "  join s.stagePersonLinks spl  " +
                                             "  where  spl.person.idPerson = :idPerson "  +
                                             "  and id.dtIncomingCall < :dtPriorInt "  +
                                             "   and id.cdIncomingDisposition in ( 'SCO' , 'SCR')"  +
                                             "      order by id.idStage " );
    
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtPriorInt", dtPriorInt);

    return (List<IncomingDetail>) query.list();
  }
  
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findPriorScreenedOutIncomingDtlsByidPersons(List<Integer> idPersons, Date dtPriorInt) {

    Query query = getSession().createQuery(" select distinct s.idStage "    +
                                             "  from  Stage s,IncomingDetail id, StagePersonLink spl " +
                                             "  where  spl.person.idPerson in (:idPersons) "  +
                                             "  and id.idStage = s.idStage " +
                                             "  and s.idStage =  spl.stage.idStage  "  +
                                             "  and id.idStage = spl.stage.idStage  "  +
                                             "  and id.dtIncomingCall < :dtPriorInt "  +
                                             "  and id.cdIncomingDisposition in ( 'SCO' , 'SCR')"  +
                                             "  order by s.idStage " );
    
    query.setParameterList("idPersons", idPersons);
    query.setTimestamp("dtPriorInt", dtPriorInt);

    return (List<Integer>) query.list();
  }
  

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIncomingDetailStageByIdPerson(Collection<Integer> idPersons) {
    Query query = getSession().createQuery("select a.idStage from IncomingDetail a, Name n " +
                                           " where n.person.idPerson in (:idPersons ) " +
                                           "   and a.nmIncomingCallerFirst = n.nmNameFirst " +
                                           "   and (a.nmIncomingCallerMiddle  = n.nmNameMiddle " +
                                           "        or n.nmNameMiddle is null ) " +
                                           "   and a.nmIncomingCallerLast  = n.nmNameLast");
    query.setParameterList("idPersons", idPersons);
    return (List<Integer>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIncomingDetailStageByNmFirstNmLast(String nmFirst, String nmLast) {
    Query query = getSession().createQuery("select a.idStage from IncomingDetail a " +
                                           " where a.nmIncomingCallerFirst = :nmFirst " +
                                           "   and a.nmIncomingCallerLast  = :nmLast");
    query.setString("nmFirst", nmFirst);
    query.setString("nmLast", nmLast);
    return (List<Integer>) query.list();
  }
 
  /**
   * STGAP00009311 - Find Intake date from the associated Intake of the Investigation stage as follow:
   * If prior stage is Intake then select incoming call date; Else it must be Diversion, then select date incoming call from
   * the Intake stage preceding the Diversion stage
   */
  public Date findDtIncomingCallByIdInvStage(int idStage) {
    SQLQuery query = getSession().createSQLQuery("SELECT NVL(id.DT_INCOMING_CALL, (select inc_detail2.DT_INCOMING_CALL " +
                                                 " from stage_link div_stage_link, incoming_detail inc_detail2, stage div_stage " +
                                                 " where div_stage_link.ID_PRIOR_STAGE = inc_detail2.ID_STAGE " +
                                                 " and div_stage_link.ID_STAGE = prior_stage.ID_STAGE " +
                                                 " and div_stage.ID_STAGE = prior_stage.ID_STAGE and div_stage.CD_STAGE = 'DIV' " +
                                                 " )) as intake_date " +
                                                 "FROM cps_invst_detail cid, " +
                                                 "     stage_link sl, " +
                                                 "     incoming_detail id, " +
                                                 "     stage prior_stage " +
                                                 "WHERE cid.id_cps_invst_stage = sl.ID_STAGE " +
                                                 " and sl.ID_PRIOR_STAGE = prior_stage.ID_STAGE " +
                                                 " and prior_stage.ID_STAGE = id.ID_STAGE(+) " +
                                                 " and sl.id_stage = :idStage");
    query.setInteger("idStage", idStage);
    query.addScalar("intake_date", Hibernate.TIMESTAMP);
    Date intakeDate = (Date)firstResult(query);
    if (!DateHelper.isNull(intakeDate)) {
      return intakeDate;
    }
    return null;
  }
  
  public Integer findIncomingDetailResourceIdIsInExchangeHome(int idStage){
    Query query = getSession().createQuery(
                                           "select ids.capsResource.idResource " 
                                           + " from IncomingDetail ids, ExchangeHome eh " 
                                           + " where ids.capsResource.idResource = eh.capsResource.idResource "
                                           + " and ids.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    Integer idResource = (Integer) firstResult(query);
    if (!(idResource==null)){
      return idResource;
    }
    return 0;    
  }
}
