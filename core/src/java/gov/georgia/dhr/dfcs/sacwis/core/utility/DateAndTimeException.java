package gov.georgia.dhr.dfcs.sacwis.core.utility;

// -- Architecture classes --

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/** Thrown when there is an error proccessing Date, Time, or DateUtility functionality */
public class DateAndTimeException extends ArchitectureException {
  public DateAndTimeException(Exception e) {
    super(null, e, BasePrsException.INFORMATIONAL_PRIORITY);
  }

  public DateAndTimeException(String message) {
    super(message, null, BasePrsException.INFORMATIONAL_PRIORITY);
  }

  public DateAndTimeException(String message, Exception e) {
    super(message, e, BasePrsException.INFORMATIONAL_PRIORITY);
  }
}










