package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ADOFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ADOFORMSO;

/**
 * Adoption Assistance Agreement service interface 
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  08/19/2008  wjcochran STGAP000010005: Adoption Assistance Agreement has been added
 *  07/15/2009  bgehlot   STGAP00014724: Get the non recurring amount limit from the approved non recurring application
 *  02/08/2012  vcollooru STGAP00017878: Added 2 static variables AGREEMENT_TYPE_INITIAL & AGREEMENT_TYPE_AMENDED 
 *                        for holding Agreement Type values.
 * </pre>
 *
 */
public interface AdoptionAssistanceAgreement extends DocumentService {

  public static final String RELEVANT_AGENCY = "txtNameOfRelevantAgency";
  public static final String AGENCY_ADDRESS = "txtAgencyAddress";
  public static final String AGENCY_PHONE = "txtAgencyPhoneNumber";
  public static final String COUNTY_NAME = "txtCountyName";
  
  //STGAP00014724: Get the non recurring amount limit from the approved non recurring application
  public static final String NON_RECURRING_LIMIT_AMT = "NON_RECURRING_LIMIT_AMT";
  public static final double NON_RECURRING_LIMIT_AMT_DEFAULT = 1500.00;
  
  public static final String ADO_PARENTS_FULL_NAMES = "txtAdoptiveParentsName";
  public static final String ADO_ADDRESS = "txtAdoptiveAddress";
  public static final String ADO_PHONE_NUMBER = "txtAdoptivePhoneNumber";
  
  public static final String CHILD_NAME = "txtChildName";
  public static final String CHILD_FIRST_NAME = "txtChildFirstName";
  public static final String CHILD_DATE_OF_BIRTH = "txtChildDOB";
  public static final String TITLE_IV_E_ELIGIBLE_YES = "CHILD_TITLE_IV_E_ELIG_YES"; //*
  public static final String TITLE_IV_E_ELIGIBLE_NO = "CHILD_TITLE_IV_E_ELIG_NO"; //*
  public static final String TITLE_IV_B_ELIGIBLE_YES = "CHILD_TITLE_IV_B_ELIG_YES"; // *
  public static final String TITLE_IV_B_ELIGIBLE_NO = "CHILD_TITLE_IV_B_ELIG_NO"; // *
  
  public static final String DOCUMENT_PURPOSE = "rdoDocumentPurpose";
  public static final String CHILD_FAM_HEALTH_INS_YES = "CHILD_FAM_HLTH_INS_YES";
  public static final String CHILD_FAM_HEALTH_INS_NO = "CHILD_FAM_HLTH_INS_NO";
  public static final String CHILD_MEDICAID_YES = "CHILD_MEDICAID_YES";
  public static final String CHILD_MEDICAID_NO = "CHILD_MEDICAID_NO";
  public static final String CHILD_MILITARY_BENEFITS_YES = "CHILD_MIL_BEFITS_YES";
  public static final String CHILD_MILITARY_BENEFITS_NO = "CHILD_MIL_BEFITS_NO";
  
  public static final String APPROVED_MONTHLY_PYMNT_YES = "MONTHLY_CASH_PYMNTS_YES";
  public static final String APPROVED_MONTHLY_PYMNT_NO = "MONTHLY_CASH_PYMNTS_NO";
  public static final String APPROVED_PAYMENT_AMOUNT = "txtApprovedAmount";
  
  public static final String APPROVED_PAY_START = "txtApprovalPeriodStart";
  public static final String APPROVED_PAY_END = "txtApprovalPeriodEnd";
  
  public static final String DOC_PURPOSE_INIT = "DOC_PURPOSE_INIT";
  public static final String DOC_PURPOSE_AMEND = "DOC_PURPOSE_AMEND";
  public static final String DOC_PURPOSE_DEFER = "DOC_PURPOSE_DEFER";
  
  public static final String COUNTY_NAME_2 = "txtCountyName2";
  public static final String COUNTY_NAME_3 = "txtCountyName3";
  
  public static final String YES = ArchitectureConstants.Y;
  public static final String NO = ArchitectureConstants.N;

  public static final String AGREEMENT_TYPE_INITIAL = "I";
  public static final String AGREEMENT_TYPE_AMENDED = "A";
  /**
   * The retrieveAdoptionAssistanceAgreement method is the main entry point for the service.
   * 
   * @param adoFormSI
   *          Input object which should contain the Stage ID.
   * @return ADOFORMSO Output object which contains prefill data
   */
  public ADOFORMSO retrieveAdoptionAssistanceAgreement(ADOFORMSI adoFormSI);
}
