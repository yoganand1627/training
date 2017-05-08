package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexRecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveRecordsRetention;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC20SO;

public class SaveRecordsRetentionImpl extends BaseServiceImpl implements SaveRecordsRetention {

  RecordsRetentionDAO recordsRetentionDAO = null;
  ComplexRecordsRetentionDAO complexRecordsRetentionDAO = null;

  public void setComplexRecordsRetentionDAO(ComplexRecordsRetentionDAO complexRecordsRetentionDAO) {
    this.complexRecordsRetentionDAO = complexRecordsRetentionDAO;
  }

  public void setRecordsRetentionDAO(RecordsRetentionDAO recordsRetentionDAO) {
    this.recordsRetentionDAO = recordsRetentionDAO;
  }

  public CCFC20SO saveRecordsRetention(CCFC20SI ccfc20si) throws ServiceException {
    CCFC20SO ccfc20so = new CCFC20SO();
    String cReqFuncCd = ccfc20si.getArchInputStruct().getCReqFuncCd();
    int rowsUpdated;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      rowsUpdated = complexRecordsRetentionDAO.saveRecordsRetention(true, ccfc20si.getUlIdCase(),
                                                                    ccfc20si.getTsLastUpdate(),
                                                                    ccfc20si.getSzCdRecRtnRetenType(),
                                                                    DateHelper.toJavaDate(
                                                                            ccfc20si.getDtDtRecRtnDstryActual()),
                                                                    DateHelper.toJavaDate(
                                                                            ccfc20si.getDtDtRecRtnDstryElig()),
                                                                    ccfc20si.getSzTxtRecRtnDstryDtRsn());
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      rowsUpdated = complexRecordsRetentionDAO.saveRecordsRetention(false, ccfc20si.getUlIdCase(),
                                                                    ccfc20si.getTsLastUpdate(),
                                                                    ccfc20si.getSzCdRecRtnRetenType(),
                                                                    DateHelper.toJavaDate(
                                                                            ccfc20si.getDtDtRecRtnDstryActual()),
                                                                    DateHelper.toJavaDate(
                                                                            ccfc20si.getDtDtRecRtnDstryElig()),
                                                                    ccfc20si.getSzTxtRecRtnDstryDtRsn());
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      rowsUpdated = recordsRetentionDAO.deleteRecordsRetention(ccfc20si.getUlIdCase(), ccfc20si.getTsLastUpdate());
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    if (rowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
    return ccfc20so;
  }
}
