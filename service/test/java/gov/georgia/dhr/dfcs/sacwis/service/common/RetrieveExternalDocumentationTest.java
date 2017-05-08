package gov.georgia.dhr.dfcs.sacwis.service.common;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCriminalHistoryTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExternalDocumentationSO;

public class RetrieveExternalDocumentationTest extends BaseServiceTest {
  
  protected RetrieveExternalDocumentation retrieveExternalDocumentation = null;
  
  public RetrieveExternalDocumentationTest(String testName) {
    super(testName);
  }

  public void setRetrieveExternalDocumentation(RetrieveExternalDocumentation retrieveExternalDocumentation) {
    this.retrieveExternalDocumentation = retrieveExternalDocumentation;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveExternalDocumentationTest("testRetrieveExternalDocumentation"));
    return suite;
  }
  
  public void testRetrieveExternalDocumentation(){
    CINV23SI cinv23si = new CINV23SI();
    cinv23si.setUlIdCase(5600032);
    retrieveExternalDocumentation.retrieveExternalDocumentation(cinv23si);
  }

}
