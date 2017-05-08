package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Calendar;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveChangeStageType;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB64SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB64SO;

public class SaveChangeStageTypeImpl extends BaseServiceImpl implements SaveChangeStageType {

  private CheckStageEventStatus checkStageEventStatus = null;
  private PostEvent postEvent = null;
  private StageDAO stageDAO = null;
  private TodoDAO todoDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CSUB64SO saveChangeStageType(CSUB64SI csub64si) throws ServiceException {

    CSUB64SO csub64so = new CSUB64SO();

    // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function    
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(csub64si.getArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(csub64si.getArchInputStruct().getCReqFuncCd());
    ccmn06ui.setSzCdTask(csub64si.getCSUB64SIG01().getSzCdTask());
    ccmn06ui.setUlIdStage(csub64si.getCSUB64SIG01().getUlIdStage());
    //rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, sqlca);
    // CheckStageEventStatus;
    // this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);

    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(new ArchInputStruct());

    ccmn01ui.getROWCCMN01UIG00().setUlIdEvent(csub64si.getCSUB64SIG01().getUlIdEvent());

    if (0 != ccmn01ui.getROWCCMN01UIG00().getUlIdEvent()) {
      ccmn01ui.setArchInputStruct(csub64si.getArchInputStruct());
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      ccmn01ui.setArchInputStruct(csub64si.getArchInputStruct());
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    ccmn01ui.getROWCCMN01UIG00().setUlIdEvent(csub64si.getCSUB64SIG01().getUlIdEvent());
    ccmn01ui.getROWCCMN01UIG00().setTsLastUpdate(csub64si.getCSUB64SIG01().getTsLastUpdate());
    ccmn01ui.getROWCCMN01UIG00().setUlIdStage(csub64si.getCSUB64SIG01().getUlIdStage());
    ccmn01ui.getROWCCMN01UIG00().setUlIdPerson(csub64si.getCSUB64SIG01().getUlIdPerson());
    ccmn01ui.getROWCCMN01UIG00().setSzCdTask(csub64si.getCSUB64SIG01().getSzCdTask());
    ccmn01ui.getROWCCMN01UIG00().setSzTxtEventDescr(csub64si.getCSUB64SIG01().getSzTxtEventDescr());
    ccmn01ui.getROWCCMN01UIG00().setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    Calendar cal = Calendar.getInstance();
    Date dtCurrentDate = cal.getTime();
    ccmn01ui.getROWCCMN01UIG00().setDtDtEventOccurred(DateHelper.toCastorDate(dtCurrentDate));
    ccmn01ui.getROWCCMN01UIG00().setSzCdEventType(csub64si.getCSUB64SIG01().getSzCdEventType());
    //rc = Ccmn01u.PostEvent(pxCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
    //PostEvent;
    //this throws an exception that will halt processing with a message if it fails; success is no output.
    postEvent.postEvent(ccmn01ui);

    //rc = caud42dAUDdam(sqlca, pCAUD42DInputRec, pCAUD42DOutputRec);
    int numRows = stageDAO.updateStage(csub64si.getCSUB64SIG00().getTsLastUpdate(),
                                       csub64si.getCSUB64SIG00().getUlIdStage());
    if (numRows == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }

    //rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
    todoDAO.updateTodoByIdEvent(csub64si.getCSUB64SIG01().getUlIdEvent());
    return csub64so;
  }

}
