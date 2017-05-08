package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.RiskFactors;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrieveRiskFactors;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV51SOG01_ARRAY;

public class RetrieveRiskFactorsImpl extends BaseServiceImpl implements RetrieveRiskFactors {

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  private RiskFactorsDAO riskFactorsDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private EventDAO eventDAO = null;

  public void setRiskFactorsDAO(RiskFactorsDAO riskFactorsDAO) {
    this.riskFactorsDAO = riskFactorsDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public CINV51SO retrieveRiskFactors(CINV51SI cinv51si) throws ServiceException {
    CINV51SO cinv51so = new CINV51SO();
    int idEvent = cinv51si.getUlIdEvent();
    if (idEvent == 0) {
      // This is not an error, but nothing is done in this case.
      return cinv51so;
    }
    ROWCCMN01UIG00 rowccmn01uig00 = retrieveEventDetails(idEvent);
    cinv51so.setROWCCMN01UIG00(rowccmn01uig00);

    ROWCINV51SOG01_ARRAY rowcinv51sog01_array;
    if (ArchitectureConstants.Y.equals(cinv51si.getBSysIndWinDataChg()) &&
        !EVENT_STATUS_NEW.equals(rowccmn01uig00.getSzCdEventStatus())) {
      rowcinv51sog01_array = retrieveRiskFactors(idEvent, cinv51si.getUlIdPerson());
    } else {
      rowcinv51sog01_array = new ROWCINV51SOG01_ARRAY();
    }
    cinv51so.setROWCINV51SOG01_ARRAY(rowcinv51sog01_array);

    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    if (!EVENT_STATUS_NEW.equals(rowccmn01uig00.getSzCdEventStatus())) {
      // ccmnd2d
      List<EventPersonLink> eventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idEvent);
      if (eventPersonLinkList == null || eventPersonLinkList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      for (Iterator<EventPersonLink> it = eventPersonLinkList.iterator(); it.hasNext();) {
        EventPersonLink eventPersonLink = it.next();
        ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
        rowccmn01uig01.setUlIdPerson(
                eventPersonLink.getPerson().getIdPerson() != null ? eventPersonLink.getPerson().getIdPerson() : 0);
        rowccmn01uig01.setTsLastUpdate(eventPersonLink.getDtLastUpdate());
        rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      }
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    return cinv51so;
  }

  private ROWCINV51SOG01_ARRAY retrieveRiskFactors(int idEvent, int idPerson) {
    // cinv65d
    List<RiskFactors> riskFactorsList =
            riskFactorsDAO.findRiskFactorsByIdEventAndIdPerson(idEvent, idPerson);
    ROWCINV51SOG01_ARRAY rowcinv51g01_array = new ROWCINV51SOG01_ARRAY();
    // An empty or null risk factors list is not an error.
    if (riskFactorsList != null) {
      for (Iterator<RiskFactors> it = riskFactorsList.iterator(); it.hasNext();) {
        RiskFactors riskFactor = it.next();
        ROWCINV51SOG01 rowcinv51sog01 = new ROWCINV51SOG01();
        rowcinv51sog01.setTsLastUpdate(riskFactor.getDtLastUpdate());
        rowcinv51sog01.setUlIdRiskFactor(riskFactor.getIdRiskFactor() != null ? riskFactor.getIdRiskFactor() : 0);
        rowcinv51sog01.setSzCdRiskFactor(riskFactor.getCdRiskFactor());
        rowcinv51sog01.setSzCdRiskFactorResponse(riskFactor.getCdRiskFactorResponse());
        rowcinv51sog01.setSzCdRiskFactorCateg(riskFactor.getCdRiskFactorCateg());
        rowcinv51sog01.setTxtRiskFactorComment(riskFactor.getTxtRiskFactorComment());
        rowcinv51g01_array.addROWCINV51SOG01(rowcinv51sog01);
      }
    }
    return rowcinv51g01_array;
  }

  private ROWCCMN01UIG00 retrieveEventDetails(int idEvent) throws ServiceException {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn01uig00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn01uig00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn01uig00.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    return rowccmn01uig00;
  }
}
