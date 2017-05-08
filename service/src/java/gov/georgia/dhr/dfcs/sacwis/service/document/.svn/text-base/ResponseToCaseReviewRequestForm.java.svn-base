package gov.georgia.dhr.dfcs.sacwis.service.document;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ResponseToCaseReviewRequestFormSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ResponseToCaseReviewRequestFormSO;

/**
 * Response To Case Review Request Form interface 
 * <pre>
 * Change History:
 *  Date        User       Description
 *  --------    --------   ------------------------------------------------------------
 *  02/10/2010  hnguyen    Response To Case Review Request Form has been added
 * </pre>
 *
 */

public interface ResponseToCaseReviewRequestForm extends DocumentService {

  // Template name
  public static final String RESPAREQ = "RESPAREQ";  
  
  // Other in-line bookmarks throughout the form
  public static final String DATE_GENERATED = "DATE_GENERATED";

  public static final String REQUESTOR_NAME = "REQUESTOR_NAME";
  public static final String REQUESTOR_ADDR_LN1 = "REQUESTOR_ADDR_LN1";
  public static final String REQUESTOR_ADDR_LN2 = "REQUESTOR_ADDR_LN2";
  public static final String REQUESTOR_ADDR_CITY = "REQUESTOR_ADDR_CITY";
  public static final String REQUESTOR_ADDR_ST = "REQUESTOR_ADDR_ST";
  public static final String REQUESTOR_ADDR_ZIP = "REQUESTOR_ADDR_ZIP";

  public static final String COUNTY = "COUNTY";

  
  /**
   * The retrieveResponseToCaseReviewRequestForm method is the main entry point for the service.
   * 
   * @param responseToCaseReviewRequestFormSI
   *          Input object which should contain the Case ID, Event ID, Stage ID, and Requestor Person ID.
   * @return ResponseToCaseReviewRequestFormSO Output object which contains prefill data
   */
  public ResponseToCaseReviewRequestFormSO retrieveResponseToCaseReviewRequestForm(ResponseToCaseReviewRequestFormSI responseToCaseReviewRequestFormSI);
}
