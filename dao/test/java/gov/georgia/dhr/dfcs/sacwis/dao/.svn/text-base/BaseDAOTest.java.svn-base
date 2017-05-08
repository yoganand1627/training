/**
 * Created on Jun 7, 2006 at 4:54:15 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class BaseDAOTest extends AbstractTransactionalDataSourceSpringContextTests {
  protected static final String[] CONFIG_LOCATIONS = new String[] {"test-dao-context.xml", "dao-context.xml"};
  protected static ConfigurableApplicationContext context;

  public BaseDAOTest(String string) throws Exception {
    super(string);
    // Cache the context if it exists already.
    if(context == null) {
      //noinspection AssignmentToStaticFieldFromInstanceMethod,NonThreadSafeLazyInitialization
      context = getContext(CONFIG_LOCATIONS);
    } else {
      addContext(CONFIG_LOCATIONS, context);
    }
  }

  protected String[] getConfigLocations() {
    return CONFIG_LOCATIONS;
  }

  public void testConfig() {
    // Nothing needed.
  }
}
