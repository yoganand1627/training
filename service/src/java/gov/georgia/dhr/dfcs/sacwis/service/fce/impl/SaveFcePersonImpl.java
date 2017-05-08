package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveFcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveFcePersonImpl extends BaseServiceImpl implements SaveFcePerson {

  private FcePersonDAO fcePersonDAO = null;
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public int saveFcePerson(FcePersonDB fcePersonDB) {
    FcePerson fcePerson = null;
    //FcePerson fcePerson = new FcePerson();
    /*if (fcePersonDB.hasIdFcePerson()) {
      fcePerson = getPersistentObject(FcePerson.class, (int) fcePersonDB.getIdFcePerson());
    }*/
    fcePerson = fcePersonDAO.findFcePersonByIdFceEPerson(fcePersonDB.getIdFcePerson());
    if(fcePerson == null){
      fcePerson = new FcePerson();
    }
    if (fcePersonDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fcePersonDB.getIdFceEligibility());
      fcePerson.setFceEligibility(fceEligibility);
    }
    if (fcePersonDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fcePersonDB.getIdPerson());
      fcePerson.setPerson(person);
    }
    fcePerson = PopulateFceUtility.populateFcePerson(fcePersonDB, fcePerson);
    fcePersonDAO.saveFcePerson(fcePerson);
    return fcePerson.getIdFcePerson();
  }
}
