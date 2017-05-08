package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSubsidyRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PaymentOfCareDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSubsidyRate;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.PaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveSpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationRetrieveSO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author vishala devarakonda
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   07/29/2008   Vishala Devarakonda   STGAP00010002: Setting the stage name, 
 *                                      event id and person id into the retrieve 
 *                                      object 
 *   10/1/2008    Stephen Roberts       STGAP00010462: Refactored service to organize code and made
 *                                      changes necessary for Adoption R3.0 release.      
 *   11/6/2008    mchillman             STGAP00010854: Change code to look at prior FCC if ADO stage for 
 *                                      populate the IV-E and Per Diem Amount fields  
 *   01/14/2009   wjcochran             STGAP00011928: Fix null pointer exception, set the Adoption
 *                                      Subisdy Rate for anyone over 18 to the rate used for anyone
 *                                      that is 18
 *   01/18/2009   wjcochran             STGAP00012008: Use the Placement Boarding County for
 *                                      the home county and boarding county for all PAD stages, if available
 *   01/31/2009   wjcochran             STGAP00012008: Use the home county of the placement home for the
 *                                      home county for the AA application, not as previously stated -
 *                                      home county != boarding county. Also switched to a different DAO
 *                                      method to retrieve this information
 *   02/06/2009   mxpatel               STGAP00012049: wrote an If statement to set values into spNdsDetBean.
 *                                      added the populateNewSpecialNeeds() method to create a new/blank App.
 *   04/20/2009   hjbaptiste            STGAP00013331: use the ternary operator to check to see if each 'getNbrxxxxAmt()' method
 *                                      returns a null. If so, set the amount to '0.0'     
 *   05/19/2009   mchillman             Refactored service to organize code and made
 *                                      changes necessary for Adoption R3.1 release.      
 *   06/08/2009   bgehlot               STGAP00012194: Added code to find if previous app has none applicable        
 *   07/01/2009   bgehlot               STGAP00014563: Added new fields to the Application Page        
 *   07/13/2009   bgehlot               STGAP00014680: Calculation redone    
 *   07/13/2009   bgehlot               STGAP00014679: TotalMonthly amount populated when radio buttons pre, post or custom selected.        
 *   09/13/2009   mchillman             STGAP00014970: Change HasCurrentEligibility  to be an indicator that child has at least one aprv
 *                                      Eligibility with no respect to period     
 *   07/13/2009   bgehlot               STGAP00014216: Removed the code which was defaulting the radio button for 
 *                                      Basic Rate Request to Yes                          
 *   09/17/2009  mxpatel                STGAP00014707: added code to pull the most recent eligibility record where the child is a PC on an open FCC stage
 *   02/01/2010  bgehlot                SMS#44783: MR-60 Changes, Pre Post radio buttons added, Special Needs Type and Approval Type
 *                                                 radio buttons changed to the drop down, new types added.
 *   12/02/2010  arege                  SMS#45932: IV-E Eligibility field on the Adoption Assistance Application in PAD displays N/A incorrectly 
 *   03/09/2011  htvo                   SMS#97845 MR-074-2 AFCARS: added retrieve for new column ind incident child, pre-population logic
 *   05/25/2011  htvo                   SMS#109403 MR-082: set up logic for incident/non-incident used to enable special needs for non-recurring only app.
 *   06/02/2011  htvo                   SMS#109403: MR-082: set event status explicitly prior to calling populateIncidentStatus
 *                                      since this method has been moved past those that set the event status.  
 *   06/07/2011  htvo                   SMS#109403: correct SMS code from 10943 to 109403         
 *   10/07/2011  hnguyen                STGAP00017011: MR-092 Update Adoption Assistance Application to retrieve Funding Type from new AA Funding Summary.                                                        
 *   10/10/2011  hnguyen                STGAP00017011: MR-092 Throw service exception to display message that validated AA Funding is required.                                                        
 *   10/11/2011  hnguyen                STGAP00017011: MR-092 Peer review update.                                                        
 *   10/17/2011  hnguyen                STGAP00017011: MR-092 Uncommented new thrown message.
 *   10/26/2011  hnguyen                STGAP00017423: MR-092 Update to use correct message thrown.                                                       
 *   11/09/2011  hnguyen                STGAP00017622: MR-092 Updated call to AAFundingDAO.findLatestValidatedAAFundingByIdChildByIdStage query
 *   11/10/2011  hnguyen                STGAP00017513: MR-092 Always set bean funding type if not pending or approved. 
 *   12/22/2011  aavila					STGAP00017795: Hot fix for adoption assistance application basic rate.
 *   02/08/2012  vcollooru				STGAP00017878: (Break-fix defect for 5.1) Modified to retrieve the Agreement Type Selection value.
 * </pre>
 * 
 */

public class RetrieveSpecialNeedsDeterminationImpl extends BaseServiceImpl implements RetrieveSpecialNeedsDetermination {

  private static final String PRIMARY_CHILD = "PC";

  private static final int MONTHS = 12;

  private static final int DAYS_IN_YEAR = 365;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;

  private EventDAO eventDAO = null;

  private PersonDAO personDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private PlacementDAO placementDAO = null;

  private EligibilityDAO eligibilityDAO = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private WorkloadDAO workloadDAO = null;

  private StageDAO stageDAO = null;

  private StageLinkDAO stageLinkDAO = null;

  private PaymentOfCareDAO paymentOfCareDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private AdoSubsidyRateDAO adoSubsidyRateDAO = null;

  private RetrievePaymentOfCare retrievePaymentOfCare = null;
  
  private AaFundingDAO aaFundingDAO = null;

