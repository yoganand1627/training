package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.SaDrugExposedNewbornsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaReasonableEffortsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyFactorDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SaDrugExposedNewborns;
import gov.georgia.dhr.dfcs.sacwis.db.SaReasonableEfforts;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyFactor;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.SaveSafetyAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DrugExposedNewBornSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ReasonableEffortsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyAssessmentSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyFactorsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DrugExposedNewBornRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ReasonableEffortsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorsRetrieveSO;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**
 * <pre>
 *                Change History:
 *                Date        User       Description
 *                ----------  ---------- --------------------------------------------------
 *                05/08/2009   cwells    STGAP00013413 If the page has been saved already then we should not 
 *                                       update the entered by field or the Date Event Occurred field on the 
 *                                       event status page.
 *
 **/

public class SaveSafetyAssessmentImpl extends BaseServiceImpl implements SaveSafetyAssessment {

  private CheckStageEventStatus checkStageEventStatus = null;

  private PostEvent postEvent = null;

  private SaDrugExposedNewbornsDAO saDrugExposedNewbornsDAO = null;

  private SaReasonableEffortsDAO saReasonableEffortsDAO = null;

  private SaSafetyAssessmentDAO saSafetyAssessmentDAO = null;

  private SaSafetyFactorDAO saSafetyFactorDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setSaDrugExposedNewbornsDAO(SaDrugExposedNewbornsDAO saDrugExposedNewbornsDAO) {
    this.saDrugExposedNewbornsDAO = saDrugExposedNewbornsDAO;
  }

  public void setSaReasonableEffortsDAO(SaReasonableEffortsDAO saReasonableEffortsDAO) {
    this.saReasonableEffortsDAO = saReasonableEffortsDAO;
  }

  public void setSaSafetyAssessmentDAO(SaSafetyAssessmentDAO saSafetyAssessmentDAO) {
    this.saSafetyAssessmentDAO = saSafetyAssessmentDAO;
  }

  public void setSaSafetyFactorDAO(SaSafetyFactorDAO saSafetyFactorDAO) {
    this.saSafetyFactorDAO = saSafetyFactorDAO;
  }
  
  
  public int saveSafetyAssessment(SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO,SafetyAssessmentSaveSI safetyAssessmentSaveSI) {

    // Old SafetyFactors
    Map<String, Collection<SafetyFactorsRetrieveSO>> origMap = null;
    // Old Drug Exposed
    Collection<DrugExposedNewBornRetrieveSO> origCollDE = null;
    // Old ReasonableEfforts
    Map<String, Collection<ReasonableEffortsRetrieveSO>> origMapRE = null;

    // Get Orig Safety Factors and RE
    if(safetyAssessmentRetrieveSO!=null) {
      origMap = safetyAssessmentRetrieveSO.getSafetyFactors();
      origMapRE = safetyAssessmentRetrieveSO.getReasonableEfforts();
    }

    // Save Old Drug Exposed New borns
    if (safetyAssessmentRetrieveSO.getDrugExposedNewborn().size()>0) {
      origCollDE = safetyAssessmentRetrieveSO.getDrugExposedNewborn();
    }

    ROWCCMN01UIG00 safetyAssessmentEvent = safetyAssessmentSaveSI.getROWCCMN01UIG00();
    int idEvent = safetyAssessmentSaveSI.getUlIdEvent();
    int idStage = safetyAssessmentSaveSI.getIdStage();
    String cdStage = CodesTables.CSTAGES_INV;
    String eventReqFuncCd;
    // set add or update mode
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }

