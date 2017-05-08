package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SAFETYRSCRASSESSMNTFRMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SAFETYRSCRASSESSMNTFRMSO;


public interface SafetyRscrAssessmentFrm extends DocumentService {
  
  
  
  public static final String FAS05O00_DOC_NAME = "fas05o00";  
  public static int FAS05O00_MAJOR = 1;
  public static int FAS05O00_MINOR = 0;
  public static int FAS05O00_REVISION = 0;
  public static final String SAFETY_RSRC_TXT = "Safety Resource";
  public static final String RELATIVE_CARE_TXT = "Safety Resource";
  
  
  
  /*******************  Header Tags  ******************************************/
  public static final String COUNTY = "COUNTY";
  public static final String PHONE_NUMB_HOME = "PHONE_NUMB_HOME";
  public static final String PHONE_NUMB_CELL = "PHONE_NUMB_CELL";
  public static final String PRIMARY_RESOURCE = "PRIMARY_RESOURCE";
  public static final String SECONDARY_RESOURCE = "SECONDARY_RESOURCE";
  public static final String STREET_ADDR = "STREET_ADDR";
  public static final String CITY_STATE_ADDR = "CITY_STATE_ADDR";
  public static final String PHONE = "PHONE";
  public static final String CASE_MANAGER = "CASE_MANAGER";
  public static final String CELL_PHONE = "CELL_PHONE";
  public static final String TXT_DT_RECEIVED = "TXT_DT_RECEIVED";
  public static final String TXT_DT_HOME_VISIT = "TXT_DT_HOME_VISIT";
  public static final String TXT_PRIMARY_RSRC = "TXT_PRIMARY_RSRC";
  public static final String TXT_SECONDARY_RSRC = "TXT_SECONDARY_RSRC";
  public static final String TXT_ADDRESS = "TXT_ADDRESS";
  public static final String TXT_CITY_ST_ZIP = "TXT_CITY_ST_ZIP";
  public static final String TXT_PHONE = "TXT_PHONE";
  public static final String TXT_CELL_PHONE = "TXT_CELL_PHONE";
  public static final String FAS05O00 = "FAS05O00";
  public static final String TYPE = "TYPE";
  public static final String TYPE_TWO = "TYPE_TWO";
  public static final String EVAL_REASON = "EVAL_REASON";
  
  
 /****************** Children Considered for Placement**************************/ 
  public static final String TMPLAT_CHILDREN = "TMPLAT_CHILDREN";
  public static final String CON_NAME = "CON_NAME";
  public static final String CON_GENDER = "CON_GENDER";
  public static final String CON_RACE = "CON_RACE";
  public static final String CON_DOB = "CON_DOB";
  public static final String CON_MED_NUM = "CON_MED_NUM";
  
  
/******************** Safety Resource HouseHold Members Tags *******************/
  public static final String HOME_NM = "HOME_NM";
  public static final String HOME_GENDER = "HOME_GENDER";
  public static final String HOME_MARTIAL = "HOME_MARTIAL";
  public static final String HOME_IDEN = "HOME_IDEN";
  public static final String HOME_DOB = "HOME_DOB";
  
/******************** Children Placed With Resource Tags ***********************/  
  public static final String TMPLAT_CHILDREN_INCASE = "TMPLAT_CHILDREN_INCASE";
  public static final String CHILD_NAME = "CHILD_NAME";
  public static final String CHILD_GENDER = "CHILD_GENDER";
  public static final String CHILD_AGE = "CHILD_AGE";
  public static final String CHILD_CARETAKER = "CHILD_CARETAKER";
  public static final String CHILD_CARETAKER_ADD = "CHILD_CARETAKER_ADD";
  public static final String CHILD_CARETAKER_PHONE = "CHILD_CARETAKER_PHONE";
  public static final String CHILD_MED_NUM = "CHILD_MED_NUM";
  public static final String START_DATE = "START_DATE";
  public static final String END_DATE = "END_DATE";
  public static final String PRIMARY_REL = "PRIMARY_REL";
  
