package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeChildrenSI;

import java.util.List;

public interface SaveExchangeHomeChildFamLink {
  
  /**
   * Save off the linked children for the Exchange Home
   * 
   * @param exchangeHomeChildren the list of children to be linked
   */
  void saveLinkedExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren);
  
  /**
   * Save off the unlinked children for the Exchange Home
   * 
   * @param exchangeHomeChildren the list of children to be unlinked
   */
  void saveUnLinkedExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren);
  
  /**
   * Updates the Exchange Home Detail dtOut field to the earliest exchange child fam link dt value
   * then Updates the Exchange Child Detail dtOut field to the earliest exchange child fam link dt value
   *    *
   * @param idEvent The event id the for the Exchange Home Detail Object
   * @return 
   */
  void updateExchangeHomeChildDateOuts(List<ExchangeHomeChildrenSI> exchangeHomeChildren);
  
  /**
   * Delete the ExchangeChildFamLink record based on the event id
   *    *
   * @param List of ExchangeChildFamLink records to delete;
   */
  public void deleteExchangeHomeChildFamLink(List<ExchangeHomeChildrenSI> exchangeHomeChildren);
}
