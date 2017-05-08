package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;

import java.util.Date;
import java.util.Map;

public interface DynamicDelvrdSvcDtlDAO {
  public static final String SORT_NAME = "NM";
  public static final String SORT_RESOURCE_ID = "ID";
  PaginatedHibernateList<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoice(int idInvoice, String orderBy,
                                                                   String sortDir, int pageNbr,
                                                                   int pageSize);
  
  PaginatedHibernateList<Map> findDelvrdSvcDtlByIdInvoiceAndIdContract(int idInvoice, int idContract,
                                                                       String orderBy, String sortDir,
                                                                       int pageNbr, int pageSize);

  PaginatedHibernateList<DelvrdSvcDtl> findDelvrdSvcDtlByIdPerson(int idPerson, Date from, Date to,
                                                                  String region, String county,
                                                                  int pageNbr, int pageSize);
  
  Double sumDelvrdSvcDtlPayments(int idPerson, Date from, Date to, String region, String county);
}
