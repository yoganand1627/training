package gov.georgia.dhr.dfcs.sacwis.service.admin;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI;

public class SaveStageProgressionTest extends BaseServiceTest {

  
  public SaveStageProgressionTest(String saveStageProgression) {
    super(saveStageProgression);
  } 
 
  public void setSaveStageProgression(SaveStageProgression saveStageProgression) {
    this.saveStageProgression = saveStageProgression;
  }
   
  protected SaveStageProgression saveStageProgression = null;
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    
    // Note: This class has not been fully tested, incomplete Save, update and delete methods.
    
    suite.addTest(new SaveStageProgressionTest("testSaveStageProgression"));
//    suite.addTest(new SaveCaseFileManagementTest("testUpdateCaseFileManagement"));
//    suite.addTest(new SaveCaseFileManagementTest("testDeleteCaseFileManagement"));
    return suite;
  }
  
  public void testSaveStageProgression() {
    CCMN88SI ccmn88si = new CCMN88SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccmn88si.setArchInputStruct(archInputStruct);
//    ccmn88si.setUlIdStage();
//    ccmn88si.setSzCdStage();
//    ccmn88si.setSzCdStageProgram();
//    ccmn88si.setSzCdStageOpen();
//    ccmn88si.setSzCdStageReasonClosed();
//    ccmn88si.setUlIdPerson();
//    ccmn88si.setSzNmPersonFull();
//    ccmn88si.setUlScrIdPrimChild();
//    ccmn88si.setCSysIndSStgOpenOnly();

    saveStageProgression.saveStageProgression(ccmn88si);
  }
}
