package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPFORMSO;

public interface WTLPForm extends DocumentService{
  
  // Template names
  public static final String FCM05O00 = "FCM05O00";  
  
  public static final String FCM05O00_DOC_NAME = "fcm05o00";
 public static final String FCM07O00 = "FCM07O00";  
  
  public static final String FCM07O00_DOC_NAME = "fcm07o00";  
  public static int FCM07O00_MAJOR = 1;
  public static int FCM07O00_MINOR = 0;
  public static int FCM07O00_REVISION = 1;
  
  // individual fields
  // Miscellaneous
public static final String NEEDS_CONCL_TASK_CODE = "2340";
public static final String SPACE = " ";
public static final String CAPX = "X";
public static final String DOUBLEUNDERSCORE = "__";
public static final String YES = "Y";
public static final String NO  = "N";
public static final String NA  = "A";
public static final String GOAL_TYPE = "WTL";

public static final int    FOURTEEN = 14;
public static final int    FOUR     = 4;
public static final int    EIGHTEEN = 18;
  
  
  // WTLP 
  public static final String WTLP_CHLD_FULLNAME       = "WTLP_CHLD_FULLNAME";
  public static final String WTLP_COUNTY              = "WTLP_COUNTY";
  public static final String WTLP_YDP_FULLNAME        = "WTLP_YDP_FULLNAME";
  public static final String WTLP_YDP_PH_NBR          = "WTLP_YDP_PH_NBR";
  public static final String WTLP_CASE_MNGR_FNAME     = "WTLP_CASE_MNGR_FNAME";  
  public static final String WTLP_CASE_MNGR_PH_NBR    = "WTLP_CASE_MNGR_PH_NBR";
  public static final String WTLP_DT                  = "WTLP_DT";
  public static final String WTLP_DOB                 = "WTLP_DOB";
  public static final String WTLP_GENDER              = "WTLP_GENDER";
  public static final String WTLP_RACE_ETHNCTY        = "WTLP_RACE_ETHNCTY";
  public static final String WTLP_ELIGIBILITY         = "WTLP_ELIGIBILITY";
  public static final String WTLP_CURR_LV_ARR         = "WTLP_CURR_LV_ARR";
  public static final String WTLP_TYPE                = "WTLP_TYPE";  
  public static final String WTLP_CUST_STAT           = "WTLP_CUST_STAT";   
  public static final String WTLP_MRTL_STAT           = "WTLP_MRTL_STAT";
  public static final String WTLP_PARENT_STATUS       = "WTLP_PARENT_STATUS";
  public static final String WTLP_AUTHRTY_PLCMT       = "WTLP_AUTHRTY_PLCMT";
  public static final String WTLP_EXPTD_GRAD_DT       = "WTLP_EXPTD_GRAD_DT";
  public static final String WTLP_ACDMY_TRACK         = "WTLP_ACDMY_TRACK";
  public static final String WTLP_EDU_CRDT_GRAD_REQ  = "WTLP_EDU_CRDT_GRAD_REQ";
  public static final String WTLP_EDU_CRDT_GRAD_ERND  = "WTLP_EDU_CRDT_GRAD_ERND";
  public static final String WTLP_EMNCPTN_DISC_YTH_Y  = "WTLP_EMNCPTN_DISC_YTH_Y";
  public static final String WTLP_EMNCPTN_DISC_YTH_N  = "WTLP_EMNCPTN_DISC_YTH_N";
  public static final String WTLP_EMNCPTN_DISC_DT     = "WTLP_EMNCPTN_DISC_DT";
  public static final String WTLP_EMNCPTN_DISC_COMM   = "WTLP_EMNCPTN_DISC_COMM";  
  public static final String WTLP_EMAN_CRDT_GRAD_REQ  = "WTLP_EMAN_CRDT_GRAD_REQ";   
  public static final String WTLP_EMAN_CRDT_GRAD_ERND = "WTLP_EMAN_CRDT_GRAD_ERND";
  public static final String WTLP_GOAL_TYPE           = "WTLP_GOAL_TYPE";
  public static final String WTLP_DRTN_DT_FROM        = "WTLP_DRTN_DT_FROM";
  public static final String WTLP_DRNT_DT_TO          = "WTLP_DRNT_DT_TO";
  public static final String WTLP_STRENGTH            = "WTLP_STRENGTH";
  public static final String WTLP_NEEDS               = "WTLP_NEEDS";
  public static final String WTLP_GOAL                = "WTLP_GOAL";
  public static final String WTLP_STEPS_CHLD_FNAME    = "WTLP_STEPS_CHLD_FNAME";
  public static final String WTLP_CHK_EDU             = "WTLP_CHK_EDU";
  public static final String WTLP_CHK_VOC             = "WTLP_CHK_VOC";
  public static final String WTLP_CHK_DAY_LVNG        = "WTLP_CHK_DAY_LVNG";
  public static final String WTLP_CHK_HEALTH          = "WTLP_CHK_HEALTH";
  public static final String WTLP_CHK_PRSNL           = "WTLP_CHK_PRSNL";
  public static final String WTLP_GOAL_RSN            = "WTLP_GOAL_RSN";  
  public static final String WTLP_GOAL_TXT            = "WTLP_GOAL_TXT";   
  public static final String WTLP_STEP_SEQ            = "WTLP_STEP_SEQ";
  public static final String WTLP_STEP_ACTN           = "WTLP_STEP_ACTN";
  public static final String WTLP_STEP_PRSN           = "WTLP_STEP_PRSN";
  public static final String WTLP_STEP_PRIORITY       = "WTLP_STEP_PRIORITY";
  public static final String WTLP_STEP_CMPLTN_DT      = "WTLP_STEP_CMPLTN_DT";
  public static final String WTLP_STEP_STATUS         = "WTLP_STEP_STATUS";
  public static final String WTLP_STEP_COMM           = "WTLP_STEP_COMM";
  public static final String WTLP_STEP_CHILD_FULLNAME = "WTLP_STEP_CHILD_FULLNAME";
  public static final String WTLP_PARTICIPANT_TYPE    = "WTLP_PARTICIPANT_TYPE";
  public static final String WTLP_PARTICIPANT_NAME    = "WTLP_PARTICIPANT_NAME";
  public static final String WTLP_PARTICIPANT_REL     = "WTLP_PARTICIPANT_REL";
  public static final String WTLP_DT_RECEIPT_SIGNED   = "WTLP_DT_RECEIPT_SIGNED";
  public static final String WTLP_DT_PARTICIPATION    = "WTLP_DT_PARTICIPATION";
  public static final String WTLP_PERSON_APPROVES_N   = "WTLP_PERSON_APPROVES_N";
  public static final String WTLP_PERSON_APPROVES_Y   = "WTLP_PERSON_APPROVES_Y";
  public static final String WTLP_DT_APPROVED         = "WTLP_DT_APPROVED";
  public static final String WTLP_REASON_NOT_APPROVE  = "WTLP_REASON_NOT_APPROVE";
  public static final String TMPLAT_WTLP              = "TMPLAT_WTLP";
  public static final String TMPLAT_WTLP_GOAL_TYPE    = "TMPLAT_WTLP_GOAL_TYPE";
  public static final String TMPLAT_WTLP_GOAL_TYPES   = "TMPLAT_WTLP_GOAL_TYPES";
  public static final String TMPLAT_WTLP_GOAL_STEPS   = "TMPLAT_WTLP_GOAL_STEPS";  
  public static final String TMPLAT_PARTICIPANT_LIST  = "TMPLAT_PARTICIPANT_LIST";
  
  public WTLPFORMSO retrieveWtlpForm(WTLPFORMSI wtlpFormsi);

}
