package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseFileManagementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseFileManagement;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveReopenPAL;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC05SO;

public class SaveReopenPALImpl extends BaseServiceImpl implements SaveReopenPAL {

  private ComplexStagePersonLinkDAO complexStagePersonLinkDAO = null;

  private CapsCaseDAO capsCaseDAO = null;

  private CaseFileManagementDAO caseFileManagementDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private EventDAO eventDAO = null;

  private PalDAO palDAO = null;

  private PostEvent postEvent = null;

  private RecordsRetentionDAO recordsRetentionDAO = null;

  private SituationDAO situationDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public static final String MEMBER_IN = "IN";

  public static final String PRIMARY_ROLE = "PR";

  public static final String TYPE_STAFF = "STF";

  public static final String PRIMARY_CHILD_ROLE = "PC";

  public static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_IN_PROCESS = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_TYPE_ILS = "ILS";

  public static final String EVENT_TYPE_PRO = "PRO";

  public static final String EVENT_TXT_DESCRIPTION = "PAL Stage has been Re-Opened";

  public static final String EVENT_TYPE_RUT = "RUT";

  public static final String EMP_IS_NEW = "1";

  public static final String OPEN = "O";

  public static final String PREP_ADULT = "PAL";

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setComplexStagePersonLinkDAO(ComplexStagePersonLinkDAO complexStagePersonLinkDAO) {
    this.complexStagePersonLinkDAO = complexStagePersonLinkDAO;
  }

