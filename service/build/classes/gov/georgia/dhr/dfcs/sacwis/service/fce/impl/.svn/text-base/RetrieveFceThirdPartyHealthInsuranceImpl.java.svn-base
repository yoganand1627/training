package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceThirdPartyInsuranceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveFceThirdPartyHealthInsurance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveFceThirdPartyHealthInsuranceImpl extends BaseServiceImpl implements
                                                                             RetrieveFceThirdPartyHealthInsurance {
  
  private FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO = null;
  
  public void setFceThirdPartyInsuranceDAO(FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO) {
    this.fceThirdPartyInsuranceDAO = fceThirdPartyInsuranceDAO;
  }
  
  public ThirdPartyHealthInsuranceDB retrieveFceThirdPartyHealthInsurance(long idFceApplication) {
    FceThirdPartyInsurance fceThirdPartyInsurance =
            fceThirdPartyInsuranceDAO.findFceThirdPartyHealthInsuranceByIdFceApplication(idFceApplication);
    if (fceThirdPartyInsurance == null) {
      return null;
    }
    return PopulateFceUtility.populateThirdPartyHealthInsuranceDB(fceThirdPartyInsurance);
  }
}
