package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveFosterCareParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveFosterCareParticipant;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class FosterCareParticipantConversation extends BaseHiddenFieldStateConversation {

  public static final String FCP_INFORMATION = "casemgmt/FosterCareParticipant/FosterCareParticipantConversation";

  public static final String PARTICIPANT_DETAIL_PAGE_MODE = "participantDetailPageMode";

  private static final String TRUE = "true";

  public static final String APPRV_DATE = "txtApprvDt";

  public static final String PERSON_ID = "hdnPersonId";

  public static final String PARTICIPANT_NAME = "txtParticipantName";

  public static final String PERSON_NOT_APPRV = "txtPersonNotApprv";

  public static final String RELATIONSHIP_INTEREST = "txtRelationshipInterest";

  public static final String PARTICIPANT_TYPE = "selParticipantType";

  public static final String IND_PERSON_APPRV = "scrIndPrsnApprv";

  public static final String SIGNED_CPY_DT = "txtSignedCpyDt";

  public static final String PARTICIPANT_DATE = "txtPartDt";

  public static final String ID_EVENT = "hdnIdEvent";

  public static final String ID_PLAN_PART = "hdnPlanPart";

  public static final String STAFF = "DFCS";

  private SaveFosterCareParticipant saveFosterCareParticipant;

  private RetrieveFosterCareParticipant retrieveFosterCareParticipant;

  public void setSaveFosterCareParticipant(SaveFosterCareParticipant saveFosterCareParticipant) {
    this.saveFosterCareParticipant = saveFosterCareParticipant;
  }

  public void setRetrieveFosterCareParticipant(RetrieveFosterCareParticipant retrieveFosterCareParticipant) {
    this.retrieveFosterCareParticipant = retrieveFosterCareParticipant;
  }

  /**
   * Displays the page when a user is not in add mode.
   * 
   * @param context
   */
  public void displayFosterCareParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayFosterCareParticipant_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    FosterCarePartBean fcPartBean = new FosterCarePartBean();
    String isAdd = "";
    int selectedParticipantId = ContextHelper.getIntSafe(request, "selectedParticipantId");
    Iterator iter = null;
    Boolean rights = hasStageAccessRights(context);
    if (!rights) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }
    try {
      if (selectedParticipantId > 0) {
        FosterCareParticipantRetrieveSO fosterCareList = (FosterCareParticipantRetrieveSO) state.getAttribute( "fosterCareList",request);
        if (fosterCareList != null) {
          if (request.getParameter("isAddFCPart") != null) {
            isAdd = (String) request.getParameter("isAddFCPart");
            if (!(TRUE.equals(isAdd))) {
              iter = fosterCareList.getFosterCarePartList().iterator();
              while (iter.hasNext()) {
                fcPartBean = (FosterCarePartBean) iter.next();
                if (fcPartBean.getIdPlanPart() == selectedParticipantId)
                  break;
              }
            } else {
              fcPartBean.setUlIdEvent(ContextHelper.getIntSafe(request, "hdnIdEvent"));
              state.removeAllAttributes(request);
            }
          }
        }
      } else {
        // Update the participant object in state with the new values received
        // from the pullback. (This will ensure that 'Participant Type' and the
        // date field values will be preserved.)
        FosterCarePartBean participantFromState = (FosterCarePartBean) state.getAttribute("participant", request);
        fcPartBean = participantFromState;

        // If the user performed a Staff Search, get the object returned by
        // Staff Search containing the selected staff person's info.
        if (request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) != null) {
          PersonListPullBackInfo person = (PersonListPullBackInfo) request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);
          fcPartBean.setSzNmPart(person.getPersonListRow().getSzNmPersonFull());
          fcPartBean.setIdPerson(person.getPersonListRow().getUlIdPerson());
          PageMode.setPageMode(PageModeConstants.EDIT, request);
          String relationshipInterest = Lookup.simpleDecodeSafe(CodesTables.CRPTRINT, person.getPersonListRow().getSzCdStagePersRelInt());
          fcPartBean.setSzCdRelInt(relationshipInterest);
        }
      } // end if (selectedParticipantId > 0)

      state.setAttribute("participant", fcPartBean, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private FosterCareParticipantRetrieveSI populate_Retrieve(int eventId) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populate_Retrieve()");
    performanceTrace.enterScope();

    FosterCareParticipantRetrieveSI fcpRetrieve = new FosterCareParticipantRetrieveSI();
    fcpRetrieve.setUlIdEvent(eventId);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return fcpRetrieve;
  }

  /**
   * Sends a populated object to the save service then returns to the calling page.
   * 
   * @param context
   */
  public void saveFCParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFCParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String includingFormName = (String) state.getAttribute("includingFormName", request);

    try {
      FosterCareParticipantSaveSI FCSave = this.populateFCPart_Save(context);
      FosterCareParticipantSaveSI saveFCPart = saveFosterCareParticipant.saveFosterCareParticipant(FCSave);

      // Set the PageMode to MODIFY in case in was ADD before the save.
      PageMode.setPageMode(PageModeConstants.MODIFY, request);

    } catch (ServiceException wtc) {
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    
    //return to calling page
    state.removeAllAttributes(request);
    if ("frmFCCPFamilyDetail".equals(includingFormName)) {
      setPresentationBranch("FCCP_FAMILY_DETAIL", context);
    } else if ("frmWTLP".equals(includingFormName)) {
      setPresentationBranch("WTLP", context);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Populates the object that is sent to the save service.
   * 
   * @param context
   * @return FosterCareParticipantSaveSI
   */
  FosterCareParticipantSaveSI populateFCPart_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCPart_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    FosterCareParticipantSaveSI fcPartSave = new FosterCareParticipantSaveSI();
    try {
      String selParticipantType = ContextHelper.getStringSafe(request, PARTICIPANT_TYPE);
      fcPartSave.setSzCdPartType(selParticipantType);

      if (request.getParameter(APPRV_DATE) != null && !"".equals(request.getParameter(APPRV_DATE))) {
        fcPartSave.setDtApprv(ContextHelper.getJavaDateSafe(request, APPRV_DATE));
      }
      if (request.getParameter(PERSON_ID) != null && !"".equals(request.getParameter(PERSON_ID))) {
        fcPartSave.setIdPerson(ContextHelper.getIntSafe(request, PERSON_ID));
      }
      if (request.getParameter(PERSON_NOT_APPRV) != null && !"".equals(request.getParameter(PERSON_NOT_APPRV))) {
        fcPartSave.setTxtNoApprv(ContextHelper.getStringSafe(request, PERSON_NOT_APPRV));
      }
      if (request.getParameter(IND_PERSON_APPRV) != null && !"".equals(request.getParameter(IND_PERSON_APPRV))) {
        fcPartSave.setIndApproval(ContextHelper.getStringSafe(request, IND_PERSON_APPRV));
      }
      if (request.getParameter(SIGNED_CPY_DT) != null && !"".equals(request.getParameter(SIGNED_CPY_DT))) {
        fcPartSave.setDtSigned(ContextHelper.getJavaDateSafe(request, SIGNED_CPY_DT));
      }
      if (request.getParameter(PARTICIPANT_DATE) != null && !"".equals(request.getParameter(PARTICIPANT_DATE))) {
        fcPartSave.setDtPart(ContextHelper.getJavaDateSafe(request, PARTICIPANT_DATE));
      }

      if (request.getParameter(PARTICIPANT_NAME) != null && !"".equals(request.getParameter(PARTICIPANT_NAME))) {
        fcPartSave.setSzNmPart(ContextHelper.getStringSafe(request, PARTICIPANT_NAME));
      }
      if (request.getParameter(RELATIONSHIP_INTEREST) != null
          && !"".equals(request.getParameter(RELATIONSHIP_INTEREST))) {
        if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ))
        {
          String relDecode = ContextHelper.getStringSafe(request, RELATIONSHIP_INTEREST);
          String relIntCode = Lookup.simpleEncodeSafe(CodesTables.CRPTRINT, relDecode);
          fcPartSave.setSzCdRelInt(relIntCode);
        }else if(selParticipantType.equals( CodesTables.CPARTYPE_STA )){
          fcPartSave.setSzCdRelInt(STAFF);
        }else{
          fcPartSave.setSzCdRelInt(ContextHelper.getStringSafe(request, RELATIONSHIP_INTEREST));
        }
      }
      if (request.getParameter(ID_PLAN_PART) != null && !"".equals(request.getParameter(ID_PLAN_PART))) {
        fcPartSave.setIdPlanPart(ContextHelper.getIntSafe(request, ID_PLAN_PART));
      }
      fcPartSave.setIdEvent(ContextHelper.getIntSafe(request, ID_EVENT));

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return fcPartSave;
  }

  /**
   * This method is called to display the Foster Care Participant page on an add after the 
   * participant type is selected.
   * 
   * @param context
   */
  public void reloadFCParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reloadFCParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      FosterCarePartBean fcPartBean = new FosterCarePartBean();
      String selParticipantType = ContextHelper.getStringSafe(request, PARTICIPANT_TYPE);
      fcPartBean.setSzCdPartType(selParticipantType);

      if (request.getParameter(APPRV_DATE) != null && !"".equals(request.getParameter(APPRV_DATE))) {
        fcPartBean.setDtApprv(ContextHelper.getJavaDateSafe(request, APPRV_DATE));
      }
      if (request.getParameter(PERSON_ID) != null && !"".equals(request.getParameter(PERSON_ID))) {
        fcPartBean.setIdPerson(ContextHelper.getIntSafe(request, PERSON_ID));
      }
      if (request.getParameter(PERSON_NOT_APPRV) != null && !"".equals(request.getParameter(PERSON_NOT_APPRV))) {
        fcPartBean.setTxtNoApprv(ContextHelper.getStringSafe(request, PERSON_NOT_APPRV));
      }
      if (request.getParameter(IND_PERSON_APPRV) != null && !"".equals(request.getParameter(IND_PERSON_APPRV))) {
        fcPartBean.setIndApproval(ContextHelper.getStringSafe(request, IND_PERSON_APPRV));
      }
      if (request.getParameter(SIGNED_CPY_DT) != null && !"".equals(request.getParameter(SIGNED_CPY_DT))) {
        fcPartBean.setDtSigned(ContextHelper.getJavaDateSafe(request, SIGNED_CPY_DT));
      }
      if (request.getParameter(PARTICIPANT_DATE) != null && !"".equals(request.getParameter(PARTICIPANT_DATE))) {
        fcPartBean.setDtPart(ContextHelper.getJavaDateSafe(request, PARTICIPANT_DATE));
      }
      if (request.getParameter("hdnPlanPart") != null && !"".equals(request.getParameter("hdnPlanPart"))
          && ContextHelper.getIntSafe(request, "hdnPlanPart") != 0) {
        fcPartBean.setIdPlanPart(ContextHelper.getIntSafe(request, "hdnPlanPart"));
      }

      // If the user selected "Other" as the Participant Type, preserve the
      // values in the Name and Relationship/Interest fields.
      if (selParticipantType.equals(CodesTables.CPARTYPE_OTH)) {
        if (request.getParameter(PARTICIPANT_NAME) != null && !"".equals(request.getParameter(PARTICIPANT_NAME))) {
          fcPartBean.setSzNmPart(ContextHelper.getStringSafe(request, PARTICIPANT_NAME));
        }
        if (request.getParameter(RELATIONSHIP_INTEREST) != null
            && !"".equals(request.getParameter(RELATIONSHIP_INTEREST))) {
          fcPartBean.setSzCdRelInt(ContextHelper.getStringSafe(request, RELATIONSHIP_INTEREST));
        }
      }
      state.setAttribute("participant", fcPartBean, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method can be called by the Foster Care Participant page or by the 
   * Foster Care Participant submodule when the delete button is clicked. This method removes
   * the entry on the PLAN_PARTICIPANT table corresponding to the selected participant.
   * 
   * @param context
   */
  public void deleteFCParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteFCParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String includingFormName = (String) state.getAttribute("includingFormName", request);

    try {

      FosterCareParticipantSaveSI FCDelete = this.populateFCPart_Save(context);
      
      //if the button was clicked on the submodule.
      if (FCDelete.getIdPlanPart() == 0) {
        FCDelete.setIdPlanPart(ContextHelper.getIntSafe(request, "rbParticipantId_CLEAN"));
      }
      FCDelete.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
      saveFosterCareParticipant.saveFosterCareParticipant(FCDelete);

    } catch (ServiceException wtc) {
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    //return to the calling page
    if ("frmFCCPFamilyDetail".equals(includingFormName)) {
      setPresentationBranch("FCCP_FAMILY_DETAIL", context);
    } else if ("frmWTLP".equals(includingFormName)) {
      setPresentationBranch("WTLP", context);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * This method is used when the add button is clicked on the Foster Care Participant submodule
   * 
   * @param context
   */
  public void addFosterCareParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addFosterCareParticipant_xa_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      PageMode.setPageMode(PageModeConstants.NEW, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Calls the Person List page.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  public void performPersonListPullback_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performPersonListPullback_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Preserve the value of PageMode so that it can be restored upon
      // returning from the Person List.
      state.setAttribute(PARTICIPANT_DETAIL_PAGE_MODE, PageMode.getPageMode(request), request);
      PersonListPullBackInfo io = new PersonListPullBackInfo();
      io.setDestinationUrl("/casemgmt/FosterCareParticipant/displayFosterCareParticipant");
      PageMode.setPageMode(PersonListConversation.PAGE_MODE_SELECT, request);
      request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, io);
      forward(PersonListConversation.DISPLAY_PAGE, request, context.getResponse());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

/**
 * Temporarily saves the state of data on the Foster Care Participant page 
 * then forwards to the Staff Search page. When the user returns
 * to the FosterCareParticipant all page data is still entered.
 * 
 * @param context
 */
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    FosterCarePartBean retrieveSO = (FosterCarePartBean) state.getAttribute("participant", request);
    if (retrieveSO == null) {
      retrieveSO = new FosterCarePartBean();
    }

    retrieveSO.setDtApprv(ContextHelper.getJavaDateSafe(request, APPRV_DATE));
    retrieveSO.setDtPart(ContextHelper.getJavaDateSafe(request, PARTICIPANT_DATE));
    retrieveSO.setDtSigned(ContextHelper.getJavaDateSafe(request, SIGNED_CPY_DT));
    retrieveSO.setIndApproval(ContextHelper.getStringSafe(request, IND_PERSON_APPRV));
    retrieveSO.setSzCdPartType(ContextHelper.getStringSafe(request, PARTICIPANT_TYPE));
    retrieveSO.setSzCdRelInt(ContextHelper.getStringSafe(request, RELATIONSHIP_INTEREST));
    retrieveSO.setTxtNoApprv(ContextHelper.getStringSafe(request, PERSON_NOT_APPRV));
    retrieveSO.setSzNmPart(ContextHelper.getStringSafe(request, PARTICIPANT_NAME));
    retrieveSO.setIdPerson(ContextHelper.getIntSafe(request, PERSON_ID));

    state.setAttribute("participant", retrieveSO, request);
    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.OTHER);
    io.setDestinationUrl("/casemgmt/FosterCareParticipant/setStaff");
    request.setAttribute("StaffSearchInput", io);
    // context and forward the user.
    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception o) {
      processSevereException(context, o);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method will retrieve the row object that the staff search sent to us and put the new data into the retrieveSO
   * object for display on the Foster Care Participant page.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void setStaff_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    FosterCarePartBean retrieveSO = (FosterCarePartBean) state.getAttribute("participant", request);
    if (retrieveSO == null) {
      retrieveSO = new FosterCarePartBean();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      retrieveSO.setSzNmPart(staff.getSzNmPersonFull());
      retrieveSO.setIdPerson(staff.getUlIdPerson());
      retrieveSO.setSzCdRelInt(STAFF);
    }
    state.setAttribute("participant", retrieveSO, request);

    performanceTrace.exitScope();
  }

  /**
   * Checks to see if the user has access to this stage.
   * 
   * @param context
   * @return hasStageAccess
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  
  /**
   * Handles any errors generated in any other methods of the class.
   * 
   * @param we
   * @param context
   */
  public void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage = null;
    switch (we.getErrorCode()) {
    case Messages.MSG_CMN_OVERLAP_ADD:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_OVERLAP_ADD);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_CMN_ON_CALL_TOO_MANY:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_ON_CALL_TOO_MANY);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_SYS_STAGE_CLOSED:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_SAVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_SYS_MULT_INST:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      setErrorMessage(errorMessage, FCP_INFORMATION, request);
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
  }
}