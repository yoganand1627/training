/**
 * Created on Mar 25, 2006 at 2:48:40 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface FacilAllegPriorReviewDAO {
  /**
   * Inserts a row into Facil_Alleg_Prior_Review
   *
   * @param idAllegation
   * @param idReviewStage
   * @param idReviewVictim
   * @param idReviewAllegedPerp
   * @param cdReviewAllegType
   * @param cdReviewAllegDisp
   * @param cdReviewAllegDispSupr
   * @param cdReviewAllegClss
   * @param cdReviewAllegClssSupr
   * @return
   */
  int insertFacilAllegPriorReview(int idAllegation,
                                  int idReviewStage,
                                  int idReviewVictim,
                                  int idReviewAllegedPerp,
                                  String cdReviewAllegType,
                                  String cdReviewAllegDisp,
                                  String cdReviewAllegDispSupr,
                                  String cdReviewAllegClss,
                                  String cdReviewAllegClssSupr);

  /**
   * Delete rows from FacilAllegPriorReview based on ID_REVIEW_STAGE.
   *
   * @param idStage
   * @return
   */
  int deleteFacilAllegPriorReviewByIdStage(int idStage);
}
