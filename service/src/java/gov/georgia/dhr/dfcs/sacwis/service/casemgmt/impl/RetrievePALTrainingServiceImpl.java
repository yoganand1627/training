package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PalService;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePALTrainingService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC10SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC10SOG00_ARRAY;

public class RetrievePALTrainingServiceImpl extends BaseServiceImpl implements RetrievePALTrainingService {

  private EventDAO eventDAO = null;

  private PalServiceDAO palServiceDAO = null;

  private StageDAO stageDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPalServiceDAO(PalServiceDAO palServiceDAO) {
    this.palServiceDAO = palServiceDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public CCFC10SO retrievePALTrainningService(CCFC10SI ccfc10si) throws ServiceException {
    CCFC10SO ccfc10so = new CCFC10SO();
    int idStage = ccfc10si.getUlIdStage();
    int idEvent = ccfc10si.getUlIdEvent();
    String eventStatus = ccfc10so.getSzCdEventStatus();

    ccfc10so.setDtWCDDtSystemDate(DateHelper.toCastorDate(new Date()));

    // Note that queries here do not cause failure, but they do prevent further execution; we return immediatly.

    // cint21dQUERYdam
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      return ccfc10so;
    }
    ccfc10so.setDtDtStageStart(DateHelper.toCastorDate(stage.getDtStageStart()));
    if (idEvent == 0) {
      // Also return if we do not have an event in the input. 
      return ccfc10so;
    }
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      return ccfc10so;
    }
    ccfc10so.setSzCdEventStatus(event.getCdEventStatus());
    ccfc10so.setTsLastUpdate(event.getDtLastUpdate());
    if (CodesTables.CEVTSTAT_NEW.equals(eventStatus)) {
      return ccfc10so;
    }
    List<PalService> palServiceList = palServiceDAO.findPalService(idStage);
    if (palServiceList == null || palServiceList.isEmpty()) {
      return ccfc10so;
    }
    ROWCCFC10SOG00_ARRAY rowCcfc10SoG00Array = new ROWCCFC10SOG00_ARRAY();
    for (Iterator<PalService> it = palServiceList.iterator(); it.hasNext();) {
      ROWCCFC10SOG00 rowCcfc10SoG00 = new ROWCCFC10SOG00();
      PalService palService = it.next();
      rowCcfc10SoG00.setUlIdPalService(palService.getIdPalService() != null ? palService.getIdPalService() : 0);
      rowCcfc10SoG00.setUlIdStage(palService.getStage().getIdStage() != null ? palService.getStage().getIdStage() : 0);
      rowCcfc10SoG00.setSzCdPalServiceCategory(palService.getCdPalServiceCatgory());
      rowCcfc10SoG00.setDtDtPalServiceDate(DateHelper.toCastorDate(palService.getDtPalServiceDate()));
      rowCcfc10SoG00.setSzCdPalServiceType(palService.getCdPalServiceType());
      rowCcfc10SoG00.setLNbrPalServiceUnits(
              palService.getNbrPalServiceUnits() != null ? palService.getNbrPalServiceUnits() : 0);
      rowCcfc10SoG00.setSzSdsPalServiceOther(palService.getSdsPalServiceOther());
      rowCcfc10SoG00.setTsLastUpdate(palService.getDtLastUpdate());
      rowCcfc10SoG00Array.addROWCCFC10SOG00(rowCcfc10SoG00);
    }
    ccfc10so.setROWCCFC10SOG00_ARRAY(rowCcfc10SoG00Array);
    return ccfc10so;
  }
}
