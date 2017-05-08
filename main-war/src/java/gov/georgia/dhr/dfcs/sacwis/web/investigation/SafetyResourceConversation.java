package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.service.document.SafetyRscrAssessmentFrm;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Error;
import gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceSaveSI;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceHshldMemberBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DocumentTemplateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForCpsHistorySI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildErrorBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO.RowPlanPrincipal;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentBuilderHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServiceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentUtilityHelpers;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * This Conversation class handles the display, save, update, and delete of the
 * Safety Resource Detail and Safety Resource Child Detail pages for Georgia 
 * SHINES release 2.5 and later.
 * 
 * @author Joshua Dorsey
 *
 * <pre>
 * Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 06/17/08    Patrick Coogan    Final updates for SHINES 2.5 build of Safety Resource 
 *                               enhancement.
 * 06/21/2009  bgehlot           STGAP00014329: MR-20 updates   
 * 
 * 07/09/2009  cwells            STGAP00014333: MR-20 Form update
 *
 * 03/01/2011  cwells            SMS 77962: Not allowing user the ability to create new safety resources 
 *                               When current stage is closed.
 * 06/10/2011  hjbaptiste        SMS#109631: CAPTA 4.3: Safety Resource - Determining which approver is the current one in order
 *                               to add multiple approvers when prior history.
 * 06/20/2011  hjbaptiste        SMS#112385: CAPTA 4.3: Safety Resource - When in approval mode, need to check conditions to 
 *                               determine if another approver is needed. Prevented an NPE by calling the equals() method
 *                               of constant string to check for equality with an object's properties                                                          	  
 * 06/22/2011  schoi             SMS #112163 Updated the name of the message from MSG_MISSING_REC_CHECK_OVER_18 to MSG_MISSING_REC_CHECK_OVER_17 
 *                               to be in sync with the message text and name change per policy change
 * 07/09/2011  cwells            SMS #114319: Moving prior CPS history message to display of Safety Resource instead of Save                                                             
 * </pre>
 */

public class SafetyResourceConversation extends BaseHiddenFieldStateConversation {
  
  public static final String TRACE_TAG = "SafetyResourceConversation";
  public static final String SAFETY_RSRC_ASMNT_NARR_TABLE_NAME = "SAFETY_RSRC_ASMNT_NARR";
  public static final String DOCEXISTS = "docExists"; 
  public static final String CODE_TABLE_EVENT_DOC = CodesTables.CEVNTDOC;
  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;
  public static final String INV_TASK_CODE = "2277";
  public static final String ONG_TASK_CODE = "7331";
  public static final String INV_STAGE = "INV";
  public static final String ONG_STAGE = "FPR";
  public static final String DISPLAY_URI = "/investigation/SafetyResource/displaySafetyResourceChild";
  public static final String DISPLAY_SAFETY_RESOURCE = "/investigation/SafetyResource/displaySafetyResource";
  public static final String APPROVE_SAFETY_RESOURCE = "7332";
  public static final String APPROVE_SAFETY_RESOURCE_ONG = "7333";
  private static final String SAFETY_RESOURCE = "Safety Resource";
  
  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;
  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;
  public static final String SAVE = "save";
  public static final String SUBMIT = "submit";
  

  
  private static final Map<String, String> TASK_CODE_MAP = new HashMap<String, String>() {
    { 
      put(INV_TASK_CODE, APPROVE_SAFETY_RESOURCE);
      put(ONG_TASK_CODE, APPROVE_SAFETY_RESOURCE_ONG);
    }
  };
        
    
  /** Create a private field for each service EJB used. */
  private Investigation investigation = null;
  
  private DocumentSave documentSave = null;
  
