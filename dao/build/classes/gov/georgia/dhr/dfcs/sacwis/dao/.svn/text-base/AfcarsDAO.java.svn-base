/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Afcars;
import java.util.Map;

/**
 * @author Patrick Coogan
 *
 */
public interface AfcarsDAO {
  /**
   * This selects a unique row from the AFCARS table. for a specific child
   * and date<p/>
   *
   * @param idPerson
   * @param intMonth
   * @param intYear
   * @return Afcars
   */
  Afcars findAfcarsByPersonAndReportDate(int idPerson, String reportDateStart, String reportDateEnd);
  
  /**
   * This selects a unique row from the AFCARS table. for a specific child
   * and date<p/>
   *
   * @param idPerson
   * @param intMonth
   * @param intYear
   * @return Map
   */
  public Map findAfcarsMapByPersonAndReportDate(int idPerson,String reportDateStart, String reportDateEnd);
  }
