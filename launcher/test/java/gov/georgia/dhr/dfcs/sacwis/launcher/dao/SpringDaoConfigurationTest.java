/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Kapil Aggarwal
 * Nov 6, 2007  5:11:02 PM, SACWIS PROJECT 2007, ATLANTA, GA
 */
public class SpringDaoConfigurationTest extends TestCase {

	/**
	 * @param name
	 */
	public SpringDaoConfigurationTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new SpringDaoConfigurationTest("testSpringDaoConfigration"));
		return suite;
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}


	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}


	public void testSpringDaoConfigration() {
		//noinspection ResultOfObjectAllocationIgnored
		new ClassPathXmlApplicationContext(new String[] {"dao-context.xml"});
	}

}