  public void setAaFundingDAO(AaFundingDAO aaFundingDAO) {
    this.aaFundingDAO = aaFundingDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setPaymentOfCareDAO(PaymentOfCareDAO paymentOfCareDAO) {
    this.paymentOfCareDAO = paymentOfCareDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setAdoSubsidyRateDAO(AdoSubsidyRateDAO adoSubsidyRateDAO) {
    this.adoSubsidyRateDAO = adoSubsidyRateDAO;
  }

  public void setRetrievePaymentOfCare(RetrievePaymentOfCare retrievePaymentOfCare) {
    this.retrievePaymentOfCare = retrievePaymentOfCare;
  }

  @SuppressWarnings("unchecked")
  public SpecialNeedsDeterminationRetrieveSO retrieveSpecialNeedsDetermination(
                                                                               SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI) {
    SpecialNeedsDeterminationRetrieveSO spNdsdetermRetrieveSO = new SpecialNeedsDeterminationRetrieveSO();
    SpecialNeedsDeterminationBean spNdsDetBean = new SpecialNeedsDeterminationBean();
    int idStage = spNdsdetermRetrieveSI.getUlIdStage();
    int idEvent = spNdsdetermRetrieveSI.getUlIdEvent();

    // Call private methods to display page
    int idPerson = populateFormInformation(spNdsdetermRetrieveSO, idStage, idEvent);
    spNdsdetermRetrieveSI.setUlIdPerson(idPerson);

    //SMS#109403: init. snd event status to NEW
    String cdEventStatus = CodesTables.CEVTSTAT_NEW; 
    //SMS#109403: retrieve event status here so it can be used by other methods
    if (idEvent != 0) {
      Event sndEvent = eventDAO.findEventByIdEvent(spNdsdetermRetrieveSI.getUlIdEvent());
      if (sndEvent == null) { // only happens when bad data
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      cdEventStatus = sndEvent.getCdEventStatus();
    }
    spNdsdetermRetrieveSO.setCdEventStatus(cdEventStatus);

    // SMS#97845 MR-074-2 AFCARS: populate the Incident/Non-Incident Status in PAD only
    if (CodesTables.CSTAGES_PAD.equals(spNdsdetermRetrieveSI.getCdStage())) {
      populateIncidentStatus(spNdsdetermRetrieveSI, spNdsdetermRetrieveSO);
      boolean isIncidentChild = ArchitectureConstants.Y.equals(spNdsdetermRetrieveSO.getIndIncidentChild()) ? true : false;
      spNdsdetermRetrieveSO.setBIncidentChild(isIncidentChild);
    } 
    // SMS#109403 MR-082 AA: set IndIncidentCChild for ADO outside populateIncidentStatus
    // because populateIncidentStatus also sets display mode for PAD which is N/A for ADO
    else if (CodesTables.CSTAGES_ADO.equals(spNdsdetermRetrieveSI.getCdStage())) {
      if (hasLinkToCdStage(spNdsdetermRetrieveSI.getUlIdStage(), CodesTables.CSTAGES_SUB)) {
        spNdsdetermRetrieveSO.setBIncidentChild(true);
      } else {
        // SMS#109403: do nothing
        // this should not happen, leaving it blank so that broken data won't get set by accident
        // or converted ADO (w/o FCC) won't get restricted by not having the non-recurring only option
      }
    } else {
      // SMS#109403: do nothing for now
      // currently, Adoption Assistance exists in ADO and PAD
    }

    // mxpatel wrote this if statement for defect #12049
    // if the event doesn't already exist, create a new/blank Adoption Assistance Application
    // set its status to NEW and return
    if (idEvent == 0) { //SMS#109403: use idEvent instead of looking up spNdsdetermRetrieveSI.getUlIdEvent() again
      spNdsDetBean = new SpecialNeedsDeterminationBean();
      populateNewSpecialNeeds(spNdsdetermRetrieveSI, spNdsdetermRetrieveSO, spNdsDetBean);
      spNdsdetermRetrieveSO.setSpNdsDetBean(spNdsDetBean);
      spNdsdetermRetrieveSO.setBFirstApplication(IsInitialApplication(spNdsdetermRetrieveSI));
      spNdsdetermRetrieveSO.setBPriorAprvNonRec(IsAprvNonRecurring(spNdsdetermRetrieveSI));
      spNdsdetermRetrieveSO.setBPriorAprvSpecialNeedsDeter(IsPriorAprvSpecialNeedsDeter(spNdsdetermRetrieveSI));
      spNdsdetermRetrieveSO.setPriorAprvSpecialNeedsDeterNA(PriorAprvSpecialNeedsDeterNoneApplicable(spNdsdetermRetrieveSI));
      populateChildBasicInformation(spNdsdetermRetrieveSI, spNdsdetermRetrieveSO);
      return spNdsdetermRetrieveSO;
    }
    
   
    //STGAP00017795: aavila Hot fix - logic copied directly from populateChildBasicRate
    Person person = personDAO.findPersonByIdPerson(spNdsdetermRetrieveSI.getUlIdPerson());
    if (person != null) {
      Date dob = person.getDtPersonBirth();
      String dobs = (DateHelper.toISOString(person.getDtPersonBirth()));
      int age = DateHelper.getAge(DateHelper.toCastorDateSafe(dobs));
      spNdsdetermRetrieveSO.setPersonDOB(dob);
      spNdsdetermRetrieveSO.setPersonFirst(person.getNmPersonFirst());
      spNdsdetermRetrieveSO.setPersonLast(person.getNmPersonLast());
      spNdsdetermRetrieveSO.setPersonMiddle(person.getNmPersonMiddle());
      spNdsdetermRetrieveSO.setPersonGender(person.getCdPersonSex());
      spNdsdetermRetrieveSO.setPersonAge(age);
    }
    //End hot fix
    
    
    populateSpecialNeeds(spNdsdetermRetrieveSI, spNdsdetermRetrieveSO, spNdsDetBean);

    spNdsdetermRetrieveSO.setSpNdsDetBean(spNdsDetBean);
    
    populateChildBasicInformation(spNdsdetermRetrieveSI, spNdsdetermRetrieveSO);

    return spNdsdetermRetrieveSO;
  }

  /**
   * Populates the Special Needs/Adoption Assistance Application data elements
   * 
   * @param spNdsdetermRetrieveSI
   * @param spNdsdetermRetrieveSO
   * @return idPerson - Person ID of primary child in stage
   */
  private int populateFormInformation(SpecialNeedsDeterminationRetrieveSO spNdsdetermRetrieveSO, int idStage,
                                      int idEvent) {

    Event closureEvent = eventDAO.findEventByStageTypeAndStatus(idStage, CodesTables.CEVNTTYP_SND,
                                                                CodesTables.CEVTSTAT_PEND);
    Map stagePersonLinkInfo = stagePersonLinkDAO.findStagePersonLinkByIdPerson(idStage, PRIMARY_CHILD);
    // STGAP00010002: Setting the stage name, event id and person id into the retrieve object - to be used to retrieve
    // the info for Special Services Adoption Assistance Agreement Form
    int idPerson = 0;
    if (stagePersonLinkInfo != null) {
      idPerson = (Integer) stagePersonLinkInfo.get("idPerson") != null ? (Integer) stagePersonLinkInfo.get("idPerson")
                                                                      : 0;
      String nmStage = (String) stagePersonLinkInfo.get("nmStage") != null ? (String) stagePersonLinkInfo
                                                                                                         .get("nmStage")
                                                                          : "";
      spNdsdetermRetrieveSO.setUlIdChild(idPerson);
      spNdsdetermRetrieveSO.setNmStage(nmStage);
      spNdsdetermRetrieveSO.setUlIdEvent(idEvent);
    }
    if (closureEvent != null) {
      spNdsdetermRetrieveSO.setHasStageClosureEvent(true);
    }

    return idPerson;
  }

  /**
   * Populates the Special Needs/Adoption Assistance Application data elements
   * 
   * @param spNdsdetermRetrieveSI
   * @param spNdsdetermRetrieveSO
   * @return void
   */
  private void populateSpecialNeeds(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI,
                                    SpecialNeedsDeterminationRetrieveSO spNdsdetermRetrieveSO,
                                    SpecialNeedsDeterminationBean spNdsDetBean) {

    // Get the staff person Role of the user from the Workload table.
    String staffPersRole = workloadDAO.findPersRoleByIdStageIdPerson(spNdsdetermRetrieveSI.getUlIdStage(),
                                                                     spNdsdetermRetrieveSI.getUserId());
    spNdsdetermRetrieveSO.setStaffPersRole(staffPersRole);

    if (spNdsdetermRetrieveSI.getUlIdEvent() != 0) {

      Event fccpEvent = eventDAO.findEventByIdEvent(spNdsdetermRetrieveSI.getUlIdEvent());
      if (fccpEvent == null) { // only happens when bad data
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      spNdsdetermRetrieveSO.setCdEventStatus(fccpEvent.getCdEventStatus());
      spNdsdetermRetrieveSO.setCdTask(fccpEvent.getCdTask());
      spNdsdetermRetrieveSO.setDtEventOccurred(fccpEvent.getDtEventOccurred());
      spNdsdetermRetrieveSO.setDtEventLastUpdate(fccpEvent.getDtLastUpdate());
      spNdsdetermRetrieveSO.setTxtEventDesc(fccpEvent.getTxtEventDescr());
      SpecialNeedsDetermination spNdsDet = specialNeedsDeterminationDAO
                                                                       .findSpecialNeedsDeterminationByIdEvent(spNdsdetermRetrieveSI
                                                                                                                                    .getUlIdEvent());
      if (spNdsDet != null) {

        spNdsDetBean.setCdApprvSpclTypeFunding(spNdsDet.getCdApprvSpclTypeFunding());
        spNdsDetBean.setCdFundingType(spNdsDet.getCdFundingType());
        spNdsDetBean.setCdSpclSerType(spNdsDet.getCdSpclSerType());
        spNdsDetBean.setDtApprvDate(spNdsDet.getDtApprvDate());
        spNdsDetBean.setDtExpirationDate(spNdsDet.getDtExpirationDate());
        spNdsDetBean.setDtLastUpdate(spNdsDet.getDtLastUpdate());
        spNdsDetBean.setIndAllSpecialDocAttached(spNdsDet.getIndAllSpecialDocAttached());
        spNdsDetBean.setIndApprvEmotionalDist(spNdsDet.getIndApprvEmotionalDist());
        spNdsDetBean.setIndApprvHearingImpaired(spNdsDet.getIndApprvHearingImpaired());
        spNdsDetBean.setIndApprvMntRetarded(spNdsDet.getIndApprvMntRetarded());
        spNdsDetBean.setIndApprvOther(spNdsDet.getIndApprvOther());
        spNdsDetBean.setIndApprvPhysicallyDisabled(spNdsDet.getIndApprvPhysicallyDisabled());
        spNdsDetBean.setIndAprType(spNdsDet.getIndAprType());
        spNdsDetBean.setIndChildEmotionallyDisabled(spNdsDet.getIndChildEmotionallyDisabled());
        spNdsDetBean.setIndChildVisHearingImpaired(spNdsDet.getIndChildVisHearingImpaired());
        spNdsDetBean.setIndChildMntRetarded(spNdsDet.getIndChildMntRetarded());
        spNdsDetBean.setIndChildOtherMedical(spNdsDet.getIndChildOtherMedical());
        spNdsDetBean.setIndChildPhysicallyDisabled(spNdsDet.getIndChildPhysicallyDisabled());
        spNdsDetBean.setIndDocDevelopmentalAssmt(spNdsDet.getIndDocDevelopmentalAssmt());
        spNdsDetBean.setIndDocMentalAssmt(spNdsDet.getIndDocMentalAssmt());
        spNdsDetBean.setIndDocPsychological(spNdsDet.getIndDocPsychological());
        spNdsDetBean.setIndDocTrtmntPrvdr(spNdsDet.getIndDocTrtmntPrvdr());
        spNdsDetBean.setIndDocSSI(spNdsDet.getIndDocSSI());

        spNdsDetBean.setIndBasicRateReq(spNdsDet.getIndBasicRateReqChild());

        spNdsDetBean.setIndSFCorRBWO(spNdsDet.getIndSfcRbwoRcvd());
        spNdsDetBean.setIndReasonSpecialRequest(spNdsDet.getIndReasonSpecialRequest());
        spNdsDetBean.setIndSpclRateAdoAppr(spNdsDet.getIndSpclRateAdoAppr());
        spNdsDetBean.setIndSpclReqApproved(spNdsDet.getIndSpclReqApproved());
        spNdsDetBean.setIndSpclServiceReq(spNdsDet.getIndSpclSerReqChild());
        spNdsDetBean.setCdPaymentMethod(spNdsDet.getCdPaymentMthd());
        spNdsDetBean.setIndSpecializedRateReq(spNdsDet.getIndSpclRateReqChild());
        spNdsDetBean.setIndAgrmtType(spNdsDet.getIndAgrmtType());
        spNdsDetBean.setIndSpcNeedsApproved(spNdsDet.getIndSpcNeedsApproved());
        spNdsDetBean.setNbrApprvAmt(spNdsDet.getNbrApprvAmt() != null ? spNdsDet.getNbrApprvAmt() : 0.0);
        spNdsDetBean.setNbrIvbAmt(spNdsDet.getNbrIvbAmt() != null ? spNdsDet.getNbrIvbAmt() : 0.0);
        spNdsDetBean.setNbrIveAmt(spNdsDet.getNbrIveAmt() != null ? spNdsDet.getNbrIveAmt() : 0.0);
        spNdsDetBean.setNbrReqAmt(spNdsDet.getNbrReqAmt() != null ? spNdsDet.getNbrReqAmt() : 0.0);
        spNdsDetBean.setNbrTotalIveIvbAmt(spNdsDet.getNbrTotalIveIvbAmt() != null ? spNdsDet.getNbrTotalIveIvbAmt()
                                                                                 : 0.0);
        spNdsDetBean.setTxtApprvOtherCmt(spNdsDet.getTxtApprvOtherCmt());
        spNdsDetBean.setTxtCmntsEmotionallyDisabled(spNdsDet.getTxtCmntsEmotionallyDisabled());
        spNdsDetBean.setTxtCmntsMntRetarded(spNdsDet.getTxtCmntsMntRetarded());
        spNdsDetBean.setTxtCmntsOtherMedical(spNdsDet.getTxtCmntsOtherMedical());
        spNdsDetBean.setTxtCmntsPhysicallyDisabled(spNdsDet.getTxtCmntsPhysicallyDisabled());
        spNdsDetBean.setTxtCmntsSpecialRequest(spNdsDet.getTxtCmntsSpecialRequest());
        spNdsDetBean.setTxtCmntsVisHearingImpaired(spNdsDet.getTxtCmntsVisHearingImpaired());
        spNdsDetBean.setTxtComments(spNdsDet.getTxtComments());
        spNdsDetBean.setTxtPleaseSpecify(spNdsDet.getTxtPleaseSpecify());

        spNdsDetBean.setIndNonRecApproved(spNdsDet.getIndNonRecApproved());
        spNdsDetBean.setNbrNonRecAprvAmt(spNdsDet.getNbrNonRecAprvAmt() != null ? spNdsDet.getNbrNonRecAprvAmt() : 0.0);
        spNdsDetBean.setIndNonRecRequested(spNdsDet.getIndNonRecRequested());
        spNdsDetBean.setNbrNonRecAmt(spNdsDet.getNbrNonRecAmt() != null ? spNdsDet.getNbrNonRecAmt() : 0.0);

        spNdsDetBean.setNbrSpNeedsChildrenRequest(spNdsDet.getNbrSpNeedsChildrenRequest());
        spNdsDetBean.setIndNonRecOnly(spNdsDet.getIndNonRecOnly());

        // STGAP00014563: Added new fields
        spNdsDetBean.setCdBasicRateType(spNdsDet.getCdBasicRateType());
        spNdsDetBean.setNbrCountyAddonAmt(spNdsDet.getNbrCountyAddonAmt() != null ? spNdsDet.getNbrCountyAddonAmt()
                                                                                 : 0.0);
        spNdsDetBean.setDtSpecialNeedsApproved(spNdsDet.getDtSpclNeedsApprvd());
        spNdsDetBean.setAddComments(spNdsDet.getTxtAdditionalComments());

        // MR-60 Changes
        spNdsDetBean.setCdSpcNdsPrePosReq(spNdsDet.getCdSpcNdsPrePosReq());
        spNdsDetBean.setCdSpcNdsPrePosApr(spNdsDet.getCdSpcNdsPrePosApr());

        // STGAP00014563: Get the basic rate as per the Basic Rate Type selected
        int personAge = spNdsdetermRetrieveSO.getPersonAge();
        AdoSubsidyRate asr = null;
        Date endDate = adoSubsidyRateDAO.findAdoptionSubsidyRateEndDate();
        asr = adoSubsidyRateDAO.findPreAdoptionSubsidyRateByAge(personAge, endDate);
        // STGAP00011928 - fix NullPointerException
        if (asr != null) {
          spNdsDetBean.setNbrPreBasicAmt(asr.getAmtAdptSub());
        } else {
          spNdsDetBean.setNbrPreBasicAmt((double) 0);
        }

        Date startDate = adoSubsidyRateDAO.findAdoptionSubsidyRateStartDate();
        asr = adoSubsidyRateDAO.findPostAdoptionSubsidyRateByAge(personAge, startDate);
        // STGAP00011928 - fix NullPointerException
        if (asr != null) {
          spNdsDetBean.setNbrPostBasicAmt(asr.getAmtAdptSub());
        } else {
          spNdsDetBean.setNbrPostBasicAmt((double) 0);
        }

        spNdsDetBean.setNbrBasicAmt(spNdsDet.getNbrBasicRateAmt() != null ? spNdsDet.getNbrBasicRateAmt() : 0.0);

        if (CodesTables.CBRTYPE_PRE.equals(spNdsDet.getCdBasicRateType())) {
          // STGAP00014680: Calculation redone
          spNdsDetBean.setNbrMonthlyAmt(spNdsDetBean.getNbrPreBasicAmt()
                                        + Round(((spNdsDetBean.getNbrCountyAddonAmt() * DAYS_IN_YEAR) / MONTHS), 2));
        } else if (CodesTables.CBRTYPE_POS.equals(spNdsDet.getCdBasicRateType())) {
          spNdsDetBean.setNbrMonthlyAmt(spNdsDetBean.getNbrPostBasicAmt());
        } else if (CodesTables.CBRTYPE_CUS.equals(spNdsDet.getCdBasicRateType())) {
          spNdsDetBean.setNbrMonthlyAmt(spNdsDetBean.getNbrBasicAmt());
        } else {
          spNdsDetBean.setNbrMonthlyAmt((double) 0);
        }

      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      spNdsdetermRetrieveSO.setBFirstApplication(IsInitialApplication(spNdsdetermRetrieveSI));
      spNdsdetermRetrieveSO.setBPriorAprvNonRec(IsAprvNonRecurring(spNdsdetermRetrieveSI));
      spNdsdetermRetrieveSO.setBPriorAprvSpecialNeedsDeter(IsPriorAprvSpecialNeedsDeter(spNdsdetermRetrieveSI));
      spNdsdetermRetrieveSO
                           .setPriorAprvSpecialNeedsDeterNA(PriorAprvSpecialNeedsDeterNoneApplicable(spNdsdetermRetrieveSI));
    }
  }

  private boolean IsInitialApplication(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI) {
    // determine if this the initial application
    boolean initialApplication = false;
    List<Integer> eventList = specialNeedsDeterminationDAO
                                                          .findAllSpclDeterminationsByIdCaseByIdPerson(
                                                                                                       spNdsdetermRetrieveSI
                                                                                                                            .getUlIdCase(),
                                                                                                       spNdsdetermRetrieveSI
                                                                                                                            .getUlIdPerson(),
                                                                                                       spNdsdetermRetrieveSI
                                                                                                                            .getUlIdStage());
    if (eventList != null) {
      if (eventList.size() == 0) {
        initialApplication = true;
      } else if (eventList.size() == 1 && eventList.contains(spNdsdetermRetrieveSI.getUlIdEvent())) {
        initialApplication = true;
      }
    } else {
      initialApplication = true;
    }
    return initialApplication;
  }

  private boolean IsAprvNonRecurring(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI) {
    SpecialNeedsDetermination sp = specialNeedsDeterminationDAO
                                                               .findAprvNonRecurringByIdStageByIdPerson(
                                                                                                        spNdsdetermRetrieveSI
                                                                                                                             .getUlIdStage(),
                                                                                                        spNdsdetermRetrieveSI
                                                                                                                             .getUlIdPerson(),
                                                                                                        spNdsdetermRetrieveSI
                                                                                                                             .getUlIdCase());
    return (sp != null);
  }

  private boolean IsPriorAprvSpecialNeedsDeter(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI) {
    SpecialNeedsDetermination sp = specialNeedsDeterminationDAO
                                                               .findSpclDeterminationByIdStageByIdPerson(
                                                                                                         spNdsdetermRetrieveSI
                                                                                                                              .getUlIdStage(),
                                                                                                         spNdsdetermRetrieveSI
                                                                                                                              .getUlIdPerson(),
                                                                                                         spNdsdetermRetrieveSI
                                                                                                                              .getUlIdCase());
    return (sp != null);
  }

  @SuppressWarnings("unchecked")
  // STGAP00012194: Added code to find if previous app has none applicable
  private Map<String, Object> PriorAprvSpecialNeedsDeterNoneApplicable(
                                                                       SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI) {
    SpecialNeedsDetermination sp = specialNeedsDeterminationDAO
                                                               .findSpclDeterminationByIdStageByIdPersonNA(
                                                                                                           spNdsdetermRetrieveSI
                                                                                                                                .getUlIdStage(),
                                                                                                           spNdsdetermRetrieveSI
                                                                                                                                .getUlIdPerson(),
                                                                                                           spNdsdetermRetrieveSI
                                                                                                                                .getUlIdCase());
    Map<String, Object> map = new HashMap();
    boolean specialNeedsNotReq = false;
    String reason = StringHelper.EMPTY_STRING;
    if (sp != null) {
      SpecialNeedsDetermination spd = specialNeedsDeterminationDAO
                                                                  .findLatestApprovedSpclDetermination(
                                                                                                       spNdsdetermRetrieveSI
                                                                                                                            .getUlIdStage(),
                                                                                                       spNdsdetermRetrieveSI
                                                                                                                            .getUlIdPerson(),
                                                                                                       spNdsdetermRetrieveSI
                                                                                                                            .getUlIdCase());
      if (spd == null) {
        reason = sp.getIndReasonSpecialRequest();
        specialNeedsNotReq = true;

      }
    }
    map.put("reason", reason);
    map.put("specialNeedsNotReq", specialNeedsNotReq);
    return map;
  }

  /**
   * Populates the Basic Child Information
   * 
   * @param spNdsdetermRetrieveSI
   * @param spNdsdetermRetrieveSO
   * @return void
   */
  private void populateChildBasicInformation(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI,
                                             SpecialNeedsDeterminationRetrieveSO spNdsdetermRetrieveSO) {
    // Calling different DAOs to get the basic child information to display in the child
    // information section of the page.
    // Begin
    // Get the First, Last and Middle names, sex, DOB and Age of the child from the person table
    Person person = personDAO.findPersonByIdPerson(spNdsdetermRetrieveSI.getUlIdPerson());
    if (person != null) {
      Date dob = person.getDtPersonBirth();
      String dobs = (DateHelper.toISOString(person.getDtPersonBirth()));
      int age = DateHelper.getAge(DateHelper.toCastorDateSafe(dobs));
      spNdsdetermRetrieveSO.setPersonDOB(dob);
      spNdsdetermRetrieveSO.setPersonFirst(person.getNmPersonFirst());
      spNdsdetermRetrieveSO.setPersonLast(person.getNmPersonLast());
      spNdsdetermRetrieveSO.setPersonMiddle(person.getNmPersonMiddle());
      spNdsdetermRetrieveSO.setPersonGender(person.getCdPersonSex());
      spNdsdetermRetrieveSO.setPersonAge(age);
    }
    // Get the race of the child from the Race table
    List<PersonRace> raceList = personRaceDAO.findPersonRaceByIdPerson(spNdsdetermRetrieveSI.getUlIdPerson());
    String race = "";
    if (raceList != null) {
      for (Iterator it = raceList.iterator(); it.hasNext();) {
        PersonRace pRace = (PersonRace) it.next();
        String raceDecode = Lookup.simpleDecodeSafe("CRACE", pRace.getCdRace());
        String delimiter = "";
        if (!"".equals(race)) {
          delimiter = ",";
        }
        race = race + delimiter + raceDecode;
      }
    }
    spNdsdetermRetrieveSO.setPersonRace(race);
    // Get the ethnicity of the child from the Ethnicity table
    List<PersonEthnicity> ethnicityList = personEthnicityDAO
                                                            .findPersonEthnicityByIdPerson(spNdsdetermRetrieveSI
                                                                                                                .getUlIdPerson());
    String ethnicity = "";
    if (ethnicityList != null) {
      for (Iterator it = ethnicityList.iterator(); it.hasNext();) {
        PersonEthnicity pEthnicity = (PersonEthnicity) it.next();
        String ethnicityDecode = Lookup.simpleDecodeSafe("CINDETHN", pEthnicity.getCdEthnicity());
        String delimiter = "";
        if (!"".equals(ethnicity)) {
          delimiter = ",";
        }
        ethnicity = ethnicity + delimiter + ethnicityDecode;
      }
    }
    spNdsdetermRetrieveSO.setPersonEthnicity(ethnicity);

    // Get the stage to see if this is a PAD stage
    String cdStage = spNdsdetermRetrieveSI.getCdStage();
    int idStage = spNdsdetermRetrieveSI.getUlIdStage();
    int idPerson = spNdsdetermRetrieveSI.getUlIdPerson();

    // Get the Boarding county of the child from the Placement table by querying for the most recent placement record
    // STGAP00012008: Use the findCurrentAdoPlcmtByIdPersonByIdStage DAO method to get
    // more information concerning the placement
    Placement placement = placementDAO.findCurrentAdoPlcmtByIdPersonByIdStage(idPerson, idStage);
    String boardingCounty = (placement == null) ? "" : placement.getCdBoardingCnty();

    if (boardingCounty != null) {
      spNdsdetermRetrieveSO.setPersonBoardCnty(boardingCounty);
    }

    // Get the Home County of the child from the Legal status table
    LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idPerson);
    if (legalStatus != null && !("PAD".equals(cdStage))) {
      spNdsdetermRetrieveSO.setPersonHomeCnty(legalStatus.getCdLegalStatCnty());
    } else if ("PAD".equals(cdStage)) { // STGAP00012008: if a PAD stage, set the home county to the county of the home
      spNdsdetermRetrieveSO.setPersonHomeCnty((placement == null) ? "" : placement.getAddrPlcmtCnty());
    }

    // Regardless of the stage (ADO or PAD) this approach should work to get the Person ID of the Primary Child
    Integer priorStageId = stageLinkDAO.findPreviousIdStagebyIdStage(spNdsdetermRetrieveSI.getUlIdStage());
    int idPriorStage = (priorStageId != null ? priorStageId : 0);
    Stage priorStage = stageDAO.findStageByIdStage(idPriorStage);

    Person primaryChild = stagePersonLinkDAO
                                            .findNmPersonByIdStageByCdStagePersRole(idPriorStage, CodesTables.CROLES_PC);

    // If the primary child is null then the page is being viewed from a non-incident PAD stage.
    // SMS#109403 MR-082: the statement above is not necessarily true. However, 
    // if the primary child is not null then this is incident child. 
    // Commented out setBNonIcidentChild to have this set in one place long with PAD
    AaFunding aaFunding = aaFundingDAO.findLatestValidatedAAFundingByIdChildByIdStage(idPerson, idStage);
    SpecialNeedsDeterminationBean spNdsDetBeanFromSO = spNdsdetermRetrieveSO.getSpNdsDetBean();

    List<String> evtStatuses = new ArrayList<String>();
    evtStatuses.add(CodesTables.CEVTSTAT_APRV);
    evtStatuses.add(CodesTables.CEVTSTAT_PEND);
    
    if(evtStatuses.contains(spNdsdetermRetrieveSO.getCdEventStatus())){
      if(spNdsDetBeanFromSO != null){
        String iveEligibility = spNdsdetermRetrieveSO.getSpNdsDetBean().getCdFundingType();
        if ("010".equals(iveEligibility) || CodesTables.CAAFDTYP_IVE.equals(iveEligibility)) {
          spNdsdetermRetrieveSO.setPersonIVEEligibility("YES");
        } else if(!CodesTables.CAAFDTYP_NRC.equals(iveEligibility)){ // Implicitly PST for AA Funding
          spNdsdetermRetrieveSO.setPersonIVEEligibility("NO");
        } else {
          spNdsdetermRetrieveSO.setPersonIVEEligibility("N/A");
        }
      } else {
        spNdsdetermRetrieveSO.setPersonIVEEligibility("N/A");
      }
    }else{
      // Application is not PEND or APRV,
      // display latest validated AA Funding Funding Type determination
      if(aaFunding != null){
        String iveEligibility = aaFunding.getCdAaFundingType();
        if ("010".equals(iveEligibility) || CodesTables.CAAFDTYP_IVE.equals(iveEligibility)) {
          spNdsdetermRetrieveSO.setPersonIVEEligibility("YES");
        } else if(!CodesTables.CAAFDTYP_NRC.equals(iveEligibility)){ // Implicitly PST for AA Funding
          spNdsdetermRetrieveSO.setPersonIVEEligibility("NO");
        } else {
          spNdsdetermRetrieveSO.setPersonIVEEligibility("N/A");
        }
        // STGAP00017513: Alway set bean funding type if not pending or approved
        if(spNdsDetBeanFromSO != null){
          spNdsDetBeanFromSO.setCdFundingType(aaFunding.getCdAaFundingType());
        }
      }else{
        // throw exception if no validated AA Funding exists
        throw new ServiceException(Messages.MSG_AA_FNDNG_SMMRY_NOT_EXISTS);
      }
    }

    // Set indicator that a least one AA Funding was validated (APRV). 
    if(aaFunding != null){
      spNdsdetermRetrieveSO.setHasCurrentEligibility(true);
    } else {
      spNdsdetermRetrieveSO.setHasCurrentEligibility(false);
    }

    // Get the latest removal date of the child from the CnsrvtrshpRemoval table
    if (primaryChild != null && priorStage != null) {
      CnsrvtrshpRemoval cnsrvtrshp = cnsrvtrshpRemovalDAO
                                                         .findCnsrvtrshpLatestRemovalByCaseAndByIdVictim(
                                                                                                         priorStage
                                                                                                                   .getCapsCase()
                                                                                                                   .getIdCase(),
                                                                                                         primaryChild
                                                                                                                     .getIdPerson());
      if (cnsrvtrshp != null) {
        spNdsdetermRetrieveSO.setPersonLstEntryFCare(cnsrvtrshp.getDtRemoval());
      }
    }

    // Get the FC Per Diem Rate
    Collection<String> cdPocTypes = new ArrayList<String>();
    cdPocTypes.add("RFD"); // Regular Foster Care per diem
    cdPocTypes.add("EFD"); // Special Foster Care per diem
    cdPocTypes.add("SFD"); // Specialized Foster Care per diem
    cdPocTypes.add("ERR"); // Enhanced Relative Rate
    cdPocTypes.add("RWW"); // RBWO with Waiver
    cdPocTypes.add("LOC"); // RBWO

    if (primaryChild != null) {
      PaymentOfCare poc = paymentOfCareDAO.findMostRecentApprovedPOCInFCC(primaryChild.getIdPerson(), cdPocTypes);

      if (poc != null) {
        int idEvent = poc.getEvent().getIdEvent();
        PaymentOfCareRetrieveSI pocRetrieveSI = new PaymentOfCareRetrieveSI();
        pocRetrieveSI.setUlIdEvent(idEvent);
        pocRetrieveSI.setUlIdStage(spNdsdetermRetrieveSI.getUlIdStage());
        PaymentOfCareRetrieveSO pocRetrieveSO = retrievePaymentOfCare.retrievePaymentOfCare(pocRetrieveSI);

        // The following Payment of Care Types have a monthly subsidy instead of a daily rate. Take the monthly subsidy
        // and divide by 30.
        if (CodesTables.CPOCTYPE_ERR.equals(poc.getCdPocType())) {
          spNdsdetermRetrieveSO.setPerDiemRate(pocRetrieveSO.getSubsidyPerDiem() / 30);
        } else {
          spNdsdetermRetrieveSO.setPerDiemRate(pocRetrieveSO.getTotalPerDiemRate());
        }
      }
    }

    // Get the Approval Date
    // DAO call returns all the approval events. Loop will go thru all and set the approval date of the last approval.
    List<Object[]> approvalList = approvalEventLinkDAO.findApprovalsforCaseEvent(spNdsdetermRetrieveSI.getUlIdEvent());
    for (Iterator<Object[]> it = approvalList.iterator(); it.hasNext();) {
      Object[] approvalArray = it.next();
      if ("APRV".equals(approvalArray[2].toString())) {
        spNdsdetermRetrieveSO.setDtEventApproved((Timestamp) approvalArray[1]);
      }
    }
  }

  /**
   * Creates a New Adoption Assistance Application when the user clicks the 'Add' button
   * 
   * @param spNdsdetermRetrieveSI
   * @param spNdsdetermRetrieveSO
   * @param spNdsDetBean
   */
  private void populateNewSpecialNeeds(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI,
                                       SpecialNeedsDeterminationRetrieveSO spNdsdetermRetrieveSO,
                                       SpecialNeedsDeterminationBean spNdsDetBean) {

    // Get the staff person Role of the user from the Workload table.
    String staffPersRole = workloadDAO.findPersRoleByIdStageIdPerson(spNdsdetermRetrieveSI.getUlIdStage(),
                                                                     spNdsdetermRetrieveSI.getUserId());
    spNdsdetermRetrieveSO.setStaffPersRole(staffPersRole);
    spNdsDetBean.setCdApprvSpclTypeFunding("");
    spNdsDetBean.setCdFundingType("");
    spNdsDetBean.setCdSpclSerType("");
    spNdsDetBean.setIndAllSpecialDocAttached("");
    spNdsDetBean.setIndApprvEmotionalDist("");
    spNdsDetBean.setIndApprvHearingImpaired("");
    spNdsDetBean.setIndApprvMntRetarded("");
    spNdsDetBean.setIndApprvOther("");
    spNdsDetBean.setIndApprvPhysicallyDisabled("");
    spNdsDetBean.setIndAprType("");
    spNdsDetBean.setIndChildEmotionallyDisabled("");
    spNdsDetBean.setIndChildVisHearingImpaired("");
    spNdsDetBean.setIndChildMntRetarded("");
    spNdsDetBean.setIndChildOtherMedical("");
    spNdsDetBean.setIndChildPhysicallyDisabled("");
    spNdsDetBean.setIndDocDevelopmentalAssmt("");
    spNdsDetBean.setIndDocMentalAssmt("");
    spNdsDetBean.setIndDocPsychological("");
    spNdsDetBean.setIndDocTrtmntPrvdr("");
    spNdsDetBean.setIndDocSSI("");

    spNdsDetBean.setIndBasicRateReq("");

    spNdsDetBean.setIndSFCorRBWO("");
    spNdsDetBean.setIndReasonSpecialRequest("");
    spNdsDetBean.setIndSpclRateAdoAppr("");
    spNdsDetBean.setIndSpclReqApproved("");
    spNdsDetBean.setIndSpclServiceReq("");
    spNdsDetBean.setCdPaymentMethod("");
    spNdsDetBean.setIndSpecializedRateReq("");
    spNdsDetBean.setIndAgrmtType("");
    spNdsDetBean.setIndSpcNeedsApproved("");
    spNdsDetBean.setNbrApprvAmt(new Double(0.0));
    spNdsDetBean.setNbrIvbAmt(new Double(0.0));
    spNdsDetBean.setNbrIveAmt(new Double(0.0));
    spNdsDetBean.setNbrReqAmt(new Double(0.0));
    spNdsDetBean.setNbrTotalIveIvbAmt(new Double(0.0));
    spNdsDetBean.setTxtApprvOtherCmt("");
    spNdsDetBean.setTxtCmntsEmotionallyDisabled("");
    spNdsDetBean.setTxtCmntsMntRetarded("");
    spNdsDetBean.setTxtCmntsOtherMedical("");
    spNdsDetBean.setTxtCmntsPhysicallyDisabled("");
    spNdsDetBean.setTxtCmntsSpecialRequest("");
    spNdsDetBean.setTxtCmntsVisHearingImpaired("");
    spNdsDetBean.setTxtComments("");
    spNdsDetBean.setTxtPleaseSpecify("");

    spNdsDetBean.setIndNonRecApproved("");
    spNdsDetBean.setNbrNonRecAprvAmt(new Double(0.0));
    spNdsDetBean.setIndNonRecRequested("");
    spNdsDetBean.setNbrNonRecAmt(new Double(0.0));

    spNdsDetBean.setNbrSpNeedsChildrenRequest(null);
    spNdsDetBean.setIndNonRecOnly(null);

    // STGAP00014563: Added new fields
    spNdsDetBean.setCdBasicRateType("");
    spNdsDetBean.setNbrCountyAddonAmt(new Double(0.0));
    spNdsDetBean.setDtSpecialNeedsApproved(null);
    spNdsDetBean.setAddComments("");
    spNdsDetBean.setNbrBasicAmt(new Double(0.0));

    // MR-60
    spNdsDetBean.setCdSpcNdsPrePosReq("");
    spNdsDetBean.setCdSpcNdsPrePosApr("");
  }

  private static double Round(double Rval, int Rpl) {
    double p = (double) Math.pow(10, Rpl);
    Rval = Rval * p;
    double tmp = Math.round(Rval);
    return (double) tmp / p;
  }
  
  // SMS#97845 MR-074-2 AFCARS
  /**
   * Populate Incident Status for application in PAD as follow:
   * - Retrieve Incident Status from DB for APRV application. Otherwise,
   * - If previous selection exists, copy over and set display mode to disable
   * - If previous selection does not exists, populate:
   *   -- PAD progressed from ADO: Y
   *   -- PAD progressed from INT + previous FC case exists: N
   *   -- Neither: blank
   * 
   * @param spNdsdetermRetrieveSI
   * @param spNdsdetermRetrieveSO
   */
  private void populateIncidentStatus(SpecialNeedsDeterminationRetrieveSI spNdsdetermRetrieveSI,
                                      SpecialNeedsDeterminationRetrieveSO spNdsdetermRetrieveSO) {
    // Exit if this is called from a stage other than PAD
    if (!CodesTables.CSTAGES_PAD.equals(spNdsdetermRetrieveSI.getCdStage())) 
      return;
    
    int idChild = spNdsdetermRetrieveSI.getUlIdPerson();
    int idStage = spNdsdetermRetrieveSI.getUlIdStage();

    // default to false
    spNdsdetermRetrieveSO.setBDisableIncidentStatus(false);

    // APRV status?
    if (CodesTables.CEVTSTAT_APRV.equals(spNdsdetermRetrieveSO.getCdEventStatus())) {
      SpecialNeedsDetermination spNdsDet = specialNeedsDeterminationDAO
                                                                       .findSpecialNeedsDeterminationByIdEvent(spNdsdetermRetrieveSI
                                                                                                                                    .getUlIdEvent());
      if (spNdsDet != null) {
        spNdsdetermRetrieveSO.setIndIncidentChild(spNdsDet.getIndIncidentChild());
        return;
      } else
        throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    
    // If not, then we are in PEND status; exit if this called from an application that is not in PEND status
    if (!CodesTables.CEVTSTAT_PEND.equals(spNdsdetermRetrieveSO.getCdEventStatus())) 
      return;

    // Any previously approved application?
    // Find the most recently entered selection of incident status from previous approved applications
    SpecialNeedsDetermination prevAprvSnd = specialNeedsDeterminationDAO
                                                                        .findLatestAprvSpclDeterminationByIdStageIdPerson(
                                                                                                                          idStage,
                                                                                                                          idChild);

    // Yes, apply the incident status from previous selection to this application and disable the section 
    if (prevAprvSnd != null) {
      spNdsdetermRetrieveSO.setIndIncidentChild(prevAprvSnd.getIndIncidentChild());
      spNdsdetermRetrieveSO.setBDisableIncidentStatus(true);
    } else {
      // ADO->PAD: set Y and leave field enabled 
      if (hasLinkToCdStage(idStage, CodesTables.CSTAGES_ADO)) {
        spNdsdetermRetrieveSO.setIndIncidentChild(ArchitectureConstants.Y);
      }
      // INT -> PAD:
      else if (hasLinkToCdStage(idStage, CodesTables.CSTAGES_INT)) { 
        // Yes, find if previous FCC exists?
        Stage stagePAD = stageDAO.findStageByIdStage(idStage);
        if (stagePAD == null)
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        // Whether previous FC case exists prior to PAD: 
        // Find the most recently opened FCC stage that is prior to PAD open for the same primary child
        // No need for checking case ID since this is executed when there was no ADO->PAD
        Integer idCase = stageDAO.findIdCaseByIdPersonCdRoleCdStageDtStageStart(idChild, CodesTables.CROLES_PC,
                                                                                CodesTables.CSTAGES_SUB,
                                                                                stagePAD.getDtStageStart());
        if (idCase != null) {
          // Most recent Legal Status Effective Date in the previous FC case indicates 
          // the child is not in DFCS custody with one of the following statuses:
          List<String> cdLegalStatusList = new ArrayList<String>(Arrays.asList(CodesTables.CLEGSTAT_AFS,
                                                                               CodesTables.CLEGSTAT_CTD,
                                                                               CodesTables.CLEGSTAT_DJA,
                                                                               CodesTables.CLEGSTAT_ILP,
                                                                               CodesTables.CLEGSTAT_NDJ,
                                                                               CodesTables.CLEGSTAT_NCD,
                                                                               CodesTables.CLEGSTAT_NCT,
                                                                               CodesTables.CLEGSTAT_NCO,
                                                                               CodesTables.CLEGSTAT_NPR,
                                                                               CodesTables.CLEGSTAT_NTT,
                                                                               CodesTables.CLEGSTAT_NCS,
                                                                               CodesTables.CLEGSTAT_NCE,
                                                                               CodesTables.CLEGSTAT_NGP,
                                                                               CodesTables.CLEGSTAT_NOT,
                                                                               CodesTables.CLEGSTAT_NPC,
                                                                               CodesTables.CLEGSTAT_STE));

          // Find the most recent LS in the FC case for the child
          LegalStatus legalStatus = legalStatusDAO.findMostRecentLegalStatusByIdPersonIdCase(idChild, idCase);
          // Whether the most recent LS indicate the primary child is not in DFCS custody by the list
          if (legalStatus != null && cdLegalStatusList.contains(legalStatus.getCdLegalStatStatus())) {
            spNdsdetermRetrieveSO.setIndIncidentChild(ArchitectureConstants.N);         
          }
        }
      } else { // explicit else to indicate the system will do nothing if neither above fits
        // The system cannot guess whether this is incident or incident child. SSAU needs to make decision on the page.
      }

    }
  }

  private boolean hasLinkToCdStage(int idStage, String cdStage) {
    List<String> cdStages = new ArrayList<String>();
    cdStages.add(cdStage);
    Integer result = stageLinkDAO.findStageLinkByIdStageAndCdStage(idStage, cdStages);

    return (result != null);
  }

}
