package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RetrieveExchangeChildDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildStruct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Change History:
 * 
 *  Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 02/11/2009   arege          STGAP00012046:Modified code so that the Field 'Family
 *                             With Whom Child is Placed' is populated when the child's
 *                             Legal Status is Adoption Finalized and there is an APRV
 *                             placement in the ADO stage.
 * 02/11/2009   arege          STGAP00012046: Added missing Null Pointer check in the method
 *                             getRegistrationInfo()
 * 02/19/2009   arege          STGAP00012046: Modified code as per code review.
 * 
 * 02/24/2009   bgehlot        STGAP00012534: After the Adoption stage is closed, the placement is end dated but a new one 
 *                             is created in PAD stage which is not end dated. The Placement name and county are pulled from 
 *                             the PAD stage Placement.
 * 03/20/2009   mxpatel        STGAP00012935: directed code to a new method that retrieves the first TPR/VS legal action for a case.
 *                             Also added If statement to make sure that child characteristics are mapped to the exchange child detail page.
 * 11/10/2009   mxpatel        37257: added code to also retrieve adults from FCC stage in order to retrieve background factors for a
 *                             child. Also only retrieve adults that match certain relationship.       
 * 12/03/2009   arege          SMS#37215 For re-registration find Earliest Exchange Child that was complete (in COMP status) in the given stage  
 *                             and get the dtregistered from that event and prepopulate it, also changed the logic to prepopulate dtapproved so 
 *                             that it is pulled from earliest approved Child Life History Check List event.      
 * 12/04/2009   cwells         37365: checking entire case for any of the legal statuses given the list above
 *                             legal status and bringing back the latest legal action to pre-populate the reason 
 *                             closed dropdown found on the exchange child detail
 *  12/05/2009  mxpatel        SMS # 37348: added code to allow users to unselect the pre-populated value of reason closed.                              
 *  12/06/2009  arege          SMS#40965 The Dissolution Date in the Closed With Placement section should be modifiable with a Date ticker. 
 *  12/14/2009 	arege	       SMS#37206 Closed With Placement section should populate if the Non Availability Reason Code of the family is saved to
 *                             one the codes out of Regular Placement, Foster Parent Placement, Foster/Adopt Placement, In Relative Placement, In Rel. Fstr-Prnt Plcmnt			    					
 *  12/18/2009  arege          SMS#37360 The dtNotified should not be populated from the TPR/VS if there exists an exchangeChild record with null dtNotified.   
 *  12/21/2009  arege          SMS#37360 Modified the code as per code review.                                                             
 *  12/28/2009  mxpatel        SMS# 37447: modified code to only pre-populate value of Birth name if the field has not been modified previously.     
 *  01/03/2010  mxpatel        SMS# 37248: modified the code to populate tpr Date in the parental rights section.       
 *  02/21/2011  htvo           SMS#97845 MR-074-2: retrieve and set data for new Putative Father section                                                                                               
 *  02/18/2010  arege          SMS#49672: Race selection issue on exchange home search page
 *  03/08/2011  htvo           SMS#97845 MR-074-2: used current TPR logic on other parent section for Putative Father per latest design update
 *  04/13/2011  htvo           SMS#105115: included TPR/VS - Putative Father in date notified retrieval logic. Replaced the TPR/VS local list with 
 *                             that in the Service Constants.
 *  05/24/2011  hnguyen        SMS#109405: MR-083 Cleaned up code to be dynamic in retrieving recruitment activity dates.
 */ 
public class RetrieveExchangeChildDetailImpl extends BaseServiceImpl implements RetrieveExchangeChildDetail {

  public static final String blackWhite = "Black-White";

  public static final String FCCP_FAMILY_PLAN_TASK_CODE = "7065";

  private PersonDAO personDAO = null;

  private ExchangeChildDAO exchangeChildDAO = null;

  private ExchangeChildFamLinkDAO exchangeChildFamLinkDAO = null;

  private DynamicExchangeChildFamLinkDAO dynamicExchangeChildFamLinkDAO = null;

  private SiblingDAO siblingDAO = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private LegalStatusDAO legalStatusDAO = null;

  private PlacementDAO placementDAO = null;

  private EmployeeDAO employeeDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private LegalActionOutcomeDAO legalActionOutcomeDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private ApproversDAO approversDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private EventDAO eventDAO = null;

  private CharacteristicsDAO characteristicsDAO = null;

  private AdoInfoDAO adoInfoDAO = null;

  private ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO = null;

  private StageLinkDAO stageLinkDAO = null;

