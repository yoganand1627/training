package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is the Service that saves the Payment of care record to the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   03/10/08  vdevarak  STGAP00007343 - Added another condition to the 
 *                       overlap validation to cover the scenario where the 
 *                       start date of the Payment of care that is being 
 *                       saved is before the the start date of an existing 
 *                       Payment of care and the end date is null. 
 *  03/25/08  vdevarak   STGAP00006420 - Added code for Gap Messages.
 *  
 *  04/20/2009 bgehlot   STGAP00013305: Added the null check for the endDate
 *  04/21/2009 arege     STGAP00013397: Added changes for MR-033 Relative
 *                       Care Invoicing Changes.
 *  05/24/2011 hnguyen   SMS#109407: MR-087 Include new Child turns 18 checkbox
 *                       to save. Also updated court review alert message. Added
 *                       logic to calculate alert due date.                        
 *  05/26/2011 hnguyen   SMS#109407: MR-087 Removed logic that create Court Review Due
 *                       alert on submit of POC.  It has been moved to SaveApprovalImpl 
 *                       to create alert on Approval of the POC.
 *  06/01/2011 arege     SMS#108265: Added new public method isRelativeCareAssessmentApproved()
 *                       
 * </pre>
 */
public class SavePaymentOfCareImpl extends BaseServiceImpl implements SavePaymentOfCare {

  private ApprovalDAO approvalDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private ApproversDAO approversDAO = null;

  private ApprovalRejectionDAO approvalRejectionDAO = null;

  private EventDAO eventDAO = null;

  private PostEvent postEvent = null;

  private PaymentOfCareDAO paymentOfCareDAO = null;

  private PersonDAO personDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private CapsResourceDAO capsResourceDAO = null;

