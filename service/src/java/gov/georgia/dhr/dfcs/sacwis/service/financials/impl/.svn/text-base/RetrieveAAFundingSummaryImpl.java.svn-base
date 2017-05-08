package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingReasonEligDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceReasonNotEligible;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.financials.AAFundingReasonEligible;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveAAFundingSummary;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AAFundingSummaryRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Herve Jean-Baptiste September 09, 2011
 * 
 * <pre>
 *   Change History:
 *   Date         User                      Description
 *   ----------   -----------------------   -----------------------------------------------------------------
 *   10/17/2011   hjbaptiste                STGAP00017237:MR-092 Retrieving the FCC Eligibility information as well as
 *                                          the Applicable Sibling info
 *   10/20/2011   hnguyen                   STGAP00017237:MR-092 Populated SO with fcc eligibility event id to retrieve
 *                                          and display FCC reasons not eligible for IVE.  Same for Applicable Sibling.
 *                                                             
 * </pre>
 * 
 */
public class RetrieveAAFundingSummaryImpl extends BaseServiceImpl implements RetrieveAAFundingSummary {
  
  private static final String ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  private static final String UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;
  public static final String ADO_STAGE = CodesTables.CSTAGES_ADO;
  public static final String FCC_STAGE = CodesTables.CSTAGES_SUB;
  public static final String FCC_ELIGIBILITY_IVE = CodesTables.CELIGIBI_010;

