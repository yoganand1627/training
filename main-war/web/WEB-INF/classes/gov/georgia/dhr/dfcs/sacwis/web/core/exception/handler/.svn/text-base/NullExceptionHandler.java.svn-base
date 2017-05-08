package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class is deigned to ignore exceptions.  It should only be used to trap exceptions that should neither be logged
 * or presented in any fashion.
 */
public class NullExceptionHandler implements SpecificExceptionHandler {
  /**
   * Users should not create their own instances of the handler.  This class will be created and managed by the
   * ExceptionHandler class.
   */
  public NullExceptionHandler() {
    this.throwable = null;
  }

  public NullExceptionHandler(Throwable throwable) {
    this.throwable = throwable;
  }

  public void handle() {
    // Do nothing.
  }

  public void presentErrorMessage(GrndsExchangeContext context) {
    // Do nothing.
  }

  public void setThrowable(Throwable throwable) {
    this.throwable = throwable;
  }

  public Throwable getThrowable() {
    return throwable;
  }

  private Throwable throwable;
}