  public StageLinkDAO getStageLinkDAO() {
    return stageLinkDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public PersonDAO getPersonDAO() {
    return personDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public CnsrvtrshpRemovalDAO getCnsrvtrshpRemovalDAO() {
    return cnsrvtrshpRemovalDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public LegalActionDAO getLegalActionDAO() {
    return legalActionDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public LegalStatusDAO getLegalStatusDAO() {
    return legalStatusDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public PlacementDAO getPlacementDAO() {
    return placementDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public EmployeeDAO getEmployeeDAO() {
    return employeeDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public PersonRaceDAO getPersonRaceDAO() {
    return personRaceDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public PersonEthnicityDAO getPersonEthnicityDAO() {
    return personEthnicityDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public LegalActionOutcomeDAO getLegalActionOutcomeDAO() {
    return legalActionOutcomeDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }

  public StagePersonLinkDAO getStagePersonLinkDAO() {
    return stagePersonLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public CapsResourceDAO getCapsResourceDAO() {
    return capsResourceDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public PersonPhoneDAO getPersonPhoneDAO() {
    return personPhoneDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CharacteristicsDAO getCharacteristicsDAO() {
    return characteristicsDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public ApproversDAO getApproversDAO() {
    return approversDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public EventDAO getEventDAO() {
    return eventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public ExchangeChildDAO getExchangeChildDAO() {
    return exchangeChildDAO;
  }

  public void setExchangeChildDAO(ExchangeChildDAO exchangeChildDAO) {
    this.exchangeChildDAO = exchangeChildDAO;
  }

  public AdoInfoDAO getAdoInfoDAO() {
    return adoInfoDAO;
  }

  public void setAdoInfoDAO(AdoInfoDAO adoInfoDAO) {
    this.adoInfoDAO = adoInfoDAO;
  }

  public ExchangeChildFamLinkDAO getExchangeChildFamLinkDAO() {
    return exchangeChildFamLinkDAO;
  }

  public void setExchangeChildFamLinkDAO(ExchangeChildFamLinkDAO exchangeChildFamLinkDAO) {
    this.exchangeChildFamLinkDAO = exchangeChildFamLinkDAO;
  }

  public SiblingDAO getSiblingDAO() {
    return siblingDAO;
  }

  public void setSiblingDAO(SiblingDAO siblingDAO) {
    this.siblingDAO = siblingDAO;
  }

  public ExcChildAdoInfoCbxDAO getExcChildAdoInfoCbxDAO() {
    return excChildAdoInfoCbxDAO;
  }

  public void setExcChildAdoInfoCbxDAO(ExcChildAdoInfoCbxDAO excChildAdoInfoCbxDAO) {
    this.excChildAdoInfoCbxDAO = excChildAdoInfoCbxDAO;
  }

  public DynamicExchangeChildFamLinkDAO getDynamicExchangeChildFamLinkDAO() {
    return dynamicExchangeChildFamLinkDAO;
  }

  public void setDynamicExchangeChildFamLinkDAO(DynamicExchangeChildFamLinkDAO dynamicExchangeChildFamLinkDAO) {
    this.dynamicExchangeChildFamLinkDAO = dynamicExchangeChildFamLinkDAO;
  }

  public ExchangeChildDetailRetrieveSO retrieveExchangeChildDetail(
                                                                   ExchangeChildDetailRetrieveSI exchangeChildDetailRetSI) {
    ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO = new ExchangeChildDetailRetrieveSO();
    ExchangeChildStruct excChildStruct = new ExchangeChildStruct();
    List<ChildLinkStruct> childLinkStructList = new ArrayList<ChildLinkStruct>();
    List<ChildLinkStruct> hasBeenChildLinkStructList = new ArrayList<ChildLinkStruct>();
    exchangeChildDetailRetSO.setExchangeChildStruct(excChildStruct);
    exchangeChildDetailRetSO.setChildLinkStructList(childLinkStructList);
    exchangeChildDetailRetSO.setHasBeenChildLinkStructList(hasBeenChildLinkStructList);
    int idChild = exchangeChildDetailRetSI.getUlIdChild();
    int idStage = exchangeChildDetailRetSI.getUlIdStage();
    int idCase = exchangeChildDetailRetSI.getUlIdCase();
    int idEvent = exchangeChildDetailRetSI.getUlIdEvent();
    String cdStage = exchangeChildDetailRetSI.getCdStage();
    String cdSortBy = exchangeChildDetailRetSI.getBWcdCdSortBy();
    int pageNbr = exchangeChildDetailRetSI.getArchInput().getUsPageNbr();
    int pageSize = exchangeChildDetailRetSI.getArchInput().getUlPageSizeNbr();
    boolean sortAscending = ServiceConstants.SORT_ASCENDING.equals(exchangeChildDetailRetSI.getSzSortDir());
    Event event = null;
    
    // Retrieve Child Information
    getChildInfo(exchangeChildDetailRetSO, idChild, idCase, idStage, idEvent);

    // Retrieve Exchange Child Detail Information and Recruitment Activities Information if idEvent is not zero.
    if (idEvent > 0) {
      
      // Retrieve Event Status
      event = eventDAO.findEventByIdEvent(idEvent);
      
      // Retrieve Recruitment Activities Information
      getRecruitmentActivitiesInfo(exchangeChildDetailRetSO, idEvent);

      // Retrieve Exchange Child Detail
      getExchangeChildInfo(exchangeChildDetailRetSO, idEvent);

      // Retrieve List of homes now being considered(Homes already linked to the child)
      getBeingConsdHmList(exchangeChildDetailRetSO, idEvent, pageNbr, pageSize, sortAscending, cdSortBy);

      // Retrieve List of homes that were considered in the past(Homes that were unlinked to the child)
      getHasBeenConsdHmList(exchangeChildDetailRetSO, idEvent, pageNbr, pageSize, sortAscending, cdSortBy);
      //STGAP00012021: Modified signature to add idCase
      // Retrieve closure information (Closed with placement or closed with no placement)
      getClosureInformation(exchangeChildDetailRetSO, idChild, idStage, idCase, event);

      // Retrieve Adoption Placement information
      getAdoptionPlacement(exchangeChildDetailRetSO, idChild, idStage);
    }

    // Retrieve Case Manager's information
    getCaseManagerInfo(exchangeChildDetailRetSO, idStage);

    // Retrieve Registration information 
    //STGAP00012046: We need to find Family with whom child is placed information, this was being done in getClosureInformation
    // only when the idEvent > 0.
    getRegistrationInfo(exchangeChildDetailRetSO, idCase, idStage, idChild, idEvent, cdStage);

    // Retrieve Special Needs Information
    if (idEvent <= 0 || CodesTables.CEVTSTAT_NEW.equals(event.getCdEventStatus())) {
      getSpecialNeedsInfo(exchangeChildDetailRetSO, idChild, idStage);
    }
    // Retrieve Status of Parental Rights
    getParentalRightsInfo(exchangeChildDetailRetSO, idStage, idCase, idChild);

    // Retrieve ADO INFO data to pre-populate the Closed Record section
    getAdoInfo(exchangeChildDetailRetSO, idChild);

    return exchangeChildDetailRetSO;
  }

  private void getChildInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idChild, int idCase,
                            int idStage, int idEvent) {
    // Retrieving Child Information
    Map child = personDAO.findChildInfoByChildId(idChild);
    if (child != null) {
      Date dtChildBirth = (Date) child.get("dtPersonBirth");
      if (dtChildBirth != null) {
        exchangeChildDetailRetSO.setChildAge(DateHelper.getAge(dtChildBirth));
      }
      exchangeChildDetailRetSO.setNmChild((String) child.get("nmPersonFull"));
      exchangeChildDetailRetSO.setCdGender((String) child.get("cdPersonSex"));
      exchangeChildDetailRetSO.setDtBirthChild(dtChildBirth);
      exchangeChildDetailRetSO.setIndAdoptDissol((String) child.get("indAdoptDisluton"));
      exchangeChildDetailRetSO.setDtDissolution((Date) child.get("dtDissolution"));
      exchangeChildDetailRetSO.setIndMothMarried((String) child.get("cdPersonMarriedAtBirth"));
    }
    boolean indChild = true;
    String childRace = retrievePersonRaceData(idChild, indChild);
    exchangeChildDetailRetSO.setTxtChildRace(childRace);
    String childEthnicity = retrievePersonEthnicityData(idChild);
    exchangeChildDetailRetSO.setTxtChEthnicity(childEthnicity);
    // Retrieve the Sibling Group Id
    Integer idSiblingGroup = siblingDAO.findSiblingGroupIdByIdPerson(idChild);
    if (idSiblingGroup != null) {
      exchangeChildDetailRetSO.setIdSiblingGroup(idSiblingGroup);
    }
  }

  private void getCaseManagerInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idStage) {
    StagePersonLink stgPersLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRoleAll(idStage);
    if (stgPersLink != null) {
      Person caseWorker = stgPersLink.getPerson();
      if (caseWorker != null) {
        String nmCaseWorker = caseWorker.getNmPersonFull();
        String nbrCsWorkerPhone = getPersonOfficePhone(caseWorker.getIdPerson());
        String caseWorkerInfo = "";
        if (nmCaseWorker != null && nbrCsWorkerPhone != null) {
          caseWorkerInfo = nmCaseWorker + " " + nbrCsWorkerPhone;
        } else if (nmCaseWorker == null && nbrCsWorkerPhone != null) {
          caseWorkerInfo = nbrCsWorkerPhone;
        } else if (nmCaseWorker != null && nbrCsWorkerPhone == null) {
          caseWorkerInfo = nmCaseWorker;
        }
        exchangeChildDetailRetSO.setCaseWorkerInfo(caseWorkerInfo);
      }
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void getRegistrationInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idCase, int idStage,
                                   int idChild, int idEvent, String cdStage) {
    // Get the most recent removal date of the child and set it into the retrieve object
    CnsrvtrshpRemoval cnsrvtrshpRemoval = cnsrvtrshpRemovalDAO.findCnsrvtrshpLatestRemovalByCaseAndByIdVictim(idCase,
                                                                                                              idChild);
    if (cnsrvtrshpRemoval != null) {
      exchangeChildDetailRetSO.setDtLastEntryFc(cnsrvtrshpRemoval.getDtRemoval());
    }
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    // SMS#105115: included TPR - Putative Father as part of MR-074-2 AFCARS. TPR list is now defined in Service Constants
    cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_FATHER_TYPES);
    cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_MOTHER_TYPES);

    // if (idEvent <= 0) {
    // Retrieve the earliest updated (STGAP00012015) TPR or Voluntary surrender date from Legal Actions. It is the last update
    // date on the earliest approved or complete legal action record with either one of the TPRs as the Hearing Type/Court
    // Order or with one of the Voluntary surrenders as the Legal Action, and with TPR Granted and Perm Custody to DHR
    // or Perm Custody to Specified Relative for Adoption or Perm Custody to a 3rd Party or Perm Custody to DHR or
    // Deceased Parents - Permanent Custody to DHR as the outcomes.
    List<String> cdLegalActActions = new ArrayList<String>();
    // SMS#105115: included Voluntary Surrender - Putative Father as part of MR-074-2 AFCARS. VS list is now defined in Service Constants.
    cdLegalActActions.addAll(ServiceConstants.LA_VOLUNTARY_SURRENDER_FATHER_TYPES);
    cdLegalActActions.addAll(ServiceConstants.LA_VOLUNTARY_SURRENDER_MOTHER_TYPES);

    List<String> cdLegalActOutcms = new ArrayList<String>();
    cdLegalActOutcms.add(CodesTables.CLEGLOUT_TPC);
    cdLegalActOutcms.add(CodesTables.CLEGLOUT_TPS);
    cdLegalActOutcms.add(CodesTables.CLEGLOUT_TPT);
    cdLegalActOutcms.add(CodesTables.CLEGLOUT_DPC);
    
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    String cdOutComeTypeTpg = CodesTables.CLEGLOUT_TPG;
    String cdOutComeTypeDpc = CodesTables.CLEGLOUT_DPC;
    
    // SMS#37215 Get the first COMP Exchange child detail event.
    List<String> cdEventStatuses = new ArrayList<String>();
    cdEventStatuses.add(CodesTables.CEVTSTAT_COMP);
    ExchangeChild exchangeChild = exchangeChildDAO.findEarliestExchangeChildByIdStageEventStatus(idStage,
                                                                                                 cdEventStatuses);

    // mxpatel directed to a different method for defect #STGAP00012935
    Date legalActionDate = legalActionDAO.findFirstTprVsLegalActionByIdCaseIdPerson(idCase, idChild, cdLegalActActions,
                                                                                    cdHrTypCrtOrds, cdEventType,
                                                                                    cdOutComeTypeTpg, cdOutComeTypeDpc);
    //Current ExchangeChild from RetSO object
    Date dtNotified = exchangeChildDetailRetSO.getExchangeChildStruct().getDtNotified();
    Date dtApproved = exchangeChildDetailRetSO.getExchangeChildStruct().getDtApproved();
    Date dtRegistered = exchangeChildDetailRetSO.getExchangeChildStruct().getDtRegistered();
    
    if (dtApproved == null) {
      // SMS#37215 Get the dtApproved from the COMP Exchange Child first if it exists.
      if (exchangeChild != null && exchangeChild.getDtApproved() != null) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setDtApproved(exchangeChild.getDtApproved());
      } else {
        // SMS#37215 We need the Earliest approved Child Life History Check List event
        Event cckEvent = eventDAO.findEarliestEventByStageTypeAndStatus(idStage, CodesTables.CEVNTTYP_CCK,
                                                                        CodesTables.CEVTSTAT_APRV);

        if (cckEvent != null) {
          Approvers approver = approversDAO.findApproverByIdEventIfEventIsApproved(cckEvent.getIdEvent(),
                                                                                   CodesTables.CEVTSTAT_APRV);
          dtApproved = approver.getDtApproversDetermination();
          exchangeChildDetailRetSO.getExchangeChildStruct().setDtApproved(dtApproved);
        }
      }
    }
    // SMS#37360: Modified the condition when dtNotified gets populated.
    if (dtNotified == null) {
      if (exchangeChild != null) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setDtNotified(exchangeChild.getDtNotified());
      } else if (legalActionDate != null ) { 
        exchangeChildDetailRetSO.getExchangeChildStruct().setDtNotified(legalActionDate);
      }
    }


    // SMS#37215 dtRegistered on the Re-registration event should come from the earliest COMP Exchange Child record.
    if (dtRegistered == null && exchangeChild != null) {
      Date dtRegisteredFromExcChild = exchangeChild.getDtRegistered();
      if (dtRegisteredFromExcChild != null) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setDtRegistered(dtRegisteredFromExcChild);
      }
    }
    
    // Get Birth Name
    String nmBirthChild = exchangeChildDetailRetSO.getExchangeChildStruct().getTxtBirthName();
    if (nmBirthChild == null || "".equals(nmBirthChild)) {
      nmBirthChild = getNmChildBirth(exchangeChildDetailRetSO, idChild, idStage, cdStage);
      exchangeChildDetailRetSO.getExchangeChildStruct().setTxtBirthName(nmBirthChild);
    }
    // }
    // Get the approval date of the most recent approved case plan event
    Integer idCsPlanEvent = eventPersonLinkDAO.findIdEventByIdCaseByEventTypeByEventStatus(idCase,
                                                                                           FCCP_FAMILY_PLAN_TASK_CODE,
                                                                                           idChild);
    if (idCsPlanEvent != null) {
      Approvers approver = approversDAO
                                       .findApproverByIdEventIfEventIsApproved(idCsPlanEvent, CodesTables.CEVTSTAT_APRV);
      //STGAP00012046: While fixing this defect added missing Null Pointer Check. 
      if(approver !=null){
      exchangeChildDetailRetSO.setDtUpdated(approver.getDtApproversDetermination());
      }
    }
    // Get the most recent legal status of the child to set the responsible county information
    LegalStatus legStat = legalStatusDAO.findMostRecentLegalStatusByIdPerson(idChild);
    if (legStat != null) {
      exchangeChildDetailRetSO
                              .setNmRspCounty(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, legStat.getCdLegalStatCnty()));
      exchangeChildDetailRetSO.setNbrRspCounty(legStat.getCdLegalStatCnty());
      exchangeChildDetailRetSO.setCdRspRegion(Lookup.simpleDecodeSafe(CodesTables.CCNTYREG,
                                                                      legStat.getCdLegalStatCnty()));
    }
    // Get the current, actual, non-concurrent placement for the child to populate the Boarding county information.
    Placement placement = placementDAO.findLatestApprovedPlacementByIdPersonByIdCase(idChild, idCase,
                                                                                     DateHelper.MAX_JAVA_DATE);
    if (placement != null) {
      exchangeChildDetailRetSO
                              .setNmBrdCounty(Lookup
                                                    .simpleDecodeSafe(CodesTables.CCOUNT, placement.getCdBoardingCnty()));
      exchangeChildDetailRetSO.setNbrBrdCounty(placement.getCdBoardingCnty());
      exchangeChildDetailRetSO.setCdBrdRegion(Lookup.simpleDecodeSafe(CodesTables.CCNTYREG,
                                                                      placement.getCdBoardingCnty()));
    }
       
    //STGAP00012046:If Child's Legal Status is Not in DFCS Custody- Adoption Finalized and there is an Open Placement in ADO stage
    //Set the name of the Resource to NmPlcmtRsrc field of exchangeChildDetailRetSO object
     String cdLegalStatus = StringHelper.EMPTY_STRING;
     String plcmtFacilName = StringHelper.EMPTY_STRING;
     String addrPlcmtCnty = StringHelper.EMPTY_STRING;
 
     if(legStat != null){
      cdLegalStatus = legStat.getCdLegalStatStatus();
    }
    
    //STGAP00012534:  After the Adoption stage is closed, the placement is end dated but a new one is created in PAD stage which
    // is not end dated. The Placement name and county are pulled from the PAD stage Placement.
    
     Integer idCasePad = stageLinkDAO.findNewIdPADCaseByIdPriorStage(idStage);
     Integer idStagePad = stageLinkDAO.findNewIdPADStageByIdPriorStage(idStage);
     if(idCasePad != null && idStagePad != null){
       Integer idPersonNew = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStagePad, CodesTables.CROLEALL_PC);
       Placement placementPADStage = placementDAO.findLatestApprovedPlacementByIdPersonByIdCase(idPersonNew, idCasePad, DateHelper.MAX_JAVA_DATE);
       if (placementPADStage != null) {
         // Get Placement name, county 
         plcmtFacilName  = placementPADStage.getNmPlcmtFacil();
         addrPlcmtCnty = placementPADStage.getAddrPlcmtCnty();
       }
     }else{
       if (placement!= null) {
         // Get Placement name, county 
         plcmtFacilName  = placement.getNmPlcmtFacil();
         addrPlcmtCnty = placement.getAddrPlcmtCnty();
       }
     }
    
    if (CodesTables.CLEGSTAT_NAF.equals(cdLegalStatus)) {
      exchangeChildDetailRetSO.setNmPlcmtRsrc(plcmtFacilName);
      exchangeChildDetailRetSO.setLegStatCnty(addrPlcmtCnty);
    }
 }

  @SuppressWarnings( { "unchecked" })
  private void getSpecialNeedsInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idChild, int idStage) {
    try {
      // Get child's special needs info from Person Characteristics
      Collection emotionalCodesList = Lookup.getCategoryCodesCollection(CodesTables.CADOEMD);
      Collection OthMedCodesList = Lookup.getCategoryCodesCollection(CodesTables.CADOOMD);
      Collection personIdsList = new ArrayList<Integer>();
      personIdsList.add(idChild);
      List<String> charList = characteristicsDAO.findCdCharacteristicByIdPerson(personIdsList);
      boolean emtDist = false;
      boolean othDiag = false;
      // Map the person characteristics to the special needs of the exchange child.
      if (charList != null && charList.size() > 0) {
        Iterator it = charList.iterator();
        while (it.hasNext()) {
          String character = (String) it.next();
          //mxpatel added this IF statement for defect #STGAP00012935
          //this is to make sure that when returning codes which are 1 digit, i.e. 3, 7 etc
          //we add a leading "0" to make appropriate comparison.
          if(character.length() == 1){
        	  character = "0" + character;
          }
          if (emotionalCodesList.contains(character)) {
            emtDist = true;
          }
          if (OthMedCodesList.contains(character)) {
            othDiag = true;
          }
          if (CodesTables.CME_52.equals(character)) {
            exchangeChildDetailRetSO.getExchangeChildStruct().setIndMntlRetard(ArchitectureConstants.Y);
          }
          if (CodesTables.CPM_36.equals(character) || CodesTables.CPM_84.equals(character)) {
            exchangeChildDetailRetSO.getExchangeChildStruct().setIndVisHearImp(ArchitectureConstants.Y);
          }
          if (CodesTables.CPL_75.equals(character)) {
            exchangeChildDetailRetSO.getExchangeChildStruct().setIndPhyDisabled(ArchitectureConstants.Y);
          }
          if (CodesTables.OTH_202.equals(character)) {
            exchangeChildDetailRetSO.getExchangeChildStruct().setIndChHxSxAbuse(ArchitectureConstants.Y);
          }
        }
      }
      if (emtDist) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setIndEmtDisturbed(ArchitectureConstants.Y);
      }
      if (othDiag) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setIndOthMed(ArchitectureConstants.Y);
      }
      
      //only consider these relatoinships when retrieving Background Factors
      List<String> relationship = new ArrayList<String>();
      relationship.add(CodesTables.CRPTRINT_BF); // Biological Father
      relationship.add(CodesTables.CRPTRINT_BB); // Biological and Legal Father
      relationship.add(CodesTables.CRPTRINT_BM); // Biological Mother
      relationship.add(CodesTables.CRPTRINT_BP); // Biological Parent 
      relationship.add(CodesTables.CRPTRINT_PA); // Parent 
      relationship.add(CodesTables.CRPTRINT_AB); // Absent Parent 
      
      
      // Get the Background Factors from the Person Characteristics of the adults in the ADO stage.
      List<Object> principalAdultIdsList = stagePersonLinkDAO.findPrincipalAdultsByStage(idStage, relationship);
      
      //Retrieve adults from FCC stage as well
      Integer idFccStage = stagePersonLinkDAO.findIdFccStageByIdPerson(idChild);
      List<Object> principalFccAdultIdsList = stagePersonLinkDAO.findPrincipalAdultsByStage(idFccStage,relationship);
            
      if (principalAdultIdsList != null && principalAdultIdsList.size() > 0) {
        personIdsList = new ArrayList<Integer>();
        Iterator it = principalAdultIdsList.iterator();
        while (it.hasNext()) {
          Integer personId = (Integer) it.next();
          if (personId != null) {
            personIdsList.add(personId);
          }
        }
      }
        
        if (principalFccAdultIdsList != null && principalFccAdultIdsList.size() > 0) {
          Iterator it1 = principalFccAdultIdsList.iterator();
          while (it1.hasNext()) {
            Integer personId = (Integer) it1.next();
            if (personId != null && !personIdsList.contains(personId)) {
              personIdsList.add(personId);
            }
          }
        }
      
        if(personIdsList != null && personIdsList.size() > 0){
        List<String> characterList = new ArrayList<String>();
        characterList = characteristicsDAO.findCdCharacteristicByIdPerson(personIdsList);
        if (characterList != null && characterList.size() > 0) {
          Iterator iterator = characterList.iterator();
          while (iterator.hasNext()) {
            String adultCharacter = (String) iterator.next();
            if (CodesTables.CCT_06.equals(adultCharacter) || CodesTables.CCT_20.equals(adultCharacter)) {
              exchangeChildDetailRetSO.getExchangeChildStruct().setIndFamHxDrugs(ArchitectureConstants.Y);
            }
            if (CodesTables.CCT_07.equals(adultCharacter) || CodesTables.CCT_22.equals(adultCharacter)) {
              exchangeChildDetailRetSO.getExchangeChildStruct().setIndFamHxIll(ArchitectureConstants.Y);
            }
            if (CodesTables.CCT_52.equals(adultCharacter)) {
              exchangeChildDetailRetSO.getExchangeChildStruct().setIndFamHxMr(ArchitectureConstants.Y);
            }
          }
        }
      }
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void getParentalRightsInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idStage, int idCase,
                                     int idChild) {
    int idMother = 0;
    int idBioFather = 0;
    int idLegFather = 0;
    int idPutFather = 0;
    boolean indChild = false;
    Collection relInts = new ArrayList<String>();
    relInts.add(CodesTables.CSRCRPTR_BM); // Bio Mother
    relInts.add(CodesTables.CSRCRPTR_LF); // Legal Father
    relInts.add(CodesTables.CSRCRPTR_BF); // Bio Father
    relInts.add(CodesTables.CSRCRPTR_BB); // Bio and Legal Father
    relInts.add(CodesTables.CSRCRPTR_PF); // Putative Father - MR-074-2 (SMS#97845)
    long cntPutFather = stagePersonLinkDAO.countStagePersonLinkByIdStageCdStagePersRelInt(idStage, CodesTables.CSRCRPTR_PF);
    boolean multiPutFather = cntPutFather > 1 ? true : false ;
    exchangeChildDetailRetSO.setMultiPutFather(multiPutFather);
    // get the list of stage person link records with the relationships of Biological Mother, Legal Father and
    // Biological Father to populate the Parental rights information.
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO
                                                                  .findStagePersonLinkByIdStageByCdStagePersRelInts(
                                                                                                                    idStage,
                                                                                                                    relInts);
    if (stagePersonLinkList != null && stagePersonLinkList.size() > 0) {
      Iterator it = stagePersonLinkList.iterator();
      while (it.hasNext()) {
        StagePersonLink stgPrsnLink = (StagePersonLink) it.next();
        Person person = stgPrsnLink.getPerson();
        if (stgPrsnLink != null && person != null) {
          if (idMother == 0 && CodesTables.CSRCRPTR_BM.equals(stgPrsnLink.getCdStagePersRelInt())) {
            idMother = person.getIdPerson();
            exchangeChildDetailRetSO.setDtBthMother(person.getDtPersonBirth());
            exchangeChildDetailRetSO.setDtDthMother(person.getDtPersonDeath());
          } else if (idBioFather == 0 && CodesTables.CSRCRPTR_BF.equals(stgPrsnLink.getCdStagePersRelInt())) {
            idBioFather = person.getIdPerson();
            exchangeChildDetailRetSO.setDtBthBioFather(person.getDtPersonBirth());
            exchangeChildDetailRetSO.setDtDthBioFather(person.getDtPersonDeath());
          } else if (idLegFather == 0 && CodesTables.CSRCRPTR_LF.equals(stgPrsnLink.getCdStagePersRelInt())) {
            idLegFather = stgPrsnLink.getPerson().getIdPerson();
            exchangeChildDetailRetSO.setDtBthLegFather(person.getDtPersonBirth());
            exchangeChildDetailRetSO.setDtDthLegFather(person.getDtPersonDeath());
          } else if (CodesTables.CSRCRPTR_BB.equals(stgPrsnLink.getCdStagePersRelInt())) {
            exchangeChildDetailRetSO.setIndBioFthIsLegFth(ArchitectureConstants.Y);
            idBioFather = person.getIdPerson();
            exchangeChildDetailRetSO.setDtBthBioFather(person.getDtPersonBirth());
            exchangeChildDetailRetSO.setDtDthBioFather(person.getDtPersonDeath());
          } else if(idMother == 0 && CodesTables.CSRCRPTR_LM.equals(stgPrsnLink.getCdStagePersRelInt())){
            idMother = person.getIdPerson();
            exchangeChildDetailRetSO.setDtBthMother(person.getDtPersonBirth());
            exchangeChildDetailRetSO.setDtDthMother(person.getDtPersonDeath());
          } else if (!multiPutFather && idPutFather == 0 && CodesTables.CSRCRPTR_PF.equals(stgPrsnLink.getCdStagePersRelInt())) {
        	  idPutFather = person.getIdPerson();
              exchangeChildDetailRetSO.setDtBthPutFather(person.getDtPersonBirth());
              exchangeChildDetailRetSO.setDtDthPutFather(person.getDtPersonDeath());
          }
        }
      }
    }
    // Set the race and Ethnicity information for the biological mother
   
    if (idMother!=0) {
      exchangeChildDetailRetSO.setTxtMotherRace(retrievePersonRaceData(idMother, indChild));
      exchangeChildDetailRetSO.setTxtMthEthnicity(retrievePersonEthnicityData(idMother));
    }
    //STGAP00012021: Moved the following code outside of the if block so that 
    //it will pull the date if there is a TPR without looking the stage person link
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    // SMS#105115: used TPR list defined in Service Constants while fixing dt notified defect
    cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_MOTHER_TYPES);    
    LegalAction legActionMother = legalActionDAO.findDtCrtActByHearingTypeByActionType(idCase,idChild, cdHrTypCrtOrds , CodesTables.CLEGCPS_COF);
    if(legActionMother!=null){
      if (legActionMother.getDtCrtActDate() != null) {
        exchangeChildDetailRetSO.setDtOrdTermFiledMoth(legActionMother.getDtCrtActDate());
      }
    }
    // Set the race and Ethnicity information for the biological father
    if (idBioFather != 0) {
      exchangeChildDetailRetSO.setTxtBioFthRace(retrievePersonRaceData(idBioFather, indChild));
      exchangeChildDetailRetSO.setTxtBioFthEthnicity(retrievePersonEthnicityData(idBioFather));
    }
    cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL);
    LegalAction legalActionBioFath = legalActionDAO.findDtCrtActByHearingTypeByActionType(idCase,idChild, cdHrTypCrtOrds , CodesTables.CLEGCPS_COF);
    if(legalActionBioFath!=null){
      if(legalActionBioFath.getDtCrtActDate()!=null){
        exchangeChildDetailRetSO.setDtOrdTermFiledBioFath(legalActionBioFath.getDtCrtActDate());
    }
    }
    // Set the race and Ethnicity information for the legal father
    if (idLegFather != 0) {
      exchangeChildDetailRetSO.setTxtLegFthRace(retrievePersonRaceData(idLegFather, indChild));
      exchangeChildDetailRetSO.setTxtLegFthEthnicity(retrievePersonEthnicityData(idLegFather));
    }
    cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA);
    LegalAction legalActionLegFath = legalActionDAO.findDtCrtActByHearingTypeByActionType(idCase, idChild,
                                                                                          cdHrTypCrtOrds,
                                                                                          CodesTables.CLEGCPS_COF);
    if (legalActionLegFath != null) {
      if (legalActionLegFath.getDtCrtActDate() != null) {
        exchangeChildDetailRetSO.setDtOrdTermFiledLegFath(legalActionLegFath.getDtCrtActDate());
      }
    }
    
    List<String> cdLegalActOutcms = new ArrayList<String>();
    cdLegalActOutcms.add(CodesTables.CLEGLOUT_DPC);// Deceased Parents - Permanent Custody to DHR

    // find appropriate legal action based on following logic
    // 1. find any Voluntary Surrender legal actions - consider the earliest event
    // 2.if there are any update to previous legal actions present use the latest updated event
    // 3. find any TPR legal actions - consider the earliest event
    // 4. if there are any update to previous legal actions present use the latest updated event
    // all of this is done in the legalActionDAO.findParentalRights query
    // find parental rights information for mother section
    List<String> cdLegalActActionsMother = new ArrayList<String>();
    cdLegalActActionsMother.add(CodesTables.CLEGCPS_VLM);// Voluntary Surrrender-Mother
    List<String> cdHrTypCrtOrdsMother = new ArrayList<String>();
    cdHrTypCrtOrdsMother.add(CodesTables.CLHECOT_TPM);// TPR-Mother

    Integer idLegalActionEvent = legalActionDAO.findIdLegalActionEventForParentalRights(idCase, idChild, cdLegalActActionsMother,
                                                                   cdHrTypCrtOrdsMother, cdLegalActOutcms);
    if (idLegalActionEvent != null) {
      LegalAction legalAction = legalActionDAO.findLegalActionByIdLegalActEvent(idLegalActionEvent);
      String tprMother = "";
      Date dtTprMother = null;
      if (legalAction != null) {
        if (CodesTables.CLEGCPS_VLM.equals(legalAction.getCdLegalActAction())) {
          tprMother = CodesTables.CTPRCODE_03;
          dtTprMother = legalAction.getDtCrtActDate();
        } else if (CodesTables.CLHECOT_TPM.equals(legalAction.getCdHrTypCrtOrd())) {
          tprMother = CodesTables.CTPRCODE_01;
          dtTprMother = legalAction.getDtCrtActDate();
        } else if (CodesTables.CLEGLOUT_DPC.equals(legalAction.getCdLegalActOutcome())) {
          if ("".equals(tprMother)) {
            tprMother = CodesTables.CTPRCODE_02;
            dtTprMother = legalAction.getDtCrtActDate();
          }
        }
      }
      exchangeChildDetailRetSO.setCdTprCodeMother(tprMother);
      exchangeChildDetailRetSO.setDtTprMother(dtTprMother);
    }

    // //find parental rights information for Father section
    List<String> cdLegalActActions2 = new ArrayList<String>();
    cdLegalActActions2.add(CodesTables.CLEGCPS_VSF);// Voluntary Surrender Legal/Biological Father
    cdLegalActActions2.add(CodesTables.CLEGCPS_VBF);// Voluntary Surrender Biological Father
    List<String> cdHrTypCrtOrds2 = new ArrayList<String>();
    cdHrTypCrtOrds2.add(CodesTables.CLHECOT_TFL);// TPR - Legal/Biological Father
    cdHrTypCrtOrds2.add(CodesTables.CLHECOT_TFB);// TPR - Biological Father

    idLegalActionEvent = legalActionDAO.findIdLegalActionEventForParentalRights(idCase, idChild, cdLegalActActions2, cdHrTypCrtOrds2,
                                                           cdLegalActOutcms);
    if (idLegalActionEvent != null) {
      LegalAction legalActionFather = legalActionDAO.findLegalActionByIdLegalActEvent(idLegalActionEvent);
      String tprBioFather = "";
      Date dtTprBioFather = null;
      if (legalActionFather != null) {
        if (CodesTables.CLHECOT_TFL.equals(legalActionFather.getCdHrTypCrtOrd())) {
          if ("".equals(tprBioFather)) {
            tprBioFather = CodesTables.CTPRCODE_01;
            dtTprBioFather = legalActionFather.getDtCrtActDate();
          }
        } else if (CodesTables.CLHECOT_TFB.equals(legalActionFather.getCdHrTypCrtOrd()) && "".equals(tprBioFather)) {
          tprBioFather = CodesTables.CTPRCODE_01;
          dtTprBioFather = legalActionFather.getDtCrtActDate();
        } else if (CodesTables.CLEGCPS_VSF.equals(legalActionFather.getCdLegalActAction()) && "".equals(tprBioFather)) {
          tprBioFather = CodesTables.CTPRCODE_03;
          dtTprBioFather = legalActionFather.getDtCrtActDate();
        } else if (CodesTables.CLEGCPS_VBF.equals(legalActionFather.getCdLegalActAction()) && "".equals(tprBioFather)) {
          tprBioFather = CodesTables.CTPRCODE_03;
          dtTprBioFather = legalActionFather.getDtCrtActDate();
        } else if (CodesTables.CLEGLOUT_DPC.equals(legalActionFather.getCdLegalActOutcome())) {
          if ("".equals(tprBioFather)) {
            tprBioFather = CodesTables.CTPRCODE_02;
            dtTprBioFather = legalActionFather.getDtCrtActDate();
          }
        }
      }
      exchangeChildDetailRetSO.setCdTprCodeBioFather(tprBioFather);
      exchangeChildDetailRetSO.setDtTprBioFather(dtTprBioFather);
    }
    
 // //find parental rights information for Legal Father section
    List<String> cdLegalActActions3 = new ArrayList<String>();
    cdLegalActActions3.add(CodesTables.CLEGCPS_VLS);// Voluntary Surrender Legal Father
    List<String> cdHrTypCrtOrds3 = new ArrayList<String>();
    cdHrTypCrtOrds3.add(CodesTables.CLHECOT_TFF);// TPR - Legal Father
    idLegalActionEvent = legalActionDAO.findIdLegalActionEventForParentalRights(idCase, idChild, cdLegalActActions3, cdHrTypCrtOrds3,
                                                                               cdLegalActOutcms);
    if (idLegalActionEvent != null) {
      LegalAction legalActionFather = legalActionDAO.findLegalActionByIdLegalActEvent(idLegalActionEvent);
      String tprLegFather = "";
      Date dtTprLegFather = null;
      if (legalActionFather != null) {
        if (CodesTables.CLHECOT_TFF.equals(legalActionFather.getCdHrTypCrtOrd()) && "".equals(tprLegFather)) {
          tprLegFather = CodesTables.CTPRCODE_01;
          dtTprLegFather = legalActionFather.getDtCrtActDate();
        } else if (CodesTables.CLEGCPS_VLS.equals(legalActionFather.getCdLegalActAction()) && "".equals(tprLegFather)) {
          tprLegFather = CodesTables.CTPRCODE_03;
          dtTprLegFather = legalActionFather.getDtCrtActDate();
        } else if (CodesTables.CLEGLOUT_DPC.equals(legalActionFather.getCdLegalActOutcome())) {
          if ("".equals(tprLegFather)) {
            tprLegFather = CodesTables.CTPRCODE_02;
            dtTprLegFather = legalActionFather.getDtCrtActDate();
          }
        }
      }
      exchangeChildDetailRetSO.setCdTprCodeLegFather(tprLegFather);
      exchangeChildDetailRetSO.setDtTprLegFather(dtTprLegFather);
    }
    
    // SMS#97845 MR-074-2: Set race, ethnic, TPR data for Putative Father section
    // Only set race, ethnic if not multiple putative father. Multiple is handled by jsp.
    if (!multiPutFather) {
        if (idPutFather!=0) {
            exchangeChildDetailRetSO.setTxtPutFthRace(retrievePersonRaceData(idPutFather, indChild));
            exchangeChildDetailRetSO.setTxtPutFthEthnicity(retrievePersonEthnicityData(idPutFather));
          }
    }
    // TPR/VS Putative Father: using the same logic with other parent section, 
    // omit unnecessary or obsolete code (per current business logic)
    List<String> cdLegalActActions4 = new ArrayList<String>();
    cdLegalActActions4.add(CodesTables.CLEGCPS_VPF);// Voluntary Surrender Putative Father
    List<String> cdHrTypCrtOrds4 = new ArrayList<String>();
    cdHrTypCrtOrds4.add(CodesTables.CLHECOT_TPP);// TPR - Putative Father
    String cdTprPutFather = StringHelper.EMPTY_STRING;
    Date dtTprPutFather = null;
    idLegalActionEvent = legalActionDAO.findIdLegalActionEventForParentalRights(idCase, idChild, cdLegalActActions4, cdHrTypCrtOrds4,
                                                                                cdLegalActOutcms);
    if (idLegalActionEvent != null) {
      LegalAction putativeFatherLA = legalActionDAO.findLegalActionByIdLegalActEvent(idLegalActionEvent);
      if (putativeFatherLA != null) {
        dtTprPutFather = putativeFatherLA.getDtCrtActDate();
        if (CodesTables.CLHECOT_TPP.equals(putativeFatherLA.getCdHrTypCrtOrd())) {
          cdTprPutFather = CodesTables.CTPRCODE_01; // Court Order
        } else if (CodesTables.CLEGCPS_VPF.equals(putativeFatherLA.getCdLegalActAction())) {
          cdTprPutFather = CodesTables.CTPRCODE_03; // Voluntary Release
        } else {
          cdTprPutFather = CodesTables.CTPRCODE_02; // Deceased
        }
      }
    }
    exchangeChildDetailRetSO.setCdTprCodePutFather(cdTprPutFather);
    exchangeChildDetailRetSO.setDtTprPutFather(dtTprPutFather);
    // Find court order filed date on the most recent update TPR court order with action Court Order Filed
    LegalAction legalActionPutFath = legalActionDAO.findDtCrtActByHearingTypeByActionType(idCase,idChild, cdHrTypCrtOrds4 , CodesTables.CLEGCPS_COF);
    if(legalActionPutFath != null) {
        exchangeChildDetailRetSO.setDtOrdTermFiledPutFath(legalActionPutFath.getDtCrtActDate());
    }

  }

  @SuppressWarnings( { "unchecked" })
  private void getRecruitmentActivitiesInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idEvent) {
    // Get the recruitment activity dates for this event
    List<ExcChildAdoInfoCbx> excChildAdoInfoList = excChildAdoInfoCbxDAO
                                                                        .findExcChildAdoInfoByIdEventByCdInfoCbx(
                                                                                                                 idEvent,
                                                                                                                 CodesTables.CADRACS);

    if (excChildAdoInfoList != null && excChildAdoInfoList.size() > 0) {
      Map<String, List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDates = new HashMap<String, List<ExcChildAdoInfoCbxStruct>>();
      Iterator<ExcChildAdoInfoCbx> it = excChildAdoInfoList.iterator();
      while (it.hasNext()) {
        ExcChildAdoInfoCbx excChildAdoInfoCbx = it.next();
        // MR-083 if code key does not exist in map yet then add otherwise retrieve existing
        // date list and add additional date.
        
        ExcChildAdoInfoCbxStruct excChildAdoInfoCbxSO = new ExcChildAdoInfoCbxStruct();
        excChildAdoInfoCbxSO.setIdInfoChar(excChildAdoInfoCbx.getIdInfoChar());
        excChildAdoInfoCbxSO.setIdEvent(excChildAdoInfoCbx.getExchangeChild().getEvent().getIdEvent());
        excChildAdoInfoCbxSO.setCdCbxCodeType(excChildAdoInfoCbx.getCdCbxCodeType());
        excChildAdoInfoCbxSO.setCdAdoInfoCbx(excChildAdoInfoCbx.getCdAdoInfoCbx());
        excChildAdoInfoCbxSO.setDtPerformed(excChildAdoInfoCbx.getDtPerformed());
        
        if( !savedRecActivitiesDates.containsKey(excChildAdoInfoCbx.getCdAdoInfoCbx())){
          List<ExcChildAdoInfoCbxStruct> recActList = new ArrayList<ExcChildAdoInfoCbxStruct>();
          recActList.add(excChildAdoInfoCbxSO);
          savedRecActivitiesDates.put(excChildAdoInfoCbx.getCdAdoInfoCbx(), recActList);
        }else{
          List<ExcChildAdoInfoCbxStruct> recActList = savedRecActivitiesDates.get(excChildAdoInfoCbx.getCdAdoInfoCbx());
          recActList.add(excChildAdoInfoCbxSO);
        }
      }
      exchangeChildDetailRetSO.setSavedRecActivitiesDates(savedRecActivitiesDates);
    }
  }

  private void getAdoInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idChild) {

  }

