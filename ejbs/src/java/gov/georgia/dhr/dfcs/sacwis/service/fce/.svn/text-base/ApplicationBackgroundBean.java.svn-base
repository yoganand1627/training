package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

public class ApplicationBackgroundBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "ApplicationBackgroundBean";

  private PostEvent postEvent = null;
  
  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
  }
  
  public ApplicationBackgroundDB read(long idStage, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    
    try {
      connection = getConnection();
      boolean isNewApplication = false;
      if (idEvent == 0l){
        isNewApplication = true;
      }

      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceApplication(idStage, idEvent, idLastUpdatePerson);

      FceApplicationDB fceApplicationDB = fceContext.getFceApplicationDB(lookupEjb(Fce.class));

      FcePersonDB fcePersonDB = fceContext.getFcePersonDBByIdFcePerson(lookupEjb(Fce.class));

      ApplicationBackgroundDB applicationBackgroundDB = new ApplicationBackgroundDB();
      applicationBackgroundDB.setFceApplication(fceApplicationDB);
      applicationBackgroundDB.setFcePerson(fcePersonDB);
      applicationBackgroundDB.setCdEventStatus(fceContext.getCdEventStatus(connection));
      
      String eventStatus = fceContext.getCdEventStatus(connection);
      if( EventHelper.APPROVED_EVENT.equals(eventStatus) == false
                      && CodesTables.CFCEAPRE_A.equals(fceApplicationDB.getCdApplication()) ){
        applicationBackgroundDB.setIndAmendedApp(lookupEjb(Fce.class).checkIfCompletedFceaExist(idStage));
      }
      
      long idPerson = fceContext.getIdPerson();
      applicationBackgroundDB.setNbrCrsId(PersonHelper.findCrsId(connection, idPerson));
      applicationBackgroundDB.setNbrSocialSecurity(PersonHelper.findSsn(connection, idPerson));
      applicationBackgroundDB.setNbrMhn(PersonHelper.findMhn(connection, idPerson));
      applicationBackgroundDB.setNmPersonFull(PersonHelper.findNmPersonFull(connection, idPerson));
      String medAppMonth = PersonHelper.findMedAppMonth(connection, fceApplicationDB.getIdCase());
      if("".equals(medAppMonth) || medAppMonth == null){
        medAppMonth = PersonHelper.findMedAppMonthAsPlcmtDate(connection, fceApplicationDB.getIdPerson());
      }
      applicationBackgroundDB.setMedAppMonth(medAppMonth);
     
      List principles =
              PersonHelper.findPrinciples(connection, fceApplicationDB.getIdFceEligibility(), lookupEjb(Fce.class));

      applicationBackgroundDB.setPrinciples(principles);
      List placements =
              PlacementHelper.findRecentPlacements(connection, idStage);

      applicationBackgroundDB.setPlacements(placements);

      //set employee fields
      PersonDB employeeDB = PersonHelper.findPrimaryWorkerForStage(connection, idStage);
      applicationBackgroundDB.setNbrEmployeePersonPhone(employeeDB.getNbrPersonPhone());
      applicationBackgroundDB.setNmEmployeePersonFull(employeeDB.getNmPersonFull());

      return applicationBackgroundDB;
    } catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      return null;
    } finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void save(ApplicationBackgroundDB applicationBackgroundDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, applicationBackgroundDB);

      FceApplicationDB fceApplicationDB = applicationBackgroundDB.getFceApplication();

      long idFceApplication = fceApplicationDB.getIdFceApplication();
      if (idFceApplication == 0l) {
        return;
      } else {
        idFceApplication = lookupEjb(Fce.class).saveFceApplication(fceApplicationDB);

      }
      // ApplicationHelper.saveApplication(fce,fceApplicationDB);

      List principles = applicationBackgroundDB.getPrinciples();
      String indNoc = "";
      PersonHelper.saveFcePersons(principles, lookupEjb(Fce.class));

      int numberCertifiedPeople = 0;
      int numberPeopleLivingInHomeOfRemoval = 0;

      Iterator iterator = principles.iterator();
      while (iterator.hasNext()) {
        FcePersonDB fcePersonDB = (FcePersonDB) iterator.next();
        if (fcePersonDB.getIndCertifiedGroup()) {
          numberCertifiedPeople++;
        }
        if (fcePersonDB.getIndPersonHmRemoval()) {
          numberPeopleLivingInHomeOfRemoval++;
        }
        indNoc = fcePersonDB.getIndNoc();
      }

      trace("numberCertifiedPeople: " + numberCertifiedPeople);
      trace("numberPeopleLivingInHomeOfRemoval: " +
            numberPeopleLivingInHomeOfRemoval);

      //!!! this is a lot of work just to save 2 values
      //!!! also, it's odd that the 2 counts are in different tables
      fceApplicationDB.setNbrLivingAtHome((long) numberPeopleLivingInHomeOfRemoval);
      lookupEjb(Fce.class).updateFceAppliationByNbrLivingAtHome(idFceApplication, (long) numberPeopleLivingInHomeOfRemoval);

      long idFceEligibility = fceApplicationDB.getIdFceEligibility();
      FceEligibilityDB fceEligibilityDB =
        lookupEjb(Fce.class).retrieveFceEligibility(idFceEligibility);

      int oldNumberCertifiedPeople = 0;

      if (fceEligibilityDB.getNbrCertifiedGroupObject() != null) {
        oldNumberCertifiedPeople = fceEligibilityDB.getNbrCertifiedGroupObject().intValue();
      }

      lookupEjb(Fce.class).updateFceEligibilityByNbrCertifiedGroup(idFceEligibility, (long) numberCertifiedPeople);
      

      trace("oldNumberCertifiedPeople: " + oldNumberCertifiedPeople);
      trace("numberCertifiedPeople: " + numberCertifiedPeople);
   
      if(!"true".equals(indNoc)){
        //if number of certified people changes, it could affect system-derived deprivation
        if (oldNumberCertifiedPeople != numberCertifiedPeople) {
          String oldIndMeetsDpOrNotSystem = fceEligibilityDB.getIndMeetsDpOrNotSystemString();
          
          ApplicationReasonsNotEligible
          .calculateSystemDerivedParentalDeprivation(connection, fceApplicationDB.getCdLivingMonthRemoval(),
                                                     fceApplicationDB, fceEligibilityDB, lookupEjb(Fce.class));
          
          String newIndMeetsDpOrNotSystem = fceEligibilityDB.getIndMeetsDpOrNotSystemString();
          
          if (newIndMeetsDpOrNotSystem.equals(oldIndMeetsDpOrNotSystem) == false) {
            //clear ES indicator if system-derived deprivation changes
            lookupEjb(Fce.class).updateFceEligibilityByIndMeetsDpOrNotEs(idFceEligibility, StringHelper.EMPTY_STRING);
          }
        }
      }
      
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

  public void trace(String string) {
    GrndsTrace.msg(TRACE_TAG, 7, string);
  }
}
