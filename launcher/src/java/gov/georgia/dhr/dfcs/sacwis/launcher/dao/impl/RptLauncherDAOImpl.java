package gov.georgia.dhr.dfcs.sacwis.launcher.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.RptLauncherDAO;

public class RptLauncherDAOImpl extends SimpleJdbcDaoSupport implements RptLauncherDAO {

  /**
   * The method is called by the jxls report job to retrieve the data for the job
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * @param sql - sql to be executed
   * @param params - the params for report tghe bind variables for the sql 
   * @return List of maps that is return by the query
   */
  public List<Map<String, Object>> performJXLSQuery(String sql, Map<String, Object> params) throws RuntimeException{
    SingleConnectionDataSource scds = null;
    List<?> queryList = null;
    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      JdbcOperations jdbcOperations = new JdbcTemplate(scds);
      NamedParameterJdbcOperations npJdbcOperations = new NamedParameterJdbcTemplate(scds);
      //TODO: May try switching params out for a SqlParameterSource
      if (params == null) {
    	  queryList = (List<?>)jdbcOperations.queryForList(sql);
      } else {
    	  queryList = (List<?>)npJdbcOperations.queryForList(sql, params);
      }
      
    } catch (CannotGetJdbcConnectionException e) {
      logger.error("When trying to perform jXLS query, cannot connect to the RDBMS");
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (DataAccessException e) {
      logger.error("When trying to perform jXLS query, a data access error occured.\n");
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
    	if (scds != null) {
    		scds.destroy();
    	}
      
    }
    List<Map<String, Object>> retList = null;
    if (queryList != null) {
      retList = copyToNewList(queryList);
    } else {
      retList = new LinkedList<Map<String,Object>>();
    }
    return retList;
  }
  

  /**
   * This method returns a properly casted List in the format List<Map<String, Object>>
   * @param oldList
   * @return newList
   */
  private List<Map<String, Object>> copyToNewList(List<?> oldList) {
    List<Map<String, Object>> newList = new LinkedList<Map<String, Object>>();
    for (Object each : oldList) {
      Map<?,?> oldMap = (Map<?,?>)each;
      Map<String, Object> newMap = copyToNewMap(oldMap);
      newList.add((Map<String, Object>) newMap);
    }
    return newList;
  }
  /**
   * This method returns a properly casted Map in the format Map<String, Object>
   * @param oldMap
   * @return newMap
   */
  private Map<String,Object> copyToNewMap(Map<?,?> oldMap) {
    Map<String, Object> newMap = new HashMap<String, Object>();
    for (Entry<?, ?> each : oldMap.entrySet()) {
    String key = (String) each.getKey();
    Object value = each.getValue();
    newMap.put(key, value);
    }
    return newMap;
  }
}
