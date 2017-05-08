/**
 * Created on Jun 28, 2006 at 11:22:23 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForKennyAReqsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralLogRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProviderAllegationHistorySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ResourceUpdateResponseWI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveFAHomeSupervisorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckForKennyAReqsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAllegationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProviderAllegationHistorySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ResponseWO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveResourceHouseholdMembersSO;

import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;

import org.springframework.beans.factory.BeanFactory;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 01/30/2009   mxpatel           STGAP00010438: added retrieveORSFacilityDetail(String facilityId, int pageNbr, int pageSize)
 * 11/22/2010   schoi             SMS #81140: MR-074 Added checkInconsistentMaritalStatus(CFAD08SI cfad08si)
 * 09/12/2011   charden           STGAP00017058 - modified return type of retrieveLog(CFAD31SI cfad31si)
 * 09/15/2011   charden           STGAP00017058 - added checkForKennyAReqs service
 *
 */

public class ResourceBean extends BaseSpringStatelessSessionBean implements Resource {

  private SaveResourceUpdateResponse saveResourceUpdateResponse;
  private Caretaker caretaker;
  private RetrieveAreaServed retrieveAreaServed;
  private RetrieveCloseReopenFAHome retrieveCloseReopenFAHome;
  private RetrieveFacilityDetail retrieveFacilityDetail;
  private RetrieveFacilityPlacementLog retrieveFacilityPlacementLog;
  private RetrieveFAHomeHistory retrieveFAHomeHistory;
  private DeleteResourceHistory deleteResourceHistory;
  private CheckHomeNameAddressExists checkHomeNameAddressExists;
  private CheckIfHomeHasActivePlacements checkIfHomeHasActivePlacements;
  private CheckInconsistentMaritalStatus checkInconsistentMaritalStatus;
  private RetrieveHomeApplicant retrieveHomeApplicant;
  private RetrieveHomeDemographics retrieveHomeDemographics;
  private RetrieveHomeLicense retrieveHomeLicense;
  private RetrieveResourceCharacteristics retrieveResourceCharacteristics;
  private RetrieveResourceDetail retrieveResourceDetail;
  private RetrieveResourceHistory retrieveResourceHistory;
  private RetrieveResourceName retrieveResourceName;
  private RetrieveSubcontractorList retrieveSubcontractorList;
  private SaveAreaServed saveAreaServed;
  private SaveFacilityDetail saveFacilityDetail;
  private SaveFAHomeCloseReopen saveFAHomeCloseReopen;
  private SaveFAHomeSupervisor saveFAHomeSupervisor;
  private SaveHomeApplicant saveHomeApplicant;
  private SaveHomeDemographics saveHomeDemographics;
  private SaveHomeLicense saveHomeLicense;
  private SaveResourceCharacteristics saveResourceCharacteristics;
  private SaveResourceDetail saveResourceDetail;
  private SaveResourceHistory saveResourceHistory;
  private SaveSubcontractorList saveSubcontractorList;
  private UpdateFAResource updateFAResource;
  private RetrievePlacementReferralLog retrievePlacementReferralLog;
  private RetrievePlacementReferralDetail retrievePlacementReferralDetail;
  private SavePlacementReferralDetail savePlacementReferralDetail;
  private SaveCaretakerDetail saveCaretakerDetail;
  private RetrieveCaretakerInformation retrieveCaretakerInformation;
  private RetrieveORSResourceDetail retrieveORSResourceDetail;
  private UpdateORSResource updateORSResource;
  private RetrieveResourceHouseholdMembers retrieveResourceHouseholdMembers;
  private SyncResourceHhMbrsFaPersonDtl syncResourceHhMbrsFaPersonDtl;
  private RetrieveHomeStatusLastApproval retrieveHomeStatusLastApproval;
  private RetrieveProviderAllgtnHistory retrieveProviderAllgtnHistory;
  private CheckForKennyAReqs checkForKennyAReqs;


  public ResponseWO saveResourceUpdateResponse(ResourceUpdateResponseWI resourseUpdateResponseSI){
    return saveResourceUpdateResponse.saveResourceUpdateResponse(resourseUpdateResponseSI);
  }

  public CRES18SO caretaker(CRES18SI cres18si) throws ServiceException {
    return caretaker.caretaker(cres18si);
  }

