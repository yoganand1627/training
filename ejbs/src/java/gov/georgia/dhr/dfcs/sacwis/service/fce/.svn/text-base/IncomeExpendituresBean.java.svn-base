package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.IncomeExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;

import org.grnds.facility.log.GrndsTrace;

public class IncomeExpendituresBean extends BaseFceSessionBean {
  public static final String TRACE_TAG = "IncomeExpendituresBean";

  private PostEvent postEvent = null;

  private RetrieveMesProgramAssistant retrieveMesProgramAssistant = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    postEvent = getService(PostEvent.class);
    retrieveMesProgramAssistant = getService(RetrieveMesProgramAssistant.class);
  }

  public IncomeExpendituresDB read(long idStage, long idEvent, long idEmployeePerson)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".read");
    Connection connection = null;
    try {
      connection = getConnection();
      
      FceContext fceContext = lookupEjb(FceInitialize.class).initializeFceApplication(idStage, idEvent, idEmployeePerson);

      FceApplicationDB fceApplicationDB = fceContext.getFceApplicationDB(lookupEjb(Fce.class));
      FceEligibilityDB fceEligibilityDB = fceContext.getFceEligibilityDB(lookupEjb(Fce.class));

      IncomeExpendituresDB incomeExpendituresDB = new IncomeExpendituresDB();
      incomeExpendituresDB.setFceApplication(fceApplicationDB);
      incomeExpendituresDB.setFceEligibility(fceEligibilityDB);
      incomeExpendituresDB.setCdEventStatus(fceContext.getCdEventStatus(connection));

      //get income lists
      long idFceEligibility = fceEligibilityDB.getIdFceEligibility();

      List<FceIncomeDB> incomeForChild =
              IncomeHelper.findIncomeForChild(connection, idFceEligibility);

      incomeExpendituresDB.setIncomeForChild(incomeForChild);

      List<FceIncomeDB> incomeForFamily =
              IncomeHelper.findIncomeForFamily(connection, idFceEligibility);

      incomeExpendituresDB.setIncomeForFamily(incomeForFamily);

      List<FceIncomeDB> resourcesForChild =
              IncomeHelper.findResourcesForChild(connection, idFceEligibility);

      incomeExpendituresDB.setResourcesForChild(resourcesForChild);

      List<FceIncomeDB> resourcesForFamily =
              IncomeHelper.findResourcesForFamily(connection, idFceEligibility);

      incomeExpendituresDB.setResourcesForFamily(resourcesForFamily);
      
      //Get Principals list
      List<FcePersonDB> principalsList = PersonHelper.findPrinciples(connection, idFceEligibility, lookupEjb(Fce.class));
      incomeExpendituresDB.setPrincipals(principalsList);
      
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
      incomeExpendituresDB.setAUMembers(aUMembersList);
      incomeExpendituresDB.setNonAUMembers(nonAUMembersList);
      
      List<FceExpendituresDB> expenditures = IncomeHelper.findFceExpenditures(connection, idFceEligibility);
      incomeExpendituresDB.setExpenditures(expenditures);
      
      long nbrCertifiedGroup = 0;
      long numberPeopleLivingInHomeOfRemoval = 0;
      for (Iterator<FcePersonDB> principleIterator = principalsList.iterator(); principleIterator.hasNext();) {
        FcePersonDB fcePersonDB = principleIterator.next();
        if (fcePersonDB.getIndCertifiedGroup()) {
          nbrCertifiedGroup++;
        }
        if (fcePersonDB.getIndPersonHmRemoval()) {
          numberPeopleLivingInHomeOfRemoval++;
        }
      }
      incomeExpendituresDB.setNbrCertifiedGroup(nbrCertifiedGroup);
      incomeExpendituresDB.setNbrLivingAtHome(numberPeopleLivingInHomeOfRemoval);
      return incomeExpendituresDB;
    }
    catch (Exception e) {
      handleException(e);
      // handleException always throws an Exception
      return null;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public void save(IncomeExpendituresDB incomeExpendituresDB)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".save");
    Connection connection = null;
    try {
      connection = getConnection();
      FceHelper.verifyCanSave(connection, incomeExpendituresDB);

      FceApplicationDB fceApplicationDB = incomeExpendituresDB.getFceApplication();
      lookupEjb(Fce.class).saveFceApplication(fceApplicationDB);

      FceEligibilityDB fceEligibilityDB = incomeExpendituresDB.getFceEligibility();
      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);
          
      IncomeHelper.saveIncome(incomeExpendituresDB.getIncomeForChild(), lookupEjb(Fce.class));
      IncomeHelper.saveIncome(incomeExpendituresDB.getIncomeForFamily(), lookupEjb(Fce.class));
      IncomeHelper.saveIncome(incomeExpendituresDB.getResourcesForFamily(), lookupEjb(Fce.class));
      IncomeHelper.saveIncome(incomeExpendituresDB.getResourcesForChild(), lookupEjb(Fce.class));
      List<FceExpendituresDB> expenditures = incomeExpendituresDB.getExpenditures();
      long idFceEligibility = 0;
      for (int i = 0; i < expenditures.size(); i++) {
        FceExpendituresDB fceExpendituresDB = (FceExpendituresDB) expenditures.get(i);
        if(fceExpendituresDB.getIdPerson() != 0){
          long idPerson = fceExpendituresDB.getIdPerson();
          long idFcePerson = Long.parseLong(PersonHelper.findIdFcePerson(connection, idPerson).toString());
          fceExpendituresDB.setIdFcePerson(idFcePerson);
          idFceEligibility = fceExpendituresDB.getIdFceEligibility();
        }
     }
      lookupEjb(Fce.class).deleteFceExpenditures(idFceEligibility);

      IncomeHelper.saveExpenditures(incomeExpendituresDB.getExpenditures(), lookupEjb(Fce.class));
      
      //!!! refactor
      EventHelper.changeEventStatus(postEvent, connection, fceApplicationDB.getIdEvent(), EventHelper.NEW_EVENT,
                                    EventHelper.PROCESS_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, fceApplicationDB.getIdEvent(), EventHelper.PROCESS_EVENT,
                                    EventHelper.PROCESS_EVENT);

      EventHelper.changeEventStatus(postEvent, connection, fceApplicationDB.getIdEvent(), EventHelper.COMPLETE_EVENT,
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

  public int[] submitApplication(IncomeExpendituresDB incomeExpendituresDB, String securityAttribute)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".submitApplication");
    Connection connection = null;
    try {
      connection = getConnection();

      //!!! is the sync redundant with the read? (optimization)
      FceContext fceContext = syncApplication(incomeExpendituresDB, connection);
      int[] errors = ApplicationErrorList.checkApplicationErrors(lookupEjb(Fce.class), fceContext, connection,
                                                                 ApplicationErrorList.SUBMIT_MODE, securityAttribute,
                                                                 retrieveMesProgramAssistant);
      if (errors != null) {
        return errors;
      }

      FceEligibilityDB fceEligibilityDB =
        fceContext.getFceEligibilityDB(lookupEjb(Fce.class));

      lookupEjb(Fce.class).saveFceEligibility(fceEligibilityDB);
      //07/09/2003, Matthew McClain, This is now handled by TodoConversation when saving the todo
       EventHelper.changeEventStatus(postEvent, connection,
                                      fceContext.getIdEvent(),
                                      EventHelper.PROCESS_EVENT,
                                      EventHelper.PENDING_EVENT);

      EventHelper.completeTodosForEventId(connection, fceContext.getIdEvent());

      /** @todo return zero length array instead of null; change code that calls it first */
      return null;
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      /** @todo return zero length array instead of null */
      return null;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  public int[] calculate(IncomeExpendituresDB incomeExpendituresDB, String securityAttribute)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".calculate");
    Connection connection = null;
    try {
      connection = getConnection();

      //!!! is the sync redundant with the read? (optimization)
      FceContext fceContext = syncApplication(incomeExpendituresDB, connection);

      int[] errors = ApplicationErrorList.checkApplicationErrors(lookupEjb(Fce.class), fceContext, connection,
                                                                 ApplicationErrorList.CALCULATE_MODE,
                                                                 securityAttribute, retrieveMesProgramAssistant);

      if (errors != null) {
        return errors;
      }

      //calculate sets the flags for the 15 (as of March 2007) system-calculated reasons not eligible
      ApplicationReasonsNotEligible.calculate(lookupEjb(Fce.class), connection, fceContext);
      
      EventHelper.changeEventStatus(postEvent, connection, fceContext.getIdEvent(), EventHelper.PENDING_EVENT,
                                    EventHelper.COMPLETE_EVENT);

      /** @todo return zero length array instead of null */
      return null;
    }
    catch (Exception e) {
      handleException(e);
      //handleException always throws an Exception
      /** @todo return zero length array instead of null */
      return null;
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  protected FceContext syncApplication(IncomeExpendituresDB incomeExpendituresDB, Connection connection)
          throws NamingException, RemoteException, FinderException, EjbValidationException, SQLException, CreateException {
    long idEvent = incomeExpendituresDB.getIdEvent();
    long idFceApplication = incomeExpendituresDB.getIdFceApplication();
    long idFceEligibility = incomeExpendituresDB.getIdFceEligibility();
    long idFcePerson = incomeExpendituresDB.getIdFcePerson();
    long idPerson = incomeExpendituresDB.getIdPerson();

    FceHelper.verifyNonZero("idEvent", idEvent);
    FceHelper.verifyNonZero("idFceApplication", idFceApplication);
    FceHelper.verifyNonZero("idFceEligibility", idFceEligibility);
    FceHelper.verifyNonZero("idFcePerson", idFcePerson);
    FceHelper.verifyNonZero("idPerson", idPerson);

    FceContext fceContext = new FceContext();
    fceContext.setIdEvent(idEvent);
    fceContext.setIdFceApplication(idFceApplication);
    fceContext.setIdFceEligibility(idFceEligibility);
    fceContext.setIdFcePerson(idFcePerson);
    fceContext.setIdPerson(idPerson);

    return fceContext;
  }
}
