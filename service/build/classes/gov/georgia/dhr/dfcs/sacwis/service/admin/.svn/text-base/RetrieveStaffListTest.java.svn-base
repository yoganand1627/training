package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveStaffListTest extends BaseServiceTest {
  
  protected RetrieveStaffList retrieveStaffList = null;
  
  public RetrieveStaffListTest(String testName) {
    super(testName);
  }

  public void setRetrieveStaffList(RetrieveStaffList retrieveStaffList) {
    this.retrieveStaffList = retrieveStaffList;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveStaffListTest("testRetrieveStaffList"));
    suite.addTest(new RetrieveStaffListTest("testRetrieveStaffList2"));
    return suite;
  }
  
  public void testRetrieveStaffList(){
    CCMN03SI ccmn03si = new CCMN03SI();
    StageIdInStruct_ARRAY stageIdInStruct_ARRAY = new StageIdInStruct_ARRAY();
    StageIdInStruct stageIdInStruct = new StageIdInStruct();
    stageIdInStruct.setUlIdStage(390);
    stageIdInStruct_ARRAY.addStageIdInStruct(stageIdInStruct);
    ccmn03si.setStageIdInStruct_ARRAY(stageIdInStruct_ARRAY);
    retrieveStaffList.retrieveStaffList(ccmn03si);
  }
  
  public void testRetrieveStaffList2(){
    CCMN03SI ccmn03si = new CCMN03SI();
    StageIdInStruct_ARRAY stageIdInStruct_ARRAY = new StageIdInStruct_ARRAY();
    StageIdInStruct stageIdInStruct = new StageIdInStruct();
    stageIdInStruct.setUlIdStage(0);
    stageIdInStruct_ARRAY.addStageIdInStruct(stageIdInStruct);
    ccmn03si.setStageIdInStruct_ARRAY(stageIdInStruct_ARRAY);
    StfSrchCrtInStruct stfSrchCrtInStruct = new StfSrchCrtInStruct();
    stfSrchCrtInStruct.setUlIdPerson(826);
    ccmn03si.setStfSrchCrtInStruct(stfSrchCrtInStruct);
    retrieveStaffList.retrieveStaffList(ccmn03si);
  }
  
  

}