  /******************** Caregiver Information: Tags***********************/  
  public static final String TMPLAT_CAREGIVERS = "TMPLAT_CAREGIVERS";
  public static final String GIVER_NM = "GIVER_NM";
  public static final String GIVER_GENDER = "GIVER_GENDER";
  public static final String GIVER_MARTIAL = "GIVER_MARTIAL";
  public static final String GIVER_IDEN = "GIVER_IDEN";
  public static final String GIVER_DOB = "GIVER_DOB";
  public static final String GIVER_SSN = "GIVER_SSN";
  public static final String TYPE_THREE = "TYPE_THREE";
  public static final String SAFETY_RESOURCE = "SAFETY_RESOURCE";
  public static final String TMPLAT_SAFETY_RESOURCE_INFORMATION = "TMPLAT_SAFETY_RESOURCE_INFORMATION";
  
  
  public static final String PSR_TYPE = "PSR_TYPE";
  public static final String PSR_AMOUNT = "PSR_AMOUNT";
  public static final String PSR_FREQ = "PSR_FREQ";
  public static final String PSR_START_DT = "PSR_START_DT";
  

  public static final String PSR_SEARCH_TYPE = "PSR_SEARCH_TYPE";
  public static final String PSR_DT_REQ = "PSR_DT_REQ";
  public static final String PSR_HIS = "PSR_HIS";
  public static final String PSR_DT_COMP = "PSR_DT_COMP";
  public static final String PSR_COMMENTS = "PSR_COMMENTS";
  
  /******************** Children Placed With Safety Resource Information: Tags***********************/
  
  public static final String TMPLAT_CHARACTERISTICS = "TMPLAT_CHARACTERISTICS";
  public static final String CHILD_PLACED = "CHILD_PLACED";
  public static final String TMPLAT_CP_CHARA = "TMPLAT_CP_CHARA";
  public static final String CHARA_NM = "CHARA_NM";
  public static final String CHARA_CAT = "CHARA_CAT";
  public static final String CHARA_CHARA = "CHARA_CHARA";
  
  public static final String TMPLAT_MEDS = "TMPLAT_MEDS";
  public static final String CP_MED_NAME = "CP_MED_NAME";
  public static final String MED_PERSON_NAME = "MED_PERSON_NAME";
  public static final String CP_MED_FREQ = "CP_MED_FREQ";
  public static final String CP_ST_DATE = "CP_ST_DATE";
  public static final String CP_ED_DATE = "CP_ED_DATE";
  public static final String CP_ALL_IND = "CP_ALL_IND";
  public static final String CP_ALL_DES = "CP_ALL_DES";
  
  public static final String TMPLAT_CP_EDUCATION = "TMPLAT_CP_EDUCATION";
  public static final String CP_EDU_TYPE = "CP_EDU_TYPE";
  public static final String CP_SCH_NAME = "CP_SCH_NAME";
  public static final String CP_ATTEN = "CP_ATTEN";
  public static final String CP_ENR_DT = "CP_ENR_DT";
  public static final String CP_GRADE_L = "CP_GRADE_L";
  public static final String CP_EDU_PROG = "CP_EDU_PROG";
  public static final String CP_EDU_COMM = "CP_EDU_COMM";
  public static final String EDU_PERSON_NAME = "EDU_PERSON_NAME";
  
  public static final String TMPLAT_CP_RECORD = "TMPLAT_CP_RECORD";
  public static final String CP_SEARCH_TYPE = "CP_SEARCH_TYPE";
  public static final String CP_DT_REQ = "CP_DT_REQ";
  public static final String CP_HIS = "CP_HIS";
  public static final String CP_DT_COMP = "CP_DT_COMP";
  public static final String CP_COMMENTS = "CP_COMMENTS";
  
