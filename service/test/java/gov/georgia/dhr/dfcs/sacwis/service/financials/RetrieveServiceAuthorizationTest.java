package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON18SI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveServiceAuthorizationTest extends BaseServiceTest {
  
  protected RetrieveServiceAuthorization retrieveServiceAuthorization = null;

  public RetrieveServiceAuthorizationTest(String testName) {
    super(testName);
  }

  public void setRetrieveServiceAuthorization(RetrieveServiceAuthorization retrieveServiceAuthorization) {
    this.retrieveServiceAuthorization = retrieveServiceAuthorization;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveServiceAuthorizationTest("test1RetrieveServiceAuthorization"));
    suite.addTest(new RetrieveServiceAuthorizationTest("test2RetrieveServiceAuthorization"));
    suite.addTest(new RetrieveServiceAuthorizationTest("test3RetrieveServiceAuthorization"));
    suite.addTest(new RetrieveServiceAuthorizationTest("test4RetrieveServiceAuthorization"));
    return suite;
  }

  //setSzCdStage
  private static final String INVESTIGATION = CodesTables.CSTAGES_INV;
  private static final String SUBCARE = CodesTables.CSTAGES_SUB;
  private static final String FAMILY_SUBCARE = CodesTables.CSTAGES_FSU;
  private static final String FAMILY_PRES = CodesTables.CSTAGES_FPR;

  //setSzCdTask
  public static final Set<String> LEGAL_STATUS_AND_SERVICE_AUTHORIZATION_TASKS = new HashSet<String>(Arrays.asList(
          new String[] {"3020", "9020", "3520", "5040", "2100", "2310", "8530", "7100", "5640", "6075", "4190", "3290",
                        "3310", "3510", "4370", "5870", "7230", "2375", "3050", "8560", "2385", "3060", "9060", "8570",
                        "7240", "5880", "4380", "9050"}));

  public void test1RetrieveServiceAuthorization() {
    CCON18SI ccon18si = new CCON18SI();
    
    ccon18si.setArchInputStruct(new ArchInputStruct());    
    ccon18si.getArchInputStruct().setCReqFuncCd(PageModeConstants.NEW); //PageMode.NEW_USING
    ccon18si.setSzCdStage(INVESTIGATION);
    ccon18si.setUlIdStage(14);
    ccon18si.setSzCdTask("3020");
    ccon18si.setUlIdCase(10043);
    ccon18si.setUlIdEvent(5600679);
    try {      
      retrieveServiceAuthorization.retrieveServiceAuthorization(ccon18si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) { //SQL_NOT_FOUND - MSG_SVC_AUTH_NEW_STAGE - MSG_CON_PRINCIPLE       
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  }

  public void test2RetrieveServiceAuthorization() {
    CCON18SI ccon18si = new CCON18SI();
    
    ccon18si.setArchInputStruct(new ArchInputStruct());    
    ccon18si.getArchInputStruct().setCReqFuncCd(PageModeConstants.NEW); //PageMode.NEW_USING
    ccon18si.setSzCdStage(INVESTIGATION);
    ccon18si.setUlIdStage(5600566);
    ccon18si.setSzCdTask("9999");
    ccon18si.setUlIdCase(10043);
    ccon18si.setUlIdEvent(5600679);
    try {      
      retrieveServiceAuthorization.retrieveServiceAuthorization(ccon18si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_SYS_INVALID_TASK) { //SQL_NOT_FOUND - MSG_SVC_AUTH_NEW_STAGE - MSG_CON_PRINCIPLE       
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  }

  public void test3RetrieveServiceAuthorization() {
    CCON18SI ccon18si = new CCON18SI();
    
    ccon18si.setArchInputStruct(new ArchInputStruct());    
    ccon18si.getArchInputStruct().setCReqFuncCd(PageModeConstants.NEW); //PageMode.NEW_USING
    ccon18si.setSzCdStage(SUBCARE);
    ccon18si.setUlIdStage(5604047);
    ccon18si.setSzCdTask("3020");
    ccon18si.setUlIdCase(10043);
    ccon18si.setUlIdEvent(5600679);
    
    try {      
      retrieveServiceAuthorization.retrieveServiceAuthorization(ccon18si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) { //SQL_NOT_FOUND - MSG_SVC_AUTH_NEW_STAGE - MSG_CON_PRINCIPLE       
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  }

  public void test4RetrieveServiceAuthorization() {
    CCON18SI ccon18si = new CCON18SI();
    
    ccon18si.setArchInputStruct(new ArchInputStruct());    
    ccon18si.getArchInputStruct().setCReqFuncCd(PageModeConstants.INQUIRE); //PageMode.NEW_USING
    ccon18si.setSzCdStage(SUBCARE);
    ccon18si.setUlIdStage(5604047);
    ccon18si.setSzCdTask("3020");
    ccon18si.setUlIdCase(10043);
    ccon18si.setUlIdEvent(5600679);
    
    try {      
      retrieveServiceAuthorization.retrieveServiceAuthorization(ccon18si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) { //SQL_NOT_FOUND - MSG_SVC_AUTH_NEW_STAGE - MSG_CON_PRINCIPLE       
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    } 
  }

  public void test5RetrieveServiceAuthorization() {
    CCON18SI ccon18si = new CCON18SI();
    
    ccon18si.setArchInputStruct(new ArchInputStruct());    
    ccon18si.getArchInputStruct().setCReqFuncCd(PageModeConstants.NEW); //PageMode.NEW_USING
    ccon18si.setSzCdStage(SUBCARE);
    ccon18si.setUlIdStage(5604047);
    ccon18si.setSzCdTask("3020");
    ccon18si.setUlIdCase(10043);
    ccon18si.setUlIdEvent(9999999);
    
    try {      
      retrieveServiceAuthorization.retrieveServiceAuthorization(ccon18si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) { //SQL_NOT_FOUND - MSG_SVC_AUTH_NEW_STAGE - MSG_CON_PRINCIPLE       
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  }  

}
