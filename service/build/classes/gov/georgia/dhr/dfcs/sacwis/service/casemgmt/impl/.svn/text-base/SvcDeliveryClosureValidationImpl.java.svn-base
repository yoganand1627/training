package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SvcDeliveryClosureValidation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV20SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV20SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROW_ERROR_MAPPING;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
* 
* <pre>
*  Change History:
*  Date         User      Description
*  --------  --------  --------------------------------------------------
*  10/21/2009   arege   SMS#38635 The error message of MSG_ONG_SAFETY_RES_EVENT should NOT be thrown while approving ONG stage closure
*                       for SRP events in COMP or APRV Status.
*  02/23/10   hnguyen   Check that all Child Death/Near Fatality/Serious Injury report event is approved,
*                       if not then add MSG_INV_CDNFSI_APRV to error list
*  04/28/10   arege     SMS#42496: Prevent save and submit of stage closure, if any of the events in the stage are in PEND status
*/
public class SvcDeliveryClosureValidationImpl extends BaseServiceImpl implements SvcDeliveryClosureValidation {


  public static final int _CCMN87DO__ROWCCMN87DO_SIZE = 100;
  public static final int CVS_REMOVAL_EDIT = 0;
  public static final String ACTION_CODE_SUBMIT = "S";
  public static final String SVC_AUTH_APPROVAL_TASK = "3310";
  public static final String FPR_FAMILY_PLAN_TASK = "7080";
  public static final String ACTION_CODE_CLOSE = "C";
  public static final String PUP_SERVICE = "521";

  private ApproversDAO approversDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private CloseStageCase closeStageCase = null;

  private DynamicEventDAO dynamicEventDAO = null;

  private EventDAO eventDAO = null;

  private StageDAO stageDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;
  
