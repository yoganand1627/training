package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- java classes --

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON16SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON16SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimsSearchSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ValidationPatternMatcher;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class used by the SubcontractorDetail page for their update, delete, add, etc. functions.
 * 
 * @author Donald Wilson, May 28, 2003
 * 
 * Change History:
 * Date         User              Description
 * --------     ----------------  -------------------------------------------------
 * 04/03/2009   arege             STGAP00012937 Added code for Pagination of Service Site/SubContractor List
 *                                on the Resource Detail Page.
 * 04/09/2009   arege             STGAP00012937 Removed extra try- catch as per peer review.                             
 * 
 */

public class SubcontractorSubConversation extends BaseHiddenFieldStateConversation {

  // static constants
  private static final String TRACE_TAG = "SubcontractorSubConversation";

  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  /**
   * This method is called by the GRNDS controller when the user requests the detail of a subcontractor
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void displaySubcontractorDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displaySubcontractorDetail_xa");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".displaySubcontractorDetail_xa");
    HttpServletRequest request = context.getRequest();

    GrndsTrace.msg(TRACE_TAG, 10, "sub_txtUIdRsrcLinkParent is:"
                                  + request.getParameter("SubcontractorSubvtxtUIdRsrcLinkParent"));
    try {
      CRES05SI cres05si = new CRES05SI();
      ArchInputStruct input = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      input.setSzUserId(user.getUserLogonID());

      input.setUlPageSizeNbr(120);
      input.setUsPageNbr(1);
      cres05si.setArchInputStruct(input);
      cres05si.setUlIdResource(ContextHelper.getIntSafe(context, "SubcontractorSubvtxtUlIdResource"));

      CRES05SO cres05so = resource.retrieveAreaServed(cres05si);
      if (cres05so != null) {
        ROWCRES05SOG00_ARRAY rowcres05sog00_array = cres05so.getROWCRES05SOG00_ARRAY();
        GrndsTrace.msg(TRACE_TAG, 10, "Service Struct UL Row QTY" + rowcres05sog00_array.getUlRowQty());
        request.setAttribute("ROWCRES05SOG00_ARRAY_subcontractorDetail", rowcres05sog00_array);
      }
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_NO_ROWS_RETURNED:
        GrndsTrace.msg(TRACE_TAG, 7, "No Rows Returned:");
        setErrorMessage(MessageLookup.getMessageByName("SSM_CON_NO_SERVICE_EXISTS"),
                        "/resource/ResourceDetail/displaySubcontractorDetail", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "WTC Error COde " + we.getErrorCode());
        break;
      }
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    GrndsTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests the validation of a resource
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void validateSubcontractorId_xa(GrndsExchangeContext context) {

    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "ValidateSubcontractor_xa");
    // start the method trace
    performanceTrace.enterScope();

    GrndsTrace.enterScope(TRACE_TAG + ".ValidateSubcontractor_xa");
    HttpServletRequest request = context.getRequest();
    GrndsTrace.msg(TRACE_TAG, 10, "request_in_validateSubcontractorId_xa is: " + context.getRequest());

    String facilType = request.getParameter("SubcontractorSubvfacilityType");
    String idStringResource = request.getParameter("SubcontractorSubvtxtUIdRsrcLinkChild").trim();
    String newIdStringResource = request.getParameter("SubcontractorSubvtxtNewIdResource");
    GrndsTrace.msg(TRACE_TAG, 10, "newIdStringResource:" + newIdStringResource);

    CCON17SO ccon17so = null;
    ValidationPatternMatcher patternMatcher = ValidationPatternMatcher.getInstance("SubContractorDetail");
    boolean resourceIdisValid = patternMatcher.match("/^\\d+$/", idStringResource);
    if (resourceIdisValid) {
      GrndsTrace.msg(TRACE_TAG, 10, "resource id is valid");
      ccon17so = this.findValidateSubcontractor(context, idStringResource);

      if (ccon17so == null) {
        // MSG - "The Subcontractor ID (a.k.a. Resource ID) you have entered is invalid."
        setErrorMessage(MessageLookup.getMessageByName("MSG_CON_RESOURCE_INVALID"),
                                "/resource/ResourceSearch/results", request);
      } else if (ccon17so.getUlIdResource() != 0){

        setErrorMessage(addMessageParameters(MessageLookup.getMessageByName("MSG_RSRC_SUB_ALREADY_EXISTS"), ccon17so.getUlIdResource() )
                        , "/resource/ResourceSearch/results", request);
      }

      request.setAttribute("CCON17S_SubcontractorValidate", ccon17so);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
      GrndsTrace.exitScope();
    } else {
      GrndsTrace.msg(TRACE_TAG, 10, "resource id is NOT valid");
      // MSG - "The Subcontractor ID (a.k.a. Resource ID) entered needs to be a numeric value."
      setErrorMessage(MessageLookup.getMessageByName("MSG_CON_RESOURCE_INVALID"), "/resource/ResourceSearch/results",
                      request);
    }
  }

  /**
   * This method calls a Tuxedo service to delete of an subcontractor
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   * @param String
   *          The mode (A/U/D) of the service request
   */
  private CCON16SO deleteSubcontractorRecord(GrndsExchangeContext context, String CReqFuncCd) {
    CCON16SO ccon16so = null;
    CCON16SI ccon16si = new CCON16SI();
    GrndsTrace.enterScope(TRACE_TAG + ".deleteSubcontractorRecord");
    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      ArchInputStruct archinputstruct = new ArchInputStruct();
      CCON15SO ccon15so = (CCON15SO) state.getAttribute("CCON15S", request);
      UserProfile user = UserProfileHelper.getUserProfile(context);
      archinputstruct.setSzUserId(user.getUserLogonID());
      archinputstruct.setCReqFuncCd(CReqFuncCd);

      boolean onDetailPage = StringHelper.isValid(request.getParameter("SubcontractorSubvbtnDeleteSubcontractorRow.x"));
      String[] SubIndex = CheckboxHelper.getCheckedValues(request,
                                                          "SubcontractorSub_cbxSubcontractorCheckboxIndex_CLEAN");

      if (!onDetailPage && SubIndex.length == 0) {
        setErrorMessage(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"), "/resource/ResourceSearch/results",
                        request);
      }

      int pageSizeNbr = 1;
      if (SubIndex != null && !onDetailPage) {
        pageSizeNbr = SubIndex.length;
      }
      archinputstruct.setUlPageSizeNbr(pageSizeNbr);
      ccon16si.setArchInputStruct(archinputstruct);
      ROWCCON16SIG00_ARRAY rowccon16sig00_array = new ROWCCON16SIG00_ARRAY();

      if (SubIndex == null || onDetailPage) {
        ROWCCON16SIG00 rowccon16sig00 = new ROWCCON16SIG00();
        int iIndex = Integer.parseInt(request.getParameter("SubcontractorSubvindexNum"));
        int IdResourceLink = ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(iIndex).getUIdRsrcLink();
        GrndsTrace.msg(TRACE_TAG, 10, "IdResourceLink_is = \n" + IdResourceLink);
        java.util.Date txtLstUpdate = ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(iIndex).getTsLastUpdate();
        GrndsTrace.msg(TRACE_TAG, 10, "txtLstUpdate_is = \n" + txtLstUpdate);
        rowccon16sig00.setTsLastUpdate(txtLstUpdate);
        rowccon16sig00.setUIdRsrcLink(IdResourceLink);
        rowccon16sig00.setSzCdScrDataAction(CReqFuncCd);
        rowccon16sig00_array.addROWCCON16SIG00(rowccon16sig00);
      } else {
        rowccon16sig00_array.setUlRowQty(SubIndex.length);
        for (int j = 0; j < SubIndex.length; j++) {
          ROWCCON16SIG00 rowccon16sig00 = new ROWCCON16SIG00();
          int iIndex = Integer.parseInt(SubIndex[j]);
          GrndsTrace.msg(TRACE_TAG, 10, "iIndex_in_del is = \n" + iIndex);
          GrndsTrace.msg(TRACE_TAG, 10, "Subindex_is = \n" + SubIndex);
          int IdResourceLink = ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(iIndex).getUIdRsrcLink();
          GrndsTrace.msg(TRACE_TAG, 10, "IdResourceLink_is = \n" + IdResourceLink);
          java.util.Date txtLstUpdate = ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(iIndex).getTsLastUpdate();
          GrndsTrace.msg(TRACE_TAG, 10, "txtLstUpdate_is = \n" + txtLstUpdate);
          rowccon16sig00.setTsLastUpdate(txtLstUpdate);
          rowccon16sig00.setUIdRsrcLink(IdResourceLink);
          rowccon16sig00.setSzCdScrDataAction(CReqFuncCd);
          rowccon16sig00_array.addROWCCON16SIG00(rowccon16sig00);
        }
      }
      ccon16si.setROWCCON16SIG00_ARRAY(rowccon16sig00_array);
      // Call WTC
      ccon16so = resource.saveUpdateOrDeleteRscrcLink(ccon16si);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(we.getErrorMessage(), "/resource/ResourceSearch/results", request);
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
    GrndsTrace.exitScope();// ccon16so );
    return ccon16so;
  }

