package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

public class NameHistorySubmoduleConversation extends NameHistoryConversation {
  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";
  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * ************************************************************************** This method is called by the GRNDS
   * controller when a user opens the Name History submodule
   * <p/>
   * Code to include this submodule: <impact:include page="/submodule/NameHistorySubmoduleConversation/displayNameHistory"
   * callingPage="/test/NameHistorySubmodTest/display" tabindex="1" includingForm="frmNameHistSub"> <impact:attribute
   * name="intakeIndicator" value=" <%= bIntakeIndicator %>" /> </impact:include>
   * <p/>
   * where bIntakeIndicator has been set to a value of 'N' or 'Y'
   * <p/>
   * Note: If the intakeIndicator attribute is not included, an error will be displayed.
   * <p/>
   * <pre>
   * Change History:
   *  Date      User      Description
   *  --------  --------  --------------------------------------------------
   *  07/10/03  GRIMSHAN  SIR 18759 When saving a new primary name, and the old
   *                      name was longer than 26 characters, the save was failing
   *                      format the name before putting into global data.
   * <p/>
   * 07/01/05 PINKSTBA    SIR 23727 MPS Phase II.  Replaced ServiceException/WtxHelper
   *                      references with ServiceException/ServiceHelper references.*
   *
   * @param context The GrndsExchangeContext object. **************************************************************************
   */
  public void displayNameHistory_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayNameHistory_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // Get the page mode that was passed to the submodule from the including
      // JSP, and put it into state so the submodule...and possibly the Name
      // History Detail page...can use it. If no page mode was passed in, use
      // the PageMode from state.
      String pageMode = PageMode.getPageMode(request);
      if (request.getAttribute(PAGE_MODE_KEY) != null) {
        pageMode = (String) request.getAttribute(PAGE_MODE_KEY);
      }
      state.setAttribute(PAGE_MODE_KEY, pageMode, request);

      String includingDisplayCommand = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY,
                                                                   request);
      state.setAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, includingDisplayCommand, request);

      CINV25SI cinv25si = populateCINV25SI_Retrieve(context);
      //CINV25SO cinv25so = CINV25SO.unmarshal(new StringReader(ServiceHelper.callService("CINV25S", cinv25si)));
      CINV25SO cinv25so = person.retrievePersonNameInformation(cinv25si);
      state.setAttribute("CINV25SO", cinv25so, request);
      //Possibly, temporary until Integration is complete
      ROWCINV25SOG00_ARRAY nameRowArray = cinv25so.getROWCINV25SOG00_ARRAY();
      if (nameRowArray.getROWCINV25SOG00Count() > 0) {
        ROWCINV25SOG00 primaryName = nameRowArray.getROWCINV25SOG00(0); //the
        // primary
        // name
        // SIR 18759 GRIMSHAN -- Format the name before putting it into global
        // data so that
        // it will save when it is longer than 26 characters.
        String fullName = FormattingHelper.formatFullName(primaryName.getSzNmNameFirst(), primaryName
                .getSzNmNameMiddle(), primaryName.getSzNmNameLast());
        GlobalData.setSzNmPersonFull(fullName, request);
      }

    }
    catch (Exception e) {
      handleException(e, context, "displayOutputLaunch_xa");
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * ************************************************************************** This helper method is called by the
   * displayNameHistory_xa to populate the input object for the cinv25s retrieve service.
   *
   * @param context The GrndeExchangeContext **************************************************************************
   */

  private CINV25SI populateCINV25SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV25SI_Retrieve()");
    performanceTrace.enterScope();

    //Get the request object from context to make input data available to this
    // method
    HttpServletRequest request = context.getRequest();
    //SR-String callingPage = request.getParameter( "callingPage" );

    String indIntake = "N";
    if (request.getAttribute("intakeIndicator") != null) {
      indIntake = (String) request.getAttribute("intakeIndicator");
    } else {
      processSevereException(context, new RuntimeWrappedException(new Exception(NO_INTAKE_IND_ERROR)));
    }

    //Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CINV25SI cinv25si = new CINV25SI();

    //Set the values for the ArchInputStruct
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);

    cinv25si.setArchInputStruct(input);
    cinv25si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    cinv25si.setBSysIndIntake(indIntake);
    Calendar cal = Calendar.getInstance();
    cinv25si.setTsSysTsQuery(cal.getTime());
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cinv25si;
  }

}
