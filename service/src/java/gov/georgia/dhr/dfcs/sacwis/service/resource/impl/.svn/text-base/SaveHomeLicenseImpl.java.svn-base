package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   03/18/11    Hai Nguyen        SMS#97850: MR-75 Updated logic to allow save in approval mode without
 *                                 invalidating current pending event.
 *   03/25/11    Hai Nguyen        SMS#97850: MR-075 Removed logic that set resource status on save or submit, 
 *                                 this should only be set on approval based on home current status and hold placment cbx.
 *
*/

import java.util.Calendar;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveHomeLicense;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;

public class SaveHomeLicenseImpl extends BaseServiceImpl implements SaveHomeLicense {

  /*
   * * Declare FOUNDATION variables
   */
  static final String HOME_STUDY_VIEW = "HOME_STUD_NARR_VIEW";

  private CheckStageEventStatus checkStageEventStatus = null;
  
  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoDAO todoDAO = null;

  private TodoCommonFunction todoCommonFunction = null;



  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
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

  @SuppressWarnings({"unchecked"})
  public CFAD38SO saveHomeLicense(CFAD38SI cfad38si) throws ServiceException {
    CFAD38SO cfad38so = new CFAD38SO();

    /*
     * * Declare local variables
     */
    int RetVal = SUCCESS;

    // input services
    CCMN01UI ccmn01ui = null;
    CCMN06UI ccmn06ui = null;
    CCMN05UI ccmn05ui = null;
    /* ToDo common function */
    CSUB40UI pTodoCommonInput = null;
    CFAD01UI cfad01ui = null;

    // output services
    CSUB40UO pTodoCommonOutput = null;
    CFAD01UO cfad01uo = null;

    // row
    ROWCCMN01UIG00 rowccmn01uig00_ccmn01ui = null;
    RetVal = SUCCESS;

    ccmn06ui = new CCMN06UI();

    ccmn06ui.setArchInputStruct(cfad38si.getArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(cfad38si.getArchInputStruct().getCReqFuncCd());
    ROWCCMN01UIG00 rowccmn01uig00_1 = cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(NEXT);
    ccmn06ui.setUlIdStage(rowccmn01uig00_1.getUlIdStage());
    ccmn06ui.setSzCdTask(rowccmn01uig00_1.getSzCdTask());

    // rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
    try {
          checkStageEventStatus.status(ccmn06ui);
    } catch (ServiceException se1) {
      int errorCode = se1.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_SYS_MULT_INST:
          RetVal = SUCCESS;
          break;
        case Messages.MSG_SYS_STAGE_CLOSED:
          RetVal = FAILED;
          break;
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
          RetVal = FAILED;
          break;
        default:
          RetVal = FAILED;
          break;

      } // end switch (errorCode)
    } // end catch se1
    CCMN01UO postEventOutput = new CCMN01UO();
    postEventOutput.setTsLastUpdate(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(CURRENT).getTsLastUpdate());
    if (RetVal == SUCCESS) {
      /*
       * * Invalidate Approval Processing.
       * * NOTE: Id Event for the current event will only be populated if Invalidate
       * Approval Procesing needs to occur.
       */
      ROWCCMN01UIG00 rowccmn01uig00_2 = cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(CURRENT);
      int input_IdEvent = rowccmn01uig00_2.getUlIdEvent();
      
      // MR-075 We don't want to invalidate the current event while in approval mode
      if (input_IdEvent > 0 && !cfad38si.getIsApprovalMode()) {
        ArchInputStruct archInputStruct = cfad38si.getArchInputStruct();
        ArchInputStruct ccmn05ui_archInputStruct = new ArchInputStruct();
        ccmn05ui_archInputStruct.setCReqFuncCd(archInputStruct.getCReqFuncCd());
        ccmn05ui_archInputStruct.setUlSysNbrReserved1(archInputStruct.getUlSysNbrReserved1());

        ccmn05ui = new CCMN05UI();
        ccmn05ui.setArchInputStruct(ccmn05ui_archInputStruct);
        ccmn05ui.setUlIdEvent(input_IdEvent);
        // Exceptions will be thrown for failure; success is no output.
        // rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
        try {
          invalidateApproval.invalidateApproval(ccmn05ui);

          ccmn01ui = new CCMN01UI();
          ArchInputStruct ccmn01_archInputStruct = new ArchInputStruct();
          ccmn01_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
          ccmn01ui.setArchInputStruct(ccmn01_archInputStruct);

          rowccmn01uig00_ccmn01ui = new ROWCCMN01UIG00();
          ROWCCMN01UIG00 rowccmn01uig00_3 = cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(CURRENT);
          if( rowccmn01uig00_3 != null ){
            rowccmn01uig00_ccmn01ui.setSzCdTask(rowccmn01uig00_3.getSzCdTask());
            rowccmn01uig00_ccmn01ui.setSzCdEventStatus(rowccmn01uig00_3.getSzCdEventStatus());
            rowccmn01uig00_ccmn01ui.setSzCdEventType(rowccmn01uig00_3.getSzCdEventType());
            rowccmn01uig00_ccmn01ui.setSzTxtEventDescr(rowccmn01uig00_3.getSzTxtEventDescr());
            rowccmn01uig00_ccmn01ui.setTsLastUpdate(rowccmn01uig00_3.getTsLastUpdate());
            rowccmn01uig00_ccmn01ui.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
            rowccmn01uig00_ccmn01ui.setUlIdEvent(rowccmn01uig00_3.getUlIdEvent());
            rowccmn01uig00_ccmn01ui.setUlIdStage(rowccmn01uig00_3.getUlIdStage());
            rowccmn01uig00_ccmn01ui.setUlIdPerson(rowccmn01uig00_3.getUlIdPerson());
            //set into parent struct
            ccmn01ui.setROWCCMN01UIG00( rowccmn01uig00_ccmn01ui );
          }
          // rc = Ccmn01u.PostEvent(ccmn01ui, pCCMN01UOutputRec, pServiceStatus);
          try {
            postEventOutput = postEvent.postEvent(ccmn01ui);
          } catch (ServiceException se2) {
            RetVal = FAILED;
          }

        } catch (ServiceException se1) {
          RetVal = FAILED;
        }
      } // end if (0 < rowccmn01uig00_2.getUlIdEvent())

      /*
       * * Post Event Processing if Return Value 
       * * equals FND_SUCCESS from Invalidate 
       * * Approval processing or if
       * Invalidate * Approval processing was not necessary.
       */
      if (SUCCESS == RetVal) { // # 0
        ccmn01ui = new CCMN01UI();
        ArchInputStruct ccmn01_archInputStruct = new ArchInputStruct();
        rowccmn01uig00_ccmn01ui = new ROWCCMN01UIG00();
        ROWCCMN01UIG00 rowccmn01uig00_3 = cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(NEXT);
        ccmn01_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        rowccmn01uig00_ccmn01ui.setUlIdEvent(rowccmn01uig00_3.getUlIdEvent());
        rowccmn01uig00_ccmn01ui.setTsLastUpdate(rowccmn01uig00_3.getTsLastUpdate());
        rowccmn01uig00_ccmn01ui.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
        ccmn01ui.setArchInputStruct(ccmn01_archInputStruct);
        rowccmn01uig00_ccmn01ui.setUlIdStage(rowccmn01uig00_3.getUlIdStage());
        
        rowccmn01uig00_ccmn01ui.setSzCdTask(rowccmn01uig00_3.getSzCdTask());
        rowccmn01uig00_ccmn01ui.setSzCdEventType(rowccmn01uig00_3.getSzCdEventType());
        rowccmn01uig00_ccmn01ui.setSzTxtEventDescr(rowccmn01uig00_3.getSzTxtEventDescr());
        
        rowccmn01uig00_ccmn01ui.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        
        
        rowccmn01uig00_ccmn01ui.setUlIdPerson(rowccmn01uig00_3.getUlIdPerson());          
        //set rowccmn01uig00_ccmn01ui into parent struct 
        ccmn01ui.setROWCCMN01UIG00( rowccmn01uig00_ccmn01ui );
        
        // rc = Ccmn01u.PostEvent(ccmn01ui, pCCMN01UOutputRec, pServiceStatus);
        try {
          postEventOutput = postEvent.postEvent(ccmn01ui);

          // MR-075 If in Approval Mode and supervisor saves a license change
          // then only add a new event without creating a history
          int idRsrcFaHomeEvent = 0;
          if(!cfad38si.getIsApprovalMode()){
            cfad38so.setUlIdEvent(postEventOutput.getUlIdEvent());
            idRsrcFaHomeEvent = postEventOutput.getUlIdEvent();
          }else{
            cfad38si.setCIndRshsWriteHist(ServiceConstants.FND_NO);
            ROWCCMN01UIG00 rowccmn01uig00Current =cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(CURRENT);
            idRsrcFaHomeEvent = rowccmn01uig00Current.getUlIdEvent();
          }

          // Update specific columns on CAPS_RESOURCE
          // rc = caud98dAUDdam(sqlca, pCAUD98DInputRec, pCAUD98DOutputRec);
          String faHomeType = cfad38si.getCCdRsrcFaHomeType1();
          //STGAP00014815: the updateCapsResource call now takes a value for region
          // to ensure this data is not lost when the update is performed
          int updteCapResCnt = complexCapsResourceDAO.updateCapsResource(cfad38si.getSzCdRsrcCategory(),
                                                                  cfad38si.getSzCdRsrcFaHomeStatus(),
                                                                  cfad38si.getCIndRshsWriteHist(),
                                                                  cfad38si.getUNbrRsrcMlAgeMin(),
                                                                  cfad38si.getUNbrRsrcMlAgeMax(),
                                                                  cfad38si.getUNbrRsrcFMAgeMin(),
                                                                  cfad38si.getUNbrRsrcFMAgeMax(),
                                                                  cfad38si.getUNbrRsrcFacilCapacity(),
                                                                  cfad38si.getSNbrRsrcOpenSlots(),
                                                                  getPositionString(faHomeType, 0, 3),
                                                                  getPositionString(faHomeType, 3, 6),
                                                                  getPositionString(faHomeType, 6, 9),
                                                                  getPositionString(faHomeType, 9, 12),
                                                                  getPositionString(faHomeType, 12, 15),
                                                                  getPositionString(faHomeType, 15, 18),
                                                                  getPositionString(faHomeType, 18, 21),
                                                                  idRsrcFaHomeEvent,
                                                                  cfad38si.getSzNmRsrcLastUpdate(),
                                                                  cfad38si.getSzCdRshsRegion(),
                                                                  cfad38si.getSzCdRsrcInvolClosure(),
                                                                  cfad38si.getSzCdRsrcClosureRsn(),
                                                                  cfad38si.getSzCdRsrcRecmndReopen(),
                                                                  cfad38si.getUlIdResource(),
                                                                  cfad38si.getTsLastUpdate(),
                                                                  cfad38si.getDtDtApprvlBegin(),
                                                                  cfad38si.getDtDtApprvlEnd(),
                                                                  cfad38si.getSzTxtStatusRsnComments(),
                                                                  cfad38si.getDtFosterParentManual(),
                                                                  cfad38si.getDtFosterParentBill(),
                                                                  cfad38si.getBIndHoldPlacements());
          if (updteCapResCnt == 0) {
            RetVal = FAILED;
          }
        } catch (ServiceException se3) {// end catch post.postEvent()
          RetVal = FAILED;
        }

        // SIR 11917- Added the TODO AUD Dam, CAUDB7D, to the
        // save service so that whenever the data for FAD to do's
        // is saved, the associated TODOs, if any, will
        // be taken off the Staff TODO List.The CAUDB7D dam updates
        // the date TODO completed and removes the TODO from the
        // TODO list whenever the window data is saved.

        // rc = caudb7dAUDdam(sqlca, pCAUDB7DInputRec, pCAUDB7DOutputRec);
        ROWCCMN01UIG00 rowccmn01uig00_5 = cfad38si.getROWCCMN01UIG00_ARRAY()
                .getROWCCMN01UIG00(NEXT);
        int toDoUpdtCnt = todoDAO.updateToDoDtTodoCompletedByIdStageAndCdTodoTask(rowccmn01uig00_5.getUlIdStage(),
                                                                                  rowccmn01uig00_5.getSzCdTask());
      } // end if (RetVal == SUCCESS) // # 0
    } // end if (RetVal == SUCCESS) after Check Stage/Event common func */



    /*
     * * Send Alert ToDo to worker if FA Home Status * has been changed to Applicant
     */
    if (SUCCESS == RetVal && FND_YES == cfad38si.getCSysIndAppStatusChange()) {
      pTodoCommonInput = new CSUB40UI();
      ArchInputStruct archInputStruct = new ArchInputStruct();
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      pTodoCommonInput.setArchInputStruct(archInputStruct);

      pTodoCommonOutput = new CSUB40UO();
      /*
       * * Set CSUB40UI CdTodoCf to FAD047
       */
      CSUB40UIG00 csub40uig00New = new CSUB40UIG00();
      csub40uig00New.setSzSysCdTodoCf("FAD047");
      //set csub40uig00New into the input object
      pTodoCommonInput.setCSUB40UIG00(csub40uig00New);     

      // SIR - 3321
      // Set CSUB40UI DtTodoCfDueFrom to SystemDate
      Date dtSysDtTodoCfDueFrom = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

      CSUB40UIG00 csub4ouig00 = pTodoCommonInput.getCSUB40UIG00();
      csub4ouig00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(dtSysDtTodoCfDueFrom));
      /*
       * * Set SysIdTodoCfStage to FA Home Stage
       */
      csub4ouig00.setUlSysIdTodoCfStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(NEXT).getUlIdStage());
      /*
       * * Set TxtTodoCfDesc to * If NmResource Home is still an applicant, please follow-up.
       */
      csub4ouig00.setSzSysTxtTodoCfDesc("If ");
      csub4ouig00.setSzSysTxtTodoCfDesc(csub4ouig00.getSzSysTxtTodoCfDesc() + cfad38si.getSzNmResource()
                                        + " Home is still an Applicant, please follow-up.");
      
