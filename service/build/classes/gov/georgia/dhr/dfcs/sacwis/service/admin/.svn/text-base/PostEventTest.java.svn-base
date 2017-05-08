package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Test;
import junit.framework.TestSuite;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.BaseServiceTest;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;

public class PostEventTest extends BaseServiceTest {

  public PostEventTest(String postEvent) {
    super(postEvent);
  } 
 
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }
   
  protected PostEvent postEvent = null;
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    
    //  Note: This method has not been fully tested, methods add and updated 
    // tested but delete method has errors when run.
    
//    suite.addTest(new PostEventTest("testAddPostEvent"));
//    suite.addTest(new PostEventTest("testUpdatePostEvent"));
    suite.addTest(new PostEventTest("testDeletePostEvent"));
    return suite;
  }
  public void testAddPostEvent() {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 rowccmn01UIG00 = new ROWCCMN01UIG00();
    rowccmn01UIG00.setSzCdEventStatus("PEND");
    rowccmn01UIG00.setSzCdEventType("STG");
    rowccmn01UIG00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    rowccmn01UIG00.setUlIdPerson(100001);
    rowccmn01UIG00.setUlIdStage(132);
    rowccmn01UIG00.setSzTxtEventDescr("Investigation Actions");
    rowccmn01UIG00.setSzCdTask("2210");
    rowccmn01UIG00.setUlIdEvent(0);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01UIG00);
    postEvent.postEvent(ccmn01ui);
  }

  public void testUpdatePostEvent() {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 rowccmn01UIG00 = new ROWCCMN01UIG00();
    rowccmn01UIG00.setSzCdEventStatus("PEND");
    rowccmn01UIG00.setSzCdEventType("STG");
    //Date dtEventOccurred = new GregorianCalendar(1996, 4, 31).getTime();
    rowccmn01UIG00.setDtDtEventOccurred(DateHelper.toCastorDateSafe("05/31/1996"));
    Date dtLastUpdate = new GregorianCalendar(1996, 5, 19, 22, 10, 34).getTime();
    rowccmn01UIG00.setTsLastUpdate(dtLastUpdate);
    rowccmn01UIG00.setUlIdPerson(100001);
    rowccmn01UIG00.setUlIdStage(132);
    rowccmn01UIG00.setSzTxtEventDescr("Investigation Actions");
    rowccmn01UIG00.setSzCdTask("2210");
    rowccmn01UIG00.setUlIdEvent(723);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01UIG00);
    postEvent.postEvent(ccmn01ui);
  }
  
  public void testDeletePostEvent() {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 rowccmn01UIG00 = new ROWCCMN01UIG00();
    Date dtLastUpdate = new GregorianCalendar(1996, 5, 19, 22, 10, 34).getTime();
    rowccmn01UIG00.setTsLastUpdate(dtLastUpdate);
    rowccmn01UIG00.setUlIdEvent(723);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01UIG00);
    postEvent.postEvent(ccmn01ui);
  }
}
