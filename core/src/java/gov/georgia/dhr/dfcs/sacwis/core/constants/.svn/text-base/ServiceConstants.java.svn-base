package gov.georgia.dhr.dfcs.sacwis.core.constants;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ServiceConstants class
 * 
 * This class serves as the central location to store any constants used in multiple services
 *
 * @author Michael K. Werle, November 1, 2001
 * 
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   07/24/2008  alwilliams        STGAP00008071 - Added constants MAX_DESIGNEES and
 *                                 MAX_DESIGNATORS 
 *                                 
 *   07/31/2008  alwilliams        STGAP00008071 - Moved MAX_DESIGNEES and MAX_DESIGNATORS 
 *                                 to the Staff Security Maintenance Conversation 
 *                                 (StaffSecurityMntConversation). MAX_DESIGNATORS was
 *                                 renamed to MAX_ASSIGNEES after the move.        
 *  04/11/2011   htvo              SMS#87845 MR-074-2 AFCARS: added list of AA Agreement Funding Types 
 *                                 and Legal Action TPR/VS values so that these can be shared across services                                                    
 *                                 
 */ 
public class ServiceConstants {

  public static final int INITIAL_PAGE = 1;
  public static final int NO_SELECTION = -1;

  // Foundation Constants
  public static final String FND_YES = "Y";
  public static final String FND_NO = "N";

  // Global Function Codes

  /** REQ_FUNC_CD_ADD = "A" */
  public static final String REQ_FUNC_CD_ADD = "A";
  /** REQ_FUNC_CD_UPDATE = "U" */
  public static final String REQ_FUNC_CD_UPDATE = "U";
  /** REQ_FUNC_CD_DELETE = "D" */
  public static final String REQ_FUNC_CD_DELETE = "D";
  /** REQ_FUNC_CD_SEARCH = "S" */
  public static final String REQ_FUNC_CD_SEARCH = "S";
  /** REQ_FUNC_CD_PAGE_UP = "P" */
  public static final String REQ_FUNC_CD_PAGE_UP = "P";
  /** REQ_FUNC_CD_PAGE_DOWN = "N" */
  public static final String REQ_FUNC_CD_PAGE_DOWN = "N";
  /** REQ_FUNC_CD_LIST = "L" */
  public static final String REQ_FUNC_CD_LIST = "L";    // service list function indicator
  /** REQ_FUNC_CD_NO_ACTION = "" */
  public static final String REQ_FUNC_CD_NO_ACTION = "";

// FAD function codes

  /** REQ_FUNC_CD_KEEP = "K" */
  public static final String REQ_FUNC_CD_KEEP = "K";
  /** REQ_FUNC_CD_HISTORY = "H" */
  public static final String REQ_FUNC_CD_HISTORY = "H";  

// Intake Function Codes

  /** REQ_FUNC_CD_CLOSE = "E" */
  public static final String REQ_FUNC_CD_CLOSE = "E";
  /** REQ_FUNC_CD_MARK_FOR_DELETE = "M" */
  public static final String REQ_FUNC_CD_MARK_FOR_DELETE = "M";
  /** REQ_FUNC_CD_REMOVE = " " */
  public static final String REQ_FUNC_CD_REMOVE = " ";
  /** REQ_FUNC_CD_SAVE = "S" */
  public static final String REQ_FUNC_CD_SAVE = "S";
  /** REQ_FUNC_CD_SAVE_AND_ASSIGN = "N" */
  public static final String REQ_FUNC_CD_SAVE_AND_ASSIGN = "N";
  /** REQ_FUNC_CD_SAVE_AND_ASSIGN_CHG = "G" */
  public static final String REQ_FUNC_CD_SAVE_AND_ASSIGN_CHG = "G";
  /** REQ_FUNC_CD_SAVE_AND_CLOSE = "O" */
  public static final String REQ_FUNC_CD_SAVE_AND_CLOSE = "O";
  /** REQ_FUNC_CD_SAVE_AND_SUBMIT = "B" */
  public static final String REQ_FUNC_CD_SAVE_AND_SUBMIT = "B";
  /** REQ_FUNC_CD_SAVE_AND_SUBMIT_CHANGES = "T" */
  public static final String REQ_FUNC_CD_SAVE_AND_SUBMIT_CHANGES = "T";
  /** REQ_FUNC_CD_SAVE_CHANGE = "C" */
  public static final String REQ_FUNC_CD_SAVE_CHANGE = "C";
  
  
  //Health log Function Code
  /** REQ_FUNC_CD_ADD  for Health Log **/
  public static final String REQ_FUNC_CD_HEALTH_LOG_ADD = "H";
  
