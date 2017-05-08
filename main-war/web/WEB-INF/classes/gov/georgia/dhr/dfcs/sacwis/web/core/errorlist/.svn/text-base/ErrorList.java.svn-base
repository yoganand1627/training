package gov.georgia.dhr.dfcs.sacwis.web.core.errorlist;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * This class provides static methods for setting a list of error messages (as ErrorListMessage objects) into state for
 * display on ErrorList.jsp.
 *
 * @author Stephan Brauchli
 * @version 1.0
 */
public abstract class ErrorList {

  public static final String ERROR_LIST_PARAM = "Error_Array_List";
  public static final String ERROR_LIST_ATTR = "Error_List_Attr";

  /**
   * Call this method from your conversation to populate state with error messages without parameters represented by the
   * int array passed.  Calling this method will allow Index.jsp to automatically open the Error List page.
   *
   * @param errorInts Array of Error IDs used to populate state with error messages
   */
  public static void setErrors(int[] errorInts, HttpServletRequest request) {
    if (errorInts == null || errorInts.length == 0) {
      return;
    }

    List<Integer> errorIntList = new ArrayList<Integer>();
    for (int errorInt : errorInts) {
      errorIntList.add(errorInt);
    }
    setErrors(errorIntList, request);
  }

  /**
   * Call this method from your conversation to populate state with error messages without parameters represented by the
   * integer list passed.  Calling this method will allow Index.jsp to automatically open the Error List page.
   *
   * @param errorInts List of Error IDs used to populate state with error messages
   * @param request
   */
  public static void setErrors(List<Integer> errorInts, HttpServletRequest request) {
    if (errorInts == null || errorInts.size() == 0) {
      return; // exit method if null or 0
    }

    List<ErrorListMessage> errorMessages = new ArrayList<ErrorListMessage>();
    // Added URL stuff SPB
    String strStageCD = GlobalData.getSzCdStage(request);
    String strPrgmCD = GlobalData.getSzCdStageProgram(request);
    if ("".equals(strPrgmCD)) {
      strPrgmCD = "0";
    }

    for (Integer errorInt : errorInts) {
      errorMessages.add(buildMessageBean(strPrgmCD, strStageCD, errorInt, null));
    }
    setAttributes(errorMessages, request);
  }

  /**
   * Call this method from your conversation to populate state with error messages using parameters represented by the
   * map passed.  The map should contain error IDs as keys that map to an Object array representing the ordered
   * collection of parameters to add to the respective message.  Calling this method will allow Index.jsp to
   * automatically open the Error List page.
   *
   * @param errorIntsToParamList Map of Error IDs (keys) and the respective message parameters to add (values)
   * @param request
   */
  public static void setErrors(Map<Integer, Object[]> errorIntsToParamList, HttpServletRequest request) {
    if (errorIntsToParamList == null || errorIntsToParamList.size() == 0) {
      return;
    }

    String cdStage = GlobalData.getSzCdStage(request);
    String cdStageProgram = GlobalData.getSzCdStageProgram(request);
    if ("".equals(cdStageProgram)) {
      cdStageProgram = "0";
    }

    List<ErrorListMessage> errorMessages = new ArrayList<ErrorListMessage>();
    for (Integer errorInt : errorIntsToParamList.keySet()) {
      if (errorInt != null && errorInt > 0) {
        errorMessages.add(buildMessageBean(cdStageProgram, cdStage, errorInt, errorIntsToParamList.get(errorInt)));
      }
    }
    setAttributes(errorMessages, request);
  }

  private static ErrorListMessage buildMessageBean(String cdStageProgram, String cdStage, Integer errorInt,
                                                   Object[] params) {
    String tabUriAndCdTask = ErrorUriLookup.lookupURI(errorInt, cdStageProgram, cdStage);
    String tabUri = tabUriAndCdTask.substring(0, tabUriAndCdTask.indexOf("-"));
    String cdTask = tabUriAndCdTask.substring(tabUriAndCdTask.indexOf("-") + 1, tabUriAndCdTask.length());

    ErrorListMessage msgBean = new ErrorListMessage();
    msgBean.setMsgURL(tabUri);
    msgBean.setTaskCD(cdTask);
    msgBean.setMessageNum(errorInt);
    msgBean.setMsgName(MessageLookup.getNameByNumber(errorInt));

    String message = MessageLookup.getMessageByNumber(errorInt);
    if (params != null && params.length > 0) {
      for (Object param : params) {
        if (param == null) {
          continue;
        }

        if (param instanceof String) {
          message = MessageLookup.addMessageParameter(message, (String) param);
        } else if (param instanceof Integer) {
          message = MessageLookup.addMessageParameter(message, (Integer) param);
        } else if (param instanceof Double) {
          message = MessageLookup.addMessageParameter(message, (Double) param);
        } else if (param instanceof Float) {
          message = MessageLookup.addMessageParameter(message, (Float) param);
        }
      }
    }
    msgBean.setErrorMessage(message);

    return msgBean;
  }
  
  private static void setAttributes(List<ErrorListMessage> errorMessages, HttpServletRequest request) {
    //-- add actual error messages to request to be picked up by Index.jsp where
    //-- it will be serialized and passed to ErrorList.jsp as a parameter
    request.setAttribute(ERROR_LIST_ATTR, errorMessages);
  }
}