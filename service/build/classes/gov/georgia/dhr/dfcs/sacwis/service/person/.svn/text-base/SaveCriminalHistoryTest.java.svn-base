package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC32SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC32SIG00_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveCriminalHistoryTest extends BaseServiceTest {
  protected SaveCriminalHistory saveCriminalHistory = null;

  private Timestamp dtLastUpdate = null;

  public void setSaveCriminalHistory(SaveCriminalHistory saveCriminalHistory) {
    this.saveCriminalHistory = saveCriminalHistory;
  }

  public SaveCriminalHistoryTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveCriminalHistoryTest("testSaveCriminalHistoryInsert"));
    suite.addTest(new SaveCriminalHistoryTest("testSaveCriminalHistoryUpdate"));
    suite.addTest(new SaveCriminalHistoryTest("testSaveCriminalHistoryDelete"));
    return suite;
  }

  protected void onSetUpInTransaction() throws Exception {
    super.onSetUpInTransaction();
    jdbcTemplate.update("INSERT INTO CRIMINAL_HISTORY (ID_REC_CHECK, " +
                        "                                 DT_LAST_UPDATE, " +
                        "                                 ID_CRIM_HIST)" +
                        "                         VALUES (?, ?, ?)",
                        new Object[] {5600000, new GregorianCalendar(2006, 5, 30, 0, 0, 0), 103});
    dtLastUpdate = (Timestamp) jdbcTemplate.queryForObject(
            "select DT_LAST_UPDATE from CRIMINAL_HISTORY where ID_CRIM_HIST=103", Timestamp.class);
  }

  public void testSaveCriminalHistoryInsert() {
    CCFC32SI ccfc32si = new CCFC32SI();
    ROWCCFC32SIG00_ARRAY rowccfc32sig00_array = new ROWCCFC32SIG00_ARRAY();
    ROWCCFC32SIG00 rowccfc32sig00 = new ROWCCFC32SIG00();
    String scrDataAction = ServiceConstants.REQ_FUNC_CD_ADD;
    rowccfc32sig00.setSzCdScrDataAction(scrDataAction);

    int idRecCheck = 5600000;
    rowccfc32sig00.setUlIdRecCheck(idRecCheck);
    String cdCrimHistAction = "act";
    rowccfc32sig00.setSzCdCrimHistAction(cdCrimHistAction);
    String nmCrimHistReturned = "nmCrimHistReturned";
    rowccfc32sig00.setSzNmCrimHistReturned(nmCrimHistReturned);
    String txtCrimHistCmnts = "txtCrimHistCmnts";
    rowccfc32sig00.setSzTxtCrimHistCmnts(txtCrimHistCmnts);
    int idCrimHist = 101;
    rowccfc32sig00.setUlIdCrimHist(idCrimHist);

    //Date dtLastUpdate = new GregorianCalendar(2006, 4, 5, 16, 43, 23).getTime();
    //rowccfc32sig00.setTsLastUpdate(dtLastUpdate);
    String indDeleteNarr = ArchitectureConstants.Y;
    rowccfc32sig00.setCIndDeleteNarr(indDeleteNarr);

    rowccfc32sig00_array.addROWCCFC32SIG00(rowccfc32sig00);
    ccfc32si.setROWCCFC32SIG00_ARRAY(rowccfc32sig00_array);
    saveCriminalHistory.saveCriminalHistory(ccfc32si);
  }

  public void testSaveCriminalHistoryUpdate() {
    CCFC32SI ccfc32si = new CCFC32SI();
    ROWCCFC32SIG00_ARRAY rowccfc32sig00_array = new ROWCCFC32SIG00_ARRAY();
    ROWCCFC32SIG00 rowccfc32sig00 = new ROWCCFC32SIG00();
    String scrDataAction = ServiceConstants.REQ_FUNC_CD_UPDATE;
    rowccfc32sig00.setSzCdScrDataAction(scrDataAction);

    int idRecCheck = 5600000;
    rowccfc32sig00.setUlIdRecCheck(idRecCheck);
    String cdCrimHistAction = "act";
    rowccfc32sig00.setSzCdCrimHistAction(cdCrimHistAction);
    String nmCrimHistReturned = "nmCrimHistReturned";
    rowccfc32sig00.setSzNmCrimHistReturned(nmCrimHistReturned);
    String txtCrimHistCmnts = "txtCrimHistCmnts";
    rowccfc32sig00.setSzTxtCrimHistCmnts(txtCrimHistCmnts);
    int idCrimHist = 103;
    rowccfc32sig00.setUlIdCrimHist(idCrimHist);

    //Date dtLastUpdate = new GregorianCalendar(2006, 5, 30, 0, 0, 0).getTime();
    rowccfc32sig00.setTsLastUpdate(dtLastUpdate);
    String indDeleteNarr = ArchitectureConstants.N;
    rowccfc32sig00.setCIndDeleteNarr(indDeleteNarr);

    rowccfc32sig00_array.addROWCCFC32SIG00(rowccfc32sig00);
    ccfc32si.setROWCCFC32SIG00_ARRAY(rowccfc32sig00_array);
    saveCriminalHistory.saveCriminalHistory(ccfc32si);
  }

  public void testSaveCriminalHistoryDelete() {
    CCFC32SI ccfc32si = new CCFC32SI();
    ROWCCFC32SIG00_ARRAY rowccfc32sig00_array = new ROWCCFC32SIG00_ARRAY();
    ROWCCFC32SIG00 rowccfc32sig00 = new ROWCCFC32SIG00();
    String scrDataAction = ServiceConstants.REQ_FUNC_CD_DELETE;
    rowccfc32sig00.setSzCdScrDataAction(scrDataAction);

    int idRecCheck = 5600000;
    rowccfc32sig00.setUlIdRecCheck(idRecCheck);
    String cdCrimHistAction = "act";
    rowccfc32sig00.setSzCdCrimHistAction(cdCrimHistAction);
    String nmCrimHistReturned = "nmCrimHistReturned";
    rowccfc32sig00.setSzNmCrimHistReturned(nmCrimHistReturned);
    String txtCrimHistCmnts = "txtCrimHistCmnts";
    rowccfc32sig00.setSzTxtCrimHistCmnts(txtCrimHistCmnts);
    int idCrimHist = 103;
    rowccfc32sig00.setUlIdCrimHist(idCrimHist);

    //Date dtLastUpdate = new GregorianCalendar(2006, 5, 30, 0, 0, 0).getTime();
    rowccfc32sig00.setTsLastUpdate(dtLastUpdate);
    String indDeleteNarr = ArchitectureConstants.N;
    rowccfc32sig00.setCIndDeleteNarr(indDeleteNarr);

    rowccfc32sig00_array.addROWCCFC32SIG00(rowccfc32sig00);
    ccfc32si.setROWCCFC32SIG00_ARRAY(rowccfc32sig00_array);
    saveCriminalHistory.saveCriminalHistory(ccfc32si);
  }

}
