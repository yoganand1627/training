package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import org.grnds.structural.web.GrndsExchangeContext;

public interface SpecificExceptionHandler {

  /** This generic method will handle the exception. */
  public void handle();

  /**
   * This generic method will present the exception to the end-user.
   *
   * @param context The current <tt>GrndsExchangeContext</tt> object
   */
  public void presentErrorMessage(GrndsExchangeContext context);

  /**
   * Used to set the throwable that this handler will handle.
   *
   * @param throwable
   */
  public void setThrowable(Throwable throwable);

  /** Used to get the throwable that this handler will handle. */
  public Throwable getThrowable();

  // static constants
  public static final String EXCEPTION_REQUEST_LOOKUP = "exception.display";
}
