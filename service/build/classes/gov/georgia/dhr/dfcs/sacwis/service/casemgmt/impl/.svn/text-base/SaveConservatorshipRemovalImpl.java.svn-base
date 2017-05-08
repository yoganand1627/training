package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonHomeRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharAdultDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;
import gov.georgia.dhr.dfcs.sacwis.db.Relationship;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdultId;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChildId;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalReason;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalReasonId;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseOpenStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveConservatorshipRemoval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN03UIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB80SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB80SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
10/05/08    mxpatel           STGAP00009009: added statements to set the idCase and
                              idRemovalEvent for removal reason.
11/05/08    mxpatel           STGAP00009009: added statements to idRemovalEvent for 
                              RemovalCharAdult.     
12/18/09    mxpatel           STGAP00010881: Changed the todoDesc to include the due 
                              date.  Changed the dueDate to be 30 days from the 
                              removal date (not 15 days)   
04/21/10    mxpatel           SMS #49746: Modified the code to make sure "youth is approaching 18th birthday"
                              alert is being sent to CM,SS and ILP co-ordinators of the region.  
08/12/10    hjbaptiste        SMS#65423: MR-71 Changes  
12/07/10    htvo              SMS#81140 MR-074 AFCARS: remove code for caretaker and child char factor                                                              
10/02/11    schoi             STGAP00017013: MR-095 Expanded CCMN03UI object to hold new array object 
                              with relationship defined via Custody page
10/08/11    schoi             STGAP00017013: MR-095 Added validation for any update and pre-population logic
                              for the Caregiver/Parental Relationship for Child section on the Person Detail page                              
10/17/11    schoi             STGAP00017270: MR-095 Removed validation MSG_CONFIRM_CP_SECTION_MISMATCH  
                              when removing a child from the FCF stage

*/


public class SaveConservatorshipRemovalImpl extends BaseServiceImpl implements SaveConservatorshipRemoval {

  public static final String SUBCARE_STAGE = CodesTables.CSPCUNTS_SUB;

  public static final String STAGE_PROGRAM = CodesTables.CPGRMS_CPS;

  public static final String FAMILY_SUB_STAGE = CodesTables.CSTAGES_FSU;
  
  public static final String INV_STAGE = CodesTables.CSTAGES_INV;
  
  public static final String ONG_STAGE = CodesTables.CSTAGES_FPR;

  //public static final String SEC_STATE_OFFICE_MGMNT = "76"; // need to match with UserProfile.java

  // this is security attribute for ILP coordinator, also YDP coordinator
  //public static final String SEC_REGIONAL_SS_STF = "70"; // need to match with UserProfile.java

  public static final int CURRENT = 0;

  public static final int NEXT = 1;

  public static final String YES = ArchitectureConstants.Y;

  public static final String STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String PRIMARY_CHILD = CodesTables.CROLEALL_PC;

  public static final String FALSE = ArchitectureConstants.FALSE;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String WINDOW_MODE_NEW_USING = "2";

  public static final String WINDOW_MODE_MODIFY = "4";

  // STGAP00017013: MR-095
  private static final String PUTATIVE_FATHER = "PF";

  private static final String LEGAL_FATHER = "LF";

  private static final String BIOLOGICAL_FATHER = "BF";
  
  private static final String LEGAL_MOTHER = "LM";

  private static final String BIOLOGICAL_MOTHER = "BM";
  
  private static final String MALE = "M";
  
  private static final String FEMALE = "F";
  
  // End STGAP00017013: MR-095
  
  private CheckStageEventStatus checkStageEventStatus = null;

  private PostEvent postEvent = null;

  private EventDAO eventDAO = null;

  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel = null;

  private InvalidateApproval invalidateApproval = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  
  private RelationshipDAO relationshipDAO = null;

  private RemovalReasonDAO removalReasonDAO = null;

  private RemovalCharChildDAO removalCharChildDAO = null;

  private RemovalCharAdultDAO removalCharAdultDAO = null;

  private PersonHomeRemovalDAO personHomeRemovalDAO = null;

  private CloseOpenStage closeOpenStage = null;

  private StageDAO stageDAO = null;

  private TodoDAO todoDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;

  private PersonDAO personDAO = null;

