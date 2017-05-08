package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveCaseFileManagement;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveCaseFileManagementTest extends BaseServiceTest {

  public SaveCaseFileManagementTest(String saveCaseFileManagement) {
    super(saveCaseFileManagement);
  } 
 
  public void setSaveCaseFileManagement(SaveCaseFileManagement saveCaseFileManagement) {
    this.saveCaseFileManagement = saveCaseFileManagement;
  }
   
  protected SaveCaseFileManagement saveCaseFileManagement = null;
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveCaseFileManagementTest("testSaveCaseFileManagement"));
    suite.addTest(new SaveCaseFileManagementTest("testUpdateCaseFileManagement"));
    suite.addTest(new SaveCaseFileManagementTest("testDeleteCaseFileManagement"));
    return suite;
  }
  
  public void testSaveCaseFileManagement() {
    CCFC22SI ccfc22si = new CCFC22SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccfc22si.setArchInputStruct(archInputStruct);
    ccfc22si.setUlIdCase(5606099);
    ccfc22si.setSzCdCaseProgram("APS");
    ccfc22si.setSzCdOfficeRegion("001");
    ccfc22si.setSzNbrUnit("00");
    ccfc22si.setSzAddrMailCode("0051");
    ccfc22si.setTsLastUpdate(new Date());
    ccfc22si.setSzAddrCaseFileCity("Austin");
    ccfc22si.setSzAddrCaseFileStLn1("122 Test");
    ccfc22si.setSzAddrCaseFileStLn2("122 Test");
    ccfc22si.setSzCdCaseFileOfficeType("P");
    ccfc22si.setDtDtCaseFileArchCompl(DateHelper.toCastorDate(new Date()));
    ccfc22si.setDtDtCaseFileArchElig(DateHelper.toCastorDate(new Date()));
    ccfc22si.setSzNmCaseFileOffice("Test Name");
    ccfc22si.setSztxtCaseFileLocateInfo("Test Service");

    saveCaseFileManagement.saveCaseFileManagement(ccfc22si);
  }
 
  public void testUpdateCaseFileManagement() {
    CCFC22SI ccfc22si = new CCFC22SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccfc22si.setArchInputStruct(archInputStruct);
    ccfc22si.setUlIdCase(5600096);
    ccfc22si.setSzCdCaseProgram("APS");
    ccfc22si.setSzCdOfficeRegion("001");
    ccfc22si.setSzNbrUnit("00");
    ccfc22si.setSzAddrMailCode("0051");
    Date dtLastUpdate = new GregorianCalendar(1996, 7, 5, 13, 40, 25).getTime();
    ccfc22si.setTsLastUpdate(dtLastUpdate);
    ccfc22si.setSzAddrCaseFileCity("Austin");
    ccfc22si.setSzAddrCaseFileStLn1("122 Test");
    ccfc22si.setSzAddrCaseFileStLn2("122 Test");
    ccfc22si.setSzCdCaseFileOfficeType("P");
    ccfc22si.setDtDtCaseFileArchCompl(DateHelper.toCastorDate(new Date()));
    ccfc22si.setDtDtCaseFileArchElig(DateHelper.toCastorDate(new Date()));
    ccfc22si.setSzNmCaseFileOffice("Test Name");
    ccfc22si.setSztxtCaseFileLocateInfo("Test Service");

    saveCaseFileManagement.saveCaseFileManagement(ccfc22si);
  }
  
  
  public void testDeleteCaseFileManagement() {
    CCFC22SI ccfc22si = new CCFC22SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    ccfc22si.setArchInputStruct(archInputStruct);
    Date dtLastUpdate = new GregorianCalendar(1996, 7, 5, 13, 40, 25).getTime();
    ccfc22si.setTsLastUpdate(dtLastUpdate);
    ccfc22si.setUlIdCase(5600096);
    saveCaseFileManagement.saveCaseFileManagement(ccfc22si);
  }
  
}
