/**
 * Created on Mar 24, 2006 at 1:41:34 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Map;

import javax.sql.DataSource;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDaoConfigurationTest extends TestCase {
  public SpringDaoConfigurationTest(String string) {
    super(string);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SpringDaoConfigurationTest("testSpringDaoConfigration"));
    return suite;
  }

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testSpringDaoConfigration() {
    //noinspection ResultOfObjectAllocationIgnored
    new ClassPathXmlApplicationContext(new String[] {"test-spring-dao-context.xml", "dao-context.xml"});
  }
}