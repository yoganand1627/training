package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAChildSearchBean;
import gov.georgia.dhr.dfcs.sacwis.dao.fad.FAHomeValueBean;

import javax.ejb.EJBLocalObject;

public interface FAHomeList extends EJBLocalObject {
  public PaginationResultBean getFAHomeList(FAHomeValueBean searchBean) throws TooManyRowsReturnedException;
  
  
  /**
   * Passing the given id person this query will retrieve Some person Information
   * @param idChild
   * @return
   * @throws TooManyRowsReturnedException, ServiceException
   */
  public FAChildSearchBean getChildInformation(Integer idChild) throws TooManyRowsReturnedException, ServiceException;
  
  
}