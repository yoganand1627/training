package gov.georgia.dhr.dfcs.sacwis.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.zip.Adler32;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;

/**
 * This class is the base class for all exceptions in the PRS system.  All application-specific exceptions should be a
 * sub-class of this class.
 */
public abstract class BasePrsException extends Exception implements PrsException {
  public static final int CRITICAL_PRIORITY = 10;
  public static final int WARNING_PRIORITY = 5;
  public static final int INFORMATIONAL_PRIORITY = 1;
  public static final String UNKNOWN_ERROR_TYPE = "Unknown";
  private static final String TRACE_TAG = "BasePrsException";
  public static String networkLocation;
  private static final Random randomGenerator = new Random();
  private int priorityLevel;
  boolean uniqueIdSet = false;
  private long uniqueId;
  private String errorType;
  private String presentationMessage;

  static {
    try {
      networkLocation = InetAddress.getLocalHost().getHostAddress();
    }
    catch (UnknownHostException uhe) {
      //we can't get the host address so let's just generate a random number instead
      //this should still be sufficiently unique.
      networkLocation = "" + randomGenerator.nextInt();
    }
  }

  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public BasePrsException(String msg, Throwable e, int priorityLevel) {
    super(msg, e);
    this.setPriorityLevel(priorityLevel);
    this.setPresentationMessage(msg);
  }


  /**
   * This constructor will take a message and a priority level.
   *
   * @param msg           The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public BasePrsException(String msg, int priorityLevel) {
    this(msg, null, priorityLevel);
  }


  /**
   * This method will return the error type for this class.  It will obtain the error type from the Codes Table Lookup
   * framework.
   */
  public String getErrorType() {
    if (errorType != null) {
      return errorType;
    }
    //mdm - this was static which won't work as intended,
    //and had a synchronized block which would always error with a NullPointerException
    try {
      errorType = Lookup.simpleDecode("Exceptions", this.getClass().getName());

      // This should never be executed, because Lookup should always
      // throw a LookupException if this happens. But just in case. . .
      if (errorType == null) {
        errorType = UNKNOWN_ERROR_TYPE;
      }
    }
    catch (LookupException le) {
      errorType = UNKNOWN_ERROR_TYPE;
    }
    return errorType;
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
   * @param level the priority level
   */
  public void setPriorityLevel(int level) {
    this.priorityLevel = level;
  }


  /**
   * This method will allow for the retrieval of the uniqueId for this exception for logging and display to the user.
   * If this is the first time the uniqueId has been requested, it will be generated automatically.
   *
   * @return long the unique id for this instance
   */
  public long getUniqueId() {
    if (!uniqueIdSet) {
      uniqueId = generateUniqueId();
      uniqueIdSet = true;
    }
    return uniqueId;
  }


  /**
   * The implementation uses the machine's IP Address + the current time in milliseconds + a random double number and
   * uses the Adler32 class to generate a checksum value. This checksum value should be as unique as our needs require.
   *
   * @return long the generated unique id
   */
  public static long generateUniqueId() {
    GrndsTrace.enterScope(TRACE_TAG + ".generateUniqueId");

    long currentTime = System.currentTimeMillis();

    //double random = Math.random();
    int random = randomGenerator.nextInt();
    String uniqueString = networkLocation + currentTime + random;
    byte[] byteArray = null;
    try {
      byteArray = uniqueString.getBytes(ArchitectureConstants.CHARACTER_ENCODING);
    }
    catch (UnsupportedEncodingException e) {
      // This will never happen; ignore it.
    }

    //Use the Adler32 class to generate a unique ID
    Adler32 idGenerator = new Adler32();
    idGenerator.update(byteArray);

    GrndsTrace.exitScope();
    return (idGenerator.getValue());
  }


  public static String getStackTrace(Throwable e) {
    String stackTrace;
    StringWriter sw = new StringWriter();
    PrintWriter pw = null;
    try {
      pw = new PrintWriter(sw);
      e.printStackTrace(pw);
    } finally {
      if (pw != null) {
        pw.close();
      }
    }
    stackTrace = sw.toString();
    return stackTrace;
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
