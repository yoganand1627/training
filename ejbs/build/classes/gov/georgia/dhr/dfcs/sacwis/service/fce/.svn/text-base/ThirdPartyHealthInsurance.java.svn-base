package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;

public interface ThirdPartyHealthInsurance {
  ThirdPartyHealthInsuranceDB read(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException;

  void save(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB) throws EjbValidationException;
}