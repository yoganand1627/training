package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC18SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC18SIG00_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveEducationalHistoryTest extends BaseServiceTest {
  protected SaveEducationalHistory saveEducationalHistory = null;

  final String IN_STATE = "I";

  final String OUT_OF_STATE = "O";

  final String ADD_ACTION = ServiceConstants.REQ_FUNC_CD_ADD;

  final String UPDATE_ACTION = ServiceConstants.REQ_FUNC_CD_UPDATE;

  final String DELETE_ACTION = ServiceConstants.REQ_FUNC_CD_DELETE;

  final String ERROR_ACTION = "E";
  private int idEdhist;
  private Date dtLastUpdate;

  public SaveEducationalHistoryTest(String testName) {
    super(testName);
  }

  public void setSaveEducationalHistory(SaveEducationalHistory saveEducationalHistory) {
    this.saveEducationalHistory = saveEducationalHistory;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveEducationalHistoryTest("testSaveEducationalHistory_add1"));
    suite.addTest(new SaveEducationalHistoryTest("testSaveEducationalHistory_updt"));
    suite.addTest(new SaveEducationalHistoryTest("testSaveEducationalHistory_del"));
    suite.addTest(new SaveEducationalHistoryTest("testSaveEducationalHistory_multi"));
    suite.addTest(new SaveEducationalHistoryTest("testSaveEducationalHistory_err"));
    return suite;

  }

  protected void onSetUpInTransaction() throws Exception {
    super.onSetUpInTransaction();
    idEdhist = getSequenceNextval("SEQ_EDUCATIONAL_HISTORY");
    jdbcTemplate.update("INSERT INTO EDUCATIONAL_HISTORY (ID_PERSON, ID_EDHIST) values (?, ?)",
                        new Object[] {5500150, idEdhist});
    int idEdhist = this.idEdhist;
    dtLastUpdate = retrieveDtLastUpdateForEducationalHistory(idEdhist);
  }

  private Date retrieveDtLastUpdateForEducationalHistory(int idEdhist) {
    return (Date) jdbcTemplate.queryForObject("SELECT DT_LAST_UPDATE FROM EDUCATIONAL_HISTORY WHERE ID_EDHIST = ?",
                                              new Object[] {idEdhist}, Date.class);
  }

  public void testSaveEducationalHistory_add1() {
    CCFC18SI ccfc18si = new CCFC18SI();
    logger.debug("testSaveEducationalHistory_ADD1 step 1");
    ccfc18si.setROWCCFC18SIG00_ARRAY(buildEdHist_array_add(0, ADD_ACTION, IN_STATE, 5000001));
    logger.debug("testSaveEducationalHistory_ADD1 step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc18si.setArchInputStruct(archInputStruct);
    ccfc18si.setUlIdPerson(2);
    logger.debug("testSaveEducationalHistory_ADD1 step 3");
    saveEducationalHistory.audEducationalHistory(ccfc18si);
    logger.debug("testSaveEducationalHistory_ADD1 step 4");
  }

  // Testing a 2nd add action

  public void testSaveEducationalHistory_add2() {
    CCFC18SI ccfc18si = new CCFC18SI();
    logger.debug("testSaveEducationalHistory_ADD2 step 1");
    ccfc18si.setROWCCFC18SIG00_ARRAY(buildEdHist_array_add(3, ADD_ACTION, OUT_OF_STATE, 5000002));
    logger.debug("testSaveEducationalHistory_ADD2 step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc18si.setArchInputStruct(archInputStruct);
    ccfc18si.setUlIdPerson(2);
    logger.debug("testSaveEducationalHistory_ADD2 step 3");
    saveEducationalHistory.audEducationalHistory(ccfc18si);
    logger.debug("testSaveEducationalHistory_ADD2 step 4");
  }

  // testing an update action

  public void testSaveEducationalHistory_updt() {
    CCFC18SI ccfc18si = new CCFC18SI();
    logger.debug("testSaveEducationalHistory_UPDT step 1");
    // this date 5/31/2006 11:54:32 PM  is only for idRes 5000000
    ccfc18si.setROWCCFC18SIG00_ARRAY(buildEdHist_array_updt(idEdhist, UPDATE_ACTION, IN_STATE, 5000000, dtLastUpdate));
    logger.debug("testSaveEducationalHistory_UPDT step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc18si.setArchInputStruct(archInputStruct);
    ccfc18si.setUlIdPerson(2);
    logger.debug("testSaveEducationalHistory_UPDT step 3");
    saveEducationalHistory.audEducationalHistory(ccfc18si);
    logger.debug("testSaveEducationalHistory_UPDT step 4");
  }

  //Testing a delete action

  public void testSaveEducationalHistory_del() {
    CCFC18SI ccfc18si = new CCFC18SI();
    logger.debug("testSaveEducationalHistory_del step 1");
    // this date 5/31/2006 11:54:32 PM  is only for idRes 5000000
    ccfc18si.setROWCCFC18SIG00_ARRAY(buildEdHist_array_del(idEdhist, DELETE_ACTION, IN_STATE, 5000000, dtLastUpdate));
    logger.debug("testSaveEducationalHistory_del step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc18si.setArchInputStruct(archInputStruct);
    ccfc18si.setUlIdPerson(2);
    logger.debug("testSaveEducationalHistory_del step 3");
    saveEducationalHistory.audEducationalHistory(ccfc18si);
    logger.debug("testSaveEducationalHistory_del step 4");
  }

  // testing multiple combination actions

  public void testSaveEducationalHistory_multi() {
    CCFC18SI ccfc18si = new CCFC18SI();
    logger.debug("testSaveEducationalHistory_multi step 1");
    ccfc18si.setROWCCFC18SIG00_ARRAY(buildEdHist_array_multi());
    logger.debug("testSaveEducationalHistory_multi step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc18si.setArchInputStruct(archInputStruct);
    ccfc18si.setUlIdPerson(2);
    logger.debug("testSaveEducationalHistory_multi step 3");
    saveEducationalHistory.audEducationalHistory(ccfc18si);
    logger.debug("testSaveEducationalHistory_multi step 4");
  }

  // Testing the scenario of throwing an error when none of the valid actions are used

  public void testSaveEducationalHistory_err() {
    CCFC18SI ccfc18si = new CCFC18SI();
    logger.debug("testSaveEducationalHistory_err step 1");
    ccfc18si.setROWCCFC18SIG00_ARRAY(buildEdHist_array_err());
    logger.debug("testSaveEducationalHistory_err step 2");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc18si.setArchInputStruct(archInputStruct);
    ccfc18si.setUlIdPerson(2);
    logger.debug("testSaveEducationalHistory_err step 3");
    try {
      saveEducationalHistory.audEducationalHistory(ccfc18si);
      fail("Should have received a ServiceException with Messages.");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD) {
        throw e;
      }
      // Ignore it; it was expected.
    }
    logger.debug("testSaveEducationalHistory_err step 4");
  }

  private ROWCCFC18SIG00_ARRAY buildEdHist_array_add(int id_edHist, String dataAction, String schoolLoc, int id_res) {
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_add(id_edHist, dataAction, schoolLoc, id_res));
    return rowccfc18sig00_array;
  }

  private ROWCCFC18SIG00_ARRAY buildEdHist_array_multi() {
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_add(0, ADD_ACTION, IN_STATE, 5000001));
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_add(0, ADD_ACTION, OUT_OF_STATE, 5000002));
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_updt(idEdhist, UPDATE_ACTION, IN_STATE, 5000000, dtLastUpdate));
    Date newDtLastUpdate = retrieveDtLastUpdateForEducationalHistory(idEdhist);
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_del(idEdhist, DELETE_ACTION, IN_STATE, 5000000,
                                                           newDtLastUpdate));
    return rowccfc18sig00_array;
  }

  private ROWCCFC18SIG00_ARRAY buildEdHist_array_err() {
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_add(2, ERROR_ACTION, IN_STATE, 5000001));
    return rowccfc18sig00_array;
  }

  private ROWCCFC18SIG00_ARRAY buildEdHist_array_updt(int id_edHist, String dataAction, String schoolLoc,
                                                      int id_res, Date dtLastUpdate) {
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_updt(id_edHist, dataAction, schoolLoc, id_res, dtLastUpdate));
    return rowccfc18sig00_array;
  }

  private ROWCCFC18SIG00_ARRAY buildEdHist_array_del(int id_edHist, String dataAction, String schoolLoc,
                                                     int id_res, Date dtLastUpdate) {
    ROWCCFC18SIG00_ARRAY rowccfc18sig00_array = new ROWCCFC18SIG00_ARRAY();
    rowccfc18sig00_array.addROWCCFC18SIG00(buildEdHist_del(id_edHist, dataAction, schoolLoc, id_res, dtLastUpdate));
    return rowccfc18sig00_array;
  }

  ROWCCFC18SIG00 buildEdHist_add(int id_edHist, String dataAction, String schoolLoc, int id_res) {
    ROWCCFC18SIG00 rowccfc18sig00 = new ROWCCFC18SIG00();
    rowccfc18sig00.setTsLastUpdate(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    rowccfc18sig00.setUlIdEdhist(id_edHist);
    rowccfc18sig00.setSzCdScrDataAction(dataAction);
    rowccfc18sig00.setDtDtEdhistEnrollDate(DateHelper.getTodayCastorDate());
    rowccfc18sig00.setDtDtEdhistWithdrawnDate(DateHelper.getTodayCastorDate());
    rowccfc18sig00.setCIndEdhistTeaSchool(schoolLoc);
    rowccfc18sig00.setSzAddrEdhistCity("Atlanta");
    rowccfc18sig00.setSzAddrEdhistCnty("FULTON");
    rowccfc18sig00.setSzAddrEdhistState("GA");
    rowccfc18sig00.setSzAddrEdhistStreetLn1("75 Peachtree st.");
    rowccfc18sig00.setSzAddrEdhistStreetLn2("suite's hello");
    rowccfc18sig00.setSzAddrEdhistZip("30090");
    rowccfc18sig00.setSzNbrEdhistPhone("4045555551");
    rowccfc18sig00.setSzNbrEdhistPhoneExt("543");
    rowccfc18sig00.setSzTxtEdhistAddrCmnt("fake address");
    rowccfc18sig00.setSzCdEdhistEnrollGrade("jr");
    rowccfc18sig00.setSzCdEdhistWithdrawnGrade("sr");
    rowccfc18sig00.setSzCdEdhistNeeds1(CodesTables.CEDUCNED_ONC);
    rowccfc18sig00.setSzCdEdhistNeeds2(CodesTables.CEDUCNED_REG);
    rowccfc18sig00.setSzCdEdhistNeeds3(CodesTables.CEDUCNED_RES);
    rowccfc18sig00.setSzCdEdhistNeeds4(CodesTables.CEDUCNED_SPE);
    rowccfc18sig00.setSzCdEdhistNeeds5(CodesTables.CEDUCNED_VOC);
    rowccfc18sig00.setSzCdEdhistNeeds6(CodesTables.CEDUCNED_XXX);
    rowccfc18sig00.setSzCdEdhistNeeds7(null);
    rowccfc18sig00.setSzCdEdhistNeeds8("");
    rowccfc18sig00.setSzNmEdhistSchool("Needs");
    rowccfc18sig00.setSzNmEdhistSchDist("3rd");
    rowccfc18sig00.setUlIdResource(id_res);

    return rowccfc18sig00;
  }

  private ROWCCFC18SIG00 buildEdHist_updt(int id_edHist, String dataAction, String schoolLoc,
                                          int id_res, Date dtLastUpdate) {
    ROWCCFC18SIG00 rowccfc18sig00 = new ROWCCFC18SIG00();
    rowccfc18sig00.setTsLastUpdate(dtLastUpdate);
    rowccfc18sig00.setUlIdEdhist(id_edHist);
    rowccfc18sig00.setSzCdScrDataAction(dataAction);
    rowccfc18sig00.setDtDtEdhistEnrollDate(DateHelper.getTodayCastorDate());
    rowccfc18sig00.setDtDtEdhistWithdrawnDate(DateHelper.getTodayCastorDate());
    rowccfc18sig00.setCIndEdhistTeaSchool(schoolLoc);
    rowccfc18sig00.setSzAddrEdhistCity("Marietta");
    rowccfc18sig00.setSzAddrEdhistCnty("COBB");
    rowccfc18sig00.setSzAddrEdhistState("GA");
    rowccfc18sig00.setSzAddrEdhistStreetLn1("75 Peachtree st.");
    rowccfc18sig00.setSzAddrEdhistStreetLn2("suite's hello");
    rowccfc18sig00.setSzAddrEdhistZip("30080");
    rowccfc18sig00.setSzNbrEdhistPhone("7705555551");
    rowccfc18sig00.setSzNbrEdhistPhoneExt("543");
    rowccfc18sig00.setSzTxtEdhistAddrCmnt("fake address");
    rowccfc18sig00.setSzCdEdhistEnrollGrade("jr");
    rowccfc18sig00.setSzCdEdhistWithdrawnGrade("sr");
    rowccfc18sig00.setSzCdEdhistNeeds1(CodesTables.CEDUCNED_ONC);
    rowccfc18sig00.setSzCdEdhistNeeds2(CodesTables.CEDUCNED_REG);
    rowccfc18sig00.setSzCdEdhistNeeds3(CodesTables.CEDUCNED_RES);
    rowccfc18sig00.setSzCdEdhistNeeds4(CodesTables.CEDUCNED_SPE);
    rowccfc18sig00.setSzCdEdhistNeeds5(CodesTables.CEDUCNED_VOC);
    rowccfc18sig00.setSzCdEdhistNeeds6(CodesTables.CEDUCNED_XXX);
    rowccfc18sig00.setSzCdEdhistNeeds7(null);
    rowccfc18sig00.setSzCdEdhistNeeds8("");
    rowccfc18sig00.setSzNmEdhistSchool("Needs");
    rowccfc18sig00.setUlIdResource(id_res);
    rowccfc18sig00.setSzNmEdhistSchDist("3rd");

    return rowccfc18sig00;
  }

  private ROWCCFC18SIG00 buildEdHist_del(int id_edHist, String dataAction, String schoolLoc, int id_res,
                                         Date dtLastUpdate) {
    return buildEdHist_updt(id_edHist, dataAction, schoolLoc, id_res, dtLastUpdate);
  }
}
