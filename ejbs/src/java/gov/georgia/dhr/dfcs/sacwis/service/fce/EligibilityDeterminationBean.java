package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilityDeterminationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;

/**
 */
public class EligibilityDeterminationBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "EligibilityDeterminationBean";
  
  private PostEvent postEvent = null;
 
  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
  }
  
  public EligibilityDeterminationDB read(long idStage, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();
       
      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceApplication(idStage, idEvent, idLastUpdatePerson);

      FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(lookupEjb(Fce.class));

      EligibilityDeterminationDB eligibilityDeterminationDB =
              new EligibilityDeterminationDB();

      eligibilityDeterminationDB.setFceEligibility(fceEligibilityDB);
      eligibilityDeterminationDB.setIdEvent(fceContext.getIdEvent());
      eligibilityDeterminationDB.setCdEventStatus(fceContext.getCdEventStatus(connection));

      long idFceEligibility = eligibilityDeterminationDB.getIdFceEligibility();

      //Get Principals list
      List<FcePersonDB> principalsList = PersonHelper.findPrinciples(connection, idFceEligibility, lookupEjb(Fce.class));
      eligibilityDeterminationDB.setPrincipals(principalsList);
      
      //Create a list of all members of the certified group (AU) for the Allocation Member dropdowns
      List<FcePersonDB> aUMembersList = new ArrayList<FcePersonDB>();
      //Create a list of all members who are not part of the certified group (AU) for the Deeming Responsible Individuals dropdowns
      List<FcePersonDB> nonAUMembersList = new ArrayList<FcePersonDB>();
      if (principalsList != null && principalsList.size() > 0) {
        Iterator<FcePersonDB> principalsList_it = principalsList.iterator();
        while (principalsList_it.hasNext()) {
          FcePersonDB fcePersonDB = principalsList_it.next();
          if (fcePersonDB.getIndCertifiedGroup()) {
            aUMembersList.add(fcePersonDB);
          } else {
            nonAUMembersList.add(fcePersonDB);
          }
        }
      }
      eligibilityDeterminationDB.setAUMembers(aUMembersList);
      eligibilityDeterminationDB.setNonAUMembers(nonAUMembersList);

      List reasonsNotEligible =
              ReasonNotEligibleHelper.findReasonsNotEligible(connection, idFceEligibility);

      eligibilityDeterminationDB.setReasonsNotEligible(reasonsNotEligible);
     
      return eligibilityDeterminationDB;
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  protected boolean isStepparentInHomeOfRemoval(Connection connection, long idFceEligibility, long idStage)
          throws SQLException {
    //!!! could optimize this to do this in a single special query
    List principles = PersonHelper.findPrinciples(connection, idFceEligibility, lookupEjb(Fce.class));

    Iterator iterator = principles.iterator();
    while (iterator.hasNext()) {
      FcePersonDB fcePersonDB = (FcePersonDB) iterator.next();
      String cdRelInt = fcePersonDB.getCdRelInt();

      if ((fcePersonDB.getIndPersonHmRemoval()) &&
          (PersonHelper.isStepParent(cdRelInt))) {
        return true;
      }
    }
    return false;
  }

  public void determineEligibility(EligibilityDeterminationDB eligibilityDeterminationDB)
  throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".determineEligibility");
    Connection connection = null;
    try {
      connection = getConnection();
      save(eligibilityDeterminationDB);
      
      long idFceEligibility = eligibilityDeterminationDB.getIdFceEligibility();
      FceHelper.verifyNonZero("idFceEligibility", idFceEligibility);
      
      FceEligibilityDB fceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(idFceEligibility);
      
      ReasonNotEligibleHelper.deleteReasonsNotEligible(connection, idFceEligibility);
      
      FceContext fceContext = getFceContext(eligibilityDeterminationDB);
      
      List reasonsNotEligible =
        ApplicationReasonsNotEligible.getReasonsNotEligible(connection, fceContext, lookupEjb(Fce.class));
      
      boolean indEligible = (reasonsNotEligible.isEmpty());
      // Need to fetch DB again after ApplicationReasonsNotEligible.calculate, since record have been updated
      fceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(idFceEligibility);
      fceEligibilityDB.setIndEligible(FceEligibilityDB.toCharIndicator(indEligible));
      
      List incomesForChild = IncomeHelper.findIncomeForChild(connection, idFceEligibility);
      boolean isChildReceivingSSI = false;
      for (Iterator incomesforChildIterator = incomesForChild.iterator();
      incomesforChildIterator.hasNext();
      ) {
        // child is always in the certified group, so no need to check that
        FceIncomeDB fceIncomeDB = (FceIncomeDB) incomesforChildIterator.next();
        if("SSI".equals(fceIncomeDB.getCdType())){
          isChildReceivingSSI = true;
        }
      }
      if(indEligible && isChildReceivingSSI && (!fceEligibilityDB.getIndChildCare() ||
                      (fceEligibilityDB.getIndChildCare() && (fceEligibilityDB.getIndOutOfHomeCare() ||
                                      fceEligibilityDB.getIndEmancipation() ||
                                      fceEligibilityDB.getIndAdoption())))){
        fceEligibilityDB.setIndChildReceivingSSI(isChildReceivingSSI);
      }
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);
      ReasonNotEligibleHelper.createReasonsNotEligible(reasonsNotEligible, idFceEligibility, lookupEjb(Fce.class));
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  protected FceContext getFceContext(EligibilityDeterminationDB eligibilityDeterminationDB) {
    FceContext fceContext = new FceContext();

    long idEvent = eligibilityDeterminationDB.getIdEvent();
    FceHelper.verifyNonZero("idEvent", idEvent);
    fceContext.setIdEvent(idEvent);

    long idPerson = eligibilityDeterminationDB.getIdPerson();
    FceHelper.verifyNonZero("idPerson", idPerson);
    fceContext.setIdPerson(idPerson);

    long idFceApplication = eligibilityDeterminationDB.getIdFceApplication();
    FceHelper.verifyNonZero("idFceApplication", idFceApplication);
    fceContext.setIdFceApplication(idFceApplication);

    long idFcePerson = eligibilityDeterminationDB.getIdFcePerson();
    FceHelper.verifyNonZero("idFcePerson", idFcePerson);
    fceContext.setIdFcePerson(idFcePerson);

    long idFceEligibility = eligibilityDeterminationDB.getIdFceEligibility();
    FceHelper.verifyNonZero("idFceEligibility", idFceEligibility);
    fceContext.setIdFceEligibility(idFceEligibility);

    return fceContext;
  }

  /**
   * Confirms Application (moves it into APRV) Creates a new Eligibility Event
   *
   * @return idEligibilityEvent - id of the new Eligibility Event
   */
  public long confirmEligibility(long idStage, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".confirmEligibility");
    Connection connection = null;
    int idEligibilityEvent = 0;
    boolean createdEvent = false;

    try {
      connection = getConnection();

      FceHelper.verifyNonZero("idStage", idStage);
      FceHelper.verifyNonZero("idEvent", idEvent);
      FceHelper.verifyNonZero("idLastUpdatePerson", idLastUpdatePerson);

      //This is implemented to prevent the user from getting confused
      //which reviews are tied to which application and which
      //review/application is currently used to assign system-derived
      //eligibility on eligibility summary.  This also keeps the
      //algorithm for copying eligiblity simple.  The last approved
      //application or completed review says what the new eligibility
      //summary's system-derived eligibility is.

      long incompleteReviewEvents =
              EventHelper.countIncompleteFosterCareReviewEvents(connection, EventHelper.FCE_REVIEW_TASK_CODE, idStage);

      if (incompleteReviewEvents > 0l) {
        throw new EjbValidationException(Messages.MSG_CLOSE_OPEN_FCE_REVIEWS, BasePrsException.WARNING_PRIORITY);
      }

      EventHelper.changeEventStatus(postEvent, connection, idEvent, EventHelper.COMPLETE_EVENT,
                                    EventHelper.APPROVED_EVENT);
      
      FceApplicationDB fceApplicationDB = lookupEjb(Fce.class).findApplicationByApplicationEvent(idEvent);
      
      fceApplicationDB.setDtApplicationComplete(new Date());
      lookupEjb(Fce.class).saveFceApplication(fceApplicationDB);
      
      long oldIdFceEligibility = fceApplicationDB.getIdFceEligibility();

      FceEligibilityDB previousFceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(oldIdFceEligibility);

      idEligibilityEvent =
              EventHelper.createEvent(postEvent, connection, EventHelper.FCE_ELIGIBILITY_EVENT_TYPE, idLastUpdatePerson,
                                      idStage);
      createdEvent = true;

      FceEligibilityDB fceEligibilityDB =
        EligibilityHelper.copyEligibility(lookupEjb(Fce.class), connection, previousFceEligibilityDB,
                                          idLastUpdatePerson);

      fceEligibilityDB.setIdEligibilityEvent((long) idEligibilityEvent);
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);

      //complete any todos for this application
      EventHelper.completeTodosForEventId(connection, idEvent);
      return (long) idEligibilityEvent;
    } catch (Exception e) {
      handleException(e);
      //handleException always rethrows something
      return 0l;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void save(EligibilityDeterminationDB eligibilityDeterminationDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, eligibilityDeterminationDB);

      FceEligibilityDB fceEligibilityDB = eligibilityDeterminationDB.getFceEligibility();

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
  
  public EventDB retrieveEventByIdEvent (long idEvent) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".retrieveEventByIdEvent");
    Connection connection = null;
    try {
      connection = getConnection();
      EventDB eventDB = EventHelper.findEvent(connection, idEvent);
      return eventDB;
    }  catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }
}
