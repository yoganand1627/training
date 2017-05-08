package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.PgmLcnsreTypsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps;


public class PgmLcnsreTypsDAOImpl extends BaseDAOImpl implements PgmLcnsreTypsDAO {

  @SuppressWarnings({"unchecked"})
  public List<PgmLcnsreTyps> findPgmLcnsreTypsByIdResource(int idResource) {
    Query query = getSession().createQuery(" from PgmLcnsreTyps plt" +
                                           " where plt.capsResource = :idResource" );
    query.setInteger("idResource", idResource);
    return (List<PgmLcnsreTyps>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public void savePgmLcnsreTyps(PgmLcnsreTyps pgmLcnsreTyps)
  {
    getSession().saveOrUpdate( pgmLcnsreTyps );
  }

  @SuppressWarnings({"unchecked"})
  public void deletePgmLcnsreTypsByIdResource(int idResource)
  {
    Query query = getSession().createQuery("delete PgmLcnsreTyps" + "  where capsResource = :idResource");
    query.setInteger("idResource", idResource);
    query.executeUpdate();
  }
}