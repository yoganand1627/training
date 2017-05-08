package gov.georgia.dhr.dfcs.sacwis.service.document;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CpsAdminReviewDecisionLetterFormSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CpsAdminReviewDecisionLetterFormSO;

/**
 * Response To Case Review Request Form interface 
 * <pre>
 * Change History:
 *  Date        User       Description
 *  --------    --------   ------------------------------------------------------------
 *  02/16/2010  hnguyen    CPS Administrative Review Decision Letter Form added
 * </pre>
 *
 */

public interface CpsAdminReviewDecisionLetterForm extends DocumentService {

  // Template name
  public static final String ADMINMEMO = "adminmemo";  
  
  // Other in-line bookmarks throughout the form
  public static final String DATE_GENERATED = "DATE_GENERATED";

  public static final String REQUESTOR_NAME = "REQUESTOR_NAME";
  public static final String REQUESTOR_ADDR_LN1 = "REQUESTOR_ADDR_LN1";
  public static final String REQUESTOR_ADDR_CITY = "REQUESTOR_ADDR_CITY";
  public static final String REQUESTOR_ADDR_ST = "REQUESTOR_ADDR_ST";
  public static final String REQUESTOR_ADDR_ZIP = "REQUESTOR_ADDR_ZIP";

  public static final String ADM_REV_ONE = "ADM_REV_ONE";
  public static final String ADM_REV_TWO = "ADM_REV_TWO";
  public static final String ADM_REV_THREE = "ADM_REV_THREE";

  public static final String REVIEWER_NAME = "REVIEWER_NAME";
  public static final String CASE_ID = "CASE_ID";

  public static final String DO_NOT = "DO_NOT";
  public static final String CASE_DET = "CASE_DET";
  public static final String DENIED = "DENIED";

  public static final String COUNTY = "COUNTY";

  public static final String FIRST_LVL_REVIEW = "1";
  public static final String SECOND_LVL_REVIEW = "2";
  public static final String THIRD_LVL_REVIEW = "3";

  
  /**
   * The retrieveCPSAdminReviewDecisionLetterForm method is the main entry point for the service.
   * 
   * @param cpsAdminReviewDecisionLetterFormSI
   *          Input object which should contain the Case ID, Event ID, Stage ID, and Requestor Person ID.
   * @return CPSAdminReviewDecisionLetterFormSO Output object which contains prefill data
   */
  public CpsAdminReviewDecisionLetterFormSO retrieveCPSAdminReviewDecisionLetterForm(CpsAdminReviewDecisionLetterFormSI cpsAdminReviewDecisionLetterFormSI);
}
