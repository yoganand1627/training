package gov.georgia.dhr.dfcs.sacwis.web.core.base;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/**
 * Utility class to populate required information to the BaseValueBean or the BasePaginationValueBean and a
 * DatabaseResultDetails object.  This may include getting user information, the results to display per page, and the
 * timestamp of any data that might be updated.  It will also create the DatabaseResultDetails object and add it to the
 * BasePaginationValueBean for the user.
 * <pre>
 * Change History:
 * Date        User      Description
 * ----------  --------  --------------------------------------------------
 * 05/03/2004  gerryc    SIR 15533 - created method to remove attributes from the paginationbean so that if you are
 *                       going from one page withpagination to a separate one with pagination, the key values are
 * reset.
 * </pre>
 */
public class ValueBeanHelper {
  public static final String UNKNOWN_USER_ID = null;
  private static final String TRACE_TAG = "ValueBeanHelper";
  private static final String DEFAULT_TIMESTAMP = "0";
  private static final String DEFAULT_RESULTS_PER_PAGE = "25";
  private static final String DEFAULT_REQUESTED_PAGE = "1";
  private static final int STRING_BEGINNING_INDEX = 0;

  /** Private constructor to make it impossible to instantiate this class. */
  private ValueBeanHelper() {
  }

  /**
   * Populate the data object bean with values from the GrndsExchangeContext.  This will get the timestamps for the data
   * (if appropriate) from the request, and set the User Id from the session.  If the bean extends the
   * BasePaginationValueBean then the requested results per page, and the requested page will be set to a
   * DatabaseResultDetails object that will be set to the bean as well.
   *
   * @param context The GrndsExchangeContext to get the session and request values from
   * @param bean    The data object bean to add the values to
   */
  public static void populateDefaultValues(GrndsExchangeContext context,
                                           BaseValueBean bean) {
    populateDefaultValues(context.getRequest(),
                          bean);
  }

  /**
   * Populate the data object bean with values from the GrndsExchangeContext.  This will get the timestamps for the data
   * (if appropriate) from the request, and set the User Id from the session.  If the bean extends the
   * BasePaginationValueBean then the requested results per page, and the requested page will be set to a
   * DatabaseResultDetails object that will be set to the bean as well.
   *
   * @param request The HttpServletRequest to get the session and request values from
   * @param bean    The data object bean to add the values to
   */
  public static void populateDefaultValues(HttpServletRequest request,
                                           BaseValueBean bean) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateDefaultValues");

    // Get all of the timestamps and strings out of the request. The "updated on"
    // timestamp is tricky and has to be treated separately, since it is actually
    // a hashmap of table names and timestamps as key/value pairs.
    long createdOnTimestamp = getTimeStamp(request, BasePaginationValueBean.CREATED_ON_TIME_STAMP);

    String createdByUserId = getCreatedByUserId(request);
    String currentUserId = getCurrentUserId(request);

    int counter = 0;
    String updatedOnTimestamp = getUpdatedOnTimestamp(request, counter);

    while (updatedOnTimestamp != null) {
      // parse the parameter's value into tablename and timestamp
      int dotLocation = updatedOnTimestamp.indexOf(".");
      String key = updatedOnTimestamp.substring(STRING_BEGINNING_INDEX, dotLocation);
      String valueAsString = updatedOnTimestamp.substring(dotLocation + 1);
      long valueAsLong = Long.parseLong(valueAsString);
      Timestamp valueAsTimestamp = new Timestamp(valueAsLong);

      // add the key/value pair to the UpdatedOn hashmap in the bean
      bean.setUpdatedOn(key, valueAsTimestamp);

      // get data from the next "updated on" hidden field
      counter++;
      updatedOnTimestamp = getUpdatedOnTimestamp(request, counter);
    }

    bean.setCreatedOn(new Timestamp(createdOnTimestamp));
    bean.setCreatedBy(createdByUserId);
    bean.setUpdatedBy(currentUserId);