  /**
   * This method is called by the GRNDS controller when the user saves/adds the subcontractor
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void saveSubcontractorDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSubcontractorDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".saveSubcontractorDetail_xa");
    HttpServletRequest request = context.getRequest();
    int idRsrcLinkChild = Integer.parseInt(request.getParameter("SubcontractorSubvtxtUIdRsrcLinkChild"));
    String sIdResource = request.getParameter("SubcontractorSubvtxtUIdRsrcLinkParent");

    int idRsrcLinkParent = 0;
    GrndsTrace.msg(TRACE_TAG, 10, "txtUIdRsrcLinkParent = ["
                                  + request.getParameter("SubcontractorSubvtxtUIdRsrcLinkParent") + "]");
    if (StringHelper.isValid(request.getParameter("SubcontractorSubvtxtUIdRsrcLinkParent"))) {
      idRsrcLinkParent = Integer.parseInt(request.getParameter("SubcontractorSubvtxtUIdRsrcLinkParent"));
    }
    String cReqFuncCd = request.getParameter("SubcontractorSubvcReqFuncCd");
    GrndsTrace.msg(TRACE_TAG, 10, "cReqFuncCd is \n" + cReqFuncCd);
    GrndsTrace.msg(TRACE_TAG, 10, "inside saveSubcontractorDetail_xa befor_calling_function \n");

    this.saveSubcontractorDetail(context, idRsrcLinkChild, idRsrcLinkParent, cReqFuncCd);

    CCON15SO ccon15so = this.findSubcontractor(context, sIdResource, true);

    BaseSessionStateManager state = getSessionStateManager(context);

    state.setAttribute("CCON15S", ccon15so, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user deletes subcontractor
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   */
  public void deleteSubcontractorDetail_xa(GrndsExchangeContext context) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteSubcontractorDetail_xa");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".deleteSubcontractorDetail_xa");
    HttpServletRequest request = context.getRequest();
    GrndsTrace.msg(TRACE_TAG, 10, "idStringResource_in_delete:"
                                  + request.getParameter("SubcontractorSubvtxtUlIdResource"));

