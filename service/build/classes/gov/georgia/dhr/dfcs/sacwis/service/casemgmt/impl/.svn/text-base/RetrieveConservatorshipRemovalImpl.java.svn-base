package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharAdultDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RemovalReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalReason;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveConservatorshipRemoval;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG04;

/**
 * The PolicyViolationReportImpl class is the service for generating the 'Policy Violation Report' Form.
 * 
 * 
 * <PRE>
 * 
 * <U>Updated by:</U> <U>Description:</U> Update description
 *    SWR               06/11/08  STGAP00008568 - Added validation check for Safety Resource
 *    hnguyen           06/28/10  SMS#59027 - Update service to populate rowcsub14sog00 with the victim id
 *                                when user is adding a new custody/removal.
 *    htvo              12/07/10  SMS#81140 MR-074 AFCARS: 
 *                                1. Retrieve child characteristics until stage close
 *                                2. Remove code populated the caretaker and child characteristics factor sections   
 *                                   (section removed/remapped)        
 *                                3. Add helper method to retrieve person characteristics to populate retrieve SO object 
 *    schoi             10/02/11  STGAP00017013: MR-095 Added logic to validate for any Principal(s) 
 *                                with Unknown Gender before proceeding to Custody page                           
 *                                
 *                                                    
 * </PRE>
 */
public class RetrieveConservatorshipRemovalImpl extends BaseServiceImpl implements RetrieveConservatorshipRemoval {

  private static final String WINDOW_MODE_NEW = "1";

  private static final String WINDOW_MODE_NEW_USING = "2";

  private EventDAO eventDAO = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private PersonDAO personDAO = null;

  private RemovalReasonDAO removalReasonDAO = null;

  private RemovalCharChildDAO removalCharChildDAO = null;

  private RemovalCharAdultDAO removalCharAdultDAO = null;

  private CharacteristicsDAO characteristicsDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private DynamicEventDAO dynamicEventDAO = null;
  
  private SafetyResourceChildDAO safetyResourceChildDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setRemovalReasonDAO(RemovalReasonDAO removalReasonDAO) {
    this.removalReasonDAO = removalReasonDAO;
  }

  public void setRemovalCharChildDAO(RemovalCharChildDAO removalCharChildDAO) {
    this.removalCharChildDAO = removalCharChildDAO;
  }

  public void setRemovalCharAdultDAO(RemovalCharAdultDAO removalCharAdultDAO) {
    this.removalCharAdultDAO = removalCharAdultDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }  
  
