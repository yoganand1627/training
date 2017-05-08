package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

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
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePaymentOfCare;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PaymentOfCareSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB45SOG01;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain payment of care records in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date        User           Description
 *   --------    --------       --------------------------------------------------
 *  03/25/2008   vdevarak       STGAP00006420: Added new sqls to retrieve placement  
 *                              records to check gaps between placements.   
 *  04/21/2009   arege          STGAP00013397: Added changes for MR-033 Relative
 *                              Care Invoicing Changes.     
 *  05/04/2009   cwells         STGAP00010116: If Payment of Care = Relative Care Subsidy(RCS), Enhanced Relative Care Subsidy(ERS),Enhanced Subsidized Guardianship(ESG), 
 *                              Subsidized Guardianship (SUG), Non-Relative Subsidized Guardianship(NSG), Non-Relative Enhanced Subsidized Guardianship(NEG). 
 *   		                Then the Legal Status has to be Not in DFCS Custody - Custody to Relative(NPR) or Not in DFCS Custody - Guardianship(NGP).
 *   06/02/2009  arege          STGAP00013914 Added an additional condition to set the Page mode. 
 *   06/08/2009  arege          STGAP00014111 - Modified code to reflect design change of check box to radio button for 
 *                              the waiver options of 80%, 100% and custom waiver.
 *   07/01/2009  hjbaptiste     STGAP00014561: Set a new Presentation Branch "APPROVAL_SAVE" to the savePOC_xa() method to forward the approver back to the 
 *                              Payment Of Care page when in approval mode
 *   05/24/2011  hnguyen        SMS#109407: MR-087 Added new Child turns 18 checkbox.                
 *   06/01/2011  arege          SMS#108265: Added validation message on Save and Submit of POC of type Enhanced Relative Rate (ERR)
 *
 * </pre>
 */

public class PaymentOfCareConversation extends BaseHiddenFieldStateConversation {
  public static final String POC_INFORMATION = "casemgmt/PaymentOfCare/PaymentOfCareConversation";

  public static final String POC_TYPE = "pocType";

  public static final String TRUE = "true";

  private InvalidateApproval invalidateApproval = null;

  private SavePaymentOfCare savePaymentOfCare;

  public static final String SELECT_STAFF_PER_COMP = "btnSelectStaffPerComp";

  public static final String SELECT_STAFF_SUPRV_APPRV = "btnSelectStaffSuprvApprv";

  public static final String SELECT_STAFF_SO_APPRV = "btnSelectStaffSOApprv";

  public static final String SELECT_STAFF_RBWO_APPRV = "btnSelectStaffRBWOApprv";

  public static final String URL_RESOURCE_SEARCH_LIST = "/resource/ResourceSearch/results";

  public static final String ID_PERS_COMP = "idPersComp";

  public static final String ID_SUPRV_APPRV = "idSuprvApprv";

  public static final String ID_SO_STAFF_APPRV = "idSOStaffApprv";

  public static final String ID_RBWO_STAFF_APPRV = "idRBWOStaffApprv";

  public static final String TXT_REASON_SPEC_WAIVER = "txtReasonSpecWaiver";

  public static final String TXT_START_DATE = "txtStartDate";

  public static final String TXT_END_DATE = "txtEndDate";

  public static final String TXT_TERM_DATE = "txtTermDate";

  public static final String TXT_RELATIVE = "txtRelative";

  public static final String TXT_SPECIAL_RATE = "txtSpecialRate";

  public static final String CBX_CONC_PER_DIEM = "cbxConcPerDiem";

  public static final String TXT_PACKET_COMP = "txtPacketComp";

  public static final String IND_RBWO_TYPE = "scrIndRbwoType";

  public static final String NM_PERS_COMP = "txtPersComp";

  public static final String PERS_COMP_TITLE = "persCompTitle";

  public static final String TXT_PACKET_EMERG_APPRV = "txtPackEmergAppr";

  public static final String TXT_SUPRVAPPRV = "txtSuprvApprv";

  public static final String SUPRV_APPRV_TITLE = "suprvsrApprvTitle";

  public static final String TXT_PACKET_SENT = "txtPacketSent";

  public static final String TXT_STAFF_COMP = "txtStaffComp";

  public static final String TXT_SO_RESPONSE = "txtSOResponse";

  public static final String TXT_SO_STAFF_APPRV = "txtSOStaffApprv";

  public static final String SO_STAFF_APPRV_TITLE = "soStaffApprvTitle";

  public static final String TXT_RBWO_REVIEW = "txtRBWOReview";

  public static final String TXT_RBWO_STAFF_APPRV = "txtRBWOStaffApprv";

  public static final String RBWO_STAFF_APPRV_TITLE = "rbwoStaffApprvTitle";

  public static final String TXT_REASON_CONC_PER_DIEM = "txtReasonConcPerDiem";

  public static final String TXT_REASON_SPEC_PER_DIEM = "txtReasonSpecPerDiem";

  public static final String TXT_FC_RBWO_WAIVER = "txtFcRbwoWaiver";
  
  public static final String TXT_WAIVER_REASON = "txtWaiverReason"; // Per MR- 033
  
  public static final String TXT_WAIVER_AMOUNT = "txtWavierAmount"; // Per MR- 033
  
  public static final String TXT_WAIVER_AMOUNT_HDN = "hdnWavierAmount"; // Per MR- 033

  public static final String IND_RCS_TYPE = "scrIndRcsType";

  public static final String DT_AGREEMENT = "txtAgreeDate";

  public static final String DT_ANNUAL_REVIEW = "txtAnnualReviewDate";

  public static final String DT_EFF_PAY = "txtEffPayDate";

  public static final String DT_RENEWAL = "txtRenewalDate";

  public static final String DT_COURT_REVIEW = "txtCourtReviewDate";

  // MR-087 Add new Child turns 18 checkbox
  public static final String IND_18_BY_NEXT_CRT_RVW = "cbx18ByNextCrtRvw";

  public static final String FAMILY_INCOME_LESS = "cbxFamIncLess";

  public static final String SUBSIDY_PER_DIEM = "monthlySubsidy";

  public static final String IND_TERMINATE = "cbxTerminate";

  public static final String IND_SUSPEND = "cbxSuspend";
  
  public static final String REASON_SUSP_TERM = "txtReasonSuspTerm";

  public static final String ID_RELATIVE = "idRelative";

  public static final String SAVE_BUTTON_ON_POC = "btnSave";

