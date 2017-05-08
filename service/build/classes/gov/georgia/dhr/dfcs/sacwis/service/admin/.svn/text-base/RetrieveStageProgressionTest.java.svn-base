package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveStageProgressionTest extends BaseServiceTest {

  public RetrieveStageProgressionTest(String retrieveStageProgression) {
    super(retrieveStageProgression);
  }
  
  public void setRetrieveStageProgression(RetrieveStageProgression retrieveStageProgression) {
    this.retrieveStageProgression = retrieveStageProgression;
  }

  protected RetrieveStageProgression retrieveStageProgression = null;
  
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveStageProgressionTest("testRetrieveStageProgression"));
    return suite;
  }
  
  public void testRetrieveStageProgression() {
    CCMN39SI ccmn39si = new CCMN39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn39si.setArchInputStruct(archInputStruct);
    ccmn39si.setSzCdStage("INV");
    ccmn39si.setSzCdStageProgram("CPS");
    ccmn39si.setSzCdStageReasonClosed("45");

    retrieveStageProgression.retrieveStageProgression(ccmn39si);
  }
}
