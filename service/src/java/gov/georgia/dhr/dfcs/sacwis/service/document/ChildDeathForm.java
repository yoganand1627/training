package gov.georgia.dhr.dfcs.sacwis.service.document;


import gov.georgia.dhr.dfcs.sacwis.structs.input.CHILDDEATHSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CHILDDEATHSO;


public interface ChildDeathForm extends DocumentService {
  
  public static final String ASIAN = "AN";
  public static final String BLACK = "BK";
  public static final String HAWAIIAN = "HP";
  public static final String WHITE = "WT";
  public static final String UNKNOWN = "UD";
  public static final String AMERICAN_INDIAN = "AA";
  public static final String CHECKED = "CHECKED";
  public static final String MOTHER = "MOTHER";
  public static final String FATHER = "FATHER";
  public static final String BIOLOGICAL_MOTHER = "BM";
  public static final String BIOLOGICAL_FATHER = "BF";
  public static final String BIOLEGAL_FATHER = "BB";
  public static final String LEGAL_MOTHER = "LM";
  public static final String LEGAL_FATHER = "LF";
  public static final String INTAKE = "INT";
  public static final String DIVERSION = "DIV";
  public static final String INVESTIGATION = "INV";
  public static final String ONGOING = "ONG";
  public static final String FCF = "FCF";
  public static final String FCC = "FCC";
  public static final String FPR = "FPR";
  public static final String PLACEMENT = "PLA";
  public static final String OTHERS = "OTH";
  public static final String HISPANIC = "Hispanic";
  public static final String NON_HISPANIC = "non-Hispanic";
  public static final String UNABLE_TO_DET = "unable to determine";
  
 
  
  /** Header Section**/
  public static final String COUNTY_NAME = "COUNTY_NAME";
  public static final String DOD = "DOD";
  
  
  
  /** I Section**/
  public static final String CHILD_FIRST_NAME = "CHILD_FIRST_NAME";
  public static final String CHILD_MIDDLE_NAME = "CHILD_MIDDLE_NAME";
  public static final String CHILD_LAST_NAME = "CHILD_LAST_NAME";
  public static final String TMPLAT_CHILD_SEX = "TMPLAT_CHILD_SEX";
  public static final String CHILD_ETHNICITY = "CHILD_ETHNICITY";
  public static final String CHILD_SEX = "CHILD_SEX";
  public static final String RACE_WHITE = "RACE_WHITE";
  public static final String RACE_BLACK = "RACE_BLACK";
  public static final String RACE_INDIAN = "RACE_INDIAN";
  public static final String RACE_ASIAN = "RACE_ASIAN";
  public static final String RACE_HAWAIIAN = "RACE_HAWAIIAN";
  public static final String RACE_MULTI = "RACE_MULTI";
  public static final String RACE_UNKNOWN = "RACE_UNKNOWN";
  public static final String CHILD_AGE = "CHILD_AGE";
  public static final String PARENT_AGE = "PARENT_AGE";
  public static final String MOTHER_NAME = "MOTHER_NAME";
  public static final String MOTHER_DOB = "MOTHER_DOB";
  public static final String FATHER_NAME = "FATHER_NAME";
  public static final String FATHER_DOB = "FATHER_DOB";
 
  
  /** Section II **/
  public static final String DT_REPORTED = "DT_REPORTED";
  public static final String LEGAL_CUST = "LEGAL_CUST";
  public static final String INADEQUATE = "INADEQUATE";
  public static final String MOTOR_VECH = "MOTOR_VECH";
  public static final String CHILD_ABUSE = "CHILD_ABUSE";
  public static final String SUICIDE = "SUICIDE";
  public static final String SID = "SID";
  public static final String DROWNING = "DROWNING";
  public static final String FIREARM = "FIREARM";
  public static final String SUID = "SUID";
  public static final String CHOKE = "CHOKE";
  public static final String POSION = "POSION";
  public static final String NATURAL = "NATURAL";
  public static final String FIRE = "FIRE";
  public static final String FALL = "FALL";
  public static final String OTHER_EXP = "OTHER_EXP";
  public static final String DEATH_COUNTY = "DEATH_COUNTY";
  public static final String AUTO_COMP = "AUTO_COMP";
  public static final String AUTO_COMMENTS = "AUTO_COMMENTS";
  public static final String PREVENTABLE = "PREVENTABLE";
  public static final String PREVENTABLE_COMMENTS = "PREVENTABLE_COMMENTS";
  public static final String CAUSE_COMMENTS = "CAUSE_COMMENTS";
  public static final String TWENTY_FOUR_COMMENT = "TWENTY_FOUR_COMMENT";
  public static final String TWENTY_FOUR = "TWENTY_FOUR";
  
  
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
  public static final String CASE_MANAGER = "CASE_MANAGER";
  public static final String COMP_DATE = "COMP_DATE";
  public static final String DEGREE_DEATH_PREV = "DEGREE_DEATH_PREV";
  public static final String TXT_PREVENTABLE_COM = "TXT_PREVENTABLE_COM";
  public static final String WITHIN_24HR = "WITHIN_24HR";
  public static final String TXT_NOTIF_EX = "TXT_NOTIF_EX";
    
  public CHILDDEATHSO retrieveChildDeath(CHILDDEATHSI childdeathsi);

}
  