  public CRES05SO retrieveAreaServed(CRES05SI cres05si) throws ServiceException {
    return retrieveAreaServed.retrieveAreaServed(cres05si);
  }

  public CFAD30SO retrieveNeccessaryInformation(CFAD30SI cfad30si) throws ServiceException {
    return retrieveCloseReopenFAHome.retrieveNeccessaryInformation(cfad30si);
  }

  public CRES09SO retrieveFacilityDetail(CRES09SI cres09si) throws ServiceException {
    return retrieveFacilityDetail.retrieveFacilityDetail(cres09si);
  }

  public PlacementLogSO retrieveLog(CFAD31SI cfad31si) throws ServiceException {
    return retrieveFacilityPlacementLog.retrieveLog(cfad31si);
  }
  
  public CheckForKennyAReqsSO checkForKennyAReqs(CheckForKennyAReqsSI checkForKennyAReqsSI) throws ServiceException {
    return checkForKennyAReqs.checkForKennyAReqs(checkForKennyAReqsSI);
  }

  public CFAD12SO retrieveFAHomeHistory(CFAD12SI cfad12si) {
    return retrieveFAHomeHistory.retrieveFAHomeHistory(cfad12si);
  }

  public CFAD14SO deleteResourceHistory(CFAD14SI cfad14si) {
    return deleteResourceHistory.deleteResourceHistory(cfad14si);
  }

  public HomeApplicantRetrieveSO retrieveHomeApplicantInfo(HomeApplicantRetrieveSI homeApplicantRetrieveSI) throws ServiceException {
    return retrieveHomeApplicant.retrieveHomeApplicantInfo(homeApplicantRetrieveSI);
  }

  public CFAD07SO retrieveHomeDemographics(CFAD07SI cfad07si) throws ServiceException {
    return retrieveHomeDemographics.retrieveHomeDemographics(cfad07si);
  }

  public CFAD37SO retrieveHomeLicenseInformation(CFAD37SI cfad37si) throws ServiceException {
    return retrieveHomeLicense.retrieveHomeLicenseInformation(cfad37si);
  }

  public CRES07SO retrieveCharacteristicsData(CRES07SI cres07si) throws ServiceException {
    return retrieveResourceCharacteristics.retrieveCharacteristicsData(cres07si);
  }

  public CRES03SO retrieveResourceDetail(CRES03SI cres03si) throws ServiceException {
    return retrieveResourceDetail.retrieveResourceDetail(cres03si);
  }

  public CFAD13SO retrieveResourceHistory(CFAD13SI cfad13si) throws ServiceException {
    return retrieveResourceHistory.retrieveResourceHistory(cfad13si);
  }

  public CCON17SO retrieveResourceName(CCON17SI ccon17si) {
    return retrieveResourceName.retrieveResourceName(ccon17si);
  }

  public CCON15SO findSubcontractorResources(CCON15SI ccon15si) throws ServiceException {
    return retrieveSubcontractorList.findSubcontractorResources(ccon15si);
  }

  public CRES06SO saveAreaServed(CRES06SI cres06si) throws ServiceException {
    return saveAreaServed.saveAreaServed(cres06si);
  }

  public CRES10SO saveFacilityDetail(CRES10SI cres10si) throws ServiceException {
    return saveFacilityDetail.saveFacilityDetail(cres10si);
  }

  public CFAD36SO saveFAHomeCloseReopen(CFAD36SI cfad36si) throws ServiceException {
    return saveFAHomeCloseReopen.saveFAHomeCloseReopen(cfad36si);
  }

  public int saveFAHomeSupervisor(SaveFAHomeSupervisorSI saveFAHomeSupervisorsi) throws ServiceException {
    return saveFAHomeSupervisor.saveFAHomeSupervisor(saveFAHomeSupervisorsi);
  }

  public HomeApplicantSaveSO saveHomeApplicantInfo(HomeApplicantSaveSI homeApplicantSaveSI) throws ServiceException {
    return saveHomeApplicant.saveHomeApplicantInfo(homeApplicantSaveSI);
  }

  public Boolean checkHomeNameAddressExists(CFAD08SI cfad08si) throws ServiceException {
    return checkHomeNameAddressExists.checkHomeNameAddressExists(cfad08si);
  }

