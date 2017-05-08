package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceThirdPartyInsuranceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceThirdPartyHealthInsurance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFceThirdPartyHealthInsuranceImpl extends BaseServiceImpl implements SaveFceThirdPartyHealthInsurance {
  
  private FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO = null;
  
  public void setFceThirdPartyInsuranceDAO(FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO) {
    this.fceThirdPartyInsuranceDAO = fceThirdPartyInsuranceDAO;
  }
  
  public int saveFceThirdPartyHealthInsurance(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB) {
    FceThirdPartyInsurance fceThirdPartyInsurance = null;
    if (thirdPartyHealthInsuranceDB.hasIdFceApplication()) {
      fceThirdPartyInsurance = fceThirdPartyInsuranceDAO.findFceThirdPartyHealthInsuranceByIdFceApplication(thirdPartyHealthInsuranceDB.getIdFceApplication());
      if (fceThirdPartyInsurance == null) {
        fceThirdPartyInsurance = new FceThirdPartyInsurance();
        fceThirdPartyInsurance.setIdFceApplication((int) thirdPartyHealthInsuranceDB.getIdFceApplication());
      }
      FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                          (int) thirdPartyHealthInsuranceDB.getIdFceApplication());
      fceThirdPartyInsurance.setFceApplication(fceApplication);
    }
    fceThirdPartyInsurance = PopulateFceUtility.populateThirdPartyHealthInsurance(thirdPartyHealthInsuranceDB,
                                                                                  fceThirdPartyInsurance);
    fceThirdPartyInsuranceDAO.saveFceThirdPartyInsurance(fceThirdPartyInsurance);
    return fceThirdPartyInsurance.getIdFceApplication();
  }
}
