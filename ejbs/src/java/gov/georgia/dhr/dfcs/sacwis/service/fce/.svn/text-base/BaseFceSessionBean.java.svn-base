package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

import java.sql.Connection;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;

public class BaseFceSessionBean extends BaseServiceEjb {

   protected void handleException(Exception e)
          throws EjbValidationException {
    SessionContext sessionContext = super.getSessionContext();
    if (sessionContext.getRollbackOnly() == false) {
      sessionContext.setRollbackOnly();
    }

    if (e instanceof EjbValidationException) {
      throw (EjbValidationException) e;
    }
    if (e instanceof EJBException) {
      throw (EJBException) e;
    }
    throw new EJBException(e);
  }

  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}
