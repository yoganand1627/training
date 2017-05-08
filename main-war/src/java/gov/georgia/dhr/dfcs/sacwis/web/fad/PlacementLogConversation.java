package gov.georgia.dhr.dfcs.sacwis.web.fad;



import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenMapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.resource.FacilityConversation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;


/********************************************************************************
 **  Put in comments about your conversation
 ********************************************************************************/

/**
 * This is the Conversation class used to search for resources from the Resource Search page
 * and refine a search, conduct a new search, and display selected list from the Resource List page.
 *
 * @author
 * Katy Laura, Feb 24, 2003
 *
 *  Change History:
 *  Date        User              Description
 *  --------    ---------------    --------------------------------------------------
 *  6/29/04    gerryc              SIR 19651 - changed the results
 *                                to show 100 per page instead of 10.
 *  9/12/11    charden             STGAP00017058 - updated transport object to PlacementLogSO for easier transport
 *  9/16/11    charden             STGAP00017058 - modified populateCFAD31SI_RETRIEVE to handle forward from placement information page
 */

/**
 * ***************************************************************************** *  Declare your conversation class and
 * have it extend *  BaseHiddenFieldStateConversation class. ******************************************************************************
 */

public class PlacementLogConversation extends BaseHiddenFieldStateConversation {

  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }
//static constants
  public static final String TRACE_TAG = "PlacementLogConversation";
  public static final String RESOURCE_TYPE_ATTRIBUTE_NAME = "resourceType";
  public static final String FACILITY_TYPE_ATTRIBUTE = "szCdRsrcFacilType";

  public static final int PAGE_SIZE = 100; //SIR 19651 changed from 10 to 100
  public static final String SORT_O = "O";
  public static final String SORT_P = "P";
  public static final String SORT_E = "E";
  public static final String SORT_C = "C";
  public static final String SORT_R = "R";
  //........etc........
  /**
   * *************************************************************************** Process - initial display of Placement
   * Log is sorted by dt_plcmnt_end, descending dt_plcmnt_start, descending.  This will show open placements (
   * placements where dt_plcmnt_end is null or 12/31/4712 ) first.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   *                ***************************************************************************
   */
  public void displayPlacementLog_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPlacementLog_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    String isReqFromPlacementInfo = (String) request.getAttribute("placementInfo");
    if(isReqFromPlacementInfo != null){
      // change the info parameter of the screen
      try {
        Screen screen = ScreenMapping.getScreenData(context);
        screen.setParameter("Info1", "Resource Name", false);
      } catch (ServletException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    // Get facility info out of state temporarily so that it can be put back
    // into state after state is cleared below.
    String facilityType = (String) state.getAttribute(FACILITY_TYPE_ATTRIBUTE, request);
    String facilityId = (String) state.getAttribute(FacilityConversation.FACILITY_ID_FIELD_NAME,
                                                    request); // RIOSJA, SIR 22521
    String resourceType = (String) state.getAttribute(RESOURCE_TYPE_ATTRIBUTE_NAME, request);
    String resourceContact = (String) state.getAttribute(FacilityConversation.RESOURCE_CONTACT_FIELD_NAME, request);

    // clear state at the beginning of the conversation
    state.removeAllAttributes(request);

    if (facilityType != null) // SPB SIR fix 18437
    {
      state.setAttribute(FACILITY_TYPE_ATTRIBUTE, facilityType, request);
    }
    if (facilityId != null) // RIOSJA, SIR 22521
    {
      state.setAttribute(FacilityConversation.FACILITY_ID_FIELD_NAME, facilityId, request);
    }
    if (resourceContact != null) // RIOSJA, SIR 22521
    {
      state.setAttribute(FacilityConversation.RESOURCE_CONTACT_FIELD_NAME, resourceContact, request);
    }
    state.setAttribute(RESOURCE_TYPE_ATTRIBUTE_NAME, resourceType, request);

    // paginate
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);

    try {
      String sortBy = tuxPagination.getResultDetails().getOrderBy();
      if (sortBy == null) {
        sortBy = SORT_O;
      }

      //state.setAttribute("pageMode", pageMode, request);
      
      // Set the page mode into State
      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      CFAD31SI cfad31si = populateCFAD31SI_RETRIEVE(context, tuxPagination, sortBy);
      //CFAD31SO cfad31so = CFAD31SO.unmarshal(new StringReader(WtcHelper.callService("CFAD31S", cfad31si)));
      
      //STGAP00017058
      PlacementLogSO placementLogSO = resource.retrieveLog(cfad31si);
      CFAD31SO cfad31so = placementLogSO.getCfad31so();
      /* place the service object and the indicator for an incomplete DPS row in the request;
            the service object contains the rows displayed on the list page;*/
      request.setAttribute("CFAD31SO", cfad31so);
      request.setAttribute("placementLogSO", placementLogSO);

      //set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(cfad31so.getArchOutputStruct(),
                                             cfad31so.getCFAD31SOG00_ARRAY().getCFAD31SOG00Count());

      super.storePaginationBeanToRequest(context, tuxPagination);
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      processSevereException(context, ve);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * *********************************************************************************** This helper method populates
   * rows for a display of rows in the Placement Log list *  @param context The GrndsExchangeContext object
   * ************************************************************************************
   */
  private CFAD31SI populateCFAD31SI_RETRIEVE(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination,
                                             String sortBy)
           {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCFAD31SI_RETRIEVE()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CFAD31SI cfad31si = new CFAD31SI();
    ROWCFAD31SIG00 rowcfad31sig00 = new ROWCFAD31SIG00();
    ROWCFAD31SIG00_ARRAY rowcfad31sig00Array = new ROWCFAD31SIG00_ARRAY();
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);

    cfad31si.setArchInputStruct(input);
    // set the sort value, id resource and id stage in the service
    cfad31si.setBWcdCdSortBy(sortBy);
    
    // Start STGAP00017058 - check to see if resource id has been forwarded from placement link on placement information page
    String forwardedIdResource = (String) request.getAttribute("frwdIdResource");
    if(forwardedIdResource != null && !"".equals(forwardedIdResource)){
      rowcfad31sig00.setUlIdResource(Integer.parseInt(forwardedIdResource));
    }else{
      rowcfad31sig00.setUlIdResource(GlobalData.getUlIdResource(request));
    }
    // End STGAP00017058
    
    rowcfad31sig00Array.addROWCFAD31SIG00(rowcfad31sig00);
    cfad31si.setIndSystem("S");
    cfad31si.setROWCFAD31SIG00_ARRAY(rowcfad31sig00Array);
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cfad31si;

  }  // end populateCFAD31SI_RETRIEVE

  /**
   * ************************************************************************************* This helper method handles
   * all the WTC Exceptions thrown by this conversation **************************************************************************************
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        this.setPresentationBranch("error", context);
        String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
        setErrorMessage(errorMessage1, "/fad/PlacementLog/displayPlacementLog", request);
        break;
      case Messages.SQL_NOT_FOUND:
        // handled by the JSP - No results returned
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  

}
