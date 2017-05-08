package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ContractValidationTest extends BaseServiceTest {
  
  protected ContractValidation contractValidation = null;

  public ContractValidationTest(String testName) {
    super(testName);
  }

  public void setContractValidation(ContractValidation contractValidation) {
    this.contractValidation = contractValidation;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new ContractValidationTest("test1ContractValidation"));
    suite.addTest(new ContractValidationTest("test2ContractValidation"));
    suite.addTest(new ContractValidationTest("test3ContractValidation"));
    suite.addTest(new ContractValidationTest("test4ContractValidation"));
    return suite;
  } 
  

  public void test1ContractValidation() {
    CCON20SI ccon20si = new CCON20SI();
    
    Integer idResource = 5600386;
    ccon20si.setUlIdResource(idResource);
    ccon20si.setSzCdSvcAuthCounty("001");
    ccon20si.setSzCdSvcAuthService("18H");
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, 6);
    cal.set(Calendar.DAY_OF_MONTH, 25);
    cal.set(Calendar.YEAR, 1996);    
    Date testDate = cal.getTime();
    ccon20si.setDtDtSvcAuthEff(DateHelper.toCastorDate(testDate));
    
    try {      
      contractValidation.contractValidation(ccon20si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_CON_NO_ACTIVE_CONTRACT) {        
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  } 
  

  public void test2ContractValidation() {
    CCON20SI ccon20si = new CCON20SI();
    
    Integer idResource = 5500004;
    ccon20si.setUlIdResource(idResource);
    ccon20si.setSzCdSvcAuthCounty("238");
    ccon20si.setSzCdSvcAuthService("88T");
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, 9);
    cal.set(Calendar.DAY_OF_MONTH, 30);
    cal.set(Calendar.YEAR, 2003);    
    Date testDate = cal.getTime();
    ccon20si.setDtDtSvcAuthEff(DateHelper.toCastorDate(testDate));
    
    try {      
      contractValidation.contractValidation(ccon20si);     
      fail("Expected an exception with Messages.EXPECTED_CODE.");    
      } 
      catch (ServiceException se) {      
        if(se.getErrorCode() != Messages.MSG_CON_NO_ACTIVE_CONTRACT) {        
//       Unexpected exception; rethrow it.        
      throw se;      
      }    
    }
  } 
  

  public void test3ContractValidation() {
    CCON20SI ccon20si = new CCON20SI();
    
    Integer idResource = 5600386;
    ccon20si.setUlIdResource(idResource);
    ccon20si.setSzCdSvcAuthCounty("227");
    ccon20si.setSzCdSvcAuthService("63A");
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, 12);
    cal.set(Calendar.DAY_OF_MONTH, 30);
    cal.set(Calendar.YEAR, 2005);    
    Date testDate = cal.getTime();
    ccon20si.setDtDtSvcAuthEff(DateHelper.toCastorDate(testDate));
    
    contractValidation.contractValidation(ccon20si);
  } 
  

  public void test4ContractValidation() {
    CCON20SI ccon20si = new CCON20SI();
    
    Integer idResource = 5600272;
    ccon20si.setUlIdResource(idResource);
    ccon20si.setSzCdSvcAuthCounty("004");
    ccon20si.setSzCdSvcAuthService("40B");
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, 12);
    cal.set(Calendar.DAY_OF_MONTH, 30);
    cal.set(Calendar.YEAR, 2000);    
    Date testDate = cal.getTime();
    ccon20si.setDtDtSvcAuthEff(DateHelper.toCastorDate(testDate));
    
    contractValidation.contractValidation(ccon20si);
  }

}
