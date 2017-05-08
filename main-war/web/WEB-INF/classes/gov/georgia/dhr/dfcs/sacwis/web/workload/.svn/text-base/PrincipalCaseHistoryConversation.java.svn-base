package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseInfoDB;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CaseLinkDB;
import gov.georgia.dhr.dfcs.sacwis.service.person.PrincipalCaseHistory;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class used to display Principal Case History Page.
 *
 * @author Vijaya Anand
 * @version 1.0
 *          <p/>
 *          Change History: Date      User     Description -------  --------  ------------------------------------
 *          04/08/05  ANANDV   SIR 23522 - PrincipalCaseHistoryConversation for Principal Case History Information Page
 *          <p/>
 *          05/09/05  ANANDV   SIR 23522 - Added condition to display Reports Section on PCH page. 05/16/05  ANANDV SIR
 *          23522 - Added conditions to Insert/Update Parent Child Relationship record as well as Child Parent Relations
 *          ship records. 05/17/06  ANANDV   SIR 23522 - Modified to update Global User Id into CASE_LINK table instead
 *          of using caseInfoDB.getPersonUpdate().
 */

public class PrincipalCaseHistoryConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "PrincipalCaseHistoryConversation";
  public static final String HIDE_PRNLIST = "hidePrincipalList";
  PrincipalCaseHistory caseEJB = null;

  public void setCaseEJB(PrincipalCaseHistory caseEJB) {
    this.caseEJB = caseEJB;
  }

  /**
   * displayCaseList
   * <p/>
   * This method used to populate the Initilal Case List Information based on the user selection CASE ID. Also this
   * method used to set the Page Mode VIEW or MODIFY depends upon the User Access. This method will call
   * PrinciplaCaseEJB to get Case List Information.
   *
   * @param context The GrndsExchangeContext Object
   */
  public List displayCaseList_xa(GrndsExchangeContext context) {
    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "caseListSection");
    performTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    List caseInfoList = new ArrayList();

    //Get the profile of the logged in user
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      // Clear state
      state.removeAllAttributes(request);

      performTrace.getElapsedTime();
      int globalCaseID = GlobalData.getUlIdCase(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      if (globalCaseID > 0) {
        //Call EJB to get Case List
        caseInfoList = caseEJB.caseList(globalCaseID);

        //Setting the Informational Message
        setInformationalMessage(Messages.MSG_PCH_NOT_SAME_FAMILY, request);

        // Based on the User Profile Check whether the user has a access
        // to View Or Edit  the page
        if (CaseUtility.hasStageAccess(user.getUserID(), ulIdStage) ||
            user.hasRight(UserProfile.SEC_MERGE_CASES)) {
          PageMode.setPageMode(PageModeConstants.MODIFY, request);
        } else {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }

        if (caseInfoList.size() > 0) {
          //Set the Case List object into state
          state.setAttribute("displayCaseList", caseInfoList, request);

          // set the Principal List section as an attribute on the request
          // it should not display untill the user select the radio button.
          request.setAttribute(HIDE_PRNLIST, "true");

          performTrace.getElapsedTime(
                  " Time for displayCaseList_xa SQL execution.");
        }

      } //ending if

    } catch (Exception excep) {
      processSevereException(context, excep);
    }
    return caseInfoList;

  } // displayCaseList_xa()

  /**
   * displayPrincipalListInfo
   * <p/>
   * The Principal List section will be populated when the radio button for a case is selected.  The persons will be
   * grouped by stage, and then listed in the default person list order.
   *
   * @param context The GrndsExchangeContext Object
   */
  public List selectPrincipalList_xa(GrndsExchangeContext context) {

    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "selectPrincipalListInfo");
    performTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    List principal = new ArrayList();
    performTrace.getElapsedTime();
    try {
      int globalCaseID = GlobalData.getUlIdCase(request);
      //getting Radio button value
      int idCASE = ContextHelper.getIntSafe(request, "hdnRadioValue");

      if (idCASE > 0 && globalCaseID > 0) {
        //call ejb selectPrincipalList to get Principal List Object
        principal = caseEJB.selectPrincipalList(idCASE, globalCaseID);

        if (principal.size() > 0) {
          // Set the Principal List object into state
          state.setAttribute("displayPrincipalListInfo", principal, request);

          // Set the selected Radio Value into state
          state.setAttribute("selectedRadioValue", idCASE, request);

          performTrace.getElapsedTime(
                  " Time for selectPrincipalList_xa SQL execution.");
        }
      }
    } catch (Exception excep) {
      GrndsTrace.msg(TRACE_TAG, 7, "selectPrincipalListInfo:" + excep.getMessage());
      processSevereException(context, excep);
    }

    return principal;

  }

  /**
   * This method will call from Workload Servlet to execute SAVE OR UPDATE This method used to save the Link Cases to
   * the primary case by checking the Link Check box. Also this method will check in the ArrayList whether the Case ID
   * is already checked or unchecked. If the Linked CASE ID is already checked in the table now the user unchecked it
   * will go and update or if the Linked Case ID is unchecked in the table if user selects now it will inser the Linked
   * Case information into Case Link table.
   * <p/>
   * For Update we are passing the parameters
   *
   * @param context
   */
  public void saveCaseInfo_xa(GrndsExchangeContext context) {

    PerformanceTrace performTrace = new PerformanceTrace(TRACE_TAG, "saveCaseInfo");
    performTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CaseLinkDB caseLinkDB;
    ArrayList saveList = null;
    String chkLink;
    CaseInfoDB caseInfoDB;
    String indicator = null;
    performTrace.getElapsedTime();
    int globalUserID = 0;
    try {
      // Get the CaseList  to check whether IND Linked Check is checked or unchecked.
      // If it is checked then the Ind + Case ID needs to save it in the CASE LINK
      // table. If already checked, now it is unchecked then it needs to update
      // in the same table based on the case id.
      if (state.getAttribute("displayCaseList", request) != null) {
        //get the displayCaseList Object from state
        saveList = (ArrayList) state.getAttribute("displayCaseList", request);
      }
      if (saveList.size() > 0) {
        Iterator saveIter = saveList.iterator();
        while (saveIter.hasNext()) {
          //using Iterator get all checked & unchecked values from
          // the saveList Object and assign to CaseInfoDB.
          caseInfoDB = (CaseInfoDB) saveIter.next();
          int iCase = caseInfoDB.getCaseID();
          if (user.getUserID() > 0) {
            globalUserID = user.getUserID();
          }

          //get the selected Link Check or Uncheck box value
          chkLink = request.getParameter("" + caseInfoDB.getCaseID());

          // The whole process executes like - For each Case IDs
          // if checkbox is checked now, previously
          // it is not checked then it will call populateSaveCaseLink for each
          // Case ID.
          // if Checkbox is unchecked now, previously
          // it is checked then it will call populateUpdCaseInfo for each CaseID.
          // if checkbox is unchecked now, previousley
          // it is unchecked then it will continue the process flow.

          // if check box value is null setting the indicator to N.
          if (chkLink == null) {
            indicator = "N";
          } else if ("true".equalsIgnoreCase(chkLink)) {
            // if check box is unchecked then it will continue the process
            // flow of next record.
            continue;
          } else if ("false".equalsIgnoreCase(chkLink)) {
            // if check box is selected then indicator will be Y.
            indicator = "Y";
          }

          // get the previous checkbox value from CaseInfoDB
          String prevInd = caseInfoDB.getIndCaseLink();

          // if previously it is not null and set the indicator to Y or N it will
          // call populateUpdCaseInfo process.
          if (prevInd != null && indicator != null && ("Y".equals(indicator) ||
                                                       "N".equals(indicator))) {
            // call the update process
            if (!prevInd.equals(indicator)) {
              // SIR 23522- Modified to update Global User Id instead of
              // caseInfoDB.getPersonUpdate() added on 05/17/2007

              populateUpdCaseInfo(indicator, globalUserID, caseInfoDB.getLinkedCase(), context);

            }
            performTrace.getElapsedTime(
                    " Time for saveCaseInfo_xa  INSERT SQL execution.");
          } else // if previously it is not null now it is checked then call populateSaveCaseLink
            if (prevInd == null && indicator != null && "Y".equals(indicator)) {

              caseLinkDB = new CaseLinkDB();

              // calling the populateSaveCaseLink to execute for each Case Id.
              populateSaveCaseLink(caseLinkDB, indicator, context, iCase);
              performTrace.getElapsedTime(
                      " Time for saveCaseInfo_xa UPDATE SQL execution.");
            }

        }

      }

    } catch (Exception excep) {
      GrndsTrace.msg(TRACE_TAG, 7, "saveCaseInfo:" + excep.getMessage());
      processSevereException(context, excep);
    }

  }

  /**
   * This method will insert the checked Linked Case Information into CASE LINK table.
   *
   * @param caseLinkDB
   * @param indicator
   * @param context
   * @param iCase
   */
  public void populateSaveCaseLink(CaseLinkDB caseLinkDB, String indicator, GrndsExchangeContext context, int iCase) {
    HttpServletRequest request = context.getRequest();
    List<CaseLinkDB> saveList = new ArrayList<CaseLinkDB>();
    int iMainCaseID;
    UserProfile user = UserProfileHelper.getUserProfile(request);
    iMainCaseID = GlobalData.getUlIdCase(request);

    if (iMainCaseID > 0) {
      //set all the values to CaseLinkDB
      caseLinkDB.setMainCaseID(iMainCaseID);
      caseLinkDB.setIndCaseLink(indicator);
      caseLinkDB.setLinkCaseID(iCase);
    }
    if (user.getUserID() > 0) {
      //set userid value to CaseLinkDB
      caseLinkDB.setPersonUpdate(user.getUserID());
    }
    if (caseLinkDB != null) {
      //add CaseLinkDB to saveList
      saveList.add(caseLinkDB);
    }
    try {
      //call EJB and sending checked case link information list.
      caseEJB.saveCaseInfo(saveList);
    } catch (Exception excep) {
      GrndsTrace.msg(TRACE_TAG, 7, "populateSaveCaseLink:" + excep.getMessage());
    }

  }

  /**
   * This method used to update the unchecked Linked Case Information into CASE LINK table.
   *
   * @param indCaseLink
   * @param idUpdate
   * @param idLinkedCase
   * @param context
   */
  public void populateUpdCaseInfo(String indCaseLink, int idUpdate, int idLinkedCase, GrndsExchangeContext context) {
    try {
      HttpServletRequest request = context.getRequest();
      int iMainCaseID = GlobalData.getUlIdCase(request);
      if (indCaseLink != null && idUpdate > 0 && idLinkedCase > 0) {
        //call ejb to update Case Info
        //Added extra iMainCaseID to to update Parent Child Realtionship record
        caseEJB.updateCaseInfo(indCaseLink, idUpdate, idLinkedCase, iMainCaseID);
      }
    } catch (Exception excep) {
      GrndsTrace.msg(TRACE_TAG, 7, "populateUpdCaseInfo:" + excep.getMessage());
    }

  }
}

