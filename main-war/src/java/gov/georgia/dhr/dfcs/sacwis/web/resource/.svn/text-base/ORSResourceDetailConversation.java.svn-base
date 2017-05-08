package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAdverseActionSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAllegationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSComplaintSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to view for resource ors detail from <p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------    --------  --------------------------------------------------
    01/30/2009  mxpatel   STGAP00010438: added code for implementing pagination
 * </pre>
 * 
 * @author mchillman
 */

public class ORSResourceDetailConversation extends BaseHiddenFieldStateConversation {
  
  public static final String ORS_DETAIL_ATTRIBUTE_NAME = "ORSResourceDetail";
  public static final String ORS_COMPLIANT_LIST_ATTRIBUTE_NAME = "ORScomplaintList";
  public static final String ORS_COMPLIANT_ATTRIBUTE_NAME = "ORScomplaint";
  public static final String ORS_ADVERSE_ACTIONS_LIST_ATTRIBUTE_NAME = "ORSAdverseActionList";
  public static final String ORS_ALLEGATION_LIST_ATTRIBUTE_NAME = "ORSAllegationList";
  public static final String ORS_ADVERSE_ACTION_ATTRIBUTE_NAME = "ORSAllegationList";
  
  // mxpatel added this for defect #10438
  public static final int MAX_PAGE_RESULTS = 50;
  
  protected static final String TRACE_TAG = "ORSResourceDetailConversation";
  public static final String ORS_RESOURCE_ID_FIELD_NAME = "txtORSFacId";
  public static final String RESOURCE_DETAIL = "/resource/ResourceDetail/newResource";
  
  Resource resource = null;
  
  public void setResource(Resource resource) {
    this.resource = resource;
  }

  public void displayResourceDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayResourceDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    //if forwarded from the list page ORS_RESOURCE_ID_FIELD_NAME will be populated 
    //else forwarded from the complaint adverse action or resource detail page
    String facilityId = ContextHelper.getStringSafe(context, ORS_RESOURCE_ID_FIELD_NAME);
    if("".equals(facilityId)) {
      facilityId = GlobalData.getSzNmORSResource(request);
    } else {
      GlobalData.setSzNmORSResource(facilityId, request);
    }
    
    //mxpatel added this for defect 10438
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();//mxpatel
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);//mxpatel
    tuxPagination.getResultDetails().setResultsPerPage(MAX_PAGE_RESULTS);//mxpatel
   
    ORSResourceDetailSO orsResDetail = new ORSResourceDetailSO();//mxpatel
  
    int pageNbr = tuxPagination.getResultDetails().getRequestedPage();//mxpatel
    int pageSize = tuxPagination.getResultDetails().getResultsPerPage();//mxpatel
   
    orsResDetail = retrieveORSResourceDetail(facilityId, pageNbr, pageSize);//mxpatel
  
    state.setAttribute(ORS_DETAIL_ATTRIBUTE_NAME, orsResDetail, request);
    
    String pageMode = getPageMode(request, orsResDetail);
    PageMode.setPageMode(pageMode, request);

    try{
    if(orsResDetail != null){
    tuxPagination.setPaginationInformation(orsResDetail.getArchOutputStruct(),orsResDetail.getComplaints().size() );
    request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
    
    storePaginationBeanToRequest(context, tuxPagination);
    }
    }catch (Exception e) {
      // TODO: handle exception
    }
    
    performanceTrace.exitScope();
  }
  
  public void addORSResourceToShines_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addORSResourceToShines_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      forward(ORSResourceDetailConversation.RESOURCE_DETAIL, request, context.getResponse());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    
    performanceTrace.exitScope();
  } 
  
  public void displayComplaintDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayComplaintDetail_xa");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    int compliantIndex = ContextHelper.getIntSafe(context, "txtCompliantRowId");
    ORSResourceDetailSO orsResDetail = (ORSResourceDetailSO) state.getAttribute(ORS_DETAIL_ATTRIBUTE_NAME, request);
    if(orsResDetail != null && compliantIndex > 0) {
      ORSComplaintSO complaint = orsResDetail.getComplaints().get(compliantIndex - 1);
      state.setAttribute(ORS_COMPLIANT_ATTRIBUTE_NAME, complaint, request);
      
      List<ORSAllegationSO> allegationsList = retrieveORSAllegation(complaint.getSzNmItake());
      state.setAttribute(ORS_ALLEGATION_LIST_ATTRIBUTE_NAME, allegationsList, request);
    }
    performanceTrace.exitScope();
  }
  
  public void displayAdverseActionDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdverseActionDetail_xa");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    int adverseActionIndex = ContextHelper.getIntSafe(context, "txtAdverseActionRowId");
    ORSResourceDetailSO orsResDetail = (ORSResourceDetailSO) state.getAttribute(ORS_DETAIL_ATTRIBUTE_NAME, request);
    if(orsResDetail != null && adverseActionIndex > 0) {
      ORSAdverseActionSO adverseAction = orsResDetail.getAdverseActions().get(adverseActionIndex - 1);
      state.setAttribute(ORS_ADVERSE_ACTION_ATTRIBUTE_NAME, adverseAction, request);
    }
    performanceTrace.exitScope();
  }
    
  public void pullBackResourceDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".pullBackResourceDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ResourceSearchPullBackInfo resourceSearchPullBackInfo = (ResourceSearchPullBackInfo) request
                                                                                                .getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    String returnUrl = resourceSearchPullBackInfo.getDestinationUrl();
    request.setAttribute("destinationUrl", returnUrl);

    performanceTrace.exitScope();
  } 
  
  // mxpatel added this for defect #10438
  private ORSResourceDetailSO retrieveORSResourceDetail(String facilityId, int pageNbr, int pageSize) {
    return resource.retrieveORSFacilityDetail(facilityId, pageNbr, pageSize);
  } 
  
  private ORSResourceDetailSO retrieveORSResourceDetail(String facilityId) {
    return resource.retrieveORSFacilityDetail(facilityId);
  } 
  
  private List<ORSAllegationSO> retrieveORSAllegation(String compliantId) {
   return resource.retrieveORSAllegations(compliantId);   
  }
  
  protected String getPageMode(HttpServletRequest request, ORSResourceDetailSO orsDetail) {
    String pageMode = PageModeConstants.VIEW;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      // Check if user has Maintain Resource rights.
      pageMode = userProfile.hasRight(UserProfile.SEC_ASSOCIATE_ORS_SHINES) == true ? PageModeConstants.EDIT : PageModeConstants.VIEW ;
    }
    GrndsTrace.msg(TRACE_TAG, 7, "getPageMode() - The page mode is: " + pageMode);
    return pageMode;
  }
}
