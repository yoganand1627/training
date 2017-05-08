/**
 * Created on Jun 6, 2005 at 5:52:46 PM
 * 
 * Created by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.exception;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;

/**
 * <pre>
 * Date        User      Description
 * --------    --------  --------------------------------------------------
 * 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add
 *                       Contact List and Detail to MPS.
 * 09/22/2005  werlem    SIR 23979 Removed unnecessary constructors.
 * </pre>
 */
public class ServiceException extends BasePrsRuntimeException {
  public ServiceException() {
    this("", null, DEFAULT_PRIORITY_LEVEL);
  }

  public ServiceException(int messageNumber) {
    this("", null, DEFAULT_PRIORITY_LEVEL);
    setErrorCode(messageNumber);
    setErrorMessage(MessageLookup.getMessageByNumber(messageNumber));
  }

  public ServiceException(int messageNumber, Throwable t) {
    this("", t, DEFAULT_PRIORITY_LEVEL);
    setErrorCode(messageNumber);
    setErrorMessage(MessageLookup.getMessageByNumber(messageNumber));
  }

  protected ServiceException(String msg, Throwable e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  protected void setErrorCode(int errorCode) {
    _errorCode = errorCode;
  }

  public int getErrorCode() {
    return _errorCode;
  }

  protected void setErrorMessage(String errorMessageText) {
    if (errorMessageText == null) {
      _errorMessageText = UNKNOWN_MESSAGE;
    } else if ("".equals(errorMessageText)) {
      _errorMessageText = UNKNOWN_MESSAGE;
    } else {
      _errorMessageText = errorMessageText;
    }
  }

  public String getErrorMessage() {
    if (_errorMessageText == null) {
      return "";
    } else {
      return _errorMessageText;
    }
  }

  public String getMessage() {
    return getErrorMessage();
  }

  protected int _errorCode = 0;
  public static final int DEFAULT_PRIORITY_LEVEL = 9;
  public static String UNKNOWN_MESSAGE = "Unknown Error Message";
  protected String _errorMessageText = null;
}
