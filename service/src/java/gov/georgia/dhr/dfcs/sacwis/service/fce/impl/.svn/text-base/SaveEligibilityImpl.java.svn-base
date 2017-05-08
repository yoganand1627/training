package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   08/03/2009  hjbaptiste        STGAP00014946 - Set the indWriteHistory indicator to 'Y' if there are paid invoices
 *                                 for the primary child and the saved Eligibility is the first one recorded for the 
 *                                 child for the case
 *   12/09/2009  arege             SMS#37426 Saving Eligibility Summary page in PAD stage should not create a Redetermination task 
 *                                 and alerts. 
 *   12/12/2010  hjbaptiste        SMS#81144: MR-053 No longer creating a Redetermination task and alerts. This is taken care of by
 *                                 the Batch Alerts  
 *   01/17/2011  hjbaptiste        SMS#81144: Update the Eligibility table with indicator that indicates if Reimbursability has 
 *                                 been created                                                          
 *
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InvoiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveChildSupportReferralOutbound;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveEligibility;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB19SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY_CSUB19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UlIdPersonSecondary_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveEligibilityImpl  extends BaseServiceImpl implements SaveEligibility {
  
  private final String ROLE_PRIM_CHILD = CodesTables.CROLEALL_PC;
  private final String ROLE_PRIM_WORKER = CodesTables.CROLEALL_PR;
  private final int CURRENT = 0;
  private final int NEXT = 1;
  //private final int EVENT = 0;
  //private final int ELIG = 1;
  private final String STATUS_NEW = "NEW";     // Task is NEW 
  private final String REQ_FUNC_CD_ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  private final String REQ_FUNC_CD_UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;

  private WorkloadDAO workloadDAO = null;
  private PostEvent postEvent = null;
  private CheckStageEventStatus checkStageEventStatus = null;
  private ComplexEligibilityDAO complexEligibilityDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoDAO todoDAO = null;
  private InvoiceDAO invoiceDAO = null;
  
  private SaveChildSupportReferralOutbound saveChildSupportReferralOutbound = null;

  
  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexEligibilityDAO(ComplexEligibilityDAO complexEligibilityDAO) {
    this.complexEligibilityDAO = complexEligibilityDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
    this.invoiceDAO = invoiceDAO;
  }

  public void setSaveChildSupportReferralOutbound(SaveChildSupportReferralOutbound saveChildSupportReferralOutbound) {
    this.saveChildSupportReferralOutbound = saveChildSupportReferralOutbound; 
  }

  public CSUB19SO saveEligibility(CSUB19SI csub19si) throws ServiceException{
    CSUB19SO csub19so = new CSUB19SO();
    
    ArchInputStruct archInputStruct = csub19si.getArchInputStruct();
    
    ROWCSUB19SIG01 rowcsub19sig01 = csub19si.getROWCSUB19SIG01();
    
    //  Check Stage/Event Status Common Function
    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    int idStage = rowcsub19sig01.getUlIdStage();
    int idEvent = rowcsub19sig01.getUlIdEvent();
    
    if (0 == idEvent)
    {
      ccmn06ui_archInputStruct.setCReqFuncCd(REQ_FUNC_CD_ADD);       
    } /* end if */
    else
    {
      ccmn06ui_archInputStruct.setCReqFuncCd(REQ_FUNC_CD_UPDATE);
    }   
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(rowcsub19sig01.getSzCdTask());
    // CheckStageEventStatus;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);

    // OBTAIN ID_PERSON OF THE STAGE'S PRIMARY CHILD
    Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, ROLE_PRIM_CHILD);
    if (idPrimaryChild == null || idPrimaryChild == 0){
      throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
    }
    // Obtain ID_PERSON of the stage's primary worker
    int idPrimaryWorker = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, ROLE_PRIM_WORKER);
    ROWCSUB19SIG00 rowcsub19sig00 = csub19si.getROWCSUB19SIG00();
    rowcsub19sig00.setUlIdPerson(idPrimaryWorker);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
    
    if (0 == idEvent)
    {
      ccmn01ui_archInputStruct.setCReqFuncCd(REQ_FUNC_CD_ADD);       
    } /* end if */
    else
    {
      ccmn01ui_archInputStruct.setCReqFuncCd(REQ_FUNC_CD_UPDATE);
    }  
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
    SzCdEventStatus_ARRAY szCdEventStatus_array = rowcsub19sig01.getSzCdEventStatus_ARRAY();
    String tempCdEventStatus = szCdEventStatus_array.getSzCdEventStatus(CURRENT);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    if (STATUS_NEW.equals(tempCdEventStatus) || idEvent == 0){
      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
      rowccmn01uig01.setSzCdScrDataAction(REQ_FUNC_CD_ADD); 
      rowccmn01uig01.setUlIdPerson(idPrimaryChild);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    } 
    rowccmn01uig00.setSzCdTask(rowcsub19sig01.getSzCdTask());
    rowccmn01uig00.setSzCdEventStatus(szCdEventStatus_array.getSzCdEventStatus(NEXT));
    rowccmn01uig00.setSzCdEventType(rowcsub19sig01.getSzCdEventType());
    rowccmn01uig00.setSzTxtEventDescr(rowcsub19sig01.getSzTxtEventDescr());
    rowccmn01uig00.setUlIdPerson(rowcsub19sig00.getUlIdPersonUpdate());
    rowccmn01uig00.setUlIdStage(idStage);
    // dtDtEventOccurred for NEW Eligibility Determinations will be set 
    // to NULL_DATE in the window and set to SYSDATE in this save service
    Date dtEventOccurred = DateHelper.toJavaDate(rowcsub19sig01.getDtDtEventOccurred());
    if (dtEventOccurred == null)
    {
      Date now = new Date();
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(now));
    }
    else
    {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    }
    rowccmn01uig00.setUlIdEvent(idEvent);
    rowccmn01uig00.setTsLastUpdate(rowcsub19sig01.getTsLastUpdate());
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    if (REQ_FUNC_CD_ADD.equals(archInputStruct.getCReqFuncCd())){
      csub19so.setUlIdEvent(ccmn01uo.getUlIdEvent());
    } else if (REQ_FUNC_CD_UPDATE.equals(archInputStruct.getCReqFuncCd())){
      csub19so.setUlIdEvent(idEvent);
    }
    TsLastUpdate_ARRAY_CSUB19SO tsLastUpdate_array = new TsLastUpdate_ARRAY_CSUB19SO();
    Date tsLastUpdate = ccmn01uo.getTsLastUpdate();
    tsLastUpdate_array.addTsLastUpdate(tsLastUpdate);
    int rowQty_lastUpdate = 1;
    tsLastUpdate_array.setUlRowQty(rowQty_lastUpdate);
    csub19so.setTsLastUpdate_ARRAY_CSUB19SO(tsLastUpdate_array);
    // (BEGIN): ELIGIBILITY SAVE
    Eligibility eligibility = new Eligibility();
    if (REQ_FUNC_CD_UPDATE.equals(archInputStruct.getCReqFuncCd())){
      eligibility = (Eligibility) getPersistentObject(Eligibility.class, idEvent);
    }
    eligibility.setDtEligCsupReferral(DateHelper.toJavaDate(rowcsub19sig00.getDtDtEligCsupReferral()));
    eligibility.setDtEligStart(DateHelper.toJavaDate(rowcsub19sig00.getDtDtEligStart()));
    eligibility.setDtEligReview(DateHelper.toJavaDate(rowcsub19sig00.getDtDtEligReview()));
    eligibility.setDtEligEnd(DateHelper.toJavaDate(rowcsub19sig00.getDtDtEligEnd()));
    int idEligibilityEvent = 0;
    if (0 == idEvent)
    {
      idEligibilityEvent = csub19so.getUlIdEvent();      
    } /* end if */
    else
    {
      idEligibilityEvent = idEvent;
    }

    // STGAP00014946 - check to see if this is the first eligibility record for the child for that case
    // if it is then check to see if there are any foster care type invoices that are in Paid ('PAD') or submitted ('SBT') status. 
    // If there are then set the IND_ELIG_WRITE_HISTORY to 'Y'
    long numPaidInvoices = 0;
    if (CodesTables.CEVTSTAT_NEW.equals(tempCdEventStatus)) {
      Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
      long numApprvElig =  eligibilityDAO.countEligEventByIdPersonIdCaseAndExcludedEvent(idPrimaryChild, stage.getCapsCase().getIdCase(), idEvent);
      if (numApprvElig == 0) {
        numPaidInvoices = invoiceDAO.countPaidInvoicesByIdPerson(idPrimaryChild);
      }
    }
    Event eligEvent = (Event) getPersistentObject(Event.class, idEligibilityEvent);
    eligibility.setEvent(eligEvent);
    Person personUpdate = (Person) getPersistentObject(Person.class, rowcsub19sig00.getUlIdPersonUpdate());
    eligibility.setPersonByIdPersonUpdate(personUpdate);
    eligibility.setCdEligActual(rowcsub19sig00.getSzCdEligActual());
    Date lastUpdate = rowcsub19sig00.getTsLastUpdate();
    eligibility.setCdEligMedEligGroup(rowcsub19sig00.getSzCdEligMedEligGroup());
    eligibility.setCdFceEligReason(rowcsub19sig00.getSzCdFceEligReason());
    eligibility.setCdEligSelected(rowcsub19sig00.getSzCdEligSelected());
    Person personByIdPerson = (Person) getPersistentObject(Person.class, idPrimaryChild);
    eligibility.setPersonByIdPerson(personByIdPerson);
    String bSysIndPrfrmValidation = csub19si.getBSysIndPrfrmValidation();
    eligibility.setIndEligWriteHistory(rowcsub19sig00.getCIndEligWriteHistory());
    eligibility.setIndReviewCreated(rowcsub19sig00.getCIndReviewCreated());
    if (numPaidInvoices > 0) {
      eligibility.setIndEligWriteHistory(ServiceConstants.FND_YES);
    }
    eligibility.setTxtChildSuppRefComment(rowcsub19sig00.getSzTxtChildSuppRefComment());
    eligibility.setTxtEligComment(rowcsub19sig00.getSzTxtEligComment());
    eligibility.setIndEligCsupSend(rowcsub19sig00.getCIndEligCsupSend());
    String bSysIndGeneric = csub19si.getBSysIndGeneric();
    
    if (REQ_FUNC_CD_ADD.equals(archInputStruct.getCReqFuncCd())){
      // This will handle any exceptions that is caught
      complexEligibilityDAO.insertEligibility(bSysIndPrfrmValidation, bSysIndGeneric, eligibility);
    } else if (REQ_FUNC_CD_UPDATE.equals(archInputStruct.getCReqFuncCd())){
      eligibility.setDtLastUpdate(lastUpdate);
      // This will handle any exceptions that is caught
      complexEligibilityDAO.updateEligibility(bSysIndPrfrmValidation, eligibility);
    } else {
      // do nothing
    }
    Eligibility addEligibility = eligibilityDAO.findEligibilityByIdEligEvent(idEvent);
//    if (addEligibility == null){
//      addEligibility = getPersistentObject(Eligibility.class, idEvent);
//    }
    // if the object is STILL null, throw exception
    if (addEligibility == null){
      throw new ServiceException(Messages.ARC_ERR_SQL_ERROR);
    }
    tsLastUpdate_array.addTsLastUpdate(addEligibility.getDtLastUpdate());
    tsLastUpdate_array.setUlRowQty(rowQty_lastUpdate++);
    // (BEGIN) Todo PROCESSING 
    todoDAO.updateTodoByIdEvent(idEvent);
    
    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    String cdStage = null;
    if (stage != null) {
      cdStage = stage.getCdStage();
    }
    return csub19so;
  }
}
