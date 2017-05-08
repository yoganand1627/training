/**
 * Created on Mar 25, 2006 at 2:17:55 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Collection;


import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;

public interface ContactDAO {
  /**
   * A QUERY join for the CONTACT, EVENT and PERSON tables
   *
   * @param idEvent
   * @return
   */
  Map findContactByPersonEventAndIdEvent(int idEvent);

  /**
   * Returns the count of contacts for an idStage and contact type EREV
   *
   * @param idStage
   * @return Integer
   */
  long countContactsByIdStageAndContactTypeEREV(int idStage);

  /**
   * Returns earliest contact date for the specified idStage
   *
   * @param idStage
   * @return Date
   */
  Date findEarliestContactDateByIdStage(int idStage);

  /**
   * Returns the initial contact for the specified idStage
   * @param idStage
   * @return
   */
  public Contact findInitialContactByIdStage(int idStage);
  
  /**
   * Return a Contact row by idCase and contact purpose.  Note that the actual Purpose is stored
   * in CONTACT_CBX and is not accessible from the Contact object.
   *
   * @param idCase
   * @param cdContactPurpose
   * @return Contact
   */
  List<Contact>  findRecentContactByIdCaseAndContactPurpose(int idCase,int idPerson,String cdContactPurpose);

  /**
   * Returns contactShellCount from Contact given idStage
   *
   * @param idStage
   * @return
   */
  long countContactShellCountByIdStage(int idStage);

  /**
   * Returns earliest contact date for specified idStage
   *
   * @param idStage
   * @return Date
   */
  Date findEarliestDtContactOccurredByIdStage(int idStage);

  /**
   * Find the list of contact id(s) and the staff person who made the contact given an idcase and an event type
   *
   * @param idCase
   * @param cdContactType
   * @return List<Contact>
   */
  List<Contact> findContactVisitationByIdCaseByCdContactTypes(int idCase, Collection<String> cdContactTypes);  
  
  /**
   * Find the list of contacts from a given stage
   *
   * @param idStage
   * @param fromDate
   * @param toDate
   * @return List<Object[]>
   */
  List<Object[]> findContactsByIdStageWithinDates(int idStage, Date fromDate, Date toDate);
  
  /**
   * Find the list of persons to contact or were contacted given an idEvent.
   *
   * @param idEvent
   * @return
   */
  List<Map> findContactVisitationsPersonsByIdEvent(int idEvent);

  /**
   * get the contacts made for an idStage and list of contactTypes
   *
   * @param idStage
   * @param cdContactTypes
   * @return List<Contact>
   */
  List<Contact> findContactByIdStageAndcdContactTypes(int idStage,  Collection<String> cdContactTypes);

  /**
   * This is an  update/insert for Contact info.
   *
   * @param contact
   */
  void saveContact(Contact contact);

  /**
   * Update contact table
   *
   * @param idStage
   * @param idEvent
   * @return
   */
  int updateContact(int idStage, int idEvent);

  /**
   * Delete from Contact based on idStage
   *
   * @param idStage
   */
  int deleteContact(int idStage);

  /**
   * Delete rows from Contact based on ID_EVENT and DT_LAST_UPDATE.
   *
   * @param idEvent
   * @param tsLastUpdate
   * @return
   */
  int deleteContactByIdEvent(int idEvent, Date tsLastUpdate);
  
  List<Contact> findContatcByIdPersonClosedAsTCMClient(int idPersMergeClosed);//mxpatel added this for defect #10312
  
  int updateContactByIdPersonClosedAsTcmClient(int idPersMergeForward, int idPersMergeClosed); //mxpatel added this for defect #10312
  
  /**
   * STGAP00012833: This method gets all the contacts for all the principals for a case for range of dates.
   * 
   * @param idCase
   * @param fromDate
   * @param toDate
   *            
   * @return List<Map<String,Object>>  A List of all contacts retrieved by the query.
   */

  List<Map<String,Object>>  findContactsByIdCaseIdPersonWithinDates(int idCase, Date fromDate, Date toDate);
  
  /**
   * Retrieves person name, person Id , contact Method and date contact occurred for all contacts of type 'CON' 
   * for the given person in the given stage.
   * 
   * @param idPerson
   * @param idStage
   * @param cdEventType
   * @return
   */
  public List<Map> findContactsByPerson(int idPerson, int idStage, String cdEventType);
  
  /**
   * The findContactsForPortal method queries the CONTACT, EVENT_PERSON_LINK, and
   * PORTAL_USER_VENDOR_LINK tables to find all contact records appropriate for display
   * on the Portal Child Detail page fo the SHINES portal.
   * 
   * @param idPerson
   * @param idCase
   * @param assignedResources (list of assigned resource ID for current portal user)
   *            
   * @return PaginatedList<Object> A List of all contacts retrieved by the query.
   */
  public PaginatedHibernateList<Object[]> findContactsForPortal(int idPerson, 
                                                                int idCase,
                                                                List <Integer> assignedResources,
                                                                int pageNbr, 
                                                                int pageSize);

  /**
   * The findEarliestContactByPersonAndCaseAndMethods is used to find the earliest
   * face to face contact made with a person during the case.
   * 
   * @param idPerson
   * @param idCase
   * @param methods (list of contact methods applicable for the contact)
   *            
   * @return Date of earliest contact meeting conditions
   */
  //SMS#49902: Added one more argument to the method
  public Date findEarliestContactByPersonAndCaseAndMethods (int idPerson, int idCase, List<String> methods, Date dtIntakeDate);

  /**
   * The findMostRecentContactByPersonAndCaseAndMethods is used to find the most recent
   * face to face contact made with a person during the case.
   * 
   * @param idPerson
   * @param idCase
   * @param methods (list of contact methods applicable for the contact)
   *            
   * @return Date of most recent contact meeting conditions
   */
  public Date findMostRecentContactByPersonAndCaseAndMethods (int idPerson, int idCase, List<String> methods);

  //STGAP00017781: Added this new method to get the most recent CM child visit to get response met date
  /**
   * The method findMostRecentCaseManagerChildVisit is used to find the case manager
   * most recent face to face contact made with a person during the case.
   * 
   * @param idPerson
   * @param idCase
   * @param methods
   * @param dtIntakeDate
   * @return
   */
  public Date findMostRecentCaseManagerChildVisit (int idPerson, int idCase, List<String> methods, Date dtIntakeDate);

  /**
   * The findEarliestContactByCaseAndPurpose is used to find the earliest
   * contact made in a case with a specific purpose during the case.
   * 
   * @param cdPurpose
   * @param idCase
   * 
   *            
   * @return Date of earliest contact meeting conditions
   */
  public Date findEarliestContactByCaseAndPurpose (int idCase, String cdPurpose);
  
  /**
   * The findEarliestContactByCaseAndPurpose is used to find the most recent
   * contact made in a case with a specific purpose during the case.
   * 
   * @param cdPurpose
   * @param idCase
   * 
   *            
   * @return Date of earliest contact meeting conditions
   */
  public Date findMostRecentContactByCaseAndPurpose (int idCase, String cdPurpose);
  
  /**
   * The findMostRecentContactByCaseAndPurpose is used to find the most recent
   * contact made in a case with a specific purpose for a specific person during the case.
   * 
   * @param cdPurpose
   * @param idCase
   * @param idPerson
   *            
   * @return Date of earliest contact meeting conditions
   */
  Date findMostRecentContactByCaseAndPersonAndPurpose (int idCase, int idPerson, String cdPurpose);
}
