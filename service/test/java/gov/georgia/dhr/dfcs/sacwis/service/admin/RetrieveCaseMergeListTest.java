package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;
import junit.framework.Test;
import junit.framework.TestSuite;

/*
 * Use test case number 5606099; this is open case (dtCaseClosed = null)
 * Logged-in idPerson is 5172, who has merge access to above case
 */

public class RetrieveCaseMergeListTest extends BaseServiceTest {
  protected RetrieveCaseMergeList retrieveCaseMergeList = null;

  public RetrieveCaseMergeListTest(String testName) {
    super(testName);
  }

  public void setRetrieveCaseMergeList(RetrieveCaseMergeList retrieveCaseMergeList) {
    this.retrieveCaseMergeList = retrieveCaseMergeList;
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveCaseMergeListTest("testIncorrectCReqFuncCd"));
    suite.addTest(new RetrieveCaseMergeListTest("testCaseClosed"));
    suite.addTest(new RetrieveCaseMergeListTest("testIdCaseNotExist"));
    suite.addTest(new RetrieveCaseMergeListTest("testDetermineMergeAccess1"));
    suite.addTest(new RetrieveCaseMergeListTest("testNoMergeAccess"));
    suite.addTest(new RetrieveCaseMergeListTest("testDetermineMergeAccess2"));
    suite.addTest(new RetrieveCaseMergeListTest("testRetrieveCaseMergeInformation"));

    return suite;
  }

  /*
   * Calls targeted: personDAO.findPersonByIdCase(idCase)
   */
  public void testIncorrectCReqFuncCd() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    archInputStruct.setUsPageNbr(0);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setUlIdCase(0);
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ccfc39so.getROWCCFC39SOG00_ARRAY().hasUlRowQty() == false);
    String expected = ArchitectureConstants.N;
    assertTrue(expected.equals(ccfc39so.getCSysIndMergeAccess()));
  }

  /*
   * Test if (dtCaseClosed != null) returns true
   */
  public void testCaseClosed() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setUlIdCase(5600847);
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ccfc39so.getROWCCFC39SOG00_ARRAY().hasUlRowQty() == false);
    String expected = ArchitectureConstants.Y;
    assertTrue(expected.equals(ccfc39so.getCScrIndToCaseCld()));
  }

  /*
   * Call targeted: capsCaseDAO.findCapsCaseByIdCase(idCase)
   */
  public void testIdCaseNotExist() { // should throw ServiceException
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    archInputStruct.setUsPageNbr(0);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setUlIdCase(0);
    try {
      retrieveCaseMergeList.findCaseMergeList(ccfc39si);
      fail("Expected ServiceException with Messages.SQl_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
      // Ignore it; it was expected.
    }
  }

  /*
   * Target: first for loop inside determineMergeAccess() personDAO.findPersonByIdCase(idCase, pageNbr, pageSize)
   * returns nonempty set
   */
  public void testDetermineMergeAccess1() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setCSysIndMergeAccess(ArchitectureConstants.N);
    ccfc39si.setUlIdCase(5606099);
    ccfc39si.setUlIdPerson(5172); // this person has merge access to case 5606099, butnot in the first page of results
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ArchitectureConstants.Y.equals(ccfc39so.getCSysIndMergeAccess()));
  }

  /*
   * personDAO.findPersonByIdCase(idCase, pageNbr, pageSize) returns nonempty set but noone has merge access; move on to
   * test unit access; no unit access
   */

  public void testNoMergeAccess() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    archInputStruct.setUsPageNbr(2);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setCSysIndMergeAccess(ArchitectureConstants.N);
    ccfc39si.setUlIdCase(5606099);
    ccfc39si.setUlIdPerson(2506);
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ArchitectureConstants.N.equals(ccfc39so.getCSysIndMergeAccess()));
  }

  /*
   * This case will throw BigDecimal Exception
   */
  public void testRetrieveCaseMergeInformation() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    // to skip capsCaseDAO.findCapsCaseByIdCase(idCase)
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE); // to skip the first block
    archInputStruct.setUsPageNbr(0);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setUlIdCase(10177);
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00Count() > 0);
  }

  /*
   * Test when the logged-in person has no merge access but unit access Call targeted:
   * unitAccess.checkForPersonWithUnitAccess(ccmn04ui) returning true
   */
  public void testDetermineMergeAccess2() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setCSysIndMergeAccess(ArchitectureConstants.Y); // to be sure first for loop not executed
    ccfc39si.setUlIdCase(5606099);
    // testUnitAccess
    ccfc39si.setUlIdPerson(1); // this person has merge access to case 5606099, butnot in the first page of results
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ArchitectureConstants.Y.equals(ccfc39so.getCSysIndMergeAccess()));
  }

  /*
   * Test when the logged-in person has no merge access nor unit access Call targeted:
   * unitAccess.checkForPersonWithUnitAccess(ccmn04ui) returning false
   */
  public void testDetermineMergeAccess3() {
    CCFC39SI ccfc39si = new CCFC39SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    archInputStruct.setUsPageNbr(0);
    archInputStruct.setUlPageSizeNbr(200);
    ccfc39si.setArchInputStruct(archInputStruct);
    ccfc39si.setCSysIndMergeAccess(ArchitectureConstants.Y); // to be sure first for loop not executed
    ccfc39si.setUlIdCase(5606099);
    // testUnitAccess
    ccfc39si.setUlIdPerson(1111);
    CCFC39SO ccfc39so = retrieveCaseMergeList.findCaseMergeList(ccfc39si);
    assertTrue(ArchitectureConstants.N.equals(ccfc39so.getCSysIndMergeAccess()));
  }
}
