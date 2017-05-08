package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStaffTodo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DtDtTodoDue_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO_ARRAY;

public class RetrieveStaffTodoImpl extends BaseServiceImpl implements RetrieveStaffTodo {

  private DynamicTodoDAO dynamicTodoDAO = null;
  private PersonDAO personDAO = null;

  private static final int DAYSTOADD = 7;
  private static final String SYSTEM_NAME = "System";

  public void setDynamicTodoDAO(DynamicTodoDAO dynamicTodoDAO) {
    this.dynamicTodoDAO = dynamicTodoDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public CCMN11SO retrieveStaffTodo(CCMN11SI ccmn11si) throws ServiceException {
    CCMN11SO ccmn11so = new CCMN11SO();
    DtDtTodoDue_ARRAY dtDtTodoDue_array = ccmn11si.getDtDtTodoDue_ARRAY();
    Date dtTodoDueFrom = DateHelper.toJavaDate(dtDtTodoDue_array.getDtDtTodoDue(0));
    Date dtTodoDueEnd = DateHelper.toJavaDate(dtDtTodoDue_array.getDtDtTodoDue(1));
    if (DateHelper.isNull(dtTodoDueEnd) && DateHelper.isNull(dtTodoDueFrom)) {
      // Get todays date and add 7 days to it.
      Date tsDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      dtTodoDueEnd = DateHelper.addToDate(tsDate, 0, 0, DAYSTOADD);
    }
    //comment for pagination
    ArchInputStruct archInputStruct = ccmn11si.getArchInputStruct();
    // ccmn17d
    PaginatedHibernateList<Todo> staffTodosList = dynamicTodoDAO.findStaffTodos(ccmn11si.getUlIdTodoPersAssigned(),
                                                                                ccmn11si.getArchInputStruct().getCReqFuncCd(),
                                                                                dtTodoDueFrom, dtTodoDueEnd,
                                                                                archInputStruct.getUsPageNbr(),
                                                                                archInputStruct.getUlPageSizeNbr());

    if (staffTodosList == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    } else {
      ROWCCMN17DO_ARRAY rowccmn17do_array = new ROWCCMN17DO_ARRAY();
      for (Iterator<Todo> it = staffTodosList.iterator(); it.hasNext();) {
        Todo row = it.next();
        ROWCCMN17DO rowccmn17do = new ROWCCMN17DO();
        rowccmn17do.setSzCdTodoType(row.getCdTodoType());
        rowccmn17do.setDtDtTodoDue(DateHelper.toCastorDate(row.getDtTodoDue()));

        //rowccmn17do.setSzScrTodoCreated(row.getNmTodoCreatorInit());
        /*if (row.getNmTodoCreatorInit() != null) {
          rowccmn17do.setSzScrTodoCreated(row.getNmTodoCreatorInit());
        } else {
          rowccmn17do.setSzScrTodoCreated("System");
        }*/
        int idPersonCreator = row.getPersonByIdTodoPersCreator() != null ?
                              row.getPersonByIdTodoPersCreator().getIdPerson() : 0;
        if (idPersonCreator != 0) {
          // retrieve the name of the person who created the ToDo
          Person person = personDAO.findPersonByIdPerson(idPersonCreator);

          if (person == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          rowccmn17do.setSzScrTodoCreated(person.getNmPersonFull());
        } else {
          rowccmn17do.setSzScrTodoCreated(SYSTEM_NAME);
        }

        rowccmn17do.setSzTxtTodoDesc(row.getTxtTodoDesc());
        rowccmn17do.setSzCdTask(row.getCdTodoTask());

        rowccmn17do.setLdIdTodo(row.getIdTodo() != null ? row.getIdTodo() : 0);
        if (row.getCapsCase() != null) {
          rowccmn17do.setUlIdCase(row.getCapsCase().getIdCase());
        } else {
          rowccmn17do.setUlIdCase(0);
        }
        Stage stage = row.getStage();
        if (stage != null) {
          rowccmn17do.setUlIdStage(stage.getIdStage());
          rowccmn17do.setSzCdStage(stage.getCdStage());
          rowccmn17do.setSzCdStageProgram(stage.getCdStageProgram());
          rowccmn17do.setSzNmStage(stage.getNmStage());
        } else {
          rowccmn17do.setUlIdStage(0);
        }
        if (row.getEvent() != null) {
          rowccmn17do.setUlIdEvent(row.getEvent().getIdEvent());
        } else {
          rowccmn17do.setUlIdEvent(0);
        }
        rowccmn17do_array.addROWCCMN17DO(rowccmn17do);
      }

      ccmn11so.setROWCCMN17DO_ARRAY(rowccmn17do_array);
      //setting the value of bMoreDateInd
      ccmn11so.setMoreDataAvailable(staffTodosList.isMoreDataAvailable());
    }
    return ccmn11so;
  }
}