  /********************Cps History*********************************************************/
  public static final String TMPLAT_DIV = "TMPLAT_DIV";
  public static final String DIV_CASE_ID = "DIV_CASE_ID";
  public static final String DIV_STAGE_TYPE = "DIV_STAGE_TYPE";
  public static final String DIV_STAGE_ID = "DIV_STAGE_ID";
  public static final String DIV_STAGE_NAME = "DIV_STAGE_NAME";
  public static final String DIV_DT_OPEN = "DIV_DT_OPEN";
  public static final String TMPLAT_INV = "TMPLAT_INV";
  public static final String INV_CASE_ID = "INV_CASE_ID";
  public static final String INV_STAGE_TYPE = "INV_STAGE_TYPE";
  public static final String INV_STAGE_ID = "INV_STAGE_ID";
  public static final String INV_STAGE_NAME = "INV_STAGE_NAME";
  public static final String INV_DT_OPEN = "INV_DT_OPEN";
  public static final String TMPLAT_ONG = "TMPLAT_ONG";
  public static final String ONG_CASE_ID = "ONG_CASE_ID";
  public static final String ONG_STAGE_TYPE = "ONG_STAGE_TYPE";
  public static final String ONG_STAGE_ID = "ONG_STAGE_ID";
  public static final String ONG_STAGE_NAME = "ONG_STAGE_NAME";
  public static final String ONG_DT_OPEN = "ONG_DT_OPEN";
  public static final String TMPLAT_PLA = "TMPLAT_PLA";
  public static final String PLA_CASE_ID = "PLA_CASE_ID";
  public static final String PLA_STAGE_TYPE = "PLA_STAGE_TYPE";
  public static final String PLA_STAGE_ID = "PLA_STAGE_ID";
  public static final String PLA_STAGE_NAME = "PLA_STAGE_NAME";
  public static final String PLA_DT_OPEN = "PLA_DT_OPEN";  
  public static final String TMPLAT_INV_BC = "TMPLAT_INV_BC";
  public static final String INV_BC_CASE_ID = "INV_BC_CASE_ID";
  public static final String INV_BC_STAGE_TYPE = "INV_BC_STAGE_TYPE";
  public static final String INV_BC_STAGE_ID = "INV_BC_STAGE_ID";
  public static final String INV_BC_STAGE_NAME = "INV_BC_STAGE_NAME";
  public static final String INV_BC_DT_OPEN = "INV_BC_DT_OPEN";
  public static final String TMPLAT_ONG_BC = "TMPLAT_ONG_BC";
  public static final String ONG_BC_CASE_ID = "ONG_BC_CASE_ID";
  public static final String ONG_BC_STAGE_TYPE = "ONG_BC_STAGE_TYPE";
  public static final String ONG_BC_STAGE_ID = "ONG_BC_STAGE_ID";
  public static final String ONG_BC_STAGE_NAME = "ONG_BC_STAGE_NAME";
  public static final String ONG_BC_DT_OPEN = "ONG_BC_DT_OPEN";
  public static final String TMPLAT_PLA_BC = "TMPLAT_PLA_BC";
  public static final String PLA_BC_CASE_ID = "PLA_BC_CASE_ID";
  public static final String PLA_BC_STAGE_TYPE = "PLA_BC_STAGE_TYPE";
  public static final String PLA_BC_STAGE_ID = "PLA_BC_STAGE_ID";
  public static final String PLA_BC_STAGE_NAME = "PLA_BC_STAGE_NAME";
  public static final String PLA_BC_DT_OPEN = "PLA_BC_DT_OPEN";
  public static final String TMPLAT_OTH_BC = "TMPLAT_OTH_BC";
  public static final String OTH_BC_CASE_ID = "OTH_BC_CASE_ID";
  public static final String OTH_BC_STAGE_TYPE = "OTH_BC_STAGE_TYPE";
  public static final String OTH_BC_STAGE_ID = "OTH_BC_STAGE_ID";
  public static final String OTH_BC_STAGE_NAME = "OTH_BC_STAGE_NAME";
  public static final String OTH_BC_DT_OPEN = "OTH_BC_DT_OPEN";
  public static final String TMPLAT_SCREEN_OUT = "TMPLAT_SCREEN_OUT";
  public static final String SO_INTAKE_ID = "SO_INTAKE_ID";
  public static final String SO_INTAKE_NM = "SO_INTAKE_NM";
  public static final String SO_DT_REC = "SO_DT_REC";
  public static final String DT_SO = "DT_SO";
  public static final String SO_MEMBERS_INVOLVED = "SO_MEMBERS_INVOLVED";
  public static final String TMPLAT_CL_DIV = "TMPLAT_CL_DIV";
  public static final String DIV_CL_CASE_ID = "DIV_CL_CASE_ID";
  public static final String DIV_CL_STAGE_TYPE = "DIV_CL_STAGE_TYPE";
  public static final String DIV_CL_STAGE_ID = "DIV_CL_STAGE_ID";
  public static final String DIV_CL_STAGE_NAME = "DIV_CL_STAGE_NAME";
  public static final String DIV_CL_DT_OPEN = "DIV_CL_DT_OPEN";
  public static final String DIV_CL_DT_CLOSED = "DIV_CL_DT_CLOSED";
  public static final String TMPLAT_CL_INV = "TMPLAT_CL_INV";
  public static final String INV_CL_CASE_ID = "INV_CL_CASE_ID";
  public static final String INV_CL_STAGE_TYPE = "INV_CL_STAGE_TYPE";
  public static final String INV_CL_STAGE_ID = "INV_CL_STAGE_ID";
  public static final String INV_CL_STAGE_NAME = "INV_CL_STAGE_NAME";
  public static final String INV_CL_DT_OPEN = "INV_CL_DT_OPEN";
  public static final String INV_CL_DT_CLOSED = "INV_CL_DT_CLOSED";
  public static final String INV_CL_DISPO = "INV_CL_DISPO";
  public static final String TMPLAT_CL_ONG = "TMPLAT_CL_ONG";
  public static final String ONG_CL_CASE_ID = "ONG_CL_CASE_ID";
  public static final String ONG_CL_STAGE_TYPE = "ONG_CL_STAGE_TYPE";
  public static final String ONG_CL_STAGE_ID = "ONG_CL_STAGE_ID";
  public static final String ONG_CL_STAGE_NAME = "ONG_CL_STAGE_NAME";
  public static final String ONG_CL_DT_OPEN = "ONG_CL_DT_OPEN";
  public static final String ONG_CL_DT_CLOSED = "ONG_CL_DT_CLOSED";
  public static final String INTAKE = "INT";
  public static final String DIVERSION = "DIV";
  public static final String INVESTIGATION = "INV";
  public static final String ONGOING = "ONG";
  public static final String FCF = "FCF";
  public static final String FCC = "FCC";
  public static final String FPR = "FPR";
  public static final String PLACEMENT = "PLA";
  public static final String OTHERS = "OTH";
  public static final String FORM_TYPE = "FORM_TYPE";
  public static final String FORM_TYPE_TWO = "FORM_TYPE_TWO";

