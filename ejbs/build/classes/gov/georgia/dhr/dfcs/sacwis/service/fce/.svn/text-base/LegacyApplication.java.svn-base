package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB;

public interface LegacyApplication {
  public LegacyApplicationDB read(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException;

  public void save(LegacyApplicationDB legacyApplicationDB) throws EjbValidationException;
}