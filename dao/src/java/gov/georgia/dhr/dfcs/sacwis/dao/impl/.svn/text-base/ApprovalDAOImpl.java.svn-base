package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approval;

import java.util.Collection;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApprovalsByIdStageCdTask, deleteApprovals
 * </pre>
 */

public class ApprovalDAOImpl extends BaseDAOImpl implements ApprovalDAO {
  @SuppressWarnings({"unchecked"})
  public Map findApprovalInfoForHeader(int idApproval) {

    Query query = getSession().createQuery(" select new map(a.person.idPerson as idPerson, " +
                                           "                a.person.nmPersonFull as nmPersonFull, " +
                                           "                a.txtApprovalTopic as txtApprovalTopic) " +
                                           "   from Approval a " +
                                           "  where a.idApproval = :idApproval ");

    query.setInteger("idApproval", idApproval);

    return (Map) firstResult(query);
  }

  public int insertApproval(int idApproval, int idPerson, String cdTxtApprovalTopic) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO APPROVAL " +
                                                 "       (TXT_APPROVAL_TOPIC, " +
                                                 "        ID_APPROVAL_PERSON, " +
                                                 "        ID_APPROVAL) " +
                                                 " VALUES (:cdTxtApprovalTopic, " +
                                                 "        :idPerson, " +
                                                 "        :idApproval)");

    query.setInteger("idApproval", idApproval);
    query.setInteger("idPerson", idPerson);
    query.setString("cdTxtApprovalTopic", cdTxtApprovalTopic);

    return query.executeUpdate();
  }
  
  public int deleteApprovalByIdApproval(Collection<Integer> idApprovalList) {
    Query query = getSession().createQuery("delete Approval a " +
                                           " where a.idApproval in (:idApprovalList) ");
    query.setParameterList("idApprovalList", idApprovalList);
    return query.executeUpdate();
  }

  public int deleteApprovalByIdApproval(int idApproval) {
    Query query = getSession().createQuery("delete from Approval" +
                                           "  where idApproval = :idApproval");

    query.setInteger("idApproval", idApproval);

    return query.executeUpdate();
  }
  
  //STGAP00010749: Save or update the Approval record
  public int saveApproval(Approval approval) {
    getSession().saveOrUpdate(approval);
    return approval.getIdApproval();
  } 
  
  //STGAP00014341: Delete Approvals for the stage and task
  public int deleteApprovalsByIdStageCdTask(int idStage, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from approval where id_approval in " +
                                                 " (select id_approval from approval_event_link " +
                                                 "where id_event in (select id_event from caps.event where " +
                                                 "cd_event_type = :cdEventType and cd_task = :cdTask and id_event_stage= :idStage))" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();
  }
  
  //STGAP00014341: Delete Approvals for the stage and task
  public int deleteApprovals(int idStage, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from approval where id_approval in " +
                                                 " (select id_event from caps.event where " +
                                                 "cd_event_type = :cdEventType and cd_task = :cdTask and id_event_stage= :idStage)" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();
  }
}
