//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class AgeCitizenshipDB
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
  public static final String AMT_COUNTABLE_INCOME_MONEY = "amtCountableIncomeMoney";
  public static final String AMT_COUNTABLE_INCOME = "amtCountableIncome";
  public static final String AMT_GROSS_EARNED_CRTFD_GRP_MONEY = "amtGrossEarnedCrtfdGrpMoney";
  public static final String AMT_GROSS_EARNED_CRTFD_GRP = "amtGrossEarnedCrtfdGrp";
  public static final String AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY = "amtGrossUnearnedCrtfdGrpMoney";
  public static final String AMT_GROSS_UNEARNED_CRTFD_GRP = "amtGrossUnearnedCrtfdGrp";
  public static final String AMT_INCOME_LIMIT_MONEY = "amtIncomeLimitMoney";
  public static final String AMT_INCOME_LIMIT = "amtIncomeLimit";
  public static final String AMT_PWE_INCOME_MONEY = "amtPweIncomeMoney";
  public static final String AMT_PWE_INCOME = "amtPweIncome";
  public static final String AMT_SSI_MONEY = "amtSsiMoney";
  public static final String AMT_SSI = "amtSsi";
  public static final String AMT_STEPPARENT_ALIMONY_MONEY = "amtStepparentAlimonyMoney";
  public static final String AMT_STEPPARENT_ALIMONY = "amtStepparentAlimony";
  public static final String AMT_STEPPARENT_ALLOWANCE_MONEY = "amtStepparentAllowanceMoney";
  public static final String AMT_STEPPARENT_ALLOWANCE = "amtStepparentAllowance";
  public static final String AMT_STEPPARENT_APPLIED_INCOME_MONEY = "amtStepparentAppliedIncomeMoney";
  public static final String AMT_STEPPARENT_APPLIED_INCOME = "amtStepparentAppliedIncome";
  public static final String AMT_STEPPARENT_CNTBL_UNEARNED_MONEY = "amtStepparentCntblUnearnedMoney";
  public static final String AMT_STEPPARENT_CNTBL_UNEARNED = "amtStepparentCntblUnearned";
  public static final String AMT_STEPPARENT_GROSS_EARNED_MONEY = "amtStepparentGrossEarnedMoney";
  public static final String AMT_STEPPARENT_GROSS_EARNED = "amtStepparentGrossEarned";
  public static final String AMT_STEPPARENT_OUTSIDE_PMNT_MONEY = "amtStepparentOutsidePmntMoney";
  public static final String AMT_STEPPARENT_OUTSIDE_PMNT = "amtStepparentOutsidePmnt";
  public static final String AMT_STEPPARENT_TOTAL_CNTBL_MONEY = "amtStepparentTotalCntblMoney";
  public static final String AMT_STEPPARENT_TOTAL_CNTBL = "amtStepparentTotalCntbl";
  public static final String AMT_STEPPARENT_WORK_DEDUCT_MONEY = "amtStepparentWorkDeductMoney";
  public static final String AMT_STEPPARENT_WORK_DEDUCT = "amtStepparentWorkDeduct";
  public static final String CD_BLOC_CHILD = "cdBlocChild";
  public static final String CD_ELIGIBILITY_ACTUAL = "cdEligibilityActual";
  public static final String CD_ELIGIBILITY_SELECTED = "cdEligibilitySelected";
  public static final String CD_MEDICAID_ELIGIBILITY_TYPE = "cdMedicaidEligibilityType";
  public static final String FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP = "fceEligibilityCdPersonCitizenship";
  public static final String CD_PWE_IRREGULAR_UNDER100 = "cdPweIrregularUnder100";
  public static final String CD_PWE_STEADY_UNDER100 = "cdPweSteadyUnder100";
  public static final String CD_VERIF_METHOD = "cdVerifMethod";
  public static final String CD_VERIF_DOC_TYPE = "cdVerifDocType";
  public static final String DT_DEPRIVATION_CHANGED_STRING = "dtDeprivationChangedString";
  public static final String DT_DEPRIVATION_CHANGED_TIME = "dtDeprivationChangedTime";
  public static final String DT_ELIGIBILITY_END_STRING = "dtEligibilityEndString";
  public static final String DT_ELIGIBILITY_END_TIME = "dtEligibilityEndTime";
  public static final String DT_ELIG_DTRMNTN_START_STRING = "dtEligDtrmntnStartString";
  public static final String DT_ELIG_DTRMNTN_START_TIME = "dtEligDtrmntnStartTime";
  public static final String FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING = "fceEligibilityDtLastUpdateString";
  public static final String FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME = "fceEligibilityDtLastUpdateTime";
  public static final String DT_REMOVAL_CHILD_ORDERED_STRING = "dtRemovalChildOrderedString";
  public static final String DT_REMOVAL_CHILD_ORDERED_TIME = "dtRemovalChildOrderedTime";
  public static final String DT_REVIEW_DATE_STRING = "dtReviewDateString";
  public static final String DT_REVIEW_DATE_TIME = "dtReviewDateTime";
  public static final String DT_RSNBL_EFFORT_PREVENT_REM_STRING = "dtRsnblEffortPreventRemString";
  public static final String DT_RSNBL_EFFORT_PREVENT_REM_TIME = "dtRsnblEffortPreventRemTime";
  public static final String ID_ELIGIBILITY_EVENT = "idEligibilityEvent";
  public static final String ID_FCE_PERSON = "idFcePerson";
  public static final String ID_FCE_REVIEW = "idFceReview";
  public static final String ID_PRN_EARNER = "idPrnEarner";
  public static final String IND_ABSENT_ALTRNT_CUSTODY = "indAbsentAltrntCustody";
  public static final String IND_ABSENT_DEPORTED = "indAbsentDeported";
  public static final String IND_ABSENT_DESERTED = "indAbsentDeserted";
  public static final String IND_ABSENT_DIED = "indAbsentDied";
  public static final String IND_ABSENT_DIVORCED = "indAbsentDivorced";
  public static final String IND_ABSENT_FATHER = "indAbsentFather";
  public static final String IND_ABSENT_HOSPITALIZED = "indAbsentHospitalized";
  public static final String IND_ABSENT_INCARCERATED = "indAbsentIncarcerated";
  public static final String IND_ABSENT_MILITARY_WORK = "indAbsentMilitaryWork";
  public static final String IND_ABSENT_MOTHER = "indAbsentMother";
  public static final String IND_ABSENT_SEPARATED = "indAbsentSeparated";
  public static final String IND_ABSENT_WORK_RELATED = "indAbsentWorkRelated";
  public static final String IND_CHILD_LIVING_PRNT6_MNTHS = "indChildLivingPrnt6Mnths";
  public static final String IND_CHILD_QUALIFIED_CITIZEN = "indChildQualifiedCitizen";
  public static final String IND_CHILD_SUPPORT_ORDERED = "indChildSupportOrdered";
  public static final String IND_CHILD_UNDER18 = "indChildUnder18";
  public static final String IND_CTZNSHP_AMER_INDIAN_CRD = "indCtznshpAmerIndianCrd";
  public static final String IND_CTZNSHP_ATTORNEY_REVIEW = "indCtznshpAttorneyReview";
  public static final String IND_CTZNSHP_BIRTH_CRTFCT_FOR = "indCtznshpBirthCrtfctFor";
  public static final String IND_CTZNSHP_BIRTH_CRTFCT_US = "indCtznshpBirthCrtfctUs";
  public static final String IND_CTZNSHP_CHLD_FOUND = "indCtznshpChldFound";
  public static final String IND_CTZNSHP_CITIZEN_CRTFCT = "indCtznshpCitizenCrtfct";
  public static final String IND_CTZNSHP_EVALUATION = "indCtznshpEvaluation";
  public static final String IND_CTZNSHP_FOR_DOCUMENTATION = "indCtznshpForDocumentation";
  public static final String IND_CTZNSHP_HOSPITAL_CRTFCT = "indCtznshpHospitalCrtfct";
  public static final String IND_CTZNSHP_NO_DOCUMENTATION = "indCtznshpNoDocumentation";
  public static final String IND_CTZNSHP_NTRLZTN_CRTFCT = "indCtznshpNtrlztnCrtfct";
  public static final String IND_CTZNSHP_PASSPORT = "indCtznshpPassport";
  public static final String IND_CTZNSHP_RESIDENT_CARD = "indCtznshpResidentCard";
  public static final String IND_CTZNSHP_UNACC_MINOR_CHILD = "indCtznshpUnaccMinorChild";
  public static final String IND_CTZNSHP_UNDOC_IMMIGRANT = "indCtznshpUndocImmigrant";
  public static final String IND_CTZNSHP_US_HSPTL_BRTH_RCRD = "indCtznshpUsHsptlBrthRcrd";
  public static final String IND_CTZNSHP_US_ID_CARD = "indCtznshpUsIdCard";
  public static final String IND_CTZNSHP_VITAL_BIRTH_RCRD = "indCtznshpVitalBirthRcrd";
  public static final String IND_CTZNSHP_DRIVER_LIC_OR_ID = "indCtznshpDriverLicOrId";
  public static final String IND_CTZNSHP_CERT_IND_BLOOD = "indCtznshpCertIndBlood";
  public static final String IND_CTZNSHP_DOC_IMMIG_NAT_ACT = "indCtznshpDocImmigNatAct";
  public static final String IND_CTZNSHP_SCHOOL_ID_PHOTO = "indCtznshpSchoolIdPhoto";
  public static final String IND_CTZNSHP_MILITARY_DEPDNT_ID = "indCtznshpMilitaryDepdntId";
  public static final String IND_CTZNSHP_SCHOOL_REC = "indCtznshpSchoolRec";
  public static final String IND_CTZNSHP_CLINIC_DOC_HOS_DOC = "indCtznshpClinicDocHosDoc";
  public static final String IND_CTZNSHP_DAYCARE_NURSE_RCRD = "indCtznshpDaycareNurseRcrd";
  public static final String IND_CTZNSHP_AFFIDAVIT_SIGNED = "indCtznshpAffidavitSigned";
  public static final String IND_CTZNSHP_CERT_REPORT_BIRTH = "indCtznshpCertReportBirth";
  public static final String IND_CTZNSHP_SAVE_SYSTEM = "indCtznshpSaveSystem";
  public static final String IND_CTZNSHP_STUDENT_VISA = "indCtznshpStudentVisa";
  public static final String IND_CTZNSHP_SUCCESS_SYSTEM = "indCtznshpSuccessSystem";
  public static final String IND_CTZNSHP_BIRTH_ABROAD = "indCtznshpBirthAbroad";
  public static final String IND_CTZNSHP_CENSUS_BIRTH_RCRD = "indCtznshpCensusBirthRcrd";
  public static final String IND_CTZNSHP_CIVIL_SERVICE_EMP = "indCtznshpCivilServiceEmp";
  public static final String IND_CTZNSHP_CONFRM_BIRTH = "indCtznshpConfrmBirth";
  public static final String IND_CTZNSHP_FINAL_ADOPT_DECREE = "indCtznshpFinalAdoptDecree";
  public static final String IND_CTZNSHP_LEGL_IMMI_STAT_EXP = "indCtznshpLeglImmiStatExp";
  public static final String IND_CTZNSHP_LIFE_INS_BRTH_RCRD = "indCtznshpLifeInsBrthRcrd";
  public static final String IND_CTZNSHP_LOCL_GOV_BRTH_RCRD = "indCtznshpLoclGovtBrthRcrd";
  public static final String IND_CTZNSHP_MED_BIRTH_RCRD = "indCtznshpMedBirthRcrd";
  public static final String IND_CTZNSHP_MILTRY_BIRTH_RCRD = "indCtznshpMiltryBirthRcrd";
  public static final String IND_CTZNSHP_NORTH_MARIANA_ID = "indCtznshpNorthMarianaId";
  public static final String IND_CTZNSHP_REFUGEE = "indCtznshpRefugee";
  public static final String IND_CTZNSHP_RELIG_BIRTH_RCRD = "indCtznshpReligBirthRcrd";
  public static final String IND_ELIGIBILITY_COURT_MONTH = "indEligibilityCourtMonth";
  public static final String IND_ELIGIBLE = "indEligible";
  public static final String IND_EQUITY = "indEquity";
  public static final String IND_FATHER_PWE = "indFatherPwe";
  public static final String IND_HOME_INCOME_AFDC_ELGBLTY = "indHomeIncomeAfdcElgblty";
  public static final String IND_MEETS_DP_OR_NOT_ES = "indMeetsDpOrNotEs";
  public static final String IND_MEETS_DP_OR_NOT_SYSTEM = "indMeetsDpOrNotSystem";
  public static final String IND_MOTHER_PWE = "indMotherPwe";
  public static final String IND_NARRATIVE_APPROVED = "indNarrativeApproved";
  public static final String IND_OTHER_VERIFICATION = "indOtherVerification";
  public static final String IND_PARENTAL_DEPRIVATION = "indParentalDeprivation";
  public static final String IND_PARENT_DISABLED = "indParentDisabled";
  public static final String IND_PE_NOT_ACPT_EMP_TRN = "indPeNotAcptEmpTrn";
  public static final String IND_PE_RECV_UNEMP = "indPeRecvUnemp";
  public static final String IND_PE_WRK_ENG_EDU_TRN = "indPeWrkEngEduTrn";
  public static final String IND_PRS_MANAGING_CVS = "indPrsManagingCvs";
  public static final String IND_RECV_100_PCT_VA = "indRecv100PctVa";
  public static final String IND_RECV_RR_RSDI = "indRecvRrRsdi";
  public static final String IND_REMOVAL_CHILD_ORDERED = "indRemovalChildOrdered";
  public static final String IND_RSDI_VERIFICATION = "indRsdiVerification";
  public static final String IND_RSNBL_EFFORT_PRVT_REMOVAL = "indRsnblEffortPrvtRemoval";
  public static final String IND_SSI_VERIFICATION = "indSsiVerification";
  public static final String NBR_CERTIFIED_GROUP = "nbrCertifiedGroup";
  public static final String NBR_PARENTS_HOME = "nbrParentsHome";
  public static final String TXT_DETERMINATION_COMMENTS = "txtDeterminationComments";
  public static final String TXT_MONTHS_DEP_UNEMP = "txtMonthsDepUnemp";
  public static final String CD_REL_INT = "cdRelInt";
  public static final String DT_BIRTH_STRING = "dtBirthString";
  public static final String DT_BIRTH_TIME = "dtBirthTime";
  public static final String FCE_PERSON_DT_LAST_UPDATE_STRING = "fcePersonDtLastUpdateString";
  public static final String FCE_PERSON_DT_LAST_UPDATE_TIME = "fcePersonDtLastUpdateTime";
  public static final String IND_CERTIFIED_GROUP = "indCertifiedGroup";
  public static final String IND_DOB_APPROX = "indDobApprox";
  public static final String IND_PERSON_HM_REMOVAL = "indPersonHmRemoval";
  public static final String NBR_AGE = "nbrAge";
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
  protected boolean hasAmtCountableIncome = false;
  protected Double amtCountableIncome = null;
  protected boolean hasAmtGrossEarnedCrtfdGrp = false;
  protected Double amtGrossEarnedCrtfdGrp = null;
  protected boolean hasAmtGrossUnearnedCrtfdGrp = false;
  protected Double amtGrossUnearnedCrtfdGrp = null;
  protected boolean hasAmtIncomeLimit = false;
  protected Double amtIncomeLimit = null;
  protected boolean hasAmtPweIncome = false;
  protected Double amtPweIncome = null;
  protected boolean hasAmtSsi = false;
  protected Double amtSsi = null;
  protected boolean hasAmtStepparentAlimony = false;
  protected Double amtStepparentAlimony = null;
  protected boolean hasAmtStepparentAllowance = false;
  protected Double amtStepparentAllowance = null;
  protected boolean hasAmtStepparentAppliedIncome = false;
  protected Double amtStepparentAppliedIncome = null;
  protected boolean hasAmtStepparentCntblUnearned = false;
  protected Double amtStepparentCntblUnearned = null;
  protected boolean hasAmtStepparentGrossEarned = false;
  protected Double amtStepparentGrossEarned = null;
  protected boolean hasAmtStepparentOutsidePmnt = false;
  protected Double amtStepparentOutsidePmnt = null;
  protected boolean hasAmtStepparentTotalCntbl = false;
  protected Double amtStepparentTotalCntbl = null;
  protected boolean hasAmtStepparentWorkDeduct = false;
  protected Double amtStepparentWorkDeduct = null;
  protected boolean hasCdBlocChild = false;
  protected String cdBlocChild = null;
  protected boolean hasCdEligibilityActual = false;
  protected String cdEligibilityActual = null;
  protected boolean hasCdEligibilitySelected = false;
  protected String cdEligibilitySelected = null;
  protected boolean hasCdMedicaidEligibilityType = false;
  protected String cdMedicaidEligibilityType = null;
  protected boolean hasFceEligibilityCdPersonCitizenship = false;
  protected String fceEligibilityCdPersonCitizenship = null;
  protected boolean hasCdPweIrregularUnder100 = false;
  protected String cdPweIrregularUnder100 = null;
  protected boolean hasCdPweSteadyUnder100 = false;
  protected String cdPweSteadyUnder100 = null;
  protected boolean hasDtDeprivationChanged = false;
  protected boolean hasCdVerifMethod = false;
  protected String cdVerifMethod = null;
  protected boolean hasCdVerifDocType = false;
  protected String cdVerifDocType = null;
  protected Date dtDeprivationChanged = null;
  protected boolean hasDtEligibilityEnd = false;
  protected Date dtEligibilityEnd = null;
  protected boolean hasDtEligDtrmntnStart = false;
  protected Date dtEligDtrmntnStart = null;
  protected boolean hasFceEligibilityDtLastUpdate = false;
  protected Date fceEligibilityDtLastUpdate = null;
  protected boolean hasDtRemovalChildOrdered = false;
  protected Date dtRemovalChildOrdered = null;
  protected boolean hasDtReviewDate = false;
  protected Date dtReviewDate = null;
  protected boolean hasDtRsnblEffortPreventRem = false;
  protected Date dtRsnblEffortPreventRem = null;
  protected boolean hasIdEligibilityEvent = false;
  protected Long idEligibilityEvent = null;
  protected boolean hasIdFcePerson = false;
  protected Long idFcePerson = null;
  protected boolean hasIdFceReview = false;
  protected Long idFceReview = null;
  protected boolean hasIdPrnEarner = false;
  protected Long idPrnEarner = null;
  protected boolean hasIndAbsentAltrntCustody = false;
  protected Boolean indAbsentAltrntCustody = null;
  protected boolean hasIndAbsentDeported = false;
  protected Boolean indAbsentDeported = null;
  protected boolean hasIndAbsentDeserted = false;
  protected Boolean indAbsentDeserted = null;
  protected boolean hasIndAbsentDied = false;
  protected Boolean indAbsentDied = null;
  protected boolean hasIndAbsentDivorced = false;
  protected Boolean indAbsentDivorced = null;
  protected boolean hasIndAbsentFather = false;
  protected Boolean indAbsentFather = null;
  protected boolean hasIndAbsentHospitalized = false;
  protected Boolean indAbsentHospitalized = null;
  protected boolean hasIndAbsentIncarcerated = false;
  protected Boolean indAbsentIncarcerated = null;
  protected boolean hasIndAbsentMilitaryWork = false;
  protected Boolean indAbsentMilitaryWork = null;
  protected boolean hasIndAbsentMother = false;
  protected Boolean indAbsentMother = null;
  protected boolean hasIndAbsentSeparated = false;
  protected Boolean indAbsentSeparated = null;
  protected boolean hasIndAbsentWorkRelated = false;
  protected Boolean indAbsentWorkRelated = null;
  protected boolean hasIndChildLivingPrnt6Mnths = false;
  protected Boolean indChildLivingPrnt6Mnths = null;
  protected boolean hasIndChildQualifiedCitizen = false;
  protected Boolean indChildQualifiedCitizen = null;
  protected boolean hasIndChildSupportOrdered = false;
  protected Boolean indChildSupportOrdered = null;
  protected boolean hasIndChildUnder18 = false;
  protected Boolean indChildUnder18 = null;
  protected boolean hasIndCtznshpAmerIndianCrd = false;
  protected Boolean indCtznshpAmerIndianCrd = null;
  protected boolean hasIndCtznshpAttorneyReview = false;
  protected Boolean indCtznshpAttorneyReview = null;
  protected boolean hasIndCtznshpBirthCrtfctFor = false;
  protected Boolean indCtznshpBirthCrtfctFor = null;
  protected boolean hasIndCtznshpBirthCrtfctUs = false;
  protected Boolean indCtznshpBirthCrtfctUs = null;
  protected boolean hasIndCtznshpChldFound = false;
  protected Boolean indCtznshpChldFound = null;
  protected boolean hasIndCtznshpCitizenCrtfct = false;
  protected Boolean indCtznshpCitizenCrtfct = null;
  protected boolean hasIndCtznshpEvaluation = false;
  protected Boolean indCtznshpEvaluation = null;
  protected boolean hasIndCtznshpForDocumentation = false;
  protected Boolean indCtznshpForDocumentation = null;
  protected boolean hasIndCtznshpHospitalCrtfct = false;
  protected Boolean indCtznshpHospitalCrtfct = null;
  protected boolean hasIndCtznshpNoDocumentation = false;
  protected Boolean indCtznshpNoDocumentation = null;
  protected boolean hasIndCtznshpNtrlztnCrtfct = false;
  protected Boolean indCtznshpNtrlztnCrtfct = null;
  protected boolean hasIndCtznshpPassport = false;
  protected Boolean indCtznshpPassport = null;
  protected boolean hasIndCtznshpResidentCard = false;
  protected Boolean indCtznshpResidentCard = null;
  protected boolean hasIndCtznshpUnaccMinorChild = false;
  protected Boolean indCtznshpUnaccMinorChild = null;
  protected boolean hasIndCtznshpUndocImmigrant = false;
  protected Boolean indCtznshpUndocImmigrant = null;
  protected boolean hasIndCtznshpUsHsptlBrthRcrd = false;
  protected Boolean indCtznshpUsHsptlBrthRcrd = null;
  protected boolean hasIndCtznshpUsIdCard = false;
  protected Boolean indCtznshpUsIdCard = null;
  protected boolean hasIndCtznshpVitalBirthRcrd = false;
  protected Boolean indCtznshpVitalBirthRcrd = null;
  protected boolean hasIndCtznshpDriverLicOrId = false;
  protected Boolean indCtznshpDriverLicOrId = null;
  protected boolean hasIndCtznshpCertIndBlood = false;
  protected Boolean indCtznshpCertIndBlood = null;
  protected boolean hasIndCtznshpDocImmigNatAct = false;
  protected Boolean indCtznshpDocImmigNatAct = null;
  protected boolean hasIndCtznshpSchoolIdPhoto = false;
  protected Boolean indCtznshpSchoolIdPhoto = null;
  protected boolean hasIndCtznshpMilitaryDepdntId = false;
  protected Boolean indCtznshpMilitaryDepdntId = null;
  protected boolean hasIndCtznshpSchoolRec = false;
  protected Boolean indCtznshpSchoolRec = null;
  protected boolean hasIndCtznshpClinicDocHosDoc = false;
  protected Boolean indCtznshpClinicDocHosDoc = null;
  protected boolean hasIndCtznshpDaycareNurseRcrd = false;
  protected Boolean indCtznshpDaycareNurseRcrd = null;
  protected boolean hasIndCtznshpAffidavitSigned = false;
  protected Boolean indCtznshpAffidavitSigned = null;
  protected boolean hasIndCtznshpCertReportBirth = false;
  protected Boolean indCtznshpCertReportBirth = null;
  protected boolean hasIndCtznshpSaveSystem = false;
  protected Boolean indCtznshpSaveSystem = null;
  protected boolean hasIndCtznshpStudentVisa = false;
  protected Boolean indCtznshpStudentVisa = null;
  protected boolean hasIndCtznshpSuccessSystem = false;
  protected Boolean indCtznshpSuccessSystem = null;
  protected boolean hasIndCtznshpBirthAbroad = false;
  protected Boolean indCtznshpBirthAbroad = null;
  protected boolean hasIndCtznshpCensusBirthRcrd = false;
  protected Boolean indCtznshpCensusBirthRcrd = null;
  protected boolean hasIndCtznshpCivilServiceEmp = false;
  protected Boolean indCtznshpCivilServiceEmp = null;
  protected boolean hasIndCtznshpConfrmBirth = false;
  protected Boolean indCtznshpConfrmBirth = null;
  protected boolean hasIndCtznshpFinalAdoptDecree = false;
  protected Boolean indCtznshpFinalAdoptDecree = null;
  protected boolean hasIndCtznshpLeglImmiStatExp = false;
  protected Boolean indCtznshpLeglImmiStatExp = null;
  protected boolean hasIndCtznshpLifeInsBrthRcrd = false;
  protected Boolean indCtznshpLifeInsBrthRcrd = null;
  protected boolean hasIndCtznshpLoclGovtBrthRcrd = false;
  protected Boolean indCtznshpLoclGovtBrthRcrd = null;
  protected boolean hasIndCtznshpMedBirthRcrd = false;
  protected Boolean indCtznshpMedBirthRcrd = null;
  protected boolean hasIndCtznshpMiltryBirthRcrd = false;
  protected Boolean indCtznshpMiltryBirthRcrd = null;
  protected boolean hasIndCtznshpNorthMarianaId = false;
  protected Boolean indCtznshpNorthMarianaId = null;
  protected boolean hasIndCtznshpRefugee = false;
  protected Boolean indCtznshpRefugee = null;
  protected boolean hasIndCtznshpReligBirthRcrd = false;
  protected Boolean indCtznshpReligBirthRcrd = null;
  protected boolean hasIndEligibilityCourtMonth = false;
  protected Boolean indEligibilityCourtMonth = null;
  protected boolean hasIndEligible = false;
  protected Boolean indEligible = null;
  protected boolean hasIndEquity = false;
  protected Boolean indEquity = null;
  protected boolean hasIndFatherPwe = false;
  protected Boolean indFatherPwe = null;
  protected boolean hasIndHomeIncomeAfdcElgblty = false;
  protected Boolean indHomeIncomeAfdcElgblty = null;
  protected boolean hasIndMeetsDpOrNotEs = false;
  protected Boolean indMeetsDpOrNotEs = null;
  protected boolean hasIndMeetsDpOrNotSystem = false;
  protected Boolean indMeetsDpOrNotSystem = null;
  protected boolean hasIndMotherPwe = false;
  protected Boolean indMotherPwe = null;
  protected boolean hasIndNarrativeApproved = false;
  protected Boolean indNarrativeApproved = null;
  protected boolean hasIndOtherVerification = false;
  protected Boolean indOtherVerification = null;
  protected boolean hasIndParentalDeprivation = false;
  protected Boolean indParentalDeprivation = null;
  protected boolean hasIndParentDisabled = false;
  protected Boolean indParentDisabled = null;
  protected boolean hasIndPeNotAcptEmpTrn = false;
  protected Boolean indPeNotAcptEmpTrn = null;
  protected boolean hasIndPeRecvUnemp = false;
  protected Boolean indPeRecvUnemp = null;
  protected boolean hasIndPeWrkEngEduTrn = false;
  protected Boolean indPeWrkEngEduTrn = null;
  protected boolean hasIndPrsManagingCvs = false;
  protected Boolean indPrsManagingCvs = null;
  protected boolean hasIndRecv100PctVa = false;
  protected Boolean indRecv100PctVa = null;
  protected boolean hasIndRecvRrRsdi = false;
  protected Boolean indRecvRrRsdi = null;
  protected boolean hasIndRemovalChildOrdered = false;
  protected Boolean indRemovalChildOrdered = null;
  protected boolean hasIndRsdiVerification = false;
  protected Boolean indRsdiVerification = null;
  protected boolean hasIndRsnblEffortPrvtRemoval = false;
  protected Boolean indRsnblEffortPrvtRemoval = null;
  protected boolean hasIndSsiVerification = false;
  protected Boolean indSsiVerification = null;
  protected boolean hasNbrCertifiedGroup = false;
  protected Long nbrCertifiedGroup = null;
  protected boolean hasNbrParentsHome = false;
  protected Long nbrParentsHome = null;
  protected boolean hasTxtDeterminationComments = false;
  protected String txtDeterminationComments = null;
  protected boolean hasTxtMonthsDepUnemp = false;
  protected String txtMonthsDepUnemp = null;
  protected boolean hasCdRelInt = false;
  protected String cdRelInt = null;
  protected boolean hasDtBirth = false;
  protected Date dtBirth = null;
  protected boolean hasFcePersonDtLastUpdate = false;
  protected Date fcePersonDtLastUpdate = null;
  protected boolean hasIndCertifiedGroup = false;
  protected Boolean indCertifiedGroup = null;
  protected boolean hasIndDobApprox = false;
  protected Boolean indDobApprox = null;
  protected boolean hasIndPersonHmRemoval = false;
  protected Boolean indPersonHmRemoval = null;
  protected boolean hasNbrAge = false;
  protected Long nbrAge = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;

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

  public boolean hasAmtCountableIncome() {
    return hasAmtCountableIncome;
  }

  public double getAmtCountableIncome() {
    if (amtCountableIncome == null) {
      return (double) 0;
    }
    return amtCountableIncome;
  }

  public Double getAmtCountableIncomeObject() {
    return amtCountableIncome;
  }

  public String getAmtCountableIncomeString() {
    return FormattingHelper.formatDouble(amtCountableIncome);
  }

  public void setAmtCountableIncome(double amtCountableIncome) {
    this.hasAmtCountableIncome = true;
    this.amtCountableIncome = amtCountableIncome;
  }

  public void setAmtCountableIncome(Double amtCountableIncome) {
    this.hasAmtCountableIncome = true;
    this.amtCountableIncome = amtCountableIncome;
  }

  public void setAmtCountableIncome(Number amtCountableIncome) {
    this.hasAmtCountableIncome = true;
    this.amtCountableIncome = null;
    if (amtCountableIncome != null) {
      setAmtCountableIncome(amtCountableIncome.doubleValue());
    }
  }

  public boolean hasAmtGrossEarnedCrtfdGrp() {
    return hasAmtGrossEarnedCrtfdGrp;
  }

  public double getAmtGrossEarnedCrtfdGrp() {
    if (amtGrossEarnedCrtfdGrp == null) {
      return (double) 0;
    }
    return amtGrossEarnedCrtfdGrp;
  }

  public Double getAmtGrossEarnedCrtfdGrpObject() {
    return amtGrossEarnedCrtfdGrp;
  }

  public String getAmtGrossEarnedCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtGrossEarnedCrtfdGrp);
  }

  public void setAmtGrossEarnedCrtfdGrp(double amtGrossEarnedCrtfdGrp) {
    this.hasAmtGrossEarnedCrtfdGrp = true;
    this.amtGrossEarnedCrtfdGrp = amtGrossEarnedCrtfdGrp;
  }

  public void setAmtGrossEarnedCrtfdGrp(Double amtGrossEarnedCrtfdGrp) {
    this.hasAmtGrossEarnedCrtfdGrp = true;
    this.amtGrossEarnedCrtfdGrp = amtGrossEarnedCrtfdGrp;
  }

  public void setAmtGrossEarnedCrtfdGrp(Number amtGrossEarnedCrtfdGrp) {
    this.hasAmtGrossEarnedCrtfdGrp = true;
    this.amtGrossEarnedCrtfdGrp = null;
    if (amtGrossEarnedCrtfdGrp != null) {
      setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtGrossUnearnedCrtfdGrp() {
    return hasAmtGrossUnearnedCrtfdGrp;
  }

  public double getAmtGrossUnearnedCrtfdGrp() {
    if (amtGrossUnearnedCrtfdGrp == null) {
      return (double) 0;
    }
    return amtGrossUnearnedCrtfdGrp;
  }

  public Double getAmtGrossUnearnedCrtfdGrpObject() {
    return amtGrossUnearnedCrtfdGrp;
  }

  public String getAmtGrossUnearnedCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtGrossUnearnedCrtfdGrp);
  }

  public void setAmtGrossUnearnedCrtfdGrp(double amtGrossUnearnedCrtfdGrp) {
    this.hasAmtGrossUnearnedCrtfdGrp = true;
    this.amtGrossUnearnedCrtfdGrp = amtGrossUnearnedCrtfdGrp;
  }

  public void setAmtGrossUnearnedCrtfdGrp(Double amtGrossUnearnedCrtfdGrp) {
    this.hasAmtGrossUnearnedCrtfdGrp = true;
    this.amtGrossUnearnedCrtfdGrp = amtGrossUnearnedCrtfdGrp;
  }

  public void setAmtGrossUnearnedCrtfdGrp(Number amtGrossUnearnedCrtfdGrp) {
    this.hasAmtGrossUnearnedCrtfdGrp = true;
    this.amtGrossUnearnedCrtfdGrp = null;
    if (amtGrossUnearnedCrtfdGrp != null) {
      setAmtGrossUnearnedCrtfdGrp(amtGrossUnearnedCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtIncomeLimit() {
    return hasAmtIncomeLimit;
  }

  public double getAmtIncomeLimit() {
    if (amtIncomeLimit == null) {
      return (double) 0;
    }
    return amtIncomeLimit;
  }

  public Double getAmtIncomeLimitObject() {
    return amtIncomeLimit;
  }

  public String getAmtIncomeLimitString() {
    return FormattingHelper.formatDouble(amtIncomeLimit);
  }

  public void setAmtIncomeLimit(double amtIncomeLimit) {
    this.hasAmtIncomeLimit = true;
    this.amtIncomeLimit = amtIncomeLimit;
  }

  public void setAmtIncomeLimit(Double amtIncomeLimit) {
    this.hasAmtIncomeLimit = true;
    this.amtIncomeLimit = amtIncomeLimit;
  }

  public void setAmtIncomeLimit(Number amtIncomeLimit) {
    this.hasAmtIncomeLimit = true;
    this.amtIncomeLimit = null;
    if (amtIncomeLimit != null) {
      setAmtIncomeLimit(amtIncomeLimit.doubleValue());
    }
  }

  public boolean hasAmtPweIncome() {
    return hasAmtPweIncome;
  }

  public double getAmtPweIncome() {
    if (amtPweIncome == null) {
      return (double) 0;
    }
    return amtPweIncome;
  }

  public Double getAmtPweIncomeObject() {
    return amtPweIncome;
  }

  public String getAmtPweIncomeString() {
    return FormattingHelper.formatDouble(amtPweIncome);
  }

  public void setAmtPweIncome(double amtPweIncome) {
    this.hasAmtPweIncome = true;
    this.amtPweIncome = amtPweIncome;
  }

  public void setAmtPweIncome(Double amtPweIncome) {
    this.hasAmtPweIncome = true;
    this.amtPweIncome = amtPweIncome;
  }

  public void setAmtPweIncome(Number amtPweIncome) {
    this.hasAmtPweIncome = true;
    this.amtPweIncome = null;
    if (amtPweIncome != null) {
      setAmtPweIncome(amtPweIncome.doubleValue());
    }
  }

  public boolean hasAmtSsi() {
    return hasAmtSsi;
  }

  public double getAmtSsi() {
    if (amtSsi == null) {
      return (double) 0;
    }
    return amtSsi;
  }

  public Double getAmtSsiObject() {
    return amtSsi;
  }

  public String getAmtSsiString() {
    return FormattingHelper.formatDouble(amtSsi);
  }

  public void setAmtSsi(double amtSsi) {
    this.hasAmtSsi = true;
    this.amtSsi = amtSsi;
  }

  public void setAmtSsi(Double amtSsi) {
    this.hasAmtSsi = true;
    this.amtSsi = amtSsi;
  }

  public void setAmtSsi(Number amtSsi) {
    this.hasAmtSsi = true;
    this.amtSsi = null;
    if (amtSsi != null) {
      setAmtSsi(amtSsi.doubleValue());
    }
  }

  public boolean hasAmtStepparentAlimony() {
    return hasAmtStepparentAlimony;
  }

  public double getAmtStepparentAlimony() {
    if (amtStepparentAlimony == null) {
      return (double) 0;
    }
    return amtStepparentAlimony;
  }

  public Double getAmtStepparentAlimonyObject() {
    return amtStepparentAlimony;
  }

  public String getAmtStepparentAlimonyString() {
    return FormattingHelper.formatDouble(amtStepparentAlimony);
  }

  public void setAmtStepparentAlimony(double amtStepparentAlimony) {
    this.hasAmtStepparentAlimony = true;
    this.amtStepparentAlimony = amtStepparentAlimony;
  }

  public void setAmtStepparentAlimony(Double amtStepparentAlimony) {
    this.hasAmtStepparentAlimony = true;
    this.amtStepparentAlimony = amtStepparentAlimony;
  }

  public void setAmtStepparentAlimony(Number amtStepparentAlimony) {
    this.hasAmtStepparentAlimony = true;
    this.amtStepparentAlimony = null;
    if (amtStepparentAlimony != null) {
      setAmtStepparentAlimony(amtStepparentAlimony.doubleValue());
    }
  }

  public boolean hasAmtStepparentAllowance() {
    return hasAmtStepparentAllowance;
  }

  public double getAmtStepparentAllowance() {
    if (amtStepparentAllowance == null) {
      return (double) 0;
    }
    return amtStepparentAllowance;
  }

  public Double getAmtStepparentAllowanceObject() {
    return amtStepparentAllowance;
  }

  public String getAmtStepparentAllowanceString() {
    return FormattingHelper.formatDouble(amtStepparentAllowance);
  }

  public void setAmtStepparentAllowance(double amtStepparentAllowance) {
    this.hasAmtStepparentAllowance = true;
    this.amtStepparentAllowance = amtStepparentAllowance;
  }

  public void setAmtStepparentAllowance(Double amtStepparentAllowance) {
    this.hasAmtStepparentAllowance = true;
    this.amtStepparentAllowance = amtStepparentAllowance;
  }

  public void setAmtStepparentAllowance(Number amtStepparentAllowance) {
    this.hasAmtStepparentAllowance = true;
    this.amtStepparentAllowance = null;
    if (amtStepparentAllowance != null) {
      setAmtStepparentAllowance(amtStepparentAllowance.doubleValue());
    }
  }

  public boolean hasAmtStepparentAppliedIncome() {
    return hasAmtStepparentAppliedIncome;
  }

  public double getAmtStepparentAppliedIncome() {
    if (amtStepparentAppliedIncome == null) {
      return (double) 0;
    }
    return amtStepparentAppliedIncome;
  }

  public Double getAmtStepparentAppliedIncomeObject() {
    return amtStepparentAppliedIncome;
  }

  public String getAmtStepparentAppliedIncomeString() {
    return FormattingHelper.formatDouble(amtStepparentAppliedIncome);
  }

  public void setAmtStepparentAppliedIncome(double amtStepparentAppliedIncome) {
    this.hasAmtStepparentAppliedIncome = true;
    this.amtStepparentAppliedIncome = amtStepparentAppliedIncome;
  }

  public void setAmtStepparentAppliedIncome(Double amtStepparentAppliedIncome) {
    this.hasAmtStepparentAppliedIncome = true;
    this.amtStepparentAppliedIncome = amtStepparentAppliedIncome;
  }

  public void setAmtStepparentAppliedIncome(Number amtStepparentAppliedIncome) {
    this.hasAmtStepparentAppliedIncome = true;
    this.amtStepparentAppliedIncome = null;
    if (amtStepparentAppliedIncome != null) {
      setAmtStepparentAppliedIncome(amtStepparentAppliedIncome.doubleValue());
    }
  }

  public boolean hasAmtStepparentCntblUnearned() {
    return hasAmtStepparentCntblUnearned;
  }

  public double getAmtStepparentCntblUnearned() {
    if (amtStepparentCntblUnearned == null) {
      return (double) 0;
    }
    return amtStepparentCntblUnearned;
  }

  public Double getAmtStepparentCntblUnearnedObject() {
    return amtStepparentCntblUnearned;
  }

  public String getAmtStepparentCntblUnearnedString() {
    return FormattingHelper.formatDouble(amtStepparentCntblUnearned);
  }

  public void setAmtStepparentCntblUnearned(double amtStepparentCntblUnearned) {
    this.hasAmtStepparentCntblUnearned = true;
    this.amtStepparentCntblUnearned = amtStepparentCntblUnearned;
  }

  public void setAmtStepparentCntblUnearned(Double amtStepparentCntblUnearned) {
    this.hasAmtStepparentCntblUnearned = true;
    this.amtStepparentCntblUnearned = amtStepparentCntblUnearned;
  }

  public void setAmtStepparentCntblUnearned(Number amtStepparentCntblUnearned) {
    this.hasAmtStepparentCntblUnearned = true;
    this.amtStepparentCntblUnearned = null;
    if (amtStepparentCntblUnearned != null) {
      setAmtStepparentCntblUnearned(amtStepparentCntblUnearned.doubleValue());
    }
  }

  public boolean hasAmtStepparentGrossEarned() {
    return hasAmtStepparentGrossEarned;
  }

  public double getAmtStepparentGrossEarned() {
    if (amtStepparentGrossEarned == null) {
      return (double) 0;
    }
    return amtStepparentGrossEarned;
  }

  public Double getAmtStepparentGrossEarnedObject() {
    return amtStepparentGrossEarned;
  }

  public String getAmtStepparentGrossEarnedString() {
    return FormattingHelper.formatDouble(amtStepparentGrossEarned);
  }

  public void setAmtStepparentGrossEarned(double amtStepparentGrossEarned) {
    this.hasAmtStepparentGrossEarned = true;
    this.amtStepparentGrossEarned = amtStepparentGrossEarned;
  }

  public void setAmtStepparentGrossEarned(Double amtStepparentGrossEarned) {
    this.hasAmtStepparentGrossEarned = true;
    this.amtStepparentGrossEarned = amtStepparentGrossEarned;
  }

  public void setAmtStepparentGrossEarned(Number amtStepparentGrossEarned) {
    this.hasAmtStepparentGrossEarned = true;
    this.amtStepparentGrossEarned = null;
    if (amtStepparentGrossEarned != null) {
      setAmtStepparentGrossEarned(amtStepparentGrossEarned.doubleValue());
    }
  }

  public boolean hasAmtStepparentOutsidePmnt() {
    return hasAmtStepparentOutsidePmnt;
  }

  public double getAmtStepparentOutsidePmnt() {
    if (amtStepparentOutsidePmnt == null) {
      return (double) 0;
    }
    return amtStepparentOutsidePmnt;
  }

  public Double getAmtStepparentOutsidePmntObject() {
    return amtStepparentOutsidePmnt;
  }

  public String getAmtStepparentOutsidePmntString() {
    return FormattingHelper.formatDouble(amtStepparentOutsidePmnt);
  }

  public void setAmtStepparentOutsidePmnt(double amtStepparentOutsidePmnt) {
    this.hasAmtStepparentOutsidePmnt = true;
    this.amtStepparentOutsidePmnt = amtStepparentOutsidePmnt;
  }

  public void setAmtStepparentOutsidePmnt(Double amtStepparentOutsidePmnt) {
    this.hasAmtStepparentOutsidePmnt = true;
    this.amtStepparentOutsidePmnt = amtStepparentOutsidePmnt;
  }

  public void setAmtStepparentOutsidePmnt(Number amtStepparentOutsidePmnt) {
    this.hasAmtStepparentOutsidePmnt = true;
    this.amtStepparentOutsidePmnt = null;
    if (amtStepparentOutsidePmnt != null) {
      setAmtStepparentOutsidePmnt(amtStepparentOutsidePmnt.doubleValue());
    }
  }

  public boolean hasAmtStepparentTotalCntbl() {
    return hasAmtStepparentTotalCntbl;
  }

  public double getAmtStepparentTotalCntbl() {
    if (amtStepparentTotalCntbl == null) {
      return (double) 0;
    }
    return amtStepparentTotalCntbl;
  }

  public Double getAmtStepparentTotalCntblObject() {
    return amtStepparentTotalCntbl;
  }

  public String getAmtStepparentTotalCntblString() {
    return FormattingHelper.formatDouble(amtStepparentTotalCntbl);
  }

  public void setAmtStepparentTotalCntbl(double amtStepparentTotalCntbl) {
    this.hasAmtStepparentTotalCntbl = true;
    this.amtStepparentTotalCntbl = amtStepparentTotalCntbl;
  }

  public void setAmtStepparentTotalCntbl(Double amtStepparentTotalCntbl) {
    this.hasAmtStepparentTotalCntbl = true;
    this.amtStepparentTotalCntbl = amtStepparentTotalCntbl;
  }

  public void setAmtStepparentTotalCntbl(Number amtStepparentTotalCntbl) {
    this.hasAmtStepparentTotalCntbl = true;
    this.amtStepparentTotalCntbl = null;
    if (amtStepparentTotalCntbl != null) {
      setAmtStepparentTotalCntbl(amtStepparentTotalCntbl.doubleValue());
    }
  }

  public boolean hasAmtStepparentWorkDeduct() {
    return hasAmtStepparentWorkDeduct;
  }

  public double getAmtStepparentWorkDeduct() {
    if (amtStepparentWorkDeduct == null) {
      return (double) 0;
    }
    return amtStepparentWorkDeduct;
  }

  public Double getAmtStepparentWorkDeductObject() {
    return amtStepparentWorkDeduct;
  }

  public String getAmtStepparentWorkDeductString() {
    return FormattingHelper.formatDouble(amtStepparentWorkDeduct);
  }

  public void setAmtStepparentWorkDeduct(double amtStepparentWorkDeduct) {
    this.hasAmtStepparentWorkDeduct = true;
    this.amtStepparentWorkDeduct = amtStepparentWorkDeduct;
  }

  public void setAmtStepparentWorkDeduct(Double amtStepparentWorkDeduct) {
    this.hasAmtStepparentWorkDeduct = true;
    this.amtStepparentWorkDeduct = amtStepparentWorkDeduct;
  }

  public void setAmtStepparentWorkDeduct(Number amtStepparentWorkDeduct) {
    this.hasAmtStepparentWorkDeduct = true;
    this.amtStepparentWorkDeduct = null;
    if (amtStepparentWorkDeduct != null) {
      setAmtStepparentWorkDeduct(amtStepparentWorkDeduct.doubleValue());
    }
  }

  public boolean hasCdBlocChild() {
    return hasCdBlocChild;
  }

  public String getCdBlocChild() {
    if (cdBlocChild == null) {
      return "";
    }
    return cdBlocChild;
  }

  public String getCdBlocChildObject() {
    return cdBlocChild;
  }

  public void setCdBlocChild(String cdBlocChild) {
    this.hasCdBlocChild = true;
    this.cdBlocChild = cdBlocChild;
  }

  public boolean hasCdEligibilityActual() {
    return hasCdEligibilityActual;
  }

  public String getCdEligibilityActual() {
    if (cdEligibilityActual == null) {
      return "";
    }
    return cdEligibilityActual;
  }

  public String getCdEligibilityActualObject() {
    return cdEligibilityActual;
  }

  public void setCdEligibilityActual(String cdEligibilityActual) {
    this.hasCdEligibilityActual = true;
    this.cdEligibilityActual = cdEligibilityActual;
  }

  public boolean hasCdEligibilitySelected() {
    return hasCdEligibilitySelected;
  }

  public String getCdEligibilitySelected() {
    if (cdEligibilitySelected == null) {
      return "";
    }
    return cdEligibilitySelected;
  }

  public String getCdEligibilitySelectedObject() {
    return cdEligibilitySelected;
  }

  public void setCdEligibilitySelected(String cdEligibilitySelected) {
    this.hasCdEligibilitySelected = true;
    this.cdEligibilitySelected = cdEligibilitySelected;
  }

  public boolean hasCdMedicaidEligibilityType() {
    return hasCdMedicaidEligibilityType;
  }

  public String getCdMedicaidEligibilityType() {
    if (cdMedicaidEligibilityType == null) {
      return "";
    }
    return cdMedicaidEligibilityType;
  }

  public String getCdMedicaidEligibilityTypeObject() {
    return cdMedicaidEligibilityType;
  }

  public void setCdMedicaidEligibilityType(String cdMedicaidEligibilityType) {
    this.hasCdMedicaidEligibilityType = true;
    this.cdMedicaidEligibilityType = cdMedicaidEligibilityType;
  }

  public boolean hasFceEligibilityCdPersonCitizenship() {
    return hasFceEligibilityCdPersonCitizenship;
  }

  public String getFceEligibilityCdPersonCitizenship() {
    if (fceEligibilityCdPersonCitizenship == null) {
      return "";
    }
    return fceEligibilityCdPersonCitizenship;
  }

  public String getFceEligibilityCdPersonCitizenshipObject() {
    return fceEligibilityCdPersonCitizenship;
  }

  public void setFceEligibilityCdPersonCitizenship(String fceEligibilityCdPersonCitizenship) {
    this.hasFceEligibilityCdPersonCitizenship = true;
    this.fceEligibilityCdPersonCitizenship = fceEligibilityCdPersonCitizenship;
  }

  public boolean hasCdPweIrregularUnder100() {
    return hasCdPweIrregularUnder100;
  }

  public String getCdPweIrregularUnder100() {
    if (cdPweIrregularUnder100 == null) {
      return "";
    }
    return cdPweIrregularUnder100;
  }

  public String getCdPweIrregularUnder100Object() {
    return cdPweIrregularUnder100;
  }

  public void setCdPweIrregularUnder100(String cdPweIrregularUnder100) {
    this.hasCdPweIrregularUnder100 = true;
    this.cdPweIrregularUnder100 = cdPweIrregularUnder100;
  }

  public boolean hasCdPweSteadyUnder100() {
    return hasCdPweSteadyUnder100;
  }

  public String getCdPweSteadyUnder100() {
    if (cdPweSteadyUnder100 == null) {
      return "";
    }
    return cdPweSteadyUnder100;
  }

  public String getCdPweSteadyUnder100Object() {
    return cdPweSteadyUnder100;
  }

  public void setCdPweSteadyUnder100(String cdPweSteadyUnder100) {
    this.hasCdPweSteadyUnder100 = true;
    this.cdPweSteadyUnder100 = cdPweSteadyUnder100;
  }

  public boolean hasCdVerifMethod() {
    return hasCdVerifMethod;
  }

  public String getCdVerifMethod() {
    if (cdVerifMethod == null) {
      return "";
    }
    return cdVerifMethod;
  }

  public String getCdVerifMethodObject() {
    return cdVerifMethod;
  }

  public void setCdVerifMethod(String cdVerifMethod) {
    if ((cdVerifMethod != null) &&
        (cdVerifMethod.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'cdVerifMethod'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + cdVerifMethod + "'");
    }
    this.hasCdVerifMethod = true;
    this.cdVerifMethod = cdVerifMethod;
  }

  public boolean hasCdVerifDocType() {
    return hasCdVerifDocType;
  }

  public String getCdVerifDocType() {
    if (cdVerifDocType == null) {
      return "";
    }
    return cdVerifDocType;
  }

  public String getCdVerifDocTypeObject() {
    return cdVerifDocType;
  }

  public void setCdVerifDocType(String cdVerifDocType) {
    if ((cdVerifDocType != null) &&
        (cdVerifDocType.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'cdVerifDocType'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + cdVerifDocType + "'");
    }
    this.hasCdVerifDocType = true;
    this.cdVerifDocType = cdVerifDocType;
  }

  public boolean hasDtDeprivationChanged() {
    return hasDtDeprivationChanged;
  }
  
  public Date getDtDeprivationChanged() {
    return dtDeprivationChanged;
  }

  public Date getDtDeprivationChangedObject() {
    return dtDeprivationChanged;
  }

  public String getDtDeprivationChangedString() {
    return toString(dtDeprivationChanged);
  }

  public long getDtDeprivationChangedTime() {
    return toTime(dtDeprivationChanged);
  }

  public void setDtDeprivationChanged(Date dtDeprivationChanged) {
    this.hasDtDeprivationChanged = true;
    if ((dtDeprivationChanged != null) &&
        (dtDeprivationChanged.getTime() == 0)) {
      dtDeprivationChanged = null;
    }
    this.dtDeprivationChanged = dtDeprivationChanged;
  }

  public void setDtDeprivationChangedString(String dtDeprivationChangedString) {
    this.hasDtDeprivationChanged = true;
    this.dtDeprivationChanged = toDate(dtDeprivationChangedString);
  }

  public void setDtDeprivationChangedTime(long dtDeprivationChangedTime) {
    this.hasDtDeprivationChanged = true;
    this.dtDeprivationChanged = toDate(dtDeprivationChangedTime);
  }

  public boolean hasDtEligibilityEnd() {
    return hasDtEligibilityEnd;
  }

  public Date getDtEligibilityEnd() {
    return dtEligibilityEnd;
  }

  public Date getDtEligibilityEndObject() {
    return dtEligibilityEnd;
  }

  public String getDtEligibilityEndString() {
    return toString(dtEligibilityEnd);
  }

  public long getDtEligibilityEndTime() {
    return toTime(dtEligibilityEnd);
  }

  public void setDtEligibilityEnd(Date dtEligibilityEnd) {
    this.hasDtEligibilityEnd = true;
    if ((dtEligibilityEnd != null) &&
        (dtEligibilityEnd.getTime() == 0)) {
      dtEligibilityEnd = null;
    }
    this.dtEligibilityEnd = dtEligibilityEnd;
  }

  public void setDtEligibilityEndString(String dtEligibilityEndString) {
    this.hasDtEligibilityEnd = true;
    this.dtEligibilityEnd = toDate(dtEligibilityEndString);
  }

  public void setDtEligibilityEndTime(long dtEligibilityEndTime) {
    this.hasDtEligibilityEnd = true;
    this.dtEligibilityEnd = toDate(dtEligibilityEndTime);
  }

  public boolean hasDtEligDtrmntnStart() {
    return hasDtEligDtrmntnStart;
  }

  public Date getDtEligDtrmntnStart() {
    return dtEligDtrmntnStart;
  }

  public Date getDtEligDtrmntnStartObject() {
    return dtEligDtrmntnStart;
  }

  public String getDtEligDtrmntnStartString() {
    return toString(dtEligDtrmntnStart);
  }

  public long getDtEligDtrmntnStartTime() {
    return toTime(dtEligDtrmntnStart);
  }

  public void setDtEligDtrmntnStart(Date dtEligDtrmntnStart) {
    this.hasDtEligDtrmntnStart = true;
    if ((dtEligDtrmntnStart != null) &&
        (dtEligDtrmntnStart.getTime() == 0)) {
      dtEligDtrmntnStart = null;
    }
    this.dtEligDtrmntnStart = dtEligDtrmntnStart;
  }

  public void setDtEligDtrmntnStartString(String dtEligDtrmntnStartString) {
    this.hasDtEligDtrmntnStart = true;
    this.dtEligDtrmntnStart = toDate(dtEligDtrmntnStartString);
  }

  public void setDtEligDtrmntnStartTime(long dtEligDtrmntnStartTime) {
    this.hasDtEligDtrmntnStart = true;
    this.dtEligDtrmntnStart = toDate(dtEligDtrmntnStartTime);
  }

  public boolean hasFceEligibilityDtLastUpdate() {
    return hasFceEligibilityDtLastUpdate;
  }

  public Date getFceEligibilityDtLastUpdate() {
    return fceEligibilityDtLastUpdate;
  }

  public Date getFceEligibilityDtLastUpdateObject() {
    return fceEligibilityDtLastUpdate;
  }

  public String getFceEligibilityDtLastUpdateString() {
    return toString(fceEligibilityDtLastUpdate);
  }

  public long getFceEligibilityDtLastUpdateTime() {
    return toTime(fceEligibilityDtLastUpdate);
  }

  public void setFceEligibilityDtLastUpdate(Date fceEligibilityDtLastUpdate) {
    this.hasFceEligibilityDtLastUpdate = true;
    if ((fceEligibilityDtLastUpdate != null) &&
        (fceEligibilityDtLastUpdate.getTime() == 0)) {
      fceEligibilityDtLastUpdate = null;
    }
    this.fceEligibilityDtLastUpdate = fceEligibilityDtLastUpdate;
  }

  public void setFceEligibilityDtLastUpdateString(String fceEligibilityDtLastUpdateString) {
    this.hasFceEligibilityDtLastUpdate = true;
    this.fceEligibilityDtLastUpdate = toDate(fceEligibilityDtLastUpdateString);
  }

  public void setFceEligibilityDtLastUpdateTime(long fceEligibilityDtLastUpdateTime) {
    this.hasFceEligibilityDtLastUpdate = true;
    this.fceEligibilityDtLastUpdate = toDate(fceEligibilityDtLastUpdateTime);
  }

  public boolean hasDtRemovalChildOrdered() {
    return hasDtRemovalChildOrdered;
  }

  public Date getDtRemovalChildOrdered() {
    return dtRemovalChildOrdered;
  }

  public Date getDtRemovalChildOrderedObject() {
    return dtRemovalChildOrdered;
  }

  public String getDtRemovalChildOrderedString() {
    return toString(dtRemovalChildOrdered);
  }

  public long getDtRemovalChildOrderedTime() {
    return toTime(dtRemovalChildOrdered);
  }

  public void setDtRemovalChildOrdered(Date dtRemovalChildOrdered) {
    this.hasDtRemovalChildOrdered = true;
    if ((dtRemovalChildOrdered != null) &&
        (dtRemovalChildOrdered.getTime() == 0)) {
      dtRemovalChildOrdered = null;
    }
    this.dtRemovalChildOrdered = dtRemovalChildOrdered;
  }

  public void setDtRemovalChildOrderedString(String dtRemovalChildOrderedString) {
    this.hasDtRemovalChildOrdered = true;
    this.dtRemovalChildOrdered = toDate(dtRemovalChildOrderedString);
  }

  public void setDtRemovalChildOrderedTime(long dtRemovalChildOrderedTime) {
    this.hasDtRemovalChildOrdered = true;
    this.dtRemovalChildOrdered = toDate(dtRemovalChildOrderedTime);
  }

  public boolean hasDtReviewDate() {
    return hasDtReviewDate;
  }

  public Date getDtReviewDate() {
    return dtReviewDate;
  }

  public Date getDtReviewDateObject() {
    return dtReviewDate;
  }

  public String getDtReviewDateString() {
    return toString(dtReviewDate);
  }

  public long getDtReviewDateTime() {
    return toTime(dtReviewDate);
  }

  public void setDtReviewDate(Date dtReviewDate) {
    this.hasDtReviewDate = true;
    if ((dtReviewDate != null) &&
        (dtReviewDate.getTime() == 0)) {
      dtReviewDate = null;
    }
    this.dtReviewDate = dtReviewDate;
  }

  public void setDtReviewDateString(String dtReviewDateString) {
    this.hasDtReviewDate = true;
    this.dtReviewDate = toDate(dtReviewDateString);
  }

  public void setDtReviewDateTime(long dtReviewDateTime) {
    this.hasDtReviewDate = true;
    this.dtReviewDate = toDate(dtReviewDateTime);
  }

  public boolean hasDtRsnblEffortPreventRem() {
    return hasDtRsnblEffortPreventRem;
  }

  public Date getDtRsnblEffortPreventRem() {
    return dtRsnblEffortPreventRem;
  }

  public Date getDtRsnblEffortPreventRemObject() {
    return dtRsnblEffortPreventRem;
  }

  public String getDtRsnblEffortPreventRemString() {
    return toString(dtRsnblEffortPreventRem);
  }

  public long getDtRsnblEffortPreventRemTime() {
    return toTime(dtRsnblEffortPreventRem);
  }

  public void setDtRsnblEffortPreventRem(Date dtRsnblEffortPreventRem) {
    this.hasDtRsnblEffortPreventRem = true;
    if ((dtRsnblEffortPreventRem != null) &&
        (dtRsnblEffortPreventRem.getTime() == 0)) {
      dtRsnblEffortPreventRem = null;
    }
    this.dtRsnblEffortPreventRem = dtRsnblEffortPreventRem;
  }

  public void setDtRsnblEffortPreventRemString(String dtRsnblEffortPreventRemString) {
    this.hasDtRsnblEffortPreventRem = true;
    this.dtRsnblEffortPreventRem = toDate(dtRsnblEffortPreventRemString);
  }

  public void setDtRsnblEffortPreventRemTime(long dtRsnblEffortPreventRemTime) {
    this.hasDtRsnblEffortPreventRem = true;
    this.dtRsnblEffortPreventRem = toDate(dtRsnblEffortPreventRemTime);
  }

  public boolean hasIdEligibilityEvent() {
    return hasIdEligibilityEvent;
  }

  public long getIdEligibilityEvent() {
    if (idEligibilityEvent == null) {
      return (long) 0;
    }
    return idEligibilityEvent;
  }

  public Long getIdEligibilityEventObject() {
    return idEligibilityEvent;
  }

  public String getIdEligibilityEventString() {
    return FormattingHelper.formatLong(idEligibilityEvent);
  }

  public void setIdEligibilityEvent(long idEligibilityEvent) {
    this.hasIdEligibilityEvent = true;
    if (idEligibilityEvent == 0) {
      this.idEligibilityEvent = null;
      return;
    }
    this.idEligibilityEvent = idEligibilityEvent;
  }

  public void setIdEligibilityEvent(Long idEligibilityEvent) {
    this.hasIdEligibilityEvent = true;
    this.idEligibilityEvent = idEligibilityEvent;
  }

  public void setIdEligibilityEvent(Number idEligibilityEvent) {
    this.hasIdEligibilityEvent = true;
    this.idEligibilityEvent = null;
    if (idEligibilityEvent != null) {
      setIdEligibilityEvent(idEligibilityEvent.longValue());
    }
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

  public boolean hasIdFceReview() {
    return hasIdFceReview;
  }

  public long getIdFceReview() {
    if (idFceReview == null) {
      return (long) 0;
    }
    return idFceReview;
  }

  public Long getIdFceReviewObject() {
    return idFceReview;
  }

  public String getIdFceReviewString() {
    return FormattingHelper.formatLong(idFceReview);
  }

  public void setIdFceReview(long idFceReview) {
    this.hasIdFceReview = true;
    if (idFceReview == 0) {
      this.idFceReview = null;
      return;
    }
    this.idFceReview = idFceReview;
  }

  public void setIdFceReview(Long idFceReview) {
    this.hasIdFceReview = true;
    this.idFceReview = idFceReview;
  }

  public void setIdFceReview(Number idFceReview) {
    this.hasIdFceReview = true;
    this.idFceReview = null;
    if (idFceReview != null) {
      setIdFceReview(idFceReview.longValue());
    }
  }

  public boolean hasIdPrnEarner() {
    return hasIdPrnEarner;
  }

  public long getIdPrnEarner() {
    if (idPrnEarner == null) {
      return (long) 0;
    }
    return idPrnEarner.longValue();
  }

  public Long getIdPrnEarnerObject() {
    return idPrnEarner;
  }

  public String getIdPrnEarnerString() {
    return FormattingHelper.formatLong(idPrnEarner);
  }

  public void setIdPrnEarner(long idPrnEarner) {
    if (idPrnEarner == 0) {
      this.idPrnEarner = null;
      return;
    }
    this.hasIdPrnEarner = true;
    this.idPrnEarner = new Long(idPrnEarner);
  }

  public void setIdPrnEarner(Long idPrnEarner) {
    this.idPrnEarner = null;
    if (idPrnEarner != null) {
      setIdPrnEarner(idPrnEarner.longValue());
    }
  }

  public void setIdPrnEarner(Number idPrnEarner) {
    this.idPrnEarner = null;
    if (idPrnEarner != null) {
      setIdPrnEarner(idPrnEarner.longValue());
    }
  }

  public boolean hasIndAbsentAltrntCustody() {
    return hasIndAbsentAltrntCustody;
  }

  public boolean getIndAbsentAltrntCustody() {
    if (indAbsentAltrntCustody == null) {
      return false;
    }
    return indAbsentAltrntCustody;
  }

  public Boolean getIndAbsentAltrntCustodyObject() {
    return indAbsentAltrntCustody;
  }

  public String getIndAbsentAltrntCustodyString() {
    if (indAbsentAltrntCustody == null) {
      return "";
    }
    return indAbsentAltrntCustody.toString();
  }

  public void setIndAbsentAltrntCustody(boolean indAbsentAltrntCustody) {
    this.hasIndAbsentAltrntCustody = true;
    this.indAbsentAltrntCustody = indAbsentAltrntCustody;
  }

  public void setIndAbsentAltrntCustody(Boolean indAbsentAltrntCustody) {
    this.hasIndAbsentAltrntCustody = true;
    this.indAbsentAltrntCustody = indAbsentAltrntCustody;
  }

  public void setIndAbsentAltrntCustody(String indAbsentAltrntCustody) {
    this.hasIndAbsentAltrntCustody = true;
    this.indAbsentAltrntCustody = isTrueBoolean(indAbsentAltrntCustody);
  }

  public boolean hasIndAbsentDeported() {
    return hasIndAbsentDeported;
  }

  public boolean getIndAbsentDeported() {
    if (indAbsentDeported == null) {
      return false;
    }
    return indAbsentDeported;
  }

  public Boolean getIndAbsentDeportedObject() {
    return indAbsentDeported;
  }

  public String getIndAbsentDeportedString() {
    if (indAbsentDeported == null) {
      return "";
    }
    return indAbsentDeported.toString();
  }

  public void setIndAbsentDeported(boolean indAbsentDeported) {
    this.hasIndAbsentDeported = true;
    this.indAbsentDeported = indAbsentDeported;
  }

  public void setIndAbsentDeported(Boolean indAbsentDeported) {
    this.hasIndAbsentDeported = true;
    this.indAbsentDeported = indAbsentDeported;
  }

  public void setIndAbsentDeported(String indAbsentDeported) {
    this.hasIndAbsentDeported = true;
    this.indAbsentDeported = isTrueBoolean(indAbsentDeported);
  }

  public boolean hasIndAbsentDeserted() {
    return hasIndAbsentDeserted;
  }

  public boolean getIndAbsentDeserted() {
    if (indAbsentDeserted == null) {
      return false;
    }
    return indAbsentDeserted;
  }

  public Boolean getIndAbsentDesertedObject() {
    return indAbsentDeserted;
  }

  public String getIndAbsentDesertedString() {
    if (indAbsentDeserted == null) {
      return "";
    }
    return indAbsentDeserted.toString();
  }

  public void setIndAbsentDeserted(boolean indAbsentDeserted) {
    this.hasIndAbsentDeserted = true;
    this.indAbsentDeserted = indAbsentDeserted;
  }

  public void setIndAbsentDeserted(Boolean indAbsentDeserted) {
    this.hasIndAbsentDeserted = true;
    this.indAbsentDeserted = indAbsentDeserted;
  }

  public void setIndAbsentDeserted(String indAbsentDeserted) {
    this.hasIndAbsentDeserted = true;
    this.indAbsentDeserted = isTrueBoolean(indAbsentDeserted);
  }

  public boolean hasIndAbsentDied() {
    return hasIndAbsentDied;
  }

  public boolean getIndAbsentDied() {
    if (indAbsentDied == null) {
      return false;
    }
    return indAbsentDied;
  }

  public Boolean getIndAbsentDiedObject() {
    return indAbsentDied;
  }

  public String getIndAbsentDiedString() {
    if (indAbsentDied == null) {
      return "";
    }
    return indAbsentDied.toString();
  }

  public void setIndAbsentDied(boolean indAbsentDied) {
    this.hasIndAbsentDied = true;
    this.indAbsentDied = indAbsentDied;
  }

  public void setIndAbsentDied(Boolean indAbsentDied) {
    this.hasIndAbsentDied = true;
    this.indAbsentDied = indAbsentDied;
  }

  public void setIndAbsentDied(String indAbsentDied) {
    this.hasIndAbsentDied = true;
    this.indAbsentDied = isTrueBoolean(indAbsentDied);
  }

  public boolean hasIndAbsentDivorced() {
    return hasIndAbsentDivorced;
  }

  public boolean getIndAbsentDivorced() {
    if (indAbsentDivorced == null) {
      return false;
    }
    return indAbsentDivorced;
  }

  public Boolean getIndAbsentDivorcedObject() {
    return indAbsentDivorced;
  }

  public String getIndAbsentDivorcedString() {
    if (indAbsentDivorced == null) {
      return "";
    }
    return indAbsentDivorced.toString();
  }

  public void setIndAbsentDivorced(boolean indAbsentDivorced) {
    this.hasIndAbsentDivorced = true;
    this.indAbsentDivorced = indAbsentDivorced;
  }

  public void setIndAbsentDivorced(Boolean indAbsentDivorced) {
    this.hasIndAbsentDivorced = true;
    this.indAbsentDivorced = indAbsentDivorced;
  }

  public void setIndAbsentDivorced(String indAbsentDivorced) {
    this.hasIndAbsentDivorced = true;
    this.indAbsentDivorced = isTrueBoolean(indAbsentDivorced);
  }

  public boolean hasIndAbsentFather() {
    return hasIndAbsentFather;
  }

  public boolean getIndAbsentFather() {
    if (indAbsentFather == null) {
      return false;
    }
    return indAbsentFather;
  }

  public Boolean getIndAbsentFatherObject() {
    return indAbsentFather;
  }

  public String getIndAbsentFatherString() {
    if (indAbsentFather == null) {
      return "";
    }
    return indAbsentFather.toString();
  }

  public void setIndAbsentFather(boolean indAbsentFather) {
    this.hasIndAbsentFather = true;
    this.indAbsentFather = indAbsentFather;
  }

  public void setIndAbsentFather(Boolean indAbsentFather) {
    this.hasIndAbsentFather = true;
    this.indAbsentFather = indAbsentFather;
  }

  public void setIndAbsentFather(String indAbsentFather) {
    this.hasIndAbsentFather = true;
    this.indAbsentFather = isTrueBoolean(indAbsentFather);
  }

  public boolean hasIndAbsentHospitalized() {
    return hasIndAbsentHospitalized;
  }

  public boolean getIndAbsentHospitalized() {
    if (indAbsentHospitalized == null) {
      return false;
    }
    return indAbsentHospitalized;
  }

  public Boolean getIndAbsentHospitalizedObject() {
    return indAbsentHospitalized;
  }

  public String getIndAbsentHospitalizedString() {
    if (indAbsentHospitalized == null) {
      return "";
    }
    return indAbsentHospitalized.toString();
  }

  public void setIndAbsentHospitalized(boolean indAbsentHospitalized) {
    this.hasIndAbsentHospitalized = true;
    this.indAbsentHospitalized = indAbsentHospitalized;
  }

  public void setIndAbsentHospitalized(Boolean indAbsentHospitalized) {
    this.hasIndAbsentHospitalized = true;
    this.indAbsentHospitalized = indAbsentHospitalized;
  }

  public void setIndAbsentHospitalized(String indAbsentHospitalized) {
    this.hasIndAbsentHospitalized = true;
    this.indAbsentHospitalized = isTrueBoolean(indAbsentHospitalized);
  }

  public boolean hasIndAbsentIncarcerated() {
    return hasIndAbsentIncarcerated;
  }

  public boolean getIndAbsentIncarcerated() {
    if (indAbsentIncarcerated == null) {
      return false;
    }
    return indAbsentIncarcerated;
  }

  public Boolean getIndAbsentIncarceratedObject() {
    return indAbsentIncarcerated;
  }

  public String getIndAbsentIncarceratedString() {
    if (indAbsentIncarcerated == null) {
      return "";
    }
    return indAbsentIncarcerated.toString();
  }

  public void setIndAbsentIncarcerated(boolean indAbsentIncarcerated) {
    this.hasIndAbsentIncarcerated = true;
    this.indAbsentIncarcerated = indAbsentIncarcerated;
  }

  public void setIndAbsentIncarcerated(Boolean indAbsentIncarcerated) {
    this.hasIndAbsentIncarcerated = true;
    this.indAbsentIncarcerated = indAbsentIncarcerated;
  }

  public void setIndAbsentIncarcerated(String indAbsentIncarcerated) {
    this.hasIndAbsentIncarcerated = true;
    this.indAbsentIncarcerated = isTrueBoolean(indAbsentIncarcerated);
  }

  public boolean hasIndAbsentMilitaryWork() {
    return hasIndAbsentMilitaryWork;
  }

  public boolean getIndAbsentMilitaryWork() {
    if (indAbsentMilitaryWork == null) {
      return false;
    }
    return indAbsentMilitaryWork;
  }

  public Boolean getIndAbsentMilitaryWorkObject() {
    return indAbsentMilitaryWork;
  }

  public String getIndAbsentMilitaryWorkString() {
    if (indAbsentMilitaryWork == null) {
      return "";
    }
    return indAbsentMilitaryWork.toString();
  }

  public void setIndAbsentMilitaryWork(boolean indAbsentMilitaryWork) {
    this.hasIndAbsentMilitaryWork = true;
    this.indAbsentMilitaryWork = indAbsentMilitaryWork;
  }

  public void setIndAbsentMilitaryWork(Boolean indAbsentMilitaryWork) {
    this.hasIndAbsentMilitaryWork = true;
    this.indAbsentMilitaryWork = indAbsentMilitaryWork;
  }

  public void setIndAbsentMilitaryWork(String indAbsentMilitaryWork) {
    this.hasIndAbsentMilitaryWork = true;
    this.indAbsentMilitaryWork = isTrueBoolean(indAbsentMilitaryWork);
  }

  public boolean hasIndAbsentMother() {
    return hasIndAbsentMother;
  }

  public boolean getIndAbsentMother() {
    if (indAbsentMother == null) {
      return false;
    }
    return indAbsentMother;
  }

  public Boolean getIndAbsentMotherObject() {
    return indAbsentMother;
  }

  public String getIndAbsentMotherString() {
    if (indAbsentMother == null) {
      return "";
    }
    return indAbsentMother.toString();
  }

  public void setIndAbsentMother(boolean indAbsentMother) {
    this.hasIndAbsentMother = true;
    this.indAbsentMother = indAbsentMother;
  }

  public void setIndAbsentMother(Boolean indAbsentMother) {
    this.hasIndAbsentMother = true;
    this.indAbsentMother = indAbsentMother;
  }

  public void setIndAbsentMother(String indAbsentMother) {
    this.hasIndAbsentMother = true;
    this.indAbsentMother = isTrueBoolean(indAbsentMother);
  }

  public boolean hasIndAbsentSeparated() {
    return hasIndAbsentSeparated;
  }

  public boolean getIndAbsentSeparated() {
    if (indAbsentSeparated == null) {
      return false;
    }
    return indAbsentSeparated;
  }

  public Boolean getIndAbsentSeparatedObject() {
    return indAbsentSeparated;
  }

  public String getIndAbsentSeparatedString() {
    if (indAbsentSeparated == null) {
      return "";
    }
    return indAbsentSeparated.toString();
  }

  public void setIndAbsentSeparated(boolean indAbsentSeparated) {
    this.hasIndAbsentSeparated = true;
    this.indAbsentSeparated = indAbsentSeparated;
  }

  public void setIndAbsentSeparated(Boolean indAbsentSeparated) {
    this.hasIndAbsentSeparated = true;
    this.indAbsentSeparated = indAbsentSeparated;
  }

  public void setIndAbsentSeparated(String indAbsentSeparated) {
    this.hasIndAbsentSeparated = true;
    this.indAbsentSeparated = isTrueBoolean(indAbsentSeparated);
  }

  public boolean hasIndAbsentWorkRelated() {
    return hasIndAbsentWorkRelated;
  }

  public boolean getIndAbsentWorkRelated() {
    if (indAbsentWorkRelated == null) {
      return false;
    }
    return indAbsentWorkRelated;
  }

  public Boolean getIndAbsentWorkRelatedObject() {
    return indAbsentWorkRelated;
  }

  public String getIndAbsentWorkRelatedString() {
    if (indAbsentWorkRelated == null) {
      return "";
    }
    return indAbsentWorkRelated.toString();
  }

  public void setIndAbsentWorkRelated(boolean indAbsentWorkRelated) {
    this.hasIndAbsentWorkRelated = true;
    this.indAbsentWorkRelated = indAbsentWorkRelated;
  }

  public void setIndAbsentWorkRelated(Boolean indAbsentWorkRelated) {
    this.hasIndAbsentWorkRelated = true;
    this.indAbsentWorkRelated = indAbsentWorkRelated;
  }

  public void setIndAbsentWorkRelated(String indAbsentWorkRelated) {
    this.hasIndAbsentWorkRelated = true;
    this.indAbsentWorkRelated = isTrueBoolean(indAbsentWorkRelated);
  }

  public boolean hasIndChildLivingPrnt6Mnths() {
    return hasIndChildLivingPrnt6Mnths;
  }

  public boolean getIndChildLivingPrnt6Mnths() {
    if (indChildLivingPrnt6Mnths == null) {
      return false;
    }
    return indChildLivingPrnt6Mnths;
  }

  public Boolean getIndChildLivingPrnt6MnthsObject() {
    return indChildLivingPrnt6Mnths;
  }

  public String getIndChildLivingPrnt6MnthsString() {
    if (indChildLivingPrnt6Mnths == null) {
      return "";
    }
    return indChildLivingPrnt6Mnths.toString();
  }

  public void setIndChildLivingPrnt6Mnths(boolean indChildLivingPrnt6Mnths) {
    this.hasIndChildLivingPrnt6Mnths = true;
    this.indChildLivingPrnt6Mnths = indChildLivingPrnt6Mnths;
  }

  public void setIndChildLivingPrnt6Mnths(Boolean indChildLivingPrnt6Mnths) {
    this.hasIndChildLivingPrnt6Mnths = true;
    this.indChildLivingPrnt6Mnths = indChildLivingPrnt6Mnths;
  }

  public void setIndChildLivingPrnt6Mnths(String indChildLivingPrnt6Mnths) {
    this.hasIndChildLivingPrnt6Mnths = true;
    this.indChildLivingPrnt6Mnths = isTrueBoolean(indChildLivingPrnt6Mnths);
  }

  public boolean hasIndChildQualifiedCitizen() {
    return hasIndChildQualifiedCitizen;
  }

  public boolean getIndChildQualifiedCitizen() {
    if (indChildQualifiedCitizen == null) {
      return false;
    }
    return indChildQualifiedCitizen;
  }

  public Boolean getIndChildQualifiedCitizenObject() {
    return indChildQualifiedCitizen;
  }

  public String getIndChildQualifiedCitizenString() {
    if (indChildQualifiedCitizen == null) {
      return "";
    }
    return indChildQualifiedCitizen.toString();
  }

  public void setIndChildQualifiedCitizen(boolean indChildQualifiedCitizen) {
    this.hasIndChildQualifiedCitizen = true;
    this.indChildQualifiedCitizen = indChildQualifiedCitizen;
  }

  public void setIndChildQualifiedCitizen(Boolean indChildQualifiedCitizen) {
    this.hasIndChildQualifiedCitizen = true;
    this.indChildQualifiedCitizen = indChildQualifiedCitizen;
  }

  public void setIndChildQualifiedCitizen(String indChildQualifiedCitizen) {
    this.hasIndChildQualifiedCitizen = true;
    this.indChildQualifiedCitizen = isTrueBoolean(indChildQualifiedCitizen);
  }

  public boolean hasIndChildSupportOrdered() {
    return hasIndChildSupportOrdered;
  }

  public boolean getIndChildSupportOrdered() {
    if (indChildSupportOrdered == null) {
      return false;
    }
    return indChildSupportOrdered;
  }

  public Boolean getIndChildSupportOrderedObject() {
    return indChildSupportOrdered;
  }

  public String getIndChildSupportOrderedString() {
    if (indChildSupportOrdered == null) {
      return "";
    }
    return indChildSupportOrdered.toString();
  }

  public void setIndChildSupportOrdered(boolean indChildSupportOrdered) {
    this.hasIndChildSupportOrdered = true;
    this.indChildSupportOrdered = indChildSupportOrdered;
  }

  public void setIndChildSupportOrdered(Boolean indChildSupportOrdered) {
    this.hasIndChildSupportOrdered = true;
    this.indChildSupportOrdered = indChildSupportOrdered;
  }

  public void setIndChildSupportOrdered(String indChildSupportOrdered) {
    this.hasIndChildSupportOrdered = true;
    this.indChildSupportOrdered = isTrueBoolean(indChildSupportOrdered);
  }

  public boolean hasIndChildUnder18() {
    return hasIndChildUnder18;
  }

  public boolean getIndChildUnder18() {
    if (indChildUnder18 == null) {
      return false;
    }
    return indChildUnder18;
  }

  public Boolean getIndChildUnder18Object() {
    return indChildUnder18;
  }

  public String getIndChildUnder18String() {
    if (indChildUnder18 == null) {
      return "";
    }
    return indChildUnder18.toString();
  }

  public void setIndChildUnder18(boolean indChildUnder18) {
    this.hasIndChildUnder18 = true;
    this.indChildUnder18 = indChildUnder18;
  }

  public void setIndChildUnder18(Boolean indChildUnder18) {
    this.hasIndChildUnder18 = true;
    this.indChildUnder18 = indChildUnder18;
  }

  public void setIndChildUnder18(String indChildUnder18) {
    this.hasIndChildUnder18 = true;
    this.indChildUnder18 = isTrueBoolean(indChildUnder18);
  }

  public boolean hasIndCtznshpAmerIndianCrd() {
    return hasIndCtznshpAmerIndianCrd;
  }
  
  public boolean getIndCtznshpAmerIndianCrd() {
    if (indCtznshpAmerIndianCrd == null) {
      return false;
    }
    return indCtznshpAmerIndianCrd.booleanValue();
  }

  public Boolean getIndCtznshpAmerIndianCrdObject() {
    return indCtznshpAmerIndianCrd;
  }

  public String getIndCtznshpAmerIndianCrdString() {
    if (indCtznshpAmerIndianCrd == null) {
      return "";
    }
    return indCtznshpAmerIndianCrd.toString();
  }

  public void setIndCtznshpAmerIndianCrd(boolean indCtznshpAmerIndianCrd) {
    this.hasIndCtznshpAmerIndianCrd = true;
    this.indCtznshpAmerIndianCrd = new Boolean(indCtznshpAmerIndianCrd);
  }

  public void setIndCtznshpAmerIndianCrd(Boolean indCtznshpAmerIndianCrd) {
    this.hasIndCtznshpAmerIndianCrd = true;
    this.indCtznshpAmerIndianCrd = indCtznshpAmerIndianCrd;
  }

  public void setIndCtznshpAmerIndianCrd(String indCtznshpAmerIndianCrd) {
    this.hasIndCtznshpAmerIndianCrd = true;
    this.indCtznshpAmerIndianCrd = isTrueBoolean(indCtznshpAmerIndianCrd);
  }

  public boolean hasIndCtznshpAttorneyReview() {
    return hasIndCtznshpAttorneyReview;
  }

  public boolean getIndCtznshpAttorneyReview() {
    if (indCtznshpAttorneyReview == null) {
      return false;
    }
    return indCtznshpAttorneyReview;
  }

  public Boolean getIndCtznshpAttorneyReviewObject() {
    return indCtznshpAttorneyReview;
  }

  public String getIndCtznshpAttorneyReviewString() {
    if (indCtznshpAttorneyReview == null) {
      return "";
    }
    return indCtznshpAttorneyReview.toString();
  }

  public void setIndCtznshpAttorneyReview(boolean indCtznshpAttorneyReview) {
    this.hasIndCtznshpAttorneyReview = true;
    this.indCtznshpAttorneyReview = indCtznshpAttorneyReview;
  }

  public void setIndCtznshpAttorneyReview(Boolean indCtznshpAttorneyReview) {
    this.hasIndCtznshpAttorneyReview = true;
    this.indCtznshpAttorneyReview = indCtznshpAttorneyReview;
  }

  public void setIndCtznshpAttorneyReview(String indCtznshpAttorneyReview) {
    this.hasIndCtznshpAttorneyReview = true;
    this.indCtznshpAttorneyReview = isTrueBoolean(indCtznshpAttorneyReview);
  }

  public boolean hasIndCtznshpBirthCrtfctFor() {
    return hasIndCtznshpBirthCrtfctFor;
  }

  public boolean getIndCtznshpBirthCrtfctFor() {
    if (indCtznshpBirthCrtfctFor == null) {
      return false;
    }
    return indCtznshpBirthCrtfctFor;
  }

  public Boolean getIndCtznshpBirthCrtfctForObject() {
    return indCtznshpBirthCrtfctFor;
  }

  public String getIndCtznshpBirthCrtfctForString() {
    if (indCtznshpBirthCrtfctFor == null) {
      return "";
    }
    return indCtznshpBirthCrtfctFor.toString();
  }

  public void setIndCtznshpBirthCrtfctFor(boolean indCtznshpBirthCrtfctFor) {
    this.hasIndCtznshpBirthCrtfctFor = true;
    this.indCtznshpBirthCrtfctFor = indCtznshpBirthCrtfctFor;
  }

  public void setIndCtznshpBirthCrtfctFor(Boolean indCtznshpBirthCrtfctFor) {
    this.hasIndCtznshpBirthCrtfctFor = true;
    this.indCtznshpBirthCrtfctFor = indCtznshpBirthCrtfctFor;
  }

  public void setIndCtznshpBirthCrtfctFor(String indCtznshpBirthCrtfctFor) {
    this.hasIndCtznshpBirthCrtfctFor = true;
    this.indCtznshpBirthCrtfctFor = isTrueBoolean(indCtznshpBirthCrtfctFor);
  }

  public boolean hasIndCtznshpBirthCrtfctUs() {
    return hasIndCtznshpBirthCrtfctUs;
  }

  public boolean getIndCtznshpBirthCrtfctUs() {
    if (indCtznshpBirthCrtfctUs == null) {
      return false;
    }
    return indCtznshpBirthCrtfctUs;
  }

  public Boolean getIndCtznshpBirthCrtfctUsObject() {
    return indCtznshpBirthCrtfctUs;
  }

  public String getIndCtznshpBirthCrtfctUsString() {
    if (indCtznshpBirthCrtfctUs == null) {
      return "";
    }
    return indCtznshpBirthCrtfctUs.toString();
  }

  public void setIndCtznshpBirthCrtfctUs(boolean indCtznshpBirthCrtfctUs) {
    this.hasIndCtznshpBirthCrtfctUs = true;
    this.indCtznshpBirthCrtfctUs = indCtznshpBirthCrtfctUs;
  }

  public void setIndCtznshpBirthCrtfctUs(Boolean indCtznshpBirthCrtfctUs) {
    this.hasIndCtznshpBirthCrtfctUs = true;
    this.indCtznshpBirthCrtfctUs = indCtznshpBirthCrtfctUs;
  }

  public void setIndCtznshpBirthCrtfctUs(String indCtznshpBirthCrtfctUs) {
    this.hasIndCtznshpBirthCrtfctUs = true;
    this.indCtznshpBirthCrtfctUs = isTrueBoolean(indCtznshpBirthCrtfctUs);
  }

  public boolean hasIndCtznshpChldFound() {
    return hasIndCtznshpChldFound;
  }

  public boolean getIndCtznshpChldFound() {
    if (indCtznshpChldFound == null) {
      return false;
    }
    return indCtznshpChldFound;
  }

  public Boolean getIndCtznshpChldFoundObject() {
    return indCtznshpChldFound;
  }

  public String getIndCtznshpChldFoundString() {
    if (indCtznshpChldFound == null) {
      return "";
    }
    return indCtznshpChldFound.toString();
  }

  public void setIndCtznshpChldFound(boolean indCtznshpChldFound) {
    this.hasIndCtznshpChldFound = true;
    this.indCtznshpChldFound = indCtznshpChldFound;
  }

  public void setIndCtznshpChldFound(Boolean indCtznshpChldFound) {
    this.hasIndCtznshpChldFound = true;
    this.indCtznshpChldFound = indCtznshpChldFound;
  }

  public void setIndCtznshpChldFound(String indCtznshpChldFound) {
    this.hasIndCtznshpChldFound = true;
    this.indCtznshpChldFound = isTrueBoolean(indCtznshpChldFound);
  }

  public boolean hasIndCtznshpCitizenCrtfct() {
    return hasIndCtznshpCitizenCrtfct;
  }

  public boolean getIndCtznshpCitizenCrtfct() {
    if (indCtznshpCitizenCrtfct == null) {
      return false;
    }
    return indCtznshpCitizenCrtfct;
  }

  public Boolean getIndCtznshpCitizenCrtfctObject() {
    return indCtznshpCitizenCrtfct;
  }

  public String getIndCtznshpCitizenCrtfctString() {
    if (indCtznshpCitizenCrtfct == null) {
      return "";
    }
    return indCtznshpCitizenCrtfct.toString();
  }

  public void setIndCtznshpCitizenCrtfct(boolean indCtznshpCitizenCrtfct) {
    this.hasIndCtznshpCitizenCrtfct = true;
    this.indCtznshpCitizenCrtfct = indCtznshpCitizenCrtfct;
  }

  public void setIndCtznshpCitizenCrtfct(Boolean indCtznshpCitizenCrtfct) {
    this.hasIndCtznshpCitizenCrtfct = true;
    this.indCtznshpCitizenCrtfct = indCtznshpCitizenCrtfct;
  }

  public void setIndCtznshpCitizenCrtfct(String indCtznshpCitizenCrtfct) {
    this.hasIndCtznshpCitizenCrtfct = true;
    this.indCtznshpCitizenCrtfct = isTrueBoolean(indCtznshpCitizenCrtfct);
  }

  public boolean hasIndCtznshpEvaluation() {
    return hasIndCtznshpEvaluation;
  }

  public boolean getIndCtznshpEvaluation() {
    if (indCtznshpEvaluation == null) {
      return false;
    }
    return indCtznshpEvaluation;
  }

  public Boolean getIndCtznshpEvaluationObject() {
    return indCtznshpEvaluation;
  }

  public String getIndCtznshpEvaluationString() {
    if (indCtznshpEvaluation == null) {
      return "";
    }
    return indCtznshpEvaluation.toString();
  }

  public void setIndCtznshpEvaluation(boolean indCtznshpEvaluation) {
    this.hasIndCtznshpEvaluation = true;
    this.indCtznshpEvaluation = indCtznshpEvaluation;
  }

  public void setIndCtznshpEvaluation(Boolean indCtznshpEvaluation) {
    this.hasIndCtznshpEvaluation = true;
    this.indCtznshpEvaluation = indCtznshpEvaluation;
  }

  public void setIndCtznshpEvaluation(String indCtznshpEvaluation) {
    this.hasIndCtznshpEvaluation = true;
    this.indCtznshpEvaluation = isTrueBoolean(indCtznshpEvaluation);
  }

  public boolean hasIndCtznshpForDocumentation() {
    return hasIndCtznshpForDocumentation;
  }

  public boolean getIndCtznshpForDocumentation() {
    if (indCtznshpForDocumentation == null) {
      return false;
    }
    return indCtznshpForDocumentation;
  }

  public Boolean getIndCtznshpForDocumentationObject() {
    return indCtznshpForDocumentation;
  }

  public String getIndCtznshpForDocumentationString() {
    if (indCtznshpForDocumentation == null) {
      return "";
    }
    return indCtznshpForDocumentation.toString();
  }

  public void setIndCtznshpForDocumentation(boolean indCtznshpForDocumentation) {
    this.hasIndCtznshpForDocumentation = true;
    this.indCtznshpForDocumentation = indCtznshpForDocumentation;
  }

  public void setIndCtznshpForDocumentation(Boolean indCtznshpForDocumentation) {
    this.hasIndCtznshpForDocumentation = true;
    this.indCtznshpForDocumentation = indCtznshpForDocumentation;
  }

  public void setIndCtznshpForDocumentation(String indCtznshpForDocumentation) {
    this.hasIndCtznshpForDocumentation = true;
    this.indCtznshpForDocumentation = isTrueBoolean(indCtznshpForDocumentation);
  }

  public boolean hasIndCtznshpHospitalCrtfct() {
    return hasIndCtznshpHospitalCrtfct;
  }

  public boolean getIndCtznshpHospitalCrtfct() {
    if (indCtznshpHospitalCrtfct == null) {
      return false;
    }
    return indCtznshpHospitalCrtfct;
  }

  public Boolean getIndCtznshpHospitalCrtfctObject() {
    return indCtznshpHospitalCrtfct;
  }

  public String getIndCtznshpHospitalCrtfctString() {
    if (indCtznshpHospitalCrtfct == null) {
      return "";
    }
    return indCtznshpHospitalCrtfct.toString();
  }

  public void setIndCtznshpHospitalCrtfct(boolean indCtznshpHospitalCrtfct) {
    this.hasIndCtznshpHospitalCrtfct = true;
    this.indCtznshpHospitalCrtfct = indCtznshpHospitalCrtfct;
  }

  public void setIndCtznshpHospitalCrtfct(Boolean indCtznshpHospitalCrtfct) {
    this.hasIndCtznshpHospitalCrtfct = true;
    this.indCtznshpHospitalCrtfct = indCtznshpHospitalCrtfct;
  }

  public void setIndCtznshpHospitalCrtfct(String indCtznshpHospitalCrtfct) {
    this.hasIndCtznshpHospitalCrtfct = true;
    this.indCtznshpHospitalCrtfct = isTrueBoolean(indCtznshpHospitalCrtfct);
  }

  public boolean hasIndCtznshpNoDocumentation() {
    return hasIndCtznshpNoDocumentation;
  }

  public boolean getIndCtznshpNoDocumentation() {
    if (indCtznshpNoDocumentation == null) {
      return false;
    }
    return indCtznshpNoDocumentation;
  }

  public Boolean getIndCtznshpNoDocumentationObject() {
    return indCtznshpNoDocumentation;
  }

  public String getIndCtznshpNoDocumentationString() {
    if (indCtznshpNoDocumentation == null) {
      return "";
    }
    return indCtznshpNoDocumentation.toString();
  }

  public void setIndCtznshpNoDocumentation(boolean indCtznshpNoDocumentation) {
    this.hasIndCtznshpNoDocumentation = true;
    this.indCtznshpNoDocumentation = indCtznshpNoDocumentation;
  }

  public void setIndCtznshpNoDocumentation(Boolean indCtznshpNoDocumentation) {
    this.hasIndCtznshpNoDocumentation = true;
    this.indCtznshpNoDocumentation = indCtznshpNoDocumentation;
  }

  public void setIndCtznshpNoDocumentation(String indCtznshpNoDocumentation) {
    this.hasIndCtznshpNoDocumentation = true;
    this.indCtznshpNoDocumentation = isTrueBoolean(indCtznshpNoDocumentation);
  }

  public boolean hasIndCtznshpNtrlztnCrtfct() {
    return hasIndCtznshpNtrlztnCrtfct;
  }

  public boolean getIndCtznshpNtrlztnCrtfct() {
    if (indCtznshpNtrlztnCrtfct == null) {
      return false;
    }
    return indCtznshpNtrlztnCrtfct;
  }

  public Boolean getIndCtznshpNtrlztnCrtfctObject() {
    return indCtznshpNtrlztnCrtfct;
  }

  public String getIndCtznshpNtrlztnCrtfctString() {
    if (indCtznshpNtrlztnCrtfct == null) {
      return "";
    }
    return indCtznshpNtrlztnCrtfct.toString();
  }

  public void setIndCtznshpNtrlztnCrtfct(boolean indCtznshpNtrlztnCrtfct) {
    this.hasIndCtznshpNtrlztnCrtfct = true;
    this.indCtznshpNtrlztnCrtfct = indCtznshpNtrlztnCrtfct;
  }

  public void setIndCtznshpNtrlztnCrtfct(Boolean indCtznshpNtrlztnCrtfct) {
    this.hasIndCtznshpNtrlztnCrtfct = true;
    this.indCtznshpNtrlztnCrtfct = indCtznshpNtrlztnCrtfct;
  }

  public void setIndCtznshpNtrlztnCrtfct(String indCtznshpNtrlztnCrtfct) {
    this.hasIndCtznshpNtrlztnCrtfct = true;
    this.indCtznshpNtrlztnCrtfct = isTrueBoolean(indCtznshpNtrlztnCrtfct);
  }

  public boolean hasIndCtznshpPassport() {
    return hasIndCtznshpPassport;
  }

  public boolean getIndCtznshpPassport() {
    if (indCtznshpPassport == null) {
      return false;
    }
    return indCtznshpPassport;
  }

  public Boolean getIndCtznshpPassportObject() {
    return indCtznshpPassport;
  }

  public String getIndCtznshpPassportString() {
    if (indCtznshpPassport == null) {
      return "";
    }
    return indCtznshpPassport.toString();
  }

  public void setIndCtznshpPassport(boolean indCtznshpPassport) {
    this.hasIndCtznshpPassport = true;
    this.indCtznshpPassport = indCtznshpPassport;
  }

  public void setIndCtznshpPassport(Boolean indCtznshpPassport) {
    this.hasIndCtznshpPassport = true;
    this.indCtznshpPassport = indCtznshpPassport;
  }

  public void setIndCtznshpPassport(String indCtznshpPassport) {
    this.hasIndCtznshpPassport = true;
    this.indCtznshpPassport = isTrueBoolean(indCtznshpPassport);
  }

  public boolean hasIndCtznshpResidentCard() {
    return hasIndCtznshpResidentCard;
  }

  public boolean getIndCtznshpResidentCard() {
    if (indCtznshpResidentCard == null) {
      return false;
    }
    return indCtznshpResidentCard;
  }

  public Boolean getIndCtznshpResidentCardObject() {
    return indCtznshpResidentCard;
  }

  public String getIndCtznshpResidentCardString() {
    if (indCtznshpResidentCard == null) {
      return "";
    }
    return indCtznshpResidentCard.toString();
  }

  public void setIndCtznshpResidentCard(boolean indCtznshpResidentCard) {
    this.hasIndCtznshpResidentCard = true;
    this.indCtznshpResidentCard = indCtznshpResidentCard;
  }

  public void setIndCtznshpResidentCard(Boolean indCtznshpResidentCard) {
    this.hasIndCtznshpResidentCard = true;
    this.indCtznshpResidentCard = indCtznshpResidentCard;
  }

  public void setIndCtznshpResidentCard(String indCtznshpResidentCard) {
    this.hasIndCtznshpResidentCard = true;
    this.indCtznshpResidentCard = isTrueBoolean(indCtznshpResidentCard);
  }

  public boolean hasIndCtznshpUnaccMinorChild() {
    return hasIndCtznshpUnaccMinorChild;
  }
  
  public boolean getIndCtznshpUnaccMinorChild() {
    if (indCtznshpUnaccMinorChild == null) {
      return false;
    }
    return indCtznshpUnaccMinorChild.booleanValue();
  }

  public Boolean getIndCtznshpUnaccMinorChildObject() {
    return indCtznshpUnaccMinorChild;
  }

  public String getIndCtznshpUnaccMinorChildString() {
    if (indCtznshpUnaccMinorChild == null) {
      return "";
    }
    return indCtznshpUnaccMinorChild.toString();
  }

  public void setIndCtznshpUnaccMinorChild(boolean indCtznshpUnaccMinorChild) {
    this.hasIndCtznshpUnaccMinorChild = true;
    this.indCtznshpUnaccMinorChild = new Boolean(indCtznshpUnaccMinorChild);
  }

  public void setIndCtznshpUnaccMinorChild(Boolean indCtznshpUnaccMinorChild) {
    this.hasIndCtznshpUnaccMinorChild = true;
    this.indCtznshpUnaccMinorChild = indCtznshpUnaccMinorChild;
  }

  public void setIndCtznshpUnaccMinorChild(String indCtznshpUnaccMinorChild) {
    this.hasIndCtznshpUnaccMinorChild = true;
    this.indCtznshpUnaccMinorChild = isTrueBoolean(indCtznshpUnaccMinorChild);
  }

  public boolean hasIndCtznshpUndocImmigrant() {
    return hasIndCtznshpUndocImmigrant;
  }
  
  public boolean getIndCtznshpUndocImmigrant() {
    if (indCtznshpUndocImmigrant == null) {
      return false;
    }
    return indCtznshpUndocImmigrant.booleanValue();
  }

  public Boolean getIndCtznshpUndocImmigrantObject() {
    return indCtznshpUndocImmigrant;
  }

  public String getIndCtznshpUndocImmigrantString() {
    if (indCtznshpUndocImmigrant == null) {
      return "";
    }
    return indCtznshpUndocImmigrant.toString();
  }

  public void setIndCtznshpUndocImmigrant(boolean indCtznshpUndocImmigrant) {
    this.hasIndCtznshpUndocImmigrant = true;
    this.indCtznshpUndocImmigrant = new Boolean(indCtznshpUndocImmigrant);
  }

  public void setIndCtznshpUndocImmigrant(Boolean indCtznshpUndocImmigrant) {
    this.hasIndCtznshpUndocImmigrant = true;
    this.indCtznshpUndocImmigrant = indCtznshpUndocImmigrant;
  }

  public void setIndCtznshpUndocImmigrant(String indCtznshpUndocImmigrant) {
    this.hasIndCtznshpUndocImmigrant = true;
    this.indCtznshpUndocImmigrant = isTrueBoolean(indCtznshpUndocImmigrant);
  }

  public boolean hasIndCtznshpUsHsptlBrthRcrd() {
    return hasIndCtznshpUsHsptlBrthRcrd;
  }
  
  public boolean getIndCtznshpUsHsptlBrthRcrd() {
    if (indCtznshpUsHsptlBrthRcrd == null) {
      return false;
    }
    return indCtznshpUsHsptlBrthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpUsHsptlBrthRcrdObject() {
    return indCtznshpUsHsptlBrthRcrd;
  }

  public String getIndCtznshpUsHsptlBrthRcrdString() {
    if (indCtznshpUsHsptlBrthRcrd == null) {
      return "";
    }
    return indCtznshpUsHsptlBrthRcrd.toString();
  }

  public void setIndCtznshpUsHsptlBrthRcrd(boolean indCtznshpUsHsptlBrthRcrd) {
    this.hasIndCtznshpUsHsptlBrthRcrd = true;
    this.indCtznshpUsHsptlBrthRcrd = new Boolean(indCtznshpUsHsptlBrthRcrd);
  }
  
  public void setIndCtznshpUsHsptlBrthRcrd(Boolean indCtznshpUsHsptlBrthRcrd) {
    this.hasIndCtznshpUsHsptlBrthRcrd = true;
    this.indCtznshpUsHsptlBrthRcrd = indCtznshpUsHsptlBrthRcrd;
  }
  
  public void setIndCtznshpUsHsptlBrthRcrd(String indCtznshpUsHsptlBrthRcrd) {
    this.hasIndCtznshpUsHsptlBrthRcrd = true;
    this.indCtznshpUsHsptlBrthRcrd = isTrueBoolean(indCtznshpUsHsptlBrthRcrd);
  }
  
  public boolean hasIndCtznshpUsIdCard() {
    return hasIndCtznshpUsIdCard;
  }
  
  public boolean getIndCtznshpUsIdCard() {
    if (indCtznshpUsIdCard == null) {
      return false;
    }
    return indCtznshpUsIdCard.booleanValue();
  }
  
  public Boolean getIndCtznshpUsIdCardObject() {
    return indCtznshpUsIdCard;
  }
  
  public String getIndCtznshpUsIdCardString() {
    if (indCtznshpUsIdCard == null) {
      return "";
    }
    return indCtznshpUsIdCard.toString();
  }
  
  public void setIndCtznshpUsIdCard(boolean indCtznshpUsIdCard) {
    this.hasIndCtznshpUsIdCard = true;
    this.indCtznshpUsIdCard = new Boolean(indCtznshpUsIdCard);
  }
  
  public void setIndCtznshpUsIdCard(Boolean indCtznshpUsIdCard) {
    this.hasIndCtznshpUsIdCard = true;
    this.indCtznshpUsIdCard = indCtznshpUsIdCard;
  }
  
  public void setIndCtznshpUsIdCard(String indCtznshpUsIdCard) {
    this.hasIndCtznshpUsIdCard = true;
    this.indCtznshpUsIdCard = isTrueBoolean(indCtznshpUsIdCard);
  }
  
  public boolean hasIndCtznshpVitalBirthRcrd() {
    return hasIndCtznshpVitalBirthRcrd;
  }
  
  public boolean getIndCtznshpVitalBirthRcrd() {
    if (indCtznshpVitalBirthRcrd == null) {
      return false;
    }
    return indCtznshpVitalBirthRcrd.booleanValue();
  }
  
  public Boolean getIndCtznshpVitalBirthRcrdObject() {
    return indCtznshpVitalBirthRcrd;
  }
  
  public String getIndCtznshpVitalBirthRcrdString() {
    if (indCtznshpVitalBirthRcrd == null) {
      return "";
    }
    return indCtznshpVitalBirthRcrd.toString();
  }
  
  public void setIndCtznshpVitalBirthRcrd(boolean indCtznshpVitalBirthRcrd) {
    this.hasIndCtznshpVitalBirthRcrd = true;
    this.indCtznshpVitalBirthRcrd = new Boolean(indCtznshpVitalBirthRcrd);
  }
  
  public void setIndCtznshpVitalBirthRcrd(Boolean indCtznshpVitalBirthRcrd) {
    this.hasIndCtznshpVitalBirthRcrd = true;
    this.indCtznshpVitalBirthRcrd = indCtznshpVitalBirthRcrd;
  }
  
  public void setIndCtznshpVitalBirthRcrd(String indCtznshpVitalBirthRcrd) {
    this.hasIndCtznshpVitalBirthRcrd = true;
    this.indCtznshpVitalBirthRcrd = isTrueBoolean(indCtznshpVitalBirthRcrd);
  }
  
  public boolean hasIndCtznshpDriverLicOrId() {
    return hasIndCtznshpDriverLicOrId;
  }
  
  public boolean getIndCtznshpDriverLicOrId() {
    if (indCtznshpDriverLicOrId == null) {
      return false;
    }
    return indCtznshpDriverLicOrId.booleanValue();
  }
  
  public Boolean getIndCtznshpDriverLicOrIdObject() {
    return indCtznshpDriverLicOrId;
  }
  
  public String getIndCtznshpDriverLicOrIdString() {
    if (indCtznshpDriverLicOrId == null) {
      return "";
    }
    return indCtznshpDriverLicOrId.toString();
  }
  
  public void setIndCtznshpDriverLicOrId(boolean indCtznshpDriverLicOrId) {
    this.hasIndCtznshpDriverLicOrId = true;
    this.indCtznshpDriverLicOrId = new Boolean(indCtznshpDriverLicOrId);
  }
  
  public void setIndCtznshpDriverLicOrId(Boolean indCtznshpDriverLicOrId) {
    this.hasIndCtznshpDriverLicOrId = true;
    this.indCtznshpDriverLicOrId = indCtznshpDriverLicOrId;
  }
  
  public void setIndCtznshpDriverLicOrId(String indCtznshpDriverLicOrId) {
    this.hasIndCtznshpDriverLicOrId = true;
    this.indCtznshpDriverLicOrId = isTrueBoolean(indCtznshpDriverLicOrId);
  }
  
  public boolean hasIndCtznshpCertIndBlood() {
    return hasIndCtznshpCertIndBlood;
  }
  
  public boolean getIndCtznshpCertIndBlood() {
    if (indCtznshpCertIndBlood == null) {
      return false;
    }
    return indCtznshpCertIndBlood.booleanValue();
  }
  
  public Boolean getIndCtznshpCertIndBloodObject() {
    return indCtznshpCertIndBlood;
  }
  
  public String getIndCtznshpCertIndBloodString() {
    if (indCtznshpCertIndBlood == null) {
      return "";
    }
    return indCtznshpCertIndBlood.toString();
  }
  
  public void setIndCtznshpCertIndBlood(boolean indCtznshpCertIndBlood) {
    this.hasIndCtznshpCertIndBlood = true;
    this.indCtznshpCertIndBlood = new Boolean(indCtznshpCertIndBlood);
  }
  
  public void setIndCtznshpCertIndBlood(Boolean indCtznshpCertIndBlood) {
    this.hasIndCtznshpCertIndBlood = true;
    this.indCtznshpCertIndBlood = indCtznshpCertIndBlood;
  }
  
  public void setIndCtznshpCertIndBlood(String indCtznshpCertIndBlood) {
    this.hasIndCtznshpCertIndBlood = true;
    this.indCtznshpCertIndBlood = isTrueBoolean(indCtznshpCertIndBlood);
  }  
  
  public boolean hasIndCtznshpDocImmigNatAct() {
    return hasIndCtznshpDocImmigNatAct;
  }
  
  public boolean getIndCtznshpDocImmigNatAct() {
    if (indCtznshpDocImmigNatAct == null) {
      return false;
    }
    return indCtznshpDocImmigNatAct.booleanValue();
  }
  
  public Boolean getIndCtznshpDocImmigNatActObject() {
    return indCtznshpDocImmigNatAct;
  }
  
  public String getIndCtznshpDocImmigNatActString() {
    if (indCtznshpDocImmigNatAct == null) {
      return "";
    }
    return indCtznshpDocImmigNatAct.toString();
  }
  
  public void setIndCtznshpDocImmigNatAct(boolean indCtznshpDocImmigNatAct) {
    this.hasIndCtznshpDocImmigNatAct = true;
    this.indCtznshpDocImmigNatAct = new Boolean(indCtznshpDocImmigNatAct);
  }
  
  public void setIndCtznshpDocImmigNatAct(Boolean indCtznshpDocImmigNatAct) {
    this.hasIndCtznshpDocImmigNatAct = true;
    this.indCtznshpDocImmigNatAct = indCtznshpDocImmigNatAct;
  }
  
  public void setIndCtznshpDocImmigNatAct(String indCtznshpDocImmigNatAct) {
    this.hasIndCtznshpDocImmigNatAct = true;
    this.indCtznshpDocImmigNatAct = isTrueBoolean(indCtznshpDocImmigNatAct);
  }  
  
  public boolean hasIndCtznshpSchoolIdPhoto() {
    return hasIndCtznshpSchoolIdPhoto;
  }
  
  public boolean getIndCtznshpSchoolIdPhoto() {
    if (indCtznshpSchoolIdPhoto == null) {
      return false;
    }
    return indCtznshpSchoolIdPhoto.booleanValue();
  }
  
  public Boolean getIndCtznshpSchoolIdPhotoObject() {
    return indCtznshpSchoolIdPhoto;
  }
  
  public String getIndCtznshpSchoolIdPhotoString() {
    if (indCtznshpSchoolIdPhoto == null) {
      return "";
    }
    return indCtznshpSchoolIdPhoto.toString();
  }
  
  public void setIndCtznshpSchoolIdPhoto(boolean indCtznshpSchoolIdPhoto) {
    this.hasIndCtznshpSchoolIdPhoto = true;
    this.indCtznshpSchoolIdPhoto = new Boolean(indCtznshpSchoolIdPhoto);
  }
  
  public void setIndCtznshpSchoolIdPhoto(Boolean indCtznshpSchoolIdPhoto) {
    this.hasIndCtznshpSchoolIdPhoto = true;
    this.indCtznshpSchoolIdPhoto = indCtznshpSchoolIdPhoto;
  }
  
  public void setIndCtznshpSchoolIdPhoto(String indCtznshpSchoolIdPhoto) {
    this.hasIndCtznshpSchoolIdPhoto = true;
    this.indCtznshpSchoolIdPhoto = isTrueBoolean(indCtznshpSchoolIdPhoto);
  }  
  
  public boolean hasIndCtznshpMilitaryDepdntId() {
    return hasIndCtznshpMilitaryDepdntId;
  }
  
  public boolean getIndCtznshpMilitaryDepdntId() {
    if (indCtznshpMilitaryDepdntId == null) {
      return false;
    }
    return indCtznshpMilitaryDepdntId.booleanValue();
  }
  
  public Boolean getIndCtznshpMilitaryDepdntIdObject() {
    return indCtznshpMilitaryDepdntId;
  }
  
  public String getIndCtznshpMilitaryDepdntIdString() {
    if (indCtznshpMilitaryDepdntId == null) {
      return "";
    }
    return indCtznshpMilitaryDepdntId.toString();
  }
  
  public void setIndCtznshpMilitaryDepdntId(boolean indCtznshpMilitaryDepdntId) {
    this.hasIndCtznshpMilitaryDepdntId = true;
    this.indCtznshpMilitaryDepdntId = new Boolean(indCtznshpMilitaryDepdntId);
  }
  
  public void setIndCtznshpMilitaryDepdntId(Boolean indCtznshpMilitaryDepdntId) {
    this.hasIndCtznshpMilitaryDepdntId = true;
    this.indCtznshpMilitaryDepdntId = indCtznshpMilitaryDepdntId;
  }
  
  public void setIndCtznshpMilitaryDepdntId(String indCtznshpMilitaryDepdntId) {
    this.hasIndCtznshpMilitaryDepdntId = true;
    this.indCtznshpMilitaryDepdntId = isTrueBoolean(indCtznshpMilitaryDepdntId);
  }  
  
  public boolean hasIndCtznshpSchoolRec() {
    return hasIndCtznshpSchoolRec;
  }
  
  public boolean getIndCtznshpSchoolRec() {
    if (indCtznshpSchoolRec == null) {
      return false;
    }
    return indCtznshpSchoolRec.booleanValue();
  }
  
  public Boolean getIndCtznshpSchoolRecObject() {
    return indCtznshpSchoolRec;
  }
  
  public String getIndCtznshpSchoolRecString() {
    if (indCtznshpSchoolRec == null) {
      return "";
    }
    return indCtznshpSchoolRec.toString();
  }
  
  public void setIndCtznshpSchoolRec(boolean indCtznshpSchoolRec) {
    this.hasIndCtznshpSchoolRec = true;
    this.indCtznshpSchoolRec = new Boolean(indCtznshpSchoolRec);
  }
  
  public void setIndCtznshpSchoolRec(Boolean indCtznshpSchoolRec) {
    this.hasIndCtznshpSchoolRec = true;
    this.indCtznshpSchoolRec = indCtznshpSchoolRec;
  }
  
  public void setIndCtznshpSchoolRec(String indCtznshpSchoolRec) {
    this.hasIndCtznshpSchoolRec = true;
    this.indCtznshpSchoolRec = isTrueBoolean(indCtznshpSchoolRec);
  } 
  
  public boolean hasIndCtznshpClinicDocHosDoc() {
    return hasIndCtznshpClinicDocHosDoc;
  }
  
  public boolean getIndCtznshpClinicDocHosDoc() {
    if (indCtznshpClinicDocHosDoc == null) {
      return false;
    }
    return indCtznshpClinicDocHosDoc.booleanValue();
  }
  
  public Boolean getIndCtznshpClinicDocHosDocObject() {
    return indCtznshpClinicDocHosDoc;
  }
  
  public String getIndCtznshpClinicDocHosDocString() {
    if (indCtznshpClinicDocHosDoc == null) {
      return "";
    }
    return indCtznshpClinicDocHosDoc.toString();
  }
  
  public void setIndCtznshpClinicDocHosDoc(boolean indCtznshpClinicDocHosDoc) {
    this.hasIndCtznshpClinicDocHosDoc = true;
    this.indCtznshpClinicDocHosDoc = new Boolean(indCtznshpClinicDocHosDoc);
  }
  
  public void setIndCtznshpClinicDocHosDoc(Boolean indCtznshpClinicDocHosDoc) {
    this.hasIndCtznshpClinicDocHosDoc = true;
    this.indCtznshpClinicDocHosDoc = indCtznshpClinicDocHosDoc;
  }
  
  public void setIndCtznshpClinicDocHosDoc(String indCtznshpClinicDocHosDoc) {
    this.hasIndCtznshpClinicDocHosDoc = true;
    this.indCtznshpClinicDocHosDoc = isTrueBoolean(indCtznshpClinicDocHosDoc);
  }
  public boolean hasIndCtznshpDaycareNurseRcrd() {
    return hasIndCtznshpDaycareNurseRcrd;
  }
  
  public boolean getIndCtznshpDaycareNurseRcrd() {
    if (indCtznshpDaycareNurseRcrd == null) {
      return false;
    }
    return indCtznshpDaycareNurseRcrd.booleanValue();
  }
  
  public Boolean getIndCtznshpDaycareNurseRcrdObject() {
    return indCtznshpDaycareNurseRcrd;
  }
  
  public String getIndCtznshpDaycareNurseRcrdString() {
    if (indCtznshpDaycareNurseRcrd == null) {
      return "";
    }
    return indCtznshpDaycareNurseRcrd.toString();
  }
  
  public void setIndCtznshpDaycareNurseRcrd(boolean indCtznshpDaycareNurseRcrd) {
    this.hasIndCtznshpDaycareNurseRcrd = true;
    this.indCtznshpDaycareNurseRcrd = new Boolean(indCtznshpDaycareNurseRcrd);
  }
  
  public void setIndCtznshpDaycareNurseRcrd(Boolean indCtznshpDaycareNurseRcrd) {
    this.hasIndCtznshpDaycareNurseRcrd = true;
    this.indCtznshpDaycareNurseRcrd = indCtznshpDaycareNurseRcrd;
  }
  
  public void setIndCtznshpDaycareNurseRcrd(String indCtznshpDaycareNurseRcrd) {
    this.hasIndCtznshpDaycareNurseRcrd = true;
    this.indCtznshpDaycareNurseRcrd = isTrueBoolean(indCtznshpDaycareNurseRcrd);
  } 
  
  public boolean hasIndCtznshpAffidavitSigned() {
    return hasIndCtznshpAffidavitSigned;
  }
  
  public boolean getIndCtznshpAffidavitSigned() {
    if (indCtznshpAffidavitSigned == null) {
      return false;
    }
    return indCtznshpAffidavitSigned.booleanValue();
  }
  
  public Boolean getIndCtznshpAffidavitSignedObject() {
    return indCtznshpAffidavitSigned;
  }
  
  public String getIndCtznshpAffidavitSignedString() {
    if (indCtznshpAffidavitSigned == null) {
      return "";
    }
    return indCtznshpAffidavitSigned.toString();
  }
  
  public void setIndCtznshpAffidavitSigned(boolean indCtznshpAffidavitSigned) {
    this.hasIndCtznshpAffidavitSigned = true;
    this.indCtznshpAffidavitSigned = new Boolean(indCtznshpAffidavitSigned);
  }
  
  public void setIndCtznshpAffidavitSigned(Boolean indCtznshpAffidavitSigned) {
    this.hasIndCtznshpAffidavitSigned = true;
    this.indCtznshpAffidavitSigned = indCtznshpAffidavitSigned;
  }
  
  public void setIndCtznshpAffidavitSigned(String indCtznshpAffidavitSigned) {
    this.hasIndCtznshpAffidavitSigned = true;
    this.indCtznshpAffidavitSigned = isTrueBoolean(indCtznshpAffidavitSigned);
  } 
  
  public boolean hasIndCtznshpCertReportBirth() {
    return hasIndCtznshpCertReportBirth;
  }

  public boolean getIndCtznshpCertReportBirth() {
    if (indCtznshpCertReportBirth == null) {
      return false;
    }
    return indCtznshpCertReportBirth.booleanValue();
  }

  public Boolean getIndCtznshpCertReportBirthObject() {
    return indCtznshpCertReportBirth;
  }

  public String getIndCtznshpCertReportBirthString() {
    if (indCtznshpCertReportBirth == null) {
      return "";
    }
    return indCtznshpCertReportBirth.toString();
  }

  public void setIndCtznshpCertReportBirth(boolean indCtznshpCertReportBirth) {
    this.hasIndCtznshpCertReportBirth = true;
    this.indCtznshpCertReportBirth = new Boolean(indCtznshpCertReportBirth);
  }

  public void setIndCtznshpCertReportBirth(Boolean indCtznshpCertReportBirth) {
    this.hasIndCtznshpCertReportBirth = true;
    this.indCtznshpCertReportBirth = indCtznshpCertReportBirth;
  }

  public void setIndCtznshpCertReportBirth(String indCtznshpCertReportBirth) {
    this.hasIndCtznshpCertReportBirth = true;
    this.indCtznshpCertReportBirth = isTrueBoolean(indCtznshpCertReportBirth);
  }
  
  public boolean hasIndCtznshpSaveSystem() {
    return hasIndCtznshpSaveSystem;
  }
  
  public boolean getIndCtznshpSaveSystem() {
    if (indCtznshpSaveSystem == null) {
      return false;
    }
    return indCtznshpSaveSystem.booleanValue();
  }
  
  public Boolean getIndCtznshpSaveSystemObject() {
    return indCtznshpSaveSystem;
  }
  
  public String getIndCtznshpSaveSystemString() {
    if (indCtznshpSaveSystem == null) {
      return "";
    }
    return indCtznshpSaveSystem.toString();
  }
  
  public void setIndCtznshpSaveSystem(boolean indCtznshpSaveSystem) {
    this.hasIndCtznshpSaveSystem = true;
    this.indCtznshpSaveSystem = new Boolean(indCtznshpSaveSystem);
  }
  
  public void setIndCtznshpSaveSystem(Boolean indCtznshpSaveSystem) {
    this.hasIndCtznshpSaveSystem = true;
    this.indCtznshpSaveSystem = indCtznshpSaveSystem;
  }
  
  public void setIndCtznshpSaveSystem(String indCtznshpSaveSystem) {
    this.hasIndCtznshpSaveSystem = true;
    this.indCtznshpSaveSystem = isTrueBoolean(indCtznshpSaveSystem);
  }
  
  public boolean hasIndCtznshpStudentVisa() {
    return hasIndCtznshpStudentVisa;
  }
  
  public boolean getIndCtznshpStudentVisa() {
    if (indCtznshpStudentVisa == null) {
      return false;
    }
    return indCtznshpStudentVisa.booleanValue();
  }
  
  public Boolean getIndCtznshpStudentVisaObject() {
    return indCtznshpStudentVisa;
  }
  
  public String getIndCtznshpStudentVisaString() {
    if (indCtznshpStudentVisa == null) {
      return "";
    }
    return indCtznshpStudentVisa.toString();
  }
  
  public void setIndCtznshpStudentVisa(boolean indCtznshpStudentVisa) {
    this.hasIndCtznshpStudentVisa = true;
    this.indCtznshpStudentVisa = new Boolean(indCtznshpStudentVisa);
  }
  
  public void setIndCtznshpStudentVisa(Boolean indCtznshpStudentVisa) {
    this.hasIndCtznshpStudentVisa = true;
    this.indCtznshpStudentVisa = indCtznshpStudentVisa;
  }
  
  public void setIndCtznshpStudentVisa(String indCtznshpStudentVisa) {
    this.hasIndCtznshpStudentVisa = true;
    this.indCtznshpStudentVisa = isTrueBoolean(indCtznshpStudentVisa);
  }

  public boolean hasIndCtznshpSuccessSystem() {
    return hasIndCtznshpSuccessSystem;
  }

  public boolean getIndCtznshpSuccessSystem() {
    if (indCtznshpSuccessSystem == null) {
      return false;
    }
    return indCtznshpSuccessSystem.booleanValue();
  }

  public Boolean getIndCtznshpSuccessSystemObject() {
    return indCtznshpSuccessSystem;
  }

  public String getIndCtznshpSuccessSystemString() {
    if (indCtznshpSuccessSystem == null) {
      return "";
    }
    return indCtznshpSuccessSystem.toString();
  }

  public void setIndCtznshpSuccessSystem(boolean indCtznshpSuccessSystem) {
    this.hasIndCtznshpSuccessSystem = true;
    this.indCtznshpSuccessSystem = new Boolean(indCtznshpSuccessSystem);
  }

  public void setIndCtznshpSuccessSystem(Boolean indCtznshpSuccessSystem) {
    this.hasIndCtznshpSuccessSystem = true;
    this.indCtznshpSuccessSystem = indCtznshpSuccessSystem;
  }

  public void setIndCtznshpSuccessSystem(String indCtznshpSuccessSystem) {
    this.hasIndCtznshpSuccessSystem = true;
    this.indCtznshpSuccessSystem = isTrueBoolean(indCtznshpSuccessSystem);
  }

  public boolean hasIndCtznshpBirthAbroad() {
    return hasIndCtznshpBirthAbroad;
  }
  
  public boolean getIndCtznshpBirthAbroad() {
    if (indCtznshpBirthAbroad == null) {
      return false;
    }
    return indCtznshpBirthAbroad.booleanValue();
  }

  public Boolean getIndCtznshpBirthAbroadObject() {
    return indCtznshpBirthAbroad;
  }

  public String getIndCtznshpBirthAbroadString() {
    if (indCtznshpBirthAbroad == null) {
      return "";
    }
    return indCtznshpBirthAbroad.toString();
  }

  public void setIndCtznshpBirthAbroad(boolean indCtznshpBirthAbroad) {
    this.hasIndCtznshpBirthAbroad = true;
    this.indCtznshpBirthAbroad = new Boolean(indCtznshpBirthAbroad);
  }

  public void setIndCtznshpBirthAbroad(Boolean indCtznshpBirthAbroad) {
    this.hasIndCtznshpBirthAbroad = true;
    this.indCtznshpBirthAbroad = indCtznshpBirthAbroad;
  }

  public void setIndCtznshpBirthAbroad(String indCtznshpBirthAbroad) {
    this.hasIndCtznshpBirthAbroad = true;
    this.indCtznshpBirthAbroad = isTrueBoolean(indCtznshpBirthAbroad);
  }

  public boolean hasIndCtznshpCensusBirthRcrd() {
    return hasIndCtznshpCensusBirthRcrd;
  }
  
  public boolean getIndCtznshpCensusBirthRcrd() {
    if (indCtznshpCensusBirthRcrd == null) {
      return false;
    }
    return indCtznshpCensusBirthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpCensusBirthRcrdObject() {
    return indCtznshpCensusBirthRcrd;
  }

  public String getIndCtznshpCensusBirthRcrdString() {
    if (indCtznshpCensusBirthRcrd == null) {
      return "";
    }
    return indCtznshpCensusBirthRcrd.toString();
  }

  public void setIndCtznshpCensusBirthRcrd(boolean indCtznshpCensusBirthRcrd) {
    this.hasIndCtznshpCensusBirthRcrd = true;
    this.indCtznshpCensusBirthRcrd = new Boolean(indCtznshpCensusBirthRcrd);
  }

  public void setIndCtznshpCensusBirthRcrd(Boolean indCtznshpCensusBirthRcrd) {
    this.hasIndCtznshpCensusBirthRcrd = true;
    this.indCtznshpCensusBirthRcrd = indCtznshpCensusBirthRcrd;
  }

  public void setIndCtznshpCensusBirthRcrd(String indCtznshpCensusBirthRcrd) {
    this.hasIndCtznshpCensusBirthRcrd = true;
    this.indCtznshpCensusBirthRcrd = isTrueBoolean(indCtznshpCensusBirthRcrd);
  }

  public boolean hasIndCtznshpCivilServiceEmp() {
    return hasIndCtznshpCivilServiceEmp;
  }
  
  public boolean getIndCtznshpCivilServiceEmp() {
    if (indCtznshpCivilServiceEmp == null) {
      return false;
    }
    return indCtznshpCivilServiceEmp.booleanValue();
  }

  public Boolean getIndCtznshpCivilServiceEmpObject() {
    return indCtznshpCivilServiceEmp;
  }

  public String getIndCtznshpCivilServiceEmpString() {
    if (indCtznshpCivilServiceEmp == null) {
      return "";
    }
    return indCtznshpCivilServiceEmp.toString();
  }

  public void setIndCtznshpCivilServiceEmp(boolean indCtznshpCivilServiceEmp) {
    this.hasIndCtznshpCivilServiceEmp = true;
    this.indCtznshpCivilServiceEmp = new Boolean(indCtznshpCivilServiceEmp);
  }

  public void setIndCtznshpCivilServiceEmp(Boolean indCtznshpCivilServiceEmp) {
    this.hasIndCtznshpCivilServiceEmp = true;
    this.indCtznshpCivilServiceEmp = indCtznshpCivilServiceEmp;
  }

  public void setIndCtznshpCivilServiceEmp(String indCtznshpCivilServiceEmp) {
    this.hasIndCtznshpCivilServiceEmp = true;
    this.indCtznshpCivilServiceEmp = isTrueBoolean(indCtznshpCivilServiceEmp);
  }

  public boolean hasIndCtznshpConfrmBirth() {
    return hasIndCtznshpConfrmBirth;
  }
  
  public boolean getIndCtznshpConfrmBirth() {
    if (indCtznshpConfrmBirth == null) {
      return false;
    }
    return indCtznshpConfrmBirth.booleanValue();
  }

  public Boolean getIndCtznshpConfrmBirthObject() {
    return indCtznshpConfrmBirth;
  }

  public String getIndCtznshpConfrmBirthString() {
    if (indCtznshpConfrmBirth == null) {
      return "";
    }
    return indCtznshpConfrmBirth.toString();
  }

  public void setIndCtznshpConfrmBirth(boolean indCtznshpConfrmBirth) {
    this.hasIndCtznshpConfrmBirth = true;
    this.indCtznshpConfrmBirth = new Boolean(indCtznshpConfrmBirth);
  }

  public void setIndCtznshpConfrmBirth(Boolean indCtznshpConfrmBirth) {
    this.hasIndCtznshpConfrmBirth = true;
    this.indCtznshpConfrmBirth = indCtznshpConfrmBirth;
  }

  public void setIndCtznshpConfrmBirth(String indCtznshpConfrmBirth) {
    this.hasIndCtznshpConfrmBirth = true;
    this.indCtznshpConfrmBirth = isTrueBoolean(indCtznshpConfrmBirth);
  }

  public boolean hasIndCtznshpFinalAdoptDecree() {
    return hasIndCtznshpFinalAdoptDecree;
  }
  
  public boolean getIndCtznshpFinalAdoptDecree() {
    if (indCtznshpFinalAdoptDecree == null) {
      return false;
    }
    return indCtznshpFinalAdoptDecree.booleanValue();
  }

  public Boolean getIndCtznshpFinalAdoptDecreeObject() {
    return indCtznshpFinalAdoptDecree;
  }

  public String getIndCtznshpFinalAdoptDecreeString() {
    if (indCtznshpFinalAdoptDecree == null) {
      return "";
    }
    return indCtznshpFinalAdoptDecree.toString();
  }

  public void setIndCtznshpFinalAdoptDecree(boolean indCtznshpFinalAdoptDecree) {
    this.hasIndCtznshpFinalAdoptDecree = true;
    this.indCtznshpFinalAdoptDecree = new Boolean(indCtznshpFinalAdoptDecree);
  }

  public void setIndCtznshpFinalAdoptDecree(Boolean indCtznshpFinalAdoptDecree) {
    this.hasIndCtznshpFinalAdoptDecree = true;
    this.indCtznshpFinalAdoptDecree = indCtznshpFinalAdoptDecree;
  }

  public void setIndCtznshpFinalAdoptDecree(String indCtznshpFinalAdoptDecree) {
    this.hasIndCtznshpFinalAdoptDecree = true;
    this.indCtznshpFinalAdoptDecree = isTrueBoolean(indCtznshpFinalAdoptDecree);
  }

  public boolean hasIndCtznshpLeglImmiStatExp() {
    return hasIndCtznshpLeglImmiStatExp;
  }
  
  public boolean getIndCtznshpLeglImmiStatExp() {
    if (indCtznshpLeglImmiStatExp == null) {
      return false;
    }
    return indCtznshpLeglImmiStatExp.booleanValue();
  }

  public Boolean getIndCtznshpLeglImmiStatExpObject() {
    return indCtznshpLeglImmiStatExp;
  }

  public String getIndCtznshpLeglImmiStatExpString() {
    if (indCtznshpLeglImmiStatExp == null) {
      return "";
    }
    return indCtznshpLeglImmiStatExp.toString();
  }

  public void setIndCtznshpLeglImmiStatExp(boolean indCtznshpLeglImmiStatExp) {
    this.hasIndCtznshpLeglImmiStatExp = true;
    this.indCtznshpLeglImmiStatExp = new Boolean(indCtznshpLeglImmiStatExp);
  }

  public void setIndCtznshpLeglImmiStatExp(Boolean indCtznshpLeglImmiStatExp) {
    this.hasIndCtznshpLeglImmiStatExp = true;
    this.indCtznshpLeglImmiStatExp = indCtznshpLeglImmiStatExp;
  }

  public void setIndCtznshpLeglImmiStatExp(String indCtznshpLeglImmiStatExp) {
    this.hasIndCtznshpLeglImmiStatExp = true;
    this.indCtznshpLeglImmiStatExp = isTrueBoolean(indCtznshpLeglImmiStatExp);
  }

  public boolean hasIndCtznshpLifeInsBrthRcrd() {
    return hasIndCtznshpLifeInsBrthRcrd;
  }

  public boolean getIndCtznshpLifeInsBrthRcrd() {
    if (indCtznshpLifeInsBrthRcrd == null) {
      return false;
    }
    return indCtznshpLifeInsBrthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpLifeInsBrthRcrdObject() {
    return indCtznshpLifeInsBrthRcrd;
  }

  public String getIndCtznshpLifeInsBrthRcrdString() {
    if (indCtznshpLifeInsBrthRcrd == null) {
      return "";
    }
    return indCtznshpLifeInsBrthRcrd.toString();
  }

  public void setIndCtznshpLifeInsBrthRcrd(boolean indCtznshpLifeInsBrthRcrd) {
    this.hasIndCtznshpLifeInsBrthRcrd = true;
    this.indCtznshpLifeInsBrthRcrd = new Boolean(indCtznshpLifeInsBrthRcrd);
  }

  public void setIndCtznshpLifeInsBrthRcrd(Boolean indCtznshpLifeInsBrthRcrd) {
    this.hasIndCtznshpLifeInsBrthRcrd = true;
    this.indCtznshpLifeInsBrthRcrd = indCtznshpLifeInsBrthRcrd;
  }

  public void setIndCtznshpLifeInsBrthRcrd(String indCtznshpLifeInsBrthRcrd) {
    this.hasIndCtznshpLifeInsBrthRcrd = true;
    this.indCtznshpLifeInsBrthRcrd = isTrueBoolean(indCtznshpLifeInsBrthRcrd);
  }

  public boolean hasIndCtznshpLoclGovtBrthRcrd() {
    return hasIndCtznshpLoclGovtBrthRcrd;
  }
  
  public boolean getIndCtznshpLoclGovtBrthRcrd() {
    if (indCtznshpLoclGovtBrthRcrd == null) {
      return false;
    }
    return indCtznshpLoclGovtBrthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpLoclGovtBrthRcrdObject() {
    return indCtznshpLoclGovtBrthRcrd;
  }

  public String getIndCtznshpLoclGovtBrthRcrdString() {
    if (indCtznshpLoclGovtBrthRcrd == null) {
      return "";
    }
    return indCtznshpLoclGovtBrthRcrd.toString();
  }

  public void setIndCtznshpLoclGovtBrthRcrd(boolean indCtznshpLoclGovtBrthRcrd) {
    this.hasIndCtznshpLoclGovtBrthRcrd = true;
    this.indCtznshpLoclGovtBrthRcrd = new Boolean(indCtznshpLoclGovtBrthRcrd);
  }

  public void setIndCtznshpLoclGovtBrthRcrd(Boolean indCtznshpLoclGovtBrthRcrd) {
    this.hasIndCtznshpLoclGovtBrthRcrd = true;
    this.indCtznshpLoclGovtBrthRcrd = indCtznshpLoclGovtBrthRcrd;
  }

  public void setIndCtznshpLoclGovtBrthRcrd(String indCtznshpLoclGovtBrthRcrd) {
    this.hasIndCtznshpLoclGovtBrthRcrd = true;
    this.indCtznshpLoclGovtBrthRcrd = isTrueBoolean(indCtznshpLoclGovtBrthRcrd);
  }

  public boolean hasIndCtznshpMedBirthRcrd() {
    return hasIndCtznshpMedBirthRcrd;
  }
  
  public boolean getIndCtznshpMedBirthRcrd() {
    if (indCtznshpMedBirthRcrd == null) {
      return false;
    }
    return indCtznshpMedBirthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpMedBirthRcrdObject() {
    return indCtznshpMedBirthRcrd;
  }

  public String getIndCtznshpMedBirthRcrdString() {
    if (indCtznshpMedBirthRcrd == null) {
      return "";
    }
    return indCtznshpMedBirthRcrd.toString();
  }

  public void setIndCtznshpMedBirthRcrd(boolean indCtznshpMedBirthRcrd) {
    this.hasIndCtznshpMedBirthRcrd = true;
    this.indCtznshpMedBirthRcrd = new Boolean(indCtznshpMedBirthRcrd);
  }

  public void setIndCtznshpMedBirthRcrd(Boolean indCtznshpMedBirthRcrd) {
    this.hasIndCtznshpMedBirthRcrd = true;
    this.indCtznshpMedBirthRcrd = indCtznshpMedBirthRcrd;
  }

  public void setIndCtznshpMedBirthRcrd(String indCtznshpMedBirthRcrd) {
    this.hasIndCtznshpMedBirthRcrd = true;
    this.indCtznshpMedBirthRcrd = isTrueBoolean(indCtznshpMedBirthRcrd);
  }

  public boolean hasIndCtznshpMiltryBirthRcrd() {
    return hasIndCtznshpMiltryBirthRcrd;
  }
  
  public boolean getIndCtznshpMiltryBirthRcrd() {
    if (indCtznshpMiltryBirthRcrd == null) {
      return false;
    }
    return indCtznshpMiltryBirthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpMiltryBirthRcrdObject() {
    return indCtznshpMiltryBirthRcrd;
  }

  public String getIndCtznshpMiltryBirthRcrdString() {
    if (indCtznshpMiltryBirthRcrd == null) {
      return "";
    }
    return indCtznshpMiltryBirthRcrd.toString();
  }

  public void setIndCtznshpMiltryBirthRcrd(boolean indCtznshpMiltryBirthRcrd) {
    this.hasIndCtznshpMiltryBirthRcrd = true;
    this.indCtznshpMiltryBirthRcrd = new Boolean(indCtznshpMiltryBirthRcrd);
  }

  public void setIndCtznshpMiltryBirthRcrd(Boolean indCtznshpMiltryBirthRcrd) {
    this.hasIndCtznshpMiltryBirthRcrd = true;
    this.indCtznshpMiltryBirthRcrd = indCtznshpMiltryBirthRcrd;
  }

  public void setIndCtznshpMiltryBirthRcrd(String indCtznshpMiltryBirthRcrd) {
    this.hasIndCtznshpMiltryBirthRcrd = true;
    this.indCtznshpMiltryBirthRcrd = isTrueBoolean(indCtznshpMiltryBirthRcrd);
  }

  public boolean hasIndCtznshpNorthMarianaId() {
    return hasIndCtznshpNorthMarianaId;
  }
  
  public boolean getIndCtznshpNorthMarianaId() {
    if (indCtznshpNorthMarianaId == null) {
      return false;
    }
    return indCtznshpNorthMarianaId.booleanValue();
  }

  public Boolean getIndCtznshpNorthMarianaIdObject() {
    return indCtznshpNorthMarianaId;
  }

  public String getIndCtznshpNorthMarianaIdString() {
    if (indCtznshpNorthMarianaId == null) {
      return "";
    }
    return indCtznshpNorthMarianaId.toString();
  }

  public void setIndCtznshpNorthMarianaId(boolean indCtznshpNorthMarianaId) {
    this.hasIndCtznshpNorthMarianaId = true;
    this.indCtznshpNorthMarianaId = new Boolean(indCtznshpNorthMarianaId);
  }

  public void setIndCtznshpNorthMarianaId(Boolean indCtznshpNorthMarianaId) {
    this.hasIndCtznshpNorthMarianaId = true;
    this.indCtznshpNorthMarianaId = indCtznshpNorthMarianaId;
  }

  public void setIndCtznshpNorthMarianaId(String indCtznshpNorthMarianaId) {
    this.hasIndCtznshpNorthMarianaId = true;
    this.indCtznshpNorthMarianaId = isTrueBoolean(indCtznshpNorthMarianaId);
  }

  public boolean hasIndCtznshpRefugee() {
    return hasIndCtznshpRefugee;
  }
  
  public boolean getIndCtznshpRefugee() {
    if (indCtznshpRefugee == null) {
      return false;
    }
    return indCtznshpRefugee.booleanValue();
  }

  public Boolean getIndCtznshpRefugeeObject() {
    return indCtznshpRefugee;
  }

  public String getIndCtznshpRefugeeString() {
    if (indCtznshpRefugee == null) {
      return "";
    }
    return indCtznshpRefugee.toString();
  }

  public void setIndCtznshpRefugee(boolean indCtznshpRefugee) {
    this.hasIndCtznshpRefugee = true;
    this.indCtznshpRefugee = new Boolean(indCtznshpRefugee);
  }

  public void setIndCtznshpRefugee(Boolean indCtznshpRefugee) {
    this.hasIndCtznshpRefugee = true;
    this.indCtznshpRefugee = indCtznshpRefugee;
  }

  public void setIndCtznshpRefugee(String indCtznshpRefugee) {
    this.hasIndCtznshpRefugee = true;
    this.indCtznshpRefugee = isTrueBoolean(indCtznshpRefugee);
  }

  public boolean hasIndCtznshpReligBirthRcrd() {
    return hasIndCtznshpReligBirthRcrd;
  }
  
  public boolean getIndCtznshpReligBirthRcrd() {
    if (indCtznshpReligBirthRcrd == null) {
      return false;
    }
    return indCtznshpReligBirthRcrd.booleanValue();
  }

  public Boolean getIndCtznshpReligBirthRcrdObject() {
    return indCtznshpReligBirthRcrd;
  }

  public String getIndCtznshpReligBirthRcrdString() {
    if (indCtznshpReligBirthRcrd == null) {
      return "";
    }
    return indCtznshpReligBirthRcrd.toString();
  }

  public void setIndCtznshpReligBirthRcrd(boolean indCtznshpReligBirthRcrd) {
    this.hasIndCtznshpReligBirthRcrd = true;
    this.indCtznshpReligBirthRcrd = new Boolean(indCtznshpReligBirthRcrd);
  }

  public void setIndCtznshpReligBirthRcrd(Boolean indCtznshpReligBirthRcrd) {
    this.hasIndCtznshpReligBirthRcrd = true;
    this.indCtznshpReligBirthRcrd = indCtznshpReligBirthRcrd;
  }

  public void setIndCtznshpReligBirthRcrd(String indCtznshpReligBirthRcrd) {
    this.hasIndCtznshpReligBirthRcrd = true;
    this.indCtznshpReligBirthRcrd = isTrueBoolean(indCtznshpReligBirthRcrd);
  }

  public boolean hasIndEligibilityCourtMonth() {
    return hasIndEligibilityCourtMonth;
  }

  public boolean getIndEligibilityCourtMonth() {
    if (indEligibilityCourtMonth == null) {
      return false;
    }
    return indEligibilityCourtMonth;
  }

  public Boolean getIndEligibilityCourtMonthObject() {
    return indEligibilityCourtMonth;
  }

  public String getIndEligibilityCourtMonthString() {
    if (indEligibilityCourtMonth == null) {
      return "";
    }
    return indEligibilityCourtMonth.toString();
  }

  public void setIndEligibilityCourtMonth(boolean indEligibilityCourtMonth) {
    this.hasIndEligibilityCourtMonth = true;
    this.indEligibilityCourtMonth = indEligibilityCourtMonth;
  }

  public void setIndEligibilityCourtMonth(Boolean indEligibilityCourtMonth) {
    this.hasIndEligibilityCourtMonth = true;
    this.indEligibilityCourtMonth = indEligibilityCourtMonth;
  }

  public void setIndEligibilityCourtMonth(String indEligibilityCourtMonth) {
    this.hasIndEligibilityCourtMonth = true;
    this.indEligibilityCourtMonth = isTrueBoolean(indEligibilityCourtMonth);
  }

  public boolean hasIndEligible() {
    return hasIndEligible;
  }

  public boolean getIndEligible() {
    if (indEligible == null) {
      return false;
    }
    return indEligible;
  }

  public Boolean getIndEligibleObject() {
    return indEligible;
  }

  public String getIndEligibleString() {
    if (indEligible == null) {
      return "";
    }
    return indEligible.toString();
  }

  public void setIndEligible(boolean indEligible) {
    this.hasIndEligible = true;
    this.indEligible = indEligible;
  }

  public void setIndEligible(Boolean indEligible) {
    this.hasIndEligible = true;
    this.indEligible = indEligible;
  }

  public void setIndEligible(String indEligible) {
    this.hasIndEligible = true;
    this.indEligible = isTrueBoolean(indEligible);
  }

  public boolean hasIndEquity() {
    return hasIndEquity;
  }

  public boolean getIndEquity() {
    if (indEquity == null) {
      return false;
    }
    return indEquity;
  }

  public Boolean getIndEquityObject() {
    return indEquity;
  }

  public String getIndEquityString() {
    if (indEquity == null) {
      return "";
    }
    return indEquity.toString();
  }

  public void setIndEquity(boolean indEquity) {
    this.hasIndEquity = true;
    this.indEquity = indEquity;
  }

  public void setIndEquity(Boolean indEquity) {
    this.hasIndEquity = true;
    this.indEquity = indEquity;
  }

  public void setIndEquity(String indEquity) {
    this.hasIndEquity = true;
    this.indEquity = isTrueBoolean(indEquity);
  }

  public boolean hasIndFatherPwe() {
    return hasIndFatherPwe;
  }

  public boolean getIndFatherPwe() {
    if (indFatherPwe == null) {
      return false;
    }
    return indFatherPwe;
  }

  public Boolean getIndFatherPweObject() {
    return indFatherPwe;
  }

  public String getIndFatherPweString() {
    if (indFatherPwe == null) {
      return "";
    }
    return indFatherPwe.toString();
  }

  public void setIndFatherPwe(boolean indFatherPwe) {
    this.hasIndFatherPwe = true;
    this.indFatherPwe = indFatherPwe;
  }

  public void setIndFatherPwe(Boolean indFatherPwe) {
    this.hasIndFatherPwe = true;
    this.indFatherPwe = indFatherPwe;
  }

  public void setIndFatherPwe(String indFatherPwe) {
    this.hasIndFatherPwe = true;
    this.indFatherPwe = isTrueBoolean(indFatherPwe);
  }

  public boolean hasIndHomeIncomeAfdcElgblty() {
    return hasIndHomeIncomeAfdcElgblty;
  }

  public boolean getIndHomeIncomeAfdcElgblty() {
    if (indHomeIncomeAfdcElgblty == null) {
      return false;
    }
    return indHomeIncomeAfdcElgblty;
  }

  public Boolean getIndHomeIncomeAfdcElgbltyObject() {
    return indHomeIncomeAfdcElgblty;
  }

  public String getIndHomeIncomeAfdcElgbltyString() {
    if (indHomeIncomeAfdcElgblty == null) {
      return "";
    }
    return indHomeIncomeAfdcElgblty.toString();
  }

  public void setIndHomeIncomeAfdcElgblty(boolean indHomeIncomeAfdcElgblty) {
    this.hasIndHomeIncomeAfdcElgblty = true;
    this.indHomeIncomeAfdcElgblty = indHomeIncomeAfdcElgblty;
  }

  public void setIndHomeIncomeAfdcElgblty(Boolean indHomeIncomeAfdcElgblty) {
    this.hasIndHomeIncomeAfdcElgblty = true;
    this.indHomeIncomeAfdcElgblty = indHomeIncomeAfdcElgblty;
  }

  public void setIndHomeIncomeAfdcElgblty(String indHomeIncomeAfdcElgblty) {
    this.hasIndHomeIncomeAfdcElgblty = true;
    this.indHomeIncomeAfdcElgblty = isTrueBoolean(indHomeIncomeAfdcElgblty);
  }

  public boolean hasIndMeetsDpOrNotEs() {
    return hasIndMeetsDpOrNotEs;
  }

  public boolean getIndMeetsDpOrNotEs() {
    if (indMeetsDpOrNotEs == null) {
      return false;
    }
    return indMeetsDpOrNotEs;
  }

  public Boolean getIndMeetsDpOrNotEsObject() {
    return indMeetsDpOrNotEs;
  }

  public String getIndMeetsDpOrNotEsString() {
    if (indMeetsDpOrNotEs == null) {
      return "";
    }
    return indMeetsDpOrNotEs.toString();
  }

  public void setIndMeetsDpOrNotEs(boolean indMeetsDpOrNotEs) {
    this.hasIndMeetsDpOrNotEs = true;
    this.indMeetsDpOrNotEs = indMeetsDpOrNotEs;
  }

  public void setIndMeetsDpOrNotEs(Boolean indMeetsDpOrNotEs) {
    this.hasIndMeetsDpOrNotEs = true;
    this.indMeetsDpOrNotEs = indMeetsDpOrNotEs;
  }

  public void setIndMeetsDpOrNotEs(String indMeetsDpOrNotEs) {
    this.hasIndMeetsDpOrNotEs = true;
    this.indMeetsDpOrNotEs = isTrueBoolean(indMeetsDpOrNotEs);
  }

  public boolean hasIndMeetsDpOrNotSystem() {
    return hasIndMeetsDpOrNotSystem;
  }

  public boolean getIndMeetsDpOrNotSystem() {
    if (indMeetsDpOrNotSystem == null) {
      return false;
    }
    return indMeetsDpOrNotSystem;
  }

  public Boolean getIndMeetsDpOrNotSystemObject() {
    return indMeetsDpOrNotSystem;
  }

  public String getIndMeetsDpOrNotSystemString() {
    if (indMeetsDpOrNotSystem == null) {
      return "";
    }
    return indMeetsDpOrNotSystem.toString();
  }

  public void setIndMeetsDpOrNotSystem(boolean indMeetsDpOrNotSystem) {
    this.hasIndMeetsDpOrNotSystem = true;
    this.indMeetsDpOrNotSystem = indMeetsDpOrNotSystem;
  }

  public void setIndMeetsDpOrNotSystem(Boolean indMeetsDpOrNotSystem) {
    this.hasIndMeetsDpOrNotSystem = true;
    this.indMeetsDpOrNotSystem = indMeetsDpOrNotSystem;
  }

  public void setIndMeetsDpOrNotSystem(String indMeetsDpOrNotSystem) {
    this.hasIndMeetsDpOrNotSystem = true;
    this.indMeetsDpOrNotSystem = isTrueBoolean(indMeetsDpOrNotSystem);
  }

  public boolean hasIndMotherPwe() {
    return hasIndMotherPwe;
  }

  public boolean getIndMotherPwe() {
    if (indMotherPwe == null) {
      return false;
    }
    return indMotherPwe;
  }

  public Boolean getIndMotherPweObject() {
    return indMotherPwe;
  }

  public String getIndMotherPweString() {
    if (indMotherPwe == null) {
      return "";
    }
    return indMotherPwe.toString();
  }

  public void setIndMotherPwe(boolean indMotherPwe) {
    this.hasIndMotherPwe = true;
    this.indMotherPwe = indMotherPwe;
  }

  public void setIndMotherPwe(Boolean indMotherPwe) {
    this.hasIndMotherPwe = true;
    this.indMotherPwe = indMotherPwe;
  }

  public void setIndMotherPwe(String indMotherPwe) {
    this.hasIndMotherPwe = true;
    this.indMotherPwe = isTrueBoolean(indMotherPwe);
  }

  public boolean hasIndNarrativeApproved() {
    return hasIndNarrativeApproved;
  }

  public boolean getIndNarrativeApproved() {
    if (indNarrativeApproved == null) {
      return false;
    }
    return indNarrativeApproved;
  }

  public Boolean getIndNarrativeApprovedObject() {
    return indNarrativeApproved;
  }

  public String getIndNarrativeApprovedString() {
    if (indNarrativeApproved == null) {
      return "";
    }
    return indNarrativeApproved.toString();
  }

  public void setIndNarrativeApproved(boolean indNarrativeApproved) {
    this.hasIndNarrativeApproved = true;
    this.indNarrativeApproved = indNarrativeApproved;
  }

  public void setIndNarrativeApproved(Boolean indNarrativeApproved) {
    this.hasIndNarrativeApproved = true;
    this.indNarrativeApproved = indNarrativeApproved;
  }

  public void setIndNarrativeApproved(String indNarrativeApproved) {
    this.hasIndNarrativeApproved = true;
    this.indNarrativeApproved = isTrueBoolean(indNarrativeApproved);
  }

  public boolean hasIndOtherVerification() {
    return hasIndOtherVerification;
  }

  public boolean getIndOtherVerification() {
    if (indOtherVerification == null) {
      return false;
    }
    return indOtherVerification;
  }

  public Boolean getIndOtherVerificationObject() {
    return indOtherVerification;
  }

  public String getIndOtherVerificationString() {
    if (indOtherVerification == null) {
      return "";
    }
    return indOtherVerification.toString();
  }

  public void setIndOtherVerification(boolean indOtherVerification) {
    this.hasIndOtherVerification = true;
    this.indOtherVerification = indOtherVerification;
  }

  public void setIndOtherVerification(Boolean indOtherVerification) {
    this.hasIndOtherVerification = true;
    this.indOtherVerification = indOtherVerification;
  }

  public void setIndOtherVerification(String indOtherVerification) {
    this.hasIndOtherVerification = true;
    this.indOtherVerification = isTrueBoolean(indOtherVerification);
  }

  public boolean hasIndParentalDeprivation() {
    return hasIndParentalDeprivation;
  }

  public boolean getIndParentalDeprivation() {
    if (indParentalDeprivation == null) {
      return false;
    }
    return indParentalDeprivation;
  }

  public Boolean getIndParentalDeprivationObject() {
    return indParentalDeprivation;
  }

  public String getIndParentalDeprivationString() {
    if (indParentalDeprivation == null) {
      return "";
    }
    return indParentalDeprivation.toString();
  }

  public void setIndParentalDeprivation(boolean indParentalDeprivation) {
    this.hasIndParentalDeprivation = true;
    this.indParentalDeprivation = indParentalDeprivation;
  }

  public void setIndParentalDeprivation(Boolean indParentalDeprivation) {
    this.hasIndParentalDeprivation = true;
    this.indParentalDeprivation = indParentalDeprivation;
  }

  public void setIndParentalDeprivation(String indParentalDeprivation) {
    this.hasIndParentalDeprivation = true;
    this.indParentalDeprivation = isTrueBoolean(indParentalDeprivation);
  }

  public boolean hasIndParentDisabled() {
    return hasIndParentDisabled;
  }

  public boolean getIndParentDisabled() {
    if (indParentDisabled == null) {
      return false;
    }
    return indParentDisabled;
  }

  public Boolean getIndParentDisabledObject() {
    return indParentDisabled;
  }

  public String getIndParentDisabledString() {
    if (indParentDisabled == null) {
      return "";
    }
    return indParentDisabled.toString();
  }

  public void setIndParentDisabled(boolean indParentDisabled) {
    this.hasIndParentDisabled = true;
    this.indParentDisabled = indParentDisabled;
  }

  public void setIndParentDisabled(Boolean indParentDisabled) {
    this.hasIndParentDisabled = true;
    this.indParentDisabled = indParentDisabled;
  }

  public void setIndParentDisabled(String indParentDisabled) {
    this.hasIndParentDisabled = true;
    this.indParentDisabled = isTrueBoolean(indParentDisabled);
  }

  public boolean hasIndPeNotAcptEmpTrn() {
    return hasIndPeNotAcptEmpTrn;
  }

  public boolean getIndPeNotAcptEmpTrn() {
    if (indPeNotAcptEmpTrn == null) {
      return false;
    }
    return indPeNotAcptEmpTrn.booleanValue();
  }

  public Boolean getIndPeNotAcptEmpTrnObject() {
    return indPeNotAcptEmpTrn;
  }

  public String getIndPeNotAcptEmpTrnString() {
    if (indPeNotAcptEmpTrn == null) {
      return "";
    }
    return indPeNotAcptEmpTrn.toString();
  }

  public void setIndPeNotAcptEmpTrn(boolean indPeNotAcptEmpTrn) {
    this.hasIndPeNotAcptEmpTrn = true;
    this.indPeNotAcptEmpTrn = new Boolean(indPeNotAcptEmpTrn);
  }

  public void setIndPeNotAcptEmpTrn(Boolean indPeNotAcptEmpTrn) {
    this.hasIndPeNotAcptEmpTrn = true;
    this.indPeNotAcptEmpTrn = indPeNotAcptEmpTrn;
  }

  public void setIndPeNotAcptEmpTrn(String indPeNotAcptEmpTrn) {
    this.hasIndPeNotAcptEmpTrn = true;
    this.indPeNotAcptEmpTrn = isTrueBoolean(indPeNotAcptEmpTrn);
  }

  public boolean hasIndPeRecvUnemp() {
    return hasIndPeRecvUnemp;
  }

  public boolean getIndPeRecvUnemp() {
    if (indPeRecvUnemp == null) {
      return false;
    }
    return indPeRecvUnemp.booleanValue();
  }

  public Boolean getIndPeRecvUnempObject() {
    return indPeRecvUnemp;
  }

  public String getIndPeRecvUnempString() {
    if (indPeRecvUnemp == null) {
      return "";
    }
    return indPeRecvUnemp.toString();
  }

  public void setIndPeRecvUnemp(boolean indPeRecvUnemp) {
    this.hasIndPeRecvUnemp = true;
    this.indPeRecvUnemp = new Boolean(indPeRecvUnemp);
  }

  public void setIndPeRecvUnemp(Boolean indPeRecvUnemp) {
    this.hasIndPeRecvUnemp = true;
    this.indPeRecvUnemp = indPeRecvUnemp;
  }

  public void setIndPeRecvUnemp(String indPeRecvUnemp) {
    this.hasIndPeRecvUnemp = true;
    this.indPeRecvUnemp = isTrueBoolean(indPeRecvUnemp);
  }

  public boolean hasIndPeWrkEngEduTrn() {
    return hasIndPeWrkEngEduTrn;
  }

  public boolean getIndPeWrkEngEduTrn() {
    if (indPeWrkEngEduTrn == null) {
      return false;
    }
    return indPeWrkEngEduTrn.booleanValue();
  }

  public Boolean getIndPeWrkEngEduTrnObject() {
    return indPeWrkEngEduTrn;
  }

  public String getIndPeWrkEngEduTrnString() {
    if (indPeWrkEngEduTrn == null) {
      return "";
    }
    return indPeWrkEngEduTrn.toString();
  }

  public void setIndPeWrkEngEduTrn(boolean indPeWrkEngEduTrn) {
    this.hasIndPeWrkEngEduTrn = true;
    this.indPeWrkEngEduTrn = new Boolean(indPeWrkEngEduTrn);
  }

  public void setIndPeWrkEngEduTrn(Boolean indPeWrkEngEduTrn) {
    this.hasIndPeWrkEngEduTrn = true;
    this.indPeWrkEngEduTrn = indPeWrkEngEduTrn;
  }

  public void setIndPeWrkEngEduTrn(String indPeWrkEngEduTrn) {
    this.hasIndPeWrkEngEduTrn = true;
    this.indPeWrkEngEduTrn = isTrueBoolean(indPeWrkEngEduTrn);
  }

  public boolean hasIndPrsManagingCvs() {
    return hasIndPrsManagingCvs;
  }

  public boolean getIndPrsManagingCvs() {
    if (indPrsManagingCvs == null) {
      return false;
    }
    return indPrsManagingCvs;
  }

  public Boolean getIndPrsManagingCvsObject() {
    return indPrsManagingCvs;
  }

  public String getIndPrsManagingCvsString() {
    if (indPrsManagingCvs == null) {
      return "";
    }
    return indPrsManagingCvs.toString();
  }

  public void setIndPrsManagingCvs(boolean indPrsManagingCvs) {
    this.hasIndPrsManagingCvs = true;
    this.indPrsManagingCvs = indPrsManagingCvs;
  }

  public void setIndPrsManagingCvs(Boolean indPrsManagingCvs) {
    this.hasIndPrsManagingCvs = true;
    this.indPrsManagingCvs = indPrsManagingCvs;
  }

  public void setIndPrsManagingCvs(String indPrsManagingCvs) {
    this.hasIndPrsManagingCvs = true;
    this.indPrsManagingCvs = isTrueBoolean(indPrsManagingCvs);
  }

  public boolean hasIndRecv100PctVa() {
    return hasIndRecv100PctVa;
  }

  public boolean getIndRecv100PctVa() {
    if (indRecv100PctVa == null) {
      return false;
    }
    return indRecv100PctVa.booleanValue();
  }

  public Boolean getIndRecv100PctVaObject() {
    return indRecv100PctVa;
  }

  public String getIndRecv100PctVaString() {
    if (indRecv100PctVa == null) {
      return "";
    }
    return indRecv100PctVa.toString();
  }

  public void setIndRecv100PctVa(boolean indRecv100PctVa) {
    this.hasIndRecv100PctVa = true;
    this.indRecv100PctVa = new Boolean(indRecv100PctVa);
  }

  public void setIndRecv100PctVa(Boolean indRecv100PctVa) {
    this.hasIndRecv100PctVa = true;
    this.indRecv100PctVa = indRecv100PctVa;
  }

  public void setIndRecv100PctVa(String indRecv100PctVa) {
    this.hasIndRecv100PctVa = true;
    this.indRecv100PctVa = isTrueBoolean(indRecv100PctVa);
  }

  public boolean hasIndRecvRrRsdi() {
    return hasIndRecvRrRsdi;
  }

  public boolean getIndRecvRrRsdi() {
    if (indRecvRrRsdi == null) {
      return false;
    }
    return indRecvRrRsdi.booleanValue();
  }

  public Boolean getIndRecvRrRsdiObject() {
    return indRecvRrRsdi;
  }

  public String getIndRecvRrRsdiString() {
    if (indRecvRrRsdi == null) {
      return "";
    }
    return indRecvRrRsdi.toString();
  }

  public void setIndRecvRrRsdi(boolean indRecvRrRsdi) {
    this.hasIndRecvRrRsdi = true;
    this.indRecvRrRsdi = new Boolean(indRecvRrRsdi);
  }

  public void setIndRecvRrRsdi(Boolean indRecvRrRsdi) {
    this.hasIndRecvRrRsdi = true;
    this.indRecvRrRsdi = indRecvRrRsdi;
  }

  public void setIndRecvRrRsdi(String indRecvRrRsdi) {
    this.hasIndRecvRrRsdi = true;
    this.indRecvRrRsdi = isTrueBoolean(indRecvRrRsdi);
  }

  public boolean hasIndRemovalChildOrdered() {
    return hasIndRemovalChildOrdered;
  }

  public boolean getIndRemovalChildOrdered() {
    if (indRemovalChildOrdered == null) {
      return false;
    }
    return indRemovalChildOrdered;
  }

  public Boolean getIndRemovalChildOrderedObject() {
    return indRemovalChildOrdered;
  }

  public String getIndRemovalChildOrderedString() {
    if (indRemovalChildOrdered == null) {
      return "";
    }
    return indRemovalChildOrdered.toString();
  }

  public void setIndRemovalChildOrdered(boolean indRemovalChildOrdered) {
    this.hasIndRemovalChildOrdered = true;
    this.indRemovalChildOrdered = indRemovalChildOrdered;
  }

  public void setIndRemovalChildOrdered(Boolean indRemovalChildOrdered) {
    this.hasIndRemovalChildOrdered = true;
    this.indRemovalChildOrdered = indRemovalChildOrdered;
  }

  public void setIndRemovalChildOrdered(String indRemovalChildOrdered) {
    this.hasIndRemovalChildOrdered = true;
    this.indRemovalChildOrdered = isTrueBoolean(indRemovalChildOrdered);
  }

  public boolean hasIndRsdiVerification() {
    return hasIndRsdiVerification;
  }

  public boolean getIndRsdiVerification() {
    if (indRsdiVerification == null) {
      return false;
    }
    return indRsdiVerification;
  }

  public Boolean getIndRsdiVerificationObject() {
    return indRsdiVerification;
  }

  public String getIndRsdiVerificationString() {
    if (indRsdiVerification == null) {
      return "";
    }
    return indRsdiVerification.toString();
  }

  public void setIndRsdiVerification(boolean indRsdiVerification) {
    this.hasIndRsdiVerification = true;
    this.indRsdiVerification = indRsdiVerification;
  }

  public void setIndRsdiVerification(Boolean indRsdiVerification) {
    this.hasIndRsdiVerification = true;
    this.indRsdiVerification = indRsdiVerification;
  }

  public void setIndRsdiVerification(String indRsdiVerification) {
    this.hasIndRsdiVerification = true;
    this.indRsdiVerification = isTrueBoolean(indRsdiVerification);
  }

  public boolean hasIndRsnblEffortPrvtRemoval() {
    return hasIndRsnblEffortPrvtRemoval;
  }

  public boolean getIndRsnblEffortPrvtRemoval() {
    if (indRsnblEffortPrvtRemoval == null) {
      return false;
    }
    return indRsnblEffortPrvtRemoval;
  }

  public Boolean getIndRsnblEffortPrvtRemovalObject() {
    return indRsnblEffortPrvtRemoval;
  }

  public String getIndRsnblEffortPrvtRemovalString() {
    if (indRsnblEffortPrvtRemoval == null) {
      return "";
    }
    return indRsnblEffortPrvtRemoval.toString();
  }

  public void setIndRsnblEffortPrvtRemoval(boolean indRsnblEffortPrvtRemoval) {
    this.hasIndRsnblEffortPrvtRemoval = true;
    this.indRsnblEffortPrvtRemoval = indRsnblEffortPrvtRemoval;
  }

  public void setIndRsnblEffortPrvtRemoval(Boolean indRsnblEffortPrvtRemoval) {
    this.hasIndRsnblEffortPrvtRemoval = true;
    this.indRsnblEffortPrvtRemoval = indRsnblEffortPrvtRemoval;
  }

  public void setIndRsnblEffortPrvtRemoval(String indRsnblEffortPrvtRemoval) {
    this.hasIndRsnblEffortPrvtRemoval = true;
    this.indRsnblEffortPrvtRemoval = isTrueBoolean(indRsnblEffortPrvtRemoval);
  }

  public boolean hasIndSsiVerification() {
    return hasIndSsiVerification;
  }

  public boolean getIndSsiVerification() {
    if (indSsiVerification == null) {
      return false;
    }
    return indSsiVerification;
  }

  public Boolean getIndSsiVerificationObject() {
    return indSsiVerification;
  }

  public String getIndSsiVerificationString() {
    if (indSsiVerification == null) {
      return "";
    }
    return indSsiVerification.toString();
  }

  public void setIndSsiVerification(boolean indSsiVerification) {
    this.hasIndSsiVerification = true;
    this.indSsiVerification = indSsiVerification;
  }

  public void setIndSsiVerification(Boolean indSsiVerification) {
    this.hasIndSsiVerification = true;
    this.indSsiVerification = indSsiVerification;
  }

  public void setIndSsiVerification(String indSsiVerification) {
    this.hasIndSsiVerification = true;
    this.indSsiVerification = isTrueBoolean(indSsiVerification);
  }

  public boolean hasNbrCertifiedGroup() {
    return hasNbrCertifiedGroup;
  }

  public long getNbrCertifiedGroup() {
    if (nbrCertifiedGroup == null) {
      return (long) 0;
    }
    return nbrCertifiedGroup;
  }

  public Long getNbrCertifiedGroupObject() {
    return nbrCertifiedGroup;
  }

  public String getNbrCertifiedGroupString() {
    return FormattingHelper.formatLong(nbrCertifiedGroup);
  }

  public void setNbrCertifiedGroup(long nbrCertifiedGroup) {
    this.hasNbrCertifiedGroup = true;
    if (nbrCertifiedGroup == 0) {
      this.nbrCertifiedGroup = null;
      return;
    }
    this.nbrCertifiedGroup = nbrCertifiedGroup;
  }

  public void setNbrCertifiedGroup(Long nbrCertifiedGroup) {
    this.hasNbrCertifiedGroup = true;
    this.nbrCertifiedGroup = nbrCertifiedGroup;
  }

  public void setNbrCertifiedGroup(Number nbrCertifiedGroup) {
    this.hasNbrCertifiedGroup = true;
    this.nbrCertifiedGroup = null;
    if (nbrCertifiedGroup != null) {
      setNbrCertifiedGroup(nbrCertifiedGroup.longValue());
    }
  }

  public boolean hasNbrParentsHome() {
    return hasNbrParentsHome;
  }

  public long getNbrParentsHome() {
    if (nbrParentsHome == null) {
      return (long) 0;
    }
    return nbrParentsHome;
  }

  public Long getNbrParentsHomeObject() {
    return nbrParentsHome;
  }

  public String getNbrParentsHomeString() {
    return FormattingHelper.formatLong(nbrParentsHome);
  }

  public void setNbrParentsHome(long nbrParentsHome) {
    this.hasNbrParentsHome = true;
    if (nbrParentsHome == 0) {
      this.nbrParentsHome = null;
      return;
    }
    this.nbrParentsHome = nbrParentsHome;
  }

  public void setNbrParentsHome(Long nbrParentsHome) {
    this.hasNbrParentsHome = true;
    this.nbrParentsHome = nbrParentsHome;
  }

  public void setNbrParentsHome(Number nbrParentsHome) {
    this.hasNbrParentsHome = true;
    this.nbrParentsHome = null;
    if (nbrParentsHome != null) {
      setNbrParentsHome(nbrParentsHome.longValue());
    }
  }

  public boolean hasTxtDeterminationComments() {
    return hasTxtDeterminationComments;
  }

  public String getTxtDeterminationComments() {
    if (txtDeterminationComments == null) {
      return "";
    }
    return txtDeterminationComments;
  }

  public String getTxtDeterminationCommentsObject() {
    return txtDeterminationComments;
  }

  public void setTxtDeterminationComments(String txtDeterminationComments) {
    this.hasTxtDeterminationComments = true;
    this.txtDeterminationComments = txtDeterminationComments;
  }

  public boolean hasTxtMonthsDepUnemp() {
    return hasTxtMonthsDepUnemp;
  }

  public String getTxtMonthsDepUnemp() {
    if (txtMonthsDepUnemp == null) {
      return "";
    }
    return txtMonthsDepUnemp;
  }

  public String getTxtMonthsDepUnempObject() {
    return txtMonthsDepUnemp;
  }
  
  public void setTxtMonthsDepUnemp(String txtMonthsDepUnemp) {
    this.hasTxtMonthsDepUnemp = true;
    this.txtMonthsDepUnemp = txtMonthsDepUnemp;
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

  public void copyInto(AgeCitizenshipDB ageCitizenshipDB) {
    if (hasAddrHealthAddrCity) {
      ageCitizenshipDB.setAddrHealthAddrCity(addrHealthAddrCity);
    }
    if (hasAddrHealthAddrStLn1) {
      ageCitizenshipDB.setAddrHealthAddrStLn1(addrHealthAddrStLn1);
    }
    if (hasAddrHealthAddrStLn2) {
      ageCitizenshipDB.setAddrHealthAddrStLn2(addrHealthAddrStLn2);
    }
    if (hasAddrHealthAddrZip) {
      ageCitizenshipDB.setAddrHealthAddrZip(addrHealthAddrZip);
    }
    if (hasAddrRemovalAddrZip) {
      ageCitizenshipDB.setAddrRemovalAddrZip(addrRemovalAddrZip);
    }
    if (hasAddrRemovalCity) {
      ageCitizenshipDB.setAddrRemovalCity(addrRemovalCity);
    }
    if (hasAddrRemovalStLn1) {
      ageCitizenshipDB.setAddrRemovalStLn1(addrRemovalStLn1);
    }
    if (hasAddrRemovalStLn2) {
      ageCitizenshipDB.setAddrRemovalStLn2(addrRemovalStLn2);
    }
    if (hasCdApplication) {
      ageCitizenshipDB.setCdApplication(cdApplication);
    }
    if (hasCdCountyHospital) {
      ageCitizenshipDB.setCdCountyHospital(cdCountyHospital);
    }
    if (hasCdHealthAddrState) {
      ageCitizenshipDB.setCdHealthAddrState(cdHealthAddrState);
    }
    if (hasCdLivingMonthRemoval) {
      ageCitizenshipDB.setCdLivingMonthRemoval(cdLivingMonthRemoval);
    }
    if (hasCdNotaMostRecent) {
      ageCitizenshipDB.setCdNotaMostRecent(cdNotaMostRecent);
    }
    if (hasCdRemovalAddrCounty) {
      ageCitizenshipDB.setCdRemovalAddrCounty(cdRemovalAddrCounty);
    }
    if (hasCdRemovalAddrState) {
      ageCitizenshipDB.setCdRemovalAddrState(cdRemovalAddrState);
    }
    if (hasCdState) {
      ageCitizenshipDB.setCdState(cdState);
    }
    if (hasDtApplicationComplete) {
      ageCitizenshipDB.setDtApplicationComplete(dtApplicationComplete);
    }
    if (hasDtHealthBeginDate) {
      ageCitizenshipDB.setDtHealthBeginDate(dtHealthBeginDate);
    }
    if (hasDtHealthEndDate) {
      ageCitizenshipDB.setDtHealthEndDate(dtHealthEndDate);
    }
    if (hasDtHospitalAdmission) {
      ageCitizenshipDB.setDtHospitalAdmission(dtHospitalAdmission);
    }
    if (hasDtHospitalDischarge) {
      ageCitizenshipDB.setDtHospitalDischarge(dtHospitalDischarge);
    }
    if (hasFceApplicationDtLastUpdate) {
      ageCitizenshipDB.setFceApplicationDtLastUpdate(fceApplicationDtLastUpdate);
    }
    if (hasDtNotifiedWorker) {
      ageCitizenshipDB.setDtNotifiedWorker(dtNotifiedWorker);
    }
    if (hasDtProofAgeSentEs) {
      ageCitizenshipDB.setDtProofAgeSentEs(dtProofAgeSentEs);
    }
    if (hasDtProofCitizenshipSentEs) {
      ageCitizenshipDB.setDtProofCitizenshipSentEs(dtProofCitizenshipSentEs);
    }
    if (hasDtRemovalDate) {
      ageCitizenshipDB.setDtRemovalDate(dtRemovalDate);
    }
    if (hasIdCase) {
      ageCitizenshipDB.setIdCase(idCase);
    }
    if (hasIdEvent) {
      ageCitizenshipDB.setIdEvent(idEvent);
    }
    if (hasIdFceApplication) {
      ageCitizenshipDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      ageCitizenshipDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdLastUpdatePerson) {
      ageCitizenshipDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdMngngCvsPerson) {
      ageCitizenshipDB.setIdMngngCvsPerson(idMngngCvsPerson);
    }
    if (hasIdOtherRelativePerson) {
      ageCitizenshipDB.setIdOtherRelativePerson(idOtherRelativePerson);
    }
    if (hasIdPerson) {
      ageCitizenshipDB.setIdPerson(idPerson);
    }
    if (hasIdStage) {
      ageCitizenshipDB.setIdStage(idStage);
    }
    if (hasIndAgeVrfdBaptismCert) {
      ageCitizenshipDB.setIndAgeVrfdBaptismCert(indAgeVrfdBaptismCert);
    }
    if (hasIndAgeJustifiedEval) {
      ageCitizenshipDB.setIndAgeJustifiedEval(indAgeJustifiedEval);
    }
    if (hasIndAgeVrfdForeignCert) {
      ageCitizenshipDB.setIndAgeVrfdForeignCert(indAgeVrfdForeignCert);
    }
    if (hasIndAgeVrfdHospitalCert) {
      ageCitizenshipDB.setIndAgeVrfdHospitalCert(indAgeVrfdHospitalCert);
    }
    if (hasIndAgeVrfdNtrlztnCert) {
      ageCitizenshipDB.setIndAgeVrfdNtrlztnCert(indAgeVrfdNtrlztnCert);
    }
    if (hasIndAgeVrfdPassport) {
      ageCitizenshipDB.setIndAgeVrfdPassport(indAgeVrfdPassport);
    }
    if (hasIndAgeVrfdResidentCard) {
      ageCitizenshipDB.setIndAgeVrfdResidentCard(indAgeVrfdResidentCard);
    }
    if (hasIndAgeVrfdSaveSystem) {
      ageCitizenshipDB.setIndAgeVrfdSaveSystem(indAgeVrfdSaveSystem);
    }
    if (hasIndAgeVrfdSuccessSystem) {
      ageCitizenshipDB.setIndAgeVrfdSuccessSystem(indAgeVrfdSuccessSystem);
    }
    if (hasIndAgeVrfdUsBirthCert) {
      ageCitizenshipDB.setIndAgeVrfdUsBirthCert(indAgeVrfdUsBirthCert);
    }
    if (hasIndAmendedApp) {
      ageCitizenshipDB.setIndAmendedApp(indAmendedApp);
    }
    if (hasIndChildSupportOrder) {
      ageCitizenshipDB.setIndChildSupportOrder(indChildSupportOrder);
    }
    if (hasIndEvaluationConclusion) {
      ageCitizenshipDB.setIndEvaluationConclusion(indEvaluationConclusion);
    }
    if (hasIndHospital) {
      ageCitizenshipDB.setIndHospital(indHospital);
    }
    if (hasIndIncomeAssistance) {
      ageCitizenshipDB.setIndIncomeAssistance(indIncomeAssistance);
    }
    if (hasIndLegalDocsSentEs) {
      ageCitizenshipDB.setIndLegalDocsSentEs(indLegalDocsSentEs);
    }
    if (hasIndLivingRelativeSixMonth) {
      ageCitizenshipDB.setIndLivingRelativeSixMonth(indLivingRelativeSixMonth);
    }
    if (hasIndManagingCvs) {
      ageCitizenshipDB.setIndManagingCvs(indManagingCvs);
    }
    if (hasIndMinorParent) {
      ageCitizenshipDB.setIndMinorParent(indMinorParent);
    }
    if (hasIndNotifiedDhsWorker) {
      ageCitizenshipDB.setIndNotifiedDhsWorker(indNotifiedDhsWorker);
    }
    if (hasIndOtherHealthInsurance) {
      ageCitizenshipDB.setIndOtherHealthInsurance(indOtherHealthInsurance);
    }
    if (hasIndProofAgeSentEs) {
      ageCitizenshipDB.setIndProofAgeSentEs(indProofAgeSentEs);
    }
    if (hasIndProofCitizenshipSentEs) {
      ageCitizenshipDB.setIndProofCitizenshipSentEs(indProofCitizenshipSentEs);
    }
    if (hasIndSpecifiedRelative) {
      ageCitizenshipDB.setIndSpecifiedRelative(indSpecifiedRelative);
    }
    if (hasNbrCourtMonth) {
      ageCitizenshipDB.setNbrCourtMonth(nbrCourtMonth);
    }
    if (hasNbrCourtYear) {
      ageCitizenshipDB.setNbrCourtYear(nbrCourtYear);
    }
    if (hasNbrHealthGroup) {
      ageCitizenshipDB.setNbrHealthGroup(nbrHealthGroup);
    }
    if (hasNbrHealthPolicy) {
      ageCitizenshipDB.setNbrHealthPolicy(nbrHealthPolicy);
    }
    if (hasNbrLivingAtHome) {
      ageCitizenshipDB.setNbrLivingAtHome(nbrLivingAtHome);
    }
    if (hasNbrNotifiedDhsWrkrPhn) {
      ageCitizenshipDB.setNbrNotifiedDhsWrkrPhn(nbrNotifiedDhsWrkrPhn);
    }
    if (hasNmHealthCompany) {
      ageCitizenshipDB.setNmHealthCompany(nmHealthCompany);
    }
    if (hasNmHealthEmployeeNm) {
      ageCitizenshipDB.setNmHealthEmployeeNm(nmHealthEmployeeNm);
    }
    if (hasNmHealthEmployerNm) {
      ageCitizenshipDB.setNmHealthEmployerNm(nmHealthEmployerNm);
    }
    if (hasNmHealthPolicyHldrNm) {
      ageCitizenshipDB.setNmHealthPolicyHldrNm(nmHealthPolicyHldrNm);
    }
    if (hasNmHospital) {
      ageCitizenshipDB.setNmHospital(nmHospital);
    }
    if (hasNmHospitalCity) {
      ageCitizenshipDB.setNmHospitalCity(nmHospitalCity);
    }
    if (hasNmMotherMaiden) {
      ageCitizenshipDB.setNmMotherMaiden(nmMotherMaiden);
    }
    if (hasNmNotifiedDhsWrkrFirst) {
      ageCitizenshipDB.setNmNotifiedDhsWrkrFirst(nmNotifiedDhsWrkrFirst);
    }
    if (hasNmNotifiedDhsWrkrLast) {
      ageCitizenshipDB.setNmNotifiedDhsWrkrLast(nmNotifiedDhsWrkrLast);
    }
    if (hasNmNotifiedDhsWrkrMiddle) {
      ageCitizenshipDB.setNmNotifiedDhsWrkrMiddle(nmNotifiedDhsWrkrMiddle);
    }
    if (hasTxtIncomeDtrmntnComments) {
      ageCitizenshipDB.setTxtIncomeDtrmntnComments(txtIncomeDtrmntnComments);
    }
    if (hasTxtLegalDocsSentEs) {
      ageCitizenshipDB.setTxtLegalDocsSentEs(txtLegalDocsSentEs);
    }
    if (hasTxtMeetsDdOrNotComments) {
      ageCitizenshipDB.setTxtMeetsDdOrNotComments(txtMeetsDdOrNotComments);
    }
    if (hasTxtNoIncomeExplanation) {
      ageCitizenshipDB.setTxtNoIncomeExplanation(txtNoIncomeExplanation);
    }
    if (hasTxtProofAgeSentEs) {
      ageCitizenshipDB.setTxtProofAgeSentEs(txtProofAgeSentEs);
    }
    if (hasTxtProofCitizenshipSentEs) {
      ageCitizenshipDB.setTxtProofCitizenshipSentEs(txtProofCitizenshipSentEs);
    }
    if (hasAmtCountableIncome) {
      ageCitizenshipDB.setAmtCountableIncome(amtCountableIncome);
    }
    if (hasAmtGrossEarnedCrtfdGrp) {
      ageCitizenshipDB.setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp);
    }
    if (hasAmtGrossUnearnedCrtfdGrp) {
      ageCitizenshipDB.setAmtGrossUnearnedCrtfdGrp(amtGrossUnearnedCrtfdGrp);
    }
    if (hasAmtIncomeLimit) {
      ageCitizenshipDB.setAmtIncomeLimit(amtIncomeLimit);
    }
    if (hasAmtPweIncome) {
      ageCitizenshipDB.setAmtPweIncome(amtPweIncome);
    }
    if (hasAmtSsi) {
      ageCitizenshipDB.setAmtSsi(amtSsi);
    }
    if (hasAmtStepparentAlimony) {
      ageCitizenshipDB.setAmtStepparentAlimony(amtStepparentAlimony);
    }
    if (hasAmtStepparentAllowance) {
      ageCitizenshipDB.setAmtStepparentAllowance(amtStepparentAllowance);
    }
    if (hasAmtStepparentAppliedIncome) {
      ageCitizenshipDB.setAmtStepparentAppliedIncome(amtStepparentAppliedIncome);
    }
    if (hasAmtStepparentCntblUnearned) {
      ageCitizenshipDB.setAmtStepparentCntblUnearned(amtStepparentCntblUnearned);
    }
    if (hasAmtStepparentGrossEarned) {
      ageCitizenshipDB.setAmtStepparentGrossEarned(amtStepparentGrossEarned);
    }
    if (hasAmtStepparentOutsidePmnt) {
      ageCitizenshipDB.setAmtStepparentOutsidePmnt(amtStepparentOutsidePmnt);
    }
    if (hasAmtStepparentTotalCntbl) {
      ageCitizenshipDB.setAmtStepparentTotalCntbl(amtStepparentTotalCntbl);
    }
    if (hasAmtStepparentWorkDeduct) {
      ageCitizenshipDB.setAmtStepparentWorkDeduct(amtStepparentWorkDeduct);
    }
    if (hasCdBlocChild) {
      ageCitizenshipDB.setCdBlocChild(cdBlocChild);
    }
    if (hasCdEligibilityActual) {
      ageCitizenshipDB.setCdEligibilityActual(cdEligibilityActual);
    }
    if (hasCdEligibilitySelected) {
      ageCitizenshipDB.setCdEligibilitySelected(cdEligibilitySelected);
    }
    if (hasCdMedicaidEligibilityType) {
      ageCitizenshipDB.setCdMedicaidEligibilityType(cdMedicaidEligibilityType);
    }
    if (hasFceEligibilityCdPersonCitizenship) {
      ageCitizenshipDB.setFceEligibilityCdPersonCitizenship(fceEligibilityCdPersonCitizenship);
    }
    if (hasCdPweIrregularUnder100) {
      ageCitizenshipDB.setCdPweIrregularUnder100(cdPweIrregularUnder100);
    }
    if (hasCdPweSteadyUnder100) {
      ageCitizenshipDB.setCdPweSteadyUnder100(cdPweSteadyUnder100);
    }
    if (hasCdVerifMethod) {
      ageCitizenshipDB.setCdVerifMethod(cdVerifMethod);
    }
    if (hasCdVerifDocType) {
      ageCitizenshipDB.setCdVerifDocType(cdVerifDocType);
    }
    if (hasDtDeprivationChanged) {
      ageCitizenshipDB.setDtDeprivationChanged(dtDeprivationChanged);
    }  
    if (hasDtEligibilityEnd) {
      ageCitizenshipDB.setDtEligibilityEnd(dtEligibilityEnd);
    }
    if (hasDtEligDtrmntnStart) {
      ageCitizenshipDB.setDtEligDtrmntnStart(dtEligDtrmntnStart);
    }
    if (hasFceEligibilityDtLastUpdate) {
      ageCitizenshipDB.setFceEligibilityDtLastUpdate(fceEligibilityDtLastUpdate);
    }
    if (hasDtRemovalChildOrdered) {
      ageCitizenshipDB.setDtRemovalChildOrdered(dtRemovalChildOrdered);
    }
    if (hasDtReviewDate) {
      ageCitizenshipDB.setDtReviewDate(dtReviewDate);
    }
    if (hasDtRsnblEffortPreventRem) {
      ageCitizenshipDB.setDtRsnblEffortPreventRem(dtRsnblEffortPreventRem);
    }
    if (hasIdEligibilityEvent) {
      ageCitizenshipDB.setIdEligibilityEvent(idEligibilityEvent);
    }
    if (hasIdFcePerson) {
      ageCitizenshipDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdFceReview) {
      ageCitizenshipDB.setIdFceReview(idFceReview);
    }
    if (hasIdPrnEarner) {
      ageCitizenshipDB.setIdPrnEarner(idPrnEarner);
    }
    if (hasIndAbsentAltrntCustody) {
      ageCitizenshipDB.setIndAbsentAltrntCustody(indAbsentAltrntCustody);
    }
    if (hasIndAbsentDeported) {
      ageCitizenshipDB.setIndAbsentDeported(indAbsentDeported);
    }
    if (hasIndAbsentDeserted) {
      ageCitizenshipDB.setIndAbsentDeserted(indAbsentDeserted);
    }
    if (hasIndAbsentDied) {
      ageCitizenshipDB.setIndAbsentDied(indAbsentDied);
    }
    if (hasIndAbsentDivorced) {
      ageCitizenshipDB.setIndAbsentDivorced(indAbsentDivorced);
    }
    if (hasIndAbsentFather) {
      ageCitizenshipDB.setIndAbsentFather(indAbsentFather);
    }
    if (hasIndAbsentHospitalized) {
      ageCitizenshipDB.setIndAbsentHospitalized(indAbsentHospitalized);
    }
    if (hasIndAbsentIncarcerated) {
      ageCitizenshipDB.setIndAbsentIncarcerated(indAbsentIncarcerated);
    }
    if (hasIndAbsentMilitaryWork) {
      ageCitizenshipDB.setIndAbsentMilitaryWork(indAbsentMilitaryWork);
    }
    if (hasIndAbsentMother) {
      ageCitizenshipDB.setIndAbsentMother(indAbsentMother);
    }
    if (hasIndAbsentSeparated) {
      ageCitizenshipDB.setIndAbsentSeparated(indAbsentSeparated);
    }
    if (hasIndAbsentWorkRelated) {
      ageCitizenshipDB.setIndAbsentWorkRelated(indAbsentWorkRelated);
    }
    if (hasIndChildLivingPrnt6Mnths) {
      ageCitizenshipDB.setIndChildLivingPrnt6Mnths(indChildLivingPrnt6Mnths);
    }
    if (hasIndChildQualifiedCitizen) {
      ageCitizenshipDB.setIndChildQualifiedCitizen(indChildQualifiedCitizen);
    }
    if (hasIndChildSupportOrdered) {
      ageCitizenshipDB.setIndChildSupportOrdered(indChildSupportOrdered);
    }
    if (hasIndChildUnder18) {
      ageCitizenshipDB.setIndChildUnder18(indChildUnder18);
    }
    if (hasIndCtznshpAmerIndianCrd) {
      ageCitizenshipDB.setIndCtznshpAmerIndianCrd(indCtznshpAmerIndianCrd);
    }
    if (hasIndCtznshpAttorneyReview) {
      ageCitizenshipDB.setIndCtznshpAttorneyReview(indCtznshpAttorneyReview);
    }
    if (hasIndCtznshpBirthCrtfctFor) {
      ageCitizenshipDB.setIndCtznshpBirthCrtfctFor(indCtznshpBirthCrtfctFor);
    }
    if (hasIndCtznshpBirthCrtfctUs) {
      ageCitizenshipDB.setIndCtznshpBirthCrtfctUs(indCtznshpBirthCrtfctUs);
    }
    if (hasIndCtznshpChldFound) {
      ageCitizenshipDB.setIndCtznshpChldFound(indCtznshpChldFound);
    }
    if (hasIndCtznshpCitizenCrtfct) {
      ageCitizenshipDB.setIndCtznshpCitizenCrtfct(indCtznshpCitizenCrtfct);
    }
    if (hasIndCtznshpEvaluation) {
      ageCitizenshipDB.setIndCtznshpEvaluation(indCtznshpEvaluation);
    }
    if (hasIndCtznshpForDocumentation) {
      ageCitizenshipDB.setIndCtznshpForDocumentation(indCtznshpForDocumentation);
    }
    if (hasIndCtznshpHospitalCrtfct) {
      ageCitizenshipDB.setIndCtznshpHospitalCrtfct(indCtznshpHospitalCrtfct);
    }
    if (hasIndCtznshpNoDocumentation) {
      ageCitizenshipDB.setIndCtznshpNoDocumentation(indCtznshpNoDocumentation);
    }
    if (hasIndCtznshpNtrlztnCrtfct) {
      ageCitizenshipDB.setIndCtznshpNtrlztnCrtfct(indCtznshpNtrlztnCrtfct);
    }
    if (hasIndCtznshpPassport) {
      ageCitizenshipDB.setIndCtznshpPassport(indCtznshpPassport);
    }
    if (hasIndCtznshpResidentCard) {
      ageCitizenshipDB.setIndCtznshpResidentCard(indCtznshpResidentCard);
    }
    if (hasIndCtznshpUnaccMinorChild) {
      ageCitizenshipDB.setIndCtznshpUnaccMinorChild(indCtznshpUnaccMinorChild);
    }
    if (hasIndCtznshpUndocImmigrant) {
      ageCitizenshipDB.setIndCtznshpUndocImmigrant(indCtznshpUndocImmigrant);
    }
    if (hasIndCtznshpUsHsptlBrthRcrd) {
      ageCitizenshipDB.setIndCtznshpUsHsptlBrthRcrd(indCtznshpUsHsptlBrthRcrd);
    }
    if (hasIndCtznshpUsIdCard) {
      ageCitizenshipDB.setIndCtznshpUsIdCard(indCtznshpUsIdCard);
    }
    if (hasIndCtznshpVitalBirthRcrd) {
      ageCitizenshipDB.setIndCtznshpVitalBirthRcrd(indCtznshpVitalBirthRcrd);
    } 
    if (hasIndCtznshpSaveSystem) {
      ageCitizenshipDB.setIndCtznshpSaveSystem(indCtznshpSaveSystem);
    }
    if (hasIndCtznshpStudentVisa) {
      ageCitizenshipDB.setIndCtznshpStudentVisa(indCtznshpStudentVisa);
    }
    if (hasIndCtznshpDriverLicOrId) {
      ageCitizenshipDB.setIndCtznshpDriverLicOrId(indCtznshpDriverLicOrId);
    }
    if (hasIndCtznshpCertIndBlood) {
      ageCitizenshipDB.setIndCtznshpCertIndBlood(indCtznshpCertIndBlood);
    }
    if (hasIndCtznshpDocImmigNatAct) {
      ageCitizenshipDB.setIndCtznshpDocImmigNatAct(indCtznshpDocImmigNatAct);
    }
    if (hasIndCtznshpSchoolIdPhoto) {
      ageCitizenshipDB.setIndCtznshpSchoolIdPhoto(indCtznshpSchoolIdPhoto);
    }
    if (hasIndCtznshpMilitaryDepdntId) {
      ageCitizenshipDB.setIndCtznshpMilitaryDepdntId(indCtznshpMilitaryDepdntId);
    }
    if (hasIndCtznshpSchoolRec) {
      ageCitizenshipDB.setIndCtznshpSchoolRec(indCtznshpSchoolRec);
    }
    if (hasIndCtznshpClinicDocHosDoc) {
      ageCitizenshipDB.setIndCtznshpClinicDocHosDoc(indCtznshpClinicDocHosDoc);
    }
    if (hasIndCtznshpDaycareNurseRcrd) {
      ageCitizenshipDB.setIndCtznshpDaycareNurseRcrd(indCtznshpDaycareNurseRcrd);
    }
    if (hasIndCtznshpAffidavitSigned) {
      ageCitizenshipDB.setIndCtznshpAffidavitSigned(indCtznshpAffidavitSigned);
    }
    if (hasIndCtznshpCertReportBirth) {
      ageCitizenshipDB.setIndCtznshpCertReportBirth(indCtznshpCertReportBirth);
    }
    if (hasIndCtznshpSuccessSystem) {
      ageCitizenshipDB.setIndCtznshpSuccessSystem(indCtznshpSuccessSystem);
    }
    if (hasIndCtznshpBirthAbroad) {
      ageCitizenshipDB.setIndCtznshpBirthAbroad(indCtznshpBirthAbroad);
    }
    if (hasIndCtznshpCensusBirthRcrd) {
      ageCitizenshipDB.setIndCtznshpCensusBirthRcrd(indCtznshpCensusBirthRcrd);
    }
    if (hasIndCtznshpCivilServiceEmp) {
      ageCitizenshipDB.setIndCtznshpCivilServiceEmp(indCtznshpCivilServiceEmp);
    }
    if (hasIndCtznshpConfrmBirth) {
      ageCitizenshipDB.setIndCtznshpConfrmBirth(indCtznshpConfrmBirth);
    }
    if (hasIndCtznshpFinalAdoptDecree) {
      ageCitizenshipDB.setIndCtznshpFinalAdoptDecree(indCtznshpFinalAdoptDecree);
    }
    if (hasIndCtznshpNorthMarianaId) {
      ageCitizenshipDB.setIndCtznshpNorthMarianaId(indCtznshpNorthMarianaId);
    }
    if (hasIndCtznshpLeglImmiStatExp) {
      ageCitizenshipDB.setIndCtznshpLeglImmiStatExp(indCtznshpLeglImmiStatExp);
    }
    if (hasIndCtznshpLifeInsBrthRcrd) {
      ageCitizenshipDB.setIndCtznshpLifeInsBrthRcrd(indCtznshpLifeInsBrthRcrd);
    }
    if (hasIndCtznshpLoclGovtBrthRcrd) {
      ageCitizenshipDB.setIndCtznshpLoclGovtBrthRcrd(indCtznshpLoclGovtBrthRcrd);
    }
    if (hasIndCtznshpMedBirthRcrd) {
      ageCitizenshipDB.setIndCtznshpMedBirthRcrd(indCtznshpMedBirthRcrd);
    }
    if (hasIndCtznshpMiltryBirthRcrd) {
      ageCitizenshipDB.setIndCtznshpMiltryBirthRcrd(indCtznshpMiltryBirthRcrd);
    }
    if (hasIndCtznshpRefugee) {
      ageCitizenshipDB.setIndCtznshpRefugee(indCtznshpRefugee);
    }
    if (hasIndCtznshpReligBirthRcrd) {
      ageCitizenshipDB.setIndCtznshpReligBirthRcrd(indCtznshpReligBirthRcrd);
    }
    if (hasIndEligibilityCourtMonth) {
      ageCitizenshipDB.setIndEligibilityCourtMonth(indEligibilityCourtMonth);
    }
    if (hasIndEligible) {
      ageCitizenshipDB.setIndEligible(indEligible);
    }
    if (hasIndEquity) {
      ageCitizenshipDB.setIndEquity(indEquity);
    }
    if (hasIndFatherPwe) {
      ageCitizenshipDB.setIndFatherPwe(indFatherPwe);
    }
    if (hasIndHomeIncomeAfdcElgblty) {
      ageCitizenshipDB.setIndHomeIncomeAfdcElgblty(indHomeIncomeAfdcElgblty);
    }
    if (hasIndMeetsDpOrNotEs) {
      ageCitizenshipDB.setIndMeetsDpOrNotEs(indMeetsDpOrNotEs);
    }
    if (hasIndMeetsDpOrNotSystem) {
      ageCitizenshipDB.setIndMeetsDpOrNotSystem(indMeetsDpOrNotSystem);
    }
    if (hasIndMotherPwe) {
      ageCitizenshipDB.setIndMotherPwe(indMotherPwe);
    }
    if (hasIndNarrativeApproved) {
      ageCitizenshipDB.setIndNarrativeApproved(indNarrativeApproved);
    }
    if (hasIndOtherVerification) {
      ageCitizenshipDB.setIndOtherVerification(indOtherVerification);
    }
    if (hasIndParentalDeprivation) {
      ageCitizenshipDB.setIndParentalDeprivation(indParentalDeprivation);
    }
    if (hasIndParentDisabled) {
      ageCitizenshipDB.setIndParentDisabled(indParentDisabled);
    }
    if (hasIndPeNotAcptEmpTrn) {
      ageCitizenshipDB.setIndPeNotAcptEmpTrn(indPeNotAcptEmpTrn);
    }
    if (hasIndPeRecvUnemp) {
      ageCitizenshipDB.setIndPeRecvUnemp(indPeRecvUnemp);
    }
    if (hasIndPeWrkEngEduTrn) {
      ageCitizenshipDB.setIndPeWrkEngEduTrn(indPeWrkEngEduTrn);
    }
    if (hasIndPrsManagingCvs) {
      ageCitizenshipDB.setIndPrsManagingCvs(indPrsManagingCvs);
    }
    if (hasIndRecv100PctVa) {
      ageCitizenshipDB.setIndRecv100PctVa(indRecv100PctVa);
    }
    if (hasIndRecvRrRsdi) {
      ageCitizenshipDB.setIndRecvRrRsdi(indRecvRrRsdi);
    }
    if (hasIndRemovalChildOrdered) {
      ageCitizenshipDB.setIndRemovalChildOrdered(indRemovalChildOrdered);
    }
    if (hasIndRsdiVerification) {
      ageCitizenshipDB.setIndRsdiVerification(indRsdiVerification);
    }
    if (hasIndRsnblEffortPrvtRemoval) {
      ageCitizenshipDB.setIndRsnblEffortPrvtRemoval(indRsnblEffortPrvtRemoval);
    }
    if (hasIndSsiVerification) {
      ageCitizenshipDB.setIndSsiVerification(indSsiVerification);
    }
    if (hasNbrCertifiedGroup) {
      ageCitizenshipDB.setNbrCertifiedGroup(nbrCertifiedGroup);
    }
    if (hasNbrParentsHome) {
      ageCitizenshipDB.setNbrParentsHome(nbrParentsHome);
    }
    if (hasTxtDeterminationComments) {
      ageCitizenshipDB.setTxtDeterminationComments(txtDeterminationComments);
    }
    if (hasTxtMonthsDepUnemp) {
      ageCitizenshipDB.setTxtMonthsDepUnemp(txtMonthsDepUnemp);
    }
    if (hasCdRelInt) {
      ageCitizenshipDB.setCdRelInt(cdRelInt);
    }
    if (hasDtBirth) {
      ageCitizenshipDB.setDtBirth(dtBirth);
    }
    if (hasFcePersonDtLastUpdate) {
      ageCitizenshipDB.setFcePersonDtLastUpdate(fcePersonDtLastUpdate);
    }
    if (hasIndCertifiedGroup) {
      ageCitizenshipDB.setIndCertifiedGroup(indCertifiedGroup);
    }
    if (hasIndDobApprox) {
      ageCitizenshipDB.setIndDobApprox(indDobApprox);
    }
    if (hasIndPersonHmRemoval) {
      ageCitizenshipDB.setIndPersonHmRemoval(indPersonHmRemoval);
    }
    if (hasNbrAge) {
      ageCitizenshipDB.setNbrAge(nbrAge);
    }
    if (hasCdEventStatus) {
      ageCitizenshipDB.setCdEventStatus(cdEventStatus);
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
    if (hasIndPersonHmRemoval) {
      fcePersonDB.setIndPersonHmRemoval(indPersonHmRemoval);
    }
    if (hasNbrAge) {
      fcePersonDB.setNbrAge(nbrAge);
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
    if (fcePersonDB.hasIndPersonHmRemoval()) {
      setIndPersonHmRemoval(fcePersonDB.getIndPersonHmRemovalObject());
    }
    if (fcePersonDB.hasNbrAge()) {
      setNbrAge(fcePersonDB.getNbrAgeObject());
    }
  }

  public FceEligibilityDB getFceEligibility() {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    if (hasAmtCountableIncome) {
      fceEligibilityDB.setAmtCountableIncome(amtCountableIncome);
    }
    if (hasAmtGrossEarnedCrtfdGrp) {
      fceEligibilityDB.setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp);
    }
    if (hasAmtGrossUnearnedCrtfdGrp) {
      fceEligibilityDB.setAmtGrossUnearnedCrtfdGrp(amtGrossUnearnedCrtfdGrp);
    }
    if (hasAmtIncomeLimit) {
      fceEligibilityDB.setAmtIncomeLimit(amtIncomeLimit);
    }
    if (hasAmtPweIncome) {
      fceEligibilityDB.setAmtPweIncome(amtPweIncome);
    }
    if (hasAmtSsi) {
      fceEligibilityDB.setAmtSsi(amtSsi);
    }
    if (hasAmtStepparentAlimony) {
      fceEligibilityDB.setAmtStepparentAlimony(amtStepparentAlimony);
    }
    if (hasAmtStepparentAllowance) {
      fceEligibilityDB.setAmtStepparentAllowance(amtStepparentAllowance);
    }
    if (hasAmtStepparentAppliedIncome) {
      fceEligibilityDB.setAmtStepparentAppliedIncome(amtStepparentAppliedIncome);
    }
    if (hasAmtStepparentCntblUnearned) {
      fceEligibilityDB.setAmtStepparentCntblUnearned(amtStepparentCntblUnearned);
    }
    if (hasAmtStepparentGrossEarned) {
      fceEligibilityDB.setAmtStepparentGrossEarned(amtStepparentGrossEarned);
    }
    if (hasAmtStepparentOutsidePmnt) {
      fceEligibilityDB.setAmtStepparentOutsidePmnt(amtStepparentOutsidePmnt);
    }
    if (hasAmtStepparentTotalCntbl) {
      fceEligibilityDB.setAmtStepparentTotalCntbl(amtStepparentTotalCntbl);
    }
    if (hasAmtStepparentWorkDeduct) {
      fceEligibilityDB.setAmtStepparentWorkDeduct(amtStepparentWorkDeduct);
    }
    if (hasCdBlocChild) {
      fceEligibilityDB.setCdBlocChild(cdBlocChild);
    }
    if (hasCdEligibilityActual) {
      fceEligibilityDB.setCdEligibilityActual(cdEligibilityActual);
    }
    if (hasCdEligibilitySelected) {
      fceEligibilityDB.setCdEligibilitySelected(cdEligibilitySelected);
    }
    if (hasCdMedicaidEligibilityType) {
      fceEligibilityDB.setCdMedicaidEligibilityType(cdMedicaidEligibilityType);
    }
    if (hasFceEligibilityCdPersonCitizenship) {
      fceEligibilityDB.setCdPersonCitizenship(fceEligibilityCdPersonCitizenship);
    }
    if (hasCdPweIrregularUnder100) {
      fceEligibilityDB.setCdPweIrregularUnder100(cdPweIrregularUnder100);
    }
    if (hasCdPweSteadyUnder100) {
      fceEligibilityDB.setCdPweSteadyUnder100(cdPweSteadyUnder100);
    }
    if (hasCdVerifMethod) {
      fceEligibilityDB.setCdVerifMethod(cdVerifMethod);
    }
    if (hasCdVerifDocType) {
      fceEligibilityDB.setCdVerifDocType(cdVerifDocType);
    }
    if (hasDtDeprivationChanged) {
      fceEligibilityDB.setDtDeprivationChanged(dtDeprivationChanged);
    }  
    if (hasDtEligibilityEnd) {
      fceEligibilityDB.setDtEligibilityEnd(dtEligibilityEnd);
    }
    if (hasDtEligDtrmntnStart) {
      fceEligibilityDB.setDtEligDtrmntnStart(dtEligDtrmntnStart);
    }
    if (hasFceEligibilityDtLastUpdate) {
      fceEligibilityDB.setDtLastUpdate(fceEligibilityDtLastUpdate);
    }
    if (hasDtRemovalChildOrdered) {
      fceEligibilityDB.setDtRemovalChildOrdered(dtRemovalChildOrdered);
    }
    if (hasDtReviewDate) {
      fceEligibilityDB.setDtReviewDate(dtReviewDate);
    }
    if (hasDtRsnblEffortPreventRem) {
      fceEligibilityDB.setDtRsnblEffortPreventRem(dtRsnblEffortPreventRem);
    }
    if (hasIdCase) {
      fceEligibilityDB.setIdCase(idCase);
    }
    if (hasIdEligibilityEvent) {
      fceEligibilityDB.setIdEligibilityEvent(idEligibilityEvent);
    }
    if (hasIdFceApplication) {
      fceEligibilityDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      fceEligibilityDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdFcePerson) {
      fceEligibilityDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdFceReview) {
      fceEligibilityDB.setIdFceReview(idFceReview);
    }
    if (hasIdLastUpdatePerson) {
      fceEligibilityDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdPerson) {
      fceEligibilityDB.setIdPerson(idPerson);
    }
    if (hasIdPrnEarner) {
      fceEligibilityDB.setIdPrnEarner(idPrnEarner);
    }
    if (hasIdStage) {
      fceEligibilityDB.setIdStage(idStage);
    }
    if (hasIndAbsentAltrntCustody) {
      fceEligibilityDB.setIndAbsentAltrntCustody(indAbsentAltrntCustody);
    }
    if (hasIndAbsentDeported) {
      fceEligibilityDB.setIndAbsentDeported(indAbsentDeported);
    }
    if (hasIndAbsentDeserted) {
      fceEligibilityDB.setIndAbsentDeserted(indAbsentDeserted);
    }
    if (hasIndAbsentDied) {
      fceEligibilityDB.setIndAbsentDied(indAbsentDied);
    }
    if (hasIndAbsentDivorced) {
      fceEligibilityDB.setIndAbsentDivorced(indAbsentDivorced);
    }
    if (hasIndAbsentFather) {
      fceEligibilityDB.setIndAbsentFather(indAbsentFather);
    }
    if (hasIndAbsentHospitalized) {
      fceEligibilityDB.setIndAbsentHospitalized(indAbsentHospitalized);
    }
    if (hasIndAbsentIncarcerated) {
      fceEligibilityDB.setIndAbsentIncarcerated(indAbsentIncarcerated);
    }
    if (hasIndAbsentMilitaryWork) {
      fceEligibilityDB.setIndAbsentMilitaryWork(indAbsentMilitaryWork);
    }
    if (hasIndAbsentMother) {
      fceEligibilityDB.setIndAbsentMother(indAbsentMother);
    }
    if (hasIndAbsentSeparated) {
      fceEligibilityDB.setIndAbsentSeparated(indAbsentSeparated);
    }
    if (hasIndAbsentWorkRelated) {
      fceEligibilityDB.setIndAbsentWorkRelated(indAbsentWorkRelated);
    }
    if (hasIndChildLivingPrnt6Mnths) {
      fceEligibilityDB.setIndChildLivingPrnt6Mnths(indChildLivingPrnt6Mnths);
    }
    if (hasIndChildQualifiedCitizen) {
      fceEligibilityDB.setIndChildQualifiedCitizen(indChildQualifiedCitizen);
    }
    if (hasIndChildSupportOrdered) {
      fceEligibilityDB.setIndChildSupportOrdered(indChildSupportOrdered);
    }
    if (hasIndChildUnder18) {
      fceEligibilityDB.setIndChildUnder18(indChildUnder18);
    }
    if (hasIndCtznshpAmerIndianCrd) {
      fceEligibilityDB.setIndCtznshpAmerIndianCrd(indCtznshpAmerIndianCrd);
    }
    if (hasIndCtznshpAttorneyReview) {
      fceEligibilityDB.setIndCtznshpAttorneyReview(indCtznshpAttorneyReview);
    }
    if (hasIndCtznshpBirthCrtfctFor) {
      fceEligibilityDB.setIndCtznshpBirthCrtfctFor(indCtznshpBirthCrtfctFor);
    }
    if (hasIndCtznshpBirthCrtfctUs) {
      fceEligibilityDB.setIndCtznshpBirthCrtfctUs(indCtznshpBirthCrtfctUs);
    }
    if (hasIndCtznshpChldFound) {
      fceEligibilityDB.setIndCtznshpChldFound(indCtznshpChldFound);
    }
    if (hasIndCtznshpCitizenCrtfct) {
      fceEligibilityDB.setIndCtznshpCitizenCrtfct(indCtznshpCitizenCrtfct);
    }
    if (hasIndCtznshpEvaluation) {
      fceEligibilityDB.setIndCtznshpEvaluation(indCtznshpEvaluation);
    }
    if (hasIndCtznshpForDocumentation) {
      fceEligibilityDB.setIndCtznshpForDocumentation(indCtznshpForDocumentation);
    }
    if (hasIndCtznshpHospitalCrtfct) {
      fceEligibilityDB.setIndCtznshpHospitalCrtfct(indCtznshpHospitalCrtfct);
    }
    if (hasIndCtznshpNoDocumentation) {
      fceEligibilityDB.setIndCtznshpNoDocumentation(indCtznshpNoDocumentation);
    }
    if (hasIndCtznshpNtrlztnCrtfct) {
      fceEligibilityDB.setIndCtznshpNtrlztnCrtfct(indCtznshpNtrlztnCrtfct);
    }
    if (hasIndCtznshpPassport) {
      fceEligibilityDB.setIndCtznshpPassport(indCtznshpPassport);
    }
    if (hasIndCtznshpResidentCard) {
      fceEligibilityDB.setIndCtznshpResidentCard(indCtznshpResidentCard);
    }
    if (hasIndCtznshpUnaccMinorChild) {
      fceEligibilityDB.setIndCtznshpUnaccMinorChild(indCtznshpUnaccMinorChild);
    }
    if (hasIndCtznshpUndocImmigrant) {
      fceEligibilityDB.setIndCtznshpUndocImmigrant(indCtznshpUndocImmigrant);
    }
    if (hasIndCtznshpUsHsptlBrthRcrd) {
      fceEligibilityDB.setIndCtznshpUsHsptlBrthRcrd(indCtznshpUsHsptlBrthRcrd);
    }
    if (hasIndCtznshpUsIdCard) {
      fceEligibilityDB.setIndCtznshpUsIdCard(indCtznshpUsIdCard);
    }
    if (hasIndCtznshpVitalBirthRcrd) {
      fceEligibilityDB.setIndCtznshpVitalBirthRcrd(indCtznshpVitalBirthRcrd);
    } 
    if (hasIndCtznshpDriverLicOrId) {
      fceEligibilityDB.setIndCtznshpDriverLicOrId(indCtznshpDriverLicOrId);
    }
    if (hasIndCtznshpCertIndBlood) {
      fceEligibilityDB.setIndCtznshpCertIndBlood(indCtznshpCertIndBlood);
    }
    if (hasIndCtznshpDocImmigNatAct) {
      fceEligibilityDB.setIndCtznshpDocImmigNatAct(indCtznshpDocImmigNatAct);
    }
    if (hasIndCtznshpSchoolIdPhoto) {
      fceEligibilityDB.setIndCtznshpSchoolIdPhoto(indCtznshpSchoolIdPhoto);
    }
    if (hasIndCtznshpMilitaryDepdntId) {
      fceEligibilityDB.setIndCtznshpMilitaryDepdntId(indCtznshpMilitaryDepdntId);
    }
    if (hasIndCtznshpSchoolRec) {
      fceEligibilityDB.setIndCtznshpSchoolRec(indCtznshpSchoolRec);
    }
    if (hasIndCtznshpClinicDocHosDoc) {
      fceEligibilityDB.setIndCtznshpClinicDocHosDoc(indCtznshpClinicDocHosDoc);
    }
    if (hasIndCtznshpDaycareNurseRcrd) {
      fceEligibilityDB.setIndCtznshpDaycareNurseRcrd(indCtznshpDaycareNurseRcrd);
    }
    if (hasIndCtznshpAffidavitSigned) {
      fceEligibilityDB.setIndCtznshpAffidavitSigned(indCtznshpAffidavitSigned);
    }
    if (hasIndCtznshpCertReportBirth) {
      fceEligibilityDB.setIndCtznshpCertReportBirth(indCtznshpCertReportBirth);
    }
    if (hasIndCtznshpSaveSystem) {
      fceEligibilityDB.setIndCtznshpSaveSystem(indCtznshpSaveSystem);
    }
    if (hasIndCtznshpStudentVisa) {
      fceEligibilityDB.setIndCtznshpStudentVisa(indCtznshpStudentVisa);
    }
    if (hasIndCtznshpSuccessSystem) {
      fceEligibilityDB.setIndCtznshpSuccessSystem(indCtznshpSuccessSystem);
    }
    if (hasIndCtznshpBirthAbroad) {
      fceEligibilityDB.setIndCtznshpBirthAbroad(indCtznshpBirthAbroad);
    }
    if (hasIndCtznshpCensusBirthRcrd) {
      fceEligibilityDB.setIndCtznshpCensusBirthRcrd(indCtznshpCensusBirthRcrd);
    }
    if (hasIndCtznshpCivilServiceEmp) {
      fceEligibilityDB.setIndCtznshpCivilServiceEmp(indCtznshpCivilServiceEmp);
    }
    if (hasIndCtznshpConfrmBirth) {
      fceEligibilityDB.setIndCtznshpConfrmBirth(indCtznshpConfrmBirth);
    }
    if (hasIndCtznshpFinalAdoptDecree) {
      fceEligibilityDB.setIndCtznshpFinalAdoptDecree(indCtznshpFinalAdoptDecree);
    }
    if (hasIndCtznshpNorthMarianaId) {
      fceEligibilityDB.setIndCtznshpNorthMarianaId(indCtznshpNorthMarianaId);
    }
    if (hasIndCtznshpLeglImmiStatExp) {
      fceEligibilityDB.setIndCtznshpLeglImmiStatExp(indCtznshpLeglImmiStatExp);
    }
    if (hasIndCtznshpLifeInsBrthRcrd) {
      fceEligibilityDB.setIndCtznshpLifeInsBrthRcrd(indCtznshpLifeInsBrthRcrd);
    }
    if (hasIndCtznshpLoclGovtBrthRcrd) {
      fceEligibilityDB.setIndCtznshpLoclGovtBrthRcrd(indCtznshpLoclGovtBrthRcrd);
    }
    if (hasIndCtznshpMedBirthRcrd) {
      fceEligibilityDB.setIndCtznshpMedBirthRcrd(indCtznshpMedBirthRcrd);
    }
    if (hasIndCtznshpMiltryBirthRcrd) {
      fceEligibilityDB.setIndCtznshpMiltryBirthRcrd(indCtznshpMiltryBirthRcrd);
    }
    if (hasIndCtznshpRefugee) {
      fceEligibilityDB.setIndCtznshpRefugee(indCtznshpRefugee);
    }
    if (hasIndCtznshpReligBirthRcrd) {
      fceEligibilityDB.setIndCtznshpReligBirthRcrd(indCtznshpReligBirthRcrd);
    }
    if (hasIndEligibilityCourtMonth) {
      fceEligibilityDB.setIndEligibilityCourtMonth(indEligibilityCourtMonth);
    }
    if (hasIndEligible) {
      fceEligibilityDB.setIndEligible(indEligible);
    }
    if (hasIndEquity) {
      fceEligibilityDB.setIndEquity(indEquity);
    }
    if (hasIndFatherPwe) {
      fceEligibilityDB.setIndFatherPwe(indFatherPwe);
    }
    if (hasIndHomeIncomeAfdcElgblty) {
      fceEligibilityDB.setIndHomeIncomeAfdcElgblty(indHomeIncomeAfdcElgblty);
    }
    if (hasIndMeetsDpOrNotEs) {
      fceEligibilityDB.setIndMeetsDpOrNotEs(indMeetsDpOrNotEs);
    }
    if (hasIndMeetsDpOrNotSystem) {
      fceEligibilityDB.setIndMeetsDpOrNotSystem(indMeetsDpOrNotSystem);
    }
    if (hasIndMotherPwe) {
      fceEligibilityDB.setIndMotherPwe(indMotherPwe);
    }
    if (hasIndNarrativeApproved) {
      fceEligibilityDB.setIndNarrativeApproved(indNarrativeApproved);
    }
    if (hasIndOtherVerification) {
      fceEligibilityDB.setIndOtherVerification(indOtherVerification);
    }
    if (hasIndParentalDeprivation) {
      fceEligibilityDB.setIndParentalDeprivation(indParentalDeprivation);
    }
    if (hasIndParentDisabled) {
      fceEligibilityDB.setIndParentDisabled(indParentDisabled);
    }
    if (hasIndPeNotAcptEmpTrn) {
      fceEligibilityDB.setIndPeNotAcptEmpTrn(indPeNotAcptEmpTrn);
    }
    if (hasIndPeRecvUnemp) {
      fceEligibilityDB.setIndPeRecvUnemp(indPeRecvUnemp);
    }
    if (hasIndPeWrkEngEduTrn) {
      fceEligibilityDB.setIndPeWrkEngEduTrn(indPeWrkEngEduTrn);
    }
    if (hasIndPrsManagingCvs) {
      fceEligibilityDB.setIndPrsManagingCvs(indPrsManagingCvs);
    }
    if (hasIndRecv100PctVa) {
      fceEligibilityDB.setIndRecv100PctVa(indRecv100PctVa);
    }
    if (hasIndRecvRrRsdi) {
      fceEligibilityDB.setIndRecvRrRsdi(indRecvRrRsdi);
    }
    if (hasIndRemovalChildOrdered) {
      fceEligibilityDB.setIndRemovalChildOrdered(indRemovalChildOrdered);
    }
    if (hasIndRsdiVerification) {
      fceEligibilityDB.setIndRsdiVerification(indRsdiVerification);
    }
    if (hasIndRsnblEffortPrvtRemoval) {
      fceEligibilityDB.setIndRsnblEffortPrvtRemoval(indRsnblEffortPrvtRemoval);
    }
    if (hasIndSsiVerification) {
      fceEligibilityDB.setIndSsiVerification(indSsiVerification);
    }
    if (hasNbrCertifiedGroup) {
      fceEligibilityDB.setNbrCertifiedGroup(nbrCertifiedGroup);
    }
    if (hasNbrParentsHome) {
      fceEligibilityDB.setNbrParentsHome(nbrParentsHome);
    }
    if (hasTxtDeterminationComments) {
      fceEligibilityDB.setTxtDeterminationComments(txtDeterminationComments);
    }
    if (hasTxtMonthsDepUnemp) {
      fceEligibilityDB.setTxtMonthsDepUnemp(txtMonthsDepUnemp);
    }
    return fceEligibilityDB;
  }

  public void setFceEligibility(FceEligibilityDB fceEligibilityDB) {
    if (fceEligibilityDB.hasAmtCountableIncome()) {
      setAmtCountableIncome(fceEligibilityDB.getAmtCountableIncomeObject());
    }
    if (fceEligibilityDB.hasAmtGrossEarnedCrtfdGrp()) {
      setAmtGrossEarnedCrtfdGrp(fceEligibilityDB.getAmtGrossEarnedCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtGrossUnearnedCrtfdGrp()) {
      setAmtGrossUnearnedCrtfdGrp(fceEligibilityDB.getAmtGrossUnearnedCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtIncomeLimit()) {
      setAmtIncomeLimit(fceEligibilityDB.getAmtIncomeLimitObject());
    }
    if (fceEligibilityDB.hasAmtPweIncome()) {
      setAmtPweIncome(fceEligibilityDB.getAmtPweIncomeObject());
    }
    if (fceEligibilityDB.hasAmtSsi()) {
      setAmtSsi(fceEligibilityDB.getAmtSsiObject());
    }
    if (fceEligibilityDB.hasAmtStepparentAlimony()) {
      setAmtStepparentAlimony(fceEligibilityDB.getAmtStepparentAlimonyObject());
    }
    if (fceEligibilityDB.hasAmtStepparentAllowance()) {
      setAmtStepparentAllowance(fceEligibilityDB.getAmtStepparentAllowanceObject());
    }
    if (fceEligibilityDB.hasAmtStepparentAppliedIncome()) {
      setAmtStepparentAppliedIncome(fceEligibilityDB.getAmtStepparentAppliedIncomeObject());
    }
    if (fceEligibilityDB.hasAmtStepparentCntblUnearned()) {
      setAmtStepparentCntblUnearned(fceEligibilityDB.getAmtStepparentCntblUnearnedObject());
    }
    if (fceEligibilityDB.hasAmtStepparentGrossEarned()) {
      setAmtStepparentGrossEarned(fceEligibilityDB.getAmtStepparentGrossEarnedObject());
    }
    if (fceEligibilityDB.hasAmtStepparentOutsidePmnt()) {
      setAmtStepparentOutsidePmnt(fceEligibilityDB.getAmtStepparentOutsidePmntObject());
    }
    if (fceEligibilityDB.hasAmtStepparentTotalCntbl()) {
      setAmtStepparentTotalCntbl(fceEligibilityDB.getAmtStepparentTotalCntblObject());
    }
    if (fceEligibilityDB.hasAmtStepparentWorkDeduct()) {
      setAmtStepparentWorkDeduct(fceEligibilityDB.getAmtStepparentWorkDeductObject());
    }
    if (fceEligibilityDB.hasCdBlocChild()) {
      setCdBlocChild(fceEligibilityDB.getCdBlocChildObject());
    }
    if (fceEligibilityDB.hasCdEligibilityActual()) {
      setCdEligibilityActual(fceEligibilityDB.getCdEligibilityActualObject());
    }
    if (fceEligibilityDB.hasCdEligibilitySelected()) {
      setCdEligibilitySelected(fceEligibilityDB.getCdEligibilitySelectedObject());
    }
    if (fceEligibilityDB.hasCdMedicaidEligibilityType()) {
      setCdMedicaidEligibilityType(fceEligibilityDB.getCdMedicaidEligibilityTypeObject());
    }
    if (fceEligibilityDB.hasCdPersonCitizenship()) {
      setFceEligibilityCdPersonCitizenship(fceEligibilityDB.getCdPersonCitizenshipObject());
    }
    if (fceEligibilityDB.hasCdPweIrregularUnder100()) {
      setCdPweIrregularUnder100(fceEligibilityDB.getCdPweIrregularUnder100Object());
    }
    if (fceEligibilityDB.hasCdPweSteadyUnder100()) {
      setCdPweSteadyUnder100(fceEligibilityDB.getCdPweSteadyUnder100Object());
    }
    if (fceEligibilityDB.hasCdVerifMethod()) {
      setCdVerifMethod(fceEligibilityDB.getCdVerifMethod());
    }
    if (fceEligibilityDB.hasCdVerifDocType()) {
      setCdVerifDocType(fceEligibilityDB.getCdVerifDocType());
    }
    if (fceEligibilityDB.hasDtDeprivationChanged()) {
      setDtDeprivationChanged(fceEligibilityDB.getDtDeprivationChangedObject());
    }
    if (fceEligibilityDB.hasDtEligibilityEnd()) {
      setDtEligibilityEnd(fceEligibilityDB.getDtEligibilityEndObject());
    }
    if (fceEligibilityDB.hasDtEligDtrmntnStart()) {
      setDtEligDtrmntnStart(fceEligibilityDB.getDtEligDtrmntnStartObject());
    }
    if (fceEligibilityDB.hasDtLastUpdate()) {
      setFceEligibilityDtLastUpdate(fceEligibilityDB.getDtLastUpdateObject());
    }
    if (fceEligibilityDB.hasDtRemovalChildOrdered()) {
      setDtRemovalChildOrdered(fceEligibilityDB.getDtRemovalChildOrderedObject());
    }
    if (fceEligibilityDB.hasDtReviewDate()) {
      setDtReviewDate(fceEligibilityDB.getDtReviewDateObject());
    }
    if (fceEligibilityDB.hasDtRsnblEffortPreventRem()) {
      setDtRsnblEffortPreventRem(fceEligibilityDB.getDtRsnblEffortPreventRemObject());
    }
    if (fceEligibilityDB.hasIdCase()) {
      setIdCase(fceEligibilityDB.getIdCaseObject());
    }
    if (fceEligibilityDB.hasIdEligibilityEvent()) {
      setIdEligibilityEvent(fceEligibilityDB.getIdEligibilityEventObject());
    }
    if (fceEligibilityDB.hasIdFceApplication()) {
      setIdFceApplication(fceEligibilityDB.getIdFceApplicationObject());
    }
    if (fceEligibilityDB.hasIdFceEligibility()) {
      setIdFceEligibility(fceEligibilityDB.getIdFceEligibilityObject());
    }
    if (fceEligibilityDB.hasIdFcePerson()) {
      setIdFcePerson(fceEligibilityDB.getIdFcePersonObject());
    }
    if (fceEligibilityDB.hasIdFceReview()) {
      setIdFceReview(fceEligibilityDB.getIdFceReviewObject());
    }
    if (fceEligibilityDB.hasIdLastUpdatePerson()) {
      setIdLastUpdatePerson(fceEligibilityDB.getIdLastUpdatePersonObject());
    }
    if (fceEligibilityDB.hasIdPerson()) {
      setIdPerson(fceEligibilityDB.getIdPersonObject());
    }
    if (fceEligibilityDB.hasIdPrnEarner()) {
      setIdPrnEarner(fceEligibilityDB.getIdPrnEarner());
    }
    if (fceEligibilityDB.hasIdStage()) {
      setIdStage(fceEligibilityDB.getIdStageObject());
    }
    if (fceEligibilityDB.hasIndAbsentAltrntCustody()) {
      setIndAbsentAltrntCustody(fceEligibilityDB.getIndAbsentAltrntCustodyObject());
    }
    if (fceEligibilityDB.hasIndAbsentDeported()) {
      setIndAbsentDeported(fceEligibilityDB.getIndAbsentDeportedObject());
    }
    if (fceEligibilityDB.hasIndAbsentDeserted()) {
      setIndAbsentDeserted(fceEligibilityDB.getIndAbsentDesertedObject());
    }
    if (fceEligibilityDB.hasIndAbsentDied()) {
      setIndAbsentDied(fceEligibilityDB.getIndAbsentDiedObject());
    }
    if (fceEligibilityDB.hasIndAbsentDivorced()) {
      setIndAbsentDivorced(fceEligibilityDB.getIndAbsentDivorcedObject());
    }
    if (fceEligibilityDB.hasIndAbsentFather()) {
      setIndAbsentFather(fceEligibilityDB.getIndAbsentFatherObject());
    }
    if (fceEligibilityDB.hasIndAbsentHospitalized()) {
      setIndAbsentHospitalized(fceEligibilityDB.getIndAbsentHospitalizedObject());
    }
    if (fceEligibilityDB.hasIndAbsentIncarcerated()) {
      setIndAbsentIncarcerated(fceEligibilityDB.getIndAbsentIncarceratedObject());
    }
    if (fceEligibilityDB.hasIndAbsentMilitaryWork()) {
      setIndAbsentMilitaryWork(fceEligibilityDB.getIndAbsentMilitaryWorkObject());
    }
    if (fceEligibilityDB.hasIndAbsentMother()) {
      setIndAbsentMother(fceEligibilityDB.getIndAbsentMotherObject());
    }
    if (fceEligibilityDB.hasIndAbsentSeparated()) {
      setIndAbsentSeparated(fceEligibilityDB.getIndAbsentSeparatedObject());
    }
    if (fceEligibilityDB.hasIndAbsentWorkRelated()) {
      setIndAbsentWorkRelated(fceEligibilityDB.getIndAbsentWorkRelatedObject());
    }
    if (fceEligibilityDB.hasIndChildLivingPrnt6Mnths()) {
      setIndChildLivingPrnt6Mnths(fceEligibilityDB.getIndChildLivingPrnt6MnthsObject());
    }
    if (fceEligibilityDB.hasIndChildQualifiedCitizen()) {
      setIndChildQualifiedCitizen(fceEligibilityDB.getIndChildQualifiedCitizenObject());
    }
    if (fceEligibilityDB.hasIndChildSupportOrdered()) {
      setIndChildSupportOrdered(fceEligibilityDB.getIndChildSupportOrderedObject());
    }
    if (fceEligibilityDB.hasIndChildUnder18()) {
      setIndChildUnder18(fceEligibilityDB.getIndChildUnder18Object());
    }
    if (fceEligibilityDB.hasIndCtznshpAmerIndianCrd()) {
      setIndCtznshpAmerIndianCrd(fceEligibilityDB.getIndCtznshpAmerIndianCrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpAttorneyReview()) {
      setIndCtznshpAttorneyReview(fceEligibilityDB.getIndCtznshpAttorneyReviewObject());
    }
    if (fceEligibilityDB.hasIndCtznshpBirthCrtfctFor()) {
      setIndCtznshpBirthCrtfctFor(fceEligibilityDB.getIndCtznshpBirthCrtfctForObject());
    }
    if (fceEligibilityDB.hasIndCtznshpBirthCrtfctUs()) {
      setIndCtznshpBirthCrtfctUs(fceEligibilityDB.getIndCtznshpBirthCrtfctUsObject());
    }
    if (fceEligibilityDB.hasIndCtznshpChldFound()) {
      setIndCtznshpChldFound(fceEligibilityDB.getIndCtznshpChldFoundObject());
    }
    if (fceEligibilityDB.hasIndCtznshpCitizenCrtfct()) {
      setIndCtznshpCitizenCrtfct(fceEligibilityDB.getIndCtznshpCitizenCrtfctObject());
    }
    if (fceEligibilityDB.hasIndCtznshpEvaluation()) {
      setIndCtznshpEvaluation(fceEligibilityDB.getIndCtznshpEvaluationObject());
    }
    if (fceEligibilityDB.hasIndCtznshpForDocumentation()) {
      setIndCtznshpForDocumentation(fceEligibilityDB.getIndCtznshpForDocumentationObject());
    }
    if (fceEligibilityDB.hasIndCtznshpHospitalCrtfct()) {
      setIndCtznshpHospitalCrtfct(fceEligibilityDB.getIndCtznshpHospitalCrtfctObject());
    }
    if (fceEligibilityDB.hasIndCtznshpNoDocumentation()) {
      setIndCtznshpNoDocumentation(fceEligibilityDB.getIndCtznshpNoDocumentationObject());
    }
    if (fceEligibilityDB.hasIndCtznshpNtrlztnCrtfct()) {
      setIndCtznshpNtrlztnCrtfct(fceEligibilityDB.getIndCtznshpNtrlztnCrtfctObject());
    }
    if (fceEligibilityDB.hasIndCtznshpPassport()) {
      setIndCtznshpPassport(fceEligibilityDB.getIndCtznshpPassportObject());
    }
    if (fceEligibilityDB.hasIndCtznshpResidentCard()) {
      setIndCtznshpResidentCard(fceEligibilityDB.getIndCtznshpResidentCardObject());
    }
    if (fceEligibilityDB.hasIndCtznshpUnaccMinorChild()) {
      setIndCtznshpUnaccMinorChild(fceEligibilityDB.getIndCtznshpUnaccMinorChildObject());
    }
    if (fceEligibilityDB.hasIndCtznshpUndocImmigrant()) {
      setIndCtznshpUndocImmigrant(fceEligibilityDB.getIndCtznshpUndocImmigrantObject());
    }
    if (fceEligibilityDB.hasIndCtznshpUsHsptlBrthRcrd()) {
      setIndCtznshpUsHsptlBrthRcrd(fceEligibilityDB.getIndCtznshpUsHsptlBrthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpUsIdCard()) {
      setIndCtznshpUsIdCard(fceEligibilityDB.getIndCtznshpUsIdCardObject());
    }
    if (fceEligibilityDB.hasIndCtznshpVitalBirthRcrd()) {
      setIndCtznshpVitalBirthRcrd(fceEligibilityDB.getIndCtznshpVitalBirthRcrdObject());
    } 
    if (fceEligibilityDB.hasIndCtznshpSaveSystem()) {
      setIndCtznshpSaveSystem(fceEligibilityDB.getIndCtznshpSaveSystemObject());
    }
    if (fceEligibilityDB.hasIndCtznshpStudentVisa()) {
      setIndCtznshpStudentVisa(fceEligibilityDB.getIndCtznshpStudentVisaObject());
    }
    if (fceEligibilityDB.hasIndCtznshpSuccessSystem()) {
      setIndCtznshpSuccessSystem(fceEligibilityDB.getIndCtznshpSuccessSystemObject());
    }
    if (fceEligibilityDB.hasIndCtznshpBirthAbroad()) {
      setIndCtznshpBirthAbroad(fceEligibilityDB.getIndCtznshpBirthAbroadObject());
    }
    if (fceEligibilityDB.hasIndCtznshpCensusBirthRcrd()) {
      setIndCtznshpCensusBirthRcrd(fceEligibilityDB.getIndCtznshpCensusBirthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpCivilServiceEmp()) {
      setIndCtznshpCivilServiceEmp(fceEligibilityDB.getIndCtznshpCivilServiceEmpObject());
    }
    if (fceEligibilityDB.hasIndCtznshpConfrmBirth()) {
      setIndCtznshpConfrmBirth(fceEligibilityDB.getIndCtznshpConfrmBirthObject());
    }
    if (fceEligibilityDB.hasIndCtznshpFinalAdoptDecree()) {
      setIndCtznshpFinalAdoptDecree(fceEligibilityDB.getIndCtznshpFinalAdoptDecreeObject());
    }
    if (fceEligibilityDB.hasIndCtznshpNorthMarianaId()) {
      setIndCtznshpNorthMarianaId(fceEligibilityDB.getIndCtznshpNorthMarianaIdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpLeglImmiStatExp()) {
      setIndCtznshpLeglImmiStatExp(fceEligibilityDB.getIndCtznshpLeglImmiStatExpObject());
    }
    if (fceEligibilityDB.hasIndCtznshpLifeInsBrthRcrd()) {
      setIndCtznshpLifeInsBrthRcrd(fceEligibilityDB.getIndCtznshpLifeInsBrthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpLoclGovtBrthRcrd()) {
      setIndCtznshpLoclGovtBrthRcrd(fceEligibilityDB.getIndCtznshpLoclGovtBrthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpMedBirthRcrd()) {
      setIndCtznshpMedBirthRcrd(fceEligibilityDB.getIndCtznshpMedBirthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpMiltryBirthRcrd()) {
      setIndCtznshpMiltryBirthRcrd(fceEligibilityDB.getIndCtznshpMiltryBirthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpRefugee()) {
      setIndCtznshpRefugee(fceEligibilityDB.getIndCtznshpRefugeeObject());
    }
    if (fceEligibilityDB.hasIndCtznshpReligBirthRcrd()) {
      setIndCtznshpReligBirthRcrd(fceEligibilityDB.getIndCtznshpReligBirthRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpDriverLicOrId()) {
      setIndCtznshpDriverLicOrId(fceEligibilityDB.getIndCtznshpDriverLicOrIdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpCertIndBlood()) {
      setIndCtznshpCertIndBlood(fceEligibilityDB.getIndCtznshpCertIndBloodObject());
    }
    if (fceEligibilityDB.hasIndCtznshpDocImmigNatAct()) {
      setIndCtznshpDocImmigNatAct(fceEligibilityDB.getIndCtznshpDocImmigNatActObject());
    }
    if (fceEligibilityDB.hasIndCtznshpSchoolIdPhoto()) {
      setIndCtznshpSchoolIdPhoto(fceEligibilityDB.getIndCtznshpSchoolIdPhotoObject());
    }
    if (fceEligibilityDB.hasIndCtznshpMilitaryDepdntId()) {
      setIndCtznshpMilitaryDepdntId(fceEligibilityDB.getIndCtznshpMilitaryDepdntIdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpSchoolRec()) {
      setIndCtznshpSchoolRec(fceEligibilityDB.getIndCtznshpSchoolRecObject());
    }
    if (fceEligibilityDB.hasIndCtznshpClinicDocHosDoc()) {
      setIndCtznshpClinicDocHosDoc(fceEligibilityDB.getIndCtznshpClinicDocHosDocObject());
    }
    if (fceEligibilityDB.hasIndCtznshpDaycareNurseRcrd()) {
      setIndCtznshpDaycareNurseRcrd(fceEligibilityDB.getIndCtznshpDaycareNurseRcrdObject());
    }
    if (fceEligibilityDB.hasIndCtznshpAffidavitSigned()) {
      setIndCtznshpAffidavitSigned(fceEligibilityDB.getIndCtznshpAffidavitSignedObject());
    }
    if (fceEligibilityDB.hasIndCtznshpCertReportBirth()) {
      setIndCtznshpCertReportBirth(fceEligibilityDB.getIndCtznshpCertReportBirthObject());
    }
    if (fceEligibilityDB.hasIndEligibilityCourtMonth()) {
      setIndEligibilityCourtMonth(fceEligibilityDB.getIndEligibilityCourtMonthObject());
    }
    if (fceEligibilityDB.hasIndEligible()) {
      setIndEligible(fceEligibilityDB.getIndEligibleObject());
    }
    if (fceEligibilityDB.hasIndEquity()) {
      setIndEquity(fceEligibilityDB.getIndEquityObject());
    }
    if (fceEligibilityDB.hasIndFatherPwe()) {
      setIndFatherPwe(fceEligibilityDB.getIndFatherPweObject());
    }
    if (fceEligibilityDB.hasIndHomeIncomeAfdcElgblty()) {
      setIndHomeIncomeAfdcElgblty(fceEligibilityDB.getIndHomeIncomeAfdcElgbltyObject());
    }
    if (fceEligibilityDB.hasIndMeetsDpOrNotEs()) {
      setIndMeetsDpOrNotEs(fceEligibilityDB.getIndMeetsDpOrNotEsObject());
    }
    if (fceEligibilityDB.hasIndMeetsDpOrNotSystem()) {
      setIndMeetsDpOrNotSystem(fceEligibilityDB.getIndMeetsDpOrNotSystemObject());
    }
    if (fceEligibilityDB.hasIndMotherPwe()) {
      setIndMotherPwe(fceEligibilityDB.getIndMotherPweObject());
    }
    if (fceEligibilityDB.hasIndNarrativeApproved()) {
      setIndNarrativeApproved(fceEligibilityDB.getIndNarrativeApprovedObject());
    }
    if (fceEligibilityDB.hasIndOtherVerification()) {
      setIndOtherVerification(fceEligibilityDB.getIndOtherVerificationObject());
    }
    if (fceEligibilityDB.hasIndParentalDeprivation()) {
      setIndParentalDeprivation(fceEligibilityDB.getIndParentalDeprivationObject());
    }
    if (fceEligibilityDB.hasIndParentDisabled()) {
      setIndParentDisabled(fceEligibilityDB.getIndParentDisabledObject());
    }
    if (fceEligibilityDB.hasIndPeNotAcptEmpTrn()) {
      setIndPeNotAcptEmpTrn(fceEligibilityDB.getIndPeNotAcptEmpTrn());
    }
    if (fceEligibilityDB.hasIndPeRecvUnemp()) {
      setIndPeRecvUnemp(fceEligibilityDB.getIndPeRecvUnemp());
    }
    if (fceEligibilityDB.hasIndPeWrkEngEduTrn()) {
      setIndPeWrkEngEduTrn(fceEligibilityDB.getIndPeWrkEngEduTrn());
    }
    if (fceEligibilityDB.hasIndPrsManagingCvs()) {
      setIndPrsManagingCvs(fceEligibilityDB.getIndPrsManagingCvsObject());
    }
    if (fceEligibilityDB.hasIndRecv100PctVa()) {
      setIndRecv100PctVa(fceEligibilityDB.getIndRecv100PctVa());
    }
    if (fceEligibilityDB.hasIndRecvRrRsdi()) {
      setIndRecvRrRsdi(fceEligibilityDB.getIndRecvRrRsdi());
    }
    if (fceEligibilityDB.hasIndRemovalChildOrdered()) {
      setIndRemovalChildOrdered(fceEligibilityDB.getIndRemovalChildOrderedObject());
    }
    if (fceEligibilityDB.hasIndRsdiVerification()) {
      setIndRsdiVerification(fceEligibilityDB.getIndRsdiVerificationObject());
    }
    if (fceEligibilityDB.hasIndRsnblEffortPrvtRemoval()) {
      setIndRsnblEffortPrvtRemoval(fceEligibilityDB.getIndRsnblEffortPrvtRemovalObject());
    }
    if (fceEligibilityDB.hasIndSsiVerification()) {
      setIndSsiVerification(fceEligibilityDB.getIndSsiVerificationObject());
    }
    if (fceEligibilityDB.hasNbrCertifiedGroup()) {
      setNbrCertifiedGroup(fceEligibilityDB.getNbrCertifiedGroupObject());
    }
    if (fceEligibilityDB.hasNbrParentsHome()) {
      setNbrParentsHome(fceEligibilityDB.getNbrParentsHomeObject());
    }
    if (fceEligibilityDB.hasTxtDeterminationComments()) {
      setTxtDeterminationComments(fceEligibilityDB.getTxtDeterminationCommentsObject());
    }
    if (fceEligibilityDB.hasTxtMonthsDepUnemp()) {
      setTxtMonthsDepUnemp(fceEligibilityDB.getTxtMonthsDepUnempObject());
    }
  }

  public String toString() {
    return
            "BEGIN bean: AgeCitizenship\n" +
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
            " amtCountableIncome: " + amtCountableIncome + "\n" +
            " amtGrossEarnedCrtfdGrp: " + amtGrossEarnedCrtfdGrp + "\n" +
            " amtGrossUnearnedCrtfdGrp: " + amtGrossUnearnedCrtfdGrp + "\n" +
            " amtIncomeLimit: " + amtIncomeLimit + "\n" +
            " amtPweIncome: " + amtPweIncome + "\n" +
            " amtSsi: " + amtSsi + "\n" +
            " amtStepparentAlimony: " + amtStepparentAlimony + "\n" +
            " amtStepparentAllowance: " + amtStepparentAllowance + "\n" +
            " amtStepparentAppliedIncome: " + amtStepparentAppliedIncome + "\n" +
            " amtStepparentCntblUnearned: " + amtStepparentCntblUnearned + "\n" +
            " amtStepparentGrossEarned: " + amtStepparentGrossEarned + "\n" +
            " amtStepparentOutsidePmnt: " + amtStepparentOutsidePmnt + "\n" +
            " amtStepparentTotalCntbl: " + amtStepparentTotalCntbl + "\n" +
            " amtStepparentWorkDeduct: " + amtStepparentWorkDeduct + "\n" +
            " cdBlocChild: " + cdBlocChild + "\n" +
            " cdEligibilityActual: " + cdEligibilityActual + "\n" +
            " cdEligibilitySelected: " + cdEligibilitySelected + "\n" +
            " cdMedicaidEligibilityType: " + cdMedicaidEligibilityType + "\n" +
            " fceEligibilityCdPersonCitizenship: " + fceEligibilityCdPersonCitizenship + "\n" +
            " cdPweIrregularUnder100: " + cdPweIrregularUnder100 + "\n" +
            " cdPweSteadyUnder100: " + cdPweSteadyUnder100 + "\n" +
            " cdVerifMethod: " + cdVerifMethod + "\n" +
            " cdVerifDocType: " + cdVerifDocType + "\n" +
            " dtDeprivationChanged: " + dtDeprivationChanged + "\n" +    
            " dtEligibilityEnd: " + dtEligibilityEnd + "\n" +
            " dtEligDtrmntnStart: " + dtEligDtrmntnStart + "\n" +
            " fceEligibilityDtLastUpdate: " + fceEligibilityDtLastUpdate + "\n" +
            " dtRemovalChildOrdered: " + dtRemovalChildOrdered + "\n" +
            " dtReviewDate: " + dtReviewDate + "\n" +
            " dtRsnblEffortPreventRem: " + dtRsnblEffortPreventRem + "\n" +
            " idEligibilityEvent: " + idEligibilityEvent + "\n" +
            " idFcePerson: " + idFcePerson + "\n" +
            " idFceReview: " + idFceReview + "\n" +
            " idPrnEarner: " + idPrnEarner + "\n" +
            " indAbsentAltrntCustody: " + indAbsentAltrntCustody + "\n" +
            " indAbsentDeported: " + indAbsentDeported + "\n" +
            " indAbsentDeserted: " + indAbsentDeserted + "\n" +
            " indAbsentDied: " + indAbsentDied + "\n" +
            " indAbsentDivorced: " + indAbsentDivorced + "\n" +
            " indAbsentFather: " + indAbsentFather + "\n" +
            " indAbsentHospitalized: " + indAbsentHospitalized + "\n" +
            " indAbsentIncarcerated: " + indAbsentIncarcerated + "\n" +
            " indAbsentMilitaryWork: " + indAbsentMilitaryWork + "\n" +
            " indAbsentMother: " + indAbsentMother + "\n" +
            " indAbsentSeparated: " + indAbsentSeparated + "\n" +
            " indAbsentWorkRelated: " + indAbsentWorkRelated + "\n" +
            " indChildLivingPrnt6Mnths: " + indChildLivingPrnt6Mnths + "\n" +
            " indChildQualifiedCitizen: " + indChildQualifiedCitizen + "\n" +
            " indChildSupportOrdered: " + indChildSupportOrdered + "\n" +
            " indChildUnder18: " + indChildUnder18 + "\n" +
            " indCtznshpAmerIndianCrd: " + indCtznshpAmerIndianCrd + "\n" +
            " indCtznshpAttorneyReview: " + indCtznshpAttorneyReview + "\n" +
            " indCtznshpBirthCrtfctFor: " + indCtznshpBirthCrtfctFor + "\n" +
            " indCtznshpBirthCrtfctUs: " + indCtznshpBirthCrtfctUs + "\n" +
            " indCtznshpChldFound: " + indCtznshpChldFound + "\n" +
            " indCtznshpCitizenCrtfct: " + indCtznshpCitizenCrtfct + "\n" +
            " indCtznshpEvaluation: " + indCtznshpEvaluation + "\n" +
            " indCtznshpForDocumentation: " + indCtznshpForDocumentation + "\n" +
            " indCtznshpHospitalCrtfct: " + indCtznshpHospitalCrtfct + "\n" +
            " indCtznshpNoDocumentation: " + indCtznshpNoDocumentation + "\n" +
            " indCtznshpNtrlztnCrtfct: " + indCtznshpNtrlztnCrtfct + "\n" +
            " indCtznshpPassport: " + indCtznshpPassport + "\n" +
            " indCtznshpResidentCard: " + indCtznshpResidentCard + "\n" +
            " indCtznshpUnaccMinorChild: " + indCtznshpUnaccMinorChild + "\n" +
            " indCtznshpUndocImmigrant: " + indCtznshpUndocImmigrant + "\n" +
            " indCtznshpUsHsptlBrthRcrd: " + indCtznshpUsHsptlBrthRcrd + "\n" +
            " indCtznshpUsIdCard: " + indCtznshpUsIdCard + "\n" +
            " indCtznshpVitalBirthRcrd: " + indCtznshpVitalBirthRcrd + "\n" +
            " indCtznshpDriverLicOrId: " + indCtznshpDriverLicOrId + "\n" +
            " indCtznshpCertIndBlood: " + indCtznshpCertIndBlood + "\n" +
            " indCtznshpDocImmigNatAct: " + indCtznshpDocImmigNatAct + "\n" +
            " indCtznshpSchoolIdPhoto: " + indCtznshpSchoolIdPhoto + "\n" +
            " indCtznshpMilitaryDepdntId: " + indCtznshpMilitaryDepdntId + "\n" +
            " indCtznshpSchoolRec: " + indCtznshpSchoolRec + "\n" +
            " indCtznshpClinicDocHosDoc: " + indCtznshpClinicDocHosDoc + "\n" +
            " indCtznshpDaycareNurseRcrd: " + indCtznshpDaycareNurseRcrd + "\n" +
            " indCtznshpAffidavitSigned: " + indCtznshpAffidavitSigned + "\n" +
            " indCtznshpCertReportBirth: " + indCtznshpCertReportBirth + "\n" +
            " indCtznshpSaveSystem: " + indCtznshpSaveSystem + "\n" +
            " indCtznshpStudentVisa: " + indCtznshpStudentVisa + "\n" +
            " indCtznshpSuccessSystem: " + indCtznshpSuccessSystem + "\n" +
            " indCtznshpBirthAbroad: " + indCtznshpBirthAbroad + "\n" +
            " indCtznshpCensusBirthRcrd: " + indCtznshpCensusBirthRcrd + "\n" +
            " indCtznshpCivilServiceEmp: " + indCtznshpCivilServiceEmp + "\n" +
            " indCtznshpConfrmBirth: " + indCtznshpConfrmBirth + "\n" +
            " indCtznshpFinalAdoptDecree: " + indCtznshpFinalAdoptDecree + "\n" +
            " indCtznshpLeglImmiStatExp: " + indCtznshpLeglImmiStatExp + "\n" +
            " indCtznshpLifeInsBrthRcrd: " + indCtznshpLifeInsBrthRcrd + "\n" +
            " indCtznshpLoclGovtBrthRcrd: " + indCtznshpLoclGovtBrthRcrd + "\n" +
            " indCtznshpMedBirthRcrd: " + indCtznshpMedBirthRcrd + "\n" +
            " indCtznshpMiltryBirthRcrd: " + indCtznshpMiltryBirthRcrd + "\n" +
            " indCtznshpNorthMarianaId: " + indCtznshpNorthMarianaId + "\n" +
            " indCtznshpRefugee: " + indCtznshpRefugee + "\n" +
            " indCtznshpReligBirthRcrd: " + indCtznshpReligBirthRcrd + "\n" +
            " indEligibilityCourtMonth: " + indEligibilityCourtMonth + "\n" +
            " indEligible: " + indEligible + "\n" +
            " indEquity: " + indEquity + "\n" +
            " indFatherPwe: " + indFatherPwe + "\n" +
            " indHomeIncomeAfdcElgblty: " + indHomeIncomeAfdcElgblty + "\n" +
            " indMeetsDpOrNotEs: " + indMeetsDpOrNotEs + "\n" +
            " indMeetsDpOrNotSystem: " + indMeetsDpOrNotSystem + "\n" +
            " indMotherPwe: " + indMotherPwe + "\n" +
            " indNarrativeApproved: " + indNarrativeApproved + "\n" +
            " indOtherVerification: " + indOtherVerification + "\n" +
            " indParentalDeprivation: " + indParentalDeprivation + "\n" +
            " indParentDisabled: " + indParentDisabled + "\n" +
            " indPeNotAcptEmpTrn: " + indPeNotAcptEmpTrn + "\n" +
            " indPeRecvUnemp: " + indPeRecvUnemp + "\n" +
            " indPeWrkEngEduTrn: " + indPeWrkEngEduTrn + "\n" +
            " indPrsManagingCvs: " + indPrsManagingCvs + "\n" +
            " indRecv100PctVa: " + indRecv100PctVa + "\n" +
            " indRecvRrRsdi: " + indRecvRrRsdi + "\n" +
            " indRemovalChildOrdered: " + indRemovalChildOrdered + "\n" +
            " indRsdiVerification: " + indRsdiVerification + "\n" +
            " indRsnblEffortPrvtRemoval: " + indRsnblEffortPrvtRemoval + "\n" +
            " indSsiVerification: " + indSsiVerification + "\n" +
            " nbrCertifiedGroup: " + nbrCertifiedGroup + "\n" +
            " nbrParentsHome: " + nbrParentsHome + "\n" +
            " txtDeterminationComments: " + txtDeterminationComments + "\n" +
            " txtMonthsDepUnemp: " + txtMonthsDepUnemp + "\n" +
            " cdRelInt: " + cdRelInt + "\n" +
            " dtBirth: " + dtBirth + "\n" +
            " fcePersonDtLastUpdate: " + fcePersonDtLastUpdate + "\n" +
            " indCertifiedGroup: " + indCertifiedGroup + "\n" +
            " indDobApprox: " + indDobApprox + "\n" +
            " indPersonHmRemoval: " + indPersonHmRemoval + "\n" +
            " nbrAge: " + nbrAge + "\n" +
            " cdEventStatus: " + cdEventStatus + "\n" +
            "END bean: AgeCitizenship\n";
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
