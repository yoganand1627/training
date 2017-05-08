package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC21SI;
import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveCaseFileManagementTest extends BaseServiceTest {

  public RetrieveCaseFileManagementTest(String retrieveCaseFileManagement) {
    super(retrieveCaseFileManagement);
  }

  public void setRetrieveCaseFileManagement(RetrieveCaseFileManagement retrieveCaseFileManagement) {
    this.retrieveCaseFileManagement = retrieveCaseFileManagement;
  }

  protected RetrieveCaseFileManagement retrieveCaseFileManagement = null;

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveCaseFileManagementTest("testRetrieveCaseFileManagement"));
    return suite;
  }

  public void testRetrieveCaseFileManagement() {
    CCFC21SI ccfc21si = new CCFC21SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccfc21si.setArchInputStruct(archInputStruct);
    int idCase = 10120;
    int idPerson = 4012272;
    ccfc21si.setUlIdPerson(idPerson);
    ccfc21si.setUlIdCase(idCase);

    retrieveCaseFileManagement.retrieveCaseFileManagement(ccfc21si);
  }
}