    String sIdResource = request.getParameter("SubcontractorSubvtxtUlIdResource");
    String cReqFuncCd = request.getParameter("SubcontractorSubvcReqFuncCd");
    GrndsTrace.enterScope(TRACE_TAG + "cReqFuncCd is \n" + cReqFuncCd);
    GrndsTrace.enterScope(TRACE_TAG + "inside deleteSubcontractorDetail_xa befor_calling_function \n");
    this.deleteSubcontractorRecord(context, cReqFuncCd);

    CCON15SO ccon15so = this.findSubcontractor(context, sIdResource, true);

    BaseSessionStateManager state = getSessionStateManager(context);

    state.setAttribute("CCON15S", ccon15so, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    GrndsTrace.exitScope();
  }

  /**
   * This method calls a Tuxedo service to get the resourceSubDetail
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   * @param String
   *          The resource's Id
   * @param boolean
   *          Subcontractor pre-display indicator
   */
  private CCON15SO findSubcontractor(GrndsExchangeContext context, String id, boolean subContractorPreDisplay) {
    CCON15SO ccon15so = null;
    GrndsTrace.enterScope(TRACE_TAG + ".findSubcontractor");
    try {
      // Set up pagination for subcontractor list.
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(70);

      ArchInputStruct input = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      input.setSzUserId(user.getUserLogonID());
      CCON15SI ccon15si = new CCON15SI();
      ccon15si.setUIdRsrcLinkParent(Integer.parseInt(id));
      ccon15si.setBSysIndSbcntrPredisplay(StringHelper.toYorN(subContractorPreDisplay));

      input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
      input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
      ccon15si.setArchInputStruct(input);

      ccon15so = resource.findSubcontractorResources(ccon15si);

      GrndsTrace.exitScope();

    } catch (ServiceException e) {
      // Handle a No Data Found error
      if (e.getErrorCode() != 1403) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    }
    return ccon15so;
  }