  private void getExchangeChildInfo(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idEvent) {
    ExchangeChild excChild = exchangeChildDAO.findExchangeChildByEventId(idEvent);
    ExchangeChildStruct excChildStruct = exchangeChildDetailRetSO.getExchangeChildStruct();
    if (excChild != null) {
      excChildStruct.setIdChildEvent(excChild.getIdEvent());
      excChildStruct.setIndLegalRisk(excChild.getIndLegalRisk());
      excChildStruct.setCdNonAvailStatus(excChild.getCdNonAvailStatus());
      excChildStruct.setDtNotified(excChild.getDtNotified());
      excChildStruct.setDtRegistered(excChild.getDtRegistered());
      excChildStruct.setDtApproved(excChild.getDtApproved());
      excChildStruct.setDtReRegistered(excChild.getDtReRegistered());
      excChildStruct.setTxtBirthName(excChild.getTxtBirthName());
      excChildStruct.setIndMntlRetard(excChild.getIndMentalRetardation());
      excChildStruct.setCdMntlSevLevel(excChild.getCdSevMentalRetardation());
      excChildStruct.setIndVisHearImp(excChild.getIndVisualHearingImp());
      excChildStruct.setCdVisHearSevLevel(excChild.getCdSevVisualHearingImp());
      excChildStruct.setIndPhyDisabled(excChild.getIndPhysicallyDisabled());
      excChildStruct.setCdPhySevLevel(excChild.getCdSevPhysicallyDisabled());
      excChildStruct.setIndEmtDisturbed(excChild.getIndEmotionallyDist());
      excChildStruct.setCdEmtSevLevel(excChild.getCdSevEmotionallyDist());
      excChildStruct.setIndOthMed(excChild.getIndOtherMed());
      excChildStruct.setCdOthSevLevel(excChild.getCdSevOtherMed());
      excChildStruct.setIndFamHxDrugs(excChild.getIndFamHxDrugsAlcohol());
      excChildStruct.setIndFamHxIll(excChild.getIndFamHxMentalIll());
      excChildStruct.setIndFamHxMr(excChild.getIndFamHxMr());
      excChildStruct.setIndChHxSxAbuse(excChild.getIndChHxSexualAbuse());
      excChildStruct.setTxtSpclNeedsCmnts(excChild.getTxtSpclNeedsComment());
      excChildStruct.setDtEventLastUpdate(excChild.getEvent().getDtLastUpdate());
      excChildStruct.setDtEventOccurred(excChild.getEvent().getDtEventOccurred());
      excChildStruct.setIndRsnClosedChanged(excChild.getIndRsnClosedChanged());
      excChildStruct.setIndBirthNameChanged(excChild.getIndBirthNameChanged());
      Date dtOut = excChild.getDtOut();
      excChildStruct.setDtOut(dtOut);
      if (dtOut != null) {
        String txtDaysOut = "";
        Date currentTime = new Date();
        if (currentTime.getTime() > dtOut.getTime()) {
          Double minDiff = new Double(DateHelper.minutesDifference(currentTime, dtOut) / 1440);
          Integer intMinDiff = minDiff.intValue();
          txtDaysOut = intMinDiff.toString();
        }
        excChildStruct.setTxtDaysOut(txtDaysOut);
      }
      excChildStruct.setTxtAvailCmnts(excChild.getTxtAvailComments());
      excChildStruct.setTxtChLinked(excChild.getTxtChildIsLinked());
      excChildStruct.setNbrAfile(excChild.getNbrAfile());
      excChildStruct.setDtClose(excChild.getDtClose());
      excChildStruct.setCdRsnClosed(excChild.getCdReasonClosed());
      excChildStruct.setTxtExplNoPlcmt(excChild.getTxtExplanationNoPlcmt());
      excChildStruct.setDtFinal(excChild.getDtFinal());
      excChildStruct.setDtFnEntered(excChild.getDtFinalEntered());
      excChildStruct.setDtDissolutionCWP(excChild.getDtDissolutionCWP()); //SMS#40965
      excChildStruct.setTxtChPlcdWith(excChild.getTxtChildPlacedWith()); 
      excChildStruct.setTxtRecCmnts(excChild.getTxtRecruitComment());
      excChildStruct.setDtLastUpdate(excChild.getDtLastUpdate());
      // MR-083 Get state actively recruiting for child
      exchangeChildDetailRetSO.setCdStateActivelyRecruiting(excChild.getCdStateActivelyRecruiting());
    } else if (idEvent > 0) {
      Event event = getPersistentObject(Event.class, idEvent);
      excChildStruct.setDtEventLastUpdate(event.getDtLastUpdate());
      excChildStruct.setDtEventOccurred(event.getDtEventOccurred());
    }
  }

