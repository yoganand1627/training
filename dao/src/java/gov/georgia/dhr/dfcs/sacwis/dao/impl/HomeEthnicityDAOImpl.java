package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.HomeEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.HomeEthnicityId;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRace;

import java.util.List;

import org.hibernate.Query;

/**
 * This is the DAO that contains the SQL to save and retrieve Home Ethnicities records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  08/29/08   mchillman   STGAP00010004: Initial code                
 * </pre>
 */

public class HomeEthnicityDAOImpl extends BaseDAOImpl implements HomeEthnicityDAO {
  
  @SuppressWarnings({"unchecked"})
  public List<HomeEthnicity> findHomeEthnicitiesByResourceId(int idResource) {
    
    Query query = getSession().createQuery(" from HomeEthnicity " +
                                           " where id.idResource = :idResource ");

    query.setInteger("idResource", idResource);
    return (List<HomeEthnicity>) query.list();
  }

  public HomeEthnicity findHomeEthnicitiesByResourceIdAndCdEthnicity(int idResource,String cdEthnicity) {
	    
	    Query query = getSession().createQuery(" from HomeEthnicity " +
	                                           " where id.idResource = :idResource and" +
	                                           " id.cdEthnicity = :cdEthnicity ");

	    query.setInteger("idResource", idResource);
	    query.setString("cdEthnicity", cdEthnicity);
	    return (HomeEthnicity)firstResult(query);
 }
	  
  public void saveHomeEthnicity(HomeEthnicity homeEthnicity) {
		getSession().saveOrUpdate(homeEthnicity);
  }


  public int deleteHomeEthnicity(HomeEthnicityId homeEthnicityId) {
		Query query = getSession()
				.createQuery(
						" delete from HomeEthnicity h"
								+ " where h.id.idResource = :idResource "
								+ " and h.id.cdEthnicity = :cdEthnicity");
		query.setInteger("idResource", homeEthnicityId.getIdResource());
		query.setString("cdEthnicity", homeEthnicityId
				.getCdEthnicity());
		return query.executeUpdate();
  }
}
