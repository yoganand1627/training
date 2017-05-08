package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;
/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   10/20/2008  ssubram           STGAP00010704 - Adding System Generated TO DO's for Adoption Enhancement
 *   07/23/2009  hjbaptiste        STGAP00014781 - Only send progression to INV alert to Regional Adoption Exchange Consultants.
 *                                 Calling ComplexTodoDAO to save Todo
 *
 */
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseOpenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStageProgression;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN88SO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveStageProgressionImpl extends BaseServiceImpl implements SaveStageProgression {

  private static final String TODO_LE_NOTIF_TASK = "1047";
  private static final String INTAKE_STAGE = CodesTables.CSTAGES_INT;

  private CapsResourceDAO capsResourceDAO = null;
  
  private CloseOpenStage closeOpenStage = null;
  
  private EventDAO eventDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;
  
  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private TodoDAO todoDAO = null;
  
  private ComplexTodoDAO complexTodoDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setCloseOpenStage(CloseOpenStage closeOpenStage) {
    this.closeOpenStage = closeOpenStage;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO= eventDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public CCMN88SO saveStageProgression(CCMN88SI ccmn88si) throws ServiceException {
    CCMN88SO ccmn88so = new CCMN88SO();
    int stageId = ccmn88si.getUlIdStage();
    String cdStage = ccmn88si.getSzCdStage();
    //STGAP00010704 enhancement
    Stage stage = stageDAO.findStageByIdStage(stageId);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    String cdStageOpen = ccmn88si.getSzCdStageOpen();
    int idCase = stage.getCapsCase().getIdCase();
    int idPerson = ccmn88si.getUlIdPerson();
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    // We do not need to call this for R1 since There is no available form
    // We need to uncomment this for R2
    if (INTAKE_STAGE.equals(cdStage)) {
      // cint58d
      checkLawEnforcementNotification(stageId);
      checkEventStatusFotIntakeClosureChange(stageId);
      //STGAP00010704
      if (CodesTables.CSTAGES_INV.equals(cdStageOpen)){
        //Query the incoming detail to see if the ID Resource is registered as Exchange Home
        Integer incomingDetailResourceId = incomingDetailDAO.findIncomingDetailResourceIdIsInExchangeHome(stageId);
        if (incomingDetailResourceId != null && incomingDetailResourceId > 0){
          CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(incomingDetailResourceId);
          String resourceName = capsResource.getNmResource();
          String cdTask = "";
          CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
          String cdCounty = capsCase.getCdCaseCounty();
          if(cdCounty != null){
            if(cdCounty.length() == 1 ){
              cdCounty = "00" + cdCounty;
            } else if (cdCounty.length() == 2){
              cdCounty = "0" + cdCounty;
            }
          }
          //Get the region of the county
          String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
          List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
          if (adoExchangeConsultants != null && adoExchangeConsultants.size() > 0) {
            Iterator<Integer> itrAdoExchangeConsultants = adoExchangeConsultants.iterator();
            List<Todo> todoList = new ArrayList<Todo>();
            while (itrAdoExchangeConsultants.hasNext()) {
              Integer idAssigned = (Integer) itrAdoExchangeConsultants.next();
              String todoDesc = "Investigation has been initiated on home registered with the exchange.";
              String todoLongDesc = "Investigation has been initiated on "
                                      + resourceName +" home registered with the exchange.";
              Todo todo = new Todo();
              todo.setPersonByIdTodoPersAssigned(personDAO.findPersonByIdPerson(idAssigned));
              todo.setTxtTodoDesc(todoDesc);
              todo.setTxtTodoLongDesc(todoLongDesc);
              todo.setCdTodoTask(cdTask);
              todo.setDtTodoDue(dtToday);
              todo.setCdTodoType(CodesTables.CTODOTYP_A);
              todo.setCapsCase(capsCase);
              todo.setDtTodoCreated(dtToday);
              todo.setStage(getPersistentObject(Stage.class, stageId));
              todoList.add(todo);
            }
            complexTodoDAO.saveTodo(todoList);
          }
        }
      }
    }
    //If User tries to stage progress from FCC to ADO, but there is already an open ADO stage exist
    //for this child. Then don't allow to stage progress.
    if (CodesTables.CSTAGES_SUB.equals(cdStage) && CodesTables.CSTAGES_ADO.equals(cdStageOpen)){
      //Get the Primary Child Person ID
      Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonForChildByIdStage(stageId);
      //Check for an existing ADO stage for the case
      long adoStageCount = stageDAO.countOpenAdoStageByIdPersonIdCase(idPrimaryChild, idCase);
      if (adoStageCount > 0){
        throw new ServiceException(Messages.MSG_ADO_STAGE_EXISTS);
      }
    }
    CCMN03UI ccmn03si = new CCMN03UI();
    ccmn03si.setUlIdStage(stageId);
    ccmn03si.setSzCdStage(ccmn88si.getSzCdStage());
    ccmn03si.setSzCdStageProgram(ccmn88si.getSzCdStageProgram());
    ccmn03si.setSzCdStageOpen(ccmn88si.getSzCdStageOpen());
    ccmn03si.setSzCdStageReasonClosed(ccmn88si.getSzCdStageReasonClosed());
    ccmn03si.setUlIdPerson(ccmn88si.getUlIdPerson());
    ccmn03si.setSzNmPersonFull(ccmn88si.getSzNmPersonFull());
    ccmn03si.setUlScrIdPrimChild(ccmn88si.getUlScrIdPrimChild());
    ccmn03si.setCSysIndSStgOpenOnly(ccmn88si.getCSysIndSStgOpenOnly());

    // law enforcement notification is fine then continue
    try {
      CCMN03UO ccmn03so = closeOpenStage.closeOpenStage(ccmn03si);
      ccmn88so.setUlIdStage(ccmn03so.getUlIdStage());
      ccmn88so.setSzCdStageType(ccmn03so.getSzCdStageType());
      ccmn88so.setTsLastUpdate(ccmn03so.getTsLastUpdate());
      ccmn88so.setTsSysTsLastUpdate2(ccmn03so.getTsSysTsLastUpdate2());
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_NO_ROWS_RETURNED:
          // Need to present a different message for this error.
          throw new ServiceException(Messages.MSG_NO_PAL_COORD_EXISTS_REASSIGN, se);
        default:
          // Just pass the exception through by default.
          throw se;
      }
    }
    return ccmn88so;
  }

  private void checkLawEnforcementNotification(int stageId) throws ServiceException {
    // Check the ToDo table to see if an incomplete Law Enforcement Notification ToDo exists.
    //   If one is needed check whether the notification was completed.
    //   If not completed flag the error otherwise continue. If no imcomplete notification exist continue
    // cint58d
    Todo todo = todoDAO.findTodoByIdStageAndCdTodoTask(stageId, TODO_LE_NOTIF_TASK);
    // If a todo is found, and there is no complete date, that means that the notif to le has not been completed;
    //   throw the notificatin required message.
    if (todo != null && DateHelper.isNull(todo.getDtTodoCompleted())) {
      throw new ServiceException(Messages.MSG_INT_LE_NOTIF_REQUIRED);
    }
  }
  
  private void checkEventStatusFotIntakeClosureChange(int stageId) throws ServiceException {
    // Check the ToDo table to see if an incomplete Law Enforcement Notification ToDo exists.
    //   If one is needed check whether the notification was completed.
    //   If not completed flag the error otherwise continue. If no imcomplete notification exist continue
    // cint58d
    String cdEventType = CodesTables.CEVNTTYP_INC;
    List<Event> eventList = eventDAO.findEventByIdStageAndCdEventType(stageId, cdEventType);
    // If a todo is found, and there is no complete date, that means that the notif to le has not been completed;
    //   throw the notificatin required message.
   if (eventList!= null && eventList.size()>0) {
     for(Iterator it = eventList.iterator(); it.hasNext();){
       Event event = (Event)it.next();
       if(!CodesTables.CEVTSTAT_APRV.equals(event.getCdEventStatus())){
         throw new ServiceException(Messages.MSG_INT_CLOS_APRV_REQ);
       }
     }
      
    }
  }
}
