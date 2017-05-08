package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.fad.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.APPLAPersonsConnectedRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB77SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForKennyAReqsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY_CSUB26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdPlcmtInfo_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdEvent_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.APPLAPersonsConnectedRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB25SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB77SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckForKennyAReqsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenMapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain Placement records in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  03/25/08   vdevarak  STGAP00006420: Added an indicator to see if the user
 *                       has the special access to modify approved placements. 
 *  01/16/2009 arege     STGAP0010670: Added the Placement types of REU,PRN,ICR,LAF to the if condition
 *                       so that the resource name is saved for these types in the TXT_EVENT_DESCR column of the 
 *                       EVENT table and then is displayed on the Placement List page, description section.                                       
 * 02/04/2009  mxpatel   STGAP00012290: Added a new case to show MSG_PLACE_SAVE_ADO_APP_REQ message. 
 * 02/11/2009  mxpatel   STGAP00012392: Added custom validations for new placement type - "Other Adoptive Home" and make
 *                       sure its only visible in PAD stage.  Also used "excludeViews" to make sure that the new placement type
 *                       is only visible in PAD stage.  
 * 02/12/2009  wcochran  STGAP00012404 - Added stage check to ensure MSG_DISRP_NARR_REQ error
 *                       is received only in the ADO stage. Added annotations to suppress 
 *                       unchecked warnings. Also removed unused imports.
 * 09/29/2009  mxpatel   STGAP00015448: Removed the code that was restricted MSG_DISRP_NARR_REQ message from displaying only for save and submit, 
 *                       so that message can also be received when clicking SAVE           
 * 11/25/2009  bgehlot   41275 MR-057 Added new fields for APPLA      
 * 04/12/2010  wcochran  SMS #37340: modified method populateCSUB26SI_Save to initialize the CSUB31SO object to a new object,
 *                       rather than null, to prevent NullPointerExceptions.    
 * 12/10/2010  schoi     SMS #81140: MR-074 Added message MSG_PLCMT_ICPC_LES  
 * 12/19/2010  schoi     SMS #81140: MR-074 Added separated conditions both for ADO and PAD when rbIndPlcmtChPlacedFr is set  
 * 12/19/2010  schoi     SMS #81140: MR-074 Added comment for existing conditions where end-dated Group Home is included 
 * 09/22/2011  charden   STGAP00017058 - adding code to allow certification of placement information page                                
 * 11/20/2011  htvo      STGAP00017398: Copy mode has id event = 0       
 * 11/21/2011  htvo      STGAP00017449: clear hdn resource data in case placement changes type from a resourced to non-resource.               
</pre>
 */

