/**
 * Created on Jun 28, 2006 at 10:49:09 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForCpsHistorySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiversionCnclsnRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiversionCnclsnSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveDiversionConclusionValidationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpclInvestigationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiversionCnclsnRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiversionCnclsnSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationSaveSO;

import javax.ejb.CreateException;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildDeleteSI;

import org.springframework.beans.factory.BeanFactory;

public class InvestigationBean extends BaseSpringStatelessSessionBean implements Investigation {
  private CheckForCpsHistory checkForCpsHistory;
  private RetrieveCPSInvestigationConclusion retrieveCPSInvestigationConclusion;
  private RetrieveDiversionCnclsn retrieveDiversionCnclsn;
  private RetrieveEmergencyAssistance retrieveEmergencyAssistance;
  private RetrievePersonAddressPersonPhone retrievePersonAddressPersonPhone;
  private RetrieveProfessionalAssessment retrieveProfessionalAssessment;
  private RetrievePolicyWaiver retrievePolicyWaiver;
  private RetrieveSpclInvestigation retrieveSpclInvestigation;
  private SaveCPSInvestigationConclusion saveCPSInvestigationConclusion;
  private SaveCPSInvestigationConclusionValidation saveCPSInvestigationConclusionValidation;
  private SaveDiversionCnclsn saveDiversionCnclsn;
  private SaveEmergencyActionDetail saveEmergencyActionDetail;
  private SaveProfessionalAssessment saveProfessionalAssessment;
  private SavePolicyWaiver savePolicyWaiver;
  private SaveDiversionConclusionValidation saveDiversionConclusionValidation;
  private RetrieveSafetyResourceChild retrieveSafetyResourceChild;
  private SaveSafetyResourceChild saveSafetyResourceChild;
  private RetrieveSafetyResource retrieveSafetyResource;
  private SaveSafetyResource saveSafetyResource;
  private SaveSpclInvestigation saveSpclInvestigation;
  private DeleteSafetyResource deleteSafetyResource;
  private DeleteSafetyResourceChild deleteSafetyResourceChild;
  private RetrieveChildrenFirstReferral retrieveChildrenFirstReferral;
  private SaveChildrenFirstReferral saveChildrenFirstReferral;
  private RetrieveIncomingDetail retrieveIncomingDetail;
  

  public CINV14SO retrieveCPSInvestigationConclusion(CINV14SI cinv14si) throws ServiceException {
    return retrieveCPSInvestigationConclusion.retrieveCPSInvestigationConclusion(cinv14si);
  }

  public DiversionCnclsnRetrieveSO retrieveDiversionCnclsn(DiversionCnclsnRetrieveSI diversionCnclsnRetrieveSI) throws ServiceException {
    return retrieveDiversionCnclsn.retrieveDiversionCnclsn(diversionCnclsnRetrieveSI);
  }
  
  public CINV11SO retrieveEmergencyAssistance(CINV11SI cinv11si) throws ServiceException {
    return retrieveEmergencyAssistance.retrieveEmergencyAssistance(cinv11si);
  }

  public CINV30SO retrievePersonAddressPersonPhone(CINV30SI cinv30si) {
    return retrievePersonAddressPersonPhone.retrievePersonAddressPersonPhone(cinv30si);
  }

  public CINV29SO retrieveProfessionalAssessment(CINV29SI cinv29si) throws ServiceException {
    return retrieveProfessionalAssessment.retrieveProfessionalAssessment(cinv29si);
  }

  public PolicyWaiverRetrieveSO retrievePolicyWaiver(PolicyWaiverRetrieveSI policyWaiverRetrieveSI)
          throws ServiceException {
    return retrievePolicyWaiver.retrievePolicyWaiver(policyWaiverRetrieveSI);
  }
  
  public SpclInvestigationRetrieveSO retrieveSpclInvestigation(SpclInvestigationRetrieveSI spclInvestigationRetrieveSI) throws ServiceException {
    return retrieveSpclInvestigation.retrieveSpclInvestigation(spclInvestigationRetrieveSI);
  }

  public CINV16SO saveCPSInvestigationConclusion(CINV16SI cinv16si) throws ServiceException {
    return saveCPSInvestigationConclusion.saveCPSInvestigationConclusion(cinv16si);
  }

  public CINV15SO saveCPSInvestigationConclusionValidation(CINV15SI cinv15si) throws ServiceException {
    return saveCPSInvestigationConclusionValidation.saveCPSInvestigationConclusionValidation(cinv15si);
  }

  public DiversionCnclsnSaveSO saveDiversionCnclsn(DiversionCnclsnSaveSI diversionCnclsnSaveSI) throws ServiceException {
    return saveDiversionCnclsn.saveDiversionCnclsn(diversionCnclsnSaveSI);
  }

  public List<Integer> saveDiversionConclusionValidation(SaveDiversionConclusionValidationSI saveDiversionConclusionValidationSI) throws ServiceException {
    return saveDiversionConclusionValidation.saveDiversionConclusionValidation(saveDiversionConclusionValidationSI);
  }
  
  public CINV12SO saveEmergencyActionDetail(CINV12SI cinv12si) throws ServiceException {
    return saveEmergencyActionDetail.saveEmergencyActionDetail(cinv12si);
  }

  public CINV31SO saveProfessionalAssessment(CINV31SI cinv31si) throws ServiceException {
    return saveProfessionalAssessment.saveProfessionalAssessment(cinv31si);
  }

  public int savePolicyWaiver(PolicyWaiverSaveSI policyWaiverSaveSI) throws ServiceException {
    return savePolicyWaiver.savePolicyWaiver(policyWaiverSaveSI);
  }
  
  public SafetyResourceChildRetrieveSO retrieveSafetyResourceChild(SafetyResourceChildRetrieveSI safetyResourceChildRetrieveSI) throws ServiceException {
    return retrieveSafetyResourceChild.retrieveSafetyResourceChild(safetyResourceChildRetrieveSI);
  }
  
  public SafetyResourceChildSaveSO saveSafetyResourceChild(SafetyResourceChildSaveSI safetyResourceChildSaveSI) throws ServiceException {
    return saveSafetyResourceChild.saveSafetyResourceChild(safetyResourceChildSaveSI);
  }
  
  public SpclInvestigationSaveSO saveSpclInvestigation(SpclInvestigationRetrieveSO spclInvestigationRetrieveSO) throws ServiceException {
    return saveSpclInvestigation.saveSpclInvestigation(spclInvestigationRetrieveSO);
  }
  
  public Boolean checkForCpsHistory(CheckForCpsHistorySI checkForCpsHisorySI) throws ServiceException {
    return checkForCpsHistory.checkForCpsHistory(checkForCpsHisorySI);
  }
  
  public SafetyResourceRetrieveSO retrieveSafetyResource(SafetyResourceRetrieveSI safetyResourceRetrieveSI) throws ServiceException {
    return retrieveSafetyResource.retrieveSafetyResource(safetyResourceRetrieveSI);
  }
  
  public SafetyResourceSaveSO saveSafetyResource(SafetyResourceSaveSI safetyResourceSaveSI) throws ServiceException {
    return saveSafetyResource.saveSafetyResource(safetyResourceSaveSI);
  }
  
  public void deleteSafetyResource(SafetyResourceDeleteSI safetyResourceDeleteSI) throws ServiceException {
    deleteSafetyResource.deleteSafetyResource(safetyResourceDeleteSI);
  }
  
  public void deleteSafetyResourceChild(SafetyResourceChildDeleteSI safetyResourceChildDeleteSI) throws ServiceException {
    deleteSafetyResourceChild.deleteSafetyResourceChild(safetyResourceChildDeleteSI);
  }
  
  public byte[] retrieveSafetyRsrcForm(SafetyResourceRetrieveSI safetyResourceRetrieveSI) throws ServiceException {
    return retrieveSafetyResource.retrieveSafetyRsrcForm(safetyResourceRetrieveSI);
  }
  
  public ChildrenFirstReferralRetrieveSO retrieveChildrenFirstReferral(ChildrenFirstReferralRetrieveSI childrenFirstReferralRetrieveSI) throws ServiceException {
    return retrieveChildrenFirstReferral.retrieveChildrenFirstReferral(childrenFirstReferralRetrieveSI);
  }
  
  public ChildrenFirstReferralSaveSO saveChildrenFirstReferral(ChildrenFirstReferralSaveSI childrenFirstReferralSaveSI) throws ServiceException {
    return saveChildrenFirstReferral.saveChildrenFirstReferral(childrenFirstReferralSaveSI);
  }
  
  public Integer retrieveIncomingDetail(Integer idStage) throws ServiceException {
	  return retrieveIncomingDetail.retrieveIncomingDetail(idStage);
  }

  protected void onEjbCreate() throws CreateException {
    BeanFactory beanFactory = getBeanFactory();
    checkForCpsHistory = getService(CheckForCpsHistory.class);
    retrieveCPSInvestigationConclusion = getService(RetrieveCPSInvestigationConclusion.class);
    retrieveDiversionCnclsn = getService(RetrieveDiversionCnclsn.class);
    retrieveEmergencyAssistance = getService(RetrieveEmergencyAssistance.class);
    retrievePersonAddressPersonPhone = getService(RetrievePersonAddressPersonPhone.class);
    retrievePolicyWaiver = getService(RetrievePolicyWaiver.class);
    retrieveProfessionalAssessment = getService(RetrieveProfessionalAssessment.class);
    retrieveSpclInvestigation = getService(RetrieveSpclInvestigation.class);
    saveCPSInvestigationConclusion = getService(SaveCPSInvestigationConclusion.class);
    saveCPSInvestigationConclusionValidation = getService(SaveCPSInvestigationConclusionValidation.class);
    saveDiversionCnclsn = getService(SaveDiversionCnclsn.class);
    saveEmergencyActionDetail = getService(SaveEmergencyActionDetail.class);
    saveProfessionalAssessment = getService(SaveProfessionalAssessment.class);
    savePolicyWaiver = getService(SavePolicyWaiver.class);
    saveDiversionConclusionValidation = getService(SaveDiversionConclusionValidation.class);
    retrieveSafetyResourceChild = getService(RetrieveSafetyResourceChild.class);
    saveSafetyResourceChild = getService(SaveSafetyResourceChild.class);
    retrieveSafetyResource = getService(RetrieveSafetyResource.class);
    saveSafetyResource = getService(SaveSafetyResource.class);
    saveSpclInvestigation = getService(SaveSpclInvestigation.class);
    deleteSafetyResource = getService(DeleteSafetyResource.class);
    deleteSafetyResourceChild = getService(DeleteSafetyResourceChild.class);
    retrieveChildrenFirstReferral = getService(RetrieveChildrenFirstReferral.class);
    saveChildrenFirstReferral = getService(SaveChildrenFirstReferral.class);
    retrieveIncomingDetail = getService(RetrieveIncomingDetail.class);
  }
}
