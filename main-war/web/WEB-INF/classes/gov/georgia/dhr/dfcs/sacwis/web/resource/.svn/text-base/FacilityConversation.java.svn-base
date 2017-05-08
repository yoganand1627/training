package gov.georgia.dhr.dfcs.sacwis.web.resource;

// -- java classes --

import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateAndTimeException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveFacilityDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SelectedLicensureTypesArrayIn;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;


/**
 * This is the conversation class used to maintain facilities in the system. <p/> October 8, 2002 Chris Cawthon
 * 
 * <pre>
 *       Change History:
 *        Date      User      Description
 *        --------  --------  --------------------------------------------------
 *        12/01/03  CORLEYAN  LOC Enhancement - Modified many methods in order to
 *                            interpret the new LOC Codes for post 09/01/2003
 *        03/08/04  RIOSJA    SIR 22521 - Added constants for certain field names
 *                            that are stored in state and used across multiple
 *                            conversations.
 *        02/16/05  REEDLG    SIR 18351 - update NmRsrcLastUpdate to populate name
 *                            of last person to update data.
 * </pre>
 */

public class FacilityConversation extends BaseHiddenFieldStateConversation {
  // static constants
  public static final String FACILITY_ID_FIELD_NAME = "lNbrRsrcFacilAcclaim"; // RIOSJA, SIR 22521

  public static final String RESOURCE_CONTACT_FIELD_NAME = "szNmRsrcContact"; // RIOSJA, SIR 22521

  public static final int RESULTS_PER_PAGE = 100;

  private static final String TRACE_TAG = "FacilityConversation";


  
  private RetrieveFacilityDetail retrieveFacilityDetail;

  /** @param retrieveFacilityDetail  */
  public void setRetrieveFacilityDetail(RetrieveFacilityDetail retrieveFacilityDetail) {
    this.retrieveFacilityDetail = retrieveFacilityDetail;
  }


  private Resource resource;

  public void setResource(Resource resource) 
  {
    this.resource = resource;
  }


