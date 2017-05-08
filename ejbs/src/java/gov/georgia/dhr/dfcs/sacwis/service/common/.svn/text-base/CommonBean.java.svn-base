/**
 * Created on Jun 28, 2006 at 9:48:37 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.io.File;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.UCMDataObject;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfMaltreatmentInCareSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRemovalPriorToAllegIncidentSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermineIfPptDocumentedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DocumentTemplateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExternalDocumentationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveFacAgencyHomesListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveContactRuleSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitHierarchyRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateContactDateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExternalDocumentationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnitHierarchyRetrieveSO;

import javax.ejb.CreateException;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - adding hasSecurityClass() method
 *
 */
@SuppressWarnings("serial")
public class CommonBean extends BaseSpringStatelessSessionBean implements Common {
  
  private AddPortalContactDetail addPortalContactDetail;
  
  private CheckIfMaltreatmentInCare checkIfMaltreatmentInCare;
  
  private CheckIfRemovalPriorToAllegIncident checkIfRemovalPriorToAllegIncident;
  
  private ContactDetailRetrieve contactDetailRetrieve;

  private ContactDetailSave contactDetailSave;

  private ContactListSearch contactListSearch;
  
  private CreateContactStandardsSummary createContactStandardsSummary;

  private DeleteContactStandards deleteContactStandards;
  
  private DetermineIfPptDocumented determineIfPptDocumented;
  
  private DetermineWhichApprover determineWhichApprover;
  
  private PrepopulateContactStandards prepopulateContactStandards;
  
  private RetrieveApprovers retrieveApprovers;

  private RetrieveContactSearchPersonList retrieveContactSearchPersonList;

  private RetrieveCriminalHistory retrieveCriminalHistory;

  private RetrieveExternalDocumentation retrieveExternalDocumentation;

  private RetrieveFAHomeMemberTraining retrieveFAHomeMemberTraining;
  
  private RetrieveContactStandards retrieveContactStandards;

  private RetrieveProtectiveServiceAlert retrieveProtectiveServiceAlert;

  private RetrieveTaskList retrieveTaskList;

  private RetrieveUnitHierarchy retrieveUnitHierarchy;

  private SaveExternalDocumentation saveExternalDocumentation;
  
  private SaveContactRule saveContactRule;
  
  private SaveContactStandards saveContactStandards;

  private SaveProtectiveServiceAlert saveProtectiveServiceAlert;
 
  private CheckIfUserHasRight checkIfUserHasRight;
  
  private CheckIfUserWasEverAssigned checkIfUserWasEverAssigned;

  private RetrieveDocumentTemplate retrieveDocumentTemplate;
  
  private RetrieveFacAgencyHomesList retrieveFacAgencyHomesList;
  
  private RetrieveVendorStaffList retrieveVendorStaffList;
  
  private ValidateContactDate validateContactDate;
  
  private SyncContactRule syncContactRule;

  private SyncFaPersonDetailRecordsCheck syncFaPersonDetailRecordsCheck;
  
  private SyncFaPersonDetailHealthDetail syncFaPersonDetailHealthDetail;
  
  private IsUserDeputyPolicyCountyDrt isUserDeputyPolicyCountyDrt;

  
  
  public Map<String,Boolean> checkIfMaltreatmentInCare (CheckIfMaltreatmentInCareSI checkIfMaltreatmentInCareSI) {
    return checkIfMaltreatmentInCare.checkIfMaltreatmentInCare(checkIfMaltreatmentInCareSI);
  }
  
  public boolean checkIfRemovalPriorToAllegIncident (CheckIfRemovalPriorToAllegIncidentSI checkIfRemovalPriorToAllegIncidentSI) {
    return checkIfRemovalPriorToAllegIncident.checkIfRemovalPriorToAllegIncident (checkIfRemovalPriorToAllegIncidentSI);
  }
  
