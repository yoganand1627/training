package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveEducationalHistoryTest extends BaseServiceTest {
  protected RetrieveEducationalHistory retrieveEducationalHistory = null;

  public RetrieveEducationalHistoryTest(String testName) {
    super(testName);
  }

  public void setRetrieveEducationalHistory(RetrieveEducationalHistory retrieveEducationalHistory) {
    this.retrieveEducationalHistory = retrieveEducationalHistory;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveEducationalHistoryTest("testRetrieveEducationalHistory"));
    suite.addTest(new RetrieveEducationalHistoryTest("testRetrieveEducationalHistory_err"));

    return suite;
  }

  protected void onSetUpInTransaction() throws Exception {
    jdbcTemplate.update("INSERT INTO EDUCATIONAL_HISTORY (ID_EDHIST, "
                        + "                                 DT_LAST_UPDATE, "
                        + "                                 ID_PERSON, "
                        + "                                 ID_RESOURCE, "
                        + "                                 IND_EDHIST_TEA_SCHOOL)"
                        + "                         VALUES (?, ?, ?, ?, ?)",
                        new Object[] {2, new GregorianCalendar(2006, 6, 5, 0, 0, 0), 1, 5000001, "I"});
  }

  public void testRetrieveEducationalHistory() {
    CCFC17SI ccfc17si = new CCFC17SI();
    logger.debug("testRetrieveEducationalHistory_get step 1");
    ccfc17si.setUlIdPerson(1);
    logger.debug("testRetrieveEducationalHistory_get step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    logger.debug("testRetrieveEducationalHistory_get step 3");
    ccfc17si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveEducationalHistory_get step 4");
    retrieveEducationalHistory.retrieveEducationalHistory(ccfc17si);
    logger.debug("testRetrieveEducationalHistory_get step 5");
  }

  public void testRetrieveEducationalHistory_out_of_state() {
    CCFC17SI ccfc17si = new CCFC17SI();
    try {
      makeStatus_OUT_OF_STATE(1);
    } catch (Exception e) {
      logger.debug("Could not update Educational_history");
    }
    ccfc17si.setUlIdPerson(1);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc17si.setArchInputStruct(archInputStruct);
    retrieveEducationalHistory.retrieveEducationalHistory(ccfc17si);
  }

  public void testRetrieveEducationalHistory_err() {
    CCFC17SI ccfc17si = new CCFC17SI();
    logger.debug("testRetrieveEducationalHistory_err step 1");
    ccfc17si.setUlIdPerson(3);
    logger.debug("testRetrieveEducationalHistory_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc17si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveEducationalHistory_err step 3");
    try { // Only these two lines go inside the try.
      retrieveEducationalHistory.retrieveEducationalHistory(ccfc17si);
      fail("Expected an exception with object == null or empty");
    } catch (ServiceException se) {
      // Ignore the exception; we expected it. }
      logger.debug("No record found for the given criteria");
    }
    logger.debug("testRetrieveEducationalHistory_err step 4");
  }

  protected void makeStatus_OUT_OF_STATE(int id_edHist) throws Exception {
    jdbcTemplate.update("UPDATE EDUCATIONAL_HISTORY SET (IND_EDHIST_TEA_SCHOOL = '?')" + " WHERE ID_EDHIST = "
                        + id_edHist, new Object[] {"O"});
    /*
     * jdbcTemplate.update("UPDATE EDUCATIONAL_HISTORY SET (IND_EDHIST_TEA_SCHOOL = (?))" + " VALUES (?)" + " WHERE
     * ID_EDHIST = " + id_edHist, new Object[] {"O"});
     */
  }
}
