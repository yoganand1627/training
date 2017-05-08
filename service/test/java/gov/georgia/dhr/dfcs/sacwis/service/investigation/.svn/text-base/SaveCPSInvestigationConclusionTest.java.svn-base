package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveCPSInvestigationConclusionTest extends BaseServiceTest {
  
  protected SaveCPSInvestigationConclusion saveCPSInvestigationConclusion = null;

  public SaveCPSInvestigationConclusionTest(String testName) {
    super(testName);
  }

  public void setSaveCPSInvestigationConclusion(SaveCPSInvestigationConclusion saveCPSInvestigationConclusion) {
    this.saveCPSInvestigationConclusion = saveCPSInvestigationConclusion;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveCPSInvestigationConclusionTest("test1SaveCPSInvestigationConclusion"));
    return suite;
  }
  public static final String[] closureArray1 = {"64", "66", "68", "70", "65", "69"};
  public static final String[] closureArray2 = {"80", "82", "84", "86"};

  public static final Set<String> LEGAL_STATUS_AND_SERVICE_AUTHORIZATION_TASKS = new HashSet<String>(Arrays.asList(new String[] {"3020",
                                                                                                                                 "9020",
                                                                                                                                 "3520",
                                                                                                                                 "5040",
                                                                                                                                 "2100",
                                                                                                                                 "2310",
                                                                                                                                 "8530",
                                                                                                                                 "7100",
                                                                                                                                 "5640",
                                                                                                                                 "6075",
                                                                                                                                 "4190",
                                                                                                                                 "3290",
                                                                                                                                 "3310",
                                                                                                                                 "3510",
                                                                                                                                 "4370",
                                                                                                                                 "5870",
                                                                                                                                 "7230",
                                                                                                                                 "2375",
                                                                                                                                 "3050",
                                                                                                                                 "8560",
                                                                                                                                 "2385",
                                                                                                                                 "3060",
                                                                                                                                 "9060",
                                                                                                                                 "8570",
                                                                                                                                 "7240",
                                                                                                                                 "5880",
                                                                                                                                 "4380",
                                                                                                                                 "9050" }));

  public void test1SaveCPSInvestigationConclusion() {
    
    CINV16SI cinv16si = new CINV16SI();  
    
    int idStage = 5600818;
    
    ROWCINV14SOG00 rowcinv14sog00 = new ROWCINV14SOG00();
    
    rowcinv14sog00.setUlIdStage(idStage);
    rowcinv14sog00.setUlIdUnit(393);
    rowcinv14sog00.setBIndStageClose(ArchitectureConstants.Y);
    rowcinv14sog00.setSzNmStage("Jean-Baptiste,Herve");
    rowcinv14sog00.setSzCdStage("SUB");
    rowcinv14sog00.setSzCdStageClassification("CPS");
    rowcinv14sog00.setSzCdStageCnty("015");
    rowcinv14sog00.setSzCdStageCurrPriority("1");
    rowcinv14sog00.setSzCdStageInitialPriority("1");
    rowcinv14sog00.setSzCdStageProgram("CPS");
    
    // in closureArray1 or closureArray2
    rowcinv14sog00.setSzCdStageReasonClosed("64");
    
    Date dtStageClose = new GregorianCalendar(1997, 3, 4).getTime();    
    rowcinv14sog00.setDtDtStageClose(DateHelper.toCastorDate(dtStageClose));
    rowcinv14sog00.setTmSysTmStageClose("5:53:08 PM");    
    Date dtStageStart = new GregorianCalendar(1996, 11, 4).getTime();
    rowcinv14sog00.setDtDtStageStart(DateHelper.toCastorDate(dtStageStart));
    rowcinv14sog00.setTmSysTmStageStart("10:53:08 AM");
    rowcinv14sog00.setUlIdCase(5600405);
    rowcinv14sog00.setUlIdSituation(5600405);
    rowcinv14sog00.setSzTxtStageClosureCmnts("Do it soon");
    rowcinv14sog00.setSzTxtStagePriorityCmnts("Do it now");
    rowcinv14sog00.setSzCdStageRegion("07");
    rowcinv14sog00.setSzCdStageRsnPriorityChgd("Do it again");
    rowcinv14sog00.setSzCdStageType("PHAB1");
    
    Date dtLastUpdate = new GregorianCalendar(1997, 5, 4, 12, 59, 24).getTime();
    rowcinv14sog00.setTsLastUpdate(dtLastUpdate);
    
    cinv16si.setROWCINV14SOG00(rowcinv14sog00); 
    
    
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    
    rowccmn45do.setSzCdEventStatus(CodesTables.CEVTSTAT_NEW); // APRV COMP PEND PROC
    int idEvent = 12345;
    rowccmn45do.setUlIdEvent(idEvent);    
    Date dtProfAssmtAppt = new GregorianCalendar(2006, 1, 7, 10, 9, 47).getTime();
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(dtProfAssmtAppt));    
    rowccmn45do.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP); //CodesTables.CEVTSTAT_NEW    
    rowccmn45do.setUlIdStage(idStage);
    rowccmn45do.setUlIdPerson(2507);
    rowccmn45do.setSzCdTask("3520"); // in Set<String> LEGAL_STATUS_AND_SERVICE_AUTHORIZATION_TASKS
    rowccmn45do.setSzCdEventType("ELG");    
    Date dtEventOccurred = new GregorianCalendar(2005, 12, 17, 10, 10, 30).getTime();    
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));    
    rowccmn45do.setSzTxtEventDescr("EA Eligibilty");    
    //Date dtLastUpdate = new GregorianCalendar(2005, 12, 17, 10, 10, 30).getTime();
    rowccmn45do.setTsLastUpdate(dtLastUpdate);
    
    cinv16si.setROWCCMN45DO(rowccmn45do);     
    
    ROWCINV10DOG00 rowcinv10dog00 = new ROWCINV10DOG00();    
    
    Date dtCPSInvstDtlAssigned = new GregorianCalendar(2005, 10, 17, 10, 10, 30).getTime();
    rowcinv10dog00.setDtDtCPSInvstDtlAssigned(DateHelper.toCastorDate(dtCPSInvstDtlAssigned));
    Date dtCPSInvstDtlBegun = new GregorianCalendar(2005, 11, 17, 10, 10, 30).getTime();
    rowcinv10dog00.setDtDtCPSInvstDtlBegun(DateHelper.toCastorDate(dtCPSInvstDtlBegun));
    Date dtCPSInvstDtlComplt = new GregorianCalendar(2005, 11, 17, 10, 10, 30).getTime();
    rowcinv10dog00.setDtDtCpsInvstDtlComplt(DateHelper.toCastorDate(dtCPSInvstDtlComplt));
    Date dtCPSInvstDtlIntake = new GregorianCalendar(2005, 11, 17, 10, 10, 30).getTime();
    rowcinv10dog00.setDtDtCPSInvstDtlIntake(dtCPSInvstDtlIntake);
    rowcinv10dog00.setUlIdStage(idStage);
    rowcinv10dog00.setSzCdCpsInvstDtlFamIncm("12");
    rowcinv10dog00.setCdCpsOverallDisptn("RTB"); 
    rowcinv10dog00.setCIndCpsInvstDtlRaNa(ArchitectureConstants.N);
    rowcinv10dog00.setBIndCpsInvstSafetyPln(ArchitectureConstants.N);
    rowcinv10dog00.setBIndCpsInvstEaConcl(ArchitectureConstants.Y);
    rowcinv10dog00.setCIndCpsInvstAbbrv(ArchitectureConstants.Y);
    rowcinv10dog00.setBIndCpsInvstCpsLeJointContact(ArchitectureConstants.Y);
    rowcinv10dog00.setSzCdCpsInvstCpsLeJointContact("12");
    rowcinv10dog00.setSzTxtCpsInvstCpsLeJointContact("Test txt entry");
    rowcinv10dog00.setBIndVictimTaped(ArchitectureConstants.Y);
    rowcinv10dog00.setSzCdVictimTaped("12");
    rowcinv10dog00.setSzTxtVictimTaped("Test txt entry");
    rowcinv10dog00.setTsLastUpdate(dtLastUpdate);
    rowcinv10dog00.setUlIdEvent(idEvent);
    
    cinv16si.setROWCINV10DOG00(rowcinv10dog00);
    
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUlSysNbrReserved2(2);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    cinv16si.setArchInputStruct(archInputStruct);     
    
    ROWCINV14DOG00 rowcinv14dog00 = new ROWCINV14DOG00();    
    rowcinv14dog00.setSzCdRiskAssmtRiskFind(CodesTables.CCRSKFND_04); //CCRSKFND_01   
    cinv16si.setROWCINV14DOG00(rowcinv14dog00);
    
    cinv16si.setBIndChkd(ArchitectureConstants.Y);
    
    
    try {
      saveCPSInvestigationConclusion.saveCPSInvestigationConclusion(cinv16si);
      //fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.MSG_CMN_TMSTAMP_MISMATCH) 
                      && (se.getErrorCode() != Messages.SQL_NOT_FOUND) 
                      && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)
                      // Temporary message to account for NonUniqueObjectException
                      && (se.getErrorCode() != Messages.MSG_DUPLICATE_RECORD)) {
        throw se;
      }
    }
    
  }
}