  private SafetyResourceChildDAO safetyResourceChildDAO = null;
  
  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  } 

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public CSVC16SO svcDeliveryClosureValidation(CSVC16SI csvc16si) throws ServiceException {
    CSVC16SO csvc16so = new CSVC16SO();
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(csvc16si.getArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn06ui.setUlIdStage(csvc16si.getUlIdStage());
    ccmn06ui.setSzCdTask(csvc16si.getSzCdTask());
    try {
      checkStageEventStatus.status(ccmn06ui);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      // Check the message for error codes, otherwise just throw
      // the error returned.
      case Messages.MSG_SYS_STAGE_CLOSED:
        throw new ServiceException(Messages.MSG_SYS_STAGE_CLOSED, se);
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, se);
      case Messages.MSG_SYS_MULT_INST:
        throw new ServiceException(Messages.MSG_SYS_MULT_INST, se);
      default:
        throw se;
      }
    }

    CINV20SOG01 cinv20sog01 = new CINV20SOG01();
    csvc16so.setCINV20SOG01(cinv20sog01);
    UsSysNbrMessageCode_ARRAY usSysNbrMessageCode_array = new UsSysNbrMessageCode_ARRAY();
    cinv20sog01.setUsSysNbrMessageCode_ARRAY(usSysNbrMessageCode_array);
    String cdStageType = csvc16si.getSzCdStageType();
    int idCase = csvc16si.getUlIdCase();

    //SWR 06/27/08 STGAP00008568 - Added error message for Safety Resource
    if (hasOpenSafetyResourcePlacements(idCase)) {
      usSysNbrMessageCode_array.addUsSysNbrMessageCode(Messages.MSG_SRP_ONG_CLOSE);       
    }    
    
    //ARR 07/11/2009 STGAP00014331 - Error message on Stage closure of ONG if there is an Open Safety Resource Event
    if (hasOpenSafetyResourceEvent(idCase)) {
      usSysNbrMessageCode_array.addUsSysNbrMessageCode(Messages.MSG_ONG_SAFETY_RES_EVENT);       
    }
    
    // check to see if there are any open service auths
    int result = callServiceAuth(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), cdStageType);
    if (result != 0){
      usSysNbrMessageCode_array.addUsSysNbrMessageCode(result);
    }
    
    // check that all Child Death/Near Fatality/Serious Injury reported event is approved
    if (existsUnapprovedCNSByIdStage(csvc16si.getUlIdStage())) {
      usSysNbrMessageCode_array.addUsSysNbrMessageCode(Messages.MSG_INV_CDNFSI_APRV);
    }
    
    
    //SMS#42496:Check if any of the events are in PEND status in ONG 
    List<Event> pendingEvents = eventDAO.findEventByIdStageAndCdEventStatus(csvc16si.getUlIdStage(), CodesTables.CEVTSTAT_PEND);
    if(pendingEvents != null && !pendingEvents.isEmpty()){
      for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
        Event pendingEvent = (Event) it.next();
        String eventType = pendingEvent.getCdEventType();
        if (!CodesTables.CEVNTTYP_CCL.equals(eventType)) { // Need to check for if it is not CCL event type as the code 
          //does stageclosure edits checks in approval mode. i.e. while saving stage closure approval
          usSysNbrMessageCode_array.addUsSysNbrMessageCode(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);//Change with with "Cannot close stage with one or more events in PEND status
        }
      }
    
    }

    // check to see if there is a removal event if the closure reason is foster care opened
    if (!StringHelper.EMPTY_STRING.equals(csvc16si.getSzDcdEditProcess())
        && csvc16si.getSzDcdEditProcess().length() >= CVS_REMOVAL_EDIT) {
      if (ArchitectureConstants.Y.charAt(0) == csvc16si.getSzDcdEditProcess().charAt(CVS_REMOVAL_EDIT)) {

        List<Object[]> objectArrayList = findEvents(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(),
                                                    CodesTables.CEVNTTYP_REM);

        if (objectArrayList == null || objectArrayList.isEmpty()) {
          csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY()
                  .addUsSysNbrMessageCode(Messages.MSG_STAGE_OPEN);
        }
      }
    }

    if (!(csvc16so.getCINV20SOG01().getUlRowQty() != 0)) {
      if (ACTION_CODE_SUBMIT.equals(csvc16si.getArchInputStruct().getCReqFuncCd())) {
        int TempRowCtr = csvc16so.getCINV20SOG01().getUlRowQty();

        // Delete the Todo
        try {
          updateEventClosingStatus(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), CodesTables.CEVTSTAT_PEND,
                                   csvc16so);
          csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY()
                  .addUsSysNbrMessageCode(Messages.MSG_SVC_EVENT_PENDING);

          // update family plan event to comp
          updateEventByIdStageCdEventType(csvc16si.getUlIdStage());
        } catch (ServiceException se) {
          int rc = se.getErrorCode();
          switch (rc) {
          case Messages.MSG_NO_ROWS_RETURNED:

            if (TempRowCtr == csvc16so.getCINV20SOG01().getUlRowQty()) {
              updateEventClosingStatus(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), CodesTables.CEVTSTAT_COMP,
                                       csvc16so);

              updateEventClosingStatus(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), CodesTables.CEVTSTAT_PROC,
                                       csvc16so);
            }
          default:
            throw se;
          }
        }
      }

      if (ACTION_CODE_CLOSE.equals(csvc16si.getArchInputStruct().getCReqFuncCd())) {

        updateEventClosingStatus(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), CodesTables.CEVTSTAT_COMP, csvc16so);

        updateEventClosingStatus(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), CodesTables.CEVTSTAT_PROC, csvc16so);
        // update family plan event to COMP
        updateEventByIdStageCdEventType(csvc16si.getUlIdStage());
        // Update the Event Status (Intervening Update Strategy)
        closeStage(csvc16si.getUlIdStage(), csvc16si.getSzCdStage(), csvc16si.getSzCdStageProgram(),
                   csvc16si.getSzCdStageReasonClosed(), csvc16so.getCINV20SOG00_ARRAY().enumerateCINV20SOG00());

      }
    }

    return csvc16so;

  }

  private void closeStage(int idStage, String cdStage, String cdStageProgram, String cdStageReasonClosed,
                          Enumeration rowCINV20SOG00Enum) throws ServiceException {

    CCMN02UI ccmn02ui = new CCMN02UI();
    updateEventByIdEvent(rowCINV20SOG00Enum);
    ccmn02ui.getCCMN02UIG00().setUlIdStage(idStage);
    ccmn02ui.getCCMN02UIG00().setSzCdStage(cdStage);
    ccmn02ui.getCCMN02UIG00().setSzCdStageProgram(cdStageProgram);
    ccmn02ui.getCCMN02UIG00().setSzCdStageReasonClosed(cdStageReasonClosed);

    closeStageCase.closeStageCase(ccmn02ui);
  }

  private void updateEventByIdEvent(Enumeration rowCINV20SOG00EnumInput) throws ServiceException {
    // The ARC_SUCCESS initializtion has been added to the following line
    // so that the logic relevant exiting out of the loop in this function
    // will work correctly.

    // Loop through Service Delivery Events, changing status to Approved
    for (Enumeration rowCINV20SOG00Enum = rowCINV20SOG00EnumInput; rowCINV20SOG00Enum.hasMoreElements();) {
      CINV20SOG00 rowCINV20SOG00 = (CINV20SOG00) rowCINV20SOG00Enum.nextElement();

      int idEvent = rowCINV20SOG00.getUlIdEvent();
      String cdEventStatus = CodesTables.CEVTSTAT_APRV;
      // ccmn62dAUDdam
      int rowsUpdated = eventDAO.updateEventByIdEvent(idEvent, cdEventStatus);
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
  }

  private void updateEventByIdStageCdEventType(int idStage) throws ServiceException {

    String cdEventStatus = CodesTables.CEVTSTAT_COMP;
    String cdEventType = CodesTables.CEVNTTYP_PLN;
    // csvc27dAUDdam
    eventDAO.updateEventByIdStageCdEventType(cdEventStatus, idStage, cdEventType);

  }

  private void updateEventClosingStatus(int idStage, String cdStage, String szCdEventStatus1, CSVC16SO csvc16so)
                                                                                                                throws ServiceException {
    int usEventCtr = 0;

    // SIR 1967 - Added declaration of input/output structures for DAM
    // CCMN56D, a boolean flag andnd another counter
    //
    int uCount = 0;
    boolean bFound = false;
    // SIR 1967 - Added memory allocation for CCMN56D input/output
    // structures
    String cdEventStatus = szCdEventStatus1;
    // csvc28dQUERYdam
    List<Event> eventList = eventDAO.findEventByIdStageAndCdEventStatus(idStage, cdEventStatus);

    if (eventList == null || eventList.isEmpty()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    // When Closing a stage or Submitting a
    // Closure for Approval, all the IN PROGRESS "PROC"
    // events should also be updated to approved "APRV" for
    // closing and pending "PEND" for submitting.
    // Added a second call to DAM CSVC28D pasing event
    // status of IN PROGRESS instead of COMPLETE.
    // Added row counter and Addition statement, to append
    // the PROC event list to the COMP event list within
    // the CALLCSVC28D function.
    //

    usEventCtr = 0;

    if (0 == CodesTables.CEVTSTAT_PROC.compareTo(szCdEventStatus1)) {
      usEventCtr = csvc16so.getArchOutputStruct().getUlRowQty();
      csvc16so.getArchOutputStruct().setUlRowQty(eventList.size() + csvc16so.getArchOutputStruct().getUlRowQty());
    } else {
      csvc16so.getArchOutputStruct().setUlRowQty(eventList.size());
    }

    // Populate Output Message if event list requested
    // "i" is the index used to access all of the rows returned.
    // It increments through each iteration of the loop.
    // "usEventCtr" is the index used to access all the rows to be
    // returned from the service to the window. It increments only
    // when an ID EVENT is added to the output message.
    // "pCSVC28DOutputRec->ArchOutputStruct.ulRowQty" is the number
    // of rows returned.
    // "pOutputMsg->ArchOutputStruct.ulRowQty" is the number of rows
    // returned from the service to the window. It is set in the
    // if-statement above, but is decremented in the if-statement
    // below when necessary.
    for (Iterator<Event> it = eventList.iterator(); it.hasNext()
                                                    && (usEventCtr < csvc16so.getArchOutputStruct().getUlRowQty());) {
      Event event = it.next();
      cdEventStatus = event.getCdEventStatus();
      if ((0 == cdStage.compareTo(CodesTables.CSTAGES_FPR))
          && (0 == event.getCdEventType().compareTo(CodesTables.CEVNTTYP_APP))
          && (0 == szCdEventStatus1.compareTo(CodesTables.CEVTSTAT_COMP))) {
        int idApproval = event.getIdEvent();
        List<Map> mapList = findAllApproversForGivenApproval(idApproval);

        // Cycle through all rows returned from CCMN56D looking
        // for an approver status of rejected or invalid. If
        // one is found, add that event to the service output
        // message, otherwise decrement the number of rows
        // being returned.
        while ((!bFound) && (null != mapList.get(uCount).get("cdApproversStatus")) && (uCount < mapList.size())) {
          String cdApproversStatus = (String) mapList.get(uCount).get("cdApproversStatus");
          if ((0 == CodesTables.CAPPDESG_REJT.compareTo(cdApproversStatus))
              || (0 == CodesTables.CAPPDESG_INVD.compareTo(cdApproversStatus))) {
            bFound = true;
          }
          uCount++;
        }
        if (bFound) {
          csvc16so.getCINV20SOG00_ARRAY().getCINV20SOG00(usEventCtr++)
                  .setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
        } else {
          csvc16so.getArchOutputStruct().setUlRowQty(csvc16so.getArchOutputStruct().getUlRowQty() - 1);
        }
      } else if (!(((CodesTables.CEVNTTYP_AUT.equals(event.getCdEventType()) && ((0 == cdEventStatus
                                                                                                    .compareTo(CodesTables.CEVTSTAT_PROC))
                                                                                 || (0 == cdEventStatus
                                                                                                       .compareTo(CodesTables.CEVTSTAT_NEW)) || (0 == cdEventStatus
                                                                                                                                                                   .compareTo(CodesTables.CEVTSTAT_COMP)))) || (0 == event
                                                                                                                                                                                                                          .getCdTask()
                                                                                                                                                                                                                          .compareTo(
                                                                                                                                                                                                                                     SVC_AUTH_APPROVAL_TASK))))) {

        csvc16so.getCINV20SOG00_ARRAY().getCINV20SOG00(usEventCtr++)
                .setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
      } else {
        csvc16so.getArchOutputStruct().setUlRowQty(csvc16so.getArchOutputStruct().getUlRowQty() - 1);
      }
    }
  }

  private List<Map> findAllApproversForGivenApproval(int idApproval) throws ServiceException {

    // ccmn56dQUERYdam

    List<Map> mapList = approversDAO.findAllApproversForGivenApproval(idApproval);

    if (mapList == null || mapList.isEmpty()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    return mapList;
  }

  private int callServiceAuth(int idStage, String cdStage, String cdStageType) throws ServiceException {
    int result = 0;
    boolean futureEndDate = false;

    int i = 0;

    int ulIdSvcAuth = 0;

    boolean bPassedSvcAuthEdit = true;
    boolean bPassedPupSvcAuth = true;

    List<Object[]> objectArrayList = findEvents(idStage, cdStage, CodesTables.CEVNTTYP_AUT);

    if (objectArrayList != null && !objectArrayList.isEmpty()) {

      // Loop through all the stages to see if there are any open service auths
      for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
        Object[] objectArray = it.next();
        String cdEventStatus = (String) objectArray[0];
        i = 0;

        // only do this for service auth events
        if ((CodesTables.CEVTSTAT_COMP.equals(cdEventStatus)) || (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))
            || (CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)) || (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus))) {

          // ccmn39d dam
          if (!bPassedSvcAuthEdit) {
            break;
          }

          ulIdSvcAuth = findServiceAuthEventLink((Integer)objectArray[6]);

          List<SvcAuthDetail> svcAuthDetailList = findServiceAuthDetailPersonByIdSvcAuth(ulIdSvcAuth);
          if (svcAuthDetailList != null && !svcAuthDetailList.isEmpty()) {
            for (Iterator<SvcAuthDetail> iterator = svcAuthDetailList.iterator(); iterator.hasNext();) {
              SvcAuthDetail svcAuthDetail = iterator.next();
              // Check the Term Date to make sure it
              // isn't greater than the current date.
              futureEndDate = DateHelper.isAfterToday(svcAuthDetail.getDtSvcAuthDtlTerm());
              if (futureEndDate) {
                bPassedSvcAuthEdit = false;
                if (PUP_SERVICE.equals(svcAuthDetail.getCdSvcAuthDtlSvc().substring(0,3))){
                  bPassedPupSvcAuth = false;
                }
              }
              if (!bPassedSvcAuthEdit && !bPassedPupSvcAuth){
                break;
              }
            }
          }
        }
        i++;
      }
    }

    if (!bPassedSvcAuthEdit) {
      result = Messages.MSG_SVA_OPN_AUTHS;
    }
    if (!bPassedPupSvcAuth) {
      result = Messages.MSG_PUP_CLOSE;
    }
    return result;
  }

  private List<SvcAuthDetail> findServiceAuthDetailPersonByIdSvcAuth(int idSvcAuth) {
    // Call CAUD17D. The Contract Service AUD performs a full row * insert to the Contract Service table.
    // clss24dQUERYdam

    List<SvcAuthDetail> svcAuthDetailList = svcAuthDetailDAO.findServiceAuthDetailPersonByIdSvcAuth(idSvcAuth);
    return svcAuthDetailList;
  }

  private int findServiceAuthEventLink(int idEvent) {
    // cses24dQUERYdam
    SvcAuthEventLink svcAuthEventLink = svcAuthEventLinkDAO.findSvcAuthEventLinkByEventId(idEvent);

    int result = 0;
    if (svcAuthEventLink != null) {
      result = svcAuthEventLink.getServiceAuthorization().getIdSvcAuth();
    }
    return result;
  }

  private List<Object[]> findEvents(int idStage, String cdStage, String szCdEventType)
                                                                                                       throws ServiceException {

    String[] eventArray = new String[1];
    eventArray[0] = szCdEventType;
    int idCase = 0;
    if (CodesTables.CEVNTTYP_REM.equals(szCdEventType) || CodesTables.CEVNTTYP_AUT.equals(szCdEventType)) {
      // ccmnb6dQUERYdam
      idCase = stageDAO.findStageIdCaseByIdStage(idStage);
    }
    // ccmn87dQUERYdam
    List<Object[]> objectArrayList = dynamicEventDAO.findEvents(false, idCase, idStage, 0, 0, 0, eventArray, null,
                                                                null, null, null, null);

    return objectArrayList;
  }

  /**
   * The hasOpenSafetyResourcePlacements method tests to see if there are open Safety
   * Resource placements.  This method checks via case, which is different than how CPS
   * Inv Concl checks because a SR may still be open from the previous Inv Stage.
   * 
   * @param idStage -
   *                Stage ID of the Investigation
   * @return boolean
   */
  private boolean hasOpenSafetyResourcePlacements(int idCase) {

    boolean openPlacements = true;
    List<SafetyResourceChild> safetyResourceList = safetyResourceChildDAO.findOpenSafetyResourcesForCase(idCase);
    if (safetyResourceList == null || safetyResourceList.isEmpty()) {
      openPlacements = false;
    }
    return openPlacements;
  }  
  
  /**
   * 
   * This method will check if there exists any open Safety Resource Events i.e events in 'PROC',
   * 'PEND' status 
   * @param idCase
   * @return
   */  
  //SMS#38635 Look for SafetyResource Events that are in PROC and PEND. 
  //The error message of MSG_ONG_SAFETY_RES_EVENT should NOT be thrown for events in 'COMP' Status.
  private boolean hasOpenSafetyResourceEvent(int idCase){
    boolean safetyResourceEvent = true;
    List<String> cdEventStatuses = new ArrayList<String>();
    cdEventStatuses.add(CodesTables.CEVTSTAT_PROC);
    cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);   
    List<Event> eventList = eventDAO.findEventByIdCaseAndCdEventTypeDesc(idCase, CodesTables.CEVNTTYP_SRP, cdEventStatuses) ;
    if(eventList == null || eventList.isEmpty()){
      safetyResourceEvent = false;
    }    
    return safetyResourceEvent;
  }
  
  /**
   * 
   * This method will check if there are any Child Death/Near Fatality/Serious Injury reported events that are not
   * approved
   * 
   * @param idStage
   * @return boolean
   */
  private boolean existsUnapprovedCNSByIdStage(int idStage) {
    List<String> cdEventStatuses = new ArrayList<String>();
    cdEventStatuses.add(CodesTables.CEVTSTAT_PROC);
    cdEventStatuses.add(CodesTables.CEVTSTAT_COMP);
    cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);

    long nbrRows = eventDAO.countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses(idStage, CodesTables.CEVNTTYP_CNS,
                                                                                    cdEventStatuses);

    if (nbrRows <= 0) {
      // all CNS event are approved or none exists
      return false;
    }

    return true;
  }
  
}
