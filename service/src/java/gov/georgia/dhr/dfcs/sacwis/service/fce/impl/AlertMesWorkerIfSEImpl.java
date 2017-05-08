package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.fce.AlertMesWorkerIfSE;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AlertMesWorkerIfSESI;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AlertMesWorkerIfSEImpl extends BaseServiceImpl implements AlertMesWorkerIfSE {
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoDAO todoDAO = null;
  private CheckIfUserHasRight checkIfUserHasRight = null;
  
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public boolean alertMesWorkerIfAlreadySE(AlertMesWorkerIfSESI alertMesWorkerIfSESI) {
    int idCase = alertMesWorkerIfSESI.getIdCase();
    int idStage = alertMesWorkerIfSESI.getIdStage();
    int idUser = alertMesWorkerIfSESI.getIdUser(); 
    String[] securityAttributesMESWorker = alertMesWorkerIfSESI.getSecurityAttributesMESWorker();
    boolean mesWorkerAssignedAsSE = false;
    
    // retrieve list of all secondary workers for the stage
    List<Integer> idSecondaryWorkers = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
    if (idSecondaryWorkers == null) {
      // We can return since there are no secondary workers for the stage
      return false;
    }
    // loop thru the list of secondary workers, retrieve their security profile 
    // and see if they have the MES Worker attribute
    for (Iterator<Integer> it_idSecondaryWorkers = idSecondaryWorkers.iterator(); it_idSecondaryWorkers.hasNext();) {
      boolean isMesWorker = false;
      int idSecondaryWorker = it_idSecondaryWorkers.next();
      if((checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, securityAttributesMESWorker[0])) || 
                      (checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, securityAttributesMESWorker[1]))){
        isMesWorker = true;
      }
      // if they have the MES Worker attribute, send them the alert
      if(isMesWorker) {
        mesWorkerAssignedAsSE = true;
        callSaveTodo(idCase, idStage, idSecondaryWorker, idUser, ADD, MES_WORKER);
      }
    }
    // if MES Worker is already assigned to the stage, also send the MES Program 
    // Assistant an alert
    if(mesWorkerAssignedAsSE) {
      int idMesProgAssist = alertMesWorkerIfSESI.getIdMesProgAssist();
      callSaveTodo(idCase, idStage, idMesProgAssist, idUser, ADD, MES_PROGRAM_ASSISTANT);
    }
    return mesWorkerAssignedAsSE;
  }
  
  private void callSaveTodo(int idCase, int idStage, int idPerson, int idPersCreator, String dataAction, String progAssistOrWorker) {

    String desc = null;
    
    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setTxtTodoLongDesc(null);

    Person persCreator = (Person) getPersistentObject(Person.class, idPersCreator);
    todo.setPersonByIdTodoPersCreator(persCreator);

    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
    todo.setCapsCase(capsCase);
 
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    todo.setStage(stage);
    
    todo.setIdTodo(0);

    // change the text of the alert accordingly for an MES Worker or MES Program Assistant
    if (MES_WORKER.equals(progAssistOrWorker)) {
      desc = "FCEA Initial App or Notification of Change is ready to be processed.";
    } else {
      desc = "FCEA Initial App or Notification of Change has been assigned."; 
    }

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
      todo.setTxtTodoDesc(desc);
      Person persWorker = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersWorker(persWorker);

      Person persAssigned = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersAssigned(persAssigned);
    } 
    todoDAO.saveTodo(todo);
  }
  
}