  private AaFundingDAO aaFundingDAO = null;
  private EventDAO eventDAO = null;
  private PersonDAO personDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private AaFundingReasonEligDAO aaFundingReasonEligDAO = null;
  private PostEvent postEvent = null;
  private FceEligibilityDAO fceEligibilityDAO = null;
  private EligibilityDAO eligibilityDAO = null;
  AAFundingReasonEligible aAFundingReasonEligible = null;
  
  
  public void setAaFundingDAO(AaFundingDAO aaFundingDAO) {
    this.aaFundingDAO = aaFundingDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setAaFundingReasonEligDAO(AaFundingReasonEligDAO aaFundingReasonEligDAO) {
    this.aaFundingReasonEligDAO = aaFundingReasonEligDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEligibilityDAO(EligibilityDAO eligibilityDAO) {
    this.eligibilityDAO = eligibilityDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public void setaAFundingReasonEligible(AAFundingReasonEligible aAFundingReasonEligible) {
    this.aAFundingReasonEligible = aAFundingReasonEligible;
  }

  public AAFundingSummarySO retrieveAAFundingSummary(AAFundingSummaryRetrieveSI aAFundingSummaryRetrieveSI) throws ServiceException{
    AAFundingSummarySO aAFundingSummarySO = new AAFundingSummarySO();
    AaFunding aaFundingSummary = new AaFunding();
    List<String> cdAaFundingReasonEligs = new ArrayList<String>();
    Event aAFundingEvent = new Event();
    int idAaFundingEvent = aAFundingSummaryRetrieveSI.getIdAaFundingEvent();
    int idUser = aAFundingSummarySO.getIduser();
    int idCase = aAFundingSummaryRetrieveSI.getIdCase();
    int idStage = aAFundingSummaryRetrieveSI.getIdStage();
    String cdStage = aAFundingSummaryRetrieveSI.getCdStage();
    String cdTask = aAFundingSummaryRetrieveSI.getCdTask();
    String cdEventStatus = "";
    
    aAFundingSummarySO.setCdTask(cdTask);
    int idChild = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
    aAFundingSummarySO.setIdCase(idCase);
    aAFundingSummarySO.setIdStage(idStage);
    aAFundingSummarySO.setIduser(idUser);
    aAFundingSummarySO.setIdChild(idChild);
    aAFundingSummarySO.setCdStage(cdStage);
    
    // If the Add button was pressed, the event doesn't exist yet. We need to create the Event record.
    // We also need to set the event status
    boolean addButtonPressed = aAFundingSummaryRetrieveSI.isAddButtonPressed();
    if (addButtonPressed) {
      cdEventStatus = CodesTables.CEVTSTAT_NEW;
      aAFundingSummaryRetrieveSI.setCdReqAction(ADD);
      aAFundingSummaryRetrieveSI.setCdEventStatus(cdEventStatus);
      List<EventPersonLink> eventPersonLinkList = null;
      CCMN01UO ccmn01uo = new CCMN01UO();
      ccmn01uo = callPostEvent(aAFundingSummaryRetrieveSI, eventPersonLinkList);
      
      
      if (ccmn01uo != null) {
        idAaFundingEvent = ccmn01uo.getUlIdEvent();
        aAFundingEvent = (Event) getPersistentObject(Event.class, idAaFundingEvent);
        aAFundingSummarySO.setIdAaFundingEvent(idAaFundingEvent);
        aAFundingSummarySO.setDtEventLastUpdate(ccmn01uo.getTsLastUpdate());
        cdEventStatus = aAFundingEvent.getCdEventStatus();
        aAFundingSummarySO.setCdEventStatus(cdEventStatus);
      }
    } 
    // Else we need to find the event record and get the event status
    else {
      aAFundingEvent = eventDAO.findEventByIdEvent(idAaFundingEvent);
      if (aAFundingEvent != null) {
        cdEventStatus = aAFundingEvent.getCdEventStatus(); 
        aAFundingSummarySO.setIdAaFundingEvent(idAaFundingEvent);
        aAFundingSummarySO.setCdEventStatus(cdEventStatus);
        aAFundingSummarySO.setDtEventLastUpdate(aAFundingEvent.getDtLastUpdate());
        if (!CodesTables.CEVTSTAT_NEW.equals(aAFundingEvent.getCdEventStatus())) {
          aaFundingSummary = aaFundingDAO.findAAfundingByIdEvent(idAaFundingEvent);
          Employee revMax = aaFundingSummary.getEmployee();
          aAFundingSummarySO.setUserFirstName(revMax.getNmEmployeeFirst());
          aAFundingSummarySO.setUserLastName(revMax.getNmEmployeeLast());
          // If the AA Funding is a Non-Recurring Only, we need to return because we don't need to
          // to apply any of the Fostering Connections criteria. Therefore, we just return
          if (ServiceConstants.FND_YES.equals(aaFundingSummary.getIndNonRecurringReq())) {
            aAFundingSummarySO.setIndNonRecurringReq(aaFundingSummary.getIndNonRecurringReq());
            aAFundingSummarySO.setDtAaFundingValidated(aaFundingSummary.getDtAaFundingValidated());
            aAFundingSummarySO.setCdAaFundingType(aaFundingSummary.getCdAaFundingType());
            aAFundingSummarySO.setTxtComments(aaFundingSummary.getTxtComments());
            // Get the list of AA Funding Reason Eligible
            List<AaFundingReasonElig> aaFundingReasonEligs = getAllAaFundingReasonElig(idAaFundingEvent);
            for (AaFundingReasonElig r : aaFundingReasonEligs) {
              cdAaFundingReasonEligs.add(r.getCdAaFundingRsn());
            }
            aAFundingSummarySO.setCdAaFundingReasonEligs(cdAaFundingReasonEligs);
            return aAFundingSummarySO;
          }
        }
      }
    }

    aaFundingSummary.setEvent(aAFundingEvent);
    
    // If the event status is Approved(APRV), then we do not need to do any calculations since the event
    // is "frozen".  We simply want to retrieve the data that is in the database. 
    if (CodesTables.CEVTSTAT_APRV.equals(aAFundingSummarySO.getCdEventStatus())) {
      populateAAFundingSummarySO(aAFundingSummarySO, aaFundingSummary);
      // Get the list of AA Funding Reason Eligible
      List<AaFundingReasonElig> aaFundingReasonEligs = getAllAaFundingReasonElig(idAaFundingEvent);
      for (AaFundingReasonElig r : aaFundingReasonEligs) {
        cdAaFundingReasonEligs.add(r.getCdAaFundingRsn());
      }
      // Get the list of FCC Reason Not Eligible
      aAFundingSummarySO.setCdAaFundingReasonEligs(cdAaFundingReasonEligs);
      List<String> applicationReasonsNotEligible = new ArrayList<String>();
      aAFundingSummarySO.setCdEligibilityReasonsNotEligible(applicationReasonsNotEligible);
      // Since the event is 'Frozen', if there's no Eligibility Summary linked to this AA Funding,
      // don't bother retrieving data for the FCC Eligibility section. 
      if (aAFundingSummarySO.getIdEligibilityEvent() > 0) {
      int idEligibilityEvent = aaFundingSummary.getEligibility().getIdEligEvent();
        if (idEligibilityEvent > 0) {
          // We need to find the latest Initial/Amended FCEA Application
          // on the Eligibility Summary page
          aAFundingSummarySO.setIdEligibilityEvent(idEligibilityEvent);

          // Get the FCC Reason Not Eligible
          Eligibility eligibility = eligibilityDAO.findEligibilityByIdEligEvent(aAFundingSummarySO.getIdEligibilityEvent());
          // Get the Actual Eligibility and the Selected Eligibility and compare them to see if user has
          // performed an 'Override'.
          // NOTE: 'Overrides' will not be permitted in the near future and the compare logic will not be necessary
          if (eligibility != null) {
            String cdEligActual = eligibility.getCdEligActual();
            String cdEligSelected = eligibility.getCdEligSelected();
            if (!cdEligActual.equals(cdEligSelected)) {
              aAFundingSummarySO.setActualEligibilityChanged(true);
            }
            aAFundingSummarySO.setCdEligActual(cdEligSelected);
            // If the child was not FCC IV-E Eligible, get the list of reasons the child was not eligible
            if (!FCC_ELIGIBILITY_IVE.equals(cdEligActual)) {
              // If the Selected Eligibility has changed from the System Derived(Actual) Eligibility,
              // Retrieve the reasons to display. The reason is that at the moment, if the eligibility
              // has changed, a generic reason, indicating that the Eligibility has changed, is displayed
              // on the page instead of the actual reasons logged on the FCC Eligibility Summary
              if (!aAFundingSummarySO.isActualEligibilityChanged()) {
                
                FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdEligibilityEvent(idEligibilityEvent);
                if (fceEligibility != null) {
                  Collection<FceReasonNotEligible> fceReasonNotEligibles = fceEligibility.getFceReasonNotEligibles();
                  if (fceReasonNotEligibles != null && !fceReasonNotEligibles.isEmpty()) {
                    reasonsNotEligibleToString(fceReasonNotEligibles, applicationReasonsNotEligible);
                  }
                  aAFundingSummarySO.setCdEligibilityReasonsNotEligible(applicationReasonsNotEligible);
                }
              }
            }
          }
        }
      }
      
      // Get the Applicable Sibling Information
      if (aAFundingSummarySO.getIdApplicableSibling() > 0) {
        Person sibling = personDAO.findPersonByIdPerson(aAFundingSummarySO.getIdApplicableSibling());
        aAFundingSummarySO.setNmAcSiblingFullName(sibling.getNmPersonFull());
        aAFundingSummarySO.setDtAcSiblingDob(sibling.getDtPersonBirth());
      }
    }
    // If the event is not Approved(APRV), do pre-population, calculation and determination 
    else {
      // Populate the SO object with data that's currently in the database
      populateAAFundingSummarySO(aAFundingSummarySO, aaFundingSummary);
      // do calculations
      // determine the funding type
      aAFundingReasonEligible.determineAAFundingType(aAFundingSummarySO);
    }
    
    
    return aAFundingSummarySO;
  }
  
  /**
   * Transfers the Hibernate object's data record to the SO object to be returned to the
   * conversation.
   * 
   * @param aAFundingSummarySO
   * @param aaFundingSummary
   */
  private void populateAAFundingSummarySO(AAFundingSummarySO aAFundingSummarySO, AaFunding aaFundingSummary) {
    aAFundingSummarySO.setDtAaFundingValidated(aaFundingSummary.getDtAaFundingValidated());
    aAFundingSummarySO.setNbrFfy(aaFundingSummary.getNbrFfy() == null ? 0 : aaFundingSummary.getNbrFfy());
    aAFundingSummarySO.setDtChildDob(aaFundingSummary.getDtChildDob());
    aAFundingSummarySO.setNbrChildAge(aaFundingSummary.getNbrChildAge() == null ? 0 : aaFundingSummary.getNbrChildAge());
    aAFundingSummarySO.setIndNonRecurringReq(aaFundingSummary.getIndNonRecurringReq());
    aAFundingSummarySO.setCdAaFundingType(aaFundingSummary.getCdAaFundingType());
    aAFundingSummarySO.setIndAcAgeMet(aaFundingSummary.getIndAcAgeMet());
    aAFundingSummarySO.setIndAcTimeInFosterMet(aaFundingSummary.getIndAcTimeInFosterMet());
    aAFundingSummarySO.setNbrChildMthsInFoster(aaFundingSummary.getNbrChildMthsInFoster() == null ? 0 : aaFundingSummary.getNbrChildMthsInFoster());
    aAFundingSummarySO.setIndAcSiblingMet(aaFundingSummary.getIndAcSiblingMet());
    aAFundingSummarySO.setIdApplicableSibling(aaFundingSummary.getSibling() == null ? 0 : aaFundingSummary.getSibling().getIdPerson());
    aAFundingSummarySO.setNmAcSiblingFullName(aaFundingSummary.getNmAcSiblingFullName());
    aAFundingSummarySO.setDtAcSiblingDob(aaFundingSummary.getDtAcSiblingDob());
    aAFundingSummarySO.setNbrAcSiblingAge(aaFundingSummary.getNbrAcSiblingAge() == null ? 0 : aaFundingSummary.getNbrAcSiblingAge());
    aAFundingSummarySO.setNbrAcSiblingMthsInFoster(aaFundingSummary.getNbrAcSiblingMthsInFoster() == null ? 0 : aaFundingSummary.getNbrAcSiblingMthsInFoster());
    aAFundingSummarySO.setIndAcTprCtwVsMet(aaFundingSummary.getIndAcTprCtwVsMet());
    aAFundingSummarySO.setIndAcSsiEligMet(aaFundingSummary.getIndAcSsiEligMet());
    aAFundingSummarySO.setIndAcChildOfMinorMet(aaFundingSummary.getIndAcChildOfMinorMet());
    aAFundingSummarySO.setIndAcIvePriorAdoptMet(aaFundingSummary.getIndAcIvePriorAdoptMet());
    aAFundingSummarySO.setIndNacAfdcMet(aaFundingSummary.getIndNacAfdcMet());
    aAFundingSummarySO.setIndNacSsiEligMet(aaFundingSummary.getIndNacSsiEligMet());
    aAFundingSummarySO.setIndNacChildOfMinorMet(aaFundingSummary.getIndNacChildOfMinorMet());
    aAFundingSummarySO.setIndNacIvePriorAdoptMet(aaFundingSummary.getIndNacIvePriorAdoptMet());
    aAFundingSummarySO.setTxtComments(aaFundingSummary.getTxtComments());
    aAFundingSummarySO.setIdEligibilityEvent(aaFundingSummary.getEligibility() == null ? 0 : aaFundingSummary.getEligibility().getIdEligEvent());
  }
  
  /**
   * Updates or inserts the event for Adoption Assistance Funding Summary
   * 
   * @param 
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(AAFundingSummaryRetrieveSI aAFundingSummaryRetrieveSI , List<EventPersonLink> eventPersonLinkList) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String cdReqAction = aAFundingSummaryRetrieveSI.getCdReqAction();
    String desc = StringHelper.EMPTY_STRING;
    if (ADD.equals(cdReqAction)) {
        desc = "AA Funding Determination";
    }

    int idEvent = aAFundingSummaryRetrieveSI.getIdAaFundingEvent();
    Date dtEventOccurred = null;
    rowccmn01uig00.setSzCdEventStatus(aAFundingSummaryRetrieveSI.getCdEventStatus());
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_AFS);
    rowccmn01uig00.setSzCdTask(aAFundingSummaryRetrieveSI.getCdTask());
    rowccmn01uig00.setUlIdPerson(aAFundingSummaryRetrieveSI.getIdUser());
    rowccmn01uig00.setUlIdStage(aAFundingSummaryRetrieveSI.getIdStage());
    rowccmn01uig00.setUlIdEvent(idEvent);

    if(idEvent != 0){
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if(event != null){
        // Set the date last update from what is in the DB or else we can get a time stamp mismatch message
        Date dtEventLastUpdated = event.getDtLastUpdate();
        rowccmn01uig00.setTsLastUpdate(dtEventLastUpdated);
        dtEventOccurred = event.getDtEventOccurred();
        if (eventPersonLinkList != null && !eventPersonLinkList.isEmpty()) {
          Iterator<EventPersonLink> eventPersonLinkList_it = eventPersonLinkList.iterator();
          while (eventPersonLinkList_it.hasNext()) {
            EventPersonLink deleteEventPersonLink = eventPersonLinkList_it.next();
            Person person = deleteEventPersonLink.getPerson();
            ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
            rowccmn01uig01.setUlIdPerson(person.getIdPerson()); 
            rowccmn01uig01.setSzCdScrDataAction(cdReqAction);
            rowccmn01uig01.setTsLastUpdate(dtEventLastUpdated);
            rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          }
        }
      }
    }
    if (!DateHelper.isNull(dtEventOccurred) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(aAFundingSummaryRetrieveSI.getCdReqAction());
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }

  private void reasonsNotEligibleToString(Collection<FceReasonNotEligible> fceReasonsNotEligible, List<String> reasonsNotEligible) {
    for (FceReasonNotEligible fceReasonNotEligible : fceReasonsNotEligible) {
      reasonsNotEligible.add(fceReasonNotEligible.getCdReasonNotEligible());
    }
  }
  
  private List<AaFundingReasonElig> getAllAaFundingReasonElig(int idAaFundingEvent) {
    return aaFundingReasonEligDAO.findAaFundingReasonElig(idAaFundingEvent);
  }
}
