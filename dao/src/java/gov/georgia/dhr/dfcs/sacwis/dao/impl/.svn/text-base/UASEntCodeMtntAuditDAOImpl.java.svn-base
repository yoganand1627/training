package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASEntCodeMtntAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtntAudit;

public class UASEntCodeMtntAuditDAOImpl extends BaseDAOImpl implements UASEntCodeMtntAuditDAO {

  public int saveUasEntCodeMtntAudit(UasEntCodeMtntAudit uasEntCodeMtntAudit) {
    getSession().saveOrUpdate(uasEntCodeMtntAudit);
    return uasEntCodeMtntAudit.getIdUasEntCodeMtntAudit();
  }

}
