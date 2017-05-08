package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.SpecSvcsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpecSvcs;
import org.hibernate.Query;

public class SpecSvcsDAOImpl extends BaseDAOImpl implements SpecSvcsDAO {
  @SuppressWarnings({"unchecked"})
  public List<SpecSvcs> findSpecSvcsByIdResource(int idResource) {
    Query query = getSession().createQuery(" from SpecSvcs " +
                                           " where  capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<SpecSvcs>) query.list();
  }

}