  /**
   * This method is called by the GRNDS controller when the user requests the detail of a facility
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  public void displayFacilityDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace("FacilityConversation", "DisplayFacilityDetail_xa");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    String idString = "";
    String nmRsrcContact = "";
    String cdRsrcType = "";
    String cdRsrcFacilType = "";
    String cdRsrcMaintainer = "";
    String facilityName = "";

    int facilityNumber = 0;
    CRES03SO cres03so = null;

    if (state.getAttribute(ResourceDetailConversation.CRES03SO_ATTRIBUTE_NAME, request) == null) {
      GrndsTrace.msg(TRACE_TAG, 10, "getting from state attributes");
      idString = GlobalData.getUlIdResourceAsString(request);
      cres03so = this.findResource(context, idString);
    } else {
      // Get the parameters passed from the Resource Detail page
      GrndsTrace.msg(TRACE_TAG, 10, "getting from cres03so object");
      cres03so = (CRES03SO) state.getAttribute(ResourceDetailConversation.CRES03SO_ATTRIBUTE_NAME, request);// SR-
    }
    
    idString = FormattingHelper.formatInt(cres03so.getUlIdResource());// SR-

    nmRsrcContact = cres03so.getSzNmRsrcContact();
    cdRsrcType = cres03so.getSzCdRsrcType();
    cdRsrcFacilType = cres03so.getSzCdRsrcFacilType();
    facilityName = cres03so.getSzNmResource();
    facilityNumber = cres03so.getLNbrRsrcFacilAcclaim();

    //get the page mode
    String pageMode = getPageMode(request, cres03so);

    
    // Remove Extraneous info from state.
    state.removeAllAttributes(request);
    state.setAttribute(RESOURCE_CONTACT_FIELD_NAME, nmRsrcContact, request);
    state.setAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, cdRsrcType, request);
    state.setAttribute("szCdRsrcFacilType", cdRsrcFacilType, request);
    state.setAttribute(FACILITY_ID_FIELD_NAME, FormattingHelper.formatInt(facilityNumber), request);
    
    //set the page mode after removalAllAttributes because that resets it to View
    GlobalData.setAppMode(pageMode, request);
    PageMode.setPageMode(GlobalData.getAppMode(request), request);
    
    try {
      // call method to retrieve the Facility Detail information
      CRES09SO facilityDetail = this.findFacility(context, idString);
      state.setAttribute("cres09so", facilityDetail, request);

      if (CodesTables.CFACTYP4_CP.equals(cdRsrcFacilType)) {
        CRES02SO homeList = this.homeList(context, idString);
        request.setAttribute("cres02so", homeList);
      } else {
        request.setAttribute("cres02so", null);
      }
    } catch (Throwable e) {
      e.printStackTrace();
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
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
    if (resDetail != null && facilityType != null && (CodesTables.CFACTYP4_70.equals(facilityType) || CodesTables.CFACTYP4_71.equals(facilityType))) {
      pageMode = PageModeConstants.VIEW;
    }
    GrndsTrace.msg(TRACE_TAG, 7, "getPageMode() - The page mode is: " + pageMode);
    return pageMode;
  }
  
  
  /**
   * This method is called by the GRNDS controller when the user requests to save the Facility Detail
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  public void saveFacility_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // get the cres09so object that is passed from hidden field state
    CRES09SO cres09so = (CRES09SO) state.getAttribute("cres09so", request);

    // create new instance of the save input structure
    CRES10SI cres10si = new CRES10SI();

    // if the close date is null, get the close date that is passed in from hidden field state
    // if the close date is not null, get the new date entered by the user
    if (request.getParameter("closeDate") == null) {
      cres10si.setDtDtRsrcClose(cres09so.getDtDtRsrcClose());
    } else {
      org.exolab.castor.types.Date closeDate = ContextHelper.getCastorDateSafe(request, "closeDate");
      cres10si.setDtDtRsrcClose(closeDate);
    }

    // if the certification date is null, get the close date that is passed in from hidden field state
    // if the certification date is not null, get the new date entered by the user
    if (request.getParameter("certDate") == null) {
      cres10si.setDtDtRsrcCert(cres09so.getDtDtRsrcCert());
    } else {
      org.exolab.castor.types.Date certDate = ContextHelper.getCastorDateSafe(request, "certDate");
      cres10si.setDtDtRsrcCert(certDate);
    }

    // set input paratmeters into the input to the save service
    cres10si.setSzCdRsrcOperBy(cres09so.getSzCdRsrcOperBy());
    cres10si.setSzCdRsrcSetting(cres09so.getSzCdRsrcSetting());
    cres10si.setSzCdRsrcPayment(cres09so.getSzCdRsrcPayment());
    cres10si.setSzCdRsrcCertBy(request.getParameter("szCdRsrcCertBy"));
    cres10si.setTxtSpecCert(request.getParameter("txtSpecCert"));
    cres10si.setUlIdResource(GlobalData.getUlIdResource(request));
    if(request.getParameter("ckAvailAfterHrs") != null && !request.getParameter("ckAvailAfterHrs").equals(""))
    {
      cres10si.setBIndAvailableAfterHrs("Y");
    }
    else
    {
      cres10si.setBIndAvailableAfterHrs("N");
    }
    if(request.getParameter("uNbrRsrcFacilCapacity") == null || request.getParameter("uNbrRsrcFacilCapacity").trim().equals(""))
    {
      
      cres10si.setUNbrRsrcFacilCapacity(Integer.parseInt(request.getParameter(null)));
    }
    else
    {
      cres10si.setUNbrRsrcFacilCapacity(Integer.parseInt(request.getParameter("uNbrRsrcFacilCapacity")));
    }
    
    
    Collection prgmLicensureTypesCollection = null;
    
    int prgmLicensureTypesSize = 0;
    try
    {
      prgmLicensureTypesCollection = Lookup.getCategoryCodesCollection(CodesTables.CPGLICTP);
    }
    catch(Exception e)
    {
      // do nothing.
    }
    if(prgmLicensureTypesCollection != null)
    {
      prgmLicensureTypesSize = prgmLicensureTypesCollection.size();
    }
    if(prgmLicensureTypesSize != 0)
    {
      SelectedLicensureTypesArrayIn selectedLicensureTypesArray = new SelectedLicensureTypesArrayIn();
      for(int i=1; i <= prgmLicensureTypesSize; i++)
      {
        String s = request.getParameter("PrgmLicensureTypesCbx_" + i);
        if(s != null && !(s.trim().equals("")))
        {
          selectedLicensureTypesArray.addSzPrgmLicensureType(s);
        }
      }
      cres10si.setSelectedLicensureTypesArrayIn(selectedLicensureTypesArray);
    }
    
    cres10si.setTsLastUpdate(cres09so.getTsLastUpdate());

    // create new instance of the ArchInputStruct to pass the update command
    ArchInputStruct archInputStruct = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // SIR 18351 - update NmRsrcLastUpdate to populate name of last person to update data.
    cres10si.setSzNmRsrcLastUpdate(user.getUserFullName());

    archInputStruct.setSzUserId(user.getUserLogonID());
    archInputStruct.setCReqFuncCd(request.getParameter("cReqFuncCd"));
    cres10si.setArchInputStruct(archInputStruct);

    // convert the Level Of Care array from a ROWCRES07DO_ARRAY to CRES10SIG01_ARRAY
    CRES10SIG01_ARRAY newLOCArray = convertArray(context, cres09so.getROWCRES07DO_ARRAY(),
                                                 GlobalData.getUlIdResourceAsString(request));
    cres10si.setCRES10SIG01_ARRAY(newLOCArray);
    // call the save service
    try {
      resource.saveFacilityDetail(cres10si);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH), "/resource/Facility/",
                        request);
        break;
      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(we.getErrorMessage(), "/resource/Facility/", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (Exception e) {
      // Handle all possible errors
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      processSevereException(context, e);
    }
    request.setAttribute(this.GRNDS_QNAME_ATTRIBUTE, null);
  }

  /**
   * This method is called by the GRNDS controller when the user requests to add a Level of Care to a Facility
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  public void addLOC_xa(GrndsExchangeContext context) {
    // LOC Enhancement - This method will now be called to set Page
    // mode appropriately.
    HttpServletRequest request = context.getRequest();
    PageMode.setPageMode(PageModeConstants.NEW, request);
  }

  /**
   * This method is called by the GRNDS controller when the user requests to modify the Level of Care for a Facility
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  public void modifyLOC_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    // LOC Enhancement - Only reset pagemode if we are not already in new mode.
    if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
      PageMode.setPageMode(GlobalData.getAppMode(request), request);
    }

  }

  /**
   * This method is called by the GRNDS controller when the user requests to save the Level of Care for a Facility
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  public void saveLOC_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".saveLOC_xa");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // get the cres09so object from hidden field state
      CRES09SO cres09so = (CRES09SO) state.getAttribute("cres09so", request);

      // create new instance of the save input
      CRES10SI cres10si = new CRES10SI();

      // copy the facility detail information from the hidden field state object
      cres10si.setDtDtRsrcCert(cres09so.getDtDtRsrcCert());
      cres10si.setDtDtRsrcClose(cres09so.getDtDtRsrcClose());
      cres10si.setSzCdRsrcOperBy(cres09so.getSzCdRsrcOperBy());
      cres10si.setSzCdRsrcSetting(cres09so.getSzCdRsrcSetting());
      cres10si.setSzCdRsrcPayment(cres09so.getSzCdRsrcPayment());
      cres10si.setSzCdRsrcCertBy(cres09so.getSzCdRsrcCertBy());
      cres10si.setTxtSpecCert(cres09so.getTxtSpecCert());
      cres10si.setUlIdResource(GlobalData.getUlIdResource(request));
      cres10si.setUNbrRsrcFacilCapacity(cres09so.getUNbrRsrcFacilCapacity());
      cres10si.setTsLastUpdate(cres09so.getTsLastUpdate());

      // create a new instance of ArchInputStruct to pass in the update code
      ArchInputStruct archInputStruct = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      // SIR 18351 - update NmRsrcLastUpdate to populate name of last person to update data.
      cres10si.setSzNmRsrcLastUpdate(user.getUserFullName());

      archInputStruct.setSzUserId(user.getUserLogonID());
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      cres10si.setArchInputStruct(archInputStruct);

      // convert the Level Of Care array from a ROWCRES07DO_ARRAY to CRES10SIG01_ARRAY
      CRES10SIG01_ARRAY newLOCArray = convertArray(context, cres09so.getROWCRES07DO_ARRAY(),
                                                   GlobalData.getUlIdResourceAsString(request));

      // LOC Enhancement - if the page mode is new, call the newLOCRow method to add a new Level of Care
      // to the Level of Care history; otherwise, call the updateLOCRow method to update a Level
      // of Care
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
        CRES10SIG01_ARRAY newLOCRowArray = newLOCRow(context, newLOCArray);
        cres10si.setCRES10SIG01_ARRAY(newLOCRowArray);
      } else {
        CRES10SIG01_ARRAY updatedLOCArray = updateLOCRow(context, newLOCArray);
        cres10si.setCRES10SIG01_ARRAY(updatedLOCArray);
      }

      resource.saveFacilityDetail(cres10si);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH), "/resource/Facility/",
                        request);
        break;
      case Messages.MSG_CMN_UPDATE_FAILED:
        setErrorMessage(we.getErrorMessage(), "/resource/Facility/", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (Exception e) {
      // Handle all possible errors
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      processSevereException(context, e);
    }
    request.setAttribute(this.GRNDS_QNAME_ATTRIBUTE, null);
    GrndsTrace.exitScope();
  }

  /** This method calls a Tuxedo service to get the facilityDetail */
  protected CRES09SO findFacility(GrndsExchangeContext context, String id) throws Exception {
    CRES09SI cres09si = new CRES09SI();
    cres09si.setUlIdResource(Integer.parseInt(id));
    return retrieveFacilityDetail.retrieveFacilityDetail( cres09si);
  }

