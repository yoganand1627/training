package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.Enumeration;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNB8DO;
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

/**
 * This is the class used for manual Stage Progression
 *
 * @author Carolyn Douglass, Jan 20, 2003
 *         <p/>
 *         <pre>
 *                 Change History:
 *                  Date      User              Description
 *                  --------  ----------------  --------------------------------------------------
 *                  5/26/05   DUNAWAKL          SIR 13544 - added logic to pull information
 *                                              about the age of the person, whose name is
 *                                              used for the new stage name from db, and set
 *                                              that information into state to
 *                                              be used in StageProgression.jsp
 *                  9/23/09   mxpate            STGAP00013963: added code to populate ccmn39si object with idStage.                            
 *                 </pre>
 */

@SuppressWarnings("serial")
public class StageProgressionConversation extends BaseHiddenFieldStateConversation {

  private Admin admin;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  @SuppressWarnings( { "unchecked" })
  public void displayStageProgression_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStageProgression_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    String szCdStage = GlobalData.getSzCdStage(request);
    String szCdStageProgram = GlobalData.getSzCdStageProgram(request);
    String szCdStageReasonClosed = (String) state.getAttribute(STAGE_REASON_CLOSED, request);

    /* Assigned Workload passes in Reason Closed in the request,
       it is then saved in state, so that it will still be there after coming back
       from person list.
       If the stage reason closed is blank, populate it with the stage
    */
    if (szCdStageReasonClosed == null || "".equals(szCdStageReasonClosed)) {
      szCdStageReasonClosed = (String) request.getAttribute(STAGE_REASON_CLOSED);
      if (szCdStageReasonClosed == null || "".equals(szCdStageReasonClosed)) {
        szCdStageReasonClosed = szCdStage;
      }
    }

    //There will be information in person ListPullBack on a redisplay of the page
    //if the Person button has been clicked and a person selected.
    //Certain stages require that a person is selected.
    //Also, pagemode will be reset to its pre-existing value after the call
    //to person list.
    int ulIdPerson = 0;
    int idStage = GlobalData.getUlIdStage(request);
    String nmPerson = null;
    
    boolean checkBirthday = false;
    String strAge = null;
    String strBirthday = null;
    String szCurrentStageType = null;

    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request.getAttribute(
            PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);

    if (personListPullBackInfo != null) {
      ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
      if (rowcinv01sog00 != null) {
        checkBirthday = true;
        ulIdPerson = rowcinv01sog00.getUlIdPerson();
        nmPerson = rowcinv01sog00.getSzNmPersonFull();
        request.setAttribute("nmPerson", nmPerson);

        if (rowcinv01sog00.getLNbrPersonAge() != 0) {
          strAge = Integer.toString(rowcinv01sog00.getLNbrPersonAge());
        }
        if (rowcinv01sog00.getDtDtPersonBirth() != null) {
          org.exolab.castor.types.Date datBirthday = rowcinv01sog00.getDtDtPersonBirth();
          strBirthday = datBirthday.toString();
        }
        szCurrentStageType = GlobalData.getSzCdStageType(request);

      }
      String pagemode = (String) state.getAttribute("previouspagemode", request);
      PageMode.setPageMode(pagemode, request);
    } else {
      //clear state
      state.removeAllAttributes(request);
    }
    try {
      //call the Tuxedo service using the WtcHelper object
      //STGAP00013963: modified populate method to add idStage 
      CCMN39SI ccmn39si = populateCCMN39SI_Retrieve(context, szCdStage, szCdStageProgram, szCdStageReasonClosed, idStage);
      CCMN39SO ccmn39so = admin.retrieveStageProgression(ccmn39si);

      ROWCCMNB8DO newStages = null;
      SortedMap stages = new TreeMap();
      Option opt = null;
      Enumeration enumeration = ccmn39so.getROWCCMNB8DO_ARRAY().enumerateROWCCMNB8DO();
      while (enumeration.hasMoreElements()) {
        newStages = (ROWCCMNB8DO) enumeration.nextElement();
        String decode = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, newStages.getSzCdStageProgOpen()) + " - " + Lookup.simpleDecodeSafe("CSTAGES",
                                                                                           newStages.getSzCdStageProgOpen());
        opt = new Option(newStages.getSzCdStageProgOpen(), decode);
        stages.put(newStages.getSzCdStageProgOpen(), opt);
      }

