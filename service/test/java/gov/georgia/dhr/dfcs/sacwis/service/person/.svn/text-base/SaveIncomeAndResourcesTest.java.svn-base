package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC30SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC30SIG00_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveIncomeAndResourcesTest extends BaseServiceTest {

  protected SaveIncomeAndResources saveIncomeAndResources = null;

  public SaveIncomeAndResourcesTest(String testName) {
    super(testName);
  }

  public void setSaveIncomeAndResources(SaveIncomeAndResources saveIncomeAndResources) {
    this.saveIncomeAndResources = saveIncomeAndResources;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveIncomeAndResourcesTest("testSaveIncomeAndResourcesAdd"));
    suite.addTest(new SaveIncomeAndResourcesTest("testSaveIncomeAndResourcesUpdate"));
    return suite;
  }

  public void testSaveIncomeAndResourcesAdd() {
    CCFC30SI ccfc30si = new CCFC30SI();
    ROWCCFC30SIG00_ARRAY rowccfc30sig00_array = new ROWCCFC30SIG00_ARRAY();
    ROWCCFC30SIG00 rowccfc30sig00 = new ROWCCFC30SIG00();
    rowccfc30sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);

    double amtIncRsrs = 1001.01;
    rowccfc30sig00.setLAmtIncRsrc(amtIncRsrs);
    String cdIncRsrsIncome = "INC";
    rowccfc30sig00.setSzCdIncRsrcIncome(cdIncRsrsIncome);
    String cdIncRsrcType = "CSP";
    rowccfc30sig00.setSzCdIncRsrcType(cdIncRsrcType);
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(2000, 1, 1);
    Date dtIncRsrsFrom = calendar.getTime();
    rowccfc30sig00.setDtDtIncRsrcFrom(DateHelper.toCastorDate(dtIncRsrsFrom));
    calendar.clear();
    calendar.set(2005, 1, 1);
    Date dtIncRsrsTo = calendar.getTime();
    rowccfc30sig00.setDtDtIncRsrcTo(DateHelper.toCastorDate(dtIncRsrsTo));
    int idPerson = 5601128;
    rowccfc30sig00.setUlIdPerson(idPerson);
    int idIncRsrsWorker = 101;
    rowccfc30sig00.setUlIdIncRsrcWorker(idIncRsrsWorker);
    String indIncRsrsNotAccess = "N";
    rowccfc30sig00.setCIndIncRsrcNotAccess(indIncRsrsNotAccess);
    String sdsIncRrcsSources = "test";
    rowccfc30sig00.setSzSdsIncRrcsSource(sdsIncRrcsSources);
    String sdsIncRsrcVerfMethod = "VerfMethod";
    rowccfc30sig00.setSzSdsIncRsrcVerfMethod(sdsIncRsrcVerfMethod);
    String txtIncRsrcDesc = "txtIncRsrcDesc";
    rowccfc30sig00.setSzTxtIncRsrcDesc(txtIncRsrcDesc);
    rowccfc30sig00_array.addROWCCFC30SIG00(rowccfc30sig00);
    ccfc30si.setROWCCFC30SIG00_ARRAY(rowccfc30sig00_array);
    // Set up input object here
    try {
      // Only these two lines go inside the try.
      saveIncomeAndResources.saveIncomeAndResources(ccfc30si);
      fail("Expected an exception with Messages.MSG_CFC_SAME_TYPE_INC");
    } catch (ServiceException se) {
      // Check the error code to see if it was the expected one.
      if (se.getErrorCode() != Messages.MSG_CFC_SAME_TYPE_INC) {
        // Unexpected exception; rethrow it.
        throw se;
      }
      // Ignore the exception; we expected it.
    }
  }

  public void testSaveIncomeAndResourcesUpdate() {
    CCFC30SI ccfc30si = new CCFC30SI();
    ROWCCFC30SIG00_ARRAY rowccfc30sig00_array = new ROWCCFC30SIG00_ARRAY();
    ROWCCFC30SIG00 rowccfc30sig00 = new ROWCCFC30SIG00();
    rowccfc30sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);

    rowccfc30sig00.setUlIdIncRsrc(5600140);
    Date dtLastUpdate = new GregorianCalendar(2005, 10, 17, 9, 55, 29).getTime();
    // Calendar calendar = Calendar.getInstance();
    // rowccfc30sig00.setUlIdIncRsrc(100);
    // Date dtLastUpdate = new Date();

    rowccfc30sig00.setTsLastUpdate(dtLastUpdate);

    double amtIncRsrs = 1001.01;
    rowccfc30sig00.setLAmtIncRsrc(amtIncRsrs);
    String cdIncRsrsIncome = "INC";
    rowccfc30sig00.setSzCdIncRsrcIncome(cdIncRsrsIncome);
    String cdIncRsrcType = "CSP";
    rowccfc30sig00.setSzCdIncRsrcType(cdIncRsrcType);
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(2000, 1, 1);
    Date dtIncRsrsFrom = calendar.getTime();
    rowccfc30sig00.setDtDtIncRsrcFrom(DateHelper.toCastorDate(dtIncRsrsFrom));
    calendar.clear();
    calendar.set(2005, 1, 1);
    Date dtIncRsrsTo = calendar.getTime();
    rowccfc30sig00.setDtDtIncRsrcTo(DateHelper.toCastorDate(dtIncRsrsTo));
    int idPerson = 5601128;
    rowccfc30sig00.setUlIdPerson(idPerson);
    int idIncRsrsWorker = 101;
    rowccfc30sig00.setUlIdIncRsrcWorker(idIncRsrsWorker);
    String indIncRsrsNotAccess = "N";
    rowccfc30sig00.setCIndIncRsrcNotAccess(indIncRsrsNotAccess);
    String sdsIncRrcsSources = "test";
    rowccfc30sig00.setSzSdsIncRrcsSource(sdsIncRrcsSources);
    String sdsIncRsrcVerfMethod = "VerfMethod";
    rowccfc30sig00.setSzSdsIncRsrcVerfMethod(sdsIncRsrcVerfMethod);
    String txtIncRsrcDesc = "txtIncRsrcDesc";
    rowccfc30sig00.setSzTxtIncRsrcDesc(txtIncRsrcDesc);
    rowccfc30sig00_array.addROWCCFC30SIG00(rowccfc30sig00);
    ccfc30si.setROWCCFC30SIG00_ARRAY(rowccfc30sig00_array);
    saveIncomeAndResources.saveIncomeAndResources(ccfc30si);
  }
}
