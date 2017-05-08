package gov.georgia.dhr.dfcs.sacwis.core.exception;


/**
 * This class could be deleted now that IMPACT is designed for JDK 1.4.2, but it remains because doing so would require
 * updating many, many places.
 */
public class RuntimeWrappedException extends RuntimeException {

  public RuntimeWrappedException(Throwable throwable) {
    super(throwable);
  }


  public String getMessage() {
    Throwable cause = getCause();
    return "RuntimeWrappedException: " + cause != null ? cause.getMessage() : null;
  }


  public String getLocalizedMessage() {
    Throwable cause = getCause();
    return "RuntimeWrappedException: " + cause != null ? cause.getMessage() : null;
  }


  public String toString() {
    Throwable cause = getCause();
    return "RuntimeWrappedException: " + cause != null ? cause.toString() : null;
  }
}