  public void setCaseFileManagementDAO(CaseFileManagementDAO caseFileManagementDAO) {
    this.caseFileManagementDAO = caseFileManagementDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPalDAO(PalDAO palDAO) {
    this.palDAO = palDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setRecordsRetentionDAO(RecordsRetentionDAO recordsRetentionDAO) {
    this.recordsRetentionDAO = recordsRetentionDAO;
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

  public CCFC05SO saveReopenPAL(CCFC05SI ccfc05si) throws ServiceException {
    CCFC05SO ccfc05so = new CCFC05SO();

    // cinv51dQUERYdam
    int cinv51dPrimaryWorker = complexStageDAO.findPrimaryWorker(ccfc05si.getUlIdStage(), PRIMARY_CHILD_ROLE);
    int idPersonChild = 0;

    if (cinv51dPrimaryWorker != 0) {
      idPersonChild = cinv51dPrimaryWorker;
      checkForOpenStages(idPersonChild);
    }

    // cint40dQUERYdam
    Stage cint40dStage = stageDAO.findStageByIdStage(ccfc05si.getUlIdStage());

    if (cint40dStage == null) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    // cmsc17dAUDdam
    int cmsc17dRowsUpdated = situationDAO.updateSituation(null, cint40dStage.getSituation().getIdSituation());

    if (cmsc17dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    // cmsc18dAUDdam
    int cmsc18dRowsUpdated = capsCaseDAO.updateCapsCaseDtCaseClosed(null, ccfc05si.getUlIdCase());

    if (cmsc18dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    // caud47dAUDdam
    int caud47dRowsUpdated = stageDAO.updateStage(null, null, null, cint40dStage.getDtLastUpdate(),
                                                  ccfc05si.getUlIdStage());

    if (caud47dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

    // cmsc15dAUDdam
    int cmsc15dRowsUpdated = palDAO.updatePal(ccfc05si.getUlIdStage(), null);

    if (cmsc15dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    // This DAO receives an ID PERSON and a CD UNIT MEMBER
    // ROLE and returns a full row from the UNIT table, a full
    // row from the UNIT EMP LINK table and NM PERSON FULL from
    // the PERSON table. The returned information applies to
    // the unit to which the ID PERSON is assigned with the given
    // CD UNIT MEMBER ROLE. The NM PERSON FULL is the name of
    // the Unit Approver for that unit.

    ROWCCMN01UIG00 ccfc05siRowrCcmn01Uig00 = ccfc05si.getROWCCMN01UIG00();
    int ccfc05siIdPerson = ccfc05siRowrCcmn01Uig00.getUlIdPerson();
    // ccmn39dQUERYdam
    UnitEmpLink ccmn39dUnitEmpLink = unitEmpLinkDAO
            .findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(
                    ccfc05siIdPerson,
                    MEMBER_IN);

    if (ccmn39dUnitEmpLink == null) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    // cauda0dQUERYdam
    Map stagePersonLinkMap = stagePersonLinkDAO.findStagePersonLinkByIdStageAndRole(ccfc05si.getUlIdStage());

    int idStagePersonLink = (Integer) stagePersonLinkMap.get("idStagePersonLink");

    // Description - If the required function is ADD: This DAO will perform a full
    // row add in the STAGE_PERSON_LINK table.
    // If the required function is UPDATE: This DAM will perform a
    // full row update in the STAGE_PERSON_LINK table. The record
    // updated is the one where the ID STAGE, ID PERSON, CD STAGE
    // PERS TYPE, DT STAGE PERS LINK, and DT LAST UPDATE match the
    // values passed in the DAO's Input Message.
    // If the required function is DELETE: This DAM will delete
    // all the rows in the STAGE_PERSON_LINK table where the value
    // of ID STAGE equals the value passed in the Input Message and
    // CD STAGE PERS ROLE is "PR" or "SE"

    if (stagePersonLinkMap != null && !stagePersonLinkMap.isEmpty()) {
      String cReqFuncCd = null;

      if (0 != idStagePersonLink) {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      } else {
        cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      }

      int ccmnd3dRowsUpdated = 0;

      // ccmnd3dAUDdam
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        ccmnd3dRowsUpdated = stagePersonLinkDAO.updateStagePersonLinkWithoutIndNmStage(ccfc05siIdPerson, PRIMARY_ROLE,
                                                                                       TYPE_STAFF, null, null,
                                                                                       new Date(), null, null, null,
                                                                                       EMP_IS_NEW, idStagePersonLink, null,null);
      } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        ccmnd3dRowsUpdated = stagePersonLinkDAO.insertStagePersonLinkWihoutIndNmStage(ccfc05si.getUlIdStage(),
                                                                                      ccfc05siIdPerson, PRIMARY_ROLE,
                                                                                      TYPE_STAFF, null, null,
                                                                                      new Date(), null, null, null,
                                                                                      EMP_IS_NEW, null,null);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

      if (ccmnd3dRowsUpdated == 0) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }

      CCMN01UI ccmn01ui = new CCMN01UI();
      ArchInputStruct ccfc05siArchInputStruct = ccfc05si.getArchInputStruct();
      ccfc05siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ccmn01ui.setArchInputStruct(ccfc05siArchInputStruct);
      ROWCCMN01UIG00 rowCcmn01Uig00 = new ROWCCMN01UIG00();
      ROWCCMN01UIG01_ARRAY rowCcmn01Uig01Array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowCcmn01Uig01 = new ROWCCMN01UIG01();
      rowCcmn01Uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowCcmn01Uig01.setUlIdPerson(idPersonChild);
      rowCcmn01Uig01Array.addROWCCMN01UIG01(0, rowCcmn01Uig01);
      rowCcmn01Uig00.setROWCCMN01UIG01_ARRAY(rowCcmn01Uig01Array);
      rowCcmn01Uig00.setSzCdTask(ccfc05si.getROWCCMN01UIG00().getSzCdTask());
      rowCcmn01Uig00.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
      rowCcmn01Uig00.setSzCdEventType(EVENT_TYPE_PRO);
      rowCcmn01Uig00.setSzTxtEventDescr(EVENT_TXT_DESCRIPTION);
      rowCcmn01Uig00.setUlIdPerson(ccfc05si.getROWCCMN01UIG00().getUlIdPerson());
      rowCcmn01Uig00.setUlIdStage(ccfc05si.getUlIdStage());
      rowCcmn01Uig00.setUlIdEvent(ccfc05si.getROWCCMN01UIG00().getUlIdEvent());
      rowCcmn01Uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      ccmn01ui.setROWCCMN01UIG00(rowCcmn01Uig00);
      postEvent.postEvent(ccmn01ui);

      // Description - This DAO will update the CD EVENT STATUS for a row in the
      // EVENT table given CD EVENT TYPE and the ID STAGE. This
      // DAO will change all events for the stage with the CD EVENT
      // TYPE specified. It will change the CD EVENT STATUS to the
      // status specified in the input.
      // (re-open PAL Training/Serivces event)

      // caud64dAUDdam
      int caud64dIdEvent = eventDAO.updateEvent(EVENT_STATUS_IN_PROCESS, ccfc05si.getUlIdStage(), EVENT_TYPE_RUT);

      if (caud64dIdEvent == 0) {
        // caud64dAUDdam
        eventDAO.updateEvent(EVENT_STATUS_IN_PROCESS, ccfc05si.getUlIdStage(), EVENT_TYPE_ILS);
      }
    }

    // cses56dQUERYdam
    RecordsRetention cses56dRecordsRetention = recordsRetentionDAO.findRecordsRetention(ccfc05si.getUlIdCase());

    if (cses56dRecordsRetention != null) {
      CapsCase cses56dCapsCase = new CapsCase();
      cses56dCapsCase.setIdCase(ccfc05si.getUlIdCase());
      cses56dRecordsRetention.setCapsCase(cses56dCapsCase);

      // caud75dAUDdam
      recordsRetentionDAO.deleteRecordsRetention(ccfc05si.getUlIdCase(), ccfc05si.getTsLastUpdate());
    }

    // cses57dQUERYdam
    CaseFileManagement cses57dCaseFileManagement = caseFileManagementDAO.findCaseFileManagement(ccfc05si.getUlIdCase());

    if (cses57dCaseFileManagement != null) {
      Unit cses57dUnit = new Unit();
      cses57dUnit.setIdUnit(ccmn39dUnitEmpLink.getUnit().getIdUnit());
      cses57dCaseFileManagement.setUnit(cses57dUnit);

      // caud76dAUDdam
      caseFileManagementDAO.saveCaseFileManagement(cses57dCaseFileManagement);

    }

    return ccfc05so;
  }

  private void checkForOpenStages(int idPerson) throws ServiceException {

    // cses94dQUERYdam
    long countOpenStages = complexStagePersonLinkDAO.countOpenStagesForIdPerson(OPEN, 0, PRIMARY_CHILD_ROLE,
                                                                                PREP_ADULT);

    if (countOpenStages > 0) {
      throw new ServiceException(Messages.MSG_OPEN_PAL_STAGE_EXISTS);
    }
  }
}
