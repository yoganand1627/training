package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN46DI;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SaveProfessionalAssessmentTest extends BaseServiceTest {
  
  protected SaveProfessionalAssessment saveProfessionalAssessment = null;

  public SaveProfessionalAssessmentTest(String testName) {
    super(testName);
  }

  public void setSaveProfessionalAssessment(SaveProfessionalAssessment saveProfessionalAssessment) {
    this.saveProfessionalAssessment = saveProfessionalAssessment;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new SaveProfessionalAssessmentTest("test1SaveProfessionalAssessment"));
    return suite;
  }

  public void test1SaveProfessionalAssessment() {
    
    CINV31SI cinv31si = new CINV31SI();
    
    Date dtLastUpdate = new GregorianCalendar(1997, 3, 4, 12, 59, 24).getTime(); 
    int idEvent = 5603124;

    // ====================================ROWCCMN46DI Set===========================
    
    ROWCCMN46DI rowccmn46di = new ROWCCMN46DI();
    
    rowccmn46di.setUlIdEvent(idEvent);
    
    Date dtProfAssmtAppt = new GregorianCalendar(2006, 1, 7, 10, 9, 47).getTime();
    cinv31si.setDtProfAssmtAppt(DateHelper.toCastorDate(dtProfAssmtAppt));    
    rowccmn46di.setDtDtEventOccurred(cinv31si.getDtProfAssmtAppt());
    
    rowccmn46di.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP); //CodesTables.CEVTSTAT_NEW
    
    rowccmn46di.setUlIdStage(2);
    rowccmn46di.setUlIdPerson(2507);
    rowccmn46di.setSzCdTask("1047");
    rowccmn46di.setSzCdEventType("ELG"); 
    
    Date dtEventOccurred = new GregorianCalendar(2005, 12, 17, 10, 10, 30).getTime();    
    rowccmn46di.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    
    rowccmn46di.setSzTxtEventDescr("EA Eligibilty");
    rowccmn46di.setTsLastUpdate(dtLastUpdate);
     
    cinv31si.setROWCCMN46DI(rowccmn46di);

    // ===============================================================================
    
    ArchInputStruct archInputStruct = new ArchInputStruct();   
    
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();                               
    rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    rowccmn01uig01.setUlIdPerson(2507);    
    cinv31si.setROWCCMN01UIG01(rowccmn01uig01); 
    
    
    archInputStruct.setUlSysNbrReserved1(ArchitectureConstants.N);
    cinv31si.setArchInputStruct(archInputStruct);
    cinv31si.setUlIdEvent(idEvent);
    
    cinv31si.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    
    cinv31si.setUlIdPersonPrincipal(5600120);
    cinv31si.setUlIdPersonProfessional(5602781);    
    cinv31si.setSzNmProfAssmtName("Dunaway,Kevin");
    cinv31si.setSzNmProfAssmtPrincipal("Jean-Baptiste,Herve");
    cinv31si.setSzTxtProfAssmtOther("Dr Test");
    cinv31si.setCdProfAssmtApptRsn("PHC");
    cinv31si.setTsLastUpdate(dtLastUpdate);
    cinv31si.setSzTxtProfAssmtFindings("Child taken to dentist");
    cinv31si.setSzAddrProfAssmtCity("Atlanta");
    cinv31si.setSzAddrProfAssmtStLn1("1000 Peachtree St");
    cinv31si.setSzAddrProfAssmtStLn2("Apt 303");
    cinv31si.setSzAddrProfAssmtZip("30329-4042");
    cinv31si.setSzCdProfAssmtCounty("015");
    cinv31si.setSzAddrProfAssmtState("GA");
    cinv31si.setLNbrPhone("404-237-5083");
    cinv31si.setLNbrPhoneExtension("");
    
    try {
      saveProfessionalAssessment.saveProfessionalAssessment(cinv31si);
      //fail("Expected an exception with Messages.EXPECTED_CODE.");
    } catch (ServiceException se) {
      if ((se.getErrorCode() != Messages.MSG_CMN_TMSTAMP_MISMATCH) && (se.getErrorCode() != Messages.SQL_NOT_FOUND) && (se.getErrorCode() != Messages.ARC_ERR_BAD_FUNC_CD)) {
        throw se;
      }
    }
  }

}
