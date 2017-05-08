package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------     
 *  12/18/09   arege      SMS#37206 Modified the findExchangeChildFamLinksIdPersonByResourceEventId() so that it finds linked children for given eventid and 
 *                        IND_LINK_CURRENT column set to Y, i.e this will give list of children in the Family is Now Considering section.
 * </pre>
 */

public interface ExchangeChildFamLinkDAO {

  /**
   * Find all children that are or have been linked by a resource exchange home registration given the link status: Linked or Unlinked
   * graduation)
   * 
   * @param idResourceEvent Resource Event Exchange Home Id
   * @param indLinkCurrent (take values "Y": Linked or "N": Unlinked)
   * @return List<ExchangeChildFamLink>
   */
  List<ExchangeChildFamLink> findExchangeChildFamLinksByResourceEventIdAndCurrentInd(int idResourceEvent, String indLinkCurrent);

  /**
   * Find all entries that are or have been linked by a resource exchange child registration given the link status: Linked or Unlinked
   * graduation)
   * 
   * @param idExchangeChildFamLink event id of the ExchangeChildFamLink 
   * @param cdNonSelectionRsn the non selection reason
   * @param indLinkCurrent (take values "Y": Linked or "N": Unlinked)
   * @return List<ExchangeChildFamLink>
   */
  List<ExchangeChildFamLink> findExchangeChildFamLinksByChildEventIdAndCurrentInd(int idChildEvent, String indLinkCurrent);
  
  
  int updateExchangeHomeCdNonSelectionRsnIdExchangeChildFamLin(int idExchangeChildFamLink, String cdNonSelectionRsn, String indLinkCurrent);
  
  /**
   * Save a new ExchangeChildFamLink
   * 
   * @param exchangeChildFamLink ExchangeChildFamLink object
   */
  void saveExchangeChildFamLink(ExchangeChildFamLink exchangeChildFamLink);
  
  /**
   * Retrieves a List of maps containing
   * idResource, nmResource,cdRsrcCnty, idHomeEvent,cdNonAvailCode, cdNonSelectionRsn, dtOut and dtLastUpdate 
   * given idChildRegEvent and indLinkCurrent
   * @param idChildRegEvent
   * @param indLinkCurrent
   * @return
   */
  List<Map> findExcChildFamLinksInfoByChildRegEventIdAndCurInd(int idChildRegEvent, String indLinkCurrent);
  
  /**
   * Gets the count of links or unlinks to the child given idChildRegEvent and indLinkCurrent
   * @param idChildRegEvent
   * @param indLinkCurrent
   * @return
   */
  Long countExcChildFamLinksByChildRegEventIdAndCurInd(int idChildRegEvent, String indLinkCurrent);
  
  /**
   * Gets the minimum dtOut value for all the links to the child
   * @param idChildEvent
   * @param indCurLink
   * @return
   */
  Date findMinDtOutByChildRegEventIdAndCurInd(int idChildEvent, String indCurLink);
  
  /**
   * Gets the minimum dtOut value for all the links to the Home
   * @param idHomeEvent
   * @param indCurLink
   * @return
   */
  Date findMinDtOutByHomeRegEventIdAndCurInd(int idHomeEvent, String indCurLink);
  
  /**
   * Gets the count of links or unlinks to the Home given idHomeRegEvent and indLinkCurrent
   * @param idChildRegEvent
   * @param indLinkCurrent
   * @return
   */
  Long countExcChildFamLinksByHomeRegEventIdAndCurInd(int idHomeRegEvent, String indLinkCurrent);
  
  /**
   * Gets the link record for the given child and home
   * @param idChildEvent
   * @param idHomeEvent
   * @param indLinkCurrent
   * @return
   */
  ExchangeChildFamLink findExchangeChildFamLinksByChildEventIdByHomeEventIdBYCurrentInd(int idChildEvent, int idHomeEvent, String indLinkCurrent);

  /**
   * Find all children ids that are or have been linked by a resource exchange home registration 
   * 
   * @param idResourceEvent Resource Event Exchange Home Id
   * @return List<Integer>
   */
  //SMS#37206 Modified the method so that it finds linked children for given eventid and 
  // IND_LINK_CURRENT column set to Y, i.e this will give list of children in the Family is Now Considering section.
  List<Integer> findExchangeChildFamLinksIdPersonByResourceEventId(int idResourceEvent, String indLinkCurrent);
  
  int updateExchangeHomeCdNonAvlRsnByIdExchangeChildFamLink(int idEvent, String cdNonAvailability);
  
  Integer findIdHomeRegEvenbtByIdEventChildReg(int idEventChildReg, String indLinkCurrent);
  
  List<Integer> findListIdExchangeChildFamilyLinkByIdEventHomeReg(int idEventHomeReg, String indLinkCurrent);
  
  Integer findIdExchangeChildFamilyLinkByIdEventHomeReg(int idEventHomeReg, String indLinkCurrent);
  
  String findCdNonAvlCodeByIdExchangeChildFamLink(int idExchangeChildFamLink, String indLinkCurrent);
  
  List<Integer> findIdChildRegEventByIdHomeReg(int idEventHomeReg, String indLinkCurrent);
  
  Long countIdHomeRegEventByIdEventChildReg(int idEventChildReg, String indLinkCurrent);
  
  Integer findIdExchangeChildFamilyLinkByIdEventChildReg(int idEventChildReg, String indLinkCurrent);
  
  Integer findIdEventExchangeChildReg(int idExchangeChildFamLink);
  
  /**
   * Delete the ExchangeChildFamLink record based on the event id
   * 
   * @param idResourceEvent Resource Event Exchange Home Id
   * @return int
   */
  int deleteExchangeChildFamLink(int idEvent);
  
  }
