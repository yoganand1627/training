package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WtlpPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.WtlpPlan;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveWTLP;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPRetrieveSO;

/*
 * @author Steven Thrasher
 * class: RetrieveWtlp
 */
public class RetrieveWTLPImpl extends BaseServiceImpl implements RetrieveWTLP {

  // declare local variables
  private static final String NEW = CodesTables.CEVTSTAT_NEW;

  private EventDAO eventDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private WtlpPlanDAO wtlpPlanDAO = null;

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) throws ServiceException {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) throws ServiceException {
    this.eventDAO = eventDAO;
  }

  public void setWtlpPlanDAO(WtlpPlanDAO wtlpPlanDAO) throws ServiceException {
    this.wtlpPlanDAO = wtlpPlanDAO;
  }

  /*
   * (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveWTLP#retrieveWTLPdetail(gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPRetrieveSI)
   *      This method populates the WTLPRetrieveSO object that is sent to the JSP for display.
   */
  public WTLPRetrieveSO retrieveWTLPdetail(WTLPRetrieveSI wtlpRetrieve) {
    WTLPRetrieveSO retWtlp = new WTLPRetrieveSO();
    int idWTLPEvent = wtlpRetrieve.getIdEvent();

    Event event = eventDAO.findEventByIdEvent(idWTLPEvent);

    // If eventDAO fails to find an event an exception is thrown
    if (event == null || event.equals(null)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    retWtlp.setIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    retWtlp.setIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    retWtlp.setCaseId(event.getCapsCase().getIdCase());
    retWtlp.setIdEvent(idWTLPEvent);
    retWtlp.setCdEventStatus(event.getCdEventStatus());
    if (approvalEventLinkDAO.findApprovalEventLinkByIdEvent(idWTLPEvent) != null) {
      retWtlp.setApprovalStatus(true);
    } else {
      retWtlp.setApprovalStatus(false);
    }

    String eventStatusSO = event.getCdEventStatus();
    // If the event isn't New then there should be data to retrieve from wtlp_plan table.
    if (!(NEW.equals(eventStatusSO))) {

      WtlpPlan wtlp = wtlpPlanDAO.findWtlp(idWTLPEvent);
      if (wtlp == null || wtlp.equals(null)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      String[] goalsArray = new String[retWtlp.sizeGoalsArray];
      int i = 0;
      try {
        if (wtlp.getCdBasic() != null) {
          goalsArray[i] = wtlp.getCdBasic();
          i++;
        }
        if (wtlp.getCdEdu() != null) {
          goalsArray[i] = wtlp.getCdEdu();
          i++;
        }
        if (wtlp.getCdHealth() != null) {
          goalsArray[i] = wtlp.getCdHealth();
          i++;
        }
        if (wtlp.getCdPers() != null) {
          goalsArray[i] = wtlp.getCdPers();
          i++;
        }
        if (wtlp.getCdVoc() != null) {
          goalsArray[i] = wtlp.getCdVoc();
          i++;
        }
        retWtlp.setTypesOfGoals(goalsArray);
        retWtlp.setSzPlanType(wtlp.getCdPlanType());
        retWtlp.setSzPlcmtAuth(wtlp.getCdPlcmtAuth());
        retWtlp.setSzNeeds(wtlp.getTxtNeeds());
        retWtlp.setSzStrengths(wtlp.getTxtStrengths());
        retWtlp.setSzVoluntary(wtlp.getTxtVoluntary());
        retWtlp.setWTLPDate(wtlp.getDtWtlp());
        retWtlp.setWTLPDateFrom(wtlp.getDtFrom());
        retWtlp.setWTLPDateTo(wtlp.getDtTo());
        retWtlp.setYdpCoordInfo(wtlp.getTxtYdpCoord());
        retWtlp.setDtLastUpdate(event.getDtLastUpdate());
        retWtlp.setDtEventCreated(event.getDtEventOccurred());
        retWtlp.setIdChild(wtlp.getPerson()== null? 0: wtlp.getPerson().getIdPerson());
        if (wtlp.getPersonByIdYdpCoord() != null) {
          retWtlp.setIdYdpCoord(wtlp.getPersonByIdYdpCoord().getIdPerson());
          retWtlp.setNmYdpCoord(wtlp.getPersonByIdYdpCoord().getNmPersonFull());
        }
      } catch (Exception e) {
        throw new RuntimeWrappedException(e);
      }
    }
    return retWtlp;
  }
}