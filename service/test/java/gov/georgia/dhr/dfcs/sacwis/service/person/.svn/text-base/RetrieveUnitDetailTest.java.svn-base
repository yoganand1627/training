package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveUnitDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN23SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveUnitDetailTest extends BaseServiceTest {
  protected RetrieveUnitDetail retrieveUnitDetail = null;

  public RetrieveUnitDetailTest(String testName) {
    super(testName);
  }

  public void setRetrieveUnitDetail(RetrieveUnitDetail retrieveUnitDetail) {
    this.retrieveUnitDetail = retrieveUnitDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveUnitDetailTest("testRetrieveUnitDetail"));
    return suite;
  }

  public void testRetrieveUnitDetail() {
    CCMN23SI ccmn23si = new CCMN23SI();     
    ccmn23si.setUlIdUnit(384);
    UlIdPerson_ARRAY_CCMN23SI ulIdPersonArrayCcmn23Si = new UlIdPerson_ARRAY_CCMN23SI();    
    ulIdPersonArrayCcmn23Si.addUlIdPerson(8765);
    ccmn23si.setUlIdPerson_ARRAY_CCMN23SI(ulIdPersonArrayCcmn23Si);
    
    retrieveUnitDetail.findUnitEmployees(ccmn23si);
  }
  
}
