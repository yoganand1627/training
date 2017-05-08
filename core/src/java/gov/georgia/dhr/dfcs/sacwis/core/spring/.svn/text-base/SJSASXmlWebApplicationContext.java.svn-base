/**
 * Created on Oct 9, 2006 at 9:55:07 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class SJSASXmlWebApplicationContext extends XmlWebApplicationContext {
  protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader) {
    super.initBeanDefinitionReader(beanDefinitionReader);
    beanDefinitionReader.setEntityResolver(new SJSASResourceEntityResolver(beanDefinitionReader.getResourceLoader()));
  }
}
