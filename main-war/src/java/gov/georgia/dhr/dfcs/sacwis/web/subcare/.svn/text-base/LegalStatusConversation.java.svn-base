package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.CourtProcess;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB46SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.types.Date;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import org.hibernate.util.StringHelper;

/**
 * This is the Conversation class used for Legal Status
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/02/08  SWR       STGAP00004587 - Added update mode for save.  Also informational
 *                      message on display for modify mode.
 *  06/30/09 bgehlot    STGAP00014336: MR-51  changes
 *  04/14/10 arege      SMS#49744  unable to delete invalid court order, custody expiration dates and Petition/Motion Due Date
 *  05/10/10 arege      SMS#49744 Modified code as per peer review
 *  08/12/10 hjbaptiste SMS#65423: MR-71 Changes  
 *  08/16/10 hjbaptiste SMS#66247: Fixed Maltreatment in Care confirmation message impeding Custody auto-navigation to Legal Status
 *  08/18/10 hjbaptiste SMS#65423: Set Task Code of Custody from which ever stage that it was created instead of hard-coding INV Task Code
 *                      as a Custody can be created from multiple stages
 *  08/18/10 hjbaptiste SMS#70287: Removed Short Term Emergency Care from the list of excluded options when creating a legal status from custody
 *  09/30/10 hnguyen    SMS#70287: Added Short Term Emergency Care to the list of excluded options 
 *                      when creating a legal status from a non-FCC, except when creating one via Custody       
 *  11/13/10 htvo		SMS#81140 - MR-074 AFCARS: handled new error messages from Save
 *  1/5/11   htvo       SMS#81140: AFCARS: add new not-in-DFCS LS to the exclusion list when LS created from Custody page navigation
 *  3/17/11  htvo       SMS#97845 MR-074-2 AFCARS: populate child previously reported to AFCARS indicator in saveSI, catch AA validation errors from Save
 * </pre>

 * @author Modeste Ngom, Sept. 5, 2006 <p/>
 */