  @SuppressWarnings( { "unchecked" })
  private void getBeingConsdHmList(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idEvent, int pageNbr,
                                   int pageSize, boolean sortDir, String cdSortBy) {

    String indLinkCurrent = ArchitectureConstants.Y;
    PaginatedHibernateList<Object[]> childFamBeingConsdList = dynamicExchangeChildFamLinkDAO
                                                                                            .findExchangeChildFamLinks(
                                                                                                                       idEvent,
                                                                                                                       indLinkCurrent,
                                                                                                                       cdSortBy,
                                                                                                                       pageNbr,
                                                                                                                       pageSize,
                                                                                                                       sortDir);
    ArchOutputStruct aos = new ArchOutputStruct();
    String bMoreDataInd = "N";
    if (childFamBeingConsdList != null && childFamBeingConsdList.size() > 0) {
      Iterator<Object[]> it = childFamBeingConsdList.iterator();
      while (it.hasNext()) {
        Object[] object = (Object[]) it.next();
        ChildLinkStruct childLinkStruct = new ChildLinkStruct();
        childLinkStruct.setIdResource((Integer) object[0] == null ? 0 : (Integer) object[0]);
        childLinkStruct.setNmResource((String) object[1] == null ? "" : (String) object[1]);
        childLinkStruct.setNonAvlRsnCode((String) object[2] == null ? "" : (String) object[2]);
        childLinkStruct.setCounty((String) object[4] == null ? "" : (String) object[4]);
        childLinkStruct.setIdHomeEvent((Integer) object[5] == null ? 0 : (Integer) object[5]);
        childLinkStruct.setDtOut((Date) object[6] == null ? null : (Date) object[6]);
        childLinkStruct.setDtLastUpdate((Date) object[7] == null ? null : (Date) object[7]);
        childLinkStruct.setIdExchangeChildFamLink((Integer) object[8] == null ? 0 : (Integer) object[8]);
        childLinkStruct.setIndLinked(true);
        childLinkStruct.setIdChildEvent(idEvent);
        exchangeChildDetailRetSO.getChildLinkStructList().add(childLinkStruct);
      }
    }
    aos.setBMoreDataInd(childFamBeingConsdList.getBMoreDataInd());
    exchangeChildDetailRetSO.setArchOutputStruct(aos);
  }

