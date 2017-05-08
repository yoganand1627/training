package gov.georgia.dhr.dfcs.sacwis.launcher.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.FaIndivTrainingLnchrDAO;

public class FaIndivTrainingLnchrDAOImpl extends SimpleJdbcDaoSupport implements FaIndivTrainingLnchrDAO {

  @SuppressWarnings( { "unchecked" })
  public List<Map> findFaIndivTrainingByIdPerson(Integer idPerson) {
    SingleConnectionDataSource scds = null;
    List<Map> listIdPersons = null;

    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      JdbcOperations jdbcOperations = new JdbcTemplate(scds);

      String sql = 
        "select f.cd_Indiv_Trn_Type as cdIndivTrnType, "+
        "       f.dt_indiv_trn as dtIndivTrn, " +
        "       f.id_indiv_training as idIndivTraining, " +
        "       f.id_person as idPerson, " +
        "       f.ind_indiv_trn_ec as indIndivTrnEc, " +
        "       f.nbr_indiv_trn_hrs as nbrIndivTrnHrs " +
        " from fa_indiv_training f, " +
        "     Person_Merge_View v " +
        " where f.id_person = v.id_person_output" +
        " and v.id_person_input = ?" +
        " order by f.dt_indiv_trn desc";
      
      Integer sqlParam[] = new Integer[] { idPerson };
      listIdPersons = (List<Map>) jdbcOperations.queryForList(sql, sqlParam);
      
    } catch (CannotGetJdbcConnectionException e) {
      //logger.error("While performing county decode, error connecting to the RDBMS");
      throw new ServiceException();
    } catch (DataAccessException e) {
      //logger.error("While performing county decode, error in accessing data");
      throw new ServiceException();
    } finally {
      scds.destroy();
    }

    return listIdPersons;
    
  }

}
