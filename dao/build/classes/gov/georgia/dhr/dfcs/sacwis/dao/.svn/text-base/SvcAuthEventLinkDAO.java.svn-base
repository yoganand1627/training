/**
 * Created on Mar 25, 2006 at 3:32:18 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;

public interface SvcAuthEventLinkDAO {

  /**
   * Retrieves idSvcAuth by joining SvcAuthEventLink with Event table and joining Event with the Stage table to retrieve
   * various attributes.
   * 
   * @param idSvcAuth
   * @return List of Map object with keys: cdStage, idStage, dtStageClose, idEvent, cdEventStatus, cdEventType, cdTask,
   *         idSvcAuth
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findEventStageAndIdSvcAuthByIdSvcAuth(int idSvcAuth);
  
 
/**
 * Retrieves the ServiceAuthorization record given the idStage by joining the stage , stagePersonLink and, serviceAuthorization tables
 * also checks to see if there is an application tied to the Service Authorization. 
 * @param idStage
 * @return List of Map Objects mostly containing Service Authorization attributes. 
 */
  @SuppressWarnings( { "unchecked" })
  public List<Map> findLinkedServAuthByIdStagecdProgType(int idStage, String cdSvcAuthCategory,  int idSpecNeedDet);
  
  
  /**
   * Retrieves a row from the SvcAuthEventLink table for the given (Svc Auth.)Event ID <p/>
   * 
   * @param idSvcAuthEvent
   * @return SvcAuthEventLink
   */
  SvcAuthEventLink findSvcAuthEventLinkByEventId(int idSvcAuthEvent);

  /**
   * Inserts/updates an entire row of SvcAuthEventLink table.
   * 
   * @param svcAuthEventLink
   */
  void saveSvcAuthEventLink(SvcAuthEventLink svcAuthEventLink);

  /**
   * Inserts an entire row of SvcAuthEventLink table given idEvent and idSvcAuth
   * 
   * @param idEvent
   * @param idSvcAuth
   */
  int insertSvcAuthEventLink(int idEvent, int idSvcAuth);
}
