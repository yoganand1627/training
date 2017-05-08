package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;

public interface ExchangeHomeDAO {
  
  /**
   * Retrieves the Exchange Home Detail Object based on the event id
   *
   * @param idEvent The event id the for the Exchange Home Detail Object
   * @return The Exchange Home Detail Object
   */
  public ExchangeHome findExchangeHomeByEventId(int idEvent);
  
  /**
   * Save or Updates the Exchange Home Detail Object 
   *
   * @param home The event id the for the Exchange Home DB object
   */
  public void saveUpdatExchangeHome(ExchangeHome home);
  
  /**
   * Updates the Exchange Home Detail CdNonAvailStatus 
   *
   * @param idEvent The event id the for the Exchange Home Detail Object
   * @param cdNonAvailStatus value
   * @return 
   */
  public int updateExchangeHomeCdNonAvailStatus(int idEvent, String cdNonAvailStatus);
  
  /**
   * Updates the Exchange Home Detail dtOut field to the earliest exchange child fam link dt value
   *
   * @param idEvent The event id the for the Exchange Home Detail Object
   * @return 
   */
  public int updateExchangeHomeDateOut(int idEvent);

  /**
   * Retrieves the current Exchange Home Detail Object based on the resource id
   *
   * @param idResource The resource id the for the Exchange Home Detail Object
   * @return The Exchange Home Detail Object
   */
  public ExchangeHome findCurrentExchangeHomeRegistrationForIdResource(int idResource);
  
  String findCdNonAvlCodeByIdEvent(int idEvent);
}
