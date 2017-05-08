package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.resource.ResourceORSSearch;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for resources from the ORS Resource Search page and refine a search,
 * conduct a new search, and display selected list from the Resource List page. <p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  03/12/08  ssubram   Initial Code
 * </pre>
 * 
 * @author ssubram, March 12, 2008
 */
public class ResourceORSSearchConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "ResourceORSSearchConversation";

  private static final String COMMA_STRING = ",";

  public static final String CHECKED_RESOURCES_KEY = "checkedResources";

  public static final String CHECKED_RESOURCE_KEY = "checkedResource";

  public static final String SEARCH_BEAN_KEY = "searchBean";

  public static final String RESULTS_COMMAND = "/resource/ResourceORSSearch/results";

  public static final String RESOURCE_NAME_KEY = "txtResourceName";

  public static final String FACILITY_ID = "txtFacilityId";

  public static final String LEGAL_NAME = "txtLegalName";
  
  public static final String CRES03SO_ATTRIBUTE_NAME = "CRES03S";

  private ResourceORSSearch resourceORSSearch;

  public void setResourceSearch(ResourceORSSearch resourceORSSearch) {
    this.resourceORSSearch = resourceORSSearch;
  }

  /**
   * This method performs some initialization that is used only for MPS.
   * 
   * @param context
   *          GrndsExchangeContext for this conversation
   */
  public void displaySearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySearch_xa");
    performanceTrace.enterScope();
    
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    CRES03SO cres03so = (CRES03SO)state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
    
    performanceTrace.exitScope();
  }

  /**
   * Constructor that builds the bean from an HttpServletRequest containing search parameters
   *  @ param HttpServletRequest
   */
  public static ResourceORSSearchValueBean createResourceORSSearchValueBean(HttpServletRequest request) {
    ResourceORSSearchValueBean resourceSearchValueBean = new ResourceORSSearchValueBean();
    // set the values to this bean
    String tmp = ContextHelper.getStringSafe(request, RESOURCE_NAME_KEY);
    resourceSearchValueBean.setResourceName(tmp);
    tmp = ContextHelper.getStringSafe(request, FACILITY_ID);
    resourceSearchValueBean.setFacilityID(tmp);
    tmp = ContextHelper.getStringSafe(request, LEGAL_NAME);
    resourceSearchValueBean.setLegalName(tmp);

    return resourceSearchValueBean;
  }

  /**
   * This method is called by the GRNDS controller when a user searches for resources. Also used for pagination through
   * Resource List. It places a pagination bean and a List of ORS Resources on the request for use by the JSP.
   * 
   * @param context
   *          Context for the request
   */
  @SuppressWarnings("unchecked")
  public void resourceORSSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".resourceORSSearch_xa");
    performanceTrace.enterScope();

    PaginationResultBean results = null;
    HttpServletRequest request = context.getRequest();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      CRES03SO cres03so = (CRES03SO)state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
      state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
      ResourceORSSearchValueBean searchBean;
      ResourceORSSearchPullBackInfo resourceORSSearchPullBackInfo;
      if (request.getAttribute(ResourceORSSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST) != null) {
        resourceORSSearchPullBackInfo = (ResourceORSSearchPullBackInfo) request
                                                                         .getAttribute(ResourceORSSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

        String returnUrl = resourceORSSearchPullBackInfo.getDestinationUrl();
        request.setAttribute("destinationUrl", returnUrl);
        searchBean = resourceORSSearchPullBackInfo;
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Before populating search bean");
        searchBean = createResourceORSSearchValueBean(request);
      }

      state.setAttribute(SEARCH_BEAN_KEY, searchBean, request);
      ValueBeanHelper.populateDefaultValues(context, searchBean);
      // Get any selected resources from previous list page and store to hidden fieldstate

      GrndsTrace.msg(TRACE_TAG, 7, " Executing the search method on the ResourceSearchBean.");
      results = resourceORSSearch.searchORSResources(searchBean);

      /** Section Below Contains Logic for maintaining information on selected resources through pagination. */
      // If this is the first page with resources selected, get the selected resources from request
      // and set them to a new attribute (checkedResource attribute) in state management.
      if ((state.getAttribute(CHECKED_RESOURCES_KEY, request) == null)
          && (request.getParameter(CHECKED_RESOURCE_KEY) != null)) {
        String checkedResource = request.getParameter(CHECKED_RESOURCE_KEY);
        int lastComma = checkedResource.lastIndexOf(COMMA_STRING);
        int fromIndex = 0;
        int numberOfResourcesChecked = 0;
        while (fromIndex < lastComma) {
          fromIndex = checkedResource.indexOf(COMMA_STRING, fromIndex + 1);
          numberOfResourcesChecked++;
        }
        String[] resourceSearchBeanArray = new String[numberOfResourcesChecked];
        int previousComma = 0;
        for (int i = 0; i < numberOfResourcesChecked; i++) {
          int nextComma = checkedResource.indexOf(COMMA_STRING, previousComma + 1);
          if (i > 0) {
            previousComma++;
          }
          resourceSearchBeanArray[i] = checkedResource.substring(previousComma, nextComma);
          previousComma = nextComma;
        }
        ResourceORSSearchValueBean[] selectedResourceBeansArray = new ResourceORSSearchValueBean[resourceSearchBeanArray.length];
        for (int i = 0; i < resourceSearchBeanArray.length; i++) {
          selectedResourceBeansArray[i] = (ResourceORSSearchValueBean) SerializationHelper
                                                                                       .deserializeObject(resourceSearchBeanArray[i]);
        }
        state.setAttribute(CHECKED_RESOURCES_KEY, selectedResourceBeansArray, request);
      }
      // If this is not the first page with selected resources, get the selected resources from request
      // and add them to the resources form previous pages (previous page resources saved to checkedResource attribute
      // in state management).
      else if ((state.getAttribute(CHECKED_RESOURCES_KEY, request) != null)
               && (request.getParameter(CHECKED_RESOURCE_KEY) != null)) {
        // Add previously selected resources
        ResourceORSSearchValueBean[] previouslySelectedResourceBeansArray = (ResourceORSSearchValueBean[]) state
                                                                                                          .getAttribute(
                                                                                                                        CHECKED_RESOURCES_KEY,
                                                                                                                        request);

        int j = previouslySelectedResourceBeansArray.length;
        String checkedResource = request.getParameter(CHECKED_RESOURCE_KEY);
        if (checkedResource != null) {
          int lastComma = checkedResource.lastIndexOf(COMMA_STRING);
          int fromIndex = 0;
          int numberOfResourcesChecked = 0;
          while (fromIndex < lastComma) {
            fromIndex = checkedResource.indexOf(COMMA_STRING, fromIndex + 1);
            numberOfResourcesChecked++;
          }
          j += numberOfResourcesChecked;
        }
        ResourceORSSearchValueBean[] selectedResourceBeansArray;
        // If resources selected on previous pages and last page total more than 25, add only enough of the resources
        // from
        // the lst page to total 25.
        int resultsPerPage = ContextHelper.getIntSafe(request, DatabaseResultDetails.RESULTS_PER_PAGE_NAME);

        if (j > resultsPerPage) {
          selectedResourceBeansArray = new ResourceORSSearchValueBean[resultsPerPage];
          // MSG - "You may only select a maximum of 25 resources. Only the first 25 resources selected are stored to
          // memory."
          setInformationalMessage(Messages.MSG_RSRC_LIMITED_DISPLAY_SELECTED, RESULTS_COMMAND, request);

          for (int i = 0; i < previouslySelectedResourceBeansArray.length; i++) {
            selectedResourceBeansArray[i] = previouslySelectedResourceBeansArray[i];
          }
          if (checkedResource != null) {
            int previousComma = 0;
            for (int i = previouslySelectedResourceBeansArray.length; i < resultsPerPage; i++) {
              if (i > previouslySelectedResourceBeansArray.length) {
                previousComma++;
              }
              int nextComma = checkedResource.indexOf(COMMA_STRING, previousComma);
              selectedResourceBeansArray[i] = (ResourceORSSearchValueBean) SerializationHelper
                                                                                           .deserializeObject(checkedResource
                                                                                                                             .substring(
                                                                                                                                        previousComma,
                                                                                                                                        nextComma));
              previousComma = nextComma;
            }
          }
        }
        // If resources selected on previous pages and last page total No more than 25, then add all.
        else {
          selectedResourceBeansArray = new ResourceORSSearchValueBean[j];
          for (int i = 0; i < previouslySelectedResourceBeansArray.length; i++) {
            selectedResourceBeansArray[i] = previouslySelectedResourceBeansArray[i];
          }
          if (checkedResource != null) {
            int previousComma = 0;
            for (int i = previouslySelectedResourceBeansArray.length; i < j; i++) {
              if (i > previouslySelectedResourceBeansArray.length) {
                previousComma++;
              }
              int nextComma = checkedResource.indexOf(COMMA_STRING, previousComma);
              selectedResourceBeansArray[i] = (ResourceORSSearchValueBean) SerializationHelper
                                                                                           .deserializeObject(checkedResource
                                                                                                                             .substring(
                                                                                                                                        previousComma,
                                                                                                                                        nextComma));

              previousComma = nextComma;
            }
          }
        }
        state.setAttribute(CHECKED_RESOURCES_KEY, selectedResourceBeansArray, request);
      }
    } catch (TooManyRowsReturnedException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TooManyRowsReturnedException.");
      setPresentationBranch("tooManyResults", context);
      setInformationalMessage(Messages.MSG_CMN_TOO_MANY_RECORDS, RESULTS_COMMAND, request);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_RSRC_PROX_ADDR_INVALID:
        setPresentationBranch("invalidAddress", context);
        setInformationalMessage(Messages.MSG_RSRC_PROX_ADDR_INVALID, RESULTS_COMMAND, request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure in ReseourceSearch:" + se.getMessage());
        processSevereException(context, se);
        break;
      }
    } catch (Exception re) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception executing the search method on the ResourceSearchBean.");
      GrndsTrace.msg(TRACE_TAG, 7, re.getMessage());
      processSevereException(context, re);
    }

    // Store results to request here so we ALWAYS have an object extending BasePaginationValueBean in the request.
    if (results == null) {
      results = new PaginationResultBean();
      ValueBeanHelper.populateDefaultValues(context, results);
      results.getResultDetails().setResultsPerPage(50); // TODO: change this to a constant
    }
    request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, results);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests a Refined Search. It places the original
   * search parameters on the request so the Search page can pre-populate itself using them.
   * 
   * @param context
   *          Context for the request
   */
  public void refineSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".refineSearch_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ResourceORSSearchValueBean bean = (ResourceORSSearchValueBean) state.getAttribute(SEARCH_BEAN_KEY, request);

    request.setAttribute(SEARCH_BEAN_KEY, bean);
    state.removeAttribute(SEARCH_BEAN_KEY, request);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests to display selected resources. The selected
   * resources are placed in a List and put on the request for display by the JSP.
   * 
   * @param context
   *          Context for the request
   */
  public void displaySelectedList_xa(GrndsExchangeContext context) {
    List<ResourceORSSearchValueBean> resourceList = new ArrayList<ResourceORSSearchValueBean>();
    ResourceORSSearchValueBean selectedResource;
    PaginationResultBean selectedResourceResults = new PaginationResultBean();
    ValueBeanHelper.populateDefaultValues(context, selectedResourceResults);
    selectedResourceResults.getResultDetails().setResultsPerPage(50); // todo: change this to a constant

    DatabaseResultDetails details;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySelectedList_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    ResourceORSSearchValueBean searchBean = (ResourceORSSearchValueBean) state.getAttribute(SEARCH_BEAN_KEY, request);
    ValueBeanHelper.populateDefaultValues(context, searchBean);
    state.setAttribute(SEARCH_BEAN_KEY, searchBean, request);

    details = searchBean.getResultDetails();

    try {
      ResourceORSSearchValueBean[] previousPagesResourceBeanArray = (ResourceORSSearchValueBean[]) state
                                                                                                  .getAttribute(
                                                                                                                CHECKED_RESOURCES_KEY,
                                                                                                                request);
      int numberOfSelected = 0;

      if (previousPagesResourceBeanArray != null) {
        resourceList.addAll(Arrays.asList(previousPagesResourceBeanArray));
        numberOfSelected += previousPagesResourceBeanArray.length;
      }
      int numberOfResourcesChecked = 0;
      // If resources were checked on last list page get them from the request object.
      if (request.getParameter(CHECKED_RESOURCE_KEY) != null) {
        String resourceSearchBeans = request.getParameter(CHECKED_RESOURCE_KEY);
        int lastComma = resourceSearchBeans.lastIndexOf(COMMA_STRING);
        int fromIndex = 0;
        while (fromIndex < lastComma) {
          fromIndex = resourceSearchBeans.indexOf(COMMA_STRING, fromIndex + 1);
          numberOfResourcesChecked++;
        }
        if (numberOfSelected + numberOfResourcesChecked < 1) {
          GrndsTrace.msg(TRACE_TAG, 7, "No resources selected for Display Selected.");
          setErrorMessage(Messages.MSG_RSRC_CHCK_DISPLAY_ROW, RESULTS_COMMAND, request);
        } else {
          int resultsPerPage = Integer.valueOf(request.getParameter(DatabaseResultDetails.RESULTS_PER_PAGE_NAME));
          // If total resources checked are greater than 25, only display first 25 resources checked.
          if (numberOfSelected + numberOfResourcesChecked > resultsPerPage) {
            GrndsTrace.msg(TRACE_TAG, 7, "More than 25 resources selected for Display Selected.");
            setInformationalMessage(Messages.MSG_RSRC_LIMITED_DISPLAY, RESULTS_COMMAND, request);
            int previousComma = 0;
            for (int i = 0; i < resultsPerPage - numberOfSelected; i++) {
              int nextComma = resourceSearchBeans.indexOf(COMMA_STRING, previousComma + 1);
              if (i > 0) {
                previousComma++;
              }
              selectedResource = (ResourceORSSearchValueBean) SerializationHelper
                                                                              .deserializeObject(resourceSearchBeans
                                                                                                                    .substring(
                                                                                                                               previousComma,
                                                                                                                               nextComma));

              resourceList.add(selectedResource);
              previousComma = nextComma;
            }
            numberOfSelected = resultsPerPage;
          }
          // If total resources checked are less than or equal to 25, display all resources.
          else {
            int previousComma = 0;
            for (int i = 0; i < numberOfResourcesChecked; i++) {
              int nextComma = resourceSearchBeans.indexOf(COMMA_STRING, previousComma + 1);
              if (i > 0) {
                previousComma++;
              }
              selectedResource = (ResourceORSSearchValueBean) SerializationHelper
                                                                              .deserializeObject(resourceSearchBeans
                                                                                                                    .substring(
                                                                                                                               previousComma,
                                                                                                                               nextComma));

              resourceList.add(selectedResource);
              previousComma = nextComma;
            }
            numberOfSelected += numberOfResourcesChecked;
          }
        }
        details.setNumberOfResults(numberOfSelected);
        // Set ArrayList of selected resources and details onto pagination result bean
        selectedResourceResults.setResults(resourceList);
        selectedResourceResults.setResultDetails(details);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7,
                     " Exception executing displaySelectedList_xa method on the ResourceSearchConversation.");
      GrndsTrace.msg(TRACE_TAG, 7, e.getMessage());
      processSevereException(context, e);
    }

    // Store results to request here so we ALWAYS have one when we get to the JSP
    request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, selectedResourceResults);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests to pull back resource information from another
   * module. It gets the search bean from the request and uses it to search for resources. The results along with the
   * destination url are placed on the request for use by the JSP.
   * 
   * @param context
   *          Context for the request
   */
  public void pullBackResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".pullBackResource_xa");
    performanceTrace.enterScope();
    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      String facilityId = ContextHelper.getStringSafe(context, ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      ResourceORSSearchValueBean resultBean = new ResourceORSSearchValueBean();
      resultBean.setFacilityID(facilityId);
      String returnUrl = request.getParameter("destinationUrl");
      request.setAttribute("destinationUrl", returnUrl);
      CRES03SO cres03so = (CRES03SO)state.getAttribute(CRES03SO_ATTRIBUTE_NAME, context.getRequest());
      state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
      forward(returnUrl,request,context.getResponse());
    } catch (ServletException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServletException:" + se.getMessage());
      processSevereException(context, se);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }
}

