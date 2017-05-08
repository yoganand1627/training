package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;

import java.sql.Connection;
import java.util.List;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

public class ThirdPartyHealthInsuranceBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "ThirdPartyHealthInsuranceBean";

  private PostEvent postEvent = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
  }

  /** @todo add javadocs */
  public ThirdPartyHealthInsuranceDB read(long idStage, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();
      
      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceApplication(idStage, idEvent, idLastUpdatePerson);

      FceApplicationDB fceApplicationDB = fceContext.getFceApplicationDB(lookupEjb(Fce.class));
      // FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(fce);
      //   FcePersonDB fcePersonDB = fceContext.getFcePersonDB(fce, connection);

      ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB =
        lookupEjb(Fce.class).retrieveFceThirdPartyHealthInsurance(fceApplicationDB.getIdFceApplication());
      if (thirdPartyHealthInsuranceDB == null) {
        thirdPartyHealthInsuranceDB = new ThirdPartyHealthInsuranceDB();
      }
      thirdPartyHealthInsuranceDB.setFceApplication(fceApplicationDB);

      thirdPartyHealthInsuranceDB.setCdEventStatus(fceContext.getCdEventStatus(connection));
      List principles = PersonHelper.findPrinciples(connection, fceApplicationDB.getIdFceEligibility(), lookupEjb(Fce.class));

      thirdPartyHealthInsuranceDB.setPrinciples(principles);

      //set employee fields
      PersonDB employeeDB = PersonHelper.findPrimaryWorkerForStage(connection, idStage);
      thirdPartyHealthInsuranceDB.setNbrEmployeePersonPhone(employeeDB.getNbrPersonPhone());
      thirdPartyHealthInsuranceDB.setNmEmployeePersonFull(employeeDB.getNmPersonFull());

      return thirdPartyHealthInsuranceDB;
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** @todo add javadocs */
  public void save(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, thirdPartyHealthInsuranceDB);

      lookupEjb(Fce.class).saveFceThirdPartyHealthInsurance(thirdPartyHealthInsuranceDB);
      //List principles = PersonHelper.findPrinciples(connection, thirdPartyHealthInsuranceDB.getIdFceEligibility(),
      //                                              lookupEjb(Fce.class));
      List principles = thirdPartyHealthInsuranceDB.getPrinciples();
      PersonHelper.updateFcePersons(principles, lookupEjb(Fce.class));

      EventHelper.changeEventStatus(postEvent, connection, thirdPartyHealthInsuranceDB.getIdEvent(),
                                    EventHelper.NEW_EVENT, EventHelper.PROCESS_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, thirdPartyHealthInsuranceDB.getIdEvent(), EventHelper.PROCESS_EVENT,
                                    EventHelper.PROCESS_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, thirdPartyHealthInsuranceDB.getIdEvent(),
                                    EventHelper.COMPLETE_EVENT, EventHelper.PENDING_EVENT);
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
