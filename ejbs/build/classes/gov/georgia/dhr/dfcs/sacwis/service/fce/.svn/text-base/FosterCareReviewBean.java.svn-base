package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.sql.Connection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgeCitizenshipSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgeCitizenshipSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;

public class FosterCareReviewBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "FosterCareReviewBean";

  protected static final String LIVING_CONDITION_BOTH = CodesTables.CFCELIV_B;
  protected static final String LIVING_CONDITION_ONE = CodesTables.CFCELIV_O;
  protected static final String LIVING_CONDITION_RELATIVE = CodesTables.CFCELIV_R;
  protected static final String LIVING_CONDITION_NONE = CodesTables.CFCELIV_N;

  private PostEvent postEvent = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
  }

  /** Read data for FosterCareReviewBean; sync data with the rest of the system */
  public FosterCareReviewDB read(long idStage, long idEvent, long idLastUpdatePerson, PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();
      boolean isNewRedetermination = false;
      if (idEvent == 0l){
        isNewRedetermination = true;
      }

      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceReview(idStage, idEvent, idLastUpdatePerson);

      // Do a Prefill using the latest FCE Application only if we have just clicked on the 'Add' button
      // on the FCE Redetermination List page. At that point the Redetermination Event will not exist
      // and as a result, the processing to do the Prefill will execute
      EventDB eventDB = EventHelper.findEvent(connection, fceContext.getIdEvent());
      
      if (isNewRedetermination || EventHelper.PENDING_EVENT.equals(eventDB.hasCdEventStatus())){
        FceDataPrefillSI fceDataPrefillSI = new FceDataPrefillSI();
        fceDataPrefillSI.setUlIdEvent(fceContext.getIdEvent());
        fceDataPrefillSI.setUlIdStage(idStage);
        // do not set SI cdApplication as redetermination is based off of most recent FCA
        // that could be an Initial, Amended, or NOC
        lookupEjb(Fce.class).doFceDataPrefill(fceDataPrefillSI);
      }
      FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(lookupEjb(Fce.class));
      FcePersonDB fcePersonDB = fceContext.getFcePersonDBByIdFcePerson(lookupEjb(Fce.class));
      FceReviewDB fceReviewDB = fceContext.getFceReviewDB(lookupEjb(Fce.class));

      //set entity databeans on foster care review
      FosterCareReviewDB fosterCareReviewDB = new FosterCareReviewDB();
      fosterCareReviewDB.setFceEligibility(fceEligibilityDB);
      fosterCareReviewDB.setFceReview(fceReviewDB);
      fosterCareReviewDB.setFcePerson(fcePersonDB);
      fosterCareReviewDB.setCdEventStatus(fceContext.getCdEventStatus(connection));

      //copy medicaid/SSN
      long idPerson = fceContext.getIdPerson();
      fosterCareReviewDB.setNbrMedicaid(PersonHelper.findMedicaid(connection, idPerson));
      fosterCareReviewDB.setNbrSocialSecurity(PersonHelper.findSsn(connection, idPerson));
      fosterCareReviewDB.setNmPersonFull(PersonHelper.findNmPersonFull(connection, idPerson));
      fosterCareReviewDB.setNbrCrsId(PersonHelper.findCrsId(connection, idPerson));
      fosterCareReviewDB.setNbrMhn(PersonHelper.findMhn(connection, idPerson));

      //set employee fields
      PersonDB employeeDB = PersonHelper.findPrimaryWorkerForStage(connection, idStage);
      fosterCareReviewDB.setNbrEmployeePersonPhone(employeeDB.getNbrPersonPhone());
      fosterCareReviewDB.setNmEmployeePersonFull(employeeDB.getNmPersonFull());

      //set cdLivingMonthRemoval and cdApplication
      FceApplicationDB fceApplicationDB = fceContext.getFceApplicationDB(lookupEjb(Fce.class));

      fosterCareReviewDB.setCdLivingMonthRemoval(fceApplicationDB.getCdLivingMonthRemoval());
      fosterCareReviewDB.setCdApplication(fceApplicationDB.getCdApplication());

      //nbrAgeYears, nbrAgeMonths
      long nbrAgeYears = 0l;
      long nbrAgeMonths = 0l;
      Date dtBirth = fosterCareReviewDB.getDtBirth();
      Date dtReviewComplete = fosterCareReviewDB.getDtReviewComplete();

      Date dtAgeCalculated = new Date();
      if (dtReviewComplete != null) {
        dtAgeCalculated = dtReviewComplete;
      }
      if (dtBirth != null) {
        nbrAgeMonths = DateUtility.getAgeInMonths(dtBirth, dtAgeCalculated);
        nbrAgeYears = nbrAgeMonths / 12;
        nbrAgeMonths = nbrAgeMonths % 12;
      }
      fosterCareReviewDB.setNbrAgeYears(nbrAgeYears);
      fosterCareReviewDB.setNbrAgeMonths(nbrAgeMonths);

      long idFceEligibility = fceContext.getIdFceEligibility();
      long idFcePerson = fcePersonDB.getIdFcePerson();

      // Get income lists on foster care review
      List<FceIncomeDB> incomeForChild = IncomeHelper.findIncomeForChild(connection, idFceEligibility);
      List<FceIncomeDB> resourcesForChild = IncomeHelper.findResourcesForChild(connection, idFceEligibility);
      // Set income lists on foster care review
      fosterCareReviewDB.setIncomeForChild(incomeForChild);
      fosterCareReviewDB.setResourcesForChild(resourcesForChild);
      // Get and set child care expenditures on foster care review
      List<FceExpendituresDB> expenditures = IncomeHelper.findFceExpendituresForChild(connection, idFceEligibility, idFcePerson);
      fosterCareReviewDB.setExpenditures(expenditures);
      //set reasonsNotEligible
      List<FceReasonNotEligibleDB> reasonsNotEligible =
              ReasonNotEligibleHelper.findReasonsNotEligible(connection, idFceEligibility);

      fosterCareReviewDB.setReasonsNotEligible(reasonsNotEligible);

      //set original application's eligibility status
      long idFceApplication = fceContext.getIdFceApplication();
      boolean indEligible = ApplicationHelper.getApplicationEligible(connection, idFceApplication, lookupEjb(Fce.class));

      fosterCareReviewDB.setIndOriginalApplicationEligible(indEligible);

      //set multiple placement indicator
      List placements = PlacementHelper.findActivePlacements(connection, idPerson);
      fosterCareReviewDB.setIndMultipleActivePlacements(placements.size() > 1);

      FceEligibilityDB fceEligibilityDbOld = EligibilityHelper.findEligibilityByIdFceApplication(connection, idFceApplication, lookupEjb(Fce.class));
      long idFceEligibilityOld = fceEligibilityDbOld.getIdFceEligibility();

      List principles =
        PersonHelper.findPrinciples(connection, idFceEligibilityOld, lookupEjb(Fce.class));

      fosterCareReviewDB.setPrinciples(principles);

      return fosterCareReviewDB;
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Prematurely close the eligibility; logic is similar to submit */
  public void closeEligibility(FosterCareReviewDB fosterCareReviewDB) throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".closeEligibility");
    Connection connection = null;
    try {
      connection = getConnection();
      save(fosterCareReviewDB, false);

      long idEvent = fosterCareReviewDB.getIdEvent();
      FceHelper.verifyNonZero("idEvent", idEvent);

      Set<String> statuses = new HashSet<String>();
      statuses.add(EventHelper.NEW_EVENT);
      statuses.add(EventHelper.PROCESS_EVENT);
      statuses.add(EventHelper.PENDING_EVENT);
      statuses.add(EventHelper.COMPLETE_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, idEvent, statuses, EventHelper.APPROVED_EVENT, "Reimbursability Determination is no longer appropriate.");

      //complete any todos for this review
      EventHelper.completeTodosForEventId(connection, idEvent);
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** save data in bean */
  public void save(FosterCareReviewDB fosterCareReviewDB)
          throws EjbValidationException {
    save(fosterCareReviewDB, true);
  }

  /** save data in bean; change eventStatus to PROC if it's true */
  protected void save(FosterCareReviewDB fosterCareReviewDB, boolean changeEventStatus)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, fosterCareReviewDB);

      long idEvent = fosterCareReviewDB.getIdEvent();
      FceHelper.verifyNonZero("idEvent", idEvent);

      FceReviewDB fceReviewDB = fosterCareReviewDB.getFceReview();
      long idFceReview = fceReviewDB.getIdFceReview();
      if (idFceReview == 0) {
        return;
      } else {
        lookupEjb(Fce.class).saveFceReview(fceReviewDB);
      }

      FceEligibilityDB fceEligibilityDB = fosterCareReviewDB.getFceEligibility();
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);

      IncomeHelper.saveIncome(fosterCareReviewDB.getIncomeForChild(), lookupEjb(Fce.class));
      IncomeHelper.saveIncome(fosterCareReviewDB.getResourcesForChild(), lookupEjb(Fce.class));

      IncomeHelper.saveExpenditures(fosterCareReviewDB.getExpenditures(), lookupEjb(Fce.class));

      if (changeEventStatus) {
        EventHelper.changeEventStatus(postEvent, connection, idEvent, EventHelper.NEW_EVENT, EventHelper.PROCESS_EVENT);
        EventHelper.changeEventStatus(postEvent, connection, idEvent, EventHelper.PROCESS_EVENT, EventHelper.PROCESS_EVENT);
      }

    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void submit(FosterCareReviewDB fosterCareReviewDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".submit");
    Connection connection = null;
    try {
      connection = getConnection();
      save(fosterCareReviewDB, true);

      long idEvent = fosterCareReviewDB.getIdEvent();
      FceHelper.verifyNonZero("idEvent", idEvent);

      //07/09/2003, Matthew McClain,//TodoConversation now handles moving event to PEND

      //complete any todos for this review
      EventHelper.completeTodosForEventId(connection, idEvent);
      
      EventHelper.changeEventStatus(postEvent, connection, idEvent, EventHelper.PROCESS_EVENT,
                                    EventHelper.PENDING_EVENT);

    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** calculate eligibility/reasons not eligible */
  public void determineEligibility(FosterCareReviewDB fosterCareReviewDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".determineEligibility");
    Connection connection = null;
    try {
      connection = getConnection();
      save(fosterCareReviewDB);

      long idFceEligibility = fosterCareReviewDB.getIdFceEligibility();
      FceHelper.verifyNonZero("idFceEligibility", idFceEligibility);

      long idFceReview = fosterCareReviewDB.getIdFceReview();
      FceHelper.verifyNonZero("idFceReview", idFceReview);

      FceEligibilityDB fceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(idFceEligibility);

      FceReviewDB fceReviewDB =
        lookupEjb(Fce.class).retrieveFceReview(idFceReview);

      FceHelper.syncFceReviewStatus(connection, fceEligibilityDB, fceReviewDB, lookupEjb(Fce.class));

      //put any additional error checking required here
      //before reasons not eligible
      ReasonNotEligibleHelper.deleteReasonsNotEligible(connection, idFceEligibility);

      //pretty much copied from EligibilityDeterminationBean
      FceContext fceContext = getFceContext(fosterCareReviewDB);

      //calculate sets the flags for the 3 (as of December 2010: MR-053) system-calculated reasons not eligible
      ApplicationReasonsNotEligible.calculate(lookupEjb(Fce.class), connection, fceContext);

      // calculations as a Notification of Change
      List reasonsNotEligible =
        ReviewReasonsNotEligible.getReasonsNotEligible(lookupEjb(Fce.class), fceContext);


      boolean indEligible = (reasonsNotEligible.isEmpty());
      // Need to fetch DB again after ApplicationReasonsNotEligible.calculate, since record have been updated
      fceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(idFceEligibility);
      fceEligibilityDB.setIndEligible(FceEligibilityDB.toCharIndicator(indEligible));

      // Copied from the EligibilityDeterminationBean
      List<FceIncomeDB> incomesForChild = IncomeHelper.findIncomeForChild(connection, idFceEligibility);
      boolean isChildReceivingSSI = false;
      for (Iterator<FceIncomeDB> incomesforChildIterator = incomesForChild.iterator();
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

      EventHelper.changeEventStatus(postEvent, connection, fceContext.getIdEvent(), EventHelper.PENDING_EVENT,
                                    EventHelper.COMPLETE_EVENT);
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** create a FceContext based on ids in the FosterCareReviewDB */
  protected FceContext getFceContext(FosterCareReviewDB fosterCareReviewDB) {
    FceContext fceContext = new FceContext();

    long idEvent = fosterCareReviewDB.getIdEvent();
    FceHelper.verifyNonZero("idEvent", idEvent);
    fceContext.setIdEvent(idEvent);

    long idPerson = fosterCareReviewDB.getIdPerson();
    FceHelper.verifyNonZero("idPerson", idPerson);
    fceContext.setIdPerson(idPerson);

    long idFceApplication = fosterCareReviewDB.getIdFceApplication();
    FceHelper.verifyNonZero("idFceApplication", idFceApplication);
    fceContext.setIdFceApplication(idFceApplication);

    long idFcePerson = fosterCareReviewDB.getIdFcePerson();
    FceHelper.verifyNonZero("idFcePerson", idFcePerson);
    fceContext.setIdFcePerson(idFcePerson);

    long idFceEligibility = fosterCareReviewDB.getIdFceEligibility();
    FceHelper.verifyNonZero("idFceEligibility", idFceEligibility);
    fceContext.setIdFceEligibility(idFceEligibility);

    long idFceReview = fosterCareReviewDB.getIdFceReview();
    FceHelper.verifyNonZero("idFceReview", idFceReview);
    fceContext.setIdFceReview(idFceReview);

    return fceContext;
  }


  /** perform logic to confirm the eligibility and close the review */
  public long confirm(FosterCareReviewDB fosterCareReviewDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".confirm");
    Connection connection = null;
    boolean createdEvent = false;
    long idEligibilityEvent = 0;

    try {
      connection = getConnection();
      save(fosterCareReviewDB, false);

      long idFceReview = fosterCareReviewDB.getIdFceReview();
      FceHelper.verifyNonZero("idFceReview", idFceReview);

      long idEvent = fosterCareReviewDB.getIdEvent();
      FceHelper.verifyNonZero("idEvent", idEvent);

      FceReviewDB fceReviewDB = lookupEjb(Fce.class).retrieveFceReview(idFceReview);
      fceReviewDB.setDtReviewComplete(new Date());

      EventHelper.changeEventStatus(postEvent, connection, idEvent, EventHelper.COMPLETE_EVENT,
                                    EventHelper.APPROVED_EVENT);

      long previousIdFceEligibility =
              fceReviewDB.getIdFceEligibility();

      FceEligibilityDB previousFceEligibilityDB = lookupEjb(Fce.class).retrieveFceEligibility(previousIdFceEligibility);

      long idStage = fceReviewDB.getIdStage();

      long idLastUpdatePerson =
              fceReviewDB.getIdLastUpdatePerson();

      //!!! duplicated from EligibilityDeterminationBean.confirm
      idEligibilityEvent =
              EventHelper.createEvent(postEvent, connection, EventHelper.FCE_ELIGIBILITY_EVENT_TYPE, idLastUpdatePerson,
                                      idStage);
      createdEvent = true;

      FceEligibilityDB fceEligibilityDB =
              EligibilityHelper.copyEligibility(lookupEjb(Fce.class), connection, previousFceEligibilityDB,
                                                idLastUpdatePerson);

      fceEligibilityDB.setIdEligibilityEvent(idEligibilityEvent);
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);

      //complete any todos for this review
      EventHelper.completeTodosForEventId(connection, idEvent);
      lookupEjb(Fce.class).saveFceReview(fceReviewDB);
      return idEligibilityEvent;
    }
    catch (Exception e) {
      handleException(e);
      //handleException always rethrows something
      return 0;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** delegates to FceHelper.trace(); */
  public void trace(String string) {
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }

  private static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }
}
