package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactFor;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.common.DeleteContactStandards;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactStandardsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Herve Jean-Baptiste February 21, 2010
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/21/2010   hjbaptiste               Add business logic for deleting a Contact Standards
 *   02/28/2010   swroberts                Commented out call to postEvent
 *   03/18/2010   bgehlot                  Added the code to check for the PPT. If it exists and set null in for 
 *                                         idContactStdEvent in PPT table
 * </pre>
 * 
 */

public class DeleteContactStandardsImpl extends BaseServiceImpl implements DeleteContactStandards {
  private static final String CHILD = CodesTables.CPARROLE_CHL;

  private ContactStandardsDAO contactStandardsDAO = null; 
  private ContactRuleDAO contactRuleDAO = null;
  private ContactForDAO contactForDAO = null;
  private EventDAO eventDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private PostEvent postEvent = null;
  private PptDAO pptDAO = null;

  public void setContactStandardsDAO(ContactStandardsDAO contactStandardsDAO) {
    this.contactStandardsDAO = contactStandardsDAO;
  }

  public void setContactRuleDAO(ContactRuleDAO contactRuleDAO) {
    this.contactRuleDAO = contactRuleDAO;
  }

  public void setContactForDAO(ContactForDAO contactForDAO) {
    this.contactForDAO = contactForDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
  
  public void setPptDAO(PptDAO pptDAO) throws ServiceException {
    this.pptDAO = pptDAO;
  }

  public void deleteContactStandards(ContactStandardsSaveSI contactStandardsSaveSI) throws ServiceException {
    int idEvent = contactStandardsSaveSI.getIdEvent();
    ContactStandards deleteContactStandards = contactStandardsDAO.findContactStandardsByIdEvent(idEvent);
    
    Iterator<ContactRule> deleteContactRuleList_it = null;
    List<ContactRule> deleteContactRuleList = contactRuleDAO.findAllContactRulesByIdEvent(idEvent);
    if (deleteContactRuleList != null && !deleteContactRuleList.isEmpty()) {
      deleteContactRuleList_it = deleteContactRuleList.iterator();
    
      while (deleteContactRuleList_it.hasNext()){
        ContactRule deleteContactRule = deleteContactRuleList_it.next();
        String cdPersonRole = deleteContactRule.getCdPersonRole();
        if (!CHILD.equals(cdPersonRole)) {
          Iterator<ContactFor> deleteContactForList_it = null;
          List<ContactFor> deleteContactForList = contactForDAO.findContactForByIdContactRule(deleteContactRule.getIdContactRule());
          if (deleteContactForList != null && !deleteContactForList.isEmpty()) {
            deleteContactForList_it = deleteContactForList.iterator();
            while (deleteContactForList_it.hasNext()){
              ContactFor deleteContactFor = deleteContactForList_it.next();
              contactForDAO.deleteContactFor(deleteContactFor);
            }
          }
        }
        contactRuleDAO.deleteContactRule(deleteContactRule);
      }
    }
    
    //Get the PPT for that Contact standard Event
    Ppt ppt = pptDAO.findPptByIdContactStdsEvent(idEvent);
    
    //Set null for idContactStdEvent in PPT table
    if(ppt != null){
      pptDAO.updatePPTByIdContactStdEvent(idEvent);
    }
    
    contactStandardsDAO.deleteContactStandards(deleteContactStandards);
    
    List<EventPersonLink> deleteEventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idEvent);
    
    //  Commented out the following call since it wasn't deleting in order when
    //  committed to the database.  Will remove later after more testing.
    //  callPostEvent(contactStandardsSaveSI, deleteEventPersonLinkList);
    
  }
  
  /**
   * Deletes the event for Contact Standards
   * 
   * @param 
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(ContactStandardsSaveSI contactStandardsSaveSI , List<EventPersonLink> deleteEventPersonLinkList) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = StringHelper.EMPTY_STRING;
    int idEvent = contactStandardsSaveSI.getIdEvent();
    Date dtEventOccurred = null;
    Date dtEventLastUpdated = null;
    String eventStatus = contactStandardsSaveSI.getCdEventStatus();
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CSS);
    rowccmn01uig00.setSzCdTask(contactStandardsSaveSI.getCdTask());
    rowccmn01uig00.setUlIdPerson(contactStandardsSaveSI.getIdPerson());
    rowccmn01uig00.setUlIdStage(contactStandardsSaveSI.getIdStage());
    rowccmn01uig00.setUlIdEvent(contactStandardsSaveSI.getIdEvent());

    if(idEvent != 0){
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if(event != null){
        dtEventLastUpdated = event.getDtLastUpdate();
        rowccmn01uig00.setTsLastUpdate(dtEventLastUpdated);
        dtEventOccurred = event.getDtEventOccurred();
        if (deleteEventPersonLinkList != null && !deleteEventPersonLinkList.isEmpty()) {
          Iterator<EventPersonLink> deleteEventPersonLinkList_it = deleteEventPersonLinkList.iterator();
          while (deleteEventPersonLinkList_it.hasNext()) {
            EventPersonLink deleteEventPersonLink = deleteEventPersonLinkList_it.next();
            Person person = deleteEventPersonLink.getPerson();
            ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
            rowccmn01uig01.setUlIdPerson(person.getIdPerson()); 
            rowccmn01uig01.setSzCdScrDataAction(contactStandardsSaveSI.getCdReqAction());
            rowccmn01uig01.setTsLastUpdate(dtEventLastUpdated);
            rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          }
        }
      }
    }
    if (!DateHelper.isNull(dtEventOccurred) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }
    
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(contactStandardsSaveSI.getCdReqAction());
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }

}
