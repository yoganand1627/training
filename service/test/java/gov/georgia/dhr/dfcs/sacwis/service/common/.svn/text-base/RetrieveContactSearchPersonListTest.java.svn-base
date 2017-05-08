package gov.georgia.dhr.dfcs.sacwis.service.common;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS03SI;

public class RetrieveContactSearchPersonListTest extends BaseServiceTest {
  
  protected RetrieveContactSearchPersonList retrieveContactSearchPersonList= null;
  
  public RetrieveContactSearchPersonListTest(String testName) {
    super(testName);
  }

  public void setRetrieveContactSearchPersonList(RetrieveContactSearchPersonList retrieveContactSearchPersonList) {
    this.retrieveContactSearchPersonList = retrieveContactSearchPersonList;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveContactSearchPersonListTest("testRetrieveContactSearchPersonList"));
    return suite;
  }
  
  public void testRetrieveContactSearchPersonList(){
    CSYS03SI csys03si = new CSYS03SI();
    csys03si.setUlIdStage(100);
    retrieveContactSearchPersonList.retrievePersonList(csys03si);
  }

}
