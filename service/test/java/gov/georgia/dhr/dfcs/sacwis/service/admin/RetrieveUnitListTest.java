package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveUnitListTest extends BaseServiceTest {
  protected RetrieveUnitList retrieveUnitList = null;

  public RetrieveUnitListTest(String testName) {
    super(testName);
  }

  public void setRetrieveUnitList(RetrieveUnitList retrieveUnitList) {
    this.retrieveUnitList = retrieveUnitList;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveUnitListTest("testRetrieveUnitList"));
    return suite;
  }

  public void testRetrieveUnitList() {
    CCMN24SI ccmn24si = new CCMN24SI();     
    ccmn24si.setSzCdUnitProgram("CPS");
    ccmn24si.setSzCdUnitRegion("001");
    ccmn24si.setSzNbrUnit("04");
    
    retrieveUnitList.retrieveUnitList(ccmn24si);
  }
  
}
