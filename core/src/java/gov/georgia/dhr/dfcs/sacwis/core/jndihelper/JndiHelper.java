package gov.georgia.dhr.dfcs.sacwis.core.jndihelper;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

/**
 * This file includes the JndiHelper class. This class creates an initial context and provides access to the JNDI API,
 * simplifying object lookups, naming and binding functionality.  Functionality is also provided to enable the lookup of
 * EJBs.
 *
 * @author Kiran R. Narahari, October 8, 2001
 * @version 1.00
 */

public class JndiHelper {

  private static InitialContext initialContext;
  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
          GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                             "exception.globalLogger"));

  static {
    try {
      // TODO: Can we cache the context safely this way???
      //noinspection JNDIResourceOpenedButNotSafelyClosed
      initialContext = new InitialContext();
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL,
                                  "Unexpected exception in JNDI Helper while creating an intial context", e);
    }
  }

  /**
   * A static method that retrieves the named object.
   *
   * @param lookupName The name of the object to lookup
   * @return The object bound to lookupName
   */
  @SuppressWarnings({"unchecked", "UnusedDeclaration"})
  public static <T> T lookup(String lookupName, Class<T> resultClass) {
    return (T) lookup(lookupName);
  }

  /**
   * A static method that retrieves the named object.
   *
   * @param lookupName The name of the object to lookup
   * @return The object bound to lookupName
   */
  public static Object lookup(String lookupName) {
    Object lookupResult;
    try {
      lookupResult = JndiHelper.initialContext.lookup(lookupName);
    } catch (NamingException e) {
      throw new JndiHelperRuntimeException("Lookup operation failed for " + lookupName, e);
    }
    return lookupResult;
  }
}

