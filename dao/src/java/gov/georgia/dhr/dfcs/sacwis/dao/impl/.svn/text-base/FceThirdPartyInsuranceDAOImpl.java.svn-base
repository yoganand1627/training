package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.FceThirdPartyInsuranceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;

public class FceThirdPartyInsuranceDAOImpl extends BaseDAOImpl implements FceThirdPartyInsuranceDAO {

  public void saveFceThirdPartyInsurance(FceThirdPartyInsurance fceThirdPartyInsurance) {
    getSession().saveOrUpdate(fceThirdPartyInsurance);
  }

  public FceThirdPartyInsurance findFceThirdPartyHealthInsuranceByIdFceApplication(long idFceApplication) {
    Query query = getSession().createQuery(" from FceThirdPartyInsurance ft " +
                                           " where ft.idFceApplication = :idFceApplication");
    
    query.setLong("idFceApplication", idFceApplication);
    return (FceThirdPartyInsurance) firstResult(query);
  }

}
