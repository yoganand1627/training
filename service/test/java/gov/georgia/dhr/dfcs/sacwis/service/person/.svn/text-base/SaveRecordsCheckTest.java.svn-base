package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveRecordsCheckTest extends BaseServiceTest {
  protected SaveRecordsCheck saveRecordsCheck = null;

  final String IN_STATE = "I";

  final String OUT_OF_STATE = "O";

  final String ADD_ACTION = ServiceConstants.REQ_FUNC_CD_ADD;

  final String UPDATE_ACTION = ServiceConstants.REQ_FUNC_CD_UPDATE;

  final String DELETE_ACTION = ServiceConstants.REQ_FUNC_CD_DELETE;

  final String ERROR_ACTION = "E";

  public SaveRecordsCheckTest(String testName) {
    super(testName);
  }

  public void setSaveRecordsCheck(SaveRecordsCheck saveRecordsCheck) {
    this.saveRecordsCheck = saveRecordsCheck;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveRecordsCheckTest("testSaveRecordsCheck"));
    suite.addTest(new SaveRecordsCheckTest("testSaveRecordsCheck_add"));
    suite.addTest(new SaveRecordsCheckTest("testSaveRecordsCheck_updt"));
    suite.addTest(new SaveRecordsCheckTest("testSaveRecordsCheck_del"));
    suite.addTest(new SaveRecordsCheckTest("testSaveRecordsCheck_err"));
    suite.addTest(new SaveRecordsCheckTest("testSaveRecordsCheck_multi"));
    return suite;
  }

  // Testing an add action

  public void testSaveRecordsCheck() {
    CCFC27SI ccfc27si = new CCFC27SI();
    logger.debug("testSaveRecordsCheck step 1");
    ccfc27si.setROWCCFC27SIG00_ARRAY(buildEdHist_array(0, ADD_ACTION, IN_STATE));
//    ccfc27si.setROWCCFC27SIG00_ARRAY(buildEdHist_array(5600168, ADD_ACTION, IN_STATE));
    logger.debug("testSaveRecordsCheck step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc27si.setArchInputStruct(archInputStruct);
    ccfc27si.setUlIdRecCheckPerson(2);
    logger.debug("testSaveRecordsCheck step 3");
    saveRecordsCheck.audRecordsCheck(ccfc27si);
    logger.debug("testSaveRecordsCheck step 4");
  }
  // Testing a 2nd add action

  public void testSaveRecordsCheck_add() {
    CCFC27SI ccfc27si = new CCFC27SI();
    logger.debug("testSaveRecordsCheck_add step 1");
    ccfc27si.setROWCCFC27SIG00_ARRAY(buildEdHist_array(0, ADD_ACTION, OUT_OF_STATE));
    logger.debug("testSaveRecordsCheck_add step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc27si.setArchInputStruct(archInputStruct);
    ccfc27si.setUlIdRecCheckPerson(2);
    logger.debug("testSaveRecordsCheck_add step 3");
    saveRecordsCheck.audRecordsCheck(ccfc27si);
    logger.debug("testSaveRecordsCheck_add step 4");
  }

  // testing an update action

  public void testSaveRecordsCheck_updt() {
    CCFC27SI ccfc27si = new CCFC27SI();
    logger.debug("testSaveRecordsCheck_updt step 1");
    // this date 5/23/2004 12:20:19 PM  is only for idRecCheck 5600123
    Date dtLastUpdate = createDate(2004, 4, 23, 12, 20, 19);
    ccfc27si.setROWCCFC27SIG00_ARRAY(buildError_array_updt(5600123, UPDATE_ACTION, IN_STATE, dtLastUpdate));
    logger.debug("testSaveRecordsCheck_updt step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc27si.setArchInputStruct(archInputStruct);
    ccfc27si.setUlIdRecCheckPerson(2);
    logger.debug("testSaveRecordsCheck_updt step 3");
    saveRecordsCheck.audRecordsCheck(ccfc27si);
    logger.debug("testSaveRecordsCheck_updt step 4");
  }

  //Testing a delete action

  public void testSaveRecordsCheck_del() {
    CCFC27SI ccfc27si = new CCFC27SI();
    logger.debug("testSaveRecordsCheck_del step 1");
    // this date 8/5/1996 9:49:21 AM  is only for idRecCheck 5600000
    Date dtLastUpdate = createDate(1996, 7, 5, 9, 49, 21);
    ccfc27si.setROWCCFC27SIG00_ARRAY(buildEdHist_array_del(5600000, DELETE_ACTION, IN_STATE, dtLastUpdate));
    logger.debug("testSaveRecordsCheck_del step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc27si.setArchInputStruct(archInputStruct);
    ccfc27si.setUlIdRecCheckPerson(2);
    logger.debug("testSaveRecordsCheck_del step 3");
    saveRecordsCheck.audRecordsCheck(ccfc27si);
    logger.debug("testSaveRecordsCheck_del step 4");
  }

  // testing multiple combination actions

  public void testSaveRecordsCheck_multi() {
    CCFC27SI ccfc27si = new CCFC27SI();
    logger.debug("testSaveRecordsCheck_multi step 1");
    ccfc27si.setROWCCFC27SIG00_ARRAY(buildEdHist_array_multiple());
    logger.debug("testSaveRecordsCheck_multi step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc27si.setArchInputStruct(archInputStruct);
    ccfc27si.setUlIdRecCheckPerson(2);
    logger.debug("testSaveRecordsCheck_multi step 3");
    saveRecordsCheck.audRecordsCheck(ccfc27si);
    logger.debug("testSaveRecordsCheck_multi step 4");
  }

  // Testing the scenario of throwing an error when none of the valid actions are used

  public void testSaveRecordsCheck_err() {
    CCFC27SI ccfc27si = new CCFC27SI();
    logger.debug("testSaveRecordsCheck_err step 1");
    ccfc27si.setROWCCFC27SIG00_ARRAY(buildError_array());
    logger.debug("testSaveRecordsCheck_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc27si.setArchInputStruct(archInputStruct);
    ccfc27si.setUlIdRecCheckPerson(5600080);
    logger.debug("testSaveRecordsCheck_err step 3");
    try {
      saveRecordsCheck.audRecordsCheck(ccfc27si);
      fail("Excpected ServiceException with Messages.ARC_ERR_BAD_FUNC_CD.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD) {
        throw se;
      }
      // We expected this; ignore it.
    }
    logger.debug("testSaveRecordsCheck_err step 4");
  }

  private ROWCCFC27SIG00_ARRAY buildEdHist_array(int id_RecCheck, String checkType, String checkStatus) {
    ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_add(id_RecCheck, checkType, checkStatus));
    return rowccfc27sig00_array;
  }

  private ROWCCFC27SIG00_ARRAY buildEdHist_array_multiple() {
    ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_add(0, "10", ""));
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_add(0, "30", ""));
    // this date 8/19/2003 9:59:33 PM is only for idRecCheck 5600120
    Date dtLastUpdate = createDate(2003, 7, 19, 21, 59, 33);
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_updt(5600120, "20", "C", dtLastUpdate));
    return rowccfc27sig00_array;
  }

  private ROWCCFC27SIG00_ARRAY buildError_array() {
    ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_err(5600170, "30", ""));
    return rowccfc27sig00_array;
  }

  private ROWCCFC27SIG00_ARRAY buildEdHist_array_del(int id_RecCheck, String checkType, String checkStatus,
                                                     Date dtLastUpdate) {
    ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_del(id_RecCheck, checkType, checkStatus, dtLastUpdate));
    return rowccfc27sig00_array;
  }

  ROWCCFC27SIG00 buildEdHist_add(int id_RecCheck, String checkType, String checkStatus) {
    ROWCCFC27SIG00 rowccfc27sig00 = new ROWCCFC27SIG00();
    rowccfc27sig00.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowccfc27sig00.setUlIdRecCheck(id_RecCheck);
    rowccfc27sig00.setSzCdRecCheckCheckType(checkType);
    rowccfc27sig00.setSzCdRecCheckStatus(checkStatus);
    rowccfc27sig00.setSzTxtRecCheckComments("Test add Record check");
    rowccfc27sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setSzCdScrDataAction(ADD_ACTION);
    rowccfc27sig00.setUlIdRecCheckRequestor(4656);
    return rowccfc27sig00;
  }

  private ROWCCFC27SIG00_ARRAY buildError_array_updt(int id_RecCheck, String checkType, String checkStatus,
                                                     Date dtLastUpdate) {
    ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    rowccfc27sig00_array.addROWCCFC27SIG00(buildEdHist_updt(id_RecCheck, checkType, checkStatus, dtLastUpdate));
    return rowccfc27sig00_array;
  }

  private ROWCCFC27SIG00 buildEdHist_updt(int id_RecCheck, String checkType, String checkStatus, Date dtLastUpdate) {
    logger.debug("*** buildEdHist_updt dtLastUpdate : " + dtLastUpdate.toString());

    ROWCCFC27SIG00 rowccfc27sig00 = new ROWCCFC27SIG00();
    rowccfc27sig00.setTsLastUpdate(dtLastUpdate);
    rowccfc27sig00.setUlIdRecCheck(id_RecCheck);
    rowccfc27sig00.setSzCdRecCheckCheckType(checkType);
    rowccfc27sig00.setSzCdRecCheckStatus(checkStatus);
    rowccfc27sig00.setSzTxtRecCheckComments("Test update Record check");
    rowccfc27sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setSzCdScrDataAction(UPDATE_ACTION);
    rowccfc27sig00.setUlIdRecCheckRequestor(4656);

    return rowccfc27sig00;
  }

  private ROWCCFC27SIG00 buildEdHist_del(int id_RecCheck, String checkType,
                                         String checkStatus, Date dtLastUpdate) {
    ROWCCFC27SIG00 rowccfc27sig00 = new ROWCCFC27SIG00();
    rowccfc27sig00.setTsLastUpdate(dtLastUpdate);
    rowccfc27sig00.setUlIdRecCheck(id_RecCheck);
    rowccfc27sig00.setSzCdRecCheckCheckType(checkType);
    rowccfc27sig00.setSzCdRecCheckStatus(checkStatus);
    rowccfc27sig00.setSzTxtRecCheckComments("Test update Record check");
    rowccfc27sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setSzCdScrDataAction(DELETE_ACTION);
    rowccfc27sig00.setUlIdRecCheckRequestor(4656);

    return rowccfc27sig00;
  }

  private ROWCCFC27SIG00 buildEdHist_err(int id_RecCheck, String checkType, String checkStatus) {
    ROWCCFC27SIG00 rowccfc27sig00 = new ROWCCFC27SIG00();
    rowccfc27sig00.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowccfc27sig00.setUlIdRecCheck(id_RecCheck);
    rowccfc27sig00.setSzCdRecCheckCheckType(checkType);
    rowccfc27sig00.setSzCdRecCheckStatus(checkStatus);
    rowccfc27sig00.setSzTxtRecCheckComments("Test update Record check");
    rowccfc27sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowccfc27sig00.setSzCdScrDataAction(ERROR_ACTION);
    rowccfc27sig00.setUlIdRecCheckRequestor(4656);
    return rowccfc27sig00;
  }

  private Date createDate(int year, int month, int day, int hour, int min, int sec) {
    return new GregorianCalendar(year, month, day, hour, min, sec).getTime();
  }

}
