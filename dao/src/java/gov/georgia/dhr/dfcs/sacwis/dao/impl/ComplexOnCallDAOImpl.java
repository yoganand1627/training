package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexOnCallDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallDAO;

public class ComplexOnCallDAOImpl extends BaseDAOImpl implements ComplexOnCallDAO {
  private OnCallDAO onCallDAO = null;

  public void setOnCallDAO(OnCallDAO onCallDAO) {
    this.onCallDAO = onCallDAO;
  }

  public Date updateOnCall(String cdOnCallProgram, String cdOnCallType, Date dtOnCallStart, Date dtOnCallEnd,
                           int idOnCall, Date dtLastUpdate) {
    onCallDAO.updateOnCall(cdOnCallProgram, cdOnCallType, dtOnCallStart, dtOnCallEnd, idOnCall, dtLastUpdate);
    return onCallDAO.findDtLastUpdate(idOnCall);
  }

  public Date updateOnCallByIdOnCallDtLastUpdate(String indOnCallFilled, int idOnCall, Date dtLastUpdate) {
    onCallDAO.updateOnCallByIdOnCallDtLastUpdate(indOnCallFilled, idOnCall, dtLastUpdate);
    return onCallDAO.findDtLastUpdate(idOnCall);
  }
}