package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFceExpendituresImpl extends BaseServiceImpl implements SaveFceExpenditures {
  
  private FceExpendituresDAO fceExpendituresDAO = null;
  
  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }
  
  public int saveFceExpenditures(FceExpendituresDB fceExpendituresDB) {
    FceExpenditures fceExpenditures = new FceExpenditures();
    if (fceExpendituresDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceExpendituresDB.getIdFceEligibility());
      fceExpenditures.setFceEligibility(fceEligibility);
    }
    if (fceExpendituresDB.hasIdFcePerson()) {
      FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceExpendituresDB.getIdFcePerson());
      fceExpenditures.setFcePerson(fcePerson);
    }
    if (fceExpendituresDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fceExpendituresDB.getIdPerson());
      fceExpenditures.setPerson(person);
    }
    if (fceExpendituresDB.hasIdPersonCareReceive()) {
      Person person = null;
      person = getPersistentObject(Person.class, (int) fceExpendituresDB.getIdPersonCareReceive());
      fceExpenditures.setPersonCareReceive(person);
    }
    fceExpenditures = PopulateFceUtility.populateFceExpenditures(fceExpendituresDB, fceExpenditures);
    fceExpendituresDAO.saveFceExpenditures(fceExpenditures);
    return fceExpenditures.getIdFceExpenditures();
  }

}
