package gov.georgia.dhr.dfcs.sacwis.service.document;


import gov.georgia.dhr.dfcs.sacwis.structs.input.SCRNREFSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SCRNREFSO;


public interface ScreeningAndReferral extends DocumentService {
  
  /** Section A CHILD AND FAMILY INFORMATION **/

  public static final String MOTHER = "MOTHER";
  public static final String FATHER = "FATHER";
  public static final String BIOLOGICAL_MOTHER = "BM";
  public static final String BIOLOGICAL_FATHER = "BF";
  public static final String BIOLEGAL_FATHER = "BB";
  public static final String AMERICAN_INDIAN = "AA";
  public static final String ASIAN = "AN";
  public static final String PRIM_LANGUAGE = "PRIM_LANGUAGE";
  public static final String BLACK = "BK";
  public static final String HAWAIIAN = "HP";
  public static final String WHITE = "WT";
  public static final String UNKNOWN = "UD";
  public static final String CHECKED = "CHECKED";
  public static final String CHILD_PROTECT_AGENCY = "CFH";
  public static final String NONE = "None";
  public static final String SPACE = " ";
  public static final String CAPX = "X";
  public static final String DOUBLEUNDERSCORE = "__";
  
  
  
  // SECTION A BOOKMARKS  
  //public static final String CHILD_NAME_LAST = "CHILD_NAME_LAST"; Declared in BaseDocumentServiceImpl
  //public static final String CHILD_NAME_FIRST = "CHILD_NAME_FIRST";  Declared in BaseDocumentServiceImpl
  //public static final String CHILD_NAME_MIDDLE = "CHILD_NAME_MIDDLE"; Declared in BaseDocumentServiceImpl
  public static final String MOTHER_LAST_NAME = "MOTHER_LAST_NAME";
  public static final String MOTHER_LAST_NAME2 = "MOTHER_LAST_NAME2";
  public static final String MOTHER_FIRST_NAME = "MOTHER_FIRST_NAME";
  public static final String MOTHER_FIRST_NAME2 = "MOTHER_FIRST_NAME2";
  public static final String MOTHER_MIDDLE_NAME = "MOTHER_MIDDLE_NAME";
  public static final String MOTHER_MIDDLE_NAME2 = "MOTHER_MIDDLE_NAME2";
  public static final String MOTHER_MADIEN = "MOTHER_MADIEN";
  public static final String FATHER_LAST_NAME = "FATHER_LAST_NAME";
  public static final String FATHER_FIRST_NAME = "FATHER_FIRST_NAME";
  public static final String FATHER_MIDDLE_NAME = "FATHER_MIDDLE_NAME";
  public static final String CHILD = "CHILD";
  public static final String CHILD_ADDRESS = "CHILD_ADDRESS";
  public static final String CHILD_CITY = "CHILD_CITY";
  public static final String CHILD_STATE = "CHILD_STATE";
  public static final String CHILD_ZIP = "CHILD_ZIP";
  public static final String CHILD_COUNTY = "CHILD_COUNTY";
  public static final String CHILD_PHONE = "CHILD_PHONE";
  public static final String CHILD_EMG_PHONE = "CHILD_EMG_PHONE";
  public static final String HIS_YES = "HIS_YES";
  public static final String HIS_NO = "HIS_NO";
  public static final String HIS_UNKNOWN = "HIS_UNKNOWN"; 
  public static final String RACE_WHITE = "RACE_WHITE";
  public static final String RACE_BLACK = "RACE_BLACK";
  public static final String RACE_INDIAN = "RACE_INDIAN";
  public static final String RACE_ASIAN = "RACE_ASIAN";
  public static final String RACE_HAWAIIAN = "RACE_HAWAIIAN";
  public static final String RACE_MULTI = "RACE_MULTI";
  public static final String RACE_UNKNOWN = "RACE_UNKNOWN";
  public static final String CHILD_SEX = "CHILD_SEX";
  public static final String CHILD_MED_NUM = "CHILD_MED_NUM";
  public static final String MEDICAID_CHK = "MEDICAID_CHK";
  // public static final String CHILD_DOB = "CHILD_DOB";  Declared in BaseDocumentServiceImpl
  public static final String MOTHER_AGE = "MOTHER_AGE";
  public static final String MOTHER_DOB = "MOTHER_DOB";
  public static final String MOTHER_EDU = "MOTHER_EDU";
  public static final String MARTIAL_STATUS = "MARTIAL_STATUS";
  public static final String MOTHER_MED_NUM = "MOTHER_MED_NUM";
  public static final String GUARDIAN = "GUARDIAN";
  public static final String AGENCY = "AGENCY";
 
 /** SECTION D Signatures **/
  public static final String CASE_MANAGER = "CASE_MANAGER";
  public static final String MANAGER_PHONE = "MANAGER_PHONE";
  public static final String APPR_DATE = "APPR_DATE";
  public static final String CHILD_NAME = "CHILD_NAME";
  public static final String MOTHER_NAME = "MOTHER_NAME";
  public static final String TODAY = "TODAY";
  
 
 /** SECTION G COMMENTS **/
  public static final String INV_DET = "INV_DET";
  public static final String LEGAL_STATUS = "LEGAL_STATUS";
  public static final String FCC_MANAGER = "FCC_MANAGER";
  public static final String FCC_MANAGER_PHONE = "FCC_MANAGER_PHONE";
  public static final String FCC_MANAGER_EMAIL = "FCC_MANAGER_EMAIL";
  public static final String FCC_MANAGER_ADDR1 = "FCC_MANAGER_ADDR1";
  public static final String FCC_MANAGER_ADDR = "FCC_MANAGER_ADDR";
  public static final String MOM_NAME = "MOM_NAME";
  public static final String MOM_ADDR = "MOM_ADDR";
  public static final String MOM_ZIP = "MOM_ZIP";
  public static final String MOM_PHONE = "MOM_PHONE";
  public static final String DAD_NAME = "DAD_NAME";
  public static final String DAD_ADDR = "DAD_ADDR";
  public static final String DAD_ZIP = "DAD_ZIP";
  public static final String DAD_PHONE = "DAD_PHONE";
  

  
  public SCRNREFSO retrieveScreeningAndReferral(SCRNREFSI scrnrefsi);

}
  
