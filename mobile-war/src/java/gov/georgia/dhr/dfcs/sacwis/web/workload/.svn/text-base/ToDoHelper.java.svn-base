package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

/**
 * This class is designed to store and retreive data related to the current To-Do and state of the To-Do List pages in
 * the Global Data area of state.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 05/09/05  NALLAVS           SIR 23547 - Removed System.out.println statements.
 * </pre>
 */
public class ToDoHelper {

  private static final String DISPLAY_STAFF_TODO_URI = "/workload/ToDo/displayStaffToDo";
  private static final String DISPLAY_SUMMARY_TODO_URI = "/workload/ToDo/displayStaffToDoSummary";
  private static final String DISPLAY_CASE_TODO_LIST_URI = "/workload/ToDo/displayCaseToDo";

  @SuppressWarnings({"unchecked"})
  public static void setToDoStateInformation(HttpServletRequest request, ToDoStateInfo toDoStateInfo) {
    if (toDoStateInfo == null) {
      throw new IllegalArgumentException("The ToDoStageInfo object cannot be null.");
    } else if (toDoStateInfo.getId() == 0) {
      throw new IllegalArgumentException("The ToDoStageInfo requires that the ID be set.");
    }
    BaseSessionStateManager state = GlobalData.getState(request);
    Map<Integer, ToDoStateInfo> searchInfoMapKey =
            (Map<Integer, ToDoStateInfo>) state.getContextParameter(TODO_STATE_INFO_MAP_KEY, request);
    if (searchInfoMapKey == null) {
      searchInfoMapKey = new HashMap<Integer, ToDoStateInfo>();
      state.setContextParameter(TODO_STATE_INFO_MAP_KEY, (Serializable) searchInfoMapKey, request);
    }
    Integer idInteger = toDoStateInfo.getId();
    searchInfoMapKey.put(idInteger, toDoStateInfo);
  }

  @SuppressWarnings({"unchecked"})
  public static ToDoStateInfo getToDoStateInformation(HttpServletRequest request, int id) {
    BaseSessionStateManager state = GlobalData.getState(request);
    Map<Integer, ToDoStateInfo> searchInfoMapKey =
            (Map<Integer, ToDoStateInfo>) state.getContextParameter(TODO_STATE_INFO_MAP_KEY, request);
    return searchInfoMapKey != null ? searchInfoMapKey.get(id) : null;
  }

  /**
   * Sets the return URI to Staff To-Do after Approvals.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   */
  public static void setReturnToStaffToDoList(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    state.setContextParameter(RETURN_TO_TODO_LIST_URI_KEY, DISPLAY_STAFF_TODO_URI, request);
  }

  /**
   * Sets the return URI to Staff To-Do Summary after Approvals.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   */
  public static void setReturnToStaffToDoSummaryList(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    state.setContextParameter(RETURN_TO_TODO_LIST_URI_KEY, DISPLAY_SUMMARY_TODO_URI, request);
  }

  /**
   * Sets the return URI to Case To-Do after Approvals.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   */
  public static void setReturnToCaseToDoList(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    state.setContextParameter(RETURN_TO_TODO_LIST_URI_KEY, DISPLAY_CASE_TODO_LIST_URI, request);
  }

  /**
   * Returns the URI for the To-Do list to which the user should be forwarded after completing an approval.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   * @return To-Do List URI to which the user should be forwarded
   */
  public static String getReturnToToDoListURI(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    String returnURI = (String) state.getContextParameter(RETURN_TO_TODO_LIST_URI_KEY, request);
    if (returnURI != null) {
      return returnURI;
    }
    return DISPLAY_STAFF_TODO_URI;
  }

  /**
   * Removes information used to give users access to stages that they wouldn't usually have access to when navigating
   * on To-Do's that have been assigned to them.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   */
  public static void clearPageModeEditOverride(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    state.removeContextParameter(PAGE_MODE_OVERRIDE, request);
  }

  /**
   * Sets the todo page mode edit into the context area of state so it won't get cleared.
   *
   * @param request current request
   */
  public static void setPageModeEditOverride(HttpServletRequest request, String taskCode, int stageId, int eventId) {
    if ((stageId == 0) || (taskCode == null) || ("".equals(taskCode))) {
      throw new IllegalArgumentException("expecting non-zero stageId and non-null taskCode");
    }

    BaseSessionStateManager state = GlobalData.getState(request);
    String override = getOverride(taskCode, stageId, eventId);
    state.setContextParameter(PAGE_MODE_OVERRIDE, override, request);
  }

