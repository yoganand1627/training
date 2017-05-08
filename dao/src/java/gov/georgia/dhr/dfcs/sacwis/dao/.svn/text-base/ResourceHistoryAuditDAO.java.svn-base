/**
 * Created on Mar 25, 2006 at 3:26:19 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistoryAudit;

public interface ResourceHistoryAuditDAO {

  /**
   * Retrieves a list of ResourceHistoryAudit by idResource , cdRshsAudFaHomeStatus and  dtRshsAudEnd
   *
   * @param idResource
   * @param szCdRsrcFaHomeStatus - APPROVED FULL ACTIVE, APPROVED TEMP ACTIVE, APPROVED SPECIAL ACTIVE
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<ResourceHistoryAudit> findResourceHistoryAuditByIdResource(int idResource);
}
