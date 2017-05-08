package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.SpecificExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PlacementReferralDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailSaveSO;

import java.util.*;

/**
 * This is a Conversation class to maintain the information specific to 
 * placement referral for a space in Home or Facility. 
 * 
 * @author lata.p.lokhande
 * 
 * <pre>
 *    &lt;p/&gt;
 *     Change History:
 *      Date      User      Description
 *     --------  --------  --------------------------------------------------
 *     02/19/2007 Lata Lokhande Coded a new Page for Release 2.
 *</pre>
 */
public class PlacementReferralDetailConversation extends BaseHiddenFieldStateConversation {
  public static final String URL_PLACEMENT_REFERRAL_DETAIL = "/PlacementReferralDetail/displayPlacementReferralDetail";
  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;
  private static final String URL_PERSON_SEARCH = "/person/PersonSearch/displayPersonSearch";
  private static final String PAGE_MODE_EDIT = PageModeConstants.EDIT;
   
  private static final String PLACEMENT_REFERRAL_STATUS_ACTIVE = CodesTables.CRSPRSTA_AC;
    
  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  public void displayPlacementReferralDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPlacementReferralDetail_xa()");
    performanceTrace.enterScope();
    
    //define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
        
    String pageMode = GlobalData.getAppMode(request);
      
    state.setAttribute("PageMode", pageMode, request);
    
    //populate the RetrieveSI Object with input fields.
    PlacementReferralDetailRetrieveSI placementReferralDetailRetrieveSI = populatePlacementReferralDetail_RetrieveSI(context);
   
    //call retrieve service and get the RetrieveSO object.
    PlacementReferralDetailRetrieveSO placementReferralDetailRetrieveSO = resource.retrievePlacementReferralDetail(placementReferralDetailRetrieveSI);
    
    //handle null object.
    if(placementReferralDetailRetrieveSO == null){
      placementReferralDetailRetrieveSO = new PlacementReferralDetailRetrieveSO();
    }
    //get saveSI from request and populate RetrieveSO from SaveSI.
    PlacementReferralDetailSaveSI prDetailSaveSI = (PlacementReferralDetailSaveSI)state.getAttribute("PlacementReferralDetailSaveSI", request);
    
    if(prDetailSaveSI != null) {
      
      String cdPlacementType = placementReferralDetailRetrieveSO.getCdPlacementType();
      if("".equals(cdPlacementType) || cdPlacementType == null ) {
        placementReferralDetailRetrieveSO.setCdPlacementType(prDetailSaveSI.getCdPlacementType());
      }
      
      if(placementReferralDetailRetrieveSO.getDtExpiration()== null) {
        placementReferralDetailRetrieveSO.setDtExpiration(prDetailSaveSI.getDtExpiration());
      }
      if(placementReferralDetailRetrieveSO.getIdResource() == 0){
        placementReferralDetailRetrieveSO.setIdResource(prDetailSaveSI.getIdResource());
      }
      if(placementReferralDetailRetrieveSO.getIdEmployee() == 0){
        placementReferralDetailRetrieveSO.setIdEmployee(prDetailSaveSI.getIdEmployee());
      }
      if(placementReferralDetailRetrieveSO.getIdPlacementReferral() == 0){
        placementReferralDetailRetrieveSO.setIdPlacementReferral(prDetailSaveSI.getIdPlacementReferral());
      }
    }
    
    //placementReferralDetailRetrieveSO.setDtBegin(new Date());
    populatePerson(request, placementReferralDetailRetrieveSO);
     
    state.setAttribute("PlacementReferralDetailRetrieveSO", placementReferralDetailRetrieveSO, request);
        
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  
  }
    
  /**
   * Saves the data from Placement Referral Detail page to Placement_Referral table.
   * @param context
   */
  public void savePlacementReferralDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePlacementReferralDetail_xa()");
    performanceTrace.enterScope();
    
    PlacementReferralDetailSaveSO placementReferralDetailSaveSO = null;
