/**
 * Created on May 28, 2006 at 9:21:47 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveStaffSecurityTest extends BaseServiceTest {
  protected RetrieveStaffSecurity retrieveStaffSecurity = null;

  public RetrieveStaffSecurityTest(String testName) {
    super(testName);
  }

  public void setRetrieveStaffSecurity(RetrieveStaffSecurity retrieveStaffSecurity) {
    this.retrieveStaffSecurity = retrieveStaffSecurity;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveStaffSecurityTest("testRetrieveStaffSecurity"));
    return suite;
  }

  public void testRetrieveStaffSecurity() {
    CARC14SI carc14si = new CARC14SI();
    carc14si.setUlIdPerson(6533);
    retrieveStaffSecurity.findEmployeeSecurityInformation(carc14si);
  }
}
