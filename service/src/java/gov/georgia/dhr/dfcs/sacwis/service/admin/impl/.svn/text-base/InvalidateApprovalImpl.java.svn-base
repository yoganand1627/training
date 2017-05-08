package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN57DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InvalidateApprovalImpl extends BaseServiceImpl implements InvalidateApproval {

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private ApproversDAO approversDAO = null;
  private ComplexEventDAO complexEventDAO = null;
  private EventDAO eventDAO = null;
  private TodoDAO todoDAO = null;
  public static final String CPS_INV_CONCL_TASK_CODE = "2330";
  public static final String SAFETY_ASSESSMENT_CODE = "2285";
  public static final String RISK_ASSESSMENT_CODE = "2295" ;
  public static final String SAFETY_PLAN_CODE = "2275" ;
  

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCMN05UO invalidateApproval(CCMN05UI ccmn05ui) throws ServiceException {
    // Did not use !StringHelper.isTrue() since there is a constant U for Unknown/Undetermined that should not be considered false
    if (ArchitectureConstants.N.equals(ccmn05ui.getArchInputStruct().getUlSysNbrReserved1()) || ArchitectureConstants.FALSE.equals(ccmn05ui.getArchInputStruct().getUlSysNbrReserved1()) || ArchitectureConstants.NO.equals(ccmn05ui.getArchInputStruct().getUlSysNbrReserved1())) {
      // Find the idApproval for the idEvent input.
      // ccmn55d
      //Integer idApproval = approvalEventLinkDAO.findApprovalEventLinkByIdEvent(ccmn05ui.getUlIdEvent());
      
      // STGAP00006198 If another user has invalidated the Pending Approval and post event fails then do not try to 
      // invalidate again just proceed with the save process.
      int idEvent = ccmn05ui.getUlIdEvent();
      boolean invalidApproval = true;
      Integer idApproval = approvalEventLinkDAO.findActiveIdApprovalByIdEvent(idEvent);
      if (idApproval == null) {
        Integer invdApproval = approvalEventLinkDAO.findInvalidIdApprovalByIdEvent(idEvent);
        if(invdApproval == null){
        throw new ServiceException(Messages.SQL_NOT_FOUND);
          }else{
            invalidApproval = false;
          }
        }
      ccmn05ui.setUlIdApproval(idApproval != null ? idApproval : 0);
      // Find the approval information.
      // ccmn45d
      
      if(invalidApproval){
      ROWCCMN45DO rowccmn45do = findROWCCMN45DO(idApproval);
      ccmn05ui.setROWCCMN45DO(rowccmn45do);
      // ccmn46d
      
     
      if (0 == complexEventDAO.updateEventByIdEventDtLastUpdate(CodesTables.CEVTSTAT_COMP,
                                                                rowccmn45do.getSzCdEventType(),
                                                                DateHelper.toJavaDate(
                                                                        rowccmn45do.getDtDtEventOccurred()),
                                                                rowccmn45do.getUlIdPerson(), rowccmn45do.getUlIdStage(),
                                                                rowccmn45do.getSzTxtEventDescr(),
                                                                rowccmn45do.getSzCdTask(),
                                                                rowccmn45do.getUlIdEvent(),
                                                                rowccmn45do.getTsLastUpdate())) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      // Find related events.
      // ccmn57d
      ROWCCMN57DO_ARRAY rowccmn57do_array = findRelatedFunctionalEvents(idApproval);
      ccmn05ui.setROWCCMN57DO_ARRAY(rowccmn57do_array);
      // Update related events to COMP
      String taskCode = "";
      String currentTaskCode = "";
      for (Enumeration rowccmn57doEnum = rowccmn57do_array.enumerateROWCCMN57DO(); rowccmn57doEnum.hasMoreElements();) {
        ROWCCMN57DO rowccmn57do = (ROWCCMN57DO) rowccmn57doEnum.nextElement();
        Event event = eventDAO.findEventByIdEvent(rowccmn57do.getUlIdEvent());
        Event currentEvent = eventDAO.findEventByIdEvent(ccmn05ui.getUlIdEvent());
         taskCode = event.getCdTask();
         currentTaskCode = currentEvent.getCdTask();
        if (rowccmn57do.getUlIdEvent() != ccmn05ui.getUlIdEvent()) {
          // ccmn62d
        	// STGAP00003874 Checking to make sure we are not invalidating the Risk Assessment Safety Assessment or the Safety Plan 
        	// when the Investigation Conclustion is being invalidated.
       
        	if(CPS_INV_CONCL_TASK_CODE.equals(currentTaskCode)){
        		if (!"SAFETY_ASSESSMENT".equals(taskCode) && !RISK_ASSESSMENT_CODE.equals(taskCode) && !SAFETY_PLAN_CODE.equals(taskCode)){
        	
          if (0 == eventDAO.updateEventByIdEvent(rowccmn57do.getUlIdEvent(), CodesTables.CEVTSTAT_COMP)) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
           }
          }
        }else{
            int rowsUpdated = eventDAO.updateEventByIdEvent(rowccmn57do.getUlIdEvent(), CodesTables.CEVTSTAT_COMP);
            if (rowsUpdated < 1) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
             }
       }
        }
      }
      // ccmn88d -- Ignores failure
      approversDAO.updateCdApproversStatusByIdApproval(idApproval);
      
      //-- as a last step to invalidating an approval, delete the associated Todo(s) so that it/they
      //-- no longer shows up on any To-Do List page; then, remove the old Todo reference by setting
      //-- the ID_TODO value in the APPROVERS table to 0 (zero).  It must be done this way b/c the
      //-- ID_TODO column is not a foreign key but is also not nullable.
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
    }
    return new CCMN05UO();
  }

  private ROWCCMN45DO findROWCCMN45DO(int idApproval) throws ServiceException {
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idApproval);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

  private ROWCCMN57DO_ARRAY findRelatedFunctionalEvents(int idApproval) throws ServiceException {
    // ccmn57d
    List<Map> approvalEventLinkInfo =
            approvalEventLinkDAO.findRelatedFunctionalEventsForGivenApproval(idApproval);

    if (approvalEventLinkInfo == null || approvalEventLinkInfo.size() == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ROWCCMN57DO_ARRAY rowCcmn57DoArray = new ROWCCMN57DO_ARRAY();
    for (Iterator<Map> it = approvalEventLinkInfo.iterator(); it.hasNext();) {
      Map approvalEventLinkMap = it.next();
      ROWCCMN57DO row = new ROWCCMN57DO();
      row.setUlIdEvent((Integer) approvalEventLinkMap.get("idEvent") != null ? (Integer) approvalEventLinkMap.get(
              "idEvent") : 0);
      row.setSzCdTask((String) approvalEventLinkMap.get("cdTask"));
      rowCcmn57DoArray.addROWCCMN57DO(row);
    }
    return rowCcmn57DoArray;
  }

}