    // make sure stage is not closed
    checkStageEventStatus(eventReqFuncCd, idStage, cdStage);

    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(safetyAssessmentSaveSI.getCdReqFuncCd())) {
// STGAP00013413 If the page has been saved already then we should not 
// update the entered by field on the event status page.
      if(idEvent != 0){
        Event event = getPersistentObject(Event.class, safetyAssessmentSaveSI.getUlIdEvent());
        Person createdBy = event.getPerson();
        java.util.Date dateEntered = event.getDtEventOccurred();
        if(createdBy != null){
          safetyAssessmentEvent.setUlIdPerson(createdBy.getIdPerson());
        }
        if(dateEntered != null){
          safetyAssessmentEvent.setDtDtEventOccurred(DateHelper.toCastorDate(dateEntered));
        }
      }
      CCMN01UO ccmn01uo = callPostEvent(eventReqFuncCd, safetyAssessmentEvent);
      // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
      idEvent = ccmn01uo.getUlIdEvent();
    }

    // Save safetyAssessment
    safetyAssessmentSaveSI.setUlIdEvent(idEvent);
    SaSafetyAssessment safetyAssessment = new SaSafetyAssessment();
    Event event = getPersistentObject(Event.class, safetyAssessmentSaveSI.getUlIdEvent());
    safetyAssessment.setEvent(event);
    CapsCase capsCase = getPersistentObject(CapsCase.class, safetyAssessmentSaveSI.getIdCase());
    safetyAssessment.setCapsCase(capsCase);
    safetyAssessment.setCdOvSfDecision(safetyAssessmentSaveSI.getSzTxtOverallSafetyDecision());
    safetyAssessment.setTxtWyRps(safetyAssessmentSaveSI.getSzTxtWhyResponses());
    safetyAssessment.setTxtAddtnlComments(safetyAssessmentSaveSI.getSzTxtAddtnlCommnts());
    safetyAssessment.setDtLastUpdate(safetyAssessmentSaveSI.getDtLastUpdate());
    safetyAssessment.setIdEvent(safetyAssessmentSaveSI.getUlIdEvent());
    safetyAssessment.setOtherSafetyFactor(safetyAssessmentSaveSI.getSzTxtOtherSafetyFactor());
    saSafetyAssessmentDAO.saveOrUpdateSafetyAssessment(safetyAssessment);
    // Save safetyFactors
    Map<String, Collection<SafetyFactorsSaveSI>> map = safetyAssessmentSaveSI.getSafetyFactors();
    if (map != null) {
      Iterator<String> iterator = map.keySet().iterator();              // Keys for SF Rows
      while (iterator.hasNext()) {                                      // Next SF Key
        Collection<SafetyFactorsSaveSI> coll = map.get(iterator.next());// Values for SF Key
        Iterator<SafetyFactorsSaveSI> collIterator = coll.iterator();   // Iterator for Values
        while (collIterator.hasNext()) {                                
          SafetyFactorsSaveSI safetyFactorSI = collIterator.next();       // Each Value
          safetyFactorSI.setUlIdEvent(safetyAssessmentSaveSI.getUlIdEvent());
          SaSafetyFactor safetyFactors = new SaSafetyFactor();            // New Instance of SaSafetyFactor DB Object 
          safetyFactors.setIdSaSafetyFactor(safetyFactorSI.getUlIdSafetyFactor());
          SaSafetyAssessment assmt = getPersistentObject(SaSafetyAssessment.class, safetyFactorSI.getUlIdEvent());
          safetyFactors.setSaSafetyAssessment(assmt);
          safetyFactors.setPersonByIdPersonCaretaker(getPersistentObject(Person.class, safetyFactorSI.getIdCaretaker()));
          safetyFactors.setPersonByIdPersonChild(getPersistentObject(Person.class, safetyFactorSI.getIdChild()));
          safetyFactors.setCdSfFactor(safetyFactorSI.getSzCdSafetyFactor());
          safetyFactors.setCdSfFactorRps(safetyFactorSI.getSzCdSafetyFactorResponse());
          safetyFactors.setDtLastUpdate(safetyFactorSI.getDtDtLastUpdateDt());
          if(isModified(safetyFactors, origMap, eventReqFuncCd)) {
            saSafetyFactorDAO.saveOrUpdateSafetyFactor(safetyFactors);
          }
        }
      }
    }

    if (safetyAssessmentSaveSI.getDrugExposedNewBornExist()) {
      // Save Drug Exposed New borns
      Collection<DrugExposedNewBornSaveSI> collDE = safetyAssessmentSaveSI.getDrugExposedNewborn();
      if (collDE != null) {
        Iterator<DrugExposedNewBornSaveSI> iteratorDE = collDE.iterator();
        while (iteratorDE.hasNext()) {
          DrugExposedNewBornSaveSI dENB = iteratorDE.next();
          dENB.setUlIdEvent(safetyAssessmentSaveSI.getUlIdEvent());
          SaDrugExposedNewborns sad = new SaDrugExposedNewborns();
          sad.setIdSaDrugExposedNewborns(dENB.getIdDrugExposedNewborn());
          SaSafetyAssessment assmt = getPersistentObject(SaSafetyAssessment.class, dENB.getUlIdEvent());
          sad.setSaSafetyAssessment(assmt);
          sad.setCdDrugExpNb(dENB.getSzCdDrugExpNb());
          sad.setCdDrugExpNbRps(dENB.getSzCdDrugExpNbRps());
          sad.setDtLastUpdate(dENB.getDtLastUpdate());
          if(isModified(sad, origCollDE, eventReqFuncCd)) {
            saDrugExposedNewbornsDAO.saveOrUpdateDrugExposedNewborn(sad);
          }
        }
      }
    }

    // Save ReasonableEfforts
    Map<String, Collection<ReasonableEffortsSaveSI>> mapRE = safetyAssessmentSaveSI.getReasonableEfforts();
    if (mapRE != null) {
      Iterator<String> iteratorRE = mapRE.keySet().iterator();
      while (iteratorRE.hasNext()) {
        Collection<ReasonableEffortsSaveSI> collRE = mapRE.get(iteratorRE.next());
        Iterator<ReasonableEffortsSaveSI> collIterator = collRE.iterator();
        while (collIterator.hasNext()) {
          ReasonableEffortsSaveSI reasonableEfforts = collIterator.next();
          reasonableEfforts.setUlIdEvent(safetyAssessmentSaveSI.getUlIdEvent());
          // int rc = saReasonableEffortsDAO.saveReasonableEfforts(reasonableEfforts);
          SaReasonableEfforts sar = new SaReasonableEfforts();
          sar.setIdSaReasonableEfforts(reasonableEfforts.getUlIdReasonableEfforts());
          SaSafetyAssessment assmt = getPersistentObject(SaSafetyAssessment.class, reasonableEfforts.getUlIdEvent());
          sar.setSaSafetyAssessment(assmt);
          sar.setPerson(getPersistentObject(Person.class, reasonableEfforts.getIdChild()));
          sar.setCdRsbEfforts(reasonableEfforts.getSzCdReasonableEfforts());
          sar.setCdRsbEffortsRps(reasonableEfforts.getSzCdReasonableEffortsResponse());
          sar.setTxtComments(reasonableEfforts.getSzTxtComments());
          sar.setDtLastUpdate(reasonableEfforts.getDtDtLastUpdateDt());
          if(isModified(sar, origMapRE, eventReqFuncCd)) {
            saReasonableEffortsDAO.saveOrUpdateReasonableEfforts(sar);
          }
        }
      }
    }
    return idEvent;
  }
  

  private boolean isModified(SaSafetyFactor safetyFactor, Map<String, Collection<SafetyFactorsRetrieveSO>> origMap, String eventReqFuncCd) {

    if(eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)){
      return true;
    }
    else if(eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)){
      Collection<SafetyFactorsRetrieveSO> sfEntries = origMap.get((String)safetyFactor.getCdSfFactor());  // Values for SF
      Iterator iterSFEntries =  sfEntries.iterator();
      while(iterSFEntries.hasNext()) {
        SafetyFactorsRetrieveSO safetyFactorsRetrieveSO = (SafetyFactorsRetrieveSO) iterSFEntries.next();
        if(safetyFactor.getPersonByIdPersonChild().getIdPerson().equals(safetyFactorsRetrieveSO.getIdChild())
                        && safetyFactor.getPersonByIdPersonCaretaker().getIdPerson().equals(safetyFactorsRetrieveSO.getIdCaretaker())){
          if(!safetyFactor.getCdSfFactorRps().equals(safetyFactorsRetrieveSO.getSzCdSafetyFactorResponse())){
            return true;
          }
        }
      }
    }
    return false;
  }
  
  
  private boolean isModified(SaDrugExposedNewborns sad, Collection<DrugExposedNewBornRetrieveSO> origCollDE, String eventReqFuncCd) {
    if(eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)){
      return true;
    }
    else if(eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)){
      // If there were no old DE Newborns then obviously modification is true
      if(origCollDE.size()==0) {
        return true;
      }
      else {
        Iterator iterOrigCollDE = origCollDE.iterator();
        while(iterOrigCollDE.hasNext()) {
          DrugExposedNewBornRetrieveSO drugExposedNewBornRetrieveSO = (DrugExposedNewBornRetrieveSO) iterOrigCollDE.next();
          if(drugExposedNewBornRetrieveSO.getUIdDrugExposedNewborn()==sad.getIdSaDrugExposedNewborns()) {
            if(!drugExposedNewBornRetrieveSO.getSzCdDrugExpNbRps().equals(sad.getCdDrugExpNbRps())){
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  
  private boolean isModified(SaReasonableEfforts sar, Map<String, Collection<ReasonableEffortsRetrieveSO>> origMapRE, String eventReqFuncCd) {
    if(eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)){
      return true;
    }
    else if(eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)){
      if (origMapRE != null) {
        Collection<ReasonableEffortsRetrieveSO> origCollREEntries = origMapRE.get((String)sar.getCdRsbEfforts());  // Values for RE
        Iterator iterOrigREEntry = origCollREEntries.iterator();
        while (iterOrigREEntry.hasNext()) {
          ReasonableEffortsRetrieveSO reasonableEffortsRetrieveSO = (ReasonableEffortsRetrieveSO) iterOrigREEntry.next();
          if(sar.getIdSaReasonableEfforts()== reasonableEffortsRetrieveSO.getUlIdReasonableEfforts()
                          && sar.getPerson().getIdPerson()==reasonableEffortsRetrieveSO.getIdChild()) {
            if(!(sar.getCdRsbEffortsRps().equals(StringHelper.getNonNullString(reasonableEffortsRetrieveSO.getSzCdReasonableEffortsResponse()))) || 
               !(sar.getTxtComments().equals(reasonableEffortsRetrieveSO.getSzTxtComments())) ){
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  
  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdStage) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdStage);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }
}
