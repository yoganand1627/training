/**
 * Created on Aug 10, 2006 at 12:18:33 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.document.ContactVisitationsLog;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CONTACTVISITLOGSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CONTACTVISITLOGSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

public class ContactVisitationsLogImpl extends BaseDocumentServiceImpl implements ContactVisitationsLog {

  private StageDAO stageDAO;

  private CapsCaseDAO capsCaseDAO;

  private IncomingDetailDAO incomingDetailDAO;

  private ContactDAO contactDAO;

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public CONTACTVISITLOGSO retrieveContactVisitationsLog(CONTACTVISITLOGSI contactVisitLogsi) {
    CONTACTVISITLOGSO contactVisitLogso = new CONTACTVISITLOGSO();
    int idStage = contactVisitLogsi.getUlIdStage();
    String cdContactType = contactVisitLogsi.getSzCdContactType();
    int idCase = 0;
    String caseName = null;

    // given a stage get the case id from stage table
    Stage stage = stageDAO.findStageByIdStage(idStage);

    // get case name with case id from case table
    CapsCase capsCase = stage.getCapsCase();
    if (!PARENTCHILDVISITCONTACTTYPE.equals(cdContactType)) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    if (capsCase != null) {
      idCase = stage.getCapsCase().getIdCase();
      caseName = capsCaseDAO.findNmCaseByIdCase(idCase);
    }
   

    List<String> cdContactTypes = new ArrayList<String>();
    cdContactTypes.add(CodesTables.CCNTCTYP_APVC);
    cdContactTypes.add(CodesTables.CCNTCTYP_DPVC);
    cdContactTypes.add(CodesTables.CCNTCTYP_KPVC);
    cdContactTypes.add(CodesTables.CCNTCTYP_OPVC);
    cdContactTypes.add(CodesTables.CCNTCTYP_LPVC);
    cdContactTypes.add(CodesTables.CCNTCTYP_MPVC);
    
    

    // get all contacts data
    List<Contact> contactList = null;

    if (idCase != 0) {
      contactList = getAllContactsFromOneContactIdCaseAndcdContactTypes(idCase, cdContactTypes);

    } else { // The form call is originating from the Contact Search list in the Intake stage
      contactList = getIntakeContactIDListByIdStageBycdContactType(idStage, cdContactTypes);
    }
    
    PreFillData preFillData = getContactVisitationHeadings(idCase, idStage, caseName);

    if ((contactList == null || contactList.isEmpty())) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    // build form
    buildContactVisitationLogContactSection(preFillData, contactList);

    contactVisitLogso.setPreFillData(preFillData);
    return contactVisitLogso;
  }

  /*
   * Get the detail data about the heading given a specific case number
   */
  private PreFillData getContactVisitationHeadings(int idCase, int idStage, String caseName) {
    PreFillData preFillData = new PreFillData();
    Date fromDate = null;
    String idCaseDisplay = null;

    // get the original date when the incoming call was first logged
    
    IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailFromAnyIdStage(idStage);
    
    if (incomingDetail != null){
    	fromDate = incomingDetail.getDtIncomingCall();
    }
    if (idCase > 0) { // call initiated from a stage other than an Intake stage
      idCaseDisplay = String.valueOf(idCase);
    }

    if (fromDate == null) {
      fromDate = DateHelper.toJavaDate(DateHelper.MIN_CASTOR_DATE);
    }
    Date today = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    preFillData.addBookmark(createBookmark("TITLE_CASE_NUMBER", idCaseDisplay));
    preFillData.addBookmark(createBookmark("TITLE_CASE_NAME", caseName));
    preFillData.addBookmark(createBookmark("CONTACT_DATE_FROM", FormattingHelper.formatDate(fromDate)));
    preFillData.addBookmark(createBookmark("CONTACT_DATE_TO", FormattingHelper.formatDate(today)));
    return preFillData;
  }

  /**
   * Get the list of persons contacted and their relevant data for a specific case id and contact type
   * 
   * @param preFillData
   * @param contactAPVCList
   * @param contactKPVCList
   */

  private void buildContactVisitationLogContactSection(PreFillData preFillData, List<Contact> contactIntakeList) {
    if (contactIntakeList != null && !contactIntakeList.isEmpty()) {
      for (Iterator<Contact> itK = contactIntakeList.iterator(); itK.hasNext();) {
        preFillData.addFormDataGroup(createContactInformation(itK.next()));
      }
    }
  }

  // get all the contacts given a specific contact idCase and a list of contactTypes.
  // This will include the contacts from intake stage that were created before and after intake stage was approved
  private List<Contact> getAllContactsFromOneContactIdCaseAndcdContactTypes(int idCase, List<String> cdContactTypes) {
     List<Contact> contactIDList = contactDAO.findContactVisitationByIdCaseByCdContactTypes( idCase, cdContactTypes);
     return contactIDList;
   }

  // get the list of contacts for the Intake stage
  private List<Contact> getIntakeContactIDListByIdStageBycdContactType(int idStage, List<String> cdContactTypes) {
    List<Contact> contactIDList = contactDAO.findContactByIdStageAndcdContactTypes(idStage, cdContactTypes);
    return contactIDList;
  }

  /**
   * Get the information specific to a contact
   * 
   * @param contactInfo
   * @param cdContactType
   * @return
   */
  private FormDataGroup createContactInformation(Contact contactInfo) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CONTACT, CFCD0700V2);

    Integer contactID = contactInfo.getIdEvent();
    group.addBookmark(createBookmark(CONTACT_CONTACT_ID, contactID));
    String dtContactOccurred = FormattingHelper.formatDateTime((Date) contactInfo.getDtContactOccurred());
    group.addBookmark(createBookmark(CONTACT_DATE_OCCURRED, dtContactOccurred));
    group.addBookmark(createBookmark(CONTACT_TYPE, Lookup.simpleDecodeSafe(CodesTables.CCNTCTYP,
                                                                           contactInfo.getCdContactType())));
    getContactedPersonListByContactId(group, contactID);
    group.addBookmark(createBookmark(CONTACT_LOCATION,
                                     Lookup.simpleDecodeSafe(CodesTables.CCNCTLOC,
                                                             (String) contactInfo.getCdContactLocation())));
    group.addBlobData(createBlobData(CONTACT_NARRATIVE, CONTACT_NARRATIVE, contactID.intValue())); // contactID
    // same as idEvent
    return group;
  }

  /**
   * get the list of persons contacted for that contact id (same as idEvent of type specific type)
   * 
   * @param parentGroup
   * @param idEvent
   */
  private void getContactedPersonListByContactId(FormDataGroup parentGroup, int idEvent) {
    List<Map> contactPersonList = contactDAO.findContactVisitationsPersonsByIdEvent(idEvent);
    if (contactPersonList != null && !contactPersonList.isEmpty()) {
      for (Iterator<Map> it = contactPersonList.iterator(); it.hasNext();) {
        Map map = it.next();
        Date endDate = (Date) map.get("dtNameEndDate");
        Calendar calendar = Calendar.getInstance();
        Date dtCurrentDate = calendar.getTime();
        // STGAP00006688 Making sure the primary name has not been 
        // end dated to prevent dual entry on contact visitation log.
        if(!endDate.before(dtCurrentDate)){
        parentGroup.addFormDataGroup(createPersonName(map));
        }
      }
    }
  }

  private FormDataGroup createPersonName(Map nameInfo) {
    FormDataGroup group = createFormDataGroup(TMPLAT_CONTACT_NAME, CFCD0700V2);
    group.addBookmark(createBookmark(CONTACT_NAME_FIRST, nameInfo.get("nmNameFirst")));
    group.addBookmark(createBookmark(CONTACT_NAME_MIDDLE, nameInfo.get("nmNameMiddle")));
    group.addBookmark(createBookmark(CONTACT_NAME_LAST, nameInfo.get("nmNameLast")));
    if (nameInfo.get("cdNameSuffix") != null) {
      group.addFormDataGroup(createFormDataGroup(TMPLAT_COMMA, CFCD0700V));
      group.addBookmark(createBookmark(CONTACT_NAME_SUFFIX, nameInfo.get("cdNameSuffix")));
    }
    return group;
  }
}
