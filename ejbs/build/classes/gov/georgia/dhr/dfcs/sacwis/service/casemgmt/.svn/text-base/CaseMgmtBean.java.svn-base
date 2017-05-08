/**
 * Created on Jun 28, 2006 at 9:22:03 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.AfcarsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCasePlanRevFtmSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCiAddlContactSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwContactStandardsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwFcSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwHealthScreensSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvestigationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwOngoingSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwTprSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.NcandsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.APPLAPersonsConnectedRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB48SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB63SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB64SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB77SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IcpcDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IcpcDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelativeCareAssmtDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.APPLAPersonsConnectedRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB28SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB49SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB64SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB77SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPRetrieveSO;


import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;

public class CaseMgmtBean extends BaseSpringStatelessSessionBean implements CaseMgmt {
  private RetrieveAddressAndPhone retrieveAddressAndPhone;

  private RetrieveChangeStageType retrieveChangeStageType;

  private RetrieveConservatorshipRemoval retrieveConservatorshipRemoval;

  private RetrieveFCCPFamilyDetail retrieveFCCPFamilyDetail;
  
  private RetrieveFosterCarePrincipalList retrieveFosterCarePrincipalList;
  
  private RetrieveIcpcDetail retrieveIcpcDetail;  

  private RetrieveLevelofCare retrieveLevelofCare;

  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel;

  private RetrievePALFollowup retrievePALFollowup;

  private RetrievePALILSAssessment retrievePALILSAssessment;

  private RetrievePALTrainingService retrievePALTrainingService;

  private RetrievePersonsInHomeRemoval retrievePersonsInHomeRemoval;

  private RetrievePlacementDetail retrievePlacementDetail;

  private RetrievePPT retrievePPT;

  private RetrieveFCGS retrieveFCGS;

  private RetrievePPTParticipant retrievePPTParticipant;

  private RetrieveSvcDeliveryClosure retrieveSvcDeliveryClosure;

  private RetrieveNeedsAndOutcomes retrieveNeedsAndOutcomes;

  private RetrieveNeedsAndOutcomesDetail retrieveNeedsAndOutcomesDetail;

  private RetrieveWTLP retrieveWTLP;

  private RetrievePaymentOfCare retrievePaymentOfCare;
  
  private RetrieveFadHome retrieveFadHome;

  private RetrieveFosterCareParticipant retrieveFosterCareParticipant;
  
  private RetrieveCaseReview retrieveCaseReview;
  
  private RetrieveAPPLAPersonsConnected retrieveAPPLAPersonsConnected;

  private SaveChangeStageType saveChangeStageType;

  private SaveClosePALStage saveClosePALStage;

  private SaveConservatorshipRemoval saveConservatorshipRemoval;

  private SaveFCCPFamilyDetail saveFCCPFamilyDetail;
  
  private SaveIcpcDetail saveIcpcDetail;

  private SaveLevelofCare saveLevelofCare;

  private SavePALFollowup savePALFollowup;

  private SavePALILSAssessment savePALILSAssessment;

  private SavePAL savePAL;

  private SavePALTrainingService savePALTrainingService;

  private SavePersonsInHomeRemoval savePersonsInHomeRemoval;

  private SavePlacementDetail savePlacementDetail;

  private SavePPTDetail savePPTDetail;

  private SavePPTParticipant savePPTParticipant;

  private SaveReopenPAL saveReopenPAL;

  private SaveSvcDeliveryClosure saveSvcDeliveryClosure;

  private SaveNeedsAndOutcomes saveNeedsAndOutcomes;

  private SaveNeedsAndOutcomesDetail saveNeedsOutcomesDetail;

  private SaveFosterCareSecGoals saveFosterCareSecGoals;

  private RetrieveFosterCareSecGoals retrieveFosterCareSecGoals;

  private SaveWTLP saveWTLP;
  
  private SavePaymentOfCare savePaymentOfCare;

  private SaveFosterCareParticipant saveFosterCareParticipant;

  private SaveFCGS saveFCGS;

  private SvcDeliveryClosureValidation svcDeliveryClosureValidation;

  private ValidatePlacementDetail validatePlacementDetail;

  private SaveChildPlan saveChildPlan;

  private RetrieveChildPlan retrieveChildPlan;

  private RetrievePrimaryChildPersonId retrievePrimaryChildPersonId;

  private SaveAdoptionInformation saveAdoptionInformation;

  private RetrieveAdoptionInformation retrieveAdoptionInformation;

  private RetrievePrivateAgencyName retrievePrivateAgencyName;

  private RetrieveRelativeCareAssmt retrieveRelativeCareAssmt;

  private DeleteRelativeCareAssmt deleteRelativeCareAssmt;

  private SaveRelativeCareAssmt saveRelativeCareAssmt;
  
  private SavePlacementAlerts savePlacementAlerts;
  
  private SaveCaseReview saveCaseReview;
  
  private RetrieveCaseWatch retrieveCaseWatch;
  
  private RetrieveAfcars retrieveAfcars;
  
  private RetrieveNcands retrieveNcands;
  
  private RetrieveNcandsChildren retrieveNcandsChildren;
  
  private RetrieveCwCaseErrors retrieveCwCaseErrors;
  
  private RetrieveCwCaseWarnings retrieveCwCaseWarnings;
  
  private RetrieveCwSummary retrieveCwSummary;
  
  private RetrieveCwCaseEvents retrieveCwCaseEvents;
  
  private RetrieveCwInvestigation retrieveCwInvestigation;
  
  private RetrieveCwOngoing retrieveCwOngoing;
  
  private RetrieveCwFcSummary retrieveCwFcSummary;
  
  private RetrieveCwContactStandards retrieveCwContactStandards;
  
  private RetrieveCwTpr retrieveCwTpr;
  
  private RetrieveCwAddlContacts retrieveCwAddlContacts;
  
  private RetrieveCwCasePlanRevFtm retrieveCwCasePlanRevFtm;
  
  private RetrieveCwHealthScreens retrieveCwHealthScreens;

    
  public CSUB14SO findConservatorShipRemovalInformation(CSUB14SI csub14si) throws ServiceException {
    return retrieveConservatorshipRemoval.findConservatorShipRemovalInformation(csub14si);
  }

  public CSUB77SO retrieveAddressAndPhone(CSUB77SI csub77si) throws ServiceException {
    return retrieveAddressAndPhone.retrieveAddressAndPhone(csub77si);
  }

  public CSUB63SO retrieveChangeStageType(CSUB63SI csub63si) throws ServiceException {
    return retrieveChangeStageType.retrieveChangeStageType(csub63si);
  }
  
  public IcpcDetailRetrieveSO retrieveIcpcDetail(IcpcDetailRetrieveSI icpcDetailRetrieveSI)throws ServiceException {
    return retrieveIcpcDetail.retrieveIcpcDetail(icpcDetailRetrieveSI);
  }
  
  public IcpcDetailSaveSO saveIcpcDetail(IcpcDetailSaveSI icpcDetailSaveSI)throws ServiceException {
    return saveIcpcDetail.saveIcpcDetail(icpcDetailSaveSI);
  }
  
  public CSUB16SO findEventAndPersonLocInformation(CSUB16SI csub16si) throws ServiceException {
    return retrieveLevelofCare.findEventAndPersonLocInformation(csub16si);
  }

  public FCCPFamilyDetailSO retrieveFCCPFamilyDetail(FCCPFamilyDetailSI fccpFamilyDetailSI) throws ServiceException {
    return retrieveFCCPFamilyDetail.retrieveFCCPFamilyDetail(fccpFamilyDetailSI);
  }

  public CCFC01SO retrieveEventStatus(CCFC01SI ccfc01si) throws ServiceException {
    return retrievePALILSAssessment.retrieveEventStatus(ccfc01si);
  }

  public List<Integer> retrieveSpecializedUnitPersonnel(SpecializedUnitPersonalBean spUnitPsnlBean) throws ServiceException {
    return retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);
  }
  public boolean hasRightByIdPerson(int idPerson, String securityAttribute) throws ServiceException {
    return retrieveSpecializedUnitPersonnel.hasRightByIdPerson(idPerson, securityAttribute);
  }

  public CCFC07SO retrievePALFollowup(CCFC07SI ccfc07si) throws ServiceException {
    return retrievePALFollowup.retrievePALFollowup(ccfc07si);
  }

  public CCFC10SO retrievePALTrainningService(CCFC10SI ccfc10si) throws ServiceException {
    return retrievePALTrainingService.retrievePALTrainningService(ccfc10si);
  }

  public CSUB80SO retrieveFosterCarePrincipalList(CSUB80SI csub80si) throws ServiceException {
    return retrieveFosterCarePrincipalList.retrieveFosterCarePrincipalList(csub80si);
  }
  
  public CSUB48SO retrievePersonsInHomeRemoval(CSUB48SI csub48si) throws ServiceException {
    return retrievePersonsInHomeRemoval.retrievePersonsInHomeRemoval(csub48si);
  }

  public CSUB29SO retrievePPT(CSUB29SI csub29si) throws ServiceException {
    return retrievePPT.retrievePPT(csub29si);
  }

  public CSUB25SO retrievePlacementDetail(CSUB25SI csub25si) throws ServiceException {
    return retrievePlacementDetail.retrievePlacementDetail(csub25si);
  }

  public CSUB27SO retrievePPTParticipant(CSUB27SI csub27si) {
    return retrievePPTParticipant.retrievePPTParticipant(csub27si);
  }

  public CSVC15SO retrieveServDelivery(CSVC15SI csvc15si) throws ServiceException {
    return retrieveSvcDeliveryClosure.retrieveServDelivery(csvc15si);
  }

  public NeedsAndOutcomesRetrieveSO retrieveNeedsAndOutcomes(NeedsAndOutcomesRetrieveSI needsoutcomesretrievesi) {
    return retrieveNeedsAndOutcomes.retrieveNeedsAndOutcomes(needsoutcomesretrievesi);
  }

  public NeedsAndOutcomesRetrieveSO retrieveNeedsAndOutcomesDetail(NeedsAndOutcomesRetrieveSI needsoutcomesretrievesi) {
    return retrieveNeedsAndOutcomesDetail.retrieveNeedsAndOutcomesDetail(needsoutcomesretrievesi);
  }

  public WTLPRetrieveSO retrieveWTLPdetail(WTLPRetrieveSI wtlpRetrieve) {
    return retrieveWTLP.retrieveWTLPdetail(wtlpRetrieve);
  }
  
  public PaymentOfCareRetrieveSO retrievePaymentOfCare(PaymentOfCareRetrieveSI paymentOfCareRetrieve) {
    return retrievePaymentOfCare.retrievePaymentOfCare(paymentOfCareRetrieve);
  }

  public FosterCareParticipantRetrieveSO retrieveFosterCareParticipant(
                                                                       FosterCareParticipantRetrieveSI fosterCareParticipantRetrieve) {
    return retrieveFosterCareParticipant.retrieveFosterCareParticipant(fosterCareParticipantRetrieve);
  }

  public FCGSRetrieveSO retrieveFCGS(FCGSRetrieveSI fcgsRetrieveSI) throws ServiceException {
    return retrieveFCGS.retrieveFCGS(fcgsRetrieveSI);
  }

  public FosterCareSecGoalsRetrieveSO retrieveFosterCareSecGoals(FosterCareSecGoalsRetrieveSI fosterCareSecGoalsRetrieve) {
    return retrieveFosterCareSecGoals.retrieveFosterCareSecGoals(fosterCareSecGoalsRetrieve);
  }

  public FadHomeRetrieveSO retrieveFadHome(int idResource) throws ServiceException {
    return retrieveFadHome.retrieveFadHome(idResource);
  }
  
  public FadHomeRetrieveSO retrieveFadHomeByIdStage(int idStage) throws ServiceException {
    return retrieveFadHome.retrieveFadHomeByIdStage(idStage);
  }
  
  public CaseReviewRetrieveSO retrieveCaseReview(CaseReviewRetrieveSI caseReviewRetrieveSI) throws ServiceException {
    return retrieveCaseReview.retrieveCaseReview(caseReviewRetrieveSI);
  }
  
  public CSUB64SO saveChangeStageType(CSUB64SI csub64si) throws ServiceException {
    return saveChangeStageType.saveChangeStageType(csub64si);
  }

  public CCFC03SO saveClosePALStage(CCFC03SI ccfc03si) throws ServiceException {
    return saveClosePALStage.saveClosePALStage(ccfc03si);
  }

  public CSUB15SO saveConservatorshipRemoval(CSUB15SI csub15si, CSUB80SI csub80si) throws ServiceException {
    return saveConservatorshipRemoval.saveConservatorshipRemoval(csub15si, csub80si);
  }

  public CSUB17SO saveEventAndLevelofCare(CSUB17SI csub17si) throws ServiceException {
    return saveLevelofCare.saveEventAndLevelofCare(csub17si);
  }

  public CCFC08SO savePALFollowup(CCFC08SI ccfc08si) throws ServiceException {
    return savePALFollowup.savePALFollowup(ccfc08si);
  }

  public CCFC02SO savePalIlsAssessment(CCFC02SI ccfc02si) throws ServiceException {
    return savePALILSAssessment.savePalIlsAssessment(ccfc02si);
  }

  public CCFC04SO savePAL(CCFC04SI ccfc04si) throws ServiceException {
    return savePAL.savePAL(ccfc04si);
  }

  public CCFC11SO savePALTrainningService(CCFC11SI ccfc11si) throws ServiceException {
    return savePALTrainingService.savePALTrainningService(ccfc11si);
  }

  public CSUB49SO savePersonsInHomeRemoval(CSUB49SI csub49si) throws ServiceException {
    return savePersonsInHomeRemoval.savePersonsInHomeRemoval(csub49si);
  }

  public CSUB26SO savePlacementDetail(CSUB26SI csub26si) throws ServiceException {
    return savePlacementDetail.savePlacementDetail(csub26si);
  }

  public CSUB50SO savePPTDetail(CSUB50SI csub50si) throws ServiceException {
    return savePPTDetail.savePPTDetail(csub50si);
  }

  public CSUB28SO savePPTParticipant(CSUB28SI csub28si) throws ServiceException {
    return savePPTParticipant.savePPTParticipant(csub28si);
  }

  public CCFC05SO saveReopenPAL(CCFC05SI ccfc05si) throws ServiceException {
    return saveReopenPAL.saveReopenPAL(ccfc05si);
  }

  public int saveNeedsOutcomes(NeedsAndOutcomesSaveSI needsandoutcomessavesi) throws ServiceException {
    return saveNeedsAndOutcomes.saveNeedsOutcomes(needsandoutcomessavesi);
  }

  public int saveNeedsAndOutcomesDetail(NeedsAndOutcomesSaveSI needsandoutcomessavesi) throws ServiceException {
    return saveNeedsOutcomesDetail.saveNeedsAndOutcomesDetail(needsandoutcomessavesi);
  }

  public FosterCareSecGoalsSaveSO saveFosterCareSecGoals(FosterCareSecGoalsSaveSI fosterCareSecGoalsSaveSi)
                                                                                                           throws ServiceException {
    return saveFosterCareSecGoals.saveFosterCareSecGoals(fosterCareSecGoalsSaveSi);
  }

  public WTLPSaveSI saveWtlp(WTLPSaveSI wtlpSave) {
    return saveWTLP.saveWtlp(wtlpSave);
  }

  public PaymentOfCareSaveSI savePaymentOfCare(PaymentOfCareSaveSI paymentOfCareSave) {
    return savePaymentOfCare.savePaymentOfCare(paymentOfCareSave);
  }

  public int checkStartDateOverlapsEndDate(int idPocEvent, Date startDate, Date endDate, int idStage, String indConcurrent) {
    return savePaymentOfCare.checkStartDateOverlapsEndDate(idPocEvent, startDate, endDate, idStage, indConcurrent);
  }

  public boolean isRelativeCareApproved (int idPerson, int idStage) {
    return savePaymentOfCare.isRelativeCareApproved(idPerson, idStage);
  }
  
  public boolean isRelativeCareAssessmentApproved ( int idStage) {
    return savePaymentOfCare.isRelativeCareAssessmentApproved( idStage);
  }
  
  public ROWCSUB45SOG01 findLegalStatus (int idStage, Date dtEffDate) {
    return savePaymentOfCare.findLegalStatus(idStage, dtEffDate);
  }
  
  public boolean childHasDob (int idPerson) {
    return savePaymentOfCare.childHasDob(idPerson);
  }
  
  public FosterCareParticipantSaveSI saveFosterCareParticipant(FosterCareParticipantSaveSI fcpSave)
                                                                                                   throws ServiceException {
    return saveFosterCareParticipant.saveFosterCareParticipant(fcpSave);
  }

  public FCGSSaveSO updateFCGSInformation(FCGSSaveSI fcgssaveSI) throws ServiceException {
    return saveFCGS.updateFCGSInformation(fcgssaveSI);
  }

  public FCCPFamilyDetailSaveSO saveFCCPFamilyDetail(List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsForEventfromState,
                                  FCCPFamilyDetailSO fccpFamilyDetail) throws ServiceException {
    return saveFCCPFamilyDetail.saveFCCPFamilyDetail(principalsForEventfromState, fccpFamilyDetail);
  }

  public CSVC14SO saveSvcDeliveryClosure(CSVC14SI csvc14si) throws ServiceException {
    return saveSvcDeliveryClosure.saveSvcDeliveryClosure(csvc14si);
  }

  public CSVC16SO svcDeliveryClosureValidation(CSVC16SI csvc16si) throws ServiceException {
    return svcDeliveryClosureValidation.svcDeliveryClosureValidation(csvc16si);
  }

  public CSUB31SO validatePlacementDetail(CSUB31SI csub31si) throws ServiceException {
    return validatePlacementDetail.validatePlacementDetail(csub31si);
  }

  public int saveChildPlan(ChildPlanDetailSaveSI childsavesi) throws ServiceException {
    return saveChildPlan.saveChildPlan(childsavesi);
  }

  public ChildPlanDetailRetrieveSO retrieveChildPlan(ChildPlanDetailRetrieveSI childretsi) throws ServiceException {
    return retrieveChildPlan.retrieveChildPlan(childretsi);
  }

  public int retrievePrimaryChildPersonId(int stageID) throws ServiceException {
    return retrievePrimaryChildPersonId.retrievePrimaryChildPersonId(stageID);
  }

  public int saveAdoptionInformation(AdoptionInformationSaveSI adoinfosavesi) throws ServiceException {
    return saveAdoptionInformation.saveAdoptionInformation(adoinfosavesi);
  }

  public AdoptionInformationRetrieveSO retrieveAdoptionInformation(AdoptionInformationRetrieveSI adoinforetsi)
                                                                                                              throws ServiceException {
    return retrieveAdoptionInformation.retrieveAdoptionInformation(adoinforetsi);
  }

  public String retrievePrivateAgencyName(int resourceID) throws ServiceException {
    return retrievePrivateAgencyName.retrievePrivateAgencyName(resourceID);
  }

  public int saveRelativeCareAssmt(RelativeCareAssessmentBean saveSI) {
    return saveRelativeCareAssmt.saveRelativeCareAssmt(saveSI);
  }

  public void deleteRelativeCareAssmt(RelativeCareAssmtDeleteSI deleteSI) {
    this.deleteRelativeCareAssmt.deleteRelativeCareAssmt(deleteSI);
  }

  public RelativeCareAssessmentBean retrieveRelativeCareAssmt(int idEvent) {
    return this.retrieveRelativeCareAssmt.retrieveRelativeCareAssmt(idEvent);
  }

  public void savePlacementAlerts(int idEvent, String secAttr) throws ServiceException {
       savePlacementAlerts.savePlacementAlerts(idEvent, secAttr);
  }
  
  public byte[] retrieveFCCPForm(FCCPFamilyDetailSI fccpFamilyDetailSI) throws ServiceException {
    return retrieveFCCPFamilyDetail.retrieveFCCPForm(fccpFamilyDetailSI);
  }
  
  public int saveCaseReview(CaseReviewSaveSI caseReviewSaveSI) throws ServiceException {
    return saveCaseReview.saveCaseReview(caseReviewSaveSI);
  }
  
  public CaseWatchSO retrieveCaseWatch(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCaseWatch.retrieveCaseWatch(caseWatchSI);
  }
  
  public AfcarsSO retrieveAfcars(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveAfcars.retrieveAfcars(caseWatchSI);
  }
  
  public NcandsSO retrieveNcands(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveNcands.retrieveNcands(caseWatchSI);
  }
  
  public NcandsChildrenSO retrieveNcandsChildren(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveNcandsChildren.retrieveNcandsChildren(caseWatchSI);
  }

  public APPLAPersonsConnectedRetrieveSO retrievePersonsConnected(APPLAPersonsConnectedRetrieveSI APPLAPersonsConnectedRetrieveSI) throws ServiceException {
    return retrieveAPPLAPersonsConnected.retrievePersonsConnected(APPLAPersonsConnectedRetrieveSI);
  }
  
  public CaseErrorsSO retrieveCwCaseErrors(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwCaseErrors.retrieveCwCaseErrors(caseWatchSI);
  }
  public CaseWarningsSO retrieveCwCaseWarnings(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwCaseWarnings.retrieveCwCaseWarnings(caseWatchSI);
  }
  public CwSummarySO retrieveCwSummary(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwSummary.retrieveCwSummary(caseWatchSI);
  }
  public CwCaseEventsSO retrieveCwCaseEvents(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwCaseEvents.retrieveCwCaseEvents(caseWatchSI);
  }
  public CwInvestigationSO retrieveCwInvestigation(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwInvestigation.retrieveCwInvestigation(caseWatchSI);
  }
  public CwOngoingSO retrieveCwOngoing(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwOngoing.retrieveCwOngoing(caseWatchSI);
  }
  public CwFcSummarySO retrieveCwFcSummary(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwFcSummary.retrieveCwFcSummary(caseWatchSI);
  }
  public CwContactStandardsSO retrieveCwContactStandards(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwContactStandards.retrieveCwContactStandards(caseWatchSI);
  }
  public CwTprSO retrieveCwTpr(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwTpr.retrieveCwTpr(caseWatchSI);
  }
  public CwCiAddlContactSO retrieveCwAddlContacts(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwAddlContacts.retrieveCwAddlContacts(caseWatchSI);
  }
  public CwCasePlanRevFtmSO retrieveCwCasePlanRevFtm(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwCasePlanRevFtm.retrieveCwCasePlanRevFtm(caseWatchSI);
  }
  public CwHealthScreensSO retrieveCwHealthScreens(CaseWatchSI caseWatchSI) throws ServiceException {
    return retrieveCwHealthScreens.retrieveCwHealthScreens(caseWatchSI);
  }
  
  protected void onEjbCreate() throws CreateException {
    deleteRelativeCareAssmt = getService(DeleteRelativeCareAssmt.class);
    retrieveAddressAndPhone = getService(RetrieveAddressAndPhone.class);
    retrieveAdoptionInformation = getService(RetrieveAdoptionInformation.class);
    retrieveChangeStageType = getService(RetrieveChangeStageType.class);
    retrieveChildPlan = getService(RetrieveChildPlan.class);
    retrieveConservatorshipRemoval = getService(RetrieveConservatorshipRemoval.class);
    retrieveFCCPFamilyDetail = getService(RetrieveFCCPFamilyDetail.class);
    retrieveFCGS = getService(RetrieveFCGS.class);
    retrieveFosterCareParticipant = getService(RetrieveFosterCareParticipant.class);
    retrieveFosterCarePrincipalList = getService(RetrieveFosterCarePrincipalList.class);
    retrieveFosterCareSecGoals = getService(RetrieveFosterCareSecGoals.class);
    retrieveIcpcDetail = getService(RetrieveIcpcDetail.class);
    saveIcpcDetail = getService(SaveIcpcDetail.class);
    retrieveLevelofCare = getService(RetrieveLevelofCare.class);
    retrieveNeedsAndOutcomes = getService(RetrieveNeedsAndOutcomes.class);
    retrieveNeedsAndOutcomesDetail = getService(RetrieveNeedsAndOutcomesDetail.class);
    retrieveSpecializedUnitPersonnel = getService(RetrieveSpecializedUnitPersonnel.class);
    retrievePALFollowup = getService(RetrievePALFollowup.class);
    retrievePALILSAssessment = getService(RetrievePALILSAssessment.class);
    retrievePALTrainingService = getService(RetrievePALTrainingService.class);
    retrievePaymentOfCare = getService(RetrievePaymentOfCare.class);
    retrievePersonsInHomeRemoval = getService(RetrievePersonsInHomeRemoval.class);
    retrievePlacementDetail = getService(RetrievePlacementDetail.class);
    retrievePPT = getService(RetrievePPT.class);
    retrievePPTParticipant = getService(RetrievePPTParticipant.class);
    retrieveRelativeCareAssmt = getService(RetrieveRelativeCareAssmt.class);
    retrieveSvcDeliveryClosure = getService(RetrieveSvcDeliveryClosure.class);
    retrieveWTLP = getService(RetrieveWTLP.class);
    retrieveFadHome = getService(RetrieveFadHome.class);
    retrieveCaseReview = getService(RetrieveCaseReview.class);
    saveAdoptionInformation = getService(SaveAdoptionInformation.class);
    saveChangeStageType = getService(SaveChangeStageType.class);
    saveChildPlan = getService(SaveChildPlan.class);
    saveClosePALStage = getService(SaveClosePALStage.class);
    saveConservatorshipRemoval = getService(SaveConservatorshipRemoval.class);
    saveFCCPFamilyDetail = getService(SaveFCCPFamilyDetail.class);
    saveFosterCareSecGoals = getService(SaveFosterCareSecGoals.class);
    saveFosterCareParticipant = getService(SaveFosterCareParticipant.class);
    saveLevelofCare = getService(SaveLevelofCare.class);
    saveNeedsAndOutcomes = getService(SaveNeedsAndOutcomes.class);
    saveNeedsOutcomesDetail = getService(SaveNeedsAndOutcomesDetail.class);
    savePALFollowup = getService(SavePALFollowup.class);
    savePALILSAssessment = getService(SavePALILSAssessment.class);
    savePAL = getService(SavePAL.class);
    savePALTrainingService = getService(SavePALTrainingService.class);
    savePaymentOfCare = getService(SavePaymentOfCare.class);
    savePersonsInHomeRemoval = getService(SavePersonsInHomeRemoval.class);
    savePlacementDetail = getService(SavePlacementDetail.class);
    savePPTDetail = getService(SavePPTDetail.class);
    savePPTParticipant = getService(SavePPTParticipant.class);
    saveRelativeCareAssmt = getService(SaveRelativeCareAssmt.class);
    saveReopenPAL = getService(SaveReopenPAL.class);
    saveSvcDeliveryClosure = getService(SaveSvcDeliveryClosure.class);
    saveFCGS = getService(SaveFCGS.class);
    saveWTLP = getService(SaveWTLP.class);
    savePlacementAlerts = getService(SavePlacementAlerts.class);
    svcDeliveryClosureValidation = getService(SvcDeliveryClosureValidation.class);
    validatePlacementDetail = getService(ValidatePlacementDetail.class);
    saveChildPlan = getService(SaveChildPlan.class);
    retrieveChildPlan = getService(RetrieveChildPlan.class);
    retrievePrimaryChildPersonId = getService(RetrievePrimaryChildPersonId.class);
    saveAdoptionInformation = getService(SaveAdoptionInformation.class);
    retrieveAdoptionInformation = getService(RetrieveAdoptionInformation.class);
    retrievePrivateAgencyName = getService(RetrievePrivateAgencyName.class);
    saveCaseReview = getService(SaveCaseReview.class);
    retrieveAfcars = getService(RetrieveAfcars.class);
    retrieveCaseWatch = getService(RetrieveCaseWatch.class);
    retrieveNcands = getService(RetrieveNcands.class);
    retrieveNcandsChildren = getService(RetrieveNcandsChildren.class);
    retrieveAPPLAPersonsConnected = getService(RetrieveAPPLAPersonsConnected.class);
    retrieveCwCaseErrors = getService(RetrieveCwCaseErrors.class);
    retrieveCwCaseWarnings = getService(RetrieveCwCaseWarnings.class);
    retrieveCwSummary = getService(RetrieveCwSummary.class);
    retrieveCwCaseEvents = getService(RetrieveCwCaseEvents.class);
    retrieveCwInvestigation = getService(RetrieveCwInvestigation.class);
    retrieveCwOngoing = getService(RetrieveCwOngoing.class);
    retrieveCwFcSummary = getService(RetrieveCwFcSummary.class);
    retrieveCwContactStandards = getService(RetrieveCwContactStandards.class);
    retrieveCwTpr = getService(RetrieveCwTpr.class);
    retrieveCwAddlContacts = getService(RetrieveCwAddlContacts.class);
    retrieveCwCasePlanRevFtm = getService(RetrieveCwCasePlanRevFtm.class);
    retrieveCwHealthScreens = getService(RetrieveCwHealthScreens.class);
  }
}
