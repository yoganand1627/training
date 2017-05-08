/**
 * Created on July 18 by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

public interface DynamicCodesTablesDAO {
  public static final String SORT_BY_CODE = "1";
  public static final String SORT_BY_DECODE = "2";
  public static final String SORT_BY_END_DATE = "3";

  /**
   * This DAO will retrieve code, decode and end date from Codes Tables, based on dynamic criteria.  
   * The codeType and sortOrder parameters must be populated.
   * <p/>
   * @param codeType
   * @param sortOrder
   * @param pageNbr
   * @param pageSize
   * @param sortAscending
   * It returns a list of object arrays with the following:
   * <pre>
   * String code = CODES_TABLES.CODE = row[0]
   * String decode = CODES_TABLES.DECODE = row[1]
   * String dtEnd = CODES_TABLES.dtEnd = row[2]
   * </pre> 
   */
  public PaginatedHibernateList<Object[]> findCodesTableDetail(String codeType, String sortOrder, int pageNbr, int pageSize, boolean sortAscending);
}
