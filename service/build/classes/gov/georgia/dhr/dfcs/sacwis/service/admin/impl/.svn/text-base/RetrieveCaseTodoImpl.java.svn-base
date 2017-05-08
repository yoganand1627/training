package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCaseTodo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO_ARRAY;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

  /*Change History:
     Date        User      Description
     ----------  --------  --------------------------------------------------
     08/04/08    mxpatel  STGAP00009712 -- wrote an "if" statement to allow values where
                           id_stage is null in the "ToDO" table.
                           
                           */
                           
public class RetrieveCaseTodoImpl extends BaseServiceImpl implements RetrieveCaseTodo {

  private DynamicTodoDAO dynamicTodoDAO = null;
  private PersonDAO personDAO = null;

  public void setDynamicTodoDAO(DynamicTodoDAO dynamicTodoDAO) {
    this.dynamicTodoDAO = dynamicTodoDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  private static final String SYSTEM_NAME = "System";
  
  public CCMN12SO retrieveCaseTodo(CCMN12SI ccmn12si) throws ServiceException {
    CCMN12SO ccmn12so = new CCMN12SO();
    ROWCCMN42DO_ARRAY rowccmn42do_array = new ROWCCMN42DO_ARRAY();
    int idCase = ccmn12si.getUlIdCase();

    // Get the date range for the requested case
    DtDtTodoDue_ARRAY dtDtTodoDue_ARRAY = ccmn12si.getDtDtTodoDue_ARRAY();
    Date dtTodoDueFrom = DateHelper.toJavaDate(dtDtTodoDue_ARRAY.getDtDtTodoDue(0));
    Date dtTodoDueEnd = DateHelper.toJavaDate(dtDtTodoDue_ARRAY.getDtDtTodoDue(1));

    // if no start and end date was given for that range add 7 days to todays date and consider it as your end date
    if (DateHelper.isNull(dtTodoDueEnd) && DateHelper.isNull(dtTodoDueFrom)) {
      // Get todays date and add 7 days to it.
      Date tsDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      dtTodoDueEnd = DateHelper.addToDate(tsDate, 0, 0, 7);
    }

    // find the to do list for the given case within the specified date range and sorted accordingly
    // ccmn42d
    String cReqFuncCd = ccmn12si.getArchInputStruct().getCReqFuncCd();
    PaginatedHibernateList<Todo> toDoList = dynamicTodoDAO.findCaseTodos(idCase, cReqFuncCd, dtTodoDueFrom,
                                                                         dtTodoDueEnd,
                                                                         ccmn12si.getArchInputStruct().getUsPageNbr(),
                                                                         ccmn12si.getArchInputStruct().getUlPageSizeNbr());
    // add the todo list of items in an array
    if (toDoList == null || toDoList.isEmpty()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    ccmn12so.setMoreDataAvailable(toDoList.isMoreDataAvailable());
    ROWCCMN42DO rowccmn42do;
    for (Iterator<Todo> it = toDoList.iterator(); it.hasNext();) {
      Todo row = it.next();
      Stage stage = row.getStage();
      rowccmn42do = new ROWCCMN42DO();
      int idPersonCreator = row.getPersonByIdTodoPersCreator() != null ? row.getPersonByIdTodoPersCreator()
                                                                            .getIdPerson() : 0;
      if (idPersonCreator != 0) {
        // retrieve the name of the person who created the ToDo
        Person person = personDAO.findPersonByIdPerson(idPersonCreator);

        if (person == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        rowccmn42do.setSzScrTodoCreated(person.getNmPersonFull());
      } else {
        rowccmn42do.setSzScrTodoCreated(SYSTEM_NAME);
      }
      //rowccmn42do.setSzScrTodoCreated(row.getPersonByIdTodoPersCreator().getNmPersonFull());
      // rowccmn42do.setCreatedOn(new Timestamp(row.getDtTodoCreated().getTime()));
      
      rowccmn42do.setSzScrTodoAssignedTo(row.getPersonByIdTodoPersAssigned().getNmPersonFull());
      rowccmn42do.setCreatedBy(row.getNmTodoCreatorInit());
      rowccmn42do.setCreatedOn(new Timestamp(row.getDtTodoCreated().getTime()));
      rowccmn42do.setDtDtTodoDue(DateHelper.toCastorDate(row.getDtTodoDue()));
      rowccmn42do.setSzCdTask(row.getCdTodoTask());
      rowccmn42do.setSzCdTodoType(row.getCdTodoType());
      rowccmn42do.setSzTxtTodoDesc(row.getTxtTodoDesc());
      rowccmn42do.setLdIdTodo(row.getIdTodo() != null ? row.getIdTodo() : 0);
      rowccmn42do.setUlIdCase(idCase);
      
     
      //mxpatel wrote this "if"
      //this method is to allow todo's with no stage id.
      if(stage != null){
        rowccmn42do.setSzCdStage(stage.getCdStage());
        rowccmn42do.setSzCdStageProgram(stage.getCdStageProgram());
      }
      rowccmn42do.setUlIdEvent(row.getEvent() != null ? row.getEvent().getIdEvent() : 0);
      rowccmn42do_array.addROWCCMN42DO(rowccmn42do);
      
      
      //rowccmn42do.setSzCdStage(stage.getCdStage()); //mxpatel commented this out
     // rowccmn42do.setUlIdEvent(row.getEvent() != null ? row.getEvent().getIdEvent() : 0);//mxpatel commented this out
      //rowccmn42do.setSzCdStageProgram(stage.getCdStageProgram()); //mxpatel commented this out
      // rowccmn42do.setDtDtTodoDue(DateHelper.toCastorDate(row.getDtTodoDue()));
      //rowccmn42do_array.addROWCCMN42DO(rowccmn42do);//mxpatel commented this out
    }
    ccmn12so.setROWCCMN42DO_ARRAY(rowccmn42do_array);
    return ccmn12so;
  }
}
