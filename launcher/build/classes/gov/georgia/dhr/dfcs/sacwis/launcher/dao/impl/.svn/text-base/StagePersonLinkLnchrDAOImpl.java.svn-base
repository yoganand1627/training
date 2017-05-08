package gov.georgia.dhr.dfcs.sacwis.launcher.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.StagePersonLinkLnchrDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class StagePersonLinkLnchrDAOImpl extends SimpleJdbcDaoSupport implements StagePersonLinkLnchrDAO {

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonByIdStageIdPersonCdStagePersTypes(int idStage, List cdStagePersTypes) {
    SingleConnectionDataSource scds = null;
    List<Map> faIndivTrainingList = null;

    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      NamedParameterJdbcOperations npJdbcOperations = new NamedParameterJdbcTemplate(scds);

      String sql = 
        " select" +
        "    p.id_Person as idPerson" +
        " from Stage_Person_Link spl, " +
        "     Person p, " +
        "     Stage s " +
        " where spl.id_Stage = s.id_Stage" +
        " and s.id_stage = :idStage" +
        " and spl.id_Person = p.id_Person" +
        " and spl.cd_Stage_Pers_Rel_Int in ( :cdStagePersTypes )";
      
      Map<String,Object> m = new HashMap<String,Object>();
      m.put("idStage", idStage);
      m.put("cdStagePersTypes", cdStagePersTypes);
      SqlParameterSource sqlParams = new MapSqlParameterSource(m);

      faIndivTrainingList = npJdbcOperations.queryForList(sql, sqlParams);
    } catch (CannotGetJdbcConnectionException e) {
      //logger.error("While performing county decode, error connecting to the RDBMS");
      throw new ServiceException();
    } catch (DataAccessException e) {
      //logger.error("While performing county decode, error in accessing data");
      throw new ServiceException();
    } finally {
      scds.destroy();
    }

    return faIndivTrainingList;

  }

}
