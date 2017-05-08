package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveNeedsAndOutcomesDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NeedsOutcomesDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomesDetail;
import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;

public class SaveNeedsAndOutcomesDetailImpl extends BaseServiceImpl implements SaveNeedsAndOutcomesDetail {

  private CheckStageEventStatus checkStageEventStatus = null;

  private NeedsOutcomesDAO needsOutcomesDAO = null;

  private NeedsOutcomesDetailDAO needsOutcomesDetailDAO = null;

  private PostEvent postEvent = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setNeedsOutcomesDAO(NeedsOutcomesDAO needsOutcomesDAO) {
    this.needsOutcomesDAO = needsOutcomesDAO;
  }

  public void setNeedsOutcomesDetailDAO(NeedsOutcomesDetailDAO needsOutcomesDetailDAO) {
    this.needsOutcomesDetailDAO = needsOutcomesDetailDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public int saveNeedsAndOutcomesDetail(NeedsAndOutcomesSaveSI needsandoutcomessavesi) {
    ROWCCMN01UIG00 needsOutcomesEvent = needsandoutcomessavesi.getROWCCMN01UIG00();

    int idEvent = needsandoutcomessavesi.getUlIdEvent();
    int idStage = needsandoutcomessavesi.getIdStage();
    String cdStage = "SUB";

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(needsandoutcomessavesi.getCdReqFuncCd())) {
      needsOutcomesDetailDAO.deleteNeedsAndOutcomesDetail(needsandoutcomessavesi.getIdNeedsAndOutcomes());
    } else {

      // set add or update mode
      String eventReqFuncCd;
      if (idEvent != 0) {
        eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      } else {
        eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      }
      needsandoutcomessavesi.setCdReqFuncCd(eventReqFuncCd);
      // make sure stage is not closed
      checkStageEventStatus(eventReqFuncCd, idStage, cdStage);

      if ((!ServiceConstants.REQ_FUNC_CD_DELETE.equals(needsandoutcomessavesi.getCdReqFuncCd())) && (idEvent == 0)) {
        CCMN01UO ccmn01uo = callPostEvent(eventReqFuncCd, needsOutcomesEvent);

        // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
        idEvent = ccmn01uo.getUlIdEvent();
        if (idEvent != 0) {
          Event event = getPersistentObject(Event.class, idEvent);
          NeedsOutcomes needsOutcomes = new NeedsOutcomes();
          needsOutcomes.setEvent(event);
          needsOutcomes.setIdEvent(idEvent);
          needsOutcomesDAO.saveNeedsOutcomes(needsOutcomes);
        }
        needsandoutcomessavesi.setUlIdEvent(idEvent);
      }

      // save needs and outcomes
      if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(needsandoutcomessavesi.getCdReqFuncCd()))
          || (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(needsandoutcomessavesi.getCdReqFuncCd()))) {
        saveNeedsOutcomesDetail(needsandoutcomessavesi);
      }
    }

    return idEvent;

  }

  // save needs and outcomes details to database
  private void saveNeedsOutcomesDetail(NeedsAndOutcomesSaveSI needsAndOutcomesSaveSI) throws ServiceException {

    NeedsOutcomesDetail needsOutcomesDetail = new NeedsOutcomesDetail();

    int idEvent = needsAndOutcomesSaveSI.getUlIdEvent();
    int idNeedsOutcomes = needsAndOutcomesSaveSI.getIdNeedsAndOutcomes();
    if (idNeedsOutcomes != 0) {
      needsOutcomesDetail = getPersistentObject(NeedsOutcomesDetail.class, idNeedsOutcomes);
      needsOutcomesDetail.setIdNeedsOutcomesDetail(idNeedsOutcomes);
    }
    needsOutcomesDetail.setIndCcfaNeed(needsAndOutcomesSaveSI.getIndCCFANeed());
    needsOutcomesDetail.setIndNeedMet(needsAndOutcomesSaveSI.getIndNeedMet());
    needsOutcomesDetail.setIndSvcProv(needsAndOutcomesSaveSI.getIndServiceProvided());
    needsOutcomesDetail.setTxtIdenNeed(needsAndOutcomesSaveSI.getTxtIdentifiedNeed());
    needsOutcomesDetail.setTxtComments(needsAndOutcomesSaveSI.getTxtComments());
    needsOutcomesDetail.setTxtSvcRec(needsAndOutcomesSaveSI.getTxtServiceRecommended());
    needsOutcomesDetail.setTxtSvcProv(needsAndOutcomesSaveSI.getTxtServRecdNotProvidedRsn());
    needsOutcomesDetail.setTxtNeedMet(needsAndOutcomesSaveSI.getTxtNeedNotMetRsn());
    needsOutcomesDetail.setDtLastUpdate(needsAndOutcomesSaveSI.getDtLastUpdateDetail());
    needsOutcomesDetail.setIdNeedsOutcomesDetail(needsAndOutcomesSaveSI.getIdNeedsAndOutcomes());
    NeedsOutcomes needsOutcomes = (NeedsOutcomes) getPersistentObject(NeedsOutcomes.class, idEvent);
    needsOutcomesDetail.setNeedsOutcomes(needsOutcomes);
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(needsAndOutcomesSaveSI.getCdReqFuncCd())) {
      needsOutcomesDetailDAO.saveNeedsOutcomesDetail(needsOutcomesDetail);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(needsAndOutcomesSaveSI.getCdReqFuncCd())) {
      needsOutcomesDetailDAO.saveNeedsOutcomesDetail(needsOutcomesDetail);
    }

  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
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

  private int findIdPrimaryChildForSub(int idStage) {
    String primaryChildRole = CodesTables.CROLES_PC;
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, primaryChildRole);
    return idPerson;
  }

}
