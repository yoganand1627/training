package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveNeedsAndOutcomes;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

public class SaveNeedsAndOutcomesImpl extends BaseServiceImpl implements SaveNeedsAndOutcomes {

  private NeedsOutcomesDAO needsOutcomesDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private PostEvent postEvent = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  public void setNeedsOutcomesDAO(NeedsOutcomesDAO needsOutcomesDAO) {
    this.needsOutcomesDAO = needsOutcomesDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public int saveNeedsOutcomes(NeedsAndOutcomesSaveSI needsandoutcomessavesi) {
    ROWCCMN01UIG00 needsOutcomesEvent = needsandoutcomessavesi.getROWCCMN01UIG00();
    CCMN01UO ccmn01uo = new CCMN01UO();
    int idEvent = needsandoutcomessavesi.getUlIdEvent();
    int idStage = needsandoutcomessavesi.getIdStage();
    String cdStage = "SUB";
    String eventReqFuncCd = "";
    // set add or update mode
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    needsandoutcomessavesi.setCdReqFuncCd(eventReqFuncCd);
    // make sure stage is not closed
    checkStageEventStatus(eventReqFuncCd, idStage, cdStage);
    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(needsandoutcomessavesi.getCdReqFuncCd())) {
      ccmn01uo = callPostEvent(eventReqFuncCd, needsOutcomesEvent);

      // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
      idEvent = ccmn01uo.getUlIdEvent();
      needsandoutcomessavesi.setUlIdEvent(idEvent);
    }
    // save needs and outcomes
    saveNeedsAndOutcomes(needsandoutcomessavesi);
    return idEvent;

  }

  // save needs and outcomes details to database
  private void saveNeedsAndOutcomes(NeedsAndOutcomesSaveSI needsAndOutcomesSaveSI) throws ServiceException {

    NeedsOutcomes needsOutcomes = new NeedsOutcomes();
    int idEvent = needsAndOutcomesSaveSI.getUlIdEvent();
    String idResource = needsAndOutcomesSaveSI.getResourceIdForPullback();
    int resourceId = 0;
    if (idResource != null) {
      resourceId = Integer.parseInt(needsAndOutcomesSaveSI.getResourceIdForPullback());
    }
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    needsOutcomes.setEvent(event);
    needsOutcomes.setIdEvent(idEvent);
    needsOutcomes.setNmAssessor(needsAndOutcomesSaveSI.getTxtAssessorName());
    needsOutcomes.setTxtAssessorTitle(needsAndOutcomesSaveSI.getTxtAssessorTitle());
    needsOutcomes.setDtReferral(needsAndOutcomesSaveSI.getDtReferral());
    needsOutcomes.setDtAsstCmplt(needsAndOutcomesSaveSI.getDtAssessmentCompletion());
    needsOutcomes.setTxtGenRec(needsAndOutcomesSaveSI.getTxtGeneralRec());
    needsOutcomes.setTxtCcfaRec(needsAndOutcomesSaveSI.getTxtCCFARecNotUsed());
    needsOutcomes.setTxtPlcmtRec(needsAndOutcomesSaveSI.getTxtPlacementRec());
    needsOutcomes.setDtLastUpdate(needsAndOutcomesSaveSI.getDtLastUpdate());
    needsOutcomes.setNmAgency(needsAndOutcomesSaveSI.getNMResource());
    needsOutcomes.setIndCcfaAgency(needsAndOutcomesSaveSI.getIndCCFAAgency());
    needsOutcomes.setIndCcfaEduAssmt(needsAndOutcomesSaveSI.getIndCCFAEduAssmt());
    needsOutcomes.setDtCcfaEduAssmt(needsAndOutcomesSaveSI.getDtCCFAEduAssmt());
    needsOutcomes.setTxtCcfaEduAssmt(needsAndOutcomesSaveSI.getTxtCCFAEduAssmt());
    //STGAP00009116: fields moved from form to page
    needsOutcomes.setTxtUnder4NoDevSrcCmnt(needsAndOutcomesSaveSI.getTxtUnder4NoDevSrcCmnt());
    needsOutcomes.setTxtUndSchoolageNoDevAss(needsAndOutcomesSaveSI.getTxtUndSchoolageNoDevAss());
    
    CapsResource capsResource = new CapsResource();
    if (resourceId != 0) {
      capsResource = (CapsResource) getPersistentObject(CapsResource.class, resourceId);
      needsOutcomes.setCapsResource(capsResource);
    }
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(needsAndOutcomesSaveSI.getCdReqFuncCd())) {
      needsOutcomesDAO.saveNeedsOutcomes(needsOutcomes);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(needsAndOutcomesSaveSI.getCdReqFuncCd())) {
      needsOutcomesDAO.saveNeedsOutcomes(needsOutcomes);
    }

  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    // populate primary child's info to insert to Event Person Link table if it is NEW
    // Delete is taken care in SaveNeedsAndOutcomesDetail service
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY();
      int idPrimaryChild = findIdPrimaryChildForSub(rowccmn01uig00.getUlIdStage());
      rowccmn01uig01.setUlIdPerson(idPrimaryChild);
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    }
    // end populate primary child's info to insert to Event Person Link table if it is NEW
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdStage) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdStage);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  private int findIdPrimaryChildForSub(int idStage) {
    String primaryChildRole = CodesTables.CROLES_PC;
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, primaryChildRole);
    return idPerson;
  }

}
