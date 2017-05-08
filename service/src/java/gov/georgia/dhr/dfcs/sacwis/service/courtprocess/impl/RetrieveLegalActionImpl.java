package gov.georgia.dhr.dfcs.sacwis.service.courtprocess.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AttendeesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionCrtLangDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageRepLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionCrtLang;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageRepLink;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.RetrieveLegalAction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdCrtLang_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdOutcome_Array;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Change History:
Date        User              Description
--------    ----------------  ----------------------------------------------------------------------------------------------------
      
02/10/2010  mxpatel           STGAP00015776: Added validations so that if there is an unassigned date for person in the stage with 
                              a relationship to the child of CASA or Atty/GAL - that is equal or prior (equal or before) 
                              to the court action date, that person will not be displayed in the section on attendees/involved parties
03/18/2010  arege             SMS#48198: A CASA , GAL Atty and GAL- NonAtty should also be displayed after the initial Save on the 
                              attendees/involved parties section if the dtAssigned is nul or equal or after the court action date. 
03/18/2010  arege             SMS#48198: Added CRPTRINT_GY to the if clause to include GAL Non-Atty
04/22/2010  wcochran          SMS #37289 - Modified Retrieve when Copying a Legal Action from one sibling to another. It now
                              pulls the primary child from the current stage rather than the child from the copied legal action.
*/

public class RetrieveLegalActionImpl extends BaseServiceImpl implements RetrieveLegalAction {

  //-- What is a role of "CL"?
  //public static final String CLIENT = CodesTables.CSECATTR_CL;
	
  public static final String NARRATIVE_TXT_DESCR = "LEGAL_ACTIONS_NARRATIVE";

  public static final String PRIMARY_CHILD = CodesTables.CROLES_PC;

  public static final String SUB_CARE = CodesTables.CSTAGES_SUB;

  public static final String ADOPTION = CodesTables.CSTAGES_ADO;

  public static final String FAM_REUNIFICATION = CodesTables.CSTAGES_FRE;

  public static final String FAM_SUBCARE = CodesTables.CSTAGES_FSU;

  public static final String FAM_PRESERVATION = CodesTables.CSTAGES_FPR;

  public static final String INVESTIGATION = CodesTables.CSTAGES_INV;

  public static final String POST_ADOPT = CodesTables.CSTAGES_PAD;
  
  public static final String POST_FOSTER = CodesTables.CSTAGES_PFC;

  public static final String CAPS_PROG_CPS = CodesTables.CPGRMS_CPS;

  public static final String STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;
  
  public static final String STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String VICTIM = CodesTables.CROLES_VC;

  public static final String VICTIM_PERPETRATOR = CodesTables.CROLES_VP;
  
  private AttendeesDAO attendeesDAO;
  
  private ComplexStageDAO complexStageDAO = null;
  
  private EventDAO eventDAO = null;
  
  private LegalActionCrtLangDAO legalActionCrtLangDAO;

  private LegalActionOutcomeDAO legalActionOutcomeDAO;
  
  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;
  
