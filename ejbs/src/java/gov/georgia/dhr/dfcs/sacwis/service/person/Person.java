/**
 * Created on Jun 28, 2006 at 10:58:45 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;

public interface Person extends SlsbFacade, PersonMergeValidation, RetrieveDiligentSearch,
                       RetrieveCitizenshipIdentity, RetrieveEducationalHistory, RetrieveExamDetail,
                       RetrieveFAPersonDetail, RetrieveIncomeAndResources, RetrieveMedication, RetrieveName,
                       RetrieveOnCallDetail, RetrievePerson, RetrievePersonAddressList, RetrievePersonDetail,
                       RetrievePersonDTL, RetrievePersonIdentifiers, RetrievePersonList, RetrievePersonMerge,
                       RetrievePersonSearch, RetrievePhoneListDetail, RetrieveRecordsCheck, RetrieveUnitDetail,
                       RetrieveYouthDetail, RetrieveYouthReportDetail, SaveAddressListDetail, SaveCitizenshipIdentity,
                       SaveCriminalHistory, SaveDiligentSearch, SaveEducationalHistory, SaveExamDetail,
                       SaveFAPersonDetail, SaveIncomeAndResources, SaveMedication, SaveName, SavePersonCharacteristics,
                       SavePersonDetail, SavePersonDTL, SavePersonIdentifiers, SavePersonMerge,
                       SavePersonSearchIndicator, SavePhoneListDetail, SavePreservice, SaveRecordsCheck,
                       SaveStagePersonLink, SaveYouthDetail, SaveYouthReportDetail, RetrieveCollegeEntranceExam,
                       SaveCollegeEntranceExam, SaveIncomeResourceOutbound, RetrievePRNUnknownIfMmbrOfPKHsehold,
                       RetrievePortalChildDetail, CheckIfPersonViewSearch, CheckIfRecordsCheckCompleted,
                       RetrieveStagePersonLink, RetrieveRecordsCheckSummary, SaveRecordsCheckSummary, 
                       CheckViewSearchForRecordsCheckSummary {
}
