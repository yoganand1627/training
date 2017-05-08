package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContactEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactNarrativeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;

public class ComplexContactEventDAOImpl extends BaseDAOImpl implements ComplexContactEventDAO {
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private ContactDAO contactDAO = null;
  private ContactNarrativeDAO contactNarrativeDAO = null;
  private EventDAO eventDAO = null;
  private TodoDAO todoDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setContactNarrativeDAO(ContactNarrativeDAO contactNarrativeDAO) {
    this.contactNarrativeDAO = contactNarrativeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  @SuppressWarnings({"unchecked"})
  public void deleteContractEvent(boolean deleteTodo, int idStage) {
    //Delete from todo before stage to maintain referential integrity.
    todoDAO.deleteTodoByIdTodoStage(idStage);

    if (deleteTodo) {
      //Also delete rows for any contact (event type 'CON')

      //Ensure that the EVENT_PERSON_LINK rows for any
      //assignment (event type 'ASG') events are deleted
      //before any EVENT rows are deleted.
      eventPersonLinkDAO.deleteEventPersonLink(idStage);

      //Prior to deleting from the EVENT table, we need
      //to delete from CONTACT and CONTACT_NARRATIVE.
      contactDAO.deleteContact(idStage);
      contactNarrativeDAO.deleteContactNarative(idStage);
      eventDAO.deleteEvent(idStage);
      incomingDetailDAO.updateIncomingDetailIdEvent(idStage);
    }
  }
}