package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveChangeStageType;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB63SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO;

public class RetrieveChangeStageTypeImpl extends BaseServiceImpl implements RetrieveChangeStageType {

  private StageDAO stageDAO = null;
  private EventDAO eventDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public CSUB63SO retrieveChangeStageType(CSUB63SI csub63si) throws ServiceException {

    CSUB63SO csub63so = new CSUB63SO();

    csub63so.getCSUB63SOG01().setSzCdEventStatus(CodesTables.CEVTSTAT_NEW);
    //rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
    Stage stageInfo = stageDAO.findStageByIdStage(csub63si.getUlIdStage());

    if (stageInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    csub63so.getCSUB63SOG00().setTsLastUpdate(stageInfo.getDtLastUpdate());
    csub63so.getCSUB63SOG00().setSzCdStageType(stageInfo.getCdStageType());
    csub63so.getCSUB63SOG00().setSzCdStage(stageInfo.getCdStage());
    if (0 != csub63si.getUlIdEvent()) {
      //rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
      Event eventInfo = eventDAO.findEventByIdEvent(csub63si.getUlIdEvent());

      if (eventInfo == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      csub63so.getCSUB63SOG01().setUlIdEvent(eventInfo.getIdEvent() != null ? eventInfo.getIdEvent() : 0);
      csub63so.getCSUB63SOG01().setTsLastUpdate(eventInfo.getDtLastUpdate());
      csub63so.getCSUB63SOG01().setUlIdStage(
              eventInfo.getStage().getIdStage() != null ? eventInfo.getStage().getIdStage() : 0);
      csub63so.getCSUB63SOG01().setUlIdPerson(
              eventInfo.getPerson().getIdPerson() != null ? eventInfo.getPerson().getIdPerson() : 0);
      csub63so.getCSUB63SOG01().setSzCdTask(eventInfo.getCdTask());
      csub63so.getCSUB63SOG01().setSzCdEventType(eventInfo.getCdEventType());
      csub63so.getCSUB63SOG01().setSzTxtEventDescr(eventInfo.getTxtEventDescr());
      csub63so.getCSUB63SOG01().setDtDtEventOccurred(DateHelper.toCastorDate(eventInfo.getDtEventOccurred()));
      csub63so.getCSUB63SOG01().setSzCdEventStatus(eventInfo.getCdEventStatus());
    }
    return csub63so;
  }

}
