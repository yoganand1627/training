package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.naming.NamingException;

import org.grnds.facility.log.GrndsTrace;

/**
 * This is the Bean implementation used to Initialize the FCEA including the Re-Determination(Review). <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 *   06/12/09  hjbaptiste     STGAP00014214: Modified initializeFceReview() to prevent APRV Re-Determination events from being
 *                            updated with current modifications(ex. modification to a principal's income or resources)
 *   11/29/10  hnguyen        SMS#81144: Added logic to set indicator whether created event is an amended app or initial app
 *   12/15/10  hnguyen        SMS#81144: Updated to sync Application and Reimbursability until event is APRV or COMP
 *   02/16/11  hnguyen        SMS#96233: Updated to sync Reimbursability until event is APRV.
 * </pre>
 */

public class FceInitializeBean extends BaseFceSessionBean {
  // These should come from a codes table
  public static final String APPLICATION = CodesTables.CFCEAPRE_A;

  public static final String REAPPLICATION = CodesTables.CFCEAPRE_R;

  public static final String SELF = CodesTables.CRELVICT_SL;

  public static final String TRACE_TAG = "FceInitializeBean";

  protected static final String FCE_APPLICATION_TABLE = "fce_application_temp_event";

  protected static final String FCE_APPLICATION_COLUMN = "id_event";