  public static final String TMPLAT_CL_PLA = "TMPLAT_CL_PLA";
  public static final String PLA_CL_CASE_ID = "PLA_CL_CASE_ID";
  public static final String PLA_CL_STAGE_TYPE = "PLA_CL_STAGE_TYPE";
  public static final String PLA_CL_STAGE_ID = "PLA_CL_STAGE_ID";
  public static final String PLA_CL_STAGE_NAME = "PLA_CL_STAGE_NAME";
  public static final String PLA_CL_DT_OPEN = "PLA_CL_DT_OPEN";
  public static final String PLA_CL_DT_CLOSED = "PLA_CL_DT_CLOSED";
  public static final String TMPLAT_CL_OTH = "TMPLAT_CL_OTH";
  public static final String OTH_CL_CASE_ID = "OTH_CL_CASE_ID";
  public static final String OTH_CL_STAGE_TYPE = "OTH_CL_STAGE_TYPE";
  public static final String OTH_CL_STAGE_ID = "OTH_CL_STAGE_ID";
  public static final String OTH_CL_STAGE_NAME = "OTH_CL_STAGE_NAME";
  public static final String OTH_CL_DT_OPEN = "OTH_CL_DT_OPEN";
  public static final String OTHE_CL_DT_CLOSED = "OTH_CL_DT_CLOSED";
  public static final String COMP_DATE = "COMP_DATE";
  public static final String DEGREE_DEATH_PREV = "DEGREE_DEATH_PREV";
  public static final String TXT_PREVENTABLE_COM = "TXT_PREVENTABLE_COM";
  public static final String WITHIN_24HR = "WITHIN_24HR";
  public static final String TXT_NOTIF_EX = "TXT_NOTIF_EX";
  
  
  
  
  /********************Resource Household Members Information: Tags***********************/
  
  public static final String TMPLAT_HHM_INFO = "TMPLAT_HHM_INFO";
  public static final String HH_MEMBER = "HH_MEMBER";
  public static final String TMPLAT_HHM_CHARA = "TMPLAT_HHM_CHARA";
  public static final String HHM_CATEGORY = "HHM_CATEGORY";
  public static final String HHM_CHARA = "HHM_CHARA";
  
  public static final String TMPLAT_HHM_MEDICATION = "TMPLAT_HHM_MEDICATION";
  public static final String HHM_MED_NAME = "HHM_MED_NAME";
  public static final String HHM_FREQ = "HHM_FREQ";
  public static final String HHM_ST_DATE = "HHM_ST_DATE";
  public static final String HHM_ED_DATE = "HHM_ED_DATE";
  public static final String HHM_ALL_IND = "HHM_ALL_IND";
  public static final String HHM_ALL_DES = "HHM_ALL_DES";
  
