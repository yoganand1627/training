//*  Conversation  Name: AdoptionInformationConversation
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:Conversation for Adoption .
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  10/7/2008	Ronnie Phelps	 	Changes for Adoptions Enhancements
//**  

package gov.georgia.dhr.dfcs.sacwis.web.subcare;

/* <pre>
 * Change History:
 *  Date        Fixer      STGAP         Description
 *  ----------  --------  -------------  ------------------------------------------------------
 *  08/05/2008  charden   STGAP00009796  Set return page url into request to be retrieve in ResourceList.jsp
 *  01/29/2009  mchillman STGAP00012095  Added code to correctly set user to Exchange Child page
 *  02/17/2009  arege     STGAP00012095  Modified displayChildDetail_xa() so that correct child name is 
 *                                       displayed in the top left corner of the page.
 *  05/11/2009  mxpatel   STGAP00012669  Removed the for loop that was iterating over number of resources as the
 *                                       maximum number of resources can not be more than one.  Also changed the "hdnIdResource" to
 *                                       "hdnResourceId" and removed "+ i" as that was causing the exception.
 *  06/06/2011  hnguyen   SMS#109405     MR-083 Updated logic to populate new county recruitment activities to SI.
 *  06/29/2011  htvo      SMS##113568    Reset the id to new mode (id = 0) for copied date row when in Copy mode before save
 *  07/05/2011  hnguyen   SMS##113568    Corrected fix to set id = 0 in retrieve service.
 *  09/23/2011  hnguyen   STGAP00017011  MR-092 Update logic to retrieve and save new sibling with ADO in a different case.
 *   
 * </pre>
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionResourceBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingGroupInformationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoInfoCbxSentStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingExternalLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupInformationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingPlacementGroupSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.fad.ExchangeHomeDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.ExchangeChildDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/** Handles all Adoption Information activities and procedures. */
public class AdoptionInformationConversation extends BaseHiddenFieldStateConversation {
  // static constants
  public static final int INITIAL_PAGE = 1;

  public static final String PRS_STAFF = "FPS Staff";

  public static final String PARTICIPANT_DETAIL_PAGE_MODE = "participantDetailPageMode";

  public static final String SAVE = "save";

  public static final String ADO_CHILD_PLAN_TASK_CODE = "8660";

  public static final String APPROVE_ADO_CHILD_PLAN_TASK_CODE = "8860";

  public static final String SUB_CHILD_PLAN_TASK_CODE = "3160";

  public static final String APPROVE_SUB_CHILD_PLAN_TASK_CODE = "3370";

  public static final int PARTICIPANTS_PER_PAGE = 50;

  public static final String EVENT_STATUS_PROC = "PROC";

  public static final String EVENT_STATUS_COMP = "COMP";

  public static final String EVENT_DESC_NO = "Adoption Information";

  public static final String NO_EVENT_TYPE = "ADO";

  private static final String TRUE = "true";

  public static final int FIFTY = 50;

  public static final int ONE = 1;

  protected static final String RESOURCE_PULLBACK_INFO = ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST;

  public static final String URL_RESOURCE_SEARCH_LIST = "/resource/ResourceSearch/displaySearch";

  public static final String SEC_REGIONAL_SS_STF = UserProfile.SEC_REGIONAL_SS_STF;

  public static final String SEC_STATE_OFFICE_CONSULTANT = UserProfile.SEC_STATE_OFFICE_CONSULTANT;

  private CaseMgmt adoinfo = null;

  private Common common;

  private Person person;

  private Admin admin;

