package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Collection;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contact;
import gov.georgia.dhr.dfcs.sacwis.db.ContactCbx;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Hibernate;

/*Change History:
Date        User      Description
----------  --------  --------------------------------------------------
                          
09/23/08  mxpatel   STGAP00010312: added findContatcByIdPersonClosedAsTCMClient method to find
                    any rows with person being closed in the person merge as a victim. 
                    wrote updateContactByIdPersonClosedAsTcmClient to update the Contact table with new person.
                    
04/22/2009 bgehlot STGAP00012833: Added method findContactsByIdCaseIdPersonWithinDates();

06/29/2009 arege   STGAP00014326 Modified findContactByPersonEventAndIdEvent() to reflect newly added columns

09/09/09   vdevarak STGAP00015341: Added method findContactsByPerson to retrieve data for CPRS interface
10/29/09   arege    38671 Modified method findRecentContactByIdCaseAndContactPurpose and method findContactsByPerson         
11/04/09   pcoogan  38978: Updated the findContactsForPortal method to include attempted contacts made through portal
08/16/10   bgehlot  66380: Added method findMostRecentContactByIdCaseAndContactPurposeAndDiscussedInReferenceTo
11/30/10   wcochran MOBILITY: Modified findContactByPersonEventAndIdEvent() to reflect newly added column
04/14/2011 arege    SMS#49902 Added one more argument to findEarliestContactByPersonAndCaseAndMethods
                       
*/
public class ContactDAOImpl extends BaseDAOImpl implements ContactDAO {
  public Map findContactByPersonEventAndIdEvent(int idEvent) {
    //STGAP00014326 Modified to include cdContactedBy, nmContactedBy, cdContactNarrative
    Query query = getSession()
                              .createQuery(
                                           "select new map (a.person.idPerson as idPerson,"
                                                           + "      b.nmPersonFull as nmPersonFull,"
                                                           + "      a.cdContactLocation as cdContactLocation  ,"
                                                           + "      a.cdContactMethod as cdContactMethod,"
                                                           + "      a.cdContactOthers as cdContactOthers,"
                                                           + "      a.cdContactPurpose as cdContactPurpose,"
                                                           + "      a.cdContactType as cdContactType,"
                                                           + "      a.dtContactOccurred as dtContactOccurred,"
                                                           + "      a.indContactAttempted as indContactAttempted,"
                                                           + "      a.indPermCrossCntyLn as indPermCrossCntyLn,"
                                                           + "      a.personByIdContactTcmClient.idPerson as idContactTCMClient,"
                                                           + "      a.cdContactTcmEligible as cdContactTCMEligible,"
                                                           + "      a.cdContactTcmMedSvcs as cdContactTCMMedSvcs,"
                                                           + "      a.dtCntctMnthlySummBeg as dtCntctMnthlySummBeg,"
                                                           + "      a.dtCntctMnthlySummEnd as dtCntctMnthlySummEnd,"
                                                           + "      a.nmAgencyName as nmAgencyName, "                  
                                                           + "      a.dtLastUpdate as dtLastUpdate,"
                                                           + "      c.dtLastUpdate as cdtLastUpdate, "
                                                           + "      a.cdContactedBy as cdContactedBy,"
                                                           + "      a.nmContactedBy as nmContactedBy,"
                                                           + "      a.cdContactNarrative as cdContactNarr,"
                                                           + "      d.idUser as idPortalUserEntered,"
                                                           + "      a.indExtDocNarrAccept as indExtDocNarrAccept,"
                                                           + "      a.dtEnteredOn as dtEnteredOn," 
                                                           + "      a.cdPopFrom as cdPopFrom)"
                                                           + "      from Contact a"
                                                           + "      left join a.portalUser d"
                                                           + "      left join a.person b"
                                                           + "      left join a.event c"
                                                           + "      where"
                                                           + "    a.event.idEvent = :idEvent or a.event.idEvent is null");
    query.setInteger("idEvent", idEvent);
    return (Map) firstResult(query);
  }

  public long countContactsByIdStageAndContactTypeEREV(int idStage) {
    Query query = getSession().createQuery(
                                           "select count(*)" + "   from Contact" + "  where stage.idStage = :idStage "
                                                           + "    and cdContactType = 'EREV'");

    query.setInteger("idStage", idStage);

    return (Long) query.uniqueResult();
  }

