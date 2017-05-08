package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegEvidenceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingFacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvHmeWaiverChildHistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvStateConcurDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvestigationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingFacility;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHist;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvestigation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveSpclInvestigation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpclInvestigationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvAllegationBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvHmeWaiverChildHistBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Herve Jean-Baptiste  May 22, 2011
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------           
 *   07/01/2011    charden                 #114744 - removed minus one from code to fix indexOutOfBounds Exception 
 *                                         since the getMonth() method is zero-based
 * </pre>
 * 
 */

public class RetrieveSpclInvestigationImpl extends BaseServiceImpl implements RetrieveSpclInvestigation {

  private SpclInvestigationDAO spclInvestigationDAO = null; 
  private SpclInvHmeWaiverChildHistDAO spclInvHmeWaiverChildHistDAO = null;
  private SpclInvStateConcurDAO spclInvStateConcurDAO = null;
  private EventDAO eventDAO = null;
  private PersonDAO personDAO = null;
  private PlacementDAO placementDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private LegalStatusDAO legalStatusDAO = null;
  private IncomingFacilityDAO incomingFacilityDAO = null;
  private FCCPFamilyDAO fccpFamilyDAO = null;
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  private AllegationDAO allegationDAO = null;
  private AllegEvidenceDAO allegEvidenceDAO = null;
  
  public void setSpclInvestigationDAO(SpclInvestigationDAO spclInvestigationDAO) {
    this.spclInvestigationDAO = spclInvestigationDAO;
  }

  public void setSpclInvHmeWaiverChildHistDAO(SpclInvHmeWaiverChildHistDAO spclInvHmeWaiverChildHistDAO) {
    this.spclInvHmeWaiverChildHistDAO = spclInvHmeWaiverChildHistDAO;
  }

