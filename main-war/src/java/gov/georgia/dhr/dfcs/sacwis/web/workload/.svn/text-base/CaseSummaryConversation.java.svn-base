package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.PageSizeNbr;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CFMgmntList;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC41SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC41SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveStageVerifiedListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * General: ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE MobileCaseSummaryConversation.java FOR
 * NECESSARY MOBILE CHANGES
 * <p/>
 * This is the Conversation class used to display the list of stages for an entire case coming from either the Assigned
 * Workload or Case List page. Users can also view Special Handling(sub-module), Case Management, Case Merge/Split,
 * Records Rentention information displayed in expandable sections.
 * <p/>
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 08/07/03  Merle Demo  Sir19133 updated setUlPageSizeNbr for  CARC14S.SRC  to match what is in ccfc40so.h
 *                       CCFC40SO__ROWCCFC40SOG00_SIZE = 20.  Added new class PageSizeNbr contains only static
 *                       variables for all the rows to be returned
 * 11/13/03  CORLEYAN    SIR 22410 Put in page number so that pagination would work
 * 01/25/04  Hadjimh     SIR 22579: When a case is merged with another case, carry forward all information in the
 *                       closed case's Locating Information textbox on the Case File Management window to the same
 *                       field for the Case Forward Case.
 * 05/17/04  CORLEYAN    SIR 22493 - If on Case Merge Split, the only messages returned from the error list are
 *                       MSG_CFC_MERGE_PEND or MSG_CFC_POST_ADOPT_STG then allow the user to merge the cases without
 *                       error
 * 07/08/04  Hadjimh     SIR#23007. User should not be able to merge case A to Case B, then Split, then merge Case B to
 *                       Case A.  This creates a Circular Merge, but message does not display.
 * 08/12/04 Codrea Alina SIR#22960. A sensitive case has a "!" in Assigned Workload page. When one navigates to Case
 *                       Summary page of a sensitive case, in the Special Handling section, the Sensitive Case checkbox
 *                       must be displayed checked.
 * 04/20/05  CORLEYAN    SIR 23530 - Added Date Stage Start into global data so that The tabs will display correctly.
 * 05/12/05  cooganpj    SIR 23572 - Use Case Utilty method getCaseCheckoutStatus to display an informational message
 *                       if a case is checked out to Mobile IMPACT.
 * 5/19/05   cooganpj    SIR 23572 - Display message only if case is not pending stage progression approval
 * 06/01/05  Hadjimh     SIR#14411. Intake received date is incorrect after a case merge of two open INV stages. When
 *                       merging open INV stages with open INV stages, the merge to case must have the earliest intake
 *                       date. If the worker has entered the merge with the case to case being the newer case, the case
 *                       ids must be switched prior to the merge. An message box should tell the worker the cases have
 *                       been switched to allow the case to case be the case with the earliest intake date.
 * 07/05/05  cooganpj    SIR 23726 - Update message on Case Summary to check for service delivery closure event, and
 *                       add code necessary to show checked out messages on case merge/split detail pages and to
 *                       validate merge/splits for checked out stages.
 * 08/29/05  anandv      Added MOBILE-IMPACT comments at the General section.
 * 08/30/05  Hadjimh     SIR#23617. Overall Disposition does not display for Licensing cases. changed the ccmn15d.pc
 *                       DAM to dynamic DAM because Overall Disposition exists not only in CPS_INVST_DETAIL table but
 *                       also in APS_INVST_DETAIL, LICENSING_INVST_DTL and FACILITY_INVST_DTL tables.
 * 09/08/05  Hadjimh     SIR#23645. Staff who access case summary page in modify mode (assigned worker, those above
 *                       worker in unit hierarchy) should be able to merge case information--even if the user does not
 *                       have the case merge attribute. Currently, the "ADD" button is not displayed if the case merge
 *                       attribute is absent from the user's profile, even for cases/stages assigned to the user or
 *                       accessible via unit summary/summary workload.
 * 10/03/05 cooganpj    SIR 23966 - Added code so that MSG_CASE_CHECKEDOUT does not display for AFC pend mode.
 * 07/04/08 mchillmna    added code to determine if Sibling Group Information should display
 * 07/17/2009 bgehlot  STGAP00014341: MR51- Stage Reopen Changes
 * 09/15/2009 bgehlot  STGAP00015366: If VC is selected then throw the message MSG_ARI_NO_REVIEW_VC
 * 09/19/2009 arege    STGAP00015330  User received incorrect error message on clicking ReOpen Stage button for Open stages.
 * 08/30/2010 wjcochran SMS #66752: Updated to work with Red Flag indicator for stages. 
 * 
 * </pre>
 *
 * @author Marie Au-Young, December 16, 2002
 */

public class CaseSummaryConversation extends BaseHiddenFieldStateConversation {

  public static final String SORT_BY_DATE = "9";
  public static final String TRACE_TAG = "CaseSummaryConversation";
  public static final String CASE_STATUS_OPEN = "Open";
  public static final String CASE_STATUS_CLOSED = "Closed";

  public static final String DISPLAY_URI = "/workload/CaseSummary/displayCaseSummary";
  public static final String ASSIGNED_WORKLOAD_URI = "/workload/AssignedWorkload/displayAssignedWorkload";
  public static final String ACTION_CODE_ADD = "A";
  public static final String ACTION_CODE_UPDATE = "U";
  public static final String ACTION_CODE_VALIDATE = "V";

  public static final String INDICATOR_YES = ArchitectureConstants.Y;
  public static final String INDICATOR_NO = ArchitectureConstants.N;

  public static final String ACTION_CODE_MERGE = "M";
  public static final String ACTION_CODE_SPLIT = "S";
  public static final String ACTION_CODE_VOID_MERGE = "V";
  public static final String ACTION_CODE_VOID_SPLIT = "Z";

  public static final String SINGLE_SPACE = " ";
  public static final String EMPTY_STRING = "";
  public static final String STRING_NULL = "null";

  public static final String CHECK = "1";
  public static final String NO_CHECK = "0";

  public static final String STAGE_INV = "INV";
  public static final String PROG_AFC = "AFC";
  public static final String ALLEGED_PERPS_ONLY = "Z";
  public static final String CAPS_WIN_MODE_PRINC_ONLY = "P";

  public static final String CASE_PROGRAM_AFC = "AFC";
  public static final String CASE_PROGRAM_APS = "APS";
  public static final String CASE_PROGRAM_CCL = "CCL";
  public static final String CASE_PROGRAM_RCL = "RCL";
  public static final String CASE_PROGRAM_LIC = "LIC";

  public static final String VALIDATE_BAD = INDICATOR_NO;
  public static final String VALIDATE_SUCCESS = INDICATOR_YES;

  public static final String FSU_STAGE = "FSU";
  public static final String SUB_STAGE = "SUB";
  public static final String FRE_STAGE = "FRE";
  public static final String PAD_STAGE = "PAD";
  //STGAP00014341
  public static final String ADO_STAGE = "ADO";
  public static final String FPR_STAGE = "FPR";
  public static final String DIV_STAGE = "DIV";
  public static final String PFC_STAGE = "PFC";

  public static final String INV_STAGE = "INV";
  public static final String ARI_STAGE = "ARI";
  public static final String FAD_STAGE = "FAD";
  public static final String ARF_STAGE = "ARF";

  public static final String PAGE_E = "pageE";
  public static final String PAGE_F = "pageF";
  public static final String PAGE_G = "pageG";
  public static final String PAGE_H = "pageH";

  public static final String HAS_REC_RET = "indHasRecordsRet";

  public static final String SUC_VAL = "SUC_VAL";

  //sir#14411
  public static final String MERGE_BY_INTAKE_DATE = "Merge_By_Intake_Date";
  public static final String SWITCH_CASES = "S";

  public static final int SEARCH_RESULTS_PER_PAGE = 50;
  public static final int LIST_RESULTS_MAX = 50;

  //SIR 23726
  public static final String INV_CONCL_TASK_CODE = "2120";
  public static final String SVC_CONCL_TASK_CODE = "6010";
  public static final String AOC_CONCL_TASK_CODE = "5090";

  public static final String SORT_ASCENDING = "ASC";
  private Admin admin;
  private CFMgmntList CFMgmntListEjb;
  private CaseMgmt caseMgmt;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setCaseMgmt(CaseMgmt caseMgmt){
    this.caseMgmt = caseMgmt;
  }
  public void setCFMgmntListEjb(CFMgmntList CFMgmntListEjb) {
    this.CFMgmntListEjb = CFMgmntListEjb;
  }

