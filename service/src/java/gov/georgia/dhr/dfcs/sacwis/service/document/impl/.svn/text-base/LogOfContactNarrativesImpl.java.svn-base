package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactPrivConverCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.common.ContactListSearch;
import gov.georgia.dhr.dfcs.sacwis.service.document.LogOfContactNarratives;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The LogOfContactNarrativesImpl Class is the service implementation for generating the 'Log of Contact Narratives'
 * Form.
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.impl.BaseDocumentServiceImpl
 * @see gov.georgia.dhr.dfcs.sacwis.service.document.LogOfContactNarratives
 * 
 * @author Stephen Roberts, Septemeber 23, 2007
 * 
 * <PRE>
 * 
 * <U>Updated by:</U>Stephen Roberts <U>Description:</U> 10/03/2007 - Added proper java docs <U>Updated by:</U>Stephen
 * Roberts <U>Description:</U> 10/10/2007 - Added code to handle Safety Assessment Types
 * Change History:
 * Date        User         Description
 * --------    -----------  -----------------------------------------------
 * 09/17/2009  arege        STGAP00015379 : Added null check to prevent NPE when launching log of Contact narratives when a 
 *                          TCM contact record in contact table has null value for id_contact_tcm_client
 * 02/17/2010  swroberts    MR-061:  Added error message when there is more data (500 contacts) in the result
 *                          set. 
 * 06/04/2010  arege        SMS#52235: As per FAD sealing rules sealed contacts should not be displayed in log of contact narratives for certain users
 * 08/16/10    bgehlot      66380 MR072 Add new field Discussed/In Reference to
 * 
 * </PRE>
 */

public class LogOfContactNarrativesImpl extends BaseDocumentServiceImpl implements LogOfContactNarratives {

  private StageDAO stageDAO;

  private ContactDAO contactDAO;
  
  private PersonDAO personDAO;
  
  private ContactListSearch contactListSearch;
  
  private EventPersonLinkDAO eventPersonLinkDAO;
  
  private ContactCbxDAO contactCbxDAO;
  
  private ContactPrivConverCbxDAO contactPrivConverCbxDAO;
  