  public boolean determineIfUserWasEverAssigned(int idCase, int idStage, int idPerson) {
    return checkIfUserWasEverAssigned.determineIfUserWasEverAssigned(idCase, idStage, idPerson);
  }
  
  public boolean determineIfUserHasRight(int idPerson, String securityAttribute) {
    return checkIfUserHasRight.determineIfUserHasRight(idPerson, securityAttribute);
  }

  public int[] retrieveUserRights(int idPerson) {
    return checkIfUserHasRight.retrieveUserRights(idPerson);
  }

  public CSYS08SO contactDetailRetrieve(CSYS08SI csys08si) throws ServiceException {
    return contactDetailRetrieve.contactDetailRetrieve(csys08si);
  }
  
  public CSYS08SO contactDetailRetrieve(CSYS08SI csys08si, int copyId, String copyFullName) throws ServiceException {
	    return contactDetailRetrieve.contactDetailRetrieve(csys08si,copyId,copyFullName);
	  }

  public CSYS07SO contactDetailSave(CSYS07SI csys07si) throws ServiceException {
    return contactDetailSave.contactDetailSave(csys07si);
  }

  public CSYS04SO contactListSearch(CSYS04SI csys04si) throws ServiceException {
    return contactListSearch.contactListSearch(csys04si);
  }
  
  public ContactStandardsSummarySO createContactStandardsSummary (ContactStandardsSummarySI contactStandardsSummarySI) throws ServiceException {
    return createContactStandardsSummary.createContactStandardsSummary(contactStandardsSummarySI);
  }

  public void deleteContactStandards (ContactStandardsSaveSI contactStandardsSaveSI) throws ServiceException {
    deleteContactStandards.deleteContactStandards(contactStandardsSaveSI);
  }
  
  public boolean determineIfPptDocumented(DetermineIfPptDocumentedSI determineIfPptDocumentedSI) throws ServiceException {
    
    return determineIfPptDocumented.determineIfPptDocumented(determineIfPptDocumentedSI);
  }
  
  public String determineWhichApprover(int idApproval, String approvalType) throws ServiceException {
    
    return determineWhichApprover.determineWhichApprover(idApproval, approvalType);
  }

  public ContactStandardsRetrieveSO prepopulateContactStandards(ContactStandardsRetrieveSI contactStandardsRetrieveSI)throws ServiceException {
    return prepopulateContactStandards.prepopulateContactStandards(contactStandardsRetrieveSI);
  }
  
  public ApproversRetrieveSO retrieveApprovers(ApproversRetrieveSI approversRetrieveSI) throws ServiceException {
    return retrieveApprovers.retrieveApprovers(approversRetrieveSI);
  }

  public ContactStandardsRetrieveSO retrieveContactStandards (ContactStandardsRetrieveSI contactStandardsRetrieveSI) throws ServiceException {
   return retrieveContactStandards.retrieveContactStandards (contactStandardsRetrieveSI);
  }

  public CSYS03SO retrievePersonList(CSYS03SI csys03si) throws ServiceException {
    return retrieveContactSearchPersonList.retrievePersonList(csys03si);
  }

  public CCFC31SO retrieveCriminalHistory(CCFC31SI ccfc31si) throws ServiceException {
    return retrieveCriminalHistory.retrieveCriminalHistory(ccfc31si);
  }

  public CINV23SO retrieveExternalDocumentation(CINV23SI cinv23si) throws ServiceException {
    return retrieveExternalDocumentation.retrieveExternalDocumentation(cinv23si);
  }

  public ExternalDocumentationSO displayExtDoc(int idExtDoc) throws ServiceException {
    return retrieveExternalDocumentation.displayExtDoc(idExtDoc);
  }

  public CFAD32SO retrieveFAHomeMemberTraining(CFAD32SI cfad32si) throws ServiceException {
    return retrieveFAHomeMemberTraining.retrieveFAHomeMemberTraining(cfad32si);
  }

