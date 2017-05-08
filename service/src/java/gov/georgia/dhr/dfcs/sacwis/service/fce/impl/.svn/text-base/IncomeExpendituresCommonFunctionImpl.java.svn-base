package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.service.fce.IncomeExpendituresCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class IncomeExpendituresCommonFunctionImpl extends BaseServiceImpl implements IncomeExpendituresCommonFunction {
  
  private FcePersonDAO fcePersonDAO = null;

  private FceExpendituresDAO fceExpendituresDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public FcePersonDB retrieveFcePersonByIdPerson(long idPerson) throws ServiceException {
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdPerson(idPerson);
    if (fcePerson == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFcePersonDB(fcePerson);
  }
  
  public FceExpendituresDB retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                            long idFcePerson,
                                                                                            long idPerson) {
    FceExpendituresDB fceExpendituresDB = null;
    FceExpenditures fceExpenditures = fceExpendituresDAO.findFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(
            idFceExpenditures, idFcePerson,
            idPerson);
    if (fceExpenditures == null) {
      return fceExpendituresDB;
    }
    return PopulateFceUtility.populateFceExpendituresDB(fceExpenditures);
  }
  
  public void deleteFceExpenditures(long idFceEligibility) {
    fceExpendituresDAO.deleteFceExpenditures(idFceEligibility);
  }
  
  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage){
    List<Integer> idPersonList = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
    return idPersonList;
  }

}
