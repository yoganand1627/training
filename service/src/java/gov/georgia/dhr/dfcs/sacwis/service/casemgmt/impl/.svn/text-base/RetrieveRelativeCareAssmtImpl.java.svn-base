package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmtPerson;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveRelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentPersonInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



public class RetrieveRelativeCareAssmtImpl extends BaseServiceImpl implements RetrieveRelativeCareAssmt {
  private RelativeCareAssmtDAO relativeCareAssmtDAO;
  private RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO;
  private EventDAO eventDAO = null;
  static final String RELATIVE_CARE_ASMNT_NARR = "SAFETY_RSRC_ASMNT_NARR";
  public void setRelativeCareAssmtDAO(RelativeCareAssmtDAO rcaDAO) {
    this.relativeCareAssmtDAO = rcaDAO;
  }
  
  public void setRelativeCareAssmtPersonDAO(RelativeCareAssmtPersonDAO rcaPersonDAO) {
    this.relativeCareAssmtPersonDAO = rcaPersonDAO;
  }

  public RelativeCareAssessmentBean retrieveRelativeCareAssmt(int idEvent) {
    RelativeCareAssessmentBean result = new RelativeCareAssessmentBean();
    result.setRowccmn45do(processEventDAO(idEvent));

    RelativeCareAssmt rca = relativeCareAssmtDAO.findRelativeCareAssmtByIdEvent(idEvent);
    result.setActualHomeVisitDate(rca.getDtActual());
    result.setCdAssessmentResults(rca.getCdAssmtResults());
    result.setCdAssessmentType(rca.getCdAssmtType());
    result.setCdCaregiverType(rca.getCdCaregiverType());
    result.setCdCounty(rca.getCdCounty());
    result.setCdInitialChoiceOfSupport(rca.getCdSupport());
    result.setCdPersonPerformingAssessment(rca.getCdAssessorType());
    result.setCdState(rca.getCdState());
    // defect fix STGAP00003915 
    result.setCdSupportOptions(rca.getIndDiscussion());
    result.setCdWillingToAcceptChild(rca.getIndAccept());
    result.setDtAssessmentComplete(rca.getDtComplete());
    result.setDtAssessmentReceived(rca.getDtReceived());
    result.setDtDecisionDate(rca.getDtDecision());
    result.setDtDiscussionDate(rca.getDtDiscussion());
    result.setDtInitiated(rca.getDtReferral());
    result.setDtLastUpdate(rca.getDtLastUpdate());
    result.setDtPlacementAgreementSigned(rca.getDtAgreeSigned());
    result.setDtReferredToRD(rca.getDtRdRefrral());
    result.setDueDate(rca.getDtDue());
    result.setIdEvent(rca.getIdRcaEvent());
    if (rca.getCapsResourceByIdResource() != null) {
      result.setIdResource(rca.getCapsResourceByIdResource().getIdResource());
      result.setNmResource(rca.getCapsResourceByIdResource().getNmResource());
    }
    result.setScheduleAssessmentDate(rca.getDtSched());
    result.setTxtComments(rca.getTxtComments());
    result.setTxtNonRelatives(rca.getTxtNonRelatives());
    
    // Retrieve associated Person
    
    List<RelativeCareAssmtPerson> personList = relativeCareAssmtPersonDAO.findRelativeCareAssmtPersonByIdRcaEvent(idEvent);
    Iterator<RelativeCareAssmtPerson> iterator = personList.iterator();
    List<RelativeCareAssessmentPersonInfo> personInfoList = new ArrayList<RelativeCareAssessmentPersonInfo>();
    result.setPersonInfoList(personInfoList);
    while(iterator.hasNext()){
      RelativeCareAssmtPerson rcaPerson = iterator.next();
      RelativeCareAssessmentPersonInfo personInfo = new RelativeCareAssessmentPersonInfo();
      personInfo.setDtLastUpdate(rcaPerson.getDtLastUpdate());
      personInfo.setNmPersonName(rcaPerson.getPersonByIdPerson().getNmPersonFull());
      personInfo.setUlIdPerson(rcaPerson.getPersonByIdPerson().getIdPerson());
      personInfo.setUlIdRcaPerson(rcaPerson.getIdRcaPerson());
      personInfo.setCdPersonType(rcaPerson.getCdPersonType());
      personInfoList.add(personInfo);
    }
    
    Date dtLastUpdate = commonDAO.findDtLastUpdate(RELATIVE_CARE_ASMNT_NARR, idEvent);
    if (dtLastUpdate == null) {
      result.setIndBLOBExistsInDatabase(ArchitectureConstants.N);
    }else{
      result.setIndBLOBExistsInDatabase(ArchitectureConstants.Y);
  }
    return result;
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

  /**
   * @return the eventDAO
   */
  public EventDAO getEventDAO() {
    return eventDAO;
  }

  /**
   * @param eventDAO the eventDAO to set
   */
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

}