  public CSUB14SO findConservatorShipRemovalInformation(CSUB14SI csub14si) throws ServiceException {
    CSUB14SO csub14so = new CSUB14SO();
    int idEvent = csub14si.getUlIdEvent();
    int idPerson = csub14si.getUlIdPerson();
    int idStage = csub14si.getUlIdStage();
    ROWCSUB14SOG00 rowcsub14sog00 = new ROWCSUB14SOG00();
    ROWCSUB14SOG04 rowcsub14sog04 = new ROWCSUB14SOG04();
    boolean bFoundPlacement = false; // flag to determine if characteristics are complete
    // Preparing to call EventDAO, CCMN45D that retrieves event information
    // Set output object CSUB14SO WCD DtSystemDate to current date
    csub14so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    // MR-074 AFCARS: find removal stage 
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    boolean stageIsOpen = (DateHelper.isNull(stage.getDtStageClose())) ? true : false;
    
    // If this is not a new event, retrieve the Removal Event Detail
    if (0 != idEvent) {
      // Calling EventDAO CCMN45D, through the helper method
      rowcsub14sog04 = retrieveEvent(idEvent);
      // csub14so.setROWCSUB14SOG04(rowcsub14sog04);
      // Retrieving szCdEventStatus, to be used in the next DAO call
      String szCdEventStatus = rowcsub14sog04.getSzCdEventStatus();
      // When this is the last stage in the case, we don't want any SvcAuths that are above COMPlete
      // to have a term date greater than today (unless the Service Codes correspond to types of daycare
      // services--Ex. 40M. Otherwise, the SvcAuths are NEW or PROC and we don't give edit checks on these
      if (!CodesTables.CEVTSTAT_NEW.equals(szCdEventStatus)) {
        // Calling CnsrvtrshpRemovalDAO, CSES20D through the helper method
        rowcsub14sog00 = retrieveCnsrvtrshpRemoval(idEvent);
        csub14so.setROWCSUB14SOG00(rowcsub14sog00);
        // The Person Id (idVictim) to passed into the next DAO, PersonDAO, is being retrieved.
        int idVictim = rowcsub14sog00.getUlIdVictim();
        // Calling PersonDAO, CCMN44D
        Person person_victim = personDAO.findPersonByIdPerson(idVictim);
        if (person_victim != null) {
          // Set fields in CSUB14SO to fields from retrieved Person object, person_victim
          csub14so.setSzNmPersonFull(person_victim.getNmPersonFull());
        }
        // Calling RemovalReasonDAO, CLSS21D through the helper method ... Perform Removal Reason Processing
        ROWCSUB14SOG01_ARRAY rowcsub14sog01_array = retrieveRemovalReason(idEvent);
        csub14so.setROWCSUB14SOG01_ARRAY(rowcsub14sog01_array);
        // csub14so.setROWCSUB14SOG01_ARRAY(getRowcsub14sog01_array(listRemovalReason));

        // Calling RemovalCharChildDAO, CLSS22D through the helper method
    	//ROWCSUB14SOG02_ARRAY rowcsub14sog02_array = retrieveRemovalCharChild(idEvent);
        //if (rowcsub14sog02_array != null) {
        //  csub14so.setROWCSUB14SOG02_ARRAY(rowcsub14sog02_array);
        //}
        // MR-074 AFCARS: retrieve current Child Person Characteristics for existing removal record for active stage; 
        // for closed stage, retrieve characteristice active at the time the stage close only 
        Date activeDate;
        if (!stageIsOpen) {
        	activeDate = stage.getDtStageClose();
        	// retrieve char that active by close date, if not found set NAChild = Y
            retrievePersonCharacteristics(idVictim, activeDate, csub14so);
        } else {
        	activeDate = DateHelper.toJavaDate(csub14so.getDtWCDDtSystemDate());
        	// if the current person char is None Diagnosed or Not Yet Diagnosed, set NAChild = Y 
            if ("2".equals(person_victim.getCdPersonChar()) || "3".equals(person_victim.getCdPersonChar())) {
                csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(ArchitectureConstants.Y);
            } else {
            	retrievePersonCharacteristics(idVictim, activeDate, csub14so);
            }
        }
        // See if event was last saved with Adult Rem Char NA box checked before retrieving Adult Rem Chars
        // MR-074: removed caretaker factor code
        /*if (!ArchitectureConstants.Y.equals(csub14so.getROWCSUB14SOG00().getCIndRemovalNACare())) {
          // Calling RemovalCharAdultDAO, CLSS23D through the helper method
          ROWCSUB14SOG03_ARRAY rowcsub14sog03_array = retrieveRemovalCharAdult(idEvent);
          if (rowcsub14sog03_array != null) {
            csub14so.setROWCSUB14SOG03_ARRAY(rowcsub14sog03_array);
          }
        }*/
      } // end .... szCdEventStatus New
    } // end .... idEvent 0

    csub14so.setROWCSUB14SOG04(rowcsub14sog04);
    csub14so.setROWCSUB14SOG00(rowcsub14sog00);
    // Call DAOs to retrieve and validate person detail data
    String szSysCdWinMode = csub14si.getSzSysCdWinMode();
    if (WINDOW_MODE_NEW.equals(szSysCdWinMode) || WINDOW_MODE_NEW_USING.equals(szSysCdWinMode) || 0 == idEvent) {
      
      //SWR 06/11/08 STGAP00008568 - Add check to make sure the child is not in an open
      //                             safety resource placement.
      if (hasOpenSafetyResourcePlacements (idPerson)) {
        throw new ServiceException(Messages.MSG_SRP_CUSTODY_REM);
      }
       
      // Calling PersonDAO, CCMN44D
      Person person = personDAO.findPersonByIdPerson(idPerson);
      if (person != null) {
        // Set fields in CSUB14SO to the values retrieved through the above DAO
        csub14so.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
        csub14so.setSzNmPersonFull(person.getNmPersonFull());
        Date dtPersonBirth = person.getDtPersonBirth();
        csub14so.setDtDtPersonBirth(DateHelper.toCastorDate(dtPersonBirth));
        if (!DateHelper.isNull(dtPersonBirth)) {
          // A comparison between the current date and the child's birthday is performed to check if the child
          // is older than 18 years.
          if (DateHelper.getAge(dtPersonBirth) >= 18) {
            throw new ServiceException(Messages.MSG_SUB_CHILD_OVER_18);
          }
        } else {
          throw new ServiceException(Messages.MSG_SUB_CHILD_AGE_REQ);
        }
        
        csub14so.getROWCSUB14SOG00().setUlIdVictim(person.getIdPerson());
        
        // STGAP00017013: MR-095
        // Check for any Principal(s) with Unknown Gender before proceeding to Custody
        long cntPrnUnknownGender = stagePersonLinkDAO
                                                     .countStagePersonLinkByIdStageCdStagePersTypeCdPersonSex(
                                                                                                              idStage,
                                                                                                              CodesTables.CPRSNTYP_PRN,
                                                                                                              CodesTables.CSEX_U);
        if (cntPrnUnknownGender > 0) {
          throw new ServiceException(Messages.MSG_UNKNOWN_GENDER_WARN);
        }
        // End STGAP00017013: MR-095
        
        // Calling WorkloadStageDao, CSES21D .. Perform Stage Person Link retrieval
        long countOpenSubStages = stagePersonLinkDAO.countOpenSubCareStages(idPerson, CodesTables.CROLEALL_PC);
        // Note: The above DAO call returns an int, the count, and hence the execution continues without
        // checking for any SQL error condition.
        // Any SQL error will throw an exception from the DAO.
        // If a row is retrieved in this dam then a subcare stage already exists, and the user should be notified
        // If no sql eroor and the number of rows returned is 0 then we have a subcare stage does not exist
        // and we can continue; if the number of rows returned is greater than 0, then a subcare stage exists
        // and we should return the message to the user
        if (0 < (int) countOpenSubStages) {
          throw new ServiceException(Messages.MSG_SUB_SUBC_STAGE_EXISTS);
        }
        // Check for bCdPersonChar value of '2'. If value is '2' that means NA was chosen on person char window.
        // if value of '3', that means Not Yet Diagnosed was chosen on person characteristics window.
        else if ("2".equals(person.getCdPersonChar()) || "3".equals(person.getCdPersonChar())) {
          csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(ArchitectureConstants.Y);
        } else {
          // This is the normal status; a subcare stage should not exist for this event when this window is
          // entered for the first time so, continue processing on the SQL_NOT_FOUND situation.
          // Process Placement Characteristics ... The child must have placement characteristics in the
          // Person window before the removal event can be started
          // Calling CharacteristicsDAO, CLSS60D
          List<Characteristics> listCharacteristics = characteristicsDAO
                                                                        .findCharacteristicsByIdPerson(
                                                                                                       idPerson,
                                                                                                       DateHelper
                                                                                                                 .toJavaDate(csub14so
                                                                                                                                     .getDtWCDDtSystemDate()));
          if (listCharacteristics == null || listCharacteristics.isEmpty()) {
            throw new ServiceException(Messages.MSG_SUB_PLCMT_CHAR_NEEDED);
          }
          // Loop through all the rows returned and determine if child has placement characteristics recorded
          // CdCharCategory == CPL... True then continue if false (no placement characteristics) then return
          // error and msg to user Also copy the placement characteristics so that
          // they can be loaded as the default selections in the Child Removal Reason listbox
          ROWCSUB14SOG02_ARRAY rowcsub14sog02_array = new ROWCSUB14SOG02_ARRAY();
          for (Iterator<Characteristics> characteristicsIt = listCharacteristics.iterator(); characteristicsIt
                                                                                                              .hasNext();) {
            Characteristics characteristics = characteristicsIt.next();
            ROWCSUB14SOG02 rowcsub14sog02 = new ROWCSUB14SOG02();
            if (CodesTables.CCHRTCAT_CPM.equals(characteristics.getCdCharCategory()) ||
                            CodesTables.CCHRTCAT_CHB.equals(characteristics.getCdCharCategory())||
                            CodesTables.CCHRTCAT_CME.equals(characteristics.getCdCharCategory()) ||
                            CodesTables.CCHRTCAT_OTH.equals(characteristics.getCdCharCategory())) {
              bFoundPlacement = true; // flag to determine if characteristics are complete
              rowcsub14sog02.setSzCdRemovChildChar(characteristics.getCdCharacteristic());
              rowcsub14sog02_array.addROWCSUB14SOG02(rowcsub14sog02);
            }
            csub14so.setROWCSUB14SOG02_ARRAY(rowcsub14sog02_array);
          }
          if (bFoundPlacement) {
            csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(ArchitectureConstants.N);
          } else {
            throw new ServiceException(Messages.MSG_SUB_PLCMT_CHAR_NEEDED); //'Person Characteristics must first be entered'
          }
        } // end else retrieve child characteristics
        // end of section .... call to WorkloadStageDAO (CSES21D)
      }
    } // end .... if WINDOW_MODE_NEW .

    // Add logic to determine which stage we are coming from and if it is INVestigation or Family PReservation,
    // then we need to see if there is a Conclusion or Closure event and what the status is
    // Note: If so far no SQL errors/ no exceptions thrown, execution continues ...
    // Calling StageDAO CINT21D
    // MR-074: moved code up so other sections can use stage data
    //Stage stage = stageDAO.findStageByIdStage(idStage); // move up to be used in other logic
    //if (stage == null) {
    //  throw new ServiceException(Messages.SQL_NOT_FOUND);
    //}
    // Event Retrieval
    // When we find out what the stage is, we need to determine which Event Type to pass to the event retrieval dao
    // Preparing to call DynmaicEvengtDAO CCMN87D
    String szCdStage = stage.getCdStage();
    String[] szCdEventType = new String[1];
    if (CodesTables.CSTAGES_INV.equals(szCdStage) || CodesTables.CSTAGES_FRE.equals(szCdStage)
        || CodesTables.CSTAGES_FSU.equals(szCdStage)) {
      szCdEventType[0] = CodesTables.CEVNTTYP_CCL;
    } else if (CodesTables.CSTAGES_FPR.equals(szCdStage)) {
      szCdEventType[0] = CodesTables.CEVNTTYP_STG;
    }
    // Calling DynamicEventDAO, CCMN87D
    // The first parameter in the findEvents() method below is set to false to indicate it is an Update.
    List<Object[]> listEventObjects = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, szCdEventType, null, null,
                                                                 null, null, null);
    if (listEventObjects == null || listEventObjects.isEmpty()) {
      csub14so.setUlIdEvent(0);
    } else {
      Object[] rowEvents = listEventObjects.get(0);
      // In the returned row Object[], index 0 contains 'szCdEventStatus'
      if (CodesTables.CEVTSTAT_PEND.equals(rowEvents[0])) {
        csub14so.setUlIdEvent((Integer) rowEvents[6] != null ? (Integer) rowEvents[6] : 0);
      } else {
        csub14so.setUlIdEvent(0);
      }
    }
    return csub14so;
  }

  private ROWCSUB14SOG00 retrieveCnsrvtrshpRemoval(int idEvent) throws ServiceException {
    CnsrvtrshpRemoval cnsrvtrshpRemoval = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemoval(idEvent);
    if (cnsrvtrshpRemoval == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    int idVictim = cnsrvtrshpRemoval.getPerson().getIdPerson();
    ROWCSUB14SOG00 rowcsub14sog00 = new ROWCSUB14SOG00();
    rowcsub14sog00.setUlIdEvent(cnsrvtrshpRemoval.getIdRemovalEvent() != null ? cnsrvtrshpRemoval.getIdRemovalEvent()
                                                                             : 0);
    rowcsub14sog00.setUlIdVictim(idVictim);
    rowcsub14sog00
                  .setLNbrRemovalAgeMo(cnsrvtrshpRemoval.getNbrRemovalAgeMo() != null ? cnsrvtrshpRemoval
                                                                                                         .getNbrRemovalAgeMo()
                                                                                     : 0);
    rowcsub14sog00
                  .setLNbrRemovalAgeYr(cnsrvtrshpRemoval.getNbrRemovalAgeYr() != null ? cnsrvtrshpRemoval
                                                                                                         .getNbrRemovalAgeYr()
                                                                                     : 0);
    rowcsub14sog00.setCIndRemovalNACare(cnsrvtrshpRemoval.getIndRemovalNaCare());
    rowcsub14sog00.setCIndRemovalNaChild(cnsrvtrshpRemoval.getIndRemovalNaChild());
    rowcsub14sog00.setTsLastUpdate(cnsrvtrshpRemoval.getDtLastUpdate());
    rowcsub14sog00.setDtDtRemoval(DateHelper.toCastorDate(cnsrvtrshpRemoval.getDtRemoval()));
    rowcsub14sog00.setRbRemovalType(cnsrvtrshpRemoval.getCdRemovalType());
    rowcsub14sog00.setCbParentNotified(cnsrvtrshpRemoval.getIndParentNotified());
    rowcsub14sog00.setTxtFactualDesc(cnsrvtrshpRemoval.getTxtDescriptionOfIncident());
    return rowcsub14sog00;
  }

  private ROWCSUB14SOG01_ARRAY retrieveRemovalReason(int idEvent) throws ServiceException {
    List<RemovalReason> listRemovalReason = removalReasonDAO.findListOfRemovalReasonByIdEvent(idEvent);
    ROWCSUB14SOG01_ARRAY rowcsub14sog01_array = new ROWCSUB14SOG01_ARRAY();
    if (listRemovalReason != null || !listRemovalReason.isEmpty()) {
     
      for (Iterator<RemovalReason> removalReasonIt = listRemovalReason.iterator(); removalReasonIt.hasNext();) {
        RemovalReason removalReason = removalReasonIt.next();
        ROWCSUB14SOG01 rowcsub14sog01 = new ROWCSUB14SOG01();
        rowcsub14sog01.setSzCdRemovalReason(removalReason.getId().getCdRemovalReason());
        rowcsub14sog01.setTsLastUpdate(removalReason.getDtLastUpdate());
        rowcsub14sog01
                      .setUlIdEvent(removalReason.getId().getIdRemovalEvent() != null ? removalReason
                                                                                                     .getId()
                                                                                                     .getIdRemovalEvent()
                                                                                     : 0);
        rowcsub14sog01_array.addROWCSUB14SOG01(rowcsub14sog01);
      }
    }
    return rowcsub14sog01_array;
  }

  private ROWCSUB14SOG02_ARRAY retrieveRemovalCharChild(int idEvent) {
    List<RemovalCharChild> listRemovalCharChild = removalCharChildDAO.findRemovalCharChildByIdRemovalEvent(idEvent);
    ROWCSUB14SOG02_ARRAY rowcsub14sog02_array = new ROWCSUB14SOG02_ARRAY();
    if (listRemovalCharChild != null || !listRemovalCharChild.isEmpty()) {
            for (Iterator<RemovalCharChild> removalCharChildIt = listRemovalCharChild.iterator(); removalCharChildIt
                                                                                                              .hasNext();) {
        RemovalCharChild removalCharChild = removalCharChildIt.next();
        ROWCSUB14SOG02 rowcsub14sog02 = new ROWCSUB14SOG02();
        rowcsub14sog02.setSzCdRemovChildChar(removalCharChild.getId().getCdRemovChildChar());
        rowcsub14sog02.setTsLastUpdate(removalCharChild.getDtLastUpdate());
        rowcsub14sog02.setUlIdEvent(removalCharChild.getEvent().getIdEvent() != null ? removalCharChild.getEvent()
                                                                                                       .getIdEvent()
                                                                                    : 0);
        rowcsub14sog02.setCIndCharChildCurrent(removalCharChild.getIndCharChildCurrent());
        rowcsub14sog02_array.addROWCSUB14SOG02(rowcsub14sog02);
      }
    }
    return rowcsub14sog02_array;
  }

  private ROWCSUB14SOG03_ARRAY retrieveRemovalCharAdult(int idEvent) {

    List<RemovalCharAdult> listRemovalCharAdult = removalCharAdultDAO.findRemovalCharAdultByIdRemovalEvent(idEvent);
    ROWCSUB14SOG03_ARRAY rowcsub14sog03_array = new ROWCSUB14SOG03_ARRAY();
    if (listRemovalCharAdult != null && !listRemovalCharAdult.isEmpty()) {
      
      for (Iterator<RemovalCharAdult> removalCharAdultIt = listRemovalCharAdult.iterator(); removalCharAdultIt
                                                                                                              .hasNext();) {
        RemovalCharAdult removalCharAdult = removalCharAdultIt.next();
        ROWCSUB14SOG03 rowcsub14sog03 = new ROWCSUB14SOG03();
        rowcsub14sog03.setSzCdRemovAdultChar(removalCharAdult.getId().getCdRemovAdultChar());
        rowcsub14sog03.setTsLastUpdate(removalCharAdult.getDtLastUpdate());
        rowcsub14sog03.setUlIdEvent(removalCharAdult.getEvent().getIdEvent() != null ? removalCharAdult.getEvent()
                                                                                                       .getIdEvent()
                                                                                    : 0);
        rowcsub14sog03_array.addROWCSUB14SOG03(rowcsub14sog03);
      }
    }
    return rowcsub14sog03_array;
  }

  private ROWCSUB14SOG04 retrieveEvent(int idEvent) throws ServiceException {
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCSUB14SOG04 rowcsub14sog04 = new ROWCSUB14SOG04();
    rowcsub14sog04.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowcsub14sog04.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowcsub14sog04.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowcsub14sog04.setSzCdTask(event.getCdTask());
    rowcsub14sog04.setSzCdEventStatus(event.getCdEventStatus());
    rowcsub14sog04.setSzCdEventType(event.getCdEventType());
    rowcsub14sog04.setSzTxtEventDescr(event.getTxtEventDescr());
    rowcsub14sog04.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowcsub14sog04.setTsLastUpdate(event.getDtLastUpdate());
    return rowcsub14sog04;
  }
  
  /**
   * Finds all the open safety resource placements for a child.
   * @param idPerson
   * @return boolean
   */
  private boolean hasOpenSafetyResourcePlacements (int idPerson) {
    boolean openPlacements = true;
    List<SafetyResourceChild> placementList = safetyResourceChildDAO.findOpenSafetyResourcesForChild(idPerson);
    if (placementList == null || placementList.isEmpty()) {
      openPlacements = false;
    }
    return openPlacements;
  }
  /**
   * Retrieve Person Characteristics and populate retrieve SO object for existing removal only. Child Characteristic
   * should already filled out. It can be Not Yet Diagnosed or Non Diagnosed.
   * @param idPerson
   * @param dtStageClose
   * @param csub14so
   */
  private void retrievePersonCharacteristics(int idPerson, Date dtStageClose, CSUB14SO csub14so) {
	  boolean bNAChild = true;
	  csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(ArchitectureConstants.Y);
	  ROWCSUB14SOG02_ARRAY rowcsub14sog02_array = new ROWCSUB14SOG02_ARRAY();
	  
	  List<Characteristics> listCharacteristics = characteristicsDAO.findCharacteristicsByIdPerson(idPerson, dtStageClose);
	  if (listCharacteristics == null || listCharacteristics.isEmpty()) {
		  return;
	  }
	  
	  for (Iterator<Characteristics> characteristicsIt = listCharacteristics.iterator(); characteristicsIt
                                            .hasNext();) {
		  Characteristics characteristics = characteristicsIt.next();
		  ROWCSUB14SOG02 rowcsub14sog02 = new ROWCSUB14SOG02();
		  if (CodesTables.CCHRTCAT_CPM.equals(characteristics.getCdCharCategory()) ||
				  CodesTables.CCHRTCAT_CHB.equals(characteristics.getCdCharCategory())||
				  CodesTables.CCHRTCAT_CME.equals(characteristics.getCdCharCategory()) ||
				  CodesTables.CCHRTCAT_OTH.equals(characteristics.getCdCharCategory())) {
			  bNAChild = false; // child has characteristics recorded at time of removal
			  rowcsub14sog02.setSzCdRemovChildChar(characteristics.getCdCharacteristic());
			  rowcsub14sog02_array.addROWCSUB14SOG02(rowcsub14sog02);
		  }
		  csub14so.setROWCSUB14SOG02_ARRAY(rowcsub14sog02_array);
	  }
	  if (!bNAChild) {
		  csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(ArchitectureConstants.N);
	  } 

  }
  
  
}