//  get request object
    HttpServletRequest request = context.getRequest();
    
    //populate SaveSI object.
    PlacementReferralDetailSaveSI placementReferralDetailSaveSI = populatePlacementReferralDetail_SaveSI(context);
    
    //call Save service.
    try {
      placementReferralDetailSaveSO = resource.savePlacementReferralDetail(placementReferralDetailSaveSI);
      setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, request);
      
    } catch (ServiceException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
    }
      
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
        
  }
  /**
   * This method gets invoke for select person button, and forwards the request
   * to Person Search page.
   * @param context
   */
  public void displayPersonList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    
    String path = "";
    if (CodesTables.CSTAGES_FAD.equals(GlobalData.getSzCdStage(request))){
      path = "/fad";
    }else{
      path = "/resource";
    }
    
    state.setAttribute("pageMode", PageMode.getPageMode(request), request);
    
    String hdnContinueBtn = ContextHelper.getStringSafe(request, "hdnContinueBtn");
    state.setAttribute("hdnContinueBtn", hdnContinueBtn, request);
    
    //populate the saveSI object before leaving the current page. and save it in request.
    PlacementReferralDetailSaveSI prDetailSaveSI = populatePlacementReferralDetail_SaveSI(context);
    state.setAttribute("PlacementReferralDetailSaveSI", prDetailSaveSI, request);
    try {
      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
      
      personListPullBackInfo.setDestinationUrl(path+URL_PLACEMENT_REFERRAL_DETAIL);
      request.setAttribute(PERSON_LIST_PULLBACK_INFO, personListPullBackInfo);
            
      PageMode.setPageMode(PAGE_MODE_EDIT, request);
      forward(URL_PERSON_SEARCH, request, response);
      
    }catch(Exception e){
      processSevereException(context, e);
    }finally {
      performanceTrace.exitScope();
    }
     
  }
  /**
   * Helper method, which gets the PersonListPullBackInfo object from request, get the person id and name from it
   * and populate that value to RetrieveSO object, so when you return from person search page,
   * you will have that value to display.
   * @param request
   * @param prDetailRetrieveSO
   */
  
  protected static void populatePerson(HttpServletRequest request, PlacementReferralDetailRetrieveSO prDetailRetrieveSO) {
    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request.getAttribute(PERSON_LIST_PULLBACK_INFO);
    if (personListPullBackInfo == null) {
      return;
    }
    ROWCINV01SOG00 person = personListPullBackInfo.getPersonListRow();
    if (person == null) {
      return;
    }
    request.removeAttribute(PERSON_LIST_PULLBACK_INFO);

    int idPerson = person.getUlIdPerson();
    String nmPersonFull = person.getSzNmPersonFull();
    
    prDetailRetrieveSO.setIdPerson(idPerson);
    prDetailRetrieveSO.setNmPersonFull(nmPersonFull);
    
  }
       
  /**
   * This helper method populates the retrieveSI object, for the retrieve service.
   * 
   * @param context
   * @param tuxPagination
   * @return
   */
  private PlacementReferralDetailRetrieveSI populatePlacementReferralDetail_RetrieveSI(GrndsExchangeContext context){
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populatePlacementReferralDetail_RetrieveSI");
    performanceTrace.enterScope();
        
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    int idPlacementReferral = ContextHelper.getIntSafe(request,"hdnIdPlacementReferral");
    int idResource = (Integer)state.getAttribute("idResource", request);
   
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
   
    PlacementReferralDetailRetrieveSI prDetailRetrieveSI = new PlacementReferralDetailRetrieveSI();
    
    prDetailRetrieveSI.setArchInputStruct(input);
    prDetailRetrieveSI.setIdPlacementReferral(idPlacementReferral);
    prDetailRetrieveSI.setIdResource(idResource);
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
        
    return prDetailRetrieveSI;
  }
  
  /**
   * Helper method to populate SaveSI object, used to pass to the save Service.
   * @param context
   * @return
   */
  private PlacementReferralDetailSaveSI populatePlacementReferralDetail_SaveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populatePlacementReferralDetail_SaveSI");
    performanceTrace.enterScope();
    int idPerson = 0;
    int idResource = 0;
    int idPlacementReferral = 0;
    
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
           
    idResource = GlobalData.getUlIdResource(request);
        
    if( idResource == 0 ) {
      idResource = (Integer)state.getAttribute("idResource", request);
    }
       
    PlacementReferralDetailSaveSI placementReferralDetailSaveSI = new PlacementReferralDetailSaveSI() ;
    
    //get retrieveSO object from state and get personId and employeeId from it.
    PlacementReferralDetailRetrieveSO prDetailRetrieveSO = (PlacementReferralDetailRetrieveSO)state.getAttribute("PlacementReferralDetailRetrieveSO", request);
    if(prDetailRetrieveSO != null){
      idPerson = prDetailRetrieveSO.getIdPerson();
      idPlacementReferral = prDetailRetrieveSO.getIdPlacementReferral();
      
    }
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    
    //get the form input fields.
    String nmPersonFull = ContextHelper.getStringSafe(request, "dspPersonName");
    String cdPlacementType = ContextHelper.getStringSafe(request, "selCdPlacementType");
    Date dtExpiration = ContextHelper.getJavaDateSafe(request,"txtDtExpiration");
    Date dtBegin = new Date();
    
    //sets the values to SaveSI object.
    placementReferralDetailSaveSI.setArchInputStruct(input);
    placementReferralDetailSaveSI.setCdPlacementType(cdPlacementType);
    placementReferralDetailSaveSI.setDtBegin(dtBegin);
    placementReferralDetailSaveSI.setDtExpiration(dtExpiration);
    if(idResource != 0) {
      placementReferralDetailSaveSI.setIdResource(idResource);
    }
    if(idPerson != 0){
      placementReferralDetailSaveSI.setIdPerson(idPerson);
    }
    placementReferralDetailSaveSI.setIdPlacementReferral(idPlacementReferral);
       
    placementReferralDetailSaveSI.setIdEmployee(user.getUserID());
    placementReferralDetailSaveSI.setNmPersonFull(nmPersonFull);
    placementReferralDetailSaveSI.setCdStatus(PLACEMENT_REFERRAL_STATUS_ACTIVE);
    
    return placementReferralDetailSaveSI;
    
  }
  
  /**
   * Method to catch exceptions.
   * @param context
   * @param throwable
   */
  public static void processSevereException(GrndsExchangeContext context, Throwable throwable) {
    GrndsTrace.enterScope(TRACE_TAG + ".processSevereException");
    SpecificExceptionHandler specificExceptionHandler = ExceptionHandler.handle(throwable);
    specificExceptionHandler.presentErrorMessage(context);
    GrndsTrace.exitScope();
  }
  
}
