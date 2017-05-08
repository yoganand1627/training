package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsChecklistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsChecklistItemDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklist;
import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklistItem;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrieveServicesReferralsChecklist;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY;

public class RetrieveServicesReferralsChecklistImpl extends BaseServiceImpl
        implements RetrieveServicesReferralsChecklist {

  private static final String INV_STAGE = CodesTables.CSTAGES_INV;

  private CpsChecklistDAO cpsChecklistDAO = null;
  private CpsChecklistItemDAO cpsChecklistItemDAO = null;
  private ContactDAO contactDAO = null;
  private EventDAO eventDAO = null;

  public void setCpsChecklistDAO(CpsChecklistDAO cpsChecklistDAO) {
    this.cpsChecklistDAO = cpsChecklistDAO;
  }

  public void setcpsChecklistItemDAO(CpsChecklistItemDAO cpsChecklistItemDAO) {
    this.cpsChecklistItemDAO = cpsChecklistItemDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public CINV54SO retrieveServicesReferralsChecklist(CINV54SI cinv54si) throws ServiceException {
    CINV54SO cinv54so = new CINV54SO();
    // csesa2d
    int idEvent = cinv54si.getUlIdEvent();
    ROWCINV54SOG00 rowcinv54sog00 = retrieveCPSChecklist(idEvent);
    cinv54so.setROWCINV54SOG00(rowcinv54sog00);

    // Get the Cps check list items.
    cinv54so.setROWCINV54SOG01_ARRAY(retrieveCpsCheckListItems(idEvent));

    // Update the earliest contact date if this is the investigative stage.
    if (INV_STAGE.equals(cinv54si.getSzCdStage())) {
      // csys15d
      Date earliestDtConactOccured = contactDAO.findEarliestDtContactOccurredByIdStage(cinv54si.getUlIdStage());
      if (DateHelper.isNull(earliestDtConactOccured)) {
        throw new ServiceException(Messages.MSG_INV_NOT_BEGUN);
      }
      rowcinv54sog00.setDtDtCPSInvstDtlBegun(DateHelper.toCastorDate(earliestDtConactOccured));
    }

    // Update output with event status if the event is non-zero.
    if (idEvent != 0) {
      // ccmn45d
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if (event == null) {
        throw new ServiceException(Messages.MSG_INV_NOT_BEGUN);
      }
      cinv54so.setSzCdEventStatus(event.getCdEventStatus());
    }
    return cinv54so;
  }

  private ROWCINV54SOG00 retrieveCPSChecklist(int idEvent) {
    ROWCINV54SOG00 rowcinv54sog00 = new ROWCINV54SOG00();
    // csesa2d
    CpsChecklist cpsChecklist = cpsChecklistDAO.findCpsChecklistByIdEvent(idEvent);
    // It it not an error to find nothing, but we will throw an NPE if we do not check for null.
    if (cpsChecklist == null) {
      return rowcinv54sog00;
    }
    rowcinv54sog00.setUlIdCpsChecklist(cpsChecklist.getIdCpsChecklist() != null ? cpsChecklist.getIdCpsChecklist() : 0);
    rowcinv54sog00.setUlIdEvent(
            cpsChecklist.getEvent().getIdEvent() != null ? cpsChecklist.getEvent().getIdEvent() : 0);
    rowcinv54sog00.setUlIdCase(
            cpsChecklist.getCapsCase().getIdCase() != null ? cpsChecklist.getCapsCase().getIdCase() : 0);
    rowcinv54sog00.setTsLastUpdate(cpsChecklist.getDtLastUpdate());
    rowcinv54sog00.setDtDtFirstReferral(DateHelper.toCastorDate(cpsChecklist.getDtFirstReferral()));
    rowcinv54sog00.setCIndSvcRefChklstNoRef(cpsChecklist.getIndReferral());
    rowcinv54sog00.setSzCdFamilyResponse(cpsChecklist.getCdFamilyResp());
    rowcinv54sog00.setSzTxtChklstComments(cpsChecklist.getTxtComments());
    return rowcinv54sog00;
  }

  public ROWCINV54SOG01_ARRAY retrieveCpsCheckListItems(int idEvent) {
    ROWCINV54SOG01_ARRAY rowcinv54sog01_array = new ROWCINV54SOG01_ARRAY();
    // clss81d
    List<CpsChecklistItem> cpsCheckListItem = cpsChecklistItemDAO.findCpsCheckListItemByIdEvent(idEvent);
    // add the check list of items to the output object
    if (cpsCheckListItem == null || cpsCheckListItem.size() <= 0) {
      return rowcinv54sog01_array;
    }
    for (Iterator<CpsChecklistItem> it = cpsCheckListItem.iterator(); it.hasNext();) {
      CpsChecklistItem row = it.next();
      ROWCINV54SOG01 rowcinv54sog01 = new ROWCINV54SOG01();
      rowcinv54sog01.setUlIdChklstItem(row.getIdCpsChecklistItem() != null ? row.getIdCpsChecklistItem() : 0);
      rowcinv54sog01.setUlIdCpsChecklist(
              row.getCpsChecklist().getIdCpsChecklist() != null ? row.getCpsChecklist().getIdCpsChecklist() : 0);
      rowcinv54sog01.setSzCdSvcReferred(row.getCdSrvcReferred());
      rowcinv54sog01.setTsLastUpdate(row.getDtLastUpdate());
      rowcinv54sog01_array.addROWCINV54SOG01(rowcinv54sog01);
    }
    return rowcinv54sog01_array;
  }
}