package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactPrivConverCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.FacilityInvstDtl;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;
import gov.georgia.dhr.dfcs.sacwis.service.common.ContactDetailRetrieve;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS08SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWDISCUSSEDSO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWPRIVCONVERSO_ARRAY;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/** 
 * Change History:
 *  Date        User              Description
 *  --------    ----------------  --------------------------------------------------
 *  07/16/2008  alwilliams        STGAP00007036: Added code  in the contact retrieval 
 *                                date conversion process (method contactDetailRetrieve
 *                                of class ContactDetailRetrieveImpl) to detect the 
 *                                time from 12:00 to 12:59 and process as PM. If the 
 *                                results of subtracting 12 from the hours section of 
 *                                the 24 hour clock time is zero then the time is between 
 *                                12:00pm and 12:59pm
 * 03/10/2009    arege            STGAP00011640 Modified code to set Intake Start Date in  csys08so
 *                                object. 
 * 06/26/2009    arege            STGAP00014326 MR-024 Changes.        
 * 07/30/2009    arege            STGAP00014857 CaseWorkers with SAU Sealed Attribute should be able to add and modify
 *                                contacts                                                
 * 08/16/10      bgehlot          66380 MR072 Add new field Discussed/In Reference to
 * 03/28/12		 cminor			  STGAP00016837:  Added additional check for if user is copying an existing CONTACT to edit.  If copying
 * 							   	  then CONTACT creator is replace with currently logged in user for creation of the new CONACT record.
 * 04/09/12	 	 cminor	          STGAP00018101: Changed DAO call to use overloaded method created for STGAP00016837 to correct Logged in user
 * 								  name and Logged in User title
 *  
 *
 */

public class ContactDetailRetrieveImpl extends BaseServiceImpl implements ContactDetailRetrieve {

  public static final String NARRATIVE_TXT_DESCR = "NARRATIVE";

  private EventPersonLinkDAO eventPersonLinkDAO;
  private CapsResourceDAO capsResourceDAO = null;
  private ContactDAO contactDAO = null;
  private ContactCbxDAO contactCbxDAO = null;
  private ContactPrivConverCbxDAO contactPrivConverCbxDAO = null;
  private PersonDAO personDAO = null;
  private StageDAO stageDAO = null;
  private EventDAO eventDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private DynamicContactDAO dynamicContactDAO = null;
  private DynamicEventDAO dynamicEventDAO = null;
  private FacilityInvstDtlDAO facilityInvstDtlDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  private EmpJobHistoryDAO empJobHistoryDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;
  private TCMClaimDAO tcmClaimDAO = null;
  private PortalUserDAO portalUserDAO = null;
  private ContactDiscussedCbxDAO contactDiscussedCbxDAO = null;
  
