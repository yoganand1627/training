package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;

public class ComplexPersonCategoryDAOImpl extends BaseDAOImpl implements ComplexPersonCategoryDAO {
  private PersonCategoryDAO personCategoryDAO = null;

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void insertPersonCategory(PersonCategory personCategory) {
    //We should only create a new Person Category record if one does not already exist;
    //so we have to first check the table and get a count
    if (0 == personCategoryDAO.countPersonCategoryIdPersonCategory(personCategory.getPerson().getIdPerson(),
                                                                   personCategory.getCdPersonCategory())) {
      personCategoryDAO.savePersonCategory(personCategory);
    }
  }

}