/**
 * Created on May 28, 2006 at 9:21:47 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN08SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveUnitSupervisorTest extends BaseServiceTest {
  protected RetrieveUnitSupervisor retrieveUnitSupervisor = null;

  public RetrieveUnitSupervisorTest(String testName) {
    super(testName);
  }

  public void setRetrieveUnitSupervisor(RetrieveUnitSupervisor retrieveUnitSupervisor) {
    this.retrieveUnitSupervisor = retrieveUnitSupervisor;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveUnitSupervisorTest("testRetrieveUnitSupervisor"));
    suite.addTest(new RetrieveUnitSupervisorTest("testRetrieveUnitSupervisorNull"));
    return suite;
  }

  public void testRetrieveUnitSupervisor() {
    CCMN08SI ccmn08si = new CCMN08SI();
    ccmn08si.setSzCdUnitProgram("APS");
    ccmn08si.setSzCdUnitRegion("001");
    ccmn08si.setSzNbrUnit("00");
    retrieveUnitSupervisor.findUnitSupervisorName(ccmn08si);
  }
  
  public void testRetrieveUnitSupervisorNull() {
    CCMN08SI ccmn08si = new CCMN08SI();
    
    try {
      retrieveUnitSupervisor.findUnitSupervisorName(ccmn08si);
    } catch (ServiceException e) {      
      //do nothing
    }
  }
}
