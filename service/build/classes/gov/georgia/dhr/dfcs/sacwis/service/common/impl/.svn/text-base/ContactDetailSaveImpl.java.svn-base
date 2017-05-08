package gov.georgia.dhr.dfcs.sacwis.service.common.impl;
/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   09/29/2009    arege           STGAP00015281 Narrative is not being deleted with change of Narrative Type.          
 *   11/08/2009  Patrick Coogan    ECEM: Updated code so that person is set to null for events for portal contacts
 *   08/16/10    bgehlot           66380 MR072 Add new field Discussed/In Reference to
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactNarrativeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactPrivConverCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilAllegPriorReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityInvstDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ContactDiscussedCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ContactNarrative;
import gov.georgia.dhr.dfcs.sacwis.db.ContactPrivConverCbx;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.common.ContactDetailSave;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSVC02SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEDISCUSSED_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDELETEPRIVCONVER_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWDISCUSSED_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWPRIVCONVER_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.EventIdStruct_ARRAY;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ContactDetailSaveImpl extends BaseServiceImpl implements ContactDetailSave {

  private static final int MAX_REG_SUBMITTED_CONTACTS = 99;
  private static final String TXT_EVENT_DESC_MONTHLY_STATUS = "Monthly Status";

  private static final String TODO_INFO_41_CODE = "SUB041";

  private static final String SVC_CD_EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  /*
  ** To-Do Arch Enh BEGIN - To-Do codes necessary for calling the
  ** TodoCommonFunction
  */
  private static final String TODO_SUB_MONTHLY_SUMM = "SVC001";
  private static final String TODO_FSU_MONTHLY_SUMM = "SVC002";
  private static final String TODO_FRE_MONTHLY_SUMM = "SVC003";
  private static final String TODO_FPR_MONTHLY_SUMM = "SVC004";
  private static final String TODO_ADO_MONTHLY_SUMM = "SVC005";
  private static final String TODO_PAD_MONTHLY_SUMM = "SVC006";
  private static final String TODO_INV_MONTHLY_STAT = "SVC007";
  private static final String TODO_AOC_MONTHLY_STAT = "SVC008";
  private static final String TODO_SVC_MONTHLY_STAT = "SVC009";
  private static final String TODO_INV_THREE_MONTH = "APS001";
  private static final String TODO_SVC_THREE_MONTH = "SVC012";

  private static final String SVC_TYPE_CHAR_CLOSED = "F";

  private static final String SVC_CD_CONTACT_TYPE_FPR_REG = CodesTables.CCNTCTYP_BREG;

  private static final String SVC_CD_CONTACT_TYPE_SUB_REG = CodesTables.CCNTCTYP_GREG;
  private static final String SVC_CD_CONTACT_TYPE_ADO_REG = CodesTables.CCNTCTYP_HREG;

  private static final String SVC_CD_CONTACT_TYPE_PAL_MNTH_J = CodesTables.CCNTCTYP_JMTH;
  private static final String SVC_CD_CONTACT_TYPE_PAL_REG = CodesTables.CCNTCTYP_JREG;

  private static final String SVC_CD_CON_TYPE_REGULAR_I = CodesTables.CCNTCTYP_IREG;
  private static final String SVC_CD_CON_PERS_HOME_STUDY_I = CodesTables.CCNTCTYP_IPHS;
  private static final String SVC_CD_CON_TYPE_CORR_ACTION_I = CodesTables.CCNTCTYP_IATP;
  private static final String SVC_CD_CON_TYPE_DEVELOP_PLAN_I = CodesTables.CCNTCTYP_IDVP;

  private static final String SVC_CD_CON_TYPE_FAD_CLOS_SUMM_I = CodesTables.CCNTCTYP_IFCL;
  private static final String SVC_CD_CON_TYPE_MONTH_ASSES_I = CodesTables.CCNTCTYP_IMAS;
  private static final String SVC_CD_CON_TYPE_REEVALUATION_I = CodesTables.CCNTCTYP_IREA;
  private static final String SVC_CD_CON_TYPE_SERIOUS_INC_I = CodesTables.CCNTCTYP_ISEI;
  private static final String SVC_CD_CON_TYPE_VARIANCE_I = CodesTables.CCNTCTYP_IVAR;
  private static final String SVC_CD_CON_TYPE_VIOLATION_I = CodesTables.CCNTCTYP_IVIO;

  private static final String SVC_CD_CONTACT_REQUEST_REVIEW = CodesTables.CCNTCTYP_EREV;

  private static final String SVC_CD_CONTACT_TYPE_FPR_MNTH = CodesTables.CCNTCTYP_BMTH;
  private static final String SVC_CD_CONTACT_TYPE_SUB_MNTH = CodesTables.CCNTCTYP_GMTH;
  private static final String SVC_CD_CONTACT_TYPE_ADO_MNTH = CodesTables.CCNTCTYP_HMTH;
  private static final String SVC_CD_CONTACT_TYPE_MONTH_STAT = CodesTables.CCNTCTYP_CMST;
  private static final String SVC_CD_CONTACT_TYPE_PAL_MNTH = "MTH";
  private static final String SVC_CD_CONTACT_THREE_MONTH = CodesTables.CCNTCTYP_C3MT;
  private static final String[] ContactTypes1 = {SVC_CD_CONTACT_TYPE_FPR_MNTH, SVC_CD_CONTACT_TYPE_SUB_MNTH,
                                                 SVC_CD_CONTACT_TYPE_ADO_MNTH, SVC_CD_CONTACT_TYPE_MONTH_STAT,
                                                 SVC_CD_CONTACT_TYPE_PAL_MNTH, SVC_CD_CONTACT_THREE_MONTH};
  private static final List ContactTypesList_1 = Arrays.asList(ContactTypes1);
  /*
  ** Service Delivery Task Codes.
  */
  private static final String SVC_CD_TASK_CONTACT_APS_INV = "2030";
  private static final String SVC_CD_TASK_CONTACT_APS = "6020";
  private static final String SVC_CD_TASK_CONTACT_FPR = "7020";

  private static final String SVC_CD_TASK_CONTACT_ADO = "8520";
  private static final String SVC_CD_TASK_CONTACT_AOC = "5010";
  private static final String SVC_CD_TASK_CONTACT_FMR = "5570";
  private static final String SVC_CD_TASK_CONTACT_FSC = "4120";
  private static final String SVC_CD_TASK_CONTACT_PAD = "9010";
  private static final String SVC_CD_TASK_CONTACT_SUB = "3010";

  private static final String SVC_CD_CONTACT_CORRECT_ACT_SUM = "ATZ";
  private static final String SVC_CD_CONTACT_DEVELOP_PLAN_SUM = "DVZ";
  private static final String SVC_CD_CONTACT_CLOSING_SUM_SUM = "FAZ";
  private static final String SVC_CD_CONTACT_MONTH_ASSESS_SUM = "MAZ";
  private static final String SVC_CD_CONTACT_PERS_HOME_STUDY_SUM = "PHZ";
  private static final String SVC_CD_CONTACT_QUARTER_VISIT_SUM = "QUZ";
  private static final String SVC_CD_CONTACT_REEVALUATION_SUM = "REE";
  private static final String SVC_CD_CONTACT_REGULAR_SUM = "REZ";
  private static final String SVC_CD_CONTACT_SERIOUS_INC_SUM = "SEZ";
  private static final String SVC_CD_CONTACT_VARIANCE_SUM = "VAZ";
  private static final String SVC_CD_CONTACT_VIOLATION_SUM = "VIZ";
  private static final String SVC_CD_CON_QUARTER_VISIT_I = "IQUV";

  private static final String CD_PAL_SERVICE_CATGORY = CodesTables.CPALSVCC_TRN;

  private AllegationDAO allegationDAO = null;
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private CheckStageEventStatus checkStageEventStatus = null;
  private ComplexStageDAO complexStageDAO = null;
  private ContactDAO contactDAO = null;
  private ContactCbxDAO contactCbxDAO = null;
  private ContactNarrativeDAO contactNarrativeDAO = null;
  private ContactPrivConverCbxDAO contactPrivConverCbxDAO = null;
  private DynamicContactDAO dynamicContactDAO = null;
  private EventDAO eventDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private FacilAllegPriorReviewDAO facilAllegPriorReviewDAO = null;
  private FacilityInvstDtlDAO facilityInvstDtlDAO = null;
  private InvalidateApproval invalidateApproval = null;
  private PalServiceDAO palServiceDAO = null;
  private PostEvent postEvent = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoCommonFunction todoCommonFunction = null;
  private TodoDAO todoDAO = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private PortalUserDAO portalUserDAO = null;
  private ContactDiscussedCbxDAO contactDiscussedCbxDAO = null;

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setContactCbxDAO(ContactCbxDAO contactCbxDAO) {
    this.contactCbxDAO = contactCbxDAO;
  }
  
  public void setContactNarrativeDAO(ContactNarrativeDAO contactNarrativeDAO) {
    this.contactNarrativeDAO = contactNarrativeDAO;
  }

  public void setContactPrivConverCbxDAO(ContactPrivConverCbxDAO contactPrivConverCbxDAO) {
    this.contactPrivConverCbxDAO = contactPrivConverCbxDAO;
  }
  
  public void setDynamicContactDAO(DynamicContactDAO dynamicContactDAO) {
    this.dynamicContactDAO = dynamicContactDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setFacilAllegPriorReviewDAO(FacilAllegPriorReviewDAO facilAllegPriorReviewDAO) {
    this.facilAllegPriorReviewDAO = facilAllegPriorReviewDAO;
  }

  public void setFacilityInvstDtlDAO(FacilityInvstDtlDAO facilityInvstDtlDAO) {
    this.facilityInvstDtlDAO = facilityInvstDtlDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPalServiceDAO(PalServiceDAO palServiceDAO) {
    this.palServiceDAO = palServiceDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }
  
  public void setContactDiscussedCbxDAO(ContactDiscussedCbxDAO contactDiscussedCbxDAO) {
    this.contactDiscussedCbxDAO = contactDiscussedCbxDAO;
  }

  public CSYS07SO contactDetailSave(CSYS07SI csys07si) throws ServiceException {

    CSYS07SO csys07so = new CSYS07SO();
    Contact portalSave = null;
    boolean bFaceToFaceExists = true;
    int ulInvalidateIdEvent = 0;
    ArchInputStruct archInputStruct = csys07si.getArchInputStruct();
    String cReqFuncCd = csys07si.getArchInputStruct().getCReqFuncCd();
    ROWCCMN01UIG00 rowccmn01uig00 = csys07si.getROWCCMN01UIG00();
    int rowccmn01uig00IdStage = rowccmn01uig00.getUlIdStage();
    int idCase = csys07si.getUlIdCase();
    int idEvent = csys07si.getUlIdEvent();
    int rowccmn01uig00IdEvent = rowccmn01uig00.getUlIdEvent();
    String szCdContactType = csys07si.getSzCdContactType();
    String szCdContactMethod = csys07si.getSzCdContactMethod();
    String szCdContactLocation = csys07si.getSzCdContactLocation();
    String szCdContactOthers = csys07si.getSzCdContactOthers();
    //portalSave.setIndExtDocNarrAccept(csys07si.getIndExtDocAccepted());
    //contactDAO.saveContact(portalSave);
    // MR-024 Get the PurposeOptions from the csys07si array
    ContactCbxRecord_Array contactCbxArray = csys07si.getContactCbxRecord_Array();
    List<String> cdPurposeList = new ArrayList<String>();
    if (contactCbxArray != null || contactCbxArray.getUlRowQty() > 0) {     
      Enumeration<ContactCbxRecord> ContactCbxRecordEnumeration = contactCbxArray.enumerateContactCbxRecord();
      while (ContactCbxRecordEnumeration.hasMoreElements()) {
        ContactCbxRecord cbx = (ContactCbxRecord) ContactCbxRecordEnumeration.nextElement();
        if (CodesTables.CCNTPURP.equals(cbx.getSzCdCbxCodeType())) {
          String cdPurpose = cbx.getSzCdContactCbx();
          cdPurposeList.add(cdPurpose);
        }
      }
    }
    //End MR-024
    // Do not execute CheckStageEventStatus if Contact was recorded on a closed stage
    if (!SVC_TYPE_CHAR_CLOSED.equals(szCdContactType.substring(0, 1))) {
      // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(archInputStruct);
      ccmn06ui.setUlIdStage(rowccmn01uig00IdStage);
      ccmn06ui.setSzCdTask(rowccmn01uig00.getSzCdTask());
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      checkStageEventStatus.status(ccmn06ui);
    }
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)
        && CodesTables.CCNTCTYP_EREV.equals(szCdContactType)) {
      //CallCSYS19D
      csys07so.setNbrContact((int) contactDAO.countContactsByIdStageAndContactTypeEREV(
              rowccmn01uig00IdStage));

    }
    if (rowccmn01uig00IdEvent == 0 &&
        ContactTypesList_1.contains(szCdContactType)) {
      //FindNEWContacts
      Integer idEventNew = findNEWContacts(rowccmn01uig00IdStage, szCdContactType);
      if (idEventNew == null) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      } else {
        // The returned idEvent (new) is set to the var which stores the
        // value of 'csys07si.getROWCCMN01UIG00().getUlIdEvent()'
        rowccmn01uig00IdEvent = idEventNew;
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
        //CallCSYS11D
        Map contactInfo = contactDAO.findContactByPersonEventAndIdEvent(idEventNew);
        if (contactInfo == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        csys07si.setTsSysTsLastUpdate2((Date) contactInfo.get("dtLastUpdate"));
        // updating dtLastUpdate value of rowccmno1uig00 (remember that
        // this var was initialized with csys07si.getROWCCMN01UIG00() )
        rowccmn01uig00.setTsLastUpdate((Date) contactInfo.get("cdtLastUpdate"));
      }
    }
    // At this point, we either have an ID EVENT and the function
    // is UPDATE, or we have no ID EVENT and the function is ADD.
    // In addition, we may have an ID EVENT and a function of DELETE.
    // If the client was given an ID EVENT that wasn't NEW, we are
    // Updating an existing Event. If the Event status is PENDing then
    // we will Invalidate the Approval associated with th Pending Contact.
    String szCdEventStatus = csys07si.getROWCCMN01UIG00().getSzCdEventStatus();
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd) ||
        ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      if (!StringHelper.isTrue(csys07si.getArchInputStruct().getUlSysNbrReserved1()) &&
          CodesTables.CEVTSTAT_PEND.equals(szCdEventStatus)) {

        //  Set the invalidation event to the Contact Event
        // passed into the client. Demote it's status to COMPlete.
        // Event status' for non PENDing Events are set in the
        // Client.
        ulInvalidateIdEvent = rowccmn01uig00IdEvent;
        //csys07si.getROWCCMN01UIG00().setSzCdEventStatus(SVC_CD_EVENT_STATUS_COMPLETE);
        szCdEventStatus = SVC_CD_EVENT_STATUS_COMPLETE;
      }
    }
    // Instead, if there was a PENDing CONCLusion Event found in the
    // retrieval service, we should invalidate this Approval Package.
    // Mode passed in is irrelevent here.
    // First we update the status of the Conclusion Event to COMPlete.
    // ( CallCCMN62D() actually sets the status and calls the DAM. )
    // IMPACT BEGIN - Don't demote events when in "Approver mode"
   // else if (!StringHelper.isTrue(csys07si.getArchInputStruct().getUlSysNbrReserved1()) && 0 != idEvent) {
      //CallCCMN62D Updates status column of Event table. Ignores timestamp
      
      //STGAP00014856  Commented out the following code as we do not want to update the Conclusion event status and don't 
      // want to invalidate conclusion event while adding a new contact.
      //eventDAO.updateEventByIdEvent(idEvent, SVC_CD_EVENT_STATUS_COMPLETE);
      // Set the Invalidation Event to the Conclusion Event.
      //ulInvalidateIdEvent = csys07si.getUlIdEvent();
  //  }
    // If any code which set the ulInvalidateIdEvent is executed, then
    // call InvalidateAprvl().
    if (ulInvalidateIdEvent != 0) {
      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setArchInputStruct(new ArchInputStruct());
      ccmn05ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
      ccmn05ui.setUlIdEvent(ulInvalidateIdEvent);
      //InvalidateAprvl
      //this throws an exception that will halt processing with a message if it fails; success is no output.
      invalidateApproval.invalidateApproval(ccmn05ui);
    }
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Two additional tables have to be DELETEd from if the user
      // has requested a DELETE. Todo and APPROVAL_EVENT_LINK using ID EVENT.
      //CallCSYS17D
      //csys17d
      todoDAO.deleteTodoByIdEvent(rowccmn01uig00IdEvent);
      //CallCCMN91D
      //ccmn91d
      approvalEventLinkDAO.deleteApprovalEventLinkByIdEvent(rowccmn01uig00IdEvent);
    }
    // Create ToDo and Contact Shell for first Face to Face
    // Contact that is created for a stage.
    String szCdStage = csys07si.getSzCdStage();
    if (CodesTables.CCNTMETH_FTF.equals(szCdContactMethod) && CodesTables.CSTAGES_AOC.equals(szCdStage)) {
      // We don't want to create the Todo and Contact shell for the first
      // face to face if the stage is AOC. This will be created when
      // the Guardianship is filed and letters received
      // ACorley  - Although this is only done for APS in the baseline, leaving the
      // code in b/c it may be useful in GA
      if (CodesTables.CPGRMS_APS.equals(csys07si.getSzCdStageClassification()) &&
          !CodesTables.CSTAGES_AOC.equals(szCdStage) && !CodesTables.CSTAGES_ARI.equals(szCdStage)) {
        //CallCSYS04D1
        // Searches and Retrieves a page of contacts matching the input
        // search criteria from the Contact window. This call specifically
        // looks if any other Face To Face contacts exist for the given stage.
        List<Object[]> contactInfo = findContacts2(csys07si);
        if (contactInfo == null || contactInfo.isEmpty()) {
          bFaceToFaceExists = false;
        }
      } else if (CodesTables.CSTAGES_AOC.equals(szCdStage)) {
        bFaceToFaceExists = true;
      }
    }
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Delete all rows from the Event_person_link table
      // before trying to delete from the Event table
      //CallCSVC32D
      //csvc32d
      eventPersonLinkDAO.deleteEventPersonLinkByIdEvent(rowccmn01uig00IdEvent);
    }

    // Call PostEvent(), either ADDing or UPDATEing the Event record. The
    // Status was set in the client if the Event was not PENDing. Otherwise
    // the status was set above.

    //CallPostEvent
    int idEventReturned = callPostEvent(rowccmn01uig00IdEvent, cReqFuncCd, rowccmn01uig00);
    csys07si.setUlIdEvent(idEventReturned);
    if (0 == rowccmn01uig00IdEvent) {
      rowccmn01uig00IdEvent = idEventReturned;
    }
    // The following DAO call handles adding people to Event Person Link
    // instead of the PostEvent Function.
    //CallCCMN68D
    insertEventPersonLink(rowccmn01uig00IdEvent, csys07si.getROWCSVC02SIG03_ARRAY());
    // If the client requests a DELETE, and it's a user gen'd Todo,
    // then we don't need to call the CONTACT AUD; the record does not
    // exist. If the client requests an UPDATE, we need to ADD the record.
    // Note that ulPageSizeNbr is being used as an indicator for User
    // Generated To-Dos.
    if (csys07si.getArchInputStruct().getUlPageSizeNbr() == 0 ||
        !ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      updateContact(csys07si, rowccmn01uig00IdStage, cReqFuncCd);
    } else if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      updateContact(csys07si, rowccmn01uig00IdStage, ServiceConstants.REQ_FUNC_CD_ADD);
    }

    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // utilized in createNEWContacts()
      // Set todo status to complete, if any exist.
      if (SVC_CD_EVENT_STATUS_COMPLETE.equals(szCdEventStatus)) {
        //CallCINV43D
        todoDAO.updateTodoByIdEvent(rowccmn01uig00IdEvent);
      }
      // If we are dealing with one of the Contact Types that require
      // System Generated To-Do's, and we have marked the Event COMPlete, then
      // we need to create a new set of Contact Shells, NEW Events,and To-Dos.
      // One exception:
      // If the Contact was already marked COMPlete during an earlier Save,
      // and we are modifying the Event, then we do NOT want to create another
      // To-Do, Contact Shell, nor NEW Event.
      if (SVC_CD_EVENT_STATUS_COMPLETE.equals(szCdEventStatus) &&
          ContactTypesList_1.contains(szCdContactType) &&
          csys07si.getArchInputStruct().getUlPageSizeNbr() != 1) {
        //CallCSYS21D
        long contactShellCount = contactDAO.countContactShellCountByIdStage(rowccmn01uig00IdStage);
        if (contactShellCount == 0) {
          //CreateNEWContacts
          createNEWContacts(csys07si, false, false);
        }
      }
      // Create ToDo and Contact Shell for first Face to Face
      // Contact that is created for a stage.
      // Changed the following condition for FacetoFace
      // contacts from an independent IF statement to an else if
      // condition so that only one ToDo is created.  Previously,
      // if on the first contact the user selected type Monthly
      // Status and Face to Face type the system created two identical
      // ToDos.
      else if (!bFaceToFaceExists) {
        //CreateNEWContacts
        createNEWContacts(csys07si, bFaceToFaceExists, false);
      }
      if (SVC_CD_EVENT_STATUS_COMPLETE.equals(szCdEventStatus)
          // Original code CompareType(csys07si, SVC_CD_CONTACT_TYPE_FPR_MNTH) != 0
          //  method CompareType checks for null string condition on cdContactType,
          //  and if not null, if cdContactType substring(1) equals CONTACT_TYPE,
          //  returns true, else returns false.
          && (SVC_CD_CONTACT_TYPE_FPR_MNTH.equals(szCdContactType)
              || SVC_CD_CONTACT_TYPE_SUB_MNTH.equals(szCdContactType)
              || SVC_CD_CONTACT_TYPE_ADO_MNTH.equals(szCdContactType)
              || SVC_CD_CONTACT_TYPE_PAL_MNTH.equals(szCdContactType)
              || SVC_CD_CONTACT_PERS_HOME_STUDY_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_QUARTER_VISIT_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_REGULAR_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_CORRECT_ACT_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_DEVELOP_PLAN_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_CLOSING_SUM_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_MONTH_ASSESS_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_REEVALUATION_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_SERIOUS_INC_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_VARIANCE_SUM.equals(szCdContactType)
              || SVC_CD_CONTACT_VIOLATION_SUM.equals(szCdContactType))) {
        //CallCSYS04D
        //MR-024 Changed to accept cdPurposeList
        EventIdStruct_ARRAY eventIdStruct_array = findContacts1(rowccmn01uig00IdStage, idCase, idEvent, szCdContactType,
                                                                cdPurposeList, szCdContactMethod,
                                                                szCdContactLocation, szCdContactOthers,
                                                                csys07si.getDtDtMonthlySummBegin(),
                                                                csys07si.getDtDtMonthlySummEnd());
        if (eventIdStruct_array != null) {
          csys07so.setEventIdStruct_ARRAY(eventIdStruct_array);
        }
      }
    }
    if (SVC_CD_CONTACT_REQUEST_REVIEW.equals(szCdContactType)
        && !StringHelper.isTrue(csys07si.getBIndReview())) {
      //CallCLSC16Dint
      // performs a full row retrieval from the allegation,
      // facility_allegation and person tables.
      if (0 == insertFacilAllegPriorReview(rowccmn01uig00IdStage)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      // Original description from CSYS07S.src:
      // This DAM select information about the original facility
      // investigation into designated variables in the
      // facility_invst_dtl table.
      //
      // HOWEVER I could not determine a usage or result for this method.
      //CallCINVC1D
      //cinvc1d
      List<Map> facilityInvstDtlInfo =
              facilityInvstDtlDAO.findFacilityInvstDtlOvrallDisCompltReasonClosedByIdStage(rowccmn01uig00IdStage);
      if (facilityInvstDtlInfo == null || facilityInvstDtlInfo.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd) &&
        CodesTables.CCNTCTYP_EREV.equals(szCdContactType) &&
        csys07so.getNbrContact() == 1) {
      //cinvb9d
      facilAllegPriorReviewDAO.deleteFacilAllegPriorReviewByIdStage(rowccmn01uig00IdStage);
      //cinvc2d
      facilityInvstDtlDAO.updateFacilInvstDtlSetNullByIdStage(rowccmn01uig00IdStage);
    }
    // CORLEYAN - Removed APS functionality
    if (CodesTables.CPGRMS_CPS.equals(csys07si.getSzCdStageClassification())
        && CodesTables.CSTAGES_SUB.equals(szCdStage)
        && CodesTables.CCNTCTYP_GSCS.equals(szCdContactType)) {
      //cseca9d
      Map stagePersonLinkInfo = stagePersonLinkDAO.findIdPersonByIdCaseAndIdStage(csys07si.getUlIdCase(),
                                                                                  rowccmn01uig00IdStage,
                                                                                  CodesTables.CSTAGES_PAL,
                                                                                  CodesTables.CROLEALL_PC);
      if (stagePersonLinkInfo != null && !stagePersonLinkInfo.isEmpty()) {
        csys07so.setUlIdPalStage((Integer) stagePersonLinkInfo.get("stage") != null ? (Integer) stagePersonLinkInfo.get(
                "stage") : 0);
        csys07so.setUlIdPlcmtChild((Integer) stagePersonLinkInfo.get("person") != null ?
                                   (Integer) stagePersonLinkInfo.get("person") : 0);
      }

      boolean bIndSendPalFollowup;
      if (csys07so.getUlIdPalStage() > 0) {
        //CallCMSC14D
        bIndSendPalFollowup = countPalServiceType(csys07so.getUlIdPalStage(), csys07so.getUlIdPlcmtChild());

        if (bIndSendPalFollowup) {
          //CallCINV51D//cinv51d
          int idTodoPersAssigned = complexStageDAO.findPrimaryWorker(csys07so.getUlIdPalStage(),
                                                                     CodesTables.CROLEALL_PR);

          if (idTodoPersAssigned == 0) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          csys07so.setUlIdPalWorker(idTodoPersAssigned);
          //SendToDoToPalWrkr
          sendToDoToPalWrkr(csys07si, csys07so);
        }
      }
    }
    
    //If this is a portal contact, we should not have an id person associated to the event
    //This is cleared after the save because of the necessity of passing a real person ID
    //in the postEvent method.
    if ((csys07si.getUlIdPortalUser()!=0)&&(!(ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)))) {
      
      Event event = (Event) getPersistentObject(Event.class, csys07si.getUlIdEvent());
      event.setPerson(null);
      eventDAO.saveEvent(event);
    }
    
    // ACorley - removed AFC
    csys07so.setUlIdEvent(csys07si.getUlIdEvent());
    return csys07so;
  }

  private void updateContact(CSYS07SI csys07si, int idStage, String reqFuncCd) throws ServiceException {
    Contact contact = null;
    
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)){
      contact = getPersistentObject(Contact.class, csys07si.getUlIdEvent());
    } else if(ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
      contact = new Contact();
    } else if(ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
      //-- delete any CONTACT_CBX entries
      contactCbxDAO.deleteContactCbxByIdContactEvent(csys07si.getUlIdEvent());
      //MR-024 delele any CONTACT_PRIV_CONVERSATION ENTRIES
      int rowsDeleted = contactPrivConverCbxDAO.deletePrivConversationMembersByEvent(csys07si.getUlIdEvent());
      
      //MR-072 delele any CONTACT_DISCUSSED_CBX ENTRIES
      rowsDeleted = contactDiscussedCbxDAO.deleteDiscussedMembersByEvent(csys07si.getUlIdEvent());
      
      //-- delete contact
      rowsDeleted = contactDAO.deleteContactByIdEvent(csys07si.getUlIdEvent(), csys07si.getTsSysTsLastUpdate2());
      if (0 == rowsDeleted) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      return;
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    String nmPersonFull = null;
    if(csys07si.getUlIdPerson() != 0){
      Person person = (Person) getPersistentObject(Person.class, csys07si.getUlIdPerson());
      nmPersonFull = person.getNmPersonFull();
      contact.setPerson(person);
    }
    Event event = (Event) getPersistentObject(Event.class, csys07si.getUlIdEvent());
    contact.setEvent(event);
    contact.setStage(stage);
    if (DateHelper.isNull(csys07si.getDtDtMonthlySummBegin())) {
      contact.setDtCntctMnthlySummBeg(null);
    } else {
      contact.setDtCntctMnthlySummBeg(DateHelper.toJavaDate(csys07si.getDtDtMonthlySummBegin()));
    }
    if (DateHelper.isNull(csys07si.getDtDtMonthlySummEnd())) {
      contact.setDtCntctMnthlySummEnd(null);
    } else {
      contact.setDtCntctMnthlySummEnd(DateHelper.toJavaDate(csys07si.getDtDtMonthlySummEnd()));
    }
    contact.setIndContactAttempted(csys07si.getBIndContactAttempted());
    if(csys07si.getUlIdPerson() == 0){
      contact.setIndExtDocNarrAccept(csys07si.getIndExtDocAccepted());
      }
    
    //save date contacted with time and date
    try {
      Date dateContactedAsJavaUtilDate = null;
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
      org.exolab.castor.types.Date dateContacted = csys07si.getDtDTContactOccurred();
      String dateContactedAsStr = "";
      if (!"".equals(csys07si.getTmScrTmCntct()))
        dateContactedAsStr = dateContacted.toString() + " " + csys07si.getTmScrTmCntct();
      dateContactedAsJavaUtilDate = formatter.parse(dateContactedAsStr);
      contact.setDtContactOccurred(dateContactedAsJavaUtilDate);
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }
    //contact.setDtContactOccurred(DateHelper.toJavaDate(csys07si.getDtDTContactOccurred()));
    
    contact.setCdContactLocation(csys07si.getSzCdContactLocation());
    contact.setCdContactMethod(csys07si.getSzCdContactMethod());
    contact.setCdContactOthers(csys07si.getSzCdContactOthers());
   // MR-024 Add cdContactedBy , nmContactedBy ,narrative_type
    contact.setCdContactPurpose(csys07si.getSzCdContactPurpose());
    contact.setCdContactedBy(csys07si.getSzCdContactedBy());
    
    if(csys07si.getSzNmContactedBy() != null && !StringHelper.EMPTY_STRING.equals(csys07si.getSzNmContactedBy())){
      contact.setNmContactedBy(csys07si.getSzNmContactedBy()); 
    }else{
      contact.setNmContactedBy(nmPersonFull); 
    }
    if(csys07si.getDtDTContactEntered() != null){
    contact.setDtEnteredOn(csys07si.getDtDTContactEntered().toDate());
    }
    contact.setCdContactNarrative(csys07si.getSzCdContactNarrative());
    
    // If a timestamp is passed in, it is because the user has indicated they want
    // to delete the document.
    // Also see if there exists a record in Contact_Narrative table of a type other than that being saved
    // e.g if you are saving STD narrative type and the narrative in the table is SPW , the record
    // in the Contact_Narrative table should get deleted.
    Date narrDate = csys07si.getTsSysTsLastUpdate3();
    if(narrDate == null){ //If narrative Date is null get it from the narrative that is saved.
      ContactNarrative contactNarrative = contactNarrativeDAO.findContactNarrativeByIdEvent(csys07si.getUlIdEvent());
      if(contactNarrative != null ){
        narrDate = contactNarrative.getDtLastUpdate();  
      }
    }
    
    if (csys07si.getTsSysTsLastUpdate3() != null || ArchitectureConstants.Y.equals(csys07si.getBIndDeleteDoc())) {  
      commonDAO.deleteRecordByEvent("CONTACT_NARRATIVE", csys07si.getUlIdEvent(), narrDate);      
    }
    
    //End-MR-024
    contact.setCdContactType(csys07si.getSzCdContactType());
    contact.setDtLastUpdate(csys07si.getTsSysTsLastUpdate2());
    contact.setNmAgencyName((csys07si.getSzNmAgencyName()));
    contact.setIndPermCrossCntyLn(csys07si.getBIndCrossCountyLines());
    if (csys07si.getUlIdPortalUser()!=0) {
      PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(csys07si.getUlIdPortalUser());
      contact.setPortalUser(portalUser);
    }
    contact.setCdPopFrom(csys07si.getSzCdPopulatedFrom());
    int idTCMClient = csys07si.getUlIdTCMClient();
    if(idTCMClient > 0) {
      contact.setPersonByIdContactTcmClient(getPersistentObject(Person.class, idTCMClient));
      contact.setCdContactTcmEligible(csys07si.getSzCdTCMEligible());
      contact.setCdContactTcmMedSvcs(csys07si.getSzCdTCMMedSvcs());
    }
    // If this is an update we need to set the idEvent in Contact, because
    // idEvent is the primary key for Contact.  Otherwise the value will be null,
    // and hibernate needs it to be zero for an Add or int for an update.
    //if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)){
    //  contact.setIdEvent(event.getIdEvent());
    //}
    //csys07d
    
    contactDAO.saveContact(contact);
    
    //-- save/delete related CONTACT_CBX records
    ContactCbxRecord_Array cbxArray = csys07si.getContactCbxRecord_Array();
    if(cbxArray != null && cbxArray.getContactCbxRecordCount() > 0) {
      for(ContactCbxRecord cbx : cbxArray.getContactCbxRecord()) {
        if(ServiceConstants.REQ_FUNC_CD_ADD.equals(cbx.getCReqFuncCd())) {
          contactCbxDAO.saveContactCbx(new ContactCbx(contact, cbx.getSzCdContactCbx(), cbx.getSzCdCbxCodeType()));
        } else if(ServiceConstants.REQ_FUNC_CD_DELETE.equals(cbx.getCReqFuncCd())) {
          contactCbxDAO.deleteContactCbx(contact.getIdEvent(), cbx.getSzCdCbxCodeType(), cbx.getSzCdContactCbx());
        }
      }
    }
 // MR-024
    // Lists of persons to either add or delete from CONTACT_PRIV_CONVER_CBX
    ROWPRIVCONVER_ARRAY rowPrivConverArray = csys07si.getROWPRIVCONVER_ARRAY();
    List<Integer> addList = new ArrayList<Integer>();
    if (rowPrivConverArray != null && rowPrivConverArray.getUlRowQty() > 0 ) {
      for (int j = 0; j < rowPrivConverArray.getUlRowQty(); j++) {
        ROWPRIVCONVER rowPrivConver = rowPrivConverArray.getROWPRIVCONVER(j);
        Integer idPerson = rowPrivConver.getUlIdPerson();
        addList.add(idPerson);
      }
    }

    ROWDELETEPRIVCONVER_ARRAY rowDeletePrivConverArray = csys07si.getROWDELETEPRIVCONVER_ARRAY();
    List<Integer> deleteList = new ArrayList<Integer>();
    if (rowDeletePrivConverArray != null && rowDeletePrivConverArray.getUlRowQty() > 0) {
      for (int j = 0; j < rowDeletePrivConverArray.getUlRowQty(); j++) {
        ROWDELETEPRIVCONVER rowDeletePrivConver = rowDeletePrivConverArray.getROWDELETEPRIVCONVER(j);
        Integer idPerson = rowDeletePrivConver.getUlIdPerson();
        deleteList.add(idPerson);
      }
    }
    if (deleteList != null && !deleteList.isEmpty()) {
      deletePrivConversationMembers(deleteList, contact.getIdEvent());
    }
    
    // MR-072
    // Lists of persons to either add or delete from CONTACT_DISCUSSED_CBX
    ROWDISCUSSED_ARRAY rowDiscussedArray = csys07si.getROWDISCUSSED_ARRAY();
    List<Integer> addDiscussedList = new ArrayList<Integer>();
    if (rowDiscussedArray != null && rowDiscussedArray.getUlRowQty() > 0 ) {
      for (int j = 0; j < rowDiscussedArray.getUlRowQty(); j++) {
        ROWDISCUSSED rowDiscussed = rowDiscussedArray.getROWDISCUSSED(j);
        Integer idPerson = rowDiscussed.getUlIdPerson();
        addDiscussedList.add(idPerson);
      }
    }

    ROWDELETEDISCUSSED_ARRAY rowDeleteDiscussedArray = csys07si.getROWDELETEDISCUSSED_ARRAY();
    List<Integer> deleteDiscussedList = new ArrayList<Integer>();
    if (rowDeleteDiscussedArray != null && rowDeleteDiscussedArray.getUlRowQty() > 0) {
      for (int j = 0; j < rowDeleteDiscussedArray.getUlRowQty(); j++) {
        ROWDELETEDISCUSSED rowDeleteDiscussed = rowDeleteDiscussedArray.getROWDELETEDISCUSSED(j);
        Integer idPerson = rowDeleteDiscussed.getUlIdPerson();
        deleteDiscussedList.add(idPerson);
      }
    }
    if (deleteDiscussedList != null && !deleteDiscussedList.isEmpty()) {
      for (Iterator <Integer> it = deleteDiscussedList.iterator(); it.hasNext();) {    
        int idDiscussedPerson = it.next().intValue();
        contactDiscussedCbxDAO.deleteDiscussedMembersByPersonAndEvent(idDiscussedPerson, contact.getIdEvent()); 
      }
    }

    // Get the list of persons selected for the event from Event Person Link.
    // Check if the Person selected for Private Conversation is also selected (left hand side check box) for the
    // event if yes, then save this person else don't save.

    List<EventPersonLink> epl = eventPersonLinkDAO.findEventPersonLinkAndPersonByIdEvent(contact.getIdEvent());
    List<Integer> eplList = new ArrayList<Integer>();

    if (epl != null && !epl.isEmpty()) {
      for (Iterator<EventPersonLink> it = epl.iterator(); it.hasNext();) {
        EventPersonLink eplRow = (EventPersonLink) it.next();
        Integer eplListPerson = eplRow.getPerson().getIdPerson();
        eplList.add(eplListPerson);
      }
    }

    if ( addList != null && !addList.isEmpty()) {
      for (Iterator<Integer> it = addList.iterator(); it.hasNext();) {
        Integer idPrivConverPerson = it.next().intValue();
        if (eplList.contains(idPrivConverPerson)) {
          ContactPrivConverCbx contactPrivConverCbx = new ContactPrivConverCbx();
          contactPrivConverCbx.setContact(contact);
          contactPrivConverCbx.setIdPrivConverPerson(idPrivConverPerson);
          contactPrivConverCbxDAO.saveOrUpdatePrivConversationMembers(contactPrivConverCbx);
        }
      }
    }
    
    //MR-072 Save the discussed person in CONTACT_DISCUSSED_CBX
    if ( addDiscussedList != null && !addDiscussedList.isEmpty()) {
      for (Iterator<Integer> it = addDiscussedList.iterator(); it.hasNext();) {
        Integer idDiscussedPerson = it.next().intValue();
        ContactDiscussedCbx contactDiscussedCbx = new ContactDiscussedCbx();
        contactDiscussedCbx.setContact(contact);
        Person person = (Person) getPersistentObject(Person.class, idDiscussedPerson);
        contactDiscussedCbx.setPerson(person);
        contactDiscussedCbxDAO.saveOrUpdateDiscussedMembers(contactDiscussedCbx);
      }
    }
    

    
  }

  // Searches and Retrieves a page of contacts matching
  // the input search criteria from the Contact window
  //MR-024 Changed to accept cdPurposeList instead of single cdPurpose
  //Do impact analysis for this TODO
  private EventIdStruct_ARRAY findContacts1(int rowccmn01uig00IdStage, int idCase, int idEvent,
                                            String csys07siCdContactType, List<String> cdPurposeList,
                                            String cdContactMethod, String cdContactLocation, String cdContactOthers,
                                            org.exolab.castor.types.Date dtMonthlySummBegin,
                                            org.exolab.castor.types.Date dtMonthlySummEnd) throws ServiceException {
    String cdContactType = new String();
    if (SVC_CD_CONTACT_TYPE_FPR_MNTH.equals(csys07siCdContactType)) {
      cdContactType = SVC_CD_CONTACT_TYPE_FPR_REG;
    }
    if (SVC_CD_CONTACT_TYPE_SUB_MNTH.equals(csys07siCdContactType)) {
      cdContactType = SVC_CD_CONTACT_TYPE_SUB_REG;
    }
    if (SVC_CD_CONTACT_TYPE_ADO_MNTH.equals(csys07siCdContactType)) {
      cdContactType = SVC_CD_CONTACT_TYPE_ADO_REG;
    }
    if (SVC_CD_CONTACT_TYPE_PAL_MNTH_J.equals(csys07siCdContactType)) {
      cdContactType = SVC_CD_CONTACT_TYPE_PAL_REG;
    }
    // Skip the extra key on the front of the Contact Type to determine Category
    if (SVC_CD_CONTACT_CORRECT_ACT_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_CORR_ACTION_I;
    }
    if (SVC_CD_CONTACT_DEVELOP_PLAN_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_DEVELOP_PLAN_I;
    }
    if (SVC_CD_CONTACT_CLOSING_SUM_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_FAD_CLOS_SUMM_I;
    }
    if (SVC_CD_CONTACT_CLOSING_SUM_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_FAD_CLOS_SUMM_I;
    }
    if (SVC_CD_CONTACT_MONTH_ASSESS_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_MONTH_ASSES_I;
    }
    if (SVC_CD_CONTACT_REEVALUATION_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_REEVALUATION_I;
    }
    if (SVC_CD_CONTACT_SERIOUS_INC_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_SERIOUS_INC_I;
    }
    if (SVC_CD_CONTACT_VARIANCE_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_VARIANCE_I;
    }
    if (SVC_CD_CONTACT_VIOLATION_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_VIOLATION_I;
    }
    if (SVC_CD_CONTACT_PERS_HOME_STUDY_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_PERS_HOME_STUDY_I;
    }
    if (SVC_CD_CONTACT_QUARTER_VISIT_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_QUARTER_VISIT_I;
    }
    if (SVC_CD_CONTACT_REGULAR_SUM.equals(csys07siCdContactType.substring(1))) {
      cdContactType = SVC_CD_CON_TYPE_REGULAR_I;
    }
    String cdEventStatus = SVC_CD_EVENT_STATUS_COMPLETE;
    int idStage = rowccmn01uig00IdStage;
    Date dtScrSearchDateFrom = DateHelper.toJavaDate(dtMonthlySummBegin);
    Date dtScrSearchDateEnd = DateHelper.toJavaDate(dtMonthlySummEnd);
    // Bypassed 'pagination-oriented' code
    //csys04d
    //MR-024 Changed to accept cdPurposeList instead of single cdPurpose
   //Do impact analysis for this
    List<Object[]> contactInfo = dynamicContactDAO.findContacts(idCase, idStage, idEvent, cdEventStatus, cdContactType,
                                                                cdPurposeList, cdContactMethod, cdContactLocation,
                                                                cdContactOthers, dtScrSearchDateFrom,
                                                                dtScrSearchDateEnd);
    EventIdStruct_ARRAY eventIdStruct_array = new EventIdStruct_ARRAY();
    if (contactInfo != null && !contactInfo.isEmpty()) {
      int prevIdEvent = 0; //MR -024
      List<Integer> distinctEventContactInfo = new ArrayList<Integer>();
      for (Iterator<Object[]> it = contactInfo.iterator(); it.hasNext();) {
        Object[] row = it.next();
        EventIdStruct eventIdStructRow = new EventIdStruct();
        // Original code utilizes an int variable called 'iInitial_Row'
        // whose value appears to remain 0 throughout the for-loop process
        // I was not able to determine its function or necessity.
        // pOutputMsg->EventIdStruct[i].ulIdEvent = pCSYS04DOutputRec->ROWCSYS04DO[i-iInitial_Row].ulIdEvent;
        int idEventCurrent = (Integer) row[6]; //MR-024
        if(idEventCurrent != prevIdEvent){
        eventIdStructRow.setUlIdEvent((Integer) row[6]);
        eventIdStruct_array.addEventIdStruct(eventIdStructRow);
        prevIdEvent = idEventCurrent;
        distinctEventContactInfo.add(idEventCurrent);
      }
      }
    
      if (distinctEventContactInfo.size() > MAX_REG_SUBMITTED_CONTACTS) {
        throw new ServiceException(Messages.TOO_MANY_CONTACTS_IN_MONTHLY);
      }
    } else {
      eventIdStruct_array = null;
    }
    return eventIdStruct_array;
  }

  private List<Object[]> findContacts2(CSYS07SI csys07si) throws ServiceException {
    String cdContactType = SVC_CD_CONTACT_TYPE_MONTH_STAT;
    String cdEventStatus = CodesTables.CEVTSTAT_NEW;
    String cdContactLocation = "";
    String cdContactOthers = "";
    String cdContactPurpose = "";
    List<String> cdPurposeList = new ArrayList<String>(); //MR-024
    int idStage = csys07si.getROWCCMN01UIG00().getUlIdStage();
    Date dtScrSearchDateFrom = null;
    Date dtScrSearchDateTo = null;

    // The following method variables were NOT identified in Csys07s.java  for this method
    int idCase = csys07si.getUlIdCase();
    int idEvent = csys07si.getUlIdEvent();
    String cdContactMethod = csys07si.getSzCdContactMethod();
    //csys04d
   //MR-024 Changed to accept cdPurposeList instead of single cdPurpose
   //Do impact analysis for this
    List<Object[]> contactInfo = dynamicContactDAO.findContacts(idCase, idStage, idEvent, cdEventStatus, cdContactType,
                                                                cdPurposeList, cdContactMethod, cdContactLocation,
                                                                cdContactOthers, dtScrSearchDateFrom,
                                                                dtScrSearchDateTo);
    return contactInfo;
  }
  // Searches for Contacts which correspond to NEW Events,
  // have a given type, and belong to the given STAGE.
  // These Contacts will be shell records that must be modified during this call.

  /**
   * Updates ROWCCMN01UIG00 object contained in csys07si Searches for Contacts which correspond to NEW Events, have a
   * given type, and belong to the given STAGE. These Contacts will be shell records that must be modified during this
   * call.
   *
   * @param idStage
   * @param cdContactType
   */
  private Integer findNEWContacts(int idStage, String cdContactType) throws ServiceException {
    String cdEventStatus = CodesTables.CEVTSTAT_NEW;
    int idCase = 0;
    int idEvent = 0;
    String cdContactPurpose = null;
    List<String> cdPurposeList = new ArrayList<String>(); //MR-024
    String cdContactMethod = null;
    String cdContactLocation = null;
    String cdContactOthers = null;
    Date dtScrSearchDateFrom = null;
    Date dtScrSearchDateTo = null;
    // csys04d
   //MR-024 Changed to accept cdPurposeList instead of single cdPurpose
   //Do impact analysis for this
    List<Object[]> contactInfo = dynamicContactDAO.findContacts(idCase, idStage, idEvent, cdEventStatus, cdContactType,
                                                                cdPurposeList, cdContactMethod, cdContactLocation,
                                                                cdContactOthers, dtScrSearchDateFrom,
                                                                dtScrSearchDateTo);
    Integer idEventNew = null;
    // Take the ID EVENT of the first row returned from CSYS04D
    // and stick it in pInputMsg->ROWCCMN01UIG00.ulIdEvent.
    // Also set csys12si->ArchInputStruct.cReqFuncCd to UPDATE. All of
    // the Contact Shell data will be discarded and replaced with the
    // data entered in the client.
    if (contactInfo != null && !contactInfo.isEmpty()) {
      Iterator<Object[]> it = contactInfo.iterator();
      Object[] row = it.next();
      idEventNew = (Integer) row[6];
    }
    return idEventNew;
  }

  // Creates a NEW Event, a Contact shell, a Todo and
  // conditionally creates a second Todo ( for a Supervisor. )
  private void createNEWContacts(CSYS07SI csys07si, boolean bFaceToFaceExists, boolean bMonthlyStatusType)
          throws ServiceException {
    // Creating a duplicate contact is a very rare operation, in relative terms;
    //  therefore, it is ok to use the copy() method to automatically create a
    //   deep copy,  even though this method is relatively slow.
    CSYS07SI temp_csys07si = (CSYS07SI) csys07si.copy();

    ROWCCMN01UIG00 rowccmn01uig00 = temp_csys07si.getROWCCMN01UIG00();
    String cdTaskTemp = rowccmn01uig00.getSzCdTask();
    String cdContactTypeTemp = temp_csys07si.getSzCdContactType();
    String cdStageTypeTemp = temp_csys07si.getSzCdStage();
    int idStage = rowccmn01uig00.getUlIdStage();
    int idPerson = rowccmn01uig00.getUlIdPerson();
    org.exolab.castor.types.Date dtContactOccured = temp_csys07si.getDtDTContactOccurred();
    org.exolab.castor.types.Date dtContactEntered = temp_csys07si.getDtDTContactEntered(); //MR-024
    
    if (bMonthlyStatusType) {
      cdContactTypeTemp = SVC_CD_CONTACT_TYPE_MONTH_STAT;
      rowccmn01uig00.setSzTxtEventDescr(TXT_EVENT_DESC_MONTHLY_STATUS);
    }
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_NEW);
    rowccmn01uig00.getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(0);

    String cReqFuncCdTemp = ServiceConstants.REQ_FUNC_CD_ADD;
    int idEventTemp = 0;
    //CallPostEvent
    callPostEvent(idEventTemp, cReqFuncCdTemp, rowccmn01uig00);
    //CallTodoCommonFunction
    callTodoCommonFunction(cdTaskTemp, cdContactTypeTemp, cReqFuncCdTemp, cdStageTypeTemp, idStage, idEventTemp,
                           idPerson, bFaceToFaceExists, dtContactOccured);
    // If the Contact requires a Supervisor Todo, then get the
    // Supervisor and create another Todo.
    if (SVC_CD_CONTACT_THREE_MONTH.equals(cdContactTypeTemp)) {
      // CallCCMN60D//ccmn60d
      Map unitEmpLinkInfo = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
      // Do not create the To-Do if there is no Supervisor.
      if (unitEmpLinkInfo != null && !unitEmpLinkInfo.isEmpty()) {
        int idPersonSupervisor = (Integer) unitEmpLinkInfo.get("idPerson");
        if (idPersonSupervisor != 0) {
          idPerson = idPersonSupervisor;
          // CallTodoCommonFunction
          callTodoCommonFunction(cdTaskTemp, cdContactTypeTemp, cReqFuncCdTemp, cdStageTypeTemp, idStage, idEventTemp,
                                 idPerson, bFaceToFaceExists, dtContactOccured);
        }
      }
    }
    temp_csys07si.setUlIdPerson(0);
    temp_csys07si.setDtDTContactOccurred(null);
    //CallCSYS07D
    updateContact(temp_csys07si, idStage, cReqFuncCdTemp);
  }

  private int callPostEvent(int idEvent, String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(new ArchInputStruct());
    ccmn01ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    ROWCCMN01UIG00 rowccmn01uig00Temp = new ROWCCMN01UIG00();
    rowccmn01uig00Temp.setUlIdEvent(idEvent);
    rowccmn01uig00Temp.setUlIdStage(rowccmn01uig00.getUlIdStage());
    rowccmn01uig00Temp.setUlIdPerson(rowccmn01uig00.getUlIdPerson());
    rowccmn01uig00Temp.setSzCdTask(rowccmn01uig00.getSzCdTask());
    rowccmn01uig00Temp.setSzCdEventType(rowccmn01uig00.getSzCdEventType());
    rowccmn01uig00Temp.setDtDtEventOccurred(rowccmn01uig00.getDtDtEventOccurred());
    rowccmn01uig00Temp.setSzTxtEventDescr(rowccmn01uig00.getSzTxtEventDescr());
    rowccmn01uig00Temp.setSzCdEventStatus(rowccmn01uig00.getSzCdEventStatus());
    rowccmn01uig00Temp.setTsLastUpdate(rowccmn01uig00.getTsLastUpdate());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00Temp);
    //PostEvent;
    //this throws an exception that will halt processing with a message if it fails; success is no output.
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    return ccmn01uo.getUlIdEvent();
  }

  private void insertEventPersonLink(int idEvent, ROWCSVC02SIG03_ARRAY rowcsvc02sig03_array) {
    for (Enumeration rowcsvc02sig03Enum = rowcsvc02sig03_array.enumerateROWCSVC02SIG03();
         rowcsvc02sig03Enum.hasMoreElements();) {
      ROWCSVC02SIG03 rowcsvc02sig03 = (ROWCSVC02SIG03) rowcsvc02sig03Enum.nextElement();
      int idPerson = rowcsvc02sig03.getUlIdPerson();
      //ccmn68d
      String cdScrDataAction = rowcsvc02sig03.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction)) {
        eventPersonLinkDAO.insertEventPersonLink(idEvent, idPerson);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
        eventPersonLinkDAO.deleteEventPersonLink(idEvent, idPerson, rowcsvc02sig03.getTsLastUpdate());
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }

  private int insertFacilAllegPriorReview(int idStage) throws ServiceException {
    // clsc16d
    List<Map> allegationInfo = allegationDAO.findAllegationAllegationPerson(idStage);
    int numRows = 0;
    if (allegationInfo != null && !allegationInfo.isEmpty()) {
      for (Iterator<Map> it = allegationInfo.iterator(); it.hasNext();) {
        Map allegationMap = it.next();
        int idAllegation = (Integer) allegationMap.get("idAllegation");
        int idReviewStage = (Integer) allegationMap.get("idStage");
        int idReviewVictim = (Integer) allegationMap.get("personByIdVictim");
        int idReviewAllegedPerp = (Integer) allegationMap.get("personByIdAllegedPerpetrator");
        String cdReviewAllegDisp = (String) allegationMap.get("cdAllegDisposition");
        String cdReviewAllegType = (String) allegationMap.get("cdAllegType");
        String cdReviewAllegDispSupr = (String) allegationMap.get("cdAllegationDispSupr");
        String cdReviewAllegClss = (String) allegationMap.get("cdAllegationClss");
        String cdReviewAllegClssSupr = (String) allegationMap.get("cdAllegationClssSupr");
        // cinvb9d
        // insert information from the orginal facility
        // investigation into the FACIL_ALLEG_PRIOR_REVIEW table
        // before a request for review contact is recorded
        numRows = facilAllegPriorReviewDAO.insertFacilAllegPriorReview(idAllegation, idReviewStage, idReviewVictim,
                                                                       idReviewAllegedPerp, cdReviewAllegType,
                                                                       cdReviewAllegDisp, cdReviewAllegDispSupr,
                                                                       cdReviewAllegClss, cdReviewAllegClssSupr);
      }
    }
    return numRows;
  }

  private boolean countPalServiceType(int idStage, int idPlcmtChild) throws ServiceException {

    //cmsc14d
    long countPalServiceType = palServiceDAO.countPalServiceType(idStage, CD_PAL_SERVICE_CATGORY, idPlcmtChild,
                                                                 CodesTables.CPALSVTG_18A, CodesTables.CPALSVTG_18B,
                                                                 CodesTables.CPALSVTG_18C, CodesTables.CPALSVTG_18D,
                                                                 CodesTables.CPALSVTG_18E, CodesTables.CPALSVTG_18F);
    boolean bSysNbrValidationMsg;
    if (countPalServiceType >= 3) {
      bSysNbrValidationMsg = true;
    } else {
      bSysNbrValidationMsg = false;
    }
    return bSysNbrValidationMsg;
  }

  private void sendToDoToPalWrkr(CSYS07SI csys07si, CSYS07SO csys07so) throws ServiceException {
    CSUB40UI csub40ui = new CSUB40UI();
    Calendar cal = Calendar.getInstance();
    Date dtCurrentDate = cal.getTime();
    csub40ui.setArchInputStruct(csys07si.getArchInputStruct());
    csub40ui.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
    csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtCurrentDate));
    csub40ui.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_41_CODE);
    csub40ui.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(csys07so.getUlIdPalWorker());
    csub40ui.getCSUB40UIG00().setUlSysIdTodoCfStage(csys07so.getUlIdPalStage());
    //Csub40u.TodoCommonFunction
    todoCommonFunction.audTodo(csub40ui);
  }

  private void callTodoCommonFunction(String rowccmn01uig00CdTaskTemp, String cdContactType, String cReqFuncCdTemp,
                                      String cdStageTypeTemp, int rowccmn01uig00IdStageTemp, int idEventTemp,
                                      int idPersonTemp, boolean bFaceToFaceExists,
                                      org.exolab.castor.types.Date dtContactOccurredTemp) throws ServiceException {

    CSUB40UI csub40ui = new CSUB40UI();
    csub40ui.setArchInputStruct(new ArchInputStruct());
    CSUB40UIG00 csub40uig00 = new CSUB40UIG00();
    org.exolab.castor.types.Date dtTempDate;
    if (!bFaceToFaceExists) {
      dtTempDate = dtContactOccurredTemp;
    } else {
      dtTempDate = DateHelper.getTodayCastorDate();
    }
    // Set the date to the middle of the target month.
    dtTempDate.setDay((short) 20);
    //  The To-Do Common Function creates task to-dos based upon the
    //  to-do code. In most cases, all you need to know is the
    //  to-do code. Unfortunately, for contacts, we create *very* similar
    //  to-dos for different task codes, so we have to figure out what the
    //  task is, before we can decide which to-do needs to be created -
    //  resulting in the following long if-else statement.
    if (SVC_CD_TASK_CONTACT_SUB.equals(rowccmn01uig00CdTaskTemp)) {
      csub40uig00.setSzSysCdTodoCf(TODO_SUB_MONTHLY_SUMM);
    } else if (SVC_CD_TASK_CONTACT_FSC.equals(rowccmn01uig00CdTaskTemp)) {
      csub40uig00.setSzSysCdTodoCf(TODO_FSU_MONTHLY_SUMM);
    } else if (SVC_CD_TASK_CONTACT_FMR.equals(rowccmn01uig00CdTaskTemp)) {
      csub40uig00.setSzSysCdTodoCf(TODO_FRE_MONTHLY_SUMM);
    } else if (SVC_CD_TASK_CONTACT_FPR.equals(rowccmn01uig00CdTaskTemp)) {
      csub40uig00.setSzSysCdTodoCf(TODO_FPR_MONTHLY_SUMM);
    } else if (SVC_CD_TASK_CONTACT_ADO.equals(rowccmn01uig00CdTaskTemp)) {
      csub40uig00.setSzSysCdTodoCf(TODO_ADO_MONTHLY_SUMM);
    } else if (SVC_CD_TASK_CONTACT_PAD.equals(rowccmn01uig00CdTaskTemp)) {
      csub40uig00.setSzSysCdTodoCf(TODO_PAD_MONTHLY_SUMM);
    } else if (SVC_CD_TASK_CONTACT_APS_INV.equals(rowccmn01uig00CdTaskTemp)) {
      if (SVC_CD_CONTACT_TYPE_MONTH_STAT.equals(cdContactType)) {
        csub40uig00.setSzSysCdTodoCf(TODO_INV_MONTHLY_STAT);
      } else {
        csub40uig00.setSzSysCdTodoCf(TODO_INV_THREE_MONTH);
      }
    } else if (SVC_CD_TASK_CONTACT_AOC.equals(rowccmn01uig00CdTaskTemp)) {
      if (SVC_CD_CONTACT_TYPE_MONTH_STAT.equals(cdContactType)) {
        csub40uig00.setSzSysCdTodoCf(TODO_AOC_MONTHLY_STAT);
      }
    } else if (SVC_CD_TASK_CONTACT_APS.equals(rowccmn01uig00CdTaskTemp)) {
      if (SVC_CD_CONTACT_TYPE_MONTH_STAT.equals(cdContactType)) {
        csub40uig00.setSzSysCdTodoCf(TODO_SVC_MONTHLY_STAT);
      } else if (!"GUA".equals(cdStageTypeTemp)) {
        csub40uig00.setSzSysCdTodoCf(TODO_SVC_THREE_MONTH);
      }
    } else {
      throw new ServiceException(Messages.ARC_ERR_INTERNAL_ERROR);
    }
    csub40ui.getArchInputStruct().setCReqFuncCd(cReqFuncCdTemp);

    csub40uig00.setDtSysDtTodoCfDueFrom(dtTempDate);
    csub40uig00.setUlSysIdTodoCfStage(rowccmn01uig00IdStageTemp);
    csub40uig00.setUlSysIdTodoCfEvent(idEventTemp);
    csub40uig00.setUlSysIdTodoCfPersCrea(0);
    csub40uig00.setUlSysIdTodoCfPersWkr(idPersonTemp);
    csub40uig00.setUlSysIdTodoCfPersAssgn(idPersonTemp);
    csub40ui.setCSUB40UIG00(csub40uig00);
    todoCommonFunction.audTodo(csub40ui);
  }
  
  /**
   * This private method iterates through the delete list to delete rows from
   * CONTACT_PRIV_CONVER_CBX for principals and collaterals unclicked since last save
   *
   * @param idEvent
   * @param delList
   * @return 
   * @throws ServiceException
   */
  private void deletePrivConversationMembers (List<Integer> delList, int idEvent) throws ServiceException{

    for (Iterator <Integer> it = delList.iterator(); it.hasNext();) {    
      int idPerson = it.next().intValue();
      contactPrivConverCbxDAO.deletePrivConversationMembersByPersonAndEvent(idPerson, idEvent); 
    }
  }

}
