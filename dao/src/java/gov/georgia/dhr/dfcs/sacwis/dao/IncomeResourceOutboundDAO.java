package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.IncomeResourceOutbound;

import java.util.Map;

public interface IncomeResourceOutboundDAO {
  
  /**
   * saves IncomeResourceOutbound record
   * @param incomeResourceOutbound
   * @return
   */
  public int saveIncomeResourceOutbound(IncomeResourceOutbound incomeResourceOutbound);
  
  /**
   * Finds idInitiator and idPerson from IncomeResourceOutbound table based in ID
   * @param idIncomeResourceOutbound
   * @return
   */
  Map findIdInitiatorAndIdPerson(int idIncomeResourceOutbound); 

}




