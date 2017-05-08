package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC29SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveIncomeAndResourcesTest extends BaseServiceTest {

  protected RetrieveIncomeAndResources retrieveIncomeAndResources = null;

  public void setRetrieveIncomeAndResources(RetrieveIncomeAndResources retrieveIncomeAndResources) {
    this.retrieveIncomeAndResources = retrieveIncomeAndResources;
  }

  public RetrieveIncomeAndResourcesTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveIncomeAndResourcesTest("testRetrieveIncomeAndResources"));
    return suite;
  }

  public void testRetrieveIncomeAndResources() {
    CCFC29SI ccfc29si = new CCFC29SI();
    ccfc29si.setUlIdPerson(5600821);
    retrieveIncomeAndResources.retrieveIncomeAndResources(ccfc29si);
  }

}
