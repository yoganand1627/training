//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class EligibilityDeterminationDB implements Serializable, FceApplicationPageDB {
  public static final String AMT_ALLOC_ALLOWANCE_MUTUAL = "amtAllocAllowanceMutual";
  public static final String AMT_ALLOC_ALLOWANCE_SNGL_1 = "amtAllocAllowanceSngl1";
  public static final String AMT_ALLOC_ALLOWANCE_SNGL_2 = "amtAllocAllowanceSngl2";
  public static final String AMT_COUNTABLE_INCOME_MONEY = "amtCountableIncomeMoney";
  public static final String AMT_COUNTABLE_INCOME = "amtCountableIncome";
  public static final String AMT_CHSUP_CHILD = "amtChsupChild";
  public static final String AMT_CHSUP_CRTFD_GRP = "amtChsupCrtfdGrp";
  public static final String AMT_CNT_INCOME_ELIG_CHILD = "amtCntIncomeEligChild";
  public static final String AMT_CNT_INCOME_ELIG_CRTFD_GRP = "amtCntIncomeEligCrtfdGrp";
  public static final String AMT_CNTBL_INCOME = "amtCntblIncome";
  public static final String AMT_CNTBL_INCOME_30 = "amtCntblIncome30";
  public static final String AMT_CNTBL_INCOME_LESS_30 = "amtCntblIncomeLess30";
  public static final String AMT_CNTBL_INCOME_LESS_THIRD = "amtCntblIncomeLessThird";
  public static final String AMT_CNTBL_INCOME_THIRD = "amtCntblIncomeThird";
  public static final String AMT_GROSS_EARNED_INCOME = "amtGrossEarnedIncome";
  public static final String AMT_GROSS_UNEARNED_INCOME = "amtGrossUnearnedIncome";
  public static final String AMT_STD_EARNED_INCOME_DEDUCT = "amtStdEarnedIncomeDeduct";
  public static final String AMT_DEEM_ALIMONY_OUTSIDE_HH = "amtDeemAlimonyOutsideHh";
  public static final String AMT_DEEM_CNT_NET_INCOME = "amtDeemCntNetIncome";
  public static final String AMT_DEEM_GROSS_EARNED_INCOME = "amtDeemGrossEarnedIncome";
  public static final String AMT_DEEM_LESS_STD_OF_NEED = "amtDeemLessStdOfNeed";
  public static final String AMT_DEEM_NET_EARNED_INCOME = "amtDeemNetEarnedIncome";
  public static final String AMT_DEEM_STD_EARNED_INC_DEDUCT = "amtDeemStdEarnedIncDeduct";
  public static final String AMT_DEEM_STD_OF_NEED = "amtDeemStdOfNeed";
  public static final String AMT_DEEM_SURPLUS_OR_DEFICIT = "amtDeemSurplusOrDeficit";
  public static final String AMT_DEEM_TAX_DEPEND_OUT_HH = "amtDeemTaxDependOutHh";
  public static final String AMT_DEEM_TOTAL = "amtDeemTotal";
  public static final String AMT_DEEM_UNEARNED_INCOME = "amtDeemUnearnedIncome";
  public static final String AMT_EARNED_LESS_ALL_DEDUCT = "amtEarnedLessAllDeduct";
  public static final String AMT_EARNED_LESS_STD_DEDUCT = "amtEarnedLessStdDeduct";
  public static final String AMT_GIC_SURP_DEFCT_CHILD = "amtGicSurpDefctChild";
  public static final String AMT_GIC_SURP_DEFCT_CRTFD_GRP = "amtGicSurpDefctCrtfdGrp";
  public static final String AMT_GROSS_EARNED_CRTFD_GRP_MONEY = "amtGrossEarnedCrtfdGrpMoney";
  public static final String AMT_GROSS_EARNED_CRTFD_GRP = "amtGrossEarnedCrtfdGrp";
  public static final String AMT_GROSS_INCOME_ALLOC_MUTUAL = "amtGrossIncomeAllocMutual";
  public static final String AMT_GROSS_INCOME_ALLOC_SNGL_1 = "amtGrossIncomeAllocSngl1";
  public static final String AMT_GROSS_INCOME_ALLOC_SNGL_2 = "amtGrossIncomeAllocSngl2";
  public static final String AMT_GROSS_INCOME_CRTFD_GRP = "amtGrossIncomeCrtfdGrp";
  public static final String AMT_GROSS_INCOME_CHILD = "amtGrossIncomeChild";
  public static final String AMT_LESS_ALLOC_ELIG = "amtLessAllocElig";
  public static final String AMT_LESS_ALLOC_STD_NEED = "amtLessAllocStdNeed";
  public static final String AMT_LESS_DEP_CARE_ELIG = "amtLessDepCareElig";
  public static final String AMT_LESS_DEP_CARE_STD_NEED = "amtLessDepCareStdNeed";
  public static final String AMT_NET_EARNED_INCOME = "amtNetEarnedIncome";
  public static final String AMT_NET_EARNED_INCOME_CHILD = "amtNetEarnedIncomeChild";
  public static final String AMT_NONEXMPT_RSRC_CRTFD_GRP = "amtNonexmptRsrcCrtfdGrp";
  public static final String AMT_PLUS_CHSUP_CHILD = "amtPlusChsupChild";
  public static final String AMT_PLUS_CHSUP_CRTFD_GRP = "amtPlusChsupCrtfdGrp";
  public static final String AMT_PLUS_DEEMED_ELIG = "amtPlusDeemedElig";
  public static final String AMT_PLUS_DEEMED_STD_NEED = "amtPlusDeemedStdNeed";
  public static final String AMT_PLUS_UNEARNED_ELIG = "amtPlusUnearnedElig";
  public static final String AMT_PLUS_UNEARNED_STD_NEED = "amtPlusUnearnedStdNeed";
  public static final String AMT_RESOURCE_LIMIT_CHILD = "amtResourceLimitChild";
  public static final String AMT_RESOURCE_LIMIT_CRTFD_GRP = "amtResourceLimitCrtfdGrp";
  public static final String AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY = "amtGrossUnearnedCrtfdGrpMoney";
  public static final String AMT_GROSS_UNEARNED_CRTFD_GRP = "amtGrossUnearnedCrtfdGrp";
  public static final String AMT_INCOME_LIMIT_MONEY = "amtIncomeLimitMoney";
  public static final String AMT_INCOME_LIMIT = "amtIncomeLimit";
  public static final String AMT_PWE_INCOME_MONEY = "amtPweIncomeMoney";
  public static final String AMT_PWE_INCOME = "amtPweIncome";
  public static final String AMT_SSI_MONEY = "amtSsiMoney";
  public static final String AMT_SSI = "amtSsi";
  public static final String AMT_STD_OF_NEED_ALLOC_MUTUAL = "amtStdOfNeedAllocMutual";
  public static final String AMT_STD_OF_NEED_ALLOC_SNGL_1 = "amtStdOfNeedAllocSngl1";
  public static final String AMT_STD_OF_NEED_ALLOC_SNGL_2 = "amtStdOfNeedAllocSngl2";
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
  public static final String AMT_SURP_DEFCT_ELIG_CHILD = "amtSurpDefctEligChild";
  public static final String AMT_SURP_DEFCT_ELIG_CRTFD_GRP = "amtSurpDefctEligCrtfdGrp";
  public static final String AMT_SURP_DEFCT_STD_NEED = "amtSurpDefctStdNeed";
  public static final String AU_MEMBERS = "aUMembers";
  public static final String CD_BLOC_CHILD = "cdBlocChild";
  public static final String CD_DEEM_INDIV_REL_1 = "cdDeemIndivRel1";
  public static final String CD_DEEM_INDIV_REL_2 = "cdDeemIndivRel2";
  public static final String CD_DEEM_RESP_TYPE = "cdDeemRespType";
  public static final String CD_DEEM_SURPLUS_OR_DEFICIT = "cdDeemSurplusOrDeficit";
  public static final String CD_ELIGIBILITY_ACTUAL = "cdEligibilityActual";
  public static final String CD_ELIGIBILITY_SELECTED = "cdEligibilitySelected";
  public static final String CD_ELIG_SURP_DEFCT_CHILD = "cdEligSurpDefctChild";
  public static final String CD_ELIG_SURP_DEFCT_CRTFD_GRP = "cdEligSurpDefctCrtfdGrp";
  public static final String CD_GIC_SURP_DEFCT_CHILD = "cdGicSurpDefctChild";
  public static final String CD_GIC_SURP_DEFCT_CRTFD_GRP = "cdGicSurpDefctCrtfdGrp";
  public static final String CD_MEDICAID_ELIGIBILITY_TYPE = "cdMedicaidEligibilityType";
  public static final String FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP = "fceEligibilityCdPersonCitizenship";
  public static final String CD_PWE_IRREGULAR_UNDER100 = "cdPweIrregularUnder100";
  public static final String CD_PWE_STEADY_UNDER100 = "cdPweSteadyUnder100";
  public static final String CD_REL_INT = "cdRelInt";
  public static final String CD_STD_TEST_SURP_DEFCT = "cdStdTestSurpDefct";
  public static final String CD_VERIF_METHOD = "cdVerifMethod";
  public static final String CD_VERIF_DOC_TYPE = "cdVerifDocType";
  public static final String DT_BIRTH_STRING = "dtBirthString";
  public static final String DT_BIRTH_TIME = "dtBirthTime";
  public static final String FCE_PERSON_DT_LAST_UPDATE_STRING = "fcePersonDtLastUpdateString";
  public static final String FCE_PERSON_DT_LAST_UPDATE_TIME = "fcePersonDtLastUpdateTime";
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
  public static final String ID_CASE = "idCase";
  public static final String ID_ELIGIBILITY_EVENT = "idEligibilityEvent";
  public static final String ID_FCE_APPLICATION = "idFceApplication";
  public static final String ID_FCE_ELIGIBILITY = "idFceEligibility";
  public static final String ID_FCE_PERSON = "idFcePerson";
  public static final String ID_FCE_REVIEW = "idFceReview";
  public static final String ID_LAST_UPDATE_PERSON = "idLastUpdatePerson";
  public static final String ID_PERSON = "idPerson";
  public static final String ID_PERSON_ALLOC_MUTUAL_1 = "idPersonAllocMutual1";
  public static final String ID_PERSON_ALLOC_MUTUAL_2 = "idPersonAllocMutual2";
  public static final String ID_PERSON_ALLOC_SNGL_1 = "idPersonAllocSngl1";
  public static final String ID_PERSON_ALLOC_SNGL_2 = "idPersonAllocSngl2";
  public static final String ID_PERSON_DEEM_INDIV_1 = "idPersonDeemIndiv1";
  public static final String ID_PERSON_DEEM_INDIV_2 = "idPersonDeemIndiv2";
  public static final String ID_PRN_EARNER = "idPrnEarner";
  public static final String ID_STAGE = "idStage";
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
  public static final String IND_CERTIFIED_GROUP = "indCertifiedGroup";
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
  public static final String IND_DOB_APPROX = "indDobApprox";
  public static final String IND_ELIGIBILITY_COURT_MONTH = "indEligibilityCourtMonth";
  public static final String IND_ELIGIBLE = "indEligible";
  public static final String IND_EQUITY = "indEquity";
  public static final String IND_CHILD_EQUITY = "indChildEquity";
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
  public static final String IND_PERSON_HM_REMOVAL = "indPersonHmRemoval";
  public static final String IND_PRS_MANAGING_CVS = "indPrsManagingCvs";
  public static final String IND_RECV_100_PCT_VA = "indRecv100PctVa";
  public static final String IND_RECV_RR_RSDI = "indRecvRrRsdi";
  public static final String IND_REMOVAL_CHILD_ORDERED = "indRemovalChildOrdered";
  public static final String IND_RSDI_VERIFICATION = "indRsdiVerification";
  public static final String IND_RSNBL_EFFORT_PRVT_REMOVAL = "indRsnblEffortPrvtRemoval";
  public static final String IND_SSI_VERIFICATION = "indSsiVerification";
  public static final String NBR_AGE = "nbrAge";
  public static final String NBR_CERTIFIED_GROUP = "nbrCertifiedGroup";
  public static final String NBR_DEEM_CHILD_NOT_IN_AU = "nbrDeemChildNotInAU";
  public static final String NBR_DEEM_RESPONSE_INDIV = "nbrDeemResponseIndiv";
  public static final String NBR_DEEM_PERSON_SON_LOOKUP = "nbrDeemPersonSONLookup";
  public static final String NBR_DEEM_TAX_DEPEND_NOT_IN_AU = "nbrDeemTaxDependNotInAU";
  public static final String NBR_INELIG_CHILD_ALLOC_MUTUAL = "nbrIneligChildAllocMutual";
  public static final String NBR_INELIG_CHILD_ALLOC_SNGL_1 = "nbrIneligChildAllocSngl1";
  public static final String NBR_INELIG_CHILD_ALLOC_SNGL_2 = "nbrIneligChildAllocSngl2";
  public static final String NBR_INELIG_PERSON_ALLOC_MUTUAL = "nbrIneligPersonAllocMutual";
  public static final String NBR_INELIG_PERSON_ALLOC_SNGL_1 = "nbrIneligPersonAllocSngl1";
  public static final String NBR_INELIG_PERSON_ALLOC_SNGL_2 = "nbrIneligPersonAllocSngl2";
  public static final String NBR_INELIG_SPOUSE_ALLOC_MUTUAL = "nbrIneligSpouseAllocMutual";
  public static final String NBR_INELIG_SPOUSE_ALLOC_SNGL_1 = "nbrIneligSpouseAllocSngl1";
  public static final String NBR_INELIG_SPOUSE_ALLOC_SNGL_2 = "nbrIneligSpouseAllocSngl2";
  public static final String NBR_PARENTS_HOME = "nbrParentsHome";
  public static final String NON_AU_MEMBERS = "nonAUMembers";
  public static final String PRINCIPALS = "principals";
  public static final String TXT_DETERMINATION_COMMENTS = "txtDeterminationComments";
  public static final String TXT_MONTHS_DEP_UNEMP = "txtMonthsDepUnemp";
  public static final String ID_EVENT = "idEvent";
  public static final String CD_EVENT_STATUS = "cdEventStatus";
  public static final String REASONS_NOT_ELIGIBLE = "reasonsNotEligible";
  public static final String AMT_GROSS_INCOME_CEILING = "amtGrossIncomeCeiling";
  public static final String AMT_STANDARD_OF_NEED = "amtStandardOfNeed";
  public static final String AMT_DEPENDENT_CARE_DEDUC = "amtDependentCareDeduc";
  public static final String AMT_ALLOC_ALLOWANCE = "amtAllocAllowance";
  public static final String AMT_COUNTABLE_INCOME_STD_NEED = "amtCountableIncomeStdNeed";
  public static final String AMT_COUNTABLE_INCOME_30_ONE_THIRD = "amtCountableIncome30OneThird";
  public static final String AMT_CNTBL_RESOURCE_CHILD = "amtCtnblResourceChild";
  public static final String AMT_GROSS_EARNED_CHILD = "amtGrossEarnedChild";
  public static final String AMT_GROSS_UNEARNED_CHILD = "amtGrossUnEarnedChild";
  public static final String AMT_TOTAL_GROSS_INCOME_CHILD = "amtTotalGrossIncomeChild";
  public static final String AMT_CNTBL_INC_STD_NEED_CHILD = "amtCntblIncStdNeedChild";
  public static final String AMT_CNTBL_INC_30_1_3_CHILD = "amtCntblInc30OneThirdChild";
  public static final String IND_CTNBL_RES_CHILD_ELGBLTY = "indCtnblResChildElgblty";
  public static final String IND_GROSS_INC_CHILD_ELGBLTY = "indGrossIncChildElgblty";
  public static final String IND_STD_OF_NEED_CHILD_TEST_ELGBLTY = "indStdOfNeedChildTestElgblty";
  public static final String IND_30_1_3_CHILD_TEST_ELGBLTY = "ind30OneThirdChildTestElgblty";
  public static final String IND_GROSS_INC_CEILING_ELGBLTY = "indGrossIncCeilingElgblty";
  public static final String AMT_DEP_CARE_DEDUC_CHILD = "amtDepCareDeducChild";
  public static final String AMT_GROSS_INCOME_CEILING_CHILD = "amtGrossIncomeCeilingChild";
  public static final String AMT_STD_OF_NEED_CHILD = "amtStdOfNeedChild";
  public static final String IND_CHILD_RECEIVING_SSI = "indChildReceivingSSI";
  public static final String AMT_CSUP_WITH_UNEARNED_INCOME = "amtCsupWithUnearnedIncome";
  
  protected boolean hasAmtAllocAllowanceMutual = false;
  protected Double amtAllocAllowanceMutual = null;
  protected boolean hasAmtAllocAllowanceSngl1 = false;
  protected Double amtAllocAllowanceSngl1 = null;
  protected boolean hasAmtAllocAllowanceSngl2 = false;
  protected Double amtAllocAllowanceSngl2 = null;
  protected boolean hasAmtCountableIncome = false;
  protected Double amtCountableIncome = null;
  protected boolean hasAmtChsupChild = false;
  protected Double amtChsupChild = null;
  protected boolean hasAmtChsupCrtfdGrp = false;
  protected Double amtChsupCrtfdGrp = null;
  protected boolean hasAmtCntIncomeEligChild = false;
  protected Double amtCntIncomeEligChild = null;
  protected boolean hasAmtCntIncomeEligCrtfdGrp = false;
  protected Double amtCntIncomeEligCrtfdGrp = null;
  protected boolean hasAmtCntblIncome = false;
  protected Double amtCntblIncome = null;
  protected boolean hasAmtCntblIncome30 = false;
  protected Double amtCntblIncome30 = null;
  protected boolean hasAmtCntblIncomeLess30 = false;
  protected Double amtCntblIncomeLess30 = null;
  protected boolean hasAmtCntblIncomeLessThird = false;
  protected Double amtCntblIncomeLessThird = null;
  protected boolean hasAmtCntblIncomeThird = false;
  protected Double amtCntblIncomeThird = null;
  protected boolean hasAmtGrossEarnedIncome = false;
  protected Double amtGrossEarnedIncome = null;
  protected boolean hasAmtGrossUnearnedIncome = false;
  protected Double amtGrossUnearnedIncome = null;
  protected boolean hasAmtStdEarnedIncomeDeduct = false;
  protected Double amtStdEarnedIncomeDeduct = null;
  protected boolean hasAmtDeemAlimonyOutsideHh = false;
  protected Double amtDeemAlimonyOutsideHh = null;
  protected boolean hasAmtDeemCntNetIncome = false;
  protected Double amtDeemCntNetIncome = null;
  protected boolean hasAmtDeemGrossEarnedIncome = false;
  protected Double amtDeemGrossEarnedIncome = null;
  protected boolean hasAmtDeemLessStdOfNeed = false;
  protected Double amtDeemLessStdOfNeed = null;
  protected boolean hasAmtDeemNetEarnedIncome = false;
  protected Double amtDeemNetEarnedIncome = null;
  protected boolean hasAmtDeemStdEarnedIncDeduct = false;
  protected Double amtDeemStdEarnedIncDeduct = null;
  protected boolean hasAmtDeemStdOfNeed = false;
  protected Double amtDeemStdOfNeed = null;
  protected boolean hasAmtDeemSurplusOrDeficit = false;
  protected Double amtDeemSurplusOrDeficit = null;
  protected boolean hasAmtDeemTaxDependOutHh = false;
  protected Double amtDeemTaxDependOutHh = null;
  protected boolean hasAmtDeemTotal = false;
  protected Double amtDeemTotal = null;
  protected boolean hasAmtDeemUnearnedIncome = false;
  protected Double amtDeemUnearnedIncome = null;
  protected boolean hasAmtEarnedLessAllDeduct = false;
  protected Double amtEarnedLessAllDeduct = null;
  protected boolean hasAmtEarnedLessStdDeduct = false;
  protected Double amtEarnedLessStdDeduct = null;
  protected boolean hasAmtGicSurpDefctChild = false;
  protected Double amtGicSurpDefctChild = null;
  protected boolean hasAmtGicSurpDefctCrtfdGrp = false;
  protected Double amtGicSurpDefctCrtfdGrp = null;
  protected boolean hasAmtGrossEarnedCrtfdGrp = false;
  protected Double amtGrossEarnedCrtfdGrp = null;
  protected boolean hasAmtGrossIncomeAllocMutual = false;
  protected Double amtGrossIncomeAllocMutual = null;
  protected boolean hasAmtGrossIncomeAllocSngl1 = false;
  protected Double amtGrossIncomeAllocSngl1 = null;
  protected boolean hasAmtGrossIncomeAllocSngl2 = false;
  protected Double amtGrossIncomeAllocSngl2 = null;
  protected boolean hasAmtGrossIncomeCrtfdGrp = false;
  protected Double amtGrossIncomeCrtfdGrp = null;
  protected boolean hasAmtGrossIncomeChild = false;
  protected Double amtGrossIncomeChild = null;
  protected boolean hasAmtLessAllocElig = false;
  protected Double amtLessAllocElig = null;
  protected boolean hasAmtLessAllocStdNeed = false;
  protected Double amtLessAllocStdNeed = null;
  protected boolean hasAmtLessDepCareElig = false;
  protected Double amtLessDepCareElig = null;
  protected boolean hasAmtLessDepCareStdNeed = false;
  protected Double amtLessDepCareStdNeed = null;
  protected boolean hasAmtNetEarnedIncome = false;
  protected Double amtNetEarnedIncome = null;
  protected boolean hasAmtNetEarnedIncomeChild = false;
  protected Double amtNetEarnedIncomeChild = null;
  protected boolean hasAmtNonexmptRsrcCrtfdGrp = false;
  protected Double amtNonexmptRsrcCrtfdGrp = null;
  protected boolean hasAmtPlusChsupChild = false;
  protected Double amtPlusChsupChild = null;
  protected boolean hasAmtPlusChsupCrtfdGrp = false;
  protected Double amtPlusChsupCrtfdGrp = null;
  protected boolean hasAmtPlusDeemedElig = false;
  protected Double amtPlusDeemedElig = null;
  protected boolean hasAmtPlusDeemedStdNeed = false;
  protected Double amtPlusDeemedStdNeed = null;
  protected boolean hasAmtPlusUnearnedElig = false;
  protected Double amtPlusUnearnedElig = null;
  protected boolean hasAmtPlusUnearnedStdNeed = false;
  protected Double amtPlusUnearnedStdNeed = null;
  protected boolean hasAmtResourceLimitChild = false;
  protected Double amtResourceLimitChild = null;
  protected boolean hasAmtResourceLimitCrtfdGrp = false;
  protected Double amtResourceLimitCrtfdGrp = null;
  protected boolean hasAmtGrossUnearnedCrtfdGrp = false;
  protected Double amtGrossUnearnedCrtfdGrp = null;
  protected boolean hasAmtIncomeLimit = false;
  protected Double amtIncomeLimit = null;
  protected boolean hasAmtPweIncome = false;
  protected Double amtPweIncome = null;
  protected boolean hasAmtSsi = false;
  protected Double amtSsi = null;
  protected boolean hasAmtStdOfNeedAllocMutual = false;
  protected Double amtStdOfNeedAllocMutual = null;
  protected boolean hasAmtStdOfNeedAllocSngl1 = false;
  protected Double amtStdOfNeedAllocSngl1 = null;
  protected boolean hasAmtStdOfNeedAllocSngl2 = false;
  protected Double amtStdOfNeedAllocSngl2 = null;
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
  protected boolean hasAmtSurpDefctEligChild = false;
  protected Double amtSurpDefctEligChild = null;
  protected boolean hasAmtSurpDefctEligCrtfdGrp = false;
  protected Double amtSurpDefctEligCrtfdGrp = null;
  protected boolean hasAmtSurpDefctStdNeed = false;
  protected Double amtSurpDefctStdNeed = null;
  protected boolean hasAUMembers = false;
  protected List<FcePersonDB> aUMembers = null;
  protected boolean hasCdAllocType = false;
  protected String cdAllocType = null;
  protected boolean hasCdBlocChild = false;
  protected String cdBlocChild = null;
  protected boolean hasCdDeemIndivRel1 = false;
  protected String cdDeemIndivRel1 = null;
  protected boolean hasCdDeemIndivRel2 = false;
  protected String cdDeemIndivRel2 = null;
  protected boolean hasCdDeemSurplusOrDeficit = false;
  protected String cdDeemSurplusOrDeficit = null;
  protected boolean hasCdEligibilityActual = false;
  protected String cdEligibilityActual = null;
  protected boolean hasCdEligibilitySelected = false;
  protected String cdEligibilitySelected = null;
  protected boolean hasCdEligSurpDefctChild = false;
  protected String cdEligSurpDefctChild = null;
  protected boolean hasCdEligSurpDefctCrtfdGrp = false;
  protected String cdEligSurpDefctCrtfdGrp = null;
  protected boolean hasCdGicSurpDefctChild = false;
  protected String cdGicSurpDefctChild = null;
  protected boolean hasCdGicSurpDefctCrtfdGrp = false;
  protected String cdGicSurpDefctCrtfdGrp = null;
  protected boolean hasCdMedicaidEligibilityType = false;
  protected String cdMedicaidEligibilityType = null;
  protected boolean hasFceEligibilityCdPersonCitizenship = false;
  protected String fceEligibilityCdPersonCitizenship = null;
  protected boolean hasCdPweIrregularUnder100 = false;
  protected String cdPweIrregularUnder100 = null;
  protected boolean hasCdPweSteadyUnder100 = false;
  protected String cdPweSteadyUnder100 = null;
  protected boolean hasCdRelInt = false;
  protected String cdRelInt = null;
  protected boolean hasCdStdTestSurpDefct = false;
  protected String cdStdTestSurpDefct = null;
  protected boolean hasCdVerifMethod = false;
  protected String cdVerifMethod = null;
  protected boolean hasCdVerifDocType = false;
  protected String cdVerifDocType = null;
  protected boolean hasDtBirth = false;
  protected Date dtBirth = null;
  protected boolean hasFcePersonDtLastUpdate = false;
  protected Date fcePersonDtLastUpdate = null;
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
  protected boolean hasIdCase = false;
  protected Long idCase = null;
  protected boolean hasIdEligibilityEvent = false;
  protected Long idEligibilityEvent = null;
  protected boolean hasIdFceApplication = false;
  protected Long idFceApplication = null;
  protected boolean hasIdFceEligibility = false;
  protected Long idFceEligibility = null;
  protected boolean hasIdFcePerson = false;
  protected Long idFcePerson = null;
  protected boolean hasIdFceReview = false;
  protected Long idFceReview = null;
  protected boolean hasIdLastUpdatePerson = false;
  protected Long idLastUpdatePerson = null;
  protected boolean hasIdPerson = false;
  protected Long idPerson = null;
  protected boolean hasIdPersonAllocMutual1 = false;
  protected Long idPersonAllocMutual1 = null;
  protected boolean hasIdPersonAllocMutual2 = false;
  protected Long idPersonAllocMutual2 = null;
  protected boolean hasIdPersonAllocSngl1 = false;
  protected Long idPersonAllocSngl1 = null;
  protected boolean hasIdPersonAllocSngl2 = false;
  protected Long idPersonAllocSngl2 = null;
  protected boolean hasIdPersonDeemIndiv1 = false;
  protected Long idPersonDeemIndiv1 = null;
  protected boolean hasIdPersonDeemIndiv2 = false;
  protected Long idPersonDeemIndiv2 = null;
  protected boolean hasIdPrnEarner = false;
  protected Long idPrnEarner = null;
  protected boolean hasIdStage = false;
  protected Long idStage = null;
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
  protected boolean hasIndCertifiedGroup = false;
  protected Boolean indCertifiedGroup = null;
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
  protected boolean hasCdDeemRespType = false;
  protected String cdDeemRespType = null;
  protected boolean hasIndDobApprox = false;
  protected Boolean indDobApprox = null;
  protected boolean hasIndEligibilityCourtMonth = false;
  protected Boolean indEligibilityCourtMonth = null;
  protected boolean hasIndEligible = false;
  protected Boolean indEligible = null;
  protected boolean hasIndEquity = false;
  protected Boolean indEquity = null;
  protected boolean hasIndChildEquity = false;
  protected Boolean indChildEquity = null;
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
  protected boolean hasIndPersonHmRemoval = false;
  protected Boolean indPersonHmRemoval = null;
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
  protected boolean hasNbrAge = false;
  protected Long nbrAge = null;
  protected boolean hasNbrCertifiedGroup = false;
  protected Long nbrCertifiedGroup = null;
  protected boolean hasNbrDeemChildNotInAU = false;
  protected Long nbrDeemChildNotInAU = null;
  protected boolean hasNbrDeemResponseIndiv = false;
  protected Long nbrDeemResponseIndiv = null;
  protected boolean hasNbrDeemPersonSONLookup = false;
  protected Long nbrDeemPersonSONLookup = null;
  protected boolean hasNbrDeemTaxDependNotInAU = false;
  protected Long nbrDeemTaxDependNotInAU = null;
  protected boolean hasNbrIneligChildAllocMutual = false;
  protected Long nbrIneligChildAllocMutual = null;
  protected boolean hasNbrIneligChildAllocSngl1 = false;
  protected Long nbrIneligChildAllocSngl1 = null;
  protected boolean hasNbrIneligChildAllocSngl2 = false;
  protected Long nbrIneligChildAllocSngl2 = null;
  protected boolean hasNbrIneligPersonAllocMutual = false;
  protected Long nbrIneligPersonAllocMutual = null;
  protected boolean hasNbrIneligPersonAllocSngl1 = false;
  protected Long nbrIneligPersonAllocSngl1 = null;
  protected boolean hasNbrIneligPersonAllocSngl2 = false;
  protected Long nbrIneligPersonAllocSngl2 = null;
  protected boolean hasNbrIneligSpouseAllocMutual = false;
  protected Long nbrIneligSpouseAllocMutual = null;
  protected boolean hasNbrIneligSpouseAllocSngl1 = false;
  protected Long nbrIneligSpouseAllocSngl1 = null;
  protected boolean hasNbrIneligSpouseAllocSngl2 = false;
  protected Long nbrIneligSpouseAllocSngl2 = null;
  protected boolean hasNbrParentsHome = false;
  protected Long nbrParentsHome = null;
  protected boolean hasNonAUMembers = false;
  protected List<FcePersonDB> nonAUMembers = null;
  protected boolean hasPrincipals = false;
  protected List<FcePersonDB> principals = null;
  protected boolean hasTxtDeterminationComments = false;
  protected String txtDeterminationComments = null;
  protected boolean hasTxtMonthsDepUnemp = false;
  protected String txtMonthsDepUnemp = null;
  protected boolean hasIdEvent = false;
  protected Long idEvent = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;
  protected boolean hasReasonsNotEligible = false;
  protected List reasonsNotEligible = null;
  protected boolean hasAmtGrossIncomeCeiling = false;
  protected Double amtGrossIncomeCeiling = null;
  protected boolean hasAmtStandardOfNeed = false;
  protected Double amtStandardOfNeed = null;
  protected boolean hasAmtDependentCareDeduc = false;
  protected Double amtDependentCareDeduc = null;
  protected boolean hasAmtAllocAllowance = false;
  protected Double amtAllocAllowance = null;
  protected boolean hasAmtCountableIncomeStdNeed = false;
  protected Double amtCountableIncomeStdNeed = null;
  protected boolean hasAmtCountableIncome30OneThird = false;
  protected Double amtCountableIncome30OneThird = null;
  protected boolean hasAmtCtnblResourceChild = false;
  protected Double amtCtnblResourceChild = null;
  protected boolean hasAmtGrossEarnedChild = false;
  protected Double amtGrossEarnedChild = null;
  protected boolean hasAmtGrossUnEarnedChild = false;
  protected Double amtGrossUnEarnedChild = null;
  protected boolean hasAmtTotalGrossIncomeChild = false;
  protected Double amtTotalGrossIncomeChild = null;
  protected boolean hasAmtCntblIncStdNeedChild = false;
  protected Double amtCntblIncStdNeedChild = null;
  protected boolean hasAmtCntblInc30OneThirdChild = false;
  protected Double amtCntblInc30OneThirdChild = null;
  protected boolean hasIndCtnblResChildElgblty = false;
  protected Boolean indCtnblResChildElgblty = null;
  protected boolean hasIndGrossIncChildElgblty = false;
  protected Boolean indGrossIncChildElgblty = null;
  protected boolean hasIndStdOfNeedChildTestElgblty = false;
  protected Boolean indStdOfNeedChildTestElgblty = null;
  protected boolean hasInd30OneThirdChildTestElgblty = false;
  protected Boolean ind30OneThirdChildTestElgblty = null;
  protected boolean hasIndGrossIncCeilingElgblty = false;
  protected Boolean indGrossIncCeilingElgblty = null;
  protected boolean hasAmtDepCareDeducChild = false;
  protected Double amtDepCareDeducChild = null;
  protected boolean hasAmtGrossIncomeCeilingChild = false;
  protected Double amtGrossIncomeCeilingChild = null;
  protected boolean hasAmtStdOfNeedChild = false;
  protected Double amtStdOfNeedChild = null;
  protected boolean hasIndChildReceivingSSI = false;
  protected Boolean indChildReceivingSSI = null;
  protected Double amtCsupWithUnearnedIncome = null;
  protected boolean hasAmtCsupWithUnearnedIncome = false;

  
  public boolean hasAmtAllocAllowanceMutual() {
    return hasAmtAllocAllowanceMutual;
  }

  public double getAmtAllocAllowanceMutual() {
    if (amtAllocAllowanceMutual == null) {
      return (double) 0;
    }
    return amtAllocAllowanceMutual.doubleValue();
  }

  public Double getAmtAllocAllowanceMutualObject() {
    return amtAllocAllowanceMutual;
  }

  public String getAmtAllocAllowanceMutualString() {
    return FormattingHelper.formatDouble(amtAllocAllowanceMutual);
  }

  public void setAmtAllocAllowanceMutual(double amtAllocAllowanceMutual) {
    this.hasAmtAllocAllowanceMutual = true;
    this.amtAllocAllowanceMutual = new Double(amtAllocAllowanceMutual);
  }

  public void setAmtAllocAllowanceMutual(Double amtAllocAllowanceMutual) {
    this.hasAmtAllocAllowanceMutual = true;
    this.amtAllocAllowanceMutual = amtAllocAllowanceMutual;
  }

  public void setAmtAllocAllowanceMutual(Number amtAllocAllowanceMutual) {
    this.hasAmtAllocAllowanceMutual = true;
    this.amtAllocAllowanceMutual = null;
    if (amtAllocAllowanceMutual != null) {
      setAmtAllocAllowanceMutual(amtAllocAllowanceMutual.doubleValue());
    }
  }
  
  public boolean hasAmtAllocAllowanceSngl1() {
    return hasAmtAllocAllowanceSngl1;
  }

  public double getAmtAllocAllowanceSngl1() {
    if (amtAllocAllowanceSngl1 == null) {
      return (double) 0;
    }
    return amtAllocAllowanceSngl1.doubleValue();
  }

  public Double getAmtAllocAllowanceSngl1Object() {
    return amtAllocAllowanceSngl1;
  }

  public String getAmtAllocAllowanceSngl1String() {
    return FormattingHelper.formatDouble(amtAllocAllowanceSngl1);
  }

  public void setAmtAllocAllowanceSngl1(double amtAllocAllowanceSngl1) {
    this.hasAmtAllocAllowanceSngl1 = true;
    this.amtAllocAllowanceSngl1 = new Double(amtAllocAllowanceSngl1);
  }

  public void setAmtAllocAllowanceSngl1(Double amtAllocAllowanceSngl1) {
    this.hasAmtAllocAllowanceSngl1 = true;
    this.amtAllocAllowanceSngl1 = amtAllocAllowanceSngl1;
  }

  public void setAmtAllocAllowanceSngl1(Number amtAllocAllowanceSngl1) {
    this.hasAmtAllocAllowanceSngl1 = true;
    this.amtAllocAllowanceSngl1 = null;
    if (amtAllocAllowanceSngl1 != null) {
      setAmtAllocAllowanceSngl1(amtAllocAllowanceSngl1.doubleValue());
    }
  }
  
  public boolean hasAmtAllocAllowanceSngl2() {
    return hasAmtAllocAllowanceSngl2;
  }

  public double getAmtAllocAllowanceSngl2() {
    if (amtAllocAllowanceSngl2 == null) {
      return (double) 0;
    }
    return amtAllocAllowanceSngl2.doubleValue();
  }

  public Double getAmtAllocAllowanceSngl2Object() {
    return amtAllocAllowanceSngl2;
  }

  public String getAmtAllocAllowanceSngl2String() {
    return FormattingHelper.formatDouble(amtAllocAllowanceSngl2);
  }

  public void setAmtAllocAllowanceSngl2(double amtAllocAllowanceSngl2) {
    this.hasAmtAllocAllowanceSngl2 = true;
    this.amtAllocAllowanceSngl2 = new Double(amtAllocAllowanceSngl2);
  }

  public void setAmtAllocAllowanceSngl2(Double amtAllocAllowanceSngl2) {
    this.hasAmtAllocAllowanceSngl2 = true;
    this.amtAllocAllowanceSngl2 = amtAllocAllowanceSngl2;
  }

  public void setAmtAllocAllowanceSngl2(Number amtAllocAllowanceSngl2) {
    this.hasAmtAllocAllowanceSngl2 = true;
    this.amtAllocAllowanceSngl2 = null;
    if (amtAllocAllowanceSngl2 != null) {
      setAmtAllocAllowanceSngl2(amtAllocAllowanceSngl2.doubleValue());
    }
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

  public boolean hasAmtChsupChild() {
    return hasAmtChsupChild;
  }

  public double getAmtChsupChild() {
    if (amtChsupChild == null) {
      return (double) 0;
    }
    return amtChsupChild.doubleValue();
  }

  public Double getAmtChsupChildObject() {
    return amtChsupChild;
  }

  public String getAmtChsupChildString() {
    return FormattingHelper.formatDouble(amtChsupChild);
  }

  public void setAmtChsupChild(double amtChsupChild) {
    this.hasAmtChsupChild = true;
    this.amtChsupChild = new Double(amtChsupChild);
  }

  public void setAmtChsupChild(Double amtChsupChild) {
    this.hasAmtChsupChild = true;
    this.amtChsupChild = amtChsupChild;
  }

  public void setAmtChsupChild(Number amtChsupChild) {
    this.hasAmtChsupChild = true;
    this.amtChsupChild = null;
    if (amtChsupChild != null) {
      setAmtChsupChild(amtChsupChild.doubleValue());
    }
  }
  
  public boolean hasAmtChsupCrtfdGrp() {
    return hasAmtChsupCrtfdGrp;
  }

  public double getAmtChsupCrtfdGrp() {
    if (amtChsupCrtfdGrp == null) {
      return (double) 0;
    }
    return amtChsupCrtfdGrp.doubleValue();
  }

  public Double getAmtChsupCrtfdGrpObject() {
    return amtChsupCrtfdGrp;
  }

  public String getAmtChsupCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtChsupCrtfdGrp);
  }

  public void setAmtChsupCrtfdGrp(double amtChsupCrtfdGrp) {
    this.hasAmtChsupCrtfdGrp = true;
    this.amtChsupCrtfdGrp = new Double(amtChsupCrtfdGrp);
  }

  public void setAmtChsupCrtfdGrp(Double amtChsupCrtfdGrp) {
    this.hasAmtChsupCrtfdGrp = true;
    this.amtChsupCrtfdGrp = amtChsupCrtfdGrp;
  }

  public void setAmtChsupCrtfdGrp(Number amtChsupCrtfdGrp) {
    this.hasAmtChsupCrtfdGrp = true;
    this.amtChsupCrtfdGrp = null;
    if (amtChsupCrtfdGrp != null) {
      setAmtChsupCrtfdGrp(amtChsupCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtCntIncomeEligChild() {
    return hasAmtCntIncomeEligChild;
  }

  public double getAmtCntIncomeEligChild() {
    if (amtCntIncomeEligChild == null) {
      return (double) 0;
    }
    return amtCntIncomeEligChild.doubleValue();
  }

  public Double getAmtCntIncomeEligChildObject() {
    return amtCntIncomeEligChild;
  }

  public String getAmtCntIncomeEligChildString() {
    return FormattingHelper.formatDouble(amtCntIncomeEligChild);
  }

  public void setAmtCntIncomeEligChild(double amtCntIncomeEligChild) {
    this.hasAmtCntIncomeEligChild = true;
    this.amtCntIncomeEligChild = new Double(amtCntIncomeEligChild);
  }

  public void setAmtCntIncomeEligChild(Double amtCntIncomeEligChild) {
    this.hasAmtCntIncomeEligChild = true;
    this.amtCntIncomeEligChild = amtCntIncomeEligChild;
  }

  public void setAmtCntIncomeEligChild(Number amtCntIncomeEligChild) {
    this.hasAmtCntIncomeEligChild = true;
    this.amtCntIncomeEligChild = null;
    if (amtCntIncomeEligChild != null) {
      setAmtCntIncomeEligChild(amtCntIncomeEligChild.doubleValue());
    }
  }

  public boolean hasAmtCntIncomeEligCrtfdGrp() {
    return hasAmtCntIncomeEligCrtfdGrp;
  }

  public double getAmtCntIncomeEligCrtfdGrp() {
    if (amtCntIncomeEligCrtfdGrp == null) {
      return (double) 0;
    }
    return amtCntIncomeEligCrtfdGrp.doubleValue();
  }

  public Double getAmtCntIncomeEligCrtfdGrpObject() {
    return amtCntIncomeEligCrtfdGrp;
  }

  public String getAmtCntIncomeEligCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtCntIncomeEligCrtfdGrp);
  }

  public void setAmtCntIncomeEligCrtfdGrp(double amtCntIncomeEligCrtfdGrp) {
    this.hasAmtCntIncomeEligCrtfdGrp = true;
    this.amtCntIncomeEligCrtfdGrp = new Double(amtCntIncomeEligCrtfdGrp);
  }

  public void setAmtCntIncomeEligCrtfdGrp(Double amtCntIncomeEligCrtfdGrp) {
    this.hasAmtCntIncomeEligCrtfdGrp = true;
    this.amtCntIncomeEligCrtfdGrp = amtCntIncomeEligCrtfdGrp;
  }

  public void setAmtCntIncomeEligCrtfdGrp(Number amtCntIncomeEligCrtfdGrp) {
    this.hasAmtCntIncomeEligCrtfdGrp = true;
    this.amtCntIncomeEligCrtfdGrp = null;
    if (amtCntIncomeEligCrtfdGrp != null) {
      setAmtCntIncomeEligCrtfdGrp(amtCntIncomeEligCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtCntblIncome() {
    return hasAmtCntblIncome;
  }

  public double getAmtCntblIncome() {
    if (amtCntblIncome == null) {
      return (double) 0;
    }
    return amtCntblIncome.doubleValue();
  }

  public Double getAmtCntblIncomeObject() {
    return amtCntblIncome;
  }

  public String getAmtCntblIncomeString() {
    return FormattingHelper.formatDouble(amtCntblIncome);
  }

  public void setAmtCntblIncome(double amtCntblIncome) {
    this.hasAmtCntblIncome = true;
    this.amtCntblIncome = new Double(amtCntblIncome);
  }

  public void setAmtCntblIncome(Double amtCntblIncome) {
    this.hasAmtCntblIncome = true;
    this.amtCntblIncome = amtCntblIncome;
  }

  public void setAmtCntblIncome(Number amtCntblIncome) {
    this.hasAmtCntblIncome = true;
    this.amtCntblIncome = null;
    if (amtCntblIncome != null) {
      setAmtCntblIncome(amtCntblIncome.doubleValue());
    }
  }

  public boolean hasAmtCntblIncome30() {
    return hasAmtCntblIncome30;
  }

  public double getAmtCntblIncome30() {
    if (amtCntblIncome30 == null) {
      return (double) 0;
    }
    return amtCntblIncome30.doubleValue();
  }

  public Double getAmtCntblIncome30Object() {
    return amtCntblIncome30;
  }

  public String getAmtCntblIncome30String() {
    return FormattingHelper.formatDouble(amtCntblIncome30);
  }

  public void setAmtCntblIncome30(double amtCntblIncome30) {
    this.hasAmtCntblIncome30 = true;
    this.amtCntblIncome30 = new Double(amtCntblIncome30);
  }

  public void setAmtCntblIncome30(Double amtCntblIncome30) {
    this.hasAmtCntblIncome30 = true;
    this.amtCntblIncome30 = amtCntblIncome30;
  }

  public void setAmtCntblIncome30(Number amtCntblIncome30) {
    this.hasAmtCntblIncome30 = true;
    this.amtCntblIncome30 = null;
    if (amtCntblIncome30 != null) {
      setAmtCntblIncome30(amtCntblIncome30.doubleValue());
    }
  }

  public boolean hasAmtCntblIncomeLess30() {
    return hasAmtCntblIncomeLess30;
  }

  public double getAmtCntblIncomeLess30() {
    if (amtCntblIncomeLess30 == null) {
      return (double) 0;
    }
    return amtCntblIncomeLess30.doubleValue();
  }

  public Double getAmtCntblIncomeLess30Object() {
    return amtCntblIncomeLess30;
  }

  public String getAmtCntblIncomeLess30String() {
    return FormattingHelper.formatDouble(amtCntblIncomeLess30);
  }

  public void setAmtCntblIncomeLess30(double amtCntblIncomeLess30) {
    this.hasAmtCntblIncomeLess30 = true;
    this.amtCntblIncomeLess30 = new Double(amtCntblIncomeLess30);
  }

  public void setAmtCntblIncomeLess30(Double amtCntblIncomeLess30) {
    this.hasAmtCntblIncomeLess30 = true;
    this.amtCntblIncomeLess30 = amtCntblIncomeLess30;
  }

  public void setAmtCntblIncomeLess30(Number amtCntblIncomeLess30) {
    this.hasAmtCntblIncomeLess30 = true;
    this.amtCntblIncomeLess30 = null;
    if (amtCntblIncomeLess30 != null) {
      setAmtCntblIncomeLess30(amtCntblIncomeLess30.doubleValue());
    }
  }

  public boolean hasAmtCntblIncomeLessThird() {
    return hasAmtCntblIncomeLessThird;
  }

  public double getAmtCntblIncomeLessThird() {
    if (amtCntblIncomeLessThird == null) {
      return (double) 0;
    }
    return amtCntblIncomeLessThird.doubleValue();
  }

  public Double getAmtCntblIncomeLessThirdObject() {
    return amtCntblIncomeLessThird;
  }

  public String getAmtCntblIncomeLessThirdString() {
    return FormattingHelper.formatDouble(amtCntblIncomeLessThird);
  }

  public void setAmtCntblIncomeLessThird(double amtCntblIncomeLessThird) {
    this.hasAmtCntblIncomeLessThird = true;
    this.amtCntblIncomeLessThird = new Double(amtCntblIncomeLessThird);
  }

  public void setAmtCntblIncomeLessThird(Double amtCntblIncomeLessThird) {
    this.hasAmtCntblIncomeLessThird = true;
    this.amtCntblIncomeLessThird = amtCntblIncomeLessThird;
  }

  public void setAmtCntblIncomeLessThird(Number amtCntblIncomeLessThird) {
    this.hasAmtCntblIncomeLessThird = true;
    this.amtCntblIncomeLessThird = null;
    if (amtCntblIncomeLessThird != null) {
      setAmtCntblIncomeLessThird(amtCntblIncomeLessThird.doubleValue());
    }
  }

  public boolean hasAmtCntblIncomeThird() {
    return hasAmtCntblIncomeThird;
  }

  public double getAmtCntblIncomeThird() {
    if (amtCntblIncomeThird == null) {
      return (double) 0;
    }
    return amtCntblIncomeThird.doubleValue();
  }

  public Double getAmtCntblIncomeThirdObject() {
    return amtCntblIncomeThird;
  }

  public String getAmtCntblIncomeThirdString() {
    return FormattingHelper.formatDouble(amtCntblIncomeThird);
  }

  public void setAmtCntblIncomeThird(double amtCntblIncomeThird) {
    this.hasAmtCntblIncomeThird = true;
    this.amtCntblIncomeThird = new Double(amtCntblIncomeThird);
  }

  public void setAmtCntblIncomeThird(Double amtCntblIncomeThird) {
    this.hasAmtCntblIncomeThird = true;
    this.amtCntblIncomeThird = amtCntblIncomeThird;
  }

  public void setAmtCntblIncomeThird(Number amtCntblIncomeThird) {
    this.hasAmtCntblIncomeThird = true;
    this.amtCntblIncomeThird = null;
    if (amtCntblIncomeThird != null) {
      setAmtCntblIncomeThird(amtCntblIncomeThird.doubleValue());
    }
  }

  public boolean hasAmtGrossEarnedIncome() {
    return hasAmtGrossEarnedIncome;
  }

  public double getAmtGrossEarnedIncome() {
    if (amtGrossEarnedIncome == null) {
      return (double) 0;
    }
    return amtGrossEarnedIncome.doubleValue();
  }

  public Double getAmtGrossEarnedIncomeObject() {
    return amtGrossEarnedIncome;
  }

  public String getAmtGrossEarnedIncomeString() {
    return FormattingHelper.formatDouble(amtGrossEarnedIncome);
  }

  public void setAmtGrossEarnedIncome(double amtGrossEarnedIncome) {
    this.hasAmtGrossEarnedIncome = true;
    this.amtGrossEarnedIncome = new Double(amtGrossEarnedIncome);
  }

  public void setAmtGrossEarnedIncome(Double amtGrossEarnedIncome) {
    this.hasAmtGrossEarnedIncome = true;
    this.amtGrossEarnedIncome = amtGrossEarnedIncome;
  }

  public void setAmtGrossEarnedIncome(Number amtGrossEarnedIncome) {
    this.hasAmtGrossEarnedIncome = true;
    this.amtGrossEarnedIncome = null;
    if (amtGrossEarnedIncome != null) {
      setAmtGrossEarnedIncome(amtGrossEarnedIncome.doubleValue());
    }
  }

  public boolean hasAmtGrossUnearnedIncome() {
    return hasAmtGrossUnearnedIncome;
  }

  public double getAmtGrossUnearnedIncome() {
    if (amtGrossUnearnedIncome == null) {
      return (double) 0;
    }
    return amtGrossUnearnedIncome.doubleValue();
  }

  public Double getAmtGrossUnearnedIncomeObject() {
    return amtGrossUnearnedIncome;
  }

  public String getAmtGrossUnearnedIncomeString() {
    return FormattingHelper.formatDouble(amtGrossUnearnedIncome);
  }

  public void setAmtGrossUnearnedIncome(double amtGrossUnearnedIncome) {
    this.hasAmtGrossUnearnedIncome = true;
    this.amtGrossUnearnedIncome = new Double(amtGrossUnearnedIncome);
  }

  public void setAmtGrossUnearnedIncome(Double amtGrossUnearnedIncome) {
    this.hasAmtGrossUnearnedIncome = true;
    this.amtGrossUnearnedIncome = amtGrossUnearnedIncome;
  }

  public void setAmtGrossUnearnedIncome(Number amtGrossUnearnedIncome) {
    this.hasAmtGrossUnearnedIncome = true;
    this.amtGrossUnearnedIncome = null;
    if (amtGrossUnearnedIncome != null) {
      setAmtGrossUnearnedIncome(amtGrossUnearnedIncome.doubleValue());
    }
  }

  public boolean hasAmtStdEarnedIncomeDeduct() {
    return hasAmtStdEarnedIncomeDeduct;
  }

  public double getAmtStdEarnedIncomeDeduct() {
    if (amtStdEarnedIncomeDeduct == null) {
      return (double) 0;
    }
    return amtStdEarnedIncomeDeduct.doubleValue();
  }

  public Double getAmtStdEarnedIncomeDeductObject() {
    return amtStdEarnedIncomeDeduct;
  }

  public String getAmtStdEarnedIncomeDeductString() {
    return FormattingHelper.formatDouble(amtStdEarnedIncomeDeduct);
  }

  public void setAmtStdEarnedIncomeDeduct(double amtStdEarnedIncomeDeduct) {
    this.hasAmtStdEarnedIncomeDeduct = true;
    this.amtStdEarnedIncomeDeduct = new Double(amtStdEarnedIncomeDeduct);
  }

  public void setAmtStdEarnedIncomeDeduct(Double amtStdEarnedIncomeDeduct) {
    this.hasAmtStdEarnedIncomeDeduct = true;
    this.amtStdEarnedIncomeDeduct = amtStdEarnedIncomeDeduct;
  }

  public void setAmtStdEarnedIncomeDeduct(Number amtStdEarnedIncomeDeduct) {
    this.hasAmtStdEarnedIncomeDeduct = true;
    this.amtStdEarnedIncomeDeduct = null;
    if (amtStdEarnedIncomeDeduct != null) {
      setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeduct.doubleValue());
    }
  }
  public boolean hasAmtDeemAlimonyOutsideHh() {
    return hasAmtDeemAlimonyOutsideHh;
  }

  public double getAmtDeemAlimonyOutsideHh() {
    if (amtDeemAlimonyOutsideHh == null) {
      return (double) 0;
    }
    return amtDeemAlimonyOutsideHh.doubleValue();
  }

  public Double getAmtDeemAlimonyOutsideHhObject() {
    return amtDeemAlimonyOutsideHh;
  }

  public String getAmtDeemAlimonyOutsideHhString() {
    return FormattingHelper.formatDouble(amtDeemAlimonyOutsideHh);
  }

  public void setAmtDeemAlimonyOutsideHh(double amtDeemAlimonyOutsideHh) {
    this.hasAmtDeemAlimonyOutsideHh = true;
    this.amtDeemAlimonyOutsideHh = new Double(amtDeemAlimonyOutsideHh);
  }

  public void setAmtDeemAlimonyOutsideHh(Double amtDeemAlimonyOutsideHh) {
    this.hasAmtDeemAlimonyOutsideHh = true;
    this.amtDeemAlimonyOutsideHh = amtDeemAlimonyOutsideHh;
  }

  public void setAmtDeemAlimonyOutsideHh(Number amtDeemAlimonyOutsideHh) {
    this.hasAmtDeemAlimonyOutsideHh = true;
    this.amtDeemAlimonyOutsideHh = null;
    if (amtDeemAlimonyOutsideHh != null) {
      setAmtDeemAlimonyOutsideHh(amtDeemAlimonyOutsideHh.doubleValue());
    }
  }

  public boolean hasAmtDeemCntNetIncome() {
    return hasAmtDeemCntNetIncome;
  }

  public double getAmtDeemCntNetIncome() {
    if (amtDeemCntNetIncome == null) {
      return (double) 0;
    }
    return amtDeemCntNetIncome.doubleValue();
  }

  public Double getAmtDeemCntNetIncomeObject() {
    return amtDeemCntNetIncome;
  }

  public String getAmtDeemCntNetIncomeString() {
    return FormattingHelper.formatDouble(amtDeemCntNetIncome);
  }

  public void setAmtDeemCntNetIncome(double amtDeemCntNetIncome) {
    this.hasAmtDeemCntNetIncome = true;
    this.amtDeemCntNetIncome = new Double(amtDeemCntNetIncome);
  }

  public void setAmtDeemCntNetIncome(Double amtDeemCntNetIncome) {
    this.hasAmtDeemCntNetIncome = true;
    this.amtDeemCntNetIncome = amtDeemCntNetIncome;
  }

  public void setAmtDeemCntNetIncome(Number amtDeemCntNetIncome) {
    this.hasAmtDeemCntNetIncome = true;
    this.amtDeemCntNetIncome = null;
    if (amtDeemCntNetIncome != null) {
      setAmtDeemCntNetIncome(amtDeemCntNetIncome.doubleValue());
    }
  }

  public boolean hasAmtDeemGrossEarnedIncome() {
    return hasAmtDeemGrossEarnedIncome;
  }

  public double getAmtDeemGrossEarnedIncome() {
    if (amtDeemGrossEarnedIncome == null) {
      return (double) 0;
    }
    return amtDeemGrossEarnedIncome.doubleValue();
  }

  public Double getAmtDeemGrossEarnedIncomeObject() {
    return amtDeemGrossEarnedIncome;
  }

  public String getAmtDeemGrossEarnedIncomeString() {
    return FormattingHelper.formatDouble(amtDeemGrossEarnedIncome);
  }

  public void setAmtDeemGrossEarnedIncome(double amtDeemGrossEarnedIncome) {
    this.hasAmtDeemGrossEarnedIncome = true;
    this.amtDeemGrossEarnedIncome = new Double(amtDeemGrossEarnedIncome);
  }

  public void setAmtDeemGrossEarnedIncome(Double amtDeemGrossEarnedIncome) {
    this.hasAmtDeemGrossEarnedIncome = true;
    this.amtDeemGrossEarnedIncome = amtDeemGrossEarnedIncome;
  }

  public void setAmtDeemGrossEarnedIncome(Number amtDeemGrossEarnedIncome) {
    this.hasAmtDeemGrossEarnedIncome = true;
    this.amtDeemGrossEarnedIncome = null;
    if (amtDeemGrossEarnedIncome != null) {
      setAmtDeemGrossEarnedIncome(amtDeemGrossEarnedIncome.doubleValue());
    }
  }

  public boolean hasAmtDeemLessStdOfNeed() {
    return hasAmtDeemLessStdOfNeed;
  }

  public double getAmtDeemLessStdOfNeed() {
    if (amtDeemLessStdOfNeed == null) {
      return (double) 0;
    }
    return amtDeemLessStdOfNeed.doubleValue();
  }

  public Double getAmtDeemLessStdOfNeedObject() {
    return amtDeemLessStdOfNeed;
  }

  public String getAmtDeemLessStdOfNeedString() {
    return FormattingHelper.formatDouble(amtDeemLessStdOfNeed);
  }

  public void setAmtDeemLessStdOfNeed(double amtDeemLessStdOfNeed) {
    this.hasAmtDeemLessStdOfNeed = true;
    this.amtDeemLessStdOfNeed = new Double(amtDeemLessStdOfNeed);
  }

  public void setAmtDeemLessStdOfNeed(Double amtDeemLessStdOfNeed) {
    this.hasAmtDeemLessStdOfNeed = true;
    this.amtDeemLessStdOfNeed = amtDeemLessStdOfNeed;
  }

  public void setAmtDeemLessStdOfNeed(Number amtDeemLessStdOfNeed) {
    this.hasAmtDeemLessStdOfNeed = true;
    this.amtDeemLessStdOfNeed = null;
    if (amtDeemLessStdOfNeed != null) {
      setAmtDeemLessStdOfNeed(amtDeemLessStdOfNeed.doubleValue());
    }
  }

  public boolean hasAmtDeemNetEarnedIncome() {
    return hasAmtDeemNetEarnedIncome;
  }

  public double getAmtDeemNetEarnedIncome() {
    if (amtDeemNetEarnedIncome == null) {
      return (double) 0;
    }
    return amtDeemNetEarnedIncome.doubleValue();
  }

  public Double getAmtDeemNetEarnedIncomeObject() {
    return amtDeemNetEarnedIncome;
  }

  public String getAmtDeemNetEarnedIncomeString() {
    return FormattingHelper.formatDouble(amtDeemNetEarnedIncome);
  }

  public void setAmtDeemNetEarnedIncome(double amtDeemNetEarnedIncome) {
    this.hasAmtDeemNetEarnedIncome = true;
    this.amtDeemNetEarnedIncome = new Double(amtDeemNetEarnedIncome);
  }

  public void setAmtDeemNetEarnedIncome(Double amtDeemNetEarnedIncome) {
    this.hasAmtDeemNetEarnedIncome = true;
    this.amtDeemNetEarnedIncome = amtDeemNetEarnedIncome;
  }

  public void setAmtDeemNetEarnedIncome(Number amtDeemNetEarnedIncome) {
    this.hasAmtDeemNetEarnedIncome = true;
    this.amtDeemNetEarnedIncome = null;
    if (amtDeemNetEarnedIncome != null) {
      setAmtDeemNetEarnedIncome(amtDeemNetEarnedIncome.doubleValue());
    }
  }

  public boolean hasAmtDeemStdEarnedIncDeduct() {
    return hasAmtDeemStdEarnedIncDeduct;
  }

  public double getAmtDeemStdEarnedIncDeduct() {
    if (amtDeemStdEarnedIncDeduct == null) {
      return (double) 0;
    }
    return amtDeemStdEarnedIncDeduct.doubleValue();
  }

  public Double getAmtDeemStdEarnedIncDeductObject() {
    return amtDeemStdEarnedIncDeduct;
  }

  public String getAmtDeemStdEarnedIncDeductString() {
    return FormattingHelper.formatDouble(amtDeemStdEarnedIncDeduct);
  }

  public void setAmtDeemStdEarnedIncDeduct(double amtDeemStdEarnedIncDeduct) {
    this.hasAmtDeemStdEarnedIncDeduct = true;
    this.amtDeemStdEarnedIncDeduct = new Double(amtDeemStdEarnedIncDeduct);
  }

  public void setAmtDeemStdEarnedIncDeduct(Double amtDeemStdEarnedIncDeduct) {
    this.hasAmtDeemStdEarnedIncDeduct = true;
    this.amtDeemStdEarnedIncDeduct = amtDeemStdEarnedIncDeduct;
  }

  public void setAmtDeemStdEarnedIncDeduct(Number amtDeemStdEarnedIncDeduct) {
    this.hasAmtDeemStdEarnedIncDeduct = true;
    this.amtDeemStdEarnedIncDeduct = null;
    if (amtDeemStdEarnedIncDeduct != null) {
      setAmtDeemStdEarnedIncDeduct(amtDeemStdEarnedIncDeduct.doubleValue());
    }
  }

  public boolean hasAmtDeemStdOfNeed() {
    return hasAmtDeemStdOfNeed;
  }

  public double getAmtDeemStdOfNeed() {
    if (amtDeemStdOfNeed == null) {
      return (double) 0;
    }
    return amtDeemStdOfNeed.doubleValue();
  }

  public Double getAmtDeemStdOfNeedObject() {
    return amtDeemStdOfNeed;
  }

  public String getAmtDeemStdOfNeedString() {
    return FormattingHelper.formatDouble(amtDeemStdOfNeed);
  }

  public void setAmtDeemStdOfNeed(double amtDeemStdOfNeed) {
    this.hasAmtDeemStdOfNeed = true;
    this.amtDeemStdOfNeed = new Double(amtDeemStdOfNeed);
  }

  public void setAmtDeemStdOfNeed(Double amtDeemStdOfNeed) {
    this.hasAmtDeemStdOfNeed = true;
    this.amtDeemStdOfNeed = amtDeemStdOfNeed;
  }

  public void setAmtDeemStdOfNeed(Number amtDeemStdOfNeed) {
    this.hasAmtDeemStdOfNeed = true;
    this.amtDeemStdOfNeed = null;
    if (amtDeemStdOfNeed != null) {
      setAmtDeemStdOfNeed(amtDeemStdOfNeed.doubleValue());
    }
  }

  public boolean hasAmtDeemSurplusOrDeficit() {
    return hasAmtDeemSurplusOrDeficit;
  }

  public double getAmtDeemSurplusOrDeficit() {
    if (amtDeemSurplusOrDeficit == null) {
      return (double) 0;
    }
    return amtDeemSurplusOrDeficit.doubleValue();
  }

  public Double getAmtDeemSurplusOrDeficitObject() {
    return amtDeemSurplusOrDeficit;
  }

  public String getAmtDeemSurplusOrDeficitString() {
    return FormattingHelper.formatDouble(amtDeemSurplusOrDeficit);
  }

  public void setAmtDeemSurplusOrDeficit(double amtDeemSurplusOrDeficit) {
    this.hasAmtDeemSurplusOrDeficit = true;
    this.amtDeemSurplusOrDeficit = new Double(amtDeemSurplusOrDeficit);
  }

  public void setAmtDeemSurplusOrDeficit(Double amtDeemSurplusOrDeficit) {
    this.hasAmtDeemSurplusOrDeficit = true;
    this.amtDeemSurplusOrDeficit = amtDeemSurplusOrDeficit;
  }

  public void setAmtDeemSurplusOrDeficit(Number amtDeemSurplusOrDeficit) {
    this.hasAmtDeemSurplusOrDeficit = true;
    this.amtDeemSurplusOrDeficit = null;
    if (amtDeemSurplusOrDeficit != null) {
      setAmtDeemSurplusOrDeficit(amtDeemSurplusOrDeficit.doubleValue());
    }
  }
     
  public boolean hasAmtDeemTaxDependOutHh() {
    return hasAmtDeemTaxDependOutHh;
  }

  public double getAmtDeemTaxDependOutHh() {
    if (amtDeemTaxDependOutHh == null) {
      return (double) 0;
    }
    return amtDeemTaxDependOutHh.doubleValue();
  }

  public Double getAmtDeemTaxDependOutHhObject() {
    return amtDeemTaxDependOutHh;
  }

  public String getAmtDeemTaxDependOutHhString() {
    return FormattingHelper.formatDouble(amtDeemTaxDependOutHh);
  }

  public void setAmtDeemTaxDependOutHh(double amtDeemTaxDependOutHh) {
    this.hasAmtDeemTaxDependOutHh = true;
    this.amtDeemTaxDependOutHh = new Double(amtDeemTaxDependOutHh);
  }

  public void setAmtDeemTaxDependOutHh(Double amtDeemTaxDependOutHh) {
    this.hasAmtDeemTaxDependOutHh = true;
    this.amtDeemTaxDependOutHh = amtDeemTaxDependOutHh;
  }

  public void setAmtDeemTaxDependOutHh(Number amtDeemTaxDependOutHh) {
    this.hasAmtDeemTaxDependOutHh = true;
    this.amtDeemTaxDependOutHh = null;
    if (amtDeemTaxDependOutHh != null) {
      setAmtDeemTaxDependOutHh(amtDeemTaxDependOutHh.doubleValue());
    }
  }

  public boolean hasAmtDeemTotal() {
    return hasAmtDeemTotal;
  }

  public double getAmtDeemTotal() {
    if (amtDeemTotal == null) {
      return (double) 0;
    }
    return amtDeemTotal.doubleValue();
  }

  public Double getAmtDeemTotalObject() {
    return amtDeemTotal;
  }

  public String getAmtDeemTotalString() {
    return FormattingHelper.formatDouble(amtDeemTotal);
  }

  public void setAmtDeemTotal(double amtDeemTotal) {
    this.hasAmtDeemTotal = true;
    this.amtDeemTotal = new Double(amtDeemTotal);
  }

  public void setAmtDeemTotal(Double amtDeemTotal) {
    this.hasAmtDeemTotal = true;
    this.amtDeemTotal = amtDeemTotal;
  }

  public void setAmtDeemTotal(Number amtDeemTotal) {
    this.hasAmtDeemTotal = true;
    this.amtDeemTotal = null;
    if (amtDeemTotal != null) {
      setAmtDeemTotal(amtDeemTotal.doubleValue());
    }
  }
   
  public boolean hasAmtDeemUnearnedIncome() {
    return hasAmtDeemUnearnedIncome;
  }

  public double getAmtDeemUnearnedIncome() {
    if (amtDeemUnearnedIncome == null) {
      return (double) 0;
    }
    return amtDeemUnearnedIncome.doubleValue();
  }

  public Double getAmtDeemUnearnedIncomeObject() {
    return amtDeemUnearnedIncome;
  }

  public String getAmtDeemUnearnedIncomeString() {
    return FormattingHelper.formatDouble(amtDeemUnearnedIncome);
  }

  public void setAmtDeemUnearnedIncome(double amtDeemUnearnedIncome) {
    this.hasAmtDeemUnearnedIncome = true;
    this.amtDeemUnearnedIncome = new Double(amtDeemUnearnedIncome);
  }

  public void setAmtDeemUnearnedIncome(Double amtDeemUnearnedIncome) {
    this.hasAmtDeemUnearnedIncome = true;
    this.amtDeemUnearnedIncome = amtDeemUnearnedIncome;
  }

  public void setAmtDeemUnearnedIncome(Number amtDeemUnearnedIncome) {
    this.hasAmtDeemUnearnedIncome = true;
    this.amtDeemUnearnedIncome = null;
    if (amtDeemUnearnedIncome != null) {
      setAmtDeemUnearnedIncome(amtDeemUnearnedIncome.doubleValue());
    }
  }

  public boolean hasAmtEarnedLessAllDeduct() {
    return hasAmtEarnedLessAllDeduct;
  }

  public double getAmtEarnedLessAllDeduct() {
    if (amtEarnedLessAllDeduct == null) {
      return (double) 0;
    }
    return amtEarnedLessAllDeduct.doubleValue();
  }

  public Double getAmtEarnedLessAllDeductObject() {
    return amtEarnedLessAllDeduct;
  }

  public String getAmtEarnedLessAllDeductString() {
    return FormattingHelper.formatDouble(amtEarnedLessAllDeduct);
  }

  public void setAmtEarnedLessAllDeduct(double amtEarnedLessAllDeduct) {
    this.hasAmtEarnedLessAllDeduct = true;
    this.amtEarnedLessAllDeduct = new Double(amtEarnedLessAllDeduct);
  }

  public void setAmtEarnedLessAllDeduct(Double amtEarnedLessAllDeduct) {
    this.hasAmtEarnedLessAllDeduct = true;
    this.amtEarnedLessAllDeduct = amtEarnedLessAllDeduct;
  }

  public void setAmtEarnedLessAllDeduct(Number amtEarnedLessAllDeduct) {
    this.hasAmtEarnedLessAllDeduct = true;
    this.amtEarnedLessAllDeduct = null;
    if (amtEarnedLessAllDeduct != null) {
      setAmtEarnedLessAllDeduct(amtEarnedLessAllDeduct.doubleValue());
    }
  }

  public boolean hasAmtEarnedLessStdDeduct() {
    return hasAmtEarnedLessStdDeduct;
  }

  public double getAmtEarnedLessStdDeduct() {
    if (amtEarnedLessStdDeduct == null) {
      return (double) 0;
    }
    return amtEarnedLessStdDeduct.doubleValue();
  }

  public Double getAmtEarnedLessStdDeductObject() {
    return amtEarnedLessStdDeduct;
  }

  public String getAmtEarnedLessStdDeductString() {
    return FormattingHelper.formatDouble(amtEarnedLessStdDeduct);
  }

  public void setAmtEarnedLessStdDeduct(double amtEarnedLessStdDeduct) {
    this.hasAmtEarnedLessStdDeduct = true;
    this.amtEarnedLessStdDeduct = new Double(amtEarnedLessStdDeduct);
  }

  public void setAmtEarnedLessStdDeduct(Double amtEarnedLessStdDeduct) {
    this.hasAmtEarnedLessStdDeduct = true;
    this.amtEarnedLessStdDeduct = amtEarnedLessStdDeduct;
  }

  public void setAmtEarnedLessStdDeduct(Number amtEarnedLessStdDeduct) {
    this.hasAmtEarnedLessStdDeduct = true;
    this.amtEarnedLessStdDeduct = null;
    if (amtEarnedLessStdDeduct != null) {
      setAmtEarnedLessStdDeduct(amtEarnedLessStdDeduct.doubleValue());
    }
  }
  
  public boolean hasAmtGicSurpDefctChild() {
    return hasAmtGicSurpDefctChild;
  }

  public double getAmtGicSurpDefctChild() {
    if (amtGicSurpDefctChild == null) {
      return (double) 0;
    }
    return amtGicSurpDefctChild.doubleValue();
  }

  public Double getAmtGicSurpDefctChildObject() {
    return amtGicSurpDefctChild;
  }

  public String getAmtGicSurpDefctChildString() {
    return FormattingHelper.formatDouble(amtGicSurpDefctChild);
  }

  public void setAmtGicSurpDefctChild(double amtGicSurpDefctChild) {
    this.hasAmtGicSurpDefctChild = true;
    this.amtGicSurpDefctChild = new Double(amtGicSurpDefctChild);
  }

  public void setAmtGicSurpDefctChild(Double amtGicSurpDefctChild) {
    this.hasAmtGicSurpDefctChild = true;
    this.amtGicSurpDefctChild = amtGicSurpDefctChild;
  }

  public void setAmtGicSurpDefctChild(Number amtGicSurpDefctChild) {
    this.hasAmtGicSurpDefctChild = true;
    this.amtGicSurpDefctChild = null;
    if (amtGicSurpDefctChild != null) {
      setAmtGicSurpDefctChild(amtGicSurpDefctChild.doubleValue());
    }
  }

  public boolean hasAmtGicSurpDefctCrtfdGrp() {
    return hasAmtGicSurpDefctCrtfdGrp;
  }

  public double getAmtGicSurpDefctCrtfdGrp() {
    if (amtGicSurpDefctCrtfdGrp == null) {
      return (double) 0;
    }
    return amtGicSurpDefctCrtfdGrp.doubleValue();
  }

  public Double getAmtGicSurpDefctCrtfdGrpObject() {
    return amtGicSurpDefctCrtfdGrp;
  }

  public String getAmtGicSurpDefctCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtGicSurpDefctCrtfdGrp);
  }

  public void setAmtGicSurpDefctCrtfdGrp(double amtGicSurpDefctCrtfdGrp) {
    this.hasAmtGicSurpDefctCrtfdGrp = true;
    this.amtGicSurpDefctCrtfdGrp = new Double(amtGicSurpDefctCrtfdGrp);
  }

  public void setAmtGicSurpDefctCrtfdGrp(Double amtGicSurpDefctCrtfdGrp) {
    this.hasAmtGicSurpDefctCrtfdGrp = true;
    this.amtGicSurpDefctCrtfdGrp = amtGicSurpDefctCrtfdGrp;
  }

  public void setAmtGicSurpDefctCrtfdGrp(Number amtGicSurpDefctCrtfdGrp) {
    this.hasAmtGicSurpDefctCrtfdGrp = true;
    this.amtGicSurpDefctCrtfdGrp = null;
    if (amtGicSurpDefctCrtfdGrp != null) {
      setAmtGicSurpDefctCrtfdGrp(amtGicSurpDefctCrtfdGrp.doubleValue());
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

  public boolean hasAmtGrossIncomeAllocMutual() {
    return hasAmtGrossIncomeAllocMutual;
  }

  public double getAmtGrossIncomeAllocMutual() {
    if (amtGrossIncomeAllocMutual == null) {
      return (double) 0;
    }
    return amtGrossIncomeAllocMutual.doubleValue();
  }

  public Double getAmtGrossIncomeAllocMutualObject() {
    return amtGrossIncomeAllocMutual;
  }

  public String getAmtGrossIncomeAllocMutualString() {
    return FormattingHelper.formatDouble(amtGrossIncomeAllocMutual);
  }

  public void setAmtGrossIncomeAllocMutual(double amtGrossIncomeAllocMutual) {
    this.hasAmtGrossIncomeAllocMutual = true;
    this.amtGrossIncomeAllocMutual = new Double(amtGrossIncomeAllocMutual);
  }

  public void setAmtGrossIncomeAllocMutual(Double amtGrossIncomeAllocMutual) {
    this.hasAmtGrossIncomeAllocMutual = true;
    this.amtGrossIncomeAllocMutual = amtGrossIncomeAllocMutual;
  }

  public void setAmtGrossIncomeAllocMutual(Number amtGrossIncomeAllocMutual) {
    this.hasAmtGrossIncomeAllocMutual = true;
    this.amtGrossIncomeAllocMutual = null;
    if (amtGrossIncomeAllocMutual != null) {
      setAmtGrossIncomeAllocMutual(amtGrossIncomeAllocMutual.doubleValue());
    }
  }

  public boolean hasAmtGrossIncomeAllocSngl1() {
    return hasAmtGrossIncomeAllocSngl1;
  }

  public double getAmtGrossIncomeAllocSngl1() {
    if (amtGrossIncomeAllocSngl1 == null) {
      return (double) 0;
    }
    return amtGrossIncomeAllocSngl1.doubleValue();
  }

  public Double getAmtGrossIncomeAllocSngl1Object() {
    return amtGrossIncomeAllocSngl1;
  }

  public String getAmtGrossIncomeAllocSngl1String() {
    return FormattingHelper.formatDouble(amtGrossIncomeAllocSngl1);
  }

  public void setAmtGrossIncomeAllocSngl1(double amtGrossIncomeAllocSngl1) {
    this.hasAmtGrossIncomeAllocSngl1 = true;
    this.amtGrossIncomeAllocSngl1 = new Double(amtGrossIncomeAllocSngl1);
  }

  public void setAmtGrossIncomeAllocSngl1(Double amtGrossIncomeAllocSngl1) {
    this.hasAmtGrossIncomeAllocSngl1 = true;
    this.amtGrossIncomeAllocSngl1 = amtGrossIncomeAllocSngl1;
  }

  public void setAmtGrossIncomeAllocSngl1(Number amtGrossIncomeAllocSngl1) {
    this.hasAmtGrossIncomeAllocSngl1 = true;
    this.amtGrossIncomeAllocSngl1 = null;
    if (amtGrossIncomeAllocSngl1 != null) {
      setAmtGrossIncomeAllocSngl1(amtGrossIncomeAllocSngl1.doubleValue());
    }
  }

  public boolean hasAmtGrossIncomeAllocSngl2() {
    return hasAmtGrossIncomeAllocSngl2;
  }

  public double getAmtGrossIncomeAllocSngl2() {
    if (amtGrossIncomeAllocSngl2 == null) {
      return (double) 0;
    }
    return amtGrossIncomeAllocSngl2.doubleValue();
  }

  public Double getAmtGrossIncomeAllocSngl2Object() {
    return amtGrossIncomeAllocSngl2;
  }

  public String getAmtGrossIncomeAllocSngl2String() {
    return FormattingHelper.formatDouble(amtGrossIncomeAllocSngl2);
  }

  public void setAmtGrossIncomeAllocSngl2(double amtGrossIncomeAllocSngl2) {
    this.hasAmtGrossIncomeAllocSngl2 = true;
    this.amtGrossIncomeAllocSngl2 = new Double(amtGrossIncomeAllocSngl2);
  }

  public void setAmtGrossIncomeAllocSngl2(Double amtGrossIncomeAllocSngl2) {
    this.hasAmtGrossIncomeAllocSngl2 = true;
    this.amtGrossIncomeAllocSngl2 = amtGrossIncomeAllocSngl2;
  }

  public void setAmtGrossIncomeAllocSngl2(Number amtGrossIncomeAllocSngl2) {
    this.hasAmtGrossIncomeAllocSngl2 = true;
    this.amtGrossIncomeAllocSngl2 = null;
    if (amtGrossIncomeAllocSngl2 != null) {
      setAmtGrossIncomeAllocSngl2(amtGrossIncomeAllocSngl2.doubleValue());
    }
  }

  public boolean hasAmtGrossIncomeCrtfdGrp() {
    return hasAmtGrossIncomeCrtfdGrp;
  }

  public double getAmtGrossIncomeCrtfdGrp() {
    if (amtGrossIncomeCrtfdGrp == null) {
      return (double) 0;
    }
    return amtGrossIncomeCrtfdGrp.doubleValue();
  }

  public Double getAmtGrossIncomeCrtfdGrpObject() {
    return amtGrossIncomeCrtfdGrp;
  }

  public String getAmtGrossIncomeCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtGrossIncomeCrtfdGrp);
  }

  public void setAmtGrossIncomeCrtfdGrp(double amtGrossIncomeCrtfdGrp) {
    this.hasAmtGrossIncomeCrtfdGrp = true;
    this.amtGrossIncomeCrtfdGrp = new Double(amtGrossIncomeCrtfdGrp);
  }

  public void setAmtGrossIncomeCrtfdGrp(Double amtGrossIncomeCrtfdGrp) {
    this.hasAmtGrossIncomeCrtfdGrp = true;
    this.amtGrossIncomeCrtfdGrp = amtGrossIncomeCrtfdGrp;
  }

  public void setAmtGrossIncomeCrtfdGrp(Number amtGrossIncomeCrtfdGrp) {
    this.hasAmtGrossIncomeCrtfdGrp = true;
    this.amtGrossIncomeCrtfdGrp = null;
    if (amtGrossIncomeCrtfdGrp != null) {
      setAmtGrossIncomeCrtfdGrp(amtGrossIncomeCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtGrossIncomeChild() {
    return hasAmtGrossIncomeChild;
  }

  public double getAmtGrossIncomeChild() {
    if (amtGrossIncomeChild == null) {
      return (double) 0;
    }
    return amtGrossIncomeChild.doubleValue();
  }

  public Double getAmtGrossIncomeChildObject() {
    return amtGrossIncomeChild;
  }

  public String getAmtGrossIncomeChildString() {
    return FormattingHelper.formatDouble(amtGrossIncomeChild);
  }

  public void setAmtGrossIncomeChild(double amtGrossIncomeChild) {
    this.hasAmtGrossIncomeChild = true;
    this.amtGrossIncomeChild = new Double(amtGrossIncomeChild);
  }

  public void setAmtGrossIncomeChild(Double amtGrossIncomeChild) {
    this.hasAmtGrossIncomeChild = true;
    this.amtGrossIncomeChild = amtGrossIncomeChild;
  }

  public void setAmtGrossIncomeChild(Number amtGrossIncomeChild) {
    this.hasAmtGrossIncomeChild = true;
    this.amtGrossIncomeChild = null;
    if (amtGrossIncomeChild != null) {
      setAmtGrossIncomeChild(amtGrossIncomeChild.doubleValue());
    }
  }

  public boolean hasAmtLessAllocElig() {
    return hasAmtLessAllocElig;
  }

  public double getAmtLessAllocElig() {
    if (amtLessAllocElig == null) {
      return (double) 0;
    }
    return amtLessAllocElig.doubleValue();
  }

  public Double getAmtLessAllocEligObject() {
    return amtLessAllocElig;
  }

  public String getAmtLessAllocEligString() {
    return FormattingHelper.formatDouble(amtLessAllocElig);
  }

  public void setAmtLessAllocElig(double amtLessAllocElig) {
    this.hasAmtLessAllocElig = true;
    this.amtLessAllocElig = new Double(amtLessAllocElig);
  }

  public void setAmtLessAllocElig(Double amtLessAllocElig) {
    this.hasAmtLessAllocElig = true;
    this.amtLessAllocElig = amtLessAllocElig;
  }

  public void setAmtLessAllocElig(Number amtLessAllocElig) {
    this.hasAmtLessAllocElig = true;
    this.amtLessAllocElig = null;
    if (amtLessAllocElig != null) {
      setAmtLessAllocElig(amtLessAllocElig.doubleValue());
    }
  }

  public boolean hasAmtLessAllocStdNeed() {
    return hasAmtLessAllocStdNeed;
  }

  public double getAmtLessAllocStdNeed() {
    if (amtLessAllocStdNeed == null) {
      return (double) 0;
    }
    return amtLessAllocStdNeed.doubleValue();
  }

  public Double getAmtLessAllocStdNeedObject() {
    return amtLessAllocStdNeed;
  }

  public String getAmtLessAllocStdNeedString() {
    return FormattingHelper.formatDouble(amtLessAllocStdNeed);
  }

  public void setAmtLessAllocStdNeed(double amtLessAllocStdNeed) {
    this.hasAmtLessAllocStdNeed = true;
    this.amtLessAllocStdNeed = new Double(amtLessAllocStdNeed);
  }

  public void setAmtLessAllocStdNeed(Double amtLessAllocStdNeed) {
    this.hasAmtLessAllocStdNeed = true;
    this.amtLessAllocStdNeed = amtLessAllocStdNeed;
  }

  public void setAmtLessAllocStdNeed(Number amtLessAllocStdNeed) {
    this.hasAmtLessAllocStdNeed = true;
    this.amtLessAllocStdNeed = null;
    if (amtLessAllocStdNeed != null) {
      setAmtLessAllocStdNeed(amtLessAllocStdNeed.doubleValue());
    }
  }

  public boolean hasAmtLessDepCareElig() {
    return hasAmtLessDepCareElig;
  }

  public double getAmtLessDepCareElig() {
    if (amtLessDepCareElig == null) {
      return (double) 0;
    }
    return amtLessDepCareElig.doubleValue();
  }

  public Double getAmtLessDepCareEligObject() {
    return amtLessDepCareElig;
  }

  public String getAmtLessDepCareEligString() {
    return FormattingHelper.formatDouble(amtLessDepCareElig);
  }

  public void setAmtLessDepCareElig(double amtLessDepCareElig) {
    this.hasAmtLessDepCareElig = true;
    this.amtLessDepCareElig = new Double(amtLessDepCareElig);
  }

  public void setAmtLessDepCareElig(Double amtLessDepCareElig) {
    this.hasAmtLessDepCareElig = true;
    this.amtLessDepCareElig = amtLessDepCareElig;
  }

  public void setAmtLessDepCareElig(Number amtLessDepCareElig) {
    this.hasAmtLessDepCareElig = true;
    this.amtLessDepCareElig = null;
    if (amtLessDepCareElig != null) {
      setAmtLessDepCareElig(amtLessDepCareElig.doubleValue());
    }
  }

  public boolean hasAmtLessDepCareStdNeed() {
    return hasAmtLessDepCareStdNeed;
  }

  public double getAmtLessDepCareStdNeed() {
    if (amtLessDepCareStdNeed == null) {
      return (double) 0;
    }
    return amtLessDepCareStdNeed.doubleValue();
  }

  public Double getAmtLessDepCareStdNeedObject() {
    return amtLessDepCareStdNeed;
  }

  public String getAmtLessDepCareStdNeedString() {
    return FormattingHelper.formatDouble(amtLessDepCareStdNeed);
  }

  public void setAmtLessDepCareStdNeed(double amtLessDepCareStdNeed) {
    this.hasAmtLessDepCareStdNeed = true;
    this.amtLessDepCareStdNeed = new Double(amtLessDepCareStdNeed);
  }

  public void setAmtLessDepCareStdNeed(Double amtLessDepCareStdNeed) {
    this.hasAmtLessDepCareStdNeed = true;
    this.amtLessDepCareStdNeed = amtLessDepCareStdNeed;
  }

  public void setAmtLessDepCareStdNeed(Number amtLessDepCareStdNeed) {
    this.hasAmtLessDepCareStdNeed = true;
    this.amtLessDepCareStdNeed = null;
    if (amtLessDepCareStdNeed != null) {
      setAmtLessDepCareStdNeed(amtLessDepCareStdNeed.doubleValue());
    }
  }

  public boolean hasAmtNetEarnedIncome() {
    return hasAmtNetEarnedIncome;
  }

  public double getAmtNetEarnedIncome() {
    if (amtNetEarnedIncome == null) {
      return (double) 0;
    }
    return amtNetEarnedIncome.doubleValue();
  }

  public Double getAmtNetEarnedIncomeObject() {
    return amtNetEarnedIncome;
  }

  public String getAmtNetEarnedIncomeString() {
    return FormattingHelper.formatDouble(amtNetEarnedIncome);
  }

  public void setAmtNetEarnedIncome(double amtNetEarnedIncome) {
    this.hasAmtNetEarnedIncome = true;
    this.amtNetEarnedIncome = new Double(amtNetEarnedIncome);
  }

  public void setAmtNetEarnedIncome(Double amtNetEarnedIncome) {
    this.hasAmtNetEarnedIncome = true;
    this.amtNetEarnedIncome = amtNetEarnedIncome;
  }

  public void setAmtNetEarnedIncome(Number amtNetEarnedIncome) {
    this.hasAmtNetEarnedIncome = true;
    this.amtNetEarnedIncome = null;
    if (amtNetEarnedIncome != null) {
      setAmtNetEarnedIncome(amtNetEarnedIncome.doubleValue());
    }
  }

  public boolean hasAmtNetEarnedIncomeChild() {
    return hasAmtNetEarnedIncomeChild;
  }

  public double getAmtNetEarnedIncomeChild() {
    if (amtNetEarnedIncomeChild == null) {
      return (double) 0;
    }
    return amtNetEarnedIncomeChild.doubleValue();
  }

  public Double getAmtNetEarnedIncomeChildObject() {
    return amtNetEarnedIncomeChild;
  }

  public String getAmtNetEarnedIncomeChildString() {
    return FormattingHelper.formatDouble(amtNetEarnedIncomeChild);
  }

  public void setAmtNetEarnedIncomeChild(double amtNetEarnedIncomeChild) {
    this.hasAmtNetEarnedIncomeChild = true;
    this.amtNetEarnedIncomeChild = new Double(amtNetEarnedIncomeChild);
  }

  public void setAmtNetEarnedIncomeChild(Double amtNetEarnedIncomeChild) {
    this.hasAmtNetEarnedIncomeChild = true;
    this.amtNetEarnedIncomeChild = amtNetEarnedIncomeChild;
  }

  public void setAmtNetEarnedIncomeChild(Number amtNetEarnedIncomeChild) {
    this.hasAmtNetEarnedIncomeChild = true;
    this.amtNetEarnedIncomeChild = null;
    if (amtNetEarnedIncomeChild != null) {
      setAmtNetEarnedIncomeChild(amtNetEarnedIncomeChild.doubleValue());
    }
  }

  public boolean hasAmtNonexmptRsrcCrtfdGrp() {
    return hasAmtNonexmptRsrcCrtfdGrp;
  }

  public double getAmtNonexmptRsrcCrtfdGrp() {
    if (amtNonexmptRsrcCrtfdGrp == null) {
      return (double) 0;
    }
    return amtNonexmptRsrcCrtfdGrp.doubleValue();
  }

  public Double getAmtNonexmptRsrcCrtfdGrpObject() {
    return amtNonexmptRsrcCrtfdGrp;
  }

  public String getAmtNonexmptRsrcCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtNonexmptRsrcCrtfdGrp);
  }

  public void setAmtNonexmptRsrcCrtfdGrp(double amtNonexmptRsrcCrtfdGrp) {
    this.hasAmtNonexmptRsrcCrtfdGrp = true;
    this.amtNonexmptRsrcCrtfdGrp = new Double(amtNonexmptRsrcCrtfdGrp);
  }

  public void setAmtNonexmptRsrcCrtfdGrp(Double amtNonexmptRsrcCrtfdGrp) {
    this.hasAmtNonexmptRsrcCrtfdGrp = true;
    this.amtNonexmptRsrcCrtfdGrp = amtNonexmptRsrcCrtfdGrp;
  }

  public void setAmtNonexmptRsrcCrtfdGrp(Number amtNonexmptRsrcCrtfdGrp) {
    this.hasAmtNonexmptRsrcCrtfdGrp = true;
    this.amtNonexmptRsrcCrtfdGrp = null;
    if (amtNonexmptRsrcCrtfdGrp != null) {
      setAmtNonexmptRsrcCrtfdGrp(amtNonexmptRsrcCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtPlusChsupChild() {
    return hasAmtPlusChsupChild;
  }

  public double getAmtPlusChsupChild() {
    if (amtPlusChsupChild == null) {
      return (double) 0;
    }
    return amtPlusChsupChild.doubleValue();
  }

  public Double getAmtPlusChsupChildObject() {
    return amtPlusChsupChild;
  }

  public String getAmtPlusChsupChildString() {
    return FormattingHelper.formatDouble(amtPlusChsupChild);
  }

  public void setAmtPlusChsupChild(double amtPlusChsupChild) {
    this.hasAmtPlusChsupChild = true;
    this.amtPlusChsupChild = new Double(amtPlusChsupChild);
  }

  public void setAmtPlusChsupChild(Double amtPlusChsupChild) {
    this.hasAmtPlusChsupChild = true;
    this.amtPlusChsupChild = amtPlusChsupChild;
  }

  public void setAmtPlusChsupChild(Number amtPlusChsupChild) {
    this.hasAmtPlusChsupChild = true;
    this.amtPlusChsupChild = null;
    if (amtPlusChsupChild != null) {
      setAmtPlusChsupChild(amtPlusChsupChild.doubleValue());
    }
  }

  public boolean hasAmtPlusChsupCrtfdGrp() {
    return hasAmtPlusChsupCrtfdGrp;
  }

  public double getAmtPlusChsupCrtfdGrp() {
    if (amtPlusChsupCrtfdGrp == null) {
      return (double) 0;
    }
    return amtPlusChsupCrtfdGrp.doubleValue();
  }

  public Double getAmtPlusChsupCrtfdGrpObject() {
    return amtPlusChsupCrtfdGrp;
  }

  public String getAmtPlusChsupCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtPlusChsupCrtfdGrp);
  }

  public void setAmtPlusChsupCrtfdGrp(double amtPlusChsupCrtfdGrp) {
    this.hasAmtPlusChsupCrtfdGrp = true;
    this.amtPlusChsupCrtfdGrp = new Double(amtPlusChsupCrtfdGrp);
  }

  public void setAmtPlusChsupCrtfdGrp(Double amtPlusChsupCrtfdGrp) {
    this.hasAmtPlusChsupCrtfdGrp = true;
    this.amtPlusChsupCrtfdGrp = amtPlusChsupCrtfdGrp;
  }

  public void setAmtPlusChsupCrtfdGrp(Number amtPlusChsupCrtfdGrp) {
    this.hasAmtPlusChsupCrtfdGrp = true;
    this.amtPlusChsupCrtfdGrp = null;
    if (amtPlusChsupCrtfdGrp != null) {
      setAmtPlusChsupCrtfdGrp(amtPlusChsupCrtfdGrp.doubleValue());
    }
  }

  public boolean hasAmtPlusDeemedElig() {
    return hasAmtPlusDeemedElig;
  }

  public double getAmtPlusDeemedElig() {
    if (amtPlusDeemedElig == null) {
      return (double) 0;
    }
    return amtPlusDeemedElig.doubleValue();
  }

  public Double getAmtPlusDeemedEligObject() {
    return amtPlusDeemedElig;
  }

  public String getAmtPlusDeemedEligString() {
    return FormattingHelper.formatDouble(amtPlusDeemedElig);
  }

  public void setAmtPlusDeemedElig(double amtPlusDeemedElig) {
    this.hasAmtPlusDeemedElig = true;
    this.amtPlusDeemedElig = new Double(amtPlusDeemedElig);
  }

  public void setAmtPlusDeemedElig(Double amtPlusDeemedElig) {
    this.hasAmtPlusDeemedElig = true;
    this.amtPlusDeemedElig = amtPlusDeemedElig;
  }

  public void setAmtPlusDeemedElig(Number amtPlusDeemedElig) {
    this.hasAmtPlusDeemedElig = true;
    this.amtPlusDeemedElig = null;
    if (amtPlusDeemedElig != null) {
      setAmtPlusDeemedElig(amtPlusDeemedElig.doubleValue());
    }
  }

  public boolean hasAmtPlusDeemedStdNeed() {
    return hasAmtPlusDeemedStdNeed;
  }

  public double getAmtPlusDeemedStdNeed() {
    if (amtPlusDeemedStdNeed == null) {
      return (double) 0;
    }
    return amtPlusDeemedStdNeed.doubleValue();
  }

  public Double getAmtPlusDeemedStdNeedObject() {
    return amtPlusDeemedStdNeed;
  }

  public String getAmtPlusDeemedStdNeedString() {
    return FormattingHelper.formatDouble(amtPlusDeemedStdNeed);
  }

  public void setAmtPlusDeemedStdNeed(double amtPlusDeemedStdNeed) {
    this.hasAmtPlusDeemedStdNeed = true;
    this.amtPlusDeemedStdNeed = new Double(amtPlusDeemedStdNeed);
  }

  public void setAmtPlusDeemedStdNeed(Double amtPlusDeemedStdNeed) {
    this.hasAmtPlusDeemedStdNeed = true;
    this.amtPlusDeemedStdNeed = amtPlusDeemedStdNeed;
  }

  public void setAmtPlusDeemedStdNeed(Number amtPlusDeemedStdNeed) {
    this.hasAmtPlusDeemedStdNeed = true;
    this.amtPlusDeemedStdNeed = null;
    if (amtPlusDeemedStdNeed != null) {
      setAmtPlusDeemedStdNeed(amtPlusDeemedStdNeed.doubleValue());
    }
  }

  public boolean hasAmtPlusUnearnedElig() {
    return hasAmtPlusUnearnedElig;
  }

  public double getAmtPlusUnearnedElig() {
    if (amtPlusUnearnedElig == null) {
      return (double) 0;
    }
    return amtPlusUnearnedElig.doubleValue();
  }

  public Double getAmtPlusUnearnedEligObject() {
    return amtPlusUnearnedElig;
  }

  public String getAmtPlusUnearnedEligString() {
    return FormattingHelper.formatDouble(amtPlusUnearnedElig);
  }

  public void setAmtPlusUnearnedElig(double amtPlusUnearnedElig) {
    this.hasAmtPlusUnearnedElig = true;
    this.amtPlusUnearnedElig = new Double(amtPlusUnearnedElig);
  }

  public void setAmtPlusUnearnedElig(Double amtPlusUnearnedElig) {
    this.hasAmtPlusUnearnedElig = true;
    this.amtPlusUnearnedElig = amtPlusUnearnedElig;
  }

  public void setAmtPlusUnearnedElig(Number amtPlusUnearnedElig) {
    this.hasAmtPlusUnearnedElig = true;
    this.amtPlusUnearnedElig = null;
    if (amtPlusUnearnedElig != null) {
      setAmtPlusUnearnedElig(amtPlusUnearnedElig.doubleValue());
    }
  }

  public boolean hasAmtPlusUnearnedStdNeed() {
    return hasAmtPlusUnearnedStdNeed;
  }

  public double getAmtPlusUnearnedStdNeed() {
    if (amtPlusUnearnedStdNeed == null) {
      return (double) 0;
    }
    return amtPlusUnearnedStdNeed.doubleValue();
  }

  public Double getAmtPlusUnearnedStdNeedObject() {
    return amtPlusUnearnedStdNeed;
  }

  public String getAmtPlusUnearnedStdNeedString() {
    return FormattingHelper.formatDouble(amtPlusUnearnedStdNeed);
  }

  public void setAmtPlusUnearnedStdNeed(double amtPlusUnearnedStdNeed) {
    this.hasAmtPlusUnearnedStdNeed = true;
    this.amtPlusUnearnedStdNeed = new Double(amtPlusUnearnedStdNeed);
  }

  public void setAmtPlusUnearnedStdNeed(Double amtPlusUnearnedStdNeed) {
    this.hasAmtPlusUnearnedStdNeed = true;
    this.amtPlusUnearnedStdNeed = amtPlusUnearnedStdNeed;
  }

  public void setAmtPlusUnearnedStdNeed(Number amtPlusUnearnedStdNeed) {
    this.hasAmtPlusUnearnedStdNeed = true;
    this.amtPlusUnearnedStdNeed = null;
    if (amtPlusUnearnedStdNeed != null) {
      setAmtPlusUnearnedStdNeed(amtPlusUnearnedStdNeed.doubleValue());
    }
  }

  public boolean hasAmtResourceLimitChild() {
    return hasAmtResourceLimitChild;
  }

  public double getAmtResourceLimitChild() {
    if (amtResourceLimitChild == null) {
      return (double) 0;
    }
    return amtResourceLimitChild.doubleValue();
  }

  public Double getAmtResourceLimitChildObject() {
    return amtResourceLimitChild;
  }

  public String getAmtResourceLimitChildString() {
    return FormattingHelper.formatDouble(amtResourceLimitChild);
  }

  public void setAmtResourceLimitChild(double amtResourceLimitChild) {
    this.hasAmtResourceLimitChild = true;
    this.amtResourceLimitChild = new Double(amtResourceLimitChild);
  }

  public void setAmtResourceLimitChild(Double amtResourceLimitChild) {
    this.hasAmtResourceLimitChild = true;
    this.amtResourceLimitChild = amtResourceLimitChild;
  }

  public void setAmtResourceLimitChild(Number amtResourceLimitChild) {
    this.hasAmtResourceLimitChild = true;
    this.amtResourceLimitChild = null;
    if (amtResourceLimitChild != null) {
      setAmtResourceLimitChild(amtResourceLimitChild.doubleValue());
    }
  }

  public boolean hasAmtResourceLimitCrtfdGrp() {
    return hasAmtResourceLimitCrtfdGrp;
  }

  public double getAmtResourceLimitCrtfdGrp() {
    if (amtResourceLimitCrtfdGrp == null) {
      return (double) 0;
    }
    return amtResourceLimitCrtfdGrp.doubleValue();
  }

  public Double getAmtResourceLimitCrtfdGrpObject() {
    return amtResourceLimitCrtfdGrp;
  }

  public String getAmtResourceLimitCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtResourceLimitCrtfdGrp);
  }

  public void setAmtResourceLimitCrtfdGrp(double amtResourceLimitCrtfdGrp) {
    this.hasAmtResourceLimitCrtfdGrp = true;
    this.amtResourceLimitCrtfdGrp = new Double(amtResourceLimitCrtfdGrp);
  }

  public void setAmtResourceLimitCrtfdGrp(Double amtResourceLimitCrtfdGrp) {
    this.hasAmtResourceLimitCrtfdGrp = true;
    this.amtResourceLimitCrtfdGrp = amtResourceLimitCrtfdGrp;
  }

  public void setAmtResourceLimitCrtfdGrp(Number amtResourceLimitCrtfdGrp) {
    this.hasAmtResourceLimitCrtfdGrp = true;
    this.amtResourceLimitCrtfdGrp = null;
    if (amtResourceLimitCrtfdGrp != null) {
      setAmtResourceLimitCrtfdGrp(amtResourceLimitCrtfdGrp.doubleValue());
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

  public boolean hasAmtStdOfNeedAllocMutual() {
    return hasAmtStdOfNeedAllocMutual;
  }

  public double getAmtStdOfNeedAllocMutual() {
    if (amtStdOfNeedAllocMutual == null) {
      return (double) 0;
    }
    return amtStdOfNeedAllocMutual.doubleValue();
  }

  public Double getAmtStdOfNeedAllocMutualObject() {
    return amtStdOfNeedAllocMutual;
  }

  public String getAmtStdOfNeedAllocMutualString() {
    return FormattingHelper.formatDouble(amtStdOfNeedAllocMutual);
  }

  public void setAmtStdOfNeedAllocMutual(double amtStdOfNeedAllocMutual) {
    this.hasAmtStdOfNeedAllocMutual = true;
    this.amtStdOfNeedAllocMutual = new Double(amtStdOfNeedAllocMutual);
  }

  public void setAmtStdOfNeedAllocMutual(Double amtStdOfNeedAllocMutual) {
    this.hasAmtStdOfNeedAllocMutual = true;
    this.amtStdOfNeedAllocMutual = amtStdOfNeedAllocMutual;
  }

  public void setAmtStdOfNeedAllocMutual(Number amtStdOfNeedAllocMutual) {
    this.hasAmtStdOfNeedAllocMutual = true;
    this.amtStdOfNeedAllocMutual = null;
    if (amtStdOfNeedAllocMutual != null) {
      setAmtStdOfNeedAllocMutual(amtStdOfNeedAllocMutual.doubleValue());
    }
  }

  public boolean hasAmtStdOfNeedAllocSngl1() {
    return hasAmtStdOfNeedAllocSngl1;
  }

  public double getAmtStdOfNeedAllocSngl1() {
    if (amtStdOfNeedAllocSngl1 == null) {
      return (double) 0;
    }
    return amtStdOfNeedAllocSngl1.doubleValue();
  }

  public Double getAmtStdOfNeedAllocSngl1Object() {
    return amtStdOfNeedAllocSngl1;
  }

  public String getAmtStdOfNeedAllocSngl1String() {
    return FormattingHelper.formatDouble(amtStdOfNeedAllocSngl1);
  }

  public void setAmtStdOfNeedAllocSngl1(double amtStdOfNeedAllocSngl1) {
    this.hasAmtStdOfNeedAllocSngl1 = true;
    this.amtStdOfNeedAllocSngl1 = new Double(amtStdOfNeedAllocSngl1);
  }

  public void setAmtStdOfNeedAllocSngl1(Double amtStdOfNeedAllocSngl1) {
    this.hasAmtStdOfNeedAllocSngl1 = true;
    this.amtStdOfNeedAllocSngl1 = amtStdOfNeedAllocSngl1;
  }

  public void setAmtStdOfNeedAllocSngl1(Number amtStdOfNeedAllocSngl1) {
    this.hasAmtStdOfNeedAllocSngl1 = true;
    this.amtStdOfNeedAllocSngl1 = null;
    if (amtStdOfNeedAllocSngl1 != null) {
      setAmtStdOfNeedAllocSngl1(amtStdOfNeedAllocSngl1.doubleValue());
    }
  }

  public boolean hasAmtStdOfNeedAllocSngl2() {
    return hasAmtStdOfNeedAllocSngl2;
  }

  public double getAmtStdOfNeedAllocSngl2() {
    if (amtStdOfNeedAllocSngl2 == null) {
      return (double) 0;
    }
    return amtStdOfNeedAllocSngl2.doubleValue();
  }

  public Double getAmtStdOfNeedAllocSngl2Object() {
    return amtStdOfNeedAllocSngl2;
  }

  public String getAmtStdOfNeedAllocSngl2String() {
    return FormattingHelper.formatDouble(amtStdOfNeedAllocSngl2);
  }

  public void setAmtStdOfNeedAllocSngl2(double amtStdOfNeedAllocSngl2) {
    this.hasAmtStdOfNeedAllocSngl2 = true;
    this.amtStdOfNeedAllocSngl2 = new Double(amtStdOfNeedAllocSngl2);
  }

  public void setAmtStdOfNeedAllocSngl2(Double amtStdOfNeedAllocSngl2) {
    this.hasAmtStdOfNeedAllocSngl2 = true;
    this.amtStdOfNeedAllocSngl2 = amtStdOfNeedAllocSngl2;
  }

  public void setAmtStdOfNeedAllocSngl2(Number amtStdOfNeedAllocSngl2) {
    this.hasAmtStdOfNeedAllocSngl2 = true;
    this.amtStdOfNeedAllocSngl2 = null;
    if (amtStdOfNeedAllocSngl2 != null) {
      setAmtStdOfNeedAllocSngl2(amtStdOfNeedAllocSngl2.doubleValue());
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

  public boolean hasAmtSurpDefctEligChild() {
    return hasAmtSurpDefctEligChild;
  }

  public double getAmtSurpDefctEligChild() {
    if (amtSurpDefctEligChild == null) {
      return (double) 0;
    }
    return amtSurpDefctEligChild.doubleValue();
  }

  public Double getAmtSurpDefctEligChildObject() {
    return amtSurpDefctEligChild;
  }

  public String getAmtSurpDefctEligChildString() {
    return FormattingHelper.formatDouble(amtSurpDefctEligChild);
  }

  public void setAmtSurpDefctEligChild(double amtSurpDefctEligChild) {
    this.hasAmtSurpDefctEligChild = true;
    this.amtSurpDefctEligChild = new Double(amtSurpDefctEligChild);
  }

  public void setAmtSurpDefctEligChild(Double amtSurpDefctEligChild) {
    this.hasAmtSurpDefctEligChild = true;
    this.amtSurpDefctEligChild = amtSurpDefctEligChild;
  }

  public void setAmtSurpDefctEligChild(Number amtSurpDefctEligChild) {
    this.hasAmtSurpDefctEligChild = true;
    this.amtSurpDefctEligChild = null;
    if (amtSurpDefctEligChild != null) {
      setAmtSurpDefctEligChild(amtSurpDefctEligChild.doubleValue());
    }
  }

  public boolean hasAmtSurpDefctEligCrtfdGrp() {
    return hasAmtSurpDefctEligCrtfdGrp;
  }

  public double getAmtSurpDefctEligCrtfdGrp() {
    if (amtSurpDefctEligCrtfdGrp == null) {
      return (double) 0;
    }
    return amtSurpDefctEligCrtfdGrp.doubleValue();
  }

  public Double getAmtSurpDefctEligCrtfdGrpObject() {
    return amtSurpDefctEligCrtfdGrp;
  }

  public String getAmtSurpDefctEligCrtfdGrpString() {
    return FormattingHelper.formatDouble(amtSurpDefctEligCrtfdGrp);
  }

  public void setAmtSurpDefctEligCrtfdGrp(double amtSurpDefctEligCrtfdGrp) {
    this.hasAmtSurpDefctEligCrtfdGrp = true;
    this.amtSurpDefctEligCrtfdGrp = new Double(amtSurpDefctEligCrtfdGrp);
  }

  public void setAmtSurpDefctEligCrtfdGrp(Double amtSurpDefctEligCrtfdGrp) {
    this.hasAmtSurpDefctEligCrtfdGrp = true;
    this.amtSurpDefctEligCrtfdGrp = amtSurpDefctEligCrtfdGrp;
  }

  public void setAmtSurpDefctEligCrtfdGrp(Number amtSurpDefctEligCrtfdGrp) {
    this.hasAmtSurpDefctEligCrtfdGrp = true;
    this.amtSurpDefctEligCrtfdGrp = null;
    if (amtSurpDefctEligCrtfdGrp != null) {
      setAmtSurpDefctEligCrtfdGrp(amtSurpDefctEligCrtfdGrp.doubleValue());
    }
  }
  
  public boolean hasAmtSurpDefctStdNeed() {
    return hasAmtSurpDefctStdNeed;
  }

  public double getAmtSurpDefctStdNeed() {
    if (amtSurpDefctStdNeed == null) {
      return (double) 0;
    }
    return amtSurpDefctStdNeed.doubleValue();
  }

  public Double getAmtSurpDefctStdNeedObject() {
    return amtSurpDefctStdNeed;
  }

  public String getAmtSurpDefctStdNeedString() {
    return FormattingHelper.formatDouble(amtSurpDefctStdNeed);
  }

  public void setAmtSurpDefctStdNeed(double amtSurpDefctStdNeed) {
    this.hasAmtSurpDefctStdNeed = true;
    this.amtSurpDefctStdNeed = new Double(amtSurpDefctStdNeed);
  }

  public void setAmtSurpDefctStdNeed(Double amtSurpDefctStdNeed) {
    this.hasAmtSurpDefctStdNeed = true;
    this.amtSurpDefctStdNeed = amtSurpDefctStdNeed;
  }

  public void setAmtSurpDefctStdNeed(Number amtSurpDefctStdNeed) {
    this.hasAmtSurpDefctStdNeed = true;
    this.amtSurpDefctStdNeed = null;
    if (amtSurpDefctStdNeed != null) {
      setAmtSurpDefctStdNeed(amtSurpDefctStdNeed.doubleValue());
    }
  }
  
  public List<FcePersonDB> getAUMembers() {
    return aUMembers;
  }

  public void setAUMembers(List<FcePersonDB> aUMembers) {
    this.hasAUMembers = true;
    this.aUMembers = aUMembers;
  }
  
  public boolean hasCdAllocType() {
    return hasCdAllocType;
  }

  public String getCdAllocType() {
    if (cdAllocType == null) {
      return "";
    }
    return cdAllocType;
  }

  public String getCdAllocTypeObject() {
    return cdAllocType;
  }

  public void setCdAllocType(String cdAllocType) {
    if ((cdAllocType != null) &&
        (cdAllocType.length() > 4)) {
      throw new IllegalStateException("Data is too large for 'cdAllocType'; \n" +
                                      " max size = 4; \n" +
                                      " data = '" + cdAllocType + "'");
    }
    this.hasCdAllocType = true;
    this.cdAllocType = cdAllocType;
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

  public boolean hasCdDeemIndivRel1() {
    return hasCdDeemIndivRel1;
  }

  public String getCdDeemIndivRel1() {
    if (cdDeemIndivRel1 == null) {
      return "";
    }
    return cdDeemIndivRel1;
  }

  public String getCdDeemIndivRel1Object() {
    return cdDeemIndivRel1;
  }

  public void setCdDeemIndivRel1(String cdDeemIndivRel1) {
    if ((cdDeemIndivRel1 != null) && (cdDeemIndivRel1.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdDeemIndivRel1'; \n" + " max size = 3; \n" + " data = '"
                                      + cdDeemIndivRel1 + "'");
    }
    this.hasCdDeemIndivRel1 = true;
    this.cdDeemIndivRel1 = cdDeemIndivRel1;
  }

  public boolean hasCdDeemIndivRel2() {
    return hasCdDeemIndivRel2;
  }

  public String getCdDeemIndivRel2() {
    if (cdDeemIndivRel2 == null) {
      return "";
    }
    return cdDeemIndivRel2;
  }

  public String getCdDeemIndivRel2Object() {
    return cdDeemIndivRel2;
  }

  public void setCdDeemIndivRel2(String cdDeemIndivRel2) {
    if ((cdDeemIndivRel2 != null) && (cdDeemIndivRel2.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdDeemIndivRel2'; \n" + " max size = 3; \n" + " data = '"
                                      + cdDeemIndivRel2 + "'");
    }
    this.hasCdDeemIndivRel2 = true;
    this.cdDeemIndivRel2 = cdDeemIndivRel2;
  }

  public boolean hasCdDeemSurplusOrDeficit() {
    return hasCdDeemSurplusOrDeficit;
  }

  public String getCdDeemSurplusOrDeficit() {
    if (cdDeemSurplusOrDeficit == null) {
      return "";
    }
    return cdDeemSurplusOrDeficit;
  }

  public String getCdDeemSurplusOrDeficitObject() {
    return cdDeemSurplusOrDeficit;
  }

  public void setCdDeemSurplusOrDeficit(String cdDeemSurplusOrDeficit) {
    if ((cdDeemSurplusOrDeficit != null) && (cdDeemSurplusOrDeficit.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdDeemSurplusOrDeficit'; \n" + " max size = 3; \n"
                                      + " data = '" + cdDeemSurplusOrDeficit + "'");
    }
    this.hasCdDeemSurplusOrDeficit = true;
    this.cdDeemSurplusOrDeficit = cdDeemSurplusOrDeficit;
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

  public boolean hasCdEligSurpDefctChild() {
    return hasCdEligSurpDefctChild;
  }

  public String getCdEligSurpDefctChild() {
    if (cdEligSurpDefctChild == null) {
      return "";
    }
    return cdEligSurpDefctChild;
  }

  public String getCdEligSurpDefctChildObject() {
    return cdEligSurpDefctChild;
  }

  public void setCdEligSurpDefctChild(String cdEligSurpDefctChild) {
    if ((cdEligSurpDefctChild != null) &&
        (cdEligSurpDefctChild.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdEligSurpDefctChild'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdEligSurpDefctChild + "'");
    }
    this.hasCdEligSurpDefctChild = true;
    this.cdEligSurpDefctChild = cdEligSurpDefctChild;
  }
  
  public boolean hasCdEligSurpDefctCrtfdGrp() {
    return hasCdEligSurpDefctCrtfdGrp;
  }

  public String getCdEligSurpDefctCrtfdGrp() {
    if (cdEligSurpDefctCrtfdGrp == null) {
      return "";
    }
    return cdEligSurpDefctCrtfdGrp;
  }

  public String getCdEligSurpDefctCrtfdGrpObject() {
    return cdEligSurpDefctCrtfdGrp;
  }

  public void setCdEligSurpDefctCrtfdGrp(String cdEligSurpDefctCrtfdGrp) {
    if ((cdEligSurpDefctCrtfdGrp != null) &&
        (cdEligSurpDefctCrtfdGrp.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdEligSurpDefctCrtfdGrp'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdEligSurpDefctCrtfdGrp + "'");
    }
    this.hasCdEligSurpDefctCrtfdGrp = true;
    this.cdEligSurpDefctCrtfdGrp = cdEligSurpDefctCrtfdGrp;
  }

  public boolean hasCdGicSurpDefctChild() {
    return hasCdGicSurpDefctChild;
  }

  public String getCdGicSurpDefctChild() {
    if (cdGicSurpDefctChild == null) {
      return "";
    }
    return cdGicSurpDefctChild;
  }

  public String getCdGicSurpDefctChildObject() {
    return cdGicSurpDefctChild;
  }

  public void setCdGicSurpDefctChild(String cdGicSurpDefctChild) {
    if ((cdGicSurpDefctChild != null) &&
        (cdGicSurpDefctChild.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdGicSurpDefctChild'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdGicSurpDefctChild + "'");
    }
    this.hasCdGicSurpDefctChild = true;
    this.cdGicSurpDefctChild = cdGicSurpDefctChild;
  }

  public boolean hasCdGicSurpDefctCrtfdGrp() {
    return hasCdGicSurpDefctCrtfdGrp;
  }

  public String getCdGicSurpDefctCrtfdGrp() {
    if (cdGicSurpDefctCrtfdGrp == null) {
      return "";
    }
    return cdGicSurpDefctCrtfdGrp;
  }

  public String getCdGicSurpDefctCrtfdGrpObject() {
    return cdGicSurpDefctCrtfdGrp;
  }

  public void setCdGicSurpDefctCrtfdGrp(String cdGicSurpDefctCrtfdGrp) {
    if ((cdGicSurpDefctCrtfdGrp != null) &&
        (cdGicSurpDefctCrtfdGrp.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdGicSurpDefctCrtfdGrp'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdGicSurpDefctCrtfdGrp + "'");
    }
    this.hasCdGicSurpDefctCrtfdGrp = true;
    this.cdGicSurpDefctCrtfdGrp = cdGicSurpDefctCrtfdGrp;
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

  public boolean hasCdStdTestSurpDefct() {
    return hasCdStdTestSurpDefct;
  }

  public String getCdStdTestSurpDefct() {
    if (cdStdTestSurpDefct == null) {
      return "";
    }
    return cdStdTestSurpDefct;
  }

  public String getCdStdTestSurpDefctObject() {
    return cdStdTestSurpDefct;
  }

  public void setCdStdTestSurpDefct(String cdStdTestSurpDefct) {
    if ((cdStdTestSurpDefct != null) &&
        (cdStdTestSurpDefct.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdStdTestSurpDefct'; \n" +
                                      " max size = 3; \n" +
                                      " data = '" + cdStdTestSurpDefct + "'");
    }
    this.hasCdStdTestSurpDefct = true;
    this.cdStdTestSurpDefct = cdStdTestSurpDefct;
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

  public boolean hasIdPersonAllocMutual1() {
    return hasIdPersonAllocMutual1;
  }

  public long getIdPersonAllocMutual1() {
    if (idPersonAllocMutual1 == null) {
      return (long) 0;
    }
    return idPersonAllocMutual1.longValue();
  }

  public Long getIdPersonAllocMutual1Object() {
    return idPersonAllocMutual1;
  }

  public String getIdPersonAllocMutual1String() {
    return FormattingHelper.formatLong(idPersonAllocMutual1);
  }

  public void setIdPersonAllocMutual1(long idPersonAllocMutual1) {
    this.hasIdPersonAllocMutual1 = true;
    if (idPersonAllocMutual1 == 0) {
      this.idPersonAllocMutual1 = null;
      return;
    }
    this.idPersonAllocMutual1 = new Long(idPersonAllocMutual1);
  }

  public void setIdPersonAllocMutual1(Long idPersonAllocMutual1) {
    this.hasIdPersonAllocMutual1 = true;
    this.idPersonAllocMutual1 = idPersonAllocMutual1;
  }

  public void setIdPersonAllocMutual1(Number idPersonAllocMutual1) {
    this.hasIdPersonAllocMutual1 = true;
    this.idPersonAllocMutual1 = null;
    if (idPersonAllocMutual1 != null) {
      setIdPersonAllocMutual1(idPersonAllocMutual1.longValue());
    }
  }

  public boolean hasIdPersonAllocMutual2() {
    return hasIdPersonAllocMutual2;
  }

  public long getIdPersonAllocMutual2() {
    if (idPersonAllocMutual2 == null) {
      return (long) 0;
    }
    return idPersonAllocMutual2.longValue();
  }

  public Long getIdPersonAllocMutual2Object() {
    return idPersonAllocMutual2;
  }

  public String getIdPersonAllocMutual2String() {
    return FormattingHelper.formatLong(idPersonAllocMutual2);
  }

  public void setIdPersonAllocMutual2(long idPersonAllocMutual2) {
    this.hasIdPersonAllocMutual2 = true;
    if (idPersonAllocMutual2 == 0) {
      this.idPersonAllocMutual2 = null;
      return;
    }
    this.idPersonAllocMutual2 = new Long(idPersonAllocMutual2);
  }

  public void setIdPersonAllocMutual2(Long idPersonAllocMutual2) {
    this.hasIdPersonAllocMutual2 = true;
    this.idPersonAllocMutual2 = idPersonAllocMutual2;
  }

  public void setIdPersonAllocMutual2(Number idPersonAllocMutual2) {
    this.hasIdPersonAllocMutual2 = true;
    this.idPersonAllocMutual2 = null;
    if (idPersonAllocMutual2 != null) {
      setIdPersonAllocMutual2(idPersonAllocMutual2.longValue());
    }
  }

  public boolean hasIdPersonAllocSngl1() {
    return hasIdPersonAllocSngl1;
  }

  public long getIdPersonAllocSngl1() {
    if (idPersonAllocSngl1 == null) {
      return (long) 0;
    }
    return idPersonAllocSngl1.longValue();
  }

  public Long getIdPersonAllocSngl1Object() {
    return idPersonAllocSngl1;
  }

  public String getIdPersonAllocSngl1String() {
    return FormattingHelper.formatLong(idPersonAllocSngl1);
  }

  public void setIdPersonAllocSngl1(long idPersonAllocSngl1) {
    this.hasIdPersonAllocSngl1 = true;
    if (idPersonAllocSngl1 == 0) {
      this.idPersonAllocSngl1 = null;
      return;
    }
    this.idPersonAllocSngl1 = new Long(idPersonAllocSngl1);
  }

  public void setIdPersonAllocSngl1(Long idPersonAllocSngl1) {
    this.hasIdPersonAllocSngl1 = true;
    this.idPersonAllocSngl1 = idPersonAllocSngl1;
  }

  public void setIdPersonAllocSngl1(Number idPersonAllocSngl1) {
    this.hasIdPersonAllocSngl1 = true;
    this.idPersonAllocSngl1 = null;
    if (idPersonAllocSngl1 != null) {
      setIdPersonAllocSngl1(idPersonAllocSngl1.longValue());
    }
  }

  public boolean hasIdPersonAllocSngl2() {
    return hasIdPersonAllocSngl2;
  }

  public long getIdPersonAllocSngl2() {
    if (idPersonAllocSngl2 == null) {
      return (long) 0;
    }
    return idPersonAllocSngl2.longValue();
  }

  public Long getIdPersonAllocSngl2Object() {
    return idPersonAllocSngl2;
  }

  public String getIdPersonAllocSngl2String() {
    return FormattingHelper.formatLong(idPersonAllocSngl2);
  }

  public void setIdPersonAllocSngl2(long idPersonAllocSngl2) {
    this.hasIdPersonAllocSngl2 = true;
    if (idPersonAllocSngl2 == 0) {
      this.idPersonAllocSngl2 = null;
      return;
    }
    this.idPersonAllocSngl2 = new Long(idPersonAllocSngl2);
  }

  public void setIdPersonAllocSngl2(Long idPersonAllocSngl2) {
    this.hasIdPersonAllocSngl2 = true;
    this.idPersonAllocSngl2 = idPersonAllocSngl2;
  }

  public void setIdPersonAllocSngl2(Number idPersonAllocSngl2) {
    this.hasIdPersonAllocSngl2 = true;
    this.idPersonAllocSngl2 = null;
    if (idPersonAllocSngl2 != null) {
      setIdPersonAllocSngl2(idPersonAllocSngl2.longValue());
    }
  }

  public boolean hasIdPersonDeemIndiv1() {
    return hasIdPersonDeemIndiv1;
  }

  public long getIdPersonDeemIndiv1() {
    if (idPersonDeemIndiv1 == null) {
      return (long) 0;
    }
    return idPersonDeemIndiv1.longValue();
  }

  public Long getIdPersonDeemIndiv1Object() {
    return idPersonDeemIndiv1;
  }

  public String getIdPersonDeemIndiv1String() {
    return FormattingHelper.formatLong(idPersonDeemIndiv1);
  }

  public void setIdPersonDeemIndiv1(long idPersonDeemIndiv1) {
    this.hasIdPersonDeemIndiv1 = true;
    if (idPersonDeemIndiv1 == 0) {
      this.idPersonDeemIndiv1 = null;
      return;
    }
    this.idPersonDeemIndiv1 = new Long(idPersonDeemIndiv1);
  }

  public void setIdPersonDeemIndiv1(Long idPersonDeemIndiv1) {
    this.hasIdPersonDeemIndiv1 = true;
    this.idPersonDeemIndiv1 = idPersonDeemIndiv1;
  }

  public void setIdPersonDeemIndiv1(Number idPersonDeemIndiv1) {
    this.hasIdPersonDeemIndiv1 = true;
    this.idPersonDeemIndiv1 = null;
    if (idPersonDeemIndiv1 != null) {
      setIdPersonDeemIndiv1(idPersonDeemIndiv1.longValue());
    }
  }

  public boolean hasIdPersonDeemIndiv2() {
    return hasIdPersonDeemIndiv2;
  }

  public long getIdPersonDeemIndiv2() {
    if (idPersonDeemIndiv2 == null) {
      return (long) 0;
    }
    return idPersonDeemIndiv2.longValue();
  }

  public Long getIdPersonDeemIndiv2Object() {
    return idPersonDeemIndiv2;
  }

  public String getIdPersonDeemIndiv2String() {
    return FormattingHelper.formatLong(idPersonDeemIndiv2);
  }

  public void setIdPersonDeemIndiv2(long idPersonDeemIndiv2) {
    this.hasIdPersonDeemIndiv2 = true;
    if (idPersonDeemIndiv2 == 0) {
      this.idPersonDeemIndiv2 = null;
      return;
    }
    this.idPersonDeemIndiv2 = new Long(idPersonDeemIndiv2);
  }

  public void setIdPersonDeemIndiv2(Long idPersonDeemIndiv2) {
    this.hasIdPersonDeemIndiv2 = true;
    this.idPersonDeemIndiv2 = idPersonDeemIndiv2;
  }

  public void setIdPersonDeemIndiv2(Number idPersonDeemIndiv2) {
    this.hasIdPersonDeemIndiv2 = true;
    this.idPersonDeemIndiv2 = null;
    if (idPersonDeemIndiv2 != null) {
      setIdPersonDeemIndiv2(idPersonDeemIndiv2.longValue());
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

  public boolean hasCdDeemRespType() {
    return hasCdDeemRespType;
  }

  public String getCdDeemRespType() {
    if (cdDeemRespType == null) {
      return "";
    }
    return cdDeemRespType;
  }

  public String getCdDeemRespTypeObject() {
    return cdDeemRespType;
  }

  public void setCdDeemRespType(String cdDeemRespType) {
    if ((cdDeemRespType != null) && (cdDeemRespType.length() > 3)) {
      throw new IllegalStateException("Data is too large for 'cdDeemRespType'; \n" + " max size = 3; \n" + " data = '"
                                      + cdDeemRespType + "'");
    }
    this.hasCdDeemRespType = true;
    this.cdDeemRespType = cdDeemRespType;
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

  public boolean hasIndChildEquity() {
    return hasIndChildEquity;
  }

  public boolean getIndChildEquity() {
    if (indChildEquity == null) {
      return false;
    }
    return indChildEquity.booleanValue();
  }

  public Boolean getIndChildEquityObject() {
    return indChildEquity;
  }

  public String getIndChildEquityString() {
    if (indChildEquity == null) {
      return "";
    }
    return indChildEquity.toString();
  }

  public void setIndChildEquity(boolean indChildEquity) {
    this.hasIndChildEquity = true;
    this.indChildEquity = new Boolean(indChildEquity);
  }

  public void setIndChildEquity(Boolean indChildEquity) {
    this.hasIndChildEquity = true;
    this.indChildEquity = indChildEquity;
  }

  public void setIndChildEquity(String indChildEquity) {
    this.hasIndEquity = true;
    this.indChildEquity = isTrueBoolean(indChildEquity);
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

  public boolean hasNbrDeemChildNotInAU() {
    return hasNbrDeemChildNotInAU;
  }

  public long getNbrDeemChildNotInAU() {
    if (nbrDeemChildNotInAU == null) {
      return (long) 0;
    }
    return nbrDeemChildNotInAU.longValue();
  }

  public Long getNbrDeemChildNotInAUObject() {
    return nbrDeemChildNotInAU;
  }

  public String getNbrDeemChildNotInAUString() {
    return FormattingHelper.formatLong(nbrDeemChildNotInAU);
  }

  public void setNbrDeemChildNotInAU(long nbrDeemChildNotInAU) {
    this.hasNbrDeemChildNotInAU = true;
    if (nbrDeemChildNotInAU == 0) {
      this.nbrDeemChildNotInAU = null;
      return;
    }
    this.nbrDeemChildNotInAU = new Long(nbrDeemChildNotInAU);
  }

  public void setNbrDeemChildNotInAU(Long nbrDeemChildNotInAU) {
    this.hasNbrDeemChildNotInAU = true;
    this.nbrDeemChildNotInAU = nbrDeemChildNotInAU;
  }

  public void setNbrDeemChildNotInAU(Number nbrDeemChildNotInAU) {
    this.hasNbrDeemChildNotInAU = true;
    this.nbrDeemChildNotInAU = null;
    if (nbrDeemChildNotInAU != null) {
      setNbrDeemChildNotInAU(nbrDeemChildNotInAU.longValue());
    }
  }

  public boolean hasNbrDeemResponseIndiv() {
    return hasNbrDeemResponseIndiv;
  }

  public long getNbrDeemResponseIndiv() {
    if (nbrDeemResponseIndiv == null) {
      return (long) 0;
    }
    return nbrDeemResponseIndiv.longValue();
  }

  public Long getNbrDeemResponseIndivObject() {
    return nbrDeemResponseIndiv;
  }

  public String getNbrDeemResponseIndivString() {
    return FormattingHelper.formatLong(nbrDeemResponseIndiv);
  }

  public void setNbrDeemResponseIndiv(long nbrDeemResponseIndiv) {
    this.hasNbrDeemResponseIndiv = true;
    if (nbrDeemResponseIndiv == 0) {
      this.nbrDeemResponseIndiv = null;
      return;
    }
    this.nbrDeemResponseIndiv = new Long(nbrDeemResponseIndiv);
  }

  public void setNbrDeemResponseIndiv(Long nbrDeemResponseIndiv) {
    this.hasNbrDeemResponseIndiv = true;
    this.nbrDeemResponseIndiv = nbrDeemResponseIndiv;
  }

  public void setNbrDeemResponseIndiv(Number nbrDeemResponseIndiv) {
    this.hasNbrDeemResponseIndiv = true;
    this.nbrDeemResponseIndiv = null;
    if (nbrDeemResponseIndiv != null) {
      setNbrDeemResponseIndiv(nbrDeemResponseIndiv.longValue());
    }
  }

  public boolean hasNbrDeemPersonSONLookup() {
    return hasNbrDeemPersonSONLookup;
  }

  public long getNbrDeemPersonSONLookup() {
    if (nbrDeemPersonSONLookup == null) {
      return (long) 0;
    }
    return nbrDeemPersonSONLookup.longValue();
  }

  public Long getNbrDeemPersonSONLookupObject() {
    return nbrDeemPersonSONLookup;
  }

  public String getNbrDeemPersonSONLookupString() {
    return FormattingHelper.formatLong(nbrDeemPersonSONLookup);
  }

  public void setNbrDeemPersonSONLookup(long nbrDeemPersonSONLookup) {
    this.hasNbrDeemPersonSONLookup = true;
    if (nbrDeemPersonSONLookup == 0) {
      this.nbrDeemPersonSONLookup = null;
      return;
    }
    this.nbrDeemPersonSONLookup = new Long(nbrDeemPersonSONLookup);
  }

  public void setNbrDeemPersonSONLookup(Long nbrDeemPersonSONLookup) {
    this.hasNbrDeemPersonSONLookup = true;
    this.nbrDeemPersonSONLookup = nbrDeemPersonSONLookup;
  }

  public void setNbrDeemPersonSONLookup(Number nbrDeemPersonSONLookup) {
    this.hasNbrDeemPersonSONLookup = true;
    this.nbrDeemPersonSONLookup = null;
    if (nbrDeemPersonSONLookup != null) {
      setNbrDeemPersonSONLookup(nbrDeemPersonSONLookup.longValue());
    }
  }

  public boolean hasNbrDeemTaxDependNotInAU() {
    return hasNbrDeemTaxDependNotInAU;
  }

  public long getNbrDeemTaxDependNotInAU() {
    if (nbrDeemTaxDependNotInAU == null) {
      return (long) 0;
    }
    return nbrDeemTaxDependNotInAU.longValue();
  }

  public Long getNbrDeemTaxDependNotInAUObject() {
    return nbrDeemTaxDependNotInAU;
  }

  public String getNbrDeemTaxDependNotInAUString() {
    return FormattingHelper.formatLong(nbrDeemTaxDependNotInAU);
  }

  public void setNbrDeemTaxDependNotInAU(long nbrDeemTaxDependNotInAU) {
    this.hasNbrDeemTaxDependNotInAU = true;
    if (nbrDeemTaxDependNotInAU == 0) {
      this.nbrDeemTaxDependNotInAU = null;
      return;
    }
    this.nbrDeemTaxDependNotInAU = new Long(nbrDeemTaxDependNotInAU);
  }

  public void setNbrDeemTaxDependNotInAU(Long nbrDeemTaxDependNotInAU) {
    this.hasNbrDeemTaxDependNotInAU = true;
    this.nbrDeemTaxDependNotInAU = nbrDeemTaxDependNotInAU;
  }

  public void setNbrDeemTaxDependNotInAU(Number nbrDeemTaxDependNotInAU) {
    this.hasNbrDeemTaxDependNotInAU = true;
    this.nbrDeemTaxDependNotInAU = null;
    if (nbrDeemTaxDependNotInAU != null) {
      setNbrDeemTaxDependNotInAU(nbrDeemTaxDependNotInAU.longValue());
    }
  }

  public boolean hasNbrIneligChildAllocMutual() {
    return hasNbrIneligChildAllocMutual;
  }

  public long getNbrIneligChildAllocMutual() {
    if (nbrIneligChildAllocMutual == null) {
      return (long) 0;
    }
    return nbrIneligChildAllocMutual.longValue();
  }

  public Long getNbrIneligChildAllocMutualObject() {
    return nbrIneligChildAllocMutual;
  }

  public String getNbrIneligChildAllocMutualString() {
    return FormattingHelper.formatLong(nbrIneligChildAllocMutual);
  }

  public void setNbrIneligChildAllocMutual(long nbrIneligChildAllocMutual) {
    this.hasNbrIneligChildAllocMutual = true;
    if (nbrIneligChildAllocMutual == 0) {
      this.nbrIneligChildAllocMutual = null;
      return;
    }
    this.nbrIneligChildAllocMutual = new Long(nbrIneligChildAllocMutual);
  }

  public void setNbrIneligChildAllocMutual(Long nbrIneligChildAllocMutual) {
    this.hasNbrIneligChildAllocMutual = true;
    this.nbrIneligChildAllocMutual = nbrIneligChildAllocMutual;
  }

  public void setNbrIneligChildAllocMutual(Number nbrIneligChildAllocMutual) {
    this.hasNbrIneligChildAllocMutual = true;
    this.nbrIneligChildAllocMutual = null;
    if (nbrIneligChildAllocMutual != null) {
      setNbrIneligChildAllocMutual(nbrIneligChildAllocMutual.longValue());
    }
  }

  public boolean hasNbrIneligChildAllocSngl1() {
    return hasNbrIneligChildAllocSngl1;
  }

  public long getNbrIneligChildAllocSngl1() {
    if (nbrIneligChildAllocSngl1 == null) {
      return (long) 0;
    }
    return nbrIneligChildAllocSngl1.longValue();
  }

  public Long getNbrIneligChildAllocSngl1Object() {
    return nbrIneligChildAllocSngl1;
  }

  public String getNbrIneligChildAllocSngl1String() {
    return FormattingHelper.formatLong(nbrIneligChildAllocSngl1);
  }

  public void setNbrIneligChildAllocSngl1(long nbrIneligChildAllocSngl1) {
    this.hasNbrIneligChildAllocSngl1 = true;
    if (nbrIneligChildAllocSngl1 == 0) {
      this.nbrIneligChildAllocSngl1 = null;
      return;
    }
    this.nbrIneligChildAllocSngl1 = new Long(nbrIneligChildAllocSngl1);
  }

  public void setNbrIneligChildAllocSngl1(Long nbrIneligChildAllocSngl1) {
    this.hasNbrIneligChildAllocSngl1 = true;
    this.nbrIneligChildAllocSngl1 = nbrIneligChildAllocSngl1;
  }

  public void setNbrIneligChildAllocSngl1(Number nbrIneligChildAllocSngl1) {
    this.hasNbrIneligChildAllocSngl1 = true;
    this.nbrIneligChildAllocSngl1 = null;
    if (nbrIneligChildAllocSngl1 != null) {
      setNbrIneligChildAllocSngl1(nbrIneligChildAllocSngl1.longValue());
    }
  }

  public boolean hasNbrIneligChildAllocSngl2() {
    return hasNbrIneligChildAllocSngl2;
  }

  public long getNbrIneligChildAllocSngl2() {
    if (nbrIneligChildAllocSngl2 == null) {
      return (long) 0;
    }
    return nbrIneligChildAllocSngl2.longValue();
  }

  public Long getNbrIneligChildAllocSngl2Object() {
    return nbrIneligChildAllocSngl2;
  }

  public String getNbrIneligChildAllocSngl2String() {
    return FormattingHelper.formatLong(nbrIneligChildAllocSngl2);
  }

  public void setNbrIneligChildAllocSngl2(long nbrIneligChildAllocSngl2) {
    this.hasNbrIneligChildAllocSngl2 = true;
    if (nbrIneligChildAllocSngl2 == 0) {
      this.nbrIneligChildAllocSngl2 = null;
      return;
    }
    this.nbrIneligChildAllocSngl2 = new Long(nbrIneligChildAllocSngl2);
  }

  public void setNbrIneligChildAllocSngl2(Long nbrIneligChildAllocSngl2) {
    this.hasNbrIneligChildAllocSngl2 = true;
    this.nbrIneligChildAllocSngl2 = nbrIneligChildAllocSngl2;
  }

  public void setNbrIneligChildAllocSngl2(Number nbrIneligChildAllocSngl2) {
    this.hasNbrIneligChildAllocSngl2 = true;
    this.nbrIneligChildAllocSngl2 = null;
    if (nbrIneligChildAllocSngl2 != null) {
      setNbrIneligChildAllocSngl2(nbrIneligChildAllocSngl2.longValue());
    }
  }

  public boolean hasNbrIneligPersonAllocMutual() {
    return hasNbrIneligPersonAllocMutual;
  }

  public long getNbrIneligPersonAllocMutual() {
    if (nbrIneligPersonAllocMutual == null) {
      return (long) 0;
    }
    return nbrIneligPersonAllocMutual.longValue();
  }

  public Long getNbrIneligPersonAllocMutualObject() {
    return nbrIneligPersonAllocMutual;
  }

  public String getNbrIneligPersonAllocMutualString() {
    return "" + nbrIneligPersonAllocMutual;
  }

  public void setNbrIneligPersonAllocMutual(long nbrIneligPersonAllocMutual) {
    this.hasNbrIneligPersonAllocMutual = true;
    this.nbrIneligPersonAllocMutual = new Long(nbrIneligPersonAllocMutual);
  }

  public void setNbrIneligPersonAllocMutual(Long nbrIneligPersonAllocMutual) {
    if (nbrIneligPersonAllocMutual != null) {
      this.hasNbrIneligPersonAllocMutual = true;
      this.nbrIneligPersonAllocMutual = nbrIneligPersonAllocMutual;
    }
  }

  public void setNbrIneligPersonAllocMutual(Number nbrIneligPersonAllocMutual) {
    this.hasNbrIneligPersonAllocMutual = true;
    this.nbrIneligPersonAllocMutual = null;
    if (nbrIneligPersonAllocMutual != null) {
      setNbrIneligPersonAllocMutual(nbrIneligPersonAllocMutual.longValue());
    }
  }

  public boolean hasNbrIneligPersonAllocSngl1() {
    return hasNbrIneligPersonAllocSngl1;
  }

  public long getNbrIneligPersonAllocSngl1() {
    if (nbrIneligPersonAllocSngl1 == null) {
      return (long) 0;
    }
    return nbrIneligPersonAllocSngl1.longValue();
  }

  public Long getNbrIneligPersonAllocSngl1Object() {
    return nbrIneligPersonAllocSngl1;
  }

  public String getNbrIneligPersonAllocSngl1String() {
    return "" + nbrIneligPersonAllocSngl1;
  }

  public void setNbrIneligPersonAllocSngl1(long nbrIneligPersonAllocSngl1) {
    this.hasNbrIneligPersonAllocSngl1 = true;
    this.nbrIneligPersonAllocSngl1 = new Long(nbrIneligPersonAllocSngl1);
  }

  public void setNbrIneligPersonAllocSngl1(Long nbrIneligPersonAllocSngl1) {
    if (nbrIneligPersonAllocSngl1 != null) {
      this.hasNbrIneligPersonAllocSngl1 = true;
      this.nbrIneligPersonAllocSngl1 = nbrIneligPersonAllocSngl1;
    }
  }

  public void setNbrIneligPersonAllocSngl1(Number nbrIneligPersonAllocSngl1) {
    this.hasNbrIneligPersonAllocSngl1 = true;
    this.nbrIneligPersonAllocSngl1 = null;
    if (nbrIneligPersonAllocSngl1 != null) {
      setNbrIneligPersonAllocSngl1(nbrIneligPersonAllocSngl1.longValue());
    }
  }

  public boolean hasNbrIneligPersonAllocSngl2() {
    return hasNbrIneligPersonAllocSngl2;
  }

  public long getNbrIneligPersonAllocSngl2() {
    if (nbrIneligChildAllocSngl2 == null) {
      return (long) 0;
    }
    return nbrIneligChildAllocSngl2.longValue();
  }

  public Long getNbrIneligPersonAllocSngl2Object() {
    return nbrIneligChildAllocSngl2;
  }

  public String getNbrIneligPersonAllocSngl2String() {
    return "" + nbrIneligChildAllocSngl2;
  }

  public void setNbrIneligPersonAllocSngl2(long nbrIneligChildAllocSngl2) {
    this.hasNbrIneligPersonAllocSngl2 = true;
    this.nbrIneligChildAllocSngl2 = new Long(nbrIneligChildAllocSngl2);
  }

  public void setNbrIneligPersonAllocSngl2(Long nbrIneligChildAllocSngl2) {
    if (nbrIneligChildAllocSngl2 != null) {
      this.hasNbrIneligPersonAllocSngl2 = true;
      this.nbrIneligChildAllocSngl2 = nbrIneligChildAllocSngl2;
    }
  }

  public void setNbrIneligPersonAllocSngl2(Number nbrIneligChildAllocSngl2) {
    this.hasNbrIneligPersonAllocSngl2 = true;
    this.nbrIneligChildAllocSngl2 = null;
    if (nbrIneligChildAllocSngl2 != null) {
      setNbrIneligPersonAllocSngl2(nbrIneligChildAllocSngl2.longValue());
    }
  }

  public boolean hasNbrIneligSpouseAllocMutual() {
    return hasNbrIneligSpouseAllocMutual;
  }

  public long getNbrIneligSpouseAllocMutual() {
    if (nbrIneligSpouseAllocMutual == null) {
      return (long) 0;
    }
    return nbrIneligSpouseAllocMutual.longValue();
  }

  public Long getNbrIneligSpouseAllocMutualObject() {
    return nbrIneligSpouseAllocMutual;
  }

  public String getNbrIneligSpouseAllocMutualString() {
    return FormattingHelper.formatLong(nbrIneligSpouseAllocMutual);
  }

  public void setNbrIneligSpouseAllocMutual(long nbrIneligSpouseAllocMutual) {
    this.hasNbrIneligSpouseAllocMutual = true;
    if (nbrIneligSpouseAllocMutual == 0) {
      this.nbrIneligSpouseAllocMutual = null;
      return;
    }
    this.nbrIneligSpouseAllocMutual = new Long(nbrIneligSpouseAllocMutual);
  }

  public void setNbrIneligSpouseAllocMutual(Long nbrIneligSpouseAllocMutual) {
    this.hasNbrIneligSpouseAllocMutual = true;
    this.nbrIneligSpouseAllocMutual = nbrIneligSpouseAllocMutual;
  }

  public void setNbrIneligSpouseAllocMutual(Number nbrIneligSpouseAllocMutual) {
    this.hasNbrIneligSpouseAllocMutual = true;
    this.nbrIneligSpouseAllocMutual = null;
    if (nbrIneligSpouseAllocMutual != null) {
      setNbrIneligSpouseAllocMutual(nbrIneligSpouseAllocMutual.longValue());
    }
  }

  public boolean hasNbrIneligSpouseAllocSngl1() {
    return hasNbrIneligSpouseAllocSngl1;
  }

  public long getNbrIneligSpouseAllocSngl1() {
    if (nbrIneligSpouseAllocSngl1 == null) {
      return (long) 0;
    }
    return nbrIneligSpouseAllocSngl1.longValue();
  }

  public Long getNbrIneligSpouseAllocSngl1Object() {
    return nbrIneligSpouseAllocSngl1;
  }

  public String getNbrIneligSpouseAllocSngl1String() {
    return FormattingHelper.formatLong(nbrIneligSpouseAllocSngl1);
  }

  public void setNbrIneligSpouseAllocSngl1(long nbrIneligSpouseAllocSngl1) {
    this.hasNbrIneligSpouseAllocSngl1 = true;
    if (nbrIneligSpouseAllocSngl1 == 0) {
      this.nbrIneligSpouseAllocSngl1 = null;
      return;
    }
    this.nbrIneligSpouseAllocSngl1 = new Long(nbrIneligSpouseAllocSngl1);
  }

  public void setNbrIneligSpouseAllocSngl1(Long nbrIneligSpouseAllocSngl1) {
    this.hasNbrIneligSpouseAllocSngl1 = true;
    this.nbrIneligSpouseAllocSngl1 = nbrIneligSpouseAllocSngl1;
  }

  public void setNbrIneligSpouseAllocSngl1(Number nbrIneligSpouseAllocSngl1) {
    this.hasNbrIneligSpouseAllocSngl1 = true;
    this.nbrIneligSpouseAllocSngl1 = null;
    if (nbrIneligSpouseAllocSngl1 != null) {
      setNbrIneligSpouseAllocSngl1(nbrIneligSpouseAllocSngl1.longValue());
    }
  }

  public boolean hasNbrIneligSpouseAllocSngl2() {
    return hasNbrIneligSpouseAllocSngl2;
  }

  public long getNbrIneligSpouseAllocSngl2() {
    if (nbrIneligSpouseAllocSngl2 == null) {
      return (long) 0;
    }
    return nbrIneligSpouseAllocSngl2.longValue();
  }

  public Long getNbrIneligSpouseAllocSngl2Object() {
    return nbrIneligSpouseAllocSngl2;
  }

  public String getNbrIneligSpouseAllocSngl2String() {
    return FormattingHelper.formatLong(nbrIneligSpouseAllocSngl2);
  }

  public void setNbrIneligSpouseAllocSngl2(long nbrIneligSpouseAllocSngl2) {
    this.hasNbrIneligSpouseAllocSngl2 = true;
    if (nbrIneligSpouseAllocSngl2 == 0) {
      this.nbrIneligSpouseAllocSngl2 = null;
      return;
    }
    this.nbrIneligSpouseAllocSngl2 = new Long(nbrIneligSpouseAllocSngl2);
  }

  public void setNbrIneligSpouseAllocSngl2(Long nbrIneligSpouseAllocSngl2) {
    this.hasNbrIneligSpouseAllocSngl2 = true;
    this.nbrIneligSpouseAllocSngl2 = nbrIneligSpouseAllocSngl2;
  }

  public void setNbrIneligSpouseAllocSngl2(Number nbrIneligSpouseAllocSngl2) {
    this.hasNbrIneligSpouseAllocSngl2 = true;
    this.nbrIneligSpouseAllocSngl2 = null;
    if (nbrIneligSpouseAllocSngl2 != null) {
      setNbrIneligSpouseAllocSngl2(nbrIneligSpouseAllocSngl2.longValue());
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

  public List<FcePersonDB> getNonAUMembers() {
    return nonAUMembers;
  }

  public void setNonAUMembers(List<FcePersonDB> nonAUMembers) {
    this.hasNonAUMembers = true;
    this.nonAUMembers = nonAUMembers;
  }
  
  public List<FcePersonDB> getPrincipals() {
    return principals;
  }

  public void setPrincipals(List<FcePersonDB> principals) {
    this.hasPrincipals = true;
    this.principals = principals;
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

  public List getReasonsNotEligible() {
    return reasonsNotEligible;
  }

  public void setReasonsNotEligible(List reasonsNotEligible) {
    this.hasReasonsNotEligible = true;
    this.reasonsNotEligible = reasonsNotEligible;
  }
  
  public boolean hasAmtGrossIncomeCeiling() {
    return hasAmtGrossIncomeCeiling;
  }

  public double getAmtGrossIncomeCeiling() {
    if (amtGrossIncomeCeiling == null) {
      return (double) 0;
    }
    return amtGrossIncomeCeiling.doubleValue();
  }

  public Double getAmtGrossIncomeCeilingObject() {
    return amtGrossIncomeCeiling;
  }

  public String getAmtGrossIncomeCeilingString() {
    return FormattingHelper.formatDouble(amtGrossIncomeCeiling);
  }

  public void setAmtGrossIncomeCeiling(double amtGrossIncomeCeiling) {
    this.hasAmtGrossIncomeCeiling = true;
    this.amtGrossIncomeCeiling = new Double(amtGrossIncomeCeiling);
  }

  public void setAmtGrossIncomeCeiling(Double amtGrossIncomeCeiling) {
    this.hasAmtGrossIncomeCeiling = true;
    this.amtGrossIncomeCeiling = amtGrossIncomeCeiling;
  }

  public void setAmtGrossIncomeCeiling(Number amtGrossIncomeCeiling) {
    this.hasAmtGrossIncomeCeiling = true;
    this.amtGrossIncomeCeiling = null;
    if (amtGrossIncomeCeiling != null) {
      setAmtGrossIncomeCeiling(amtGrossIncomeCeiling.doubleValue());
    }
  }
  
  public boolean hasAmtStandardOfNeed() {
    return hasAmtStandardOfNeed;
  }

  public double getAmtStandardOfNeed() {
    if (amtStandardOfNeed == null) {
      return (double) 0;
    }
    return amtStandardOfNeed.doubleValue();
  }

  public Double getAmtStandardOfNeedObject() {
    return amtStandardOfNeed;
  }

  public String getAmtStandardOfNeedString() {
    return FormattingHelper.formatDouble(amtStandardOfNeed);
  }

  public void setAmtStandardOfNeed(double amtStandardOfNeed) {
    this.hasAmtStandardOfNeed = true;
    this.amtStandardOfNeed = new Double(amtStandardOfNeed);
  }

  public void setAmtStandardOfNeed(Double amtStandardOfNeed) {
    this.hasAmtStandardOfNeed = true;
    this.amtStandardOfNeed = amtStandardOfNeed;
  }

  public void setAmtStandardOfNeed(Number amtStandardOfNeed) {
    this.hasAmtStandardOfNeed = true;
    this.amtStandardOfNeed = null;
    if (amtStandardOfNeed != null) {
      setAmtStandardOfNeed(amtStandardOfNeed.doubleValue());
    }
  }
  
  public boolean hasAmtDependentCareDeduc() {
    return hasAmtDependentCareDeduc;
  }

  public double getAmtDependentCareDeduc() {
    if (amtDependentCareDeduc == null) {
      return (double) 0;
    }
    return amtDependentCareDeduc.doubleValue();
  }

  public Double getAmtDependentCareDeducObject() {
    return amtDependentCareDeduc;
  }

  public String getAmtDependentCareDeducString() {
    return FormattingHelper.formatDouble(amtDependentCareDeduc);
  }

  public void setAmtDependentCareDeduc(double amtDependentCareDeduc) {
    this.hasAmtDependentCareDeduc = true;
    this.amtDependentCareDeduc = new Double(amtDependentCareDeduc);
  }

  public void setAmtDependentCareDeduc(Double amtDependentCareDeduc) {
    this.hasAmtDependentCareDeduc = true;
    this.amtDependentCareDeduc = amtDependentCareDeduc;
  }

  public void setAmtDependentCareDeduc(Number amtDependentCareDeduc) {
    this.hasAmtDependentCareDeduc = true;
    this.amtDependentCareDeduc = null;
    if (amtDependentCareDeduc != null) {
      setAmtDependentCareDeduc(amtDependentCareDeduc.doubleValue());
    }
  }
  
  public boolean hasAmtAllocAllowance() {
    return hasAmtAllocAllowance;
  }

  public double getAmtAllocAllowance() {
    if (amtAllocAllowance == null) {
      return (double) 0;
    }
    return amtAllocAllowance.doubleValue();
  }

  public Double getAmtAllocAllowanceObject() {
    return amtAllocAllowance;
  }

  public String getAmtAllocAllowanceString() {
    return FormattingHelper.formatDouble(amtAllocAllowance);
  }

  public void setAmtAllocAllowance(double amtAllocAllowance) {
    this.hasAmtAllocAllowance = true;
    this.amtAllocAllowance = new Double(amtAllocAllowance);
  }

  public void setAmtAllocAllowance(Double amtAllocAllowance) {
    this.hasAmtAllocAllowance = true;
    this.amtAllocAllowance = amtAllocAllowance;
  }

  public void setAmtAllocAllowance(Number amtAllocAllowance) {
    this.hasAmtAllocAllowance = true;
    this.amtAllocAllowance = null;
    if (amtAllocAllowance != null) {
      setAmtAllocAllowance(amtAllocAllowance.doubleValue());
    }
  }
  
  public boolean hasAmtCountableIncomeStdNeed() {
    return hasAmtCountableIncomeStdNeed;
  }

  public double getAmtCountableIncomeStdNeed() {
    if (amtCountableIncomeStdNeed == null) {
      return (double) 0;
    }
    return amtCountableIncomeStdNeed.doubleValue();
  }

  public Double getAmtCountableIncomeStdNeedObject() {
    return amtCountableIncomeStdNeed;
  }

  public String getAmtCountableIncomeStdNeedString() {
    return FormattingHelper.formatDouble(amtCountableIncomeStdNeed);
  }

  public void setAmtCountableIncomeStdNeed(double amtCountableIncomeStdNeed) {
    this.hasAmtCountableIncomeStdNeed = true;
    this.amtCountableIncomeStdNeed = new Double(amtCountableIncomeStdNeed);
  }

  public void setAmtCountableIncomeStdNeed(Double amtCountableIncomeStdNeed) {
    this.hasAmtCountableIncomeStdNeed = true;
    this.amtCountableIncomeStdNeed = amtCountableIncomeStdNeed;
  }

  public void setAmtCountableIncomeStdNeed(Number amtCountableIncomeStdNeed) {
    this.hasAmtCountableIncomeStdNeed = true;
    this.amtCountableIncomeStdNeed = null;
    if (amtCountableIncomeStdNeed != null) {
      setAmtCountableIncomeStdNeed(amtCountableIncomeStdNeed.doubleValue());
    }
  }
 
  public boolean hasAmtCountableIncome30OneThird() {
    return hasAmtCountableIncome30OneThird;
  }

  public double getAmtCountableIncome30OneThird() {
    if (amtCountableIncome30OneThird == null) {
      return (double) 0;
    }
    return amtCountableIncome30OneThird.doubleValue();
  }

  public Double getAmtCountableIncome30OneThirdObject() {
    return amtCountableIncome30OneThird;
  }

  public String getAmtCountableIncome30OneThirdString() {
    return FormattingHelper.formatDouble(amtCountableIncome30OneThird);
  }

  public void setAmtCountableIncome30OneThird(double amtCountableIncome30OneThird) {
    this.hasAmtCountableIncome30OneThird = true;
    this.amtCountableIncome30OneThird = new Double(amtCountableIncome30OneThird);
  }

  public void setAmtCountableIncome30OneThird(Double amtCountableIncome30OneThird) {
    this.hasAmtCountableIncome30OneThird = true;
    this.amtCountableIncome30OneThird = amtCountableIncome30OneThird;
  }

  public void setAmtCountableIncome30OneThird(Number amtCountableIncome30OneThird) {
    this.hasAmtCountableIncome30OneThird = true;
    this.amtCountableIncome30OneThird = null;
    if (amtCountableIncome30OneThird != null) {
      setAmtCountableIncome30OneThird(amtCountableIncome30OneThird.doubleValue());
    }
  }
  
  public boolean hasAmtCtnblResourceChild() {
    return hasAmtCtnblResourceChild;
  }

  public double getAmtCtnblResourceChild() {
    if (amtCtnblResourceChild == null) {
      return (double) 0;
    }
    return amtCtnblResourceChild.doubleValue();
  }

  public Double getAmtCtnblResourceChildObject() {
    return amtCtnblResourceChild;
  }

  public String getAmtCtnblResourceChildString() {
    return FormattingHelper.formatDouble(amtCtnblResourceChild);
  }

  public void setAmtCtnblResourceChild(double amtCtnblResourceChild) {
    this.hasAmtCtnblResourceChild = true;
    this.amtCtnblResourceChild = new Double(amtCtnblResourceChild);
  }

  public void setAmtCtnblResourceChild(Double amtCtnblResourceChild) {
    this.hasAmtCtnblResourceChild = true;
    this.amtCtnblResourceChild = amtCtnblResourceChild;
  }

  public void setAmtCtnblResourceChild(Number amtCtnblResourceChild) {
    this.hasAmtCtnblResourceChild = true;
    this.amtCtnblResourceChild = null;
    if (amtCtnblResourceChild != null) {
      setAmtCtnblResourceChild(amtCtnblResourceChild.doubleValue());
    }
  }
  
  public boolean hasAmtGrossEarnedChild() {
    return hasAmtGrossEarnedChild;
  }

  public double getAmtGrossEarnedChild() {
    if (amtGrossEarnedChild == null) {
      return (double) 0;
    }
    return amtGrossEarnedChild.doubleValue();
  }

  public Double getAmtGrossEarnedChildObject() {
    return amtGrossEarnedChild;
  }

  public String getAmtGrossEarnedChildString() {
    return FormattingHelper.formatDouble(amtGrossEarnedChild);
  }

  public void setAmtGrossEarnedChild(double amtGrossEarnedChild) {
    this.hasAmtGrossEarnedChild = true;
    this.amtGrossEarnedChild = new Double(amtGrossEarnedChild);
  }

  public void setAmtGrossEarnedChild(Double amtGrossEarnedChild) {
    this.hasAmtGrossEarnedChild = true;
    this.amtGrossEarnedChild = amtGrossEarnedChild;
  }

  public void setAmtGrossEarnedChild(Number amtGrossEarnedChild) {
    this.hasAmtGrossEarnedChild = true;
    this.amtGrossEarnedChild = null;
    if (amtGrossEarnedChild != null) {
      setAmtGrossEarnedChild(amtGrossEarnedChild.doubleValue());
    }
  }
  
  public boolean hasAmtGrossUnEarnedChild() {
    return hasAmtGrossUnEarnedChild;
  }

  public double getAmtGrossUnEarnedChild() {
    if (amtGrossUnEarnedChild == null) {
      return (double) 0;
    }
    return amtGrossUnEarnedChild.doubleValue();
  }

  public Double getAmtGrossUnEarnedChildObject() {
    return amtGrossUnEarnedChild;
  }

  public String getAmtGrossUnEarnedChildString() {
    return FormattingHelper.formatDouble(amtGrossUnEarnedChild);
  }

  public void setAmtGrossUnEarnedChild(double amtGrossUnEarnedChild) {
    this.hasAmtGrossUnEarnedChild = true;
    this.amtGrossUnEarnedChild = new Double(amtGrossUnEarnedChild);
  }

  public void setAmtGrossUnEarnedChild(Double amtGrossUnEarnedChild) {
    this.hasAmtGrossUnEarnedChild = true;
    this.amtGrossUnEarnedChild = amtGrossUnEarnedChild;
  }

  public void setAmtGrossUnEarnedChild(Number amtGrossUnEarnedChild) {
    this.hasAmtGrossUnEarnedChild = true;
    this.amtGrossUnEarnedChild = null;
    if (amtGrossUnEarnedChild != null) {
      setAmtGrossUnEarnedChild(amtGrossUnEarnedChild.doubleValue());
    }
  }
  
  public boolean hasAmtTotalGrossIncomeChild() {
    return hasAmtTotalGrossIncomeChild;
  }

  public double getAmtTotalGrossIncomeChild() {
    if (amtTotalGrossIncomeChild == null) {
      return (double) 0;
    }
    return amtTotalGrossIncomeChild.doubleValue();
  }

  public Double getAmtTotalGrossIncomeChildObject() {
    return amtTotalGrossIncomeChild;
  }

  public String getAmtTotalGrossIncomeChildString() {
    return FormattingHelper.formatDouble(amtTotalGrossIncomeChild);
  }

  public void setAmtTotalGrossIncomeChild(double amtTotalGrossIncomeChild) {
    this.hasAmtTotalGrossIncomeChild = true;
    this.amtTotalGrossIncomeChild = new Double(amtTotalGrossIncomeChild);
  }

  public void setAmtTotalGrossIncomeChild(Double amtTotalGrossIncomeChild) {
    this.hasAmtTotalGrossIncomeChild = true;
    this.amtTotalGrossIncomeChild = amtTotalGrossIncomeChild;
  }

  public void setAmtTotalGrossIncomeChild(Number amtTotalGrossIncomeChild) {
    this.hasAmtTotalGrossIncomeChild = true;
    this.amtTotalGrossIncomeChild = null;
    if (amtTotalGrossIncomeChild != null) {
      setAmtTotalGrossIncomeChild(amtTotalGrossIncomeChild.doubleValue());
    }
  }
  
  public boolean hasAmtCntblIncStdNeedChild() {
    return hasAmtCntblIncStdNeedChild;
  }

  public double getAmtCntblIncStdNeedChild() {
    if (amtCntblIncStdNeedChild == null) {
      return (double) 0;
    }
    return amtCntblIncStdNeedChild.doubleValue();
  }

  public Double getAmtCntblIncStdNeedChildObject() {
    return amtCntblIncStdNeedChild;
  }

  public String getAmtCntblIncStdNeedChildString() {
    return FormattingHelper.formatDouble(amtCntblIncStdNeedChild);
  }

  public void setAmtCntblIncStdNeedChild(double amtCntblIncStdNeedChild) {
    this.hasAmtCntblIncStdNeedChild = true;
    this.amtCntblIncStdNeedChild = new Double(amtCntblIncStdNeedChild);
  }

  public void setAmtCntblIncStdNeedChild(Double amtCntblIncStdNeedChild) {
    this.hasAmtCntblIncStdNeedChild = true;
    this.amtCntblIncStdNeedChild = amtCntblIncStdNeedChild;
  }

  public void setAmtCntblIncStdNeedChild(Number amtCntblIncStdNeedChild) {
    this.hasAmtCntblIncStdNeedChild = true;
    this.amtCntblIncStdNeedChild = null;
    if (amtCntblIncStdNeedChild != null) {
      setAmtCntblIncStdNeedChild(amtCntblIncStdNeedChild.doubleValue());
    }
  }
  
  public boolean hasAmtCntblInc30OneThirdChild() {
    return hasAmtCntblInc30OneThirdChild;
  }

  public double getAmtCntblInc30OneThirdChild() {
    if (amtCntblInc30OneThirdChild == null) {
      return (double) 0;
    }
    return amtCntblInc30OneThirdChild.doubleValue();
  }

  public Double getAmtCntblInc30OneThirdChildObject() {
    return amtCntblInc30OneThirdChild;
  }

  public String getAmtCntblInc30OneThirdChildString() {
    return FormattingHelper.formatDouble(amtCntblInc30OneThirdChild);
  }

  public void setAmtCntblInc30OneThirdChild(double amtCntblInc30OneThirdChild) {
    this.hasAmtCntblInc30OneThirdChild = true;
    this.amtCntblInc30OneThirdChild = new Double(amtCntblInc30OneThirdChild);
  }

  public void setAmtCntblInc30OneThirdChild(Double amtCntblInc30OneThirdChild) {
    this.hasAmtCntblInc30OneThirdChild = true;
    this.amtCntblInc30OneThirdChild = amtCntblInc30OneThirdChild;
  }

  public void setAmtCntblInc30OneThirdChild(Number amtCntblInc30OneThirdChild) {
    this.hasAmtCntblInc30OneThirdChild = true;
    this.amtCntblInc30OneThirdChild = null;
    if (amtCntblInc30OneThirdChild != null) {
      setAmtCntblInc30OneThirdChild(amtCntblInc30OneThirdChild.doubleValue());
    }
  }
  
  public boolean hasIndCtnblResChildElgblty() {
    return hasIndCtnblResChildElgblty;
  }

  public boolean getIndCtnblResChildElgblty() {
    if (indCtnblResChildElgblty == null) {
      return false;
    }
    return indCtnblResChildElgblty.booleanValue();
  }

  public Boolean getIndCtnblResChildElgbltyObject() {
    return indCtnblResChildElgblty;
  }

  public String getIndCtnblResChildElgbltyString() {
    if (indCtnblResChildElgblty == null) {
      return "";
    }
    return indCtnblResChildElgblty.toString();
  }

  public void setIndCtnblResChildElgblty(boolean indCtnblResChildElgblty) {
    this.hasIndCtnblResChildElgblty = true;
    this.indCtnblResChildElgblty = new Boolean(indCtnblResChildElgblty);
  }

  public void setIndCtnblResChildElgblty(Boolean indCtnblResChildElgblty) {
    this.hasIndCtnblResChildElgblty = true;
    this.indCtnblResChildElgblty = indCtnblResChildElgblty;
  }

  public void setIndCtnblResChildElgblty(String indCtnblResChildElgblty) {
    this.hasIndCtnblResChildElgblty = true;
    this.indCtnblResChildElgblty = isTrueBoolean(indCtnblResChildElgblty);
  }
  
  public boolean hasIndGrossIncChildElgblty() {
    return hasIndGrossIncChildElgblty;
  }

  public boolean getIndGrossIncChildElgblty() {
    if (indGrossIncChildElgblty == null) {
      return false;
    }
    return indGrossIncChildElgblty.booleanValue();
  }

  public Boolean getIndGrossIncChildElgbltyObject() {
    return indGrossIncChildElgblty;
  }

  public String getIndGrossIncChildElgbltyString() {
    if (indGrossIncChildElgblty == null) {
      return "";
    }
    return indGrossIncChildElgblty.toString();
  }

  public void setIndGrossIncChildElgblty(boolean indGrossIncChildElgblty) {
    this.hasIndGrossIncChildElgblty = true;
    this.indGrossIncChildElgblty = new Boolean(indGrossIncChildElgblty);
  }

  public void setIndGrossIncChildElgblty(Boolean indGrossIncChildElgblty) {
    this.hasIndGrossIncChildElgblty = true;
    this.indGrossIncChildElgblty = indGrossIncChildElgblty;
  }

  public void setIndGrossIncChildElgblty(String indGrossIncChildElgblty) {
    this.hasIndGrossIncChildElgblty = true;
    this.indGrossIncChildElgblty = isTrueBoolean(indGrossIncChildElgblty);
  }
  
  public boolean hasIndStdOfNeedChildTestElgblty() {
    return hasIndStdOfNeedChildTestElgblty;
  }

  public boolean getIndStdOfNeedChildTestElgblty() {
    if (indStdOfNeedChildTestElgblty == null) {
      return false;
    }
    return indStdOfNeedChildTestElgblty.booleanValue();
  }

  public Boolean getIndStdOfNeedChildTestElgbltyObject() {
    return indStdOfNeedChildTestElgblty;
  }

  public String getIndStdOfNeedChildTestElgbltyString() {
    if (indStdOfNeedChildTestElgblty == null) {
      return "";
    }
    return indStdOfNeedChildTestElgblty.toString();
  }

  public void setIndStdOfNeedChildTestElgblty(boolean indStdOfNeedChildTestElgblty) {
    this.hasIndStdOfNeedChildTestElgblty = true;
    this.indStdOfNeedChildTestElgblty = new Boolean(indStdOfNeedChildTestElgblty);
  }

  public void setIndStdOfNeedChildTestElgblty(Boolean indStdOfNeedChildTestElgblty) {
    this.hasIndStdOfNeedChildTestElgblty = true;
    this.indStdOfNeedChildTestElgblty = indStdOfNeedChildTestElgblty;
  }

  public void setIndStdOfNeedChildTestElgblty(String indStdOfNeedChildTestElgblty) {
    this.hasIndStdOfNeedChildTestElgblty = true;
    this.indStdOfNeedChildTestElgblty = isTrueBoolean(indStdOfNeedChildTestElgblty);
  }
  
  public boolean hasInd30OneThirdChildTestElgblty() {
    return hasInd30OneThirdChildTestElgblty;
  }

  public boolean getInd30OneThirdChildTestElgblty() {
    if (ind30OneThirdChildTestElgblty == null) {
      return false;
    }
    return ind30OneThirdChildTestElgblty.booleanValue();
  }

  public Boolean getInd30OneThirdChildTestElgbltyObject() {
    return ind30OneThirdChildTestElgblty;
  }

  public String getInd30OneThirdChildTestElgbltyString() {
    if (ind30OneThirdChildTestElgblty == null) {
      return "";
    }
    return ind30OneThirdChildTestElgblty.toString();
  }

  public void setInd30OneThirdChildTestElgblty(boolean ind30OneThirdChildTestElgblty) {
    this.hasInd30OneThirdChildTestElgblty = true;
    this.ind30OneThirdChildTestElgblty = new Boolean(ind30OneThirdChildTestElgblty);
  }

  public void setInd30OneThirdChildTestElgblty(Boolean ind30OneThirdChildTestElgblty) {
    this.hasInd30OneThirdChildTestElgblty = true;
    this.ind30OneThirdChildTestElgblty = ind30OneThirdChildTestElgblty;
  }

  public void setInd30OneThirdChildTestElgblty(String ind30OneThirdChildTestElgblty) {
    this.hasInd30OneThirdChildTestElgblty = true;
    this.ind30OneThirdChildTestElgblty = isTrueBoolean(ind30OneThirdChildTestElgblty);
  }
  
  public boolean hasIndGrossIncCeilingElgblty() {
    return hasIndGrossIncCeilingElgblty;
  }

  public boolean getIndGrossIncCeilingElgblty() {
    if (indGrossIncCeilingElgblty == null) {
      return false;
    }
    return indGrossIncCeilingElgblty.booleanValue();
  }

  public Boolean getIndGrossIncCeilingElgbltyObject() {
    return indGrossIncCeilingElgblty;
  }

  public String getIndGrossIncCeilingElgbltyString() {
    if (indGrossIncCeilingElgblty == null) {
      return "";
    }
    return indGrossIncCeilingElgblty.toString();
  }

  public void setIndGrossIncCeilingElgblty(boolean indGrossIncCeilingElgblty) {
    this.hasIndGrossIncCeilingElgblty = true;
    this.indGrossIncCeilingElgblty = new Boolean(indGrossIncCeilingElgblty);
  }

  public void setIndGrossIncCeilingElgblty(Boolean indGrossIncCeilingElgblty) {
    this.hasIndGrossIncCeilingElgblty = true;
    this.indGrossIncCeilingElgblty = indGrossIncCeilingElgblty;
  }

  public void setIndGrossIncCeilingElgblty(String indGrossIncCeilingElgblty) {
    this.hasIndGrossIncCeilingElgblty = true;
    this.indGrossIncCeilingElgblty = isTrueBoolean(indGrossIncCeilingElgblty);
  }
  
  public boolean hasAmtDepCareDeducChild() {
    return hasAmtDepCareDeducChild;
  }

  public double getAmtDepCareDeducChild() {
    if (amtDepCareDeducChild == null) {
      return (double) 0;
    }
    return amtDepCareDeducChild.doubleValue();
  }

  public Double getAmtDepCareDeducChildObject() {
    return amtDepCareDeducChild;
  }

  public String getAmtDepCareDeducChildString() {
    return FormattingHelper.formatDouble(amtDepCareDeducChild);
  }

  public void setAmtDepCareDeducChild(double amtDepCareDeducChild) {
    this.hasAmtDepCareDeducChild = true;
    this.amtDepCareDeducChild = new Double(amtDepCareDeducChild);
  }

  public void setAmtDepCareDeducChild(Double amtDepCareDeducChild) {
    this.hasAmtDepCareDeducChild = true;
    this.amtDepCareDeducChild = amtDepCareDeducChild;
  }

  public void setAmtDepCareDeducChild(Number amtDepCareDeducChild) {
    this.hasAmtDepCareDeducChild = true;
    this.amtDepCareDeducChild = null;
    if (amtDepCareDeducChild != null) {
      setAmtDepCareDeducChild(amtDepCareDeducChild.doubleValue());
    }
  }
  
  public boolean hasAmtGrossIncomeCeilingChild() {
    return hasAmtGrossIncomeCeilingChild;
  }

  public double getAmtGrossIncomeCeilingChild() {
    if (amtGrossIncomeCeilingChild == null) {
      return (double) 0;
    }
    return amtGrossIncomeCeilingChild.doubleValue();
  }

  public Double getAmtGrossIncomeCeilingChildObject() {
    return amtGrossIncomeCeilingChild;
  }

  public String getAmtGrossIncomeCeilingChildString() {
    return FormattingHelper.formatDouble(amtGrossIncomeCeilingChild);
  }

  public void setAmtGrossIncomeCeilingChild(double amtGrossIncomeCeilingChild) {
    this.hasAmtGrossIncomeCeilingChild = true;
    this.amtGrossIncomeCeilingChild = new Double(amtGrossIncomeCeilingChild);
  }

  public void setAmtGrossIncomeCeilingChild(Double amtGrossIncomeCeilingChild) {
    this.hasAmtGrossIncomeCeilingChild = true;
    this.amtGrossIncomeCeilingChild = amtGrossIncomeCeilingChild;
  }

  public void setAmtGrossIncomeCeilingChild(Number amtGrossIncomeCeilingChild) {
    this.hasAmtGrossIncomeCeilingChild = true;
    this.amtGrossIncomeCeilingChild = null;
    if (amtGrossIncomeCeilingChild != null) {
      setAmtGrossIncomeCeilingChild(amtGrossIncomeCeilingChild.doubleValue());
    }
  }
  
  public boolean hasAmtStdOfNeedChild() {
    return hasAmtStdOfNeedChild;
  }

  public double getAmtStdOfNeedChild() {
    if (amtStdOfNeedChild == null) {
      return (double) 0;
    }
    return amtStdOfNeedChild.doubleValue();
  }

  public Double getAmtStdOfNeedChildObject() {
    return amtStdOfNeedChild;
  }

  public String getAmtStdOfNeedChildString() {
    return FormattingHelper.formatDouble(amtStdOfNeedChild);
  }

  public void setAmtStdOfNeedChild(double amtStdOfNeedChild) {
    this.hasAmtStdOfNeedChild = true;
    this.amtStdOfNeedChild = new Double(amtStdOfNeedChild);
  }

  public void setAmtStdOfNeedChild(Double amtStdOfNeedChild) {
    this.hasAmtStdOfNeedChild = true;
    this.amtStdOfNeedChild = amtStdOfNeedChild;
  }

  public void setAmtStdOfNeedChild(Number amtStdOfNeedChild) {
    this.hasAmtStdOfNeedChild = true;
    this.amtStdOfNeedChild = null;
    if (amtStdOfNeedChild != null) {
      setAmtStdOfNeedChild(amtStdOfNeedChild.doubleValue());
    }
  }
  
  public boolean hasIndChildReceivingSSI() {
    return hasIndChildReceivingSSI;
  }

  public boolean getIndChildReceivingSSI() {
    if (indChildReceivingSSI == null) {
      return false;
    }
    return indChildReceivingSSI.booleanValue();
  }

  public Boolean getIndChildReceivingSSIObject() {
    return indChildReceivingSSI;
  }

  public String getIndChildReceivingSSIString() {
    if (indChildReceivingSSI == null) {
      return "";
    }
    return indChildReceivingSSI.toString();
  }

  public void setIndChildReceivingSSI(boolean indChildReceivingSSI) {
    this.hasIndChildReceivingSSI = true;
    this.indChildReceivingSSI = new Boolean(indChildReceivingSSI);
  }

  public void setIndChildReceivingSSI(Boolean indChildReceivingSSI) {
    this.hasIndChildReceivingSSI = true;
    this.indChildReceivingSSI = indChildReceivingSSI;
  }

  public void setIndChildReceivingSSI(String indChildReceivingSSI) {
    this.hasIndChildReceivingSSI = true;
    this.indChildReceivingSSI = isTrueBoolean(indChildReceivingSSI);
  }

  public boolean hasAmtCsupWithUnearnedIncome() {
    return hasAmtCsupWithUnearnedIncome;
  }

  public double getAmtCsupWithUnearnedIncome() {
    if (amtCsupWithUnearnedIncome == null) {
      return (double) 0;
    }
    return amtCsupWithUnearnedIncome.doubleValue();
  }

  public Double getAmtCsupWithUnearnedIncomeObject() {
    return amtCsupWithUnearnedIncome;
  }

  public String getAmtCsupWithUnearnedIncomeString() {
    return FormattingHelper.formatDouble(amtCsupWithUnearnedIncome);
  }

  public void setAmtCsupWithUnearnedIncome(double amtCsupWithUnearnedIncome) {
    this.hasAmtCsupWithUnearnedIncome = true;
    this.amtCsupWithUnearnedIncome = new Double(amtCsupWithUnearnedIncome);
  }

  public void setAmtCsupWithUnearnedIncome(Double amtCsupWithUnearnedIncome) {
    this.hasAmtCsupWithUnearnedIncome = true;
    this.amtCsupWithUnearnedIncome = amtCsupWithUnearnedIncome;
  }

  public void setAmtCsupWithUnearnedIncome(Number amtCsupWithUnearnedIncome) {
    this.hasAmtCsupWithUnearnedIncome = true;
    this.amtCsupWithUnearnedIncome = null;
    if (amtCsupWithUnearnedIncome != null) {
      setAmtCsupWithUnearnedIncome(amtCsupWithUnearnedIncome.doubleValue());
    }
  }

  
  public void copyInto(EligibilityDeterminationDB eligibilityDeterminationDB) {
    if (hasAmtAllocAllowanceMutual) {
      eligibilityDeterminationDB.setAmtAllocAllowanceMutual(amtAllocAllowanceMutual);
    }
    if (hasAmtAllocAllowanceSngl1) {
      eligibilityDeterminationDB.setAmtAllocAllowanceSngl1(amtAllocAllowanceSngl1);
    }
    if (hasAmtAllocAllowanceSngl2) {
      eligibilityDeterminationDB.setAmtAllocAllowanceSngl2(amtAllocAllowanceSngl2);
    }
    if (hasAmtCountableIncome) {
      eligibilityDeterminationDB.setAmtCountableIncome(amtCountableIncome);
    }
    if (hasAmtChsupChild) {
      eligibilityDeterminationDB.setAmtChsupChild(amtChsupChild);
    }
    if (hasAmtChsupCrtfdGrp) {
      eligibilityDeterminationDB.setAmtChsupCrtfdGrp(amtChsupCrtfdGrp);
    }
    if (hasAmtCntIncomeEligChild) {
      eligibilityDeterminationDB.setAmtCntIncomeEligChild(amtCntIncomeEligChild);
    }
    if (hasAmtCntIncomeEligCrtfdGrp) {
      eligibilityDeterminationDB.setAmtCntIncomeEligCrtfdGrp(amtCntIncomeEligCrtfdGrp);
    }
    if (hasAmtCntblIncome) {
      eligibilityDeterminationDB.setAmtCntblIncome(amtCntblIncome);
    }
    if (hasAmtCntblIncome30) {
      eligibilityDeterminationDB.setAmtCntblIncome30(amtCntblIncome30);
    }
    if (hasAmtCntblIncomeLess30) {
      eligibilityDeterminationDB.setAmtCntblIncomeLess30(amtCntblIncomeLess30);
    }
    if (hasAmtCntblIncomeLessThird) {
      eligibilityDeterminationDB.setAmtCntblIncomeLessThird(amtCntblIncomeLessThird);
    }
    if (hasAmtCntblIncomeThird) {
      eligibilityDeterminationDB.setAmtCntblIncomeThird(amtCntblIncomeThird);
    }
    if (hasAmtGrossEarnedIncome) {
      eligibilityDeterminationDB.setAmtGrossEarnedIncome(amtGrossEarnedIncome);
    }
    if (hasAmtGrossUnearnedIncome) {
      eligibilityDeterminationDB.setAmtGrossUnearnedIncome(amtGrossUnearnedIncome);
    }
    if (hasAmtStdEarnedIncomeDeduct) {
      eligibilityDeterminationDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeduct);
    }
    if (hasAmtDeemAlimonyOutsideHh) {
      eligibilityDeterminationDB.setAmtDeemAlimonyOutsideHh(amtDeemAlimonyOutsideHh);
    }
    if (hasAmtDeemCntNetIncome) {
      eligibilityDeterminationDB.setAmtDeemCntNetIncome(amtDeemCntNetIncome);
    }
    if (hasAmtDeemGrossEarnedIncome) {
      eligibilityDeterminationDB.setAmtDeemGrossEarnedIncome(amtDeemGrossEarnedIncome);
    }
    if (hasAmtDeemLessStdOfNeed) {
      eligibilityDeterminationDB.setAmtDeemLessStdOfNeed(amtDeemLessStdOfNeed);
    }
    if (hasAmtDeemNetEarnedIncome) {
      eligibilityDeterminationDB.setAmtDeemNetEarnedIncome(amtDeemNetEarnedIncome);
    }
    if (hasAmtDeemStdEarnedIncDeduct) {
      eligibilityDeterminationDB.setAmtDeemStdEarnedIncDeduct(amtDeemStdEarnedIncDeduct);
    }
    if (hasAmtDeemStdOfNeed) {
      eligibilityDeterminationDB.setAmtDeemStdOfNeed(amtDeemStdOfNeed);
    }
    if (hasAmtDeemSurplusOrDeficit) {
      eligibilityDeterminationDB.setAmtDeemSurplusOrDeficit(amtDeemSurplusOrDeficit);
    }
    if (hasAmtDeemTaxDependOutHh) {
      eligibilityDeterminationDB.setAmtDeemTaxDependOutHh(amtDeemTaxDependOutHh);
    }
    if (hasAmtDeemTotal) {
      eligibilityDeterminationDB.setAmtDeemTotal(amtDeemTotal);
    }
    if (hasAmtDeemUnearnedIncome) {
      eligibilityDeterminationDB.setAmtDeemUnearnedIncome(amtDeemUnearnedIncome);
    }
    if (hasAmtEarnedLessAllDeduct) {
      eligibilityDeterminationDB.setAmtEarnedLessAllDeduct(amtEarnedLessAllDeduct);
    }
    if (hasAmtEarnedLessStdDeduct) {
      eligibilityDeterminationDB.setAmtEarnedLessStdDeduct(amtEarnedLessStdDeduct);
    }
    if (hasAmtGicSurpDefctChild) {
      eligibilityDeterminationDB.setAmtGicSurpDefctChild(amtGicSurpDefctChild);
    }
    if (hasAmtGicSurpDefctCrtfdGrp) {
      eligibilityDeterminationDB.setAmtGicSurpDefctCrtfdGrp(amtGicSurpDefctCrtfdGrp);
    }
    if (hasAmtGrossEarnedCrtfdGrp) {
      eligibilityDeterminationDB.setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp);
    }
    if (hasAmtGrossIncomeAllocMutual) {
      eligibilityDeterminationDB.setAmtGrossIncomeAllocMutual(amtGrossIncomeAllocMutual);
    }
    if (hasAmtGrossIncomeAllocSngl1) {
      eligibilityDeterminationDB.setAmtGrossIncomeAllocSngl1(amtGrossIncomeAllocSngl1);
    }
    if (hasAmtGrossIncomeAllocSngl2) {
      eligibilityDeterminationDB.setAmtGrossIncomeAllocSngl2(amtGrossIncomeAllocSngl2);
    }
    if (hasAmtGrossIncomeCrtfdGrp) {
      eligibilityDeterminationDB.setAmtGrossIncomeCrtfdGrp(amtGrossIncomeCrtfdGrp);
    }
    if (hasAmtGrossIncomeChild) {
      eligibilityDeterminationDB.setAmtGrossIncomeChild(amtGrossIncomeChild);
    }
    if (hasAmtLessAllocElig) {
      eligibilityDeterminationDB.setAmtLessAllocElig(amtLessAllocElig);
    }
    if (hasAmtLessAllocStdNeed) {
      eligibilityDeterminationDB.setAmtLessAllocStdNeed(amtLessAllocStdNeed);
    }
    if (hasAmtLessDepCareElig) {
      eligibilityDeterminationDB.setAmtLessDepCareElig(amtLessDepCareElig);
    }
    if (hasAmtLessDepCareStdNeed) {
      eligibilityDeterminationDB.setAmtLessDepCareStdNeed(amtLessDepCareStdNeed);
    }
    if (hasAmtNetEarnedIncome) {
      eligibilityDeterminationDB.setAmtNetEarnedIncome(amtNetEarnedIncome);
    }
    if (hasAmtNetEarnedIncomeChild) {
      eligibilityDeterminationDB.setAmtNetEarnedIncomeChild(amtNetEarnedIncomeChild);
    }
    if (hasAmtNonexmptRsrcCrtfdGrp) {
      eligibilityDeterminationDB.setAmtNonexmptRsrcCrtfdGrp(amtNonexmptRsrcCrtfdGrp);
    }
    if (hasAmtPlusChsupChild) {
      eligibilityDeterminationDB.setAmtPlusChsupChild(amtPlusChsupChild);
    }
    if (hasAmtPlusChsupCrtfdGrp) {
      eligibilityDeterminationDB.setAmtPlusChsupCrtfdGrp(amtPlusChsupCrtfdGrp);
    }
    if (hasAmtPlusDeemedElig) {
      eligibilityDeterminationDB.setAmtPlusDeemedElig(amtPlusDeemedElig);
    }
    if (hasAmtPlusDeemedStdNeed) {
      eligibilityDeterminationDB.setAmtPlusDeemedStdNeed(amtPlusDeemedStdNeed);
    }
    if (hasAmtPlusUnearnedElig) {
      eligibilityDeterminationDB.setAmtPlusUnearnedElig(amtPlusUnearnedElig);
    }
    if (hasAmtPlusUnearnedStdNeed) {
      eligibilityDeterminationDB.setAmtPlusUnearnedStdNeed(amtPlusUnearnedStdNeed);
    }
    if (hasAmtResourceLimitChild) {
      eligibilityDeterminationDB.setAmtResourceLimitChild(amtResourceLimitChild);
    }
    if (hasAmtResourceLimitCrtfdGrp) {
      eligibilityDeterminationDB.setAmtResourceLimitCrtfdGrp(amtResourceLimitCrtfdGrp);
    }
    if (hasAmtGrossUnearnedCrtfdGrp) {
      eligibilityDeterminationDB.setAmtGrossUnearnedCrtfdGrp(amtGrossUnearnedCrtfdGrp);
    }
    if (hasAmtIncomeLimit) {
      eligibilityDeterminationDB.setAmtIncomeLimit(amtIncomeLimit);
    }
    if (hasAmtPweIncome) {
      eligibilityDeterminationDB.setAmtPweIncome(amtPweIncome);
    }
    if (hasAmtSsi) {
      eligibilityDeterminationDB.setAmtSsi(amtSsi);
    }
    if (hasAmtStdOfNeedAllocMutual) {
      eligibilityDeterminationDB.setAmtStdOfNeedAllocMutual(amtStdOfNeedAllocMutual);
    }
    if (hasAmtStdOfNeedAllocSngl1) {
      eligibilityDeterminationDB.setAmtStdOfNeedAllocSngl1(amtStdOfNeedAllocSngl1);
    }
    if (hasAmtStdOfNeedAllocSngl2) {
      eligibilityDeterminationDB.setAmtStdOfNeedAllocSngl2(amtStdOfNeedAllocSngl2);
    }
    if (hasAmtStepparentAlimony) {
      eligibilityDeterminationDB.setAmtStepparentAlimony(amtStepparentAlimony);
    }
    if (hasAmtStepparentAllowance) {
      eligibilityDeterminationDB.setAmtStepparentAllowance(amtStepparentAllowance);
    }
    if (hasAmtStepparentAppliedIncome) {
      eligibilityDeterminationDB.setAmtStepparentAppliedIncome(amtStepparentAppliedIncome);
    }
    if (hasAmtStepparentCntblUnearned) {
      eligibilityDeterminationDB.setAmtStepparentCntblUnearned(amtStepparentCntblUnearned);
    }
    if (hasAmtStepparentGrossEarned) {
      eligibilityDeterminationDB.setAmtStepparentGrossEarned(amtStepparentGrossEarned);
    }
    if (hasAmtStepparentOutsidePmnt) {
      eligibilityDeterminationDB.setAmtStepparentOutsidePmnt(amtStepparentOutsidePmnt);
    }
    if (hasAmtStepparentTotalCntbl) {
      eligibilityDeterminationDB.setAmtStepparentTotalCntbl(amtStepparentTotalCntbl);
    }
    if (hasAmtStepparentWorkDeduct) {
      eligibilityDeterminationDB.setAmtStepparentWorkDeduct(amtStepparentWorkDeduct);
    }
    if (hasAmtSurpDefctEligChild) {
      eligibilityDeterminationDB.setAmtSurpDefctEligChild(amtSurpDefctEligChild);
    }    
    if (hasAmtSurpDefctEligCrtfdGrp) {
      eligibilityDeterminationDB.setAmtSurpDefctEligCrtfdGrp(amtSurpDefctEligCrtfdGrp);
    }
    if (hasAmtSurpDefctEligCrtfdGrp) {
      eligibilityDeterminationDB.setAmtSurpDefctEligCrtfdGrp(amtSurpDefctEligCrtfdGrp);
    }
    if(hasAUMembers){
      eligibilityDeterminationDB.setAUMembers(aUMembers);
    }
    if (hasCdAllocType) {
      eligibilityDeterminationDB.setCdAllocType(cdAllocType);
    }
    if (hasCdBlocChild) {
      eligibilityDeterminationDB.setCdBlocChild(cdBlocChild);
    }
    if (hasCdDeemIndivRel1) {
      eligibilityDeterminationDB.setCdDeemIndivRel1(cdDeemIndivRel1);
    }
    if (hasCdDeemIndivRel2) {
      eligibilityDeterminationDB.setCdDeemIndivRel2(cdDeemIndivRel2);
    }
    if (hasCdDeemSurplusOrDeficit) {
      eligibilityDeterminationDB.setCdDeemSurplusOrDeficit(cdDeemSurplusOrDeficit);
    }
    if (hasCdEligibilityActual) {
      eligibilityDeterminationDB.setCdEligibilityActual(cdEligibilityActual);
    }
    if (hasCdEligibilitySelected) {
      eligibilityDeterminationDB.setCdEligibilitySelected(cdEligibilitySelected);
    }
    if (hasCdEligSurpDefctChild) {
      eligibilityDeterminationDB.setCdEligSurpDefctChild(cdEligSurpDefctChild);
    }
    if (hasCdEligSurpDefctCrtfdGrp) {
      eligibilityDeterminationDB.setCdEligSurpDefctCrtfdGrp(cdEligSurpDefctCrtfdGrp);
    }
    if (hasCdGicSurpDefctChild) {
      eligibilityDeterminationDB.setCdGicSurpDefctChild(cdGicSurpDefctChild);
    }
    if (hasCdGicSurpDefctCrtfdGrp) {
      eligibilityDeterminationDB.setCdGicSurpDefctCrtfdGrp(cdGicSurpDefctCrtfdGrp);
    }
    if (hasCdMedicaidEligibilityType) {
      eligibilityDeterminationDB.setCdMedicaidEligibilityType(cdMedicaidEligibilityType);
    }
    if (hasFceEligibilityCdPersonCitizenship) {
      eligibilityDeterminationDB.setFceEligibilityCdPersonCitizenship(fceEligibilityCdPersonCitizenship);
    }
    if (hasCdPweIrregularUnder100) {
      eligibilityDeterminationDB.setCdPweIrregularUnder100(cdPweIrregularUnder100);
    }
    if (hasCdPweSteadyUnder100) {
      eligibilityDeterminationDB.setCdPweSteadyUnder100(cdPweSteadyUnder100);
    }
    if (hasCdRelInt) {
      eligibilityDeterminationDB.setCdRelInt(cdRelInt);
    }
    if (hasCdStdTestSurpDefct) {
      eligibilityDeterminationDB.setCdStdTestSurpDefct(cdStdTestSurpDefct);
    }
    if (hasCdVerifMethod) {
      eligibilityDeterminationDB.setCdVerifMethod(cdVerifMethod);
    }
    if (hasCdVerifDocType) {
      eligibilityDeterminationDB.setCdVerifDocType(cdVerifDocType);
    }
    if (hasDtBirth) {
      eligibilityDeterminationDB.setDtBirth(dtBirth);
    }
    if (hasFcePersonDtLastUpdate) {
      eligibilityDeterminationDB.setFcePersonDtLastUpdate(fcePersonDtLastUpdate);
    }
    if (hasDtDeprivationChanged) {
      eligibilityDeterminationDB.setDtDeprivationChanged(dtDeprivationChanged);
    }   
    if (hasDtEligibilityEnd) {
      eligibilityDeterminationDB.setDtEligibilityEnd(dtEligibilityEnd);
    }
    if (hasDtEligDtrmntnStart) {
      eligibilityDeterminationDB.setDtEligDtrmntnStart(dtEligDtrmntnStart);
    }
    if (hasFceEligibilityDtLastUpdate) {
      eligibilityDeterminationDB.setFceEligibilityDtLastUpdate(fceEligibilityDtLastUpdate);
    }
    if (hasDtRemovalChildOrdered) {
      eligibilityDeterminationDB.setDtRemovalChildOrdered(dtRemovalChildOrdered);
    }
    if (hasDtReviewDate) {
      eligibilityDeterminationDB.setDtReviewDate(dtReviewDate);
    }
    if (hasDtRsnblEffortPreventRem) {
      eligibilityDeterminationDB.setDtRsnblEffortPreventRem(dtRsnblEffortPreventRem);
    }
    if (hasIdCase) {
      eligibilityDeterminationDB.setIdCase(idCase);
    }
    if (hasIdEligibilityEvent) {
      eligibilityDeterminationDB.setIdEligibilityEvent(idEligibilityEvent);
    }
    if (hasIdFceApplication) {
      eligibilityDeterminationDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      eligibilityDeterminationDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdFcePerson) {
      eligibilityDeterminationDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdFceReview) {
      eligibilityDeterminationDB.setIdFceReview(idFceReview);
    }
    if (hasIdLastUpdatePerson) {
      eligibilityDeterminationDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdPerson) {
      eligibilityDeterminationDB.setIdPerson(idPerson);
    }
    if (hasIdPersonAllocMutual1) {
      eligibilityDeterminationDB.setIdPersonAllocMutual1(idPersonAllocMutual1);
    }           
    if (hasIdPersonAllocMutual2) {
      eligibilityDeterminationDB.setIdPersonAllocMutual2(idPersonAllocMutual2);
    }
    if (hasIdPersonAllocSngl1) {
      eligibilityDeterminationDB.setIdPersonAllocSngl1(idPersonAllocSngl1);
    }
    if (hasIdPersonAllocSngl2) {
      eligibilityDeterminationDB.setIdPersonAllocSngl2(idPersonAllocSngl2);
    }
    if (hasIdPersonDeemIndiv1) {
      eligibilityDeterminationDB.setIdPersonDeemIndiv1(idPersonDeemIndiv1);
    }
    if (hasIdPersonDeemIndiv2) {
      eligibilityDeterminationDB.setIdPersonDeemIndiv2(idPersonDeemIndiv2);
    }
    if (hasIdPrnEarner) {
      eligibilityDeterminationDB.setIdPrnEarner(idPrnEarner);
    }
    if (hasIdStage) {
      eligibilityDeterminationDB.setIdStage(idStage);
    }
    if (hasIndAbsentAltrntCustody) {
      eligibilityDeterminationDB.setIndAbsentAltrntCustody(indAbsentAltrntCustody);
    }
    if (hasIndAbsentDeported) {
      eligibilityDeterminationDB.setIndAbsentDeported(indAbsentDeported);
    }
    if (hasIndAbsentDeserted) {
      eligibilityDeterminationDB.setIndAbsentDeserted(indAbsentDeserted);
    }
    if (hasIndAbsentDied) {
      eligibilityDeterminationDB.setIndAbsentDied(indAbsentDied);
    }
    if (hasIndAbsentDivorced) {
      eligibilityDeterminationDB.setIndAbsentDivorced(indAbsentDivorced);
    }
    if (hasIndAbsentFather) {
      eligibilityDeterminationDB.setIndAbsentFather(indAbsentFather);
    }
    if (hasIndAbsentHospitalized) {
      eligibilityDeterminationDB.setIndAbsentHospitalized(indAbsentHospitalized);
    }
    if (hasIndAbsentIncarcerated) {
      eligibilityDeterminationDB.setIndAbsentIncarcerated(indAbsentIncarcerated);
    }
    if (hasIndAbsentMilitaryWork) {
      eligibilityDeterminationDB.setIndAbsentMilitaryWork(indAbsentMilitaryWork);
    }
    if (hasIndAbsentMother) {
      eligibilityDeterminationDB.setIndAbsentMother(indAbsentMother);
    }
    if (hasIndAbsentSeparated) {
      eligibilityDeterminationDB.setIndAbsentSeparated(indAbsentSeparated);
    }
    if (hasIndAbsentWorkRelated) {
      eligibilityDeterminationDB.setIndAbsentWorkRelated(indAbsentWorkRelated);
    }
    if (hasIndCertifiedGroup) {
      eligibilityDeterminationDB.setIndCertifiedGroup(indCertifiedGroup);
    }
    if (hasIndChildLivingPrnt6Mnths) {
      eligibilityDeterminationDB.setIndChildLivingPrnt6Mnths(indChildLivingPrnt6Mnths);
    }
    if (hasIndChildQualifiedCitizen) {
      eligibilityDeterminationDB.setIndChildQualifiedCitizen(indChildQualifiedCitizen);
    }
    if (hasIndChildSupportOrdered) {
      eligibilityDeterminationDB.setIndChildSupportOrdered(indChildSupportOrdered);
    }
    if (hasIndChildUnder18) {
      eligibilityDeterminationDB.setIndChildUnder18(indChildUnder18);
    }
    if (hasIndCtznshpAmerIndianCrd) {
      eligibilityDeterminationDB.setIndCtznshpAmerIndianCrd(indCtznshpAmerIndianCrd);
    }
    if (hasIndCtznshpAttorneyReview) {
      eligibilityDeterminationDB.setIndCtznshpAttorneyReview(indCtznshpAttorneyReview);
    }
    if (hasIndCtznshpBirthCrtfctFor) {
      eligibilityDeterminationDB.setIndCtznshpBirthCrtfctFor(indCtznshpBirthCrtfctFor);
    }
    if (hasIndCtznshpBirthCrtfctUs) {
      eligibilityDeterminationDB.setIndCtznshpBirthCrtfctUs(indCtznshpBirthCrtfctUs);
    }
    if (hasIndCtznshpChldFound) {
      eligibilityDeterminationDB.setIndCtznshpChldFound(indCtznshpChldFound);
    }
    if (hasIndCtznshpCitizenCrtfct) {
      eligibilityDeterminationDB.setIndCtznshpCitizenCrtfct(indCtznshpCitizenCrtfct);
    }
    if (hasIndCtznshpEvaluation) {
      eligibilityDeterminationDB.setIndCtznshpEvaluation(indCtznshpEvaluation);
    }
    if (hasIndCtznshpForDocumentation) {
      eligibilityDeterminationDB.setIndCtznshpForDocumentation(indCtznshpForDocumentation);
    }
    if (hasIndCtznshpHospitalCrtfct) {
      eligibilityDeterminationDB.setIndCtznshpHospitalCrtfct(indCtznshpHospitalCrtfct);
    }
    if (hasIndCtznshpNoDocumentation) {
      eligibilityDeterminationDB.setIndCtznshpNoDocumentation(indCtznshpNoDocumentation);
    }
    if (hasIndCtznshpNtrlztnCrtfct) {
      eligibilityDeterminationDB.setIndCtznshpNtrlztnCrtfct(indCtznshpNtrlztnCrtfct);
    }
    if (hasIndCtznshpPassport) {
      eligibilityDeterminationDB.setIndCtznshpPassport(indCtznshpPassport);
    }
    if (hasIndCtznshpResidentCard) {
      eligibilityDeterminationDB.setIndCtznshpResidentCard(indCtznshpResidentCard);
    }
    if (hasIndCtznshpUnaccMinorChild) {
      eligibilityDeterminationDB.setIndCtznshpUnaccMinorChild(indCtznshpUnaccMinorChild);
    }
    if (hasIndCtznshpUndocImmigrant) {
      eligibilityDeterminationDB.setIndCtznshpUndocImmigrant(indCtznshpUndocImmigrant);
    }
    if (hasIndCtznshpUsHsptlBrthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpUsHsptlBrthRcrd(indCtznshpUsHsptlBrthRcrd);
    }
    if (hasIndCtznshpUsIdCard) {
      eligibilityDeterminationDB.setIndCtznshpUsIdCard(indCtznshpUsIdCard);
    }
    if (hasIndCtznshpVitalBirthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpVitalBirthRcrd(indCtznshpVitalBirthRcrd);
    } 
    if (hasIndCtznshpSaveSystem) {
      eligibilityDeterminationDB.setIndCtznshpSaveSystem(indCtznshpSaveSystem);
    }
    if (hasIndCtznshpStudentVisa) {
      eligibilityDeterminationDB.setIndCtznshpStudentVisa(indCtznshpStudentVisa);
    }
    if (hasIndCtznshpSuccessSystem) {
      eligibilityDeterminationDB.setIndCtznshpSuccessSystem(indCtznshpSuccessSystem);
    }
    if (hasIndCtznshpBirthAbroad) {
      eligibilityDeterminationDB.setIndCtznshpBirthAbroad(indCtznshpBirthAbroad);
    }
    if (hasIndCtznshpCensusBirthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpCensusBirthRcrd(indCtznshpCensusBirthRcrd);
    }
    if (hasIndCtznshpConfrmBirth) {
      eligibilityDeterminationDB.setIndCtznshpConfrmBirth(indCtznshpConfrmBirth);
    }
    if (hasIndCtznshpFinalAdoptDecree) {
      eligibilityDeterminationDB.setIndCtznshpFinalAdoptDecree(indCtznshpFinalAdoptDecree);
    }
    if (hasIndCtznshpLeglImmiStatExp) {
      eligibilityDeterminationDB.setIndCtznshpLeglImmiStatExp(indCtznshpLeglImmiStatExp);
    }
    if (hasIndCtznshpLifeInsBrthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpLifeInsBrthRcrd(indCtznshpLifeInsBrthRcrd);
    }
    if (hasIndCtznshpLoclGovtBrthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpLoclGovtBrthRcrd(indCtznshpLoclGovtBrthRcrd);
    }
    if (hasIndCtznshpMedBirthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpMedBirthRcrd(indCtznshpMedBirthRcrd);
    }
    if (hasIndCtznshpMiltryBirthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpMiltryBirthRcrd(indCtznshpMiltryBirthRcrd);
    }
    if (hasIndCtznshpNorthMarianaId) {
      eligibilityDeterminationDB.setIndCtznshpNorthMarianaId(indCtznshpNorthMarianaId);
    }
    if (hasIndCtznshpRefugee) {
      eligibilityDeterminationDB.setIndCtznshpRefugee(indCtznshpRefugee);
    }
    if (hasIndCtznshpReligBirthRcrd) {
      eligibilityDeterminationDB.setIndCtznshpReligBirthRcrd(indCtznshpReligBirthRcrd);
    }
    if (hasCdDeemRespType) {
      eligibilityDeterminationDB.setCdDeemRespType(cdDeemRespType);
    }
    if (hasIndDobApprox) {
      eligibilityDeterminationDB.setIndDobApprox(indDobApprox);
    }
    if (hasIndEligibilityCourtMonth) {
      eligibilityDeterminationDB.setIndEligibilityCourtMonth(indEligibilityCourtMonth);
    }
    if (hasIndEligible) {
      eligibilityDeterminationDB.setIndEligible(indEligible);
    }
    if (hasIndEquity) {
      eligibilityDeterminationDB.setIndEquity(indEquity);
    }
    if (hasIndChildEquity) {
      eligibilityDeterminationDB.setIndChildEquity(indChildEquity);
    }
    if (hasIndFatherPwe) {
      eligibilityDeterminationDB.setIndFatherPwe(indFatherPwe);
    }
    if (hasIndHomeIncomeAfdcElgblty) {
      eligibilityDeterminationDB.setIndHomeIncomeAfdcElgblty(indHomeIncomeAfdcElgblty);
    }
    if (hasIndMeetsDpOrNotEs) {
      eligibilityDeterminationDB.setIndMeetsDpOrNotEs(indMeetsDpOrNotEs);
    }
    if (hasIndMeetsDpOrNotSystem) {
      eligibilityDeterminationDB.setIndMeetsDpOrNotSystem(indMeetsDpOrNotSystem);
    }
    if (hasIndMotherPwe) {
      eligibilityDeterminationDB.setIndMotherPwe(indMotherPwe);
    }
    if (hasIndNarrativeApproved) {
      eligibilityDeterminationDB.setIndNarrativeApproved(indNarrativeApproved);
    }
    if (hasIndOtherVerification) {
      eligibilityDeterminationDB.setIndOtherVerification(indOtherVerification);
    }
    if (hasIndParentalDeprivation) {
      eligibilityDeterminationDB.setIndParentalDeprivation(indParentalDeprivation);
    }
    if (hasIndParentDisabled) {
      eligibilityDeterminationDB.setIndParentDisabled(indParentDisabled);
    }
    if (hasIndPeNotAcptEmpTrn) {
      eligibilityDeterminationDB.setIndPeNotAcptEmpTrn(indPeNotAcptEmpTrn);
    }
    if (hasIndPeRecvUnemp) {
      eligibilityDeterminationDB.setIndPeRecvUnemp(indPeRecvUnemp);
    }
    if (hasIndPeWrkEngEduTrn) {
      eligibilityDeterminationDB.setIndPeWrkEngEduTrn(indPeWrkEngEduTrn);
    }
    if (hasIndPersonHmRemoval) {
      eligibilityDeterminationDB.setIndPersonHmRemoval(indPersonHmRemoval);
    }
    if (hasIndPrsManagingCvs) {
      eligibilityDeterminationDB.setIndPrsManagingCvs(indPrsManagingCvs);
    }
    if (hasIndRecv100PctVa) {
      eligibilityDeterminationDB.setIndRecv100PctVa(indRecv100PctVa);
    }
    if (hasIndRecvRrRsdi) {
      eligibilityDeterminationDB.setIndRecvRrRsdi(indRecvRrRsdi);
    }
    if (hasIndRemovalChildOrdered) {
      eligibilityDeterminationDB.setIndRemovalChildOrdered(indRemovalChildOrdered);
    }
    if (hasIndRsdiVerification) {
      eligibilityDeterminationDB.setIndRsdiVerification(indRsdiVerification);
    }
    if (hasIndRsnblEffortPrvtRemoval) {
      eligibilityDeterminationDB.setIndRsnblEffortPrvtRemoval(indRsnblEffortPrvtRemoval);
    }
    if (hasIndSsiVerification) {
      eligibilityDeterminationDB.setIndSsiVerification(indSsiVerification);
    }
    if (hasNbrAge) {
      eligibilityDeterminationDB.setNbrAge(nbrAge);
    }
    if (hasNbrCertifiedGroup) {
      eligibilityDeterminationDB.setNbrCertifiedGroup(nbrCertifiedGroup);
    }
    if (hasNbrDeemChildNotInAU) {
      eligibilityDeterminationDB.setNbrDeemChildNotInAU(nbrDeemChildNotInAU);
    }
    if (hasNbrDeemResponseIndiv) {
      eligibilityDeterminationDB.setNbrDeemResponseIndiv(nbrDeemResponseIndiv);
    }
    if (hasNbrDeemPersonSONLookup) {
      eligibilityDeterminationDB.setNbrDeemPersonSONLookup(nbrDeemPersonSONLookup);
    }
    if (hasNbrDeemTaxDependNotInAU) {
      eligibilityDeterminationDB.setNbrDeemTaxDependNotInAU(nbrDeemTaxDependNotInAU);
    }
    if (hasNbrIneligChildAllocMutual) {
      eligibilityDeterminationDB.setNbrIneligChildAllocMutual(nbrIneligChildAllocMutual);
    }
    if (hasNbrIneligChildAllocSngl1) {
      eligibilityDeterminationDB.setNbrIneligChildAllocSngl1(nbrIneligChildAllocSngl1);
    }
    if (hasNbrIneligChildAllocSngl2) {
      eligibilityDeterminationDB.setNbrIneligChildAllocSngl2(nbrIneligChildAllocSngl2);
    }
    if (hasNbrIneligPersonAllocMutual) {
      eligibilityDeterminationDB.setNbrIneligPersonAllocMutual(nbrIneligPersonAllocMutual);
    }
    if (hasNbrIneligPersonAllocSngl1) {
      eligibilityDeterminationDB.setNbrIneligPersonAllocSngl1(nbrIneligPersonAllocSngl1);
    }
    if (hasNbrIneligPersonAllocSngl2) {
      eligibilityDeterminationDB.setNbrIneligPersonAllocSngl2(nbrIneligPersonAllocSngl2);
    }
    if (hasNbrIneligSpouseAllocMutual) {
      eligibilityDeterminationDB.setNbrIneligSpouseAllocMutual(nbrIneligSpouseAllocMutual);
    }
    if (hasNbrIneligSpouseAllocSngl1) {
      eligibilityDeterminationDB.setNbrIneligSpouseAllocSngl1(nbrIneligSpouseAllocSngl1);
    }
    if (hasNbrIneligSpouseAllocSngl2) {
      eligibilityDeterminationDB.setNbrIneligSpouseAllocSngl2(nbrIneligSpouseAllocSngl2);
    }
    if (hasNbrParentsHome) {
      eligibilityDeterminationDB.setNbrParentsHome(nbrParentsHome);
    }
    if(hasNonAUMembers){
      eligibilityDeterminationDB.setNonAUMembers(nonAUMembers);
    }
    if(hasPrincipals){
      eligibilityDeterminationDB.setPrincipals(principals);
    }
    if (hasTxtDeterminationComments) {
      eligibilityDeterminationDB.setTxtDeterminationComments(txtDeterminationComments);
    }
    if (hasTxtMonthsDepUnemp) {
      eligibilityDeterminationDB.setTxtMonthsDepUnemp(txtMonthsDepUnemp);
    }
    if (hasIdEvent) {
      eligibilityDeterminationDB.setIdEvent(idEvent);
    }
    if (hasCdEventStatus) {
      eligibilityDeterminationDB.setCdEventStatus(cdEventStatus);
    }
    if (hasReasonsNotEligible) {
      eligibilityDeterminationDB.setReasonsNotEligible(reasonsNotEligible);
    }
    if (hasAmtStandardOfNeed) {
      eligibilityDeterminationDB.setAmtStandardOfNeed(amtStandardOfNeed);
    }
    if (hasAmtGrossIncomeCeiling) {
      eligibilityDeterminationDB.setAmtGrossIncomeCeiling(amtGrossIncomeCeiling);
    }
    if (hasAmtDependentCareDeduc) {
      eligibilityDeterminationDB.setAmtDependentCareDeduc(amtDependentCareDeduc);
    }
    if (hasAmtAllocAllowance) {
      eligibilityDeterminationDB.setAmtAllocAllowance(amtAllocAllowance);
    }
    if (hasAmtCountableIncomeStdNeed) {
      eligibilityDeterminationDB.setAmtCountableIncomeStdNeed(amtCountableIncomeStdNeed);
    }
    if (hasAmtCountableIncome30OneThird) {
      eligibilityDeterminationDB.setAmtCountableIncome30OneThird(amtCountableIncome30OneThird);
    }
    if (hasAmtCtnblResourceChild) {
      eligibilityDeterminationDB.setAmtCtnblResourceChild(amtCtnblResourceChild);
    }
    if (hasAmtGrossEarnedChild) {
      eligibilityDeterminationDB.setAmtGrossEarnedChild(amtGrossEarnedChild);
    }
    if (hasAmtGrossUnEarnedChild) {
      eligibilityDeterminationDB.setAmtGrossUnEarnedChild(amtGrossUnEarnedChild);
    }
    if (hasAmtTotalGrossIncomeChild) {
      eligibilityDeterminationDB.setAmtTotalGrossIncomeChild(amtTotalGrossIncomeChild);
    }
    if (hasAmtCntblIncStdNeedChild) {
      eligibilityDeterminationDB.setAmtCntblIncStdNeedChild(amtCntblIncStdNeedChild);
    }
    if (hasAmtCntblInc30OneThirdChild) {
      eligibilityDeterminationDB.setAmtCntblInc30OneThirdChild(amtCntblInc30OneThirdChild);
    }
    if (hasIndCtnblResChildElgblty) {
      eligibilityDeterminationDB.setIndCtnblResChildElgblty(indCtnblResChildElgblty);
    }
    if (hasIndGrossIncChildElgblty) {
      eligibilityDeterminationDB.setIndGrossIncChildElgblty(indGrossIncChildElgblty);
    }
    if (hasIndStdOfNeedChildTestElgblty) {
      eligibilityDeterminationDB.setIndStdOfNeedChildTestElgblty(indStdOfNeedChildTestElgblty);
    }
    if (hasInd30OneThirdChildTestElgblty) {
      eligibilityDeterminationDB.setInd30OneThirdChildTestElgblty(ind30OneThirdChildTestElgblty);
    }
    if (hasIndGrossIncCeilingElgblty) {
      eligibilityDeterminationDB.setIndGrossIncCeilingElgblty(indGrossIncCeilingElgblty);
    }
    if (hasAmtDepCareDeducChild) {
      eligibilityDeterminationDB.setAmtDepCareDeducChild(amtDepCareDeducChild);
    }
    if (hasAmtGrossIncomeCeilingChild) {
      eligibilityDeterminationDB.setAmtGrossIncomeCeilingChild(amtGrossIncomeCeilingChild);
    }
    if (hasAmtStdOfNeedChild) {
      eligibilityDeterminationDB.setAmtStdOfNeedChild(amtStdOfNeedChild);
    }
    if (hasIndChildReceivingSSI) {
      eligibilityDeterminationDB.setIndChildReceivingSSI(indChildReceivingSSI);
    }
    if (hasAmtCsupWithUnearnedIncome) {
      eligibilityDeterminationDB.setAmtCsupWithUnearnedIncome(amtCsupWithUnearnedIncome);
    }
  }

  
  public FcePersonDB getFcePerson() {
    FcePersonDB fcePersonDB = new FcePersonDB();
    if (hasAmtCntblIncome) {
      fcePersonDB.setAmtCntblIncome(amtCntblIncome);
    }
    if (hasAmtCntblIncome30) {
      fcePersonDB.setAmtCntblIncome30(amtCntblIncome30);
    }
    if (hasAmtCntblIncomeLess30) {
      fcePersonDB.setAmtCntblIncomeLess30(amtCntblIncomeLess30);
    }
    if (hasAmtCntblIncomeLessThird) {
      fcePersonDB.setAmtCntblIncomeLessThird(amtCntblIncomeLessThird);
    }
    if (hasAmtCntblIncomeThird) {
      fcePersonDB.setAmtCntblIncomeThird(amtCntblIncomeThird);
    }
    if (hasAmtGrossEarnedIncome) {
      fcePersonDB.setAmtGrossEarnedIncome(amtGrossEarnedIncome);
    }
    if (hasAmtGrossUnearnedIncome) {
      fcePersonDB.setAmtGrossUnearnedIncome(amtGrossUnearnedIncome);
    }
    if (hasAmtStdEarnedIncomeDeduct) {
      fcePersonDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeduct);
    }
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
    if (fcePersonDB.hasAmtCntblIncome()) {
      setAmtCntblIncome(fcePersonDB.getAmtCntblIncomeObject());
    }
    if (fcePersonDB.hasAmtCntblIncome30()) {
      setAmtCntblIncome30(fcePersonDB.getAmtCntblIncome30Object());
    }
    if (fcePersonDB.hasAmtCntblIncomeLess30()) {
      setAmtCntblIncomeLess30(fcePersonDB.getAmtCntblIncomeLess30Object());
    }
    if (fcePersonDB.hasAmtCntblIncomeLessThird()) {
      setAmtCntblIncomeLessThird(fcePersonDB.getAmtCntblIncomeLessThirdObject());
    }
    if (fcePersonDB.hasAmtCntblIncomeThird()) {
      setAmtCntblIncomeThird(fcePersonDB.getAmtCntblIncomeThirdObject());
    }
    if (fcePersonDB.hasAmtGrossEarnedIncome()) {
      setAmtGrossEarnedIncome(fcePersonDB.getAmtGrossEarnedIncomeObject());
    }
    if (fcePersonDB.hasAmtGrossUnearnedIncome()) {
      setAmtGrossUnearnedIncome(fcePersonDB.getAmtGrossUnearnedIncomeObject());
    }
    if (fcePersonDB.hasAmtStdEarnedIncomeDeduct()) {
      setAmtStdEarnedIncomeDeduct(fcePersonDB.getAmtStdEarnedIncomeDeductObject());
    }
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
    if (hasAmtAllocAllowanceMutual) {
      fceEligibilityDB.setAmtAllocAllowanceMutual(amtAllocAllowanceMutual);
    }
    if (hasAmtAllocAllowanceSngl1) {
      fceEligibilityDB.setAmtAllocAllowanceSngl1(amtAllocAllowanceSngl1);
    }
    if (hasAmtAllocAllowanceSngl2) {
      fceEligibilityDB.setAmtAllocAllowanceSngl2(amtAllocAllowanceSngl2);
    }
    if (hasAmtCountableIncome) {
      fceEligibilityDB.setAmtCountableIncome(amtCountableIncome);
    }
    if (hasAmtChsupChild) {
      fceEligibilityDB.setAmtChsupChild(amtChsupChild);
    }
    if (hasAmtChsupCrtfdGrp) {
      fceEligibilityDB.setAmtChsupCrtfdGrp(amtChsupCrtfdGrp);
    }
    if (hasAmtCntIncomeEligChild) {
      fceEligibilityDB.setAmtCntIncomeEligChild(amtCntIncomeEligChild);
    }
    if (hasAmtCntIncomeEligCrtfdGrp) {
      fceEligibilityDB.setAmtCntIncomeEligCrtfdGrp(amtCntIncomeEligCrtfdGrp);
    }
    if (hasAmtDeemAlimonyOutsideHh) {
      fceEligibilityDB.setAmtDeemAlimonyOutsideHh(amtDeemAlimonyOutsideHh);
    }
    if (hasAmtDeemCntNetIncome) {
      fceEligibilityDB.setAmtDeemCntNetIncome(amtDeemCntNetIncome);
    }
    if (hasAmtDeemGrossEarnedIncome) {
      fceEligibilityDB.setAmtDeemGrossEarnedIncome(amtDeemGrossEarnedIncome);
    }
    if (hasAmtDeemLessStdOfNeed) {
      fceEligibilityDB.setAmtDeemLessStdOfNeed(amtDeemLessStdOfNeed);
    }
    if (hasAmtDeemNetEarnedIncome) {
      fceEligibilityDB.setAmtDeemNetEarnedIncome(amtDeemNetEarnedIncome);
    }
    if (hasAmtDeemStdEarnedIncDeduct) {
      fceEligibilityDB.setAmtDeemStdEarnedIncDeduct(amtDeemStdEarnedIncDeduct);
    }
    if (hasAmtDeemStdOfNeed) {
      fceEligibilityDB.setAmtDeemStdOfNeed(amtDeemStdOfNeed);
    }
    if (hasAmtDeemSurplusOrDeficit) {
      fceEligibilityDB.setAmtDeemSurplusOrDeficit(amtDeemSurplusOrDeficit);
    }
    if (hasAmtDeemTaxDependOutHh) {
      fceEligibilityDB.setAmtDeemTaxDependOutHh(amtDeemTaxDependOutHh);
    }
    if (hasAmtDeemTotal) {
      fceEligibilityDB.setAmtDeemTotal(amtDeemTotal);
    }
    if (hasAmtDeemUnearnedIncome) {
      fceEligibilityDB.setAmtDeemUnearnedIncome(amtDeemUnearnedIncome);
    }
    if (hasAmtEarnedLessAllDeduct) {
      fceEligibilityDB.setAmtEarnedLessAllDeduct(amtEarnedLessAllDeduct);
    }
    if (hasAmtEarnedLessStdDeduct) {
      fceEligibilityDB.setAmtEarnedLessStdDeduct(amtEarnedLessStdDeduct);
    }
    if (hasAmtGicSurpDefctChild) {
      fceEligibilityDB.setAmtGicSurpDefctChild(amtGicSurpDefctChild);
    }
    if (hasAmtGicSurpDefctCrtfdGrp) {
      fceEligibilityDB.setAmtGicSurpDefctCrtfdGrp(amtGicSurpDefctCrtfdGrp);
    }
    if (hasAmtGrossEarnedCrtfdGrp) {
      fceEligibilityDB.setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp);
    }
    if (hasAmtGrossIncomeAllocMutual) {
      fceEligibilityDB.setAmtGrossIncomeAllocMutual(amtGrossIncomeAllocMutual);
    }
    if (hasAmtGrossIncomeAllocSngl1) {
      fceEligibilityDB.setAmtGrossIncomeAllocSngl1(amtGrossIncomeAllocSngl1);
    }
    if (hasAmtGrossIncomeAllocSngl2) {
      fceEligibilityDB.setAmtGrossIncomeAllocSngl2(amtGrossIncomeAllocSngl2);
    }
    if (hasAmtGrossIncomeCrtfdGrp) {
      fceEligibilityDB.setAmtGrossIncomeCrtfdGrp(amtGrossIncomeCrtfdGrp);
    }
    if (hasAmtGrossIncomeChild) {
      fceEligibilityDB.setAmtGrossIncomeChild(amtGrossIncomeChild);
    }
    if (hasAmtLessAllocElig) {
      fceEligibilityDB.setAmtLessAllocElig(amtLessAllocElig);
    }
    if (hasAmtLessAllocStdNeed) {
      fceEligibilityDB.setAmtLessAllocStdNeed(amtLessAllocStdNeed);
    }
    if (hasAmtLessDepCareElig) {
      fceEligibilityDB.setAmtLessDepCareElig(amtLessDepCareElig);
    }
    if (hasAmtLessDepCareStdNeed) {
      fceEligibilityDB.setAmtLessDepCareStdNeed(amtLessDepCareStdNeed);
    }
    if (hasAmtNetEarnedIncome) {
      fceEligibilityDB.setAmtNetEarnedIncome(amtNetEarnedIncome);
    }
    if (hasAmtNetEarnedIncomeChild) {
      fceEligibilityDB.setAmtNetEarnedIncomeChild(amtNetEarnedIncomeChild);
    }
    if (hasAmtNonexmptRsrcCrtfdGrp) {
      fceEligibilityDB.setAmtNonexmptRsrcCrtfdGrp(amtNonexmptRsrcCrtfdGrp);
    }
    if (hasAmtPlusChsupChild) {
      fceEligibilityDB.setAmtPlusChsupChild(amtPlusChsupChild);
    }
    if (hasAmtPlusChsupCrtfdGrp) {
      fceEligibilityDB.setAmtPlusChsupCrtfdGrp(amtPlusChsupCrtfdGrp);
    }
    if (hasAmtPlusDeemedElig) {
      fceEligibilityDB.setAmtPlusDeemedElig(amtPlusDeemedElig);
    }
    if (hasAmtPlusDeemedStdNeed) {
      fceEligibilityDB.setAmtPlusDeemedStdNeed(amtPlusDeemedStdNeed);
    }
    if (hasAmtPlusUnearnedElig) {
      fceEligibilityDB.setAmtPlusUnearnedElig(amtPlusUnearnedElig);
    }
    if (hasAmtPlusUnearnedStdNeed) {
      fceEligibilityDB.setAmtPlusUnearnedStdNeed(amtPlusUnearnedStdNeed);
    }
    if (hasAmtResourceLimitChild) {
      fceEligibilityDB.setAmtResourceLimitChild(amtResourceLimitChild);
    }
    if (hasAmtResourceLimitCrtfdGrp) {
      fceEligibilityDB.setAmtResourceLimitCrtfdGrp(amtResourceLimitCrtfdGrp);
    }
    if (hasAmtStdEarnedIncomeDeduct) {
      fceEligibilityDB.setAmtStdEarnedIncomeDeduct(amtStdEarnedIncomeDeduct);
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
    if (hasAmtStdOfNeedAllocMutual) {
      fceEligibilityDB.setAmtStdOfNeedAllocMutual(amtStdOfNeedAllocMutual);
    }
    if (hasAmtStdOfNeedAllocSngl1) {
      fceEligibilityDB.setAmtStdOfNeedAllocSngl1(amtStdOfNeedAllocSngl1);
    }
    if (hasAmtStdOfNeedAllocSngl2) {
      fceEligibilityDB.setAmtStdOfNeedAllocSngl2(amtStdOfNeedAllocSngl2);
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
    if (hasAmtSurpDefctEligChild) {
      fceEligibilityDB.setAmtSurpDefctEligChild(amtSurpDefctEligChild);
    }    
    if (hasAmtSurpDefctEligCrtfdGrp) {
      fceEligibilityDB.setAmtSurpDefctEligCrtfdGrp(amtSurpDefctEligCrtfdGrp);
    }
    if (hasAmtSurpDefctStdNeed) {
      fceEligibilityDB.setAmtSurpDefctStdNeed(amtSurpDefctStdNeed);
    }
    if (hasCdAllocType) {
      fceEligibilityDB.setCdAllocType(cdAllocType);
    }
    if (hasCdBlocChild) {
      fceEligibilityDB.setCdBlocChild(cdBlocChild);
    }
    if (hasCdDeemIndivRel1) {
      fceEligibilityDB.setCdDeemIndivRel1(cdDeemIndivRel1);
    }
    if (hasCdDeemIndivRel2) {
      fceEligibilityDB.setCdDeemIndivRel2(cdDeemIndivRel2);
    }
    if (hasCdDeemSurplusOrDeficit) {
      fceEligibilityDB.setCdDeemSurplusOrDeficit(cdDeemSurplusOrDeficit);
    }
    if (hasCdEligibilityActual) {
      fceEligibilityDB.setCdEligibilityActual(cdEligibilityActual);
    }
    if (hasCdEligibilitySelected) {
      fceEligibilityDB.setCdEligibilitySelected(cdEligibilitySelected);
    }
    if (hasCdEligSurpDefctChild) {
      fceEligibilityDB.setCdEligSurpDefctChild(cdEligSurpDefctChild);
    }
    if (hasCdEligSurpDefctCrtfdGrp) {
      fceEligibilityDB.setCdEligSurpDefctCrtfdGrp(cdEligSurpDefctCrtfdGrp);
    }
    if (hasCdGicSurpDefctChild) {
      fceEligibilityDB.setCdGicSurpDefctChild(cdGicSurpDefctChild);
    }
    if (hasCdGicSurpDefctCrtfdGrp) {
      fceEligibilityDB.setCdGicSurpDefctCrtfdGrp(cdGicSurpDefctCrtfdGrp);
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
    if (hasCdStdTestSurpDefct) {
      fceEligibilityDB.setCdStdTestSurpDefct(cdStdTestSurpDefct);
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
    if (hasIdPersonAllocMutual1) {
      fceEligibilityDB.setIdPersonAllocMutual1(idPersonAllocMutual1);
    }           
    if (hasIdPersonAllocMutual2) {
      fceEligibilityDB.setIdPersonAllocMutual2(idPersonAllocMutual2);
    }
    if (hasIdPersonAllocSngl1) {
      fceEligibilityDB.setIdPersonAllocSngl1(idPersonAllocSngl1);
    }
    if (hasIdPersonAllocSngl2) {
      fceEligibilityDB.setIdPersonAllocSngl2(idPersonAllocSngl2);
    }
    if (hasIdPersonDeemIndiv1) {
      fceEligibilityDB.setIdPersonDeemIndiv1(idPersonDeemIndiv1);
    }
    if (hasIdPersonDeemIndiv2) {
      fceEligibilityDB.setIdPersonDeemIndiv2(idPersonDeemIndiv2);
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
    if (hasCdDeemRespType) {
      fceEligibilityDB.setCdDeemRespType(cdDeemRespType);
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
    if (hasIndChildEquity) {
      fceEligibilityDB.setIndChildEquity(indChildEquity);
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
    if (hasNbrDeemChildNotInAU) {
      fceEligibilityDB.setNbrDeemChildNotInAU(nbrDeemChildNotInAU);
    }
    if (hasNbrDeemResponseIndiv) {
      fceEligibilityDB.setNbrDeemResponseIndiv(nbrDeemResponseIndiv);
    }
    if (hasNbrDeemPersonSONLookup) {
      fceEligibilityDB.setNbrDeemPersonSONLookup(nbrDeemPersonSONLookup);
    }
    if (hasNbrDeemTaxDependNotInAU) {
      fceEligibilityDB.setNbrDeemTaxDependNotInAU(nbrDeemTaxDependNotInAU);
    }
    if (hasNbrIneligChildAllocMutual) {
      fceEligibilityDB.setNbrIneligChildAllocMutual(nbrIneligChildAllocMutual);
    }
    if (hasNbrIneligChildAllocSngl1) {
      fceEligibilityDB.setNbrIneligChildAllocSngl1(nbrIneligChildAllocSngl1);
    }
    if (hasNbrIneligChildAllocSngl2) {
      fceEligibilityDB.setNbrIneligChildAllocSngl2(nbrIneligChildAllocSngl2);
    }
    if (hasNbrIneligPersonAllocMutual) {
      fceEligibilityDB.setNbrIneligPersonAllocMutual(nbrIneligPersonAllocMutual);
    }
    if (hasNbrIneligPersonAllocSngl1) {
      fceEligibilityDB.setNbrIneligPersonAllocSngl1(nbrIneligPersonAllocSngl1);
    }
    if (hasNbrIneligPersonAllocSngl2) {
      fceEligibilityDB.setNbrIneligPersonAllocSngl2(nbrIneligPersonAllocSngl2);
    }
    if (hasNbrIneligSpouseAllocMutual) {
      fceEligibilityDB.setNbrIneligSpouseAllocMutual(nbrIneligSpouseAllocMutual);
    }
    if (hasNbrIneligSpouseAllocSngl1) {
      fceEligibilityDB.setNbrIneligSpouseAllocSngl1(nbrIneligSpouseAllocSngl1);
    }
    if (hasNbrIneligSpouseAllocSngl2) {
      fceEligibilityDB.setNbrIneligSpouseAllocSngl2(nbrIneligSpouseAllocSngl2);
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
    if (hasAmtStandardOfNeed) {
      fceEligibilityDB.setAmtStandardOfNeed(amtStandardOfNeed);
    }
    if (hasAmtGrossIncomeCeiling) {
      fceEligibilityDB.setAmtGrossIncomeCeiling(amtGrossIncomeCeiling);
    }
    if (hasAmtDependentCareDeduc) {
      fceEligibilityDB.setAmtDependentCareDeduc(amtDependentCareDeduc);
    }
    if (hasAmtAllocAllowance) {
      fceEligibilityDB.setAmtAllocAllowance(amtAllocAllowance);
    }
    if (hasAmtCountableIncomeStdNeed) {
      fceEligibilityDB.setAmtCountableIncomeStdNeed(amtCountableIncomeStdNeed);
    }
    if (hasAmtCountableIncome30OneThird) {
      fceEligibilityDB.setAmtCountableIncome30OneThird(amtCountableIncome30OneThird);
    }
    if (hasAmtCtnblResourceChild) {
      fceEligibilityDB.setAmtCtnblResourceChild(amtCtnblResourceChild);
    }
    if (hasAmtGrossEarnedChild) {
      fceEligibilityDB.setAmtGrossEarnedChild(amtGrossEarnedChild);
    }
    if (hasAmtGrossUnEarnedChild) {
      fceEligibilityDB.setAmtGrossUnEarnedChild(amtGrossUnEarnedChild);
    }
    if (hasAmtTotalGrossIncomeChild) {
      fceEligibilityDB.setAmtTotalGrossIncomeChild(amtTotalGrossIncomeChild);
    }
    if (hasAmtCntblIncStdNeedChild) {
      fceEligibilityDB.setAmtCntblIncStdNeedChild(amtCntblIncStdNeedChild);
    }
    if (hasAmtCntblInc30OneThirdChild) {
      fceEligibilityDB.setAmtCntblInc30OneThirdChild(amtCntblInc30OneThirdChild);
    }
    if (hasIndCtnblResChildElgblty) {
      fceEligibilityDB.setIndCtnblResChildElgblty(indCtnblResChildElgblty);
    }
    if (hasIndGrossIncChildElgblty) {
      fceEligibilityDB.setIndGrossIncChildElgblty(indGrossIncChildElgblty);
    }
    if (hasIndStdOfNeedChildTestElgblty) {
      fceEligibilityDB.setIndStdOfNeedChildTestElgblty(indStdOfNeedChildTestElgblty);
    }
    if (hasInd30OneThirdChildTestElgblty) {
      fceEligibilityDB.setInd30OneThirdChildTestElgblty(ind30OneThirdChildTestElgblty);
    }
    if (hasIndGrossIncCeilingElgblty) {
      fceEligibilityDB.setIndGrossIncCeilingElgblty(indGrossIncCeilingElgblty);
    }
    if (hasAmtDepCareDeducChild) {
      fceEligibilityDB.setAmtDepCareDeducChild(amtDepCareDeducChild);
    }
    if (hasAmtGrossIncomeCeilingChild) {
      fceEligibilityDB.setAmtGrossIncomeCeilingChild(amtGrossIncomeCeilingChild);
    }
    if (hasAmtStdOfNeedChild) {
      fceEligibilityDB.setAmtStdOfNeedChild(amtStdOfNeedChild);
    }
    if (hasIndChildReceivingSSI) {
      fceEligibilityDB.setIndChildReceivingSSI(indChildReceivingSSI);
    }
    if (hasAmtCsupWithUnearnedIncome) {
      fceEligibilityDB.setAmtCsupWithUnearnedIncome(amtCsupWithUnearnedIncome);
    }
    return fceEligibilityDB;
  }

  public void setFceEligibility(FceEligibilityDB fceEligibilityDB) {
    if (fceEligibilityDB.hasAmtAllocAllowanceMutual()) {
      setAmtAllocAllowanceMutual(fceEligibilityDB.getAmtAllocAllowanceMutualObject());
    }
    if (fceEligibilityDB.hasAmtAllocAllowanceSngl1()) {
      setAmtAllocAllowanceSngl1(fceEligibilityDB.getAmtAllocAllowanceSngl1Object());
    }
    if (fceEligibilityDB.hasAmtAllocAllowanceSngl2()) {
      setAmtAllocAllowanceSngl2(fceEligibilityDB.getAmtAllocAllowanceSngl2Object());
    }
    if (fceEligibilityDB.hasAmtCountableIncome()) {
      setAmtCountableIncome(fceEligibilityDB.getAmtCountableIncomeObject());
    }
    if (fceEligibilityDB.hasAmtChsupChild()) {
      setAmtChsupChild(fceEligibilityDB.getAmtChsupChildObject());
    }
    if (fceEligibilityDB.hasAmtChsupCrtfdGrp()) {
      setAmtChsupCrtfdGrp(fceEligibilityDB.getAmtChsupCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtCntIncomeEligChild()) {
      setAmtCntIncomeEligChild(fceEligibilityDB.getAmtCntIncomeEligChildObject());
    }
    if (fceEligibilityDB.hasAmtCntIncomeEligCrtfdGrp()) {
      setAmtCntIncomeEligCrtfdGrp(fceEligibilityDB.getAmtCntIncomeEligCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtDeemAlimonyOutsideHh()) {
      setAmtDeemAlimonyOutsideHh(fceEligibilityDB.getAmtDeemAlimonyOutsideHhObject());
    }
    if (fceEligibilityDB.hasAmtDeemCntNetIncome()) {
      setAmtDeemCntNetIncome(fceEligibilityDB.getAmtDeemCntNetIncomeObject());
    }
    if (fceEligibilityDB.hasAmtDeemGrossEarnedIncome()) {
      setAmtDeemGrossEarnedIncome(fceEligibilityDB.getAmtDeemGrossEarnedIncomeObject());
    }
    if (fceEligibilityDB.hasAmtDeemLessStdOfNeed()) {
      setAmtDeemLessStdOfNeed(fceEligibilityDB.getAmtDeemLessStdOfNeedObject());
    }
    if (fceEligibilityDB.hasAmtDeemNetEarnedIncome()) {
      setAmtDeemNetEarnedIncome(fceEligibilityDB.getAmtDeemNetEarnedIncomeObject());
    }
    if (fceEligibilityDB.hasAmtDeemStdEarnedIncDeduct()) {
      setAmtDeemStdEarnedIncDeduct(fceEligibilityDB.getAmtDeemStdEarnedIncDeductObject());
    }
    if (fceEligibilityDB.hasAmtDeemStdOfNeed()) {
      setAmtDeemStdOfNeed(fceEligibilityDB.getAmtDeemStdOfNeedObject());
    }
    if (fceEligibilityDB.hasAmtDeemSurplusOrDeficit()) {
      setAmtDeemSurplusOrDeficit(fceEligibilityDB.getAmtDeemSurplusOrDeficitObject());
    }
    if (fceEligibilityDB.hasAmtDeemTaxDependOutHh()) {
      setAmtDeemTaxDependOutHh(fceEligibilityDB.getAmtDeemTaxDependOutHhObject());
    }
    if (fceEligibilityDB.hasAmtDeemTotal()) {
      setAmtDeemTotal(fceEligibilityDB.getAmtDeemTotalObject());
    }
    if (fceEligibilityDB.hasAmtDeemUnearnedIncome()) {
      setAmtDeemUnearnedIncome(fceEligibilityDB.getAmtDeemUnearnedIncomeObject());
    }
    if (fceEligibilityDB.hasAmtEarnedLessAllDeduct()) {
      setAmtEarnedLessAllDeduct(fceEligibilityDB.getAmtEarnedLessAllDeductObject());
    }
    if (fceEligibilityDB.hasAmtEarnedLessStdDeduct()) {
      setAmtEarnedLessStdDeduct(fceEligibilityDB.getAmtEarnedLessStdDeductObject());
    }
    if (fceEligibilityDB.hasAmtGicSurpDefctChild()) {
      setAmtGicSurpDefctChild(fceEligibilityDB.getAmtGicSurpDefctChildObject());
    }
    if (fceEligibilityDB.hasAmtGicSurpDefctCrtfdGrp()) {
      setAmtGicSurpDefctCrtfdGrp(fceEligibilityDB.getAmtGicSurpDefctCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtGrossEarnedCrtfdGrp()) {
      setAmtGrossEarnedCrtfdGrp(fceEligibilityDB.getAmtGrossEarnedCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeAllocMutual()) {
      setAmtGrossIncomeAllocMutual(fceEligibilityDB.getAmtGrossIncomeAllocMutualObject());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeAllocSngl1()) {
      setAmtGrossIncomeAllocSngl1(fceEligibilityDB.getAmtGrossIncomeAllocSngl1Object());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeAllocSngl2()) {
      setAmtGrossIncomeAllocSngl2(fceEligibilityDB.getAmtGrossIncomeAllocSngl2Object());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeCrtfdGrp()) {
      setAmtGrossIncomeCrtfdGrp(fceEligibilityDB.getAmtGrossIncomeCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeChild()) {
      setAmtGrossIncomeChild(fceEligibilityDB.getAmtGrossIncomeChildObject());
    }
    if (fceEligibilityDB.hasAmtLessAllocElig()) {
      setAmtLessAllocElig(fceEligibilityDB.getAmtLessAllocEligObject());
    }
    if (fceEligibilityDB.hasAmtLessAllocStdNeed()) {
      setAmtLessAllocStdNeed(fceEligibilityDB.getAmtLessAllocStdNeedObject());
    }
    if (fceEligibilityDB.hasAmtLessDepCareElig()) {
      setAmtLessDepCareElig(fceEligibilityDB.getAmtLessDepCareEligObject());
    }
    if (fceEligibilityDB.hasAmtLessDepCareStdNeed()) {
      setAmtLessDepCareStdNeed(fceEligibilityDB.getAmtLessDepCareStdNeedObject());
    }
    if (fceEligibilityDB.hasAmtNetEarnedIncome()) {
      setAmtNetEarnedIncome(fceEligibilityDB.getAmtNetEarnedIncomeObject());
    }
    if (fceEligibilityDB.hasAmtNetEarnedIncomeChild()) {
      setAmtNetEarnedIncomeChild(fceEligibilityDB.getAmtNetEarnedIncomeChildObject());
    }
    if (fceEligibilityDB.hasAmtNonexmptRsrcCrtfdGrp()) {
      setAmtNonexmptRsrcCrtfdGrp(fceEligibilityDB.getAmtNonexmptRsrcCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtPlusChsupChild()) {
      setAmtPlusChsupChild(fceEligibilityDB.getAmtPlusChsupChildObject());
    }
    if (fceEligibilityDB.hasAmtPlusChsupCrtfdGrp()) {
      setAmtPlusChsupCrtfdGrp(fceEligibilityDB.getAmtPlusChsupCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtPlusDeemedElig()) {
      setAmtPlusDeemedElig(fceEligibilityDB.getAmtPlusDeemedEligObject());
    }
    if (fceEligibilityDB.hasAmtPlusDeemedStdNeed()) {
      setAmtPlusDeemedStdNeed(fceEligibilityDB.getAmtPlusDeemedStdNeedObject());
    }
    if (fceEligibilityDB.hasAmtPlusUnearnedElig()) {
      setAmtPlusUnearnedElig(fceEligibilityDB.getAmtPlusUnearnedEligObject());
    }
    if (fceEligibilityDB.hasAmtPlusUnearnedStdNeed()) {
      setAmtPlusUnearnedStdNeed(fceEligibilityDB.getAmtPlusUnearnedStdNeedObject());
    }
    if (fceEligibilityDB.hasAmtResourceLimitChild()) {
      setAmtResourceLimitChild(fceEligibilityDB.getAmtResourceLimitChildObject());
    }
    if (fceEligibilityDB.hasAmtResourceLimitCrtfdGrp()) {
      setAmtResourceLimitCrtfdGrp(fceEligibilityDB.getAmtResourceLimitCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtStdEarnedIncomeDeduct()) {
      setAmtStdEarnedIncomeDeduct(fceEligibilityDB.getAmtStdEarnedIncomeDeductObject());
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
    if (fceEligibilityDB.hasAmtStdOfNeedAllocMutual()) {
      setAmtStdOfNeedAllocMutual(fceEligibilityDB.getAmtStdOfNeedAllocMutualObject());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedAllocSngl1()) {
      setAmtStdOfNeedAllocSngl1(fceEligibilityDB.getAmtStdOfNeedAllocSngl1Object());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedAllocSngl2()) {
      setAmtStdOfNeedAllocSngl2(fceEligibilityDB.getAmtStdOfNeedAllocSngl2Object());
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
    if (fceEligibilityDB.hasAmtSurpDefctEligChild()) {
      setAmtSurpDefctEligChild(fceEligibilityDB.getAmtSurpDefctEligChildObject());
    }    
    if (fceEligibilityDB.hasAmtSurpDefctEligCrtfdGrp()) {
      setAmtSurpDefctEligCrtfdGrp(fceEligibilityDB.getAmtSurpDefctEligCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasAmtSurpDefctStdNeed()) {
      setAmtSurpDefctStdNeed(fceEligibilityDB.getAmtSurpDefctStdNeedObject());
    }
    if (fceEligibilityDB.hasCdAllocType()) {
      setCdAllocType(fceEligibilityDB.getCdAllocTypeObject());
    }
    if (fceEligibilityDB.hasCdBlocChild()) {
      setCdBlocChild(fceEligibilityDB.getCdBlocChildObject());
    }
    if (fceEligibilityDB.hasCdDeemIndivRel1()) {
      setCdDeemIndivRel1(fceEligibilityDB.getCdDeemIndivRel1Object());
    }
    if (fceEligibilityDB.hasCdDeemIndivRel2()) {
      setCdDeemIndivRel2(fceEligibilityDB.getCdDeemIndivRel2Object());
    }
    if (fceEligibilityDB.hasCdDeemSurplusOrDeficit()) {
      setCdDeemSurplusOrDeficit(fceEligibilityDB.getCdDeemSurplusOrDeficitObject());
    }
    if (fceEligibilityDB.hasCdEligibilityActual()) {
      setCdEligibilityActual(fceEligibilityDB.getCdEligibilityActualObject());
    }
    if (fceEligibilityDB.hasCdEligibilitySelected()) {
      setCdEligibilitySelected(fceEligibilityDB.getCdEligibilitySelectedObject());
    }
    if (fceEligibilityDB.hasCdEligSurpDefctChild()) {
      setCdEligSurpDefctChild(fceEligibilityDB.getCdEligSurpDefctChildObject());
    }
    if (fceEligibilityDB.hasCdEligSurpDefctCrtfdGrp()) {
      setCdEligSurpDefctCrtfdGrp(fceEligibilityDB.getCdEligSurpDefctCrtfdGrpObject());
    }
    if (fceEligibilityDB.hasCdGicSurpDefctChild()) {
      setCdGicSurpDefctChild(fceEligibilityDB.getCdGicSurpDefctChildObject());
    }
    if (fceEligibilityDB.hasCdGicSurpDefctCrtfdGrp()) {
      setCdGicSurpDefctCrtfdGrp(fceEligibilityDB.getCdGicSurpDefctCrtfdGrpObject());
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
    if (fceEligibilityDB.hasCdStdTestSurpDefct()) {
      setCdStdTestSurpDefct(fceEligibilityDB.getCdStdTestSurpDefct());
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
    if (fceEligibilityDB.hasIdPersonAllocMutual1()) {
      setIdPersonAllocMutual1(fceEligibilityDB.getIdPersonAllocMutual1Object());
    }           
    if (fceEligibilityDB.hasIdPersonAllocMutual2()) {
      setIdPersonAllocMutual2(fceEligibilityDB.getIdPersonAllocMutual2Object());
    }
    if (fceEligibilityDB.hasIdPersonAllocSngl1()) {
      setIdPersonAllocSngl1(fceEligibilityDB.getIdPersonAllocSngl1Object());
    }
    if (fceEligibilityDB.hasIdPersonAllocSngl2()) {
      setIdPersonAllocSngl2(fceEligibilityDB.getIdPersonAllocSngl2Object());
    }
    if (fceEligibilityDB.hasIdPersonDeemIndiv1()) {
      setIdPersonDeemIndiv1(fceEligibilityDB.getIdPersonDeemIndiv1Object());
    }
    if (fceEligibilityDB.hasIdPersonDeemIndiv2()) {
      setIdPersonDeemIndiv2(fceEligibilityDB.getIdPersonDeemIndiv2Object());
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
    if (fceEligibilityDB.hasCdDeemRespType()) {
      setCdDeemRespType(fceEligibilityDB.getCdDeemRespTypeObject());
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
    if (fceEligibilityDB.hasIndChildEquity()) {
      setIndChildEquity(fceEligibilityDB.getIndChildEquityObject());
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
    if (fceEligibilityDB.hasNbrDeemChildNotInAU()) {
      setNbrDeemChildNotInAU(fceEligibilityDB.getNbrDeemChildNotInAUObject());
    }
    if (fceEligibilityDB.hasNbrDeemResponseIndiv()) {
      setNbrDeemResponseIndiv(fceEligibilityDB.getNbrDeemResponseIndivObject());
    }
    if (fceEligibilityDB.hasNbrDeemPersonSONLookup()) {
      setNbrDeemPersonSONLookup(fceEligibilityDB.getNbrDeemPersonSONLookupObject());
    }
    if (fceEligibilityDB.hasNbrDeemTaxDependNotInAU()) {
      setNbrDeemTaxDependNotInAU(fceEligibilityDB.getNbrDeemTaxDependNotInAUObject());
    }
    if (fceEligibilityDB.hasNbrIneligChildAllocMutual()) {
      setNbrIneligChildAllocMutual(fceEligibilityDB.getNbrIneligChildAllocMutualObject());
    }
    if (fceEligibilityDB.hasNbrIneligChildAllocSngl1()) {
      setNbrIneligChildAllocSngl1(fceEligibilityDB.getNbrIneligChildAllocSngl1Object());
    }
    if (fceEligibilityDB.hasNbrIneligChildAllocSngl2()) {
      setNbrIneligChildAllocSngl2(fceEligibilityDB.getNbrIneligChildAllocSngl2Object());
    }
    if (fceEligibilityDB.hasNbrIneligPersonAllocMutual()) {
      setNbrIneligPersonAllocMutual(fceEligibilityDB.getNbrIneligPersonAllocMutualObject());
    }
    if (fceEligibilityDB.hasNbrIneligPersonAllocSngl1()) {
      setNbrIneligPersonAllocSngl1(fceEligibilityDB.getNbrIneligPersonAllocSngl1Object());
    }
    if (fceEligibilityDB.hasNbrIneligPersonAllocSngl2()) {
      setNbrIneligPersonAllocSngl2(fceEligibilityDB.getNbrIneligPersonAllocSngl2Object());
    }
    if (fceEligibilityDB.hasNbrIneligSpouseAllocMutual()) {
      setNbrIneligSpouseAllocMutual(fceEligibilityDB.getNbrIneligSpouseAllocMutualObject());
    }
    if (fceEligibilityDB.hasNbrIneligSpouseAllocSngl1()) {
      setNbrIneligSpouseAllocSngl1(fceEligibilityDB.getNbrIneligSpouseAllocSngl1Object());
    }
    if (fceEligibilityDB.hasNbrIneligSpouseAllocSngl2()) {
      setNbrIneligSpouseAllocSngl2(fceEligibilityDB.getNbrIneligSpouseAllocSngl2Object());
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
    if (fceEligibilityDB.hasAmtStandardOfNeed()) {
      setAmtStandardOfNeed(fceEligibilityDB.getAmtStandardOfNeed());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeCeiling()) {
      setAmtGrossIncomeCeiling(fceEligibilityDB.getAmtGrossIncomeCeiling());
    }
    if (fceEligibilityDB.hasAmtDependentCareDeduc()) {
      setAmtDependentCareDeduc(fceEligibilityDB.getAmtDependentCareDeduc());
    }
    if (fceEligibilityDB.hasAmtAllocAllowance()) {
      setAmtAllocAllowance(fceEligibilityDB.getAmtAllocAllowance());
    }
    if (fceEligibilityDB.hasAmtCountableIncomeStdNeed()) {
      setAmtCountableIncomeStdNeed(fceEligibilityDB.getAmtCountableIncomeStdNeed());
    }
    if (fceEligibilityDB.hasAmtCountableIncome30OneThird()) {
      setAmtCountableIncome30OneThird(fceEligibilityDB.getAmtCountableIncome30OneThird());
    }
    if (fceEligibilityDB.hasAmtCtnblResourceChild()) {
      setAmtCtnblResourceChild(fceEligibilityDB.getAmtCtnblResourceChild());
    }
    if (fceEligibilityDB.hasAmtGrossEarnedChild()) {
      setAmtGrossEarnedChild(fceEligibilityDB.getAmtGrossEarnedChild());
    }
    if (fceEligibilityDB.hasAmtGrossUnEarnedChild()) {
      setAmtGrossUnEarnedChild(fceEligibilityDB.getAmtGrossUnEarnedChild());
    }
    if (fceEligibilityDB.hasAmtTotalGrossIncomeChild()) {
      setAmtTotalGrossIncomeChild(fceEligibilityDB.getAmtTotalGrossIncomeChild());
    }
    if (fceEligibilityDB.hasAmtCntblIncStdNeedChild()) {
      setAmtCntblIncStdNeedChild(fceEligibilityDB.getAmtCntblIncStdNeedChild());
    }
    if (fceEligibilityDB.hasAmtCntblInc30OneThirdChild()) {
      setAmtCntblInc30OneThirdChild(fceEligibilityDB.getAmtCntblInc30OneThirdChild());
    }
    if (fceEligibilityDB.hasIndCtnblResChildElgblty()) {
      setIndCtnblResChildElgblty(fceEligibilityDB.getIndCtnblResChildElgblty());
    }
    if (fceEligibilityDB.hasIndGrossIncChildElgblty()) {
      setIndGrossIncChildElgblty(fceEligibilityDB.getIndGrossIncChildElgblty());
    }
    if (fceEligibilityDB.hasIndStdOfNeedChildTestElgblty()) {
      setIndStdOfNeedChildTestElgblty(fceEligibilityDB.getIndStdOfNeedChildTestElgblty());
    }
    if (fceEligibilityDB.hasInd30OneThirdChildTestElgblty()) {
      setInd30OneThirdChildTestElgblty(fceEligibilityDB.getInd30OneThirdChildTestElgblty());
    }
    if (fceEligibilityDB.hasIndGrossIncCeilingElgblty()) {
      setIndGrossIncCeilingElgblty(fceEligibilityDB.getIndGrossIncCeilingElgblty());
    }
    if (fceEligibilityDB.hasAmtDepCareDeducChild()) {
      setAmtDepCareDeducChild(fceEligibilityDB.getAmtDepCareDeducChild());
    }
    if (fceEligibilityDB.hasAmtGrossIncomeCeilingChild()) {
      setAmtGrossIncomeCeilingChild(fceEligibilityDB.getAmtGrossIncomeCeilingChild());
    }
    if (fceEligibilityDB.hasAmtStdOfNeedChild()) {
      setAmtStdOfNeedChild(fceEligibilityDB.getAmtStdOfNeedChild());
    }
    if (fceEligibilityDB.hasIndChildReceivingSSI()) {
      setIndChildReceivingSSI(fceEligibilityDB.getIndChildReceivingSSI());
    }
    if (fceEligibilityDB.hasAmtCsupWithUnearnedIncome()) {
      setAmtCsupWithUnearnedIncome(fceEligibilityDB.getAmtCsupWithUnearnedIncomeObject());
    }
  }

  public String toString() {
    return
            "BEGIN bean: EligibilityDetermination\n" +
            " amtAllocAllowanceMutual: " + amtAllocAllowanceMutual + "\n" +
            " amtAllocAllowanceSngl1: " + amtAllocAllowanceSngl1 + "\n" + 
            " amtAllocAllowanceSngl2: " + amtAllocAllowanceSngl2 + "\n" +
            " amtCountableIncome: " + amtCountableIncome + "\n" +
            " amtChsupChild: " + amtChsupChild + "\n" +
            " amtChsupCrtfdGrp: " + amtChsupCrtfdGrp + "\n" +
            " amtCntIncomeEligChild: " + amtCntIncomeEligChild + "\n" +  
            " amtCntIncomeEligCrtfdGrp: " + amtCntIncomeEligCrtfdGrp + "\n" +  
            " amtCntblIncome: " + amtCntblIncome + "\n" +   
            " amtCntblIncome30: " + amtCntblIncome30 + "\n" + 
            " amtCntblIncomeLess30: " + amtCntblIncomeLess30 + "\n" +  
            " amtCntblIncomeLessThird: " + amtCntblIncomeLessThird + "\n" +
            " amtCntblIncomeThird: " + amtCntblIncomeThird + "\n" +  
            " amtGrossEarnedIncome: " + amtGrossEarnedIncome + "\n" +
            " amtGrossUnearnedIncome: " + amtGrossUnearnedIncome + "\n" +
            " amtStdEarnedIncomeDeduct: " + amtStdEarnedIncomeDeduct + "\n" + 
            " amtDeemAlimonyOutsideHh: " + amtDeemAlimonyOutsideHh + "\n" +  
            " amtDeemCntNetIncome: " + amtDeemCntNetIncome + "\n" +  
            " amtDeemGrossEarnedIncome: " + amtDeemGrossEarnedIncome + "\n" +   
            " amtDeemLessStdOfNeed: " + amtDeemLessStdOfNeed + "\n" +   
            " amtDeemNetEarnedIncome: " + amtDeemNetEarnedIncome + "\n" + 
            " amtDeemStdEarnedIncDeduct: " + amtDeemStdEarnedIncDeduct + "\n" +  
            " amtDeemStdOfNeed: " + amtDeemStdOfNeed + "\n" +  
            " amtDeemSurplusOrDeficit: " + amtDeemSurplusOrDeficit + "\n" +  
            " amtDeemTaxDependOutHh: " + amtDeemTaxDependOutHh + "\n" +  
            " amtDeemTotal: " + amtDeemTotal + "\n" +  
            " amtDeemUnearnedIncome: " + amtDeemUnearnedIncome + "\n" +  
            " amtEarnedLessAllDeduct: " + amtEarnedLessAllDeduct + "\n" +  
            " amtEarnedLessStdDeduct: " + amtEarnedLessStdDeduct + "\n" +
            " amtGicSurpDefctChild: " + amtGicSurpDefctChild + "\n" +  
            " amtGicSurpDefctCrtfdGrp: " + amtGicSurpDefctCrtfdGrp + "\n" +
            " amtGrossEarnedCrtfdGrp: " + amtGrossEarnedCrtfdGrp + "\n" +
            " amtGrossIncomeAllocMutual: " + amtGrossIncomeAllocMutual + "\n" +  
            " amtGrossIncomeAllocSngl1: " + amtGrossIncomeAllocSngl1 + "\n" +  
            " amtGrossIncomeAllocSngl2: " + amtGrossIncomeAllocSngl2 + "\n" +  
            " amtGrossIncomeCrtfdGrp: " + amtGrossIncomeCrtfdGrp + "\n" +  
            " amtGrossIncomeChild: " + amtGrossIncomeChild + "\n" +  
            " amtLessAllocElig: " + amtLessAllocElig + "\n" +  
            " amtLessAllocStdNeed: " + amtLessAllocStdNeed + "\n" +  
            " amtLessDepCareElig: " + amtLessDepCareElig + "\n" +  
            " amtLessDepCareStdNeed: " + amtLessDepCareStdNeed + "\n" + 
            " amtNetEarnedIncome: " + amtNetEarnedIncome + "\n" +
            " amtNetEarnedIncomeChild: " + amtNetEarnedIncomeChild + "\n" +
            " amtNonexmptRsrcCrtfdGrp: " + amtNonexmptRsrcCrtfdGrp + "\n" +  
            " amtPlusChsupChild: " + amtPlusChsupChild + "\n" +  
            " amtPlusChsupCrtfdGrp: " + amtPlusChsupCrtfdGrp + "\n" +  
            " amtPlusDeemedElig: " + amtPlusDeemedElig + "\n" +  
            " amtPlusDeemedStdNeed: " + amtPlusDeemedStdNeed + "\n" +  
            " amtPlusUnearnedElig: " + amtPlusUnearnedElig + "\n" +  
            " amtPlusUnearnedStdNeed: " + amtPlusUnearnedStdNeed + "\n" +  
            " amtResourceLimitChild: " + amtResourceLimitChild + "\n" +  
            " amtResourceLimitCrtfdGrp: " + amtResourceLimitCrtfdGrp + "\n" +
            " amtGrossUnearnedCrtfdGrp: " + amtGrossUnearnedCrtfdGrp + "\n" +
            " amtIncomeLimit: " + amtIncomeLimit + "\n" +
            " amtPweIncome: " + amtPweIncome + "\n" +
            " amtSsi: " + amtSsi + "\n" +
            " amtStdOfNeedAllocMutual: " + amtStdOfNeedAllocMutual + "\n" +  
            " amtStdOfNeedAllocSngl1: " + amtStdOfNeedAllocSngl1 + "\n" +  
            " amtStdOfNeedAllocSngl2: " + amtStdOfNeedAllocSngl2 + "\n" + 
            " amtStepparentAlimony: " + amtStepparentAlimony + "\n" +
            " amtStepparentAllowance: " + amtStepparentAllowance + "\n" +
            " amtStepparentAppliedIncome: " + amtStepparentAppliedIncome + "\n" +
            " amtStepparentCntblUnearned: " + amtStepparentCntblUnearned + "\n" +
            " amtStepparentGrossEarned: " + amtStepparentGrossEarned + "\n" +
            " amtStepparentOutsidePmnt: " + amtStepparentOutsidePmnt + "\n" +
            " amtStepparentTotalCntbl: " + amtStepparentTotalCntbl + "\n" +
            " amtStepparentWorkDeduct: " + amtStepparentWorkDeduct + "\n" +
            " amtSurpDefctEligChild: " + amtSurpDefctEligChild + "\n" +  
            " amtSurpDefctEligCrtfdGrp: " + amtSurpDefctEligCrtfdGrp + "\n" +  
            " aUMembers: " + aUMembers.toString() + "\n" +
            " cdAllocType: " + cdAllocType + "\n" + 
            " cdBlocChild: " + cdBlocChild + "\n" +
            " cdDeemIndivRel1: " + cdDeemIndivRel1 + "\n" +    
            " cdDeemIndivRel2: " + cdDeemIndivRel2 + "\n" + 
            " cdDeemRespType: " + cdDeemRespType + "\n" +
            " cdDeemSurplusOrDeficit: " + cdDeemSurplusOrDeficit + "\n" +  
            " cdEligibilityActual: " + cdEligibilityActual + "\n" +
            " cdEligibilitySelected: " + cdEligibilitySelected + "\n" +
            " cdEligSurpDefctChild: " + cdEligSurpDefctChild + "\n" +  
            " cdEligSurpDefctCrtfdGrp: " + cdEligSurpDefctCrtfdGrp + "\n" +
            " cdGicSurpDefctChild: " + cdGicSurpDefctChild + "\n" +  
            " cdGicSurpDefctCrtfdGrp: " + cdGicSurpDefctCrtfdGrp + "\n" + 
            " cdMedicaidEligibilityType: " + cdMedicaidEligibilityType + "\n" +
            " fceEligibilityCdPersonCitizenship: " + fceEligibilityCdPersonCitizenship + "\n" +
            " cdPweIrregularUnder100: " + cdPweIrregularUnder100 + "\n" +
            " cdPweSteadyUnder100: " + cdPweSteadyUnder100 + "\n" +
            " cdRelInt: " + cdRelInt + "\n" +
            " cdStdTestSurpDefct: " + cdStdTestSurpDefct + "\n" +
            " cdVerifMethod: " + cdVerifMethod + "\n" +
            " cdVerifDocType: " + cdVerifDocType + "\n" +
            " dtBirth: " + dtBirth + "\n" +
            " fcePersonDtLastUpdate: " + fcePersonDtLastUpdate + "\n" +
            " dtDeprivationChanged: " + dtDeprivationChanged + "\n" +    
            " dtEligibilityEnd: " + dtEligibilityEnd + "\n" +
            " dtEligDtrmntnStart: " + dtEligDtrmntnStart + "\n" +
            " fceEligibilityDtLastUpdate: " + fceEligibilityDtLastUpdate + "\n" +
            " dtRemovalChildOrdered: " + dtRemovalChildOrdered + "\n" +
            " dtReviewDate: " + dtReviewDate + "\n" +
            " dtRsnblEffortPreventRem: " + dtRsnblEffortPreventRem + "\n" +
            " idCase: " + idCase + "\n" +
            " idEligibilityEvent: " + idEligibilityEvent + "\n" +
            " idFceApplication: " + idFceApplication + "\n" +
            " idFceEligibility: " + idFceEligibility + "\n" +
            " idFcePerson: " + idFcePerson + "\n" +
            " idFceReview: " + idFceReview + "\n" +
            " idLastUpdatePerson: " + idLastUpdatePerson + "\n" +
            " idPerson: " + idPerson + "\n" +
            " idPersonAllocMutual1: " + idPersonAllocMutual1 + "\n" +    
            " idPersonAllocMutual2: " + idPersonAllocMutual2 + "\n" + 
            " idPersonAllocSngl1: " + idPersonAllocSngl1 + "\n" + 
            " idPersonAllocSngl2: " + idPersonAllocSngl2 + "\n" + 
            " idPersonDeemIndiv1: " + idPersonDeemIndiv1 + "\n" + 
            " idPersonDeemIndiv2: " + idPersonDeemIndiv2 + "\n" + 
            " idPrnEarner: " + idPrnEarner + "\n" +
            " idStage: " + idStage + "\n" +
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
            " indCertifiedGroup: " + indCertifiedGroup + "\n" +
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
            " indDobApprox: " + indDobApprox + "\n" +
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
            " nbrAge: " + nbrAge + "\n" +
            " nbrCertifiedGroup: " + nbrCertifiedGroup + "\n" +
            " nbrDeemChildNotInAU: " + nbrDeemChildNotInAU + "\n" +  
            " nbrDeemResponseIndiv: " + nbrDeemResponseIndiv + "\n" +  
            " nbrDeemPersonSONLookup: " + nbrDeemPersonSONLookup + "\n" +  
            " nbrDeemTaxDependNotInAU: " + nbrDeemTaxDependNotInAU + "\n" +  
            " nbrIneligChildAllocMutual: " + nbrIneligChildAllocMutual + "\n" +  
            " nbrIneligChildAllocSngl1: " + nbrIneligChildAllocSngl1 + "\n" +  
            " nbrIneligChildAllocSngl2: " + nbrIneligChildAllocSngl2 + "\n" + 
            " nbrIneligPersonAllocMutual: " + nbrIneligPersonAllocMutual + "\n" +  
            " nbrIneligPersonAllocSngl1: " + nbrIneligPersonAllocSngl1 + "\n" + 
            " nbrIneligPersonAllocSngl2: " + nbrIneligPersonAllocSngl2 + "\n" + 
            " nbrIneligSpouseAllocMutual: " + nbrIneligSpouseAllocMutual + "\n" +  
            " nbrIneligSpouseAllocSngl1: " + nbrIneligSpouseAllocSngl1 + "\n" +  
            " nbrIneligSpouseAllocSngl2: " + nbrIneligSpouseAllocSngl2 + "\n" +
            " nbrParentsHome: " + nbrParentsHome + "\n" +
            " nonAUMembers: " + nonAUMembers.toString() + "\n" +
            " principals: " + principals.toString() + "\n" +
            " txtDeterminationComments: " + txtDeterminationComments + "\n" +
            " txtMonthsDepUnemp: " + txtMonthsDepUnemp + "\n" +
            " idEvent: " + idEvent + "\n" +
            " cdEventStatus: " + cdEventStatus + "\n" +
            " reasonsNotEligible: " + reasonsNotEligible + "\n" +
            " amtGrossIncomeCeiling: " + amtGrossIncomeCeiling + "\n" +
            " amtStandardOfNeed: " + amtStandardOfNeed + "\n" +
            " amtDependentCareDeduc: " + amtDependentCareDeduc + "\n" +
            " amtAllocAllowance: " + amtAllocAllowance + "\n" +
            " amtCountableIncomeStdNeed: " + amtCountableIncomeStdNeed + "\n" +
            " amtCountableIncome30OneThird: " + amtCountableIncome30OneThird + "\n" +
            " amtCtnblResourceChild: " + amtCtnblResourceChild + "\n" +
            " amtGrossEarnedChild: " + amtGrossEarnedChild + "\n" +
            " amtGrossUnEarnedChild: " + amtGrossUnEarnedChild + "\n" +
            " amtTotalGrossIncomeChild: " + amtTotalGrossIncomeChild + "\n" +
            " amtCntblIncStdNeedChild: " + amtCntblIncStdNeedChild + "\n" +
            " amtCntblInc30OneThirdChild: " + amtCntblInc30OneThirdChild + "\n" +
            " indCtnblResChildElgblty: " + indCtnblResChildElgblty + "\n" +
            " indGrossIncChildElgblty: " + indGrossIncChildElgblty + "\n" +
            " indGrossIncChildElgblty: " + indGrossIncChildElgblty + "\n" +
            " ind30OneThirdChildTestElgblty: " + ind30OneThirdChildTestElgblty + "\n" +
            " indGrossIncCeilingElgblty: " + indGrossIncCeilingElgblty + "\n" +
            " amtDepCareDeducChild: " + amtDepCareDeducChild + "\n" +
            " amtGrossIncomeCeilingChild: " + amtGrossIncomeCeilingChild + "\n" +
            " amtStdOfNeedChild: " + amtStdOfNeedChild + "\n" +
            " indChildReceivingSSI: " + indChildReceivingSSI + "\n" +
            " amtCsupWithUnearnedIncome: " + amtCsupWithUnearnedIncome + "\n" +
            "END bean: EligibilityDetermination\n";
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
