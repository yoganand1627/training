/**
 * Created on Jun 28, 2006 at 9:41:48 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;

public interface Common
        extends SlsbFacade, CheckIfMaltreatmentInCare, CheckIfRemovalPriorToAllegIncident, ContactDetailRetrieve, ContactDetailSave, 
                ContactListSearch, CreateContactStandardsSummary, DeleteContactStandards, DetermineIfPptDocumented, DetermineWhichApprover, 
                PrepopulateContactStandards,  RetrieveApprovers, RetrieveContactSearchPersonList, RetrieveCriminalHistory, 
                RetrieveExternalDocumentation, RetrieveFAHomeMemberTraining, RetrieveProtectiveServiceAlert, RetrieveTaskList, 
                RetrieveUnitHierarchy, SaveExternalDocumentation, SaveProtectiveServiceAlert, CheckIfUserHasRight, RetrieveDocumentTemplate, 
                CheckIfUserWasEverAssigned, RetrieveFacAgencyHomesList, RetrieveVendorStaffList, AddPortalContactDetail, 
                RetrieveContactStandards, SaveContactStandards, SyncContactRule, SaveContactRule, ValidateContactDate,
                SyncFaPersonDetailRecordsCheck, SyncFaPersonDetailHealthDetail, IsUserDeputyPolicyCountyDrt {
}
