package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SavePersonDTLTest extends BaseServiceTest {
  
  protected SavePersonDTL savePersonDTL = null;
  
  public SavePersonDTLTest(String testName) {
    super(testName);
  }

  public void setSavePersonDTL(SavePersonDTL savePersonDTL) {
    this.savePersonDTL = savePersonDTL;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SavePersonDTLTest("testSavePersonDTL"));
    suite.addTest(new SavePersonDTLTest("testSavePersonDTL_Update"));
    suite.addTest(new SavePersonDTLTest("testSavePersonDTL_Add"));
    return suite;
  }
  
  private void prepObj(CCFC38SI ccfc38si,ArchInputStruct archInputStruct){
    ccfc38si.setArchInputStruct(archInputStruct);
    Date dtLastUpdate = new GregorianCalendar(1996, 7, 5, 10, 3, 49).getTime();
    ccfc38si.setTsLastUpdate(dtLastUpdate);
    ccfc38si.setUlIdPerson(5600193);
  }
  
  public void testSavePersonDTL(){
    CCFC38SI ccfc38si = new CCFC38SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    prepObj(ccfc38si,archInputStruct);
    savePersonDTL.updatePersonDTL(ccfc38si);
  }
  
  public void testSavePersonDTL_Update(){
    CCFC38SI ccfc38si = new CCFC38SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    prepObj(ccfc38si,archInputStruct);
    ccfc38si.setSzCdPersonBirthCity("Atlanta");
    savePersonDTL.updatePersonDTL(ccfc38si);
  }
  
  public void testSavePersonDTL_Add(){
    CCFC38SI ccfc38si = new CCFC38SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccfc38si.setArchInputStruct(archInputStruct);
    ccfc38si.setUlIdPerson(893);
    savePersonDTL.updatePersonDTL(ccfc38si);
  }

}
