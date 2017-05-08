package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialFceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveInitialFceExpendituresImpl extends BaseServiceImpl implements SaveInitialFceExpenditures {

  private FceExpendituresDAO fceExpendituresDAO = null;
  
  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }
  
  public int saveInitialFceExpenditures(FceExpendituresDB fceExpendituresDB) {
    FceExpenditures fceExpenditures = new FceExpenditures();
    Person person = getPersistentObject(Person.class, (int) fceExpendituresDB.getIdPerson());
    fceExpenditures.setPerson(person);
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceExpendituresDB.getIdFcePerson());
    fceExpenditures.setFcePerson(fcePerson);
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                        (int) fceExpendituresDB.getIdFceEligibility());
    fceExpenditures.setFceEligibility(fceEligibility);
    fceExpendituresDAO.saveFceExpenditures(fceExpenditures);

    return fceExpenditures.getIdFceExpenditures();
  }
}
