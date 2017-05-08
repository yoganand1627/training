package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdptSubEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.MedicaidUpdateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveAdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD40SO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *  04/14/2009    bgehlot               STGAP00013779: MR-50 changes        
 *  06/04/2009    bgehlot               STGAP00013932: Amount also taken into consideration  when displaying the
 *                                      Informational message 'Non Recurring <type> Adoption Assistance Agreement for <amount> currently exists.
 *  06/11/2009    bgehlot               STGAP00014186: Error message 'Special Service Agreement exists for the attached 
 *                                      Application' will display on the Save and Complete buttons when the user attempts 
 *                                      to add a subsequent Agreement to an Application that already has a COMP Agreement. 
 *  06/18/2009    bgehlot               STGAP00014354: No validation in COMP status    
 *  07/04/2009    bgehlot               STGAP00014563: Save the basic rate type and county add on amount in the ADOPTION_SUBSIDY table      
 *  09/17/2009    mxpatel               STGAP00014359: added code to make sure values were set in rowccmn01uig01_array in order to be able to 
 *                                      update event_person_link table in postEvent.     
 *  09/30/2009    bgehlot               STGAP00012573: Adoption Assistance Agreement has been completed for child 
 *                                      Assign the alert to Regional Subsidy SAU (Adoptions Subsidy Staff) 
 *  01/08/2010    mxpatel               STGAP00015702: Added code to verify that the approved amount for Non Recurring services on the Adoption Assistance 
 *                                      Application is strictly adhered to by looking to previously approved and paid Assistance Agreements 
 *                                      and Service Authorization before allowing the Case Manager to Save/Mark Complete a new Agreement
 *  01/19/2010    mxpatel               SMS #43772: Added code to check for existing service auths  with same type and same amount as the current Agreement.               
 *  02/10/2010    mxpatel               SMS #44084: Modified the code so that we can find all svc_auth_dtl events regardless of the event status    
 *  02/18/2010    mxpatel               SMS #45630: Modified the code to consider amount as well when checking for svc_auth_dtl 
 *  03/02/2010    mxpatel               SMS #45293: modified the code so that all service auths will copied from ADO to PAD (including end dated and terminated).  Also
 *                                      added code to make sure approved amount for Non Recurring services on the Adoption Assistance 
 *                                      Application is strictly adhered to by looking to previously approved and paid Assistance Agreements
 *  02/18/2011    hnguyen               SMS#97432: Updated saveAlert21 alert message to state "Complete Termination requirements for Adoption Assistance for <child's name>."                                                                 
 * </pre>
 * 
 */

public class SaveAdoptionSubsidyImpl extends BaseServiceImpl implements SaveAdoptionSubsidy {

  public static final int SEC_ADOPT_ASSIST_SPEC = 59;

  private CheckStageEventStatus checkStageEventStatus = null;
  private PostEvent postEvent = null;
  private TodoCommonFunction todoCommonFunction = null;
  private TodoDAO todoDAO = null;
  private AdptSubEventLinkDAO adptSubEventLinkDAO = null;
  private MedicaidUpdateDAO medicaidUpdateDAO = null;
  private PersonDAO personDAO = null;
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;
  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private ComplexTodoDAO complexTodoDAO = null;
  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;
  private EventDAO eventDAO = null;
  private SvcAuthDetailDAO svcAuthDetailDAO = null;
  private StageDAO stageDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  public void setAdptSubEventLinkDAO(AdptSubEventLinkDAO adptSubEventLinkDAO) {
    this.adptSubEventLinkDAO = adptSubEventLinkDAO;
  }

