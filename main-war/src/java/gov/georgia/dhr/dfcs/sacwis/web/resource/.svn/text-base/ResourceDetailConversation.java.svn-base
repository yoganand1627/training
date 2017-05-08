/*
 Change History:
 Date       User        Description
 ---------  ----------- --------------------------------------------------------
 6/29/2005   piazzat     refactored for MPS
 10/27/2006  aodutayo    Added dependency that initiates call to service object. 
 09/12/2011  charden     STGAP00017058 - adding code to make address detail page editable for fiscal ops users
      
 */

package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES04SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used by ResourceDetail, PhoneDetail, AddressDetail, and SubcontractorDetail pages for
 * their update, delete, add, etc. functions.
 * 
 * @author Sanjay Rana, July 23, 2002
 */
public class ResourceDetailConversation extends BaseHiddenFieldStateConversation {

  public static final String CRES03SO_ATTRIBUTE_NAME = "CRES03S";

  protected static final String TRACE_TAG = "ResourceDetailConversation";

  public static final String RESOURCE_ID_FIELD_NAME = "txtUlIdResource";
  
  public static final String FISC_OPS_MAINT = "FISC_OPS_MAINT";
  
  private static final String GENERAL_FAILURE_STRING = "General Failure:";
  
  private static final String ERROR_STRING = "ServletException:";

  private Resource resource;
  
  private Common common;

  public void setResource(Resource resource) {
    this.resource = resource;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }

  /**
   * This method is called by the GRNDS controller when the user requests the detail of a resource
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void displayResourceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".DisplayResourceDetail_xa");
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "DisplayResourceDetail_xa");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // SPB 6/18/2003 - Setting resourceID into GD
    String idString;
    int ulIdResource = ContextHelper.getIntSafe(context, RESOURCE_ID_FIELD_NAME);
    if (ulIdResource != 0) // Get parameter if coming from Results page
    {
      idString = request.getParameter(RESOURCE_ID_FIELD_NAME);
      GlobalData.setUlIdResource(ulIdResource, request);
    } else {
      idString = GlobalData.getUlIdResourceAsString(request);
    }

    // SIR 18430 - Grabbed idString from State to Add's would work.
    if (idString == null || idString.equals(StringHelper.EMPTY_STRING)) {
      idString = (String) state.getAttribute("idString", request);
    }

    // clear state
    state.removeAllAttributes(request);

    // Get the Resource Detail and store it to request and state
    CRES03SO cres03so = this.findResource(context, idString);
    
    cres03so.setBIndORSAssociateToShines(geORSAssociateToSHINESSecAtt(request));

    // storeValueBeanToRequest( context, cres03so, "CRES03S" );
    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
    String pageMode = getPageMode(request, cres03so);
    GlobalData.setAppMode(pageMode, request);

    // Store resource type to state for use by Metaphor (used to determine if Facility Detail and/or Services By Area
    // tabs should be displayed)

    state.setAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, cres03so.getSzCdRsrcType(), request);

    CRES04SI cres04si;
    cres04si = setResourceDetailDatabaseValues(request, cres03so);
    state.setAttribute("CRES04SI_ResourceDetail", cres04si, request);

    state.setAttribute("szNmRsrcContact", cres03so.getSzNmRsrcContact(), request);// FacilityDetail, ResourceDetail,
    // ResCOnv
    state.setAttribute("szCdRsrcFacilType", cres03so.getSzCdRsrcFacilType(), request);// FacilityDetail, ResourceDetail,
    // ResCOnv
    state.setAttribute("lNbrRsrcFacilAcclaim", FormattingHelper.formatInt(cres03so.getLNbrRsrcFacilAcclaim()), request);

    GlobalData.setSzNmResource(cres03so.getSzNmResource(), request);

    // Set the page mode into State
    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    // Set the resource type onto the request so it can be used by the metaphor to display the tabs correctly
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests the detail of a resource
   * 
   * @param request
   *          The http request
   * @param resDetail
   *          Output struct
   */
  protected String getPageMode(HttpServletRequest request, CRES03SO resDetail) {
    String pageMode = PageModeConstants.VIEW;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    boolean userHasResourceMaintanPrivelege = false;
    boolean userHasRightToMaintainRegion = false;
    if (userProfile != null) {
      // Check if user has Maintain Resource rights.
      userHasResourceMaintanPrivelege = userProfile.hasRight(UserProfile.SEC_MNTN_RSRC);
      // Check if the user is allowed to maintain the region for this resource.
      if (resDetail != null) {
        userHasRightToMaintainRegion = userProfile.hasAccessToRegion(resDetail.getSzCdRsrcMaintainer());
        if (userHasResourceMaintanPrivelege && userHasRightToMaintainRegion) {
          pageMode = PageModeConstants.EDIT;
        }
      }
    }
    // Set page mode to VIEW if facility type of 70 or 71
    String facilityType = resDetail.getSzCdRsrcFacilType();
    if (resDetail != null && facilityType != null && ("70".equals(facilityType) || "71".equals(facilityType))) {
      pageMode = PageModeConstants.VIEW;
    }
    GrndsTrace.msg(TRACE_TAG, 7, "getPageMode() - The page mode is: " + pageMode);
    return pageMode;
  }

