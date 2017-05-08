
package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegEvidenceCode_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CdAllegDisposition_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfMaltreatmentInCareSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegEvidence_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * General: ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE AllgtnConversation.java--Mobile FOR NECESSARY
 * MOBILE CHANGES
 * <p/>
 * <p/>
 * This is the Conversation class used to maintain Allegations.  It contains methods to display Allegation List,
 * Allegation Detail, and Injury Detail.  As well as methods to add, update, and delete.
 * <p/>
 * <br> Services:<br> <ul>  <li>CINV09S - Save Allegation Detail Multi</li> <li>CINV10S - Save Facility Allegation
 * Detail Multi</li> <li>CINV44S - Display Allegation List</li> <li>CINV45S - Calculate Overall Disposition</li>
 * <li>CINV46S - Display Alegation Detail</li> <li>CINV47S - Add, Update, and Delete Allegation Detail</li> </ul>
 * <p/>
 * <p/>
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  05/10/03  KRD       SIR 17233 - Code changes applied to support
 *                      "Approver Mode" providing supervisors the ability to
 *                      modify data without invalidating the pending
 *                      approval.  Required changes to: populateCinv08s_audAllgtn(),
 *                      populateCinv47s_audAllgtn(), populateCinv09s_SaveMulti(),
 *                      populateCinv10s_SaveMulti(), populateCinv47s_Delete(),
 *                      and populateCinv08s_Delete().
 *  06/23/03 Todd Reser SIR 18451 - LIdTodo was incorrect causing saves to think
 *                      the stage was closed.
 *  07/08/03 JMC        SIR 19352 - Removed the autoSave of Fac Allgt Dtl upon
 *                      click of the Injury List hyperlink or Add button.
 *  07/16/03 dejuanr    SIR 18865 - I have completely rewriten how facility allegation
 *                      works.  It onlys saves on the save or save and stay buttons.
 *                      There may be code in here that is not used for anything.
 *                      Due to time contraints i may have not cleaned it up
 *                      completely.
 *  08/01/03 RIOSJA     SIR 18812 - UNDO SIR 17233. A PENDing Investigation
 *                      Conclusion must be invalidated even if the worker accesses
 *                      the page in "approval mode" because changing an allegation's
 *                      disposition could cause the Overall Dispostion to change,
 *                      in which case the Recommended Action will no longer apply.
 *                      Invalidating the pending closure will force the worker to
 *                      select a new Recommended Action.
 *  10/01/03 dejuanr    SIR 19887 - Fixed saving of neglect type.
 *  03/10/04 CORLEYAN   SIR 22595 -- Calculate Overall disposition should only be
 *                      called when all of the allegations have had a dispostion
 *                      saved to them.  This affects the delete and save for all
 *                      programs.
 *  03/26/04 RIOSJA     SIR 22679 - Worker cannot update multiple allegations
 *                      at a time for ARI stage. If they attempt to do so, and
 *                      stage is ARI, display an error message.
 * 06/30/05  floresrj   SIR 23729 Refactored class for Phase II implementation.
 * 08/29/05  anandv     Added MOBILE-IMPACT comments at the General section.
 * 09/08/05  floresrj   SIR 23956 Added logic for IMPACT to use the EJB for displaying the
 *                      Facility Allegaton Detail page in lieu of IMPACT Tuxedo Service.
 *  11/28/07 Imomio     Defect 5874 Passed the right value (size of the paginated data array) for paginated list
 *  09/15/09 bgehlot    STGAP00015366: Get the Maltreator relationship from hidden field when its hidden on the page,
 *                      Removed the message 'Requested person does not match AP' 
 * 09/17/09  hjbaptiste STGAP00015384: Added new message MSG_INV_NO_DEL_INT_ALLEG to catch block of deleteAllgtn_xa()
 *                      and deleteAllgtnList_xa()
 * 02/15/10  ssubram    CAPTA Requirements changes 3.1 - 3.10   
 * 05/26/10  hjbaptiste SMS#51977-MR66-Maltreatment In Care: Added additional field to indicate that Maltreatment took
 *                      place while the child was/is in DFCS custody and a method to check for Maltreatment in Care
 * 06/21/2011 arege     SMS#112534: Investigation Conclusion task should be invalidated on Add, Update, Copy or Delete of Allegation.
 * 01/20/2012 habraham  STGAP00017829 - MR-097 : Unsubstantiated MIC - The method signature for the checkIfMaltreatmentInCare 
 *                         						   to the Common bean has changed
 *                                                                 
 * <p/>
 * <p/>
 * <p/>
 * </pre>
 */
