package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaDrugExposedNewbornsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaReasonableEffortsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyFactorDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.DeleteSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

public class DeleteSafetyAssessmentImpl extends BaseServiceImpl implements DeleteSafetyAssessment {

  private PostEvent postEvent = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private SaReasonableEffortsDAO saReasonableEffortsDAO = null;

  private SaSafetyAssessmentDAO saSafetyAssessmentDAO = null;

  private SaSafetyFactorDAO saSafetyFactorDAO = null;

  private SaDrugExposedNewbornsDAO saDrugExposedNewbornsDAO = null;
  
  //Added to resolve STGAP00007567
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
  
  //End to resolve STGAP00007567
  

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setSaDrugExposedNewbornsDAO(SaDrugExposedNewbornsDAO saDrugExposedNewbornsDAO) {
    this.saDrugExposedNewbornsDAO = saDrugExposedNewbornsDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setSaReasonableEffortsDAO(SaReasonableEffortsDAO saReasonableEffortsDAO) {
    this.saReasonableEffortsDAO = saReasonableEffortsDAO;
  }

  public void setSaSafetyAssessmentDAO(SaSafetyAssessmentDAO saSafetyAssessmentDAO) {
    this.saSafetyAssessmentDAO = saSafetyAssessmentDAO;
  }

  public void setSaSafetyFactorDAO(SaSafetyFactorDAO saSafetyFactorDAO) {
    this.saSafetyFactorDAO = saSafetyFactorDAO;
  }

  public int deleteSafetyAssessment(SafetyAssessmentDeleteSI safetyAssessment) {
    int rowsDeleted = 0;
    checkStageEventStatus(safetyAssessment.getEventReqFuncCd(), safetyAssessment.getIdStage(),
                          safetyAssessment.getCdStage());
    
    int idEvent = safetyAssessment.getUlIdEvent();
    
    rowsDeleted = saSafetyFactorDAO.deleteSafetyFactor(idEvent);
    rowsDeleted = saReasonableEffortsDAO.deleteReasonableEfforts(idEvent);
    rowsDeleted = saDrugExposedNewbornsDAO.deleteDrugExposedNewborns(idEvent);
    rowsDeleted  = saSafetyAssessmentDAO.deleteSafetyAssessment(idEvent);
    
    //Per STGAP00007567
    todoDAO.deleteTodoByIdEvent(idEvent);
    
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
    // End  Per STGAP00007567
    ROWCCMN01UIG00 rowccmn01uigoo =  safetyAssessment.getROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowArray = safetyAssessment.getROWCCMN01UIG01_ARRAY();
    callPostEvent(safetyAssessment.getEventReqFuncCd(), rowccmn01uigoo, rowArray);   
    return rowsDeleted;
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
                                 ROWCCMN01UIG01_ARRAY rowccmn01uig01_array)
          throws ServiceException {

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }
}
