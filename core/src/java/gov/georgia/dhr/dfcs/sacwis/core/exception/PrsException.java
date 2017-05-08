package gov.georgia.dhr.dfcs.sacwis.core.exception;

public interface PrsException {

  public static final int CRITICAL_PRIORITY = 10;
  public static final int WARNING_PRIORITY = 5;
  public static final int INFORMATIONAL_PRIORITY = 1;
  public static final String UNKNOWN_ERROR_CODE = "Unknown";

  /**
   * This method will return the priority level for this specific exception object
   *
   * @return int the priority level
   */
  public int getPriorityLevel();

  /**
   * This method will allow the priority level for a specific exception object to be changed
   *
   * @param level the priority level
   */
  public void setPriorityLevel(int level);

  /**
   * This method will allow for the retrieval of the uniqueId for this exception for logging and diplay to the user.  If
   * this is the first time the uniqueId has been requested, it will be generated automatically.
   *
   * @return long the unique id for this instance
   */
  public long getUniqueId();

  /**
   * All exceptions must implement this.  Placed on the interface simply to allow all PrsExceptions to be acted on
   * through this interface.
   */
  public String getMessage();
}






