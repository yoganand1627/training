package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicCodesTablesDAO;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

/**
 * This DAO contains sql that retrieves the code, decode and end date combinations for a given code type from the
 * Database based on the search criteria . <p/>
 * 
 * <pre>
 *    Change History:
 *    Date          User              Description
 *    ----------    ------------      --------------------------------------------------
 *    07/18/2008    vdevarakonda      Initial class creation           
 * </pre>
 */

public class DynamicCodesTablesDAOImpl extends DynamicBaseDAOImpl implements DynamicCodesTablesDAO {
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findCodesTableDetail(String codeType, String cdSortBy, int pageNbr,
                                                               int pageSize, boolean sortAscending) {  
  StringBuffer queryBuffer = new StringBuffer(
                                              "  SELECT  CODE AS CODE, "
                                                              + "          DECODE AS DECODE, "
                                                              + "          DT_END AS DT_END "
                                                              + "          FROM (SELECT"
                                                              + "                        c.CODE, "
                                                              + "                        c.DECODE, "
                                                              + "                        c.DT_END "
                                                              + "                 FROM "
                                                              + "                  CODES_TABLES c "
                                                              + "                 WHERE c.CODE_TYPE = :codeType ");

  
  // sort and format the list with the appropriate data type for Hibernate 
  if (SORT_BY_CODE.equals(cdSortBy)) {
    if (sortAscending) {  
                queryBuffer.append(" ORDER BY c.CODE asc ");
    } else {
      queryBuffer.append(" ORDER BY c.CODE desc ");
    }
  } else if (SORT_BY_DECODE.equals(cdSortBy)) {
    if (sortAscending) {
      queryBuffer.append(" ORDER BY c.DECODE asc ");
    } else {
      queryBuffer.append(" ORDER BY c.DECODE desc ");
    }
  } else if (SORT_BY_END_DATE.equals(cdSortBy)) {
    if (sortAscending) {
      queryBuffer.append(" ORDER BY c.DECODE asc ");
    } else {
      queryBuffer.append(" ORDER BY c.DECODE desc ");
    }
  }
  queryBuffer.append(" )");
  SQLQuery query = getSession().createSQLQuery(queryBuffer.toString());
  query.setString("codeType", codeType);
  query.addScalar("CODE", Hibernate.STRING);
  query.addScalar("DECODE", Hibernate.STRING);
  query.addScalar("DT_END", Hibernate.DATE);
  return (PaginatedHibernateList<Object[]>) this.paginatedList(pageNbr, pageSize, query);
}
}
