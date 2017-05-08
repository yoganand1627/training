package gov.georgia.dhr.dfcs.sacwis.service.person;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;

public class RetrievePersonDTLTest extends BaseServiceTest {
  
  protected RetrievePersonDTL retrievePersonDTL = null;
  
  public RetrievePersonDTLTest(String testName) {
    super(testName);
  }

  public void setRetrievePersonDTL(RetrievePersonDTL retrievePersonDTL) {
    this.retrievePersonDTL = retrievePersonDTL;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrievePersonDTLTest("testRetrievePersonDTL"));
    return suite;
  }
  
  public void testRetrievePersonDTL() {
    CCFC37SI ccfc37si = new CCFC37SI();
    ccfc37si.setUlIdStage(5600054);
    ccfc37si.setSzCdStagePersRole("NO");
    retrievePersonDTL.retrievePersonDTL(ccfc37si);
  }

}
