package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveServicesAndReferralsTest extends BaseServiceTest {
  protected SaveServicesAndReferrals saveServicesAndReferrals = null;

  final String IN_STATE = "I";
  final String OUT_OF_STATE = "O";
  final String ADD_ACTION = ServiceConstants.REQ_FUNC_CD_ADD;
  final String UPDATE_ACTION = ServiceConstants.REQ_FUNC_CD_UPDATE;
  final String DELETE_ACTION = ServiceConstants.REQ_FUNC_CD_DELETE;
  final String ERROR_ACTION = "E";

  private static final String FALSE = "0";
  private final int INVALID_IDEVENT = 0;

  private final String SYSNBRRESERVED1_TRUE = "1";
  private final String SYSNBRRESERVED1_FALSE = "0";

  private int idEdhist;

  private Date dtLastUpdate;

  public SaveServicesAndReferralsTest(String testName) {
    super(testName);
  }

  public void setSaveServicesAndReferrals(SaveServicesAndReferrals saveServicesAndReferrals) {
    this.saveServicesAndReferrals = saveServicesAndReferrals;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();

    suite.addTest(new SaveServicesAndReferralsTest("testSaveServicesAndReferrals_add1"));
    suite.addTest(new SaveServicesAndReferralsTest("testSaveServicesAndReferrals_add2"));
    suite.addTest(new SaveServicesAndReferralsTest("testSaveServicesAndReferrals_add3"));

    //suite.addTest(new
    //SaveServicesAndReferralsTest("testSaveServicesAndReferrals_del"));
    return suite;

  }

  private Date retrieveDtLastUpdateForCPS_CHECKList(int id) {
    return (Date) jdbcTemplate.queryForObject("SELECT DT_LAST_UPDATE FROM CPS_CHECKLIST WHERE ID_CPS_CHECKLIST = ?",
                                              new Object[] {id}, Date.class);
  }

  private Date retrieveDtLastUpdateForCPS_CHECKListItem(int id) {
    return (Date) jdbcTemplate.queryForObject(
            "SELECT DT_LAST_UPDATE FROM CPS_CHECKLIST_ITEM WHERE ID_CPS_CHECKLIST_ITEM = ?", new Object[] {id},
            Date.class);
  }

  private String retrieveSrvcReferredForCPS_CHECKListItem(int id) {
    return (String) jdbcTemplate.queryForObject(
            "SELECT CD_SRVC_REFERRED FROM CPS_CHECKLIST_ITEM WHERE ID_CPS_CHECKLIST_ITEM = ?", new Object[] {id},
            String.class);
  }

  public void testSaveServicesAndReferrals_add1() {
    CINV55SI cinv55si = new CINV55SI();
    logger.debug("testSaveServicesAndReferrals_ADD1 step 1");
    cinv55si.setROWCINV55SIG01(build_add(5600510, 5600073, 5600152, ADD_ACTION, "2310"));
    logger.debug("testSaveServicesAndReferrals_ADD1 step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlSysNbrReserved1(FALSE);
    cinv55si.setArchInputStruct(archInputStruct);
    cinv55si.setUlIdPerson(2);
    cinv55si.setROWCINV55SIG00_ARRAY(build_array_sig00(ADD_ACTION, ADD_ACTION, 1));
    logger.debug("testSaveServicesAndReferrals_ADD1 step 3");
    saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
    logger.debug("testSaveServicesAndReferrals_ADD1 step 4");
  }

  // Testing a 2nd add action

  public void testSaveServicesAndReferrals_add2() {
    CINV55SI cinv55si = new CINV55SI();
    logger.debug("testSaveServicesAndReferrals_ADD2 step 1");
    try {
      change_cd_event_status_pend(5618926, 5605172, 5602427);
    } catch (Exception e) {
      logger.debug("&&&&&&&&&& change_cd_event_status() failed");
    }
    cinv55si.setROWCINV55SIG01(build_add(5618926, 5605172, 5602427, ADD_ACTION, "2310"));
    logger.debug("testSaveServicesAndReferrals_ADD2 step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlSysNbrReserved1(FALSE);
    cinv55si.setArchInputStruct(archInputStruct);
    cinv55si.setUlIdPerson(2);
    cinv55si.setROWCINV55SIG00_ARRAY(build_array_sig00(ADD_ACTION, ADD_ACTION, 1));
    logger.debug("testSaveServicesAndReferrals_ADD2 step 3");
    saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
    logger.debug("testSaveServicesAndReferrals_ADD2 step 4");
  }

  public void testSaveServicesAndReferrals_add3() {
    CINV55SI cinv55si = new CINV55SI();
    logger.debug("testSaveServicesAndReferrals_ADD3 step 1");
    try {
      change_cd_event_status_new(5618926, 5605172, 5602427);
    } catch (Exception e) {
      logger.debug("&&&&&&&&&& change_cd_event_status() failed");
    }
    cinv55si.setROWCINV55SIG01(build_add(5618926, 5605172, 5602427, ADD_ACTION, "2310"));
    logger.debug("testSaveServicesAndReferrals_ADD3 step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlSysNbrReserved1(FALSE);
    cinv55si.setArchInputStruct(archInputStruct);
    cinv55si.setUlIdPerson(2);
    cinv55si.setROWCINV55SIG00_ARRAY(build_array_sig00(ADD_ACTION, ADD_ACTION, 1));
    logger.debug("testSaveServicesAndReferrals_ADD3 step 3");
    saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
    logger.debug("testSaveServicesAndReferrals_ADD3 step 4");
  }

  // Testing a delete action

  public void testSaveServicesAndReferrals_del() {
    CINV55SI cinv55si = new CINV55SI();
    int chkListItemId = 1;
    logger.debug("testSaveServicesAndReferrals_DEL step 1");
    try {
      change_cd_event_status_new(5618926, 5605172, 5602427);
    } catch (Exception e) {
      logger.debug("&&&&&&&&&& change_cd_event_status() failed");
    }
    cinv55si.setROWCINV55SIG01(build_del(5618926, 5605172, 5602427, DELETE_ACTION, "2310"));
    logger.debug("testSaveServicesAndReferrals_DEL step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlSysNbrReserved1(FALSE);
    cinv55si.setArchInputStruct(archInputStruct);
    cinv55si.setUlIdPerson(2);
    cinv55si.setROWCINV55SIG00_ARRAY(build_array_sig00_2(DELETE_ACTION, chkListItemId));
    logger.debug("testSaveServicesAndReferrals_DEL step 3");
    saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
    logger.debug("testSaveServicesAndReferrals_DEL step 4");
  }

  // Testing the scenario of throwing an error when none of the valid actions
  // are used

  public void testSaveServicesAndReferrals_err() {
    CINV55SI cinv55si = new CINV55SI();
    logger.debug("testSaveServicesAndReferrals_err step 1");
    cinv55si.setROWCINV55SIG01(build_err(idEdhist, DELETE_ACTION, IN_STATE, 5000000, dtLastUpdate));
    logger.debug("testSaveServicesAndReferrals_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    cinv55si.setArchInputStruct(archInputStruct);
    cinv55si.setUlIdPerson(2);
    logger.debug("testSaveServicesAndReferrals_err step 3");
    try {
      saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
      fail("Should have received a ServiceException with Messages.");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD) {
        throw e;
      }
      // Ignore it; it was expected.
    }
    logger.debug("testSaveServicesAndReferrals_err step 4");
  }

  ROWCINV55SIG01 build_add(int id_event, int id_case, int id_stage, String dataAction, String cd_task) {
    ROWCINV55SIG01 rowcinv55sig01 = new ROWCINV55SIG01();
    rowcinv55sig01.setTsLastUpdate(retrieveDtLastUpdateForCPS_CHECKList(1));
    rowcinv55sig01.setUlIdCase(id_case);
    rowcinv55sig01.setUlIdStage(id_stage);
    rowcinv55sig01.setUlIdEvent(id_event);
    rowcinv55sig01.setSzCdScrDataAction(dataAction);
    rowcinv55sig01.setSzCdTask(cd_task);
    rowcinv55sig01.setUlIdCpsChecklist(1);
    rowcinv55sig01.setCIndSvcRefChklstNoRef("1");
    rowcinv55sig01.setSzCdFamilyResponse("r");
    rowcinv55sig01.setSzTxtChklstComments("Add Comment");

    return rowcinv55sig01;
  }

  private ROWCINV55SIG00_ARRAY build_array_sig00(String cdSvcReferred, String cdScrDataAction, int idChklistItem) {
    ROWCINV55SIG00_ARRAY rowcinv55sig00_array = new ROWCINV55SIG00_ARRAY();
    ROWCINV55SIG00 rowcinv55sig00 = new ROWCINV55SIG00();
    rowcinv55sig00.setSzCdSvcReferred(cdSvcReferred);
    rowcinv55sig00.setSzCdScrDataAction(cdScrDataAction);
    rowcinv55sig00.setUlIdChklstItem(idChklistItem);
    rowcinv55sig00.setTsLastUpdate(retrieveDtLastUpdateForCPS_CHECKListItem(idChklistItem));
    rowcinv55sig00_array.addROWCINV55SIG00(rowcinv55sig00);
    return rowcinv55sig00_array;
  }

  private ROWCINV55SIG00_ARRAY build_array_sig00_2(String cdScrDataAction, int idChklistItem) {
    ROWCINV55SIG00_ARRAY rowcinv55sig00_array = new ROWCINV55SIG00_ARRAY();
    ROWCINV55SIG00 rowcinv55sig00 = new ROWCINV55SIG00();
    rowcinv55sig00.setSzCdSvcReferred(retrieveSrvcReferredForCPS_CHECKListItem(idChklistItem));
    rowcinv55sig00.setSzCdScrDataAction(cdScrDataAction);
    rowcinv55sig00.setUlIdChklstItem(idChklistItem);
    rowcinv55sig00.setTsLastUpdate(retrieveDtLastUpdateForCPS_CHECKListItem(idChklistItem));
    rowcinv55sig00_array.addROWCINV55SIG00(rowcinv55sig00);
    return rowcinv55sig00_array;
  }

  private ROWCINV55SIG01 build_updt(int id_edHist, String dataAction, String schoolLoc, int id_res, Date dtLastUpdate) {
    ROWCINV55SIG01 rowcinv55sig01 = new ROWCINV55SIG01();
    rowcinv55sig01.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowcinv55sig01.setUlIdCase(id_edHist);
    rowcinv55sig01.setUlIdStage(1);
    rowcinv55sig01.setUlIdEvent(1);
    rowcinv55sig01.setSzCdScrDataAction(dataAction);
    rowcinv55sig01.setSzCdTask("2300");
    rowcinv55sig01.setUlIdCpsChecklist(1);
    rowcinv55sig01.setCIndSvcRefChklstNoRef("1");
    rowcinv55sig01.setSzCdFamilyResponse("r");
    rowcinv55sig01.setSzTxtChklstComments("Update Comment");

    return rowcinv55sig01;
  }

  private ROWCINV55SIG01 build_del(int id_event, int id_case, int id_stage, String dataAction, String cd_task) {
    return build_add(id_event, id_case, id_stage, dataAction, cd_task);
  }

  private ROWCINV55SIG01 build_err(int id_edHist, String dataAction, String schoolLoc, int id_res, Date dtLastUpdate) {
    // Messages.SQL_NOT_FOUND with invalid id_event
    return build_updt(id_edHist, dataAction, schoolLoc, id_res, dtLastUpdate);
  }

  protected void change_cdTask(int id_stage, String cd_task) throws Exception {
    jdbcTemplate.update("UPDATE event SET " +
                        " (CD_TASK = ?) WHERE ID_STAGE = ?", new Object[] {cd_task, id_stage});
    jdbcTemplate.update("UPDATE event SET " +
                        " (CD_TASK = ?) WHERE ID_STAGE = ?", new Object[] {cd_task, id_stage});
  }

  protected void change_cd_event_status_pend(int id_event, int id_case, int id_stage
  ) throws Exception {
    jdbcTemplate.update("UPDATE event SET " +
                        " CD_EVENT_STATUS = 'PEND' WHERE ID_EVENT = ? AND ID_CASE = ? AND ID_EVENT_STAGE = ? ",
                        new Object[] {id_event, id_case, id_stage});
  }

  protected void change_cd_event_status_new(int id_event, int id_case, int id_stage
  ) throws Exception {
    jdbcTemplate.update("UPDATE event SET " +
                        " CD_EVENT_STATUS = 'NEW' WHERE ID_EVENT = ? AND ID_CASE = ? AND ID_EVENT_STAGE = ? ",
                        new Object[] {id_event, id_case, id_stage});
  }

}
