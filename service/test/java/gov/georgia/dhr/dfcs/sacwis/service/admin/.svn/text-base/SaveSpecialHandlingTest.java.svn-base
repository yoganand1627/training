package gov.georgia.dhr.dfcs.sacwis.service.admin;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveSpecialHandling;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82SI;
//import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD;

public class SaveSpecialHandlingTest extends BaseServiceTest {
  protected SaveSpecialHandling saveSpecialHandling = null;

  protected RetrieveSpecialHandling retrieveSpecialHandling = null;

  public void setRetrieveSpecialHandling(RetrieveSpecialHandling retrieveSpecialHandling) {
    this.retrieveSpecialHandling = retrieveSpecialHandling;
  }

  public SaveSpecialHandlingTest(String testName) {
    super(testName);
  }

  public void setSaveSpecialHandling(SaveSpecialHandling saveSpecialHandling) {
    this.saveSpecialHandling = saveSpecialHandling;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveSpecialHandlingTest("saveSpecialHandling_INCORRECT_FUNC_CD"));
    suite.addTest(new SaveSpecialHandlingTest("saveSpecialHandling_CASE_NOT_FOUND"));
    suite.addTest(new SaveSpecialHandlingTest("saveSpecialHandling"));

    return suite;
  }

  public void saveSpecialHandling_INCORRECT_FUNC_CD() {
    CCMN82SI ccmn82si = new CCMN82SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    ccmn82si.setArchInputStruct(archInputStruct);
    try {
      saveSpecialHandling.updateCapsCase(ccmn82si);
      fail("Expected Service Exception ARC_ERR_BAD_FUNC_CD");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD) {
        throw e;
      }
    }
  }

  public void saveSpecialHandling_CASE_NOT_FOUND() {
    CCMN82SI ccmn82si = new CCMN82SI();
    SpecHD specHD = new SpecHD();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn82si.setArchInputStruct(archInputStruct);
    specHD.setUlIdCase(0);
    ccmn82si.setSpecHD(specHD);
    try {
      saveSpecialHandling.updateCapsCase(ccmn82si);
      fail("Expected Service Exception MSG_CMN_TMSTAMP_MISMATCH");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_CMN_TMSTAMP_MISMATCH) {
        throw e;
      }
    }

  }

  public void saveSpecialHandling() {
    CCMN82SI ccmn82si = new CCMN82SI();
    SpecHD specHD = new SpecHD();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn82si.setArchInputStruct(archInputStruct);

    CCMN81SI ccmn81si = new CCMN81SI();
    CCMN81SG01 ccmn81sg01 = new CCMN81SG01();
    // capscase 100001 has CdCaseSpecialHandling <> null
    ccmn81sg01.setUlIdCase(10001);
    ccmn81si.setCCMN81SG01(ccmn81sg01);
    CCMN81SO ccmn81so = retrieveSpecialHandling.findCapsCase(ccmn81si);
    // this should never evaluate to true unless case 10001 is removed from db
    if (ccmn81so == null || ccmn81so.equals(null) || ccmn81so.getSpecHD().equals(null)
        || !ccmn81so.getSpecHD().hasUlIdCase()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    specHD.setUlIdCase(10001);
    specHD.setTsSysTsLastUpdate2(ccmn81so.getSpecHD().getTsSysTsLastUpdate2());
    ccmn82si.setSpecHD(specHD);
    // this record exists in current db, no need to try/catch
    saveSpecialHandling.updateCapsCase(ccmn82si);
  }

}