  private DocumentServiceExecutor documentServiceExecutor = null;
  
  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }
  
  //STGAP00014329
  private Admin admin;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  
  //STGAP00014329
  private Common common;
  
  public void setCommon(Common common) {
    this.common = common;
  }
  
  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }
  
  public void setDocumentServiceExecutor(DocumentServiceExecutor documentServiceExecutor) {
    this.documentServiceExecutor = documentServiceExecutor;
  }

  /**
   * This method is called by the GRNDS controller when displaying the Safety Resource page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displaySafetyResource_xa(GrndsExchangeContext context) {
    
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySafetyResource_xa()");
    performanceTrace.enterScope();
    
    try {
      
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      
      
      
      
      SafetyResourceRetrieveSI safetyResourceRetrieveSI = populateSafetyResourceRetrieveSI(context);
      SafetyResourceRetrieveSO safetyResourceRetrieveSO = investigation.retrieveSafetyResource(safetyResourceRetrieveSI);   
      state.setAttribute("safetyResourceRetrieveSO", safetyResourceRetrieveSO, request);
      state.setAttribute("isStageClosed", isStageClosed(context), request);
      
      
      //Update page mode for redisplay after initial save of a new page
      if ((PageModeConstants.NEW.equals(pageMode))&&(safetyResourceRetrieveSO.getUlIdEvent()!=0)) 
      {
        pageMode = PageModeConstants.EDIT;
      }
      
      UserProfile user = UserProfileHelper.getUserProfile(request);
      Integer idUser = user.getUserID();
      Integer idCountyManager = safetyResourceRetrieveSO.getIdCountyManager();
     
      // Users having the County Management (COUNTY_MGMNT) profile will have the ability to access 
      // the Safety Resource Detail page in modify mode, while either the INV or ONG stage is open
      if(idCountyManager > 0 && idCountyManager.equals(idUser) && getHasOpenOngInv(safetyResourceRetrieveSO.getUlIdStage())){
        state.setAttribute("countyMgtMode", true, request);
        pageMode = PageModeConstants.MODIFY;
      }else{
        state.setAttribute("countyMgtMode", false, request);
        pageMode = PageModeConstants.EDIT;
      }
      
      
      //Override page mode to modify if the user has access to an open INV or ONG stage in the
      //same case
      if (PageModeConstants.VIEW.equals(pageMode)) 
      {  
        if (hasStageAccessRights(context))
        {  
          pageMode = PageModeConstants.EDIT;
        }
      }
      
      PageMode.setPageMode(pageMode, request);
      
      //STGAP00014329: Added the invalidate approval message
      // If the Investigation Conclusion Event Status is 'PEND', then set a
      // message in the request that will notify the user that the pending
      // approval will be invalidated if they save any changes.
      if (!GlobalData.isApprovalMode(request) && safetyResourceRetrieveSO.getCdEventStatus() != null && safetyResourceRetrieveSO.getCdEventStatus().equals(EVENT_STATUS_PEND))
      {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, DISPLAY_SAFETY_RESOURCE, request);
        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }
      
      //Capta 4.3 Checking to see if any primary SR, Secondary SR or Household member were 
      // involved in any previous cases.
      int ulIdEvent = GlobalData.getUlIdEvent(request);
      if(ulIdEvent > 0){
      CheckForCpsHistorySI checkForCpsHistorySI = populateCheckForCpsHistorySI(context);
      boolean hasCpsHistory = investigation.checkForCpsHistory(checkForCpsHistorySI);
      if(hasCpsHistory){
        setInformationalMessage(Messages.MSG_SFTY_RSRC_PRIOR_HISTORY_WARN, DISPLAY_SAFETY_RESOURCE, request);
        }  
      }
    }
    catch (ServiceException we) {
      handleException(we, context);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  /**
   * This method is called by the GRNDS controller when displaying the Safety Resource Child page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displaySafetyResourceChild_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySafetyResourceChild_xa()");
    performanceTrace.enterScope();
    
    try {
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    SafetyResourceChildRetrieveSI safetyResourceChildRetrieveSI = populateSafetyResourceChildRetrieveSI(context);
    
    SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = investigation.retrieveSafetyResourceChild(safetyResourceChildRetrieveSI);
    
    state.setAttribute("SafetyResourceChildRetrieveSO", safetyResourceChildRetrieveSO, request);
    
    }
    catch (ServiceException we) {
      handleException(we, context);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;  
  }
  
 
  /**
   * This method is called by the GRNDS controller when saving a Safety Resource.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveSafetyResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSafetyResource_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    try {
      int eventId = saveSafetyResource(context, SAVE);
      GlobalData.setUlIdEvent(eventId, request);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return; 
  
  }
  
  /** STGAP00014329: 
   * This method is called by the GRNDS controller when saving and submitting a Safety Resource.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveSubmitSafetyResourceAssessment_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSubmitSafetyResourceAssessment_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {

      int idEvent = saveSafetyResource(context, SUBMIT);
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      String approvalCdTask = APPROVE_SAFETY_RESOURCE;

      String cdTask = GlobalData.getSzCdTask(request);
      if(TASK_CODE_MAP.containsKey(cdTask)) {
        approvalCdTask = TASK_CODE_MAP.get(cdTask);
      }

      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(idEvent, ulIdCase, ulIdStage, approvalCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    } 
    catch (ServiceException we) {
      handleException(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      //This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;

  }
  
  /**
   * This method is called when the user clicks the Approval Status button on the SpecialNeedsDetermination page in
   * approval mode. This method calls the save function to perform edits checks. We are forwarded to the Approval Status page.
   * 
   * @param context -
   *                the GrndsExchangeContext object
   * @return void
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      int eventId = saveSafetyResource(context, SAVE);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }
  
  private Boolean getHasOpenOngInv(int ulIdStage) {
    Boolean hasOpenSafetyResource = false;
  gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Stage currentStage = CaseUtility.getStage(ulIdStage);
  List<CaseUtility.Stage> stages = CaseUtility.getOpenStages(currentStage.getIdCase());
  for( CaseUtility.Stage stage : stages){
    if(CodesTables.CSTAGES_FPR.equals(stage.getCdStage()) || CodesTables.CSTAGES_INV.equals(stage.getCdStage())){
       hasOpenSafetyResource = true;
       break;
    }
  } 
    return hasOpenSafetyResource;
  }
  
  /**
   * This method is used when the safety Resource needs to be saved. 
   * @param context
   * @param assessment
   * @param method
   */
  private int saveSafetyResource(GrndsExchangeContext context, String method) {    
    int idEvent = 0;
    
    try {

      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      GlobalData.setUlIdPerson(user.getUserID(), request);

      SafetyResourceSaveSI safetyResourceSaveSI = populateSafetyResourceSaveSI(context, user, state, method);
      
            
      //STGAP00014329: if save only and in pending mode and not an approver then invalidate the approval
      if (GlobalData.getUlIdEvent(request) != 0 && CodesTables.CEVTSTAT_PEND.equals(safetyResourceSaveSI.getSzEventStatus())
                      && !isCurrentActiveApprover(context) && hasStageAccessRights(context)) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setUlIdEvent(GlobalData.getUlIdEvent(request));
        ArchInputStruct ais = new ArchInputStruct();
        ais.setUlSysNbrReserved1(ArchitectureConstants.N);
        ccmn05ui.setArchInputStruct(ais);
        try {
         admin.invalidateApproval(ccmn05ui);
        } catch (ServiceException se) {
          int errorCode = se.getErrorCode();
          switch (errorCode) {
          case Messages.SQL_NOT_FOUND:
            //if there is not an Approval to invalidate just keep on going
            break;
          default:
            GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
            processSevereException(context, se);
            break;
          }
        }
      }
      
      //STGAP00014329: Added the invalidate approval message
      // If the Investigation Conclusion Event Status is 'PEND', then set a
      // message in the request that will notify the user that the pending
      // approval will be invalidated if they save any changes.
      if (!GlobalData.isApprovalMode(request) && safetyResourceSaveSI.getSzEventStatus() != null && EVENT_STATUS_PEND.equals(safetyResourceSaveSI.getSzEventStatus()))
      {
        safetyResourceSaveSI.setSzEventStatus(CodesTables.CEVTSTAT_PROC);
      }      
      
      SafetyResourceSaveSO safetyResourceSaveSO = investigation.saveSafetyResource(safetyResourceSaveSI);
      idEvent = safetyResourceSaveSO.getUlIdEvent();
      GlobalData.setUlIdEvent(idEvent, request);
      //STGAP00014333: If user is clicking on the save and submit button launch and save the form for them to obtain the 
      // most recent information at time of submission.
      if(SUBMIT.equals(method)){
        saveSafetyAssessmentForm(context);
      } 
      //Capta 4.3 Checking to see if any primary SR, Secondary SR or Household member were 
      // involved in any previous cases.
      CheckForCpsHistorySI checkForCpsHistorySI = populateCheckForCpsHistorySI(context);
      boolean hasCpsHistory = investigation.checkForCpsHistory(checkForCpsHistorySI);
      // CAPTA 4.3: When in approval mode, need to check conditions to determine if another approver is needed
      if (GlobalData.isApprovalMode(request) && safetyResourceSaveSI.getSzEventStatus() != null && EVENT_STATUS_PEND.equals(safetyResourceSaveSI.getSzEventStatus()))
      {
        // CAPTA 4.3: If the Denial Reason has changed, County Director approval is required 
        String cdPreviousDenialReason = ContextHelper.getStringSafe(request, "hdnPreviousDenialReason");
        String cdDenialReason = safetyResourceSaveSI.getCdDenialReason();
        boolean cdDenialReasonChg = cdPreviousDenialReason != null && cdDenialReason != null && !cdPreviousDenialReason.equals(cdDenialReason);
        // CAPTA 4.3: When CPS History exists or the Denial Reason has changed, we need to determine which approver this is
        // in order to add the county director as another approver if the supervisor has changed the reason. Another
        // approver is not necessary if the approver is the county director. County Director is the final approver
        if (hasCpsHistory || cdDenialReasonChg) {
          String whichSafetyRsrcApprover = common.determineWhichApprover(GlobalData.getUlIdApproval(request), SAFETY_RESOURCE);
          state.setAttribute("whichSafetyRsrcApprover", whichSafetyRsrcApprover, request);
        }
      }
      
    } catch (ServiceException se) {
      handleException(se, context);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    return idEvent;
  }
  

  /**
   * This method is called by the GRNDS controller when saving Safety Resource Child record.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
    public void saveSafetyResourceChild_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveSafetyResourceChild_xa");
    try {
        
      BaseSessionStateManager state = getSessionStateManager(context);
      
      SafetyResourceChildSaveSI safetyResourceChildSaveSI = populateSafetyResourceChildSaveSI(context,state);
         
      SafetyResourceChildSaveSO safetyResourceChildSaveSO = investigation.saveSafetyResourceChild(safetyResourceChildSaveSI);
      
      if (!safetyResourceChildSaveSO.getSafetyResourceChildList().isEmpty()){
        
        processSafetyResourceChildMessages(safetyResourceChildSaveSO, context);
        
      }
           
    } catch (ServiceException we) {
        handleException(we, context);
    } catch (Exception e) {
        processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  /**
   * This method is called by the GRNDS controller when deleting a Safety Resource record.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteSafetyResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteSafetyResource_xa");

    try {
      HttpServletRequest request = context.getRequest();
      
      
      int ulIdEvent = GlobalData.getUlIdEvent(request);
      SafetyResourceDeleteSI safetyResourceDeleteSI = new SafetyResourceDeleteSI();
      
      safetyResourceDeleteSI.setUlIdEvent(ulIdEvent);
      
      investigation.deleteSafetyResource(safetyResourceDeleteSI);   
      
      } catch (ServiceException we) {
          handleException(we, context);
      } catch (Exception e) {
          processSevereException(context, e);
      }
   
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return; 
  }
 
  /**
   * This method is called by the GRNDS controller when deleting an Safety Resource Child
   * record.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void deleteSafetyResourceChild_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteSafetyResourceChild_xa");
    
    try {
      
      HttpServletRequest request = context.getRequest();
      int ulIdSrChild = Integer.parseInt(ContextHelper.getStringSafe(request, "hdnUlIdSrChild"));
      int ulIdEvent = GlobalData.getUlIdEvent(request);
      SafetyResourceChildDeleteSI safetyResourceChildDeleteSI = new SafetyResourceChildDeleteSI();
    
      safetyResourceChildDeleteSI.setUlIdSrChild(ulIdSrChild);
      safetyResourceChildDeleteSI.setUlIdEvent(ulIdEvent);
    
      investigation.deleteSafetyResourceChild(safetyResourceChildDeleteSI);   
    
    } 
    catch (ServiceException we) {
      handleException(we, context);
    } 
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  

  
  /**
  *Determines if the stage is closed or open
  *
  * @param context
  *
  */
  private boolean isStageClosed(GrndsExchangeContext context){
    boolean bStageClosed = false;
    HttpServletRequest request = context.getRequest();
    List<CaseUtility.Stage> stageList= CaseUtility.getClosedStages(GlobalData.getUlIdCase(request));
    Integer idStage = GlobalData.getUlIdStage(request);
    
 if (!stageList.isEmpty()){
      
      for(Iterator<CaseUtility.Stage> it = stageList.iterator(); it.hasNext();)
      {
        
        CaseUtility.Stage stage = it.next();
        Integer tempIdStage = stage.getIdStage();
        if (tempIdStage.equals(idStage)){
          bStageClosed = true;
          break;
        }
      }    
    }
 
    return bStageClosed;
  }

  /**
   * Determines whether person has rights to access the page
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    
    boolean bStageAccess = false;
    
    HttpServletRequest request = context.getRequest();
    List<CaseUtility.Stage> stageList= CaseUtility.getOpenStages(GlobalData.getUlIdCase(request));
    int userId = UserProfileHelper.getUserProfile(context).getUserID();
    
    if (!stageList.isEmpty()){
      
      for(Iterator<CaseUtility.Stage> it = stageList.iterator(); it.hasNext();)
      {
        
        CaseUtility.Stage stage = it.next();
        String cdStage = stage.getCdStage();
        
        if ((INV_STAGE.equals(cdStage))||(ONG_STAGE.equals(cdStage))){
          
          bStageAccess = CaseUtility.hasStageAccess(userId, stage.getIdStage());
          if (bStageAccess) 
          {
            break;
          }
        }
      }    
    }
    
    return bStageAccess;
  }
  
 
  /**
   * This method is called by the saveSafetyResourceChild_xa method to process messages returned in the error bean for
   * overlapping placements.
   * 
   * @param context
   * @param safetyResourceChildSaveSO
   * @return
   */
  private void processSafetyResourceChildMessages(SafetyResourceChildSaveSO 
       safetyResourceChildSaveSO, GrndsExchangeContext context){
    
    HttpServletRequest request = context.getRequest();
    
    for(Iterator<SafetyResourceChildErrorBean> it = safetyResourceChildSaveSO.getSafetyResourceChildList().iterator(); it.hasNext();)
    {
      
      SafetyResourceChildErrorBean safetyResourceChildErrorBean = it.next();  
      setErrorMessage(MessageLookup.addMessageParameter(
              MessageLookup.getMessageByNumber(safetyResourceChildErrorBean.getUlIdMessage()),
              safetyResourceChildErrorBean.getNmChildFull()),DISPLAY_URI, request);  
    }
    setPresentationBranch("error", context);
  }
  
  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   */
  private void handleException(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    //STGAP00014329: Added this message for the records check
    // SMS #112163 Updated the name of the message from MSG_MISSING_REC_CHECK_OVER_18 to MSG_MISSING_REC_CHECK_OVER_17 
    // to be in sync with the message text and name change per policy change  
    case Messages.MSG_MISSING_REC_CHECK_OVER_17:
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(Messages.MSG_MISSING_REC_CHECK_OVER_17, request);
      break;
      
    case Messages.MSG_SFTY_RSRC_ASSESS_FORM_REQ:
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(Messages.MSG_SFTY_RSRC_ASSESS_FORM_REQ, request);
      break;  
    default:
      if (we.getErrorCode() != 0) {
        setErrorMessage(we.getErrorCode(), request);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
      break;
    }
  }
  
  
  

  
  /**
   * This method populates the CheckForCpsHistorySI object.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private CheckForCpsHistorySI populateCheckForCpsHistorySI(GrndsExchangeContext context) {
    
    HttpServletRequest request = context.getRequest();
    CheckForCpsHistorySI checkForCpsHistorySI = new CheckForCpsHistorySI();
    
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdCase = GlobalData.getUlIdCase(request);
 
    checkForCpsHistorySI.setUlIdEvent(ulIdEvent);
    checkForCpsHistorySI.setIdCase(ulIdCase);
    
    return checkForCpsHistorySI;
  }
  
  
  
  /**
   * This method populates the SafetyResourceRetrieveSI object.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private SafetyResourceRetrieveSI populateSafetyResourceRetrieveSI(GrndsExchangeContext context) {
    
    HttpServletRequest request = context.getRequest();
    SafetyResourceRetrieveSI safetyResourceRetrieveSI = new SafetyResourceRetrieveSI();
    
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
 
    safetyResourceRetrieveSI.setUlIdEvent(ulIdEvent);
    safetyResourceRetrieveSI.setUlIdStage(ulIdStage);
    
    return safetyResourceRetrieveSI;
  }
  
  /**
   * This method populates the SafetyResourceSaveSI object.
   * 
   * @param context
   * @param user
   * @param state
   */
  @SuppressWarnings( { "unchecked" })
  private SafetyResourceSaveSI populateSafetyResourceSaveSI(GrndsExchangeContext context, 
        UserProfile user, BaseSessionStateManager state, String method) {
    
    HttpServletRequest request = context.getRequest();
    SafetyResourceSaveSI safetyResourceSaveSI = new SafetyResourceSaveSI();
    
    SafetyResourceRetrieveSO safetyResourceRetrieveSO = (SafetyResourceRetrieveSO) state.getAttribute("safetyResourceRetrieveSO",request);
    
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
    int ulIdCase = GlobalData.getUlIdCase(request);
    
    //Set the task code depending on the current stage
    if (StringHelper.checkForEquality(GlobalData.getSzCdStage(request),INV_STAGE)){
      safetyResourceSaveSI.setCdTask(INV_TASK_CODE);
    } else {
      safetyResourceSaveSI.setCdTask(ONG_TASK_CODE);
    }
    
    //STGAP00014329: Save and Submit has been added to the page
    if (ulIdEvent > 0) {
      safetyResourceSaveSI.setSzEventStatus(safetyResourceRetrieveSO.getCdEventStatus());
      if ((CodesTables.CEVTSTAT_PEND.equals(safetyResourceRetrieveSO.getCdEventStatus()) && SAVE.equals(method)) || SUBMIT.equals(method)) {
        safetyResourceSaveSI.setSzEventStatus(CodesTables.CEVTSTAT_PEND);
      } else if (SAVE.equals(method)) {
        safetyResourceSaveSI.setSzEventStatus(CodesTables.CEVTSTAT_PROC);
      }
    } else {
      safetyResourceSaveSI.setSzEventStatus(CodesTables.CEVTSTAT_PROC);
    }
    
    safetyResourceSaveSI.setUlIdEvent(ulIdEvent);
    safetyResourceSaveSI.setUlIdCase(ulIdCase);
    safetyResourceSaveSI.setUlIdStage(ulIdStage);
    
    safetyResourceSaveSI.setUlIdPerson(user.getUserID());
    
    int ulIdPrimary = Integer.parseInt(ContextHelper.getStringSafe(request, "selPrimaryResource"));
    String szIdSecondary = ContextHelper.getStringSafe(request, "selSecondaryResource");
    
    safetyResourceSaveSI.setUlIdPrimary(ulIdPrimary);
    
    if (!"".equals(szIdSecondary)) {
      int ulIdSecondary = Integer.parseInt(szIdSecondary); 
      safetyResourceSaveSI.setUlIdSecondary(ulIdSecondary);
    }
    
    //STGAP00014329: New Dates added on the safety resource page
    Date dtRequestReceived = ContextHelper.getJavaDateSafe(request, "dtRequestReceived");
    Date dtHomeVisit = ContextHelper.getJavaDateSafe(request, "dtHomeVisit");
    
    String txtComments = ContextHelper.getStringSafe(request, "txtComments");
    String indRecommendation = ContextHelper.getStringSafe(request, "indRecommendation");
    String cdDenialReasoun = ContextHelper.getStringSafe(request, "selDenialReason");
    
    safetyResourceSaveSI.setIndRecommendation(indRecommendation);
    safetyResourceSaveSI.setTxtComments(txtComments);
    safetyResourceSaveSI.setCdDenialReason(cdDenialReasoun);
    safetyResourceSaveSI.setDtRequestReceived(dtRequestReceived);
    safetyResourceSaveSI.setDtHomeVisit(dtHomeVisit);
    safetyResourceSaveSI.setMethod(method);
    
    safetyResourceSaveSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
    
    //Perform iteration through checked boxes and previously checked boxes to determine which
    //household members records must be added or deleted by the service
    
    List<Integer> householdMembersToDelete = (List<Integer>) state.getAttribute("savedHouseholdMemberList", request);
    List<SafetyResourceHshldMemberBean> principalsCollateralsList = (List<SafetyResourceHshldMemberBean>) state.getAttribute("principalsCollateralList", request);
    
    List<Integer> householdMembersToAdd = new ArrayList<Integer>();
    
    //STGAP00014329: Checked HouseHold Members
    List<Integer> checkedHouseholdMembers = new ArrayList<Integer>();
    
    String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbx_");
    
    for (int i = 0; i < cbxValues.length; i++) {
      
      Integer person = (Integer) (principalsCollateralsList.get(Integer.parseInt(cbxValues[i])).getUlIdPerson());
      //STGAP00014329
      checkedHouseholdMembers.add(person);    
      
      if (householdMembersToDelete.contains(person))
      {  
        householdMembersToDelete.remove(person);  
      }
      else 
      {  
        householdMembersToAdd.add(person);      
      }
    }
    
    //remove after forming add and delete lists, will be rest on page redisplay
    state.removeAttribute("savedHouseholdMemberList", request);
    state.removeAttribute("principalsCollateralList", request);
    
    //add list of records to add and delete from SR_HOUSEHOLD_MEMBERS to SI object
    safetyResourceSaveSI.setAddHshldMembers(householdMembersToAdd);
    safetyResourceSaveSI.setDeleteHshldMembers(householdMembersToDelete);
    
    //STGAP00014329
    safetyResourceSaveSI.setCheckedHshldMembers(checkedHouseholdMembers);
    
    
    //STGAP00014329: New section "Children Considered For Placement" added. It populates with a list of all persons on 
    // the stage indicated as members of the primary caretaker's household that are under the age of 18.  
    // Identifying members of the primary caretaker's household is done using the Primary Caretaker Household Member 
    // checkbox on the Person Detail page.
    
    List<Integer> childConsideredToDeleteList = (List<Integer>) state.getAttribute("childrenConsideredList", request);
    List<SafetyResourceHshldMemberBean> memeberPKHouseHoldUnder18List = (List<SafetyResourceHshldMemberBean>) state.getAttribute("memeberPKHouseHoldUnder18List", request);
    
    List<Integer> childConsideredToAddList = new ArrayList<Integer>();
    
    String[] cbxChildrenConsidered = CheckboxHelper.getCheckedValues(request, "cbxChildren_");
    
    for (int i = 0; i < cbxChildrenConsidered.length; i++) {
      
      Integer person = (Integer) (memeberPKHouseHoldUnder18List.get(Integer.parseInt(cbxChildrenConsidered[i])).getUlIdPerson());
      
      if (childConsideredToDeleteList.contains(person))
      {  
        childConsideredToDeleteList.remove(person);  
      }
      else 
      {  
        childConsideredToAddList.add(person);      
      }
    }
    
    //remove after forming add and delete lists, will be rest on page redisplay
    state.removeAttribute("childrenConsideredList", request);
    state.removeAttribute("memeberPKHouseHoldUnder18List", request);
    
    //add list of records to SI object
    safetyResourceSaveSI.setAddChildConsidered(childConsideredToAddList);
    safetyResourceSaveSI.setDeleteChildConsidered(childConsideredToDeleteList);
    
    return safetyResourceSaveSI;
  }
  
  
  private void saveSafetyAssessmentForm(GrndsExchangeContext context) throws Exception, ServiceException, IOException {
    HttpServletRequest request = context.getRequest();
    
    //set the general attribute for the meta-data
    request.setAttribute("docType", SafetyRscrAssessmentFrm.FAS05O00);
    request.setAttribute("sCase", String.valueOf(GlobalData.getUlIdCase(request)));
    request.setAttribute("pStage", String.valueOf(GlobalData.getUlIdStage(request)));
    request.setAttribute("sEvent", String.valueOf(GlobalData.getUlIdEvent(request)));
    
    //walk through the Children

        
        DocumentTemplateSI documentTemplateSI = new DocumentTemplateSI();
        documentTemplateSI.setDocument(SafetyRscrAssessmentFrm.FAS05O00_DOC_NAME);
        documentTemplateSI.setMajor(SafetyRscrAssessmentFrm.FAS05O00_MAJOR);
        documentTemplateSI.setMinor(SafetyRscrAssessmentFrm.FAS05O00_MINOR);
        documentTemplateSI.setRevision(SafetyRscrAssessmentFrm.FAS05O00_REVISION);
        
        Integer currentTemplate = common.retrieveDocumentTemplate(documentTemplateSI);
        SafetyResourceRetrieveSI safetyResourceRetrieveSI = populateSafetyResourceRetrieveSI(context);
        SafetyResourceRetrieveSO safetyResourceRetrieveSO = investigation.retrieveSafetyResource(safetyResourceRetrieveSI);
       
        if ("Y".equals(safetyResourceRetrieveSO.getIndBLOBExistsInDatabase())) {
          request.setAttribute("docExists", "true");
        } else {
          request.setAttribute("docExists", "");
          safetyResourceRetrieveSO.setTemplateVersion(currentTemplate);
        }
        

       
        
        Integer templateVersion = safetyResourceRetrieveSO.getTemplateVersion();
        
        // Get the specific document type requested and lookup in JNDI
        if (request.getAttribute("docType") != null) {
          String docType = (String) request.getAttribute("docType");
          String docMetaDataString = DocumentLookup.lookup(docType.toUpperCase());
          
          StringReader stringReader = new StringReader(docMetaDataString);
          DocumentMetaData documentMetaData = null;
          try {
            //Unmarshall the Xml String into the DocumentMetaData object
            documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
            documentMetaData.setActualTemplateVersion(templateVersion.intValue());
          } catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
            throw e;
          }
          
          // Fill in the rest of the documentMetaData from the request
          try {
            if (context.getRequest().getParameter("tableName") != null) {
              documentMetaData.getTableMetaData().setTableName(context.getRequest().getParameter("tableName"));
            }
            documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                               false);
            documentMetaData.setRenderFormat(RenderType.HTML_WITHOUT_SHELL);
          } catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception in completeDocumentMetaData:" + e.getMessage());
            throw e;
          }
          
          //populate the pre fill data
          String preFillData = null;
          try {
            GrndsTrace.msg(TRACE_TAG, 7, "Calling prefill service");
            preFillData = DocumentServiceHelper.returnPreFillData(documentServiceExecutor, request, documentMetaData);
          } catch (ServiceException we) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception calling Tuxedo:" + we.getMessage());
            String errorMessageString = null;

            // Get the errorMessages collection for the tux service
            ErrorMessages errorMessages = documentMetaData.getPreFillMetaData().getErrorMessages();

            // Loop thru the error messages until the constant is found.
            for (int x = 0; x < errorMessages.getErrorCount(); x++) {
              Error error = errorMessages.getError(x);
              GrndsTrace.msg(TRACE_TAG, 7, "Value of Error code:" + error.getErrorCode());
              // TODO: This used to only get displayed if error code and name were the same, which is very weird.
              errorMessageString = MessageLookup.getMessageByName(error.getDisplayMessage());
              if (errorMessageString.equals(we.getMessage())) {
                break;
              }
            }

            //  If the error code could not be found then perform the default behavior
            if (errorMessageString == null) {
              if (!"PROCESS_SEVERE_ERROR".equals(errorMessages.getDefault().getDisplayMessage())) {
                GrndsTrace.msg(TRACE_TAG, 7,
                               "Getting default error message:" + errorMessages.getDefault().getDisplayMessage());
                errorMessageString = MessageLookup.getMessageByName(errorMessages.getDefault().getDisplayMessage());
              } else {
                throw we;
              }
            }

            //If there was an error message show the exception page. 
            if (errorMessageString != null) {
              throw new Exception(errorMessageString);
            }
          }
          catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
            throw e;
          }
          
          StringWriter stringWriter = new StringWriter();
          try {
            Marshaller.marshal(documentMetaData, stringWriter);
          }
          catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
            throw e;
          }

          docMetaDataString = stringWriter.toString();          
          
          try {
        // if an older version of the form where there are entry fields on the form
        // get the user entered data and then add the newer prefill values
        preFillData = createPreFillDataForEarlierVersion(GlobalData.getUlIdEvent(request), preFillData);
        if (preFillData != null) {
          documentSave.saveDocument(documentMetaData,
                                    (CompressionHelper.compressData(preFillData.getBytes())).toByteArray());
        }
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
        throw e;
      }
    }
  }
  
  private String createPreFillDataForEarlierVersion(int eventId, String preFillData) throws Exception {
    String newNarrative = null;
    
    //get the existing narrative
    SafetyResourceRetrieveSI safetyResourceRetrieveSI = new SafetyResourceRetrieveSI();
    safetyResourceRetrieveSI.setUlIdEvent(eventId);
    
    byte[] narrativeba = investigation.retrieveSafetyRsrcForm(safetyResourceRetrieveSI);
    
    //create the document from the narrative
    if(narrativeba != null) {
      ByteArrayOutputStream docData = CompressionHelper.decompressData(narrativeba);
      SAXBuilder parser = new SAXBuilder();
      ByteArrayInputStream baIS = new ByteArrayInputStream(docData.toByteArray());
      Document doc = parser.build(baIS);
      Element root = doc.getRootElement();
      
      //remove the old prefill
      root.removeChildren(DocumentBuilderHelper.FIELD_VALUE_PREFILL);
      
      //create the new prefill document from the new values
      ByteArrayInputStream baISPreFill = new ByteArrayInputStream(preFillData.getBytes());
      Document docPreFill = parser.build(baISPreFill);
      Element rootPreFill = docPreFill.getRootElement();
      List children = rootPreFill.cloneContent(); 
      
      //add in the new prefill values to the user entered data
      Element prefillElement = new Element(DocumentBuilderHelper.FIELD_VALUE_PREFILL);
      prefillElement.addContent(children);
      root.addContent(0, prefillElement);
      
      //setup the new xml for the narrative . 
      XMLOutputter serializer = new XMLOutputter();
      newNarrative = serializer.outputString(doc);    
    }
    return newNarrative;
  }

  /**
   * This method populates the SafetyResourceChildSaveSI object.
   * 
   * @param context
   * @param state
   */
  
  private SafetyResourceChildSaveSI populateSafetyResourceChildSaveSI(GrndsExchangeContext context, BaseSessionStateManager state) {
  
    HttpServletRequest request = context.getRequest();
    SafetyResourceChildSaveSI safetyResourceChildSaveSI = new SafetyResourceChildSaveSI();
  
    SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = (SafetyResourceChildRetrieveSO) state.getAttribute("SafetyResourceChildRetrieveSO",request);
    List<SafetyResourcePersonBean> safetyResourceChildListDisplay = safetyResourceChildRetrieveSO.getSafetyResourceChildList();
    List<SafetyResourcePersonBean> safetyResourceChildListSave = new ArrayList<SafetyResourcePersonBean>();
  
    String szCdPrimaryRelationship = ContextHelper.getStringSafe(request, "selPrimaryRelationship");
    String szCdSecondaryRelationship = ContextHelper.getStringSafe(request, "selSecondaryRelationship");
    Date dtStart = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtStart"));
    Date dtEnd = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtEnd"));
    int ulIdEvent = Integer.parseInt(ContextHelper.getStringSafe(request, "hdnUlIdEvent"));
    int ulIdSrChild = Integer.parseInt(ContextHelper.getStringSafe(request, "hdnUlIdSrChild"));
    
    //STGAP00014328:
    int ulIdStage = GlobalData.getUlIdStage(request);
    int ulIdCase = GlobalData.getUlIdCase(request);    
    UserProfile user = UserProfileHelper.getUserProfile(request);
  
    String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbx_");
  
    for (int i = 0; i < cbxValues.length; i++) {
      SafetyResourcePersonBean safetyResourceChildBeanSave = new SafetyResourcePersonBean();
      safetyResourceChildBeanSave = safetyResourceChildListDisplay.get(Integer.parseInt(cbxValues[i]));
      safetyResourceChildListSave.add(safetyResourceChildBeanSave);  
    }
  
    safetyResourceChildSaveSI.setCdRelationshipPrimary(szCdPrimaryRelationship);
    safetyResourceChildSaveSI.setCdRelationshipSecondary(szCdSecondaryRelationship);
    safetyResourceChildSaveSI.setDtStart(dtStart);
    safetyResourceChildSaveSI.setDtEnd(dtEnd);
    safetyResourceChildSaveSI.setUlIdEvent(ulIdEvent);
    safetyResourceChildSaveSI.setUlIdSrChild(ulIdSrChild);
    safetyResourceChildSaveSI.setSafetyResourceChildList(safetyResourceChildListSave);
    
    //STGAP00014328:
    safetyResourceChildSaveSI.setUlIdStage(ulIdStage);
    safetyResourceChildSaveSI.setUlIdCase(ulIdCase);
    safetyResourceChildSaveSI.setUlIdPerson(user.getUserID());

  
    return safetyResourceChildSaveSI;
  }

  /**
   * This method populates the SafetyResourceChildRetrieveSI object.
   * 
   * @param context
   */
  private SafetyResourceChildRetrieveSI populateSafetyResourceChildRetrieveSI(GrndsExchangeContext context) {
  
    HttpServletRequest request = context.getRequest();
    SafetyResourceChildRetrieveSI safetyResourceChildRetrieveSI = new SafetyResourceChildRetrieveSI();
  
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
    int ulIdSrChild = Integer.parseInt(ContextHelper.getStringSafe(request, "hdnUlIdSrChild"));

    safetyResourceChildRetrieveSI.setUlIdEvent(ulIdEvent);
    safetyResourceChildRetrieveSI.setUlIdStage(ulIdStage);
    safetyResourceChildRetrieveSI.setUlIdSrChild(ulIdSrChild);
  
    return safetyResourceChildRetrieveSI;
  } 
  
  //STGAP00014329: Returns true if the user is the approver else false
  private boolean isCurrentActiveApprover(GrndsExchangeContext context) {
    boolean result = false;
    HttpServletRequest request = context.getRequest();
    int eventId = GlobalData.getUlIdEvent(request);
    if (eventId != 0) {
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      int loggedInUserId = userProfile.getUserID();
      int approverId = -1;
      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
      ApproversRetrieveSO so = common.retrieveApprovers(si);
      if (so.hasCurrentActiveApprover()) {
        approverId = so.getCurrentActiveApprover().getIdPerson();
      }
      // -- return true if user is approver
      if (loggedInUserId == approverId) {
        result = true;
      }
    }
    return result;
  }
  
  private void handleError(ServiceException we, GrndsExchangeContext context) {

    int errorCode = we.getErrorCode();
    
    if (Messages.MSG_CMN_TMSTAMP_MISMATCH == errorCode || Messages.MSG_SYS_EVENT_STS_MSMTCH == errorCode ||
                    Messages.MSG_SYS_STAGE_CLOSED == errorCode || Messages.MSG_DATABASE_SAVE_FAIL == errorCode){
      setErrorMessage(errorCode, context.getRequest());
    } else {
      processSevereException(context, we);
    }          
  }
} 