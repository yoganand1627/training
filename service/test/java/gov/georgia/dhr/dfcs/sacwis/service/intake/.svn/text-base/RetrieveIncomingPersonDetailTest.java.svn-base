package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveIncomingPersonDetailTest extends BaseServiceTest {

  protected RetrieveIncomingPersonDetail retrieveIncomingPersonDetail = null;

  public RetrieveIncomingPersonDetailTest(String testName) {
    super(testName);
  }

  public void setRetrieveIncomingPersonDetail(RetrieveIncomingPersonDetail retrieveIncomingPersonDetail) {
    this.retrieveIncomingPersonDetail = retrieveIncomingPersonDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveIncomingPersonDetailTest("testRetrieveIncomingPersonDetail_ValidData"));
    suite.addTest(new RetrieveIncomingPersonDetailTest("testRetrieveIncomingPersonDetail_InvalidData"));
    return suite;
  }

  public void testRetrieveIncomingPersonDetail_ValidData() {

    CINT34SI cint34si = new CINT34SI();
    cint34si.setUlIdPerson(5600238);
    cint34si.setUlIdStage(5601400);
    CINT34SO cint34so = retrieveIncomingPersonDetail.retrieveIncomingPersonDetail(cint34si);

    // findIncomingPerson
    assertEquals("findIncomingPerson", 5600238, cint34so.getROWCINT51DO().getUlIdPerson());
    // findIncomingAddresses
    assertEquals("findIncomingAddresses", true, cint34so.getROWCINT48DO_ARRAY().enumerateROWCINT48DO()
                                                        .hasMoreElements());
    // findIncomingNames
    assertEquals("findIncomingNames", true, cint34so.getROWCINT49DO_ARRAY().enumerateROWCINT49DO().hasMoreElements());
    // findIncomingPersonIds
    assertEquals("findIncomingPersonIds", true, cint34so.getROWCINT50DO_ARRAY().enumerateROWCINT50DO()
                                                        .hasMoreElements());
    // findIncomingPhones
    assertEquals("findIncomingPhones", true, cint34so.getROWCINT52DO_ARRAY().enumerateROWCINT52DO().hasMoreElements());

  }

  public void testRetrieveIncomingPersonDetail_InvalidData() {

    CINT34SI cint34si = new CINT34SI();
    cint34si.setUlIdPerson(0);
    cint34si.setUlIdStage(0);

    try {
      CINT34SO cint34so = retrieveIncomingPersonDetail.retrieveIncomingPersonDetail(cint34si);
      fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }

    }

    // findIncomingPerson

  }

}
