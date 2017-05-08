package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;

import java.sql.Connection;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

/** @todo add javadocs */
public class AgeCitizenshipBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "AgeCitizenshipBean";

  private PostEvent postEvent = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
  }

  /** @todo add javadocs */
  public AgeCitizenshipDB read(long idStage, long idEvent, long idLastUpdatePerson) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();

      FceApplicationDB fceApplicationDB = lookupEjb(Fce.class).findApplicationByApplicationEvent(idEvent);
      FceEligibilityDB fceEligibilityDB =
              lookupEjb(Fce.class).retrieveFceEligibility(fceApplicationDB.getIdFceEligibility());
      FcePersonDB fcePersonDB =
              lookupEjb(Fce.class).findFcePersonByIdFceEligibilityAndIdPerson(fceEligibilityDB.getIdFceEligibility(),
                                                                              fceEligibilityDB.getIdPerson());

      AgeCitizenshipDB ageCitizenshipDB = new AgeCitizenshipDB();
      ageCitizenshipDB.setFceApplication(fceApplicationDB);
      ageCitizenshipDB.setFceEligibility(fceEligibilityDB);
      ageCitizenshipDB.setFcePerson(fcePersonDB);
      EventDB eventDB = EventHelper.findEvent(connection, idEvent);
      ageCitizenshipDB.setCdEventStatus(eventDB.getCdEventStatus());

      return ageCitizenshipDB;
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
  public void save(AgeCitizenshipDB ageCitizenshipDB) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, ageCitizenshipDB);

      FceApplicationDB fceApplicationDB = ageCitizenshipDB.getFceApplication();
      lookupEjb(Fce.class).saveFceApplication(fceApplicationDB);

      FceEligibilityDB fceEligibilityDB = ageCitizenshipDB.getFceEligibility();
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
