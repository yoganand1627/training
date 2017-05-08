package gov.georgia.dhr.dfcs.sacwis.service.intake;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG;

public class SaveAllegationDetailTest extends BaseServiceTest {

  protected SaveAllegationDetail saveAllegationDetail = null;

  public SaveAllegationDetailTest(String testName) {
    super(testName);
  }

  protected void onSetUpInTransaction() throws Exception {
    super.onSetUpInTransaction();
    jdbcTemplate.update("UPDATE CASE_MERGE SET IND_CASE_MERGE_INVALID='Y' WHERE ID_CASE_MERGE = 5600000");
    jdbcTemplate
                .update("Insert into ALLEGATION (ID_ALLEGATION,DT_LAST_UPDATE, ID_ALLEGATION_STAGE, ID_VICTIM, ID_ALLEGED_PERPETRATOR, ID_CASE, CD_ALLEG_INCIDENT_STAGE, CD_ALLEG_TYPE, CD_ALLEG_DISPOSITION, CD_ALLEG_SEVERITY)  Values ( SEQ_ALLEGATION.NEXTVAL,TO_DATE('02/07/2003 22:09:47', 'MM/DD/YYYY HH24:MI:SS'), 240, 4012273,5172, 10120, 'INT', 'PHAB', 'RTB', 'MD')");

    jdbcTemplate
                .update("Insert into ALLEGATION (ID_ALLEGATION,DT_LAST_UPDATE, ID_ALLEGATION_STAGE, ID_VICTIM, ID_ALLEGED_PERPETRATOR, ID_CASE, CD_ALLEG_INCIDENT_STAGE, CD_ALLEG_TYPE, CD_ALLEG_DISPOSITION, CD_ALLEG_SEVERITY)  Values ( SEQ_ALLEGATION.NEXTVAL,TO_DATE('02/07/2003 22:09:47', 'MM/DD/YYYY HH24:MI:SS'), 240, 4012273,5172, 10120, 'INT', 'PHAB', 'RTB', 'MD')");

    jdbcTemplate
                .update("Insert into APS_INVST_DETAIL (DT_LAST_UPDATE, ID_EVENT, ID_APS_STAGE, ID_CASE, DT_APS_INVST_BEGUN) Values (TO_DATE('06/29/2005 16:31:06', 'MM/DD/YYYY HH24:MI:SS'), 5600679, 240, 5600000, TO_DATE('07/13/1996 00:00:00', 'MM/DD/YYYY HH24:MI:SS'))");

    jdbcTemplate
                .update("Insert into LICENSING_INVST_DTL  (DT_LAST_UPDATE, ID_EVENT, ID_CASE, ID_LICNG_INVST_STAGE, DT_LICNG_INVST_INTAKE, DT_LICNG_INVST_ASSIGNED, DT_LICNG_INVST_BEGUN)   Values  (TO_DATE('08/17/1998 09:36:15', 'MM/DD/YYYY HH24:MI:SS'), 5600679, 5600485, 240, TO_DATE('08/17/1998 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('08/17/1998 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), TO_DATE('08/17/1998 00:00:00', 'MM/DD/YYYY HH24:MI:SS'))");

  }

  public void setRetrieveUserProfile(SaveAllegationDetail saveAllegationDetail) {
    this.saveAllegationDetail = saveAllegationDetail;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_Add"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_Update"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_Delete_NOT_INTAKE"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_Delete_INTAKE_APS"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_Delete_INTAKE_RCL"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_Delete_INTAKE_CPS"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_ARC_ERR_BAD_FUNC_CD"));
    suite.addTest(new SaveAllegationDetailTest("testSaveAllegationDetail_InvalidData"));
    return suite;
  }

  public void testSaveAllegationDetail_Add() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("VC");
    cinv47sig.setUlIdVictim(1186);
    cinv47sig.setUlIdStage(354);
    cinv47sig.setSzCdAllegType("PHAB");

