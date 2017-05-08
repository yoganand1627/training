package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseBudgetLimitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimit;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * 
 * <pre>
 *               Change History:
 *                Date        User      Description
 *                ----------  --------  --------------------------------------------------
 *               01/07/2010   arege   STGAP00015696: MR-52- User attempts to Save and Submit a Service Authorization with a UAS/Entitlement Code of 512
 *                                    (Excluding 51257 and 51277) and the child is not in an approved adoptive placement
 *               01/08/2010   mxpatel   STGAP00015702: Added code to verify that the approved amount for Non Recurring services on the Adoption Assistance 
 *                                      Application is strictly adhered to by looking to previously approved and paid Assistance Agreements 
 *                                      and Service Authorization before allowing the Case Manager to Save/Mark Complete a new Agreement
 *               02/21/2010   mxpatel   SMS #44052: added code so that 512 can only be added in ADO or PAD stage. 
 *               03/02/2010   mxpatel   SMS #45293:removed the code for validations messages as it is no longer required
 */     

public class SaveServiceAuthorizationImpl extends BaseServiceImpl implements SaveServiceAuthorization {

  private static final String CON2 = "CON002";

  private static final String CON7 = "CON007";

  private CheckStageEventStatus checkStageEventStatus = null;

  private SaveCaseBudgetLimitList saveCaseBudgetLimitList = null;

  private ApproversDAO approversDAO = null;
  
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PlacementDAO placementDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private ComplexServiceAuthorizationDAO complexServiceAuthorizationDAO = null;

  private PostEvent postEvent = null;

  private EventDAO eventDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private TodoDAO todoDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private PersonDAO personDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private CaseBudgetLimitDAO caseBudgetLimitDAO = null;

  private ComplexCaseBudgetLimitDAO complexCaseBudgetLimitDAO = null;
  
