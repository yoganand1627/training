/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Ncands;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Patrick Coogan
 *
 */
public interface NcandsDAO {
  /**
   * This selects a unique row from the NCANDS table for a specific child
   * and stage ID<p/>
   *
   * @param idPerson
   * @param idStage
   * @return Ncands
   */
  public Ncands findNcandsByPersonAndStage(int idPerson, int idStage);
  
  /**
   * This selects a unique row from the NCANDS table for a specific child
   * and stage ID<p/>
   *
   * @param idPerson
   * @param idStage
   * @return Map
   */
  public Map findNcandsMapByPersonAndStage(int idPerson, int idStage);

/**
 * This selects the list of children with NCANDS records for a stage
 * <p/>
 *
 * @param idStage
 * @return List<Map>
 */
public List<Map> findNcandsChildrenByStage(int idStage);
}
