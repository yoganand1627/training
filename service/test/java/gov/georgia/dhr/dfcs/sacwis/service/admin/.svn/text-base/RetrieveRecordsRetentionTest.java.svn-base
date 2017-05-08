package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveRecordsRetentionTest extends BaseServiceTest {

  public RetrieveRecordsRetentionTest(String findRecordsRetention) {
    super(findRecordsRetention);
  }

  public void setRetrieveRecordsRetention(RetrieveRecordsRetention retrieveRecordsRetention) {
    this.retrieveRecordsRetention = retrieveRecordsRetention;
  }

  protected RetrieveRecordsRetention retrieveRecordsRetention = null;

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveRecordsRetentionTest("testRetrieveRecordsRetention"));
    return suite;
  }

  public void testRetrieveRecordsRetention() {
    CCFC19SI ccfc19si = new CCFC19SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    //archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccfc19si.setArchInputStruct(archInputStruct);
    int idCase = 5600096;
    ccfc19si.setUlIdCase(idCase);

    retrieveRecordsRetention.findRecordsRetention(ccfc19si);
  }

}
