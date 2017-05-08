package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;

public interface FosterCareReview {
  public FosterCareReviewDB read(long idStage, long idEvent, long idLastUpdatePerson, 
                                 PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO) throws EjbValidationException;

  public void save(FosterCareReviewDB fosterCareReviewDB) throws EjbValidationException;

  public void submit(FosterCareReviewDB fosterCareReviewDB) throws EjbValidationException;

  public void determineEligibility(FosterCareReviewDB fosterCareReviewDB) throws EjbValidationException;

  public long confirm(FosterCareReviewDB fosterCareReviewDB) throws EjbValidationException;

  public void closeEligibility(FosterCareReviewDB fosterCareReviewDB) throws EjbValidationException;

  public void updateSystemDerivedParentalDeprivation(long idReviewEvent) throws EjbValidationException;
}