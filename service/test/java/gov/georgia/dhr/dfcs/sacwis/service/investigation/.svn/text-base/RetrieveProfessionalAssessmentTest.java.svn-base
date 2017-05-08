package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveProfessionalAssessmentTest extends BaseServiceTest {
  
  protected RetrieveProfessionalAssessment retrieveProfessionalAssessment = null;

  public RetrieveProfessionalAssessmentTest(String testName) {
    super(testName);
  }

  public void setRetrieveProfessionalAssessment(RetrieveProfessionalAssessment retrieveProfessionalAssessment) {
    this.retrieveProfessionalAssessment = retrieveProfessionalAssessment;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveProfessionalAssessmentTest("test1RetrieveProfessionalAssessment"));
    suite.addTest(new RetrieveProfessionalAssessmentTest("test2RetrieveProfessionalAssessment"));
    suite.addTest(new RetrieveProfessionalAssessmentTest("test3RetrieveProfessionalAssessment"));
    suite.addTest(new RetrieveProfessionalAssessmentTest("test4RetrieveProfessionalAssessment"));
    return suite;
  } 
  

  public void test1RetrieveProfessionalAssessment() {
    CINV29SI cinv29si = new CINV29SI();
    
    cinv29si.setUlIdEvent(5600088);
    cinv29si.setUlIdStage(10);
    cinv29si.setSzSysCdWinMode(PageModeConstants.INQUIRE);
    
    retrieveProfessionalAssessment.retrieveProfessionalAssessment(cinv29si);
  } 
  

  public void test2RetrieveProfessionalAssessment() {
    CINV29SI cinv29si = new CINV29SI();
    
    cinv29si.setUlIdEvent(5600088);
    cinv29si.setUlIdStage(10);
    cinv29si.setSzSysCdWinMode(PageModeConstants.MODIFY);
    
    retrieveProfessionalAssessment.retrieveProfessionalAssessment(cinv29si);
  }

  public void test3RetrieveProfessionalAssessment() {
    CINV29SI cinv29si = new CINV29SI();
    
    cinv29si.setUlIdEvent(5600510);
    cinv29si.setUlIdStage(10);
    cinv29si.setSzSysCdWinMode(PageModeConstants.MODIFY);
    
    retrieveProfessionalAssessment.retrieveProfessionalAssessment(cinv29si);
  }
  

  public void test4RetrieveProfessionalAssessment() {
    CINV29SI cinv29si = new CINV29SI();
    
    cinv29si.setUlIdEvent(0);
    cinv29si.setUlIdStage(10);
    cinv29si.setSzSysCdWinMode(PageModeConstants.MODIFY);
    
    try {
      retrieveProfessionalAssessment.retrieveProfessionalAssessment(cinv29si);
      //fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }
    }
  }

}
