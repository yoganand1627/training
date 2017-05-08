package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveServiceAuthorizationDetailTest extends BaseServiceTest {
  
  protected RetrieveServiceAuthorizationDetail retrieveServiceAuthorizationDetail = null;

  public RetrieveServiceAuthorizationDetailTest(String testName) {
    super(testName);
  }

  public void setRetrieveServiceAuthorizationDetail(RetrieveServiceAuthorizationDetail retrieveServiceAuthorizationDetail) {
    this.retrieveServiceAuthorizationDetail = retrieveServiceAuthorizationDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveServiceAuthorizationDetailTest("test1RetrieveServiceAuthorizationDetail"));
    suite.addTest(new RetrieveServiceAuthorizationDetailTest("test2RetrieveServiceAuthorizationDetail"));
    suite.addTest(new RetrieveServiceAuthorizationDetailTest("test3RetrieveServiceAuthorizationDetail"));
    suite.addTest(new RetrieveServiceAuthorizationDetailTest("test4RetrieveServiceAuthorizationDetail"));
    return suite;
  }

  public void test1RetrieveServiceAuthorizationDetail() {
    CCON22SI ccon22si = new CCON22SI();
    
    int idSvcAuthDtl = 5500000;
    ccon22si.setUlIdSvcAuthDtl(idSvcAuthDtl);    
    int idStage = 5600566;
    ccon22si.setUlIdStage(idStage);
    String cdSvcAuthCounty = "105";
    ccon22si.setSzCdSvcAuthCounty(cdSvcAuthCounty);
    int idContract = 5000001; 
    ccon22si.setUlIdContract(idContract);    
    int nbrCnverVersion = 1; 
    ccon22si.setUlNbrCnverVersion(nbrCnverVersion);    
    int nbrCnperPeriod = 1; 
    ccon22si.setUlNbrCnperPeriod(nbrCnperPeriod);
    
    ccon22si.setSzSysCdWinMode(PageModeConstants.NEW);
    
    retrieveServiceAuthorizationDetail.retrieveServiceAuthorizationDetail(ccon22si);
  }

  public void test2RetrieveServiceAuthorizationDetail() {
    CCON22SI ccon22si = new CCON22SI();
        
    int idSvcAuthDtl = 5500000;
    ccon22si.setUlIdSvcAuthDtl(idSvcAuthDtl);    
    int idStage = 5600566;
    ccon22si.setUlIdStage(idStage);
    String cdSvcAuthCounty = "001";
    ccon22si.setSzCdSvcAuthCounty(cdSvcAuthCounty);
    int idContract = 0; 
    ccon22si.setUlIdContract(idContract);    
    int nbrCnverVersion = 0; 
    ccon22si.setUlNbrCnverVersion(nbrCnverVersion);    
    int nbrCnperPeriod = 0; 
    ccon22si.setUlNbrCnperPeriod(nbrCnperPeriod);
    
    ccon22si.setSzSysCdWinMode(PageModeConstants.MODIFY);
    try {      
      retrieveServiceAuthorizationDetail.retrieveServiceAuthorizationDetail(ccon22si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_CON_CONTRACT_SVC) {        
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  }

      public void test3RetrieveServiceAuthorizationDetail() {
        CCON22SI ccon22si = new CCON22SI();      
        
        int idStage = 5600566;
        ccon22si.setUlIdStage(idStage);
        
        String cdSvcAuthCounty = "105";
        ccon22si.setSzCdSvcAuthCounty(cdSvcAuthCounty);
        int idContract = 5000001; 
        ccon22si.setUlIdContract(idContract);    
        int nbrCnverVersion = 1; 
        ccon22si.setUlNbrCnverVersion(nbrCnverVersion);    
        int nbrCnperPeriod = 1; 
        ccon22si.setUlNbrCnperPeriod(nbrCnperPeriod);
        
        int idSvcAuthDtl = 0;
        ccon22si.setUlIdSvcAuthDtl(idSvcAuthDtl);        
        ccon22si.setSzSysCdWinMode(PageModeConstants.NEW);
        ccon22si.setSzCdStagePersType("COL");
        
        retrieveServiceAuthorizationDetail.retrieveServiceAuthorizationDetail(ccon22si);
     }

      public void test4RetrieveServiceAuthorizationDetail() {
        CCON22SI ccon22si = new CCON22SI();
        
        String cdSvcAuthCounty = "105";
        ccon22si.setSzCdSvcAuthCounty(cdSvcAuthCounty);
        int idContract = 5000001; 
        ccon22si.setUlIdContract(idContract);    
        int nbrCnverVersion = 1; 
        ccon22si.setUlNbrCnverVersion(nbrCnverVersion);    
        int nbrCnperPeriod = 1; 
        ccon22si.setUlNbrCnperPeriod(nbrCnperPeriod);
        
        ccon22si.setUlIdSvcAuthDtl(0);    
        int idStage = 0;
        ccon22si.setUlIdStage(idStage);
        
        ccon22si.setSzSysCdWinMode(PageModeConstants.NEW);
        try {      
          retrieveServiceAuthorizationDetail.retrieveServiceAuthorizationDetail(ccon22si);     
          fail("Expected an exception with Messages.EXPECTED_CODE.");    
          } 
          catch (ServiceException se1) {      
            if(se1.getErrorCode() != Messages.SQL_NOT_FOUND) {        
//           Unexpected exception; rethrow it.        
          throw se1;
            }
          }
      }

}
