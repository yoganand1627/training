package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.config.GrndsConfigurationEnvironment;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsContextListener;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Destroyable;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Initializable;

/**
 * This context listener exists solely to do custom initialization of the init* properties in the domain properties
 * file.
 */
public class SACWISContextListener extends GrndsContextListener {

  private static final String TRACE_TAG = "SACWISContextListener";
  private static final String INITIALIZATION_PREFIX = "init";

  /**
   * Used to initialize startup classes.
   *
   * @param servletContextEvent
   */
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    super.contextInitialized(servletContextEvent);
    ServletContext servletContext = servletContextEvent.getServletContext();
    GrndsTrace.enterScope(TRACE_TAG + ".contextInitialized()");
    servletContext.log("Beginning Initialization of SACWIS Components...");
    GrndsConfigurationEnvironment config =
            GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
    executeOnInitClasses(config, servletContext, true);
    servletContext.log("Completed SACWIS Initialization.");
    GrndsTrace.exitScope();
  }

  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    ServletContext servletContext = servletContextEvent.getServletContext();
    GrndsTrace.enterScope(TRACE_TAG + ".contextDestroyed()");
    servletContext.log("Beginning Destruction of SACWIS Components...");
    GrndsConfigurationEnvironment config =
            GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
    executeOnInitClasses(config, servletContext, false);
    servletContext.log("Completed SACWIS Destruction.");
    super.contextDestroyed(servletContextEvent);
    // The last thing that we need to do during unload is shut down the Grnds Configuration
    GrndsConfiguration.shutdown();
    GrndsTrace.exitScope();
  }

  /**
   * This method will use the architecture configuration file and look for all values that follow the pattern of
   * "init#".  When it hits a number that does not return a value it will stop iterating and consider the initialization
   * complete.  As each class is initialized, it will add a statement to the initLog which will be returned to the
   * calling method.
   *
   * @param config         The GrndsConfiguration object to look for the "init#" values in.
   * @param servletContext The servelt context
   * @param init           Whether to initialize or destroy classes.
   * @throws Exception If an error occurs during initialization.
   */
  void executeOnInitClasses(GrndsConfigurationEnvironment config, ServletContext servletContext, boolean init) {
    for (int i = 1; ; i++) {
      String className = null;
      try {
        //look up the class names in order for initialization.  If we don't find one for
        //a specific value of "i", we must have initialized all of the classes in the list.
        GrndsTrace.msg(TRACE_TAG, 5, "Class#: " + i);
        className = config.getProperty(INITIALIZATION_PREFIX + i);
        if (className == null) {
          break;
        }
        GrndsTrace.msg(TRACE_TAG, 5, "ClassName: " + className);
        Class initializationClass = Class.forName(className);
        if (init && Initializable.class.isAssignableFrom(initializationClass)) {
          Initializable initializable = (Initializable) initializationClass.newInstance();
          GrndsTrace.msg(TRACE_TAG, 5, "Class Instance: " + initializable);
          servletContext.log("Initializing: " + className);
          long startInit = System.currentTimeMillis();
          initializable.initialize(servletContext);
          long endInit = System.currentTimeMillis();
          servletContext.log("Completed initializing '" + className + "' in " + (endInit - startInit) +
                             " milliseconds.");
        } else if (Destroyable.class.isAssignableFrom(initializationClass)) {
          Destroyable destroyable = (Destroyable) initializationClass.newInstance();
          GrndsTrace.msg(TRACE_TAG, 5, "Class Instance: " + destroyable);
          servletContext.log("Destroying: " + className);
          long startInit = System.currentTimeMillis();
          destroyable.destroy(servletContext);
          long endInit = System.currentTimeMillis();
          servletContext.log("Completed destroying '" + className + "' in " + (endInit - startInit) + " milliseconds.");
        }
      } catch (Exception e) {
        // Allow each init to try to work; so if one fails, it still trys the next
        servletContext.log("Failed to " + (init ? "initialize" : "destroy") + " class: " + className != null ?
                           className : "unknown", e);
      }
    }
  }
}
