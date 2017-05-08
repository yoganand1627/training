package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDiscussedCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.common.ContactListSearch;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContactCbxRecord_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiscussedPersonsSI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSYS04SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*CHANGE HISTORY


 ** Change History:
 **  Date        User              Description
 **  --------    --------------  --------------------------------------------------
 * 6/5/08       CHARDEN          STGAP00006217 - added StagePersonLinkDAO to find idPerson of Primary Child belonging
 *                               to the contact stage. Compared PC idPerson to idPerson of persons contacted 
 *                               in if statement and added a break statement to exit while loop and add PC full name
 *                               to row to be displayed as contact name. 
 *
 * 9/08/08      CHARDEN          STGAP00010137 - moved else statement inside of the if block so that code would not get skipped
 * 10/31/09     mchillman        STGAP00010898 Added code for ADO Sealing
 * 07/04/09     arege            STGAP00014326 MR-024 Changes to include Purpose options on the Contact Search List page
 * 07/30/09     arege            STGAP00014857 CaseWorkers with SAU Sealed Attribute should be able to add and modify
 *                               contacts.
 * 02/17/10     swroberts        MR-061 Added the sort feature for contact date.
 * 02/23/10     wjcochran        MR-062 Added logic to determine if a Contact can be added. See 
 *                               method determineIsContactAddAllowed for the logic involved.
 *  06/04/10    arege            SMS#52235 Sealing Rules for contacts
 *  07/04/10    arege            SMS#52235 Sealing Rules for contacts
 *  08/16/10    bgehlot          66380 MR072 Add new field Discussed/In Reference to
 *  
 ** */
@SuppressWarnings({"serial", "unchecked"})
public class ContactListSearchImpl extends BaseServiceImpl implements ContactListSearch {

  public static final int MAX_NAMES = 5;
  private static final Set<String> STAGES_CONTACT_STDS = new HashSet<String>() {
    {
      add(CodesTables.CSTAGES_FSU);
      add(CodesTables.CSTAGES_ONG);
      add(CodesTables.CSTAGES_FPR);
    }
  };

  private CapsResourceDAO capsResourceDAO;
 
  private ContactStandardsDAO contactStandardsDAO = null;
  
