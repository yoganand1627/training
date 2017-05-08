package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.NonPrsExceptionWrapper;

/**
 * This exception handler will handle any Non-PRS exceptions passed to the ExceptionHandler class. It will be called to
 * perform generic exception handling for any exception that is not a subclass of the BasePrsException class.
 */
public class NonPrsExceptionHandler extends PrsExceptionHandler {
  /**
   * Users should not create their own instances of the handler.  This class will be created and managed by the
   * ExceptionHandler class.
   */
  public NonPrsExceptionHandler(Throwable throwable) {
    super(throwable instanceof NonPrsExceptionWrapper
          ? throwable : new NonPrsExceptionWrapper("NonPrsExceptionWrapper wrapping: " + throwable.getClass(),
                                                   throwable, BasePrsException.WARNING_PRIORITY));
  }

  public void setThrowable(Throwable throwable) {
    super.setThrowable(throwable instanceof NonPrsExceptionWrapper
                       ? throwable
                       : new NonPrsExceptionWrapper("NonPrsExceptionWrapper wrapping: " + throwable.getClass(),
                                                    throwable, BasePrsException.WARNING_PRIORITY));
  }
}
