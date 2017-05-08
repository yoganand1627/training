package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB;

import javax.ejb.EJBLocalObject;

public interface ApplicationBackground {
  ApplicationBackgroundDB read(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException;

  void save(ApplicationBackgroundDB applicationBackgroundDB) throws EjbValidationException;
}