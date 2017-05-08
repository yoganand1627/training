package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildrenFirstReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;
import gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveServiceList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrieveEmergencyAssistance;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveCPSInvestigationConclusionValidation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN87DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV11SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UsSysNbrMessageCode_ARRAY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * This is the service class is used to run validations/edits for the Investigation Conclusion page.
 * 
 * <pre>
 *  Change History:
 *  Date      User        Description
 *  --------  ----------  --------------------------------------------------
 *  06/04/08  SWR         STGAP00009080 - Added hasAllegationsUnsubstantiated(), hasOtherOpenStagesInCase()
 *                        and made modifications to conditional edit checks so that
 *                        they were not run for the 'Opened in Error' closure reason.
 * 
 *  06/11/08  SWR         STGAP00008568 - Added edit checks for Safety Resource placements.
 *  
 *  10/16/08  alwilliams  STGAP00010014 - Updated method findEvents to only set the event status to COMP
 *                        if the event status is not PEND.
 *                        
 *                        STGAP00009916 - added code to perform check on Principal children in case to make sure
 *  11/20/08  CHARDEN     all children have been removed from home if the overall risk finding chosen is 'RISK INDICATED/OPEN FOR SERVICES'
 *  01/23/09  hnguyen     STGAP00011985 - Added static task code and modified code to retrieve only the investigation conclusion event
 *                        otherwise the approval event will be linked to multiple events when conclusion is submitted.
 *  07/11/09  arege       STGAP00014330   Check for Safety Resource Event in PEND, PROC status, if yes throw error message on Save and
 *                        and Submit.
 *  10/21/09  arege       SMS#38635 if there are SRP events in COMP or APRV Status, the error message of MSG_SAFETY_RES_EVENT should NOT be thrown while Save and Submit of 
 *                        CPS investigation conclusion 
 *  10/27/09  arege       SMS#37162 if there are SPL events in COMP or APRV Status, the error message of MSG_SAFETY_PLAN_EVENT should NOT be thrown while Save and Submit of 
 *                        CPS investigation conclusion                
 *  02/23/10  hnguyen     Check that all Child Death/Near Fatality/Serious Injury report event is approved,
 *                        if not then add MSG_INV_CDNFSI_APRV to error list
 *  03/26/10  arege       SMS#48860 Correctly display the error message on Submitting INV CCL.
 *  03/31/10  arege       SMS#49510 Added additional condition for displaying error message of MSG_INV_BCW_REF_REQ_2
 *  04/28/10  arege       SMS#42496: Prevent save and submit of INV CCL, if any of the events in the stage are in PEND status
 *  06/20/11  arege       SMS#112531 :A new BCW referral is required if the existing referral is more than 90 days old.
 *  06/22/11  charden     if safe place for newborns, short term emergency care or voluntary placement was selected for Special Circumstances, then do not do a Risk Assessment check
 *  06/27/11  arege       SMS#112535: Cannot approve an INV CCL with pending events even if these events were added after the 
 *                        investigation conclusion was submitted for approval.
 *  06/28/11  arege       SMS#112535: Added Safety Assessment event to the list of pending events to be checked while submitting and approving an INV CCL event, this will ensure
 *                        that the INV stage is closed after the approval of INV CCL event.
 *  03/02/12  aavila	  STGAP00017987: Changing method to find child death report to search through case instead of just stage.                      
 * </pre>
 */
