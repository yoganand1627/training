/**
 * Created on March 11 2009 by Bhavna Gehlot
 */
package gov.georgia.dhr.dfcs.sacwis.dao;


import gov.georgia.dhr.dfcs.sacwis.db.CaseReview;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewCateg;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewCbxResponse;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewItem;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewQuesResponse;

import java.util.List;
import java.util.Map;

public interface CaseReviewDAO {
  /**
   * This selects a row from CASE_REVIEW_CATEG_LOOKUP , 
                             CASE_REVIEW_ITEM_LOOKUP CRIL, 
                             CASE_REVIEW_QUES_LOOKUP CRQL for the survey code and survey type.
   * @param cdSurveyCode  , cdSurveyType , cdSurveyQuestionType
   * @return List<Map<Object, Object>>
   */
  List<Map<String, Object>> findCaseReviewQuestions(String cdSurveyCode, String cdSurveyType, String cdSurveyQuestionType, int maxVersion);
  
  /**
   * This selects a row from case_review given id_event. <p/>
   *
   * @param idEvent
   * @return
   */
  CaseReview findCaseReviewByIdEvent(int idEvent);
  
  
  /**
   * This selects a list from different case review tables . <p/>
   *
   * @param cdStage, idEvent
   * @return List<Map<String, Object>>
   */
  List<Map<String, Object>> findCaseReviewDetails(int idStage, int idEvent);
  
  /**
   * This retrieves the check boxes from the question
   * @param cdQuestion, cdVersion
   */
  List<Map<String, Object>> findCheckboxbyCdQuestionLookup(String cdQuestion, int cdVersion);
  
  /**
   * This retrieves the check boxes from the question
   * @param cdQuestion, cdVersion
   */
  List<Map<String, Object>> findCheckboxbyCdQuestion(String cdQuestion, int cdVersion, int idEvent);
 
  /**
   * This saves the info in Case Review Table
   * @param caseReview
   */
  void saveCaseReview(CaseReview caseReview);
  
  /**
   * This saves the info in CaseReviewCateg Table
   * @param caseReviewCateg
   */
  int saveCaseReviewCateg(CaseReviewCateg caseReviewCateg);
  
  /**
   * This saves the info in CaseReviewItem Table
   * @param caseReviewItem
   */
  int saveCaseReviewItem(CaseReviewItem caseReviewItem);
  
  /**
   * This saves the info in CaseReviewQuestions Table
   * @param caseReviewQuestions
   */
  void saveCaseReviewQuestions(CaseReviewQuesResponse caseReviewQuesResponse);
  
  /**
   * This saves the info in Case Review Cbx Response Table
   * @param caseReviewCbxResponse
   */
  void saveCaseReviewCbxResponse(CaseReviewCbxResponse caseReviewCbxResponse);
  
  int updateCaseReviewCateg(String cdCategory, int idCaseReviewCateg);
  
  int updateCaseReviewItem(String txtComments, int idCaseReviewItem);
  
  void updateCaseReviewQuestion(String cdQuesResponse, int idCaseReviewQuestion);
  
  /**
   * This deletes the info from Case Review Cbx Response Table
   * @param cdQuestion cdVersion idEvent
   */
  void deleteCaseReviewChkBxByCdQuestion(String cdQuestion, int cdVersion, int idEvent);
  
  /**
   * This deletes the case review record.
   * @param idEvent
   * @return int
   */
  int deleteCaseReviewByIdEvent(int idEvent);
  
  /**
   * This deletes the case review categ record.
   * @param idEvent
   * @return int
   */
  int deleteCaseReviewCategByIdEvent(int idEvent);
  
  /**
   * This deletes the case review item record.
   * @param idEvent
   * @return int
   */
  int deleteCaseReviewItemByIdEvent(int idEvent);
  
  
  /**
   * This deletes the case review ques response record.
   * @param idEvent
   * @return int
   */
  int deleteCaseReviewQuesResponseByIdEvent(int idEvent);
  
  
  /**
   * This deletes the case review cbx response record.
   * @param idEvent
   * @return int
   */
  int deleteCaseReviewCbxResponseByIdEvent(int idEvent);  

}
