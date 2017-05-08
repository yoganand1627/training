/**
 * Created on 14th Feb, 2007 for Release 2, by Lata Lokhande.
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.PlacementReferral;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface PlacementReferralDAO {
  /**
   * This retrieves the records from Placement_referral table by using resource ID.
   * 
   * @param idResource
   * @param pageNbr
   * @param pageSize
   * @return
   */
  
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPlacementReferralByIdResource(int idResource, int pageNbr, int pageSize);
  
  /**
   * Retrieves a row from Placement_referral table by using PlacementReferral ID.
   * @param idPlacementReferral
   * @return
   */
  public PlacementReferral findPlacementReferralByIdPlacementReferral(int idPlacementReferral);
  
  /**
   * Saves data in the table
   * @param placementReferral
   */
  public void savePlacementReferral(PlacementReferral placementReferral);
}