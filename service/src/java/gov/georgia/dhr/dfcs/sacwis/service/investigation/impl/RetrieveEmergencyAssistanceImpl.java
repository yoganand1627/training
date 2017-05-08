package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmergencyAssistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.EmergencyAssist;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveEmergencyAssistance;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG01;

public class RetrieveEmergencyAssistanceImpl extends BaseServiceImpl implements RetrieveEmergencyAssistance {

  private DynamicEventDAO dynamicEventDAO = null;
  private EventDAO eventDAO = null;
  private EmergencyAssistDAO emergencyAssistDAO = null;
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEmergencyAssistDAO(EmergencyAssistDAO emergencyAssistDAO) {
    this.emergencyAssistDAO = emergencyAssistDAO;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public CINV11SO retrieveEmergencyAssistance(CINV11SI cinv11si) throws ServiceException {
    CINV11SO cinv11so = new CINV11SO();
    int idEvent = findPendingCCLEvent(cinv11si.getUlIdStage());
    cinv11so.setUlIdEvent(idEvent);
    if (cinv11si.getUlIdEvent() != 0) {
      cinv11so.setROWCCMN45DO(retieveEventDetails(cinv11si.getUlIdEvent()));
      cinv11so.setROWCINV11SOG00_ARRAY(retrieveEmergencyAssistList(cinv11si.getUlIdEvent()));
    } else { // add the array to the output object with at least 3 empty elements to it to handle the 3 EA eligibility options
      ROWCINV11SOG00_ARRAY rowcinv11sog00_array = new ROWCINV11SOG00_ARRAY();
      rowcinv11sog00_array.setUlRowQty(0);
      cinv11so.setROWCINV11SOG00_ARRAY(rowcinv11sog00_array);
    }

    cinv11so.setROWCINV11SOG01(retrieveCpsInvstDetail(cinv11si.getUlIdStage()));
    return cinv11so;
  }

  private int findPendingCCLEvent(int idStage) throws ServiceException {
    String[] cdEventTypes = new String[] {CodesTables.CEVNTTYP_CCL};
    // ccmn87d
    List<Object[]> objectList =
            dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, cdEventTypes, null, null, null, null, null);
    if (objectList == null || objectList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    Object[] firstElement = objectList.get(0);
    String cdEventStatus = (String) firstElement[0];
    if (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {
      return (Integer) firstElement[6];
    } else {
      return 0;
    }
  }

  private ROWCCMN45DO retieveEventDetails(int idEvent) throws ServiceException {
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    Integer idEvent2 = event.getIdEvent();
    rowccmn45do.setUlIdEvent(idEvent2 != null ? idEvent2 : 0);
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());

    return rowccmn45do;
  }

  private ROWCINV11SOG00_ARRAY retrieveEmergencyAssistList(int idEvent) {
    // cinv15d
    List<EmergencyAssist> emergencyAssistList = emergencyAssistDAO.findEmergencyAssistByIdEvent(idEvent);
    ROWCINV11SOG00_ARRAY rowcinv11sogoo_array = new ROWCINV11SOG00_ARRAY();
    if (emergencyAssistList == null || emergencyAssistList.isEmpty()) {
      // No results is not an error.
      return rowcinv11sogoo_array;
    }
    for (Iterator it = emergencyAssistList.iterator(); it.hasNext();) {
      EmergencyAssist eAssist = (EmergencyAssist) it.next();
      ROWCINV11SOG00 row = new ROWCINV11SOG00();
      //row.setSzCdEaQuestion(eAssist.getCdEaQuestion());
      Integer idEmergencyAssist = eAssist.getIdEmergencyAssist();
      row.setUlIdEmergencyAssist(idEmergencyAssist != null ? idEmergencyAssist : 0);
      //row.setBIndEaResponse(eAssist.getIndEaResponse());
      row.setTsLastUpdate(eAssist.getDtLastUpdate());
      rowcinv11sogoo_array.addROWCINV11SOG00(row);
    }
    rowcinv11sogoo_array.setUlRowQty(emergencyAssistList.size());
    return rowcinv11sogoo_array;
  }

  private ROWCINV11SOG01 retrieveCpsInvstDetail(int idStage) throws ServiceException {
    // cinv95d
    CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    if (cpsInvstDetail == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCINV11SOG01 rowcinv11sog01 = new ROWCINV11SOG01();
    Integer idEvent = cpsInvstDetail.getEvent().getIdEvent();
    rowcinv11sog01.setUlIdEvent(idEvent != null ? idEvent : 0);
    rowcinv11sog01.setSzCdCpsInvstDtlFamIncm(cpsInvstDetail.getCdCpsInvstDtlFamIncm());
    rowcinv11sog01.setCdCpsOverallDisptn(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn());
    rowcinv11sog01.setDtDtCPSInvstDtlAssigned(DateHelper.toCastorDate(cpsInvstDetail.getDtCpsInvstDtlAssigned()));
    rowcinv11sog01.setDtDtCPSInvstDtlBegun(DateHelper.toCastorDate(cpsInvstDetail.getDtCpsInvstDtlBegun()));
    rowcinv11sog01.setDtDtCpsInvstDtlComplt(DateHelper.toCastorDate(cpsInvstDetail.getDtCpsInvstDtlComplt()));
    rowcinv11sog01.setDtDtCPSInvstDtlIntake(cpsInvstDetail.getDtCpsInvstDtlIntake());
    Integer idStage2 = cpsInvstDetail.getStage().getIdStage();
    rowcinv11sog01.setUlIdStage(idStage2 != null ? idStage2 : 0);
    rowcinv11sog01.setBIndCpsInvstEaConcl(cpsInvstDetail.getIndCpsInvstDtlEaConcl());
    rowcinv11sog01.setBIndCpsInvstSafetyPln(cpsInvstDetail.getIndCpsInvstSafetyPln());
    rowcinv11sog01.setCIndCpsInvstDtlRaNa(cpsInvstDetail.getIndCpsInvstDtlRaNa());
    rowcinv11sog01.setCIndCpsInvstAbbrv(cpsInvstDetail.getIndCpsInvstDtlAbbrv());
    rowcinv11sog01.setTsLastUpdate(cpsInvstDetail.getDtLastUpdate());
    return rowcinv11sog01;
  }
}
