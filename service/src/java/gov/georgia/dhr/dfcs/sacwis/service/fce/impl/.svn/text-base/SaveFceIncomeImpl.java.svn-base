package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceIncome;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

  /**   Change History:
  *     Date      User      Description
  *    --------  --------  --------------------------------------------------
  *    01/12/09  charden   STGAP00009029 - added null check to fceIncome
  *                                                    
*/


public class SaveFceIncomeImpl extends BaseServiceImpl implements SaveFceIncome {
  
  private FceIncomeDAO fceIncomeDAO = null;
  
  private FceEligibilityDAO fceEligibilityDAO = null;
  
  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }
  
  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }
  
  public int saveFceIncome(FceIncomeDB fceIncomeDB) {
    FceIncome fceIncome = new FceIncome();
    if (fceIncomeDB.hasIdFceIncome()) {
      fceIncome = fceIncomeDAO.findFceIncomeByIdFceIncome(fceIncomeDB.getIdFceIncome()) != null 
          ? fceIncomeDAO.findFceIncomeByIdFceIncome(fceIncomeDB.getIdFceIncome()) : fceIncome;
    }
    //STGAP00009029 - added null check to fceIncome
    if (fceIncomeDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility((int) fceIncomeDB.getIdFceEligibility());
      fceIncome.setFceEligibility(fceEligibility);      
    }
    if (fceIncomeDB.hasIdFcePerson()) {
      FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceIncomeDB.getIdFcePerson());
      fceIncome.setFcePerson(fcePerson);
    }
    if (fceIncomeDB.hasIdIncRsrc()) {
      fceIncome.setIdIncRsrc((int) fceIncomeDB.getIdIncRsrc());
    }
    if (fceIncomeDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fceIncomeDB.getIdPerson());
      fceIncome.setPerson(person);
    }
    fceIncome = PopulateFceUtility.populateFceIncome(fceIncomeDB, fceIncome);
    fceIncomeDAO.saveFceIncome(fceIncome);
    int idFceIncome = fceIncome.getIdFceIncome();
    return idFceIncome;
  }

}