public class AllgtnConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "AllgtnConversation";

  public static final String CAPS_LIST = "L";
  public static final String CASE_RELATED_SPECIAL_REQUEST = "C-";

  public static final String CD_TASK_APS_ALLEGATION = "2020";
  public static final String CD_TASK_CPS_ALLEGATION = "2170";
  public static final String CD_TASK_AFC_ALLEGATION = "2380";
  public static final String CD_TASK_CCL_ALLEGATION = "2510";
  public static final String CD_TASK_RCL_ALLEGATION = "2720";

  public static final String DISPLAY_PAGE_ALLGTN_DTL = "/investigation/Allegation/displayAllgtnDetail";
  public static final String DISPLAY_PAGE_ALLGTN_LIST = "/investigation/Allegation/displayAllgtnList";

  public static final String ADD = "Add";
  public static final String UPDATE = "Update";
  public static final String MULTI = "Multi";
  private static final String WARN_STRING = "warn";

  public static final String MARRIED = "MA";

  public static final String YES = "Y";
  public static final String NO = "N";

  public static final String ERROR_BRANCH = "error";
  public static final String STAY_BRANCH = "stay";
  //STGAP00005874: Changed the size from 50 to 25
  public static final int ALLGTN_LIST_PAGE_SIZE = 25;

  public static final String EMPTY_STRING = "";

  public static final String SEARCH_SER = "S";
  public static final String ADD_SER = "A";
  public static final String UPDATE_SER = "U";
  public static final String DELETE_SER = "D";

  public static final String REASON_TO_BELIEVE = "RTB";

  public static final String INJURY_STATI = "injuryStati";

  public static final String EVENT_LIST = getUrl("displayEventList");
  public static final String CONVERSATION_URL = "/workload/EventSearch/";

  public static final int OVERALL_DISPOSITION_BLANKED = 10003;

  public static final int MAX_VICTIM_AGE = 18;
  public static final int MIN_AP_AGE = 10;
  public static final int MAX_INJURIES = 20;

  public static final int PAGE_SIZE = 250;

  public static final String HDN_OVERALL_DISP_FIELD_NAME = "hdnOverallDisp";

  public static final String MEDICAL_NEGLECT = "MDNG";
  public static final String NEGLECTFUL_SUPERVISOR = "NSUP";
  public static final String MENTAL_HEALTH_NEGLECT = "MHNG";
  public static final String PHYSICAL_NEGLECT = "PHNG";
  public static final String NEGLECT = "NEGL";

  private Intake intake;

  public void setIntake(Intake intake) {
    this.intake = intake;
  }


  /**
   * This method is called by the GRNDS controller when a user views the Allegation List.
   * <p/>
   * <br> Services Used:<br> <ul> <li>CINV44S - Display Allegation List</li> </ul>
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayAllgtnList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAllgtnList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    Integer relatedStage = (Integer) state.getAttribute("relatedStage", request);
    Integer personRequestor = (Integer) state.getAttribute("personRequestor", request);

    state.removeAllAttributes(request);

    state.setAttribute("relatedStage", relatedStage, request);
    state.setAttribute("personRequestor", personRequestor, request);

    // If Stage Type begin with "C-", it is a Case Related Special Request and
    // no allegation may be created or viewed on it.
    String stageType = GlobalData.getSzCdStageType(request);
    if (stageType.length() > 2) {
      if (CASE_RELATED_SPECIAL_REQUEST.equals(stageType.substring(0, 2))) {
        this.setPresentationBranch(ERROR_BRANCH, context);
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_INV_PREVENT_ALLEGATIONS),
                        DISPLAY_PAGE_ALLGTN_LIST, request);
        state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, PageModeConstants.VIEW, request);
        return;
      }
    }

    String winMode = (GlobalData.getAppMode(request) != null) ? GlobalData.getAppMode(request) :
                     PageModeConstants.INQUIRE;
    if (EVENT_LIST.equals(ContextHelper.getPreviousUrl(request))) {
      winMode = PageModeConstants.INQUIRE;
    }

    // Check to make sure PageMode is correct.
    String stage = GlobalData.getSzCdStage(request);
    String program = GlobalData.getSzCdStageProgram(request);
    if ((!winMode.equals(PageModeConstants.NEW)) &&
        (!winMode.equals(PageModeConstants.MODIFY)) &&
        (!winMode.equals(CAPS_LIST)) &&
        ((!winMode.equals(PageModeConstants.INQUIRE)) &&
         ((stage.equals(CodesTables.CSTAGES_INV)) && (program.equals(CodesTables.CPGRMSFM_AFC))))) {
      this.setPresentationBranch(ERROR_BRANCH, context);
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_INV_BAD_MODE_CD), DISPLAY_PAGE_ALLGTN_LIST,
                      request);
      return;
    }

    // Check to make sure program is correct
    if ((!program.equals(CodesTables.CPGRMS_APS)) &&
        (!program.equals(CodesTables.CPGRMS_CPS)) &&
        (!program.equals(CodesTables.CPGRMS_CCL)) &&
        (!program.equals(CodesTables.CPGRMS_RCL)) &&
        (!program.equals(CodesTables.CPGRMS_AFC))) {
      this.setPresentationBranch(ERROR_BRANCH, context);
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_INV_BAD_PROG_CD), DISPLAY_PAGE_ALLGTN_LIST,
                      request);
      return;
    }

    String pageMode;
    if ((winMode.equals(PageModeConstants.NEW)) ||
        (winMode.equals(PageModeConstants.MODIFY))) {
      pageMode = PageModeConstants.MODIFY;
    } else {
      pageMode = PageModeConstants.VIEW;
    }

    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, pageMode, request);

    callCinv44s_displayAllgtnList(context);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user clicks on an Allegation hyperlink, Detail button, New
   * Using button, or Add button.  It will display the Allgeation Detail page.
   * <p/>
   * <br> Services Used:<br> <ul> <li>CINV46S - Display Alegation Detail</li> </ul>
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayAllgtnDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAllgtnDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      String szIdAllgtn = ContextHelper.getStringSafe(request, "hdnUlIdAllgtn");
      String[] idAllgtns = CheckboxHelper.getCheckedValues(request, "cbxAllgtn_");
      boolean bDetail = ContextHelper.getString(request, "btnDetail.x") != null;
      boolean bNewUsing = ContextHelper.getString(request, "btnNewUsing.x") != null;
      boolean bAdd = ContextHelper.getString(request, "btnAdd.x") != null;
      boolean bLink = !(bDetail || bNewUsing || bAdd);
      

      // RIOSJA, SIR 22679 - Worker cannot update multiple allegations at a time
      // for ARI stage. If they attempt to do so, and stage is ARI, display an
      // error message.
      if (CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request)) &&
          idAllgtns.length > 1) {
        this.setPresentationBranch(ERROR_BRANCH, context);
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_ARI_ONE_ALLEG),
                        DISPLAY_PAGE_ALLGTN_DTL,
                        context.getRequest());
        return;
      }


      if (bAdd) {
        displayAllgtnDetail(context, "0");
      } else if (bLink) {
        displayAllgtnDetail(context, szIdAllgtn);
      } else if (bNewUsing) {
        if ((idAllgtns.length == 1) && (idAllgtns[0] != null)) {
          displayAllgtnDetail(context, idAllgtns[0]);
        } else {
          this.setPresentationBranch(ERROR_BRANCH, context);
          int errorCode = (idAllgtns.length == 0) ? Messages.MSG_SELECT_ONE_ALLEGATION : Messages.MSG_ONE_NEW_USING;
          setErrorMessage(MessageLookup.getMessageByNumber(errorCode), DISPLAY_PAGE_ALLGTN_LIST, request);
        }
      } else if (bDetail) {
        if ((idAllgtns.length == 1) && (idAllgtns[0] != null)) {
          displayAllgtnDetail(context, idAllgtns[0]);
        } else if (idAllgtns.length > 1) {
          displayAllgtnDetailMulti(context, idAllgtns);
        } else {
          this.setPresentationBranch(ERROR_BRANCH, context);
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ONE_ALLEGATION),
                          DISPLAY_PAGE_ALLGTN_LIST, request);
        }
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the displayAllgtnDetail_xa method to display a single Allegation.
   *
   * @param context    The GrndsExchangeContext object.
   * @param szIdAllgtn String object of Allegation ID for the Allegation you wish to display
   */
  private void displayAllgtnDetail(GrndsExchangeContext context, String szIdAllgtn) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAllgtnDetail()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    callCinv46s_displayAllgtn(context, szIdAllgtn);
    String idAllgtn;
    String idVictim;
    String idAP;
    String txtMode;
    boolean bNewUsing = ContextHelper.getString(request, "btnNewUsing.x") != null;
    boolean bAdd = ContextHelper.getString(request, "btnAdd.x") != null;
    if (bAdd) {
      idAllgtn = EMPTY_STRING;
      idVictim = (String) request.getAttribute("selUlIdVictim");
      idAP = EMPTY_STRING;
      txtMode = ADD;
    } else if (bNewUsing) {
      idAllgtn = EMPTY_STRING;
      idVictim = ContextHelper.getStringSafe(request, "hdnVic_" + szIdAllgtn);
      idAP = ContextHelper.getStringSafe(request, "hdnPerp_" + szIdAllgtn);
      txtMode = ADD;
      request.setAttribute("doNotHideRalationship", "true");
    } else {
      idAllgtn = szIdAllgtn;
      idVictim = ContextHelper.getStringSafe(request, "hdnVic_" + szIdAllgtn);
      // CAPTA 4.3: This would only be set if we're coming from the Special Investigation page
      if (StringHelper.isNotEmptyOrNull(ContextHelper.getStringSafe(request, "hdnIdSpclInvAllgtnVictim"))) {
        idVictim = ContextHelper.getStringSafe(request, "hdnIdSpclInvAllgtnVictim");
      }
      idAP = ContextHelper.getStringSafe(request, "hdnPerp_" + szIdAllgtn);
      txtMode = UPDATE;
    }

    setHiddenFields(context, idAllgtn, idVictim, idAP, txtMode);
    CINV46SO cinv46so = (CINV46SO) request.getAttribute("CINV46SO");
    String txtSzSysCdWinMode = GlobalData.getAppMode(request);
    String pageMode;
    if ((PageModeConstants.NEW.equals(txtSzSysCdWinMode)) ||
        (PageModeConstants.MODIFY.equals(txtSzSysCdWinMode)) || (ArchitectureConstants.Y.equals(cinv46so.getCIndCpsPolicyViolation()))) {
      pageMode = PageModeConstants.MODIFY;
    } else {
      pageMode = PageModeConstants.VIEW;
    }
    

    // Set A is normal, everything on mode.
    Sets.setPageSet(Sets.A, request);

    // Set B turns off the Delete and Save and Stay buttons.
    if (txtMode.equals(ADD)) {
      Sets.setPageSet(Sets.B, request);
    }

    // Set C is used for Admin Review mode and Allegations created in intake.
    // It will disable Victim, Allegation, and AP.

    if (((CodesTables.CSTAGES_INT.equals(cinv46so.getSzCdAllegIncidentStage())) ||
         (GlobalData.getUlIdTodo(request) > 0)) &&
                                                (!txtMode.equals(ADD))) {
      Sets.setPageSet(Sets.C, request);
    }

    // Set D is disabes everything.
    if (pageMode.equals(PageModeConstants.VIEW)) {
      Sets.setPageSet(Sets.D, request);
    }

    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, pageMode, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * This method is called by the displayAllgtnDetail_xa method to display multiple allegations.  It will display the
   * Allegation Detial page in Multi Mode.
   *
   * @param context   The GrndsExchangeContext object.
   * @param szAllgtns This string array contains the Allegation ID's.
   */
  private void displayAllgtnDetailMulti(GrndsExchangeContext context, String[] szAllgtns) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAllgtnDetailMulti()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Retrieve timestamps of select allegations.
    List<String> allgtnsTimestamps = new ArrayList<String>();
    for (int i = 0; i < szAllgtns.length; i++) {
      allgtnsTimestamps.add(ContextHelper.getStringSafe(request, "hdnTs_" + szAllgtns[i]));
    }

    callCinv46s_displayAllgtn(context, "0");

    setHiddenFields(context, "0", "", "", MULTI);

    state.setAttribute("szAllgtnArray", szAllgtns, request);
    state.setAttribute("vecAllgtnTimestamps", allgtnsTimestamps, request);

    // Set E is for Multi mode, all fields will be disabled except the Disposition
    // Evidence codes,Text Summary and Severity.
    Sets.setPageSet(Sets.E, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the any function that wishes to prepare a CINV47SI object.  Cinv47s is used to add,
   * update, and delete Allgations.
   *
   * @param context The GrndsExchangeContext object.
   * @return cinv47si The CINV47SI object.
   */
  private CINV47SI populateCinv47s_audAllgtn(GrndsExchangeContext context) throws CheckboxHelperException {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCinv47s_audAllgtn()");
    performanceTrace.enterScope();

    ArchInputStruct input = new ArchInputStruct();
    CINV47SIG cinv47sig = new CINV47SIG();
    CINV47SI cinv47si = new CINV47SI();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    int idAP = ContextHelper.getIntSafe(request, "selUlIdAllegedPerpetrator");
    String apRole = EMPTY_STRING;
    Date apTS = new Date();

    int idVictim = ContextHelper.getIntSafe(request, "selUlIdVictim");
    String vicRole = EMPTY_STRING;
    Date vicTS = new Date();
    CINV46SOG1_ARRAY personListArray = (CINV46SOG1_ARRAY) state.getAttribute("personListArray", request);
    Enumeration personListEnum = personListArray.enumerateCINV46SOG1();

    boolean bARI = CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request));

    while (personListEnum.hasMoreElements()) {
      CINV46SOG1 personDetail = (CINV46SOG1) personListEnum.nextElement();
      if (personDetail.getUlIdPerson() == idAP) {
        apRole = personDetail.getSzCdStagePersRole();
        apTS = personDetail.getTsLastUpdate();
      }
      if (personDetail.getUlIdPerson() == idVictim) {
        vicRole = personDetail.getSzCdStagePersRole();
        vicTS = personDetail.getTsLastUpdate();
      }
    }

    // The page will know if it in Add or Update mode, if the Delete button is
    // pressed, set the cReqFuncCd to "D".
    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    if (null != ContextHelper.getString(request, "btnDelete.x")) {
      input.setCReqFuncCd(DELETE_SER);
    }
    input.setUlPageSizeNbr(1);
    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

    // SIR 18812 - A PENDing Investigation Conclusion must be invalidated even
    // if the worker accessed the page in approval mode because the Recommended
    // Action will be cleared, and the Investigation should not be closed
    // without a Recommended Action.
    // SIR 17233 - set the flag indicating approver mode
    //SMS#112534: Investigation Conclusion should be invalidated on save of allegation
    input.setUlSysNbrReserved1( ArchitectureConstants.N );

    cinv47si.setArchInputStruct(input);
    cinv47si.setUlIdEvent((Integer) state.getAttribute("idEvent",
                                                       request));//GlobalData.getUlIdEvent( request ) );
    String cdStage = GlobalData.getSzCdStage(request);
    cdStage = bARI ? CodesTables.CSTAGES_INV : cdStage;
    cinv47si.setSzCdStage(cdStage);
    String program = GlobalData.getSzCdStageProgram(request);
    cinv47si.setSzCdStageProgram(program);
    cinv47si.setCdAllegDisposition(ContextHelper.getStringSafe(request, HDN_OVERALL_DISP_FIELD_NAME));
    cinv47si.setCINV47SIG(cinv47sig);
    int idTodo = bARI ? GlobalData.getUlIdStage(request) : ContextHelper.getIntSafe(request, "hdnLdIdTodo");
    cinv47si.setLdIdTodo(idTodo);
    
    cinv47sig.setDtDtAllegedIncident(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                     "dtDtAllegedIncident")));
    cinv47sig.setSzCdAllegedMalLocation(ContextHelper.getStringSafe(request, "szCdAllegedMalLocation"));
    cinv47sig.setCdAllegDisposition(ContextHelper.getStringSafe(request, "selCdAllegDisposition"));
    cinv47sig.setSzCdAllegIncidentStage(ContextHelper.getStringSafe(request, "hdnSzCdAllegStage"));
    cinv47sig.setSzTxtEvidenceSummary(ContextHelper.getStringSafe(request, "txtEvidenceSummary"));
    
    // If the disposition is "RTB", then save the severity, otherwise save EMPTY_STRING.
    //if (REASON_TO_BELIEVE.equals(ContextHelper.getStringSafe(request, "selCdAllegDisposition"))) {
     // cinv47sig.setSzCdAllegSeverity(ContextHelper.getStringSafe(request, "selSzCdAllegSeverity"));
    //} else {
    //  cinv47sig.setSzCdAllegSeverity(EMPTY_STRING);    }
    
    // For R2.
    cinv47sig.setSzCdAllegSeverity(ContextHelper.getStringSafe(request, "selSzCdAllegSeverity"));
    cinv47sig.setIndCrimChrgsFiled(ContextHelper.getStringSafe(request, "indCrimChrgsFiled"));
    
    //CAPTA Changes Added
    cinv47sig.setIndChildDeathSeverity(ContextHelper.getStringSafe(request, "indSevChildDeath"));
    cinv47sig.setDtPriorNearFatalMaltrtmnt(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                        "dtPriorNearFatalMaltrtmnt")));    
    
    cinv47sig.setSzCdAllegType(ContextHelper.getStringSafe(request, "selSzCdAllegMalCode"));
    //STGAP00015366: Get the Maltreator relationship from hidden field when its hidden on the page 
    if(StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel"))){
      cinv47sig.setSzCdMaltreatorRel(ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel"));
    }else{
      cinv47sig.setSzCdMaltreatorRel(ContextHelper.getStringSafe(request, "hdnSzCdMaltreatorRel"));
    }
    
    // This is to indicate if maltreatment in care
    String indMaltreatInCare = (String) state.getAttribute("indMaltreatInCare", request);
    cinv47sig.setCIndMaltreatInCare(indMaltreatInCare);
    
    // This is to indicate if Unsubstantiated MIC
    String indUnsubstantiatedMIC = (String) state.getAttribute("indUnSubstantiatedMIC", request);
    cinv47sig.setCIndUnsubMIC(indUnsubstantiatedMIC);
    
    
    // Duration has been removed from the page.
    cinv47sig.setSzTxtAllegDuration(EMPTY_STRING);
    cinv47sig.setUlIdAllegation(ContextHelper.getIntSafe(request, "hdnUlIdAllegation"));
    cinv47sig.setUlIdAllegedPerpetrator(idAP);
    cinv47sig.setSzCdStagePersRole(apRole);
    cinv47sig.setTsSysTsLastUpdate3(apTS);
    cinv47sig.setUlIdVictim(idVictim);
    cinv47sig.setSzCdStagePersRole2(vicRole);
    cinv47sig.setTsSysTsLastUpdate4(vicTS);
    cinv47sig.setUlIdStage(getIdStage(context));
    cinv47sig.setSzCdTask(getCdTask(context));
    cinv47sig.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));

    // AllegEvidenceCode_ARRAY is for manipulating an array of AllegEvidenceCode's
    AllegEvidenceCode_ARRAY allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();

    AllegEvidence_ARRAY allegEvidenceArray = (AllegEvidence_ARRAY) state.getAttribute("allegEvidence_ARRAY",
                                                                                      request);

    //begin: populate the input array from the checkboxes and the output object
    if (ContextHelper.getIntSafe(request, "hdnUlIdAllegation") == 0) {
      String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxEvidenceCode");
      for (int i = 0; i < checkedValues.length; i++) {
        AllegEvidenceCode allegEvidenceCode = new AllegEvidenceCode();
        allegEvidenceCode.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        allegEvidenceCode.setSzCdEvidenceCode(checkedValues[i]);
        allegEvidenceCode_Array.addAllegEvidenceCode(allegEvidenceCode);
      }
      cinv47sig.setAllegEvidenceCode_ARRAY(allegEvidenceCode_Array);
    } else {
      if (input.getCReqFuncCd().equals(ServiceConstants.REQ_FUNC_CD_DELETE)) {
        if (null != allegEvidenceArray && allegEvidenceArray.getAllegationEvidenceCount() > 0) {
          Enumeration allegEvidenceArray_enum = allegEvidenceArray.enumerateAllegationEvidence();
          AllegationEvidence allegationEvidence;
          while (allegEvidenceArray_enum.hasMoreElements()) {
            AllegEvidenceCode allegEvidenceCode = new AllegEvidenceCode();
            allegationEvidence = (AllegationEvidence) allegEvidenceArray_enum.nextElement();
            allegEvidenceCode.setUlIdAllegEvidence(allegationEvidence.getUlIdAllegEvidence());
            allegEvidenceCode.setUlIdAllegation(allegationEvidence.getUlIdAllegation());
            allegEvidenceCode.setSzCdEvidenceCode(allegationEvidence.getSzCdEvidenceCode());
            allegEvidenceCode.setTsLastUpdate(allegationEvidence.getTsLastUpdate());
            allegEvidenceCode.setSzCdScrDataAction(DELETE_SER);
            allegEvidenceCode_Array.addAllegEvidenceCode(allegEvidenceCode);
          }
          cinv47sig.setAllegEvidenceCode_ARRAY(allegEvidenceCode_Array);
        }
      } else {
        try {
          allegEvidenceCode_Array = (AllegEvidenceCode_ARRAY) state.getAttribute("allegEvidenceCode_Array", request);
          if (allegEvidenceCode_Array == null) {
            allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();
          }
          Collection changedValues =
                  CheckboxHelper.getChangedValues(request,
                                                  "cbxEvidenceCode",
                                                  allegEvidenceCode_Array,
                                                  AllegEvidenceCode.class,
                                                  "szCdEvidenceCode");
          AllegEvidenceCode_ARRAY allegEvidenceCode_ArrayUpdate = new AllegEvidenceCode_ARRAY();
          for (Iterator i = changedValues.iterator(); i.hasNext();) {
            CheckboxHelper.ObjectActionCodePair pair =
                    (CheckboxHelper.ObjectActionCodePair) i.next();

            AllegEvidenceCode row = (AllegEvidenceCode) pair.getObject();
            String action = pair.getActionCode();

            AllegEvidenceCode evidenceCode = new AllegEvidenceCode();
            evidenceCode.setSzCdScrDataAction(action);
            evidenceCode.setTsLastUpdate(row.getTsLastUpdate());
            evidenceCode.setUlIdAllegEvidence(row.getUlIdAllegEvidence());
            evidenceCode.setUlIdAllegation(row.getUlIdAllegation());
            evidenceCode.setSzCdEvidenceCode(row.getSzCdEvidenceCode());
            allegEvidenceCode_ArrayUpdate.addAllegEvidenceCode(evidenceCode);
          }
          cinv47sig.setAllegEvidenceCode_ARRAY(allegEvidenceCode_ArrayUpdate);
        } catch (Exception e) {
          throw new CheckboxHelperException("createCheckBoxGroup", e);
        }
      }
    }
    //end: populate the input array from the checkboxes and the output object

    if (bARI) {
      cinv47sig.setBIndFacilAllegCancelHist("N");
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv47si;
  }

  /**
   * This method is called by the deleteAllgtnList_xa method to populate the CINV47SI object.  This method will populate
   * the input object from data from the CINV46SO object that is in state, rather than data from the request.
   *
   * @param context          The GrndsExchangeContext object.
   * @param txtUlIdAllgation The Allegation ID of the Allegation the users wishes to delete.
   * @return cinv47si The CINV47SI object.
   */
  private CINV47SI populateCinv47s_Delete(GrndsExchangeContext context, String txtUlIdAllgation) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCinv47s_Delete()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ArchInputStruct input = new ArchInputStruct();
    CINV47SIG cinv47sig = new CINV47SIG();
    CINV47SI cinv47si = new CINV47SI();
    CINV46SO cinv46so = (CINV46SO) request.getAttribute("CINV46SO");
    Enumeration personListEnum = cinv46so.getCINV46SOG1_ARRAY().enumerateCINV46SOG1();

    int idAP = ContextHelper.getIntSafe(request, "hdnPerp_" + txtUlIdAllgation);
    int idVictim = ContextHelper.getIntSafe(request, "hdnVic_" + txtUlIdAllgation);
    String vicRole = EMPTY_STRING;
    Date vicTS = new Date();
    String apRole = EMPTY_STRING;
    Date apTS = new Date();
    while (personListEnum.hasMoreElements()) {
      CINV46SOG1 personDetail = (CINV46SOG1) personListEnum.nextElement();
      if (personDetail.getUlIdPerson() == idVictim) {
        vicRole = personDetail.getSzCdStagePersRole();
        vicTS = personDetail.getTsLastUpdate();
      }
      if (personDetail.getUlIdPerson() == idAP) {
        apRole = personDetail.getSzCdStagePersRole();
        apTS = personDetail.getTsLastUpdate();
      }
    }

    input.setCReqFuncCd(DELETE_SER);
    input.setUlPageSizeNbr(1);
    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

    // Load any Allegation Evidence codes assoicated with allegations from the CINV46SO object
    AllegEvidence_ARRAY allegEvidenceArray = cinv46so.getAllegEvidence_ARRAY();
    if (null != allegEvidenceArray && allegEvidenceArray.getAllegationEvidenceCount() > 0) {
      AllegEvidenceCode_ARRAY allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();
      Enumeration allegEvidenceArray_enum = allegEvidenceArray.enumerateAllegationEvidence();
      AllegationEvidence allegationEvidence;
      while (allegEvidenceArray_enum.hasMoreElements()) {
        AllegEvidenceCode allegEvidenceCode = new AllegEvidenceCode();
        allegationEvidence = (AllegationEvidence) allegEvidenceArray_enum.nextElement();
        allegEvidenceCode.setUlIdAllegEvidence(allegationEvidence.getUlIdAllegEvidence());
        allegEvidenceCode.setUlIdAllegation(allegationEvidence.getUlIdAllegation());
        allegEvidenceCode.setSzCdEvidenceCode(allegationEvidence.getSzCdEvidenceCode());
        allegEvidenceCode.setTsLastUpdate(allegationEvidence.getTsLastUpdate());
        allegEvidenceCode.setSzCdScrDataAction(DELETE_SER);
        allegEvidenceCode_Array.addAllegEvidenceCode(allegEvidenceCode);
      }
      cinv47sig.setAllegEvidenceCode_ARRAY(allegEvidenceCode_Array);
    }

    // SIR 18812 - A PENDing Investigation Conclusion must be invalidated even
    // if the worker accessed the page in approval mode because the Recommended
    // Action will be cleared, and the Investigation should not be closed
    // without a Recommended Action.
    // SIR 17233 - set the flag indicating approver mode
    //SMS#112534    
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    cinv47si.setArchInputStruct(input);
    cinv47si.setSzCdStage(GlobalData.getSzCdStage(request));
    cinv47si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    cinv47si.setCdAllegDisposition(ContextHelper.getStringSafe(request, HDN_OVERALL_DISP_FIELD_NAME));
    cinv47si.setCINV47SIG(cinv47sig);
    cinv47si.setLdIdTodo(0);
    cinv47si.setUlIdEvent((Integer) state.getAttribute("idEvent",
                                                       request));

    cinv47sig.setCdAllegDisposition(cinv46so.getCdAllegDisposition());
    cinv47sig.setSzCdAllegIncidentStage(cinv46so.getSzCdAllegIncidentStage());
    cinv47sig.setSzCdAllegSeverity(cinv46so.getSzCdAllegSeverity());
    cinv47sig.setIndCrimChrgsFiled(cinv46so.getIndCrimChrgsFiled());
    cinv47sig.setSzCdAllegType(cinv46so.getSzCdAllegType());
    cinv47sig.setSzTxtAllegDuration(EMPTY_STRING);
    cinv47sig.setSzCdMaltreatorRel(cinv46so.getSzCdMaltreatorRel());
    cinv47sig.setUlIdAllegation(Integer.parseInt(txtUlIdAllgation));
    //CAPTA Changes Added
    cinv47sig.setIndChildDeathSeverity(cinv46so.getIndChildDeathSeverity());
    cinv47sig.setDtPriorNearFatalMaltrtmnt(cinv46so.getDtPriorNearFatalMaltrtmnt());
    
    cinv47sig.setUlIdAllegedPerpetrator(idAP);
    cinv47sig.setSzCdStagePersRole(apRole);
    cinv47sig.setTsSysTsLastUpdate3(apTS);

    cinv47sig.setUlIdVictim(idVictim);
    cinv47sig.setSzCdStagePersRole2(vicRole);
    cinv47sig.setTsSysTsLastUpdate4(vicTS);

    cinv47sig.setUlIdStage(getIdStage(context));
    cinv47sig.setSzCdTask(getCdTask(context));
    cinv47sig.setTsLastUpdate(cinv46so.getTsLastUpdate());

    
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv47si;
  }


  /**
   * This method is called by the saveFacilityAllgtnMulti_xa method to prepare a CINV09SI object.  Cinv09s is used to
   * save multiple Allgations.
   *
   * @param context The GrndsExchangeContext object.
   * @return cinv09si The CINV09SI object.
   */
  private CINV09SI populateCinv09s_SaveMulti(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCinv09s_SaveMulti()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    CINV09SI cinv09si = new CINV09SI();
    CINV09SIG_ARRAY cinv09sig_array = new CINV09SIG_ARRAY();
    CdAllegDisposition_ARRAY disp_array = new CdAllegDisposition_ARRAY();

    String[] szAllgtns = (String[]) state.getAttribute("szAllgtnArray", request);
    List allgtnsTimestamps = (List) state.getAttribute("vecAllgtnTimestamps", request);

    //Set the values for the ArchInputStruct
    input.setCReqFuncCd(UPDATE_SER);
    input.setBPerfInd(YES);
    input.setBDataAcsInd(YES);
    input.setUlPageSizeNbr(szAllgtns.length);
    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

    // SIR 18812 - A PENDing Investigation Conclusion must be invalidated even
    // if the worker accessed the page in approval mode because the Recommended
    // Action will be cleared, and the Investigation should not be closed
    // without a Recommended Action.
    // SIR 17233 - set the flag indicating approver mode
    //SMS#112534
    input.setUlSysNbrReserved1( ArchitectureConstants.N );

    cinv09si.setArchInputStruct(input);

    for (int i = 0; i < szAllgtns.length; i++) {
      CINV09SIG cinv09sig = new CINV09SIG();
      cinv09sig.setUlIdAllegation(Integer.parseInt(szAllgtns[i]));
      java.util.Date d1 = DateHelper.toJavaDateSafe((String) allgtnsTimestamps.get(i));
      cinv09sig.setTsLastUpdate(d1);
      cinv09sig_array.addCINV09SIG(cinv09sig);
    }
    cinv09si.setCINV09SIG_ARRAY(cinv09sig_array);

    disp_array.addCdAllegDisposition(0, ContextHelper.getStringSafe(request, "selCdAllegDisposition")); //Detail
    disp_array.addCdAllegDisposition(1, ContextHelper.getStringSafe(request, HDN_OVERALL_DISP_FIELD_NAME));  //Overall
    cinv09si.setCdAllegDisposition_ARRAY(disp_array);

    cinv09si.setUlIdEvent((Integer) state.getAttribute("idEvent",
                                                       request));//GlobalData.getUlIdEvent( request ) );
    cinv09si.setUlIdStage(getIdStage(context));
    cinv09si.setSzCdTask(getCdTask(context));
    cinv09si.setSzCdStage(GlobalData.getSzCdStage(request));
    cinv09si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    cinv09si.setSzTxtEvidenceSummary(ContextHelper.getStringSafe(request, "txtEvidenceSummary"));

    // If Disposition equal "RTB" then severity is requiered, otherwise Severity is EMPTY_STRING.
    if (REASON_TO_BELIEVE.equals(ContextHelper.getStringSafe(request, "selCdAllegDisposition"))) {
      cinv09si.setSzCdAllegSeverity(ContextHelper.getStringSafe(request, "selSzCdAllegSeverity"));
    } else {
      cinv09si.setSzCdAllegSeverity(EMPTY_STRING);
    }

    // AllegEvidenceCode_ARRAY is for manipulating an array of AllegEvidenceCode's
    AllegEvidenceCode_ARRAY allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();
    // If any boxes are checked this would be an ADD
    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxEvidenceCode");
    for (int i = 0; i < checkedValues.length; i++) {
      AllegEvidenceCode allegEvidenceCode = new AllegEvidenceCode();
      allegEvidenceCode.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      allegEvidenceCode.setSzCdEvidenceCode(checkedValues[i]);
      allegEvidenceCode_Array.addAllegEvidenceCode(allegEvidenceCode);
    }
    cinv09si.setAllegEvidenceCode_ARRAY(allegEvidenceCode_Array);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv09si;
  }

  /**
   * This method is called by the calculateOverallDisp_xa method to prepare a CINV45SI object.  Cinv45s is used to
   * calculate and save the overall disposition.
   *
   * @param context The GrndsExchangeContext object.
   * @return cinv45si The CINV45SI object.
   */
  private CINV45SI populateCinv45s_CalcOverallDisp(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCinv45s_CalcOverallDisp()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String originalOverallDisposition = ContextHelper.getStringSafe(request, HDN_OVERALL_DISP_FIELD_NAME);

    CINV45SI cinv45si = new CINV45SI();
    ArchInputStruct input = new ArchInputStruct();

    boolean bARI = CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request));
    String program = GlobalData.getSzCdStageProgram(request);

    input.setCReqFuncCd(UPDATE_SER);
    input.setBPerfInd(YES);
    input.setBDataAcsInd(YES);
    input.setUsPageNbr(0);
    input.setUlPageSizeNbr(0);
    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

    cinv45si.setArchInputStruct(input);
    cinv45si.setUlIdStage(getIdStage(context));
    cinv45si.setSzCdTask(getCdTask(context));
    cinv45si.setSzCdStageProgram(program);
    // SIR 18812 - Pass the original Overall Disposition to the Calculate Overall
    // Disposition service. If the new Overall Disposition is different from the
    // original one, the service will clear the Recommended Action on the
    // Investigation Conclusion page.
    cinv45si.setSzCdOverallDisp(originalOverallDisposition);
    int idTodo = bARI ? GlobalData.getUlIdStage(request) : ContextHelper.getIntSafe(request, "hdnLdIdTodo");
    cinv45si.setLdIdTodo(idTodo);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv45si;
  }


  /**
   * This method is called by the save methods to calculate the roles of the persons associated with the allegation.
   * <p/>
   * 1) Find current role and timestamp for victim and for perp from AP/VC list in WCD. 2) Calculate role: Current:
   * Designated as   New: in this alleg: NO or UK    AP              AP NO or UK    VC              VC VC          VC VC
   * VC          AV or VP        VP AV          AV              AV AV          VC or VP        VP VP AV, VC, or VP   VP
   * any         AP = VC         VP
   *
   * @param cinv47si The CINV47SI object that contains the Allegation information.
   * @return cinv47si The modifed CINV47SI object.
   */
  private CINV47SI calculateRoles(CINV47SI cinv47si) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".calculateRoles()");
    performanceTrace.enterScope();

    String victimRole = cinv47si.getCINV47SIG().getSzCdStagePersRole2();
    String apRole = cinv47si.getCINV47SIG().getSzCdStagePersRole();

    if (!EMPTY_STRING.equals(victimRole)) {
      if (CodesTables.CROLES_NO.equals(victimRole) || CodesTables.CROLES_UK.equals(victimRole)) {
        victimRole = CodesTables.CROLES_VC;
      }
      if (CodesTables.CROLES_AP.equals(victimRole)) {
        victimRole = CodesTables.CROLES_VP;
      }
    }

    if (!EMPTY_STRING.equals(apRole)) {
      if (CodesTables.CROLES_NO.equals(apRole) || CodesTables.CROLES_UK.equals(apRole)) {
        apRole = CodesTables.CROLES_AP;
      }
      if (CodesTables.CROLES_VC.equals(apRole)) {
        apRole = CodesTables.CROLES_VP;
      }
    }

    if (victimRole.equals(apRole)) {
      victimRole = CodesTables.CROLES_VP;
      apRole = CodesTables.CROLES_VP;
    }

    cinv47si.getCINV47SIG().setSzCdStagePersRole2(victimRole);
    cinv47si.getCINV47SIG().setSzCdStagePersRole(apRole);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv47si;
  }


  /**
   * This method is called the display Detail methods to check if the Allegation that is begin displayed contains the
   * person that is being passed to the List.
   *
   * @param context    The GrndsExchangeContext object.
   * @param szIdAllgtn The Allagetion ID we are checking.
   * @param idAllgtns  The Allegtaion ID array we are checking..
   * @return boolean Method return true if person is not in selected Allegation.
   */
  private boolean personCheck(GrndsExchangeContext context, String szIdAllgtn, String[] idAllgtns) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".personCheck()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    int personID = state.getAttribute("personRequestor", request) != null ?
                   (Integer) state.getAttribute("personRequestor", request) :
                   0;

    if ((personID == 0)) {
      return false;
    }

    if (szIdAllgtn.length() > 2) {
      if (personID != ContextHelper.getIntSafe(context, "hdnPerp_" + szIdAllgtn)) {
        return true;
      }
    } else {
      for (int i = 0; i < idAllgtns.length; i++) {
        if (personID != ContextHelper.getIntSafe(context, "hdnPerp_" + idAllgtns[i])) {
          return true;
        }
      }
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return false;
  }

  /**
   * Set the re-occuring hidden values.
   *
   * @param context      The GrndsExchangeContext object.
   * @param idAllegation The Allagetion ID we are setting.
   * @param idVictim     The Victim ID we are setting.
   * @param idAP         The The AP ID we are setting.
   * @param Mode         The Mode teh page will be in (Add, Update, or Multi).
   */
  private void setHiddenFields(GrndsExchangeContext context,
                                 String idAllegation, String idVictim, String idAP, String Mode) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setHiddenFields()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    request.setAttribute("hdnUlIdAllegation", idAllegation);
    request.setAttribute("selUlIdVictim", idVictim);
    request.setAttribute("selUlIdAllegedPerpetrator", idAP);
    request.setAttribute("hdnMode", Mode);

    request.setAttribute(HDN_OVERALL_DISP_FIELD_NAME, ContextHelper.getStringSafe(request,
                                                                                  HDN_OVERALL_DISP_FIELD_NAME));

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }


  /**
   * Repopulate cinv46so.  This will repopulate the cinv46so object with data from the request.  Will be used when Fac
   * Allgtn or injury detail error out.
   *
   * @param context The GrndsExchangeContext object.
   */
  private void populateCinv46so(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCinv46so()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    CINV46SO cinv46so = new CINV46SO();

    cinv46so.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));
    cinv46so.setSzCdAllegIncidentStage(ContextHelper.getStringSafe(request, "dspSzCdAllegStage"));
    cinv46so.setSzCdAllegType(ContextHelper.getStringSafe(request, "selSzCdAllegType"));
    cinv46so.setSzCdMaltreatorRel(ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel"));
    cinv46so.setCdAllegDisposition(ContextHelper.getStringSafe(request, "selCdAllegDisposition"));
    cinv46so.setSzCdAllegSeverity(ContextHelper.getStringSafe(request, "selSzCdAllegSeverity"));
    cinv46so.setIndCrimChrgsFiled(ContextHelper.getStringSafe(request, "indCrimChrgsFiled"));
    //Adding code for CAPTA
    cinv46so.setIndChildDeathSeverity(ContextHelper.getStringSafe(request, "indChildDeathSeverity"));
    cinv46so.setDtPriorNearFatalMaltrtmnt(ContextHelper.getCastorDateSafe(request, "dtPriorNearFatalMaltrtmnt"));
    request.setAttribute("CINV46SO", cinv46so);

    setHiddenFields(context, ContextHelper.getStringSafe(request, "hdnUlIdAllegation"),
                    ContextHelper.getStringSafe(request, "selUlIdVictim"),
                    ContextHelper.getStringSafe(request, "selUlIdAllegedPerpetrator"),
                    ContextHelper.getStringSafe(request, "hdnMode"));

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  private int getIdStage(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    return (state.getAttribute("relatedStage", request) != null) ?
           (Integer) state.getAttribute("relatedStage", request) :
           GlobalData.getUlIdStage(request);
  }

  private String getCdTask(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    String program = GlobalData.getSzCdStageProgram(request);

    String task = "";
    if (CodesTables.CPGRMS_APS.equals(program)) {
      task = CD_TASK_APS_ALLEGATION;
    } else if (CodesTables.CPGRMS_CPS.equals(program)) {
      task = CD_TASK_CPS_ALLEGATION;
    } else if (CodesTables.CPGRMS_AFC.equals(program)) {
      task = CD_TASK_AFC_ALLEGATION;
    } else if (CodesTables.CPGRMS_CCL.equals(program)) {
      task = CD_TASK_CCL_ALLEGATION;
    } else if (CodesTables.CPGRMS_RCL.equals(program)) {
      task = CD_TASK_RCL_ALLEGATION;
    }

    return task;
  }


  /**
   * Appends pageName to CONVERSATION_URL
   *
   * @param pageName String
   * @return CONVERSATION_URL + pagename
   */
  private static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }

  /**
   * This method is called by the GRNDS controller when the user clicks on an Save button or Save and Stay button.  It
   * will save the information displayed on the Allegation Detail page and then reload the page or navigate to the
   * Allegation List page.
   * <p/>
   * <br> Services Used:<br> <ul> <li>CINV47S - Add and Update Allegation Detail</li> <li>CINV45S - Calculate Overall
   * Disposition</li> <li>CINV44S - Display Allegation List</li> </ul>
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveAllgtn_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAllgtn_xa()");
    performanceTrace.enterScope();

    CINV47SI cinv47si;
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    try {
      // SIR 22595 get the ulidAllegation, and currently saved disposition out of context
      // Set a boolean to determine if all Allegations have a disposition
      int ulIdAllegation = ContextHelper.getIntSafe(request, "hdnUlIdAllegation");
      String disp = ContextHelper.getStringSafe(request, "selCdAllegDisposition");
      boolean bAllDispAssigned = true;

      
      cinv47si = populateCinv47s_audAllgtn(context);
      cinv47si = calculateRoles(cinv47si);
      intake.saveAllegDtl(cinv47si);
      
      state.removeAttribute("warnMaltreatmentInCare", request);
      state.removeAttribute("indMaltreatInCare", request);

      // SIR 22595 If the currently saved disposition is blank,
      // set the boolean to false
      if ("".equals(disp)) {
        bAllDispAssigned = false;
      } else {
        ROWCINV44SOG_ARRAY allgtnListArray = (ROWCINV44SOG_ARRAY) state.
                getAttribute("allgtnListArray",
                             request);
        Enumeration allgtnListEnum = allgtnListArray.enumerateROWCINV44SOG();
        while (allgtnListEnum.hasMoreElements()) {
          ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) allgtnListEnum.nextElement();
          // If the disposition for the row is blank, and we are not looking at the current
          // row we are saving, set the boolean to false
          if ("".equals(allgtnListDetail.getCdAllegDisposition()) &&
              ulIdAllegation != allgtnListDetail.getUlIdAllegation()) {
            bAllDispAssigned = false;
            break;
          }
        }
      }

      // SIR 22595 only call calculateOverallDisp, if all dispositions have been
      // assigned for all allegation rows.
      if (bAllDispAssigned) {
        calculateOverallDisp(context);
      }

      // CAPTA Changes Added
      // User successfully saves the Allegation Detail noting that a Child Death was
      // not due to prior Near Fatality, but system finds an allegation in a prior case
      // with a severity of Near Fatality for the alleged victim.
      if ("Y".equals(cinv47si.getCINV47SIG().getIndPriorNearFatality())) {
        setInformationalMessage(Messages.MSG_INV_PRIOR_NEAR_FATALITY, DISPLAY_PAGE_ALLGTN_LIST, request);
      }
      
      if (null != ContextHelper.getString(request, "btnSaveAndStay.x")) {
        this.setPresentationBranch(STAY_BRANCH, context);
        populateCinv46so(context);
      } else {
        callCinv44s_displayAllgtnList(context);
      }
    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      populateCinv46so(context);

      String errorMessage;
      switch (we.getErrorCode()) {
        case Messages.MSG_INV_DISP_INVALID:
          this.setPresentationBranch(STAY_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_DISP_INVALID);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.MSG_SYS_STAGE_CLOSED:
          this.setPresentationBranch(STAY_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
          this.setPresentationBranch(STAY_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.MSG_SYS_MULT_INST:
          this.setPresentationBranch(STAY_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.MSG_NO_DUP_LB_ROW:
          this.setPresentationBranch(STAY_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_DUP_LB_ROW);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        default:
          if (we.getErrorCode() != 0) {
            this.setPresentationBranch(STAY_BRANCH, context);
            errorMessage = MessageLookup.getMessageByNumber(we.getErrorCode());
            setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          } else {
            GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
            processSevereException(context, we);
          }
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General  Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the GRNDS controller when the user clicks on an Save button when the page is in Multi
   * mode.  It will save the information displayed on the Allegation Detail page and then navigate to the Allegation
   * List page.
   * <p/>
   * <br> Services Used:<br> <ul> <li>CINV09S - Save Allegation Detail Multi</li> <li>CINV45S - Calculate Overall
   * Disposition</li> <li>CINV44S - Display Allegation List</li> </ul>
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveAllgtnMulti_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAllgtnMulti_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CINV09SI cinv09si = populateCinv09s_SaveMulti(context);
      intake.saveMultipleAllegationDetail(cinv09si);

      // SIR 22595 get the ulidAllegations out of state, and currently saved dispostion
      // out of context Set a boolean to determine if all Allegations have a disposition
      String[] szAllgtns = (String[]) state.getAttribute("szAllgtnArray", request);
      String disp = ContextHelper.getStringSafe(request, "selCdAllegDisposition");
      boolean bAllDispAssigned = true;

      // Create a set for all of the rows we are currently saving.
      Set<String> ulIdAllegationSet = new HashSet<String>();
      ulIdAllegationSet.addAll(Arrays.asList(szAllgtns));

      // SIR 22595 If the currently saved disposition is blank,
      // set the boolean to false
      if ("".equals(disp)) {
        bAllDispAssigned = false;
      } else {
        ROWCINV44SOG_ARRAY allgtnListArray = (ROWCINV44SOG_ARRAY) state.getAttribute("allgtnListArray", request);
        Enumeration allgtnListEnum = allgtnListArray.enumerateROWCINV44SOG();

        while (allgtnListEnum.hasMoreElements()) {
          ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) allgtnListEnum.
                  nextElement();
          String ulIdAllegationString = String.valueOf(allgtnListDetail.getUlIdAllegation());
          // If the disposition for the row is blank, and we are not looking at any of the current
          // rows we are saving, set the boolean to false
          if ("".equals(allgtnListDetail.getCdAllegDisposition()) &&
              !ulIdAllegationSet.contains(ulIdAllegationString)) {
            bAllDispAssigned = false;
            break;
          }
        }

      }

      // SIR 22595 only call calculateOverallDisp, if all dispositions have been
      // assigned for all allegation rows.
      if (bAllDispAssigned) {
        calculateOverallDisp(context);
      }

      callCinv44s_displayAllgtnList(context);

    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      populateCinv46so(context);

      String errorMessage;
      switch (we.getErrorCode()) {
        case Messages.MSG_INV_DISP_INVALID:
          this.setPresentationBranch(ERROR_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_DISP_INVALID);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.MSG_SYS_STAGE_CLOSED:
          this.setPresentationBranch(ERROR_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
          this.setPresentationBranch(ERROR_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        case Messages.MSG_SYS_MULT_INST:
          this.setPresentationBranch(ERROR_BRANCH, context);
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_DTL, context.getRequest());
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General  Failure:" + e.getMessage());
      processSevereException(context, e);
    }

// Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the saveAllgtn_xa, saveAllgtnMulti_xa, saveFacilityAllgtn_xa, and
   * saveFacilityAllgtnMulti_xa methods.  It will calculate the overall disposition of the stage.
   *
   * @param context The GrndsExchangeContext object.
   */
  private void calculateOverallDisp(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".calculateOverallDisp()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      CINV45SI cinv45si = populateCinv45s_CalcOverallDisp(context);

      CINV45SO cinv45so = intake.saveRoleDisp(cinv45si);

      request.setAttribute("CINV45SO", cinv45so);

      if (YES.equals(cinv45so.getCIndRuloutOrAdm())) {
        String infoMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_RULOUT_OR_ADM);
        setInformationalMessage(infoMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
      }

    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      String errorMessage;
      switch (we.getErrorCode())  //getErrorCode() )
      {
        case -1:
//        case OVERALL_DISPOSITION_BLANKED:
//          // These errors are ok.
//          break;
        case Messages.MSG_SYS_STAGE_CLOSED:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.MSG_SYS_MULT_INST:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.MSG_INV_ALL_DISP_MERGED:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_ALL_DISP_MERGED);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;

        default:

//          if (we.getRc() != OVERALL_DISPOSITION_BLANKED) {
//            break;
//          }

          if (we.getErrorCode() != OVERALL_DISPOSITION_BLANKED) {
            processSevereException(context, we); //-- added by abgoode for debugging
            break;
          }

          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the GRNDS controller when the user clicks on an delete button from the Allegation Detail
   * page.  It will delete the currently displayed on the Allgeation Detail page and navigate to the Allegation List
   * page.
   * <p/>
   * <br> Services Used:<br> <ul> <li>CINV47S - Delete Allegation Detail</li> <li>CINV45S - Calculate Overall
   * Disposition</li> <li>CINV44S - Display Allegation List</li> </ul>
   *
   * @param context The GrndsExchangeContext object.
   */
  public void deleteAllgtn_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteAllgtn_xa()");
    performanceTrace.enterScope();

    CINV47SI cinv47si;
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      // SIR 22595 get the ulidAllegation, and currently saved dispostion out of context
      // Set a boolean to determine if all Allegations have a disposition
      int ulIdAllegation = ContextHelper.getIntSafe(request, "hdnUlIdAllegation");
      boolean bAllDispAssigned = true;

      cinv47si = populateCinv47s_audAllgtn(context);
      CINV47SO cinv47so = intake.saveAllegDtl(cinv47si);

      request.setAttribute("CINV47SO", cinv47so);

      ROWCINV44SOG_ARRAY allgtnListArray = (ROWCINV44SOG_ARRAY) state.
              getAttribute("allgtnListArray",
                           request);
      Enumeration allgtnListEnum = allgtnListArray.enumerateROWCINV44SOG();
      while (allgtnListEnum.hasMoreElements()) {
        ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) allgtnListEnum.nextElement();
        // If the disposition for the row is blank, and we are not looking at the current
        // row we are saving, set the boolean to false
        if ("".equals(allgtnListDetail.getCdAllegDisposition()) &&
            ulIdAllegation != allgtnListDetail.getUlIdAllegation()) {
          bAllDispAssigned = false;
          break;
        }
      }

      // SIR 22595 only call calculateOverallDisp, if all dispositions have been
      // assigned for all allegation rows.
      if (bAllDispAssigned) {
        calculateOverallDisp(context);
      }

      callCinv44s_displayAllgtnList(context);
    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      callCinv44s_displayAllgtnList(context);

      String errorMessage;
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.MSG_INV_DISP_INVALID:
        case Messages.MSG_SYS_MULT_INST:
        case Messages.MSG_SYS_STAGE_CLOSED:
        case Messages.MSG_NO_DUP_LB_ROW:
        case Messages.MSG_INV_NOT_DUP_ALLEG:
        case Messages.MSG_INV_NO_DEL_INT_ALLEG:
          errorMessage = MessageLookup.getMessageByNumber(we.getErrorCode());
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General  Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the GRNDS controller when the user clicks on an delete button from the Allegation List
   * page.  It will delete the selected Allegations and reload the Allegation List page.
   * <p/>
   * <br> Services Used:<br> <ul> <li>CINV46S - Retrieve Alegation Detail information to populate cinv47si</li>
   * <li>CINV47S - Delete Allegation Detail</li> <li>CINV44S - Display Allegation List</li> <li>CINV45S - Calculate
   * Overall Disposition</li> </ul>
   *
   * @param context The GrndsExchangeContext object.
   */
  public void deleteAllgtnList_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteAllgtnList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // SIR 22595 Set a boolean to determine if all Allegations have a disposition
    boolean bAllDispAssigned = true;

    String[] idAllgtns = (CheckboxHelper.getCheckedValues(request, "cbxAllgtn_"));

    // Check Box help will return a String Array with one empty cell if no check boxex
    // were selected.  So set length to 0 if length idAllgtns = 1 and the first cell is null.
    int length = idAllgtns.length;
    if (length == 0) {
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ONE_ALLEGATION),
                      DISPLAY_PAGE_ALLGTN_LIST, request);
      return;
    }

    try {
      // For each allegation that was selected, retrieve its info and use populateCinv47s_Delete()
      // to populate cinv47si, the call teh service to delete it.
      for (int i = 0; i < length; i++) {
        callCinv46s_displayAllgtn(context, idAllgtns[i]);
        CINV47SI cinv47si = populateCinv47s_Delete(context, idAllgtns[i]);
        intake.saveAllegDtl(cinv47si);

      }

      // Create a set for all of the rows we are currently deleting.
      Set<String> ulIdAllegationSet = new HashSet<String>();
      ulIdAllegationSet.addAll(Arrays.asList(idAllgtns));

      ROWCINV44SOG_ARRAY allgtnListArray = (ROWCINV44SOG_ARRAY) state.getAttribute("allgtnListArray", request);
      Enumeration allgtnListEnum = allgtnListArray.enumerateROWCINV44SOG();

      while (allgtnListEnum.hasMoreElements()) {
        ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) allgtnListEnum.
                nextElement();
        String ulIdAllegationString = String.valueOf(allgtnListDetail.getUlIdAllegation());
        // If the disposition for the row is blank, and we are not looking at any of the current
        // rows we are deleting, set the boolean to false
        if ("".equals(allgtnListDetail.getCdAllegDisposition()) &&
            !ulIdAllegationSet.contains(ulIdAllegationString)) {
          bAllDispAssigned = false;
          break;
        }
      }

      // SIR 22595 only call calculateOverallDisp, if all dispositions have been
      // assigned for all allegation rows.
      if (bAllDispAssigned) {
        calculateOverallDisp(context);
      }
      callCinv44s_displayAllgtnList(context);
    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      callCinv44s_displayAllgtnList(context);

      String errorMessage;
      switch (we.getErrorCode()) {
        case Messages.MSG_CMN_UPDATE_FAILED:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_DUP_LB_ROW);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.MSG_INV_NOT_DUP_ALLEG:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_NOT_DUP_ALLEG);
          setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
          break;
        case Messages.MSG_INV_NO_DEL_INT_ALLEG:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_NO_DEL_INT_ALLEG);
        setErrorMessage(errorMessage, DISPLAY_PAGE_ALLGTN_LIST, context.getRequest());
        break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the any function that wishes to display the Allegtion Detail page.
   *
   * @param context    The GrndsExchangeContext object.
   * @param szIdAllgtn The Allegation ID for the Facility Allegaiton you wish you to display.
   */
  private void callCinv46s_displayAllgtn(GrndsExchangeContext context, String szIdAllgtn) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callCinv46s_displayAllgtn()");
    performanceTrace.enterScope();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      HttpServletRequest request = context.getRequest();

      state.removeAttribute("checkedValues", request);

      CINV46SI cinv46si = new CINV46SI();
      ArchInputStruct input = new ArchInputStruct();
      UserProfile user = UserProfileHelper.getUserProfile(request);
      GlobalData.setUlIdPerson(user.getUserID(), request);

      //Set the values for the ArchInputStruct
      input.setBPerfInd(YES);
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(PAGE_SIZE);
      input.setSzUserId(Integer.toString(user.getUserID()));

      cinv46si.setArchInputStruct(input);
      cinv46si.setUlIdAllegation(Integer.parseInt(szIdAllgtn));
      cinv46si.setUlIdStage(getIdStage(context));

      // RetrieveAllegationDetail 
      CINV46SO cinv46so = intake.retrieveAllegationDetail(cinv46si);

      // Need to load the AllegEvidence_ARRAY into a List Object for the .jsp page codesCheckbox tag. 
      AllegEvidence_ARRAY allegEvidenceArray = cinv46so.getAllegEvidence_ARRAY();

      AllegEvidenceCode_ARRAY allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();

      // Load the array to be used with Checkbox Helper
      if (null != allegEvidenceArray && allegEvidenceArray.getAllegationEvidenceCount() > 0) {
        Enumeration allegEvidenceArray_enum = allegEvidenceArray.enumerateAllegationEvidence();
        List checkedValues = CastorArrayHelper.getStringVector(allegEvidenceArray_enum, "szCdEvidenceCode");
        state.setAttribute("checkedValues", checkedValues, request);

        // We need to store the original evidenceCode values for future reference and set in the request.
        //AllegEvidenceCode_ARRAY allegEvidenceCode_Array = new AllegEvidenceCode_ARRAY();
        AllegationEvidence allegationEvidence;
        Enumeration allegEvidenceCodeArray_enum = allegEvidenceArray.enumerateAllegationEvidence();
        while (allegEvidenceCodeArray_enum.hasMoreElements()) {
          AllegEvidenceCode allegEvidenceCode = new AllegEvidenceCode();
          allegationEvidence = (AllegationEvidence) allegEvidenceCodeArray_enum.nextElement();
          allegEvidenceCode.setUlIdAllegEvidence(allegationEvidence.getUlIdAllegEvidence());
          allegEvidenceCode.setUlIdAllegation(allegationEvidence.getUlIdAllegation());
          allegEvidenceCode.setSzCdEvidenceCode(allegationEvidence.getSzCdEvidenceCode());
          allegEvidenceCode.setTsLastUpdate(allegationEvidence.getTsLastUpdate());
          allegEvidenceCode_Array.addAllegEvidenceCode(allegEvidenceCode);
        }

        // Set the Arrays into the request for future reference.
        state.setAttribute("allegEvidence_ARRAY", allegEvidenceArray, request);
        state.setAttribute("allegEvidenceCode_Array", allegEvidenceCode_Array, request);
      }

      request.setAttribute("CINV46SO", cinv46so);

      CINV46SOG1_ARRAY personListArray = cinv46so.getCINV46SOG1_ARRAY();
      Enumeration personListEnum = personListArray.enumerateCINV46SOG1();
      String txtSzCdStageProgram = GlobalData.getSzCdStageProgram(request);
      List victimArray = (List) state.getAttribute("vecVictim", request);
      List perpArray = (List) state.getAttribute("vecPerp", request);
      
      // CAPTA 4.3: This is to allow the Allegation Detail page to display the name of the victim for the 
      // selected Allegation on the Special Investigation page. When the link is selected on the SI page,
      // the victimArray object will not be available but the victim on the selected Allegation will be in
      // the request as a hidden variable set on the SI page. Instantiating a new object will also prevent
      // a Null Pointer Exception (NPE) from being thrown.
      if (victimArray == null) {
        victimArray = new ArrayList();
        String idVictim = ContextHelper.getStringSafe(request, "hdnIdSpclInvAllgtnVictim");
        if (StringHelper.isNotEmptyOrNull(idVictim)) {
          victimArray.add(idVictim);
        }
      }
      // CAPTA 4.3: This is to prevent a Null Pointer Exception (NPE) from being thrown when displaying
      // the Allegation Detail page as a result of clicking the link on the Special Investigation page.
      if (perpArray == null) {
        perpArray = new ArrayList();
      }

      // The Victim and AP select boxes have differnt requirements depending on Program.
      List<Option> victimListOptions = new ArrayList<Option>();
      List<Option> apListOptions = new ArrayList<Option>();
      while (personListEnum.hasMoreElements()) {
        CINV46SOG1 personDetail = (CINV46SOG1) personListEnum.nextElement();
        Option option = new Option(Integer.toString(personDetail.getUlIdPerson()), personDetail.getSzNmPersonFull());
        if (CodesTables.CPGRMS_CPS.equals(txtSzCdStageProgram)) {
          // In CPS,
          // Victim list contains all who are below the age of 18 and not married,
          // or were victims before,
          // or their birthday is null in the database.
          // Alleged Perpetrators list contains all who are above the age of 10,
          // or were alleged perpetrators before,
          // or their birthday is null in the database.
          if (personDetail.getDtDtPersonBirth() != null) {
            if (((DateHelper.getAge(personDetail.getDtDtPersonBirth()) < MAX_VICTIM_AGE) &&
                 (!MARRIED.equals(personDetail.getSzCdPersonMaritalStatus()))) ||
                                                                               (victimArray.contains(Integer.toString(
                                                                                       personDetail.getUlIdPerson())))) {
              victimListOptions.add(option);
            }
            if ((DateHelper.getAge(personDetail.getDtDtPersonBirth()) >= MIN_AP_AGE) ||
                (perpArray.contains(Integer.toString(personDetail.getUlIdPerson())))) {
              apListOptions.add(option);
            }
          } else {
            victimListOptions.add(option);
            apListOptions.add(option);
          }
        } else if (CodesTables.CPGRMS_APS.equals(txtSzCdStageProgram)) {
          // In APS, if the person role is Victim, Victim Perpetrator, or Client
          // you are on the victim list.
          // All persons can be Alleged Perpetrators.
          if ((CodesTables.CROLES_VC.equals(personDetail.getSzCdStagePersRole())) ||
              (CodesTables.CROLES_VP.equals(personDetail.getSzCdStagePersRole())) ||
              (CodesTables.CROLEALL_CL.equals(personDetail.getSzCdStagePersRole()))) {
            victimListOptions.add(option);
          }
          apListOptions.add(option);

        } else if (CodesTables.CPGRMS_RCL.equals(txtSzCdStageProgram) || CodesTables.CPGRMS_CCL.equals(
                txtSzCdStageProgram)) {
          // In RCL or CLL, all persons are on both lists.
          victimListOptions.add(option);
          apListOptions.add(option);
        }
      }

      if (victimListOptions.size() == 1) {
        request.setAttribute("selUlIdVictim", victimListOptions.get(0).getCode());
      } else {
        request.setAttribute("selUlIdVictim", EMPTY_STRING);
      }

      state.setAttribute("victimOptions", victimListOptions, request);
      state.setAttribute("apOptions", apListOptions, request);

      // We need this on the save and civn46so is in request and therefore will die
      // once the page is loaded.
      state.setAttribute("personListArray", cinv46so.getCINV46SOG1_ARRAY(), request);

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure in Displaying Allegation Detail:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method checks to see if Maltreatment happened (Substantiated or Unsubstantiated)while the child was in care (in DFCS Care).
   * It uses the date of alleged incident and does a lookup on the LEGAL_STATUS_VIEW to see if at the
   * time of the incident if the child's legal status was one of the 'in DFCS Care'
   * 
   * @param idVictim
   * @param idCase
   * @param dtAllegedIncident
   * @param common
   * @return
   */
  public static Map<String, Boolean>  checkIfMaltreatmentInCare(int idVictim, int idCase, Date dtAllegedIncident, Common common, String cdAllegDisposition, String cdStageType, String cdMaltreatorRel) {
    //boolean isMaltreatmentInCare = false;
    CheckIfMaltreatmentInCareSI checkIfMaltreatmentInCareSI = new CheckIfMaltreatmentInCareSI();
    checkIfMaltreatmentInCareSI.setIdVictim(idVictim);
    checkIfMaltreatmentInCareSI.setIdCase(idCase);
    checkIfMaltreatmentInCareSI.setAllegDisposition(cdAllegDisposition);
    checkIfMaltreatmentInCareSI.setDtAllegedIncident(dtAllegedIncident);
    checkIfMaltreatmentInCareSI.setCdStageType(cdStageType);
    checkIfMaltreatmentInCareSI.setCdMaltreatorRel(cdMaltreatorRel);
    Map<String,Boolean> micMap = common.checkIfMaltreatmentInCare(checkIfMaltreatmentInCareSI);
    return micMap;
  }

  
  /**
   * This method is called by the any function that wishes to display the Allegation List page.
   *
   * @param context The GrndsExchangeContext object.
   */
  private void callCinv44s_displayAllgtnList(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callCinv44s_displayAllgtnList()");
    performanceTrace.enterScope();
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(ALLGTN_LIST_PAGE_SIZE);
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CINV44SI cinv44si = new CINV44SI();
      ArchInputStruct input = new ArchInputStruct();

      //Set the values for the ArchInputStruct
      input.setCReqFuncCd(SEARCH_SER);
      input.setBPerfInd(YES);
      input.setUlPageSizeNbr(ALLGTN_LIST_PAGE_SIZE);
      input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
      input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

      cinv44si.setArchInputStruct(input);
      cinv44si.setUlIdStage(getIdStage(context));
      int idCase = CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request)) ?
                   0 : GlobalData.getUlIdCase(request);
      cinv44si.setUlIdCase(idCase);
      cinv44si.setSzCdAllegIncidentStage(GlobalData.getSzCdStage(request));
      cinv44si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));

      CINV44SO cinv44so = intake.retrieveAllegationList(cinv44si);
      request.setAttribute("CINV44SO", cinv44so);

      // If there is an event then the stage is in pend or appr mode, this code
      // sets the info and popup messages.
      String pageMode = (String) state.getAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
      int ulIdEvent = cinv44so.getUlIdEvent();

      // SIR 18812 - Removed the condition "&& !GlobalData.isApprovalMode( request )"
      // from the if statement. If the Investigation Conclusion is PENDing approval
      // and the user saves the page, the Recommended Action will be cleared. Since
      // the Investigation should not be closed without a Recommended Action, the
      // PENDing approval must be invalidated even if the user access the page in
      // approval mode.
      if ((ulIdEvent > 0) && !PageModeConstants.INQUIRE.equals(pageMode)) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL_POPUP),
                                DISPLAY_PAGE_ALLGTN_LIST, request);
        setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL_POPUP),
                        DISPLAY_PAGE_ALLGTN_LIST, request);
      }
      state.setAttribute("idEvent", cinv44so.getUlIdEvent(), request);

      //set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(cinv44so.getArchOutputStruct(),
                                             cinv44so.getROWCINV44SOG_ARRAY().getROWCINV44SOGCount());
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

      // Create a victim and alleged perpetrator vector.  This list will be used
      // to determine who will appear in the select box in the detail page.
      Enumeration listArrayEnum = cinv44so.getROWCINV44SOG_ARRAY().enumerateROWCINV44SOG();
      List<String> victimArray = new ArrayList<String>();
      List<String> perpArray = new ArrayList<String>();
      while (listArrayEnum.hasMoreElements()) {
        ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) listArrayEnum.nextElement();
        victimArray.add(Integer.toString(allgtnListDetail.getUlIdVictim()));
        perpArray.add(Integer.toString(allgtnListDetail.getUlIdAllegedPerpetrator()));
        
      }
      victimArray = StringHelper.removeDuplicates(victimArray);
      perpArray = StringHelper.removeDuplicates(perpArray);

      state.setAttribute("vecVictim", victimArray, request);
      state.setAttribute("vecPerp", perpArray, request);

      // We need this on the save, cinv44so is only in the request
      state.setAttribute("allgtnListArray", cinv44so.getROWCINV44SOG_ARRAY(), request);

      setHiddenFields(context, "0", "0", "0", "0");

    }
    catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_INV_NO_ALLEGS:
          request.setAttribute("noRowsReturned", "true");
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

}

