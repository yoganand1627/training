/**
 * Created on Oct 9, 2006 at 7:38:34 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

/**
 * This BeanFactoryLocator exists solely to get around an EJB classloader bug in SJSAS.  It creates an instance of
 * {@link SJSASClassPathXmlApplicationContext} instead, which contains the work-around.
 */
public class SJSASContextSingletonBeanFactoryLocator extends ContextSingletonBeanFactoryLocator {

  /** @see org.springframework.context.access.ContextSingletonBeanFactoryLocator#BEANS_REFS_XML_NAME */
  private static final String BEANS_REFS_XML_NAME = "classpath*:beanRefContext.xml";

  // the keyed singleton instances
  private static final Map<String, BeanFactoryLocator> instances = new HashMap<String, BeanFactoryLocator>();

  /** @see {@link ContextSingletonBeanFactoryLocator#ContextSingletonBeanFactoryLocator()} */
  protected SJSASContextSingletonBeanFactoryLocator() {
    super(BEANS_REFS_XML_NAME);
  }

  /** @see {@link ContextSingletonBeanFactoryLocator#ContextSingletonBeanFactoryLocator(String)} */
  protected SJSASContextSingletonBeanFactoryLocator(String resourceName) {
    super(resourceName);
  }

  /** @see {@link super#getInstance()} */
  @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass"})
  public static BeanFactoryLocator getInstance() throws BeansException {
    return getInstance(BEANS_REFS_XML_NAME);
  }

  /** @see {@link super#getInstance(String)} */
  @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass"})
  public static BeanFactoryLocator getInstance(String selector) throws BeansException {
    // For backwards compatibility, we prepend "classpath*:" to the selector name if there
    //   is no other prefix (i.e. "classpath*:", "classpath:", or some URL prefix).
    if (!ResourcePatternUtils.isUrl(selector)) {
      selector = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + selector;
    }

    synchronized (instances) {
      if (logger.isDebugEnabled()) {
        logger.debug("ContextSingletonBeanFactoryLocator.getInstance(): instances.hashCode=" +
                     instances.hashCode() + ", instances=" + instances);
      }
      BeanFactoryLocator bfl = instances.get(selector);
      if (bfl == null) {
        bfl = new SJSASContextSingletonBeanFactoryLocator(selector);
        instances.put(selector, bfl);
      }
      return bfl;
    }
  }

  protected BeanFactory createDefinition(String resourceName, String factoryKey) throws BeansException {
    return new SJSASClassPathXmlApplicationContext(new String[] {resourceName}, false);
  }

  /**
   * Allows the application to be fully unloaded.
   */
  public static void destroy() {
    instances.clear();
  }
}
