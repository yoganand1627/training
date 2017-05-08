package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveFacAgencyHomesListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListSO;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

/**
 * This is the Conversation class used display the Facility/Agency and Homes List pages
 * within the SHINES Vendor Portal.
 *
 * @author
 * Patrick Coogan, October XX, 2009
 *
 *  Change History:
 *  Date        User              Description
 *  --------    ---------------   --------------------------------------------------
 *  11/09/09    Patrick Coogan    Updated comments sections
 *   
 */

public class FacAgencyHomesListConversation extends BaseHiddenFieldStateConversation {

  private Common common;

  public void setCommon(Common common) {
    this.common = common;
  }
//static constants
  public static final String TRACE_TAG = "FacAgencyHomesListConversation";
  private static final int PAGE_SIZE = 20;
  public static final String SORT_NAME = "Name";
  public static final String SORT_TYPE = "Type";
  public static final String SORT_CITY = "City";
  public static final String SORT_COUNTY = "County";
 
  
  /**
   * *************************************************************************** 
   * displayFacAgencyList_xa
   * 
   * Performs service calls to display the Facility/Agency List view of the page
   * within the SHINES VendorPortal
   * 
   * @param context
   ****************************************************************************
   */
  public void displayFacAgencyList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFacAgencyList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //This is view only page, pageMode means nothing
    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);
    
    //When we are on this view, we want to clear all resource data from GlobalData
    //as we are specifically on the page where this should not be set.  This data will be set
    //into GlobalData as we click on a resource from this page.
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
            
      PageMode.setPageMode(GlobalData.getAppMode(request), request);
      
      String sortBy = tuxPagination.getResultDetails().getOrderBy();
      if (sortBy == null) {
        sortBy = SORT_NAME;
      }
      
      RetrieveFacAgencyHomesListSI retrieveFacAgencyHomesListSI = populateRetrieveFacAgencyHomesListSI(context, sortBy, tuxPagination);
      
      RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesListSO = common.retrieveFacAgencyHomesList(retrieveFacAgencyHomesListSI);
     
      request.setAttribute("retrieveFacAgencyHomesListSO", retrieveFacAgencyHomesListSO);

      //set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(retrieveFacAgencyHomesListSO.getArchOutputStruct(),
                                             retrieveFacAgencyHomesListSO.getFacilityAgencyList().size());

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
   * displayHomesList_xa
   * 
   * Performs service calls to display the Homes view of the page
   * within the SHINES Vendor Portal to display homes currently assigned to a CPA
   * 
   * @param context
   ****************************************************************************
   */
  
  
  public void displayHomesList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomesList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Page mode has no meaning; setting to Edit by default
    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    //When we are on the homes list, the GlobalData.ulIdResource should not be set as this is
    //the resource ID of an individual home selected by clicking a hyperlink off of this page
    if (!("".equals(GlobalData.getUlIdResourceAsString(request))))
    {
      GlobalData.setUlIdResource(0,request);
    }
    
    // paginate
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);

    try {
            
      PageMode.setPageMode(GlobalData.getAppMode(request), request);
 
      String sortBy = tuxPagination.getResultDetails().getOrderBy();
      if (sortBy == null) {
        sortBy = SORT_NAME;
      }
      
      RetrieveFacAgencyHomesListSI retrieveFacAgencyHomesListSI = populateRetrieveFacAgencyHomesListSI(context, sortBy, tuxPagination);
      
      RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesListSO = common.retrieveFacAgencyHomesList(retrieveFacAgencyHomesListSI);
      
      request.setAttribute("retrieveFacAgencyHomesListSO", retrieveFacAgencyHomesListSO);

      
      if (retrieveFacAgencyHomesListSO != null) {
      //set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(retrieveFacAgencyHomesListSO.getArchOutputStruct(),
                                             retrieveFacAgencyHomesListSO.getFacilityAgencyList().size());

      super.storePaginationBeanToRequest(context, tuxPagination);
      }
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
   * *********************************************************************************** 
   * This helper method populates the RetrieveFacAgencyHomesListSI service input object
   * for display of the page
   *  
   * @param context The GrndsExchangeContext object
   * ************************************************************************************
   */
  private RetrieveFacAgencyHomesListSI populateRetrieveFacAgencyHomesListSI(GrndsExchangeContext context, String sortBy, TuxedoPaginationValueBean tuxPagination)
           {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateRetrieveFacAgencyHomesListSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    RetrieveFacAgencyHomesListSI retrieveFacAgencyHomesListSI = new RetrieveFacAgencyHomesListSI();
    
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);
    
    retrieveFacAgencyHomesListSI.setCdSortBy(sortBy);

    //If we are on the homes list, get the agency ID out of the GlobalData, previously selected
    //by drilling down from the Facility/Agency List
    String idRsrcParent = GlobalData.getUlIdParentRsrcAsString(request);
    
    if(!("".equals(idRsrcParent))){
      retrieveFacAgencyHomesListSI.setIdParentRsrc(Integer.parseInt(idRsrcParent));
    } else {
      //Set to 0 when not populated, this powers logic within the service and DAO
      retrieveFacAgencyHomesListSI.setIdParentRsrc(0);
    }
    
    //Get the list of resources to which the user is currently assigned out of the
    //User Profile.  This is set at Login based off of the vendors to which the external user is
    //currently assigned.
    
    UserProfile user = UserProfileHelper.getUserProfile(request);
    Map<Integer, String> rsrcMap = new HashMap<Integer, String>();
    rsrcMap = user.getRsrcMap();
    
    List<Integer> assignedResources = new ArrayList<Integer>();
    
    assignedResources.addAll(rsrcMap.keySet());
    
    retrieveFacAgencyHomesListSI.setRsrcList(assignedResources);
    retrieveFacAgencyHomesListSI.setArchInputStruct(input);
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return retrieveFacAgencyHomesListSI;
    
  }  
  
  //We are not really using this in portal.
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        this.setPresentationBranch("error", context);
        String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
        setErrorMessage(errorMessage1, "/resource/FacAgencyHomesList/displayFacAgencyList", request);
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

}
