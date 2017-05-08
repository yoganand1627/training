package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportListDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.DeleteReportList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC19SO;

public class DeleteReportListImpl extends BaseServiceImpl implements DeleteReportList {

  private ReportListDAO reportListDAO = null;

  public void setReportListDAO(ReportListDAO reportListDAO) {
    this.reportListDAO = reportListDAO;
  }

  public CARC19SO deleteReportList(CARC19SI carc19si) throws ServiceException {
    CARC19SO carc19so = new CARC19SO();
    // cauda2d
    if (reportListDAO.deleteReportList(carc19si.getUlIdRptList()) == 0) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    return carc19so;
  }
}
