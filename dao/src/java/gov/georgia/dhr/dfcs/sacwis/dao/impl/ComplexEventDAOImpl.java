package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.Map;

import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

public class ComplexEventDAOImpl extends BaseDAOImpl implements ComplexEventDAO {
  private EventDAO eventDAO = null;

  private RiskAssessmentDAO riskAssessmentDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }

  public int updateEventByIdEventDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                              int idPerson, int idStage, String txtEventDescr, String cdTask,
                                              int idEvent, Date dtLastUpdate) {
    if (CodesTables.CEVNTTYP_PLA.equals(cdEventType) || CodesTables.CEVNTTYP_REF.equals(cdEventType)
        || CodesTables.CEVNTTYP_LES.equals(cdEventType) || CodesTables.CEVNTTYP_REM.equals(cdEventType)
        || CodesTables.CEVNTTYP_LOC.equals(cdEventType)) {

      int ret = eventDAO.updateEvent(cdEventStatus, cdEventType, idPerson, idStage, txtEventDescr, cdTask, idEvent,
                                     dtLastUpdate);
      // STGAP00000686
      // Refresh the Session
      if (ret > 0) {
        Session session = getSession();
        Event event = (Event) getSession().load(Event.class, idEvent);
        session.refresh(event);
      }
      return ret;
    } else {
      int ret = eventDAO.updateEventByIdEventAlsoDtLastUpdate(cdEventStatus, cdEventType, dtEventOccurred, idPerson,
                                                              idStage, txtEventDescr, cdTask, idEvent, dtLastUpdate);
      // STGAP00000686
      // Refresh the Session
      if (ret > 0) {
        Session session = getSession();
        Event event = (Event) getSession().load(Event.class, idEvent);
        session.refresh(event);
      }
      return ret;
    }
  }
  
  public int updatePortalEventByIdEventDtLastUpdate(String cdEventStatus, String cdEventType, Date dtEventOccurred,
                                                    int idStage, String txtEventDescr, String cdTask,
                                              int idEvent, Date dtLastUpdate) {
    if (CodesTables.CEVNTTYP_PLA.equals(cdEventType) || CodesTables.CEVNTTYP_REF.equals(cdEventType)
        || CodesTables.CEVNTTYP_LES.equals(cdEventType) || CodesTables.CEVNTTYP_REM.equals(cdEventType)
        || CodesTables.CEVNTTYP_LOC.equals(cdEventType)) {

      int ret = eventDAO.updatePortalEvent(cdEventStatus, cdEventType, idStage, txtEventDescr, cdTask, idEvent,
                                     dtLastUpdate);
      // STGAP00000686
      // Refresh the Session
      if (ret > 0) {
        Session session = getSession();
        Event event = (Event) getSession().load(Event.class, idEvent);
        session.refresh(event);
      }
      return ret;
    } else {
      int ret = eventDAO.updatePortalEventByIdEventAlsoDtLastUpdate(cdEventStatus, cdEventType, dtEventOccurred,
                                                              idStage, txtEventDescr, cdTask, idEvent, dtLastUpdate);
      // STGAP00000686
      // Refresh the Session
      if (ret > 0) {
        Session session = getSession();
        Event event = (Event) getSession().load(Event.class, idEvent);
        session.refresh(event);
      }
      return ret;
    }
  }

  public Map findIdEventAndCdEventStatus(int idStage, String cdTask) {
    // If the task is any of the four RISK_ASSESSMENT types, it checks for indicator
    // in the RISK_ASSESSMENT table to see if it is an Intranet Risk Assessment.
    Map map;
    if (ComplexEventDAO.RISK_ASSESSMENT.equals(cdTask) || ComplexEventDAO.RISK_ASSESSMENT_SUB.equals(cdTask)
        || ComplexEventDAO.RISK_ASSESSMENT_ADO.equals(cdTask) || ComplexEventDAO.RISK_ASSESSMENT_FPR.equals(cdTask)) {
      map = riskAssessmentDAO.findRiskAssessmentByIdStageCdTask(idStage, cdTask);
      // If the task is an eligibility task then it sorts by event status.
    } else if (ComplexEventDAO.ELIG_DETERM_SUB.equals(cdTask) || ComplexEventDAO.ELIG_DETERM_ADO.equals(cdTask)
               || ComplexEventDAO.ELIG_DETERM_PAD.equals(cdTask)) {
      map = eventDAO.findEventByIdStageCdTask(idStage, cdTask);
    } else {
      map = eventDAO.findEventByIdStageCdTaskOrderByIdEvent(idStage, cdTask);
    }
    return map;
  }

  public int insertEvent(String cdEventStatus, String cdEventType, Date dtEventOccurred, int idPerson, int idStage,
                         String txtEventDescr, String cdTask) {
    Event event = new Event();
    event.setCdEventStatus(cdEventStatus);
    event.setCdEventType(cdEventType);
    event.setDtEventOccurred(dtEventOccurred);
    Person person = null;
    if (idPerson != 0) {
      person = (Person) getSession().load(Person.class, idPerson);
      person.setIdPerson(idPerson);      
    }
    event.setPerson(person);
    Stage stage = (Stage) getSession().load(Stage.class, idStage);
    stage.setIdStage(idStage);
    event.setStage(stage);
    event.setTxtEventDescr(txtEventDescr);
    event.setCdTask(cdTask);
    eventDAO.saveEvent(event);
    return event.getIdEvent();
  }
}
