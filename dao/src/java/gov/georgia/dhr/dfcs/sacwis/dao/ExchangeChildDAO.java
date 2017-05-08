package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;

import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;

public interface ExchangeChildDAO {
  /**
   * Count the exchange child records for the given person id
   * 
   * @param idPerson - person id
   * @return Integer
   */
  public Long countExchangeChildByIdPerson(int idPerson);
  
  /**
   * Find the person id of the child for the exchange child record
   * 
   * @param idEvent - the exchange child event
   * @return Integer
   */
  public Integer findIdPersonByEventId(int idEvent);
  
  /**
   * Find the exchange child record for the given event id
   * 
   * @param idEvent - the exchange child event
   * @return ExchangeChild
   */
  public ExchangeChild findExchangeChildByEventId(int idEvent);
  
  /**
   * Updates the Exchange Child Detail CdNonAvailStatus 
   *
   * @param idEvent The event id the for the Exchange Home Detail Object
   * @param cdNonAvailStatus value
   * @return 
   */
  public int updateExchangeChildCdNonAvailStatus(int idEvent, String cdNonAvailStatus);
  
  /**
   * Updates the Exchange Child Detail dtOut field to the earliest exchange child fam link dt value
   *
   * @param idEvent The event id the for the Exchange Home Child Object
   * @return 
   */
  public int updateExchangeChildDateOut(int idEvent);
  
  /**
   * Inserts or updates an Exchange Child record
   * 
   * @param exchangeChild
   * @return 
   */
  public int saveExchangeChild(ExchangeChild excChild);
  
  /**
   * Find most recent exchange child record by id person
   * 
   * @param idPerson
   * @return ExchangeChild
   */
  public ExchangeChild findMostRecentExchangeChildRecordByIdPerson(int idPerson);
  
  /**
   * Find the cdNonAvailStatus of the child for the exchange child record
   * 
   * @param idEvent - the exchange child event
   * @return String
   */
  public String findExchangeChildNonAvailCodeByIdEvent(int idEvent);
  
  Integer findIdEventByIdChild(Integer idChild);
  
  int updateExchangeChildCdNonAvlCdByIdExchangeChildFamLink(int idEvent,String cdNonAvailability);
  
 // SMS#37215 Added to find Earliest Exchange Child that was complete (in COMP status) in the given stage.
  /**
   * 
   * @param idStage
   * @param cdEventStatuses
   * @return
   */
  public ExchangeChild findEarliestExchangeChildByIdStageEventStatus(int idStage, Collection<String> cdEventStatuses);
}
