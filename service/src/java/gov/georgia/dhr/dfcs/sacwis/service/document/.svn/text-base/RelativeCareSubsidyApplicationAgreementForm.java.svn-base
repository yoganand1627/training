package gov.georgia.dhr.dfcs.sacwis.service.document;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelativeCareSubsidyApplicationAgreementFormSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareSubsidyApplicationAgreementFormSO;

/**
 * <pre>
 * Change History:
 *  Date        User       Description
 *  --------    --------   ------------------------------------------------------------
 *  05/21/2011  hnguyen    SMS#109407: MR-087 Relative Care Subsidy Application and Agreement Form added
 * </pre>
 *
 */

public interface RelativeCareSubsidyApplicationAgreementForm extends DocumentService {

  // Template name
  public static final String RCSAPPAGMT = "RCSAPPAGMT";  
  
  // Other in-line bookmarks throughout the form
  public static final String CHILD_NAME = "CHILD_NAME";
  public static final String CHILD_DOB = "CHILD_DOB";
  public static final String CHILD_AGE = "CHILD_AGE";
  public static final String CHILD_SSN = "CHILD_SSN";
  public static final String CHILD_PHONE = "CHILD_PHONE";
  public static final String CHILD_ADDRESS_LN1 = "CHILD_ADDRESS_LN1";
  public static final String CHILD_ADDRESS_LN2 = "CHILD_ADDRESS_LN2";
  public static final String CHILD_ADDRESS_CITY = "CHILD_ADDRESS_CITY";
  public static final String CHILD_ADDRESS_STATE = "CHILD_ADDRESS_STATE";
  public static final String CHILD_ADDRESS_ZIP = "CHILD_ADDRESS_ZIP";
  
  public static final String CHILD_NAME2 = "CHILD_NAME2";
  public static final String CHILD_NAME3 = "CHILD_NAME3";
  public static final String CHILD_NAME4 = "CHILD_NAME4";

  public static final String LEGAL_COUNTY = "LEGAL_COUNTY";
  public static final String LEGAL_COUNTY2 = "LEGAL_COUNTY2";
  
  /**
   * The retrieveRelativeCareSubsidyApplicationAgreementForm method is the main entry point for the service.
   * 
   * @param relativeCareSubsidyApplicationAgreementFormSI
   *          Input object which should contain the Case ID and Stage ID.
   * @return RelativeCareSubsidyApplicationAgreementFormSO Output object which contains prefill data
   */
  public RelativeCareSubsidyApplicationAgreementFormSO retrieveRelativeCareSubsidyApplicationAgreementForm(RelativeCareSubsidyApplicationAgreementFormSI relativeCareSubsidyApplicationAgreementFormSI);
}
