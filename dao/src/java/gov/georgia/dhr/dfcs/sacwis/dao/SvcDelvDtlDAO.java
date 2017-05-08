/**
 * Created on Mar 25, 2006 at 3:32:04 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.SvcDelvDtl;

public interface SvcDelvDtlDAO {
  /**
   * selects the date of decision from the Svc Delivery Dtl table based on the stage id
   *
   * @param idStage
   * @return
   */
  Map findSvcDelvDtlByIdStage(int idStage);

  /**
   * This is an  update/insert for SvcDelvDtl info.
   *
   * @param svcDelvDtl
   */

  void saveSvcDelvDtl(SvcDelvDtl svcDelvDtl);
}