  /** This method calls a Tuxedo service to get the homesList */
  protected CRES02SO homeList(GrndsExchangeContext context, String id) throws Exception {
    CRES02SI cres02si = new CRES02SI();
    CRES02SO cres02so = null;
    try {
      HttpServletRequest request = context.getRequest();
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      // SIR 18413 SPB - Changed results per page to 100 per page ( same as CAPS )
      DatabaseResultDetails databaseResultDetails = tuxPagination.getResultDetails();
      databaseResultDetails.setResultsPerPage(RESULTS_PER_PAGE);

      cres02si.setUlIdResource(Integer.parseInt(id));
      cres02si.setSzCdRsrcLinkType("02");


      ArchInputStruct input = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      input.setSzUserId(user.getUserLogonID());
      input.setUlPageSizeNbr(databaseResultDetails.getResultsPerPage());
      input.setUsPageNbr(databaseResultDetails.getRequestedPage());

      cres02si.setArchInputStruct(input);

      // We are going to catch this with an internal try-catch b/c it is an "OK" error to recieve
      // The homes list section ONLY displays for one type of resource, if the resource
      // has no homes in it, it will display no rows returned if the cres02so object is null
    //  try {
        // cres02so = CRES02SO.unmarshal(new StringReader(WtcHelper.callService("CRES02S", cres02si)));
        // CCON15SO ccon15so =resource.retreiveSubcontractorList();
        // FIXME- Amit -cres02so is not implemented(retreiveSubcontractorList);

      // tuxPagination.setPaginationInformation(cres02so.getArchOutputStruct(), cres02so.getCRES02SOG01_ARRAY().getUlRowQty());
                                                                                       

     // } catch (ServiceException we) {
       // int errorCode = we.getErrorCode();
        //switch (errorCode) {
        //case Messages.MSG_NO_ROWS_RETURNED:
          //break;
        //default:
          //throw we;
       // }
      //}
      //request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_ROWS_RETURNED:
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    }
    return cres02so;
  }

