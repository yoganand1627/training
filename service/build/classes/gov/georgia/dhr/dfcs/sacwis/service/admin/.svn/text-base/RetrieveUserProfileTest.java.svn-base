/**
 * Created on May 28, 2006 at 9:21:47 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveUserProfileTest extends BaseServiceTest {
  protected RetrieveUserProfile retrieveUserProfile = null;

  public RetrieveUserProfileTest(String testName) {
    super(testName);
  }

  public void setRetrieveUserProfile(RetrieveUserProfile retrieveUserProfile) {
    this.retrieveUserProfile = retrieveUserProfile;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveUserProfileTest("testRetrieveUserProfile"));
    return suite;
  }

  public void testRetrieveUserProfile() {
    CARC01SI carc01si = new CARC01SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    carc01si.setArchInputStruct(archInputStruct);
    carc01si.setSzIdEmployeeLogon("HUNTERKM");
    retrieveUserProfile.retrieveUserProfile(carc01si);
  }

  public void testRetrieveUserProfileWithTempAssignments() {
    CARC01SI carc01si = new CARC01SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    carc01si.setArchInputStruct(archInputStruct);
    carc01si.setSzIdEmployeeLogon("HUNTERKM");
    retrieveUserProfile.retrieveUserProfile(carc01si);
  }
}
