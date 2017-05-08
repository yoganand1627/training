package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
//import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdCategoryCategory_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.util.Date;
import java.util.GregorianCalendar;

public class SavePersonDetailTest extends BaseServiceTest {
  protected SavePersonDetail savePersonDetail = null;

  final String IN_STATE = "I";

  final String OUT_OF_STATE = "O";

  final String ADD_ACTION = ServiceConstants.REQ_FUNC_CD_ADD;

  final String UPDATE_ACTION = ServiceConstants.REQ_FUNC_CD_UPDATE;

  final String DELETE_ACTION = ServiceConstants.REQ_FUNC_CD_DELETE;

  final String ERROR_ACTION = "E";

  public SavePersonDetailTest(String testName) {
    super(testName);
  }

  public void setSavePersonDetail(SavePersonDetail savePersonDetail) {
    this.savePersonDetail = savePersonDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
  //  suite.addTest(new SavePersonDetailTest("testSavePersonDetail"));
  //  suite.addTest(new SavePersonDetailTest("testSavePersonDetail_add"));
  //  suite.addTest(new SavePersonDetailTest("testSavePersonDetail_updt"));
   // suite.addTest(new SavePersonDetailTest("testSavePersonDetail_del"));
   // suite.addTest(new SavePersonDetailTest("testSavePersonDetail_err"));
   // suite.addTest(new SavePersonDetailTest("testSavePersonDetail_multi"));
    return suite;
  }

  // Testing an add action