  @SuppressWarnings( { "unchecked" })
  private void getHasBeenConsdHmList(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idEvent, int pageNbr,
                                     int pageSize, boolean sortDir, String cdSortBy) {
    String indLinkCurrent = ArchitectureConstants.N;
    PaginatedHibernateList<Object[]> childFamHasBeenConsdList = dynamicExchangeChildFamLinkDAO
                                                                                              .findExchangeChildFamLinks(
                                                                                                                         idEvent,
                                                                                                                         indLinkCurrent,
                                                                                                                         cdSortBy,
                                                                                                                         pageNbr,
                                                                                                                         pageSize,
                                                                                                                         sortDir);
    ArchOutputStruct aos = new ArchOutputStruct();
    String bMoreDataInd = "N";
    if (childFamHasBeenConsdList != null && childFamHasBeenConsdList.size() > 0) {
      Iterator<Object[]> it = childFamHasBeenConsdList.iterator();
      while (it.hasNext()) {
        Object[] object = (Object[]) it.next();
        ChildLinkStruct childLinkStruct = new ChildLinkStruct();
        childLinkStruct.setIdResource((Integer) object[0] == null ? 0 : (Integer) object[0]);
        childLinkStruct.setNmResource((String) object[1] == null ? "" : (String) object[1]);
        childLinkStruct.setNonAvlRsnCode((String) object[2] == null ? "" : (String) object[2]);
        childLinkStruct.setNonSelRsn((String) object[3] == null ? "" : (String) object[3]);
        childLinkStruct.setCounty((String) object[4] == null ? "" : (String) object[4]);
        childLinkStruct.setIdHomeEvent((Integer) object[5] == null ? 0 : (Integer) object[5]);
        childLinkStruct.setDtOut((Date) object[6] == null ? null : (Date) object[6]);
        childLinkStruct.setDtLastUpdate((Date) object[7] == null ? null : (Date) object[7]);
        childLinkStruct.setIdExchangeChildFamLink((Integer) object[8] == null ? 0 : (Integer) object[8]);
        childLinkStruct.setIndLinked(true);
        childLinkStruct.setIdChildEvent(idEvent);
        exchangeChildDetailRetSO.getHasBeenChildLinkStructList().add(childLinkStruct);
      }
    }
    aos.setBMoreDataInd(childFamHasBeenConsdList.getBMoreDataInd());
    exchangeChildDetailRetSO.setArchOutputStruct(aos);
  }

