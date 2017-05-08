/**
 * Created on Jun 22, 2006 at 12:43:59 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;
import gov.georgia.dhr.dfcs.sacwis.service.document.RetrieveDocuments;

public interface Admin extends SlsbFacade, CalculateCaseRetention, CheckStageEventStatus, CloseOpenStage,
                      CloseStageCase, DeleteTodo, InvalidateApproval, InvalidateAndPostEvent, PostEvent,
                      RetrieveAdminReview, RetrieveApprovalStatus, RetrieveAssign, RetrieveCaseFileManagement,
                      RetrieveCaseList, RetrieveCaseMergeList, RetrieveCaseMergeVerify, RetrieveCaseSummary,
                      RetrieveCaseTodo, RetrieveChangeCaseName, RetrieveChildUnitList, RetrieveClosureEvent,
                      RetrieveDesignees, RetrieveEmployeeDetail, RetrieveEventList, RetrieveIntake, RetrieveOfficeCity,
                      RetrieveOfficeName, RetrieveOnCallListCounty, RetrieveOnCallList, RetrieveOnCallPhone,
                      RetrieveRecordsRetention, RetrieveSpecialHandling, RetrieveStaffList, RetrieveStaffSecurity,
                      RetrieveStaffTodo, RetrieveStageList, RetrieveStageProgression, RetrieveUnitID, RetrieveUnitList,
                      RetrieveUnitSummary, RetrieveUnitSupervisor, RetrieveUserProfile, RetrieveWorkload,
                      SaveAdminReview, SaveApproval, SaveAutoAdoStage, SaveAssign, SaveCaseFileManagement,
                      SaveCaseMerge, SaveCaseName, SaveCounty, SaveCreateAdminReview, SaveDesignees,
                      SaveEmployeeDetail, SaveOnCallDetail, SaveOnCallList, SaveRecordsRetention, SaveReopenStage,
                      SaveSpecialHandling, SaveStaffSecurity, SaveStageProgression, SaveTodo, SaveUnitDetail,
                      StageClosureEditChecks, TodoCommonFunction, UnitAccess, SaveSummaryVerifiedStage,
                      SaveNewUnitToBecomeItsOwnParentUnit, CheckIntakeProgressionStatus, RetrieveCodeTypesList,
                      RetrieveCodesTableDetail, SaveCodeDetail, RetrieveCodeDetail, SaveAdoFinalized, 
                      RetrieveFADStageResource, SaveStageClosureAlerts, RetrieveStageReopen, SaveStageReopen,
                      ValidateLogin, RetrieveVendorStaffDetail, SaveVendorStaffDetail, SaveSummaryRedFlagCaseStage,
                      RetrieveDocuments{

}