  private ContactDiscussedCbxDAO contactDiscussedCbxDAO;

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }  
  
  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setContactPrivConverCbxDAO(ContactPrivConverCbxDAO contactPrivConverCbxDAO) {
    this.contactPrivConverCbxDAO = contactPrivConverCbxDAO;
  }

  public void setContactCbxDAO(ContactCbxDAO contactCbxDAO) {
    this.contactCbxDAO = contactCbxDAO;
  }

  public ContactListSearch getContactListSearch() {
    return contactListSearch;
  }

  public void setContactListSearch(ContactListSearch contactListSearch) {
    this.contactListSearch = contactListSearch;
  }
  
  public void setContactDiscussedCbxDAO(ContactDiscussedCbxDAO contactDiscussedCbxDAO) {
    this.contactDiscussedCbxDAO = contactDiscussedCbxDAO;
  }

  /**
   * The retrieveLogOfContactNarratives method is the main entry point for the service.
   * 
   * @param CSVC06SI
   *          Input object which should contain the Stage ID and Dates.
   * @return CSVC06SO Output object which contains prefill data
   */
  public CSVC06SO retrieveLogOfContactNarratives(CSVC06SI csvc06si) {

    CSVC06SO csvc06so = new CSVC06SO();
    Stage stage = stageDAO.findStageByIdStage(csvc06si.getUlIdStage());
    CapsCase capsCase = stage.getCapsCase();

    Date fromDate = csvc06si.getDtDtSampleFrom().toDate();
    Date toDate = csvc06si.getDtDtSampleTo().toDate();
    
    CSYS04SI csys04si = csvc06si.getCSYS04SI();
    
    // Make sure all contacts come back regardless of pagination.  500 seemed like a safe number
    csys04si.getArchInputStruct().setUsPageNbr(1);
    csys04si.getArchInputStruct().setUlPageSizeNbr(500);
    
    CSYS04SO csys04so = contactListSearch.contactListSearch(csys04si);
    
    // MR-061 If there are more than 500 contacts returned then display an error message
    if (ArchitectureConstants.Y.equals(csys04so.getArchOutputStruct().getBMoreDataInd())) {
      throw new ServiceException(Messages.MSG_SVC_TOO_MANY_CONTACTS_FOUND);
    }
    
    ROWCSYS04SO_ARRAY rowcsys04soArray = csys04so.getROWCSYS04SO_ARRAY() != null ? csys04so.getROWCSYS04SO_ARRAY() : new ROWCSYS04SO_ARRAY();
    Enumeration<ROWCSYS04SO> rowcsys04soEnumeration = rowcsys04soArray.enumerateROWCSYS04SO();

    // If there are no contacts display error message.
    if (!rowcsys04soEnumeration.hasMoreElements()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    
    //As per FAD sealing rules sealed contacts should not be displayed in log of contact narratives for certain users
    ROWCSYS04SO_ARRAY tempRowcsys04soArray = new ROWCSYS04SO_ARRAY();
    while (rowcsys04soEnumeration.hasMoreElements()) {
      ROWCSYS04SO rowcsys04so = rowcsys04soEnumeration.nextElement();
      if (ArchitectureConstants.Y.equals(rowcsys04so.getCIndRsrcSvcShowRow())) {
        tempRowcsys04soArray.addROWCSYS04SO(rowcsys04so);
      }
    }
    
    Enumeration<ROWCSYS04SO> tempRowcsys04soEnumeration = tempRowcsys04soArray.enumerateROWCSYS04SO();
    PreFillData preFillData = generatePreFillData(capsCase, tempRowcsys04soEnumeration, fromDate, toDate);
    csvc06so.setPreFillData(preFillData);
    return csvc06so;

  }

  
  /**
   * The generatePreFillData method creates the prefill data for the form.
   * 
   * @param capsCase
   *          Contains case data from CAPS_CASE table.
   * @param contactList
   *          Contains list of contacts
   * @param fromDate Date to show contacts from
   * @param toDate Date to show contacts to
   * @return PreFillData Data to populate the form template
   */
  private PreFillData generatePreFillData(CapsCase capsCase, Enumeration<ROWCSYS04SO> rowcsys04soEnumeration, Date fromDate, Date toDate) {
    PreFillData preFillData = new PreFillData();

    preFillData.addBookmark(createBookmark(TITLE_CASE_NAME, capsCase.getNmCase()));
    preFillData.addBookmark(createBookmark(TITLE_CASE_NUMBER, capsCase.getIdCase()));
    preFillData.addBookmark(createBookmark(CONTACT_DATE_TO, FormattingHelper.formatDate(toDate)));

    // This first contact group is a dummy group which actually won't show up in the template. It's
    // needed so that all the data can be grabbed at once and looped thru a single cursor. The eventId is
    // also initialized at "0" for looping logic.
    String eventId = "0";
    FormDataGroup contactGroup = createFormDataGroup("TMPLAT_DUMMY", "");
    Date earliestContactDate = new Date();
    
    while (rowcsys04soEnumeration.hasMoreElements()) {
      ROWCSYS04SO rowcsys04so = rowcsys04soEnumeration.nextElement();
      if (!eventId.equals(String.valueOf(rowcsys04so.getUlIdEvent()))) {
        preFillData.addFormDataGroup(contactGroup);
        contactGroup = createFormDataGroup(TMPLAT_CONTACT, "CFSD0701");
        contactGroup.addBookmark(createBookmark(CONTACT_ID, rowcsys04so.getUlIdEvent()));
        
        // Add the 'Contacted By:' bookmarks
        // If the cdContactedBy field is null, just use the person's name that entered the contact.  This
        // would be the case for any contacts made prior to R3.2
        if (rowcsys04so.getSzCdContactedBy() == null && rowcsys04so.getSzNmContactedBy() == null) {
          Person person = personDAO.findPersonByIdPerson(rowcsys04so.getUlIdPerson());
          if (person != null) {
            contactGroup.addBookmark(createBookmark(CONTACTED_BY_FIRST, person.getNmPersonFirst()));
            contactGroup.addBookmark(createBookmark(CONTACTED_BY_MIDDLE, person.getNmPersonMiddle()));
            contactGroup.addBookmark(createBookmark(CONTACTED_BY_LAST, person.getNmPersonLast()));
          }
        }
        else if (rowcsys04so.getSzNmContactedBy() != null && rowcsys04so.getSzCdContactedBy()!= null){
          contactGroup.addBookmark(createBookmark(CONTACTED_BY_LAST, rowcsys04so.getSzNmContactedBy()));
        }
        
        Date contactDate = rowcsys04so.getDtDTContactOccurred();
        contactGroup.addBookmark(createBookmark(CONTACT_DATE_OCCURRED, FormattingHelper.formatDateTime(contactDate)));

        if (earliestContactDate.after(contactDate)) {
          earliestContactDate = contactDate;
        }

        contactGroup.addBookmark(createBookmarkWithCodesTable(CONTACT_METHOD, rowcsys04so.getSzCdContactMethod(), CodesTables.CCNTMETH));
        contactGroup.addBookmark(createBookmarkWithCodesTable(CONTACT_OTHERS, rowcsys04so.getSzCdContactOthers(), CodesTables.COTHCNCT));
        contactGroup.addBookmark(createBookmarkWithCodesTable(CONTACT_LOCATION, rowcsys04so.getSzCdContactLocation(), CodesTables.CCNCTLOC));
        contactGroup.addBookmark(createBookmarkWithCodesTable(CONTACT_TYPE, rowcsys04so.getSzCdContactType(), CodesTables.CCNTCTYP));
        contactGroup.addBookmark(createBookmark(NAME_OF_AGENCY, rowcsys04so.getSzNmAgencyName()));
        
        
        
        String indContactAttempted = String.valueOf(rowcsys04so.getBIndContactAttempted());
        // Add 'Attempted text to form if the contact was attempted
        if (ArchitectureConstants.Y.equals(indContactAttempted)) {
          contactGroup.addFormDataGroup(createFormDataGroup(TMPLAT_ATTEMPTED, ""));
        }
        
        String indCountyLines = String.valueOf(rowcsys04so.getBIndCrossCountyLines());
        // Add 'Attempted text to form if the contact was attempted
        if (ArchitectureConstants.Y.equals(indCountyLines)) {
          contactGroup.addBookmark(createBookmark(PERM_COUNTY_LINES, "Yes"));
        }        

        List<EventPersonLink> eplList = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(rowcsys04so.getUlIdEvent());
        List<Integer> privConvList = contactPrivConverCbxDAO.findPrivConversationMembersByIdEvent(rowcsys04so.getUlIdEvent());
        
        for (Iterator<EventPersonLink> it = eplList.iterator(); it.hasNext();) {
           EventPersonLink epl = it.next();
           Person personContacted = epl.getPerson();
           
           FormDataGroup personGroup = createFormDataGroup(TMPLAT_CONTACT_NAME, "");
           personGroup.addBookmark(createBookmark(CONTACT_NAME_FIRST, personContacted.getNmPersonFirst()));
           personGroup.addBookmark(createBookmark(CONTACT_NAME_MIDDLE, personContacted.getNmPersonMiddle()));
           personGroup.addBookmark(createBookmark(CONTACT_NAME_LAST, personContacted.getNmPersonLast()));
           String cdNameSuffix = personContacted.getCdPersonSuffix();

           if (cdNameSuffix != null && !"".equals(cdNameSuffix)) {
             personGroup.addFormDataGroup(createFormDataGroup(TMPLAT_COMMA, "CFSD0704"));
           }
           personGroup.addBookmark(createBookmarkWithCodesTable(CONTACT_NAME_SUFFIX, cdNameSuffix, CodesTables.CSUFFIX2));
           
           if (privConvList.contains(personContacted.getIdPerson())) {
             personGroup.addFormDataGroup(createFormDataGroup(TMPLAT_PRIVATE_CONVERSATION, "CFSD0704"));
           }   
           contactGroup.addFormDataGroup(personGroup);
        }
               
        //MR-072 Discussed/In Reference To persons displayed on the forms
        //Get all the Discussed/In Reference persons for the contact
        List<ContactDiscussedCbx> discussedPersons = contactDiscussedCbxDAO.findDiscussedMembersByIdEvent(rowcsys04so.getUlIdEvent());
        if(discussedPersons != null && !discussedPersons.isEmpty()){
          Iterator<ContactDiscussedCbx> itDiscussed = discussedPersons.iterator();
          while (itDiscussed.hasNext()) {
            ContactDiscussedCbx contactDiscussedCbx = itDiscussed.next();
            Person personDiscussed = contactDiscussedCbx.getPerson();

            FormDataGroup personGroup = createFormDataGroup(TMPLAT_DISCUSSED_PERSON_NAME, "");
            personGroup.addBookmark(createBookmark(DISCUSSED_PERSON_NAME_FIRST, personDiscussed.getNmPersonFirst()));
            personGroup.addBookmark(createBookmark(DISCUSSED_PERSON_NAME_MIDDLE, personDiscussed.getNmPersonMiddle()));
            personGroup.addBookmark(createBookmark(DISCUSSED_PERSON_NAME_LAST, personDiscussed.getNmPersonLast()));
            String cdNameSuffix = personDiscussed.getCdPersonSuffix();

            if (cdNameSuffix != null && !"".equals(cdNameSuffix)) {
              personGroup.addFormDataGroup(createFormDataGroup(TMPLAT_COMMA, "CFSD0704"));
            }
            personGroup.addBookmark(createBookmarkWithCodesTable(DISCUSSED_PERSON_NAME_SUFFIX, cdNameSuffix, CodesTables.CSUFFIX2));
 
            contactGroup.addFormDataGroup(personGroup);
          }
        }
        
        // Add the TCM Elements if the contact is of type TCM
        if (rowcsys04so.getSzCdContactType().endsWith("TCM")){
          
          FormDataGroup tcmGroup = createFormDataGroup(TMPLAT_TCM, "");
          Person tcmGuarantor = personDAO.findPersonByIdPerson(rowcsys04so.getUlIdTCMClient());
          //STGAP00015379 : Added null check to prevent NPE when launching log of Contact narratives 
          if(tcmGuarantor != null){
          tcmGroup.addBookmark(createBookmark(TCM_GUARANTOUR, tcmGuarantor.getNmPersonFull()));
          }
          tcmGroup.addBookmark(createBookmarkWithCodesTable(TCM_ELIGIBLE, rowcsys04so.getSzCdTCMEligible(),CodesTables.CINFPKRQ));
          tcmGroup.addBookmark(createBookmarkWithCodesTable(TCM_BILLABLE, rowcsys04so.getSzCdTCMMedSvcs(),CodesTables.CINVACAN));
          
          List<ContactCbx> contactCbxList =  contactCbxDAO.findContactCbx(rowcsys04so.getUlIdEvent());
          
          
          // Add the Service and Program Groups
          
          for (Iterator<ContactCbx> it = contactCbxList.iterator(); it.hasNext();) {
            ContactCbx contactCbx = it.next();
            FormDataGroup formDataGroup = null;
            if (CodesTables.CTCMPROG.equals(contactCbx.getCdCbxCodeType())){
              formDataGroup = createFormDataGroup(TMPLAT_TCM_PROGRAMS, "");
              formDataGroup.addBookmark(createBookmarkWithCodesTable(TCM_PROGRAM, contactCbx.getCdContactCbx(),CodesTables.CTCMPROG));
            } else if (CodesTables.CTCMSVCS.equals(contactCbx.getCdCbxCodeType())) {
              formDataGroup = createFormDataGroup(TMPLAT_TCM_SERVICES, "");
              formDataGroup.addBookmark(createBookmarkWithCodesTable(TCM_SERVICE, contactCbx.getCdContactCbx(),CodesTables.CTCMSVCS));            
            }
            if (formDataGroup != null) {
              tcmGroup.addFormDataGroup(formDataGroup);
            }
          }           
          contactGroup.addFormDataGroup(tcmGroup);
        }

        // Add the Blob bookmark. Unfortunately different contact types are saving narratives to different
        // tables.
        if ("SRA".equals(rowcsys04so.getSzCdContactType().substring(1, 4))) {
          // Pull from the safety resource assessment table
          contactGroup.addBlobData(createBlobData(CONTACT_NARRATIVE, SAFETY_RSRC_ASMNT_NARR,
                                                  String.valueOf(rowcsys04so.getUlIdEvent())));
        } else {
          // Pull from the normal contact narrative table
          contactGroup
                      .addBlobData(createBlobData(CONTACT_NARRATIVE, CONTACT_NARRATIVE, String.valueOf(rowcsys04so.getUlIdEvent())));
        }
      }
      
      // The array that is looping may have duplicate rows due to multiple purposes being reported.  This is
      // how those purposes are added w/out an extra DB call.
      FormDataGroup purposeGroup = createFormDataGroup(TMPLAT_PURPOSE, "CFSD0703");
      purposeGroup.addBookmark(createBookmarkWithCodesTable(CONTACT_PURPOSE, rowcsys04so.getSzCdContactPurpose(), CodesTables.CCNTPURP));
      contactGroup.addFormDataGroup(purposeGroup);
      eventId = String.valueOf(rowcsys04so.getUlIdEvent());
    }
    // Get Last contact group. It won't be added in the loop logic because the iterator will meet its limit.
    preFillData.addFormDataGroup(contactGroup);

    // If the form is viewed without filtering by date (i.e. using  the minimum Java Date), show the
    // From Date as the first contact.  Otherwise show what was used in the search.
    if (DateHelper.MIN_JAVA_DATE.equals(fromDate)) {
      preFillData.addBookmark(createBookmark(CONTACT_DATE_FROM, FormattingHelper.formatDate(earliestContactDate)));
    } else {
      preFillData.addBookmark(createBookmark(CONTACT_DATE_FROM, FormattingHelper.formatDate(fromDate)));
    }

    return preFillData;

  }  
}
