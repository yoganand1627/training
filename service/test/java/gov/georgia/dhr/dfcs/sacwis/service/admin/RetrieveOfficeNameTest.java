package gov.georgia.dhr.dfcs.sacwis.service.admin;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40SI;


public class RetrieveOfficeNameTest extends BaseServiceTest {

  public RetrieveOfficeNameTest(String retrieveOfficeName) {
    super(retrieveOfficeName);
  }
  
  public void setRetrieveOfficeName(RetrieveOfficeName retrieveOfficeName) {
    this.retrieveOfficeName = retrieveOfficeName;
  }

  protected RetrieveOfficeName retrieveOfficeName = null;
 
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveOfficeNameTest("testRetrieveOfficeName"));
    return suite;
  }
  
  public void testRetrieveOfficeName() {
    CCMN40SI ccmn40si = new CCMN40SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn40si.setArchInputStruct(archInputStruct);
    ccmn40si.setSzCdOfficeProgram("CPS");
    ccmn40si.setSzCdOfficeRegion("002");
    ccmn40si.setSzAddrMailCode("0017");

    retrieveOfficeName.retrieveOfficeName(ccmn40si);
  }
  
  
}
