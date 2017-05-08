/**
 * Created on Aug 20, 2006 at 11:13:40 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SJSASContextSingletonBeanFactoryLocator;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SlsbFacade;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SpringConstants;

import java.util.Arrays;

import javax.servlet.ServletContext;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.config.GrndsConfigurationEnvironment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextsInit implements Initializable, Destroyable, SpringConstants {
  private static Log log = LogFactory.getLog(SpringContextsInit.class);

  private static final GrndsConfigurationEnvironment GRNDS_CONFIGURATION =
          GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
  /** {@link Boolean#parseBoolean(String)} defaults to false, so it is appropriate to use here. */
  private static boolean DEV_MODE = Boolean.parseBoolean(GRNDS_CONFIGURATION.getProperty("development.mode"));

  public void initialize(ServletContext servletContext) throws BasePrsException {
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    if (DEV_MODE) {
      // In development mode, all we need to do is to initialize the Hibernat Session Factory.
      BeanFactoryLocator locator = SJSASContextSingletonBeanFactoryLocator.getInstance(SERVICE_CONTEXT_SELECTOR);
      locator.useBeanFactory(SERVICE_BEAN_FACTORY).getFactory().getBean("sessionFactory");
      return;
    }
    // For server mode, load all EJBs and execute a pseudo-method to verify that they load properly.
    initializeAllEJBs(context);
  }

  private void initializeAllEJBs(ApplicationContext context) {
    // Loop over all the beans in the factory to make sure that they can be created.
    String[] beanNames = context.getBeanDefinitionNames();
    // Guarantee alpha-order for consistent results.
    Arrays.sort(beanNames);
    for (int i = 0; i < beanNames.length; i++) {
      String beanName = beanNames[i];
      try {
        Object bean = context.getBean(beanName);
        if (bean instanceof SlsbFacade) {
          if (log.isInfoEnabled()) {
            log.info("Initializing EJB: " + beanName);
          }
          ((SlsbFacade) bean).initialize();
        }
      } catch (BeanIsAbstractException e) {
        // Ignore this
      }
    }
  }

  public void destroy(ServletContext config) throws BasePrsException {
    // Shut down the business context.
    BeanFactoryLocator locator = SJSASContextSingletonBeanFactoryLocator.getInstance(SERVICE_CONTEXT_SELECTOR);
    ((ConfigurableApplicationContext) locator.useBeanFactory(SERVICE_BEAN_FACTORY).getFactory()).close();
    SJSASContextSingletonBeanFactoryLocator.destroy();
  }
}
