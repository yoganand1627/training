package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveAddressListDetailTest extends BaseServiceTest {

  protected SaveAddressListDetail saveAddressListDetail = null;

  public SaveAddressListDetailTest(String testName) {
    super(testName);
  }

  public void setSaveAddressListDetail(SaveAddressListDetail saveAddressListDetail) {
    this.saveAddressListDetail = saveAddressListDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveAddressListDetailTest("testSaveAddressListDetail_Add"));
    suite.addTest(new SaveAddressListDetailTest("testSaveAddressListDetail_Add2"));
    suite.addTest(new SaveAddressListDetailTest("testSaveAddressListDetail_Update"));
    suite.addTest(new SaveAddressListDetailTest("testSaveAddressListDetail_Update2"));
    return suite;
  }

  public void testSaveAddressListDetail_Add() {
    CCMN44SI ccmn44si = new CCMN44SI();
    prepObj(ccmn44si, ServiceConstants.REQ_FUNC_CD_ADD, false);
    saveAddressListDetail.saveAddressListDetail(ccmn44si);
  }
  
  public void testSaveAddressListDetail_Add2() {
    CCMN44SI ccmn44si = new CCMN44SI();
    prepObj(ccmn44si, ServiceConstants.REQ_FUNC_CD_ADD, true);
    saveAddressListDetail.saveAddressListDetail(ccmn44si);
  }

  private void prepObj(CCMN44SI ccmn44si, String dataAction, boolean includeLinkEnd) {
    ccmn44si.setUlIdStage(5600566);
    ccmn44si.setSzCdTask("3020");

    ROWCCMN44SIG00_ARRAY rowccmn44sig00_array = new ROWCCMN44SIG00_ARRAY();
    ccmn44si.setROWCCMN44SIG00_ARRAY(rowccmn44sig00_array);
    ROWCCMN44SIG00 rowccmn44sig00 = new ROWCCMN44SIG00();
    rowccmn44sig00_array.addROWCCMN44SIG00(rowccmn44sig00);
    rowccmn44sig00.setSzAddrPersAddrStLn1("Potomac Rd");
    rowccmn44sig00.setSzCdScrDataAction(dataAction);
    if (dataAction.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
      rowccmn44sig00.setLdIdAddress(459);
      Date dtLastUpdate = new GregorianCalendar(2005, 10, 9, 11, 34, 57).getTime();
      rowccmn44sig00.setTsLastUpdate(dtLastUpdate);

      rowccmn44sig00.setUlIdAddrPersonLink(1043);
      Date dtLastUpdate2 = new GregorianCalendar(2005, 4, 29, 7, 46, 39).getTime();
      rowccmn44sig00.setTsSysTsLastUpdate2(dtLastUpdate2);
    } else {
      rowccmn44sig00.setBSysIndAddrMedUpdate(ArchitectureConstants.Y);
      ccmn44si.setUlIdPerson(5500160);
      rowccmn44sig00.setLdIdAddress(5501131);
    }

    rowccmn44sig00_array.setUlRowQty(1);
    rowccmn44sig00.setSzCdPersAddrLinkType("MD");
    rowccmn44sig00.setBIndPersAddrLinkInvalid("N");

    if (includeLinkEnd) {
      rowccmn44sig00.setDtDtPersAddrLinkEnd(DateHelper.toCastorDate(new Date()));
    }
  }

  public void testSaveAddressListDetail_Update() {
    CCMN44SI ccmn44si = new CCMN44SI();
    prepObj(ccmn44si, ServiceConstants.REQ_FUNC_CD_UPDATE, false);
    saveAddressListDetail.saveAddressListDetail(ccmn44si);
  }

  public void testSaveAddressListDetail_Update2() {
    CCMN44SI ccmn44si = new CCMN44SI();
    prepObj(ccmn44si, ServiceConstants.REQ_FUNC_CD_UPDATE, true);
    saveAddressListDetail.saveAddressListDetail(ccmn44si);
  }

}
