package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApprovalEventLinkByIdStageCdTask
 * </pre>
 */

public class ApprovalEventLinkDAOImpl extends BaseDAOImpl implements ApprovalEventLinkDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findRelatedFunctionalEventsForGivenApproval(int idApprovers) {

    Query query = getSession().createQuery(" select new map(a.event.idEvent as idEvent, " +
                                           "        a.event.cdTask as cdTask) " +
                                           "   from ApprovalEventLink a " +
                                           "  where a.approval.idApproval = :idApprovers ");

    query.setInteger("idApprovers", idApprovers);

    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findApprovalsforCaseEvent(int idEvent) {

    // DO NOT alter the order of the select list, it will affect service
    // dependencies. Add to the end of the select
    // clause to safely change.
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 " select p.nm_person_full, "
                                                                 + " ap.dt_approvers_determination, "
                                                                 + " ap.cd_approvers_status, "
                                                                 + " ap.txt_approvers_cmnts "
                                                                 + " from approval_event_link ael, approvers ap,  person p "
                                                                 + " where ael.id_approval = ap.id_approval "
                                                                 + " and ap.id_person = p.id_person "
                                                                 + " and ael.id_event = :idEvent "
                                                                 + " order by ap.cd_approvers_status, ap.dt_approvers_determination ");

    query.setInteger("idEvent", idEvent);

    // Set the scalar values to optimize query access
    // the fields must be in the same order as the select clause
    query.addScalar("nm_person_full", Hibernate.STRING);
    query.addScalar("dt_approvers_determination", Hibernate.TIMESTAMP);
    query.addScalar("cd_approvers_status", Hibernate.STRING);
    query.addScalar("txt_approvers_cmnts", Hibernate.STRING);

    return (List<Object[]>) query.list();
  }  
  
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findApprovalEventLinksByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select new map(a.approval.idApproval as idApproval, " +
                                           "        ap.cdApproversStatus as cdApproversStatus) " +
                                           "   from ApprovalEventLink a, Approvers ap " +
                                           "  where a.event.idEvent = :idEvent " +
                                           "  and a.approval.idApproval = ap.approval.idApproval");
    query.setInteger("idEvent", idEvent);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdApprovalEventLinksByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select a.approval.idApproval " +
                                           "   from ApprovalEventLink a " +
                                           "  where a.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (List<Integer>) query.list();
  }

  public Integer findApprovalEventLinkByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select a.approval.idApproval " +
                                           "   from ApprovalEventLink a " +
                                           "  where a.event.idEvent = :idEvent " +
                                           "  order by a.dtLastUpdate desc ");

    query.setInteger("idEvent", idEvent);

    return (Integer) firstResult(query);
  }
  
  public Integer findActiveIdApprovalByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select ael.approval.idApproval " +
                                           "   from ApprovalEventLink ael, Approvers ap " +
                                           "  where ael.event.idEvent = :idEvent " +
                                           "  and ael.approval.idApproval = ap.approval.idApproval " +
                                           "  and ap.cdApproversStatus = :cdPendApproversStatus");

    query.setInteger("idEvent", idEvent);
    query.setString("cdPendApproversStatus", CodesTables.CAPPDESG_PEND);
    return (Integer) firstResult(query);
  }
  
  public Integer findInvalidIdApprovalByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select ael.approval.idApproval " +
                                           "   from ApprovalEventLink ael, Approvers ap " +
                                           "  where ael.event.idEvent = :idEvent " +
                                           "  and ael.approval.idApproval = ap.approval.idApproval " +
                                           "  and ap.cdApproversStatus = :cdPendApproversStatus");

    query.setInteger("idEvent", idEvent);
    query.setString("cdPendApproversStatus", CodesTables.CAPPDESG_INVD);
    return (Integer) firstResult(query);
  }
  
  public Integer findEventByIdApprovalEvent(int idApprovalEvent) {
    Query query = getSession().createQuery(" select a.event.idEvent " +
                                           "   from ApprovalEventLink a " +
                                           "  where a.idApprovalEvent = :idApprovalEvent ");

    query.setInteger("idApprovalEvent", idApprovalEvent);

    return (Integer) firstResult(query);
  }
  
  
  

  public int insertApprovalEventLink(int idEvent, int idApproval) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO APPROVAL_EVENT_LINK " +
                                                 "             (ID_EVENT, " +
                                                 "              ID_APPROVAL, " +
                                                 "              ID_APPROVAL_EVENT) " +
                                                 " VALUES (:idEvent, " +
                                                 "         :idApproval, " +
                                                 "         SEQ_APPROVAL_EVENT_LINK.NEXTVAL)");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idApproval", idApproval);

    return query.executeUpdate();
  }

  public int deleteApprovalEventLinkByIdApproval(int idApproval) {
    Query query = getSession().createQuery("delete ApprovalEventLink" +
                                           "  where approval.idApproval = :idApproval");
    query.setInteger("idApproval", idApproval);
    return query.executeUpdate();
  }

  public int deleteApprovalEventLinkByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from ApprovalEventLink" +
                                           "       where event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();

  }
 
  //STGAP00010749: Insert an approval event link record
  public int insertNewApprovalEventLink(int idEvent, int idApproval, int idCase) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO APPROVAL_EVENT_LINK " +
                                                 "             (ID_EVENT, " +
                                                 "              ID_APPROVAL, " +
                                                 "              ID_CASE, " +
                                                 "              ID_APPROVAL_EVENT) " +
                                                 " VALUES (:idEvent, " +
                                                 "         :idApproval, " +
                                                 "         :idCase, " +
                                                 "         SEQ_APPROVAL_EVENT_LINK.NEXTVAL)");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idCase", idCase);
    query.setInteger("idApproval", idApproval);

    return query.executeUpdate();
  }
  
  //STGAP00014341: Delete Approval event link records for the stage and task
  public int deleteApprovalEventLinkByIdStageCdTask(int idStage, String cdEventType, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from caps.approval_event_link where id_event in " +
                                                 " (select id_event from caps.event where cd_event_type = :cdEventType  " +
                                                 "and cd_task = :cdTask and id_event_stage = :idStage)" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", cdEventType);
    return query.executeUpdate();
  }
}
