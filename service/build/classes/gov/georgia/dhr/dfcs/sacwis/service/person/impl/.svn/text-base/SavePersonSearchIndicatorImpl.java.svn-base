package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePersonSearchIndicator;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV50SO;

public class SavePersonSearchIndicatorImpl extends BaseServiceImpl implements SavePersonSearchIndicator {
  private CheckStageEventStatus checkStageEventStatus = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public CINV50SO updatePersonSearchIndicator(CINV50SI cinv50si) throws ServiceException {
    CINV50SO cinv50so = new CINV50SO();
    // (BEGIN): Common Function: ccmn06u Check Stage/Event common function
    ArchInputStruct archInputStruct = cinv50si.getArchInputStruct();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    int idStage = cinv50si.getUlIdStage();
    // Common Function: ccmn06u   Check Stage/Event common function
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(new ArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cinv50si.getSzCdTask());
    // CheckStageEventStatus;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);

    // Update the Person Search Indicator on STAGE PERSON LINK for a given ID PERSON.
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Update the Person Search Indicator on the Stage Person Link table.
      // cinv78d
      stagePersonLinkDAO.updateStagePersonLinkCdStagePersSearchInd(cinv50si.getSzCdStagePersSearchInd(),
                                                                   cinv50si.getUlIdStagePerson(), idStage);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return cinv50so;
  }
}
