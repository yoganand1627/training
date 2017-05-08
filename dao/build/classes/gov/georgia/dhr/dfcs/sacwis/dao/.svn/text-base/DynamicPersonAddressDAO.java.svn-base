package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

import java.util.Map;

public interface DynamicPersonAddressDAO {
  public PaginatedHibernateList<Map> findPersonsByAddr(String addrStLn1, String addrStLn2, String city, String county,
                                                       String state, String zip, int pageNbr, int pageSize);

}
