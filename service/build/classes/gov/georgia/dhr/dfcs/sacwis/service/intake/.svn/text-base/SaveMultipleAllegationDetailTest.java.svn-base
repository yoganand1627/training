package gov.georgia.dhr.dfcs.sacwis.service.intake;

import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveMultipleAllegationDetailTest extends BaseServiceTest {

  protected SaveMultipleAllegationDetail saveMultipleAllegationDetail = null;

  private static final String CD_STAGE_ADMIN = "ADM";

  private static final String CASE_MERGED_IN_ERROR = CodesTables.CDISPSTN_ZZZ;

  private static final String APS = CodesTables.CCONPROG_APS;

  private static final String CPS = CodesTables.CCONPROG_CPS;

  private static final String COMMUNITY_LIC = CodesTables.CPGRMS_CCL;

  protected void onSetUpInTransaction() throws Exception {
    super.onSetUpInTransaction();
    // jdbcTemplate.update("UPDATE TASK SET IND_TASK_MULTIPLE_INSTANCE=0 WHERE CD_TASK = '3020'");
  }

  public SaveMultipleAllegationDetailTest(String testName) {
    super(testName);
  }

  public void setSaveMultipleAllegationDetail(SaveMultipleAllegationDetail saveMultipleAllegationDetail) {
    this.saveMultipleAllegationDetail = saveMultipleAllegationDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveMultipleAllegationDetailTest("testSaveMultipleAllegationDetailAdd_CD_STAGE_ADMIN"));
    suite.addTest(new SaveMultipleAllegationDetailTest("testSaveMultipleAllegationDetailAdd_NOT_CD_STAGE_ADMIN"));
    suite
         .addTest(new SaveMultipleAllegationDetailTest("testSaveMultipleAllegationDetailUpdate_NOT_CD_STAGE_ADMIN_APS"));
    suite
         .addTest(new SaveMultipleAllegationDetailTest("testSaveMultipleAllegationDetailUpdate_NOT_CD_STAGE_ADMIN_CPS"));
    suite
         .addTest(new SaveMultipleAllegationDetailTest("testSaveMultipleAllegationDetailUpdate_NOT_CD_STAGE_ADMIN_LIC"));
    suite.addTest(new SaveMultipleAllegationDetailTest("testSaveMultipleAllegationDetailUpdate_InvalidData"));

    return suite;
  }

  public void testSaveMultipleAllegationDetailAdd_CD_STAGE_ADMIN() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(5600996);
    cinv09si.setSzCdTask("3020");
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    cinv09si.setArchInputStruct(archInputStruct);
    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();

    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 10, 9, 47).getTime();
    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    try {
      saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);

      fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }

    }

  }

  public void testSaveMultipleAllegationDetailAdd_NOT_CD_STAGE_ADMIN() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(5600996);
    cinv09si.setSzCdTask("3020");
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    cinv09si.setArchInputStruct(archInputStruct);
    cinv09si.setSzCdStage("NOT" + CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();

    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 10, 9, 47).getTime();

    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    try {
      saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);

      fail("Expected an exception with Messages.EXPECTED_CODE.");

    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    // findIncomingPerson

  }

  public void testSaveMultipleAllegationDetailUpdate1_CD_STAGE_ADMIN() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(5600996);
    cinv09si.setSzCdTask("3020");
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cinv09si.setArchInputStruct(archInputStruct);
    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();
    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    try {
      saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);

    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void testSaveMultipleAllegationDetailUpdate_NOT_CD_STAGE_ADMIN_APS() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(5600002);
    cinv09si.setSzCdTask("3020");
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cinv09si.setArchInputStruct(archInputStruct);
    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();

    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    cinv09si.setSzCdStage("NOT" + CD_STAGE_ADMIN);

    cinv09si.setSzCdStageProgram(APS);
    try {
      saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);

    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }

    }
  }

  public void testSaveMultipleAllegationDetailUpdate_NOT_CD_STAGE_ADMIN_LIC() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(5600996);
    cinv09si.setSzCdTask("3020");
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cinv09si.setArchInputStruct(archInputStruct);

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();

    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    cinv09si.setSzCdStage("NOT" + CD_STAGE_ADMIN);

    cinv09si.setSzCdStageProgram(COMMUNITY_LIC);

    saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);

  }

  public void testSaveMultipleAllegationDetailUpdate_NOT_CD_STAGE_ADMIN_CPS() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(5603672);
    cinv09si.setSzCdTask("3020");
    cinv09si.setUlIdEvent(2496);

    ArchInputStruct archInputStruct = new ArchInputStruct();

    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.N);
    cinv09si.setArchInputStruct(archInputStruct);
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    // ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cinv09si.setArchInputStruct(archInputStruct);

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();

    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    cinv09si.setSzCdStage("NOT" + CD_STAGE_ADMIN);

    cinv09si.setSzCdStageProgram(CPS);

    saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);

  }

  public void testSaveMultipleAllegationDetailUpdate_InvalidData() {

    CINV09SI cinv09si = new CINV09SI();
    cinv09si.setUlIdStage(0);
    cinv09si.setSzCdTask("9999");
    cinv09si.setUlIdEvent(0);

    ArchInputStruct archInputStruct = new ArchInputStruct();

    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.N);
    cinv09si.setArchInputStruct(archInputStruct);
    // ===========================Start of NOT CD_STAGE_ADMIN=======================================

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    // ====================================ServiceConstants.REQ_FUNC_CD_ADD===========================
    // ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cinv09si.setArchInputStruct(archInputStruct);

    cinv09si.setSzCdStage(CD_STAGE_ADMIN);

    CdAllegDisposition_ARRAY cdAllegDisposition_ARRAY = new CdAllegDisposition_ARRAY();

    cdAllegDisposition_ARRAY.addCdAllegDisposition(CASE_MERGED_IN_ERROR);

    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();

    CINV09SIG cinv09sig = new CINV09SIG();

    java.util.Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv09sig.setTsLastUpdate(dtLastUpdate);
    cinv09sig.setUlIdAllegation(318);

    cinv09sig_array.addCINV09SIG(cinv09sig);

    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);
    cinv09si.setCdAllegDisposition_ARRAY(cdAllegDisposition_ARRAY);

    cinv09si.setSzCdStage("NOT" + CD_STAGE_ADMIN);

    cinv09si.setSzCdStageProgram(CPS);
    try {

      saveMultipleAllegationDetail.saveMultipleAllegationDetail(cinv09si);
      fail("Expected an exception with Messages.EXPECTED_CODE.");

    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }
    }
  }
}