  private StageDAO stageDAO = null;
  
  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;
  
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;
  
  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }
  
  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }
  
  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO){
    this.stageDAO = stageDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }
  
  public void setSaveCaseBudgetLimitList(SaveCaseBudgetLimitList saveCaseBudgetLimitList) {
    this.saveCaseBudgetLimitList = saveCaseBudgetLimitList;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setComplexServiceAuthorizationDAO(ComplexServiceAuthorizationDAO complexServiceAuthorizationDAO) {
    this.complexServiceAuthorizationDAO = complexServiceAuthorizationDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setComplexCaseBudgetLimitDAO(ComplexCaseBudgetLimitDAO complexCaseBudgetLimitDAO) {
    this.complexCaseBudgetLimitDAO = complexCaseBudgetLimitDAO;
  }

  public void setCaseBudgetLimitDAO(CaseBudgetLimitDAO caseBudgetLimitDAO) {
    this.caseBudgetLimitDAO = caseBudgetLimitDAO;
  }

  public CCON19SO saveServiceAuthorization(CCON19SI ccon19si) throws ServiceException {
    CCON19SO ccon19so = new CCON19SO();
    ROWCCMN01UIG00 rowccmn01uig00 = ccon19si.getROWCCMN01UIG00();
    int rowccmn01uig00IdEvent = rowccmn01uig00.getUlIdEvent();
    int rowccmn01uig00IdPerson = rowccmn01uig00.getUlIdPerson();
    int rowccmn01uig00IdStage = rowccmn01uig00.getUlIdStage();
    String rowccmn01uig00CdTask = rowccmn01uig00.getSzCdTask();
    String cReqFuncCd = ccon19si.getArchInputStruct().getCReqFuncCd();
    String cdStage = stageDAO.findCdStageByIdStage(rowccmn01uig00IdStage);
    int idCase = ccon19si.getUlIdCase();
    List<Double> amtPendAuthList = new ArrayList<Double>();
    List<String> serviceCodeList = new ArrayList<String>();
    String indAddUpdate = "";
    int waiverId = 0;
    List<Double> amtBudgetedList = new ArrayList<Double>();

    // END Retrieval for Act Plcmt for a given Dt
    // (BEGIN): Common Function: ccmn06u ** Check Stage/Event common function
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(ccon19si.getArchInputStruct());

    ccmn06ui.setUlIdStage(rowccmn01uig00IdStage);

    // CheckStageEventStatus
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);
    int ccon19siIdSvcAuth = ccon19si.getUlIdSvcAuth();
    int idEvent = ccon19si.getUlIdEvent();
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      //Removing the Pending amount from the Budget Limit     
      
      //STGAP00008181 Only updating the Case Budgetlimit if the Status is pending 
      if(CodesTables.CEVTSTAT_PEND.equals(event.getCdEventStatus())){
      CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
      csBdgtSaveSI.setUlIdCase(idCase);
      csBdgtSaveSI.setUlIdEvent(idEvent);
      csBdgtSaveSI.setUlIdSvcAuth(ccon19siIdSvcAuth);
      csBdgtSaveSI.setModeIndicator(CodesTables.CAPPDESG_INVD);
      saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);     
      }
      // caude7d call. Deletes all Service Auth-related data from the database.
      // Here the return value from the delete call is not captured and tested to throw a service exception
      // because in this case a complex delete procedure defined at the database end is called. If the
      // the call is not successful the assumption here is that the database will indicate that.
      serviceAuthorizationDAO.deleteServiceAuthorization(ccon19siIdSvcAuth);
      todoDAO.deleteTodoByIdEvent(ccon19si.getUlIdEvent());
      
      Integer idApproval = approvalEventLinkDAO.findActiveIdApprovalByIdEvent(idEvent);
      if(idApproval != null){
      List<Approvers> approversList = approversDAO.findApproversByIdApproval(idApproval);
      if(approversList == null || approversList.isEmpty()) {
        //-- throw exception?
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      for(Iterator<Approvers> it = approversList.iterator(); it.hasNext();) {
        Approvers approvers = it.next();
        Todo todo = approvers.getTodo();
        if(todo != null && todo.getIdTodo() > 0) {
          todoDAO.deleteTodo(todo);
        }
        approversDAO.updateIdTodoByIdApprovers(approvers.getIdApprovers(), 0);
      }
      }
      
      
      
      
    } else if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
/*      // This code was moved to do the budget update after the save button is click on the todo detail page
      // Budget Limit validation code
      // Begin
      // When the save and submit button on the service auth header page is clicked then the requested amount
      // for each service which has predefined budget limit needs to be validated against the budget limits.
      // If it exceeds the limit an error message is displayed.
      // If the the amount is within the limits and there is no entry for the service code that is being
      // validated in the case budget limit table then a new row is inserted, else the existing row is updated.

      String eventStatus = "";
      if (ccon19si.getROWCCMN01UIG00() != null) {
        eventStatus = ccon19si.getROWCCMN01UIG00().getSzCdEventStatus();
      }
      if (CodesTables.CEVTSTAT_PEND.equals(eventStatus)) {
        int idSvcAuth = ccon19si.getUlIdSvcAuth();
        CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
        csBdgtSaveSI.setUlIdCase(idCase);
        csBdgtSaveSI.setModeIndicator(CodesTables.CEVTSTAT_PEND);
        csBdgtSaveSI.setUlIdSvcAuth(ccon19si.getUlIdSvcAuth());
        saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
      }
      // Budget Limit validation code
      // End
      
      */
      
      //STGAP00015696 MR-52- User attempts to Save and Submit a Service Authorization with a UAS/Entitlement Code of 512 (
      //Excluding 51257 and 51277) and the child is not in an approved adoptive placement
      Date dtCurrentDate = new Date();    
      Placement childInAdoptivePlacement = placementDAO.findPlacementByIdPlcmtChildAndPlcmtAcctPlanned(ccon19si.getUlIdPrimaryClient(), dtCurrentDate);
      if (CodesTables.CSTAGES_PAD.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)) {
        if (CodesTables.CPRGCOD1_512.equals(ccon19si.getSzCdSvcAuthCategory())
            && !(CodesTables.CENTCODE_57.equals(ccon19si.getSzCdSvcAuthService()) || CodesTables.CENTCODE_77
                                                                                                            .equals(ccon19si
                                                                                                                            .getSzCdSvcAuthService()))
            && (childInAdoptivePlacement == null)// Child not in adoptive placement
        ) {
          throw new ServiceException(Messages.MSG_APRV_ADOPT_PLCMT_REQD);
        }
      } else {
        if (CodesTables.CPRGCOD1_512.equals(ccon19si.getSzCdSvcAuthCategory())) {
          if (CodesTables.CPRGCOD1_512.equals(ccon19si.getSzCdSvcAuthCategory())
              && !(CodesTables.CENTCODE_57.equals(ccon19si.getSzCdSvcAuthService()) || CodesTables.CENTCODE_77
                                                                                                              .equals(ccon19si
                                                                                                                              .getSzCdSvcAuthService()))

          ) {
            throw new ServiceException(Messages.MSG_SPEC_SVC_ADO_PAD);
          }
        }
      }

      // Set value of cReqFuncCd based on idEvent
      if (rowccmn01uig00IdEvent == 0) {
        ccon19si.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      } else {
        ccon19si.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      }
      // Re-assigning cReqFuncCd with the modified value fromArchInputStruct.
      cReqFuncCd = ccon19si.getArchInputStruct().getCReqFuncCd();
      // Preparing to call PostEvent Common Function
      CCMN01UI ccmn01ui = new CCMN01UI();
      ccmn01ui.setArchInputStruct(new ArchInputStruct());
      ccmn01ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
      ROWCCMN01UIG00 rowccmn01uig00Temp = new ROWCCMN01UIG00();
      rowccmn01uig00Temp.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      rowccmn01uig00Temp.setSzCdEventStatus(rowccmn01uig00.getSzCdEventStatus());
      rowccmn01uig00Temp.setSzCdTask(rowccmn01uig00CdTask);
      rowccmn01uig00Temp.setSzCdEventType(rowccmn01uig00.getSzCdEventType());
      rowccmn01uig00Temp.setSzTxtEventDescr(rowccmn01uig00.getSzTxtEventDescr());
      rowccmn01uig00Temp.setUlIdEvent(rowccmn01uig00IdEvent);
      rowccmn01uig00Temp.setUlIdStage(rowccmn01uig00IdStage);
      rowccmn01uig00Temp.setUlIdPerson(rowccmn01uig00IdPerson);
      rowccmn01uig00Temp.setTsLastUpdate(rowccmn01uig00.getTsLastUpdate());
      ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00Temp);
      // PostEvent;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
      // Setting a ROWCCMN01UIG00 object into the ccon19so structure created at the beginning
      ccon19so.setROWCCMN01UIG00(new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00());
      // Initializing ccon19soIdEventTemp to the idEvent retrieved from ROWCCMN01UIG00 object of ccon19si
      int ccon19soIdEvent = rowccmn01uig00IdEvent;
      if (!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        ccon19soIdEvent = ccmn01uo.getUlIdEvent();
      }
      ccon19so.getROWCCMN01UIG00().setTsLastUpdate(ccmn01uo.getTsLastUpdate());
      ccon19so.getROWCCMN01UIG00().setUlIdEvent(ccon19soIdEvent);
      if (0 == ccon19siIdSvcAuth) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      } else {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }
      // call InvalidateApproval common function to invalidate the conclusion
      // event if it has been submitted and the user has added a new record or
      // modified an existing record
       idEvent = ccon19si.getUlIdEvent();

      if (0 < idEvent && CodesTables.CEVTSTAT_PEND.equals(ccon19si.getSzCdEventStatus())) {
        // Begin Invalidate Approval
        // Invalidate the Conclusion event directly
        String cdEventStatus = "";
        if (StringHelper.isTrue(ccon19si.getArchInputStruct().getUlSysNbrReserved1())) {
          cdEventStatus = CodesTables.CEVTSTAT_PEND;
        } else {
          cdEventStatus = CodesTables.CEVTSTAT_PROC;
        }

        // ccmn62d
        int rowsUpdated = eventDAO.updateEventByIdEvent(idEvent, cdEventStatus);
        if (0 == rowsUpdated) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setArchInputStruct(new ArchInputStruct());
        ccmn05ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
        ccmn05ui.setUlIdEvent(idEvent);
        // InvalidateApproval;
        // this throws an exception that will halt processing with a message if it fails; success is no output.
        invalidateApproval.invalidateApproval(ccmn05ui);
        
//        CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
//        csBdgtSaveSI.setUlIdCase(idCase);
//        csBdgtSaveSI.setUlIdEvent(rowccmn01uig00IdEvent);
//        csBdgtSaveSI.setModeIndicator(CodesTables.CAPPDESG_INVD);
//        saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
      }
      // caud33d
      int ccon19soIdSvcAuth = updateServiceAuthorization(cReqFuncCd, ccon19siIdSvcAuth, ccon19si.getUlIdResource(),
                                                         ccon19si.getUlIdContract(), ccon19si.getCIndSvcAuthComplete(),
                                                         ccon19si.getSzCdSvcAuthCategory(),
                                                         ccon19si.getSzCdSvcAuthRegion(),
                                                         ccon19si.getSzCdSvcAuthCounty(),
                                                         ccon19si.getSzCdSvcAuthService(),
                                                         ccon19si.getSzTxtSvcAuthComments(),
                                                         ccon19si.getSzTxtSvcAuthSecProvdr(),
                                                         ccon19si.getTsLastUpdate(), ccon19si.getUlIdPrimaryClient(),
                                                         DateHelper.toJavaDate(ccon19si.getDtDtSvcAuthEff()),
                                                         ccon19si.getCIndDntdCmmtySvc(), ccon19si.getCIndWaiverReqd(),
                                                         DateHelper.toJavaDate(ccon19si.getDtDtRefSent()),
                                                         ccon19si.getSzCdPayCnty(), ccon19si.getSzCdErlyCaseTyp(),
                                                         ccon19si.getSzCdPupOtcme(), ccon19si.getSzCdPupTyp(),
                                                         ccon19si.getUlIdWaiver());
      ccon19so.setUlIdSvcAuth(ccon19soIdSvcAuth);
      // cses23d
      ServiceAuthorization serviceAuthorizationInfo = serviceAuthorizationDAO.findServiceAuth(ccon19soIdSvcAuth);
      if (serviceAuthorizationInfo == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ccon19so.setTsLastUpdate(serviceAuthorizationInfo.getDtLastUpdate());
      // cinv43d Delete any ToDo's related to this event
      todoDAO.updateTodoByIdEvent(ccon19soIdEvent);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // caud34d
        int rowsInserted = svcAuthEventLinkDAO.insertSvcAuthEventLink(ccon19soIdEvent, ccon19soIdSvcAuth);
        if (0 == rowsInserted) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
      // Call InvalidateApproval Common Function if PREVIOUS CdEvent status
      // in ccon19si is pending 'PEND'
      if (CodesTables.CEVTSTAT_PEND.equals(ccon19si.getSzCdEventStatus())) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setArchInputStruct(ccon19si.getArchInputStruct());
        ccmn05ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
        ccmn05ui.setUlIdEvent(ccon19soIdEvent);
        // InvalidateApproval;
        // this throws an exception that will halt processing with a message if it fails; success is no output.
        invalidateApproval.invalidateApproval(ccmn05ui);
        
        // This should be done in the invalidate approval but if it is not, its getting done here. 
        List<Integer> approvalEventLink = approvalEventLinkDAO.findIdApprovalEventLinksByIdEvent(ccon19soIdEvent);
        if(approvalEventLink != null || !approvalEventLink.isEmpty()){
          approvalEventLinkDAO.deleteApprovalEventLinkByIdEvent(ccon19soIdEvent);
        }
        
        
        // Update CaseBudgetLimit table when the service auth is in pending status
        // and the svcauthheader is modified and saved.
        // begin
        CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
        csBdgtSaveSI.setUlIdCase(idCase);
        csBdgtSaveSI.setUlIdEvent(rowccmn01uig00IdEvent);
        csBdgtSaveSI.setModeIndicator(CodesTables.CAPPDESG_INVD);
        saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
        // end

      }
      // Commented out some code here since APS is not there for Georgia.
    } // end else if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd))
    return ccon19so;
  }

  private int updateServiceAuthorization(String cReqFuncCd, int ccon19siIdSvcAuth, int idResource, int idContract,
                                         String indSvcAuthComplete, String cdSvcAuthCategory, String cdSvcAuthRegion,
                                         String cdSvcAuthCounty, String cdSvcAuthService, String txtSvcAuthComments,
                                         String txtSvcAuthSecProvdr, Date dtLastUpdate, int idPrimaryClient,
                                         Date dtSvcAuthEff, String indDntdCmmtySvc, String cIndWaiverReqd,
                                         Date dtRefSent, String cdPayCnty, String cdErlyCaseTyp, String cdPupOtcme,
                                         String cdPupTyp, int idWaiver) throws ServiceException {
    int idSvcAuth = ccon19siIdSvcAuth;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // caud33d
      // assigning the new value to idSvcAuth, to be returned
      idSvcAuth = complexServiceAuthorizationDAO.insertServiceAuthorization(idResource, idContract, cdSvcAuthCategory,
                                                                            cdSvcAuthCounty, cdSvcAuthService,
                                                                            txtSvcAuthComments, txtSvcAuthSecProvdr,
                                                                            dtLastUpdate, idPrimaryClient,
                                                                            dtSvcAuthEff, cIndWaiverReqd, dtRefSent,
                                                                            cdPayCnty, idWaiver, cdPupTyp,
                                                                            cdErlyCaseTyp, cdPupOtcme);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // caud33d
      serviceAuthorizationDAO.updateServiceAuthorization(cdSvcAuthCounty, idResource, idContract, cdSvcAuthCategory,
                                                         cdSvcAuthService, txtSvcAuthComments, txtSvcAuthSecProvdr,
                                                         idSvcAuth, dtLastUpdate, cIndWaiverReqd, dtRefSent, cdPayCnty,
                                                         idWaiver, cdPupTyp, cdErlyCaseTyp, cdPupOtcme);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return idSvcAuth;
  }
}
