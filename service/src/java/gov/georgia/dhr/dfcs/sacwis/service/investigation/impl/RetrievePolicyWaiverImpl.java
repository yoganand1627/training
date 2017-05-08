package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   03/18/11    Hai Nguyen        SMS#97850: MR-75 Added new logic for FAD 30 Day Grace Period Waiver.
 *   03/31/11    Hai Nguyen        SMS#97850: MR-75 Moved WGP date calculation to conversation.
 *
*/
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrievePolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

public class RetrievePolicyWaiverImpl extends BaseServiceImpl implements RetrievePolicyWaiver {

  private EventDAO eventDAO = null;
  private PolicyWaiverDAO policyWaiverDAO = null;
  private StageDAO stageDAO = null;
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPolicyWaiverDAO(PolicyWaiverDAO policyWaiverDAO) {
    this.policyWaiverDAO = policyWaiverDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public PolicyWaiverRetrieveSO retrievePolicyWaiver(PolicyWaiverRetrieveSI policyWaiverRetrieveSI)
          throws ServiceException {

    PolicyWaiverRetrieveSO policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
    int idEvent = policyWaiverRetrieveSI.getIdWvrEvent();
    int idStage = policyWaiverRetrieveSI.getIdStage();

    // CallCINT21D
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // WINDOW_MODE_INQUIRE
    if (PageModeConstants.VIEW.equals(policyWaiverRetrieveSI.getPageMode())) {
      // Retrieve policy waiver
      policyWaiverRetrieveSO = processPolicyWaiverDAO(idEvent);
      
      if (idEvent != 0) {
        // Retrieve policy waiver event
        policyWaiverRetrieveSO.setROWCCMN45DO(processEventDAO(idEvent));
      }
    }
    // WINDOW_MODE_MODIFY
    else if (PageModeConstants.MODIFY.equals(policyWaiverRetrieveSI.getPageMode()) && idEvent != 0) {
      //Retrieve policy waiver
      policyWaiverRetrieveSO = processPolicyWaiverDAO(idEvent);
      
      //Retrieve policy waiver event
      policyWaiverRetrieveSO.setROWCCMN45DO(processEventDAO(idEvent));
      
      policyWaiverRetrieveSO.setIdWvrEvent(idEvent);

    } else {
      policyWaiverRetrieveSO.setIdWvrEvent(idEvent);

    }

    return policyWaiverRetrieveSO;
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

  private PolicyWaiverRetrieveSO processPolicyWaiverDAO(int idEvent) {
    PolicyWaiverRetrieveSO policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
    PolicyWaiver policyWaiver = policyWaiverDAO.findPolicyWaiverByIdEvent(idEvent);

    if (policyWaiver != null)
    {
      if(policyWaiver.getPerson() != null)
      {
        policyWaiverRetrieveSO.setIdWvrCaseManager(policyWaiver.getPerson().getIdPerson());
        policyWaiverRetrieveSO.setSzNmCaseManager(policyWaiver.getPerson().getNmPersonFull());
      }
      if (!DateHelper.isNull(policyWaiver.getDtWvrRequest())) {
        policyWaiverRetrieveSO.setDtDtWvrRequest(policyWaiver.getDtWvrRequest());
        policyWaiverRetrieveSO.setTmWvrRequest(DateHelper.getAMPM(policyWaiver.getDtWvrRequest()));
      }
      policyWaiverRetrieveSO.setIdWvrEvent(policyWaiver.getIdWvrEvent());
      policyWaiverRetrieveSO.setSzCdWvrType(policyWaiver.getCdWvrType());
      policyWaiverRetrieveSO.setSzCdWvrReason(policyWaiver.getCdWvrReason());
      policyWaiverRetrieveSO.setDtDtWvrExprtn(policyWaiver.getDtWvrExprtn());
      policyWaiverRetrieveSO.setSzTxtWvrComments(policyWaiver.getTxtWvrComments());
      policyWaiverRetrieveSO.setDtLastUpdate(policyWaiver.getDtLastUpdate());
      if(policyWaiver.getMnthWvrCtct() != null)
      {
        StringBuffer sb = new StringBuffer("");
        if(policyWaiver.getMnthWvrCtct().intValue() < 10)
        {
          sb.append("0");
        }
        sb.append(policyWaiver.getMnthWvrCtct().intValue());
        policyWaiverRetrieveSO.setMnthWvrCtct(sb.toString());
      }
      // now the year.
      if(policyWaiver.getYrWvrCtct() != null)
      {
        StringBuffer sb = new StringBuffer("");
        if(policyWaiver.getYrWvrCtct().intValue() < 10)
        {
          sb.append("0");
        }
        sb.append(policyWaiver.getYrWvrCtct().intValue());
        policyWaiverRetrieveSO.setYrWvrCtct(sb.toString());
      }
      policyWaiverRetrieveSO.setTxtWvrOther(policyWaiver.getTxtWvrOther());
      if(policyWaiver.getPersonByIdWvrPrnUnableCnct() != null)
      {
        Person person = policyWaiver.getPersonByIdWvrPrnUnableCnct();
        policyWaiverRetrieveSO.setPersonByIdWvrPrnUnableCnct(person.getNmPersonFull());
        policyWaiverRetrieveSO.setPersonIdForPullback(person.getIdPerson().toString());
      }
      policyWaiverRetrieveSO.setCdWvrJustification(policyWaiver.getCdWvrJustification());
      policyWaiverRetrieveSO.setTxtWvrCapacity(policyWaiver.getTxtWvrCapacity());
      policyWaiverRetrieveSO.setDtWvrBegin(policyWaiver.getDtWvrBegin());
      policyWaiverRetrieveSO.setDtWvrEnd(policyWaiver.getDtWvrEnd());
      policyWaiverRetrieveSO.setTxtSlpArngmts(policyWaiver.getTxtSlpArngmts());
      if(policyWaiver.getAmtAppPrdm() != null)
      {
        policyWaiverRetrieveSO.setAmtAppPrdm(policyWaiver.getAmtAppPrdm().doubleValue());
      }
      policyWaiverRetrieveSO.setCdWvrAuthCounty(policyWaiver.getCdWvrAuthCounty());
      policyWaiverRetrieveSO.setCdWvrPmtCounty(policyWaiver.getCdWvrPmtCounty());
      policyWaiverRetrieveSO.setCdWvrEntCd(policyWaiver.getCdWvrEntCd());
      policyWaiverRetrieveSO.setCdWvrSvcDesc(policyWaiver.getCdWvrSvcDesc());
      policyWaiverRetrieveSO.setCdWvrUasCd(policyWaiver.getCdWvrUasCd());
      if(policyWaiver.getPersonByIdWvrPryCust() != null)
      {
        Person person = policyWaiver.getPersonByIdWvrPryCust();
        policyWaiverRetrieveSO.setPersonByIdWvrPryCust(person.getNmPersonFull());
        policyWaiverRetrieveSO.setPersonIdForPullback(person.getIdPerson().toString());
      }
      if(policyWaiver.getCapsResource() != null)
      {
        CapsResource capsResource = policyWaiver.getCapsResource();
        policyWaiverRetrieveSO.setCapsResource(capsResource.getNmResource());
        policyWaiverRetrieveSO.setResourceIdForPullback(capsResource.getIdResource().toString());
      }
      if(policyWaiver.getAmtWvr() != null)
      {
        policyWaiverRetrieveSO.setAmtWvr(policyWaiver.getAmtWvr());
      }
      if(policyWaiver.getNbrWvrUnit() != null)
      {
        policyWaiverRetrieveSO.setNbrWvrUnit(policyWaiver.getNbrWvrUnit());
      }
    }
    return policyWaiverRetrieveSO;
  }

}