  public ProtectiveServiceAlertRetrieveSO retrieveProtectiveServiceAlert(ProtectiveServiceAlertRetrieveSI psaSI)
                                                                                                                throws ServiceException {
    return retrieveProtectiveServiceAlert.retrieveProtectiveServiceAlert(psaSI);
  }

  public CCMN50SO findTaskListEvents(CCMN50SI ccmn50si) throws ServiceException {
    return retrieveTaskList.findTaskListEvents(ccmn50si);
  }

  public UnitHierarchyRetrieveSO retrieveUnitHierarchy(UnitHierarchyRetrieveSI unitHierarchyRetrieveSI)
                                                                                                       throws ServiceException {
    return retrieveUnitHierarchy.retrieveUnitHierarchy(unitHierarchyRetrieveSI);
  }

  public int saveContactRule(SaveContactRuleSI saveContactRuleSI) throws ServiceException {
    return saveContactRule.saveContactRule(saveContactRuleSI);
  }
  
  public ContactStandardsSaveSO saveContactStandards(ContactStandardsRetrieveSO contactStandardsRetrieveSO) throws ServiceException {
    return saveContactStandards.saveContactStandards(contactStandardsRetrieveSO);
  }
  
  public CINV22SO saveExternalDocumentation(CINV22SI cinv22si, boolean isUploadFile, ExternalDocumentationSI extDocSI)
                                                                                                                      throws ServiceException {
    return saveExternalDocumentation.saveExternalDocumentation(cinv22si, isUploadFile, extDocSI);
  }

  public String uploadDocumentToUCM(UCMDataObject ucmData) {
	  return saveExternalDocumentation.uploadDocumentToUCM(ucmData);
  }

  public ProtectiveServiceAlertSaveSO saveProtectiveServiceAlert(ProtectiveServiceAlertSaveSI psaSaveSI)
                                                                                                        throws ServiceException {
    return saveProtectiveServiceAlert.saveProtectiveServiceAlert(psaSaveSI);
  }

  public Integer retrieveDocumentTemplate(DocumentTemplateSI documentTemplateSI) throws ServiceException {
    return retrieveDocumentTemplate.retrieveDocumentTemplate(documentTemplateSI);
  }
  
  public RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesList(RetrieveFacAgencyHomesListSI retrieveFacAgencyHomesListSI) 
                                                                                  throws ServiceException {
    return retrieveFacAgencyHomesList.retrieveFacAgencyHomesList(retrieveFacAgencyHomesListSI);
  }
  
  public RetrieveVendorStaffListSO retrieveVendorList(RetrieveVendorStaffListSI retrieveVendorStaffListSI) 
                                                                                 throws ServiceException {
   return retrieveVendorStaffList.retrieveVendorList(retrieveVendorStaffListSI);
}

  public CSYS08SO addPortalContactDetail(CSYS08SI csys08si, Integer idPortalUser, Integer idResource)
                                                                                                          throws ServiceException {
    return addPortalContactDetail.addPortalContactDetail(csys08si, idPortalUser, idResource);
  }
  
  public boolean validateContactDate(ValidateContactDateSI validateContactDateSI) throws ServiceException {
    return validateContactDate.validateContactDate(validateContactDateSI);
  }
  
  public int syncContactRule (ContactStandardsRetrieveSI contactStandardsRetrieveSI) throws ServiceException {
    return syncContactRule.syncContactRule(contactStandardsRetrieveSI);
   }
  
  public void syncFaPersonDetailRecordsCheck (int idRecCheckPerson) throws ServiceException {
    syncFaPersonDetailRecordsCheck.syncFaPersonDetailRecordsCheck(idRecCheckPerson);
  }
  
  public void syncFaPersonDetailHealthDetail (int idPerson) throws ServiceException {
    syncFaPersonDetailHealthDetail.syncFaPersonDetailHealthDetail(idPerson);
  }
  
  public boolean isUserDeputyPolicyCountyDrt(int idPerson, int idStage )throws ServiceException {
    return isUserDeputyPolicyCountyDrt.isUserDeputyPolicyCountyDrt(idPerson, idStage);
  }
  
