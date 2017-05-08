/**
 * Created on May 28, 2006 at 9:41:00 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service;

import org.hibernate.SessionFactory;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class BaseServiceTest extends AbstractTransactionalDataSourceSpringContextTests {
  protected SessionFactory sessionFactory;

  public BaseServiceTest(String testName) {
    super(testName);
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  protected String[] getConfigLocations() {
    return new String[] {"service-context.xml", "test-service-context.xml"};
  }

  protected int getSequenceNextval(String sequenceName) {
    return jdbcTemplate.queryForInt("SELECT " + sequenceName + ".NEXTVAL FROM DUAL");
  }

  public void testConfig() {
    // Nothing needed.
  }
}
