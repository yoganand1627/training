/**
 * Created on Jun 28, 2006 at 9:47:07 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SJSASContextSingletonBeanFactoryLocator;

import java.lang.reflect.Field;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.xml.DelegatingEntityResolver;
import org.xml.sax.XMLReader;

@SuppressWarnings({"deprecation"})
public class SpringMainConfigurationTest extends TestCase {

  private static final String APPLICATION_TEST_CONTEXT = "classpath:test-app-context.xml";
  private static final String HIBERNATE_FACADE_EJBS_CONTEXT = "ejbs-client-context.xml";

  private BaseSpringStatelessSessionBean targetBean;
  private String name;

  public SpringMainConfigurationTest(String interfaceName) throws Exception {
    super("testBean");
    String className = interfaceName + "Bean";
    Class ejbClass = Class.forName(className);
    BaseSpringStatelessSessionBean springStatelessSessionBean = (BaseSpringStatelessSessionBean) ejbClass.newInstance();
    springStatelessSessionBean.setSessionContext(null);
    // Override the context locator defined in the test.
    BeanFactoryLocator locator = SJSASContextSingletonBeanFactoryLocator.getInstance(APPLICATION_TEST_CONTEXT);
    springStatelessSessionBean.setBeanFactoryLocator(locator);
    this.targetBean = springStatelessSessionBean;
    this.name = "test" + ejbClass.getSimpleName() + "Configuration";
  }

  public static Test suite() throws Exception {
    TestSuite suite = new TestSuite();
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    XMLReader xmlReader = saxParser.getXMLReader();
    SAXReader reader = new SAXReader(xmlReader);
    // We're parsing a Spring config file, so use their entity resolver.
    reader.setEntityResolver(new DelegatingEntityResolver(SpringMainConfigurationTest.class.getClassLoader()));
    reader.setValidation(true);
    // Turn validation on to catch schema violations w/o needing to even start Spring.
    reader.setFeature("http://apache.org/xml/features/validation/schema", true);
    ClassLoader loader = SpringMainConfigurationTest.class.getClassLoader();
    Document document = reader.read(loader.getResource(HIBERNATE_FACADE_EJBS_CONTEXT));
    Element root = document.getRootElement();
    for (Iterator beanIt = root.elementIterator("bean"); beanIt.hasNext();) {
      Element bean = (Element) beanIt.next();
      for (Iterator propIt = bean.elementIterator("property"); propIt.hasNext();) {
        Element property = (Element) propIt.next();
        if ("businessInterface".equals(property.attribute("name").getValue())) {
          String interfaceName = property.attribute("value").getValue();
          suite.addTest(new SpringMainConfigurationTest(interfaceName));
        }
      }
    }
    return suite;
  }


  public void testBean() throws CreateException, IllegalAccessException {
    // Execte ejbCreate() becuase it forces Spring to wire the EJBs.
    this.targetBean.ejbCreate();
    // Verify that the bean is completely wired.
    Field[] fields = this.targetBean.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      Field field = fields[i];
      field.setAccessible(true);
      assertNotNull("The field " + field.getName() + " was not correctly wired.", field.get(this.targetBean));
    }
  }

  public String getName() {
    return this.name;
  }
}
