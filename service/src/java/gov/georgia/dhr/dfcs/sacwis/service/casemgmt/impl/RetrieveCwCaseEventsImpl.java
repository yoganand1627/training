//*  Service Class  Name:     RetrieveCwCaseEventsImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch case events.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwCaseEvents;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwCaseEventBean;

import gov.georgia.dhr.dfcs.sacwis.dao.CwUpcomingCaseEventsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CwUpcomingEvents;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class RetrieveCwCaseEventsImpl extends BaseServiceImpl implements RetrieveCwCaseEvents {

  private CwUpcomingCaseEventsDAO cwUpcomingCaseEventsDAO = null;
  
  public void setCwUpcomingCaseEventsDAO(CwUpcomingCaseEventsDAO cwUpcomingCaseEventsDAO) {
    this.cwUpcomingCaseEventsDAO = cwUpcomingCaseEventsDAO;
  }
  
  
  @SuppressWarnings("unchecked")
  /**
   * retrieveCwCaseEvents retrieves all information necessary for displaying case event data on the Case Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwCaseEventsSO object.
   */
  public CwCaseEventsSO retrieveCwCaseEvents(CaseWatchSI caseWatchSI) {

    CwCaseEventsSO cwCaseEventsSO = new CwCaseEventsSO();
    List<CwCaseEventBean> events = new ArrayList<CwCaseEventBean>();
    List<CwUpcomingEvents> eventsList = new ArrayList<CwUpcomingEvents>();
    
    eventsList = cwUpcomingCaseEventsDAO.findUpcomingEventsByStageID(caseWatchSI.getIdStage());
    
    if ((eventsList!=null) && !(eventsList.isEmpty())){
      
      for (Iterator<CwUpcomingEvents> it = eventsList.iterator(); it.hasNext();) {

        CwUpcomingEvents eventDb = it.next();
        CwCaseEventBean event = new CwCaseEventBean();
        
        event.setDueDate(eventDb.getDtDue());
        event.setDaysUntilDue(eventDb.getNbrDaysUntilDue()!=null ? eventDb.getNbrDaysUntilDue() : 0);
        event.setEventDescription(eventDb.getTxtEvent()!=null ? eventDb.getTxtEvent():"");
        event.setUlIdEvent(eventDb.getEvent()!=null ? eventDb.getEvent().getIdEvent() :0); 
        event.setIndError(eventDb.getIndError()!=null ? eventDb.getIndError() :"");
        
        events.add(event);
      }
    }
    
    cwCaseEventsSO.setEvents(events);
    
    return cwCaseEventsSO;
  }

}
