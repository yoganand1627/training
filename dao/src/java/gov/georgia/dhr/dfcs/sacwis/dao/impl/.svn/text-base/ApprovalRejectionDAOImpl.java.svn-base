package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ApprovalRejection;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------   
 *  07/23/2009  bgehlot  STGAP00014341: Added method deleteApprovalRejectionsByIdStageCdTask
 *  11/18/2009  arege    SMS#38675: Added method deleteApprovalRejectionsByIdStageCdTask
 * </pre>
 */

public class ApprovalRejectionDAOImpl extends BaseDAOImpl implements ApprovalRejectionDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findApprovalRejectionByIdCaseIdStage(int idCase, int idStage) {

    Query query = getSession().createQuery(" select new map(b.nmPersonFull as nmPersonFull, " +
                                           "                a.idApprovalRejection as idApprovalRejection, " +
                                           "                a.person.idPerson as idPerson, " +
                                           "                a.approval.idApproval as idApproval, " +
                                           "                a.dtRejection as dtRejection, " +
                                           "                a.indApsEffort as indApsEffort, " +
                                           "                a.indProblems as indProblems, " +
                                           "                a.indEvidence as indEvidence, " +
                                           "                a.indMissingEvidRptr as indMissingEvidRptr, " +
                                           "                a.indMissingEvidAp as indMissingEvidAp, " +
                                           "                a.indMissingEvidMp as indMissingEvidMp, " +
                                           "                a.indMissingEvidCol as indMissingEvidCol, " +
                                           "                a.indMissingEvidPhotos as indMissingEvidPhotos, " +
                                           "                a.indMissingEvidDe as indMissingEvidDe, " +
                                           "                a.indMissingEvidOth as indMissingEvidOth, " +
                                           "                a.indDiscretionary as indDiscretionary, " +
                                           "                a.txtApproversCmnts as txtApproversCmnts) " +
                                           "     from ApprovalRejection a join a.person b " +
                                           "    where a.capsCase.idCase = :idCase " +
                                           "      and a.stage.idStage = :idStage " +
                                           " order by a.idApprovalRejection ");

    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findApprovalRejectionByIdCaseIdStageAndIdApproval(int idCase, int idStage, int idApproval) {

    Query query = getSession().createQuery(" select new map(b.nmPersonFull as nmPersonFull, " +
                                           "                a.idApprovalRejection as idApprovalRejection, " +
                                           "                a.person.idPerson as idPerson, " +
                                           "                a.approval.idApproval as idApproval, " +
                                           "                a.dtRejection as dtRejection, " +
                                           "                a.indApsEffort as indApsEffort, " +
                                           "                a.indProblems as indProblems, " +
                                           "                a.indEvidence as indEvidence, " +
                                           "                a.indMissingEvidRptr as indMissingEvidRptr, " +
                                           "                a.indMissingEvidAp as indMissingEvidAp, " +
                                           "                a.indMissingEvidMp as indMissingEvidMp, " +
                                           "                a.indMissingEvidCol as indMissingEvidCol, " +
                                           "                a.indMissingEvidPhotos as indMissingEvidPhotos, " +
                                           "                a.indMissingEvidDe as indMissingEvidDe, " +
                                           "                a.indMissingEvidOth as indMissingEvidOth, " +
                                           "                a.indDiscretionary as indDiscretionary, " +
                                           "                a.txtApproversCmnts as txtApproversCmnts) " +
                                           "     from ApprovalRejection a join a.person b join a.approval app" +
                                           "    where a.capsCase.idCase = :idCase " +
                                           "      and a.stage.idStage = :idStage " +
                                           "      and app.idApproval = :idApproval " +
                                           " order by a.idApprovalRejection ");

    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setInteger("idApproval", idApproval);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<ApprovalRejection> findApprovalRejectionByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from ApprovalRejection ar " +
                                           "where ar.approval.idApproval in " +
                                           "   (select ael.approval.idApproval " +
                                           "      from ApprovalEventLink ael " +
                                           "     where ael.event.idEvent = :idEvent) " +
                                           "order by ar.idApprovalRejection");
    query.setInteger("idEvent", idEvent);
    return (List<ApprovalRejection>) query.list();
  }
  
  public int deleteApprovalRejectionByIdApproval(Collection<Integer> idApprovalList) {
    Query query = getSession().createQuery("delete ApprovalRejection ar" +
                                           " where ar.approval.idApproval in (:idApprovalList) ");
    query.setParameterList("idApprovalList", idApprovalList);
    return query.executeUpdate();
  }
  
  public int deleteApprovalRejectionByIdApproval(int idApproval) {
    Query query = getSession().createQuery("delete ApprovalRejection ar " +
                                           " where ar.approval.idApproval = :idApproval");
    query.setInteger("idApproval", idApproval);
    return query.executeUpdate();
  }
  
  public void saveApprovalRejection(ApprovalRejection approvalRejection) {
    getSession().saveOrUpdate(approvalRejection);
  }
  
  //STGAP00014341: Delete Approval rejections for the stage and task
  public int deleteApprovalRejectionsByIdStageCdTask(int idStage, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from approval_rejection where id_approval in " +
                                                 " (select id_approval from approval_event_link " +
                                                 "where id_event in (select id_event from caps.event where " +
                                                 "cd_event_type = :cdEventType and cd_task = :cdTask and id_event_stage= :idStage))" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();
  }
  
  //SMS#38675: Delete Approval rejections for the SUB, FPR and FSU stage and task
  public int deleteApprovalRejections(int idStage, String cdTask) {
    SQLQuery query = getSession().createSQLQuery("delete from approval_rejection where id_approval in " +
                                                 " (select id_event from caps.event where " +
                                                 "cd_event_type = :cdEventType and cd_task = :cdTask and id_event_stage= :idStage)" );
    query.setInteger("idStage", idStage);
    query.setString("cdTask", cdTask);
    query.setString("cdEventType", CodesTables.CEVNTTYP_APP);
    return query.executeUpdate();
  }
}