  /**
   * This method is called by the GRNDS controller when a user searches for case summaries. Also displays Special
   * Handling, Case File Management, Case Merge/Split, and Records Retention.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayCaseSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseSummary_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    //Lenses Link to Case Summary
    int globalLensesCaseId = 0;
    String lensesCaseIdStr = (String)request.getAttribute(AuthenticatedPrsHttpServlet.LENSES_CASE_ID);
    if (StringHelper.isValid(lensesCaseIdStr)){
      try{
        globalLensesCaseId = Integer.valueOf(lensesCaseIdStr);
      }catch (NumberFormatException nfe){
        globalLensesCaseId = 0;
      }
    }
    if (globalLensesCaseId > 0) {
      //Checking whether the user has access to view the Case
      if (!isCaseViewable(context,globalLensesCaseId)){
        try{
          //Set the error message and redirect to Assigned Workload
          setErrorMessage("You do not have the security to view the case you requested.", ASSIGNED_WORKLOAD_URI, request);
          //setErrorMessage(Messages.MSG_NO_SEC_VIEW_CASE, ASSIGNED_WORKLOAD_URI, request);
          forward(ASSIGNED_WORKLOAD_URI, request, context.getResponse());
          return;
        } catch (ServletException se) {
          processSevereException(context, se);
        }
      }
    }
    // SPB - 4/10/03 The metaphor uses the taskCode to determine the active tabs hence it needs to be cleared here
    //   to avoid having Case Summary Show under the tabs of its calling page.
    GlobalData.setSzCdTask(null, request);

    // Pagination
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(SEARCH_RESULTS_PER_PAGE);

    //Get the profile of the logged in user
    UserProfile user = UserProfileHelper.getUserProfile(context);

    try {
      // Clear state
      state.removeAllAttributes(request);

      //call the Tuxedo service using the WtcHelper object for Case Summary retrieve
      CCMN37SI ccmn37si = populateCCMN37SI_CaseSummaryRetrieve(context, tuxPagination);

      CCMN37SO ccmn37so = admin.retrieveCaseSummary(ccmn37si);
      //STGAP00010749: If the case is a PAD case than set the PAd case indicator, Pad case Id,
      //and Ado case Id in Global Data
      if(ArchitectureConstants.Y.equals(ccmn37so.getBIndPadCase())){
        GlobalData.setPadCase(true, request);
        GlobalData.setUlIdAdoCase(ccmn37so.getUlIdAdoCase(), request);
        GlobalData.setUlIdPadCase(ccmn37so.getUlIdPadCase(), request);
      }
      //call the Tuxedo service using the WtcHelper object for Special Handling retrieve
      CCMN81SI ccmn81si = populateCCMN81SI_SpecialHandlingRetrieve(context);
      CCMN81SO ccmn81so = admin.findCapsCase(ccmn81si);

      //call the Tuxedo service using the WtcHelper object for Case Merge/Split retrieve
      CCFC39SI ccfc39si = populateCCFC39SI_CaseMergeSplitRetrieve(context);
      CCFC39SO ccfc39so = admin.findCaseMergeList(ccfc39si);

      //call the Tuxedo service using the WtcHelper object for Case File Management retrieve
      CCFC21SI ccfc21si = populateCCFC21SI_CaseMgmntRetrieve(context);
      CCFC21SO ccfc21so = admin.retrieveCaseFileManagement(ccfc21si);

      //Get the case summary info into its own variable.
      ROWCCMN37SOG01 caseSummary = ccmn37so.getROWCCMN37SOG01();

      // SPB - SIR 22445 - Need to get program type in case previous conversation did not set it
      // into GlobalData as is the case when coming from CallLog (Intake)
      ROWCCMN37SOG02_ARRAY programArray = ccmn37so.getROWCCMN37SOG02_ARRAY();
      if (programArray != null) {
        ROWCCMN37SOG02 programRow = programArray.getROWCCMN37SOG02(0);
        String strPrgmType = programRow.getSzCdStageProgram();
        GlobalData.setSzCdStageProgram(strPrgmType, request);
      }

      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn37so.getBMoreDataInd());
      ccmn37so.setArchOutputStruct(archOutputStruct);

      //pagination for caseSummary list box
      tuxPagination.setPaginationInformation(ccmn37so.getArchOutputStruct(),
                                             programArray != null ? programArray.getROWCCMN37SOG02Count() : 0);

      // set the tuxedo bean as an attribute on the request
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

      //Set Case Summary Errors and Warnings
      CaseWatchSI caseWatchSI = new CaseWatchSI();
      caseWatchSI.setIdStage(GlobalData.getUlIdStage(request));
      CaseErrorsSO caseErrorsSO = caseMgmt.retrieveCwCaseErrors(caseWatchSI);
      CaseWarningsSO caseWarningsSO = caseMgmt.retrieveCwCaseWarnings(caseWatchSI);
      state.setAttribute("CaseErrorsSO", caseErrorsSO, request);
      state.setAttribute("CaseWarningsSO", caseWarningsSO, request);
      
      //Set the output object into state
      state.setAttribute("CCMN37SO", ccmn37so, request);
      state.setAttribute("CCMN81SO", ccmn81so, request);
      state.setAttribute("CCFC39SO", ccfc39so, request);
      state.setAttribute("CCFC21SO", ccfc21so, request);

      //Check for Case Status
      String caseStatus;
      if (DateHelper.isNull(caseSummary.getDtDtCaseClosed())) {
        caseStatus = CASE_STATUS_OPEN;
      } else {
        caseStatus = CASE_STATUS_CLOSED; // van - debug went in here
        //call the Tuxedo service using the WtcHelper object for Records Retention retrieve
        request.setAttribute(HAS_REC_RET, "Y");
        CCFC19SI ccmn19si = populateCCFC19SI_RecordsRetentionRetrieve(context);
        CCFC19SO ccmn19so = admin.findRecordsRetention(ccmn19si);
        state.setAttribute("CCFC19SO", ccmn19so, request);
      }
      request.setAttribute("caseStatus", caseStatus);

      // We are taking the Case Merge/Split List that appears on the Case Summary and removing any duplicate rows
      //   created from having a pending split. First we loop throught the list to see what rows are marked to split.
      // We take the From and To id's and place them into an array list.
      ROWCCFC39SOG00_ARRAY caseMergeArray = ccfc39so.getROWCCFC39SOG00_ARRAY();
      Enumeration caseMergeEnum = caseMergeArray.enumerateROWCCFC39SOG00();
      List<Integer> from = new LinkedList<Integer>();
      List<Integer> to = new LinkedList<Integer>();
      while (caseMergeEnum.hasMoreElements()) {
        ROWCCFC39SOG00 caseMergeRow = (ROWCCFC39SOG00) caseMergeEnum.nextElement();
        if (ACTION_CODE_SPLIT.equals(caseMergeRow.getCIndCaseMergePending())) {
          from.add(caseMergeRow.getUlIdCaseMergeFrom());
          to.add(caseMergeRow.getUlIdCaseMergeTo());
        }
      }

      // Next we loop through the list again and check to see what row having matching From and To id's.
      //   We skip the marked for split rows. When we find a match, place its index in the removal array list.
      List<ROWCCFC39SOG00> removalIndex = new LinkedList<ROWCCFC39SOG00>();
      caseMergeEnum = caseMergeArray.enumerateROWCCFC39SOG00();
      while (caseMergeEnum.hasMoreElements()) {
        ROWCCFC39SOG00 caseMergeRow = (ROWCCFC39SOG00) caseMergeEnum.nextElement();
        if (!ACTION_CODE_SPLIT.equals(caseMergeRow.getCIndCaseMergePending())) {
          int size = from.size();
          for (int i = 0; i < size; i++) {
            if (caseMergeRow.getUlIdCaseMergeFrom() == from.get(i) && caseMergeRow.getUlIdCaseMergeTo() == to.get(i)) {
              removalIndex.add(caseMergeRow);
            }
          }
        }
      }

      // Finally, if we remove the rows from the list in ascending order, the indexes will be off.  We iterate
      // through the removal array in descending order, so we don't change the index of the starting rows.
      int loopCount = removalIndex.size() - 1;
      for (int i = loopCount; i >= 0; i--) {
        caseMergeArray.removeROWCCFC39SOG00(removalIndex.get(i));
      }

      request.setAttribute("caseMergeArray", caseMergeArray);

      hasStageAccess(user, context);
      setSpecialHandlingPageSet(user, context);
      setCaseMergePageSet(user, context);
      setCaseFileMgmtPageSet(user, context);
      setRecordsRetentionPageSet(user, context);

      if (GlobalData.getUlIdStage(request) != 0) {
        CaseUtility.Stage currentStage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
        GlobalData.setSzNmStage(currentStage.getNmStage(), request);
        GlobalData.setSzNmCase(currentStage.getNmCase(), request);
        // SIR 23530 - Also set date stage start into global data for the current stage
        GlobalData.setDtDtStageStart(currentStage.getDtStart(), request);
        GlobalData.setSzCdCounty(ccmn37so.getROWCCMN37SOG01().getSzCdCaseCounty(), request);
        String formattedStageName = FormattingHelper.formatStringSpecialChars(GlobalData.getSzNmStage(request), "\\\"");
        String stageMessage =
                MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_CURRENT_STAGE),
                                                  formattedStageName);
        setInformationalMessage(MessageLookup.addMessageParameter(stageMessage, Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage(request))),
                                DISPLAY_URI, context.getRequest());
        //SIR 23726 - Hide for both investigation and service delivery closure events
        String conclTaskCode = SVC_CONCL_TASK_CODE;
        if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))) {
          conclTaskCode = INV_CONCL_TASK_CODE;
        } else if (CodesTables.CSTAGES_AOC.equals(GlobalData.getSzCdStage(request))) {
          conclTaskCode = AOC_CONCL_TASK_CODE;
        }

        CaseUtility.Event apsCnclEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
                                                              conclTaskCode);

        boolean pendStageProg = (apsCnclEvent.getCdEventStatus() != null &&
                                 CodesTables.CEVTSTAT_PEND.equals(apsCnclEvent.getCdEventStatus()))
                                ||
                                CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request));

        if (CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request)) && !pendStageProg) {
          setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, DISPLAY_URI, context.getRequest());
        }
        
        //determine to display the SiblingGroupInformation tab
        checkSiblingGroupInformationAvailableTabDisplay(context);
      }
      // SIR 22579: this function gets the Locating Information
      locatingInformation(context);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
        // There is no Records Retention data for this case due to converted data.
        case Messages.MSG_REC_RETN_NOT_FOUND:
          setInformationalMessage(errorCode, DISPLAY_URI, request);
          // SPB SIR 22406 - Set indicator in request attribute then on JSP put value into hidden field
          // then check request parameter on save_xa to call populateRecordsRetention if
          // HAS_REC_RET is "Y" or not call it if HAS_REC_RET is "N"
          request.setAttribute(HAS_REC_RET, "N");
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
          processSevereException(context, se);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "displayCaseSummary_xa:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method creates an admin review for an INV stage. It takes the user to the Person List to select a person and
   * then creates an ARI stage.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void callCaseFilePrint_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".caseFilePrint_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //set values needed Case File Print for a STAGE
    String hdnUlIdStage = request.getParameter("hdnUlIdStage");
    if (StringHelper.isValid(hdnUlIdStage) &&
        !STRING_NULL.equals(hdnUlIdStage)) {
      setStageInGlobalData(request);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method determines what admin review command was passed in through the JSP, then forwards to the appropriate
   * command.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void callAdminCommand_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "callAdminCommand_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String adminCommand = ContextHelper.getStringSafe(request, "hdnAdminCommand");
    if (adminCommand.equals(StringHelper.EMPTY_STRING)) {
      adminCommand = DISPLAY_URI;
    }
    try {
      forward(adminCommand, request, context.getResponse());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method creates an admin review for an INV stage. It takes the user to the Person List to select a person and
   * then creates an ARI stage.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void createAdmnReview_CheckPersonList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createAdmnReview_CheckPersonList_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    setStageInGlobalData(request);

    try {
      hasStageAccess(getUserProfile(request), context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Could not complete hasStageAccess in createAdmnReview_CheckPersonList_xa()");
      GrndsTrace.msg(TRACE_TAG, 7, BasePrsException.getStackTrace(e));
    }

    setSavedPageMode(context, GlobalData.getAppMode(request));

    //If stage is an INV stage, prepare to call the personList pullback
    if (ContextHelper.getStringSafe(request, "hdnSzCdStage").equals(STAGE_INV)) {
      String pageMode = (GlobalData.getSzCdStageProgram(request).equals(PROG_AFC)) ?
                        ALLEGED_PERPS_ONLY : CAPS_WIN_MODE_PRINC_ONLY;

      PersonListPullBackInfo personListPBInfo = new PersonListPullBackInfo();
      personListPBInfo.setDestinationUrl("/workload/CaseSummary/createAdmnReview_CallCCFC42S");
      PageMode.setPageMode(pageMode, request);
      request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPBInfo);
    }
    //If not INV stage, create an AdminReview
    else {
      setPresentationBranch("stay", context);
      createAdmnReview_CallCCFC42S_xa(context);
    }

    performanceTrace.exitScope();
  }

  private String getSavedPageMode(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    return (String) state.getAttribute("caseSummaryPageMode", context.getRequest());
  }

  private void setSavedPageMode(GrndsExchangeContext context, String value) {
    BaseSessionStateManager state = getSessionStateManager(context);
    state.setAttribute("caseSummaryPageMode", value, context.getRequest());
  }

  /**
   * This method creates an Admin Review stage for FAD stages. It creates and ARF stage automatically.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void createAdmnReview_CallCCFC42S_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createAdmnReview_CallCCFC42S_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      String pageMode = getSavedPageMode(context);
      if (pageMode != null) {
        PageMode.setPageMode(pageMode, request);
        setSavedPageMode(context, null);
      }
      String personName = EMPTY_STRING;
      int personID = 0;
      PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo)
              context.getRequest().getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);

      if (personListPullBackInfo != null) {
        ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
        personName = rowcinv01sog00.getSzNmPersonFull();
        personID = rowcinv01sog00.getUlIdPerson();
      }
      CCFC42SI ccfc42si = populateCCFC42SI_CreateAdminReview(context, personName, personID);
      CCFC42SO ccfc42so = admin.saveCreateAdminReview(ccfc42si);

      request.setAttribute("CCFC42SO", ccfc42so);

      String infoMessage = MessageLookup.getMessageByNumber(Messages.MSG_AR_CREATE_SUCCESS);
      setInformationalMessage(infoMessage, DISPLAY_URI, context.getRequest());
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_CFC_NOT_CONF_PERP:            // ccfc18w.win : 5324
        case Messages.MSG_AR_CURR_OPEN:                 // ccfc18w.win : 5348
        case Messages.MSG_ADMIN_REV_EXISTS:             // ccfc18w.win : 5373
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:         // ccfc18w.win : 5398
        case Messages.MSG_DUPLICATE_RECORD:             // ccfc18w.win : 5422
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:         // ccfc18w.win : 5447
        case Messages.MSG_ARI_NO_REVIEW_DV_VC: //STGAP00015366: If VC is selected then throw the message
          setErrorMessage(errorCode, DISPLAY_URI, request);
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

    setStageInGlobalData(request);

    performanceTrace.exitScope();
  }

  /**
   * This method routes the user to the Admin Review page to view the review. Only closed ARI or ARF stages can access
   * the Admin Review page
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void callAdmnReview_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callAdmnReview_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //set values needed for adminReview into GlobalData
    setStageInGlobalData(request);

    performanceTrace.exitScope();
  }

  /**
   * This method sets the GlobalData neccessary to change the context of the page from CASE to STAGE or refreshes the
   * context to a different STAGE altogether.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void selectStage_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".  selectStage_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    setStageInGlobalData(request);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user saves information on the Case Summary page. The
   * expandable sections use this method to save.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveCaseSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".  saveCaseSummary_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      //Call the populate input helper method for Special Handling  (must be a closed case)
      CCMN82SI ccmn82si = populateCCMN82SI_SpecialHandlingAUD(context, ACTION_CODE_UPDATE);
      CCMN81SO retrieveCCMN81SO = (CCMN81SO) state.getAttribute("CCMN81SO", request);
      CCMN37SO retrieveCCMN37SO = (CCMN37SO) state.getAttribute("CCMN37SO", request);
      //WtcTransactionHandle wth = null;
      try {
        // begin a transaction
    	ROWCCMN37SOG02_ARRAY caseSummaryArray = retrieveCCMN37SO.getROWCCMN37SOG02_ARRAY();
    	ROWCCMN37SOG02[] rowccmn37sog02array = caseSummaryArray.getROWCCMN37SOG02();
    	List<Integer> verifiedStageIds = new ArrayList<Integer>();
    	List<String> verifiedStageInds = new ArrayList<String>();
    	  
    	for (int i = 0; i < rowccmn37sog02array.length; i++) {
          String checkboxValue = CheckboxHelper.getCheckboxValue(request, "cbStageRedFlag_" + i);
          ROWCCMN37SOG02 rowccmn37sog02 = rowccmn37sog02array[i];
          verifiedStageIds.add(rowccmn37sog02.getUlIdStage());
          verifiedStageInds.add(checkboxValue);
    	}
    	// Save the Stage validated check boxes
    	SaveStageVerifiedListSI saveStageVerifiedListSI = new SaveStageVerifiedListSI();
    	saveStageVerifiedListSI.setVerifiedStageIds(verifiedStageIds);
    	saveStageVerifiedListSI.setVerifiedStageInds(verifiedStageInds);
    	admin.updateSummaryRedFlagCaseStages(saveStageVerifiedListSI);
    	  
        if (isSpecialHandlingChanged(ccmn82si, retrieveCCMN81SO)) {
          //call the Tuxedo service using the WtcHelper object for Special Handling
          admin.updateCapsCase(ccmn82si);
        }

        CCFC21SO ccfc21so = (CCFC21SO) state.getAttribute("CCFC21SO", context.getRequest());
        boolean add = ccfc21so.getTsLastUpdate() == null;

        //Call the populate input helper method for Case File Mgmt  (must be a closed case)
        CCFC22SI ccfc22si = populateCCFC22SI_CaseMgmntUpdate(context, add ? ACTION_CODE_ADD : ACTION_CODE_UPDATE);

        if (isCaseFileMgmtChanged(ccfc22si, ccfc21so)) {
          //call the Tuxedo service using the WtcHelper object for Case File Mgmt
          //WtcHelper.callService("CCFC22S", ccfc22si.toString(), wth.getTuxedoConnection());
          admin.saveCaseFileManagement(ccfc22si);
        }

        String caseStatus;
        if (ccfc21so == null) {
          ccfc21so = new CCFC21SO();
        }

        if (ccfc21so.getDtDtCaseClosed() == null) {
          caseStatus = CASE_STATUS_OPEN;
        } else {
          caseStatus = CASE_STATUS_CLOSED;

          // SPB - SIR 22406
          // Only call the populate method for Records Retention if case has
          // Records Retention section (must be a closed case)
          if (("Y").equals(request.getParameter(HAS_REC_RET))) {
            CCFC20SI ccfc20si = populateCCFC20SI_RecordsRetentionUpdate(context,
                                                                        ACTION_CODE_UPDATE);

            CCFC19SO ccfc19so = (CCFC19SO) state.getAttribute("CCFC19SO",
                                                              context.getRequest());

            if (isRecordsRetentionChanged(ccfc20si, ccfc19so)) {
              //call the Tuxedo service using the WtcHelper object for Records Retention
              //WtcHelper.callService("CCFC20S", ccfc20si.toString(), wth.getTuxedoConnection());
              admin.saveRecordsRetention(ccfc20si);
            }
          }
        }
        request.setAttribute("caseStatus", caseStatus);
      } finally {
        // end the transaction
        //WtcHelper.endTuxedoTransaction(wth);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        // for any of the following messages, look up the string value and display it
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:         // CCMN73W.win : 1865
        case Messages.MSG_CMN_UPDATE_FAILED:            // CCMN73W.win : 1875
        case Messages.MSG_CMN_INVALID_UNIT:             // CCFC19W.win : 2135
        case Messages.MSG_CMN_INVALID_OFFICE:           // CCFC19W.win : 2144
          setErrorMessage(errorCode, DISPLAY_URI, request);
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "displayCaseSummary_xa:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  private boolean isSpecialHandlingChanged(CCMN82SI saveIn, CCMN81SO retrieveOut) {
    boolean isChanged = false;
    if (retrieveOut == null) {
      isChanged = true;
    } else {
      SpecHD inSpecHD = saveIn.getSpecHD();
      gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD outSpecHD = retrieveOut.getSpecHD();
      if (!(inSpecHD.getBIndCaseSensitive().equals(outSpecHD.getBIndCaseSensitive()) &&
            inSpecHD.getBIndCaseWorkerSafety().equals(outSpecHD.getBIndCaseWorkerSafety()) &&
            inSpecHD.getSzCdCaseSpeclHndlg().equals(outSpecHD.getSzCdCaseSpeclHndlg()) &&
            inSpecHD.getSzTxtCaseSensitiveCmnts().equals(outSpecHD.getSzTxtCaseSensitiveCmnts()) &&
            inSpecHD.getSzTxtCaseWorkerSafety().equals(outSpecHD.getSzTxtCaseWorkerSafety()))) {
        isChanged = true;
      }
    }
    GrndsTrace.msg(TRACE_TAG + ".isSpecialHandlingChanged", 7, "Changed indicator=" + isChanged + ".");
    return isChanged;
  }

  private boolean isCaseFileMgmtChanged(CCFC22SI saveIn, CCFC21SO retrieveOut) {
    boolean isChanged = false;
    if (retrieveOut == null) {
      isChanged = true;
    } else if (!saveIn.getSzAddrCaseFileCity().equals(retrieveOut.getSzAddrCaseFileCity()) ||
               !saveIn.getSzAddrCaseFileStLn1().equals(retrieveOut.getSzAddrCaseFileStLn1()) ||
               !saveIn.getSzAddrCaseFileStLn2().equals(retrieveOut.getSzAddrCaseFileStLn2()) ||
               !saveIn.getSzAddrMailCode().equals(retrieveOut.getSzAddrMailCode()) ||
               !saveIn.getSzCdCaseFileOfficeType().equals(retrieveOut.getSzCdCaseFileOfficeType()) ||
               !saveIn.getSzCdCaseProgram().equals(retrieveOut.getSzCdCaseProgram()) ||
               !saveIn.getSzCdOfficeRegion().equals(retrieveOut.getSzCdOfficeRegion()) ||
               !saveIn.getSzNbrUnit().equals(retrieveOut.getSzNbrUnit()) ||
               !saveIn.getSzNmCaseFileOffice().equals(retrieveOut.getSzNmCaseFileOffice()) ||
               !saveIn.getSztxtCaseFileLocateInfo().equals(retrieveOut.getSztxtCaseFileLocateInfo()) ||
               !saveIn.getSzTxtPriorCmnts().equals(retrieveOut.getSzTxtPriorCmnts())) {
      isChanged = true;
    } else {
      org.exolab.castor.types.Date inDateClosed = retrieveOut.getDtDtCaseClosed();
      org.exolab.castor.types.Date outDateClosed = retrieveOut.getDtDtCaseClosed();
      org.exolab.castor.types.Date inDateComplete = saveIn.getDtDtCaseFileArchCompl();
      org.exolab.castor.types.Date outDateComplete = retrieveOut.getDtDtCaseFileArchCompl();
      org.exolab.castor.types.Date inDateElig = saveIn.getDtDtCaseFileArchElig();
      org.exolab.castor.types.Date outDateElig = retrieveOut.getDtDtCaseFileArchElig();

      if ((inDateClosed != null && outDateClosed != null &&
           DateHelper.isBefore(inDateClosed, DateHelper.MAX_CASTOR_DATE) &&
           DateHelper.minutesDifference(inDateClosed, outDateClosed) != 0)
          ||
          (inDateComplete != null && outDateComplete != null &&
           DateHelper.isBefore(inDateComplete, DateHelper.MAX_CASTOR_DATE) &&
           DateHelper.minutesDifference(inDateComplete, outDateComplete) != 0)
          ||
          (inDateElig != null && inDateElig != null &&
           DateHelper.isBefore(inDateElig, DateHelper.MAX_CASTOR_DATE) &&
           DateHelper.minutesDifference(inDateElig, outDateElig) != 0)) {
        isChanged = true;
      }
    }
    GrndsTrace.msg(TRACE_TAG + ".isCaseFileMgmtChanged", 7, "Changed indicator=" + isChanged + ".");
    return isChanged;
  }

  private boolean isRecordsRetentionChanged(CCFC20SI saveIn, CCFC19SO retrieveOut) {
    boolean isChanged = false;
    if (retrieveOut == null) {
      isChanged = true;
    } else {
      if (!(saveIn.getSzCdRecRtnRetenType().equals(retrieveOut.getSzCdRecRtnRetenType())) ||
          !(saveIn.getSzTxtRecRtnDstryDtRsn().equals(retrieveOut.getSzTxtRecRtnDstryDtRsn()))) {
        isChanged = true;
      } else {
        org.exolab.castor.types.Date inDateDstryActual = saveIn.getDtDtRecRtnDstryActual();
        org.exolab.castor.types.Date outDateDstryActual = retrieveOut.getDtDtRecRtnDstryActual();
        org.exolab.castor.types.Date inDateDstryElig = saveIn.getDtDtRecRtnDstryElig();
        org.exolab.castor.types.Date outDateDstryElig = retrieveOut.getDtDtRecRtnDstryElig();
        if ((inDateDstryActual != null &&
             DateHelper.isBefore(inDateDstryActual, DateHelper.MAX_CASTOR_DATE) &&
             DateHelper.minutesDifference(inDateDstryActual, outDateDstryActual) != 0)
            ||
            (inDateDstryElig != null &&
             DateHelper.isBefore(inDateDstryElig, DateHelper.MAX_CASTOR_DATE) &&
             DateHelper.minutesDifference(inDateDstryElig, outDateDstryElig) != 0)) {
          isChanged = true;
        }
      }
    }
    GrndsTrace.msg(TRACE_TAG + ".isRecordsRetentionChanged", 7, "Changed indicator=" + isChanged + ".");
    return isChanged;
  }

  /**
   * This method is called by the GRNDS controller when a user navigates to the Case Merge/Split Detail page by clicking
   * the Add pushbutton in order to merge a case.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void addCaseMergeDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addCaseMergeDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CCMN37SO ccmn37so = (CCMN37SO) state.getAttribute("CCMN37SO", request);
      ROWCCMN37SOG01 caseSummary = ccmn37so.getROWCCMN37SOG01();

      request.setAttribute("hdnCReqFuncCd", ServiceConstants.REQ_FUNC_CD_ADD);
      request.setAttribute("hdnDataAction", ACTION_CODE_MERGE);
      request.setAttribute("txtSzScrNmCaseMrgTo", String.valueOf(caseSummary.getSzNmCase()));
      request.setAttribute("txtUlIdCaseMergeTo", String.valueOf(caseSummary.getUlIdCase()));
      Sets.setPageSet(Sets.D, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "addCaseMergeDetail_xa:" + e.getMessage());
      processSevereException(context, e);
    }

    //displays informational message reminding the user to merge persons if needed
    if (request.getAttribute("hdnCReqFuncCd").equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      String stageMessage = MessageLookup.getMessageByNumber(Messages.MSG_MRG_PERSON_MRG_CASE);
      setInformationalMessage(stageMessage, DISPLAY_URI, context.getRequest());
    }

    //SIR 23726 - Show checked out message if accessed from a checked out stage
    if (CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))
        && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user navigates to the Case Merge/Split Detail page by clicking
   * the Add pushbutton in order to merge a case.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayValidate_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayValidate_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CCMN37SO ccmn37so = (CCMN37SO) state.getAttribute("CCMN37SO", request);
      ROWCCMN37SOG01 caseSummary = ccmn37so.getROWCCMN37SOG01();

      request.setAttribute("hdnCReqFuncCd", ServiceConstants.REQ_FUNC_CD_KEEP);
      request.setAttribute("hdnDataAction", ACTION_CODE_MERGE);
      request.setAttribute("txtSzScrNmCaseMrgTo", String.valueOf(caseSummary.getSzNmCase()));
      request.setAttribute("txtUlIdCaseMergeFrom", ContextHelper.getStringSafe(request, "txtUlIdCaseMergeFrom"));

      Sets.setPageSet(Sets.D, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "displayValidate_xa:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user navigates to the Case Merge/Split Detail page. The user
   * can split a merged case or void a pending merge/split.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayCaseMergeSplitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".  displayCaseMergeSplitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CCFC39SI ccfc39si = populateCCFC39SI_CaseMergeSplitRetrieve(context);
      CCFC39SO ccfc39so = admin.findCaseMergeList(ccfc39si);

      setCaseMergeDetailPageSet(context, ccfc39so);

      if (ccfc39so != null) {
        ROWCCFC39SOG00_ARRAY nameRowArray = ccfc39so.getROWCCFC39SOG00_ARRAY();
        int idCaseMerge = ContextHelper.getIntSafe(context, "idCaseMerge");
        Enumeration nameRowEnum = nameRowArray.enumerateROWCCFC39SOG00();
        ROWCCFC39SOG00 selectedName = null;
        while (nameRowEnum.hasMoreElements()) {
          ROWCCFC39SOG00 tempRow = (ROWCCFC39SOG00) nameRowEnum.nextElement();
          if (tempRow.getUlIdCaseMerge() == idCaseMerge) {
            selectedName = tempRow;
            request.setAttribute("hdnCReqFuncCd", ServiceConstants.REQ_FUNC_CD_UPDATE);
            request.setAttribute("hdnDataAction", ACTION_CODE_SPLIT);
            break;
          }
        }
        state.setAttribute("currentRow", selectedName, request);
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "displayCaseMergeSplitDetail_xa:" + e.getMessage());
      processSevereException(context, e);
    }

    //SIR 23726 - show checked out message if accessed from a checked out stage
    if (CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))
        && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      setInformationalMessage(Messages.MSG_CASE_CHECKEDOUT, request);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method inlcudes the logic for displaying the Case Merge/Split detail.
   * <p/>
   * If the case if in PEND status, then only the Void Pending pushbutton should appear. Otherwise, the Split or Merge
   * pushbutton will appear, but Void Pending will not. For Merge details, the Validate pushbutton will also appear.
   *
   * @param context
   * @param ccfc39so
   */
  protected void setCaseMergeDetailPageSet(GrndsExchangeContext context, CCFC39SO ccfc39so) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "setCaseMergeDetailPageSet()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    String pendStatus = ContextHelper.getString(request, "pendStatus");
    String staffNameSplit = ContextHelper.getString(request, "staffNameSplit");

