package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveEmployeeDetailTest extends BaseServiceTest {
  protected RetrieveEmployeeDetail retrieveEmployeeDetail = null;

  public RetrieveEmployeeDetailTest(String testName) {
    super(testName);
  }

  public void setRetrieveEmployeeDetail(RetrieveEmployeeDetail retrieveEmployeeDetail) {
    this.retrieveEmployeeDetail = retrieveEmployeeDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveEmployeeDetailTest("testRetrieveEmployeeDetail"));
    return suite;
  }

  public void testRetrieveEmployeeDetail() {
    CCMN04SI ccmn04si = new CCMN04SI();         
    UlIdPerson_ARRAY_CCMN04SI ulIdPersonArrrayCcmn04Si = new UlIdPerson_ARRAY_CCMN04SI();
    ulIdPersonArrrayCcmn04Si.addUlIdPerson(1848);
    ccmn04si.setUlIdPerson_ARRAY_CCMN04SI(ulIdPersonArrrayCcmn04Si);
    
    jdbcTemplate.update("UPDATE EMPLOYEE SET EMPLOYEE.IND_EMP_ACTIVE_STATUS = 'Y' WHERE EMPLOYEE.ID_PERSON = '1848' ");
    jdbcTemplate.update("UPDATE UNIT_EMP_LINK SET UNIT_EMP_LINK.CD_UNIT_MEMBER_IN_OUT = 'IN' WHERE UNIT_EMP_LINK.ID_UNIT = '391' AND UNIT_EMP_LINK.ID_PERSON = '1848'");
    jdbcTemplate.update("UPDATE UNIT_EMP_LINK SET UNIT_EMP_LINK.CD_UNIT_MEMBER_IN_OUT = 'OUT' WHERE UNIT_EMP_LINK.ID_UNIT = '363' AND UNIT_EMP_LINK.ID_PERSON = '1848'");
    
    
    retrieveEmployeeDetail.retrieveEmployeeDetail(ccmn04si);
  }
  
}
