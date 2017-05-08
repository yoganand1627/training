package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalFollowUpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalPublicAssistDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.PalFollowUp;
import gov.georgia.dhr.dfcs.sacwis.db.PalPublicAssist;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePALFollowup;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC07SOG00_ARRAY;

public class RetrievePALFollowupImpl extends BaseServiceImpl implements RetrievePALFollowup {

  private EventDAO eventDAO = null;

  private PalFollowUpDAO palFollowUpDAO = null;

  private PalPublicAssistDAO palPublicAssistDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPalFollowUpDAO(PalFollowUpDAO palFollowUpDAO) {
    this.palFollowUpDAO = palFollowUpDAO;
  }

  public void setPalPublicAssistDAO(PalPublicAssistDAO palPublicAssistDAO) {
    this.palPublicAssistDAO = palPublicAssistDAO;
  }

  public CCFC07SO retrievePALFollowup(CCFC07SI ccfc07si) throws ServiceException {
    CCFC07SO ccfc07so = new CCFC07SO();

    // ccmn45dQUERYdam
    Event event = eventDAO.findEventByIdEvent(ccfc07si.getUlIdEvent());

    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ccfc07so.setSzCdEventStatus(event.getCdEventStatus());
    ccfc07so.setTsSysTsLastUpdate2(event.getDtLastUpdate());

    if (!CodesTables.CEVTSTAT_NEW.equals(ccfc07so.getSzCdEventStatus())) {

      // cses48dQUERYdam
      PalFollowUp palFollowUp = palFollowUpDAO.findPalFollowUpByIdStage(ccfc07si.getUlIdStage());
      if (palFollowUp == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      ccfc07so.setSzCdPalFollupEducStat(palFollowUp.getCdPalFollupEducStat());
      ccfc07so.setSzCdPalFollupEmployed(palFollowUp.getCdPalFollupEmployed());
      ccfc07so.setSzCdPalFollupLivArr(palFollowUp.getCdPalFollupLivArr());
      ccfc07so.setSzCdPalFollupMarital(palFollowUp.getCdPalFollupMarital());
      ccfc07so.setSzCdPalFollupHighestEdu(palFollowUp.getCdPalFollupHighestEdu());
      ccfc07so.setUCdPalFollupReunified(palFollowUp.getCdPalFollupReunified());
      ccfc07so.setDtDtPalFollupDate(DateHelper.toCastorDate(palFollowUp.getDtPalFollupDate()));
      ccfc07so.setCIndPalFollupNoPubAst(palFollowUp.getIndPalFollupNoPubAst());
      ccfc07so.setCIndPalFollupNotLocate(palFollowUp.getIndPalFollupNotLocate());
      ccfc07so.setLNbrPalFollupNumChldrn(
              palFollowUp.getNbrPalFollupNumChldrn() != null ? palFollowUp.getNbrPalFollupNumChldrn() : 0);

      if (ArchitectureConstants.N.equals(palFollowUp.getIndPalFollupNoPubAst()) &&
          ArchitectureConstants.N.equals(palFollowUp.getIndPalFollupNotLocate())) {

        //clss40dQUERYdam
        List<PalPublicAssist> palPublicAssistList = palPublicAssistDAO.findPalPublicAssist(ccfc07si.getUlIdStage());
        if (palPublicAssistList == null || palPublicAssistList.isEmpty()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        // Set fields in CCFC07SO to fields in CLSS40DO
        // Retrieve all applicable Public Assist types from the PAL PUBLIC ASSIST table until there are no more rows
        ROWCCFC07SOG00_ARRAY rowCcfc07SoG00Array = new ROWCCFC07SOG00_ARRAY();
        for (Iterator<PalPublicAssist> it = palPublicAssistList.iterator(); it.hasNext();) {
          PalPublicAssist palPublicAssist = it.next();
          ROWCCFC07SOG00 rowCcfc07SoG00 = new ROWCCFC07SOG00();
          rowCcfc07SoG00.setSzCdPalPublicAssist(palPublicAssist.getId().getCdPalPublicAssist());
          rowCcfc07SoG00Array.addROWCCFC07SOG00(rowCcfc07SoG00);
        }
        ccfc07so.setROWCCFC07SOG00_ARRAY(rowCcfc07SoG00Array);
      }
    }
    return ccfc07so;
  }
}
