package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public class FceApplicationDB
        implements Serializable {
  public static final String ADDR_HEALTH_ADDR_CITY = "addrHealthAddrCity";
  public static final String ADDR_HEALTH_ADDR_ST_LN1 = "addrHealthAddrStLn1";
  public static final String ADDR_HEALTH_ADDR_ST_LN2 = "addrHealthAddrStLn2";
  public static final String ADDR_HEALTH_ADDR_ZIP = "addrHealthAddrZip";
  public static final String ADDR_REMOVAL_ADDR_ZIP = "addrRemovalAddrZip";
  public static final String ADDR_REMOVAL_CITY = "addrRemovalCity";
  public static final String ADDR_REMOVAL_ST_LN1 = "addrRemovalStLn1";
  public static final String ADDR_REMOVAL_ST_LN2 = "addrRemovalStLn2";
  public static final String CD_APPLICATION = "cdApplication";
  public static final String CD_COUNTY_HOSPITAL = "cdCountyHospital";
  public static final String CD_HEALTH_ADDR_STATE = "cdHealthAddrState";
  public static final String CD_LIVING_MONTH_REMOVAL = "cdLivingMonthRemoval";
  public static final String CD_NOTA_MOST_RECENT = "cdNotaMostRecent";
  public static final String CD_REMOVAL_ADDR_COUNTY = "cdRemovalAddrCounty";
  public static final String CD_REMOVAL_ADDR_STATE = "cdRemovalAddrState";
  public static final String CD_STATE = "cdState";
  public static final String DT_APPLICATION_COMPLETE_STRING = "dtApplicationCompleteString";
  public static final String DT_APPLICATION_COMPLETE_TIME = "dtApplicationCompleteTime";
  public static final String DT_HEALTH_BEGIN_DATE_STRING = "dtHealthBeginDateString";
  public static final String DT_HEALTH_BEGIN_DATE_TIME = "dtHealthBeginDateTime";
  public static final String DT_HEALTH_END_DATE_STRING = "dtHealthEndDateString";
  public static final String DT_HEALTH_END_DATE_TIME = "dtHealthEndDateTime";
  public static final String DT_HOSPITAL_ADMISSION_STRING = "dtHospitalAdmissionString";
  public static final String DT_HOSPITAL_ADMISSION_TIME = "dtHospitalAdmissionTime";
  public static final String DT_HOSPITAL_DISCHARGE_STRING = "dtHospitalDischargeString";
  public static final String DT_HOSPITAL_DISCHARGE_TIME = "dtHospitalDischargeTime";
  public static final String DT_LAST_UPDATE_STRING = "dtLastUpdateString";
  public static final String DT_LAST_UPDATE_TIME = "dtLastUpdateTime";
  public static final String DT_NOTIFIED_WORKER_STRING = "dtNotifiedWorkerString";
  public static final String DT_NOTIFIED_WORKER_TIME = "dtNotifiedWorkerTime";
  public static final String DT_PROOF_AGE_SENT_ES_STRING = "dtProofAgeSentEsString";
  public static final String DT_PROOF_AGE_SENT_ES_TIME = "dtProofAgeSentEsTime";
  public static final String DT_PROOF_CITIZENSHIP_SENT_ES_STRING = "dtProofCitizenshipSentEsString";
  public static final String DT_PROOF_CITIZENSHIP_SENT_ES_TIME = "dtProofCitizenshipSentEsTime";
  public static final String DT_REMOVAL_DATE_STRING = "dtRemovalDateString";
  public static final String DT_REMOVAL_DATE_TIME = "dtRemovalDateTime";
  public static final String ID_CASE = "idCase";
  public static final String ID_EVENT = "idEvent";
  public static final String ID_FCE_APPLICATION = "idFceApplication";
  public static final String ID_FCE_ELIGIBILITY = "idFceEligibility";
  public static final String ID_LAST_UPDATE_PERSON = "idLastUpdatePerson";
  public static final String ID_MNGNG_CVS_PERSON = "idMngngCvsPerson";
  public static final String ID_OTHER_RELATIVE_PERSON = "idOtherRelativePerson";
  public static final String ID_PERSON = "idPerson";
  public static final String ID_STAGE = "idStage";
  public static final String IND_AGE_JUSTIFIED_EVAL = "indAgeJustifiedEval";
  public static final String IND_AGE_VRFD_BAPTISM_CERT = "indAgeVrfdBaptismCert";
  public static final String IND_AGE_VRFD_FOREIGN_CERT = "indAgeVrfdForeignCert";
  public static final String IND_AGE_VRFD_HOSPITAL_CERT = "indAgeVrfdHospitalCert";
  public static final String IND_AGE_VRFD_NTRLZTN_CERT = "indAgeVrfdNtrlztnCert";
  public static final String IND_AGE_VRFD_PASSPORT = "indAgeVrfdPassport";
  public static final String IND_AGE_VRFD_RESIDENT_CARD = "indAgeVrfdResidentCard";
  public static final String IND_AGE_VRFD_SAVE_SYSTEM = "indAgeVrfdSaveSystem";
  public static final String IND_AGE_VRFD_SUCCESS_SYSTEM = "indAgeVrfdSuccessSystem";
  public static final String IND_AGE_VRFD_US_BIRTH_CERT = "indAgeVrfdUsBirthCert";
  public static final String IND_AMENDED_APP = "indAmendedApp";
  public static final String IND_CHILD_SUPPORT_ORDER = "indChildSupportOrder";
  public static final String IND_EVALUATION_CONCLUSION = "indEvaluationConclusion";
  public static final String IND_HOSPITAL = "indHospital";
  public static final String IND_INCOME_ASSISTANCE = "indIncomeAssistance";
  public static final String IND_LEGAL_DOCS_SENT_ES = "indLegalDocsSentEs";
  public static final String IND_LIVING_RELATIVE_SIX_MONTH = "indLivingRelativeSixMonth";
  public static final String IND_MANAGING_CVS = "indManagingCvs";
  public static final String IND_MINOR_PARENT = "indMinorParent";
  public static final String IND_NOTIFIED_DHS_WORKER = "indNotifiedDhsWorker";
  public static final String IND_OTHER_HEALTH_INSURANCE = "indOtherHealthInsurance";
  public static final String IND_PROOF_AGE_SENT_ES = "indProofAgeSentEs";
  public static final String IND_PROOF_CITIZENSHIP_SENT_ES = "indProofCitizenshipSentEs";
  public static final String IND_SPECIFIED_RELATIVE = "indSpecifiedRelative";
  public static final String NBR_COURT_MONTH = "nbrCourtMonth";
  public static final String NBR_COURT_YEAR = "nbrCourtYear";
  public static final String NBR_HEALTH_GROUP = "nbrHealthGroup";
  public static final String NBR_HEALTH_POLICY = "nbrHealthPolicy";
  public static final String NBR_LIVING_AT_HOME = "nbrLivingAtHome";
  public static final String NBR_NOTIFIED_DHS_WRKR_PHN = "nbrNotifiedDhsWrkrPhn";
  public static final String NM_HEALTH_COMPANY = "nmHealthCompany";
  public static final String NM_HEALTH_EMPLOYEE_NM = "nmHealthEmployeeNm";
  public static final String NM_HEALTH_EMPLOYER_NM = "nmHealthEmployerNm";
  public static final String NM_HEALTH_POLICY_HLDR_NM = "nmHealthPolicyHldrNm";
  public static final String NM_HOSPITAL = "nmHospital";
  public static final String NM_HOSPITAL_CITY = "nmHospitalCity";
  public static final String NM_MOTHER_MAIDEN = "nmMotherMaiden";
  public static final String NM_NOTIFIED_DHS_WRKR_FIRST = "nmNotifiedDhsWrkrFirst";
  public static final String NM_NOTIFIED_DHS_WRKR_LAST = "nmNotifiedDhsWrkrLast";
  public static final String NM_NOTIFIED_DHS_WRKR_MIDDLE = "nmNotifiedDhsWrkrMiddle";
  public static final String TXT_INCOME_DTRMNTN_COMMENTS = "txtIncomeDtrmntnComments";
  public static final String TXT_LEGAL_DOCS_SENT_ES = "txtLegalDocsSentEs";
  public static final String TXT_MEETS_DD_OR_NOT_COMMENTS = "txtMeetsDdOrNotComments";
  public static final String TXT_NO_INCOME_EXPLANATION = "txtNoIncomeExplanation";
  public static final String TXT_PROOF_AGE_SENT_ES = "txtProofAgeSentEs";
  public static final String TXT_PROOF_CITIZENSHIP_SENT_ES = "txtProofCitizenshipSentEs";
  public static final String TXT_PROOF_PRIOR_REMOVAL_MONTHS = "txtPriorRemovalMonths";
  public static final String IND_PROOF_CHILD_ID_SENT_ES = "indProofChildIdSentEs";
  public static final String DT_PROOF_CHILD_ID_SENT_ES_STRING = "dtProofChildIdSentEs";
  public static final String TXT_PROOF_CHILD_ID_SENT_ES = "txtProofChildIdSentEs";
  public static final String IND_PROOF_PREGNANCY_SENT_ES = "indProofPregnancySentEs";
  public static final String DT_PROOF_PREGNANCY_SENT_ES_STRING = "dtProofPregnancySentEs";
  public static final String TXT_PROOF_PREGNANCY_SENT_ES = "txtProofPregnancySentEs";
  public static final String TXT_EMPLOYEE_COMMENTS = "txtEmployeeComments";
  public static final String DT_LEGAL_DOCS_SENT_ES_STRING = "dtLegalDocsSentEsString";
  
  protected boolean hasAddrHealthAddrCity = false;
  protected String addrHealthAddrCity = null;
  protected boolean hasAddrHealthAddrStLn1 = false;
  protected String addrHealthAddrStLn1 = null;
  protected boolean hasAddrHealthAddrStLn2 = false;
  protected String addrHealthAddrStLn2 = null;
  protected boolean hasAddrHealthAddrZip = false;
  protected String addrHealthAddrZip = null;
  protected boolean hasAddrRemovalAddrZip = false;
  protected String addrRemovalAddrZip = null;
  protected boolean hasAddrRemovalCity = false;
  protected String addrRemovalCity = null;
  protected boolean hasAddrRemovalStLn1 = false;
  protected String addrRemovalStLn1 = null;
  protected boolean hasAddrRemovalStLn2 = false;
  protected String addrRemovalStLn2 = null;
  protected boolean hasCdApplication = false;
  protected String cdApplication = null;
  protected boolean hasCdCountyHospital = false;
  protected String cdCountyHospital = null;
  protected boolean hasCdHealthAddrState = false;
  protected String cdHealthAddrState = null;
  protected boolean hasCdLivingMonthRemoval = false;
  protected String cdLivingMonthRemoval = null;
  protected boolean hasCdNotaMostRecent = false;
  protected String cdNotaMostRecent = null;
  protected boolean hasCdRemovalAddrCounty = false;
  protected String cdRemovalAddrCounty = null;
  protected boolean hasCdRemovalAddrState = false;
  protected String cdRemovalAddrState = null;
  protected boolean hasCdState = false;
  protected String cdState = null;
  protected boolean hasDtApplicationComplete = false;
  protected Date dtApplicationComplete = null;
  protected boolean hasDtHealthBeginDate = false;
  protected Date dtHealthBeginDate = null;
  protected boolean hasDtHealthEndDate = false;
  protected Date dtHealthEndDate = null;
  protected boolean hasDtHospitalAdmission = false;
  protected Date dtHospitalAdmission = null;
  protected boolean hasDtHospitalDischarge = false;
  protected Date dtHospitalDischarge = null;
  protected boolean hasDtLastUpdate = false;
  protected Date dtLastUpdate = null;
  protected boolean hasDtNotifiedWorker = false;
  protected Date dtNotifiedWorker = null;
  protected boolean hasDtProofAgeSentEs = false;
  protected Date dtProofAgeSentEs = null;
  protected boolean hasDtProofCitizenshipSentEs = false;
  protected Date dtProofCitizenshipSentEs = null;
  protected boolean hasDtRemovalDate = false;
  protected Date dtRemovalDate = null;
  protected boolean hasIdCase = false;
  protected Long idCase = null;
  protected boolean hasIdEvent = false;
  protected Long idEvent = null;
  protected boolean hasIdFceApplication = false;
  protected Long idFceApplication = null;
  protected boolean hasIdFceEligibility = false;
  protected Long idFceEligibility = null;
  protected boolean hasIdLastUpdatePerson = false;
  protected Long idLastUpdatePerson = null;
  protected boolean hasIdMngngCvsPerson = false;
  protected Long idMngngCvsPerson = null;
  protected boolean hasIdOtherRelativePerson = false;
  protected Long idOtherRelativePerson = null;
  protected boolean hasIdPerson = false;
  protected Long idPerson = null;
  protected boolean hasIdStage = false;
  protected Long idStage = null;
  protected boolean hasIndAgeJustifiedEval = false;
  protected Boolean indAgeJustifiedEval = null;
  protected boolean hasIndAgeVrfdBaptismCert = false;
  protected Boolean indAgeVrfdBaptismCert = null;
  protected boolean hasIndAgeVrfdForeignCert = false;
  protected Boolean indAgeVrfdForeignCert = null;
  protected boolean hasIndAgeVrfdHospitalCert = false;
  protected Boolean indAgeVrfdHospitalCert = null;
  protected boolean hasIndAgeVrfdNtrlztnCert = false;
  protected Boolean indAgeVrfdNtrlztnCert = null;
  protected boolean hasIndAgeVrfdPassport = false;
  protected Boolean indAgeVrfdPassport = null;
  protected boolean hasIndAgeVrfdResidentCard = false;
  protected Boolean indAgeVrfdResidentCard = null;
  protected boolean hasIndAgeVrfdSaveSystem = false;
  protected Boolean indAgeVrfdSaveSystem = null;
  protected boolean hasIndAgeVrfdSuccessSystem = false;
  protected Boolean indAgeVrfdSuccessSystem = null;
  protected boolean hasIndAgeVrfdUsBirthCert = false;
  protected Boolean indAgeVrfdUsBirthCert = null;
  protected boolean hasIndAmendedApp = false;
  protected Boolean indAmendedApp = null;
  protected boolean hasIndChildSupportOrder = false;
  protected Boolean indChildSupportOrder = null;
  protected boolean hasIndEvaluationConclusion = false;
  protected Boolean indEvaluationConclusion = null;
  protected boolean hasIndHospital = false;
  protected Boolean indHospital = null;
  protected boolean hasIndIncomeAssistance = false;
  protected Boolean indIncomeAssistance = null;
  protected boolean hasIndLegalDocsSentEs = false;
  protected Boolean indLegalDocsSentEs = null;
  protected boolean hasIndLivingRelativeSixMonth = false;
  protected Boolean indLivingRelativeSixMonth = null;
  protected boolean hasIndManagingCvs = false;
  protected Boolean indManagingCvs = null;
  protected boolean hasIndMinorParent = false;
  protected Boolean indMinorParent = null;
  protected boolean hasIndNotifiedDhsWorker = false;
  protected Boolean indNotifiedDhsWorker = null;
  protected boolean hasIndOtherHealthInsurance = false;
  protected Boolean indOtherHealthInsurance = null;
  protected boolean hasIndProofAgeSentEs = false;
  protected Boolean indProofAgeSentEs = null;
  protected boolean hasIndProofCitizenshipSentEs = false;
  protected Boolean indProofCitizenshipSentEs = null;
  protected boolean hasIndSpecifiedRelative = false;
  protected Boolean indSpecifiedRelative = null;
  protected boolean hasNbrCourtMonth = false;
  protected Long nbrCourtMonth = null;
  protected boolean hasNbrCourtYear = false;
  protected Long nbrCourtYear = null;
  protected boolean hasNbrHealthGroup = false;
  protected String nbrHealthGroup = null;
  protected boolean hasNbrHealthPolicy = false;
  protected String nbrHealthPolicy = null;
  protected boolean hasNbrLivingAtHome = false;
  protected Long nbrLivingAtHome = null;
  protected boolean hasNbrNotifiedDhsWrkrPhn = false;
  protected String nbrNotifiedDhsWrkrPhn = null;
  protected boolean hasNmHealthCompany = false;
  protected String nmHealthCompany = null;
  protected boolean hasNmHealthEmployeeNm = false;
  protected String nmHealthEmployeeNm = null;
  protected boolean hasNmHealthEmployerNm = false;
  protected String nmHealthEmployerNm = null;
  protected boolean hasNmHealthPolicyHldrNm = false;
  protected String nmHealthPolicyHldrNm = null;
  protected boolean hasNmHospital = false;
  protected String nmHospital = null;
  protected boolean hasNmHospitalCity = false;
  protected String nmHospitalCity = null;
  protected boolean hasNmMotherMaiden = false;
  protected String nmMotherMaiden = null;
  protected boolean hasNmNotifiedDhsWrkrFirst = false;
  protected String nmNotifiedDhsWrkrFirst = null;
  protected boolean hasNmNotifiedDhsWrkrLast = false;
  protected String nmNotifiedDhsWrkrLast = null;
  protected boolean hasNmNotifiedDhsWrkrMiddle = false;
  protected String nmNotifiedDhsWrkrMiddle = null;
  protected boolean hasTxtIncomeDtrmntnComments = false;
  protected String txtIncomeDtrmntnComments = null;
  protected boolean hasTxtLegalDocsSentEs = false;
  protected String txtLegalDocsSentEs = null;
  protected boolean hasTxtMeetsDdOrNotComments = false;
  protected String txtMeetsDdOrNotComments = null;
  protected boolean hasTxtNoIncomeExplanation = false;
  protected String txtNoIncomeExplanation = null;
  protected boolean hasTxtProofAgeSentEs = false;
  protected String txtProofAgeSentEs = null;
  protected boolean hasTxtProofCitizenshipSentEs = false;
  protected String txtProofCitizenshipSentEs = null;
  protected boolean hasTxtPriorRemovalMonths = false;
  protected String txtPriorRemovalMonths = null;
  protected boolean hasIndProofChildIdSentEs = false;
  protected Boolean indProofChildIdSentEs = null;
  protected boolean hasDtProofChildIdSentEs = false;
  protected Date dtProofChildIdSentEs = null;
  protected boolean hasTxtProofChildIdSentEs = false;
  protected String txtProofChildIdSentEs = null;
  protected boolean hasIndProofPregnancySentEs = false;
  protected Boolean indProofPregnancySentEs = null;
  protected boolean hasDtProofPregnancySentEs = false;
  protected Date dtProofPregnancySentEs = null;
  protected boolean hasTxtProofPregnancySentEs = false;
  protected String txtProofPregnancySentEs = null;
  protected boolean hasTxtEmployeeComments = false;
  protected String txtEmployeeComments = null;
  protected boolean hasDtLegalDocsSentEs = false;
  protected Date dtLegalDocsSentEs = null;
  
  protected boolean hasRemovalAddress = false;
  
  public boolean hasRemovalAddress() {
    hasRemovalAddress = false;
    if (StringHelper.isValid(addrRemovalStLn1) || StringHelper.isValid(addrRemovalStLn2) ||
                    StringHelper.isValid(addrRemovalCity) || StringHelper.isValid(addrRemovalAddrZip) ||
                    StringHelper.isValid(cdRemovalAddrCounty) || StringHelper.isValid(cdRemovalAddrState)) {
      hasRemovalAddress = true;
    }
    return hasRemovalAddress;
  }
  
  public boolean hasAddrHealthAddrCity() {
    return hasAddrHealthAddrCity;
  }

  public String getAddrHealthAddrCity() {
    if (addrHealthAddrCity == null) {
      return "";
    }
    return addrHealthAddrCity;
  }

  public String getAddrHealthAddrCityObject() {
    return addrHealthAddrCity;
  }

  public void setAddrHealthAddrCity(String addrHealthAddrCity) {
    if ((addrHealthAddrCity != null) &&
        (addrHealthAddrCity.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'addrHealthAddrCity'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + addrHealthAddrCity + "'");
    }
    this.hasAddrHealthAddrCity = true;
    this.addrHealthAddrCity = addrHealthAddrCity;
  }

  public boolean hasAddrHealthAddrStLn1() {
    return hasAddrHealthAddrStLn1;
  }

  public String getAddrHealthAddrStLn1() {
    if (addrHealthAddrStLn1 == null) {
      return "";
    }
    return addrHealthAddrStLn1;
  }

  public String getAddrHealthAddrStLn1Object() {
    return addrHealthAddrStLn1;
  }

  public void setAddrHealthAddrStLn1(String addrHealthAddrStLn1) {
    if ((addrHealthAddrStLn1 != null) &&
        (addrHealthAddrStLn1.length() > 30)) {
      throw new IllegalStateException("Data is too large for 'addrHealthAddrStLn1'; \n" +
                                      " max size = 30; \n" +
                                      " data = '" + addrHealthAddrStLn1 + "'");
    }
    this.hasAddrHealthAddrStLn1 = true;
    this.addrHealthAddrStLn1 = addrHealthAddrStLn1;
  }

  public boolean hasAddrHealthAddrStLn2() {
    return hasAddrHealthAddrStLn2;
  }

  public String getAddrHealthAddrStLn2() {
    if (addrHealthAddrStLn2 == null) {
      return "";
    }
    return addrHealthAddrStLn2;
  }

  public String getAddrHealthAddrStLn2Object() {
    return addrHealthAddrStLn2;
  }

  public void setAddrHealthAddrStLn2(String addrHealthAddrStLn2) {
    if ((addrHealthAddrStLn2 != null) &&
        (addrHealthAddrStLn2.length() > 30)) {
      throw new IllegalStateException("Data is too large for 'addrHealthAddrStLn2'; \n" +
                                      " max size = 30; \n" +
                                      " data = '" + addrHealthAddrStLn2 + "'");
    }
    this.hasAddrHealthAddrStLn2 = true;
    this.addrHealthAddrStLn2 = addrHealthAddrStLn2;
  }

  public boolean hasAddrHealthAddrZip() {
    return hasAddrHealthAddrZip;
  }

  public String getAddrHealthAddrZip() {
    if (addrHealthAddrZip == null) {
      return "";
    }
    return addrHealthAddrZip;
  }

  public String getAddrHealthAddrZipObject() {
    return addrHealthAddrZip;
  }

  public void setAddrHealthAddrZip(String addrHealthAddrZip) {
    if ((addrHealthAddrZip != null) &&
        (addrHealthAddrZip.length() > 10)) {
      throw new IllegalStateException("Data is too large for 'addrHealthAddrZip'; \n" +
                                      " max size = 10; \n" +
                                      " data = '" + addrHealthAddrZip + "'");
    }
    this.hasAddrHealthAddrZip = true;
    this.addrHealthAddrZip = addrHealthAddrZip;
  }

  public boolean hasAddrRemovalAddrZip() {
    return hasAddrRemovalAddrZip;
  }

  public String getAddrRemovalAddrZip() {
    if (addrRemovalAddrZip == null) {
      return "";
    }
    return addrRemovalAddrZip;
  }

  public String getAddrRemovalAddrZipObject() {
    return addrRemovalAddrZip;
  }

  public void setAddrRemovalAddrZip(String addrRemovalAddrZip) {
    if ((addrRemovalAddrZip != null) &&
        (addrRemovalAddrZip.length() > 10)) {
      throw new IllegalStateException("Data is too large for 'addrRemovalAddrZip'; \n" +
                                      " max size = 10; \n" +
                                      " data = '" + addrRemovalAddrZip + "'");
    }
    this.hasAddrRemovalAddrZip = true;
    this.addrRemovalAddrZip = addrRemovalAddrZip;
  }

  public boolean hasAddrRemovalCity() {
    return hasAddrRemovalCity;
  }

  public String getAddrRemovalCity() {
    if (addrRemovalCity == null) {
      return "";
    }
    return addrRemovalCity;
  }

  public String getAddrRemovalCityObject() {
    return addrRemovalCity;
  }

  public void setAddrRemovalCity(String addrRemovalCity) {
    if ((addrRemovalCity != null) &&
        (addrRemovalCity.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'addrRemovalCity'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + addrRemovalCity + "'");
    }
    this.hasAddrRemovalCity = true;
    this.addrRemovalCity = addrRemovalCity;
  }

  public boolean hasAddrRemovalStLn1() {
    return hasAddrRemovalStLn1;
  }

  public String getAddrRemovalStLn1() {
    if (addrRemovalStLn1 == null) {
      return "";
    }
    return addrRemovalStLn1;
  }

  public String getAddrRemovalStLn1Object() {
    return addrRemovalStLn1;
  }

  public void setAddrRemovalStLn1(String addrRemovalStLn1) {
    if ((addrRemovalStLn1 != null) &&
        (addrRemovalStLn1.length() > 30)) {
      throw new IllegalStateException("Data is too large for 'addrRemovalStLn1'; \n" +
                                      " max size = 30; \n" +
                                      " data = '" + addrRemovalStLn1 + "'");
    }
    this.hasAddrRemovalStLn1 = true;
    this.addrRemovalStLn1 = addrRemovalStLn1;
  }

  public boolean hasAddrRemovalStLn2() {
    return hasAddrRemovalStLn2;
  }

  public String getAddrRemovalStLn2() {
    if (addrRemovalStLn2 == null) {
      return "";
    }
    return addrRemovalStLn2;
  }

  public String getAddrRemovalStLn2Object() {
    return addrRemovalStLn2;
  }

  public void setAddrRemovalStLn2(String addrRemovalStLn2) {
    if ((addrRemovalStLn2 != null) &&
        (addrRemovalStLn2.length() > 30)) {
      throw new IllegalStateException("Data is too large for 'addrRemovalStLn2'; \n" +
                                      " max size = 30; \n" +
                                      " data = '" + addrRemovalStLn2 + "'");
    }
    this.hasAddrRemovalStLn2 = true;
    this.addrRemovalStLn2 = addrRemovalStLn2;
  }

  public boolean hasCdApplication() {
    return hasCdApplication;
  }

  public String getCdApplication() {
    if (cdApplication == null) {
      return "";
    }
    return cdApplication;
  }

  public String getCdApplicationObject() {
    return cdApplication;
  }

  public void setCdApplication(String cdApplication) {
    if ((cdApplication != null) &&
        (cdApplication.length() > 4)) {
      throw new IllegalStateException("Data is too large for 'cdApplication'; \n" +
                                      " max size = 4; \n" +
                                      " data = '" + cdApplication + "'");
    }
    this.hasCdApplication = true;
    this.cdApplication = cdApplication;
  }

  public boolean hasCdCountyHospital() {
    return hasCdCountyHospital;
  }

  public String getCdCountyHospital() {
    if (cdCountyHospital == null) {
      return "";
    }
    return cdCountyHospital;
  }

  public String getCdCountyHospitalObject() {
    return cdCountyHospital;
  }

  public void setCdCountyHospital(String cdCountyHospital) {
    if ((cdCountyHospital != null) &&
        (cdCountyHospital.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdCountyHospital'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdCountyHospital + "'");
    }
    this.hasCdCountyHospital = true;
    this.cdCountyHospital = cdCountyHospital;
  }

  public boolean hasCdHealthAddrState() {
    return hasCdHealthAddrState;
  }

  public String getCdHealthAddrState() {
    if (cdHealthAddrState == null) {
      return "";
    }
    return cdHealthAddrState;
  }

  public String getCdHealthAddrStateObject() {
    return cdHealthAddrState;
  }

  public void setCdHealthAddrState(String cdHealthAddrState) {
    if ((cdHealthAddrState != null) &&
        (cdHealthAddrState.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdHealthAddrState'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdHealthAddrState + "'");
    }
    this.hasCdHealthAddrState = true;
    this.cdHealthAddrState = cdHealthAddrState;
  }

  public boolean hasCdLivingMonthRemoval() {
    return hasCdLivingMonthRemoval;
  }

  public String getCdLivingMonthRemoval() {
    if (cdLivingMonthRemoval == null) {
      return "";
    }
    return cdLivingMonthRemoval;
  }

  public String getCdLivingMonthRemovalObject() {
    return cdLivingMonthRemoval;
  }

  public void setCdLivingMonthRemoval(String cdLivingMonthRemoval) {
    if ((cdLivingMonthRemoval != null) &&
        (cdLivingMonthRemoval.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdLivingMonthRemoval'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdLivingMonthRemoval + "'");
    }
    this.hasCdLivingMonthRemoval = true;
    this.cdLivingMonthRemoval = cdLivingMonthRemoval;
  }

  public boolean hasCdNotaMostRecent() {
    return hasCdNotaMostRecent;
  }

  public String getCdNotaMostRecent() {
    if (cdNotaMostRecent == null) {
      return "";
    }
    return cdNotaMostRecent;
  }

  public String getCdNotaMostRecentObject() {
    return cdNotaMostRecent;
  }

  public void setCdNotaMostRecent(String cdNotaMostRecent) {
    if ((cdNotaMostRecent != null) &&
        (cdNotaMostRecent.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdNotaMostRecent'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdNotaMostRecent + "'");
    }
    this.hasCdNotaMostRecent = true;
    this.cdNotaMostRecent = cdNotaMostRecent;
  }

  public boolean hasCdRemovalAddrCounty() {
    return hasCdRemovalAddrCounty;
  }

  public String getCdRemovalAddrCounty() {
    if (cdRemovalAddrCounty == null) {
      return "";
    }
    return cdRemovalAddrCounty;
  }

  public String getCdRemovalAddrCountyObject() {
    return cdRemovalAddrCounty;
  }

  public void setCdRemovalAddrCounty(String cdRemovalAddrCounty) {
    if ((cdRemovalAddrCounty != null) &&
        (cdRemovalAddrCounty.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdRemovalAddrCounty'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdRemovalAddrCounty + "'");
    }
    this.hasCdRemovalAddrCounty = true;
    this.cdRemovalAddrCounty = cdRemovalAddrCounty;
  }

  public boolean hasCdRemovalAddrState() {
    return hasCdRemovalAddrState;
  }

  public String getCdRemovalAddrState() {
    if (cdRemovalAddrState == null) {
      return "";
    }
    return cdRemovalAddrState;
  }

  public String getCdRemovalAddrStateObject() {
    return cdRemovalAddrState;
  }

  public void setCdRemovalAddrState(String cdRemovalAddrState) {
    if ((cdRemovalAddrState != null) &&
        (cdRemovalAddrState.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdRemovalAddrState'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdRemovalAddrState + "'");
    }
    this.hasCdRemovalAddrState = true;
    this.cdRemovalAddrState = cdRemovalAddrState;
  }

  public boolean hasCdState() {
    return hasCdState;
  }

  public String getCdState() {
    if (cdState == null) {
      return "";
    }
    return cdState;
  }

  public String getCdStateObject() {
    return cdState;
  }

  public void setCdState(String cdState) {
    if ((cdState != null) &&
        (cdState.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdState'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdState + "'");
    }
    this.hasCdState = true;
    this.cdState = cdState;
  }

  public boolean hasDtApplicationComplete() {
    return hasDtApplicationComplete;
  }

  public Date getDtApplicationComplete() {
    return dtApplicationComplete;
  }

  public Date getDtApplicationCompleteObject() {
    return dtApplicationComplete;
  }

  public String getDtApplicationCompleteString() {
    return toString(dtApplicationComplete);
  }

  public long getDtApplicationCompleteTime() {
    return toTime(dtApplicationComplete);
  }

  public void setDtApplicationComplete(Date dtApplicationComplete) {
    this.hasDtApplicationComplete = true;
    if ((dtApplicationComplete != null) &&
        (dtApplicationComplete.getTime() == 0)) {
      dtApplicationComplete = null;
    }
    this.dtApplicationComplete = dtApplicationComplete;
  }

  public void setDtApplicationCompleteString(String dtApplicationCompleteString) {
    this.hasDtApplicationComplete = true;
    this.dtApplicationComplete = toDate(dtApplicationCompleteString);
  }

  public void setDtApplicationCompleteTime(long dtApplicationCompleteTime) {
    this.hasDtApplicationComplete = true;
    this.dtApplicationComplete = toDate(dtApplicationCompleteTime);
  }

  public boolean hasDtHealthBeginDate() {
    return hasDtHealthBeginDate;
  }

  public Date getDtHealthBeginDate() {
    return dtHealthBeginDate;
  }

  public Date getDtHealthBeginDateObject() {
    return dtHealthBeginDate;
  }

  public String getDtHealthBeginDateString() {
    return toString(dtHealthBeginDate);
  }

  public long getDtHealthBeginDateTime() {
    return toTime(dtHealthBeginDate);
  }

  public void setDtHealthBeginDate(Date dtHealthBeginDate) {
    this.hasDtHealthBeginDate = true;
    if ((dtHealthBeginDate != null) &&
        (dtHealthBeginDate.getTime() == 0)) {
      dtHealthBeginDate = null;
    }
    this.dtHealthBeginDate = dtHealthBeginDate;
  }

  public void setDtHealthBeginDateString(String dtHealthBeginDateString) {
    this.hasDtHealthBeginDate = true;
    this.dtHealthBeginDate = toDate(dtHealthBeginDateString);
  }

  public void setDtHealthBeginDateTime(long dtHealthBeginDateTime) {
    this.hasDtHealthBeginDate = true;
    this.dtHealthBeginDate = toDate(dtHealthBeginDateTime);
  }

  public boolean hasDtHealthEndDate() {
    return hasDtHealthEndDate;
  }

  public Date getDtHealthEndDate() {
    return dtHealthEndDate;
  }

  public Date getDtHealthEndDateObject() {
    return dtHealthEndDate;
  }

  public String getDtHealthEndDateString() {
    return toString(dtHealthEndDate);
  }

  public long getDtHealthEndDateTime() {
    return toTime(dtHealthEndDate);
  }

  public void setDtHealthEndDate(Date dtHealthEndDate) {
    this.hasDtHealthEndDate = true;
    if ((dtHealthEndDate != null) &&
        (dtHealthEndDate.getTime() == 0)) {
      dtHealthEndDate = null;
    }
    this.dtHealthEndDate = dtHealthEndDate;
  }

  public void setDtHealthEndDateString(String dtHealthEndDateString) {
    this.hasDtHealthEndDate = true;
    this.dtHealthEndDate = toDate(dtHealthEndDateString);
  }

  public void setDtHealthEndDateTime(long dtHealthEndDateTime) {
    this.hasDtHealthEndDate = true;
    this.dtHealthEndDate = toDate(dtHealthEndDateTime);
  }

  public boolean hasDtHospitalAdmission() {
    return hasDtHospitalAdmission;
  }

  public Date getDtHospitalAdmission() {
    return dtHospitalAdmission;
  }

  public Date getDtHospitalAdmissionObject() {
    return dtHospitalAdmission;
  }

  public String getDtHospitalAdmissionString() {
    return toString(dtHospitalAdmission);
  }

  public long getDtHospitalAdmissionTime() {
    return toTime(dtHospitalAdmission);
  }

  public void setDtHospitalAdmission(Date dtHospitalAdmission) {
    this.hasDtHospitalAdmission = true;
    if ((dtHospitalAdmission != null) &&
        (dtHospitalAdmission.getTime() == 0)) {
      dtHospitalAdmission = null;
    }
    this.dtHospitalAdmission = dtHospitalAdmission;
  }

  public void setDtHospitalAdmissionString(String dtHospitalAdmissionString) {
    this.hasDtHospitalAdmission = true;
    this.dtHospitalAdmission = toDate(dtHospitalAdmissionString);
  }

  public void setDtHospitalAdmissionTime(long dtHospitalAdmissionTime) {
    this.hasDtHospitalAdmission = true;
    this.dtHospitalAdmission = toDate(dtHospitalAdmissionTime);
  }

  public boolean hasDtHospitalDischarge() {
    return hasDtHospitalDischarge;
  }

  public Date getDtHospitalDischarge() {
    return dtHospitalDischarge;
  }

  public Date getDtHospitalDischargeObject() {
    return dtHospitalDischarge;
  }

  public String getDtHospitalDischargeString() {
    return toString(dtHospitalDischarge);
  }

  public long getDtHospitalDischargeTime() {
    return toTime(dtHospitalDischarge);
  }

  public void setDtHospitalDischarge(Date dtHospitalDischarge) {
    this.hasDtHospitalDischarge = true;
    if ((dtHospitalDischarge != null) &&
        (dtHospitalDischarge.getTime() == 0)) {
      dtHospitalDischarge = null;
    }
    this.dtHospitalDischarge = dtHospitalDischarge;
  }

  public void setDtHospitalDischargeString(String dtHospitalDischargeString) {
    this.hasDtHospitalDischarge = true;
    this.dtHospitalDischarge = toDate(dtHospitalDischargeString);
  }

  public void setDtHospitalDischargeTime(long dtHospitalDischargeTime) {
    this.hasDtHospitalDischarge = true;
    this.dtHospitalDischarge = toDate(dtHospitalDischargeTime);
  }

  public boolean hasDtLastUpdate() {
    return hasDtLastUpdate;
  }

  public Date getDtLastUpdate() {
    return dtLastUpdate;
  }

  public Date getDtLastUpdateObject() {
    return dtLastUpdate;
  }

  public String getDtLastUpdateString() {
    return toString(dtLastUpdate);
  }

  public long getDtLastUpdateTime() {
    return toTime(dtLastUpdate);
  }

  public void setDtLastUpdate(Date dtLastUpdate) {
    this.hasDtLastUpdate = true;
    if ((dtLastUpdate != null) &&
        (dtLastUpdate.getTime() == 0)) {
      dtLastUpdate = null;
    }
    this.dtLastUpdate = dtLastUpdate;
  }

  public void setDtLastUpdateString(String dtLastUpdateString) {
    this.hasDtLastUpdate = true;
    this.dtLastUpdate = toDate(dtLastUpdateString);
  }

  public void setDtLastUpdateTime(long dtLastUpdateTime) {
    this.hasDtLastUpdate = true;
    this.dtLastUpdate = toDate(dtLastUpdateTime);
  }

  public boolean hasDtNotifiedWorker() {
    return hasDtNotifiedWorker;
  }

  public Date getDtNotifiedWorker() {
    return dtNotifiedWorker;
  }

  public Date getDtNotifiedWorkerObject() {
    return dtNotifiedWorker;
  }

  public String getDtNotifiedWorkerString() {
    return toString(dtNotifiedWorker);
  }

  public long getDtNotifiedWorkerTime() {
    return toTime(dtNotifiedWorker);
  }

  public void setDtNotifiedWorker(Date dtNotifiedWorker) {
    this.hasDtNotifiedWorker = true;
    if ((dtNotifiedWorker != null) &&
        (dtNotifiedWorker.getTime() == 0)) {
      dtNotifiedWorker = null;
    }
    this.dtNotifiedWorker = dtNotifiedWorker;
  }

  public void setDtNotifiedWorkerString(String dtNotifiedWorkerString) {
    this.hasDtNotifiedWorker = true;
    this.dtNotifiedWorker = toDate(dtNotifiedWorkerString);
  }

  public void setDtNotifiedWorkerTime(long dtNotifiedWorkerTime) {
    this.hasDtNotifiedWorker = true;
    this.dtNotifiedWorker = toDate(dtNotifiedWorkerTime);
  }

  public boolean hasDtProofAgeSentEs() {
    return hasDtProofAgeSentEs;
  }

  public Date getDtProofAgeSentEs() {
    return dtProofAgeSentEs;
  }

  public Date getDtProofAgeSentEsObject() {
    return dtProofAgeSentEs;
  }

  public String getDtProofAgeSentEsString() {
    return toString(dtProofAgeSentEs);
  }

  public long getDtProofAgeSentEsTime() {
    return toTime(dtProofAgeSentEs);
  }

  public void setDtProofAgeSentEs(Date dtProofAgeSentEs) {
    this.hasDtProofAgeSentEs = true;
    if ((dtProofAgeSentEs != null) &&
        (dtProofAgeSentEs.getTime() == 0)) {
      dtProofAgeSentEs = null;
    }
    this.dtProofAgeSentEs = dtProofAgeSentEs;
  }

  public void setDtProofAgeSentEsString(String dtProofAgeSentEsString) {
    this.hasDtProofAgeSentEs = true;
    this.dtProofAgeSentEs = toDate(dtProofAgeSentEsString);
  }

  public void setDtProofAgeSentEsTime(long dtProofAgeSentEsTime) {
    this.hasDtProofAgeSentEs = true;
    this.dtProofAgeSentEs = toDate(dtProofAgeSentEsTime);
  }

  public boolean hasDtProofCitizenshipSentEs() {
    return hasDtProofCitizenshipSentEs;
  }

  public Date getDtProofCitizenshipSentEs() {
    return dtProofCitizenshipSentEs;
  }

  public Date getDtProofCitizenshipSentEsObject() {
    return dtProofCitizenshipSentEs;
  }

  public String getDtProofCitizenshipSentEsString() {
    return toString(dtProofCitizenshipSentEs);
  }

  public long getDtProofCitizenshipSentEsTime() {
    return toTime(dtProofCitizenshipSentEs);
  }

  public void setDtProofCitizenshipSentEs(Date dtProofCitizenshipSentEs) {
    this.hasDtProofCitizenshipSentEs = true;
    if ((dtProofCitizenshipSentEs != null) &&
        (dtProofCitizenshipSentEs.getTime() == 0)) {
      dtProofCitizenshipSentEs = null;
    }
    this.dtProofCitizenshipSentEs = dtProofCitizenshipSentEs;
  }

  public void setDtProofCitizenshipSentEsString(String dtProofCitizenshipSentEsString) {
    this.hasDtProofCitizenshipSentEs = true;
    this.dtProofCitizenshipSentEs = toDate(dtProofCitizenshipSentEsString);
  }

  public void setDtProofCitizenshipSentEsTime(long dtProofCitizenshipSentEsTime) {
    this.hasDtProofCitizenshipSentEs = true;
    this.dtProofCitizenshipSentEs = toDate(dtProofCitizenshipSentEsTime);
  }

  public boolean hasDtRemovalDate() {
    return hasDtRemovalDate;
  }

  public Date getDtRemovalDate() {
    return dtRemovalDate;
  }

  public Date getDtRemovalDateObject() {
    return dtRemovalDate;
  }

  public String getDtRemovalDateString() {
    return toString(dtRemovalDate);
  }

  public long getDtRemovalDateTime() {
    return toTime(dtRemovalDate);
  }

  public void setDtRemovalDate(Date dtRemovalDate) {
    this.hasDtRemovalDate = true;
    if ((dtRemovalDate != null) &&
        (dtRemovalDate.getTime() == 0)) {
      dtRemovalDate = null;
    }
    this.dtRemovalDate = dtRemovalDate;
  }

  public void setDtRemovalDateString(String dtRemovalDate) {
    this.hasDtRemovalDate = true;
    this.dtRemovalDate = toDate(dtRemovalDate);
  }

  public void setDtRemovalDateTime(long dtRemovalDate) {
    this.hasDtRemovalDate = true;
    this.dtRemovalDate = toDate(dtRemovalDate);
  }

  public boolean hasIdCase() {
    return hasIdCase;
  }

  public long getIdCase() {
    if (idCase == null) {
      return (long) 0;
    }
    return idCase.longValue();
  }

  public Long getIdCaseObject() {
    return idCase;
  }

  public String getIdCaseString() {
    return FormattingHelper.formatLong(idCase);
  }

  public void setIdCase(long idCase) {
    this.hasIdCase = true;
    if (idCase == 0) {
      this.idCase = null;
      return;
    }
    this.idCase = new Long(idCase);
  }

  public void setIdCase(Long idCase) {
    this.hasIdCase = true;
    this.idCase = idCase;
  }

  public void setIdCase(Number idCase) {
    this.hasIdCase = true;
    this.idCase = null;
    if (idCase != null) {
      setIdCase(idCase.longValue());
    }
  }

  public boolean hasIdEvent() {
    return hasIdEvent;
  }

  public long getIdEvent() {
    if (idEvent == null) {
      return (long) 0;
    }
    return idEvent.longValue();
  }

  public Long getIdEventObject() {
    return idEvent;
  }

  public String getIdEventString() {
    return FormattingHelper.formatLong(idEvent);
  }

  public void setIdEvent(long idEvent) {
    this.hasIdEvent = true;
    if (idEvent == 0) {
      this.idEvent = null;
      return;
    }
    this.idEvent = new Long(idEvent);
  }

  public void setIdEvent(Long idEvent) {
    this.hasIdEvent = true;
    this.idEvent = idEvent;
  }

  public void setIdEvent(Number idEvent) {
    this.hasIdEvent = true;
    this.idEvent = null;
    if (idEvent != null) {
      setIdEvent(idEvent.longValue());
    }
  }

  public boolean hasIdFceApplication() {
    return hasIdFceApplication;
  }

  public long getIdFceApplication() {
    if (idFceApplication == null) {
      return (long) 0;
    }
    return idFceApplication.longValue();
  }

  public Long getIdFceApplicationObject() {
    return idFceApplication;
  }

  public String getIdFceApplicationString() {
    return FormattingHelper.formatLong(idFceApplication);
  }

  public void setIdFceApplication(long idFceApplication) {
    this.hasIdFceApplication = true;
    if (idFceApplication == 0) {
      this.idFceApplication = null;
      return;
    }
    this.idFceApplication = new Long(idFceApplication);
  }

  public void setIdFceApplication(Long idFceApplication) {
    this.hasIdFceApplication = true;
    this.idFceApplication = idFceApplication;
  }

  public void setIdFceApplication(Number idFceApplication) {
    this.hasIdFceApplication = true;
    this.idFceApplication = null;
    if (idFceApplication != null) {
      setIdFceApplication(idFceApplication.longValue());
    }
  }

  public boolean hasIdFceEligibility() {
    return hasIdFceEligibility;
  }

  public long getIdFceEligibility() {
    if (idFceEligibility == null) {
      return (long) 0;
    }
    return idFceEligibility.longValue();
  }

  public Long getIdFceEligibilityObject() {
    return idFceEligibility;
  }

  public String getIdFceEligibilityString() {
    return FormattingHelper.formatLong(idFceEligibility);
  }

  public void setIdFceEligibility(long idFceEligibility) {
    this.hasIdFceEligibility = true;
    if (idFceEligibility == 0) {
      this.idFceEligibility = null;
      return;
    }
    this.idFceEligibility = new Long(idFceEligibility);
  }

  public void setIdFceEligibility(Long idFceEligibility) {
    this.hasIdFceEligibility = true;
    this.idFceEligibility = idFceEligibility;
  }

  public void setIdFceEligibility(Number idFceEligibility) {
    this.hasIdFceEligibility = true;
    this.idFceEligibility = null;
    if (idFceEligibility != null) {
      setIdFceEligibility(idFceEligibility.longValue());
    }
  }

  public boolean hasIdLastUpdatePerson() {
    return hasIdLastUpdatePerson;
  }

  public long getIdLastUpdatePerson() {
    if (idLastUpdatePerson == null) {
      return (long) 0;
    }
    return idLastUpdatePerson.longValue();
  }

  public Long getIdLastUpdatePersonObject() {
    return idLastUpdatePerson;
  }

  public String getIdLastUpdatePersonString() {
    return FormattingHelper.formatLong(idLastUpdatePerson);
  }

  public void setIdLastUpdatePerson(long idLastUpdatePerson) {
    this.hasIdLastUpdatePerson = true;
    if (idLastUpdatePerson == 0) {
      this.idLastUpdatePerson = null;
      return;
    }
    this.idLastUpdatePerson = new Long(idLastUpdatePerson);
  }

  public void setIdLastUpdatePerson(Long idLastUpdatePerson) {
    this.hasIdLastUpdatePerson = true;
    this.idLastUpdatePerson = idLastUpdatePerson;
  }

  public void setIdLastUpdatePerson(Number idLastUpdatePerson) {
    this.hasIdLastUpdatePerson = true;
    this.idLastUpdatePerson = null;
    if (idLastUpdatePerson != null) {
      setIdLastUpdatePerson(idLastUpdatePerson.longValue());
    }
  }

  public boolean hasIdMngngCvsPerson() {
    return hasIdMngngCvsPerson;
  }

  public long getIdMngngCvsPerson() {
    if (idMngngCvsPerson == null) {
      return (long) 0;
    }
    return idMngngCvsPerson.longValue();
  }

  public Long getIdMngngCvsPersonObject() {
    return idMngngCvsPerson;
  }

  public String getIdMngngCvsPersonString() {
    return FormattingHelper.formatLong(idMngngCvsPerson);
  }

  public void setIdMngngCvsPerson(long idMngngCvsPerson) {
    this.hasIdMngngCvsPerson = true;
    if (idMngngCvsPerson == 0) {
      this.idMngngCvsPerson = null;
      return;
    }
    this.idMngngCvsPerson = new Long(idMngngCvsPerson);
  }

  public void setIdMngngCvsPerson(Long idMngngCvsPerson) {
    this.hasIdMngngCvsPerson = true;
    this.idMngngCvsPerson = idMngngCvsPerson;
  }

  public void setIdMngngCvsPerson(Number idMngngCvsPerson) {
    this.hasIdMngngCvsPerson = true;
    this.idMngngCvsPerson = null;
    if (idMngngCvsPerson != null) {
      setIdMngngCvsPerson(idMngngCvsPerson.longValue());
    }
  }

  public boolean hasIdOtherRelativePerson() {
    return hasIdOtherRelativePerson;
  }

  public long getIdOtherRelativePerson() {
    if (idOtherRelativePerson == null) {
      return (long) 0;
    }
    return idOtherRelativePerson.longValue();
  }

  public Long getIdOtherRelativePersonObject() {
    return idOtherRelativePerson;
  }

  public String getIdOtherRelativePersonString() {
    return FormattingHelper.formatLong(idOtherRelativePerson);
  }

  public void setIdOtherRelativePerson(long idOtherRelativePerson) {
    this.hasIdOtherRelativePerson = true;
    if (idOtherRelativePerson == 0) {
      this.idOtherRelativePerson = null;
      return;
    }
    this.idOtherRelativePerson = new Long(idOtherRelativePerson);
  }

  public void setIdOtherRelativePerson(Long idOtherRelativePerson) {
    this.hasIdOtherRelativePerson = true;
    this.idOtherRelativePerson = idOtherRelativePerson;
  }

  public void setIdOtherRelativePerson(Number idOtherRelativePerson) {
    this.hasIdOtherRelativePerson = true;
    this.idOtherRelativePerson = null;
    if (idOtherRelativePerson != null) {
      setIdOtherRelativePerson(idOtherRelativePerson.longValue());
    }
  }

  public boolean hasIdPerson() {
    return hasIdPerson;
  }

  public long getIdPerson() {
    if (idPerson == null) {
      return (long) 0;
    }
    return idPerson.longValue();
  }

  public Long getIdPersonObject() {
    return idPerson;
  }

  public String getIdPersonString() {
    return FormattingHelper.formatLong(idPerson);
  }

  public void setIdPerson(long idPerson) {
    this.hasIdPerson = true;
    if (idPerson == 0) {
      this.idPerson = null;
      return;
    }
    this.idPerson = new Long(idPerson);
  }

  public void setIdPerson(Long idPerson) {
    this.hasIdPerson = true;
    this.idPerson = idPerson;
  }

  public void setIdPerson(Number idPerson) {
    this.hasIdPerson = true;
    this.idPerson = null;
    if (idPerson != null) {
      setIdPerson(idPerson.longValue());
    }
  }

  public boolean hasIdStage() {
    return hasIdStage;
  }

  public long getIdStage() {
    if (idStage == null) {
      return (long) 0;
    }
    return idStage.longValue();
  }

  public Long getIdStageObject() {
    return idStage;
  }

  public String getIdStageString() {
    return FormattingHelper.formatLong(idStage);
  }

  public void setIdStage(long idStage) {
    this.hasIdStage = true;
    if (idStage == 0) {
      this.idStage = null;
      return;
    }
    this.idStage = new Long(idStage);
  }

  public void setIdStage(Long idStage) {
    this.hasIdStage = true;
    this.idStage = idStage;
  }

  public void setIdStage(Number idStage) {
    this.hasIdStage = true;
    this.idStage = null;
    if (idStage != null) {
      setIdStage(idStage.longValue());
    }
  }

  public boolean hasIndAgeJustifiedEval() {
    return hasIndAgeJustifiedEval;
  }

  public boolean getIndAgeJustifiedEval() {
    if (indAgeJustifiedEval == null) {
      return false;
    }
    return indAgeJustifiedEval.booleanValue();
  }

  public Boolean getIndAgeJustifiedEvalObject() {
    return indAgeJustifiedEval;
  }

  public String getIndAgeJustifiedEvalString() {
    if (indAgeJustifiedEval == null) {
      return "";
    }
    return indAgeJustifiedEval.toString();
  }

  public void setIndAgeJustifiedEval(boolean indAgeJustifiedEval) {
    this.hasIndAgeJustifiedEval = true;
    this.indAgeJustifiedEval = new Boolean(indAgeJustifiedEval);
  }

  public void setIndAgeJustifiedEval(Boolean indAgeJustifiedEval) {
    this.hasIndAgeJustifiedEval = true;
    this.indAgeJustifiedEval = indAgeJustifiedEval;
  }

  public void setIndAgeJustifiedEval(String indAgeJustifiedEval) {
    this.hasIndAgeJustifiedEval = true;
    this.indAgeJustifiedEval = isTrueBoolean(indAgeJustifiedEval);
  }

  public boolean hasIndAgeVrfdBaptismCert() {
    return hasIndAgeVrfdBaptismCert;
 }

 public boolean getIndAgeVrfdBaptismCert() {
    if (indAgeVrfdBaptismCert == null) {
      return false;
    }
    return indAgeVrfdBaptismCert.booleanValue();
  }

  public Boolean getIndAgeVrfdBaptismCertObject() {
    return indAgeVrfdBaptismCert;
  }

  public String getIndAgeVrfdBaptismCertString() {
    if (indAgeVrfdBaptismCert == null) {
      return "";
    }
    return indAgeVrfdBaptismCert.toString();
  }

  public void setIndAgeVrfdBaptismCert(boolean indAgeVrfdBaptismCert) {
    this.hasIndAgeVrfdBaptismCert = true;
    this.indAgeVrfdBaptismCert = new Boolean(indAgeVrfdBaptismCert);
  }

  public void setIndAgeVrfdBaptismCert(Boolean indAgeVrfdBaptismCert) {
    this.hasIndAgeVrfdBaptismCert = true;
    this.indAgeVrfdBaptismCert = indAgeVrfdBaptismCert;
  }

  public void setIndAgeVrfdBaptismCert(String indAgeVrfdBaptismCert) {
    this.hasIndAgeVrfdBaptismCert = true;
    this.indAgeVrfdBaptismCert = isTrueBoolean(indAgeVrfdBaptismCert);
  }

  public boolean hasIndAgeVrfdForeignCert() {
    return hasIndAgeVrfdForeignCert;
  }

  public boolean getIndAgeVrfdForeignCert() {
    if (indAgeVrfdForeignCert == null) {
      return false;
    }
    return indAgeVrfdForeignCert.booleanValue();
  }

  public Boolean getIndAgeVrfdForeignCertObject() {
    return indAgeVrfdForeignCert;
  }

  public String getIndAgeVrfdForeignCertString() {
    if (indAgeVrfdForeignCert == null) {
      return "";
    }
    return indAgeVrfdForeignCert.toString();
  }

  public void setIndAgeVrfdForeignCert(boolean indAgeVrfdForeignCert) {
    this.hasIndAgeVrfdForeignCert = true;
    this.indAgeVrfdForeignCert = new Boolean(indAgeVrfdForeignCert);
  }

  public void setIndAgeVrfdForeignCert(Boolean indAgeVrfdForeignCert) {
    this.hasIndAgeVrfdForeignCert = true;
    this.indAgeVrfdForeignCert = indAgeVrfdForeignCert;
  }

  public void setIndAgeVrfdForeignCert(String indAgeVrfdForeignCert) {
    this.hasIndAgeVrfdForeignCert = true;
    this.indAgeVrfdForeignCert = isTrueBoolean(indAgeVrfdForeignCert);
  }

  public boolean hasIndAgeVrfdHospitalCert() {
    return hasIndAgeVrfdHospitalCert;
  }

  public boolean getIndAgeVrfdHospitalCert() {
    if (indAgeVrfdHospitalCert == null) {
      return false;
    }
    return indAgeVrfdHospitalCert.booleanValue();
  }

  public Boolean getIndAgeVrfdHospitalCertObject() {
    return indAgeVrfdHospitalCert;
  }

  public String getIndAgeVrfdHospitalCertString() {
    if (indAgeVrfdHospitalCert == null) {
      return "";
    }
    return indAgeVrfdHospitalCert.toString();
  }

  public void setIndAgeVrfdHospitalCert(boolean indAgeVrfdHospitalCert) {
    this.hasIndAgeVrfdHospitalCert = true;
    this.indAgeVrfdHospitalCert = new Boolean(indAgeVrfdHospitalCert);
  }

  public void setIndAgeVrfdHospitalCert(Boolean indAgeVrfdHospitalCert) {
    this.hasIndAgeVrfdHospitalCert = true;
    this.indAgeVrfdHospitalCert = indAgeVrfdHospitalCert;
  }

  public void setIndAgeVrfdHospitalCert(String indAgeVrfdHospitalCert) {
    this.hasIndAgeVrfdHospitalCert = true;
    this.indAgeVrfdHospitalCert = isTrueBoolean(indAgeVrfdHospitalCert);
  }

  public boolean hasIndAgeVrfdNtrlztnCert() {
    return hasIndAgeVrfdNtrlztnCert;
  }

  public boolean getIndAgeVrfdNtrlztnCert() {
    if (indAgeVrfdNtrlztnCert == null) {
      return false;
    }
    return indAgeVrfdNtrlztnCert.booleanValue();
  }

  public Boolean getIndAgeVrfdNtrlztnCertObject() {
    return indAgeVrfdNtrlztnCert;
  }

  public String getIndAgeVrfdNtrlztnCertString() {
    if (indAgeVrfdNtrlztnCert == null) {
      return "";
    }
    return indAgeVrfdNtrlztnCert.toString();
  }

  public void setIndAgeVrfdNtrlztnCert(boolean indAgeVrfdNtrlztnCert) {
    this.hasIndAgeVrfdNtrlztnCert = true;
    this.indAgeVrfdNtrlztnCert = new Boolean(indAgeVrfdNtrlztnCert);
  }

  public void setIndAgeVrfdNtrlztnCert(Boolean indAgeVrfdNtrlztnCert) {
    this.hasIndAgeVrfdNtrlztnCert = true;
    this.indAgeVrfdNtrlztnCert = indAgeVrfdNtrlztnCert;
  }

  public void setIndAgeVrfdNtrlztnCert(String indAgeVrfdNtrlztnCert) {
    this.hasIndAgeVrfdNtrlztnCert = true;
    this.indAgeVrfdNtrlztnCert = isTrueBoolean(indAgeVrfdNtrlztnCert);
  }

  public boolean hasIndAgeVrfdPassport() {
    return hasIndAgeVrfdPassport;
  }

  public boolean getIndAgeVrfdPassport() {
    if (indAgeVrfdPassport == null) {
      return false;
    }
    return indAgeVrfdPassport.booleanValue();
  }

  public Boolean getIndAgeVrfdPassportObject() {
    return indAgeVrfdPassport;
  }

  public String getIndAgeVrfdPassportString() {
    if (indAgeVrfdPassport == null) {
      return "";
    }
    return indAgeVrfdPassport.toString();
  }

  public void setIndAgeVrfdPassport(boolean indAgeVrfdPassport) {
    this.hasIndAgeVrfdPassport = true;
    this.indAgeVrfdPassport = new Boolean(indAgeVrfdPassport);
  }

  public void setIndAgeVrfdPassport(Boolean indAgeVrfdPassport) {
    this.hasIndAgeVrfdPassport = true;
    this.indAgeVrfdPassport = indAgeVrfdPassport;
  }

  public void setIndAgeVrfdPassport(String indAgeVrfdPassport) {
    this.hasIndAgeVrfdPassport = true;
    this.indAgeVrfdPassport = isTrueBoolean(indAgeVrfdPassport);
  }

  public boolean hasIndAgeVrfdResidentCard() {
    return hasIndAgeVrfdResidentCard;
  }

  public boolean getIndAgeVrfdResidentCard() {
    if (indAgeVrfdResidentCard == null) {
      return false;
    }
    return indAgeVrfdResidentCard.booleanValue();
  }

  public Boolean getIndAgeVrfdResidentCardObject() {
    return indAgeVrfdResidentCard;
  }

  public String getIndAgeVrfdResidentCardString() {
    if (indAgeVrfdResidentCard == null) {
      return "";
    }
    return indAgeVrfdResidentCard.toString();
  }

  public void setIndAgeVrfdResidentCard(boolean indAgeVrfdResidentCard) {
    this.hasIndAgeVrfdResidentCard = true;
    this.indAgeVrfdResidentCard = new Boolean(indAgeVrfdResidentCard);
  }

  public void setIndAgeVrfdResidentCard(Boolean indAgeVrfdResidentCard) {
    this.hasIndAgeVrfdResidentCard = true;
    this.indAgeVrfdResidentCard = indAgeVrfdResidentCard;
  }
  
  public void setIndAgeVrfdResidentCard(String indAgeVrfdResidentCard) {
    this.hasIndAgeVrfdResidentCard = true;
    this.indAgeVrfdResidentCard = isTrueBoolean(indAgeVrfdResidentCard);
  }
  
  public boolean hasIndAgeVrfdSaveSystem() {
    return hasIndAgeVrfdSaveSystem;
  }
  
  public boolean getIndAgeVrfdSaveSystem() {
    if (indAgeVrfdSaveSystem == null) {
      return false;
    }
    return indAgeVrfdSaveSystem.booleanValue();
  }
  
  public Boolean getIndAgeVrfdSaveSystemObject() {
    return indAgeVrfdSaveSystem;
  }
  
  public String getIndAgeVrfdSaveSystemString() {
    if (indAgeVrfdSaveSystem == null) {
      return "";
    }
    return indAgeVrfdSaveSystem.toString();
  }
  
  public void setIndAgeVrfdSaveSystem(boolean indAgeVrfdSaveSystem) {
    this.hasIndAgeVrfdSaveSystem = true;
    this.indAgeVrfdSaveSystem = new Boolean(indAgeVrfdSaveSystem);
  }
  
  public void setIndAgeVrfdSaveSystem(Boolean indAgeVrfdSaveSystem) {
    this.hasIndAgeVrfdSaveSystem = true;
    this.indAgeVrfdSaveSystem = indAgeVrfdSaveSystem;
  }
  
  public void setIndAgeVrfdSaveSystem(String indAgeVrfdSaveSystem) {
    this.hasIndAgeVrfdSaveSystem = true;
    this.indAgeVrfdSaveSystem = isTrueBoolean(indAgeVrfdSaveSystem);
  }

  public boolean hasIndAgeVrfdSuccessSystem() {
    return hasIndAgeVrfdSuccessSystem;
  }

  public boolean getIndAgeVrfdSuccessSystem() {
    if (indAgeVrfdSuccessSystem == null) {
      return false;
    }
    return indAgeVrfdSuccessSystem.booleanValue();
  }

  public Boolean getIndAgeVrfdSuccessSystemObject() {
    return indAgeVrfdSuccessSystem;
  }

  public String getIndAgeVrfdSuccessSystemString() {
    if (indAgeVrfdSuccessSystem == null) {
      return "";
    }
    return indAgeVrfdSuccessSystem.toString();
  }

  public void setIndAgeVrfdSuccessSystem(boolean indAgeVrfdSuccessSystem) {
    this.hasIndAgeVrfdSuccessSystem = true;
    this.indAgeVrfdSuccessSystem = new Boolean(indAgeVrfdSuccessSystem);
  }

  public void setIndAgeVrfdSuccessSystem(Boolean indAgeVrfdSuccessSystem) {
    this.hasIndAgeVrfdSuccessSystem = true;
    this.indAgeVrfdSuccessSystem = indAgeVrfdSuccessSystem;
  }

  public void setIndAgeVrfdSuccessSystem(String indAgeVrfdSuccessSystem) {
    this.hasIndAgeVrfdSuccessSystem = true;
    this.indAgeVrfdSuccessSystem = isTrueBoolean(indAgeVrfdSuccessSystem);
  }
  
  public boolean hasIndAgeVrfdUsBirthCert() {
    return hasIndAgeVrfdUsBirthCert;
  }

  public boolean getIndAgeVrfdUsBirthCert() {
    if (indAgeVrfdUsBirthCert == null) {
      return false;
    }
    return indAgeVrfdUsBirthCert.booleanValue();
  }

  public Boolean getIndAgeVrfdUsBirthCertObject() {
    return indAgeVrfdUsBirthCert;
  }

  public String getIndAgeVrfdUsBirthCertString() {
    if (indAgeVrfdUsBirthCert == null) {
      return "";
    }
    return indAgeVrfdUsBirthCert.toString();
  }

  public void setIndAgeVrfdUsBirthCert(boolean indAgeVrfdUsBirthCert) {
    this.hasIndAgeVrfdUsBirthCert = true;
    this.indAgeVrfdUsBirthCert = new Boolean(indAgeVrfdUsBirthCert);
  }

  public void setIndAgeVrfdUsBirthCert(Boolean indAgeVrfdUsBirthCert) {
    this.hasIndAgeVrfdUsBirthCert = true;
    this.indAgeVrfdUsBirthCert = indAgeVrfdUsBirthCert;
  }

  public void setIndAgeVrfdUsBirthCert(String indAgeVrfdUsBirthCert) {
    this.hasIndAgeVrfdUsBirthCert = true;
    this.indAgeVrfdUsBirthCert = isTrueBoolean(indAgeVrfdUsBirthCert);
  }

  public boolean hasIndAmendedApp() {
    return hasIndAmendedApp;
  }

  public boolean getIndAmendedApp() {
    if (indAmendedApp == null) {
      return false;
    }
    return indAmendedApp.booleanValue();
  }

  public Boolean getIndAmendedAppObject() {
    return indAmendedApp;
  }

  public String getIndAmendedAppString() {
    if (indAmendedApp == null) {
      return "";
    }
    return indAmendedApp.toString();
  }

  public void setIndAmendedApp(boolean indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = new Boolean(indAmendedApp);
  }

  public void setIndAmendedApp(Boolean indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = indAmendedApp;
  }

  public void setIndAmendedApp(String indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = isTrueBoolean(indAmendedApp);
  }
  
  public boolean hasIndChildSupportOrder() {
    return hasIndChildSupportOrder;
  }

  public boolean getIndChildSupportOrder() {
    if (indChildSupportOrder == null) {
      return false;
    }
    return indChildSupportOrder.booleanValue();
  }

  public Boolean getIndChildSupportOrderObject() {
    return indChildSupportOrder;
  }

  public String getIndChildSupportOrderString() {
    if (indChildSupportOrder == null) {
      return "";
    }
    return indChildSupportOrder.toString();
  }

  public void setIndChildSupportOrder(boolean indChildSupportOrder) {
    this.hasIndChildSupportOrder = true;
    this.indChildSupportOrder = new Boolean(indChildSupportOrder);
  }

  public void setIndChildSupportOrder(Boolean indChildSupportOrder) {
    this.hasIndChildSupportOrder = true;
    this.indChildSupportOrder = indChildSupportOrder;
  }

  public void setIndChildSupportOrder(String indChildSupportOrder) {
    this.hasIndChildSupportOrder = true;
    this.indChildSupportOrder = isTrueBoolean(indChildSupportOrder);
  }

  public boolean hasIndEvaluationConclusion() {
    return hasIndEvaluationConclusion;
  }

  public boolean getIndEvaluationConclusion() {
    if (indEvaluationConclusion == null) {
      return false;
    }
    return indEvaluationConclusion.booleanValue();
  }

  public Boolean getIndEvaluationConclusionObject() {
    return indEvaluationConclusion;
  }

  public String getIndEvaluationConclusionString() {
    if (indEvaluationConclusion == null) {
      return "";
    }
    return indEvaluationConclusion.toString();
  }

  public void setIndEvaluationConclusion(boolean indEvaluationConclusion) {
    this.hasIndEvaluationConclusion = true;
    this.indEvaluationConclusion = new Boolean(indEvaluationConclusion);
  }

  public void setIndEvaluationConclusion(Boolean indEvaluationConclusion) {
    this.hasIndEvaluationConclusion = true;
    this.indEvaluationConclusion = indEvaluationConclusion;
  }

  public void setIndEvaluationConclusion(String indEvaluationConclusion) {
    this.hasIndEvaluationConclusion = true;
    this.indEvaluationConclusion = isTrueBoolean(indEvaluationConclusion);
  }

  public boolean hasIndHospital() {
    return hasIndHospital;
  }

  public boolean getIndHospital() {
    if (indHospital == null) {
      return false;
    }
    return indHospital.booleanValue();
  }

  public Boolean getIndHospitalObject() {
    return indHospital;
  }

  public String getIndHospitalString() {
    if (indHospital == null) {
      return "";
    }
    return indHospital.toString();
  }

  public void setIndHospital(boolean indHospital) {
    this.hasIndHospital = true;
    this.indHospital = new Boolean(indHospital);
  }

  public void setIndHospital(Boolean indHospital) {
    this.hasIndHospital = true;
    this.indHospital = indHospital;
  }

  public void setIndHospital(String indHospital) {
    this.hasIndHospital = true;
    this.indHospital = isTrueBoolean(indHospital);
  }

  public boolean hasIndIncomeAssistance() {
    return hasIndIncomeAssistance;
  }

  public boolean getIndIncomeAssistance() {
    if (indIncomeAssistance == null) {
      return false;
    }
    return indIncomeAssistance.booleanValue();
  }

  public Boolean getIndIncomeAssistanceObject() {
    return indIncomeAssistance;
  }

  public String getIndIncomeAssistanceString() {
    if (indIncomeAssistance == null) {
      return "";
    }
    return indIncomeAssistance.toString();
  }

  public void setIndIncomeAssistance(boolean indIncomeAssistance) {
    this.hasIndIncomeAssistance = true;
    this.indIncomeAssistance = new Boolean(indIncomeAssistance);
  }

  public void setIndIncomeAssistance(Boolean indIncomeAssistance) {
    this.hasIndIncomeAssistance = true;
    this.indIncomeAssistance = indIncomeAssistance;
  }

  public void setIndIncomeAssistance(String indIncomeAssistance) {
    this.hasIndIncomeAssistance = true;
    this.indIncomeAssistance = isTrueBoolean(indIncomeAssistance);
  }

  public boolean hasIndLegalDocsSentEs() {
    return hasIndLegalDocsSentEs;
  }

  public boolean getIndLegalDocsSentEs() {
    if (indLegalDocsSentEs == null) {
      return false;
    }
    return indLegalDocsSentEs.booleanValue();
  }

  public Boolean getIndLegalDocsSentEsObject() {
    return indLegalDocsSentEs;
  }

  public String getIndLegalDocsSentEsString() {
    if (indLegalDocsSentEs == null) {
      return "";
    }
    return indLegalDocsSentEs.toString();
  }

  public void setIndLegalDocsSentEs(boolean indLegalDocsSentEs) {
    this.hasIndLegalDocsSentEs = true;
    this.indLegalDocsSentEs = new Boolean(indLegalDocsSentEs);
  }

  public void setIndLegalDocsSentEs(Boolean indLegalDocsSentEs) {
    this.hasIndLegalDocsSentEs = true;
    this.indLegalDocsSentEs = indLegalDocsSentEs;
  }

  public void setIndLegalDocsSentEs(String indLegalDocsSentEs) {
    this.hasIndLegalDocsSentEs = true;
    this.indLegalDocsSentEs = isTrueBoolean(indLegalDocsSentEs);
  }

  public boolean hasIndLivingRelativeSixMonth() {
    return hasIndLivingRelativeSixMonth;
  }

  public boolean getIndLivingRelativeSixMonth() {
    if (indLivingRelativeSixMonth == null) {
      return false;
    }
    return indLivingRelativeSixMonth.booleanValue();
  }

  public Boolean getIndLivingRelativeSixMonthObject() {
    return indLivingRelativeSixMonth;
  }

  public String getIndLivingRelativeSixMonthString() {
    if (indLivingRelativeSixMonth == null) {
      return "";
    }
    return indLivingRelativeSixMonth.toString();
  }

  public void setIndLivingRelativeSixMonth(boolean indLivingRelativeSixMonth) {
    this.hasIndLivingRelativeSixMonth = true;
    this.indLivingRelativeSixMonth = new Boolean(indLivingRelativeSixMonth);
  }

  public void setIndLivingRelativeSixMonth(Boolean indLivingRelativeSixMonth) {
    this.hasIndLivingRelativeSixMonth = true;
    this.indLivingRelativeSixMonth = indLivingRelativeSixMonth;
  }

  public void setIndLivingRelativeSixMonth(String indLivingRelativeSixMonth) {
    this.hasIndLivingRelativeSixMonth = true;
    this.indLivingRelativeSixMonth = isTrueBoolean(indLivingRelativeSixMonth);
  }

  public boolean hasIndManagingCvs() {
    return hasIndManagingCvs;
  }

  public boolean getIndManagingCvs() {
    if (indManagingCvs == null) {
      return false;
    }
    return indManagingCvs.booleanValue();
  }

  public Boolean getIndManagingCvsObject() {
    return indManagingCvs;
  }

  public String getIndManagingCvsString() {
    if (indManagingCvs == null) {
      return "";
    }
    return indManagingCvs.toString();
  }

  public void setIndManagingCvs(boolean indManagingCvs) {
    this.hasIndManagingCvs = true;
    this.indManagingCvs = new Boolean(indManagingCvs);
  }

  public void setIndManagingCvs(Boolean indManagingCvs) {
    this.hasIndManagingCvs = true;
    this.indManagingCvs = indManagingCvs;
  }

  public void setIndManagingCvs(String indManagingCvs) {
    this.hasIndManagingCvs = true;
    this.indManagingCvs = isTrueBoolean(indManagingCvs);
  }

  public boolean hasIndMinorParent() {
    return hasIndMinorParent;
  }

  public boolean getIndMinorParent() {
    if (indMinorParent == null) {
      return false;
    }
    return indMinorParent.booleanValue();
  }

  public Boolean getIndMinorParentObject() {
    return indMinorParent;
  }

  public String getIndMinorParentString() {
    if (indMinorParent == null) {
      return "";
    }
    return indMinorParent.toString();
  }

  public void setIndMinorParent(boolean indMinorParent) {
    this.hasIndMinorParent = true;
    this.indMinorParent = new Boolean(indMinorParent);
  }

  public void setIndMinorParent(Boolean indMinorParent) {
    this.hasIndMinorParent = true;
    this.indMinorParent = indMinorParent;
  }

  public void setIndMinorParent(String indMinorParent) {
    this.hasIndMinorParent = true;
    this.indMinorParent = isTrueBoolean(indMinorParent);
  }

  public boolean hasIndNotifiedDhsWorker() {
    return hasIndNotifiedDhsWorker;
  }

  public boolean getIndNotifiedDhsWorker() {
    if (indNotifiedDhsWorker == null) {
      return false;
    }
    return indNotifiedDhsWorker.booleanValue();
  }

  public Boolean getIndNotifiedDhsWorkerObject() {
    return indNotifiedDhsWorker;
  }

  public String getIndNotifiedDhsWorkerString() {
    if (indNotifiedDhsWorker == null) {
      return "";
    }
    return indNotifiedDhsWorker.toString();
  }

  public void setIndNotifiedDhsWorker(boolean indNotifiedDhsWorker) {
    this.hasIndNotifiedDhsWorker = true;
    this.indNotifiedDhsWorker = new Boolean(indNotifiedDhsWorker);
  }

  public void setIndNotifiedDhsWorker(Boolean indNotifiedDhsWorker) {
    this.hasIndNotifiedDhsWorker = true;
    this.indNotifiedDhsWorker = indNotifiedDhsWorker;
  }

  public void setIndNotifiedDhsWorker(String indNotifiedDhsWorker) {
    this.hasIndNotifiedDhsWorker = true;
    this.indNotifiedDhsWorker = isTrueBoolean(indNotifiedDhsWorker);
  }

  public boolean hasIndOtherHealthInsurance() {
    return hasIndOtherHealthInsurance;
  }

  public boolean getIndOtherHealthInsurance() {
    if (indOtherHealthInsurance == null) {
      return false;
    }
    return indOtherHealthInsurance.booleanValue();
  }

  public Boolean getIndOtherHealthInsuranceObject() {
    return indOtherHealthInsurance;
  }

  public String getIndOtherHealthInsuranceString() {
    if (indOtherHealthInsurance == null) {
      return "";
    }
    return indOtherHealthInsurance.toString();
  }

  public void setIndOtherHealthInsurance(boolean indOtherHealthInsurance) {
    this.hasIndOtherHealthInsurance = true;
    this.indOtherHealthInsurance = new Boolean(indOtherHealthInsurance);
  }

  public void setIndOtherHealthInsurance(Boolean indOtherHealthInsurance) {
    this.hasIndOtherHealthInsurance = true;
    this.indOtherHealthInsurance = indOtherHealthInsurance;
  }

  public void setIndOtherHealthInsurance(String indOtherHealthInsurance) {
    this.hasIndOtherHealthInsurance = true;
    this.indOtherHealthInsurance = isTrueBoolean(indOtherHealthInsurance);
  }

  public boolean hasIndProofAgeSentEs() {
    return hasIndProofAgeSentEs;
  }

  public boolean getIndProofAgeSentEs() {
    if (indProofAgeSentEs == null) {
      return false;
    }
    return indProofAgeSentEs.booleanValue();
  }

  public Boolean getIndProofAgeSentEsObject() {
    return indProofAgeSentEs;
  }

  public String getIndProofAgeSentEsString() {
    if (indProofAgeSentEs == null) {
      return "";
    }
    return indProofAgeSentEs.toString();
  }

  public void setIndProofAgeSentEs(boolean indProofAgeSentEs) {
    this.hasIndProofAgeSentEs = true;
    this.indProofAgeSentEs = new Boolean(indProofAgeSentEs);
  }

  public void setIndProofAgeSentEs(Boolean indProofAgeSentEs) {
    this.hasIndProofAgeSentEs = true;
    this.indProofAgeSentEs = indProofAgeSentEs;
  }

  public void setIndProofAgeSentEs(String indProofAgeSentEs) {
    this.hasIndProofAgeSentEs = true;
    this.indProofAgeSentEs = isTrueBoolean(indProofAgeSentEs);
  }

  public boolean hasIndProofCitizenshipSentEs() {
    return hasIndProofCitizenshipSentEs;
  }

  public boolean getIndProofCitizenshipSentEs() {
    if (indProofCitizenshipSentEs == null) {
      return false;
    }
    return indProofCitizenshipSentEs.booleanValue();
  }

  public Boolean getIndProofCitizenshipSentEsObject() {
    return indProofCitizenshipSentEs;
  }

  public String getIndProofCitizenshipSentEsString() {
    if (indProofCitizenshipSentEs == null) {
      return "";
    }
    return indProofCitizenshipSentEs.toString();
  }

  public void setIndProofCitizenshipSentEs(boolean indProofCitizenshipSentEs) {
    this.hasIndProofCitizenshipSentEs = true;
    this.indProofCitizenshipSentEs = new Boolean(indProofCitizenshipSentEs);
  }

  public void setIndProofCitizenshipSentEs(Boolean indProofCitizenshipSentEs) {
    this.hasIndProofCitizenshipSentEs = true;
    this.indProofCitizenshipSentEs = indProofCitizenshipSentEs;
  }

  public void setIndProofCitizenshipSentEs(String indProofCitizenshipSentEs) {
    this.hasIndProofCitizenshipSentEs = true;
    this.indProofCitizenshipSentEs = isTrueBoolean(indProofCitizenshipSentEs);
  }

  public boolean hasIndSpecifiedRelative() {
    return hasIndSpecifiedRelative;
  }

  public boolean getIndSpecifiedRelative() {
    if (indSpecifiedRelative == null) {
      return false;
    }
    return indSpecifiedRelative.booleanValue();
  }

  public Boolean getIndSpecifiedRelativeObject() {
    return indSpecifiedRelative;
  }

  public String getIndSpecifiedRelativeString() {
    if (indSpecifiedRelative == null) {
      return "";
    }
    return indSpecifiedRelative.toString();
  }

  public void setIndSpecifiedRelative(boolean indSpecifiedRelative) {
    this.hasIndSpecifiedRelative = true;
    this.indSpecifiedRelative = new Boolean(indSpecifiedRelative);
  }

  public void setIndSpecifiedRelative(Boolean indSpecifiedRelative) {
    this.hasIndSpecifiedRelative = true;
    this.indSpecifiedRelative = indSpecifiedRelative;
  }

  public void setIndSpecifiedRelative(String indSpecifiedRelative) {
    this.hasIndSpecifiedRelative = true;
    this.indSpecifiedRelative = isTrueBoolean(indSpecifiedRelative);
  }

  public boolean hasNbrCourtMonth() {
    return hasNbrCourtMonth;
  }

  public long getNbrCourtMonth() {
    if (nbrCourtMonth == null) {
      return (long) 0;
    }
    return nbrCourtMonth.longValue();
  }

  public Long getNbrCourtMonthObject() {
    return nbrCourtMonth;
  }

  public String getNbrCourtMonthString() {
    return FormattingHelper.formatLong(nbrCourtMonth);
  }

  public void setNbrCourtMonth(long nbrCourtMonth) {
    this.hasNbrCourtMonth = true;
    if (nbrCourtMonth == 0) {
      this.nbrCourtMonth = null;
      return;
    }
    this.nbrCourtMonth = new Long(nbrCourtMonth);
  }

  public void setNbrCourtMonth(Long nbrCourtMonth) {
    this.hasNbrCourtMonth = true;
    this.nbrCourtMonth = nbrCourtMonth;
  }

  public void setNbrCourtMonth(Number nbrCourtMonth) {
    this.hasNbrCourtMonth = true;
    this.nbrCourtMonth = null;
    if (nbrCourtMonth != null) {
      setNbrCourtMonth(nbrCourtMonth.longValue());
    }
  }

  public boolean hasNbrCourtYear() {
    return hasNbrCourtYear;
  }

  public long getNbrCourtYear() {
    if (nbrCourtYear == null) {
      return (long) 0;
    }
    return nbrCourtYear.longValue();
  }

  public Long getNbrCourtYearObject() {
    return nbrCourtYear;
  }

  public String getNbrCourtYearString() {
    return FormattingHelper.formatLong(nbrCourtYear);
  }

  public void setNbrCourtYear(long nbrCourtYear) {
    this.hasNbrCourtYear = true;
    if (nbrCourtYear == 0) {
      this.nbrCourtYear = null;
      return;
    }
    this.nbrCourtYear = new Long(nbrCourtYear);
  }

  public void setNbrCourtYear(Long nbrCourtYear) {
    this.hasNbrCourtYear = true;
    this.nbrCourtYear = nbrCourtYear;
  }

  public void setNbrCourtYear(Number nbrCourtYear) {
    this.hasNbrCourtYear = true;
    this.nbrCourtYear = null;
    if (nbrCourtYear != null) {
      setNbrCourtYear(nbrCourtYear.longValue());
    }
  }

  public boolean hasNbrHealthGroup() {
    return hasNbrHealthGroup;
  }

  public String getNbrHealthGroup() {
    if (nbrHealthGroup == null) {
      return "";
    }
    return nbrHealthGroup;
  }

  public String getNbrHealthGroupObject() {
    return nbrHealthGroup;
  }

  public void setNbrHealthGroup(String nbrHealthGroup) {
    if ((nbrHealthGroup != null) &&
        (nbrHealthGroup.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'nbrHealthGroup'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + nbrHealthGroup + "'");
    }
    this.hasNbrHealthGroup = true;
    this.nbrHealthGroup = nbrHealthGroup;
  }

  public boolean hasNbrHealthPolicy() {
    return hasNbrHealthPolicy;
  }

  public String getNbrHealthPolicy() {
    if (nbrHealthPolicy == null) {
      return "";
    }
    return nbrHealthPolicy;
  }

  public String getNbrHealthPolicyObject() {
    return nbrHealthPolicy;
  }

  public void setNbrHealthPolicy(String nbrHealthPolicy) {
    if ((nbrHealthPolicy != null) &&
        (nbrHealthPolicy.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'nbrHealthPolicy'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + nbrHealthPolicy + "'");
    }
    this.hasNbrHealthPolicy = true;
    this.nbrHealthPolicy = nbrHealthPolicy;
  }

  public boolean hasNbrLivingAtHome() {
    return hasNbrLivingAtHome;
  }

  public long getNbrLivingAtHome() {
    if (nbrLivingAtHome == null) {
      return (long) 0;
    }
    return nbrLivingAtHome.longValue();
  }

  public Long getNbrLivingAtHomeObject() {
    return nbrLivingAtHome;
  }

  public String getNbrLivingAtHomeString() {
    return FormattingHelper.formatLong(nbrLivingAtHome);
  }

  public void setNbrLivingAtHome(long nbrLivingAtHome) {
    this.hasNbrLivingAtHome = true;
    if (nbrLivingAtHome == 0) {
      this.nbrLivingAtHome = null;
      return;
    }
    this.nbrLivingAtHome = new Long(nbrLivingAtHome);
  }

  public void setNbrLivingAtHome(Long nbrLivingAtHome) {
    this.hasNbrLivingAtHome = true;
    this.nbrLivingAtHome = nbrLivingAtHome;
  }

  public void setNbrLivingAtHome(Number nbrLivingAtHome) {
    this.hasNbrLivingAtHome = true;
    this.nbrLivingAtHome = null;
    if (nbrLivingAtHome != null) {
      setNbrLivingAtHome(nbrLivingAtHome.longValue());
    }
  }

  public boolean hasNbrNotifiedDhsWrkrPhn() {
    return hasNbrNotifiedDhsWrkrPhn;
  }

  public String getNbrNotifiedDhsWrkrPhn() {
    if (nbrNotifiedDhsWrkrPhn == null) {
      return "";
    }
    return nbrNotifiedDhsWrkrPhn;
  }

  public String getNbrNotifiedDhsWrkrPhnObject() {
    return nbrNotifiedDhsWrkrPhn;
  }

  public void setNbrNotifiedDhsWrkrPhn(String nbrNotifiedDhsWrkrPhn) {
    if ((nbrNotifiedDhsWrkrPhn != null) &&
        (nbrNotifiedDhsWrkrPhn.length() > 10)) {
      throw new IllegalStateException("Data is too large for 'nbrNotifiedDhsWrkrPhn'; \n" +
                                      " max size = 10; \n" +
                                      " data = '" + nbrNotifiedDhsWrkrPhn + "'");
    }
    this.hasNbrNotifiedDhsWrkrPhn = true;
    this.nbrNotifiedDhsWrkrPhn = nbrNotifiedDhsWrkrPhn;
  }

  public boolean hasNmHealthCompany() {
    return hasNmHealthCompany;
  }

  public String getNmHealthCompany() {
    if (nmHealthCompany == null) {
      return "";
    }
    return nmHealthCompany;
  }

  public String getNmHealthCompanyObject() {
    return nmHealthCompany;
  }

  public void setNmHealthCompany(String nmHealthCompany) {
    if ((nmHealthCompany != null) &&
        (nmHealthCompany.length() > 50)) {
      throw new IllegalStateException("Data is too large for 'nmHealthCompany'; \n" +
                                      " max size = 50; \n" +
                                      " data = '" + nmHealthCompany + "'");
    }
    this.hasNmHealthCompany = true;
    this.nmHealthCompany = nmHealthCompany;
  }

  public boolean hasNmHealthEmployeeNm() {
    return hasNmHealthEmployeeNm;
  }

  public String getNmHealthEmployeeNm() {
    if (nmHealthEmployeeNm == null) {
      return "";
    }
    return nmHealthEmployeeNm;
  }

  public String getNmHealthEmployeeNmObject() {
    return nmHealthEmployeeNm;
  }

  public void setNmHealthEmployeeNm(String nmHealthEmployeeNm) {
    if ((nmHealthEmployeeNm != null) &&
        (nmHealthEmployeeNm.length() > 50)) {
      throw new IllegalStateException("Data is too large for 'nmHealthEmployeeNm'; \n" +
                                      " max size = 50; \n" +
                                      " data = '" + nmHealthEmployeeNm + "'");
    }
    this.hasNmHealthEmployeeNm = true;
    this.nmHealthEmployeeNm = nmHealthEmployeeNm;
  }

  public boolean hasNmHealthEmployerNm() {
    return hasNmHealthEmployerNm;
  }

  public String getNmHealthEmployerNm() {
    if (nmHealthEmployerNm == null) {
      return "";
    }
    return nmHealthEmployerNm;
  }

  public String getNmHealthEmployerNmObject() {
    return nmHealthEmployerNm;
  }

  public void setNmHealthEmployerNm(String nmHealthEmployerNm) {
    if ((nmHealthEmployerNm != null) &&
        (nmHealthEmployerNm.length() > 50)) {
      throw new IllegalStateException("Data is too large for 'nmHealthEmployerNm'; \n" +
                                      " max size = 50; \n" +
                                      " data = '" + nmHealthEmployerNm + "'");
    }
    this.hasNmHealthEmployerNm = true;
    this.nmHealthEmployerNm = nmHealthEmployerNm;
  }

  public boolean hasNmHealthPolicyHldrNm() {
    return hasNmHealthPolicyHldrNm;
  }

  public String getNmHealthPolicyHldrNm() {
    if (nmHealthPolicyHldrNm == null) {
      return "";
    }
    return nmHealthPolicyHldrNm;
  }

  public String getNmHealthPolicyHldrNmObject() {
    return nmHealthPolicyHldrNm;
  }

  public void setNmHealthPolicyHldrNm(String nmHealthPolicyHldrNm) {
    if ((nmHealthPolicyHldrNm != null) &&
        (nmHealthPolicyHldrNm.length() > 50)) {
      throw new IllegalStateException("Data is too large for 'nmHealthPolicyHldrNm'; \n" +
                                      " max size = 50; \n" +
                                      " data = '" + nmHealthPolicyHldrNm + "'");
    }
    this.hasNmHealthPolicyHldrNm = true;
    this.nmHealthPolicyHldrNm = nmHealthPolicyHldrNm;
  }

  public boolean hasNmHospital() {
    return hasNmHospital;
  }

  public String getNmHospital() {
    if (nmHospital == null) {
      return "";
    }
    return nmHospital;
  }

  public String getNmHospitalObject() {
    return nmHospital;
  }

  public void setNmHospital(String nmHospital) {
    if ((nmHospital != null) &&
        (nmHospital.length() > 50)) {
      throw new IllegalStateException("Data is too large for 'nmHospital'; \n" +
                                      " max size = 50; \n" +
                                      " data = '" + nmHospital + "'");
    }
    this.hasNmHospital = true;
    this.nmHospital = nmHospital;
  }

  public boolean hasNmHospitalCity() {
    return hasNmHospitalCity;
  }

  public String getNmHospitalCity() {
    if (nmHospitalCity == null) {
      return "";
    }
    return nmHospitalCity;
  }

  public String getNmHospitalCityObject() {
    return nmHospitalCity;
  }

  public void setNmHospitalCity(String nmHospitalCity) {
    if ((nmHospitalCity != null) &&
        (nmHospitalCity.length() > 20)) {
      throw new IllegalStateException("Data is too large for 'nmHospitalCity'; \n" +
                                      " max size = 20; \n" +
                                      " data = '" + nmHospitalCity + "'");
    }
    this.hasNmHospitalCity = true;
    this.nmHospitalCity = nmHospitalCity;
  }

  public boolean hasNmMotherMaiden() {
    return hasNmMotherMaiden;
  }

  public String getNmMotherMaiden() {
    if (nmMotherMaiden == null) {
      return "";
    }
    return nmMotherMaiden;
  }

  public String getNmMotherMaidenObject() {
    return nmMotherMaiden;
  }

  public void setNmMotherMaiden(String nmMotherMaiden) {
    if ((nmMotherMaiden != null) &&
        (nmMotherMaiden.length() > 22)) {
      throw new IllegalStateException("Data is too large for 'nmMotherMaiden'; \n" +
                                      " max size = 22; \n" +
                                      " data = '" + nmMotherMaiden + "'");
    }
    this.hasNmMotherMaiden = true;
    this.nmMotherMaiden = nmMotherMaiden;
  }

  public boolean hasNmNotifiedDhsWrkrFirst() {
    return hasNmNotifiedDhsWrkrFirst;
  }

  public String getNmNotifiedDhsWrkrFirst() {
    if (nmNotifiedDhsWrkrFirst == null) {
      return "";
    }
    return nmNotifiedDhsWrkrFirst;
  }

  public String getNmNotifiedDhsWrkrFirstObject() {
    return nmNotifiedDhsWrkrFirst;
  }

  public void setNmNotifiedDhsWrkrFirst(String nmNotifiedDhsWrkrFirst) {
    if ((nmNotifiedDhsWrkrFirst != null) &&
        (nmNotifiedDhsWrkrFirst.length() > 12)) {
      throw new IllegalStateException("Data is too large for 'nmNotifiedDhsWrkrFirst'; \n" +
                                      " max size = 12; \n" +
                                      " data = '" + nmNotifiedDhsWrkrFirst + "'");
    }
    this.hasNmNotifiedDhsWrkrFirst = true;
    this.nmNotifiedDhsWrkrFirst = nmNotifiedDhsWrkrFirst;
  }

  public boolean hasNmNotifiedDhsWrkrLast() {
    return hasNmNotifiedDhsWrkrLast;
  }

  public String getNmNotifiedDhsWrkrLast() {
    if (nmNotifiedDhsWrkrLast == null) {
      return "";
    }
    return nmNotifiedDhsWrkrLast;
  }

  public String getNmNotifiedDhsWrkrLastObject() {
    return nmNotifiedDhsWrkrLast;
  }

  public void setNmNotifiedDhsWrkrLast(String nmNotifiedDhsWrkrLast) {
    if ((nmNotifiedDhsWrkrLast != null) &&
        (nmNotifiedDhsWrkrLast.length() > 22)) {
      throw new IllegalStateException("Data is too large for 'nmNotifiedDhsWrkrLast'; \n" +
                                      " max size = 22; \n" +
                                      " data = '" + nmNotifiedDhsWrkrLast + "'");
    }
    this.hasNmNotifiedDhsWrkrLast = true;
    this.nmNotifiedDhsWrkrLast = nmNotifiedDhsWrkrLast;
  }

  public boolean hasNmNotifiedDhsWrkrMiddle() {
    return hasNmNotifiedDhsWrkrMiddle;
  }

  public String getNmNotifiedDhsWrkrMiddle() {
    if (nmNotifiedDhsWrkrMiddle == null) {
      return "";
    }
    return nmNotifiedDhsWrkrMiddle;
  }

  public String getNmNotifiedDhsWrkrMiddleObject() {
    return nmNotifiedDhsWrkrMiddle;
  }

  public void setNmNotifiedDhsWrkrMiddle(String nmNotifiedDhsWrkrMiddle) {
    if ((nmNotifiedDhsWrkrMiddle != null) &&
        (nmNotifiedDhsWrkrMiddle.length() > 12)) {
      throw new IllegalStateException("Data is too large for 'nmNotifiedDhsWrkrMiddle'; \n" +
                                      " max size = 12; \n" +
                                      " data = '" + nmNotifiedDhsWrkrMiddle + "'");
    }
    this.hasNmNotifiedDhsWrkrMiddle = true;
    this.nmNotifiedDhsWrkrMiddle = nmNotifiedDhsWrkrMiddle;
  }

  public boolean hasTxtIncomeDtrmntnComments() {
    return hasTxtIncomeDtrmntnComments;
  }

  public String getTxtIncomeDtrmntnComments() {
    if (txtIncomeDtrmntnComments == null) {
      return "";
    }
    return txtIncomeDtrmntnComments;
  }

  public String getTxtIncomeDtrmntnCommentsObject() {
    return txtIncomeDtrmntnComments;
  }

  public void setTxtIncomeDtrmntnComments(String txtIncomeDtrmntnComments) {
    if ((txtIncomeDtrmntnComments != null) &&
        (txtIncomeDtrmntnComments.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtIncomeDtrmntnComments'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtIncomeDtrmntnComments + "'");
    }
    this.hasTxtIncomeDtrmntnComments = true;
    this.txtIncomeDtrmntnComments = txtIncomeDtrmntnComments;
  }

  public boolean hasTxtLegalDocsSentEs() {
    return hasTxtLegalDocsSentEs;
  }

  public String getTxtLegalDocsSentEs() {
    if (txtLegalDocsSentEs == null) {
      return "";
    }
    return txtLegalDocsSentEs;
  }

  public String getTxtLegalDocsSentEsObject() {
    return txtLegalDocsSentEs;
  }

  public void setTxtLegalDocsSentEs(String txtLegalDocsSentEs) {
    if ((txtLegalDocsSentEs != null) &&
        (txtLegalDocsSentEs.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtLegalDocsSentEs'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtLegalDocsSentEs + "'");
    }
    this.hasTxtLegalDocsSentEs = true;
    this.txtLegalDocsSentEs = txtLegalDocsSentEs;
  }

  public boolean hasTxtMeetsDdOrNotComments() {
    return hasTxtMeetsDdOrNotComments;
  }

  public String getTxtMeetsDdOrNotComments() {
    if (txtMeetsDdOrNotComments == null) {
      return "";
    }
    return txtMeetsDdOrNotComments;
  }

  public String getTxtMeetsDdOrNotCommentsObject() {
    return txtMeetsDdOrNotComments;
  }

  public void setTxtMeetsDdOrNotComments(String txtMeetsDdOrNotComments) {
    if ((txtMeetsDdOrNotComments != null) &&
        (txtMeetsDdOrNotComments.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtMeetsDdOrNotComments'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtMeetsDdOrNotComments + "'");
    }
    this.hasTxtMeetsDdOrNotComments = true;
    this.txtMeetsDdOrNotComments = txtMeetsDdOrNotComments;
  }

  public boolean hasTxtNoIncomeExplanation() {
    return hasTxtNoIncomeExplanation;
  }

  public String getTxtNoIncomeExplanation() {
    if (txtNoIncomeExplanation == null) {
      return "";
    }
    return txtNoIncomeExplanation;
  }

  public String getTxtNoIncomeExplanationObject() {
    return txtNoIncomeExplanation;
  }

  public void setTxtNoIncomeExplanation(String txtNoIncomeExplanation) {
    if ((txtNoIncomeExplanation != null) &&
        (txtNoIncomeExplanation.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtNoIncomeExplanation'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtNoIncomeExplanation + "'");
    }
    this.hasTxtNoIncomeExplanation = true;
    this.txtNoIncomeExplanation = txtNoIncomeExplanation;
  }

  public boolean hasTxtProofAgeSentEs() {
    return hasTxtProofAgeSentEs;
  }

  public String getTxtProofAgeSentEs() {
    if (txtProofAgeSentEs == null) {
      return "";
    }
    return txtProofAgeSentEs;
  }

  public String getTxtProofAgeSentEsObject() {
    return txtProofAgeSentEs;
  }

  public void setTxtProofAgeSentEs(String txtProofAgeSentEs) {
    if ((txtProofAgeSentEs != null) &&
        (txtProofAgeSentEs.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtProofAgeSentEs'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtProofAgeSentEs + "'");
    }
    this.hasTxtProofAgeSentEs = true;
    this.txtProofAgeSentEs = txtProofAgeSentEs;
  }

  public boolean hasTxtProofCitizenshipSentEs() {
    return hasTxtProofCitizenshipSentEs;
  }

  public String getTxtProofCitizenshipSentEs() {
    if (txtProofCitizenshipSentEs == null) {
      return "";
    }
    return txtProofCitizenshipSentEs;
  }

  public String getTxtProofCitizenshipSentEsObject() {
    return txtProofCitizenshipSentEs;
  }

  public void setTxtProofCitizenshipSentEs(String txtProofCitizenshipSentEs) {
    if ((txtProofCitizenshipSentEs != null) &&
        (txtProofCitizenshipSentEs.length() > 300)) {
      throw new IllegalStateException("Data is too large for 'txtProofCitizenshipSentEs'; \n" +
                                      " max size = 300; \n" +
                                      " data = '" + txtProofCitizenshipSentEs + "'");
    }
    this.hasTxtProofCitizenshipSentEs = true;
    this.txtProofCitizenshipSentEs = txtProofCitizenshipSentEs;
  }

  
  public boolean hasTxtPriorRemovalMonths() {
    return hasTxtPriorRemovalMonths;
  }

  public String getTxtPriorRemovalMonths() {
    if (txtPriorRemovalMonths == null) {
      return "";
    }
    return txtPriorRemovalMonths;
  }
  public String getTxtPriorRemovalMonthsObject() {
    return txtPriorRemovalMonths;
  }
  
  public void setTxtPriorRemovalMonths(String txtPriorRemovalMonths) {
    
    this.hasTxtPriorRemovalMonths = true;
    this.txtPriorRemovalMonths = txtPriorRemovalMonths;
  }
  
  public boolean hasIndProofChildIdSentEs() {
    return hasIndProofChildIdSentEs;
  }

  public boolean getIndProofChildIdSentEs() {
    if (indProofChildIdSentEs == null) {
      return false;
    }
    return indProofChildIdSentEs.booleanValue();
  }

  public Boolean getIndProofChildIdSentEsObject() {
    return indProofChildIdSentEs;
  }

  public String getIndProofChildIdSentEsString() {
    if (indProofChildIdSentEs == null) {
      return "";
    }
    return indProofChildIdSentEs.toString();
  }

  public void setIndProofChildIdSentEs(boolean indProofChildIdSentEs) {
    this.hasIndProofChildIdSentEs = true;
    this.indProofChildIdSentEs = new Boolean(indProofChildIdSentEs);
  }

  public void setIndProofChildIdSentEs(Boolean indProofChildIdSentEs) {
    this.hasIndProofChildIdSentEs = true;
    this.indProofChildIdSentEs = indProofChildIdSentEs;
  }

  public void setIndProofChildIdSentEs(String indProofChildIdSentEs) {
    this.hasIndProofChildIdSentEs = true;
    this.indProofChildIdSentEs = isTrueBoolean(indProofChildIdSentEs);
  }
  
  public boolean hasDtProofChildIdSentEs() {
    return hasDtProofChildIdSentEs;
  }

  public Date getDtProofChildIdSentEs() {
    return dtProofChildIdSentEs;
  }

  public Date getDtProofChildIdSentEsObject() {
    return dtProofChildIdSentEs;
  }

  public String getDtProofChildIdSentEsString() {
    return toString(dtProofChildIdSentEs);
  }

  public long getDtProofChildIdSentEsTime() {
    return toTime(dtProofChildIdSentEs);
  }

  public void setDtProofChildIdSentEs(Date dtProofChildIdSentEs) {
    this.hasDtProofChildIdSentEs = true;
    if ((dtProofChildIdSentEs != null) &&
        (dtProofChildIdSentEs.getTime() == 0)) {
      dtProofChildIdSentEs = null;
    }
    this.dtProofChildIdSentEs = dtProofChildIdSentEs;
  }

  public void setDtProofChildIdSentEsString(String dtProofChildIdSentEsString) {
    this.hasDtProofChildIdSentEs = true;
    this.dtProofChildIdSentEs = toDate(dtProofChildIdSentEsString);
  }

  public void setDtProofChildIdSentEsTime(long dtProofChildIdSentEsTime) {
    this.hasDtProofChildIdSentEs = true;
    this.dtProofChildIdSentEs = toDate(dtProofChildIdSentEsTime);
  }
  
  public boolean hasTxtProofChildIdSentEs() {
    return hasTxtProofChildIdSentEs;
  }

  public String getTxtProofChildIdSentEs() {
    if (txtProofChildIdSentEs == null) {
      return "";
    }
    return txtProofChildIdSentEs;
  }

  public String getTxtProofChildIdSentEsObject() {
    return txtProofChildIdSentEs;
  }

  public void setTxtProofChildIdSentEs(String txtProofChildIdSentEs) {
    this.hasTxtProofChildIdSentEs = true;
    this.txtProofChildIdSentEs = txtProofChildIdSentEs;
  }
  
  public boolean hasIndProofPregnancySentEs() {
    return hasIndProofPregnancySentEs;
  }

  public boolean getIndProofPregnancySentEs() {
    if (indProofPregnancySentEs == null) {
      return false;
    }
    return indProofPregnancySentEs.booleanValue();
  }

  public Boolean getIndProofPregnancySentEsObject() {
    return indProofPregnancySentEs;
  }

  public String getIndProofPregnancySentEsString() {
    if (indProofPregnancySentEs == null) {
      return "";
    }
    return indProofPregnancySentEs.toString();
  }

  public void setIndProofPregnancySentEs(boolean indProofPregnancySentEs) {
    this.hasIndProofPregnancySentEs = true;
    this.indProofPregnancySentEs = new Boolean(indProofPregnancySentEs);
  }

  public void setIndProofPregnancySentEs(Boolean indProofPregnancySentEs) {
    this.hasIndProofPregnancySentEs = true;
    this.indProofPregnancySentEs = indProofPregnancySentEs;
  }

  public void setIndProofPregnancySentEs(String indProofPregnancySentEs) {
    this.hasIndProofPregnancySentEs = true;
    this.indProofPregnancySentEs = isTrueBoolean(indProofPregnancySentEs);
  }
  
  public boolean hasDtProofPregnancySentEs() {
    return hasDtProofPregnancySentEs;
  }

  public Date getDtProofPregnancySentEs() {
    return dtProofPregnancySentEs;
  }

  public Date getDtProofPregnancySentEsObject() {
    return dtProofPregnancySentEs;
  }

  public String getDtProofPregnancySentEsString() {
    return toString(dtProofPregnancySentEs);
  }

  public long getDtProofPregnancySentEsTime() {
    return toTime(dtProofPregnancySentEs);
  }

  public void setDtProofPregnancySentEs(Date dtProofPregnancySentEs) {
    this.hasDtProofPregnancySentEs = true;
    if ((dtProofPregnancySentEs != null) &&
        (dtProofPregnancySentEs.getTime() == 0)) {
      dtProofPregnancySentEs = null;
    }
    this.dtProofPregnancySentEs = dtProofPregnancySentEs;
  }

  public void setDtProofPregnancySentEsString(String dtProofPregnancySentEsString) {
    this.hasDtProofPregnancySentEs = true;
    this.dtProofPregnancySentEs = toDate(dtProofPregnancySentEsString);
  }

  public void setDtProofPregnancySentEsTime(long dtProofPregnancySentEsTime) {
    this.hasDtProofPregnancySentEs = true;
    this.dtProofPregnancySentEs = toDate(dtProofPregnancySentEsTime);
  }
  
  public boolean hasTxtProofPregnancySentEs() {
    return hasTxtProofPregnancySentEs;
  }

  public String getTxtProofPregnancySentEs() {
    if (txtProofPregnancySentEs == null) {
      return "";
    }
    return txtProofPregnancySentEs;
  }

  public String getTxtProofPregnancySentEsObject() {
    return txtProofPregnancySentEs;
  }

  public void setTxtProofPregnancySentEs(String txtProofPregnancySentEs) {
    this.hasTxtProofPregnancySentEs = true;
    this.txtProofPregnancySentEs = txtProofPregnancySentEs;
  }
  
  public boolean hasTxtEmployeeComments() {
    return hasTxtEmployeeComments;
  }

  public String getTxtEmployeeComments() {
    if (txtEmployeeComments == null) {
      return "";
    }
    return txtEmployeeComments;
  }

  public String getTxtEmployeeCommentsObject() {
    return txtEmployeeComments;
  }

  public void setTxtEmployeeComments(String txtEmployeeComments) {
    this.hasTxtEmployeeComments = true;
    this.txtEmployeeComments = txtEmployeeComments;
  }
  
  public boolean hasDtLegalDocsSentEs() {
    return hasDtLegalDocsSentEs;
  }

  public Date getDtLegalDocsSentEs() {
    return dtLegalDocsSentEs;
  }

  public Date getDtLegalDocsSentEsObject() {
    return dtLegalDocsSentEs;
  }

  public String getDtLegalDocsSentEsString() {
    return toString(dtLegalDocsSentEs);
  }

  public long getDtLegalDocsSentEsTime() {
    return toTime(dtLegalDocsSentEs);
  }

  public void setDtLegalDocsSentEs(Date dtLegalDocsSentEs) {
    this.hasDtLegalDocsSentEs = true;
    if ((dtLegalDocsSentEs != null) &&
        (dtLegalDocsSentEs.getTime() == 0)) {
      dtLegalDocsSentEs = null;
    }
    this.dtLegalDocsSentEs = dtLegalDocsSentEs;
  }

  public void setDtLegalDocsSentEsString(String dtLegalDocsSentEsString) {
    this.hasDtLegalDocsSentEs = true;
    this.dtLegalDocsSentEs = toDate(dtLegalDocsSentEsString);
  }

  public void setDtLegalDocsSentEsTime(long dtLegalDocsSentEsTime) {
    this.hasDtLegalDocsSentEs = true;
    this.dtLegalDocsSentEs = toDate(dtLegalDocsSentEsTime);
  }
  
  public void copyInto(FceApplicationDB fceApplicationDB) {
    if (hasAddrHealthAddrCity) {
      fceApplicationDB.setAddrHealthAddrCity(addrHealthAddrCity);
    }
    if (hasAddrHealthAddrStLn1) {
      fceApplicationDB.setAddrHealthAddrStLn1(addrHealthAddrStLn1);
    }
    if (hasAddrHealthAddrStLn2) {
      fceApplicationDB.setAddrHealthAddrStLn2(addrHealthAddrStLn2);
    }
    if (hasAddrHealthAddrZip) {
      fceApplicationDB.setAddrHealthAddrZip(addrHealthAddrZip);
    }
    if (hasAddrRemovalAddrZip) {
      fceApplicationDB.setAddrRemovalAddrZip(addrRemovalAddrZip);
    }
    if (hasAddrRemovalCity) {
      fceApplicationDB.setAddrRemovalCity(addrRemovalCity);
    }
    if (hasAddrRemovalStLn1) {
      fceApplicationDB.setAddrRemovalStLn1(addrRemovalStLn1);
    }
    if (hasAddrRemovalStLn2) {
      fceApplicationDB.setAddrRemovalStLn2(addrRemovalStLn2);
    }
    if (hasCdApplication) {
      fceApplicationDB.setCdApplication(cdApplication);
    }
    if (hasCdCountyHospital) {
      fceApplicationDB.setCdCountyHospital(cdCountyHospital);
    }
    if (hasCdHealthAddrState) {
      fceApplicationDB.setCdHealthAddrState(cdHealthAddrState);
    }
    if (hasCdLivingMonthRemoval) {
      fceApplicationDB.setCdLivingMonthRemoval(cdLivingMonthRemoval);
    }
    if (hasCdNotaMostRecent) {
      fceApplicationDB.setCdNotaMostRecent(cdNotaMostRecent);
    }
    if (hasCdRemovalAddrCounty) {
      fceApplicationDB.setCdRemovalAddrCounty(cdRemovalAddrCounty);
    }
    if (hasCdRemovalAddrState) {
      fceApplicationDB.setCdRemovalAddrState(cdRemovalAddrState);
    }
    if (hasCdState) {
      fceApplicationDB.setCdState(cdState);
    }
    if (hasDtApplicationComplete) {
      fceApplicationDB.setDtApplicationComplete(dtApplicationComplete);
    }
    if (hasDtHealthBeginDate) {
      fceApplicationDB.setDtHealthBeginDate(dtHealthBeginDate);
    }
    if (hasDtHealthEndDate) {
      fceApplicationDB.setDtHealthEndDate(dtHealthEndDate);
    }
    if (hasDtHospitalAdmission) {
      fceApplicationDB.setDtHospitalAdmission(dtHospitalAdmission);
    }
    if (hasDtHospitalDischarge) {
      fceApplicationDB.setDtHospitalDischarge(dtHospitalDischarge);
    }
    if (hasDtLastUpdate) {
      fceApplicationDB.setDtLastUpdate(dtLastUpdate);
    }
    if (hasDtNotifiedWorker) {
      fceApplicationDB.setDtNotifiedWorker(dtNotifiedWorker);
    }
    if (hasDtProofAgeSentEs) {
      fceApplicationDB.setDtProofAgeSentEs(dtProofAgeSentEs);
    }
    if (hasDtProofCitizenshipSentEs) {
      fceApplicationDB.setDtProofCitizenshipSentEs(dtProofCitizenshipSentEs);
    }
    if (hasDtRemovalDate) {
      fceApplicationDB.setDtRemovalDate(dtRemovalDate);
    }
    if (hasIdCase) {
      fceApplicationDB.setIdCase(idCase);
    }
    if (hasIdEvent) {
      fceApplicationDB.setIdEvent(idEvent);
    }
    if (hasIdFceApplication) {
      fceApplicationDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      fceApplicationDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdLastUpdatePerson) {
      fceApplicationDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdMngngCvsPerson) {
      fceApplicationDB.setIdMngngCvsPerson(idMngngCvsPerson);
    }
    if (hasIdOtherRelativePerson) {
      fceApplicationDB.setIdOtherRelativePerson(idOtherRelativePerson);
    }
    if (hasIdPerson) {
      fceApplicationDB.setIdPerson(idPerson);
    }
    if (hasIdStage) {
      fceApplicationDB.setIdStage(idStage);
    }
    if (hasIndAgeJustifiedEval) {
      fceApplicationDB.setIndAgeJustifiedEval(indAgeJustifiedEval);
    }
    if (hasIndAgeVrfdBaptismCert) {
      fceApplicationDB.setIndAgeVrfdBaptismCert(indAgeVrfdBaptismCert);
    }
    if (hasIndAgeVrfdForeignCert) {
      fceApplicationDB.setIndAgeVrfdForeignCert(indAgeVrfdForeignCert);
    }
    if (hasIndAgeVrfdHospitalCert) {
      fceApplicationDB.setIndAgeVrfdHospitalCert(indAgeVrfdHospitalCert);
    }
    if (hasIndAgeVrfdNtrlztnCert) {
      fceApplicationDB.setIndAgeVrfdNtrlztnCert(indAgeVrfdNtrlztnCert);
    }
    if (hasIndAgeVrfdPassport) {
      fceApplicationDB.setIndAgeVrfdPassport(indAgeVrfdPassport);
    }
    if (hasIndAgeVrfdResidentCard) {
      fceApplicationDB.setIndAgeVrfdResidentCard(indAgeVrfdResidentCard);
    }
    if (hasIndAgeVrfdSaveSystem) {
      fceApplicationDB.setIndAgeVrfdSaveSystem(indAgeVrfdSaveSystem);
    }
    if (hasIndAgeVrfdSuccessSystem) {
      fceApplicationDB.setIndAgeVrfdSuccessSystem(indAgeVrfdSuccessSystem);
    }
    if (hasIndAgeVrfdUsBirthCert) {
      fceApplicationDB.setIndAgeVrfdUsBirthCert(indAgeVrfdUsBirthCert);
    }
    if (hasIndAmendedApp) {
      fceApplicationDB.setIndAmendedApp(indAmendedApp);
    }
    if (hasIndChildSupportOrder) {
      fceApplicationDB.setIndChildSupportOrder(indChildSupportOrder);
    }
    if (hasIndEvaluationConclusion) {
      fceApplicationDB.setIndEvaluationConclusion(indEvaluationConclusion);
    }
    if (hasIndHospital) {
      fceApplicationDB.setIndHospital(indHospital);
    }
    if (hasIndIncomeAssistance) {
      fceApplicationDB.setIndIncomeAssistance(indIncomeAssistance);
    }
    if (hasIndLegalDocsSentEs) {
      fceApplicationDB.setIndLegalDocsSentEs(indLegalDocsSentEs);
    }
    if (hasIndLivingRelativeSixMonth) {
      fceApplicationDB.setIndLivingRelativeSixMonth(indLivingRelativeSixMonth);
    }
    if (hasIndManagingCvs) {
      fceApplicationDB.setIndManagingCvs(indManagingCvs);
    }
    if (hasIndMinorParent) {
      fceApplicationDB.setIndMinorParent(indMinorParent);
    }
    if (hasIndNotifiedDhsWorker) {
      fceApplicationDB.setIndNotifiedDhsWorker(indNotifiedDhsWorker);
    }
    if (hasIndOtherHealthInsurance) {
      fceApplicationDB.setIndOtherHealthInsurance(indOtherHealthInsurance);
    }
    if (hasIndProofAgeSentEs) {
      fceApplicationDB.setIndProofAgeSentEs(indProofAgeSentEs);
    }
    if (hasIndProofCitizenshipSentEs) {
      fceApplicationDB.setIndProofCitizenshipSentEs(indProofCitizenshipSentEs);
    }
    if (hasIndSpecifiedRelative) {
      fceApplicationDB.setIndSpecifiedRelative(indSpecifiedRelative);
    }
    if (hasNbrCourtMonth) {
      fceApplicationDB.setNbrCourtMonth(nbrCourtMonth);
    }
    if (hasNbrCourtYear) {
      fceApplicationDB.setNbrCourtYear(nbrCourtYear);
    }
    if (hasNbrHealthGroup) {
      fceApplicationDB.setNbrHealthGroup(nbrHealthGroup);
    }
    if (hasNbrHealthPolicy) {
      fceApplicationDB.setNbrHealthPolicy(nbrHealthPolicy);
    }
    if (hasNbrLivingAtHome) {
      fceApplicationDB.setNbrLivingAtHome(nbrLivingAtHome);
    }
    if (hasNbrNotifiedDhsWrkrPhn) {
      fceApplicationDB.setNbrNotifiedDhsWrkrPhn(nbrNotifiedDhsWrkrPhn);
    }
    if (hasNmHealthCompany) {
      fceApplicationDB.setNmHealthCompany(nmHealthCompany);
    }
    if (hasNmHealthEmployeeNm) {
      fceApplicationDB.setNmHealthEmployeeNm(nmHealthEmployeeNm);
    }
    if (hasNmHealthEmployerNm) {
      fceApplicationDB.setNmHealthEmployerNm(nmHealthEmployerNm);
    }
    if (hasNmHealthPolicyHldrNm) {
      fceApplicationDB.setNmHealthPolicyHldrNm(nmHealthPolicyHldrNm);
    }
    if (hasNmHospital) {
      fceApplicationDB.setNmHospital(nmHospital);
    }
    if (hasNmHospitalCity) {
      fceApplicationDB.setNmHospitalCity(nmHospitalCity);
    }
    if (hasNmMotherMaiden) {
      fceApplicationDB.setNmMotherMaiden(nmMotherMaiden);
    }
    if (hasNmNotifiedDhsWrkrFirst) {
      fceApplicationDB.setNmNotifiedDhsWrkrFirst(nmNotifiedDhsWrkrFirst);
    }
    if (hasNmNotifiedDhsWrkrLast) {
      fceApplicationDB.setNmNotifiedDhsWrkrLast(nmNotifiedDhsWrkrLast);
    }
    if (hasNmNotifiedDhsWrkrMiddle) {
      fceApplicationDB.setNmNotifiedDhsWrkrMiddle(nmNotifiedDhsWrkrMiddle);
    }
    if (hasTxtIncomeDtrmntnComments) {
      fceApplicationDB.setTxtIncomeDtrmntnComments(txtIncomeDtrmntnComments);
    }
    if (hasTxtLegalDocsSentEs) {
      fceApplicationDB.setTxtLegalDocsSentEs(txtLegalDocsSentEs);
    }
    if (hasTxtMeetsDdOrNotComments) {
      fceApplicationDB.setTxtMeetsDdOrNotComments(txtMeetsDdOrNotComments);
    }
    if (hasTxtNoIncomeExplanation) {
      fceApplicationDB.setTxtNoIncomeExplanation(txtNoIncomeExplanation);
    }
    if (hasTxtProofAgeSentEs) {
      fceApplicationDB.setTxtProofAgeSentEs(txtProofAgeSentEs);
    }
    if (hasTxtProofCitizenshipSentEs) {
      fceApplicationDB.setTxtProofCitizenshipSentEs(txtProofCitizenshipSentEs);
    }
    if(hasIndProofChildIdSentEs){
      fceApplicationDB.setIndProofChildIdSentEs(indProofChildIdSentEs);
    }
    if(hasDtProofChildIdSentEs){
      fceApplicationDB.setDtProofChildIdSentEs(dtProofChildIdSentEs);
    }
    if(hasTxtProofChildIdSentEs){
      fceApplicationDB.setTxtProofChildIdSentEs(txtProofChildIdSentEs);
    }
    if(hasIndProofPregnancySentEs){
      fceApplicationDB.setIndProofPregnancySentEs(indProofPregnancySentEs);
    }
    if(hasDtProofPregnancySentEs){
      fceApplicationDB.setDtProofPregnancySentEs(dtProofPregnancySentEs);
    }
    if(hasTxtProofPregnancySentEs){
      fceApplicationDB.setTxtProofPregnancySentEs(txtProofPregnancySentEs);
    }
    if(hasTxtEmployeeComments){
      fceApplicationDB.setTxtEmployeeComments(txtEmployeeComments);
    }
    if (hasDtLegalDocsSentEs) {
      fceApplicationDB.setDtLegalDocsSentEs(dtLegalDocsSentEs);
    }
  }

  public static void populateWithMap(FceApplicationDB fceApplicationDB,
                                     Map map) {
    if (map.containsKey("ADDR_HEALTH_ADDR_CITY")) {
      String value = (String) map.get("ADDR_HEALTH_ADDR_CITY");
      fceApplicationDB.setAddrHealthAddrCity(value);
    }
    if (map.containsKey("ADDR_HEALTH_ADDR_ST_LN_1")) {
      String value = (String) map.get("ADDR_HEALTH_ADDR_ST_LN_1");
      fceApplicationDB.setAddrHealthAddrStLn1(value);
    }
    if (map.containsKey("ADDR_HEALTH_ADDR_ST_LN_2")) {
      String value = (String) map.get("ADDR_HEALTH_ADDR_ST_LN_2");
      fceApplicationDB.setAddrHealthAddrStLn2(value);
    }
    if (map.containsKey("ADDR_HEALTH_ADDR_ZIP")) {
      String value = (String) map.get("ADDR_HEALTH_ADDR_ZIP");
      fceApplicationDB.setAddrHealthAddrZip(value);
    }
    if (map.containsKey("ADDR_REMOVAL_ADDR_ZIP")) {
      String value = (String) map.get("ADDR_REMOVAL_ADDR_ZIP");
      fceApplicationDB.setAddrRemovalAddrZip(value);
    }
    if (map.containsKey("ADDR_REMOVAL_CITY")) {
      String value = (String) map.get("ADDR_REMOVAL_CITY");
      fceApplicationDB.setAddrRemovalCity(value);
    }
    if (map.containsKey("ADDR_REMOVAL_ST_LN_1")) {
      String value = (String) map.get("ADDR_REMOVAL_ST_LN_1");
      fceApplicationDB.setAddrRemovalStLn1(value);
    }
    if (map.containsKey("ADDR_REMOVAL_ST_LN_2")) {
      String value = (String) map.get("ADDR_REMOVAL_ST_LN_2");
      fceApplicationDB.setAddrRemovalStLn2(value);
    }
    if (map.containsKey("CD_APPLICATION")) {
      String value = (String) map.get("CD_APPLICATION");
      fceApplicationDB.setCdApplication(value);
    }
    if (map.containsKey("CD_COUNTY_HOSPITAL")) {
      String value = (String) map.get("CD_COUNTY_HOSPITAL");
      fceApplicationDB.setCdCountyHospital(value);
    }
    if (map.containsKey("CD_HEALTH_ADDR_STATE")) {
      String value = (String) map.get("CD_HEALTH_ADDR_STATE");
      fceApplicationDB.setCdHealthAddrState(value);
    }
    if (map.containsKey("CD_LIVING_MONTH_REMOVAL")) {
      String value = (String) map.get("CD_LIVING_MONTH_REMOVAL");
      fceApplicationDB.setCdLivingMonthRemoval(value);
    }
    if (map.containsKey("CD_NOTA_MOST_RECENT")) {
      String value = (String) map.get("CD_NOTA_MOST_RECENT");
      fceApplicationDB.setCdNotaMostRecent(value);
    }
    if (map.containsKey("CD_REMOVAL_ADDR_COUNTY")) {
      String value = (String) map.get("CD_REMOVAL_ADDR_COUNTY");
      fceApplicationDB.setCdRemovalAddrCounty(value);
    }
    if (map.containsKey("CD_REMOVAL_ADDR_STATE")) {
      String value = (String) map.get("CD_REMOVAL_ADDR_STATE");
      fceApplicationDB.setCdRemovalAddrState(value);
    }
    if (map.containsKey("CD_STATE")) {
      String value = (String) map.get("CD_STATE");
      fceApplicationDB.setCdState(value);
    }
    if (map.containsKey("DT_APPLICATION_COMPLETE")) {
      Date value = (Date) map.get("DT_APPLICATION_COMPLETE");
      fceApplicationDB.setDtApplicationComplete(value);
    }
    if (map.containsKey("DT_HEALTH_BEGIN_DATE")) {
      Date value = (Date) map.get("DT_HEALTH_BEGIN_DATE");
      fceApplicationDB.setDtHealthBeginDate(value);
    }
    if (map.containsKey("DT_HEALTH_END_DATE")) {
      Date value = (Date) map.get("DT_HEALTH_END_DATE");
      fceApplicationDB.setDtHealthEndDate(value);
    }
    if (map.containsKey("DT_HOSPITAL_ADMISSION")) {
      Date value = (Date) map.get("DT_HOSPITAL_ADMISSION");
      fceApplicationDB.setDtHospitalAdmission(value);
    }
    if (map.containsKey("DT_HOSPITAL_DISCHARGE")) {
      Date value = (Date) map.get("DT_HOSPITAL_DISCHARGE");
      fceApplicationDB.setDtHospitalDischarge(value);
    }
    if (map.containsKey("DT_LAST_UPDATE")) {
      Date value = (Date) map.get("DT_LAST_UPDATE");
      fceApplicationDB.setDtLastUpdate(value);
    }
    if (map.containsKey("DT_NOTIFIED_WORKER")) {
      Date value = (Date) map.get("DT_NOTIFIED_WORKER");
      fceApplicationDB.setDtNotifiedWorker(value);
    }
    if (map.containsKey("DT_PROOF_AGE_SENT_ES")) {
      Date value = (Date) map.get("DT_PROOF_AGE_SENT_ES");
      fceApplicationDB.setDtProofAgeSentEs(value);
    }
    if (map.containsKey("DT_PROOF_CITIZENSHIP_SENT_ES")) {
      Date value = (Date) map.get("DT_PROOF_CITIZENSHIP_SENT_ES");
      fceApplicationDB.setDtProofCitizenshipSentEs(value);
    }
    if (map.containsKey("DT_REMOVAL_DATE")) {
      Date value = (Date) map.get("DT_REMOVAL_DATE");
      fceApplicationDB.setDtRemovalDate(value);
    }
    if (map.containsKey("ID_CASE")) {
      Number value = (Number) map.get("ID_CASE");
      fceApplicationDB.setIdCase(value);
    }
    if (map.containsKey("ID_EVENT")) {
      Number value = (Number) map.get("ID_EVENT");
      fceApplicationDB.setIdEvent(value);
    }
    if (map.containsKey("ID_FCE_APPLICATION")) {
      Number value = (Number) map.get("ID_FCE_APPLICATION");
      fceApplicationDB.setIdFceApplication(value);
    }
    if (map.containsKey("ID_FCE_ELIGIBILITY")) {
      Number value = (Number) map.get("ID_FCE_ELIGIBILITY");
      fceApplicationDB.setIdFceEligibility(value);
    }
    if (map.containsKey("ID_LAST_UPDATE_PERSON")) {
      Number value = (Number) map.get("ID_LAST_UPDATE_PERSON");
      fceApplicationDB.setIdLastUpdatePerson(value);
    }
    if (map.containsKey("ID_MNGNG_CVS_PERSON")) {
      Number value = (Number) map.get("ID_MNGNG_CVS_PERSON");
      fceApplicationDB.setIdMngngCvsPerson(value);
    }
    if (map.containsKey("ID_OTHER_RELATIVE_PERSON")) {
      Number value = (Number) map.get("ID_OTHER_RELATIVE_PERSON");
      fceApplicationDB.setIdOtherRelativePerson(value);
    }
    if (map.containsKey("ID_PERSON")) {
      Number value = (Number) map.get("ID_PERSON");
      fceApplicationDB.setIdPerson(value);
    }
    if (map.containsKey("ID_STAGE")) {
      Number value = (Number) map.get("ID_STAGE");
      fceApplicationDB.setIdStage(value);
    }
    if (map.containsKey("IND_AGE_JUSTIFIED_EVAL")) {
      String value = (String) map.get("IND_AGE_JUSTIFIED_EVAL");
      fceApplicationDB.setIndAgeJustifiedEval(value);
    }
    if (map.containsKey("IND_AGE_VRFD_BAPTISM_CERT")) {
      String value = (String) map.get("IND_AGE_VRFD_BAPTISM_CERT");
      fceApplicationDB.setIndAgeVrfdBaptismCert(value);
    }
    if (map.containsKey("IND_AGE_VRFD_FOREIGN_CERT")) {
      String value = (String) map.get("IND_AGE_VRFD_FOREIGN_CERT");
      fceApplicationDB.setIndAgeVrfdForeignCert(value);
    }
    if (map.containsKey("IND_AGE_VRFD_HOSPITAL_CERT")) {
      String value = (String) map.get("IND_AGE_VRFD_HOSPITAL_CERT");
      fceApplicationDB.setIndAgeVrfdHospitalCert(value);
    }
    if (map.containsKey("IND_AGE_VRFD_NTRLZTN_CERT")) {
      String value = (String) map.get("IND_AGE_VRFD_NTRLZTN_CERT");
      fceApplicationDB.setIndAgeVrfdNtrlztnCert(value);
    }
    if (map.containsKey("IND_AGE_VRFD_PASSPORT")) {
      String value = (String) map.get("IND_AGE_VRFD_PASSPORT");
      fceApplicationDB.setIndAgeVrfdPassport(value);
    }
    if (map.containsKey("IND_AGE_VRFD_RESIDENT_CARD")) {
      String value = (String) map.get("IND_AGE_VRFD_RESIDENT_CARD");
      fceApplicationDB.setIndAgeVrfdResidentCard(value);
    }
    if (map.containsKey("IND_AGE_VRFD_SAVE_SYSTEM")) {
      String value = (String) map.get("IND_AGE_VRFD_SAVE_SYSTEM");
      fceApplicationDB.setIndAgeVrfdSaveSystem (value);
    }
    if (map.containsKey("IND_AGE_VRFD_SUCCESS_SYSTEM")) {
      String value = (String) map.get("IND_AGE_VRFD_SUCCESS_SYSTEM");
      fceApplicationDB.setIndAgeVrfdSuccessSystem (value);
    }
    if (map.containsKey("IND_AGE_VRFD_US_BIRTH_CERT")) {
      String value = (String) map.get("IND_AGE_VRFD_US_BIRTH_CERT");
      fceApplicationDB.setIndAgeVrfdUsBirthCert(value);
    }
    if (map.containsKey("IND_AMENDED_APP")) {
      String value = (String) map.get("IND_AMENDED_APP");
      fceApplicationDB.setIndAmendedApp(value);
    }
    if (map.containsKey("IND_CHILD_SUPPORT_ORDER")) {
      String value = (String) map.get("IND_CHILD_SUPPORT_ORDER");
      fceApplicationDB.setIndChildSupportOrder(value);
    }
    if (map.containsKey("IND_EVALUATION_CONCLUSION")) {
      String value = (String) map.get("IND_EVALUATION_CONCLUSION");
      fceApplicationDB.setIndEvaluationConclusion(value);
    }
    if (map.containsKey("IND_HOSPITAL")) {
      String value = (String) map.get("IND_HOSPITAL");
      fceApplicationDB.setIndHospital(value);
    }
    if (map.containsKey("IND_INCOME_ASSISTANCE")) {
      String value = (String) map.get("IND_INCOME_ASSISTANCE");
      fceApplicationDB.setIndIncomeAssistance(value);
    }
    if (map.containsKey("IND_LEGAL_DOCS_SENT_ES")) {
      String value = (String) map.get("IND_LEGAL_DOCS_SENT_ES");
      fceApplicationDB.setIndLegalDocsSentEs(value);
    }
    if (map.containsKey("IND_LIVING_RELATIVE_SIX_MONTH")) {
      String value = (String) map.get("IND_LIVING_RELATIVE_SIX_MONTH");
      fceApplicationDB.setIndLivingRelativeSixMonth(value);
    }
    if (map.containsKey("IND_MANAGING_CVS")) {
      String value = (String) map.get("IND_MANAGING_CVS");
      fceApplicationDB.setIndManagingCvs(value);
    }
    if (map.containsKey("IND_MINOR_PARENT")) {
      String value = (String) map.get("IND_MINOR_PARENT");
      fceApplicationDB.setIndMinorParent(value);
    }
    if (map.containsKey("IND_NOTIFIED_DHS_WORKER")) {
      String value = (String) map.get("IND_NOTIFIED_DHS_WORKER");
      fceApplicationDB.setIndNotifiedDhsWorker(value);
    }
    if (map.containsKey("IND_OTHER_HEALTH_INSURANCE")) {
      String value = (String) map.get("IND_OTHER_HEALTH_INSURANCE");
      fceApplicationDB.setIndOtherHealthInsurance(value);
    }
    if (map.containsKey("IND_PROOF_AGE_SENT_ES")) {
      String value = (String) map.get("IND_PROOF_AGE_SENT_ES");
      fceApplicationDB.setIndProofAgeSentEs(value);
    }
    if (map.containsKey("IND_PROOF_CITIZENSHIP_SENT_ES")) {
      String value = (String) map.get("IND_PROOF_CITIZENSHIP_SENT_ES");
      fceApplicationDB.setIndProofCitizenshipSentEs(value);
    }
    if (map.containsKey("IND_SPECIFIED_RELATIVE")) {
      String value = (String) map.get("IND_SPECIFIED_RELATIVE");
      fceApplicationDB.setIndSpecifiedRelative(value);
    }
    if (map.containsKey("NBR_COURT_MONTH")) {
      Number value = (Number) map.get("NBR_COURT_MONTH");
      fceApplicationDB.setNbrCourtMonth(value);
    }
    if (map.containsKey("NBR_COURT_YEAR")) {
      Number value = (Number) map.get("NBR_COURT_YEAR");
      fceApplicationDB.setNbrCourtYear(value);
    }
    if (map.containsKey("NBR_HEALTH_GROUP")) {
      String value = (String) map.get("NBR_HEALTH_GROUP");
      fceApplicationDB.setNbrHealthGroup(value);
    }
    if (map.containsKey("NBR_HEALTH_POLICY")) {
      String value = (String) map.get("NBR_HEALTH_POLICY");
      fceApplicationDB.setNbrHealthPolicy(value);
    }
    if (map.containsKey("NBR_LIVING_AT_HOME")) {
      Number value = (Number) map.get("NBR_LIVING_AT_HOME");
      fceApplicationDB.setNbrLivingAtHome(value);
    }
    if (map.containsKey("NBR_NOTIFIED_DHS_WRKR_PHN")) {
      String value = (String) map.get("NBR_NOTIFIED_DHS_WRKR_PHN");
      fceApplicationDB.setNbrNotifiedDhsWrkrPhn(value);
    }
    if (map.containsKey("NM_HEALTH_COMPANY")) {
      String value = (String) map.get("NM_HEALTH_COMPANY");
      fceApplicationDB.setNmHealthCompany(value);
    }
    if (map.containsKey("NM_HEALTH_EMPLOYEE_NM")) {
      String value = (String) map.get("NM_HEALTH_EMPLOYEE_NM");
      fceApplicationDB.setNmHealthEmployeeNm(value);
    }
    if (map.containsKey("NM_HEALTH_EMPLOYER_NM")) {
      String value = (String) map.get("NM_HEALTH_EMPLOYER_NM");
      fceApplicationDB.setNmHealthEmployerNm(value);
    }
    if (map.containsKey("NM_HEALTH_POLICY_HLDR_NM")) {
      String value = (String) map.get("NM_HEALTH_POLICY_HLDR_NM");
      fceApplicationDB.setNmHealthPolicyHldrNm(value);
    }
    if (map.containsKey("NM_HOSPITAL")) {
      String value = (String) map.get("NM_HOSPITAL");
      fceApplicationDB.setNmHospital(value);
    }
    if (map.containsKey("NM_HOSPITAL_CITY")) {
      String value = (String) map.get("NM_HOSPITAL_CITY");
      fceApplicationDB.setNmHospitalCity(value);
    }
    if (map.containsKey("NM_MOTHER_MAIDEN")) {
      String value = (String) map.get("NM_MOTHER_MAIDEN");
      fceApplicationDB.setNmMotherMaiden(value);
    }
    if (map.containsKey("NM_NOTIFIED_DHS_WRKR_FIRST")) {
      String value = (String) map.get("NM_NOTIFIED_DHS_WRKR_FIRST");
      fceApplicationDB.setNmNotifiedDhsWrkrFirst(value);
    }
    if (map.containsKey("NM_NOTIFIED_DHS_WRKR_LAST")) {
      String value = (String) map.get("NM_NOTIFIED_DHS_WRKR_LAST");
      fceApplicationDB.setNmNotifiedDhsWrkrLast(value);
    }
    if (map.containsKey("NM_NOTIFIED_DHS_WRKR_MIDDLE")) {
      String value = (String) map.get("NM_NOTIFIED_DHS_WRKR_MIDDLE");
      fceApplicationDB.setNmNotifiedDhsWrkrMiddle(value);
    }
    if (map.containsKey("TXT_INCOME_DTRMNTN_COMMENTS")) {
      String value = (String) map.get("TXT_INCOME_DTRMNTN_COMMENTS");
      fceApplicationDB.setTxtIncomeDtrmntnComments(value);
    }
    if (map.containsKey("TXT_LEGAL_DOCS_SENT_ES")) {
      String value = (String) map.get("TXT_LEGAL_DOCS_SENT_ES");
      fceApplicationDB.setTxtLegalDocsSentEs(value);
    }
    if (map.containsKey("TXT_MEETS_DD_OR_NOT_COMMENTS")) {
      String value = (String) map.get("TXT_MEETS_DD_OR_NOT_COMMENTS");
      fceApplicationDB.setTxtMeetsDdOrNotComments(value);
    }
    if (map.containsKey("TXT_NO_INCOME_EXPLANATION")) {
      String value = (String) map.get("TXT_NO_INCOME_EXPLANATION");
      fceApplicationDB.setTxtNoIncomeExplanation(value);
    }
    if (map.containsKey("TXT_PROOF_AGE_SENT_ES")) {
      String value = (String) map.get("TXT_PROOF_AGE_SENT_ES");
      fceApplicationDB.setTxtProofAgeSentEs(value);
    }
    if (map.containsKey("TXT_PROOF_CITIZENSHIP_SENT_ES")) {
      String value = (String) map.get("TXT_PROOF_CITIZENSHIP_SENT_ES");
      fceApplicationDB.setTxtProofCitizenshipSentEs(value);
    }
    if (map.containsKey("IND_PROOF_CHILD_ID_SENT_ES")) {
      String value = (String) map.get("IND_PROOF_CHILD_ID_SENT_ES");
      fceApplicationDB.setIndProofChildIdSentEs(value);
    }
    if (map.containsKey("DT_PROOF_CHILD_ID_SENT_ES_STRING")) {
      Date value = (Date) map.get("DT_PROOF_CHILD_ID_SENT_ES_STRING");
      fceApplicationDB.setDtProofChildIdSentEs(value);
    }
    if (map.containsKey("TXT_PROOF_CHILD_ID_SENT_ES")) {
      String value = (String) map.get("TXT_PROOF_CHILD_ID_SENT_ES");
      fceApplicationDB.setTxtProofChildIdSentEs(value);
    }
    if (map.containsKey("IND_PROOF_PREGNANCY_SENT_ES")) {
      String value = (String) map.get("IND_PROOF_PREGNANCY_SENT_ES");
      fceApplicationDB.setIndProofPregnancySentEs(value);
    }
    if (map.containsKey("DT_PROOF_PREGNANCY_SENT_ES_STRING")) {
      Date value = (Date) map.get("DT_PROOF_PREGNANCY_SENT_ES_STRING");
      fceApplicationDB.setDtProofPregnancySentEs(value);
    }
    if (map.containsKey("TXT_PROOF_PREGNANCY_SENT_ES")) {
      String value = (String) map.get("TXT_PROOF_PREGNANCY_SENT_ES");
      fceApplicationDB.setTxtProofPregnancySentEs(value);
    }
    if (map.containsKey("TXT_EMPLOYEE_COMMENTS")) {
      String value = (String) map.get("TXT_EMPLOYEE_COMMENTS");
      fceApplicationDB.setTxtEmployeeComments(value);
    }
    if (map.containsKey("DT_LEGAL_DOCS_SENT_ES_STRING")) {
      Date value = (Date) map.get("DT_LEGAL_DOCS_SENT_ES_STRING");
      fceApplicationDB.setDtLegalDocsSentEs(value);
    }
  }

/*
  public static void populateWithRequest(FceApplicationDB fceApplicationDB,
                                         HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(ADDR_HEALTH_ADDR_CITY)) {
      fceApplicationDB.setAddrHealthAddrCity(ContextHelper.getStringSafe(request, ADDR_HEALTH_ADDR_CITY));
    }
    if (map.containsKey(ADDR_HEALTH_ADDR_ST_LN1)) {
      fceApplicationDB.setAddrHealthAddrStLn1(ContextHelper.getStringSafe(request, ADDR_HEALTH_ADDR_ST_LN1));
    }
    if (map.containsKey(ADDR_HEALTH_ADDR_ST_LN2)) {
      fceApplicationDB.setAddrHealthAddrStLn2(ContextHelper.getStringSafe(request, ADDR_HEALTH_ADDR_ST_LN2));
    }
    if (map.containsKey(ADDR_HEALTH_ADDR_ZIP)) {
      fceApplicationDB.setAddrHealthAddrZip(ContextHelper.getStringSafe(request, ADDR_HEALTH_ADDR_ZIP));
    }
    if (map.containsKey(ADDR_REMOVAL_ADDR_ZIP)) {
      fceApplicationDB.setAddrRemovalAddrZip(ContextHelper.getStringSafe(request, ADDR_REMOVAL_ADDR_ZIP));
    }
    if (map.containsKey(ADDR_REMOVAL_CITY)) {
      fceApplicationDB.setAddrRemovalCity(ContextHelper.getStringSafe(request, ADDR_REMOVAL_CITY));
    }
    if (map.containsKey(ADDR_REMOVAL_ST_LN1)) {
      fceApplicationDB.setAddrRemovalStLn1(ContextHelper.getStringSafe(request, ADDR_REMOVAL_ST_LN1));
    }
    if (map.containsKey(ADDR_REMOVAL_ST_LN2)) {
      fceApplicationDB.setAddrRemovalStLn2(ContextHelper.getStringSafe(request, ADDR_REMOVAL_ST_LN2));
    }
    if (map.containsKey(CD_APPLICATION)) {
      fceApplicationDB.setCdApplication(ContextHelper.getStringSafe(request, CD_APPLICATION));
    }
    if (map.containsKey(CD_COUNTY_HOSPITAL)) {
      fceApplicationDB.setCdCountyHospital(ContextHelper.getStringSafe(request, CD_COUNTY_HOSPITAL));
    }
    if (map.containsKey(CD_HEALTH_ADDR_STATE)) {
      fceApplicationDB.setCdHealthAddrState(ContextHelper.getStringSafe(request, CD_HEALTH_ADDR_STATE));
    }
    if (map.containsKey(CD_LIVING_MONTH_REMOVAL)) {
      fceApplicationDB.setCdLivingMonthRemoval(ContextHelper.getStringSafe(request, CD_LIVING_MONTH_REMOVAL));
    }
    if (map.containsKey(CD_NOTA_MOST_RECENT)) {
      fceApplicationDB.setCdNotaMostRecent(ContextHelper.getStringSafe(request, CD_NOTA_MOST_RECENT));
    }
    if (map.containsKey(CD_REMOVAL_ADDR_COUNTY)) {
      fceApplicationDB.setCdRemovalAddrCounty(ContextHelper.getStringSafe(request, CD_REMOVAL_ADDR_COUNTY));
    }
    if (map.containsKey(CD_REMOVAL_ADDR_STATE)) {
      fceApplicationDB.setCdRemovalAddrState(ContextHelper.getStringSafe(request, CD_REMOVAL_ADDR_STATE));
    }
    if (map.containsKey(CD_STATE)) {
      fceApplicationDB.setCdState(ContextHelper.getStringSafe(request, CD_STATE));
    }
    if (map.containsKey(DT_APPLICATION_COMPLETE_STRING)) {
      fceApplicationDB.setDtApplicationCompleteString(ContextHelper.getStringSafe(request,
                                                                                  DT_APPLICATION_COMPLETE_STRING));
    }
    if (map.containsKey(DT_APPLICATION_COMPLETE_TIME)) {
      fceApplicationDB.setDtApplicationCompleteTime(ContextHelper.getLongSafe(request, DT_APPLICATION_COMPLETE_TIME));
    }
    if (map.containsKey(DT_HEALTH_BEGIN_DATE_STRING)) {
      fceApplicationDB.setDtHealthBeginDateString(ContextHelper.getStringSafe(request, DT_HEALTH_BEGIN_DATE_STRING));
    }
    if (map.containsKey(DT_HEALTH_BEGIN_DATE_TIME)) {
      fceApplicationDB.setDtHealthBeginDateTime(ContextHelper.getLongSafe(request, DT_HEALTH_BEGIN_DATE_TIME));
    }
    if (map.containsKey(DT_HEALTH_END_DATE_STRING)) {
      fceApplicationDB.setDtHealthEndDateString(ContextHelper.getStringSafe(request, DT_HEALTH_END_DATE_STRING));
    }
    if (map.containsKey(DT_HEALTH_END_DATE_TIME)) {
      fceApplicationDB.setDtHealthEndDateTime(ContextHelper.getLongSafe(request, DT_HEALTH_END_DATE_TIME));
    }
    if (map.containsKey(DT_HOSPITAL_ADMISSION_STRING)) {
      fceApplicationDB.setDtHospitalAdmissionString(ContextHelper.getStringSafe(request, DT_HOSPITAL_ADMISSION_STRING));
    }
    if (map.containsKey(DT_HOSPITAL_ADMISSION_TIME)) {
      fceApplicationDB.setDtHospitalAdmissionTime(ContextHelper.getLongSafe(request, DT_HOSPITAL_ADMISSION_TIME));
    }
    if (map.containsKey(DT_HOSPITAL_DISCHARGE_STRING)) {
      fceApplicationDB.setDtHospitalDischargeString(ContextHelper.getStringSafe(request, DT_HOSPITAL_DISCHARGE_STRING));
    }
    if (map.containsKey(DT_HOSPITAL_DISCHARGE_TIME)) {
      fceApplicationDB.setDtHospitalDischargeTime(ContextHelper.getLongSafe(request, DT_HOSPITAL_DISCHARGE_TIME));
    }
    if (map.containsKey(DT_LAST_UPDATE_STRING)) {
      fceApplicationDB.setDtLastUpdateString(ContextHelper.getStringSafe(request, DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(DT_LAST_UPDATE_TIME)) {
      fceApplicationDB.setDtLastUpdateTime(ContextHelper.getLongSafe(request, DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(DT_NOTIFIED_WORKER_STRING)) {
      fceApplicationDB.setDtNotifiedWorkerString(ContextHelper.getStringSafe(request, DT_NOTIFIED_WORKER_STRING));
    }
    if (map.containsKey(DT_NOTIFIED_WORKER_TIME)) {
      fceApplicationDB.setDtNotifiedWorkerTime(ContextHelper.getLongSafe(request, DT_NOTIFIED_WORKER_TIME));
    }
    if (map.containsKey(DT_PROOF_AGE_SENT_ES_STRING)) {
      fceApplicationDB.setDtProofAgeSentEsString(ContextHelper.getStringSafe(request, DT_PROOF_AGE_SENT_ES_STRING));
    }
    if (map.containsKey(DT_PROOF_AGE_SENT_ES_TIME)) {
      fceApplicationDB.setDtProofAgeSentEsTime(ContextHelper.getLongSafe(request, DT_PROOF_AGE_SENT_ES_TIME));
    }
    if (map.containsKey(DT_PROOF_CITIZENSHIP_SENT_ES_STRING)) {
      fceApplicationDB.setDtProofCitizenshipSentEsString(ContextHelper.getStringSafe(request,
                                                                                     DT_PROOF_CITIZENSHIP_SENT_ES_STRING));
    }
    if (map.containsKey(DT_PROOF_CITIZENSHIP_SENT_ES_TIME)) {
      fceApplicationDB.setDtProofCitizenshipSentEsTime(ContextHelper.getLongSafe(request,
                                                                                 DT_PROOF_CITIZENSHIP_SENT_ES_TIME));
    }
    if (map.containsKey(DT_REMOVAL_DATE_STRING)) {
      fceApplicationDB.setDtRemovalDateString(ContextHelper.getStringSafe(request,
                                                                                     DT_REMOVAL_DATE_STRING));
    }
    if (map.containsKey(DT_REMOVAL_DATE_TIME)) {
      fceApplicationDB.setDtRemovalDateTime(ContextHelper.getLongSafe(request,
                                                                                 DT_REMOVAL_DATE_TIME));
    }
    if (map.containsKey(ID_CASE)) {
      fceApplicationDB.setIdCase(ContextHelper.getLongSafe(request, ID_CASE));
    }
    if (map.containsKey(ID_EVENT)) {
      fceApplicationDB.setIdEvent(ContextHelper.getLongSafe(request, ID_EVENT));
    }
    if (map.containsKey(ID_FCE_APPLICATION)) {
      fceApplicationDB.setIdFceApplication(ContextHelper.getLongSafe(request, ID_FCE_APPLICATION));
    }
    if (map.containsKey(ID_FCE_ELIGIBILITY)) {
      fceApplicationDB.setIdFceEligibility(ContextHelper.getLongSafe(request, ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(ID_LAST_UPDATE_PERSON)) {
      fceApplicationDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request, ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(ID_MNGNG_CVS_PERSON)) {
      fceApplicationDB.setIdMngngCvsPerson(ContextHelper.getLongSafe(request, ID_MNGNG_CVS_PERSON));
    }
    if (map.containsKey(ID_OTHER_RELATIVE_PERSON)) {
      fceApplicationDB.setIdOtherRelativePerson(ContextHelper.getLongSafe(request, ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(ID_PERSON)) {
      fceApplicationDB.setIdPerson(ContextHelper.getLongSafe(request, ID_PERSON));
    }
    if (map.containsKey(ID_STAGE)) {
      fceApplicationDB.setIdStage(ContextHelper.getLongSafe(request, ID_STAGE));
    }
    if (map.containsKey(IND_AGE_JUSTIFIED_EVAL)) {
      fceApplicationDB.setIndAgeJustifiedEval(ContextHelper.getBooleanSafe(request, IND_AGE_JUSTIFIED_EVAL));
    }
    if (map.containsKey(IND_AGE_VRFD_FOREIGN_CERT)) {
      fceApplicationDB.setIndAgeVrfdForeignCert(ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_FOREIGN_CERT));
    }
    if (map.containsKey(IND_AGE_VRFD_HOSPITAL_CERT)) {
      fceApplicationDB.setIndAgeVrfdHospitalCert(ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_HOSPITAL_CERT));
    }
    if (map.containsKey(IND_AGE_VRFD_NTRLZTN_CERT)) {
      fceApplicationDB.setIndAgeVrfdNtrlztnCert(ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_NTRLZTN_CERT));
    }
    if (map.containsKey(IND_AGE_VRFD_PASSPORT)) {
      fceApplicationDB.setIndAgeVrfdPassport(ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_PASSPORT));
    }
    if (map.containsKey(IND_AGE_VRFD_RESIDENT_CARD)) {
      fceApplicationDB.setIndAgeVrfdResidentCard(ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_RESIDENT_CARD));
    }
    if (map.containsKey(IND_AGE_VRFD_SAVE_SYSTEM)) {
          fceApplicationDB.setIndAgeVrfdSaveSystem (ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_SAVE_SYSTEM));
    }
    if (map.containsKey(IND_AGE_VRFD_SUCCESS_SYSTEM)) {
      fceApplicationDB.setIndAgeVrfdSuccessSystem (ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_SUCCESS_SYSTEM));
    }
    if (map.containsKey(IND_AGE_VRFD_US_BIRTH_CERT)) {
      fceApplicationDB.setIndAgeVrfdUsBirthCert(ContextHelper.getBooleanSafe(request, IND_AGE_VRFD_US_BIRTH_CERT));
    }
    if (map.containsKey(IND_CHILD_SUPPORT_ORDER)) {
      fceApplicationDB.setIndChildSupportOrder(ContextHelper.getBooleanSafe(request, IND_CHILD_SUPPORT_ORDER));
    }
    if (map.containsKey(IND_EVALUATION_CONCLUSION)) {
      fceApplicationDB.setIndEvaluationConclusion(ContextHelper.getBooleanSafe(request, IND_EVALUATION_CONCLUSION));
    }
    if (map.containsKey(IND_HOSPITAL)) {
      fceApplicationDB.setIndHospital(ContextHelper.getBooleanSafe(request, IND_HOSPITAL));
    }
    if (map.containsKey(IND_INCOME_ASSISTANCE)) {
      fceApplicationDB.setIndIncomeAssistance(ContextHelper.getBooleanSafe(request, IND_INCOME_ASSISTANCE));
    }
    if (map.containsKey(IND_LEGAL_DOCS_SENT_ES)) {
      fceApplicationDB.setIndLegalDocsSentEs(ContextHelper.getBooleanSafe(request, IND_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(IND_LIVING_RELATIVE_SIX_MONTH)) {
      fceApplicationDB.setIndLivingRelativeSixMonth(ContextHelper.getBooleanSafe(request,
                                                                                 IND_LIVING_RELATIVE_SIX_MONTH));
    }
    if (map.containsKey(IND_MANAGING_CVS)) {
      fceApplicationDB.setIndManagingCvs(ContextHelper.getBooleanSafe(request, IND_MANAGING_CVS));
    }
    if (map.containsKey(IND_MINOR_PARENT)) {
      fceApplicationDB.setIndMinorParent(ContextHelper.getBooleanSafe(request, IND_MINOR_PARENT));
    }
    if (map.containsKey(IND_NOTIFIED_DHS_WORKER)) {
      fceApplicationDB.setIndNotifiedDhsWorker(ContextHelper.getBooleanSafe(request, IND_NOTIFIED_DHS_WORKER));
    }
    if (map.containsKey(IND_OTHER_HEALTH_INSURANCE)) {
      fceApplicationDB.setIndOtherHealthInsurance(ContextHelper.getBooleanSafe(request, IND_OTHER_HEALTH_INSURANCE));
    }
    if (map.containsKey(IND_PROOF_AGE_SENT_ES)) {
      fceApplicationDB.setIndProofAgeSentEs(ContextHelper.getBooleanSafe(request, IND_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(IND_PROOF_CITIZENSHIP_SENT_ES)) {
      fceApplicationDB.setIndProofCitizenshipSentEs(ContextHelper.getBooleanSafe(request,
                                                                                 IND_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(NBR_COURT_MONTH)) {
      fceApplicationDB.setNbrCourtMonth(ContextHelper.getLongSafe(request, NBR_COURT_MONTH));
    }
    if (map.containsKey(NBR_COURT_YEAR)) {
      fceApplicationDB.setNbrCourtYear(ContextHelper.getLongSafe(request, NBR_COURT_YEAR));
    }
    if (map.containsKey(NBR_HEALTH_GROUP)) {
      fceApplicationDB.setNbrHealthGroup(ContextHelper.getStringSafe(request, NBR_HEALTH_GROUP));
    }
    if (map.containsKey(NBR_HEALTH_POLICY)) {
      fceApplicationDB.setNbrHealthPolicy(ContextHelper.getStringSafe(request, NBR_HEALTH_POLICY));
    }
    if (map.containsKey(NBR_LIVING_AT_HOME)) {
      fceApplicationDB.setNbrLivingAtHome(ContextHelper.getLongSafe(request, NBR_LIVING_AT_HOME));
    }
    if (map.containsKey(NBR_NOTIFIED_DHS_WRKR_PHN)) {
      fceApplicationDB.setNbrNotifiedDhsWrkrPhn(ContextHelper.getStringSafe(request, NBR_NOTIFIED_DHS_WRKR_PHN));
    }
    if (map.containsKey(NM_HEALTH_COMPANY)) {
      fceApplicationDB.setNmHealthCompany(ContextHelper.getStringSafe(request, NM_HEALTH_COMPANY));
    }
    if (map.containsKey(NM_HEALTH_EMPLOYEE_NM)) {
      fceApplicationDB.setNmHealthEmployeeNm(ContextHelper.getStringSafe(request, NM_HEALTH_EMPLOYEE_NM));
    }
    if (map.containsKey(NM_HEALTH_EMPLOYER_NM)) {
      fceApplicationDB.setNmHealthEmployerNm(ContextHelper.getStringSafe(request, NM_HEALTH_EMPLOYER_NM));
    }
    if (map.containsKey(NM_HEALTH_POLICY_HLDR_NM)) {
      fceApplicationDB.setNmHealthPolicyHldrNm(ContextHelper.getStringSafe(request, NM_HEALTH_POLICY_HLDR_NM));
    }
    if (map.containsKey(NM_HOSPITAL)) {
      fceApplicationDB.setNmHospital(ContextHelper.getStringSafe(request, NM_HOSPITAL));
    }
    if (map.containsKey(NM_HOSPITAL_CITY)) {
      fceApplicationDB.setNmHospitalCity(ContextHelper.getStringSafe(request, NM_HOSPITAL_CITY));
    }
    if (map.containsKey(NM_MOTHER_MAIDEN)) {
      fceApplicationDB.setNmMotherMaiden(ContextHelper.getStringSafe(request, NM_MOTHER_MAIDEN));
    }
    if (map.containsKey(NM_NOTIFIED_DHS_WRKR_FIRST)) {
      fceApplicationDB.setNmNotifiedDhsWrkrFirst(ContextHelper.getStringSafe(request, NM_NOTIFIED_DHS_WRKR_FIRST));
    }
    if (map.containsKey(NM_NOTIFIED_DHS_WRKR_LAST)) {
      fceApplicationDB.setNmNotifiedDhsWrkrLast(ContextHelper.getStringSafe(request, NM_NOTIFIED_DHS_WRKR_LAST));
    }
    if (map.containsKey(NM_NOTIFIED_DHS_WRKR_MIDDLE)) {
      fceApplicationDB.setNmNotifiedDhsWrkrMiddle(ContextHelper.getStringSafe(request, NM_NOTIFIED_DHS_WRKR_MIDDLE));
    }
    if (map.containsKey(TXT_INCOME_DTRMNTN_COMMENTS)) {
      fceApplicationDB.setTxtIncomeDtrmntnComments(ContextHelper.getStringSafe(request, TXT_INCOME_DTRMNTN_COMMENTS));
    }
    if (map.containsKey(TXT_LEGAL_DOCS_SENT_ES)) {
      fceApplicationDB.setTxtLegalDocsSentEs(ContextHelper.getStringSafe(request, TXT_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(TXT_MEETS_DD_OR_NOT_COMMENTS)) {
      fceApplicationDB.setTxtMeetsDdOrNotComments(ContextHelper.getStringSafe(request, TXT_MEETS_DD_OR_NOT_COMMENTS));
    }
    if (map.containsKey(TXT_NO_INCOME_EXPLANATION)) {
      fceApplicationDB.setTxtNoIncomeExplanation(ContextHelper.getStringSafe(request, TXT_NO_INCOME_EXPLANATION));
    }
    if (map.containsKey(TXT_PROOF_AGE_SENT_ES)) {
      fceApplicationDB.setTxtProofAgeSentEs(ContextHelper.getStringSafe(request, TXT_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(TXT_PROOF_CITIZENSHIP_SENT_ES)) {
      fceApplicationDB.setTxtProofCitizenshipSentEs(ContextHelper.getStringSafe(request,
                                                                                TXT_PROOF_CITIZENSHIP_SENT_ES));
    }
  }
*/

  public String toString() {
    return
            "BEGIN bean: FceApplication\n" +
            " addrHealthAddrCity: " + addrHealthAddrCity + "\n" +
            " addrHealthAddrStLn1: " + addrHealthAddrStLn1 + "\n" +
            " addrHealthAddrStLn2: " + addrHealthAddrStLn2 + "\n" +
            " addrHealthAddrZip: " + addrHealthAddrZip + "\n" +
            " addrRemovalAddrZip: " + addrRemovalAddrZip + "\n" +
            " addrRemovalCity: " + addrRemovalCity + "\n" +
            " addrRemovalStLn1: " + addrRemovalStLn1 + "\n" +
            " addrRemovalStLn2: " + addrRemovalStLn2 + "\n" +
            " cdApplication: " + cdApplication + "\n" +
            " cdCountyHospital: " + cdCountyHospital + "\n" +
            " cdHealthAddrState: " + cdHealthAddrState + "\n" +
            " cdLivingMonthRemoval: " + cdLivingMonthRemoval + "\n" +
            " cdNotaMostRecent: " + cdNotaMostRecent + "\n" +
            " cdRemovalAddrCounty: " + cdRemovalAddrCounty + "\n" +
            " cdRemovalAddrState: " + cdRemovalAddrState + "\n" +
            " cdState: " + cdState + "\n" +
            " dtApplicationComplete: " + dtApplicationComplete + "\n" +
            " dtHealthBeginDate: " + dtHealthBeginDate + "\n" +
            " dtHealthEndDate: " + dtHealthEndDate + "\n" +
            " dtHospitalAdmission: " + dtHospitalAdmission + "\n" +
            " dtHospitalDischarge: " + dtHospitalDischarge + "\n" +
            " dtLastUpdate: " + dtLastUpdate + "\n" +
            " dtNotifiedWorker: " + dtNotifiedWorker + "\n" +
            " dtProofAgeSentEs: " + dtProofAgeSentEs + "\n" +
            " dtProofCitizenshipSentEs: " + dtProofCitizenshipSentEs + "\n" +
            " dtRemovalDate: " + dtRemovalDate + "\n" +
            " idCase: " + idCase + "\n" +
            " idEvent: " + idEvent + "\n" +
            " idFceApplication: " + idFceApplication + "\n" +
            " idFceEligibility: " + idFceEligibility + "\n" +
            " idLastUpdatePerson: " + idLastUpdatePerson + "\n" +
            " idMngngCvsPerson: " + idMngngCvsPerson + "\n" +
            " idOtherRelativePerson: " + idOtherRelativePerson + "\n" +
            " idPerson: " + idPerson + "\n" +
            " idStage: " + idStage + "\n" +
            " indAgeJustifiedEval: " + indAgeJustifiedEval + "\n" +
            " indAgeVrfdBaptismCert: " + indAgeVrfdBaptismCert + "\n" +
            " indAgeVrfdForeignCert: " + indAgeVrfdForeignCert + "\n" +
            " indAgeVrfdHospitalCert: " + indAgeVrfdHospitalCert + "\n" +
            " indAgeVrfdNtrlztnCert: " + indAgeVrfdNtrlztnCert + "\n" +
            " indAgeVrfdPassport: " + indAgeVrfdPassport + "\n" +
            " indAgeVrfdResidentCard: " + indAgeVrfdResidentCard + "\n" +
            " indAgeVrfdSaveSystem: " + indAgeVrfdSaveSystem + "\n" +    
            " indAgeVrfdSuccessSystem: " + indAgeVrfdSuccessSystem + "\n" +
            " indAgeVrfdUsBirthCert: " + indAgeVrfdUsBirthCert + "\n" +
            " indAmendedApp: " + indAmendedApp + "\n" +    
            " indChildSupportOrder: " + indChildSupportOrder + "\n" +
            " indEvaluationConclusion: " + indEvaluationConclusion + "\n" +
            " indHospital: " + indHospital + "\n" +
            " indIncomeAssistance: " + indIncomeAssistance + "\n" +
            " indLegalDocsSentEs: " + indLegalDocsSentEs + "\n" +
            " indLivingRelativeSixMonth: " + indLivingRelativeSixMonth + "\n" +
            " indManagingCvs: " + indManagingCvs + "\n" +
            " indMinorParent: " + indMinorParent + "\n" +
            " indNotifiedDhsWorker: " + indNotifiedDhsWorker + "\n" +
            " indOtherHealthInsurance: " + indOtherHealthInsurance + "\n" +
            " indProofAgeSentEs: " + indProofAgeSentEs + "\n" +
            " indProofCitizenshipSentEs: " + indProofCitizenshipSentEs + "\n" +
            " indSpecifiedRelative: " + indSpecifiedRelative + "\n" +
            " nbrCourtMonth: " + nbrCourtMonth + "\n" +
            " nbrCourtYear: " + nbrCourtYear + "\n" +
            " nbrHealthGroup: " + nbrHealthGroup + "\n" +
            " nbrHealthPolicy: " + nbrHealthPolicy + "\n" +
            " nbrLivingAtHome: " + nbrLivingAtHome + "\n" +
            " nbrNotifiedDhsWrkrPhn: " + nbrNotifiedDhsWrkrPhn + "\n" +
            " nmHealthCompany: " + nmHealthCompany + "\n" +
            " nmHealthEmployeeNm: " + nmHealthEmployeeNm + "\n" +
            " nmHealthEmployerNm: " + nmHealthEmployerNm + "\n" +
            " nmHealthPolicyHldrNm: " + nmHealthPolicyHldrNm + "\n" +
            " nmHospital: " + nmHospital + "\n" +
            " nmHospitalCity: " + nmHospitalCity + "\n" +
            " nmMotherMaiden: " + nmMotherMaiden + "\n" +
            " nmNotifiedDhsWrkrFirst: " + nmNotifiedDhsWrkrFirst + "\n" +
            " nmNotifiedDhsWrkrLast: " + nmNotifiedDhsWrkrLast + "\n" +
            " nmNotifiedDhsWrkrMiddle: " + nmNotifiedDhsWrkrMiddle + "\n" +
            " txtIncomeDtrmntnComments: " + txtIncomeDtrmntnComments + "\n" +
            " txtLegalDocsSentEs: " + txtLegalDocsSentEs + "\n" +
            " txtMeetsDdOrNotComments: " + txtMeetsDdOrNotComments + "\n" +
            " txtNoIncomeExplanation: " + txtNoIncomeExplanation + "\n" +
            " txtProofAgeSentEs: " + txtProofAgeSentEs + "\n" +
            " txtProofCitizenshipSentEs: " + txtProofCitizenshipSentEs + "\n" +
            " txtPriorRemovalMonths: " + txtPriorRemovalMonths + "\n" +
            " indProofChildIdSentEs: " + indProofChildIdSentEs + "\n" +
            " dtProofChildIdSentEs: " + dtProofChildIdSentEs + "\n" +
            " txtProofChildIdSentEs: " + txtProofChildIdSentEs + "\n" +
            " indProofPregnancySentEs: " + indProofPregnancySentEs + "\n" +
            " txtProofPregnancySentEs: " + txtProofPregnancySentEs + "\n" +
            " dtProofPregnancySentEs: " + dtProofPregnancySentEs + "\n" +
            " txtEmployeeComments: " + txtEmployeeComments + "\n" +
            " dtLegalDocsSentEs: " + dtLegalDocsSentEs + "\n" +
            "END bean: FceApplication\n";
  }

  public static Boolean isTrueBoolean(String string) {
    if (string == null) {
      return null;
    }
    return new Boolean(isTrue(string));
  }

  public static boolean isTrue(String string) {
    return ((string != null) &&
            (string.equals("Y") || string.equals("1")));
  }

  /** Similar to StringHelper.isFalse, except it handles null and "1" */
  public static boolean isFalse(String string) {
    return (isTrue(string) == false);
  }

  /** true  --> "Y" false --> "N" */
  public static String toCharIndicator(boolean value) {
    if (value) {
      return "Y";
    }
    return "N";
  }

  public static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }

  //copied from PalDB
  protected static Date toDate(String string) {
    return DateHelper.toJavaDateFromInputWithDefault(string, null);
  }

  protected static String toString(Date date) {
    return FormattingHelper.formatDate(date);
  }

  protected static long toTime(Date date) {
    if (date == null) {
      return 0;
    }
    return date.getTime();
  }

  protected static Date toDate(long time) {
    if (time == 0) {
      return null;
    }
    return new Date(time);
  }
}
