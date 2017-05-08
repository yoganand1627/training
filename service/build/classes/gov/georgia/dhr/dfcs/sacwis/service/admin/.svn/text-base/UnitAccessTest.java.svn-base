package gov.georgia.dhr.dfcs.sacwis.service.admin;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;

public class UnitAccessTest extends BaseServiceTest {
  protected UnitAccess unitAccess = null;

  public UnitAccessTest(String testName) {
    super(testName);
  }

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new UnitAccessTest("testCheckForUnitAccess1"));
    suite.addTest(new UnitAccessTest("testCheckForUnitAccess2"));
    suite.addTest(new UnitAccessTest("testCheckForUnitAccess3"));

    return suite;
  }

  // Unit Id = 0
  public void testCheckForUnitAccess1() {
    CCMN04UI ccmn04ui = new CCMN04UI();
    ccmn04ui.setUlIdUnit(0);

    unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
  }

  // Unit Id <> 0, !isApprover and no unit access whatsoever
  public void testCheckForUnitAccess2() {
    CCMN04UI ccmn04ui = new CCMN04UI();
    UlIdPerson_ARRAY_CCMN04UI idPerson_ARRAY_CCMN04UI = new UlIdPerson_ARRAY_CCMN04UI();
    ccmn04ui.setUlIdUnit(605);
    idPerson_ARRAY_CCMN04UI.addUlIdPerson(5172);
    ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(idPerson_ARRAY_CCMN04UI);

    unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
  }

  // Unit Id <> 0, isApprover
  public void testCheckForUnitAccess3() {
    CCMN04UI ccmn04ui = new CCMN04UI();
    UlIdPerson_ARRAY_CCMN04UI idPerson_ARRAY_CCMN04UI = new UlIdPerson_ARRAY_CCMN04UI();
    ccmn04ui.setUlIdUnit(605);
    idPerson_ARRAY_CCMN04UI.addUlIdPerson(1);
    ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(idPerson_ARRAY_CCMN04UI);

    unitAccess.checkForPersonWithUnitAccess(ccmn04ui);

  }
}
