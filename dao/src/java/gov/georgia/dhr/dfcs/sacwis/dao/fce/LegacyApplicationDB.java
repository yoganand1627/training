//DO NOT MAKE ANY CHANGES TO THIS FILE
//IT IS GENERATED
//see Matthew McClain (PRSmmcclain) if a change needs to be made

package gov.georgia.dhr.dfcs.sacwis.dao.fce;

import java.io.Serializable;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public class LegacyApplicationDB implements Serializable, FceReviewPageDB {
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
  public static final String IND_PRS_MANAGING_CVS = "indPrsManagingCvs";
  public static final String IND_REMOVAL_CHILD_ORDERED = "indRemovalChildOrdered";
  public static final String IND_RSDI_VERIFICATION = "indRsdiVerification";
  public static final String IND_RSNBL_EFFORT_PRVT_REMOVAL = "indRsnblEffortPrvtRemoval";
  public static final String IND_SSI_VERIFICATION = "indSsiVerification";
  public static final String NBR_CERTIFIED_GROUP = "nbrCertifiedGroup";
  public static final String NBR_PARENTS_HOME = "nbrParentsHome";
  public static final String TXT_DETERMINATION_COMMENTS = "txtDeterminationComments";
  public static final String TXT_MONTHS_DEP_UNEMP = "txtMonthsDepUnemp";
  public static final String ID_EVENT = "idEvent";
  public static final String CD_EVENT_STATUS = "cdEventStatus";

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
  protected boolean hasIndPrsManagingCvs = false;
  protected Boolean indPrsManagingCvs = null;
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
  protected boolean hasIdEvent = false;
  protected Long idEvent = null;
  protected boolean hasCdEventStatus = false;
  protected String cdEventStatus = null;

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

  public void copyInto(LegacyApplicationDB legacyApplicationDB) {
    if (hasAmtCountableIncome) {
      legacyApplicationDB.setAmtCountableIncome(amtCountableIncome);
    }
    if (hasAmtGrossEarnedCrtfdGrp) {
      legacyApplicationDB.setAmtGrossEarnedCrtfdGrp(amtGrossEarnedCrtfdGrp);
    }
    if (hasAmtGrossUnearnedCrtfdGrp) {
      legacyApplicationDB.setAmtGrossUnearnedCrtfdGrp(amtGrossUnearnedCrtfdGrp);
    }
    if (hasAmtIncomeLimit) {
      legacyApplicationDB.setAmtIncomeLimit(amtIncomeLimit);
    }
    if (hasAmtPweIncome) {
      legacyApplicationDB.setAmtPweIncome(amtPweIncome);
    }
    if (hasAmtSsi) {
      legacyApplicationDB.setAmtSsi(amtSsi);
    }
    if (hasAmtStepparentAlimony) {
      legacyApplicationDB.setAmtStepparentAlimony(amtStepparentAlimony);
    }
    if (hasAmtStepparentAllowance) {
      legacyApplicationDB.setAmtStepparentAllowance(amtStepparentAllowance);
    }
    if (hasAmtStepparentAppliedIncome) {
      legacyApplicationDB.setAmtStepparentAppliedIncome(amtStepparentAppliedIncome);
    }
    if (hasAmtStepparentCntblUnearned) {
      legacyApplicationDB.setAmtStepparentCntblUnearned(amtStepparentCntblUnearned);
    }
    if (hasAmtStepparentGrossEarned) {
      legacyApplicationDB.setAmtStepparentGrossEarned(amtStepparentGrossEarned);
    }
    if (hasAmtStepparentOutsidePmnt) {
      legacyApplicationDB.setAmtStepparentOutsidePmnt(amtStepparentOutsidePmnt);
    }
    if (hasAmtStepparentTotalCntbl) {
      legacyApplicationDB.setAmtStepparentTotalCntbl(amtStepparentTotalCntbl);
    }
    if (hasAmtStepparentWorkDeduct) {
      legacyApplicationDB.setAmtStepparentWorkDeduct(amtStepparentWorkDeduct);
    }
    if (hasCdBlocChild) {
      legacyApplicationDB.setCdBlocChild(cdBlocChild);
    }
    if (hasCdEligibilityActual) {
      legacyApplicationDB.setCdEligibilityActual(cdEligibilityActual);
    }
    if (hasCdEligibilitySelected) {
      legacyApplicationDB.setCdEligibilitySelected(cdEligibilitySelected);
    }
    if (hasCdMedicaidEligibilityType) {
      legacyApplicationDB.setCdMedicaidEligibilityType(cdMedicaidEligibilityType);
    }
    if (hasFceEligibilityCdPersonCitizenship) {
      legacyApplicationDB.setFceEligibilityCdPersonCitizenship(fceEligibilityCdPersonCitizenship);
    }
    if (hasCdPweIrregularUnder100) {
      legacyApplicationDB.setCdPweIrregularUnder100(cdPweIrregularUnder100);
    }
    if (hasCdPweSteadyUnder100) {
      legacyApplicationDB.setCdPweSteadyUnder100(cdPweSteadyUnder100);
    }
    if (hasDtDeprivationChanged) {
      legacyApplicationDB.setDtDeprivationChanged(dtDeprivationChanged);
    } 
    if (hasDtEligibilityEnd) {
      legacyApplicationDB.setDtEligibilityEnd(dtEligibilityEnd);
    }
    if (hasDtEligDtrmntnStart) {
      legacyApplicationDB.setDtEligDtrmntnStart(dtEligDtrmntnStart);
    }
    if (hasFceEligibilityDtLastUpdate) {
      legacyApplicationDB.setFceEligibilityDtLastUpdate(fceEligibilityDtLastUpdate);
    }
    if (hasDtRemovalChildOrdered) {
      legacyApplicationDB.setDtRemovalChildOrdered(dtRemovalChildOrdered);
    }
    if (hasDtReviewDate) {
      legacyApplicationDB.setDtReviewDate(dtReviewDate);
    }
    if (hasDtRsnblEffortPreventRem) {
      legacyApplicationDB.setDtRsnblEffortPreventRem(dtRsnblEffortPreventRem);
    }
    if (hasIdCase) {
      legacyApplicationDB.setIdCase(idCase);
    }
    if (hasIdEligibilityEvent) {
      legacyApplicationDB.setIdEligibilityEvent(idEligibilityEvent);
    }
    if (hasIdFceApplication) {
      legacyApplicationDB.setIdFceApplication(idFceApplication);
    }
    if (hasIdFceEligibility) {
      legacyApplicationDB.setIdFceEligibility(idFceEligibility);
    }
    if (hasIdFcePerson) {
      legacyApplicationDB.setIdFcePerson(idFcePerson);
    }
    if (hasIdFceReview) {
      legacyApplicationDB.setIdFceReview(idFceReview);
    }
    if (hasIdLastUpdatePerson) {
      legacyApplicationDB.setIdLastUpdatePerson(idLastUpdatePerson);
    }
    if (hasIdPerson) {
      legacyApplicationDB.setIdPerson(idPerson);
    }
    if (hasIdStage) {
      legacyApplicationDB.setIdStage(idStage);
    }
    if (hasIndAbsentAltrntCustody) {
      legacyApplicationDB.setIndAbsentAltrntCustody(indAbsentAltrntCustody);
    }
    if (hasIndAbsentDeported) {
      legacyApplicationDB.setIndAbsentDeported(indAbsentDeported);
    }
    if (hasIndAbsentDeserted) {
      legacyApplicationDB.setIndAbsentDeserted(indAbsentDeserted);
    }
    if (hasIndAbsentDied) {
      legacyApplicationDB.setIndAbsentDied(indAbsentDied);
    }
    if (hasIndAbsentDivorced) {
      legacyApplicationDB.setIndAbsentDivorced(indAbsentDivorced);
    }
    if (hasIndAbsentFather) {
      legacyApplicationDB.setIndAbsentFather(indAbsentFather);
    }
    if (hasIndAbsentHospitalized) {
      legacyApplicationDB.setIndAbsentHospitalized(indAbsentHospitalized);
    }
    if (hasIndAbsentIncarcerated) {
      legacyApplicationDB.setIndAbsentIncarcerated(indAbsentIncarcerated);
    }
    if (hasIndAbsentMilitaryWork) {
      legacyApplicationDB.setIndAbsentMilitaryWork(indAbsentMilitaryWork);
    }
    if (hasIndAbsentMother) {
      legacyApplicationDB.setIndAbsentMother(indAbsentMother);
    }
    if (hasIndAbsentSeparated) {
      legacyApplicationDB.setIndAbsentSeparated(indAbsentSeparated);
    }
    if (hasIndAbsentWorkRelated) {
      legacyApplicationDB.setIndAbsentWorkRelated(indAbsentWorkRelated);
    }
    if (hasIndChildLivingPrnt6Mnths) {
      legacyApplicationDB.setIndChildLivingPrnt6Mnths(indChildLivingPrnt6Mnths);
    }
    if (hasIndChildQualifiedCitizen) {
      legacyApplicationDB.setIndChildQualifiedCitizen(indChildQualifiedCitizen);
    }
    if (hasIndChildSupportOrdered) {
      legacyApplicationDB.setIndChildSupportOrdered(indChildSupportOrdered);
    }
    if (hasIndChildUnder18) {
      legacyApplicationDB.setIndChildUnder18(indChildUnder18);
    }
    if (hasIndCtznshpAmerIndianCrd) {
      legacyApplicationDB.setIndCtznshpAmerIndianCrd(indCtznshpAmerIndianCrd);
    }
    if (hasIndCtznshpAttorneyReview) {
      legacyApplicationDB.setIndCtznshpAttorneyReview(indCtznshpAttorneyReview);
    }
    if (hasIndCtznshpBirthCrtfctFor) {
      legacyApplicationDB.setIndCtznshpBirthCrtfctFor(indCtznshpBirthCrtfctFor);
    }
    if (hasIndCtznshpBirthCrtfctUs) {
      legacyApplicationDB.setIndCtznshpBirthCrtfctUs(indCtznshpBirthCrtfctUs);
    }
    if (hasIndCtznshpChldFound) {
      legacyApplicationDB.setIndCtznshpChldFound(indCtznshpChldFound);
    }
    if (hasIndCtznshpCitizenCrtfct) {
      legacyApplicationDB.setIndCtznshpCitizenCrtfct(indCtznshpCitizenCrtfct);
    }
    if (hasIndCtznshpEvaluation) {
      legacyApplicationDB.setIndCtznshpEvaluation(indCtznshpEvaluation);
    }
    if (hasIndCtznshpForDocumentation) {
      legacyApplicationDB.setIndCtznshpForDocumentation(indCtznshpForDocumentation);
    }
    if (hasIndCtznshpHospitalCrtfct) {
      legacyApplicationDB.setIndCtznshpHospitalCrtfct(indCtznshpHospitalCrtfct);
    }
    if (hasIndCtznshpNoDocumentation) {
      legacyApplicationDB.setIndCtznshpNoDocumentation(indCtznshpNoDocumentation);
    }
    if (hasIndCtznshpNtrlztnCrtfct) {
      legacyApplicationDB.setIndCtznshpNtrlztnCrtfct(indCtznshpNtrlztnCrtfct);
    }
    if (hasIndCtznshpPassport) {
      legacyApplicationDB.setIndCtznshpPassport(indCtznshpPassport);
    }
    if (hasIndCtznshpResidentCard) {
      legacyApplicationDB.setIndCtznshpResidentCard(indCtznshpResidentCard);
    }
    if (hasIndCtznshpUnaccMinorChild) {
      legacyApplicationDB.setIndCtznshpUnaccMinorChild(indCtznshpUnaccMinorChild);
    }
    if (hasIndCtznshpUndocImmigrant) {
      legacyApplicationDB.setIndCtznshpUndocImmigrant(indCtznshpUndocImmigrant);
    }
    if (hasIndCtznshpUsHsptlBrthRcrd) {
      legacyApplicationDB.setIndCtznshpUsHsptlBrthRcrd(indCtznshpUsHsptlBrthRcrd);
    }
    if (hasIndCtznshpUsIdCard) {
      legacyApplicationDB.setIndCtznshpUsIdCard(indCtznshpUsIdCard);
    }
    if (hasIndCtznshpVitalBirthRcrd) {
      legacyApplicationDB.setIndCtznshpVitalBirthRcrd(indCtznshpVitalBirthRcrd);
    } 
    if (hasIndCtznshpSaveSystem) {
      legacyApplicationDB.setIndCtznshpSaveSystem(indCtznshpSaveSystem);
    }
    if (hasIndCtznshpStudentVisa) {
      legacyApplicationDB.setIndCtznshpStudentVisa(indCtznshpStudentVisa);
    }
    if (hasIndCtznshpSuccessSystem) {
      legacyApplicationDB.setIndCtznshpSuccessSystem(indCtznshpSuccessSystem);
    }
    if (hasIndCtznshpBirthAbroad) {
      legacyApplicationDB.setIndCtznshpBirthAbroad(indCtznshpBirthAbroad);
    }
    if (hasIndCtznshpCensusBirthRcrd) {
      legacyApplicationDB.setIndCtznshpCensusBirthRcrd(indCtznshpCensusBirthRcrd);
    }
    if (hasIndCtznshpCivilServiceEmp) {
      legacyApplicationDB.setIndCtznshpCivilServiceEmp(indCtznshpCivilServiceEmp);
    }
    if (hasIndCtznshpConfrmBirth) {
      legacyApplicationDB.setIndCtznshpConfrmBirth(indCtznshpConfrmBirth);
    }
    if (hasIndCtznshpFinalAdoptDecree) {
      legacyApplicationDB.setIndCtznshpFinalAdoptDecree(indCtznshpFinalAdoptDecree);
    }
    if (hasIndCtznshpNorthMarianaId) {
      legacyApplicationDB.setIndCtznshpNorthMarianaId(indCtznshpNorthMarianaId);
    }
    if (hasIndCtznshpLeglImmiStatExp) {
      legacyApplicationDB.setIndCtznshpLeglImmiStatExp(indCtznshpLeglImmiStatExp);
    }
    if (hasIndCtznshpLifeInsBrthRcrd) {
      legacyApplicationDB.setIndCtznshpLifeInsBrthRcrd(indCtznshpLifeInsBrthRcrd);
    }
    if (hasIndCtznshpLoclGovtBrthRcrd) {
      legacyApplicationDB.setIndCtznshpLoclGovtBrthRcrd(indCtznshpLoclGovtBrthRcrd);
    }
    if (hasIndCtznshpMedBirthRcrd) {
      legacyApplicationDB.setIndCtznshpMedBirthRcrd(indCtznshpMedBirthRcrd);
    }
    if (hasIndCtznshpMiltryBirthRcrd) {
      legacyApplicationDB.setIndCtznshpMiltryBirthRcrd(indCtznshpMiltryBirthRcrd);
    }
    if (hasIndCtznshpRefugee) {
      legacyApplicationDB.setIndCtznshpRefugee(indCtznshpRefugee);
    }
    if (hasIndCtznshpReligBirthRcrd) {
      legacyApplicationDB.setIndCtznshpReligBirthRcrd(indCtznshpReligBirthRcrd);
    }
    if (hasIndEligibilityCourtMonth) {
      legacyApplicationDB.setIndEligibilityCourtMonth(indEligibilityCourtMonth);
    }
    if (hasIndEligible) {
      legacyApplicationDB.setIndEligible(indEligible);
    }
    if (hasIndEquity) {
      legacyApplicationDB.setIndEquity(indEquity);
    }
    if (hasIndFatherPwe) {
      legacyApplicationDB.setIndFatherPwe(indFatherPwe);
    }
    if (hasIndHomeIncomeAfdcElgblty) {
      legacyApplicationDB.setIndHomeIncomeAfdcElgblty(indHomeIncomeAfdcElgblty);
    }
    if (hasIndMeetsDpOrNotEs) {
      legacyApplicationDB.setIndMeetsDpOrNotEs(indMeetsDpOrNotEs);
    }
    if (hasIndMeetsDpOrNotSystem) {
      legacyApplicationDB.setIndMeetsDpOrNotSystem(indMeetsDpOrNotSystem);
    }
    if (hasIndMotherPwe) {
      legacyApplicationDB.setIndMotherPwe(indMotherPwe);
    }
    if (hasIndNarrativeApproved) {
      legacyApplicationDB.setIndNarrativeApproved(indNarrativeApproved);
    }
    if (hasIndOtherVerification) {
      legacyApplicationDB.setIndOtherVerification(indOtherVerification);
    }
    if (hasIndParentalDeprivation) {
      legacyApplicationDB.setIndParentalDeprivation(indParentalDeprivation);
    }
    if (hasIndParentDisabled) {
      legacyApplicationDB.setIndParentDisabled(indParentDisabled);
    }
    if (hasIndPrsManagingCvs) {
      legacyApplicationDB.setIndPrsManagingCvs(indPrsManagingCvs);
    }
    if (hasIndRemovalChildOrdered) {
      legacyApplicationDB.setIndRemovalChildOrdered(indRemovalChildOrdered);
    }
    if (hasIndRsdiVerification) {
      legacyApplicationDB.setIndRsdiVerification(indRsdiVerification);
    }
    if (hasIndRsnblEffortPrvtRemoval) {
      legacyApplicationDB.setIndRsnblEffortPrvtRemoval(indRsnblEffortPrvtRemoval);
    }
    if (hasIndSsiVerification) {
      legacyApplicationDB.setIndSsiVerification(indSsiVerification);
    }
    if (hasNbrCertifiedGroup) {
      legacyApplicationDB.setNbrCertifiedGroup(nbrCertifiedGroup);
    }
    if (hasNbrParentsHome) {
      legacyApplicationDB.setNbrParentsHome(nbrParentsHome);
    }
    if (hasTxtDeterminationComments) {
      legacyApplicationDB.setTxtDeterminationComments(txtDeterminationComments);
    }
    if (hasTxtMonthsDepUnemp) {
      legacyApplicationDB.setTxtMonthsDepUnemp(txtMonthsDepUnemp);
    }
    if (hasIdEvent) {
      legacyApplicationDB.setIdEvent(idEvent);
    }
    if (hasCdEventStatus) {
      legacyApplicationDB.setCdEventStatus(cdEventStatus);
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
    if (hasIndPrsManagingCvs) {
      fceEligibilityDB.setIndPrsManagingCvs(indPrsManagingCvs);
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
    if (fceEligibilityDB.hasIndPrsManagingCvs()) {
      setIndPrsManagingCvs(fceEligibilityDB.getIndPrsManagingCvsObject());
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
            "BEGIN bean: LegacyApplication\n" +
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
            " indPrsManagingCvs: " + indPrsManagingCvs + "\n" +
            " indRemovalChildOrdered: " + indRemovalChildOrdered + "\n" +
            " indRsdiVerification: " + indRsdiVerification + "\n" +
            " indRsnblEffortPrvtRemoval: " + indRsnblEffortPrvtRemoval + "\n" +
            " indSsiVerification: " + indSsiVerification + "\n" +
            " nbrCertifiedGroup: " + nbrCertifiedGroup + "\n" +
            " nbrParentsHome: " + nbrParentsHome + "\n" +
            " txtDeterminationComments: " + txtDeterminationComments + "\n" +
            " txtMonthsDepUnemp: " + txtMonthsDepUnemp + "\n" +
            " idEvent: " + idEvent + "\n" +
            " cdEventStatus: " + cdEventStatus + "\n" +
            "END bean: LegacyApplication\n";
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
