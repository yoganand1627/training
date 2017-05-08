package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PsaPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ProtectiveServiceAlertDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ProtectiveServiceAlert;
import gov.georgia.dhr.dfcs.sacwis.db.PsaPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.common.SaveProtectiveServiceAlert;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonProtectiveServiceAlertList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertSaveSO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveProtectiveServiceAlertImpl extends BaseServiceImpl implements SaveProtectiveServiceAlert {
  private EventDAO eventDAO;
  private EventPersonLinkDAO eventPersonLinkDAO;
  private ProtectiveServiceAlertDAO protectiveServiceAlertDAO;
  private PsaPersonLinkDAO psaPersonLinkDAO;
  private TodoDAO todoDAO;
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setProtectiveServiceAlertDAO(ProtectiveServiceAlertDAO protectiveServiceAlertDAO) {
    this.protectiveServiceAlertDAO = protectiveServiceAlertDAO;
  }

  public void setPsaPersonLinkDAO(PsaPersonLinkDAO psaPersonLinkDAO) {
    this.psaPersonLinkDAO = psaPersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public ProtectiveServiceAlertSaveSO saveProtectiveServiceAlert(ProtectiveServiceAlertSaveSI psaSaveSI) {
    ProtectiveServiceAlertSaveSO psaSaveSO = new ProtectiveServiceAlertSaveSO();

    int idPSA = savePSA(psaSaveSI);
    savePersonsAbsconded(idPSA, psaSaveSI);

    return psaSaveSO;
  }

  private void createNewEvent(int idStage, Date activated, int idUserCreatedBy,
                              String nmPersonFull, int idPerson) {
    Event event = new Event();
    event.setIdEvent(0);
    Stage stage = this.getPersistentObject(Stage.class, idStage);
    event.setStage(stage);
    event.setCapsCase(stage.getCapsCase());
    event.setCdEventType(CodesTables.CEVNTTYP_PSA);
    event.setCdEventStatus(CodesTables.CEVTSTAT_COMP);
    event.setDtEventOccurred(activated);
    Person person = this.getPersistentObject(Person.class, idUserCreatedBy);
    event.setPerson(person);
    String dateStr = DateHelper.SLASH_FORMAT.format(activated);
    event.setTxtEventDescr("Protective Service Alert issued on " + dateStr + " for " + nmPersonFull);

    eventDAO.saveEvent(event);
    
    int idEvent = event.getIdEvent();
    eventPersonLinkDAO.insertEventPersonLink(idEvent, idPerson);
  }

  private void createNewAlert(int idPersAssigned, int idStage, Date deactivated, String nmPersonFull) {
    Todo todo = new Todo();
    todo.setIdTodo(0);
    Person person = this.getPersistentObject(Person.class, idPersAssigned);
    todo.setPersonByIdTodoPersAssigned(person);
    Stage stage = this.getPersistentObject(Stage.class, idStage);
    todo.setStage(stage);
    todo.setCapsCase(stage.getCapsCase());
    todo.setDtTodoCreated(new Date());
    todo.setDtTodoCompleted(deactivated);
    todo.setDtTodoDue(deactivated);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setTxtTodoDesc("Protective Service Alert for " + nmPersonFull + " has been deactivated");

    todoDAO.saveTodo(todo);
  }

  private void savePersonsAbsconded(int idPSA, ProtectiveServiceAlertSaveSI psaSaveSI) {
    List<PersonProtectiveServiceAlertList> persons = psaSaveSI.getPersons();
    if (persons != null && !persons.isEmpty()) {
      Iterator<PersonProtectiveServiceAlertList> it = persons.iterator();
      while (it.hasNext()) {
        PersonProtectiveServiceAlertList person = it.next();
        PsaPersonLink psaPersonLink = null;
        if (!person.isPsaCurrentlyActive() && person.isPsaNewlyActive()) {
          //-- add to PSA_PERSON_LINK with no DT_DEACTIVATED
          psaPersonLink = new PsaPersonLink();
          psaPersonLink.setIdPsaPersonLink(0);
          ProtectiveServiceAlert psa = this.getPersistentObject(ProtectiveServiceAlert.class, idPSA);
          psaPersonLink.setPsa(psa);
          Person per = this.getPersistentObject(Person.class, person.getIdPerson());
          psaPersonLink.setPerson(per);
          Date activated = psaSaveSI.getDateAndTime();
          psaPersonLink.setDtActivated(activated);
          psaPersonLinkDAO.savePsaPersonLink(psaPersonLink);

          //-- create event
          createNewEvent(psaSaveSI.getIdStage(), activated, psaSaveSI.getIdUserCreatedBy(),
                         person.getName(), person.getIdPerson());
        } else if (person.isPsaCurrentlyActive() && !person.isPsaNewlyActive()) {
          //-- update DT_DEACTIVATED as today for all active entries for the person
          
          /*
          Integer idPsaPersonLink = psaPersonLinkDAO.findIdPsaPersonLinkByIdPSAAndIdPerson(idPSA,
                                                                                           person.getIdPerson());
          if (idPsaPersonLink == null || idPsaPersonLink.intValue() < 1) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          psaPersonLink = this.getPersistentObject(PsaPersonLink.class, idPsaPersonLink.intValue());
          */
          
          List<PsaPersonLink> listToDeactivate = psaPersonLinkDAO.findActivePsaPersonLinksByIdPerson(person.getIdPerson());
          if(listToDeactivate == null || listToDeactivate.isEmpty()){
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          
          Date deactivated = new Date();
          Iterator<PsaPersonLink> dit = listToDeactivate.iterator();
          while(dit.hasNext()){
            psaPersonLink = dit.next();
            psaPersonLink.setDtDeactivated(deactivated);
            psaPersonLinkDAO.savePsaPersonLink(psaPersonLink);
          }
          
          //Date deactivated = new Date();
          //psaPersonLink.setDtDeactivated(deactivated);

          //-- create alert for the employee that originally created the PSA
          createNewAlert(psaSaveSI.getIdUserCreatedBy(), psaSaveSI.getIdStage(),
                         deactivated, person.getName());
        }
      }
    }
  }

  private int savePSA(ProtectiveServiceAlertSaveSI psaSaveSI) throws ServiceException {
    //-- populate ProtectiveServiceAlert (Hibernate) object and call saveProtectiveServiceAlert()
    ProtectiveServiceAlert psa;
    ArchInputStruct ais = psaSaveSI.getArchInputStruct();
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(ais.getCReqFuncCd())) {
      psa = this.getPersistentObject(ProtectiveServiceAlert.class, psaSaveSI.getIdPSA());
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(ais.getCReqFuncCd())) {
      psa = new ProtectiveServiceAlert();
      psa.setIdProtectiveServiceAlert(0);
      int idStage = psaSaveSI.getIdStage();
      if (idStage > 0) {
        Stage stage = this.getPersistentObject(Stage.class, idStage);
        psa.setStage(stage);
      } else {
        //-- TODO: mike, is this okay?  same effect, but still undeclared
        throw new RuntimeWrappedException(new PopulationException("A valid stage id was not populated " +
                                                                  "in the ProtectiveServiceAlertSaveSI object"));
      }
      int idUserCreatedBy = psaSaveSI.getIdUserCreatedBy();
      if (idUserCreatedBy > 0) {
        Person person = this.getPersistentObject(Person.class, idUserCreatedBy);
        psa.setPerson(person);
      } else {
        //-- TODO: mike, is this okay?  same effect, but still undeclared
        throw new RuntimeWrappedException(new PopulationException("A valid user id was not populated " +
                                                                  "in the ProtectiveServiceAlertSaveSI object"));
      }
      psa.setCdPsaStage(psaSaveSI.getCdStage());
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    //-- these 5 always reset
    Date dateAndTime = psaSaveSI.getDateAndTime();
    if (!DateHelper.isNull(dateAndTime)) {
      psa.setDtPsaDate(dateAndTime);
    }
    Date dateAbsconded = psaSaveSI.getDateAbsconded();
    if (!DateHelper.isNull(dateAbsconded)) {
      psa.setDtPsaAbsconded(dateAbsconded);
    }
    psa.setCdPsaReasonalert(psaSaveSI.getCdReasonForAlert());
    psa.setChPsaAllpesrlocated(psaSaveSI.getIndAllPersonsLocated());
    psa.setTxtPsaComment(psaSaveSI.getComments());

    protectiveServiceAlertDAO.saveProtectiveServiceAlert(psa);

    return psa.getIdProtectiveServiceAlert();
  }
}