  /**
   * This method coverts the ROWCRES07DO_ARRAY to a CRES10SIG01_ARRAY
   * 
   * @param context
   * @param locArray
   * @param idResource
   * @return CRES10SIG01_ARRAY
   */
  protected static CRES10SIG01_ARRAY convertArray(GrndsExchangeContext context, ROWCRES07DO_ARRAY locArray,
                                                  String idResource) {

    CRES10SIG01_ARRAY inputArray = new CRES10SIG01_ARRAY();

    int i = 0;
    for (Enumeration e = locArray.enumerateROWCRES07DO(); e.hasMoreElements();) {
      ROWCRES07DO locRow = (ROWCRES07DO) e.nextElement();
      CRES10SIG01 inputRow = new CRES10SIG01();

      // set the locRow information into the new inputRow structure
      inputRow.setCCdFlocStatus1(locRow.getCCdFlocStatus1());
      inputRow.setCCdFlocStatus2(locRow.getCCdFlocStatus2());
      inputRow.setCCdFlocStatus3(locRow.getCCdFlocStatus3());
      inputRow.setCCdFlocStatus4(locRow.getCCdFlocStatus4());
      inputRow.setCCdFlocStatus5(locRow.getCCdFlocStatus5());
      inputRow.setCCdFlocStatus6(locRow.getCCdFlocStatus6());
      inputRow.setCCdFlocStatus7(locRow.getCCdFlocStatus7());
      inputRow.setCCdFlocStatus8(locRow.getCCdFlocStatus8());
      inputRow.setCCdFlocStatus9(locRow.getCCdFlocStatus9());
      inputRow.setCCdFlocStatus10(locRow.getCCdFlocStatus10());
      inputRow.setCCdFlocStatus11(locRow.getCCdFlocStatus11());
      inputRow.setCCdFlocStatus12(locRow.getCCdFlocStatus12());
      inputRow.setCCdFlocStatus13(locRow.getCCdFlocStatus13());
      inputRow.setCCdFlocStatus14(locRow.getCCdFlocStatus14());
      inputRow.setCCdFlocStatus15(locRow.getCCdFlocStatus15());

      inputRow.setDtDtFlocEffect(locRow.getDtDtFlocEffect());
      inputRow.setDtDtFlocEnd(locRow.getDtDtFlocEnd());
      inputRow.setSNbrFlocLevelsOfCare(locRow.getSNbrFlocLevelsOfCare());
      inputRow.setTsLastUpdate(locRow.getTsLastUpdate());
      inputRow.setUlIdFloc(locRow.getUlIdFloc());
      inputRow.setUlIdResource(Integer.parseInt(idResource));
      // set the data action to update for each Level of Care
      inputRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      // add the inputRow to the Level of Care array
      inputArray.addCRES10SIG01(inputRow);

      i++;
    }

    return inputArray;
  }

