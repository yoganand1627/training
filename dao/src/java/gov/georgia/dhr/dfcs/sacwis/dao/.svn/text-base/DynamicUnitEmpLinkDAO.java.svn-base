/* Change log
 * 
 * 	3/17/2008	aroberts	Renamed the RD_COLUMN and added the PFC_COLUMN string
*/
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DynamicUnitEmpLinkDAO {
  /**
   * These constants represent the sortable columns for the Unit Summary page.  They are mapped to particular
   * impact:sortableColumnHeader tags in UnitSummary.jsp, and that value is then checked in the impl class of this DAO
   * for proper sorting via a dynamic query built using org.hibernate.Criteria.  These values are also used as keys to
   * each Map in the List result set returned from the query, meaning they are assigned to the query in the impl class
   * of this DAO as well as used for extracting the data from the result set in RetrieveUnitSummaryImpl.
   */
  static final String INT_COLUMN = "nbrInt";
  static final String INV_COLUMN = "nbrInv";
  static final String DIV_COLUMN = "nbrDiv";
  static final String ONG_COLUMN = "nbrOng";
  static final String FC_COLUMN = "nbrFc";
  static final String ADO_COLUMN = "nbrAdo";
  static final String PAD_COLUMN = "nbrPad";
  static final String FAD_COLUMN = "nbrFad";
  static final String PFC_COLUMN = "nbrPfc";
  //Added for Showing Errors and Warnings in the Unit Summary Page
  static final String ERRORS_COLUMN = "nbrErrors";
  static final String WARNINGS_COLUMN = "nbrWarnings";
  @SuppressWarnings("serial")
  static final List<String> STAGE_COLUMNS = new ArrayList<String>() {
    {
      add(INT_COLUMN);
      add(INV_COLUMN);
      add(DIV_COLUMN);
      add(ONG_COLUMN);
      add(FC_COLUMN);
      add(ADO_COLUMN);
      add(PAD_COLUMN);
      add(FAD_COLUMN);
      add(PFC_COLUMN);
      add(ERRORS_COLUMN);
      add(WARNINGS_COLUMN);
    }
  };

  /**
   * These values are also used as keys to each Map in the List result set returned from the query, meaning they are
   * assigned to the query in the impl class of this DAO as well as used for extracting the data from the result set in
   * RetrieveUnitSummaryImpl.
   */
  static final String STAFF_ID_COLUMN = "idPerson";
  static final String EMP_BJN = "cdEmpBjnEmp";
  static final String IN_UNIT_COLUMN = "cdUnitMemberInOut";
  static final String EMP_FIRST_NAME = "nmEmployeeFirst";
  static final String EMP_MIDDLE_NAME = "nmEmployeeMiddle";
  static final String EMP_LAST_NAME = "nmEmployeeLast";

  /**
   * This method creates the single query needed for data displayed on the Unit Summary page.  It implements the
   * standard methodology for a customized sorting solution via a dynamic query using an ORDER BY clause. This dynamic
   * query is built using the org.hibernate.Criteria API so that the SQL is not hard-coded but is dynamically
   * generated.
   *
   * @param idUnit   - The single required search criteria - a unit ID (ID_UNIT column from UNIT_EMP_LINK table)
   * @param orderBy  - Should be one of this DAO's constants - represents a sortable column from the results
   * @param sortDir  - Should be either SORT_ASCENDING or SORT_DESCENDING from ServiceConstants - the direction to sort
   * @param pageNbr  - The page number currently displayed in the paginated result set
   * @param pageSize - The number of results to be displayed per page via pagination
   * @return PaginatedHibernateList<Map> - The proper paginated result set
   */
  PaginatedHibernateList<Map> findUnitSummary(int idUnit, String orderBy, String sortDir, int pageNbr, int pageSize);
}
