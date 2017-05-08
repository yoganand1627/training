package gov.georgia.dhr.dfcs.sacwis.service.security;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC12SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveSecurityClassTest extends BaseServiceTest {
  protected RetrieveSecurityClass retrieveSecurityClass = null;

  public RetrieveSecurityClassTest(String testName) {
    super(testName);
  }

  public void setRetrieveSecurityClass(RetrieveSecurityClass retrieveSecurityClass) {
    this.retrieveSecurityClass = retrieveSecurityClass;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveSecurityClassTest("testRetrieveSecurityClass"));

    return suite;
  }

  public void testRetrieveSecurityClass() {
    CARC12SI carc12si = new CARC12SI();
    retrieveSecurityClass.retrieveSecurityClass(carc12si);
  }
}
