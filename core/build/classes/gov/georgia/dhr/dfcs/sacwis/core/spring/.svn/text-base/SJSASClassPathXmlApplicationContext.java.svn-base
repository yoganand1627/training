/**
 * Created on Oct 8, 2006 at 10:56:43 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class exists solely to work-around a bug in the EJB classloader in SJSAS.  It seems that that classloader does
 * not correctly implement {@link ClassLoader#getResources(java.lang.String)}, so the default {@link
 * org.springframework.beans.factory.xml.PluggableSchemaResolver} does not correctly find META-INF/spring.schemas, which
 * describes the cached location of the Spring xsds.  Therefore, this implementation uses.
 */
public class SJSASClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
  public SJSASClassPathXmlApplicationContext(String configLocation) throws BeansException {
    super(configLocation);
  }

  public SJSASClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
    super(configLocations);
  }

  public SJSASClassPathXmlApplicationContext(String[] configLocations, ApplicationContext parent)
          throws BeansException {
    super(configLocations, parent);
  }

  public SJSASClassPathXmlApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
    super(configLocations, refresh);
  }

  public SJSASClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
          throws BeansException {
    super(configLocations, refresh, parent);
  }

  public SJSASClassPathXmlApplicationContext(String path, Class clazz) throws BeansException {
    super(path, clazz);
  }

  public SJSASClassPathXmlApplicationContext(String[] paths, Class clazz) throws BeansException {
    super(paths, clazz);
  }

  public SJSASClassPathXmlApplicationContext(String[] paths, Class clazz, ApplicationContext parent)
          throws BeansException {
    super(paths, clazz, parent);
  }

  protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader) {
    super.initBeanDefinitionReader(beanDefinitionReader);
    beanDefinitionReader.setEntityResolver(new SJSASResourceEntityResolver(beanDefinitionReader.getResourceLoader()));
  }
}
