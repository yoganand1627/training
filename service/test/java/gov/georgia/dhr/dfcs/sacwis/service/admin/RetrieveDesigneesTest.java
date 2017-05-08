package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC16SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveDesigneesTest extends BaseServiceTest {
  protected RetrieveDesignees retrieveDesignees = null;

  public RetrieveDesigneesTest(String testName) {
    super(testName);
  }

  public void setRetrieveDesignees(RetrieveDesignees retrieveDesignees) {
    this.retrieveDesignees = retrieveDesignees;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveDesigneesTest("testRetrieveDesignees"));
    return suite;
  }

  public void testRetrieveDesignees() {
    CARC16SI carc16si = new CARC16SI();
    carc16si.setUlIdPerson(6533);
    retrieveDesignees.retrieveDesigneeAssignments(carc16si);
  }
}
