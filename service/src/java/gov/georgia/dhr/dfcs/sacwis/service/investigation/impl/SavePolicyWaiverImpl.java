package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SavePolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

/**
 * This class provides the service that saves the policy waiver.
 * 
 * 
 * <pre>
 *    Change History:
 *    Date      User              Description
 *    --------  ----------------  --------------------------------------------------
 *    09/25/08  alwilliams        STGAP00009727: Updated method retrieveResource_xa to
 *                                store the pullback object in to the state.
 * </pre>
 */

public class SavePolicyWaiverImpl extends BaseServiceImpl implements SavePolicyWaiver {

  private PolicyWaiverDAO policyWaiverDAO = null;

  private PostEvent postEvent = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private EventDAO eventDAO = null;

  private StageDAO stageDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private SaveCaseBudgetLimitList saveCaseBudgetLimitList = null;

  // STGAP00007567
  private TodoDAO todoDAO = null;

  private ApproversDAO approversDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  // EndSTGAP00007567

  public void setPolicyWaiverDAO(PolicyWaiverDAO policyWaiverDAO) {
    this.policyWaiverDAO = policyWaiverDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public int savePolicyWaiver(PolicyWaiverSaveSI policyWaiverSaveSI) throws ServiceException {
    String eventReqFuncCd = "";
    int idEvent = policyWaiverSaveSI.getIdWvrEvent();
    int idStage = policyWaiverSaveSI.getIdStage();
    int idWvrEvent = 0;
    String cdStage = policyWaiverSaveSI.getCdStage();
    ROWCCMN01UIG00 policyWaiverEvent = policyWaiverSaveSI.getROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY policyWaiverEvent_array = policyWaiverSaveSI.getROWCCMN01UIG01_ARRAY();
    CCMN01UO ccmn01uo = new CCMN01UO();

    // set add or update mode
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }

    // make sure stage is not closed
    checkStageEventStatus(eventReqFuncCd, idStage, cdStage);

    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(policyWaiverSaveSI.getCdReqFuncCd())) {
      ccmn01uo = callPostEvent(eventReqFuncCd, policyWaiverEvent, policyWaiverEvent_array);

      // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
      idEvent = ccmn01uo.getUlIdEvent();
    }
    Event event = (Event) getPersistentObject(Event.class, idEvent);

    PolicyWaiver policyWaiver = new PolicyWaiver();

    Person person = (Person) getPersistentObject(Person.class, policyWaiverSaveSI.getIdWvrCaseManager());
    policyWaiver.setPerson(person);
    policyWaiver.setEvent(event);
    try {
      policyWaiver
                  .setDtWvrRequest(DateHelper
                                             .toJavaDate(
                                                         DateHelper
                                                                   .toCastorDate(policyWaiverSaveSI.getDtDtWvrRequest()),
                                                         policyWaiverSaveSI.getTmDtWvrRequest()));
    } catch (Exception e) {
    }
    policyWaiver.setCdWvrType(policyWaiverSaveSI.getSzCdWvrType());
    policyWaiver.setCdWvrReason(policyWaiverSaveSI.getSzCdWvrReason());
    policyWaiver.setDtWvrExprtn(policyWaiverSaveSI.getDtDtWvrExprtn());
    policyWaiver.setTxtWvrComments(policyWaiverSaveSI.getSzTxtWvrComments());
    policyWaiver.setIdWvrEvent(policyWaiverSaveSI.getIdWvrEvent());
    policyWaiver.setDtLastUpdate(policyWaiverSaveSI.getDtLastUpdate());
    policyWaiver.setCdWvrJustification(policyWaiverSaveSI.getCdWvrJustification());
    policyWaiver.setDtWvrBegin(policyWaiverSaveSI.getDtWvrBegin());
    policyWaiver.setDtWvrEnd(policyWaiverSaveSI.getDtWvrEnd());
    policyWaiver.setTxtWvrOther(policyWaiverSaveSI.getTxtWvrOther());
    if (policyWaiverSaveSI.getMnthWvrCtct() != null && !(policyWaiverSaveSI.getMnthWvrCtct().trim().equals(""))) {
      policyWaiver.setMnthWvrCtct(new Integer(policyWaiverSaveSI.getMnthWvrCtct()));
    }
    if (policyWaiverSaveSI.getYrWvrCtct() != null && !(policyWaiverSaveSI.getYrWvrCtct().trim().equals(""))) {
      policyWaiver.setYrWvrCtct(new Integer(policyWaiverSaveSI.getYrWvrCtct()));
    }

