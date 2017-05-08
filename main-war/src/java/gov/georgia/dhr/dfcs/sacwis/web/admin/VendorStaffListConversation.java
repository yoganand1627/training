package gov.georgia.dhr.dfcs.sacwis.web.admin;

import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListSO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This conversation is used to display the Vendor Staff List and Pending 
 * Vendor Staff list pages within the SHINES Vendor Portal.
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 11/10/09  Patrick Coogan    Updated comments for original construction to support
 *                             the ECEM SHIENS vendor portal.
 * </pre>
 */
public class VendorStaffListConversation extends BaseHiddenFieldStateConversation {

  private Common common;

  public void setCommon(Common common) {
    this.common = common;
  }

  // static constants
  public static final String TRACE_TAG = "VendorStaffListConversation";

  private static final int PAGE_SIZE = 20;
  
  //These are used to perform the correct search for the different views of the page
  private static final String PORTAL_STAFF_LIST = "portalActive";
  private static final String PORTAL_PENDING_STAFF_LIST = "portalPending";
  //Note: the following are only used in SHINES
  private static final String SHINES_STAFF_LIST = "shinesActive";
  private static final String SHINES_PENDING_STAFF_LIST = "shinesPending";
  private static final String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  
  /**
   * Activity method to display the active vendor staff list in SHINES Portal
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayVendorStaffList_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayVendorStaffList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Note: page mode does not actually matter for this list page
    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    // paginate
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);

    try {

      PageMode.setPageMode(GlobalData.getAppMode(request), request);
      
      //Set this based on the activity method so we perform the right search
      String cdSearchType = PORTAL_STAFF_LIST;
      
      //Call a common helper method to populate the SI object
      RetrieveVendorStaffListSI retrieveVendorStaffListSI = populateRetrieveVendorStaffListSI(context, cdSearchType, tuxPagination);
      
      RetrieveVendorStaffListSO retrieveVendorStaffListSO = common.retrieveVendorList(retrieveVendorStaffListSI);
      
      request.setAttribute("retrieveVendorStaffListSO", retrieveVendorStaffListSO);
      request.setAttribute("screenName",PORTAL_STAFF_LIST);
      // Reset the Staff ID in Global Data in order for not to display the third level tab
      GlobalData.setUlIdStaff(0, request);
      // set the information into the pagination bean and then store it to
      // the request
      tuxPagination.setPaginationInformation(retrieveVendorStaffListSO.getArchOutputStruct(),
                                             retrieveVendorStaffListSO.getVendorStaffList().size());

      super.storePaginationBeanToRequest(context, tuxPagination);
    } catch (ServiceException we) {
      // handleError(we, context);
    } catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      processSevereException(context, ve);
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Activity method to display the pending vendor staff list in SHINES Portal
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayPendingVendorStaffList_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPendingStaffList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    // paginate
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);

    try {

      PageMode.setPageMode(GlobalData.getAppMode(request), request);
      
      String cdSearchType = PORTAL_PENDING_STAFF_LIST;
      RetrieveVendorStaffListSI retrieveVendorStaffListSI = populateRetrieveVendorStaffListSI(context,
                                                                                              cdSearchType, tuxPagination);

      RetrieveVendorStaffListSO retrieveVendorStaffListSO = common.retrieveVendorList(retrieveVendorStaffListSI);
      /*
       * place the service object and the indicator for an incomplete DPS row in the request; the service object
       * contains the rows displayed on the list page;
       */
      request.setAttribute("retrieveVendorStaffListSO", retrieveVendorStaffListSO);
      request.setAttribute("screenName",PORTAL_PENDING_STAFF_LIST);
      // Reset the Staff ID in Global Data in order for not to display the third level tab
      GlobalData.setUlIdStaff(0, request);
      // set the information into the pagination bean and then store it to
      // the request
      tuxPagination.setPaginationInformation(retrieveVendorStaffListSO.getArchOutputStruct(),
                                             retrieveVendorStaffListSO.getVendorStaffList().size());

      super.storePaginationBeanToRequest(context, tuxPagination);
    } catch (ServiceException we) {
      // handleError(we, context);
    } catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      processSevereException(context, ve);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  
  private RetrieveVendorStaffListSI populateRetrieveVendorStaffListSI(GrndsExchangeContext context,
                                                                      String cdSearchType,
                                                                      TuxedoPaginationValueBean tuxPagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateRetrieveVendorStaffListSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    RetrieveVendorStaffListSI retrieveVendorStaffListSI = new RetrieveVendorStaffListSI();

    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);

    //Set the user equal to the current user ID
    UserProfile user = UserProfileHelper.getUserProfile(request);
    Integer idUser = user.getUserID();
    
    //The following code creates the list of resource for which the 
    //portal user is an assigned administrator.  This controls the persons
    //which will be seen on the pages when called via portal.
    Map<Integer, String> rsrcMap = new HashMap<Integer, String>();
    rsrcMap = user.getRsrcMap();
    
    List<Integer> vendorStaffList = new ArrayList<Integer>();
    List<Integer> adminList = new ArrayList<Integer>();
    
    vendorStaffList.addAll(rsrcMap.keySet());
    for(Iterator<Integer> it = vendorStaffList.iterator();it.hasNext();){
      
      Integer resourceId = it.next();
      String userType = rsrcMap.get(resourceId);
    
      if (CodesTables.CUSRTYP_PAD.equals(userType)){
        adminList.add(resourceId); 
      }
    }
    
    retrieveVendorStaffListSI.setIdUser(idUser);
    retrieveVendorStaffListSI.setAdminList(adminList);
    retrieveVendorStaffListSI.setCdSearchType(cdSearchType);
    retrieveVendorStaffListSI.setIdUser(idUser);
    retrieveVendorStaffListSI.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return retrieveVendorStaffListSI;
  }
}