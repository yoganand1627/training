/**
 * Created on Jun 28, 2006 at 11:20:23 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;

public interface Resource
        extends SaveResourceUpdateResponse, SlsbFacade, Caretaker, RetrieveAreaServed, RetrieveCloseReopenFAHome, RetrieveFacilityDetail,
                RetrieveFacilityPlacementLog, RetrieveFAHomeHistory, DeleteResourceHistory,RetrieveHomeApplicant, RetrieveHomeDemographics, RetrieveHomeLicense,
                RetrieveResourceCharacteristics, RetrieveResourceDetail, RetrieveResourceHistory, RetrieveResourceName,
                RetrieveSubcontractorList, SaveAreaServed, SaveFacilityDetail, CheckHomeNameAddressExists, CheckInconsistentMaritalStatus,
                CheckIfHomeHasActivePlacements, SaveFAHomeCloseReopen, SaveFAHomeSupervisor, SaveHomeApplicant, SaveHomeDemographics,
                SaveHomeLicense, SaveResourceCharacteristics, SaveResourceDetail, SaveResourceHistory, SaveSubcontractorList,
                UpdateFAResource, RetrievePlacementReferralLog, RetrievePlacementReferralDetail, SavePlacementReferralDetail,
                SaveCaretakerDetail, RetrieveCaretakerInformation, RetrieveORSResourceDetail, UpdateORSResource, RetrieveResourceHouseholdMembers,
                SyncResourceHhMbrsFaPersonDtl, RetrieveHomeStatusLastApproval, RetrieveProviderAllgtnHistory, CheckForKennyAReqs {
}