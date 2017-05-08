package gov.georgia.dhr.dfcs.sacwis.launcher.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.ResourceHistoryLnchrDAO;

public class ResourceHistoryLnchrDAOImpl extends SimpleJdbcDaoSupport implements ResourceHistoryLnchrDAO {

  public Date findFirstApprovedDateForResource(int idResource) {
    SingleConnectionDataSource scds = null;
    Date firstApprovedDate = null;
    
    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      NamedParameterJdbcOperations npJdbcOperations = new NamedParameterJdbcTemplate(scds);
      
      String sql = "select min(resource_history.dt_lic_begin)" +
                   " from resource_history " +
                   " where resource_history.CD_RSHS_FA_HOME_STATUS IN (:faHomeStatusAFA, :faHomeStatusASA, :faHomeStatusATA)" +
                   " and resource_history.id_resource = :idResource" +
                   " and not EXISTS (select * " +
                   "                   From resource_history resource_history2" +
                   "                   where resource_history2.id_resource = resource_history.id_resource" +
                   "                   and resource_history2.dt_rshs_close is not null" +
                   "                   and resource_history2.id_resource_history > resource_history.id_resource_history" +
                   "                )";
      
      Map<String,Object> m = new HashMap<String, Object>();
      m.put("idResource", idResource);
      m.put("faHomeStatusAFA", "AFA");
      m.put("faHomeStatusASA", "ASA");
      m.put("faHomeStatusATA", "ATA");
      SqlParameterSource sqlParams = new MapSqlParameterSource(m);
      firstApprovedDate = (Date) npJdbcOperations.queryForObject(sql, sqlParams, Date.class);

    } catch(CannotGetJdbcConnectionException e) {
      throw new ServiceException();
    } catch(DataAccessException e) {
      throw new ServiceException();
    } finally {
      scds.destroy();
    }
    
    return firstApprovedDate;
    
  }

}