      state.setAttribute("ulIdPerson", String.valueOf(ulIdPerson), request);
      state.setAttribute(STAGE_REASON_CLOSED, szCdStageReasonClosed, request);
      state.setAttribute("stages", stages, request);
      
      state.setAttribute(CHECK_BDAY, checkBirthday, request);
      state.setAttribute(PERSON_BDAY, strBirthday, request);
      state.setAttribute(PERSON_AGE, strAge, request);

      state.setAttribute(CURRENT_STAGE_TYPE, szCurrentStageType, request);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
  }

  /**
   * This method will set the inputs into the CCMN38S service to retrieve data for the page.
   *
   * @param context, szCdStage, szCdStageProgram, szCdStageReasonClosed to pass to the retrieve service
   */
  private CCMN39SI populateCCMN39SI_Retrieve(GrndsExchangeContext context, String szCdStage, String szCdStageProgram,
                                             String szCdStageReasonClosed, int idStage) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN39SI_Retrieve()");
    performanceTrace.enterScope();

//    HttpServletRequest request = context.getRequest();

    CCMN39SI ccmn39si = new CCMN39SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

    //Set the values for the ArchInputStruct
    ccmn39si.setArchInputStruct(input);
    ccmn39si.setSzCdStage(szCdStage);
    ccmn39si.setSzCdStageProgram(szCdStageProgram);
    ccmn39si.setSzCdStageReasonClosed(szCdStageReasonClosed);
    //STGAP00013963: added code to set idStage to ccmn39si
    ccmn39si.setUlIdStage(idStage);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return ccmn39si;
  }

  /**
   * This method will call Person List to allow the user to select a person for the new stage.
   *
   * @param context to pass data to the person list service
   */
  public void createPersonList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createPersonList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    String newStage = ContextHelper.getStringSafe(context, NEW_STAGE);
    state.setAttribute(NEW_STAGE, newStage, request);

    PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
    personListPullBackInfo.setDestinationUrl("/workload/StageProgression/displayStageProgression");
    state.setAttribute("previouspagemode", PageMode.getPageMode(request), request);

    PageMode.setPageMode(PersonListConversation.PAGE_MODE_PRINC_ONLY, request);

    request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPullBackInfo);
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will Stage Progress the existing stage to the new stage.
   *
   * @param context used to call the save service to stage progress.
   */
  public void saveStageProgression_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveStageProgression_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      //Allocate the structures
      CCMN88SI ccmn88si = populateCCMN88SI_StageProgress(context);
      //Call save service.  It will throw an exception if there is an error.
      admin.saveStageProgression(ccmn88si);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      state.removeAttribute("ulIdPerson", request);
      state.removeAttribute(STAGE_REASON_CLOSED, request);
      state.removeAttribute("stages", request);
      state.removeAttribute(PERSON_AGE, request);
      state.removeAttribute(PERSON_BDAY, request);
      state.removeAttribute(CHECK_BDAY, request);
      state.removeAttribute(CURRENT_STAGE_TYPE, request);
    }
    // Handle exceptions
    catch (ServiceException we) {
      handleServiceError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will set the inputs into the CCMN88S service to stage progress.
   *
   * @param context data to pass to the save service
   */
  private CCMN88SI populateCCMN88SI_StageProgress(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    CCMN88SI ccmn88si = new CCMN88SI();
    ArchInputStruct input = new ArchInputStruct();
    String setSzCdStageOpen = ContextHelper.getStringSafe(context, NEW_STAGE);

    input.setSzUserId(userProfile.getUserLogonID());

    ccmn88si.setArchInputStruct(input);
    ccmn88si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccmn88si.setUlIdPerson(userProfile.getUserID());
    ccmn88si.setSzCdStage(GlobalData.getSzCdStage(request));
    ccmn88si.setSzCdStageOpen(setSzCdStageOpen);
    ccmn88si.setSzCdStageReasonClosed((String) state.getAttribute(STAGE_REASON_CLOSED, request));

    ccmn88si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    ccmn88si.setSzNmPersonFull(ContextHelper.getStringSafe(context, "nmPerson"));
    int idPerson = 0;
    try {
      idPerson = Integer.parseInt((String) state.getAttribute("ulIdPerson", request));
    } catch(NumberFormatException nfe) {}
    ccmn88si.setUlScrIdPrimChild(idPerson);
    
    String currentStage = ContextHelper.getStringSafe(context, "szCdCurrStage");
    if ((currentStage.length() > 2 && !INT_STAGE.equals(currentStage.substring(0, 3))) &&
        (SUB_STAGE.equals(setSzCdStageOpen) || ADO_STAGE.equals(setSzCdStageOpen) ||
         PAD_STAGE.equals(setSzCdStageOpen) || FSU_STAGE.equals(setSzCdStageOpen) ||
         FPR_STAGE.equals(setSzCdStageOpen) || PFC_STAGE.equals(setSzCdStageOpen))) {
      ccmn88si.setCSysIndSStgOpenOnly(INDICATOR_YES);
    } else {
      ccmn88si.setCSysIndSStgOpenOnly(INDICATOR_NO);
    }

    return ccmn88si;
  }

  /**
   * Helper method that handles all the WTC Exceptions.
   *
   * @param ServiceException and context The GrndeExchangeContext object.
   */
  private void handleServiceError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage = null;
    this.setPresentationBranch("error", context);
    switch (we.getErrorCode()) {
      case Messages.MSG_INT_LE_NOTIF_REQUIRED:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INT_LE_NOTIF_REQUIRED);
        setErrorMessage(errorMessage, DISPLAY_PAGE, request);
        break;
      case Messages.MSG_CANT_ASSIGN_WORKER:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CANT_ASSIGN_WORKER);
        setErrorMessage(errorMessage, DISPLAY_PAGE, request);
        break;
      case Messages.MSG_SUB_SUBC_STAGE_EXISTS:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SUB_SUBC_STAGE_EXISTS);
        setErrorMessage(errorMessage, DISPLAY_PAGE, request);
        break;
      case Messages.MSG_CMN_STAGE_CLOSED:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_STAGE_CLOSED);
        setErrorMessage(errorMessage, DISPLAY_PAGE, request);
        break;
      case Messages.MSG_INT_CLOS_APRV_REQ:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INT_CLOS_APRV_REQ);
        setErrorMessage(errorMessage, DISPLAY_PAGE, request);
        break;
      case Messages.MSG_ADO_STAGE_EXISTS:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_ADO_STAGE_EXISTS);
        setErrorMessage(errorMessage, DISPLAY_PAGE, request);
        break;        
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }


  // static constants
  public static final String TRACE_TAG = "StageProgressionConversation";
  public static final String DISPLAY_PAGE = "/workload/StageProgression/displayStageProgression";
  public static final String ADO_STAGE = CodesTables.CSTAGES_ADO;
  public static final String DIV_STAGE = CodesTables.CSTAGES_DIV;
  public static final String FPR_STAGE = CodesTables.CSTAGES_FPR;
  public static final String FPR_ONG_STAGE = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, CodesTables.CTXTOGA_FPR);
  public static final String FSU_STAGE = CodesTables.CSTAGES_FSU;
  public static final String FSU_FCF_STAGE = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, CodesTables.CTXTOGA_FSU);
  public static final String INT_STAGE = CodesTables.CSTAGES_INT;
  public static final String PAD_STAGE = CodesTables.CSTAGES_PAD;
  public static final String PFC_STAGE = CodesTables.CSTAGES_PFC;
  public static final String SUB_STAGE = CodesTables.CSTAGES_SUB;
  public static final String SUB_FCC_STAGE = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, CodesTables.CTXTOGA_SUB);
  public static final String INDICATOR_YES = "Y";
  public static final String INDICATOR_NO = "N";
  public static final String STAGE_REASON_CLOSED = "szCdStageReasonClosed";
  public static final String NEW_STAGE = "selNewStage";
  public static final String PERSON_AGE = "strAge";
  public static final String PERSON_BDAY = "strBirthday";
  public static final String CHECK_BDAY = "bCheckBday";
  public static final String CURRENT_STAGE_TYPE = "strCurrentStageType";
}