  public void setCaseMgmt(CaseMgmt adoinfo) {
    this.adoinfo = adoinfo;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * Displays the Adoption Information details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void displayAdoption_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdoption_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      String PageName = "";
      boolean IndEduDetail = false;
      String pageModeFromEvent = PageMode.getPageMode(request);
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state
                                                                                                         .getAttribute(
                                                                                                                       "AdoptionInformationRetrieveSO",
                                                                                                                       request);

      int ulIdEvent = GlobalData.getUlIdEvent(request);
      // STGAP00010427: If the Adoption Information page is being called by clicking the hyperlink on the
      // sibling id hyperlink on the exchange child detail page, than the Global data will have the event
      // Id of the exchange child event not the ADO event. In that particular case we do not
      // want to call the EventSearchConversation.getEventDetailPageMode since we are not coming
      // from the event list.
      if (adoptioninformationRetrieveSO == null || adoptioninformationRetrieveSO.getUlIdEvent() == ulIdEvent) {
        pageModeFromEvent = EventSearchConversation.getEventDetailPageMode(request);
      }
      Boolean rights = hasStageAccessRights(context);
      if (!rights) {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      } else {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
      if (adoptioninformationRetrieveSO == null) {
        adoptioninformationRetrieveSO = new AdoptionInformationRetrieveSO();
        AdoptionInformationRetrieveSI adoptioninformationRetrieveSI = populateAdoptionInformationRetrieveSI_Retrieve(context);
        adoptioninformationRetrieveSI.setUlIdEvent(ulIdEvent);
        if (pageModeFromEvent.equals(PageModeConstants.NEW_USING)) {
          adoptioninformationRetrieveSI.setIsNewUsing(true);
        }
        adoptioninformationRetrieveSO = adoinfo.retrieveAdoptionInformation(adoptioninformationRetrieveSI);

        String cdEventStatus = adoptioninformationRetrieveSO.getCdEventStatus();
        // set page mode to view only if the event status is complete.
        if (cdEventStatus != null && cdEventStatus.equals(EVENT_STATUS_COMP)) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }
      // Changes for Copy Button from Event List
      if (pageModeFromEvent.equals(PageModeConstants.NEW_USING)) {
        ulIdEvent = 0;
        // STGAP00010761 remove tracking dates
        adoptioninformationRetrieveSO.setDtAdptPlacAgmtSigned(null);
        adoptioninformationRetrieveSO.setDtChildLifeHistPres(null);
        // adoptioninformationRetrieveSO.setDtDisruption();
        adoptioninformationRetrieveSO.setDtDocSentAttor(null);
        adoptioninformationRetrieveSO.setDtFostParNotAgDecAdpt(null);
        adoptioninformationRetrieveSO.setDtFostParNotAgTPR(null);
        adoptioninformationRetrieveSO.setDtLetterSent(null);
        adoptioninformationRetrieveSO.setDtPermFileLetterComp(null);
        adoptioninformationRetrieveSO.setDtPermStaffFostPar(null);
        adoptioninformationRetrieveSO.setDtStaffAdptFam(null);
        adoptioninformationRetrieveSO.setIndAdoptOutcome(null);
        GlobalData.setUlIdEvent(ulIdEvent, request);
      }
      if (ulIdEvent == 0 && rights == true) {
        PageMode.setPageMode(PageModeConstants.NEW, request);
      }

      List<Option> siblingOptionList = new ArrayList<Option>();
      // must include a blank value for dropdown option first
      siblingOptionList.add(new Option("", ""));

      // MR-092 get option list for sibling with open ADO in another case
      if (adoptioninformationRetrieveSO != null
          && adoptioninformationRetrieveSO.getPrnChildrenUnder18WithAnotherAdoCaseNames() != null) {
        Map<Integer, String> prnChildrenUnder18WithAnotherAdoCaseNames = adoptioninformationRetrieveSO.getPrnChildrenUnder18WithAnotherAdoCaseNames();
        Set<Integer> idSiblingSet = prnChildrenUnder18WithAnotherAdoCaseNames.keySet();
        for (Iterator<Integer> keyIter = idSiblingSet.iterator(); keyIter.hasNext();) {
          int idSibling = keyIter.next();
          String siblingFullName = prnChildrenUnder18WithAnotherAdoCaseNames.get(idSibling);
          Option siblingOption = new Option(String.valueOf(idSibling), siblingFullName);
          siblingOptionList.add(siblingOption);
        }
      }

      state.setAttribute("siblingOptionList", siblingOptionList, request);
      state.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO, request);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SSM_TOO_MANY_ROWS_RETURNED:
      case Messages.SSM_NO_ROWS_RETURNED:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
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
   * Saves the Adoption Information details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void saveAdoption_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAdoption_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      AdoptionInformationSaveSI adoptioninfoSaveSI = new AdoptionInformationSaveSI();
      adoptioninfoSaveSI = populateAdoptionInfoSaveSI_AU(context, SAVE);
      adoptioninfoSaveSI.setSiblingGroupInformationSI(populateSiblingGroupInformationSaveSI(context));
      int eventId = adoinfo.saveAdoptionInformation(adoptioninfoSaveSI);
      request.setAttribute("AdoptionInformationSaveSI", adoptioninfoSaveSI);
      request = context.getRequest();
      GlobalData.setUlIdEvent(eventId, request);

      // removed in order to refresh data previously saved.
      state.removeAttribute("AdoptionInformationRetrieveSO", request);
      if (ContextHelper.getString(request, "btnComplete.x") == null) {
        	forward("/subcare/AdoptionInformation/displayAdoption", request,
        			context.getResponse());
      }
      performanceTrace.exitScope();
      performanceTrace.getTotalTime();
    } catch (Exception e) {
      handleException(e, context, "saveAdoption_xa");
    } finally {
      performanceTrace.exitScope();
    }

