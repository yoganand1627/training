package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.OutputLaunchEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 10/11/11  hnguyen                  STGAP00017012: MR-094 Added new method findCurrentVisitationPlansByIdPersonByIdCase.
 * 10/11/11  hnguyen                  STGAP00017012: MR-094 Added new method findCurrentVisitationPlansForOpenStageByIdPersonByIdCase
 *                                    and also update findCurrentVisitationPlansByIdPersonByIdCase to findCurrentVisitationPlansByIdPersonByIdStage.
 * </pre>
 *
 */

public class OutputLaunchEventLinkDAOImpl extends BaseDAOImpl implements OutputLaunchEventLinkDAO {

  public OutputLaunchEventLink findOutputLaunchEventLink(int idEvent) {
    Query query = getSession().createQuery(" from OutputLaunchEventLink ol " +
                                           "where ol.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (OutputLaunchEventLink) firstResult(query);
  }

  public void saveOutputLaunchEventLink(OutputLaunchEventLink outputLaunchEventLink) {
    getSession().saveOrUpdate(outputLaunchEventLink);
  }
  
  public int deleteOutputLaunchEventLink(int idEvent) {
    Query query = getSession().createQuery(   " delete from OutputLaunchEventLink ol " +
                                              " where ol.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  /*
   * MR-094 This particular method retrieves visitation plans for both closed and open FCC stage. Retrieving all 
   * current visitation plans associated with child single CLOSED or OPEN foster care episode.
   */
  @SuppressWarnings("unchecked")
  public List<OutputLaunchEventLink> findCurrentVisitationPlansByIdPersonByIdStage(int idPerson, int idStage) {
    Query query = getSession().createQuery(" select op from OutputLaunchEventLink op, StagePersonLink spl " +
                                           // current visitation in FCC
                                           " where ((op.event.stage.idStage = :idStage "+
                                           "   and op.event.stage.cdStage ='SUB') "+
                                           // or current visitation in ADO that progressed from FCC id stage
                                           " or (op.event.stage.cdStage = 'ADO' " +
                                           "   and op.event.stage.idStage in (" +
                                           "      select sl.stageByIdStage.idStage "+
                                           "      from StageLink sl "+
                                           "      where sl.stageByIdPriorStage.idStage = :idStage "+
                                           "      and sl.stageByIdPriorStage.cdStage = 'SUB' ) "+
                                           "   )) "+
                                           " and op.event.cdEventType='VIS' "+
                                           " and op.event.cdEventStatus in ('COMP', 'APRV') "+
                                           " and op.indCurrent='Y' "+
                                           " and op.event.stage.idStage = spl.stage.idStage "+
                                           " and spl.cdStagePersRole='PC' "+
                                           " and spl.person.idPerson=:idPerson ");
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (List<OutputLaunchEventLink>) query.list();
  }

  /*
   * MR-094 This particular method retrieve current visitation plans for OPEN FCC and/or ADO stage.
   */
  @SuppressWarnings("unchecked")
  public List<OutputLaunchEventLink> findCurrentVisitationPlansForOpenStageByIdPersonByIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery(" select op from OutputLaunchEventLink op, StagePersonLink spl " +
                                           " where op.event.capsCase.idCase = :idCase "+
                                           " and op.event.cdEventType='VIS' "+
                                           " and op.event.cdEventStatus in ('COMP', 'APRV') "+
                                           " and op.indCurrent='Y' "+
                                           " and op.event.stage.cdStage in ('SUB', 'ADO') "+
                                           " and op.event.stage.idStage = spl.stage.idStage "+
                                           " and spl.stage.dtStageClose is null "+
                                           " and spl.cdStagePersRole='PC' "+
                                           " and spl.person.idPerson=:idPerson ");
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (List<OutputLaunchEventLink>) query.list();
  }

  
}
