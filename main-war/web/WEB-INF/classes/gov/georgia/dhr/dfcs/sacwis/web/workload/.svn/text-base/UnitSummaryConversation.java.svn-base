//*  JSP Name:     Unit Summary Conversation
//*  Created by:   Michael Ochu
//*  Date Created: 12/15/2002
//*
//*  Description:
//*  This Conversation is used to maintain Unit Summary information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/09/05  NALLAVS           SIR 23547 - Removed System.out.println statements.

package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.TempAssignment;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class used by users with appropriate security profile * and approval responsibility for a
 * unit to view their unit's current activity. The * user can then enter their workers' To-Do List and Assigned Workload
 * in order to * view or modify anything within their unit's responsibility. *
 *
 * @author Michael Ochu, Dec 15, 2002
 * 
 * Change History:
 *  Date        User              Description
 *  --------    ---------------   --------------------------------------------------
 *  07/17/08    wjcochran         STGAP00009599: Added data as per MR-017 - Units that are child units
 *                                of the current unit are now loaded as part
 *                                of the searchUnitSummary_xa method.
 *  08/27/08    wjcochran         STGAP00009599: Modified the displayUnitSummary_xa method to clear
 *                                the state at the close of the method so that when the user leaves
 *                                the screen and comes back, the user is presented with the
 *                                default search values and the previous search results are gone.
 *  12/03/08    wjcochran         STGAP00010660: Modified populateCCMN24SO to populate the region attribute.
 */

@SuppressWarnings("serial")
public class UnitSummaryConversation extends BaseHiddenFieldStateConversation {

  private Admin admin;

  // Setter method for Admin
  public void setAdmin(Admin admin1) {
    this.admin = admin1;
  }

  /**
   * This method is called by the GRNDS controller when a user searches for a unit.
   *
   * @param context The GrndsExchangeContext object. The user profile is used to populate the search parameters
   *                therefore no service is called here.
   */

  public void displayUnitSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayUnitSummary_xa()");

    HttpServletRequest request = context.getRequest();

    UnitSummarySearchBean unitSummarySearchBean = UnitSummaryHelper.getUnitSummarySearchBean(request);

    clearState(context);

    if (unitSummarySearchBean != null) {
      // @todo setPresentation
      searchUnitSummary_xa(context);
    }

