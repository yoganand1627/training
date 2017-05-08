package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFceDAO;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveInitialFcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class SaveInitialFcePersonImpl extends BaseServiceImpl implements SaveInitialFcePerson {
  private ComplexFceDAO complexFceDAO = null;
  
  public void setComplexFceDAO(ComplexFceDAO complexFceDAO) {
    this.complexFceDAO = complexFceDAO;
  }
    
  public int saveInitialFcePerson(long idFceEligibility, long idPerson, String cdRelInt) {
    return complexFceDAO.saveFcePersonByIdPersonIdFceEligAndCdRelInt(idFceEligibility, idPerson, cdRelInt);
  }
  
}
