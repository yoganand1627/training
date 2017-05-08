package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SavePhoneListDetailTest extends BaseServiceTest {
  
  protected SavePhoneListDetail savePhoneListDetail = null;
  
  public SavePhoneListDetailTest(String testName) {
    super(testName);
  }

  public void setSavePhoneListDetail(SavePhoneListDetail savePhoneListDetail) {
    this.savePhoneListDetail = savePhoneListDetail;
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SavePhoneListDetailTest("testSavePhoneListDetail_Add1"));
    suite.addTest(new SavePhoneListDetailTest("testSavePhoneListDetail_Add2"));
    suite.addTest(new SavePhoneListDetailTest("testSavePhoneListDetail_Update1"));
    suite.addTest(new SavePhoneListDetailTest("testSavePhoneListDetail_Update2"));
    return suite;
  }
  
  public void prepObj(CCMN31SI ccmn31si,String dataAction){
    ccmn31si.setUlIdStage(5600566);
    ccmn31si.setSzCdTask("3020");
    
    ROWCCMN31SI_ARRAY rowccmn31si_array = new ROWCCMN31SI_ARRAY();
    ROWCCMN31SI rowccmn31si = new ROWCCMN31SI();
    rowccmn31si_array.addROWCCMN31SI(rowccmn31si);
    ccmn31si.setROWCCMN31SI_ARRAY(rowccmn31si_array);
    rowccmn31si.setSzCdScrDataAction(dataAction);
    ccmn31si.setUlIdPerson(839);
    rowccmn31si.setSzCdPhoneType("RS");
    rowccmn31si.setBIndPersonPhoneInvalid("N");
    
    if (dataAction.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)){
      rowccmn31si.setUlIdPhone(1011);
      Date dtLastUpdate = new GregorianCalendar(2005, 10, 9, 11, 34, 19).getTime();
      rowccmn31si.setTsLastUpdate(dtLastUpdate);
    }
  }
  
  public void testSavePhoneListDetail_Add1(){
    CCMN31SI ccmn31si = new CCMN31SI();
    prepObj(ccmn31si,ServiceConstants.REQ_FUNC_CD_ADD);
    savePhoneListDetail.savePhoneListDetail(ccmn31si);
  }
  
  public void testSavePhoneListDetail_Add2(){
    CCMN31SI ccmn31si = new CCMN31SI();
    prepObj(ccmn31si,ServiceConstants.REQ_FUNC_CD_ADD);
    ROWCCMN31SI rowccmn31si2 = ccmn31si.getROWCCMN31SI_ARRAY().getROWCCMN31SI(0);
    rowccmn31si2.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(new Date()));
    savePhoneListDetail.savePhoneListDetail(ccmn31si);
  }
  
  public void testSavePhoneListDetail_Update1(){
    CCMN31SI ccmn31si = new CCMN31SI();
    prepObj(ccmn31si,ServiceConstants.REQ_FUNC_CD_UPDATE);
    savePhoneListDetail.savePhoneListDetail(ccmn31si);
  }
  
  public void testSavePhoneListDetail_Update2(){
    CCMN31SI ccmn31si = new CCMN31SI();
    prepObj(ccmn31si,ServiceConstants.REQ_FUNC_CD_UPDATE);
    ROWCCMN31SI rowccmn31si = ccmn31si.getROWCCMN31SI_ARRAY().getROWCCMN31SI(0);
    rowccmn31si.setDtDtPersonPhoneEnd(DateHelper.toCastorDate(new Date()));
    savePhoneListDetail.savePhoneListDetail(ccmn31si);
  }
  
  

}