  public static final String SAVE_SUBMIT_ON_POC = "btnSaveAndSubmit";

  public static final String POC_EVENT_DESC = "Payment Of Care";

  protected static final String RESOURCE_PULLBACK_INFO = ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST;

  // STGAP00004406
  public static final String IND_PROGRAM_TYPE = "scrIndProgramType";

  public static final String RBWO_PROGRAM_TYPE = "selRbwoProgramType";

  public static final String PROGRAM_TYPE_LABEL = "txtProgramType";

  // end STGAP00004406  

  private RetrievePaymentOfCare retrievePaymentOfCare;

  private Person person;

  private static final Map<String, String> APPROVAL_TASK_MAP = new HashMap<String, String>() {
    {
      // SUB
      put("9460", "9465");
      put("9470", "9475");
      put("8605", "8606"); // ADO
    }
  };

  public void setSavePaymentOfCare(SavePaymentOfCare savePaymentOfCare) {
    this.savePaymentOfCare = savePaymentOfCare;
  }

  public void setRetrievePaymentOfCare(RetrievePaymentOfCare retrievePaymentOfCare) {
    this.retrievePaymentOfCare = retrievePaymentOfCare;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void displayPOC_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayPOC_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String name = GlobalData.getSzNmStage(request);

    Boolean rights = hasStageAccessRights(context);
    if (!rights) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }
    try {
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      state.removeAllAttributes(request);

      // if there is no eventId the page is New
      if (GlobalData.getUlIdEvent(request) == 0 && rights == true) {
        pageMode = PageModeConstants.NEW;
        PageMode.setPageMode(pageMode, request);
      }

      PaymentOfCareRetrieveSI retrieveSI = this.populate_Retrieve(GlobalData.getUlIdEvent(request),
                                                                  GlobalData.getUlIdStage(request));
      PaymentOfCareRetrieveSO retrieveSO = new PaymentOfCareRetrieveSO();
      retrieveSO = retrievePaymentOfCare.retrievePaymentOfCare(retrieveSI);

      if (CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getCdEventStatus())
          && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }

      if (CodesTables.CEVTSTAT_APRV.equals(retrieveSO.getCdEventStatus())) {
        pageMode = PageModeConstants.VIEW;
      } else if (rights || GlobalData.isApprovalMode(request)) { //STGAP00013914 Added an additional condition.
        pageMode = PageModeConstants.EDIT;
      } else {
        pageMode = PageModeConstants.VIEW;
      }
      GlobalData.setUlIdEvent(retrieveSO.getUlIdEvent(), request);
      PageMode.setPageMode(pageMode, request);
      GlobalData.setSzNmStage(name, request);
      GlobalData.setUlIdPerson(retrieveSO.getUlIdPerson(), request);
      state.setAttribute("pocRetrieve", retrieveSO, request);

    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private PaymentOfCareRetrieveSI populate_Retrieve(int eventId, int stageId) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populate_Retrieve()");
    performanceTrace.enterScope();