  private int copyId = 0;
  private String copyFullName = null;

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  } 
  
  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setContactCbxDAO(ContactCbxDAO contactCbxDAO) {
    this.contactCbxDAO = contactCbxDAO;
  }

  public void setContactPrivConverCbxDAO(ContactPrivConverCbxDAO contactPrivConverCbxDAO) {
    this.contactPrivConverCbxDAO = contactPrivConverCbxDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setDynamicContactDAO(DynamicContactDAO dynamicContactDAO) {
    this.dynamicContactDAO = dynamicContactDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setFacilityInvstDtlDAO(FacilityInvstDtlDAO facilityInvstDtlDAO) {
    this.facilityInvstDtlDAO = facilityInvstDtlDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }
  
  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }
  
  public void setTcmClaimDAO(TCMClaimDAO tcmClaimDAO) {
    this.tcmClaimDAO = tcmClaimDAO;
  }
  
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }
  
  public void setContactDiscussedCbxDAO(ContactDiscussedCbxDAO contactDiscussedCbxDAO) {
    this.contactDiscussedCbxDAO = contactDiscussedCbxDAO;
  }

  /**
   *   STGAP00016837:  Added method to replace creator information with currently logged in user on copied CONTACTS
   */
  public CSYS08SO contactDetailRetrieve(CSYS08SI csys08si, int copyId, String copyFullName) throws ServiceException {
	  this.copyId = copyId;
	  this.copyFullName = copyFullName;
	  return contactDetailRetrieve(csys08si);
  }
  public CSYS08SO contactDetailRetrieve(CSYS08SI csys08si) throws ServiceException {
    CSYS08SO csys08so = new CSYS08SO();
    int idStage = csys08si.getUlIdStage();
    int idEvent = csys08si.getUlIdEvent();
    String eventStatus = new String();
    Integer idUser = null;
    
    // Sometime one can be in one stage and look for a contact in another stage. So the stage id must belong
    // to the contact you are searching for in the stage the contact was created in
    if ( idEvent != 0 ){
      Event originalEvent = eventDAO.findEventByIdEvent(idEvent);
      if (originalEvent == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      idStage = originalEvent.getStage().getIdStage();      
    }

    // Retrieve stage closed date
    // cinv21d
    Stage stage = stageDAO.findStageByIdStage(idStage);
    Date dtTempDTStageStart = null;
    if (stage != null) {
      csys08so.setSzCdStage(stage.getCdStage());
      csys08so.setSzCdStageProgram(stage.getCdStageProgram());
      csys08so.setSzCdStageClassification(stage.getCdStageClassification());
      csys08so.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
      dtTempDTStageStart = stage.getDtStageStart();
    }

    // Search for structured narrative if it exists
    // csys04d
    csys08so.setBScrIndStructNarrExists(callDynamicContactDAO(idStage, dtTempDTStageStart));

    // Populate possible Principal/Collaterals Contacted
    // cinv34d
    csys08so.setROWCSYS08SO_ARRAY(callStagePersonLinkDAO(idStage));

    if (0 != idEvent) {
      // Retrieve the INITDATA given Event record
      // ccmn45d
      csys08so.setROWCCMN45DO(callEventDAO(idEvent));
      eventStatus = csys08so.getROWCCMN45DO().getSzCdEventStatus();

      // Retrieve a Contact record using the ID EVENT
      // csys11d
      Map contactMap = contactDAO.findContactByPersonEventAndIdEvent(idEvent);
      if (contactMap == null) {
        // The Event record was found, but the Contact record was not. If the Event status is not NEW, we have an error.
        //   If the Event status is NEW, then the Event is tied to a To-Do. There may or may not be a Contact record
        //   associated with this Event. If one was found, then return it. If not, then continue with the service to
        //   retrieve the rest of the requested data.
        if (!CodesTables.CEVTSTAT_NEW.equals(eventStatus)) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } else {
    	  //STGAP00016837: Check if this CONTACT is being copied or a new Add.  If so replace userID with logged in user ID
        if (copyId == 0) {
    	  csys08so.setUlIdPerson((Integer) contactMap.get("idPerson") != null ? (Integer) contactMap.get("idPerson") : 0);
    	  csys08so.setSzNmPersonFull((String) contactMap.get("nmPersonFull"));
    	  Date dtEntered = (Date)contactMap.get("dtEnteredOn");
          csys08so.setDtDTContactEntered(DateHelper.toCastorDate(dtEntered));
        }else{
        	csys08so.setUlIdPerson(copyId);
        	csys08so.setSzNmPersonFull(copyFullName);
        	copyId=0;
        	copyFullName=null;
        }        
        csys08so.setSzCdContactLocation((String) contactMap.get("cdContactLocation"));
        csys08so.setSzCdContactMethod((String) contactMap.get("cdContactMethod"));
        csys08so.setSzCdContactOthers((String) contactMap.get("cdContactOthers"));
        csys08so.setSzCdContactPurpose((String) contactMap.get("cdContactPurpose"));
        csys08so.setSzCdContactType((String) contactMap.get("cdContactType"));
        csys08so.setSzCdContactType((String) contactMap.get("cdContactType"));
        csys08so.setIndExtDocAccepted((String) contactMap.get("indExtDocNarrAccept"));
        csys08so.setUlIdPortalUser((Integer) contactMap.get("idPortalUserEntered") != null ? (Integer) contactMap.get("idPortalUserEntered") : 0);
        csys08so.setTsSysTsLastUpdate2((Date) contactMap.get("dtLastUpdate"));
        //STGAP00014326 MR-024
        csys08so.setSzCdContactedBy((String) contactMap.get("cdContactedBy"));
        csys08so.setSzNmContactedBy((String) contactMap.get("nmContactedBy"));
        csys08so.setSzCdContactNarr((String) contactMap.get("cdContactNarr"));
       
        //End STGAP00014326 MR-024
        //SIR 674
         idUser = (csys08so.getUlIdPortalUser());
        if (idUser!=0){
          PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(idUser);
          csys08so.setSzNmPortalUserFull(portalUser.getNmUserFull());
          csys08so.setSzTitlePortalUser(portalUser.getTxtTitle());
        }
        try {
          String timeContacted = "";
          String timeSubstr = "";
          // Changed amOrPmTimeString to twentyFourHourTimeStr
          String twentyFourHourTimeStr = "";
          
          String dtmAsString = DateHelper.toISOStringSafe((Timestamp) contactMap.get("dtContactOccurred"));
          if(dtmAsString!=null && !"".equals(dtmAsString)){
          timeSubstr = dtmAsString.substring(11,16);
          }
          if(timeSubstr!=null && !"".equals(timeSubstr)){
            // Replaced amOrPmTimeString  
            twentyFourHourTimeStr = timeSubstr.substring(0,2);
          }
          
          // Convert hours from 24 hour clock to a 12 hour clock 
          // Changed variable from Integer to int to match the output of parseInt
          // Added the twelveHourTimeInt variable to hold the conversion from 24 hour clock to 12 hour clock
          int twentyFourHourTimeInt = Integer.parseInt(twentyFourHourTimeStr);
          int twelveHourTimeInt = twentyFourHourTimeInt - 12;

          // Added code to correctly handle the time from 12:00pm to 12:59pm
          if (twelveHourTimeInt == 0) {
            timeContacted = timeSubstr + " PM";          
          } else if (twelveHourTimeInt > 0) {
            if (twelveHourTimeInt < 10)
              timeContacted = "0";
            timeContacted += twelveHourTimeInt + timeSubstr.substring(2) + " PM";
          } else
            timeContacted = timeSubstr + " AM";
                   
          gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY contactTimeArray = new gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY();
          contactTimeArray.addTmScrTmCntct(timeContacted);
          csys08so.setTmScrTmCntct_ARRAY(contactTimeArray);
        } catch (Exception e) {
          throw new RuntimeWrappedException(e);
        }
        // end SIR 674
        
        csys08so.setDtDTContactOccurred((Date)contactMap.get("dtContactOccurred"));        
        csys08so.setDtDtMonthlySummBegin(DateHelper.toCastorDate((Date) contactMap.get("dtCntctMnthlySummBeg")));
        csys08so.setDtDtMonthlySummEnd(DateHelper.toCastorDate((Date) contactMap.get("dtCntctMnthlySummEnd")));
        csys08so.setSzNmAgencyName((String) contactMap.get("nmAgencyName"));
        csys08so.setBIndContactAttempted((String) contactMap.get("indContactAttempted"));
        csys08so.setIndExtDocAccepted((String) contactMap.get("indExtDocNarrAccept"));
        csys08so.setBIndCrossCountyLines((String) contactMap.get("indPermCrossCntyLn"));
        Integer idTCMClient = (Integer) contactMap.get("idContactTCMClient");
        if(idTCMClient != null && idTCMClient > 0) {
          csys08so.setUlIdTCMClient(idTCMClient);
          csys08so.setSzCdTCMEligible((String) contactMap.get("cdContactTCMEligible"));
          csys08so.setSzCdTCMMedSvcs((String) contactMap.get("cdContactTCMMedSvcs"));
          //MR-024
          //If TCM contact check to see if the TCM claim status is NBL is yes, the contact is modifiable     
          boolean bIndTcmNBLStatus =  isTCMClaimNBL(idTCMClient, idEvent, idStage);
          csys08so.setBIndTcmNBLStatus(bIndTcmNBLStatus);
        }else{
        //If there is no idTCMClient set the bIndTcmNBLStatus to true
        //this will ensure that the TCM Contacts without TCMClaims are
        //modifiable for 7 days.
        csys08so.setBIndTcmNBLStatus(true);
        }
        
        CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
        if (capsResource != null) {
          String cdRsrcCategory = capsResource.getCdRsrcCategory();
          if (cdRsrcCategory != null) {
            csys08so.setSzCdRsrcCategory(cdRsrcCategory);
          }
        }

        // We need to retrieve the Title of the contact by Person
        int idPerson = csys08so.getUlIdPerson();
        if (idPerson != 0) {
          String jobTitleMap = empJobHistoryDAO.findEmpJobTitle(idPerson);
          if(jobTitleMap != null){
            csys08so.setSzCdJobTitle(jobTitleMap != null ?  jobTitleMap : "" );
          }
        }
        
        //-- Retrieve any existing CONTACT_CBX records for associated contact
        List<ContactCbx> cbxList = contactCbxDAO.findContactCbx(idEvent);
        if(cbxList != null && !cbxList.isEmpty()) {
          ContactCbxDisplay_Array cbxDisplayArray = new ContactCbxDisplay_Array();
          cbxDisplayArray.setUlRowQty(cbxList.size());
          for(ContactCbx cbx : cbxList) {
            ContactCbxDisplay cbxDisplay = new ContactCbxDisplay();
            cbxDisplay.setSzCdCbxCodeType(cbx.getCdCbxCodeType());
            cbxDisplay.setSzCdContactCbx(cbx.getCdContactCbx());
            cbxDisplayArray.addContactCbxDisplay(cbxDisplay);
          }
          csys08so.setContactCbxDisplay_Array(cbxDisplayArray);
        }
        
        //MR-024
        // Retrieve the CONTACT_PRIV_CONVER_CBX records for associated event
        List<Integer> privConverCbxList = contactPrivConverCbxDAO.findPrivConversationMembersByIdEvent(idEvent);
        if(privConverCbxList != null && !privConverCbxList.isEmpty()) {
          ROWPRIVCONVERSO_ARRAY privConverArray = new ROWPRIVCONVERSO_ARRAY();
          privConverArray.setUlRowQty(privConverCbxList.size());
          for(int i=0; i < privConverCbxList.size(); i++) {
            ROWPRIVCONVERSO rowPrivConverSO = new ROWPRIVCONVERSO();
            Integer ulIdPerson = privConverCbxList.get(i);
            rowPrivConverSO.setUlIdPerson(ulIdPerson);
            privConverArray.addROWPRIVCONVERSO(rowPrivConverSO);
          }
          privConverArray.setUlRowQty(privConverCbxList.size());
          csys08so.setROWPRIVCONVERSO_ARRAY(privConverArray);
          
        }
        
        //MR-072
        // Retrieve the CONTACT_DISCUSSED_CBX records for associated event
        List<ContactDiscussedCbx> discussedCbxList = contactDiscussedCbxDAO.findDiscussedMembersByIdEvent(idEvent);
        if(discussedCbxList != null && !discussedCbxList.isEmpty()) {
          ROWDISCUSSEDSO_ARRAY discussedArray = new ROWDISCUSSEDSO_ARRAY();
          discussedArray.setUlRowQty(discussedCbxList.size());
          for(int i=0; i < discussedCbxList.size(); i++) {
            ROWDISCUSSEDSO rowPrivConverSO = new ROWDISCUSSEDSO();
            ContactDiscussedCbx contactDiscussedCbx = discussedCbxList.get(i);
            Integer ulIdPerson = contactDiscussedCbx.getPerson().getIdPerson();
            rowPrivConverSO.setUlIdPerson(ulIdPerson);
            discussedArray.addROWDISCUSSEDSO(rowPrivConverSO);
          }
          discussedArray.setUlRowQty(discussedCbxList.size());
          csys08so.setROWDISCUSSEDSO_ARRAY(discussedArray);
          
        }
      }

      // If the Event status is not 'NEW', then we should look for people who were contacted. The following gets all
      //   people linked to the given Event via EVENT_PERSON_LINK.
      if (!CodesTables.CEVTSTAT_NEW.equals(eventStatus)) {
        // CallCSYS08D - pass in the entire output structure, this method needs to loop through setROWCSYS08SO_ARRAY to
        //   determine if the person has been contacted and set an indicator
        callEventPersonLinkDAO(idEvent, csys08so);
        
        List<Integer> privConversationMembers = populateprivConversation(idEvent);
        ROWPRIVCONVERSO_ARRAY privConverArray = new ROWPRIVCONVERSO_ARRAY();
       //mr -024 
        Iterator<Integer> privConversationMembersIt = privConversationMembers.iterator();
        while (privConversationMembersIt.hasNext()) {
          Integer idPerson = privConversationMembersIt.next();
           ROWPRIVCONVERSO rowPrivConversation = new ROWPRIVCONVERSO();
        rowPrivConversation.setUlIdPerson(idPerson);
        privConverArray.addROWPRIVCONVERSO(rowPrivConversation);
        }
        csys08so.setROWPRIVCONVERSO_ARRAY(privConverArray);      
        
        //MR-072
        List<ContactDiscussedCbx> discussedMembers = contactDiscussedCbxDAO.findDiscussedMembersByIdEvent(idEvent);
        ROWDISCUSSEDSO_ARRAY discussedArray = new ROWDISCUSSEDSO_ARRAY();
        Iterator<ContactDiscussedCbx> discussedMembersIt = discussedMembers.iterator();
        while (discussedMembersIt.hasNext()) {
           ContactDiscussedCbx contactDiscussedCbx = discussedMembersIt.next();
           Integer idPerson = contactDiscussedCbx.getPerson().getIdPerson();
           ROWDISCUSSEDSO rowDiscussed = new ROWDISCUSSEDSO();
           rowDiscussed.setUlIdPerson(idPerson);
           discussedArray.addROWDISCUSSEDSO(rowDiscussed);
        }
        csys08so.setROWDISCUSSEDSO_ARRAY(discussedArray);   
      }
      // Look for a Narrative/Blob using the given ID EVENT.
      // csys13d
      Date dtLastUpdateByIdEvent = commonDAO.findDtLastUpdate(csys08si.getSzSysTxtTablename(), idEvent);
      if (dtLastUpdateByIdEvent != null) {
        csys08so.setSzScrTxtNarrStatus(NARRATIVE_TXT_DESCR);
        csys08so.setTsLastUpdate(dtLastUpdateByIdEvent);
      } else {
        csys08so.setSzScrTxtNarrStatus("");
      }
      
      //MOBILITY
      csys08so.setSzCdPopulatedFrom((String) contactMap.get("cdPopFrom"));

    }

    // At this point, we may have an Event record, maybe a Contact record, a list of people linked to the Event, and an
    //   indicator designating the existence of a Narrative/Blob. We are executing the rest of the code whether an
    //   ID EVENT was given or not.

    // If we are not given an ID EVENT or if the Event record we retrieved is NEW, we must retrieve the
    //   PRIMARY CASEWORKER from the STAGE_PERSON_LINK and PERSON tables.

    if (0 == idEvent || CodesTables.CEVTSTAT_NEW.equals(eventStatus)) {
      // csys14d
      Map personMap = personDAO.findPersonByStagePersonLink(csys08si.getUlIdStage());
      if (personMap != null) {
        Integer idPersonEmp = (Integer) personMap.get("idPerson") != null ? (Integer) personMap.get("idPerson") : 0;
//        csys08so.setUlIdPerson((Integer) personMap.get("idPerson") != null ? (Integer) personMap.get("idPerson") : 0);
        csys08so.setUlIdPerson((Integer) personMap.get("idPerson") != null ? (Integer) personMap.get("idPerson") : 0);
        csys08so.setSzNmPersonFull((String) personMap.get("nmPersonFull")); //Entered by
        //STGAP00018101 Check if userID and and name were sent over.  Then insert correct User Name and User Employee  Title
        if (copyId != 0){
        	idPersonEmp = copyId;
        	csys08so.setUlIdPerson(copyId);
        	csys08so.setSzNmPersonFull(copyFullName);
        	copyId=0;
        	copyFullName=null;
        }
        csys08so.setBIndContactAttempted(ArchitectureConstants.N);
        csys08so.setDtDtMonthlySummEnd(DateHelper.toCastorDate(csys08so.getDtDTContactOccurred()));
        csys08so.setDtDtMonthlySummBegin(null);

        // get employee job title
        if (idPersonEmp != 0) {
          String jobTitleMap = empJobHistoryDAO.findEmpJobTitle(idPersonEmp);
          if(jobTitleMap != null){
            csys08so.setSzCdJobTitle(jobTitleMap != null ? jobTitleMap : "" );
          }
        } // end idPersonEmp != 0
        
      }
    }

    // Finally, we need to determine if there is a Stage Conclusion Event in the tables. If there is, and it is pending,
    //   then we need to return this fact to the client. Any Contacts recorded against Closure Pending Stages will
    //   invalidate the Approval Event. pOutputMsg->ulIdEvent is populated with the ID EVENT of the Stage Conclusion
    //   Event IF it exists AND IF it's status is PENDING.
    // ccmn87d
    csys08so.setUlIdEvent(callDynamicEventDAO(idStage, csys08so.getSzCdStage()));

    // Call callFacilityInvstDtlDAO to retrieve the superintendent notification indicator
    //   from the facility_invst_dtl table.
    // Only call the following two DAOs if the Stage Program is AFC and the Stage is INV.
    if (CodesTables.CPGRMS_AFC.equals(csys08so.getSzCdStageProgram()) &&
        CodesTables.CSTAGES_INV.equals(csys08so.getSzCdStage())) {
      // cinv17d
      FacilityInvstDtl facilityInvstDtl = facilityInvstDtlDAO.findFacilityInvstDtlByIdStage(idStage);
      if (facilityInvstDtl == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      csys08so.setCIndFacilSuperintNotif(facilityInvstDtl.getIndFacilSuperintNotif());

      // cinvb8d
      Date dtDTContactOccurred = contactDAO.findEarliestContactDateByIdStage(idStage);
      if (DateHelper.isNull(dtDTContactOccurred)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      csys08so.setUlNbrReviewContact(1);
    }

    // Retrieve the Intake start date
    // cinvc8d
    // STGAP00011640: Find Intake from the idStage and then get the dt_incomingcall from
    // the IncomingDetail.
    Date dtStageStart = null;
    IncomingDetail incmgDetl = incomingDetailDAO.findIncomingDetailFromAnyIdStage(idStage);
    if (incmgDetl != null) {
      dtStageStart = incmgDetl.getDtIncomingCall();
    } else {
      // If there is no IntakeStage for the case get the date case opened from capscase table as done before this fix.
      dtStageStart = capsCaseDAO.findDtCaseOpenedByIdStage(csys08si.getUlIdStage());
    }

    if (!DateHelper.isNull(dtStageStart)) {
      csys08so.setDtDtIntStart(dtStageStart);
    }
    csys08so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    return csys08so;
  }

  private void callEventPersonLinkDAO(int idEvent, CSYS08SO csys08so) {
    // csys08d
    List<EventPersonLink> eventPersonLinkList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(idEvent);
    if (eventPersonLinkList == null || eventPersonLinkList.isEmpty()) {
      // This is not an error, but no further processing is necessary
      return;
    }
    // Cache the rows in ROWCSYS08SO_ARRAY in a map for later lookup.
    Map<Integer, ROWCSYS08SO> rowcsys08so_map = new HashMap<Integer, ROWCSYS08SO>();
    ROWCSYS08SO_ARRAY rowcsys08so_array = csys08so.getROWCSYS08SO_ARRAY();
    Enumeration rowcsys08so_enum = rowcsys08so_array.enumerateROWCSYS08SO();
    while (rowcsys08so_enum.hasMoreElements()) {
      ROWCSYS08SO rowcsys08so = (ROWCSYS08SO) rowcsys08so_enum.nextElement();
      rowcsys08so_map.put(rowcsys08so.getUlIdPerson(), rowcsys08so);
    }
    // Loop over the results and update csys08so.
    Iterator<EventPersonLink> eventPersonLinkListIt = eventPersonLinkList.iterator();
    while (eventPersonLinkListIt.hasNext()) {
      EventPersonLink eventPersonLink = eventPersonLinkListIt.next();
      Person person = eventPersonLink.getPerson();
      int idPerson = person.getIdPerson();
      if (idPerson == csys08so.getUlIdPerson()) {
        csys08so.setTsSysTsLastUpdate3(eventPersonLink.getDtLastUpdate());
      }
      ROWCSYS08SO rowcsys08so = rowcsys08so_map.get(idPerson);
      if (rowcsys08so != null) {
        rowcsys08so.setCSysIndContactOccurred(ArchitectureConstants.Y);
        rowcsys08so.setTsLastUpdate(eventPersonLink.getDtLastUpdate());
      }
    }
  }

  private ROWCCMN45DO callEventDAO(int idEvent) throws ServiceException {
    // ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    if(event.getPerson()== null){
      rowccmn45do.setUlIdPerson(0);
    }else if(event.getPerson().getIdPerson() != null ){
      rowccmn45do.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    }
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

  private ROWCSYS08SO_ARRAY callStagePersonLinkDAO(int idStage) {
    ROWCSYS08SO_ARRAY rowcsys08so_array = new ROWCSYS08SO_ARRAY();
    int pageNbr = 1;
    int pageSize = 50;
    // cinv34d
    List<StagePersonLink> stagePersonLinkInfoList =
            stagePersonLinkDAO.findStagePersonLinkAndPersonByidStageAndCdStagePersType(idStage,
                                                                                       CodesTables.CPRSNALL_STF,
                                                                                       pageNbr,
                                                                                       pageSize);
    if (stagePersonLinkInfoList == null || stagePersonLinkInfoList.isEmpty()) {
      return rowcsys08so_array;
    }
    Iterator stagePersonLinkInfoIt = stagePersonLinkInfoList.iterator();
    while (stagePersonLinkInfoIt.hasNext()) {
      StagePersonLink stagePersonLink = (StagePersonLink) stagePersonLinkInfoIt.next();
      int idPerson = stagePersonLink.getPerson().getIdPerson();
      if (0 != idPerson) {
        ROWCSYS08SO rowcsys08so = new ROWCSYS08SO();
        rowcsys08so.setSzNmPersonFull(stagePersonLink.getPerson().getNmPersonFull());
        rowcsys08so.setSzCdStagePersRole(stagePersonLink.getCdStagePersRole());
        rowcsys08so.setSzCdStagePersRelInt(stagePersonLink.getCdStagePersRelInt());
        rowcsys08so.setSzCdStagePersType(stagePersonLink.getCdStagePersType());
        rowcsys08so.setUlIdPerson(idPerson);
        rowcsys08so_array.addROWCSYS08SO(rowcsys08so);
      }
    }
    return rowcsys08so_array;
  }

  private String callDynamicContactDAO(int idStage, Date dtTempDTStageStart) {
    String cdContactLocation = null;
    String cdContactMethod = null;
    String cdContactOthers = null;
    String cdContactPurpose = null;
    List<String> cdPurposeList = new ArrayList<String>();
    String cdContactType = CodesTables.CCNTCTYP_ASTR;
    int idCase = 0;
    int idEvent = 0;
    String cdEventStatus = null;
    Date dtScrSearchDateTo = null;
    // csys04d
  //MR-024 Changed to accept cdPurposeList instead of single cdPurpose
  //Do impact analysis for this
    List<Object[]> dynamicContactList =
            dynamicContactDAO.findContacts(idCase, idStage, idEvent, cdEventStatus, cdContactType, cdPurposeList,
                                           cdContactMethod, cdContactLocation, cdContactOthers, dtTempDTStageStart,
                                           dtScrSearchDateTo);
    if (dynamicContactList != null && dynamicContactList.size() > 0) {
      return ArchitectureConstants.Y;
    } else {
      return ArchitectureConstants.N;
    }
  }

  private int callDynamicEventDAO(int idStage, String cdStage) throws ServiceException {
    String[] cdEventTypes;
    if (CodesTables.CSTAGES_INV.equals(cdStage)) {
      cdEventTypes = new String[] {CodesTables.CEVNTTYP_CCL};
    } else {
      cdEventTypes = new String[] {CodesTables.CEVNTTYP_STG};
    }
    boolean extraTables = false;
    int idCase = 0;
    int idPerson = 0;
    int idSituation = 0;
    int idEventPerson = 0;
    String[] cdStages = null;
    String cdTask = null;
    Date dtScrDtStartDt = null;
    Date dtScrDtEventEn = null;
    // ccmn87d
    List<Object[]> dynamicEventList = dynamicEventDAO.findEvents(extraTables, idCase, idStage, idPerson, idSituation,
                                                                 idEventPerson, cdEventTypes, cdStages, cdTask,
                                                                 dtScrDtStartDt, dtScrDtEventEn, null);
    if (dynamicEventList == null || dynamicEventList.isEmpty()) {
      return 0;
    }
    Object[] firstEventInfo = dynamicEventList.get(0);
    String cdEventStatus = (String) firstEventInfo[0];
    if (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {
      // The 6th element of the array is the idEvent.
      return (Integer) firstEventInfo[6];
    } else {
      return 0;
    }
  }
  
  /**
   * This private method returns an integer list of person id's of currently saved
   * contactPrivConverCbx records for the contact event
   *
   * @param idEvent
   * @return List<Integer>
   * @throws ServiceException
   */  
  private List<Integer> populateprivConversation(int idEvent) throws ServiceException {

    List<Integer> contPrivConversationMembers = new ArrayList<Integer>();
    contPrivConversationMembers = contactPrivConverCbxDAO.findPrivConversationMembersByIdEvent(idEvent);
    return contPrivConversationMembers;

  }
  
  /**
   * This method returns boolean true if the TCM claim is in NBL status.
   * 
   * @param idPerson
   * @param idEvent
   * @param idStage
   * 
   * @return
   */
  private boolean isTCMClaimNBL(int idPerson, int idEvent, int idStage) {
    boolean tcmClaimNBL = false;
    // Call tcmClaimdao to find if the Tcmclaim is in NBL status ,
    // if yes then return true
    TcmClaim tcmClaim = tcmClaimDAO.findTcmClaimByidPersonidEventidStage(idPerson, idEvent, idStage);
    if (tcmClaim != null) {
      String cdTCMStatus = tcmClaim.getCdStatus();
      if (CodesTables.CTCMSTAT_NBL.equals(cdTCMStatus)) {
        tcmClaimNBL = true;
      }
    } else {
      tcmClaimNBL = true;
     }
    return tcmClaimNBL;
  }  
  
}
