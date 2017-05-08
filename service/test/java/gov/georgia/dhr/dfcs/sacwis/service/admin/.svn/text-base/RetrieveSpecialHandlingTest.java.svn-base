package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveSpecialHandling;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SG01;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveSpecialHandlingTest extends BaseServiceTest {
  protected RetrieveSpecialHandling retrieveSpecialHandling = null;

  public RetrieveSpecialHandlingTest(String testName) {
    super(testName);
  }

  public void setRetrieveSpecialHandling(RetrieveSpecialHandling retrieveSpecialHandling) {
    this.retrieveSpecialHandling = retrieveSpecialHandling;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveSpecialHandlingTest("retrieveSpecialHandling"));
    suite.addTest(new RetrieveSpecialHandlingTest("retrieveSpecialHandling_CASE_NOT_FOUND"));

    return suite;
  }

  public void retrieveSpecialHandling() {
    CCMN81SI ccmn81si = new CCMN81SI();
    CCMN81SG01 ccmn81sg01 = new CCMN81SG01();
    // capscase 100001 has CdCaseSpecialHandling <> null
    ccmn81sg01.setUlIdCase(10001);
    ccmn81si.setCCMN81SG01(ccmn81sg01);
    retrieveSpecialHandling.findCapsCase(ccmn81si);
  }

  public void retrieveSpecialHandling_CASE_NOT_FOUND() {
    CCMN81SI ccmn81si = new CCMN81SI();
    CCMN81SG01 ccmn81sg01 = new CCMN81SG01();
    // capscase 100001 has CdCaseSpecialHandling <> null
    ccmn81sg01.setUlIdCase(0);
    ccmn81si.setCCMN81SG01(ccmn81sg01);

    try {
      retrieveSpecialHandling.findCapsCase(ccmn81si);
      fail("Expected ServiceException with Messages.SQl_NOT_FOUND.");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw e;
      }
    }

  }

}
