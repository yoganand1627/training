package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveRecordsCheckTest extends BaseServiceTest {
  protected RetrieveRecordsCheck retrieveRecordsCheck = null;

  public RetrieveRecordsCheckTest(String testName) {
    super(testName);
  }

  public void setRetrieveRecordsCheck(RetrieveRecordsCheck retrieveRecordsCheck) {
    this.retrieveRecordsCheck = retrieveRecordsCheck;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveRecordsCheckTest("testRetrieveRecordsCheck"));
    suite.addTest(new RetrieveRecordsCheckTest("testRetrieveRecordsCheck_type10"));
    suite.addTest(new RetrieveRecordsCheckTest("testRetrieveRecordsCheck_err"));
    return suite;
  }

  // passing an invalid ID
  public void testRetrieveRecordsCheck() {
    CCFC26SI ccfc26si = new CCFC26SI();
    logger.debug("testRetrieveRecordsCheck step 1");
    ccfc26si.setUlIdRecCheckPerson(5600077);
    logger.debug("testRetrieveRecordsCheck step 2");
    ccfc26si.setUlIdRecCheckRequestor(4656);
    logger.debug("testRetrieveRecordsCheck step 3");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc26si.setArchInputStruct(archInputStruct);
    retrieveRecordsCheck.retrieveRecordsCheck(ccfc26si);
    logger.debug("testRetrieveRecordsCheck step 4");
  }

  // test CHECK_TYPE_10 section
  public void testRetrieveRecordsCheck_type10() {
    CCFC26SI ccfc26si = new CCFC26SI();
    logger.debug("testRetrieveRecordsCheck_type10 step 1");
    ccfc26si.setUlIdRecCheckPerson(5600197);
    ccfc26si.setUlIdRecCheckRequestor(8624);
    logger.debug("testRetrieveRecordsCheck_type10 step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc26si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveRecordsCheck_type10 step 3");
    retrieveRecordsCheck.retrieveRecordsCheck(ccfc26si);
    logger.debug("testRetrieveRecordsCheck_type10 step 4");
  }

  // testing throwing an error by passing an invalid data
  public void testRetrieveRecordsCheck_err() {
    CCFC26SI ccfc26si = new CCFC26SI();
    logger.debug("testRetrieveRecordsCheck_err step 1");
    ccfc26si.setUlIdRecCheckPerson(-1);
    ccfc26si.setUlIdRecCheckRequestor(-1);
    logger.debug("testRetrieveRecordsCheck_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc26si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrieveRecordsCheck_err step 3");
    retrieveRecordsCheck.retrieveRecordsCheck(ccfc26si);
    logger.debug("testRetrieveRecordsCheck_err step 4");
  }

}
