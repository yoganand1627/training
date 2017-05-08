package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import gov.georgia.dhr.dfcs.sacwis.db.UasEntCodeMtntAudit;

import java.util.List;

public interface ComplexUASEntCodeMtntAuditDAO {
  public List<Integer> saveUasEntCodeMtntAuditList(List<UasEntCodeMtntAudit> entAuditList);

}