  public CFAD08SO saveHomeDemographics(CFAD08SI cfad08si) throws ServiceException {
    return saveHomeDemographics.saveHomeDemographics(cfad08si);
  }

  public CFAD38SO saveHomeLicense(CFAD38SI cfad38si) throws ServiceException {
    return saveHomeLicense.saveHomeLicense(cfad38si);
  }

  public boolean checkEvalDocExists(int idStage) throws ServiceException {
    return saveHomeLicense.checkEvalDocExists(idStage);
  }

  public boolean checkIfHomeHasActivePlacements (int idResource, String cdClosureRsn) throws ServiceException {
    return checkIfHomeHasActivePlacements.checkIfHomeHasActivePlacements(idResource, cdClosureRsn);
  }

  public boolean checkInconsistentMaritalStatus(CFAD08SI cfad08si) throws ServiceException {
    return checkInconsistentMaritalStatus.checkInconsistentMaritalStatus(cfad08si);
  }

  public CRES08SO saveResourceCharacteristics(CRES08SI cres08si) throws ServiceException {
    return saveResourceCharacteristics.saveResourceCharacteristics(cres08si);
  }

  public CRES04SO saveResourceDetail(CRES04SI cres04si) throws ServiceException {
    return saveResourceDetail.saveResourceDetail(cres04si);
  }

  public CFAD14SO audResourceHistory(CFAD14SI cfad14si) throws ServiceException {
    return saveResourceHistory.audResourceHistory(cfad14si);
  }

  public CCON16SO saveUpdateOrDeleteRscrcLink(CCON16SI ccon16si) throws ServiceException {
    return saveSubcontractorList.saveUpdateOrDeleteRscrcLink(ccon16si);
  }

  public CFAD01UO updateFAResource(CFAD01UI input) throws ServiceException {
    return updateFAResource.updateFAResource(input);
  }

  public PlacementReferralLogRetrieveSO retrievePlacementReferralLog(PlacementReferralLogRetrieveSI placementReferralLogRetrieveSI) throws ServiceException {
    return retrievePlacementReferralLog.retrievePlacementReferralLog(placementReferralLogRetrieveSI);
  }

  public PlacementReferralDetailRetrieveSO retrievePlacementReferralDetail(PlacementReferralDetailRetrieveSI placementReferralDetailRetrieveSI) throws ServiceException {
    return retrievePlacementReferralDetail.retrievePlacementReferralDetail(placementReferralDetailRetrieveSI);
  }

  public PlacementReferralDetailSaveSO savePlacementReferralDetail(PlacementReferralDetailSaveSI placementReferralDetailSaveSI) throws ServiceException {
    return savePlacementReferralDetail.savePlacementReferralDetail(placementReferralDetailSaveSI);
  }

  public CRES18SO saveCaretakerDetail(CRES18SI cres18SI){
    return saveCaretakerDetail.saveCaretakerDetail(cres18SI);
  }

  public CRES18SO retrieveCaretakerInformation(CRES18SI cres18SI){
    return retrieveCaretakerInformation.retrieveCaretakerInformation(cres18SI);
  }

  // mxpatel added this for defect #10438
  public ORSResourceDetailSO retrieveORSFacilityDetail(String facilityId, int pageNbr, int pageSize) {
    return retrieveORSResourceDetail.retrieveORSFacilityDetail(facilityId, pageNbr, pageSize);
  }

  public ORSResourceDetailSO retrieveORSFacilityDetail(String facilityId) {
    return retrieveORSResourceDetail.retrieveORSFacilityDetail(facilityId);
  }

  public List<ORSAllegationSO> retrieveORSAllegations(String compliantId) {
    return retrieveORSResourceDetail.retrieveORSAllegations(compliantId);
  }

  public int updateFacilityResourceId(String facId, int resourceid) {
    return updateORSResource.updateFacilityResourceId(facId, resourceid);
  }

  public RetrieveResourceHouseholdMembersSO retrieveResourceHouseholdMembers(int idResource) {
    return retrieveResourceHouseholdMembers.retrieveResourceHouseholdMembers(idResource);
  }