  @SuppressWarnings( { "unchecked" })
  private void getClosureInformation(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idChild, int idStage,
                                     int idCase, Event event) {
    List<String> cdStages = new ArrayList<String>();
    int idEvent = event.getIdEvent();
    String cdLegalStatStatus = CodesTables.CLEGSTAT_NAF;
    cdStages.add(CodesTables.CSTAGES_ADO);
    cdStages.add(CodesTables.CSTAGES_SUB);
    
  //SMS#37206 Closed With Placement section should populate if the Non Availability Reason Code of the family is saved to one the 
  // codes out of Regular Placement, Foster Parent Placement, Foster/Adopt Placement, In Relative Placement, In Rel. Fstr-Prnt Plcmnt
    List<String> cdNonAvailCodes = new ArrayList<String>();
    cdNonAvailCodes.add(CodesTables.CANONAV_09); //Regular Placement
    cdNonAvailCodes.add(CodesTables.CANONAV_10); //Foster Parent Placement
    cdNonAvailCodes.add(CodesTables.CANONAV_12); //Foster/Adopt Placement
    cdNonAvailCodes.add(CodesTables.CANONAV_15); //In Relative Placement
    cdNonAvailCodes.add(CodesTables.CANONAV_16); //In Rel. Fstr-Prnt Plcmnt
    
    Map legStat = legalStatusDAO.findLegalStatusByIdCaseByIdPersonByCdStatusByCdStages(idCase, idChild,
                                                                                       cdLegalStatStatus, cdStages);
    String cdNonAvailStatus = exchangeChildDetailRetSO.getExchangeChildStruct().getCdNonAvailStatus();
    if (cdNonAvailCodes.contains(cdNonAvailStatus)) {
      if (legStat != null && exchangeChildDetailRetSO.getExchangeChildStruct().getDtFinal() == null) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setDtFinal((Date) legStat.get("dtLegalStatStatusDt")); // Date
                                                                                                                  // Final
      }
      if (legStat != null && exchangeChildDetailRetSO.getExchangeChildStruct().getDtFnEntered() == null) {
        exchangeChildDetailRetSO.getExchangeChildStruct().setDtFnEntered((Date) legStat.get("dtEventOccurred")); // Date
                                                                                                                  // Final
                                                                                                                  // Entered
      }
     
     //SMS#37206
      List resourceLinkedList = exchangeChildDetailRetSO.getChildLinkStructList();
      if (resourceLinkedList != null && !resourceLinkedList.isEmpty()) {
        ChildLinkStruct childLinkStruct = (ChildLinkStruct) resourceLinkedList.iterator().next();
        int idResource = childLinkStruct.getIdResource();
        CapsResource resource = capsResourceDAO.findCapsResourceByIdResc(idResource);
        if (resource != null) {
          exchangeChildDetailRetSO.setNmPlcmtRsrc(resource.getNmResource()); // Family with whom child is placed
          exchangeChildDetailRetSO.setNmPrvtAgency(resource.getNdfcsCertEntity()); // Private agency name
          exchangeChildDetailRetSO.setLegStatCnty(resource.getCdRsrcCnty()); // county
        }
        AdoInfo adoInfo = adoInfoDAO.findAdoInfoByIdChildRegEvent(idEvent);
        if (adoInfo != null) {
          exchangeChildDetailRetSO.setDtPlaced(adoInfo.getDtAdoAgree()); // Date placed
          exchangeChildDetailRetSO.setDtPermToFile(adoInfo.getDtPermFile()); // Permission to File
          exchangeChildDetailRetSO.setDtDocSent(adoInfo.getDtDocSent()); // Documents sent date
        }
      }
    } else if ((exchangeChildDetailRetSO.getExchangeChildStruct().getCdRsnClosed() == null || ""
                                                                                                .equals(exchangeChildDetailRetSO
                                                                                                                                .getExchangeChildStruct()
                                                                                                                                .getCdRsnClosed()))
               && ((ArchitectureConstants.N.equals(exchangeChildDetailRetSO.getExchangeChildStruct()
                                                                           .getIndRsnClosedChanged())) || (exchangeChildDetailRetSO
                                                                                                                                   .getExchangeChildStruct()
                                                                                                                                   .getIndRsnClosedChanged() == null))) {
      List<String> cdLegalStatStatusList = new ArrayList<String>();
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_PCT);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_STE);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_TVL);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NDJ);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NCT);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_ILP);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NCT);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NCE);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NCD);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NPR);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NGP);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NPC);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_AFS);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_TCT);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_PVL);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NCO);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NTT);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_DJA);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_JCP);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_JCT);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_NCS);
      cdLegalStatStatusList.add(CodesTables.CLEGSTAT_CTD);

      // 37365 checking entire case for any of the legal statuses given the list above
      // legal status and bringing back the latest legal action to pre-populate the reason
      // closed dropdown found on the exchange child detail
      Date dtEcdCreated = event.getDtEventOccurred();
      Map legStatus = legalStatusDAO.findLegalStatusByIdCaseByIdPerson(idCase, idChild, cdLegalStatStatusList,dtEcdCreated );
      if (legStatus != null) {
        String cdLegalStatStat = (String) legStatus.get("cdLegalStatStatus");
        if (CodesTables.CLEGSTAT_PCT.equals(cdLegalStatStat) || CodesTables.CLEGSTAT_STE.equals(cdLegalStatStat)
            || CodesTables.CLEGSTAT_TVL.equals(cdLegalStatStat) || CodesTables.CLEGSTAT_NDJ.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_04);
        } else if (CodesTables.CLEGSTAT_NCT.equals(cdLegalStatStat) || CodesTables.CLEGSTAT_ILP.equals(cdLegalStatStat)
                   || CodesTables.CLEGSTAT_NCE.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_06);
        } else if (CodesTables.CLEGSTAT_NCD.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_07);
        } else if (CodesTables.CLEGSTAT_NPR.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_08);
        } else if (CodesTables.CLEGSTAT_NGP.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_09);
        } else if (CodesTables.CLEGSTAT_NPC.equals(cdLegalStatStat) || CodesTables.CLEGSTAT_AFS.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_10);
        } else if (CodesTables.CLEGSTAT_TCT.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_11);
        } else if (CodesTables.CLEGSTAT_PVL.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_12);
        } else if (CodesTables.CLEGSTAT_NCO.equals(cdLegalStatStat) || CodesTables.CLEGSTAT_NTT.equals(cdLegalStatStat)
                   || CodesTables.CLEGSTAT_NCS.equals(cdLegalStatStat)
                   || CodesTables.CLEGSTAT_CTD.equals(cdLegalStatStat)
                   || CodesTables.CLEGSTAT_DJA.equals(cdLegalStatStat)
                   || CodesTables.CLEGSTAT_JCP.equals(cdLegalStatStat)
                   || CodesTables.CLEGSTAT_JCT.equals(cdLegalStatStat)) {
          exchangeChildDetailRetSO.getExchangeChildStruct().setCdRsnClosed(CodesTables.CADEXCLD_13);
        }
      }
    }
  }
  
  private void getAdoptionPlacement(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idChild, int idStage) {

    // Get the earliest, actual, non-concurrent placement for the ith a removal reason of
    // adoption disruption child in the ADO stage to populate the Disruption
    // date.
    String cdStage = CodesTables.CSTAGES_ADO;
    Date dtEnd = placementDAO.findAdoDisrPlcmtEndDateByIdChildByStageType(idChild, cdStage);
    // The date disruption is defined as the end date of the child's adoptive placement record that took place before
    // the
    // adoption is finalized.
    if (dtEnd != null) {
      exchangeChildDetailRetSO.setDtDisruption(dtEnd);
    }
  }

  // if a person has a primary active & valid business office phone, select it, otherwise get the next active & valid
  // business phone available
  private String getPersonOfficePhone(int idPerson) {
    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    return getPersonOfficePhoneNbr(idPerson, phoneTypes);
  }

  private String getPersonOfficePhoneNbr(int idPerson, List<String> phoneTypes) {
    StringBuffer primPersonPhone = new StringBuffer();
    String indPersonPhoneInValid = "N";
    String indPersonPhonePrimary = "Y";

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);

    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {

      PersonPhone personPhone = it.next();
      if (personPhone != null) {
        if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          }
        } else {
          if (personPhone.getNbrPersonPhone() != null) {
            primPersonPhone.append(FormattingHelper.formatPhone(personPhone.getNbrPersonPhone()));
            if (personPhone.getNbrPersonPhoneExtension() != null) {
              primPersonPhone
                             .append("   Ext " + FormattingHelper.formatPhone(personPhone.getNbrPersonPhoneExtension()));
            }
            break;
          } // inner else
        } // end outer if indPersonPhonePrimary
      } // end if personPhone
    } // end for loop
    return primPersonPhone.toString();

  }

  // If the current stage is ADO then search the system to see if there is any PAD stage with this child as the primary
  // child. If there is, then get the ADO stage in that case and get the name of the child using Stage Person Link. If the
  // current stage is PAD then get the child id from the previous ADO stage and get the person name from that.
  private String getNmChildBirth(ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO, int idChild, int idStage, String cdStage) {
    String nmBirth = "";
    boolean indPrevStageExists = true;
    Integer idPadStage = 0;
    Integer idAdoStage = 0;
    if(CodesTables.CSTAGES_PAD.equals(cdStage)){
      idPadStage = idStage;
      idAdoStage = stageLinkDAO.findPreviousIdStageByIdStageByCdStage(idStage);
    }else if(CodesTables.CSTAGES_ADO.equals(cdStage)){
      idAdoStage = idStage;
    }
    while (indPrevStageExists) {
      if (idAdoStage != null && idAdoStage != 0) {
        Integer idPrimChild =  stagePersonLinkDAO.findIdPersonForChildByIdStage(idAdoStage);
        if (idPrimChild != null && idPrimChild != 0) {
          // Get the id PAD Stage if there is any PAD stage in the system with this child as the primary child
          idPadStage = stagePersonLinkDAO.findIdStageByIdPersonCdStage(idPrimChild);
        }
        // If there is such PAD stage then see if there is a previous ADO stage if there is none exit the loop
        if (idPadStage != null && idPadStage != 0) {
          idAdoStage = stageLinkDAO.findPreviousIdStageByIdStageByCdStage(idPadStage);
        } else {
          indPrevStageExists = false;
          break;
        }
      } else {
        indPrevStageExists = false;
        break;
      }
    }
    if (idPadStage == null || idPadStage==0) {
      Person primaryChild = stagePersonLinkDAO
                                              .findNmPersonByIdStageByCdStagePersRole(idAdoStage, CodesTables.CROLES_PC);
      //37447: Only pre-populate value of birth name if it has not been modified previously.
      if ((primaryChild != null)
          && ((ArchitectureConstants.N.equals(exchangeChildDetailRetSO.getExchangeChildStruct()
                                                                      .getIndBirthNameChanged())) || (exchangeChildDetailRetSO
                                                                                                                              .getExchangeChildStruct()
                                                                                                                              .getIndBirthNameChanged() == null))) {
        nmBirth = primaryChild.getNmPersonFull();
      }
    }
    return nmBirth;
  }

  private String retrievePersonRaceData(int idPerson, boolean indChild) {
    List<PersonRace> personRaceList = personRaceDAO.findPersonRaceByIdPerson(idPerson);
    //SMS#49672: Used list instead of StringBuffer
    List<String> raceList  = new ArrayList<String>();
    List<String> cdRaceList = new ArrayList<String>();
    if (personRaceList != null && !personRaceList.isEmpty()) {
      for (Iterator<PersonRace> it = personRaceList.iterator(); it.hasNext();) {
        PersonRace personRace = it.next();
        raceList.add(Lookup.simpleDecodeSafe(CodesTables.CRACE, personRace.getCdRace()));
        cdRaceList.add(personRace.getCdRace());
      }
      // If the child has Black and White in the Race list and no other
      // races then append Black-White
      if (indChild && personRaceList.size() == 2 && cdRaceList.contains(CodesTables.CRACE_BK)
          && cdRaceList.contains(CodesTables.CRACE_WT)) {
        String raceString = "Black and White";           
        return raceString;
      }
    }
    String raceString = raceList.toString();
    raceString = raceString.substring(1,raceString.length()-1);    
    return raceString;
  }

  private String retrievePersonEthnicityData(int idPerson) {
    PersonEthnicity personEthnicity = personEthnicityDAO.findLatestPersonEthnicityByIdPerson(idPerson);
    if (personEthnicity != null) {
      return personEthnicity.getCdEthnicity();
    } else {
      return "";
    }
  }

  public EventPersonLinkDAO getEventPersonLinkDAO() {
    return eventPersonLinkDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
}
