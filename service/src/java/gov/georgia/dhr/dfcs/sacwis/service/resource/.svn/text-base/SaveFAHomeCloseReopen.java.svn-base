package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD36SO;

public interface SaveFAHomeCloseReopen {

  public static final int NEXT = 1;

  public static final int CURRENT = 0;

  public static final String EMP_IS_NEW = "1";

  public static final int NBR_SVC_CODE_SIXTY_A = 1;

  public static final int NBR_SVC_CODE_SIXTY_AB = 2;

  public static final int NBR_SVC_CODE_SIXTY_ABC = 3;

  public static final int NBR_SVC_CODE_SIXTY_ABCD = 4;

  public static final int NBR_OF_HOME_TYPE = 7;

  public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";

  public static final double FOSTER_PAYMENT_LEV_BASIC = 20.00;

  public static final double FOSTER_PAYMENT_LEV_MOD = 35.00;

  public static final double FOSTER_PAYMENT_LEV_SPEC = 45.00;

  public static final double FOSTER_PAYMENT_LEV_INT = 0.00;

  public static final String CD_SERV_FOST_LEV_BASIC = "63A";

  public static final String CD_SERV_FOST_LEV_MOD = "63B";

  public static final String CD_SERV_FOST_LEV_SPEC = "63C";

  public static final String CD_SERV_FOST_LEV_INT = "63D";

  public static final String HOME_STATUS_INQUIRY = CodesTables.CFAHMSTA_INQ;
  
  public static final String HOME_STATUS_APPLICANT = CodesTables.CFAHMSTA_APP;

  public static final String HOME_STATUS_PENDING_CLOSURE = CodesTables.CFAHMSTA_PCL;

  public static final String HOME_STATUS_CLOSED = CodesTables.CFAHMSTA_CSD;

  public static final String FA_CATG_ADOPT = "A";

  public static final String FOST_TYPE_HABIL = "H";

  public static final String FOST_TYPE_THER = "P";

  public static final String FOST_TYPE_PRIM_MED = "R";

  public static final String FOST_TYPE_GROUP = "U";

  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;
  
  public static final String RSRC_TYPE_PVT_AGENCY = CodesTables.CFACTYP4_71;

  public static final String STAGE_CD_FAD = CodesTables.CSTAGES_FAD;

  public static final String CAPS_PROG_CPS = CodesTables.CPGRMS_CPS;

  public static final int RESOURCE = 0;

  public static final int STAGE = 1;

  public static final String PRIM_WORKER = "PR";

  public static final String PRS_WORKER = "STF";

  public static final String CONTRACT_STATUS_SERVICE_HOLD = CodesTables.CCONSTAT_SVH;

  public static final String CONTRACT_STATUS_ACTIVE = CodesTables.CCONSTAT_ACT;

  public static final String CONTRACT_STATUS_CLOSED = CodesTables.CCONSTAT_CLS;

  public static final String CD_SERV_FOST_L1 = "95L";

  public static final String CD_SERV_FOST_L2 = "95M";

  public static final String CD_SERV_ADP_SUB = "96D";

  public static final String CD_SERV_ADP_NON_REC_SUB = "96J";

  public static final String HISTORICAL_PRIM_WKR = "HP";

  public static final String PERSON_TYPE_WORKER = "STF";

  public static final String RSRC_PRIM_ADDR = CodesTables.CRSCADDR_01;
  
  public static final String RSRC_BUIS_ADDR = CodesTables.CRSCADDR_02;

  public static final int FOSTER = 1;

  public static final int ADOPTIVE = 2;
  
  public static final String ADOPTIVE_STATUS="02";
  
  public static final String FOSTER_STATUS="01";

  public static final String COUNTY_CD_OUT_OF_STATE = "999";

  public static final String CAPS_UNIT_STATE_OFFICE = "99";

  public static final String FA_PROGRAM = CodesTables.CSRPGTYP_CPS;

  public static final String PROVIDER_ENROLL = "PEN";

  public static final String NO_LIMIT = ArchitectureConstants.N;

  public static final String DAY_24_HOURS = "DA2";

  public static final String UNIT_RATE_PAYMENT_TYPE = "URT";

  public static final String ADOPTION_SUBSIDY = "SUB";

  public static final double SUBSIDY_PAYMENT = 486.00;
  
  public static final String ADOPTION_SUB_FINAL = "AFN";
  
  public static final String ADOPTION_SUB_NOT_FINAL = "AFS";
  
  /**
   * Save service called from the F/A Home Close/ReOpen Home window.
   *
   * @param cfad36si
   * @return
   */
  public CFAD36SO saveFAHomeCloseReopen(CFAD36SI cfad36si);
}
