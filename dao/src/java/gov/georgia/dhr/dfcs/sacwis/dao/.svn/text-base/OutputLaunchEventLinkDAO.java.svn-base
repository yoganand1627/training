package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;

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

public interface OutputLaunchEventLinkDAO {

  /**
   * Return outputLaunch record
   *
   * @param idEvent
   * @return Date
   */
  OutputLaunchEventLink findOutputLaunchEventLink(int idEvent);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink} object to the database.
   *
   * @param outputLaunchEventLink A populated {@link gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink} object.
   */
  void saveOutputLaunchEventLink(OutputLaunchEventLink outputLaunchEventLink);
  
  /**
   * 
   * @param idEvent
   * @return
   */
  public int deleteOutputLaunchEventLink(int idEvent);
  
  /**
   * Retrieve list of OutputLaunchEventLink where event is a COMP or APRV visitation plan 
   * and is marked current for specified primary child in specified stage
   *
   * @param idPerson
   * @param idStage
   * @return java.util.List<OutputLaunchEventLink>
   */
  List<OutputLaunchEventLink> findCurrentVisitationPlansByIdPersonByIdStage(int idPerson,int idStage);

  /**
   * Retrieve list of OutputLaunchEventLink where event is a COMP or APRV visitation plan 
   * and is marked current for specified primary child in specified case with open FCC or ADO stage
   * for the child.
   *
   * @param idPerson
   * @param idCase
   * @return java.util.List<OutputLaunchEventLink>
   */
  List<OutputLaunchEventLink> findCurrentVisitationPlansForOpenStageByIdPersonByIdCase(int idPerson,int idCase);
}
