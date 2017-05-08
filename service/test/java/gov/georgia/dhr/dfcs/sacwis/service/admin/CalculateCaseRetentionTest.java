package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CalculateCaseRetention;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC51UI;

public class CalculateCaseRetentionTest extends BaseServiceTest {
  protected CalculateCaseRetention calculateCaseRetention = null;

  public CalculateCaseRetentionTest(String testName) {
    super(testName);
  }

  public void setCalculateCaseRetention(CalculateCaseRetention calculateCaseRetention) {
    this.calculateCaseRetention = calculateCaseRetention;
  }

  protected void onSetUpInTransaction() throws Exception {
    jdbcTemplate.update("UPDATE STAGE " + "SET CD_STAGE_REASON_CLOSED = '000', CD_STAGE_PROGRAM = 'APS' "
                        + "WHERE ID_CASE = 10335 " + "AND ID_STAGE = 670");
    jdbcTemplate.update("UPDATE STAGE " + "SET CD_STAGE_REASON_CLOSED = '000', CD_STAGE_PROGRAM = 'APS' "
                        + "WHERE ID_CASE = 10002 " + "AND ID_STAGE = 4");
    jdbcTemplate.update("INSERT INTO ADMIN_REVIEW (ID_CASE, " + "                                 DT_LAST_UPDATE, "
                        + "                                 ID_EVENT, "
                        + "                                 ID_STAGE, ID_STAGE_RELATED)"
                        + "                         VALUES (?, ?, ?, ?, ?)", new Object[] {
                                                                                           10002,
                                                                                           new GregorianCalendar(2006,
                                                                                                                 6, 6,
                                                                                                                 0, 0,
                                                                                                                 0),
                                                                                           5627565, 4, 4 });
    jdbcTemplate.update("UPDATE STAGE " + "SET CD_STAGE_REASON_CLOSED = '000', CD_STAGE_PROGRAM = 'AFC' "
                        + "WHERE ID_CASE = 10003 " + "AND ID_STAGE = 6");
    jdbcTemplate.update("INSERT INTO ADMIN_REVIEW (ID_CASE, " + "                                 DT_LAST_UPDATE, "
                        + "                                 ID_EVENT, "
                        + "                                 ID_STAGE, ID_STAGE_RELATED)"
                        + "                         VALUES (?, ?, ?, ?, ?)", new Object[] {
                                                                                           10003,
                                                                                           new GregorianCalendar(2006,
                                                                                                                 6, 6,
                                                                                                                 0, 0,
                                                                                                                 0),
                                                                                           5627604, 6, 6 });
    jdbcTemplate.update("UPDATE STAGE " + "SET CD_STAGE = 'ADO' " + "WHERE ID_CASE = 5000000 "
                        + "AND ID_STAGE = 5000000");

  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_NULL_CASE"));
    // suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_NULL_STAGE"));
    suite.addTest(new CalculateCaseRetentionTest("testCodeSetFlagIsFalse1_RO"));
    suite.addTest(new CalculateCaseRetentionTest("testCodeSetFlagIsFalse2_NotRO"));
    suite.addTest(new CalculateCaseRetentionTest("testCodeSetFlagIsFalse3_APS"));
    suite.addTest(new CalculateCaseRetentionTest("testCodeSetFlagIsFalse4_APS"));
    suite.addTest(new CalculateCaseRetentionTest("testCodeSetFlagIsFalse5_AFC"));
    suite.addTest(new CalculateCaseRetentionTest("testCodeSetFlagIsFalse6_CCL"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_INV1"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_INV2"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_INV3"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_FPR"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_SVC_APS"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_AOC_APS"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_FRE"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_ADO"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_FAD_Foster"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_FAD_Else"));
    suite.addTest(new CalculateCaseRetentionTest("testRecordsRetention_PAD"));

    return suite;
  }

  public void testRecordsRetention_NULL_CASE() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(0);

    try {
      calculateCaseRetention.recordsRetention(ccfc51ui);
      fail("Expected Service Exception MSG_DETAIL_DELETED");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_DETAIL_DELETED) {
        throw e;
      }
    }
  }

  // exsiting case that has no stage
  public void testRecordsRetention_NULL_STAGE() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(10001);

    try {
      calculateCaseRetention.recordsRetention(ccfc51ui);
      fail("Expected Service Exception MSG_DETAIL_DELETED");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_DETAIL_DELETED) {
        throw e;
      }
    }
  }

  // test first if (!bCodeSetFlag)
  public void testCodeSetFlagIsFalse1_RO() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5600338);
    try {
      calculateCaseRetention.recordsRetention(ccfc51ui);
      fail("Expected Service Exception MSG_DETAIL_DELETED");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_DETAIL_DELETED) {
        throw e;
      }
    }
  }

  // test second if (!bCodeSetFlag), FRE too
  public void testCodeSetFlagIsFalse2_NotRO() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5606181);
    try {
      calculateCaseRetention.recordsRetention(ccfc51ui);
      fail("Expected Service Exception MSG_DETAIL_DELETED");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_DETAIL_DELETED) {
        throw e;
      }
    }
  }

  // test THIRD if (!bCodeSetFlag), use setup data
  public void testCodeSetFlagIsFalse3_APS() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(10335);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testCodeSetFlagIsFalse4_APS() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(10002);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testCodeSetFlagIsFalse5_AFC() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(10003);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  // riskAssessmentDAO.countRiskAssessment(NO_SIGNIFICANT_RISK_FACTORS, idStage) > 0: true
  // bCodeSetFlag <- T
  public void testRecordsRetention_INV1() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5600569);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  // if (riskAssessmentDAO.countRiskAssessment(FACTORS_CONTROLLED, idStage) > 0) > 0: true
  // bCodeSetFlag <- T
  public void testRecordsRetention_INV2() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5606178);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  // if (riskAssessmentDAO.countRiskAssessment(RISK_ASSESSMENT_NA, idStage) > 0): true
  // bCodeSetFlag <- T
  public void testRecordsRetention_INV3() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5606120);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  // test updateCaseRetentionInfoForFamilyPreservationStages - didnot call
  // caseRetentionInfo.getDtLastStageClosed() need not null
  // 
  public void testRecordsRetention_FPR() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5600037);
    try {
      calculateCaseRetention.recordsRetention(ccfc51ui);
      fail("Expected Service Exception MSG_DETAIL_DELETED");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_DETAIL_DELETED) {
        throw e;
      }
    }
  }

  // test updateCaseRetentionInfoForAPSServiceDeliveryStages(idCase, caseRetentionInfo) - done
  public void testRecordsRetention_SVC_APS() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5600532);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testRecordsRetention_AOC_APS() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    // ccfc51ui.setUlIdCase(5600532);
    ccfc51ui.setUlIdCase(5600062);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testRecordsRetention_FRE() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5600034);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testRecordsRetention_ADO() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    // ccfc51ui.setUlIdCase(5600030); start with int, inv and throw
    ccfc51ui.setUlIdCase(5000000);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testRecordsRetention_FAD_Foster() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5000002);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testRecordsRetention_FAD_Else() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5500014);
    calculateCaseRetention.recordsRetention(ccfc51ui);
  }

  public void testRecordsRetention_PAD() {
    CCFC51UI ccfc51ui = new CCFC51UI();
    ccfc51ui.setUlIdCase(5605029);
    try {
      calculateCaseRetention.recordsRetention(ccfc51ui);
      fail("Expected Service Exception MSG_DETAIL_DELETED");
    } catch (ServiceException e) {
      if (e.getErrorCode() != Messages.MSG_DETAIL_DELETED) {
        throw e;
      }
    }
  }

}
