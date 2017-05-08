package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IntNarrBlobOutRec;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveIntakeNarrativeTest extends BaseServiceTest {

  protected RetrieveIntakeNarrative retrieveIntakeNarrative = null;

  public RetrieveIntakeNarrativeTest(String testName) {
    super(testName);
  }

  public void setRetrieveUserProfile(RetrieveIntakeNarrative retrieveIntakeNarrative) {
    this.retrieveIntakeNarrative = retrieveIntakeNarrative;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveIntakeNarrativeTest("testRetrieveIntakeNarrative_ValidData"));
    suite.addTest(new RetrieveIntakeNarrativeTest("testRetrieveIntakeNarrative_InvalidData"));
    return suite;
  }

  public void testRetrieveIntakeNarrative_ValidData() {

    IntNarrBlobInRec intNarrBlobInRec = new IntNarrBlobInRec();
    intNarrBlobInRec.setIntNarrBlobRtrvStruct(new IntNarrBlobRtrvStruct());
    intNarrBlobInRec.getIntNarrBlobRtrvStruct().setUlIdStage(19);
    IntNarrBlobOutRec intNarrBlobOutRec = retrieveIntakeNarrative.findIntakeNarrative(intNarrBlobInRec);

    // TODO: This needs to be complete when forms architecture is determined
    // intNarrBlobOutRec.BLOBStruct = pCINT42DOutputRec.getBLOBStruct();
    // intNarrBlobOutRec.BLOBStruct = incomingNarrative.getNarrIncoming();

  }

  public void testRetrieveIntakeNarrative_InvalidData() {

    IntNarrBlobInRec intNarrBlobInRec = new IntNarrBlobInRec();
    intNarrBlobInRec.setIntNarrBlobRtrvStruct(new IntNarrBlobRtrvStruct());
    intNarrBlobInRec.getIntNarrBlobRtrvStruct().setUlIdStage(0);

    try {
      IntNarrBlobOutRec intNarrBlobOutRec = retrieveIntakeNarrative.findIntakeNarrative(intNarrBlobInRec);
      fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }

    }
  }

}
