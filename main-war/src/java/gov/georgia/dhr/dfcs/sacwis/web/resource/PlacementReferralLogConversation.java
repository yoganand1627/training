package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralLogRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogRetrieveSO;

/**
 * This is a Conversation class to maintain the information specific to 
 * list of children to hold a space in Home or Facility. Placement Referral Log lists
 * the number of children currently scheduled for a placement in the home. In addition, the 
 * placement referral log maintains a history of all expired referrals. The list is sorted by
 * ascending status, then by ascending Begin Date, so that the first entered active referral to be 
 * displayed at the top.
 * 
 * @author lata.p.lokhande
 * 
 * <pre>
 *    &lt;p/&gt;
 *     Change History:
 *      Date      User      Description
 *     --------  --------  --------------------------------------------------
 *     02/12/2007 Lata Lokhande Coded a new Page for Release 2.
 *</pre>
 */
public class PlacementReferralLogConversation extends BaseHiddenFieldStateConversation {
  public static final int PAGE_SIZE = 50;

  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  public void displayPlacementReferralLog_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPlacementReferralLog_xa()");
    performanceTrace.enterScope();
    
    //define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    //create pagination bean, populate with default values and set the page size.
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
    
    String pageMode = GlobalData.getAppMode(request);
    state.setAttribute("PageMode", pageMode, request);
    
    //if we get the resourceId from GlobalData twice, the second time it was coming 0,
    //that's why I am taking it from state.
    int idResource = GlobalData.getUlIdResource(request);
    if(idResource == 0) {
      idResource = (Integer)state.getAttribute("idResource", request);
    }
    GlobalData.setUlIdResource(idResource, request);
    request.setAttribute("idResource", idResource);
    
    //populate RetrieveSI object.
    PlacementReferralLogRetrieveSI placementReferralLogRetrieveSI = populatePlacementReferralLog_RetrieveSI(context, tuxPagination);
    
    //call retrieve service.
    PlacementReferralLogRetrieveSO placementReferralLogRetrieveSO = resource.retrievePlacementReferralLog(placementReferralLogRetrieveSI);
    
    //set information to pagination bean from RetrieveSO object, and put that bean to request.
    tuxPagination.setPaginationInformation(placementReferralLogRetrieveSO.getArchOutputStruct(), placementReferralLogRetrieveSO.getPlacementReferralLogList().size());
    request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
    
    //put RetrieveSO object and resourceId to the state, so that we can get it on JSP page to display.
    state.setAttribute("PlacementReferralLogRetrieveSO", placementReferralLogRetrieveSO, request);
    state.setAttribute("idResource", placementReferralLogRetrieveSO.getIdResource(), request);
    
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  
  }
  /**
   * This method is called from the name hyperlink of log page. It reads hidden personId and person name
   * sets in Global data, sets the page mode depending on security attributes and then
   * forwards the request to person detail page.
   * @param context
   */
  public void callPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callPersonDetail_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    
//  Set the Full Name into GlobalData
    String fullName = ContextHelper.getStringSafe(context, "hdnFullName");
    int personId = ContextHelper.getIntSafe(context, "hdnUlIdPerson");

    GlobalData.setUlIdPerson(personId, request);
    GlobalData.setSzNmPersonFull(fullName, request);
    
    PersonHelper.setBSysIndViewPersonInfo(request, ContextHelper.getStringSafe(request, "bSysIndViewPersonInfo"));
    if (GlobalData.getUlIdStage(request) == 0) {
      if (user.hasRight(UserProfile.SEC_MNTN_PERSON)) {
        GlobalData.setAppMode(PageModeConstants.MODIFY, request);
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON);
      } else {
        GlobalData.setAppMode(PageModeConstants.VIEW, request);
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.VIEW);
      }
    }else {
      // If the user has the Maintain Person Security Attribute, set the page mode to
      // Maintain person
      if (user.hasRight(UserProfile.SEC_MNTN_PERSON)) {
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON);
      } else {
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.VIEW);
      }
    }
    
    //Forward user to PersonDetail.jsp
    try {
      forward("/person/PersonDetail/displayPersonDetail", request, context.getResponse());
    } catch (ServletException ex) {
      processSevereException(context, ex);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
  }
  
  /**
   * This helper method populates the retrieveSI object, for the retrieve service.
   * 
   * @param context
   * @param tuxPagination
   * @return
   */
  private PlacementReferralLogRetrieveSI populatePlacementReferralLog_RetrieveSI(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination){
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populatePlacementReferralLog_RetrieveSI");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    ArchInputStruct input = new ArchInputStruct();
    input.setUlPageSizeNbr(PAGE_SIZE);
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
        
    PlacementReferralLogRetrieveSI prLogRetrieveSI = new PlacementReferralLogRetrieveSI();
    
    prLogRetrieveSI.setArchInputStruct(input);
    prLogRetrieveSI.setIdResource(GlobalData.getUlIdResource(request));
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
        
    return prLogRetrieveSI;
  }
  
}
