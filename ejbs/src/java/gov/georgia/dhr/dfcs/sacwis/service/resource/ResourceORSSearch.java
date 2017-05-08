package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceActivityException;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;

import java.sql.SQLException;

/**
 * This class is the interface for ResourceOrsSearchEJB.
 * 
 * @author Sriram S, Mar 10, 2008
 */
public interface ResourceORSSearch {

  /**
   * This method provides functionality to search for resources based on a set of criteria.
   * 
   * @param searchBean the object containing the values to search on.
   * @return PaginationResultBean
   */
  public PaginationResultBean searchORSResources(ResourceORSSearchValueBean searchBean) throws SQLException,
                                                                                    ResourceActivityException,
                                                                                    TooManyRowsReturnedException;
}