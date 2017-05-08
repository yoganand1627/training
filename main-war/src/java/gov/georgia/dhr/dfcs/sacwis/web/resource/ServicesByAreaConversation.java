package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Title: ServicesByAreaConversation 
 * Description: Activity Methods used by the ServicesByArea pages
 * 
 * @author Bradley Eilers 
 * <p/> Change History: 
 * Date       User            Description 
 * --------   --------------  ---------------------------------------------------- 
 * 06/07/04   Linda Reed      Added/modified flowerbox comments and Changelog. 
 * 06/07/04   Linda Reed      SIR 17658 - modified edit on client characteristic duplicates to check only
 *                            service/characteristic, not service/characteristic/age/sex on adds and updates. Removed 
 *                            associated unused local variables. 
 * 06/28/05   piazzat         Changes to support MPS
 *                            STGAP00005831: Services By Area pagination implemented ei 11/30/07  
 * 09/19/11   htvo            STGAP00017019:ECEM 5.0: added new save_xa method for Financial services to allow saving multiple services
 *                            to multiple counties across regions. 
 * 09/26/11   htvo            STGAP00017019:ECEM 5.0: added validation for financial services to prevent adding duplicates.                                          
 * 10/18/11   htvo            STGAP00017212: validate duplicate against all existing records as data in state 
 *                            is paginated and does not hold all existing data
 * 12/14/2011 vcollooru       STGAP00017735: Replace the hard-coded region code map with the value from code table and also added region code for Out of State
 * 04/11/2012 vcollooru       STGAP00018067: Regional restructuring - modified static variable NUMBER_OF_REGIONS to 15 from 17 as regions 16 & 17 no longer exists        
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ServicesByAreaConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "ServicesByAreaConversation";

  public static final String SWI_REGION_CODE = "00";

  public static final String STATEWIDE_REGION_CODE = "98";

  public static final String OUT_OF_STATE_REGION_CODE = "99";

  public static final String CRES05SO_ATTRIBUTE_NAME = "CRES05SO";

  public static final String CRES07SO_ATTRIBUTE_NAME = "CRES07SO";

  public static final String CRES05SOG00_ROW_ATTRIBUTE_NAME = "rowcres05sog00";

  public static final String CRES07SOG_ROW_ATTRIBUTE_NAME = "rowcres07sog";

  public static final String SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME = "selectedServiceIndex";

  public static final String SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME = "selectedCharacteristicIndex";

  public static final String DISPLAY_ADD_FINANCIAL_SERVICE_DETAIL_PAGE = "/resource/ServicesByArea/addFinServiceDetail";

  // STGAP00018067: changed the constant value from 17 to 15
  // NOTE: the code which uses this constant is unreachable, hence unable to test the change
  public static final int NUMBER_OF_REGIONS = 15;

  protected static final int SERVICES_PER_PAGE = 65;

  public static final String ALL_REGIONS = CodesTables.CSVCRGNS_95;
  
  private Resource resource;

  public static Map<String,String> REGION_MAP = new HashMap<String,String>();

  public static Map<Integer,String> REGION_INDEX = new HashMap<Integer,String>();

  public static Map<String,String> REGION_COUNTY_MAP = new HashMap<String,String>();

  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  /**
   * STGAP00017735
   * The Static block executes the code to populate the following static variables -
   * 	  i) REGION_MAP - containing Region(code,decode) as key-value pair
   * 	 ii) REGION_INDEX - containing the index-region code as key-value pair
   * 	iii) REGION_COUNTY_MAP - containing Region code - county code array as key-value pair
   */
	static {
		// Region, county code array map used for Service Area
		List<CodeAttributes> regionList = null;
		try {
			regionList = Lookup.getCategoryCollection("CSVCRGNS");
		} catch (LookupException e) {
		      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
		}
		if (regionList != null) {
			int index = 1;
			for (Iterator<CodeAttributes> itr = regionList.iterator(); itr
					.hasNext();) {
				CodeAttributes codeAttributes = itr.next();
				String regionCode = codeAttributes.getCode();
				if (ServicesByAreaConversation.ALL_REGIONS.equals(regionCode)) {
					continue;
				}
				String regionDecode = codeAttributes.getDecode();
				String countyCodeArray = "CCOUNT" + regionCode;
				REGION_MAP.put(regionCode, regionDecode);
				REGION_INDEX.put(index, regionCode);
				REGION_COUNTY_MAP.put(regionCode, countyCodeArray);
				index++;
			}
		}
	}
  /**
   * Retrieves Services List. Calls cres05s
   * 
   * @param context
   */
  public void displayServiceList_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".displayServiceList_xa");
    try {
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(SERVICES_PER_PAGE);
      BaseSessionStateManager state = getSessionStateManager(context);
      HttpServletRequest request = context.getRequest();

      // HD 5/16/2003 -- SIR 17480
      clearStatePreserve(context);
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(SERVICES_PER_PAGE);
      CRES05SO cres05so = getServices(context, tuxPagination);
      request.setAttribute(CRES05SO_ATTRIBUTE_NAME, cres05so);
      state.setAttribute(CRES05SO_ATTRIBUTE_NAME, cres05so, context.getRequest());
      tuxPagination.setPaginationInformation(cres05so.getArchOutputStruct(), cres05so.getROWCRES05SOG00_ARRAY()
              .getROWCRES05SOG00Count());

      CRES07SO cres07so = getClientCharacteristics(context, tuxPagination);
      request.setAttribute(CRES07SO_ATTRIBUTE_NAME, cres07so);
      state.setAttribute(CRES07SO_ATTRIBUTE_NAME, cres07so, context.getRequest());

      super.storePaginationBeanToRequest(context, tuxPagination);

      PageMode.setPageMode(GlobalData.getAppMode(request), request);
    } catch (ServiceException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres05s or cres07s: " + e.getMessage());
      int errorCode = e.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_ROWS_RETURNED:
        break;
      default:
        processSevereException(context, e);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
  }

  public void refreshCharacteristicList_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".refreshCharacteristicList_xa");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(SERVICES_PER_PAGE);

      if (StringHelper.isValid(request.getParameter("page"))) {
        tuxPagination.getResultDetails().setRequestedPage(ContextHelper.getIntSafe(request, "page"));
      } else {
        tuxPagination.getResultDetails().setRequestedPage(1);
      }

      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      CRES05SO cres05so = (CRES05SO) state.getAttribute(CRES05SO_ATTRIBUTE_NAME, request);
      request.setAttribute(CRES05SO_ATTRIBUTE_NAME, cres05so);

      CRES07SO cres07so = getClientCharacteristics(context, tuxPagination);
      request.setAttribute(CRES07SO_ATTRIBUTE_NAME, cres07so);
      // set the information into the pagination bean and then store it to the request
      // set the information into the pagination bean and then store it to the request
      if (cres07so.getROWCRES07SOG_ARRAY() != null && cres07so.getArchOutputStruct() != null) {
        tuxPagination.setPaginationInformation(cres07so.getArchOutputStruct(), cres07so.getROWCRES07SOG_ARRAY()
                                                                                       .getROWCRES07SOGCount());
      } else {
        ArchOutputStruct archOutputStruct = new ArchOutputStruct();
        archOutputStruct.setBMoreDataInd(ArchitectureConstants.N);
        tuxPagination.setPaginationInformation(archOutputStruct, 0);
      }

      state.removeAttribute(CRES07SO_ATTRIBUTE_NAME, context.getRequest());
      state.setAttribute(CRES07SO_ATTRIBUTE_NAME, cres07so, context.getRequest());

    } catch (ServiceException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres07s: " + e.getMessage());
      state.removeAttribute(CRES07SO_ATTRIBUTE_NAME, context.getRequest());
      request.removeAttribute(CRES07SO_ATTRIBUTE_NAME);
      processSevereException(context, e);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
  }

  /**
   * Retrieves Services List. Calls cres05s
   * 
   * @param context
   */
  private CRES05SO getServices(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination)
                                                                                                     throws ServiceException,
                                                                                                     MarshalException,
                                                                                                     ValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".getServices");

    HttpServletRequest request = context.getRequest();

    clearStatePreserve(context);

    CRES05SI cres05si = new CRES05SI();

    // Set Pagination data
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    cres05si.setArchInputStruct(input);
    // Set Non-Pagination values into input
    int idResource = GlobalData.getUlIdResource(request);
    cres05si.setUlIdResource(idResource);

    CRES05SO cres05so = resource.retrieveAreaServed(cres05si);
    if(ArchitectureConstants.Y.equals(cres05so.getCIndFadHome())){
      GlobalData.setAppMode(PageModeConstants.EDIT, request);
    }
    GrndsTrace.exitScope();
    return cres05so;
  }

  /**
   * Retrieves Services List. Calls cres07s
   * 
   * @param context
   */
  private CRES07SO getClientCharacteristics(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination)
                                                                                                                  throws ServiceException,
                                                                                                                  MarshalException,
                                                                                                                  ValidationException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".getClientCharacteristics");

      HttpServletRequest request = context.getRequest();
      CRES05SO cres05so = (CRES05SO) request.getAttribute(CRES05SO_ATTRIBUTE_NAME);

      // if a txtUlIdResourceService was specified on request, use it
      // Otherwise, get the first id from the Services array

      int selectedServiceIndex = ContextHelper.getIntSafe(request, SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);

      if (selectedServiceIndex >= cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00Count()) {
        selectedServiceIndex = 0;
      }

      int idResourceService = 0;
      // check to make sure that size of array is greater than 0
      if (cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00Count() > 0) {
        idResourceService = cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(selectedServiceIndex)
                                    .getUlIdResourceService();
      }

      request.setAttribute("txtUlIdResourceService", "" + idResourceService);

      GrndsTrace.msg(TRACE_TAG, 10, "txtUlIdResourceService is " + idResourceService);
      CRES07SI cres07si = new CRES07SI();

      ArchInputStruct input = new ArchInputStruct();
      input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
      input.setUlPageSizeNbr(50);
      cres07si.setArchInputStruct(input);

      // Set Non-Pagination values into input
      cres07si.setUlIdResourceService(idResourceService);

      CRES07SO cres07so = resource.retrieveCharacteristicsData(cres07si);

      GrndsTrace.exitScope();
      return cres07so;
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_ROWS_RETURNED:
        CRES07SO cres07so = new CRES07SO();
        cres07so.setROWCRES07SOG_ARRAY(new ROWCRES07SOG_ARRAY());
        return cres07so;

      default:
        break;
      }
      throw e;
    }
  }

  /** @param context */
  public void displayServiceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".displayServiceDetail_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    int index = ContextHelper.getIntSafe(request, SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);

    // Place individual row object on request
    ROWCRES05SOG00 service = getService(context, index);
    request.setAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, service);
    state.setAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, service, request);

    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    GrndsTrace.exitScope();
  }

  /**
   * Retrieves detail row from Hidden Field State
   * 
   * @param context
   */
  private ROWCRES05SOG00 getService(GrndsExchangeContext context, int index) {
    GrndsTrace.enterScope(TRACE_TAG + ".getService");

    HttpServletRequest request = context.getRequest();
    GrndsTrace.msg(TRACE_TAG, 10, "index is " + index);

    BaseSessionStateManager state = getSessionStateManager(context);
    CRES05SO cres05so = (CRES05SO) state.getAttribute(CRES05SO_ATTRIBUTE_NAME, request);

    ROWCRES05SOG00 service = cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(index);

    GrndsTrace.exitScope();
    return service;
  }

  /**
   * Not sure if this needs to do anything
   * 
   * @param context
   */
  public void addServiceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".addServiceDetail_xa");
    GrndsTrace.exitScope();
  }

  /**
   * Delete Services Detail calls cres06s
   * 
   * @param context
   */
  public void deleteServiceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteServiceDetail_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCRES05SOG00 rowcres05sog00 = (ROWCRES05SOG00) state.getAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);

    if (rowcres05sog00 == null) {
      // Row is null, so this is from service area.
      // Get the detail row from the array and add it to the state.
      int index = ContextHelper.getIntSafe(request, SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);
      ROWCRES05SOG00 service = getService(context, index);
      request.setAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, service);
      state.setAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, service, request);
    }

    try {
      // populate the request object
      CRES06SI cres06si = populateServiceFromState(context);

      // Pull service detail back off request
      // We're going back to the Services By Area page, so
      // we don't need the row data anymore.
      state.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);
      request.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME);

      // Call the Service
      resource.saveAreaServed(cres06si);
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres06s: " + we.getMessage());

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling cres06s: " + e.getMessage());
      processSevereException(context, e);
    }

    // Remove individual service from state
    state.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);
    state.removeAttribute(CRES07SO_ATTRIBUTE_NAME, request);
    state.removeAttribute(CRES05SO_ATTRIBUTE_NAME, request);
    request.setAttribute("tmpPageNum", "1"); // not removed in conversation

    GrndsTrace.exitScope();
  }

  /**
   * Save Services Detail calls cres06s
   * 
   * @param context
   */
  private boolean similarContractedServiceRowExists(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".similarContractedServiceRowExists");
    boolean dupRow = false;

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Ignore checking for dupes in update mode.
    if (StringHelper.checkForEquality(request.getParameter("SzCdScrDataAction"), "U")) {
      return false;
    }

    CRES05SO cres05so = (CRES05SO) state.getAttribute(CRES05SO_ATTRIBUTE_NAME, request);

    if (cres05so != null) {
      ROWCRES05SOG00_ARRAY rowcres05sog00_array = cres05so.getROWCRES05SOG00_ARRAY();

      boolean bStateWide = (StringHelper.checkForEquality(request.getParameter("selSzCdRsrcSvcRegion"),
                                                          STATEWIDE_REGION_CODE));
      boolean bRegionWide = (StringHelper.checkForEquality(request.getParameter("cbxBIndRsrcSvcCntyAll"), ArchitectureConstants.Y));
      String service = request.getParameter("selSzCdRsrcSvcService");
      String region = request.getParameter("selSzCdRsrcSvcRegion");
      String serviceType = request.getParameter("rbServiceType");
      int id = ContextHelper.getIntSafe(request, "txtUlIdResourceService");

      for (int i = 0; i < rowcres05sog00_array.getUlRowQty(); ++i) {
        int currId = rowcres05sog00_array.getROWCRES05SOG00(i).getUlIdResourceService();

        // Make sure we don't check the row against itself.
        if (id != currId) {
          boolean bContracted = (rowcres05sog00_array.getROWCRES05SOG00(i).getUlNbrCntrctNumber() > 0);
          String currService = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcService();
          boolean bSameService = StringHelper.checkForEquality(service, currService);
          String currRegion = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcRegion();
          boolean bSameRegion = StringHelper.checkForEquality(region, currRegion);
          String currServiceType = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcServiceType();
          boolean bSameServiceType = StringHelper.checkForEquality(serviceType, currServiceType);

          if ((bSameServiceType && bStateWide && bSameService && bContracted)
              || (bSameServiceType && bRegionWide && bSameRegion && bSameService && bContracted)) {
            dupRow = true;
          }
        }
      }
    }

    GrndsTrace.exitScope();
    return dupRow;
  }

  private boolean similarServiceRowExists(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".similarServiceRowExists");

    boolean dupRow = false;
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Ignore checking for dupes in update mode.
    if (StringHelper.checkForEquality(request.getParameter("SzCdScrDataAction"), "U")) {
      return false;
    }

    CRES05SO cres05so = (CRES05SO) state.getAttribute(CRES05SO_ATTRIBUTE_NAME, request);

    if (cres05so != null) {
      ROWCRES05SOG00_ARRAY rowcres05sog00_array = cres05so.getROWCRES05SOG00_ARRAY();

      // if same state, service, region, and there is a regionwide row already
      //boolean bRegionWide = StringHelper.checkForEquality(CheckboxHelper.getCheckboxValue(request, "cbxBIndRsrcSvcCntyAll"), ArchitectureConstants.Y);

      String stateString = request.getParameter("selSzCdRsrcSvcState");
      String service = request.getParameter("selSzCdRsrcSvcService");
      String region = request.getParameter("selSzCdRsrcSvcRegion");
      int id = ContextHelper.getIntSafe(request, "txtUlIdResourceService");
      String serviceType = request.getParameter("rbServiceType");

      for (int i = 0; i < rowcres05sog00_array.getROWCRES05SOG00Count(); ++i) {
        int currId = rowcres05sog00_array.getROWCRES05SOG00(i).getUlIdResourceService();

        // Make sure we don't check the row against itself.
        if (id != currId) {
          String currState = StringHelper.getNonNullString(rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcState());
          boolean bSameState = StringHelper.checkForEquality(stateString, currState);

          String currService = StringHelper.getNonNullString(rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcService());
          boolean bSameService = StringHelper.checkForEquality(service, currService);

          String currRegion = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcRegion();
          boolean bSameRegion = StringHelper.checkForEquality(region, currRegion);

          String currCounty = StringHelper.getNonNullString(rowcres05sog00_array.getROWCRES05SOG00(i).getSzScrRsrcSvcCntyCode());
          boolean bCurrRegionWide = StringHelper.checkForEquality(currCounty, StringHelper.EMPTY_STRING);
          
          String currServiceType = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcServiceType();
          boolean bSameServiceType = StringHelper.checkForEquality(serviceType, currServiceType);

          if (bSameServiceType && bSameState && bSameService && bSameRegion && bCurrRegionWide) {
            dupRow = true;
          }
        }
      }
    }

    GrndsTrace.exitScope();
    return dupRow;
  }

  private CRES06SI populateServiceForRegionwideProc(GrndsExchangeContext context, String region, String actionCode,
                                                    boolean popFromState) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateServiceForRegionwideProc");

    HttpServletRequest request = context.getRequest();
    CRES06SI cres06si = new CRES06SI();
    ROWCRES06SIG row = new ROWCRES06SIG();
    ROWCRES06SIG_ARRAY rowArray = new ROWCRES06SIG_ARRAY();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCRES05SOG00 rowcres05sog00 = (ROWCRES05SOG00) state.getAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);

    if (rowcres05sog00 == null) {
      rowcres05sog00 = new ROWCRES05SOG00();
    }

    if (popFromState) {
      row.setSzCdRsrcSvcServiceType(rowcres05sog00.getSzCdRsrcSvcServiceType());
      row.setBIndRsrcSvcCntyPartial(rowcres05sog00.getBIndRsrcSvcCntyPartial());
      row.setCIndRsrcSvcIncomeBsed(rowcres05sog00.getCIndRsrcSvcIncomeBsed());
      row.setSzCdRsrcSvcCategRsrc(rowcres05sog00.getSzCdRsrcSvcCategRsrc());
      row.setSzCdRsrcSvcProgram(rowcres05sog00.getSzCdRsrcSvcProgram());
      row.setSzCdRsrcSvcService(rowcres05sog00.getSzCdRsrcSvcService());
      row.setSzCdRsrcSvcState(rowcres05sog00.getSzCdRsrcSvcState());
      row.setSzScrRsrcSvcCntyCode(rowcres05sog00.getSzScrRsrcSvcCntyCode());
      row.setCIndRsrcSvcShowRow(rowcres05sog00.getCIndRsrcSvcShowRow());
      row.setUlIdResourceService(rowcres05sog00.getUlIdResourceService());
      row.setTsLastUpdate(rowcres05sog00.getTsLastUpdate());
    } else {
      row.setBIndRsrcSvcCntyPartial(ArchitectureConstants.N);
      if (StringHelper.isValid(request.getParameter("cbxBIndRsrcSvcCntyPartial"))) {
        row.setBIndRsrcSvcCntyPartial(ArchitectureConstants.Y);
      }
      if (StringHelper.isTrue(request.getParameter("cbxCIndRsrcSvcIncomeBsed"))) {
        row.setCIndRsrcSvcIncomeBsed(ArchitectureConstants.Y);
      } else {
        row.setCIndRsrcSvcIncomeBsed(ArchitectureConstants.N);
      }
      row.setSzCdRsrcSvcServiceType(request.getParameter("rbServiceType"));
      row.setSzCdRsrcSvcCategRsrc(request.getParameter("selSzCdRsrcSvcCategRsrc"));
      row.setSzCdRsrcSvcProgram(request.getParameter("selSzCdRsrcSvcProgram"));
      row.setSzCdRsrcSvcService(request.getParameter("selSzCdRsrcSvcService"));
      row.setSzCdRsrcSvcState(request.getParameter("selSzCdRsrcSvcState"));
      row.setSzScrRsrcSvcCntyCode(request.getParameter("selSzScrRsrcSvcCntyCode"));
      row.setCIndRsrcSvcShowRow(ArchitectureConstants.Y);
      row.setTsLastUpdate(rowcres05sog00.getTsLastUpdate());
    }

    row.setUlIdResource(GlobalData.getUlIdResource(request));
    row.setSzCdRsrcSvcRegion(region);

    // set the function code into cres06si
    row.setSzCdScrDataAction(actionCode);

    rowArray.addROWCRES06SIG(row);
    cres06si.setROWCRES06SIG_ARRAY(rowArray);
    cres06si.setUlRowQty(1);

    GrndsTrace.exitScope();
    return cres06si;
  }

  private void deleteRegionalServicesForStatewideRow(GrndsExchangeContext context) throws ServiceException,
                                                                                  MarshalException, ValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteRegionalServicesForStatewide");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CRES05SO cres05so = (CRES05SO) state.getAttribute(CRES05SO_ATTRIBUTE_NAME, request);

    // If we don't pull back any rows, then there's nothing to delete.
    // We can just return.
    if (cres05so == null) {
      return;
    }

    ROWCRES05SOG00_ARRAY rowarray = cres05so.getROWCRES05SOG00_ARRAY();

    // We're doing this for eleven regions. Heaven help us if they split
    // the state up and add more.
    for (int jj = 1; jj <= NUMBER_OF_REGIONS; ++jj) {
      String sj = "" + jj;
      if (jj < 10) {
        sj = "0".concat(sj);
      }

      // Loop through array, look for existing regionwide rows,
      // and get their timestamps.
      Enumeration services = rowarray.enumerateROWCRES05SOG00();
      while (services.hasMoreElements()) {
        ROWCRES05SOG00 thisRow = (ROWCRES05SOG00) services.nextElement();

        // we need to compare
        // service, region, state, and county fields
        // to find matches
        String currState = request.getParameter("selSzCdRsrcSvcState");
        boolean bSameState = StringHelper.checkForEquality(thisRow.getSzCdRsrcSvcState(), currState);

        // String currRegion = request.getParameter("selSzCdRsrcSvcRegion");
        boolean bSameRegion = StringHelper.checkForEquality(thisRow.getSzCdRsrcSvcRegion(), sj);

        String currCounty = request.getParameter("selSzScrRsrcSvcCntyCode");
        boolean bSameCounty = StringHelper.checkForEquality(thisRow.getSzScrRsrcSvcCntyCode(), currCounty);

        String currService = request.getParameter("selSzCdRsrcSvcService");
        boolean bSameService = StringHelper.checkForEquality(thisRow.getSzCdRsrcSvcService(), currService);

        String currServiceType = request.getParameter("rbServiceType");
        boolean bSameServiceType = StringHelper.checkForEquality(thisRow.getSzCdRsrcSvcServiceType(), currServiceType);

        boolean bFoundMatch = (bSameState && bSameRegion && bSameCounty && bSameService && bSameServiceType);

        if (bFoundMatch) {
          state.setAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, thisRow, request);

          CRES06SI cres06si = populateServiceForRegionwideProc(context, sj, "D", true);
          resource.saveAreaServed(cres06si);
        }
      }
    }

    GrndsTrace.exitScope();
  }

  public void saveServiceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".saveServiceDetail_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      if (similarContractedServiceRowExists(context)) {
        /*
         * ECEM 5.0: this existing logic is broken but do not fix. The above function used rowQty which is not set so no error found, if any. 
         * However, during ECEM 5.0, user (Susan Morgan, Suzy Johnson) confirmed that it is correct behavior. The new validation 
         * logic for Financial service therefore  did not implement this. If this changes, similarContractedFinServiceRowExists 
         * must be updated the same way.
         */
        setErrorMessage(Messages.MSG_RES_ROW_CNTRCTD, request); 
        setPresentationBranch("error", context);
      } else if (similarServiceRowExists(context)) {
        setErrorMessage(Messages.MSG_RES_ROW_EXISTS, request);
        setPresentationBranch("error", context);
      } else {
        // check to see if we're trying to add a statewide row.
        // if so, we'll need to remove old regionwide rows for this service,
        // then add eleven new ones.

        if (StringHelper.checkForEquality(request.getParameter("selSzCdRsrcSvcRegion"), STATEWIDE_REGION_CODE)) {
          // first, delete the old regionwide rows.
          deleteRegionalServicesForStatewideRow(context);

          // now save one regionwide row for each region.
          for (int jj = 1; jj <= NUMBER_OF_REGIONS; ++jj) {
            String sj = "" + jj;
            if (jj < 10) {
              sj = "0".concat(sj);
            }

            CRES06SI cres06si = populateServiceForRegionwideProc(context, sj, "A", false);
            resource.saveAreaServed(cres06si);
          }
        } else {
          // just save the row.
          // get all of the parameters into cres06si
          CRES06SI cres06si = populateServiceFromRequest(context);
          resource.saveAreaServed(cres06si);
        }
      }

      // Remove individual service row from state
      state.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, context.getRequest());
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres06s: " + we.getMessage());
      we.printStackTrace();

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CMN_UPDATE_FAILED:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, request);
        break;
      case Messages.MSG_CON_COUNTY_VIOLATION:
        //setPresentationBranch("error", context);
        //setErrorMessage(errorCode, request);
        setPopUpMessage(Messages.MSG_CON_COUNTY_VIOLATION, context.getRequest());
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling cres06s: " + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope();
  }

  private CRES06SI populateServiceFromRequest(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateServiceFromRequest");

    HttpServletRequest request = context.getRequest();
    CRES06SI cres06si = new CRES06SI();
    ROWCRES06SIG row = new ROWCRES06SIG();
    ROWCRES06SIG_ARRAY rowArray = new ROWCRES06SIG_ARRAY();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCRES05SOG00 rowcres05sog00 = (ROWCRES05SOG00) state.getAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);
    if (rowcres05sog00 == null) {
      rowcres05sog00 = new ROWCRES05SOG00();
    }

    row.setBIndRsrcSvcCntyPartial(ArchitectureConstants.N);
    if (StringHelper.isTrue(request.getParameter("partCounties"))) {
      row.setBIndRsrcSvcCntyPartial(ArchitectureConstants.Y);
    }

    if (StringHelper.isTrue(request.getParameter("cbxCIndRsrcSvcIncomeBsed"))) {
      row.setCIndRsrcSvcIncomeBsed(ArchitectureConstants.Y);
    } else {
      row.setCIndRsrcSvcIncomeBsed(ArchitectureConstants.N);
    }

    row.setSzCdRsrcSvcCategRsrc(request.getParameter("selSzCdRsrcSvcCategRsrc"));
    row.setSzCdRsrcSvcProgram(request.getParameter("selSzCdRsrcSvcProgram"));
    row.setSzCdRsrcSvcRegion(request.getParameter("selSzCdRsrcSvcRegion"));
    row.setSzCdRsrcSvcService(request.getParameter("selSzCdRsrcSvcService"));
    row.setSzCdRsrcSvcServiceType(request.getParameter("rbServiceType"));
    row.setSzCdRsrcSvcState(request.getParameter("selSzCdRsrcSvcState"));
    row.setSzScrRsrcSvcCntyCode(request.getParameter("selSzScrRsrcSvcCntyCode"));
    row.setCIndRsrcSvcShowRow(ArchitectureConstants.Y);
    row.setTsLastUpdate(rowcres05sog00.getTsLastUpdate());
    row.setUlIdResource(GlobalData.getUlIdResource(request));
    row.setUlIdResourceService(ContextHelper.getIntSafe(request, "txtUlIdResourceService"));
    // set the function code, A or U into cres06si
    row.setSzCdScrDataAction(request.getParameter("SzCdScrDataAction"));

    rowArray.addROWCRES06SIG(row);

    cres06si.setROWCRES06SIG_ARRAY(rowArray);
    cres06si.setUlRowQty(1);

    GrndsTrace.exitScope();
    return cres06si;
  }

  private CRES06SI populateServiceFromState(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateServiceFromState");

    HttpServletRequest request = context.getRequest();
    CRES06SI cres06si = new CRES06SI();
    ROWCRES06SIG row = new ROWCRES06SIG();
    ROWCRES06SIG_ARRAY rowArray = new ROWCRES06SIG_ARRAY();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCRES05SOG00 rowcres05sog00 = (ROWCRES05SOG00) state.getAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);

    row.setBIndRsrcSvcCntyPartial(rowcres05sog00.getBIndRsrcSvcCntyPartial());
    row.setCIndRsrcSvcIncomeBsed(rowcres05sog00.getCIndRsrcSvcIncomeBsed());
    row.setSzCdRsrcSvcCategRsrc(rowcres05sog00.getSzCdRsrcSvcProgram());
    row.setSzCdRsrcSvcProgram(rowcres05sog00.getSzCdRsrcSvcProgram());
    row.setSzCdRsrcSvcRegion(rowcres05sog00.getSzCdRsrcSvcRegion());
    row.setSzCdRsrcSvcService(rowcres05sog00.getSzCdRsrcSvcService());
    row.setSzCdRsrcSvcState(rowcres05sog00.getSzCdRsrcSvcState());
    row.setSzScrRsrcSvcCntyCode(rowcres05sog00.getSzScrRsrcSvcCntyCode());
    row.setCIndRsrcSvcShowRow(rowcres05sog00.getCIndRsrcSvcShowRow());
    row.setTsLastUpdate(rowcres05sog00.getTsLastUpdate());
    row.setSzCdRsrcSvcServiceType(rowcres05sog00.getSzCdRsrcSvcServiceType());

    row.setUlIdResource(GlobalData.getUlIdResource(request));
    row.setUlIdResourceService(rowcres05sog00.getUlIdResourceService());
    // set the function code, A, U, or D into cres06si
    row.setSzCdScrDataAction(request.getParameter("SzCdScrDataAction"));

    rowArray.addROWCRES06SIG(row);
    cres06si.setROWCRES06SIG_ARRAY(rowArray);
    cres06si.setUlRowQty(1);

    GrndsTrace.exitScope();
    return cres06si;
  }

  private ROWCRES07SOG getServiceCRES07(GrndsExchangeContext context, int index) {
    GrndsTrace.enterScope(TRACE_TAG + ".getServiceCRES07");

    HttpServletRequest request = context.getRequest();
    GrndsTrace.msg(TRACE_TAG, 10, "index is " + index);

    BaseSessionStateManager state = getSessionStateManager(context);
    CRES07SO cres07so = (CRES07SO) state.getAttribute(CRES07SO_ATTRIBUTE_NAME, request);
    ROWCRES07SOG service = cres07so.getROWCRES07SOG_ARRAY().getROWCRES07SOG(index);

    GrndsTrace.msg(TRACE_TAG, 10, "service idResSvc is " + service.getUlIdResourceChrctr());

    GrndsTrace.exitScope();
    return service;
  }

  /**
   * Retrieves Client Characteristics Detail calls cres07s
   * 
   * @param context
   */
  public void displayClientCharacteristicDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".displayClientCharacteristicDetail");

    HttpServletRequest request = context.getRequest();

    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    GrndsTrace.exitScope();
  }

  /**
   * Not sure if this needs to do anything
   * 
   * @param context
   */
  public void addClientCharacteristicDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".addClientCharacteristicDetail_xa");
    GrndsTrace.exitScope();
  }

  /**
   * Deletes a client Characteristic calls cres08s
   * 
   * @param context
   */
  public void deleteClientCharacteristicDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteClientCharacteristicDetail_xa");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    int txtUlIdResource = GlobalData.getUlIdResource(request);

    ROWCRES05SOG00 service = (ROWCRES05SOG00) state.getAttribute("serviceRow", request);
    if (service == null) {
      // Row is null, so this is from service area.
      // Get the detail row from the array and add it to the state.
      int index = ContextHelper.getIntSafe(request, SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);
      service = getService(context, index);
      state.setAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, service, request);
    }

    ROWCRES07SOG characteristic = (ROWCRES07SOG) state.getAttribute(CRES07SOG_ROW_ATTRIBUTE_NAME, request);

    if (characteristic == null) {
      // Row is null, so this is from service area.
      // Get the detail row from the array and add it to the state.
      if (StringHelper.isValid(request.getParameter(SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME))) {
        int index = ContextHelper.getIntSafe(request, SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME);
        characteristic = getServiceCRES07(context, index);
        state.setAttribute(CRES07SOG_ROW_ATTRIBUTE_NAME, characteristic, request);
      }
    }

    CRES08SI cres08si = populateServiceCRES08FromState(context);
    cres08si.setSzCdRsrcCharService(service.getSzCdRsrcSvcService());
    cres08si.setUlIdResource(txtUlIdResource);
    cres08si.setUlIdResourceService(service.getUlIdResourceService());

    if (!(StringHelper.isValid(service.getSzScrRsrcSvcCntyCode()))
        && StringHelper.isValid(service.getSzCdRsrcSvcRegion())
        && (StringHelper.checkForEquality(service.getSzCdRsrcSvcRegion(), SWI_REGION_CODE) || StringHelper
                                                                                                          .checkForEquality(
                                                                                                                            service
                                                                                                                                   .getSzCdRsrcSvcRegion(),
                                                                                                                            OUT_OF_STATE_REGION_CODE))) {
      cres08si.setSzCdRsrcCharRegion(service.getSzCdRsrcSvcRegion());
    }

    try {
      resource.saveResourceCharacteristics(cres08si);

    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres08s: " + we.getMessage());

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling cres08s: " + e.getMessage());
      processSevereException(context, e);
    }

    // Pull service detail and characteristic detail back off request
    // We're going back to the Services By Area page, so
    // we don't need the row data anymore.
    // request.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME);
    state.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);
    state.removeAttribute(CRES07SOG_ROW_ATTRIBUTE_NAME, request);
    state.removeAttribute("serviceRow", request);
    state.removeAttribute(CRES07SO_ATTRIBUTE_NAME, request);
    state.removeAttribute(CRES05SO_ATTRIBUTE_NAME, request);

    GrndsTrace.exitScope();
  }

  private CRES08SI populateServiceCRES08FromState(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateServiceCRES08FromState");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CRES08SI cres08si = new CRES08SI();
    ROWCRES08SIG00 row0 = new ROWCRES08SIG00();
    ROWCRES08SIG00_ARRAY row0Array = new ROWCRES08SIG00_ARRAY();
    ROWCRES08SIG01 row1 = new ROWCRES08SIG01();
    ROWCRES08SIG01_ARRAY row1Array = new ROWCRES08SIG01_ARRAY();

    ROWCRES07SOG rowcres07sog = (ROWCRES07SOG) state.getAttribute(CRES07SOG_ROW_ATTRIBUTE_NAME, request);

    row0.setCCdRsrcCharSex(rowcres07sog.getCCdRsrcCharSex());
    row0.setSzCdRsrcCharChrctr(rowcres07sog.getSzCdRsrcCharChrctr());
    row0.setTsLastUpdate(rowcres07sog.getTsLastUpdate());
    row0.setUlIdResourceChrctr(rowcres07sog.getUlIdResourceChrctr());
    row0.setUNbrRsrcCharMaxFAge(rowcres07sog.getUNbrRsrcCharMaxFAge());
    row0.setUNbrRsrcCharMaxMAge(rowcres07sog.getUNbrRsrcCharMaxMAge());
    row0.setUNbrRsrcCharMinFAge(rowcres07sog.getUNbrRsrcCharMinFAge());
    row0.setUNbrRsrcCharMinMAge(rowcres07sog.getUNbrRsrcCharMinMAge());

    row1.setSzCdRsrcCharChrctr(rowcres07sog.getSzCdRsrcCharChrctr());
    row1.setUNbrRsrcCharMaxFAge(rowcres07sog.getUNbrRsrcCharMaxFAge());
    row1.setUNbrRsrcCharMaxMAge(rowcres07sog.getUNbrRsrcCharMaxMAge());
    row1.setUNbrRsrcCharMinFAge(rowcres07sog.getUNbrRsrcCharMinFAge());
    row1.setUNbrRsrcCharMinMAge(rowcres07sog.getUNbrRsrcCharMinMAge());

    // set the function code, A, U, or D into cres08si
    row0.setSzCdScrDataAction(request.getParameter("SzCdScrDataAction"));

    row0Array.addROWCRES08SIG00(row0);
    cres08si.setROWCRES08SIG00_ARRAY(row0Array);

    row1Array.addROWCRES08SIG01(row1);
    cres08si.setROWCRES08SIG01_ARRAY(row1Array);

    cres08si.setUlRowQty(1);

    GrndsTrace.exitScope();
    return cres08si;
  }

  private boolean similarCharacteristicRowExists(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".similarCharacteristicRowExists");

    boolean dupRow = false;
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CRES07SO cres07so = (CRES07SO) state.getAttribute(CRES07SO_ATTRIBUTE_NAME, request);
    ROWCRES07SOG_ARRAY rowcres07sog_array = cres07so.getROWCRES07SOG_ARRAY();

    if (rowcres07sog_array == null) {
      GrndsTrace.msg("TRACE_TAG", 10, "Null characteristics array.");
    } else if (rowcres07sog_array.getUlRowQty() < 1) {
      GrndsTrace.msg("TRACE_TAG", 10, "Characteristics array is empty.");
    } else {
      GrndsTrace.msg("TRACE_TAG", 10, "Characteristics array has " + rowcres07sog_array.getUlRowQty() + " rows.");
    }

    // if same characteristic, we have a dup.
    String sCharacteristic = request.getParameter("clientCharacteristics");

    // SIR 17658 - re-define edit for client chararacteristic duplicates
    int chrindex = ContextHelper.getIntSafe(request, "selectedCharacteristicIndex");

    int i = 0;
    Enumeration erowcres07sog_array = rowcres07sog_array.enumerateROWCRES07SOG();
    while (erowcres07sog_array.hasMoreElements()) {
      ROWCRES07SOG rowcres07sog = (ROWCRES07SOG) erowcres07sog_array.nextElement();
      boolean bSameIndex = (i == chrindex);
      String currCharacteristic = rowcres07sog.getSzCdRsrcCharChrctr();
      boolean bSameCharacteristic = StringHelper.checkForEquality(currCharacteristic, sCharacteristic);
      // // SIR 17658 - re-define edit for client chararacteristic duplicates
      String SzCdScrDataAction = request.getParameter("SzCdScrDataAction");
      if ((bSameCharacteristic && StringHelper.checkForEquality(SzCdScrDataAction, "A"))
          || (bSameCharacteristic && StringHelper.checkForEquality(SzCdScrDataAction, "U") && !bSameIndex)) {
        dupRow = true;
      }
      i++;
    }

    GrndsTrace.exitScope();
    return dupRow;
  }

  /**
   * Saves a client Characteristic calls cres08s
   * 
   * @param context
   */
  public void saveClientCharacteristicDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".saveClientCharacteristicDetail_xa");
    HttpServletRequest request = context.getRequest();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      CRES07SO cres07so = (CRES07SO) state.getAttribute(CRES07SO_ATTRIBUTE_NAME, request);
      int index = ContextHelper.getIntSafe(request, SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);
      ROWCRES05SOG00 service = getService(context, index);

      int txtUlIdResource = GlobalData.getUlIdResource(request);

      ROWCRES07SOG_ARRAY oldCharacteristicsArray = null;

      if (cres07so != null) {
        oldCharacteristicsArray = cres07so.getROWCRES07SOG_ARRAY();
      }

      CRES08SI cres08si = new CRES08SI();
      ROWCRES08SIG00_ARRAY rowcres08sig00_array = new ROWCRES08SIG00_ARRAY();
      ROWCRES08SIG01_ARRAY rowcres08sig01_array = new ROWCRES08SIG01_ARRAY();

      if (service != null) {
        if (!(StringHelper.isValid(service.getSzScrRsrcSvcCntyCode()))
            && StringHelper.isValid(service.getSzCdRsrcSvcRegion())
            && (StringHelper.checkForEquality(service.getSzCdRsrcSvcRegion(), SWI_REGION_CODE) || StringHelper
                                                                                                              .checkForEquality(
                                                                                                                                service
                                                                                                                                       .getSzCdRsrcSvcRegion(),
                                                                                                                                OUT_OF_STATE_REGION_CODE))) {
          cres08si.setSzCdRsrcCharRegion(service.getSzCdRsrcSvcRegion());
        } else {
          cres08si.setSzCdRsrcCharRegion(null);
        }
        cres08si.setSzCdRsrcCharService(service.getSzCdRsrcSvcService());
        cres08si.setUlIdResource(txtUlIdResource);
        cres08si.setUlIdResourceService(service.getUlIdResourceService());
      }

      if (cres07so != null) {
        // populate old characteristic row into array
        rowcres08sig01_array = convertArrayOld(context, oldCharacteristicsArray);
      }
      // populate new characteristic row into array
      rowcres08sig00_array = convertArrayNew(context, oldCharacteristicsArray);

      cres08si.setROWCRES08SIG00_ARRAY(rowcres08sig00_array);
      cres08si.setROWCRES08SIG01_ARRAY(rowcres08sig01_array);
      cres08si.setUlRowQty(1);

      // SIR 17658 - check for duplicates with adds and updates, not just adds
      if (similarCharacteristicRowExists(context)) {
        setErrorMessage(Messages.MSG_RES_DUP_CHARACTERISTIC, request);
        setPresentationBranch("error", context);
        return;
      }

      resource.saveResourceCharacteristics(cres08si);
      state.removeAttribute(CRES07SO_ATTRIBUTE_NAME, request);
      state.removeAttribute(CRES05SO_ATTRIBUTE_NAME, request);

      GrndsTrace.exitScope();
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres08s: " + we.getMessage());

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CMN_UPDATE_FAILED:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling cres08s: " + e.getMessage());
      processSevereException(context, e);
    }
  }

  private ROWCRES08SIG01_ARRAY convertArrayOld(GrndsExchangeContext context, ROWCRES07SOG_ARRAY oldArray) {
    GrndsTrace.enterScope(TRACE_TAG + ".convertArrayOld");

    HttpServletRequest request = context.getRequest();

    ROWCRES08SIG01_ARRAY newArray = new ROWCRES08SIG01_ARRAY();
    ROWCRES07SOG oldCharacteristics = new ROWCRES07SOG();
    ROWCRES08SIG01 newCharacteristics = new ROWCRES08SIG01();
    if (StringHelper.isValid(request.getParameter(SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME))) {
      int selectedCharacteristicIndex = ContextHelper.getIntSafe(request, SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME);
      oldCharacteristics = oldArray.getROWCRES07SOG(selectedCharacteristicIndex);
      newCharacteristics.setSzCdRsrcCharChrctr(oldCharacteristics.getSzCdRsrcCharChrctr());
      newCharacteristics.setUNbrRsrcCharMaxFAge(oldCharacteristics.getUNbrRsrcCharMaxFAge());
      newCharacteristics.setUNbrRsrcCharMaxMAge(oldCharacteristics.getUNbrRsrcCharMaxMAge());
      newCharacteristics.setUNbrRsrcCharMinFAge(oldCharacteristics.getUNbrRsrcCharMinFAge());
      newCharacteristics.setUNbrRsrcCharMinMAge(oldCharacteristics.getUNbrRsrcCharMinMAge());
      newArray.addROWCRES08SIG01(newCharacteristics);
    } else {
      newArray.addROWCRES08SIG01(newCharacteristics);
    }

    GrndsTrace.exitScope();
    return newArray;
  }

  private ROWCRES08SIG00_ARRAY convertArrayNew(GrndsExchangeContext context, ROWCRES07SOG_ARRAY oldArray) {
    GrndsTrace.enterScope(TRACE_TAG + ".convertArrayNew");

    HttpServletRequest request = context.getRequest();

    ROWCRES08SIG00_ARRAY newArray = new ROWCRES08SIG00_ARRAY();

    int malMinMo = ContextHelper.getIntSafe(request, "malMinMo");
    int malMinYr = ContextHelper.getIntSafe(request, "malMinYr");
    int malMaxYr = ContextHelper.getIntSafe(request, "malMaxYr");
    int malMaxMo = ContextHelper.getIntSafe(request, "malMaxMo");

    int maleMaxAge = (malMaxYr * 12) + malMaxMo;
    int maleMinAge = (malMinYr * 12) + malMinMo;

    if (maleMaxAge == 0 && maleMinAge == 0) {
      GrndsTrace.msg(TRACE_TAG, 7, "Male ages are zero!");
    }

    int femMinYr = ContextHelper.getIntSafe(request, "femMinYr");
    int femMinMo = ContextHelper.getIntSafe(request, "femMinMo");
    int femMaxYr = ContextHelper.getIntSafe(request, "femMaxYr");
    int femMaxMo = ContextHelper.getIntSafe(request, "femMaxMo");

    int femaleMaxAge = (femMaxYr * 12) + femMaxMo;
    int femaleMinAge = (femMinYr * 12) + femMinMo;

    if (femaleMaxAge == 0 && femaleMinAge == 0) {
      GrndsTrace.msg(TRACE_TAG, 7, "Female ages are zero!");
    }

    String charSex = null;
    if ((femaleMaxAge > 0) && (maleMaxAge > 0)) {
      charSex = "B";
    } else if ((femaleMaxAge > 0) && (maleMaxAge <= 0)) {
      charSex = "F";
    } else if ((femaleMaxAge <= 0) && (maleMaxAge > 0)) {
      charSex = "M";
    }
    String SzCdScrDataAction = request.getParameter("SzCdScrDataAction");
    String characteristic = request.getParameter("clientCharacteristics");

    if (StringHelper.checkForEquality(SzCdScrDataAction, "A")) {
      ROWCRES08SIG00 newEntry = new ROWCRES08SIG00();
      newEntry.setUlIdResourceChrctr(0);
      newEntry.setTsLastUpdate(null);
      newEntry.setSzCdRsrcCharChrctr(characteristic);
      newEntry.setCCdRsrcCharSex(charSex);
      newEntry.setSzCdScrDataAction(SzCdScrDataAction);
      newEntry.setUNbrRsrcCharMaxFAge(femaleMaxAge);
      newEntry.setUNbrRsrcCharMaxMAge(maleMaxAge);
      newEntry.setUNbrRsrcCharMinFAge(femaleMinAge);
      newEntry.setUNbrRsrcCharMinMAge(maleMinAge);
      newArray.addROWCRES08SIG00(newEntry);
    } else if (StringHelper.checkForEquality(SzCdScrDataAction, "U")) {
      ROWCRES07SOG oldCharacteristics = new ROWCRES07SOG();
      if (StringHelper.isValid(request.getParameter(SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME))) {
        int selectedCharacteristicIndex = ContextHelper.getIntSafe(request,
                                                                   SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME);
        oldCharacteristics = oldArray.getROWCRES07SOG(selectedCharacteristicIndex);
      }
      ROWCRES08SIG00 updateEntry = new ROWCRES08SIG00();
      updateEntry.setUNbrRsrcCharMaxFAge(femaleMaxAge);
      updateEntry.setUNbrRsrcCharMaxMAge(maleMaxAge);
      updateEntry.setUNbrRsrcCharMinFAge(femaleMinAge);
      updateEntry.setUNbrRsrcCharMinMAge(maleMinAge);
      updateEntry.setSzCdRsrcCharChrctr(characteristic);
      updateEntry.setCCdRsrcCharSex(oldCharacteristics.getCCdRsrcCharSex());
      updateEntry.setSzCdScrDataAction(SzCdScrDataAction);
      updateEntry.setTsLastUpdate(oldCharacteristics.getTsLastUpdate());
      updateEntry.setUlIdResourceChrctr(oldCharacteristics.getUlIdResourceChrctr());
      newArray.addROWCRES08SIG00(updateEntry);
    }

    GrndsTrace.exitScope();
    return newArray;
  }

  private void clearStatePreserve(GrndsExchangeContext context) {
    String idResource = "";
    String nmResource = "";

    String nmRsrcContact = "";
    String cdRsrcType = "";
    String cdRsrcFacilType = "";
    String facilityNumber = "";

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CRES03SO cres03so = (CRES03SO) state.getAttribute(ResourceDetailConversation.CRES03SO_ATTRIBUTE_NAME, request);

    if (cres03so == null) {
      idResource = (String) state.getAttribute("ulIdResource", request);
      nmResource = GlobalData.getSzNmResource(request); // RIOSJA, SIR 22521
      nmRsrcContact = (String) state.getAttribute(FacilityConversation.RESOURCE_CONTACT_FIELD_NAME, request); // RIOSJA,
      // SIR
      // 22521
      cdRsrcType = (String) state.getAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, request);
      cdRsrcFacilType = (String) state.getAttribute("szCdRsrcFacilType", request);
      facilityNumber = (String) state.getAttribute(FacilityConversation.FACILITY_ID_FIELD_NAME, request); // RIOSJA, SIR
      // 22521
    } else {
      // Get the parameters passed from the Resource Detail page
      idResource = FormattingHelper.formatInt(cres03so.getUlIdResource());// SR-
      nmResource = cres03so.getSzNmResource();
      nmRsrcContact = cres03so.getSzNmRsrcContact();
      cdRsrcType = cres03so.getSzCdRsrcType();
      cdRsrcFacilType = cres03so.getSzCdRsrcFacilType();
      facilityNumber = FormattingHelper.formatInt(cres03so.getLNbrRsrcFacilAcclaim());
    }
    state.removeAllAttributes(request);

    state.setAttribute("ulIdResource", idResource, request);
    GlobalData.setSzNmResource(nmResource, request);
    state.setAttribute(FacilityConversation.RESOURCE_CONTACT_FIELD_NAME, nmRsrcContact, request); // RIOSJA, SIR 22521
    state.setAttribute("szCdRsrcType", cdRsrcType, request);
    state.setAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, cdRsrcType, request);
    state.setAttribute("szCdRsrcFacilType", cdRsrcFacilType, request);
    state.setAttribute(FacilityConversation.FACILITY_ID_FIELD_NAME, facilityNumber, request); // RIOSJA, SIR 22521
  }

  // STGAP00017019:ECEM 5.0: new save_xa method for Financial services as the current one is too crowded and with obsolete
  // logic
  /**
   * This method is called by the GRNDS controller when the user clicks the Save button on the Financial service
   * screen. It populates the input object for the Save service and calls the save service to save page data.
   * 
   * @param context: Context for the request
   *                
   */
  public void saveFinServiceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".saveFinServiceDetail_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    String szCdRsrcSvcRegion = request.getParameter("selSzCdRsrcSvcRegion");
    String[] serviceChecks = CheckboxHelper.getCheckedValues(request, "cbxService");
    String serviceDup = "";

    try {
      serviceDup = findSimilarContractedFinServiceRowExists(context, serviceChecks, szCdRsrcSvcRegion);
      if (! "".equals(serviceDup)){
        setPresentationBranch("error", context);
        String errMsg = "The row " + serviceDup + " could not be added. A similar service/region/county combination already exists.";
        // set error destination here so that custom validation still returns user to the correct page after repeated save fails
        //setErrorMessage(errMsg, DISPLAY_ADD_FINANCIAL_SERVICE_DETAIL_PAGE, request);
        setErrorMessage(Messages.MSG_RES_ROW_EXISTS, DISPLAY_ADD_FINANCIAL_SERVICE_DETAIL_PAGE, request);        
      } else {
        if (ALL_REGIONS.equals(szCdRsrcSvcRegion)) {  // all regions selected
          for (String cdService: serviceChecks) {
        	//STGAP00017735: Modified the loop to consider the size of REGION_MAP instead of NUMBER_OF_REGIONS 
            for (int regionNum = 1; regionNum <= REGION_MAP.size(); regionNum++) {
              //STGAP00017735: Modified to get the region code from REGION_INDEX map instead of using regionNum value
              String cdRegion = REGION_INDEX.get(regionNum);
              String sCbxGroup = "cbxCounty" + cdRegion;
              String[] countyChecks = CheckboxHelper.getCheckedValues(request, sCbxGroup);
              String szFinCountyCodeArray = "CCOUNT" + cdRegion;
              int numAllCounties = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
              int numCountiesSelected = (countyChecks != null) ? countyChecks.length : 0;
              
              if (numCountiesSelected == numAllCounties) { // region wide
                CRES06SI cres06si = populateFinServiceFromRequest(context, cdService, cdRegion, "");
                resource.saveAreaServed(cres06si);
              } else {
                for (String cdCounty: countyChecks) {
                  CRES06SI cres06si = populateFinServiceFromRequest(context, cdService, cdRegion, cdCounty);
                  resource.saveAreaServed(cres06si);
                }
              }
            }
          }
        }
        else {  // single region
          String[] countyChecks = CheckboxHelper.getCheckedValues(request, "cbxCounty" + szCdRsrcSvcRegion);
          String szFinCountyCodeArray = "CCOUNT" + szCdRsrcSvcRegion;
          int numAllCounties = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
          int numCountiesSelected = (countyChecks != null) ? countyChecks.length : 0;
          
          for (String cdService: serviceChecks) {
            if (numCountiesSelected == numAllCounties) { // region wide
              CRES06SI cres06si = populateFinServiceFromRequest(context, cdService, szCdRsrcSvcRegion, "");
              resource.saveAreaServed(cres06si);
            } else {
              for (String cdCounty: countyChecks) {
                CRES06SI cres06si = populateFinServiceFromRequest(context, cdService, szCdRsrcSvcRegion, cdCounty);
                resource.saveAreaServed(cres06si);
              }
            }
          }
        }
      }
      // Remove individual service row from state
      state.removeAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, context.getRequest());
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "ServiceException calling cres06s: " + we.getMessage());
      we.printStackTrace();

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CMN_UPDATE_FAILED:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, request);
        break;
     // Catch duplicate in service because duplicate validation in conv limited by the paginated list of existing data
     // This error message is customized with scenario details so need to use getErrorMessage to get scenario-specific text.
      case Messages.MSG_RES_ROW_EXISTS: 
        setPresentationBranch("error", context);
        setErrorMessage(we.getErrorMessage(), request);
        break;
      case Messages.MSG_CON_COUNTY_VIOLATION:
        //setPresentationBranch("error", context);
        //setErrorMessage(errorCode, request);
        setPopUpMessage(Messages.MSG_CON_COUNTY_VIOLATION, context.getRequest());
        break;
      default:
        processSevereException(context, we);
        break;
      }
    }catch (LookupException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling cres06s: " + e.getMessage());
      processSevereException(context, e);
    }
    
    GrndsTrace.exitScope();
  }
  // STGAP00017019:ECEM 5.0: new validation helper method for Financial services as the current one is too crowded and with obsolete
  // logic
  /**
   * This method is called by findSimilarContractedFinServiceRowExists to
   * validate on one single service/county/region combination whether it already exists in database.
   * @param rowcres05sog00_array
   * @param id
   * @param cdService
   * @param cdRegion
   * @param cdCounty
   * @param bRegionWide
   * @return
   */
  private String similarContractedFinServiceRowExists(ROWCRES05SOG00_ARRAY rowcres05sog00_array,
                                                       int id, String cdService, String cdRegion,
                                                       String cdCounty, boolean bRegionWide) {
    
    GrndsTrace.enterScope(TRACE_TAG + ".similarContractedFinServiceRowExists");

    String results = "";

    for (int i = 0; i < rowcres05sog00_array.getROWCRES05SOG00Count(); ++i) {
      int currId = rowcres05sog00_array.getROWCRES05SOG00(i).getUlIdResourceService();

      // Make sure we don't check the row against itself.
      if (id != currId) {
        boolean bContracted = (rowcres05sog00_array.getROWCRES05SOG00(i).getUlNbrCntrctNumber() > 0);
        
        String currService = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcService();
        boolean bSameService = StringHelper.checkForEquality(cdService, currService);
        
        String currRegion = rowcres05sog00_array.getROWCRES05SOG00(i).getSzCdRsrcSvcRegion();
        boolean bSameRegion = StringHelper.checkForEquality(cdRegion, currRegion);
        
        String currCounty = StringHelper.getNonNullString(rowcres05sog00_array.getROWCRES05SOG00(i).getSzScrRsrcSvcCntyCode());
        boolean bCurrRegionWide = StringHelper.checkForEquality(currCounty, StringHelper.EMPTY_STRING);

        boolean bSameCounty = StringHelper.checkForEquality(currCounty, cdCounty);
        /*
         *  Not implemented this validation because user confirmed that this is correct and also current behavior that user is warned that 
         *  attempting to add a
         *  region-wide row will delete any existing service row and client characteristic. User must then enter a new contract version
         *  for the new services. Any deleted service still payable because the row in contract county does not get deleted.
         *  Added note to the original method that has this validation, even thought it is currently not working due to using rowQty.
         */
        
        // Region-wide (all counties) selected for the service whereas this service is currently contracted for at least one county in the same region
        /*if (bRegionWide && bSameRegion && bSameService && bContracted) {
          results = cdService; // add more when we know about active contract
          break;
        }*/
        // The combination service and region already exists. A region-wide row exists. Return the error combination to the caller
        if (bSameService && bSameRegion && bCurrRegionWide) {
          results = "service " + cdService + ", region " + cdRegion; 
          break;
        }
        // The combination service and county already exists. Return the error combination to the caller
        /*if (bSameService && bSameCounty && !bRegionWide) {
          String countyName = Lookup.simpleDecodeSafe("CCOUNT", cdCounty);
          results = "service " + cdService + ", region " + cdRegion + ", county " + countyName; 
          break;
        }*/
      }
    }

    GrndsTrace.exitScope();
    return results;
  }
  // STGAP00017019:ECEM 5.0: new validation helper method for Financial services as the current one is too crowded and with obsolete
  // logic  
  /**
   * Validation method called by saveFinServiceDetail_xa(GrndsExchangeContext)
   * to find whether the combination user is trying to add already exists in the database. 
   * This method loops through all financial service combination and validate
   * @param context
   * @param serviceChecks
   * @param szCdRsrcSvcRegion
   * @return
   * @throws LookupException
   */
  private String findSimilarContractedFinServiceRowExists(GrndsExchangeContext context, 
                                                      String[] serviceChecks, String szCdRsrcSvcRegion)  
                                                      throws LookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".findSimilarContractedFinServiceRowExists");
 
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String serviceDup = "";

    // Ignore checking for dupes in update mode.
    // we are always in add mode. Redundant?
    if (StringHelper.checkForEquality(request.getParameter("SzCdScrDataAction"), "U")) {
      GrndsTrace.exitScope();
      return serviceDup;
    }

    CRES05SO cres05so = (CRES05SO) state.getAttribute(CRES05SO_ATTRIBUTE_NAME, request);

    if (cres05so != null) {
      ROWCRES05SOG00_ARRAY rowcres05sog00_array = cres05so.getROWCRES05SOG00_ARRAY();

      // id is always 0 in add mode; passing in is redundant?
      int id = ContextHelper.getIntSafe(request, "txtUlIdResourceService");

      // TODO combine scenarios
      if (ALL_REGIONS.equals(szCdRsrcSvcRegion)) {  // all regions selected
        allRegionsLoop:
        for (String cdService: serviceChecks) {
          //STGAP00017735: Modified the loop to consider the size of REGION_MAP instead of NUMBER_OF_REGIONS
          for (int regionNum = 1; regionNum <= REGION_MAP.size(); regionNum++) {
        	//STGAP00017735: Modified to get the region code from REGION_INDEX map instead of using regionNum value
            String cdRegion = REGION_INDEX.get(regionNum);
            String sCbxGroup = "cbxCounty" + cdRegion;
            String[] countyChecks = CheckboxHelper.getCheckedValues(request, sCbxGroup);
            String szFinCountyCodeArray = "CCOUNT" + cdRegion;
            int numAllCounties = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
            int numCountiesSelected = (countyChecks != null) ? countyChecks.length : 0;
            boolean bRegionWide = false;
            
            if (numCountiesSelected == numAllCounties) // region wide from request
              bRegionWide = true;
            
            for (String cdCounty: countyChecks) {
              serviceDup = similarContractedFinServiceRowExists(rowcres05sog00_array, id, cdService, cdRegion, cdCounty, bRegionWide);
              if (! "".equals(serviceDup)) {
                break allRegionsLoop;
              }
            }
          }
        }
      } 
      else {  // single region
        String[] countyChecks = CheckboxHelper.getCheckedValues(request, "cbxCounty" + szCdRsrcSvcRegion);
        String szFinCountyCodeArray = "CCOUNT" + szCdRsrcSvcRegion;
        int numAllCounties = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
        int numCountiesSelected = (countyChecks != null) ? countyChecks.length : 0;
        boolean bRegionWide = false;
        
        if (numCountiesSelected == numAllCounties) // region wide from request
          bRegionWide = true;
        
        singleRegionLoop:
        for (String cdService: serviceChecks) {
           for (String cdCounty: countyChecks) {
             serviceDup = similarContractedFinServiceRowExists(rowcres05sog00_array, id, cdService, szCdRsrcSvcRegion, cdCounty, bRegionWide);
             if (! "".equals(serviceDup)) {              
               break singleRegionLoop;
             }
           }
        }
      }
    }

    GrndsTrace.exitScope();
    return serviceDup;
  }

  

 /**
   * This is helper method to populate the input object for saving Financial services by area
   * @param context
   * @param cdService
   * @param cdRegion
   * @param cdCounty
   * @return CRES06SI
   */
  private CRES06SI populateFinServiceFromRequest(GrndsExchangeContext context, String cdService, String cdRegion, String cdCounty) {
    GrndsTrace.enterScope(TRACE_TAG + ".populateFinServiceFromRequest");

    HttpServletRequest request = context.getRequest();
    CRES06SI cres06si = new CRES06SI();
    ROWCRES06SIG row = new ROWCRES06SIG();
    ROWCRES06SIG_ARRAY rowArray = new ROWCRES06SIG_ARRAY();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCRES05SOG00 rowcres05sog00 = (ROWCRES05SOG00) state.getAttribute(CRES05SOG00_ROW_ATTRIBUTE_NAME, request);
    if (rowcres05sog00 == null) {
      rowcres05sog00 = new ROWCRES05SOG00();
    }

    row.setBIndRsrcSvcCntyPartial(ArchitectureConstants.N);

    if (StringHelper.isTrue(request.getParameter("cbxCIndRsrcSvcIncomeBsed"))) {
      row.setCIndRsrcSvcIncomeBsed(ArchitectureConstants.Y);
    } else {
      row.setCIndRsrcSvcIncomeBsed(ArchitectureConstants.N);
    }

    row.setSzCdRsrcSvcCategRsrc(request.getParameter("selSzCdRsrcSvcCategRsrc"));
    row.setSzCdRsrcSvcProgram(request.getParameter("selSzCdRsrcSvcProgram"));
    row.setSzCdRsrcSvcRegion(cdRegion);
    row.setSzCdRsrcSvcService(cdService);
    row.setSzCdRsrcSvcServiceType(request.getParameter("rbServiceType"));
    row.setSzCdRsrcSvcState(request.getParameter("selSzCdRsrcSvcState"));
    row.setSzScrRsrcSvcCntyCode(cdCounty);
    row.setCIndRsrcSvcShowRow(ArchitectureConstants.Y);
    row.setTsLastUpdate(rowcres05sog00.getTsLastUpdate());
    row.setUlIdResource(GlobalData.getUlIdResource(request));
    row.setUlIdResourceService(ContextHelper.getIntSafe(request, "txtUlIdResourceService"));
    row.setSzCdScrDataAction(request.getParameter("SzCdScrDataAction"));

    rowArray.addROWCRES06SIG(row);

    cres06si.setROWCRES06SIG_ARRAY(rowArray);
    cres06si.setUlRowQty(1);

    GrndsTrace.exitScope();
    return cres06si;
  }
}
