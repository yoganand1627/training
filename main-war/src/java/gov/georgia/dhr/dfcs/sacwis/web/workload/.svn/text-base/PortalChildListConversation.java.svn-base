package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD31SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;


/**
 * This is the Conversation class used to display the children in the care of a resource worker page
 * when logging into the SHINES Vendor Portal.
 *
 * @author
 * Patrick Coogan, October 2009
 *
 *  Change History:
 *  Date        User              Description
 *  --------    ---------------    --------------------------------------------------
 *  11/12/09    Patrick Coogan     Added comments as a part of the implementation of
 *                                 the ECEM SHINES vendor portal.
 */


public class PortalChildListConversation extends BaseHiddenFieldStateConversation {

  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }
//static constants
  public static final String TRACE_TAG = "PortalChildListConversation";
  
  public static final int PAGE_SIZE = 100;
  public static final String SORT_O = "O";
  public static final String SORT_P = "P";
  public static final String SORT_E = "E";
  public static final String SORT_C = "C";
  public static final String SORT_R = "R";
  
  /**
   * *************************************************************************** 
   * Activity method to display the list of all children assigned to a user
   * when the user logs into the SHINES Vendor Portal at the top level.
   *
   * @param context Contains the session, state, and request objects to get data 
   * from jsps
   *                
   ****************************************************************************
   */
  public void displayChildListAll_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayChildListAll_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);
    
    //We are at top level - clear global data 
    if (!("".equals(GlobalData.getUlIdParentRsrcAsString(request))))
    {
      GlobalData.setUlIdParentRsrc(0,request);
    }
    
    if (!("".equals(GlobalData.getUlIdResourceAsString(request))))
    {
      GlobalData.setUlIdResource(0,request);
    }
        
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

      //The GlobalData context is use to decide what list of children to show, helped
      //by which activity method for this page is called.
      CFAD31SI cfad31si = populateCFAD31SI_RETRIEVE(context, tuxPagination, sortBy, "", "");
      
      PlacementLogSO placementLogSO = resource.retrieveLog(cfad31si);
      CFAD31SO cfad31so = placementLogSO.getCfad31so();
      /* place the service object and the indicator for an incomplete DPS row in the request;
            the service object contains the rows displayed on the list page;*/
      request.setAttribute("CFAD31SO", cfad31so);

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
    
  }
  
  /**
   * *************************************************************************** 
   * Activity method to display the children assigned to a user
   * when the user chooses a specific resource within the SHINES vendor portal.
   *
   * @param context Contains the session, state, and request objects to get data 
   * from jsps
   *                
   ****************************************************************************
   */
  public void displayChildList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayChildList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    
    String idRsrcParent = ContextHelper.getStringSafe(request, "hdnUlIdRsrcParent");
    String idRsrcChild = ContextHelper.getStringSafe(request, "hdnUlIdRsrcChild");

    if ("".equals(idRsrcParent)){
      idRsrcParent = GlobalData.getUlIdParentRsrcAsString(request);
    }
    
    if ("".equals(idRsrcChild)){
      idRsrcChild = GlobalData.getUlIdResourceAsString(request);
    }
    
    if (!("".equals(idRsrcChild))){
      GlobalData.setUlIdResource(Integer.parseInt(idRsrcChild),request);
    }
    
    if (!("".equals(idRsrcParent))){
      GlobalData.setUlIdParentRsrc(Integer.parseInt(idRsrcParent),request);
    }
    
    if (("".equals(idRsrcParent) && "".equals(idRsrcChild))||("0".equals(idRsrcParent) && "0".equals(idRsrcChild))){
      super.setPresentationBranch("all", context);   
    }
    
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

      CFAD31SI cfad31si = populateCFAD31SI_RETRIEVE(context, tuxPagination, sortBy, idRsrcParent, idRsrcChild);
         
      PlacementLogSO placementLogSO = resource.retrieveLog(cfad31si);
      CFAD31SO cfad31so = placementLogSO.getCfad31so();
    
      request.setAttribute("CFAD31SO", cfad31so);

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
    
  }

  private CFAD31SI populateCFAD31SI_RETRIEVE(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination,
                                             String sortBy, String idRsrcParent, String idRsrcChild)
           {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCFAD31SI_RETRIEVE()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CFAD31SI cfad31si = new CFAD31SI();
    ROWCFAD31SIG00_ARRAY rowcfad31sig00Array = new ROWCFAD31SIG00_ARRAY();
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);

    List<Integer> assignedResources = new ArrayList<Integer>();
    
    //If we have data from GlobalData we will use it to set the list of children to be 
    //seen.  Otherwise we will decide to show all children for resources to which the user 
    //is assigned
    if (!("".equals(idRsrcChild)||"0".equals(idRsrcChild))){
      
      assignedResources.add(Integer.valueOf(idRsrcChild));
           
    } else if (!("".equals(idRsrcParent)||"0".equals(idRsrcParent))){
      
      assignedResources.add(Integer.valueOf(idRsrcParent));

    } else {
      
      UserProfile user = UserProfileHelper.getUserProfile(request);
      Map<Integer, String> rsrcMap = new HashMap<Integer, String>();
      rsrcMap = user.getRsrcMap();
      
      assignedResources.addAll(rsrcMap.keySet());
    
    }
    
    for (Iterator<Integer> it = assignedResources.iterator(); it.hasNext();) {
      
      ROWCFAD31SIG00 rowcfad31sig00 = new ROWCFAD31SIG00();
      rowcfad31sig00.setUlIdResource(it.next());
      rowcfad31sig00Array.addROWCFAD31SIG00(rowcfad31sig00);
      
    }
    
    cfad31si.setArchInputStruct(input);
    // set the sort value, id resource and id stage in the service
    cfad31si.setBWcdCdSortBy(sortBy);
    cfad31si.setIndSystem("P");
    cfad31si.setROWCFAD31SIG00_ARRAY(rowcfad31sig00Array);
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return cfad31si;
    
  }  // end populateCFAD31SI_RETRIEVE

  
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
      //case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      //  this.setPresentationBranch("error", context);
      //  String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      //  setErrorMessage(errorMessage1, "/workload/PortalChildList/displayChildList", request);
      //  break;
      case Messages.SQL_NOT_FOUND:
        // handled by the JSP - No results returned
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

}
