//*  JSP Name:     Incoming Person Detail Conversation
//*  Created by:   Michael Ochu
//*  Date Created: 02/05/2003
//*
//*  Description:
//*  The Incoming Person detail page allows a user to view  a related person original
//*  information. Four submodule namely person identifier, name history, address and phone lists
//*  are called on this page.  This page is in view mode at all times.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
package gov.georgia.dhr.dfcs.sacwis.web.intake;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/**
 * This is the Conversation class used to display incoming person information. There are four submodules person
 * identifier, name history, address list and phone list. Each submodule display information on the incoming person
 *
 * @author Michael Ochu, Feb. 05, 2003
 */
public class IncomingPersonDetailConversation
        extends BaseHiddenFieldStateConversation {

  private Intake intake = null;

  public void setIntake(Intake intake) {
    this.intake = intake;
  }

  /**
   * This method is called by the GRNDS controller to display the incoming person information.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayIncomingPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, ".displayIncomingPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      CINT34SI cint34si = populateCINT34SI_Retrieve(context);

      CINT34SO cint34so = intake.retrieveIncomingPersonDetail(cint34si);

      request.setAttribute("CINT34SO", cint34so);
      /* Put the data needed by the submodeles in to the Global data */
      // JMC - 040903 - Commented out the line of code that set App Mode to CAPS_WIN_MODE_INCMG
      // Added code that would set PageMode.setPageMode to VIEW
      //GlobalData.setAppMode(CAPS_WIN_MODE_INCMG, request);
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      GlobalData.setSzNmPersonFull(cint34so.getROWCINT51DO().getSzNmIncmgPersFull(), request);
      GlobalData.setUlIdPerson(cint34so.getROWCINT51DO().getUlIdPerson(), request);
    }
    catch (ServiceException we) {
      handleServiceError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the displayIncomingPersonDetail_xa to populate the input object for the cint34s
   * retrieve service.
   *
   * @param context The GrndeExchangeContext object.
   */
  public static CINT34SI populateCINT34SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "populateCINT34SI_Retrieve");

    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    ArchInputStruct input = new ArchInputStruct();
    CINT34SI cint34si = new CINT34SI();
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(1);
    input.setSzUserId(userProfile.getUserLogonID());
    cint34si.setArchInputStruct(input);
    cint34si.setUlIdStage(GlobalData.getUlIdStage(request));
    cint34si.setUlIdPerson(GlobalData.getUlIdPerson(request));

    performanceTrace.exitScope();
    return cint34si;
  }

  /**
   * This helper method handles all the WTC Exceptions thrown by the service.
   *
   * @param WtcException and context The GrndeExchangeContext object.
   */
  private void handleServiceError(ServiceException we, GrndsExchangeContext context) {
    switch (we.getErrorCode()) {
      case Messages.SQL_NOT_FOUND:
        break;
      case Messages.MSG_NO_ROWS_RETURNED:
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  public static final String TRACE_TAG = "IncomingPersonDetailConversation";
}