  public void syncResourceHhMbrsFaPersonDtl (int idResource) throws ServiceException {
    syncResourceHhMbrsFaPersonDtl.syncResourceHhMbrsFaPersonDtl(idResource);
  }

  public Date retrieveHomeStatusLastApproval (int idResource, List<String> cdFaHomeStatuses) throws ServiceException {
    return retrieveHomeStatusLastApproval.retrieveHomeStatusLastApproval(idResource, cdFaHomeStatuses);
  }

  public ProviderAllegationHistorySO retrieveProviderAllgtnHistory(ProviderAllegationHistorySI providerAllegationHistorySI) {
      return retrieveProviderAllgtnHistory.retrieveProviderAllgtnHistory(providerAllegationHistorySI);
  }

  protected void onEjbCreate() throws CreateException {
    BeanFactory beanFactory = getBeanFactory();
    saveResourceUpdateResponse = getService(SaveResourceUpdateResponse.class);
    caretaker = getService(Caretaker.class);
    retrieveAreaServed = getService(RetrieveAreaServed.class);
    retrieveCloseReopenFAHome = getService(RetrieveCloseReopenFAHome.class);
    retrieveFacilityDetail = getService(RetrieveFacilityDetail.class);
    retrieveFacilityPlacementLog = getService(RetrieveFacilityPlacementLog.class);
    retrieveFAHomeHistory = getService(RetrieveFAHomeHistory.class);
    deleteResourceHistory = getService(DeleteResourceHistory.class);
    retrieveHomeApplicant = getService(RetrieveHomeApplicant.class);
    retrieveHomeDemographics = getService(RetrieveHomeDemographics.class);
    retrieveHomeLicense = getService(RetrieveHomeLicense.class);
    retrieveResourceCharacteristics = getService(RetrieveResourceCharacteristics.class);
    retrieveResourceDetail = getService(RetrieveResourceDetail.class);
    retrieveResourceHistory = getService(RetrieveResourceHistory.class);
    retrieveResourceName = getService(RetrieveResourceName.class);
    retrieveSubcontractorList = getService(RetrieveSubcontractorList.class);
    saveAreaServed = getService(SaveAreaServed.class);
    saveFacilityDetail = getService(SaveFacilityDetail.class);
    saveFAHomeCloseReopen = getService(SaveFAHomeCloseReopen.class);
    saveFAHomeSupervisor = getService(SaveFAHomeSupervisor.class);
    saveHomeApplicant = getService(SaveHomeApplicant.class);
    saveHomeDemographics = getService(SaveHomeDemographics.class);
    saveHomeLicense = getService(SaveHomeLicense.class);
    checkHomeNameAddressExists = getService(CheckHomeNameAddressExists.class);
    checkIfHomeHasActivePlacements = getService(CheckIfHomeHasActivePlacements.class);
    checkInconsistentMaritalStatus = getService(CheckInconsistentMaritalStatus.class);
    saveResourceCharacteristics = getService(SaveResourceCharacteristics.class);
    saveResourceDetail = getService(SaveResourceDetail.class);
    saveResourceHistory = getService(SaveResourceHistory.class);
    saveSubcontractorList = getService(SaveSubcontractorList.class);
    updateFAResource = getService(UpdateFAResource.class);
    retrievePlacementReferralLog = getService(RetrievePlacementReferralLog.class);
    retrievePlacementReferralDetail = getService(RetrievePlacementReferralDetail.class);
    savePlacementReferralDetail = getService(SavePlacementReferralDetail.class);
    saveCaretakerDetail = getService(SaveCaretakerDetail.class);
    retrieveCaretakerInformation = getService(RetrieveCaretakerInformation.class);
    retrieveORSResourceDetail = getService(RetrieveORSResourceDetail.class);
    updateORSResource = getService(UpdateORSResource.class);
    retrieveResourceHouseholdMembers = getService(RetrieveResourceHouseholdMembers.class);
    syncResourceHhMbrsFaPersonDtl = getService(SyncResourceHhMbrsFaPersonDtl.class);
    retrieveHomeStatusLastApproval = getService(RetrieveHomeStatusLastApproval.class);
    retrieveProviderAllgtnHistory = getService(RetrieveProviderAllgtnHistory.class);
    checkForKennyAReqs = getService(CheckForKennyAReqs.class);
  }
}
