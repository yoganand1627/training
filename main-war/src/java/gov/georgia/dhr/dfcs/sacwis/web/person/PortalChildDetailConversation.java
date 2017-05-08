package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PortalChildRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PortalChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;


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
 */

/**
 * ***************************************************************************** *  Declare your conversation class and
 * have it extend *  BaseHiddenFieldStateConversation class. ******************************************************************************
 */

public class PortalChildDetailConversation extends BaseHiddenFieldStateConversation {

  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }
//static constants
  public static final String TRACE_TAG = "PortalChildDetailConversation";
  private static final int PAGE_SIZE = 50;
  
  
  //........etc........
  /**
   * *************************************************************************** Process - initial display of Placement
   * Log is sorted by dt_plcmnt_end, descending dt_plcmnt_start, descending.  This will show open placements (
   * placements where dt_plcmnt_end is null or 12/31/4712 ) first.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   *                ***************************************************************************
   */
  public void displayPortalChildDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPortalChildDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //state.removeAllAttributes(request);
    
    String pageMode = GlobalData.getAppMode(request);
    PageMode.setPageMode(PageModeConstants.VIEW, request);

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
    
    PortalChildRetrieveSI portalChildRetrieveSI = new PortalChildRetrieveSI();
      
    ArchInputStruct archInputStruct = new ArchInputStruct();
    
    archInputStruct.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    archInputStruct.setUlPageSizeNbr(PAGE_SIZE);
    
    portalChildRetrieveSI.setArchInputStruct(archInputStruct);
    
    int idPerson = ContextHelper.getIntSafe(request, "hdnUlIdPerson");
    int idCase = ContextHelper.getIntSafe(request, "hdnUlIdCase");
    int idStage =  ContextHelper.getIntSafe(request, "hdnUlIdStage");
    int idPlcmtEvent =  ContextHelper.getIntSafe(request, "hdnUlIdPlcmtEvent");
       
    if (idPerson == 0){
      idPerson = GlobalData.getUlIdPerson(request);
    }
    
    if (idCase == 0){
      idCase = GlobalData.getUlIdCase(request);
    }

    if (idStage == 0){
      idStage = GlobalData.getUlIdStage(request);
    }

    if (idPlcmtEvent == 0){
      idPlcmtEvent = GlobalData.getUlIdPlcmtEvent(request);
    }
    
    UserProfile user = UserProfileHelper.getUserProfile(request);
    Map<Integer, String> rsrcMap = new HashMap<Integer, String>();
    rsrcMap = user.getRsrcMap();
    
    List<Integer> assignedResources = new ArrayList<Integer>();
    
    assignedResources.addAll(rsrcMap.keySet());
    
    portalChildRetrieveSI.setIdCase(idCase);
    portalChildRetrieveSI.setIdStage(idStage);
    portalChildRetrieveSI.setIdPerson(idPerson);
    portalChildRetrieveSI.setIdPlcmtEvent(idPlcmtEvent);
    portalChildRetrieveSI.setAssignedResources(assignedResources);
    
    GlobalData.setUlIdPerson(idPerson, request);
    GlobalData.setUlIdStage(idStage, request);
    GlobalData.setUlIdCase(idCase, request);
    GlobalData.setUlIdPlcmtEvent(idPlcmtEvent, request);
    GlobalData.setUlIdEvent(0, request);
    
    try {
            
      PortalChildRetrieveSO portalChildRetrieveSO = null;
      //portalChildRetrieveSO.getCdCaseManagerJobTitle();
      portalChildRetrieveSO = person.retrievePortalChildDetail(portalChildRetrieveSI);
      /* place the service object and the indicator for an incomplete DPS row in the request;
            the service object contains the rows displayed on the list page;*/
      request.setAttribute("portalChildRetrieveSO", portalChildRetrieveSO);

      if (portalChildRetrieveSO != null) {
        //set the information into the pagination bean and then store it to the request
        tuxPagination.setPaginationInformation(portalChildRetrieveSO.getArchOutputStruct(),
                                               portalChildRetrieveSO.getContactsList().size());

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
   * ************************************************************************************* This helper method handles
   * all the WTC Exceptions thrown by this conversation **************************************************************************************
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
      //case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      //  this.setPresentationBranch("error", context);
      //  String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      //  //setErrorMessage(errorMessage1, "/workload/PortalChildList/displayChildList", request);
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

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  

}