  public static final String TMPLAT_INCOME = "TMPLAT_INCOME";
  public static final String INC_NAME = "INC_NAME";
  public static final String INC_FREQ = "INC_FREQ";
  public static final String INC_TYPE = "INC_TYPE";
  public static final String INC_AMOUNT = "INC_AMOUNT";
  public static final String INC_ST_DT = "INC_ST_DT";
  
  public static final String TMPLAT_HHM_EDUCATION = "TMPLAT_HHM_EDUCATION";
  public static final String HHM_EDU_TYPE = "HHM_EDU_TYPE";
  public static final String HHM_SCH_NAME = "HHM_SCH_NAME";
  public static final String HHM_ATTEN = "HHM_ATTEN";
  public static final String HHM_ENR_DT = "HHM_ENR_DT";
  public static final String HHM_GRADE_L = "HHM_GRADE_L";
  public static final String HHM_EDU_PROG = "HHM_EDU_PROG";
  public static final String HHM_EDU_COMM = "HHM_EDU_COMM";
  
  
  public static final String TMPLAT_HHM_RECORD = "TMPLAT_HHM_RECORD";
  public static final String HHM_SEARCH_TYPE = "HHM_SEARCH_TYPE";
  public static final String HHM_DT_REQ = "HHM_DT_REQ";
  public static final String HHM_HIS = "HHM_HIS";
  public static final String HHM_DT_COMP = "HHM_DT_COMP";
  public static final String HHM_COMMENTS = "HHM_COMMENTS";
  
  /********************Approval Section Tags***********************/
  public static final String SUPERVISOR = "SUPERVISOR";
  public static final String SUPERVISOR_NUMBER = "SUPERVISOR_NUMBER";
  public static final String APP_DT = "APP_DT";
  public static final String TXT_APP_COMMENTS = "TXT_APP_COMMENTS";
  
  /********************OTHERS***********************/
  public static final String TMPLAT_RELATIVE_CARE_2 = "TMPLAT_RELATIVE_CARE_2";
  public static final String TMPLAT_RELATIVE_CARE_1 = "TMPLAT_RELATIVE_CARE_1";
  public static final String TMPLAT_RELATIVE_CARE_3 = "TMPLAT_RELATIVE_CARE_3";
  public static final String TMPLAT_RELATIVE_CARE_4 = "TMPLAT_RELATIVE_CARE_4";
  public static final String TMPLAT_RELATIVE_CARE_5 = "TMPLAT_RELATIVE_CARE_5";
  public static final String TMPLAT_RELATIVE_CARE_6 = "TMPLAT_RELATIVE_CARE_6";
  public static final String TMPLAT_RELATIVE_CARE_7 = "TMPLAT_RELATIVE_CARE_7";
  public static final String TMPLAT_RELATIVE_CARE_8 = "TMPLAT_RELATIVE_CARE_8";
  public static final String TMPLAT_RELATIVE_CARE_9 = "TMPLAT_RELATIVE_CARE_9";
  
  
  
  public static final String TMPLAT_SAFETY_RSRC_1 = "TMPLAT_SAFETY_RSRC_1";
  public static final String TMPLAT_SAFETY_RSRC_2 = "TMPLAT_SAFETY_RSRC_2";
  public static final String TMPLAT_SAFETY_RSRC_3 = "TMPLAT_SAFETY_RSRC_3";
  public static final String TMPLAT_SAFETY_RSRC_4 = "TMPLAT_SAFETY_RSRC_4";
  public static final String TMPLAT_SAFETY_RSRC_5 = "TMPLAT_SAFETY_RSRC_5";
  public static final String TMPLAT_SAFETY_RSRC_6 = "TMPLAT_SAFETY_RSRC_6";
  public static final String TMPLAT_SAFETY_RSRC_7 = "TMPLAT_SAFETY_RSRC_7";
  public static final String TMPLAT_SAFETY_RSRC_8 = "TMPLAT_SAFETY_RSRC_8";
  public static final String TMPLAT_SAFETY_RSRC_9 = "TMPLAT_SAFETY_RSRC_9";
  
  public static final String TMPLAT_HSLD_MEMB_RC = "TMPLAT_HSLD_MEMB_RC";
  public static final String TMPLAT_PSR_RECORD = "TMPLAT_PSR_RECORD";
  
  
  

  
  
  
  
  
  
  
  
  
  





  public SAFETYRSCRASSESSMNTFRMSO retrieveSafetyRscrAssessmentFrm(SAFETYRSCRASSESSMNTFRMSI safetyRscrAssessmentFrmSI);

}