  public Date findEarliestContactDateByIdStage(int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "select dtContactOccurred"
                                                           + "   from Contact a "
                                                           + "  where nvl(dtContactOccurred,"
                                                           + "        :dtMaxDate) = (select nvl(min(dtContactOccurred),"
                                                           + "                              :dtMaxDate)"
                                                           + "                     from Contact b"
                                                           + "                    where b.stage.idStage = :idStage)"
                                                           + "    and a.stage.idStage = :idStage");

    query.setInteger("idStage", idStage);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);

    return (Date) firstResult(query);
  }
  
  //SMS#38671 Modified method to take into consideration the cdPurposes stored in the contact_cbx table.
  //Retrieve only the Latest Diligent Search Contact made by a DFCS person ( cdContactedBy = DFC)
  @SuppressWarnings( { "unchecked" })
  public List<Contact> findRecentContactByIdCaseAndContactPurpose(int idCase, int idPerson, String cdContactPurpose) {

    Query query = getSession().createQuery(
                                           "select  c " + "  from Contact c ," + " EventPersonLink epl " + " , ContactCbx cbx"
                                                           + " where  epl.person.idPerson = :idPerson"
                                                           + " and c.event.idEvent = cbx.contact.idEvent"
                                                           + " and epl.event.idEvent = c.idEvent "
                                                           + " and c.capsCase.idCase = :idCase  "
                                                           + " and epl.capsCase.idCase = :idCase  "
                                                           + " and cbx.cdCbxCodeType = 'CCNTPURP' "
                                                           + " and cbx.cdContactCbx = :cdContactPurpose "
                                                           + " and c.cdContactedBy = '" + CodesTables.CCCONTBY_DFC + "'"
                                                           + " order by c.dtContactOccurred desc");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdContactPurpose", cdContactPurpose);

    return (List<Contact>) query.list();
  }

  public long countContactShellCountByIdStage(int idStage) {
    Query query = getSession().createQuery(
                                           " select count(*) as contactShellCount" + " from   Contact"
                                                           + " where  cdContactType = 'c3mt'"
                                                           + " and dtContactOccurred is null "
                                                           + " and stage.idStage = :idStage");

    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public Date findEarliestDtContactOccurredByIdStage(int idStage) {
    Query query = getSession().createQuery(
                                           "select dtContactOccurred" + "   from Contact"
                                                           + "  where nvl(dtContactOccurred, :dtMaxDate) = "
                                                           + "         (select nvl(min(dtContactOccurred), :dtMaxDate)"
                                                           + "            from Contact b"
                                                           + "            where b.stage.idStage = :idStage)"
                                                           + "    and stage.idStage = :idStage");

    query.setInteger("idStage", idStage);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (Date) firstResult(query);
  }

  public Contact findInitialContactByIdStage(int idStage){
    Query query = getSession().createQuery(
                                           "   from Contact"
                                         + "  where nvl(dtContactOccurred, :dtMaxDate) = "
                                         + "         (select nvl(min(dtContactOccurred), :dtMaxDate)"
                                         + "            from Contact b"
                                         + "            where b.stage.idStage = :idStage)"
                                         + "    and stage.idStage = :idStage");

    query.setInteger("idStage", idStage);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (Contact) firstResult(query);
  }
  @SuppressWarnings( { "unchecked" })
  public List<Contact> findContactVisitationByIdCaseByCdContactTypes(int idCase, Collection<String> cdContactTypes) {

    //STGAP00006890 - SWR 2/11/2008 Removed join to name table which was creating duplicates on the Visitation log for 
    //those caseworkers with multiple names.  It appeared to serve no purpose.
    //STGAP00007963 - added order by date of contact so they appear in order from earliest to latest
    Query query = getSession().createQuery(
                                           "select c" + "  from Event e, Contact c "
                                                           + " where e.capsCase.idCase = :idCase "
                                                           + "   and c.idEvent = e.idEvent "
                                                           + "   and c.cdContactType in ( :cdContactTypes )" 
                                                           + "   order by c.dtContactOccurred ");

    query.setInteger("idCase", idCase);
    query.setParameterList("cdContactTypes", cdContactTypes);

    return (List<Contact>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findContactVisitationsPersonsByIdEvent(int idEvent) {

    Query query = getSession().createQuery(
                                           "select new map(n.person.idPerson as idPerson, "
                                                           + "               n.nmNameFirst as nmNameFirst, "
                                                           + "               n.nmNameLast as nmNameLast, "
                                                           + "               n.nmNameMiddle as nmNameMiddle, "
                                                           + "               n.dtNameEndDate as dtNameEndDate, "
                                                           + "               n.cdNameSuffix as cdNameSuffix )"
                                                           + "  from EventPersonLink epl, " + "       Name n, "
                                                           + "       Event e, " + "       Contact c "
                                                           + " where c.idEvent = :idEvent "
                                                           + "   and c.idEvent = e.idEvent "
                                                           + "   and e.idEvent = epl.event.idEvent "
                                                           + "   and n.person.idPerson = epl.person.idPerson "
                                                           + "   and n.indNamePrimary = 'Y'");
    query.setInteger("idEvent", idEvent);
    return (List<Map>) query.list();
  }

  @SuppressWarnings("unchecked")
  //STGAP00007963 - added order by date of contact so they appear in order from earliest to latest
  public List<Contact> findContactByIdStageAndcdContactTypes(int idStage, Collection<String> cdContactTypes) {
    Query query = getSession().createQuery(
                                           " from Contact c " + "where c.stage.idStage = :idStage "
                                                           + "  and c.cdContactType in ( :cdContactTypes) "
                                                           + "  and c.capsCase.idCase is null "
                                                           + "  order by c.dtContactOccurred ");

    query.setInteger("idStage", idStage);
    query.setParameterList("cdContactTypes", cdContactTypes);

    return (List<Contact>) query.list();
  }

  public void saveContact(Contact contact) {
    getSession().saveOrUpdate(contact);
  }

  public int updateContact(int idStage, int idEvent) {
    Query query = getSession().createQuery(
                                           "update Contact" + "    set stage.idStage = :idStage"
                                                           + "  where event.idEvent = :idEvent");
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
  }

  public int deleteContact(int idStage) {
    Query query = getSession().createQuery("delete from Contact c " + "       where c.stage.idStage = :idStage ");
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }

  public int deleteContactByIdEvent(int idEvent, Date tsLastUpdate) {
    Query query = getSession().createQuery(
                                           " delete from Contact" + "       where idEvent = :idEvent"
                                                           + "         and dtLastUpdate = :tsLastUpdate");
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  /**
   * The findContactsByIdStage method queries the CONTACT, NAME and EVENT_PERSON_LINK tables to find all the contacts by
   * STAGEID within the date range.   The query uses native sql and returns an object array.  For new fields
   * add them to the end of the select clause to avoid breaking other code.
   * 
   * @param idStage
   * @param fromDate
   * @param toDate
   *            
   * @return List<Map> A List of all contacts retrieved by the query.
   */
  @SuppressWarnings("unchecked")
  public List<Object[]> findContactsByIdStageWithinDates(int idStage, Date fromDate, Date toDate) {
    
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 " SELECT n.nm_name_first, "
                                                                 + " n.nm_name_middle, "
                                                                 + " n.nm_name_last, "
                                                                 + " n.cd_name_suffix, "
                                                                 + " c.id_event, "
                                                                 + " c.ind_contact_attempted, "
                                                                 + " c.cd_contact_type, "
                                                                 + " c.cd_contact_location, "
                                                                 + " c.dt_contact_occurred "
                                                                 + " FROM contact c "
                                                                 + " LEFT JOIN event_person_link epl "
                                                                 + " ON c.ID_EVENT = epl.id_event "
                                                                 + " LEFT JOIN name n "
                                                                 + " ON epl.id_person = n.id_person "
                                                                 + " WHERE c.id_contact_stage=:idStage "
                                                                 + " AND trunc(c.dt_contact_occurred) between :dtSearchDateFrom AND :dtSearchDateTo "
                                                                 + " AND (n.ind_name_primary = 'Y' OR n.ind_name_primary IS NULL) "
                                                                 + " AND (n.ind_name_invalid = 'N' OR n.ind_name_invalid IS NULL) "
                                                                 + " ORDER BY c.dt_contact_occurred asc");
    query.setInteger("idStage", idStage);
    query.setDate("dtSearchDateFrom", fromDate);
    query.setDate("dtSearchDateTo", toDate);
    
    // Set the scalar values to optimize query access
    // the fields must be in the same order as the select clause
    query.addScalar("nm_name_first", Hibernate.STRING);
    query.addScalar("nm_name_middle", Hibernate.STRING);
    query.addScalar("nm_name_last", Hibernate.STRING);
    query.addScalar("cd_name_suffix", Hibernate.STRING);
    query.addScalar("id_event", Hibernate.INTEGER);
    query.addScalar("ind_contact_attempted", Hibernate.STRING);
    query.addScalar("cd_contact_type", Hibernate.STRING);
    query.addScalar("cd_contact_location", Hibernate.STRING);
    query.addScalar("dt_contact_occurred", Hibernate.TIMESTAMP);
    
    return (List<Object[]>) query.list();
  }

  //mxpatel added this method for defect #10312
  @SuppressWarnings({"unchecked"})
  public List<Contact> findContatcByIdPersonClosedAsTCMClient(int idPersMergeClosed){
    
    Query query = getSession().createQuery(" select c " +
                                           " from Contact c " +
                                           " where personByIdContactTcmClient.idPerson = :idPersMergeClosed " );
                                           
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (List<Contact>) query.list();
  }
  
  //mxpatel wrote this method for defect #10312
  public int updateContactByIdPersonClosedAsTcmClient(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("update Contact " +
                                           "   set personByIdContactTcmClient.idPerson = :idPersMergeForward " +
                                           " where personByIdContactTcmClient.idPerson = :idPersMergeClosed ");
                                           
    
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return query.executeUpdate();
  }
  
  /**
   * STGAP00012833: This method gets all the contacts for all the principals for a case for range of dates.
   * 
   * @param idCase
   * @param fromDate
   * @param toDate
   *            
   * @return List<Map<String,Object>>  A List of all contacts retrieved by the query.
   */
 @SuppressWarnings("unchecked")
  public List<Map<String,Object>> findContactsByIdCaseIdPersonWithinDates(int idCase, Date fromDate, Date toDate) {
    List<String> cdContactType = new ArrayList<String>();
    cdContactType.add(CodesTables.CCNTCTYP_OTRN);
    cdContactType.add(CodesTables.CCNTCTYP_ITRN);
    cdContactType.add(CodesTables.CCNTCTYP_LTRN);
    cdContactType.add(CodesTables.CCNTCTYP_PTRN);
    cdContactType.add(CodesTables.CCNTCTYP_MTRN);
    cdContactType.add(CodesTables.CCNTCTYP_ATRN);
    cdContactType.add(CodesTables.CCNTCTYP_QTRN);
    cdContactType.add(CodesTables.CCNTCTYP_NTRN);
    cdContactType.add(CodesTables.CCNTCTYP_HTRN);
    
    Query query = getSession().createQuery("select new map (c.stage.idStage as idContactStage, " +
                                           "                spl.person.idPerson as idPerson, " +
                                           "                c.dtContactOccurred as dtContactOccurred, " +
                                           "                c.cdContactLocation as cdContactLocation,  " +
                                           "                epl.event.idEvent as idEvent, " +
                                           "                p.nmPersonFull as nmPersonFull, " +
                                           "                spl.cdStagePersRelInt as cdStagePersRelInt) " +
                                           "                from Contact c, " +
                                           "                EventPersonLink epl, " +
                                           "                StagePersonLink spl, " +
                                           "                Person p where " +
                                           "                c.idEvent = epl.event.idEvent and " +
                                           "                epl.person.idPerson = spl.person.idPerson and " +
                                           "                c.stage.idStage = spl.stage.idStage and " +
                                           "                epl.person.idPerson = p.idPerson and " +
                                           "                c.capsCase.idCase = :idCase and " +
                                           "                spl.cdStagePersType = :principal and " +
                                           "                c.cdContactType not in ( :cdContactType ) and  "+
                                           "                trunc(c.dtContactOccurred) between :dtSearchDateFrom and  :dtSearchDateTo " +
                                           "                order by spl.person.idPerson, c.dtContactOccurred desc");
    query.setInteger("idCase", idCase);
    query.setDate("dtSearchDateFrom", fromDate);
    query.setDate("dtSearchDateTo", toDate);
    query.setString("principal", CodesTables.CPRSNTYP_PRN);
    query.setParameterList("cdContactType", cdContactType);
    return (List<Map<String,Object>>) query.list();
  }
 
 //SMS#38671 Retrieve only the Latest Contact made by a DFCS person ( cdContactedBy = DFC)
 //Find only the Diligent (DIL) search contacts to keep it consistent with the Diligent Search Report Form.
 //As a result of MR-024 contact detail page can save information about who entered the Contact in Shines as well as
 //the person who actually made the contact, person who made the contact may or may not have idPerson. 
 //To account for above change , replaced  c.person.nmPersonFull as nmPersonFull with c.nmContactedBy as nmContactedBy
 @SuppressWarnings("unchecked")
 public List<Map> findContactsByPerson(int idPerson, int idStage, String cdEventType) {
   Query query = getSession()
                             .createQuery(
                                          "select new map (c.person.idPerson as idPerson,"
                                                          + "      c.nmContactedBy as nmContactedBy,"
                                                          + "      c.cdContactMethod as cdContactMethod,"
                                                          + "      c.dtContactOccurred as dtContactOccurred )"
                                                          + "  from Event e, EventPersonLink epl, Contact c" + " , ContactCbx cbx"
                                                          + "  where e.idEvent = epl.event.idEvent "
                                                          + "  and c.event.idEvent = cbx.contact.idEvent"
                                                          + "  and e.idEvent = c.event.idEvent "
                                                          + "  and e.stage.idStage = :idStage "
                                                          + "  and e.cdEventType = :cdEventType "
                                                          + "  and epl.person.idPerson = :idPerson " 
                                                          + "  and cbx.cdCbxCodeType = 'CCNTPURP' "
                                                          + "  and cbx.cdContactCbx = '" + CodesTables.CCNTPURP_DIL + "'"
                                                          + "  and c.cdContactedBy = '" + CodesTables.CCCONTBY_DFC + "'"
                                                          + "  order by c.dtContactOccurred desc");
   query.setInteger("idPerson", idPerson);
   query.setInteger("idStage", idStage);
   query.setString("cdEventType", cdEventType);
   return (List<Map>) query.list();
 }
 
 @SuppressWarnings("unchecked")
 public List<ContactCbx> findContactCbx(int idContactEvent) {
   Query query = getSession().createQuery(" from ContactCbx cbx " +
                                          "where cbx.contact.idEvent = :idContactEvent");
   query.setInteger("idContactEvent", idContactEvent);
   return (List<ContactCbx>) query.list();
 }

 /**
  * The findContactsForPortal method queries the CONTACT, EVENT_PERSON_LINK, and
  * PORTAL_USER_VENDOR_LINK tables to find all contact records appropriate for display
  * on the Portal Child Detail page of the SHINES portal.
  * 
  * @param idPerson
  * @param idCase
  * @param assignedResources (list of assigned resource ID for current portal user)
  *            
  * @return PaginatedList<Object> A List of all contacts retrieved by the query.
  */
 @SuppressWarnings("unchecked")
 public PaginatedHibernateList<Object[]> findContactsForPortal(int idPerson, 
                                                               int idCase,
                                                               List <Integer> assignedResources,
                                                               int pageNbr, 
                                                               int pageSize) {
   
   SQLQuery query = getSession()
                                .createSQLQuery("SELECT DISTINCT id_event, id_contact_stage, cd_stage, " +
                                		"   dt_contact_occurred, " +
                                		"   cd_contact_method, nm_contacted_by, nm_agency_name, " +
                                		"   id_portal_user_entered FROM " +
                                		"   (SELECT c.id_event, c.id_contact_stage, s.cd_stage, " +
                                		"   c.dt_contact_occurred, c.cd_contact_method, " +
                                                "   c.nm_contacted_by, c.nm_agency_name, c.id_portal_user_entered " +
                                                "   FROM " +
                                                "   contact c, event_person_link epl, stage s " +
                                                "   WHERE c.id_event = epl.id_event " +
                                                "   AND s.id_stage = c.id_contact_stage " +
                                                "   AND epl.id_person = :idPerson " +
                                                "   AND c.cd_contact_method in (:contactTypes) " +
                                                "   AND c.id_case = :idCase  " +
                                                "   AND c.ind_contact_attempted = :indAttempted " +
                                                "   AND ((SYSDATE - c.dt_contact_occurred) <= 60) " +
                                                "UNION " +
                                                "SELECT DISTINCT c.id_event, c.id_contact_stage, " +
                                                "   s.cd_stage, c.dt_contact_occurred, c.cd_contact_method, " +
                                                "   c.nm_contacted_by, c.nm_agency_name, c.id_portal_user_entered " +
                                                "   FROM " +
                                                "   contact c, event_person_link epl, stage s, " +
                                                "   portal_user_vendor_link puvl " +
                                                "   WHERE c.id_event = epl.id_event " +
                                                "   AND s.id_stage = c.id_contact_stage " +
                                                "   AND epl.id_person = :idPerson " +
                                                "   AND c.cd_contact_method in (:contactTypes) " +
                                                "   AND c.id_case = :idCase " +
                                                "   AND c.id_portal_user_entered = puvl.id_user " +
                                                "   AND puvl.id_resource in (:assignedResources) " +
                                                "   AND puvl.dt_start <= c.dt_contact_occurred " +
                                                "   AND (puvl.dt_end IS NULL OR puvl.dt_end >= c.dt_contact_occurred)) " +
                                                "   ORDER BY dt_contact_occurred DESC");
                                               
   
   
                                
   //Query parameters
   
   List<String> contactTypes = new ArrayList<String>();
   contactTypes.add(CodesTables.CCNTMETH_ATF);
   contactTypes.add(CodesTables.CCNTMETH_UTF);
   
   query.setParameterList("assignedResources", assignedResources);
   query.setInteger("idPerson", idPerson);
   query.setInteger("idCase", idCase);
   query.setParameterList("contactTypes", contactTypes);
   query.setString("indAttempted", CodesTables.CRISKYN_N);
   
   // Set the scalar values to optimize query access
   // the fields must be in the same order as the select clause
   query.addScalar("id_event", Hibernate.INTEGER);
   query.addScalar("id_contact_stage", Hibernate.INTEGER);
   query.addScalar("cd_stage", Hibernate.STRING);
   query.addScalar("dt_contact_occurred", Hibernate.DATE);
   query.addScalar("cd_contact_method", Hibernate.STRING);
   query.addScalar("nm_contacted_by", Hibernate.STRING);
   query.addScalar("nm_agency_name", Hibernate.STRING);
   query.addScalar("id_portal_user_entered", Hibernate.INTEGER);
   
   return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
 }
//Added for SMS#49902
 public Date findEarliestContactByPersonAndCaseAndMethods (int idPerson, int idCase, List<String> methods, Date dtIntakeDate){
   Query query = getSession().createQuery(
                                          "select min(c.dtContactOccurred) " + "  from Contact c ," + " EventPersonLink epl "
                                                          + " where  epl.person.idPerson = :idPerson"
                                                          + " and epl.event.idEvent = c.idEvent "
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and epl.capsCase.idCase = :idCase  "
                                                          + " and c.indContactAttempted = :indAttempted "
                                                          + " and c.cdContactMethod in (:methods) "
                                                          + " and c.dtContactOccurred >= :dtIntakeDate ");

   query.setParameterList("methods", methods);
   query.setString("indAttempted", CodesTables.CRISKYN_N);
   query.setInteger("idCase", idCase);
   query.setInteger("idPerson", idPerson);
   query.setDate("dtIntakeDate", dtIntakeDate);
   return (Date) firstResult(query);
 }


 public Date findMostRecentContactByPersonAndCaseAndMethods (int idPerson, int idCase, List<String> methods){
   Query query = getSession().createQuery(
                                          "select max(c.dtContactOccurred) " + "  from Contact c ," + " EventPersonLink epl "
                                                          + " where  epl.person.idPerson = :idPerson"
                                                          + " and epl.event.idEvent = c.idEvent "
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and epl.capsCase.idCase = :idCase  "
                                                          + " and c.indContactAttempted = :indAttempted "
                                                          + " and c.cdContactMethod in (:methods) ");

   query.setParameterList("methods", methods);
   query.setString("indAttempted", CodesTables.CRISKYN_N);
   query.setInteger("idCase", idCase);
   query.setInteger("idPerson", idPerson);

   return (Date) firstResult(query);
 }
 
 //STGAP00017781: Added this new method to get the most recent CM child visit to get response met date
 public Date findMostRecentCaseManagerChildVisit (int idPerson, int idCase, List<String> methods, Date dtIntakeDate){
   Query query = getSession().createQuery(
                                          "select max(c.dtContactOccurred) " 
		   												  + " from Contact c ," + " EventPersonLink epl, " + "ContactCbx ccbx"
                                                          + " where  epl.person.idPerson = :idPerson"
                                                          + " and epl.event.idEvent = c.idEvent "
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and epl.capsCase.idCase = :idCase  "
                                                          + " and c.indContactAttempted = :indAttempted "
                                                          + " and c.cdContactMethod in (:methods) "
                                                          + " and c.dtContactOccurred >= :dtIntakeDate "
                                                          + " and c.idEvent = ccbx.contact.idEvent "
                                                          + " and ccbx.cdContactCbx = :cdContactCbxVal");

   query.setParameterList("methods", methods);
   query.setString("indAttempted", CodesTables.CRISKYN_N);
   query.setInteger("idCase", idCase);
   query.setInteger("idPerson", idPerson);
   query.setDate("dtIntakeDate", dtIntakeDate);
   query.setString("cdContactCbxVal", CodesTables.CCNTPURP_CMC);
   return (Date) firstResult(query);
 }
 
 public Date findEarliestContactByCaseAndPurpose (int idCase, String cdPurpose){
   
   Query query = getSession().createQuery(
                                          "select min(c.dtContactOccurred) " + "  from Contact c ," + " ContactCbx cbx"
                                                          + " where c.event.idEvent = cbx.contact.idEvent"
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and cbx.cdCbxCodeType = 'CCNTPURP' "
                                                          + " and cbx.cdContactCbx = :cdContactPurpose ");

   query.setInteger("idCase", idCase);
   query.setString("cdContactPurpose", cdPurpose); 
 
   return (Date) firstResult(query);
 }
 
 public Date findMostRecentContactByCaseAndPurpose (int idCase, String cdPurpose){
   
   Query query = getSession().createQuery(
                                          "select max(c.dtContactOccurred) " + "  from Contact c ," + " ContactCbx cbx"
                                                          + " where c.event.idEvent = cbx.contact.idEvent"
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and cbx.cdCbxCodeType = 'CCNTPURP' "
                                                          + " and cbx.cdContactCbx = :cdContactPurpose ");

   query.setInteger("idCase", idCase);
   query.setString("cdContactPurpose", cdPurpose); 
 
   return (Date) firstResult(query);
   
 }
 
 public Date findMostRecentContactByCaseAndPersonAndPurpose(int idCase, int idPerson, String cdPurpose){
   
   Query query = getSession().createQuery(
                                          "select max(c.dtContactOccurred) " + "  from Contact c ," + "EventPersonLink epl, "+ " ContactCbx cbx"
                                                          + " where c.event.idEvent = cbx.contact.idEvent"
                                                          + " and epl.person.idPerson = :idPerson"
                                                          + " and epl.event.idEvent = c.idEvent "
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and cbx.cdCbxCodeType = 'CCNTPURP' "
                                                          + " and cbx.cdContactCbx = :cdContactPurpose ");

   query.setInteger("idCase", idCase);
   query.setInteger("idPerson", idPerson);
   query.setString("cdContactPurpose", cdPurpose); 
 
   return (Date) firstResult(query);
   
 }
 
 public List<Contact> findMostRecentContactByIdCaseAndContactPurposeAndDiscussedInReferenceTo(int idCase, int idPerson, String cdContactPurpose) {

   Query query = getSession().createQuery(
                                          "select  c " + "  from Contact c ," + " EventPersonLink epl " + " , ContactCbx cbx"
                                                          + " where  epl.person.idPerson = :idPerson"
                                                          + " and c.event.idEvent = cbx.contact.idEvent"
                                                          + " and epl.event.idEvent = c.idEvent "
                                                          + " and c.capsCase.idCase = :idCase  "
                                                          + " and epl.capsCase.idCase = :idCase  "
                                                          + " and cbx.cdCbxCodeType = 'CCNTPURP' "
                                                          + " and cbx.cdContactCbx = :cdContactPurpose "
                                                          + " and c.cdContactedBy = '" + CodesTables.CCCONTBY_DFC + "'"
                                                          + " order by c.dtContactOccurred desc");

   query.setInteger("idCase", idCase);
   query.setInteger("idPerson", idPerson);
   query.setString("cdContactPurpose", cdContactPurpose);

   return (List<Contact>) query.list();
 }
 
}
