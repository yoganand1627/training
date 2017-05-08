//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class DomicileDeprivationDB implements Serializable, FceApplicationPageDB {
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
  public static final String ID_PRN_EARNER = "idPrnEarner";
  public static final String ID_FCE_REVIEW = "idFceReview";
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
  public static final String IND_ABSENT_TPR_VOL_RELINQ = "indAbsentTprVolRelinq";
  public static final String TXT_MONTHS_DEP_DISABLED = "txtMonthsDepDisabled";
  public static final String TXT_MONTHS_DEP_UNDER_EMPL = "txtMonthsDepUnderEmpl";
  public static final String TXT_MONTHS_LIVING_REL_CUST = "txtMonthsLivingRelCust";
  public static final String PRINCIPLES = "principles";
  public static final String _BOTH6_M_AMT_PWE_INCOME_MONEY = "Both6M_amtPweIncomeMoney";
  public static final String _BOTH6_M_AMT_PWE_INCOME = "Both6M_amtPweIncome";
  public static final String _BOTH6_M_CD_PWE_IRREGULAR_UNDER100 = "Both6M_cdPweIrregularUnder100";
  public static final String _BOTH6_M_CD_PWE_STEADY_UNDER100 = "Both6M_cdPweSteadyUnder100";
  public static final String _BOTH6_M_CD_VERIF_METHOD = "Both6M_cdVerifMethod";
  public static final String _BOTH6_M_CD_VERIF_DOC_TYPE = "Both6M_cdVerifDocType";
  public static final String _BOTH6_M_ID_PRN_EARNER = "Both6_M_idPrnEarner";
  public static final String _BOTH6_M_IND_FATHER_PWE = "Both6M_indFatherPwe";
  public static final String _BOTH6_M_IND_MOTHER_PWE = "Both6M_indMotherPwe";
  public static final String _BOTH6_M_IND_OTHER_VERIFICATION = "Both6M_indOtherVerification";
  public static final String _BOTH6_M_IND_PARENT_DISABLED = "Both6M_indParentDisabled";
  public static final String _BOTH6_M_IND_PE_NOT_ACPT_EMP_TRN = "Both6M_indPeNotAcptEmpTrn";
  public static final String _BOTH6_M_IND_PE_RECV_UNEMP = "Both6M_indPeRecvUnemp";
  public static final String _BOTH6_M_IND_PE_WRK_ENG_EDU_TRN = "Both6M_indPeWrkEngEduTrn";
  public static final String _BOTH6_M_IND_RECV_100_PCT_VA = "Both6M_indRecv100PctVa";
  public static final String _BOTH6_M_IND_RECV_RR_RSDI = "Both6M_indRecvRrRsdi";
  public static final String _BOTH6_M_IND_RSDI_VERIFICATION = "Both6M_indRsdiVerification";
  public static final String _BOTH6_M_IND_SSI_VERIFICATION = "Both6M_indSsiVerification";
  public static final String _BOTH_AMT_PWE_INCOME_MONEY = "Both_amtPweIncomeMoney";
  public static final String _BOTH_AMT_PWE_INCOME = "Both_amtPweIncome";
  public static final String _BOTH_CD_PWE_IRREGULAR_UNDER100 = "Both_cdPweIrregularUnder100";
  public static final String _BOTH_CD_PWE_STEADY_UNDER100 = "Both_cdPweSteadyUnder100";
  public static final String _BOTH_CD_VERIF_METHOD = "Both_cdVerifMethod";
  public static final String _BOTH_CD_VERIF_DOC_TYPE = "Both_cdVerifDocType";
  public static final String _BOTH_ID_PRN_EARNER = "Both_idPrnEarner";
  public static final String _BOTH_IND_FATHER_PWE = "Both_indFatherPwe";
  public static final String _BOTH_IND_MOTHER_PWE = "Both_indMotherPwe";
  public static final String _BOTH_IND_OTHER_VERIFICATION = "Both_indOtherVerification";
  public static final String _BOTH_IND_PARENT_DISABLED = "Both_indParentDisabled";
  public static final String _BOTH_IND_PE_NOT_ACPT_EMP_TRN = "Both_indPeNotAcptEmpTrn";
  public static final String _BOTH_IND_PE_RECV_UNEMP = "Both_indPeRecvUnemp";
  public static final String _BOTH_IND_PE_WRK_ENG_EDU_TRN = "Both_indPeWrkEngEduTrn";
  public static final String _BOTH_IND_RECV_100_PCT_VA = "Both_indRecv100PctVa";
  public static final String _BOTH_IND_RECV_RR_RSDI = "Both_indRecvRrRsdi";
  public static final String _BOTH_IND_RSDI_VERIFICATION = "Both_indRsdiVerification";
  public static final String _BOTH_IND_SSI_VERIFICATION = "Both_indSsiVerification";
  public static final String _NOTA_CD_NOTA_MOST_RECENT = "Nota_cdNotaMostRecent";
  public static final String _NOTA_IND_CHILD_LIVING_PRNT6_MNTHS = "Nota_indChildLivingPrnt6Mnths";
  public static final String _ONE6_M_IND_ABSENT_ALTRNT_CUSTODY = "One6M_indAbsentAltrntCustody";
  public static final String _ONE6_M_IND_ABSENT_DEPORTED = "One6M_indAbsentDeported";
  public static final String _ONE6_M_IND_ABSENT_DESERTED = "One6M_indAbsentDeserted";
  public static final String _ONE6_M_IND_ABSENT_DIED = "One6M_indAbsentDied";
  public static final String _ONE6_M_IND_ABSENT_DIVORCED = "One6M_indAbsentDivorced";
  public static final String _ONE6_M_IND_ABSENT_FATHER = "One6M_indAbsentFather";
  public static final String _ONE6_M_IND_ABSENT_HOSPITALIZED = "One6M_indAbsentHospitalized";
  public static final String _ONE6_M_IND_ABSENT_INCARCERATED = "One6M_indAbsentIncarcerated";
  public static final String _ONE6_M_IND_ABSENT_MILITARY_WORK = "One6M_indAbsentMilitaryWork";
  public static final String _ONE6_M_IND_ABSENT_MOTHER = "One6M_indAbsentMother";
  public static final String _ONE6_M_IND_ABSENT_SEPARATED = "One6M_indAbsentSeparated";
  public static final String _ONE6_M_IND_ABSENT_WORK_RELATED = "One6M_indAbsentWorkRelated";
  public static final String _ONE_IND_ABSENT_ALTRNT_CUSTODY = "One_indAbsentAltrntCustody";
  public static final String _ONE_IND_ABSENT_DEPORTED = "One_indAbsentDeported";
  public static final String _ONE_IND_ABSENT_DESERTED = "One_indAbsentDeserted";
  public static final String _ONE_IND_ABSENT_DIED = "One_indAbsentDied";
  public static final String _ONE_IND_ABSENT_DIVORCED = "One_indAbsentDivorced";
  public static final String _ONE_IND_ABSENT_FATHER = "One_indAbsentFather";
  public static final String _ONE_IND_ABSENT_HOSPITALIZED = "One_indAbsentHospitalized";
  public static final String _ONE_IND_ABSENT_INCARCERATED = "One_indAbsentIncarcerated";
  public static final String _ONE_IND_ABSENT_MILITARY_WORK = "One_indAbsentMilitaryWork";
  public static final String _ONE_IND_ABSENT_MOTHER = "One_indAbsentMother";
  public static final String _ONE_IND_ABSENT_SEPARATED = "One_indAbsentSeparated";
  public static final String _ONE_IND_ABSENT_WORK_RELATED = "One_indAbsentWorkRelated";
  public static final String _OTHER6_M_IND_SPECIFIED_RELATIVE = "Other6_M_indSpecifiedRelative";
  public static final String _OTHER_ID_MNGNG_CVS_PERSON = "Other_idMngngCvsPerson";
  public static final String _OTHER_ID_OTHER_RELATIVE_PERSON = "Other_idOtherRelativePerson";
  public static final String _OTHER_IND_SPECIFIED_RELATIVE = "Other_indSpecifiedRelative";
  public static final String CD_EVENT_STATUS = "cdEventStatus";
  public static final String IND_ABSENT_NEVER_COHABITATED = "indAbsentNeverCohabitated";
  public static final String _ONE_IND_ABSENT_NEVER_COHABITATED = "One_indAbsentNeverCohabitated";
  public static final String _ONE6_M_IND_ABSENT_NEVER_COHABITATED = "One6M_indAbsentNeverCohabitated";
  public static final String NBR_STEPPARENT_CHILDREN = "nbrStepparentChildren";

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
  protected boolean hasCdVerifMethod = false;
  protected String cdVerifMethod = null;
  protected boolean hasCdVerifDocType = false;
  protected String cdVerifDocType = null;
  protected boolean hasDtDeprivationChanged = false;
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
  protected boolean hasIndAbsentTprVolRelinq = false;
  protected Boolean indAbsentTprVolRelinq = null;
  protected boolean hasTxtMonthsDepDisabled = false;
  protected String txtMonthsDepDisabled = null;
  protected boolean hasTxtMonthsDepUnderEmpl = false;
  protected String txtMonthsDepUnderEmpl = null;
  protected boolean hasTxtMonthsLivingRelCust = false;
  protected String txtMonthsLivingRelCust = null;
  protected boolean hasPrinciples = false;
  protected List principles = null;
  protected boolean hasBoth6M_amtPweIncome = false;
  protected Double Both6M_amtPweIncome = null;
  protected boolean hasBoth6M_cdPweIrregularUnder100 = false;
  protected String Both6M_cdPweIrregularUnder100 = null;
  protected boolean hasBoth6M_cdPweSteadyUnder100 = false;
  protected String Both6M_cdPweSteadyUnder100 = null;
  protected boolean hasBoth6M_cdVerifMethod = false;
  protected String Both6M_cdVerifMethod = null;
  protected boolean hasBoth6M_cdVerifDocType = false;
  protected String Both6M_cdVerifDocType = null;
  protected boolean hasBoth6M_idPrnEarner = false;
  protected Long Both6M_idPrnEarner = null;
  protected boolean hasBoth6M_indFatherPwe = false;
  protected Boolean Both6M_indFatherPwe = null;
  protected boolean hasBoth6M_indMotherPwe = false;
  protected Boolean Both6M_indMotherPwe = null;
  protected boolean hasBoth6M_indOtherVerification = false;
  protected Boolean Both6M_indOtherVerification = null;
  protected boolean hasBoth6M_indParentDisabled = false;
  protected Boolean Both6M_indParentDisabled = null;
  protected boolean hasBoth6M_indPeNotAcptEmpTrn = false;
  protected Boolean Both6M_indPeNotAcptEmpTrn = null;
  protected boolean hasBoth6M_indPeRecvUnemp = false;
  protected Boolean Both6M_indPeRecvUnemp = null;
  protected boolean hasBoth6M_indPeWrkEngEduTrn = false;
  protected Boolean Both6M_indPeWrkEngEduTrn = null;
  protected boolean hasBoth6M_indRecv100PctVa = false;
  protected Boolean Both6M_indRecv100PctVa = null;
  protected boolean hasBoth6M_indRecvRrRsdi = false;
  protected Boolean Both6M_indRecvRrRsdi = null;
  protected boolean hasBoth6M_indRsdiVerification = false;
  protected Boolean Both6M_indRsdiVerification = null;
  protected boolean hasBoth6M_indSsiVerification = false;
  protected Boolean Both6M_indSsiVerification = null;
  protected boolean hasBoth_amtPweIncome = false;
  protected Double Both_amtPweIncome = null;
  protected boolean hasBoth_cdPweIrregularUnder100 = false;
  protected String Both_cdPweIrregularUnder100 = null;
  protected boolean hasBoth_cdPweSteadyUnder100 = false;
  protected String Both_cdPweSteadyUnder100 = null;
  protected boolean hasBoth_cdVerifMethod = false;
  protected String Both_cdVerifMethod = null;
  protected boolean hasBoth_cdVerifDocType = false;
  protected String Both_cdVerifDocType = null;
  protected boolean hasBoth_idPrnEarner = false;
  protected Long Both_idPrnEarner = null;
  protected boolean hasBoth_indFatherPwe = false;
  protected Boolean Both_indFatherPwe = null;
  protected boolean hasBoth_indMotherPwe = false;
  protected Boolean Both_indMotherPwe = null;
  protected boolean hasBoth_indOtherVerification = false;
  protected Boolean Both_indOtherVerification = null;
  protected boolean hasBoth_indParentDisabled = false;
  protected Boolean Both_indParentDisabled = null;
  protected boolean hasBoth_indPeNotAcptEmpTrn = false;
  protected Boolean Both_indPeNotAcptEmpTrn = null;
  protected boolean hasBoth_indPeRecvUnemp = false;
  protected Boolean Both_indPeRecvUnemp = null;
  protected boolean hasBoth_indPeWrkEngEduTrn = false;
  protected Boolean Both_indPeWrkEngEduTrn = null;
  protected boolean hasBoth_indRecv100PctVa = false;
  protected Boolean Both_indRecv100PctVa = null;
  protected boolean hasBoth_indRecvRrRsdi = false;
  protected Boolean Both_indRecvRrRsdi = null;
  protected boolean hasBoth_indRsdiVerification = false;
  protected Boolean Both_indRsdiVerification = null;
  protected boolean hasBoth_indSsiVerification = false;
  protected Boolean Both_indSsiVerification = null;
  protected boolean hasNota_cdNotaMostRecent = false;
  protected String Nota_cdNotaMostRecent = null;
  protected boolean hasNota_indChildLivingPrnt6Mnths = false;
  protected Boolean Nota_indChildLivingPrnt6Mnths = null;
  protected boolean hasOne6M_indAbsentAltrntCustody = false;
  protected Boolean One6M_indAbsentAltrntCustody = null;
  protected boolean hasOne6M_indAbsentDeported = false;
  protected Boolean One6M_indAbsentDeported = null;
  protected boolean hasOne6M_indAbsentDeserted = false;
  protected Boolean One6M_indAbsentDeserted = null;
  protected boolean hasOne6M_indAbsentDied = false;
  protected Boolean One6M_indAbsentDied = null;
  protected boolean hasOne6M_indAbsentDivorced = false;
  protected Boolean One6M_indAbsentDivorced = null;
  protected boolean hasOne6M_indAbsentFather = false;
  protected Boolean One6M_indAbsentFather = null;
  protected boolean hasOne6M_indAbsentHospitalized = false;
  protected Boolean One6M_indAbsentHospitalized = null;
  protected boolean hasOne6M_indAbsentIncarcerated = false;
  protected Boolean One6M_indAbsentIncarcerated = null;
  protected boolean hasOne6M_indAbsentMilitaryWork = false;
  protected Boolean One6M_indAbsentMilitaryWork = null;
  protected boolean hasOne6M_indAbsentMother = false;
  protected Boolean One6M_indAbsentMother = null;
  protected boolean hasOne6M_indAbsentSeparated = false;
  protected Boolean One6M_indAbsentSeparated = null;
  protected boolean hasOne6M_indAbsentWorkRelated = false;
  protected Boolean One6M_indAbsentWorkRelated = null;
  protected boolean hasOne_indAbsentAltrntCustody = false;
  protected Boolean One_indAbsentAltrntCustody = null;
  protected boolean hasOne_indAbsentDeported = false;
  protected Boolean One_indAbsentDeported = null;
  protected boolean hasOne_indAbsentDeserted = false;
  protected Boolean One_indAbsentDeserted = null;
  protected boolean hasOne_indAbsentDied = false;
  protected Boolean One_indAbsentDied = null;
  protected boolean hasOne_indAbsentDivorced = false;
  protected Boolean One_indAbsentDivorced = null;
  protected boolean hasOne_indAbsentFather = false;
  protected Boolean One_indAbsentFather = null;
  protected boolean hasOne_indAbsentHospitalized = false;
  protected Boolean One_indAbsentHospitalized = null;
  protected boolean hasOne_indAbsentIncarcerated = false;
  protected Boolean One_indAbsentIncarcerated = null;
  protected boolean hasOne_indAbsentMilitaryWork = false;
  protected Boolean One_indAbsentMilitaryWork = null;
  protected boolean hasOne_indAbsentMother = false;
  protected Boolean One_indAbsentMother = null;
  protected boolean hasOne_indAbsentSeparated = false;
  protected Boolean One_indAbsentSeparated = null;
  protected boolean hasOne_indAbsentWorkRelated = false;
  protected Boolean One_indAbsentWorkRelated = null;
  protected boolean hasOther6M_indSpecifiedRelative = false;
  protected Boolean Other6M_indSpecifiedRelative = null;
  protected boolean hasOther_idMngngCvsPerson = false;
  protected Long Other_idMngngCvsPerson = null;
  protected boolean hasOther_idOtherRelativePerson = false;
  protected Long Other_idOtherRelativePerson = null;
  protected boolean hasOther_indSpecifiedRelative = false;
  protected Boolean Other_indSpecifiedRelative = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;
  protected boolean hasIndAbsentNeverCohabitated = false;
  protected Boolean indAbsentNeverCohabitated = null;
  protected boolean hasOne_indAbsentNeverCohabitated = false;
  protected Boolean One_indAbsentNeverCohabitated = null;
  protected boolean hasOne6M_indAbsentNeverCohabitated = false;
  protected Boolean One6M_indAbsentNeverCohabitated = null;
  protected boolean hasNbrStepparentChildren = false;
  protected Long nbrStepparentChildren = null;

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
    return amtCountableIncome.doubleValue();
  }

  public Double getAmtCountableIncomeObject() {
    return amtCountableIncome;
  }

  public String getAmtCountableIncomeString() {
    return FormattingHelper.formatDouble(amtCountableIncome);
  }

  public void setAmtCountableIncome(double amtCountableIncome) {
    this.hasAmtCountableIncome = true;
    this.amtCountableIncome = new Double(amtCountableIncome);
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
    return amtGrossEarnedCrtfdGrp.doubleValue();
  }

  public Double getAmtGrossEarnedCrtfdGrpObject() {
    return amtGrossEarnedCrtfdGrp;
  }

  public String getAmtGrossEarnedCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtGrossEarnedCrtfdGrp);
  }

  public void setAmtGrossEarnedCrtfdGrp(double amtGrossEarnedCrtfdGrp) {
    this.hasAmtGrossEarnedCrtfdGrp = true;
    this.amtGrossEarnedCrtfdGrp = new Double(amtGrossEarnedCrtfdGrp);
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
    return amtGrossUnearnedCrtfdGrp.doubleValue();
  }

  public Double getAmtGrossUnearnedCrtfdGrpObject() {
    return amtGrossUnearnedCrtfdGrp;
  }

  public String getAmtGrossUnearnedCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtGrossUnearnedCrtfdGrp);
  }

  public void setAmtGrossUnearnedCrtfdGrp(double amtGrossUnearnedCrtfdGrp) {
    this.hasAmtGrossUnearnedCrtfdGrp = true;
    this.amtGrossUnearnedCrtfdGrp = new Double(amtGrossUnearnedCrtfdGrp);
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
    return amtIncomeLimit.doubleValue();
  }

  public Double getAmtIncomeLimitObject() {
    return amtIncomeLimit;
  }

  public String getAmtIncomeLimitString() {
    return FormattingHelper.formatDouble(amtIncomeLimit);
  }

  public void setAmtIncomeLimit(double amtIncomeLimit) {
    this.hasAmtIncomeLimit = true;
    this.amtIncomeLimit = new Double(amtIncomeLimit);
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
    return amtPweIncome.doubleValue();
  }

  public Double getAmtPweIncomeObject() {
    return amtPweIncome;
  }

  public String getAmtPweIncomeString() {
    return FormattingHelper.formatDouble(amtPweIncome);
  }

  public void setAmtPweIncome(double amtPweIncome) {
    this.hasAmtPweIncome = true;
    this.amtPweIncome = new Double(amtPweIncome);
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
    return amtSsi.doubleValue();
  }

  public Double getAmtSsiObject() {
    return amtSsi;
  }

  public String getAmtSsiString() {
    return FormattingHelper.formatDouble(amtSsi);
  }

  public void setAmtSsi(double amtSsi) {
    this.hasAmtSsi = true;
    this.amtSsi = new Double(amtSsi);
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
    return amtStepparentAlimony.doubleValue();
  }

  public Double getAmtStepparentAlimonyObject() {
    return amtStepparentAlimony;
  }

  public String getAmtStepparentAlimonyString() {
    return FormattingHelper.formatDouble(amtStepparentAlimony);
  }

  public void setAmtStepparentAlimony(double amtStepparentAlimony) {
    this.hasAmtStepparentAlimony = true;
    this.amtStepparentAlimony = new Double(amtStepparentAlimony);
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
    return amtStepparentAllowance.doubleValue();
  }

  public Double getAmtStepparentAllowanceObject() {
    return amtStepparentAllowance;
  }

  public String getAmtStepparentAllowanceString() {
    return FormattingHelper.formatDouble(amtStepparentAllowance);
  }

  public void setAmtStepparentAllowance(double amtStepparentAllowance) {
    this.hasAmtStepparentAllowance = true;
    this.amtStepparentAllowance = new Double(amtStepparentAllowance);
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
    return amtStepparentAppliedIncome.doubleValue();
  }

  public Double getAmtStepparentAppliedIncomeObject() {
    return amtStepparentAppliedIncome;
  }

  public String getAmtStepparentAppliedIncomeString() {
    return FormattingHelper.formatDouble(amtStepparentAppliedIncome);
  }

  public void setAmtStepparentAppliedIncome(double amtStepparentAppliedIncome) {
    this.hasAmtStepparentAppliedIncome = true;
    this.amtStepparentAppliedIncome = new Double(amtStepparentAppliedIncome);
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
    return amtStepparentCntblUnearned.doubleValue();
  }

  public Double getAmtStepparentCntblUnearnedObject() {
    return amtStepparentCntblUnearned;
  }

  public String getAmtStepparentCntblUnearnedString() {
    return FormattingHelper.formatDouble(amtStepparentCntblUnearned);
  }

  public void setAmtStepparentCntblUnearned(double amtStepparentCntblUnearned) {
    this.hasAmtStepparentCntblUnearned = true;
    this.amtStepparentCntblUnearned = new Double(amtStepparentCntblUnearned);
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
    return amtStepparentGrossEarned.doubleValue();
  }

  public Double getAmtStepparentGrossEarnedObject() {
    return amtStepparentGrossEarned;
  }

  public String getAmtStepparentGrossEarnedString() {
    return FormattingHelper.formatDouble(amtStepparentGrossEarned);
  }

  public void setAmtStepparentGrossEarned(double amtStepparentGrossEarned) {
    this.hasAmtStepparentGrossEarned = true;
    this.amtStepparentGrossEarned = new Double(amtStepparentGrossEarned);
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
    return amtStepparentOutsidePmnt.doubleValue();
  }

  public Double getAmtStepparentOutsidePmntObject() {
    return amtStepparentOutsidePmnt;
  }

  public String getAmtStepparentOutsidePmntString() {
    return FormattingHelper.formatDouble(amtStepparentOutsidePmnt);
  }

  public void setAmtStepparentOutsidePmnt(double amtStepparentOutsidePmnt) {
    this.hasAmtStepparentOutsidePmnt = true;
    this.amtStepparentOutsidePmnt = new Double(amtStepparentOutsidePmnt);
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
    return amtStepparentTotalCntbl.doubleValue();
  }

  public Double getAmtStepparentTotalCntblObject() {
    return amtStepparentTotalCntbl;
  }

  public String getAmtStepparentTotalCntblString() {
    return FormattingHelper.formatDouble(amtStepparentTotalCntbl);
  }

  public void setAmtStepparentTotalCntbl(double amtStepparentTotalCntbl) {
    this.hasAmtStepparentTotalCntbl = true;
    this.amtStepparentTotalCntbl = new Double(amtStepparentTotalCntbl);
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
    return amtStepparentWorkDeduct.doubleValue();
  }

  public Double getAmtStepparentWorkDeductObject() {
    return amtStepparentWorkDeduct;
  }

  public String getAmtStepparentWorkDeductString() {
    return FormattingHelper.formatDouble(amtStepparentWorkDeduct);
  }

  public void setAmtStepparentWorkDeduct(double amtStepparentWorkDeduct) {
    this.hasAmtStepparentWorkDeduct = true;
    this.amtStepparentWorkDeduct = new Double(amtStepparentWorkDeduct);
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
    return idEligibilityEvent.longValue();
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
    this.idEligibilityEvent = new Long(idEligibilityEvent);
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
    return idFcePerson.longValue();
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
    this.idFcePerson = new Long(idFcePerson);
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
    return idFceReview.longValue();
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
    this.idFceReview = new Long(idFceReview);
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
    return indAbsentAltrntCustody.booleanValue();
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
    this.indAbsentAltrntCustody = new Boolean(indAbsentAltrntCustody);
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
    return indAbsentDeported.booleanValue();
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
    this.indAbsentDeported = new Boolean(indAbsentDeported);
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
    return indAbsentDeserted.booleanValue();
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
    this.indAbsentDeserted = new Boolean(indAbsentDeserted);
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
    return indAbsentDied.booleanValue();
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
    this.indAbsentDied = new Boolean(indAbsentDied);
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
    return indAbsentDivorced.booleanValue();
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
    this.indAbsentDivorced = new Boolean(indAbsentDivorced);
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
    return indAbsentFather.booleanValue();
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
    this.indAbsentFather = new Boolean(indAbsentFather);
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
    return indAbsentHospitalized.booleanValue();
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
    this.indAbsentHospitalized = new Boolean(indAbsentHospitalized);
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
    return indAbsentIncarcerated.booleanValue();
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
    this.indAbsentIncarcerated = new Boolean(indAbsentIncarcerated);
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
    return indAbsentMilitaryWork.booleanValue();
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
    this.indAbsentMilitaryWork = new Boolean(indAbsentMilitaryWork);
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
    return indAbsentMother.booleanValue();
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
    this.indAbsentMother = new Boolean(indAbsentMother);
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
    return indAbsentSeparated.booleanValue();
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
    this.indAbsentSeparated = new Boolean(indAbsentSeparated);
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
    return indAbsentWorkRelated.booleanValue();
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
    this.indAbsentWorkRelated = new Boolean(indAbsentWorkRelated);
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
    return indChildLivingPrnt6Mnths.booleanValue();
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
    this.indChildLivingPrnt6Mnths = new Boolean(indChildLivingPrnt6Mnths);
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
    return indChildQualifiedCitizen.booleanValue();
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
    this.indChildQualifiedCitizen = new Boolean(indChildQualifiedCitizen);
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
    return indChildSupportOrdered.booleanValue();
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
    this.indChildSupportOrdered = new Boolean(indChildSupportOrdered);
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
    return indChildUnder18.booleanValue();
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
    this.indChildUnder18 = new Boolean(indChildUnder18);
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
    return indEligibilityCourtMonth.booleanValue();
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
    this.indEligibilityCourtMonth = new Boolean(indEligibilityCourtMonth);
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
    return indEligible.booleanValue();
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
    this.indEligible = new Boolean(indEligible);
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
    return indEquity.booleanValue();
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
    this.indEquity = new Boolean(indEquity);
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
    return indFatherPwe.booleanValue();
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
    this.indFatherPwe = new Boolean(indFatherPwe);
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
    return indHomeIncomeAfdcElgblty.booleanValue();
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
    this.indHomeIncomeAfdcElgblty = new Boolean(indHomeIncomeAfdcElgblty);
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
    return indMeetsDpOrNotEs.booleanValue();
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
    this.indMeetsDpOrNotEs = new Boolean(indMeetsDpOrNotEs);
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
    return indMeetsDpOrNotSystem.booleanValue();
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
    this.indMeetsDpOrNotSystem = new Boolean(indMeetsDpOrNotSystem);
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
    return indMotherPwe.booleanValue();
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
    this.indMotherPwe = new Boolean(indMotherPwe);
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
    return indNarrativeApproved.booleanValue();
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
    this.indNarrativeApproved = new Boolean(indNarrativeApproved);
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
    return indOtherVerification.booleanValue();
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
    this.indOtherVerification = new Boolean(indOtherVerification);
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
    return indParentalDeprivation.booleanValue();
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
    this.indParentalDeprivation = new Boolean(indParentalDeprivation);
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
    return indParentDisabled.booleanValue();
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
    this.indParentDisabled = new Boolean(indParentDisabled);
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
    return indPrsManagingCvs.booleanValue();
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
    this.indPrsManagingCvs = new Boolean(indPrsManagingCvs);
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
    return indRemovalChildOrdered.booleanValue();
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
    this.indRemovalChildOrdered = new Boolean(indRemovalChildOrdered);
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
    return indRsdiVerification.booleanValue();
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
    this.indRsdiVerification = new Boolean(indRsdiVerification);
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
    return indRsnblEffortPrvtRemoval.booleanValue();
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
    this.indRsnblEffortPrvtRemoval = new Boolean(indRsnblEffortPrvtRemoval);
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
    return indSsiVerification.booleanValue();
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
    this.indSsiVerification = new Boolean(indSsiVerification);
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
    return nbrCertifiedGroup.longValue();
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
    this.nbrCertifiedGroup = new Long(nbrCertifiedGroup);
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
    return nbrParentsHome.longValue();
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
    this.nbrParentsHome = new Long(nbrParentsHome);
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
  
  public boolean hasIndAbsentTprVolRelinq() {
    return hasIndAbsentTprVolRelinq;
}

public boolean getIndAbsentTprVolRelinq() {
    if (indAbsentTprVolRelinq == null) {
      return false;
    }
    return indAbsentTprVolRelinq.booleanValue();
  }

  public Boolean getIndAbsentTprVolRelinqObject() {
    return indAbsentTprVolRelinq;
  }

  public String getIndAbsentTprVolRelinqString() {
    if (indAbsentTprVolRelinq == null) {
      return "";
    }
    return indAbsentTprVolRelinq.toString();
  }

  public void setIndAbsentTprVolRelinq(boolean indAbsentTprVolRelinq) {
    this.hasIndAbsentTprVolRelinq = true;
    this.indAbsentTprVolRelinq = new Boolean(indAbsentTprVolRelinq);
  }

  public void setIndAbsentTprVolRelinq(Boolean indAbsentTprVolRelinq) {
    this.hasIndAbsentTprVolRelinq = true;
    this.indAbsentTprVolRelinq = indAbsentTprVolRelinq;
  }

  public void setIndAbsentTprVolRelinq(String indAbsentTprVolRelinq) {
    this.hasIndAbsentTprVolRelinq = true;
    this.indAbsentTprVolRelinq = isTrueBoolean(indAbsentTprVolRelinq);
  }
  
  public boolean hasTxtMonthsDepDisabled() {
    return hasTxtMonthsDepDisabled;
  }
  
  public String getTxtMonthsDepDisabled() {
    if (txtMonthsDepDisabled == null) {
      return "";
    }
    return txtMonthsDepDisabled;
  }
  
  public String getTxtMonthsDepDisabledObject() {
    return txtMonthsDepDisabled;
  }
  
  public void setTxtMonthsDepDisabled(String txtMonthsDepDisabled) {
    if ((txtMonthsDepDisabled != null) &&
                    (txtMonthsDepDisabled.length() > 100)) {
      throw new IllegalStateException("Data is too large for 'txtMonthsDepDisabled'; \n" +
                                      " max size = 100; \n" +
                                      " data = '" + txtMonthsDepDisabled + "'");
    }
    this.hasTxtMonthsDepDisabled = true;
    this.txtMonthsDepDisabled = txtMonthsDepDisabled;
  }
  
  public boolean hasTxtMonthsDepUnderEmpl() {
    return hasTxtMonthsDepUnderEmpl;
  }
  
  public String getTxtMonthsDepUnderEmpl() {
    if (txtMonthsDepUnderEmpl == null) {
      return "";
    }
    return txtMonthsDepUnderEmpl;
  }
  
  public String getTxtMonthsDepUnderEmplObject() {
    return txtMonthsDepUnderEmpl;
  }
  
  public void setTxtMonthsDepUnderEmpl(String txtMonthsDepUnderEmpl) {
    if ((txtMonthsDepUnderEmpl != null) &&
                    (txtMonthsDepUnderEmpl.length() > 100)) {
      throw new IllegalStateException("Data is too large for 'txtMonthsDepUnderEmpl'; \n" +
                                      " max size = 100; \n" +
                                      " data = '" + txtMonthsDepUnderEmpl + "'");
    }
    this.hasTxtMonthsDepUnderEmpl = true;
    this.txtMonthsDepUnderEmpl = txtMonthsDepUnderEmpl;
  }
  
  public boolean hasTxtMonthsLivingRelCust() {
    return hasTxtMonthsLivingRelCust;
  }
  
  public String getTxtMonthsLivingRelCust() {
    if (txtMonthsLivingRelCust == null) {
      return "";
    }
    return txtMonthsLivingRelCust;
  }
  
  public String getTxtMonthsLivingRelCustObject() {
    return txtMonthsLivingRelCust;
  }
  
  public void setTxtMonthsLivingRelCust(String txtMonthsLivingRelCust) {
    if ((txtMonthsLivingRelCust != null) &&
                    (txtMonthsLivingRelCust.length() > 100)) {
      throw new IllegalStateException("Data is too large for 'txtMonthsLivingRelCust'; \n" +
                                      " max size = 100; \n" +
                                      " data = '" + txtMonthsLivingRelCust + "'");
    }
    this.hasTxtMonthsLivingRelCust = true;
    this.txtMonthsLivingRelCust = txtMonthsLivingRelCust;
  }

  public List getPrinciples() {
    return principles;
  }

  public void setPrinciples(List principles) {
    this.hasPrinciples = true;
    this.principles = principles;
  }

  public boolean hasBoth6M_amtPweIncome() {
    return hasBoth6M_amtPweIncome;
  }

  public double getBoth6M_amtPweIncome() {
    if (Both6M_amtPweIncome == null) {
      return (double) 0;
    }
    return Both6M_amtPweIncome.doubleValue();
  }

  public Double getBoth6M_amtPweIncomeObject() {
    return Both6M_amtPweIncome;
  }

  public String getBoth6M_amtPweIncomeString() {
    return FormattingHelper.formatDouble(Both6M_amtPweIncome);
  }

  public void setBoth6M_amtPweIncome(double Both6M_amtPweIncome) {
    this.hasBoth6M_amtPweIncome = true;
    this.Both6M_amtPweIncome = new Double(Both6M_amtPweIncome);
  }

  public void setBoth6M_amtPweIncome(Double Both6M_amtPweIncome) {
    this.hasBoth6M_amtPweIncome = true;
    this.Both6M_amtPweIncome = Both6M_amtPweIncome;
  }

  public void setBoth6M_amtPweIncome(Number Both6M_amtPweIncome) {
    this.hasBoth6M_amtPweIncome = true;
    this.Both6M_amtPweIncome = null;
    if (Both6M_amtPweIncome != null) {
      setBoth6M_amtPweIncome(Both6M_amtPweIncome.doubleValue());
    }
  }

  public boolean hasBoth6M_cdPweIrregularUnder100() {
    return hasBoth6M_cdPweIrregularUnder100;
  }

  public String getBoth6M_cdPweIrregularUnder100() {
    if (Both6M_cdPweIrregularUnder100 == null) {
      return "";
    }
    return Both6M_cdPweIrregularUnder100;
  }

  public String getBoth6M_cdPweIrregularUnder100Object() {
    return Both6M_cdPweIrregularUnder100;
  }

  public void setBoth6M_cdPweIrregularUnder100(String Both6M_cdPweIrregularUnder100) {
    this.hasBoth6M_cdPweIrregularUnder100 = true;
    this.Both6M_cdPweIrregularUnder100 = Both6M_cdPweIrregularUnder100;
  }

  public boolean hasBoth6M_cdPweSteadyUnder100() {
    return hasBoth6M_cdPweSteadyUnder100;
  }

  public String getBoth6M_cdPweSteadyUnder100() {
    if (Both6M_cdPweSteadyUnder100 == null) {
      return "";
    }
    return Both6M_cdPweSteadyUnder100;
  }

  public String getBoth6M_cdPweSteadyUnder100Object() {
    return Both6M_cdPweSteadyUnder100;
  }

  public void setBoth6M_cdPweSteadyUnder100(String Both6M_cdPweSteadyUnder100) {
    this.hasBoth6M_cdPweSteadyUnder100 = true;
    this.Both6M_cdPweSteadyUnder100 = Both6M_cdPweSteadyUnder100;
  }

  public boolean hasBoth6M_cdVerifMethod() {
    return hasBoth6M_cdVerifMethod;
  }

  public String getBoth6M_cdVerifMethod() {
    if (Both6M_cdVerifMethod == null) {
      return "";
    }
    return Both6M_cdVerifMethod;
  }

  public String getBoth6M_cdVerifMethodObject() {
    return Both6M_cdVerifMethod;
  }

  public void setBoth6M_cdVerifMethod(String Both6M_cdVerifMethod) {
    if ((Both6M_cdVerifMethod != null) &&
        (Both6M_cdVerifMethod.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'Both6M_cdVerifMethod'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + Both6M_cdVerifMethod + "'");
    }
    this.hasBoth6M_cdVerifMethod = true;
    this.Both6M_cdVerifMethod = Both6M_cdVerifMethod;
  }

  public boolean hasBoth6M_cdVerifDocType() {
    return hasBoth6M_cdVerifDocType;
  }

  public String getBoth6M_cdVerifDocType() {
    if (Both6M_cdVerifDocType == null) {
      return "";
    }
    return Both6M_cdVerifDocType;
  }

  public String getBoth6M_cdVerifDocTypeObject() {
    return Both6M_cdVerifDocType;
  }

  public void setBoth6M_cdVerifDocType(String Both6M_cdVerifDocType) {
    if ((Both6M_cdVerifDocType != null) &&
        (Both6M_cdVerifDocType.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'Both6M_cdVerifDocType'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + Both6M_cdVerifDocType + "'");
    }
    this.hasBoth6M_cdVerifDocType = true;
    this.Both6M_cdVerifDocType = Both6M_cdVerifDocType;
  }

  public boolean hasBoth6M_idPrnEarner() {
    return hasBoth6M_idPrnEarner;
  }

  public long getBoth6M_idPrnEarner() {
    if (Both6M_idPrnEarner == null) {
      return (long) 0;
    }
    return Both6M_idPrnEarner.longValue();
  }

  public Long getBoth6M_idPrnEarnerObject() {
    return Both6M_idPrnEarner;
  }

  public String getBoth6M_idPrnEarnerString() {
    return FormattingHelper.formatLong(Both6M_idPrnEarner);
  }

  public void setBoth6M_idPrnEarner(long Both6M_idPrnEarner) {
    if (Both6M_idPrnEarner == 0) {
      this.Both6M_idPrnEarner = null;
      return;
    }
    this.hasBoth6M_idPrnEarner = true;
    this.Both6M_idPrnEarner = new Long(Both6M_idPrnEarner);
  }

  public void setBoth6M_idPrnEarner(Long Both6M_idPrnEarner) {
    this.Both6M_idPrnEarner = null;
    if (Both6M_idPrnEarner != null) {
      setBoth6M_idPrnEarner(Both6M_idPrnEarner.longValue());
    }
  }

  public void setBoth6M_idPrnEarner(Number Both6M_idPrnEarner) {
    this.Both6M_idPrnEarner = null;
    if (Both6M_idPrnEarner != null) {
      setBoth6M_idPrnEarner(Both6M_idPrnEarner.longValue());
    }
  }

  public boolean hasBoth6M_indFatherPwe() {
    return hasBoth6M_indFatherPwe;
  }

  public boolean getBoth6M_indFatherPwe() {
    if (Both6M_indFatherPwe == null) {
      return false;
    }
    return Both6M_indFatherPwe.booleanValue();
  }

  public Boolean getBoth6M_indFatherPweObject() {
    return Both6M_indFatherPwe;
  }

  public String getBoth6M_indFatherPweString() {
    if (Both6M_indFatherPwe == null) {
      return "";
    }
    return Both6M_indFatherPwe.toString();
  }

  public void setBoth6M_indFatherPwe(boolean Both6M_indFatherPwe) {
    this.hasBoth6M_indFatherPwe = true;
    this.Both6M_indFatherPwe = new Boolean(Both6M_indFatherPwe);
  }

  public void setBoth6M_indFatherPwe(Boolean Both6M_indFatherPwe) {
    this.hasBoth6M_indFatherPwe = true;
    this.Both6M_indFatherPwe = Both6M_indFatherPwe;
  }

  public void setBoth6M_indFatherPwe(String Both6M_indFatherPwe) {
    this.hasBoth6M_indFatherPwe = true;
    this.Both6M_indFatherPwe = isTrueBoolean(Both6M_indFatherPwe);
  }

  public boolean hasBoth6M_indMotherPwe() {
    return hasBoth6M_indMotherPwe;
  }

  public boolean getBoth6M_indMotherPwe() {
    if (Both6M_indMotherPwe == null) {
      return false;
    }
    return Both6M_indMotherPwe.booleanValue();
  }

  public Boolean getBoth6M_indMotherPweObject() {
    return Both6M_indMotherPwe;
  }

  public String getBoth6M_indMotherPweString() {
    if (Both6M_indMotherPwe == null) {
      return "";
    }
    return Both6M_indMotherPwe.toString();
  }

  public void setBoth6M_indMotherPwe(boolean Both6M_indMotherPwe) {
    this.hasBoth6M_indMotherPwe = true;
    this.Both6M_indMotherPwe = new Boolean(Both6M_indMotherPwe);
  }

  public void setBoth6M_indMotherPwe(Boolean Both6M_indMotherPwe) {
    this.hasBoth6M_indMotherPwe = true;
    this.Both6M_indMotherPwe = Both6M_indMotherPwe;
  }

  public void setBoth6M_indMotherPwe(String Both6M_indMotherPwe) {
    this.hasBoth6M_indMotherPwe = true;
    this.Both6M_indMotherPwe = isTrueBoolean(Both6M_indMotherPwe);
  }

  public boolean hasBoth6M_indOtherVerification() {
    return hasBoth6M_indOtherVerification;
  }

  public boolean getBoth6M_indOtherVerification() {
    if (Both6M_indOtherVerification == null) {
      return false;
    }
    return Both6M_indOtherVerification.booleanValue();
  }

  public Boolean getBoth6M_indOtherVerificationObject() {
    return Both6M_indOtherVerification;
  }

  public String getBoth6M_indOtherVerificationString() {
    if (Both6M_indOtherVerification == null) {
      return "";
    }
    return Both6M_indOtherVerification.toString();
  }

  public void setBoth6M_indOtherVerification(boolean Both6M_indOtherVerification) {
    this.hasBoth6M_indOtherVerification = true;
    this.Both6M_indOtherVerification = new Boolean(Both6M_indOtherVerification);
  }

  public void setBoth6M_indOtherVerification(Boolean Both6M_indOtherVerification) {
    this.hasBoth6M_indOtherVerification = true;
    this.Both6M_indOtherVerification = Both6M_indOtherVerification;
  }

  public void setBoth6M_indOtherVerification(String Both6M_indOtherVerification) {
    this.hasBoth6M_indOtherVerification = true;
    this.Both6M_indOtherVerification = isTrueBoolean(Both6M_indOtherVerification);
  }

  public boolean hasBoth6M_indParentDisabled() {
    return hasBoth6M_indParentDisabled;
  }

  public boolean getBoth6M_indParentDisabled() {
    if (Both6M_indParentDisabled == null) {
      return false;
    }
    return Both6M_indParentDisabled.booleanValue();
  }

  public Boolean getBoth6M_indParentDisabledObject() {
    return Both6M_indParentDisabled;
  }

  public String getBoth6M_indParentDisabledString() {
    if (Both6M_indParentDisabled == null) {
      return "";
    }
    return Both6M_indParentDisabled.toString();
  }

  public void setBoth6M_indParentDisabled(boolean Both6M_indParentDisabled) {
    this.hasBoth6M_indParentDisabled = true;
    this.Both6M_indParentDisabled = new Boolean(Both6M_indParentDisabled);
  }

  public void setBoth6M_indParentDisabled(Boolean Both6M_indParentDisabled) {
    this.hasBoth6M_indParentDisabled = true;
    this.Both6M_indParentDisabled = Both6M_indParentDisabled;
  }

  public void setBoth6M_indParentDisabled(String Both6M_indParentDisabled) {
    this.hasBoth6M_indParentDisabled = true;
    this.Both6M_indParentDisabled = isTrueBoolean(Both6M_indParentDisabled);
  }

  public boolean hasBoth6M_indPeNotAcptEmpTrn() {
    return hasBoth6M_indPeNotAcptEmpTrn;
  }

  public boolean getBoth6M_indPeNotAcptEmpTrn() {
    if (Both6M_indPeNotAcptEmpTrn == null) {
      return false;
    }
    return Both6M_indPeNotAcptEmpTrn.booleanValue();
  }

  public Boolean getBoth6M_indPeNotAcptEmpTrnObject() {
    return Both6M_indPeNotAcptEmpTrn;
  }

  public String getBoth6M_indPeNotAcptEmpTrnString() {
    if (Both6M_indPeNotAcptEmpTrn == null) {
      return "";
    }
    return Both6M_indPeNotAcptEmpTrn.toString();
  }

  public void setBoth6M_indPeNotAcptEmpTrn(boolean Both6M_indPeNotAcptEmpTrn) {
    this.hasBoth6M_indPeNotAcptEmpTrn = true;
    this.Both6M_indPeNotAcptEmpTrn = new Boolean(Both6M_indPeNotAcptEmpTrn);
  }

  public void setBoth6M_indPeNotAcptEmpTrn(Boolean Both6M_indPeNotAcptEmpTrn) {
    this.hasBoth6M_indPeNotAcptEmpTrn = true;
    this.Both6M_indPeNotAcptEmpTrn = Both6M_indPeNotAcptEmpTrn;
  }

  public void setBoth6M_indPeNotAcptEmpTrn(String Both6M_indPeNotAcptEmpTrn) {
    this.hasBoth6M_indPeNotAcptEmpTrn = true;
    this.Both6M_indPeNotAcptEmpTrn = isTrueBoolean(Both6M_indPeNotAcptEmpTrn);
  }

  public boolean hasBoth6M_indPeRecvUnemp() {
    return hasBoth6M_indPeRecvUnemp;
  }

  public boolean getBoth6M_indPeRecvUnemp() {
    if (Both6M_indPeRecvUnemp == null) {
      return false;
    }
    return Both6M_indPeRecvUnemp.booleanValue();
  }

  public Boolean getBoth6M_indPeRecvUnempObject() {
    return Both6M_indPeRecvUnemp;
  }

  public String getBoth6M_indPeRecvUnempString() {
    if (Both6M_indPeRecvUnemp == null) {
      return "";
    }
    return Both6M_indPeRecvUnemp.toString();
  }

  public void setBoth6M_indPeRecvUnemp(boolean Both6M_indPeRecvUnemp) {
    this.hasBoth6M_indPeRecvUnemp = true;
    this.Both6M_indPeRecvUnemp = new Boolean(Both6M_indPeRecvUnemp);
  }

  public void setBoth6M_indPeRecvUnemp(Boolean Both6M_indPeRecvUnemp) {
    this.hasBoth6M_indPeRecvUnemp = true;
    this.Both6M_indPeRecvUnemp = Both6M_indPeRecvUnemp;
  }

  public void setBoth6M_indPeRecvUnemp(String Both6M_indPeRecvUnemp) {
    this.hasBoth6M_indPeRecvUnemp = true;
    this.Both6M_indPeRecvUnemp = isTrueBoolean(Both6M_indPeRecvUnemp);
  }

  public boolean hasBoth6M_indPeWrkEngEduTrn() {
    return hasBoth6M_indPeWrkEngEduTrn;
  }

  public boolean getBoth6M_indPeWrkEngEduTrn() {
    if (Both6M_indPeWrkEngEduTrn == null) {
      return false;
    }
    return Both6M_indPeWrkEngEduTrn.booleanValue();
  }

  public Boolean getBoth6M_indPeWrkEngEduTrnObject() {
    return Both6M_indPeWrkEngEduTrn;
  }

  public String getBoth6M_indPeWrkEngEduTrnString() {
    if (Both6M_indPeWrkEngEduTrn == null) {
      return "";
    }
    return Both6M_indPeWrkEngEduTrn.toString();
  }

  public void setBoth6M_indPeWrkEngEduTrn(boolean Both6M_indPeWrkEngEduTrn) {
    this.hasBoth6M_indPeWrkEngEduTrn = true;
    this.Both6M_indPeWrkEngEduTrn = new Boolean(Both6M_indPeWrkEngEduTrn);
  }

  public void setBoth6M_indPeWrkEngEduTrn(Boolean Both6M_indPeWrkEngEduTrn) {
    this.hasBoth6M_indPeWrkEngEduTrn = true;
    this.Both6M_indPeWrkEngEduTrn = Both6M_indPeWrkEngEduTrn;
  }

  public void setBoth6M_indPeWrkEngEduTrn(String Both6M_indPeWrkEngEduTrn) {
    this.hasBoth6M_indPeWrkEngEduTrn = true;
    this.Both6M_indPeWrkEngEduTrn = isTrueBoolean(Both6M_indPeWrkEngEduTrn);
  }

  public boolean hasBoth6M_indRecv100PctVa() {
    return hasBoth6M_indRecv100PctVa;
  }

  public boolean getBoth6M_indRecv100PctVa() {
    if (Both6M_indRecv100PctVa == null) {
      return false;
    }
    return Both6M_indRecv100PctVa.booleanValue();
  }

  public Boolean getBoth6M_indRecv100PctVaObject() {
    return Both6M_indRecv100PctVa;
  }

  public String getBoth6M_indRecv100PctVaString() {
    if (Both6M_indRecv100PctVa == null) {
      return "";
    }
    return Both6M_indRecv100PctVa.toString();
  }

  public void setBoth6M_indRecv100PctVa(boolean Both6M_indRecv100PctVa) {
    this.hasBoth6M_indRecv100PctVa = true;
    this.Both6M_indRecv100PctVa = new Boolean(Both6M_indRecv100PctVa);
  }

  public void setBoth6M_indRecv100PctVa(Boolean Both6M_indRecv100PctVa) {
    this.hasBoth6M_indRecv100PctVa = true;
    this.Both6M_indRecv100PctVa = Both6M_indRecv100PctVa;
  }

  public void setBoth6M_indRecv100PctVa(String Both6M_indRecv100PctVa) {
    this.hasBoth6M_indRecv100PctVa = true;
    this.Both6M_indRecv100PctVa = isTrueBoolean(Both6M_indRecv100PctVa);
  }

  public boolean hasBoth6M_indRecvRrRsdi() {
    return hasBoth6M_indRecvRrRsdi;
  }

  public boolean getBoth6M_indRecvRrRsdi() {
    if (Both6M_indRecvRrRsdi == null) {
      return false;
    }
    return Both6M_indRecvRrRsdi.booleanValue();
  }

  public Boolean getBoth6M_indRecvRrRsdiObject() {
    return Both6M_indRecvRrRsdi;
  }

  public String getBoth6M_indRecvRrRsdiString() {
    if (Both6M_indRecvRrRsdi == null) {
      return "";
    }
    return Both6M_indRecvRrRsdi.toString();
  }

  public void setBoth6M_indRecvRrRsdi(boolean Both6M_indRecvRrRsdi) {
    this.hasBoth6M_indRecvRrRsdi = true;
    this.Both6M_indRecvRrRsdi = new Boolean(Both6M_indRecvRrRsdi);
  }

  public void setBoth6M_indRecvRrRsdi(Boolean Both6M_indRecvRrRsdi) {
    this.hasBoth6M_indRecvRrRsdi = true;
    this.Both6M_indRecvRrRsdi = Both6M_indRecvRrRsdi;
  }

  public void setBoth6M_indRecvRrRsdi(String Both6M_indRecvRrRsdi) {
    this.hasBoth6M_indRecvRrRsdi = true;
    this.Both6M_indRecvRrRsdi = isTrueBoolean(Both6M_indRecvRrRsdi);
  }

  public boolean hasBoth6M_indRsdiVerification() {
    return hasBoth6M_indRsdiVerification;
  }

  public boolean getBoth6M_indRsdiVerification() {
    if (Both6M_indRsdiVerification == null) {
      return false;
    }
    return Both6M_indRsdiVerification.booleanValue();
  }

  public Boolean getBoth6M_indRsdiVerificationObject() {
    return Both6M_indRsdiVerification;
  }

  public String getBoth6M_indRsdiVerificationString() {
    if (Both6M_indRsdiVerification == null) {
      return "";
    }
    return Both6M_indRsdiVerification.toString();
  }

  public void setBoth6M_indRsdiVerification(boolean Both6M_indRsdiVerification) {
    this.hasBoth6M_indRsdiVerification = true;
    this.Both6M_indRsdiVerification = new Boolean(Both6M_indRsdiVerification);
  }

  public void setBoth6M_indRsdiVerification(Boolean Both6M_indRsdiVerification) {
    this.hasBoth6M_indRsdiVerification = true;
    this.Both6M_indRsdiVerification = Both6M_indRsdiVerification;
  }

  public void setBoth6M_indRsdiVerification(String Both6M_indRsdiVerification) {
    this.hasBoth6M_indRsdiVerification = true;
    this.Both6M_indRsdiVerification = isTrueBoolean(Both6M_indRsdiVerification);
  }

  public boolean hasBoth6M_indSsiVerification() {
    return hasBoth6M_indSsiVerification;
  }

  public boolean getBoth6M_indSsiVerification() {
    if (Both6M_indSsiVerification == null) {
      return false;
    }
    return Both6M_indSsiVerification.booleanValue();
  }

  public Boolean getBoth6M_indSsiVerificationObject() {
    return Both6M_indSsiVerification;
  }

  public String getBoth6M_indSsiVerificationString() {
    if (Both6M_indSsiVerification == null) {
      return "";
    }
    return Both6M_indSsiVerification.toString();
  }

  public void setBoth6M_indSsiVerification(boolean Both6M_indSsiVerification) {
    this.hasBoth6M_indSsiVerification = true;
    this.Both6M_indSsiVerification = new Boolean(Both6M_indSsiVerification);
  }

  public void setBoth6M_indSsiVerification(Boolean Both6M_indSsiVerification) {
    this.hasBoth6M_indSsiVerification = true;
    this.Both6M_indSsiVerification = Both6M_indSsiVerification;
  }

  public void setBoth6M_indSsiVerification(String Both6M_indSsiVerification) {
    this.hasBoth6M_indSsiVerification = true;
    this.Both6M_indSsiVerification = isTrueBoolean(Both6M_indSsiVerification);
  }

  public boolean hasBoth_amtPweIncome() {
    return hasBoth_amtPweIncome;
  }

  public double getBoth_amtPweIncome() {
    if (Both_amtPweIncome == null) {
      return (double) 0;
    }
    return Both_amtPweIncome.doubleValue();
  }

  public Double getBoth_amtPweIncomeObject() {
    return Both_amtPweIncome;
  }

  public String getBoth_amtPweIncomeString() {
    return FormattingHelper.formatDouble(Both_amtPweIncome);
  }

  public void setBoth_amtPweIncome(double Both_amtPweIncome) {
    this.hasBoth_amtPweIncome = true;
    this.Both_amtPweIncome = new Double(Both_amtPweIncome);
  }

  public void setBoth_amtPweIncome(Double Both_amtPweIncome) {
    this.hasBoth_amtPweIncome = true;
    this.Both_amtPweIncome = Both_amtPweIncome;
  }

  public void setBoth_amtPweIncome(Number Both_amtPweIncome) {
    this.hasBoth_amtPweIncome = true;
    this.Both_amtPweIncome = null;
    if (Both_amtPweIncome != null) {
      setBoth_amtPweIncome(Both_amtPweIncome.doubleValue());
    }
  }

  public boolean hasBoth_cdPweIrregularUnder100() {
    return hasBoth_cdPweIrregularUnder100;
  }

  public String getBoth_cdPweIrregularUnder100() {
    if (Both_cdPweIrregularUnder100 == null) {
      return "";
    }
    return Both_cdPweIrregularUnder100;
  }

  public String getBoth_cdPweIrregularUnder100Object() {
    return Both_cdPweIrregularUnder100;
  }

  public void setBoth_cdPweIrregularUnder100(String Both_cdPweIrregularUnder100) {
    this.hasBoth_cdPweIrregularUnder100 = true;
    this.Both_cdPweIrregularUnder100 = Both_cdPweIrregularUnder100;
  }

  public boolean hasBoth_cdPweSteadyUnder100() {
    return hasBoth_cdPweSteadyUnder100;
  }

  public String getBoth_cdPweSteadyUnder100() {
    if (Both_cdPweSteadyUnder100 == null) {
      return "";
    }
    return Both_cdPweSteadyUnder100;
  }

  public String getBoth_cdPweSteadyUnder100Object() {
    return Both_cdPweSteadyUnder100;
  }

  public void setBoth_cdPweSteadyUnder100(String Both_cdPweSteadyUnder100) {
    this.hasBoth_cdPweSteadyUnder100 = true;
    this.Both_cdPweSteadyUnder100 = Both_cdPweSteadyUnder100;
  }

  public boolean hasBoth_cdVerifMethod() {
    return hasBoth_cdVerifMethod;
  }

  public String getBoth_cdVerifMethod() {
    if (Both_cdVerifMethod == null) {
      return "";
    }
    return Both_cdVerifMethod;
  }

  public String getBoth_cdVerifMethodObject() {
    return Both_cdVerifMethod;
  }

  public void setBoth_cdVerifMethod(String Both_cdVerifMethod) {
    if ((Both_cdVerifMethod != null) &&
        (Both_cdVerifMethod.length() > 1)) {
      throw new IllegalStateException("Data is too large for 'Both_cdVerifMethod'; \n" +
                                      " max size = 1; \n" +
                                      " data = '" + Both_cdVerifMethod + "'");
    }
    this.hasBoth_cdVerifMethod = true;
    this.Both_cdVerifMethod = Both_cdVerifMethod;
  }

  public boolean hasBoth_cdVerifDocType() {
    return hasBoth_cdVerifDocType;
  }

  public String getBoth_cdVerifDocType() {
    if (Both_cdVerifDocType == null) {
      return "";
    }
    return Both_cdVerifDocType;
  }

  public String getBoth_cdVerifDocTypeObject() {
    return Both_cdVerifDocType;
  }

  public void setBoth_cdVerifDocType(String Both_cdVerifDocType) {
    if ((Both_cdVerifDocType != null) &&
        (Both_cdVerifDocType.length() > 2)) {
      throw new IllegalStateException("Data is too large for 'Both_cdVerifDocType'; \n" +
                                      " max size = 2; \n" +
                                      " data = '" + Both_cdVerifDocType + "'");
    }
    this.hasBoth_cdVerifDocType = true;
    this.Both_cdVerifDocType = Both_cdVerifDocType;
  }

  public boolean hasBoth_idPrnEarner() {
    return hasBoth_idPrnEarner;
  }

  public long getBoth_idPrnEarner() {
    if (Both_idPrnEarner == null) {
      return (long) 0;
    }
    return Both_idPrnEarner.longValue();
  }

  public Long getBoth_idPrnEarnerObject() {
    return Both_idPrnEarner;
  }

  public String getBoth_idPrnEarnerString() {
    return FormattingHelper.formatLong(Both_idPrnEarner);
  }

  public void setBoth_idPrnEarner(long Both_idPrnEarner) {
    if (Both_idPrnEarner == 0) {
      this.Both_idPrnEarner = null;
      return;
    }
    this.hasBoth_idPrnEarner = true;
    this.Both_idPrnEarner = new Long(Both_idPrnEarner);
  }

  public void setBoth_idPrnEarner(Long Both_idPrnEarner) {
    this.Both_idPrnEarner = null;
    if (Both_idPrnEarner != null) {
      setBoth_idPrnEarner(Both_idPrnEarner.longValue());
    }
  }

  public void setBoth_idPrnEarner(Number Both_idPrnEarner) {
    this.Both_idPrnEarner = null;
    if (Both_idPrnEarner != null) {
      setBoth_idPrnEarner(Both_idPrnEarner.longValue());
    }
  }

  public boolean hasBoth_indFatherPwe() {
    return hasBoth_indFatherPwe;
  }

  public boolean getBoth_indFatherPwe() {
    if (Both_indFatherPwe == null) {
      return false;
    }
    return Both_indFatherPwe.booleanValue();
  }

  public Boolean getBoth_indFatherPweObject() {
    return Both_indFatherPwe;
  }

  public String getBoth_indFatherPweString() {
    if (Both_indFatherPwe == null) {
      return "";
    }
    return Both_indFatherPwe.toString();
  }

  public void setBoth_indFatherPwe(boolean Both_indFatherPwe) {
    this.hasBoth_indFatherPwe = true;
    this.Both_indFatherPwe = new Boolean(Both_indFatherPwe);
  }

  public void setBoth_indFatherPwe(Boolean Both_indFatherPwe) {
    this.hasBoth_indFatherPwe = true;
    this.Both_indFatherPwe = Both_indFatherPwe;
  }

  public void setBoth_indFatherPwe(String Both_indFatherPwe) {
    this.hasBoth_indFatherPwe = true;
    this.Both_indFatherPwe = isTrueBoolean(Both_indFatherPwe);
  }

  public boolean hasBoth_indMotherPwe() {
    return hasBoth_indMotherPwe;
  }

  public boolean getBoth_indMotherPwe() {
    if (Both_indMotherPwe == null) {
      return false;
    }
    return Both_indMotherPwe.booleanValue();
  }

  public Boolean getBoth_indMotherPweObject() {
    return Both_indMotherPwe;
  }

  public String getBoth_indMotherPweString() {
    if (Both_indMotherPwe == null) {
      return "";
    }
    return Both_indMotherPwe.toString();
  }

  public void setBoth_indMotherPwe(boolean Both_indMotherPwe) {
    this.hasBoth_indMotherPwe = true;
    this.Both_indMotherPwe = new Boolean(Both_indMotherPwe);
  }

  public void setBoth_indMotherPwe(Boolean Both_indMotherPwe) {
    this.hasBoth_indMotherPwe = true;
    this.Both_indMotherPwe = Both_indMotherPwe;
  }

  public void setBoth_indMotherPwe(String Both_indMotherPwe) {
    this.hasBoth_indMotherPwe = true;
    this.Both_indMotherPwe = isTrueBoolean(Both_indMotherPwe);
  }

  public boolean hasBoth_indOtherVerification() {
    return hasBoth_indOtherVerification;
  }

  public boolean getBoth_indOtherVerification() {
    if (Both_indOtherVerification == null) {
      return false;
    }
    return Both_indOtherVerification.booleanValue();
  }

  public Boolean getBoth_indOtherVerificationObject() {
    return Both_indOtherVerification;
  }

  public String getBoth_indOtherVerificationString() {
    if (Both_indOtherVerification == null) {
      return "";
    }
    return Both_indOtherVerification.toString();
  }

  public void setBoth_indOtherVerification(boolean Both_indOtherVerification) {
    this.hasBoth_indOtherVerification = true;
    this.Both_indOtherVerification = new Boolean(Both_indOtherVerification);
  }

  public void setBoth_indOtherVerification(Boolean Both_indOtherVerification) {
    this.hasBoth_indOtherVerification = true;
    this.Both_indOtherVerification = Both_indOtherVerification;
  }

  public void setBoth_indOtherVerification(String Both_indOtherVerification) {
    this.hasBoth_indOtherVerification = true;
    this.Both_indOtherVerification = isTrueBoolean(Both_indOtherVerification);
  }

  public boolean hasBoth_indParentDisabled() {
    return hasBoth_indParentDisabled;
  }

  public boolean getBoth_indParentDisabled() {
    if (Both_indParentDisabled == null) {
      return false;
    }
    return Both_indParentDisabled.booleanValue();
  }

  public Boolean getBoth_indParentDisabledObject() {
    return Both_indParentDisabled;
  }

  public String getBoth_indParentDisabledString() {
    if (Both_indParentDisabled == null) {
      return "";
    }
    return Both_indParentDisabled.toString();
  }

  public void setBoth_indParentDisabled(boolean Both_indParentDisabled) {
    this.hasBoth_indParentDisabled = true;
    this.Both_indParentDisabled = new Boolean(Both_indParentDisabled);
  }

  public void setBoth_indParentDisabled(Boolean Both_indParentDisabled) {
    this.hasBoth_indParentDisabled = true;
    this.Both_indParentDisabled = Both_indParentDisabled;
  }

  public void setBoth_indParentDisabled(String Both_indParentDisabled) {
    this.hasBoth_indParentDisabled = true;
    this.Both_indParentDisabled = isTrueBoolean(Both_indParentDisabled);
  }

  public boolean hasBoth_indPeNotAcptEmpTrn() {
    return hasBoth_indPeNotAcptEmpTrn;
  }

  public boolean getBoth_indPeNotAcptEmpTrn() {
    if (Both_indPeNotAcptEmpTrn == null) {
      return false;
    }
    return Both_indPeNotAcptEmpTrn.booleanValue();
  }

  public Boolean getBoth_indPeNotAcptEmpTrnObject() {
    return Both_indPeNotAcptEmpTrn;
  }

  public String getBoth_indPeNotAcptEmpTrnString() {
    if (Both_indPeNotAcptEmpTrn == null) {
      return "";
    }
    return Both_indPeNotAcptEmpTrn.toString();
  }

  public void setBoth_indPeNotAcptEmpTrn(boolean Both_indPeNotAcptEmpTrn) {
    this.hasBoth_indPeNotAcptEmpTrn = true;
    this.Both_indPeNotAcptEmpTrn = new Boolean(Both_indPeNotAcptEmpTrn);
  }

  public void setBoth_indPeNotAcptEmpTrn(Boolean Both_indPeNotAcptEmpTrn) {
    this.hasBoth_indPeNotAcptEmpTrn = true;
    this.Both_indPeNotAcptEmpTrn = Both_indPeNotAcptEmpTrn;
  }

  public void setBoth_indPeNotAcptEmpTrn(String Both_indPeNotAcptEmpTrn) {
    this.hasBoth_indPeNotAcptEmpTrn = true;
    this.Both_indPeNotAcptEmpTrn = isTrueBoolean(Both_indPeNotAcptEmpTrn);
  }

  public boolean hasBoth_indPeRecvUnemp() {
    return hasBoth_indPeRecvUnemp;
  }

  public boolean getBoth_indPeRecvUnemp() {
    if (Both_indPeRecvUnemp == null) {
      return false;
    }
    return Both_indPeRecvUnemp.booleanValue();
  }

  public Boolean getBoth_indPeRecvUnempObject() {
    return Both_indPeRecvUnemp;
  }

  public String getBoth_indPeRecvUnempString() {
    if (Both_indPeRecvUnemp == null) {
      return "";
    }
    return Both_indPeRecvUnemp.toString();
  }

  public void setBoth_indPeRecvUnemp(boolean Both_indPeRecvUnemp) {
    this.hasBoth_indPeRecvUnemp = true;
    this.Both_indPeRecvUnemp = new Boolean(Both_indPeRecvUnemp);
  }

  public void setBoth_indPeRecvUnemp(Boolean Both_indPeRecvUnemp) {
    this.hasBoth_indPeRecvUnemp = true;
    this.Both_indPeRecvUnemp = Both_indPeRecvUnemp;
  }

  public void setBoth_indPeRecvUnemp(String Both_indPeRecvUnemp) {
    this.hasBoth_indPeRecvUnemp = true;
    this.Both_indPeRecvUnemp = isTrueBoolean(Both_indPeRecvUnemp);
  }

  public boolean hasBoth_indPeWrkEngEduTrn() {
    return hasBoth_indPeWrkEngEduTrn;
  }

  public boolean getBoth_indPeWrkEngEduTrn() {
    if (Both_indPeWrkEngEduTrn == null) {
      return false;
    }
    return Both_indPeWrkEngEduTrn.booleanValue();
  }

  public Boolean getBoth_indPeWrkEngEduTrnObject() {
    return Both_indPeWrkEngEduTrn;
  }

  public String getBoth_indPeWrkEngEduTrnString() {
    if (Both_indPeWrkEngEduTrn == null) {
      return "";
    }
    return Both_indPeWrkEngEduTrn.toString();
  }

  public void setBoth_indPeWrkEngEduTrn(boolean Both_indPeWrkEngEduTrn) {
    this.hasBoth_indPeWrkEngEduTrn = true;
    this.Both_indPeWrkEngEduTrn = new Boolean(Both_indPeWrkEngEduTrn);
  }

  public void setBoth_indPeWrkEngEduTrn(Boolean Both_indPeWrkEngEduTrn) {
    this.hasBoth_indPeWrkEngEduTrn = true;
    this.Both_indPeWrkEngEduTrn = Both_indPeWrkEngEduTrn;
  }

  public void setBoth_indPeWrkEngEduTrn(String Both_indPeWrkEngEduTrn) {
    this.hasBoth_indPeWrkEngEduTrn = true;
    this.Both_indPeWrkEngEduTrn = isTrueBoolean(Both_indPeWrkEngEduTrn);
  }

  public boolean hasBoth_indRecv100PctVa() {
    return hasBoth_indRecv100PctVa;
  }

  public boolean getBoth_indRecv100PctVa() {
    if (Both_indRecv100PctVa == null) {
      return false;
    }
    return Both_indRecv100PctVa.booleanValue();
  }

  public Boolean getBoth_indRecv100PctVaObject() {
    return Both_indRecv100PctVa;
  }

  public String getBoth_indRecv100PctVaString() {
    if (Both_indRecv100PctVa == null) {
      return "";
    }
    return Both_indRecv100PctVa.toString();
  }

  public void setBoth_indRecv100PctVa(boolean Both_indRecv100PctVa) {
    this.hasBoth_indRecv100PctVa = true;
    this.Both_indRecv100PctVa = new Boolean(Both_indRecv100PctVa);
  }

  public void setBoth_indRecv100PctVa(Boolean Both_indRecv100PctVa) {
    this.hasBoth_indRecv100PctVa = true;
    this.Both_indRecv100PctVa = Both_indRecv100PctVa;
  }

  public void setBoth_indRecv100PctVa(String Both_indRecv100PctVa) {
    this.hasBoth_indRecv100PctVa = true;
    this.Both_indRecv100PctVa = isTrueBoolean(Both_indRecv100PctVa);
  }

  public boolean hasBoth_indRecvRrRsdi() {
    return hasBoth_indRecvRrRsdi;
  }

  public boolean getBoth_indRecvRrRsdi() {
    if (Both_indRecvRrRsdi == null) {
      return false;
    }
    return Both_indRecvRrRsdi.booleanValue();
  }

  public Boolean getBoth_indRecvRrRsdiObject() {
    return Both_indRecvRrRsdi;
  }

  public String getBoth_indRecvRrRsdiString() {
    if (Both_indRecvRrRsdi == null) {
      return "";
    }
    return Both_indRecvRrRsdi.toString();
  }

  public void setBoth_indRecvRrRsdi(boolean Both_indRecvRrRsdi) {
    this.hasBoth_indRecvRrRsdi = true;
    this.Both_indRecvRrRsdi = new Boolean(Both_indRecvRrRsdi);
  }

  public void setBoth_indRecvRrRsdi(Boolean Both_indRecvRrRsdi) {
    this.hasBoth_indRecvRrRsdi = true;
    this.Both_indRecvRrRsdi = Both_indRecvRrRsdi;
  }

  public void setBoth_indRecvRrRsdi(String Both_indRecvRrRsdi) {
    this.hasBoth_indRecvRrRsdi = true;
    this.Both_indRecvRrRsdi = isTrueBoolean(Both_indRecvRrRsdi);
  }

  public boolean hasBoth_indRsdiVerification() {
    return hasBoth_indRsdiVerification;
  }

  public boolean getBoth_indRsdiVerification() {
    if (Both_indRsdiVerification == null) {
      return false;
    }
    return Both_indRsdiVerification.booleanValue();
  }

  public Boolean getBoth_indRsdiVerificationObject() {
    return Both_indRsdiVerification;
  }

  public String getBoth_indRsdiVerificationString() {
    if (Both_indRsdiVerification == null) {
      return "";
    }
    return Both_indRsdiVerification.toString();
  }

  public void setBoth_indRsdiVerification(boolean Both_indRsdiVerification) {
    this.hasBoth_indRsdiVerification = true;
    this.Both_indRsdiVerification = new Boolean(Both_indRsdiVerification);
  }

  public void setBoth_indRsdiVerification(Boolean Both_indRsdiVerification) {
    this.hasBoth_indRsdiVerification = true;
    this.Both_indRsdiVerification = Both_indRsdiVerification;
  }

  public void setBoth_indRsdiVerification(String Both_indRsdiVerification) {
    this.hasBoth_indRsdiVerification = true;
    this.Both_indRsdiVerification = isTrueBoolean(Both_indRsdiVerification);
  }

  public boolean hasBoth_indSsiVerification() {
    return hasBoth_indSsiVerification;
  }

  public boolean getBoth_indSsiVerification() {
    if (Both_indSsiVerification == null) {
      return false;
    }
    return Both_indSsiVerification.booleanValue();
  }

  public Boolean getBoth_indSsiVerificationObject() {
    return Both_indSsiVerification;
  }

  public String getBoth_indSsiVerificationString() {
    if (Both_indSsiVerification == null) {
      return "";
    }
    return Both_indSsiVerification.toString();
  }

  public void setBoth_indSsiVerification(boolean Both_indSsiVerification) {
    this.hasBoth_indSsiVerification = true;
    this.Both_indSsiVerification = new Boolean(Both_indSsiVerification);
  }

  public void setBoth_indSsiVerification(Boolean Both_indSsiVerification) {
    this.hasBoth_indSsiVerification = true;
    this.Both_indSsiVerification = Both_indSsiVerification;
  }

  public void setBoth_indSsiVerification(String Both_indSsiVerification) {
    this.hasBoth_indSsiVerification = true;
    this.Both_indSsiVerification = isTrueBoolean(Both_indSsiVerification);
  }

  public boolean hasNota_cdNotaMostRecent() {
    return hasNota_cdNotaMostRecent;
  }

  public String getNota_cdNotaMostRecent() {
    if (Nota_cdNotaMostRecent == null) {
      return "";
    }
    return Nota_cdNotaMostRecent;
  }

  public String getNota_cdNotaMostRecentObject() {
    return Nota_cdNotaMostRecent;
  }

  public void setNota_cdNotaMostRecent(String Nota_cdNotaMostRecent) {
    this.hasNota_cdNotaMostRecent = true;
    this.Nota_cdNotaMostRecent = Nota_cdNotaMostRecent;
  }

  public boolean hasNota_indChildLivingPrnt6Mnths() {
    return hasNota_indChildLivingPrnt6Mnths;
  }

  public boolean getNota_indChildLivingPrnt6Mnths() {
    if (Nota_indChildLivingPrnt6Mnths == null) {
      return false;
    }
    return Nota_indChildLivingPrnt6Mnths.booleanValue();
  }

  public Boolean getNota_indChildLivingPrnt6MnthsObject() {
    return Nota_indChildLivingPrnt6Mnths;
  }

  public String getNota_indChildLivingPrnt6MnthsString() {
    if (Nota_indChildLivingPrnt6Mnths == null) {
      return "";
    }
    return Nota_indChildLivingPrnt6Mnths.toString();
  }

  public void setNota_indChildLivingPrnt6Mnths(boolean Nota_indChildLivingPrnt6Mnths) {
    this.hasNota_indChildLivingPrnt6Mnths = true;
    this.Nota_indChildLivingPrnt6Mnths = new Boolean(Nota_indChildLivingPrnt6Mnths);
  }

  public void setNota_indChildLivingPrnt6Mnths(Boolean Nota_indChildLivingPrnt6Mnths) {
    this.hasNota_indChildLivingPrnt6Mnths = true;
    this.Nota_indChildLivingPrnt6Mnths = Nota_indChildLivingPrnt6Mnths;
  }

  public void setNota_indChildLivingPrnt6Mnths(String Nota_indChildLivingPrnt6Mnths) {
    this.hasNota_indChildLivingPrnt6Mnths = true;
    this.Nota_indChildLivingPrnt6Mnths = isTrueBoolean(Nota_indChildLivingPrnt6Mnths);
  }

  public boolean hasOne6M_indAbsentAltrntCustody() {
    return hasOne6M_indAbsentAltrntCustody;
  }

  public boolean getOne6M_indAbsentAltrntCustody() {
    if (One6M_indAbsentAltrntCustody == null) {
      return false;
    }
    return One6M_indAbsentAltrntCustody.booleanValue();
  }

  public Boolean getOne6M_indAbsentAltrntCustodyObject() {
    return One6M_indAbsentAltrntCustody;
  }

  public String getOne6M_indAbsentAltrntCustodyString() {
    if (One6M_indAbsentAltrntCustody == null) {
      return "";
    }
    return One6M_indAbsentAltrntCustody.toString();
  }

  public void setOne6M_indAbsentAltrntCustody(boolean One6M_indAbsentAltrntCustody) {
    this.hasOne6M_indAbsentAltrntCustody = true;
    this.One6M_indAbsentAltrntCustody = new Boolean(One6M_indAbsentAltrntCustody);
  }

  public void setOne6M_indAbsentAltrntCustody(Boolean One6M_indAbsentAltrntCustody) {
    this.hasOne6M_indAbsentAltrntCustody = true;
    this.One6M_indAbsentAltrntCustody = One6M_indAbsentAltrntCustody;
  }

  public void setOne6M_indAbsentAltrntCustody(String One6M_indAbsentAltrntCustody) {
    this.hasOne6M_indAbsentAltrntCustody = true;
    this.One6M_indAbsentAltrntCustody = isTrueBoolean(One6M_indAbsentAltrntCustody);
  }

  public boolean hasOne6M_indAbsentDeported() {
    return hasOne6M_indAbsentDeported;
  }

  public boolean getOne6M_indAbsentDeported() {
    if (One6M_indAbsentDeported == null) {
      return false;
    }
    return One6M_indAbsentDeported.booleanValue();
  }

  public Boolean getOne6M_indAbsentDeportedObject() {
    return One6M_indAbsentDeported;
  }

  public String getOne6M_indAbsentDeportedString() {
    if (One6M_indAbsentDeported == null) {
      return "";
    }
    return One6M_indAbsentDeported.toString();
  }

  public void setOne6M_indAbsentDeported(boolean One6M_indAbsentDeported) {
    this.hasOne6M_indAbsentDeported = true;
    this.One6M_indAbsentDeported = new Boolean(One6M_indAbsentDeported);
  }

  public void setOne6M_indAbsentDeported(Boolean One6M_indAbsentDeported) {
    this.hasOne6M_indAbsentDeported = true;
    this.One6M_indAbsentDeported = One6M_indAbsentDeported;
  }

  public void setOne6M_indAbsentDeported(String One6M_indAbsentDeported) {
    this.hasOne6M_indAbsentDeported = true;
    this.One6M_indAbsentDeported = isTrueBoolean(One6M_indAbsentDeported);
  }

  public boolean hasOne6M_indAbsentDeserted() {
    return hasOne6M_indAbsentDeserted;
  }

  public boolean getOne6M_indAbsentDeserted() {
    if (One6M_indAbsentDeserted == null) {
      return false;
    }
    return One6M_indAbsentDeserted.booleanValue();
  }

  public Boolean getOne6M_indAbsentDesertedObject() {
    return One6M_indAbsentDeserted;
  }

  public String getOne6M_indAbsentDesertedString() {
    if (One6M_indAbsentDeserted == null) {
      return "";
    }
    return One6M_indAbsentDeserted.toString();
  }

  public void setOne6M_indAbsentDeserted(boolean One6M_indAbsentDeserted) {
    this.hasOne6M_indAbsentDeserted = true;
    this.One6M_indAbsentDeserted = new Boolean(One6M_indAbsentDeserted);
  }

  public void setOne6M_indAbsentDeserted(Boolean One6M_indAbsentDeserted) {
    this.hasOne6M_indAbsentDeserted = true;
    this.One6M_indAbsentDeserted = One6M_indAbsentDeserted;
  }

  public void setOne6M_indAbsentDeserted(String One6M_indAbsentDeserted) {
    this.hasOne6M_indAbsentDeserted = true;
    this.One6M_indAbsentDeserted = isTrueBoolean(One6M_indAbsentDeserted);
  }

  public boolean hasOne6M_indAbsentDied() {
    return hasOne6M_indAbsentDied;
  }

  public boolean getOne6M_indAbsentDied() {
    if (One6M_indAbsentDied == null) {
      return false;
    }
    return One6M_indAbsentDied.booleanValue();
  }

  public Boolean getOne6M_indAbsentDiedObject() {
    return One6M_indAbsentDied;
  }

  public String getOne6M_indAbsentDiedString() {
    if (One6M_indAbsentDied == null) {
      return "";
    }
    return One6M_indAbsentDied.toString();
  }

  public void setOne6M_indAbsentDied(boolean One6M_indAbsentDied) {
    this.hasOne6M_indAbsentDied = true;
    this.One6M_indAbsentDied = new Boolean(One6M_indAbsentDied);
  }

  public void setOne6M_indAbsentDied(Boolean One6M_indAbsentDied) {
    this.hasOne6M_indAbsentDied = true;
    this.One6M_indAbsentDied = One6M_indAbsentDied;
  }

  public void setOne6M_indAbsentDied(String One6M_indAbsentDied) {
    this.hasOne6M_indAbsentDied = true;
    this.One6M_indAbsentDied = isTrueBoolean(One6M_indAbsentDied);
  }

  public boolean hasOne6M_indAbsentDivorced() {
    return hasOne6M_indAbsentDivorced;
  }

  public boolean getOne6M_indAbsentDivorced() {
    if (One6M_indAbsentDivorced == null) {
      return false;
    }
    return One6M_indAbsentDivorced.booleanValue();
  }

  public Boolean getOne6M_indAbsentDivorcedObject() {
    return One6M_indAbsentDivorced;
  }

  public String getOne6M_indAbsentDivorcedString() {
    if (One6M_indAbsentDivorced == null) {
      return "";
    }
    return One6M_indAbsentDivorced.toString();
  }

  public void setOne6M_indAbsentDivorced(boolean One6M_indAbsentDivorced) {
    this.hasOne6M_indAbsentDivorced = true;
    this.One6M_indAbsentDivorced = new Boolean(One6M_indAbsentDivorced);
  }

  public void setOne6M_indAbsentDivorced(Boolean One6M_indAbsentDivorced) {
    this.hasOne6M_indAbsentDivorced = true;
    this.One6M_indAbsentDivorced = One6M_indAbsentDivorced;
  }

  public void setOne6M_indAbsentDivorced(String One6M_indAbsentDivorced) {
    this.hasOne6M_indAbsentDivorced = true;
    this.One6M_indAbsentDivorced = isTrueBoolean(One6M_indAbsentDivorced);
  }

  public boolean hasOne6M_indAbsentFather() {
    return hasOne6M_indAbsentFather;
  }

  public boolean getOne6M_indAbsentFather() {
    if (One6M_indAbsentFather == null) {
      return false;
    }
    return One6M_indAbsentFather.booleanValue();
  }

  public Boolean getOne6M_indAbsentFatherObject() {
    return One6M_indAbsentFather;
  }

  public String getOne6M_indAbsentFatherString() {
    if (One6M_indAbsentFather == null) {
      return "";
    }
    return One6M_indAbsentFather.toString();
  }

  public void setOne6M_indAbsentFather(boolean One6M_indAbsentFather) {
    this.hasOne6M_indAbsentFather = true;
    this.One6M_indAbsentFather = new Boolean(One6M_indAbsentFather);
  }

  public void setOne6M_indAbsentFather(Boolean One6M_indAbsentFather) {
    this.hasOne6M_indAbsentFather = true;
    this.One6M_indAbsentFather = One6M_indAbsentFather;
  }

  public void setOne6M_indAbsentFather(String One6M_indAbsentFather) {
    this.hasOne6M_indAbsentFather = true;
    this.One6M_indAbsentFather = isTrueBoolean(One6M_indAbsentFather);
  }

  public boolean hasOne6M_indAbsentHospitalized() {
    return hasOne6M_indAbsentHospitalized;
  }

  public boolean getOne6M_indAbsentHospitalized() {
    if (One6M_indAbsentHospitalized == null) {
      return false;
    }
    return One6M_indAbsentHospitalized.booleanValue();
  }

  public Boolean getOne6M_indAbsentHospitalizedObject() {
    return One6M_indAbsentHospitalized;
  }

  public String getOne6M_indAbsentHospitalizedString() {
    if (One6M_indAbsentHospitalized == null) {
      return "";
    }
    return One6M_indAbsentHospitalized.toString();
  }

  public void setOne6M_indAbsentHospitalized(boolean One6M_indAbsentHospitalized) {
    this.hasOne6M_indAbsentHospitalized = true;
    this.One6M_indAbsentHospitalized = new Boolean(One6M_indAbsentHospitalized);
  }

  public void setOne6M_indAbsentHospitalized(Boolean One6M_indAbsentHospitalized) {
    this.hasOne6M_indAbsentHospitalized = true;
    this.One6M_indAbsentHospitalized = One6M_indAbsentHospitalized;
  }

  public void setOne6M_indAbsentHospitalized(String One6M_indAbsentHospitalized) {
    this.hasOne6M_indAbsentHospitalized = true;
    this.One6M_indAbsentHospitalized = isTrueBoolean(One6M_indAbsentHospitalized);
  }

  public boolean hasOne6M_indAbsentIncarcerated() {
    return hasOne6M_indAbsentIncarcerated;
  }

  public boolean getOne6M_indAbsentIncarcerated() {
    if (One6M_indAbsentIncarcerated == null) {
      return false;
    }
    return One6M_indAbsentIncarcerated.booleanValue();
  }

  public Boolean getOne6M_indAbsentIncarceratedObject() {
    return One6M_indAbsentIncarcerated;
  }

  public String getOne6M_indAbsentIncarceratedString() {
    if (One6M_indAbsentIncarcerated == null) {
      return "";
    }
    return One6M_indAbsentIncarcerated.toString();
  }

  public void setOne6M_indAbsentIncarcerated(boolean One6M_indAbsentIncarcerated) {
    this.hasOne6M_indAbsentIncarcerated = true;
    this.One6M_indAbsentIncarcerated = new Boolean(One6M_indAbsentIncarcerated);
  }

  public void setOne6M_indAbsentIncarcerated(Boolean One6M_indAbsentIncarcerated) {
    this.hasOne6M_indAbsentIncarcerated = true;
    this.One6M_indAbsentIncarcerated = One6M_indAbsentIncarcerated;
  }

  public void setOne6M_indAbsentIncarcerated(String One6M_indAbsentIncarcerated) {
    this.hasOne6M_indAbsentIncarcerated = true;
    this.One6M_indAbsentIncarcerated = isTrueBoolean(One6M_indAbsentIncarcerated);
  }

  public boolean hasOne6M_indAbsentMilitaryWork() {
    return hasOne6M_indAbsentMilitaryWork;
  }

  public boolean getOne6M_indAbsentMilitaryWork() {
    if (One6M_indAbsentMilitaryWork == null) {
      return false;
    }
    return One6M_indAbsentMilitaryWork.booleanValue();
  }

  public Boolean getOne6M_indAbsentMilitaryWorkObject() {
    return One6M_indAbsentMilitaryWork;
  }

  public String getOne6M_indAbsentMilitaryWorkString() {
    if (One6M_indAbsentMilitaryWork == null) {
      return "";
    }
    return One6M_indAbsentMilitaryWork.toString();
  }

  public void setOne6M_indAbsentMilitaryWork(boolean One6M_indAbsentMilitaryWork) {
    this.hasOne6M_indAbsentMilitaryWork = true;
    this.One6M_indAbsentMilitaryWork = new Boolean(One6M_indAbsentMilitaryWork);
  }

  public void setOne6M_indAbsentMilitaryWork(Boolean One6M_indAbsentMilitaryWork) {
    this.hasOne6M_indAbsentMilitaryWork = true;
    this.One6M_indAbsentMilitaryWork = One6M_indAbsentMilitaryWork;
  }

  public void setOne6M_indAbsentMilitaryWork(String One6M_indAbsentMilitaryWork) {
    this.hasOne6M_indAbsentMilitaryWork = true;
    this.One6M_indAbsentMilitaryWork = isTrueBoolean(One6M_indAbsentMilitaryWork);
  }

  public boolean hasOne6M_indAbsentMother() {
    return hasOne6M_indAbsentMother;
  }

  public boolean getOne6M_indAbsentMother() {
    if (One6M_indAbsentMother == null) {
      return false;
    }
    return One6M_indAbsentMother.booleanValue();
  }

  public Boolean getOne6M_indAbsentMotherObject() {
    return One6M_indAbsentMother;
  }

  public String getOne6M_indAbsentMotherString() {
    if (One6M_indAbsentMother == null) {
      return "";
    }
    return One6M_indAbsentMother.toString();
  }

  public void setOne6M_indAbsentMother(boolean One6M_indAbsentMother) {
    this.hasOne6M_indAbsentMother = true;
    this.One6M_indAbsentMother = new Boolean(One6M_indAbsentMother);
  }

  public void setOne6M_indAbsentMother(Boolean One6M_indAbsentMother) {
    this.hasOne6M_indAbsentMother = true;
    this.One6M_indAbsentMother = One6M_indAbsentMother;
  }

  public void setOne6M_indAbsentMother(String One6M_indAbsentMother) {
    this.hasOne6M_indAbsentMother = true;
    this.One6M_indAbsentMother = isTrueBoolean(One6M_indAbsentMother);
  }

  public boolean hasOne6M_indAbsentSeparated() {
    return hasOne6M_indAbsentSeparated;
  }

  public boolean getOne6M_indAbsentSeparated() {
    if (One6M_indAbsentSeparated == null) {
      return false;
    }
    return One6M_indAbsentSeparated.booleanValue();
  }

  public Boolean getOne6M_indAbsentSeparatedObject() {
    return One6M_indAbsentSeparated;
  }

  public String getOne6M_indAbsentSeparatedString() {
    if (One6M_indAbsentSeparated == null) {
      return "";
    }
    return One6M_indAbsentSeparated.toString();
  }

  public void setOne6M_indAbsentSeparated(boolean One6M_indAbsentSeparated) {
    this.hasOne6M_indAbsentSeparated = true;
    this.One6M_indAbsentSeparated = new Boolean(One6M_indAbsentSeparated);
  }

  public void setOne6M_indAbsentSeparated(Boolean One6M_indAbsentSeparated) {
    this.hasOne6M_indAbsentSeparated = true;
    this.One6M_indAbsentSeparated = One6M_indAbsentSeparated;
  }

  public void setOne6M_indAbsentSeparated(String One6M_indAbsentSeparated) {
    this.hasOne6M_indAbsentSeparated = true;
    this.One6M_indAbsentSeparated = isTrueBoolean(One6M_indAbsentSeparated);
  }

  public boolean hasOne6M_indAbsentWorkRelated() {
    return hasOne6M_indAbsentWorkRelated;
  }

  public boolean getOne6M_indAbsentWorkRelated() {
    if (One6M_indAbsentWorkRelated == null) {
      return false;
    }
    return One6M_indAbsentWorkRelated.booleanValue();
  }

  public Boolean getOne6M_indAbsentWorkRelatedObject() {
    return One6M_indAbsentWorkRelated;
  }

  public String getOne6M_indAbsentWorkRelatedString() {
    if (One6M_indAbsentWorkRelated == null) {
      return "";
    }
    return One6M_indAbsentWorkRelated.toString();
  }

  public void setOne6M_indAbsentWorkRelated(boolean One6M_indAbsentWorkRelated) {
    this.hasOne6M_indAbsentWorkRelated = true;
    this.One6M_indAbsentWorkRelated = new Boolean(One6M_indAbsentWorkRelated);
  }

  public void setOne6M_indAbsentWorkRelated(Boolean One6M_indAbsentWorkRelated) {
    this.hasOne6M_indAbsentWorkRelated = true;
    this.One6M_indAbsentWorkRelated = One6M_indAbsentWorkRelated;
  }

  public void setOne6M_indAbsentWorkRelated(String One6M_indAbsentWorkRelated) {
    this.hasOne6M_indAbsentWorkRelated = true;
    this.One6M_indAbsentWorkRelated = isTrueBoolean(One6M_indAbsentWorkRelated);
  }

  public boolean hasOne_indAbsentAltrntCustody() {
    return hasOne_indAbsentAltrntCustody;
  }

  public boolean getOne_indAbsentAltrntCustody() {
    if (One_indAbsentAltrntCustody == null) {
      return false;
    }
    return One_indAbsentAltrntCustody.booleanValue();
  }

  public Boolean getOne_indAbsentAltrntCustodyObject() {
    return One_indAbsentAltrntCustody;
  }

  public String getOne_indAbsentAltrntCustodyString() {
    if (One_indAbsentAltrntCustody == null) {
      return "";
    }
    return One_indAbsentAltrntCustody.toString();
  }

  public void setOne_indAbsentAltrntCustody(boolean One_indAbsentAltrntCustody) {
    this.hasOne_indAbsentAltrntCustody = true;
    this.One_indAbsentAltrntCustody = new Boolean(One_indAbsentAltrntCustody);
  }

  public void setOne_indAbsentAltrntCustody(Boolean One_indAbsentAltrntCustody) {
    this.hasOne_indAbsentAltrntCustody = true;
    this.One_indAbsentAltrntCustody = One_indAbsentAltrntCustody;
  }

  public void setOne_indAbsentAltrntCustody(String One_indAbsentAltrntCustody) {
    this.hasOne_indAbsentAltrntCustody = true;
    this.One_indAbsentAltrntCustody = isTrueBoolean(One_indAbsentAltrntCustody);
  }

  public boolean hasOne_indAbsentDeported() {
    return hasOne_indAbsentDeported;
  }

  public boolean getOne_indAbsentDeported() {
    if (One_indAbsentDeported == null) {
      return false;
    }
    return One_indAbsentDeported.booleanValue();
  }

  public Boolean getOne_indAbsentDeportedObject() {
    return One_indAbsentDeported;
  }

  public String getOne_indAbsentDeportedString() {
    if (One_indAbsentDeported == null) {
      return "";
    }
    return One_indAbsentDeported.toString();
  }

  public void setOne_indAbsentDeported(boolean One_indAbsentDeported) {
    this.hasOne_indAbsentDeported = true;
    this.One_indAbsentDeported = new Boolean(One_indAbsentDeported);
  }

  public void setOne_indAbsentDeported(Boolean One_indAbsentDeported) {
    this.hasOne_indAbsentDeported = true;
    this.One_indAbsentDeported = One_indAbsentDeported;
  }

  public void setOne_indAbsentDeported(String One_indAbsentDeported) {
    this.hasOne_indAbsentDeported = true;
    this.One_indAbsentDeported = isTrueBoolean(One_indAbsentDeported);
  }

  public boolean hasOne_indAbsentDeserted() {
    return hasOne_indAbsentDeserted;
  }

  public boolean getOne_indAbsentDeserted() {
    if (One_indAbsentDeserted == null) {
      return false;
    }
    return One_indAbsentDeserted.booleanValue();
  }

  public Boolean getOne_indAbsentDesertedObject() {
    return One_indAbsentDeserted;
  }

  public String getOne_indAbsentDesertedString() {
    if (One_indAbsentDeserted == null) {
      return "";
    }
    return One_indAbsentDeserted.toString();
  }

  public void setOne_indAbsentDeserted(boolean One_indAbsentDeserted) {
    this.hasOne_indAbsentDeserted = true;
    this.One_indAbsentDeserted = new Boolean(One_indAbsentDeserted);
  }

  public void setOne_indAbsentDeserted(Boolean One_indAbsentDeserted) {
    this.hasOne_indAbsentDeserted = true;
    this.One_indAbsentDeserted = One_indAbsentDeserted;
  }

  public void setOne_indAbsentDeserted(String One_indAbsentDeserted) {
    this.hasOne_indAbsentDeserted = true;
    this.One_indAbsentDeserted = isTrueBoolean(One_indAbsentDeserted);
  }

  public boolean hasOne_indAbsentDied() {
    return hasOne_indAbsentDied;
  }

  public boolean getOne_indAbsentDied() {
    if (One_indAbsentDied == null) {
      return false;
    }
    return One_indAbsentDied.booleanValue();
  }

  public Boolean getOne_indAbsentDiedObject() {
    return One_indAbsentDied;
  }

  public String getOne_indAbsentDiedString() {
    if (One_indAbsentDied == null) {
      return "";
    }
    return One_indAbsentDied.toString();
  }

  public void setOne_indAbsentDied(boolean One_indAbsentDied) {
    this.hasOne_indAbsentDied = true;
    this.One_indAbsentDied = new Boolean(One_indAbsentDied);
  }

  public void setOne_indAbsentDied(Boolean One_indAbsentDied) {
    this.hasOne_indAbsentDied = true;
    this.One_indAbsentDied = One_indAbsentDied;
  }

  public void setOne_indAbsentDied(String One_indAbsentDied) {
    this.hasOne_indAbsentDied = true;
    this.One_indAbsentDied = isTrueBoolean(One_indAbsentDied);
  }

  public boolean hasOne_indAbsentDivorced() {
    return hasOne_indAbsentDivorced;
  }

  public boolean getOne_indAbsentDivorced() {
    if (One_indAbsentDivorced == null) {
      return false;
    }
    return One_indAbsentDivorced.booleanValue();
  }

  public Boolean getOne_indAbsentDivorcedObject() {
    return One_indAbsentDivorced;
  }

  public String getOne_indAbsentDivorcedString() {
    if (One_indAbsentDivorced == null) {
      return "";
    }
    return One_indAbsentDivorced.toString();
  }

  public void setOne_indAbsentDivorced(boolean One_indAbsentDivorced) {
    this.hasOne_indAbsentDivorced = true;
    this.One_indAbsentDivorced = new Boolean(One_indAbsentDivorced);
  }

  public void setOne_indAbsentDivorced(Boolean One_indAbsentDivorced) {
    this.hasOne_indAbsentDivorced = true;
    this.One_indAbsentDivorced = One_indAbsentDivorced;
  }

  public void setOne_indAbsentDivorced(String One_indAbsentDivorced) {
    this.hasOne_indAbsentDivorced = true;
    this.One_indAbsentDivorced = isTrueBoolean(One_indAbsentDivorced);
  }

  public boolean hasOne_indAbsentFather() {
    return hasOne_indAbsentFather;
  }

  public boolean getOne_indAbsentFather() {
    if (One_indAbsentFather == null) {
      return false;
    }
    return One_indAbsentFather.booleanValue();
  }

  public Boolean getOne_indAbsentFatherObject() {
    return One_indAbsentFather;
  }

  public String getOne_indAbsentFatherString() {
    if (One_indAbsentFather == null) {
      return "";
    }
    return One_indAbsentFather.toString();
  }

  public void setOne_indAbsentFather(boolean One_indAbsentFather) {
    this.hasOne_indAbsentFather = true;
    this.One_indAbsentFather = new Boolean(One_indAbsentFather);
  }

  public void setOne_indAbsentFather(Boolean One_indAbsentFather) {
    this.hasOne_indAbsentFather = true;
    this.One_indAbsentFather = One_indAbsentFather;
  }

  public void setOne_indAbsentFather(String One_indAbsentFather) {
    this.hasOne_indAbsentFather = true;
    this.One_indAbsentFather = isTrueBoolean(One_indAbsentFather);
  }

  public boolean hasOne_indAbsentHospitalized() {
    return hasOne_indAbsentHospitalized;
  }

  public boolean getOne_indAbsentHospitalized() {
    if (One_indAbsentHospitalized == null) {
      return false;
    }
    return One_indAbsentHospitalized.booleanValue();
  }

  public Boolean getOne_indAbsentHospitalizedObject() {
    return One_indAbsentHospitalized;
  }

  public String getOne_indAbsentHospitalizedString() {
    if (One_indAbsentHospitalized == null) {
      return "";
    }
    return One_indAbsentHospitalized.toString();
  }

  public void setOne_indAbsentHospitalized(boolean One_indAbsentHospitalized) {
    this.hasOne_indAbsentHospitalized = true;
    this.One_indAbsentHospitalized = new Boolean(One_indAbsentHospitalized);
  }

  public void setOne_indAbsentHospitalized(Boolean One_indAbsentHospitalized) {
    this.hasOne_indAbsentHospitalized = true;
    this.One_indAbsentHospitalized = One_indAbsentHospitalized;
  }

  public void setOne_indAbsentHospitalized(String One_indAbsentHospitalized) {
    this.hasOne_indAbsentHospitalized = true;
    this.One_indAbsentHospitalized = isTrueBoolean(One_indAbsentHospitalized);
  }

  public boolean hasOne_indAbsentIncarcerated() {
    return hasOne_indAbsentIncarcerated;
  }

  public boolean getOne_indAbsentIncarcerated() {
    if (One_indAbsentIncarcerated == null) {
      return false;
    }
    return One_indAbsentIncarcerated.booleanValue();
  }

  public Boolean getOne_indAbsentIncarceratedObject() {
    return One_indAbsentIncarcerated;
  }

  public String getOne_indAbsentIncarceratedString() {
    if (One_indAbsentIncarcerated == null) {
      return "";
    }
    return One_indAbsentIncarcerated.toString();
  }

  public void setOne_indAbsentIncarcerated(boolean One_indAbsentIncarcerated) {
    this.hasOne_indAbsentIncarcerated = true;
    this.One_indAbsentIncarcerated = new Boolean(One_indAbsentIncarcerated);
  }

  public void setOne_indAbsentIncarcerated(Boolean One_indAbsentIncarcerated) {
    this.hasOne_indAbsentIncarcerated = true;
    this.One_indAbsentIncarcerated = One_indAbsentIncarcerated;
  }

  public void setOne_indAbsentIncarcerated(String One_indAbsentIncarcerated) {
    this.hasOne_indAbsentIncarcerated = true;
    this.One_indAbsentIncarcerated = isTrueBoolean(One_indAbsentIncarcerated);
  }

  public boolean hasOne_indAbsentMilitaryWork() {
    return hasOne_indAbsentMilitaryWork;
  }

  public boolean getOne_indAbsentMilitaryWork() {
    if (One_indAbsentMilitaryWork == null) {
      return false;
    }
    return One_indAbsentMilitaryWork.booleanValue();
  }

  public Boolean getOne_indAbsentMilitaryWorkObject() {
    return One_indAbsentMilitaryWork;
  }

  public String getOne_indAbsentMilitaryWorkString() {
    if (One_indAbsentMilitaryWork == null) {
      return "";
    }
    return One_indAbsentMilitaryWork.toString();
  }

  public void setOne_indAbsentMilitaryWork(boolean One_indAbsentMilitaryWork) {
    this.hasOne_indAbsentMilitaryWork = true;
    this.One_indAbsentMilitaryWork = new Boolean(One_indAbsentMilitaryWork);
  }

  public void setOne_indAbsentMilitaryWork(Boolean One_indAbsentMilitaryWork) {
    this.hasOne_indAbsentMilitaryWork = true;
    this.One_indAbsentMilitaryWork = One_indAbsentMilitaryWork;
  }

  public void setOne_indAbsentMilitaryWork(String One_indAbsentMilitaryWork) {
    this.hasOne_indAbsentMilitaryWork = true;
    this.One_indAbsentMilitaryWork = isTrueBoolean(One_indAbsentMilitaryWork);
  }

  public boolean hasOne_indAbsentMother() {
    return hasOne_indAbsentMother;
  }

  public boolean getOne_indAbsentMother() {
    if (One_indAbsentMother == null) {
      return false;
    }
    return One_indAbsentMother.booleanValue();
  }

  public Boolean getOne_indAbsentMotherObject() {
    return One_indAbsentMother;
  }

  public String getOne_indAbsentMotherString() {
    if (One_indAbsentMother == null) {
      return "";
    }
    return One_indAbsentMother.toString();
  }

  public void setOne_indAbsentMother(boolean One_indAbsentMother) {
    this.hasOne_indAbsentMother = true;
    this.One_indAbsentMother = new Boolean(One_indAbsentMother);
  }

  public void setOne_indAbsentMother(Boolean One_indAbsentMother) {
    this.hasOne_indAbsentMother = true;
    this.One_indAbsentMother = One_indAbsentMother;
  }

  public void setOne_indAbsentMother(String One_indAbsentMother) {
    this.hasOne_indAbsentMother = true;
    this.One_indAbsentMother = isTrueBoolean(One_indAbsentMother);
  }

  public boolean hasOne_indAbsentSeparated() {
    return hasOne_indAbsentSeparated;
  }

  public boolean getOne_indAbsentSeparated() {
    if (One_indAbsentSeparated == null) {
      return false;
    }
    return One_indAbsentSeparated.booleanValue();
  }

  public Boolean getOne_indAbsentSeparatedObject() {
    return One_indAbsentSeparated;
  }

  public String getOne_indAbsentSeparatedString() {
    if (One_indAbsentSeparated == null) {
      return "";
    }
    return One_indAbsentSeparated.toString();
  }

  public void setOne_indAbsentSeparated(boolean One_indAbsentSeparated) {
    this.hasOne_indAbsentSeparated = true;
    this.One_indAbsentSeparated = new Boolean(One_indAbsentSeparated);
  }

  public void setOne_indAbsentSeparated(Boolean One_indAbsentSeparated) {
    this.hasOne_indAbsentSeparated = true;
    this.One_indAbsentSeparated = One_indAbsentSeparated;
  }

  public void setOne_indAbsentSeparated(String One_indAbsentSeparated) {
    this.hasOne_indAbsentSeparated = true;
    this.One_indAbsentSeparated = isTrueBoolean(One_indAbsentSeparated);
  }

  public boolean hasOne_indAbsentWorkRelated() {
    return hasOne_indAbsentWorkRelated;
  }

  public boolean getOne_indAbsentWorkRelated() {
    if (One_indAbsentWorkRelated == null) {
      return false;
    }
    return One_indAbsentWorkRelated.booleanValue();
  }

  public Boolean getOne_indAbsentWorkRelatedObject() {
    return One_indAbsentWorkRelated;
  }

  public String getOne_indAbsentWorkRelatedString() {
    if (One_indAbsentWorkRelated == null) {
      return "";
    }
    return One_indAbsentWorkRelated.toString();
  }

  public void setOne_indAbsentWorkRelated(boolean One_indAbsentWorkRelated) {
    this.hasOne_indAbsentWorkRelated = true;
    this.One_indAbsentWorkRelated = new Boolean(One_indAbsentWorkRelated);
  }

  public void setOne_indAbsentWorkRelated(Boolean One_indAbsentWorkRelated) {
    this.hasOne_indAbsentWorkRelated = true;
    this.One_indAbsentWorkRelated = One_indAbsentWorkRelated;
  }

  public void setOne_indAbsentWorkRelated(String One_indAbsentWorkRelated) {
    this.hasOne_indAbsentWorkRelated = true;
    this.One_indAbsentWorkRelated = isTrueBoolean(One_indAbsentWorkRelated);
  }

  public boolean hasOther6M_indSpecifiedRelative() {
    return hasOther6M_indSpecifiedRelative;
  }

  public boolean getOther6M_indSpecifiedRelative() {
    if (Other6M_indSpecifiedRelative == null) {
      return false;
    }
    return Other6M_indSpecifiedRelative.booleanValue();
  }

  public Boolean getOther6M_indSpecifiedRelativeObject() {
    return Other6M_indSpecifiedRelative;
  }

  public String getOther6M_indSpecifiedRelativeString() {
    if (Other6M_indSpecifiedRelative == null) {
      return "";
    }
    return Other6M_indSpecifiedRelative.toString();
  }

  public void setOther6M_indSpecifiedRelative(boolean Other6M_indSpecifiedRelative) {
    this.hasOther6M_indSpecifiedRelative = true;
    this.Other6M_indSpecifiedRelative = new Boolean(Other6M_indSpecifiedRelative);
  }

  public void setOther6M_indSpecifiedRelative(Boolean Other6M_indSpecifiedRelative) {
    this.hasOther6M_indSpecifiedRelative = true;
    this.Other6M_indSpecifiedRelative = Other6M_indSpecifiedRelative;
  }

  public void setOther6M_indSpecifiedRelative(String Other6M_indSpecifiedRelative) {
    this.hasOther6M_indSpecifiedRelative = true;
    this.Other6M_indSpecifiedRelative = isTrueBoolean(Other6M_indSpecifiedRelative);
  }

  public boolean hasOther_idMngngCvsPerson() {
    return hasOther_idMngngCvsPerson;
  }

  public long getOther_idMngngCvsPerson() {
    if (Other_idMngngCvsPerson == null) {
      return (long) 0;
    }
    return Other_idMngngCvsPerson.longValue();
  }

  public Long getOther_idMngngCvsPersonObject() {
    return Other_idMngngCvsPerson;
  }

  public String getOther_idMngngCvsPersonString() {
    return FormattingHelper.formatLong(Other_idMngngCvsPerson);
  }

  public void setOther_idMngngCvsPerson(long Other_idMngngCvsPerson) {
    this.hasOther_idMngngCvsPerson = true;
    if (Other_idMngngCvsPerson == 0) {
      this.Other_idMngngCvsPerson = null;
      return;
    }
    this.Other_idMngngCvsPerson = new Long(Other_idMngngCvsPerson);
  }

  public void setOther_idMngngCvsPerson(Long Other_idMngngCvsPerson) {
    this.hasOther_idMngngCvsPerson = true;
    this.Other_idMngngCvsPerson = Other_idMngngCvsPerson;
  }

  public void setOther_idMngngCvsPerson(Number Other_idMngngCvsPerson) {
    this.hasOther_idMngngCvsPerson = true;
    this.Other_idMngngCvsPerson = null;
    if (Other_idMngngCvsPerson != null) {
      setOther_idMngngCvsPerson(Other_idMngngCvsPerson.longValue());
    }
  }

  public boolean hasOther_idOtherRelativePerson() {
    return hasOther_idOtherRelativePerson;
  }

  public long getOther_idOtherRelativePerson() {
    if (Other_idOtherRelativePerson == null) {
      return (long) 0;
    }
    return Other_idOtherRelativePerson.longValue();
  }

  public Long getOther_idOtherRelativePersonObject() {
    return Other_idOtherRelativePerson;
  }

  public String getOther_idOtherRelativePersonString() {
    return FormattingHelper.formatLong(Other_idOtherRelativePerson);
  }

  public void setOther_idOtherRelativePerson(long Other_idOtherRelativePerson) {
    this.hasOther_idOtherRelativePerson = true;
    if (Other_idOtherRelativePerson == 0) {
      this.Other_idOtherRelativePerson = null;
      return;
    }
    this.Other_idOtherRelativePerson = new Long(Other_idOtherRelativePerson);
  }

  public void setOther_idOtherRelativePerson(Long Other_idOtherRelativePerson) {
    this.hasOther_idOtherRelativePerson = true;
    this.Other_idOtherRelativePerson = Other_idOtherRelativePerson;
  }

  public void setOther_idOtherRelativePerson(Number Other_idOtherRelativePerson) {
    this.hasOther_idOtherRelativePerson = true;
    this.Other_idOtherRelativePerson = null;
    if (Other_idOtherRelativePerson != null) {
      setOther_idOtherRelativePerson(Other_idOtherRelativePerson.longValue());
    }
  }

  public boolean hasOther_indSpecifiedRelative() {
    return hasOther_indSpecifiedRelative;
  }

  public boolean getOther_indSpecifiedRelative() {
    if (Other_indSpecifiedRelative == null) {
      return false;
    }
    return Other_indSpecifiedRelative.booleanValue();
  }

  public Boolean getOther_indSpecifiedRelativeObject() {
    return Other_indSpecifiedRelative;
  }

  public String getOther_indSpecifiedRelativeString() {
    if (Other_indSpecifiedRelative == null) {
      return "";
    }
    return Other_indSpecifiedRelative.toString();
  }

  public void setOther_indSpecifiedRelative(boolean Other_indSpecifiedRelative) {
    this.hasOther_indSpecifiedRelative = true;
    this.Other_indSpecifiedRelative = new Boolean(Other_indSpecifiedRelative);
  }

  public void setOther_indSpecifiedRelative(Boolean Other_indSpecifiedRelative) {
    this.hasOther_indSpecifiedRelative = true;
    this.Other_indSpecifiedRelative = Other_indSpecifiedRelative;
  }

  public void setOther_indSpecifiedRelative(String Other_indSpecifiedRelative) {
    this.hasOther_indSpecifiedRelative = true;
    this.Other_indSpecifiedRelative = isTrueBoolean(Other_indSpecifiedRelative);
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

  public boolean hasIndAbsentNeverCohabitated() {
    return hasIndAbsentNeverCohabitated;
  }

  public boolean getIndAbsentNeverCohabitated() {
    if (indAbsentNeverCohabitated == null) {
      return false;
    }
    return indAbsentNeverCohabitated.booleanValue();
  }

  public Boolean getIndAbsentNeverCohabitatedObject() {
    return indAbsentNeverCohabitated;
  }

  public String getIndAbsentNeverCohabitatedString() {
    if (indAbsentNeverCohabitated == null) {
      return "";
    }
    return indAbsentNeverCohabitated.toString();
  }

  public void setIndAbsentNeverCohabitated(boolean indAbsentNeverCohabitated) {
    this.hasIndAbsentNeverCohabitated = true;
    this.indAbsentNeverCohabitated = new Boolean(indAbsentNeverCohabitated);
  }

  public void setIndAbsentNeverCohabitated(Boolean indAbsentNeverCohabitated) {
    this.hasIndAbsentNeverCohabitated = true;
    this.indAbsentNeverCohabitated = indAbsentNeverCohabitated;
  }

  public void setIndAbsentNeverCohabitated(String indAbsentNeverCohabitated) {
    this.hasIndAbsentNeverCohabitated = true;
    this.indAbsentNeverCohabitated = isTrueBoolean(indAbsentNeverCohabitated);
  }

  public boolean hasOne_indAbsentNeverCohabitated() {
    return hasOne_indAbsentNeverCohabitated;
  }

  public boolean getOne_indAbsentNeverCohabitated() {
    if (One_indAbsentNeverCohabitated == null) {
      return false;
    }
    return One_indAbsentNeverCohabitated.booleanValue();
  }

  public Boolean getOne_indAbsentNeverCohabitatedObject() {
    return One_indAbsentNeverCohabitated;
  }

  public String getOne_indAbsentNeverCohabitatedString() {
    if (One_indAbsentNeverCohabitated == null) {
      return "";
    }
    return One_indAbsentNeverCohabitated.toString();
  }

  public void setOne_indAbsentNeverCohabitated(boolean One_indAbsentNeverCohabitated) {
    this.hasOne_indAbsentNeverCohabitated = true;
    this.One_indAbsentNeverCohabitated = new Boolean(One_indAbsentNeverCohabitated);
  }

  public void setOne_indAbsentNeverCohabitated(Boolean One_indAbsentNeverCohabitated) {
    this.hasOne_indAbsentNeverCohabitated = true;
    this.One_indAbsentNeverCohabitated = One_indAbsentNeverCohabitated;
  }

  public void setOne_indAbsentNeverCohabitated(String One_indAbsentNeverCohabitated) {
    this.hasOne_indAbsentNeverCohabitated = true;
    this.One_indAbsentNeverCohabitated = isTrueBoolean(One_indAbsentNeverCohabitated);
  }

  public boolean hasOne6M_indAbsentNeverCohabitated() {
    return hasOne6M_indAbsentNeverCohabitated;
  }

  public boolean getOne6M_indAbsentNeverCohabitated() {
    if (One6M_indAbsentNeverCohabitated == null) {
      return false;
    }
    return One6M_indAbsentNeverCohabitated.booleanValue();
  }

  public Boolean getOne6M_indAbsentNeverCohabitatedObject() {
    return One6M_indAbsentNeverCohabitated;
  }

  public String getOne6M_indAbsentNeverCohabitatedString() {
    if (One6M_indAbsentNeverCohabitated == null) {
      return "";
    }
    return One6M_indAbsentNeverCohabitated.toString();
  }

  public void setOne6M_indAbsentNeverCohabitated(boolean One6M_indAbsentNeverCohabitated) {
    this.hasOne6M_indAbsentNeverCohabitated = true;
    this.One6M_indAbsentNeverCohabitated = new Boolean(One6M_indAbsentNeverCohabitated);
  }

  public void setOne6M_indAbsentNeverCohabitated(Boolean One6M_indAbsentNeverCohabitated) {
    this.hasOne6M_indAbsentNeverCohabitated = true;
    this.One6M_indAbsentNeverCohabitated = One6M_indAbsentNeverCohabitated;
  }

  public void setOne6M_indAbsentNeverCohabitated(String One6M_indAbsentNeverCohabitated) {
    this.hasOne6M_indAbsentNeverCohabitated = true;
    this.One6M_indAbsentNeverCohabitated = isTrueBoolean(One6M_indAbsentNeverCohabitated);
  }

  public boolean hasNbrStepparentChildren() {
    return hasNbrStepparentChildren;
  }

  public long getNbrStepparentChildren() {
    if (nbrStepparentChildren == null) {
      return (long) 0;
    }
    return nbrStepparentChildren.longValue();
  }

  public Long getNbrStepparentChildrenObject() {
    return nbrStepparentChildren;
  }

  public String getNbrStepparentChildrenString() {
    return FormattingHelper.formatLong(nbrStepparentChildren);
  }

  public void setNbrStepparentChildren(long nbrStepparentChildren) {
    this.hasNbrStepparentChildren = true;
    if (nbrStepparentChildren == 0) {
      this.nbrStepparentChildren = null;
      return;
    }
    this.nbrStepparentChildren = new Long(nbrStepparentChildren);
  }

  public void setNbrStepparentChildren(Long nbrStepparentChildren) {
    this.hasNbrStepparentChildren = true;
    this.nbrStepparentChildren = nbrStepparentChildren;
  }

  public void setNbrStepparentChildren(Number nbrStepparentChildren) {
    this.hasNbrStepparentChildren = true;
    this.nbrStepparentChildren = null;
    if (nbrStepparentChildren != null) {
      setNbrStepparentChildren(nbrStepparentChildren.longValue());
    }
  }

  public void copyInto(DomicileDeprivationDB domicileDeprivationDB) {
    if (hasAddrHealthAddrCity) {
      domicileDeprivationDB.setAddrHealthAddrCity(addrHealthAddrCity);
    }
    if (hasAddrHealthAddrStLn1) {
      domicileDeprivationDB.setAddrHealthAddrStLn1(addrHealthAddrStLn1);
    }
    if (hasAddrHealthAddrStLn2) {
      domicileDeprivationDB.setAddrHealthAddrStLn2(addrHealthAddrStLn2);
    }
    if (hasAddrHealthAddrZip) {
      domicileDeprivationDB.setAddrHealthAddrZip(addrHealthAddrZip);
    }
    if (hasAddrRemovalAddrZip) {
      domicileDeprivationDB.setAddrRemovalAddrZip(addrRemovalAddrZip);
    }
    if (hasAddrRemovalCity) {
      domicileDeprivationDB.setAddrRemovalCity(addrRemovalCity);
    }
    if (hasAddrRemovalStLn1) {
      domicileDeprivationDB.setAddrRemovalStLn1(addrRemovalStLn1);
    }
    if (hasAddrRemovalStLn2) {
      domicileDeprivationDB.setAddrRemovalStLn2(addrRemovalStLn2);
    }
    if (hasCdApplication) {
      domicileDeprivationDB.setCdApplication(cdApplication);
    }
    if (hasCdCountyHospital) {
      domicileDeprivationDB.setCdCountyHospital(cdCountyHospital);
    }
    if (hasCdHealthAddrState) {
      domicileDeprivationDB.setCdHealthAddrState(cdHealthAddrState);
    }
    if (hasCdLivingMonthRemoval) {
      domicileDeprivationDB.setCdLivingMonthRemoval(cdLivingMonthRemoval);
    }
    if (hasCdNotaMostRecent) {
      domicileDeprivationDB.setCdNotaMostRecent(cdNotaMostRecent);
    }
    if (hasCdRemovalAddrCounty) {
      domicileDeprivationDB.setCdRemovalAddrCounty(cdRemovalAddrCounty);
    }
    if (hasCdRemovalAddrState) {
      domicileDeprivationDB.setCdRemovalAddrState(cdRemovalAddrState);
    }
    if (hasCdState) {
      domicileDeprivationDB.setCdState(cdState);
    }
    if (hasDtApplicationComplete) {
      domicileDeprivationDB.setDtApplicationComplete(dtApplicationComplete);
    }
    if (hasDtHealthBeginDate) {
      domicileDeprivationDB.setDtHealthBeginDate(dtHealthBeginDate);
    }
    if (hasDtHealthEndDate) {
      domicileDeprivationDB.setDtHealthEndDate(dtHealthEndDate);
    }
    if (hasDtHospitalAdmission) {
      domicileDeprivationDB.setDtHospitalAdmission(dtHospitalAdmission);
    }
    if (hasDtHospitalDischarge) {
      domicileDeprivationDB.setDtHospitalDischarge(dtHospitalDischarge);
    }
    if (hasFceApplicationDtLastUpdate) {
      domicileDeprivationDB.setFceApplicationDtLastUpdate(fceApplicationDtLastUpdate);
    }
    if (hasDtNotifiedWorker) {
      domicileDeprivationDB.setDtNotifiedWorker(dtNotifiedWorker);
    }
    if (hasDtProofAgeSentEs) {
      domicileDeprivationDB.setDtProofAgeSentEs(dtProofAgeSentEs);
    }
    if (hasDtProofCitizenshipSentEs) {
      domicileDeprivationDB.setDtProofCitizenshipSentEs(dtProofCitizenshipSentEs);
    }
    if (hasDtRemovalDate) {
      domicileDeprivationDB.setDtRemovalDate(dtRemovalDate);
    }
    if (hasIdCase) {
      domicileDeprivationDB.setIdCase(idCase);
    }
    if (hasIdEvent) {
      domicileDeprivationDB.setIdEvent(idEvent);
    }
    if (hasIdFceApplication) {
      domicileDeprivationDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      domicileDeprivationDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdLastUpdatePerson) {
      domicileDeprivationDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdMngngCvsPerson) {
      domicileDeprivationDB.setIdMngngCvsPerson(idMngngCvsPerson);
    }
    if (hasIdOtherRelativePerson) {
      domicileDeprivationDB.setIdOtherRelativePerson(idOtherRelativePerson);
    }
    if (hasIdPerson) {
      domicileDeprivationDB.setIdPerson(idPerson);
    }
    if (hasIdStage) {
      domicileDeprivationDB.setIdStage(idStage);
    }
    if (hasIndAgeJustifiedEval) {
      domicileDeprivationDB.setIndAgeJustifiedEval(indAgeJustifiedEval);
    }
    if (hasIndAgeVrfdBaptismCert) {
      domicileDeprivationDB.setIndAgeVrfdBaptismCert(indAgeVrfdBaptismCert);
    }
    if (hasIndAgeJustifiedEval) {
      domicileDeprivationDB.setIndAgeJustifiedEval(indAgeJustifiedEval);
    }
    if (hasIndAgeVrfdForeignCert) {
      domicileDeprivationDB.setIndAgeVrfdForeignCert(indAgeVrfdForeignCert);
    }
    if (hasIndAgeVrfdHospitalCert) {
      domicileDeprivationDB.setIndAgeVrfdHospitalCert(indAgeVrfdHospitalCert);
    }
    if (hasIndAgeVrfdNtrlztnCert) {
      domicileDeprivationDB.setIndAgeVrfdNtrlztnCert(indAgeVrfdNtrlztnCert);
    }
    if (hasIndAgeVrfdPassport) {
      domicileDeprivationDB.setIndAgeVrfdPassport(indAgeVrfdPassport);
    }
    if (hasIndAgeVrfdResidentCard) {
      domicileDeprivationDB.setIndAgeVrfdResidentCard(indAgeVrfdResidentCard);
    }
    if (hasIndAgeVrfdSaveSystem) {
      domicileDeprivationDB.setIndAgeVrfdSaveSystem(indAgeVrfdSaveSystem);
    }
    if (hasIndAgeVrfdSuccessSystem) {
      domicileDeprivationDB.setIndAgeVrfdSuccessSystem(indAgeVrfdSuccessSystem);
    }
    if (hasIndAgeVrfdUsBirthCert) {
      domicileDeprivationDB.setIndAgeVrfdUsBirthCert(indAgeVrfdUsBirthCert);
    }
    if (hasIndAmendedApp) {
      domicileDeprivationDB.setIndAmendedApp(indAmendedApp);
    }
    if (hasIndChildSupportOrder) {
      domicileDeprivationDB.setIndChildSupportOrder(indChildSupportOrder);
    }
    if (hasIndEvaluationConclusion) {
      domicileDeprivationDB.setIndEvaluationConclusion(indEvaluationConclusion);
    }
    if (hasIndHospital) {
      domicileDeprivationDB.setIndHospital(indHospital);
    }
    if (hasIndIncomeAssistance) {
      domicileDeprivationDB.setIndIncomeAssistance(indIncomeAssistance);
    }
    if (hasIndLegalDocsSentEs) {
      domicileDeprivationDB.setIndLegalDocsSentEs(indLegalDocsSentEs);
    }
    if (hasIndLivingRelativeSixMonth) {
      domicileDeprivationDB.setIndLivingRelativeSixMonth(indLivingRelativeSixMonth);
    }
    if (hasIndManagingCvs) {
      domicileDeprivationDB.setIndManagingCvs(indManagingCvs);
    }
    if (hasIndMinorParent) {
      domicileDeprivationDB.setIndMinorParent(indMinorParent);
    }
    if (hasIndNotifiedDhsWorker) {
      domicileDeprivationDB.setIndNotifiedDhsWorker(indNotifiedDhsWorker);
    }
    if (hasIndOtherHealthInsurance) {
      domicileDeprivationDB.setIndOtherHealthInsurance(indOtherHealthInsurance);
    }
    if (hasIndProofAgeSentEs) {
      domicileDeprivationDB.setIndProofAgeSentEs(indProofAgeSentEs);
    }
    if (hasIndProofCitizenshipSentEs) {
      domicileDeprivationDB.setIndProofCitizenshipSentEs(indProofCitizenshipSentEs);
    }
    if (hasIndSpecifiedRelative) {
      domicileDeprivationDB.setIndSpecifiedRelative(indSpecifiedRelative);
    }
    if (hasNbrCourtMonth) {
      domicileDeprivationDB.setNbrCourtMonth(nbrCourtMonth);
    }
    if (hasNbrCourtYear) {
      domicileDeprivationDB.setNbrCourtYear(nbrCourtYear);
    }
    if (hasNbrHealthGroup) {
      domicileDeprivationDB.setNbrHealthGroup(nbrHealthGroup);
    }
    if (hasNbrHealthPolicy) {
      domicileDeprivationDB.setNbrHealthPolicy(nbrHealthPolicy);
    }
    if (hasNbrLivingAtHome) {
      domicileDeprivationDB.setNbrLivingAtHome(nbrLivingAtHome);
    }
    if (hasNbrNotifiedDhsWrkrPhn) {
      domicileDeprivationDB.setNbrNotifiedDhsWrkrPhn(nbrNotifiedDhsWrkrPhn);
    }
    if (hasNmHealthCompany) {
      domicileDeprivationDB.setNmHealthCompany(nmHealthCompany);
    }
    if (hasNmHealthEmployeeNm) {
      domicileDeprivationDB.setNmHealthEmployeeNm(nmHealthEmployeeNm);
    }
    if (hasNmHealthEmployerNm) {
      domicileDeprivationDB.setNmHealthEmployerNm(nmHealthEmployerNm);
    }
    if (hasNmHealthPolicyHldrNm) {
      domicileDeprivationDB.setNmHealthPolicyHldrNm(nmHealthPolicyHldrNm);
    }
    if (hasNmHospital) {
      domicileDeprivationDB.setNmHospital(nmHospital);
    }
    if (hasNmHospitalCity) {
      domicileDeprivationDB.setNmHospitalCity(nmHospitalCity);
    }
    if (hasNmMotherMaiden) {
      domicileDeprivationDB.setNmMotherMaiden(nmMotherMaiden);
    }
    if (hasNmNotifiedDhsWrkrFirst) {
      domicileDeprivationDB.setNmNotifiedDhsWrkrFirst(nmNotifiedDhsWrkrFirst);
    }
    if (hasNmNotifiedDhsWrkrLast) {
      domicileDeprivationDB.setNmNotifiedDhsWrkrLast(nmNotifiedDhsWrkrLast);
    }
    if (hasNmNotifiedDhsWrkrMiddle) {
      domicileDeprivationDB.setNmNotifiedDhsWrkrMiddle(nmNotifiedDhsWrkrMiddle);
    }
    if (hasTxtIncomeDtrmntnComments) {
      domicileDeprivationDB.setTxtIncomeDtrmntnComments(txtIncomeDtrmntnComments);
    }
    if (hasTxtLegalDocsSentEs) {
      domicileDeprivationDB.setTxtLegalDocsSentEs(txtLegalDocsSentEs);
    }
    if (hasTxtMeetsDdOrNotComments) {
      domicileDeprivationDB.setTxtMeetsDdOrNotComments(txtMeetsDdOrNotComments);
    }
    if (hasTxtNoIncomeExplanation) {
      domicileDeprivationDB.setTxtNoIncomeExplanation(txtNoIncomeExplanation);
    }
    if (hasTxtProofAgeSentEs) {
      domicileDeprivationDB.setTxtProofAgeSentEs(txtProofAgeSentEs);
    }
    if (hasTxtProofCitizenshipSentEs) {
      domicileDeprivationDB.setTxtProofCitizenshipSentEs(txtProofCitizenshipSentEs);
    }
    if (hasAmtCountableIncome) {
      domicileDeprivationDB.setAmtCountableIncome(amtCountableIncome);
    }
    if (hasAmtGrossEarnedCrtfdGrp) {
      domicileDeprivationDB.setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp);
    }
    if (hasAmtGrossUnearnedCrtfdGrp) {
      domicileDeprivationDB.setAmtGrossUnearnedCrtfdGrp(amtGrossUnearnedCrtfdGrp);
    }
    if (hasAmtIncomeLimit) {
      domicileDeprivationDB.setAmtIncomeLimit(amtIncomeLimit);
    }
    if (hasAmtPweIncome) {
      domicileDeprivationDB.setAmtPweIncome(amtPweIncome);
    }
    if (hasAmtSsi) {
      domicileDeprivationDB.setAmtSsi(amtSsi);
    }
    if (hasAmtStepparentAlimony) {
      domicileDeprivationDB.setAmtStepparentAlimony(amtStepparentAlimony);
    }
    if (hasAmtStepparentAllowance) {
      domicileDeprivationDB.setAmtStepparentAllowance(amtStepparentAllowance);
    }
    if (hasAmtStepparentAppliedIncome) {
      domicileDeprivationDB.setAmtStepparentAppliedIncome(amtStepparentAppliedIncome);
    }
    if (hasAmtStepparentCntblUnearned) {
      domicileDeprivationDB.setAmtStepparentCntblUnearned(amtStepparentCntblUnearned);
    }
    if (hasAmtStepparentGrossEarned) {
      domicileDeprivationDB.setAmtStepparentGrossEarned(amtStepparentGrossEarned);
    }
    if (hasAmtStepparentOutsidePmnt) {
      domicileDeprivationDB.setAmtStepparentOutsidePmnt(amtStepparentOutsidePmnt);
    }
    if (hasAmtStepparentTotalCntbl) {
      domicileDeprivationDB.setAmtStepparentTotalCntbl(amtStepparentTotalCntbl);
    }
    if (hasAmtStepparentWorkDeduct) {
      domicileDeprivationDB.setAmtStepparentWorkDeduct(amtStepparentWorkDeduct);
    }
    if (hasCdBlocChild) {
      domicileDeprivationDB.setCdBlocChild(cdBlocChild);
    }
    if (hasCdEligibilityActual) {
      domicileDeprivationDB.setCdEligibilityActual(cdEligibilityActual);
    }
    if (hasCdEligibilitySelected) {
      domicileDeprivationDB.setCdEligibilitySelected(cdEligibilitySelected);
    }
    if (hasCdMedicaidEligibilityType) {
      domicileDeprivationDB.setCdMedicaidEligibilityType(cdMedicaidEligibilityType);
    }
    if (hasFceEligibilityCdPersonCitizenship) {
      domicileDeprivationDB.setFceEligibilityCdPersonCitizenship(fceEligibilityCdPersonCitizenship);
    }
    if (hasCdPweIrregularUnder100) {
      domicileDeprivationDB.setCdPweIrregularUnder100(cdPweIrregularUnder100);
    }
    if (hasCdPweSteadyUnder100) {
      domicileDeprivationDB.setCdPweSteadyUnder100(cdPweSteadyUnder100);
    }
    if (hasCdVerifMethod) {
      domicileDeprivationDB.setCdVerifMethod(cdVerifMethod);
    }
    if (hasCdVerifDocType) {
      domicileDeprivationDB.setCdVerifDocType(cdVerifDocType);
    }
    if (hasDtDeprivationChanged) {
      domicileDeprivationDB.setDtDeprivationChanged(dtDeprivationChanged);
    }
    if (hasDtEligibilityEnd) {
      domicileDeprivationDB.setDtEligibilityEnd(dtEligibilityEnd);
    }
    if (hasDtEligDtrmntnStart) {
      domicileDeprivationDB.setDtEligDtrmntnStart(dtEligDtrmntnStart);
    }
    if (hasFceEligibilityDtLastUpdate) {
      domicileDeprivationDB.setFceEligibilityDtLastUpdate(fceEligibilityDtLastUpdate);
    }
    if (hasDtRemovalChildOrdered) {
      domicileDeprivationDB.setDtRemovalChildOrdered(dtRemovalChildOrdered);
    }
    if (hasDtReviewDate) {
      domicileDeprivationDB.setDtReviewDate(dtReviewDate);
    }
    if (hasDtRsnblEffortPreventRem) {
      domicileDeprivationDB.setDtRsnblEffortPreventRem(dtRsnblEffortPreventRem);
    }
    if (hasIdEligibilityEvent) {
      domicileDeprivationDB.setIdEligibilityEvent(idEligibilityEvent);
    }
    if (hasIdFcePerson) {
      domicileDeprivationDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdPrnEarner) {
      domicileDeprivationDB.setIdPrnEarner(idPrnEarner);
    }
    if (hasIdFceReview) {
      domicileDeprivationDB.setIdFceReview(idFceReview);
    }
    if (hasIndAbsentAltrntCustody) {
      domicileDeprivationDB.setIndAbsentAltrntCustody(indAbsentAltrntCustody);
    }
    if (hasIndAbsentDeported) {
      domicileDeprivationDB.setIndAbsentDeported(indAbsentDeported);
    }
    if (hasIndAbsentDeserted) {
      domicileDeprivationDB.setIndAbsentDeserted(indAbsentDeserted);
    }
    if (hasIndAbsentDied) {
      domicileDeprivationDB.setIndAbsentDied(indAbsentDied);
    }
    if (hasIndAbsentDivorced) {
      domicileDeprivationDB.setIndAbsentDivorced(indAbsentDivorced);
    }
    if (hasIndAbsentFather) {
      domicileDeprivationDB.setIndAbsentFather(indAbsentFather);
    }
    if (hasIndAbsentHospitalized) {
      domicileDeprivationDB.setIndAbsentHospitalized(indAbsentHospitalized);
    }
    if (hasIndAbsentIncarcerated) {
      domicileDeprivationDB.setIndAbsentIncarcerated(indAbsentIncarcerated);
    }
    if (hasIndAbsentMilitaryWork) {
      domicileDeprivationDB.setIndAbsentMilitaryWork(indAbsentMilitaryWork);
    }
    if (hasIndAbsentMother) {
      domicileDeprivationDB.setIndAbsentMother(indAbsentMother);
    }
    if (hasIndAbsentSeparated) {
      domicileDeprivationDB.setIndAbsentSeparated(indAbsentSeparated);
    }
    if (hasIndAbsentWorkRelated) {
      domicileDeprivationDB.setIndAbsentWorkRelated(indAbsentWorkRelated);
    }
    if (hasIndChildLivingPrnt6Mnths) {
      domicileDeprivationDB.setIndChildLivingPrnt6Mnths(indChildLivingPrnt6Mnths);
    }
    if (hasIndChildQualifiedCitizen) {
      domicileDeprivationDB.setIndChildQualifiedCitizen(indChildQualifiedCitizen);
    }
    if (hasIndChildSupportOrdered) {
      domicileDeprivationDB.setIndChildSupportOrdered(indChildSupportOrdered);
    }
    if (hasIndChildUnder18) {
      domicileDeprivationDB.setIndChildUnder18(indChildUnder18);
    }
    if (hasIndCtznshpAmerIndianCrd) {
      domicileDeprivationDB.setIndCtznshpAmerIndianCrd(indCtznshpAmerIndianCrd);
    }
    if (hasIndCtznshpAttorneyReview) {
      domicileDeprivationDB.setIndCtznshpAttorneyReview(indCtznshpAttorneyReview);
    }
    if (hasIndCtznshpBirthCrtfctFor) {
      domicileDeprivationDB.setIndCtznshpBirthCrtfctFor(indCtznshpBirthCrtfctFor);
    }
    if (hasIndCtznshpBirthCrtfctUs) {
      domicileDeprivationDB.setIndCtznshpBirthCrtfctUs(indCtznshpBirthCrtfctUs);
    }
    if (hasIndCtznshpChldFound) {
      domicileDeprivationDB.setIndCtznshpChldFound(indCtznshpChldFound);
    }
    if (hasIndCtznshpCitizenCrtfct) {
      domicileDeprivationDB.setIndCtznshpCitizenCrtfct(indCtznshpCitizenCrtfct);
    }
    if (hasIndCtznshpEvaluation) {
      domicileDeprivationDB.setIndCtznshpEvaluation(indCtznshpEvaluation);
    }
    if (hasIndCtznshpForDocumentation) {
      domicileDeprivationDB.setIndCtznshpForDocumentation(indCtznshpForDocumentation);
    }
    if (hasIndCtznshpHospitalCrtfct) {
      domicileDeprivationDB.setIndCtznshpHospitalCrtfct(indCtznshpHospitalCrtfct);
    }
    if (hasIndCtznshpNoDocumentation) {
      domicileDeprivationDB.setIndCtznshpNoDocumentation(indCtznshpNoDocumentation);
    }
    if (hasIndCtznshpNtrlztnCrtfct) {
      domicileDeprivationDB.setIndCtznshpNtrlztnCrtfct(indCtznshpNtrlztnCrtfct);
    }
    if (hasIndCtznshpPassport) {
      domicileDeprivationDB.setIndCtznshpPassport(indCtznshpPassport);
    }
    if (hasIndCtznshpResidentCard) {
      domicileDeprivationDB.setIndCtznshpResidentCard(indCtznshpResidentCard);
    }
    if (hasIndCtznshpUnaccMinorChild) {
      domicileDeprivationDB.setIndCtznshpUnaccMinorChild(indCtznshpUnaccMinorChild);
    }
    if (hasIndCtznshpUndocImmigrant) {
      domicileDeprivationDB.setIndCtznshpUndocImmigrant(indCtznshpUndocImmigrant);
    }
    if (hasIndCtznshpUsHsptlBrthRcrd) {
      domicileDeprivationDB.setIndCtznshpUsHsptlBrthRcrd(indCtznshpUsHsptlBrthRcrd);
    }
    if (hasIndCtznshpUsIdCard) {
      domicileDeprivationDB.setIndCtznshpUsIdCard(indCtznshpUsIdCard);
    }
    if (hasIndCtznshpVitalBirthRcrd) {
      domicileDeprivationDB.setIndCtznshpVitalBirthRcrd(indCtznshpVitalBirthRcrd);
    } 
    if (hasIndCtznshpSaveSystem) {
      domicileDeprivationDB.setIndCtznshpSaveSystem(indCtznshpSaveSystem);
    }
    if (hasIndCtznshpStudentVisa) {
      domicileDeprivationDB.setIndCtznshpStudentVisa(indCtznshpStudentVisa);
    }
    if (hasIndCtznshpSuccessSystem) {
      domicileDeprivationDB.setIndCtznshpSuccessSystem(indCtznshpSuccessSystem);
    }
    if (hasIndCtznshpBirthAbroad) {
      domicileDeprivationDB.setIndCtznshpBirthAbroad(indCtznshpBirthAbroad);
    }
    if (hasIndCtznshpCensusBirthRcrd) {
      domicileDeprivationDB.setIndCtznshpCensusBirthRcrd(indCtznshpCensusBirthRcrd);
    }
    if (hasIndEligibilityCourtMonth) {
      domicileDeprivationDB.setIndEligibilityCourtMonth(indEligibilityCourtMonth);
    }
    if (hasIndEligible) {
      domicileDeprivationDB.setIndEligible(indEligible);
    }
    if (hasIndEquity) {
      domicileDeprivationDB.setIndEquity(indEquity);
    }
    if (hasIndFatherPwe) {
      domicileDeprivationDB.setIndFatherPwe(indFatherPwe);
    }
    if (hasIndHomeIncomeAfdcElgblty) {
      domicileDeprivationDB.setIndHomeIncomeAfdcElgblty(indHomeIncomeAfdcElgblty);
    }
    if (hasIndMeetsDpOrNotEs) {
      domicileDeprivationDB.setIndMeetsDpOrNotEs(indMeetsDpOrNotEs);
    }
    if (hasIndMeetsDpOrNotSystem) {
      domicileDeprivationDB.setIndMeetsDpOrNotSystem(indMeetsDpOrNotSystem);
    }
    if (hasIndMotherPwe) {
      domicileDeprivationDB.setIndMotherPwe(indMotherPwe);
    }
    if (hasIndNarrativeApproved) {
      domicileDeprivationDB.setIndNarrativeApproved(indNarrativeApproved);
    }
    if (hasIndOtherVerification) {
      domicileDeprivationDB.setIndOtherVerification(indOtherVerification);
    }
    if (hasIndParentalDeprivation) {
      domicileDeprivationDB.setIndParentalDeprivation(indParentalDeprivation);
    }
    if (hasIndParentDisabled) {
      domicileDeprivationDB.setIndParentDisabled(indParentDisabled);
    }
    if (hasIndPeNotAcptEmpTrn) {
      domicileDeprivationDB.setIndPeNotAcptEmpTrn(indPeNotAcptEmpTrn);
    }
    if (hasIndPeRecvUnemp) {
      domicileDeprivationDB.setIndPeRecvUnemp(indPeRecvUnemp);
    }
    if (hasIndPeWrkEngEduTrn) {
      domicileDeprivationDB.setIndPeWrkEngEduTrn(indPeWrkEngEduTrn);
    }
    if (hasIndPrsManagingCvs) {
      domicileDeprivationDB.setIndPrsManagingCvs(indPrsManagingCvs);
    }
    if (hasIndRecv100PctVa) {
      domicileDeprivationDB.setIndRecv100PctVa(indRecv100PctVa);
    }
    if (hasIndRecvRrRsdi) {
      domicileDeprivationDB.setIndRecvRrRsdi(indRecvRrRsdi);
    }
    if (hasIndRemovalChildOrdered) {
      domicileDeprivationDB.setIndRemovalChildOrdered(indRemovalChildOrdered);
    }
    if (hasIndRsdiVerification) {
      domicileDeprivationDB.setIndRsdiVerification(indRsdiVerification);
    }
    if (hasIndRsnblEffortPrvtRemoval) {
      domicileDeprivationDB.setIndRsnblEffortPrvtRemoval(indRsnblEffortPrvtRemoval);
    }
    if (hasIndSsiVerification) {
      domicileDeprivationDB.setIndSsiVerification(indSsiVerification);
    }
    if (hasNbrCertifiedGroup) {
      domicileDeprivationDB.setNbrCertifiedGroup(nbrCertifiedGroup);
    }
    if (hasNbrParentsHome) {
      domicileDeprivationDB.setNbrParentsHome(nbrParentsHome);
    }
    if (hasTxtDeterminationComments) {
      domicileDeprivationDB.setTxtDeterminationComments(txtDeterminationComments);
    }
    if (hasTxtMonthsDepUnemp) {
      domicileDeprivationDB.setTxtMonthsDepUnemp(txtMonthsDepUnemp);
    }
    if (hasIndAbsentTprVolRelinq) {
      domicileDeprivationDB.setIndAbsentTprVolRelinq(indAbsentTprVolRelinq);
    }
    if (hasTxtMonthsDepDisabled) {
      domicileDeprivationDB.setTxtMonthsDepDisabled(txtMonthsDepDisabled);
    }
    if (hasTxtMonthsDepUnderEmpl) {
      domicileDeprivationDB.setTxtMonthsDepUnderEmpl(txtMonthsDepUnderEmpl);
    }
    if (hasTxtMonthsLivingRelCust) {
      domicileDeprivationDB.setTxtMonthsLivingRelCust(txtMonthsLivingRelCust);
    }
    if (hasPrinciples) {
      domicileDeprivationDB.setPrinciples(principles);
    }
    if (hasBoth6M_amtPweIncome) {
      domicileDeprivationDB.setBoth6M_amtPweIncome(Both6M_amtPweIncome);
    }
    if (hasBoth6M_cdPweIrregularUnder100) {
      domicileDeprivationDB.setBoth6M_cdPweIrregularUnder100(Both6M_cdPweIrregularUnder100);
    }
    if (hasBoth6M_cdPweSteadyUnder100) {
      domicileDeprivationDB.setBoth6M_cdPweSteadyUnder100(Both6M_cdPweSteadyUnder100);
    }
    if (hasBoth6M_cdVerifMethod) {
      domicileDeprivationDB.setBoth6M_cdVerifMethod(Both6M_cdVerifMethod);
    }
    if (hasBoth6M_cdVerifDocType) {
      domicileDeprivationDB.setBoth6M_cdVerifDocType(Both6M_cdVerifDocType);
    }
    if (hasBoth6M_indFatherPwe) {
      domicileDeprivationDB.setBoth6M_indFatherPwe(Both6M_indFatherPwe);
    }
    if (hasBoth6M_indMotherPwe) {
      domicileDeprivationDB.setBoth6M_indMotherPwe(Both6M_indMotherPwe);
    }
    if (hasBoth6M_indOtherVerification) {
      domicileDeprivationDB.setBoth6M_indOtherVerification(Both6M_indOtherVerification);
    }
    if (hasBoth6M_indParentDisabled) {
      domicileDeprivationDB.setBoth6M_indParentDisabled(Both6M_indParentDisabled);
    }
    if (hasBoth6M_indPeNotAcptEmpTrn) {
      domicileDeprivationDB.setBoth6M_indPeNotAcptEmpTrn(Both6M_indPeNotAcptEmpTrn);
    }
    if (hasBoth6M_indPeRecvUnemp) {
      domicileDeprivationDB.setBoth6M_indPeRecvUnemp(Both6M_indPeRecvUnemp);
    }
    if (hasBoth6M_indPeWrkEngEduTrn) {
      domicileDeprivationDB.setBoth6M_indPeWrkEngEduTrn(Both6M_indPeWrkEngEduTrn);
    }
    if (hasBoth6M_indRecv100PctVa) {
      domicileDeprivationDB.setBoth6M_indRecv100PctVa(Both6M_indRecv100PctVa);
    }
    if (hasBoth6M_indRecvRrRsdi) {
      domicileDeprivationDB.setBoth6M_indRecvRrRsdi(Both6M_indRecvRrRsdi);
    }
    if (hasBoth6M_indRsdiVerification) {
      domicileDeprivationDB.setBoth6M_indRsdiVerification(Both6M_indRsdiVerification);
    }
    if (hasBoth6M_indSsiVerification) {
      domicileDeprivationDB.setBoth6M_indSsiVerification(Both6M_indSsiVerification);
    }
    if (hasBoth_amtPweIncome) {
      domicileDeprivationDB.setBoth_amtPweIncome(Both_amtPweIncome);
    }
    if (hasBoth_cdPweIrregularUnder100) {
      domicileDeprivationDB.setBoth_cdPweIrregularUnder100(Both_cdPweIrregularUnder100);
    }
    if (hasBoth_cdPweSteadyUnder100) {
      domicileDeprivationDB.setBoth_cdPweSteadyUnder100(Both_cdPweSteadyUnder100);
    }
    if (hasBoth_cdVerifMethod) {
      domicileDeprivationDB.setBoth_cdVerifMethod(Both_cdVerifMethod);
    }
    if (hasBoth_cdVerifDocType) {
      domicileDeprivationDB.setBoth_cdVerifDocType(Both_cdVerifDocType);
    }
    if (hasBoth_indFatherPwe) {
      domicileDeprivationDB.setBoth_indFatherPwe(Both_indFatherPwe);
    }
    if (hasBoth_indMotherPwe) {
      domicileDeprivationDB.setBoth_indMotherPwe(Both_indMotherPwe);
    }
    if (hasBoth_indOtherVerification) {
      domicileDeprivationDB.setBoth_indOtherVerification(Both_indOtherVerification);
    }
    if (hasBoth_indParentDisabled) {
      domicileDeprivationDB.setBoth_indParentDisabled(Both_indParentDisabled);
    }
    if (hasBoth_indPeNotAcptEmpTrn) {
      domicileDeprivationDB.setBoth_indPeNotAcptEmpTrn(Both_indPeNotAcptEmpTrn);
    }
    if (hasBoth_indPeRecvUnemp) {
      domicileDeprivationDB.setBoth_indPeRecvUnemp(Both_indPeRecvUnemp);
    }
    if (hasBoth_indPeWrkEngEduTrn) {
      domicileDeprivationDB.setBoth_indPeWrkEngEduTrn(Both_indPeWrkEngEduTrn);
    }
    if (hasBoth_indRecv100PctVa) {
      domicileDeprivationDB.setBoth_indRecv100PctVa(Both_indRecv100PctVa);
    }
    if (hasBoth_indRecvRrRsdi) {
      domicileDeprivationDB.setBoth_indRecvRrRsdi(Both_indRecvRrRsdi);
    }
    if (hasBoth_indRsdiVerification) {
      domicileDeprivationDB.setBoth_indRsdiVerification(Both_indRsdiVerification);
    }
    if (hasBoth_indSsiVerification) {
      domicileDeprivationDB.setBoth_indSsiVerification(Both_indSsiVerification);
    }
    if (hasNota_cdNotaMostRecent) {
      domicileDeprivationDB.setNota_cdNotaMostRecent(Nota_cdNotaMostRecent);
    }
    if (hasNota_indChildLivingPrnt6Mnths) {
      domicileDeprivationDB.setNota_indChildLivingPrnt6Mnths(Nota_indChildLivingPrnt6Mnths);
    }
    if (hasOne6M_indAbsentAltrntCustody) {
      domicileDeprivationDB.setOne6M_indAbsentAltrntCustody(One6M_indAbsentAltrntCustody);
    }
    if (hasOne6M_indAbsentDeported) {
      domicileDeprivationDB.setOne6M_indAbsentDeported(One6M_indAbsentDeported);
    }
    if (hasOne6M_indAbsentDeserted) {
      domicileDeprivationDB.setOne6M_indAbsentDeserted(One6M_indAbsentDeserted);
    }
    if (hasOne6M_indAbsentDied) {
      domicileDeprivationDB.setOne6M_indAbsentDied(One6M_indAbsentDied);
    }
    if (hasOne6M_indAbsentDivorced) {
      domicileDeprivationDB.setOne6M_indAbsentDivorced(One6M_indAbsentDivorced);
    }
    if (hasOne6M_indAbsentFather) {
      domicileDeprivationDB.setOne6M_indAbsentFather(One6M_indAbsentFather);
    }
    if (hasOne6M_indAbsentHospitalized) {
      domicileDeprivationDB.setOne6M_indAbsentHospitalized(One6M_indAbsentHospitalized);
    }
    if (hasOne6M_indAbsentIncarcerated) {
      domicileDeprivationDB.setOne6M_indAbsentIncarcerated(One6M_indAbsentIncarcerated);
    }
    if (hasOne6M_indAbsentMilitaryWork) {
      domicileDeprivationDB.setOne6M_indAbsentMilitaryWork(One6M_indAbsentMilitaryWork);
    }
    if (hasOne6M_indAbsentMother) {
      domicileDeprivationDB.setOne6M_indAbsentMother(One6M_indAbsentMother);
    }
    if (hasOne6M_indAbsentSeparated) {
      domicileDeprivationDB.setOne6M_indAbsentSeparated(One6M_indAbsentSeparated);
    }
    if (hasOne6M_indAbsentWorkRelated) {
      domicileDeprivationDB.setOne6M_indAbsentWorkRelated(One6M_indAbsentWorkRelated);
    }
    if (hasOne_indAbsentAltrntCustody) {
      domicileDeprivationDB.setOne_indAbsentAltrntCustody(One_indAbsentAltrntCustody);
    }
    if (hasOne_indAbsentDeported) {
      domicileDeprivationDB.setOne_indAbsentDeported(One_indAbsentDeported);
    }
    if (hasOne_indAbsentDeserted) {
      domicileDeprivationDB.setOne_indAbsentDeserted(One_indAbsentDeserted);
    }
    if (hasOne_indAbsentDied) {
      domicileDeprivationDB.setOne_indAbsentDied(One_indAbsentDied);
    }
    if (hasOne_indAbsentDivorced) {
      domicileDeprivationDB.setOne_indAbsentDivorced(One_indAbsentDivorced);
    }
    if (hasOne_indAbsentFather) {
      domicileDeprivationDB.setOne_indAbsentFather(One_indAbsentFather);
    }
    if (hasOne_indAbsentHospitalized) {
      domicileDeprivationDB.setOne_indAbsentHospitalized(One_indAbsentHospitalized);
    }
    if (hasOne_indAbsentIncarcerated) {
      domicileDeprivationDB.setOne_indAbsentIncarcerated(One_indAbsentIncarcerated);
    }
    if (hasOne_indAbsentMilitaryWork) {
      domicileDeprivationDB.setOne_indAbsentMilitaryWork(One_indAbsentMilitaryWork);
    }
    if (hasOne_indAbsentMother) {
      domicileDeprivationDB.setOne_indAbsentMother(One_indAbsentMother);
    }
    if (hasOne_indAbsentSeparated) {
      domicileDeprivationDB.setOne_indAbsentSeparated(One_indAbsentSeparated);
    }
    if (hasOne_indAbsentWorkRelated) {
      domicileDeprivationDB.setOne_indAbsentWorkRelated(One_indAbsentWorkRelated);
    }
    if (hasOther6M_indSpecifiedRelative) {
      domicileDeprivationDB.setOther6M_indSpecifiedRelative(Other6M_indSpecifiedRelative);
    }
    if (hasOther_idMngngCvsPerson) {
      domicileDeprivationDB.setOther_idMngngCvsPerson(Other_idMngngCvsPerson);
    }
    if (hasOther_idOtherRelativePerson) {
      domicileDeprivationDB.setOther_idOtherRelativePerson(Other_idOtherRelativePerson);
    }
    if (hasOther_indSpecifiedRelative) {
      domicileDeprivationDB.setOther_indSpecifiedRelative(Other_indSpecifiedRelative);
    }
    if (hasCdEventStatus) {
      domicileDeprivationDB.setCdEventStatus(cdEventStatus);
    }
    if (hasIndAbsentNeverCohabitated) {
      domicileDeprivationDB.setIndAbsentNeverCohabitated(indAbsentNeverCohabitated);
    }
    if (hasOne_indAbsentNeverCohabitated) {
      domicileDeprivationDB.setOne_indAbsentNeverCohabitated(One_indAbsentNeverCohabitated);
    }
    if (hasOne6M_indAbsentNeverCohabitated) {
      domicileDeprivationDB.setOne6M_indAbsentNeverCohabitated(One6M_indAbsentNeverCohabitated);
    }
    if (hasNbrStepparentChildren) {
      domicileDeprivationDB.setNbrStepparentChildren(nbrStepparentChildren);
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
      setDtRemovalDate(fceApplicationDB.getDtRemovalDateObject());
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
      setIndSpecifiedRelative(fceApplicationDB.getIndSpecifiedRelativeObject());
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
    if (hasIdPrnEarner) {
      fceEligibilityDB.setIdPrnEarner(idPrnEarner);
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
    if (hasIndAbsentTprVolRelinq) {
      fceEligibilityDB.setIndAbsentTprVolRelinq(indAbsentTprVolRelinq);
    }
    if (hasTxtMonthsDepDisabled) {
      fceEligibilityDB.setTxtMonthsDepDisabled(txtMonthsDepDisabled);
    }
    if (hasTxtMonthsDepUnderEmpl) {
      fceEligibilityDB.setTxtMonthsDepUnderEmpl(txtMonthsDepUnderEmpl);
    }
    if (hasTxtMonthsLivingRelCust) {
      fceEligibilityDB.setTxtMonthsLivingRelCust(txtMonthsLivingRelCust);
    }
    if (hasIndAbsentNeverCohabitated) {
      fceEligibilityDB.setIndAbsentNeverCohabitated(indAbsentNeverCohabitated);
    }
    if (hasNbrStepparentChildren) {
      fceEligibilityDB.setNbrStepparentChildren(nbrStepparentChildren);
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
      setCdVerifMethod(fceEligibilityDB.getCdVerifMethodObject());
    }
    if (fceEligibilityDB.hasCdVerifDocType()) {
      setCdVerifDocType(fceEligibilityDB.getCdVerifDocTypeObject());
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
    if (fceEligibilityDB.hasIdPrnEarner()) {
      setIdPrnEarner(fceEligibilityDB.getIdPrnEarnerObject());
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
      setIndPeNotAcptEmpTrn(fceEligibilityDB.getIndPeNotAcptEmpTrnObject());
    }
    if (fceEligibilityDB.hasIndPeRecvUnemp()) {
      setIndPeRecvUnemp(fceEligibilityDB.getIndPeRecvUnempObject());
    }
    if (fceEligibilityDB.hasIndPeWrkEngEduTrn()) {
      setIndPeWrkEngEduTrn(fceEligibilityDB.getIndPeWrkEngEduTrnObject());
    }
    if (fceEligibilityDB.hasIndPrsManagingCvs()) {
      setIndPrsManagingCvs(fceEligibilityDB.getIndPrsManagingCvsObject());
    }
    if (fceEligibilityDB.hasIndRecv100PctVa()) {
      setIndRecv100PctVa(fceEligibilityDB.getIndRecv100PctVaObject());
    }
    if (fceEligibilityDB.hasIndRecvRrRsdi()) {
      setIndRecvRrRsdi(fceEligibilityDB.getIndRecvRrRsdiObject());
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
    if (fceEligibilityDB.hasIndAbsentTprVolRelinq) {
      setIndAbsentTprVolRelinq(fceEligibilityDB.getIndAbsentTprVolRelinqObject());
    }
    if (fceEligibilityDB.hasTxtMonthsDepDisabled) {
      setTxtMonthsDepDisabled(fceEligibilityDB.getTxtMonthsDepDisabledObject());
    }
    if (fceEligibilityDB.hasTxtMonthsDepUnderEmpl) {
      setTxtMonthsDepUnderEmpl(fceEligibilityDB.getTxtMonthsDepUnderEmplObject());
    }
    if (fceEligibilityDB.hasTxtMonthsLivingRelCust) {
      setTxtMonthsLivingRelCust(fceEligibilityDB.getTxtMonthsLivingRelCustObject());
    }
    if (fceEligibilityDB.hasIndAbsentNeverCohabitated()) {
      setIndAbsentNeverCohabitated(fceEligibilityDB.getIndAbsentNeverCohabitatedObject());
    }
    if (fceEligibilityDB.hasNbrStepparentChildren()) {
      setNbrStepparentChildren(fceEligibilityDB.getNbrStepparentChildrenObject());
    }
  }

  public String toString() {
    return
            "BEGIN bean: DomicileDeprivation\n" +
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
            " idPrnEarner: " + idPrnEarner + "\n" +
            " idFceReview: " + idFceReview + "\n" +
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
            " indAbsentTprVolRelinq: " + indAbsentTprVolRelinq + "\n" +    
            " txtMonthsDepDisabled: " + txtMonthsDepDisabled + "\n" +
            " txtMonthsDepUnderEmpl: " + txtMonthsDepUnderEmpl + "\n" +
            " txtMonthsLivingRelCust: " + txtMonthsLivingRelCust + "\n" +
            " principles: " + principles + "\n" +
            " Both6M_amtPweIncome: " + Both6M_amtPweIncome + "\n" +
            " Both6M_cdPweIrregularUnder100: " + Both6M_cdPweIrregularUnder100 + "\n" +
            " Both6M_cdPweSteadyUnder100: " + Both6M_cdPweSteadyUnder100 + "\n" +
            " Both6M_cdVerifMethod: " + Both6M_cdVerifMethod + "\n" +
            " Both6M_cdVerifDocType: " + Both6M_cdVerifDocType + "\n" +
            " Both6M_idPrnEarner: " + Both6M_idPrnEarner + "\n" +
            " Both6M_indFatherPwe: " + Both6M_indFatherPwe + "\n" +
            " Both6M_indMotherPwe: " + Both6M_indMotherPwe + "\n" +
            " Both6M_indOtherVerification: " + Both6M_indOtherVerification + "\n" +
            " Both6M_indParentDisabled: " + Both6M_indParentDisabled + "\n" +
            " Both6M_indPeNotAcptEmpTrn: " + Both6M_indPeNotAcptEmpTrn + "\n" +
            " Both6M_indPeRecvUnemp: " + Both6M_indPeRecvUnemp + "\n" +
            " Both6M_indPeWrkEngEduTrn: " + Both6M_indPeWrkEngEduTrn + "\n" +
            " Both6M_indRecv100PctVa: " + Both6M_indRecv100PctVa + "\n" +
            " Both6M_indRecvRrRsdi: " + Both6M_indRecvRrRsdi + "\n" +
            " Both6M_indRsdiVerification: " + Both6M_indRsdiVerification + "\n" +
            " Both6M_indSsiVerification: " + Both6M_indSsiVerification + "\n" +
            " Both_amtPweIncome: " + Both_amtPweIncome + "\n" +
            " Both_cdPweIrregularUnder100: " + Both_cdPweIrregularUnder100 + "\n" +
            " Both_cdPweSteadyUnder100: " + Both_cdPweSteadyUnder100 + "\n" +
            " Both_cdVerifMethod: " + Both_cdVerifMethod + "\n" +
            " Both_cdVerifDocType: " + Both_cdVerifDocType + "\n" +
            " Both_idPrnEarner: " + Both_idPrnEarner + "\n" +
            " Both_indFatherPwe: " + Both_indFatherPwe + "\n" +
            " Both_indMotherPwe: " + Both_indMotherPwe + "\n" +
            " Both_indOtherVerification: " + Both_indOtherVerification + "\n" +
            " Both_indParentDisabled: " + Both_indParentDisabled + "\n" +
            " Both_indPeNotAcptEmpTrn: " + Both_indPeNotAcptEmpTrn + "\n" +
            " Both_indPeRecvUnemp: " + Both_indPeRecvUnemp + "\n" +
            " Both_indPeWrkEngEduTrn: " + Both_indPeWrkEngEduTrn + "\n" +
            " Both_indRecv100PctVa: " + Both_indRecv100PctVa + "\n" +
            " Both_indRecvRrRsdi: " + Both_indRecvRrRsdi + "\n" +
            " Both_indRsdiVerification: " + Both_indRsdiVerification + "\n" +
            " Both_indSsiVerification: " + Both_indSsiVerification + "\n" +
            " Nota_cdNotaMostRecent: " + Nota_cdNotaMostRecent + "\n" +
            " Nota_indChildLivingPrnt6Mnths: " + Nota_indChildLivingPrnt6Mnths + "\n" +
            " One6M_indAbsentAltrntCustody: " + One6M_indAbsentAltrntCustody + "\n" +
            " One6M_indAbsentDeported: " + One6M_indAbsentDeported + "\n" +
            " One6M_indAbsentDeserted: " + One6M_indAbsentDeserted + "\n" +
            " One6M_indAbsentDied: " + One6M_indAbsentDied + "\n" +
            " One6M_indAbsentDivorced: " + One6M_indAbsentDivorced + "\n" +
            " One6M_indAbsentFather: " + One6M_indAbsentFather + "\n" +
            " One6M_indAbsentHospitalized: " + One6M_indAbsentHospitalized + "\n" +
            " One6M_indAbsentIncarcerated: " + One6M_indAbsentIncarcerated + "\n" +
            " One6M_indAbsentMilitaryWork: " + One6M_indAbsentMilitaryWork + "\n" +
            " One6M_indAbsentMother: " + One6M_indAbsentMother + "\n" +
            " One6M_indAbsentSeparated: " + One6M_indAbsentSeparated + "\n" +
            " One6M_indAbsentWorkRelated: " + One6M_indAbsentWorkRelated + "\n" +
            " One_indAbsentAltrntCustody: " + One_indAbsentAltrntCustody + "\n" +
            " One_indAbsentDeported: " + One_indAbsentDeported + "\n" +
            " One_indAbsentDeserted: " + One_indAbsentDeserted + "\n" +
            " One_indAbsentDied: " + One_indAbsentDied + "\n" +
            " One_indAbsentDivorced: " + One_indAbsentDivorced + "\n" +
            " One_indAbsentFather: " + One_indAbsentFather + "\n" +
            " One_indAbsentHospitalized: " + One_indAbsentHospitalized + "\n" +
            " One_indAbsentIncarcerated: " + One_indAbsentIncarcerated + "\n" +
            " One_indAbsentMilitaryWork: " + One_indAbsentMilitaryWork + "\n" +
            " One_indAbsentMother: " + One_indAbsentMother + "\n" +
            " One_indAbsentSeparated: " + One_indAbsentSeparated + "\n" +
            " One_indAbsentWorkRelated: " + One_indAbsentWorkRelated + "\n" +
            " Other6M_indSpecifiedRelative: " + Other6M_indSpecifiedRelative + "\n" +
            " Other_idMngngCvsPerson: " + Other_idMngngCvsPerson + "\n" +
            " Other_idOtherRelativePerson: " + Other_idOtherRelativePerson + "\n" +
            " Other_indSpecifiedRelative: " + Other_indSpecifiedRelative + "\n" +
            " cdEventStatus: " + cdEventStatus + "\n" +
            " indAbsentNeverCohabitated: " + indAbsentNeverCohabitated + "\n" +
            " One_indAbsentNeverCohabitated: " + One_indAbsentNeverCohabitated + "\n" +
            " One6M_indAbsentNeverCohabitated: " + One6M_indAbsentNeverCohabitated + "\n" +
            " nbrStepparentChildren: " + nbrStepparentChildren + "\n" +
            "END bean: DomicileDeprivation\n";
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
