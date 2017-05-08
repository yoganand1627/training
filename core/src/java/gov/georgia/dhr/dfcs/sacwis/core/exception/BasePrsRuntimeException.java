package gov.georgia.dhr.dfcs.sacwis.core.exception;

//--GRNDS Classes--

import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;

public class BasePrsRuntimeException extends RuntimeException implements PrsException {

  public static final int CRITICAL_PRIORITY = 10;
  public static final int WARNING_PRIORITY = 5;
  public static final int INFORMATIONAL_PRIORITY = 1;
  private static final String UNKNOWN_ERROR_CODE = "Unknown";

  private int priorityLevel;
  private long uniqueId;
  private String genericMessage = "";
  private String presentationMessage;

  /**
   * This constructor will take a message and a priority level.
   *
   * @param message       The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public BasePrsRuntimeException(String message, int priorityLevel) {
    super(message);
    this.setPriorityLevel(priorityLevel);
  }

  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param message       The message to add to the exception
   * @param throwable     The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public BasePrsRuntimeException(String message, Throwable throwable, int priorityLevel) {
    super(message, throwable);
    this.setPriorityLevel(priorityLevel);
  }

  /**
   * This method will return the error code for this class.  It will obtain the error code from the Codes Table Lookup
   * framework.
   */
  public String getErrorType() {
    String errorCode;
    try {
      errorCode = Lookup.simpleDecode("Exceptions", this.getClass().getName());

      // This should never be executed, because Lookup should always
      // throw a LookupException if this happens. But just in case. . .
      if (errorCode == null) {
        errorCode = UNKNOWN_ERROR_CODE;
      }
    }
    catch (LookupException le) {
      errorCode = UNKNOWN_ERROR_CODE;
    }
    return errorCode;
  }

  /**
   * This method will return the priority level for this specific exception object
   *
   * @return int the priority level
   */
  public int getPriorityLevel() {
    return this.priorityLevel;
  }

  /**
   * This method will allow the priority level for a specific exception object to be changed
   *
   * @param priorityLevel the priority level
   */
  public void setPriorityLevel(int priorityLevel) {
    this.priorityLevel = priorityLevel;
  }

  /**
   * This method will allow for the retrieval of the uniqueId for this exception for logging and diplay to the user.  If
   * this is the first time the uniqueId has been requested, it will be generated automatically.
   *
   * @return long the unique id for this instance
   */
  public long getUniqueId() {
    if (uniqueId == 0) {
      uniqueId = this.generateUniqueId();
    }
    return uniqueId;
  }

  /**
   * This method will return the generic message that the end-user will see if this exception reached them.
   *
   * @return String The message to show the user.
   */
  public String getGenericMessage() {
    return this.genericMessage;
  }

  /**
   * This method simply calls the implementation defined in the BasePrsException
   *
   * @return long the generated unique id
   */
  protected long generateUniqueId() {
    return BasePrsException.generateUniqueId();
  }

  /**
   * This method will set the generic messag that the end-user will see if this exception reached them.
   *
   * @param message The message to show the user.
   */
  protected void setGenericMessage(String message) {
    this.genericMessage = message;
  }

  /*
  * The get/set PresentaionMessage methods are for storing/retrieving the messsage in a special field.  This
  * is needed b/c when throwing BasePrsException from the Ejb container the entire stack trace is
  * added to the message, making the base message impossible to get.
  */
  public String getPresentationMessage() {
    return this.presentationMessage;
  }

  public void setPresentationMessage(String presentationMessage) {
    this.presentationMessage = presentationMessage;
  }
}
