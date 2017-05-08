package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.financials.UASPrgCodeMtntAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.db.UasPrgCodeMtntAudit;

public class UASPrgCodeMtntAuditDAOImpl extends BaseDAOImpl implements UASPrgCodeMtntAuditDAO {

  public int saveUasPrgCodeMtntAudit(UasPrgCodeMtntAudit uasPrgCodeMtntAudit) {
      getSession().saveOrUpdate(uasPrgCodeMtntAudit);
      return uasPrgCodeMtntAudit.getIdUasPrgCodeMtntAudit();
    }

}