  private RelativeCareAssmtDAO relativeCareAssmtDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private TodoDAO todoDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private WorkloadDAO workloadDAO = null;

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setRelativeCareAssmtDAO(RelativeCareAssmtDAO relativeCareAssmtDAO) {
    this.relativeCareAssmtDAO = relativeCareAssmtDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPersonDAO(PersonDAO personDAO) throws ServiceException {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) throws ServiceException {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public PaymentOfCareSaveSI savePaymentOfCare(PaymentOfCareSaveSI paymentOfCareSave) {
    PaymentOfCare poc = new PaymentOfCare();
    ROWCCMN01UIG00 pocEvent = paymentOfCareSave.getRowccmn01uig00();
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(paymentOfCareSave.getUlIdStage(),
                                                                              PRIMARY_CHILD);

    int idEvent = pocEvent.getUlIdEvent();
    int idStage = pocEvent.getUlIdStage();
    String cdTask = paymentOfCareSave.getSzCdTask();
    Event event = null;
    pocEvent.setUlIdPerson(paymentOfCareSave.getIdUser());

    if (idEvent != 0) {
      poc = (PaymentOfCare) getPersistentObject(PaymentOfCare.class, idEvent);
      event = (Event) getPersistentObject(Event.class, idEvent);
      poc.setEvent(event);
      pocEvent.setTsLastUpdate(event.getDtLastUpdate());
    }

    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    rowccmn01uig01_array.getROWCCMN01UIG01(0).setUlIdPerson(idPerson);

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(paymentOfCareSave.getCdReqFuncCd())) {
      // STGAP00003348
      int idEventToDelete = paymentOfCareSave.getUlIdEvent();
      deleteApprovals(idEventToDelete);
      // to delete to-do that has event id populated (some alerts, etc.)
      todoDAO.deleteTodoByIdTodoEvent(idEventToDelete);
      // end STGAP00003348
      EventPersonLink epl = eventPersonLinkDAO.findEventPersonLinkByIdEventAndIdPerson(idEvent, idPerson);
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
      rowccmn01uig01_array.getROWCCMN01UIG01(0).setTsLastUpdate(epl.getDtLastUpdate());
      pocEvent.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
      paymentOfCareDAO.deletePOC(idEventToDelete);
      callPostEvent(paymentOfCareSave.getCdReqFuncCd(), pocEvent);
    } else {

      String eventReqFuncCd = "";

      // set person ojects based on person id
      if (!(paymentOfCareSave.getIdSuprvsrApprv() == 0)) {
        Person suprvsrApprv = personDAO.findPersonByIdPerson(paymentOfCareSave.getIdSuprvsrApprv());
        poc.setPersonByIdSpvPacketAprv(suprvsrApprv);
      }
      if (!(paymentOfCareSave.getIdRBWOStaffApprv() == 0)) {
        Person rbwoStaff = personDAO.findPersonByIdPerson(paymentOfCareSave.getIdRBWOStaffApprv());
        poc.setPersonByIdRbwoRevAprv(rbwoStaff);
      }
      if (!(paymentOfCareSave.getIdPersonCompleting() == 0)) {
        Person personComp = personDAO.findPersonByIdPerson(paymentOfCareSave.getIdPersonCompleting());
        poc.setPersonByIdCmPacketComp(personComp);
      }
      if (!(paymentOfCareSave.getIdRelative() == 0)) {
        CapsResource relative = capsResourceDAO.findCapsResourceByIdResourceOnly(paymentOfCareSave.getIdRelative());
        poc.setCapsResourceByIdResource(relative);
      }
      if (!(paymentOfCareSave.getIdSOStaffApprv() == 0)) {
        Person soStaffApprv = personDAO.findPersonByIdPerson(paymentOfCareSave.getIdSOStaffApprv());
        poc.setPersonByIdSoAprv(soStaffApprv);
      }

      CCMN01UO ccmn01uo = new CCMN01UO();

      // if the save object has data
      if (paymentOfCareSave != null) {
        poc.setCdPocType(paymentOfCareSave.getPocType());

        if (!DateHelper.isNull(paymentOfCareSave.getEndDate())) {
          poc.setDtEnd(paymentOfCareSave.getEndDate());
        } else if (!DateHelper.isNull(paymentOfCareSave.getRenewDate())) {
          poc.setDtEnd(paymentOfCareSave.getRenewDate());
        } else { // STGAP00002536
          poc.setDtEnd(null);
        } // end STGAP00002536

        // Start Date is a required field so no need for else clause
        if (paymentOfCareSave.getStartDate() != null) {
          poc.setDtStart(paymentOfCareSave.getStartDate());
        } else if (paymentOfCareSave.getEffPaymentDate() != null) {
          poc.setDtStart(paymentOfCareSave.getEffPaymentDate());
        }
        poc.setDtTerminate(paymentOfCareSave.getDtTerminate());
        poc.setNbrSpecPerDiem(paymentOfCareSave.getSpecialRate());
        poc.setIndConcurrent(paymentOfCareSave.getIndConcurrentPerDiem());
        poc.setTxtConcurPDiem(paymentOfCareSave.getTxtReasonConcurrentPD());
        poc.setTxtSpecPerDiem(paymentOfCareSave.getTxtReasonSpecializedPD());
        poc.setDtPacketComp(paymentOfCareSave.getDtPacketComplete());
        poc.setDtPacketAprv(paymentOfCareSave.getDtEmergSupApprv());
        poc.setDtPacketSent(paymentOfCareSave.getDtPacketSent());
        poc.setDtStaffCompl(paymentOfCareSave.getDtStaffingComplete());
        poc.setDtSoResp(paymentOfCareSave.getDtStateOfficeResponse());
        poc.setDtRbwoAprv(paymentOfCareSave.getDtRBWOReview());
        poc.setDtAgreement(paymentOfCareSave.getAgreeDate());
        poc.setDtAnnReview(paymentOfCareSave.getAnnualRevDate());
        poc.setAmtSpecFcRbwoWaiver(paymentOfCareSave.getSpecFcRbwoWaiver());
        poc.setTxtReasonSpecWaiver(paymentOfCareSave.getTxtReasonSpecWaiver());
        poc.setDtCourt(paymentOfCareSave.getCourtRevDate());
        // MR-087 added Child turns 18 checkbox
        poc.setInd18ByNextCrtRvw(paymentOfCareSave.getInd18ByNextCrtRvw());
        poc.setIndIncome(paymentOfCareSave.getIndFamIncomeLess());
        poc.setIndTerminate(paymentOfCareSave.getIndTerminate());
        poc.setIndRcsType(paymentOfCareSave.getIndRcsType());
        poc.setIndSuspend(paymentOfCareSave.getIndSuspend());
        poc.setTxtTerminate(paymentOfCareSave.getTxtReasonTerm());
        poc.setIndRbwoType(paymentOfCareSave.getIndRbwoType());
        // STGAP00004406
        poc.setIndCCI(paymentOfCareSave.getIndProgramType());
        poc.setCdRbwoProgram(paymentOfCareSave.getRbwoProgramType());
        // end STGAP00004406
        //STGAP00013397- MR - 033
        poc.setInd80PerDiem(paymentOfCareSave.getInd80PerDiem());
        poc.setInd100PerDiem(paymentOfCareSave.getInd100PerDiem());
        poc.setIndCustomWaiver(paymentOfCareSave.getIndCustomWaiver());
        poc.setAmtWaiver(paymentOfCareSave.getWaiverAmount());
        poc.setTxtWaiverReason(paymentOfCareSave.getTxtWaiverReason());        
        //End STGAP00013397- MR - 033
      }
      String eventPersonReqFunc = "";
      if (idEvent != 0) {
        eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
        eventPersonReqFunc = ServiceConstants.REQ_FUNC_CD_NO_ACTION;
      } else {
        eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
        eventPersonReqFunc = ServiceConstants.REQ_FUNC_CD_ADD;
      }

      rowccmn01uig01_array.getROWCCMN01UIG01(0).setSzCdScrDataAction(eventPersonReqFunc);
      pocEvent.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

      checkStageEventStatus(eventReqFuncCd, idStage, cdTask);

      ccmn01uo = callPostEvent(eventReqFuncCd, pocEvent);
      idEvent = ccmn01uo.getUlIdEvent();
      event = (Event) getPersistentObject(Event.class, idEvent);

      poc.setEvent(event);
      poc.setIdPocEvent(idEvent);
      paymentOfCareDAO.savePOC(poc);
      paymentOfCareSave.setUlIdEvent(idEvent);

      // Create system generated To-dos - event was set to COMP on save and submit earlier; will change to PEND later by
      // other process
      // so check for Pending stage here
      if ("COMP".equals(paymentOfCareSave.getRowccmn01uig00().getSzCdEventStatus())) {
        String pocType = paymentOfCareSave.getPocType();
        Person child = personDAO.findPersonByIdPerson(idPerson);
        int idPersAssigned = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage,
                                                                                         CodesTables.CROLEALL_PR);

        if (CodesTables.CPOCTYPE_ERR.equals(pocType) || CodesTables.CPOCTYPE_RCS.equals(pocType)
            || CodesTables.CPOCTYPE_ERS.equals(pocType) || CodesTables.CPOCTYPE_NSG.equals(pocType)
            || CodesTables.CPOCTYPE_NEG.equals(pocType)) {
          addDtRelativePOCExpireAlertTodo(idEvent, paymentOfCareSave.getIdCase(), idStage,
                                          paymentOfCareSave.getIdUser(), poc.getDtEnd(), child.getNmPersonFull(),
                                          idPersAssigned);
        }
        if (CodesTables.CPOCTYPE_EFD.equals(pocType) || CodesTables.CPOCTYPE_SFD.equals(pocType)) {
          addDtSpecPDExpireAlertTodo(idEvent, paymentOfCareSave.getIdCase(), idStage, paymentOfCareSave.getIdUser(),
                                     paymentOfCareSave.getEndDate(), child.getNmPersonFull(), idPersAssigned);
        }
        if (CodesTables.CPOCTYPE_ERR.equals(pocType) || CodesTables.CPOCTYPE_RCS.equals(pocType)
            || CodesTables.CPOCTYPE_ERS.equals(pocType) || CodesTables.CPOCTYPE_NSG.equals(pocType)
            || CodesTables.CPOCTYPE_NEG.equals(pocType) || CodesTables.CPOCTYPE_SUG.equals(pocType)
            || CodesTables.CPOCTYPE_ESG.equals(pocType)) {
          addDtStopRelativeSubsidyAlertTodo(idEvent, paymentOfCareSave.getIdCase(), idStage,
                                            paymentOfCareSave.getIdUser(), poc.getDtEnd(), child.getNmPersonFull(),
                                            idPersAssigned);
        }
      }// end system generated to-dos

    }
    return paymentOfCareSave;
  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdTask) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

