package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntValueBean;

public interface CFMgmntList {
  CFMgmntValueBean getCFMgmntInfo(CFMgmntValueBean searchBean);
}