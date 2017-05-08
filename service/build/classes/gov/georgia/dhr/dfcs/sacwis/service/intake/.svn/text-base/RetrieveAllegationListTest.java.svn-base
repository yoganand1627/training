package gov.georgia.dhr.dfcs.sacwis.service.intake;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCriminalHistoryTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44SI;

public class RetrieveAllegationListTest extends BaseServiceTest {
  
  protected RetrieveAllegationList retrieveAllegationList = null;
  
  public RetrieveAllegationListTest(String testName) {
    super(testName);
  }

  public void setRetrieveAllegationList(RetrieveAllegationList retrieveAllegationList) {
    this.retrieveAllegationList = retrieveAllegationList;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveAllegationListTest("testRetrieveAllegationList1"));
    suite.addTest(new RetrieveAllegationListTest("testRetrieveAllegationList2"));
    suite.addTest(new RetrieveAllegationListTest("testRetrieveAllegationList3"));
    suite.addTest(new RetrieveAllegationListTest("testRetrieveAllegationList4"));
    suite.addTest(new RetrieveAllegationListTest("testRetrieveAllegationList5"));
    suite.addTest(new RetrieveAllegationListTest("testRetrieveAllegationList6"));
    return suite;
  }
  
  public void testRetrieveAllegationList1(){
    CINV44SI cinv44si = new CINV44SI();
    cinv44si.setUlIdStage(5600229);
    cinv44si.setSzCdAllegIncidentStage("INV");
    
    cinv44si.setSzCdStageProgram("APS");
    
    retrieveAllegationList.retrieveAllegationList(cinv44si);
  }
  
  public void testRetrieveAllegationList2(){
    CINV44SI cinv44si = new CINV44SI();
    cinv44si.setUlIdStage(5500121);
    cinv44si.setSzCdAllegIncidentStage("INV");
    cinv44si.setSzCdStageProgram("CPS");
    retrieveAllegationList.retrieveAllegationList(cinv44si);
  }
  
  public void testRetrieveAllegationList3(){
    CINV44SI cinv44si = new CINV44SI();
    cinv44si.setUlIdStage(5600155);
    cinv44si.setSzCdAllegIncidentStage("INV");
    cinv44si.setSzCdStageProgram("AFC");
    retrieveAllegationList.retrieveAllegationList(cinv44si);
  }
  
  public void testRetrieveAllegationList4(){
    CINV44SI cinv44si = new CINV44SI();
    cinv44si.setUlIdStage(5601181);
    cinv44si.setSzCdAllegIncidentStage("INV");
    cinv44si.setSzCdStageProgram("CCL");
    retrieveAllegationList.retrieveAllegationList(cinv44si);
  }
  
  public void testRetrieveAllegationList5(){
    CINV44SI cinv44si = new CINV44SI();
    cinv44si.setUlIdStage(5601181);
    cinv44si.setUlIdCase(5600405);
    cinv44si.setSzCdAllegIncidentStage("SVC");
    retrieveAllegationList.retrieveAllegationList(cinv44si);
  }
  
  public void testRetrieveAllegationList6(){
    CINV44SI cinv44si = new CINV44SI();
    cinv44si.setUlIdStage(5604174);
    cinv44si.setUlIdCase(5600405);
    cinv44si.setSzCdAllegIncidentStage("INT");
    retrieveAllegationList.retrieveAllegationList(cinv44si);
  }
  
  
  
  

}
