/**
 * Created on Jun 21, 2006 at 4:29:32 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.service.document.RetrieveDocuments;
import gov.georgia.dhr.dfcs.sacwis.structs.document.GetDocumentsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.document.GetDocumentsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC41SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC43SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC51UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN85SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN86SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN97SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB67SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodeDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodesTableDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntakeProgressionStatusSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvalidateApprovalSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveInitialUnitBeforeBecomingOwnParentSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveStageVerifiedListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageReopenRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageReopenSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateLoginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC41SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC51UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN47SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN49SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN86SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN88SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN97SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH7SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodeTypesRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;

import java.util.List;

import javax.ejb.CreateException;

@SuppressWarnings("serial")
public class AdminBean extends BaseSpringStatelessSessionBean implements Admin {

  private CalculateCaseRetention calculateCaseRetention;
  private CheckStageEventStatus checkStageEventStatus;
  private CloseOpenStage closeOpenStage;
  private CloseStageCase closeStageCase;
  private DeleteTodo deleteTodo;
  private InvalidateApproval invalidateApproval;
  private InvalidateAndPostEvent invalidateAndPostEvent;
  private PostEvent postEvent;
  private RetrieveAdminReview retrieveAdminReview;
  private RetrieveApprovalStatus retrieveApprovalStatus;
  private RetrieveAssign retrieveAssign;
  private RetrieveCaseFileManagement retrieveCaseFileManagement;
  private RetrieveCaseList retrieveCaseList;
  private RetrieveCaseMergeList retrieveCaseMergeList;
  private RetrieveCaseMergeVerify retrieveCaseMergeVerify;
  private RetrieveCaseSummary retrieveCaseSummary;
  private RetrieveCaseTodo retrieveCaseTodo;
  private RetrieveChangeCaseName retrieveChangeCaseName;
  private RetrieveChildUnitList retrieveChildUnitList;
  private RetrieveClosureEvent retrieveClosureEvent;
  private RetrieveDesignees retrieveDesignees;
  private RetrieveEmployeeDetail retrieveEmployeeDetail;
  private RetrieveEventList retrieveEventList;
  private RetrieveIntake retrieveIntake;
  private RetrieveOfficeCity retrieveOfficeCity;
  private RetrieveOfficeName retrieveOfficeName;
  private RetrieveOnCallListCounty retrieveOnCallListCounty;
  private RetrieveOnCallList retrieveOnCallList;
  private RetrieveOnCallPhone retrieveOnCallPhone;
  private RetrieveRecordsRetention retrieveRecordsRetention;
  private RetrieveSpecialHandling retrieveSpecialHandling;
  private RetrieveStaffList retrieveStaffList;
  private RetrieveStaffSecurity retrieveStaffSecurity;
  private RetrieveStaffTodo retrieveStaffTodo;
  private RetrieveStageList retrieveStageList;
  private RetrieveStageProgression retrieveStageProgression;
  private RetrieveStageReopen retrieveStageReopen;
  private RetrieveUnitID retrieveUnitID;
  private RetrieveUnitList retrieveUnitList;
  private RetrieveUnitSummary retrieveUnitSummary;
  private RetrieveUnitSupervisor retrieveUnitSupervisor;
  private RetrieveUserProfile retrieveUserProfile;
  private RetrieveWorkload retrieveWorkload;
  private SaveAdminReview saveAdminReview;
  private SaveApproval saveApproval;
  private SaveAssign saveAssign;
  private SaveAutoAdoStage saveAutoAdoStage;
  private SaveCaseFileManagement saveCaseFileManagement;
  private SaveCaseMerge saveCaseMerge;
  private SaveCaseName saveCaseName;
  private SaveCounty saveCounty;
  private SaveCreateAdminReview saveCreateAdminReview;
  private SaveDesignees saveDesignees;
  private SaveEmployeeDetail saveEmployeeDetail;
  private SaveOnCallDetail saveOnCallDetail;
  private SaveOnCallList saveOnCallList;
  private SaveRecordsRetention saveRecordsRetention;
  private SaveReopenStage saveReopenStage;
  private SaveSpecialHandling saveSpecialHandling;
  private SaveStaffSecurity saveStaffSecurity;
  private SaveStageProgression saveStageProgression;
  private SaveStageReopen saveStageReopen;
  private SaveTodo saveTodo;
  private SaveUnitDetail saveUnitDetail;
  private StageClosureEditChecks stageClosureEditChecks;
  private TodoCommonFunction todoCommonFunction;
  private UnitAccess unitAccess;
  private SaveSummaryVerifiedStage saveSummaryVerifiedStage;
  private SaveSummaryRedFlagCaseStage saveSummaryRedFlagCaseStage;
  private SaveNewUnitToBecomeItsOwnParentUnit saveNewUnitToBecomeItsOwnParentUnit;
  private CheckIntakeProgressionStatus checkIntakeProgressionStatus;
  private RetrieveCodeTypesList retrieveCodeTypesList;
  private RetrieveCodesTableDetail retrieveCodesTableDetail;
  private SaveCodeDetail saveCodeDetail;
  private RetrieveCodeDetail retrieveCodeDetail;
  private SaveAdoFinalized saveAdoFinalized;
  private RetrieveFADStageResource retrieveFADStageResource;
  private SaveStageClosureAlerts saveStageClosureAlerts;
  private ValidateLogin validateLogin;
  private RetrieveVendorStaffDetail retrieveVendorStaffDetail;
  private SaveVendorStaffDetail saveVendorStaffDetail;
  private RetrieveDocuments retrieveDocuments;

  public CCFC51UO recordsRetention(CCFC51UI ccfc51ui) throws ServiceException {
    return calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public CCMN06UO status(CCMN06UI ccmn06ui) throws ServiceException {
    return checkStageEventStatus.status(ccmn06ui);
  }

  public CCMN03UO closeOpenStage(CCMN03UI ccmn03ui) throws ServiceException {
    return closeOpenStage.closeOpenStage(ccmn03ui);
  }

  public CCMN02UO closeStageCase(CCMN02UI ccmn02ui) throws ServiceException {
    return closeStageCase.closeStageCase(ccmn02ui);
  }

  public CCMN97SO deleteTodo(CCMN97SI ccmn97si) throws ServiceException {
    return deleteTodo.deleteTodo(ccmn97si);
  }

  public CCMN05UO invalidateApproval(CCMN05UI ccmn05ui) throws ServiceException {
    return invalidateApproval.invalidateApproval(ccmn05ui);
  }
  public void invalidateAndPostEvent(InvalidateApprovalSI invalidateApprovalsi) throws ServiceException {
     invalidateAndPostEvent.invalidateAndPostEvent(invalidateApprovalsi);
  }

  public CCMN01UO postEvent(CCMN01UI ccmn01ui) throws ServiceException {
    return postEvent.postEvent(ccmn01ui);
  }

  public CCFC43SO retrieveAdminReview(CCFC43SI ccfc43si) throws ServiceException {
    return retrieveAdminReview.retrieveAdminReview(ccfc43si);
  }

  public CCMN34SO retrieveApprovalStatus(CCMN34SI ccmn34si) throws ServiceException {
    return retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
  }

  public CCMN80SO retrieveEmployeeAssignInfo(CCMN80SI ccmn80si) throws ServiceException {
    return retrieveAssign.retrieveEmployeeAssignInfo(ccmn80si);
  }

  public CCFC21SO retrieveCaseFileManagement(CCFC21SI ccfc21si) throws ServiceException {
    return retrieveCaseFileManagement.retrieveCaseFileManagement(ccfc21si);
  }

  public CCMN20SO findCaseListInformation(CCMN20SI ccmn20si) throws ServiceException {
    return retrieveCaseList.findCaseListInformation(ccmn20si);
  }

  public CCFC39SO findCaseMergeList(CCFC39SI ccfc39si) throws ServiceException {
    return retrieveCaseMergeList.findCaseMergeList(ccfc39si);
  }

  public CCFC40SO findCaseMergeVerify(CCFC40SI ccfc40si) throws ServiceException {
    return retrieveCaseMergeVerify.findCaseMergeVerify(ccfc40si);
  }

  public CCMN37SO retrieveCaseSummary(CCMN37SI ccmn37si) throws ServiceException {
    return retrieveCaseSummary.retrieveCaseSummary(ccmn37si);
  }

  public CCMN12SO retrieveCaseTodo(CCMN12SI ccmn12si) throws ServiceException {
    return retrieveCaseTodo.retrieveCaseTodo(ccmn12si);
  }

  public CCMN85SO findAllPrinciplesAndFacility(CCMN85SI ccmn85si) throws ServiceException {
    return retrieveChangeCaseName.findAllPrinciplesAndFacility(ccmn85si);
  }

  public CSUB67SO retrieveClosureEvent(CSUB67SI csub67si) throws ServiceException {
    return retrieveClosureEvent.retrieveClosureEvent(csub67si);
  }

  public CARC16SO retrieveDesigneeAssignments(CARC16SI carc16si) {
    return retrieveDesignees.retrieveDesigneeAssignments(carc16si);
  }

  public CCMN04SO retrieveEmployeeDetail(CCMN04SI ccmn04si) throws ServiceException {
    return retrieveEmployeeDetail.retrieveEmployeeDetail(ccmn04si);
  }

  public CCMN33SO retrieveEventList(CCMN33SI ccmn33si) throws ServiceException {
    return retrieveEventList.retrieveEventList(ccmn33si);
  }

  public CCMN13SO findIntakeInformation(CCMN13SI ccmn13si) throws ServiceException {
    return retrieveIntake.findIntakeInformation(ccmn13si);
  }

  public CCMN87SO findCountiesLinkedToCity(CCMN87SI ccmn87si) {
    return retrieveOfficeCity.findCountiesLinkedToCity(ccmn87si);
  }

  public CCMN40SO retrieveOfficeName(CCMN40SI ccmn40si) throws ServiceException {
    return retrieveOfficeName.retrieveOfficeName(ccmn40si);
  }

  public CCMNH7SO retrieveOnCallListCounty(CCMNH7SI input) {
    return retrieveOnCallListCounty.retrieveOnCallListCounty(input);
  }

  public CCMN06SO findOnCallList(CCMN06SI ccmn06si) throws ServiceException {
    return retrieveOnCallList.findOnCallList(ccmn06si);
  }

  public CCMNA1SO retrieveOnCallPhone(CCMNA1SI input) {
    return retrieveOnCallPhone.retrieveOnCallPhone(input);
  }

  public CCFC19SO findRecordsRetention(CCFC19SI ccfc19si) throws ServiceException {
    return retrieveRecordsRetention.findRecordsRetention(ccfc19si);
  }

  public CCMN81SO findCapsCase(CCMN81SI ccmn81si) throws ServiceException {
    return retrieveSpecialHandling.findCapsCase(ccmn81si);
  }

  public CCMN03SO retrieveStaffList(CCMN03SI ccmn03si) throws ServiceException {
    return retrieveStaffList.retrieveStaffList(ccmn03si);
  }

  public CARC14SO findEmployeeSecurityInformation(CARC14SI carc14si) throws ServiceException {
    return retrieveStaffSecurity.findEmployeeSecurityInformation(carc14si);
  }

  public CCMN11SO retrieveStaffTodo(CCMN11SI ccmn11si) throws ServiceException {
    return retrieveStaffTodo.retrieveStaffTodo(ccmn11si);
  }

  public CCMN32SO retrieveStageList(CCMN32SI ccmn32si) throws ServiceException {
    return retrieveStageList.retrieveStageList(ccmn32si);
  }

  public CCMN39SO retrieveStageProgression(CCMN39SI ccmn39si) {
    return retrieveStageProgression.retrieveStageProgression(ccmn39si);
  }
  
  public StageReopenRetrieveSO retrieveStageReopen(StageReopenRetrieveSI stageReopenRetrieveSI) {
    return retrieveStageReopen.retrieveStageReopen(stageReopenRetrieveSI);
  }

  public CCMN47SO retrieveUnitID(CCMN47SI ccmn47si) throws ServiceException {
    return retrieveUnitID.retrieveUnitID(ccmn47si);
  }

  public CCMN24SO retrieveUnitList(CCMN24SI ccmn24si) throws ServiceException {
    return retrieveUnitList.retrieveUnitList(ccmn24si);
  }

  public CCMN29SO findUnitSummary(CCMN29SI ccmn29si) throws ServiceException {
    return retrieveUnitSummary.findUnitSummary(ccmn29si);
  }

  public CCMN08SO findUnitSupervisorName(CCMN08SI ccmn08si) throws ServiceException {
    return retrieveUnitSupervisor.findUnitSupervisorName(ccmn08si);
  }

  public CARC01SO retrieveUserProfile(CARC01SI carc01si) throws ServiceException {
    return retrieveUserProfile.retrieveUserProfile(carc01si);
  }

  public CCMN14SO findWorkloadInformation(CCMN14SI ccmn14si) throws ServiceException {
    return retrieveWorkload.findWorkloadInformation(ccmn14si);
  }

  public CCFC44SO saveAdminReview(CCFC44SI ccfc44si) throws ServiceException {
    return saveAdminReview.saveAdminReview(ccfc44si);
  }

  public CCMN35SO saveApproval(CCMN35SI ccmn35si) throws ServiceException {
    return saveApproval.saveApproval(ccmn35si);
  }

  public CCMN25SO saveAssign(CCMN25SI ccmn25si) throws ServiceException {
    return saveAssign.saveAssign(ccmn25si);
  }
  
  public CCMN35SO saveAutoAdoStage(CCMN35SI ccmn35si) throws ServiceException {
    return saveAutoAdoStage.saveAutoAdoStage(ccmn35si);
  }
  
  public CCFC22SO saveCaseFileManagement(CCFC22SI ccfc22si) throws ServiceException {
    return saveCaseFileManagement.saveCaseFileManagement(ccfc22si);
  }

  public CCFC41SO saveCaseMerge(CCFC41SI ccfc41si) throws ServiceException {
    return saveCaseMerge.saveCaseMerge(ccfc41si);
  }

  public CCMN86SO saveCaseNameInformation(CCMN86SI ccmn86si) throws ServiceException {
    return saveCaseName.saveCaseNameInformation(ccmn86si);
  }

  public CCMN27SO updateStageCountyCaseCounty(CCMN27SI ccmn27si) throws ServiceException {
    return saveCounty.updateStageCountyCaseCounty(ccmn27si);
  }

  public CCFC42SO saveCreateAdminReview(CCFC42SI ccfc42si) throws ServiceException {
    return saveCreateAdminReview.saveCreateAdminReview(ccfc42si);
  }

  public CARC17SO saveDesigneeAssignments(CARC17SI carc17si) throws ServiceException {
    return saveDesignees.saveDesigneeAssignments(carc17si);
  }

  public CCMN05SO saveEmployeeDetail(CCMN05SI ccmn05si) throws ServiceException {
    return saveEmployeeDetail.saveEmployeeDetail(ccmn05si);
  }

  public CCMN10SO saveOnCallDetailInformation(CCMN10SI ccmn10si) throws ServiceException {
    return saveOnCallDetail.saveOnCallDetailInformation(ccmn10si);
  }

  public CCMN07SO saveOnCallListInformation(CCMN07SI ccmn07si) throws ServiceException {
    return saveOnCallList.saveOnCallListInformation(ccmn07si);
  }

  public CCFC20SO saveRecordsRetention(CCFC20SI ccfc20si) throws ServiceException {
    return saveRecordsRetention.saveRecordsRetention(ccfc20si);
  }

  public CCMN49SO saveReopenStage(CCMN49SI ccmn49si) throws ServiceException {
    return saveReopenStage.saveReopenStage(ccmn49si);
  }

  public CCMN82SO updateCapsCase(CCMN82SI ccmn82si) throws ServiceException {
    return saveSpecialHandling.updateCapsCase(ccmn82si);
  }

  public CARC18SO saveStaffSecurityInformation(CARC18SI carc18si) throws ServiceException {
    return saveStaffSecurity.saveStaffSecurityInformation(carc18si);
  }

  public CCMN88SO saveStageProgression(CCMN88SI ccmn88si) throws ServiceException {
    return saveStageProgression.saveStageProgression(ccmn88si);
  }
  
  public StageReopenSaveSO saveStageReopen(StageReopenSaveSI stageReopenSaveSI) throws ServiceException {
    return saveStageReopen.saveStageReopen(stageReopenSaveSI);
  }

  public CCMN19SO saveTodoInformation(CCMN19SI ccmn19si) throws ServiceException {
    return saveTodo.saveTodoInformation(ccmn19si);
  }
  
  public CINV05SO saveTodoAlert(TodoAlertSaveSI todoalertsavesi) throws ServiceException {
    return saveTodo.saveTodoAlert(todoalertsavesi);
  }

  public CCMN22SO saveUnitInformation(CCMN22SI ccmn22si) throws ServiceException {
    return saveUnitDetail.saveUnitInformation(ccmn22si);
  }

  public CSUB68SO performEditChecks(CSUB68SI csub68si) throws ServiceException {
    return stageClosureEditChecks.performEditChecks(csub68si);
  }

  public CSUB40UO audTodo(CSUB40UI csub40ui) throws ServiceException {
    return todoCommonFunction.audTodo(csub40ui);
  }

  public CCMN04UO checkForPersonWithUnitAccess(CCMN04UI ccmn04ui) {
    return unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
  }
  
  public CCMN24SO retrieveChildUnitList(CCMN24SI ccmn24si) {
    return retrieveChildUnitList.retrieveChildUnitList(ccmn24si);
  }
  
  public void updateSummaryVerifiedStages(SaveStageVerifiedListSI saveStageVerifiedListSI){
    saveSummaryVerifiedStage.updateSummaryVerifiedStages(saveStageVerifiedListSI);
  }
  
  public void updateSummaryRedFlagCaseStages(SaveStageVerifiedListSI saveStageVerifiedListSI) {
    saveSummaryRedFlagCaseStage.updateSummaryRedFlagCaseStages(saveStageVerifiedListSI);
  }

  public int saveInitialUnitBeforeBecomingOwnParent(SaveInitialUnitBeforeBecomingOwnParentSI saveInitialUnitBeforeBecomingOwnParentSI){
    return saveNewUnitToBecomeItsOwnParentUnit.saveInitialUnitBeforeBecomingOwnParent(saveInitialUnitBeforeBecomingOwnParentSI); 
  }
  
  public boolean checkIntakeProgressionStatus(IntakeProgressionStatusSI intakeProgressionStatusSI) throws ServiceException {
    return checkIntakeProgressionStatus.checkIntakeProgressionStatus(intakeProgressionStatusSI);
  }
  
  public List<CodeTypesRetrieveSO> retrieveCodeTypesList() throws ServiceException {
    return retrieveCodeTypesList.retrieveCodeTypesList();
  }
  
  public CodesTableDetailRetrieveSO retrieveCodesTableDetail(CodesTableDetailRetrieveSI codesTblDtlRtrvSI) throws ServiceException {
    return retrieveCodesTableDetail.retrieveCodesTableDetail(codesTblDtlRtrvSI);
  }
  
  public void saveCodeDetail(CodeDetailSaveSI codeDetailSaveSI) throws ServiceException {
     saveCodeDetail.saveCodeDetail(codeDetailSaveSI);
  }
  
  public CodesTableDetailRetrieveSO retrieveCodeDetail(CodesTableDetailRetrieveSI codesTblDtlRtrvSI) throws ServiceException {
    return retrieveCodeDetail.retrieveCodeDetail(codesTblDtlRtrvSI);
  }
  
  public CSUB68SO saveAdoFinalized(CSUB68SI csub68si) throws ServiceException {
    return saveAdoFinalized.saveAdoFinalized(csub68si);
  }
  
  public String retrieveFADStageResourceCategory(int idStage) throws ServiceException {
    return retrieveFADStageResource.retrieveFADStageResourceCategory(idStage);
  }
  
  public void saveStageClosureAlerts(CCMN35SI ccmn35si){
    saveStageClosureAlerts.saveStageClosureAlerts(ccmn35si);
  }
  
  public ValidateLoginSO validateLogin(ValidateLoginSI validateLoginSI){
    return validateLogin.validateLogin(validateLoginSI);
  }
  
  public RetrieveVendorStaffDetailSO retrieveVendorStaffDetail(RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI){
    return retrieveVendorStaffDetail.retrieveVendorStaffDetail(retrieveVendorStaffDetailSI);
  }
  
  public SaveVendorStaffDetailSO saveVendorStaffDetail(SaveVendorStaffDetailSI saveVendorStaffDetailSI){
    return saveVendorStaffDetail.saveVendorStaffDetail(saveVendorStaffDetailSI);
  }
  

  public GetDocumentsSO retrieveDocuments(GetDocumentsSI getDocumentsSI) {
    return retrieveDocuments.retrieveDocuments(getDocumentsSI);
  }

  protected void onEjbCreate() throws CreateException {
    this.calculateCaseRetention = getService(CalculateCaseRetention.class);
    this.checkStageEventStatus = getService(CheckStageEventStatus.class);
    this.closeOpenStage = getService(CloseOpenStage.class);
    this.closeStageCase = getService(CloseStageCase.class);
    this.deleteTodo = getService(DeleteTodo.class);
    this.invalidateApproval = getService(InvalidateApproval.class);
    this.invalidateAndPostEvent = getService(InvalidateAndPostEvent.class);
    this.postEvent = getService(PostEvent.class);
    this.retrieveAdminReview = getService(RetrieveAdminReview.class);
    this.retrieveApprovalStatus = getService(RetrieveApprovalStatus.class);
    this.retrieveAssign = getService(RetrieveAssign.class);
    this.retrieveCaseFileManagement = getService(RetrieveCaseFileManagement.class);
    this.retrieveCaseList = getService(RetrieveCaseList.class);
    this.retrieveCaseMergeList = getService(RetrieveCaseMergeList.class);
    this.retrieveCaseMergeVerify = getService(RetrieveCaseMergeVerify.class);
    this.retrieveCaseSummary = getService(RetrieveCaseSummary.class);
    this.retrieveCaseTodo = getService(RetrieveCaseTodo.class);
    this.retrieveChangeCaseName = getService(RetrieveChangeCaseName.class);
    this.retrieveChildUnitList = getService(RetrieveChildUnitList.class);
    this.retrieveClosureEvent = getService(RetrieveClosureEvent.class);
    this.retrieveDesignees = getService(RetrieveDesignees.class);
    this.retrieveEmployeeDetail = getService(RetrieveEmployeeDetail.class);
    this.retrieveEventList = getService(RetrieveEventList.class);
    this.retrieveIntake = getService(RetrieveIntake.class);
    this.retrieveOfficeCity = getService(RetrieveOfficeCity.class);
    this.retrieveOfficeName = getService(RetrieveOfficeName.class);
    this.retrieveOnCallListCounty = getService(RetrieveOnCallListCounty.class);
    this.retrieveOnCallList = getService(RetrieveOnCallList.class);
    this.retrieveOnCallPhone = getService(RetrieveOnCallPhone.class);
    this.retrieveRecordsRetention = getService(RetrieveRecordsRetention.class);
    this.retrieveSpecialHandling = getService(RetrieveSpecialHandling.class);
    this.retrieveStaffList = getService(RetrieveStaffList.class);
    this.retrieveStaffSecurity = getService(RetrieveStaffSecurity.class);
    this.retrieveStaffTodo = getService(RetrieveStaffTodo.class);
    this.retrieveStageList = getService(RetrieveStageList.class);
    this.retrieveStageProgression = getService(RetrieveStageProgression.class);
    this.retrieveStageReopen = getService(RetrieveStageReopen.class);
    this.retrieveUnitID = getService(RetrieveUnitID.class);
    this.retrieveUnitList = getService(RetrieveUnitList.class);
    this.retrieveUnitSummary = getService(RetrieveUnitSummary.class);
    this.retrieveUnitSupervisor = getService(RetrieveUnitSupervisor.class);
    this.retrieveUserProfile = getService(RetrieveUserProfile.class);
    this.retrieveWorkload = getService(RetrieveWorkload.class);
    this.saveAdminReview = getService(SaveAdminReview.class);
    this.saveApproval = getService(SaveApproval.class);
    this.saveAssign = getService(SaveAssign.class);
    this.saveAutoAdoStage = getService(SaveAutoAdoStage.class);
    this.saveCaseFileManagement = getService(SaveCaseFileManagement.class);
    this.saveCaseMerge = getService(SaveCaseMerge.class);
    this.saveCaseName = getService(SaveCaseName.class);
    this.saveCounty = getService(SaveCounty.class);
    this.saveCreateAdminReview = getService(SaveCreateAdminReview.class);
    this.saveDesignees = getService(SaveDesignees.class);
    this.saveEmployeeDetail = getService(SaveEmployeeDetail.class);
    this.saveOnCallDetail = getService(SaveOnCallDetail.class);
    this.saveOnCallList = getService(SaveOnCallList.class);
    this.saveRecordsRetention = getService(SaveRecordsRetention.class);
    this.saveReopenStage = getService(SaveReopenStage.class);
    this.saveSpecialHandling = getService(SaveSpecialHandling.class);
    this.saveStaffSecurity = getService(SaveStaffSecurity.class);
    this.saveStageProgression = getService(SaveStageProgression.class);
    this.saveStageReopen = getService(SaveStageReopen.class);
    this.saveSummaryVerifiedStage = getService(SaveSummaryVerifiedStage.class);
    this.saveTodo = getService(SaveTodo.class);
    this.saveUnitDetail = getService(SaveUnitDetail.class);
    this.stageClosureEditChecks = getService(StageClosureEditChecks.class);
    this.todoCommonFunction = getService(TodoCommonFunction.class);
    this.unitAccess = getService(UnitAccess.class);
    this.saveNewUnitToBecomeItsOwnParentUnit = getService(SaveNewUnitToBecomeItsOwnParentUnit.class);
    this.checkIntakeProgressionStatus = getService(CheckIntakeProgressionStatus.class);
    this.retrieveCodeTypesList = getService(RetrieveCodeTypesList.class);
    this.retrieveCodesTableDetail = getService(RetrieveCodesTableDetail.class);
    this.saveCodeDetail = getService(SaveCodeDetail.class);
    this.retrieveCodeDetail = getService(RetrieveCodeDetail.class);
    this.saveAdoFinalized = getService(SaveAdoFinalized.class); 
    this.retrieveFADStageResource = getService(RetrieveFADStageResource.class); 
    this.saveStageClosureAlerts = getService(SaveStageClosureAlerts.class);
    this.validateLogin = getService(ValidateLogin.class);
    this.retrieveVendorStaffDetail = getService(RetrieveVendorStaffDetail.class);
    this.saveVendorStaffDetail = getService(SaveVendorStaffDetail.class);
    this.saveSummaryRedFlagCaseStage = getService(SaveSummaryRedFlagCaseStage.class);
    this.retrieveDocuments = getService(RetrieveDocuments.class);
  }
}
