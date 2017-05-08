package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.sql.Connection;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;

public class LegacyApplicationBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "LegacyApplicationBean";
  private PostEvent postEvent = null;

  protected void onEjbCreate() throws CreateException {
    postEvent = getService(PostEvent.class);
  }

  public LegacyApplicationDB read(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();
      
      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceReview(idStage, idEvent, idLastUpdatePerson);

      //get original application's eligibility
      long idFceApplication = fceContext.getIdFceApplication();

      FceEligibilityDB applicationFceEligibilityDB =
              EligibilityHelper.findEligibilityByIdFceApplication(connection, idFceApplication, lookupEjb(Fce.class));

      FceEligibilityDB applicationFceEligibilityDB1 = new FceEligibilityDB();
      applicationFceEligibilityDB.copyInto(applicationFceEligibilityDB1);

      LegacyApplicationDB legacyApplicationDB = new LegacyApplicationDB();
      legacyApplicationDB.setFceEligibility(applicationFceEligibilityDB1);
      legacyApplicationDB.setIdEvent(fceContext.getIdEvent());
      legacyApplicationDB.setCdEventStatus(fceContext.getCdEventStatus(connection));

      return legacyApplicationDB;
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void save(LegacyApplicationDB legacyApplicationDB) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, legacyApplicationDB);

      FceEligibilityDB fceEligibilityDB = legacyApplicationDB.getFceEligibility();

      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }
}