  private PostEvent postEvent = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    this.postEvent = getService(PostEvent.class);
  }

  public void changeEventToPend(long idEvent) throws ServiceException {
    Connection connection = getConnection();
    try {
      EventHelper.changeEventStatus(postEvent, connection, idEvent, EventHelper.PROCESS_EVENT,
                                    EventHelper.PENDING_EVENT);
    } catch (Exception e) {
      SessionContext sessionContext = super.getSessionContext();
      if (sessionContext.getRollbackOnly() == false) {
        sessionContext.setRollbackOnly();
      }

      if (e instanceof ServiceException) {
        throw (ServiceException) e;
      }
      if (e instanceof RuntimeException) {
        throw (RuntimeException) e;
      }
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
    }
  }

  public EventDB findEvent(long idEvent) {
    Connection connection = getConnection();
    try {
      return EventHelper.findEvent(connection, idEvent);
    } catch (SQLException e) {
      throw new EJBException(e);
    } finally {
      cleanup(connection);
    }
  }

  public FceContext initializeFceApplication(long idStage, long idApplicationEvent, long idLastUpdatePerson)
                                                                                                            throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".initializeFceApplication");

    FceHelper.verifyNonZero("idStage", idStage);
    FceHelper.verifyNonZero("idLastUpdatePerson", idLastUpdatePerson);

    Connection connection = getConnection();
    FceApplicationDB fceApplicationDB;
    boolean createdEvent = false;

    try {
      EventDB eventDB = EventHelper.findOrCreateEvent(postEvent, connection, EventHelper.FCE_APPLICATION_EVENT_TYPE,
                                                      idApplicationEvent, idLastUpdatePerson, idStage);
      if (idApplicationEvent == 0l) {
        createdEvent = true;
        idApplicationEvent = eventDB.getIdEvent();
      }

      Fce fce = lookupEjb(Fce.class);
      fceApplicationDB = fce.findApplicationByApplicationEvent(idApplicationEvent);

      if (fceApplicationDB == null) {
        // create "semaphore" to prevent multiple fce_application records
        // from being created; this is possible when an id_event for the application
        // has been created, but the fce_application records haven't
        // (double click on event created by Stage progression from INV to SUB); 19893
        lookupEjb(SemaphoreUtility.class).createSemaphore((int) idApplicationEvent, FCE_APPLICATION_TABLE,
                                                          FCE_APPLICATION_COLUMN);

        fceApplicationDB = createFceApplicationDB(connection, APPLICATION, eventDB.getIdCase(), idApplicationEvent,
                                                  idLastUpdatePerson, idStage, null, fce);
      }

      long idFceApplication = fceApplicationDB.getIdFceApplication();
      long idFceEligibility = fceApplicationDB.getIdFceEligibility();
      FceEligibilityDB fceEligibilityDB = fce.retrieveFceEligibility(idFceEligibility);
      long idFcePerson = fceEligibilityDB.getIdFcePerson();
      long idPerson = fceApplicationDB.getIdPerson();
      // depending on eventStatus, sync application/person state
      // with other sources of data in the database
      String eventStatus = eventDB.getCdEventStatus();
      if (eventStatus.equals(EventHelper.APPROVED_EVENT) == false
                      && eventStatus.equals(EventHelper.COMPLETE_EVENT) == false) {
        FceHelper.syncFceApplicationStatus(connection, fceEligibilityDB, fceApplicationDB, fce);
      }

      FceContext fceContext = new FceContext();
      fceContext.setIdEvent(idApplicationEvent);
      fceContext.setIdPerson(idPerson);
      fceContext.setIdFceApplication(idFceApplication);
      fceContext.setIdFcePerson(idFcePerson);
      fceContext.setIdFceEligibility(idFceEligibility);
      return fceContext;
    } catch (Exception e) {
      handleException(e);
      // handleException always throws; but this is to make the compiler happy
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public FceContext initializeFceEligibility(long idStage, long idEligibilityEvent, long idLastUpdatePerson)
                                                                                                            throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".initializeFceEligibility");

    FceHelper.verifyNonZero("idStage", idStage);
    FceHelper.verifyNonZero("idLastUpdatePerson", idLastUpdatePerson);

    Connection connection = getConnection();
    FceEligibilityDB fceEligibilityDB = null;
    FceContext fceContext = new FceContext();
    boolean createdEvent = false;

    Fce fce = lookupEjb(Fce.class);
    try {
      if (idEligibilityEvent != 0l) {
        fceEligibilityDB = fce.retrieveEligibilityForEligibilityEvent(idEligibilityEvent);
      }
      // If fceEligibilityDB is null (or not found in the retrieve call above)
      // then initialize fceContext object with default values
      // and create a new eligibility event. This will often be the case when
      // this method is called in a PAD or ADO stage.
      if (fceEligibilityDB == null) {
        long idFceApplication = 0l;
        long idFceEligibility = 0l;
        long idFcePerson = 0l;
        
        //STGAP00011595 - in the ADO & PAD stages, the idPerson will need to be
        // populated to perform a placement search. Look for a placement for the
        // primary child, if none is returned, then set to the default 
        // of '01', as was previously done
        long idPerson = fce.findPrimaryChildForStage(idStage, CodesTables.CROLEALL_PC);
        if (idPerson == 0) {
          idPerson = 0l;
        }

        fceContext.setIdEvent(idEligibilityEvent);
        fceContext.setIdPerson(idPerson);
        fceContext.setIdFceApplication(idFceApplication);
        fceContext.setIdFceEligibility(idFceEligibility);
        fceContext.setIdFcePerson(idFcePerson);
        
        // create a new eligibility event
        EventDB eventDB = EventHelper.findOrCreateEvent(postEvent, connection, EventHelper.FCE_ELIGIBILITY_EVENT_TYPE,
                                                        idEligibilityEvent, idLastUpdatePerson, idStage);

        if (idEligibilityEvent == 0l) {
          createdEvent = true;
          idEligibilityEvent = eventDB.getIdEvent();
          fceContext.setIdEvent(idEligibilityEvent);
        }

        // find the last end-dated eligibility for the stage
        FceEligibilityDB lastFceEligibility = EligibilityHelper.findLatestEligibilityForStage(connection, idStage, fce);

        if (lastFceEligibility != null) {
          // copy state from old eligibility to new eligibility
          fceEligibilityDB = EligibilityHelper.copyEligibility(fce, connection, lastFceEligibility, idLastUpdatePerson);
        } else {
          fceContext.setIdFceEligibility(0);
          return fceContext;
        }

        EligibilityDB legacyEligibilityDB = null;

        if (!CodesTables.CEVTSTAT_NEW.equals(eventDB.getCdEventStatus())) {
          legacyEligibilityDB = EligibilityHelper.findLegacyEligibility(connection, idEligibilityEvent);

        }

        setChildSupportFromLegacy(legacyEligibilityDB, fceEligibilityDB);

        fceEligibilityDB.setIdEligibilityEvent(idEligibilityEvent);
        fce.saveFceEligibility(fceEligibilityDB);
      }

      EventDB eventDB = EventHelper.findEvent(connection, idEligibilityEvent);
      String eventStatus = eventDB.getCdEventStatus();
      if (eventStatus.equals(EventHelper.APPROVED_EVENT) == false) {
        FceHelper.syncFceEligibilityStatus(connection, fceEligibilityDB, fce);
      }

      if (CodesTables.CEVTSTAT_NEW.equals(eventStatus)) {
        EligibilityDB legacyEligibilityDB = EligibilityHelper
                                                             .findLatestLegacyEligibility(
                                                                                          connection,
                                                                                          eventDB.getIdCase(),
                                                                                          fceEligibilityDB
                                                                                                          .getIdPerson());
        setChildSupportFromLegacy(legacyEligibilityDB, fceEligibilityDB);
        fce.updateFceEligibilityIndChildSupportOrdered(fceEligibilityDB.getIdFceEligibility(),
                                                       fceEligibilityDB.getIndChildSupportOrderedString());
      }

      long idFceApplication = fceEligibilityDB.getIdFceApplication();
      long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
      long idFcePerson = fceEligibilityDB.getIdFcePerson();
      long idPerson = fceEligibilityDB.getIdPerson();

      fceContext.setIdEvent(idEligibilityEvent);
      fceContext.setIdPerson(idPerson);
      fceContext.setIdFceApplication(idFceApplication);
      fceContext.setIdFceEligibility(idFceEligibility);
      fceContext.setIdFcePerson(idFcePerson);
      return fceContext;
    } catch (Exception e) {
      handleException(e);

      // handleException always throws; but this is to make the compiler happy
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  private void setChildSupportFromLegacy(EligibilityDB legacyEligibilityDB, FceEligibilityDB fceEligibilityDB) {
    if ((legacyEligibilityDB != null)
        && (EligibilityHelper.isQuestionAnswered(CodesTables.CELIGCSU_030, legacyEligibilityDB))) {
      fceEligibilityDB.setIndChildSupportOrdered(ArchitectureConstants.Y);
    }
  }

  public FceContext initializeFceReview(long idStage, long idReviewEvent, long idLastUpdatePerson)
                                                                                                  throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".initializeFceReview");

    FceHelper.verifyNonZero("idStage", idStage);
    FceHelper.verifyNonZero("idLastUpdatePerson", idLastUpdatePerson);

    Connection connection = getConnection();
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    FceReviewDB fceReviewDB = new FceReviewDB();
    boolean createdEvent = false;

    try {
      Fce fce = lookupEjb(Fce.class);
      if (idReviewEvent != 0l) {
        fceReviewDB = fce.findReviewByReviewEvent(idReviewEvent);

        long idFceEligibility = fceReviewDB.getIdFceEligibility();
        fceEligibilityDB = fce.retrieveFceEligibility(idFceEligibility);
      } else {
        // create a new review event
        idReviewEvent = (long) EventHelper.createEvent(postEvent, connection, EventHelper.FCE_REVIEW_EVENT_TYPE,
                                                       idLastUpdatePerson, idStage);
        createdEvent = true;

        // find the last application with an eligibility
        FceEligibilityDB lastFceEligibility = EligibilityHelper.findLatestEligibilityForStage(connection, idStage, fce);

        if (lastFceEligibility != null) {
          fceEligibilityDB = EligibilityHelper.copyEligibility(fce, connection, lastFceEligibility, idLastUpdatePerson,
                                                               false);
          fceEligibilityDB.setIdFceReview(null);
        } else {
          EventDB eventDB = EventHelper.findEvent(connection, idReviewEvent);
          long idCase = eventDB.getIdCase();
          long idPerson = PersonHelper.findPrimaryChildForStage(connection, idStage);
          
          boolean applicationExists = false;
          applicationExists = EligibilityHelper.isChildNewToSubcare(connection, idPerson);
          if (!applicationExists) {
            //Manually rollback the transaction since it is not done automatically for checked exceptions
            getSessionContext().setRollbackOnly();
            throw new EjbValidationException(Messages.MSG_NO_APPLICATION_REVIEW_NOT_AVAILABLE,
                                               BasePrsException.WARNING_PRIORITY);
          }
          
          EligibilityDB eligibilityDB = EligibilityHelper.findLatestLegacyEligibility(connection, idCase, idPerson);
          // If an Eligibility Summary doesn't exists (either in PROC/COMP status) inform the user that
          // a Redetermination can not be done
          if (eligibilityDB == null) {
            //Manually rollback the transaction since it is not done automatically for checked exceptions
            getSessionContext().setRollbackOnly();
            throw new EjbValidationException(Messages.MSG_FCE_CHILD_NON_DFCS_PAID_ELIGIBILITY,
                                             BasePrsException.WARNING_PRIORITY);
          }
        }

        long idFceApplication = fceEligibilityDB.getIdFceApplication();
        long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
        long idCase = fceEligibilityDB.getIdCase();

        fceReviewDB.setIdCase(idCase);
        fceReviewDB.setIdEvent(idReviewEvent);
        fceReviewDB.setIdFceApplication(idFceApplication);
        fceReviewDB.setIdFceEligibility(idFceEligibility);
        fceReviewDB.setIdStage(idStage);
        fceReviewDB.setIdLastUpdatePerson(idLastUpdatePerson);

        int idFceReview = fce.saveFceReview(fceReviewDB);
        fceReviewDB.setIdFceReview((long) idFceReview);

        EventHelper.attachEventToTodo(connection, idReviewEvent, idStage, EventHelper.FCE_REVIEW_TASK_CODE);
      }

      EventDB eventDB = EventHelper.findEvent(connection, idReviewEvent);
      String eventStatus = eventDB.getCdEventStatus();
      // SMS#96233: Only sync when event is not APRV and the checkbox is not checked for no longer appropriate
      if (eventStatus.equals(EventHelper.APPROVED_EVENT) == false){
        FceHelper.syncFceReviewStatus(connection, fceEligibilityDB, fceReviewDB, fce);
      }

      long idFceApplication = fceEligibilityDB.getIdFceApplication();
      long idFceEligibility = fceEligibilityDB.getIdFceEligibility();
      long idFcePerson = fceEligibilityDB.getIdFcePerson();
      long idFceReview = fceReviewDB.getIdFceReview();
      long idPerson = fceEligibilityDB.getIdPerson();

      FceContext fceContext = new FceContext();
      fceContext.setIdEvent(idReviewEvent);
      fceContext.setIdPerson(idPerson);
      fceContext.setIdFceApplication(idFceApplication);
      fceContext.setIdFcePerson(idFcePerson);
      fceContext.setIdFceEligibility(idFceEligibility);
      fceContext.setIdFceReview(idFceReview);
      return fceContext;
    } catch (Exception e) {
      handleException(e);

      // handleException always throws; but this is to make the compiler happy
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  protected static FceEligibilityDB createFceEligibilityDB(Connection connection, long idCase, long idEvent,
                                                           long idLastUpdatePerson, long idStage, boolean forFceReview,
                                                           Fce fce) throws NamingException, CreateException,
                                                                   EjbValidationException, RemoteException,
                                                                   SQLException {
    long idPerson = PersonHelper.findPrimaryChildForStage(connection, idStage);

    FceEligibilityDB fceEligibilityDB = EligibilityHelper.createEligibility(idCase, idLastUpdatePerson, idStage);

    long idFceEligibility = (long) fce.saveInitialFceEligibility(fceEligibilityDB);
    fceEligibilityDB.setIdFceEligibility(idFceEligibility);

    FcePersonDB fcePersonDB = PersonHelper.createFcePerson(fce, idFceEligibility, idPerson, SELF, null);

    long idFcePerson = fcePersonDB.getIdFcePerson();

    fceEligibilityDB.setIdPerson(idPerson);
    fceEligibilityDB.setIdFcePerson(idFcePerson);

    // If the latest FceEligibility is not null and
    // is NTSC - New To SubCare; this eligibility is New To SubCare
    // is Impact Application; this eligibility is Impact Application
    // is CAPS - this eligibility is CAPS

    // (FYI. If you get here; latest FceEligibility is null)// If there's an existing Eligibility but no FceEligibility
    // OR there are legacy applications/reviews
    // Then
    // The child is from CAPs
    // Else
    // The child is NTSC new to subcare

    EligibilityDB eligibilityDB = EligibilityHelper.findLatestLegacyEligibility(connection, idCase, idPerson);

    boolean hasLegacyEvents = EventHelper.hasLegacyEvents(connection, idStage);

    String cdApplication = FceConstants.CAPS;
    if (hasLegacyEvents == false) {
      boolean childMarkedNewToSubcare = (eligibilityDB == null);
      if (childMarkedNewToSubcare == false) {
        // while there is no complete application/review,//there may still be an FceApplication object associated
        // with an FceEligibility object created in Shines

        childMarkedNewToSubcare = EligibilityHelper.isChildNewToSubcare(connection, idPerson);
      }

      if (childMarkedNewToSubcare) {
        if (forFceReview) {
          throw new EjbValidationException(Messages.MSG_NO_APPLICATION_REVIEW_NOT_AVAILABLE,
                                           BasePrsException.WARNING_PRIORITY);
        }
        cdApplication = FceConstants.NEW_TO_SUBCARE;
      }
    }

    String indEligibleString = null;

    if ((forFceReview) && (cdApplication.equals(FceConstants.CAPS))) {
      if (eligibilityDB == null) {
        throw new EjbValidationException(Messages.MSG_NO_SUMMARY_REVIEW_NOT_AVAILABLE,
                                         BasePrsException.WARNING_PRIORITY);
      }

      // set indEligible according to what's in latest eligibility
      String actualEligibility = eligibilityDB.getCdEligActual();
      boolean indEligible = (actualEligibility.equals(FceConstants.TITLE_IV_E));

      fceEligibilityDB.setIndEligible(ArchitectureConstants.N);
      if (indEligible) {
        fceEligibilityDB.setIndEligible(ArchitectureConstants.Y);
      }
      indEligibleString = fceEligibilityDB.getIndEligibleString();
    }

    // !!! event id is not nullable
    FceApplicationDB fceApplicationDB = createFceApplicationDB(connection, cdApplication, idCase,
    // !!! this is goofy; it's either an eligibility event or a review event
                                                               // 08/14/2003, This may be goofy, but
                                                                // FosterCareReviewBean now relies on
                                                               // it to calculate IndReviewForCapsChild
                                                               idEvent, idLastUpdatePerson, idStage, indEligibleString,
                                                               fce);

    fceEligibilityDB.setIdFceApplication(fceApplicationDB.getIdFceApplication());

    return fceEligibilityDB;
  }

  protected static FceApplicationDB createFceApplicationDB(Connection connection, String cdApplication, long idCase,
                                                           long idEvent, long idLastUpdatePerson, long idStage,
                                                           String indEligibleString, Fce fce) throws RemoteException,
                                                                                             SQLException {
    FceEligibilityDB fceEligibilityDB = new FceEligibilityDB();
    fceEligibilityDB.setIdCase(idCase);
    fceEligibilityDB.setIdLastUpdatePerson(idLastUpdatePerson);
    fceEligibilityDB.setIdStage(idStage);
    int idFceEligibility = fce.saveInitialFceEligibility(fceEligibilityDB);

    long idPerson = PersonHelper.findPrimaryChildForStage(connection, idStage);
    if (idPerson == 0l) {
      // !!! need application exception?
      throw new IllegalStateException("expected a primary child for stage: " + idStage);
    }

    FceApplicationDB fceApplicationDB = new FceApplicationDB();
    fceApplicationDB.setCdApplication(cdApplication);

    long nbrAppExists = EventHelper.countApprovedEvents(connection, EventHelper.FCE_APPLICATION_TASK_CODE, idStage);
    if (nbrAppExists > 0) {
      fceApplicationDB.setIndAmendedApp(true);
    }

    fceApplicationDB.setIdCase(idCase);
    fceApplicationDB.setIdEvent(idEvent);
    fceApplicationDB.setIdFceEligibility((long) idFceEligibility);
    fceApplicationDB.setIdLastUpdatePerson(idLastUpdatePerson);
    fceApplicationDB.setIdPerson(idPerson);
    fceApplicationDB.setIdStage(idStage);
    int idFceApplication = fce.saveInitialFceApplication(fceApplicationDB);
    fceApplicationDB.setIdFceApplication((long) idFceApplication);
    FcePersonDB fcePersonDB = new FcePersonDB();
    fcePersonDB.setIdFceEligibility((long) idFceEligibility);
    fcePersonDB.setIdPerson(idPerson);
    fcePersonDB.setCdRelInt(SELF);
    long idFcePerson = (long) fce.saveFcePerson(fcePersonDB);
    if (idFcePerson == 0l) {
      throw new IllegalStateException();
    }
    FceEligibilityDB updateFceEligibilityDB = fce.retrieveFceEligibility((long) idFceEligibility);
    updateFceEligibilityDB.setIdFceApplication((long) idFceApplication);
    updateFceEligibilityDB.setIdFcePerson(idFcePerson);
    updateFceEligibilityDB.setIdPerson(idPerson);
    updateFceEligibilityDB.setIndEligible(indEligibleString);
    fce.updateInitialFceEligibility(updateFceEligibilityDB);
    return fceApplicationDB;
  }
}