  private PersonDtlDAO personDtlDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setRemovalReasonDAO(RemovalReasonDAO removalReasonDAO) {
    this.removalReasonDAO = removalReasonDAO;
  }
  
  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
    this.relationshipDAO = relationshipDAO;
  }

  public void setRemovalCharChildDAO(RemovalCharChildDAO removalCharChildDAO) {
    this.removalCharChildDAO = removalCharChildDAO;
  }

  public void setRemovalCharAdultDAO(RemovalCharAdultDAO removalCharAdultDAO) {
    this.removalCharAdultDAO = removalCharAdultDAO;
  }

  public void setPersonHomeRemovalDAO(PersonHomeRemovalDAO personHomeRemovalDAO) {
    this.personHomeRemovalDAO = personHomeRemovalDAO;
  }

  public void setCloseOpenStage(CloseOpenStage closeOpenStage) {
    this.closeOpenStage = closeOpenStage;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CSUB15SO saveConservatorshipRemoval(CSUB15SI csub15si, CSUB80SI csub80si) throws ServiceException {

    CSUB15SO csub15so = new CSUB15SO();

    int nbrRowsUpdated;
    Date dtDbDtRemoval = DateHelper.toJavaDate(DateHelper.MIN_CASTOR_DATE);
    Date birthDate;
    String cReqFuncCd;
    String SzCdStageOpen = SUBCARE_STAGE;
    int UlIdCase = csub15si.getROWCSUB15SIG00().getUlIdCase();
    int UlIdStage = csub15si.getROWCCMN01UIG00().getUlIdStage();
    int lNbrRemovalAgeYr = csub15si.getROWCSUB15SIG00().getLNbrRemovalAgeYr();
    int IdPerson = csub15si.getROWCCMN01UIG00().getUlIdPerson();
    Date RemovalDate = DateHelper.toJavaDate(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
    String ccmn03uiNmPersonFull = csub15si.getSzNmPersonFull();
    String todoDesc = "";
    String securityAttr = csub15si.getSzCdAttrRegSsStf();

    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(csub15si.getArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
    ccmn06ui.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
    ccmn06ui.setSzCdTask(csub15si.getROWCCMN01UIG00().getSzCdTask());

    checkStageEventStatus.status(ccmn06ui);

    CCMN01UI ccmn01ui = new CCMN01UI();

    ccmn01ui.setArchInputStruct(csub15si.getArchInputStruct());
    if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
    } else {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    ROWCCMN01UIG00 rowccmn01uigoo = new ROWCCMN01UIG00();
    rowccmn01uigoo.setSzCdEventStatus(csub15si.getROWCCMN01UIG00().getSzCdEventStatus());
    rowccmn01uigoo.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
    rowccmn01uigoo.setSzCdTask(csub15si.getROWCCMN01UIG00().getSzCdTask());
    rowccmn01uigoo.setTsLastUpdate(csub15si.getROWCCMN01UIG00().getTsLastUpdate());
    rowccmn01uigoo.setSzCdEventType(csub15si.getROWCCMN01UIG00().getSzCdEventType());
    rowccmn01uigoo.setDtDtEventOccurred(csub15si.getROWCCMN01UIG00().getDtDtEventOccurred());
    rowccmn01uigoo.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
    rowccmn01uigoo.setUlIdPerson(csub15si.getROWCCMN01UIG00().getUlIdPerson());
    rowccmn01uigoo.setSzTxtEventDescr(csub15si.getROWCCMN01UIG00().getSzTxtEventDescr());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uigoo);

    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setUlIdPerson(csub15si.getROWCSUB15SIG00().getUlIdVictim());
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    }
    rowccmn01uigoo.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    // Call PostEvent
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    csub15si.getROWCCMN01UIG00().setUlIdEvent(ccmn01uo.getUlIdEvent());
    TsLastUpdate_ARRAY tslastupdate_array = new TsLastUpdate_ARRAY();
    tslastupdate_array.addTsLastUpdate(ccmn01ui.getROWCCMN01UIG00().getTsLastUpdate());
    csub15so.setTsLastUpdate_ARRAY(tslastupdate_array);
    csub15so.setUlIdEvent(csub15si.getROWCCMN01UIG00().getUlIdEvent());
    csub15so.getTsLastUpdate_ARRAY().setTsLastUpdate(CURRENT, ccmn01ui.getROWCCMN01UIG00().getTsLastUpdate());

    if ((0 < csub15si.getUlIdEvent()) && (FALSE.equals(csub15si.getArchInputStruct().getUlSysNbrReserved1()))) {

      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setArchInputStruct(csub15si.getArchInputStruct());

      int idEvent_csub15si = csub15si.getUlIdEvent();
      String cdEventStatus = EVENT_STATUS_COMP;
      // ccmn62d -Invalidate the Conclusion event
      nbrRowsUpdated = eventDAO.updateEventByIdEvent(idEvent_csub15si, cdEventStatus);

      if (nbrRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      ccmn05ui.setUlIdEvent(idEvent_csub15si);
      invalidateApproval.invalidateApproval(ccmn05ui);
    }
    CnsrvtrshpRemoval cnsrvtrshpRemoval = new CnsrvtrshpRemoval();
    if (0 < csub15si.getROWCSUB15SIG00().getUlIdEvent()) {
      int idRemovalEvent = csub15si.getROWCSUB15SIG00().getUlIdEvent();
      // Call cses20d
      // CnsrvtrshpRemoval cnsrvtrshpRemoval = (CnsrvtrshpRemoval) getPersistentObject(CnsrvtrshpRemoval.class,
      // idRemovalEvent);
      cnsrvtrshpRemoval = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemoval(idRemovalEvent);

      if (cnsrvtrshpRemoval == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      dtDbDtRemoval = cnsrvtrshpRemoval.getDtRemoval();
    }

    cReqFuncCd = csub15si.getArchInputStruct().getCReqFuncCd();
    int idEvent_CAUD29D;
    if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
      idEvent_CAUD29D = csub15so.getUlIdEvent();
    } else {
      idEvent_CAUD29D = csub15si.getROWCCMN01UIG00().getUlIdEvent();
    }

    Event event = getPersistentObject(Event.class, idEvent_CAUD29D);
    cnsrvtrshpRemoval.setEvent(event);
    cnsrvtrshpRemoval.setDtLastUpdate(csub15si.getROWCSUB15SIG00().getTsLastUpdate());
    cnsrvtrshpRemoval.setNbrRemovalAgeMo(csub15si.getROWCSUB15SIG00().getLNbrRemovalAgeMo());
    cnsrvtrshpRemoval.setNbrRemovalAgeYr(csub15si.getROWCSUB15SIG00().getLNbrRemovalAgeYr());
    cnsrvtrshpRemoval.setIndRemovalNaCare(csub15si.getROWCSUB15SIG00().getCIndRemovalNACare());
    cnsrvtrshpRemoval.setIndRemovalNaChild(csub15si.getROWCSUB15SIG00().getCIndRemovalNaChild());
    cnsrvtrshpRemoval.setDtRemoval(DateHelper.toJavaDate(csub15si.getROWCSUB15SIG00().getDtDtRemoval()));
    cnsrvtrshpRemoval.setIndParentNotified(csub15si.getROWCSUB15SIG00().getCbParentNotified());
    cnsrvtrshpRemoval.setCdRemovalType(csub15si.getROWCSUB15SIG00().getRbRemovalType());
    cnsrvtrshpRemoval.setTxtDescriptionOfIncident(csub15si.getROWCSUB15SIG00().getTxtFactualDesc());
    Person person = getPersistentObject(Person.class, csub15si.getROWCSUB15SIG00().getUlIdVictim());
    cnsrvtrshpRemoval.setPerson(person);
    // caud29d
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      cnsrvtrshpRemovalDAO.saveCnsrvtrshpRemoval(cnsrvtrshpRemoval);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      cnsrvtrshpRemovalDAO.saveCnsrvtrshpRemoval(cnsrvtrshpRemoval);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      cnsrvtrshpRemovalDAO.deleteCnsrvtrshpRemoval(cnsrvtrshpRemoval);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    int idRemovalEvent_csub15s;
    if (0 == csub15si.getROWCCMN01UIG00().getUlIdEvent()) {
      idRemovalEvent_csub15s = csub15so.getUlIdEvent();
    } else {
      idRemovalEvent_csub15s = csub15si.getROWCCMN01UIG00().getUlIdEvent();
    }
    // cses20d
    cnsrvtrshpRemoval = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemoval(idRemovalEvent_csub15s);

    if (cnsrvtrshpRemoval == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    tslastupdate_array.addTsLastUpdate(cnsrvtrshpRemoval.getDtLastUpdate());
    csub15so.setTsLastUpdate_ARRAY(tslastupdate_array);
    csub15so.getTsLastUpdate_ARRAY().setTsLastUpdate(NEXT, cnsrvtrshpRemoval.getDtLastUpdate());

    RemovalReason removalReason = new RemovalReason();
    RemovalReasonId removalReasonId = new RemovalReasonId();
    int idEvent_csub15s;
    // While more rows are left to process continue loop.
    ROWCSUB15SIG01_ARRAY rowcsub15sig01_array = csub15si.getROWCSUB15SIG01_ARRAY();
    ROWCSUB15SIG01 rowcsub15sig01;
    Enumeration rowcsub15sig01_enum = rowcsub15sig01_array.enumerateROWCSUB15SIG01();
    
    while (rowcsub15sig01_enum.hasMoreElements()) {
      rowcsub15sig01 = (ROWCSUB15SIG01) rowcsub15sig01_enum.nextElement();

      cReqFuncCd = rowcsub15sig01.getSzCdSysDataActionOutcome();
      // int idEvent_csub15s;
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(csub15si.getArchInputStruct().getCReqFuncCd())) {
        idEvent_csub15s = csub15so.getUlIdEvent();
      } else {
        idEvent_csub15s = csub15si.getROWCCMN01UIG00().getUlIdEvent();
      }
      String cdRemovalReason = rowcsub15sig01.getSzCdRemovalReason();
      Date dtLastUpdate = rowcsub15sig01.getTsLastUpdate();
      removalReason.setDtLastUpdate(dtLastUpdate);
      removalReasonId.setCdRemovalReason(cdRemovalReason);
      removalReasonId.setIdRemovalEvent(idEvent_csub15s);
      removalReason.setId(removalReasonId);
      removalReason.setDtLastUpdate(dtLastUpdate);
      removalReason.setIdCase(csub15si.getROWCSUB15SIG00().getUlIdCase());//mxpatel added this for defect #9009 
      //csub15si.getROWCSUB15SIG00().getUlIdCase()
      // caud30d
   
      int idCase = removalReason.getIdCase();//mxpatel added this for defect #9009
      int idRemovalEvent = removalReason.getId().getIdRemovalEvent();//mxpatel added this for defect #9009
      
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        removalReasonDAO.saveRemovalReason(removalReason);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        
        nbrRowsUpdated = removalReasonDAO.updateRemovalReason(idEvent_csub15s, cdRemovalReason, dtLastUpdate);
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        removalReasonDAO.deleteRemovalReason(idCase, idRemovalEvent, cdRemovalReason);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }

    ROWCSUB15SIG02_ARRAY rowcsub15sig02_array = csub15si.getROWCSUB15SIG02_ARRAY();
    ROWCSUB15SIG02 rowcsub15sig02;
    Enumeration rowcsub15sig02_enum = rowcsub15sig02_array.enumerateROWCSUB15SIG02();
    while (rowcsub15sig02_enum.hasMoreElements()) {
      rowcsub15sig02 = (ROWCSUB15SIG02) rowcsub15sig02_enum.nextElement();
      cReqFuncCd = rowcsub15sig02.getSzCdSysDataActionOutcome();
      if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(csub15si.getArchInputStruct().getCReqFuncCd())) {
        idEvent_csub15s = csub15si.getROWCCMN01UIG00().getUlIdEvent();
      } else {
        idEvent_csub15s = csub15so.getUlIdEvent();
      }
      Date dtLastUpdate = rowcsub15sig02.getTsLastUpdate();
      String cdRemovChildChar = rowcsub15sig02.getSzCdRemovChildChar();
      String indCharChildCurrent = rowcsub15sig02.getCIndCharChildCurrent();

      RemovalCharChild removalCharChild = new RemovalCharChild();

      RemovalCharChildId removalCharChildId = new RemovalCharChildId();

      removalCharChildId.setCdRemovChildChar(cdRemovChildChar);
      removalCharChildId.setIdRemovalEvent(idEvent_csub15s);
      event = getPersistentObject(Event.class, idEvent_csub15s);
      removalCharChild.setDtLastUpdate(dtLastUpdate);
      removalCharChild.setEvent(event);
      removalCharChild.setIndCharChildCurrent(indCharChildCurrent);
      removalCharChild.setId(removalCharChildId);

      int idCase = 0;
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, idCase);
      removalCharChild.setCapsCase(capsCase);
      // caud31dAUDdam
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        removalCharChildDAO.saveRemovalCharChild(removalCharChild);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        nbrRowsUpdated = removalCharChildDAO.updateRemovalCharChild(indCharChildCurrent, dtLastUpdate, idEvent_csub15s,
                                                                    cdRemovChildChar);
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    
    // MR-074 AFCARS: removed, adult char is now part of the removal reasons

    /*ROWCSUB15SIG03_ARRAY rowcsub15sig03_array = csub15si.getROWCSUB15SIG03_ARRAY();
    ROWCSUB15SIG03 rowcsub15sig03;
    Enumeration rowcsub15sig03_enum = rowcsub15sig03_array.enumerateROWCSUB15SIG03();
    while (rowcsub15sig03_enum.hasMoreElements()) {
      rowcsub15sig03 = (ROWCSUB15SIG03) rowcsub15sig03_enum.nextElement();
      cReqFuncCd = rowcsub15sig03.getSzCdSysDataActionOutcome();
      if (!ServiceConstants.REQ_FUNC_CD_ADD.equals(csub15si.getArchInputStruct().getCReqFuncCd())) {
        idEvent_csub15s = csub15si.getROWCCMN01UIG00().getUlIdEvent();
      } else {
        idEvent_csub15s = csub15so.getUlIdEvent();
      }
      Date dtLastUpdate = rowcsub15sig03.getTsLastUpdate();
      String cdRemovAdultChar = rowcsub15sig03.getSzCdRemovAdultChar();
      RemovalCharAdult removalCharAdult = new RemovalCharAdult();
      RemovalCharAdultId removalCharAdultId = new RemovalCharAdultId();
      removalCharAdult.setId(removalCharAdultId);//mxpatel added this for defect #9009
      removalCharAdultId.setCdRemovAdultChar(cdRemovAdultChar);
      removalCharAdultId.setIdRemovalEvent(idEvent_csub15s);
      event = getPersistentObject(Event.class, idEvent_csub15s);
      int idRemovalEvent = removalCharAdult.getId().getIdRemovalEvent();//mxpatel added this for defect #9009
      
      // event.setIdEvent(idEvent_csub15s);
      removalCharAdult.setDtLastUpdate(dtLastUpdate);
      removalCharAdult.setEvent(event);
      removalCharAdult.setId(removalCharAdultId);

      // caud32d
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        removalCharAdultDAO.saveRemovalCharAdult(removalCharAdult);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        nbrRowsUpdated = removalCharAdultDAO.updateRemovalCharAdult(idEvent_csub15s, cdRemovAdultChar, dtLastUpdate);
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
       // removalCharAdultDAO.deleteRemovalCharAdult(removalCharAdult);//mxpatel commented this out for defect #9009
        removalCharAdultDAO.deleteRemovalCharAdult(idRemovalEvent, cdRemovAdultChar); //mxpatel added this for defect #9009
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }*/

    if ((WINDOW_MODE_NEW_USING.equals(csub15si.getSzSysCdWinMode()))
        && (FALSE.equals(csub15si.getBWCDIndSearchChange()))) {
      cReqFuncCd = csub15si.getArchInputStruct().getCReqFuncCd();
      idEvent_csub15s = csub15si.getROWCSUB15SIG00().getUlIdEvent();
      int sysIdNewEvent = csub15so.getUlIdEvent();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        personHomeRemovalDAO.insertPersonHomeRemoval(sysIdNewEvent, idEvent_csub15s);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }

    // check to see if FSU is open. If open then add only sub stages

    List openStages = CaseUtility.getOpenStages(UlIdCase);
    boolean isFSUOpen = false;
    for (Iterator openStageIterator = openStages.iterator(); openStageIterator.hasNext();) {
      CaseUtility.Stage stage = (CaseUtility.Stage) openStageIterator.next();
      // if (CaseUtility.hasStageAccess(user.getUserID(), stage.getIdStage())) {
      if (stage.getCdStage().equals("FSU")) {
        isFSUOpen = true;
        break;
      }

    }
    
    CCMN03UO ccmn03uo = new CCMN03UO();
    if (!(WINDOW_MODE_MODIFY.equals(csub15si.getSzSysCdWinMode()))
        || (STATUS_NEW.equals(csub15si.getSzCdEventStatus()))) {
      CCMN03UI ccmn03ui = new CCMN03UI();
      ccmn03ui.setArchInputStruct(csub15si.getArchInputStruct());
      ccmn03ui.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
      ccmn03ui.setSzCdStage(SUBCARE_STAGE);
      ccmn03ui.setSzCdStageOpen(SUBCARE_STAGE);
      ccmn03ui.setSzCdStageReasonClosed(SUBCARE_STAGE);
      ccmn03ui.setSzCdStageProgram(STAGE_PROGRAM);
      ccmn03ui.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
      ccmn03ui.setUlIdPerson(csub15si.getROWCCMN01UIG00().getUlIdPerson());
      ccmn03ui.setSzNmPersonFull(csub15si.getSzNmPersonFull());
      ccmn03ui.setCSysIndSStgOpenOnly(YES);
      ccmn03ui.setDtDtStageStart(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
      ccmn03ui.setUlScrIdPrimChild(csub15si.getROWCSUB15SIG00().getUlIdVictim());
      // STGAP00017013: MR-095
      int idRemovalChild = csub15si.getROWCSUB15SIG00().getUlIdVictim();
      ROWCCMN03UIG00_ARRAY rowccmn03uigoo_array = createROWCCMN03UIG00_ARRAY(csub80si);
      ccmn03ui.setROWCCMN03UIG00_ARRAY(rowccmn03uigoo_array);  
      // STGAP00017013: MR-095
      // Check the Mother/Father values populated from the Caregiver/Parental Relationship for Child section
      // has been updated through Custody page
      //
      // This validation should happen in INV and ONG stage only
      // When we remove child from FCF stage this validation is not needed 
      // because removal from FCF is basically carrying over the existing relationships
      String cdStageRemovalStage = stageDAO.findCdStageByIdStage(UlIdStage);
      if (INV_STAGE.equals(cdStageRemovalStage) || ONG_STAGE.equals(cdStageRemovalStage)) {
        List<Relationship> relationshipsForChild = relationshipDAO.findRelationshipByIdChildPerson(idRemovalChild);
        if (relationshipsForChild != null && !relationshipsForChild.isEmpty()) {
          boolean isRelUpdated = false;
          Iterator<Relationship> it = relationshipsForChild.iterator();
          boolean bIndCpValueCheck = csub80si.getBIndCpValueCheck();
          if (bIndCpValueCheck) {
            while (it.hasNext()) {
              Relationship relationship = it.next();
              // Secondary Caregiver will be excluded in the consideration
              if (!"SC".equals(relationship.getCdPersonRelationship())) {
                String relValue = relationship.getCdPersonRelationship();
                Person relatedPerson = relationship.getPersonByIdRelatedPerson();
                int idRelatedPerson = relatedPerson.getIdPerson();
                if (csub80si.getROWCSUB80SIG00_ARRAY() != null) {
                  ROWCSUB80SIG00_ARRAY rowcsub80sig00_array = csub80si.getROWCSUB80SIG00_ARRAY();
                  Enumeration e = rowcsub80sig00_array.enumerateROWCSUB80SIG00();
                  while (e.hasMoreElements()) {
                    ROWCSUB80SIG00 rowcsub80sig00;
                    rowcsub80sig00 = (ROWCSUB80SIG00) e.nextElement();

                    if (idRelatedPerson == rowcsub80sig00.getUlIdPersonPrincipal()) {
                      if (!relValue.equals(rowcsub80sig00.getSzCdStagePersRelInt())) {
                        // Set the flag to throw exception
                        isRelUpdated = true;
                        break;
                      }
                    }
                  }
                }
              }
            }
            if (isRelUpdated) {
              throw new ServiceException(Messages.MSG_CONFIRM_CP_SECTION_MISMATCH);
            }
          }
        }
      }
      
      // Update the Caregiver/Parental Relationship for Child section
      // if the dropdown value was blank initially 
      // and any of the corresponding Mother/Father values listed below saved in Custody page
      // Putative Father      
      // Legal Father
      // Biological Father   
      // Legal Mother   
      // Biological Mother 
      if (csub80si.getROWCSUB80SIG00_ARRAY() != null) {
        ROWCSUB80SIG00_ARRAY rowcsub80sig00_array = csub80si.getROWCSUB80SIG00_ARRAY();
        Enumeration e = rowcsub80sig00_array.enumerateROWCSUB80SIG00();

        // Add person to the corresponding List if the person has selected in Custody page 
        // as the same relationship in the Caregiver/Parental Relationship for Child section
        List<Integer> putativeFatherList = new ArrayList<Integer>();
        List<Integer> legalFatherList = new ArrayList<Integer>();
        List<Integer> bioFatherList = new ArrayList<Integer>();
        List<Integer> legalMotherList = new ArrayList<Integer>();
        List<Integer> bioMotherList = new ArrayList<Integer>();
                
        while (e.hasMoreElements()) {
          ROWCSUB80SIG00 rowcsub80sig00;
          rowcsub80sig00 = (ROWCSUB80SIG00) e.nextElement(); 
          
          // Get the person Gender for updating correct dropdown value in the C/P section
          String cdPrincipalGender = personDAO.findCdPersonSexByIdPerson(rowcsub80sig00.getUlIdPersonPrincipal());

          if (PUTATIVE_FATHER.equals(rowcsub80sig00.getSzCdStagePersRelInt()) && MALE.equals(cdPrincipalGender)) {
            putativeFatherList.add(rowcsub80sig00.getUlIdPersonPrincipal());
          } else if (LEGAL_FATHER.equals(rowcsub80sig00.getSzCdStagePersRelInt()) && MALE.equals(cdPrincipalGender)) {
            legalFatherList.add(rowcsub80sig00.getUlIdPersonPrincipal());
          } else if (BIOLOGICAL_FATHER.equals(rowcsub80sig00.getSzCdStagePersRelInt()) && MALE.equals(cdPrincipalGender)) {
            bioFatherList.add(rowcsub80sig00.getUlIdPersonPrincipal());
          } else if (LEGAL_MOTHER.equals(rowcsub80sig00.getSzCdStagePersRelInt()) && FEMALE.equals(cdPrincipalGender)) {
            legalMotherList.add(rowcsub80sig00.getUlIdPersonPrincipal());
          } else if (BIOLOGICAL_MOTHER.equals(rowcsub80sig00.getSzCdStagePersRelInt()) && FEMALE.equals(cdPrincipalGender)) {
            bioMotherList.add(rowcsub80sig00.getUlIdPersonPrincipal());
          }
        }
        
        int idRelatePersonPutativeFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idRemovalChild,
                                                                                                    PUTATIVE_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                        .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                   idRemovalChild,
                                                                                                                                                                                                   PUTATIVE_FATHER)
                                                                                                                            : 0;

        int idRelatePersonLegalFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idRemovalChild,
                                                                                                 LEGAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                  .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                             idRemovalChild,
                                                                                                                                                                                             LEGAL_FATHER)
                                                                                                                      : 0;

        int idRelatePersonBioFather = (Integer) relationshipDAO.findRelationshipIdRelationship(idRemovalChild,
                                                                                               BIOLOGICAL_FATHER) != null ? (Integer) relationshipDAO
                                                                                                                                                     .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                idRemovalChild,
                                                                                                                                                                                                BIOLOGICAL_FATHER)
                                                                                                                         : 0;

        int idRelatePersonLegalMother = (Integer) relationshipDAO.findRelationshipIdRelationship(idRemovalChild,
                                                                                                 LEGAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                  .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                             idRemovalChild,
                                                                                                                                                                                             LEGAL_MOTHER)
                                                                                                                      : 0;

        int idRelatePersonBioMother = (Integer) relationshipDAO.findRelationshipIdRelationship(idRemovalChild,
                                                                                               BIOLOGICAL_MOTHER) != null ? (Integer) relationshipDAO
                                                                                                                                                     .findRelationshipIdRelatedPersonByIdPerson(
                                                                                                                                                                                                idRemovalChild,
                                                                                                                                                                                                BIOLOGICAL_MOTHER)
                                                                                                                         : 0;

        // Get the Primary Caretaker ID
        int idPrimaryCaretaker = findIdPrimaryCaretaker(UlIdStage);
        
        // Get the PK Gender for updating correct dropdown value in the C/P section
        String cdPKGender = personDAO.findCdPersonSexByIdPerson(idPrimaryCaretaker);

        if (idRelatePersonPutativeFather == 0 && putativeFatherList.size() > 0) {
          if (idPrimaryCaretaker > 0 && putativeFatherList.contains(idPrimaryCaretaker)) {
            // Check if the Primary Caretaker has selected in the C/P section
            // If the PK is selected, set PK as the person on the C/P section

            if (MALE.equals(cdPKGender)) {
              relationshipDAO.saveRelationship(idRelatePersonPutativeFather, idRemovalChild, idPrimaryCaretaker,
                                               PUTATIVE_FATHER);
            } else {
              // If PK does not have the correct Gender for the dropdown on the C/P section
              // Set the person with the highest ID_PERSON as the person on the section
              Person personFound = personDAO.findMostRecentPersonByIdPerson(legalFatherList);
              int idPersonFound = personFound.getIdPerson();
              relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPersonFound, LEGAL_FATHER);
            }
          } else {
            // If PK is not selected as the person on the C/P section
            // Set the person with the highest ID_PERSON as the person on the section
            Person personFound = personDAO.findMostRecentPersonByIdPerson(putativeFatherList);
            int idPersonFound = personFound.getIdPerson();
            relationshipDAO.saveRelationship(idRelatePersonPutativeFather, idRemovalChild, idPersonFound,
                                             PUTATIVE_FATHER);
          }
        }
        
        if (idRelatePersonLegalFather == 0 && legalFatherList.size() > 0) {
          if (idPrimaryCaretaker > 0 && legalFatherList.contains(idPrimaryCaretaker)) {
            // Check if the Primary Caretaker has selected in the C/P section
            // If the PK is selected, set PK as the person on the C/P section

            if (MALE.equals(cdPKGender)) {
              relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPrimaryCaretaker,
                                               LEGAL_FATHER);
            } else {
              // If PK does not have the correct Gender for the dropdown on the C/P section
              // Set the person with the highest ID_PERSON as the person on the section
              Person personFound = personDAO.findMostRecentPersonByIdPerson(legalFatherList);
              int idPersonFound = personFound.getIdPerson();
              relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPersonFound, LEGAL_FATHER);
            }
          } else {
            // If PK is not selected as the person on the C/P section
            // Set the person with the highest ID_PERSON as the person on the section
            Person personFound = personDAO.findMostRecentPersonByIdPerson(legalFatherList);
            int idPersonFound = personFound.getIdPerson();
            relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPersonFound, LEGAL_FATHER);
          }
        }
        
        if (idRelatePersonBioFather == 0 && bioFatherList.size() > 0) {
          if (idPrimaryCaretaker > 0 && bioFatherList.contains(idPrimaryCaretaker)) {
            // Check if the Primary Caretaker has selected in the C/P section
            // If the PK is selected, set PK as the person on the C/P section

            if (MALE.equals(cdPKGender)) {
              relationshipDAO.saveRelationship(idRelatePersonBioFather, idRemovalChild, idPrimaryCaretaker,
                                               BIOLOGICAL_FATHER);
            } else {
              // If PK does not have the correct Gender for the dropdown on the C/P section
              // Set the person with the highest ID_PERSON as the person on the section
              Person personFound = personDAO.findMostRecentPersonByIdPerson(legalFatherList);
              int idPersonFound = personFound.getIdPerson();
              relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPersonFound, LEGAL_FATHER);
            }
          } else {
            // If PK is not selected as the person on the C/P section
            // Set the person with the highest ID_PERSON as the person on the section
            Person personFound = personDAO.findMostRecentPersonByIdPerson(bioFatherList);
            int idPersonFound = personFound.getIdPerson();
            relationshipDAO.saveRelationship(idRelatePersonBioFather, idRemovalChild, idPersonFound, BIOLOGICAL_FATHER);
          }
        }
        
        if (idRelatePersonLegalMother == 0 && legalMotherList.size() > 0) {
          if (idPrimaryCaretaker > 0 && legalMotherList.contains(idPrimaryCaretaker)) {
            // Check if the Primary Caretaker has selected in the C/P section
            // If the PK is selected, set PK as the person on the C/P section

            if (FEMALE.equals(cdPKGender)) {
              relationshipDAO.saveRelationship(idRelatePersonLegalMother, idRemovalChild, idPrimaryCaretaker,
                                               LEGAL_MOTHER);
            } else {
              // If PK does not have the correct Gender for the dropdown on the C/P section
              // Set the person with the highest ID_PERSON as the person on the section
              Person personFound = personDAO.findMostRecentPersonByIdPerson(legalFatherList);
              int idPersonFound = personFound.getIdPerson();
              relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPersonFound, LEGAL_FATHER);
            }
          } else {
            // If PK is not selected as the person on the C/P section
            // Set the person with the highest ID_PERSON as the person on the section
            Person personFound = personDAO.findMostRecentPersonByIdPerson(legalMotherList);
            int idPersonFound = personFound.getIdPerson();
            relationshipDAO.saveRelationship(idRelatePersonLegalMother, idRemovalChild, idPersonFound, LEGAL_MOTHER);
          }
        }
        
        if (idRelatePersonBioMother == 0 && bioMotherList.size() > 0) {
          if (idPrimaryCaretaker > 0 && bioMotherList.contains(idPrimaryCaretaker)) {
            // Check if the Primary Caretaker has selected in the C/P section
            // If the PK is selected, set PK as the person on the C/P section
            
            if (FEMALE.equals(cdPKGender)) {
              relationshipDAO.saveRelationship(idRelatePersonBioMother, idRemovalChild, idPrimaryCaretaker,
                                               BIOLOGICAL_MOTHER);
            } else {
              // If PK does not have the correct Gender for the dropdown on the C/P section
              // Set the person with the highest ID_PERSON as the person on the section
              Person personFound = personDAO.findMostRecentPersonByIdPerson(legalFatherList);
              int idPersonFound = personFound.getIdPerson();
              relationshipDAO.saveRelationship(idRelatePersonLegalFather, idRemovalChild, idPersonFound, LEGAL_FATHER);
            }
          } else {
            // If PK is not selected as the person on the C/P section
            // Set the person with the highest ID_PERSON as the person on the section
            Person personFound = personDAO.findMostRecentPersonByIdPerson(bioMotherList);
            int idPersonFound = personFound.getIdPerson();
            relationshipDAO.saveRelationship(idRelatePersonBioMother, idRemovalChild, idPersonFound, BIOLOGICAL_MOTHER);
          }
        }
      } 
      
      // End STGAP00017013: MR-095
      
      ccmn03uo = closeOpenStage.closeOpenStage(ccmn03ui);
      csub15so.setUlIdSUBStage(ccmn03uo.getUlIdStage());
    }

    if ((!(WINDOW_MODE_MODIFY.equals(csub15si.getSzSysCdWinMode())) || (STATUS_NEW
                                                                                  .equals(csub15si.getSzCdEventStatus())))
        && (!isFSUOpen)) {
      CCMN03UI ccmn03ui = new CCMN03UI();
      ccmn03ui.setArchInputStruct(csub15si.getArchInputStruct());
      ccmn03ui.getArchInputStruct().setCReqFuncCd(csub15si.getArchInputStruct().getCReqFuncCd());
      ccmn03ui.setSzCdStage(SUBCARE_STAGE);
      ccmn03ui.setSzCdStageOpen(FAMILY_SUB_STAGE);
      ccmn03ui.setSzCdStageReasonClosed(SUBCARE_STAGE);
      ccmn03ui.setSzCdStageProgram(STAGE_PROGRAM);
      ccmn03ui.setUlIdStage(csub15si.getROWCCMN01UIG00().getUlIdStage());
      ccmn03ui.setUlIdPerson(csub15si.getROWCCMN01UIG00().getUlIdPerson());
      ccmn03ui.setDtDtStageStart(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
      ccmn03ui.setUlScrIdPrimChild(csub15si.getROWCSUB15SIG00().getUlIdVictim());
      ccmn03ui.setSzNmPersonFull(csub15si.getSzNmPersonFull());
      ccmn03ui.setCSysIndSStgOpenOnly(YES);
      // STGAP00017013: MR-095
      ROWCCMN03UIG00_ARRAY rowccmn03uigoo_array = createROWCCMN03UIG00_ARRAY(csub80si);
      ccmn03ui.setROWCCMN03UIG00_ARRAY(rowccmn03uigoo_array);  
      // End STGAP00017013: MR-095
      
      closeOpenStage.closeOpenStage(ccmn03ui);
    }

    // ** Begin creating alerts

    // get date of birth from person table

    birthDate = personDAO.findDateOfBirthByIdPerson(csub15si.getROWCSUB15SIG00().getUlIdVictim());
    // get age based on birthdate
    int age = DateHelper.getAge(birthDate);

    // alert 90 days before child's 18th birthday and 14th birthday
    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      Person id_person = retrieveUnitSupervisorByCaseManagerId(IdPerson);
      Person caseManager = personDAO.findPersonByIdPerson(IdPerson);
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, UlIdCase);
      String cdTask = "";
      Date dateCreated = new Date();
      List<Person> employees = new ArrayList<Person>();
      employees.add(id_person);
      employees.add(caseManager);
      sendAlertToIlpCoordinator(capsCase, getPersistentObject(Stage.class, UlIdStage), securityAttr, birthDate, IdPerson, ccmn03uiNmPersonFull,UlIdStage );
      if (employees != null && !employees.isEmpty()) {
        Iterator<Person> itEmployee = employees.iterator();
        List<Todo> todoList = new ArrayList<Todo>();
        while (itEmployee.hasNext()) {
          Person employee = itEmployee.next();
          if (employee != null) {
            Todo todo1 = new Todo();
            if (age < 18) {
              Date birthday = DateHelper.addToDate(birthDate, 18, 0, 0);
              Date todoDueDate = DateHelper.addToDate(birthday, 0, 0, -90);
              todoDesc = ccmn03uiNmPersonFull + "  is approaching 18 years of age";
              todo1.setDtTodoDue(todoDueDate);

            } else if (age < 14) {

              Date birthday = DateHelper.addToDate(birthDate, 14, 0, 0);
              Date todoDueDate = DateHelper.addToDate(birthday, 0, 0, -90);
              todoDesc = ccmn03uiNmPersonFull + "  is approaching 14 years of age";
              todo1.setDtTodoDue(todoDueDate);

            }
            todo1.setPersonByIdTodoPersAssigned(employee);
            todo1.setTxtTodoDesc(todoDesc);
            todo1.setCdTodoTask(cdTask);
            todo1.setCdTodoType(CodesTables.CTODOTYP_A);
            todo1.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
            todo1.setDtTodoCreated(dateCreated);
            todo1.setCapsCase(capsCase);
            todo1.setStage(getPersistentObject(Stage.class, UlIdStage));
            todoList.add(todo1);
          }
        }
        complexTodoDAO.saveTodo(todoList);
      }
    }

    // alert 15 days after removal

    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      Todo todo = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, UlIdCase);
      Person id_person = retrieveUnitSupervisorByCaseManagerId(IdPerson);
      String cdTask = "";
      Date dateCreated = new Date();
      Date todoDueDate = DateHelper.addToDate(RemovalDate, 0, 0, 15);
      todo.setPersonByIdTodoPersAssigned(id_person);
      Date dtPlanningDue = DateHelper.addToDate(RemovalDate, 0, 0, 30);//mxpatel added this for defect #10881
      todoDesc = "Begin case planning - initial case plan due on " + dtPlanningDue;//mxpatel added this for defect #10881
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(todoDueDate);
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
      todo.setDtTodoCreated(dateCreated);
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, UlIdStage));
      todoDAO.saveTodo(todo);

    }

    // alert one year anniversaries of care until age 18
    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (lNbrRemovalAgeYr < 18)
        && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      Todo todo = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, UlIdCase);
      Person id_person = retrieveUnitSupervisorByCaseManagerId(IdPerson);
      String cdTask = "";
      Date dateCreated = new Date();
      Date todoDueDate = DateHelper.addToDate(RemovalDate, 1, 0, 0);
      todo.setPersonByIdTodoPersAssigned(id_person);
      todoDesc = "Child has reached anniversary of entering care.";
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(todoDueDate);
      // todo.setPersonByIdTodoPersCreator(getPersistentObject(Person.class, IdPerson));
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
      todo.setDtTodoCreated(dateCreated);
      // todo.setEvent(event);
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, UlIdStage));
      todoDAO.saveTodo(todo);
    }

    // alert for child eligible for ILP
    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      Todo todo = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, UlIdCase);
      Person id_person = retrieveUnitSupervisorByCaseManagerId(IdPerson);
      String cdTask = "";
      Date dateCreated = new Date();
      if (age < 14) {
        Date birthday = DateHelper.addToDate(birthDate, 14, 0, 0);
        Date todoDueDate = DateHelper.addToDate(birthday, 0, 0, 0);
        todo.setDtTodoDue(todoDueDate);

      } else {
        Date todoDueDate;
        todoDueDate = DateHelper.addToDate(RemovalDate, 1, 0, 0);
        todo.setDtTodoDue(todoDueDate);
      }
      todoDesc = ccmn03uiNmPersonFull + "  eligible for ILP";
      todo.setPersonByIdTodoPersAssigned(id_person);
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
      todo.setDtTodoCreated(dateCreated);
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, UlIdStage));
      todoDAO.saveTodo(todo);
    }

    // alert 11 days after removal for health screen

    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      Todo todo = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, UlIdCase);
      Person id_person = retrieveUnitSupervisorByCaseManagerId(IdPerson);
      String cdTask = "";
      Date dateCreated = new Date();
      Date todoDueDate = DateHelper.addToDate(RemovalDate, 0, 0, 11);
      todo.setPersonByIdTodoPersAssigned(id_person);
      todoDesc = "Health Screen for " + ccmn03uiNmPersonFull + " did not take place";
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(todoDueDate);
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
      todo.setDtTodoCreated(dateCreated);
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, UlIdStage));
      todoDAO.saveTodo(todo);

    }

    // alert on day of care
    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      int idChild = csub15si.getROWCSUB15SIG00().getUlIdVictim();
      String desc = null;
      boolean isRegional = false;
      // this method finds the person detail, not just service auth
      PersonDtl personDtl = personDtlDAO.findServiceAuthByIdPerson(idChild);
      String cdChildCitizenship = personDtl != null ? personDtl.getCdPersonCitizenship() : null;

      if (StringHelper.isValid(cdChildCitizenship) && !CodesTables.CCTZNSTA_AMR.equals(cdChildCitizenship)) {
        // undetermined status
        if (CodesTables.CCTZNSTA_TMR.equals(cdChildCitizenship)) {
          desc = " - Undocumented immigrant child has entered care.";
        }
        // documented alien
        else if (CodesTables.CCTZNSTA_PTR.equals(cdChildCitizenship)
                 || CodesTables.CCTZNSTA_VIS.equals(cdChildCitizenship)) {
          desc = " - Immigrant child has entered care.";
        }
        // currently there are only 4 codes for citizenship; should this list be changed (from Person design) then this 
        // should be updated accordingly - immediate result would be alert sent with child's name plus the word 'null' probably

        // Retrieve stage office management personnel
        SpecializedUnitPersonalBean spUnitPsnlBean = new SpecializedUnitPersonalBean();
        spUnitPsnlBean.setIdStage(UlIdStage);
        spUnitPsnlBean.setCdCounty("");
        spUnitPsnlBean.setSecurityAttribute(csub15si.getSzCdAttrStateOfficeMgmt());
        spUnitPsnlBean.setSpecialization(CodesTables.CSPCUNTS_PPD);
        spUnitPsnlBean.setRAC(isRegional);
        List<Integer> somList = retrieveSpecializedUnitPersonnel
                                                                .retrieveSpecializedUnitPersonnel(spUnitPsnlBean);
        if (somList != null && !somList.isEmpty()) {
          List<Todo> todoList = createAlertChildEnterCare(ccmn03uiNmPersonFull, desc, RemovalDate, UlIdCase, UlIdStage,
                                                          IdPerson, somList);
          complexTodoDAO.saveTodo(todoList);
        }
      }
    }
    // alert one year from removal
    if ((SzCdStageOpen.equals(SUBCARE_STAGE)) && (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd))) {
      Todo todo = new Todo();
      CapsCase capsCase;
      capsCase = getPersistentObject(CapsCase.class, UlIdCase);
      Person id_person = retrieveUnitSupervisorByCaseManagerId(IdPerson);
      String cdTask = "";
      Date dateCreated = new Date();
      Date todoDueDate = DateHelper.addToDate(RemovalDate, 0, 15, 0);
      todo.setPersonByIdTodoPersAssigned(id_person);
      todoDesc = ccmn03uiNmPersonFull + " is approaching 15 months in care";
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoDue(todoDueDate);
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
      todo.setDtTodoCreated(dateCreated);
      todo.setCapsCase(capsCase);
      todo.setStage(getPersistentObject(Stage.class, UlIdStage));
      todoDAO.saveTodo(todo);
    }

    // End alerts

    int idCase_csub15s = csub15si.getROWCSUB15SIG00().getUlIdCase();
    // ccmne1d
    List<Stage> stageList = stageDAO.findStageByIdCase(idCase_csub15s);
    if (stageList == null || stageList.isEmpty()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    // for any open FSU stages
    Iterator<Stage> stage_it = stageList.iterator();
    while (stage_it.hasNext()) {
      Stage stage = stage_it.next();

      if (FAMILY_SUB_STAGE.equals(stage.getCdStage()) && stage.getDtStageClose() == null) {
        // check the stage start date vs. the conservatorship removal date
        // if removal date is prior to start date
        Date dtRemovalDate = DateHelper.toJavaDate(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
        if (DateHelper.isBefore(dtRemovalDate, stage.getDtStageStart())) {
          int idStage = stage.getIdStage();
          // Call cinvc4d - to update stage start date
          nbrRowsUpdated = stageDAO.updateStage(dtRemovalDate, idStage);
          if (nbrRowsUpdated == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        }
      }
    }

    if (WINDOW_MODE_MODIFY.equals(csub15si.getSzSysCdWinMode())) {
      Date dtRemovalDate = DateHelper.toJavaDate(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
      if (DateHelper.isBefore(dtRemovalDate, dtDbDtRemoval)) {
        // use the person id and INV stage id to get the SUB stage id.
        int idPriorStage = csub15si.getROWCCMN01UIG00().getUlIdStage();
        int idPerson = csub15si.getROWCSUB15SIG00().getUlIdVictim();
        String cdStage = SUBCARE_STAGE;
        String cdStagePersRole = PRIMARY_CHILD;
        // csub84d
        int idStage = stageDAO.findStageByStageByIdPriorStage(cdStage, idPriorStage, idPerson, cdStagePersRole);

        if (idStage == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        Date dtStageStart = DateHelper.toJavaDate(csub15si.getROWCSUB15SIG00().getDtDtRemoval());
        // cinvc4d
        nbrRowsUpdated = stageDAO.updateStage(dtStageStart, idStage);
        if (nbrRowsUpdated == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      }
    }
    return csub15so;
  }

  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {
    // CallCCMN60D
    // -- FIXME: this retrieve finds the unit supervisor's id, but this is not necessarily the assigned approver
    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    boolean throwError = false;
    if (resultMap != null && resultMap.size() > 0) {
      idSupervisor = (Integer) resultMap.get("idPerson");
      if (idSupervisor == null) {
        throwError = true;
      }
    } else {
      throwError = true;
    }

    if (throwError) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return getPersistentObject(Person.class, idSupervisor);
  }

  private List<Todo> createAlertChildEnterCare(String nmChildNmFull, String todoPartDesc, Date removalDate, int idCase,
                                               int idStage, int idUser, List<Integer> unitList) {
    List<Todo> todoList;
    if (unitList != null && unitList.size() != 0) {
      todoList = new ArrayList<Todo>();
      for (Iterator unitListItr = unitList.iterator(); unitListItr.hasNext();) {
        Todo todo = new Todo();
        CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
        int idPerson = ((Integer) unitListItr.next());
        String cdTask = "";
        Date dateCreated = new Date();
        Date todoDueDate = new Date();
        String todoDesc = nmChildNmFull + todoPartDesc;
        todo.setTxtTodoDesc(todoDesc);
        todo.setCdTodoTask(cdTask);
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setDtTodoDue(todoDueDate);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
        todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
        todo.setDtTodoCreated(dateCreated);
        todo.setCapsCase(capsCase);
        todo.setStage(getPersistentObject(Stage.class, idStage));
        todoList.add(todo);
      }
      return todoList;
    }
    return null;
  }
  
  private void sendAlertToIlpCoordinator(CapsCase capsCase, Stage stage, String securityAttr, Date birthDate,
                                         int IdPerson, String ccmn03uiNmPersonFull, int UlIdStage) {
    boolean isUniqueResult = true;
    Date dateCreated = new Date();
    String todoDesc = "";
    int age = DateHelper.getAge(birthDate);
    SpecializedUnitPersonalBean spUnitPsnlBean = new SpecializedUnitPersonalBean();
    spUnitPsnlBean.setIdStage(stage.getIdStage());
    spUnitPsnlBean.setCdCounty("");
    spUnitPsnlBean.setSecurityAttribute(securityAttr);
    spUnitPsnlBean.setSpecialization(CodesTables.CSPCUNTS_ILP);
    spUnitPsnlBean.setRAC(isUniqueResult);
    // retrieve id persons of state Independent Living unit personnel
    List<Integer> sauList1 = retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);
    int idPerson = 0;
    String cdTask = "";
    if (sauList1 != null && sauList1.size() > 0) {
      Iterator<Integer> itEmployee = sauList1.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itEmployee.hasNext()) {
        Integer idAssgnd = (Integer) itEmployee.next();
        ;
        Todo todo1 = new Todo();
        if (age < 18) {
          Date birthday = DateHelper.addToDate(birthDate, 18, 0, 0);
          Date todoDueDate = DateHelper.addToDate(birthday, 0, 0, -90);
          todoDesc = ccmn03uiNmPersonFull + "  is approaching 18 years of age";
          todo1.setDtTodoDue(todoDueDate);

        } else if (age < 14) {

          Date birthday = DateHelper.addToDate(birthDate, 14, 0, 0);
          Date todoDueDate = DateHelper.addToDate(birthday, 0, 0, -90);
          todoDesc = ccmn03uiNmPersonFull + "  is approaching 14 years of age";
          todo1.setDtTodoDue(todoDueDate);

        }
        todo1.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssgnd));
        todo1.setTxtTodoDesc(todoDesc);
        todo1.setCdTodoTask(cdTask);
        todo1.setCdTodoType(CodesTables.CTODOTYP_A);
        todo1.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, IdPerson));
        todo1.setDtTodoCreated(dateCreated);
        todo1.setCapsCase(capsCase);
        todo1.setStage(getPersistentObject(Stage.class, UlIdStage));
        todoList.add(todo1);
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  public void setPersonDtlDAO(PersonDtlDAO personDtlDAO) {
    this.personDtlDAO = personDtlDAO;
  }

  public void setRetrieveSpecializedUnitPersonnel(RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel) {
    this.retrieveSpecializedUnitPersonnel = retrieveSpecializedUnitPersonnel;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  // STGAP00017013: MR-095
  /**
   * Setup the ROWCCMN03UIG00_ARRAY object for the CSUB80SI input object
   * 
   * @param csub80si: the output from the CSUB80SI service
   * @return the newly constructed array object
   */
  private ROWCCMN03UIG00_ARRAY createROWCCMN03UIG00_ARRAY(CSUB80SI csub80si) {
    // Allocate the new array
    ROWCCMN03UIG00_ARRAY rowccmn03uigoo_array = new ROWCCMN03UIG00_ARRAY();

    // Get the ROWCCMN03UIG00_ARRAY returned from CINV80SO
    ROWCSUB80SIG00_ARRAY rowcsub80sig00_array = csub80si.getROWCSUB80SIG00_ARRAY();
    int rowCount = 0;

    if (rowcsub80sig00_array != null) {
      Enumeration rowcsub80sig00Enumeration = rowcsub80sig00_array.enumerateROWCSUB80SIG00();
      while (rowcsub80sig00Enumeration.hasMoreElements()) {
        ROWCSUB80SIG00 rowcsub80sig00;
        rowcsub80sig00 = (ROWCSUB80SIG00) rowcsub80sig00Enumeration.nextElement();
        
        rowCount++;
        ROWCCMN03UIG00 rowccmn03uigoo = new ROWCCMN03UIG00();
        rowccmn03uigoo.setUlIdPersonPrincipal(rowcsub80sig00.getUlIdPersonPrincipal());
        rowccmn03uigoo.setSzNmPersonFull(rowcsub80sig00.getSzNmPersonFull());
        rowccmn03uigoo.setSzCdStagePersRelInt(rowcsub80sig00.getSzCdStagePersRelInt());
        rowccmn03uigoo_array.addROWCCMN03UIG00(rowccmn03uigoo);
      }
    }

    // set the size of the array to the row count
    rowccmn03uigoo_array.setUlRowQty(rowCount);

    // return the new array object
    return rowccmn03uigoo_array;
  }
  
  // STGAP00017013: MR-095
  private int findIdPrimaryCaretaker(int idRemovalStage) {
    // Find the count of PK in the removal stage
    int idPrimaryCaretaker = 0;
    long cntPrimaryCaretaker = stagePersonLinkDAO
                                                 .countStagePersonLinkByIdStageCdStagePersRelInt(
                                                                                                 idRemovalStage,
                                                                                                 CodesTables.CRELVICT_PK);
    boolean noPrimaryCaretaker = cntPrimaryCaretaker < 1 ? true : false;
    boolean multiPrimaryCaretaker = cntPrimaryCaretaker > 1 ? true : false;

    // If no PK found, set the person with the stage name as PK
    if (noPrimaryCaretaker) {
      String stageName = stageDAO.findNmStageByIdStage(idRemovalStage);

      Person personWithStageName = stagePersonLinkDAO.findPersonByIdStageByNmPersonFull(idRemovalStage, stageName);
      if (personWithStageName != null) {
        idPrimaryCaretaker = personWithStageName.getIdPerson();
      }
    }

    // If multiple PK found, set the person with the stage name as the PK
    // and set the relationship of the additional PK(s) as 'Other' (by sending to the relationship mapping)
    // If single PK cannot be determined, set cdStagePersRelPKForPrincipals as Non-Related
    // and send all persons in the removal stage to the C/P section check then the relationship mapping
    if (multiPrimaryCaretaker) {
      String stageName = stageDAO.findNmStageByIdStage(idRemovalStage);

      Person personWithStageName = stagePersonLinkDAO.findPersonByIdStageByNmPersonFull(idRemovalStage, stageName);
      if (personWithStageName != null) {
        idPrimaryCaretaker = personWithStageName.getIdPerson();
      }
    }
    // Set PK in the returning map if single PK exists
    if (!noPrimaryCaretaker && !multiPrimaryCaretaker) {
      // Set the Relationship that is used for mapping through STAGE_PERS_REL_MAP_CUSTODY table
      // The Relationship is based on the relationship of the removal child to the Primary Caretaker
      Person personPK = stagePersonLinkDAO.findStagePersonLinkByIdStageByCdStagePersRelInt(idRemovalStage,
                                                                                           CodesTables.CRELVICT_PK);
      if (personPK != null) {
        idPrimaryCaretaker = personPK.getIdPerson();
      }
    }
    return idPrimaryCaretaker;
  }
}
