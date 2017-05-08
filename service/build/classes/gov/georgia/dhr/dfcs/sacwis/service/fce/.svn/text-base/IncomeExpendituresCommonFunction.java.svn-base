package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

import java.util.List;

public interface IncomeExpendituresCommonFunction {
  
  /**
   * This retrieves a record from the FCE_PERSON table for idPerson.
   * 
   * @param long idPerson
   * @return FcePersonDB
   */  
  public FcePersonDB retrieveFcePersonByIdPerson(long idPerson) throws ServiceException ;
  
  /**
   * This retrieves the data from the FCE_EXPENDITURES table
   * @param idFceExpenditures, idFcePerson, idPerson
   * @return FceExpendituresDB
   */
  public FceExpendituresDB retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                            long idFcePerson,
                                                                                            long idPerson);
  /**
   * This deletes the data from the FCE_EXPENDITURES table
   * @param idFceEligibility
   */
  public void deleteFceExpenditures(long idFceEligibility);
  
  /**
   * Retrieves list of idPersons from Stage_Person_Link table by idStage and CdStagePersRole As 'SE'
   *
   * @param idStage
   * @return List<Integer>
   */  
  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage);
}
