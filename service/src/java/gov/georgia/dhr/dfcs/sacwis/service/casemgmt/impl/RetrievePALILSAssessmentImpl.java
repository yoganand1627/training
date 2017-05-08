package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Pal;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePALILSAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC01SO;

public class RetrievePALILSAssessmentImpl extends BaseServiceImpl implements RetrievePALILSAssessment {

  private EventDAO eventDAO = null;

  private PalDAO palDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPalDAO(PalDAO palDAO) {
    this.palDAO = palDAO;
  }

  public CCFC01SO retrieveEventStatus(CCFC01SI ccfc01si) throws ServiceException {
    CCFC01SO ccfc01so = new CCFC01SO();
    // Calling ccmn45d
    Event event = eventDAO.findEventByIdEvent(ccfc01si.getUlIdEvent());
    if (event == null) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }

    if (!CodesTables.CEVTSTAT_NEW.equals(event.getCdEventStatus())) {
      // Calling cses42d
      Pal pal = palDAO.findPal(event.getStage().getIdStage());
      if (pal == null) {
        throw new ServiceException(Messages.MSG_DETAIL_DELETED);
      }
      ccfc01so.setSzCdPalCloseLivArr(pal.getCdPalCloseLivArr());
      ccfc01so.setSzTxtPalIlNoIlsRsn(pal.getTxtPalIlNoIlsRsn());
      ccfc01so.setDtDtPalPostasmtDate(DateHelper.toCastorDate(pal.getDtPalPostasmtDate()));
      ccfc01so.setDtDtPalPreasmtDate(DateHelper.toCastorDate(pal.getDtPalPreasmtDate()));
      ccfc01so.setTsLastUpdate(pal.getDtLastUpdate());
      ccfc01so.setCIndPalIlNoIlsAssmt(pal.getIndPalIlNoIlsAssmt());
      ccfc01so.setCIndPalIlNoPoasmt_Scre(pal.getIndPalIlNoPrasmtScre());
      ccfc01so.setCIndPalIlNoPrasmtScre(pal.getIndPalIlNoPrasmtScre());
      ccfc01so.setLNbrPalPostasmtScore(pal.getNbrPalPostasmtScore() != null ? pal.getNbrPalPostasmtScore() : 0);
      ccfc01so.setLNbrPalPreasmtScore(pal.getNbrPalPreasmtScore() != null ? pal.getNbrPalPreasmtScore() : 0);
    }
    return ccfc01so;
  }
}