  public void setMedicaidUpdateDAO(MedicaidUpdateDAO medicaidUpdateDAO) {
    this.medicaidUpdateDAO = medicaidUpdateDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public CFAD40SO saveAdoptionSubsidy(CFAD40SI cfad40si) throws ServiceException {

    CFAD40SO cfad40so = new CFAD40SO();
    int ulPostEventIdEvent = 0;
    String priorEventStatus = StringHelper.EMPTY_STRING;
    
    Event eventInfo = eventDAO.findEventByIdEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
    if(eventInfo != null){
      priorEventStatus = eventInfo.getCdEventStatus();
    }
    
    String actionCode = null;
    
    if (!NULL_STRING1.equals(cfad40si.getROWCCMN01UIG00().getSzCdTask())) {
      // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(cfad40si.getArchInputStruct());
      ccmn06ui.setUlIdStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
      ccmn06ui.setSzCdTask(cfad40si.getROWCCMN01UIG00().getSzCdTask());
      if (cfad40si.getROWCCMN01UIG00().getUlIdEvent() == 0
                      && ArchitectureConstants.N.equals(cfad40si.getBSysIndUserTodo())) {
        ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        actionCode =  ServiceConstants.REQ_FUNC_CD_ADD;
      } else {
        ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }
      //    one rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      checkStageEventStatus.status(ccmn06ui);
    }
    
    //STGAP00014359 - added this code to make sure CReqFuncCd was set
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(actionCode);
    ccmn01ui.setArchInputStruct(archInputStruct);

    if (cfad40si.getROWCCMN01UIG00().getUlIdEvent() == 0) {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    
    //STGAP00014359 - added code to make sure values were set to rowccmn01uig01_array
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    int idPerson = cfad40si.getUlIdPerson();
    if (idPerson != 0) {
    rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
    rowccmn01uig01.setUlIdPerson(idPerson);
    rowccmn01uig01.setSzCdScrDataAction(actionCode);
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    //STGAP00014359 - make sure that rowccmn01uig01_array is null of we are updating (not adding a new event)
    if (cfad40si.getROWCCMN01UIG00().getUlIdEvent() != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    
    rowccmn01uig00.setSzCdTask(cfad40si.getROWCCMN01UIG00().getSzCdTask());
    rowccmn01uig00.setTsLastUpdate(cfad40si.getROWCCMN01UIG00().getTsLastUpdate());
    rowccmn01uig00.setSzCdEventStatus(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus());
    rowccmn01uig00.setSzCdEventType(cfad40si.getROWCCMN01UIG00().getSzCdEventType());
    rowccmn01uig00.setDtDtEventOccurred(cfad40si.getROWCCMN01UIG00().getDtDtEventOccurred());
    rowccmn01uig00.setUlIdEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
    rowccmn01uig00.setUlIdStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
    rowccmn01uig00.setUlIdPerson(cfad40si.getROWCCMN01UIG00().getUlIdPerson());
    rowccmn01uig00.setSzTxtEventDescr(cfad40si.getROWCCMN01UIG00().getSzTxtEventDescr());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    //  two rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
    //PostEvent;
    //this throws an exception that will halt processing with a message if it fails; success is no output.
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

    //  Populate ulPostEventIdEvent with IdEvent.  This is done because it
    // is needed in CAUD97DI.  ulPostEventIdEvent is a local varaible created
    // created to hold this value.  It is referenced here, in the CAUD97D
    // CSUB40, and CAUD99 input structure.
    ulPostEventIdEvent = ccmn01uo.getUlIdEvent();

    ArrayList<Boolean> bToDoFlag = new ArrayList<Boolean>();
    bToDoFlag.add(FAD037, false);
    bToDoFlag.add(FAD038, false);
    bToDoFlag.add(FAD040, false);
    bToDoFlag.add(FAD041, false);
    bToDoFlag.add(FAD042, false);

    if ((ArchitectureConstants.N.equals(cfad40si.getCSysIndAppSent())
                    && (!EVENT_STATUS_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus())))) {
      if ((DateHelper.isNull(cfad40si.getCFAD40SIG00().getDtDtAdptSubAppSent())
                      && (!EVENT_STATUS_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus())))) {
        bToDoFlag.set(FAD037, true);
      }
    }
    if ((ArchitectureConstants.N.equals(cfad40si.getCSysIndAgreeSent())
                    && (!EVENT_STATUS_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus())))) {
      if (!DateHelper.isNull(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent())
                      && DateHelper.isNull(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn())) {
        bToDoFlag.set(FAD040, true);
      }
    }
    if ((ArchitectureConstants.N.equals(cfad40si.getCSysIndAgreeRtn())
                    && (!EVENT_STATUS_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus())))) {
      if (!DateHelper.isNull(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn())) {
        bToDoFlag.set(FAD041, true);
      }
    }
    if (ArchitectureConstants.N.equals(cfad40si.getCSysIndSubEnd())) {
      if (!DateHelper.isNull(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd())) {
        if (!EVENT_STATUS_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus())) {
          bToDoFlag.set(FAD042, true);
        }
        bToDoFlag.set(FAD038, true);
      }
    }
    int numAdptSubEventLinkRows = 0;
    if (((cfad40si.getROWCCMN01UIG00().getUlIdEvent() != 0)
                    && ((STATUS_COMPLETE.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus()))
                                    || (EVENT_STATUS_PROC.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus()))))
                                    || (cfad40si.getROWCCMN01UIG00().getUlIdEvent() == 0)) {
      //    three rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);

      if(STATUS_COMPLETE.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus()) || 
                      (EVENT_STATUS_PROC.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus()))) {
        todoDAO.updateTodoByIdEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
      }

      int idResource = cfad40si.getCFAD40SIG00().getUlIdAdptSubPayee();
      AdoptionSubsidy adoptionSubsidy = new AdoptionSubsidy();
      Placement placement = getPersistentObject(Placement.class, cfad40si.getUlIdPlcmtEvent());
      Person person = getPersistentObject(Person.class, cfad40si.getUlIdPerson()); 
      CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);

      adoptionSubsidy.setIdAdptSub(cfad40si.getCFAD40SIG00().getUlIdAdptSub());
      adoptionSubsidy.setDtAdptSubAgreeRetn(DateHelper.toJavaDate(
                                                                  cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn()));
      adoptionSubsidy.setDtAdptSubAgreeSent(DateHelper.toJavaDate(
                                                                  cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent()));
      adoptionSubsidy.setDtAdptSubAppReturned(DateHelper.toJavaDate(
                                                                    cfad40si.getCFAD40SIG00().getDtDtAdptSubAppReturned()));
      adoptionSubsidy.setDtAdptSubAppSent(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubAppSent()));
      adoptionSubsidy.setDtAdptSubApprvd(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubApprvd()));
      adoptionSubsidy.setDtAdptSubEffective(DateHelper.toJavaDate(
                                                                  cfad40si.getCFAD40SIG00().getDtDtAdptSubEffective()));
      adoptionSubsidy.setDtAdptSubEnd(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd()));
      adoptionSubsidy.setAmtAdptSub(cfad40si.getCFAD40SIG00().getSAmtAdptSub());
      adoptionSubsidy.setTxtAdptSubRsn(cfad40si.getCFAD40SIG00().getSzTxtAdptSubRsn());
      adoptionSubsidy.setCdAdptSubCloseRsn(cfad40si.getCFAD40SIG00().getSzCdAdptSubCloseRsn());
      adoptionSubsidy.setIndAdptSubThirdParty(cfad40si.getCFAD40SIG00().getCIndAdptSubThirdParty());


      adoptionSubsidy.setDtRenwlEffBegin(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtRenwlEffBegin()));
      adoptionSubsidy.setDtRenwlEffEnd(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtRenwlEffEnd()));
      adoptionSubsidy.setAmtSpclAsstReq(cfad40si.getCFAD40SIG00().getSAmtSpclAsstReq());
      adoptionSubsidy.setTxtSpclAsstCmnts(cfad40si.getCFAD40SIG00().getSzTxtSpclAsstCmnts());
      adoptionSubsidy.setTxtSpclAsstSpecify(cfad40si.getCFAD40SIG00().getSzTxtSpclAsstSpecify());

      //STGAP00011586 -- need to check to see if a contract exists
      //STGAP00013779: Corrected and added service code as per the design document
      String spclAsstType = cfad40si.getCFAD40SIG00().getSzCdAdptSubDeterm();
      String decodeType = "";
      if (CodesTables.CSUBTYPE_18.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51217;
      } else if (CodesTables.CSUBTYPE_10.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51260;
      } else if (CodesTables.CSUBTYPE_30.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51258B; //STGAP00013779: changed it to 51258B as per Design Document
      } else if (CodesTables.CSUBTYPE_28.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51258C; //STGAP00013779: changed it to 51258C
      }  else if (CodesTables.CSUBTYPE_29.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51258A; //STGAP00013779: changed it to 51258A
      }  else if (CodesTables.CSUBTYPE_21.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51258D;
      } else if (CodesTables.CSUBTYPE_22.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51033A;
      } else if (CodesTables.CSUBTYPE_25.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51033B;
      } else if (CodesTables.CSUBTYPE_23.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51033C;
      }else if (CodesTables.CSUBTYPE_24.equals(spclAsstType)) {
        decodeType = CodesTables.CADOSVCD_51033C;
      }

      adoptionSubsidy.setCdSpclAsstType(spclAsstType);
      adoptionSubsidy.setIndSauConf(cfad40si.getCFAD40SIG00().getCIndSauConf());
      
      //STGAP00013779: For batch use saving Y to the IndSpclAsstApprvl when Special Service is completed
      if(EVENT_STATUS_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus()) && 
        (CodesTables.CSUBTYPE_18.equals(spclAsstType) || CodesTables.CSUBTYPE_10.equals(spclAsstType) ||
         CodesTables.CSUBTYPE_21.equals(spclAsstType) || CodesTables.CSUBTYPE_28.equals(spclAsstType) || 
         CodesTables.CSUBTYPE_29.equals(spclAsstType) || CodesTables.CSUBTYPE_30.equals(spclAsstType))){
        adoptionSubsidy.setIndSpclAsstApprvl(ArchitectureConstants.Y);
      }
      if (cfad40si.getROWCCMN01UIG00().getUlIdEvent() == 0
                      || ArchitectureConstants.Y.equals(cfad40si.getBSysIndUserTodo())) {
        adoptionSubsidy.setIndAdptSubProcess(ArchitectureConstants.N);
      } else {
        adoptionSubsidy.setIndAdptSubProcess(cfad40si.getCFAD40SIG00().getCIndAdptSubProcess());
      }

      adoptionSubsidy.setCapsResource(capsResource);
      adoptionSubsidy.setDtLastUpdate(cfad40si.getCFAD40SIG00().getTsLastUpdate());
      adoptionSubsidy.setPlacement(placement);
      adoptionSubsidy.setDtAdptSubLastInvc(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubLastInvc()));
      adoptionSubsidy.setPerson(person);

      adoptionSubsidy.setDtAdptSubTerminated(DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubTerm()));
      adoptionSubsidy.setIndSchoolVer(cfad40si.getCFAD40SIG00().getCIndSchoolVerified());

      //STGAP00011586 -- if the payment method is 'direct to provider' and no
      // service authorization is found, then throw an exception
      String txtSzCdPaymentMethod = cfad40si.getCFAD40SIG00().getSzCdPlaymentMthd();

      double amountAdoSub = cfad40si.getCFAD40SIG00().getSAmtAdptSub();
      int serviceAuthId = serviceAuthorizationDAO.findServiceAuthByIdPrimaryClient(cfad40si.getUlIdPerson(), decodeType, amountAdoSub);
      if (CodesTables.CPAYMTHD_DIR.equals(txtSzCdPaymentMethod) && serviceAuthId == 0) {
        if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
          throw new ServiceException(Messages.MSG_SVC_AUTH_REQ);
        }
      }

      adoptionSubsidy.setCdPaymentMthd(txtSzCdPaymentMethod);
      adoptionSubsidy.setCdAdptSubDeterm(cfad40si.getCFAD40SIG00().getSzCdAdptSubDeterm());
      adoptionSubsidy.setIndNonIncSSA(cfad40si.getCFAD40SIG00().getSzCdAllNonIncidentSSA());

      int idSpecialNeedsEvent = cfad40si.getCFAD40SIG00().getUlIdSpecialNeedsEvent();
      if(idSpecialNeedsEvent > 0) {
        SpecialNeedsDetermination specialNeedsDetermination = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idSpecialNeedsEvent);
        if(specialNeedsDetermination != null) {
          adoptionSubsidy.setSpecialNeedsDetermination(specialNeedsDetermination);
        }
        //STGAP00014563: Save the basic rate type in the ADOPTION_SUBSIDY table 
        adoptionSubsidy.setCdBasicRateType(specialNeedsDetermination.getCdBasicRateType());
        //STGAP00014563: Save the county add on amount in the ADOPTION_SUBSIDY table 
        adoptionSubsidy.setNbrCountyAddonAmt(specialNeedsDetermination.getNbrCountyAddonAmt());
      }

      //      four rc = caud97dAUDdam(sqlca, pCAUD97DInputRec, pCAUD97DOutputRec);

      int adptSubPerson = cfad40si.getUlIdPerson();
      int idAdptSub = cfad40si.getCFAD40SIG00().getUlIdAdptSub();
      Date dtAdptSubEffective = DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubEffective());
      Date dtAdptSubEnd = DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
      Date tsLastUpdate = cfad40si.getCFAD40SIG00().getTsLastUpdate();
      String cdAdptAudDeterm = cfad40si.getCFAD40SIG00().getSzCdAdptSubDeterm();
      Date dtAdptSubTerm = DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubTerm());
      Date renewalDate = null;
      Date dtEndTerm = null; 
      if(cfad40si.getROWCCMN01UIG00().getUlIdEvent() != 0){
        Map adoptionsub = adptSubEventLinkDAO.findAdptSubEventLink(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
        renewalDate = (Date)adoptionsub.get("dtRenwlEffEnd");
      }
      if(dtAdptSubTerm != null){
        dtEndTerm = dtAdptSubTerm;
      }else{
        dtEndTerm = dtAdptSubEnd;
      }
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cfad40si.getArchInputStruct().getCReqFuncCd())) {
        checkForActiveExistingTypes(adptSubPerson, cfad40si.getROWCCMN01UIG00().getUlIdEvent(), cfad40si.getUlIdCase(), 
                                    cfad40so, dtAdptSubEffective, dtEndTerm, cdAdptAudDeterm, priorEventStatus, idSpecialNeedsEvent);
        adoptionSubsidyDAO.saveAdoptionSubsidy(adoptionSubsidy);
        idAdptSub = adoptionSubsidy.getIdAdptSub();
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cfad40si.getArchInputStruct().getCReqFuncCd())) {
        checkForActiveExistingTypes(adptSubPerson, cfad40si.getROWCCMN01UIG00().getUlIdEvent(), cfad40si.getUlIdCase(), 
                                    cfad40so, dtAdptSubEffective, dtEndTerm, cdAdptAudDeterm, priorEventStatus, idSpecialNeedsEvent);
        adoptionSubsidyDAO.saveAdoptionSubsidy(adoptionSubsidy);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cfad40si.getArchInputStruct().getCReqFuncCd())) {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      cfad40so.setUlIdAdptSub(idAdptSub);

      //create the alert on the first save only
      //STGAP00013779: Added the restrictions to exclude Special Services when creating alerts
      if(cfad40si.getROWCCMN01UIG00().getUlIdEvent() == 0 && 
                      !(CodesTables.CSUBTYPE_10.equals(cdAdptAudDeterm) ||
                                      CodesTables.CSUBTYPE_18.equals(cdAdptAudDeterm) ||
                                      CodesTables.CSUBTYPE_21.equals(cdAdptAudDeterm) ||
                                      CodesTables.CSUBTYPE_28.equals(cdAdptAudDeterm) ||
                                      CodesTables.CSUBTYPE_29.equals(cdAdptAudDeterm) ||
                                      CodesTables.CSUBTYPE_30.equals(cdAdptAudDeterm))) {
        saveAlert18(cfad40si, ulPostEventIdEvent);
        saveAlert21(cfad40si, ulPostEventIdEvent);
        saveAlert18DD(cfad40si, ulPostEventIdEvent);
      }

      //STGAP00013779: Agreement has been terminated. Payment Change value has been selected, and the page is "Saved".
      if(StringHelper.isNotEmptyOrNull(cfad40si.getCFAD40SIG00().getSzCdAdptSubCloseRsn())){
        saveAlertTerminate(cfad40si, ulPostEventIdEvent);
      }
      
      //STGAP00012573: Agreement has been completed. Agreement goes to COMP status.
      if(CodesTables.CEVTSTAT_COMP.equals(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus())
         && !CodesTables.CEVTSTAT_COMP.equals(priorEventStatus)){
        saveAlertCOMPStatus(cfad40si, ulPostEventIdEvent);
      }

      if (cfad40si.getROWCCMN01UIG00().getUlIdEvent() == 0
                      || ArchitectureConstants.Y.equals(cfad40si.getBSysIndUserTodo())) {
        //        five rc = caudb2dAUDdam(sqlca, pCAUDB2DInputRec, pCAUDB2DOutputRec);
        numAdptSubEventLinkRows = adptSubEventLinkDAO.insertAdptSubEventLink(ulPostEventIdEvent,
                                                                             idAdptSub);
      }

    }
    int numMedicaidUpdateRows = 0;
    if (numAdptSubEventLinkRows != 0
                    && cfad40si.getSzCdMedUpdType() != null && cfad40si.getSzCdMedUpdTransTypE() != null) {
      // The following temporary comment
      // contains text taken from the CFAD40S.src C-code,
      // along with the C conditonal logic itself,
      // to assist in clarifying and evaluating the Java conversion
      // of the intended original logic.

      // Also NOTE that the current code and logic
      // pertaining to Adoption Subsidy Trans Type TYPE_ADD and TYPE_TRANSFER
      // is not mentioned in the original comment text.
      /**
       When the Adoption Subsidy Trans Type is DEN, denial,
       and
       the Adoption Subsidy End Month is the current month
       and
       the current day is the 15th or after
       the Medicaid Update table should not be updated.

       if ((!strcmp(TYPE_ADD, pInputMsg->szCdMedUpdTransTypE))
       ||
       (!strcmp(TYPE_TRANSFER, pInputMsg->szCdMedUpdTransTypE))
       ||
       ((!strcmp(TYPE_DENIAL, pInputMsg->szCdMedUpdTransTypE))
       &&
       !(pInputMsg->CFAD40SIG00.dtDtAdptSubEnd.month == dtDtCurrentDate.month
       &&
       dtDtCurrentDate.day >= 15)))
       */

      // Get the current date and store it in dtCurrentDate
      Calendar cal = Calendar.getInstance();
      Date dtCurrentDate = cal.getTime();
      int dtCurrentDay = cal.get(Calendar.DAY_OF_MONTH);

      if ((TYPE_ADD.equals(cfad40si.getSzCdMedUpdTransTypE()))
                      || (TYPE_TRANSFER.equals(cfad40si.getSzCdMedUpdTransTypE()))
                      || ((TYPE_DENIAL.equals(cfad40si.getSzCdMedUpdTransTypE()))
                                      && !(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd() == DateHelper.toCastorDate(dtCurrentDate)
                                                      && dtCurrentDay >= 15))) {
        int idMedUpdRecord = 0;
        if (cfad40si.getROWCCMN01UIG00().getUlIdEvent() != 0) {
          idMedUpdRecord = cfad40si.getROWCCMN01UIG00().getUlIdEvent();
        } else {
          idMedUpdRecord = ulPostEventIdEvent;
        }
        //      six rc = caud99dAUDdam(sqlca, pCAUD99DInputRec, pCAUD99DOutputRec);
        numMedicaidUpdateRows = medicaidUpdateDAO.insertMedicaidUpdate(cfad40si.getROWCCMN01UIG00().getTsLastUpdate(),
                                                                       cfad40si.getUlIdPerson(),
                                                                       cfad40si.getROWCCMN01UIG00().getUlIdStage(),
                                                                       idMedUpdRecord,
                                                                       cfad40si.getSzCdMedUpdType(),
                                                                       cfad40si.getSzCdMedUpdTransTypE());
      }
    }
    if ((numMedicaidUpdateRows != 0)
                    && (bToDoFlag.get(FAD037)
                                    || bToDoFlag.get(FAD038)
                                    || bToDoFlag.get(FAD040)
                                    || bToDoFlag.get(FAD041)
                                    || bToDoFlag.get(FAD042))) {
      int bToDoFlagIndex = 0;
      int dtAdd1 = -90;
      int dtAdd2 = 45;
      Date dtSysDtTodoCfDueFrom = null;
      String sysTxtTodoCfDesc = new String();
      String sysTxtTodoCfLongDesc = new String();

      //

      // Get the current date and store it in dtCurrentDate
      Calendar cal = Calendar.getInstance();
      Date dtCurrentDate = cal.getTime();
      //    for (iToDoFlagCounter = 0;iToDoFlagCounter <= FAD042 && SUCCESS == RetVal;iToDoFlagCounter++) {
      for (Iterator<Boolean> it = bToDoFlag.iterator(); it.hasNext();) {
        boolean bToDoFlagInstance = it.next();

        //      if (true == bToDoFlag.charAt(iToDoFlagCounter)) {
        if (bToDoFlagInstance) {
          // BEGIN CSUB40U ToDo COMMON FUNTION
          CSUB40UI csub40ui = new CSUB40UI();
          //csub40ui.setArchInputStruct(new ArchInputStruct());
          csub40ui.setArchInputStruct(cfad40si.getArchInputStruct());
          csub40ui.setCSUB40UIG00(new CSUB40UIG00());
          //  Analyze return code
          switch (bToDoFlagIndex) {

          case FAD037:
            csub40ui.getCSUB40UIG00().setSzSysCdTodoCf("FAD037");
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtCurrentDate));
            sysTxtTodoCfDesc = csub40ui.getCSUB40UIG00().getSzSysTxtTodoCfDesc();
            sysTxtTodoCfDesc = (sysTxtTodoCfDesc != null ? sysTxtTodoCfDesc : "");
            csub40ui.getCSUB40UIG00().setSzSysTxtTodoCfDesc(sysTxtTodoCfDesc +=
              "Has the subsidy application for " + cfad40si.getSzNmStage() + " been received?");
            break;
          case FAD038:
            csub40ui.getCSUB40UIG00().setSzSysCdTodoCf("FAD038");
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
            // ??? Get the current date and store it in dtCurrDate
            dtSysDtTodoCfDueFrom = DateHelper.toJavaDate(csub40ui.getCSUB40UIG00().getDtSysDtTodoCfDueFrom());
            dtSysDtTodoCfDueFrom = DateHelper.addToDate(dtSysDtTodoCfDueFrom, 0, 0, dtAdd1);
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtSysDtTodoCfDueFrom));
            sysTxtTodoCfDesc = csub40ui.getCSUB40UIG00().getSzSysTxtTodoCfDesc();
            sysTxtTodoCfDesc = (sysTxtTodoCfDesc != null ? sysTxtTodoCfDesc : "");
            csub40ui.getCSUB40UIG00().setSzSysTxtTodoCfDesc(sysTxtTodoCfDesc +=
              "A new adoption subsidy period for " + cfad40si.getSzNmStage() + " needs to be created.");
            break;
          case FAD040:// No Svc Auth Detail Rows Found
            csub40ui.getCSUB40UIG00().setSzSysCdTodoCf("FAD040");
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent());
            dtSysDtTodoCfDueFrom = DateHelper.toJavaDate(csub40ui.getCSUB40UIG00().getDtSysDtTodoCfDueFrom());
            dtSysDtTodoCfDueFrom = DateHelper.addToDate(dtSysDtTodoCfDueFrom, 0, 0, dtAdd2);
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtSysDtTodoCfDueFrom));
            sysTxtTodoCfDesc = csub40ui.getCSUB40UIG00().getSzSysTxtTodoCfDesc();
            sysTxtTodoCfDesc = (sysTxtTodoCfDesc != null ? sysTxtTodoCfDesc : "");
            csub40ui.getCSUB40UIG00().setSzSysTxtTodoCfDesc(sysTxtTodoCfDesc +=
              "Has the subsidy agreement for " + cfad40si.getSzNmStage() + " been received?");
            break;
          case FAD041:
            csub40ui.getCSUB40UIG00().setSzSysCdTodoCf("FAD041");
            //  Get the current date and store it in dtCurrentDate
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtCurrentDate));
            sysTxtTodoCfDesc = csub40ui.getCSUB40UIG00().getSzSysTxtTodoCfDesc();
            sysTxtTodoCfDesc = (sysTxtTodoCfDesc != null ? sysTxtTodoCfDesc : "");
            csub40ui.getCSUB40UIG00().setSzSysTxtTodoCfDesc(
                                                            sysTxtTodoCfDesc += "You must complete the subsidy details or close the subsidy.");
            break;
          case FAD042:
            csub40ui.getCSUB40UIG00().setSzSysCdTodoCf("FAD042");
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
            dtSysDtTodoCfDueFrom = DateHelper.addToDate(dtSysDtTodoCfDueFrom, 0, 0, dtAdd1);
            csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtSysDtTodoCfDueFrom));
            sysTxtTodoCfDesc = csub40ui.getCSUB40UIG00().getSzSysTxtTodoCfDesc();
            sysTxtTodoCfDesc = (sysTxtTodoCfDesc != null ? sysTxtTodoCfDesc : "");
            csub40ui.getCSUB40UIG00().setSzSysTxtTodoCfDesc(
                                                            sysTxtTodoCfDesc += "The adoption subsidy for " + cfad40si.getSzNmStage() + " must be closed.");
            sysTxtTodoCfLongDesc = csub40ui.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc();
            sysTxtTodoCfDesc = (sysTxtTodoCfLongDesc != null ? sysTxtTodoCfLongDesc : "");
            csub40ui.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc(sysTxtTodoCfLongDesc += "The adoption subsidy for " +
                                                                cfad40si.getSzNmStage() +
            " must be closed.  The Close Adoption Subsidy batch processwill automatically close it 2 weeks before its end date");
            break;
          }
          if (0 == cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
            csub40ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          } else {
            csub40ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
          }
          csub40ui.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cfad40si.getROWCCMN01UIG00().getUlIdPerson());
          csub40ui.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(cfad40si.getROWCCMN01UIG00().getUlIdPerson());

          if (0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
            csub40ui.getCSUB40UIG00().setUlSysIdTodoCfEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
            csub40ui.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
          } else {
            csub40ui.getCSUB40UIG00().setUlSysIdTodoCfEvent(ulPostEventIdEvent);
            csub40ui.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
          }
          //        seven rc = Csub40u.TodoCommonFunction(pToDoCommonInput, pToDoCommonOutput, pServiceStatus);
          todoCommonFunction.audTodo(csub40ui);
        } // end if (bToDoFlagInstance)
        bToDoFlagIndex++;
      } // end for loop
    }

    cfad40so.setUlIdEvent((cfad40si.getROWCCMN01UIG00().getUlIdEvent() != 0) ? cfad40si.getROWCCMN01UIG00().getUlIdEvent() :ulPostEventIdEvent);

    return cfad40so;
  }

  private void saveAlert18(CFAD40SI cfad40si, int ulPostEventIdEvent){
    Stage stage = getPersistentObject(Stage.class, cfad40si.getROWCCMN01UIG00().getUlIdStage());
    Date birthDate = personDAO.findDateOfBirthByIdPerson(cfad40si.getUlIdPerson());
    Date birthDate18 = DateHelper.addToDate(birthDate, 18, 0, 0);
    String todoDesc = "";
    todoDesc = "Review adoption assistance eligibility for " + stage.getNmStage() + ".";
    Date birthDate18Minus30 = DateHelper.addToDate(birthDate18, 0, 0, -30);
    saveAlerts(cfad40si, todoDesc, birthDate18Minus30, ulPostEventIdEvent);
  }

  private void saveAlert21(CFAD40SI cfad40si, int ulPostEventIdEvent){
    Stage stage = getPersistentObject(Stage.class, cfad40si.getROWCCMN01UIG00().getUlIdStage());
    Date birthDate = personDAO.findDateOfBirthByIdPerson(cfad40si.getUlIdPerson());
    Date birthDate21 = DateHelper.addToDate(birthDate, 21, 0, 0);
    String todoDesc = "";
    todoDesc = "Complete Termination requirements for Adoption Assistance for " + stage.getNmStage() + ".";
    Date birthDate21Minus30 = DateHelper.addToDate(birthDate21, 0, 0, -30);
    saveAlerts(cfad40si, todoDesc, birthDate21Minus30, ulPostEventIdEvent);
  }

  private void saveAlert18DD(CFAD40SI cfad40si, int ulPostEventIdEvent){
    Stage stage = getPersistentObject(Stage.class, cfad40si.getROWCCMN01UIG00().getUlIdStage());
    Date birthDate = personDAO.findDateOfBirthByIdPerson(cfad40si.getUlIdPerson());
    Date birthDate18 = DateHelper.addToDate(birthDate, 18, 0, 0);
    String todoDesc = "";
    todoDesc = "Determine and Document " + stage.getNmStage() + "  continued eligibility for adoption assistance beyond the age of 18.";
    saveAlerts(cfad40si, todoDesc.substring(0, 80), birthDate18, ulPostEventIdEvent);
    //add an alert for every 3 months until the child terms 21
    for(int i = 0; i < 12; i++) {
      birthDate18 = DateHelper.addToDate(birthDate18, 0, 3, 0);
      saveAlerts(cfad40si, todoDesc.substring(0, 80), birthDate18, ulPostEventIdEvent);
    }
  }

  //STGAP00013779: Adoption Assistance Agreement has been terminated for child 
  //               Assign the alert to Regional Subsidy SAU (Adoptions Subsidy Staff)
  private void saveAlertTerminate(CFAD40SI cfad40si, int ulPostEventIdEvent){
    CapsCase capsCase = getPersistentObject(CapsCase.class, cfad40si.getUlIdCase());
    Stage stage = getPersistentObject(Stage.class, cfad40si.getROWCCMN01UIG00().getUlIdStage());
    String todoDesc = "";
    todoDesc = "Adoption Assistance Agreement has been terminated for child: " + stage.getNmStage();
    Date dateDue= new Date();
    String cdCounty = capsCase.getCdCaseCounty();
    //Get the region of the county
    String cdRegion = "0"+Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> regionalPersonList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
    //alert Special needs determination has been completed
    if (regionalPersonList != null && !regionalPersonList.isEmpty()) {
      Iterator<Integer> itrSauList = regionalPersonList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrSauList.hasNext()) {
        int idAssigned = (Integer) itrSauList.next();
        Todo todo = new Todo();
        Event event = null;
        if (0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
          event = getPersistentObject(Event.class, cfad40si.getROWCCMN01UIG00().getUlIdEvent());
        }else{
          event = getPersistentObject(Event.class, ulPostEventIdEvent);
        }
        String cdTask = "";
        Date dateCreated = new Date();
        todo.setDtTodoDue(dateDue);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
        todo.setTxtTodoDesc(todoDesc);
        todo.setCdTodoTask(cdTask);
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, cfad40si.getROWCCMN01UIG00().getUlIdPerson()));
        todo.setDtTodoCreated(dateCreated);
        todo.setStage(stage);
        todo.setCapsCase(capsCase);
        todo.setEvent(event);
        todoList.add(todo);
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }
  
  //STGAP00012573: Adoption Assistance Agreement has been completed for child 
  //               Assign the alert to Regional Subsidy SAU (Adoptions Subsidy Staff)
  private void saveAlertCOMPStatus(CFAD40SI cfad40si, int ulPostEventIdEvent){
    CapsCase capsCase = getPersistentObject(CapsCase.class, cfad40si.getUlIdCase());
    Stage stage = getPersistentObject(Stage.class, cfad40si.getROWCCMN01UIG00().getUlIdStage());
    String todoDesc = "";
    todoDesc = "Adoption Assistance Agreement has been completed for child: " + stage.getNmStage();
    Date dateDue= new Date();
    String cdCounty = capsCase.getCdCaseCounty();
    //Get the region of the county
    String cdRegion = "0"+Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> regionalPersonList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
    if (regionalPersonList != null && !regionalPersonList.isEmpty()) {
      Iterator<Integer> itrSauList = regionalPersonList.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrSauList.hasNext()) {
        int idAssigned = (Integer) itrSauList.next();
        Todo todo = new Todo();
        Event event = null;
        if (0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
          event = getPersistentObject(Event.class, cfad40si.getROWCCMN01UIG00().getUlIdEvent());
        }else{
          event = getPersistentObject(Event.class, ulPostEventIdEvent);
        }
        String cdTask = "";
        Date dateCreated = new Date();
        todo.setDtTodoDue(dateDue);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
        todo.setTxtTodoDesc(todoDesc);
        todo.setCdTodoTask(cdTask);
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, cfad40si.getROWCCMN01UIG00().getUlIdPerson()));
        todo.setDtTodoCreated(dateCreated);
        todo.setStage(stage);
        todo.setCapsCase(capsCase);
        todo.setEvent(event);
        todoList.add(todo);
      }
      complexTodoDAO.saveTodo(todoList);
    }
  }

  private void saveAlerts(CFAD40SI cfad40si, String todoDesc, Date birthDate18Minus30, int ulPostEventIdEvent){
    Todo todo = new Todo();
    Event event = null;
    CapsCase capsCase = getPersistentObject(CapsCase.class, cfad40si.getUlIdCase());
    Stage stage = getPersistentObject(Stage.class, cfad40si.getROWCCMN01UIG00().getUlIdStage());
    if (0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
      event = getPersistentObject(Event.class, cfad40si.getROWCCMN01UIG00().getUlIdEvent());
    }else{
      event = getPersistentObject(Event.class, ulPostEventIdEvent);
    }
    String cdTask = "";
    Date dateCreated = new Date();
    todo.setDtTodoDue(birthDate18Minus30);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, cfad40si.getROWCCMN01UIG00().getUlIdPerson()));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, cfad40si.getROWCCMN01UIG00().getUlIdPerson()));
    todo.setDtTodoCreated(dateCreated);
    todo.setStage(stage);
    todo.setCapsCase(capsCase);
    todo.setEvent(event);
    todoDAO.saveTodo(todo);
  }

  public void checkForActiveExistingTypes(int adptSubPerson, int idEvent, int idCase, CFAD40SO cfad40so, 
                                          Date dtAdptSubEffective, Date dtEndTerm, String adoptType, String priorEventStatus,
                                          int idSpecialNeedsEvent)
  throws ServiceException {
    //STGAP00013779: An active Basic/Specialized Rate Adoption Assistance Agreement currently exists. 
    List<String> cdAdoptionType = new ArrayList<String>();
    cdAdoptionType.add(CodesTables.CSUBTYPE_01);
    cdAdoptionType.add(CodesTables.CSUBTYPE_03);
    cdAdoptionType.add(CodesTables.CSUBTYPE_07);
    cdAdoptionType.add(CodesTables.CSUBTYPE_09);

    Map<String, Object> adoptionSubsidy = null;
    Integer idAdptSub = null;
    Double amtAdptSub = null;
    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent, adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_01) || adoptType.equals(CodesTables.CSUBTYPE_03) ||
                    adoptType.equals(CodesTables.CSUBTYPE_07) || adoptType.equals(CodesTables.CSUBTYPE_09))){
      cfad40so.setBIndActiveBasicSpeclzdRateAdoAsstnExists((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_BASIC_SPCLD_RATE_EXISTS);
      }
    }

    //STGAP00013779: An active Special Services- Child Care Agreement currently exists. 
    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_18);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }

    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_18))){
      cfad40so.setBIndActiveSpecServChildCareExists((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_CHILD_CARE_EXISTS);
      }
    }


    //STGAP00013779: An active Special Services- Respite Adoption Assistance Agreement currently exists. 
    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_10);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_10))){
      cfad40so.setBIndActiveSpecServRespiteExists((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_RESPITE_EXISTS);
      }
    }

    //STGAP00013779: An active IV-E/ IV-B State Medicaid Only (GA Child) Adoption Assistance Agreement currently exists. 
    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_26);
    cdAdoptionType.add(CodesTables.CSUBTYPE_27);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_26) || adoptType.equals(CodesTables.CSUBTYPE_27))){
      cfad40so.setBIndActiveIVEIVBMedicaidOnlyExists ((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_EXISTS);
      }
    }

    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_01) || adoptType.equals(CodesTables.CSUBTYPE_03) ||
                    adoptType.equals(CodesTables.CSUBTYPE_07) || adoptType.equals(CodesTables.CSUBTYPE_09) ||
                    adoptType.equals(CodesTables.CSUBTYPE_22) || adoptType.equals(CodesTables.CSUBTYPE_23) ||
                    adoptType.equals(CodesTables.CSUBTYPE_24) || adoptType.equals(CodesTables.CSUBTYPE_25) ||
                    adoptType.equals(CodesTables.CSUBTYPE_10) || adoptType.equals(CodesTables.CSUBTYPE_18) ||
                    adoptType.equals(CodesTables.CSUBTYPE_21) || adoptType.equals(CodesTables.CSUBTYPE_28) ||
                    adoptType.equals(CodesTables.CSUBTYPE_29) || adoptType.equals(CodesTables.CSUBTYPE_30))){
      cfad40so.setBIndActiveIVEIVBMedicaidOnlyExists ((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_OVERLAP);
      }
    }


    //STGAP00013779: Title IV-E/ IV- B State Medicaid Only (GA Child) Adoption Assistance Agreements can not overlap 
    //with other Type/Class of Assistance Agreements.  
    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_01);
    cdAdoptionType.add(CodesTables.CSUBTYPE_03);
    cdAdoptionType.add(CodesTables.CSUBTYPE_07);
    cdAdoptionType.add(CodesTables.CSUBTYPE_09);
    cdAdoptionType.add(CodesTables.CSUBTYPE_22);
    cdAdoptionType.add(CodesTables.CSUBTYPE_23);
    cdAdoptionType.add(CodesTables.CSUBTYPE_24);
    cdAdoptionType.add(CodesTables.CSUBTYPE_25);
    cdAdoptionType.add(CodesTables.CSUBTYPE_18);
    cdAdoptionType.add(CodesTables.CSUBTYPE_10);
    cdAdoptionType.add(CodesTables.CSUBTYPE_21);
    cdAdoptionType.add(CodesTables.CSUBTYPE_28);
    cdAdoptionType.add(CodesTables.CSUBTYPE_29);
    cdAdoptionType.add(CodesTables.CSUBTYPE_30);


    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }

    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_26) || adoptType.equals(CodesTables.CSUBTYPE_27))){
      cfad40so.setBIndActiveAllOtherExists ((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_OVERLAP);
      }
    }

    //STGAP00013779: An active Title IV- E Adoption Assistance Agreement currently exists. 
    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_01);
    cdAdoptionType.add(CodesTables.CSUBTYPE_03);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_01) || adoptType.equals(CodesTables.CSUBTYPE_03))){
      cfad40so.setBIndActiveIVEExists ((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_IVE_EXISTS);
      }
    }

    //STGAP00013779: An active Title IV-B State Adoption Assistance Agreement currently exists.  
    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_07);
    cdAdoptionType.add(CodesTables.CSUBTYPE_09);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
      }
    }
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_07) || adoptType.equals(CodesTables.CSUBTYPE_09))){
      cfad40so.setBIndActiveIVBExists ((idAdptSub != null) ? ArchitectureConstants.Y : ArchitectureConstants.N);
      if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
        throw new ServiceException(Messages.MSG_AGMT_IVB_EXISTS);
      }
    }
    
    //STGAP00014186: Error message 'Special Service Agreement exists for the attached Application' will display on the Save 
    //and Complete buttons when the user attempts to add a subsequent Agreement to an Application that already has a COMP 
    //Agreement. 
    
    Integer idAdoptionAgmtObj = adoptionSubsidyDAO.findSpecialServiceForAttachedApp(idSpecialNeedsEvent, idEvent);
    if(idAdoptionAgmtObj != null){
      throw new ServiceException(Messages.MSG_AGMT_SPCL_SERV_EXISTS);
    }
  }


  /**
   * STGAP00013779: Sets the Amount and indicator for displaying following error message 
   * Non-Recurring <type> Adoption Assistance Agreement for <amount> currently exists. 
   *
   * @param cfad40si
   * @return
   */
  public CFAD40SO checkForActiveNonRecAdoSubsidy(CFAD40SI cfad40si){
    CFAD40SO cfad40so = new CFAD40SO();
    int adptSubPerson = cfad40si.getUlIdPerson();
    int idCase = cfad40si.getUlIdCase();
    int idEvent = cfad40si.getROWCCMN01UIG00().getUlIdEvent();
    Date dtAdptSubEffective = DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubEffective());
    Date dtAdptSubEnd = DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
    String adoptType = cfad40si.getCFAD40SIG00().getSzCdAdptSubDeterm();
    double newNonRecAmt = cfad40si.getCFAD40SIG00().getSAmtAdptSub();
    Date dtAdptSubTerm = DateHelper.toJavaDate(cfad40si.getCFAD40SIG00().getDtDtAdptSubTerm());
    
    Date dtEndTerm = null; 
    if(dtAdptSubTerm != null){
      dtEndTerm = dtAdptSubTerm;
    }else{
      dtEndTerm = dtAdptSubEnd;
    }

    String priorEventStatus = StringHelper.EMPTY_STRING;
    
    Event eventInfo = eventDAO.findEventByIdEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
    if(eventInfo != null){
      priorEventStatus = eventInfo.getCdEventStatus();
    }
    
    //STGAP00013779: Non-Recurring <type> Adoption Assistance Agreement for <amount> currently exists.
    List<String> cdAdoptionType = new ArrayList<String>();
    Integer idAdptSub = null;
    Double amtAdptSub = null;
    Map<String, Object> adoptionSubsidy = null;

    cdAdoptionType.add(CodesTables.CSUBTYPE_22);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
        amtAdptSub = (Double) adoptionSubsidy.get("amtAdptSub");
      }
    }
    // STGAP00013932: Amount also taken into consideration
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_22) && (newNonRecAmt == amtAdptSub))){
      if(adoptionSubsidy != null){
        cfad40so.setDAmtActiveNonRecurrAdopLegalFees(amtAdptSub);
      }
      cfad40so.setBIndActiveNonRecurrAdopLegalFeesExists(ArchitectureConstants.Y);
    }

    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_23);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
        amtAdptSub = (Double) adoptionSubsidy.get("amtAdptSub");
      }
    }
    
    // STGAP00013932: Amount also taken into consideration
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_23)) && (newNonRecAmt == amtAdptSub)){
      if(adoptionSubsidy != null){
        cfad40so.setDAmtActiveNonRecurrTravel(amtAdptSub);
      }
      cfad40so.setBIndActiveNonRecurrTravelExists(ArchitectureConstants.Y);
    }

    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_24);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
        amtAdptSub = (Double) adoptionSubsidy.get("amtAdptSub");
      }
    }
    
    // STGAP00013932: Amount also taken into consideration
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_24)) && (newNonRecAmt == amtAdptSub)){
      if(adoptionSubsidy != null){
        cfad40so.setDAmtActiveNonRecurrLogMeals(amtAdptSub);
      }
      cfad40so.setBIndActiveNonRecurrLogMealsExists(ArchitectureConstants.Y );
    }

    idAdptSub = null;
    amtAdptSub = null;
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_25);

    if(adptSubPerson > 0 ) {
      adoptionSubsidy = adoptionSubsidyDAO.findActiveAdoptionSubsidyByIdPersonCdAdoptionType(idCase, idEvent,adptSubPerson, cdAdoptionType, dtAdptSubEffective, dtEndTerm);
      if(adoptionSubsidy != null){
        idAdptSub = (Integer) adoptionSubsidy.get("idAdptSub");
        amtAdptSub = (Double) adoptionSubsidy.get("amtAdptSub");
      }
    }
    
    // STGAP00013932: Amount also taken into consideration
    if(idAdptSub != null && (adoptType.equals(CodesTables.CSUBTYPE_25)) && (newNonRecAmt == amtAdptSub)){
      if(adoptionSubsidy != null){
        cfad40so.setDAmtActiveNonRecurrPhyAdopParent(amtAdptSub);
      }
      cfad40so.setBIndActiveNonRecurrPhyAdopParentExists(ArchitectureConstants.Y);
    }
    

    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = CodesTables.CEVNTTYP_AUT;
    int idStage = cfad40si.getROWCCMN01UIG00().getUlIdStage();
    List<String> cdSvcAuthDtlSvc = new ArrayList<String>();
    if (CodesTables.CPAYMTHD_PAR.equals(cfad40si.getCFAD40SIG00().getSzCdPlaymentMthd())) {
      if (CodesTables.CSUBTYPE_22.equals(adoptType)) {
        cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033A);
        List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO.findSvcAuthDtlByIdPerson(adptSubPerson, 
                                                                                    cdEventType, idStage,
                                                                                    cdSvcAuthDtlSvc, newNonRecAmt);
        if (svcAuthDtls != null && svcAuthDtls.size() > 0) {
          cfad40so.setDAmtActiveNonRecurrAdopLegalFees(newNonRecAmt);
          cfad40so.setBIndActiveNonRecurrAdopLegalFeesExists(ArchitectureConstants.Y);
        }
      }

      if (CodesTables.CSUBTYPE_23.equals(adoptType) || CodesTables.CSUBTYPE_24.equals(adoptType)) {
        cdAdoptionType.clear();
        cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033C);
        List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO.findSvcAuthDtlByIdPerson(adptSubPerson, 
                                                                                    cdEventType, idStage,
                                                                                    cdSvcAuthDtlSvc, newNonRecAmt);
        if (svcAuthDtls != null && svcAuthDtls.size() > 0) {
          if (CodesTables.CSUBTYPE_23.equals(adoptType)) {
            cfad40so.setDAmtActiveNonRecurrTravel(newNonRecAmt);
            cfad40so.setBIndActiveNonRecurrTravelExists(ArchitectureConstants.Y);
          } else if (CodesTables.CSUBTYPE_24.equals(adoptType)) {
            cfad40so.setDAmtActiveNonRecurrLogMeals(newNonRecAmt);
            cfad40so.setBIndActiveNonRecurrLogMealsExists(ArchitectureConstants.Y);
          }
        }
      }

      if (CodesTables.CSUBTYPE_25.equals(adoptType)) {
        cdAdoptionType.clear();
        cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033B);
        List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO.findSvcAuthDtlByIdPerson(adptSubPerson, 
                                                                                    cdEventType, idStage,
                                                                                    cdSvcAuthDtlSvc, newNonRecAmt);
        if (svcAuthDtls != null && svcAuthDtls.size() > 0) {
          cfad40so.setDAmtActiveNonRecurrPhyAdopParent(newNonRecAmt);
          cfad40so.setBIndActiveNonRecurrPhyAdopParentExists(ArchitectureConstants.Y);
        }
      }

    }
    cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033B);
    cdSvcAuthDtlSvc.add(CodesTables.CADOSVCD_51033C);
    List<SvcAuthDetail> svcAuthDtls = svcAuthDetailDAO.findSvcAuthDtlByIdPerson(adptSubPerson, cdEventType, idStage, cdSvcAuthDtlSvc, newNonRecAmt);
    
    //STGAP00013779: Adding this Non-Recurring Expenses will take the child over the spending limit of Approved NonRecurring 
    // amount on the Adoption Assistance Application.
    SpecialNeedsDetermination specialNeedsNonRec = specialNeedsDeterminationDAO.findLatestApprovedNonRecSpclDetermination(cfad40si.getROWCCMN01UIG00().getUlIdStage(), adptSubPerson, idCase);
    if(specialNeedsNonRec != null){    
      cfad40so.setDAmtNonRecLimit(specialNeedsNonRec.getNbrNonRecAprvAmt());
    }
    cdAdoptionType.clear();
    cdAdoptionType.add(CodesTables.CSUBTYPE_22);
    cdAdoptionType.add(CodesTables.CSUBTYPE_23);
    cdAdoptionType.add(CodesTables.CSUBTYPE_24);
    cdAdoptionType.add(CodesTables.CSUBTYPE_25);
    Double adopSubNonRecAmt = adoptionSubsidyDAO.totalNonRecAdoptionSubsidyAmt(idCase, adptSubPerson, cdAdoptionType);
    if(adopSubNonRecAmt == null){
      adopSubNonRecAmt = 0.0;
    }else {
      cfad40so.setDAmtSumAdopSubNonRec(adopSubNonRecAmt);
    }
    
    //do all the following for PAD stage only
    
    String cdStage = stageDAO.findCdStageByIdStage(idStage);
    
    Double amountAgreement = 0.0;
    Double usedAmount = 0.0;
    Double usedAmountTerm= 0.0;
    if (CodesTables.CSTAGES_PAD.equals(cdStage)
        && CodesTables.CPAYMTHD_PAR.equals(cfad40si.getCFAD40SIG00().getSzCdPlaymentMthd())
        && (CodesTables.CSUBTYPE_22.equals(adoptType) || CodesTables.CSUBTYPE_23.equals(adoptType)
            || CodesTables.CSUBTYPE_24.equals(adoptType) || CodesTables.CSUBTYPE_25.equals(adoptType))) {

      if (cfad40si.getCFAD40SIG00().getDtDtAdptSubTerm() == null) {
        // find the application attached to the agreement
        Integer idSpeicalNeedsDetermination = cfad40si.getCFAD40SIG00().getUlIdSpecialNeedsEvent();
        List<Integer> idServiceAuths = null;
        List<Integer> idAgreements = null;

        if (idSpeicalNeedsDetermination != null) {
          // find all the services auths ids attached to the application
          List<String> cdSvcDtlServiceList = new ArrayList<String>();
          cdSvcDtlServiceList.add(CodesTables.CSVCCODE_51033A);
          cdSvcDtlServiceList.add(CodesTables.CSVCCODE_51033B);
          cdSvcDtlServiceList.add(CodesTables.CSVCCODE_51033C);
          cdEventType = CodesTables.CEVNTTYP_AUT;
          String cdSvcAuthCategory = CodesTables.CPROGCDE_510;

          Date dtToday = new Date();
          usedAmount = svcAuthDetailDAO.getTotalSvcAuthDetailAmountReqFor510ForAgreement(idSpeicalNeedsDetermination,
                                                                                         cdSvcDtlServiceList, dtToday,
                                                                                         cdEventType);
          if (usedAmount == null) {
            usedAmount = 0.0;
          }
          usedAmountTerm = svcAuthDetailDAO
                                           .getTotalSvcAuthDetailAmountReqFor510TermForAgreement(
                                                                                                 idSpeicalNeedsDetermination,
                                                                                                 cdSvcDtlServiceList,
                                                                                                 dtToday, cdEventType);
          if (usedAmountTerm == null) {
            usedAmountTerm = 0.0;
          }

          // find the total of all agreements attached to this application
          cdEventStatus = CodesTables.CEVTSTAT_COMP;
          cdEventType = CodesTables.CEVNTTYP_ADP;
          String cdPaymentMthd = CodesTables.CPAYMTHD_PAR;
          List<String> cdSpclAsstType = new ArrayList<String>();
          cdSpclAsstType.add(CodesTables.CSUBTYPE_22);
          cdSpclAsstType.add(CodesTables.CSUBTYPE_23);
          cdSpclAsstType.add(CodesTables.CSUBTYPE_24);
          cdSpclAsstType.add(CodesTables.CSUBTYPE_25);
          amountAgreement = adoptionSubsidyDAO.getTotalAgreementAmountUsed(idSpeicalNeedsDetermination,
                                                                           cfad40si.getROWCCMN01UIG00().getUlIdStage(),
                                                                           cdEventStatus, cdEventType, cdPaymentMthd,
                                                                           cdSpclAsstType);
          if (amountAgreement == null) {
            amountAgreement = 0.0;
          }
        }

        Double totalAmount = usedAmount + usedAmountTerm + amountAgreement + newNonRecAmt;
        if (totalAmount > specialNeedsNonRec.getNbrNonRecAprvAmt()) {
          cfad40so.setBIndOverSpendingLimitPad(ArchitectureConstants.Y);
        }
      }
    }
    
    //STGAP00014354: No validation in COMP status
    if(!EVENT_STATUS_COMP.equals(priorEventStatus)){
      //STGAP00013779: Adding this Non-Recurring Expenses will take the child over the spending limit of Approved NonRecurring 
      // amount on the Adoption Assistance Application.
      if(specialNeedsNonRec != null && adopSubNonRecAmt != null && (adoptType.equals(CodesTables.CSUBTYPE_22) || adoptType.equals(CodesTables.CSUBTYPE_23) ||
                      adoptType.equals(CodesTables.CSUBTYPE_24) || adoptType.equals(CodesTables.CSUBTYPE_25)) &&
                      (adopSubNonRecAmt + cfad40si.getCFAD40SIG00().getSAmtAdptSub()) > specialNeedsNonRec.getNbrNonRecAprvAmt()){
        cfad40so.setBIndOverSpendingLimit(ArchitectureConstants.Y);
      }
    }
    
    return cfad40so;
  }
}
