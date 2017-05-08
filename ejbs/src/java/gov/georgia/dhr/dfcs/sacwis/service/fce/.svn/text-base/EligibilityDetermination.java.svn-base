package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;

public interface EligibilityDetermination {
  public EligibilityDeterminationDB read(long idStage, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException;

  public void save(EligibilityDeterminationDB eligibilityDeterminationDB) throws EjbValidationException;

  public void determineEligibility(EligibilityDeterminationDB eligibilityDeterminationDB) throws EjbValidationException;

  public long confirmEligibility(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException;
  
  public EventDB retrieveEventByIdEvent (long idEvent) throws EjbValidationException;
}