  public void setSpclInvStateConcurDAO(SpclInvStateConcurDAO spclInvStateConcurDAO) {
    this.spclInvStateConcurDAO = spclInvStateConcurDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setIncomingFacilityDAO(IncomingFacilityDAO incomingFacilityDAO) {
    this.incomingFacilityDAO = incomingFacilityDAO;
  }
  
  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }
  
  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }
  
  public void setAllegEvidenceDAO(AllegEvidenceDAO allegEvidenceDAO) {
    this.allegEvidenceDAO = allegEvidenceDAO;
  }

  public SpclInvestigationRetrieveSO retrieveSpclInvestigation(SpclInvestigationRetrieveSI spclInvestigationRetrieveSI)
                                                                                                             throws ServiceException {
    SpclInvestigationRetrieveSO spclInvestigationRetrieveSO = new SpclInvestigationRetrieveSO();
    SpclInvestigation spclInvestigation = new SpclInvestigation();
    int idEvent = spclInvestigationRetrieveSI.getIdEvent();
    int idCase = spclInvestigationRetrieveSI.getIdCase();
    int idStage = spclInvestigationRetrieveSI.getIdStage();
    spclInvestigationRetrieveSO.setIdCase(idCase);
    spclInvestigationRetrieveSO.setIdStage(idStage);
    spclInvestigationRetrieveSO.setCdTask(spclInvestigationRetrieveSI.getCdTask());
    String cdEventStatus = "";
    if (idEvent == 0) {
      cdEventStatus = CodesTables.CEVTSTAT_NEW; 
    }
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event != null) {
      cdEventStatus = event.getCdEventStatus(); 
      spclInvestigationRetrieveSO.setDtEventLastUpdate(event.getDtLastUpdate());
      spclInvestigationRetrieveSO.setDtEventOccurred(event.getDtEventOccurred());
      spclInvestigationRetrieveSO.setIdEvent(idEvent);
      spclInvestigationRetrieveSO.setCdEventStatus(cdEventStatus);
      // Update the task code with the one from the event if the event exists
      spclInvestigationRetrieveSO.setCdTask(event.getCdTask());
      spclInvestigation = spclInvestigationDAO.findSpclInvestigationByIdEvent(idEvent);
      if (spclInvestigation == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      
      spclInvestigationRetrieveSO.setIndRcmndPlcmntRsrcClosed(spclInvestigation.getIndRcmndPlcmntRsrcClosed());
      spclInvestigationRetrieveSO.setIndRcmndChldrnRemoved(spclInvestigation.getIndRcmndChldrnRemoved());
      spclInvestigationRetrieveSO.setIndRcmndActionPlanDvlpd(spclInvestigation.getIndRcmndActionPlanDvlpd());
      spclInvestigationRetrieveSO.setIndRcmndNoChangeStatus(spclInvestigation.getIndRcmndNoChangeStatus());
      spclInvestigationRetrieveSO.setIndRcmndWaiverAttached(spclInvestigation.getIndRcmndWaiverAttached());
      spclInvestigationRetrieveSO.setIndRcmndCpaCciNotUsed(spclInvestigation.getIndRcmndCpaCciNotUsed());
      spclInvestigationRetrieveSO.setIndRcmndOther(spclInvestigation.getIndRcmndOther());
      spclInvestigationRetrieveSO.setIndRecordChkViewed(spclInvestigation.getIndRecordChkViewed());
      spclInvestigationRetrieveSO.setTxtRcmndOtherComments(spclInvestigation.getTxtRcmndOtherComments());
      spclInvestigationRetrieveSO.setTxtResults48hrStaffing(spclInvestigation.getTxtResults48hrStaffing());
      spclInvestigationRetrieveSO.setTxtNamesAgncyRepStaffing(spclInvestigation.getTxtNamesAgncyRepStaffing());
      spclInvestigationRetrieveSO.setTxtJustHmeRemainOpen(spclInvestigation.getTxtJustHmeRemainOpen());
      spclInvestigationRetrieveSO.setTxtSynopsisRecReviewed(spclInvestigation.getTxtSynopsisRecReviewed());
      spclInvestigationRetrieveSO.setTxtStepsAssureSafety(spclInvestigation.getTxtStepsAssureSafety());
    }     
    
    // Get the Allegation Information
    int idCpsInvEvent = retrieveCpsInvestigation(idStage, spclInvestigationRetrieveSO);
    
    // retrieve if cps investigation narrative already exist in DB
    String tableName = "CPS_CONCLUSION_NARR";
    Date lastUpdate = commonDAO.findDtLastUpdate(tableName, idCpsInvEvent);
    if (DateHelper.isNull(lastUpdate)) {
      spclInvestigationRetrieveSO.setIsBLOBExistsInDatabase(false);
    } else {
      spclInvestigationRetrieveSO.setIsBLOBExistsInDatabase(true);
    }
    
    List<SpclInvHmeWaiverChildHistBean> spclInvHmeWaiverChildHistBeans = new ArrayList<SpclInvHmeWaiverChildHistBean>();
    IncomingFacility incomingFacility = incomingFacilityDAO.findIncomingFacilityByIdStage(idStage);
    int idResource = 0;
    
    CapsResource resource = incomingFacility.getCapsResource();
    if (incomingFacility != null) {
      if (resource != null) {
        idResource = resource.getIdResource();
      }
      spclInvestigationRetrieveSO.setIdResource(idResource);
      spclInvestigationRetrieveSO.setNmResource(incomingFacility.getNmIncmgFacilName());
      spclInvestigationRetrieveSO.setCdRsrcFacilType(incomingFacility.getCdIncmgFacilType());
      
      // If the event is still in PROC status, we need to continually update the list of children placed
      // in the home to display
      if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus) || CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)) {
        List<Placement> placements = placementDAO.findCompAprvPlacementsByIdResource(new Date(), idResource);
        if (placements != null && !placements.isEmpty()) {
          for (Placement p : placements) {
            SpclInvHmeWaiverChildHistBean waiverChild = new SpclInvHmeWaiverChildHistBean();
            int idChild = p.getPersonByIdPlcmtChild().getIdPerson();
            waiverChild.setIdChild(idChild);
            waiverChild.setCdChildPlcmntType(p.getCdPlcmtType());
            Map<String, Integer> duration = calculateDateDifference(p.getDtPlcmtStart(), new Date());
            waiverChild.setNumMonthsInPlcmnt(duration.get("months"));
            waiverChild.setNumYearInPlcmnt(duration.get("years"));
            String nmPersonFull = personDAO.findNmFullByIdPerson(idChild);
            waiverChild.setNmPersonFull(nmPersonFull);
            LegalStatus ls = legalStatusDAO.findCurrentLegalStatusByIdPerson(idChild);
            if (ls != null) {
              waiverChild.setCdChildLegalCounty(ls.getCdLegalStatCnty());
              waiverChild.setCdChildLegalStatus(ls.getCdLegalStatStatus());
            }
            String indRemainInHome = spclInvHmeWaiverChildHistDAO.findIndRemainInHomeByIdEventIdChild(idEvent, idChild);
            waiverChild.setIndRemainInHome(indRemainInHome);
            FccpFamily f = fccpFamilyDAO.findLatestApprovedFCCPFamilyByIdPersonForOpenFsuStage(idChild);
            if (f != null) {
              waiverChild.setCdChildPermncyPlan((f.getCdPrimPermPlan() != null ? f.getCdPrimPermPlan() : ""));
              waiverChild.setCdChildConcurPlan((f.getCdSecndPermPlan() != null ? f.getCdSecndPermPlan() : ""));
            } else {
              waiverChild.setCdChildPermncyPlan("");
              waiverChild.setCdChildConcurPlan("");
            }
            spclInvHmeWaiverChildHistBeans.add(waiverChild);
          }
        }
        // Add the list of Home Waiver children to the output object
        spclInvestigationRetrieveSO.setSpclInvHmeWaiverChildHistBeans(spclInvHmeWaiverChildHistBeans);
        // If This is a new Special Investigation(hasn't been saved yet), we have enough information
        // to return
        if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
          spclInvestigationRetrieveSO.setCdEventStatus(cdEventStatus);
          return spclInvestigationRetrieveSO; 
        }
      }
      // Or else, just get the Home Waiver Children records from the database while Event is in PEND, APRV
      else {
        List<SpclInvHmeWaiverChildHist> homeWaiverChildren = spclInvHmeWaiverChildHistDAO.findSpclInvHmeWaiverChildHist(idEvent);
        if (homeWaiverChildren != null && !homeWaiverChildren.isEmpty()) {
          for (SpclInvHmeWaiverChildHist homeWaiverChild : homeWaiverChildren) {
            SpclInvHmeWaiverChildHistBean homeWaiverChildBean = new SpclInvHmeWaiverChildHistBean();
            int idChild = homeWaiverChild.getPersonChild().getIdPerson();
            homeWaiverChildBean.setIdChild(idChild);
            String nmPersonFull = personDAO.findNmFullByIdPerson(idChild);
            homeWaiverChildBean.setNmPersonFull(nmPersonFull);
            homeWaiverChildBean.setCdChildPlcmntType(homeWaiverChild.getCdChildPlcmntType());
            homeWaiverChildBean.setNumMonthsInPlcmnt(homeWaiverChild.getNumMonthsInPlcmnt());
            homeWaiverChildBean.setNumYearInPlcmnt(homeWaiverChild.getNumYearInPlcmnt());
            homeWaiverChildBean.setCdChildLegalCounty(homeWaiverChild.getCdChildLegalCounty());
            homeWaiverChildBean.setCdChildLegalStatus(homeWaiverChild.getCdChildLegalStatus());
            homeWaiverChildBean.setCdChildPermncyPlan(homeWaiverChild.getCdChildPermncyPlan());
            homeWaiverChildBean.setCdChildConcurPlan(homeWaiverChild.getCdChildConcurPlan());
            homeWaiverChildBean.setIndRemainInHome(homeWaiverChild.getIndRemainInHome());
            spclInvHmeWaiverChildHistBeans.add(homeWaiverChildBean);
          }
          // Add the list of Home Waiver children to the output object
          spclInvestigationRetrieveSO.setSpclInvHmeWaiverChildHistBeans(spclInvHmeWaiverChildHistBeans);
        }
      }
    } else {
      if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
        spclInvestigationRetrieveSO.setCdEventStatus(cdEventStatus);
        return spclInvestigationRetrieveSO; 
      }
    }

    // There's no need to retrieve the State Office Concurrence while the event is in PROC status 
    // since the section will not show
    if (!CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)) {
      spclInvestigationRetrieveSO.setDtSpclInvSent(spclInvestigation.getDtSpclInvSent());
      spclInvestigationRetrieveSO.setDtSpclInvApproved(spclInvestigation.getDtSpclInvApproved());
      spclInvestigationRetrieveSO.setIndConcurAssmntDisp(spclInvestigation.getIndConcurAssmntDisp());
      spclInvestigationRetrieveSO.setIndConcurActionRecmnd(spclInvestigation.getIndConcurActionRecmnd());
      spclInvestigationRetrieveSO.setTxtConcurComments(spclInvestigation.getTxtConcurComments());
      List<String> concurrenceCodes = spclInvStateConcurDAO.findCdStateConcurrenceListByIdEvent(idEvent);
      spclInvestigationRetrieveSO.setConcurrenceCodes(concurrenceCodes);
    }
    
    return spclInvestigationRetrieveSO;
  }
  
  /**
   * Retrieves the Allegation information for the stage along with their Evidence codes
   * 
   * @param idStage
   * @param spclInvestigationRetrieveSO
   */
  private Integer retrieveCpsInvestigation (int idStage, SpclInvestigationRetrieveSO spclInvestigationRetrieveSO) {
    List<SpclInvAllegationBean> spclInvAllegationBeans = new ArrayList<SpclInvAllegationBean>();
    CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    int idCpsInvEvent = 0;
    if (cpsInvstDetail != null) {
      idCpsInvEvent = cpsInvstDetail.getIdEvent();
      spclInvestigationRetrieveSO.setIdCpsInvEvent(idCpsInvEvent);
      spclInvestigationRetrieveSO.setDtIntakeRcvd(cpsInvstDetail.getDtCpsInvstDtlIntake());
      spclInvestigationRetrieveSO.setCdCpsOverallDisptn(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn());
      spclInvestigationRetrieveSO.setCdCnclsnRiskFnd(cpsInvstDetail.getCdCnclsnRiskFnd());
      spclInvestigationRetrieveSO.setIndInvMaltreatInCare(cpsInvstDetail.getIndInvMaltreatInCare());
      spclInvestigationRetrieveSO.setIndPolicyViolation(cpsInvstDetail.getIndPolicyViolation());
      List<Allegation> allegationsList = allegationDAO.findAllegationsByIdStageForCPS(idStage);
      if (allegationsList != null && !allegationsList.isEmpty()) {
        for (Allegation a : allegationsList) {
          SpclInvAllegationBean spclInvAllegationBean = new SpclInvAllegationBean();
          spclInvAllegationBean.setIdAllegation(a.getIdAllegation());
          spclInvAllegationBean.setIdVictim(a.getPersonByIdVictim().getIdPerson());
          spclInvAllegationBean.setDtLastUpdate(a.getDtLastUpdate());
          spclInvAllegationBean.setCdAllegType(a.getCdAllegType());
          spclInvAllegationBean.setNmVictimFull(a.getPersonByIdVictim().getNmPersonFull());
          spclInvAllegationBean.setCdAllegIncidentStage(a.getCdAllegIncidentStage());
          spclInvAllegationBean.setCdAllegDisposition(a.getCdAllegDisposition());
          List<AllegEvidence> allegEvidenceList = allegEvidenceDAO.findAllegEvidenceByIdAllegation(a.getIdAllegation());
          if (allegEvidenceList != null && !allegEvidenceList.isEmpty()) {
            StringBuffer b = new StringBuffer();
            Iterator<AllegEvidence> allegEvidenceList_it = allegEvidenceList.iterator();
            while (allegEvidenceList_it.hasNext()) {
              AllegEvidence ae = allegEvidenceList_it.next();
              b.append(ae.getCdEvidenceCode());
              if (allegEvidenceList_it.hasNext()) {
                b.append(" - ");
              }
            }
            spclInvAllegationBean.setEvidenceCodes(b.toString());
          }
          spclInvAllegationBeans.add(spclInvAllegationBean);
        }
      }
    }
    spclInvestigationRetrieveSO.setAllegationBeans(spclInvAllegationBeans);
    return idCpsInvEvent;
  }
  
  /**
   * Calculates the duration between two dates by the number of years, months and days.
   * It does take a Leap Year into consideration
   * 
   * @param fromDate
   * @param toDate
   * @return
   */
  @SuppressWarnings({"deprecation"})
  private Map<String, Integer> calculateDateDifference(Date fromDate, Date toDate) {
    // The number of days in a month from January to December
    int[] monthDay = { 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int years;
    int months;
    int days;
    int increment = 0;
    if (fromDate.getDay() > toDate.getDay()) {
      // Corey #114744 - removed minus one from code since the getMonth() method is zero-based
      increment = monthDay[fromDate.getMonth()];
    }
    // Check to see if the month is February; If it is, then what are the number of days?
    if (increment == -1) {
      // Check to see if the from date is a leap year. As we know leap year is divided by the integer 4 
      if (fromDate.getYear() % 4 == 0) {
        increment = 29;
      } else {
        increment = 28;
      }
    }
    if (increment != 0) {
      days = (toDate.getDay() + increment) - fromDate.getDay();
      // 'increment' contains the number which will be added to fromDate.getMonth’.
      increment = 1;
    } else {
      days = toDate.getDay() - fromDate.getDay();
    }
    if ((fromDate.getMonth() + increment) > toDate.getMonth()) {
      months = (toDate.getMonth() + 12) - (fromDate.getMonth() + increment);
      increment = 1;
    } else {
      months = (toDate.getMonth()) - (fromDate.getMonth() + increment);
      increment = 0;
    }
    years = toDate.getYear() - (fromDate.getYear() + increment);
    
    Map<String, Integer> duration = new HashMap<String, Integer>();
    duration.put("days", days);
    duration.put("months", months);
    duration.put("years", years);
    return duration;
  }
   
}