    //If the case is in PEND status: hide validate, split, and merge pushbutton --> show VOID PENDING
    if (pendStatus.equals(INDICATOR_YES)) {
      Sets.setPageSet(Sets.A, request);
    } else if (staffNameSplit == null || EMPTY_STRING.equals(staffNameSplit)) {
      //The case selected has been merged: hide merge, voidPending, and validate pushbutton --> SHOW SPLIT
      Sets.setPageSet(Sets.B, request);
    } else {
      //The case selected has been split after a merge: hide all buttons
      Sets.setPageSet(Sets.C, request);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method determines if the user can has access to a particular stage if coming from workload in the context of a
   * stage. If coming from Case List in the context of a case, the method first checks if the user has access to the
   * most recently opened "open" stage. If all stages are closed, then the method checks to see if the user has access
   * to the most recently opened "closed" stage.
   *
   * @param context
   */
  protected void hasStageAccess(UserProfile user, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". hasStageAccess()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    int ulIdStage = GlobalData.getUlIdStage(request);
    int ulIdCase = GlobalData.getUlIdCase(request);
    Boolean bHasAccess = Boolean.FALSE;
    // This boolean is false if the stage selected is not closed.  If the page
    // is loading for the first time, and there is no stage selected it will
    // default to false.  This will happen if we are coming from case search
    boolean closed = request.getParameter("hdnDtDtStageClose") != null;
    GlobalData.setAppMode(PageModeConstants.VIEW, request);
    PageMode.setPageMode(PageModeConstants.VIEW, request);
    Boolean caseAccessAttr = null;

    // If a stage id is given, determine whether or not the user has access to
    // the stage.
    if (ulIdStage != 0) {
      if (CaseUtility.hasStageAccess(user.getUserID(), ulIdStage)) {
        // Only set AppMode/PageMode to MODIFY if the stage is not closed.
        CaseUtility.Stage thisStage = CaseUtility.getStage(ulIdStage);
        if (!StringHelper.isTrue(thisStage.getIndStageClose())) {
          GlobalData.setAppMode(PageModeConstants.MODIFY, request);
          PageMode.setPageMode(PageModeConstants.MODIFY, request);
        }
        bHasAccess = Boolean.TRUE;
        caseAccessAttr = Boolean.TRUE;
      }

      // If the stage is closed, the user should be able to reopen the stage
      // if they have access to any open or closed stage in the case.
      if (ulIdCase != 0 && closed) {
        if (CaseUtility.hasStageAccessToAnyClosedStage(user.getUserID(), ulIdCase) ||
            CaseUtility.hasStageAccessToAnyOpenStage(user.getUserID(), ulIdCase)) {
          caseAccessAttr = Boolean.TRUE;
        }
      }
    } else if (ulIdCase != 0 && !closed) {
      // Determine whether or not the user has access to any of the open stages.
      // If the user has access to the stage, the task tabs will be modifiable
      // (appMode = MODIFY).
      // If the page is loading for the first time from case search, there
      // will be no stage selected, so the code is just checking for if the
      // user has access to any open stage in the summary.  This will
      // allow for the case file print button to display even if there
      // is no stage selected.
      if (CaseUtility.hasStageAccessToAnyOpenStage(user.getUserID(), ulIdCase)) {
        bHasAccess = Boolean.TRUE;
        GlobalData.setAppMode(PageModeConstants.MODIFY, request);
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
        caseAccessAttr = Boolean.TRUE;
      }
    } else if (ulIdCase != 0 && closed) {
      // For Reopen Stage, determine whether or not the user has access to any of
      // the open or closed stages in the case. The appMode will always be VIEW
      // since the stage is closed.
      if (CaseUtility.hasStageAccessToAnyClosedStage(user.getUserID(), ulIdCase) ||
          CaseUtility.hasStageAccessToAnyOpenStage(user.getUserID(), ulIdCase)) {
        bHasAccess = Boolean.TRUE;
        GlobalData.setAppMode(PageModeConstants.VIEW, request);
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        caseAccessAttr = Boolean.TRUE;
      }
    } else {
      throw new IllegalStateException("There is no case Id and no stageId for this case");
    }
    state.setAttribute("hdnHasAccess", bHasAccess, request);
    request.setAttribute("hasCaseAccess", caseAccessAttr);
    GlobalData.setStageAccess(bHasAccess, request);
    performanceTrace.exitScope();
  }

  /**
   * This method determines if the user can modify Special Handling. If the user is the primary worker on the case or
   * above the worker in the unit heirarchy, or posseses the SEC_SENSITIVE_CASE_ACCESS security attribute, the
   * expandable section will be in modify mode
   *
   * @param context
   */
  protected void setSpecialHandlingPageSet(UserProfile user, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". setSpecialHandlingPageSet()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    boolean access = ((Boolean) state.getAttribute("hdnHasAccess", request));

    if ((!access && !user.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS)) ||
        user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
      request.setAttribute(PAGE_E, Boolean.TRUE);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method determines if the user can modify Case Merge Split. The user must have the SEC_MERGE_CASE security
   * attribute to modify Case Merge/Split.
   *
   * @param context
   */
  protected void setCaseMergePageSet(UserProfile user, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". setCaseMergePageSet()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //SIR# 23645: employees who do not have SEC_MERGE_CASE security attribute will be able to
    // merge/split cases in their workload. The following if statement has been changed to
    // allow such merge/split.
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean bAccess = ((Boolean) state.getAttribute("hdnHasAccess", request));
    if (user.hasRight(UserProfile.SEC_MERGE_CASES) || bAccess) {
      request.setAttribute(PAGE_F, Boolean.TRUE);
    } else {
      request.setAttribute(PAGE_F, null);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method determines if the user can modify Case File Management. If the user is the primary worker on the case
   * or above the worker in the unit heirarchy, or posseses the SEC_CASE_FILE_PRINT security attribute, the expandable
   * section will be in modify mode.
   *
   * @param context
   */
  protected void setCaseFileMgmtPageSet(UserProfile user, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". setCaseFileMgmtPageSet()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    boolean access = ((Boolean) state.getAttribute("hdnHasAccess", request));
    if (!access) {
      request.setAttribute(PAGE_G, Boolean.TRUE);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method determines if the user can modify Records Retention. If the user is the primary worker on the case or
   * above the worker in the unit heirarchy, the expandable
   * section will be in modify mode
   *
   * @param context
   */
  protected void setRecordsRetentionPageSet(UserProfile user, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". setRecordsRetentionPageSet()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    boolean access = ((Boolean) state.getAttribute("hdnHasAccess", request));
    if ((!access) ||
        user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
      request.setAttribute(PAGE_H, Boolean.TRUE);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method inlcudes the logic for voiding a casee merge or split from the list box.
   *
   * @param context
   */
  public void voidPending_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". voidPending_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      //Declare the actual row object.
      ROWCCFC39SOG00 caseMergeSplitRow = (ROWCCFC39SOG00) state.getAttribute("currentRow", request);

      if (caseMergeSplitRow != null) {
        if (caseMergeSplitRow.getCIndCaseMergePending().equals(ACTION_CODE_MERGE)) {
          request.setAttribute("hdnDataAction", ACTION_CODE_VOID_MERGE);
        } else if (caseMergeSplitRow.getCIndCaseMergePending().equals(ACTION_CODE_SPLIT)) {
          request.setAttribute("hdnDataAction", ACTION_CODE_VOID_SPLIT);
        }
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "voidPending_xa:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user validates a From ID for a merge.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void validateCaseMerge_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". validateCaseMerge_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      String txtUlIdCaseMergeFrom = ContextHelper.getStringSafe(request, "txtUlIdCaseMergeFrom");
      String txtUlIdCaseMergeTo = ContextHelper.getStringSafe(request, "txtUlIdCaseMergeTo");
      // Populates CCFC40SI for Validating the requested merge Page
      CCFC40SI ccfc40si = populateCCFC40SI_CaseMergeVal(context);
      //Call the Merge/Split validate Service
      CCFC40SO ccfc40so = admin.findCaseMergeVerify(ccfc40si);
      state.removeAttribute(MERGE_BY_INTAKE_DATE, request);
      int count = ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00Count();
      int countK = 0;
      int[] errorArray = new int[count];
      boolean hasActualErrors = false;
      // sir#14411. added bShowErrorList
      boolean bShowErrorList = true;
      request.setAttribute("CCFC40SO", ccfc40so);
      if (count > 0) {
        for (int j = 0; j < count; j++) {
          ROWCCFC40SOG00 row = ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(j);
          int errorCode = row.getSzCdUerrorMsgNbr();
          // SIR# 14411. MSG_MERGE_BY_INTAKE_DATE is not an error.
          hasActualErrors = hasActualErrors ||
                            (errorCode != Messages.MSG_CFC_MERGE_PEND &&
                             errorCode != Messages.MSG_CFC_POST_ADOPT_STG &&
                             errorCode != Messages.MSG_MERGE_BY_INTAKE_DATE);

          if (errorCode == Messages.MSG_MERGE_BY_INTAKE_DATE) {
            state.setAttribute(MERGE_BY_INTAKE_DATE, SWITCH_CASES, request);
            // we don't need to show error list if the only error is
            // MSG_MERGE_BY_INTAKE_DATE because this is neither an error nor warning
            if (count == 1) {
              bShowErrorList = false;
            }
          }
          //SIR#23007. Circular Case Merge is not allowed
          hasActualErrors = hasActualErrors || (errorCode == Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED);
          // SIR# 14411. MSG_MERGE_BY_INTAKE_DATE is not an error.
          if (errorCode != Messages.MSG_MERGE_BY_INTAKE_DATE) {
            errorArray[countK++] = errorCode;
          }
        }

        //SIR 22493 if the error list does not have actual errors (only has warnings), then
        // set hdnBIndValidate to success so that the merge can finish without problems.
        if (!hasActualErrors) {
          request.setAttribute("hdnBIndValidate", VALIDATE_SUCCESS);
        }
        //  Put the errorArray into the ErrorList
        // SIR# 14411. we don't need to show error list if the only error is
        // MSG_MERGE_BY_INTAKE_DATE because this is neither an error nor warning
        if (bShowErrorList) {
          ErrorList.setErrors(errorArray, request);
        }
        request.setAttribute("txtSzScrNmCaseMrgFrom", ccfc40so.getSzScrNmCaseMrgFrom());
      } else {
        request.setAttribute("hdnBIndValidate", VALIDATE_SUCCESS);
        request.setAttribute("txtSzScrNmCaseMrgFrom", ccfc40so.getSzScrNmCaseMrgFrom());
        request.setAttribute("txtUlIdCaseMergeFrom", txtUlIdCaseMergeFrom);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        // for any of the following messages, look up the string value and display it
        case Messages.MSG_CFC_CASE_INVALID:
        case Messages.MSG_CFC_FROM_ID_INV:              // CCFC23W.win : 1478
        case Messages.MSG_CFC_NO_MERGE_ACCESS:          // CCFC23W.win : 1519
        case Messages.MSG_MERGE_OPN_CLD_NOT_ALLOWED:              // STGAP00003248
          request.removeAttribute("CCFC40SO");
          addErrorMessage(MessageLookup.getMessageByNumber(errorCode),
                          request);
          break;
          //SIR 18916-- The Validate message will handle the MSG_NO_ROWS_RETURNED message.
        case Messages.MSG_NO_ROWS_RETURNED:
          setErrorMessage(errorCode,
                          "/workload/CaseSummary/displayCaseMergeSplitDetail",
                          request);
          break;

          // if the error isn't one of the above, we don't know what to do!
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "validateCaseMerge_xa:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user save the merge or split.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveCaseMergeSplitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ". saveCaseMergeSplitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    //SIR 23726 - Allow merge/split to be saved only if both cases do not have stages checked out to MPS.  If a stage
    //   is checked out to MPS, show an error message.
    String hdnDataAction = (String) request.getAttribute("hdnDataAction");
    if ((hdnDataAction == null) || (hdnDataAction.equals(EMPTY_STRING))) {
      hdnDataAction = ContextHelper.getStringSafe(request, "hdnDataAction");
    }

    if (detCheckoutStatus(ContextHelper.getStringSafe(request, "txtUlIdCaseMergeTo"),
                          ContextHelper.getStringSafe(request, "txtUlIdCaseMergeFrom")) && !(
            hdnDataAction.equals(ACTION_CODE_VOID_MERGE) || hdnDataAction.equals(ACTION_CODE_VOID_SPLIT))) {
      setErrorMessage(Messages.MSG_MPS_CASE_MERGE_VAL, request);
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
    } else {
      try {
        //Call the populate input helper method for CaseMergeSplit save (must be a closed case)
        CCFC41SI ccfc41si = populateCCFC41SI_CaseMergeSplitAUD(context);
        admin.saveCaseMerge(ccfc41si);
      } catch (ServiceException we) {
        int errorCode = we.getErrorCode();
        GrndsTrace.msg(TRACE_TAG, 7, "Caught an exception in SaveCaseMergeSplitDetail_xa:" + errorCode + ".");
        switch (errorCode) {
          case Messages.MSG_CFC_CONNECT_BY_LOOP: // CCFC23W.win : 4215
          case Messages.MSG_DUPLICATE_RECORD: // CCFC23W.win : 4216
          case Messages.MSG_CMN_TMSTAMP_MISMATCH: // CCFC23W.win : 4217
            setErrorMessage(errorCode, "/workload/CaseSummary/displayCaseMergeSplitDetail", request);
            break;

            // if the error isn't one of the above, we don't know what to do!
          default:
            GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
            processSevereException(context, we);
            break;
        }
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "saveCaseMergeSplitDetail_xa:" + e.getMessage());
        processSevereException(context, e);
      }
    }
    performanceTrace.exitScope();
  }
  
  /**
   * STGAP00014341: This method calls the Stage Reopen Page
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void reopenStage_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".  reopenStage_xa()");
    performanceTrace.enterScope();
    
    BaseSessionStateManager state = getSessionStateManager(context);

    HttpServletRequest request = context.getRequest();
    setStageInGlobalData(request);
    GlobalData.setUlIdEvent(0, request);
    
    // Get the output object from the request for Case Summary
    CCMN37SO ccmn37so = (CCMN37SO) state.getAttribute("CCMN37SO", request);
    //Get Case Summary Array of stages
    ROWCCMN37SOG02_ARRAY caseSummaryArray;
    if (ccmn37so.getROWCCMN37SOG02_ARRAY() != null) {
      caseSummaryArray = ccmn37so.getROWCCMN37SOG02_ARRAY();
    } else {
      caseSummaryArray = new ROWCCMN37SOG02_ARRAY();
    }

    ROWCCMN37SOG02[] rowccmn37sog02array = caseSummaryArray.getROWCCMN37SOG02();
   
    
    //STGAP00014341:If Stage is already open it cannot be reopened
    //STGAP00015330: Changed message from MSG_STG_CANNOT_REOPEN to MSG_OPEN_STG_CANNOT_REOPEN and moved the code block before 
    // all other code blocks that displayed MSG_STG_CANNOT_REOPEN messages.
    for (int i = 0; i < rowccmn37sog02array.length; i++) {
      if (rowccmn37sog02array[i].getSzCdStage() != null &&
                      rowccmn37sog02array[i].getSzCdStage().equals(GlobalData.getSzCdStage(request)) &&
                      rowccmn37sog02array[i].getUlIdStage() == GlobalData.getUlIdStage(request)
                      && rowccmn37sog02array[i].getDtDtStageClose() == null) {
        if(ArchitectureConstants.N.equals(rowccmn37sog02array[i].getBIndStageReopenSUB())){
          setErrorMessage(Messages.MSG_OPEN_STG_CANNOT_REOPEN,request);
          setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          return;
        }
      }
    }
    
    // STGAP00014341: A closed Adoption stage can be reopened only if the child has not been adopted
    if ((CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)))) {
      for (int i = 0; i < rowccmn37sog02array.length; i++) {
        if (rowccmn37sog02array[i].getSzCdStage() != null && 
                        rowccmn37sog02array[i].getSzCdStage().equals(GlobalData.getSzCdStage(request)) &&
                        rowccmn37sog02array[i].getUlIdStage() == GlobalData.getUlIdStage(request)) {
          if(ArchitectureConstants.N.equals(rowccmn37sog02array[i].getBIndStageReopenADO())){
            setErrorMessage(Messages.MSG_STG_CANNOT_REOPEN,request);
            setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
            return;
          }
        }
      }
    }

    // STGAP00014341: A closed Foster Care Child stage can be reopened only if the child has not been adopted
    if ((CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)))) {
      for (int i = 0; i < rowccmn37sog02array.length; i++) {
        if (rowccmn37sog02array[i].getSzCdStage() != null &&
                        rowccmn37sog02array[i].getSzCdStage().equals(GlobalData.getSzCdStage(request)) &&
                        rowccmn37sog02array[i].getUlIdStage() == GlobalData.getUlIdStage(request)) {
          if(ArchitectureConstants.N.equals(rowccmn37sog02array[i].getBIndStageReopenSUB())){
            setErrorMessage(Messages.MSG_STG_CANNOT_REOPEN,request);
            setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
            return;
          }
        }
      }
    }

    // STGAP00014341: A closed Foster Care Child stage can be reopened only if the child has not been adopted
    if ((CodesTables.CSTAGES_DIV.equals(GlobalData.getSzCdStage(request)))) {
      for (int i = 0; i < rowccmn37sog02array.length; i++) {
        if (rowccmn37sog02array[i].getSzCdStage() != null &&
                        rowccmn37sog02array[i].getSzCdStage().equals(GlobalData.getSzCdStage(request)) &&
                        rowccmn37sog02array[i].getUlIdStage() == GlobalData.getUlIdStage(request)) {
          if(ArchitectureConstants.N.equals(rowccmn37sog02array[i].getBIndStageReopenDIV())){
            setErrorMessage(Messages.MSG_STG_CANNOT_REOPEN,request);
            setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
            return;
          }
        }
      }
    }
    
    // STGAP00014341:These stages cannot be reopened
    if (CodesTables.CSTAGES_INT.equals(GlobalData.getSzCdStage(request)) || CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request)) || CodesTables.CSTAGES_FAD.equals(GlobalData.getSzCdStage(request))
                    || CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request))) {
      for (int i = 0; i < rowccmn37sog02array.length; i++) {
        if (rowccmn37sog02array[i].getSzCdStage() != null &&
                        rowccmn37sog02array[i].getSzCdStage().equals(GlobalData.getSzCdStage(request)) &&
                        rowccmn37sog02array[i].getUlIdStage() == GlobalData.getUlIdStage(request)) {
          if(ArchitectureConstants.N.equals(rowccmn37sog02array[i].getBIndStageReopenSUB())){
            setErrorMessage(Messages.MSG_STG_CANNOT_REOPEN,request);
            setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
            return;
          }
        }
      }
    }


    performanceTrace.exitScope();
  }
  

  /**
   * This helper mehtod populates the retrieve service for the Case Summary detail and list box.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCMN37SI populateCCMN37SI_CaseSummaryRetrieve(GrndsExchangeContext context,
                                                        TuxedoPaginationValueBean tuxPagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN37SI_CaseSummaryRetrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CCMN37SI ccmn37si = new CCMN37SI();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd("S");
    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    // SIR 22410 Set page number for actual pagination
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(SEARCH_RESULTS_PER_PAGE);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccmn37si.setArchInputStruct(input);
    ccmn37si.setUlIdCase(GlobalData.getUlIdCase(request));
    //SIR#23617. added a new field and its value to ccmn37s input header file.
    String sCdStageProg = GlobalData.getSzCdStageProgram(request);
    ccmn37si.setSzCdStageProgram(sCdStageProg);
    String indSealed = getSealedAttribute(request);
    ccmn37si.setCScrIndSealed(indSealed);
    //STGAP00010749: If the case is a PAD case than set the PAd case indicator, Pad case Id,
    //and Ado case Id in the retrieve object
    if(GlobalData.isPadCase(request)){
      ccmn37si.setBIndPadCase(ArchitectureConstants.Y);
      ccmn37si.setUlIdAdoCase(GlobalData.getUlIdAdoCase(request));
      ccmn37si.setUlIdPadCase(GlobalData.getUlIdPadCase(request));
    }
    performanceTrace.exitScope();
    return ccmn37si;
  }

  /**
   * This helper mehtod populates the service for Reopen Stage.
   *
   * @param context The GrndsExchangeContext object.
   */
  @SuppressWarnings({"UnusedDeclaration"})
  private CCMN49SI populateCCMN49SI_ReopenStage(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN49SI_ReopenStage()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CCMN49SI ccmn49si = new CCMN49SI();

    // RIOSJA, 10/21/2003 - Commented out these lines to match the service
    // input message in CAPS.
    //input.setCReqFuncCd( "U" );
    //input.setBPerfInd( INDICATOR_YES );
    //input.setBDataAcsInd( INDICATOR_YES );

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccmn49si.setArchInputStruct(input);
    ccmn49si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccmn49si.setUlIdStage(ContextHelper.getIntSafe(request, "hdnUlIdStage"));
    ccmn49si.setUlIdPerson(user.getUserID());
    ccmn49si.setSzCdStage(ContextHelper.getStringSafe(request, "hdnSzCdStage"));
    ccmn49si.setUlIdPersonAssigned(0);

    performanceTrace.exitScope();
    return ccmn49si;
  }

  /**
   * This helper mehtod populates the save service for the Special Handling expandable section.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCMN81SI populateCCMN81SI_SpecialHandlingRetrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN81SI_SpecialHandlingRetrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CCMN81SI ccmn81si = new CCMN81SI();
    CCMN81SG01 ccmn81sg01 = new CCMN81SG01();

    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(LIST_RESULTS_MAX);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccmn81si.setArchInputStruct(input);
    ccmn81sg01.setUlIdCase(GlobalData.getUlIdCase(request));
    ccmn81si.setCCMN81SG01(ccmn81sg01);

    performanceTrace.exitScope();
    return ccmn81si;
  }

  /**
   * This helper mehtod populates the save service for the Special Handling submodule.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCMN82SI populateCCMN82SI_SpecialHandlingAUD(GrndsExchangeContext context, String reqCode) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN82SI_SpecialHandlingAUD()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Create Instance (CCMN81SO retreive service)
    CCMN81SO ccmn81so = (CCMN81SO) state.getAttribute("CCMN81SO", request);
    if (ccmn81so == null) {
      ccmn81so = new CCMN81SO();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD outputSpecHD = ccmn81so.getSpecHD();
    ArchInputStruct input = new ArchInputStruct();
    CCMN82SI ccmn82si = new CCMN82SI();
    gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD inputSpecHD =
            new gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD();

    input.setCReqFuncCd(reqCode);
    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(LIST_RESULTS_MAX);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    //Setting the widgets on the page, that actually change value, into the request
    inputSpecHD.setSzCdCaseSpeclHndlg(ContextHelper.getStringSafe(request, "selSzCdCaseSpeclHndlg"));
    inputSpecHD.setBIndCaseSensitive(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSensitive"));
    inputSpecHD.setBIndCaseWorkerSafety(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseWorkerSafety"));
    inputSpecHD.setSzTxtCaseWorkerSafety(ContextHelper.getStringSafe(request, "txtSzTxtCaseWorkerSafety"));
    inputSpecHD.setSzTxtCaseSensitiveCmnts(ContextHelper.getStringSafe(request, "txtSzTxtCaseSensitiveCmnts"));

    inputSpecHD.setTsSysTsLastUpdate2(outputSpecHD.getTsSysTsLastUpdate2());
    inputSpecHD.setUlIdCase(GlobalData.getUlIdCase(request));
    ccmn82si.setArchInputStruct(input);
    ccmn82si.setSpecHD(inputSpecHD);

    performanceTrace.exitScope();
    return ccmn82si;
  }

  /**
   * This helper mehtod populates the validate service for Case Merge .
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC40SI populateCCFC40SI_CaseMergeVal(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC40SI_CaseMergeVal()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Create Instance (CCFC39SO retreive service)
    CCFC39SO ccfc39so = (CCFC39SO) state.getAttribute("CCFC39SO", request);

    if (ccfc39so == null) {
      ccfc39so = new CCFC39SO();
    }

    ArchInputStruct input = new ArchInputStruct();
    CCFC40SI ccfc40si = new CCFC40SI();

    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    //Sir19133 changed PageSizeNbr from 50 to 20
    //input.setUlPageSizeNbr( LIST_RESULTS_MAX );
    input.setUlPageSizeNbr(PageSizeNbr.CCFC40SO_ROWCCFC40SOG00_SIZE);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccfc40si.setUlIdPerson(user.getUserID());
    ccfc40si.setCSysIndMergePend(INDICATOR_NO);
    ccfc40si.setCSysIndPostAdopt(INDICATOR_NO);
    ccfc40si.setCScrIndToCaseCld(ccfc39so.getCScrIndToCaseCld());
    ccfc40si.setUlIdCaseMergeTo(ContextHelper.getIntSafe(request, "txtUlIdCaseMergeTo"));
    ccfc40si.setUlIdCaseMergeFrom(ContextHelper.getIntSafe(request, "txtUlIdCaseMergeFrom"));
    ccfc40si.setSzCdCaseProgram(ccfc39so.getSzCdCaseProgram());

    if (user.hasRight(UserProfile.SEC_MERGE_CASES)) {
      ccfc40si.setCSysIndMergeAccess(INDICATOR_YES);
    } else if (ccfc39so.getCScrIndToCaseCld().equals(INDICATOR_YES) &&
               (ccfc39so.getSzCdCaseProgram().equals(user.getUserProgram())
                ||
                (ccfc39so.getSzCdCaseProgram().equals(CASE_PROGRAM_AFC)
                 && ccfc39so.getSzCdCaseProgram().equals(CASE_PROGRAM_APS))
                || ((ccfc39so.getSzCdCaseProgram().equals(CASE_PROGRAM_CCL) ||
                     ccfc39so.getSzCdCaseProgram().equals(CASE_PROGRAM_RCL))
                    &&
                    ccfc39so.getSzCdCaseProgram().equals(CASE_PROGRAM_LIC)))) {
      ccfc40si.setCSysIndMergeAccess(INDICATOR_NO);
    }

    ccfc40si.setArchInputStruct(input);

    performanceTrace.exitScope();
    return ccfc40si;
  }

  /**
   * This helper mehtod populates the retrieve service for the Case Merge/Split detail expandable section list box.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC39SI populateCCFC39SI_CaseMergeSplitRetrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC39SI_CaseMergeSplitRetrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CCFC39SI ccfc39si = new CCFC39SI();

    input.setCReqFuncCd(ACTION_CODE_SPLIT);
    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(200);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccfc39si.setArchInputStruct(input);
    ccfc39si.setUlIdPerson(user.getUserID());
    ccfc39si.setUlIdCase(GlobalData.getUlIdCase(request));
    if (user.hasRight(UserProfile.SEC_MERGE_CASES)) {
      ccfc39si.setCSysIndMergeAccess(INDICATOR_YES);
    } else {
      ccfc39si.setCSysIndMergeAccess(INDICATOR_NO);
    }

    performanceTrace.exitScope();
    return ccfc39si;
  }

  /**
   * This helper mehtod populates the retrieve service for the Case Management expandable section.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC21SI populateCCFC21SI_CaseMgmntRetrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC21SI_CaseMgmntRetrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CCFC21SI ccfc21si = new CCFC21SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(LIST_RESULTS_MAX);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccfc21si.setArchInputStruct(input);
    ccfc21si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccfc21si.setUlIdPerson(user.getUserID());

    performanceTrace.exitScope();
    return ccfc21si;
  }

  /**
   * This helper mehtod populates the retrieve service for the Records Retention expandable section.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC19SI populateCCFC19SI_RecordsRetentionRetrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             ".populateCCFC19SI_RecordsRetentionRetrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CCFC19SI ccfc19si = new CCFC19SI();

    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(LIST_RESULTS_MAX);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccfc19si.setArchInputStruct(input);
    ccfc19si.setUlIdCase(GlobalData.getUlIdCase(request));

    performanceTrace.exitScope();
    return ccfc19si;
  }

  /**
   * This helper mehtod populates the save service for the Records Retention expandable section.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC20SI populateCCFC20SI_RecordsRetentionUpdate(GrndsExchangeContext context, String reqCode) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC20SI_RecordsRetentionUpdate()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Create Instance (CCFC19SO retreive service)
    CCFC19SO ccfc19so = (CCFC19SO) state.getAttribute("CCFC19SO", request);
    if (ccfc19so == null) {
      ccfc19so = new CCFC19SO();
    }

    ArchInputStruct archarchInputStruct = new ArchInputStruct();
    CCFC20SI ccfc20si = new CCFC20SI();
    archarchInputStruct.setCReqFuncCd(reqCode);
    archarchInputStruct.setBPerfInd(INDICATOR_YES);
    archarchInputStruct.setBDataAcsInd(INDICATOR_YES);
    archarchInputStruct.setUsPageNbr(1);
    archarchInputStruct.setUlPageSizeNbr(LIST_RESULTS_MAX);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    archarchInputStruct.setSzUserId(user.getUserLogonID());

    //Setting the widgets on the page, that actually change value, into the request
    ccfc20si.setDtDtRecRtnDstryActual(ContextHelper.getCastorDateSafe(request, "txtDtDtRecRtnDstryActual"));
    ccfc20si.setSzTxtRecRtnDstryDtRsn(ContextHelper.getStringSafe(request, "txtSzTxtRecRtnDstryDtRsn"));

    ccfc20si.setArchInputStruct(archarchInputStruct);
    ccfc20si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccfc20si.setSzCdRecRtnRetenType(ccfc19so.getSzCdRecRtnRetenType());
    ccfc20si.setDtDtRecRtnDstryElig(ccfc19so.getDtDtRecRtnDstryElig());
    ccfc20si.setTsLastUpdate(ccfc19so.getTsLastUpdate());

    performanceTrace.exitScope();
    return ccfc20si;
  }

  /**
   * This helper mehtod populates the save service for the Case Management expandable section.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC22SI populateCCFC22SI_CaseMgmntUpdate(GrndsExchangeContext context, String reqCode) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC22SI_CaseMgmntUpdate()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Create Instance (CCFC21SO retreive service)
    CCFC21SO ccfc21so = (CCFC21SO) state.getAttribute("CCFC21SO", request);
    if (ccfc21so == null) {
      ccfc21so = new CCFC21SO();
    }

    ArchInputStruct input = new ArchInputStruct();
    CCFC22SI ccfc22si = new CCFC22SI();

    input.setCReqFuncCd(reqCode);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    //Setting the widgets on the page, that actually change value, into the request
    String rbPrs = ContextHelper.getStringSafe(request, "rbPrs");
    if (EMPTY_STRING.equals(rbPrs)) {
      rbPrs = INDICATOR_NO;
    }
    ccfc22si.setSzCdCaseFileOfficeType(rbPrs);
    org.exolab.castor.types.Date closeDate = DateHelper.toCastorDateSafe("txtDtDtCaseClosed");
    if (closeDate != null) {
      ccfc22si.setDtDtCaseClosed(closeDate);
    }
    ccfc22si.setSzCdCaseProgram(ContextHelper.getStringSafe(request, "txtSzCdCaseProgram"));
    ccfc22si.setSzCdOfficeRegion(ContextHelper.getStringSafe(request, "selSzCdOfficeRegion"));
    ccfc22si.setSzNbrUnit(ContextHelper.getStringSafe(request, "txtSzNbrUnit"));
    ccfc22si.setSzAddrMailCode(ContextHelper.getStringSafe(request, "txtSzAddrMailCode"));
    ccfc22si.setSzNmCaseFileOffice(ContextHelper.getStringSafe(request, "txtSzNmCaseFileOffice"));
    ccfc22si.setSzAddrCaseFileCity(ContextHelper.getStringSafe(request, "txtSzAddrCaseFileCity"));
    ccfc22si.setSzAddrCaseFileStLn1(ContextHelper.getStringSafe(request, "txtSzAddrCaseFileStLn1"));
    ccfc22si.setSzAddrCaseFileStLn2(ContextHelper.getStringSafe(request, "txtSzAddrCaseFileStLn2"));
    ccfc22si.setDtDtCaseFileArchElig(ContextHelper.getCastorDateSafe(request, "txtDtDtCaseFileArchElig"));
    ccfc22si.setDtDtCaseFileArchCompl(ContextHelper.getCastorDateSafe(request, "txtDtDtCaseFileArchCompl"));
    ccfc22si.setSztxtCaseFileLocateInfo(ContextHelper.getStringSafe(request, "txtSztxtCaseFileLocateInfo"));
    ccfc22si.setSzTxtPriorCmnts(ContextHelper.getStringSafe(request, "szTxtPriorCmnts"));
    ccfc22si.setSzCdCounty(ContextHelper.getStringSafe(request, "selSzCdCounty"));

    ccfc22si.setArchInputStruct(input);
    ccfc22si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccfc22si.setTsLastUpdate(ccfc21so.getTsLastUpdate());

    performanceTrace.exitScope();
    return ccfc22si;
  }

  /**
   * This helper mehtod populates the save service for the Case Merge/Split Detail page.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CCFC41SI populateCCFC41SI_CaseMergeSplitAUD(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC41SI_CaseMergeSplitAUD()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Create Instance (CCFC39SO retreive service)
    CCFC39SO ccfc39so = (CCFC39SO) state.getAttribute("CCFC39SO", request);
    ROWCCFC39SOG00 rowccfc39sog00 = (ROWCCFC39SOG00) state.getAttribute("currentRow", request);
    if (ccfc39so == null) {
      ccfc39so = new CCFC39SO();
    }
    if (rowccfc39sog00 == null) {
      rowccfc39sog00 = new ROWCCFC39SOG00();
    }

    //Retrieve user information for saving to the database
    Date date = new Date();

    String cReqFuncCD = (String) request.getAttribute("hdnCReqFuncCd");
    String hdnDataAction = (String) request.getAttribute("hdnDataAction");
    if ((hdnDataAction == null) || (hdnDataAction.equals(EMPTY_STRING))) {
      hdnDataAction = ContextHelper.getStringSafe(request, "hdnDataAction");
    }

    CCFC41SI ccfc41si = new CCFC41SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCFC41SIG00 rowccfc41sig00 = new ROWCCFC41SIG00();
    ROWCCFC41SIG00_ARRAY rowccfc41sig00_array = new ROWCCFC41SIG00_ARRAY();

    input.setCReqFuncCd(cReqFuncCD);
    input.setBPerfInd(INDICATOR_YES);
    input.setBDataAcsInd(INDICATOR_YES);
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(LIST_RESULTS_MAX);

    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());

    ccfc41si.setArchInputStruct(input);
    ccfc41si.setUlIdPerson(user.getUserID());
    ccfc41si.setCScrIndToCaseCld(ccfc39so.getCScrIndToCaseCld());
    rowccfc41sig00.setTsLastUpdate(rowccfc39sog00.getTsLastUpdate());
    rowccfc41sig00.setSzCdScrDataAction(hdnDataAction);

    //The user clicked the Add pushbutton to merge a case
    if (hdnDataAction.equals(ACTION_CODE_MERGE)) {
      rowccfc41sig00.setUlIdCaseMerge(rowccfc39sog00.getUlIdCaseMerge());
      String sSwitch = (String) state.getAttribute(MERGE_BY_INTAKE_DATE, request);
      if (sSwitch != null && sSwitch.toString().compareTo(SWITCH_CASES) == 0) {
        rowccfc41sig00.setUlIdCaseMergeFrom(ContextHelper.getIntSafe(request, "txtUlIdCaseMergeTo"));
        rowccfc41sig00.setUlIdCaseMergeTo(ContextHelper.getIntSafe(request, "txtUlIdCaseMergeFrom"));
      } else {
        rowccfc41sig00.setUlIdCaseMergeFrom(ContextHelper.getIntSafe(request, "txtUlIdCaseMergeFrom"));
        rowccfc41sig00.setUlIdCaseMergeTo(ContextHelper.getIntSafe(request, "txtUlIdCaseMergeTo"));
      }
      rowccfc41sig00.setUlIdCaseMergePersMrg(user.getUserID());
      rowccfc41sig00.setUlIdCaseMergePersSplit(0);
      rowccfc41sig00.setDtDtCaseMerge(DateHelper.toCastorDate(date));
      rowccfc41sig00.setDtCaseMergeSplit(null);
      rowccfc41sig00.setCIndCaseMergeInv(INDICATOR_YES);
    }
    //The user clicks the hyperlink to split a case
    else if (hdnDataAction.equals(ACTION_CODE_SPLIT)) {
      rowccfc41sig00.setUlIdCaseMerge(0);
      rowccfc41sig00.setUlIdCaseMergeFrom(rowccfc39sog00.getUlIdCaseMergeFrom());
      rowccfc41sig00.setUlIdCaseMergePersMrg(rowccfc39sog00.getUlIdCaseMergePersMrg());
      rowccfc41sig00.setUlIdCaseMergePersSplit(user.getUserID());
      rowccfc41sig00.setUlIdCaseMergeTo(rowccfc39sog00.getUlIdCaseMergeTo());
      rowccfc41sig00.setDtDtCaseMerge(rowccfc39sog00.getDtDtCaseMerge());
      rowccfc41sig00.setDtCaseMergeSplit(DateHelper.toCastorDate(date));
      rowccfc41sig00.setCIndCaseMergeInv(INDICATOR_YES);
    }
    //The user void the pending merge or split
    else if (hdnDataAction.equals(ACTION_CODE_VOID_SPLIT)) {
      rowccfc41sig00.setUlIdCaseMerge(rowccfc39sog00.getUlIdCaseMerge());
      rowccfc41sig00.setUlIdCaseMergeFrom(rowccfc39sog00.getUlIdCaseMergeFrom());
      rowccfc41sig00.setUlIdCaseMergePersMrg(rowccfc39sog00.getUlIdCaseMergePersMrg());
      rowccfc41sig00.setUlIdCaseMergePersSplit(0);
      rowccfc41sig00.setUlIdCaseMergeTo(rowccfc39sog00.getUlIdCaseMergeTo());
      rowccfc41sig00.setDtDtCaseMerge(rowccfc39sog00.getDtDtCaseMerge());
      rowccfc41sig00.setDtCaseMergeSplit(rowccfc39sog00.getDtCaseMergeSplit());
      rowccfc41sig00.setCIndCaseMergeInv(INDICATOR_YES);
    } else if (hdnDataAction.equals(ACTION_CODE_VOID_MERGE)) {
      rowccfc41sig00.setUlIdCaseMerge(rowccfc39sog00.getUlIdCaseMerge());
      rowccfc41sig00.setUlIdCaseMergeFrom(rowccfc39sog00.getUlIdCaseMergeFrom());
      rowccfc41sig00.setUlIdCaseMergePersMrg(0);
      rowccfc41sig00.setUlIdCaseMergePersSplit(rowccfc39sog00.getUlIdCaseMergePersSplit());
      rowccfc41sig00.setUlIdCaseMergeTo(rowccfc39sog00.getUlIdCaseMergeTo());
      rowccfc41sig00.setDtDtCaseMerge(rowccfc39sog00.getDtDtCaseMerge());
      rowccfc41sig00.setCIndCaseMergeInv(INDICATOR_YES);
    }

    ccfc41si.setArchInputStruct(input);

    rowccfc41sig00_array.addROWCCFC41SIG00(rowccfc41sig00);

    ccfc41si.setROWCCFC41SIG00_ARRAY(rowccfc41sig00_array);

    performanceTrace.exitScope();
    return ccfc41si;
  }

  /**
   * Blank method just to show general pattern of a Activity Method, including naming standards, etc.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private CCFC42SI populateCCFC42SI_CreateAdminReview(GrndsExchangeContext context, String personName, int personID) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC42SI_CreateAdminReview()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    if (ContextHelper.getStringSafe(request, "hdnSzCdStage").equals(FAD_STAGE)) {
      setStageInGlobalData(request);
    }

    CCFC42SI ccfc42si = new CCFC42SI();
    UlIdPerson_ARRAY_CCFC42SI personArray = new UlIdPerson_ARRAY_CCFC42SI();

    personArray.addUlIdPerson(0, personID);
    personArray.addUlIdPerson(1, UserProfileHelper.getUserProfile(request).getUserID());
    ccfc42si.setUlIdPerson_ARRAY_CCFC42SI(personArray);
    ccfc42si.setSzNmPersonFull(personName);

    ccfc42si.setSzCdStage(GlobalData.getSzCdStage(request));
    ccfc42si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    ccfc42si.setSzNmCase(GlobalData.getSzNmCase(request));
    ccfc42si.setSzNmStage(GlobalData.getSzNmStage(request));
    ccfc42si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccfc42si.setUlIdStage(GlobalData.getUlIdStage(request));

    performanceTrace.exitScope();
    return ccfc42si;
  }

  public void locatingInformation(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "locatingInformation");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    CFMgmntValueBean returnBean;
    try {
      CFMgmntValueBean searchBean = new CFMgmntValueBean(GlobalData.getUlIdCase(request));
      returnBean = CFMgmntListEjb.getCFMgmntInfo(searchBean);
      if (returnBean != null) {
        List vTmp = returnBean.getLocatingInfo();
        state.setAttribute("LocatingInformation", vTmp, request);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
  }

  private void setStageInGlobalData(HttpServletRequest request) {
    GlobalData.setUlIdStage(ContextHelper.getIntSafe(request, "hdnUlIdStage"), request);
    GlobalData.setSzNmStage(ContextHelper.getStringSafe(request, "hdnSzNmStage"), request);
    GlobalData.setSzCdStage(ContextHelper.getStringSafe(request, "hdnSzCdStage"), request);
    GlobalData.setSzCdStageType(ContextHelper.getStringSafe(request, "hdnSzCdStageType"), request);
    GlobalData.setDtDtStageStart(ContextHelper.getCastorDateSafe(request, "hdnDtDtStageStart"), request);
    if (ContextHelper.getIntSafe(request, "hdnUlIdAdoCase") != 0) {
      GlobalData.setUlIdCase(ContextHelper.getIntSafe(request, "hdnUlIdAdoCase"), request);
    }
  }

  /**
   * method detCheckoutStatus
   *
   * @param toCase
   * @param fromCase
   * @return
   */
  private static boolean detCheckoutStatus(String toCase, String fromCase) {
    boolean checkedout = false;
    List<CaseUtility.Stage> allStages = new LinkedList<CaseUtility.Stage>();
    List<Integer> stageIDs = new LinkedList<Integer>();

    List<CaseUtility.Stage> toList = CaseUtility.getOpenStages(toCase);
    List<CaseUtility.Stage> fromList = CaseUtility.getOpenStages(fromCase);

    allStages.addAll(toList);
    allStages.addAll(fromList);

    CaseUtility.Stage stage;
    for (Iterator iterator = allStages.iterator(); iterator.hasNext();) {
      stage = (CaseUtility.Stage) iterator.next();
      stageIDs.add(stage.getIdStage());
    }

    if (!stageIDs.isEmpty()) {
      checkedout = CaseUtility.getCaseCheckoutStatus(stageIDs);
    }

    return checkedout;
  }
  
  private void checkSiblingGroupInformationAvailableTabDisplay(GrndsExchangeContext context) {
    //show SiblingGroupInformation if the stage is ADO or FCC
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    String stage = GlobalData.getSzCdStage(request);
    int stageId = GlobalData.getUlIdStage(request);
    if(CodesTables.CSTAGES_ADO.equalsIgnoreCase(stage) || CodesTables.CSTAGES_SUB.equalsIgnoreCase(stage)){
      state.setContextParameter("_siblingGroupInformationAvailable"+stageId, ArchitectureConstants.Y, request);
    } else {
      state.removeContextParameter("_siblingGroupInformationAvailable"+stageId, request);
    }
  }
  
  /**
   * This method is called by the other methods to get whether the user has Rights to access
   * ADO and FCC Stages after the Adoption is Finalized.
   * 
   * @param request
   *                HTTP Servlet Request object.
   * @return String
   *                Return either N or Y.
   */
  private String getSealedAttribute(HttpServletRequest request) {
    String retValue = ArchitectureConstants.N;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == true ? 
                                   ArchitectureConstants.Y : ArchitectureConstants.N ;
    }
    return retValue;
  }

  /**
   * Check the case viewable or not 
   */
  private boolean isCaseViewable(GrndsExchangeContext context, int ulIdCase) {
    HttpServletRequest request = context.getRequest();

    // Pagination
    int resultsPerPage = 10;
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(resultsPerPage);

    int pageRequested = tuxPagination.getResultDetails().getRequestedPage();

    int personID = 0;
    CCMN20SI ccmn20si;
    // Apply logic to determine which search parameters to use
    // If Case ID exists, use only that. If not, use Facility Name
    // (which is szNmCase). If that also doesn't exist, bring in
    // First, Middle, and Last names, concatenate as Last,First M
    // and send as szNmCase parameter.
    String szNmCase = "";
    String szNmCaseManager = "";
    int ulIdCaseManager = 0;
    if (ulIdCase != 0) {
      // Use only Case ID, clear Name, Case Manager Name, Case Manager ID
      szNmCase = StringHelper.EMPTY_STRING;
      szNmCaseManager = StringHelper.EMPTY_STRING;
      ulIdCaseManager = 0;
    }
    ccmn20si = populateSearchStruct(personID, pageRequested, tuxPagination, resultsPerPage, ulIdCase,
                                    szNmCase, ulIdCaseManager, szNmCaseManager, context);
    CCMN20SO ccmn20so = callSearchService(tuxPagination, context, ccmn20si);
    
    // Initialize the row and array objects
    ROWCCMN13DO_ARRAY addressArray = null;
    // Null catch for ccmn20so, if null set to blank (initialize)
    if ( ccmn20so == null )
    {
      ccmn20so = new CCMN20SO();
    }
    // Null catch for ROW objects, if not null get rows
    if ( ccmn20so.getROWCCMN13DO_ARRAY() != null )
    {
      addressArray = ccmn20so.getROWCCMN13DO_ARRAY();
    } else
    {
      addressArray = new ROWCCMN13DO_ARRAY();
    }
    ROWCCMN13DO addressRow = null;
    boolean viewable = true;
    UserProfile user = UserProfileHelper.getUserProfile( request );
    Enumeration<ROWCCMN13DO> addressEnumeration1 = addressArray.enumerateROWCCMN13DO();
    
    while( addressEnumeration1.hasMoreElements() )
    {
      addressRow = (ROWCCMN13DO) addressEnumeration1.nextElement();
      if (("Y".equalsIgnoreCase(addressRow.getBIndCaseSensitive()) 
                      && !user.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS))&&
         (!CaseUtility.hasStageAccessToAnyStage(user.getUserID(),ArchitectureConstants.Y, ulIdCase)))
      {
        viewable = false;
      }
      if ("FAD".equals(addressRow.getSzCdStage()) && !user.hasRight(UserProfile.SEC_MTN_HOME))
      {
        viewable = false;
      }
    }
    return viewable;
  }
  
  protected CCMN20SI populateSearchStruct(int personID, int usPageNbr, TuxedoPaginationValueBean tuxPagination,
                                          int ulPageSizeNbr, int ulIdCase, String szNmCase, int ulIdCaseManager,
                                          String szNmCaseManager, GrndsExchangeContext context) {
    CCMN20SI populatedCcmn20si = new CCMN20SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);
    input.setSzUserId(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());

    // The window code seems to create the UlIdPerson array regardless of whether
    // a personID has been specified as part of the search criteria. Create it
    // here, fill it with the personID (which is 0 if not entered by the user),
    // then add a second element for the user ID.
    UlIdPerson_ARRAY_CCMN20SI a = new UlIdPerson_ARRAY_CCMN20SI();
    a.addUlIdPerson(personID);
    a.addUlIdPerson(UserProfileHelper.getUserProfile(context.getRequest()).getUserID());
    populatedCcmn20si.setUlIdPerson_ARRAY_CCMN20SI(a);

    populatedCcmn20si.setArchInputStruct(input);
    populatedCcmn20si.setUlIdCase(ulIdCase);
    String orderBy = "1";
    //-- following line only necessary because the service calls Integer.parseInt using this value
    //-- particular number represented is irrelevant since dao uses its own default ordering
    String sortDir = SORT_ASCENDING;
    populatedCcmn20si.setBWcdCdSortBy(orderBy);
    populatedCcmn20si.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);
    return populatedCcmn20si;
  }
  
  protected CCMN20SO callSearchService(TuxedoPaginationValueBean tuxPagination, GrndsExchangeContext context,
                                   CCMN20SI ccmn20si) {
    HttpServletRequest request = context.getRequest();
    CCMN20SO ccmn20so = new CCMN20SO();
    try {
      ccmn20so = admin.findCaseListInformation(ccmn20si);
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn20so.getBMoreDataInd());
      ccmn20so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccmn20so.getArchOutputStruct(),
                                             ccmn20so.getROWCCMN13DO_ARRAY().getROWCCMN13DOCount());

    } catch (ServiceException se) {
      switch (se.getErrorCode()) {
        case(Messages.MSG_NO_ROWS_RETURNED): {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_ROWS_RETURNED);
          setInformationalMessage(errorMessage, "/workload/CaseSummary/displayCaseSummary", request);
          break;
        }
        // SIR 18300 this message will now be thrown by the service.
        case(Messages.MSG_TOO_MANY_ROWS_RETURNED): {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_TOO_MANY_ROWS_RETURNED);
          setInformationalMessage(errorMessage, "/workload/CaseSummary/displayCaseSummary", request);
          break;
        }

        default: {
          super.processSevereException(context, se);
        }
      }
    } catch (Exception e) {
      super.processSevereException(context, e);
    }
    // return the output object.
    return ccmn20so;
  }  
}

