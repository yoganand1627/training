package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePPT;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB29SOG01;

import java.util.Date;

public class RetrievePPTImpl extends BaseServiceImpl implements RetrievePPT {

  private static final String NEW = CodesTables.CEVTSTAT_NEW;

  private static final String PPT_NARR = "PPT_NARR";

  private static final String FALSE = ArchitectureConstants.FALSE;

  private static final String TRUE = ArchitectureConstants.TRUE;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private EventDAO eventDAO = null;
  private PptDAO pptDAO = null;

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) throws ServiceException {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) throws ServiceException {
    this.eventDAO = eventDAO;
  }

  public void setPptDAO(PptDAO pptDAO) throws ServiceException {
    this.pptDAO = pptDAO;
  }

  public CSUB29SO retrievePPT(CSUB29SI csub29si) throws ServiceException {
    CSUB29SO csub29so = new CSUB29SO();
    int idEventSI = csub29si.getUlIdEvent();
    ROWCSUB29SOG01 rowcsub29sog01 = new ROWCSUB29SOG01();

    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEventSI);

    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    rowcsub29sog01.setSzCdEventType(event.getCdEventType());
    rowcsub29sog01.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowcsub29sog01.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowcsub29sog01.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowcsub29sog01.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowcsub29sog01.setSzTxtEventDescr(event.getTxtEventDescr());
    rowcsub29sog01.setSzCdTask(event.getCdTask());
    rowcsub29sog01.setSzCdEventStatus(event.getCdEventStatus());
    rowcsub29sog01.setTsLastUpdate(event.getDtLastUpdate());

    String eventStatusSO = rowcsub29sog01.getSzCdEventStatus();
    if (!(NEW.equals(eventStatusSO))) {
      int idPptEvent = idEventSI;
      CSUB29SOG00 csub29sog00 = new CSUB29SOG00();
      // cses14d
      Ppt ppt = pptDAO.findPpt(idPptEvent);
      if (ppt == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      if (approvalEventLinkDAO.findApprovalEventLinkByIdEvent(idEventSI) != null) {
        csub29sog00.setSzApprovalStatus(ArchitectureConstants.TRUE);
      } else {
        csub29sog00.setSzApprovalStatus(ArchitectureConstants.FALSE);
      }

      String dateDisplay = "";
      if (ppt.getDtPptDate() != null) {
        dateDisplay = ppt.getDtPptDate().toString();
      }
      try {

        Integer idContactStdsEvent = 0;
        ContactStandards cs = ppt.getContactStandards();
        /*
         * Pull the ID for ContactStandards from the
         * database. If not found, see if one was
         * passed in.
         */
        if (cs != null) {
          idContactStdsEvent = cs.getIdContactStdsEvent(); 
        } else {
          idContactStdsEvent = csub29si.getUlIdContactStdsEvent();
        }
        csub29sog00.setUlIdContactStdsEvent(idContactStdsEvent);
        csub29sog00.setSzAddrPptCity(ppt.getAddrPptCity());
        csub29sog00.setSzAddrPptCnty(ppt.getAddrPptCnty());
        csub29sog00.setSzAddrPptStLn1(ppt.getAddrPptStLn1());
        csub29sog00.setSzAddrPptStLn2(ppt.getAddrPptStLn2());
        csub29sog00.setSzAddrPptState(ppt.getAddrPptState());
        csub29sog00.setSzAddrPptZip(ppt.getAddrPptZip());
        csub29sog00.setSzNbrPptPhone(ppt.getNbrPptPhone());
        csub29sog00.setSzTxtPptAddrCmnt(ppt.getTxtPptAddrCmnt());
        csub29sog00.setSzMeetingType(ppt.getCdPptType());
        csub29sog00.setBIndAssistNeeded(ppt.getIndAhAsstNeeded());
        csub29sog00.setDtDateHearingReq(DateHelper.toCastorDate(ppt.getDtAhRequested()));
        csub29sog00.setDtOutcomeDiscussed(DateHelper.toCastorDate(ppt.getDtAhOutcome()));
        csub29sog00.setUlIdPptEvent(ppt.getIdPptEvent() != null ? ppt.getIdPptEvent() : 0);
        csub29sog00.setDtDatePrepIntvw(DateHelper.toCastorDate(ppt.getDtDatePrepIntvw()));
        csub29sog00.setDtPermRepComp(DateHelper.toCastorDate(ppt.getDtPermRepComp()));
        csub29sog00.setDtUtilBeginDate(DateHelper.toCastorDate(ppt.getDtUrBegin()));
        csub29sog00.setDtUtilEndDate(DateHelper.toCastorDate(ppt.getDtUrEnd()));
        csub29sog00.setDtDtPptDate(DateHelper.toCastorDate(ppt.getDtPptDate()));
        csub29sog00.setBIndPermanency(ppt.getIndMdtPerm());
        csub29sog00.setBIndPrevReqMet(ppt.getIndFtmReqMet());
        csub29sog00.setBIndSafety(ppt.getIndMdtSfty());
        csub29sog00.setBIndWellbeing(ppt.getIndMdtWlbng());
        csub29sog00.setLNbrPptPhoneExt(ppt.getNbrPptPhoneExt());
        csub29sog00.setTsLastUpdate(ppt.getDtLastUpdate());
        csub29sog00.setBIndTranPlanComp(ppt.getIndTranPlanComp());
        if (dateDisplay.contains(":")) {
          csub29sog00.setTmScrTmPptTime(FormattingHelper.formatTime(ppt.getDtPptDate()));
        }

        csub29so.setCSUB29SOG00(csub29sog00);
      } catch (Exception e) {
        throw new RuntimeWrappedException(e);
      }
      // Check if Document Exists
      //String tableName = PPT_NARR;
      String tableName = TEAM_MEET_REVIEW_NARRATIVE;

      // csys06d
      Date lastUpdate = commonDAO.findDtLastUpdate(tableName, idEventSI);
      if (DateHelper.isNull(lastUpdate)) {
        csub29so.setBIndBLOBExistsInDatabase(FALSE);
      } else {
        csub29so.setBIndBLOBExistsInDatabase(TRUE);
      }
    }
    csub29so.setROWCSUB29SOG01(rowcsub29sog01);
    return csub29so;
  }

}

