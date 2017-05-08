package gov.georgia.dhr.dfcs.sacwis.web.document.successaction;

// -- javax --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GenericStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 *          <p/>
 *          <pre>
 *                   Change History:
 *                    Date      User      Description
 *                    --------  --------  --------------------------------------------------
 *                    07/28/04  CORLEYAN  SIR 23048 - Incorrect code being written to the
 *                                        Purpose field
 *                    10/8/2004 ROBERTSW  SIR 23149 - Added throws clause for execute method
 *                   </pre>
 */

public class NoticeToParent extends DocumentSuccessAction {

  public void execute(HttpServletRequest request) throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace("NoticeToParent", "execute");
    performanceTrace.enterScope();

    ROWCINT33SIG01 rowcint33sig01 = new ROWCINT33SIG01();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();

    // Populate the contact structure
    rowcint33sig01.setSzCdContactLocation(PAR_CONTACT_LOCATION);
    rowcint33sig01.setSzCdContactMethod(PAR_CONTACT_METHOD);
    rowcint33sig01.setSzCdContactOthers(PAR_CONTACT_OTHERS);
    rowcint33sig01.setSzCdContactPurpose(PAR_CONTACT_PURPOSE);
    rowcint33sig01.setSzCdContactType(PAR_CONTACT_TYPE);
    rowcint33sig01.setBIndContactAttempted(ServiceConstants.FND_NO);
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());

    // Populate the event structure
    rowccmn01uig00.setSzCdTask(PAR_EVENT_TASK);
    rowccmn01uig00.setSzCdEventStatus(PAR_EVENT_STATUS);
    rowccmn01uig00.setSzCdEventType(PAR_EVENT_TYPE);
    rowccmn01uig00.setSzTxtEventDescr(PAR_EVENT_DESCRIPTION);
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));

    GenericStruct genericstruct = new GenericStruct();
    genericstruct.setUlIdStage(GlobalData.getUlIdStage(request));
    genericstruct.setUlIdEvent(0);

    // Call the service
    super.createContact(rowcint33sig01, rowccmn01uig00, genericstruct);

    performanceTrace.exitScope();
  }

  // Event-Contact Constants for cfiv0400
  public final String PAR_CONTACT_LOCATION = "";
  public final String PAR_CONTACT_OTHERS = "BXXX";
  public final String PAR_CONTACT_METHOD = "LST";
  public final String PAR_CONTACT_PURPOSE = "BFND";
  public final String PAR_CONTACT_TYPE = "ANOT";
  public final String PAR_EVENT_TASK = "";
  public final String PAR_EVENT_STATUS = "COMP";
  public final String PAR_EVENT_TYPE = "NOT";
  public final String PAR_EVENT_DESCRIPTION = "Investigation Notice to Parent Form";

}