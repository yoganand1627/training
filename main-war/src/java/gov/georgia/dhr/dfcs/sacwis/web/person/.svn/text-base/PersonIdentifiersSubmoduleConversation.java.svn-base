/**
 * User: mkw
 * Date: Dec 9, 2002
 */

package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * PersonIdentifiers Submodule Conversation Class
 * <p>
 * Description: This conversation exists solely to display the Person Identifiers list in other pages as a submodule;
 * because the service that is used to do this (CINT19S) is also used by the conversation that displays the detail page,
 * this conversation extends and uses a method from PersonIdentifiersConversation to do the bulk of its display.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Michael Werle
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PersonIdentifiersSubmoduleConversation extends PersonIdentifiersConversation {
  /**
   * This method does the display of the Person Identifiers list that appears when it is included as a submodule; it
   * uses getCINT14WLB_ARRAY from its superclass to get this object out of request or call CINT19S to generate it, if it
   * is missing from state. CINT19S requires only that
   * 
   * @param context
   */

  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  /*
   * private RetrievePersonIdentifiers retrievePersonIdentifiers; public void
   * setRetrievePersonIdentifiers(RetrievePersonIdentifiers retrievePersonIdentifiers) { this.retrievePersonIdentifiers =
   * retrievePersonIdentifiers; }
   */

  public void displayPersonIDsListSubmodule_xa(GrndsExchangeContext context) {
    // Turn on the performance tracing
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonIDsListSubmodule_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    GrndsTrace.enterScope(TRACE_TAG + ".displayPersonIDsListSubmodule_xa()");

    HttpServletRequest request = context.getRequest();

    String localPageMode = (String) request.getAttribute(PAGE_MODE_KEY);

    if (localPageMode == null || "".equals(localPageMode)) {
      localPageMode = PageModeConstants.VIEW;

    }

    state.setAttribute(PAGE_MODE_KEY, localPageMode, request);

    // set the cint14_array into the request
    getCINT14WLB_ARRAY(context, person);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public static final String TRACE_TAG = "PersonIdentifiersSubmoduleConversation";

  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";
}
