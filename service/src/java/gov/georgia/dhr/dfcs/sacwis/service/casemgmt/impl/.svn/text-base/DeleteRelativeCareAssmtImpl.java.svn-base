package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.DeleteRelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelativeCareAssmtDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

public class DeleteRelativeCareAssmtImpl extends BaseServiceImpl implements DeleteRelativeCareAssmt{
  
  private PostEvent postEvent = null;

  private CheckStageEventStatus checkStageEventStatus = null;
  
  private InvalidateApproval invalidateApproval = null;
  
  private RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO = null;
  
  private RelativeCareAssmtDAO relativeCareAssmtDAO = null;
  
  public void setRelativeCareAssmtPersonDAO(RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO ){
    this.relativeCareAssmtPersonDAO = relativeCareAssmtPersonDAO;
  }
  
  public void setRelativeCareAssmtDAO(RelativeCareAssmtDAO relativeCareAssmtDAO ){
    this.relativeCareAssmtDAO = relativeCareAssmtDAO;
  }
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void deleteRelativeCareAssmt(RelativeCareAssmtDeleteSI deleteSI){
    checkStageEventStatus(deleteSI.getEventReqFuncCd(), deleteSI.getIdStage(),
                          deleteSI.getCdStage());
    int idEvent = deleteSI.getUlIdEvent();
    relativeCareAssmtPersonDAO.deleteRelativeCareAssmtPersons(idEvent);
    relativeCareAssmtDAO.deleteRelativeCareAssmtByIdEvent(idEvent);
    
    //STGAP00010758 Deleting an Event should call invalidate approval
    CCMN05UI ccmn05ui = new CCMN05UI();
    ccmn05ui.setUlIdEvent(idEvent);
    ArchInputStruct ais = new ArchInputStruct();
    ais.setUlSysNbrReserved1(ArchitectureConstants.N);
    ccmn05ui.setArchInputStruct(ais);
    invalidateApproval.invalidateApproval(ccmn05ui);
     
    ROWCCMN01UIG00 rowccmn01uigoo =  deleteSI.getRowccmn01uigoo();
    ROWCCMN01UIG01_ARRAY rowArray = deleteSI.getRowccmn01uig00_array();
    callPostEvent(deleteSI.getEventReqFuncCd(), rowccmn01uigoo, rowArray); 
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
  
  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00,
                                 ROWCCMN01UIG01_ARRAY rowccmn01uig01_array)
          throws ServiceException {

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

}
