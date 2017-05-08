package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.RestrictedFunds;

public interface RestrictedFundsDAO {
  RestrictedFunds findByIdPerson(int idPerson);
  RestrictedFunds findByIdEvent(int idEvent);
  void save(RestrictedFunds rf);
  int updateRestrictedFundsByIdPerson(double amtCheckBal, double amtSavBal, int idPerson);
}
