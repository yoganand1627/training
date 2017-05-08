package gov.georgia.dhr.dfcs.sacwis.service.common;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;

public class RetrieveTaskListTest extends BaseServiceTest {
  
  protected RetrieveTaskList retrieveTaskList = null;
  
  private static final String IND_YES = "1";
  private static final String IND_NO = "0";
  public static final String RISK_ASSESSMENT = "2290";
  public static final String ELIG_DETERM_SUB = "3120";
  
  public void setRetrieveTaskList(RetrieveTaskList retrieveTaskList) {
    this.retrieveTaskList = retrieveTaskList;
  }
  
  public RetrieveTaskListTest(String testName) {
    super(testName);
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveTaskListTest("testRetrieveTaskList"));
    suite.addTest(new RetrieveTaskListTest("testRetrieveTaskList2"));
    suite.addTest(new RetrieveTaskListTest("testRetrieveTaskList3"));
    suite.addTest(new RetrieveTaskListTest("testRetrieveTaskList4"));
    suite.addTest(new RetrieveTaskListTest("testRetrieveTaskList5"));
    suite.addTest(new RetrieveTaskListTest("testRetrieveTaskList6"));
    return suite;
  }
  
  public void testRetrieveTaskList(){
    CCMN50SI ccmn50si = new CCMN50SI();
    ccmn50si.setCIndTaskRtrvPriorStage(IND_YES);
    ccmn50si.setUlIdStage(5600113);
    retrieveTaskList.findTaskListEvents(ccmn50si);
    
  }
  
  public void testRetrieveTaskList2(){
    CCMN50SI ccmn50si = new CCMN50SI();
    ccmn50si.setCIndTaskRtrvPriorStage(IND_NO);
    ccmn50si.setBIndTaskMultInstance(IND_YES);
    ccmn50si.setUlIdStage(132);
    ccmn50si.setSzCdTask("2210");
    retrieveTaskList.findTaskListEvents(ccmn50si);
  }
  
  public void testRetrieveTaskList3(){
    CCMN50SI ccmn50si = new CCMN50SI();
    ccmn50si.setCIndTaskRtrvPriorStage(IND_NO);
    ccmn50si.setBIndTaskMultInstance(IND_YES);
    ccmn50si.setUlIdStage(132);
    ccmn50si.setSzCdTask(RISK_ASSESSMENT);
    retrieveTaskList.findTaskListEvents(ccmn50si);
  }
  
  public void testRetrieveTaskList4(){
    CCMN50SI ccmn50si = new CCMN50SI();
    ccmn50si.setCIndTaskRtrvPriorStage(IND_NO);
    ccmn50si.setBIndTaskMultInstance(IND_YES);
    ccmn50si.setUlIdStage(5600197);
    ccmn50si.setSzCdTask(ELIG_DETERM_SUB);
    retrieveTaskList.findTaskListEvents(ccmn50si);
  }
  
  public void testRetrieveTaskList5(){
    CCMN50SI ccmn50si = new CCMN50SI();
    ccmn50si.setCIndTaskRtrvPriorStage(IND_NO);
    ccmn50si.setBIndTaskMultInstance(IND_NO);
    ccmn50si.setUlIdStage(5600197);
    ccmn50si.setSzCdTask(ELIG_DETERM_SUB);
    retrieveTaskList.findTaskListEvents(ccmn50si);
  }
  
  public void testRetrieveTaskList6(){
    CCMN50SI ccmn50si = new CCMN50SI();
    ccmn50si.setCIndTaskRtrvPriorStage(IND_NO);
    ccmn50si.setBIndTaskMultInstance(IND_YES);
    ccmn50si.setUlIdStage(5601800);
    retrieveTaskList.findTaskListEvents(ccmn50si);
  }

  

}
