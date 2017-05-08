package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveApprovalStatus;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34SI;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RetrieveApprovalStatusTest extends BaseServiceTest {
    protected RetrieveApprovalStatus retrieveApprovalStatus = null;

  public RetrieveApprovalStatusTest(String testName) {
    super(testName);
  }

  public void setRetrieveApprovalStatus(RetrieveApprovalStatus retrieveApprovalStatus) {
    this.retrieveApprovalStatus = retrieveApprovalStatus;
  }

  protected void onSetUpInTransaction() throws Exception {
    int idApprovalRejection = getSequenceNextval("SEQ_APPROVAL_REJECTION");
    jdbcTemplate.update("INSERT INTO APPROVAL_REJECTION (ID_APPROVAL_REJECTION, ID_CASE, DT_LAST_UPDATE, ID_STAGE, ID_REJECTOR, DT_REJECTION, IND_APS_EFFORT, IND_DISCRETIONARY) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        new Object[] { idApprovalRejection, 5600850, new GregorianCalendar(2006, 6, 6, 0, 0, 0), 5601802, 850, new GregorianCalendar(2006, 6, 6, 0, 0, 0), "N", "N" });
    jdbcTemplate.update("UPDATE EVENT " + "SET CD_TASK = '2120' " + "WHERE ID_EVENT = 5600876");
    
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_BROWSE"));
    suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_MODIFY1"));
    suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_MODIFY2"));
        suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_MODIFY3"));
    suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_NoApprover"));
    suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_NoApprovalEventLink"));
    suite.addTest(new RetrieveApprovalStatusTest("testRetrieveApprovalStatus_NoApprovalEventLink2"));
    suite.addTest(new RetrieveApprovalStatusTest("testIdCase0_IdPerson0"));

    return suite;
  }
  
  public void testRetrieveApprovalStatus_BROWSE() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(0);
    ccmn34si.setUlIdCase(10209);
    ccmn34si.setUlIdEvent(2295);
    ccmn34si.setUlIdStage(418);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
    } catch (ServiceException se) {
    }
  }
  public void testIdCase0_IdPerson0() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(0);
    ccmn34si.setUlIdCase(0);
    ccmn34si.setUlIdEvent(2295);
    ccmn34si.setUlIdStage(0);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
    } catch (ServiceException se) {
    }
  }
  
  public void testRetrieveApprovalStatus_MODIFY1() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(5600637);
    ccmn34si.setUlIdCase(5600139);
    ccmn34si.setUlIdEvent(5600876);
    ccmn34si.setUlIdStage(5600225);
//    retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
      fail("Expected ServiceException with Messages.SQL_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
    }
    
  }
  // Rejection
  public void testRetrieveApprovalStatus_MODIFY2() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(5607300); // scenario will be reset to 2 later on inside
    ccmn34si.setUlIdCase(5600850);
    ccmn34si.setUlIdEvent(5611955);
    ccmn34si.setUlIdStage(5601802);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
    } catch (ServiceException se) {
    }
  }
  public void testRetrieveApprovalStatus_NoApprover() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(100); 
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
      fail("Expected ServiceException with Messages.SQL_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
    }
  }
  public void testRetrieveApprovalStatus_NoApprovalEventLink() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(0); 
     ccmn34si.setUlIdEvent(1);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
      fail("Expected ServiceException with Messages.SQL_NOT_FOUND or Messages.MSG_NO_ROWS_RETURNED.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND && se.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) {
        throw se;
      }
    }
  }
  public void testRetrieveApprovalStatus_NoApprovalEventLink2() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(0); 
     ccmn34si.setUlIdEvent(0);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
      fail("Expected ServiceException with Messages.SQL_NOT_FOUND.");
    } catch (ServiceException se) {
      if (se.getErrorCode() != Messages.SQL_NOT_FOUND) {
        throw se;
      }
    }
  }
  public void testRetrieveApprovalStatus_MODIFY3() {
    CCMN34SI ccmn34si = new CCMN34SI();
    ccmn34si.setLdIdTodo(5607300); // scenario will be reset to 2 later on inside
    ccmn34si.setUlIdCase(0);
    ccmn34si.setUlIdEvent(5611955);
    ccmn34si.setUlIdStage(0);
    try {
      retrieveApprovalStatus.retrieveApprovalStatus(ccmn34si);
    } catch (ServiceException se) {
    }
  }
}
