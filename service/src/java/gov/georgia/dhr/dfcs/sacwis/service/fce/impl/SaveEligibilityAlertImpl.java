package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveEligibilityAlert;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveEligibilityAlertImpl extends BaseServiceImpl implements SaveEligibilityAlert {
  
  public static final String INITIAL_MEDICAID = "IMA";
  public static final String FOSTER_CARE_APPLICATION = "FCA";
  private TodoDAO todoDAO = null;
    
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void saveEligibilityAlert(int idPerson, int idUser, int idStage, int idCase, String eventType){
    //  Eligibility needs to be redetermined for <Stage Name> by <Current Date + 6 Months>. 
      Todo todo = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, idCase);
      Stage stage = getPersistentObject(Stage.class, idStage);
      String cdTask = "";
      Date dateCreated = new Date();
      Date todaysDate = new Date();
      String todoDesc = "";
      if(FOSTER_CARE_APPLICATION.equals(eventType)){
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
        todoDesc = "Eligibility needs to be redetermined for " + stage.getNmStage() 
                      + " by " + DateHelper.toString(DateHelper.addToDate(todaysDate, 0, 6, 0), DATE_FORMAT);
        todo.setDtTodoDue(DateHelper.addToDate(todaysDate, 0, 6, 0));
      }else if(INITIAL_MEDICAID.equals(eventType)){
        todoDesc = "Initial Medicaid Application ready for assignment." ;
        todo.setDtTodoDue(todaysDate);
      }
      todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
      todo.setDtTodoCreated(dateCreated);
      todo.setCapsCase(capsCase);
      todo.setStage(stage);
      todoDAO.saveTodo(todo);
    }
}
