package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV22SIG_ARRAY;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveExternalDocumentationTest extends BaseServiceTest {
  
  protected SaveExternalDocumentation saveExternalDocumentation = null;
  
  public SaveExternalDocumentationTest(String testName) {
    super(testName);
  }

  public void setSaveExternalDocumentation(SaveExternalDocumentation saveExternalDocumentation) {
    this.saveExternalDocumentation = saveExternalDocumentation;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveExternalDocumentationTest("testSaveExternalDocumentation"));
    suite.addTest(new SaveExternalDocumentationTest("testSaveExternalDocumentation2"));
    return suite;
  }
  
  public void testSaveExternalDocumentation(){
    CINV22SI cinv22si = new CINV22SI();
    cinv22si.setUlIdStage(134);
    ArchInputStruct archInputStruct = new ArchInputStruct(); 
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    cinv22si.setArchInputStruct(archInputStruct);
    cinv22si.setSzCdTask("2180");
    
    ROWCINV22SIG_ARRAY rowCinv22SigArray = new ROWCINV22SIG_ARRAY();
    cinv22si.setROWCINV22SIG_ARRAY(rowCinv22SigArray);
    ROWCINV22SIG rowCinv22Sig = new ROWCINV22SIG();
    rowCinv22Sig.setUlIdCase(10288);
    //rowCinv22Sig.setUlIdExtSitInfo(101);
    rowCinv22Sig.setSzCdExtDocType("BC");
    rowCinv22Sig.setDtDtExtDocObtained( DateHelper.toCastorDate(new Date()));
    rowCinv22Sig.setSzTxtExtDocLocation("Case File");
    rowCinv22Sig.setSzTxtExtDocDetails("Test");
    //rowCinv22Sig.setTsLastUpdate(new Date());
    rowCinv22Sig.setSzCdExtDocSort("");
    rowCinv22Sig.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);

    rowCinv22SigArray.addROWCINV22SIG(rowCinv22Sig);
    
    saveExternalDocumentation.saveExternalDocumentation(cinv22si, true, null);
  }
  
  public void testSaveExternalDocumentation2(){
    CINV22SI cinv22si = new CINV22SI();
    cinv22si.setUlIdStage(134);
    ArchInputStruct archInputStruct = new ArchInputStruct(); 
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    cinv22si.setArchInputStruct(archInputStruct);
    cinv22si.setSzCdTask("2180");
    
    ROWCINV22SIG_ARRAY rowCinv22SigArray = new ROWCINV22SIG_ARRAY();
    cinv22si.setROWCINV22SIG_ARRAY(rowCinv22SigArray);
    ROWCINV22SIG rowCinv22Sig = new ROWCINV22SIG();
    rowCinv22Sig.setUlIdExtSitInfo(5600000);
    Date dtLastUpdate = new GregorianCalendar(1996, 7, 5, 9, 58, 56).getTime();
    rowCinv22Sig.setTsLastUpdate(dtLastUpdate);
    rowCinv22Sig.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);

    rowCinv22SigArray.addROWCINV22SIG(rowCinv22Sig);
    
    saveExternalDocumentation.saveExternalDocumentation(cinv22si, true, null);
  }

}
