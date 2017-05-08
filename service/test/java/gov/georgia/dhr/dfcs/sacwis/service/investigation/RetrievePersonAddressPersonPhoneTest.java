package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrievePersonAddressPersonPhone;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV30SI;

public class RetrievePersonAddressPersonPhoneTest extends BaseServiceTest {
  
  protected RetrievePersonAddressPersonPhone retrievePersonAddressPersonPhone = null;

  public RetrievePersonAddressPersonPhoneTest(String testName) {
    super(testName);
  }

  public void setRetrievePersonAddressPersonPhone(RetrievePersonAddressPersonPhone retrievePersonAddressPersonPhone) {
    this.retrievePersonAddressPersonPhone = retrievePersonAddressPersonPhone;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrievePersonAddressPersonPhoneTest("test1RetrievePersonAddressPersonPhone"));
    return suite;
  } 
  

  public void test1RetrievePersonAddressPersonPhone() {
    CINV30SI cinv30si = new CINV30SI();
    
    cinv30si.setUlIdPerson(356);
    
    retrievePersonAddressPersonPhone.retrievePersonAddressPersonPhone(cinv30si);
  }

}
