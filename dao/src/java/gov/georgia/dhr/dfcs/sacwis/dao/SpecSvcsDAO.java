/**
 * Created on Mar 25, 2006 at 3:33:36 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.SpecSvcs;

public interface SpecSvcsDAO {
  /**
   * Retrieves Special Service Information
   *
   * @param idResource
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<SpecSvcs> findSpecSvcsByIdResource(int idResource);

}