    policyWaiver.setTxtWvrCapacity(policyWaiverSaveSI.getTxtWvrCapacity());
    if (policyWaiverSaveSI.getPersonByIdWvrPrnUnableCnct() != null
        && policyWaiverSaveSI.getPersonByIdWvrPrnUnableCnct().trim() != "") {
      Person personUnableCnct = (Person) getPersistentObject(
                                                             Person.class,
                                                             new Integer(
                                                                         policyWaiverSaveSI
                                                                                           .getPersonByIdWvrPrnUnableCnct()));
      if (personUnableCnct != null) {
        policyWaiver.setPersonByIdWvrPrnUnableCnct(personUnableCnct);
      }
    }
    policyWaiver.setTxtSlpArngmts(policyWaiverSaveSI.getTxtSlpArngmts());

    if (policyWaiverSaveSI.getAmtAppPrdm() != null) {
      policyWaiver.setAmtAppPrdm(new Double(policyWaiverSaveSI.getAmtAppPrdm()));
    }

    policyWaiver.setCdWvrAuthCounty(policyWaiverSaveSI.getCdWvrAuthCounty());
    policyWaiver.setCdWvrPmtCounty(policyWaiverSaveSI.getCdWvrPmtCounty());
    policyWaiver.setCdWvrUasCd(policyWaiverSaveSI.getCdWvrUasCd());
    policyWaiver.setCdWvrEntCd(policyWaiverSaveSI.getCdWvrEntCd());
    policyWaiver.setCdWvrSvcDesc(policyWaiverSaveSI.getCdWvrSvcDesc());
    if (StringUtils.isNotBlank(policyWaiverSaveSI.getPersonByIdWvrPryCust())) {
      Person primaryCustomer = (Person) getPersistentObject(Person.class,
                                                            new Integer(policyWaiverSaveSI.getPersonByIdWvrPryCust()));
      if (primaryCustomer != null) {
        policyWaiver.setPersonByIdWvrPryCust(primaryCustomer);
      }
    }

    // STGAP00009727: Added a numeric check
    if (StringUtils.isNotBlank(policyWaiverSaveSI.getCapsResource())
        && StringUtils.isNumeric(policyWaiverSaveSI.getCapsResource())) {
      CapsResource capsResource = (CapsResource) getPersistentObject(CapsResource.class,
                                                                     new Integer(policyWaiverSaveSI.getCapsResource()));
      if (capsResource != null) {
        policyWaiver.setCapsResource(capsResource);
      }
    }

    if (StringUtils.isNotBlank(policyWaiverSaveSI.getAmtWvr())) {
      policyWaiver.setAmtWvr(new Double(policyWaiverSaveSI.getAmtWvr()));
    }

    if (StringUtils.isNotBlank(policyWaiverSaveSI.getNbrWvrUnit())) {
      policyWaiver.setNbrWvrUnit(new Double(policyWaiverSaveSI.getNbrWvrUnit()));
    }
    // if add or update
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(policyWaiverSaveSI.getCdReqFuncCd())
        || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(policyWaiverSaveSI.getCdReqFuncCd())) {
      policyWaiverDAO.savePolicyWaiver(policyWaiver);
      idWvrEvent = policyWaiver.getIdWvrEvent();
    }
    // if delete
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(policyWaiverSaveSI.getCdReqFuncCd())) {
      policyWaiverDAO.deletePolicyWaiverByIdEvent(idEvent);

      // if ((!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request)))
      // Per STGAP00007567
      todoDAO.deleteTodoByIdEvent(idEvent);

      Integer idApproval = approvalEventLinkDAO.findActiveIdApprovalByIdEvent(idEvent);
      if (idApproval != null) {
        List<Approvers> approversList = approversDAO.findApproversByIdApproval(idApproval);
        if (approversList == null || approversList.isEmpty()) {
          // -- throw exception?
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        for (Iterator<Approvers> it = approversList.iterator(); it.hasNext();) {
          Approvers approvers = it.next();
          Todo todo = approvers.getTodo();
          if (todo != null && todo.getIdTodo() > 0) {
            todoDAO.deleteTodo(todo);
          }
          approversDAO.updateIdTodoByIdApprovers(approvers.getIdApprovers(), 0);
        }
      }

      // End STGAP00007567
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
      ccmn01uo = callPostEvent(eventReqFuncCd, policyWaiverEvent, policyWaiverEvent_array);
    }
    return idWvrEvent;
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdStage) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdStage);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00,
                                 ROWCCMN01UIG01_ARRAY rowccmn01uig01_array) throws ServiceException {

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }
}