package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveDiversionConclusionValidation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveDiversionConclusionValidationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


public class SaveDiversionConclusionValidationImpl extends BaseServiceImpl implements SaveDiversionConclusionValidation {
  
  private DynamicEventDAO dynamicEventDAO = null;
  
  private EventDAO eventDAO = null;
  
  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }


  public List<Integer> saveDiversionConclusionValidation(SaveDiversionConclusionValidationSI saveDiversionConclusionValidationSI)
                                                                                                                        throws ServiceException {
    int idStage = saveDiversionConclusionValidationSI.getIdStage();
    int idCase = saveDiversionConclusionValidationSI.getIdCase();
    String cdTask = saveDiversionConclusionValidationSI.getCdTask();
    int idEvent = saveDiversionConclusionValidationSI.getIdEvent();
    String stageReasonClosed = saveDiversionConclusionValidationSI.getCdStageReasonClosed();
    List<Integer> nbrMessageCodes = new ArrayList<Integer>(); 
    
    // This call to this method and the called method are copied in part 
    // from SaveCPSInvestigationConclusionValidation
    callServiceAuth(idStage, idCase, SVC_AUTH_CD_TASK, stageReasonClosed, nbrMessageCodes);
    
  //SMS#42496:Check if any of the events are in PEND status in FCC
    List<Event> pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(idStage, CodesTables.CEVTSTAT_PEND);
    if(pendingEvents != null && !pendingEvents.isEmpty()){
      for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
        Event pendingEvent = (Event) it.next();
        String eventType = pendingEvent.getCdEventType();
        if (!CodesTables.CEVNTTYP_CCL.equals(eventType)) { // Need to check for if it is not CCL event type as the code 
          //does stageclosure edits checks in approval mode. i.e. while saving stage closure approval 
          nbrMessageCodes.add(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE); // Cannot close stage with one or more events in PEND status         
        }
      }
    }

    return nbrMessageCodes;
  }
  
  //Calls DAOs to perform the Service Authorization validation/edit
  private List<Integer> callServiceAuth(int idStage, int idCase, String cdTask, String szCdStageReasonClosed, List<Integer> nbrMessageCodes)
          throws ServiceException {
    boolean bSvcAuthFlag = true;

    // Call DynamicEventDAO, CCMN87DA
    // retrieve all Service Authorization events for a particular IdEvent
    ROWCCMN87DO_ARRAY rowccmn87d0_array = findAuthEvents(idStage, cdTask);
    if (rowccmn87d0_array != null) {
      for (Enumeration rowccmn87d0Enum = rowccmn87d0_array.enumerateROWCCMN87DO(); rowccmn87d0Enum.hasMoreElements()
                                                                                   && bSvcAuthFlag;) {
        ROWCCMN87DO rowccmn87d0 = (ROWCCMN87DO) rowccmn87d0Enum.nextElement();
        String cdEventStatus = rowccmn87d0.getSzCdEventStatus();
        // We don't want any SvcAuths that are in PENDing status. Otherwise, the SvcAuths
        // are NEW or PROC or COMP and we don't give validation/edit checks on these
        if (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {
          bSvcAuthFlag = false;
        }
      }
    }
    if (!bSvcAuthFlag) {
      nbrMessageCodes.add(Messages.MSG_SVA_OPN_AUTHS);
    }
    return nbrMessageCodes;
  }  
  
  
  //Calls the DynamicEventDAO,CCMN87DA t retrieve event records based on the given search criteria.
  private ROWCCMN87DO_ARRAY findAuthEvents(int idStage, String cdTask) throws ServiceException {
    ROWCCMN87DO_ARRAY rowccmn87d0_array = new ROWCCMN87DO_ARRAY();
    List<Object[]> dynamicEventInfo = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0,
                                                                 null, null, cdTask, null, null, null);
    if (dynamicEventInfo != null && dynamicEventInfo.size() > 0) {
      for (Iterator<Object[]> it4 = dynamicEventInfo.iterator(); it4.hasNext();) {
        Object[] dynamicEvent = it4.next();
        ROWCCMN87DO rowccmn87d0 = new ROWCCMN87DO();
        rowccmn87d0.setSzCdEventStatus((String) dynamicEvent[0]);
        rowccmn87d0.setSzCdEventType((String) dynamicEvent[1]);
        rowccmn87d0.setDtDtEventOccurred(DateHelper.toCastorDate((Date) dynamicEvent[3]));
        rowccmn87d0.setUlIdEvent((Integer) dynamicEvent[6] != null ? (Integer) dynamicEvent[6] : 0);
        rowccmn87d0.setSzTxtEventDescr((String) dynamicEvent[10]);
        rowccmn87d0.setSzCdTask((String) dynamicEvent[11]);
        rowccmn87d0_array.addROWCCMN87DO(rowccmn87d0);
      }
    }

    return rowccmn87d0_array;
  }
  
}
