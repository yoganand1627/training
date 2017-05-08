package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.AdoSiblingExtLnkHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSiblingExtLnkHistory;

/**
 * 
 * 
 * @author Hai Nguyen, September 14, 2011
 * 
 *         <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public class AdoSiblingExtLnkHistoryDAOImpl extends BaseDAOImpl implements AdoSiblingExtLnkHistoryDAO {

  /**
   * find the AdoSiblingExtLnkHistory records with the given event id
   * 
   * @param idEvent
   * 
   * @return List<AdoSiblingExtLnkHistory>
   */
  @SuppressWarnings({ "unchecked" })
  public List<AdoSiblingExtLnkHistory> findAdoSiblingExtLnkHistoryByIdEvent(int idEvent) {
    Query query = getSession().createQuery("from AdoSiblingExtLnkHistory where adoInfo.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);

    return (List<AdoSiblingExtLnkHistory>) query.list();
  }

  /**
   * Save the AdoSiblingExtLnkHistory record
   * 
   * @param adoSiblingExtLnkHistory
   */
  public void saveAdoSiblingExtLnkHistory(AdoSiblingExtLnkHistory adoSiblingExtLnkHistory) {
    getSession().saveOrUpdate(adoSiblingExtLnkHistory);
  }

}