    request.removeAttribute(UNIT_SUMMARY_BEAN);
    clearState(context);
    performanceTrace.exitScope();
    return;
  }

  /**
   * Searches the database for county - region - unit combination that matches the specified search criteria.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void searchUnitSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".searchUnitSummary_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(MAX_RESULTS_PER_PAGE);

    try {
      CCMN29SI ccmn29si = this.populateCcmn29S(context, tuxPagination);

      UnitSummarySearchBean unitSummarySearchBean = new UnitSummarySearchBean();
      unitSummarySearchBean.setCounty(ccmn29si.getSzCdUnitCounty());
      unitSummarySearchBean.setRegion(ccmn29si.getSzCdUnitRegion());
      unitSummarySearchBean.setUnit(ccmn29si.getSzNbrUnit());
      unitSummarySearchBean.setAssignments(ccmn29si.getCScrIndAsgnTotal());
      // mdm, 5/16/2003, I am putting it both in GlobalData and in request
      // to avoid duplicating populate code in the jsp. The Jsp will remove the
      // bean from the request when it is done.
      // It needs to be in both, because it's only entered in GlobalData if the
      // search returned results.
      request.setAttribute(UNIT_SUMMARY_BEAN, unitSummarySearchBean);

      // clearing value out of global data, so it only is in there on a successful search
      UnitSummaryHelper.setUnitSummarySearchBean(request, null);

      // CCMN29SO ccmn29so = (CCMN29SO) WtcHelper.callService("CCMN29S", ccmn29si, CCMN29SO.class);
      CCMN29SO ccmn29so = admin.findUnitSummary(ccmn29si);
      UnitSummaryHelper.setUnitSummarySearchBean(request, unitSummarySearchBean);

      state.setAttribute("CCMN29SO", ccmn29so, request);

      tuxPagination.setPaginationInformation(ccmn29so.getArchOutputStruct(),
                                             ccmn29so.getROWCCMN29SOG01_ARRAY().getUlRowQty());

      // Populate CCMN24SI here
      CCMN24SI ccmn24si = populateCCMN24SI(context, unitSummarySearchBean);
      CCMN24SO ccmn24so = admin.retrieveChildUnitList(ccmn24si);
      state.setAttribute("CCMN24SO", ccmn24so, request);
      
    } catch (ServiceException we) {
      handleServiceError(we, context);
      clearState(context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    storePaginationBeanToRequest(context, tuxPagination);
    // After the search is completed, we remove the bean
    // So that the next time the user clicks over to the
    // Unit search, he/she is presented with the 'default'
    // search options.
    //request.removeAttribute(UNIT_SUMMARY_BEAN);
    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method is called when the user clicks on the Person Name Hyperlink. It calls Assigned Workload and passes it
   * the information it needs to populate. </p>
   *
   * @param context The <code>GrndsExchangeContext</code> object.
   */
  public void callAssignedWorkload_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "callAssignedWorkload_xa()");

    HttpServletRequest request = context.getRequest();

    // This section puts the person selected into Session, using a method
    // in UserProfileHelper designed solely for this purpose. This person
    // stays in the session until the person logs out, another person is
    // selected, the session times out, or the user goes to Staff To-Do or
    // Assigned Workload (the non-summary versions).
    //
    // Note that we need to handle a UserProfileException in case the session
    // has timed out (should never happen, but just in case . . .).
    //
    // This information is used by the "Other Person" tab under "My Tasks" to
    // display the workload of whever has been selected by unit summary. It has
    // to be in session so that it can persist across conversations (so state
    // cannot be used), and across first level tabs (so globalData cannot be
    // used).
    try {
      UserProfileHelper.setUnitStaffIdentifier(ContextHelper.getIntSafe(context, "personId"),
                                               ContextHelper.getStringSafe(request, "personNmWorkload"), request);
    } catch (UserProfileException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure selecting staff person:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Called by the searchUnitSummary_xa activity method to populate the input object for the Unit Summary search
   * service.
   *
   * @param context The GrndeExchangeContext object.
   */
  private CCMN29SI populateCcmn29S(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateCcmn29S()");

    // Do region/county/program checks in this method and add the user if conditions are met
    
    ArchInputStruct input = new ArchInputStruct();
    HttpServletRequest request = context.getRequest();
    CCMN29SI ccmn29si = new CCMN29SI();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI pArray =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN29SI();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(userProfile.getUserLogonID());
    ccmn29si.setArchInputStruct(input);

    String selCounty = ContextHelper.getStringSafe(context, "selCounty");
    String selRegDiv = ContextHelper.getStringSafe(context, "selRegDiv");
    String txtszNbrUnit = ContextHelper.getStringSafe(context, "txtszNbrUnit").toUpperCase();
    String rbSameName = ContextHelper.getStringSafe(request, "rbSameName");
    //-- added for custom sorting logic
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");

    // if all 4 parameters are null (new page) check for UnitSearchSummaryBean
    if (("".equals(selCounty)) && ("".equals(selRegDiv)) && ("".equals(txtszNbrUnit)) && ("".equals(rbSameName))) {
      UnitSummarySearchBean unitSummarySearchBean = UnitSummaryHelper.getUnitSummarySearchBean(request);

      if (unitSummarySearchBean != null) {
        selCounty = unitSummarySearchBean.getCounty();
        selRegDiv = unitSummarySearchBean.getRegion();
        txtszNbrUnit = unitSummarySearchBean.getUnit();
        rbSameName = unitSummarySearchBean.getAssignments();
      }
    }

    ccmn29si.setSzCdUnitCounty(selCounty);
    ccmn29si.setSzCdUnitRegion(selRegDiv);
    ccmn29si.setSzNbrUnit(txtszNbrUnit);
    ccmn29si.setCScrIndAsgnTotal(rbSameName);
    ccmn29si.setSzOrderBy(orderBy);
    ccmn29si.setSzSortDir(sortDir);
    //-- set orderBy and sortDir into tuxPagination so sortDir
    //-- determination logic works in SortableColumnTag
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);

    pArray.addUlIdPerson(userProfile.getUserID());
    List tempAssignments = userProfile.getTempAssignments();
    if ((tempAssignments != null)) {
      Iterator iter = tempAssignments.iterator();
      while (iter.hasNext()) {
        TempAssignment tempAssignment = (TempAssignment) iter.next();
        int employeeId = Integer.parseInt(tempAssignment.getTempDesignatorID());
        pArray.addUlIdPerson(employeeId);
      }
    }
    ccmn29si.setUlIdPerson_ARRAY_CCMN29SI(pArray);

    performanceTrace.exitScope();
    return ccmn29si;
  }

  /**
   * This method is called by the displayUnitDetail method to populate
   * an input object that will be used to request the list of direct
   * reporting units of a particular unit.
   * 
   * @param ccmn23so An object containing the information needed to populate the
   *                    new request object.
   * @return ccmn24si
   */
  private CCMN24SI populateCCMN24SI(GrndsExchangeContext context, UnitSummarySearchBean unitSummarySearchBean) {
    HttpServletRequest request = context.getRequest();
    CCMN24SI ccmn24si = new CCMN24SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();

    UserProfile user = UserProfileHelper.getUserProfile(request);
    int userId = user.getUserID();

    archInputStruct.setSzUserId(FormattingHelper.formatInt(userId));
    ccmn24si.setSzCdUnitCounty(unitSummarySearchBean.getCounty());
    ccmn24si.setSzCdUnitRegion(unitSummarySearchBean.getRegion());
    ccmn24si.setSzNbrUnit(unitSummarySearchBean.getUnit().toUpperCase());
    ccmn24si.setArchInputStruct(archInputStruct);
    return ccmn24si;
  }

  /**
   * This helper method handles all the WTC Exceptions thrown by the search. Called by the following methods:
   * searchUnitSummary_xa.
   *
   * @param we      The <tt>WtcException</tt> object
   * @param context The <tt>GrndeExchangeContext</tt> object.
   */
  private void handleServiceError(ServiceException we, GrndsExchangeContext context) {
    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_CMN_NO_UNIT_APPRV:
      case Messages.MSG_CMN_INVALID_UNIT:
      case Messages.MSG_CMN_INVALID_ACCESS:
        setErrorMessage(errorCode, context.getRequest());
        break;
      default:
        processSevereException(context, we);
        break;
    }
  }

  public static final String TRACE_TAG = "UnitSummaryConversation";
  public static final String UNIT_SUMMARY_BEAN = "UnitSummarySearchBean";
  public static final int MAX_RESULTS_PER_PAGE = 50;
}
