/**
 * Created on Mar 25, 2006 at 1:38:53 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;
/**
 * 
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------    --------  --------------------------------------------------
 *  09/24/2008  arege     Modified methods and method names for  findAdminReviewByIdStageIdPersonDtMaxDate()
 *                        ,findAdminReviewByIdStageDtMaxDate to findAdminReviewByIdStageIdPerson() 
 *                        , findAdminReviewByIdStageDtStageClose() respectively. Now, the code in CloseOpenStageImpl
 *                        does not enter a MAX_JAVA_DATE in the Dt_Stage_Close field of Stage table when creating
 *                        New 'ARI' stage.
 *  
 *  
 **/


public interface AdminReviewDAO {
  /**
   * This selects a row from AdminReview given the idStage, idPerson  <p/>
   *
   * @param idStage
   * @param idPerson
   * @return Integer
   */
  Integer findAdminReviewByIdStageIdPerson(int idStage, int idPerson);

  /**
   * This selects a row from AdminReview given the idStage. <p/>
   *
   * @param idStage
   * @return AdminReview
   */
  Integer findAdminReviewByIdStageDtStageClose(int idStage);

  /**
   * This selects a row from AdminReview given the idStage. <p/>
   *
   * @param idStage
   * @return AdminReview by idStage
   */
  AdminReview findAdminReviewByIdStage(int idStage);

  /**
   * This selects a row from AdminReview given the idEvent. <p/>
   *
   * @param idEvent
   * @return AdminReview
   */
  AdminReview findAdminReviewByIdEvent(int idEvent);

  /**
   * Returns a count of the Admin Review records that are assoicated with an idStage. <p/>
   *
   * @param idStage
   * @return Integer
   */
  long countAdminReviewByIdStage(int idStage);
  
  /**
   * Returns a list of the Admin Review records that are associated with the case and requestor. <p/>
   *
   * @param idCase
   * @param idPerson
   * @return List<AdminReview>
   */
  List<AdminReview> retrievePrior1lvlAdminReviews(int idCase, int idPerson);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.AdminReview} object to the database.
   *
   * @param adminReview A populated {@link gov.georgia.dhr.dfcs.sacwis.db.AdminReview} object.
   */
  void saveAdminReview(AdminReview adminReview);
}
