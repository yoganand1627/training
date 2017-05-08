package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsRetentionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsRetention;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveRecordsRetention;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;

public class RetrieveRecordsRetentionImpl extends BaseServiceImpl implements RetrieveRecordsRetention {

  private CapsCaseDAO capsCaseDAO = null;
  private RecordsRetentionDAO recordsRetentionDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setRecordsRetentionDAO(RecordsRetentionDAO recordsRetentionDAO) {
    this.recordsRetentionDAO = recordsRetentionDAO;
  }

  public CCFC19SO findRecordsRetention(CCFC19SI ccfc19si) throws ServiceException {
    CCFC19SO ccfc19so = new CCFC19SO();
    int idCase = ccfc19si.getUlIdCase();

    //rc = ccmnc5dQUERYdam(sqlca, pCCMNC5DInputRec, pCCMNC5DOutputRec);
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    if (capsCase == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ccfc19so.setDtDtCaseClosed(DateHelper.toCastorDate(capsCase.getDtCaseClosed()));

    // rc = cses56dQUERYdam(sqlca, pCSES56DInputRec, pCSES56DOutputRec);
    RecordsRetention recRtn = recordsRetentionDAO.findRecordsRetention(idCase);
    if (recRtn == null) {
      throw new ServiceException(Messages.MSG_REC_RETN_NOT_FOUND);
    }

    ccfc19so.setSzCdRecRtnRetenType(recRtn.getCdRecRtnRetenType());
    ccfc19so.setSzTxtRecRtnDstryDtRsn(recRtn.getTxtRecRtnDstryDtRsn());
    ccfc19so.setTsLastUpdate(recRtn.getDtLastUpdate());
    ccfc19so.setDtDtRecRtnDstryActual(DateHelper.toCastorDate(recRtn.getDtRecRtnDstryActual()));
    ccfc19so.setDtDtRecRtnDstryElig(DateHelper.toCastorDate(recRtn.getDtRecRtnDstryElig()));

    if (DateHelper.isNull(ccfc19so.getDtDtRecRtnDstryActual())) {
      ccfc19so.setDtDtRecRtnDstryActual(DateHelper.MAX_CASTOR_DATE);
    }

    if (DateHelper.isNull(ccfc19so.getDtDtRecRtnDstryElig())) {
      ccfc19so.setDtDtRecRtnDstryElig(DateHelper.MAX_CASTOR_DATE);
    }

    return ccfc19so;
  }
}