  /**
   * This method calls a Tuxedo service to retrieve resource details for pull back functionality.
   * 
   * @param context
   *          The http request
   */
  public void pullBackResourceDetail_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".pullBackResourceDetail_xa");
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "pullBackResourceDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    // Get parameter if coming from Results page
    String idString = request.getParameter("txtUlIdResource");
    String destinationUrl = request.getParameter("destinationUrl");// SR - 02/19/03

    try {
      // Get the Resource Detail and store it to request and state
      CRES03SO cres03so = this.findResource(context, idString);
      request.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, cres03so);
      forward(destinationUrl, request, context.getResponse());
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

  /**
   * This helper method populates CRES04SI input struct from paramters on the request
   * 
   * @param request
   *          The http request
   * @param cres04si
   *          The input struct containing resuorce details
   */
  protected CRES04SI setResourceDetailParameterValues(HttpServletRequest request, CRES04SI cres04si) {
    String idString2 = request.getParameter("txtLNbrRsrcFacilAcclaim");
    String idString = request.getParameter("txtUlIdResource");
    String txtLstUpdate = request.getParameter("txtLastUpdate");
    try {
      if (txtLstUpdate != null && !"".equals(txtLstUpdate)) {
        java.util.Date txtDate = (java.util.Date) SerializationHelper.deserializeObject(txtLstUpdate);
        cres04si.setTsLastUpdate(txtDate);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Date serializatin Failure:" + e.getMessage());
    }
    if (idString != null && !"".equals(idString)) {
      cres04si.setUlIdResource(Integer.parseInt(idString));
    }
    if (idString2 != null && !"".equals(idString2)) {
      cres04si.setLNbrRsrcFacilAcclaim(Integer.parseInt(idString2));
    }
    cres04si.setSzNmResource(FormattingHelper.changeCase(request.getParameter("txtNmResource")));
    cres04si.setSzCdMhmrCompCode(request.getParameter("selCdMhmrCompCode"));
    cres04si.setSzCdRsrcFacilType(request.getParameter("selCdRsrcFacilType"));
    cres04si.setSzCdRsrcMaintainer(request.getParameter("selCdRsrcMaintainer"));
    cres04si.setSzCdRsrcOwnership(request.getParameter("selCdRsrcOwnership"));
    cres04si.setSzCdRsrcStatus(request.getParameter("selCdRsrcStatus"));
    cres04si.setSzCdRsrcType(request.getParameter("selCdRsrcType"));

    cres04si.setSzNmRsrcContact(request.getParameter("txtNmRsrcContact"));
    cres04si.setSzNmLegal(FormattingHelper.changeCase(request.getParameter("txtNmLegal")));// SIR 22639- 03/25/04

    GrndsTrace.msg(TRACE_TAG, 10, "cbxCIndRsrcTransport: \n" + request.getParameter("cbxCIndRsrcTransport"));
    cres04si.setCIndRsrcTransport(request.getParameter("cbxCIndRsrcTransport"));

    // need to add this when you actually logon as a user
    UserProfile userProfile1 = UserProfileHelper.getUserProfile(request);
    cres04si.setSzNmRsrcLastUpdate(userProfile1.getUserFullName());
    cres04si.setSzTxtRsrcComments(request.getParameter("txtTxtRsrcComments"));

    cres04si.setSzNmRsrcContactTitle(request.getParameter("txtNmRsrcContactTitle"));
    cres04si.setSzNbrRsrcNtnlProvider(request.getParameter("txtNationalProviderNumber"));
    cres04si.setSzAddrRsrcEmail(request.getParameter("txtEmailAddress"));
    cres04si.setSzAddrRsrcWebsite(request.getParameter("txtWebAddress"));
    cres04si.setSzCdSchoolType(request.getParameter("selCdSchoolType"));
    cres04si.setSzCdSchoolDistrict(request.getParameter("selCdSchoolDist"));
    cres04si.setSzCdPaymentDelivery(request.getParameter("selPaymentDelivery"));

    return cres04si;
  }

  /**
   * This helper method populates CRES04SI input struct from CRES03SO output struct
   * 
   * @param request
   *          The http request
   * @param cres03so
   *          The output struct containing resuorce details
   */
  protected CRES04SI setResourceDetailDatabaseValues(HttpServletRequest request, CRES03SO cres03so) {
    CRES04SI cres04si = new CRES04SI();
    cres04si.setTsLastUpdate(cres03so.getTsLastUpdate());
    cres04si.setUlIdResource(cres03so.getUlIdResource());
    cres04si.setLNbrRsrcFacilAcclaim(cres03so.getLNbrRsrcFacilAcclaim());
    cres04si.setSzNmResource(cres03so.getSzNmResource());
    cres04si.setSzCdMhmrCompCode(cres03so.getSzCdMhmrCompCode());
    cres04si.setSzCdRsrcFacilType(cres03so.getSzCdRsrcFacilType());
    cres04si.setSzCdRsrcMaintainer(cres03so.getSzCdRsrcMaintainer());
    cres04si.setSzCdRsrcOwnership(cres03so.getSzCdRsrcOwnership());
    cres04si.setSzCdRsrcStatus(cres03so.getSzCdRsrcStatus());
    cres04si.setSzCdRsrcType(cres03so.getSzCdRsrcType());
    cres04si.setSzNmRsrcContact(cres03so.getSzNmRsrcContact());
    cres04si.setCIndRsrcTransport(cres03so.getCIndRsrcTransport());
    cres04si.setSzTxtRsrcComments(cres03so.getSzTxtRsrcComments());
    cres04si.setSzCdRsrcCampusType(cres03so.getSzCdRsrcCampusType());
    cres04si.setSzNmLegal(cres03so.getSzNmLegal());// SIR 22639- 03/25/04
    // need to add this when you actually logon as a user
    UserProfile userProfile1 = UserProfileHelper.getUserProfile(request);// SR - 02/14/03
    cres04si.setSzNmRsrcLastUpdate(userProfile1.getUserFullName());// SR - 02/14/03
    cres04si.setSzNmRsrcContactTitle(cres03so.getSzNmRsrcContactTitle());
    cres04si.setSzNbrRsrcNtnlProvider(cres03so.getSzNbrRsrcNtnlProvider());
    cres04si.setSzAddrRsrcEmail(cres03so.getSzAddrRsrcEmail());
    cres04si.setSzAddrRsrcWebsite(cres03so.getSzAddrRsrcWebsite());
    cres04si.setSzCdSchoolType(cres03so.getSzCdSchoolType());
    cres04si.setSzCdSchoolDistrict(cres03so.getSzCdSchoolDistrict());
    cres04si.setSzCdPaymentDelivery(cres03so.getSzCdPaymentDelivery());

    return cres04si;
  }

  protected CRES03SO findResource(GrndsExchangeContext context, String id) {
    CRES03SO cres03so = null;
    GrndsTrace.enterScope(TRACE_TAG + ".findResource");
    try {
      CRES03SI cres03si = new CRES03SI();
      int resourceId = 0;
      if (StringHelper.isValid(id)) {
        resourceId = Integer.parseInt(id);
      }
      cres03si.setUlIdResource(resourceId);
      cres03so = resource.retrieveResourceDetail(cres03si);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }

    catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, " Failure:" + ve.getMessage());
      processSevereException(context, ve);
    }
    return cres03so;
  }

  /**
   * This method is called by the GRNDS controller when the user saves the address
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void saveAddressDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "saveAddressDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".saveAddressDetail_xa");
    HttpServletRequest request = context.getRequest();
    GrndsTrace.msg(TRACE_TAG, 10, "IdRsrcAddress is= \n" + request.getParameter("iUlIdRsrcAddress"));
    int idResourceAddress = 0;
    if (StringHelper.isValid(request.getParameter("iUlIdRsrcAddress"))) {
      idResourceAddress = Integer.parseInt(request.getParameter("iUlIdRsrcAddress"));
    }

    String sIdResource = GlobalData.getUlIdResourceAsString(request);

    int idResource = 0;
    if (StringHelper.isValid(sIdResource)) {
      idResource = Integer.parseInt(sIdResource);
    }
    String szCReqFuncCd = request.getParameter("cReqFuncCd");
    BaseSessionStateManager state = getSessionStateManager(context);

    CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);

    ROWCRES03SOG00_ARRAY rowcres03sog00_array = cres03so.getROWCRES03SOG00_ARRAY();
    ROWCRES03SOG00 rowcres03sog00;

    // -- Retrieve values via the AddressBean in the request
    String addressSubmoduleName = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME);
    AddressBean addressBean = AddressBean.getFromRequest(addressSubmoduleName, request);
    if (addressBean == null) {
      // -- This should never happen since the resource/AddressDetail.jsp page always uses standardized
      // -- AddressBean request parameter names, allowing the AddressBean to be initialized and populated
      // -- via the getFromRequest static method.
      addressBean = new AddressBean(addressSubmoduleName);
    }

    String street1 = addressBean.getAddress1() != null ? addressBean.getAddress1() : "";
    String street2 = addressBean.getAddress2() != null ? addressBean.getAddress2() : "";
    String city = addressBean.getCity() != null ? addressBean.getCity() : "";
    String addrState = addressBean.getState() != null ? addressBean.getState() : "";
    String zip = addressBean.getZipAndSuff() != null ? addressBean.getZipAndSuff() : "";

    String vid = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVid");
    String addressType = ContextHelper.getStringSafe(request, "selCdRsrcAddrType");
    
    boolean duplicateAddressData = false;
    boolean duplicateVid = false;
    String errorMsg = null;

    for (int i = 0; i < rowcres03sog00_array.getUlRowQty(); i++) {
      rowcres03sog00 = rowcres03sog00_array.getROWCRES03SOG00(i);
      // Check to see if address entered is duplicate
      if ((idResourceAddress != rowcres03sog00.getUlIdRsrcAddress())
          && (addressType.equals(rowcres03sog00.getSzCdRsrcAddrType()))
          && (street1.equals(rowcres03sog00.getSzAddrRsrcAddrStLn1()))
          && (street2.equals(rowcres03sog00.getSzAddrRsrcAddrStLn2()))
          && (city.equals(rowcres03sog00.getSzAddrRsrcAddrCity()))
          && (addrState.equals(rowcres03sog00.getSzCdFacilityState()))
          && (zip.equals(rowcres03sog00.getSzAddrRsrcAddrZip()))) {
        duplicateAddressData = true;
        errorMsg = MessageLookup.getMessageByName("MSG_NO_DUP_LB_ROW");
      }
      // check to see that vendor id is not already used
      else if ((idResourceAddress != rowcres03sog00.getUlIdRsrcAddress()) && vid != null && !"".equals(vid)
               && vid.equals(rowcres03sog00.getSzNbrRsrcAddrVid())) {
        duplicateVid = true;
        errorMsg = MessageLookup.getMessageByName("MSG_RES_UNIQUE_VID");
      }
    }
    if (duplicateAddressData || duplicateVid) {
      // Set error message and presentation branch
      this.setPresentationBranch("duplicateRecord", context);
      setErrorMessage(errorMsg, "/resource/ResourceDetail/DisplayAddressDetail", request);
    } else {
      this.saveAddressDetail(context, idResource, idResourceAddress, szCReqFuncCd, addressBean);
      CRES03SO resourceDetail = this.findResource(context, sIdResource);

      state.setAttribute(CRES03SO_ATTRIBUTE_NAME, resourceDetail, request);
      CRES04SI cres04si = setResourceDetailDatabaseValues(request, resourceDetail);
      state.setAttribute("CRES04SI_ResourceDetail", cres04si, request);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }

  /**
   * This method calls a Tuxedo service to save Detail of an address
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   * @param idResource
   *          The resource Id
   * @param txtUlIdRsrcAddress
   *          The address Id
   * @param cReqFuncCd
   *          The mode (A/U/D) of the service request
   */
  protected CRES04SO saveAddressDetail(GrndsExchangeContext context, int idResource, int txtUlIdRsrcAddress,
                                       String cReqFuncCd, AddressBean addressBean) {
    CRES04SO cres04so = null;
    CRES04SI cres04si = new CRES04SI();
    GrndsTrace.enterScope(TRACE_TAG + ".saveAddressDetail");
    HttpServletRequest request = context.getRequest();

    try {

      BaseSessionStateManager state = getSessionStateManager(context);
      if (state.getAttribute("CRES04SI_ResourceDetail", request) != null) {
        cres04si = (CRES04SI) state.getAttribute("CRES04SI_ResourceDetail", request);
      }
      GrndsTrace.msg(TRACE_TAG, 10, "timelastupdate: \n" + cres04si.getTsLastUpdate());

      UserProfile user = UserProfileHelper.getUserProfile(context);

      ArchInputStruct archinputstruct = new ArchInputStruct();
      archinputstruct.setSzUserId(String.valueOf(user.getUserID()));
      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cres04si.setArchInputStruct(archinputstruct);

      ROWCRES04SIG00_ARRAY rowCres04sig00_array = new ROWCRES04SIG00_ARRAY();
      ROWCRES04SIG00 rowcres04sig00 = new ROWCRES04SIG00();
      rowcres04sig00.setSzNbrRsrcAddrVid(request.getParameter("txtNbrRsrcAddrVid"));
      rowcres04sig00.setSzAddrRsrcAddrAttn(request.getParameter("txtSzAddrRsrcAddrAttn"));
      rowcres04sig00.setSzAddrRsrcAddrStLn1(addressBean.getAddress1() != null ? addressBean.getAddress1() : "");
      rowcres04sig00.setSzAddrRsrcAddrStLn2(addressBean.getAddress2() != null ? addressBean.getAddress2() : "");
      rowcres04sig00.setSzAddrRsrcAddrCity(addressBean.getCity() != null ? addressBean.getCity() : "");
      rowcres04sig00.setSzAddrRsrcAddrCounty(addressBean.getCounty() != null ? addressBean.getCounty() : "");
      rowcres04sig00.setSzCdFacilityState(addressBean.getState() != null ? addressBean.getState() : "");
      rowcres04sig00.setSzAddrRsrcAddrZip(addressBean.getZipAndSuff() != null ? addressBean.getZipAndSuff() : "");
      rowcres04sig00.setSzCdRsrcAddrSchDist(request.getParameter("selCdRsrcAddrSchDist"));
      rowcres04sig00.setSzCdRsrcAddrType(request.getParameter("selCdRsrcAddrType"));
      rowcres04sig00.setNbrRsrcAddrLat(ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLat"));
      rowcres04sig00.setNbrRsrcAddrLong(ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLong"));
      String txtLstUpdate = request.getParameter("txtTsLastUpdate");
      
      GrndsTrace.msg(TRACE_TAG, 10, "timelastupdate_addressRow_befor_serial: \n" + txtLstUpdate);
      try {
        java.util.Date txtDate = (java.util.Date) SerializationHelper.deserializeObject(txtLstUpdate);
        rowcres04sig00.setTsLastUpdate(txtDate);
        GrndsTrace.msg(TRACE_TAG, 10, "timelastupdate_addressRow: \n" + rowcres04sig00.getTsLastUpdate());
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Date serialization Failure: " + e.getMessage());
        processSevereException(context, e);
      }
      rowcres04sig00.setUlIdResource(idResource);
      rowcres04sig00.setSzTxtRsrcAddrComments(request.getParameter("txtszTxtRsrcAddrComments"));
      rowcres04sig00.setUlIdRsrcAddress(txtUlIdRsrcAddress);
      rowcres04sig00.setSzCdScrDataAction(cReqFuncCd);
      rowCres04sig00_array.setUlRowQty(1);
      rowCres04sig00_array.addROWCRES04SIG00(rowcres04sig00);
      UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY = new UlPageSizeNbr_ARRAY();
      ulPageSizeNbr_ARRAY.addUlPageSizeNbr(0, 1);
      cres04si.setUlPageSizeNbr_ARRAY(ulPageSizeNbr_ARRAY);
      GrndsTrace.msg(TRACE_TAG, 10, "getUlPageSizeNbr_ARRAY is = \n" + cres04si.getUlPageSizeNbr_ARRAY());
      cres04si.setROWCRES04SIG00_ARRAY(rowCres04sig00_array);
      
      // CODE added by srinivas to check if any of the required address information is changed or not?
      
      String hdnAdd1Name ="", hdnAdd2Name = "", hdnZipName = "", hdnZipSuffName = "", hdnCityName ="", hdnStateName ="", hdnCntyName = "";
      
      String street1 ="", street2 = "", city = "", zip = "", zipStuff = "", county = "", stat = "";
      
      hdnAdd1Name = request.getParameter("hdnAdd1Name") != null ? (String) request.getParameter("hdnAdd1Name"): "" ;
      hdnAdd2Name = request.getParameter("hdnAdd2Name") != null ? (String) request.getParameter("hdnAdd2Name") : "";
      hdnZipName = request.getParameter("hdnZipName") != null ? (String) request.getParameter("hdnZipName") : "";
      hdnZipSuffName = request.getParameter("hdnZipSuffName") != null ? (String) request.getParameter("hdnZipSuffName") : "";
      hdnCityName = request.getParameter("hdnCityName") != null ? (String) request.getParameter("hdnCityName") : "";
      hdnStateName = request.getParameter("hdnStateName") != null ? (String)request.getParameter("hdnStateName") : "";
      hdnCntyName = request.getParameter("hdnCntyName") != null ? (String)request.getParameter("hdnCntyName") : "";      
      
      street1 = addressBean.getAddress1() != null ? addressBean.getAddress1(): "";
      street2 = addressBean.getAddress2() != null ? addressBean.getAddress2() : "";
      city = addressBean.getCity() != null ? addressBean.getCity() : "";
      zip = addressBean.getZip() != null ? addressBean.getZip() : "";
      zipStuff = addressBean.getZipSuff() != null ? addressBean.getZipSuff() : "";
      county = addressBean.getCounty() != null ? addressBean.getCounty() : "";     
      stat = addressBean.getState() != null ? addressBean.getState() : "";
      boolean vidChanged = request.getParameter("vidChanged") != null ? true : false;
      
      // STGAP00017058 - set indicator so that new vendor id can be saved in service
      if(vidChanged){
        cres04si.setBIndReview(ArchitectureConstants.Y);
      }else{
        cres04si.setBIndReview(ArchitectureConstants.N);
      }
      
      if( (!hdnAdd1Name.equalsIgnoreCase(street1)) || (!hdnAdd2Name.equalsIgnoreCase(street2)) || (!hdnCityName.equalsIgnoreCase(city)) ||
          (!hdnStateName.equalsIgnoreCase(stat)) || (!hdnZipName.equalsIgnoreCase(zip)) ||(!zipStuff.equalsIgnoreCase(zipStuff)) ||
          (!hdnCntyName.equalsIgnoreCase(county))
      ){        
        cres04si.setIndAddrChanged(true);
      }  
      
      cres04so = resource.saveResourceDetail(cres04si);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(errorCode, "/resource/ResourceSearch/results", request);
        break;
      case Messages.MSG_CMN_UPDATE_FAILED:
        this.setPresentationBranch("duplicateRecord", context);
        // MSG - A duplicate row cannot be added to the list box."
        setErrorMessage(Messages.MSG_NO_DUP_LB_ROW, "/resource/ResourceSearch/results", request);
        break;
      case Messages.MSG_VID_REQ:
        // MSG - Resource Details cannot be updated until VendorID is assigned by SMILE
        setErrorMessage(Messages.MSG_VID_REQ, request);
        break;
      case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    GrndsTrace.exitScope(cres04so);
    return cres04so;
  }

  /**
   * This method is called by the GRNDS controller when the user saves the detail of a resource
   * 
   * @param con
   *          The context of this page including the http request and other GRNDS information
   */
  public void saveResourceDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "saveResourceDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".saveResourceDetail_xa");
    GrndsTrace.msg(TRACE_TAG, 10, "inside saveResourceDetail_xa");
    this.saveResourceDetail(context);

    HttpServletRequest request = context.getRequest();

    String idString = request.getParameter("txtUlIdResource");
    CRES03SO cres03so = this.findResource(context, idString);

    BaseSessionStateManager state = getSessionStateManager(context);

    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);

    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
    GlobalData.setAppMode(this.getPageMode(request, cres03so), request);

    // Store resource type to state for use by Metaphor (used to determine if Facility Detail and/or Services By Area
    // tabs should be displayed)

    state.setAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, cres03so.getSzCdRsrcType(), request);

    // Set Attributes into State for use on ResourceDetail, FacilityDetail & ServiceByArea JSPs
    state.setAttribute("szNmRsrcContact", cres03so.getSzNmRsrcContact(), request);// FacilityDetail, ResourceDetail,
    // ResCOnv
    state.setAttribute("szCdRsrcFacilType", cres03so.getSzCdRsrcFacilType(), request);// FacilityDetail, ResourceDetail,
    // ResCOnv
    state.setAttribute("lNbrRsrcFacilAcclaim", FormattingHelper.formatInt(cres03so.getLNbrRsrcFacilAcclaim()), request);
    GlobalData.setSzNmResource(cres03so.getSzNmResource(), request);

    // Populate CRES04SI in state with clean Resource Detail data from the database
    CRES04SI cres04si = setResourceDetailDatabaseValues(request, cres03so);
    state.setAttribute("CRES04SI_ResourceDetail", cres04si, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  protected CRES04SO saveResourceDetail(GrndsExchangeContext context) {
    CRES04SO cres04so = null;
    GrndsTrace.enterScope(TRACE_TAG + ".saveResourceDetail");
    HttpServletRequest request = context.getRequest();

    try {
      CRES04SI cres04si = new CRES04SI();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      ArchInputStruct archinputstruct = new ArchInputStruct();
      archinputstruct.setSzUserId(String.valueOf(user.getUserID()));
      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cres04si.setArchInputStruct(archinputstruct);
      
      // Code added by Srinivas to test which contact details are changed
      
      String hdnRsrcName = "";
      String hdnCntName = "";
      String rsrcName = "";
      String cnctName = "";
      
      hdnRsrcName = (String) request.getParameter("resName");
      hdnCntName = (String) request.getParameter("contactName");      
      rsrcName = (String) request.getParameter("txtNmLegal");
      cnctName = (String) request.getParameter("txtNmRsrcContact");
      
      if(! hdnRsrcName .equalsIgnoreCase(rsrcName)){        
        cres04si.setIndRsrcChanged(true);
      }
      if(! hdnCntName .equalsIgnoreCase(cnctName)){
        cres04si.setIndRsrcChanged(true);
      }     
      
      cres04si = setResourceDetailParameterValues(request, cres04si);
      cres04so = resource.saveResourceDetail(cres04si);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      
      case Messages.MSG_VID_REQ:
        // MSG - Resource Details cannot be updated until VendorID is assigned by SMILE
        setErrorMessage(Messages.MSG_VID_REQ, request);
        break;
      case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH),
                        "/resource/ResourceSearch/results", request);
        break;
      case Messages.MSG_RSRC_CONTRACTED_NO_VID:
        this.setPresentationBranch("error", context);
        // MSG - Save failed: Cannot remove VID from address record with an active contract.
        setErrorMessage(MessageLookup.getMessageByName("MSG_RSRC_CONTRACTED_NO_VID"),
                        "/resource/ResourceSearch/results", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    GrndsTrace.exitScope(cres04so);
    return cres04so;
  }

  /**
   * This method is called by the GRNDS controller when the user clicks to open the Add Resource page
   * 
   * @param context
   */
  public void newResource_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".newResource_xa");
    GrndsTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user deletes the phone
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void deletePhoneDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "deletePhoneDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".deletePhoneDetail_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String sIdResource = GlobalData.getUlIdResourceAsString(request);

    String szCReqFuncCd = request.getParameter("cReqFuncCd");
    GrndsTrace.msg(TRACE_TAG, 10, "just_before_calling deletePhoneRecord sIdResource is = \n" + sIdResource);

    this.deletePhoneRecord(context, szCReqFuncCd);
    CRES03SO cres03so = this.findResource(context, sIdResource);

    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);

    // Populate CRES04SI in state with clean Resource Detail data from the database
    CRES04SI cres04si = setResourceDetailDatabaseValues(request, cres03so);
    state.setAttribute("CRES04SI_ResourceDetail", cres04si, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  protected CRES04SO deletePhoneRecord(GrndsExchangeContext context, String cReqFuncCd) {
    CRES04SO cres04so = null;
    CRES04SI cres04si = new CRES04SI();
    GrndsTrace.enterScope(TRACE_TAG + ".deletePhoneRecord");
    HttpServletRequest request = context.getRequest();
    String szWindowName = request.getParameter("WindowName");

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      if ("ResourceDetail".equalsIgnoreCase(szWindowName)) {
        cres04si = (CRES04SI) state.getAttribute("CRES04SI_ResourceDetail", request);
        UserProfile userProfile1 = UserProfileHelper.getUserProfile(request);
        cres04si.setSzNmRsrcLastUpdate(userProfile1.getUserFullName());
      }

      if ("PhoneDetail".equalsIgnoreCase(szWindowName)) {
        cres04si = (CRES04SI) state.getAttribute("CRES04SI_ResourceDetail", request);
      }
      ArchInputStruct archinputstruct = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      archinputstruct.setSzUserId(String.valueOf(user.getUserID()));
      CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cres04si.setArchInputStruct(archinputstruct);
      UserProfile userProfile1 = UserProfileHelper.getUserProfile(request);
      cres04si.setSzNmRsrcLastUpdate(userProfile1.getUserFullName());
      GrndsTrace.msg(TRACE_TAG, 10, "rbPhoneRadioIndex is = \n" + request.getParameter("rbPhoneRadioIndex"));
      int iIndex = Integer.parseInt(request.getParameter("rbPhoneRadioIndex"));
      ROWCRES04SIG01_ARRAY rowcres04sig01_array = new ROWCRES04SIG01_ARRAY();
      ROWCRES04SIG01 rowcres04sig01 = new ROWCRES04SIG01();
      ROWCRES03SOG01 rowcres03sog01 = cres03so.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(iIndex);
      int IdResourcePhone = rowcres03sog01.getUlIdRsrcPhone();
      if ("01".equals(rowcres03sog01.getSzCdFacilPhoneType())) {
        setErrorMessage(MessageLookup.getMessageByName("MSG_CMN_PRIMARY_PHONE_NO_DELETE"),
                        "/resource/ResourceSearch/results", request);
      } else {
        java.util.Date txtLstUpdate = cres03so.getROWCRES03SOG01_ARRAY().getROWCRES03SOG01(iIndex).getTsLastUpdate();
        rowcres04sig01.setTsLastUpdate(txtLstUpdate);
        rowcres04sig01.setUlIdRsrcPhone(IdResourcePhone);
        rowcres04sig01.setSzCdScrDataAction(cReqFuncCd);
        rowcres04sig01_array.setUlRowQty(1);
        rowcres04sig01_array.addROWCRES04SIG01(rowcres04sig01);
        UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY = new UlPageSizeNbr_ARRAY();
        ulPageSizeNbr_ARRAY.setUlRowQty(2);
        ulPageSizeNbr_ARRAY.addUlPageSizeNbr(0, 0);
        ulPageSizeNbr_ARRAY.addUlPageSizeNbr(1, 1);
        cres04si.setUlPageSizeNbr_ARRAY(ulPageSizeNbr_ARRAY);
        GrndsTrace.msg(TRACE_TAG, 10, "getUlPageSizeNbr_ARRAY is = \n" + cres04si.getUlPageSizeNbr_ARRAY());

        cres04si.setROWCRES04SIG01_ARRAY(rowcres04sig01_array);

        cres04so = resource.saveResourceDetail(cres04si);

      }
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), request);
        break;
      case Messages.MSG_VID_REQ:
        // MSG - Resource Details cannot be updated until VendorID is assigned by SMILE
        setErrorMessage(Messages.MSG_VID_REQ, request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH),
                        "/resource/ResourceSearch/results", request);
        break;
      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(we.getErrorMessage(), "/resource/ResourceSearch/results", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    GrndsTrace.exitScope(cres04so);
    return cres04so;
  }

  /**
   * This method is called by the GRNDS controller when the user deletes the address
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void deleteAddressDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "deleteAddressDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".deleteAddressDetail_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String sIdResource = GlobalData.getUlIdResourceAsString(request);

    String szCReqFuncCd = request.getParameter("cReqFuncCd");
    GrndsTrace.msg(TRACE_TAG, 10, "just_before_calling deleteAddressRecord sIdResource is = \n" + sIdResource);

    deleteAddressRecord(context, szCReqFuncCd);

    CRES03SO cres03so = this.findResource(context, sIdResource);
    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);

    // Populate CRES04SI in state with clean Resource Detail data from the database
    CRES04SI cres04si = setResourceDetailDatabaseValues(request, cres03so);
    state.setAttribute("CRES04SI_ResourceDetail", cres04si, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  protected void deleteAddressRecord(GrndsExchangeContext context, String CReqFuncCd) {
    CRES04SI cres04si = new CRES04SI();
    GrndsTrace.enterScope(TRACE_TAG + ".deleteAddressRecord");
    HttpServletRequest request = context.getRequest();
    String szWindowName = request.getParameter("WindowName");

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      if ("ResourceDetail".equalsIgnoreCase(szWindowName)) {
        cres04si = (CRES04SI) state.getAttribute("CRES04SI_ResourceDetail", request);
        UserProfile userProfile1 = UserProfileHelper.getUserProfile(request);
        cres04si.setSzNmRsrcLastUpdate(userProfile1.getUserFullName());
      }
      if ("frmAddressDetail".equalsIgnoreCase(szWindowName)) {
        cres04si = (CRES04SI) state.getAttribute("CRES04SI_ResourceDetail", request);
      }
      ArchInputStruct archinputstruct = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      archinputstruct.setSzUserId(String.valueOf(user.getUserID()));
      CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cres04si.setArchInputStruct(archinputstruct);
      GrndsTrace.msg(TRACE_TAG, 7, "address radio index =  " + request.getParameter("rbAddressRadioIndex"));
      int iIndex = Integer.parseInt(request.getParameter("rbAddressRadioIndex"));
      ROWCRES04SIG00_ARRAY rowcres04sig00_array = new ROWCRES04SIG00_ARRAY();
      ROWCRES04SIG00 rowcres04sig00 = new ROWCRES04SIG00();
      ROWCRES03SOG00 selectedRow = cres03so.getROWCRES03SOG00_ARRAY().getROWCRES03SOG00(iIndex);

      if (selectedRow.getSzNbrRsrcAddrVid() != null && !"".equals(selectedRow.getSzNbrRsrcAddrVid())) {
        setErrorMessage(MessageLookup.getMessageByName("MSG_RES_VID_ADDR"), "/resource/ResourceSearch/results", request);
      } else if (selectedRow.getSzCdRsrcAddrType() != null && "01".equals(selectedRow.getSzCdRsrcAddrType())) {
        setErrorMessage(MessageLookup.getMessageByName("MSG_CMN_PRIMARY_ADDRESS_NO_DELETE"),
                        "/resource/ResourceSearch/results", request);
      } else {
        int IdResourceAddress = selectedRow.getUlIdRsrcAddress();
        java.util.Date txtLstUpdate = selectedRow.getTsLastUpdate();
        GrndsTrace.msg(TRACE_TAG, 7, " Delete Address txtTsLastUpdate = " + txtLstUpdate);
        rowcres04sig00.setTsLastUpdate(txtLstUpdate);
        rowcres04sig00.setUlIdRsrcAddress(IdResourceAddress);
        rowcres04sig00.setSzCdScrDataAction(CReqFuncCd);
        rowcres04sig00_array.setUlRowQty(1);
        rowcres04sig00_array.addROWCRES04SIG00(rowcres04sig00);
        UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY = new UlPageSizeNbr_ARRAY();
        ulPageSizeNbr_ARRAY.addUlPageSizeNbr(0, 1);
        cres04si.setUlPageSizeNbr_ARRAY(ulPageSizeNbr_ARRAY);
        GrndsTrace.msg(TRACE_TAG, 10, "getUlPageSizeNbr_ARRAY is = \n" + cres04si.getUlPageSizeNbr_ARRAY());
        cres04si.setROWCRES04SIG00_ARRAY(rowcres04sig00_array);
        resource.saveResourceDetail(cres04si);
      }

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_VID_REQ:
        // MSG - Resource Details cannot be updated until VendorID is assigned by SMILE
        setErrorMessage(Messages.MSG_VID_REQ, request);
        break;
      case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH),
                        "/resource/ResourceSearch/results", request);
        break;
      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(we.getErrorMessage(), "/resource/ResourceSearch/results", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }
    GrndsTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user saves the phone
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void savePhoneDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "savePhoneDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".savePhoneDetail_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    GrndsTrace.msg(TRACE_TAG, 10, "IdPhone is= \n" + request.getParameter("IdResourcePhone"));

    int idResourcePhone = ContextHelper.getIntSafe(context, "IdResourcePhone");

    String sIdResource = GlobalData.getUlIdResourceAsString(request);
    int idResource = GlobalData.getUlIdResource(request);

    String szCReqFuncCd = request.getParameter("cReqFuncCd");

    CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
    ROWCRES03SOG01_ARRAY rowccres03sog01_array = cres03so.getROWCRES03SOG01_ARRAY();
    ROWCRES03SOG01 rowccres03sog01;
    //int phoneArraySize = rowccres03sog01_array.getUlRowQty();
    //used the array length instead of U1RowQty(). need to fix the UlRowQty error--Haritha.
    int phoneArraySize = rowccres03sog01_array.getROWCRES03SOG01().length;
    String subittedPhoneType = request.getParameter("selSzCdFacilPhoneType");

    String subittedPhoneNumber = ContextHelper.getPhoneSafe(request, "txtLNbrFacilPhoneNumber");
    String subittedPhoneExtension = request.getParameter("txtLNbrFacilPhoneExtension");

    boolean duplicatePhoneData = false;

    for (int i = 0; i < phoneArraySize; i++) {
    //for (int i = 0; i < 1; i++) {
      rowccres03sog01 = rowccres03sog01_array.getROWCRES03SOG01(i);
      GrndsTrace.msg(TRACE_TAG, 10, "phone id = " + idResourcePhone);
      GrndsTrace.msg(TRACE_TAG, 10, "rowccres03sog01.getUlIdRsrcPhone = "
                                    + new Integer(rowccres03sog01.getUlIdRsrcPhone()).toString());
      if ((idResourcePhone != rowccres03sog01.getUlIdRsrcPhone())
          && (subittedPhoneType != null && subittedPhoneType.equals(rowccres03sog01.getSzCdFacilPhoneType()))
          && (subittedPhoneNumber != null && subittedPhoneNumber.equals(rowccres03sog01.getLNbrFacilPhoneNumber()))
          && (subittedPhoneExtension != null && subittedPhoneExtension
                                                                      .equals(rowccres03sog01
                                                                                             .getLNbrFacilPhoneExtension()))) {
        GrndsTrace.msg(TRACE_TAG, 10, "Duplicate phone record found");
        duplicatePhoneData = true;
      }
    }
    if (duplicatePhoneData) {
      this.setPresentationBranch("duplicateRecord", context);
      setErrorMessage(MessageLookup.getMessageByName("MSG_RES_PHONE_EXISTS"), "/resource/ResourceSearch/results",
                      request);
    } else {
      this.savePhoneDetail(context, idResource, idResourcePhone, szCReqFuncCd);
      CRES03SO cres03so_1 = this.findResource(context, sIdResource);

      state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so_1, request);

      // Populate CRES04SI in state with clean Resource Detail data from the database
      CRES04SI cres04si = setResourceDetailDatabaseValues(request, cres03so_1);
      state.setAttribute("CRES04SI_ResourceDetail", cres04si, request);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  protected CRES04SO savePhoneDetail(GrndsExchangeContext context, int IdResource, int IdResourcePhone,
                                     String CReqFuncCd) {
    CRES04SO cres04so = null;
    CRES04SI cres04si;
    GrndsTrace.enterScope(TRACE_TAG + ".savePhoneDetail");
    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      cres04si = (CRES04SI) state.getAttribute("CRES04SI_ResourceDetail", request);
      GrndsTrace.msg(TRACE_TAG, 10, "CRES04SI_SavePhoneDetail: \n"
                                    + state.getAttribute("CRES04SI_ResourceDetail", request));
      ArchInputStruct archinputstruct = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      archinputstruct.setSzUserId(String.valueOf(user.getUserID()));
      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cres04si.setArchInputStruct(archinputstruct);
      // Phone Array
      ROWCRES04SIG01_ARRAY rowcres04sig01_array = new ROWCRES04SIG01_ARRAY();
      // Phone Row
      ROWCRES04SIG01 rowcres04sig01 = new ROWCRES04SIG01();

      rowcres04sig01.setUlIdRsrcPhone(IdResourcePhone);
      rowcres04sig01.setUlIdResource(IdResource);
      rowcres04sig01.setSzTxtRsrcPhoneComments(request.getParameter("txtszTxtRsrcPhoneComments"));
      rowcres04sig01.setLNbrFacilPhoneExtension(request.getParameter("txtLNbrFacilPhoneExtension"));
      rowcres04sig01.setSzCdFacilPhoneType(request.getParameter("selSzCdFacilPhoneType"));
      rowcres04sig01.setSzCdScrDataAction(CReqFuncCd);
      rowcres04sig01.setLNbrFacilPhoneNumber(ContextHelper.getPhoneSafe(request, "txtLNbrFacilPhoneNumber"));

      String txtLstUpdate = request.getParameter("txtTsLastUpdate");
      GrndsTrace.msg(TRACE_TAG, 10, "txtLstUpdate_in_savePhoneDetail is \n" + txtLstUpdate);
      try {
        java.util.Date txtDate = (java.util.Date) SerializationHelper.deserializeObject(txtLstUpdate);
        if (txtDate != null) {
          rowcres04sig01.setTsLastUpdate(txtDate);
        }
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Date serializatin Failure: " + e.getMessage());
        processSevereException(context, e);
      }
      rowcres04sig01_array.setUlRowQty(1);
      rowcres04sig01_array.addROWCRES04SIG01(rowcres04sig01);
      GrndsTrace.msg(TRACE_TAG, 10, "rowcres04sig01_array is = \n" + rowcres04sig01_array.toString());
      UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY = new UlPageSizeNbr_ARRAY();
      ulPageSizeNbr_ARRAY.addUlPageSizeNbr(0, 0);
      ulPageSizeNbr_ARRAY.addUlPageSizeNbr(1, 1);
      cres04si.setUlPageSizeNbr_ARRAY(ulPageSizeNbr_ARRAY);
      GrndsTrace.msg(TRACE_TAG, 10, "getUlPageSizeNbr_ARRAY is = \n" + cres04si.getUlPageSizeNbr_ARRAY());
      cres04si.setROWCRES04SIG01_ARRAY(rowcres04sig01_array);
      
      String hdnPhone = "", hdnExt = "", phoneNo = "", extNo = "";
      hdnPhone = request.getParameter("hdnPhone") != null ? (String) request.getParameter("hdnPhone") : "" ;
      hdnExt = request.getParameter("hdnExt") != null ? (String) request.getParameter("hdnExt") : "" ;
      
      phoneNo = rowcres04sig01.getLNbrFacilPhoneNumber() != null ? rowcres04sig01.getLNbrFacilPhoneNumber() : "";
      extNo = request.getParameter("txtLNbrFacilPhoneExtension");
      
      
      if((!hdnPhone.equalsIgnoreCase(phoneNo)) || (!hdnExt.equalsIgnoreCase(extNo)) ){
        cres04si.setIndPhoneChanged(true);         
      }     
      
      cres04so = resource.saveResourceDetail(cres04si);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), request);
        break;
      case Messages.MSG_VID_REQ:
        // MSG - Resource Details cannot be updated until VendorID is assigned by SMILE
        setErrorMessage(Messages.MSG_VID_REQ, request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH),
                        "/resource/ResourceSearch/results", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }
    GrndsTrace.exitScope();
    return cres04so;
  }

  /**
   * This method is called by the GRNDS controller when the user saves the address
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void addResource_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".addResource_xa");
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "addResource_xa");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String szCReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    // get back output struct from addResourceAddressPhone method
    CRES04SO cres04so = this.addResourceAddressPhone(context, szCReqFuncCd);

    int IdResource = cres04so.getUlIdResource();
    String sIdResource = String.valueOf(IdResource);
    
    String sORSFacilityId = ContextHelper.getStringSafe(context, ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
    
    //if the sORSFacilityId is not empty create the link from shines res to the ors res
    if("".equals(sORSFacilityId) == false) {
      resource.updateFacilityResourceId(sORSFacilityId, IdResource);
    }

    CRES03SO resourceDetail = this.findResource(context, sIdResource);

    GlobalData.setAppMode(this.getPageMode(request, resourceDetail), request);
    PageMode.setPageMode(this.getPageMode(request, resourceDetail), request);

    BaseSessionStateManager state = getSessionStateManager(context);
    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, resourceDetail, request);
    state.setAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, resourceDetail.getSzCdRsrcType(), request);
    GlobalData.setSzNmResource(resourceDetail.getSzNmResource(), request);

    state.setAttribute("szNmRsrcContact", resourceDetail.getSzNmRsrcContact(), request);// FacilityDetail,
    // ResourceDetail, ResCOnv
    state.setAttribute("szCdRsrcFacilType", resourceDetail.getSzCdRsrcFacilType(), request);// FacilityDetail,
    // ResourceDetail, ResCOnv

    state.setAttribute("lNbrRsrcFacilAcclaim", FormattingHelper.formatInt(resourceDetail.getLNbrRsrcFacilAcclaim()),
                       request);

    GlobalData.setSzNmResource(resourceDetail.getSzNmResource(), request);

    GlobalData.setUlIdResource(resourceDetail.getUlIdResource(), request);

    // SIR 18430 - Set idString to State so Add's would work.
    state.setAttribute("idString", sIdResource, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  protected CRES04SO addResourceAddressPhone(GrndsExchangeContext context, String cReqFuncCd) {
    CRES04SO cres04so = null;
    CRES04SI cres04si = new CRES04SI();
    String sTmpNewAddressType = "01";
    String sTmpNewPhoneType = "01";
    GrndsTrace.enterScope(TRACE_TAG + ".addResourceAddressPhone");
    HttpServletRequest request = context.getRequest();

    try {

      // need to add this when you actually logon as a user
      UserProfile userProfile1 = UserProfileHelper.getUserProfile(request);
      cres04si.setSzNmRsrcLastUpdate(userProfile1.getUserFullName());

      ArchInputStruct archinputstruct = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      archinputstruct.setSzUserId(String.valueOf(user.getUserID()));

      archinputstruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      cres04si.setArchInputStruct(archinputstruct);
      GrndsTrace.msg(TRACE_TAG, 10, "before calling setResourceDetailParameterValues");

      cres04si = setResourceDetailParameterValues(request, cres04si);
      // Address Array
      ROWCRES04SIG00_ARRAY rowcres04sig00_array = new ROWCRES04SIG00_ARRAY();
      // Address Row
      ROWCRES04SIG00 rowcres04sig00 = new ROWCRES04SIG00();
      // Phone Array
      ROWCRES04SIG01_ARRAY rowcres04sig01_array = new ROWCRES04SIG01_ARRAY();
      // Phone Row
      ROWCRES04SIG01 rowcres04sig01 = new ROWCRES04SIG01();

      // -- Retrieve values via the AddressBean in the request
      String addressSubmoduleName = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME);
      AddressBean addressBean = AddressBean.getFromRequest(addressSubmoduleName, request);
      if (addressBean == null) {
        // -- This should never happen since the resource/AddressDetail.jsp page always uses standardized
        // -- AddressBean request parameter names, allowing the AddressBean to be initialized and populated
        // -- via the getFromRequest static method.
        addressBean = new AddressBean(addressSubmoduleName);
      }

      rowcres04sig00.setSzCdRsrcAddrType(sTmpNewAddressType);
      rowcres04sig00.setSzNbrRsrcAddrVid(ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVid"));
      rowcres04sig00.setSzAddrRsrcAddrStLn1(addressBean.getAddress1() != null ? addressBean.getAddress1() : "");
      rowcres04sig00.setSzAddrRsrcAddrStLn2(addressBean.getAddress2() != null ? addressBean.getAddress2() : "");
      rowcres04sig00.setSzAddrRsrcAddrAttn(request.getParameter("txtSzAddrRsrcAddrAttn"));
      rowcres04sig00.setSzAddrRsrcAddrCity(addressBean.getCity() != null ? addressBean.getCity() : "");
      rowcres04sig00.setSzCdFacilityState(addressBean.getState() != null ? addressBean.getState() : "");

      rowcres04sig00.setSzAddrRsrcAddrZip(addressBean.getZipAndSuff() != null ? addressBean.getZipAndSuff() : "");
      rowcres04sig00.setSzAddrRsrcAddrCounty(addressBean.getCounty() != null ? addressBean.getCounty() : "");

      // SHINES
      rowcres04sig00.setNbrRsrcAddrLat(ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLat"));
      rowcres04sig00.setNbrRsrcAddrLong(ContextHelper.getDoubleSafe(request, "hdnNbrRsrcAddrLong"));
      rowcres04sig00.setSzTxtRsrcAddrComments(ContextHelper.getStringSafe(request, "txtszTxtRsrcAddrComments"));
      rowcres04sig00.setUlIdResource(0);
      rowcres04sig00.setUlIdRsrcAddress(0);
      rowcres04sig00.setSzCdScrDataAction(cReqFuncCd);
      rowcres04sig00_array.setUlRowQty(1);
      rowcres04sig00_array.addROWCRES04SIG00(rowcres04sig00);
      UlPageSizeNbr_ARRAY ulPageSizeNbr_ARRAY = new UlPageSizeNbr_ARRAY();
      ulPageSizeNbr_ARRAY.addUlPageSizeNbr(0, 1);
      cres04si.setUlPageSizeNbr_ARRAY(ulPageSizeNbr_ARRAY);
      cres04si.setROWCRES04SIG00_ARRAY(rowcres04sig00_array);
      rowcres04sig01.setUlIdRsrcPhone(0);
      rowcres04sig01.setUlIdResource(0);
      rowcres04sig01.setSzCdScrDataAction(cReqFuncCd);
      rowcres04sig01.setSzCdFacilPhoneType(sTmpNewPhoneType);
      rowcres04sig01.setLNbrFacilPhoneNumber(ContextHelper.getPhoneSafe(request, "txtLNbrFacilPhoneNumber"));
      rowcres04sig01.setLNbrFacilPhoneExtension(request.getParameter("txtLNbrFacilPhoneExtension"));
      rowcres04sig01.setSzTxtRsrcPhoneComments(request.getParameter("txtszTxtRsrcPhoneComments"));
      GrndsTrace.msg(TRACE_TAG, 10, "AddResource selSzCdFacilPhoneType is = \n"
                                    + request.getParameter("selSzCdFacilPhoneType"));

      rowcres04sig01_array.setUlRowQty(1);
      rowcres04sig01_array.addROWCRES04SIG01(rowcres04sig01);
      ulPageSizeNbr_ARRAY.addUlPageSizeNbr(1, 1);
      cres04si.setUlPageSizeNbr_ARRAY(ulPageSizeNbr_ARRAY);
      cres04si.setROWCRES04SIG01_ARRAY(rowcres04sig01_array);
      cres04so = resource.saveResourceDetail(cres04si);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Integer.MAX_VALUE:
        setErrorMessage(we.getMessage(), request);
        break;
      case Messages.MSG_VID_REQ:
        // MSG - Resource Details cannot be updated until VendorID is assigned by SMILE
        setErrorMessage(Messages.MSG_VID_REQ, request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH),
                        "/resource/ResourceSearch/results", request);
        break;

      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(we.getErrorMessage(), "/resource/ResourceSearch/results", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }
    GrndsTrace.exitScope();
    return cres04so;
  }

  /**
   * This method is called by the GRNDS controller when the user requests the detail of an Address
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void displayAddressDetail_xa(GrndsExchangeContext context) {

    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("AddressDetailConversation", "DisplayAddressDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".DisplayAddressDetail_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
    try {
      ROWCRES03SOG00_ARRAY rowCres03sog00_array = cres03so.getROWCRES03SOG00_ARRAY();
      String idStringIndex = request.getParameter("indexNum");
      ROWCRES03SOG00 rowcres03sog00 = rowCres03sog00_array.getROWCRES03SOG00(Integer.parseInt(idStringIndex));
      request.setAttribute("addressDetail", rowcres03sog00);

      if (!StringHelper.isValid(request.getParameter("selCdFacilityCounty"))) {
        request.setAttribute("selCdFacilityCounty", rowcres03sog00.getSzCdFacilityCounty());
      }
      
      // STGAP00017058 - set pagemode to edit for users fiscal ops security class
      UserProfile user = UserProfileHelper.getUserProfile(request);
      // check to see if user is the Fiscal Operations State Office Maintainer
      if(common.hasSecurityClass(user.getUserID(), FISC_OPS_MAINT)){
        // set page mode to edit and add attribute to state to signify that we are in edit plus mode
        request.setAttribute("editPlus", true);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception executing displayAddressDetail_xa.");
      processSevereException(context, e);

    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests the detail of a Phone
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void displayPhoneDetail_xa(GrndsExchangeContext context) {

    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "DisplayPhoneDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".DisplayPhoneDetail_xa");
    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);

      ROWCRES03SOG01_ARRAY rowccres03sog01_array = cres03so.getROWCRES03SOG01_ARRAY();
      String idStringIndex = request.getParameter("indexNum");
      String idStringResource = GlobalData.getUlIdResourceAsString(request);
      GrndsTrace.msg(TRACE_TAG, 10, "idStringResource:" + idStringResource);
      ROWCRES03SOG01 phoneRow = new ROWCRES03SOG01();
      if (!ServiceConstants.REQ_FUNC_CD_ADD.equalsIgnoreCase(ContextHelper.getStringSafe(request, "cReqFuncCd"))) {
        phoneRow = rowccres03sog01_array.getROWCRES03SOG01(Integer.parseInt(idStringIndex));
      }
      request.setAttribute("PhoneDetail_Attribute", phoneRow);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception executing displayPhoneDetail_xa.");
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }
  /**
   * This method is called by the GRNDS controller when the user requests the detail of a ORS Facility
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void displayOrsFacilty_xa(GrndsExchangeContext context) {

    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "DisplayOrsFacility_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".DisplayOrsFacility_xa");
    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);

      ROWCRES03SOG02_ARRAY rowccres03sog02_array = cres03so.getROWCRES03SOG02_ARRAY();
      String idStringIndex = request.getParameter("indexNum");
      String idStringResource = GlobalData.getUlIdResourceAsString(request);
      GrndsTrace.msg(TRACE_TAG, 10, "idStringResource:" + idStringResource);
      ROWCRES03SOG02 orsFacRow = new ROWCRES03SOG02();
      if (!ServiceConstants.REQ_FUNC_CD_ADD.equalsIgnoreCase(ContextHelper.getStringSafe(request, "cReqFuncCd"))) {
        orsFacRow = rowccres03sog02_array.getROWCRES03SOG02(Integer.parseInt(idStringIndex));
      }
      request.setAttribute("OrsFacility_Attribute", orsFacRow);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, " Exception executing displayOrsFacility_xa.");
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }
  
  /**
   * This method is called by the GRNDS controller when the user requests the detail of a ORS Facility
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void addORSResource_xa(GrndsExchangeContext context) {

    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "addORSResource_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".addORSResource_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CRES03SO cres03so = (CRES03SO)state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
    state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
    ResourceORSSearchPullBackInfo resourceORSSearchData = new ResourceORSSearchPullBackInfo();
    try {

      resourceORSSearchData.setDestinationUrl("/resource/ResourceDetail/setORSResource");
      request.setAttribute(ResourceORSSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceORSSearchData);
      request.setAttribute("destinationUrl", "/resource/ResourceDetail/setORSResource");
      String forwardUrl = "/resource/ResourceORSSearch/";
      forward(forwardUrl,request,context.getResponse());
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
      return;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
    return;
  }

  /**
   * This method is called by the GRNDS controller when the user requests the detail of a ORS Facility
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void setORSResource_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "setORSResource_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".setORSResource_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
      String facilityId = ContextHelper.getStringSafe(context, ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      if(facilityId != null) {
        ORSResourceDetailSO orsResourceDetail = resource.retrieveORSFacilityDetail(facilityId);
        if (orsResourceDetail != null){
          ROWCRES03SOG02 rowcres03sog02 = new ROWCRES03SOG02();
          rowcres03sog02.setSzNbrOrsRsrcId(orsResourceDetail.getSzORSFacilityID());
          rowcres03sog02.setSzNmOrsFacilName(orsResourceDetail.getSzResourceName());
          rowcres03sog02.setSzNmOrsFacType(orsResourceDetail.getSzORSFacilityType());
          rowcres03sog02.setSzTxtOrsFacStatus(orsResourceDetail.getSzOperatingStatus());
          ROWCRES03SOG02_ARRAY testRow = cres03so.getROWCRES03SOG02_ARRAY();
          if(testRow == null) {
            cres03so.setROWCRES03SOG02_ARRAY(new ROWCRES03SOG02_ARRAY());
          }
          cres03so.getROWCRES03SOG02_ARRAY().addROWCRES03SOG02(rowcres03sog02);
          resource.updateFacilityResourceId(facilityId, cres03so.getUlIdResource());
        }
      }
      state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
      return;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
    return;
  }
  
  /**
   * This method is called by the GRNDS controller when the user requests to unassociate an ORS facility 
   * 
   * @param context
   *          The context of this page including the http request and other GRNDS information
   */
  public void deleteOrsFacility_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ResourceDetailConversation", "deleteOrsFacility_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".deleteOrsFacility_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      CRES03SO cres03so = (CRES03SO) state.getAttribute(CRES03SO_ATTRIBUTE_NAME, request);
      int iIndex = Integer.parseInt(request.getParameter("rbORSRadioIndex"));
      ROWCRES03SOG02 rowcres03sog02 = cres03so.getROWCRES03SOG02_ARRAY().getROWCRES03SOG02(iIndex);
      resource.updateFacilityResourceId(rowcres03sog02.getSzNbrOrsRsrcId(), 0);
      cres03so.getROWCRES03SOG02_ARRAY().removeROWCRES03SOG02At(iIndex);
      state.setAttribute(CRES03SO_ATTRIBUTE_NAME, cres03so, request);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
      return;
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }
  
  private String geORSAssociateToSHINESSecAtt(HttpServletRequest request) {
    String retValue = "0";
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_ASSOCIATE_ORS_SHINES) == true ? "1" : "0" ;
    }
    return retValue;
  }
}
