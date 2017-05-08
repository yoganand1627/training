package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.SaDrugExposedNewbornsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaReasonableEffortsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyFactorDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SaDrugExposedNewborns;
import gov.georgia.dhr.dfcs.sacwis.db.SaReasonableEfforts;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyFactor;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrieveIsDrugExposedNewborn;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrieveSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DrugExposedNewBornRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ReasonableEffortsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorsRetrieveSO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RetrieveSafetyAssessmentImpl extends BaseServiceImpl implements RetrieveSafetyAssessment {

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;
  
  private SaDrugExposedNewbornsDAO saDrugExposedNewbornsDAO = null;
  private EventDAO eventDAO = null;
  private SaReasonableEffortsDAO saReasonableEffortsDAO = null;
  private RetrieveIsDrugExposedNewborn retrieveIsDrugExposedNewborn = null;
  private SaSafetyAssessmentDAO saSafetyAssessmentDAO = null;
  private SaSafetyFactorDAO saSafetyFactorDAO = null;

  public void setSaDrugExposedNewbornsDAO(SaDrugExposedNewbornsDAO saDrugExposedNewbornsDAO) {
    this.saDrugExposedNewbornsDAO = saDrugExposedNewbornsDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
  }

  public void setSaReasonableEffortsDAO(SaReasonableEffortsDAO saReasonableEffortsDAO) {
    this.saReasonableEffortsDAO = saReasonableEffortsDAO;
  }

  public void setRetrieveIsDrugExposedNewborn(RetrieveIsDrugExposedNewborn retrieveIsDrugExposedNewborn) {
    this.retrieveIsDrugExposedNewborn = retrieveIsDrugExposedNewborn;
  }

  public void setSaSafetyAssessmentDAO(SaSafetyAssessmentDAO saSafetyAssessmentDAO) {
    this.saSafetyAssessmentDAO = saSafetyAssessmentDAO;
  }

  public void setSaSafetyFactorDAO(SaSafetyFactorDAO saSafetyFactorDAO) {
    this.saSafetyFactorDAO = saSafetyFactorDAO;
  }

  public SafetyAssessmentRetrieveSO retrieveSafetyAssessment(SafetyAssessmentRetrieveSI safetyAssessmentRetrieveSI)
          throws ServiceException {
    SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO = new SafetyAssessmentRetrieveSO();

    int idEvent = safetyAssessmentRetrieveSI.getUlIdEvent();
    if (idEvent == 0) {
      return safetyAssessmentRetrieveSO;
    } else {
      //retrieve event
      safetyAssessmentRetrieveSO.setROWCCMN45DO(processEventDAO(idEvent));
      
      
      // Retrieve existing Safety Assessment
      SaSafetyAssessment saSafetyAssessment = saSafetyAssessmentDAO.findSafetyAssessmentByIdEvent(idEvent);

      // Set safetyAssessmentRetrieveSO attributes retrieved from saSafetyAssessment
      safetyAssessmentRetrieveSO.setUlIdEvent(saSafetyAssessment.getIdEvent());
      safetyAssessmentRetrieveSO.setSzTxtOverallSafetyDecision(saSafetyAssessment.getCdOvSfDecision());
      safetyAssessmentRetrieveSO.setSzTxtWhyResponses(saSafetyAssessment.getTxtWyRps());
      safetyAssessmentRetrieveSO.setSzTxtAddtnlCommnts(saSafetyAssessment.getTxtAddtnlComments());
      safetyAssessmentRetrieveSO.setSzTxtOtherSafetyFactor(saSafetyAssessment.getOtherSafetyFactor());
      safetyAssessmentRetrieveSO.setDtLastUpdate(saSafetyAssessment.getDtLastUpdate());

      // Retrieve a List of SafetyFactors
      Map<String,Collection<SafetyFactorsRetrieveSO>> safetyFactors_Map = retrieveSafetyFactors(idEvent);
      safetyAssessmentRetrieveSO.setSafetyFactors(safetyFactors_Map);

      // Retrieve a List of ReasonableEfforts
      Map<String,Collection<ReasonableEffortsRetrieveSO>> reasonableEffort_Map = retrieveReasonableEfforts(idEvent);
      safetyAssessmentRetrieveSO.setReasonableEfforts(reasonableEffort_Map);

      // Retrieve a List of DrugExposedNewBorn
      Collection<DrugExposedNewBornRetrieveSO> drugExposedNewborn_List = new ArrayList<DrugExposedNewBornRetrieveSO>();
      drugExposedNewborn_List = retrieveDrugExposedNewborn_List(idEvent);
      safetyAssessmentRetrieveSO.setDrugExposedNewborn(drugExposedNewborn_List);
      
      boolean isDrugExposedNewborn = retrieveIsDrugExposedNewborn.isDrugExposedNewborn(safetyAssessmentRetrieveSI.getUIdStage());
      safetyAssessmentRetrieveSO.setIsDrugExposedNewBorn(isDrugExposedNewborn);

      return safetyAssessmentRetrieveSO;
    }
  }
  
  private Map<String,Collection<ReasonableEffortsRetrieveSO>> retrieveReasonableEfforts(int idEvent) {
    // 
    List<SaReasonableEfforts> reasonableEffortsList = saReasonableEffortsDAO.findReasonableEffortsByIdEvent(idEvent);
    Map<String,Collection<ReasonableEffortsRetrieveSO>> map = new TreeMap<String,Collection<ReasonableEffortsRetrieveSO>>();

    // An empty or null safety factors list is not an error.
    if (reasonableEffortsList != null) {
      for (Iterator<SaReasonableEfforts> it = reasonableEffortsList.iterator(); it.hasNext();) {
        SaReasonableEfforts saReasonableEfforts = it.next();

        ReasonableEffortsRetrieveSO reasonableEffortsRetrieveSO = new ReasonableEffortsRetrieveSO();
        reasonableEffortsRetrieveSO.setDtDtLastUpdateDt(saReasonableEfforts.getDtLastUpdate());
        reasonableEffortsRetrieveSO.setSzTxtChild(saReasonableEfforts.getPerson().getNmPersonFull());
        reasonableEffortsRetrieveSO.setIdChild(saReasonableEfforts.getPerson().getIdPerson());
        reasonableEffortsRetrieveSO
                .setUlIdReasonableEfforts(saReasonableEfforts.getIdSaReasonableEfforts() != null ? saReasonableEfforts
                        .getIdSaReasonableEfforts()
                                          : 0);
        reasonableEffortsRetrieveSO.setszCdReasonableEffortsResponse(saReasonableEfforts.getCdRsbEffortsRps());
        reasonableEffortsRetrieveSO.setSzTxtComments(saReasonableEfforts.getTxtComments());
        // reasonableEffortsRetrieveSO.setSzTxtWhyResponse(saReasonableEfforts.getSaSafetyAssessment().getTxtWyRps());
        String code = saReasonableEfforts.getCdRsbEfforts();
        reasonableEffortsRetrieveSO.setSzCdReasonableEfforts(code);
        Collection<ReasonableEffortsRetrieveSO> collection = map.get(code);
        if (collection==null){
          collection = new ArrayList<ReasonableEffortsRetrieveSO>();
          map.put(code,collection);
        }
        collection.add(reasonableEffortsRetrieveSO);
      }
    }

    return map;
  }

  private Map<String,Collection<SafetyFactorsRetrieveSO>> retrieveSafetyFactors(int idEvent) {
    // 
    List<SaSafetyFactor> safetyFactorList = saSafetyFactorDAO.findSafetyFactorsByIdEvent(idEvent);
    Map<String,Collection<SafetyFactorsRetrieveSO>> map = new HashMap<String,Collection<SafetyFactorsRetrieveSO>>();
    // An empty or null safety factors list is not an error.
    String code =  null;
    if (safetyFactorList != null) {
      for (Iterator<SaSafetyFactor> it = safetyFactorList.iterator(); it.hasNext();) {
        SaSafetyFactor saSafetyFactor = it.next();
        SafetyFactorsRetrieveSO safetyFactorsRetrieveSO = new SafetyFactorsRetrieveSO();
        safetyFactorsRetrieveSO.setDtDtLastUpdateDt(saSafetyFactor.getDtLastUpdate());
        safetyFactorsRetrieveSO
                .setUlIdSafetyFactor(saSafetyFactor.getIdSaSafetyFactor() != null ? saSafetyFactor
                        .getIdSaSafetyFactor()
                                     : 0);
        safetyFactorsRetrieveSO.setSzCdSafetyFactorResponse(saSafetyFactor.getCdSfFactorRps());
        safetyFactorsRetrieveSO.setIdCaretaker(saSafetyFactor.getPersonByIdPersonCaretaker().getIdPerson());
        safetyFactorsRetrieveSO.setTxtCaretaker(saSafetyFactor.getPersonByIdPersonCaretaker().getNmPersonFull());
        safetyFactorsRetrieveSO.setIdChild(saSafetyFactor.getPersonByIdPersonChild().getIdPerson());
        safetyFactorsRetrieveSO.setTxtChild(saSafetyFactor.getPersonByIdPersonChild().getNmPersonFull());
        code= saSafetyFactor.getCdSfFactor();
        safetyFactorsRetrieveSO.setSzCdSafetyFactor(code);
        Collection<SafetyFactorsRetrieveSO> collection = map.get(code);
        if (collection==null){
          collection = new ArrayList<SafetyFactorsRetrieveSO>();
          map.put(code,collection);
        }
        collection.add(safetyFactorsRetrieveSO);
      }
    }

    return map;
  }

  private Collection<DrugExposedNewBornRetrieveSO> retrieveDrugExposedNewborn_List(int idEvent) {
    // 
    List<SaDrugExposedNewborns> drugExposedList = saDrugExposedNewbornsDAO.findDrugExposedNewbornByIdEvent(idEvent);
    Collection<DrugExposedNewBornRetrieveSO> retrieveDrugExposedNewborn_List =
            new ArrayList<DrugExposedNewBornRetrieveSO>();

    // An empty or null safety factors list is not an error.
    if (drugExposedList != null) {
      for (Iterator<SaDrugExposedNewborns> it = drugExposedList.iterator(); it.hasNext();) {
        SaDrugExposedNewborns saDrugExposedNewborns = it.next();

        DrugExposedNewBornRetrieveSO drugExposedNewBornRetrieveSO = new DrugExposedNewBornRetrieveSO();
        drugExposedNewBornRetrieveSO.setUlIdEvent(saDrugExposedNewborns.getSaSafetyAssessment().getIdEvent());
        drugExposedNewBornRetrieveSO.setSzCdDrugExpNb(saDrugExposedNewborns.getCdDrugExpNb());
        drugExposedNewBornRetrieveSO.setSzCdDrugExpNbRps(saDrugExposedNewborns.getCdDrugExpNbRps());
        drugExposedNewBornRetrieveSO.setDtLastUpdateDt(saDrugExposedNewborns.getDtLastUpdate());
        drugExposedNewBornRetrieveSO.setUdDrugExposedNewborn(saDrugExposedNewborns.getIdSaDrugExposedNewborns());
        retrieveDrugExposedNewborn_List.add(drugExposedNewBornRetrieveSO);
      }
    }

    return retrieveDrugExposedNewborn_List;
  }
  
  private ROWCCMN45DO processEventDAO(int idEvent) throws ServiceException {

    // Calling ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

}