@SuppressWarnings("serial")
public class PlacementConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "PlacementConversation";

  public static final String CSUB25SO_STRING = "CSUB25SO";

  public static final String PLACEMENT_INFO = "csc37o00";

  public static final String PLACEMENT_HISTORY = "csc38o00";

  public static final int CURRENT = 0;

  public static final int NEXT = 1;

  public static final int CLOSURE_STATUS = 2;

  public static final String PLACEMENT_EVENT_TYPE = "PLA";

  public static final String ACTUAL = "A";

  public static final String APPRV_TASK_SUB_PLCMNT = "3320";

  public static final String APPRV_TASK_ADO_PLCMNT = "8830";

  public static final String WINDOW_MODE_NEW_APPRV = "X";

  public static final String TYPE_NON_CERT = "010";

  public static final String TYPE_FOST_ADOPT = "020";

  public static final String TYPE_CONTRACTED = "030";

  public static final String TYPE_NON_PAID = "040";

  public static final String TYPE_TYC = "050";

  public static final String TYPE_JUV_PROB = "060";

  public static final String TYPE_PACE = "070";

  // SIR 23067 - adding Unauthorized Placement Type
  public static final String TYPE_UNAUTH = "080";

  public static final String NON_CERT_CODES_TABLE = CodesTables.CLANCP;

  public static final String FOST_ADOPT_CODES_TABLE = CodesTables.CLAPRSFA;

  public static final String NON_PAID_CODES_TABLE = CodesTables.CPLCMT;

  public static final String OTHER_CODES_TABLE = CodesTables.CFACTYP2;

  // SIR 23067 - define new codestable for Unauthorized Placement Type for Living Arrangement.
  public static final String UNAUTH_CODES_TABLE = CodesTables.CLAUNA;

  public static final String PLACE_INFO_MED_DIF = "010";

  public static final String Y = ArchitectureConstants.Y;

  public static final String N = ArchitectureConstants.N;
  
  public static final String INDICATOR_START_DT_MISMATCH = "M";

  public static final String SUBCARE = "SUB";

  public static final String ADOPT = "ADO";

  public static final String POST_ADOPT = "PAD";

  public static final String STATUS_NEW = "NEW";

  public static final String STATUS_PROCESS = "PROC";

  public static final String STATUS_COMPLETE = "COMP";

  public static final String STATUS_PENDING = "PEND";

  public static final String STATUS_APPROVED = "APRV";

  public static final String CAPS_WIN_MODE_PRINC_ONLY = "P";

  public static final String FA_HOME_TYPE_H = "H";

  public static final String FA_HOME_TYPE_P = "P";

  public static final String FA_HOME_TYPE_R = "R";

  public static final String LEGAL_RISK = "L";

  public static final String DFCS_FA_HOME = "70";

  public static final String DISPLAY_PAGE = "/subcare/Placement/displayPlacement";

  public static final String FACIL_TYPE_C_MHMR_CTR_OUTPT = CodesTables.CPLLAFRM_13;

  public static final String FACIL_TYPE_REGISTER_FAM_HOME = CodesTables.CPLLAFRM_48;

  public static final String FACIL_TYPE_CHILD_PLAC_AGENCY = CodesTables.CFACTYP4_CP;

  public static final String FACIL_TYPE_BASIC_CHILD_CARE = CodesTables.CPLLAFRM_68;

  public static final String FACIL_TYPE_GROUP_DAY_HOME = CodesTables.CPLLAFRM_88;

  public static final String FACIL_TYPE_DAY_CARE_CENTER = CodesTables.CPLLAFRM_98;

  public static final String FACIL_TYPE_DROP_IN_DAY_CARE = CodesTables.CPLLAFRM_99;

  public static final String LIV_ARR_ADOPTIVE = CodesTables.CPLLAFRM_GT;

  public static final String LIV_ARR_BASIC = CodesTables.CPLLAFRM_GA;

  public static final String LIV_ARR_RCVNG = CodesTables.CPLLAFRM_GP;

  public static final String LIV_ARR_LGL_RISK = CodesTables.CPLLAFRM_GW;

  public static final String LIV_ARR_HABILITATE = CodesTables.CPLLAFRM_GD;

  public static final String LIV_ARR_THERAPEUTIC = CodesTables.CPLLAFRM_GG;

  public static final String LIV_ARR_MED_NEEDS = CodesTables.CPLLAFRM_GK;

  public static final String LIV_ARR_FACIL_PRVT_HOME = CodesTables.CPLLAFRM_71;

  public static final String LIV_ARR_MHMR_STATE_CENTER = CodesTables.CPLLAFRM_07;

  public static final String LIV_ARR_ICFMR_MEDIUM = CodesTables.CPLLAFRM_09;

  public static final String LIV_ARR_ICFMR_SMALL = CodesTables.CPLLAFRM_10;

  public static final String LIV_ARR_HSC_HOME = CodesTables.CPLLAFRM_14;

  public static final String LIV_ARR_TYC_FACILITY = CodesTables.CPLLAFRM_20;

  public static final String LIV_ARR_OTHER = CodesTables.CPLLAFRM_69;

  // SIR 23067 - add Living Arrangements Abducted Stranger and Runaway for Unauthorized Placement Type
  public static final String LIV_ARR_ABDUCTED_STRANGER = CodesTables.CLAUNA_UL;

  public static final String LIV_ARR_RUNAWAY = CodesTables.CLAUNA_UR;

  public static final int FT_SOCS = 6;

  public static final int FT_AFC_CMHMR_CONTRACT = 11;

  public static final int FT_AFC_PRIVATE_HCS = 16;

  public static final int FT_AFC_CMHMR_OPER_HCS = 17;

  public static final int FT_AFC_CMHMR_CENTER = 19;

  public static final int FT_TYC_RECEPT = 21;

  public static final int FT_TYC_CAMP = 22;

  public static final int FT_OTHER_TYC_FACILITY = 23;

  public static final int FT_PRIVATE_ICFMR_DHS = 46;

  public static final int FT_LISTED_FAMILY_HOME = 49;

  public static final int FT_ICFMR_FAC = 62;

  // New R2 Fields for Placement Type.
  public static final String TYPE_PARENT = CodesTables.CPLMNTYP_PRN;

  public static final String TYPE_RELATIVE_PAID = CodesTables.CPLMNTYP_REP;

  public static final String TYPE_RELATIVE_UNPAID = CodesTables.CPLMNTYP_REU;

  public static final String TYPE_RELATIVE_FOSTER_HOME = CodesTables.CPLMNTYP_RFH;

  public static final String TYPE_DFCS_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_DFH;

  public static final String TYPE_CPA_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_CFH;

  public static final String TYPE_CCI_FAMILY_FOSTER_HOME = CodesTables.CPLMNTYP_IFH;

  public static final String TYPE_ADOPTIVE_HOME = CodesTables.CPLMNTYP_ADH;

  public static final String TYPE_EMERGENCY_SHELTER = CodesTables.CPLMNTYP_EMS;

  public static final String TYPE_GROUP_HOME = CodesTables.CPLMNTYP_GRH;

  public static final String TYPE_CHILD_CARE_INSTITUTION = CodesTables.CPLMNTYP_CCI;

  public static final String TYPE_SPECIALIZED_FOSTER_HOME = CodesTables.CPLMNTYP_SFH;

  public static final String TYPE_ILP_AFTERCARE = CodesTables.CPLMNTYP_LAF;

  public static final String TYPE_ICPC_FOSTER = CodesTables.CPLMNTYP_ICF;

  public static final String TYPE_ICPC_ADOPTIVE = CodesTables.CPLMNTYP_ICA;

  public static final String TYPE_ICPC_RELATIVE = CodesTables.CPLMNTYP_ICR;

  public static final String TYPE_HOSPITAL = CodesTables.CPLMNTYP_HOS;

  public static final String TYPE_RUNAWAY = CodesTables.CPLMNTYP_RNA;

  public static final String TYPE_YDC = CodesTables.CPLMNTYP_YDC;

  public static final String TYPE_OTHER_RESOURCE = CodesTables.CPLMNTYP_OTR;
  
  public static final String TYPE_OTHER_ADOPTIVE_HOME = CodesTables.CPLMNTYP_OTA;//mxpatel 12392

  public static final String TYPE_OTHER_PERSON = CodesTables.CPLMNTYP_OTP;

  public static final String TYPE_NON_RELATIVE_PAID = CodesTables.CPLMNTYP_NRP;

  public static final String IND_POLICY_WAIVER = "true";

  public static final String CCON18SO_S = "CCON18SO";

  public static final String SAVE_SUBMIT_PLACEMENT_BUTTON = "btnSaveAndSubmit";

  public static final String SAVE_PLACEMENT_BUTTON = "btnSave";
  
  public static final String SEC_REGIONAL_SS_STF = UserProfile.SEC_REGIONAL_SS_STF;
  
  public static final String PREVIOUS_URL = TRACE_TAG + "PREVIOUS_URL";
  
  public static final String FOSTER_CASE_CASE_PLAN_FAMILY_URI = "/serviceDelivery/FCCPFamilyDetail/saveAndSubmitFCCPFamilyDetail";

  private DocumentSave documentSave;

  private CaseMgmt caseMgmt;

  private NonCompliance nonCompliance;
  
  private Person person;
  
  private Resource resource;

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  public void setNonCompliance(NonCompliance nonCompliance) {
    this.nonCompliance = nonCompliance;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  /**
   * Calls the csub25s service to retrieve the display information.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayPlacement_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPlacement_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    //MR-057 APPLA
    Integer ulIdFCCPEvent = (Integer)state.getAttribute("ulIdFCCPEvent", request);

    Set<String> placementType = new HashSet<String>();//mxpatel 12392

    //mxpatel 12392
    if (!POST_ADOPT.equals(GlobalData.getSzCdStage(request))) {
      placementType.add(TYPE_OTHER_ADOPTIVE_HOME);
    }
    request.setAttribute("excludeViews", placementType);//mxpatel 12392
    
    
    // event list sets page mode
    String pageMode = EventSearchConversation.getEventDetailPageMode(request);
    String reqPullBack = ContextHelper.getStringSafe(request, "hdnReqPullBack");
    if (!IND_POLICY_WAIVER.equals(reqPullBack)) {
      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);
    } else {
      setPageMode(request);
    }
    
    
    // MR-057 if we haven't already set the calling URL (i.e., if this is the first time the page has been
    // accessed), then clear the state, and store the previous URL there
    if (state.getAttribute(PREVIOUS_URL, request) == null) {
      String callingPage = ContextHelper.getPreviousUrl(request);
      state.setAttribute(PREVIOUS_URL, callingPage, request);
      state.setAttribute("ulIdFCCPEvent", ulIdFCCPEvent, request ); 
    }
    
    CSUB25SO csub25so = new CSUB25SO();
    try {
      if (IND_POLICY_WAIVER.equals(reqPullBack)) {
        csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
      } else {
     
        CSUB25SI csub25si = populateCSUB25SI_Retrieve(request);
        csub25so = caseMgmt.retrievePlacementDetail(csub25si);
        
        //MR-057 APPLA changes. Add the person Connected list to the csub25so object after setting the person connected list
        APPLAPersonsConnectedRetrieveSI APPLAPersonsConnectedRetrieveSI = populateAPPLAPersonsConnectedRetrieveSI_Retrieve(request);
        APPLAPersonsConnectedRetrieveSO APPLAPersonsConnectedRetrieveSO =  caseMgmt.retrievePersonsConnected(APPLAPersonsConnectedRetrieveSI);
        CSUB25SOG02_ARRAY personConnectedList = APPLAPersonsConnectedRetrieveSO.getPersonConnectedList();
        csub25so.setCSUB25SOG02_ARRAY(personConnectedList);
        
        // state.removeAllAttributes(request);
        populateAdminAddressPhoneSubmodule(request, csub25so.getCSUB25SOG00());
      }
      
      //STGAP00005989: If the placement type is DFCS Foster Home or CPA Foster Home
      //and if the facility type is DFCS FA Home or NON-DFCS FA home and the resource
      //status is pending temp approval or temp approval then display this informational
      //message.
      if(ArchitectureConstants.Y.equals(csub25so.getCIndRsrcStatus())){
        setInformationalMessage(Messages.MSG_RSRC_PEND_APRV, request);
      }
      String county = CaseUtility.getCounty(GlobalData.getUlIdCaseAsString(request));
      GlobalData.setSzCdCounty(county, request);

      if (PageModeConstants.NEW_USING.equals(pageMode)) {
        csub25so = convertCsub25so_to_NewUsing(request, csub25so);

        state.setAttribute("newUsingEventId", GlobalData.getUlIdEventAsString(request), request);
      }
      if (PageModeConstants.NEW.equals(pageMode)) {
        csub25so = convertCsub25so_to_New(request, csub25so);
        
      }
      // STGAP00017398 - move Kenny A check after NEW_USING update to get the correct Global Event id 0;
      // STGAP00017058 - check if resource is a facility or FA Home to know whether to display the placement log link
      //Boolean displayPlacementLogLink = (Boolean) request.getAttribute("displayPlacementLogLink");
      CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();
      
      // check to see if resource has a placement log
      if(placementDetail != null && placementDetail.getUlIdRsrcFacil() != 0){
        // create transport object
        CheckForKennyAReqsSI checkForKennyAReqsSI = new CheckForKennyAReqsSI();
        checkForKennyAReqsSI.setIdResource(placementDetail.getUlIdRsrcFacil());
        checkForKennyAReqsSI.setCurrChild(0);
        checkForKennyAReqsSI.setIdPlcmtEvent(GlobalData.getUlIdEvent(request));
        // check the resource type
        CheckForKennyAReqsSO checkForKennyAReqsSO = resource.checkForKennyAReqs(checkForKennyAReqsSI);
        // if home or facility, display the placement log link
        if(checkForKennyAReqsSO.isFAHome() || checkForKennyAReqsSO.isFacility()){
          request.setAttribute("displayPlacementLogLink", true);
        }else{
          request.setAttribute("displayPlacementLogLink", false);
        } 
        
        // set indicator in request to determine whether event has been approved before (which means
        // we should be freezing certification sections and validations
        state.setAttribute("isCertificationFrozen", checkForKennyAReqsSO.isCertificationFrozen(), request);
     }else{
       state.setAttribute("isCertificationFrozen", false, request);
       // STGAP00017449: non-facil resource must not show log link. If placement was  changed from a 
       // resourced placement(has id resource)and saved successfully, these hdn may still remain so 
       // reset all  
       request.setAttribute("displayPlacementLogLink", false); 
       request.setAttribute("hdnPlacementLogResource", 0); 
       request.setAttribute("hdnPlacementLogResourceName", ""); 
     }
      // End STGAP00017058
      
      state.setAttribute(CSUB25SO_STRING, csub25so, request);
      if (checkDisruptionNarrExists(GlobalData.getUlIdEvent(request))) {
        state.setAttribute("adoDisruptNarrExists", ArchitectureConstants.Y, request);
      }
      setPageMode(request);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      // -- temporary fix for "no primary child in stage" scenario from RetrievePlacementDetailImpl
      case Integer.MAX_VALUE:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(we.getErrorMessage(), request);
        break;
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Throwable e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  
  /**
   * This method displays the Placement Log page
   * @param context - The GRNDS context object
   */
  public void displayPlacementLog_xa(GrndsExchangeContext context){
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPlacementLog_xa()");
    performanceTrace.enterScope();
    
    // get the request and placement out object
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CSUB25SO csub25SO = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
    
    // setup url to forward Records Check conversation display method
    String forwardUrl = "/fad/PlacementLog/displayPlacementLog";
    
    // set info into global data for info sections
    String idResource = StringHelper.getSafeString(request.getParameter("hdnPlacementLogResource"));
    String nmResource = StringHelper.getSafeString(request.getParameter("hdnPlacementLogResourceName"));
    GlobalData.setUlIdResource(Integer.parseInt(idResource), request);
    GlobalData.setSzNmResource(nmResource, request);
    request.setAttribute("frwdIdResource", idResource);
    
    
    // create transport objects
    @SuppressWarnings("unused")
    CheckForKennyAReqsSO checkForKennyAReqsSO = new CheckForKennyAReqsSO();
    CheckForKennyAReqsSI checkForKennyAReqsSI = new CheckForKennyAReqsSI();

    try{  
      request.setAttribute("placementInfo", "true");
      if(PageModeConstants.NEW.equals(PageMode.getPageMode(request))){
        state.setAttribute("plcmtLogLastViewDate", new Date(), request);
      }else if(csub25SO != null){
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 placementDetail = csub25SO.getROWCCMN01UIG00();
        Boolean isCertificationFrozen = (Boolean) state.getAttribute("isCertificationFrozen", request);
        if(placementDetail != null && !isCertificationFrozen && !"APRV".equals(placementDetail.getSzCdEventStatus())){
          // populate input object 
          checkForKennyAReqsSI.setCurrChild(0);
          checkForKennyAReqsSI.setIdResource(Integer.parseInt(idResource));
          checkForKennyAReqsSI.setPlacementLogViewDate(new Date());
          checkForKennyAReqsSI.setIdPlcmtEvent(placementDetail.getUlIdEvent());
          
          //store the current date in the placement detail as the last view prior to approval date
          checkForKennyAReqsSO = resource.checkForKennyAReqs(checkForKennyAReqsSI);
        }
      }
      
      // forward control to placement log but maintain the current context
      forward(forwardUrl, request, context.getResponse());
    }catch(Exception e){
      // process any exception
      processSevereException(context, e);
      return;
    }finally{
      // log time and exit method scope
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }
  
 

  /**
   * This method will call the csub26s service. It will then determine if Save or Save and Submit was called. It will
   * reload the Placement page if Save is called and navigate to the Todo detail if Save and Submit is called.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void savePlacement_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePlacement_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    // get whether the certification section should be frozen
    Boolean isCertificationFrozen = (Boolean) state.getAttribute("isCertificationFrozen", request);
    
    //MR-057 APPLA return control to the calling page
    String previousURL = (String) state.getAttribute(PREVIOUS_URL, request);
    Integer ulIdFCCPEvent = (Integer)state.getAttribute("ulIdFCCPEvent", request);
    
    // bSaveIsPressed is used to determine what button was originally pressed.
    // set it here based on if bSaveIsPressed was selected.
    boolean bSaveIsPressed = ContextHelper.getString(request, "btnSave.x") != null;
    // reset bSaveIsPressed based on hdnBSaveIsPressed. hdnBSaveIsPressed is set to the value of bSaveIsPressed
    // when OK is selected from a confirmation message in the page
    boolean hdnBSaveIsPressed = ContextHelper.getBooleanSafe(request, "hdnBSaveIsPressed");
    if (hdnBSaveIsPressed) {
      bSaveIsPressed = true;
    }
    boolean btnAppovalStatus = ContextHelper.getString(request, "btnApprovalStatusFinal.x") != null;
    
    

    CSUB26SI csub26si = null;
    try {
      if (checkDisruptionNarrExists(GlobalData.getUlIdEvent(request))) {
          state.setAttribute("adoDisruptNarrExists", ArchitectureConstants.Y, request);
      }
        
      csub26si = populateCSUB26SI_Save(request, caseMgmt, bSaveIsPressed);
      CSUB26SO csub26so = caseMgmt.savePlacementDetail(csub26si);

      /*
       * if (csub26so.getSNbrRsrcOpenSlots() < 0) { setInformationalMessage(Messages.MSG_FAD_CAP_EXCEEDED, request); }
       */

      // if new using call this to copy the documents from the old placment.
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.NEW_USING.equals(pageMode)) {
        request.setAttribute("nEvent", state.getAttribute("newUsingEventId", request));
        request.setAttribute("nCase", GlobalData.getUlIdCaseAsString(request));
        request.setAttribute("sEvent", StringHelper.EMPTY_STRING + csub26so.getUlIdEvent());
        request.setAttribute("sCase", GlobalData.getUlIdCaseAsString(request));
        request.setAttribute("docType", "csc37iss");

      }

      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))
          || PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }

      GlobalData.setUlIdEvent(csub26so.getUlIdEvent(), request);

      ToDoDetailDB toDoDetailDB = null;
      //STGAP00017058
      Boolean btnApprovalStatus = (Boolean) state.getAttribute("btnApprovalStatus", request);
      boolean erroredOut = state.getAttribute("erroredOut", request) != null ? true : false;
      if(btnAppovalStatus || (erroredOut && btnApprovalStatus != null && btnApprovalStatus)){
        setPresentationBranch("display_approval", context);
      }else if (!bSaveIsPressed) {
        String taskCode = APPRV_TASK_SUB_PLCMNT;
        if (ADOPT.equals(GlobalData.getSzCdStage(request))) {
          taskCode = APPRV_TASK_ADO_PLCMNT;
        }

        toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), csub26si.getUlIdCase(),
                                        GlobalData.getUlIdStage(request), taskCode);
        //STGAP00005989: If the childs eligibility is Not Eligible or Not Elig - County Pd 
        //then display this message on the TO DO detail page when a paid placement is submitted 
        //for the child. 
        if (ArchitectureConstants.Y.equals(csub26so.getCIndEllig())) {
          setInformationalMessage(Messages.MSG_CHLD_NOT_ELLIGIBLE, request);
        }
        setPresentationBranch("submit_approval", context);
      }
      // clean up on-change flags and other messes
      state.removeAllAttributes(request);

      // after removing all attributes if todoDetailDB is not null, set
      // it into state.
      if (toDoDetailDB != null) {
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      }
      
      //MR-057 APPLA return control to the calling page
      String forwardUrl = StringHelper.EMPTY_STRING;
      if(bSaveIsPressed){
        if (FOSTER_CASE_CASE_PLAN_FAMILY_URI.equals(previousURL)) {
          forwardUrl = "/workload/EventSearch/displayEventDetail";
          int idFCCPEvent = 0;
          if (ulIdFCCPEvent != null){
            idFCCPEvent = ulIdFCCPEvent;
            CaseUtility.Event excEvent = CaseUtility.getEvent(idFCCPEvent);
            CaseUtility.Stage excStage = CaseUtility.getStage(excEvent.getIdStage());

            String paramString = StringHelper.EMPTY_STRING;
            paramString = "actionEventId=" + idFCCPEvent + "&actionStageCode=" + excStage.getCdStage() + "&actionStageName=" + 
            excStage.getNmStage() + "&actionTaskCode=" + "7065" + "&actionCaseId=" + excStage.getIdCase() + "&actionStageId=" +excEvent.getIdStage(); 
            forwardUrl = forwardUrl + "?" + paramString;
          }
          forward(forwardUrl, request, context.getResponse());
        }
      }
      // Van - removeAllAttributes was called earlier, why these?
      state.removeAttribute("certInfoMap", request);
      state.removeAttribute("hdnClearingPlaceInfo", request);
    } catch (ServiceException we) {
      we.printStackTrace();

      setPresentationBranch("stay", context);
      resetCsub25so(request);

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      // -- temporary fix for "no primary child in stage" scenario from RetrievePlacementDetailImpl
      case Integer.MAX_VALUE:
        setErrorMessage(we.getErrorMessage(), request);
        break;
      case Messages.MSG_MOTHER_MARRIED:
        setErrorMessage(Messages.MSG_MOTHER_MARRIED, request);
        setErrorMessage("You may click on Save to store Placement Information until required changes are complete.",
                        request);
        break;

      case Messages.MSG_SUB_AFFECT_PYMT:
        request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
        setInformationalMessage(Messages.MSG_SUB_AFFECT_PYMT, request);
        // data wasn't saved; refresh what was on the page
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(Messages.SQL_NOT_FOUND, request);
        break;

      //mxpatel wrote this case for defect #12290
      case Messages.MSG_PLACE_SAVE_ADO_APP_REQ:
        setErrorMessage(Messages.MSG_PLACE_SAVE_ADO_APP_REQ, request);
       break;
      case Messages.ARC_UTL_YEAR_TOO_SMALL:
      case Messages.MSG_PLCMT_FC_PER_DIEM_REQ:
        setErrorMessage(Messages.MSG_PLCMT_FC_PER_DIEM_REQ, request);
        break;
      case Messages.ARC_ERR_BAD_FUNC_CD:
        setErrorMessage(Messages.ARC_ERR_BAD_FUNC_CD, request);
        break;
      case Messages.MSG_NO_LOC_RECORDED:
        setErrorMessage(Messages.MSG_NO_LOC_RECORDED, request);
        break;
      case Messages.MSG_PLCMT_REL_SUP_REQ:
        setErrorMessage(Messages.MSG_PLCMT_REL_SUP_REQ, request);
        break;
      case Messages.MSG_PLCMT_NON_REL_SUP_REQ:
        setErrorMessage(Messages.MSG_PLCMT_NON_REL_SUP_REQ, request);
        break;
      
      case Messages.SSM_START_BEFORE_SAME_END:
        setErrorMessage(Messages.SSM_START_BEFORE_SAME_END, request);
        break;

      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      case Messages.MSG_MUST_SAVE_PLACEMENT_FIRST:
      case Messages.MSG_NO_ACTIVE_CONTRACT_EXIST:
        setErrorMessage(Messages.MSG_NO_ACTIVE_CONTRACT_EXIST, request);
        break;
      case Messages.MSG_SUB_PERIOD_OVERLAP_1:
        setErrorMessage(Messages.MSG_SUB_PERIOD_OVERLAP_1, request);
        break;
      case Messages.MSG_SUB_PERIOD_OVERLAP_2:
        setErrorMessage(Messages.MSG_SUB_PERIOD_OVERLAP_2, request);
        break;
      //STGAP00006420: Added the next 3 cases to display gap Messages.
      case Messages.MSG_SUB_GAP_EXISTS_1:
        request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
        request.setAttribute("errorCode", Messages.MSG_SUB_GAP_EXISTS_1);
        //data wasn't saved; refresh what was on the page
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      case Messages.MSG_SUB_GAP_EXISTS_2:
        request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
        request.setAttribute("errorCode", Messages.MSG_SUB_GAP_EXISTS_2);
        //data wasn't saved; refresh what was on the page
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      case Messages.MSG_SUB_GAP_EXISTS_3:
        request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
        request.setAttribute("errorCode", Messages.MSG_SUB_GAP_EXISTS_3);
        //data wasn't saved; refresh what was on the page
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      case Messages.MSG_DISRP_NARR_REQ:
        setPresentationBranch("stay", context);
        setErrorMessage(errorCode, request);
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_NO_ACT_FLOC_STATUS:
      case Messages.MSG_SYS_INVALID_TASK:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.SSM_FA_HM_TYPE_MISMATCH:
      case Messages.SSM_SUB_ADOPT_LIV_ARRG:
      case Messages.SSM_SUB_SUBCARE_LIV_ARRG:
      case Messages.SSM_SUB_SUBCARE_PLACE_TYP:
      case Messages.MSG_PLACE_DATE_RANGE:
      case Messages.MSG_LEG_STAT_REQ:
      case Messages.MSG_CHILD_DOB_REQUIRED:
      case Messages.MSG_PLCMT_WAIVER_TYPE_REQ:
      case Messages.MSG_PLCMT_HOME_LIC_CH_AGE:
      case Messages.MSG_PLCMT_HOME_LIC_CAP:  
      case Messages.MSG_PLCMT_CHILD_12_GROUP:
      case Messages.SSM_COMPLETE_REQUIRED:
      case Messages.MSG_FC_PDM_DT_MISSMATCH:
      case Messages.MSG_RBWO_DT_MISMATCH:
      case Messages.MSG_SUB_DT_MISSMATCH:
      case Messages.MSG_NRP_SUB_DT_MISSMATCH:
      case Messages.MSG_SUB_RSRC_MISSMATCH:
      case Messages.MSG_PLCMT_CPA_PRGM_REQ:
      case Messages.MSG_PLCMT_CCI_PRGM_REQ:
      case Messages.MSG_PLCMT_CTZSHIP_REQ:
      case Messages.MSG_PLCMT_RSRC_TYP_INVALID:
      case Messages.MSG_CONCUR_POC_REQ:
      case Messages.MSG_NO_SVC_IN_HM_CNTRCT:
      case Messages.MSG_NO_SVC_IN_SUB_CNTRCT:
      case Messages.MSG_NO_SVC_IN_FACIL_CNTRCT:
      case Messages.MSG_CCI_PRGM_CONFIRM:
      case Messages.MSG_CPA_PRGM_CONFIRM:
      case Messages.MSG_RSRC_SVC_NOT_IN_CNTY:
      case Messages.MSG_CPA_REQ:
      case Messages.MSG_PLCMT_ICPC_LES:
      case Messages.MSG_FH_CONV_REQ:
      setErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Throwable e) {
      processSevereException(context, e);
    }finally{
      //STGAP00017058
      state.setAttribute("isCertificationFrozen", isCertificationFrozen, request);
      state.setAttribute("erroredOut", true, request);
      request.setAttribute("displayPlacementLogLink", ContextHelper.getBooleanSafe(request, "hdnDisplayPlacementLogLink"));
      if(btnAppovalStatus){
        state.setAttribute("btnAppovalStatus", btnAppovalStatus, request);
      }
      // End STGAP00017058
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will call the Resource search page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void getResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getResource_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    resetCsub25so(request);

    performanceTrace.exitScope();
  }

  /**
   * This method will take the data from the resource search and apply it to our page. It will call csub31s to retrieve
   * the agency info. The logic for this code was taken directly from CAPS.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  @SuppressWarnings({"unchecked"})
  public void setResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setResource_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    boolean type_foster_adoptive = false;
    boolean type_contracted_institutional = false;

    try {
      CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
      CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();
      gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 rowccmn01uigoo = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00)csub25so.getROWCCMN01UIG00();
      int idPlcmtEvent = 0;
      if(rowccmn01uigoo!=null && rowccmn01uigoo.hasUlIdEvent()){
        idPlcmtEvent = rowccmn01uigoo.getUlIdEvent();
      }
      CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);
      int idRsrc = 0;
      boolean validRes = false;
      String facilType = StringHelper.EMPTY_STRING;
      String county = StringHelper.EMPTY_STRING;
      CheckForKennyAReqsSO checkForKennyAReqsSO = new CheckForKennyAReqsSO();
      CheckForKennyAReqsSI checkForKennyAReqsSI = new CheckForKennyAReqsSI();
      // int idRsrcCapacity = cres03so.getUlIdResource();

      if (cres03so != null) {
        if (cres03so.getUlIdResource() != 0) {
          String eventStatus = rowccmn01uigoo.getSzCdEventStatus();
          idRsrc = cres03so.getUlIdResource();
          // STGAP00017058 - check to see if Kenny A. message is required and remove certification data
          checkForKennyAReqsSI.setEventStatus(eventStatus);
          checkForKennyAReqsSI.setIdResource(idRsrc);
          checkForKennyAReqsSI.setCurrChild(placementDetail.getUlIdPlcmtChild());
          checkForKennyAReqsSI.setIdPlcmtEvent(idPlcmtEvent);
          checkForKennyAReqsSO = resource.checkForKennyAReqs(checkForKennyAReqsSI);
          request.setAttribute("isKennyAReq", checkForKennyAReqsSO.isKennyAReq());
          
          // check to see if resource is an FA Home or Facility
          if(checkForKennyAReqsSO.isFacility() || checkForKennyAReqsSO.isFAHome()){
            request.setAttribute("displayPlacementLogLink", true);
          }else{
            request.setAttribute("displayPlacementLogLink", false);
          }
          
          // remove indicator from state and request so that link can be displayed
          request.getParameterMap().put("hdnClearingPlaceInfo", "N");
          state.removeAttribute("hdnClearingPlaceInfo", request);
          
          // reset certification info
          // STGAP00017398: do not reset cert and log data if there has been an APRV, 
          // TODO however, should not hardcode the display here now that the updates are save to DB in KennyAImpl; or do not let KennyA save.
          if (!checkForKennyAReqsSO.isCertificationFrozen()) {
          if(!"APRV".equals(eventStatus)){
            placementDetail.setDtLastViewPlcmtLog(null);
          }
          // STGAP00017398: reset CM cert data on Copy when the page has not been saved and resource pullback
          // Add mode can have id event = 0 too but it cannot have the cert checked w/o saving the page
          // so no worry about accidentally erasing data
          if("COMP".equals(eventStatus) || idPlcmtEvent == 0){
            placementDetail.setIndCaseMngrCert("N");
            placementDetail.setUlIdCaseMngrCert(0);
            placementDetail.setDtCaseMngrCert(null);
            placementDetail.setNmCaseMngrCertFullName("");
            placementDetail.setUlIdCaseMngrRsrc(0);
            placementDetail.setNmCaseMngrRsrc("");
          }else if("PEND".equals(eventStatus)){
            placementDetail.setIndSupCert("N");
            placementDetail.setUlIdSupCert(0);
            placementDetail.setDtSupCert(null);
            placementDetail.setNmSupCertFullName("");
            placementDetail.setUlIdSupRsrc(0);
            placementDetail.setNmSupRsrc("");
          }
          } // End STGAP00017398: do not reset cert data if there has been an APRV
          if(checkForKennyAReqsSO.getDtLastUpdate() != null){
            placementDetail.setTsLastUpdate(checkForKennyAReqsSO.getDtLastUpdate());
          }
          // End STGAP00017058
        }
        if (cres03so.getSzCdRsrcFacilType() != null) {
          facilType = cres03so.getSzCdRsrcFacilType();
        }
      }

      Enumeration addressEnum = cres03so.getROWCRES03SOG00_ARRAY().enumerateROWCRES03SOG00();
      ROWCRES03SOG00 addressDetail = new ROWCRES03SOG00();

      // Here is some error checking to make sure the facilty is applicable.
      if (!(StringHelper.EMPTY_STRING).equals(facilType) || facilType != null) {
        if (FACIL_TYPE_CHILD_PLAC_AGENCY.equals(facilType)) {
          addErrorMessage(Messages.MSG_SUB_CPA_SELECTED, request);
          setPageMode(request);
          return;
        }
      }
      if (TYPE_DFCS_FAMILY_FOSTER_HOME.equals(placementDetail.getSzCdPlcmtType())
          || TYPE_RELATIVE_FOSTER_HOME.equals(placementDetail.getSzCdPlcmtType())) {
        type_foster_adoptive = true;

      }else{
        type_foster_adoptive = false;
      }
      // SMS #81140: MR-074
      // Group Home (TYPE_GROUP_HOME condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
      // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
      // However, it is no harm to keep Group Home in the code below because it will not break the logic.
      // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value. 
      if (TYPE_CPA_FAMILY_FOSTER_HOME.equals(placementDetail.getSzCdPlcmtType())
          || TYPE_CCI_FAMILY_FOSTER_HOME.equals(placementDetail.getSzCdPlcmtType())
          || TYPE_EMERGENCY_SHELTER.equals(placementDetail.getSzCdPlcmtType())
          || TYPE_GROUP_HOME.equals(placementDetail.getSzCdPlcmtType())
          || TYPE_CHILD_CARE_INSTITUTION.equals(placementDetail.getSzCdPlcmtType())
          || TYPE_SPECIALIZED_FOSTER_HOME.equals(placementDetail.getSzCdPlcmtType())) {
        type_contracted_institutional = true;

      }else{
        type_contracted_institutional = false;
      }

      if (cres03so.getSzCdRsrcFacilType() != null) {
        if (type_foster_adoptive && !DFCS_FA_HOME.equals(cres03so.getSzCdRsrcFacilType())) {
           addErrorMessage(Messages.MSG_SUB_NOT_FA_HOME, request);
          setPageMode(request);
          // STGAP00017058
          request.setAttribute("displayPlacementLogLink", false);
          request.removeAttribute("isKennyAReq");
          return;
        }
        if (type_contracted_institutional && DFCS_FA_HOME.equals(cres03so.getSzCdRsrcFacilType())) {
           addErrorMessage(Messages.MSG_FA_HOME_CONTRACT, request);
          setPageMode(request);
          return;
        }
      }
      while (addressEnum.hasMoreElements()) {
        addressDetail = (ROWCRES03SOG00) addressEnum.nextElement();
        if ("01".equals(addressDetail.getSzCdRsrcAddrType())) {
          county = addressDetail.getSzCdFacilityCounty();
          break;
        }
      }
      Enumeration phoneEnum = cres03so.getROWCRES03SOG01_ARRAY().enumerateROWCRES03SOG01();
      ROWCRES03SOG01 phoneDetail = new ROWCRES03SOG01();
      while (phoneEnum.hasMoreElements()) {
        phoneDetail = (ROWCRES03SOG01) phoneEnum.nextElement();
        if ("01".equals(phoneDetail.getSzCdFacilPhoneType())) {
          break;
        }
      }

      CSUB31SI csub31si = new CSUB31SI();

      csub31si.setUlIdResource(idRsrc);
      csub31si.setSzAddrPlcmtCnty(county);
      csub31si.setSzCdRsrcFacilType(facilType);
      csub31si.setSzCdPlcmtType(placementDetail.getSzCdPlcmtType());
      csub31si.setUlIdPlcmtChild(placementDetail.getUlIdPlcmtChild());
      csub31si.setDtDtPlcmtStart(placementDetail.getDtDtPlcmtStart());
      csub31si.setSzCdTempPlcmtType(placementDetail.getSzCdPlcmtTempType());
      csub31si.setCIndPlcmetEmerg(placementDetail.getCIndPlcmetEmerg());
      csub31si.setUlIdStage(GlobalData.getUlIdStage(request));
      csub31si.setUlIdPlcmtEvent(idPlcmtEvent);

      CSUB31SO csub31so = callCSUB31S_Retrieve(request, csub31si, caseMgmt);

      // SIR 23155 - If bSysIndHomeHist is set, that means no home history
      // rows are available for this resource, display an error message
      if (Y.equals(csub31so.getBSysIndHomeHist())) {
        setInformationalMessage(Messages.MSG_PLACE_DATE_RANGE, request);
      }

      if (TYPE_FOST_ADOPT.equals(placementDetail.getSzCdPlcmtType())) {
        csub25so.setCCdRsrcFaHomeType1(csub31so.getCCdRsrcFaHomeType1());
        csub25so.setCCdRsrcFaHomeType2(csub31so.getCCdRsrcFaHomeType2());
        csub25so.setCCdRsrcFaHomeType3(csub31so.getCCdRsrcFaHomeType3());
        csub25so.setCCdRsrcFaHomeType4(csub31so.getCCdRsrcFaHomeType4());
        csub25so.setCCdRsrcFaHomeType5(csub31so.getCCdRsrcFaHomeType5());
        csub25so.setCCdRsrcFaHomeType6(csub31so.getCCdRsrcFaHomeType6());
        csub25so.setCCdRsrcFaHomeType7(csub31so.getCCdRsrcFaHomeType7());
        csub25so.setSzCdRsrcCategory(csub31so.getSzCdRsrcCategory());
      }
      placementDetail.setSzNmPlcmtAgency(csub31so.getSzNmPlcmtAgency());
      placementDetail.setUlIdRsrcAgency(csub31so.getUlIdRsrcAgency());
      placementDetail.setUlIdContract(csub31so.getUlIdContract());

      placementDetail.setSzNmPlcmtFacil(cres03so.getSzNmResource());
      placementDetail.setUlIdRsrcFacil(cres03so.getUlIdResource());

      // SIR 23223 - when changing from a Person to a Resource, make sure to
      // clear out the IdPlcmtAdult.
      placementDetail.setUlIdPlcmtAdult(0);

      placementDetail.setSzNbrPlcmtTelephone(phoneDetail.getLNbrFacilPhoneNumber());
      placementDetail.setSzNbrPlcmtPhoneExt(phoneDetail.getLNbrFacilPhoneExtension());
      placementDetail.setSzAddrPlcmtLn1(addressDetail.getSzAddrRsrcAddrStLn1());
      placementDetail.setSzAddrPlcmtLn2(addressDetail.getSzAddrRsrcAddrStLn2());
      placementDetail.setSzAddrPlcmtCity(addressDetail.getSzAddrRsrcAddrCity());
      placementDetail.setSzAddrPlcmtSt(addressDetail.getSzCdFacilityState());
      placementDetail.setSzAddrPlcmtZip(addressDetail.getSzAddrRsrcAddrZip());
      placementDetail.setSzAddrPlcmtCnty(addressDetail.getSzCdFacilityCounty());
      placementDetail.setSzTxtPlcmtAddrComment(addressDetail.getSzTxtRsrcAddrComments());

      populateAdminAddressPhoneSubmodule(request, placementDetail);
      
      //MR-057 APPLA Changes
      state.setAttribute("idResourceFacil", idRsrc, request);      
      APPLAPersonsConnectedRetrieveSI APPLAPersonsConnectedRetrieveSI = populateAPPLAPersonsConnectedRetrieveSI_Retrieve(request);
      APPLAPersonsConnectedRetrieveSO APPLAPersonsConnectedRetrieveSO =  caseMgmt.retrievePersonsConnected(APPLAPersonsConnectedRetrieveSI);
      CSUB25SOG02_ARRAY personConnectedList = APPLAPersonsConnectedRetrieveSO.getPersonConnectedList();
      csub25so.setCSUB25SOG02_ARRAY(personConnectedList);
      
      state.setAttribute(CSUB25SO_STRING, csub25so, request);

      // always say page is dirty if leave placement after setResource_xa
       //request.setAttribute("isDirty", "isDirty");

      setPageMode(request);
    } catch (ServiceException we) {
      we.printStackTrace();

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_SUB_NOT_FA_HOME:
        setInformationalMessage(Messages.MSG_SUB_NOT_FA_HOME, request);
        setPresentationBranch("stay", context);
        break;
      // SIR 15078
      case Messages.MSG_SUB_CPA_SELECTED:
        setInformationalMessage(Messages.MSG_SUB_CPA_SELECTED, request);
        setPresentationBranch("stay", context);
        break;
      // SIR 23155
      case Messages.MSG_PLACE_DATE_RANGE:
        setErrorMessage(Messages.MSG_PLACE_DATE_RANGE, request);
        setPresentationBranch("stay", context);
        break;
      case Messages.MSG_FA_HOME_CONTRACT:
        setErrorMessage(Messages.MSG_FA_HOME_CONTRACT, request);
        setPresentationBranch("stay", context);
        break;
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(Messages.MSG_FA_HOME_CONTRACT, request);
        setPresentationBranch("stay", context);
        break;
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        setErrorMessage(Messages.MSG_FA_HOME_CONTRACT, request);
        setPresentationBranch("stay", context);
        break;
      case Messages.ARC_UTL_YEAR_TOO_SMALL:
        addErrorMessage(errorCode, request);
        setPresentationBranch("stay", context);
        break;
      case Messages.MSG_PLCMT_CTZSHIP_REQ:
        setErrorMessage(Messages.MSG_PLCMT_CTZSHIP_REQ, request);
        setPresentationBranch("stay", context);
        break;
      case Messages.MSG_PLCMT_RSRC_TYP_INVALID:
        setErrorMessage(Messages.MSG_PLCMT_RSRC_TYP_INVALID, request);
        setPresentationBranch("stay", context);
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Throwable e) {
      e.printStackTrace();
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will call the person list.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void getPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getPerson_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    resetCsub25so(request);

    // preserving pageMode for when we return via setPerson_xa
    state.setAttribute("pageMode", PageMode.getPageMode(request), request);

    PageMode.setPageMode(CAPS_WIN_MODE_PRINC_ONLY, request);
    PersonListPullBackInfo personListPBInfo = new PersonListPullBackInfo();
    personListPBInfo.setDestinationUrl("/subcare/Placement/setPerson");
    request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPBInfo);

    performanceTrace.exitScope();
  }

  /**
   * This method will apply the info we got from the person list and place it in the page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void setPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDocument_setPerson_SP_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      PageMode.setPageMode((String) state.getAttribute("pageMode", request), request);

      String nmPerson = StringHelper.EMPTY_STRING;
      // SIR 23067 - need Person Role for edit for PC role in custom val on person selected for unauthorized placements.
      String szCdStagePersRole = StringHelper.EMPTY_STRING;

      int idPerson = 0;
      PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request
                                                                                      .getAttribute("personListPullBackInfo");

      if (personListPullBackInfo != null) {
        ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
        idPerson = rowcinv01sog00.getUlIdPerson();
        nmPerson = String.valueOf(rowcinv01sog00.getSzNmPersonFull());

        // SIR 23067 - need Person Role for edit for PC role in custom val on person selected for unauthorized
        // placements.
        szCdStagePersRole = String.valueOf(rowcinv01sog00.getSzCdStagePersRole());
        request.setAttribute("szCdStagePersRole", szCdStagePersRole);
      }

      CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
      CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();

      CSUB77SI csub77si = new CSUB77SI();
      csub77si.setUlIdPerson(idPerson);
      CSUB77SO csub77so = caseMgmt.retrieveAddressAndPhone(csub77si);

      // SIR 23067 - change edit on whether person address exists to allow selection of a person
      // without an address if placement type is unauthorized.
      if (StringHelper.isValid(csub77so.getSzAddrPersAddrStLn1()) == false
          && !TYPE_UNAUTH.equals(placementDetail.getSzCdPlcmtType())) {
        placementDetail.setSzNmPlcmtPersonFull(StringHelper.EMPTY_STRING);
        placementDetail.setUlIdPlcmtAdult(0);

        placementDetail.setSzNbrPlcmtTelephone(null);
        placementDetail.setSzNbrPlcmtPhoneExt(null);
        placementDetail.setSzAddrPlcmtLn1(null);
        placementDetail.setSzAddrPlcmtLn2(null);
        placementDetail.setSzAddrPlcmtCity(null);
        placementDetail.setSzAddrPlcmtSt(null);
        placementDetail.setSzAddrPlcmtZip(null);
        placementDetail.setSzAddrPlcmtCnty(null);
        placementDetail.setSzTxtPlcmtAddrComment(null);

        setErrorMessage(Messages.MSG_SUB_NO_ADDRESS_EXIST, request); // !!!
      } else {
        placementDetail.setSzNmPlcmtPersonFull(nmPerson);
        placementDetail.setUlIdPlcmtAdult(idPerson);

        placementDetail.setSzNbrPlcmtTelephone(csub77so.getLNbrPhone());
        placementDetail.setSzNbrPlcmtPhoneExt(csub77so.getLNbrPhoneExtension());
        placementDetail.setSzAddrPlcmtLn1(csub77so.getSzAddrPersAddrStLn1());
        placementDetail.setSzAddrPlcmtLn2(csub77so.getSzAddrPersAddrStLn2());
        placementDetail.setSzAddrPlcmtCity(csub77so.getSzAddrCity());
        placementDetail.setSzAddrPlcmtSt(csub77so.getSzCdAddrState());
        placementDetail.setSzAddrPlcmtZip(csub77so.getLAddrZip());
        placementDetail.setSzAddrPlcmtCnty(csub77so.getSzCdAddrCounty());
        placementDetail.setSzTxtPlcmtAddrComment(csub77so.getSzTxtPersAddrCmnts());
      }
      placementDetail.setUlIdContract(0);

      populateAdminAddressPhoneSubmodule(request, placementDetail);

      state.setAttribute(CSUB25SO_STRING, csub25so, request);

     setPageMode(request);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        addErrorMessage(errorCode, request);
        break;

      default:
        processSevereException(context, we);
        break;
      }
    } catch (Throwable e) {
      e.printStackTrace();
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will take a csub31si object and call the csub31s service.
   * 
   * @param request
   *          The HTTP Servlet Request
   * @param csub31si
   *          The the input object for the csub31s service
   * @return csub31so
   * @throws Exception
   */
  private static CSUB31SO callCSUB31S_Retrieve(HttpServletRequest request, CSUB31SI csub31si, CaseMgmt caseMgmt)
                                                                                                                throws Exception {
    try {
      return caseMgmt.validatePlacementDetail(csub31si);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      if (errorCode == Messages.SQL_NOT_FOUND) {
        we.printStackTrace();
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      } else if (errorCode == Messages.MSG_NO_LOC_RECORDED) {
        we.printStackTrace();
        throw new ServiceException(Messages.MSG_NO_LOC_RECORDED);
      }
      throw we;
    }
  }

  public static CSUB25SOG00 getCurrentlySavedValues(HttpServletRequest request, CaseMgmt caseMgmt) throws Exception {
    if ((PageModeConstants.NEW.equals(PageMode.getPageMode(request)))
        || (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request)))) {
      return new CSUB25SOG00();
    }
    CSUB25SO originalCsub25so = new CSUB25SO();
    //MR-057 APPLA changes. Add the person Connected list to the csub25so object after setting the person connected list
    APPLAPersonsConnectedRetrieveSI APPLAPersonsConnectedRetrieveSI = populateAPPLAPersonsConnectedRetrieveSI_Retrieve(request);
    APPLAPersonsConnectedRetrieveSO APPLAPersonsConnectedRetrieveSO =  caseMgmt.retrievePersonsConnected(APPLAPersonsConnectedRetrieveSI);
    CSUB25SOG02_ARRAY personConnectedList = APPLAPersonsConnectedRetrieveSO.getPersonConnectedList();
    originalCsub25so.setCSUB25SOG02_ARRAY(personConnectedList);
    
    // get currently saved values;
    CSUB25SI csub25si = populateCSUB25SI_Retrieve(request);
    originalCsub25so = caseMgmt.retrievePlacementDetail(csub25si);

    return originalCsub25so.getCSUB25SOG00();
  }

  /**
   * This will populate the csub25si object with the Event, Stage, and Person ID's
   * 
   * @param request
   *          The HTTP Servlet Request
   * @return csub25si
   */
  private static CSUB25SI populateCSUB25SI_Retrieve(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);

    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(getUserLogonID(request));

    CSUB25SI csub25si = new CSUB25SI();
    csub25si.setArchInputStruct(input);
    csub25si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    csub25si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub25si.setUlIdPerson(getUserID(request));
    
    return csub25si;
  }

  /**
   * This will populate the csub31si object.
   * 
   * @param request
   *          The HTTP Servlet Request
   * @return csub31si
   */
  private static CSUB31SI populateCSUB31SI_Retrieve(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);

    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(getUserLogonID(request));

    CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);

    CSUB31SI csub31si = new CSUB31SI();
    int idResource = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacil");
    csub31si.setArchInputStruct(input);
    csub31si.setUlIdResource(idResource);
    csub31si.setSzAddrPlcmtCnty(aapBean.getCounty());
    csub31si.setSzCdRsrcFacilType(ContextHelper.getStringSafe(request, "selSzCdPlcmtLivArr"));
    csub31si.setSzCdPlcmtType(ContextHelper.getStringSafe(request, "selSzCdPlcmtType"));
    csub31si.setUlIdPlcmtChild(csub25so.getCSUB25SOG00().getUlIdPlcmtChild());
    csub31si.setDtDtPlcmtStart(ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtStart"));
    csub31si.setCIndPlcmetEmerg(ContextHelper.getStringSafe(request, "cbxCIndPlcmetEmerg"));
    csub31si.setSzCdTempPlcmtType(ContextHelper.getStringSafe(request, "szCdTempPlcmtType"));
    csub31si.setUlIdWaiver(ContextHelper.getIntSafe(request, "dspUlWaiverId"));
    csub31si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub31si.setUlIdPlcmtEvent(GlobalData.getUlIdEvent(request));

    return csub31si;
  }

  /**
   * Populate the csub26si object for saving.
   * 
   * @param request
   *          The HTTP Servlet Request
   * @return csub26si
   * @throws Exception
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  private static CSUB26SI populateCSUB26SI_Save(HttpServletRequest request, CaseMgmt caseMgmt, boolean bSaveIsPressed) throws Exception {
    CSUB25SOG00 originalPlacementDetail = getCurrentlySavedValues(request, caseMgmt);

    BaseSessionStateManager state = getSessionStateManager(request);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    ArchInputStruct input = new ArchInputStruct();
    CSUB26SI csub26si = new CSUB26SI();
    CSUB26SIG00 placementDetail = new CSUB26SIG00();
    SzCdEventStatus_ARRAY_CSUB26SI eventStatusArray = new SzCdEventStatus_ARRAY_CSUB26SI();
    ROWCCMN01UIG00 eventDetail = new ROWCCMN01UIG00();
    UlIdEvent_ARRAY eventIDArray = new UlIdEvent_ARRAY();
    String szCdStage = GlobalData.getSzCdStage(request);

    CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
    CSUB25SOG00 outPlacementDetail = csub25so.getCSUB25SOG00();

    boolean bSaveandSubmit = ContextHelper.getString(request, "btnSaveAndSubmit.x") != null;
    boolean bSave = ContextHelper.getString(request, "btnSave.x") != null;

    CSUB31SO csub31so = new CSUB31SO();
    //STGAP00009517: Getting the next two fields to find if it is coming back from clicking
    //ok on the pop-up Gap message
    String indReturnFromGapMessage = ContextHelper.getStringSafe(request, "hdnBSysIndPrfrmValidation");
    boolean hdnBSaveIsPressed = ContextHelper.getBooleanSafe(request, "hdnBSaveIsPressed");
    String placeType = ContextHelper.getStringSafe(request, "selSzCdPlcmtType");
    Date dtPlaceStart = ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtStart");
    String tmPlcmtStart = ContextHelper.getTimeSafe(request, "txtDtTmPlcmtStart");

    if (!DateHelper.isNull(dtPlaceStart) && !(StringHelper.EMPTY_STRING).equals(tmPlcmtStart)) {
      dtPlaceStart = DateHelper.toJavaDateSafe(dtPlaceStart, tmPlcmtStart);
    }

    int idContract = originalPlacementDetail.getUlIdContract(); // 23545 changed from outPlacementDetail
    int idPlcmtAdult = outPlacementDetail.getUlIdPlcmtAdult();

    String plcmtService = outPlacementDetail.getSzCdPlcmtService();
    String plcmtLocMatch = N;

    // Even if we are closing home right away, if this is the first time we are saving it,
    // we need to validate the contract otherwise the contract id will not get retrieved.
    boolean isExistingPlacement = (GlobalData.getUlIdEvent(request) != 0);
    boolean isClosing = true;
    boolean didPlacementContractChange = didPlacementContractChange(request, originalPlacementDetail);
    boolean specialModAccess = false;
    boolean type_contracted_institutional = false;
    boolean type_nonpaid_facility = false;
    if(user.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT)){
      specialModAccess = true;
    }
    //STGAP00006420: If the user has the special access to modify
    //Approved placements an indicator is set using which the user 
    //will be given access to modify fields of an approved placement.
    if(specialModAccess && didPlacementContractChange){
      csub26si.setBIndSpecialAccess(ArchitectureConstants.Y);
    }
    //STGAP00006533: Modified code to eliminate code type CATTEMP
    String szCdActAtt = ContextHelper.getStringSafe(request, "selSzCdActAtt");
    if (CodesTables.CPLCMTAC_P.equals(szCdActAtt)) {
      isClosing = true;
    } else if (CodesTables.CPLCMTAC_A.equals(szCdActAtt)) {
       isClosing = false;
    }
    // SMS #81140: MR-074
    // Group Home (TYPE_GROUP_HOME condition below) has been end-dated as of Release 4.1 and is replaced by CCI. 
    // Also, data conversion to update Placement Type from Group Home to CCI has been submitted
    // However, it is no harm to keep Group Home in the code below because it will not break the logic.
    // This can be kept until we can verify the data conversion effort cleaned up the existing Group Home value.
    if (TYPE_CPA_FAMILY_FOSTER_HOME.equals(placeType) || TYPE_CCI_FAMILY_FOSTER_HOME.equals(placeType)
                    || TYPE_EMERGENCY_SHELTER.equals(placeType) || TYPE_GROUP_HOME.equals(placeType)
                    || TYPE_CHILD_CARE_INSTITUTION.equals(placeType) || TYPE_SPECIALIZED_FOSTER_HOME.equals(placeType)) {
                  type_contracted_institutional = true;

                }
    if (TYPE_HOSPITAL.equals(placeType) || TYPE_YDC.equals(placeType) || TYPE_OTHER_RESOURCE.equals(placeType) || TYPE_OTHER_ADOPTIVE_HOME.equals(placeType)) {//mxpatel 12392
      type_nonpaid_facility = true;

    }
    //Mr-004
    String evtStatus = csub25so.getROWCCMN01UIG00().getSzCdEventStatus();
   if (!isClosing
        && (!CodesTables.CEVTSTAT_APRV.equals(evtStatus) || (ArchitectureConstants.Y
                                                                                    .equals(csub26si
                                                                                                    .getBIndSpecialAccess()) && didPlacementContractChange))) {
      CSUB31SI csub31si = populateCSUB31SI_Retrieve(request);
      csub31so = callCSUB31S_Retrieve(request, csub31si, caseMgmt);
      if (type_contracted_institutional && didPlacementContractChange && Y.equals(csub31so.getBSysIndHomeHist())) {
        throw new ServiceException(Messages.MSG_PLACE_DATE_RANGE);
      }
    }
    if (specialModAccess || (bSaveandSubmit
        && !isClosing
        && (!CodesTables.CEVTSTAT_APRV.equals(evtStatus) || (ArchitectureConstants.Y
                                                                                    .equals(csub26si
                                                                                                    .getBIndSpecialAccess()) && didPlacementContractChange)))) {
      if (Y.equals(csub31so.getBSysIndNoDOBFound())) {
        throw new ServiceException(Messages.MSG_CHILD_DOB_REQUIRED);
      }
      if (ArchitectureConstants.Y.equals(csub31so.getCSysIndChildUnder12())) {
        throw new ServiceException(Messages.MSG_PLCMT_CHILD_12_GROUP);
      }
      if (ArchitectureConstants.Y.equals(csub31so.getCSysIndRsCapacity())) {
        throw new ServiceException(Messages.MSG_PLCMT_HOME_LIC_CAP);
      }
      if (ArchitectureConstants.Y.equals(csub31so.getCSysIndChildUnder2or3())) {
        throw new ServiceException(Messages.MSG_PLCMT_HOME_LIC_CH_AGE);
      }
    }
    //STGAP0001128 if save and submit was pressed and we are removing the child
    //from an approved adoptive placement the disruption narrative must be completed.
    String selSzCdPlcmtRemovalRsn = ContextHelper.getStringSafe(request, "selSzCdPlcmtRemovalRsn");
    //STGAP00012404 - Added ADO stage check
    if (TYPE_ADOPTIVE_HOME.equals(placeType) && (CodesTables.CEVTSTAT_APRV.equals(evtStatus)|| CodesTables.CEVTSTAT_COMP.equals(evtStatus))&& 
                StringHelper.isValid(selSzCdPlcmtRemovalRsn) &&  
                !CodesTables.CRMRSNAC_ADF.equals(selSzCdPlcmtRemovalRsn) &&
                        state.getAttribute("adoDisruptNarrExists", request) == null &&
                        ADOPT.equals(szCdStage)
          ) 
    {
                request.setAttribute("unSuccessfulClosure", "Y");
                throw new ServiceException(Messages.MSG_DISRP_NARR_REQ);
    }
    //STGAP00006533: Modified code to eliminate code type CATTEMP
    placementDetail.setSzCdPlcmtActPlanned(szCdActAtt);
    int ulIdContactedBy = ContextHelper.getIntSafe(request, "hdnUlIdContactedBy");
    String szCdContactedBy = ContextHelper.getStringSafe(request, "szCdContactedBy");

    // If Staff Search is not performed then Contacted By defaults to the case manager user id.
    if (ulIdContactedBy == 0) {
      placementDetail.setUlIdContactedBy(user.getUserID());
      placementDetail.setSzCdPlcmtContactedBy(user.getUserFullName());
    } else {
      placementDetail.setUlIdContactedBy(ulIdContactedBy);
      placementDetail.setSzCdPlcmtContactedBy(szCdContactedBy);
    }

    String selSzCdMethod = ContextHelper.getStringSafe(request, "selSzCdMethod");
    placementDetail.setSzCdPlcmtContMethod(selSzCdMethod);
    String cbxIndTempReplacement = ContextHelper.getStringSafe(request, "cbxIndTempReplacement");
    placementDetail.setCIndPlcmtTempType(cbxIndTempReplacement);
    String szCdTempPlcmtType = ContextHelper.getStringSafe(request, "szCdTempPlcmtType");
    placementDetail.setSzCdPlcmtTempType(szCdTempPlcmtType);
    String szTxtTempPlcmtCmnts = ContextHelper.getStringSafe(request, "szTxtTempPlcmtCmnts");
    placementDetail.setSzTxtPlcmtTempCmmnts(szTxtTempPlcmtCmnts);
    String cbxIndWaiverRequired = ContextHelper.getStringSafe(request, "cbxIndWaiverRequired");
    placementDetail.setCIndWaiverReqd(cbxIndWaiverRequired);
    String rbIndCaseHome = ContextHelper.getStringSafe(request, "rbIndCaseHome");
    placementDetail.setSzCdWaivertype(rbIndCaseHome);
    int dspUlWaiverId = ContextHelper.getIntSafe(request, "dspUlWaiverId");
    placementDetail.setUlIdWaiver(dspUlWaiverId);
    org.exolab.castor.types.Date dtDateLastDischarged = ContextHelper.getCastorDateSafe(request, "dtDateLastDischarged");
    
    // STGAP00017058 - set placement certification info
    Map certInfoMap = new HashMap();
    
    // get parameters from request
    int ulIdCaseMngrCert = ContextHelper.getIntSafe(request, "hdnDspCaseManagerId");
    int ulIdSupCert = ContextHelper.getIntSafe(request, "hdnDspSupId");
    int ulIdSupRsrc = ContextHelper.getIntSafe(request, "hdnDspSupervisorRsrcId");
    int ulIdCaseMngrRsrc = ContextHelper.getIntSafe(request, "hdnDspCaseManagerRsrcId");
    String nmCaseMngrRsrc = ContextHelper.getStringSafe(request, "hdnDspCaseManagerRsrcName"); // STGAP00017398: fixed CM and SUP resource name switched 
    String nmSupRsrc = ContextHelper.getStringSafe(request, "hdnDspSupervisorRsrcName");
    org.exolab.castor.types.Date dtCaseMngrCert = DateHelper.isValidDate(request.getParameter("hdnDtCaseMngrCert")) ? ContextHelper.getCastorDate(request, "hdnDtCaseMngrCert") : null;
    org.exolab.castor.types.Date dtSupCert = DateHelper.isValidDate(request.getParameter("hdnDtSupCert")) ? ContextHelper.getCastorDate(request, "hdnDtSupCert") : null;
    org.exolab.castor.types.Date hdnLastViewPlcmtLogDate = DateHelper.isValidDate(request.getParameter("hdnLastViewPlcmtLogDate")) ? ContextHelper.getCastorDate(request, "hdnLastViewPlcmtLogDate") : null;

    // set request parameters into struct
    placementDetail.setDtLastViewPlcmtLog(hdnLastViewPlcmtLogDate);
    placementDetail.setUlIdCaseMngrCert(ulIdCaseMngrCert);
    placementDetail.setUlIdSupCert(ulIdSupCert);
    placementDetail.setDtCaseMngrCert(dtCaseMngrCert);
    placementDetail.setDtSupCert(dtSupCert);
    placementDetail.setUlIdCaseMngrRsrc(ulIdCaseMngrRsrc);
    placementDetail.setUlIdSupRsrc(ulIdSupRsrc);
    placementDetail.setNmCaseMngrRsrc(nmCaseMngrRsrc);
    placementDetail.setNmSupRsrc(nmSupRsrc);
    
    // also store info into map to be placed into request in case the save errors out
    certInfoMap.put("hdnLastViewPlcmtLogDate", hdnLastViewPlcmtLogDate);
    certInfoMap.put("ulIdCaseMngrCert", ulIdCaseMngrCert);
    certInfoMap.put("ulIdSupCert", ulIdSupCert);
    certInfoMap.put("dtCaseMngrCert", dtCaseMngrCert);
    certInfoMap.put("dtSupCert", dtSupCert);
    certInfoMap.put("nmSupRsrc", nmSupRsrc);
    certInfoMap.put("nmCaseMngrRsrc", nmCaseMngrRsrc);
    certInfoMap.put("ulIdSupRsrc", ulIdSupRsrc);
    certInfoMap.put("ulIdCaseMngrRsrc", ulIdCaseMngrRsrc);
    state.setAttribute("certInfoMap", certInfoMap, request);
    
    // if the case manager's id and the date certified are valid, then the certification checkbox has been selected
    if(ulIdCaseMngrCert != 0 && dtCaseMngrCert != null){
      placementDetail.setIndCaseMngrCert(ArchitectureConstants.Y);
    }else{
      placementDetail.setIndCaseMngrCert(ArchitectureConstants.N);
    }
    
    // if the supervisor's id and the date certified are valid, then the certification checkbox has been selected
    if(ulIdSupCert != 0 && dtSupCert != null){
      placementDetail.setIndSupCert(ArchitectureConstants.Y);
    }else{
      placementDetail.setIndSupCert(ArchitectureConstants.N);
    }
    // End STGAP00017058
    
    placementDetail.setDtDtLastDischarged(dtDateLastDischarged);
    String ulMatch = ContextHelper.getStringSafe(request, "ulMatch");
    placementDetail.setSzCdMatch(ulMatch);
    org.exolab.castor.types.Date dtPermReportDueDate = ContextHelper.getCastorDateSafe(request, "dtPermReportDueDate");
    placementDetail.setDtDtPlcmtPermDue(dtPermReportDueDate);
    String cbxBoardingCounty = ContextHelper.getStringSafe(request, "cbxBoardingCounty");
    placementDetail.setSzCdBrdngCnty(cbxBoardingCounty);
    String cbxIndTrialHomeVisit = ContextHelper.getStringSafe(request, "cbxIndTrialHomeVisit");
    placementDetail.setCIndTrialHomeVisit(cbxIndTrialHomeVisit);
    org.exolab.castor.types.Date dtCrtBeginDate = ContextHelper.getCastorDateSafe(request, "dtCrtBeginDate");
    placementDetail.setDtDtCrtBegin(dtCrtBeginDate);
    org.exolab.castor.types.Date dtCrtEndDate = ContextHelper.getCastorDateSafe(request, "dtCrtEndDate");
    placementDetail.setDtDtCrtEnd(dtCrtEndDate);
    String rbIndPlcmtSafe = ContextHelper.getStringSafe(request, "rbIndPlcmtSafe");
    placementDetail.setCIndPlcmtSafe(rbIndPlcmtSafe);
    String rbIndPlcmtLeastRestrict = ContextHelper.getStringSafe(request, "rbIndPlcmtLeastRestrict");
    placementDetail.setCIndPlcmtRestr(rbIndPlcmtLeastRestrict);
    String rbIndPlcmtFamilyLike = ContextHelper.getStringSafe(request, "rbIndPlcmtFamilyLike");
    placementDetail.setCIndPlcmtFamLike(rbIndPlcmtFamilyLike);
    String rbIndPlcmtAppropriate = ContextHelper.getStringSafe(request, "rbIndPlcmtAppropriate");
    placementDetail.setCIndPlcmtAppr(rbIndPlcmtAppropriate);
    String rbIndPlcmtCloseProxPar = ContextHelper.getStringSafe(request, "rbIndPlcmtCloseProxPar");
    placementDetail.setCIndPlcmtProx(rbIndPlcmtCloseProxPar);
    String rbIndPlcmtCloseProxSchool = ContextHelper.getStringSafe(request, "rbIndPlcmtCloseProxSchool");
    placementDetail.setCIndPlcmtSchDist(rbIndPlcmtCloseProxSchool);
    String rbIndConsistent = ContextHelper.getStringSafe(request, "rbIndConsistent");
    placementDetail.setCIndPlcmtCasePlan(rbIndConsistent);
    String szTxtNoExplainCheckList = ContextHelper.getStringSafe(request, "szTxtNoExplainCheckList");
    placementDetail.setSzTxtPlcmtChkList(szTxtNoExplainCheckList);
    String rbIndExpTrauma = ContextHelper.getStringSafe(request, "rbIndExpTrauma");
    placementDetail.setCIndPlcmtTrauma(rbIndExpTrauma);
    String szTxtYesExpTrauma = ContextHelper.getStringSafe(request, "szTxtYesExpTrauma");
    placementDetail.setSzTxtPlcmtTrauma(szTxtYesExpTrauma);
    String rbIndStaySiblings = ContextHelper.getStringSafe(request, "rbIndStaySiblings");
    placementDetail.setCIndPlcmtSibling(rbIndStaySiblings);
    int nbrSibinCare = ContextHelper.getIntSafe(request, "nbrSibinCare");
    placementDetail.setNbrSibinCare(nbrSibinCare);
    int nbrSibPlaced = ContextHelper.getIntSafe(request, "nbrSibPlaced");
    placementDetail.setNbrSibPlaced(nbrSibPlaced);
    String szCdSibRsn = ContextHelper.getStringSafe(request, "selSzCdSibRsn");
    placementDetail.setSzCdSibRsn(szCdSibRsn);
    String szCdNoReasonCmnts = ContextHelper.getStringSafe(request, "szCdNoReasonCmnts");
    placementDetail.setSzTxtPlcmtSibling(szCdNoReasonCmnts);
    String rbIndPlcmtMatchCCFA = ContextHelper.getStringSafe(request, "rbIndPlcmtMatchCCFA");
    placementDetail.setCIndPlcmtCCFA(rbIndPlcmtMatchCCFA);
    String szCdCCFARsn = ContextHelper.getStringSafe(request, "selSzCdCCFARsn");
    placementDetail.setSzCdPlcmtCCFA(szCdCCFARsn);
    String szCdPlcmtMatchCCFAReasonCmnts = ContextHelper.getStringSafe(request, "szCdPlcmtMatchCCFAReasonCmnts");
    placementDetail.setSzTxtPlcmtCCFA(szCdPlcmtMatchCCFAReasonCmnts);
    String szCdChildTransitionCmnts = ContextHelper.getStringSafe(request, "szCdChildTransitionCmnts");
    placementDetail.setSzCdChildTransitionCmnts(szCdChildTransitionCmnts);
    String rbIndSuppSupervision = ContextHelper.getStringSafe(request, "rbIndSuppSupervision");
    placementDetail.setCIndPlcmtSpvsn(rbIndSuppSupervision);
    String szCdSuppSupervisionCmnts = ContextHelper.getStringSafe(request, "szCdSuppSupervisionCmnts");
    placementDetail.setSzTxtPlcmtSpvsn(szCdSuppSupervisionCmnts);
    org.exolab.castor.types.Date txtDtPsychInfo = ContextHelper.getCastorDateSafe(request, "txtDtPsychInfo");
    String txtSzNmPsychinfo = ContextHelper.getStringSafe(request, "txtSzNmPsychinfo");
    placementDetail.setDtDtPsychInfo(txtDtPsychInfo);
    placementDetail.setSzTxtPsychInfoCont(txtSzNmPsychinfo);
    org.exolab.castor.types.Date txtDtCasePsychInfo = ContextHelper.getCastorDateSafe(request, "txtDtCasePsychInfo");
    String txtSzNmCasePsychinfo = ContextHelper.getStringSafe(request, "txtSzNmCasePsychinfo");
    placementDetail.setDtDtPsychCPInfo(txtDtCasePsychInfo);
    placementDetail.setSzTxtPsychCPInfoCont(txtSzNmCasePsychinfo);
    org.exolab.castor.types.Date txtDtMedInfo = ContextHelper.getCastorDateSafe(request, "txtDtMedInfo");
    String txtSzNmMedinfo = ContextHelper.getStringSafe(request, "txtSzNmMedinfo");
    placementDetail.setDtDtMedInfo(txtDtMedInfo);
    placementDetail.setSzTxtMedInfoCont(txtSzNmMedinfo);
    org.exolab.castor.types.Date txtDtCaseMedInfo = ContextHelper.getCastorDateSafe(request, "txtDtCaseMedInfo");
    String txtSzNmCaseMedinfo = ContextHelper.getStringSafe(request, "txtSzNmCaseMedinfo");
    placementDetail.setDtDtMedCPInfo(txtDtCaseMedInfo);
    placementDetail.setSzTxtMedCPInfoCont(txtSzNmCaseMedinfo);
    org.exolab.castor.types.Date txtDtEduInfo = ContextHelper.getCastorDateSafe(request, "txtDtEduInfo");
    String txtSzNmEduinfo = ContextHelper.getStringSafe(request, "txtSzNmEduinfo");
    String cbxIndNAEduInfo = ContextHelper.getStringSafe(request, "cbxIndNAEduInfo");
    if (Y.equals((ContextHelper.getStringSafe(request, "cbxIndNAEduInfo")))) {
      txtDtEduInfo = null;
    }
    placementDetail.setDtDtEduInfo(txtDtEduInfo);
    placementDetail.setSzTxtEduInfoCont(txtSzNmEduinfo);
    placementDetail.setCIndEduInfoNA(cbxIndNAEduInfo);
    org.exolab.castor.types.Date txtDtCaseEduInfo = ContextHelper.getCastorDateSafe(request, "txtDtCaseEduInfo");
    String txtSzNmCaseEduinfo = ContextHelper.getStringSafe(request, "txtSzNmCaseEduinfo");
    String cbxIndNACaseEduInfo = ContextHelper.getStringSafe(request, "cbxIndNACaseEduInfo");
    if (Y.equals((ContextHelper.getStringSafe(request, "setCIndEduInfoNA")))) {
      txtDtCaseEduInfo = null;
    }
    placementDetail.setDtDtEduCPInfo(txtDtCaseEduInfo);
    placementDetail.setSzTxtEduCPInfoCont(txtSzNmCaseEduinfo);
    placementDetail.setCIndEduCPInfoNA(cbxIndNACaseEduInfo);
    String txtaSzTxtPlcmtCmntsDocuments = ContextHelper.getStringSafe(request, "txtaSzTxtPlcmtCmntsDocuments");
    placementDetail.setSzTxtAddtnlDoc(txtaSzTxtPlcmtCmntsDocuments);
    // SMS #81140: MR-074 If ADO, use hidden variables for enabling automation on the Placement page
    String rbIndPlcmtChPlacedFr = "";
    String rbIndPlcmtChPlacedBy = "";
    
    if (POST_ADOPT.equals(szCdStage)) {
      rbIndPlcmtChPlacedFr = ContextHelper.getStringSafe(request, "rbIndPlcmtChPlacedFr");
      rbIndPlcmtChPlacedBy = ContextHelper.getStringSafe(request, "rbIndPlcmtChPlacedBy");
    } else if (ADOPT.equals(szCdStage)) {
      rbIndPlcmtChPlacedFr = ContextHelper.getStringSafe(request, "hdnRbIndPlcmtChPlacedFr");
      rbIndPlcmtChPlacedBy = ContextHelper.getStringSafe(request, "hdnRbIndPlcmtChPlacedBy");
    }
    
    // String[] placementAdoInfoCbx = CheckboxHelper.getCheckedValues(request, "cbxAdoPlaceInfo");
    String cbxAdoPlaceInfo1 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo1");
    String cbxAdoPlaceInfo2 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo2");
    String cbxAdoPlaceInfo3 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo3");
    String cbxAdoPlaceInfo4 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo4");
    placementDetail.setCIndPlcmtChPlacedFr(rbIndPlcmtChPlacedFr);
    placementDetail.setCIndPlcmtChPlacedBy(rbIndPlcmtChPlacedBy);
    placementDetail.setSzCdAdoPlaceInfo1(cbxAdoPlaceInfo1);
    placementDetail.setSzCdAdoPlaceInfo2(cbxAdoPlaceInfo2);
    placementDetail.setSzCdAdoPlaceInfo3(cbxAdoPlaceInfo3);
    placementDetail.setSzCdAdoPlaceInfo4(cbxAdoPlaceInfo4);
    placementDetail.setDtDtPlcmtStart(dtPlaceStart);
    //STGAP00007457: need to save the temporary type field into the 
    //IndPlcmtEmerg in the placement table.Hence commented out the code and 
    //added the next 3 lines.
    String cbxIndTempPlacement = ContextHelper.getStringSafe(request,"cbxIndTempReplacement");
    if(!ArchitectureConstants.Y.equals(cbxIndTempPlacement)){
      cbxIndTempPlacement = ArchitectureConstants.N;
    }
    placementDetail.setCIndPlcmetEmerg(cbxIndTempPlacement);
    placementDetail.setSzCdPlcmtType(ContextHelper.getStringSafe(request, "selSzCdPlcmtType"));
    // Non Paid can have values enterd in so, we check here to see where we're supposed
    // to grab the facil and agency data.
    String nmAgency = ContextHelper.getStringSafe(request, "dspSzNmPlcmtAgency");
    int idAgency = ContextHelper.getIntSafe(request, "dspUlIdRsrcAgency");
    String nmFacil = ContextHelper.getStringSafe(request, "dspSzNmPlcmtFacil");
    int idFacil = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacil");

    if (type_nonpaid_facility) {
      if (!(StringHelper.EMPTY_STRING).equals(ContextHelper.getStringSafe(request, "txtSzNmPlcmtAgencyPaid"))) {
        nmAgency = ContextHelper.getStringSafe(request, "txtSzNmPlcmtAgencyPaid");
      }
      if (ContextHelper.getIntSafe(request, "dspUlIdRsrcAgencyPaid") != 0) {
        idAgency = ContextHelper.getIntSafe(request, "dspUlIdRsrcAgencyPaid");
      }
      if (!(StringHelper.EMPTY_STRING).equals(ContextHelper.getStringSafe(request, "txtSzNmPlcmtFacilPaid"))) {
        nmFacil = ContextHelper.getStringSafe(request, "txtSzNmPlcmtFacilPaid");
      }
      if (ContextHelper.getIntSafe(request, "dspUlIdRsrcFacilPaid") != 0) {
        idFacil = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacilPaid");
      }
    }
    placementDetail.setSzNmPlcmtAgency(nmAgency);
    placementDetail.setUlIdRsrcAgency(idAgency);
    placementDetail.setSzNmPlcmtFacil(nmFacil);
    placementDetail.setUlIdRsrcFacil(idFacil);
    placementDetail.setUlIdRsrcFacilOriginal(originalPlacementDetail.getUlIdRsrcFacil());
    placementDetail.setSzNmPlcmtPersonFull(ContextHelper.getStringSafe(request, "dspSzNmPlcmtPersonFull"));
    csub26si.setCSUB26SIG01(populatePlacementInfo_CSUB26SIG01(request));
    placementDetail.setSzNmPlcmtContact(ContextHelper.getStringSafe(request, "txtSzNmPlcmtContact"));
    placementDetail.setDtDtPlcmtPreplaceVisit(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtPreplaceVisit"));
    placementDetail.setDtDtPlcmtParentsNotif(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtParentsNotif"));
    placementDetail.setDtDtPlcmtChildDiscuss(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtChildDiscuss"));
    placementDetail.setDtDtPlcmtCaregvrDiscuss(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtCaregvrDiscuss"));
    placementDetail.setSzTxtPlcmtDiscussion(ContextHelper.getStringSafe(request, "txtaSzTxtPlcmtDiscussion"));
    placementDetail.setSzTxtPlcmtDocuments(ContextHelper.getStringSafe(request, "txtSzTxtPlcmtDocuments"));
    Date dtPlaceEnd = ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtEnd");
    String tmPlcmtEnd = ContextHelper.getTimeSafe(request, "txtDtTmPlcmtEnd");
    if (!DateHelper.isNull(dtPlaceEnd) && !(StringHelper.EMPTY_STRING).equals(tmPlcmtEnd)) {
      dtPlaceEnd = DateHelper.toJavaDateSafe(dtPlaceEnd, tmPlcmtEnd);
    }
    placementDetail.setDtDtPlcmtEnd(dtPlaceEnd);
    placementDetail.setSzCdPlcmtRemovalRsn(ContextHelper.getStringSafe(request, "selSzCdPlcmtRemovalRsn"));
    placementDetail.setSzTxtPlcmtRemovalRsn(ContextHelper.getStringSafe(request, "txtaSzTxtPlcmtRemovalRsn"));
    placementDetail.setCIndPlcmtContCntct(ContextHelper.getStringSafe(request, "cbxCIndPlcmtContCntct"));
    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);
    placementDetail.setSzNbrPlcmtTelephone(aapBean.getPhone());
    placementDetail.setSzNbrPlcmtPhoneExt(aapBean.getPhoneExt());
    placementDetail.setSzAddrPlcmtLn1(aapBean.getAddress1());
    placementDetail.setSzAddrPlcmtLn2(aapBean.getAddress2());
    placementDetail.setSzAddrPlcmtCity(aapBean.getCity());
    placementDetail.setSzAddrPlcmtSt(aapBean.getState());
    placementDetail.setSzAddrPlcmtZip(aapBean.getZipAndSuff());
    placementDetail.setSzAddrPlcmtCnty(aapBean.getCounty());
    placementDetail.setSzTxtPlcmtAddrComment(aapBean.getComments());
    //STGAP00006533: Modified code to eliminate code type CATTEMP
    placementDetail.setSzCdPlcmtActPlanned(szCdActAtt);
    placementDetail.setSzCdPlcmtService(plcmtService);
    placementDetail.setTsLastUpdate(outPlacementDetail.getTsLastUpdate());
    placementDetail.setUlIdContract(idContract);
    placementDetail.setUlIdPlcmtAdult(idPlcmtAdult);
    placementDetail.setUlIdPlcmtChild(outPlacementDetail.getUlIdPlcmtChild());
    
    //MR-057 Added new fields for APPLA changes
    placementDetail.setCIndLTFCPlacement(ContextHelper.getStringSafe(request, "rbIndLTFCPlacement"));
    placementDetail.setDtDtAgreementSigned(ContextHelper.getCastorDateSafe(request, "dtAgreementSigned"));
    placementDetail.setCIndConnectedAdult(ContextHelper.getStringSafe(request, "rbIndChildConnectedToAdult"));
    String szIdPersonConnected = ContextHelper.getStringSafe(request, "szCdPersonConnected");
    if (!"".equals(szIdPersonConnected)) {
      int ulIdPersonConnected = Integer.parseInt(szIdPersonConnected); 
      placementDetail.setUlIdPersonConnected(ulIdPersonConnected);
    }
    
    csub26si.setCSUB26SIG00(placementDetail);
    eventDetail.setSzCdTask(GlobalData.getSzCdTask(request));
    Date eventTimeStamp = csub25so.getROWCCMN01UIG00().getTsLastUpdate();
    eventDetail.setTsLastUpdate(eventTimeStamp);
    String eventStatus;
    //
    // SIR 17233 - event status should remain PEND, if we're in Approver Mode
    //STGAP00009517: Added additional check to set the event status to pending if coming back
    //by clicking ok on the Gap message and the button pressed is save and submit.
    if ((!hdnBSaveIsPressed && ArchitectureConstants.N.equals(indReturnFromGapMessage)) || (bSaveandSubmit) || (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request)))) {
      eventStatus = STATUS_PENDING;
    } else if (STATUS_APPROVED.equals(csub25so.getROWCCMN01UIG00().getSzCdEventStatus())) {
      eventStatus = STATUS_APPROVED;
    } else {
      eventStatus = STATUS_COMPLETE;
    }
    eventDetail.setSzCdEventStatus(eventStatus);
    eventDetail.setSzCdEventType(PLACEMENT_EVENT_TYPE);
    org.exolab.castor.types.Date eventOccured = ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtStart");
    if (ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtEnd") != null) {
      eventOccured = ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtEnd");
    }
    eventDetail.setDtDtEventOccurred(eventOccured);
    eventDetail.setUlIdEvent(csub25so.getROWCCMN01UIG00().getUlIdEvent());
    eventDetail.setUlIdStage(GlobalData.getUlIdStage(request));
    eventDetail.setUlIdPerson(getUserID(request));
    eventDetail.setSzTxtEventDescr(generateEventDescr(request));
    String currEventStatus = csub25so.getROWCCMN01UIG00().getSzCdEventStatus();
    String indGen = N;
    String newPlcmt = N;
    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))
        || PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      newPlcmt = Y;
      if (bSave) {
        indGen = Y;
        currEventStatus = StringHelper.EMPTY_STRING;
      }
    }
    csub26si.setBSysIndGeneric(indGen);
    csub26si.setBSysIndPrfrmValidation(ContextHelper.getStringSafe(request, "hdnBSysIndPrfrmValidation"));

    String indAddrChng = Y;
    if ((aapBean.getAddress1().equals(outPlacementDetail.getSzAddrPlcmtLn1()))) {
      indAddrChng = N;
    }
    csub26si.setCSysIndPlcmtChgAdrAdm(indAddrChng);
    String indMedAdr = N;
    if (PLACE_INFO_MED_DIF.equals((csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(0)))) {
      indMedAdr = Y;
    }
    csub26si.setBIndSavePressed(bSaveIsPressed);
    csub26si.setCSysIndPlcmtDifMedAdr(indMedAdr);
    csub26si.setCSysIndPlcmtLocMatch(plcmtLocMatch);
    csub26si.setSysIndNewActualPlcmt(newPlcmt);
    String indRemPlcmt = N;
    if (placementDetail.getDtDtPlcmtEnd() != null && DateHelper.isNull(originalPlacementDetail.getDtDtPlcmtEnd())) {
      indRemPlcmt = Y;
    }
    csub26si.setSysIndNewRemovalPlcmt(indRemPlcmt);
    csub26si.setSzCdStage(GlobalData.getSzCdStage(request));
    csub26si.setSzNmStage(GlobalData.getSzNmStage(request));
    csub26si.setUlIdCase(GlobalData.getUlIdCase(request));
    eventStatusArray.addSzCdEventStatus(CURRENT, currEventStatus);
    String eventStatusNext = eventDetail.getSzCdEventStatus();
    if ((bSaveandSubmit)) {
      eventStatusNext = STATUS_COMPLETE;
    }
    // SIR 17233 - event status should remain PEND, if we're in Approver Mode
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      eventStatusNext = STATUS_PENDING;
    }
    eventStatusArray.addSzCdEventStatus(NEXT, eventStatusNext); // Next Event Status
    String closureStatus = csub25so.getSzCdEventStatus();
    // SIR 18571 - This should simply set what the current closure status is
    // Old code:
    // closureStatus = STATUS_PENDING.equals(closureStatus) && datesChanged(context) ?
    // STATUS_NEW : closureStatus;
    eventStatusArray.addSzCdEventStatus(CLOSURE_STATUS, closureStatus); // Closure Status
    csub26si.setSzCdEventStatus_ARRAY_CSUB26SI(eventStatusArray);
    eventIDArray.addUlIdEvent(CURRENT, 0); // Current - This will always be 0 due to sir 21130
    eventIDArray.addUlIdEvent(NEXT, csub25so.getUlIdEvent()); // Next -
    csub26si.setUlIdEvent_ARRAY(eventIDArray);
    String cReqFuncCD = ServiceConstants.REQ_FUNC_CD_UPDATE;
    if ((PageModeConstants.NEW.equals(PageMode.getPageMode(request))
         || PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request)) 
         || eventStatusArray.getSzCdEventStatus(CURRENT) == null || STATUS_NEW
                                                                              .equals(eventStatusArray
                                                                                                      .getSzCdEventStatus(CURRENT)))) {
      cReqFuncCD = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    input.setCReqFuncCd(cReqFuncCD);
    input.setSzUserId(getUserLogonID(request));
    //
    // SIR 17233 - set the flag indicating approver mode
    //
    if (CodesTables.CEVTSTAT_PEND.equals(eventStatusArray.getSzCdEventStatus(CURRENT))
        && !GlobalData.isApprovalMode(request)) {
      input.setUlSysNbrReserved1(ArchitectureConstants.N);
    }
    csub26si.setArchInputStruct(input);
    csub26si.setROWCCMN01UIG00(eventDetail);
    return csub26si;
  }

  /**
   * Populate the address/phone bean for display on the page.
   * 
   * @param request
   *          Contains the current request object data from jsps
   * @param placementDetail
   *          This is the CSUB25SOG00 ibject off of the CSUB25SO object we got from the retrieve service.
   */
  private static void populateAdminAddressPhoneSubmodule(HttpServletRequest request, CSUB25SOG00 placementDetail) {
    AdminAddressPhoneBean aapBean = new AdminAddressPhoneBean();
    aapBean.setPhone(placementDetail.getSzNbrPlcmtTelephone());
    aapBean.setPhoneExt(placementDetail.getSzNbrPlcmtPhoneExt());
    aapBean.setAddress1(placementDetail.getSzAddrPlcmtLn1());
    aapBean.setAddress2(placementDetail.getSzAddrPlcmtLn2());
    aapBean.setCity(placementDetail.getSzAddrPlcmtCity());
    aapBean.setState(placementDetail.getSzAddrPlcmtSt());
    aapBean.setZipAndSuff(placementDetail.getSzAddrPlcmtZip());
    aapBean.setCounty(placementDetail.getSzAddrPlcmtCnty());
    aapBean.setComments(placementDetail.getSzTxtPlcmtAddrComment());
    aapBean.addToRequest(request);
  }

  /**
   * This method will set the page mode
   * 
   * @param request
   *          The HTTP Servlet Request
   */
  private static void setPageMode(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
    CSUB25SOG00 placementInfo = csub25so.getCSUB25SOG00();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    String pageMode = PageMode.getPageMode(request);
    String eventStatus = csub25so.getROWCCMN01UIG00().getSzCdEventStatus();
    String eventStatusCurrent = csub25so.getSzCdEventStatus();
    // SIR 22916 Instead of checking supervisor access, check
    // has stage access b/c all users with stage access should
    // be able to modify the page.
    if (STATUS_APPROVED.equals(eventStatus)
        && (CaseUtility.hasStageAccess(user.getUserID(),GlobalData.getUlIdStage(request)))) {
      pageMode = PageModeConstants.MODIFY;
      
    }
    if (((STATUS_PENDING.equals(eventStatus)) || (STATUS_PENDING.equals(eventStatusCurrent)))
        && (!GlobalData.isApprovalMode(request))) {
      if(!hasInformationalMessage((MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL)),request)){
      setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
      setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }
    }
    PageMode.setPageMode(pageMode, request);
  }
 
  /**
   * This method will take the current csub25so apply the changes made on the page to the object. This will allow us to
   * navigate of the page and not lose our changes. This will also save the changes in case an error is returned when
   * trying to save.
   * 
   * @param request
   *          The HTTP Servlet Request
   */
  private static void resetCsub25so(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
    CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();
    Date dtPlaceStart = ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtStart");
    String tmPlcmtStart = ContextHelper.getTimeSafe(request, "txtDtTmPlcmtStart");
    if (!DateHelper.isNull(dtPlaceStart) && !(StringHelper.EMPTY_STRING).equals(tmPlcmtStart)) {
      dtPlaceStart = DateHelper.toJavaDateSafe(dtPlaceStart, tmPlcmtStart);
    }
    placementDetail.setDtDtPlcmtStart(dtPlaceStart);
    //STGAP00007457: need to save the temporary type field into the 
    //IndPlcmtEmerg in the placement table.Hence commented out the code and 
    //added the next 3 lines.
    String cbxIndTempPlacement = ContextHelper.getStringSafe(request,"cbxIndTempReplacement");
    if(!ArchitectureConstants.Y.equals(cbxIndTempPlacement)){
      cbxIndTempPlacement = ArchitectureConstants.N;
    }
    placementDetail.setCIndPlcmetEmerg(cbxIndTempPlacement);
    placementDetail.setSzCdPlcmtType(ContextHelper.getStringSafe(request, "selSzCdPlcmtType"));
    csub25so.setDtDtPlcmtPermEff(ContextHelper.getCastorDateSafe(request, "dtPermReportDueDate"));
    String nmAgency = ContextHelper.getStringSafe(request, "dspSzNmPlcmtAgency");
    int idAgency = ContextHelper.getIntSafe(request, "dspUlIdRsrcAgency");
    String nmFacil = ContextHelper.getStringSafe(request, "dspSzNmPlcmtFacil");
    int idFacil = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacil");
    String placeType = ContextHelper.getStringSafe(request, "selSzCdPlcmtType");
    if ((TYPE_NON_PAID.equals(placeType))) {
      nmAgency = ContextHelper.getStringSafe(request, "txtSzNmPlcmtAgencyPaid");
      idAgency = ContextHelper.getIntSafe(request, "dspUlIdRsrcAgencyPaid");
      nmFacil = ContextHelper.getStringSafe(request, "txtSzNmPlcmtFacilPaid");
      idFacil = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacilPaid");
    }
    placementDetail.setSzNmPlcmtAgency(nmAgency);
    placementDetail.setUlIdRsrcAgency(idAgency);
    placementDetail.setSzNmPlcmtFacil(nmFacil);
    placementDetail.setUlIdRsrcFacil(idFacil);
    placementDetail.setSzNmPlcmtPersonFull(ContextHelper.getStringSafe(request, "dspSzNmPlcmtPersonFull"));
    placementDetail.setCIndPlcmtNoneApply(ContextHelper.getStringSafe(request, "cbxCIndPlcmtNoneApply"));
    csub25so.setCSUB25SOG01(populatePlacementInfo_CSUB25SOG01(request));
    placementDetail.setSzNmPlcmtContact(ContextHelper.getStringSafe(request, "txtSzNmPlcmtContact"));
    placementDetail.setDtDtPlcmtPreplaceVisit(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtPreplaceVisit"));
    placementDetail.setDtDtPlcmtParentsNotif(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtParentsNotif"));
    placementDetail.setDtDtPlcmtChildDiscuss(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtChildDiscuss"));
    placementDetail.setDtDtPlcmtCaregvrDiscuss(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtCaregvrDiscuss"));
    placementDetail.setSzTxtPlcmtDiscussion(ContextHelper.getStringSafe(request, "txtaSzTxtPlcmtDiscussion"));
    placementDetail.setCIndPlcmtSchoolDoc(ContextHelper.getStringSafe(request, "cbxCIndPlcmtSchoolDoc"));
    placementDetail.setDtDtPlcmtChildPlan(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtChildPlan"));
    placementDetail.setCIndPlcmtEducLog(ContextHelper.getStringSafe(request, "cbxCIndPlcmtEducLog"));
    placementDetail.setSzTxtPlcmtDocuments(ContextHelper.getStringSafe(request, "txtSzTxtPlcmtDocuments"));
    Date dtPlaceEnd = ContextHelper.getJavaDateSafe(request, "txtDtDtPlcmtEnd");
    String tmPlcmtEnd = ContextHelper.getTimeSafe(request, "txtDtTmPlcmtEnd");
    if (!DateHelper.isNull(dtPlaceEnd) && !(StringHelper.EMPTY_STRING).equals(tmPlcmtEnd)) {
      dtPlaceEnd = DateHelper.toJavaDateSafe(dtPlaceEnd, tmPlcmtEnd);
    }
    placementDetail.setDtDtPlcmtEnd(dtPlaceEnd);
    placementDetail.setSzCdPlcmtRemovalRsn(ContextHelper.getStringSafe(request, "selSzCdPlcmtRemovalRsn"));
    placementDetail.setSzTxtPlcmtRemovalRsn(ContextHelper.getStringSafe(request, "txtSzTxtPlcmtRemovalRsn"));
    placementDetail.setCIndPlcmtContCntct(ContextHelper.getStringSafe(request, "cbxCIndPlcmtContCntct"));
    // New fields
    String szCdActAtt = ContextHelper.getStringSafe(request, "selSzCdActAtt");
    //STGAP00006533: Modified code to eliminate code type CATTEMP
    //String plcmtPlanned = StringHelper.EMPTY_STRING;
    /*if (PLAC_ATT.equals(szCdActAtt)) {
      // Attempted
      plcmtPlanned = "P";
    } else if (PLAC_ACT.equals(szCdActAtt)) {
      // Actual
      plcmtPlanned = "A";
    }*/
    placementDetail.setSzCdPlcmtActPlanned(szCdActAtt);
    placementDetail.setSzCdPlcmtContactedBy(ContextHelper.getStringSafe(request, "szCdContactedBy"));
    placementDetail.setUlIdContactedBy(ContextHelper.getIntSafe(request, "hdnUlIdContactedBy"));
    placementDetail.setSzCdPlcmtContMethod(ContextHelper.getStringSafe(request, "selSzCdMethod"));
    placementDetail.setCIndPlcmtTempType(ContextHelper.getStringSafe(request, "cbxIndTempReplacement"));
    placementDetail.setSzCdPlcmtTempType(ContextHelper.getStringSafe(request, "szCdTempPlcmtType"));
    placementDetail.setSzTxtPlcmtTempCmmnts(ContextHelper.getStringSafe(request, "szTxtTempPlcmtCmnts"));
    placementDetail.setCIndWaiverReqd(ContextHelper.getStringSafe(request, "cbxIndWaiverRequired"));
    placementDetail.setSzCdWaivertype(ContextHelper.getStringSafe(request, "rbIndCaseHome"));
    placementDetail.setUlIdWaiver(ContextHelper.getIntSafe(request, "dspUlWaiverId"));
    placementDetail.setDtDtLastDischarged(ContextHelper.getCastorDateSafe(request, "dtDateLastDischarged"));
    placementDetail.setSzCdMatch(ContextHelper.getStringSafe(request, "ulMatch"));
    placementDetail.setDtDtPlcmtPermDue(ContextHelper.getCastorDateSafe(request, "dtPermReportDueDate"));
    placementDetail.setSzCdBrdngCnty(ContextHelper.getStringSafe(request, "cbxBoardingCounty"));
    placementDetail.setCIndTrialHomeVisit(ContextHelper.getStringSafe(request, "cbxIndTrialHomeVisit"));
    placementDetail.setDtDtCrtBegin(ContextHelper.getCastorDateSafe(request, "dtCrtBeginDate"));
    placementDetail.setDtDtCrtEnd(ContextHelper.getCastorDateSafe(request, "dtCrtEndDate"));
    placementDetail.setCIndPlcmtSafe(ContextHelper.getStringSafe(request, "rbIndPlcmtSafe"));
    placementDetail.setCIndPlcmtRestr(ContextHelper.getStringSafe(request, "rbIndPlcmtLeastRestrict"));
    placementDetail.setCIndPlcmtFamLike(ContextHelper.getStringSafe(request, "rbIndPlcmtFamilyLike"));
    placementDetail.setCIndPlcmtAppr(ContextHelper.getStringSafe(request, "rbIndPlcmtAppropriate"));
    placementDetail.setCIndPlcmtProx(ContextHelper.getStringSafe(request, "rbIndPlcmtCloseProxPar"));
    placementDetail.setCIndPlcmtSchDist(ContextHelper.getStringSafe(request, "rbIndPlcmtCloseProxSchool"));
    placementDetail.setCIndPlcmtCasePlan(ContextHelper.getStringSafe(request, "rbIndConsistent"));
    placementDetail.setSzTxtPlcmtChkList(ContextHelper.getStringSafe(request, "szTxtNoExplainCheckList"));
    placementDetail.setCIndPlcmtTrauma(ContextHelper.getStringSafe(request, "rbIndExpTrauma"));
    placementDetail.setSzTxtPlcmtTrauma(ContextHelper.getStringSafe(request, "szTxtYesExpTrauma"));
    placementDetail.setNbrSibinCare(ContextHelper.getIntSafe(request, "nbrSibinCare"));
    placementDetail.setNbrSibPlaced(ContextHelper.getIntSafe(request, "nbrSibPlaced"));
    placementDetail.setCIndPlcmtSibling(ContextHelper.getStringSafe(request, "rbIndStaySiblings"));
    placementDetail.setSzCdSibRsn(ContextHelper.getStringSafe(request, "selSzCdSibRsn"));
    placementDetail.setSzTxtPlcmtSibling(ContextHelper.getStringSafe(request, "szCdNoReasonCmnts"));
    placementDetail.setCIndPlcmtCCFA(ContextHelper.getStringSafe(request, "rbIndPlcmtMatchCCFA"));
    placementDetail.setSzCdPlcmtCCFA(ContextHelper.getStringSafe(request, "selSzCdCCFARsn"));
    placementDetail.setSzTxtPlcmtCCFA(ContextHelper.getStringSafe(request, "szCdPlcmtMatchCCFAReasonCmnts"));
    placementDetail.setSzCdChildTransitionCmnts(ContextHelper.getStringSafe(request, "szCdChildTransitionCmnts"));
    placementDetail.setCIndPlcmtSpvsn(ContextHelper.getStringSafe(request, "rbIndSuppSupervision"));
    placementDetail.setSzTxtPlcmtSpvsn(ContextHelper.getStringSafe(request, "szCdSuppSupervisionCmnts"));
    placementDetail.setDtDtPsychInfo(ContextHelper.getCastorDateSafe(request, "txtDtPsychInfo"));
    placementDetail.setSzTxtPsychInfoCont(ContextHelper.getStringSafe(request, "txtSzNmPsychinfo"));
    placementDetail.setDtDtPsychCPInfo(ContextHelper.getCastorDateSafe(request, "txtDtCasePsychInfo"));
    placementDetail.setSzTxtPsychCPInfoCont(ContextHelper.getStringSafe(request, "txtSzNmCasePsychinfo"));
    placementDetail.setDtDtMedInfo(ContextHelper.getCastorDateSafe(request, "txtDtMedInfo"));
    placementDetail.setSzTxtMedInfoCont(ContextHelper.getStringSafe(request, "txtSzNmMedinfo"));
    placementDetail.setDtDtMedCPInfo(ContextHelper.getCastorDateSafe(request, "txtDtCaseMedInfo"));
    placementDetail.setSzTxtMedCPInfoCont(ContextHelper.getStringSafe(request, "txtSzNmCaseMedinfo"));
    placementDetail.setDtDtEduInfo(ContextHelper.getCastorDateSafe(request, "txtDtEduInfo"));
    placementDetail.setSzTxtEduInfoCont(ContextHelper.getStringSafe(request, "txtSzNmEduinfo"));
    placementDetail.setCIndEduInfoNA(ContextHelper.getStringSafe(request, "cbxIndNAEduInfo"));
    placementDetail.setDtDtEduCPInfo(ContextHelper.getCastorDateSafe(request, "txtDtCaseEduInfo"));
    placementDetail.setSzTxtEduCPInfoCont(ContextHelper.getStringSafe(request, "txtSzNmCaseEduinfo"));
    placementDetail.setCIndEduCPInfoNA(ContextHelper.getStringSafe(request, "cbxIndNACaseEduInfo"));
    placementDetail.setSzTxtAddtnlDoc(ContextHelper.getStringSafe(request, "txtaSzTxtPlcmtCmntsDocuments"));
    
    // SMS #81140: MR-074 If ADO, use hidden variables for enabling automation on the Placement page
    String szCdStage = GlobalData.getSzCdStage(request);
    String rbIndPlcmtChPlacedFr = "";
    String rbIndPlcmtChPlacedBy = "";
    
    if (POST_ADOPT.equals(szCdStage)) {
      rbIndPlcmtChPlacedFr = ContextHelper.getStringSafe(request, "rbIndPlcmtChPlacedFr");
      rbIndPlcmtChPlacedBy = ContextHelper.getStringSafe(request, "rbIndPlcmtChPlacedBy");
    } else if (ADOPT.equals(szCdStage)) {
      rbIndPlcmtChPlacedFr = ContextHelper.getStringSafe(request, "hdnRbIndPlcmtChPlacedFr");
      rbIndPlcmtChPlacedBy = ContextHelper.getStringSafe(request, "hdnRbIndPlcmtChPlacedBy");
    }    
    placementDetail.setCIndPlcmtChPlacedFr(rbIndPlcmtChPlacedFr);
    placementDetail.setCIndPlcmtChPlacedBy(rbIndPlcmtChPlacedBy);
    
    String cbxAdoPlaceInfo1 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo1");
    String cbxAdoPlaceInfo2 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo2");
    String cbxAdoPlaceInfo3 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo3");
    String cbxAdoPlaceInfo4 = ContextHelper.getStringSafe(request, "cbxAdoPlaceInfo4");
    placementDetail.setSzCdAdoPlaceInfo1(cbxAdoPlaceInfo1);
    placementDetail.setSzCdAdoPlaceInfo2(cbxAdoPlaceInfo2);
    placementDetail.setSzCdAdoPlaceInfo3(cbxAdoPlaceInfo3);
    placementDetail.setSzCdAdoPlaceInfo4(cbxAdoPlaceInfo4);
    // End New fields
    AdminAddressPhoneBean aapBean = (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);
    placementDetail.setSzNbrPlcmtTelephone(aapBean.getPhone());
    placementDetail.setSzNbrPlcmtPhoneExt(aapBean.getPhoneExt());
    placementDetail.setSzAddrPlcmtLn1(aapBean.getAddress1());
    placementDetail.setSzAddrPlcmtLn2(aapBean.getAddress2());
    placementDetail.setSzAddrPlcmtCity(aapBean.getCity());
    placementDetail.setSzAddrPlcmtSt(aapBean.getState());
    placementDetail.setSzAddrPlcmtZip(aapBean.getZipAndSuff());
    placementDetail.setSzAddrPlcmtCnty(aapBean.getCounty());
    placementDetail.setSzTxtPlcmtAddrComment(aapBean.getComments());
    
    //MR-057 Added new fields for APPLA changes
    placementDetail.setCIndLTFCPlacement(ContextHelper.getStringSafe(request, "rbIndLTFCPlacement"));
    placementDetail.setDtDtAgreementSigned(ContextHelper.getCastorDateSafe(request, "dtAgreementSigned"));
    placementDetail.setCIndConnectedAdult(ContextHelper.getStringSafe(request, "rbIndChildConnectedToAdult"));
    String szIdPersonConnected = ContextHelper.getStringSafe(request, "szCdPersonConnected");
    if (!"".equals(szIdPersonConnected)) {
      int ulIdPersonConnected = Integer.parseInt(szIdPersonConnected); 
      placementDetail.setUlIdPersonConnected(ulIdPersonConnected);
    }
  }

  /**
   * This will take a csub25so and delete some values that are not tranfered in in the new using process.
   * 
   * @param request
   *          The HTTP Servlet Request
   * @param csub25so
   *          The retrieved object.
   * @return csub25so
   */
  private static CSUB25SO convertCsub25so_to_NewUsing(HttpServletRequest request, CSUB25SO csub25so) {
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 eventDetail = csub25so.getROWCCMN01UIG00();
    CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();
    GlobalData.setUlIdEvent(0, request);
    eventDetail.setUlIdEvent(0);
    eventDetail.setUlIdStage(0);
    eventDetail.setTsLastUpdate(null);
    eventDetail.setSzCdEventStatus(StringHelper.EMPTY_STRING);
    csub25so.setSzCdEventStatus(StringHelper.EMPTY_STRING);
    placementDetail.setTsLastUpdate(null);
    placementDetail.setDtDtPlcmtCaregvrDiscuss(null);
    placementDetail.setDtDtPlcmtChildDiscuss(null);
    placementDetail.setDtDtPlcmtChildPlan(null);
    placementDetail.setDtDtPlcmtEducLog(null);
    placementDetail.setDtDtPlcmtMeddevHistory(null);
    placementDetail.setDtDtPlcmtParentsNotif(null);
    placementDetail.setDtDtPlcmtPreplaceVisit(null);
    placementDetail.setDtDtPlcmtSchoolRecords(null);
    placementDetail.setCIndPlcmtEducLog(StringHelper.EMPTY_STRING);
    placementDetail.setCIndPlcmtSchoolDoc(StringHelper.EMPTY_STRING);
    placementDetail.setSzTxtPlcmtDiscussion(StringHelper.EMPTY_STRING);
    placementDetail.setSzTxtPlcmtDocuments(StringHelper.EMPTY_STRING);
    placementDetail.setSzCdPlcmtActPlanned(StringHelper.EMPTY_STRING);
    placementDetail.setSzCdPlcmtActAtt(StringHelper.EMPTY_STRING);
    placementDetail.setDtDtPlcmtEnd(null);
    placementDetail.setSzCdPlcmtRemovalRsn(StringHelper.EMPTY_STRING);
    placementDetail.setSzTxtPlcmtRemovalRsn(StringHelper.EMPTY_STRING);
    placementDetail.setCIndPlcmtContCntct(N);
    placementDetail.setUlIdContract(0);
    placementDetail.setSzCdPlcmtService(StringHelper.EMPTY_STRING);
    csub25so.getBIndBLOBExistsInDatabase_ARRAY().setBIndBLOBExistsInDatabase(0, N);
    csub25so.getBIndBLOBExistsInDatabase_ARRAY().setBIndBLOBExistsInDatabase(1, N);
    return csub25so;
  }

  /**
   * This will take a csub25so and confrim that certain values are null and set two item in the placement info section.
   * 
   * @param request
   *          The HTTP Servlet Request
   * @param csub25so
   *          The retrieved object.
   * @return csub25so
   */
  private static CSUB25SO convertCsub25so_to_New(HttpServletRequest request, CSUB25SO csub25so) {
    // If the stage is adopt or post adopt, at least one of the placed from and placde by
    // check boxes must be set.
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CSUB25SOG00 placementDetail = new CSUB25SOG00();
    placementDetail = csub25so.getCSUB25SOG00();
    placementDetail.setUlIdContactedBy(user.getUserID());
    placementDetail.setSzCdPlcmtContactedBy(user.getUserFullName());
    csub25so.setCSUB25SOG00(placementDetail);
    return csub25so;
  }

  /**
   * This method will determine if the Placement Contract Change flag shoudl be set to yes. This will be yes, if
   * Placement Type, Placement Name, or Living Arrangements have changed.
   * 
   * @param request
   *          The HTTP Servlet Request
   * @param placementDetail
   *          CSUB25SOG00
   * @return boolean
   */
  public static boolean didPlacementContractChange(HttpServletRequest request, CSUB25SOG00 placementDetail) {
    // if any are not equal, return true
    // trim the comparisons just in case there are extra spaces in the DB
    if (placementDetail != null) {
      String nmPlcmtAgency = placementDetail.getSzNmPlcmtAgency() == null ? "" : placementDetail.getSzNmPlcmtAgency()
                                                                                                .trim();
      String nmPlcmtFacil = placementDetail.getSzNmPlcmtFacil() == null ? "" : placementDetail.getSzNmPlcmtFacil()
                                                                                              .trim();
      String nmPlcmtPersonFull = placementDetail.getSzNmPlcmtPersonFull() == null ? ""
                                                                                 : placementDetail
                                                                                                  .getSzNmPlcmtPersonFull()
                                                                                                  .trim();
       String cdPlcmtType = placementDetail.getSzCdPlcmtType() == null ? "" : placementDetail.getSzCdPlcmtType().trim();
      return
      ((!ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtStart").equals(placementDetail.getDtDtPlcmtStart()))
       || (!ContextHelper.getStringSafe(request, "dspSzNmPlcmtAgency").equals(nmPlcmtAgency))
       || (!ContextHelper.getStringSafe(request, "dspSzNmPlcmtFacil").equals(nmPlcmtFacil))
       || (!ContextHelper.getStringSafe(request, "cbxIndTempReplacement").equals(FormattingHelper.formatString(placementDetail.getCIndPlcmetEmerg())))
       || (!ContextHelper.getStringSafe(request, "dspSzNmPlcmtPersonFull").equals(nmPlcmtPersonFull))
       || (!ContextHelper.getStringSafe(request, "selSzCdPlcmtType").equals(cdPlcmtType))
       || (!ContextHelper.getStringSafe(request, "txtSzNmPlcmtAgencyPaid").equals(nmPlcmtAgency))
       || (!ContextHelper.getStringSafe(request, "txtSzNmPlcmtFacilPaid").equals(nmPlcmtFacil))
       || (placementDetail.getUlIdRsrcAgency() != ContextHelper.getIntSafe(request, "dspUlIdRsrcAgency"))
       || (placementDetail.getUlIdRsrcAgency() != ContextHelper.getIntSafe(request, "dspUlIdRsrcAgencyPaid"))
       || (placementDetail.getUlIdRsrcFacil() != ContextHelper.getIntSafe(request, "dspUlIdRsrcFacil")) || (placementDetail
                                                                                                                           .getUlIdRsrcFacil() != ContextHelper
                                                                                                                                                               .getIntSafe(
                                                                                                                                                                           request,
                                                                                                                                                                           "dspUlIdRsrcFacilPaid")));// SIR
                                                                                                                                                                                                      // //
                                                                                                                                                                                                      // 23545
    } else {
      return true;
    }
  }

  /**
   * This method will structure the placement information checkboxes in the correct format. The serivice wants an array
   * with a place holder for each checkbox. Only those checkboxes that are checked will contain values.
   * 
   * @param request
   *          The request object to get data from jsps.
   * @return placementInfo csub26sig01
   */
  @SuppressWarnings({"unchecked"})
  private static CSUB26SIG01 populatePlacementInfo_CSUB26SIG01(HttpServletRequest request) {
    SzCdPlcmtInfo_ARRAY placementInfoArray = new SzCdPlcmtInfo_ARRAY();

    List placementInfoList = populatePlacementInfoList(request);
    Iterator iterator = placementInfoList.iterator();
    while (iterator.hasNext()) {
      String string = (String) iterator.next();
      placementInfoArray.addSzCdPlcmtInfo(string);
    }
    CSUB26SIG01 placementInfo = new CSUB26SIG01();
    placementInfo.setSzCdPlcmtInfo_ARRAY(placementInfoArray);

    return placementInfo;
  }

  /**
   * This method will structure the placement information checkboxes in the correct format. The serivice wants an array
   * with a place holder for each checkbox. Only those checkboxes that are checked will contain values.
   * 
   * @param request
   *          The request object to get data from jsps.
   * @return placementInfo csub25sog01
   */
  // notice this code looks very similar to populatePlacementInfo();
  // further refactoring can't be done unless placementInfo was interfaced
  @SuppressWarnings({"unchecked"})
  private static CSUB25SOG01 populatePlacementInfo_CSUB25SOG01(HttpServletRequest request) {
    gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPlcmtInfo_ARRAY placementInfoArray = new gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdPlcmtInfo_ARRAY();

    List placementInfoList = populatePlacementInfoList(request);
    Iterator iterator = placementInfoList.iterator();
    while (iterator.hasNext()) {
      String string = (String) iterator.next();
      placementInfoArray.addSzCdPlcmtInfo(string);
    }

    CSUB25SOG01 placementInfo = new CSUB25SOG01();
    placementInfo.setSzCdPlcmtInfo_ARRAY(placementInfoArray);

    return placementInfo;
  }

  /**
   * Return a list of strings in proper order to populate input/output objects
   * 
   * @param request
   *          The request object to get data from jsps.
   * @return placementInfo
   */
  @SuppressWarnings({"unchecked"})
  private static List populatePlacementInfoList(HttpServletRequest request) {
    List<String> placementInfo = new ArrayList<String>();

    String[] placementInfoCbx = CheckboxHelper.getCheckedValues(request, "cbxPlaceInfo");

    // Download the codestable so we can figure out how many codes are possible
    // and what order we need them in.
    Collection<String> ctPlaceInfoColl = null;
    try {
      ctPlaceInfoColl = Lookup.getCategoryCodesCollection(CodesTables.CPLCMTIN);
    } catch (Exception e) {
      // ignore errors
    }

    if (ctPlaceInfoColl == null) {
      ctPlaceInfoColl = new ArrayList<String>();
    }

    // Create a hash table to holder the code table values and their corresponding
    // indexes.
    Map<String, Integer> ctHash = new HashMap<String, Integer>();
    Iterator<String> ctIt = ctPlaceInfoColl.iterator();
    int j = 0;
    while (ctIt.hasNext()) {
      String col = ctIt.next();
      ctHash.put(col, j++);
    }

    // Generate an array the same size as the codetable with all fields being "".
    for (int i = 0; i < ctHash.size(); i++) {
      placementInfo.add(StringHelper.EMPTY_STRING);
    }

    // For all the values we got back from the checkboxes, use the hash table to get
    // the index, and place the value in that slot.
    for (int i = 0; i < placementInfoCbx.length; i++) {
      Integer index = (Integer) ctHash.get(placementInfoCbx[i]);
      // STGAP00006059 : Added null check to eliminate the null pointer exception
      if (index != null) {
        placementInfo.set(index, placementInfoCbx[i]);
      }
    }

    return placementInfo;
  }

  /**
   * This method will generate the Event Description
   * 
   * @param request
   *          The request object to get data from jsps.
   * @return eventDescr StringBuffer.toString()
   */
  private static String generateEventDescr(HttpServletRequest request) {
    StringBuffer eventDescr = new StringBuffer(0);
    boolean Actual = false;
    String szCdActAtt = ContextHelper.getStringSafe(request, "selSzCdActAtt");
    String name = null;
    //STGAP00006533: Replaced code type CATTEMP by CPLCMTAC
    if (CodesTables.CPLCMTAC_A.equals(szCdActAtt)) {
      // Attempted
      Actual = true;
    }
    String szCdStageName = GlobalData.getSzNmStage(request);

    String type = ContextHelper.getStringSafe(request, "selSzCdPlcmtType");
    if (Actual) {
      // Start Date<placement start date> End Date <placement end date OR
      // 15 spaces if no end date> <Person name OR Placement name> <Placement
      // Type>
      eventDescr.append("Start Date")
                .append(FormattingHelper.formatDate(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtStart")));

      org.exolab.castor.types.Date endDate = ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtEnd");
      if (DateHelper.isNull(endDate) == false) {
        eventDescr.append(" End Date ").append(FormattingHelper.formatDate(endDate)).append(" ");
      } else {
        eventDescr.append("               ");

      }
      if ((TYPE_NON_CERT).equals(type)
          || ((TYPE_UNAUTH).equals(type))
          ||
          // STGAP0010670 Added the Placement types of REU,PRN,ICR,LAF to the if condition
          // so that the resource name is saved in the TXT_EVENT_DESCR column of the
          // EVENT table and then is
          // displayed on the Placement List page, description section.
          ((TYPE_RELATIVE_UNPAID).equals(type)) || ((TYPE_PARENT).equals(type)) || ((TYPE_ICPC_RELATIVE).equals(type))
          || ((TYPE_ILP_AFTERCARE).equals(type))) {
        name = ContextHelper.getStringSafe(request, "dspSzNmPlcmtPersonFull");
      } else {
        name = ContextHelper.getStringSafe(request, "dspSzNmPlcmtFacil");
      }
      name = StringHelper.truncate(name, 14);
      eventDescr.append(name).append(" ");
      eventDescr.append(type);

    } else {
      eventDescr.append("Attempted placement for ").append(szCdStageName)
                .append(FormattingHelper.formatDate(ContextHelper.getCastorDateSafe(request, "txtDtDtPlcmtStart")));
    }

    return eventDescr.toString();
  }

  /**
   * Method is named after a similar method in ccmn51w.win This is called by addEventDetail_xa. It checks whether:
   * 'Mother Married' info on PersonDetail/CVS FA Home must be entered first.
   * 
   * @param stageId
   *          int used in population of ccfc37si
   * @param userLogin
   *          String used in population of AtchInputStruct of ccfc37si
   * @throws Exception
   */
  protected static void callPersonDetail(int stageId, String userLogin, Person person) throws Exception {
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(userLogin);
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(1);

    CCFC37SI ccfc37si = new CCFC37SI();
    ccfc37si.setArchInputStruct(archInputStruct);
    ccfc37si.setUlIdStage(stageId);

    CCFC37SO ccfc37so = person.retrievePersonDTL(ccfc37si);

    if (StringHelper.isValid(ccfc37so.getCCdRemovalMothrMarrd()) == false) {
      throw new ServiceException(Messages.MSG_MOTHER_MARRIED);
    }
  }
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    // BaseSessionStateManager state = getSessionStateManager(context);
    resetCsub25so(request);
    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.OTHER);
    io.setDestinationUrl("/subcare/Placement/setStaff");
    request.setAttribute("StaffSearchInput", io);

    // context and forward the user.
    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception o) {
      processSevereException(context, o);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method will retrieve the row object that the staff search sent to us and put the new data into the retrieveSO
   * object for display on the Placement Information Page. Items Retrieved: Staff Full Name for Display. Staff Person Id
   * for storing into database.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  @SuppressWarnings({"unchecked"})
  public void setStaff_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CSUB25SO csub25so = (CSUB25SO) state.getAttribute(CSUB25SO_STRING, request);
    CSUB25SOG00 placementDetail = csub25so.getCSUB25SOG00();

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      placementDetail.setSzCdPlcmtContactedBy(staff.getSzNmPersonFull());
      placementDetail.setUlIdContactedBy(staff.getUlIdPerson());
    }
    
    // STGAP00017058 - place indicator back in request so that placement log link 
    // continues to display on page (if it was already displaying)
    String displayPlacementLogLink = (String) request.getAttribute("hdnDisplayPlacementLogLink");
    if(displayPlacementLogLink != null){
      request.setAttribute("displayPlacementLogLink", displayPlacementLogLink);
    }
    state.setAttribute(CSUB25SO_STRING, csub25so, request);
    //request.setAttribute("isDirty", "isDirty");
    performanceTrace.exitScope();
  }

  /**
   * This method will retrieve the row object that the Waiver search sent to us and put the new data into the retrieveSO
   * object for display on the Placement Information Page.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void selectWaiver_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".selectWaiver_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    resetCsub25so(request);
    int idResource = ContextHelper.getIntSafe(request, "dspUlIdRsrcFacil");
    String rbIndCaseHome = ContextHelper.getStringSafe(request, "rbIndCaseHome");
    try{
    if(N.equals(rbIndCaseHome)){
      FadHomeRetrieveSO fadHomeRetSO = caseMgmt.retrieveFadHome(idResource);
      if(fadHomeRetSO.getUlIdCase()==0 && fadHomeRetSO.getUlIdStage()==0){
         throw new ServiceException(Messages.MSG_PLCMT_FA_HOME); 
      }
    }
    }catch (ServiceException we) {
      we.printStackTrace();
      setPresentationBranch("stay", context);
      //resetCsub25so(request);
      int errorCode = we.getErrorCode();
      if(errorCode == Messages.MSG_PLCMT_FA_HOME){
      setErrorMessage(Messages.MSG_PLCMT_FA_HOME, request);
      }
    }
    request.setAttribute("grnds.request.qname", null);
    performanceTrace.exitScope();

  }
  
  private boolean checkDisruptionNarrExists(int idEvent) {
    NonComplianceSO nonComplianceSO = null;
    NonComplianceSI nonComplianceSI = new NonComplianceSI();
    
    nonComplianceSI.setCdNonCompliance(CodesTables.CEVNTTBL_FCD);
    nonComplianceSI.setIdEvent(idEvent);
    nonComplianceSO = nonCompliance.checkDocExistsForNonCompliance(nonComplianceSI);
    
    Date dtFormLastDate = nonComplianceSO.getDtFormLastDate();
    return (dtFormLastDate == null) ? false : true;

  }
  
  /**
   * This will populate the APPLAPersonsConnectedRetrieveSI object with the Event, Stage, and Resource ID
   * 
   * @param request
   *          The HTTP Servlet Request
   * @return APPLAPersonsConnectedRetrieveSI
   */
  private static APPLAPersonsConnectedRetrieveSI populateAPPLAPersonsConnectedRetrieveSI_Retrieve(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);

    APPLAPersonsConnectedRetrieveSI APPLAPersonsConnectedRetrieveSI = new APPLAPersonsConnectedRetrieveSI();

    APPLAPersonsConnectedRetrieveSI.setIdEvent(GlobalData.getUlIdEvent(request));
    APPLAPersonsConnectedRetrieveSI.setIdStage(GlobalData.getUlIdStage(request));

    //MR-057 Set the idResource from the state which was set when coming from resource pullback
    Integer idResourceFacilObj = (Integer) state.getAttribute("idResourceFacil", request);
    if(idResourceFacilObj != null){
      APPLAPersonsConnectedRetrieveSI.setIdResource(idResourceFacilObj.intValue());
    }
    return APPLAPersonsConnectedRetrieveSI;
  }
}