    PaymentOfCareRetrieveSI pocRetrieve = new PaymentOfCareRetrieveSI();
    pocRetrieve.setUlIdEvent(eventId);
    pocRetrieve.setUlIdStage(stageId);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return pocRetrieve;
  }

  PaymentOfCareRetrieveSO populateSelects(GrndsExchangeContext context, PaymentOfCareRetrieveSO pocSelect) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateSelects()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      String pocType = ContextHelper.getStringSafe(request, POC_TYPE);
      pocSelect.setPocType(pocType);

      pocSelect.setIdPersonCompleting(ContextHelper.getIntSafe(request, ID_PERS_COMP));
      pocSelect.setIdSuprvsrApprv(ContextHelper.getIntSafe(request, ID_SUPRV_APPRV));
      pocSelect.setIdSOStaffApprv(ContextHelper.getIntSafe(request, ID_SO_STAFF_APPRV));
      pocSelect.setIdRBWOStaffApprv(ContextHelper.getIntSafe(request, ID_RBWO_STAFF_APPRV));
      pocSelect.setIdRelative(ContextHelper.getIntSafe(request, ID_RELATIVE));
      pocSelect.setStartDate(ContextHelper.getJavaDateSafe(request, TXT_START_DATE));
      pocSelect.setEndDate(ContextHelper.getJavaDateSafe(request, TXT_END_DATE));
      pocSelect.setDtTerminate(ContextHelper.getJavaDateSafe(request, TXT_TERM_DATE));
      pocSelect.setSpecialRate(ContextHelper.getDoubleSafe(request, TXT_SPECIAL_RATE));
      pocSelect.setIndConcurrentPerDiem(CheckboxHelper.getCheckboxValue(request, CBX_CONC_PER_DIEM));
      pocSelect.setDtPacketComplete(ContextHelper.getJavaDateSafe(request, TXT_PACKET_COMP));
      pocSelect.setIndRbwoType(ContextHelper.getStringSafe(request, IND_RBWO_TYPE));
      pocSelect.setNmPersonCompleting(ContextHelper.getStringSafe(request, NM_PERS_COMP));
      pocSelect.setPersCompTitle(ContextHelper.getStringSafe(request, PERS_COMP_TITLE));
      pocSelect.setDtEmergSupApprv(ContextHelper.getJavaDateSafe(request, TXT_PACKET_EMERG_APPRV));
      pocSelect.setNmSuprvsrApprv(ContextHelper.getStringSafe(request, TXT_SUPRVAPPRV));
      pocSelect.setSuprvsrApprvTitle(ContextHelper.getStringSafe(request, SUPRV_APPRV_TITLE));
      pocSelect.setDtPacketSent(ContextHelper.getJavaDateSafe(request, TXT_PACKET_SENT));
      pocSelect.setDtStaffingComplete(ContextHelper.getJavaDateSafe(request, TXT_STAFF_COMP));
      pocSelect.setDtStateOfficeResponse(ContextHelper.getJavaDateSafe(request, TXT_SO_RESPONSE));
      pocSelect.setTxtReasonSpecWaiver(ContextHelper.getStringSafe(request, TXT_REASON_SPEC_WAIVER));
      pocSelect.setNmSOStaffApprv(ContextHelper.getStringSafe(request, TXT_SO_STAFF_APPRV));
      pocSelect.setSoStaffApprvTitle(ContextHelper.getStringSafe(request, SO_STAFF_APPRV_TITLE));
      pocSelect.setDtRBWOReview(ContextHelper.getJavaDateSafe(request, TXT_RBWO_REVIEW));
      pocSelect.setNmRBWOStaffApprv(ContextHelper.getStringSafe(request, TXT_RBWO_STAFF_APPRV));
      pocSelect.setRbwoStaffApprvTitle(ContextHelper.getStringSafe(request, RBWO_STAFF_APPRV_TITLE));
      pocSelect.setTxtReasonConcurrentPD(ContextHelper.getStringSafe(request, TXT_REASON_CONC_PER_DIEM));
      pocSelect.setSpecFcRbwoWaiver(ContextHelper.getDoubleSafe(request, TXT_FC_RBWO_WAIVER));
      pocSelect.setIndRcsType(ContextHelper.getStringSafe(request, IND_RCS_TYPE));
      pocSelect.setAgreeDate(ContextHelper.getJavaDateSafe(request, DT_AGREEMENT));
      pocSelect.setAnnualRevDate(ContextHelper.getJavaDateSafe(request, DT_ANNUAL_REVIEW));
      pocSelect.setEffPaymentDate(ContextHelper.getJavaDateSafe(request, DT_EFF_PAY));
      pocSelect.setRenewDate(ContextHelper.getJavaDateSafe(request, DT_RENEWAL));
      pocSelect.setCourtRevDate(ContextHelper.getJavaDateSafe(request, DT_COURT_REVIEW));
      // MR-087 Add new Child turns 18 checkbox
      pocSelect.setInd18ByNextCrtRvw(CheckboxHelper.getCheckboxValue(request, IND_18_BY_NEXT_CRT_RVW));
      pocSelect.setIndFamIncomeLess(CheckboxHelper.getCheckboxValue(request, FAMILY_INCOME_LESS));
      pocSelect.setSubsidyPerDiem(ContextHelper.getDoubleSafe(request, SUBSIDY_PER_DIEM));
      pocSelect.setIndTerminate(CheckboxHelper.getCheckboxValue(request, IND_TERMINATE));
      pocSelect.setIndSuspend(CheckboxHelper.getCheckboxValue(request, IND_SUSPEND));
      pocSelect.setTxtReasonTerm(ContextHelper.getStringSafe(request, REASON_SUSP_TERM));
      pocSelect.setTxtReasonSpecializedPD(ContextHelper.getStringSafe(request, TXT_REASON_SPEC_PER_DIEM));
      pocSelect.setNmRelative(ContextHelper.getStringSafe(request, TXT_RELATIVE));
     
      //STGAP00013397- MR - 033
      String waiverSelected = ContextHelper.getStringSafe(request, "rbCWaiverOptions"); 

      String ind80PerDiem = CodesTables.CPERDIEM_W1.equals(waiverSelected)? ArchitectureConstants.Y : ArchitectureConstants.N;
      String ind100PerDiem = CodesTables.CPERDIEM_W2.equals(waiverSelected)? ArchitectureConstants.Y : ArchitectureConstants.N;
      String indCustomWaiver = CodesTables.CPERDIEM_W3.equals(waiverSelected)? ArchitectureConstants.Y : ArchitectureConstants.N;
      pocSelect.setInd80PerDiem(ind80PerDiem);
      pocSelect.setInd100PerDiem(ind100PerDiem);
      pocSelect.setIndCustomWaiver(indCustomWaiver);
      if(ArchitectureConstants.Y.equals(ind100PerDiem)){
      pocSelect.setWaiverAmount(ContextHelper.getDoubleSafe(request, TXT_WAIVER_AMOUNT_HDN));
      }else{
      pocSelect.setWaiverAmount(ContextHelper.getDoubleSafe(request, TXT_WAIVER_AMOUNT));
      }
      
      if(ArchitectureConstants.Y.equals(ind80PerDiem)){
      pocSelect.setTxtWaiverReason(StringHelper.EMPTY_STRING); 
      }else{
      pocSelect.setTxtWaiverReason(ContextHelper.getStringSafe(request, TXT_WAIVER_REASON));
      }
      // End STGAP00013397- MR - 033
      

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return pocSelect;
  }

  /**
   * Populates the object that is sent to the save service.
   * 
   * @param context
   * @return FosterCareParticipantSaveSI
   */
  PaymentOfCareSaveSI populatePOC_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populatePOC_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    PaymentOfCareSaveSI pocSave = new PaymentOfCareSaveSI();
    int idEvent = ContextHelper.getIntSafe(request, "hdnIdEvent");
    PaymentOfCareRetrieveSO pocFromState = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    try {
      String pocType = ContextHelper.getStringSafe(request, POC_TYPE);
      pocSave.setPocType(pocType);
      pocSave.setIdPersonCompleting(ContextHelper.getIntSafe(request, ID_PERS_COMP));
      pocSave.setIdSuprvsrApprv(ContextHelper.getIntSafe(request, ID_SUPRV_APPRV));
      pocSave.setIdSOStaffApprv(ContextHelper.getIntSafe(request, ID_SO_STAFF_APPRV));
      pocSave.setIdRBWOStaffApprv(ContextHelper.getIntSafe(request, ID_RBWO_STAFF_APPRV));
      pocSave.setIdRelative(ContextHelper.getIntSafe(request, ID_RELATIVE));
      
      if (request.getParameter(TXT_START_DATE) != null && !"".equals(request.getParameter(TXT_START_DATE))) {
        pocSave.setStartDate(ContextHelper.getJavaDateSafe(request, TXT_START_DATE));
      }
      if (request.getParameter(TXT_END_DATE) != null && !"".equals(request.getParameter(TXT_END_DATE))) {
        pocSave.setEndDate(ContextHelper.getJavaDateSafe(request, TXT_END_DATE));
      }
      if (request.getParameter(TXT_TERM_DATE) != null && !"".equals(request.getParameter(TXT_TERM_DATE))) {
        pocSave.setDtTerminate(ContextHelper.getJavaDateSafe(request, TXT_TERM_DATE));
      }
      if (request.getParameter(TXT_PACKET_COMP) != null && !"".equals(request.getParameter(TXT_PACKET_COMP))) {
        pocSave.setDtPacketComplete(ContextHelper.getJavaDateSafe(request, TXT_PACKET_COMP));
      }
      if (request.getParameter(TXT_PACKET_EMERG_APPRV) != null
          && !"".equals(request.getParameter(TXT_PACKET_EMERG_APPRV))) {
        pocSave.setDtEmergSupApprv(ContextHelper.getJavaDateSafe(request, TXT_PACKET_EMERG_APPRV));
      }
      if (request.getParameter(TXT_PACKET_SENT) != null && !"".equals(request.getParameter(TXT_PACKET_SENT))) {
        pocSave.setDtPacketSent(ContextHelper.getJavaDateSafe(request, TXT_PACKET_SENT));
      }
      if (request.getParameter(TXT_STAFF_COMP) != null && !"".equals(request.getParameter(TXT_STAFF_COMP))) {
        pocSave.setDtStaffingComplete(ContextHelper.getJavaDateSafe(request, TXT_STAFF_COMP));
      }
      if (request.getParameter(TXT_SO_RESPONSE) != null && !"".equals(request.getParameter(TXT_SO_RESPONSE))) {
        pocSave.setDtStateOfficeResponse(ContextHelper.getJavaDateSafe(request, TXT_SO_RESPONSE));
      }
      if (request.getParameter(TXT_RBWO_REVIEW) != null && !"".equals(request.getParameter(TXT_RBWO_REVIEW))) {
        pocSave.setDtRBWOReview(ContextHelper.getJavaDateSafe(request, TXT_RBWO_REVIEW));
      }
      if (request.getParameter(DT_AGREEMENT) != null && !"".equals(request.getParameter(DT_AGREEMENT))) {
        pocSave.setAgreeDate(ContextHelper.getJavaDateSafe(request, DT_AGREEMENT));
      }
      if (request.getParameter(DT_ANNUAL_REVIEW) != null && !"".equals(request.getParameter(DT_ANNUAL_REVIEW))) {
        pocSave.setAnnualRevDate(ContextHelper.getJavaDateSafe(request, DT_ANNUAL_REVIEW));
      }
      if (request.getParameter(DT_EFF_PAY) != null && !"".equals(request.getParameter(DT_EFF_PAY))) {
        pocSave.setEffPaymentDate(ContextHelper.getJavaDateSafe(request, DT_EFF_PAY));
      }
      if (request.getParameter(DT_RENEWAL) != null && !"".equals(request.getParameter(DT_RENEWAL))) {
        pocSave.setRenewDate(ContextHelper.getJavaDateSafe(request, DT_RENEWAL));
      }
      if (request.getParameter(DT_COURT_REVIEW) != null && !"".equals(request.getParameter(DT_COURT_REVIEW))) {
        pocSave.setCourtRevDate(ContextHelper.getJavaDateSafe(request, DT_COURT_REVIEW));
      }
      if (request.getParameter(IND_RCS_TYPE) != null && !"".equals(request.getParameter(IND_RCS_TYPE))) {
        pocSave.setIndRcsType(ContextHelper.getStringSafe(request, IND_RCS_TYPE));
      }
      if (request.getParameter(IND_RBWO_TYPE) != null && !"".equals(request.getParameter(IND_RBWO_TYPE))) {
        pocSave.setIndRbwoType(ContextHelper.getStringSafe(request, IND_RBWO_TYPE));
      }
      // STGAP00004406
      String indProgramType = ContextHelper.getStringSafe(request, IND_PROGRAM_TYPE);
      String rbwoProgramType = ContextHelper.getStringSafe(request, RBWO_PROGRAM_TYPE);
      if (StringHelper.isValid(indProgramType)) {
        pocSave.setIndProgramType(indProgramType);
      }
      if (StringHelper.isValid(rbwoProgramType)) {
        pocSave.setRbwoProgramType(rbwoProgramType);
      }
      // end STGAP00004406
      
      //STGAP00013397- MR-033
      String waiverSelected = ContextHelper.getStringSafe(request, "rbCWaiverOptions"); 
      String ind80PerDiem = CodesTables.CPERDIEM_W1.equals(waiverSelected)? ArchitectureConstants.Y : ArchitectureConstants.N;
      String ind100PerDiem = CodesTables.CPERDIEM_W2.equals(waiverSelected)? ArchitectureConstants.Y : ArchitectureConstants.N;
      String indCustomWaiver = CodesTables.CPERDIEM_W3.equals(waiverSelected)? ArchitectureConstants.Y : ArchitectureConstants.N;
      pocSave.setInd80PerDiem(ind80PerDiem);
      pocSave.setInd100PerDiem(ind100PerDiem);
      pocSave.setIndCustomWaiver(indCustomWaiver);
      //Save Waiver Amount only if the waiver option is 'Custom Waiver'
      if(ArchitectureConstants.Y.equals(indCustomWaiver)){
      pocSave.setWaiverAmount(ContextHelper.getDoubleSafe(request,TXT_WAIVER_AMOUNT));
      }else{
       pocSave.setWaiverAmount(0);
      }
      if(ArchitectureConstants.Y.equals(ind80PerDiem)){
      pocSave.setTxtWaiverReason(StringHelper.EMPTY_STRING);
      }else{
      pocSave.setTxtWaiverReason(ContextHelper.getStringSafe(request,TXT_WAIVER_REASON));
      }
      //End STGAP00013397- MR-033
      
      pocSave.setIndSuspend(CheckboxHelper.getCheckboxValue(request, IND_SUSPEND));
      pocSave.setIndTerminate(CheckboxHelper.getCheckboxValue(request, IND_TERMINATE));
      // MR-087 Add new Child turns 18 checkbox
      pocSave.setInd18ByNextCrtRvw(CheckboxHelper.getCheckboxValue(request, IND_18_BY_NEXT_CRT_RVW));
      pocSave.setIndFamIncomeLess(CheckboxHelper.getCheckboxValue(request, FAMILY_INCOME_LESS));
      pocSave.setIndConcurrentPerDiem(CheckboxHelper.getCheckboxValue(request, CBX_CONC_PER_DIEM));
      pocSave.setSpecialRate(ContextHelper.getDoubleSafe(request, TXT_SPECIAL_RATE));
      pocSave.setTxtReasonSpecWaiver(ContextHelper.getStringSafe(request, TXT_REASON_SPEC_WAIVER));
      pocSave.setTxtReasonConcurrentPD(ContextHelper.getStringSafe(request, TXT_REASON_CONC_PER_DIEM));
      pocSave.setSpecFcRbwoWaiver(ContextHelper.getDoubleSafe(request, TXT_FC_RBWO_WAIVER));
      pocSave.setTxtReasonTerm(ContextHelper.getStringSafe(request, REASON_SUSP_TERM));
      pocSave.setTxtReasonSpecializedPD(ContextHelper.getStringSafe(request, TXT_REASON_SPEC_PER_DIEM));
      pocSave.setUlIdStage(ContextHelper.getIntSafe(request, "ulIdStage"));
      pocSave.setUlIdEvent(idEvent);
      pocSave.setIdUser(user.getUserID());
      pocSave.setIdCase(GlobalData.getUlIdCase(request));
      pocSave.setSzCdTask(ContextHelper.getStringSafe(request, "szCdTask"));
    
      ROWCCMN01UIG00 rowccmn01uigoo = new ROWCCMN01UIG00();
      rowccmn01uigoo.setSzCdEventType(CodesTables.CEVNTTYP_POC);

      String POC_TASK_CODE = ContextHelper.getStringSafe(request, "szCdTask");
      if (DateHelper.isNull(pocFromState.getDtEventOccurred())) {
        rowccmn01uigoo.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      } else {
        rowccmn01uigoo.setDtDtEventOccurred(DateHelper.toCastorDate(pocFromState.getDtEventOccurred()));
      }
      // STGAP00002379 - Payment of Care event status stays APRV in case of termination
      // In case of approver approving Payment, status will be changed to APRV, handled by SaveApprovalImpl
      // If approver modifies the page, stays PEND
      // So here only make it PROC when none of those happens
      // STGAP00004549 - added check on APRV stat: end date allowed to change after approval
      if (!GlobalData.isApprovalMode(request) && DateHelper.isNull(pocSave.getDtTerminate())
          && !CodesTables.CEVTSTAT_APRV.equals(pocFromState.getCdEventStatus())) {
        rowccmn01uigoo.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
      } else {
        rowccmn01uigoo.setSzCdEventStatus(pocFromState.getCdEventStatus());
      }
      rowccmn01uigoo.setUlIdEvent(idEvent);
      rowccmn01uigoo.setSzCdTask(POC_TASK_CODE);
      rowccmn01uigoo.setUlIdStage(ContextHelper.getIntSafe(request, "ulIdStage"));
      // STGAP00002538
      String dtStartEffDate = DateHelper.isNull(pocSave.getStartDate()) ? FormattingHelper
                                                                                          .formatDate(pocSave
                                                                                                             .getEffPaymentDate())
                                                                       : FormattingHelper
                                                                                         .formatDate(pocSave
                                                                                                            .getStartDate());
      String desc = POC_EVENT_DESC + " " + Lookup.simpleDecodeSafe(CodesTables.CPOCTYPE, pocType) + " Start "
                    + dtStartEffDate;
      if (!DateHelper.isNull(pocSave.getDtTerminate())) {
        desc = desc + " Terminated " + FormattingHelper.formatDate(pocSave.getDtTerminate());
      }
      rowccmn01uigoo.setSzTxtEventDescr(desc);
      // end STGAP00002538
      pocSave.setRowccmn01uig00(rowccmn01uigoo);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return pocSave;
  }

  /**
   * This method is called to display the Foster Care Participant page on an add after the participant type is selected.
   * 
   * @param context
   */
  public void reloadPOC_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reloadPOC_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PaymentOfCareRetrieveSO pocReload = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);

    try {

      if (request.getParameter(POC_TYPE) != null && !"".equals(request.getParameter(POC_TYPE))) {
        pocReload.setPocType(ContextHelper.getStringSafe(request, POC_TYPE));
      }

      state.setAttribute("pocRetrieve", pocReload, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Accesses the service to check if it is valid to save.
   * 
   */
  private boolean checkIsValid(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean isValid = true;
    Date startDate = ContextHelper.getJavaDateSafe(request, "txtStartDate");
    Date effectiveDate = ContextHelper.getJavaDateSafe(request, "txtEffPayDate");
    int idPocEvent = GlobalData.getUlIdEvent(request);
    if (DateHelper.isNull(startDate)) {
      startDate = effectiveDate;
    }
    Date endDate = null;
    if (request.getParameter(TXT_END_DATE) != null && !"".equals(request.getParameter(TXT_END_DATE))) {
      endDate = ContextHelper.getJavaDateSafe(request, TXT_END_DATE);
    }
    int idStage = GlobalData.getUlIdStage(request);
    String indConcurrent = CheckboxHelper.getCheckboxValue(request, PaymentOfCareConversation.CBX_CONC_PER_DIEM);

    // STGAP00005190 - note that terminate date is before or at end date so if there is terminate date, it is safe to
    // make end date equal terminate date and pass to 'checkStartDateOverlapsEndDate'
    Date terminateDate = ContextHelper.getJavaDateSafe(request, TXT_TERM_DATE);
    if (!DateHelper.isNull(terminateDate)) {
      endDate = terminateDate;
    }
    // end STGAP00005190

    int saveOptionNumber = savePaymentOfCare.checkStartDateOverlapsEndDate(idPocEvent, startDate, endDate, idStage,
                                                                           indConcurrent);
    if (saveOptionNumber == 1 && ArchitectureConstants.N.equals(indConcurrent)) {
      isValid = false;
      setPresentationBranch("PAYMENT_OF_CARE", context);
      PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
      retrieveSO = populateSelects(context, retrieveSO);
      state.setAttribute("pocRetrieve", retrieveSO, request);
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SUB_PERIOD_OVERLAP_1), request);
    } else if (saveOptionNumber == 2 && ArchitectureConstants.N.equals(indConcurrent)) {
      isValid = false;
      setPresentationBranch("PAYMENT_OF_CARE", context);
      PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
      retrieveSO = populateSelects(context, retrieveSO);
      state.setAttribute("pocRetrieve", retrieveSO, request);
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SUB_PERIOD_OVERLAP_2), request);
    } else if (saveOptionNumber == 0) {
      isValid = true;
    } else if (ArchitectureConstants.Y.equals(indConcurrent) && (saveOptionNumber == 1 || saveOptionNumber == 2)) {
      isValid = false;
      setPresentationBranch("PAYMENT_OF_CARE", context);
      PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
      retrieveSO = populateSelects(context, retrieveSO);
      state.setAttribute("pocRetrieve", retrieveSO, request);
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_ONE_CONCUR_ONLY), request);
    }
    return isValid;
  }

  
  private boolean checkGardAndRelCustody(ROWCSUB45SOG01 legalStatus) {
    return (legalStatus != null && (CodesTables.CLEGSTAT_NGP.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NPR.equals(legalStatus.getSzCdLegalStatStatus())));
  }
  
  
  private boolean checkHasLegalStatus(ROWCSUB45SOG01 legalStatus) {
    return (legalStatus != null && (CodesTables.CLEGSTAT_NAF.equals(legalStatus.getSzCdLegalStatStatus())
                                    || "".equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NCT.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NCD.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NCO.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NTT.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NCE.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NGP.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NPC.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_NPR.equals(legalStatus.getSzCdLegalStatStatus())
                                    || CodesTables.CLEGSTAT_PCT.equals(legalStatus.getSzCdLegalStatStatus()) || CodesTables.CLEGSTAT_PVL
                                                                                                                                        .equals(legalStatus
                                                                                                                                                           .getSzCdLegalStatStatus())));
  }

  private boolean checkHasLegalStatusCounty(ROWCSUB45SOG01 legalStatus) {
    return (legalStatus != null && StringHelper.isValid(legalStatus.getSzCdLegalStatCnty()));
  }

  private ROWCSUB45SOG01 findLegalStatus(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    int idStage = GlobalData.getUlIdStage(request);
    Date dtEffPayDate = ContextHelper.getJavaDateSafe(request, DT_EFF_PAY);
    Date dtStartDate = ContextHelper.getJavaDateSafe(request, TXT_START_DATE);
    String pocType = request.getParameter(POC_TYPE);
    ROWCSUB45SOG01 rowcsub45sog01;
    if ((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)
         || CodesTables.CPOCTYPE_SUG.equals(pocType) || CodesTables.CPOCTYPE_ESG.equals(pocType)
         || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType))) {
      rowcsub45sog01 = savePaymentOfCare.findLegalStatus(idStage, dtEffPayDate);
    } else {
      rowcsub45sog01 = savePaymentOfCare.findLegalStatus(idStage, dtStartDate);
    }
    return rowcsub45sog01;
  }

  /**
   * Sends a populated object to the save service then returns to the calling page.
   * 
   * @param context
   */
  public void savePOC_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFCParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    //STGAP00006420: Added the next 3 lines to enable the Gap messages.
    boolean bSaveIsPressed = true;
    request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
    String sysIndPrfrmValidation = ContextHelper.getStringSafe(request,"hdnBSysIndPrfrmValidation");
    try {
      boolean isValid = true;
      //STGAP00006420: Added the if condition to make sure once the user ignores the gap message and 
      //decides to continue with the save the gap validation is switched off and the record is saved.
      if (ArchitectureConstants.Y.equals(sysIndPrfrmValidation)) {
        isValid = checkIsValid(context);
      }
      // invalidate before populate SaveSI so that can use populate to demote pending as well
      if (CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getCdEventStatus())
          && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
        invalidateApproval.invalidateApproval(ccmn05ui);
      }

      PaymentOfCareSaveSI pocSave = this.populatePOC_Save(context);
      // If not being saved by approver or terminated by either approver or case manager
      // Do not validate Payment of Care if this is approver approving or modifying the Payment.
      // Do not validate if case manager terminates the page
      // STGAP00005190 - Validate at all time now
      // if (!GlobalData.isApprovalMode(request) && DateHelper.isNull(pocSave.getDtTerminate())) {
      // }
      if (isValid) {
        // pocSave.getRowccmn01uig00().setSzCdEventStatus("PROC");
        savePaymentOfCare.savePaymentOfCare(pocSave);

        // Set the PageMode to MODIFY in case in was ADD before the save.
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      } else { // redisplay page without losing previous page data that has not been saved
        setPresentationBranch("PAYMENT_OF_CARE", context);
        retrieveSO = populateSelects(context, retrieveSO);
        state.setAttribute("pocRetrieve", retrieveSO, request);
      }
      if (GlobalData.isApprovalMode(request)) {
        setPresentationBranch("APPROVAL_SAVE", context);
      }
    } catch (ServiceException wtc) {
      //STGAP00006420: Added the next line to set an indicator to indicate if save or  
      //save and submit button is pressed after the gap message is confirmed by the user.
      request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Sends a populated object to the save service then forwards to the todo detail page for approval
   * 
   * @param context
   */
  public void saveAndSubmitPOC_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitPOC_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    //STGAP00006420: Added the next 3 lines to enable the Gap messages.
    boolean bSaveIsPressed = false;
    request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
    String sysIndPrfrmValidation = ContextHelper.getStringSafe(request, "hdnBSysIndPrfrmValidation");
    try {
      boolean isValid = true;
      //STGAP00006420: Added the if condition to make sure once the user ignores the gap message and 
      //decides to continue with the save the gap validation is switched off and the record is saved.
      if (ArchitectureConstants.Y.equals(sysIndPrfrmValidation)) {
        isValid = checkIsValid(context);
      }
      boolean saveAndSubmit = true;

      // Child has to have DOB at time of submitting for approval
      int childId = GlobalData.getUlIdPerson(request);
      boolean childHasDob = savePaymentOfCare.childHasDob(GlobalData.getUlIdPerson(request));
      if (!childHasDob) {
        setPresentationBranch("PAYMENT_OF_CARE", context);
        retrieveSO = populateSelects(context, retrieveSO);
        state.setAttribute("pocRetrieve", retrieveSO, request);
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CHILD_DOB_REQUIRED), request);
      }

      // get poc type from request to include case when user click save and submit in new page (retrieveSO is blank)
      String pocType = ContextHelper.getStringSafe(request, POC_TYPE);
      // SMS#108265
      boolean relativeAssmtIsApproved = true;
      if (CodesTables.CPOCTYPE_ERR.equals(pocType)) {
        int idStage = ContextHelper.getIntSafe(request, "ulIdStage");
        relativeAssmtIsApproved = savePaymentOfCare.isRelativeCareAssessmentApproved(idStage);
      }
      if (CodesTables.CPOCTYPE_ERR.equals(pocType) && !relativeAssmtIsApproved) {
        setPresentationBranch("PAYMENT_OF_CARE", context);
        retrieveSO = populateSelects(context, retrieveSO);
        state.setAttribute("pocRetrieve", retrieveSO, request);
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_REL_ASSMT_REQD), request);
        saveAndSubmit = false;
      }

      boolean relativeIsApproved = true;
      ROWCSUB45SOG01 legalStatus = findLegalStatus(context);

      boolean hasLegalStatus = false;
      int nbrLegalStatusErrorMsg;
     //STGAP00010116 -If Payment of Care = Relative Care Subsidy(RCS), Enhanced Relative Care Subsidy(ERS),Enhanced Subsidized Guardianship(ESG), Subsidized Guardianship (SUG), Non-Relative Subsidized Guardianship(NSG), Non-Relative Enhanced Subsidized Guardianship(NEG). 
     //Then the Legal Status has to be Not in DFCS Custody - Custody to Relative(NPR) or Not in DFCS Custody - Guardianship(NGP). 
     String stageType = GlobalData.getSzCdStage(request);
      if((CodesTables.CSTAGES_SUB.equals(stageType) && (CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)
                      || CodesTables.CPOCTYPE_SUG.equals(pocType) || CodesTables.CPOCTYPE_ESG.equals(pocType)
                      || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType))))  {
        hasLegalStatus = checkGardAndRelCustody(legalStatus); 
       nbrLegalStatusErrorMsg = Messages.MSG_REL_SUB_LEG_STAT_REQ;
      } else if ("ERS".equals(pocType) || "RCS".equals(pocType)) {
        hasLegalStatus = checkHasLegalStatus(legalStatus);
        nbrLegalStatusErrorMsg = Messages.MSG_REL_SUB_TPR_REQ;
      } else {
        hasLegalStatus = checkHasLegalStatusCounty(legalStatus);
        nbrLegalStatusErrorMsg = Messages.MSG_LEG_STAT_REQ;
      }
      if (isValid && relativeIsApproved && hasLegalStatus) {
        String ccfcMessageInReq = (String) state.getAttribute("ccfcMessageInReq", request);
        if ((!ArchitectureConstants.Y.equals(ccfcMessageInReq))
            && (CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)
                || CodesTables.CPOCTYPE_SUG.equals(pocType) || CodesTables.CPOCTYPE_ESG.equals(pocType)
                || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType))) {
          int idStage = ContextHelper.getIntSafe(request, "ulIdStage");
          relativeIsApproved = savePaymentOfCare.isRelativeCareApproved(childId, idStage);
          if (!relativeIsApproved) {
            setPresentationBranch("PAYMENT_OF_CARE", context);
            retrieveSO = populateSelects(context, retrieveSO);
            state.setAttribute("pocRetrieve", retrieveSO, request);
            state.setAttribute("ccfcMessageInReq", ArchitectureConstants.Y, request);
            setInformationalMessage(Messages.MSG_NO_CCFA_REL_SUB, request);
            saveAndSubmit = false;
          }
        }
      } else {
        saveAndSubmit = false;
        if (!hasLegalStatus) {
          setPresentationBranch("PAYMENT_OF_CARE", context);
          retrieveSO = populateSelects(context, retrieveSO);
          state.setAttribute("pocRetrieve", retrieveSO, request);
          setErrorMessage(MessageLookup.getMessageByNumber(nbrLegalStatusErrorMsg), request);
        }
      }
      // STGAP00005845 - presentation branch for save and submit was only set inside the 'if' block 
      // regarding 'ccfcMessageInReq' above causing grnds error where there is no ccfc error
      // Move it here to cover all scenarios 
      if (saveAndSubmit) {
        // only invalidate approval when every thing is good to submit
        if (CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getCdEventStatus())
            && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
          CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
          invalidateApproval.invalidateApproval(ccmn05ui);
        }

        PaymentOfCareSaveSI pocSave = this.populatePOC_Save(context);
        pocType = pocSave.getPocType();

        pocSave.getRowccmn01uig00().setSzCdEventStatus("COMP");

        PaymentOfCareSaveSI savePOC = savePaymentOfCare.savePaymentOfCare(pocSave);

        GlobalData.setUlIdEvent(savePOC.getUlIdEvent(), request);

        int ulIdEvent = savePOC.getUlIdEvent();
        int ulIdCase = GlobalData.getUlIdCase(request);
        int ulIdStage = savePOC.getUlIdStage();
        setPresentationBranch("TO_DO", context);
        String szCdTask = APPROVAL_TASK_MAP.get(savePOC.getSzCdTask());
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      }
      // end STGAP00005845
    } catch (ServiceException wtc) {
      //STGAP00006420: Added the next line to set an indicator to indicate if save or  
      //save and submit button is pressed after the gap message is confirmed by the user.
      request.setAttribute("bSaveIsPressed", StringHelper.EMPTY_STRING + bSaveIsPressed);
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void deletePOC_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deletePOC_xa()");
    performanceTrace.enterScope();

    try {

      PaymentOfCareSaveSI pocDelete = this.populatePOC_Save(context);

      pocDelete.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
      savePaymentOfCare.savePaymentOfCare(pocDelete);

    } catch (ServiceException wtc) {
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  public void getResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getResource_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
      if (retrieveSO == null) {
        retrieveSO = new PaymentOfCareRetrieveSO();
      }
      // get page data
      retrieveSO = populateSelects(context, retrieveSO);
      state.setAttribute("pocRetrieve", retrieveSO, request);

    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void selectPocResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrievePocResource_xa");
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
      if (retrieveSO == null) {
        retrieveSO = new PaymentOfCareRetrieveSO();
      }
      // get page data
      retrieveSO = populateSelects(context, retrieveSO);
      state.setAttribute("pocRetrieve", retrieveSO, request);

      ResourceSearchPullBackInfo resourceSearchPullBackInfo = new ResourceSearchPullBackInfo();
      resourceSearchPullBackInfo.setDestinationUrl("/casemgmt/PaymentOfCare/setPocResource");
      request.setAttribute(RESOURCE_PULLBACK_INFO, resourceSearchPullBackInfo);

      forward(URL_RESOURCE_SEARCH_LIST, request, response);

    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void setPocResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setPocResource_xa");
    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
      populateResource(request, retrieveSO);

      request.setAttribute("pocRetrieve", retrieveSO);

    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  protected void populateResource(HttpServletRequest request, PaymentOfCareRetrieveSO paymentOfCareRetrieve) {
    CRES03SO cres03so = (CRES03SO) request.getAttribute(RESOURCE_PULLBACK_INFO);
    if (cres03so == null) {
      return;
    }
    request.removeAttribute(RESOURCE_PULLBACK_INFO);
    int idResourceIdForPullback = 0;
    idResourceIdForPullback = cres03so.getUlIdResource();
    if (idResourceIdForPullback != 0) {
      paymentOfCareRetrieve.setIdRelative(cres03so.getUlIdResource());
      paymentOfCareRetrieve.setNmRelative(String.valueOf(cres03so.getSzNmResource()));
    }
  }
  
  /**
   * Temporarily saves the state of data on the Foster Care Participant page then forwards to the Staff Search page.
   * When the user returns to the FosterCareParticipant all page data is still entered.
   * 
   * @param context
   */
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String selectStaffPerComp = SELECT_STAFF_PER_COMP + ".x";
    boolean bSelectStaffPerComp = ContextHelper.getString(request, selectStaffPerComp) != null;
    String selectStaffSuprvApprv = SELECT_STAFF_SUPRV_APPRV + ".x";
    boolean bSelectStaffSuprvApprv = ContextHelper.getString(request, selectStaffSuprvApprv) != null;
    String selectStaffSOApprv = SELECT_STAFF_SO_APPRV + ".x";
    boolean bSelectStaffSOApprv = ContextHelper.getString(request, selectStaffSOApprv) != null;
    String selectStaffRBWOApprv = SELECT_STAFF_RBWO_APPRV + ".x";
    boolean bSelectStaffRBWOApprv = ContextHelper.getString(request, selectStaffRBWOApprv) != null;

    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    if (retrieveSO == null) {
      retrieveSO = new PaymentOfCareRetrieveSO();
    }

    retrieveSO = populateSelects(context, retrieveSO);

    state.setAttribute("pocRetrieve", retrieveSO, request);
    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.OTHER);

    if (bSelectStaffPerComp) {
      io.setDestinationUrl("/casemgmt/PaymentOfCare/setStaffPerComp");
    } else if (bSelectStaffSuprvApprv) {
      io.setDestinationUrl("/casemgmt/PaymentOfCare/setStaffSuprvApprv");
    } else if (bSelectStaffSOApprv) {
      io.setDestinationUrl("/casemgmt/PaymentOfCare/setStaffSOApprv");
    } else if (bSelectStaffRBWOApprv) {
      io.setDestinationUrl("/casemgmt/PaymentOfCare/setStaffRBWOApprv");
    }
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
   * object for display on the Foster Care Participant page.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void setStaffPerComp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    if (retrieveSO == null) {
      retrieveSO = new PaymentOfCareRetrieveSO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      retrieveSO.setNmPersonCompleting(staff.getSzNmPersonFull());
      retrieveSO.setIdPersonCompleting(staff.getUlIdPerson());
      retrieveSO.setPersCompTitle(Lookup.simpleDecodeSafe(CodesTables.CEMPJBCL, staff.getSzCdEmployeeClass()));
    }
    state.setAttribute("pocRetrieve", retrieveSO, request);

    performanceTrace.exitScope();
  }

  public void setStaffSuprvApprv_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    if (retrieveSO == null) {
      retrieveSO = new PaymentOfCareRetrieveSO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      retrieveSO.setNmSuprvsrApprv(staff.getSzNmPersonFull());
      retrieveSO.setIdSuprvsrApprv(staff.getUlIdPerson());
      // retrieveSO.setSuprvsrApprvTitle(staff.getSzCdJobTitle());
      retrieveSO.setSuprvsrApprvTitle(Lookup.simpleDecodeSafe(CodesTables.CEMPJBCL, staff.getSzCdEmployeeClass()));
    }
    state.setAttribute("pocRetrieve", retrieveSO, request);

    performanceTrace.exitScope();
  }

  public void setStaffSOApprv_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    if (retrieveSO == null) {
      retrieveSO = new PaymentOfCareRetrieveSO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      retrieveSO.setNmSOStaffApprv(staff.getSzNmPersonFull());
      retrieveSO.setIdSOStaffApprv(staff.getUlIdPerson());
      // retrieveSO.setSoStaffApprvTitle(staff.getSzCdJobTitle());
      retrieveSO.setSoStaffApprvTitle(Lookup.simpleDecodeSafe(CodesTables.CEMPJBCL, staff.getSzCdEmployeeClass()));
    }
    state.setAttribute("pocRetrieve", retrieveSO, request);

    performanceTrace.exitScope();
  }

  public void setStaffRBWOApprv_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PaymentOfCareRetrieveSO retrieveSO = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);
    if (retrieveSO == null) {
      retrieveSO = new PaymentOfCareRetrieveSO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      retrieveSO.setNmRBWOStaffApprv(staff.getSzNmPersonFull());
      retrieveSO.setIdRBWOStaffApprv(staff.getUlIdPerson());
      // retrieveSO.setRbwoStaffApprvTitle(staff.getSzCdJobTitle());
      retrieveSO.setRbwoStaffApprvTitle(Lookup.simpleDecodeSafe(CodesTables.CEMPJBCL, staff.getSzCdEmployeeClass()));
    }
    state.setAttribute("pocRetrieve", retrieveSO, request);

    performanceTrace.exitScope();
  }

  /**
   * Checks to see if the user has access to this stage.
   * 
   * @param context
   * @return hasStageAccess
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /**
   * Handles any errors generated in any other methods of the class.
   * 
   * @param we
   * @param context
   */
  public void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage = null;
    switch (we.getErrorCode()) {
    case Messages.MSG_CMN_OVERLAP_ADD:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_OVERLAP_ADD);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_CMN_ON_CALL_TOO_MANY:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_ON_CALL_TOO_MANY);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_SYS_STAGE_CLOSED:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_SAVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_SYS_MULT_INST:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      setErrorMessage(errorMessage, POC_INFORMATION, request);
      break;
      //STGAP00006420: Added the next 3 cases to display gap Messages.
    case Messages.MSG_SUB_GAP_EXISTS_1:
      request.setAttribute("errorCode", Messages.MSG_SUB_GAP_EXISTS_1);
      //data wasn't saved; refresh what was on the page
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      setPresentationBranch("PAYMENT_OF_CARE", context);
      break;
    case Messages.MSG_SUB_GAP_EXISTS_2:
      
      request.setAttribute("errorCode", Messages.MSG_SUB_GAP_EXISTS_2);
      //data wasn't saved; refresh what was on the page
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      setPresentationBranch("PAYMENT_OF_CARE", context);
      break;
    case Messages.MSG_SUB_GAP_EXISTS_3:
      request.setAttribute("errorCode", Messages.MSG_SUB_GAP_EXISTS_3);
      //data wasn't saved; refresh what was on the page
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      setPresentationBranch("PAYMENT_OF_CARE", context);
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
  }

  private CCMN05UI populateCCMN05UI_InvalidateApproval(int idEvent) {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    ccmn05ui.setUlIdEvent(idEvent);
    ccmn05ui.setArchInputStruct(input);

    return ccmn05ui;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

}