  /**
   * This method calls a Tuxedo service for subcontractor validation
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   * @param String
   *          The resource Id of the subcontractor
   */
  private CCON17SO findValidateSubcontractor(GrndsExchangeContext context, String id) {
    CCON17SO ccon17so = null;

    GrndsTrace.enterScope(TRACE_TAG + ".validateSubcontractor");

    ArchInputStruct archinputstruct = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    archinputstruct.setSzUserId(user.getUserLogonID());
    CCON17SI ccon17si = new CCON17SI();
    ccon17si.setUIdRsrcLinkChild(Integer.parseInt(id));
    ccon17si.setArchInputStruct(archinputstruct);
    ccon17so = resource.retrieveResourceName(ccon17si);
          
    GrndsTrace.exitScope();
    return ccon17so;   
  }

  /**
   * This method calls a Tuxedo service to get the resourceSubDetail
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   * @param String
   *          The resource's Id
   * @param boolean
   *          Subcontractor pre-display indicator
   */
  public void retrieveSubcontractorList_xa(GrndsExchangeContext context) {
    CCON15SO ccon15so = null;
    GrndsTrace.enterScope(TRACE_TAG + ".findSubcontractor");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      state.removeAttribute("CCON15S", request);

      // Set up pagination for subcontractor list.
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();

      ValueBeanHelper.populateDefaultValues(context, tuxPagination);

      tuxPagination.getResultDetails().setResultsPerPage(70);

      ArchInputStruct input = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      input.setSzUserId(user.getUserLogonID());

      CCON15SI ccon15si = new CCON15SI();

      String sIdResource = (String) request.getAttribute("SubcontractorSubvidResource");

      ccon15si.setUIdRsrcLinkParent(Integer.parseInt(sIdResource));
      ccon15si
              .setBSysIndSbcntrPredisplay(StringHelper
                                                      .toYorN(StringHelper
                                                                          .isTrue((String) request
                                                                                                  .getAttribute("SubcontractorSubvpredisplay"))));

      input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
      input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());

      ccon15si.setArchInputStruct(input);
      ccon15so = resource.findSubcontractorResources(ccon15si);
 
      state.setAttribute("CCON15S", ccon15so, request);
      //STGAP00012937 Added this for Pagination      
        if(ccon15so != null){
        tuxPagination.setPaginationInformation(ccon15so.getArchOutputStruct(),ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00Count());
        request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
        storePaginationBeanToRequest(context, tuxPagination);
        }   

