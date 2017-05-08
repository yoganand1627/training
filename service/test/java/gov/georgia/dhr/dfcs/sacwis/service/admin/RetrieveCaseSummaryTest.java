package gov.georgia.dhr.dfcs.sacwis.service.admin;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI;

public class RetrieveCaseSummaryTest extends BaseServiceTest {

  public RetrieveCaseSummaryTest(String retrieveCaseSummary) {
    super(retrieveCaseSummary);
  }
  
  public void setRetrieveCaseSummary(RetrieveCaseSummary retrieveCaseSummary) {
    this.retrieveCaseSummary = retrieveCaseSummary;
  }

  protected RetrieveCaseSummary retrieveCaseSummary = null;
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveCaseSummaryTest("testRetrieveCaseSummary"));
    return suite;
  }
  
  public void testRetrieveCaseSummary() {
    CCMN37SI ccmn37si = new CCMN37SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn37si.setArchInputStruct(archInputStruct);
    int idCase = 5600847;
    ccmn37si.setUlIdCase(idCase);

    retrieveCaseSummary.retrieveCaseSummary(ccmn37si);
  }
}
