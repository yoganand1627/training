package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveSpecialHandling;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82SO;

public class SaveSpecialHandlingImpl extends BaseServiceImpl implements SaveSpecialHandling {

  private CapsCaseDAO capsCaseDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public CCMN82SO updateCapsCase(CCMN82SI ccmn82si) throws ServiceException {
    if (!(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(ccmn82si.getArchInputStruct().getCReqFuncCd()))) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    //ccmng4d
    int rowsUpdated = capsCaseDAO.updateCapsCase(ccmn82si.getSpecHD().getSzCdCaseSpeclHndlg(),
                                                 ccmn82si.getSpecHD().getBIndCaseWorkerSafety(),
                                                 ccmn82si.getSpecHD().getSzTxtCaseWorkerSafety(),
                                                 ccmn82si.getSpecHD().getSzTxtCaseSensitiveCmnts(),
                                                 ccmn82si.getSpecHD().getBIndCaseSensitive(),
                                                 ccmn82si.getSpecHD().getUlIdCase(),
                                                 ccmn82si.getSpecHD().getTsSysTsLastUpdate2());
    if (rowsUpdated <= 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    return new CCMN82SO();
  }
}
