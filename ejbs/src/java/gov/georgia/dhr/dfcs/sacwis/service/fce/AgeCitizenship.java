package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB;

public interface AgeCitizenship {
  AgeCitizenshipDB read(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException;

  void save(AgeCitizenshipDB ageCitizenshipDB) throws EjbValidationException;
}
