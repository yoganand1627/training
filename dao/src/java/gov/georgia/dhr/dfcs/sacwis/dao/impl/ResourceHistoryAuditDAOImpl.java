package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistoryAudit;
import org.hibernate.Query;

public class ResourceHistoryAuditDAOImpl extends BaseDAOImpl implements ResourceHistoryAuditDAO {

  @SuppressWarnings({"unchecked"})
  public List<ResourceHistoryAudit> findResourceHistoryAuditByIdResource(int idResource) {
    Query query = getSession().createQuery("     from ResourceHistoryAudit r" +
                                           "    where r.id.idAudResource = :idResource" +
                                           "      and r.id.cdRshsAudFaHomeStatus " +
                                           "                            in ('AFA', 'ASA', 'ATA')" +
                                           "      and trunc(r.id.dtRshsAudEnd) = to_date('4712/12/31', 'yyyy/mm/dd')" +
                                           " order by r.id.idResourceHistoryAud desc");
    query.setInteger("idResource", idResource);
    //query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<ResourceHistoryAudit>) query.list();
  }
}
