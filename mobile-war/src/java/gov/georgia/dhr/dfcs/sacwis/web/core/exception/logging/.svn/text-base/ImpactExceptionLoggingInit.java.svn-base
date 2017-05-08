package gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Initializable;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Destroyable;

/** User: mkw Date: Sep 23, 2003 Time: 3:51:39 AM */
public class ImpactExceptionLoggingInit implements Initializable, Destroyable {
  public void initialize(ServletContext config) throws BasePrsException {
    Logger logger = Logger.getLogger(ImpactExceptionLoggingUtility.DETAILED_EXCEPTION_LOGGER);
    // Remove exisitng handlers because of deadlock possibility in SJSAS.
    clearHandlers(logger);
    // Do not use parent handlers.
    logger.setUseParentHandlers(false);
    ImpactExceptionFilter filter = new ImpactExceptionFilter();
    logger.setFilter(filter);
    ImpactExceptionLogHandler handler = new ImpactExceptionLogHandler();
    handler.setFilter(filter); // Not strictly necessary
    handler.setFormatter(new ImpactExceptionFormatter());
    handler.setLevel(Level.ALL);
    // Clear existing handlers again so SJSAS does not try to log the exception.
    clearHandlers(logger);
    logger.addHandler(handler);
    logger.setLevel(Level.ALL);
  }

  private void clearHandlers(Logger logger) {
    Handler[] handlers = logger.getHandlers();
    for (int i = 0; i < handlers.length; i++) {
      Handler handler = handlers[i];
      logger.removeHandler(handler);
      handler.flush();
    }
  }

  public void destroy(ServletContext config) throws BasePrsException {
    Logger logger = Logger.getLogger(ImpactExceptionLoggingUtility.DETAILED_EXCEPTION_LOGGER);
    clearHandlers(logger);
    logger.setFilter(null);
  }
}