    cinv47si.setCdAllegDisposition(CodesTables.CDISPSTN_ZZZ);

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.N);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate);

    cinv47si.setCINV47SIG(cinv47sig);

    // cinv47si.setUlIdEvent(5600679);
    cinv47si.setUlIdEvent(5500006);

    saveAllegationDetail.saveAllegDtl(cinv47si);

  }

  public void testSaveAllegationDetail_Update() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("DV");
    cinv47sig.setUlIdVictim(4012273);
    cinv47sig.setUlIdStage(240);
    cinv47sig.setSzCdAllegType("PHAB");

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate);

    cinv47si.setCINV47SIG(cinv47sig);

    saveAllegationDetail.saveAllegDtl(cinv47si);

  }

  public void testSaveAllegationDetail_Delete_NOT_INTAKE() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("DV");
    cinv47sig.setUlIdVictim(4012273);
    cinv47sig.setUlIdStage(240);
    cinv47sig.setSzCdAllegType("PHAB");
    cinv47sig.setUlIdAllegation(120);
    cinv47sig.setUlIdAllegedPerpetrator(5172);

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv47sig.setTsLastUpdate(dtLastUpdate);
    Date dtLastUpdate4 = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate4);

    Date dtLastUpdate3 = new GregorianCalendar(2003, 1, 7, 22, 9, 45).getTime();
    cinv47sig.setTsSysTsLastUpdate3(dtLastUpdate3);

    cinv47si.setCINV47SIG(cinv47sig);

    saveAllegationDetail.saveAllegDtl(cinv47si);

  }

  public void testSaveAllegationDetail_Delete_INTAKE_APS() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("DV");
    cinv47sig.setUlIdVictim(4012273);
    cinv47sig.setUlIdStage(240);
    // cinv47sig.setUlIdStage(5600002);
    cinv47sig.setSzCdAllegType("PHAB");
    cinv47sig.setUlIdAllegation(120);
    cinv47sig.setUlIdAllegedPerpetrator(5172);
    cinv47sig.setSzCdAllegIncidentStage("INT");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv47sig.setTsLastUpdate(dtLastUpdate);
    Date dtLastUpdate4 = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate4);

    Date dtLastUpdate3 = new GregorianCalendar(2003, 1, 7, 22, 9, 45).getTime();
    cinv47sig.setTsSysTsLastUpdate3(dtLastUpdate3);
    cinv47sig.setCdAllegDisposition("RTB");

    cinv47si.setSzCdStageProgram(CodesTables.CSRPGTYP_APS);
    cinv47si.setCINV47SIG(cinv47sig);

    saveAllegationDetail.saveAllegDtl(cinv47si);

  }

  public void testSaveAllegationDetail_Delete_INTAKE_RCL() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("DV");
    cinv47sig.setUlIdVictim(4012273);
    cinv47sig.setUlIdStage(240);
    // cinv47sig.setUlIdStage(5600002);
    cinv47sig.setSzCdAllegType("PHAB");
    cinv47sig.setUlIdAllegation(120);
    cinv47sig.setUlIdAllegedPerpetrator(5172);
    cinv47sig.setSzCdAllegIncidentStage("INT");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv47sig.setTsLastUpdate(dtLastUpdate);
    Date dtLastUpdate4 = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate4);

    Date dtLastUpdate3 = new GregorianCalendar(2003, 1, 7, 22, 9, 45).getTime();
    cinv47sig.setTsSysTsLastUpdate3(dtLastUpdate3);
    cinv47sig.setCdAllegDisposition("RTB");
    cinv47si.setSzCdStageProgram(CodesTables.CSRPGTYP_RCL);
    cinv47si.setCINV47SIG(cinv47sig);

    saveAllegationDetail.saveAllegDtl(cinv47si);

  }

  public void testSaveAllegationDetail_Delete_INTAKE_CPS() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("DV");
    cinv47sig.setUlIdVictim(4012273);
    cinv47sig.setUlIdStage(240);
    cinv47sig.setSzCdAllegType("PHAB");
    cinv47sig.setUlIdAllegation(120);
    cinv47sig.setUlIdAllegedPerpetrator(5172);
    cinv47sig.setSzCdAllegIncidentStage("INT");
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(2003, 1, 7, 22, 9, 47).getTime();
    cinv47sig.setTsLastUpdate(dtLastUpdate);
    Date dtLastUpdate4 = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate4);

    Date dtLastUpdate3 = new GregorianCalendar(2003, 1, 7, 22, 9, 45).getTime();
    cinv47sig.setTsSysTsLastUpdate3(dtLastUpdate3);
    cinv47sig.setCdAllegDisposition("RTB");
    cinv47si.setSzCdStageProgram(CodesTables.CSRPGTYP_CPS);
    cinv47si.setCINV47SIG(cinv47sig);

    saveAllegationDetail.saveAllegDtl(cinv47si);

  }

  public void testSaveAllegationDetail_ARC_ERR_BAD_FUNC_CD() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("VC");
    cinv47sig.setUlIdVictim(1186);
    cinv47sig.setUlIdStage(354);
    cinv47sig.setSzCdAllegType("PHAB");

    cinv47si.setCdAllegDisposition(CodesTables.CDISPSTN_ZZZ);

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.N);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate);

    cinv47si.setCINV47SIG(cinv47sig);

    // cinv47si.setUlIdEvent(5600679);
    cinv47si.setUlIdEvent(5500006);

    try {
      saveAllegationDetail.saveAllegDtl(cinv47si);
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD) {
        throw se;
      }

    }

  }

  public void testSaveAllegationDetail_InvalidData() {

    CINV47SI cinv47si = new CINV47SI();
    CINV47SIG cinv47sig = new CINV47SIG();
    cinv47sig.setSzCdStagePersRole2("");
    cinv47sig.setUlIdVictim(0);
    cinv47sig.setUlIdStage(0);
    cinv47sig.setSzCdAllegType("");

    cinv47si.setCdAllegDisposition(CodesTables.CDISPSTN_ZZZ);

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.N);
    cinv47si.setArchInputStruct(archInputStruct);

    Date dtLastUpdate = new GregorianCalendar(1996, 4, 31, 16, 9, 55).getTime();
    cinv47sig.setTsSysTsLastUpdate4(dtLastUpdate);

    cinv47si.setCINV47SIG(cinv47sig);

    // cinv47si.setUlIdEvent(5600679);
    cinv47si.setUlIdEvent(0);
    try {
      saveAllegationDetail.saveAllegDtl(cinv47si);
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }

    }
  }

}