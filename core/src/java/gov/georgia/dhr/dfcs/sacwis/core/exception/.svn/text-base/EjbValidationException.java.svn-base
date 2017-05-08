package gov.georgia.dhr.dfcs.sacwis.core.exception;


import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;


public class EjbValidationException
        extends BasePrsException {
  protected int errorCode = 0;
  protected String message = null;


  public EjbValidationException(int errorCode,
                                int priorityLevel) {
    this(errorCode, null, priorityLevel);
  }


  public EjbValidationException(int errorCode,
                                Throwable e,
                                int priorityLevel) {
    this(errorCode,
         getErrorMessage(errorCode),
         e,
         priorityLevel);
  }


  public EjbValidationException(int errorCode,
                                String message,
                                Throwable e,
                                int priorityLevel) {
    super(message,
          e,
          priorityLevel);

    this.errorCode = errorCode;
    this.message = message;
  }


  public int getErrorCode() {
    return errorCode;
  }


  public String getErrorMessage() {
    if (message == null) {
      message = getErrorMessage(errorCode);
    }
    return message;
  }


  protected static String getErrorMessage(int errorCode) {
    String message = MessageLookup.getMessageByNumber(errorCode);
    if ((message == null) ||
        ("".equals(message))) {
      return "unknown error: " + errorCode;
    }
    return message;
  }
}

  
