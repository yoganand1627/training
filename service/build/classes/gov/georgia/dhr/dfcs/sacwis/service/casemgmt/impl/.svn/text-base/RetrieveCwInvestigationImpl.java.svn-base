//*  Service Class  Name:     RetrieveCwInvestigationImpl
//*  Created by:   Patrick Coogan
//*  Date Created: 12/06/2009
//*
//*  Description:Service Implementation for retrieving Case Watch investigation stage info.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/06/09  Patrick Coogan    Created file for ECEM Case Watch page
//**  02/23/2011 arege            SMS#49902 Used new method to get Intake corresponding to given INV stage
//**  04/14/2011 arege            SMS#49902 In Case of merged cases , we need to ensure that we retrieve the contact made after the current 
//**                              open intake date/time 
//**
package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCwInvestigation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseWatchFactorHelpDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvestigationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CwInvResponseTimeBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

public class RetrieveCwInvestigationImpl extends BaseServiceImpl implements RetrieveCwInvestigation {

  private AllegationDAO allegationDAO = null;

  private PersonDAO personDAO = null;

  private ContactDAO contactDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private StageDAO stageDAO = null;

  private CaseWatchFactorHelpDAO caseWatchFactorHelpDAO = null;

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCaseWatchFactorHelpDAO(CaseWatchFactorHelpDAO caseWatchFactorHelpDAO) {
    this.caseWatchFactorHelpDAO = caseWatchFactorHelpDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrieveCwInvestigation retrieves all information necessary for displaying investigation stage data on the Case
   * Watch page.
   * 
   * @param context
   *                The CaseWatchSI object.
   * 
   * Returns CwInvestigationSO object.
   */
  public CwInvestigationSO retrieveCwInvestigation(CaseWatchSI caseWatchSI) {

    CwInvestigationSO cwInvestigationSO = new CwInvestigationSO();
    List<CwInvResponseTimeBean> responseTimes = new ArrayList<CwInvResponseTimeBean>();
    List<Integer> victims = new ArrayList<Integer>();
    IncomingDetail intake = new IncomingDetail();
    Stage intakeStage = new Stage();
    Date dt48HourContact = null;
    String responseCd = "";
    Date intakeDate = null;
    Integer idResource = null;
    List<String> methods = new ArrayList<String>();

    cwInvestigationSO.setOverallRespTime(ArchitectureConstants.Y);
    cwInvestigationSO.setOverallRespTimeError("");

    methods.add(CodesTables.CCNTMETH_ATF);
    methods.add(CodesTables.CCNTMETH_UTF);
    
    // SMS#49902 Used new method to get Intake corresponding to given INV stage
    intake = incomingDetailDAO. findIncomingDetailFromINVIdStage(caseWatchSI.getIdStage());

    if (intake != null) {

      intakeDate = intake.getDtIncomingCall();
      idResource = intake.getCapsResource() != null ? intake.getCapsResource().getIdResource() : null;
      intakeStage = stageDAO.findStageByIdStage(intake.getIdStage() != null ? intake.getIdStage() : 0);

      if (intakeStage != null) {
        responseCd = intakeStage.getCdStageCurrPriority();
      }

      dt48HourContact = contactDAO.findEarliestContactByCaseAndPurpose(caseWatchSI.getIdCase(),
                                                                       CodesTables.CCNTPURP_SIS);

    }

    victims = allegationDAO.findPersonByIdVictimByIdStage(caseWatchSI.getIdStage());

    if (victims != null && !victims.isEmpty()) {

      for (Iterator<Integer> It = victims.iterator(); It.hasNext();) {

        Integer victimId = It.next();
        Person victim = personDAO.findPersonByIdPerson(victimId);
        CwInvResponseTimeBean responseTime = new CwInvResponseTimeBean();

        responseTime.setNmPersonFull(victim.getNmPersonFull() != null ? victim.getNmPersonFull() : "");
        responseTime.setIntakeDate(intakeDate);
        responseTime.setIntResponseTimeCd(responseCd);

     // SMS#49902: In Case of merged cases , we need to ensure that the contact is made after the current open intake date/time hence pass intake date 
        
        Date actualResponse = contactDAO.findEarliestContactByPersonAndCaseAndMethods(victimId.intValue(),
                                                                                      caseWatchSI.getIdCase(), methods, intakeDate);        

        Date calcResponse;

        if (actualResponse != null) {
          responseTime.setResponseDate(actualResponse);
          calcResponse = actualResponse;
        } else {
          calcResponse = new Date();
        }

        if (intakeDate != null) {

          String stringIntakeDate = DateHelper.toString(intakeDate, DateHelper.DATE_TIME_FORMAT);
          String stringCalcResponse = DateHelper.toString(calcResponse, DateHelper.DATE_TIME_FORMAT);
          
          Object[] responseTimeMap = caseWatchFactorHelpDAO.findDateDifferences(stringIntakeDate, stringCalcResponse);

          Integer businessDays = (Integer) responseTimeMap[1];
          Float actualDays = (Float) responseTimeMap[0];
          
          if (CodesTables.CPRIORTY_5D.equals(responseCd)) {
            responseTime.setResponseTime(businessDays.floatValue());
            if ((actualResponse != null) && (businessDays <= 5)) {
              responseTime.setIndError("");
            } else if ((actualResponse == null) && (businessDays <= 5)) {
              responseTime.setIndError("W");
              cwInvestigationSO.setOverallRespTime(ArchitectureConstants.N);
              if ("".equals(cwInvestigationSO.getOverallRespTimeError())) {
                cwInvestigationSO.setOverallRespTimeError("W");
              }
            } else if (businessDays > 5) {
              responseTime.setIndError("E");
              cwInvestigationSO.setOverallRespTime(ArchitectureConstants.N);
              cwInvestigationSO.setOverallRespTimeError("E");
            }

          } else {
            responseTime.setResponseTime(actualDays);
            if ((actualResponse != null) && (actualDays <= 1)) {
              responseTime.setIndError("");
            } else if ((actualResponse == null) && (actualDays <= 1)) {
              responseTime.setIndError("W");
              cwInvestigationSO.setOverallRespTime(ArchitectureConstants.N);
              if ("".equals(cwInvestigationSO.getOverallRespTimeError())) {
                cwInvestigationSO.setOverallRespTimeError("W");
              }
            } else if (actualDays > 1) {
              responseTime.setIndError("E");
              cwInvestigationSO.setOverallRespTime(ArchitectureConstants.N);
              cwInvestigationSO.setOverallRespTimeError("E");
            }
          }

        }

        responseTimes.add(responseTime);

      }

    }

    cwInvestigationSO.setResponseTimes(responseTimes);

    if (idResource != null) {
      cwInvestigationSO.setSpecInvRsrcID(idResource);
    }
    if (dt48HourContact != null) {
      cwInvestigationSO.setDt48HourStaffing(dt48HourContact);
    }
    // Set error flags
    if ((idResource != null) && (dt48HourContact == null)) {
      cwInvestigationSO.setInd48HourError("E");
    }
    if ((idResource == null) && (dt48HourContact != null)) {
      cwInvestigationSO.setIndSpecInvError("E");
    }

    return cwInvestigationSO;
  }

}
