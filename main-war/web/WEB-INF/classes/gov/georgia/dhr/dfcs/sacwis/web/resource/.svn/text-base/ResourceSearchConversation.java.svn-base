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
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.external.External;
import gov.georgia.dhr.dfcs.sacwis.service.resource.ResourceSearch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthConversation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for resources from the Resource Search page and refine a search,
 * conduct a new search, and display selected list from the Resource List page. <p/> <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  10/12/05  PIAZZAAT  Changes for Phase 3 (SIR 24033)
 *  10/21/05  PIAZZAAT  SIR 24076
 *  06/12/08  cwells    STGAP00009003 - Changed the code back to default the resource Status to 01 
 * </pre>
 * 
 * @author Sanjay Rana, July 23, 2002
 */
public class ResourceSearchConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "ResourceSearchConversation";

  private static final String COMMA_STRING = ",";

  public static final String CHECKED_RESOURCES_KEY = "checkedResources";

  public static final String CHECKED_RESOURCE_KEY = "checkedResource";

  public static final String SEARCH_BEAN_KEY = "searchBean";

  public static final String RESULTS_COMMAND = "/resource/ResourceSearch/results";

  public static final String RESOURCE_TYPE_KEY = "selResourceType";

  public static final String RESOURCE_NAME_KEY = "txtResourceName";

  public static final String IDENTIFICATION_TYPE_KEY = "selIdentificationType";

  public static final String ID_KEY = "txtIdentificationNumber";

  public static final String CATEGORY_KEY = "selResourceCategory";

  public static final String SERVICE_KEY = "selResourceService";

  public static final String PROGRAM_KEY = "selResourceProgram";

  public static final String LOCATIONAREA_SERVED_KEY = "rbResourceLocationArea";

  public static final String RSRC_REGION_KEY = "selResourceRegion";

  public static final String NAME_COUNTY_KEY = "selResourceCounty";

  public static final String NAME_CITY_KEY = "txtResourceCity";

  public static final String ZIP_CODE_KEY = "txtResourceZip";

  public static final String ZIP_CODE_SUFFIX_KEY = "txtResourceZipSuffix";

  public static final String STATE_NAME_KEY = "selResourceState";

  // changed for sacwis status is changed from radio to dropdown
  public static final String RESOURCE_INACTIVE_KEY = "rbResourceStatus";

  public static final String RESOURCE_STATUS_KEY = "selResourceStatus";

  public static final String RSRC_CONTRACTED_KEY = "selResourceContractedStatus";

  public static final String FACILITY_TYPE_KEY = "selResourceFacilityType";

  public static final String LEVEL_CARE_KEY = "selResourceLOC";

  public static final String AGE_SERVED_KEY = "txtResourceAge";

  public static final String GENDER_SERVED_KEY = "selResourceSex";

  public static final String CLIENT_CHARACTERISTICS_KEY = "selResourceCharacterisitcs";

  public static final String EFFECTIVE_DATE_KEY = "txtEffectiveDate";

  public static final String IND_DONATED = "txtIndDonated";

  public static final String PROXIMITY_RANGE = "selProximityRange";

  public static final String DEFAULT_CODE_PRGRM_TYPE = "01";

  public static final String RESOURCE_ADDRESS = "txtResourceAddress1";
  
  public static final String RESOURCE_LOCATION = "lctn";
  
  public static String CPS_INV_CNCLSN_CALLED = "/investigation/CPSInvCnclsn/displayCPSInvCnclsn";
  
  public static String INTAKE_INFORMATION_CALLED = "/intake/CallInformation/displayCallInformation";
  
  public static final String PREVIOUS_URL = TRACE_TAG + "PREVIOUS_URL";  

  private ResourceSearch resourceSearch;

  private External external;

  public void setResourceSearch(ResourceSearch resourceSearch) {
    this.resourceSearch = resourceSearch;
  }

  public void setExternal(External external) {
    this.external = external;
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

    pageInit(context);

    performanceTrace.exitScope();
  }

  private void pageInit(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    try {
      if (PlatformConstants.MOBILE_IMPACT) {
        // Set the exclusions on the Resource Type
        HashSet<String> typeExclSet = new HashSet<String>(Lookup.getCategoryCodesCollection(CodesTables.CRSCTYPE));
        // Set the exclusions on the Program Type
        HashSet<String> progExclSet = new HashSet<String>();
        // Set the exclusions on the Identification Number
        HashSet<String> idExclSet = new HashSet<String>();

        progExclSet.add(CodesTables.CRSCPROG_01);
        idExclSet.add(CodesTables.CRSIDTYP_CON);
        idExclSet.add(CodesTables.CRSIDTYP_LIC);

        if (ResourceHelper.userHasApsWorkloadCases()) {
          typeExclSet.remove(CodesTables.CRSCTYPE_01);
        }

        if (ResourceHelper.userHasAfcWorkloadCases()) {
          typeExclSet.remove(CodesTables.CRSCTYPE_05);
        } else {
          idExclSet.add(CodesTables.CRSIDTYP_MHM);
        }

        request.setAttribute("rsrcTypeExclusions", typeExclSet);
        request.setAttribute("rsrcProgExclusions", progExclSet);
        request.setAttribute("rsrcIdExclusions", idExclSet);
      }
      
      //check if the search is coming from a prior page and if so set the attributes 
      request.removeAttribute("requestFromServiceAutPage");
      BaseSessionStateManager state = getSessionStateManager(context);
      
      //MR-066
      if (state.getAttribute(PREVIOUS_URL, request) == null) {
        String callingPage = ContextHelper.getPreviousUrl(request);
        state.setAttribute(PREVIOUS_URL, callingPage, request);
      }
      String previousURL = (String) state.getAttribute(PREVIOUS_URL, request);
      if( (CPS_INV_CNCLSN_CALLED.equals(previousURL) || INTAKE_INFORMATION_CALLED.equals(previousURL) )
                      && StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewSearch.x"))){
        state.removeAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, request);
      }
      
      ResourceSearchPullBackInfo resourceSearchPullBackInfo;
      if (state.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, request) != null) {
        resourceSearchPullBackInfo = (ResourceSearchPullBackInfo) state.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, request);
         
        String returnUrl = resourceSearchPullBackInfo.getDestinationUrl();
        request.setAttribute("destinationUrl", returnUrl);
        //forces the page to populate/display with the values from the search bean
        request.setAttribute("requestFromServiceAutPage", "true"); 
        request.setAttribute(SEARCH_BEAN_KEY, resourceSearchPullBackInfo); 
        state.setAttribute(SEARCH_BEAN_KEY, resourceSearchPullBackInfo, request);
      }
      
    } catch (LookupException e) {
      processSevereException(context, e);
    }
  }

  /**
   * Constructor that builds the bean from an HttpServletRequest containing search parameters
   *  @ param HttpServletRequest
   */
  public static ResourceSearchPullBackInfo createResourceSearchValueBean(HttpServletRequest request) {
    ResourceSearchPullBackInfo resourceSearchValueBean = new ResourceSearchPullBackInfo();
    // set the values to this bean
    String tmp = ContextHelper.getStringSafe(request, RESOURCE_TYPE_KEY);
    resourceSearchValueBean.setResourceType(tmp);
    tmp = ContextHelper.getStringSafe(request, RESOURCE_NAME_KEY);
    resourceSearchValueBean.setResourceName(tmp);
    tmp = ContextHelper.getStringSafe(request, IDENTIFICATION_TYPE_KEY);
    resourceSearchValueBean.setIdentificationType(tmp);
    tmp = ContextHelper.getStringSafe(request, ID_KEY);
    resourceSearchValueBean.setIdentificationNum(tmp);
    tmp = ContextHelper.getStringSafe(request, CATEGORY_KEY);
    resourceSearchValueBean.setCategory(tmp);
    tmp = ContextHelper.getStringSafe(request, SERVICE_KEY);
    resourceSearchValueBean.setService(tmp);
    tmp = ContextHelper.getStringSafe(request, PROGRAM_KEY);
    resourceSearchValueBean.setProgram(tmp);
    tmp = ContextHelper.getStringSafe(request, LOCATIONAREA_SERVED_KEY);
    resourceSearchValueBean.setLocationArea(tmp);
    tmp = ContextHelper.getStringSafe(request, RSRC_REGION_KEY);
    resourceSearchValueBean.setRsrcRegion(tmp);
    tmp = ContextHelper.getStringSafe(request, NAME_COUNTY_KEY);
    resourceSearchValueBean.setNameCounty(tmp);
    tmp = ContextHelper.getStringSafe(request, NAME_CITY_KEY);
    resourceSearchValueBean.setNameCity(tmp);
    tmp = ContextHelper.getStringSafe(request, STATE_NAME_KEY);
    resourceSearchValueBean.setStateName(tmp);
    tmp = ContextHelper.getStringSafe(request, ZIP_CODE_KEY);
    resourceSearchValueBean.setZipCode(tmp);
    tmp = ContextHelper.getStringSafe(request, ZIP_CODE_SUFFIX_KEY);
    resourceSearchValueBean.setZipCodeSuffix(tmp);
    tmp = ContextHelper.getStringSafe(request, RESOURCE_STATUS_KEY);
    
   // default status to ACTIVE if no status type is selected
   //   if ((StringHelper.EMPTY_STRING.equals(tmp) && tmp.length() == 0) || ("actv".equals(tmp))) {
   //   tmp = CodesTables.CRSCSTAT_01;
   //}
   // van - do not default since there is no option ALL to search for all status, that would make sense to use empty selection as ALL option
    
    
    resourceSearchValueBean.setResourceStatus(tmp);
    tmp = ContextHelper.getStringSafe(request, RSRC_CONTRACTED_KEY);
    resourceSearchValueBean.setRsrcContracted(tmp);
    tmp = ContextHelper.getStringSafe(request, FACILITY_TYPE_KEY);
    resourceSearchValueBean.setFacilityType(tmp);
    tmp = ContextHelper.getStringSafe(request, LEVEL_CARE_KEY);
    resourceSearchValueBean.setLevelCare(tmp);
    tmp = ContextHelper.getStringSafe(request, AGE_SERVED_KEY);
    resourceSearchValueBean.setAgeServed(tmp);
    tmp = ContextHelper.getStringSafe(request, CLIENT_CHARACTERISTICS_KEY);
    resourceSearchValueBean.setClientCharacteristics(tmp);
    tmp = ContextHelper.getStringSafe(request, GENDER_SERVED_KEY);
    resourceSearchValueBean.setGenderServed(tmp);
    tmp = ContextHelper.getStringSafe(request, EFFECTIVE_DATE_KEY);
    resourceSearchValueBean.setEffectiveDate(tmp);
    // SIR 23622
    tmp = ContextHelper.getStringSafe(request, IND_DONATED);
    resourceSearchValueBean.setDonatedService(tmp);
    tmp = ContextHelper.getStringSafe(request, PROXIMITY_RANGE);
    resourceSearchValueBean.setProximityRange(tmp);
    // adding address
    tmp = ContextHelper.getStringSafe(request, RESOURCE_ADDRESS);
    resourceSearchValueBean.setStreetAddress(tmp);

    if (request.getParameter("cbxBIndAvalibleAfterHours") != null
        && !request.getParameter("cbxBIndAvalibleAfterHours").equals("")) {
      resourceSearchValueBean.setAvalibleAfterHours("Y");
    }

    return resourceSearchValueBean;
  }

  /**
   * Populates the AddressValidatorSI object used in the address validation validation
   * 
   * @param context
   * @return
   */
  private AddressValidatorSI populateAddressValidatorSI_Resource(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateAddressValidatorSI_Resource");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    AddressValidatorSI addressValidatorSI = new AddressValidatorSI();
    addressValidatorSI.setAddress1(ContextHelper.getStringSafe(request, RESOURCE_ADDRESS));
    addressValidatorSI.setCity(ContextHelper.getStringSafe(request, "txtResourceCity"));
    addressValidatorSI.setState(ContextHelper.getStringSafe(request, "selResourceState"));
    String zip = ContextHelper.getStringSafe(request, "txtResourceZip");
    String zipSuffix = ContextHelper.getStringSafe(request, "txtResourceZipSuffix");
    if (!StringHelper.EMPTY_STRING.equals(zipSuffix)) {
      zip = zip + "-" + zipSuffix;
    }
    addressValidatorSI.setZipCode(zip);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return addressValidatorSI;
  }

  /**
   * This method is called by the GRNDS controller when a user searches for resources. Also used for pagination through
   * Resource List. It places a pagination bean and a List of Resources on the request for use by the JSP.
   * 
   * @param context
   *          Context for the request
   */
  @SuppressWarnings("unchecked")
  public void resourceSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".resourceSearch_xa");
    performanceTrace.enterScope();

    PaginationResultBean results = null;
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      ResourceSearchValueBean searchBean;
      ResourceSearchPullBackInfo resourceSearchPullBackInfo;
      
      //MR-066
      if (state.getAttribute(PREVIOUS_URL, request) == null) {
        String callingPage = ContextHelper.getPreviousUrl(request);
        state.setAttribute(PREVIOUS_URL, callingPage, request);
      }
      String previousURL = (String) state.getAttribute(PREVIOUS_URL, request);
      if((CPS_INV_CNCLSN_CALLED.equals(previousURL) || INTAKE_INFORMATION_CALLED.equals(previousURL))
                      && StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSearch.x"))){
        state.removeAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, request);
      }
      
      //STGAP00009003 Retrieving the Resource pullback information from the state since it will be cleared from the
      // request when coming from Svc Auth to Resource Search list. 
      if (state.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, request) != null) {
        resourceSearchPullBackInfo = (ResourceSearchPullBackInfo) state.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, request);
        String returnUrl = resourceSearchPullBackInfo.getDestinationUrl();
        request.setAttribute("destinationUrl", returnUrl);
        if(resourceSearchPullBackInfo.isFullSerach() == true) {
          ResourceSearchPullBackInfo newResourceSearchPullBackInfo = createResourceSearchValueBean(request);
          //add back the values from original pullback to preserve the pullback info
          newResourceSearchPullBackInfo.setDestinationUrl(returnUrl);
          newResourceSearchPullBackInfo.setEffectiveDate(resourceSearchPullBackInfo.getEffectiveDate());
          newResourceSearchPullBackInfo.setCategory(resourceSearchPullBackInfo.getCategory());
          newResourceSearchPullBackInfo.setService(resourceSearchPullBackInfo.getService());
          newResourceSearchPullBackInfo.setFullSearch(true);
          if(RESOURCE_LOCATION.equals(resourceSearchPullBackInfo.getLocationArea()) || (resourceSearchPullBackInfo.getRsrcRegion() != null && resourceSearchPullBackInfo.getRsrcRegion().length() > 0)) {
            newResourceSearchPullBackInfo.setRsrcRegion(Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, newResourceSearchPullBackInfo.getNameCounty()));
          }
          //not carrying the status for the pagination so add it back to preserve the info
          if(newResourceSearchPullBackInfo.getResourceStatus() == null || newResourceSearchPullBackInfo.getResourceStatus().length() == 0) {
            newResourceSearchPullBackInfo.setResourceStatus(resourceSearchPullBackInfo.getResourceStatus());
          }
          request.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, newResourceSearchPullBackInfo);
          state.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, newResourceSearchPullBackInfo, request);
          resourceSearchPullBackInfo = newResourceSearchPullBackInfo;
        } 
        searchBean = resourceSearchPullBackInfo; 
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Before populating search bean");
        searchBean = createResourceSearchValueBean(request);
      }

      // check if proximity search is required. if it is
      // perform address validation.
      if ("prox".equals(searchBean.getLocationArea())) {
        AddressValidatorSI addressValidatorSI = populateAddressValidatorSI_Resource(context);
        AddressValidatorSO addressValidatorSO = external.validate(addressValidatorSI);
        if (addressValidatorSO != null && addressValidatorSO.isValidated()) {
          // populate bean with coordinates
          searchBean.setIsValid(addressValidatorSO.isValidated());
          searchBean.setLatX(addressValidatorSO.getX());
          searchBean.setLongY(addressValidatorSO.getY());
        } else {
          // inform user that address could not be validated.
          GrndsTrace.msg(TRACE_TAG, 7, "Address information entered is invalid.");
          throw new ServiceException(Messages.MSG_RSRC_PROX_ADDR_INVALID);
        }
      }

      //BaseSessionStateManager state = getSessionStateManager(context);
      state.setAttribute(SEARCH_BEAN_KEY, searchBean, request);
      ValueBeanHelper.populateDefaultValues(context, searchBean);
      // Get any selected resources from previous list page and store to hidden fieldstate

      GrndsTrace.msg(TRACE_TAG, 7, " Executing the search method on the ResourceSearchBean.");
      results = resourceSearch.searchResources(searchBean);

      // filter out open intake or unsubstantiated investigation FA home resources
      if (searchBean.getResourceType().equals("06")) {
      List resourceList = null;
      Map<String, ResourceSearchValueBean> resourceListHashmap = new HashMap<String, ResourceSearchValueBean>();
      if (results != null) {
        resourceList = results.getResults();
        if (resourceList != null) {
          Iterator itrResource = resourceList.iterator();
          while (itrResource.hasNext()) {
            ResourceSearchValueBean currentResource = (ResourceSearchValueBean)itrResource.next();
            String idResourceStr = currentResource.getIdentificationNum();
            int idStage = currentResource.getUlIdStage();
            String disptn = currentResource.getCdDispstn();
            if (resourceListHashmap.containsKey(idResourceStr)) {
              ResourceSearchValueBean hashResource = resourceListHashmap.get(idResourceStr);
              if (!"SUB".equals(hashResource.getCdDispstn())) {
                if ("SUB".equals(disptn) || idStage > hashResource.getUlIdStage()) {
                  resourceListHashmap.remove(idResourceStr);
                  resourceListHashmap.put(idResourceStr, currentResource);
                } 
              }
            } else {
              resourceListHashmap.put(idResourceStr, currentResource);
            }
          }
          
          if (!resourceListHashmap.isEmpty()) {
            Iterator itrResource2 = resourceList.iterator();
            List<ResourceSearchValueBean> resultList = new ArrayList();
            while (itrResource2.hasNext()) {
              ResourceSearchValueBean currentResource2 = (ResourceSearchValueBean)itrResource2.next();
              if (resourceListHashmap.containsValue(currentResource2)) {
                resultList.add(currentResource2);
              }
            }
            results.setResults(resultList);
          }
        }
      }
      }
      // end filter

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
        ResourceSearchValueBean[] selectedResourceBeansArray = new ResourceSearchValueBean[resourceSearchBeanArray.length];
        for (int i = 0; i < resourceSearchBeanArray.length; i++) {
          selectedResourceBeansArray[i] = (ResourceSearchValueBean) SerializationHelper
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
        ResourceSearchValueBean[] previouslySelectedResourceBeansArray = (ResourceSearchValueBean[]) state
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
        ResourceSearchValueBean[] selectedResourceBeansArray;
        // If resources selected on previous pages and last page total more than 25, add only enough of the resources
        // from
        // the lst page to total 25.
        int resultsPerPage = ContextHelper.getIntSafe(request, DatabaseResultDetails.RESULTS_PER_PAGE_NAME);

        if (j > resultsPerPage) {
          selectedResourceBeansArray = new ResourceSearchValueBean[resultsPerPage];
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
              selectedResourceBeansArray[i] = (ResourceSearchValueBean) SerializationHelper
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
          selectedResourceBeansArray = new ResourceSearchValueBean[j];
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
              selectedResourceBeansArray[i] = (ResourceSearchValueBean) SerializationHelper
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
      pageInit(context);
      setPresentationBranch("tooManyResults", context);
      setInformationalMessage(Messages.MSG_CMN_TOO_MANY_RECORDS, RESULTS_COMMAND, request);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_RSRC_PROX_ADDR_INVALID:
        pageInit(context);
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
      results.getResultDetails().setResultsPerPage(50); // todo: change this to a constant
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

    ResourceSearchValueBean bean = (ResourceSearchValueBean) state.getAttribute(SEARCH_BEAN_KEY, request);

    request.setAttribute(SEARCH_BEAN_KEY, bean);
    state.removeAttribute(SEARCH_BEAN_KEY, request);

    pageInit(context);

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
    List<ResourceSearchValueBean> resourceList = new ArrayList<ResourceSearchValueBean>();
    ResourceSearchValueBean selectedResource;
    PaginationResultBean selectedResourceResults = new PaginationResultBean();
    ValueBeanHelper.populateDefaultValues(context, selectedResourceResults);
    selectedResourceResults.getResultDetails().setResultsPerPage(50); // todo: change this to a constant

    DatabaseResultDetails details;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySelectedList_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    ResourceSearchValueBean searchBean = (ResourceSearchValueBean) state.getAttribute(SEARCH_BEAN_KEY, request);
    ValueBeanHelper.populateDefaultValues(context, searchBean);
    state.setAttribute(SEARCH_BEAN_KEY, searchBean, request);

    details = searchBean.getResultDetails();

    try {
      ResourceSearchValueBean[] previousPagesResourceBeanArray = (ResourceSearchValueBean[]) state
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
              selectedResource = (ResourceSearchValueBean) SerializationHelper
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
              selectedResource = (ResourceSearchValueBean) SerializationHelper
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

    HttpServletRequest request = context.getRequest();

    ResourceSearchPullBackInfo resourceSearchPullBackInfo = (ResourceSearchPullBackInfo) request
                                                                                                .getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    String returnUrl = resourceSearchPullBackInfo.getDestinationUrl();
    request.setAttribute("destinationUrl", returnUrl);

    performanceTrace.exitScope();
  }
}

