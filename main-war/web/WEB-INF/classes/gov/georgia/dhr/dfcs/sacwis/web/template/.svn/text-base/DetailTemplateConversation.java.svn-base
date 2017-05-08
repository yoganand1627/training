package gov.georgia.dhr.dfcs.sacwis.web.template;

import java.beans.IntrospectionException;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SOG04_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

/**
 * This is the Conversation class used to search for resources from the Resource Search page and refine a search,
 * conduct a new search, and display selected list from the Resource List page.
 * <p/>
 * Declare your conversation class and have it extend BaseHiddenFieldStateConversation class.
 * <p/>
 * Note that the "<code>&lt;pre&gt;</code>" tag below is necessary to prevent the change history from being reformatted
 * by code formatting tools.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * </pre>
 */
public class DetailTemplateConversation extends BaseHiddenFieldStateConversation {

  /**
   * The CLASSNAME_TAG constant is used to mark log records in GRNDS tracing; most classes should have it.
   * <p/>
   * Other static constants should be put just below this.
   */
  public static final String TRACE_TAG = "DetailTemplateConversation";

  /**
   * Create a private field for each service EJB used.
   * <p/>
   * <i>Please make sure that they are in alphabetical order!</i>
   */
  private Resource resource = null;

  /**
   * Create a public setter for each service EJB used.
   * <p/>
   * <i>Please make sure that they are in alphabetical order!</i>
   *
   * @param resource
   */
  public void setResource(Resource resource) {
    this.resource = resource;
  }

  /**
   * Blank method just to show general pattern of a Activity Method, including naming standards, etc.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void doSomething_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".doSomething_xa()");
    performanceTrace.enterScope();

    //Add Business Logic HERE (see exampleServiceCall_xa below for example code)

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Another blank example method. Used as a dummy method for the DetailTemplate.jsp
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void exampleSave_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".save_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    //Add Business Logic HERE (see exampleServiceCall_xa below for example code)

    // example of how to get data back form a saved AdminAddressPhoneSub.jsp submodule
    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest("first", request);
    AddressBean aBean = AddressBean.getFromRequest("second", request);

    // example of how to get data back form a saved RaceEthnicitySub.jsp submodule
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    RaceEthnicityBean.Races races = reBean.getRaces();
    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Another blank example method. Used as a dummy method for the DetailTemplate.jsp
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void exampleAdd_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".add_xa()");
    performanceTrace.enterScope();

    //Add Business Logic HERE (see exampleServiceCall_xa below for example code)

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Another blank example method. Used as a dummy method for the DetailTemplate.jsp
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void exampleDelete_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".delete_xa()");
    performanceTrace.enterScope();

    //Add Business Logic HERE (see exampleServiceCall_xa below for example code)

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Demonstrates the pattern for populating SI objects from the context. All population from the context (including
   * request, session, and state), should take place in private methods like this one. The method should instantiate the
   * input object, get values out of the context, and then return the SI object.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private CRES03SI populateCRES03SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCRES03SI_Retrieve");
    performanceTrace.enterScope();

    // Get the state and request objects, if necessary.
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // The input object.
    CRES03SI cres03si = new CRES03SI();

    // Populate the input object sub-structures from the request, then populate the input object form the request.
    // Use GlobalData when practical.
    cres03si.setUlIdResource(GlobalData.getUlIdResource(request));

    // HARDCODED so that the service returns a response: Delete this
    cres03si.setUlIdResource(10002484);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cres03si;
  }

  /**
   * Demonstrates an actual service call pattern. Populates CRES03SI, calls the service, and puts CRES03SO on the
   * request. Used as a retrieve method call for the DetailTemplate.jsp pattern of this method should be the general
   * pattern for all methods that call services.  A good description would be as follows:
   * <p/>
   * This service calls the RetrieveResourceDetail service to get details about a resource baseds on its id.  It
   * retrieves the id resource in question from GlobalData.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void exampleServiceCall_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayResourceList_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      // Create the input object.
      CRES03SI cres03si = populateCRES03SI_Retrieve(context);
      // Call the service method from the EJB interface.
      CRES03SO cres03so = resource.retrieveResourceDetail(cres03si);
      // Put output object on the request and return to the controller
      request.setAttribute("CRES03SO", cres03so);

      // This method shows how Race Ethnicity submodule data is populated
      populateRaceEthSubmodule(request);

      // This method shows how AdminAddressPhone submodule data is populated
      populateAdminAddressPhoneSubmodule(request);
    } catch (ServiceException se) {
      // switch the response based on the Service Returned Error Code
      switch (se.getErrorCode()) {
        case Messages.MSG_NO_DUP_LB_ROW:
          // Set a presentation branch to use a differnt JSP or header.
          setPresentationBranch("duplicateRecord", context);
          // Look up an error message.
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_DUP_LB_ROW);
          // Set an error message.
          setErrorMessage(errorMessage, "/resource/ResourceSearch/results", request);
          break;
        default:
          // Handle unknown errors.
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
          processSevereException(context, se);
          break;
      }
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private void populateRaceEthSubmodule(HttpServletRequest request) throws IntrospectionException {
    // Createing race and ethnicity data.  In a real conversation, this data would be returned from a service call.
    CINV04SOG03_ARRAY raceList = new CINV04SOG03_ARRAY();
    CINV04SOG03 raceData = new CINV04SOG03();
    raceData.setSzCdPersonRace(CodesTables.CRACE_HP);
    raceList.addCINV04SOG03(raceData);
    CINV04SOG04_ARRAY ethnicityList = new CINV04SOG04_ARRAY();
    CINV04SOG04 ethnicityData = new CINV04SOG04();
    ethnicityData.setSzCdPersonEthnicity(CodesTables.CINDETHN_NH);
    ethnicityList.addCINV04SOG04(ethnicityData);

    // Creating a RaceEthnicityBean, populating it, and adding it to the request
    RaceEthnicityBean raceEthnicityBean = new RaceEthnicityBean();
    raceEthnicityBean.setEthnicity(ethnicityList);
    raceEthnicityBean.setRaces(raceList);
    RaceEthnicityHelper.addToRequest(raceEthnicityBean, request);
  }

  private void populateAdminAddressPhoneSubmodule(HttpServletRequest request) {
    // This is an example; a real conversation would use user input and/or results from service calls to populate this.
    AdminAddressPhoneBean aapBean = new AdminAddressPhoneBean();
    aapBean.setAddressSubmoduleName("first");
    aapBean.setPhone("972-596-2345");
    aapBean.setPhoneExt("2121");
    aapBean.setAddress1("8524 Burnet");
    aapBean.setAddress2("315");
    aapBean.setCity("Austin");
    aapBean.setState("TX");
    aapBean.setZipAndSuff("75705-2323");
    aapBean.setCounty("005");
    aapBean.setComments("Moved here 10 years ago");
    aapBean.addToRequest(request);

    AddressBean abean = new AddressBean();
    abean.setAddressSubmoduleName("second");
    abean.setAddress1("666 Burnet");
    abean.setAddress2("777");
    abean.setCity("Houston");
    abean.setState("AZ");
    abean.setZipAndSuff("75705-2323");
    abean.setCounty("005");
    abean.setComments("Moved here 10 years ago");
    abean.addToRequest(request);
  }
}