package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CloseStageCaseTest extends BaseServiceTest {
  public static final String SPC_STAGE = CodesTables.CSTAGES_SPC;

  public static final String INR_STAGE = CodesTables.CSTAGES_IR;

  public static final String HISTORICAL_PRIMARY = "HP";

  public static final String EVENT_STATUS = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_TYPE = CodesTables.CEVNTTYP_STG;

  public static final String SPC_EVENT_DESC = "SPC Stage Closed";

  public static final String INR_EVENT_DESC = "I&R Stage Closed";

  public static final String CASE_EVENT_DESC = "Case Closed";

  public static final String CASE_CLOSURE_EVENT = CodesTables.CEVNTTYP_CAS;

  public static final String PERSON_ROLE_BOTH = CodesTables.CINVROLE_VC;

  public static final String PERSON_ROLE_VICTIM = CodesTables.CINVROLE_VP;

  public static final String PERSON_ROLE_CLIENT = CodesTables.CINVROLE_CL;

  public static final String APS_PROGRAM = CodesTables.CPGRMS_APS;

  public static final String AFC_PROGRAM = CodesTables.CPGRMS_AFC;

  public static final String INVESTIGATION = CodesTables.CSTAGES_INV;

  public static final String HYPHEN = " - ";

  public static final String CPS_PROGRAM = CodesTables.CPGRMS_CPS;

  public static final String SERVICE_AUTH_TYPE = CodesTables.CEVNTTYP_AUT;

  public static final String FSU_PROGRAM = CodesTables.CSTAGES_FSU;

  public static final String SVC_AUTH_CD_TASK = "2310";

  public static final String FSU_SVC_AUTH_TASK = "4190";

  public static final String EMPTY_STR = "";

  public static final String CD_INACTIVE = "I";

  public static final String STAFF = "STF";

  public static final String ARI_STAGE = CodesTables.CSTAGES_ARI;

  public static final String POST_ADOPT = CodesTables.CSTAGES_PAD;

  public static final String SUBCARE = CodesTables.CSTAGES_SUB;

  public static final String PREP_ADULT = CodesTables.CSTAGES_PAL;

  public static final String FPR_PROGRAM = CodesTables.CSTAGES_FPR;

  public static final String FRE_PROGRAM = CodesTables.CSTAGES_FRE;

  public static final String ADOPTION = CodesTables.CSTAGES_ADO;

  public static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  public static final String FPR_SVC_AUTH_TASK = "7100";

  public static final String FRE_SVC_AUTH_TASK = "5640";

  public static final String ADO_SVC_AUTH_TASK = "8530";

  public static final String SUB_SVC_AUTH_TASK = "3020";

  public static final String ADOPTION_DISRUPT = "020";

  public static final String PRIMARY_CHILD = "PC";

  public static final String CPS_ADMIN_REVIEW = "ARI";

  public static final String ALLEG_RULED_OUT = "R/O";

  public static final String ADMIN_REVIEW_YES = ArchitectureConstants.Y;

  public static final String ADMIN_REVIEW_NO = ArchitectureConstants.N;

  public static final String STARS = "S";

  public static final String CAPS = "C";

  public static final String BOTH = "B";

  public static final String BOTH_NULL = "3";

  public static final String UPDATE_DENY_DATE = "4";

  public static final String UPDATE_DENY_OPEN_CLOSE = "5";

  public static final String FORMER_DAY_CARE = "40M";

  private static final int EVENT_DESCR_LENGTH = 80;

  protected CloseStageCase closeStageCase = null;

  public CloseStageCaseTest(String testName) {
    super(testName);
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  protected void onSetUpInTransaction() throws Exception {
    super.onSetUpInTransaction();
    jdbcTemplate.update("UPDATE STAGE " + "SET DT_STAGE_CLOSE = NULL " + "WHERE ID_CASE = 5606146 "
                        + "AND ID_STAGE = 5604035");
    jdbcTemplate.update("UPDATE STAGE_PERSON_LINK " + "SET CD_STAGE_PERS_ROLE = 'PR' " + "WHERE ID_PERSON = 4245 "
                        + "AND ID_STAGE = 5604035");
    jdbcTemplate.update("UPDATE STAGE " + "SET CD_STAGE = 'SPC' " + "WHERE CD_STAGE = 'I&R' "
                        + "AND ID_STAGE = 5603607 " + "AND CD_STAGE_PROGRAM = 'PRS' "
                        + "AND CD_STAGE_REASON_CLOSED = '01'");

    /*int idStageProg = getSequenceNextval("SEQ_STAGE_PROG");
    jdbcTemplate.update("INSERT INTO STAGE_PROG (ID_STAGE_PROG, " + " DT_LAST_UPDATE, " + " CD_STAGE_PROG_PROGRAM, "
                        + " CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE)" + " VALUES (?, ?, ?, ?, ?)",
                        new Object[] { idStageProg, new GregorianCalendar(2006, 6, 12, 0, 0, 0), "PRS", "SPC", "01" });

*/    
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new CloseStageCaseTest("testStageINV_RsnCls"));
    suite.addTest(new CloseStageCaseTest("testStageARI_CPS_INV"));
    suite.addTest(new CloseStageCaseTest("testStageARI_CPS_INV_020"));
    suite.addTest(new CloseStageCaseTest("testStageSUB"));
    suite.addTest(new CloseStageCaseTest("testStage_PE"));
    suite.addTest(new CloseStageCaseTest("testCaseClosed"));
    suite.addTest(new CloseStageCaseTest("testCloseStageCase_IR_PROG_STAGE"));
    suite.addTest(new CloseStageCaseTest("testCloseStageCase_APS_PROG_STAGE"));
    suite.addTest(new CloseStageCaseTest("testCloseStageCase_APS_PROG_STAGE2"));

    return suite;
  }

  public void testStageINV_RsnCls() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02uiG00 = new CCMN02UIG00();
    ccmn02uiG00.setUlIdStage(240);
    ccmn02uiG00.setSzCdStage("INV");
    ccmn02uiG00.setSzCdStageProgram("CPS");
    ccmn02uiG00.setSzCdStageReasonClosed("64");
    // ccmn02uiG00.setUlIdPerson(5172);
    ccmn02uiG00.setUlIdPerson(4012273);
    ccmn02ui.setCCMN02UIG00(ccmn02uiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }

  public void testStageARI_CPS_INV() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02uiG00 = new CCMN02UIG00();
    ccmn02uiG00.setUlIdStage(5604035);
    ccmn02uiG00.setSzCdStage("ARI");
    ccmn02uiG00.setSzCdStageProgram("CPS");
    ccmn02uiG00.setSzCdStageReasonClosed("020");
    ccmn02uiG00.setUlIdPerson(4245);
    ccmn02ui.setCCMN02UIG00(ccmn02uiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }

  public void testStageSUB() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02uiG00 = new CCMN02UIG00();
    ccmn02uiG00.setUlIdStage(5600109);
    ccmn02uiG00.setSzCdStage("SUB");
    ccmn02uiG00.setSzCdStageProgram("CPS");
    ccmn02uiG00.setSzCdStageReasonClosed("10");
    ccmn02uiG00.setUlIdPerson(4245);
    ccmn02ui.setCCMN02UIG00(ccmn02uiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }

  // csec29d
  public void testStageARI_CPS_INV_020() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02uiG00 = new CCMN02UIG00();
    ccmn02uiG00.setUlIdStage(5604035);
    ccmn02uiG00.setSzCdStage("ADO");
    ccmn02uiG00.setSzCdStageProgram("CPS");
    ccmn02uiG00.setSzCdStageReasonClosed("020");
    ccmn02uiG00.setUlIdPerson(4245);
    ccmn02ui.setCCMN02UIG00(ccmn02uiG00);
    try {
      closeStageCase.closeStageCase(ccmn02ui);
      fail("Expected ServiceException with Messages.SQL_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
    }
  }

  // test PersonEligibilityDAO, last page of res
  public void testStage_PE() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02uiG00 = new CCMN02UIG00();
    ccmn02uiG00.setUlIdStage(5604199);
    ccmn02uiG00.setSzCdStage("INT");
    ccmn02uiG00.setSzCdStageProgram("CPS");
    ccmn02uiG00.setSzCdStageReasonClosed("01");
    ccmn02uiG00.setUlIdPerson(5607205);
    ccmn02ui.setCCMN02UIG00(ccmn02uiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }

  public void testCaseClosed() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02UiG00 = new CCMN02UIG00();
    ccmn02UiG00.setUlIdStage(5600566);
    ccmn02UiG00.setSzCdStage(SPC_STAGE);
    ccmn02ui.setCCMN02UIG00(ccmn02UiG00);
    try {
      closeStageCase.closeStageCase(ccmn02ui);
      fail("Expected ServiceException with Messages.MSG_CMN_STAGE_CLOSED.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.MSG_CMN_STAGE_CLOSED) {
        throw se;
      }
    }
  }

  public void testCloseStageCase_IR_PROG_STAGE() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02UiG00 = new CCMN02UIG00();
    ccmn02UiG00.setUlIdStage(5603607);
    ccmn02UiG00.setSzCdStage(INR_STAGE);
    ccmn02UiG00.setSzCdStageProgram("PRS");
    ccmn02UiG00.setSzCdStageReasonClosed("01");
    ccmn02UiG00.setUlIdPerson(5380);
    ccmn02ui.setCCMN02UIG00(ccmn02UiG00);
    try {
      closeStageCase.closeStageCase(ccmn02ui);
      fail("Expected ServiceException with Messages.SQL_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
    }
  }

  public void testCloseStageCase_APS_PROG_STAGE() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02UiG00 = new CCMN02UIG00();
    ccmn02UiG00.setUlIdStage(5600161);
    ccmn02UiG00.setSzCdStage("SVC");
    ccmn02UiG00.setSzCdStageProgram("APS");
    ccmn02UiG00.setSzCdStageReasonClosed("90");
    ccmn02UiG00.setUlIdPerson(1);
    ccmn02ui.setCCMN02UIG00(ccmn02UiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }

  public void testCloseStageCase_APS_PROG_STAGE2() {
    CCMN02UI ccmn02ui = new CCMN02UI();
    CCMN02UIG00 ccmn02UiG00 = new CCMN02UIG00();
    ccmn02UiG00.setUlIdStage(5600094);
    ccmn02UiG00.setSzCdStage("INT");
    ccmn02UiG00.setSzCdStageProgram("RCL");
    ccmn02UiG00.setSzCdStageReasonClosed("105");
    ccmn02UiG00.setUlIdPerson(15);
    ccmn02ui.setCCMN02UIG00(ccmn02UiG00);
    closeStageCase.closeStageCase(ccmn02ui);
  }
}
