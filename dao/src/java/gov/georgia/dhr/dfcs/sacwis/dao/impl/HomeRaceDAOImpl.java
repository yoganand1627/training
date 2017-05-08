package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.HomeRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRace;
import gov.georgia.dhr.dfcs.sacwis.db.HomeRaceId;

import java.util.List;

import org.hibernate.Query;

/**
 * This is the DAO that contains the SQL to save and retrieve Home Race records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  08/29/08   mchillman   STGAP00010004: Initial code                
 * </pre>
 */

public class HomeRaceDAOImpl extends BaseDAOImpl implements HomeRaceDAO {

  @SuppressWarnings({"unchecked"})
  public List<HomeRace> findHomeRacesByResourceId(int idResource) {
    Query query = getSession().createQuery(" from HomeRace " +
                                           " where capsResource.idResource = :idResource ");

    query.setInteger("idResource", idResource);
    return (List<HomeRace>) query.list();
  }


  public HomeRace findHomeRacesByResourceIdAndCdRace(
			int idResource, String cdRace) {

		Query query = getSession().createQuery(
				" from HomeRace "
						+ " where id.idResource = :idResource and"
						+ " id.cdRace = :cdRace ");

		query.setInteger("idResource", idResource);
		query.setString("cdRace", cdRace);
		return (HomeRace) firstResult(query);
	}

	public void saveHomeRace(HomeRace homeRace) {
		getSession().saveOrUpdate(homeRace);
	}

	public int deleteHomeRace(HomeRaceId homeRaceId) {
		Query query = getSession().createQuery(
				" delete from HomeRace h"
						+ " where h.id.idResource = :idResource "
						+ " and h.id.cdRace = :cdRace");
		query.setInteger("idResource", homeRaceId.getIdResource());
		query.setString("cdRace", homeRaceId.getCdRace());
		return query.executeUpdate();
	}

}