  public boolean isUserCountyDirector(int idPerson, int idStage) {
    return isUserDeputyPolicyCountyDrt.isUserCountyDirector(idPerson, idStage);
    
  }
  
  public boolean hasSecurityClass(int idPerson, String securityClassName) {
    return isUserDeputyPolicyCountyDrt.hasSecurityClass(idPerson, securityClassName);
  }

  public boolean isUserDeputyDirector(int idPerson) {
    return isUserDeputyPolicyCountyDrt.isUserDeputyDirector(idPerson);
  }

  public boolean isUserPolicyUnit(int idPerson) {
    return isUserDeputyPolicyCountyDrt.isUserPolicyUnit(idPerson);
  }
  
  public List<Integer> getStateOfficeResourceDeveloperList() {
    return isUserDeputyPolicyCountyDrt.getStateOfficeResourceDeveloperList();
  }
  public Integer getCountyDirector(int idStage, String unitNumber) {
    return isUserDeputyPolicyCountyDrt.getCountyDirector(idStage, unitNumber);
  }
  
  protected void onEjbCreate() throws CreateException {
    addPortalContactDetail = getService(AddPortalContactDetail.class);
    checkIfMaltreatmentInCare = getService(CheckIfMaltreatmentInCare.class);
    checkIfRemovalPriorToAllegIncident = getService(CheckIfRemovalPriorToAllegIncident.class);
    contactDetailRetrieve = getService(ContactDetailRetrieve.class);
    contactDetailSave = getService(ContactDetailSave.class);
    contactListSearch = getService(ContactListSearch.class);
    createContactStandardsSummary = getService(CreateContactStandardsSummary.class);
    deleteContactStandards = getService(DeleteContactStandards.class);
    determineIfPptDocumented = getService(DetermineIfPptDocumented.class);
    determineWhichApprover = getService(DetermineWhichApprover.class);
    prepopulateContactStandards = getService(PrepopulateContactStandards.class);
    retrieveApprovers = getService(RetrieveApprovers.class);
    retrieveContactSearchPersonList = getService(RetrieveContactSearchPersonList.class);
    retrieveCriminalHistory = getService(RetrieveCriminalHistory.class);
    retrieveExternalDocumentation = getService(RetrieveExternalDocumentation.class);
    retrieveFAHomeMemberTraining = getService(RetrieveFAHomeMemberTraining.class);
    retrieveContactStandards = getService(RetrieveContactStandards.class);
    retrieveProtectiveServiceAlert = getService(RetrieveProtectiveServiceAlert.class);
    retrieveTaskList = getService(RetrieveTaskList.class);
    retrieveUnitHierarchy = getService(RetrieveUnitHierarchy.class);
    saveExternalDocumentation = getService(SaveExternalDocumentation.class);
    saveContactRule = getService(SaveContactRule.class);
    saveContactStandards = getService(SaveContactStandards.class);
    saveProtectiveServiceAlert = getService(SaveProtectiveServiceAlert.class);
    checkIfUserHasRight = getService(CheckIfUserHasRight.class);
    checkIfUserWasEverAssigned = getService(CheckIfUserWasEverAssigned.class);
    retrieveDocumentTemplate = getService(RetrieveDocumentTemplate.class);
    retrieveFacAgencyHomesList = getService(RetrieveFacAgencyHomesList.class);
    retrieveVendorStaffList = getService(RetrieveVendorStaffList.class);
    validateContactDate = getService(ValidateContactDate.class);
    syncContactRule = getService(SyncContactRule.class);
    syncFaPersonDetailRecordsCheck = getService(SyncFaPersonDetailRecordsCheck.class);
    syncFaPersonDetailHealthDetail = getService(SyncFaPersonDetailHealthDetail.class);
    isUserDeputyPolicyCountyDrt = getService(IsUserDeputyPolicyCountyDrt.class);
    
  }

}