  private StageRepLinkDAO stageRepLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  public void setAttendeesDAO(AttendeesDAO attendeesDAO) {
    this.attendeesDAO = attendeesDAO;
  }
  
  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setLegalActionCrtLangDAO(LegalActionCrtLangDAO legalActionCrtLangDAO) {
    this.legalActionCrtLangDAO = legalActionCrtLangDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStageRepLinkDAO(StageRepLinkDAO stageRepLinkDAO) {
    this.stageRepLinkDAO = stageRepLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CSUB38SO retrieveLegalAction(CSUB38SI csub38si) throws ServiceException {

    CSUB38SO csub38so = new CSUB38SO();

    csub38so.setROWCSUB38SOG00(new ROWCSUB38SOG00());
    csub38so.setROWCSUB38SOG01(new ROWCSUB38SOG01());

    ROWCSUB38SOG00 rowcsub38sog00 = csub38so.getROWCSUB38SOG00();
    ROWCSUB38SOG01 rowcsub38sog01 = csub38so.getROWCSUB38SOG01();

    int idStage = csub38si.getUlIdStage();
    String cdStage = csub38si.getSzCdStage();
    //-- sysIndDamCalled IS PAGEMODE
    String sysIndDamCalled = csub38si.getCSysIndDamCalled();

    // cint21dQUERYdam
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null)
    {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    csub38so.setSzCdStageProgram(stage.getCdStageProgram());

    String cdStageProgram = stage.getCdStageProgram();

    int idEvent = csub38si.getUlIdEvent();
if(idEvent != 0){
    Date dtLastUpdateByIdEvent = commonDAO.findDtLastUpdate(NARRATIVE_TXT_DESCR, idEvent);
    
    if (dtLastUpdateByIdEvent != null) {
      csub38so.setSzScrTxtNarrStatus(NARRATIVE_TXT_DESCR);
      csub38so.setTsLastUpdate(dtLastUpdateByIdEvent);
    } else {
      csub38so.setSzScrTxtNarrStatus("");
    }   
}
    
    //-- if idEvent == 0, assume we are adding a brand new legal action
    //-- Add button pushed
    if (0 == idEvent) {
      if ((INVESTIGATION.equals(cdStage) && (CAPS_PROG_CPS.equals(cdStageProgram))) || (FAM_SUBCARE.equals(cdStage))
          || (FAM_REUNIFICATION.equals(cdStage)) || (FAM_PRESERVATION.equals(cdStage))) {

      } else if (SUB_CARE.equals(cdStage) 
                      || ADOPTION.equals(cdStage) 
                      || POST_ADOPT.equals(cdStage) 
                      || POST_FOSTER.equals(cdStage)) {

        String[] cdStagePersRoleArray = {PRIMARY_CHILD};
        // cinv51dQUERYdam & ccmn44dQUERYdam
        retrieveSetPersonInfo(idStage, cdStagePersRoleArray, csub38so);

      } else {

        //-- What is a role of "CL"?
        //String[] cdStagePersRoleArray = {VICTIM, VICTIM_PERPETRATOR, CLIENT};
        String[] cdStagePersRoleArray = {VICTIM, VICTIM_PERPETRATOR};
        // cinv51dQUERYdam & ccmn44dQUERYdam
        retrieveSetPersonInfo(idStage, cdStagePersRoleArray, csub38so);
      }

      AttendeePerson_Array persons = new AttendeePerson_Array();
      findPopulatePersons(csub38si, persons, rowcsub38sog01);
      csub38so.setAttendeePerson_Array(persons);
    }

    // else IdEvent != 0
    //-- Add button NOT pushed
    else {
      String cdEventStatus = findEvent(idEvent, rowcsub38sog00);
      AttendeePerson_Array aps = new AttendeePerson_Array();
      findPopulateAttendees(idEvent, aps);
      boolean callFindPopulatePersons = true;
      
      //-- If page mode is NOT new using and status is COMP or APRV
      if(!PageModeConstants.NEW_USING.equals(sysIndDamCalled)){
        if(STATUS_COMPLETE.equals(cdEventStatus) || STATUS_APPROVED.equals(cdEventStatus)){
          callFindPopulatePersons = false;
        }
      }
      
      //retrievePopulatePerson(idPerson, csub38so);
      Person person = findPopulateLegalAction(idEvent, rowcsub38sog01, idStage, sysIndDamCalled);
      
      if (callFindPopulatePersons) {
        findPopulatePersons(csub38si, aps, rowcsub38sog01);
      }
      
      csub38so.setUlIdPerson(person.getIdPerson());
      csub38so.setSzNmPersonFull(person.getNmPersonFull());
      
      if(aps.hasUlRowQty() && aps.getUlRowQty() > 0){
        csub38so.setAttendeePerson_Array(aps);
      } else{
        csub38so.setAttendeePerson_Array(null);
      }
      
      //-- retrieve and populate Outcome list
      List<LegalActionOutcome> outcomes = legalActionOutcomeDAO.findLegalActionOutcomeList(idEvent);
      SzCdOutcome_Array outcomeArray = new SzCdOutcome_Array();
      int outcomeArrayRowQty = 0;
      if(outcomes != null && !outcomes.isEmpty()){
        for(Iterator<LegalActionOutcome> it = outcomes.iterator(); it.hasNext();){
          LegalActionOutcome lao = it.next();
          outcomeArray.addSzCdOutcome(lao.getCdOutcome());
          outcomeArrayRowQty++;
        }
      }
      outcomeArray.setUlRowQty(outcomeArrayRowQty);
      csub38so.setSzCdOutcome_Array(outcomeArray);
      
      //-- retrieve and populate Court Language list
      List<LegalActionCrtLang> crtLangs = legalActionCrtLangDAO.findLegalActionCrtLangList(idEvent);
      SzCdCrtLang_Array crtLangArray = new SzCdCrtLang_Array();
      int crtLangArrayRowQty = 0;
      if(crtLangs != null && !crtLangs.isEmpty()){
        for(Iterator<LegalActionCrtLang> it = crtLangs.iterator(); it.hasNext();){
          LegalActionCrtLang lacl = it.next();
          crtLangArray.addSzCdCrtLang(lacl.getCdCrtLang());
          crtLangArrayRowQty++;
        }
      }
      crtLangArray.setUlRowQty(crtLangArrayRowQty);
      csub38so.setSzCdCrtLang_Array(crtLangArray);
    }

    return csub38so;
  }

  private String findEvent(int idEvent, ROWCSUB38SOG00 rowcsub38sog00) throws ServiceException

  {
    Event event = eventDAO.findEventByIdEvent(idEvent);

    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    else
    {
      rowcsub38sog00.setSzCdEventType(event.getCdEventType());
      rowcsub38sog00.setSzTxtEventDescr(event.getTxtEventDescr());
      rowcsub38sog00.setSzCdTask(event.getCdTask());
      rowcsub38sog00.setSzCdEventStatus(event.getCdEventStatus());
      rowcsub38sog00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
      rowcsub38sog00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
      rowcsub38sog00.setUlIdEventPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
      rowcsub38sog00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      rowcsub38sog00.setTsLastUpdate(event.getDtLastUpdate());

    }
    return event.getCdEventStatus();
  }

  private Person findPopulateLegalAction(int idEvent, ROWCSUB38SOG01 rowcsub38sog01, int idStage, String sysIndDamCalled) throws ServiceException {
    LegalAction legalAction = this.getPersistentObject(LegalAction.class, idEvent);

    if (legalAction == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      rowcsub38sog01.setUlIdLegalActEvent(legalAction.getIdLegalActEvent());
    }
    rowcsub38sog01.setTsLastUpdate(legalAction.getDtLastUpdate());
    /* SMS #37289 - Copying a legal action from a sibling was 
     * linking the sibling to the new event and not the primary child
     * of the current stage. This change will pull the ID of
     * the primary child for the stage and add it to the copied
     * legal action.
     */
    Person person = new Person();
    if(PageModeConstants.NEW_USING.equals(sysIndDamCalled)){
      Integer idPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
      person = getPersistentObject(Person.class, idPerson);
    } else {
      person = legalAction.getPerson();
    }

    rowcsub38sog01.setUlIdPerson(person.getIdPerson());
    rowcsub38sog01.setDtDtLegalActDateFiled(DateHelper.toCastorDate(legalAction.getDtLegalActDateFiled()));
    //rowcsub38sog01.setDtDtLegalActOutcomeDt(DateHelper.toCastorDate(legalAction.getDtLegalActOutcomeDt()));
    rowcsub38sog01.setCIndLegalActDocsNCase(legalAction.getIndLegalActDocsNCase());
    rowcsub38sog01.setSzCdLegalActAction(legalAction.getCdLegalActAction());
    //rowcsub38sog01.setSzCdLegalActActnSubtype(legalAction.getCdLegalActActnSubtype());
    rowcsub38sog01.setSzCdLegalActOutcome(legalAction.getCdLegalActOutcome());
    //rowcsub38sog01.setSzTxtLegalActComment(legalAction.getTxtLegalActComment());
    rowcsub38sog01.setSzCdCounty(legalAction.getCdCounty());
    int nbrCrtFile = legalAction.getNbrCrtFile() != null ? legalAction.getNbrCrtFile() : 0;
    rowcsub38sog01.setUlNbrCrtFile(nbrCrtFile);
    rowcsub38sog01.setSzCdCrtCaseNbr(legalAction.getCrtCaseNbr());
    rowcsub38sog01.setDtCrtActDate(DateHelper.toCastorDate(legalAction.getDtCrtActDate()));
    rowcsub38sog01.setSzCdCrtType(legalAction.getCdCrtType());
    rowcsub38sog01.setSzCdHrTypCrtOrd(legalAction.getCdHrTypCrtOrd());
    rowcsub38sog01.setDtNxtHearDate(DateHelper.toCastorDate(legalAction.getDtNxtHearDate()));
    rowcsub38sog01.setDtContinDate(DateHelper.toCastorDate(legalAction.getDtContinDate()));
    rowcsub38sog01.setDtCrtOrdDate(DateHelper.toCastorDate(legalAction.getDtCrtOrdDate()));
    rowcsub38sog01.setDtPubDate(DateHelper.toCastorDate(legalAction.getDtPubDate()));
    rowcsub38sog01.setIndUpPrevAct(legalAction.getIndUpPrevAct());
    rowcsub38sog01.setIndComplete(legalAction.getIndComplete());
    rowcsub38sog01.setSzCdState(legalAction.getCdState());
    rowcsub38sog01.setTsDtShelterCareAuth(legalAction.getDtShelterCareAuth());
    rowcsub38sog01.setNmCrtOrdPrepBy(legalAction.getNmCrtOrdPrepBy());
    rowcsub38sog01.setIndCrtOrdSigned(legalAction.getIndCrtOrdSigned());
    rowcsub38sog01.setIndAmendment(legalAction.getIndAmendment());
    rowcsub38sog01.setBIndNoRepAppointed(legalAction.getIndLegalRepAppointed());

    //return idPerson;
    return person;
  }

  private void retrieveSetPersonInfo(int idStage, String[] cdStagePersRoleArray, CSUB38SO csub38so)
          throws ServiceException {

    // Retrieve Persion Info
    Integer idPerson = null;

    for (int i = 0; i < cdStagePersRoleArray.length; i++) {
      String cdStagePersRole = cdStagePersRoleArray[i];

      // Get IdPerson given IdStage & Role
      // cinv51dQUERYdam
      idPerson = complexStageDAO.findPrimaryWorker(idStage, cdStagePersRole);
      if (idPerson != null) {
        break;
      }
    }

    // Check all the roles in cdStagePersRoleArray. if idPersion is still null then throw SQL_NOT_FOUND exception.
    if (idPerson == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    //retrievePopulatePerson(idPerson, csub38so);
    Person person = this.getPersistentObject(Person.class, idPerson);

    if (person == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // Set Person Info
    csub38so.setUlIdPerson(person.getIdPerson());
    csub38so.getROWCSUB38SOG01().setUlIdPerson(person.getIdPerson());
    csub38so.setSzNmPersonFull(person.getNmPersonFull());
  }
  
  private void findPopulateAttendees(int idEvent, AttendeePerson_Array aps) {
    if (idEvent <= 0) {
      return;
    } else {
      int rowQty = 0;
      if (aps == null) {
        aps = new AttendeePerson_Array();
      } else if (aps.hasUlRowQty() && aps.getUlRowQty() > 0) {
        rowQty = aps.getUlRowQty();
      }
      List<Map> results = attendeesDAO.findAttendeesByIdLegalActEvent(idEvent);
      for (Iterator<Map> it = results.iterator(); it.hasNext();) {
        Map row = it.next();
        AttendeePerson attendee = new AttendeePerson();
        attendee.setUlIndIsAttendee(1);
        Integer idPerson = (Integer) row.get("idAttdPerson");
        if (idPerson == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        attendee.setUlIdPerson(idPerson);

        Person person = personDAO.findPersonByIdPerson(idPerson);
        if (person == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        attendee.setSzNmPersonFull(person.getNmPersonFull());
        attendee.setSzCdStagePersType((String) row.get("cdAttdType"));
        attendee.setSzCdStagePersRole((String) row.get("cdAttdRole"));
        attendee.setSzCdStagePersRelInt((String) row.get("cdAttdRelation"));
        aps.addAttendeePerson(attendee);
        rowQty++;
      }
      aps.setUlRowQty(rowQty);
    }
  }

  private void findPopulatePersons(CSUB38SI csub38si, AttendeePerson_Array aps, ROWCSUB38SOG01 rowcsub38sog01) {
    int idStage = csub38si.getUlIdStage();
    int idEvent = csub38si.getUlIdEvent();
    if (idStage <= 0) {
      return;
    } else {
      boolean checkPersonsAgainstAttendees = true;
      int rowQty = 0;
      if (aps == null) {
        aps = new AttendeePerson_Array();
        checkPersonsAgainstAttendees = false;
      } else if (!aps.hasUlRowQty() || aps.getUlRowQty() <= 0) {
        checkPersonsAgainstAttendees = false;
      } else {
        rowQty = aps.getUlRowQty();
      }
      //List<Map> results = stagePersonLinkDAO.findPersonsForAttendeesArray(idCase);
      List<Map> results = stagePersonLinkDAO.findPersonsForAttendeesArrayByIdStage(idStage);
      for (Iterator<Map> it = results.iterator(); it.hasNext();) {
        boolean dontAdd = false;
        Map resultRow = it.next();
        AttendeePerson person = new AttendeePerson();
        person.setUlIndIsAttendee(0);
        Integer idPerson = (Integer) resultRow.get("idPerson");
        Date crtActDate = DateHelper.toJavaDate(rowcsub38sog01.getDtCrtActDate());
        Date dtUnassinged = null;
        Date dtAssigned = null;
        // added this code for defect #STGAP00015776: if there is an unassigned date for person in the stage with
        // a relationship to the child of CASA or Atty/GAL - that is equal or prior (equal or before)
        // to the court action date, that person will not be displayed in the section on attendees/involved parties
        // Currently this does not work before initial save. i.e. when we add a new event by clicking on add, we will
        // see
        // all persons regardless of the unassigned date. Once the date event is saved, it will display results
        // correctly.
        // However, if you check the person (the one that will not be displayed after the inital save) before inital
        // save, that
        // person will always be displayed.
        boolean personCasaGal = false;
        if ((CodesTables.CRPTRINT_CS.equals((String) resultRow.get("cdStagePersRelInt")))
            || (CodesTables.CRPTRINT_GX.equals((String) resultRow.get("cdStagePersRelInt"))) 
            || (CodesTables.CRPTRINT_GY.equals((String) resultRow.get("cdStagePersRelInt"))) 
                 ) {
          StageRepLink stageRepLink = stageRepLinkDAO.findStageRepLinkByIdPersonIdStage(idPerson, idStage);
          if (stageRepLink != null) {
            dtUnassinged = stageRepLink.getDtRepEnd();
            dtAssigned = stageRepLink.getDtRepStart();
          }
          personCasaGal = true;
        }else{
          personCasaGal = false;
        }
        
        //Add a person to the list if he is 
        // a Not Casa CS, GX 
        // if event is new and court action date is null , add all persons 
        // if a person is CS, GX check if he has dtAssigned <= CrtActDate and (dtUnassigned is >= CrtActDate  or dtUnAssigned is null)
        if ((personCasaGal && !DateHelper.isBefore(dtUnassinged, crtActDate) && (DateHelper.isBefore(dtAssigned,
                                                                                                     crtActDate) || DateHelper
                                                                                                                              .isEqual(
                                                                                                                                       dtAssigned,
                                                                                                                                       crtActDate)))
            || (idEvent == 0 && crtActDate == null) || !personCasaGal) {
            person.setUlIdPerson(idPerson == null ? 0 : idPerson);
            person.setSzNmPersonFull((String) resultRow.get("nmPersonFull"));
            person.setSzCdStagePersType((String) resultRow.get("cdStagePersType"));
            person.setSzCdStagePersRole((String) resultRow.get("cdStagePersRole"));
            person.setSzCdStagePersRelInt((String) resultRow.get("cdStagePersRelInt"));
            if (checkPersonsAgainstAttendees) {
              for (Enumeration e = aps.enumerateAttendeePerson(); e.hasMoreElements();) {
                AttendeePerson attendee = (AttendeePerson) e.nextElement();
                if (isSamePerson(attendee, person)) {
                  dontAdd = true;
                }
              }
            }
            if (dontAdd) {
              continue;
            }
            aps.addAttendeePerson(person);
            rowQty++;

          }
        
      }
      aps.setUlRowQty(rowQty);
    }
  }

  private boolean isSamePerson(AttendeePerson attendee, AttendeePerson person) {
    if (attendee == null || person == null) {
      return false;
    } else if (attendee.getUlIdPerson() != person.getUlIdPerson()) {
      return false;
    } else if (!attendee.getSzCdStagePersType().equals(person.getSzCdStagePersType())) {
      return false;
    } else if (!attendee.getSzCdStagePersRole().equals(person.getSzCdStagePersRole())) {
      return false;
    } else if (!attendee.getSzCdStagePersRelInt().equals(person.getSzCdStagePersRelInt())) {
      return false;
    } else {
      return true;
    }
  }
}
