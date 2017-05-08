package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22SIG02_ARRAY;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveUnitDetailTest extends BaseServiceTest {
  protected SaveUnitDetail saveUnitDetail = null;

  public SaveUnitDetailTest(String testName) {
    super(testName);
  }

  public void setSaveUnitDetail(SaveUnitDetail saveUnitDetail) {
    this.saveUnitDetail = saveUnitDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveUnitDetailTest("testSaveUnitDetailUpdate"));
    suite.addTest(new SaveUnitDetailTest("testSaveUnitDetailDelete"));
    return suite;
  }

 

  public void testSaveUnitDetailUpdate() {
    CCMN22SI ccmn22si = new CCMN22SI();

    ArchInputStruct ccmn22siArchInputStruct = new ArchInputStruct();
    ccmn22siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn22si.setArchInputStruct(ccmn22siArchInputStruct);
    ccmn22si.setUlIdUnit(9);
    ROWCCMN22SIG02 rowccmn22sig02 = new ROWCCMN22SIG02();
    rowccmn22sig02.setUlIdPerson(8828);
    rowccmn22sig02.setSzCdUnitMemberInOut("IN");
    rowccmn22sig02.setSzScrCdUnitMemberInOut("OUT");
    rowccmn22sig02.setSzCdUnitMemberRole("40");
    rowccmn22sig02.setUlIdUnitEmpLink(5351);       
    int idUnitEmpLink = 5351;    
    Date dtLastUpdate =
      (Date) jdbcTemplate.queryForObject("SELECT DT_LAST_UPDATE FROM UNIT_EMP_LINK WHERE UNIT_EMP_LINK.ID_UNIT_EMP_LINK = ?",
                                         new Object[] {idUnitEmpLink}, Date.class);      
    
    rowccmn22sig02.setTsLastUpdate(dtLastUpdate);
    ROWCCMN22SIG02_ARRAY rowCcmn22Sig02Array = new ROWCCMN22SIG02_ARRAY();
    rowCcmn22Sig02Array.addROWCCMN22SIG02(rowccmn22sig02);
    ccmn22si.setROWCCMN22SIG02_ARRAY(rowCcmn22Sig02Array);
    ROWCCMN22SIG01 rowCcmn22Sig01 = new ROWCCMN22SIG01();
    rowCcmn22Sig01.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    rowCcmn22Sig01.setUlIdPerson(6821);
    int idUnit = 9;
    Date rowCcmn22Sig01DtLastUpdate =
      (Date) jdbcTemplate.queryForObject("SELECT DT_LAST_UPDATE FROM UNIT WHERE UNIT.ID_UNIT = ?",
                                         new Object[] {idUnit}, Date.class); 
        
    rowCcmn22Sig01.setTsLastUpdate(rowCcmn22Sig01DtLastUpdate);
    rowCcmn22Sig01.setUlIdUnitParent(6);
    rowCcmn22Sig01.setSzNbrUnit("04");
    rowCcmn22Sig01.setSzCdUnitCounty("001");
    rowCcmn22Sig01.setSzCdUnitRegion("001");
    rowCcmn22Sig01.setSzCdUnitSpecialization("INT");
    
    ccmn22si.setROWCCMN22SIG01(rowCcmn22Sig01);

    saveUnitDetail.saveUnitInformation(ccmn22si);
  }
  
  
  public void testSaveUnitDetailDelete() {
    CCMN22SI ccmn22si = new CCMN22SI();
    ArchInputStruct ccmn22siArchInputStruct = new ArchInputStruct();
    ccmn22siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    ccmn22si.setArchInputStruct(ccmn22siArchInputStruct);
    ccmn22si.setUlIdUnit(9);
    ROWCCMN22SIG02 rowccmn22sig02 = new ROWCCMN22SIG02();
    rowccmn22sig02.setUlIdPerson(8828);
    rowccmn22sig02.setSzCdUnitMemberInOut("IN");
    rowccmn22sig02.setSzScrCdUnitMemberInOut("OUT");
    rowccmn22sig02.setSzCdUnitMemberRole("40");
    rowccmn22sig02.setUlIdUnitEmpLink(5351);       
    int idUnitEmpLink = 5351;    
    Date dtLastUpdate =
      (Date) jdbcTemplate.queryForObject("SELECT DT_LAST_UPDATE FROM UNIT_EMP_LINK WHERE UNIT_EMP_LINK.ID_UNIT_EMP_LINK = ?",
                                         new Object[] {idUnitEmpLink}, Date.class);      
    
    rowccmn22sig02.setTsLastUpdate(dtLastUpdate);
    ROWCCMN22SIG02_ARRAY rowCcmn22Sig02Array = new ROWCCMN22SIG02_ARRAY();
    rowCcmn22Sig02Array.addROWCCMN22SIG02(rowccmn22sig02);
    ccmn22si.setROWCCMN22SIG02_ARRAY(rowCcmn22Sig02Array);
    ROWCCMN22SIG01 rowCcmn22Sig01 = new ROWCCMN22SIG01();
    rowCcmn22Sig01.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowCcmn22Sig01.setUlIdPerson(6821);
    int idUnit = 9;
    Date rowCcmn22Sig01DtLastUpdate =
      (Date) jdbcTemplate.queryForObject("SELECT DT_LAST_UPDATE FROM UNIT WHERE UNIT.ID_UNIT = ?",
                                         new Object[] {idUnit}, Date.class); 
        
    rowCcmn22Sig01.setTsLastUpdate(rowCcmn22Sig01DtLastUpdate);
    rowCcmn22Sig01.setUlIdUnitParent(6);
    rowCcmn22Sig01.setSzNbrUnit("04");
    rowCcmn22Sig01.setSzCdUnitCounty("001");
    rowCcmn22Sig01.setSzCdUnitRegion("001");
    rowCcmn22Sig01.setSzCdUnitSpecialization("INT");
    
    ccmn22si.setROWCCMN22SIG01(rowCcmn22Sig01);

    saveUnitDetail.saveUnitInformation(ccmn22si);
  }

}