      //set the creator
      csub40uig00New.setUlSysIdTodoCfPersCrea(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(NEXT).getUlIdPerson());
      

      /*
       * * Call CSUB40U
       */
      // rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
      pTodoCommonOutput = todoCommonFunction.audTodo(pTodoCommonInput);
    }

    return cfad38so;
  }

  public boolean checkEvalDocExists(int idStage){
    Date dtLastUpdate = commonDAO.findDtLastUpdate(HOME_STUDY_VIEW, idStage);
    if (dtLastUpdate == null) {
      return false;
    }else
      return true;
  }
  
  /**
   * returns string - the characters located between the beginIndex value and the endIndex value 
   */
  private String getPositionString(String str, int beginIndex, int endIndex ) {
    String returnString = "";
    if(StringHelper.isValid(str) && str.length() >= endIndex && str.trim().substring(beginIndex, endIndex) != "" )
      return  str.trim().substring(beginIndex, endIndex);
    else
    return returnString;
  }
  
  /**
   * given a date and a time value it returns the integer value of a day, month, or year
   */
  private int getGivenTimeFieldValue(Date date, int timeValue) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(timeValue);
  }

  /*
   * returns the day of a date
   */
  private int getDay(Date date) {
    return getGivenTimeFieldValue(date, Calendar.DAY_OF_MONTH);
  }

  /*
   * returns the month of a date
   */
  private int getMonth(Date date) {
    return getGivenTimeFieldValue(date, Calendar.MONTH);
  }

  /*
   * returns the year of a date
   */
  private int getYear(Date date) {
    return getGivenTimeFieldValue(date, Calendar.YEAR);
  }
}
