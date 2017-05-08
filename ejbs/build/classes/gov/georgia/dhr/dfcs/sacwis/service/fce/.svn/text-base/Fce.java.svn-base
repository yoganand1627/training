package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;
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

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   08/24/2011  hnguyen           STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
 *                                 and not look at the legal actions across the AU.
 *
 */

public interface Fce extends SlsbFacade {
  public Map<String, Date> checkFceJudicialRequirements (int idCase, int idChild, Date removalDAte) throws ServiceException;

  public ThirdPartyHealthInsuranceDB retrieveFceThirdPartyHealthInsurance(long idFceApplication);

  public FceIncomeDB retrieveFceIncome(long idFceIncome) throws ServiceException;
  
  public List<FceIncomeDB> retrieveFceIncomeForFcePerson(long idFceEligibility, long idPerson) throws ServiceException;

  public int retrieveIdEventFromEvent(int idCase);

  public List retrieveEventByIdEvent(int idEvent);

  public MedicaidApplicationRetrieveSO retrieveInitialMedicaid(MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI);

  public FceEligibilityDB retrieveFceEligibility(long idFceEligibility) throws ServiceException;

  public Integer[] retrieveAFDCIncomeLimit(long nbrCertifiedGroup);

  public Double[] retrieveIVEIncomeLimit(long nbrAge);

  public Map retrieveSuccessMedAssistance(long idCase, long idStage);

  public FceReviewDB retrieveFceReview(long idFceReview);

  public AssignmentGroup_ARRAY retrieveAssignmentGroup(int idStage);

  public FceApplicationDB retrieveFceApplication(long idFceApplication);

  public FcePersonDB retrieveFcePerson(long idFcePerson);

  public FceExpendituresDB retrieveFceExpenditures(long idFceExpenditures) throws ServiceException;

  public int retrieveMesProgramAssistant(int idStage, String securityAttribute);
  
  public boolean checkIfCompletedFceaExist(long idStage);
  
  public int saveInitialFceReview(FceReviewDB fceReviewDB);

  public int saveFceReview(FceReviewDB fceReviewDB);

  public int saveInitialFcePerson(long idFceEligibility, long idPerson, String cdRelInt);

  public int saveInitialFceEligibility(FceEligibilityDB fceEligibilityDB);

  public int saveInitialFceApplication(FceApplicationDB fceApplication);

  public int saveFceApplication(FceApplicationDB fceApplicationDB);

  public int saveFceEligibility(FceEligibilityDB fceEligibilityDB);

  public int saveInitialFceIncome(FceIncomeDB FceIncomeDB);

  public int saveFceIncome(FceIncomeDB fceIncomeDB);

  public int saveFcePerson(FcePersonDB fcePersonDB);

  public int saveFceThirdPartyHealthInsurance(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB);

  public int saveFceExpenditures(FceExpendituresDB fceExpendituresDB);

  public int saveInitialFceExpenditures(FceExpendituresDB fceExpendituresDB);

  public int saveFceReasonNotEligible(FceReasonNotEligibleDB fceReasonNotEligibleDB);

  public void saveEligibilityAlert(int idPerson, int idUser, int idCase, int idStage, String eventType);

  public int saveInitialMedicaid(MedicaidApplicationSaveSI medicaidApplicationSaveSI);

  public AgeCitizenshipSaveSO saveCheckedAgeCitizenshipVerification(AgeCitizenshipSaveSI ageCitizenshipSaveSI) throws IOException, LookupException;

  public void updateInitialFceEligibility(FceEligibilityDB fceEligibilityDB);

  public void updateFcePersonBirthday(FcePersonDB fcePersonDB);

  public void eligibilityRouting(int idStage, int idUser, int idPerson, String eventType);
  
  public boolean alertMesWorkerIfAlreadySE(AlertMesWorkerIfSESI alertMesWorkerIfSESI);

  public FceReviewDB findReviewByReviewEvent(long idReviewEvent);

  public long findPrimaryChildForStage(long idStage, String cdStagePersonRole);

  public FcePersonDB findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson) throws ServiceException;

  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion);

  public void updateFceEligibilityCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship);

  public FceApplicationDB findApplicationByApplicationEvent(long idApplicationEvent);

  public void updateFceApplicationPersonAddress(FceApplicationDB fceApplicationDB);

  public void updateFceApplicationCdApplication(FceApplicationDB fceApplicationDB);

  public void updateCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, boolean indLegalCustodian);

  public void updateFcePerson(FcePersonDB fcePersonDB);

  public FceEligibilityDB retrieveEligibilityForEligibilityEvent(long idEligibilityEvent);

  public int updateFceEligibilityIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered);

  public int updateFceEligibilityCdBlocAmtSsi(long idFceEligibility, String cdBlocChild, double amtSsi);

  public FceEligibilityDB retrieveEligibilityByIdFceApplication(long idFceApplication);

  public int updateFceEligibilityCdBlocChild(long idFceEligibility, String cdBlocChild);

  public FceExpendituresDB retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                            long idFcePerson,
                                                                                            long idPerson);

  public void deleteFceExpenditures(long idFceEligibility);
  
  public List<FcePersonDB> retrievePersistentFcePrinciples(long idFceEligibility) throws ServiceException;

  public FcePersonDB retrieveFcePersonByIdPerson(long idPerson) throws ServiceException;

  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage);
  
  public void doFceDataPrefill(FceDataPrefillSI fceDataPrefillSI);
  
  public int updateFceAppliationByNbrLivingAtHome(long idFceApplication,long nbrLivingAtHome);
  
  public int updateFceEligibilityByIndMeetsDpOrNotEs(long idFceEligibility, String indMeetsDpOrNotEs);
  
  public void updateFceEligibilityByIndMeetsDpOrNotSystem(long idFceEligibility, String indMeetsDpOrNotSystem);
  
  public int updateFceEligibilityByNbrCertifiedGroup(long idFceApplication,long nbrCertifiedGroup);

  public RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcps(EligibilitySummaryDB eligibilitySummaryDB, RetrieveCsupOutboundNcpsSI retrieveCsupOutboundNcpsSI);

  public boolean changeEventStatus(int idEvent);
  
  public void updateRemovalDate(int idFceApplication);
  
  public void updateReimbursabilityJudicialRequirements(FceReviewDB fceReviewDB);
}