  private DynamicContactDAO dynamicContactDAO = null;

  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private ContactDiscussedCbxDAO contactDiscussedCbxDAO = null;

  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  } 
  
  public void setContactStandardsDAO(ContactStandardsDAO contactStandardsDAO) {
    this.contactStandardsDAO = contactStandardsDAO;
  }
  
  public void setDynamicContactDAO(DynamicContactDAO dynamicContactDAO) {
    this.dynamicContactDAO = dynamicContactDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setContactDiscussedCbxDAO(ContactDiscussedCbxDAO contactDiscussedCbxDAO) {
    this.contactDiscussedCbxDAO = contactDiscussedCbxDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CSYS04SO contactListSearch(CSYS04SI csys04si) throws ServiceException {
    CSYS04SO csys04so = new CSYS04SO();
    int idCase = csys04si.getUlIdCase();
    int idStage = csys04si.getUlIdStage();
    
    CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
    if (capsResource != null) {
      String cdRsrcCategory = capsResource.getCdRsrcCategory();
      if (cdRsrcCategory != null) {
        csys04so.setSzCdRsrcCategory(cdRsrcCategory);
      }
    }    
    
    // MR-024 Get the PurposeOptions from the csys04si array
    ContactCbxRecord_Array contactCbxArray = csys04si.getContactCbxRecord_Array();
    List<String> cdPurposeList = new ArrayList<String>();
    Enumeration<ContactCbxRecord> ContactCbxRecordEnumeration = contactCbxArray.enumerateContactCbxRecord();
    while (ContactCbxRecordEnumeration.hasMoreElements()) {
      ContactCbxRecord cbx = (ContactCbxRecord) ContactCbxRecordEnumeration.nextElement();
      String cdPurpose = cbx.getSzCdContactCbx();
      cdPurposeList.add(cdPurpose);
    }

    // int idStage = csys04si.getUlIdStage();

    // if from date is equal to NULL date (meaning there was nothing in it) then change it
    // to MIN castor date otherwise use the given date
    // csys04d
    Date endDate = csys04si.getDtScrSearchDateTo() != null ? DateHelper.toJavaDate(csys04si.getDtScrSearchDateTo())
                                                          : DateHelper.MAX_JAVA_DATE;
    Calendar cal = new GregorianCalendar();
    cal.setTime(endDate);
    cal.add(Calendar.DATE, 0);
    endDate = cal.getTime();

    ArchInputStruct ais = csys04si.getArchInputStruct();
    int pageNbr = ais.getUsPageNbr();
    int pageSize = ais.getUlPageSizeNbr();
    
    //MR-061 Capture the sort preferences
    String orderBy = ais.getSzOrderBy();
    String orderDirection = ais.getSzOrderDirection();

    //MR-024 Now the result can have multiple records for single idEvent, as we are joining the table 
    //ContactCbx to get purpose options for a CONTACT.
    PaginatedHibernateList<Object[]> objectArrayList = dynamicContactDAO
    .findContactsPaginated(
                           idCase,
                           csys04si.getUlIdStage(),
                           csys04si.getUlIdEvent(),
                           null,
                           csys04si
                                   .getSzCdContactType(),
                                   cdPurposeList,
                           csys04si
                                   .getSzCdContactMethod(),
                           csys04si
                                   .getSzCdContactLocation(),
                           csys04si
                                   .getSzCdContactOthers(),
                           DateHelper
                                     .toJavaDate(csys04si
                                                         .getDtScrSearchDateFrom() == null ? DateHelper.MIN_CASTOR_DATE
                                                                                          : csys04si
                                                                                                    .getDtScrSearchDateFrom()),
                           endDate, pageNbr,
                           pageSize, orderBy, orderDirection);
    // If the above was successful, cache the idPersons in LinkedHashSet so their order is preserved.
    Set<Integer> inputIdPersons = new LinkedHashSet<Integer>();
    ROWCSYS04SI_ARRAY rowcsys04si_array = csys04si.getROWCSYS04SI_ARRAY();
    Enumeration rowcsys04si_enum = rowcsys04si_array.enumerateROWCSYS04SI();
    while (rowcsys04si_enum.hasMoreElements()) {
      ROWCSYS04SI rowcsys04si = (ROWCSYS04SI) rowcsys04si_enum.nextElement();
      inputIdPersons.add(rowcsys04si.getUlIdPerson());
    }
    
    //MR-072 Get the discussed in reference to persons
    Set<Integer> discussedPersons = new LinkedHashSet<Integer>();
    DiscussedPersonsSI_ARRAY discussedPersonsSI_ARRAY = csys04si.getDiscussedPersonsSI_ARRAY();
    Enumeration discussedPersonsSI_enum = discussedPersonsSI_ARRAY.enumerateDiscussedPersonsSI();
    while (discussedPersonsSI_enum.hasMoreElements()) {
      DiscussedPersonsSI discussedPersonsSI = (DiscussedPersonsSI) discussedPersonsSI_enum.nextElement();
      discussedPersons.add(discussedPersonsSI.getUlIdPerson());
    }
    
    //if the FAD stage is sealed set the date for the view test
    org.exolab.castor.types.Date dtStageSealed = csys04si.getDtDtStageSealed();
    
    // Populate the rowcsys04so_array object with only the results that fully match (including contacts).
    ROWCSYS04SO_ARRAY rowcsys04so_array = new ROWCSYS04SO_ARRAY();
    for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
      Object[] rowArray = it.next();
      int idEvent = (Integer) rowArray[6];
      int idContactStage = (Integer) rowArray[5];

      List<Map> matches = null;
      if (!inputIdPersons.isEmpty()) {
        // Only call csys12d if we have people passed into the event.
        matches = retrieveEventPersonLinkMatches(idEvent, inputIdPersons);
      }
      
      //MR-072 Find the match for the Discussed person in the contact
      List<Map> discussedPersonMatch = null;
      if (!discussedPersons.isEmpty()) {
        discussedPersonMatch = retrieveDiscussedInReferenceToMatches(idEvent, discussedPersons);
      }
      
      // A row should be used if no persons were passed in OR matches were found for the people passed in..
      //MR-072 Added discussedPersonMatch to the condition
      if ((inputIdPersons.isEmpty() && discussedPersons.isEmpty()) || matches != null || (discussedPersonMatch != null && !discussedPersonMatch.isEmpty())) {
        ROWCSYS04SO rowcsys04so = new ROWCSYS04SO();
        // Set the names only if we have matches.
        if (matches != null) {
          // Use a switch statement to handle having less than 5 names.
          // The "break;" statements are NOT missing!!! We use the drop-through behavior to set the rest of the fields.
          switch (matches.size()) {
          case 5:
            rowcsys04so.setSzScrNmContact5((String) matches.get(4).get("nmPersonFull"));
          case 4:
            rowcsys04so.setSzScrNmContact4((String) matches.get(3).get("nmPersonFull"));
          case 3:
            rowcsys04so.setSzScrNmContact3((String) matches.get(2).get("nmPersonFull"));
          case 2:
            rowcsys04so.setSzScrNmContact2((String) matches.get(1).get("nmPersonFull"));
          case 1:
            rowcsys04so.setSzScrNmContact1((String) matches.get(0).get("nmPersonFull"));
          }
        }
        // Populate the rest of the fields in the row from the results of the contact search.
        List<Map> Personname = personDAO.findPersonByEventId(idEvent);

        // STGAP00006217 - loop through list of contacts to determine if contact is primary child for the stage
        Iterator<Map> itnext = Personname.iterator();
        String nmPerson = null;
        idStage = csys04si.getUlIdStage();
        if (idContactStage == idStage) {
          List<Map> stageMap = stagePersonLinkDAO.findCdStageByIdStage(idStage);
          String cdStage = (String) stageMap.get(0).get("cdStage");
          if (CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_PFC.equals(cdStage)
              || CodesTables.CSTAGES_ADO.equals(cdStage)) {
            // retrieves the idPerson of.the primary child for the stage
            Integer check = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
            while (itnext.hasNext()) {
              Map eventPersonLinkMap = itnext.next();
              nmPerson = (String) eventPersonLinkMap.get("nmPersonFull");
              Integer idPerson = (Integer) eventPersonLinkMap.get("idPerson");
              if (idPerson.equals(check)) {
                break;
              }
            }
          }//STGAP00010137 - moved else statement inside of the if block so that code would not get skipped 
          else {
            while (itnext.hasNext()) {
              Map eventPersonLinkMap = itnext.next();
              nmPerson = (String) eventPersonLinkMap.get("nmPersonFull");
            }
          }
        } else if (idContactStage != idStage) {
          List<Map> stageMap = stagePersonLinkDAO.findCdStageByIdStage(idContactStage);
          String cdStage = (String) stageMap.get(0).get("cdStage");
          if (CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_PFC.equals(cdStage)
              || CodesTables.CSTAGES_ADO.equals(cdStage)) {
            // retrieves the idPerson of.the primary child for the stage
            Integer check = stagePersonLinkDAO.findIdPersonForChildByIdStage(idContactStage);
            while (itnext.hasNext()) {
              Map eventPersonLinkMap = itnext.next();
              nmPerson = (String) eventPersonLinkMap.get("nmPersonFull");
              Integer idPerson = (Integer) eventPersonLinkMap.get("idPerson");
              if (idPerson.equals(check)) {
                break;
              }
            }
          }else {
            while (itnext.hasNext()) {
              Map eventPersonLinkMap = itnext.next();
              nmPerson = (String) eventPersonLinkMap.get("nmPersonFull");
            }
          }
        } 

        // List<Map> eventPersonLinkList = personDAO.findPersonByEventId(idEvent);
        Date dtContactOccurred = (Timestamp) rowArray[0];
        String cdContactType = (String) rowArray[1];
        String cdContactPurpose = (String) rowArray[2];
        String cdContactMethod = (String) rowArray[3];
        String indContactAttempted = (String) rowArray[4];
        rowcsys04so.setDtDTContactOccurred(dtContactOccurred);
        rowcsys04so.setSzCdContactType(cdContactType);
        rowcsys04so.setSzCdContactPurpose(cdContactPurpose);
        rowcsys04so.setSzCdContactMethod(cdContactMethod);
        rowcsys04so.setBIndContactAttempted(indContactAttempted);
        rowcsys04so.setSzCdContactLocation ((String) rowArray[8]);
        rowcsys04so.setSzNmAgencyName((String) rowArray[9]);
        rowcsys04so.setBIndCrossCountyLines((String) rowArray[10]);
        rowcsys04so.setSzCdTCMEligible((String) rowArray[11]);
        rowcsys04so.setSzCdTCMMedSvcs((String) rowArray[12]);
        rowcsys04so.setSzCdContactedBy((String) rowArray[13]);
        rowcsys04so.setSzNmContactedBy((String) rowArray[14]);
        rowcsys04so.setSzCdContactNarr((String) rowArray[15]);
        if (rowArray[16] != null) {
          rowcsys04so.setUlIdTCMClient((Integer) ((Person)rowArray[16]).getIdPerson());
        }
        
        if (rowArray[17] != null){
          rowcsys04so.setUlIdPerson((Integer)((Person)rowArray[17]).getIdPerson());
        }
        
        rowcsys04so.setSzCdContactOthers((String) rowArray[18]);
        rowcsys04so.setSzScrNmContact1(nmPerson);
        rowcsys04so.setUlIdEvent(idEvent);
        // cses71d -- retrieves the cdStage (this should probably be outside the loop, but it was inside in the service)
        // Stage stage = stageDAO.findStageByIdStage(idStage);
        // if (stage == null) {
        // throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        // }
        // rowcsys04so.setSzCdStage(stage.getCdStage());
        rowcsys04so.setSzCdStage((String) rowArray[7]);
        rowcsys04so_array.addROWCSYS04SO(rowcsys04so);
        
        //if the FAD stage is sealed set the view ind based on the date
        //SMS#52235
        String  showRow = ArchitectureConstants.Y;
        if (dtStageSealed != null) {
          if (ArchitectureConstants.FALSE.equals(csys04si.getBIndUserSealed())) {
            String category = csys04so.getSzCdRsrcCategory();
            List<String> categories = new ArrayList<String>();
            categories.add(CodesTables.CFACATEG_A); // Adoptive
            categories.add(CodesTables.CFACATEG_D); // Relative Adopt
            categories.add(CodesTables.CFACATEG_L); // Foster/Adoptive (Legal Risk)
            categories.add(CodesTables.CFACATEG_J); // ICPC Adopt
            // general users see only the following events that occured since last sealing
            // the events created before sealing cannot be viewed by an user even if he has stageAccess
            if (categories.contains(category)
                ||  ArchitectureConstants.FALSE.equals(csys04si.getBIndUserStageAccess())) {
              if (DateHelper.isBefore(DateHelper.toCastorDate(dtContactOccurred), dtStageSealed) || DateHelper.isEqual(DateHelper.toCastorDate(dtContactOccurred), dtStageSealed)) {
                showRow = ArchitectureConstants.N;
              }
            }
          }
        }  
        rowcsys04so.setCIndRsrcSvcShowRow(showRow);
        
        //MR-072 Append the discussed Persons Names to be displayed on the Contact Search List Page
        StringBuffer discussedPersonsInContact =  retrieveDiscussedInReferenceToNames(idEvent);
           
        rowcsys04so.setSzDiscussedPersons(discussedPersonsInContact.toString());
       }
    }
    // It's not an error for this array to be empty.
    csys04so.setROWCSYS04SO_ARRAY(rowcsys04so_array);

    /*
     * MR-62: Determine if a new contact can be added.
     */
    boolean canAddContact = determineIsContactAddAllowed(idCase);
    String strIndCanAddContact = "";
    if (canAddContact){
      strIndCanAddContact = ArchitectureConstants.Y;
    } else {
      strIndCanAddContact = ArchitectureConstants.N;
    }
    csys04so.setIndCanAddCntct(strIndCanAddContact);

    ArchOutputStruct aos = new ArchOutputStruct();
    aos.setBMoreDataInd(objectArrayList.getBMoreDataInd());
    csys04so.setArchOutputStruct(aos);

    return csys04so;
  }

  private List<Map> retrieveEventPersonLinkMatches(int idEvent, Set<Integer> inputIdPersons) throws ServiceException {
    // csys12d
    List<Map> eventPersonLinkList = personDAO.findPersonByEventId(idEvent);
    Iterator<Map> eplIt = eventPersonLinkList.iterator();
    List<Map> matches = new LinkedList<Map>();
    while (eplIt.hasNext()) {

      Map eventPersonLinkMap = eplIt.next();
      int idPerson = (Integer) eventPersonLinkMap.get("idPerson");
      if (inputIdPersons.contains(idPerson)) {
        matches.add(eventPersonLinkMap);
        // Remove the match from the list so we end up with a list of names that do not mach below.
        eplIt.remove();
      }
    }
    if (matches.size() != inputIdPersons.size()) {
      //MR-072 If no match return null
      if(matches.isEmpty()){
        return null;
      }
    }
    
    if (matches.size() < MAX_NAMES && inputIdPersons.size() > 0) {
      // If there are less than 5 names, add up to 5 to the list.
      eplIt = eventPersonLinkList.iterator(); // reset the iterator
      while (eplIt.hasNext() && matches.size() < MAX_NAMES) {
        matches.add(eplIt.next());
      }
    }
    return matches;
  }
  
  private boolean determineIsContactAddAllowed(int idCase) {
    
    boolean isContactAddAllowed = false;
    
    String strDateDeploy = Lookup.simpleDecodeSafe("PMCNTCTS", "DEPDATE");
    String strDaysAfterStart = Lookup.simpleDecodeSafe("PMCNTCTS", "DAYS");
    
    Date dtDeploy = DateHelper.toJavaDateSafe(strDateDeploy);
    Integer intDaysAfterStart = Integer.parseInt(strDaysAfterStart);
    
    List<Stage> listCntctStdsStages = stageDAO.findStageByIdCaseAndCdStageSet(idCase, STAGES_CONTACT_STDS);
    
    /* If this value is -1 in the database, then
     * we want to allow contacts to be added.
     */
    if (intDaysAfterStart == -1) {
      isContactAddAllowed = true;
    } 
    /* If there are no FCF or ONG stages in the case,
     * We still want the user to be able to add contacts
     * without the addition of contact standards.
     */
    else if (listCntctStdsStages == null || listCntctStdsStages.isEmpty()) {
      isContactAddAllowed = true;
    }
    /* Contact Standards must be added if an ONG
     * or FCF stage exists for the case and that
     * stage has been open for more than
     * "intDaysAfterStart" days.
     */
    else {

      Date dtLatestStageStart = null;
      /*
       * Find the latest start date in the
       * returned stages
       */
      for (Stage s : listCntctStdsStages) {
        Date dtTmpStart = s.getDtStageStart();
        if (dtLatestStageStart == null) {
          dtLatestStageStart = dtTmpStart;
        } else if (dtTmpStart.after(dtLatestStageStart)){
          dtLatestStageStart = dtTmpStart;
        }
      }
      
      /* If we have made it this far, then the case
       * has either an ONG or FCF stage and must have
       * established contact standards.
       */
      ContactStandards cs = contactStandardsDAO
                                               .findApprovedContactStandardsByCdStageByIdCase(STAGES_CONTACT_STDS, 
                                                                                              idCase);
      /*
       * If the above call did not return any contact standards
       * then determine if the latest opened ONG or FCF stage was
       * started within the "intDaysAfterStart" period. This value
       * is stored in the database and determined by the business.
       */
      if (cs == null) {
        Calendar calToday = Calendar.getInstance();
        calToday.set(Calendar.HOUR, 0);
        calToday.set(Calendar.MINUTE, 0);
        calToday.set(Calendar.SECOND, 0);
        calToday.set(Calendar.MILLISECOND, 0);
        calToday.set(Calendar.HOUR_OF_DAY, 0);
        
        Date dtToday = calToday.getTime();
        
        DateHelper.addToDate(dtLatestStageStart, 0, 0, intDaysAfterStart);
        if (dtLatestStageStart.compareTo(dtToday) < 0) {
          isContactAddAllowed = false;
        } else {
          isContactAddAllowed = true;
        }

      }
      /*
       * If Contact Standards were returned, then allow
       * a new contact to be added.
       */
      else {
        isContactAddAllowed = true;
      }
      
      /*
       * If the stage was opened prior to dtDeploy,
       * then allow a contact to be added.
       */
      if (dtLatestStageStart.before(dtDeploy)) {
        isContactAddAllowed = true;
      }
    }
    
    
    return isContactAddAllowed;
  }
  
  /**
   * MR-072 Returns the matches for discussed in reference To Persons with the ones chosen on Contact Search page
   * @param idEvent
   * @param discussedIdPersons
   * @return
   * @throws ServiceException
   */
  private List<Map> retrieveDiscussedInReferenceToMatches(int idEvent, Set<Integer> discussedIdPersons) throws ServiceException {
    List<Map> discussedPersonsByEvent = contactDiscussedCbxDAO.findDiscussedMembersIdAndNameByIdEvent(idEvent);
    Iterator<Map> discussedIt = discussedPersonsByEvent.iterator();
    List<Map> matches = new LinkedList<Map>();
    while (discussedIt.hasNext()) {
      Map discussedMap = discussedIt.next();
      int idDiscussedPerson = (Integer) discussedMap.get("idDiscussedPerson");
      if (discussedIdPersons.contains(idDiscussedPerson)) {
        matches.add(discussedMap);
        // Remove the match from the list so we end up with a list of names that do not match below.
        discussedIt.remove();
      }
    }
    return matches;
  }
  
  /**
   * MR-072 Returns the names of the Discussed/In reference To Persons with the ones chosen on Contact Search page
   * @param idEvent
   * @param discussedIdPersons
   * @return
   * @throws ServiceException
   */
  private StringBuffer retrieveDiscussedInReferenceToNames(int idEvent) throws ServiceException {
    StringBuffer discussedPersonsInContact = new StringBuffer();
    List<Map> discussedPersons = contactDiscussedCbxDAO.findDiscussedMembersIdAndNameByIdEvent(idEvent);
    if(discussedPersons != null && !discussedPersons.isEmpty()){
      Iterator<Map> itDiscussed = discussedPersons.iterator();
      while (itDiscussed.hasNext()) {
        Map discussedMap = itDiscussed.next();
        String nmPerson = (String) discussedMap.get("nmPersonFull");
        discussedPersonsInContact.append(nmPerson);
        discussedPersonsInContact.append("\n");
      }
    }  
    return discussedPersonsInContact;
  }
}