      GrndsTrace.exitScope();

    } catch (ServiceException e) {
      // Handle a No Data Found error
      if (e.getErrorCode() != 1403) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {      
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);      
    }
  }

  /**
   * This method calls a Tuxedo service to save Detail of Subcontractor
   * 
   * @param GrndsExchangeContext
   *          The context of this page including the http request and other GRNDS information
   * @param int
   *          The Id of the Subcontractor
   * @param int
   *          The Id of the parent resource
   * @param String
   *          The mode (A/U/D) of the service request
   */
  private CCON16SO saveSubcontractorDetail(GrndsExchangeContext context, int idRsrcLinkChild, int idRsrcLinkParent,
                                           String cReqFuncCd) {
    CCON16SO ccon16so = null;
    CCON16SI ccon16si = new CCON16SI();
    GrndsTrace.enterScope(TRACE_TAG + ".saveSubcontractorDetail");
    HttpServletRequest request = context.getRequest();

    try {
      String tmpTxtuIdRsrcLink = request.getParameter("SubcontractorSubvtxtUIdRsrcLink");
      ArchInputStruct archinputstruct = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      archinputstruct.setSzUserId(user.getUserLogonID());
      archinputstruct.setUlPageSizeNbr(1);
      archinputstruct.setCReqFuncCd(cReqFuncCd);
      ccon16si.setArchInputStruct(archinputstruct);
      // Subcontractor array
      ROWCCON16SIG00_ARRAY rowccon16sig00_array = new ROWCCON16SIG00_ARRAY();
      // Subcontractor row
      ROWCCON16SIG00 rowccon16sig00 = new ROWCCON16SIG00();

      rowccon16sig00.setSzCdRsrcLinkType("01"); // Prime/Sub relationship type
      String txtLstUpdate = request.getParameter("SubcontractorSubvtxtTsLastUpdate");
      GrndsTrace.msg(TRACE_TAG, 10, "txtTsLastUpdate_in_saveSubcontractorDetail= \n" + txtLstUpdate);
      if (txtLstUpdate != null) {
        java.util.Date txtDate = (java.util.Date) SerializationHelper.deserializeObject(txtLstUpdate);
        rowccon16sig00.setTsLastUpdate(txtDate);
      }
      GrndsTrace.msg(TRACE_TAG, 10, "tmpTxtuIdRsrcLink_in_saveSubcontractorDetail= \n" + tmpTxtuIdRsrcLink);
      if (StringHelper.isValid(tmpTxtuIdRsrcLink)) {
        int iIdResourceLink = Integer.parseInt(tmpTxtuIdRsrcLink);
        rowccon16sig00.setUIdRsrcLink(iIdResourceLink);
      }
      rowccon16sig00.setSzCdRsrcLinkService(request.getParameter("SubcontractorSubvselCdRsrcSvcService"));
      rowccon16sig00.setSzCdScrDataAction(cReqFuncCd);
      rowccon16sig00.setUIdRsrcLinkChild(idRsrcLinkChild);
      rowccon16sig00.setUIdRsrcLinkParent(idRsrcLinkParent);
      rowccon16sig00_array.setUlRowQty(1);
      rowccon16sig00_array.addROWCCON16SIG00(rowccon16sig00);
      ccon16si.setROWCCON16SIG00_ARRAY(rowccon16sig00_array);

      ccon16so = resource.saveUpdateOrDeleteRscrcLink(ccon16si);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        setErrorMessage(errorMessage1, "/resource/ResourceSearch/results", request);
        break;
      case Messages.MSG_DUPLICATE_RECORD:
      case 1:
        this.setPresentationBranch("error", context);
        // MSG - "Duplicate Record Exists."
        setErrorMessage(MessageLookup.getMessageByName("MSG_DUPLICATE_RECORD"), "/resource/ResourceSearch/results",
                        request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (IOException ie) {
      GrndsTrace.msg(TRACE_TAG, 7, "IO Exception:" + ie.getMessage());
      processSevereException(context, ie);
    }
    GrndsTrace.exitScope();
    return ccon16so;
  }
  
  
  private String addMessageParameters(String message, int idResource) {
    return MessageLookup.addMessageParameter(message, idResource);
  }
}