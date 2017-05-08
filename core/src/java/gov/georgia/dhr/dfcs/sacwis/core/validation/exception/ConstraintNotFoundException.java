package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/**
 * A <code>ConstraintNotFoundException</code> is thrown when the named constraint is not specified by the related schema
 * document.
 *
 * @author Kelly J. Mayes
 */
public class ConstraintNotFoundException extends ArchitectureException {
  /** Constructor for the ConstraintNotFoundException object */
  public ConstraintNotFoundException() {
    super("Constraint not found", BasePrsException.WARNING_PRIORITY);
  }

  /**
   * Constructor for the ConstraintNotFoundException object
   *
   * @param sMessage Description of Parameter
   */
  public ConstraintNotFoundException(String message) {
    super(message, BasePrsException.WARNING_PRIORITY);
  }
}