  protected static CRES10SIG01_ARRAY updateLOCRow(GrndsExchangeContext context, CRES10SIG01_ARRAY locArray) {

    HttpServletRequest request = context.getRequest();

    // get the rownumber of the Level of Care to be updated
    int rownum = Integer.parseInt(request.getParameter("rownum"));
    // removing this logic.
    //org.exolab.castor.types.Date changeDate = DateHelper.toCastorDateSafe("09/01/2003");

    // get the specified row from the Level of Care array
    CRES10SIG01 locRow = locArray.getCRES10SIG01(rownum);

    // get the Level of Care status from the levelOfCare.jsp
    CRES10SIG01 inputRow = new CRES10SIG01();
    String one = ContextHelper.getStringSafe(request, "radio1");
    String two = ContextHelper.getStringSafe(request, "radio2");
    String three = ContextHelper.getStringSafe(request, "radio3");
    String four = ContextHelper.getStringSafe(request, "radio4");
    String five = ContextHelper.getStringSafe(request, "radio5");
    String six = ContextHelper.getStringSafe(request, "radio6");
    String seven = ContextHelper.getStringSafe(request, "radioA");
    //String seven = ContextHelper.getStringSafe(request, "radioE2");
    String eight = ContextHelper.getStringSafe(request, "radioE3");
    String nine = ContextHelper.getStringSafe(request, "radio3N");

    // LOC Enhancement -- Also get New codes out of the context if they are available
    String bas = ContextHelper.getStringSafe(request, "radioB");
    String mod = ContextHelper.getStringSafe(request, "radioM");
    String spec = ContextHelper.getStringSafe(request, "radioS");
    String ints = ContextHelper.getStringSafe(request, "radioI");

    // if the status is NA, set it to a blank string
    if ("NA".equals(one) || "NA".equals(bas)) {
      one = "";
      bas = "";
    }
    if ("NA".equals(two) || "NA".equals(bas)) {
      two = "";
      bas = "";
    }
    if ("NA".equals(three) || "NA".equals(mod)) {
      three = "";
      mod = "";
    }
    if ("NA".equals(four) || "NA".equals(mod)) {
      four = "";
      mod = "";
    }
    if ("NA".equals(five) || "NA".equals(spec)) {
      five = "";
      spec = "";
    }
    if ("NA".equals(six) || "NA".equals(ints)) {
      six = "";
      ints = "";
    }
    if ("NA".equals(seven)) {
      seven = "";
    }
    if ("NA".equals(eight)) {
      eight = "";
    }
    if ("NA".equals(nine)) {
      nine = "";
    }

    // set the Level of Care information into the inputRow
    // LOC Enhancement - If the date is before the change date, set the old
    // Radio values into the input Row, otherwise set the new ones.
    
    // removing this logic.
    //if (DateHelper.isBefore(locRow.getDtDtFlocEffect(), changeDate)) {
      inputRow.setCCdFlocStatus1(one);
      inputRow.setCCdFlocStatus2(two);
      inputRow.setCCdFlocStatus3(three);
      inputRow.setCCdFlocStatus4(four);
      inputRow.setCCdFlocStatus5(five);
      inputRow.setCCdFlocStatus6(six);

    //} else {
    //  inputRow.setCCdFlocStatus1(bas);
    //  inputRow.setCCdFlocStatus2(bas);
    //  inputRow.setCCdFlocStatus3(mod);
    //  inputRow.setCCdFlocStatus4(mod);
    //  inputRow.setCCdFlocStatus5(spec);
    //  inputRow.setCCdFlocStatus6(ints);
    //}

    inputRow.setCCdFlocStatus7(seven);
    inputRow.setCCdFlocStatus8(eight);
    inputRow.setCCdFlocStatus9(nine);
    inputRow.setCCdFlocStatus10(locRow.getCCdFlocStatus10());
    inputRow.setCCdFlocStatus11(locRow.getCCdFlocStatus11());
    inputRow.setCCdFlocStatus12(locRow.getCCdFlocStatus12());
    inputRow.setCCdFlocStatus13(locRow.getCCdFlocStatus13());
    inputRow.setCCdFlocStatus14(locRow.getCCdFlocStatus14());
    inputRow.setCCdFlocStatus15(locRow.getCCdFlocStatus15());

    inputRow.setDtDtFlocEnd(locRow.getDtDtFlocEnd());
    inputRow.setSNbrFlocLevelsOfCare(locRow.getSNbrFlocLevelsOfCare());
    inputRow.setTsLastUpdate(locRow.getTsLastUpdate());
    inputRow.setUlIdFloc(locRow.getUlIdFloc());
    inputRow.setUlIdResource(GlobalData.getUlIdResource(request));
    inputRow.setDtDtFlocEffect(locRow.getDtDtFlocEffect());
    inputRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);

