package gov.georgia.dhr.dfcs.sacwis.web.document.successaction;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GenericStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/**
 * <p>Title: Notification To L.E.</p> <p>Description: Contact creation code for document</p> <p>Copyright: Copyright (c)
 * 2002</p> <p>Company: </p>
 *
 * @author Rodrigo DeJuana
 * @version 1.0 Change History: Date      User      Description --------  --------  --------------------------------------------------
 *          10/8/2004 ROBERTSW  SIR 23149 - Added throws clause for execute method and other private methods
 */
public class NotificationToLE
        extends DocumentSuccessAction {
  public static final String INVESTIGATION = "INV";

  public void execute(HttpServletRequest request) throws Exception {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope("NotificationToLE", "execute");

    String stageCode = GlobalData.getSzCdStage(request);
    if (INVESTIGATION.equals(stageCode)) {
      createContactInvestigation(request);
    } else {
      createContactIntake(request);
    }

    performanceTrace.exitScope();
  }

  protected void createContactInvestigation(HttpServletRequest request) throws Exception {
    //code ported from cinv55w.win: SaveDetail
    ROWCINT33SIG01 rowcint33sig01 = new ROWCINT33SIG01();
    rowcint33sig01.setSzCdContactLocation("");
    rowcint33sig01.setSzCdContactMethod("LST");
    rowcint33sig01.setSzCdContactOthers("CLAW");
    rowcint33sig01.setSzCdContactPurpose("ANOT");
    rowcint33sig01.setSzCdContactType("ENOT");
    rowcint33sig01.setBIndContactAttempted(ServiceConstants.FND_NO);
    rowcint33sig01.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask("");
    rowccmn01uig00.setSzCdEventStatus("COMP");
    rowccmn01uig00.setSzCdEventType("CON");
    rowccmn01uig00.setSzTxtEventDescr("Notice to Law Enforcement Document");
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));

    GenericStruct genericstruct = new GenericStruct();
    genericstruct.setUlIdStage(GlobalData.getUlIdStage(request));

    /*
    ** Pass in the ulIdEvent from the generic structure
    ** in case this is the Id Event for the to-do. The
    ** generic service will create new id_event and remove
    ** a to-do if a valid id_event is passed in.
    */
    genericstruct.setUlIdEvent(GlobalData.getUlIdEvent(request));

    super.createContact(rowcint33sig01, rowccmn01uig00, genericstruct);
  }

  protected void createContactIntake(HttpServletRequest request) throws Exception {
    //code ported from cint12w.win: NotificationClick
    ROWCINT33SIG01 rowcint33sig01 = new ROWCINT33SIG01();
    rowcint33sig01.setSzCdContactLocation("");
    rowcint33sig01.setSzCdContactMethod("LST");
    rowcint33sig01.setSzCdContactOthers("DLAW");
    rowcint33sig01.setSzCdContactPurpose("DLEV");
    rowcint33sig01.setSzCdContactType("DNOT");
    rowcint33sig01.setBIndContactAttempted(ServiceConstants.FND_NO);
    rowcint33sig01.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask("1047");
    rowccmn01uig00.setSzCdEventStatus("COMP");
    rowccmn01uig00.setSzCdEventType("NOT");
    rowccmn01uig00.setSzTxtEventDescr("Notification to Law Enforcement");
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));

    GenericStruct genericstruct = new GenericStruct();
    genericstruct.setUlIdStage(GlobalData.getUlIdStage(request));

    super.createContact(rowcint33sig01, rowccmn01uig00, genericstruct);
  }
}