public class SaveCPSInvestigationConclusionValidationImpl extends BaseServiceImpl implements
                                                                                 SaveCPSInvestigationConclusionValidation {
  
  private CharacteristicsDAO characteristicsDAO = null;
  
  private CheckStageEventStatus checkStageEventStatus = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private EventDAO eventDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private DynamicEventDAO dynamicEventDAO = null;

  private StageDAO stageDAO = null;

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private RetrieveServiceList retrieveServiceList = null;

  private ComplexEventDAO complexEventDAO = null;

  private RetrieveEmergencyAssistance retrieveEmergencyAssistance = null;

  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  
  private ChildrenFirstReferralDAO childrenFirstReferralDAO = null;

  private AllegationDAO allegationDAO = null;

  private TodoDAO todoDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private StageLinkDAO stageLinkDAO = null;

  private SafetyResourceChildDAO safetyResourceChildDAO = null;

  public static final String RISK_ASSMT_OPEN_FOR_PLACEMENT = CodesTables.CCRSKFND_01; // Risk Indicated/Open for
                                                                                      // Placement

  public static final String RISK_ASSMT_CONTROLLED = CodesTables.CCRSKFND_02; // Risk Controlled

  public static final String RISK_ASSMT_NO_SIGNFT_FACTOR = CodesTables.CCRSKFND_03; // No Significant Risk Factors

  public static final String RISK_ASSMT_NA = CodesTables.CCRSKFND_04; // Risk Assessment N/A

  public static final String RISK_ASSMT_OPEN_FOR_SERVICES = CodesTables.CCRSKFND_05; // Risk Indicated/Open for
                                                                                      // Services

  public static final String EVENT_TYPE_FOR_RISK_ASSMT = CodesTables.CEVNTTYP_ASM;

  public static final String RISK_ASSMT_TASK = "2295";

  public static final String SAFETY_ASSESSMENT_CODE = "2285";

  public static final String SAFETY_PLAN_CODE = "2275";
  
  public static final String INVESTIGATION_CCL_TASK = "2330";

  public static final String SAVE = "save";
  
  public static final String SAVEANDSUBMIT = "saveandsubmit";

  public void setChildrenFirstReferralDAO(ChildrenFirstReferralDAO childrenFirstReferralDAO) {
    this.childrenFirstReferralDAO = childrenFirstReferralDAO;
  }

  public void setCharacteristicsDAO(CharacteristicsDAO characteristicsDAO) {
    this.characteristicsDAO = characteristicsDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
  
  public void setDynamicEventDAO(DynamicEventDAO dynamicEventDAO) {
    this.dynamicEventDAO = dynamicEventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setRetrieveServiceList(RetrieveServiceList retrieveServiceList) {
    this.retrieveServiceList = retrieveServiceList;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setRetrieveEmergencyAssistance(RetrieveEmergencyAssistance retrieveEmergencyAssistance) {
    this.retrieveEmergencyAssistance = retrieveEmergencyAssistance;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stgLink) {
    this.stageLinkDAO = stgLink;
  }

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }

  public CINV15SO saveCPSInvestigationConclusionValidation(CINV15SI cinv15si) throws ServiceException {

    // Parameters that are used repeatedly are extracted and assigned to variables.
    int idStage = cinv15si.getUlIdStage();
    int idCase = cinv15si.getUlIdCase();
    String cdTask = cinv15si.getSzCdTask();
    String stageReasonClosed = cinv15si.getSzCdStageReasonClosed();
    //STGAP00009916 - on SAVE, checking to see if all children have been removed from home 
    //when overall risk finding is 'RISK INDICATED/OPEN FOR SERVICES'
    CINV15SO cinv15so = new CINV15SO();
    if (cdTask != null && SAVE.equals(cdTask)) {
      checkStageReasonClosedSub(idStage);
    } else if (!SAVE.equals(cdTask)){
      String dCdEditProcess = cinv15si.getSzDcdEditProcess();
      ArchInputStruct archInputStruct = cinv15si.getArchInputStruct();
      String sysNbrReserved1 = archInputStruct.getUlSysNbrReserved1();
      int idEvent = cinv15si.getUlIdEvent();
      if ("05".equals(stageReasonClosed)) {
        checkStageReasonClosedSub(idStage);
      }

      // This array object will be passed around and updated/appended by various private method.
      // At the end of the main method, it is set into the ouput object, cinv15so.
      UsSysNbrMessageCode_ARRAY usSysNbrMessageCode_ARRAY = new UsSysNbrMessageCode_ARRAY();
      cinv15so.setCINV15SOG01(new CINV15SOG01());
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setArchInputStruct(new ArchInputStruct());
      ccmn06ui.getArchInputStruct().setCReqFuncCd(archInputStruct.getCReqFuncCd());
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(cdTask);
      // CheckStageEventStatus;
      // this throws an exception that will halt processing with a message if it fails; success is no output.
      CCMN06UO ccmn06uo = checkStageEventStatus.status(ccmn06ui);
      if (ccmn06uo == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      // SWR - Do not run this check if the disposition is 'Opened in Error'
      if (!CodesTables.CCRSKFND_06.equals(cinv15si.getSzCdStageReasonClosed()) && findAllegationsByIdStage(idStage)) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_ALL_DSPSTN_REQ);
      }
      String checkAssessments = cinv15si.getBIndValidateAssessments();
      if (checkAssessments == null || "".equals(checkAssessments)) {
        checkAssessments = ArchitectureConstants.Y;
      }

      if (ArchitectureConstants.Y.equals(checkAssessments)) {
        // Check to see if there are any open RiskAssessments that are not in COMP status
        // int messageCodeForRA = findOpenRiskAssessments(idStage);
        int messageCodeForRA = setErroMsgForRiskAssessments(idStage, stageReasonClosed);

        if (messageCodeForRA != 0) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(messageCodeForRA);
        }

        // Check to see if there are any SafetyAssessments that need approval
        Object[] results = eventDAO.findSafetyAssessments(idStage);
        int totalSafetyAssessments = (Integer) results[0];
        int numberApproved = (Integer) results[1];
        // if (totalSafetyAssessments==0 || totalSafetyAssessments!=numberApproved){
        if (totalSafetyAssessments != numberApproved) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_SA_REQ);
        }      
  
      }
      
      

      // Call StagePersonLinkDAO, CINV34D
      // This handels edits for Victim DOB, Person Search, and
      // Person Characteristics. At least one of these edits is always required.
      // This performs a retrieve from the joined PERSON and STAGE PERSON LINK tables given the ID STAGE. Then
      // validates each person returned, using checks based on the Edit Process that it is passed into the service.
      // This method may append more than one value to the usSysNbrMessageCode_ARRAY object.
      if (!CodesTables.CCRSKFND_06.equals(cinv15si.getSzCdStageReasonClosed())) {
        findStagePersonLink(idStage, dCdEditProcess, usSysNbrMessageCode_ARRAY);
      }

      // If the Services and Referrals Checklist are required, call DAO using idEvent to get the event status.
      if (dCdEditProcess != null && dCdEditProcess.length() > SVC_REF_CHKLST_EDIT
          && dCdEditProcess.charAt(SVC_REF_CHKLST_EDIT) == EDIT_YES) {
        // Call EventDAO, CSESA3D
        Integer messageCode = findEventByIdStageAndEventTypeAndTask(idStage, sysNbrReserved1);
        if (messageCode != null) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(messageCode);
        }
      }
      // If a Safety Eval is required, call DAO, CCMN87D using idStage and cdTask == SAFETY_EVAL_TASK
      if (dCdEditProcess != null && dCdEditProcess.length() > SAFETY_EVAL_EDIT
          && dCdEditProcess.charAt(SAFETY_EVAL_EDIT) == EDIT_YES) {
        // Call DynamicEventDAO, CCMN87D
        ROWCINV15SOG00_ARRAY rowcinv15sog00_array = findEvents(idStage, sysNbrReserved1, SAFETY_EVAL_TASK,
                                                               CodesTables.CEVNTTYP_ASM, usSysNbrMessageCode_ARRAY);
        cinv15so.setROWCINV15SOG00_ARRAY(rowcinv15sog00_array);
      }

      // If a EA Questions are required, check the value of IND_CPS_INVST_EA_CONCL passed in the Input Message
      if (dCdEditProcess != null && dCdEditProcess.length() > EA_QUESTIONS_EDIT
          && dCdEditProcess.charAt(EA_QUESTIONS_EDIT) == EDIT_YES) {
        // If value is not 'Y' save the warning message in the Error List array. If value is
        // not NULL save the warning message in the ErrorList array. The 'Y' check was checking
        // if the family was actually found elegible, which is really not a concern for
        // Edits. So the change is made to check that the window is complete.
        if ((cinv15si.getBIndCpsInvstEaConcl() == null)
            && (!CodesTables.CCRSKFND_04.equals(cinv15si.getSzCdRiskAssmtRiskFind()))) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_EA_QUEST_REQ);
        }
      }
      if (dCdEditProcess != null && dCdEditProcess.length() > OPEN_SUBCARE_STAGE
          && dCdEditProcess.charAt(OPEN_SUBCARE_STAGE) == EDIT_YES) {
        // Before the user can Save and Submit a CPS Investigation Conclusion with recommendation
        // "Removal/Subcare", a Subcare stage must exist that meets one of the following criteria:
        // 1) is currently open, or 2) has been closed within the timespan of the investigation.
        // Call StageDAO, CLSS30D
        Integer messageCode = findStagesByIdCase(idCase, cinv15si.getDtDtCPSInvstDtlBegun());
        if (messageCode != null) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(messageCode);
        }
      }
      if (dCdEditProcess != null && dCdEditProcess.length() > SVC_AUTH_EDIT
          && dCdEditProcess.charAt(SVC_AUTH_EDIT) == EDIT_YES) {
        // Call ServiceAuth, which makes call to DAOs
        Integer messageCode = callServiceAuth(idStage, idCase, cdTask, cinv15si.getSzCdStageReasonClosed());
        if (messageCode != null) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(messageCode);
        }
      }
      // Call Consitency Check between EA Questions, Safety Plan, and Risk Findings
      // Calls to other DAOs are made from this private method.
      if (!CodesTables.CCRSKFND_06.equals(cinv15si.getSzCdStageReasonClosed())) {
        callConsistencyCheck(idStage, cinv15si.getSzCdRiskAssmtRiskFind());
      }

      if (!CodesTables.CCRSKFND_06.equals(cinv15si.getSzCdStageReasonClosed())) {
        // Call, StagePersonLinkDAO CLSC18D, to do an Edit check for Marital Status and Ethnicity.
        // Retrieve a list of principals in the home and data about these people using idStage.
        List<StagePersonLink> stagePersonLinkInfo = findAllPrincipalsLinkedToStage(idStage, dCdEditProcess,
                                                                                   usSysNbrMessageCode_ARRAY);
        if (stagePersonLinkInfo != null) {
          if (dCdEditProcess != null && dCdEditProcess.length() > RSN_DTH_EDIT
              && dCdEditProcess.charAt(RSN_DTH_EDIT) == EDIT_YES) {
            boolean bRsnDthEdit = false;
            for (Iterator<StagePersonLink> it = stagePersonLinkInfo.iterator(); it.hasNext() || bRsnDthEdit;) {
              // only check for consistency between death code and allegation severity
              // when there IS a death code. This will catch cases where allegation
              // severity = FT with no death code.
              StagePersonLink stagePersonLink = it.next();
              cinv15si.setSzCdPersonDeath(stagePersonLink.getPerson().getCdPersonDeath());
              int idPerson = stagePersonLink.getPerson().getIdPerson();
              // Call, CSES97D
              // Call AllegationDAO, CSES97D
              // Updates/appends usSysNbrMessageCode_ARRAY
              bRsnDthEdit = findAllegationByIdPersonAndIdStage(idStage, cinv15si.getSzCdPersonDeath(), idPerson,
                                                               bRsnDthEdit, usSysNbrMessageCode_ARRAY);
            }
          }
        }
      }

      // SWR 06/04/08 STGAP00009080 - Check that all allegations are unsubstantiated
      if (dCdEditProcess != null && dCdEditProcess.length() > UNSUB_ALLEG_EDIT
          && dCdEditProcess.charAt(UNSUB_ALLEG_EDIT) == EDIT_YES) {
        if (!hasAllegationsUnsubstantiated(idStage)) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_ALL_DSPSTN_UNSUB);
        }
      }

      // SWR 06/04/08 STGAP00009080 - Verify there are no open stages
      if (dCdEditProcess != null && dCdEditProcess.length() > OPEN_STAGE_EDIT
          && dCdEditProcess.charAt(OPEN_STAGE_EDIT) == EDIT_YES) {
        if (hasOtherOpenStagesInCase(idCase, idStage)) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_OPEN_STAGES);
        }
      }

      // SWR 06/11/08 STGAP00008568 Check for Open Safety Resource Placements
      if (dCdEditProcess != null && dCdEditProcess.length() > SAFETY_RESOURCE_EDIT
          && dCdEditProcess.charAt(SAFETY_RESOURCE_EDIT) == EDIT_YES) {
        if (hasOpenSafetyResourcePlacements(idStage)) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_SRP_INV_CNCLSN);
        }
      }
      //CAPTA Changes Added below
      String cdCpsoverallDisptn = cinv15si.getCdCpsOverallDisptn();
      List<Integer> pricipalUnderThree = stagePersonLinkDAO.findPrincipalPersonsUnderThreeByIdStage(idStage);
      boolean substantiatedMsgAdded = false;
      boolean unsubstantiatedMsgAdded = false;
      for (int i = 0; i < pricipalUnderThree.size(); i++){
        int idPerson = pricipalUnderThree.get(i);
        if (cdCpsoverallDisptn!= null && CodesTables.CDISPSTN_SUB.equals(cdCpsoverallDisptn) && !substantiatedMsgAdded){
          //Check CFR Event present for each child under 3
          /*
          When the overall investigation determination is substantiated, every 
          principal child under the age of three in the investigation must have a completed 
          referral to Babies Can’t Wait, which is submitted to Public Health using the Children
          1st referral.  This will be enforced by verifying that each child under 3 at the time 
          of Save and Submit has at least one Children 1st referral event in the stage which is 
          in COMP status.  If any eligible child does not have the completed referral, the 
          Error List will include this error message "One or more children under the age 3 do not 
          have a Babies Can’t Wait/Children 1st Referral.  Please navigate to the Children 1st 
          Referral List page for each child under 3 to generate and forward to Public Health.
          */
          //SMS#112531
          ChildrenFirstReferral cFr = childrenFirstReferralDAO.findLatestCompChildrenFirstReferralByIdPerson(idPerson);
          // Get the expiration date for the BCW referral which is 90 days from the latest referral 
          if(cFr != null){
          Date dtReferralExpiration = DateHelper.addToDate(cFr.getDtReferralSent(), 0, 0, 90); //A referral is valid until 90 days
          if(DateHelper.isBeforeToday(dtReferralExpiration)){
            usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_BCW_REF_REQ_1);
            substantiatedMsgAdded = true; 
          }
          }else{ //if there is no referral sent
            usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_BCW_REF_REQ_1);
            substantiatedMsgAdded = true;
          }
        }else if (cdCpsoverallDisptn!= null && CodesTables.CDISPSTN_UNS.equals(cdCpsoverallDisptn) && !unsubstantiatedMsgAdded){
          //Check if each child has the special characteristics
          /*
           * If the overall investigation determination is unsubstantiated, but there are children under the age of 3 in the 
           * case who have been identified as having physical or developmental delay by marking any of the characteristics 
           * under Child Physical/Medical, Child Behavior, Child Mental/Emotional, or the Other Medically Diagnosed Conditions
           * Requiring Special Care characteristic on the Person Characteristics page, then a referral is still required for 
           * those children.  If any child eligible due to age and characteristics does not have the completed referral, 
           * the Error List will include this error message "One or more children under the age of 3 whom have an identified 
           * physical impairment or developmental delay does not have a Babies Can’t Wait/Children 1st Referral.  
           * Please navigate to the Children 1st Referral List page for the children with medical conditions to 
           * generate and complete the referral to Public Health."
           */
          long charcCount = characteristicsDAO.countPhysicalDevelopmentalDelayCharacteristicsByIdPerson(idPerson);
          //SMS#49510
          //SMS#112531 
          ChildrenFirstReferral cFr = childrenFirstReferralDAO.findLatestCompChildrenFirstReferralByIdPerson(idPerson);
          if(charcCount > 0){
            // Get the expiration date for the BCW referral which is 90 days from the latest referral 
            if(cFr != null){
            Date dtReferralExpiration = DateHelper.addToDate(cFr.getDtReferralSent(), 0, 0, 90); //A referral is valid until 90 days
            if(DateHelper.isBeforeToday(dtReferralExpiration)){
              usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_BCW_REF_REQ_2);
              unsubstantiatedMsgAdded = true;  
            }
            }else{ //if there is no referral sent
              usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_BCW_REF_REQ_2);
              unsubstantiatedMsgAdded = true; 
            }           
          }
        }
      }
      /*
       * If any child in the case is an alleged victim in an allegation with an entered Severity of Child Death, Near
       * Fatality as Certified by a Physician, or Serious Injury, and that child does not have a Child Death/Near
       * Fatality/Serious Injury form event entered in the stage, the Error List will include this message: "One or more
       * children in the stage have an allegation with a severity of Child Death, Near Fatality as Certified by a
       * Physician or Serious Injury but do not have a Child Death/Near Fatality/Serious Injury Report entered. Please
       * produce and approve the Child Death/Near Fatality/Serious Injury report for each affected child."
       */
       // SMS#48860 Modified to take into account APRV event status  and correctly display the message
      
      //STGAP00017987 - Searching for report by case
      BigDecimal nbrAllegationWithNoCNSEvent = allegationDAO.countAllegationWithSevAsCDNFSIWithNoCNSEventByIdCase(idCase);
      int intAllegationWithNoCNSEvent = 0; //Integer variable for nbrAllegationWithNoCNSEvent
      
      if(nbrAllegationWithNoCNSEvent != null){
        intAllegationWithNoCNSEvent = nbrAllegationWithNoCNSEvent.intValue();
      }
      if (intAllegationWithNoCNSEvent > 0) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_CDNFSI_REQ);
      }
      /*
       * The system will perform an edit to verify that all children who have been marked as alleged victims on an
       * allegation with a severity of “Child Death” have an entered date of death. If any child does not have a DOD,
       * the Error List will display this message: "One or more children associated to an allegation with a severity of
       * Child Death to not have an entered Date of Death. Enter Date of Death on Person Detail before closing the
       * stage."
       */
      List<Allegation> childrenWithSevAsChildDeath = allegationDAO.findIdVictimByIdStageWithSevAsChildDeath(idStage);
      for (int i = 0; i < childrenWithSevAsChildDeath.size(); i++){
        Allegation childAllegation = childrenWithSevAsChildDeath.get(i);
        if (childAllegation != null && childAllegation.getPersonByIdVictim() != null &&
                        childAllegation.getPersonByIdVictim().getDtPersonDeath() == null ){
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_CD_ALLEG_DOD_REQ);
          break;
        }
      }

      // check that all Child Death/Near Fatality/Serious Injury reported event is approved, if any
      if (existsUnapprovedCNSByIdStage(idStage)) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_CDNFSI_APRV);
      }
       
      //SMS#112535 Moved this block of code here so that the validation message is thrown even in approval mode. This is required to see that there are no
      //Pending events that were created after the submission of INV CCL task. This will ensure that the INV stage
      //closes after the INV CCL approval.
      
      // ARR 07/11/2009 STGAP00014330 Check for Safety Resource Event in PEND, PROC status
      // SMS#38635 Look for SafetyResource Events that are in PROC and PEND.
      // The error message of MSG_SAFETY_RES_EVENT should NOT be thrown for events in 'COMP' Status.
      List<String> cdEventStatuses = new ArrayList<String>();
      cdEventStatuses.add(CodesTables.CEVTSTAT_PROC);
      cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);
      List<Event> eventList = eventDAO.findEventByIdCaseAndCdEventTypeDesc(idCase, CodesTables.CEVNTTYP_SRP,
                                                                           cdEventStatuses);
      if (eventList != null && !eventList.isEmpty()) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_SAFETY_RES_EVENT);
      }

      // ARR 10/26/2010 37162 Check for Safety Plan Event in PEND, PROC status, if exists throw error message.
      List<Event> eventListSPL = eventDAO.findEventByIdStageAndCdEventTypeDesc(idStage, CodesTables.CEVNTTYP_SPL,
                                                                               cdEventStatuses);
      if (eventListSPL != null && !eventListSPL.isEmpty()) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_SAFETY_PLAN_EVENT);
      }
      
      
    //SMS#42496: Check if any of the events are in PEND status, If yes error
      List<String> cdEventStatuses1 = new ArrayList<String>();
      cdEventStatuses1.add(CodesTables.CEVTSTAT_PEND);
      List<String> cdEventTypes = new ArrayList<String>();
      cdEventTypes.add(CodesTables.CEVNTTYP_AUT); //Service Auth Event
      cdEventTypes.add(CodesTables.CEVNTTYP_PPT); //Team Meetings/ Review
      cdEventTypes.add(CodesTables.CEVNTTYP_WVR); //Policy Waiver
      cdEventTypes.add(CodesTables.CEVNTTYP_LEG); //Legal Actions
      cdEventTypes.add(CodesTables.CEVNTTYP_ASM); //Safety Assessment  //SMS#112535 Added this because the SafetyAssessment task added after the 
      //submission of INV CCL was not being validated and this caused the investigation to get stuck due to pending Safety Assessment event.
      List<Event> pendingEventsList = eventDAO.findEventByIdStageCdEventStatusCdEventTypes(idStage, cdEventTypes,
                                                                           cdEventStatuses1);
      if (pendingEventsList != null && !pendingEventsList.isEmpty()) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_CONFIRM_EVENTS_DELETE);
      }

      // If no warnings posted, prepare to submit for approval
      cinv15so.getCINV15SOG01().setUsSysNbrMessageCode_ARRAY(usSysNbrMessageCode_ARRAY);
      if (usSysNbrMessageCode_ARRAY.getUsSysNbrMessageCodeCount() == 0) {
        // Call TodoDAO, CINV43D Set all TODOs associated with event to COMPLETED
        updateTodoByIdEvent(cinv15si.getUlIdEvent());
        // Retrieve all the events associated with the Investigation
        // Call DynamicEventDAO, CCMN87D
        // STGAP00011985 - This should only return the INV CCL event otherwise approval will
        // link to multiple events when conclusion is submitted
        ROWCINV15SOG00_ARRAY rowcinv15sog00_array = findEvents(idStage, sysNbrReserved1, INVESTIGATION_CCL_TASK, "",
                                                               usSysNbrMessageCode_ARRAY);
        cinv15so.setROWCINV15SOG00_ARRAY(rowcinv15sog00_array);
      }
    }
    return cinv15so;
  }

  // Calling EventDAO, CSESA3D
  private int findEventByIdStageAndEventTypeAndTask(int idStage, String sysNbrReserved1) {
    boolean bSvcRefChklst;
    Integer messageCode = null;
    Event eventInfo = eventDAO.findEventByIdStageAndEventTypeAndTask(idStage, CodesTables.CEVNTTYP_CHK,
                                                                     SVC_REF_CKLST_TASK);
    if (eventInfo == null) {
      messageCode = Messages.MSG_INV_SVC_RFRL_CHKLST_WARNING;
    } else {
      // Determine if the event status is COMP.
      bSvcRefChklst = false;
      // If the status of the event is not COMP, then user must complete the window before saving.
      if (CodesTables.CEVTSTAT_COMP.equals(eventInfo.getCdEventStatus())
          || (sysNbrReserved1.equals(ArchitectureConstants.Y) && (CodesTables.CEVTSTAT_PEND
                                                                                           .equals(eventInfo
                                                                                                            .getCdEventStatus())))) {
        bSvcRefChklst = true;
      }
      // Pop up error message if checkbox is selected and the inv is not abbreviated.
      if (!bSvcRefChklst) {
        // Set edit message to display that Services and Referalls Checklist is required.
        messageCode = Messages.MSG_INV_SVC_RFRL_CHKLST_WARNING;
      }
    }
    return messageCode;
  }

  /**
   * The UsSysNbrMessageCode_ARRAY object gets updated/appended with values based on the implemented logic. The appended
   * array is finally set back into the output object at the end of the main method.
   * 
   * @param idStage
   *                Used as a parameter for the DAO call.
   * @param dCdEditProcess
   *                Used in the implementged logic.
   * @param usSysNbrMessageCode_ARRAY
   *                Updated/appended with int values(message codes) based on some logic.
   * @throws ServiceException
   */
  private void findStagePersonLink(int idStage, String dCdEditProcess,
                                   UsSysNbrMessageCode_ARRAY usSysNbrMessageCode_ARRAY) throws ServiceException {
    PaginatedHibernateList<StagePersonLink> stagePersonLinkInfo;
    boolean bUnknownName;
    boolean bPersSearch = false;
    boolean bMoreDataInd = true;
    boolean bPersCharacter = false;
    boolean bVictimDob = false;
    int countOldestVictim = 0;
    int pageNbr = 1;
    int pageSize = 50;
    // Set loop to retrieve all the persons associated with the case
    while (bMoreDataInd) {
      stagePersonLinkInfo = stagePersonLinkDAO
                                              .findStagePersonLinkAndPersonByidStageAndCdStagePersType(
                                                                                                       idStage,
                                                                                                       CodesTables.CPRSNALL_STF,
                                                                                                       pageNbr,
                                                                                                       pageSize);
      if (stagePersonLinkInfo == null || stagePersonLinkInfo.size() <= 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      for (Iterator<StagePersonLink> it = stagePersonLinkInfo.iterator(); it.hasNext();) {
        StagePersonLink stagePersonLink = it.next();
        bUnknownName = false; // Reset bUnknownName for each person in the loop
        // Once than an edit flag has been set to TRUE, that same edit is not performed again.
        // If all three edit flags have been set, we exit out of for and while loops
        // Check to see if the name is unknown. Unknown names are defined as system generated
        // unknown names. System generated unknown names populate the full name of a person
        // with Unknown # (being either a number from 1-9 or a person id). The first and last
        // name fields will be left blank. Therefore, if the first and last names are blank, then
        // the name is system generated, so set the unknown name flag to true.
        if ((stagePersonLink.getPerson().getNmPersonFirst() == null)
            && (stagePersonLink.getPerson().getNmPersonLast() == null)) {
          bUnknownName = true;
        }
        String cdStagePersSearchInd = stagePersonLink.getCdStagePersSearchInd();
        String cdStagePersType = stagePersonLink.getCdStagePersType();
        if ((dCdEditProcess != null && dCdEditProcess.length() > PERS_SEARCH_EDIT && dCdEditProcess
                                                                                                   .charAt(PERS_SEARCH_EDIT) == EDIT_YES)
            && (!CodesTables.CSRCHSTA_R.equals(cdStagePersSearchInd))
            && (!CodesTables.CSRCHSTA_V.equals(cdStagePersSearchInd))
            && (!CodesTables.CPRSNTYP_COL.equals(cdStagePersType)) && (!bUnknownName) && (!bPersSearch)) {
          bPersSearch = true;
        }
        String cdPersonChar = stagePersonLink.getPerson().getCdPersonChar();
        if ((dCdEditProcess != null && dCdEditProcess.length() > PERS_CHARACTER_EDIT && dCdEditProcess
                                                                                                      .charAt(PERS_CHARACTER_EDIT) == EDIT_YES)
            && ((CodesTables.CPERCHAR_0.equals(cdPersonChar)) || (cdPersonChar == null))
            && (CodesTables.CPRSNTYP_PRN.equals(cdStagePersType)) && (!bUnknownName) && (!bPersCharacter)) {
          bPersCharacter = true;
        }
        // Check that all principals, not just victims, have a DOB. If one does not,
        // set flag to post warning. Also, if the name is not unknown, then set the edit flag.
        if ((dCdEditProcess != null && dCdEditProcess.length() > VICTIM_DOB_EDIT && dCdEditProcess
                                                                                                  .charAt(VICTIM_DOB_EDIT) == EDIT_YES)
            && CodesTables.CPRSNTYP_PRN.equals(cdStagePersType)
            && DateHelper.isNull(stagePersonLink.getPerson().getDtPersonBirth()) && !bUnknownName && !bVictimDob) {
          bVictimDob = true;
        }
        // Check that only one Oldest Vicitm exists, If two or more, sest flag to post warning
        if (CodesTables.CRELVICT_OV.equals(stagePersonLink.getCdStagePersRelInt())) {
          countOldestVictim++;
          if (countOldestVictim < 1) {
            break; // break out of for loop
          }
        }
        // Break out of for and while loops if all warning flags are set
        if (bPersCharacter == true && bVictimDob == true && bPersSearch == true) {
          bMoreDataInd = false;
          break;
        }
      }
      bMoreDataInd = stagePersonLinkInfo.isMoreDataAvailable();
    }// end while (bMoreDataInd)
    if (bPersCharacter) {
      usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_PERS_CHAR_REQ);
    }
    if (bVictimDob) {
      usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_VICTIM_DOB_REQ);
    }
    if (bPersSearch) {
      usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_PERS_SEARCH_REQ);
    }
    // Populate Output Message
    if (countOldestVictim > 1) {
      usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INT_ONE_PRINCIPAL_OV);
    }
  }

  // Call DynamicEventDAO, CCMN87D
  // Retrieves all the events from the EVENT table given the specific search criteria

  /**
   * 1.Updates/appends usSysNbrMessageCode_ARRAY; 2.Populates and returns ROWCINV15SOG00_ARRAY object. Calls the DAO to
   * retrieve all the events from the EVENT table given the specific search criteria.
   * 
   * @param idStage
   * @param sysNbrReserved1
   * @param cdTask1
   * @param cdEventType2
   * @param usSysNbrMessageCode_ARRAY
   *                Updated/appended with int values(message codes) based on some logic.
   * @return ROWCINV15SOG00_ARRAY The object containing values retrieved thru DynamicEventDAO call.
   */
  private ROWCINV15SOG00_ARRAY findEvents(int idStage, String sysNbrReserved1, String cdTask1, String cdEventType2,
                                          UsSysNbrMessageCode_ARRAY usSysNbrMessageCode_ARRAY) throws ServiceException {
    String[] cdEventTypes = null;
    ROWCINV15SOG00_ARRAY rowcinv15sog00_array = new ROWCINV15SOG00_ARRAY();
    if (cdEventType2 != null && !cdEventType2.trim().equals("")) {
      cdEventTypes = new String[] { cdEventType2 };
    }

    if (cdTask1 != null && cdTask1.trim().equals("")) {
      cdTask1 = null;
    }

    List<Object[]> dynamicEventInfo = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, cdEventTypes, null,
                                                                 cdTask1, null, null, null);
    if (dynamicEventInfo == null || dynamicEventInfo.size() <= 0) {
      if (cdTask1 != null && INVESTIGATION_ACTION_TASK.equals(cdTask1)) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_INV_ACT_QUEST_REQ);
      } else if (cdTask1 != null && SAFETY_EVAL_TASK.equals(cdTask1)) {
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_SAFETY_EVAL_REQ);
      } else if ("".equals(cdEventType2)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else {
      if ("".equals(cdEventType2)) {
        for (Iterator<Object[]> it = dynamicEventInfo.iterator(); it.hasNext();) {
          Object[] dynamicEvent = it.next();
          // Service Authorization events should not be returned to the client
          // If the Event has a status of NEW, it will not be included in the structure and will
          // thus not be updated to a status of PENDing. If the event is an approval event,
          // do not change the event status to PENDing.
          if ((!CodesTables.CEVNTTYP_AUT.equals(dynamicEvent[1]))
              && (!CodesTables.CEVTSTAT_NEW.equals(dynamicEvent[0]))
              && (!CodesTables.CEVNTTYP_APP.equals(dynamicEvent[1])) && (!SAFETY_PLAN_CODE.equals(dynamicEvent[11]))
              && (!SAFETY_ASSESSMENT_CODE.equals(dynamicEvent[11]))) {
            Integer idEvent = (Integer) dynamicEvent[6] != null ? (Integer) dynamicEvent[6] : 0;
            if (idEvent != 0) {
              ROWCINV15SOG00 rowcinv15sog00 = new ROWCINV15SOG00();
              rowcinv15sog00.setUlIdEvent(idEvent);
              // -- Update all related events with a status of COMP so the To-Do Detail can
              // -- properly update the status to PEND when saving a new approval todo and event.
              // -- STGAP00010014 - If the Event status is PEND do not reset status to COMP
              if (!CodesTables.CEVTSTAT_PEND.equals(dynamicEvent[0]))
                eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_COMP);
              rowcinv15sog00_array.addROWCINV15SOG00(rowcinv15sog00);
            }
          }
        }// end for (Iterator<Object[]> it
        // Also check for Pending on Investigation Actions.
      } else if (cdTask1 != null && INVESTIGATION_ACTION_TASK.equals(cdTask1)) {

        Iterator<Object[]> it = dynamicEventInfo.iterator();
        Object[] dynamicEvent = it.next();
        if ((!CodesTables.CEVTSTAT_COMP.equals(dynamicEvent[0]))
            && (!CodesTables.CEVTSTAT_PEND.equals(dynamicEvent[0]))) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_INV_ACT_QUEST_REQ);
        }
      } else if (cdTask1 != null && SAFETY_EVAL_TASK.equals(cdTask1)) {

        Iterator<Object[]> it = dynamicEventInfo.iterator();
        Object[] dynamicEvent = it.next();
        if ((!CodesTables.CEVTSTAT_COMP.equals(dynamicEvent[0]))
            || ((sysNbrReserved1 != null) && (!CodesTables.CEVTSTAT_PEND.equals(dynamicEvent[0])))) {
          usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_SAFETY_EVAL_REQ);
        }
      }
    }
    return rowcinv15sog00_array;
  }

  // Call TodoDAO, CINV43D to update status on the Todo table.
  private void updateTodoByIdEvent(int idEvent) {
    todoDAO.updateTodoByIdEvent(idEvent);
    // Future Hibernate code for Messages.MSG_CMN_UPDATE_FAILED
  }

  // original logic
  /*
   * private int findOpenRiskAssessments(int idStage){ int result = 0;
   * 
   * if (eventDAO.countCompletedRiskAssessments(idStage)==0){ result = Messages.MSG_INV_RA_REQ; } return result; }
   */

  /*
   * private int findOpenRiskAssessments(int idStage){ int result = 0; Integer temp =
   * stageLinkDAO.findPreviousIdStagebyIdStage(idStage); int prevIdStage = temp.intValue();
   * 
   * if (eventDAO.countCompletedRiskAssessments(idStage)==0 && !isSafePlaceForNewBornFromIntake(prevIdStage)){ result =
   * Messages.MSG_INV_RA_REQ; } return result; }
   */

  /*
   * private int findOpenRiskAssessments(int idStage){ int completedRiskAssessments = 0; //Integer temp =
   * stageLinkDAO.findPreviousIdStagebyIdStage(idStage); //int prevIdStage = temp.intValue();
   * 
   * completedRiskAssessments = (int)eventDAO.countCompletedRiskAssessments(idStage);
   * 
   * //if (eventDAO.countCompletedRiskAssessments(idStage)==0 && !isSafePlaceForNewBornFromIntake(prevIdStage)){ //
   * result = Messages.MSG_INV_RA_REQ; //} return completedRiskAssessments; }
   */

  // check if Safe place for new born is selected under special circumstances of intake.
  // if it is selected then bypasses the logic to check for completed risk assessment.
  private boolean isSafePlaceForNewBornFromIntake(int idStage) {
    boolean safePlaceForNewBorn = false;
    IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(idStage);
    if (incomingDetail != null) {
      String specialCircumstances = incomingDetail.getCdSpclCircumstances();
      // Corey 6/21/2011 Capta 4.3 Release - if safe place for newborns, short term emergency care or voluntary placement was selected for Special Circumstances, then do not do a Risk Assessment check
      if (CodesTables.CSPECCIR_SPN.equals(specialCircumstances) || CodesTables.CSPECCIR_SEC.equals(specialCircumstances) || CodesTables.CSPECCIR_VIP.equals(specialCircumstances)) {
        safePlaceForNewBorn = true;
      }
    }
    return safePlaceForNewBorn;
  }

  // If there are incomplete Risk Assessments for risk findings as Open for services, open for placement,
  // risk controlled or no significant risk factors then show message.
  private int setErroMsgForRiskAssessments(int idStage, String stageReasonClosed) {
    boolean setError = false;
    int messageCodeForRA = 0;
    // get the previous stage id to retrieve the intake record.
    Integer temp = stageLinkDAO.findPreviousIdStagebyIdStage(idStage);
    int prevIdStage = temp.intValue();
    boolean isSafePlaceForNewBorn = isSafePlaceForNewBornFromIntake(prevIdStage);
    // If risk indicated is not Risk assessment N/A then do not check for completed risk assessments
    // if safe place for new born is selected under special circumstances in Intake,
    // then bypass the logic to check completed Risk Assessments.
    if (RISK_ASSMT_NA.equals(stageReasonClosed) || isSafePlaceForNewBorn) {
      setError = false;
      // for all other risks indicated, check for completed Risk Assessments and show error for incomplete Risk
      // Assessments.
    } else if ((RISK_ASSMT_OPEN_FOR_PLACEMENT.equals(stageReasonClosed)
                || RISK_ASSMT_CONTROLLED.equals(stageReasonClosed)
                || RISK_ASSMT_NO_SIGNFT_FACTOR.equals(stageReasonClosed)
                || RISK_ASSMT_OPEN_FOR_SERVICES.equals(stageReasonClosed) || !RISK_ASSMT_NA.equals(stageReasonClosed))) {

      int completedRiskAssessments = (int) eventDAO.countCompletedRiskAssessments(idStage);
      if (completedRiskAssessments == 0) {
        setError = true;
      } else {
        setError = false;
      }

    }

    if (setError) {
      messageCodeForRA = Messages.MSG_INV_RA_REQ;
    }

    return messageCodeForRA;
  }

  // Call StageDAO, CLSS30D
  // Performs a retrieve from the STAGE table given the ID CASE.
  private Integer findStagesByIdCase(int idCase, org.exolab.castor.types.Date dtCPSInvstDtlBegun)
                                                                                                 throws ServiceException {
    boolean bSubStageFound = false;// Boolean flags to determine widget state
    Integer messageCode = null;
    List<Stage> stageInfo = stageDAO.findStagesByIdCase(idCase);
    if (stageInfo == null || stageInfo.size() <= 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // Populate output object if event list requested.
    // Check for a Subcare stage that meets one of the following
    // criteria: 1) is currently open, or 2) has been closed
    // within the timespan of the investigation.
    Iterator<Stage> it = stageInfo.iterator();
    while (it.hasNext()) {
      // for (Iterator<Stage> it = stageInfo.iterator(); it.hasNext();) {
      Stage stage = it.next();
      if (CodesTables.CSTAGES_SUB.equals(stage.getCdStage())
          && ((DateHelper.isNull(stage.getDtStageClose())) || (!DateHelper
                                                                          .isAfter(
                                                                                   DateHelper
                                                                                             .toCastorDate(stage
                                                                                                                .getDtStageClose()),
                                                                                   dtCPSInvstDtlBegun)))) {
        bSubStageFound = true;
        break;
      }
    }

    // If there is no Subcare stage that meets the criteria shown above, add a row to the error
    // list window and display a message telling the user that a Subcare stage must be created
    // before investigation stage can be concluded with recommendation "Removal/Subcare".
    if (!bSubStageFound) {
      messageCode = Messages.MSG_OPEN_SUBCARE_STAGE;
    }

    return messageCode;
  }

  // Calls DAOs to perform the Service Authorization edit
  private Integer callServiceAuth(int idStage, int idCase, String cdTask, String szCdStageReasonClosed)
                                                                                                       throws ServiceException {
    Integer messageCode = null;
    boolean bSvcAuthFlag = true;
    boolean bLastStage = false;
    // populate CurrentDate variable with current date
    Calendar calendar = Calendar.getInstance();
    Date dtCurrentDate = calendar.getTime();
    // We need to determine if this Investigation stage is the last stage in the case for
    // how we process Service Auth's later
    // Calling StageDAO, CCMNF6D. Returns the number of rows retrieved, if any.
    int rowCount = findStageByIdCaseDtStageClose(idCase);
    // If we only get one row back, then the current Investigation stage is the last stage in the case
    if (rowCount == 1) {
      bLastStage = true;
    }
    // Call DynamicEventDAO, CCMN87DA
    // retrieve all Service Authorization events for a particular IdEvent
    ROWCCMN87DO_ARRAY rowccmn87d0_array = findAuthEvents(idStage, cdTask);
    if (rowccmn87d0_array != null) {
      // Added "Moderate Family Pres" and Contracted Moderate Family Pres" to the list of
      // Recommended Actions for which APRV'd service auths will be progressed if Term Date is in the future.
      // If code Stage Reason Close is one of the FPR closure reasons allow approved,
      // open Service Auths to pass edit check.
      if ((!bLastStage) || (FAM_PRES_CODE.equals(szCdStageReasonClosed))
          || (MOD_FAM_PRES_CODE.equals(szCdStageReasonClosed)) || (INTNSV_FAM_PRES_CODE.equals(szCdStageReasonClosed))
          || (CNTRCTED_FAM_PRES_CODE.equals(szCdStageReasonClosed))
          || (CNTRCTED_MOD_FAM_PRES_CODE.equals(szCdStageReasonClosed))
          || (CNTRCTED_INTNSV_FAM_PRES_CODE.equals(szCdStageReasonClosed))) {
        for (Enumeration rowccmn87d0Enum = rowccmn87d0_array.enumerateROWCCMN87DO(); rowccmn87d0Enum.hasMoreElements()
                                                                                     && bSvcAuthFlag;) {
          ROWCCMN87DO rowccmn87d0 = (ROWCCMN87DO) rowccmn87d0Enum.nextElement();
          String cdEventStatus = rowccmn87d0.getSzCdEventStatus();
          int idEvent = rowccmn87d0.getUlIdEvent();
          // When this is not the last stage in the case, we are only concerned that there are
          // open COMPlete or PENDing Service Authorizations. Otherwise, the SvcAuths
          // are APRV, NEW or PROC and we don't give edit checks on these
          if ((CodesTables.CEVTSTAT_COMP.equals(cdEventStatus)) || (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))) {
            // Call ServiceAuthorizationDAO, CSES24D
            // Retrieve the IdSvcAuth based on the IdEvent
            int idSvcAuth = findServiceAuthEventLink(idEvent);
            if (idSvcAuth != 0) {
              // For the IdSvcAuth returned from the DAM search the SVC_AUTH_DETAIL table
              // to retrieve the SvcAuthDtlTermDate
              // Call RetrieveServiceList, CLSS24D
              ROWCCON21SOG00_ARRAY rowccon21sogoo_array = retrieveServiceList(idSvcAuth);
              if (rowccon21sogoo_array != null) {
                // For each Term date returned from the DAM, check it to make sure it isn't
                // greater than the current date. If it is set the SvcAuthFlag to false.
                for (Enumeration rowccon21sogooEnum = rowccon21sogoo_array.enumerateROWCCON21SOG00(); rowccon21sogooEnum
                                                                                                                        .hasMoreElements();) {
                  ROWCCON21SOG00 rowccon21sogoo = (ROWCCON21SOG00) rowccon21sogooEnum.nextElement();
                  Date dtSvcAuthDtlTerm = DateHelper.toJavaDate(rowccon21sogoo.getDtDtSvcAuthDtlTerm());
                  if (DateHelper.isBefore(dtCurrentDate, dtSvcAuthDtlTerm)) {
                    bSvcAuthFlag = false;
                    break;
                  }
                }
              }
            }
          }
        }
      } else {
        for (Enumeration rowccmn87d0Enum = rowccmn87d0_array.enumerateROWCCMN87DO(); rowccmn87d0Enum.hasMoreElements()
                                                                                     && bSvcAuthFlag;) {
          ROWCCMN87DO rowccmn87d0 = (ROWCCMN87DO) rowccmn87d0Enum.nextElement();
          String cdEventStatus = rowccmn87d0.getSzCdEventStatus();
          int idEvent = rowccmn87d0.getUlIdEvent();
          // String txtEventDescr = rowccmn87d0.getSzTxtEventDescr();
          // String cdTask = rowccmn87d0.getSzCdTask();
          // When this is the last stage in the case, we don't want any SvcAuths that are
          // above COMPlete to have a term date greater than today (unless the Service
          // Codes correspond to types of daycare services--Ex. 40M. Otherwise, the SvcAuths
          // are NEW or PROC and we don't give edit checks on these
          if ((CodesTables.CEVTSTAT_COMP.equals(cdEventStatus)) || (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))
              || (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus))) {
            // Call ServiceAuthorizationDAO, CSES24D to retrieve the IdSvcAuth based on the IdEvent
            int idSvcAuth = findServiceAuthEventLink(idEvent);
            if (idSvcAuth != 0) {
              // Call RetrieveServiceList, CLSS24D
              // For each IdSvcAuth returned from the DAM search the SVC_AUTH_DETAIL table to
              // retrieve the SvcAuthDtlTermDate
              ROWCCON21SOG00_ARRAY rowccon21sogoo_array = retrieveServiceList(idSvcAuth);
              if (rowccon21sogoo_array != null) {
                // For each Term date returned from the DAM, check it to make
                // sure it greater than the current date.
                // If it is set the SvcAuthFlag to false.
                for (Enumeration rowccon21sogooEnum = rowccon21sogoo_array.enumerateROWCCON21SOG00(); rowccon21sogooEnum
                                                                                                                        .hasMoreElements();) {
                  ROWCCON21SOG00 rowccon21sogoo = (ROWCCON21SOG00) rowccon21sogooEnum.nextElement();
                  Date dtSvcAuthDtlTerm = DateHelper.toJavaDate(rowccon21sogoo.getDtDtSvcAuthDtlTerm());
                  String cdSvcAuthDtlSvc = rowccon21sogoo.getSzCdSvcAuthDtlSvc();

                  if ((DateHelper.isBefore(dtCurrentDate, dtSvcAuthDtlTerm))
                      || (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))
                      || (CodesTables.CEVTSTAT_COMP.equals(cdEventStatus))) {

                    if ((CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))
                        || (CodesTables.CEVTSTAT_COMP.equals(cdEventStatus))) {
                      bSvcAuthFlag = false;
                      break;
                    }
                  }
                }
              }
            }
          }
          // (APPROVED.equals(cdEventStatus)))
        }
      }
    }
    if (!bSvcAuthFlag) {
      messageCode = Messages.MSG_SVA_OPN_AUTHS;
    }
    return messageCode;
  }

  // Calls the DynamicEventDAO,CCMN87DA t retrieve event records based on the given search criteria.
  private ROWCCMN87DO_ARRAY findAuthEvents(int idStage, String cdTask) throws ServiceException {
    ROWCCMN87DO_ARRAY rowccmn87d0_array = new ROWCCMN87DO_ARRAY();
    List<Object[]> dynamicEventInfo = dynamicEventDAO.findEvents(false, 0, idStage, 0, 0, 0, null, null, cdTask, null,
                                                                 null, null);
    if (dynamicEventInfo == null || dynamicEventInfo.size() <= 0) {
      throw new ServiceException(Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST);
    } else {
      for (Iterator<Object[]> it4 = dynamicEventInfo.iterator(); it4.hasNext();) {
        Object[] dynamicEvent = it4.next();
        ROWCCMN87DO rowccmn87d0 = new ROWCCMN87DO();
        rowccmn87d0.setSzCdEventStatus((String) dynamicEvent[0]);
        rowccmn87d0.setSzCdEventType((String) dynamicEvent[1]);
        rowccmn87d0.setDtDtEventOccurred(DateHelper.toCastorDate((Date) dynamicEvent[3]));
        rowccmn87d0.setUlIdEvent((Integer) dynamicEvent[6] != null ? (Integer) dynamicEvent[6] : 0);
        rowccmn87d0.setSzTxtEventDescr((String) dynamicEvent[10]);
        rowccmn87d0.setSzCdTask((String) dynamicEvent[11]);
        rowccmn87d0_array.addROWCCMN87DO(rowccmn87d0);
      }
    }
    return rowccmn87d0_array;
  }

  // Call serviceAuthorizationDAO, CSES24D
  // Retrieves a row from the SvcAuthEventLink table.
  private int findServiceAuthEventLink(int idEvent) throws ServiceException {
    ServiceAuthorization serviceAuthorizationInfo = serviceAuthorizationDAO.findServiceAuthEventLink(idEvent);
    int idSvcAuth;
    if (serviceAuthorizationInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      idSvcAuth = serviceAuthorizationInfo.getIdSvcAuth();
    }
    return idSvcAuth;
  }

  // Calls retrieveServiceList, CLSS24D to retrieve rows from the SvcAuthDetail table.
  private ROWCCON21SOG00_ARRAY retrieveServiceList(int idSvcAuth) throws ServiceException {
    CCON21SI ccon21si = new CCON21SI();
    ccon21si.setUlIdSvcAuth(idSvcAuth);
    CCON21SO ccon21so = retrieveServiceList.retrieveServiceList(ccon21si);
    return ccon21so.getROWCCON21SOG00_ARRAY();
  }

  // Call StageDAO, CCMNF6D that retrieves all the open stages associated to the given ID CASE.
  private int findStageByIdCaseDtStageClose(int idCase) throws ServiceException {
    List<Map> stageInfo = stageDAO.findStageByIdCaseDtStageClose(idCase);
    if (stageInfo == null || stageInfo.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      // There is no structure available in the output object CIN15SO,
      // to set the rows returned from the DAO.
      // for (Iterator<Map> it = stageInfo.iterator(); it.hasNext();) {
      // Map stageMap = it.next();
      // }
    }
    return stageInfo.size();
  }

  private Integer callConsistencyCheck(int idStage, String cdRiskAssmtRiskFind) throws ServiceException {
    Integer messageCode = null;
    boolean bConsistencyCheckFail = false;/* Boolean flags to determine widget state */

    // For each row returned from the DAM call CLSC49D to check
    // for Person Merge data, if the DAM returns a count > 0
    // Merge Indicator flag to true else set the Merge Indicator flag to false.
    // Step One: Retrieve response to the first EA Question (CCMNB4D) passing ID_STAGE and
    // CD_TASK = 'ELG'. Retrieve ID_EVENT to use as input to CINV15D. For all rows
    // which the CD_EA_QUESTION is 'ARC', record the IND_EA_RESPONSE.
    // Call ComplexEventDAO, CCMNB4D
    int idEvent = findIdEventAndCdEventStatus(idStage);
    // Call RetrieveEmergencyAssistance, CINV15D
    // Retrieves full rows from the emregency_assist table.
    ROWCINV11SOG00_ARRAY rowcinv11sogoo_array = retrieveEmergencyAssistance(idEvent, idStage);
    // Step Two: The CD Risk Finding comes the Client
    // Step Three: Retrieve Safety Plan Indicator Pass ID_STAGE to CINV95D.
    // Get IND_CPS_INVST_SAFETY_PLN from CPS_INVST_DETAIL.
    // Call CpsInvstDetailDAO, CINV95D
    String indCpsInvstSafetyPln = findCpsInvstDetailByIdStageOnly(idStage);
    // Step Four: Interpret Results of Step One, Two, and Three
    // If EA is NO and Risk Finding is Risk Indicated or
    // Safety Plan is Checked --> Set off edit message.
    // OR if EA is YES and Risk Finding is NOT Risk Indicated
    // AND Safety Plan is NOT checked --> Set off edit message
    if (rowcinv11sogoo_array != null) {
      for (Enumeration rowcinv11sogooEnum = rowcinv11sogoo_array.enumerateROWCINV11SOG00(); rowcinv11sogooEnum
                                                                                                              .hasMoreElements();) {
        ROWCINV11SOG00 rowcinv11sogoo = (ROWCINV11SOG00) rowcinv11sogooEnum.nextElement();
        if (CodesTables.CELGSTMT_ARC.equals(rowcinv11sogoo.getSzCdEaQuestion())) {
          String indEaResponse = rowcinv11sogoo.getBIndEaResponse();
          if (ArchitectureConstants.Y.equals(indEaResponse)
              && !CodesTables.CCRSKFND_01.equals(cdRiskAssmtRiskFind)
              && ArchitectureConstants.N.equals(indCpsInvstSafetyPln)
              || ArchitectureConstants.N.equals(indEaResponse)
              && (CodesTables.CCRSKFND_01.equals(cdRiskAssmtRiskFind) || ArchitectureConstants.Y
                                                                                                .equals(indCpsInvstSafetyPln))) {
            bConsistencyCheckFail = true;
          }

          if (ArchitectureConstants.N.equals(indEaResponse) && CodesTables.CCRSKFND_04.equals(cdRiskAssmtRiskFind)
              && ArchitectureConstants.N.equals(indCpsInvstSafetyPln)
              || ArchitectureConstants.Y.equals(indCpsInvstSafetyPln)) {
            bConsistencyCheckFail = false;
          }
        }
      }
    }
    if (bConsistencyCheckFail) {
      messageCode = Messages.MSG_EA_NOT_RISK_SAFETY;
    }
    return messageCode;
  }

  // Call RetrieveEmergencyAssistance, CINV15D
  // Retrieves full rows from the emregency_assist table.
  private ROWCINV11SOG00_ARRAY retrieveEmergencyAssistance(int idEvent, int idStage) throws ServiceException {
    ROWCINV11SOG00_ARRAY rowcinv11sogoo_array = null;
    CINV11SI cinv11si = new CINV11SI();
    cinv11si.setUlIdEvent(idEvent);
    cinv11si.setUlIdStage(idStage);
    CINV11SO cinv11so = retrieveEmergencyAssistance.retrieveEmergencyAssistance(cinv11si);
    if (cinv11so != null) {
      rowcinv11sogoo_array = cinv11so.getROWCINV11SOG00_ARRAY();
    }
    return rowcinv11sogoo_array;
  }

  // Call ComplexEventDAO, CCMNB4D
  private int findIdEventAndCdEventStatus(int idStage) {
    int idEvent = 0;
    Map eventInfo = complexEventDAO.findIdEventAndCdEventStatus(idStage, EA_ELIGIBILITY_TASK);
    if (eventInfo != null && !eventInfo.isEmpty()) {
      idEvent = ((Integer) eventInfo.get("idEvent")).intValue();
    }
    return idEvent;
  }

  // Call CpsInvstDetailDAO, CINV95D
  // Retrieves bIndCpsInvstSafetyPln from CPS_INVST_DETAIL
  private String findCpsInvstDetailByIdStageOnly(int idStage) throws ServiceException {
    CpsInvstDetail cpsInvstDetailInfo = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(idStage);
    String indCpsInvstSafetyPln;
    if (cpsInvstDetailInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      indCpsInvstSafetyPln = cpsInvstDetailInfo.getIndCpsInvstSafetyPln();
    }
    return indCpsInvstSafetyPln;
  }

  // Call StagePersonLinkDAO, CLSC18D

  /**
   * Updates/appends usSysNbrMessageCode_ARRAY through a logic that uses the param dCdEditProcess.
   * 
   * @param idStage
   * @param dCdEditProcess
   * @param usSysNbrMessageCode_ARRAY
   * @return List<StagePersonLink>
   * @throws ServiceException
   */
  private List<StagePersonLink> findAllPrincipalsLinkedToStage(int idStage, String dCdEditProcess,
                                                               UsSysNbrMessageCode_ARRAY usSysNbrMessageCode_ARRAY)
                                                                                                                   throws ServiceException {
    boolean bMaritalEthnicity = false;
    boolean bDateRsnDth = false;
    boolean bUnknownName;
    List<StagePersonLink> stagePersonLinkInfo = stagePersonLinkDAO
                                                                  .findAllPrincipalsLinkedToStage(
                                                                                                  idStage,
                                                                                                  CodesTables.CPRSNTYP_PRN);
    if (stagePersonLinkInfo == null || stagePersonLinkInfo.size() <= 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      for (Iterator<StagePersonLink> it = stagePersonLinkInfo.iterator(); it.hasNext() && !bMaritalEthnicity;) {
        StagePersonLink stagePersonLink = it.next();
        bUnknownName = false; // Reset bUnknownName for each person in the loop
        // Check to see if the name is unknown. Unknown names are defined as system
        // generated unknown names. System generated unknown names populate the
        // full name of a person with Unknown # (being either a number from
        // 1-9 or a person id). The first and last name fields will be left blank.
        // Therefore, if the first and last names are blank, then
        // the name is system generated, so set the unknown name flag to true.
        if ((stagePersonLink.getPerson().getNmPersonFirst() == null)
            && (stagePersonLink.getPerson().getNmPersonLast() == null)) {
          bUnknownName = true;
        }
        // check to see if the marital status field is already populated; also,
        // if the name is not unknown, then set the edit flag
        if (((stagePersonLink.getPerson().getCdPersonMaritalStatus() == null) || (stagePersonLink
                                                                                                 .getPerson()
                                                                                                 .getCdPersonEthnicGroup() == null))
            && (!bUnknownName)) {
          bMaritalEthnicity = true;
        }
      }
      // Check for the condition to determine if the date of death field is not null and
      // the reason for death field is null. Populate output object.
      if (dCdEditProcess != null && dCdEditProcess.length() > DATE_RSN_DTH_EDIT
          && dCdEditProcess.charAt(DATE_RSN_DTH_EDIT) == EDIT_YES) {
        for (Iterator<StagePersonLink> it = stagePersonLinkInfo.iterator(); it.hasNext() && !bDateRsnDth;) {
          StagePersonLink stagePersonLink = it.next();
          if (!DateHelper.isNull(stagePersonLink.getPerson().getDtPersonDeath())
              && stagePersonLink.getPerson().getCdPersonDeath() == null) {
            bDateRsnDth = true;
          }
        }
      }
    }
    // Post Marital Status & Ethnicity Warning
    // If Marital Status And Ethnicity is not recorded, add an Edit to the Error List when
    // doing a SAve & Submit of the CPS INV Conclusion
    if (bMaritalEthnicity) {
      usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_MAR_STAT_EDIT);
    }
    if (bDateRsnDth) {
      usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_DATE_RSN_DTH_EDIT);
    }
    return stagePersonLinkInfo;
  }

  // Call AllegationDAO, CSES97D
  // This DAM now checks to see if the person returned is a victim in an allegation
  // with allegation severity of fatal. In order for allegation severity to be
  // enabled for the user to set it to FATAL, disposition would have to be set to RTB.
  // So the requirement for SIR 14996 is met if this one is met. In cases where the
  // victim the DAM is searching on has a death code of A/N, if the DAM does not find
  // allegation severity of FATAL, a message is set for the user to fix the
  // inconsistency. In cases where the victim the DAM is searching on has a death code
  // that is NOT A/N, if the DAM DOES find allegation severity of FATAL, a message
  // is set for the user to fix the inconsistency.

  /**
   * Updates/appends usSysNbrMessageCode_ARRAY through a logic that uses the param cdPersonDeath.
   * 
   * @param idStage
   * @param cdPersonDeath
   * @param idPerson
   * @param bRsnDthEdit
   * @param usSysNbrMessageCode_ARRAY
   * @return boolean
   */
  private boolean findAllegationByIdPersonAndIdStage(int idStage, String cdPersonDeath, int idPerson,
                                                     boolean bRsnDthEdit,
                                                     UsSysNbrMessageCode_ARRAY usSysNbrMessageCode_ARRAY) {
    Allegation allegationInfo = allegationDAO.findAllegationByIdPersonAndIdStage(idPerson, idStage);
    if (allegationInfo == null) {
      if ((CodesTables.CRSNFDTH_ABN.equals(cdPersonDeath)) || (CodesTables.CRSNFDTH_ABO.equals(cdPersonDeath))
          || (CodesTables.CRSNFDTH_ABP.equals(cdPersonDeath))) {
        bRsnDthEdit = true;
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_RSN_DTH_EDIT);
      }
    } else {
      if ((!CodesTables.CRSNFDTH_ABN.equals(cdPersonDeath)) && (!CodesTables.CRSNFDTH_ABO.equals(cdPersonDeath))
          && (!CodesTables.CRSNFDTH_ABP.equals(cdPersonDeath))) {
        bRsnDthEdit = true;
        usSysNbrMessageCode_ARRAY.addUsSysNbrMessageCode(Messages.MSG_INV_RSN_DTH_EDIT);
      }
    }
    return bRsnDthEdit;
  }

  private boolean findAllegationsByIdStage(int idStage) {
    List<Map> allegationList = allegationDAO.findAllegationsByIdStage(idStage);
    for (Iterator it = allegationList.iterator(); it.hasNext();) {
      Map allegation = (Map) it.next();
      String disposition = (String) allegation.get("cdAllegDisposition");
      if (disposition == null || "".equals(disposition)) {
        return true;
      }
    }
    return false;
  }

  /**
   * The hasAllegationsUnsubstantiated method tests to make sure that all allegations are unsubstantiated. Added as part
   * of STGAP00009080 (MR-005)
   * 
   * @param idStage -
   *                Stage ID of the Investigation
   * @return boolean
   */
  private boolean hasAllegationsUnsubstantiated(int idStage) {
    List<Map> allegationList = allegationDAO.findAllegationsByIdStage(idStage);
    for (Iterator<Map> it = allegationList.iterator(); it.hasNext();) {
      Map allegation = it.next();
      String disposition = (String) allegation.get("cdAllegDisposition");
      if (!CodesTables.CDISPSTN_UNS.equals(disposition)) {
        return false;
      }
    }
    return true;
  }

  /**
   * The hasOtherOpenStagesInCase method tests to make sure there are no other open stages. Added as part of
   * STGAP00009080 (MR-005)
   * 
   * @param idStage -
   *                Stage ID of the Investigation
   * @return boolean
   */
  private boolean hasOtherOpenStagesInCase(int idCase, int idStage) {

    boolean openStages = true;
    List<Stage> stageList = stageDAO.findOtherOpenStagesInCase(idCase, idStage);
    if (stageList == null || stageList.isEmpty()) {
      openStages = false;
    }
    return openStages;
  }

  /**
   * The hasOpenSafetyResourcePlacements method tests to see if there are open Safety
   * Resource placements.
   * 
   * @param idStage -
   *                Stage ID of the Investigation
   * @return boolean
   */
  private boolean hasOpenSafetyResourcePlacements(int idStage) {

    boolean openPlacements = true;
    List<SafetyResourceChild> safetyResourceList = safetyResourceChildDAO.findOpenSafetyResourcesForStage(idStage);
    if (safetyResourceList == null || safetyResourceList.isEmpty()) {
      openPlacements = false;
    }
    return openPlacements;
  }

  @SuppressWarnings( { "unused", "unchecked" })
  private void checkStageReasonClosedSub(int idStage) {
    String cdStagePersType = "PRN";
    StagePersonLink stagePersonLink = null;
    int numChildren = 0;
    String removalEventTaskCode = "2350";
    Long removalEventCount = eventDAO.findCountEventByIdStageCdTask(idStage, removalEventTaskCode);
    int intRemovalEventCount = removalEventCount != null ? removalEventCount.intValue() : 0;
    List<StagePersonLink> stagePersonLinkList = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(idStage,
                                                                                                  cdStagePersType);
    Iterator it = stagePersonLinkList.iterator();
    while (it.hasNext()) {
      stagePersonLink = (StagePersonLink) it.next();
      Date dtBirthPrincipal = stagePersonLink.getPerson().getDtPersonBirth();
      String relationshipPrn = stagePersonLink.getCdStagePersRelInt();
      int age = -1;
      if (dtBirthPrincipal != null) {
        age = DateHelper.getAge(dtBirthPrincipal);
      }
      if (age >= 0 && age < 18) {
        numChildren++;
      }
    }
    if (!(numChildren == 0 && intRemovalEventCount == 0) && (numChildren == intRemovalEventCount)) {
      throw new ServiceException(Messages.MSG_RISK_FINDING_SUB);
    }
  }

  /**
   * 
   * This method will check if there are any Child Death/Near Fatality/Serious Injury 
   * report events that are not approved
   * @param idStage
   * @return boolean
   */
  private boolean existsUnapprovedCNSByIdStage(int idStage) {
    List<String> cdEventStatuses = new ArrayList<String>();
    cdEventStatuses.add(CodesTables.CEVTSTAT_PROC);
    cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);
    cdEventStatuses.add(CodesTables.CEVTSTAT_COMP);

    long nbrRows = eventDAO.countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses(idStage, CodesTables.CEVNTTYP_CNS,
                                                                                    cdEventStatuses);

    if (nbrRows <= 0) {
      // All CNS event are approved or none exists
      return false;
    }

    return true;
  }

}