  public void testSavePersonDetail() {
    CINV05SI cinv05si = new CINV05SI();
    logger.debug("testSavePersonDetail step 1");
   // // cinv05si.setROWCINV05SG00_ARRAY(buildEdHist_array(0, ADD_ACTION, IN_STATE));
//    // cinv05si.setROWCINV05SG00_ARRAY(buildEdHist_array(5600168, ADD_ACTION, IN_STATE));
    logger.debug("testSavePersonDetail step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.FALSE);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD); // req add/update
    cinv05si.setArchInputStruct(archInputStruct);
    cinv05si.setUlIdStage(5600185);
    cinv05si.setUlIdPerson(5500160);
    cinv05si.setCCdPersonSex("M");
    cinv05si.setSzCdTask("1000"); // findTaskByCdTask stage table
    cinv05si.setDtDtPersonDeath(null);
    SzCdCategoryCategory_ARRAY cat_array = new SzCdCategoryCategory_ARRAY();
    cat_array.addSzCdCategoryCategory("CAS");
    cinv05si.setSzCdCategoryCategory_ARRAY(cat_array);
//    cinv05si.setDtDtPersonDeath(DateHelper.toCastorDate(createDate(1998, 7, 1, 0,0,0)));
    logger.debug("testSavePersonDetail step 3");
    savePersonDetail.savePersonDetail(cinv05si);
    logger.debug("testSavePersonDetail step 4");
  }
  // Testing a 2nd add action
/*
  // DOD is NULL
  public void testSavePersonDetail_add() {
    CINV05SI cinv05si = new CINV05SI();
    logger.debug("testSavePersonDetail_add step 1");
    // cinv05si.setROWCINV05SG00_ARRAY(buildEdHist_array(0, ADD_ACTION, OUT_OF_STATE));
    logger.debug("testSavePersonDetail_add step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv05si.setArchInputStruct(archInputStruct);
    cinv05si.setUlIdStage(132);
    cinv05si.setUlIdPerson(5602393);
    cinv05si.setSzCdTask("2210"); // findTaskByCdTask stage table
    cinv05si.setDtDtPersonDeath(null);
    logger.debug("testSavePersonDetail_add step 3");
    savePersonDetail.savePersonDetail(cinv05si);
    logger.debug("testSavePersonDetail_add step 4");
  }

  // testing an update action

  public void testSavePersonDetail_updt() {
    CINV05SI cinv05si = new CINV05SI();
    logger.debug("testSavePersonDetail_updt step 1");
    // this date 5/23/2004 12:20:19 PM  is only for idRecCheck 5600123
    Date dtLastUpdate = createDate(2004, 4, 23, 12, 20, 19);
    // cinv05si.setROWCINV05SG00_ARRAY(buildError_array_updt(5600123, UPDATE_ACTION, IN_STATE, dtLastUpdate));
    logger.debug("testSavePersonDetail_updt step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv05si.setArchInputStruct(archInputStruct);
    logger.debug("testSavePersonDetail_updt step 3");
    savePersonDetail.savePersonDetail(cinv05si);
    logger.debug("testSavePersonDetail_updt step 4");
  }

  //Testing a delete action

  public void testSavePersonDetail_del() {
    CINV05SI cinv05si = new CINV05SI();
    logger.debug("testSavePersonDetail_del step 1");
    // this date 8/5/1996 9:49:21 AM  is only for idRecCheck 5600000
    Date dtLastUpdate = createDate(1996, 7, 5, 9, 49, 21);
    // cinv05si.setROWCINV05SG00_ARRAY(buildEdHist_array_del(5600000, DELETE_ACTION, IN_STATE, dtLastUpdate));
    logger.debug("testSavePersonDetail_del step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv05si.setArchInputStruct(archInputStruct);
    logger.debug("testSavePersonDetail_del step 3");
    savePersonDetail.savePersonDetail(cinv05si);
    logger.debug("testSavePersonDetail_del step 4");
  }

  // testing multiple combination actions

  public void testSavePersonDetail_multi() {
    CINV05SI cinv05si = new CINV05SI();
    logger.debug("testSavePersonDetail_multi step 1");
    // cinv05si.setROWCINV05SG00_ARRAY(buildEdHist_array_multiple());
    logger.debug("testSavePersonDetail_multi step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv05si.setArchInputStruct(archInputStruct);
    logger.debug("testSavePersonDetail_multi step 3");
    savePersonDetail.savePersonDetail(cinv05si);
    logger.debug("testSavePersonDetail_multi step 4");
  }

  // Testing the scenario of throwing an error when none of the valid actions are used

  public void testSavePersonDetail_err() {
    CINV05SI cinv05si = new CINV05SI();
    logger.debug("testSavePersonDetail_err step 1");
    // cinv05si.setROWCINV05SG00_ARRAY(buildError_array());
    logger.debug("testSavePersonDetail_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv05si.setArchInputStruct(archInputStruct);
    logger.debug("testSavePersonDetail_err step 3");
    try {
      savePersonDetail.savePersonDetail(cinv05si);
      fail("Excpected ServiceException with Messages.ARC_ERR_BAD_FUNC_CD.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD) {
        throw se;
      }
      // We expected this; ignore it.
    }
    logger.debug("testSavePersonDetail_err step 4");
  }

  private ROWCINV05SG00_ARRAY buildEdHist_array(int id_RecCheck, String checkType, 
                                                 String checkStatus) {
    ROWCINV05SG00_ARRAY rowcinv05sig00_array = new ROWCINV05SG00_ARRAY();
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_add(id_RecCheck, checkType, checkStatus));
    return rowcinv05sig00_array;
  }

  private ROWCINV05SG00_ARRAY buildEdHist_array_multiple() {
    ROWCINV05SG00_ARRAY rowcinv05sig00_array = new ROWCINV05SG00_ARRAY();
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_add(5600168, "10", ""));
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_add(5600169, "30", ""));
    // this date 8/19/2003 9:59:33 PM is only for idRecCheck 5600120
    Date dtLastUpdate = createDate(2003, 7, 19, 21, 59, 33);
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_updt(5600120, "20", "C", dtLastUpdate));
    return rowcinv05sig00_array;
  }

  private ROWCINV05SG00_ARRAY buildError_array() {
    ROWCINV05SG00_ARRAY rowcinv05sig00_array = new ROWCINV05SG00_ARRAY();
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_err(5600170, "30", ""));
    return rowcinv05sig00_array;
  }

  private ROWCINV05SG00_ARRAY buildEdHist_array_del(int id_RecCheck, String checkType, 
                                                     String checkStatus, Date dtLastUpdate) {
    ROWCINV05SG00_ARRAY rowcinv05sig00_array = new ROWCINV05SG00_ARRAY();
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_del(id_RecCheck, checkType, checkStatus, dtLastUpdate));
    return rowcinv05sig00_array;
  }

  private ROWCINV05SG00_ARRAY buildError_array_updt(int id_RecCheck, String checkType, 
                                                     String checkStatus, 
                                                     Date dtLastUpdate) {
    ROWCINV05SG00_ARRAY rowcinv05sig00_array = new ROWCINV05SG00_ARRAY();
    rowcinv05sig00_array.addROWCINV05SG00(buildEdHist_updt(id_RecCheck, checkType, checkStatus, dtLastUpdate));
    return rowcinv05sig00_array;
  }

 private  ROWCINV05SG00 buildEdHist_add(int id_RecCheck, String checkType, String checkStatus) {
    ROWCINV05SG00 rowcinv05sig00 = new ROWCINV05SG00();
    rowcinv05sig00.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowcinv05sig00.setUlIdRecCheck(id_RecCheck);
    rowcinv05sig00.setSzCdRecCheckCheckType(checkType);
    rowcinv05sig00.setSzCdRecCheckStatus(checkStatus);
    rowcinv05sig00.setSzTxtRecCheckComments("Test add Record check");
    rowcinv05sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setSzCdScrDataAction(ADD_ACTION);
    rowcinv05sig00.setUlIdRecCheckRequestor(4656);
    return rowcinv05sig00;
  }

  private ROWCINV05SG00 buildEdHist_updt(int id_RecCheck, String checkType, 
                                          String checkStatus, Date dtLastUpdate) {
    logger.debug("*** buildEdHist_updt dtLastUpdate : " + dtLastUpdate.toString());
   
    ROWCINV05SG00 rowcinv05sig00 = new ROWCINV05SG00();
    rowcinv05sig00.setTsLastUpdate(dtLastUpdate);
    rowcinv05sig00.setUlIdRecCheck(id_RecCheck);
    rowcinv05sig00.setSzCdRecCheckCheckType(checkType);
    rowcinv05sig00.setSzCdRecCheckStatus(checkStatus);
    rowcinv05sig00.setSzTxtRecCheckComments("Test update Record check");
    rowcinv05sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setSzCdScrDataAction(UPDATE_ACTION);
    rowcinv05sig00.setUlIdRecCheckRequestor(4656);

    return rowcinv05sig00;
  }

  private ROWCINV05SG00 buildEdHist_del(int id_RecCheck, String checkType, 
                                         String checkStatus, Date dtLastUpdate) {
    ROWCINV05SG00 rowcinv05sig00 = new ROWCINV05SG00();
    rowcinv05sig00.setTsLastUpdate(dtLastUpdate);
    rowcinv05sig00.setUlIdRecCheck(id_RecCheck);
    rowcinv05sig00.setSzCdRecCheckCheckType(checkType);
    rowcinv05sig00.setSzCdRecCheckStatus(checkStatus);
    rowcinv05sig00.setSzTxtRecCheckComments("Test update Record check");
    rowcinv05sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setSzCdScrDataAction(DELETE_ACTION);
    rowcinv05sig00.setUlIdRecCheckRequestor(4656);

    return rowcinv05sig00;
  }

  private ROWCINV05SG00 buildEdHist_err(int id_RecCheck, String checkType, String checkStatus) {
    ROWCINV05SG00 rowcinv05sig00 = new ROWCINV05SG00();
    rowcinv05sig00.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowcinv05sig00.setUlIdRecCheck(id_RecCheck);
    rowcinv05sig00.setSzCdRecCheckCheckType(checkType);
    rowcinv05sig00.setSzCdRecCheckStatus(checkStatus);
    rowcinv05sig00.setSzTxtRecCheckComments("Test update Record check");
    rowcinv05sig00.setDtDtRecCheckCompleted(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setDtDtRecCheckRequest(DateHelper.getTodayCastorDate());
    rowcinv05sig00.setSzCdScrDataAction(ERROR_ACTION);
    rowcinv05sig00.setUlIdRecCheckRequestor(4656);

    return rowcinv05sig00;
  }
 */ 
  private Date createDate(int year, int month, int day, int hour, int min, int sec){
    return new GregorianCalendar(year, month, day, hour, min, sec).getTime();
  }

}
