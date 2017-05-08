package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveServicesReferralsChecklistTest extends BaseServiceTest {

  private static final String INV_STAGE = CodesTables.CSTAGES_INV;

  protected RetrieveServicesReferralsChecklist retrieveServicesReferralsChecklist = null;

  public RetrieveServicesReferralsChecklistTest(String testName) {
    super(testName);
  }

  public void setRetrieveServicesReferralsChecklist(
          RetrieveServicesReferralsChecklist retrieveServicesReferralsChecklist) {
    this.retrieveServicesReferralsChecklist = retrieveServicesReferralsChecklist;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveServicesReferralsChecklistTest("testRetrieveServicesReferralsChecklist"));
    suite.addTest(new RetrieveServicesReferralsChecklistTest("testRetrieveServicesReferralsChecklist_OLD"));
    //  suite.addTest(new RetrieveServicesReferralsChecklistTest("testRetrieveServicesReferralsChecklist_err"));

    return suite;
  }

  public void testRetrieveServicesReferralsChecklist() {
    CINV54SI cinv54si = new CINV54SI();
    logger.debug("testRetrieveServicesReferralsChecklist_get step 1");
    cinv54si.setUlIdEvent(5628258);
    cinv54si.setUlIdStage(5604193);
    cinv54si.setSzCdStage(INV_STAGE);
    logger.debug("testRetrieveServicesReferralsChecklist_get step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    logger.debug("testRetrieveServicesReferralsChecklist_get step 3");
    cinv54si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveServicesReferralsChecklist_get step 4");
    retrieveServicesReferralsChecklist.retrieveServicesReferralsChecklist(cinv54si);
    logger.debug("testRetrieveServicesReferralsChecklist_get step 5");
  }

  public void testRetrieveServicesReferralsChecklist_OLD() {
    CINV54SI cinv54si = new CINV54SI();
    logger.debug("testRetrieveServicesReferralsChecklist_OLD step 1");
    cinv54si.setUlIdEvent(5628073);
    cinv54si.setUlIdStage(5604163);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    logger.debug("testRetrieveServicesReferralsChecklist_OLD step 2");
    cinv54si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveServicesReferralsChecklist_OLD step 3");
    retrieveServicesReferralsChecklist.retrieveServicesReferralsChecklist(cinv54si);
    logger.debug("testRetrieveServicesReferralsChecklist_OLD step 4");
  }

  public void testRetrieveServicesReferralsChecklist_err() {
    CINV54SI cinv54si = new CINV54SI();
    logger.debug("testRetrieveServicesReferralsChecklist_err step 1");
    cinv54si.setUlIdEvent(0);
    cinv54si.setUlIdStage(0);
    logger.debug("testRetrieveServicesReferralsChecklist_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv54si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveServicesReferralsChecklist_err step 3");
    try { // Only these two lines go inside the try.
      retrieveServicesReferralsChecklist.retrieveServicesReferralsChecklist(cinv54si);
      fail("Expected an exception with Messages.MSG_INV_NOT_BEGUN");
    } catch (ServiceException se) {
      // Ignore the exception; we expected it. }
      if (se.getErrorCode() != Messages.MSG_INV_NOT_BEGUN) {
        // Unexpected exception; rethrow it.
        throw se;
      }
    }
    logger.debug("testRetrieveServicesReferralsChecklist_err step 4");
  }

  protected void makeStatus_OUT_OF_STATE(int id_edHist) throws Exception {
    jdbcTemplate.update(
            "UPDATE EDUCATIONAL_HISTORY SET (IND_EDHIST_TEA_SCHOOL = '?')" + " WHERE ID_EDHIST = " + id_edHist,
            new Object[] {"O"});
    /*
       * jdbcTemplate.update("UPDATE EDUCATIONAL_HISTORY SET
       * (IND_EDHIST_TEA_SCHOOL = (?))" + " VALUES (?)" + " WHERE ID_EDHIST = " +
       * id_edHist, new Object[] {"O"});
       */
  }
}
