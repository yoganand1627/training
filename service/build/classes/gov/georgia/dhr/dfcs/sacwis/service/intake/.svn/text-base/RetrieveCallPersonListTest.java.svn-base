package gov.georgia.dhr.dfcs.sacwis.service.intake;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveCallPersonListTest extends BaseServiceTest {

  protected RetrieveCallPersonList retrieveCallPersonList = null;

  public RetrieveCallPersonListTest(String testName) {
    super(testName);
  }

  public void setRetrieveCallPersonList(RetrieveCallPersonList retrieveCallPersonList) {
    this.retrieveCallPersonList = retrieveCallPersonList;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveCallPersonListTest("testRetrieveCallPersonList_InmgStatus_CLD"));
    suite.addTest(new RetrieveCallPersonListTest("testRetrieveCallPersonList_InmgStatus_OPF"));
    suite.addTest(new RetrieveCallPersonListTest("testRetrieveCallPersonList_InvalidData"));
    return suite;
  }

  public void testRetrieveCallPersonList_InmgStatus_CLD() {

    PersListInRec cint26in = new PersListInRec();
    cint26in.setUlIdStage(5500123);
    String cdIncmgStatus = CodesTables.CINCMGST_CLD;
    cint26in.setCdIncmgStatus(cdIncmgStatus);

    Calendar cal = Calendar.getInstance();
    Date sysdate = cal.getTime();
    cint26in.setTsIncmgCallDisp(sysdate);

    PersListOutRec persListOutRec = retrieveCallPersonList.retrieveCallPersonList(cint26in);

    Enumeration enumeratePersList = persListOutRec.getPersListRtrvStruct_ARRAY().enumeratePersListRtrvStruct();
    assertEquals("Check for More Element", true, enumeratePersList.hasMoreElements());

    PersListRtrvStruct persListRtrvStruct = (PersListRtrvStruct) enumeratePersList.nextElement();

    assertEquals("createPersListRtrvStruct", true, persListRtrvStruct.getUlIdStage() > 0);

  }

  public void testRetrieveCallPersonList_InmgStatus_OPF() {

    PersListInRec cint26in = new PersListInRec();
    cint26in.setUlIdStage(5600325);
    String cdIncmgStatus = CodesTables.CINCMGST_OPN;
    cint26in.setCdIncmgStatus(cdIncmgStatus);

    Calendar cal = Calendar.getInstance();
    Date sysdate = cal.getTime();
    cint26in.setTsIncmgCallDisp(sysdate);

    PersListOutRec persListOutRec = retrieveCallPersonList.retrieveCallPersonList(cint26in);

    Enumeration enumeratePersList = persListOutRec.getPersListRtrvStruct_ARRAY().enumeratePersListRtrvStruct();
    assertEquals("Check for More Element", true, enumeratePersList.hasMoreElements());

    PersListRtrvStruct persListRtrvStruct = (PersListRtrvStruct) enumeratePersList.nextElement();

    assertEquals("createPersListRtrvStruct", true, persListRtrvStruct.getUlIdStage() > 0);

  }

  public void testRetrieveCallPersonList_InvalidData() {

    PersListInRec cint26in = new PersListInRec();
    cint26in.setUlIdStage(0);
    String cdIncmgStatus = CodesTables.CINCMGST_OPN;
    cint26in.setCdIncmgStatus(cdIncmgStatus);

    Calendar cal = Calendar.getInstance();
    Date sysdate = cal.getTime();
    cint26in.setTsIncmgCallDisp(sysdate);

    retrieveCallPersonList.retrieveCallPersonList(cint26in);
  }

}
