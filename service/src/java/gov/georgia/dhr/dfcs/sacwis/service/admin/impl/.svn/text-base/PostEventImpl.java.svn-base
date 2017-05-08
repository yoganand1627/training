package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;//mxpatel wrote this for defect #9851
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
/**
 * This is the Conversation class used by the entire application to post events of
 * all types.  This class also creates records in event_person_link<p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/02/08  SWR       STGAP00004587 - Modified logic in updateEventPersonLink() so that when a 0 
 *                      Person ID is passed in that is ignored.
 *                      
 *  09/26/08  mxpatel   STGAP00009851 - added IF statement and some logic to make sure that only 
 *                      one row is created in the eventPersonLink table if the event type is Visitation.
 *                      The row is only created for the primary child of the stage.      
 *  03/13/09  arege     STGAP00012811 - Removed if condition added for STGAP00009851 as it was no longer
 *                      needed as the fix for STGAP00012811 fixed STGAP00009851 too.              
 * </pre>
 * 
 * 
 */

public class PostEventImpl extends BaseServiceImpl implements PostEvent {

  private ComplexEventDAO complexEventDAO = null;

  private EventDAO eventDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

//mxpatel wrote this for defect #9851
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
//mxpatel wrote this for defect #9851
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  
  public CCMN01UO postEvent(CCMN01UI ccmn01ui) throws ServiceException {
    CCMN01UO ccmn01uo = new CCMN01UO();
    String cReqFuncCd = ccmn01ui.getArchInputStruct().getCReqFuncCd();

    // if delete do the reverse of insert
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // if delete idEvent should be present
      int idEvent = ccmn01ui.getROWCCMN01UIG00().getUlIdEvent();
      updateEventPersonLink(idEvent, ccmn01ui.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY());
      // then delete Event
      audEvent(ccmn01ui.getROWCCMN01UIG00(), cReqFuncCd);

      ccmn01uo.setUlIdEvent(idEvent);
      ccmn01uo.setTsLastUpdate(null);

    } else {
      // update the event
      int idEvent = audEvent(ccmn01ui.getROWCCMN01UIG00(), cReqFuncCd);
      ccmn01uo.setUlIdEvent(idEvent);

      // Update the event_person_link table.
      updateEventPersonLink(idEvent, ccmn01ui.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY());
      
      // Need to get dtLastUpdate for the event so long as we did not just delete it.
      if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        Event event = eventDAO.findEventByIdEvent(idEvent);
        if (event != null) {
          ccmn01uo.setTsLastUpdate(event.getDtLastUpdate());
        }
        // FIXME - this else statement might not be a good idea, but in certain scenarios,
        // the DAO call above returns null, even if the event exists
        else {
          // ?? This might need to be DateHelper.MAX_JAVA_DATE instead.
          ccmn01uo.setTsLastUpdate(null);
        }
      }
    }
    return ccmn01uo;
  }

  private int audEvent(ROWCCMN01UIG00 rowccmn01UIG00, String cReqFuncCd) throws ServiceException {
    String cdEventStatus = rowccmn01UIG00.getSzCdEventStatus();
    String cdEventType = rowccmn01UIG00.getSzCdEventType();
    Date dtEventOccurred = DateHelper.toJavaDate(rowccmn01UIG00.getDtDtEventOccurred());
    int idPerson = rowccmn01UIG00.getUlIdPerson();
    int idStage = rowccmn01UIG00.getUlIdStage();
    String txtEventDescr = rowccmn01UIG00.getSzTxtEventDescr();
    String cdTask = rowccmn01UIG00.getSzCdTask();
    int idEvent = rowccmn01UIG00.getUlIdEvent();
    Date tsLastUpdate = rowccmn01UIG00.getTsLastUpdate();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // Don't set idEvent - we want to force a save.
      Event event = new Event();
      event.setCdEventType(cdEventType);
      event.setDtEventOccurred(dtEventOccurred);
      Stage stage = getPersistentObject(Stage.class, idStage);
      event.setStage(stage);
      Person person = getPersistentObject(Person.class, idPerson);
      event.setPerson(person);
      event.setCdTask(cdTask);
      event.setTxtEventDescr(txtEventDescr);
      event.setCdEventStatus(cdEventStatus);
      event.setDtLastUpdate(tsLastUpdate);
      eventDAO.saveEvent(event);
      // Return the idEvent that is created.
      idEvent = event.getIdEvent();
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd) && idPerson!=0 ) {
      int rowsUpdated = complexEventDAO.updateEventByIdEventDtLastUpdate(cdEventStatus, cdEventType, dtEventOccurred,
                                                                         idPerson, idStage, txtEventDescr, cdTask,
                                                                         idEvent, tsLastUpdate);
      if (rowsUpdated == 0 && !CodesTables.CEVNTTYP_LEG.equals(cdEventType)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd) && idPerson==0 ) {
      int rowsUpdated = complexEventDAO.updatePortalEventByIdEventDtLastUpdate(cdEventStatus, cdEventType, dtEventOccurred,
                                                                         idStage, txtEventDescr, cdTask,
                                                                         idEvent, tsLastUpdate);
      if (rowsUpdated == 0 && !CodesTables.CEVNTTYP_LEG.equals(cdEventType)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      int rowsDeleted = eventDAO.deleteEvent(idEvent, tsLastUpdate);
      if (rowsDeleted == 0) {
        // TODO - Think about throwing error message.  Leaving it w/out one for now.
      }
      
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return idEvent;
  }

  private void updateEventPersonLink(int idEvent, ROWCCMN01UIG01_ARRAY rowccmn01uig01_array) throws ServiceException {
    if (rowccmn01uig01_array == null) {
      // Nothing do do.
      return;
    }
    Enumeration rowccmn01uig01_enum = rowccmn01uig01_array.enumerateROWCCMN01UIG01();
    while (rowccmn01uig01_enum.hasMoreElements()) {
      ROWCCMN01UIG01 rowccmn01uig01 = (ROWCCMN01UIG01) rowccmn01uig01_enum.nextElement();
      String szCdScrDataAction = rowccmn01uig01.getSzCdScrDataAction();
      
      // SWR 6/2/2008 STGAP00004587 - Inserted the following condition so that if the Person ID is 0
      // none of the code will be executed.  This seems to be fine b/c the only two actions are add and delete.  This
      // also conforms to the orginal logic of Post Event as implemented in the original C Services.
      if (rowccmn01uig01.getUlIdPerson() != 0) {

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction)) {

          EventPersonLink eventPersonLink = eventPersonLinkDAO
                                                              .findEventPersonLinkByIdEventAndIdPerson(
                                                                                                       idEvent,
                                                                                                       rowccmn01uig01
                                                                                                                     .getUlIdPerson());
          // only insert if eventPersonLink record is not found
          if (eventPersonLink != null)
            continue;
          int rowsUpdated = eventPersonLinkDAO.insertEventPersonLink(idEvent, rowccmn01uig01.getUlIdPerson());
          if (rowsUpdated == 0) {
            throw new ServiceException(Messages.MSG_CMN_UPDATE_FAILED);
          }
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
          int rowsUpdated = eventPersonLinkDAO.deleteEventPersonLink(idEvent, rowccmn01uig01.getUlIdPerson(),
                                                                     rowccmn01uig01.getTsLastUpdate());
          if (rowsUpdated == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else if (ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(szCdScrDataAction)) {
          continue;
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
  }
}
