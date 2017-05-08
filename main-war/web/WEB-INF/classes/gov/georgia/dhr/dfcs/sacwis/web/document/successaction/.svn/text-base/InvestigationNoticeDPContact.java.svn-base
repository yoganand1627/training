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
 *          <p/>
 *                    10/8/2004 ROBERTSW  SIR 23149 - Added throws clause for execute method
 *          <p/>
 *                   </pre>
 */

public class InvestigationNoticeDPContact extends DocumentSuccessAction {

  public void execute(HttpServletRequest request) throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace("InvestigationNoticeDPContact", "execute");
    performanceTrace.enterScope();

    ROWCINT33SIG01 rowcint33sig01 = new ROWCINT33SIG01();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();

    // Populate the contact structure
    rowcint33sig01.setSzCdContactLocation(DP_CONTACT_LOCATION);
    rowcint33sig01.setSzCdContactMethod(DP_CONTACT_METHOD);
    rowcint33sig01.setSzCdContactOthers(DP_CONTACT_OTHERS);
    rowcint33sig01.setSzCdContactPurpose(DP_CONTACT_PURPOSE);
    rowcint33sig01.setSzCdContactType(DP_CONTACT_TYPE);
    rowcint33sig01.setBIndContactAttempted(ServiceConstants.FND_NO);
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());

    // Populate the event structure
    rowccmn01uig00.setSzCdTask(DP_EVENT_TASK);
    rowccmn01uig00.setSzCdEventStatus(DP_EVENT_STATUS);
    rowccmn01uig00.setSzCdEventType(DP_EVENT_TYPE);
    rowccmn01uig00.setSzTxtEventDescr(DP_EVENT_DESCRIPTION);
    rowccmn01uig00.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));

    GenericStruct genericstruct = new GenericStruct();
    genericstruct.setUlIdStage(GlobalData.getUlIdStage(request));
    genericstruct.setUlIdEvent(0);

    // Call the service
    super.createContact(rowcint33sig01, rowccmn01uig00, genericstruct);

    performanceTrace.exitScope();
  }

  // Event-Contact Constants for cfiv0900
  public final String DP_CONTACT_LOCATION = "";
  public final String DP_CONTACT_OTHERS = "BXXX";
  public final String DP_CONTACT_METHOD = "LST";
  public final String DP_CONTACT_PURPOSE = "BFND";
  public final String DP_CONTACT_TYPE = "ANOT";
  public final String DP_EVENT_TASK = "";
  public final String DP_EVENT_STATUS = "COMP";
  public final String DP_EVENT_TYPE = "NOT";
  public final String DP_EVENT_DESCRIPTION = "Investigation Notice to Des Perp Form";

}