package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialFceIncome;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveInitialFceIncomeImpl extends BaseServiceImpl implements SaveInitialFceIncome {
  
  private FceIncomeDAO fceIncomeDAO = null;
  
  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }
  
  public int saveInitialFceIncome(FceIncomeDB fceIncomeDB) {
    FceIncome fceIncome = new FceIncome();
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class, (int) fceIncomeDB.getIdFceEligibility());
    fceIncome.setFceEligibility(fceEligibility);
    Person person = getPersistentObject(Person.class, (int) fceIncomeDB.getIdPerson());
    fceIncome.setPerson(person);
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceIncomeDB.getIdFcePerson());
    fceIncome.setFcePerson(fcePerson);
    String indChild = null;
    if (fceIncomeDB.getIndChild() == true) {
      indChild = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndChild() == false) {
      indChild = ArchitectureConstants.N;
    }
    fceIncome.setIndChild(indChild);
    String indFamily = null;
    if (fceIncomeDB.getIndFamily() == true) {
      indFamily = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndFamily() == false) {
      indFamily = ArchitectureConstants.N;
    }
    fceIncome.setIndFamily(indFamily);
    String indIncomeSource = null;
    if (fceIncomeDB.getIndIncomeSource() == true) {
      indIncomeSource = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndIncomeSource() == false) {
      indIncomeSource = ArchitectureConstants.N;
    }
    fceIncome.setIndIncomeSource(indIncomeSource);
    String indResourceSource = null;
    if (fceIncomeDB.getIndResourceSource() == true) {
      indResourceSource = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndResourceSource() == false) {
      indResourceSource = ArchitectureConstants.N;
    }
    fceIncome.setIdIncRsrc((int) fceIncomeDB.getIdIncRsrc());
    fceIncome.setIndResourceSource(indResourceSource);
    fceIncome.setCdType(fceIncomeDB.getCdType());
    fceIncome.setAmtIncome(fceIncomeDB.getAmtIncome());
    fceIncome.setTxtSource(fceIncomeDB.getTxtSource());
    if (fceIncomeDB.getIndNotAccessible() == true) {
      fceIncome.setIndNotAccessible(ArchitectureConstants.Y);
    } else if (fceIncomeDB.getIndNotAccessible() == false) {
      fceIncome.setIndNotAccessible(ArchitectureConstants.N);
    }
    if (fceIncomeDB.getIndNone() == true) {
      fceIncome.setIndNone(ArchitectureConstants.Y);
    } else if (fceIncomeDB.getIndNone() == false) {
      fceIncome.setIndNone(ArchitectureConstants.N);
    }
    fceIncomeDAO.saveFceIncome(fceIncome);
    return fceIncome.getIdFceIncome();
  }
}
