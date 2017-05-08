package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveWorkloadTest extends BaseServiceTest {
  protected RetrieveWorkload retrieveWorkload = null;

  public RetrieveWorkloadTest(String testName) {
    super(testName);
  }

  public void setRetrieveUnitSupervisor(RetrieveWorkload retrieveWorkload) {
    this.retrieveWorkload = retrieveWorkload;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveWorkloadTest("testRetrieveWorkload"));
    return suite;
  }

  public void testRetrieveWorkload() {
    CCMN14SI ccmn14si = new CCMN14SI();  
    ArchInputStruct ccmn14siArchInputStruct = new ArchInputStruct();  
    ccmn14siArchInputStruct.setCReqFuncCd("3");    
    ccmn14si.setArchInputStruct(ccmn14siArchInputStruct);
    
    ROWCCMN52DI rowCcmn52Di = new ROWCCMN52DI();
    rowCcmn52Di.setUlIdStage(240);
    ROWCCMN52DI_ARRAY rowccmn52di_array = new ROWCCMN52DI_ARRAY();
    rowccmn52di_array.addROWCCMN52DI(rowCcmn52Di);
    ccmn14si.setROWCCMN52DI_ARRAY(rowccmn52di_array);
    ccmn14si.setUlIdPerson(356);
    ccmn14si.setBWcdCdSortBy("2");
    
   ccmn14si.setBSysIndSupervisor("");
    
    retrieveWorkload.findWorkloadInformation(ccmn14si);
  }
  
}