  /**
   * Returns wether todo page mode override is set in the context area of state.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   */
  public static boolean hasPageModeEditOverride(HttpServletRequest request) {
    String taskCode = GlobalData.getSzCdTask(request);
    int stageId = GlobalData.getUlIdStage(request);
    int eventId = GlobalData.getUlIdEvent(request);

    return hasPageModeEditOverride(request, taskCode, stageId, eventId);
  }

  /**
   * Returns wether todo page mode override is set in the context area of state for a particular task, stage and event.
   *
   * @param request The current <tt>HttpServletRequest</tt> object
   */
  public static boolean hasPageModeEditOverride(HttpServletRequest request, String taskCode, int stageId, int eventId) {
    BaseSessionStateManager state = GlobalData.getState(request);
    String override = (String) state.getContextParameter(PAGE_MODE_OVERRIDE, request);
    if (override == null) {
      return false;
    }
    String overrideTest = getOverride(taskCode, stageId, eventId);
    if (override.equals(overrideTest)) {
      return true;
    }
    // If event id was zero initially, treat it as allow all changes to that taskcode in the stage.
    overrideTest = getOverride(taskCode, stageId, 0);
    return (override.equals(overrideTest));
  }

  /**
   * Formats information in the page mode override.
   *
   * @param taskCode The current task code
   * @param stageId  The current stageId code
   * @param eventId  The current eventIds code
   */
  protected static String getOverride(String taskCode, int stageId, int eventId) {
    return taskCode + "~" + stageId + "~" + eventId;
  }

  public static class ToDoStateInfo implements Serializable {
    public ToDoStateInfo() {
      // These are useful defaults, but in particular, neither id nor sort order should be left unchanged
      //   after the object is created.
      this.fromDate = null;
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.WEEK_OF_YEAR, 1);
      this.toDate = new org.exolab.castor.types.Date(cal.getTime());
      this.orderBy = null;
      this.id = 0;
      this.requestedPage = 1;
    }

    public ToDoStateInfo(org.exolab.castor.types.Date fromDate, org.exolab.castor.types.Date toDate,
                         String sortOrder, int id, int currentPage) {
      this.fromDate = fromDate;
      this.toDate = toDate;
      this.orderBy = sortOrder;
      this.id = id;
      this.requestedPage = currentPage;
    }

    public org.exolab.castor.types.Date getFromDate() {
      return fromDate;
    }

    public void setFromDate(org.exolab.castor.types.Date fromDate) {
      this.fromDate = fromDate;
    }

    public org.exolab.castor.types.Date getToDate() {
      return toDate;
    }

    public void setToDate(org.exolab.castor.types.Date toDate) {
      this.toDate = toDate;
    }

    public String getOrderBy() {
      return orderBy;
    }

    public void setOrderBy(String orderBy) {
      this.orderBy = orderBy;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getRequestedPage() {
      return requestedPage;
    }

    public void setRequestedPage(int requestedPage) {
      this.requestedPage = requestedPage;
    }

    private org.exolab.castor.types.Date fromDate;
    private org.exolab.castor.types.Date toDate;
    private String orderBy;
    private int id;
    private int requestedPage;
  }

  public static final String TRACE_TAG = "ToDoHelper";

  public static final String RETURN_TO_TODO_LIST_URI_KEY = TRACE_TAG + ".RETURN_TO_TODO_LIST_URI_KEY";
  public static final String TODO_FROM_DATE_KEY = TRACE_TAG + ".STAFF_TODO_FROM_DATE_KEY ";
  public static final String TODO_TO_DATE_KEY = TRACE_TAG + ".STAFF_TODO_FROM_DATE_KEY ";
  public static final String TODO_STATE_INFO_MAP_KEY = TRACE_TAG + ".TODO_STATE_INFO_MAP_KEY";
  public static final String PAGE_MODE_OVERRIDE = TRACE_TAG + ".PAGE_MODE_OVERRIDE";
  protected static final String TODO_DETAIL_DB_KEY = TRACE_TAG + ".TODO_DETAIL_DB_KEY";
}
