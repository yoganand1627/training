package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrievePersonDetailTest extends BaseServiceTest{
  protected RetrievePersonDetail retrievePersonDetail = null;
  private static final String WINDOW_MODE_RELATE = PageModeConstants.PersonDetail.WINDOW_MODE_RELATE;
  private static final String WINDOW_MODE_MNTN_PERSON = PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON;
  private static final String INITIAL_DEATH_TABLE = "INIT_CHLD_DTH_NARR_VIEW";
  private static final String COMMITTEE_DEATH_TABLE = "CHLD_DTH_COMM_NARR_VIEW";
  private static final int INITIAL_DOC_INDEX = 0;
  private static final int COMMITTEE_DOC_INDEX = 1;
  
  public RetrievePersonDetailTest(String testName){
    super(testName);
  }
  
  public void setRetrievePersonDetail(RetrievePersonDetail retrievePersonDetail){
  this.retrievePersonDetail = retrievePersonDetail;
  }
  
  public static Test suite(){
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrievePersonDetailTest("testRetrievePersonDetail"));
    return suite;
  }
  
  // testing personDAO.findPersonByIdPerson and expecting a return
  public void testRetrievePersonDetail(){
    CINV04SI cinv04si = new CINV04SI();
    logger.debug("testRetrievePersonDetail step 1");
      cinv04si.setUlIdPerson(4012274);
      cinv04si.setUlIdStage(240);
      cinv04si.setUlIdCase(10288);
      cinv04si.setSzSysCdWinMode(WINDOW_MODE_RELATE);
    logger.debug("testRetrievePersonDetail step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv04si.setArchInputStruct(archInputStruct);
    logger.debug("testRetrievePersonDetail step 3");
    retrievePersonDetail.retrievePersonDetail(cinv04si);
    logger.debug("testRetrievePersonDetail step 4");
  }
  // test CHECK_TYPE_10 section
  public void testRetrievePersonDetail1(){
    CINV04SI cinv04si = new CINV04SI();
    cinv04si.setUlIdPerson(5600040);
    cinv04si.setUlIdStage(240);
    cinv04si.setUlIdCase(10288);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv04si.setArchInputStruct(archInputStruct);
    retrievePersonDetail.retrievePersonDetail(cinv04si);
  }
  // testing throwing an error by passing an invalid data
  public void testRetrievePersonDetail_pID_err(){
    CINV04SI cinv04si = new CINV04SI();
    cinv04si.setUlIdPerson(-1);
    cinv04si.setUlIdStage(240);
    cinv04si.setUlIdCase(10288);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv04si.setArchInputStruct(archInputStruct);
    try { // Only these two lines go inside the try.
    retrievePersonDetail.retrievePersonDetail(cinv04si);
    fail("Expected an exception with object == null or empty");
    } catch (ServiceException se) {
      // Ignore the exception; we expected it. }
      logger.debug("No record found for the given criteria");
    }
  }
  
  // testing throwing an error by passing an invalid data
  public void testRetrievePersonDetail_stgID_err(){
    CINV04SI cinv04si = new CINV04SI();
    cinv04si.setUlIdPerson(4012274);
    cinv04si.setUlIdStage(-1);
    cinv04si.setUlIdCase(10288);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv04si.setArchInputStruct(archInputStruct);
    try { // Only these two lines go inside the try.
    retrievePersonDetail.retrievePersonDetail(cinv04si);
    fail("Expected an exception with object == null or empty");
    } catch (ServiceException se) {
      // Ignore the exception; we expected it. }
      logger.debug("No record found for the given criteria");
    }
  }
  
  // testing throwing an error by passing an invalid data
  public void testRetrievePersonDetail_CaseID_err(){
    CINV04SI cinv04si = new CINV04SI();
    cinv04si.setUlIdPerson(4012274);
    cinv04si.setUlIdStage(240);
    cinv04si.setUlIdCase(-1);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv04si.setArchInputStruct(archInputStruct);
    try { // Only these two lines go inside the try.
    retrievePersonDetail.retrievePersonDetail(cinv04si);
    fail("Expected an exception with object == null or empty");
    } catch (ServiceException se) {
      // Ignore the exception; we expected it. }
      logger.debug("No record found for the given criteria");
    }
  }
  
  private Date createDate(int year, int month, int day, int hour, int min, int sec){
    return new GregorianCalendar(year, month, day, hour, min, sec).getTime();
  }

  
}
