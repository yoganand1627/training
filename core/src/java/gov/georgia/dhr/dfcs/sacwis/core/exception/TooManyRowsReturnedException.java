package gov.georgia.dhr.dfcs.sacwis.core.exception;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;


/**
 */
public class TooManyRowsReturnedException
        extends BasePrsException {
  /**
   */
  public TooManyRowsReturnedException() {
    this("Too Many Rows Returned");
  }


  /**
   */
  public TooManyRowsReturnedException(String msg) {
    super(msg, BasePrsException.INFORMATIONAL_PRIORITY);
  }
}