    if (bean instanceof BasePaginationValueBean) {
      //populate the additional values required
      populatePaginationValues((BasePaginationValueBean) bean, request);
    }
    GrndsTrace.exitScope();
  }

  /**
   * SIR 15533 - added this method to clear pagination values.  This can be used when going from one page with
   * pagination to another.  This was first needed going from Payment Approval to Invoice - the order by parameter from
   * Payment Approval was getting passed to Invoice, and that constant wasn't handled as part of the Invoice service.
   */
  protected static DatabaseResultDetails clearPaginationValues(DatabaseResultDetails details) {
    details.setOrderBy(null);
    details.setOrderByDirection(null);
    details.setRequestedPage(Integer.parseInt(DEFAULT_REQUESTED_PAGE));
    details.setResultsPerPage(Integer.parseInt(DEFAULT_RESULTS_PER_PAGE));

    return details;
  }

  /**
   * Populate the data object bean with pagination values from the HttpServletRequest object.
   *
   * @param request The request object to obtain the values from
   * @param bean    The data object bean to add the values to
   * @return bean The bean with the added values
   */
  protected static BasePaginationValueBean populatePaginationValues(BasePaginationValueBean bean,
                                                                    HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + ".populatePaginationValues");

    BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);
    DatabaseResultDetails details = new DatabaseResultDetails();

    int resultsPerPage = getResultsPerPage(request);
    details.setResultsPerPage(resultsPerPage);

    // If the request is from a submodule, get the calling page URI.
    String callingPage = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);

    // Get the URI for the current page.
    StringBuffer currentUri = new StringBuffer();
    currentUri.append("/");
    currentUri.append(request.getAttribute("grnds_conversation"));
    currentUri.append("/");
    currentUri.append(request.getAttribute("grnds_command"));

    // If the request was from a page other than the one we are on, do not
    // populate values from the request because the original page might have
    // used pagination also, and its pagination values could still be in the
    // request; instead, populate with default values.
    // -----
    // RIOSJA, SIR 22614 - Added submodule "callingPage" condition so that
    // submodules can use pagination also.
    if (currentUri.toString().equals(request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL)) ||
        (StringHelper.isValid(callingPage) &&
         callingPage.equals(request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL)))) {
      /*SIR 15533 - if user is staying on the same page, the pagination info gets set here */
      int requestedPage = getRequestedPage(request);
      details.setRequestedPage(requestedPage);
      details.setOrderBy(request.getParameter(SortableColumnTag.ORDER_BY_NAME));
      details.setOrderByDirection(request.getParameter(SortableColumnTag.DIRECTION_NAME));
      GrndsTrace.msg(ValueBeanHelper.TRACE_TAG, 9, "populate pagination information from request");
    } else {
      /* SIR 15533 - added this protected method to reset paginiation values
      when going to a new page*/
      details = clearPaginationValues(details);
      GrndsTrace.msg(ValueBeanHelper.TRACE_TAG, 9, "clear out pagination");
    }
    ResultsPaginationHelper.setUrlParameters(request, details);
    bean.setResultDetails(details);
    GrndsTrace.exitScope( /*bean*/);
    return bean;
  }

  /**
   * This method gets the time stamp from the request
   *
   * @param request the HttpServletRequest
   * @return the timestamp value
   */
  protected static long getTimeStamp(HttpServletRequest request,
                                     String parameter) {
    String value = request.getParameter(parameter);
    if (value == null) {
      value = DEFAULT_TIMESTAMP;
    }
    return Long.valueOf(value);
  }

  /**
   * This method gets an "updated on" timestamp from the request, via a hidden field.
   *
   * @param counter The number appended to the parameter name (this allows for multiple updated by timestamp hidden
   *                fields).
   * @return A String object in this format: "tablename.timestamp-as-a-string"
   */
  protected static String getUpdatedOnTimestamp(HttpServletRequest request,
                                                int counter) {
    return request.getParameter(BaseValueBean.UPDATED_ON_TIME_STAMP + counter);
  }

  /**
   * This method gets the results per page from the request
   *
   * @param request the HttpServletRequest
   * @return int the results per page
   */
  protected static int getResultsPerPage(HttpServletRequest request) {
    String value =
            request.getParameter(DatabaseResultDetails.RESULTS_PER_PAGE_NAME);

    if (!StringHelper.isValid(value)) {
      value = DEFAULT_RESULTS_PER_PAGE;
    }
    return Integer.valueOf(value);
  }

  /**
   * This method gets the requested page from the request
   *
   * @param request the HttpServletRequest
   * @return int the requested page
   */
  protected static int getRequestedPage(HttpServletRequest request) {
    String value =
            request.getParameter(ResultsPaginationHelper.REQUESTED_PAGE_KEY);

    if (!StringHelper.isValid(value)) {
      value = DEFAULT_REQUESTED_PAGE;
    }
    return Integer.valueOf(value);
  }

  /** Used by InvoiceConversation to know whether the user clicked a Next/Previous hyperlink */
  public static boolean hasRequestedPage(HttpServletRequest request) {
    //!!! Notes: Matthew McClain 9/15/2003
    //!!! @todo code from populatePaginationValues which gets currentUri, etc,
    //can probably be safely put here
    //If you do, retest SIR 19696 as well as other pagination stuff
    String value =
            request.getParameter(ResultsPaginationHelper.REQUESTED_PAGE_KEY);

    return (StringHelper.isValid(value));
  }

  /**
   * This method gets the current user's ID from the session.
   *
   * @return String the user's ID
   */
  protected static String getCreatedByUserId(HttpServletRequest request) {
    return request.getParameter(BaseValueBean.CREATED_BY);
  }

  /**
   * This method gets the current user's ID from the session.
   *
   * @return String the user's ID
   */
  protected static String getCurrentUserId(HttpServletRequest request) {
    String userId = UNKNOWN_USER_ID;

    UserProfile user = UserProfileHelper.getUserProfile(request);
    if (user != null) {
      userId = user.getUserLogonID();
    }
    return userId;
  }
}
