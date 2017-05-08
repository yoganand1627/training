package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46SI;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrievePhoneListDetailTest extends BaseServiceTest {
  
  protected RetrievePhoneListDetail retrievePhoneListDetail = null;
  
  public RetrievePhoneListDetailTest(String testName) {
    super(testName);
  }

  public void setRetrievePhoneListDetail(RetrievePhoneListDetail retrievePhoneListDetail) {
    this.retrievePhoneListDetail = retrievePhoneListDetail;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrievePhoneListDetailTest("testRetrievePhoneListDetail"));
    suite.addTest(new RetrievePhoneListDetailTest("testRetrievePhoneListDetail2"));
    return suite;
  }
  
  public void testRetrievePhoneListDetail(){
    CCMN46SI ccmn46si = new CCMN46SI();
    ccmn46si.setUlIdPerson(5602757);
    ccmn46si.setBSysIndIntake(ArchitectureConstants.Y);
    ccmn46si.setTsSysTsQuery(new Date());
    retrievePhoneListDetail.retrievePhoneListDetail(ccmn46si);
  }
  
  public void testRetrievePhoneListDetail2(){
    CCMN46SI ccmn46si = new CCMN46SI();
    ccmn46si.setUlIdPerson(5603599);
    retrievePhoneListDetail.retrievePhoneListDetail(ccmn46si);
  }

}
