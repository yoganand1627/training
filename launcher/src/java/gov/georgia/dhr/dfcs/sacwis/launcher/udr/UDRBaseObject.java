package gov.georgia.dhr.dfcs.sacwis.launcher.udr;

import java.util.HashMap;
import java.util.Map;

/**
 * Each report available for UDR (User Defined Reports) will have a corresponding
 * Java class that will implement this interface. This interface lays out the framework
 * for properly building the SQL query and the parameter map for the query that will
 * be used in creating User Defined Reports.
 *  
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   3/13/09  wjcochran  Initial file creation
 * </pre>
 */
public interface UDRBaseObject {

  /**
   * This method creates a SQL query for use in creating
   * a User-defined report (UDR) based on the parameters passed in.
   * @param params - The parameters required to build a
   * query. Currently, all UDRs will use the same parameters passed
   * in the same order (dtStart, dtEnd, Region, County, Staff ID)
   * @return - a SQL query string
   */
  public String buildSQLQuery(String[] params);
  
  /**
   * This method creates a SQL query fro use in creating
   * a User-defined report (UDR) based on the parameters
   * passed in.
   * @param params - The parameters required to build a
   * query. (i.e. - dtStart, dtEnd, etc.)
   * @return - a SQL query string
   * @since SHINES 3.5
   */
  public String buildSQLQuery(Map<String, Object> params);
  
  /**
   * This method will build a parameter map for binding
   * to the SQL query based on the parameters that are
   * passed in.
   * @param params - The parameters as they are input from
   * the user. This should be the same map used in building
   * the SQL query, otherwise problems may arise in executing
   * the query.
   * @return - a new parameter map used for biding to the query
   */
  public Map<String, Object> buildParamMap(String[] params);
  
  /**
   * This method creates a SQL query to get the row count
   * for the actual query.
   * @param params
   * @return
   */
  public String queryForRowCount(String[] params);
  
  
  public String buildSQLQueryMultiple(String[] params, String sql);
  public String queryForRowCountMultiple(String[] params, String sql);
  
  public Map<String, String> getSqlRefMapList();
}
