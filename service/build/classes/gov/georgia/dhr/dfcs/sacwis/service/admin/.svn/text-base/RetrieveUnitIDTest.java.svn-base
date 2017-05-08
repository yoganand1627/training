package gov.georgia.dhr.dfcs.sacwis.service.admin;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN47SI;

public class RetrieveUnitIDTest extends BaseServiceTest {

  public RetrieveUnitIDTest(String retrieveUnitID) {
    super(retrieveUnitID);
  }
  
  public void setRetrieveUnitID(RetrieveUnitID retrieveUnitID) {
    this.retrieveUnitID = retrieveUnitID;
  }

  protected RetrieveUnitID retrieveUnitID = null;
 
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveUnitIDTest("testRetrieveUnitID"));
    return suite;
  }
  
  public void testRetrieveUnitID() {
    CCMN47SI ccmn47si = new CCMN47SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn47si.setArchInputStruct(archInputStruct);
    ccmn47si.setSzCdUnitCounty("001");
    ccmn47si.setSzCdUnitRegion("007");
    ccmn47si.setSzNbrUnit("36");

    retrieveUnitID.retrieveUnitID(ccmn47si);
  }
  
  
}