@SuppressWarnings("serial")
public class LegalStatusConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "LegalStatusConversation";

  public static final String STATUS_COMPLETE = "COMP";

  public static final String SUB_LEGAL_STAT_EVENT_TYPE = "LES";

  public static final int STAGE_CLOSURE = 1;

  public static final String EVENT_STATUS_PENDING = "PEND";

  public static final String DISPLAY_PAGE = "/subcare/LegalStatus/displayLegalStatus";

  public static final String CLEGSTAT_PMC_RTS_TERM_ALL = "040";

  public static final String CLEGSTAT_PMC_RTS_TERM = "030";

  public static final String CLEGSTAT_PMC_RTS_TERM_FATHER = "050";

  public static final String CLEGSTAT_PMC_RTS_TERM_MOTHER = "070";

  public static final String CLEGSTAT_CC_AND_C = "010";

  public static final String CLEGSTAT_OTHER_LEG_BASIS = "080";

  public static final String CLEGSTAT_TMC = "020";

  public static final String CLEGSTAT_CVS_NOT_OBTAINED = "150";

  public static final String CSTAGE_SUB = "SUB";

  public static final String CSTAGE_ADO = "ADO";
  
  public static final String CSTAGE_PFC = "PFC";
    
  public static final String CSTAGE_PAD = "PAD";
  
  public static final String SUB_CD_TASK = "3050";
    

  private CourtProcess courtprocess;

  public void setCourtprocess(CourtProcess courtProcess) {
    this.courtprocess = courtProcess;
  }

  /**
   * This method will retrieve data from CSUB45S to use to display the page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayLegalStatus_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayLegalStatus_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      // event list sets page mode
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      boolean creatingFromCustody = false;
      Date custodyDate = null;
      int idSUBStage = 0;
      String custodyCdTask = "";
      // Getting previous Url to indicate if we're coming from Custody. If the user receives the warning message
      // for Maltreatment in Care, the previous URL is different then if the page is saved without any message
      String formValidationPrevUrl = (String) request.getParameter("FormValidationPrevUrl");
      if ("/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemoval".equals(formValidationPrevUrl) ||
                      "/subcare/CnsrvtrshpRemoval/save".equals(formValidationPrevUrl)) {
        creatingFromCustody = true;
        custodyDate = (Date) state.getAttribute("custodyDate", request);
        idSUBStage = ((Integer) state.getAttribute("idSUBStage", request) != null) ? (Integer) state.getAttribute("idSUBStage", request) : 0;
        custodyCdTask = (String) state.getAttribute("custodyCdTask", request);
      }
      // MR-71 Remove all the items associated with creating a legal status from the Custody page from state
      state.removeAttribute("excludeLegalStatusTypes", request);
      state.removeAttribute("custodyDate", request); 
      state.removeAttribute("idSUBStage", request);
      state.removeAttribute("custodyCdTask", request);
      state.removeAttribute("creatingFromCustody", request);
      CSUB45SO csub45so;
      
      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
      // clear state
      if (state.getAttribute("CSUB45SO", request) == null
          && request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) == null) {
        state.removeAllAttributes(request);
      }
      
      // MR-071 Filter out all 'Not in DFCS Custody' Legal Statuses when creating one from Custody
      List<String> excludeLegalStatusTypes = new ArrayList<String>();
      if (creatingFromCustody) {
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_CTD); // Committed To DJJ
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_ILP); // ILP Aftercare
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NAF); // Not In DFCS Custody - Adoption Finalized
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NCT); // Not In DFCS Custody - Child Turned 18 (No ILP)
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NCD); // Not In DFCS Custody - Child Death
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NCO); // Not In DFCS Custody - Custody To Other
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NTT); // Not In DFCS Custody - Custody Transferred To Tribe
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NCE); // Not In DFCS Custody - Emancipated
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NGP); // Not In DFCS Custody - Guardianship
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NPC); // Not In DFCS Custody - Parental Custody
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NPR); // Not In DFCS Custody - Custody To Relative
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NCS); // Not In DFCS Custody - Custody With Other State
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NDJ); // No Longer Committed to DJJ
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_DJA); // DJJ Aftercare
        // SMS#81140: AFCARS: new not-in-DFCS LS 
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_NOT); // Not In DFCS custody - Out of State Child Adopted by Georgia Family
      } 
      // MR-071 Filter out all 'In DFCS Custody' Legal Statuses when creating one in any non-FCC(SUB) stage
      else if (!CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))) {
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_PCT); // Permanent Court
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_PVL); // Permanent Voluntary
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_TCT); // Temporary Court
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_TVL); // Temporary Voluntary
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_JCP); // Joint Commitment With DJJ - Permanent Court
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_JCT); // Joint Commitment With DJJ - Temporary Court
        excludeLegalStatusTypes.add(CodesTables.CLEGSTAT_STE); // Short Term Emergency Care
      }
      state.setAttribute("excludeLegalStatusTypes", excludeLegalStatusTypes, request);
      
      PageMode.setPageMode(pageMode, request);

      // MR-71: If creating Legal Status from Custody, we don't need to go to the person list since the Legal Status
      // will be saved in the child's FCC(SUB) stage
      if (creatingFromCustody) {
        PageMode.setPageMode(PageModeConstants.NEW, request);
        GlobalData.setUlIdEvent(0, request);
        state.setAttribute("custodyDate", custodyDate, request); 
        state.setAttribute("idSUBStage", idSUBStage, request);
        state.setAttribute("custodyCdTask", custodyCdTask, request);
        state.setAttribute("creatingFromCustody", creatingFromCustody, request);
        UserProfile user = UserProfileHelper.getUserProfile(request);
        ArchInputStruct input = new ArchInputStruct();
        CSUB45SI csub45si = new CSUB45SI();
        input.setSzUserId(user.getUserLogonID());
        csub45si.setArchInputStruct(input);
        csub45si.setUlIdEvent(GlobalData.getUlIdEvent(request));
        csub45si.setUlIdStage(idSUBStage);
        csub45si.setCSysIndDamCalled(PageMode.getPageMode(request));
        csub45si.setSzCdStage(CodesTables.CSTAGES_SUB);
        //STGAP00014336: Get case id
        csub45si.setUlIdCase(GlobalData.getUlIdCase(request));
        csub45si.setUlIdStage(idSUBStage);
        csub45so = courtprocess.retrieveLegalService(csub45si);
        csub45so.getROWCSUB45SOG01().setDtDtLegalStatStatusDt(custodyDate);
        state.setAttribute("CSUB45SO", csub45so, request);
        // SIR 17395 - add person name to GlobalData so that InfoBox.jsp
        // can display
        GlobalData.setSzNmPersonFull(csub45so.getSzNmPersonFull(), request);
      }
      // if this is not a new or new using FC or ADO legal status, then
      // must call person list
      // if person list hasn't been called already
      else if (!(GlobalData.getSzCdStage(request).equals(CSTAGE_SUB) || GlobalData.getSzCdStage(request).equals(CSTAGE_ADO) || GlobalData.getSzCdStage(request).equals(CSTAGE_PFC) || GlobalData.getSzCdStage(request).equals(CSTAGE_PAD))
          && (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)
              || PageMode.getPageMode(request).equals(PageModeConstants.NEW) || PageMode
                                                                                        .getPageMode(request)
                                                                                        .equals(
                                                                                                PersonListConversation.PAGE_MODE_PRINC_ONLY))) {
        if (request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) == null) {
          // save pagemode before going to person list
          state.setAttribute("previouspagemode", PageMode.getPageMode(request), request);
          personListPullBackInfo.setDestinationUrl("/subcare/LegalStatus/displayLegalStatus");
          PageMode.setPageMode(PersonListConversation.PAGE_MODE_PRINC_ONLY, request);
          request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPullBackInfo);
          request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
          forward(PersonListConversation.DISPLAY_PAGE, request, context.getResponse());
          // SIR 22985 - Put a return here to ensure that the page
          // isn't continuing to process
          // even though the forward has been done.
          return;
        } else {
          // retrieve previous pagemode after returning from person
          // list
          String pagemode = (String) state.getAttribute("previouspagemode", request);
          PageMode.setPageMode(pagemode, request);
          personListPullBackInfo = (PersonListPullBackInfo) request
                                                                   .getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);
          int ulIdPerson = 0;
          // SIR 17395 - add person name to GlobalData from person
          // list pullback,
          // so that InfoBox.jsp can display
          String nmPerson = "";
          ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
          if (rowcinv01sog00 != null) {
            ulIdPerson = rowcinv01sog00.getUlIdPerson();
            nmPerson = rowcinv01sog00.getSzNmPersonFull();
          }
          state.setAttribute("ulIdPerson", String.valueOf(ulIdPerson), request);
          GlobalData.setSzNmPersonFull(nmPerson, request);
          // call retrieve service after selecting person from person
          // list
          CSUB45SI csub45si = populateCSUB45SI_Retrieve(context);
          csub45so = courtprocess.retrieveLegalService(csub45si);
          state.setAttribute("CSUB45SO", csub45so, request);
        }
      } else {
        // call retrieve service - person list call not needed for this
        // stage
        CSUB45SI csub45si = populateCSUB45SI_Retrieve(context);

        csub45so = courtprocess.retrieveLegalService(csub45si);
        state.setAttribute("CSUB45SO", csub45so, request);
        // SIR 17395 - add person name to GlobalData so that InfoBox.jsp
        // can display
        GlobalData.setSzNmPersonFull(csub45so.getSzNmPersonFull(), request);
      }
      if (GlobalData.getUlIdEvent(request) != 0) {
        // if a Legal Status ToDo has been accessed, need to reset mode
        // to New
        if ("NEW".equals(csub45so.getROWCSUB45SOG00().getSzCdEventStatus_ARRAY().getSzCdEventStatus(0))) {
          if (PageMode.getPageMode(request).equals(PageModeConstants.MODIFY)) {
            PageMode.setPageMode(PageModeConstants.NEW, request);
          }
        }
        // if pagemode is new using, then the event id should be reset
        // to 0
        if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
          GlobalData.setUlIdEvent(0, request);
        }
      }

      // SIR 22768 - Prevent modification of LS type w/o Legal Status
      // security
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      boolean haveLegalStatSecurity = userProfile.hasRight(UserProfile.SEC_MNTN_LEGAL_STAT);

      // SWR 06/02/08 STGAP00004587 - Modified code to show Error Message when modifying Legal Status
      if (pageMode.equals(PageModeConstants.MODIFY) && haveLegalStatSecurity) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_LEGAL_STATUS_CHANGE_WARN), DISPLAY_PAGE,
                                request);
      }

    } catch (ServiceException we) {
      handleServiceError(we, context);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will save a legal status record.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void saveLegalStatus_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveLegalStatus_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CSUB46SI csub46si = populateCSUB46SI_AUD(context, ServiceConstants.REQ_FUNC_CD_UPDATE);
      courtprocess.saveLegalService(csub46si);
      
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      state.removeAttribute("CSUB45SO", request);
      state.removeAttribute("previouspagemode", request);
      state.removeAttribute("ulIdPerson", request);
      state.removeAttribute("nmPersonFull", request);
      
      // MR-71: If Legal Status was created from Custody, return to Custody List page after saving
      if ((Boolean) (ContextHelper.getBooleanSafe(context, "hdnCameFromCustody"))) {
        String custodyCdTask = (String) ContextHelper.getStringSafe(context, "hdnCustodyCdTask");
        String forwardUrl = "/workload/EventSearch/displayEventList?taskCD=" + custodyCdTask;
        forward(forwardUrl, request, context.getResponse());
      }
    } catch (ServiceException we) {
      handleServiceError(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will populate the input data for service CSUB45SI.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  private CSUB45SI populateCSUB45SI_Retrieve(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB45I_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    ArchInputStruct input = new ArchInputStruct();
    CSUB45SI csub45si = new CSUB45SI();
    input.setSzUserId(user.getUserLogonID());
    csub45si.setArchInputStruct(input);
    csub45si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    csub45si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub45si.setCSysIndDamCalled(PageMode.getPageMode(request));
    csub45si.setSzCdStage(GlobalData.getSzCdStage(request));
    //STGAP00014336: Get case id
    csub45si.setUlIdCase(GlobalData.getUlIdCase(request));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return csub45si;
  }

  /**
   * This method will populate the service input object CSUB46SI
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  private CSUB46SI populateCSUB46SI_AUD(GrndsExchangeContext context, String action) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB46SI_AUD()");
    performanceTrace.enterScope();
    // Allocate the structures
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    CSUB45SO csub45so = (CSUB45SO) state.getAttribute("CSUB45SO", request);
    StringBuffer description = new StringBuffer();
  
    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCSUB46SIG00 rowcsub46sig00 = new ROWCSUB46SIG00();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    CSUB46SI csub46si = new CSUB46SI();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    SzCdEventStatus_ARRAY rowArray = new SzCdEventStatus_ARRAY();

    // if New Using, need to set id_event to 0
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
      GlobalData.setUlIdEvent(0, request);
    }

    // set arch input function to add

    if (GlobalData.getUlIdEvent(request) == 0) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else if (GlobalData.getUlIdEvent(request) != 0
               && (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING) || PageMode
                                                                                                .getPageMode(request)
                                                                                                .equals(
                                                                                                        PageModeConstants.NEW))) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      // SWR 06/02/08 STGAP00004587 Added update function
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    input.setSzUserId(userProfile.getUserLogonID());

    if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
      rowcsub46sig00.setUlIdLegalStatEvent(csub45so.getROWCSUB45SOG01().getUlIdLegalStatEvent());
    }

    // populate legal status information in rowcsub46sig00
    rowcsub46sig00.setTsLastUpdate(csub45so.getROWCSUB45SOG01().getTsLastUpdate());
    rowcsub46sig00.setSzCdLegalStatCnty(ContextHelper.getStringSafe(context, "selCdLegalStatCnty"));
    rowcsub46sig00.setSzCdLegalStatStatus(ContextHelper.getStringSafe(context, "selLegalStat"));
    rowcsub46sig00.setDtDtLegalStatStatusDt(ContextHelper.getCastorDateSafe(context, "txtDtEffLegalStat"));
    rowcsub46sig00.setDtDtLegalStatPMDueDt(ContextHelper.getCastorDateSafe(context, "txtDtPtMtDue"));
    rowcsub46sig00.setDtDtLegalStatCrtOrdExpDt(ContextHelper.getCastorDateSafe(context, "txtDtCtOrExp"));
    rowcsub46sig00.setDtDtLegalStatCustExpDt(ContextHelper.getCastorDateSafe(context, "txtDtCustodyExp"));
    rowcsub46sig00.setBIndLegalStatRisk(ContextHelper.getStringSafe(context, "rbLegalRisk"));
    // person is either from csub45 or from person list pullback
    int ulIdPerson;
    if (state.getAttribute("ulIdPerson", request) == null) {
      ulIdPerson = csub45so.getUlIdPerson();
    } else {
      ulIdPerson = Integer.parseInt((String) state.getAttribute("ulIdPerson", request));
    }
    rowcsub46sig00.setUlIdPerson(ulIdPerson);
    csub46si.setArchInputStruct(input);
    csub46si.setROWCSUB46SIG00(rowcsub46sig00);
    csub46si.setROWCCMN01UIG00(rowccmn01uig00);
    csub46si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub46si.setUlIdCase(GlobalData.getUlIdCase(request));
    // event status 0 is for legal status, 1 is for stage closure event
    rowArray.addSzCdEventStatus(0, "");
    rowArray.addSzCdEventStatus(1, csub45so.getROWCSUB45SOG00().getSzCdEventStatus_ARRAY().getSzCdEventStatus(1));
    csub46si.setSzCdEventStatus_ARRAY(rowArray);
    // only set the person that creates the todo if legal status is rights
    // terminated all
    csub46si.setUlSysIdTodoCfPersCrea(0);
    if (ContextHelper.getStringSafe(context, "selLegalStat").equals(CLEGSTAT_PMC_RTS_TERM_ALL)) {
      csub46si.setUlSysIdTodoCfPersCrea(userProfile.getUserID());
    }
    
    // SWR 06/03/08 STGAP00004587 set IndDateModified to true ("Y") if Legal Status Effective Date has been changed.
    // This will be used
    // later on in the service to make sure there isn't an existing Legal Status on the same date.
    String dateChanged = ArchitectureConstants.N;
    if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)
        && !PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
      dateChanged = ArchitectureConstants.N;
      if (!csub45so.getROWCSUB45SOG01().getDtDtLegalStatStatusDt()
                   .equals(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtEffLegalStat")))) {
        dateChanged = ArchitectureConstants.Y;
      }
    }
    
    csub46si.setIndDateModified( dateChanged );
    csub46si.setBIndPrevAfcars(ContextHelper.getStringSafe(context, "hdnBIndPrevAfcars")); // SMS#97845 MR-074-2 AFCARS
    if (ContextHelper.getStringSafe(context, "selLegalStat").equals(CLEGSTAT_PMC_RTS_TERM)
        || ContextHelper.getStringSafe(context, "selLegalStat").equals(CLEGSTAT_PMC_RTS_TERM_ALL)
        || ContextHelper.getStringSafe(context, "selLegalStat").equals(CLEGSTAT_PMC_RTS_TERM_MOTHER)
        || ContextHelper.getStringSafe(context, "selLegalStat").equals(CLEGSTAT_PMC_RTS_TERM_FATHER)) {
      csub46si.setCIndCsupSend(ArchitectureConstants.Y);
    } else {
      csub46si.setCIndCsupSend(ArchitectureConstants.N);
    }

    // populate Event Information in rowccmn01uig00
    rowccmn01uig00.setSzCdTask(GlobalData.getSzCdTask(request));
    rowccmn01uig00.setTsLastUpdate(csub45so.getROWCSUB45SOG00().getTsLastUpdate());
    // SIR 17233 - event status should remain PEND, if we're in Approver
    // Mode
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_PENDING);
    } // end if
    else {
      rowccmn01uig00.setSzCdEventStatus(STATUS_COMPLETE);
    } // end else
    rowccmn01uig00.setSzCdEventType(SUB_LEGAL_STAT_EVENT_TYPE);
    // if this is a new or new using legal status, the dtEventOccurred
    // should be the system date
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)
        || PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    } else {
      rowccmn01uig00.setDtDtEventOccurred(csub45so.getROWCSUB45SOG00().getDtDtEventOccurred());

    }
    rowccmn01uig00.setUlIdEvent(GlobalData.getUlIdEvent(request));
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));
    // MR-71 If saving Legal Status from Custody, save the Legal Status in the child's FCC stage
    boolean comingFromCustody = (Boolean) ContextHelper.getBooleanSafe(context, "hdnCreatingFromCustody");
    if (comingFromCustody) {
      int idSUBStage = (Integer) ContextHelper.getIntSafe(context, "hdnIdSUBStage");
      if (idSUBStage > 0) {
        csub46si.setUlIdStage(idSUBStage);
        rowccmn01uig00.setUlIdStage(idSUBStage);
        rowccmn01uig00.setSzCdTask(SUB_CD_TASK);
      }
    }
    
    rowccmn01uig00.setUlIdPerson(userProfile.getUserID());
    // txtEventDescription is Legal Status + 1 space + Legal Status
    // Effective Date
    description.append(Lookup.simpleDecodeSafe("CLEGSTAT", ContextHelper.getStringSafe(context, "selLegalStat")));
    description.append(" ");
    description.append(FormattingHelper.formatDate(ContextHelper.getCastorDateSafe(context, "txtDtEffLegalStat")));
    rowccmn01uig00.setSzTxtEventDescr(description.toString());

    if (GlobalData.getUlIdEvent(request) == 0
        || (GlobalData.getUlIdEvent(request) != 0 && (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING) || PageMode
                                                                                                                                   .getPageMode(
                                                                                                                                                request)
                                                                                                                                   .equals(
                                                                                                                                           PageModeConstants.NEW)))) {
      rowccmn01uig01.setUlIdPerson(ulIdPerson);
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    }

    // set the flag indicating approver mode
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    // Add the struct to the array
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    // Set the array into the parent struct
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return csub46si;
  }

  /**
   * This method will handle errors returned from the services.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  private void handleServiceError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage;
    this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
    int errorCode = we.getErrorCode();
    switch (errorCode) {
    // SMS#87845 MR-074-2 AFCARS: adoption assistance validation for Adoption Finalized
    case Messages.MSG_LEG_STAT_ADO_APP_PEND_ERR: // PEND AA application exists (any status, for any stage)
    case Messages.MSG_LEG_STAT_ADO_APP_APRV_ERR: // APRV monthly AA application with special needs determination in ADO not exists (approved/deferred)
    case Messages.MSG_LEG_STAT_ADO_APP_APRV_ERR_NI : // APRV monthly AA application with special needs determination in PAD not exists (approved/deferred/denied)
    case Messages.MSG_LEG_STAT_ADO_APP_AGMT_ERR: // ADO + incident PAD: no active AA agreement linked to APRV monthly AA application (w/ or w/o special needs determination)
    case Messages.MSG_LEG_STAT_ADO_APP_AGMT_COMP_ERR_NI: // non-incident PAD: active AA agreement not linked to APRV monthly app
    case Messages.MSG_LEG_STAT_ADO_APP_APRV_AGMT_ERR_NI: // APRV monthly app exists but no COMP AG linked
      setErrorMessage(we.getMessage(), DISPLAY_PAGE, request);
      break;
    // MR-074 AFCARS: new validation messages for Adoption Finalized and Permanent Custody
    case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), DISPLAY_PAGE, request);
        break;
    case Messages.MSG_CHILD_WAS_DISCHARGED_ERR:
    case Messages.MSG_DISCHARGE_BEFORE_REMOVAL_ERR:
    case Messages.MSG_DUP_NOT_IN_DFCS_ERR:
    case Messages.MSG_MISSING_PARENT_TPR:
    case Messages.MSG_LEG_STAT_EFF_BEFORE_TPR_VS_DOD_ERR:   	
    case Messages.MSG_LEG_STAT_EFF_BEFORE_DOB_ERR:   	
    	errorMessage = MessageLookup.getMessageByNumber(errorCode);
    	setErrorMessage(errorMessage, DISPLAY_PAGE, request);
    	break; // end MR-074 AFCARS: new validation messages
    case Messages.MSG_CHD_FRST_TERM_LEG_STAT:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CHD_FRST_TERM_LEG_STAT);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.SQL_NOT_FOUND:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_DETAIL_DELETED:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DETAIL_DELETED);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_DUP_LEG_STAT_DATE:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DUP_LEG_STAT_DATE);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_DUP_TERM_LEG_STAT:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DUP_TERM_LEG_STAT);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_LEG_CSRVT_OF_PER_PROH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_LEG_CSRVT_OF_PER_PROH);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_SUB_SUBC_STAGE_EXISTS:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SUB_SUBC_STAGE_EXISTS);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_LGL_STAT_CAUSE_NBR_INVALID:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_LGL_STAT_CAUSE_NBR_INVALID);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_NEED_CAUSE_COURT_NBR:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NEED_CAUSE_COURT_NBR);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_NO_LS_AFTER_STG_CLOSE:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_LS_AFTER_STG_CLOSE);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_SYS_MULT_INST:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    case Messages.MSG_SYS_STAGE_CLOSED:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
      setErrorMessage(errorMessage, DISPLAY_PAGE, request);
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      //-- undo presentation branch since these exceptions will be handled by architecture
      //-- and forwarded to /error/MessageDisplay/messageDisplay for user-friendly message
      //-- if appropriate
      setPresentationBranch(null, context);
      processSevereException(context, we);
      break;
    }
  }
}
