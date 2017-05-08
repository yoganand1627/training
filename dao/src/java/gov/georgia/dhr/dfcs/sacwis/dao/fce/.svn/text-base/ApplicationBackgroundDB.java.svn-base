package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public class ApplicationBackgroundDB
        implements Serializable,
                   FceApplicationPageDB {
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
  public static final String CD_REL_INT = "cdRelInt";
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
  public static final String FCE_APPLICATION_DT_LAST_UPDATE_STRING = "fceApplicationDtLastUpdateString";
  public static final String FCE_APPLICATION_DT_LAST_UPDATE_TIME = "fceApplicationDtLastUpdateTime";
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
  public static final String IND_AGE_VRFD_US_BIRTH_CERT = "indAgeVrfdUsBirthCert";
  public static final String IND_AMENDED_APP = "indAmendedApp";
  public static final String IND_AGE_VRFD_SAVE_SYSTEM = "indAgeVrfdSaveSystem";
  public static final String IND_AGE_VRFD_SUCCESS_SYSTEM = "indAgeVrfdSuccessSystem";
  public static final String IND_CHILD_SUPPORT_ORDER = "indChildSupportOrder";
  public static final String IND_EVALUATION_CONCLUSION = "indEvaluationConclusion";
  public static final String IND_HOSPITAL = "indHospital";
  public static final String IND_INCOME_ASSISTANCE = "indIncomeAssistance";
  public static final String IND_LEGAL_CUSTODIAN="indLegalCustodian";
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
  public static final String TXT_EMPLOYEE_COMMENTS = "txtEmployeeComments";
  public static final String TXT_INCOME_DTRMNTN_COMMENTS = "txtIncomeDtrmntnComments";
  public static final String TXT_LEGAL_DOCS_SENT_ES = "txtLegalDocsSentEs";
  public static final String TXT_MEETS_DD_OR_NOT_COMMENTS = "txtMeetsDdOrNotComments";
  public static final String TXT_NO_INCOME_EXPLANATION = "txtNoIncomeExplanation";
  public static final String TXT_PROOF_AGE_SENT_ES = "txtProofAgeSentEs";
  public static final String TXT_PROOF_CITIZENSHIP_SENT_ES = "txtProofCitizenshipSentEs";
  public static final String TXT_PRIOR_REMOVAL_MONTHS = "txtPriorRemovalMonths";
  public static final String DT_BIRTH_STRING = "dtBirthString";
  public static final String DT_BIRTH_TIME = "dtBirthTime";
  public static final String FCE_PERSON_DT_LAST_UPDATE_STRING = "fcePersonDtLastUpdateString";
  public static final String FCE_PERSON_DT_LAST_UPDATE_TIME = "fcePersonDtLastUpdateTime";
  public static final String ID_FCE_PERSON = "idFcePerson";
  public static final String IND_CERTIFIED_GROUP = "indCertifiedGroup";
  public static final String IND_DOB_APPROX = "indDobApprox";
  public static final String IND_PERSON_HM_REMOVAL = "indPersonHmRemoval";
  public static final String NBR_AGE = "nbrAge";
  public static final String PRINCIPLES = "principles";
  public static final String PLACEMENTS = "placements";
  public static final String NM_EMPLOYEE_PERSON_FULL = "nmEmployeePersonFull";
  public static final String NM_PERSON_FULL = "nmPersonFull";
  public static final String NBR_SOCIAL_SECURITY = "nbrSocialSecurity";
  public static final String NBR_MEDICAID = "nbrMedicaid";
  public static final String NBR_CRS_ID = "nbrCrsId";
  public static final String NBR_MHN = "nbrMhn";  
  public static final String NBR_EMPLOYEE_PERSON_PHONE = "nbrEmployeePersonPhone";
  public static final String MED_APP_MONTH = "medAppMonth";
  public static final String CD_EVENT_STATUS = "cdEventStatus";
  
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
  protected boolean hasCdRelInt = false;
  protected String cdRelInt = null;
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
  protected boolean hasFceApplicationDtLastUpdate = false;
  protected Date fceApplicationDtLastUpdate = null;
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
  protected boolean hasIndAgeVrfdUsBirthCert = false;
  protected Boolean indAgeVrfdUsBirthCert = null;
  protected boolean hasIndAmendedApp = false;
  protected Boolean indAmendedApp = null;
  protected boolean hasIndAgeVrfdSaveSystem = false;
  protected Boolean indAgeVrfdSaveSystem = null;
  protected boolean hasIndAgeVrfdSuccessSystem = false;
  protected Boolean indAgeVrfdSuccessSystem = null;
  protected boolean hasIndChildSupportOrder = false;
  protected Boolean indChildSupportOrder = null;
  protected boolean hasIndEvaluationConclusion = false;
  protected Boolean indEvaluationConclusion = null;
  protected boolean hasIndHospital = false;
  protected Boolean indHospital = null;
  protected boolean hasIndIncomeAssistance = false;
  protected Boolean indIncomeAssistance = null;
  protected boolean hasIndLegalCustodian = false;
  protected Boolean indLegalCustodian = null;
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
  protected boolean hasTxtEmployeeComments;
  protected String txtEmployeeComments;
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
  protected boolean hasDtBirth = false;
  protected Date dtBirth = null;
  protected boolean hasFcePersonDtLastUpdate = false;
  protected Date fcePersonDtLastUpdate = null;
  protected boolean hasIdFcePerson = false;
  protected Long idFcePerson = null;
  protected boolean hasIndCertifiedGroup = false;
  protected Boolean indCertifiedGroup = null;
  protected boolean hasIndDobApprox = false;
  protected Boolean indDobApprox = null;
  protected boolean hasIndPersonHmRemoval = false;
  protected Boolean indPersonHmRemoval = null;
  protected boolean hasNbrAge = false;
  protected Long nbrAge = null;
  protected boolean hasPrinciples = false;
  protected List principles = null;
  protected boolean hasPlacements = false;
  protected List placements = null;
  protected boolean hasNmEmployeePersonFull;
  protected String nmEmployeePersonFull;
  protected boolean hasNmPersonFull = false;
  protected String nmPersonFull = null;
  protected boolean hasNbrEmployeePersonPhone;
  protected String nbrEmployeePersonPhone;
  protected boolean hasNbrSocialSecurity = false;
  protected String nbrSocialSecurity = null;
  protected boolean hasNbrMedicaid = false;
  protected String nbrMedicaid = null;
  protected boolean hasNbrMhn = false;
  protected String nbrMhn = null;
  protected boolean hasMedAppMonth = false;
  protected String medAppMonth = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;
  protected boolean hasNbrCrsId = false;
  protected String nbrCrsId = null;
  
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
    this.hasCdRemovalAddrCounty = true;
    this.cdRemovalAddrCounty = cdRemovalAddrCounty;
  }
  
  public boolean hasCdRelInt() {
    return hasCdRelInt;
  }

  public String getCdRelInt() {
    if (cdRelInt == null) {
      return "";
    }
    return cdRelInt;
  }

  public String getCdRelIntObject() {
    return cdRelInt;
  }

  public void setCdRelInt(String cdRelInt) {
    this.hasCdRelInt = true;
    this.cdRelInt = cdRelInt;
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

  public boolean hasFceApplicationDtLastUpdate() {
    return hasFceApplicationDtLastUpdate;
  }

  public Date getFceApplicationDtLastUpdate() {
    return fceApplicationDtLastUpdate;
  }

  public Date getFceApplicationDtLastUpdateObject() {
    return fceApplicationDtLastUpdate;
  }

  public String getFceApplicationDtLastUpdateString() {
    return toString(fceApplicationDtLastUpdate);
  }

  public long getFceApplicationDtLastUpdateTime() {
    return toTime(fceApplicationDtLastUpdate);
  }

  public void setFceApplicationDtLastUpdate(Date fceApplicationDtLastUpdate) {
    this.hasFceApplicationDtLastUpdate = true;
    if ((fceApplicationDtLastUpdate != null) &&
        (fceApplicationDtLastUpdate.getTime() == 0)) {
      fceApplicationDtLastUpdate = null;
    }
    this.fceApplicationDtLastUpdate = fceApplicationDtLastUpdate;
  }

  public void setFceApplicationDtLastUpdateString(String fceApplicationDtLastUpdateString) {
    this.hasFceApplicationDtLastUpdate = true;
    this.fceApplicationDtLastUpdate = toDate(fceApplicationDtLastUpdateString);
  }

  public void setFceApplicationDtLastUpdateTime(long fceApplicationDtLastUpdateTime) {
    this.hasFceApplicationDtLastUpdate = true;
    this.fceApplicationDtLastUpdate = toDate(fceApplicationDtLastUpdateTime);
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
    return idCase;
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
    this.idCase = idCase;
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
    return idEvent;
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
    this.idEvent = idEvent;
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
    return idFceApplication;
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
    this.idFceApplication = idFceApplication;
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
    return idFceEligibility;
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
    this.idFceEligibility = idFceEligibility;
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
    return idLastUpdatePerson;
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
    this.idLastUpdatePerson = idLastUpdatePerson;
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
    return idMngngCvsPerson;
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
    this.idMngngCvsPerson = idMngngCvsPerson;
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
    return idOtherRelativePerson;
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
    this.idOtherRelativePerson = idOtherRelativePerson;
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
    return idPerson;
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
    this.idPerson = idPerson;
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
    return idStage;
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
    this.idStage = idStage;
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
    return indAgeJustifiedEval;
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
    this.indAgeJustifiedEval = indAgeJustifiedEval;
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
    return indAgeVrfdForeignCert;
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
    this.indAgeVrfdForeignCert = indAgeVrfdForeignCert;
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
    return indAgeVrfdHospitalCert;
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
    this.indAgeVrfdHospitalCert = indAgeVrfdHospitalCert;
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
    return indAgeVrfdNtrlztnCert;
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
    this.indAgeVrfdNtrlztnCert = indAgeVrfdNtrlztnCert;
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
    return indAgeVrfdPassport;
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
    this.indAgeVrfdPassport = indAgeVrfdPassport;
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
    return indAgeVrfdResidentCard;
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
    this.indAgeVrfdResidentCard = indAgeVrfdResidentCard;
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
    return indAgeVrfdUsBirthCert;
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
    this.indAgeVrfdUsBirthCert = indAgeVrfdUsBirthCert;
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
      return "false";
    }
    return indAmendedApp.toString();
  }

  public void setIndAmendedApp(boolean indAmendedApp) {
    this.hasIndAmendedApp = true;
    this.indAmendedApp = new Boolean(indAmendedApp);
  }

  public void setIndAmendedApp(Boolean indAmendedApp) {
    this.hasIndAmendedApp = true;
    
    if (indAmendedApp == null) {
      this.indAmendedApp = false;
    }else{
      this.indAmendedApp = indAmendedApp;
    }
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
    return indChildSupportOrder;
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
    this.indChildSupportOrder = indChildSupportOrder;
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
    return indEvaluationConclusion;
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
    this.indEvaluationConclusion = indEvaluationConclusion;
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
    return indHospital;
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
    this.indHospital = indHospital;
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
    return indIncomeAssistance;
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
    this.indIncomeAssistance = indIncomeAssistance;
  }

  public void setIndIncomeAssistance(Boolean indIncomeAssistance) {
    this.hasIndIncomeAssistance = true;
    this.indIncomeAssistance = indIncomeAssistance;
  }

  public void setIndIncomeAssistance(String indIncomeAssistance) {
    this.hasIndIncomeAssistance = true;
    this.indIncomeAssistance = isTrueBoolean(indIncomeAssistance);
  }
  public boolean hasIndLegalCustodian() {
    return hasIndLegalCustodian;
  }
  
  public boolean getIndLegalCustodian() {
    if (indLegalCustodian == null) {
      return false;
    }
    return indLegalCustodian;
  }

  public Boolean getIndLegalCustodianObject() {
    return indLegalCustodian;
  }

  public String getIndLegalCustodianString() {
    if (indLegalCustodian == null) {
      return "";
    }
    return indLegalCustodian.toString();
  }
  public void setIndLegalCustodian(boolean indLegalCustodian) {
    this.hasIndLegalCustodian = true;
    this.indLegalCustodian = indLegalCustodian;
  }

  public void setIndLegalCustodian(Boolean indLegalCustodian) {
    this.hasIndLegalCustodian = true;
    this.indLegalCustodian = indLegalCustodian;
  }

  public void setIndLegalCustodian(String indLegalCustodian) {
    this.hasIndLegalCustodian = true;
    this.indLegalCustodian = isTrueBoolean(indLegalCustodian);
  }

  public boolean hasIndLegalDocsSentEs() {
    return hasIndLegalDocsSentEs;
  }

  public boolean getIndLegalDocsSentEs() {
    if (indLegalDocsSentEs == null) {
      return false;
    }
    return indLegalDocsSentEs;
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
    this.indLegalDocsSentEs = indLegalDocsSentEs;
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
    return indLivingRelativeSixMonth;
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
    this.indLivingRelativeSixMonth = indLivingRelativeSixMonth;
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
    return indManagingCvs;
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
    this.indManagingCvs = indManagingCvs;
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
    return indMinorParent;
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
    this.indMinorParent = indMinorParent;
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
    return indNotifiedDhsWorker;
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
    this.indNotifiedDhsWorker = indNotifiedDhsWorker;
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
    return indOtherHealthInsurance;
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
    this.indOtherHealthInsurance = indOtherHealthInsurance;
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
    return indProofAgeSentEs;
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
    this.indProofAgeSentEs = indProofAgeSentEs;
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
    return indProofCitizenshipSentEs;
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
    this.indProofCitizenshipSentEs = indProofCitizenshipSentEs;
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
    return nbrCourtMonth;
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
    this.nbrCourtMonth = nbrCourtMonth;
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
    return nbrCourtYear;
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
    this.nbrCourtYear = nbrCourtYear;
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
    return nbrLivingAtHome;
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
    this.nbrLivingAtHome = nbrLivingAtHome;
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
  
  //// added by srini need to be removed if page starts working

  /**
 * 
 * Follwoing four methods are added by srini to generate indLegalCustodian value 
 */  
  
 
  
   
  
   
  
  public boolean hasDtBirth() {
    return hasDtBirth;
  }

  public Date getDtBirth() {
    return dtBirth;
  }

  public Date getDtBirthObject() {
    return dtBirth;
  }

  public String getDtBirthString() {
    return toString(dtBirth);
  }

  public long getDtBirthTime() {
    return toTime(dtBirth);
  }

  public void setDtBirth(Date dtBirth) {
    this.hasDtBirth = true;
    if ((dtBirth != null) &&
        (dtBirth.getTime() == 0)) {
      dtBirth = null;
    }
    this.dtBirth = dtBirth;
  }

  public void setDtBirthString(String dtBirthString) {
    this.hasDtBirth = true;
    this.dtBirth = toDate(dtBirthString);
  }

  public void setDtBirthTime(long dtBirthTime) {
    this.hasDtBirth = true;
    this.dtBirth = toDate(dtBirthTime);
  }

  public boolean hasFcePersonDtLastUpdate() {
    return hasFcePersonDtLastUpdate;
  }

  public Date getFcePersonDtLastUpdate() {
    return fcePersonDtLastUpdate;
  }

  public Date getFcePersonDtLastUpdateObject() {
    return fcePersonDtLastUpdate;
  }

  public String getFcePersonDtLastUpdateString() {
    return toString(fcePersonDtLastUpdate);
  }

  public long getFcePersonDtLastUpdateTime() {
    return toTime(fcePersonDtLastUpdate);
  }

  public void setFcePersonDtLastUpdate(Date fcePersonDtLastUpdate) {
    this.hasFcePersonDtLastUpdate = true;
    if ((fcePersonDtLastUpdate != null) &&
        (fcePersonDtLastUpdate.getTime() == 0)) {
      fcePersonDtLastUpdate = null;
    }
    this.fcePersonDtLastUpdate = fcePersonDtLastUpdate;
  }

  public void setFcePersonDtLastUpdateString(String fcePersonDtLastUpdateString) {
    this.hasFcePersonDtLastUpdate = true;
    this.fcePersonDtLastUpdate = toDate(fcePersonDtLastUpdateString);
  }

  public void setFcePersonDtLastUpdateTime(long fcePersonDtLastUpdateTime) {
    this.hasFcePersonDtLastUpdate = true;
    this.fcePersonDtLastUpdate = toDate(fcePersonDtLastUpdateTime);
  }

  public boolean hasIdFcePerson() {
    return hasIdFcePerson;
  }

  public long getIdFcePerson() {
    if (idFcePerson == null) {
      return (long) 0;
    }
    return idFcePerson;
  }

  public Long getIdFcePersonObject() {
    return idFcePerson;
  }

  public String getIdFcePersonString() {
    return FormattingHelper.formatLong(idFcePerson);
  }

  public void setIdFcePerson(long idFcePerson) {
    this.hasIdFcePerson = true;
    if (idFcePerson == 0) {
      this.idFcePerson = null;
      return;
    }
    this.idFcePerson = idFcePerson;
  }

  public void setIdFcePerson(Long idFcePerson) {
    this.hasIdFcePerson = true;
    this.idFcePerson = idFcePerson;
  }

  public void setIdFcePerson(Number idFcePerson) {
    this.hasIdFcePerson = true;
    this.idFcePerson = null;
    if (idFcePerson != null) {
      setIdFcePerson(idFcePerson.longValue());
    }
  }

  public boolean hasIndCertifiedGroup() {
    return hasIndCertifiedGroup;
  }

  public boolean getIndCertifiedGroup() {
    if (indCertifiedGroup == null) {
      return false;
    }
    return indCertifiedGroup;
  }

  public Boolean getIndCertifiedGroupObject() {
    return indCertifiedGroup;
  }

  public String getIndCertifiedGroupString() {
    if (indCertifiedGroup == null) {
      return "";
    }
    return indCertifiedGroup.toString();
  }

  public void setIndCertifiedGroup(boolean indCertifiedGroup) {
    this.hasIndCertifiedGroup = true;
    this.indCertifiedGroup = indCertifiedGroup;
  }

  public void setIndCertifiedGroup(Boolean indCertifiedGroup) {
    this.hasIndCertifiedGroup = true;
    this.indCertifiedGroup = indCertifiedGroup;
  }

  public void setIndCertifiedGroup(String indCertifiedGroup) {
    this.hasIndCertifiedGroup = true;
    this.indCertifiedGroup = isTrueBoolean(indCertifiedGroup);
  }

  public boolean hasIndDobApprox() {
    return hasIndDobApprox;
  }

  public boolean getIndDobApprox() {
    if (indDobApprox == null) {
      return false;
    }
    return indDobApprox;
  }

  public Boolean getIndDobApproxObject() {
    return indDobApprox;
  }

  public String getIndDobApproxString() {
    if (indDobApprox == null) {
      return "";
    }
    return indDobApprox.toString();
  }

  public void setIndDobApprox(boolean indDobApprox) {
    this.hasIndDobApprox = true;
    this.indDobApprox = indDobApprox;
  }

  public void setIndDobApprox(Boolean indDobApprox) {
    this.hasIndDobApprox = true;
    this.indDobApprox = indDobApprox;
  }

  public void setIndDobApprox(String indDobApprox) {
    this.hasIndDobApprox = true;
    this.indDobApprox = isTrueBoolean(indDobApprox);
  }

  public boolean hasIndPersonHmRemoval() {
    return hasIndPersonHmRemoval;
  }

  public boolean getIndPersonHmRemoval() {
    if (indPersonHmRemoval == null) {
      return false;
    }
    return indPersonHmRemoval;
  }

  public Boolean getIndPersonHmRemovalObject() {
    return indPersonHmRemoval;
  }

  public String getIndPersonHmRemovalString() {
    if (indPersonHmRemoval == null) {
      return "";
    }
    return indPersonHmRemoval.toString();
  }

  public void setIndPersonHmRemoval(boolean indPersonHmRemoval) {
    this.hasIndPersonHmRemoval = true;
    this.indPersonHmRemoval = indPersonHmRemoval;
  }

  public void setIndPersonHmRemoval(Boolean indPersonHmRemoval) {
    this.hasIndPersonHmRemoval = true;
    this.indPersonHmRemoval = indPersonHmRemoval;
  }

  public void setIndPersonHmRemoval(String indPersonHmRemoval) {
    this.hasIndPersonHmRemoval = true;
    this.indPersonHmRemoval = isTrueBoolean(indPersonHmRemoval);
  }

  public boolean hasNbrAge() {
    return hasNbrAge;
  }

  public long getNbrAge() {
    if (nbrAge == null) {
      return (long) 0;
    }
    return nbrAge;
  }

  public Long getNbrAgeObject() {
    return nbrAge;
  }

  public String getNbrAgeString() {
    return FormattingHelper.formatLong(nbrAge);
  }

  public void setNbrAge(long nbrAge) {
    this.hasNbrAge = true;
    if (nbrAge == 0) {
      this.nbrAge = null;
      return;
    }
    this.nbrAge = nbrAge;
  }

  public void setNbrAge(Long nbrAge) {
    this.hasNbrAge = true;
    this.nbrAge = nbrAge;
  }

  public void setNbrAge(Number nbrAge) {
    this.hasNbrAge = true;
    this.nbrAge = null;
    if (nbrAge != null) {
      setNbrAge(nbrAge.longValue());
    }
    
  }
   

  public List getPrinciples() {
    return principles;
  }

  public void setPrinciples(List principles) {
    this.hasPrinciples = true;
    this.principles = principles;
  }

  public List getPlacements() {
    return placements;
  }

  public void setPlacements(List placements) {
    this.hasPlacements = true;
    this.placements = placements;
  }

  public boolean hasNmEmployeePersonFull() {
    return hasNmEmployeePersonFull;
  }

  public String getNmEmployeePersonFull() {
    if (nmEmployeePersonFull == null) {
      return "";
    }
    return nmEmployeePersonFull;
  }

  public String getNmEmployeePersonFullObject() {
    return nmEmployeePersonFull;
  }

  public void setNmEmployeePersonFull(String nmEmployeePersonFull) {
    this.hasNmEmployeePersonFull = true;
    this.nmEmployeePersonFull = nmEmployeePersonFull;
  }

  public boolean hasNmPersonFull() {
    return hasNmPersonFull;
  }

  public String getNmPersonFull() {
    if (nmPersonFull == null) {
      return "";
    }
    return nmPersonFull;
  }

  public String getNmPersonFullObject() {
    return nmPersonFull;
  }

  public void setNmPersonFull(String nmPersonFull) {
    this.hasNmPersonFull = true;
    this.nmPersonFull = nmPersonFull;
  }

  public boolean hasNbrSocialSecurity() {
    return hasNbrSocialSecurity;
  }

  public String getNbrSocialSecurity() {
    if (nbrSocialSecurity == null) {
      return "";
    }
    return nbrSocialSecurity;
  }

  public String getNbrSocialSecurityObject() {
    return nbrSocialSecurity;
  }

  public void setNbrSocialSecurity(String nbrSocialSecurity) {
    this.hasNbrSocialSecurity = true;
    this.nbrSocialSecurity = nbrSocialSecurity;
  }

  public boolean hasNbrMedicaid() {
    return hasNbrMedicaid;
  }

  public String getNbrMedicaid() {
    if (nbrMedicaid == null) {
      return "";
    }
    return nbrMedicaid;
  }

  public String getNbrMedicaidObject() {
    return nbrMedicaid;
  }

  public void setNbrMedicaid(String nbrMedicaid) {
    this.hasNbrMedicaid = true;
    this.nbrMedicaid = nbrMedicaid;
  }

  public boolean hasNbrMhn() {
    return hasNbrMhn;
  }
  
  public String getNbrMhn() {
    if (nbrMhn == null) {
      return "";
    }
    return nbrMhn;
  }
  public String getNbrMhnObject() {
    return nbrMhn;
  }
  public void setNbrMhn(String nbrMhn) {
    this.hasNbrMhn = true;
    this.nbrMhn = nbrMhn;
  }
  
  public boolean hasMedAppMonth() {
    return hasMedAppMonth;
  }
  public String getMedAppMonth() {
    if (medAppMonth == null) {
      return "";
    }
    return medAppMonth;
  }
  public String getMedAppMonthObject() {
    return medAppMonth;
  }
  public void setMedAppMonth(String medAppMonth) {
    this.hasMedAppMonth = true;
    this.medAppMonth = medAppMonth;
  }
  public boolean hasCdEventStatus() {
    return hasCdEventStatus;
  }

  public String getCdEventStatus() {
    if (cdEventStatus == null) {
      return "";
    }
    return cdEventStatus;
  }

  public String getCdEventStatusObject() {
    return cdEventStatus;
  }

  public void setCdEventStatus(String cdEventStatus) {
    this.hasCdEventStatus = true;
    this.cdEventStatus = cdEventStatus;
  }
  
  public boolean hasNbrCrsId() {
    return hasNbrCrsId;
  }

  public String getNbrCrsId() {
    if (nbrCrsId == null) {
      return "";
    }
    return nbrCrsId;
  }

  public String getNbrCrsIdObject() {
    return nbrCrsId;
  }

  public void setNbrCrsId(String nbrCrsId) {
    this.hasNbrCrsId = true;
    this.nbrCrsId = nbrCrsId;
  }

  public boolean hasNbrEmployeePersonPhone() {
    return hasNbrEmployeePersonPhone;
  }

  public String getNbrEmployeePersonPhone() {
    if (nbrEmployeePersonPhone == null) {
      return "";
    }
    return nbrEmployeePersonPhone;
  }

  public String getNbrEmployeePersonPhoneObject() {
    return nbrEmployeePersonPhone;
  }

  public void setNbrEmployeePersonPhone(String nbrEmployeePersonPhone) {
    this.hasNbrEmployeePersonPhone = true;
    this.nbrEmployeePersonPhone = nbrEmployeePersonPhone;
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

  public void copyInto(ApplicationBackgroundDB applicationBackgroundDB) {
    if (hasAddrHealthAddrCity) {
      applicationBackgroundDB.setAddrHealthAddrCity(addrHealthAddrCity);
    }
    if (hasAddrHealthAddrStLn1) {
      applicationBackgroundDB.setAddrHealthAddrStLn1(addrHealthAddrStLn1);
    }
    if (hasAddrHealthAddrStLn2) {
      applicationBackgroundDB.setAddrHealthAddrStLn2(addrHealthAddrStLn2);
    }
    if (hasAddrHealthAddrZip) {
      applicationBackgroundDB.setAddrHealthAddrZip(addrHealthAddrZip);
    }
    if (hasAddrRemovalAddrZip) {
      applicationBackgroundDB.setAddrRemovalAddrZip(addrRemovalAddrZip);
    }
    if (hasAddrRemovalCity) {
      applicationBackgroundDB.setAddrRemovalCity(addrRemovalCity);
    }
    if (hasAddrRemovalStLn1) {
      applicationBackgroundDB.setAddrRemovalStLn1(addrRemovalStLn1);
    }
    if (hasAddrRemovalStLn2) {
      applicationBackgroundDB.setAddrRemovalStLn2(addrRemovalStLn2);
    }
    if (hasCdApplication) {
      applicationBackgroundDB.setCdApplication(cdApplication);
    }
    if (hasCdCountyHospital) {
      applicationBackgroundDB.setCdCountyHospital(cdCountyHospital);
    }
    if (hasCdHealthAddrState) {
      applicationBackgroundDB.setCdHealthAddrState(cdHealthAddrState);
    }
    if (hasCdLivingMonthRemoval) {
      applicationBackgroundDB.setCdLivingMonthRemoval(cdLivingMonthRemoval);
    }
    if (hasCdNotaMostRecent) {
      applicationBackgroundDB.setCdNotaMostRecent(cdNotaMostRecent);
    }
    if (hasCdRelInt) {
      applicationBackgroundDB.setCdRelInt(cdRelInt);
    }
    if (hasCdRemovalAddrCounty) {
      applicationBackgroundDB.setCdRemovalAddrCounty(cdRemovalAddrCounty);
    }
    if (hasCdRemovalAddrState) {
      applicationBackgroundDB.setCdRemovalAddrState(cdRemovalAddrState);
    }
    if (hasCdState) {
      applicationBackgroundDB.setCdState(cdState);
    }
  if (hasDtApplicationComplete) {
      applicationBackgroundDB.setDtApplicationComplete(dtApplicationComplete);
    }
    if (hasDtHealthBeginDate) {
      applicationBackgroundDB.setDtHealthBeginDate(dtHealthBeginDate);
    }
    if (hasDtHealthEndDate) {
      applicationBackgroundDB.setDtHealthEndDate(dtHealthEndDate);
    }
    if (hasDtHospitalAdmission) {
      applicationBackgroundDB.setDtHospitalAdmission(dtHospitalAdmission);
    }
    if (hasDtHospitalDischarge) {
      applicationBackgroundDB.setDtHospitalDischarge(dtHospitalDischarge);
    }
    if (hasMedAppMonth) {
      applicationBackgroundDB.setMedAppMonth(medAppMonth);
    }
    if (hasFceApplicationDtLastUpdate) {
      applicationBackgroundDB.setFceApplicationDtLastUpdate(fceApplicationDtLastUpdate);
    }
    if (hasDtNotifiedWorker) {
      applicationBackgroundDB.setDtNotifiedWorker(dtNotifiedWorker);
    }
    if (hasDtProofAgeSentEs) {
      applicationBackgroundDB.setDtProofAgeSentEs(dtProofAgeSentEs);
    }
    if (hasDtProofCitizenshipSentEs) {
      applicationBackgroundDB.setDtProofCitizenshipSentEs(dtProofCitizenshipSentEs);
    }
    if (hasDtRemovalDate) {
      applicationBackgroundDB.setDtRemovalDate(dtRemovalDate);
    }
    if (hasIdCase) {
      applicationBackgroundDB.setIdCase(idCase);
    }
    if (hasIdEvent) {
      applicationBackgroundDB.setIdEvent(idEvent);
    }
    if (hasIdFceApplication) {
      applicationBackgroundDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      applicationBackgroundDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdLastUpdatePerson) {
      applicationBackgroundDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdMngngCvsPerson) {
      applicationBackgroundDB.setIdMngngCvsPerson(idMngngCvsPerson);
    }
    if (hasIdOtherRelativePerson) {
      applicationBackgroundDB.setIdOtherRelativePerson(idOtherRelativePerson);
    }
    if (hasIdPerson) {
      applicationBackgroundDB.setIdPerson(idPerson);
    }
    if (hasIdStage) {
      applicationBackgroundDB.setIdStage(idStage);
    }
    if (hasIndAgeJustifiedEval) {
      applicationBackgroundDB.setIndAgeJustifiedEval(indAgeJustifiedEval);
    }
    if (hasIndAgeVrfdForeignCert) {
      applicationBackgroundDB.setIndAgeVrfdForeignCert(indAgeVrfdForeignCert);
    }
    if (hasIndAgeVrfdHospitalCert) {
      applicationBackgroundDB.setIndAgeVrfdHospitalCert(indAgeVrfdHospitalCert);
    }
    if (hasIndAgeVrfdNtrlztnCert) {
      applicationBackgroundDB.setIndAgeVrfdNtrlztnCert(indAgeVrfdNtrlztnCert);
    }
    if (hasIndAgeVrfdPassport) {
      applicationBackgroundDB.setIndAgeVrfdPassport(indAgeVrfdPassport);
    }
    if (hasIndAgeVrfdResidentCard) {
      applicationBackgroundDB.setIndAgeVrfdResidentCard(indAgeVrfdResidentCard);
    }
    if (hasIndAgeVrfdSaveSystem) {
      applicationBackgroundDB.setIndAgeVrfdSaveSystem(indAgeVrfdSaveSystem);
    }
    if (hasIndAgeVrfdSuccessSystem) {
      applicationBackgroundDB.setIndAgeVrfdSuccessSystem(indAgeVrfdSuccessSystem);
    }
    if (hasIndAgeVrfdUsBirthCert) {
      applicationBackgroundDB.setIndAgeVrfdUsBirthCert(indAgeVrfdUsBirthCert);
    }
    if (hasIndAgeVrfdUsBirthCert) {
      applicationBackgroundDB.setIndAgeVrfdUsBirthCert(indAgeVrfdUsBirthCert);
    }
    if (hasIndChildSupportOrder) {
      applicationBackgroundDB.setIndChildSupportOrder(indChildSupportOrder);
    }
    if (hasIndEvaluationConclusion) {
      applicationBackgroundDB.setIndEvaluationConclusion(indEvaluationConclusion);
    }
    if (hasIndHospital) {
      applicationBackgroundDB.setIndHospital(indHospital);
    }
    if (hasIndIncomeAssistance) {
      applicationBackgroundDB.setIndIncomeAssistance(indIncomeAssistance);
    }
    if (hasIndLegalCustodian) {
      applicationBackgroundDB.setIndLegalCustodian(indLegalCustodian);
    }
    if (hasIndLegalDocsSentEs) {
      applicationBackgroundDB.setIndLegalDocsSentEs(indLegalDocsSentEs);
    }
    if (hasIndLivingRelativeSixMonth) {
      applicationBackgroundDB.setIndLivingRelativeSixMonth(indLivingRelativeSixMonth);
    }
    if (hasIndManagingCvs) {
      applicationBackgroundDB.setIndManagingCvs(indManagingCvs);
    }
    if (hasIndMinorParent) {
      applicationBackgroundDB.setIndMinorParent(indMinorParent);
    }
    if (hasIndNotifiedDhsWorker) {
      applicationBackgroundDB.setIndNotifiedDhsWorker(indNotifiedDhsWorker);
    }
    if (hasIndOtherHealthInsurance) {
      applicationBackgroundDB.setIndOtherHealthInsurance(indOtherHealthInsurance);
    }
    if (hasIndProofAgeSentEs) {
      applicationBackgroundDB.setIndProofAgeSentEs(indProofAgeSentEs);
    }
    if (hasIndProofCitizenshipSentEs) {
      applicationBackgroundDB.setIndProofCitizenshipSentEs(indProofCitizenshipSentEs);
    }
    if (hasIndSpecifiedRelative) {
      applicationBackgroundDB.setIndSpecifiedRelative(indSpecifiedRelative);
    }
    if (hasNbrCourtMonth) {
      applicationBackgroundDB.setNbrCourtMonth(nbrCourtMonth);
    }
    if (hasNbrCourtYear) {
      applicationBackgroundDB.setNbrCourtYear(nbrCourtYear);
    }
    if (hasNbrHealthGroup) {
      applicationBackgroundDB.setNbrHealthGroup(nbrHealthGroup);
    }
    if (hasNbrHealthPolicy) {
      applicationBackgroundDB.setNbrHealthPolicy(nbrHealthPolicy);
    }
    if (hasNbrLivingAtHome) {
      applicationBackgroundDB.setNbrLivingAtHome(nbrLivingAtHome);
    }
    if (hasNbrNotifiedDhsWrkrPhn) {
      applicationBackgroundDB.setNbrNotifiedDhsWrkrPhn(nbrNotifiedDhsWrkrPhn);
    }
    if (hasNmHealthCompany) {
      applicationBackgroundDB.setNmHealthCompany(nmHealthCompany);
    }
    if (hasNmHealthEmployeeNm) {
      applicationBackgroundDB.setNmHealthEmployeeNm(nmHealthEmployeeNm);
    }
    if (hasNmHealthEmployerNm) {
      applicationBackgroundDB.setNmHealthEmployerNm(nmHealthEmployerNm);
    }
    if (hasNmHealthPolicyHldrNm) {
      applicationBackgroundDB.setNmHealthPolicyHldrNm(nmHealthPolicyHldrNm);
    }
    if (hasNmHospital) {
      applicationBackgroundDB.setNmHospital(nmHospital);
    }
    if (hasNmHospitalCity) {
      applicationBackgroundDB.setNmHospitalCity(nmHospitalCity);
    }
    if (hasNmMotherMaiden) {
      applicationBackgroundDB.setNmMotherMaiden(nmMotherMaiden);
    }
    if (hasNmNotifiedDhsWrkrFirst) {
      applicationBackgroundDB.setNmNotifiedDhsWrkrFirst(nmNotifiedDhsWrkrFirst);
    }
    if (hasNmNotifiedDhsWrkrLast) {
      applicationBackgroundDB.setNmNotifiedDhsWrkrLast(nmNotifiedDhsWrkrLast);
    }
    if (hasNmNotifiedDhsWrkrMiddle) {
      applicationBackgroundDB.setNmNotifiedDhsWrkrMiddle(nmNotifiedDhsWrkrMiddle);
    }
    if (hasTxtEmployeeComments) {
      applicationBackgroundDB.setTxtEmployeeComments(txtEmployeeComments);
    }
    if (hasTxtIncomeDtrmntnComments) {
      applicationBackgroundDB.setTxtIncomeDtrmntnComments(txtIncomeDtrmntnComments);
    }
    if (hasTxtLegalDocsSentEs) {
      applicationBackgroundDB.setTxtLegalDocsSentEs(txtLegalDocsSentEs);
    }
    if (hasTxtMeetsDdOrNotComments) {
      applicationBackgroundDB.setTxtMeetsDdOrNotComments(txtMeetsDdOrNotComments);
    }
    if (hasTxtNoIncomeExplanation) {
      applicationBackgroundDB.setTxtNoIncomeExplanation(txtNoIncomeExplanation);
    }
    if (hasTxtProofAgeSentEs) {
      applicationBackgroundDB.setTxtProofAgeSentEs(txtProofAgeSentEs);
    }
    if (hasTxtProofCitizenshipSentEs) {
      applicationBackgroundDB.setTxtProofCitizenshipSentEs(txtProofCitizenshipSentEs);
    }
    // added by srini need to be removed once page stareted working
    if (hasTxtPriorRemovalMonths) {
      applicationBackgroundDB.setTxtPriorRemovalMonths(txtPriorRemovalMonths);
    }
    
   
    
    if (hasDtBirth) {
      applicationBackgroundDB.setDtBirth(dtBirth);
    }
    if (hasFcePersonDtLastUpdate) {
      applicationBackgroundDB.setFcePersonDtLastUpdate(fcePersonDtLastUpdate);
    }
    if (hasIdFcePerson) {
      applicationBackgroundDB.setIdFcePerson(idFcePerson);
    }
    if (hasIndCertifiedGroup) {
      applicationBackgroundDB.setIndCertifiedGroup(indCertifiedGroup);
    }
    if (hasIndDobApprox) {
      applicationBackgroundDB.setIndDobApprox(indDobApprox);
    }
    if (hasIndPersonHmRemoval) {
      applicationBackgroundDB.setIndPersonHmRemoval(indPersonHmRemoval);
    }
    if (hasNbrAge) {
      applicationBackgroundDB.setNbrAge(nbrAge);
    }
    
    if (hasPrinciples) {
      applicationBackgroundDB.setPrinciples(principles);
    }
    if (hasPlacements) {
      applicationBackgroundDB.setPlacements(placements);
    }
    if (hasNmEmployeePersonFull) {
      applicationBackgroundDB.setNmEmployeePersonFull(nmEmployeePersonFull);
    }
    if (hasNmPersonFull) {
      applicationBackgroundDB.setNmPersonFull(nmPersonFull);
    }
    if (hasNbrSocialSecurity) {
      applicationBackgroundDB.setNbrSocialSecurity(nbrSocialSecurity);
    }
    if (hasNbrMedicaid) {
      applicationBackgroundDB.setNbrMedicaid(nbrMedicaid);
    }
    if (hasNbrMhn) {
      applicationBackgroundDB.setNbrMhn(nbrMhn);
    }
    if (hasCdEventStatus) {
      applicationBackgroundDB.setCdEventStatus(cdEventStatus);
    }
    if (hasNbrCrsId) {
      applicationBackgroundDB.setNbrCrsId(nbrCrsId);
    }
    if (hasNbrEmployeePersonPhone) {
      applicationBackgroundDB.setNbrEmployeePersonPhone(nbrEmployeePersonPhone);
    }
  }

  public FceApplicationDB getFceApplication() {
    FceApplicationDB fceApplicationDB = new FceApplicationDB();
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
    if (hasFceApplicationDtLastUpdate) {
      fceApplicationDB.setDtLastUpdate(fceApplicationDtLastUpdate);
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
    if (hasTxtEmployeeComments) {
      fceApplicationDB.setTxtEmployeeComments(txtEmployeeComments);
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
    if (hasTxtPriorRemovalMonths) {
      fceApplicationDB.setTxtPriorRemovalMonths(txtPriorRemovalMonths);
    }
    return fceApplicationDB;
  }

  public void setFceApplication(FceApplicationDB fceApplicationDB) {
    if (fceApplicationDB.hasAddrHealthAddrCity()) {
      setAddrHealthAddrCity(fceApplicationDB.getAddrHealthAddrCityObject());
    }
    if (fceApplicationDB.hasAddrHealthAddrStLn1()) {
      setAddrHealthAddrStLn1(fceApplicationDB.getAddrHealthAddrStLn1Object());
    }
    if (fceApplicationDB.hasAddrHealthAddrStLn2()) {
      setAddrHealthAddrStLn2(fceApplicationDB.getAddrHealthAddrStLn2Object());
    }
    if (fceApplicationDB.hasAddrHealthAddrZip()) {
      setAddrHealthAddrZip(fceApplicationDB.getAddrHealthAddrZipObject());
    }
    if (fceApplicationDB.hasAddrRemovalAddrZip()) {
      setAddrRemovalAddrZip(fceApplicationDB.getAddrRemovalAddrZipObject());
    }
    if (fceApplicationDB.hasAddrRemovalCity()) {
      setAddrRemovalCity(fceApplicationDB.getAddrRemovalCityObject());
    }
    if (fceApplicationDB.hasAddrRemovalStLn1()) {
      setAddrRemovalStLn1(fceApplicationDB.getAddrRemovalStLn1Object());
    }
    if (fceApplicationDB.hasAddrRemovalStLn2()) {
      setAddrRemovalStLn2(fceApplicationDB.getAddrRemovalStLn2Object());
    }
    if (fceApplicationDB.hasCdApplication()) {
      setCdApplication(fceApplicationDB.getCdApplicationObject());
    }
    if (fceApplicationDB.hasCdCountyHospital()) {
      setCdCountyHospital(fceApplicationDB.getCdCountyHospitalObject());
    }
    if (fceApplicationDB.hasCdHealthAddrState()) {
      setCdHealthAddrState(fceApplicationDB.getCdHealthAddrStateObject());
    }
    if (fceApplicationDB.hasCdLivingMonthRemoval()) {
      setCdLivingMonthRemoval(fceApplicationDB.getCdLivingMonthRemovalObject());
    }
    if (fceApplicationDB.hasCdNotaMostRecent()) {
      setCdNotaMostRecent(fceApplicationDB.getCdNotaMostRecentObject());
    }
    if (fceApplicationDB.hasCdRemovalAddrCounty()) {
      setCdRemovalAddrCounty(fceApplicationDB.getCdRemovalAddrCountyObject());
    }
    if (fceApplicationDB.hasCdRemovalAddrState()) {
      setCdRemovalAddrState(fceApplicationDB.getCdRemovalAddrStateObject());
    }
    if (fceApplicationDB.hasCdState()) {
      setCdState(fceApplicationDB.getCdStateObject());
    }
    if (fceApplicationDB.hasDtApplicationComplete()) {
      setDtApplicationComplete(fceApplicationDB.getDtApplicationCompleteObject());
    }
    if (fceApplicationDB.hasDtHealthBeginDate()) {
      setDtHealthBeginDate(fceApplicationDB.getDtHealthBeginDateObject());
    }
    if (fceApplicationDB.hasDtHealthEndDate()) {
      setDtHealthEndDate(fceApplicationDB.getDtHealthEndDateObject());
    }
    if (fceApplicationDB.hasDtHospitalAdmission()) {
      setDtHospitalAdmission(fceApplicationDB.getDtHospitalAdmissionObject());
    }
    if (fceApplicationDB.hasDtHospitalDischarge()) {
      setDtHospitalDischarge(fceApplicationDB.getDtHospitalDischargeObject());
    }
    if (fceApplicationDB.hasDtLastUpdate()) {
      setFceApplicationDtLastUpdate(fceApplicationDB.getDtLastUpdateObject());
    }
    if (fceApplicationDB.hasDtNotifiedWorker()) {
      setDtNotifiedWorker(fceApplicationDB.getDtNotifiedWorkerObject());
    }
    if (fceApplicationDB.hasDtProofAgeSentEs()) {
      setDtProofAgeSentEs(fceApplicationDB.getDtProofAgeSentEsObject());
    }
    if (fceApplicationDB.hasDtProofCitizenshipSentEs()) {
      setDtProofCitizenshipSentEs(fceApplicationDB.getDtProofCitizenshipSentEsObject());
    }
    if (fceApplicationDB.hasDtRemovalDate()) {
      setDtRemovalDate(fceApplicationDB.getDtRemovalDate());
    }
    if (fceApplicationDB.hasIdCase()) {
      setIdCase(fceApplicationDB.getIdCaseObject());
    }
    if (fceApplicationDB.hasIdEvent()) {
      setIdEvent(fceApplicationDB.getIdEventObject());
    }
    if (fceApplicationDB.hasIdFceApplication()) {
      setIdFceApplication(fceApplicationDB.getIdFceApplicationObject());
    }
    if (fceApplicationDB.hasIdFceEligibility()) {
      setIdFceEligibility(fceApplicationDB.getIdFceEligibilityObject());
    }
    if (fceApplicationDB.hasIdLastUpdatePerson()) {
      setIdLastUpdatePerson(fceApplicationDB.getIdLastUpdatePersonObject());
    }
    if (fceApplicationDB.hasIdMngngCvsPerson()) {
      setIdMngngCvsPerson(fceApplicationDB.getIdMngngCvsPersonObject());
    }
    if (fceApplicationDB.hasIdOtherRelativePerson()) {
      setIdOtherRelativePerson(fceApplicationDB.getIdOtherRelativePersonObject());
    }
    if (fceApplicationDB.hasIdPerson()) {
      setIdPerson(fceApplicationDB.getIdPersonObject());
    }
    if (fceApplicationDB.hasIdStage()) {
      setIdStage(fceApplicationDB.getIdStageObject());
    }
    if (fceApplicationDB.hasIndAgeJustifiedEval()) {
      setIndAgeJustifiedEval(fceApplicationDB.getIndAgeJustifiedEvalObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdBaptismCert()) {
      setIndAgeVrfdBaptismCert(fceApplicationDB.getIndAgeVrfdBaptismCertObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdForeignCert()) {
      setIndAgeVrfdForeignCert(fceApplicationDB.getIndAgeVrfdForeignCertObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdHospitalCert()) {
      setIndAgeVrfdHospitalCert(fceApplicationDB.getIndAgeVrfdHospitalCertObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdNtrlztnCert()) {
      setIndAgeVrfdNtrlztnCert(fceApplicationDB.getIndAgeVrfdNtrlztnCertObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdPassport()) {
      setIndAgeVrfdPassport(fceApplicationDB.getIndAgeVrfdPassportObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdResidentCard()) {
      setIndAgeVrfdResidentCard(fceApplicationDB.getIndAgeVrfdResidentCardObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdSaveSystem()) {
      setIndAgeVrfdSaveSystem(fceApplicationDB.getIndAgeVrfdSaveSystemObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdSuccessSystem()) {
      setIndAgeVrfdSuccessSystem(fceApplicationDB.getIndAgeVrfdSuccessSystemObject());
    }
    if (fceApplicationDB.hasIndAgeVrfdUsBirthCert()) {
      setIndAgeVrfdUsBirthCert(fceApplicationDB.getIndAgeVrfdUsBirthCertObject());
    }
    if (fceApplicationDB.hasIndAmendedApp()) {
      setIndAmendedApp(fceApplicationDB.getIndAmendedAppObject());
    }
    if (fceApplicationDB.hasIndChildSupportOrder()) {
      setIndChildSupportOrder(fceApplicationDB.getIndChildSupportOrderObject());
    }
    if (fceApplicationDB.hasIndEvaluationConclusion()) {
      setIndEvaluationConclusion(fceApplicationDB.getIndEvaluationConclusionObject());
    }
    if (fceApplicationDB.hasIndHospital()) {
      setIndHospital(fceApplicationDB.getIndHospitalObject());
    }
    if (fceApplicationDB.hasIndIncomeAssistance()) {
      setIndIncomeAssistance(fceApplicationDB.getIndIncomeAssistanceObject());
    }
    if (fceApplicationDB.hasIndLegalDocsSentEs()) {
      setIndLegalDocsSentEs(fceApplicationDB.getIndLegalDocsSentEsObject());
    }
    if (fceApplicationDB.hasIndLivingRelativeSixMonth()) {
      setIndLivingRelativeSixMonth(fceApplicationDB.getIndLivingRelativeSixMonthObject());
    }
    if (fceApplicationDB.hasIndManagingCvs()) {
      setIndManagingCvs(fceApplicationDB.getIndManagingCvsObject());
    }
    if (fceApplicationDB.hasIndMinorParent()) {
      setIndMinorParent(fceApplicationDB.getIndMinorParentObject());
    }
    if (fceApplicationDB.hasIndNotifiedDhsWorker()) {
      setIndNotifiedDhsWorker(fceApplicationDB.getIndNotifiedDhsWorkerObject());
    }
    if (fceApplicationDB.hasIndOtherHealthInsurance()) {
      setIndOtherHealthInsurance(fceApplicationDB.getIndOtherHealthInsuranceObject());
    }
    if (fceApplicationDB.hasIndProofAgeSentEs()) {
      setIndProofAgeSentEs(fceApplicationDB.getIndProofAgeSentEsObject());
    }
    if (fceApplicationDB.hasIndProofCitizenshipSentEs()) {
      setIndProofCitizenshipSentEs(fceApplicationDB.getIndProofCitizenshipSentEsObject());
    }
    if (fceApplicationDB.hasIndSpecifiedRelative()) {
      setIndSpecifiedRelative(fceApplicationDB.getIndSpecifiedRelative());
    }
    if (fceApplicationDB.hasNbrCourtMonth()) {
      setNbrCourtMonth(fceApplicationDB.getNbrCourtMonthObject());
    }
    if (fceApplicationDB.hasNbrCourtYear()) {
      setNbrCourtYear(fceApplicationDB.getNbrCourtYearObject());
    }
    if (fceApplicationDB.hasNbrHealthGroup()) {
      setNbrHealthGroup(fceApplicationDB.getNbrHealthGroupObject());
    }
    if (fceApplicationDB.hasNbrHealthPolicy()) {
      setNbrHealthPolicy(fceApplicationDB.getNbrHealthPolicyObject());
    }
    if (fceApplicationDB.hasNbrLivingAtHome()) {
      setNbrLivingAtHome(fceApplicationDB.getNbrLivingAtHomeObject());
    }
    if (fceApplicationDB.hasNbrNotifiedDhsWrkrPhn()) {
      setNbrNotifiedDhsWrkrPhn(fceApplicationDB.getNbrNotifiedDhsWrkrPhnObject());
    }
    if (fceApplicationDB.hasNmHealthCompany()) {
      setNmHealthCompany(fceApplicationDB.getNmHealthCompanyObject());
    }
    if (fceApplicationDB.hasNmHealthEmployeeNm()) {
      setNmHealthEmployeeNm(fceApplicationDB.getNmHealthEmployeeNmObject());
    }
    if (fceApplicationDB.hasNmHealthEmployerNm()) {
      setNmHealthEmployerNm(fceApplicationDB.getNmHealthEmployerNmObject());
    }
    if (fceApplicationDB.hasNmHealthPolicyHldrNm()) {
      setNmHealthPolicyHldrNm(fceApplicationDB.getNmHealthPolicyHldrNmObject());
    }
    if (fceApplicationDB.hasNmHospital()) {
      setNmHospital(fceApplicationDB.getNmHospitalObject());
    }
    if (fceApplicationDB.hasNmHospitalCity()) {
      setNmHospitalCity(fceApplicationDB.getNmHospitalCityObject());
    }
    if (fceApplicationDB.hasNmMotherMaiden()) {
      setNmMotherMaiden(fceApplicationDB.getNmMotherMaidenObject());
    }
    if (fceApplicationDB.hasNmNotifiedDhsWrkrFirst()) {
      setNmNotifiedDhsWrkrFirst(fceApplicationDB.getNmNotifiedDhsWrkrFirstObject());
    }
    if (fceApplicationDB.hasNmNotifiedDhsWrkrLast()) {
      setNmNotifiedDhsWrkrLast(fceApplicationDB.getNmNotifiedDhsWrkrLastObject());
    }
    if (fceApplicationDB.hasNmNotifiedDhsWrkrMiddle()) {
      setNmNotifiedDhsWrkrMiddle(fceApplicationDB.getNmNotifiedDhsWrkrMiddleObject());
    }
    if (fceApplicationDB.hasTxtEmployeeComments()) {
      setTxtEmployeeComments(fceApplicationDB.getTxtEmployeeCommentsObject());
    }
    if (fceApplicationDB.hasTxtIncomeDtrmntnComments()) {
      setTxtIncomeDtrmntnComments(fceApplicationDB.getTxtIncomeDtrmntnCommentsObject());
    }
    if (fceApplicationDB.hasTxtLegalDocsSentEs()) {
      setTxtLegalDocsSentEs(fceApplicationDB.getTxtLegalDocsSentEsObject());
    }
    if (fceApplicationDB.hasTxtMeetsDdOrNotComments()) {
      setTxtMeetsDdOrNotComments(fceApplicationDB.getTxtMeetsDdOrNotCommentsObject());
    }
    if (fceApplicationDB.hasTxtNoIncomeExplanation()) {
      setTxtNoIncomeExplanation(fceApplicationDB.getTxtNoIncomeExplanationObject());
    }
    if (fceApplicationDB.hasTxtProofAgeSentEs()) {
      setTxtProofAgeSentEs(fceApplicationDB.getTxtProofAgeSentEsObject());
    }
    if (fceApplicationDB.hasTxtProofCitizenshipSentEs()) {
      setTxtProofCitizenshipSentEs(fceApplicationDB.getTxtProofCitizenshipSentEsObject());
    }
    if (fceApplicationDB.hasTxtPriorRemovalMonths()) {
      setTxtPriorRemovalMonths(fceApplicationDB.getTxtPriorRemovalMonthsObject());
      
    }
  }

  public FcePersonDB getFcePerson() {
    FcePersonDB fcePersonDB = new FcePersonDB();
    if (hasCdRelInt) {
      fcePersonDB.setCdRelInt(cdRelInt);
    }
    
    if (hasDtBirth) {
      fcePersonDB.setDtBirth(dtBirth);
    }
    if (hasFcePersonDtLastUpdate) {
      fcePersonDB.setDtLastUpdate(fcePersonDtLastUpdate);
    }
    if (hasIdFceEligibility) {
      fcePersonDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdFcePerson) {
      fcePersonDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdPerson) {
      fcePersonDB.setIdPerson(idPerson);
    }
    if (hasIndCertifiedGroup) {
      fcePersonDB.setIndCertifiedGroup(indCertifiedGroup);
    }
    if (hasIndDobApprox) {
      fcePersonDB.setIndDobApprox(indDobApprox);
    }
    if (hasIndLegalCustodian) {
      fcePersonDB.setIndLegalCustodian(indLegalCustodian);
    }
    if (hasIndPersonHmRemoval) {
      fcePersonDB.setIndPersonHmRemoval(indPersonHmRemoval);
    }
    if (hasNbrAge) {
      fcePersonDB.setNbrAge(nbrAge);
    }
    if (hasNmPersonFull) {
      fcePersonDB.setNmPersonFull(nmPersonFull);
    }
    
    return fcePersonDB;
  }

  public void setFcePerson(FcePersonDB fcePersonDB) {
    
    
    
    if (fcePersonDB.hasCdRelInt()) {
      setCdRelInt(fcePersonDB.getCdRelIntObject());
    }
    
    if (fcePersonDB.hasDtBirth()) {
      setDtBirth(fcePersonDB.getDtBirthObject());
    }
    if (fcePersonDB.hasDtLastUpdate()) {
      setFcePersonDtLastUpdate(fcePersonDB.getDtLastUpdateObject());
    }
    if (fcePersonDB.hasIdFceEligibility()) {
      setIdFceEligibility(fcePersonDB.getIdFceEligibilityObject());
    }
    if (fcePersonDB.hasIdFcePerson()) {
      setIdFcePerson(fcePersonDB.getIdFcePersonObject());
    }
    if (fcePersonDB.hasIdPerson()) {
      setIdPerson(fcePersonDB.getIdPersonObject());
    }
    if (fcePersonDB.hasIndCertifiedGroup()) {
      setIndCertifiedGroup(fcePersonDB.getIndCertifiedGroupObject());
    }
    if (fcePersonDB.hasIndDobApprox()) {
      setIndDobApprox(fcePersonDB.getIndDobApproxObject());
    }
    if (fcePersonDB.hasIndLegalCustodian()) {
      setIndLegalCustodian(fcePersonDB.getIndLegalCustodianObject());
    }
    if (fcePersonDB.hasIndPersonHmRemoval()) {
      setIndPersonHmRemoval(fcePersonDB.getIndPersonHmRemovalObject());
    }
    if (fcePersonDB.hasNbrAge()) {
      setNbrAge(fcePersonDB.getNbrAgeObject());
    }
    if (fcePersonDB.hasNmPersonFull()) {
      setNmPersonFull(fcePersonDB.getNmPersonFullObject());
    }
    
  }

  public String toString() {
    return
            "BEGIN bean: ApplicationBackground\n" +
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
            " cdRelInt: " + cdRelInt + "\n" +
            " cdRemovalAddrCounty: " + cdRemovalAddrCounty + "\n" +
            " cdRemovalAddrState: " + cdRemovalAddrState + "\n" +
            " cdState: " + cdState + "\n" +
            " dtApplicationComplete: " + dtApplicationComplete + "\n" +
            " dtHealthBeginDate: " + dtHealthBeginDate + "\n" +
            " dtHealthEndDate: " + dtHealthEndDate + "\n" +
            " dtHospitalAdmission: " + dtHospitalAdmission + "\n" +
            " dtHospitalDischarge: " + dtHospitalDischarge + "\n" +
            " fceApplicationDtLastUpdate: " + fceApplicationDtLastUpdate + "\n" +
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
            " indLegalCustodian: " + indLegalCustodian + "\n" +
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
            " txtEmployeeComments: " + txtEmployeeComments + "\n" +
            " txtIncomeDtrmntnComments: " + txtIncomeDtrmntnComments + "\n" +
            " txtLegalDocsSentEs: " + txtLegalDocsSentEs + "\n" +
            " txtMeetsDdOrNotComments: " + txtMeetsDdOrNotComments + "\n" +
            " txtNoIncomeExplanation: " + txtNoIncomeExplanation + "\n" +
            " txtProofAgeSentEs: " + txtProofAgeSentEs + "\n" +
            " txtProofCitizenshipSentEs: " + txtProofCitizenshipSentEs + "\n" +
            " txtPriorRemovalMonths: " + txtPriorRemovalMonths + "\n" + 
            " dtBirth: " + dtBirth + "\n" +
            " fcePersonDtLastUpdate: " + fcePersonDtLastUpdate + "\n" +
            " idFcePerson: " + idFcePerson + "\n" +
            " indCertifiedGroup: " + indCertifiedGroup + "\n" +
            " indDobApprox: " + indDobApprox + "\n" +
            " indPersonHmRemoval: " + indPersonHmRemoval + "\n" +
            " nbrAge: " + nbrAge + "\n" +
            " principles: " + principles + "\n" +
            " placements: " + placements + "\n" +
            " nmEmployeePersonFull: " + nmEmployeePersonFull + "\n" +
            " nmPersonFull: " + nmPersonFull + "\n" +
            " nbrEmployeePersonPhone: " + nbrEmployeePersonPhone + "\n" +
            " nbrSocialSecurity: " + nbrSocialSecurity + "\n" +
            " nbrMedicaid: " + nbrMedicaid + "\n" +
            " nbrMhn: " + nbrMhn + "\n" +
            " cdEventStatus: " + cdEventStatus + "\n" +
            " nbrCrsId: " + nbrCrsId + "\n" +
            "END bean: ApplicationBackground\n";
  }

  public static Boolean isTrueBoolean(String string) {
    if (string == null) {
      return null;
    }
    return isTrue(string);
  }

  public static boolean isTrue(String string) {
    return ((string != null) &&
            ("Y".equals(string) || "1".equals(string)));
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
    if (value) {
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
