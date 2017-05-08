package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingHistory;
/**
 * 
 * 
 * @author Ronnie Phelps, October 1, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public interface AdoSiblingHistoryDAO {

	/**
	 * Save the AdoSiblingHistory record
	 * 
	 * @param adoSiblingHistory
	 */
	List<AdoSiblingHistory> findAdoSiblingHistoryByIdEvent(int idEvent);	
	
	/**
	 * find the AdoSiblingHistory records with the given event id
	 * 
	 * @param idEvent
	 * 
	 * @return List<AdoSiblingHistory>
	 */
	void saveAdoSiblingHistory(AdoSiblingHistory adoSiblingHistory);


	
	
}