  /**
   * returnCode = 0 : no overlapping @param @return 
   */
  public int checkStartDateOverlapsEndDate(int idPocEvent, Date startDate, Date endDate, int idStage, String indConcurrent) {
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
    List<Map> datesMap = null;
    int returnCode = 0;
    datesMap = paymentOfCareDAO.findEndAndTerminateDateByIdPerson(idPerson, indConcurrent, idPocEvent);
    if (datesMap == null) {
      returnCode = 0;
    }
    for (Iterator<Map> it = datesMap.iterator(); it.hasNext();) {
      Map row = it.next();
      Date start = (Date) row.get("dtStart");
      Date end = (Date) row.get("dtEnd");
      Date terminate = (Date) row.get("dtTerminate");
      // STGAP00002536
      Date actualEndDate;
      if (!DateHelper.isNull(terminate)) {
        actualEndDate = terminate;
      } else {
        actualEndDate = end;
      }
      // 1. Current start date before previous end date: invalid
      // 2. Current start date equal previous start date and if previous start is different from previous end: invalid
      // (user might be trying to cancel a payment approved by mistake by endating it the same day it started)
      // 3. The previous has not ended
      if ((!DateHelper.isNull(actualEndDate) && startDate.after(start) && startDate.before(actualEndDate))
          || (startDate.equals(start) && !start.equals(actualEndDate))
          || (DateHelper.isNull(actualEndDate) && startDate.after(start))) {
        returnCode = 1;
        break;
      }// STGAP00007343: Added the 'or' condition to account for the scenarios where the start date of the current
      // Payment of care date is before the start date of the existing Payment of care and end date of the currrent
      // payment of care is null.
      else if ((startDate.before(start) && !DateHelper.isNull(endDate) && endDate.after(start))
               || (startDate.before(start) && DateHelper.isNull(endDate))) {
        returnCode = 2;
        break;
      }else {
        returnCode = 0;
      }
      // end STGAP00002536
    }
    //STGAP00006420:This method is called to check gaps between the POC records and display appropriate messages.
    //STGAP00008743: Added aditional check to eliminate concurrent POCs from Gap Check validation.
    if(returnCode ==0 && ArchitectureConstants.N.equals(indConcurrent)){
      checkGap(idPerson, idPocEvent, startDate, endDate);
    }
    return returnCode;
  }

