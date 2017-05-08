package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgeCitizenshipSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AlertMesWorkerIfSESI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveCsupOutboundNcpsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgeCitizenshipSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveCsupOutboundNcpsSO;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   08/24/2011  hnguyen           STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
 *                                 and not look at the legal actions across the AU.
 *
 */

public class FceBean extends BaseFceSessionBean {
  //These should come from a codes table
  public static final String APPLICATION = CodesTables.CFCEAPRE_A;
  public static final String REAPPLICATION = CodesTables.CFCEAPRE_R;
  public static final String SELF = CodesTables.CRELVICT_SL;
  public static final String TRACE_TAG = "FceBean";

  protected static final String FCE_APPLICATION_TABLE = "fce_application_temp_event";
  protected static final String FCE_APPLICATION_COLUMN = "id_event";

  private AlertMesWorkerIfSE alertMesWorkerIfSE = null;
  private EligibilityRouting eligibilityRouting = null;
  private CheckFceJudicialRequirements checkFceJudicialRequirements = null;
  private RetrieveMesProgramAssistant retrieveMesProgramAssistant = null;
  private SaveAgeCitizenshipVerification saveAgeCitizenshipVerification = null;
  private RetrieveInitialMedicaid retrieveInitialMedicaid = null;
  private SaveInitialMedicaid saveInitialMedicaid = null;
  private RetrieveFceEligibility retrieveFceEligibility = null;
  private SaveInitialFceEligibility saveInitialFceEligibility = null;
  private SaveInitialFceApplication saveInitialFceApplication = null;
  private SaveFceApplication saveFceApplication = null;
  private SaveFceEligibility saveFceEligibility = null;
  private SaveInitialFceIncome saveInitialFceIncome = null;
  private SaveFceIncome saveFceIncome = null;
  private SaveFcePerson saveFcePerson = null;
  private SaveFceThirdPartyHealthInsurance saveFceThirdPartyHealthInsurance = null;
  private SaveFceExpenditures saveFceExpenditures = null;
  private SaveInitialFceExpenditures saveInitialFceExpenditures = null;
  private SaveFceReasonNotEligible saveFceReasonNotEligible = null;
  private RetrieveAFDCIncomeLimit retrieveAFDCIncomeLimit = null;
  private RetrieveIVEIncomeLimit retrieveIVEIncomeLimit = null;
  private SaveEligibilityAlert saveEligibilityAlert = null;
  private RetrieveAssignmentGroup retrieveAssignmentGroup = null;
  private RetrieveFceReview retrieveFceReview = null;
  private SaveInitialFceReview saveInitialFceReview = null;
  private SaveFceReview saveFceReview = null;
  private RetrieveSuccessMedAssistance retrieveSuccessMedAssistance = null;
  private RetrieveFceApplication retrieveFceApplication = null;
  private RetrievePersistentFcePrinciples retrievePersistentFcePrinciples = null;
  private RetrieveFcePerson retrieveFcePerson = null;
  private SaveInitialFcePerson saveInitialFcePerson = null;
  private AppAndBgCommonFunction appAndBgCommonFunction = null;
  private AgeAndCitizenshipCommonFunction ageAndCitizenshipCommonFunction = null;
  private EligibilitySummaryCommonFunction eligibilitySummaryCommonFunction = null;
  private IncomeExpendituresCommonFunction incomeExpendituresCommonFunction = null;
  private FceRedeterminationCommonFunction fceRedeterminationCommonFunction = null;
  private RetrieveFceThirdPartyHealthInsurance retrieveFceThirdPartyHealthInsurance = null;
  private RetrieveFceIncome retrieveFceIncome = null;
  private RetrieveFceExpenditures retrieveFceExpenditures = null;
  private UpdateFcePersonBirthday updateFcePersonBirthday = null;
  private UpdateInitialFceEligibility updateInitialFceEligibility = null;
  private PerformFceDataPrefill performFceDataPrefill = null;
  private RetrieveCsupOutboundNcps retrieveCsupOutboundNcpsSvc = null;
  private ChangeEventStatus changeEventStatus = null;
  private CheckIfCompletedFceaExist checkIfCompletedFceaExist = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    this.checkIfCompletedFceaExist = getService(CheckIfCompletedFceaExist.class);
    this.alertMesWorkerIfSE = getService(AlertMesWorkerIfSE.class);
    this.checkFceJudicialRequirements = getService(CheckFceJudicialRequirements.class);
    this.eligibilityRouting = getService(EligibilityRouting.class);
    this.retrieveMesProgramAssistant = getService(RetrieveMesProgramAssistant.class);
    this.saveAgeCitizenshipVerification = getService(SaveAgeCitizenshipVerification.class);
    this.retrieveInitialMedicaid = getService(RetrieveInitialMedicaid.class);
    this.saveInitialMedicaid = getService(SaveInitialMedicaid.class);
    this.retrieveFceEligibility = getService(RetrieveFceEligibility.class);
    this.saveInitialFceEligibility = getService(SaveInitialFceEligibility.class);
    this.saveInitialFceApplication = getService(SaveInitialFceApplication.class);
    this.saveFceApplication = getService(SaveFceApplication.class);
    this.saveFceEligibility = getService(SaveFceEligibility.class);
    this.saveInitialFceIncome = getService(SaveInitialFceIncome.class);
    this.saveFceIncome = getService(SaveFceIncome.class);
    this.saveFcePerson = getService(SaveFcePerson.class);
    this.saveFceThirdPartyHealthInsurance = getService(SaveFceThirdPartyHealthInsurance.class);
    this.saveFceExpenditures = getService(SaveFceExpenditures.class);
    this.saveInitialFceExpenditures = getService(SaveInitialFceExpenditures.class);
    this.saveFceReasonNotEligible = getService(SaveFceReasonNotEligible.class);
    this.retrieveAFDCIncomeLimit = getService(RetrieveAFDCIncomeLimit.class);
    this.retrieveIVEIncomeLimit = getService(RetrieveIVEIncomeLimit.class);
    this.saveEligibilityAlert = getService(SaveEligibilityAlert.class);
    this.retrieveAssignmentGroup = getService(RetrieveAssignmentGroup.class);
    this.retrieveFceReview = getService(RetrieveFceReview.class);
    this.saveInitialFceReview = getService(SaveInitialFceReview.class);
    this.saveFceReview = getService(SaveFceReview.class);
    this.retrieveSuccessMedAssistance = getService(RetrieveSuccessMedAssistance.class);
    this.retrieveFceApplication = getService(RetrieveFceApplication.class);
    this.retrievePersistentFcePrinciples = getService(RetrievePersistentFcePrinciples.class);
    this.retrieveFcePerson = getService(RetrieveFcePerson.class);
    this.saveInitialFcePerson = getService(SaveInitialFcePerson.class);
    this.appAndBgCommonFunction = getService(AppAndBgCommonFunction.class);
    this.ageAndCitizenshipCommonFunction = getService(AgeAndCitizenshipCommonFunction.class);
    this.eligibilitySummaryCommonFunction = getService(EligibilitySummaryCommonFunction.class);
    this.incomeExpendituresCommonFunction = getService(IncomeExpendituresCommonFunction.class);
    this.fceRedeterminationCommonFunction = getService(FceRedeterminationCommonFunction.class);
    this.retrieveFceThirdPartyHealthInsurance = getService(RetrieveFceThirdPartyHealthInsurance.class);
    this.retrieveFceIncome = getService(RetrieveFceIncome.class);
    this.retrieveFceExpenditures = getService(RetrieveFceExpenditures.class);
    this.updateFcePersonBirthday = getService(UpdateFcePersonBirthday.class);
    this.updateInitialFceEligibility = getService(UpdateInitialFceEligibility.class);
    this.performFceDataPrefill = getService(PerformFceDataPrefill.class);
    this.retrieveCsupOutboundNcpsSvc = getService(RetrieveCsupOutboundNcps.class);
    this.changeEventStatus = getService(ChangeEventStatus.class);
  }

  public ThirdPartyHealthInsuranceDB retrieveFceThirdPartyHealthInsurance(long idFceApplication) {
    return retrieveFceThirdPartyHealthInsurance.retrieveFceThirdPartyHealthInsurance(idFceApplication);
  }

  public boolean checkIfCompletedFceaExist(long idStage){
    return checkIfCompletedFceaExist.checkIfCompletedFceaExist(idStage);
  }
  
  public Map<String, Date> checkFceJudicialRequirements (int idCase, int idChild, Date removalDAte) throws ServiceException {
    return checkFceJudicialRequirements.checkFceJudicialRequirements(idCase, idChild, removalDAte);
  }
  
  public FceIncomeDB retrieveFceIncome(long idFceIncome) throws ServiceException {
    return retrieveFceIncome.retrieveFceIncome(idFceIncome);
  }
  
  public List<FceIncomeDB> retrieveFceIncomeForFcePerson(long idFceEligibility, long idPerson) throws ServiceException {
    return retrieveFceIncome.retrieveFceIncomeForFcePerson(idFceEligibility, idPerson);
  }

  public int retrieveIdEventFromEvent(int idStage) {
    return retrieveInitialMedicaid.retrieveIdEventFromEvent(idStage);
  }

  public List retrieveEventByIdEvent(int idEvent) {
    return retrieveInitialMedicaid.retrieveEventByIdEvent(idEvent);
  }

  public MedicaidApplicationRetrieveSO retrieveInitialMedicaid(MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI) {
    return retrieveInitialMedicaid.retrieveInitialMedicaid(medicaidApplicationRetrieveSI);
  }

  public FceEligibilityDB retrieveFceEligibility(long idFceEligibility) throws ServiceException {
    return retrieveFceEligibility.retrieveFceEligibility(idFceEligibility);
  }

  public Integer[] retrieveAFDCIncomeLimit(long nbrCertifiedGroup) {
    return retrieveAFDCIncomeLimit.retrieveAFDCIncomeLimit(nbrCertifiedGroup);
  }

  public Double[] retrieveIVEIncomeLimit(long nbrAge) {
    return retrieveIVEIncomeLimit.retrieveIVEIncomeLimit(nbrAge);
  }

  public Map retrieveSuccessMedAssistance(long idCase, long idStage) {
    return retrieveSuccessMedAssistance.retrieveSuccessMedAssistance(idCase, idStage);
  }

  public FceReviewDB retrieveFceReview(long idFceReview) {
    return retrieveFceReview.retrieveFceReview(idFceReview);
  }

  public AssignmentGroup_ARRAY retrieveAssignmentGroup(int idStage) {
    return retrieveAssignmentGroup.retrieveAssignmentGroup(idStage);
  }

  public FceApplicationDB retrieveFceApplication(long idFceApplication) {
    //return retrieveFceApplication.retrieveFceApplication(idFceApplication);
    return appAndBgCommonFunction.retrieveFceApplication(idFceApplication);
  }

  public List<FcePersonDB> retrievePersistentFcePrinciples(long idFceEligibility) throws ServiceException {
    return retrievePersistentFcePrinciples.retrievePersistentFcePrinciples(idFceEligibility);
  }
  
  public FcePersonDB retrieveFcePerson(long idFcePerson) {
    return retrieveFcePerson.retrieveFcePerson(idFcePerson);
  }

  public FceExpendituresDB retrieveFceExpenditures(long idFceExpenditures) throws ServiceException {
    return retrieveFceExpenditures.retrieveFceExpenditures(idFceExpenditures);
  }

  public int retrieveMesProgramAssistant(int idStage, String securityAttribute) {
    return retrieveMesProgramAssistant.retrieveMesProgramAssistant(idStage, securityAttribute);
  }

  public int saveInitialFceReview(FceReviewDB fceReviewDB) {
    return saveInitialFceReview.saveInitialFceReview(fceReviewDB);
  }

  public int saveFceReview(FceReviewDB fceReviewDB) {
    return saveFceReview.saveFceReview(fceReviewDB);
  }

  public int saveInitialFcePerson(long idFceEligibility, long idPerson, String cdRelInt) {
    return saveInitialFcePerson.saveInitialFcePerson(idFceEligibility, idPerson, cdRelInt);
  }

  public int saveInitialFceEligibility(FceEligibilityDB fceEligibilityDB) {
    return saveInitialFceEligibility.saveInitialFceEligibility(fceEligibilityDB);
  }

  public int saveInitialFceApplication(FceApplicationDB fceApplication) {
    return saveInitialFceApplication.saveInitialFceApplication(fceApplication);
  }

  public int saveFceApplication(FceApplicationDB fceApplicationDB) {
    return saveFceApplication.saveFceApplication(fceApplicationDB);
  }

  public int saveFceEligibility(FceEligibilityDB fceEligibilityDB) {
    return saveFceEligibility.saveFceEligibility(fceEligibilityDB);
  }

  public int saveInitialFceIncome(FceIncomeDB FceIncomeDB) {
    return saveInitialFceIncome.saveInitialFceIncome(FceIncomeDB);
  }

  public int saveFceIncome(FceIncomeDB fceIncomeDB) {
    return saveFceIncome.saveFceIncome(fceIncomeDB);
  }

  public int saveFcePerson(FcePersonDB fcePersonDB) {
    return saveFcePerson.saveFcePerson(fcePersonDB);
  }

  public int saveFceThirdPartyHealthInsurance(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB) {
    return saveFceThirdPartyHealthInsurance.saveFceThirdPartyHealthInsurance(thirdPartyHealthInsuranceDB);
  }

  public int saveFceExpenditures(FceExpendituresDB fceExpendituresDB) {
    return saveFceExpenditures.saveFceExpenditures(fceExpendituresDB);
  }

  public int saveInitialFceExpenditures(FceExpendituresDB fceExpendituresDB) {
    return saveInitialFceExpenditures.saveInitialFceExpenditures(fceExpendituresDB);
  }

  public int saveFceReasonNotEligible(FceReasonNotEligibleDB fceReasonNotEligibleDB) {
    return saveFceReasonNotEligible.saveFceReasonNotEligible(fceReasonNotEligibleDB);
  }

  public void saveEligibilityAlert(int idPerson, int idUser, int idStage, int idCase, String eventType) {
    saveEligibilityAlert.saveEligibilityAlert(idPerson, idUser, idStage, idCase, eventType);
  }

  public int saveInitialMedicaid(MedicaidApplicationSaveSI medicaidApplicationSaveSI) {
    return saveInitialMedicaid.saveInitialMedicaid(medicaidApplicationSaveSI);
  }

  public AgeCitizenshipSaveSO saveCheckedAgeCitizenshipVerification(AgeCitizenshipSaveSI ageCitizenshipSaveSI) throws IOException, LookupException {
    return saveAgeCitizenshipVerification.saveCheckedAgeCitizenshipVerification(ageCitizenshipSaveSI);
  }

  public void updateInitialFceEligibility(FceEligibilityDB fceEligibilityDB) {
    updateInitialFceEligibility.updateInitialFceEligibility(fceEligibilityDB);
  }

  public void updateFcePersonBirthday(FcePersonDB fcePersonDB) {
    updateFcePersonBirthday.updateFcePersonBirthday(fcePersonDB);
  }

  public void eligibilityRouting(int idStage, int idUser, int idPerson, String eventType) {
    eligibilityRouting.eligibilityRouting(idStage, idUser, idPerson, eventType);
  }
  
  public boolean alertMesWorkerIfAlreadySE(AlertMesWorkerIfSESI alertMesWorkerIfSESI){
    return alertMesWorkerIfSE.alertMesWorkerIfAlreadySE(alertMesWorkerIfSESI);
  }

  public FceReviewDB findReviewByReviewEvent(long idReviewEvent) {
    return ageAndCitizenshipCommonFunction.findReviewByReviewEvent(idReviewEvent);
  }

  public long findPrimaryChildForStage(long idStage, String cdStagePersonRole) {
    return ageAndCitizenshipCommonFunction.findPrimaryChildForStage(idStage, cdStagePersonRole);
  }

  public FcePersonDB findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson) throws ServiceException {
    return ageAndCitizenshipCommonFunction.findFcePersonByIdFceEligibilityAndIdPerson(idFceEligibility, idPerson);
  }

  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion) {
    //ageAndCitizenshipCommonFunction.updateFceApplicationIndEvalConclusion(idFceApplication, indEvaluationConclusion);
    appAndBgCommonFunction.updateFceApplicationIndEvalConclusion(idFceApplication, indEvaluationConclusion);
  }

  public void updateFceEligibilityCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship) {
    ageAndCitizenshipCommonFunction.updateFceEligibilityCdPersonCitizenship(idFceEligibility, cdPersonCitizenship);
  }

  public FceApplicationDB findApplicationByApplicationEvent(long idApplicationEvent) {
    return appAndBgCommonFunction.findApplicationByApplicationEvent(idApplicationEvent);
  }

  public void updateFceApplicationPersonAddress(FceApplicationDB fceApplicationDB) {
    appAndBgCommonFunction.updateFceApplicationPersonAddress(fceApplicationDB);
  }

  public void updateFceApplicationCdApplication(FceApplicationDB fceApplicationDB) {
    appAndBgCommonFunction.updateFceApplicationCdApplication(fceApplicationDB);
  }

  public void updateCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, boolean indLegalCustodian) {
    appAndBgCommonFunction.updateCdRelIntandLegalCustodian(idFcePerson, cdRelInt, indLegalCustodian);
  }

  public void updateFcePerson(FcePersonDB fcePersonDB) {
    appAndBgCommonFunction.updateFcePerson(fcePersonDB);
  }

  public FceEligibilityDB retrieveEligibilityForEligibilityEvent(long idEligibilityEvent) {
    return eligibilitySummaryCommonFunction.retrieveEligibilityForEligibilityEvent(idEligibilityEvent);
  }

  public int updateFceEligibilityIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered) {
    return eligibilitySummaryCommonFunction.updateFceEligibilityIndChildSupportOrdered(idFceEligibility, indChildSupportOrdered);
  }

  public int updateFceEligibilityCdBlocAmtSsi(long idFceEligibility, String cdBlocChild, double amtSsi) {
    return eligibilitySummaryCommonFunction.updateFceEligibilityCdBlocAmtSsi(idFceEligibility, cdBlocChild, amtSsi);
  }

  public FceEligibilityDB retrieveEligibilityByIdFceApplication(long idFceApplication) {
    return fceRedeterminationCommonFunction.retrieveEligibilityByIdFceApplication(idFceApplication);
  }

  public int updateFceEligibilityCdBlocChild(long idFceEligibility, String cdBlocChild) {
    return fceRedeterminationCommonFunction.updateFceEligibilityCdBlocChild(idFceEligibility, cdBlocChild);
  }

  public FceExpendituresDB retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                            long idFcePerson,
                                                                                            long idPerson) {
    return incomeExpendituresCommonFunction.retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(idFceExpenditures,
                                                                                                             idFcePerson,
                                                                                                             idPerson);
  }

  public void deleteFceExpenditures(long idFceEligibility) {
    incomeExpendituresCommonFunction.deleteFceExpenditures(idFceEligibility);
  }

  public FcePersonDB retrieveFcePersonByIdPerson(long idPerson) throws ServiceException {
    return incomeExpendituresCommonFunction.retrieveFcePersonByIdPerson(idPerson);
  }

  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage) {
    return incomeExpendituresCommonFunction.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);

  }

  public void doFceDataPrefill(FceDataPrefillSI fceDataPrefillSI) {
    performFceDataPrefill.doFceDataPrefill(fceDataPrefillSI);
  }

  public int updateFceAppliationByNbrLivingAtHome(long idFceApplication, long nbrLivingAtHome) {
    return appAndBgCommonFunction.updateNbrLivingAtHome(idFceApplication, nbrLivingAtHome);
  }

  public int updateFceEligibilityByIndMeetsDpOrNotEs(long idFceEligibility, String indMeetsDpOrNotEs) {
    return appAndBgCommonFunction.updateIndMeetsDpOrNotEs(idFceEligibility, indMeetsDpOrNotEs);
  }

  public int updateFceEligibilityByNbrCertifiedGroup(long idFceApplication, long nbrCertifiedGroup) {
    return appAndBgCommonFunction.updateNbrCertifiedGroup(idFceApplication, nbrCertifiedGroup);
  }

  public void updateFceEligibilityByIndMeetsDpOrNotSystem(long idFceEligibility, String indMeetsDpOrNotSystem){
    appAndBgCommonFunction.updateFceEligibilityByIndMeetsDpOrNotSystem(idFceEligibility, indMeetsDpOrNotSystem);
  }
  
  public RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcps(EligibilitySummaryDB eligibilitySummaryDB, RetrieveCsupOutboundNcpsSI retrieveCsupOutboundNcpsSI) {
    return retrieveCsupOutboundNcpsSvc.retrieveCsupOutboundNcps(eligibilitySummaryDB, retrieveCsupOutboundNcpsSI);
  }

  public boolean changeEventStatus(int idEvent) {
    return changeEventStatus.changeEventStatus(idEvent);
  }
  
  public void updateRemovalDate(int idFceApplication) {
    appAndBgCommonFunction.updateRemovalDate(idFceApplication);
  }
  
  public void updateReimbursabilityJudicialRequirements(FceReviewDB fceReviewDB) {
    fceRedeterminationCommonFunction.updateReimbursabilityJudicialRequirements(fceReviewDB);
  }
}
