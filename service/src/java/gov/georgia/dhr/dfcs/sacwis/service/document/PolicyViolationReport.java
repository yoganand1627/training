package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyViolationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyViolationSO;;

/**
 * The PolicyViolationReport Interface is the service interface for generating the 'Policy Vilation Report'
 * Form.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.DocumentService
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.impl.PolicyViolationReportImpl
 * 
 * 
 * @author Stephen Roberts, June 6, 2008
 * 
 * <PRE>
 * 
 * <U>Updated by:</U> <U>Description:</U> Update description
 * 
 * </PRE>
 */
public interface PolicyViolationReport extends DocumentService {

  public static final String PRINCIPAL = "PRN";
  public static final String RESOURCE_LINK_TYPE = "01"; 
  
  // The page size constant is also defined in PlacementLogConversation.  Both should
  // be set to the same value.
  public static final int PAGE_SIZE = 100;
  public static final String SORT_O = "O";
 
  public static final String INTAKE_DISPOSITION = "ACA";
  
  // Heading bookmarks
  public static final String HOME_NAME = "HOME_NAME";
  public static final String COUNTY_NAME= "COUNTY_NAME";
  public static final String VENDOR_ID = "VENDOR_ID";
  public static final String CASE_ID = "CASE_ID";

  // Other in-line bookmarks throughout the form
  public static final String COUNTY_OF_VIOLATION = "COUNTY_OF_VIOLATION";
  public static final String DATE_OF_VIOLATION = "DATE_OF_VIOLATION";
  public static final String YES_SO_CONCURRENCE = "YES_SO_CONCURRENCE";
  public static final String NO_SO_CONCURRENCE = "NO_SO_CONCURRENCE";
  public static final String DATE_SO_CONCURRENCE = "DATE_SO_CONCURRENCE"; 

  // Repeating group constants for TMPLAT_CPA_HEADER and associated bookmarks
  public static final String TMPLAT_CPA_HEADER = "TMPLAT_CPA_HEADER";
  public static final String CPA_NAME = "CPA_NAME";  
  
  // Repeating group constants for TMPLAT_CPA_CONCURRENCE and associated bookmarks
  public static final String TMPLAT_CPA_CONCURRENCE = "TMPLAT_CPA_CONCURRENCE";
  public static final String YES_CPA_CONCURRENCE = "YES_CPA_CONCURRENCE";
  public static final String NO_CPA_CONCURRENCE = "NO_CPA_CONCURRENCE";
  public static final String DATE_CPA_CONCURRENCE = "DATE_CPA_CONCURRENCE";

  // Repeating group constants for TMPLAT_VIOLATION and associated bookmarks
  public static final String TMPLAT_VIOLATION = "TMPLAT_VIOLATION";
  public static final String VIOLATION_DATE = "VIOLATION_DATE"; 
  public static final String VIOLATION = "VIOLATION";
  
  // Repeating group constants for TMPLAT_CHILD and associated bookmarks
  public static final String TMPLAT_CHILD = "TMPLAT_CHILD";
  public static final String CHILD_NAME = "CHILD_NAME";
  public static final String CHILD_DOB = "CHILD_DOB";
  public static final String CHILD_GENDER = "CHILD_GENDER";
  public static final String CHILD_PLACEMENT_DATE = "CHILD_PLACEMENT_DATE";
  public static final String CHILD_INVOLVED = "CHILD_INVOLVED";
  public static final String CHILD_ADOPT = "CHILD_ADOPT";
  
  // Repeating group constants for TMPLAT_MEMBER and associated bookmarks
  public static final String TMPLAT_MEMBER = "TMPLAT_MEMBER";
  public static final String MEMBER_NAME = "MEMBER_NAME";
  public static final String MEMBER_DOB = "MEMBER_DOB";
  public static final String MEMBER_GENDER = "MEMBER_GENDER";
  public static final String MEMBER_RELATIONSHIP = "MEMBER_RELATIONSHIP";

  // Repeating group constants for TMPLAT_PLACEMENT and associated bookmarks
  public static final String TMPLAT_PLACEMENT = "TMPLAT_PLACEMENT";
  public static final String PLACEMENT_NAME = "PLACEMENT_NAME";
  public static final String PLACEMENT_DOB = "PLACEMENT_DOB";
  public static final String PLACEMENT_GENDER = "PLACEMENT_GENDER";
  public static final String PLACEMENT_START_DATE = "PLACEMENT_START_DATE";
  public static final String PLACEMENT_END_DATE = "PLACEMENT_END_DATE";
  public static final String PLACEMENT_REMOVAL_REASON = "PLACEMENT_REMOVAL_REASON";
  public static final String PLACEMENT_TYPE = "PLACEMENT_TYPE";  
  public static final String ADOPTION_FINALIZED = "ADOPTION_FINALIZED";
  public static final String PLACEMENT_SIBLING = "PLACEMENT_SIBLING";
  public static final String PLACEMENT_LEGAL_COUNTY = "PLACEMENT_LEGAL_COUNTY";
  
  // Repeating group constants for TMPLAT_ALLEGATION and associated bookmarks
  public static final String TMPLAT_ALLEGATION = "TMPLAT_ALLEGATION";
  public static final String ALLEGATION_DATE = "ALLEGATION_DATE";
  public static final String ALLEGATION_CODE = "ALLEGATION_CODE";
  public static final String ALLEGATION_DECODE = "ALLEGATION_DECODE";
  public static final String ALLEGATION_DISPOSITION = "ALLEGATION_DISPOSITION";
  
  // Repeating group constants for TMPLAT_APPROVAL and associated bookmarks
  public static final String TMPLAT_APPROVAL = "TMPLAT_APPROVAL";
  public static final String APPROVAL_DATE = "APPROVAL_DATE";
  public static final String APPROVAL_NAME = "APPROVAL_NAME";

  // Repeating group constants for TMPLAT_REJECTION and associated bookmarks
  public static final String TMPLAT_REJECTION = "TMPLAT_REJECTION";
  public static final String REJECTION_DATE = "REJECTION_DATE";
  public static final String REJECTION_NAME = "REJECTION_NAME";  
  public static final String REJECTION_REASON = "REJECTION_REASON";   
  
  /**
   * The retrievePolicyViolationReport method is the main entry point for the service.
   * 
   * @param PolicyViolationSI
   *          Input object which should contain the Stage ID.
   * @return PolicyViolationSO Output object which contains prefill data
   */
  public PolicyViolationSO retrievePolicyViolationReport(PolicyViolationSI policyViolationSI);
}
