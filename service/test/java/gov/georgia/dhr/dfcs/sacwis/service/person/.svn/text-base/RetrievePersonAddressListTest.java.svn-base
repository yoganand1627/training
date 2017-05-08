package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42SI;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrievePersonAddressListTest extends BaseServiceTest {
  
  protected RetrievePersonAddressList retrievePersonAddressList = null;
  
  public RetrievePersonAddressListTest(String testName) {
    super(testName);
  }

  public void setRetrievePersonAddressList(RetrievePersonAddressList retrievePersonAddressList) {
    this.retrievePersonAddressList = retrievePersonAddressList;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrievePersonAddressListTest("testRetrievePersonAddressList"));
    suite.addTest(new RetrievePersonAddressListTest("testRetrievePersonAddressList2"));
    return suite;
  }
  
  public void testRetrievePersonAddressList(){
    CCMN42SI ccmn42si = new CCMN42SI();
    ccmn42si.setUlIdPerson(460);
    retrievePersonAddressList.retrievePersonAddressList(ccmn42si);
  }
  
  public void testRetrievePersonAddressList2(){
    CCMN42SI ccmn42si = new CCMN42SI();
    ccmn42si.setUlIdPerson(460);
    ccmn42si.setBSysIndIntake("T");
    ccmn42si.setTsSysTsQuery(new Date());
    retrievePersonAddressList.retrievePersonAddressList(ccmn42si);
  }

}