    return;
  }

  /**
   * Adds the Adoption Information Family Resource List.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addAdoptionInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addAdoptionInformation_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      // AdoptionInformationSaveSI adoptioninfoSaveSI = new AdoptionInformationSaveSI();
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state
                                                                                                         .getAttribute(
                                                                                                                       "AdoptionInformationRetrieveSO",
                                                                                                                       request);
      if (adoptioninformationRetrieveSO == null) {
        adoptioninformationRetrieveSO = new AdoptionInformationRetrieveSO();
      }
      populateAdoptionInfo(request, adoptioninformationRetrieveSO);
      state.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO, request);
      ResourceSearchPullBackInfo resourceSearchPullBackInfo = new ResourceSearchPullBackInfo();
      resourceSearchPullBackInfo.setDestinationUrl("/subcare/AdoptionInformation/setAdoResourceList");
      request.setAttribute(RESOURCE_PULLBACK_INFO, resourceSearchPullBackInfo);
      // STGAP00009796 - set return page url into request to be retrieved in ResourceList.jsp
      request.setAttribute("destinationUrl", resourceSearchPullBackInfo.getDestinationUrl());
      String addResourceIndicator = "Y";
      state.setAttribute("addResourceIndicator", addResourceIndicator, request);
      forward(URL_RESOURCE_SEARCH_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void displayChildDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayChildDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String strIdECEvent = StringHelper.getSafeString(request.getParameter("hdnIdChildEventFromAdoInfo"));
    String strIdChild = StringHelper.getSafeString(request.getParameter("hdnIdChildPersonFromAdoInfo"));
    // STGAP00012095
    String strNameChild = StringHelper.getSafeString(request.getParameter("hdnNameChildPersonFromAdoInfo"));
    if (strIdECEvent != null && strIdChild != null && strNameChild != null) {
      try {
        int idECEvent = Integer.parseInt(strIdECEvent);
        int idChild = Integer.parseInt(strIdChild);
        CaseUtility.Event excEvent = CaseUtility.getEvent(idECEvent);
        CaseUtility.Stage stage = CaseUtility.getStage(excEvent.getIdStage());
        GlobalData.setUlIdPerson(idChild, request);
        // STGAP00012095: This will display correct child name in the top left corner on the Exchange Child Detail page.
        GlobalData.setSzNmPersonFull(strNameChild, request);
        String paramString = "actionEventId=" + strIdECEvent + "&actionStageCode=" + stage.getCdStage()
                             + "&actionStageName=" + stage.getNmStage() + "&actionTaskCode=" + "9530"
                             + "&actionCaseId=" + stage.getIdCase() + "&actionStageId=" + excEvent.getIdStage();

        String forwardUril = "/workload/EventSearch/displayEventDetail?" + paramString;
        forward(forwardUril, request, context.getResponse());

      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        handleException(e, context, "displayChildDetail_xa");
      }
    }
    performanceTrace.exitScope();
  }

  /**
   * Deletes the selected Resources from the list.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteAdoptionInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteAdoptionInformation_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      AdoptionInformationSaveSI adoptioninfoSaveSI = new AdoptionInformationSaveSI();
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state
              .getAttribute(
                      "AdoptionInformationRetrieveSO",
                                                                                                                       request);
      if (adoptioninformationRetrieveSO == null) {
        adoptioninformationRetrieveSO = new AdoptionInformationRetrieveSO();
      }
      AdoptionResourceBean resBeantoDelete = new AdoptionResourceBean();
      List<AdoptionResourceBean> resBeanList = new ArrayList();
      List<AdoptionResourceBean> newBeanList = new ArrayList();
      int idAdoption = 0;
      int size = 0;
      int idResourcetoDelete = ContextHelper.getIntSafe(request, "hdnIdResourcetoDelete");
      String nmResourcetoDelete = ContextHelper.getStringSafe(request, "hdnNmResourcetoDelete");
      populateAdoptionInfo(request, adoptioninformationRetrieveSO);
      if (adoptioninformationRetrieveSO.getIdenResList().size() != 0) {
        resBeanList = adoptioninformationRetrieveSO.getIdenResList();
      }
      size = resBeanList.size();
      for (int i = 0; i < size; i++) {

        if ((resBeanList.get(i).getIdResource() != idResourcetoDelete)
            && !(nmResourcetoDelete.equals(resBeanList.get(i).getNmResource()))) {
          newBeanList.add(resBeanList.get(i));
        }
      }

      adoptioninformationRetrieveSO.setIdenResList(newBeanList);
      state.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO, request);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_CMN_NO_PRIMARY_ROW:
        this.setPresentationBranch("error", context);
        break;
      case Messages.MSG_ADO_DT_WO_TERMINATION:
        setErrorMessage(Messages.MSG_ADO_DT_WO_TERMINATION, request);
        this.setPresentationBranch("error", context);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Retrieves the Adoption Information details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void retrieveAdoResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrieveAdoResource_xa");
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                                       request);
      if (adoptioninformationRetrieveSO == null) {
        adoptioninformationRetrieveSO = new AdoptionInformationRetrieveSO();
      }
      // get page data
      populateAdoptionInfo(request, adoptioninformationRetrieveSO);
      request.setAttribute("destinationUrl", "/subcare/AdoptionInformation/setAdoResource");
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Sets the Resource details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void setAdoResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setAdoResource_xa");
    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                                       request);
      populateResource(request, adoptioninformationRetrieveSO);

      request.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Sets the resource details for the Resource List.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void setAdoResourceList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setAdoResourceList_xa");
    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                                       request);
      populateResourceforList(request, adoptioninformationRetrieveSO);
      // PageMode.setPageMode((String)
      // state.getAttribute("ACTUAL_PAGE_MODE", request), request);
      request.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void addSiblingGroup_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addSiblingGroup_xa()");
    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                                     request);

    SiblingGroupInformationSO siblingGroupInformationSO = adoptioninformationRetrieveSO.getSiblingGroupInformation();

    int numOfNewSiblingGroups = siblingGroupInformationSO.getNumOfNewSiblingGroups();

    /* add a new sibling placmentGroup */
    numOfNewSiblingGroups = numOfNewSiblingGroups + 1;
    siblingGroupInformationSO.setNumOfNewSiblingGroups(numOfNewSiblingGroups);

    state.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO, request);
    // displayAdoption_xa(context);
    try {
      forward("/subcare/AdoptionInformation/displayAdoption", request, context.getResponse());
    } catch (Exception e) {

      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
    performanceTrace.exitScope();
  }

  /**
   * Populates the Resource details from Pullback.
   * 
   * @param request
   *          The HttpServletRequest object.
   * @param adoptioninformationRetrieveSO
   *          The AdoptionInformationRetrieveSO object.
   */
  protected void populateResource(HttpServletRequest request,
                                  AdoptionInformationRetrieveSO adoptioninformationRetrieveSO) {
    CRES03SO cres03so = (CRES03SO) request.getAttribute(RESOURCE_PULLBACK_INFO);
    if (cres03so == null) {
      return;
    }
    request.removeAttribute(RESOURCE_PULLBACK_INFO);
    int idResourceIdForPullback = 0;
    idResourceIdForPullback = cres03so.getUlIdResource();
    if (idResourceIdForPullback != 0) {
      adoptioninformationRetrieveSO.setResourceIdForPullback(cres03so.getUlIdResource());
      adoptioninformationRetrieveSO.setNMResource(String.valueOf(cres03so.getSzNmResource()));
      adoptioninformationRetrieveSO.setSzCdCategory(cres03so.getSzCdRsrcCategory());
    }
    String county = StringHelper.EMPTY_STRING;
    String prvagency = StringHelper.EMPTY_STRING;
    String icpcstate = StringHelper.EMPTY_STRING;
    Enumeration addressEnum = cres03so.getROWCRES03SOG00_ARRAY().enumerateROWCRES03SOG00();
    ROWCRES03SOG00 addressDetail = new ROWCRES03SOG00();
    while (addressEnum.hasMoreElements()) {
      addressDetail = (ROWCRES03SOG00) addressEnum.nextElement();
      if ("01".equals(addressDetail.getSzCdRsrcAddrType())) {
        county = addressDetail.getSzCdFacilityCounty();
        icpcstate = addressDetail.getSzCdFacilityState();
        break;
      }
    }
    if (idResourceIdForPullback != 0) {
      prvagency = cres03so.getSzNmAgencyName();
      adoptioninformationRetrieveSO.setSzCdCounty(county);
      adoptioninformationRetrieveSO.setSzCdState(icpcstate);
      adoptioninformationRetrieveSO.setIndIdentifiedAdopRes("Y");
    }
    if (!("".equals(prvagency))) {

      adoptioninformationRetrieveSO.setNMAgency(prvagency);
    }
  }

  /**
   * Populates the resource details for the List..
   * 
   * @param request
   *          The HttpServletRequest object.
   * @param adoptioninformationRetrieveSO
   *          The AdoptionInformationRetrieveSO object.
   */
  protected void populateResourceforList(HttpServletRequest request,
                                         AdoptionInformationRetrieveSO adoptioninformationRetrieveSO) {
    CRES03SO cres03so = (CRES03SO) request.getAttribute(RESOURCE_PULLBACK_INFO);

    AdoptionResourceBean resBean = new AdoptionResourceBean();
    if (cres03so == null) {
      return;
    }
    List<AdoptionResourceBean> resBeanList = new ArrayList<AdoptionResourceBean>();

    if (adoptioninformationRetrieveSO.getIdenResList().size() != 0) {
      resBeanList = adoptioninformationRetrieveSO.getIdenResList();
    }
    request.removeAttribute(RESOURCE_PULLBACK_INFO);
    int idResourceIdForPullback = 0;
    resBean.setIdResource(cres03so.getUlIdResource());
    resBean.setNmResource(String.valueOf(cres03so.getSzNmResource()));
    resBeanList.add(resBean);
    adoptioninformationRetrieveSO.setIdenResList(resBeanList);
  }

  /**
   * Populates the Adoption Information details for the Save.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param method
   *          The Method name.
   */
  private AdoptionInformationSaveSI populateAdoptionInfoSaveSI_AU(GrndsExchangeContext context, String method) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateAdoptionInfoSaveSI_AU");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    // bCompleteIsPressed is used to determine what button was originally pressed.
    // set it here based on if btnCompleteIsPressed was selected.
    // boolean btnCompleteIsPressed = ContextHelper.getString(request, "btnComplete.x") != null;

    boolean isComplete = false;
    String cdEventStatus = ContextHelper.getStringSafe(request, "cdEventStatus");
    if (cdEventStatus != null) {
      isComplete = cdEventStatus.equals(EVENT_STATUS_COMP);
    }

    AdoptionInformationRetrieveSO adoptioninfoRetrieveSO = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                              request);
    AdoptionInformationSaveSI adoptioninfoSaveSI = new AdoptionInformationSaveSI();
    List<AdoptionResourceBean> resBeanList = new ArrayList<AdoptionResourceBean>();
    String fieldName = null;
    int numOfResources = ContextHelper.getIntSafe(request, "numOfResources");
    try {
      ROWCCMN01UIG00 adoptioninfoEvent = new ROWCCMN01UIG00();
      // adoptioninfoSaveSI.setComplete(isComplete);
      if (ContextHelper.getString(request, "btnComplete.x") != null || isComplete) {
        adoptioninfoEvent.setSzCdEventStatus(EVENT_STATUS_COMP);
      } else {
        adoptioninfoEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
      }

      adoptioninfoEvent.setSzCdEventType(NO_EVENT_TYPE);
      adoptioninfoEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      adoptioninfoEvent.setUlIdStage(GlobalData.getUlIdStage(request));
      adoptioninfoEvent.setUlIdPerson(user.getUserID());
      adoptioninfoEvent.setSzTxtEventDescr(EVENT_DESC_NO);
      adoptioninfoEvent.setSzCdTask(GlobalData.getSzCdTask(request));
      adoptioninfoEvent.setUlIdEvent(idEvent);
      adoptioninfoEvent.setTsLastUpdate(adoptioninfoRetrieveSO.getDtLastUpdate());
      adoptioninfoSaveSI.setRowCCMN01UIG00(adoptioninfoEvent);

      adoptioninfoSaveSI.setSzCdReasonChildNonAvail(ContextHelper.getStringSafe(request, "szCdReasonChildNonAvail"));
      if (!("".equals(ContextHelper.getStringSafe(request, "dtFostParNotAgTPR")))) {
        adoptioninfoSaveSI.setDtFostParNotAgTPR(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                  "dtFostParNotAgTPR")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtPermStaffFostPar")))) {
        adoptioninfoSaveSI.setDtPermStaffFostPar(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                   "dtPermStaffFostPar")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtFostParNotAgDecAdpt")))) {
        adoptioninfoSaveSI.setDtFostParNotAgDecAdpt(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                      "dtFostParNotAgDecAdpt")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtChildLifeHistPres")))) {
        adoptioninfoSaveSI.setDtChildLifeHistPres(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                    "dtChildLifeHistPres")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtStaffAdptFam")))) {
        adoptioninfoSaveSI.setDtStaffAdptFam(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                               "dtStaffAdptFam")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtAdptPlacAgmtSigned")))) {
        adoptioninfoSaveSI.setDtAdptPlacAgmtSigned(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                     "dtAdptPlacAgmtSigned")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtDocSentAttor")))) {
        adoptioninfoSaveSI.setDtDocSentAttor(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                               "dtDocSentAttor")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtPermFileLetterComp")))) {
        adoptioninfoSaveSI.setDtPermFileLetterComp(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                     "dtPermFileLetterComp")));
      }

      if (!("".equals(ContextHelper.getStringSafe(request, "dtSelectionLetterSent")))) {
        adoptioninfoSaveSI.setDtLetterSent((DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                              "dtSelectionLetterSent"))));
      }

      String indIdentifiedAdopRes = ContextHelper.getStringSafe(request, "indIdentifiedAdopRes");
      adoptioninfoSaveSI.setIndIdentifiedAdopRes(indIdentifiedAdopRes);
      adoptioninfoSaveSI.setSzCdCounty(ContextHelper.getStringSafe(request, "txtSzCounty"));
      adoptioninfoSaveSI.setSzCdState(ContextHelper.getStringSafe(request, "txtSzICPCState"));
      adoptioninfoSaveSI.setNMAgency(ContextHelper.getStringSafe(request, "txtSzNmPrAgency"));
      adoptioninfoSaveSI.setIndOutofTown(ContextHelper.getStringSafe(request, "indOutofTown"));
      adoptioninfoSaveSI.setIndIdentifiedAdopRes(ContextHelper.getStringSafe(request, "indIdentifiedAdopRes"));

      if (StringHelper.isValid(indIdentifiedAdopRes)) {
        adoptioninfoSaveSI.setResourceIdForPullback(ContextHelper.getIntSafe(request, "hdnResourceId"));
      }
      adoptioninfoSaveSI.setNMResource(ContextHelper.getStringSafe(request, "txtSzNmAdpRes"));
      adoptioninfoSaveSI.setIndOtherSiblingsAdopted(ContextHelper.getStringSafe(request, "indOtherSiblingsAdopted"));
      adoptioninfoSaveSI.setNmFamConsidered(ContextHelper.getIntSafe(request, "nmFamConsidered"));
      adoptioninfoSaveSI.setSzCdReasonsFamNotSel(ContextHelper.getStringSafe(request, "szCdReasonsFamNotSel"));
      adoptioninfoSaveSI.setSzCdTypeAdptRsrcNeeded(ContextHelper.getStringSafe(request, "szCdTypeAdptRsrcNeeded"));
      adoptioninfoSaveSI.setSzCdComntsPrepAct(ContextHelper.getStringSafe(request, "szCdComntsPrepAct"));
      adoptioninfoSaveSI.setSzCdComntsBarRec(ContextHelper.getStringSafe(request, "szCdComntsBarRec"));
      adoptioninfoSaveSI.setSzCdComntsRecActsCounty(ContextHelper.getStringSafe(request, "szCdComntsRecActsCounty"));
      adoptioninfoSaveSI.setSzCdComntsBarPla(ContextHelper.getStringSafe(request, "szCdComntsBarPla"));
      adoptioninfoSaveSI.setSzCdComntsBarTpr(ContextHelper.getStringSafe(request, "szCdComntsBarTpr"));
      adoptioninfoSaveSI.setSzCdChildLinked(ContextHelper.getStringSafe(request, "szCdChildLinked"));
      adoptioninfoSaveSI.setSzCdExchConsidered(ContextHelper.getStringSafe(request, "szCdExchConsidered"));
      adoptioninfoSaveSI.setIndAdoptOutcome(ContextHelper.getStringSafe(request, "indAdoptOutcome"));
      adoptioninfoSaveSI.setIndAdoptOutcomePre(adoptioninfoRetrieveSO.getIndAdoptOutcome());
      adoptioninfoSaveSI.setSzCdCountyConsidered(ContextHelper.getStringSafe(request, "szCdCountyConsideredComments"));
      String[] checkedPreperationActivities = CheckboxHelper.getCheckedValues(request, "chkPreperationActivities");
      adoptioninfoSaveSI.setChkPreperationActivities(checkedPreperationActivities);
      String[] checkedBarriersRecruitment = CheckboxHelper.getCheckedValues(request, "chkBarriersRecruitment");
      adoptioninfoSaveSI.setChkBarriersRecruitment(checkedBarriersRecruitment);
      // MR-092 set sibling with open ADO in another case questions
      adoptioninfoSaveSI.setIndHasSiblingExtCase(ContextHelper.getStringSafe(request, "rbHasSiblingExtCase"));
      adoptioninfoSaveSI.setIndSiblingGrpExtCase(ContextHelper.getStringSafe(request, "rbSiblingGrpExtCase"));
      // MR-083
      // Setting the recruitment Activities dates from request.
      Collection<String> actList = new ArrayList<String>();
      Map<String, List<AdoInfoCbxSentStruct>> modifiedRecActivitiesDates = new HashMap<String, List<AdoInfoCbxSentStruct>>();
      Map<String, Date> newRecActivityDate = new HashMap<String, Date>();

      try {
        // get all possible recruitment activity codes
        actList = Lookup.getCategoryCodesCollection(CodesTables.CADRACC);

        if (actList != null && !actList.isEmpty()) {
          Iterator<String> it = actList.iterator();

          // loop through each activity code
          while (it.hasNext()) {
            String actCode = it.next();

            // get the date calendar field value if any
            Date newRecActDate = ContextHelper.getJavaDateSafe(request, "dtRecActCounty" + actCode);
            newRecActivityDate.put(actCode, newRecActDate);

            // get the each of the recruitment activities 10 date fields for any updates or additions
            List<AdoInfoCbxSentStruct> adoInfoCbxSentStructList = new ArrayList<AdoInfoCbxSentStruct>();

            // loop through each set of 10 dates that ends with actCode
            for (int i = 0; i < 10; i++) {
              String attrNameId = "Date#_idAdoInfoCbxSent" + actCode;
              attrNameId = attrNameId.replace("#", String.valueOf(i));

              String attrName = "Date#_dtRecActCounty" + actCode;
              attrName = attrName.replace("#", String.valueOf(i));

              // retrieve each recruitment activity date from request and add to list in order
              Date dtRecAct = ContextHelper.getJavaDateSafe(request, attrName);
              int idRecAct = ContextHelper.getIntSafe(request, attrNameId);

              AdoInfoCbxSentStruct adoInfoCbxSentStruct = null;

              // if no date entered AND field was not populated initially
              // then adoInfoCbxSentStruct should remain null
              if (!(dtRecAct == null && idRecAct == 0)) {
                adoInfoCbxSentStruct = new AdoInfoCbxSentStruct();
                adoInfoCbxSentStruct.setIdAdoInfoCbxSent(idRecAct);
                adoInfoCbxSentStruct.setIdEvent(GlobalData.getUlIdEvent(request));
                adoInfoCbxSentStruct.setCdCbxCodeType(CodesTables.CADRACC);
                adoInfoCbxSentStruct.setCdAdoInfoCbx(actCode);
                adoInfoCbxSentStruct.setDtAdoInfoCbxSent(dtRecAct);
              }

              adoInfoCbxSentStructList.add(adoInfoCbxSentStruct);
            } // end for loop
            modifiedRecActivitiesDates.put(actCode, adoInfoCbxSentStructList);
          } // end while it
        } // end if
      } catch (LookupException e) {
        // if lookup exception then no changes should be made. Set maps to null to indicate
        // something went wrong and we do not want to delete existing
        // dates. There is a difference between null maps vs maps with null values.
        // Save service need to check for state of these maps.
        newRecActivityDate = null;
        modifiedRecActivitiesDates = null;
      }

      adoptioninfoSaveSI.setNewRecActivityDate(newRecActivityDate);
      adoptioninfoSaveSI.setModifiedRecActivitiesDates(modifiedRecActivitiesDates);

      String[] checkedBarriersPlacement = CheckboxHelper.getCheckedValues(request, "chkBarriersPlacement");
      adoptioninfoSaveSI.setChkBarriersPlacement(checkedBarriersPlacement);
      String[] checkedBarriersTpr = CheckboxHelper.getCheckedValues(request, "chkBarriersTPR");
      adoptioninfoSaveSI.setChkBarriersTPR(checkedBarriersTpr);
      adoptioninfoSaveSI.setDtLastUpdate(adoptioninfoRetrieveSO.getDtLastUpdate());
      adoptioninfoSaveSI.setUlIdEvent(idEvent);
      adoptioninfoSaveSI.setUlIdStage(GlobalData.getUlIdStage(request));
      adoptioninfoSaveSI.setUlIdCase(GlobalData.getUlIdCase(request));
      adoptioninfoSaveSI.setUlIdPerson(user.getUserID());
      adoptioninfoSaveSI.setAttrSocialServicesStaff(SEC_REGIONAL_SS_STF);
      adoptioninfoSaveSI.setAttrstateOficeConsultant(SEC_STATE_OFFICE_CONSULTANT);
      adoptioninfoSaveSI.setResourceIdForPullbackPre(adoptioninfoRetrieveSO.getInitialResourceIdForPullback());
      adoptioninfoSaveSI.setDtAdptPlacAgmtSignedPre(adoptioninfoRetrieveSO.getDtAdptPlacAgmtSigned());
      adoptioninfoSaveSI.setDtDocSentAttorPre(adoptioninfoRetrieveSO.getDtDocSentAttor());
      adoptioninfoSaveSI.setDtPermFileLetterCompPre(adoptioninfoRetrieveSO.getDtPermFileLetterComp());
      adoptioninfoSaveSI.setIdChildRegistrationEvent(adoptioninfoRetrieveSO.getUlIdChildRegEvent());

      if (numOfResources != 0) {
        AdoptionResourceBean resBean = new AdoptionResourceBean();
        fieldName = "hdnResourceId";
        if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
          resBean.setIdResource(ContextHelper.getIntSafe(request, fieldName));
        }
        fieldName = "hdnNmResource";
        if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
          resBean.setNmResource(ContextHelper.getStringSafe(request, fieldName));
        }
        resBeanList.add(resBean);
      }
      adoptioninfoSaveSI.setIdenResList(resBeanList);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return adoptioninfoSaveSI;
  }

  /**
   * Populates the Adoption Information details for the Retrieve.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private AdoptionInformationRetrieveSI populateAdoptionInformationRetrieveSI_Retrieve(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             "populateAdoptionInformationRetrieveSI_Retrieve");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    AdoptionInformationRetrieveSI adoptioninformationRetrieveSI = new AdoptionInformationRetrieveSI();
    adoptioninformationRetrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    adoptioninformationRetrieveSI.setUlIdStage(GlobalData.getUlIdStage(request));
    adoptioninformationRetrieveSI.setUlIdCase(GlobalData.getUlIdCase(request));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return adoptioninformationRetrieveSI;
  }

  /**
   * Stage Access Rights
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /**
   * Populates the Adoption Information details for the maintaining the state.
   * 
   * @param request
   *          The HttpServletRequest object.
   * @param adoptioninformationRetrieveSO
   *          The AdoptionInformationRetrieveSO object.
   */
  protected static void populateAdoptionInfo(HttpServletRequest request,
                                             AdoptionInformationRetrieveSO adoptioninformationRetrieveSO) {

    int numOfResources = ContextHelper.getIntSafe(request, "numOfResources");
    String fieldName = null;
    List<AdoptionResourceBean> resBeanList = new ArrayList<AdoptionResourceBean>();
    try {

      if (request.getParameter("rbHasSiblingExtCase") != null
          && !"".equals(request.getParameter("rbHasSiblingExtCase"))) {
        adoptioninformationRetrieveSO.setIndHasSiblingExtCase(ContextHelper.getStringSafe(request,
                                                                                          "rbHasSiblingExtCase"));
      }
      if (request.getParameter("rbSiblingGrpExtCase") != null
          && !"".equals(request.getParameter("rbSiblingGrpExtCase"))) {
        adoptioninformationRetrieveSO.setIndSiblingGrpExtCase(ContextHelper.getStringSafe(request,
                                                                                          "rbSiblingGrpExtCase"));
      }
      if (request.getParameter("szCdReasonChildNonAvail") != null
          && !"".equals(request.getParameter("szCdReasonChildNonAvail"))) {

        adoptioninformationRetrieveSO.setSzCdReasonChildNonAvail(ContextHelper.getStringSafe(request,
                                                                                             "szCdReasonChildNonAvail"));
      }
      if (request.getParameter("dtFostParNotAgTPR") != null && !"".equals(request.getParameter("dtFostParNotAgTPR"))) {
        adoptioninformationRetrieveSO.setDtFostParNotAgTPR(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                             "dtFostParNotAgTPR")));
      }
      if (request.getParameter("dtPermStaffFostPar") != null && !"".equals(request.getParameter("dtPermStaffFostPar"))) {
        adoptioninformationRetrieveSO.setDtPermStaffFostPar(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                              "dtPermStaffFostPar")));

      }
      if (request.getParameter("dtFostParNotAgDecAdpt") != null
          && !"".equals(request.getParameter("dtFostParNotAgDecAdpt"))) {
        adoptioninformationRetrieveSO.setDtFostParNotAgDecAdpt(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                                 "dtFostParNotAgDecAdpt")));
      }
      if (request.getParameter("dtChildLifeHistPres") != null
          && !"".equals(request.getParameter("dtChildLifeHistPres"))) {
        adoptioninformationRetrieveSO.setDtChildLifeHistPres(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                               "dtChildLifeHistPres")));
      }
      if (request.getParameter("dtStaffAdptFam") != null && !"".equals(request.getParameter("dtStaffAdptFam"))) {
        adoptioninformationRetrieveSO.setDtStaffAdptFam(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                          "dtStaffAdptFam")));
      }
      if (request.getParameter("dtAdptPlacAgmtSigned") != null
          && !"".equals(request.getParameter("dtAdptPlacAgmtSigned"))) {
        adoptioninformationRetrieveSO.setDtAdptPlacAgmtSigned(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                                "dtAdptPlacAgmtSigned")));
      }
      if (request.getParameter("dtDocSentAttor") != null && !"".equals(request.getParameter("dtDocSentAttor"))) {
        adoptioninformationRetrieveSO.setDtDocSentAttor(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                          "dtDocSentAttor")));
      }
      if (request.getParameter("dtPermFileLetterComp") != null
          && !"".equals(request.getParameter("dtPermFileLetterComp"))) {
        adoptioninformationRetrieveSO.setDtPermFileLetterComp(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                                "dtPermFileLetterComp")));
      }
      if (request.getParameter("indIdentifiedAdopRes") != null
          && !"".equals(request.getParameter("indIdentifiedAdopRes"))) {
        adoptioninformationRetrieveSO.setIndIdentifiedAdopRes(ContextHelper.getStringSafe(request,
                                                                                          "indIdentifiedAdopRes"));
      }
      if (request.getParameter("txtSzCounty") != null && !"".equals(request.getParameter("txtSzCounty"))) {
        adoptioninformationRetrieveSO.setSzCdCounty(ContextHelper.getStringSafe(request, "txtSzCounty"));
      }
      if (request.getParameter("txtSzICPCState") != null && !"".equals(request.getParameter("txtSzICPCState"))) {
        adoptioninformationRetrieveSO.setSzCdState(ContextHelper.getStringSafe(request, "txtSzICPCState"));
      }
      if (request.getParameter("txtSzNmPrAgency") != null && !"".equals(request.getParameter("txtSzNmPrAgency"))) {
        adoptioninformationRetrieveSO.setNMAgency(ContextHelper.getStringSafe(request, "txtSzNmPrAgency"));
      }
      if (request.getParameter("indOutofTown") != null && !"".equals(request.getParameter("indOutofTown"))) {
        adoptioninformationRetrieveSO.setIndOutofTown(ContextHelper.getStringSafe(request, "indOutofTown"));
      }
      if (request.getParameter("indIdentifiedAdopRes") != null
          && !"".equals(request.getParameter("indIdentifiedAdopRes"))) {
        adoptioninformationRetrieveSO.setIndIdentifiedAdopRes(ContextHelper.getStringSafe(request,
                                                                                          "indIdentifiedAdopRes"));
      }
      if (request.getParameter("hdnResourceId") != null && !"".equals(request.getParameter("hdnResourceId"))) {
        adoptioninformationRetrieveSO.setResourceIdForPullback(ContextHelper.getIntSafe(request, "hdnResourceId"));
      }
      if (request.getParameter("txtSzNmAdpRes") != null && !"".equals(request.getParameter("txtSzNmAdpRes"))) {
        adoptioninformationRetrieveSO.setNMResource(ContextHelper.getStringSafe(request, "txtSzNmAdpRes"));
      }
      if (request.getParameter("indOtherSiblingsAdopted") != null
          && !"".equals(request.getParameter("indOtherSiblingsAdopted"))) {
        adoptioninformationRetrieveSO.setIndOtherSiblingsAdopted(ContextHelper.getStringSafe(request,
                                                                                             "indOtherSiblingsAdopted"));
      }
      if (request.getParameter("nmFamConsidered") != null && !"".equals(request.getParameter("nmFamConsidered"))) {
        adoptioninformationRetrieveSO.setNmFamConsidered(ContextHelper.getIntSafe(request, "nmFamConsidered"));
      }
      if (request.getParameter("szCdReasonsFamNotSel") != null
          && !"".equals(request.getParameter("szCdReasonsFamNotSel"))) {
        adoptioninformationRetrieveSO.setSzCdReasonsFamNotSel(ContextHelper.getStringSafe(request,
                                                                                          "szCdReasonsFamNotSel"));
      }
      if (request.getParameter("szCdTypeAdptRsrcNeeded") != null
          && !"".equals(request.getParameter("szCdTypeAdptRsrcNeeded"))) {
        adoptioninformationRetrieveSO.setSzCdTypeAdptRsrcNeeded(ContextHelper.getStringSafe(request,
                                                                                            "szCdTypeAdptRsrcNeeded"));
      }
      if (request.getParameter("szCdComntsPrepAct") != null && !"".equals(request.getParameter("szCdComntsPrepAct"))) {
        adoptioninformationRetrieveSO.setSzCdComntsPrepAct(ContextHelper.getStringSafe(request, "szCdComntsPrepAct"));
      }
      if (request.getParameter("szCdComntsBarRec") != null && !"".equals(request.getParameter("szCdComntsBarRec"))) {
        adoptioninformationRetrieveSO.setSzCdComntsBarRec(ContextHelper.getStringSafe(request, "szCdComntsBarRec"));
      }
      if (request.getParameter("szCdComntsRecActsState") != null
          && !"".equals(request.getParameter("szCdComntsRecActsState"))) {
        adoptioninformationRetrieveSO.setSzCdComntsRecActsState(ContextHelper.getStringSafe(request,
                                                                                            "szCdComntsRecActsState"));
      }
      if (request.getParameter("szCdComntsRecActsCounty") != null
          && !"".equals(request.getParameter("szCdComntsRecActsCounty"))) {
        adoptioninformationRetrieveSO.setSzCdComntsRecActsCounty(ContextHelper.getStringSafe(request,
                                                                                             "szCdComntsRecActsCounty"));
      }
      if (request.getParameter("szCdComntsBarPla") != null && !"".equals(request.getParameter("szCdComntsBarPla"))) {
        adoptioninformationRetrieveSO.setSzCdComntsBarPla(ContextHelper.getStringSafe(request, "szCdComntsBarPla"));
      }
      if (request.getParameter("szCdComntsBarTpr") != null && !"".equals(request.getParameter("szCdComntsBarTpr"))) {
        adoptioninformationRetrieveSO.setSzCdComntsBarTpr(ContextHelper.getStringSafe(request, "szCdComntsBarTpr"));
      }
      String[] checkedPreperationActivities = CheckboxHelper.getCheckedValues(request, "chkPreperationActivities");
      if (checkedPreperationActivities.length != 0) {
        adoptioninformationRetrieveSO.setChkPreperationActivities(checkedPreperationActivities);
      }
      String[] checkedBarriersRecruitment = CheckboxHelper.getCheckedValues(request, "chkBarriersRecruitment");
      if (checkedBarriersRecruitment.length != 0) {
        adoptioninformationRetrieveSO.setChkBarriersRecruitment(checkedBarriersRecruitment);
      }
      String[] checkedBarriersPlacement = CheckboxHelper.getCheckedValues(request, "chkBarriersPlacement");
      if (checkedBarriersPlacement.length != 0) {
        adoptioninformationRetrieveSO.setChkBarriersPlacement(checkedBarriersPlacement);
      }
      String[] checkedBarriersTPR = CheckboxHelper.getCheckedValues(request, "chkBarriersTPR");
      if (checkedBarriersTPR.length != 0) {
        adoptioninformationRetrieveSO.setChkBarriersTPR(checkedBarriersTPR);
      }
      for (int i = 0; i < numOfResources; i++) {
        AdoptionResourceBean resBean = new AdoptionResourceBean();
        fieldName = "hdnIdResource" + i;
        if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
          resBean.setIdResource(ContextHelper.getIntSafe(request, fieldName));
        }
        fieldName = "hdnNmResource" + i;
        if (request.getParameter(fieldName) != null && !"".equals(request.getParameter(fieldName))) {
          resBean.setNmResource(ContextHelper.getStringSafe(request, fieldName));
        }
        resBeanList.add(resBean);
      }
      adoptioninformationRetrieveSO.setIdenResList(resBeanList);
      request.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO);
    } catch (Exception e) {
      e.getMessage();
    }

  }

  public SiblingGroupInformationSI populateSiblingGroupInformationSaveSI(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    SiblingGroupInformationSI siblingGroupInformationSI = new SiblingGroupInformationSI();

    siblingGroupInformationSI.setSiblingMappedToExistingGroups(new HashMap<SiblingSI, Integer>());

    /* get the initial groupings from adoption information ret */
    AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = (AdoptionInformationRetrieveSO) state.getAttribute("AdoptionInformationRetrieveSO",
                                                                                                                     request);
    SiblingGroupInformationSO siblingGroupInformationSO = adoptioninformationRetrieveSO.getSiblingGroupInformation();

    if (siblingGroupInformationSO == null) {
      // STGAP00011367: no sibling group info to update
      return null;
    }
    /* get checked siblinggroup_sibling fields */
    String[] checked_existing_SiblingGroups_Siblings = CheckboxHelper.getCheckedValues(request, "cbx_sibling_");

    List<SiblingSI> existingSiblings = new ArrayList<SiblingSI>();

    /* get checked new siblingroup_sibling fields */
    String[] checked_new_SiblingGroups_Siblings = CheckboxHelper.getCheckedValues(request, "cbx_New_PG");

    /* build input list for existing groupings */
    for (int i = 0; i < checked_existing_SiblingGroups_Siblings.length; ++i) {
      StringTokenizer st = new StringTokenizer(checked_existing_SiblingGroups_Siblings[i], "_");

      Integer idSiblingGroupInteger = new Integer(st.nextToken());
      Integer idPersonInteger = new Integer(st.nextToken());

      SiblingSI siblingSI = new SiblingSI();
      siblingSI.setIdPerson(idPersonInteger.intValue());
      siblingSI.setIdSiblingGroup(idSiblingGroupInteger.intValue());

      existingSiblings.add(siblingSI);

    }

    Map<SiblingSI, Integer> newGroupingsToSave = new HashMap<SiblingSI, Integer>();
    List<SiblingSI> newSiblingsToSave = new ArrayList<SiblingSI>();

    /* build input groupings for new Siblings */
    for (int i = 0; i < checked_new_SiblingGroups_Siblings.length; ++i) {
      StringTokenizer st = new StringTokenizer(checked_new_SiblingGroups_Siblings[i], "_");

      Integer indexOfNewSiblingGroup = new Integer(st.nextToken());
      Integer idPersonInteger = new Integer(st.nextToken());

      SiblingSI siblingSI = new SiblingSI();
      siblingSI.setIdPerson(idPersonInteger.intValue());

      newGroupingsToSave.put(siblingSI, indexOfNewSiblingGroup);
      newSiblingsToSave.add(siblingSI);
    }

    siblingGroupInformationSI.setNumOfNewSiblingGroupsToSave(siblingGroupInformationSO.getNumOfNewSiblingGroups());
    siblingGroupInformationSI.setSiblingsToSaveInExistingGroups(existingSiblings);
    siblingGroupInformationSI.setSiblingsToSaveInNewGroups(newSiblingsToSave);
    siblingGroupInformationSI.setSiblingsMappedToNewGroups(newGroupingsToSave);
    
    // MR-092 Populate sibling with an open ADO in another case list
    List<SiblingExternalLinkStruct> siblingExternalLinkStructList = new ArrayList<SiblingExternalLinkStruct>();
    
    if (siblingGroupInformationSO != null) {
      Map<Integer, Integer> prnChildrenUnder18WithAnotherAdoCase = adoptioninformationRetrieveSO.getPrnChildrenUnder18WithAnotherAdoCase();
      Set<Integer> prnKeySet = prnChildrenUnder18WithAnotherAdoCase.keySet();
      Iterator<Integer> prnIter = prnKeySet.iterator();
      
      while(prnIter.hasNext()){
        Integer idPersonFromMap = prnIter.next();
        for(int i = 0; i < prnChildrenUnder18WithAnotherAdoCase.size(); i++){
          int idPersonFromRequest = ContextHelper.getIntSafe(request, "selSiblingsExtCase_" + i);
          
          if(idPersonFromRequest > 0 && idPersonFromMap == idPersonFromRequest){
            SiblingExternalLinkStruct siblingExtLnk = new SiblingExternalLinkStruct();
            siblingExtLnk.setIdPerson(idPersonFromMap);
            siblingExtLnk.setIdSiblingExternalStage(prnChildrenUnder18WithAnotherAdoCase.get(idPersonFromMap));
            // At this point we don't know the Primary child placement group id
            // it may have been changed, so we're setting to zero for now to be populated later during save.
            siblingExtLnk.setIdSiblingGroup(0);
            siblingExternalLinkStructList.add(siblingExtLnk);
          }
        }
      }
    }
    siblingGroupInformationSI.setSiblingExternalLinkStructList(siblingExternalLinkStructList);

    // set all siblings retrieved to be saved in the output struct

    // (){
    // siblingGroupInformationSI.setAllSiblingsList(siblingGroupInformationSO.getAllSiblingsRetrievedSOList());
    // }
    //
    // siblingGroupInformationSI
    // .setSiblingPlacementGroups(new ArrayList<SiblingPlacementGroupSI>());
    siblingGroupInformationSI.setIdAdoInfoEvent(adoptioninformationRetrieveSO.getUlIdEvent());

    siblingGroupInformationSI.setInitialRegisteredChildMap(siblingGroupInformationSO.getRegisteredChildMap());

    return siblingGroupInformationSI;
  }

}
