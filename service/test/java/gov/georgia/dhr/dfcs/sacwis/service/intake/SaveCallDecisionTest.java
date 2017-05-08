package gov.georgia.dhr.dfcs.sacwis.service.intake;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CdIncmgDeterm_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdIncmgDetermType_ARRAY;

public class SaveCallDecisionTest extends BaseServiceTest {

  protected SaveCallDecision saveCallDecision = null;

  public SaveCallDecisionTest(String testName) {
    super(testName);
  }

  protected void onSetUpInTransaction() throws Exception {
    super.onSetUpInTransaction();
   
   
//    jdbcTemplate.update("DELETE CONTACT WHERE ID_CONTACT_STAGE = 5603304");
//    
//    jdbcTemplate.update("DELETE INCMG_DETERM_FACTORS WHERE ID_INCMG_DETERM_STAGE = 5603304");
//    
//    jdbcTemplate.update("DELETE EVENT WHERE ID_EVENT_STAGE = 5603304");
//    
//    jdbcTemplate.update("DELETE EVENT WHERE ID_EVENT_STAGE = 5603304");
//    jdbcTemplate.update("DELETE STAGE WHERE ID_STAGE = 5603304");
  }

  public void setSaveCallDecision(SaveCallDecision saveCallDecision) {
    this.saveCallDecision = saveCallDecision;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveCallDecisionTest("testSaveCallDecision_Add"));
    suite.addTest(new SaveCallDecisionTest("testSaveCallDecision_Update"));
    suite.addTest(new SaveCallDecisionTest("testSaveCallDecision_InvalidData"));
    return suite;
  }

  public void testSaveCallDecision_Add() {
    CallDcsnAUDIn callDcsnAUDIn = new CallDcsnAUDIn();

    CallDcsnAUD callDcsnAUD = new CallDcsnAUD();
    SpecHD specHD = new SpecHD();
    callDcsnAUD.setUlIdStage(5603304);
    callDcsnAUD.setUlIdPerson(1);
    callDcsnAUD.getSzNmJurisdiction();
    // callDcsnAUDIn.getSpecHD().getSzCdCaseSpeclHndlg();

    DetermListAUD determListAUD = new DetermListAUD();
    CdIncmgDeterm_ARRAY cdIncmgDetermArray = new CdIncmgDeterm_ARRAY();

    cdIncmgDetermArray.addCdIncmgDeterm("CIS");

    determListAUD.setCdIncmgDeterm_ARRAY(cdIncmgDetermArray);

    SzCdIncmgDetermType_ARRAY szCdIncmgDetermTypeArray = new SzCdIncmgDetermType_ARRAY();
    szCdIncmgDetermTypeArray.addSzCdIncmgDetermType("F");
    determListAUD.setSzCdIncmgDetermType_ARRAY(szCdIncmgDetermTypeArray);

    // updateCaseInformation
    specHD.setSzCdCaseSpeclHndlg(null);
    specHD.setUlIdCase(5606099);
    specHD.setSzTxtCaseWorkerSafety(null);
    specHD.setSzTxtCaseSensitiveCmnts(null);
    specHD.setSzTxtCaseSuspMeth(null);
    specHD.setBIndCaseSensitive(null);
    specHD.setBIndCaseSuspMeth(null);
    specHD.setBIndCaseWorkerSafety(null);
    callDcsnAUD.setBIndIncmgNoFactor(null);

    callDcsnAUDIn.setDetermListAUD(determListAUD);
    callDcsnAUDIn.setCallDcsnAUD(callDcsnAUD);
    callDcsnAUDIn.setSpecHD(specHD);
    callDcsnAUD.setSzCdIncmgAllegType(null);
    // caudf0dAUDdam

    saveCallDecision.saveCallDecision(callDcsnAUDIn);
  }

  public void testSaveCallDecision_Update() {
    CallDcsnAUDIn callDcsnAUDIn = new CallDcsnAUDIn();

    CallDcsnAUD callDcsnAUD = new CallDcsnAUD();

    callDcsnAUD.setSzNmStage("Test");
    SpecHD specHD = new SpecHD();
    //callDcsnAUD.setUlIdStage(5600021);
     callDcsnAUD.setUlIdStage(99999);
    callDcsnAUD.setUlIdPerson(1);
    callDcsnAUD.getSzNmJurisdiction();
    // callDcsnAUDIn.getSpecHD().getSzCdCaseSpeclHndlg();

    DetermListAUD determListAUD = new DetermListAUD();
    CdIncmgDeterm_ARRAY cdIncmgDetermArray = new CdIncmgDeterm_ARRAY();

    cdIncmgDetermArray.addCdIncmgDeterm("CIS");

    determListAUD.setCdIncmgDeterm_ARRAY(cdIncmgDetermArray);

    SzCdIncmgDetermType_ARRAY szCdIncmgDetermTypeArray = new SzCdIncmgDetermType_ARRAY();
    szCdIncmgDetermTypeArray.addSzCdIncmgDetermType("F");
    determListAUD.setSzCdIncmgDetermType_ARRAY(szCdIncmgDetermTypeArray);

    // updateCaseInformation
    specHD.setSzCdCaseSpeclHndlg(null);
    specHD.setUlIdCase(5606099);
    specHD.setSzTxtCaseWorkerSafety(null);
    specHD.setSzTxtCaseSensitiveCmnts(null);
    specHD.setSzTxtCaseSuspMeth(null);
    specHD.setBIndCaseSensitive(null);
    specHD.setBIndCaseSuspMeth(null);
    specHD.setBIndCaseWorkerSafety(null);
    callDcsnAUD.setBIndIncmgNoFactor(null);

    callDcsnAUDIn.setDetermListAUD(determListAUD);
    callDcsnAUDIn.setCallDcsnAUD(callDcsnAUD);
    callDcsnAUDIn.setSpecHD(specHD);
    callDcsnAUD.setSzCdIncmgAllegType(null);
    // caudf0dAUDdam
    try {
    saveCallDecision.saveCallDecision(callDcsnAUDIn);
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
    }

  }

  public void testSaveCallDecision_InvalidData() {
    CallDcsnAUDIn callDcsnAUDIn = new CallDcsnAUDIn();

    CallDcsnAUD callDcsnAUD = new CallDcsnAUD();

    callDcsnAUD.setSzNmStage("Test");
    SpecHD specHD = new SpecHD();
    callDcsnAUD.setUlIdStage(0);
    callDcsnAUD.setUlIdPerson(0);
    callDcsnAUD.getSzNmJurisdiction();
    // callDcsnAUDIn.getSpecHD().getSzCdCaseSpeclHndlg();

    DetermListAUD determListAUD = new DetermListAUD();
    CdIncmgDeterm_ARRAY cdIncmgDetermArray = new CdIncmgDeterm_ARRAY();

    cdIncmgDetermArray.addCdIncmgDeterm("CIS");

    determListAUD.setCdIncmgDeterm_ARRAY(cdIncmgDetermArray);

    SzCdIncmgDetermType_ARRAY szCdIncmgDetermTypeArray = new SzCdIncmgDetermType_ARRAY();
    szCdIncmgDetermTypeArray.addSzCdIncmgDetermType("F");
    determListAUD.setSzCdIncmgDetermType_ARRAY(szCdIncmgDetermTypeArray);

    // updateCaseInformation
    specHD.setSzCdCaseSpeclHndlg(null);
    specHD.setUlIdCase(5606099);
    specHD.setSzTxtCaseWorkerSafety(null);
    specHD.setSzTxtCaseSensitiveCmnts(null);
    specHD.setSzTxtCaseSuspMeth(null);
    specHD.setBIndCaseSensitive(null);
    specHD.setBIndCaseSuspMeth(null);
    specHD.setBIndCaseWorkerSafety(null);
    callDcsnAUD.setBIndIncmgNoFactor(null);

    callDcsnAUDIn.setDetermListAUD(determListAUD);
    callDcsnAUDIn.setCallDcsnAUD(callDcsnAUD);
    callDcsnAUDIn.setSpecHD(specHD);
    callDcsnAUD.setSzCdIncmgAllegType(null);
    // caudf0dAUDdam
    try {
      saveCallDecision.saveCallDecision(callDcsnAUDIn);
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }

    }
  }

}
