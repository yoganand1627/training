package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/**
 * A <code>DataFormatException</code> is thrown when the data being validated does not conform to the
 * <code>Constraint</code> specified by the related schema document.
 */
public class DataFormatException extends ArchitectureException {
  private static final String INVALID_DATA_SUPPLIED = "Invalid data supplied";

  /** Constructor for the DataFormatException object */
  public DataFormatException() {
    super(INVALID_DATA_SUPPLIED, BasePrsException.INFORMATIONAL_PRIORITY);
  }

  /** Constructor for the DataFormatException object */
  public DataFormatException(Throwable t) {
    super(INVALID_DATA_SUPPLIED, t, BasePrsException.INFORMATIONAL_PRIORITY);
  }

  /**
   * Constructor for the DataFormatException object
   *
   * @param message Description of Parameter
   */
  public DataFormatException(String message) {
    super(message, BasePrsException.INFORMATIONAL_PRIORITY);
  }

  /**
   * Constructor for the DataFormatException object
   *
   * @param message Description of Parameter
   */
  public DataFormatException(String message, Throwable t) {
    super(message, t, BasePrsException.INFORMATIONAL_PRIORITY);
  }
}












