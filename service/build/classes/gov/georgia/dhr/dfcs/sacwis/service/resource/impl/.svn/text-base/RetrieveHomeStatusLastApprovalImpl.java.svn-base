package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveHomeStatusLastApproval;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   03/24/11    Hai Nguyen        SMS#97850: MR-075 Initial creation.                                
 *                                 
 **/

public class RetrieveHomeStatusLastApprovalImpl extends BaseServiceImpl implements RetrieveHomeStatusLastApproval {

  private ResourceHistoryDAO resourceHistoryDAO = null;

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  public Date retrieveHomeStatusLastApproval(int idResource, List<String> cdFaHomeStatuses) throws ServiceException {
    if( cdFaHomeStatuses != null && !cdFaHomeStatuses.isEmpty()){
      return resourceHistoryDAO.findLastApprovalDateByIdResourceByCdFaHomeStatuses(idResource, cdFaHomeStatuses);
    }else{
      return null;
    }
  }
}
