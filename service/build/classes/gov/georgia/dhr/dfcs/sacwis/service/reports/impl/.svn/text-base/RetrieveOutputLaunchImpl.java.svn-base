package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthCauseCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthNrFltySeriInjDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OutputLaunchEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VisitationTypeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChldDthNrFltySeriInj;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.db.VisitationType;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveOutputLaunch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB59SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay;
import gov.georgia.dhr.dfcs.sacwis.structs.output.VisitCbxDisplay_Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class RetrieveOutputLaunchImpl extends BaseServiceImpl implements RetrieveOutputLaunch {

  private static final String WINDOW_MODE_NEW = "1";
  
  private static final String WINDOW_MODE_NEW_USING = "2";
  
  private static final List<String> CD_NF_SI_TASK_CODES = new ArrayList<String>() {
    {
      add("6110"); // -- Child Death/Near Fatality / Serious Injury task code in INT
      add("6220"); // -- Child Death/Near Fatality / Serious Injury task code in INV
      add("6330"); // -- Child Death/Near Fatality / Serious Injury task code in FPR
      add("6440"); // -- Child Death/Near Fatality / Serious Injury task code in SUB
      add("6550"); // -- Child Death/Near Fatality / Serious Injury task code in ADO
      add("6660"); // -- Child Death/Near Fatality / Serious Injury task code in PFC    
    }
  };

  private ChldDthCauseCbxDAO chldDthCauseCbxDAO = null;
  
  private ChldDthNrFltySeriInjDAO chldDthNrFltySeriInjDAO = null;
  
  private EventDAO eventDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;

  private TaskDAO taskDAO = null;

  private OutputLaunchEventLinkDAO outputLaunchEventLinkDAO = null;  
  
  private VisitationTypeDAO visitationTypeDAO = null;  
  
  public void setChldDthCauseCbxDAO(ChldDthCauseCbxDAO chldDthCauseCbxDAO) {
    this.chldDthCauseCbxDAO = chldDthCauseCbxDAO;
  }

  public void setChldDthNrFltySeriInjDAO(ChldDthNrFltySeriInjDAO chldDthNrFltySeriInjDAO) {
    this.chldDthNrFltySeriInjDAO = chldDthNrFltySeriInjDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  } 
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO; 
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  public void setOutputLaunchEventLinkDAO(OutputLaunchEventLinkDAO outputLaunchEventLinkDAO) {
    this.outputLaunchEventLinkDAO = outputLaunchEventLinkDAO;
  }
  
  public void setVisitationTypeDAO(VisitationTypeDAO visitationTypeDAO) {
	    this.visitationTypeDAO = visitationTypeDAO;
	  }

  public CSUB59SO retrieveOutputLaunch(CSUB59SI csub59si) throws ServiceException {

    CSUB59SO csub59so = new CSUB59SO();
    // declared here so it has method scope
    ROWCSUB59SOG00 rowcsub59sog00 = new ROWCSUB59SOG00();
    int idEvent = csub59si.getUlIdEvent();
    String cdEventType = rowcsub59sog00.getSzCdEventType();
   

    Stage stage = stageDAO.findStageByIdStage(csub59si.getUlIdStage());

    csub59so.setUlIdCase(stage.getCapsCase().getIdCase() != null ? stage.getCapsCase().getIdCase() : 0);

    if ((0 != csub59si.getUlIdEvent()) && (0 != stage.getIdStage())) {

      Event event = eventDAO.findEventByIdEvent(csub59si.getUlIdEvent());

      if (0 != event.getIdEvent()) {
      }

      rowcsub59sog00.setSzCdEventType(event.getCdEventType());
      rowcsub59sog00.setSzTxtEventDescr(event.getTxtEventDescr());
      rowcsub59sog00.setSzCdTask(event.getCdTask());
      rowcsub59sog00.setSzCdEventStatus(event.getCdEventStatus());
      rowcsub59sog00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
      rowcsub59sog00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
      Person person = event.getPerson();
      if (person != null) {
        rowcsub59sog00.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
      }
      rowcsub59sog00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      rowcsub59sog00.setTsLastUpdate(event.getDtLastUpdate());

     // get OutputLaunchEventlink
      OutputLaunchEventLink outputLaunchEventLink =outputLaunchEventLinkDAO.findOutputLaunchEventLink(event.getIdEvent());
      
      if (outputLaunchEventLink != null) {

        rowcsub59sog00.setCIndCurrent(outputLaunchEventLink.getIndCurrent());

        rowcsub59sog00.setTsSysTsLastUpdate2(outputLaunchEventLink.getDtLastUpdate());

      }
      
    // MR-094 Visitation Type
      List <VisitationType> cbxList = visitationTypeDAO.findVisitationTypeByEvent(idEvent);
      if (cbxList != null && !cbxList.isEmpty()) {
        VisitCbxDisplay_Array cbxDisplayArray = new VisitCbxDisplay_Array();
        cbxDisplayArray.setUlRowQty(cbxList.size());
        for (VisitationType cbx : cbxList) {
          VisitCbxDisplay cbxDisplay = new VisitCbxDisplay();
          cbxDisplay.setSzCdVisitTypeCbx(cbx.getCdVisitationType());
          cbxDisplayArray.addVisitCbxDisplay(cbxDisplay);
        }
        csub59so.setVisitCbxDisplay_Array(cbxDisplayArray);
      }
      
   
      csub59so.setROWCSUB59SOG00(rowcsub59sog00);

      String sysTxtTableName = Lookup.simpleDecodeSafe(CodesTables.CEVNTTBL, csub59so.getROWCSUB59SOG00()
                                                                                     .getSzCdEventType());

      Date narrativeDate = commonDAO.findDtLastUpdate(sysTxtTableName, csub59si.getUlIdEvent());

      if (DateHelper.isNull(narrativeDate)) {
        csub59so.setTsLastUpdate(null);
      } else {
        csub59so.setTsLastUpdate(narrativeDate);
      }
    } else if (0 != stage.getIdStage()) {

      Task task = taskDAO.findTaskByCdTask(csub59si.getSzCdTask());

      if (task.getCdTask() == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      rowcsub59sog00.setSzCdEventType(task.getCdTaskEventType());
      csub59so.setROWCSUB59SOG00(rowcsub59sog00);

    }

    
    

    return csub59so;

  }

  //STGAP00015749: Added method for CAPTA: CD/NF/SI event
  public CDNFRetrieveSO retrieveOutputLaunch(CDNFRetrieveSI cdnfRetrieveSI) throws ServiceException {
    CSUB59SI csub59si = cdnfRetrieveSI.getCsub59si();
    CSUB59SO csub59so = new CSUB59SO();
    CDNFRetrieveSO cdnfRetrieveSO = new CDNFRetrieveSO();
    // declared here so it has method scope
    ROWCSUB59SOG00 rowcsub59sog00 = new ROWCSUB59SOG00();

    Stage stage = stageDAO.findStageByIdStage(csub59si.getUlIdStage());
    String cdEventType = csub59si.getSzCdTask();
    String eventType = rowcsub59sog00.getSzCdEventType();
    String nameVictim = StringHelper.EMPTY_STRING;

    csub59so.setUlIdCase(stage.getCapsCase().getIdCase() != null ? stage.getCapsCase().getIdCase() : 0);

    if ((0 != csub59si.getUlIdEvent()) && (0 != stage.getIdStage())) {     

      Event event = eventDAO.findEventByIdEvent(csub59si.getUlIdEvent());      
   


      rowcsub59sog00.setSzCdEventType(event.getCdEventType());
      rowcsub59sog00.setSzTxtEventDescr(event.getTxtEventDescr());
      rowcsub59sog00.setSzCdTask(event.getCdTask());
      rowcsub59sog00.setSzCdEventStatus(event.getCdEventStatus());
      rowcsub59sog00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
      rowcsub59sog00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
      Person person = event.getPerson();
      if (person != null) {
        rowcsub59sog00.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
      }
      rowcsub59sog00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      rowcsub59sog00.setTsLastUpdate(event.getDtLastUpdate());

      // get OutputLaunchEventlink
      OutputLaunchEventLink outputLaunchEventLink = outputLaunchEventLinkDAO.findOutputLaunchEventLink(event.getIdEvent());

      if (outputLaunchEventLink != null) {

        rowcsub59sog00.setCIndCurrent(outputLaunchEventLink.getIndCurrent());

        rowcsub59sog00.setTsSysTsLastUpdate2(outputLaunchEventLink.getDtLastUpdate());

      }

      csub59so.setROWCSUB59SOG00(rowcsub59sog00);

      String sysTxtTableName = Lookup.simpleDecodeSafe(CodesTables.CEVNTTBL, csub59so.getROWCSUB59SOG00()
                                                                                     .getSzCdEventType());

      Date narrativeDate = commonDAO.findDtLastUpdate(sysTxtTableName, csub59si.getUlIdEvent());

      if (DateHelper.isNull(narrativeDate)) {
        csub59so.setTsLastUpdate(null);
      } else {
        csub59so.setTsLastUpdate(narrativeDate);
      }

      ChldDthNrFltySeriInj cldDthRec = chldDthNrFltySeriInjDAO
                                                              .findChldDthNrFltySeriInjByIdEvent(csub59si
                                                                                                         .getUlIdEvent());
      if (cldDthRec != null) {
        cdnfRetrieveSO.setIdCase(cldDthRec.getCapsCase().getIdCase());
        cdnfRetrieveSO.setIdEvent(cldDthRec.getIdEvent());
        cdnfRetrieveSO.setCountyOfDeath(cldDthRec.getCountyOfDeath());
        cdnfRetrieveSO.setAutopsyCompleted(cldDthRec.getAutopsyCompleted());
        cdnfRetrieveSO.setTxtCommentsAutopsy(cldDthRec.getCommentsAutopsy());
        cdnfRetrieveSO.setTxtCommentsCauseDeath(cldDthRec.getCommentsCauseDeath());
        cdnfRetrieveSO.setDeathPrev(cldDthRec.getDeathPreventable());
        cdnfRetrieveSO.setTxtCommentsDeathPrev(cldDthRec.getCommentsDeathPreventable());
        cdnfRetrieveSO.setTxtCommentsRepSub(cldDthRec.getCommentsReportSubmitted());
        cdnfRetrieveSO.setReportSubmittedWith24Hrs(cldDthRec.getReportSubmittedWithin24hrs());

        cdnfRetrieveSO.setIdChild(cldDthRec.getIdChild());
        person = (Person) getPersistentObject(Person.class, cldDthRec.getIdChild());
        Date dtOfBirth = person.getDtPersonBirth();
        String nmFirst = person.getNmPersonFirst();
        String nmLast = person.getNmPersonLast();
        String nmMiddle = person.getNmPersonMiddle();
        if (nmMiddle != null) {
          char m = nmMiddle.charAt(0);
          nmMiddle = m + StringHelper.EMPTY_STRING;
        } else {
          nmMiddle = StringHelper.EMPTY_STRING;
        }
        cdnfRetrieveSO.setNmFirst(nmFirst);
        cdnfRetrieveSO.setNmLast(nmLast);
        cdnfRetrieveSO.setNmMiddle(nmMiddle);
        cdnfRetrieveSO.setDtPersonBirth(dtOfBirth);
        
        cdnfRetrieveSO.setCdStage(stage.getCdStage());
        //SMS#54782
        cdnfRetrieveSO.setReportType(cldDthRec.getReportType());
      }

      List<String> savedCausesOfDeath = new ArrayList<String>();
      savedCausesOfDeath = chldDthCauseCbxDAO.findSavedCausesByIdEvent(csub59si.getUlIdEvent());
      cdnfRetrieveSO.setSavedCausesOfDeath(savedCausesOfDeath);

    } else if (0 != stage.getIdStage()) {

      Task task = taskDAO.findTaskByCdTask(csub59si.getSzCdTask());

      if (task.getCdTask() == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      rowcsub59sog00.setSzCdEventType(task.getCdTaskEventType());
      csub59so.setROWCSUB59SOG00(rowcsub59sog00);

    }

    // Call DAOs to retrieve and validate person detail data

    String szSysCdWinMode = csub59si.getSzSysCdWinMode();
    if ((WINDOW_MODE_NEW.equals(szSysCdWinMode) || 0 == csub59si.getUlIdEvent())) {
      //idPerson is the id of person selected by user from person list in INT , INV and ONG stages                                                                                                          
      int idPerson = csub59si.getUlIdPerson();
      Person person = personDAO.findPersonByIdPerson(idPerson);
     //Get PC for FCC, ADO and PFC stages 
      if (CodesTables.CSTAGES_SUB.equals(stage.getCdStage()) || CodesTables.CSTAGES_ADO.equals(stage.getCdStage())
          || CodesTables.CSTAGES_PFC.equals(stage.getCdStage())) {
        Collection<StagePersonLink> stagePersonLinks = stage.getStagePersonLinks();
        java.util.Iterator<StagePersonLink> it = stagePersonLinks.iterator();
        while (it.hasNext()) {
          StagePersonLink spl = it.next();
          String cdPersRole = spl.getCdStagePersRole();
          if (CodesTables.CROLEALL_PC.equals(cdPersRole)) {
            person = spl.getPerson();
            break;
          }
        }
      }
      
      if (person != null) {
        Date dtPersonBirth = person.getDtPersonBirth();
        String nmPerson = person.getNmPersonFull();
        String nmFirst = person.getNmPersonFirst();
        String nmMiddle = person.getNmPersonMiddle();
        String nmLast = person.getNmPersonLast();
        if(nmMiddle != null ){
          nmMiddle = nmMiddle.substring(0, 1);
        }else{
          nmMiddle = StringHelper.EMPTY_STRING;
        }
        
        cdnfRetrieveSO.setNmFirst(nmFirst);
        cdnfRetrieveSO.setNmMiddle(nmMiddle);
        cdnfRetrieveSO.setNmLast(nmLast);
        
        if (!DateHelper.isNull(dtPersonBirth)) {
          // A comparison between the current date and the child's birthday is performed to check if the child
          // is older than 18 years.
          if (DateHelper.getAge(dtPersonBirth) >= 18) {
            throw new ServiceException(Messages.MSG_CDNFSI_OVER_18);
          }
        }
        csub59so.setDtDtPersonBirth(DateHelper.toCastorDate(dtPersonBirth));
        cdnfRetrieveSO.setDtPersonBirth(dtPersonBirth);
        if (nmPerson != null) {
          csub59so.setSzNmPersonFull(nmPerson);
        }

      }
    }
    cdnfRetrieveSO.setCsub59SO(csub59so);

    return cdnfRetrieveSO;
}
}
