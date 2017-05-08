package gov.georgia.dhr.dfcs.sacwis.service.financials;


import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON21SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveServiceListTest extends BaseServiceTest {
  
  protected RetrieveServiceList retrieveServiceList = null;

  public RetrieveServiceListTest(String testName) {
    super(testName);
  }

  public void setRetrieveServiceList(RetrieveServiceList retrieveServiceList) {
    this.retrieveServiceList = retrieveServiceList;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveServiceListTest("test1RetrieveServiceList"));
    suite.addTest(new RetrieveServiceListTest("test2RetrieveServiceList"));
    return suite;
  }

  public void test1RetrieveServiceList() {
    CCON21SI ccon21si = new CCON21SI();
    
    int idSvcAuth = 5500000;
    ccon21si.setUlIdSvcAuth(idSvcAuth);
    
    retrieveServiceList.retrieveServiceList(ccon21si);
  }

  public void test2RetrieveServiceList() {
    CCON21SI ccon21si = new CCON21SI();
    
    int idSvcAuth = 0;
    ccon21si.setUlIdSvcAuth(idSvcAuth);
    
    retrieveServiceList.retrieveServiceList(ccon21si);
  }

}
