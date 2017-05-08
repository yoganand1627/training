package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   09/23/09    wcochran          STGAP00014982: Changed how db objects are instantiated wherever
 *                                 possible. i.e. Person p = new Person() becomes Person p =
 *                                 getPersistentObject(Person.class, idPerson) whenever idPerson
 *                                 is available.
 *  10/04/09     bgehlot           STGAP00015485: MR-056 Added cdPKHouseholdMember in method insertStagePersonLinkWihoutIndNmStage and
 *                                 updateStagePersonLinkWithoutIndNmStage
 *  11/12/09     cwells           38663: making sure cfad01dListMap has data before pulling information from it to prevent index out of bounds error.                            
 *
 *  12/15/09     cwells           38677- copying side of family infromation when creating a new stage. 
 *  05/24/2010   arege            SMS#42496:Check if any of the events are in PEND status in FAD
 *  03/18/2011   hnguyen          SMS#97850: MR-075 Added logic to return SO with newly created event id.
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriodId;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.ContractVersion;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveFAHomeCloseReopen;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdRsrcFaHomeStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD36SO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SaveFAHomeCloseReopenImpl extends BaseServiceImpl implements SaveFAHomeCloseReopen {

  private CapsCaseDAO capsCaseDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ContractDAO contractDAO = null;

  private ContractCountyDAO contractCountyDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  private ContractServiceDAO contractServiceDAO = null;

  private ContractVersionDAO contractVersionDAO = null;

  private CloseStageCase closeStageCase = null;
  
  private EventDAO eventDAO = null;

  private InvalidateApproval invalidateApproval = null;
  
  private PlacementDAO placementDAO = null;

  private PostEvent postEvent = null;
  
  private LegalActionDAO legalActionDAO = null;

  private RecordsRetentionDAO recordsRetentionDAO = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  private SituationDAO situationDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setRecordsRetentionDAO(RecordsRetentionDAO recordsRetentionDAO) {
    this.recordsRetentionDAO = recordsRetentionDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  @SuppressWarnings("unchecked")
  public CFAD36SO saveFAHomeCloseReopen(CFAD36SI cfad36si) throws ServiceException {
    CFAD36SO cfad36so = new CFAD36SO();
    boolean bIndFosterContractExists = false;
    boolean bIndAdoptContractExists = false;
    boolean bIndUpdateFosterContract = false;
    boolean bIndUpdateAdoptContract = false;
    ROWCCMN01UIG00_ARRAY rowCcmn01Uig00Array = cfad36si.getROWCCMN01UIG00_ARRAY();
    ROWCCMN01UIG00 rowCcmn01Uig00Next = rowCcmn01Uig00Array.getROWCCMN01UIG00(NEXT);
    int cfad36siIdStageNext = rowCcmn01Uig00Next.getUlIdStage();
    ROWCCMN01UIG00 rowCcmn01Uig00Current = rowCcmn01Uig00Array.getROWCCMN01UIG00(CURRENT);
    int ccmn01IdEventCurrent = rowCcmn01Uig00Current.getUlIdEvent();
    String cfad36siCdRsrcFaHomeStatusNext = cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(NEXT);
    int cfad36siIdResource = cfad36si.getUlIdResource();
    int cfad36siIdCntrctWkr = cfad36si.getUlIdCntrctWkr();
    
    if (HOME_STATUS_PENDING_CLOSURE.equals(cfad36siCdRsrcFaHomeStatusNext)) {
      // SMS#42496:Check if any of the events are in PEND status in FAD
      List<String> cdEventStatuses = new ArrayList<String>();
      cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);
      List<Event> pendingEvents = eventDAO.findEventByIdCaseAndCdEventStatus(cfad36si.getUlIdCase(), cdEventStatuses);
      if (pendingEvents != null && !pendingEvents.isEmpty()) {
        for (Iterator it = pendingEvents.iterator(); it.hasNext();) {
          Event pendingEvent = (Event) it.next();
          String eventType = pendingEvent.getCdEventType();
          if (!CodesTables.CEVNTTYP_CCL.equals(eventType)) { // Need to check for if it is not CCL event type as the
                                                              // code
            throw new ServiceException(Messages.MSG_CONFIRM_STAGE_EVENTS_DELETE);// Change with with "Cannot close
                                                                                  // stage with one or more events in
                                                                                  // PEND status
          }
        }
      }
    }

    if ((HOME_STATUS_CLOSED.equals(cfad36siCdRsrcFaHomeStatusNext))
        || (HOME_STATUS_PENDING_CLOSURE.equals(cfad36siCdRsrcFaHomeStatusNext))) {

      CCMN06UI ccmn06ui = new CCMN06UI();
      ArchInputStruct cfad36siArchInputStruct = cfad36si.getArchInputStruct();
      cfad36siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setArchInputStruct(cfad36siArchInputStruct);
      ccmn06ui.setUlIdStage(cfad36siIdStageNext);
      ccmn06ui.setSzCdTask(rowCcmn01Uig00Next.getSzCdTask());
      checkStageEventStatus.status(ccmn06ui);

      if (EVENT_STATUS_PEND.equals(rowCcmn01Uig00Current.getSzCdEventStatus())) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        cfad36siArchInputStruct = cfad36si.getArchInputStruct();
        ccmn05ui.setArchInputStruct(cfad36siArchInputStruct);
        ccmn05ui.setUlIdEvent(ccmn01IdEventCurrent);
        invalidateApproval.invalidateApproval(ccmn05ui);

        CCMN01UI ccmn01ui = new CCMN01UI();
        cfad36siArchInputStruct = cfad36si.getArchInputStruct();
        cfad36siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        ccmn01ui.setArchInputStruct(cfad36siArchInputStruct);
        ccmn01ui.setROWCCMN01UIG00(rowCcmn01Uig00Current);

        if (ArchitectureConstants.N.equals(cfad36siArchInputStruct.getUlSysNbrReserved1())) {
          ccmn01ui.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMP);
        }

        CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
        int ccmn01uoIdEvent = ccmn01uo.getUlIdEvent();
        cfad36so.setUlIdEvent(ccmn01uoIdEvent);
      }

      if ((ArchitectureConstants.N.equals(cfad36siArchInputStruct.getUlSysNbrReserved1()))) {
        CCMN01UI ccmn01ui = new CCMN01UI();
        cfad36siArchInputStruct = cfad36si.getArchInputStruct();
        ROWCCMN01UIG00 rowCcmn01Uig00Ccmn01ui = rowCcmn01Uig00Next;

        // MR-075 Regardless, next status is Closed or Pending Closure
        // therefore we are creating a new event.
        cfad36siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        rowCcmn01Uig00Ccmn01ui.setUlIdEvent(0);
        rowCcmn01Uig00Ccmn01ui.setTsLastUpdate(rowCcmn01Uig00Current.getTsLastUpdate());

        ccmn01ui.setArchInputStruct(cfad36siArchInputStruct);
        ccmn01ui.setROWCCMN01UIG00(rowCcmn01Uig00Ccmn01ui);
        ccmn01ui.getROWCCMN01UIG00().setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

        int ccmn01uoIdEvent = ccmn01uo.getUlIdEvent();
        rowCcmn01Uig00Next.setUlIdEvent(ccmn01uoIdEvent);
        cfad36so.setUlIdEvent(ccmn01uoIdEvent);

        // caud70dAUDdam
        //MR-075 At this point next status is Closed or Pending Closure so set hold placements to Y.
        int caud70dRowsUpdated = complexCapsResourceDAO.updateCapsResource(cfad36siIdResource,
                                                                           cfad36siCdRsrcFaHomeStatusNext,
                                                                           cfad36si.getSzCdRsrcClosureRsn(),
                                                                           cfad36si.getSzCdRsrcInvolClosure(),
                                                                           cfad36si.getSzCdRsrcRecmndReopen(),
                                                                           cfad36si.getSzTxtStatusRsnComments(),
                                                                           rowCcmn01Uig00Next.getUlIdEvent(),
                                                                           ArchitectureConstants.Y,
                                                                           null,
                                                                           cfad36si.getTsLastUpdate_ARRAY()
                                                                                   .getTsLastUpdate()[RESOURCE],
                                                                           cfad36siIdStageNext,
                                                                           ServiceConstants.FND_YES);

        if (caud70dRowsUpdated == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        SzCdRsrcFaHomeStatus_ARRAY cfad36siCdRsrcFaHomeStatusArray = cfad36si.getSzCdRsrcFaHomeStatus_ARRAY();
        String cfad36siCdRsrcFaHomeStatusCurrent = cfad36siCdRsrcFaHomeStatusArray.getSzCdRsrcFaHomeStatus(CURRENT);
        
       //STGAP00006734 added applicant status to ensure proper closure
        if (HOME_STATUS_INQUIRY.equals(cfad36siCdRsrcFaHomeStatusCurrent) || 
        		HOME_STATUS_APPLICANT.equals(cfad36siCdRsrcFaHomeStatusCurrent)) {

          CCMN02UI ccmn02ui = new CCMN02UI();
          ccmn02ui.setArchInputStruct(cfad36si.getArchInputStruct());
          CCMN02UIG00 ccmn02Uig00 = new CCMN02UIG00();
          ccmn02Uig00.setUlIdStage(cfad36siIdStageNext);
          ccmn02Uig00.setSzCdStage(STAGE_CD_FAD);
          ccmn02Uig00.setSzCdStageProgram(CAPS_PROG_CPS);
          ccmn02Uig00.setSzCdStageReasonClosed(cfad36si.getSzCdRsrcClosureRsn());
          ccmn02ui.setCCMN02UIG00(ccmn02Uig00);
          closeStageCase.closeStageCase(ccmn02ui);
        }
      }
    } else {

      // update the row with the person logged in
      // if the person who was originally assigned is no longer
      // an active employee

      // The employee has been switched from OUT to "IN" status for
      // this unit. (szCdUnitMemberInOut = IN the current assignment,
      // while szScrCdUnitMemberInOut = OUT (the original))
      // Delete all other occurences (other units) where this
      // employee is "IN". An employee can only be IN-assigned to
      // one unit.

      // PWO 1080:
      // Restored the call to the CallCCMNF4D function.
      // BEGIN PWO 416 -- Ensure that Unit Approvers who are
      // "IN"-assigned to this unit are no longer referenced as the
      // approver on the original unit.

      // cmsc17dAUDdam
      int cmsc17dRowsUpdated = situationDAO.updateSituation(null, cfad36si.getUlIdSituation());

      if (cmsc17dRowsUpdated == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      int cfad36siIdCase = cfad36si.getUlIdCase();

      // cmsc18dAUDdam
      int cmsc18dRowsUpdated = capsCaseDAO.updateCapsCaseDtCaseClosed(null, cfad36siIdCase);

      if (cmsc18dRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      }

      // caud47dAUDdam
      int caud47dRowsUpdated = stageDAO.updateStage(null, null, null,
                                                    cfad36si.getTsLastUpdate_ARRAY().getTsLastUpdate(STAGE),
                                                    cfad36siIdStageNext);

      if (caud47dRowsUpdated == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      // cauda0dQUERYdam
      Map cauda0dStagePersonLinkMap = stagePersonLinkDAO.findStagePersonLinkByIdStageAndRole(cfad36siIdStageNext);
      int cauda0dIdStagePersonLink = 0;
      int cauda0dIdPerson = 0;
      Date cauda0dDtEmpTermination = (Date) cauda0dStagePersonLinkMap.get("dtEmpTermination");
      String cReqFuncCd = null;

      if (cauda0dStagePersonLinkMap == null) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
        cauda0dIdPerson = cfad36si.getUlIdPerson();
      }
      // If years are equal and month is greater
      else if (DateHelper.isNull(cauda0dDtEmpTermination)) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
        cauda0dIdStagePersonLink = (Integer) cauda0dStagePersonLinkMap.get("idStagePersonLink");
        cauda0dIdPerson = (Integer) cauda0dStagePersonLinkMap.get("idPerson");
      }
      // If years and months are equal and day is greater
      else {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
        cauda0dIdStagePersonLink = (Integer) cauda0dStagePersonLinkMap.get("idStagePersonLink");
        cauda0dIdPerson = cfad36si.getUlIdPerson();
      }

      // ccmnd3dAUDdam
      int ccmnd3dRowsUpdated = 0;
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        
        String  sCdStagePersRole= null;
        if (HOME_STATUS_CLOSED.equals(cfad36siCdRsrcFaHomeStatusNext)) {
           sCdStagePersRole = HISTORICAL_PRIM_WKR;
        }else
        {
          sCdStagePersRole = PRIM_WORKER;
        }
        
        ccmnd3dRowsUpdated = stagePersonLinkDAO.updateStagePersonLinkWithoutIndNmStage(cauda0dIdPerson, sCdStagePersRole,
                                                                                       PRS_WORKER, null, null,
                                                                                       new Date(), null, null, null,
                                                                                       EMP_IS_NEW,
                                                                                       cauda0dIdStagePersonLink,null,null);
      } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
       
        
        ccmnd3dRowsUpdated = stagePersonLinkDAO.insertStagePersonLinkWihoutIndNmStage(cfad36siIdStageNext,
                                                                                      cauda0dIdPerson, PRIM_WORKER,
                                                                                      PRS_WORKER, null, null,
                                                                                      new Date(), null, null, null,
                                                                                      EMP_IS_NEW,null,null);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

      if (ccmnd3dRowsUpdated == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      // caudc3dAUDdam
      int caudc3dRowsUpdated = stageDAO.updateStageIdUnitByIdStageAndUnitEmpLinkIdUnit(cfad36siIdStageNext,
                                                                                       cauda0dIdPerson);

      if (caudc3dRowsUpdated == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      CCMN01UI ccmn01ui = new CCMN01UI();
      ArchInputStruct cfad36siArchInputStruct = cfad36si.getArchInputStruct();
      cfad36siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ccmn01ui.setArchInputStruct(cfad36siArchInputStruct);
      ccmn01ui.setROWCCMN01UIG00(rowCcmn01Uig00Next);
      ccmn01ui.getROWCCMN01UIG00().setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
      rowCcmn01Uig00Current.setUlIdEvent(ccmn01uo.getUlIdEvent());

      // The assumption is that there must be at least one
      // person involved with the Risk Assessment. If no
      // Principals were found then send back an error.

      // All performance functions always
      // return success so there is no need to check status.
      // caud70dAUDdam
      
      //MR-075 At this point next status is Inquiry so set hold placements to Y.
      int caud70dRowsUpdated = complexCapsResourceDAO.updateCapsResource(cfad36siIdResource,
                                                                         cfad36siCdRsrcFaHomeStatusNext,
                                                                         cfad36si.getSzCdRsrcClosureRsn(),
                                                                         cfad36si.getSzCdRsrcInvolClosure(),
                                                                         cfad36si.getSzCdRsrcRecmndReopen(),
                                                                         cfad36si.getSzTxtStatusRsnComments(),
                                                                         ccmn01IdEventCurrent, ArchitectureConstants.Y,
                                                                         null,
                                                                         cfad36si.getTsLastUpdate_ARRAY()
                                                                                 .getTsLastUpdate(RESOURCE),
                                                                         cfad36siIdStageNext,
                                                                         ServiceConstants.FND_YES);

      if (caud70dRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }

      // CSES56D and CAUD75D to retrieve an then
      // delete a Records Retention row from the
      // database table when the home is successfully
      // reopened.

      // Call the REC RETN RTRV CSES56D
      // Description - This will retrieve a full
      // row from RECORDS RETENTION table and will take
      // as input ID_CASE

      // cses56dQUERYdam
      RecordsRetention cses56dRecordsRetention = recordsRetentionDAO.findRecordsRetention(cfad36siIdCase);

      if (cses56dRecordsRetention != null) {
        RecordsRetention caud75dRecordsRetention = new RecordsRetention();
        caud75dRecordsRetention.setDtLastUpdate(cses56dRecordsRetention.getDtLastUpdate());
        CapsCase caud75dCapsCase = new CapsCase();
        caud75dCapsCase.setIdCase(cfad36siIdCase);
        caud75dRecordsRetention.setCapsCase(caud75dCapsCase);

        // caud75dAUDdam
        recordsRetentionDAO.deleteRecordsRetention(cfad36siIdCase, cfad36si.getTsLastUpdate_ARRAY()
                                                                           .getTsLastUpdate(RESOURCE));
      }
    }

    // clss67dQUERYdam
    List<Contract> clss67dContractList = contractDAO.findContractByIdResource(cfad36siIdResource);

    // Note: needed for later when trying to populate caud08dAUDdam cdCnctyCounty field.
    // This is initially set to null. This field will possibly be populated when trying to
    // populate the clss68dContractCountyList object. The caud08dAUDdam and clss68dContractCountyList
    // objects are part of different loops requiring us to define and initialize this variable outside
    // the two.
    String cfad36siCdRsrcCnty = cfad36si.getSzCdRsrcCnty();
    String cfad01dCdCncntyCountyRowZero = null;
    List<Map> cfad01dListMap = new ArrayList<Map>();
    int ulContractQty = 0;
    if (clss67dContractList != null && !clss67dContractList.isEmpty()) {
      ulContractQty = clss67dContractList.size();
      Iterator itClss67dContractList = clss67dContractList.iterator();

      // Loop through all contract rows returned from the previous
      while (itClss67dContractList.hasNext()) {
        Contract clss67dContract = (Contract) itClss67dContractList.next();
        Map cfad01dMap = new HashMap();
        int cfad01dIdContract = clss67dContract.getIdContract();
        cfad01dMap.put("cfad01dIdContract", cfad01dIdContract);
        cfad36si.setSzCdCntrctRegion(clss67dContract.getCdCntrctRegion());
        Date cfad01dDtLastUpdate = clss67dContract.getDtLastUpdate();

        // cses80dQUERYdam
        ContractPeriod cses80dContractPeriod = contractPeriodDAO.findContractPeriodByIdContract(cfad01dIdContract);
        

        if (cses80dContractPeriod != null) {
          cfad01dMap.put("cfad01dDtCnperStart", cses80dContractPeriod.getDtCnperStart());
          cfad01dMap.put("cfad01dDtCnperClosure", cses80dContractPeriod.getDtCnperClosure());
          cfad01dMap.put("cfad01dNbrCnperPeriod", cses80dContractPeriod.getId().getNbrCnperPeriod());
          cfad01dMap.put("cfad01dDtLastUpdate2", cses80dContractPeriod.getDtLastUpdate());
          Date cfad01dDtCnperTerm = cses80dContractPeriod.getDtCnperTerm();
          cfad01dMap.put("cfad01dDtCnperTerm", cses80dContractPeriod.getDtCnperTerm());
          Calendar cfad01dDtCnperTermCal = Calendar.getInstance();
          cfad01dDtCnperTermCal.setTime(cfad01dDtCnperTerm);
          int cfad01dDtCnperTermCalYear = cfad01dDtCnperTermCal.get(Calendar.YEAR);
          int cfad01dDtCnperTermCalMonth = cfad01dDtCnperTermCal.get(Calendar.MONTH);
          int cfad01dDtCnperTermCalDay = cfad01dDtCnperTermCal.get(Calendar.DAY_OF_YEAR);

          Date now = new Date();
          Calendar nowCal = Calendar.getInstance();
          nowCal.setTime(now);
          int nowCalYear = nowCal.get(Calendar.YEAR);
          int nowCalMonth = nowCal.get(Calendar.MONTH);
          int nowCalDay = nowCal.get(Calendar.DAY_OF_YEAR);
          boolean testBool = false;
          if (cfad01dDtCnperTermCalYear > nowCalDay) {
            testBool = true;
          }
          // If year, month and day are equal
          else if ((cfad01dDtCnperTermCalYear == nowCalYear) && (cfad01dDtCnperTermCalMonth > nowCalMonth)) {
            testBool = true;
          } else if ((cfad01dDtCnperTermCalYear == nowCalYear) && (cfad01dDtCnperTermCalMonth == nowCalMonth)
                     && (cfad01dDtCnperTermCalDay > nowCalDay)) {
            testBool = true;

          } else if ((cfad01dDtCnperTermCalYear == nowCalYear) && (cfad01dDtCnperTermCalMonth == nowCalMonth)
                     && (cfad01dDtCnperTermCalDay == nowCalDay)) {
            testBool = true;
          } else {
            testBool = false;
          }

          boolean cfad01dIndContractCurrent = false;
          if (testBool) {
            if (!CONTRACT_STATUS_CLOSED.equals(cses80dContractPeriod.getCdCnperStatus())) {
              cfad01dIndContractCurrent = true;
            } else {
              cfad01dIndContractCurrent = false;
            }
          } else {
            cfad01dIndContractCurrent = false;
          }

          cfad01dMap.put("cfad01dIndContractCurrent", cfad01dIndContractCurrent);

          if (cfad01dIndContractCurrent) {

            // cses81dQUERYdam
            ContractVersion cses81dContractVersion = contractVersionDAO
                                                                       .findCurrentContractVersion(
                                                                                                   cfad01dIdContract,
                                                                                                   cses80dContractPeriod
                                                                                                                        .getId()
                                                                                                                        .getNbrCnperPeriod());
            if (cses81dContractVersion == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            cfad01dMap.put("cfad01dNbrCnverVersion", cses81dContractVersion.getNbrCnverVersion());
            cfad01dMap.put("cfad01dIdCnver", cses81dContractVersion.getIdCnver());
            cfad01dMap.put("cfad01dDtCnverCreate", cses81dContractVersion.getDtCnverCreate());
            cfad01dMap.put("cfad01dDtCnverEffective", cses81dContractVersion.getDtCnverEffective());
            cfad01dMap.put("cfad01dDtCnverEnd", cses81dContractVersion.getDtCnverEnd());
            cfad01dMap.put("cfad01dDTLastUpdate3", cses81dContractVersion.getDtLastUpdate());

            // clss13dQUERYdam
            List<ContractService> clss13dContractServiceList = contractServiceDAO
                                                                                 .findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(cfad01dIdContract);

            if (clss13dContractServiceList != null && !clss13dContractServiceList.isEmpty()) {
              Iterator itClss13dContractServiceList = clss13dContractServiceList.iterator();

              // clss68dQUERYdam
              List<ContractCounty> clss68dContractCountyList = contractCountyDAO
                                                                                .findContractCountyByIdContactVersionAndPeriod(
                                                                                                                               cfad01dIdContract,
                                                                                                                               cses80dContractPeriod
                                                                                                                                                    .getId()
                                                                                                                                                    .getNbrCnperPeriod(),
                                                                                                                               cses81dContractVersion
                                                                                                                                                     .getNbrCnverVersion());

              if (clss68dContractCountyList == null || clss68dContractCountyList.isEmpty()) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }

              Iterator itClss68dContractCountyList = clss68dContractCountyList.iterator();
              List<Map> contractServiceCountyListMap = new ArrayList();

              while (itClss13dContractServiceList.hasNext() && itClss68dContractCountyList.hasNext()) {
                ContractService clss13dContractService = (ContractService) itClss13dContractServiceList.next();
                Map contractServiceCountyMap = new HashMap();
                contractServiceCountyMap.put("cfad01dDTLastUpdate5", clss13dContractService.getDtLastUpdate());
                contractServiceCountyMap.put("cfad01dNbrCnsvcVersion", clss13dContractService.getNbrCnsvcVersion());
                contractServiceCountyMap.put("cfad01dIdCnsvc", clss13dContractService.getIdCnsvc());
                contractServiceCountyMap.put("cfad01dNbrCnsvcLineItem", clss13dContractService.getNbrCnsvcLineItem());
                contractServiceCountyMap.put("cfad01dNbrCnsvcUnitRate", clss13dContractService.getNbrCnsvcUnitRate());
                contractServiceCountyMap.put("cfad01dNbrCnsvcUnitRate", clss13dContractService.getNbrCnsvcUnitRate());
                contractServiceCountyMap.put("cfad01dAmtCnsvcUnitRateUsed",
                                             clss13dContractService.getAmtCnsvcUnitRateUsed());
                contractServiceCountyMap.put("cfad01dNbrCnsvcUnitType", clss13dContractService.getCdCnsvcUnitType());
                contractServiceCountyMap.put("cfad01dCdCnsvcService", clss13dContractService.getCdCnsvcService());
                String cfad01dCdCnsvcService = clss13dContractService.getCdCnsvcService();

                if (Lookup.isValidCode(CodesTables.CFOSSVCD, cfad01dCdCnsvcService)) {
                  bIndFosterContractExists = true;
                  bIndUpdateFosterContract = true;
                }

                if (Lookup.isValidCode(CodesTables.CADOSVCD, cfad01dCdCnsvcService)) {
                  bIndAdoptContractExists = true;
                  bIndUpdateAdoptContract = true;
                }

                ContractCounty clss68dContractCounty = (ContractCounty) itClss68dContractCountyList.next();
                contractServiceCountyMap.put("cfad01dCdCncntyService", clss68dContractCounty.getCdCncntyService());
                contractServiceCountyMap.put("cfad01dDtLastUpdate4", clss68dContractCounty.getDtLastUpdate());
                contractServiceCountyMap.put("cfad01dIdCncnty", clss68dContractCounty.getIdCncnty());
                contractServiceCountyMap.put("cfad01dCdCncntyCounty", clss68dContractCounty.getCdCncntyCounty());
                contractServiceCountyMap.put("cfad01dDtCncntyEffective", clss68dContractCounty.getDtCncntyEffective());
                contractServiceCountyMap.put("cfad01dCdCncntyCounty", clss68dContractCounty.getCdCncntyCounty());
                cfad01dCdCncntyCountyRowZero = clss68dContractCountyList.get(0).getCdCncntyCounty();
                contractServiceCountyMap.put("cfad01dDtCncntyEnd", clss68dContractCounty.getDtCncntyEnd());
                contractServiceCountyMap.put("cfad01dNbrCncntyPeriod", clss68dContractCounty.getNbrCncntyPeriod());
                contractServiceCountyMap.put("cfad01dNbrCncntyVersion", clss68dContractCounty.getNbrCncntyVersion());
                contractServiceCountyMap.put("cfad01dNbrCncntyLineItem", clss68dContractCounty.getNbrCncntyLineItem());
                contractServiceCountyListMap.add(contractServiceCountyMap);
              }
              cfad01dMap.put("cfad01dContractServiceListMap", contractServiceCountyListMap);
            } else if (clss13dContractServiceList == null || clss13dContractServiceList.isEmpty()) {
              bIndFosterContractExists = false;
              bIndUpdateFosterContract = false;
            }
          }
          cfad01dListMap.add(cfad01dMap);
        }
      }

      String cint20dCdStagePersRole = null;
      if (HOME_STATUS_CLOSED.equals(cfad36siCdRsrcFaHomeStatusNext)) {
        cint20dCdStagePersRole = HISTORICAL_PRIM_WKR;
      }

      // if someone with a division number is trying to save - i.e.
      // invalid region - then save the region as the state office
      // region.
      else {
        cint20dCdStagePersRole = PRIM_WORKER;
      }

      // cint20dQUERYdam --TODO
      StagePersonLink cint20dStagePersonLink = stagePersonLinkDAO
                                                                 .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                                        cfad36siIdStageNext,
                                                                                                                        cint20dCdStagePersRole,
                                                                                                                        PERSON_TYPE_WORKER);

      if (cint20dStagePersonLink == null) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

    
      Map cfad01dTempMap = null;
      
      //ignore contract Manager info when reopening a home.
      if (!HOME_STATUS_INQUIRY.equals(cfad36siCdRsrcFaHomeStatusNext)) {
        // add IdCntrctManager to cfad01dListMap.    
        // 38663 making sure cfad01dListMap has data before pulling information from it.      
        if (!cfad01dListMap.isEmpty() && cfad01dListMap != null) {
          cfad01dTempMap = cfad01dListMap.get(0);
          cfad01dTempMap.put("cfad01dIdCntrctManager", cint20dStagePersonLink.getPerson().getIdPerson());
          cfad01dListMap.add(cfad01dTempMap);
        }
      }
      // cres13dQUERYdam
      List<ResourceAddress> cres13dResourceAddressList = resourceAddressDAO
                                                                           .findResourceAddressByIdResource(cfad36siIdResource);

      if (cres13dResourceAddressList == null || cres13dResourceAddressList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      Iterator itCres13dResourceAddressList = cres13dResourceAddressList.iterator();
      int ulTempIdRsrcAddress = 0;
      int ulIdTempContract = 0;
      while (itCres13dResourceAddressList.hasNext()) {
        ResourceAddress cres13dResourceAddress = (ResourceAddress) itCres13dResourceAddressList.next();

        // I am assuming that by the time a home is to be closed a vendor id would've been generated
        if ((RSRC_PRIM_ADDR.equals(cres13dResourceAddress.getCdRsrcAddrType()))
        /* && (cres13dResourceAddress.getNbrRsrcAddrVid() != null) */) {
          ulTempIdRsrcAddress = cres13dResourceAddress.getIdRsrcAddress();
          cfad36si.setSzCdRsrcCnty(cres13dResourceAddress.getCdRsrcAddrCounty());
        }
      }

      if (cfad36siCdRsrcCnty == null || "".equals(cfad36siCdRsrcCnty)) {
          cfad36siCdRsrcCnty = cfad36si.getSzCdRsrcCnty();
      }
      
      int usCreateContract = 0;
      if ((ArchitectureConstants.Y.equals(cfad36si.getBIndRsrcNonPrs()))
          && (!(HOME_STATUS_CLOSED.equals(cfad36siCdRsrcFaHomeStatusNext)
              || HOME_STATUS_PENDING_CLOSURE.equals(cfad36siCdRsrcFaHomeStatusNext)))) {
        // Only create new contracts if one does not exist for foster or adoptive
        // contracts.

        while ((!bIndAdoptContractExists) && (!bIndFosterContractExists)) {
          if (ADOPTIVE_STATUS.equals(cfad36si.getSzCdRsrcStatus())) {
            bIndAdoptContractExists = true;
            usCreateContract = ADOPTIVE;
          } else if (FOSTER_STATUS.equals(cfad36si.getSzCdRsrcStatus())) {
            bIndFosterContractExists = true;
            usCreateContract = FOSTER;
          }

          if (COUNTY_CD_OUT_OF_STATE.equals(cfad36siCdRsrcCnty)) {

            // ccmn39dQUERYdam
            UnitEmpLink ccmn39dUnitEmpLink = unitEmpLinkDAO
                                                           .findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(
                                                                                                                      cint20dStagePersonLink
                                                                                                                                            .getPerson()
                                                                                                                                            .getIdPerson(),
                                                                                                                      UNIT_MEMBER_IN_ASSIGNED);
            if (ccmn39dUnitEmpLink == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            Unit ccmn39dUnitEmpLinkUnit = ccmn39dUnitEmpLink.getUnit();
            if ("0".equals(ccmn39dUnitEmpLinkUnit.getCdUnitRegion())) {
              cfad36si.setSzCdRsrcRegion(ccmn39dUnitEmpLinkUnit.getCdUnitRegion());
            } else {
              cfad36si.setSzCdRsrcRegion(CAPS_UNIT_STATE_OFFICE);
            }
          } else {
            // cses82dQUERYdam
        	String szCdRsrcRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cfad36siCdRsrcCnty);
            cfad36si.setSzCdRsrcRegion(szCdRsrcRegion);
          }

          // caud01dAUDdam - save Contract and return new object
          Contract caud01dContract = saveContract(cfad36siIdResource, cfad36si.getSzCdRsrcRegion(),
                                                  ulTempIdRsrcAddress,
                                                  cint20dStagePersonLink.getPerson().getIdPerson(), cfad36siIdCntrctWkr);

          ulIdTempContract = caud01dContract.getIdContract();

          Date now = new Date();
          Calendar nowCal = Calendar.getInstance();
          nowCal.setTime(now);
          nowCal.add(Calendar.YEAR, 100);
          Date nowPlus100Years = nowCal.getTime();

          // caud20dAUDdam
          saveContractPeriod(caud01dContract, cfad36siIdCntrctWkr, nowPlus100Years);

          // caud15dAUDdam
          saveContractVersion(ulIdTempContract, cfad36siIdCntrctWkr, now, nowPlus100Years);
        }

        int usCountyRow = 0;
        if (FOSTER == usCreateContract) {
          // caud17dAUDdam
          saveContractServiceFoster(usCountyRow, ulIdTempContract, cfad36siIdCntrctWkr);
        }

        if (ADOPTIVE == usCreateContract) {
          // caud17dAUDdam
          saveContractServiceAdoptive(cfad36siIdCntrctWkr, ulIdTempContract);
        }

        usCountyRow = 0;
        int ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_A;
        boolean bFoster = true;
        String szAdoptiveOrFoster = null;
        String szCategoryType = null;
        boolean bGroupHome = false;
        if (FOSTER == usCreateContract) {
          // this wants to return/update 2 objects ?????
          updateAdoptiveOrFosterAndCategoryType(cfad36siIdResource, szAdoptiveOrFoster, szCategoryType);

          if (FA_CATG_ADOPT.equals(szCategoryType)) {
            bFoster = false;
          }

          if (szAdoptiveOrFoster == null || StringHelper.EMPTY_STRING.equals(szAdoptiveOrFoster.substring(0))) {
            ulAdoptiveOrFoster = 0;
          } else {
            // loop through the rows to see if any of them
            // are group homes, if they are set an indicator
            for (usCountyRow = 0; usCountyRow < NBR_OF_HOME_TYPE; usCountyRow++) {
              if (FOST_TYPE_GROUP.equals(szAdoptiveOrFoster.substring(usCountyRow))) {
                bGroupHome = true;
                break;
              }
            }

            for (usCountyRow = 0; usCountyRow < NBR_OF_HOME_TYPE; usCountyRow++) {
              if ((FOST_TYPE_HABIL.equals(szAdoptiveOrFoster.substring(usCountyRow)))
                  || (FOST_TYPE_THER.equals(szAdoptiveOrFoster.substring(usCountyRow)))
                  || (FOST_TYPE_PRIM_MED.equals(szAdoptiveOrFoster.substring(usCountyRow)))) {
                if (!bGroupHome) {
                  ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABCD;
                  break;
                } else {
                  ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABC;
                  break;
                }
              }
            }
          }

        } else if (ADOPTIVE == usCreateContract) {
          ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_AB;
        } else {
          ulAdoptiveOrFoster = 0;
        }

        // Add 100 years to current date.
        Date dtToday = new Date();
        Calendar dtTodayCal = Calendar.getInstance();
        dtTodayCal.setTime(dtToday);
        dtTodayCal.add(Calendar.YEAR, 100);
        Date dtTodayPlus100Years = dtTodayCal.getTime();

        // caud08dAUDdam - add
        saveContractCountyFoster(usCountyRow, cfad36siIdCntrctWkr, dtTodayPlus100Years, ulIdTempContract,
                                 cfad36siIdResource, cfad01dCdCncntyCountyRowZero, dtToday, ulAdoptiveOrFoster,
                                 usCreateContract, bFoster);
      }
    }

    // If the CallCCMN36D function returns SQL_NOT_FOUND,
    // we cannot re-assign this employee to another unit.
    // If the current IdPerson that we are processing is
    // the same IdPerson in pInputMsg->ROWCCMN22SIG01
    // (that is the Unit Approver for this unit),
    // then in addition to not re-assigning the current
    // IdPerson, we should not continue processing the
    // remaining employees in the pInputMsg. Return the
    // MSG_CMN_TMSTAMP_MISMATCH message to the user.
    // else
    // we may continue with the remaining employees
    // in the pInputMsg. The if statement following this
    // switch statement (if (rc == ARC_SUCCESS)) contains
    // all remaining processing on the employee within this
    // for loop. With rc set to SQL_NOT_FOUND, we effectively
    // skip to the next employee in the pInputMsg.
    // PWO 1080: Add if statement

    // cfad01dListMap is created and populated earlier in this class from
    // the combination of other objects.
    Iterator itCfad01dListMap = cfad01dListMap.iterator();
    int usUpdateContract = 0;
    if ((ArchitectureConstants.Y.equals(cfad36si.getBIndRsrcNonPrs()))
        && (!(HOME_STATUS_CLOSED.equals(cfad36siCdRsrcFaHomeStatusNext)
            || HOME_STATUS_PENDING_CLOSURE.equals(cfad36siCdRsrcFaHomeStatusNext)))) {

      // Only modify contracts when flags are TRUE
      while (itCfad01dListMap.hasNext() && bIndUpdateAdoptContract == true || bIndUpdateFosterContract == true) {
        Map cfad01dMap = (Map) itCfad01dListMap.next();
        boolean cfad01dIndContractCurrent = (Boolean) cfad01dMap.get("cfad01dIndContractCurrent");
        List<Map> cfad01dContractServiceListMap = (List<Map>) cfad01dMap.get("cfad01dContractServiceListMap");
        Map cfad01dContractServiceMapRowZero = cfad01dContractServiceListMap.get(0);
        String cfad01dCdCnsvcServiceRowZero = (String) cfad01dContractServiceMapRowZero.get("cfad01dCdCnsvcService");

        if (cfad01dIndContractCurrent) {
          if (bIndUpdateAdoptContract == true
              && (CD_SERV_ADP_SUB.equals(cfad01dCdCnsvcServiceRowZero) || CD_SERV_ADP_NON_REC_SUB
                                                                                                 .equals(cfad01dCdCnsvcServiceRowZero))) {
            bIndUpdateAdoptContract = false;
            usUpdateContract = ADOPTIVE;
          } else if (bIndUpdateFosterContract == true
                     && (CD_SERV_FOST_L1.equals(cfad01dCdCnsvcServiceRowZero)
                         || CD_SERV_FOST_L2.equals(cfad01dCdCnsvcServiceRowZero)
                         || CD_SERV_FOST_LEV_BASIC.equals(cfad01dCdCnsvcServiceRowZero)
                         || CD_SERV_FOST_LEV_MOD.equals(cfad01dCdCnsvcServiceRowZero)
                         || CD_SERV_FOST_LEV_SPEC.equals(cfad01dCdCnsvcServiceRowZero) || CD_SERV_FOST_LEV_INT
                                                                                                              .equals(cfad01dCdCnsvcServiceRowZero))) {
            bIndUpdateFosterContract = false;
            usUpdateContract = FOSTER;
          }

          int caud20dIdContract = (Integer) cfad01dMap.get("cfad01dIdContract");
          Date caud20dDtCnperStart = (Date) cfad01dMap.get("cfad01dDtCnperStart");
          Date caud20dDtCnperClosure = (Date) cfad01dMap.get("cfad01dDtCnperClosure");
          int caud20dNbrCnperPeriod = (Integer) cfad01dMap.get("cfad01dNbrCnperPeriod");
          Date caud20dDtLastUpdate = (Date) cfad01dMap.get("cfad01dDtLastUpdate2");
          Date caud20dDtCnperTerm = (Date) cfad01dMap.get("cfad01dDtCnperTerm");

          if (DateHelper.isEqual(caud20dDtCnperClosure,caud20dDtCnperStart)){
            DateHelper.addToDate(caud20dDtCnperClosure,0,0,1);
          }
          if (DateHelper.isEqual(caud20dDtCnperTerm,caud20dDtCnperStart)){
            DateHelper.addToDate(caud20dDtCnperTerm,0,0,1);
          }
          // caud20dAUDdam
          int caud20dRowsUpdated = contractPeriodDAO.updateContractPeriod(cfad36siIdCntrctWkr, CONTRACT_STATUS_ACTIVE,
                                                                          caud20dDtCnperStart, caud20dDtCnperTerm,
                                                                          caud20dDtCnperClosure,
                                                                          ArchitectureConstants.N,
                                                                          ArchitectureConstants.Y, 0,
                                                                          caud20dDtLastUpdate, caud20dIdContract,
                                                                          caud20dNbrCnperPeriod, cfad36si.getTxtLastUpdatedBy());
          if (caud20dRowsUpdated == 0) {
            throw new ServiceException(Messages.MSG_CON_CLOSURE_AFTER_EFF);
          }

          if ((cfad01dIndContractCurrent && (usUpdateContract == FOSTER))) {
            contractVerSerCnty(cfad36siCdRsrcCnty, cfad36siIdResource, caud20dIdContract, caud20dNbrCnperPeriod, cfad36si.getTxtLastUpdatedBy());
          }
        }
      }

      if ((ArchitectureConstants.Y.equals(cfad36si.getBIndRsrcNonPrs()))
          && (HOME_STATUS_CLOSED.equals(cfad36siCdRsrcFaHomeStatusNext))) {

        // cses82dQUERYdam
        String tempRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cfad36siCdRsrcCnty);

        // Only modify contracts where flag is TRUE
        while (itCfad01dListMap.hasNext() && bIndUpdateAdoptContract == true || bIndUpdateFosterContract == true) {
          Map cfad01dMap = (Map) itCfad01dListMap.next();
          boolean cfad01dIndContractCurrent = (Boolean) cfad01dMap.get("cfad01dIndContractCurrent");
          List<Map> cfad01dContractServiceListMap = (List<Map>) cfad01dMap.get("cfad01dContractServiceListMap");
          Map cfad01dContractServiceMapRowZero = cfad01dContractServiceListMap.get(0);
          String cfad01dCdCnsvcServiceRowZero = (String) cfad01dContractServiceMapRowZero.get("cfad01dCdCnsvcService");

          if (cfad01dIndContractCurrent) {
            if (bIndUpdateAdoptContract == true
                && (CD_SERV_ADP_SUB.equals(cfad01dCdCnsvcServiceRowZero) || CD_SERV_ADP_NON_REC_SUB
                                                                                                   .equals(cfad01dCdCnsvcServiceRowZero))) {
              bIndUpdateAdoptContract = false;
              usUpdateContract = ADOPTIVE;
            } else if (bIndUpdateFosterContract == true
                       && (CD_SERV_FOST_L1.equals(cfad01dCdCnsvcServiceRowZero)
                           || CD_SERV_FOST_L2.equals(cfad01dCdCnsvcServiceRowZero)
                           || CD_SERV_FOST_LEV_BASIC.equals(cfad01dCdCnsvcServiceRowZero)
                           || CD_SERV_FOST_LEV_MOD.equals(cfad01dCdCnsvcServiceRowZero)
                           || CD_SERV_FOST_LEV_SPEC.equals(cfad01dCdCnsvcServiceRowZero) || CD_SERV_FOST_LEV_INT
                                                                                                                .equals(cfad01dCdCnsvcServiceRowZero))) {
              bIndUpdateFosterContract = false;
              usUpdateContract = FOSTER;
            }

            int caud20dIdContract = (Integer) cfad01dMap.get("cfad01dIdContract");
            int caud20dNbrCnperPeriod = (Integer) cfad01dMap.get("cfad01dNbrCnperPeriod");

            // Run loop to guarantee all contract
            // services will be checked.
            Date caud20dDtCnperStart = (Date) cfad01dMap.get("cfad01dDtCnperStart");
            Iterator itCfad01dContractServiceListMap = cfad01dContractServiceListMap.iterator();
            String caud20dCdCnperStatus = null;
            Date caud20dDtCnperTerm = null;
            Date caud20dDtCnperClosure = null;

            while (itCfad01dContractServiceListMap.hasNext()) {
              Map cfad01dContractServiceMap = (Map) itCfad01dContractServiceListMap.next();
              String cfad01dCdCnsvcService = (String) cfad01dContractServiceMap.get("cfad01dCdCnsvcService");

              if (!StringHelper.EMPTY_STRING.equals(cfad01dCdCnsvcService)) {
                if ((CD_SERV_FOST_L1.equals(cfad01dCdCnsvcService)) || (CD_SERV_FOST_L2.equals(cfad01dCdCnsvcService))
                    || (CD_SERV_FOST_LEV_BASIC.equals(cfad01dCdCnsvcService))
                    || (CD_SERV_FOST_LEV_MOD.equals(cfad01dCdCnsvcService))
                    || (CD_SERV_FOST_LEV_SPEC.equals(cfad01dCdCnsvcService))
                    || (CD_SERV_FOST_LEV_INT.equals(cfad01dCdCnsvcService))) {

                  caud20dCdCnperStatus = CONTRACT_STATUS_CLOSED;
                  Date dtToday = new Date();

                  if (DateHelper.isToday(caud20dDtCnperStart)) {
                    Calendar dtTodayCal = Calendar.getInstance();
                    dtTodayCal.setTime(dtToday);
                    dtTodayCal.add(Calendar.DAY_OF_YEAR, 1);// add one day
                    dtToday = dtTodayCal.getTime();
                  }

                  caud20dDtCnperTerm = dtToday;
                  caud20dDtCnperClosure = dtToday;
                }

                if ((CD_SERV_ADP_SUB.equals(cfad01dCdCnsvcService))
                    || (CD_SERV_ADP_NON_REC_SUB.equals(cfad01dCdCnsvcService))) {
                  caud20dCdCnperStatus = CONTRACT_STATUS_SERVICE_HOLD;
                  caud20dDtCnperTerm = (Date) cfad01dMap.get("cfad01dDtCnperTerm");
                  caud20dDtCnperClosure = (Date) cfad01dMap.get("cfad01dDtCnperClosure");
                }
              }
            }

            Date caud20dDtLastUpdate = (Date) cfad01dMap.get("cfad01dDtLastUpdate2");

            // caud20dAUDdam
            int caud20dRowsUpdated = contractPeriodDAO.updateContractPeriod(cfad36siIdCntrctWkr, caud20dCdCnperStatus,
                                                                            caud20dDtCnperStart, caud20dDtCnperTerm,
                                                                            caud20dDtCnperClosure,
                                                                            ArchitectureConstants.N,
                                                                            ArchitectureConstants.Y, 0,
                                                                            caud20dDtLastUpdate, caud20dIdContract,
                                                                            caud20dNbrCnperPeriod, cfad36si.getTxtLastUpdatedBy());
            if (caud20dRowsUpdated == 0) {
              throw new ServiceException(Messages.MSG_CON_CLOSURE_AFTER_EFF);
            }

            int caud15dIdCnver = (Integer) cfad01dMap.get("cfad01dIdCnver");
            int caud15dNbrCnverVersion = (Integer) cfad01dMap.get("cfad01dNbrCnverVersion");
            Date caud15dDtCnverCreate = (Date) cfad01dMap.get("cfad01dDtCnverCreate");
            Date caud15dDtLastUpdate = (Date) cfad01dMap.get("cfad01dDtLastUpdate3");
            Date caud15dDtCnverEffective = (Date) cfad01dMap.get("cfad01dDtCnverEffective");

            // Run loop to guarantee all contract
            // services will be checked.

            Date cfad01dDtCnverEnd = null;
            while (itCfad01dContractServiceListMap.hasNext()) {
              Map cfad01dContractServiceMap = (Map) itCfad01dContractServiceListMap.next();
              String cfad01dCdCnsvcService = (String) cfad01dContractServiceMap.get("cfad01dCdCnsvcService");

              if ((CD_SERV_FOST_L1.equals(cfad01dCdCnsvcService)) || (CD_SERV_FOST_L2.equals(cfad01dCdCnsvcService))
                  || (CD_SERV_FOST_LEV_BASIC.equals(cfad01dCdCnsvcService))
                  || (CD_SERV_FOST_LEV_MOD.equals(cfad01dCdCnsvcService))
                  || (CD_SERV_FOST_LEV_SPEC.equals(cfad01dCdCnsvcService))
                  || (CD_SERV_FOST_LEV_INT.equals(cfad01dCdCnsvcService))) {
                cfad01dDtCnverEnd = new Date();
              }

              if ((CD_SERV_ADP_SUB.equals(cfad01dCdCnsvcService))
                  || (CD_SERV_ADP_NON_REC_SUB.equals(cfad01dCdCnsvcService))) {
                cfad01dDtCnverEnd = (Date) cfad01dMap.get("cfad01dDtCnverEnd");
              }
            }

            // caud15dAUDdam
            int caud15dRowsUpdated = contractVersionDAO.updateContractVersion(caud20dIdContract, caud20dNbrCnperPeriod,
                                                                              caud15dNbrCnverVersion,
                                                                              caud15dDtLastUpdate, caud15dIdCnver,
                                                                              cfad36siIdCntrctWkr, 0,
                                                                              ArchitectureConstants.Y, null,
                                                                              caud15dDtCnverCreate, cfad01dDtCnverEnd,
                                                                              caud15dDtCnverEffective, cfad36si.getTxtLastUpdatedBy());
            if (caud15dRowsUpdated == 0) {
              throw new ServiceException(Messages.MSG_DUPLICATE_RECORD);
            }

            // BEGIN CAUD08D CONTRACT COUNTY update. This
            // is added because the contract county end date needs to
            // be upated simulatneously with the contract_period and
            // contract_county tables.

            while (itCfad01dContractServiceListMap.hasNext()) {
              Map cfad01dContractServiceMap = (Map) itCfad01dContractServiceListMap.next();
              String cfad01dCdCnsvcService = null;
              Date caud08dDtCncntyEnd = null;
              int caud08dNbrCncntyPeriod = (Integer) cfad01dContractServiceMap.get("cfad01dNbrCncntyPeriod");
              int caud08dNbrCncntyVersion = (Integer) cfad01dContractServiceMap.get("cfad01dNbrCncntyVersion");
              int caud08dNbrCncntyLineItem = (Integer) cfad01dContractServiceMap.get("cfad01dNbrCncntyLineItem");
              Date caud08dDtLastUpdate = (Date) cfad01dContractServiceMap.get("cfad01dDtLastUpdate4");
              Date caud08dDtCncntyEffective = (Date) cfad01dContractServiceMap.get("cfad01dDtCncntyEffective");
              String caud08dCdCncntyCounty = (String) cfad01dContractServiceMap.get("cfad01dCdCncntyCounty");

              // caud08dAUDdam - update
              updateContractCounty(cfad01dCdCnsvcService, caud08dDtCncntyEnd, cfad36siIdResource, cfad36siIdCntrctWkr,
                                   caud08dNbrCncntyPeriod, caud08dNbrCncntyVersion, caud08dCdCncntyCounty,
                                   caud08dNbrCncntyLineItem, caud08dDtCncntyEffective, caud08dDtLastUpdate, cfad01dMap,
                                   cfad01dContractServiceMap);
            }
          }
        }
      }
    }
    return cfad36so;
  }

  private void updateContractCounty(String cfad01dCdCnsvcService, Date caud08dDtCncntyEnd, int cfad36siIdResource,
                                    int cfad36siIdCntrctWkr, int caud08dNbrCncntyPeriod, int caud08dNbrCncntyVersion,
                                    String caud08dCdCncntyCounty, int caud08dNbrCncntyLineItem,
                                    Date caud08dDtCncntyEffective, Date caud08dDtLastUpdate, Map cfad01dMap,
                                    Map cfad01dContractServiceMap) {

    ContractCounty caud08dContractCounty = new ContractCounty();
    Integer ulIdTempContract = (Integer) cfad01dMap.get("cfad01dIdContract");
    Contract caud08dContract = getPersistentObject(Contract.class, ulIdTempContract);
    caud08dContractCounty.setContract(caud08dContract);
    caud08dContractCounty.setIdCncnty((Integer) cfad01dMap.get("cfad01dIdCncnty"));
    Person caud08dPerson = getPersistentObject(Person.class, cfad36siIdCntrctWkr);
    caud08dContractCounty.setPerson(caud08dPerson);
    CapsResource caud08dCapsResource = getPersistentObject(CapsResource.class, cfad36siIdResource);
    caud08dContractCounty.setCapsResource(caud08dCapsResource);
    caud08dContractCounty.setNbrCncntyPeriod(caud08dNbrCncntyPeriod);
    caud08dContractCounty.setNbrCncntyVersion(caud08dNbrCncntyVersion);
    caud08dContractCounty.setCdCncntyCounty(caud08dCdCncntyCounty);
    caud08dContractCounty.setNbrCncntyLineItem(caud08dNbrCncntyLineItem);
    caud08dContractCounty.setDtCncntyEffective(caud08dDtCncntyEffective);
    caud08dContractCounty.setDtLastUpdate(caud08dDtLastUpdate);

    if ((CD_SERV_FOST_L1.equals(cfad01dCdCnsvcService)) || (CD_SERV_FOST_L2.equals(cfad01dCdCnsvcService))
        || (CD_SERV_FOST_LEV_BASIC.equals(cfad01dCdCnsvcService))
        || (CD_SERV_FOST_LEV_MOD.equals(cfad01dCdCnsvcService))
        || (CD_SERV_FOST_LEV_SPEC.equals(cfad01dCdCnsvcService))
        || (CD_SERV_FOST_LEV_INT.equals(cfad01dCdCnsvcService))) {

      caud08dDtCncntyEnd = new Date();
      cfad01dCdCnsvcService = (String) cfad01dContractServiceMap.get("cfad01dCdCnsvcService");
    }
    if ((CD_SERV_ADP_SUB.equals(cfad01dCdCnsvcService)) || (CD_SERV_ADP_NON_REC_SUB.equals(cfad01dCdCnsvcService))) {
      caud08dDtCncntyEnd = (Date) cfad01dMap.get("cfad01dDtCncntyEnd");
      cfad01dCdCnsvcService = (String) cfad01dContractServiceMap.get("cfad01dCdCnsvcService");
    }

    caud08dContractCounty.setDtCncntyEnd(caud08dDtCncntyEnd);
    caud08dContractCounty.setCdCncntyService(cfad01dCdCnsvcService);

    // caud08dAUDdam - update
    contractCountyDAO.saveContractCounty(caud08dContractCounty);
  }

  private void updateAdoptiveOrFosterAndCategoryType(int idResource, String szAdoptiveOrFoster, String szCategoryType)
                                                                                                                      throws ServiceException {

    // cres04dQUERYdam
    CapsResource cres04dCapsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);

    if (cres04dCapsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // No unit was found that matched the search criteria, so pass
    // back a code to generate the appropriate error message
    String szTempHomeType = cres04dCapsResource.getCdRsrcFaHomeType1() + cres04dCapsResource.getCdRsrcFaHomeType2()
                            + cres04dCapsResource.getCdRsrcFaHomeType3() + cres04dCapsResource.getCdRsrcFaHomeType4()
                            + cres04dCapsResource.getCdRsrcFaHomeType5() + cres04dCapsResource.getCdRsrcFaHomeType6()
                            + cres04dCapsResource.getCdRsrcFaHomeType7();

    szAdoptiveOrFoster = szTempHomeType;
    szCategoryType = cres04dCapsResource.getCdRsrcCategory();
  }

  private void saveContractVersion(int ulIdTempContract, int idCntrctWkr, Date now, Date nowPlus100Years) {
    ContractVersion caud15dContractVersion = new ContractVersion();
    ContractPeriodId caud15dContractPeriodId = new ContractPeriodId();
    caud15dContractPeriodId.setNbrCnperPeriod(1);
    caud15dContractPeriodId.setIdContract(ulIdTempContract);
    ContractPeriod caud15dContractPeriod = getPersistentObject(ContractPeriod.class, caud15dContractPeriodId);
    caud15dContractVersion.setContractPeriod(caud15dContractPeriod);
    Person person = getPersistentObject(Person.class, idCntrctWkr);
    caud15dContractVersion.setPerson(person);
    caud15dContractVersion.setNbrCnverVersion(1);

    caud15dContractVersion.setDtCnverCreate(now);
    caud15dContractVersion.setDtCnverEffective(now);
    caud15dContractVersion.setDtCnverEnd(nowPlus100Years);
    caud15dContractVersion.setIndCnverVerLock(ArchitectureConstants.Y);

    // caud15dAUDdam
    contractVersionDAO.saveContractVersion(caud15dContractVersion);
  }

  private void saveContractCountyFoster(int usCountyRow, int idCntrctWkr, Date dtTodayPlus100Years,
                                        int ulIdTempContract, int idResource, String cdCncntyCounty, Date dtToday,
                                        int ulAdoptiveOrFoster, int usCreateContract, boolean bFoster) {
    ContractCounty caud08dContractCounty = new ContractCounty();
    Person caud08dPerson = getPersistentObject(Person.class, idCntrctWkr);
    caud08dContractCounty.setPerson(caud08dPerson);
    caud08dContractCounty.setDtCncntyEnd(dtTodayPlus100Years);
    Contract caud08dContract = getPersistentObject(Contract.class, ulIdTempContract);
    caud08dContractCounty.setContract(caud08dContract);
    CapsResource caud08dCapsResource = getPersistentObject(CapsResource.class, idResource);
    caud08dContractCounty.setCapsResource(caud08dCapsResource);

    // Note: "cfad01dCdCncntyCountyRowZero" value is set in earlier loop above.
    // The value is initialized as null and possible set when "clss68dContractCountyList"
    // is trying to be populated.
    caud08dContractCounty.setCdCncntyCounty(cdCncntyCounty);
    caud08dContractCounty.setDtCncntyEffective(dtToday);
    caud08dContractCounty.setNbrCncntyPeriod(1);
    caud08dContractCounty.setNbrCncntyVersion(1);

    // Set ulAdoptiveOrFoster based on home type
    // 19613 Basic only has 63A now
    usCountyRow = 0;
    // County AUD processing CAUD08D
    while (usCountyRow < ulAdoptiveOrFoster) {
      String caud08dCdCncntyService = null;
      if (FOSTER == usCreateContract && bFoster) {

        switch (usCountyRow) {
        case 0:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_BASIC;
          break;
        case 1:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_MOD;
          break;
        case 2:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_SPEC;
          break;
        case 3:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_INT;
          break;
        default:
          break;
        }
      }

      // If the employee to be modified has (or is proposed to have)
      // MemberInOut status (in this unit) == IN, then
      // check if the employee is currently the UNIT APPROVER
      // of the unit in which they are currently "IN" assigned.
      // If the employee is the UNIT APPROVER of their current "IN"
      // unit (and that current "IN" unit is not the unit being
      // modified right now), the CallCCMNG5D function will return
      // MSG_CMN_UNIT_APPROVER.
      // If the CallCCMNG5D function returns MSG_CMN_UNIT_APPROVER,
      // then the CallCCMN36D function needs to be called
      // (see further comments within switch after 'rc=CallCCMN36D' line).
      if ((ADOPTIVE == usCreateContract) && (0 == usCountyRow)) {
        caud08dCdCncntyService = CD_SERV_ADP_SUB;
      }

      // PWO 1080: Add if statement
      if ((ADOPTIVE == usCreateContract) && (1 == usCountyRow)) {
        caud08dCdCncntyService = CD_SERV_ADP_NON_REC_SUB;
      }

      caud08dContractCounty.setCdCncntyService(caud08dCdCncntyService);
      caud08dContractCounty.setNbrCncntyLineItem((usCountyRow + 1));

      // caud08dAUDdam - add
      contractCountyDAO.saveContractCounty(caud08dContractCounty);
      usCountyRow++;
    }
  }

  private Contract saveContract(int cfad36siIdResource, String cdRsrcRegion, int ulTempIdRsrcAddress,
                                int idCntrctManager, int idCntrctWkr) {

	    Contract caud01dContract = new Contract();
	    CapsResource caud01dCapsResource = getPersistentObject(CapsResource.class, cfad36siIdResource);
	    caud01dContract.setCapsResource(caud01dCapsResource);
	    caud01dContract.setCdCntrctFuncType(STAGE_CD_FAD);
	    caud01dContract.setCdCntrctProgramType(FA_PROGRAM);
	    caud01dContract.setCdCntrctProcureType(PROVIDER_ENROLL);
	    caud01dContract.setCdCntrctRegion(cdRsrcRegion);
	    caud01dContract.setIndCntrctBudgLimit(NO_LIMIT);
	    ResourceAddress caud01dResourceAddress = getPersistentObject(ResourceAddress.class, ulTempIdRsrcAddress); 
	    caud01dContract.setResourceAddress(caud01dResourceAddress);
	    Person caud01dPersonIdCntrctManager = getPersistentObject(Person.class, idCntrctManager);//new Person();
	    caud01dContract.setPersonByIdCntrctManager(caud01dPersonIdCntrctManager);
	    Person caud01dPersonIdCntrctWkr = getPersistentObject(Person.class, idCntrctWkr);//new Person();
	    caud01dContract.setPersonByIdCntrctWkr(caud01dPersonIdCntrctWkr);

	    // caud01dAUDdam - save Contract and return new object.
	    // This should include the new idContract.
	    contractDAO.saveContract(caud01dContract);
	    return caud01dContract;
	  }

  private void saveContractServiceAdoptive(int idCntrctWkr, int ulIdTempContract) {
    ContractService caud17dContractService = new ContractService();
    Person caud17dPerson = getPersistentObject(Person.class, idCntrctWkr);
    caud17dContractService.setPerson(caud17dPerson);
    Contract caud17dContract = getPersistentObject(Contract.class, ulIdTempContract);
    caud17dContractService.setContract(caud17dContract);
    caud17dContractService.setNbrCnsvcPeriod(1);
    caud17dContractService.setNbrCnsvcVersion(1);
    caud17dContractService.setNbrCnsvcLineItem(1);
    caud17dContractService.setCdCnsvcService(CD_SERV_ADP_SUB);
    caud17dContractService.setCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
    caud17dContractService.setIndCnsvcNewRow(ArchitectureConstants.N);
    caud17dContractService.setCdCnsvcUnitType(ADOPTION_SUBSIDY);
    caud17dContractService.setNbrCnsvcUnitRate(SUBSIDY_PAYMENT);

    // caud17dAUDdam
    contractServiceDAO.saveContractService(caud17dContractService);

    ContractService caud17dContractService2 = new ContractService();
    caud17dContractService2.setPerson(caud17dPerson);
    caud17dContractService2.setContract(caud17dContract);
    caud17dContractService2.setNbrCnsvcPeriod(1);
    caud17dContractService2.setNbrCnsvcVersion(1);
    caud17dContractService2.setNbrCnsvcLineItem(2);
    caud17dContractService2.setCdCnsvcService(CD_SERV_ADP_SUB);
    caud17dContractService2.setCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
    caud17dContractService2.setIndCnsvcNewRow(ArchitectureConstants.N);
    caud17dContractService2.setCdCnsvcUnitType(ADOPTION_SUBSIDY);
    caud17dContractService2.setNbrCnsvcUnitRate(SUBSIDY_PAYMENT);

    // caud17dAUDdam
    contractServiceDAO.saveContractService(caud17dContractService2);
  }

  private void saveContractPeriod(Contract newContract, int idCntrctWkr, Date nowPlus100Years) {
    ContractPeriod caud20dContractPeriod = new ContractPeriod();
    Integer idContract = newContract.getIdContract();
    caud20dContractPeriod.setContract(newContract);
    Person caud20dPerson = getPersistentObject(Person.class, idCntrctWkr);
    caud20dContractPeriod.setPerson(caud20dPerson);
    ContractPeriodId caud20dContractPeriodId = new ContractPeriodId();
    caud20dContractPeriodId.setIdContract(idContract);
    caud20dContractPeriodId.setNbrCnperPeriod(1);
    caud20dContractPeriod.setId(caud20dContractPeriodId);
    caud20dContractPeriod.setDtCnperClosure(nowPlus100Years);
    caud20dContractPeriod.setDtCnperTerm(nowPlus100Years);
    caud20dContractPeriod.setDtCnperStart(new Date());
    caud20dContractPeriod.setCdCnperStatus(CONTRACT_STATUS_ACTIVE);
    caud20dContractPeriod.setIndCnperRenewal(ArchitectureConstants.N);
    caud20dContractPeriod.setIndCnperSigned(ArchitectureConstants.Y);

    // caud20dAUDdam
    contractPeriodDAO.saveContractPeriod(caud20dContractPeriod);
  }

  private void saveContractServiceFoster(int usCountyRow, int ulIdTempContract, int idCntrctWkr) {

    ContractService caud17dContractService = new ContractService();
    Contract caud17dContract = getPersistentObject(Contract.class, ulIdTempContract);
    caud17dContractService.setContract(caud17dContract);
    Person caud17dPerson = getPersistentObject(Person.class, idCntrctWkr);
    caud17dContractService.setPerson(caud17dPerson);
    caud17dContractService.setNbrCnsvcPeriod(1);
    caud17dContractService.setNbrCnsvcVersion(1);
    caud17dContractService.setCdCnsvcUnitType(DAY_24_HOURS);
    caud17dContractService.setCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
    caud17dContractService.setIndCnsvcNewRow(ArchitectureConstants.N);

    while (usCountyRow < NBR_SVC_CODE_SIXTY_ABCD) {
      caud17dContractService.setNbrCnsvcLineItem(usCountyRow + 1);
      String caud17dCdCnsvcService = null;
      double caud17dNbrCnsvcUnitRate = 0.0;

      switch (usCountyRow) {
      case 0:
        caud17dCdCnsvcService = CD_SERV_FOST_LEV_BASIC;
        caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_BASIC;
        break;
      case 1:
        caud17dCdCnsvcService = CD_SERV_FOST_LEV_MOD;
        caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_MOD;
        break;
      case 2:
        caud17dCdCnsvcService = CD_SERV_FOST_LEV_SPEC;
        caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_SPEC;
        break;
      case 3:
        caud17dCdCnsvcService = CD_SERV_FOST_LEV_INT;
        caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_INT;
        break;
      default:
        break;
      }

      caud17dContractService.setCdCnsvcService(caud17dCdCnsvcService);
      caud17dContractService.setNbrCnsvcUnitRate(caud17dNbrCnsvcUnitRate);

      // caud17dAUDdam
      contractServiceDAO.saveContractService(caud17dContractService);
      usCountyRow++;
    }

  }

  private void contractVerSerCnty(String cdRsrcCnty, int idResource, int idContract, int nbrCnperPeriod, String lastUpdatedBy)
                                                                                                        throws ServiceException {

    // cses01dQUERYdam
    ContractVersion cses01dContractVersion = contractVersionDAO.findLatestContractVersion(idContract, nbrCnperPeriod);

    if (cses01dContractVersion == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Date caud15dDtCnverEffective = cses01dContractVersion.getDtCnverEffective();
    boolean bDeleteInsertContractCounty = true;

    if (DateHelper.minutesDifference(new Date(), caud15dDtCnverEffective) <= 2) {
      bDeleteInsertContractCounty = false;
    }

    String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    ContractPeriod cses01dContractPeriod = cses01dContractVersion.getContractPeriod();
    ContractPeriodId cses01dContractPeriodId = cses01dContractPeriod.getId();
    int caud15dNbrCnverVersion = cses01dContractVersion.getNbrCnverVersion();
    String caud15dIndCnverVerLock = cses01dContractVersion.getIndCnverVerLock();
    String caud15dTxtCnverComment = cses01dContractVersion.getTxtCnverComment();
    int caud15dIdCnver = cses01dContractVersion.getIdCnver();
    Date caud15dDtCnverEnd = new Date();

    for (int x = 0; x < 2 && bDeleteInsertContractCounty; x++) {
      if (x == 1) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
        caud15dIndCnverVerLock = ArchitectureConstants.Y;
        caud15dDtCnverEnd = cses01dContractVersion.getDtCnverEnd();
        caud15dDtCnverEffective = new Date();
        caud15dNbrCnverVersion = cses01dContractVersion.getNbrCnverVersion() + 1;
        caud15dTxtCnverComment = StringHelper.EMPTY_STRING;
        caud15dIdCnver = 0;
      }

      // caud15dAUDdam
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        cses01dContractVersion.setIndCnverVerLock(caud15dIndCnverVerLock);
        cses01dContractVersion.setDtCnverEnd(caud15dDtCnverEnd);
        cses01dContractVersion.setNbrCnverVersion(caud15dNbrCnverVersion);
        cses01dContractVersion.setTxtCnverComment(caud15dTxtCnverComment);
        cses01dContractVersion.setIdCnver(caud15dIdCnver);
        contractVersionDAO.saveContractVersion(cses01dContractVersion);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        int caud15dRowsUpdated = contractVersionDAO
                                                   .updateContractVersion(
                                                                          cses01dContractPeriodId.getIdContract(),
                                                                          cses01dContractPeriodId.getNbrCnperPeriod(),
                                                                          caud15dNbrCnverVersion,
                                                                          cses01dContractVersion.getDtLastUpdate(),
                                                                          caud15dIdCnver,
                                                                          cses01dContractVersion.getPerson()
                                                                                                .getIdPerson(),
                                                                          cses01dContractVersion.getNbrCnverNoShowPct(),
                                                                          caud15dIndCnverVerLock,
                                                                          caud15dTxtCnverComment,
                                                                          cses01dContractVersion.getDtCnverCreate(),
                                                                          caud15dDtCnverEnd, caud15dDtCnverEffective, lastUpdatedBy);
        if (caud15dRowsUpdated == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

    }

    if (bDeleteInsertContractCounty) {

      // clss13dQUERYdam
      List<ContractService> clss13dContractServiceList = contractServiceDAO
                                                                           .findConSvcByIdConAndNbrCnsvcPeriodMaxAndNbrCnsvcVersionMax(idContract);

      if (clss13dContractServiceList == null || clss13dContractServiceList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      ContractService clss13dContractServiceRowZero = clss13dContractServiceList.get(0);
      clss13dContractServiceRowZero.setIdCnsvc(0);

      for (int y = 0; y < 5; y++) {
        clss13dContractServiceRowZero.setNbrCnsvcVersion(clss13dContractServiceRowZero.getNbrCnsvcVersion() + 1);
        clss13dContractServiceRowZero.setNbrCnsvcLineItem(y + 1);
        String caud17dCdCnsvcService = null;
        double caud17dNbrCnsvcUnitRate = 0.00;

        switch (y) {
        case 0:
          caud17dCdCnsvcService = CD_SERV_FOST_LEV_BASIC;
          caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_BASIC;
          break;
        case 1:
          caud17dCdCnsvcService = CD_SERV_FOST_LEV_MOD;
          caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_MOD;
          break;
        case 2:
          caud17dCdCnsvcService = CD_SERV_FOST_LEV_SPEC;
          caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_SPEC;
          break;
        case 3:
          caud17dCdCnsvcService = CD_SERV_FOST_LEV_INT;
          caud17dNbrCnsvcUnitRate = FOSTER_PAYMENT_LEV_INT;
          break;
        default:
          break;
        }

        clss13dContractServiceRowZero.setCdCnsvcService(caud17dCdCnsvcService);
        clss13dContractServiceRowZero.setNbrCnsvcUnitRate(caud17dNbrCnsvcUnitRate);
        clss13dContractServiceRowZero.setDtLastUpdate(new Date());

        // caud17dAUDdam - add
        contractServiceDAO.saveContractService(clss13dContractServiceRowZero);
      }
    }

    // cres04dQUERYdam
    CapsResource cres04dCapsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);

    if (cres04dCapsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    boolean blFoster = true;
    if (FA_CATG_ADOPT.equals(cres04dCapsResource.getCdRsrcCategory())) {
      blFoster = false;
    }

    String szAdoptiveOrFoster = cres04dCapsResource.getCdRsrcFaHomeType1() + cres04dCapsResource.getCdRsrcFaHomeType2()
                                + cres04dCapsResource.getCdRsrcFaHomeType3()
                                + cres04dCapsResource.getCdRsrcFaHomeType4()
                                + cres04dCapsResource.getCdRsrcFaHomeType5()
                                + cres04dCapsResource.getCdRsrcFaHomeType6()
                                + cres04dCapsResource.getCdRsrcFaHomeType7();

    boolean bGroupHome2 = false;
    // 19613 Basic only has 63A now
    int ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_A;
    if (szAdoptiveOrFoster.substring(0) == null) {
      ulLocalAdoptOrFoster = 0;
    } else {
      // loop through the rows to see if any of them
      // are group homes, if they are set an indicator
      for (int a = 0; a < NBR_OF_HOME_TYPE; a++) {
        if (szAdoptiveOrFoster.substring(a) == FOST_TYPE_GROUP) {
          bGroupHome2 = true;
          break;
        }
      }

      for (int b = 0; b < NBR_OF_HOME_TYPE; b++) {
        if ((szAdoptiveOrFoster.substring(b) == FOST_TYPE_HABIL) || (szAdoptiveOrFoster.substring(b) == FOST_TYPE_THER)
            || (szAdoptiveOrFoster.substring(b) == FOST_TYPE_PRIM_MED)) {
          if (!bGroupHome2) {
            ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_ABCD;
            break;
          } else {
            ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_ABC;
            break;
          }
        }
      }
    }

    // clss68dQUERYdam
    List<ContractCounty> clss68dContractCountyList = contractCountyDAO
                                                                      .findContractCountyByIdContactVersionAndPeriod(
                                                                                                                     idContract,
                                                                                                                     nbrCnperPeriod,
                                                                                                                     cses01dContractVersion
                                                                                                                                           .getNbrCnverVersion());

    if (clss68dContractCountyList != null && !clss68dContractCountyList.isEmpty()) {
      Iterator itClss68dContractCountyList = clss68dContractCountyList.iterator();
      if (!bDeleteInsertContractCounty) {
        while (itClss68dContractCountyList.hasNext()) {
          ContractCounty clss68dContractCounty = (ContractCounty) itClss68dContractCountyList.next();

          // caud08dAUDdam
          int caud08dRowsUpdated = contractCountyDAO.deleteContractCounty(clss68dContractCounty.getDtLastUpdate(),
                                                                          clss68dContractCounty.getIdCncnty());

          if (caud08dRowsUpdated == 0) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        }
      } else {

        while (itClss68dContractCountyList.hasNext()) {
          ContractCounty clss68dContractCounty = (ContractCounty) itClss68dContractCountyList.next();
          clss68dContractCounty.setDtCncntyEnd(new Date());

          // caud08dAUDdam - update
          contractCountyDAO.saveContractCounty(clss68dContractCounty);
        }
      }
    }

    if (blFoster) {
      ContractCounty caud08dContractCounty = new ContractCounty();

      caud08dContractCounty.setIdCncnty(0);

      if (!bDeleteInsertContractCounty) {
        caud08dContractCounty.setNbrCncntyVersion(cses01dContractVersion.getNbrCnverVersion());
      } else {
        caud08dContractCounty.setNbrCncntyVersion(cses01dContractVersion.getNbrCnverVersion() + 1);
      }

      caud08dContractCounty.setCdCncntyCounty(cdRsrcCnty);
      caud08dContractCounty.setDtLastUpdate(new Date());
      Contract caud08dContract = new Contract();
      caud08dContract.setIdContract(cses01dContractPeriodId.getIdContract());
      caud08dContractCounty.setContract(caud08dContract);
      caud08dContractCounty.setNbrCncntyPeriod(caud15dNbrCnverVersion);
      Person caud08dPerson = cses01dContractVersion.getPerson();
      caud08dContractCounty.setPerson(caud08dPerson);
      CapsResource caud08dCapsResource = new CapsResource();
      caud08dCapsResource.setIdResource(idResource);
      caud08dContractCounty.setCapsResource(caud08dCapsResource);
      caud08dContractCounty.setDtCncntyEffective(new Date());
      caud08dContractCounty.setDtCncntyEnd(cses01dContractVersion.getDtCnverEnd());

      for (int p = 0; p < ulLocalAdoptOrFoster; p++) {
        caud08dContractCounty.setNbrCncntyLineItem(p + 1);
        String caud08dCdCncntyService = null;

        switch (p) {
        case 0:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_BASIC;
          break;
        case 1:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_MOD;
          break;
        case 2:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_SPEC;
          break;
        case 3:
          caud08dCdCncntyService = CD_SERV_FOST_LEV_INT;
          break;
        default:
          break;
        }

        caud08dContractCounty.setCdCncntyService(caud08dCdCncntyService);

        // caud08dAUDdam - add
        contractCountyDAO.saveContractCounty(caud08dContractCounty);
      }
    }
  }
}
