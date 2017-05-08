package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ExamDetail;

import java.util.List;
/*
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  3/23/2007 htvo      Added method findExamsByIdPersonIndGed()
 *  3/28/2007  htvo     Rename file from ExamDAOImpl to ExamDetailDAOImpl
 * 
 */

/**
 * @author nandita.hegde
 * 
 */

public interface ExamDetailDAO {
  /**
   * Find all exams taken by a person given the person's id and exams' category (GED or HS for Georgia highschool
   * graduation)
   * 
   * @param idPerson
   * @param indGed
   *          (take values "Y": GED esxam or "N": highschool graduation exam)
   * @return
   */
  public List<ExamDetail> findExamsByIdPersonIndGed(int idPerson, String indGed);

  /**
   * Retrieves all exam details Info from the exam_detail table given exam detail id. <p/>
   * 
   * @param idExamDetail
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  ExamDetail findExamDetailsOnId(int idExamDetail);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ExamDetail} object to the database.
   * 
   * @param ExamDetail
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ExamDetail} object.
   */
  void saveExamDetails(ExamDetail examDetail);

}
