package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.AdoSiblingHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingHistory;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;

/**
 * 
 * 
 * @author Ronnie Phelps, October 6, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public class AdoSiblingHistoryDAOImpl extends BaseDAOImpl implements
		AdoSiblingHistoryDAO {

	/**
	 * find the AdoSiblingHistory records with the given event id
	 * 
	 * @param idEvent
	 * 
	 * @return List<AdoSiblingHistory>
	 */
	@SuppressWarnings( { "unchecked" })
	public List<AdoSiblingHistory> findAdoSiblingHistoryByIdEvent(int idEvent) {
	    Query query = getSession().createQuery("from AdoSiblingHistory where adoInfo.event.idEvent = :idEvent");
	    query.setInteger("idEvent", idEvent);
	    
	    return (List<AdoSiblingHistory>) query.list();
	}

	/**
	 * Save the AdoSiblingHistory record
	 * 
	 * @param adoSiblingHistory
	 */
	public void saveAdoSiblingHistory(AdoSiblingHistory adoSiblingHistory) {
		getSession().saveOrUpdate(adoSiblingHistory);
	}

}
