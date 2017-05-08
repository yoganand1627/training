package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcException;

/*
* Date        User      Description
* --------    --------  --------------------------------------------------
* 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */

/** User: mkw Date: Sep 19, 2003 Time: 9:50:34 AM */
public class WtcExceptionHandler extends ServiceExceptionHandler {
  /**
   * Users should not create their own instances of the handler.  This class will be created and managed by the
   * ExceptionHandler class.
   */
  public WtcExceptionHandler(WtcException wtcException) {
    super(wtcException);
  }

  public void setThrowable(Throwable throwable) {
    if (throwable instanceof WtcException) {
      super.setThrowable(throwable);
    } else {
      throw new ClassCastException("The WtcExceptionHandler class can only be used to handle WtcException's.");
    }
  }
}