  public boolean isRelativeCareApproved(int idPerson, int idStage) {
    boolean isApproved = true;
    //STGAP00007630: Modified this method to retrieve the approved relative care assessment for the given stage 
    //which has the child listed as a 'Child to be placed'. Since there is no way of tying a relative care assessment,
    //to the resource selected on the Payment of care, we are checking to see if there is any relative care assessment 
    //in that stage that has the child listed as the person of type 'Child to be placed'. 
    String personType = CodesTables.CPRNTYP_CHP;
    RelativeCareAssmt rca = relativeCareAssmtDAO.findRelativeApprvByIdStage(idPerson, idStage, personType);
    if (rca == null) {
      isApproved = false;
    } else {
      isApproved = true;
    }
    return isApproved;
  }
  public boolean isRelativeCareAssessmentApproved(int idStage) {
    boolean isApproved = true;
    // SMS#108265
    RelativeCareAssmt rca = relativeCareAssmtDAO.findRelativeAssmtApprv(idStage);
    if (rca == null) {
      isApproved = false;
    } else {
      isApproved = true;
    }
    return isApproved;
  }

  public ROWCSUB45SOG01 findLegalStatus(int idStage, Date dtEffDate) {
    ROWCSUB45SOG01 rowcsub45sog01 = null;
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
    LegalStatus legalStatus = legalStatusDAO.findLegalStatusByIdPersonByDtLegalStatStatusDt(idPerson, dtEffDate);
    if (legalStatus != null) {
      rowcsub45sog01 = new ROWCSUB45SOG01();
      rowcsub45sog01.setSzCdLegalStatCnty(legalStatus.getCdLegalStatCnty());
      rowcsub45sog01.setSzCdLegalStatStatus(legalStatus.getCdLegalStatStatus());
      rowcsub45sog01.setUlIdLegalStatEvent(legalStatus.getIdLegalStatEvent());
    }
    return rowcsub45sog01;
  }
  
