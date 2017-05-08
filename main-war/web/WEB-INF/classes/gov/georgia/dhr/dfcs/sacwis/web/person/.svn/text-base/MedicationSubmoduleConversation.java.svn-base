package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;


@SuppressWarnings("serial")
public class MedicationSubmoduleConversation extends MedicationDetailConversation {
  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * This method is called by the GRNDS controller when a user opens the Medication submodule
   * <p/>
   * <pre>
   *   Change History:
   *    Date      User      Description
   *    --------  --------  --------------------------------------------------
   * <p/>
   *   @param context The GrndsExchangeContext object.
   */
  public void displayMedication_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayMedication_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // Get the page mode that was passed to the submodule from the
      // including
      // JSP, and put it into state so the submodule...and possibly the
      // Medication Detail page...can use it. If no page mode was passed
      // in, use
      // the PageMode from state.
      String pageMode = PageMode.getPageMode(request);
      if (request.getAttribute(PAGE_MODE_KEY) != null) {
        pageMode = (String) request.getAttribute(PAGE_MODE_KEY);
      }
      state.setAttribute(PAGE_MODE_KEY, pageMode, request);

      String includingDisplayCommand =
              (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request);
      state.setAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, includingDisplayCommand, request);

      MedicationRetrieveSI medretsi = populateMedRetSI_Retrieve(context);
      MedicationRetrieveSO medretso = person.retrieveMedication(medretsi);
      state.setAttribute("MedicationRetrieveSO", medretso, request);

    } catch (Exception e) {
      handleException(e, context, "displayOutputLaunch_xa");
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called by the displayMedication_xa to populate the input object for the Medication retrieve
   * service.
   *
   * @param context The GrndeExchangeContext
   */

  private MedicationRetrieveSI populateMedRetSI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateMedRetSI_Retrieve");
    performanceTrace.enterScope();

    // Get the request object from context to make input data available to
    // this method
    HttpServletRequest request = context.getRequest();

    String indIntake = "N";
    if (request.getAttribute("intakeIndicator") != null) {
      indIntake = (String) request.getAttribute("intakeIndicator");
    } else {
      processSevereException(context, new RuntimeWrappedException(new Exception(NO_INTAKE_IND_ERROR)));
    }

    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    MedicationRetrieveSI medretsi = new MedicationRetrieveSI();

    // Set the values for the ArchInputStruct
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);

    // medretsi.setArchInputStruct(input);
    medretsi.setUlIdPerson(GlobalData.getUlIdPerson(request));
    medretsi.setBSysIndIntake(indIntake);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return medretsi;
  }
}