  //-- The following two constants are used as the sorting direction for a sortable column
  //-- which is determined by the SortableColumnTag class when using the
  //-- impact:sortableColumnHeader tag. These constants should also be used to check the value
  //-- passed to the service class for custom sorting implementation in the DAO.
  public static final String SORT_DESCENDING = "DESC";
  public static final String SORT_ASCENDING = "ASC";
  // SMS#87845 MR-074-2 AFCARS: defined these Legal Action and Adoption Assistance constants here in an attempt to unifying TPR/VS logic
  // and Legal Status Adoption Finalized validation in SHINES
  public static final List<String> LA_VOLUNTARY_SURRENDER_FATHER_TYPES = 
    new ArrayList<String>(Arrays.asList(CodesTables.CLEGCPS_VAF, // Voluntary Surrender-Adoptive Father
                                        CodesTables.CLEGCPS_VBF,  // Voluntary Surrender-Biological Father
                                        CodesTables.CLEGCPS_VLS,  // Voluntary Surrender-Legal Father
                                        CodesTables.CLEGCPS_VSF,  // Voluntary Surrender-Legal/Biological Father
                                        CodesTables.CLEGCPS_VPF)); // Voluntary Surrender-Putative Father - SMS#87845 MR-074-2 AFCARS
  
  public static final List<String> LA_TPR_FATHER_TYPES = 
    new ArrayList<String>(Arrays.asList(CodesTables.CLHECOT_TFA, // TPR - Adoptive Father
                                        CodesTables.CLHECOT_TFB, // TPR - Biological Father
                                        CodesTables.CLHECOT_TFF, // TPR - Legal Father
                                        CodesTables.CLHECOT_TFL, // TPR - Legal/Biological Father
                                        CodesTables.CLHECOT_TPP)); // TPR - Putative Father - SMS#87845 MR-074-2 AFCARS

  
  public static final List<String> LA_VOLUNTARY_SURRENDER_MOTHER_TYPES = 
    new ArrayList<String>(Arrays.asList(CodesTables.CLEGCPS_VAM, // Voluntary Surrender-Adoptive Mother
                                        CodesTables.CLEGCPS_VLM)); // Voluntary Surrender-Mother
  
  public static final List<String> LA_TPR_MOTHER_TYPES = 
    new ArrayList<String>(Arrays.asList(CodesTables.CLHECOT_TPA, // TPR - Adoptive Mother
                                        CodesTables.CLHECOT_TPM)); // TPR-Mother

  public static final List<String> AA_AGREEMENT_RECURRING_FUNDING_TYPES = new ArrayList<String>(Arrays.asList(CodesTables.CSUBTYPE_01, // Title IV-E Fin Asst and Medicaid
                                                                                                CodesTables.CSUBTYPE_03, // Title IV-E Fin Asst Only
                                                                                                CodesTables.CSUBTYPE_07, // Title IV-B State Adpt Fin Asst and Medicaid
                                                                                                CodesTables.CSUBTYPE_09, // Title IV-B State Adpt Fin Asst Only
                                                                                                CodesTables.CSUBTYPE_26, // IV-E Medicaid Only (GA Child)
                                                                                                CodesTables.CSUBTYPE_27)); // Title IV-B State Medicaid Only (GA Child)
}
