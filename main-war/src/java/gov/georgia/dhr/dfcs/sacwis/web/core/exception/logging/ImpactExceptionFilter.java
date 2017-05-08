package gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/** User: mkw Date: Sep 22, 2003 Time: 3:19:33 PM */
public class ImpactExceptionFilter implements Filter {
  /**
   * This filter only accepts ImpactExceptionLogRecord's, which are handled by the overloaded version this method that
   * take a single ImpactExceptionLogRecord.
   *
   * @param record
   * @return This method ALWAYS returns false.
   */
  public boolean isLoggable(LogRecord record) {
    return record instanceof ImpactExceptionLogRecord && !((ImpactExceptionLogRecord) record).isWritten();
  }
}
