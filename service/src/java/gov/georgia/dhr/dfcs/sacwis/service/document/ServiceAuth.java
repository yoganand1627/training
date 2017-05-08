package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SERVICEAUTHSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SERVICEAUTHSO;

public interface ServiceAuth extends DocumentService {
  // Group Names
  static final String FCM06O00 = "FCM06O00";

  static final String FCM06O002 = "FCM06O002";

  // Form Group Bookmark Names
  static final String TMPLAT_PERSON_RELATIONSHIP = "TMPLAT_PERSON_RELATIONSHIP";

  static final String TMPLAT_SERVICE = "TMPLAT_SERVICE";

  static final String TMPLAT_OTHER_MEMBERS = "TMPLAT_OTHER_MEMBERS";

  static final String TMPLAT_APPROVAL_INFORMATION = "TMPLAT_APPROVAL_INFORMATION";

  static final String TMPLAT_DENIAL_INFORMATION = "TMPLAT_DENIAL_INFORMATION";

  // Bookmark name
  static final String CASE_NAME = "CASE_NAME";

  static final String CASE_NUM = "CASE_NUM";

  static final String CASE_TYPE = "CASE_TYPE";

  static final String CLIENT_ADDRESS = "CLIENT_ADDRESS";

  static final String REFERRAL_DATE = "REFERRAL_DATE";

  static final String CLIENT_CITY = "CLIENT_CITY";

  static final String CLIENT_STATE = "CLIENT_STATE";

  static final String CLIENT_ZIP = "CLIENT_ZIP";

  static final String CLIENT_TELE = "CLIENT_TELE";

  static final String CLIENT_FAX = "CLIENT_FAX";

  static final String CD_SVC_QLTY = "CD_SVC_QLTY";

  static final String CURRENT_DATE = "CURRENT_DATE";

  static final String TXT_CMMTS = "TXT_CMMTS";

  static final String REFERRAL_REASON = "REFERRAL_REASON";

  static final String DT_SVC_AUTH_DTL_UNIT_TYPE = "DT_SVC_AUTH_DTL_UNIT_TYPE";

  static final String CD_SVC_AUTH_DTL_SVC = "CD_SVC_AUTH_DTL_SVC";

  static final String DT_SVC_AUTH_DTL_BEGIN = "DT_SVC_AUTH_DTL_BEGIN";

  static final String DT_SVC_AUTH_DTL_END = "DT_SVC_AUTH_DTL_END";

  static final String DT_SVC_AUTH_DTL_TERM = "DT_SVC_AUTH_DTL_TERM";

  static final String NBR_SVC_AUTH_DTL_FREQ = "NBR_SVC_AUTH_DTL_FREQ";

  static final String NBR_SVC_AUTH_DTL_SUG_UNIT = "NBR_SVC_AUTH_DTL_SUG_UNIT";

  static final String CD_SVC_AUTH_DTL_AUTH_TYPE = "CD_SVC_AUTH_DTL_AUTH_TYPE";

  static final String CD_SVC_AUTH_DTL_UNIT_TYPE = "CD_SVC_AUTH_DTL_UNIT_TYPE";

  static final String CD_SVC_AUTH_DTL_PERIOD = "CD_SVC_AUTH_DTL_PERIOD";

  static final String NBR_SVC_AUTH_DTL_UNITS_REQ = "NBR_SVC_AUTH_DTL_UNITS_REQ";

  static final String AMT_SVC_AUTH_DTL_AMT_REQ = "AMT_SVC_AUTH_DTL_AMT_REQ";

  static final String NBR_SVC_AUTH_DTL_UNIT_REQ = "NBR_SVC_AUTH_DTL_UNIT_REQ";

  static final String ID_PERSON = "ID_PERSON";

  static final String CD_STAGE_PERS_REL_INT = "CD_STAGE_PERS_REL_INT";

  static final String IND_SERV_ACPT = "IND_SERV_ACPT";

  static final String PERSON_NAME_LAST = "PERSON_NAME_LAST";

  static final String PERSON_NAME_FIRST = "PERSON_NAME_FIRST";

  static final String PERSON_NAME_MIDDLE = "PERSON_NAME_MIDDLE";

  static final String IND_CASE_PLN_SVC = "IND_CASE_PLN_SVC";

  static final String OTHER_NM = "OTHER_NM";

  static final String NBR_MEDICAID = "NBR_MEDICAID";

  static final String DT_BIRTH = "DT_BIRTH";

  static final String ETHNICITY = "ETHNICITY";

  static final String SSN = "SSN";

  static final String RELATIONSHIP = "RELATIONSHIP";

  static final String MANAGER_NM = "MANAGER_NM";

  static final String MANAGER_ID_NUM = "MANAGER_ID_NUM";

  static final String AGENCY_ADDRESS = "AGENCY_ADDRESS";

  static final String AGENCY_ADDRESS2 = "AGENCY_ADDRESS2";

  static final String AGENCY_CITY = "AGENCY_CITY";

  static final String AGENCY_ZIP = "AGENCY_ZIP";

  static final String AGENCY_COUNTY = "AGENCY_COUNTY";

  static final String AGENCY_TELE = "AGENCY_TELE";

  static final String DT_APPROVED = "DT_APPROVED";

  static final String AGENCY_DIRECTOR = "AGENCY_DIRECTOR";

  static final String REASON_DENIED = "REASON_DENIED";

  static final String DT_DENIED = "DT_DENIED";

  public static final String SERVICE_NAMES = "SERVICE_NAMES";

  public static final String SERVICE = "SERVICE";

  public static final String SERVICE_AUTH_ID = "SERVICE_AUTH_ID";

  public static final String AGENCY_STATE = "AGENCY_STATE";

  public static final String SERVICE_PROVIDER = "SERVICE_PROVIDER";

  public static final String SERVICE_ID_NUM = "SERVICE_ID_NUM";

  public static final String SERVICE_ADDRESS = "SERVICE_ADDRESS";

  
  public static final String SERVICE_CITY = "SERVICE_CITY";

  public static final String SERVICE_STATE = "SERVICE_STATE";

  public static final String SERVICE_ZIP = "SERVICE_ZIP";

  public static final String SERVICE_TELEPHONE_NUM = "SERVICE_TELEPHONE_NUM";

  public static final String SERVICE_FAX_NUM = "SERVICE_FAX_NUM";

  public static final String SERVICE_ADDRESS2 = "SERVICE_ADDRESS2";

  public static final String PERFERRED_SUB = "PERFERRED_SUB";

  SERVICEAUTHSO retrieveServiceAuth(SERVICEAUTHSI serciveAuthSI);
}
