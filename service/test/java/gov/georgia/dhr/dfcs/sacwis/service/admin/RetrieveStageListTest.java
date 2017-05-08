package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStageList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32SI;

public class RetrieveStageListTest extends BaseServiceTest {
  protected RetrieveStageList retrieveStagetList = null;

  public RetrieveStageListTest(String testName) {
    super(testName);
  }

  public void setRetrieveStageList(RetrieveStageList retrieveStageList) {
    this.retrieveStagetList = retrieveStageList;
  }

  protected void onSetUpInTransaction() throws Exception {
    /*
     * jdbcTemplate.update("UPDATE STAGE_PERSON_LINK " + "SET CD_STAGE_PERS_ROLE = 'PC' " + "WHERE ID_STAGE = 5600104 " +
     * "AND ID_PERSON = 2507 " + "AND CD_STAGE_PERS_ROLE = 'PR'");
     */jdbcTemplate.update("INSERT INTO CAPS_CASE (ID_CASE, DT_LAST_UPDATE) VALUES (?, ?)",
                          new Object[] { 10000, new GregorianCalendar(2006, 6, 6, 0, 0, 0) });
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveStageListTest("testRetrieveStageListByIdCase"));
    suite.addTest(new RetrieveStageListTest("testCaseHasNoStage"));
    suite.addTest(new RetrieveStageListTest("testIdCase0_NoStage"));
    suite.addTest(new RetrieveStageListTest("testRetrieveStageListByIdPerson"));
    suite.addTest(new RetrieveStageListTest("testIdCase0_IdPerson0"));

    return suite;
  }

  public void testRetrieveStageListByIdCase() {
    CCMN32SI ccmn32si = new CCMN32SI();
    ccmn32si.setUlIdCase(5600103);
    // ccmn32si.setUlIdPerson(2507);
    retrieveStagetList.retrieveStageList(ccmn32si);
  }

  public void testCaseHasNoStage() {
    CCMN32SI ccmn32si = new CCMN32SI();
    ccmn32si.setUlIdCase(10000);
    try {
      retrieveStagetList.retrieveStageList(ccmn32si);
      fail("Expected ServiceException with Messages.MSG_CMN_SEARCH_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.MSG_CMN_SEARCH_NOT_FOUND) {
        throw se;
      }
    }
  }

  public void testIdCase0_NoStage() {
    CCMN32SI ccmn32si = new CCMN32SI();
    ccmn32si.setUlIdCase(0);
    ccmn32si.setUlIdPerson(4245);
    try {
      retrieveStagetList.retrieveStageList(ccmn32si);
      fail("Expected ServiceException with Messages.MSG_CMN_SEARCH_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.MSG_CMN_SEARCH_NOT_FOUND) {
        throw se;
      }
    }
  }

  public void testRetrieveStageListByIdPerson() {
    CCMN32SI ccmn32si = new CCMN32SI();
    ccmn32si.setUlIdCase(0);
    ccmn32si.setUlIdPerson(5600084);
    try {
      retrieveStagetList.retrieveStageList(ccmn32si);
      fail("Expected ServiceException with Messages.MSG_CMN_SEARCH_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.MSG_CMN_SEARCH_NOT_FOUND) {
        throw se;
      }
    }
  }

  public void testIdCase0_IdPerson0() {
    CCMN32SI ccmn32si = new CCMN32SI();
    ccmn32si.setUlIdCase(0);
    ccmn32si.setUlIdPerson(0);
    retrieveStagetList.retrieveStageList(ccmn32si);

  }

}
