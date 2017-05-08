package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveAllegationDetailTest extends BaseServiceTest {

  protected RetrieveAllegationDetail retrieveAllegationDetail = null;

  public RetrieveAllegationDetailTest(String testName) {
    super(testName);
  }

  public void setRetrieveUserProfile(RetrieveAllegationDetail retrieveAllegationDetail) {
    this.retrieveAllegationDetail = retrieveAllegationDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveAllegationDetailTest("testRetrieveAllegationDetail_ValidData"));
    suite.addTest(new RetrieveAllegationDetailTest("testRetrieveAllegationDetail_InvalidData"));
    return suite;
  }

  public void testRetrieveAllegationDetail_ValidData() {

    CINV46SI cinv46si = new CINV46SI();
    cinv46si.setUlIdStage(318);
    cinv46si.setUlIdAllegation(240);

    try {
      CINV46SO cinv46so= retrieveAllegationDetail.retrieveAllegationDetail(cinv46si);
     
    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }

    }
  }

  public void testRetrieveAllegationDetail_InvalidData() {
    CINV46SI cinv46si = new CINV46SI();
    cinv46si.setUlIdStage(0);
    cinv46si.setUlIdAllegation(9999);

    try {
      retrieveAllegationDetail.retrieveAllegationDetail(cinv46si);
      //fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }

    }
  }

}