  // STGAP00006420: Added this method to check gaps between the POC records and display appropriate messages.
  private void checkGap(int idPerson, int idPocEvent,Date startDate, Date endDate){
    List<Map> datesMap1 = null;
    List<Date> startDateList = new ArrayList<Date>();
    List<Date> endDateList = new ArrayList<Date>();
    datesMap1 = paymentOfCareDAO.findEndAndTerminateDateByIdPerson(idPerson,idPocEvent);
    boolean addMode = true;
    Date dtCurrStdate = DateHelper.MAX_JAVA_DATE;
    Date dtCurrEdDate = DateHelper.MIN_JAVA_DATE;
    if(idPocEvent >0){
      PaymentOfCare poc = paymentOfCareDAO.findPOC(idPocEvent);
      dtCurrStdate = poc.getDtStart();
      dtCurrEdDate = poc.getDtEnd();
      Date dtCurrTrmDate = poc.getDtTerminate();
      if(!DateHelper.isNull(dtCurrTrmDate)){
        dtCurrEdDate = dtCurrTrmDate;
      }
      addMode = false;
    }
    if (datesMap1 != null) {
      for (Iterator<Map> it = datesMap1.iterator(); it.hasNext();) {
        Map row = it.next();
        Date start = (Date) row.get("dtStart");
        Date end = (Date) row.get("dtEnd");
        Date terminate = (Date) row.get("dtTerminate");
        // STGAP00002536
        Date actualEndDate;
        if (!DateHelper.isNull(terminate)) {
          actualEndDate = terminate;
        } else {
          actualEndDate = end;
        }
        if (addMode) {
          //This if condition is to account for concurrent records.
          if (actualEndDate == null && (start.before(startDate) || start.equals(startDate))) {
            endDateList = new ArrayList<Date>();
            break;
          } else {
            if (actualEndDate != null && startDate != null
                && (actualEndDate.before(startDate) || actualEndDate.equals(startDate))) {
              endDateList.add(actualEndDate);
            }
          }
          if (start != null && endDate != null && (start.after(endDate) || start.equals(endDate))) {
            startDateList.add(start);
          }
        } else {
          //This if condition is to account for concurrent records.
          if (actualEndDate == null && (start.before(startDate) || start.equals(startDate))) {
            endDateList = new ArrayList<Date>();
            break;
          } else {
            if (actualEndDate != null && dtCurrStdate != null
                && (actualEndDate.before(dtCurrStdate) || actualEndDate.equals(dtCurrStdate))) {
              endDateList.add(actualEndDate);
            }
          }
          if (start != null && dtCurrEdDate != null && (start.after(dtCurrEdDate) || start.equals(dtCurrEdDate))) {
            startDateList.add(start);
          }
        }
      }
      Collections.sort(startDateList, Collections.reverseOrder());
      Date stDate = DateHelper.MAX_JAVA_DATE;
      Date edDate = DateHelper.MIN_JAVA_DATE;
      if (startDateList.size() > 0) {
        stDate = Collections.min(startDateList);
      }
      if (endDateList.size() > 0) {
        edDate = Collections.max(endDateList);
      }
      
      //STGAP00013305: Added the null check for the endDate
      if (!edDate.equals(DateHelper.MIN_JAVA_DATE) && startDate.after(edDate)
          && !stDate.equals(DateHelper.MAX_JAVA_DATE) && !DateHelper.isNull(endDate) && endDate.before(stDate)) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_3);
      } else if (!edDate.equals(DateHelper.MIN_JAVA_DATE) && startDate.after(edDate)) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_1);
      } else if (!stDate.equals(DateHelper.MAX_JAVA_DATE) && !DateHelper.isNull(endDate) && endDate.before(stDate)) {
        throw new ServiceException(Messages.MSG_SUB_GAP_EXISTS_2);
      }
    }
  }
  public boolean childHasDob (int idPerson) {
    Date childDob = personDAO.findDateOfBirthByIdPerson(idPerson);
    return (!DateHelper.isNull(childDob));
  }

  private int addDtRelativePOCExpireAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date endDate,
                                              String nmStage, int persAssigned) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = DateHelper.addToDate(endDate, 0, 0, -45);
    String todoDesc = "Relative Payment of Care due to expire for " + nmStage;
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, persAssigned));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

  private int addDtSpecPDExpireAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date endDate,
                                         String nmStage, int persAssigned) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    // int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = DateHelper.addToDate(endDate, 0, 0, -60);
    String todoDesc = "Special or Specialized FC Per Diem due to expire for " + nmStage;
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, persAssigned));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

  private int addDtStopRelativeSubsidyAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date endDate,
                                                String nmStage, int persAssigned) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    // int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = DateHelper.addToDate(endDate, 0, 0, -5);
    String todoDesc = "Ensure stop payment of rel/non-rel rate/subsidy for " + nmStage;
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, persAssigned));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

  private void deleteApprovals(int idEvent) {
    List<Integer> idApprovalList = approvalEventLinkDAO.findIdApprovalEventLinksByIdEvent(idEvent);
    if (idApprovalList != null && !idApprovalList.isEmpty()) {
      // Delete the todo associating approver
      List<Approvers> approversList = approversDAO.findApproversByIdApproval(idApprovalList);
      if (approversList != null && !approversList.isEmpty()) {
        for (Iterator<Approvers> it = approversList.iterator(); it.hasNext();) {
          Approvers approvers = it.next();
          int idTodo = approvers.getTodo().getIdTodo();
          if (idTodo != 0) {
            Todo todo = getPersistentObject(Todo.class, idTodo);
            todoDAO.deleteTodo(todo);
          }
        }
      }
      approversDAO.deleteApproversByIdApproval(idApprovalList);
      approvalRejectionDAO.deleteApprovalRejectionByIdApproval(idApprovalList);
      approvalEventLinkDAO.deleteApprovalEventLinkByIdEvent(idEvent);
      approvalDAO.deleteApprovalByIdApproval(idApprovalList);
      eventDAO.deleteAppEventByIdApproval(idApprovalList);
    }
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public void setApprovalRejectionDAO(ApprovalRejectionDAO approvalRejectionDAO) {
    this.approvalRejectionDAO = approvalRejectionDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
}