    // update the row in the array with the new Level of Care information
    locArray.setCRES10SIG01(rownum, inputRow);

    return locArray;
  }

  protected static CRES10SIG01_ARRAY newLOCRow(GrndsExchangeContext context, CRES10SIG01_ARRAY locArray) {
    HttpServletRequest request = context.getRequest();
    CRES10SIG01 rowToEndDate = null;

    org.exolab.castor.types.Date effectiveDate = ContextHelper.getCastorDateSafe(request, "rdatReceiveDate");

    // if this is not the initial Level of Care entry for the Facility, set the row to endate to be the newest row
    if (locArray.getCRES10SIG01Count() > 0) {
      rowToEndDate = locArray.getCRES10SIG01(0);
    }
    // get the Level of Care status from the levelOfCare.jsp
    CRES10SIG01 inputRow = new CRES10SIG01();
    String one = ContextHelper.getStringSafe(request, "radio1");
    String two = ContextHelper.getStringSafe(request, "radio2");
    String three = ContextHelper.getStringSafe(request, "radio3");
    String four = ContextHelper.getStringSafe(request, "radio4");
    String five = ContextHelper.getStringSafe(request, "radio5");
    String six = ContextHelper.getStringSafe(request, "radio6");
    String seven = ContextHelper.getStringSafe(request, "radioA");
    //String seven = ContextHelper.getStringSafe(request, "radioE2");
    String eight = ContextHelper.getStringSafe(request, "radioE3");
    String nine = ContextHelper.getStringSafe(request, "radio3N");

    // LOC Enhancement -- Also get New codes out of the context if they are available
    String bas = ContextHelper.getStringSafe(request, "radioB");
    String mod = ContextHelper.getStringSafe(request, "radioM");
    String spec = ContextHelper.getStringSafe(request, "radioS");
    String ints = ContextHelper.getStringSafe(request, "radioI");

    // if the status is NA, set it to a blank string
    if ("NA".equals(one) || "NA".equals(bas)) {
      one = "";
      bas = "";
    }
    if ("NA".equals(two) || "NA".equals(bas)) {
      two = "";
      bas = "";
    }
    if ("NA".equals(three) || "NA".equals(mod)) {
      three = "";
      mod = "";
    }
    if ("NA".equals(four) || "NA".equals(mod)) {
      four = "";
      mod = "";
    }
    if ("NA".equals(five) || "NA".equals(spec)) {
      five = "";
      spec = "";
    }
    if ("NA".equals(six) || "NA".equals(ints)) {
      six = "";
      ints = "";
    }
    if ("NA".equals(seven)) {
      seven = "";
    }
    if ("NA".equals(eight)) {
      eight = "";
    }
    if ("NA".equals(nine)) {
      nine = "";
    }

    // get the number of Active Levels of Care to be the SNbrFlocLevelsOfCare
    int i = 0;
    if ("A".equals(one) || "A".equals(bas)) {
      i++;
    }
    if ("A".equals(two) || "A".equals(bas)) {
      i++;
    }
    if ("A".equals(three) || "A".equals(mod)) {
      i++;
    }
    if ("A".equals(four) || "A".equals(mod)) {
      i++;
    }
    if ("A".equals(five) || "A".equals(spec)) {
      i++;
    }
    if ("A".equals(six) || "A".equals(ints)) {
      i++;
    }
    if ("A".equals(seven)) {
      i++;
    }
    if ("A".equals(eight)) {
      i++;
    }
    if ("A".equals(nine)) {
      i++;
    }

    // set the Level of Care information into the inputRow
    // LOC Enhancement - If the date is before the change date, set the old
    // Radio values into the input Row, otherwise set the new ones.
    // removing this logic.
    //if (DateHelper.isBefore(effectiveDate, changeDate)) {
      inputRow.setCCdFlocStatus1(one);
      inputRow.setCCdFlocStatus2(two);
      inputRow.setCCdFlocStatus3(three);
      inputRow.setCCdFlocStatus4(four);
      inputRow.setCCdFlocStatus5(five);
      inputRow.setCCdFlocStatus6(six);
    //} else {
    //  inputRow.setCCdFlocStatus1(bas);
    //  inputRow.setCCdFlocStatus2(bas);
    //  inputRow.setCCdFlocStatus3(mod);
    //  inputRow.setCCdFlocStatus4(mod);
    //  inputRow.setCCdFlocStatus5(spec);
    //  inputRow.setCCdFlocStatus6(ints);

    //}

    inputRow.setCCdFlocStatus7(seven);
    inputRow.setCCdFlocStatus8(eight);
    inputRow.setCCdFlocStatus9(nine);
    inputRow.setCCdFlocStatus10("");
    inputRow.setCCdFlocStatus11("");
    inputRow.setCCdFlocStatus12("");
    inputRow.setCCdFlocStatus13("");
    inputRow.setCCdFlocStatus14("");
    inputRow.setCCdFlocStatus15("");

    inputRow.setSNbrFlocLevelsOfCare(i);
    inputRow.setUlIdFloc(0);
    inputRow.setUlIdResource(GlobalData.getUlIdResource(request));

    // if the effective date is not null, get it from the request
    String newLocEffDt = null;

    // If there is an old row end date it to one days prior to the new effective date
    try {
      Date effDate = new Date();

      // set the effective date into the new Level of Care row
      inputRow.setDtDtFlocEffect(effectiveDate);

      gov.georgia.dhr.dfcs.sacwis.core.utility.Date newEndDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();

      newEndDate = gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility
                                                                       .validateAsDate(DateHelper
                                                                                                 .toString(
                                                                                                           effectiveDate,
                                                                                                           DateHelper.SLASH_FORMAT));

      // set the endate for the row to end date to one day prior to the new effective date
      newEndDate.addDays(-1);
      java.util.Date endDate = newEndDate.getTime();
      if (rowToEndDate != null) {
        rowToEndDate.setDtDtFlocEnd(new org.exolab.castor.types.Date(endDate));
      }
      // set the end date for the new row to the latest date allowed by CAPS
      org.exolab.castor.types.Date utilDate2 = effDate.convertDate("12/31/4712");

      inputRow.setDtDtFlocEnd(utilDate2);

    } catch (DateAndTimeException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Date and Time Exception:" + e.getMessage());
    }

    // if this is not the initial entry, add the row to end date to the Level of Care array
    if (locArray.getCRES10SIG01Count() > 0) {
      locArray.setCRES10SIG01(0, rowToEndDate);
    }
    // set the action of the new Level of Care row to Add
    inputRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    // add the new Level of Care row to the Array
    locArray.addCRES10SIG01(inputRow);

    GrndsTrace.exitScope();

    return locArray;
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
}
