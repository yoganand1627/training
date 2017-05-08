package gov.georgia.dhr.dfcs.sacwis.web.document.successaction;

// -- javax --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GenericStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT33SIG01;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/**
 * <p>Title: Intake Notification To Reporter</p> <p>Description: Contact creation code for document</p> <p>Copyright:
 * Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Rodrigo DeJuana
 * @version 1.0
 *          <pre>
 *                   Change History:
 *                    Date      User      Description
 *                    --------  --------  --------------------------------------------------
 *                    10/8/2004 ROBERTSW  SIR 23149 - Added throws clause for execute method
 *          <p/>
 *                   </pre>
 */

public class IntakeNotifToReporter extends DocumentSuccessAction {

  public void execute(HttpServletRequest request) throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace("IntakeNotifToReporter", "execute");
    performanceTrace.enterScope();

    ROWCINT33SIG01 rowcint33sig01 = new ROWCINT33SIG01();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();

    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
            BaseSessionStateManager.STATE_MANAGER_KEY);
    String nmPerson = (String) state.getAttribute("nmPerson", request);

    // Populate the contact structure
    rowcint33sig01.setSzCdContactMethod(DP_CONTACT_METHOD_METHOD_LETTER_SENT);
    rowcint33sig01.setSzCdContactPurpose(DP_CONTACT_PURPOSE_CWA_PURPOSE);
    rowcint33sig01.setSzCdContactType(DP_CONTACT_TYPE_REGULAR_CONTACT_TYPE);

    // Populate the event structure
    rowccmn01uig00.setSzCdEventStatus(DP_EVENT_STATUS);
    rowccmn01uig00.setSzCdEventType(DP_EVENT_TYPE);
    rowccmn01uig00.setSzTxtEventDescr(DP_DESCR_FORM_LETTER_DESCRIP + nmPerson);
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));

    GenericStruct genericstruct = new GenericStruct();
    genericstruct.setUlIdStage(GlobalData.getUlIdStage(request));

    // Call the service
    super.createContact(rowcint33sig01, rowccmn01uig00, genericstruct);

    performanceTrace.exitScope();
  }

  public static final String TRACE_TAG = "IntakeNotifToReporter";

  // Event-Contact Constants for CFIV0900
  public final String DP_CONTACT_OTHERS = "";
  public final String DP_CONTACT_METHOD_METHOD_LETTER_SENT = "LST";
  public final String DP_CONTACT_PURPOSE_CWA_PURPOSE = "DCWA";
  public final String DP_CONTACT_TYPE_REGULAR_CONTACT_TYPE = "DREG";
  public final String DP_EVENT_STATUS = "COMP";
  public final String DP_EVENT_TYPE = "NOT";
  public final String DP_DESCR_FORM_LETTER_DESCRIP = "Form Letter Sent to Reporter: ";

}