package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;

import java.sql.Connection;
import java.util.List;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

public class DomicileDeprivationBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "DomicileDeprivationBean";

  private PostEvent postEvent = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
  }

  /** @todo add javadocs */
  public DomicileDeprivationDB read(long idStage, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();
      
      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceApplication(idStage, idEvent, idLastUpdatePerson);
      FceApplicationDB fceApplicationDB = fceContext.getFceApplicationDB(lookupEjb(Fce.class));
      FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(lookupEjb(Fce.class));

      DomicileDeprivationDB domicileDeprivationDB = new DomicileDeprivationDB();
      domicileDeprivationDB.setFceApplication(fceApplicationDB);
      domicileDeprivationDB.setFceEligibility(fceEligibilityDB);
      domicileDeprivationDB.setCdEventStatus(fceContext.getCdEventStatus(connection));

      List principles =
              PersonHelper.findPrinciples(connection, fceEligibilityDB.getIdFceEligibility(), lookupEjb(Fce.class));

      domicileDeprivationDB.setPrinciples(principles);

      EventDB eventDB = EventHelper.findEvent(connection, idEvent);
      if ((eventDB.getCdEventStatus().equals(EventHelper.PENDING_EVENT)) ||
          (eventDB.getCdEventStatus().equals(EventHelper.COMPLETE_EVENT))) {

        ApplicationReasonsNotEligible
                .calculateSystemDerivedParentalDeprivation(connection, fceApplicationDB.getCdLivingMonthRemoval(),
                                                           fceApplicationDB, fceEligibilityDB, lookupEjb(Fce.class));
      }
      domicileDeprivationDB.setFceEligibility(fceEligibilityDB);
      return domicileDeprivationDB;
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** @todo add javadoc */
  public void save(DomicileDeprivationDB domicileDeprivationDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, domicileDeprivationDB);

      FceApplicationDB fceApplicationDB = domicileDeprivationDB.getFceApplication();
      lookupEjb(Fce.class).saveFceApplication(fceApplicationDB);

      FceEligibilityDB fceEligibilityDB = domicileDeprivationDB.getFceEligibility();
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);

      EventHelper.changeEventStatus(postEvent, connection, fceApplicationDB.getIdEvent(), EventHelper.NEW_EVENT,
                                    EventHelper.PROCESS_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, fceApplicationDB.getIdEvent(), EventHelper.PROCESS_EVENT,
                                    EventHelper.PROCESS_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, fceApplicationDB.getIdEvent(), EventHelper.COMPLETE_EVENT,
                                    EventHelper.PENDING_EVENT);
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
