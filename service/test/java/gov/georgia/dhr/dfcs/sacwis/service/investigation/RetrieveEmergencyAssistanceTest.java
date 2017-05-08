package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV11SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveEmergencyAssistanceTest extends BaseServiceTest {
  
  protected RetrieveEmergencyAssistance retrieveEmergencyAssistance = null;

  public RetrieveEmergencyAssistanceTest(String testName) {
    super(testName);
  }

  public void setRetrieveEmergencyAssistance(RetrieveEmergencyAssistance retrieveEmergencyAssistance) {
    this.retrieveEmergencyAssistance = retrieveEmergencyAssistance;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveEmergencyAssistanceTest("test1RetrieveEmergencyAssistance"));
    suite.addTest(new RetrieveEmergencyAssistanceTest("test2RetrieveEmergencyAssistance"));
    suite.addTest(new RetrieveEmergencyAssistanceTest("test3RetrieveEmergencyAssistance"));
    return suite;
  }

  public void test1RetrieveEmergencyAssistance() {
    CINV11SI cinv11si = new CINV11SI();
    
    int idStage = 304;
    cinv11si.setUlIdStage(idStage);    
    int idEvent = 325;
    cinv11si.setUlIdEvent(idEvent);
    
    retrieveEmergencyAssistance.retrieveEmergencyAssistance(cinv11si);
  }

  public void test2RetrieveEmergencyAssistance() {
    CINV11SI cinv11si = new CINV11SI();
    
    int idStage = 5500000;
    cinv11si.setUlIdStage(idStage);    
    int idEvent = 5500000;
    cinv11si.setUlIdEvent(idEvent);
    
    try {      
      retrieveEmergencyAssistance.retrieveEmergencyAssistance(cinv11si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.SQL_NOT_FOUND) {        
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  }

  public void test3RetrieveEmergencyAssistance() {
    CINV11SI cinv11si = new CINV11SI();
    
    int idStage = 304;
    cinv11si.setUlIdStage(idStage);    
    int idEvent = 285;
    cinv11si.setUlIdEvent(idEvent);
    
    retrieveEmergencyAssistance.retrieveEmergencyAssistance(cinv11si);
  }

}
