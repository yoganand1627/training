/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.EcemMonthMv;
import java.util.Date;

/**
 * @author Patrick Coogan
 *
 */
public interface EcemMonthMvDAO {
  /**
   * This selects a distinct ECEM month row for a child, case, and ECEM month<p/>
   *
   * @param idPerson
   * @param idCase
   * @param ecemMonth
   * @return EcemMonthMv
   */
  EcemMonthMv findEcemMonthByPersonByCaseByDate(int idPerson, int idCase, Date ecemMonth);
  
}
