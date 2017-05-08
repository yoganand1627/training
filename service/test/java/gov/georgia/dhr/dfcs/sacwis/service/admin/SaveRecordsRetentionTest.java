package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC20SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveRecordsRetentionTest extends BaseServiceTest {

  public SaveRecordsRetentionTest(String saveRecordsRetention) {
    super(saveRecordsRetention);
  }

  public void setSaveRecordsRetention(SaveRecordsRetention saveRecordsRetention) {
    this.saveRecordsRetention = saveRecordsRetention;
  }

  protected SaveRecordsRetention saveRecordsRetention = null;

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveRecordsRetentionTest("testSaveRecordsRetention"));
    //suite.addTest(new SaveRecordsRetentionTest("testUpdateRecordsRetention"));
    //suite.addTest(new SaveRecordsRetentionTest("testDeleteRecordsRetention"));
    return suite;
  }

  private void buildRecord(CCFC20SI ccfc20si) {
    ccfc20si.setSzCdRecRtnRetenType("ACP");
    GregorianCalendar dtRecRtnDstryActual = new GregorianCalendar(2009, 1, 17, 0, 0, 0);
    ccfc20si.setDtDtRecRtnDstryActual(DateHelper.toCastorDate(dtRecRtnDstryActual.getTime()));
    GregorianCalendar dtRecRtnDstryElig = new GregorianCalendar(2009, 1, 17, 0, 0, 0);
    ccfc20si.setDtDtRecRtnDstryElig(DateHelper.toCastorDate(dtRecRtnDstryElig.getTime()));

  }

  public void testSaveRecordsRetention() {
    CCFC20SI ccfc20si = new CCFC20SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccfc20si.setArchInputStruct(archInputStruct);
    buildRecord(ccfc20si);
    ccfc20si.setUlIdCase(5606099);
    ccfc20si.setSzTxtRecRtnDstryDtRsn("Test Add");
    ccfc20si.setTsLastUpdate(new Date());
    saveRecordsRetention.saveRecordsRetention(ccfc20si);
  }

  public void testUpdateRecordsRetention() {
    CCFC20SI ccfc20si = new CCFC20SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccfc20si.setArchInputStruct(archInputStruct);
    buildRecord(ccfc20si);
    ccfc20si.setUlIdCase(5600096);
    ccfc20si.setSzTxtRecRtnDstryDtRsn("Test Update");
    GregorianCalendar dtLastUpdate = new GregorianCalendar(1996, 7, 5, 13, 40, 25);
    ccfc20si.setTsLastUpdate(dtLastUpdate.getTime());
    saveRecordsRetention.saveRecordsRetention(ccfc20si);
  }

  public void testDeleteRecordsRetention() {
    CCFC20SI ccfc20si = new CCFC20SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    ccfc20si.setArchInputStruct(archInputStruct);
    GregorianCalendar dtLastUpdate = new GregorianCalendar(1996, 7, 5, 13, 40, 25);
    ccfc20si.setTsLastUpdate(dtLastUpdate.getTime());
    ccfc20si.setUlIdCase(5600096);
    saveRecordsRetention.saveRecordsRetention(ccfc20si);
  }

}
