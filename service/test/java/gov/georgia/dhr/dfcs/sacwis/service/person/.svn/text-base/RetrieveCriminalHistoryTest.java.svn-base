package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveCriminalHistory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC31SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveCriminalHistoryTest extends BaseServiceTest {
  protected RetrieveCriminalHistory retrieveCriminalHistory = null;

  public void setRetrieveCriminalHistory(RetrieveCriminalHistory retrieveCriminalHistory) {
    this.retrieveCriminalHistory = retrieveCriminalHistory;
  }

  public RetrieveCriminalHistoryTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveCriminalHistoryTest("testRetrieveCriminalHistory"));
    return suite;
  }

  protected void onSetUpInTransaction() throws Exception {
    jdbcTemplate.update("INSERT INTO CRIMINAL_HISTORY (ID_REC_CHECK, " +
                        "                                 DT_LAST_UPDATE, " +
                        "                                 ID_CRIM_HIST)" +
                        "                         VALUES (?, ?, ?)",
                        new Object[] {5600000, new GregorianCalendar(2006, 5, 30, 0, 0, 0), 0});
  }

  public void testRetrieveCriminalHistory() {
    CCFC31SI ccfc31si = new CCFC31SI();
    ccfc31si.setUlIdRecCheck(5600000);
    retrieveCriminalHistory.retrieveCriminalHistory(ccfc31si);
  }

}
