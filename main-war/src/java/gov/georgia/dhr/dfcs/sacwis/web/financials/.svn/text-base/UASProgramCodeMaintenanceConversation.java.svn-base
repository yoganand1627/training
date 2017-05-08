/**
 * Name: ProgramCodeMaintenanceConversation
 * Description : This is the conversation class for the page UAS Program Code Maintenance.
 * <p/>
 * <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  09/02/11  htvo      STGAP00017019: ECEM 5.0: UAS Program Code Maintenance - new page development
 *  10/20/11  htvo      STGAP00017324: fixed invalid date format
 *  11/14/11  htvo      STGAP00017672: displays message to inform user when a header already exists, all at once, and 
 *                      allow reuse of the existing header if user presses Save again.
 * </pre>
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UASProgramCodeMtntRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UASProgramCodeMtntSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASEntitlementCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeListRow;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class UASProgramCodeMaintenanceConversation extends BaseHiddenFieldStateConversation {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  // Page state values
  // This state allows program and entitlement codes to be added. New program code should always be added with
  // entitlement codes
  public final static String ADD_UAS = "ADD_UAS";

  // This state allows new entitlement codes to be added; program code section should be disabled
  public final static String ADD_ENT = "ADD_ENT";

  public final static String UPDATE = "UPDATE";

  public final static String PAGE_STATE = "PAGE_STATE";
  
  public static final String SORT_BY_CODE = "C";

  public static final String SORT_BY_EFFECTIVE_DATE = "D";
  
  private static final String UAS_MTNT_DETAIL_URL = "/financials/UASProgramCodeMaintenance/displayUASProgramCodeMaintenance";

  // this value group (9) should be in sync with Save service
  private final static String CCI = "CCI";

  private final static String CPA = "CPA";

  private final static String PSSF = "PSSF";
  
  private static final String FC_ADD_ON = "FC_ADD_ON";
  
  private static final String SVC_AUTH = "SVC_AUTH";
  
  private static final String MILEAGE = "MILEAGE";
  
  private static final String REL = "REL_CARE";
  
  private static final String CBL = "CASE_BUDGET_LIMIT";
  
  private static final String LIL = "LINE_ITEM_LIMIT";
  
  private static final String HEADER = "ENT_HEADER";
  
  private static final String EQUIVALENCY = "EQUIVALENCY";
 
  private Financials financials;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }
  /**
   * This method sorts the list section by code or effective date, both in ascending order.
   * @param context
   */
  public void sortUasProgramCodeList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".sortUasProgramCodeList_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    String pageState = (String) state.getAttribute(PAGE_STATE, request);  
    String pageMode = PageMode.getPageMode(request);
    UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state.getAttribute("UASPrgCodeMtntRetrieveSO",request);
    String hdnSortOrderBy = ContextHelper.getStringSafe(request, "hdnSortOrderBy"); 
    if (SORT_BY_EFFECTIVE_DATE.equals(hdnSortOrderBy)) {
      sortProgramCodeListByEffDate(uasPrgCodeMtntRetrieveSO.getPrgCodeList());
    } else if (SORT_BY_CODE.equals(hdnSortOrderBy)) {
      sortProgramCodeListByCode(uasPrgCodeMtntRetrieveSO.getPrgCodeList());
    }
    // re-set necessary attributes back to state after sort
    state.setAttribute("UASPrgCodeMtntRetrieveSO", uasPrgCodeMtntRetrieveSO, request);
    state.setAttribute(PAGE_STATE, pageState, request);
    PageMode.setPageMode(pageMode, request);
    performanceTrace.exitScope();
  }
  /**
   * addUASProgramCode_xa Method
   * <p/>
   * This method is called by the GRNDS controller when the user clicks on the Program Code Maintenance second level tab.
   * @param context
   */
  public void addUASProgramCode_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addUASProgramCode_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // get state data first
    UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state.getAttribute("UASPrgCodeMtntRetrieveSO",request);
    String hdnAddProgramCodeMode = ContextHelper.getStringSafe(request, "hdnAddProgramCodeMode"); 

    if (StringHelper.isTrue(hdnAddProgramCodeMode)) {
      // Add Program Code was clicked, don't need to retrieve, 
      // all other modes always retrieves list data, just clear detail data
      uasPrgCodeMtntRetrieveSO.setPrgCodeDetail(null);
    } else {
      // // Tab was clicked
      UASProgramCodeMtntRetrieveSI uasProgramCodeMtntRetrieveSI = new UASProgramCodeMtntRetrieveSI();
      uasPrgCodeMtntRetrieveSO = financials.retrieveUASProgramCodeMtnt(uasProgramCodeMtntRetrieveSI);
      state.removeAllAttributes(request);
      state.setAttribute("UASPrgCodeMtntRetrieveSO", uasPrgCodeMtntRetrieveSO, request);
    } 

    // set page state to differentiate between add program code, add ent code, or view/modify existing program/ent code options
    state.setAttribute(PAGE_STATE, ADD_UAS, request);
    // set page mode for use in common activities between add ent code and view/modify existing program/ent code
    // only add new prog code gets page mode NEW
    PageMode.setPageMode(PageModeConstants.NEW, request);
    performanceTrace.exitScope();
  }

  /**
   * addEntitlementCode_xa Method
   * <p/>
   * This method is called by the GRNDS controller when the user clicks the Add Entitlement Code button from the Entitlement Code section.
   * @param context
   */
  public void addEntitlementCode_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addEntitlementCode_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state.getAttribute("UASPrgCodeMtntRetrieveSO",request);
    // clear existing entitlement code to display blank rows for new entitlement code entry
    if (uasPrgCodeMtntRetrieveSO != null && uasPrgCodeMtntRetrieveSO.getPrgCodeDetail() != null) {
      uasPrgCodeMtntRetrieveSO.getPrgCodeDetail().setEntCodeList(new ArrayList<UASEntitlementCodeDetail>());
    }

    state.setAttribute(PAGE_STATE, ADD_ENT, request);
    PageMode.setPageMode(PageModeConstants.MODIFY, request);
    performanceTrace.exitScope();
  }

  /**
   * displayUASProgramCodeMaintenance_xa Method
   * <p/>
   * This method is called by the GRNDS controller when the user clicks the Program Code hyperlink on the UAS Program Code List.
   * @param context: Context for the request
   */
  public void displayUASProgramCodeMaintenance_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayUASProgramCodeMaintenance_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PageMode.setPageMode(PageModeConstants.MODIFY, request);
    // STGAP00017672: when click HL or come back after successful Save
    // clear existing header override and set correct page state
     UASProgramCodeMtntSaveSO uasPrgCodeMtntSaveSO = (UASProgramCodeMtntSaveSO) state.getAttribute("uasPrgCodeMtntSaveSO",request);

    String hdnHyperlinkClicked = ContextHelper.getStringSafe(request, "hdnHyperlinkClicked"); 
    if (StringHelper.isTrue(hdnHyperlinkClicked) || (uasPrgCodeMtntSaveSO != null && uasPrgCodeMtntSaveSO.isNoError())) {
      state.removeAttribute("IndHeaderReuse",request);
      state.setAttribute(PAGE_STATE, UPDATE, request);
    } 
    try {
      UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = new UASProgramCodeMtntRetrieveSO();
      UASProgramCodeMtntRetrieveSI uasProgramCodeMtntRetrieveSI = populateRetrieveSI(context);
      uasPrgCodeMtntRetrieveSO = financials.retrieveUASProgramCodeMtnt(uasProgramCodeMtntRetrieveSI);
      state.setAttribute("UASPrgCodeMtntRetrieveSO", uasPrgCodeMtntRetrieveSO, request);
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + we.getMessage());
      setErrorMessage(we.getMessage(), UAS_MTNT_DETAIL_URL, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user clicks the Save button. This populates
   * the SaveSI object and passes to the Save service.
   * @param context
   */
  public void saveUASProgramCodeMaintenance_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveUASProgramCodeMaintenance_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      UASProgramCodeMtntSaveSO uasPrgCodeMtntSaveSO = new UASProgramCodeMtntSaveSO();
      UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI = populateSaveSI(context);
      // STGAP00017672: whether existing header message has been display, yes, set override = Y
      // to bypass the check
      String indHeaderReuse = (String) state.getAttribute("IndHeaderReuse", request);
      if (ArchitectureConstants.Y.equals(indHeaderReuse)) {
        uasProgramCodeMtntSaveSI.setIndHeaderReuse(ArchitectureConstants.Y);
      } // 
      uasPrgCodeMtntSaveSO = financials.saveUASProgramCodeMtnt(uasProgramCodeMtntSaveSI);
      state.setAttribute("uasPrgCodeMtntSaveSO", uasPrgCodeMtntSaveSO, request);
      // STGAP00017672: set error message to request if header is found existing the first time
      List<Map<String,Object>> headerInDBList = uasPrgCodeMtntSaveSO.getHeaderInDBList();
      if (headerInDBList != null && headerInDBList.size() > 0) {
        for (Map<String,Object> headerInfor : headerInDBList) {
          String ent = (String) headerInfor.get("headerEntCode");
          String desc = (String) headerInfor.get("headerDesc");
          List<String> progs = (List) headerInfor.get("headerProgs");
          String errorMsg = "The header entitlement code '" + ent + 
          		"' already exists with description '" + desc +
          		"' for the following program codes: "  + progs.toString() + ". Press Save to add entitlement code '" + ent + "' as a header for the current program code, which will update it to contain this description.";
          setErrorMessage(errorMsg, request);
        }
        // reset indicator so next save will not be caught by the existing header check
        state.setAttribute("IndHeaderReuse", ArchitectureConstants.Y, request);
        GrndsTrace.msg(TRACE_TAG, 7, "Confirm header re-use...");
        performanceTrace.exitScope();
        return;
      }
      // Save completes normally, page will display in Modify page mode and Update page state
      state.setAttribute(PAGE_STATE, UPDATE, request);
    } catch (NullPointerException npe) { 
      GrndsTrace.msg(TRACE_TAG, 7, "populate save: " + npe.getMessage());
      setPresentationBranch("error", context);
      setErrorMessage(npe.getMessage(), request);
    }
    catch (PopulationException pe) {
      GrndsTrace.msg(TRACE_TAG, 7, "populate save: " + pe.getMessage());
      setPresentationBranch("error", context);
      setErrorMessage(pe.getMessage(), request);
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "service save: " + we.getMessage());
      setPresentationBranch("error", context);
      setErrorMessage(we.getMessage(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method sets the page mode based on the business page states, populates program code request data, and 
   * calls validate helper method to populates entitlement codes. 
   * data and instruction for save service.
   * @param context
   * @return
   * @throws PopulationException
   */
  private UASProgramCodeMtntSaveSI populateSaveSI(GrndsExchangeContext context) throws PopulationException  {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idUasPrgCodeMtnt = ContextHelper.getIntSafe(request, "hdnUlIdUasProgramCodeMtnt");
    String pageState = (String) state.getAttribute(PAGE_STATE, request);  //ContextHelper.getStringSafe(request, PAGE_STATE);
    String pageMode = PageMode.getPageMode(request);
    UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state.getAttribute("UASPrgCodeMtntRetrieveSO",
                                                                                                              request);

    UASProgramCodeDetail uasProgramCodeDetail = new UASProgramCodeDetail();
    UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI = new UASProgramCodeMtntSaveSI();
    uasProgramCodeMtntSaveSI.setPageState(pageState);
    if (PageModeConstants.NEW.equals(pageMode)) {
      uasProgramCodeMtntSaveSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_ADD);
    } else if (PageModeConstants.MODIFY.equals(pageMode)) {
      uasProgramCodeMtntSaveSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_UPDATE);
      if (uasPrgCodeMtntRetrieveSO != null) {
        uasProgramCodeMtntSaveSI.setPrevPrgCodeDetail(uasPrgCodeMtntRetrieveSO.getPrgCodeDetail());
      } else {
        // probably state data is corrupted; throw this so that user would try to re-enter the page and 
        throw new PopulationException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH));
      }
    } else {
      uasProgramCodeMtntSaveSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    }

    // If user is adding new Entitlement codes, the UAS Program code section should be disabled, only need to
    // save the Entitlement codes and re-save to update last update of the program code
    if (ADD_ENT.equals(pageState)) {
      if (uasPrgCodeMtntRetrieveSO != null) {
        uasProgramCodeDetail = uasPrgCodeMtntRetrieveSO.getPrgCodeDetail();
        // should always have prog code detail 
        if (uasProgramCodeDetail != null && uasProgramCodeDetail.getIdUasPrgCode() != 0) {
          //uasProgramCodeMtntSaveSI.setPrgCodeDetail(uasProgramCodeDetail);
          // only copy the program code detail, ent list will be blank
          uasProgramCodeMtntSaveSI.setPrgCodeDetail(new UASProgramCodeDetail(uasProgramCodeDetail, "PROGRAM_DETAIL"));
        } else {
          // probably state data is corrupted; throw this so that user would try to re-enter the page and 
          throw new PopulationException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH));
        }
      }
    } else { // Add UAS or update
      // Use Castor first to retain value for no-slash date string
      Date dtProgramEffective = DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request, "txtDtDtProgEff"));
      Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, "hdnDtLastUpdateUasProgCodeDetail"); 
      String cdProgramCode = ContextHelper.getStringSafe(request, "txtSzCdProgCode");
      String txtProgramDesc = ContextHelper.getStringSafe(request, "txtSzTxtProgDesc");
      String cdProgramType = ContextHelper.getStringSafe(request, "selSzCdProgType");
      String indCCI = ContextHelper.getStringSafe(request, "rbCCI");
      String indCPA = ContextHelper.getStringSafe(request, "rbCPA");
      String indServAuth = ContextHelper.getStringSafe(request, "rbServAuth");
      String indPSSF = ContextHelper.getStringSafe(request, "rbPSSF");
      String indInvAddOn = ContextHelper.getStringSafe(request, "rbInvAddOn");

      uasProgramCodeDetail.setCdProgramCode(cdProgramCode);
      uasProgramCodeDetail.setCdProgramType(cdProgramType);
      // STGAP00017324: catch null and throw error message b/c effective is a required column
      if (DateHelper.isNull(dtProgramEffective)) {
        throw new ServiceException(Messages.MSG_ARC_CONSTR_DATE2);
      }
      uasProgramCodeDetail.setDtProgramEffective(dtProgramEffective);

      uasProgramCodeDetail.setIdUasPrgCode(idUasPrgCodeMtnt);
      uasProgramCodeDetail.setDtLastUpdatedBy(dtLastUpdate);
      uasProgramCodeDetail.setTxtProgramDesc(txtProgramDesc);
      uasProgramCodeDetail.setIndCCI(indCCI);
      uasProgramCodeDetail.setIndCPA(indCPA);
      uasProgramCodeDetail.setIndInvAddOn(indInvAddOn);
      uasProgramCodeDetail.setIndPSSF(indPSSF);
      uasProgramCodeDetail.setIndServiceAuth(indServAuth);

      uasProgramCodeMtntSaveSI.setPrgCodeDetail(uasProgramCodeDetail);
    }

    int idPersonLastUpdate = user.getUserID();
    String nmPersonLastUpdate = user.getUserFullName();
    uasProgramCodeMtntSaveSI.getPrgCodeDetail().setIdPersonLastUpdate(idPersonLastUpdate);
    uasProgramCodeMtntSaveSI.getPrgCodeDetail().setNmPersonLastUpdate(nmPersonLastUpdate);

    // Get ENT array
    List<UASEntitlementCodeDetail> entCodeListToSave = populateEntSaveSI(context, uasProgramCodeMtntSaveSI);
    uasProgramCodeMtntSaveSI.getPrgCodeDetail().setEntCodeList(entCodeListToSave);
    
    state.setAttribute(PAGE_STATE, pageState, request);
    return uasProgramCodeMtntSaveSI;

  }
  
  /**
   * Called by populateSaveSI(). This method populates and validates entitlement code from request, determine subprogram save mode.
   * @param context
   * @param pageState
   * @return null if invalid call; otherwise List<UASEntitlementCodeDetail>
   */
  private List<UASEntitlementCodeDetail> populateEntSaveSI (GrndsExchangeContext context, UASProgramCodeMtntSaveSI uasProgramCodeMtntSaveSI) throws PopulationException {
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state.getAttribute("UASPrgCodeMtntRetrieveSO", request);
    
    // 10 if in ADD_UAS or ADD_ENT mode; size of existing ENT list if in UPDATE mode
    int nbrEntCodeToSave = ContextHelper.getIntSafe(request, "hdnNbrDisplayEntCodeRows");
    String cdProgram = ContextHelper.getStringSafe(request, "txtSzCdProgCode");
    String indProgramChanged = ContextHelper.getStringSafe(request, "hdnProgramChanged");
    String pageState = uasProgramCodeMtntSaveSI.getPageState();
    
    List<UASEntitlementCodeDetail> entCodeListToSave = new ArrayList<UASEntitlementCodeDetail>();
    List<UASEntitlementCodeDetail> entCodeListSO = null;
    // Designated/Sub program for each ENT from retrieve (prev list)
    Map<Integer, Map<String, Object>> entCodeSubProgsSO = null;
    UASProgramCodeDetail uasProgramCodeDetail = uasProgramCodeMtntSaveSI.getPrgCodeDetail();
    UASProgramCodeDetail uasProgramCodeDetailSO = null;
    String cdProgramTypeSO = StringHelper.EMPTY_STRING;
    String indSvcAuthSO = StringHelper.EMPTY_STRING;
    String indInvAddonSO = StringHelper.EMPTY_STRING;
    String cdProgramTypeSI = uasProgramCodeDetail.getCdProgramType();
    String indSvcAuthSI = StringHelper.getNonNullString(uasProgramCodeDetail.getIndServiceAuth());
    String indInvAddonSI = StringHelper.getNonNullString(uasProgramCodeDetail.getIndInvAddOn());
    
    if (uasPrgCodeMtntRetrieveSO != null && uasPrgCodeMtntRetrieveSO.getPrgCodeDetail() != null) {
      uasProgramCodeDetailSO = uasPrgCodeMtntRetrieveSO.getPrgCodeDetail();
      cdProgramTypeSO = uasProgramCodeDetailSO.getCdProgramType();
      indSvcAuthSO = StringHelper.getNonNullString(uasProgramCodeDetailSO.getIndServiceAuth());
      indInvAddonSO = StringHelper.getNonNullString(uasProgramCodeDetailSO.getIndInvAddOn());
      entCodeListSO = uasProgramCodeDetailSO.getEntCodeList();
      
      if (entCodeListSO != null) {
        entCodeSubProgsSO = toHashMapList(entCodeListSO);
      }
    }
                                                                                                              
    // Prog code request action data
    String indCCIReq;
    String indCPAreq ;
    String indFcAddonReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION ;
    String indSvcAuthReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION ;
    String indPSSFreq = ServiceConstants.REQ_FUNC_CD_NO_ACTION ;
    String indRelReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION;
    
    if (uasProgramCodeDetailSO == null) {
      // setting action code Add if sub program is indicated or no action
      indCCIReq = ArchitectureConstants.Y.equals(uasProgramCodeDetail.getIndCCI()) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
      indCPAreq = ArchitectureConstants.Y.equals(uasProgramCodeDetail.getIndCPA()) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
      indFcAddonReq = ArchitectureConstants.Y.equals(indInvAddonSI) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
      //indSvcAuthReq = ArchitectureConstants.Y.equals(indSvcAuthSI) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
      indPSSFreq = ArchitectureConstants.Y.equals(uasProgramCodeDetail.getIndPSSF()) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
    } else {
      // setting action code (Add, Delete) by comparing the prev and cur values
      indCCIReq = setCdReqFunc(uasProgramCodeDetailSO.getIndCCI(), uasProgramCodeDetail.getIndCCI());
      indCPAreq = setCdReqFunc(uasProgramCodeDetailSO.getIndCPA(), uasProgramCodeDetail.getIndCPA());
      indFcAddonReq = setCdReqFunc(indInvAddonSO, indInvAddonSI);
      //indSvcAuthReq = setCdReqFunc(indSvcAuthSO, indSvcAuthSI);
      indPSSFreq = setCdReqFunc(uasProgramCodeDetailSO.getIndPSSF(), uasProgramCodeDetail.getIndPSSF());
      // CADDONLI: FC Add-on: Foster care type + Invoice Add-on 
      if (CodesTables.CINVSRTP_FSC.equals(cdProgramTypeSO) && 
                      ArchitectureConstants.Y.equals(indInvAddonSO) && 
                      (!CodesTables.CINVSRTP_FSC.equals(cdProgramTypeSI) || 
                                      !ArchitectureConstants.Y.equals(indInvAddonSI))) {
        indFcAddonReq = ServiceConstants.REQ_FUNC_CD_DELETE;
        // curr is FCS and invoice addon; prev is anything but: Add to CADDONLI
      } else if (CodesTables.CINVSRTP_FSC.equals(cdProgramTypeSI) && 
                      ArchitectureConstants.Y.equals(indInvAddonSI) && 
                      (!CodesTables.CINVSRTP_FSC.equals(cdProgramTypeSO)
                                      || !ArchitectureConstants.Y.equals(indInvAddonSO)) ) {
        indFcAddonReq = ServiceConstants.REQ_FUNC_CD_ADD;
      }
    }
    // UPDATE or ADD_ENT mode, prog code detail and its ENT list exist
    // Still loop all 10 blank rows when in ADD_UAS or ADD_ENT mode because user can enter data on any row 
    for (int i=0; i<nbrEntCodeToSave; i++) {
      UASEntitlementCodeDetail entRowToSave = new UASEntitlementCodeDetail();
      int idEquiv = 0;
      String fieldName = "txtSzEntCode"+i;
      String cdEntCode = request.getParameter(fieldName);
      String indRowChangedField = "hdnIndRowChanged"+i;
      String indRowChanged = request.getParameter(indRowChangedField);
      // Only save actual data ENT rows (in ADD modes) or updated rows (in UPDATE mode)
      // In UPDATE mode, if there is changes at the program level such as code or subprogram selection, all ENT 
      // rows are affected.
      if (StringHelper.isValid(cdEntCode) && (ArchitectureConstants.Y.equals(indRowChanged) || ArchitectureConstants.Y.equals(indProgramChanged))) {
        // this is a valid ENT record or modified rows, get the rest of the row from request, populate ToSave row, and add to ToSave list
        entRowToSave.setCdEntCode(cdEntCode);
        fieldName = "hdnUlIdEntProgramCodeMtnt"+i;
        entRowToSave.setIdEntRow(ContextHelper.getIntSafe(request, fieldName));
        fieldName = "hdnDtLastUpdateEntProgramCodeMtnt"+i; 
        entRowToSave.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, fieldName));
        fieldName = "txtSzTxtEntAlpha"+i;
        entRowToSave.setTxtEntAlpha(ContextHelper.getStringSafe(request, fieldName));
        fieldName = "cbxIndEntHeader" + i;
        entRowToSave.setIndHeader(CheckboxHelper.getCheckboxValue(request, fieldName)); // cbx helper handles null string
        fieldName = "txtSzTxtEntDesc"+i;
        entRowToSave.setTxtEntDesc(ContextHelper.getStringSafe(request, fieldName));
        fieldName = "txtDtDtEntEff"+i;
        // Use Castor first to retain value for no-slash date string
        // STGAP00017324: catch null and throw error message b/c effective is a required column/
        Date dtEntEff = DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request, fieldName));
        if (DateHelper.isNull(dtEntEff)) {
          throw new ServiceException(Messages.MSG_ARC_CONSTR_DATE2);
        }
        entRowToSave.setDtEntEff(dtEntEff); 
        fieldName = "txtAmtEntRate"+i;
        entRowToSave.setAmtRate(ContextHelper.getMoneyAsDoubleSafe(request, fieldName));
        fieldName = "selSzCdEntPymtType"+i;
        entRowToSave.setCdPymtType(ContextHelper.getStringSafe(request, fieldName));
        fieldName = "selSzCdEntUnitType"+i;
        entRowToSave.setCdUnitType(ContextHelper.getStringSafe(request, fieldName));
        fieldName = "cbxIndEntMileage"+i;
        entRowToSave.setIndMileage(CheckboxHelper.getCheckboxValue(request, fieldName));
        // only save CBL on header row and save LIL on non-header row
        if (ArchitectureConstants.Y.equals(entRowToSave.getIndHeader())) {
          fieldName = "txtDAmtEntCBL"+i;
          entRowToSave.setAmtCBL(ContextHelper.getMoneyAsDoubleSafe(request, fieldName));
        } else {
          fieldName = "txtDAmtEntLIL"+i;
          entRowToSave.setAmtLIL(ContextHelper.getMoneyAsDoubleSafe(request, fieldName));
        }
        String svcCode = cdProgram + cdEntCode + entRowToSave.getTxtEntAlpha();
        entRowToSave.setCdSvcCode(svcCode);

        String currIndHeader = StringHelper.getNonNullString(entRowToSave.getIndHeader());
        String prevIndHeader = StringHelper.EMPTY_STRING;
        String currIndMileage = StringHelper.getNonNullString(entRowToSave.getIndMileage());
        boolean isCurrRel = ((ArchitectureConstants.Y.equals(currIndMileage) || CodesTables.CINVSRTP_RCS.equals(cdProgramTypeSI)) && 
                        !ArchitectureConstants.Y.equals(indSvcAuthSI)); 
        boolean isPrevRel = false;

        // set delete indicator for Service Auth, Mileage, PSSF, CCI, CPA, Case Budget Limit
        // Line Item Limit
        
        // ENT request data
        String indCBLReq ;
        String indLILReq ;
        String indMileageReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION ;
        String indHeaderReq;
        Map<String, String> subProgramActionMap = new HashMap<String,String>();
        
        // Sub program values from retrieve
        // New program 
        //if (entCodeSubProgsSO == null || entCodeSubProgsSO.isEmpty()) {
        // New program or new ent
        if (ADD_UAS.equals(pageState) || ADD_ENT.equals(pageState)) {
          indMileageReq = ArchitectureConstants.Y.equals(currIndMileage) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          indCBLReq = entRowToSave.getAmtCBL() > 0.00 ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          indLILReq = entRowToSave.getAmtLIL() > 0.00 ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          indHeaderReq = ArchitectureConstants.Y.equals(currIndHeader) ? ServiceConstants.REQ_FUNC_CD_ADD : ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          if (ArchitectureConstants.Y.equals(indSvcAuthSI) && ArchitectureConstants.Y.equals(entRowToSave.getIndHeader())) {
            indSvcAuthReq = ServiceConstants.REQ_FUNC_CD_ADD;
          } 
          // if mileage or relative care is indicated, and SA not indicated, add to CRELCODE
          if (isCurrRel) {
            indRelReq = ServiceConstants.REQ_FUNC_CD_ADD;
          }
        // Existing record  
        } else {
          int idEntRow = entRowToSave.getIdEntRow();
          // get the previous ENT row values
          Map<String, Object> subProgramValueSO =  (Map<String, Object>) entCodeSubProgsSO.get(idEntRow);
          // get the id of Equivalency table if exist
          idEquiv = subProgramValueSO.get(EQUIVALENCY) == null ? 0 : ((Integer)subProgramValueSO.get(EQUIVALENCY)).intValue();
          // get the previous fields' value
          String prevIndMileage = subProgramValueSO.get(MILEAGE) == null ? StringHelper.EMPTY_STRING : StringHelper.castToString(subProgramValueSO.get(MILEAGE));
          double prevIndCBL = subProgramValueSO.get(CBL) == null ? 0.00 : ((Double)subProgramValueSO.get(CBL)).doubleValue();
          double prevIndLIL = subProgramValueSO.get(LIL) == null ? 0.00 : ((Double)subProgramValueSO.get(LIL)).doubleValue();
          double currIndCBL = entRowToSave.getAmtCBL();
          double currIndLIL = entRowToSave.getAmtLIL();
          
          prevIndHeader = subProgramValueSO.get(HEADER) == null ? StringHelper.EMPTY_STRING : StringHelper.castToString(subProgramValueSO.get(HEADER));
          // recalculate previous subprogram relative care
          isPrevRel = ((ArchitectureConstants.Y.equals(prevIndHeader) || CodesTables.CINVSRTP_RCS.equals(cdProgramTypeSO)) && 
                          !ArchitectureConstants.Y.equals(indSvcAuthSO));
          indCBLReq = setCdReqFunc(prevIndCBL, currIndCBL);
          indLILReq = setCdReqFunc(prevIndLIL, currIndLIL);
          indHeaderReq = setCdReqFunc(prevIndHeader, currIndHeader);
          
          // MILEAGE: prev is mileage w/o SA and curr is not: delete
          if (ArchitectureConstants.N.equals(indSvcAuthSO) && ArchitectureConstants.Y.equals(prevIndMileage) && 
                          (!ArchitectureConstants.N.equals(indSvcAuthSI) || !ArchitectureConstants.Y.equals(currIndMileage)) ) {
            indMileageReq = ServiceConstants.REQ_FUNC_CD_DELETE;
          } 
          // prev is not the combination of mileage not requirin SA, curr is: Add
          else if (!(ArchitectureConstants.N.equals(indSvcAuthSO) && ArchitectureConstants.Y.equals(prevIndMileage)) && 
                          (ArchitectureConstants.N.equals(indSvcAuthSI) && ArchitectureConstants.Y.equals(currIndMileage)) ) {
            indMileageReq = ServiceConstants.REQ_FUNC_CD_ADD;
          } else { // needed to clear prev ENT setting, if any
            indMileageReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          }
          // SA: prev is SA and header checked (SA header correct combination); now is not: delete
          if (ArchitectureConstants.Y.equals(indSvcAuthSO) && ArchitectureConstants.Y.equals(prevIndHeader) && 
                          !(ArchitectureConstants.Y.equals(indSvcAuthSI) && ArchitectureConstants.Y.equals(currIndHeader))) {
            indSvcAuthReq = ServiceConstants.REQ_FUNC_CD_DELETE;
          } 
          // reverse: add
          else if (ArchitectureConstants.Y.equals(indSvcAuthSI) && ArchitectureConstants.Y.equals(currIndHeader) && 
                          !(ArchitectureConstants.Y.equals(indSvcAuthSO) && ArchitectureConstants.Y.equals(prevIndHeader))) {
            indSvcAuthReq = ServiceConstants.REQ_FUNC_CD_ADD;
          } else { // needed to clear prev ENT setting, if any
            indSvcAuthReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          }
          // RELATIVE: set insert and delete for relative care/mileage combination. Codes tables is CRELCODE.
          if (isPrevRel && !isCurrRel) {
            indRelReq = ServiceConstants.REQ_FUNC_CD_DELETE;
           
          } else if (!isPrevRel && isCurrRel) {
            indRelReq = ServiceConstants.REQ_FUNC_CD_ADD;
          } else { // needed to clear prev ENT setting, if any
            indRelReq = ServiceConstants.REQ_FUNC_CD_NO_ACTION;
          }
        }
        
        subProgramActionMap.put(CCI, indCCIReq);
        subProgramActionMap.put(CPA, indCPAreq);
        subProgramActionMap.put(PSSF, indPSSFreq);
        subProgramActionMap.put(SVC_AUTH, indSvcAuthReq);
        subProgramActionMap.put(FC_ADD_ON, indFcAddonReq);
        subProgramActionMap.put(MILEAGE, indMileageReq);
        subProgramActionMap.put(CBL, indCBLReq);
        subProgramActionMap.put(LIL, indLILReq);
        subProgramActionMap.put(REL, indRelReq);
        subProgramActionMap.put(HEADER, indHeaderReq);
           
        entRowToSave.setCdFuncProgs(subProgramActionMap);    
        entRowToSave.setIdEquiv(idEquiv);
        entCodeListToSave.add(entRowToSave);
      } else if (!StringHelper.isValid(cdEntCode)) {
        // disallow a delete by blanking out the row or the required portion of a row
        if (UPDATE.equals(pageState) && entRowToSave.getIdEntRow() > 0) {
          throw new ServiceException(Messages.MSG_REQ_ENT_CD_INFO);
        }
      }
    }
    // New program code must be added with entitlement code(s), or
    // if user selects Add Ent, then new ENT must be entered.
    if ((ADD_UAS.equals(pageState) || ADD_ENT.equals(pageState)) && entCodeListToSave.size() == 0) {
      throw new ServiceException(Messages.MSG_REQ_ENT_CD_INFO);
    }
    return entCodeListToSave;
  }
  /**
   * Helper method to convert an ENT record into a map (column/field, value) for fast value lookup.
   * Contains the list of ENT sub program mileage, case budget limit, and line item limit values for each ENT 
   * @param entList
   * @return 
   * key: id ENT row
   * value: map: sub program name and the indicator or amount that indicates that is whether this service is used for this sub program
   */
  private Map<Integer, Map<String, Object>> toHashMapList(List<UASEntitlementCodeDetail> entList) {
    Map<Integer, Map<String, Object>> entMapList = new HashMap<Integer, Map<String, Object>>();
    for (UASEntitlementCodeDetail ent : entList) {
      Map<String, Object> entMapHash = new HashMap<String, Object>();
      entMapHash.put(MILEAGE, ent.getIndMileage());
      entMapHash.put(CBL, Double.valueOf(ent.getAmtCBL()));
      entMapHash.put(LIL, Double.valueOf(ent.getAmtLIL()));
      entMapHash.put(HEADER, ent.getIndHeader());
      entMapHash.put(EQUIVALENCY, Integer.valueOf(ent.getIdEquiv()));
      entMapList.put(Integer.valueOf(ent.getIdEntRow()), entMapHash);
    }
    return entMapList;
  }
  /**
   * Helper method to compare previous and current subprogram string values and set the action indicator
   * accordingly (A, D)
   * @param prev
   * @param curr
   * @return
   */
  private String setCdReqFunc(String prev, String curr) {
    String retVal = ServiceConstants.REQ_FUNC_CD_NO_ACTION;

    if (ArchitectureConstants.Y.equals(curr)) {
      if (!curr.equals(prev)) {
        retVal = ServiceConstants.REQ_FUNC_CD_ADD; 
      }
    } else if (ArchitectureConstants.N.equals(curr)) { 
      if (!curr.equals(prev)) {
        retVal = ServiceConstants.REQ_FUNC_CD_DELETE; 
      }
    } else {
      if (ArchitectureConstants.Y.equals(prev))
        retVal = ServiceConstants.REQ_FUNC_CD_DELETE;
    }
    return retVal;
  }
  /**
   * Helper method to compare previous and current subprogram double values and set the action indicator
   * accordingly (A, D, U)
   * @param prev
   * @param curr
   * @return
   */
  
  private String setCdReqFunc(double prev, double curr) {
    String retVal = ServiceConstants.REQ_FUNC_CD_NO_ACTION;
    
    if (curr != prev) {
      if (prev == 0.00)
        retVal = ServiceConstants.REQ_FUNC_CD_ADD; 
      else if (curr == 0.00)
        retVal = ServiceConstants.REQ_FUNC_CD_DELETE;
      else 
        retVal = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    return retVal;
  }
  /**
   * This method populates the retrieveSI object to pass to Retrieve service. 
   * Called by display_xa method.
   * @param context
   * @return
   */
  private UASProgramCodeMtntRetrieveSI populateRetrieveSI(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UASProgramCodeMtntSaveSO uasPrgCodeMtntSaveSO = (UASProgramCodeMtntSaveSO) state.getAttribute("uasPrgCodeMtntSaveSO",request);

    int idUasProgramCodeMtnt = ContextHelper.getIntSafe(context, "hdnUlIdUasProgramCodeMtnt");
    int rowIndex = ContextHelper.getIntSafe(context, "hdnRowIndex");
    // If coming back from saving a new program code, hdnUlIdUasProgramCodeMtnt still 0, 
    // use the newly created program code's id to populate detail section
    // Used hdnRowIndex to recognize this scenario, the value should be -1, 
    // all other scenarios, do not override the hdnUlIdUasProgramCodeMtnt in state set by user clicking on the hyperlink.
    if (rowIndex < 0 && uasPrgCodeMtntSaveSO != null && uasPrgCodeMtntSaveSO.getIdUasPrgCode() != null) {
      idUasProgramCodeMtnt = uasPrgCodeMtntSaveSO.getIdUasPrgCode().intValue();
    }

    String pageMode = PageMode.getPageMode(request);
    UASProgramCodeMtntRetrieveSI uasProgramCodeMtntRetrieveSI = new UASProgramCodeMtntRetrieveSI();
    uasProgramCodeMtntRetrieveSI.setRowIndex(rowIndex);
    uasProgramCodeMtntRetrieveSI.setIdUasProgramCodeMtnt(idUasProgramCodeMtnt);
    if (PageModeConstants.NEW.equals(pageMode)) {
      uasProgramCodeMtntRetrieveSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_ADD);
    } else if (PageModeConstants.MODIFY.equals(pageMode)) {
      uasProgramCodeMtntRetrieveSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      uasProgramCodeMtntRetrieveSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    }
    return uasProgramCodeMtntRetrieveSI;
  }
  /**
   * Helper method to sort the list by date in ascending order.
   * @param uasProgramCodeList
   */
  private void sortProgramCodeListByEffDate(List<UASProgramCodeListRow> uasProgramCodeList) {
    if(uasProgramCodeList != null && uasProgramCodeList.size() > 0) {
      Collections.sort(uasProgramCodeList, new Comparator<UASProgramCodeListRow>() {
        public int compare(UASProgramCodeListRow one, UASProgramCodeListRow two) {
          return one.getDtProgramEffective().compareTo(two.getDtProgramEffective());
        }
      });
    }
  }
  /**
   * Helper method to sort the list by program code in ascending order.
   * @param uasProgramCodeList
   */
  private void sortProgramCodeListByCode(List<UASProgramCodeListRow> uasProgramCodeList) {
    if(uasProgramCodeList != null && uasProgramCodeList.size() > 0) {
      Collections.sort(uasProgramCodeList, new Comparator<UASProgramCodeListRow>() {
        public int compare(UASProgramCodeListRow one, UASProgramCodeListRow two) {
          return one.getCdProgramCode().compareTo(two.getCdProgramCode());
        }
      });
    }
  }
  
 }
