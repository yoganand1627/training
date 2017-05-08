package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;

public interface FceInitialize {
  public void changeEventToPend(long idEvent);

  public EventDB findEvent(long idEvent);

  public FceContext initializeFceApplication(long idStage, long idApplicationEvent, long idLastUpdatePerson)
          throws EjbValidationException;

  public FceContext initializeFceEligibility(long idStage, long idEligibilityEvent, long idLastUpdatePerson)
          throws EjbValidationException;

  public FceContext initializeFceReview(long idStage, long idReviewEvent, long idLastUpdatePerson)
          throws EjbValidationException;
}
