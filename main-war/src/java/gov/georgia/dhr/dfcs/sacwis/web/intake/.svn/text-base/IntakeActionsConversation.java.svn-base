package gov.georgia.dhr.dfcs.sacwis.web.intake;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Stage;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CdIncmgDeterm_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfMaltreatmentInCareSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRecordsCheckCompletedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermCmntsAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DetermListAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT14DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdIncmgDetermType_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreateCallOutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.AssignConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

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

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to display, save, and process the Intake Actions page. <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date      User      Description
 *                           --------  --------  --------------------------------------------------
 *                           07/08/03  JMC        SIR  18760 - Changed the logic to correctly truncate
 *                                                Case Names over 25 characters long.
 *                           09/08/03  JMC        SIR 19630 - Added logic in to send the Zip and County
 *                                                of the person designated as case name to Resource
 *                                                Search when a Law Jurisdiction search is performed.
 *                          09/17/03  JMC         SIR 19734 - Modified logic that saved CurrPriority as
 *                                                InitPriority.
 *                          03/29/04  resertg     SIR 22616 -- Put Classification into State so
 *                                                Allegation Detail can filter on it.
 *                          03/30/04  resertg     SIR 22806 - Cleaned up code, fixed Javadocs.  Still
 *                                                need to fix really long Methods and Classes.
 *                          04/05/04  resertg     Fixed erroneous StringHelper refrences to True.
 *                                                Restored displayIntakeActions_xa catch section.
 *                          04/08/04  ochumd      Sir 22646 - Management Information Focus Team and the
 *                                                technical leads for IMPACT Intranet Reports have
 *                                                determined that they need the ID of the PERSON that
 *                                                has been selected as the NM_STAGE.  NM_STAGE is stored
 *                                                on the STAGE table.  An indicator  has  been added to
 *                                                the STAGE_PERSON_LINK table indicating the selected nmstage.
 *                          07/12/04  ochumd      Sir 22934 - Sometimes when a report is made to SWI, the
 *                                                reporter doesn't know the names of the people involved,
 *                                                so they are listed as unknown on the people list of the
 *                                                intake. Usually, the investigator will obtain the names
 *                                                of the people during the investigation and then update
 *                                                IMPACT with the correct names. This should not update the
 *                                                names in the intake since that stage is already closed
 *                                                and essentially frozen (i.e whatever information the
 *                                                intake worker entered should stay as is.  We have
 *                                                cint17d.pc in cint30s with cint76d.pc and modified cint14d.pc
 *                                                in cint06s.src.
 *                          07/13/04 dejuanr      SIR 23001 - I added some excpetion handling for wtc exceptions
 *                                                for when a intake does not exist.
 *                          09/09/04 dejuanr      SIR 23110 - Set a flag into state to tell the intake that
 *                                                it is coming from the ereport request page.
 *                          07/20/05 ochumd       Sir 23720 - A check box and a comments box were added to the
 *                                                Special Handling Section on the Intake Actions page to track
 *                                                Methamphetamine cases.  Those new fields were populated here.
 *                          07/24/05 werlem       SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *                          03/20/08 schoi        STGAP00005751: Added a variable and an If condition 
 *                                                that holds the Approved status in displayAllegationDetail_xa method. 
 *			    04/14/08 schoi        STGAP00008020 - Added validations in saveAndSubmitIntake_xa and
 *		                                  submitApproval_xa. If the User attempts to Save and Submit 
 *			                          Intake Actions when a Non-Incident Request is selected and
 *						  any Allegations have been saved, the system generates error messages.
 *                         06/12/2008 vdevarak    STGAP00009181: Modified code to add functionality for MR-011
 *                         08/29/2008 arege       STGAP00009889: Added if(hasStageAccess) because the following message 
 *                                                should not be displayed for someone who does not have modify access to this
 *                                                page and thus he will never be able to modify this page.
 *                         01/05/2009 arege       STGAP00009957: Added function IfNoAllegationOrAllegationTypeOther to check if 
 *                                                there are no allegations or if there is an allegation of type 'OTHER'
 *                                                Modified code so that the Special Circumstances determination factors are not
 *                                                saved if the above function returns false. Modified populateCallDcsnAUDIn()
 *                         01/28/2009  arege      STGAP00009957: Changed the name of the method IfNoAllegationOrAllegationTypeOther
 *                                                to isNoAllegationOrAllegationTypeOther as per peer review.    
 *                         05/06/2009  cwells     STGAP00013218 - Changed the code to make the allegation warnings back to allegation errors.
 *                         09/17/2009  bgehlot    STGAP00015386: If INT stage is closed set the attribute to true so that Ralationship field on Allegation
 *                                                Detail is not displayed.
 *                         05/26/2010  hjbaptiste SMS#51977-MR66-Maltreatment In Care: Added additional field to indicate that Maltreatment took
 *                                                place while the child was/is in DFCS custody. Also check to see if any of the allegation's location of 
 *                                                maltreatment is candidate to require a special investigation call type and/or a selection for 
 *                                                placement/non-placement provider section. This check will only happen if there are'nt any errorlist errors
 *                         06/29/2010  hnguyen    SMS#59958: Save facility info into state upon display of page.
 *                         06/30/2010  hnguyen    SMS#59535: Save callEntryRtrvOut into request for page to display Call Decision after receiving 
 *                                                and responding to maltreatment-in-care warning confirmation                                         
 *                         06/30/2010  bgehlot    SMS# 60651 End dated the CD, SI and NF code and created CDNC, SINC and NFNC codes. Replaced the old ones with new ones.
 *                         08/18/2010  bgehlot    SMS 66380 MR-072 Changes
 *                         06/12/2011  llokhande  CAPTA 4.3 added policy violation radio button logic for save and retrieve.
 *                         07/08/2011  hjbaptiste SMS#114497: CAPTA 4.3 Removed all logic to set indicator to show pop-up for message surrounding 
 *                                                'Where did the Maltreatment in Care....'
 *                         07/11/2011  hjbaptiste SMS#114497: CAPTA 4.3 Put back all logic to set indicator to show pop-up for message surrounding 
 *                                                'Where did the Maltreatment in Care....'
 *                         01/20/2012  habraham    STGAP00017829 - MR-097 : Unsubstantiated MIC - The method signature for the checkIfMaltreatmentInCare 
 *                         						   to the Common bean has changed
 *                         03/05/12    vcollooru   STGAP00017922: Modified to change the text of the task of an intake submitted with the 
 *                                                                Special Investigation type of Near Fatality.
 *                                                                
 * </pre>
 */
public class IntakeActionsConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "IntakeActionsConversation";
  
  public static final String INDICATOR_YES = ArchitectureConstants.Y;

  private static final String GENERAL_FAILURE_STRING = "General Failure:";

  private static final String ERROR_STRING = "error";
  
  private static final String WARN_STRING = "warn";

  private static final String ALLEGLISTARRAY_STRING = "allegListArray";

  private static final String NMSTAGE_STRING = "hdnCaseName";

  private static final String SCREEN_OUT_NO_MALTREATMENT_CODE = "SNM";

  private static final String SCREEN_OUT_DISP_CODE = "SCO";

  private static final String SCREEN_OUT_REF_DISP_CODE = "SCR";

  private static final String NO_MALTREATMENT_SCREEN_OUT_REASON = "NMA"; 	     

  private static final String SHORT_TER_EMER_CARE_CODE = CodesTables.COTHER_OECC;
  
  public static final String DISPLAY_URI = "/intake/IntakeActions/displayIntakeActions";
  
  public static final String VALIDATE_SUCCESS = INDICATOR_YES;
  
  public static final String STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;
  
  public static final String INTAKE_ACTION = "Intake Action";

  private Intake intake1;

  private Common common;
  
  private Person person;

  public void setIntake(Intake intake1) {
    this.intake1 = intake1;
  }

  public void setCommon(Common common) {
    this.common = common;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
  private static final Set<String> LOC_OF_MALTREATMENT_CODES = new HashSet<String>() {
    {
      add(CodesTables.CLOCMAL_018); // -- F/A Home-DFCS
      add(CodesTables.CLOCMAL_019); // -- F/A Home-Non DFCS (CPA)
      add(CodesTables.CLOCMAL_009); // -- Other Institution (School)
      add(CodesTables.CLOCMAL_020); // -- Residential Facility (CCI)
      add(CodesTables.CLOCMAL_012); // -- Relative Placement Home (Not Relative F/A Home)
      add(CodesTables.CLOCMAL_013); // -- Non-Residential Facility (Includes Daycare)
      add(CodesTables.CLOCMAL_014); // -- Granny House
      add(CodesTables.CLOCMAL_015); // -- Military Base
      add(CodesTables.CLOCMAL_016); // -- Non-Relative Placement Home (Not F/A Home)
    }
  };
  
  //STGAP00009181 - Added this inner class to enable the return of more
  //than one variables from the function - lastAllegOfTypeCheck
  private static class LasAllegOfTypeVariables{
    private int count =0;
    private String allegationType = "";
    private boolean allegIndicator = false;
   
    public int getCount() {
      return count;
    }
    public void setCount(int count) {
      this.count = count;
    }
    public String getAllegationType() {
      return allegationType;
    }
    public void setAllegationType(String allegationType) {
      this.allegationType = allegationType;
    }
    public boolean isAllegIndicator() {
      return allegIndicator;
    }
    
    public void setAllegIndicator(boolean allegIndicator) {
      this.allegIndicator = allegIndicator;
    }
}

  /**
   * <p/> This method is called when the user selects the Intake Actions second level tab.
   * </p>
   * <p/> The following services are called: <blockquote>
   * <ul>
   * <li>CINT30S - Allegation List Retrieve</li>
   * <li>CINT25S - Call Decision/ Call Entry Retrieve</li>
   * <li>CINT26S - Person List Retrieve</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayIntakeActions_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayIntakeActions_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // JMC - SIR 17855 - In order for the metaphor to work correctly when
      // navigating from Approval To Do's we have to clear out the szCdTask that
      // is put into GlobalData.
      GlobalData.setSzCdTask(null, request);

      // If the CdStage that is set into Global Data is equal to INV that means
      // we are in the context of an Investigation Stage and therefore the UlIdStage in
      // Global Data is not the actual UlIdStage we need to retrieve the Intake. We use
      // the IntakeUtils.getPriorIntakeStageId() method to retrieve the previous
      // INT stage id.
      String stageCd = GlobalData.getSzCdStage(request);
      if (CodesTables.CSTAGES_INV.equals(stageCd) || CodesTables.CSTAGES_DIV.equals(stageCd)) {
        int stageId = IntakeUtils.getPriorIntakeStageId(context, common);
        GlobalData.setUlIdStage(stageId, request);
        GlobalData.setSzCdStage(CodesTables.CSTAGES_INT, request);
      }
      // If the Intake Report Log page calls displayIntakeActions()
      // through a Intake Report Log Search List Reporter hyperlink...
      if (ArchitectureConstants.Y
                                 .equals(ContextHelper
                                                      .getStringSafe(request, "displayIntakeActionsFromIntakeReportLog"))
          || ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "displayIntakeActionsFAHomeSearch"))
          || ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "displayIntakeActionsFromResourceSearchResults")))

      {
        int stageId = ContextHelper.getIntSafe(request, "stageId");
        GlobalData.setUlIdStage(stageId, request);
      }
      // In Intake, if we are navigating between any of the second level tabs, we want to automatically
      // save the previous page if any changes were made (excluding Call Log).
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "hdnSaveCallInformation"))
          && (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "hdnIsCallInfoDirty")))) {
        CallInformationConversation.saveCallInformation(context, intake1);
      }
      CaseUtility.Event e = CaseUtility.getIntakeCallEvent(GlobalData.getUlIdStage(request), "1000", "CAL");
      String eventStatus = e.getCdEventStatus();
      int eventId = e.getIdEvent();
         if(STATUS_PENDING.equals(eventStatus) || STATUS_COMPLETE.equals(eventStatus) || 
        		 STATUS_APPROVED.equals(eventStatus)){
        	/* ApproversRetrieveSO so = null;
             ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
             so = common.retrieveApprovers(si);
             if(so.hasCurrentActiveApprover()){
                 int userId = UserProfileHelper.getGlobalDataUserId(request);
                 if(userId == so.getCurrentActiveApprover().getIdPerson()){*/
                	 state.setAttribute("showMRLetter", true, request);
                 /*}
                 else{
                	 state.setAttribute("showMRLetter", false, request);
                 }
                 
             }*/
         }
      displayIntakeActions(context);

      // SIR 23110 Start
      Boolean validateEReport = (Boolean) state.getAttribute("validateEReport", request);
      if (validateEReport == null) {
        state.setAttribute("validateEReport", request.getAttribute("validate"), request);
      }
      // SIR 23110 End
      // INTAKE/EREPORT PROJECT
    } catch (ServiceException we) {
      // SIR 23001 start
      switch (we.getErrorCode()) {
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_NO_ROWS_RETURNED:
        displayMessagePage(Messages.MSG_PAPER_INTAKE, context);
        break;
      case Messages.MSG_INV_NO_EXISTS:
        displayMessagePage(Messages.MSG_INV_NO_EXISTS, context);
        break;
      default:
        setErrorMessage(we.getErrorCode(), request);
      }
      // SIR 23001 end
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
      return;
    }

    performanceTrace.exitScope();
    return;
  }

  /**
   * <p/> This method is called when the user selects the Save button on the Intake Actions page. The
   * saveIntakeActions() submethod is called and then the displayIntakeActions() method is called.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveIntakeActions_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveIntakeActions_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      saveIntakeActions(context, intake1);

       displayIntakeActions(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This method automatically saves the Intake Actions page and displays the Allegation Detail page.
   * </p>
   * <p/> The following services are called: <blockquote>
   * <ul>
   * <li>CINT14S - Call Decision AUD</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayAllegationDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayAllegationDetail_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String pageMode = PageMode.getPageMode(request);
    // SIR 22616 -- Put Classification into State so Allegation Detail can filter
    // on it.
    state.setAttribute("selSzCdStageClassification",
                       ContextHelper.getStringSafe(request, "selSzCdStageClassification"), request);

    try {
      // Save Intake Actions before proceeding to the Allegation Detail page.
    	if (!PageModeConstants.VIEW.equals(pageMode))
    		saveIntakeActions(context, intake1);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
      return;
    }

    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute(ALLEGLISTARRAY_STRING, request);
    if (allegListArray == null) {
      allegListArray = new ROWCINT76DO_ARRAY();
    }
    ROWCINT76DO allegListRow = new ROWCINT76DO();

    // Situation 1: The user clicked the Add button.
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnAdd.x"))) {
      allegListRow = new ROWCINT76DO();
    }
    // Situation 2: The user clicked the New Using button.
    else if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsingAlleg.x"))) {
      int index = ContextHelper.getIntSafe(request, "rbAllegList");
      ROWCINT76DO oldRow = null;
      if (index < allegListArray.getROWCINT76DOCount()) {
        oldRow = allegListArray.getROWCINT76DO(index);
      }
      if (oldRow == null) {
        oldRow = new ROWCINT76DO();
      }
      allegListRow.setSzCdIntakeAllegType(oldRow.getSzCdIntakeAllegType());
      allegListRow.setUlIdAllegedPerpetrator(oldRow.getUlIdAllegedPerpetrator());
      allegListRow.setUlIdVictim(oldRow.getUlIdVictim());
      // ochumd sir22934 Added Names of victim and perpetrator
      allegListRow.setSzScrAllegPerp(oldRow.getSzScrAllegPerp());
      allegListRow.setSzScrPersVictim(oldRow.getSzScrPersVictim());
      allegListRow.setSzCdAllegedMalLocation(oldRow.getSzCdAllegedMalLocation());
      allegListRow.setSzCdIntakeAllegMalCode(oldRow.getSzCdIntakeAllegMalCode());
      allegListRow.setCIndIncmgMaltreatInCare(oldRow.getCIndIncmgMaltreatInCare());
      allegListRow.setDtDtAllegedIncident(oldRow.getDtDtAllegedIncident());
      allegListRow.setSzCdMaltreatorRel(oldRow.getSzCdMaltreatorRel());
    }
    // Situation 3: The user clicked a hyperlink.
    else {
      int index = ContextHelper.getIntSafe(request, "hdnIndex");
      allegListRow = allegListArray.getROWCINT76DO(index);
    }

    request.setAttribute("allegListRow", allegListRow);
    
    //STGAP00015386: If INT stage is closed set the attribute to true so that Ralationship field on Allegation
    //Detail is not displayed.
    Stage stageClosed = CaseUtility.getStage(GlobalData.getUlIdStage(request));
    if(stageClosed != null){
      if(stageClosed.getDtClose() != null){
        request.setAttribute("INTStageClosed", "true");
      }
    }
    performanceTrace.exitScope();
  }

  /**
   * <p/> This method deletes an Allegation from the Intake Stage. The user can call this method in two ways:
   * </p>
   * <blockquote>
   * <ol>
   * <li>By clicking the Delete button from the Allegation List on Intake Actions.</li>
   * <li>By clicking the Delete button from the Allegation Detail page on Allegation Detail.</li>
   * </ol>
   * </blockquote> <p/> <p/> The following services are called: <blockquote>
   * <ul>
   * <li>CINT14S - Call Decision AUD</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void deleteAllegation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteAllegation_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String hdnIndDelAlleg = ContextHelper.getStringSafe(request, "hdnIndDelAlleg");
    int index = ContextHelper.getIntSafe(request, "rbAllegList");
    boolean indBtnDel = StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDeleteFromList.x"));
    if(ArchitectureConstants.N.equals(hdnIndDelAlleg)){
      indBtnDel = true;
    }
    try {
      //STGAP00009181: Added code to check if the allegation being deleted
      //is the last one of that type and if so to give the user a confirmational
      //message
      if (indBtnDel) {
        LasAllegOfTypeVariables lasAllegOfTypeVariables = null;
        lasAllegOfTypeVariables = lastAllegOfTypeCheck(context);
        boolean allegIndicator = lasAllegOfTypeVariables.isAllegIndicator();
        //The hiddden field is set to 'N' once the user confirms the deletion
        //and checked here to avoid going in loops
        if(allegIndicator && !ArchitectureConstants.N.equals(hdnIndDelAlleg)){
          throw new ServiceException(Messages.MSG_ALLEG_DEL_CNFRM);
        }
        //Clearing the object to avoid any lingering values
        request.setAttribute("hdnIndDelAlleg", "");
        if (ContextHelper.getBooleanSafe(request, "hdnIsIntakeActionsDirty")) {
          // Save Intake Actions before deleting the Allegation from the List.
          // DO NOT CALL THE SAVE UNLESS YOU ARE DELETING FROM THE LIST!
          CallDcsnAUDIn callDcsnAUDIn = populateCallDcsnAUDIn(context);
          // WtcHelper.callService("CINT14S", callDcsnAUDIn);
          intake1.saveCallDecision(callDcsnAUDIn);

          setPriorityChangeIndicator(context);
        }

        ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute(ALLEGLISTARRAY_STRING, request);
        if (allegListArray == null) {
          allegListArray = new ROWCINT76DO_ARRAY();
        }
        //STGAP00009181: If the allegation is the last one of that type 
        // when the user clicks the delete button the control goes back to
        //the jsp to display the pop up message. If the user confirms deletion
        //the index of the selected allegation is set into a hidden field to preserve 
        if(allegIndicator && ArchitectureConstants.N.equals(hdnIndDelAlleg)){
          index = (Integer.valueOf(ContextHelper.getStringSafe(request, "hdnIndRdBtn"))).intValue();
        }
        ROWCINT76DO allegToDelete = allegListArray.getROWCINT76DO(index);
        request.setAttribute("allegToDelete", allegToDelete);
      }

      allegation_AUD(context);
      displayIntakeActions(context);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      //STGAP00009181: If the confirm delete allegation is thrown than 
      //the request values are set to indicate that so that the confirmation
      //message can be displayed
      case Messages.MSG_ALLEG_DEL_CNFRM:
        setPresentationBranch(ERROR_STRING, context);
        request.setAttribute("rbAllegList", index);
        request.setAttribute("hdnIndDelAlleg", ArchitectureConstants.Y);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(context.getRequest(), true);
        break;
      default:
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This method save an allegation to the Allegation List and reloads the Allegation Detail page so the user can
   * enter a new Allegation.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveAndAddAllegation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndAddAllegation_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      allegation_AUD(context);
      state.removeAttribute("warnMaltreatmentInCare", request);
      state.removeAttribute("indMaltreatInCare", request);
      
      IntakeDataBean intakeDataBean = PopulateDataBean.populate(context, intake1);

      ROWCINT76DO_ARRAY allegListArray = intakeDataBean.getAllegListArray();
      state.setAttribute(ALLEGLISTARRAY_STRING, allegListArray, request);

      ROWCINT76DO allegListRow = new ROWCINT76DO();

      // The Maltreatment Code needs to be stored in place of the code value associated with ethe Maltreatment Typ
      
      String selSzCdIntakeAllegType = ContextHelper.getStringSafe(request, "selSzCdIntakeAllegType");
      String selSzCdIntakeAllegMalCode = ContextHelper.getStringSafe(request, "selSzCdIntakeAllegMalCode");
      allegListRow.setSzCdIntakeAllegType(selSzCdIntakeAllegType);
      String selSzCdAllegedMalLocation = ContextHelper.getStringSafe(request, "selSzCdAllegedMalLocation");
      allegListRow.setSzCdAllegedMalLocation(selSzCdAllegedMalLocation);
      allegListRow.setDtDtAllegedIncident(ContextHelper.getCastorDateSafe(request, "selDtDtAllegedIncident"));
      allegListRow.setSzCdIntakeAllegMalCode(selSzCdIntakeAllegMalCode);
      allegListRow.setSzCdMaltreatorRel(ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel"));
      allegListRow.setCIndIncmgMaltreatInCare(ContextHelper.getStringSafe(request, "hdnIndIncmgMaltreatInCare"));
      // ochumd sir 22934 - Split value of perpetrator name gotten from JSP to obtain person name and person id
      String namePerpetratorAndId = ContextHelper.getStringSafe(request, "selUlIdAllegedPerpetrator");
      if (StringHelper.isValid(namePerpetratorAndId)) {
        allegListRow.setSzScrAllegPerp(namePerpetratorAndId.substring(0, namePerpetratorAndId.indexOf("|")));
        String idPerpetratorString = namePerpetratorAndId.substring(namePerpetratorAndId.indexOf("|") + 1,
                                                                    namePerpetratorAndId.length());
        if (idPerpetratorString.length() > 0) {
          int id = Integer.parseInt(idPerpetratorString);
          allegListRow.setUlIdAllegedPerpetrator(id);
        }
      }
      // ochumd sir 22934 - Split value of victim name gotten from JSP to obtain person name and person id
      String nameVictimAndId = ContextHelper.getStringSafe(request, "selUlIdVictim");
      if (StringHelper.isValid(nameVictimAndId)) {
        allegListRow.setSzScrPersVictim(nameVictimAndId.substring(0, nameVictimAndId.indexOf("|")));
        String idVictimString = nameVictimAndId.substring(nameVictimAndId.indexOf("|") + 1, nameVictimAndId.length());
        if (idVictimString.length() > 0) {
          int id = Integer.parseInt(idVictimString);
          allegListRow.setUlIdVictim(id);
        }
      }
      // JMC - SIR 19113 - Added message so alleviate user confusion.
      setInformationalMessage(Messages.MSG_INT_ALLG_ADD, request);

      request.setAttribute("allegListRow", allegListRow);
    } catch (ServiceException we) {
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This method saves an allegation and continues to the Intake Actions page.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveAndContinueAllegation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndContinueAllegation_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      allegation_AUD(context);
      state.removeAttribute("warnMaltreatmentInCare", request);
      state.removeAttribute("indMaltreatInCare", request);
      displayIntakeActions(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Save and Submit button on the Intake Actions page. It will Save the
   * Intake Actions page, validate the Intake calling the createErrorList() submethod, and then call the CINT02S AUD
   * service passing in cReqFuncCd == WtcHelper.REQ_FUNC_CD_SAVE_AND_SUBMIT. <p/> <p/> The following services are
   * called: <blockquote>
   * <ul>
   * <li>CINT25S - Call Decision/Call Entry Retrieve</li>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void saveAndSubmitIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndSubmitIntake()");
    boolean bAllegationsExists = false;
    
    int allegationRows = 0;
    
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      // Save the current data on Intake Actions.
      saveIntakeActions(context, intake1);

      // Populate the IntakeDataBean and pass it to the CreateErrorList.create() method.
      IntakeDataBean intake = PopulateDataBean.populate(context, intake1);
      // STGAP00009181: Added this call to throw the person search required message
      checkPersonSearch(intake);
      allegationRows = intake.getAllegListArray().getROWCINT76DOCount();      
      

      int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.SUBMIT_BUTTON);
      
      // Process the error list if any errors returned.
      if (errorArray.length > 0) {
        setPresentationBranch(ERROR_STRING, context);
        ErrorList.setErrors(errorArray, request);
        request.setAttribute("warnSpclInvPlcmtProvider", ArchitectureConstants.N);
        request.setAttribute("warnRecordsCheckNotCompleted", ArchitectureConstants.N);
        return;
      } 
      // If there aren't any errors to display on the error list page, warn that a special investigation and/or 
      // a placement/non-placement provider may be required based on specific selections for where the maltreatment 
      // occurred for any of the allegations
      else {
        String specInvest = ContextHelper.getStringSafe(request, "hdnSzCdSplInvest");
        ROWCINT76DO_ARRAY allegListArray = intake.getAllegListArray();
        // Check to see if there are any allegations logged and that user has not yet confirmed (meaning the save and
        // submit button was clicked)
        if (allegListArray != null) {
          if (!ArchitectureConstants.Y
                                      .equals(ContextHelper.getStringSafe(request, "hdnSpclInvPlcmntProviderConfirmed"))
              && !StringHelper.isValid(specInvest)) {
            boolean isDFCSLocOfMaltreatment = false;
            ROWCINT76DO allegListRow = null;
            Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();
            while (allegListEnum.hasMoreElements()) {
              allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
              String locOfMaltreatment = allegListRow.getSzCdAllegedMalLocation();
              if (LOC_OF_MALTREATMENT_CODES.contains(locOfMaltreatment)) {
                isDFCSLocOfMaltreatment = true;
                break;
              }
            }
            if (isDFCSLocOfMaltreatment) {
              request.setAttribute("warnSpclInvPlcmtProvider", ArchitectureConstants.Y);
              ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
              setPresentationBranch(WARN_STRING, context);
              return;
            }
          }
        }
        
        //MR-072 Check to see if Records check are completed for all the persons in the stage
        CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI = new CheckIfRecordsCheckCompletedSI();
        checkIfRecordsCheckCompletedSI.setIdStage(GlobalData.getUlIdStage(request));
        checkIfRecordsCheckCompletedSI.setPageName(INTAKE_ACTION);
        String recordsCheckCompleted = person.checkIfRecordsCheckCompleted(checkIfRecordsCheckCompletedSI);
        if(!ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnRecordsCheckCompletedConfirmed")) && 
                                ArchitectureConstants.FALSE.equals(recordsCheckCompleted)){
          request.setAttribute("warnRecordsCheckNotCompleted", ArchitectureConstants.Y);
          ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
          setPresentationBranch(WARN_STRING, context);
          return;
        }
      }
      request.setAttribute("hdnBIndValidate", VALIDATE_SUCCESS);
      CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
      if (callEntryRtrvOut == null) {
        callEntryRtrvOut = new CallEntryRtrvOut();
      }

      CallEntryAUDInRec callEntryAUDInRec = PopulateCallEntryAUDInRec
                                                                     .populate(
                                                                               context,
                                                                               callEntryRtrvOut,
                                                                               ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT);

      // START POPULATE COUNTY - The following code pertains to setting the new county
      // into the input object for the cint12s save.
      CallEntrySvcStruct callEntrySvcStruct = callEntryAUDInRec.getCallEntrySvcStruct();
      CallDcsnAUD callDcsnAUD = callEntryRtrvOut.getCallDcsnAUD();
      if (callDcsnAUD == null) {
        callDcsnAUD = new CallDcsnAUD();
      }

      FacilRtrvOutRec facilRtrvOutRec = intake.getFacility();
      if (facilRtrvOutRec == null) {
        facilRtrvOutRec = new FacilRtrvOutRec();
      }

      gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facDetailEntStruct = facilRtrvOutRec
                                                                                                        .getFacDetailEntStruct();

      if (facDetailEntStruct == null) {
        facDetailEntStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
      }

      String county = IntakeUtils.chooseCountyForAssignment(context, callDcsnAUD.getSzCdStageClassification(),
                                                            callEntrySvcStruct.getSzCdIncomingDisposition(),
                                                            facDetailEntStruct.getSzCdIncmgFacilCnty(),
                                                            callEntrySvcStruct.getSzCdIncomingCallerCounty(),
                                                            intake.getPersonlistarray());

      callEntrySvcStruct.setSzCdStageCnty(county);
      String region = FormattingHelper.convertRegionCode(Lookup.simpleDecodeSafe("CCNTYREG", county));
      callEntrySvcStruct.setSzCdStageRegion(region);
      callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);
      // END POPULATE COUNTY
      
      // STGAP00008020
      // Validation for Allegation if it is a Non Incident Request
      String cdNonIncReqType = callEntrySvcStruct.getSzCdNonRsdntReqType();
      
      allegationRows = intake.getAllegListArray().getROWCINT76DOCount();      
      bAllegationsExists = (allegationRows > 0) ? true : false;      
      if (bAllegationsExists && StringHelper.isValid(cdNonIncReqType)){
    	  setPresentationBranch(ERROR_STRING, context);
          setErrorMessage(Messages.MSG_INT_SAVE_NI_ALLEGS, request);
          displayIntakeActions(context);
          return;
          }
      // STGAP00008020

      CallEntryAUDOutRec callEntryAUDOutRec = PopulateDataBean.callCINT12S(callEntryAUDInRec, intake1);

      CreateCallOutStruct out = callEntryAUDOutRec.getCreateCallOutStruct();

      ToDoDetailDB toDoDetailDB = null;
      if ((CodesTables.CSPECREQ_CDNC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()) || CodesTables.CSPECREQ_CDIC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()))) {
        toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                        IntakeConstants.APPROVE_CALL_CD_TASK_CHILD_DEATH);
      } else if ((CodesTables.CSPECREQ_SINC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()) || CodesTables.CSPECREQ_SIIC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()))) {

        toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                        IntakeConstants.APPROVE_CALL_CD_TASK_SERIOUS_INJURY);

      } else if ((CodesTables.CSPECREQ_NFNC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()) || CodesTables.CSPECREQ_NFIC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()))) {
        // STGAP00017922: Executed for an Intake with the Special Investigation type of Near Fatality  
        toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                        IntakeConstants.APPROVE_CALL_CD_TASK_NEAR_FATALITY);

      } else {
        toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                        IntakeConstants.APPROVE_CALL_CD_TASK);

      }

      // toDoDetailDB.setSzTxtTodoDesc(IntakeConstants.INT_RPT_SUBMIT_REVIEW_APPRVL);

      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

      // The last thing we want to do before leaving this conversation is clear the async person
      // search results out of session.
      IntakeUtils.clearAsynchInfoFromSession(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Approval Status button on the Intake Actions page. If the Intake
   * Incoming status is not CLD and the Event Status is not already APRV, we will call the saveIntakeActions() helper
   * method and then use the CreateErrorList class to validate the intake for submittal. If the Intake passes the final
   * edits, we are forwarded to the Approval Status page.
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");

    // STGAP00008020
    boolean bAllegationsExists = false;    
    int allegationRows = 0;
    // STGAP00008020
    
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    try {
      // Call the cint25s service to retrieve the Intake Incoming Status and the evnt status.
      // If the Intake Incoming Status is CLD or if the event status is already APRV
      // we do not want to call any of submittal services.
      CallEntryRtrvOut tempCallEntryRtrvOut = null;
      gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct tempCallEntryData = null;
      PopulateDataBean.populateCallEntryRtrvIn_Retrieve(context);
      tempCallEntryRtrvOut = PopulateDataBean.callCINT25S(context, intake1);
      if (tempCallEntryRtrvOut == null) {
        tempCallEntryRtrvOut = new CallEntryRtrvOut();
      }
      tempCallEntryData = tempCallEntryRtrvOut.getCallEntrySvcStruct();
      if (tempCallEntryData == null) {
        tempCallEntryData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
      }

      String incomingStatus = FormattingHelper.formatString(tempCallEntryData.getCdIncmgStatus());
      String eventStatus = FormattingHelper.formatString(tempCallEntryRtrvOut.getSzCdEventStatus());

      if (!CodesTables.CINCMGST_CLD.equals(incomingStatus) && !CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
        // Save the current data on Intake Actions.
        saveIntakeActions(context, intake1);
        IntakeDataBean intake = PopulateDataBean.populate(context, intake1);
        //STGAP00009181: Added this call to throw the person search required message
        checkPersonSearch(intake);
        // START POPULATE COUNTY - The following code pertains to setting the new county
        // into the input object for the cint12s save.

        CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
        if (callEntryRtrvOut == null) {
          callEntryRtrvOut = new CallEntryRtrvOut();
        }
        request.setAttribute("CallEntryRtrvOut", callEntryRtrvOut);
        
        // JMC - Modified what we send in for the reqFuncCd because when we pass
        // in SAVE_AND_SUBMIT the incoming status gets set to SBA, but when we pass
        // in SAVE_AND_ASSIGN the incoming status gets set to CLD.
        CallEntryAUDInRec callEntryAUDInRec = PopulateCallEntryAUDInRec
                                                                       .populate(
                                                                                 context,
                                                                                 callEntryRtrvOut,
                                                                                 ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT);

        CallEntrySvcStruct callEntrySvcStruct = callEntryAUDInRec.getCallEntrySvcStruct();
        CallDcsnAUD callDcsnAUD = callEntryRtrvOut.getCallDcsnAUD();
        if (callDcsnAUD == null) {
          callDcsnAUD = new CallDcsnAUD();
        }

        FacilRtrvOutRec facilRtrvOutRec = intake.getFacility();
        if (facilRtrvOutRec == null) {
          facilRtrvOutRec = new FacilRtrvOutRec();
        }

        gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facDetailEntStruct = facilRtrvOutRec
                                                                                                          .getFacDetailEntStruct();

        if (facDetailEntStruct == null) {
          facDetailEntStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
        }

        String county = IntakeUtils.chooseCountyForAssignment(context, callDcsnAUD.getSzCdStageClassification(),
                                                              callEntrySvcStruct.getSzCdIncomingDisposition(),
                                                              facDetailEntStruct.getSzCdIncmgFacilCnty(),
                                                              callEntrySvcStruct.getSzCdIncomingCallerCounty(),
                                                              intake.getPersonlistarray());

        request.setAttribute("county", county);

        // STGAP00008020
        // Validation for Allegation if it is a Non-Incident Request
        String cdNonIncReqType = callEntrySvcStruct.getSzCdNonRsdntReqType();
        
        allegationRows = intake.getAllegListArray().getROWCINT76DOCount();      
        bAllegationsExists = (allegationRows > 0) ? true : false;      
        if (bAllegationsExists && StringHelper.isValid(cdNonIncReqType) && (GlobalData.isApprovalMode(request))){
        	setPresentationBranch(ERROR_STRING, context);
            setErrorMessage(Messages.MSG_INT_SAVE_NI_ALLEGS, request);
            displayIntakeActions(context);
            return;
            }
        // STGAP00008020
        
        saveIntakeActions(context, intake1);
        int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.SUBMIT_BUTTON);
        int count = errorArray.length;
        if (count > 0) {
          setPresentationBranch(ERROR_STRING, context);
          ErrorList.setErrors(errorArray, request);
          displayIntakeActions(context);
          return;
        } // If there aren't any errors to display on the error list page, warn that a special investigation and/or 
        // a placement/non-placement provider may be required based on specific selections for where the maltreatment 
        // occurred for any of the allegations
        else {
          String specInvest = ContextHelper.getStringSafe(request, "hdnSzCdSplInvest");
          ROWCINT76DO_ARRAY allegListArray = intake.getAllegListArray();
          // Check to see if there are any allegations logged and that user has not yet confirmed (meaning the save and
          // submit button was clicked)
          if (allegListArray != null) {
            if (!ArchitectureConstants.Y
                                        .equals(ContextHelper.getStringSafe(request, "hdnSpclInvPlcmntProviderConfirmed"))
                && !StringHelper.isValid(specInvest)) {
              boolean isDFCSLocOfMaltreatment = false;
              ROWCINT76DO allegListRow = null;
              Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();
              while (allegListEnum.hasMoreElements()) {
                allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
                String locOfMaltreatment = allegListRow.getSzCdAllegedMalLocation();
                if (LOC_OF_MALTREATMENT_CODES.contains(locOfMaltreatment)) {
                  isDFCSLocOfMaltreatment = true;
                  break;
                }
              }
              if (isDFCSLocOfMaltreatment) {
                request.setAttribute("warnSpclInvPlcmtProvider", ArchitectureConstants.Y);
                ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
                setPresentationBranch(WARN_STRING, context);
                return;
              }
            }
          }
        }
      }
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Save and Assign button on the Intake Actions page. It will Save the
   * Intake Actions page, validate the Intake calling the createErrorList() submethod, and then call the CINT02S AUD
   * service passing in cReqFuncCd == WtcHelper.REQ_FUNC_CD_SAVE_AND_ASSIGN. <p/> <p/> The following services are
   * called: <blockquote>
   * <ul>
   * <li>CINT25S - Call Decision/Call Entry Retrieve</li>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void saveAndAssignIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndAssignIntake_xa()");

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    try {
      // Save the current data on Intake Actions.
      saveIntakeActions(context, intake1);

      // Populate the IntakeDataBean and pass it to the CreateErrorList.create() method.
      IntakeDataBean intake = PopulateDataBean.populate(context, intake1);
      int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.ASSIGN_BUTTON);

      // Process the error list is any errors returned.
      if (errorArray.length > 0) {
        setPresentationBranch(ERROR_STRING, context);
        ErrorList.setErrors(errorArray, request);
        return;
      }
      assign(context, intake);

      // ***** send email here
      CallEntryAUDInRec callEntryAUDInRec = (CallEntryAUDInRec) request.getAttribute("callEntryAUDInRec");
      request.removeAttribute("callEntryAUDInRec");

      // The last thing we want to do before leaving this conversation is clear the async person
      // search results out of session.
      IntakeUtils.clearAsynchInfoFromSession(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the Approver clicks the Save and Assign button on the Intake Actions page. It will call
   * the assignIntake() helper method and take the user to the Assign page. <p/> <p/> The following services are called:
   * <blockquote>
   * <ul>
   * <li>CINT12S - Call Entry AUD - Save and Assign</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void assignIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".assignIntake_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      IntakeDataBean intake = PopulateDataBean.populate(context, intake1);
      assign(context, intake);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {

      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Delete button on the Intake Actions page. It will first save the
   * Intake Actions page, the call the retrieve for the call entry/call decision page and use this information to
   * popuate the cint12s input object. We will pass in the cReqFuncCd = REQ_FUNC_CD_DELETE <p/> <p/> The following
   * services are called: <blockquote>
   * <ul>
   * <li>CINT25S - Call Decision/Call Entry Retrieve</li>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void deleteIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteIntake_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      CallEntryRtrvOut callEntryRtrvOut = PopulateDataBean.callCINT25S(context, intake1);

      CallEntryAUDInRec callEntryAUDInRec = PopulateCallEntryAUDInRec.populate(context, callEntryRtrvOut,
                                                                               ServiceConstants.REQ_FUNC_CD_DELETE);

      // WtcHelper.callService("CINT12S", callEntryAUDInRec);
      intake1.saveCallEntry(callEntryAUDInRec);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Mark for Deletion button on the Intake Actions page. It will call
   * the retrieve for the call entry/call decision page and use this information to populate the cint12s input object.
   * We will pass in the cReqFuncCd = REQ_FUNC_CD_MARK_FOR_DELETE <p/> <p/> The following services are called:
   * <blockquote>
   * <ul>
   * <li>CINT25S - Call Decision/Call Entry Retrieve</li>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void markIntakeForDeletion_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".markIntakeForDeletion_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      saveIntakeActions(context, intake1);

      CallEntryRtrvOut callEntryRtrvOut = PopulateDataBean.callCINT25S(context, intake1);

      CallEntryAUDInRec callEntryAUDInRec = PopulateCallEntryAUDInRec
                                                                     .populate(
                                                                               context,
                                                                               callEntryRtrvOut,
                                                                               ServiceConstants.REQ_FUNC_CD_MARK_FOR_DELETE);

      // WtcHelper.callService("CINT12S", callEntryAUDInRec);
      intake1.saveCallEntry(callEntryAUDInRec);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This method is called when the user selects the Call Information second level tab.
   * </p>
   * <p/> The following services are called: <blockquote>
   * <ul>
   * <li>CINT30S - Allegation List Retrieve</li>
   * <li>CINT25S - Call Decision/ Call Entry Retrieve</li>
   * <li>CINT26S - Person List Retrieve</li>
   * <li>CINT27S - Facility Detail Retrieve</li>
   * <li>CINT22S - Intake Narrative Retrieve</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   * @throws LookupException
   */
  private void displayIntakeActions(GrndsExchangeContext context) throws LookupException, ServiceException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayIntakeActions()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    if (PageModeConstants.VIEW.equals(ContextHelper.getStringSafe(request, "intakeActionsPageMode"))) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    } else {
      PageMode.setPageMode(GlobalData.getAppMode(request), request);
    }

    IntakeDataBean intakeDataBean = PopulateDataBean.populate(context, intake1);

    ROWCINT76DO_ARRAY allegListArray = intakeDataBean.getAllegListArray();
    state.setAttribute(ALLEGLISTARRAY_STRING, allegListArray, request);
    
    // This section of code deals with populating the Descriptors in the Call Decision section.
    // Descriptors are filtered depending on what allegations are reported.
    populateCPSDescriptorsArray(context, allegListArray); // !!! does this handle an empty array?

    CallEntryRtrvOut callEntryRtrvOut = intakeDataBean.getCallEntryDecision();
    // request.setAttribute( "CallEntryRtrvOut", callEntryRtrvOut );

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntryData = callEntryRtrvOut
                                                                                                  .getCallEntrySvcStruct();

    if (callEntryData == null) {
      callEntryData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
    }

    // If we are navigating via Call Log the case id does not get set into Global Data
    // properly. We set the retrieved Case ID into Global Data to ensure that the Case ID
    // will display properly in the Call Summary section.
    GlobalData.setUlIdCase(callEntryData.getUlIdCase(), request);

    // In order for GlobalData.isApprovalMode() to work, we have to have ulIdEvent for the
    // Record Call event set into global data. If the intake has been Closed (if it has been
    // Saved and Assigned), the ulIdEvent is no longer retrieved by cint25s. (cint25s retrieves the
    // ulIdEvent from the Incoming Detail table, but it is nulled out after the intake is closed).
    // That's why we use the CaseUtility helper.
    int eventId = callEntryData.getUlIdEvent();
    CaseUtility.Event e = CaseUtility.getIntakeCallEvent(GlobalData.getUlIdStage(request), "1000", "CAL");
    eventId = e.getIdEvent();

    GlobalData.setUlIdEvent(eventId, request);

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD callDecisionData = callEntryRtrvOut.getCallDcsnAUD();

    if (callDecisionData == null) {
      callDecisionData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD();
    } 
    String classification = FormattingHelper.formatString(callDecisionData.getSzCdStageClassification());

    if (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "hdnChangeDisp"))
        && StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdDisp"))) {
      callDecisionData.setSzCdIncomingDisposition(ContextHelper.getStringSafe(request, "selSzCdDisp"));
    }
    // This section of code deals with populating the vector of selected Determination Factors. It sets
    // the populate/sorted vectors into the request for use on the Intake Actions page.
    populateDeterminationFactorsArrays(context, callEntryRtrvOut, classification);

    int idStage = GlobalData.getUlIdStage(request);
    int UserId = UserProfileHelper.getUserProfile(request).getUserID();
    boolean hasStageAccess = CaseUtility.hasStageAccess(UserId, idStage);
    
    // If the incoming status is EVER closed, we want to set the app mode to VIEW     
    String incomingStatus = FormattingHelper.formatString(callEntryData.getCdIncmgStatus());
    String eventStatus = FormattingHelper.formatString(callEntryRtrvOut.getSzCdEventStatus());
    if ((CodesTables.CINCMGST_CLD).equals(incomingStatus) || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
      GlobalData.setAppMode(PageModeConstants.VIEW, request);
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    } else if (!GlobalData.isApprovalMode(request) && PageModeConstants.EDIT.equals(GlobalData.getAppMode(request))
               && CodesTables.CINCMGST_SBA.equals(incomingStatus) && CodesTables.CEVTSTAT_PEND.equals(eventStatus)) {
      if (hasStageAccess) { 
        //arege Per STGAP00009889 Added this if(hasStageAccess) because the following message should not be displayed 
        //for someone who does not have modify access to this page and thus he will never be able to modify this 
        // page.
      setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);

      setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }
    }
    // FACILITY DETAIL RETRIEVE
    // We have to call the Facility Detail Retrieve in order to populate the "Case Name" drop down box
    // in the Call Decision portion of the page. If the user has entered anything for Facility Name this
    // should also be included in the Case Name list.

    String facilityName = "";
    FacilRtrvOutRec facilRtrvOutRec = intakeDataBean.getFacility();
    //capta 4.3 -  if placement found on Intake information page, take the record from state.
    String placementFound = (String)state.getAttribute("PlacementFoundForChild", request);
    gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facDetailEntStruct = null;
    if(facilRtrvOutRec != null && facilRtrvOutRec.getFacDetailEntStruct().getUlIdResource() == 0 &&
                    (placementFound != null && placementFound.equals("true")) ) {
      facilRtrvOutRec = (FacilRtrvOutRec)state.getAttribute("FacilRtrvOutRec", request);
    }

    if(facilRtrvOutRec != null) {
      state.setAttribute("FacilRtrvOutRec", facilRtrvOutRec, request);
      facDetailEntStruct = facilRtrvOutRec.getFacDetailEntStruct();
    }
    
    if (facDetailEntStruct == null) {
      facDetailEntStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
    }

    if (StringHelper.isValid(facDetailEntStruct.getNmIncmgFacilName())) {
      facilityName = facDetailEntStruct.getNmIncmgFacilName();
      // If we are in approval mode, we want to have access to the facility county at all
      // times since we will need it every single time we save. (it is used to determine
      // the StageCnty).
      if (GlobalData.isApprovalMode(request)) {
        state.setAttribute("facilityCounty", facDetailEntStruct.getSzCdIncmgFacilCnty(), request);
      }
    }
    // We have to call the Person List Retrieve in order to populate the "Case Name" drop down box
    // in the Call Decision portion of the page. Also, we will populate two vectors, the allegedVictimVector and
    // the allegedPerpVector for later use on the Intake Allegation Detail page.
    // This service call will also be in an embedded try catch
    // block because we have to catch the case where no persons are returned. Since this is an acceptable error,
    // we will simply ignore it.

    PersListRtrvStruct_ARRAY personListArray = intakeDataBean.getPersonlistarray();
    facilityName = facilityName != null ? facilityName : "";
    // This submethod uses the personListArray to build the Alleged Perp, Alleged Victim, and Case Name array's
    // and then set's then onto the state or request.
    /*
     * * ochumd Sir 22646 - Save caseName to be used as the selection in stage name drop down on JSP
     */
    String caseName = callEntryRtrvOut.getCallDcsnAUD().getSzNmStage();
    // ochumd Sir 22646 - caseName is returned with person's id appended to name
    populateAllegAndCaseNameVectors(context, personListArray, classification, facilityName, caseName); //
    // !!!
    // can
    // this
    // handle
    // empty
    // array?
    // ochumd sir 22646 - Overwrite the case name with the modified case name which has ID appended
    // CallDcsnAUD callDcsn = callEntryRtrvOut.getCallDcsnAUD();
    // callDcsn.setSzNmStage(caseName);
    // callEntryRtrvOut.setCallDcsnAUD(callDcsn);
    request.setAttribute("CallEntryRtrvOut", callEntryRtrvOut);
    request.setAttribute(IntakeConstants.NARRATIVE_EXISTS, ArchitectureConstants.N);
    if (intakeDataBean.hasCallNarr()) {
      request.setAttribute(IntakeConstants.NARRATIVE_EXISTS, ArchitectureConstants.Y);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This submethod saves an allegation.
   * </p>
   * <p/> <p/> The following services are called: <blockquote>
   * <ul>
   * <li>CINT06S- Allegation List AUD</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   * @throws ValidationException
   * @throws MarshalException
   */
  private void allegation_AUD(GrndsExchangeContext context) throws ServiceException, ValidationException,
                                                           MarshalException {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".allegation_AUD()");

    HttpServletRequest request = context.getRequest();

    // String incomingStatus = ContextHelper.getStringSafe(request, "hdnIncomingStatus");
    IntakeUtils.callCINT12SUpdateWorkload(context, intake1);
    String hdnIndDelAlleg = ContextHelper.getStringSafe(request, "hdnIndDelAlleg");
    boolean indBtnDel = StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDeleteFromList.x"));
    if(ArchitectureConstants.N.equals(hdnIndDelAlleg)){
      indBtnDel = true;
    }
    String reqFuncCd = "";
    if (indBtnDel) {
      reqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
    } else if (ContextHelper.getIntSafe(request, "hdnUlIdAllegation") == 0) {
      reqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    } else {
      reqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }

    AllegListAudInRec allegListAudInRec = populateAllegListAudInRec_AUD(context, reqFuncCd);
    // WtcHelper.callService("CINT06S", allegListAudInRec);
    intake1.saveAllegations(allegListAudInRec);

    performanceTrace.exitScope();
  }

  /**
   * <p/> This submethod saves the Intake Actions page. We must also call the CINT12S service since this service saves
   * the Stage Name(based on Case Name), Program (based on Primary Allegation), and Type (based on Classification) to
   * the Workload.
   * </p>
   * <p/> <p/> The following services are called: <blockquote>
   * <ul>
   * <li>CINT14S - Call Decision AUD</li>
   * <li>CINT12S - Call Entry AUD</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   *
   * @throws ValidationException
   * @throws MarshalException
   */
  public static void saveIntakeActions(GrndsExchangeContext context, Intake intake1) throws ServiceException,
                                                                                    MarshalException,
                                                                                    ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveIntakeActions()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // If this save was kicked off by the user clicking one of the Save && Whatever (including Save) Buttons
    // this means the user is exiting the Intake. We want to delete any person's that have not had a detail
    // page saved from the Call Person List. The reason for this is that in CAPS, if a person was not "made real"
    // they would simply "fall off of the Intake" when the Intake was exited. This is important because the
    // reporter and in re persons automatically get saved to the Call Person List. Instead of forcing
    // the user to delete these persons manually (for instance in an I&R where you can't have anyone on the
    // person list or if the reporter was a Law Enforcement officer), we can just auto-delete.
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSubmit.x"))
        || StringHelper.isValid(ContextHelper.getStringSafe(request, "btnAssign.x"))
        || StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSave.x"))) {
      try {
        CallInformationConversation.autoDeletePersonsOnSave(context, intake1);
        state.removeAttribute("PersListRtrvStruct_ARRAY", request);
      } catch (Exception ex) {
        // If the delete fails don't do anything. We don't want to ruin the
        // save just because the specified people did not "fall off" the
        // intake. Even though PMD will complain about this.
      }
    }

    GlobalData.setSzNmStage(ContextHelper.getStringSafe(request, NMSTAGE_STRING), request);

    // This service saves only the Call Decision portion of the page. This does not
    // update the workload with the new information entered in Call Decision. We
    // have to call CINT12S every time we save Intake Actions to make sure the workload
    // gets updated correctly.
    CallDcsnAUDIn callDcsnAUDIn = populateCallDcsnAUDIn(context);

    // WtcHelper.callService("CINT14S", callDcsnAUDIn);

    intake1.saveCallDecision(callDcsnAUDIn);

    setPriorityChangeIndicator(context);
    IntakeUtils.callCINT12SUpdateWorkload(context, intake1);

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user selects the Search button in Call Summary section of the Intake Actions page.
   * It will copy all the current data into an object and kick off a Resource Search.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void getFacilityResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".getFacilityResource_xa()");

    HttpServletRequest request = context.getRequest();
    ResourceSearchPullBackInfo resourceSearchData = new ResourceSearchPullBackInfo();
    try {
      // Save Intake Actions before proceeding to the Allegation Detail page.
      CallDcsnAUDIn callDcsnAUDIn = populateCallDcsnAUDIn(context);
      WtcHelper.callService("CINT14S", callDcsnAUDIn);

      resourceSearchData.setDestinationUrl("/intake/IntakeActions/setFacilityResource");
      resourceSearchData.setResourceType(CodesTables.CRSCTYPE_02);
      resourceSearchData.setResourceName(ContextHelper.getStringSafe(request, "txtSzNmJurisdiction"));
      resourceSearchData.setResourceStatus(IntakeConstants.ACTIVE);
      resourceSearchData.setLocationArea(IntakeConstants.LOCATION);
      // JMC - SIR 19630
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, NMSTAGE_STRING))) {
        resourceSearchData = setCaseNameStateCountyIntoResourceSearchData(context, resourceSearchData);
      }
      // END SIR 19630
      request.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceSearchData);

    } catch (ServiceException we) {
      // !!! need setPresentationBranch ???
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
      return;
    }

    performanceTrace.exitScope();
  }

  /**
   * This helper method will enumerate through the Person List until the person record is found who is designated as the
   * Case Name. It will then set the Zip and County of the person designated as the case name into the
   * ResourceSearchPullBackInfo object. <p/> This helper method added for SIR FIX 19630.
   * 
   * @param context
   *          the GrndsExchangeContext object
   * @param resourceSearchData
   *          ResourceSearchPullBackInfo
   * @return resourceSearchData
   * @throws Exception
   */
  private ResourceSearchPullBackInfo setCaseNameStateCountyIntoResourceSearchData(
                                                                                  GrndsExchangeContext context,
                                                                                  ResourceSearchPullBackInfo resourceSearchData)
                                                                                                                                throws Exception {

    String incomingStatus = ContextHelper.getStringSafe(context, "hdnIncomingStatus");
    Date callDisposedDt = ContextHelper.getJavaDateSafe(context, "hdnTsIncmgCallDisp");
    // ochumd sir 22646 - Get stage name from the JSP and rip off the ID that was appended to it
    String caseName = ContextHelper.getStringSafe(context, NMSTAGE_STRING);

    PersListRtrvStruct_ARRAY personListArray = new PersListRtrvStruct_ARRAY();
    try {
      gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec persListOutRec = PopulateDataBean
                                                                                                 .callCINT26S(
                                                                                                              context,
                                                                                                              incomingStatus,
                                                                                                              callDisposedDt,
                                                                                                              intake1);

      personListArray = persListOutRec.getPersListRtrvStruct_ARRAY();
      if (personListArray == null) {
        personListArray = new PersListRtrvStruct_ARRAY();
      }
      PersListRtrvStruct personRow = new PersListRtrvStruct();
      Enumeration e = personListArray.enumeratePersListRtrvStruct();
      while (e.hasMoreElements()) {
        personRow = (PersListRtrvStruct) e.nextElement();
        if (caseName.equals(personRow.getSzNmPersonFull())) {
          resourceSearchData.setNameCounty(personRow.getSzCdAddrCounty());
          // SIR 19833 - Added State to Resource Search Parameters
          resourceSearchData.setStateName(personRow.getSzCdAddrState());

          break;
        }
      }
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_NO_ROWS_RETURNED:
        break;
      default:
        throw we;
      }
    }

    return resourceSearchData;
  }

  /**
   * This submethod will be called by the Save and Assign methods. This conversation has two methods that will Save and
   * Assign. The first method, saveAndAssignIntake() is called when a normal user clicks the Save and Assign button. The
   * second method, assignIntake() is called when the approver assigns the intake. <p/> The following services are
   * called: <blockquote>
   * <ul>
   * <li>CINT12S - Call Entry AUD - Save and Assign</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GrndsExchangeContext object
   * @param intake
   *          IntakeDataBean
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   * @throws MarshalException
   * @throws ValidationException
   */
  private void assign(GrndsExchangeContext context, IntakeDataBean intake) throws ServiceException, MarshalException,
                                                                          ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".assign()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }

    CallEntryAUDInRec callEntryAUDInRec = PopulateCallEntryAUDInRec
                                                                   .populate(
                                                                             context,
                                                                             callEntryRtrvOut,
                                                                             ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN);

    // START POPULATE COUNTY - The following code pertains to setting the new county
    // into the input object for the cint12s save.
    CallEntrySvcStruct callEntrySvcStruct = callEntryAUDInRec.getCallEntrySvcStruct();
    CallDcsnAUD callDcsnAUD = callEntryRtrvOut.getCallDcsnAUD();
    if (callDcsnAUD == null) {
      callDcsnAUD = new CallDcsnAUD();
    }

    FacilRtrvOutRec facilRtrvOutRec = intake.getFacility();
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facDetailEntStruct = facilRtrvOutRec
                                                                                                      .getFacDetailEntStruct();
    if (facDetailEntStruct == null) {
      facDetailEntStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
    }

    String county = IntakeUtils.chooseCountyForAssignment(context, callDcsnAUD.getSzCdStageClassification(),
                                                          callEntrySvcStruct.getSzCdIncomingDisposition(),
                                                          facDetailEntStruct.getSzCdIncmgFacilCnty(),
                                                          callEntrySvcStruct.getSzCdIncomingCallerCounty(),
                                                          intake.getPersonlistarray());

    callEntrySvcStruct.setSzCdStageCnty(county);
    callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);
    // END POPULATE COUNTY

    CallEntryAUDOutRec callEntryAUDOutRec = PopulateDataBean.callCINT12S(callEntryAUDInRec, intake1);

    CreateCallOutStruct out = callEntryAUDOutRec.getCreateCallOutStruct();

    int[] stageIdArray = new int[] { GlobalData.getUlIdStage(request) };

    // We set the INTAKE_RETURN_URL depending on whether the user is a Case Worker
    // or an Approver. It the user is a Case Worker and they Save and Assign, upon saving
    // the Assign page they will be taken to the Call Information page in NEW mode. If the user
    // is an Approver, upon saving the Assign page they will be taken back to the Intake Actions page
    // for the Intake they were assigning. This is necessary because after the Approver assigns an
    // Intake, they still have to APPROVE the intake. So by returning the Approver to the Intake
    // Actions page - all they have to do to Approve the Intake is click the Approval Status button
    // and save the Approve page.
    if (GlobalData.isApprovalMode(request)) {
      state.setAttribute(AssignConversation.INTAKE_RETURN_URI, "/intake/IntakeActions/displayIntakeActions", request);
    } else {
      state.setAttribute(AssignConversation.INTAKE_RETURN_URI, "/intake/CallInformation/displayNewIntake", request);
    }

    GlobalData.setSzCdStageProgram(callEntrySvcStruct.getSzCdStageProgram(), request);
    request.setAttribute(IntakeConstants.COUNTY, county);
    request.setAttribute(AssignConversation.STAGE_ID_ARRAY, stageIdArray);
    request.setAttribute(IntakeConstants.ASSIGN_INTAKE, ArchitectureConstants.TRUE);
    GlobalData.setUlIdPerson(user.getUserID(), request);
    GlobalData.setSzNmPersonFull(user.getUserFullName(), request);
    GlobalData.setUlIdStage(GlobalData.getUlIdStage(request), request);
    GlobalData.setUlIdCase(out.getUlIdCase(), request);
    GlobalData.setUlIdEvent(out.getUlIdEvent(), request);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Resource Search after a search has been completed. We will get the object returned
   * from the Resource Search, unpack it, and set the new data (Jurisdiction name) into the request to be displayed on
   * the Intake Actions page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void setFacilityResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setResource_xa()");

    HttpServletRequest request = context.getRequest();

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    request.setAttribute("jurisdiction", cres03so.getSzNmResource());
    request.setAttribute("jurisdictionResourceId", String.valueOf(cres03so.getUlIdResource()));
    request.setAttribute("resourceSearch", ArchitectureConstants.TRUE);

    try {
      displayIntakeActions(context);
    }

    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This submethod populates the Intake Allegation Detail AUD input object.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   * @param cReqFuncCd String
   * @return allegListAudInRec
   */
  private AllegListAudInRec populateAllegListAudInRec_AUD(GrndsExchangeContext context, String cReqFuncCd) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateAllegListAudInRec_AUD()");

    HttpServletRequest request = context.getRequest();

    AllegListAudInRec allegListAudInRec = new AllegListAudInRec();
    ROWCINT14DI_ARRAY rowcint14di_array = new ROWCINT14DI_ARRAY();
    ROWCINT14DI rowcint14di = new ROWCINT14DI();
    //
    BaseSessionStateManager state = getSessionStateManager(context);
    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute(ALLEGLISTARRAY_STRING, request);

    String hdnIndDelAlleg = ContextHelper.getStringSafe(request, "hdnIndDelAlleg");
    boolean indBtnDel = StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDeleteFromList.x"));
    if(ArchitectureConstants.N.equals(hdnIndDelAlleg)){
      indBtnDel = true;
    }
    if (indBtnDel) {
      ROWCINT76DO allegToDelete = (ROWCINT76DO) request.getAttribute("allegToDelete");
      rowcint14di.setSzCdScrDataAction(cReqFuncCd);
      rowcint14di.setSzCdAllegType(allegToDelete.getSzCdIntakeAllegType());
      rowcint14di.setSzCdAllegedMalLocation(allegToDelete.getSzCdAllegedMalLocation());
      rowcint14di.setDtDtAllegedIncident(allegToDelete.getDtDtAllegedIncident());
      rowcint14di.setSzCdMaltreatorRel(allegToDelete.getSzCdMaltreatorRel());
      rowcint14di.setSzTxtAllegDuration(allegToDelete.getCTxtIntakeAllegDuration());
      rowcint14di.setUlIdAllegation(allegToDelete.getUlIdAllegation());
      rowcint14di.setUlIdAllegedPerpetrator(allegToDelete.getUlIdAllegedPerpetrator());
      /* ochumd sir 22934 Added NmVictim and NmPerpetrator to be deleted */
      rowcint14di.setSzNmVictim(allegToDelete.getSzScrPersVictim());
      rowcint14di.setSzNmPerpetrator(allegToDelete.getSzScrAllegPerp());
      rowcint14di.setUlIdStage(GlobalData.getUlIdStage(request));
      rowcint14di.setUlIdVictim(allegToDelete.getUlIdVictim());
    } else {
      rowcint14di.setSzCdScrDataAction(cReqFuncCd);

      // The Maltreatment Code needs to be stored in place of the code value associated with the Maltreatment Type
       rowcint14di.setSzCdAllegType(ContextHelper.getStringSafe(request, "selSzCdIntakeAllegType"));
      rowcint14di.setSzCdIntakeAllegMalCode(ContextHelper.getStringSafe(request, "selSzCdIntakeAllegMalCode"));
      rowcint14di.setSzCdAllegedMalLocation(ContextHelper.getStringSafe(request, "selSzCdAllegedMalLocation"));
      rowcint14di.setDtDtAllegedIncident(ContextHelper.getCastorDateSafe(request, "selDtDtAllegedIncident"));
      rowcint14di.setSzTxtAllegDuration(ContextHelper.getStringSafe(request, "hdnCTxtIntakeAllegDuration"));
      rowcint14di.setSzCdMaltreatorRel(ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel"));
      rowcint14di.setUlIdAllegation(ContextHelper.getIntSafe(request, "hdnUlIdAllegation"));
      rowcint14di.setUlIdStage(GlobalData.getUlIdStage(request));
      // ochumd sir 22934 - Split value of victim name gotten from JSP to obtain person name and person id
      String nameVictimAndId = ContextHelper.getStringSafe(request, "selUlIdVictim");
      if (StringHelper.isValid(nameVictimAndId)) {
        rowcint14di.setSzNmVictim(nameVictimAndId.substring(0, nameVictimAndId.indexOf("|")));
        String idVictimString = nameVictimAndId.substring(nameVictimAndId.indexOf("|") + 1, nameVictimAndId.length());
        if (idVictimString.length() > 0) {
          int id = Integer.parseInt(idVictimString);
          rowcint14di.setUlIdVictim(id);
        }
      }
      // ochumd sir 22934 - Split value of perpetrator name gotten from JSP to obtain person name and person id
      String namePerpetratorAndId = ContextHelper.getStringSafe(request, "selUlIdAllegedPerpetrator");
      if (StringHelper.isValid(namePerpetratorAndId)) {
        rowcint14di.setSzNmPerpetrator(namePerpetratorAndId.substring(0, namePerpetratorAndId.indexOf("|")));
        String idPerpetratorString = namePerpetratorAndId.substring(namePerpetratorAndId.indexOf("|") + 1,
                                                                    namePerpetratorAndId.length());
        if (idPerpetratorString.length() > 0) {
          int id = Integer.parseInt(idPerpetratorString);
          rowcint14di.setUlIdAllegedPerpetrator(id);
        }
      }
    }
    // This is to indicate if Maltreatment happened in Care (in DFCS Custody)
    String indMaltreatInCare = (String) state.getAttribute("indMaltreatInCare", request);
    rowcint14di.setCIndIncmgMaltreatInCare(indMaltreatInCare);
    rowcint14di_array.addROWCINT14DI(rowcint14di);
    allegListAudInRec.setROWCINT14DI_ARRAY(rowcint14di_array);

    performanceTrace.exitScope();

    return allegListAudInRec;
  }

  /**
   * This helpermethod will use the retrieved Allegations and filter the descriptors according to what allegations were
   * retrieved. It will then set the CPS Descriptors Array onto the request.
   * 
   * @param context
   *          the GrndsExchangeContext object
   * @param allegListArray
   *          ROWCINT76DO_ARRAY
   * @throws LookupException
   */
  private void populateCPSDescriptorsArray(GrndsExchangeContext context, ROWCINT76DO_ARRAY allegListArray)
                                                                                                          throws LookupException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCPSDescriptorsArray()");

    HttpServletRequest request = context.getRequest();

    Enumeration allegEnum = allegListArray.enumerateROWCINT76DO();
    ROWCINT76DO allegRow = new ROWCINT76DO();
    List CPSDescrValues = new ArrayList();
    Set allegHash = new HashSet();
    Collection descrCodes = Lookup.getCategoryCollection(CodesTables.CALGDESC);

    while (allegEnum.hasMoreElements()) {
      allegRow = (ROWCINT76DO) allegEnum.nextElement();
      allegHash.add(allegRow.getSzCdIntakeAllegType());
    }

    Iterator i = descrCodes.iterator();

    while (i.hasNext()) {
      CodeAttributes option = (CodeAttributes) i.next();
      String key = option.getCode();
      key = key.substring(0, 4);
      if (allegHash.contains(key)) {
        CPSDescrValues.add(option);
      }
    }
    request.setAttribute("CPSDescrValues", CPSDescrValues);

    performanceTrace.exitScope();
  }

  /**
   * This helpermethod will take the personListArray and build the following three Array Lists: <blockquote>
   * <ul>
   * <li>Alleged Perp Array List</li>
   * <li>Alleged Victim Array List</li>
   * <li>Case Name Array List</li>
   * </ul>
   * </blockquote> Once the arrays are built the alleged perp and victim arrays are set into state for use on the
   * Allegation Detail page and the Case Name array is put onto the request for use on the Intake Actions page.
   * 
   * @param context
   *          the GrndsExchangeContext object
   * @param personListArray
   *          PersListRtrvStruct_ARRAY
   * @param classification
   *          String
   * @param facilityName
   *          String
   */
  private String populateAllegAndCaseNameVectors(GrndsExchangeContext context,
                                                 PersListRtrvStruct_ARRAY personListArray, String classification,
                                                 String facilityName, String caseNm) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".buildDeterminationFactorsArrays()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    List allegedVictimVector = new ArrayList();
    List allegedPerpVector = new ArrayList();
    List caseNameVector = new ArrayList();
    List caseNameEtAlVector = new ArrayList();
    PersListRtrvStruct personRow = new PersListRtrvStruct();

    Enumeration e = personListArray.enumeratePersListRtrvStruct();
    caseNm = caseNm + "|";
    while (e.hasMoreElements()) {
      personRow = (PersListRtrvStruct) e.nextElement();
      String type = FormattingHelper.formatString(personRow.getSzCdStagePersType());
      String role = FormattingHelper.formatString(personRow.getSzCdStagePersRole());
      String searchInd = FormattingHelper.formatString(personRow.getSzCdStagePersSearchInd());
      if (type.equals(CodesTables.CPRSNTYP_PRN)) {

        // We build the case name vector to attach to the case name drop down list and also build
        // the case name vector "et al" that will be used if there is more than one victim and the user
        // classifies the intake as an AFC. We only want to append the "et al" to the Victims though
        // so we imbed the caseNameEtAlVector.add statements in the if logic that cases on whether a person
        // is a Victim or a Perp.

        // ochumd sir 22646 - append the persons id to their name for value
        caseNameVector.add(new Option(personRow.getSzNmPersonFull() + "|" + personRow.getUlIdPerson(),
                                      personRow.getSzNmPersonFull()));
        // for principal person, if name matches, append id to the name so it can
        // be sent in as value for the dropdown (all option values have id appended now)
        if (caseNm.equals(personRow.getSzNmPersonFull() + "|")) {
          caseNm = caseNm + personRow.getUlIdPerson();
        }

        if (role.equals(CodesTables.CINTROLE_VC) || role.equals(CodesTables.CINTROLE_VP)) {
          // ochumd sir 22934 Added the bar in order to get name and id
          allegedVictimVector
                             .add(new Option(personRow.getSzNmPersonFull() + "|"
                                             + String.valueOf(personRow.getUlIdPerson()), personRow.getSzNmPersonFull()));

          caseNameEtAlVector.add(new Option(personRow.getSzNmPersonFull() + "|" + personRow.getUlIdPerson(),
                                            personRow.getSzNmPersonFull()));

          String truncName = personRow.getSzNmPersonFull();
          // JMC - SIR 18760 - The case name was not being truncated correctly.
          truncName = truncName.length() > 19 ? truncName.substring(0, 19) : truncName;

          caseNameEtAlVector.add(new Option(truncName + " et al" + "|", truncName + " et al"));
        }
        if (role.equals(CodesTables.CINTROLE_AP) || role.equals(CodesTables.CINTROLE_VP)) {
          // ochumd sir 22934 Added the bar in order to get name and id
          allegedPerpVector.add(new Option(personRow.getSzNmPersonFull() + "|"
                                           + String.valueOf(personRow.getUlIdPerson()), personRow.getSzNmPersonFull()));

          caseNameEtAlVector.add(new Option(personRow.getSzNmPersonFull() + "|" + personRow.getUlIdPerson(),
                                            personRow.getSzNmPersonFull()));
        }
        // Error Handling for Save and Submit and Save and Assign. If the case is not an SPC or an I&R,
        // and a Person Search has not been conducted for one of the Principals of the case,
        // we will set the promptPersonSearch indicator onto the request. Then, on the JSP, we
        // use this indicator to determine if we should prompt the user with the MSG_INT_SRCH_PRINC when
        // the user attempts to Submit or Assign the Intake.
        if (!((CodesTables.CCLASS_IR).equals(classification) || (CodesTables.CCLASS_SPC).equals(classification))
            && CodesTables.CPRSNTYP_PRN.equals(type)
            && !((CodesTables.CSRCHSTA_V).equals(searchInd) || (CodesTables.CSRCHSTA_R).equals(searchInd) || (CodesTables.CSRCHSTA_U)
                                                                                                                                     .equals(searchInd))) {
          request.setAttribute("promptPersonSearch", ArchitectureConstants.TRUE);
          
        }
      }
    }
    state.setAttribute("allegedVictimVector", allegedVictimVector, request);
    state.setAttribute("allegedPerpVector", allegedPerpVector, request);

    // Before we set the caseNameVector onto the request we want to check if a Facility
    // Name exists. We called the Facility Detail Retrieve in the previous Try Catch Block
    // and set the facilityName string variable if a facility name was returned.
    if (!"".equals(facilityName)) {

      String tempFacilityName = facilityName.length() > 25 ? facilityName.substring(0, 25) : facilityName;
      // SIR 18760 - We need to trim off any trailing spaces because or the facility name
      // in the vector will not match what is retrieved from the database (the retrieved
      // data is automatically trimmed).
      tempFacilityName = tempFacilityName.trim();
      caseNameVector.add(new Option(tempFacilityName + "|", tempFacilityName));
      caseNameEtAlVector.add(new Option(tempFacilityName + "|", tempFacilityName));
    }

    request.setAttribute("caseNameVector", caseNameVector);

    // Only set the caseNameEtAlVector onto the request if we have more than one Victim.
    if (allegedVictimVector.size() > 1) {
      request.setAttribute("caseNameEtAlVector", caseNameEtAlVector);
    }

    // Set the personListArray into state for use on Save. The saveIntakeActions submethod
    // calls the autoDeletePersonsOnSave() helper method to delete any persons that have not yet had
    // a call person detail page saved for them and thus "made real".
    state.setAttribute("PersListRtrvStruct_ARRAY", personListArray, request);

    performanceTrace.exitScope();
    return caseNm;
  }

  /**
   * This helpermethod will take the retrieved determination factors and sort them into different arrays for display on
   * the Intake Actions page. It then sets the sorted arrays into the request as
   * 
   * @param context
   *          the GrndsExchangeContext object
   * @param callEntryRtrvOut
   *          CallEntryRtrvOut
   * @param classification
   *          String
   */
  private void populateDeterminationFactorsArrays(GrndsExchangeContext context, CallEntryRtrvOut callEntryRtrvOut,
                                                  String classification) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".buildDeterminationFactorsArrays()");

    HttpServletRequest request = context.getRequest();
    String determinationType = "";
    if ((classification.equals(CodesTables.CCLASS_AFC)) || (classification.equals(CodesTables.CCLASS_AOA))
        || (classification.equals(CodesTables.CCLASS_AOS)) || (classification.equals(CodesTables.CCLASS_APS))) {
      determinationType = CodesTables.CCLASS_APS;
    } else {
      if (("".equals(classification)) || (classification.equals(CodesTables.CCLASS_IR))
          || (CodesTables.CCLASS_SPC.equals(classification))) {
        determinationType = IntakeConstants.NO_FACTORS;
      } else {
        determinationType = CodesTables.CCLASS_CPS;
      }
    }
    // Only populate the Determination Factor and Descriptor Vectors if the Classification is of type APS or CPS.
    // (Determiniation factors are only visible on the jsp if Classification selected is of these types)
    if (!determinationType.equals(IntakeConstants.NO_FACTORS)) {
      gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD determinations = callEntryRtrvOut.getDetermListAUD();

      if (determinations == null) {
        determinations = new gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD();
      }

      gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY retrievedDeterms = determinations
                                                                                                      .getCdIncmgDeterm_ARRAY();

      if (retrievedDeterms == null) {
        retrievedDeterms = new gov.georgia.dhr.dfcs.sacwis.structs.output.CdIncmgDeterm_ARRAY();
      }

      gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY retrievedDetermTypes = determinations
                                                                                                                .getSzCdIncmgDetermType_ARRAY();

      if (retrievedDetermTypes == null) {
        retrievedDetermTypes = new gov.georgia.dhr.dfcs.sacwis.structs.output.SzCdIncmgDetermType_ARRAY();
      }

      if (determinationType.equals(CodesTables.CCLASS_CPS)) {
        List<String> CPScheckedValuesPA = new ArrayList<String>();
        List<String> CPScheckedValuesNEG = new ArrayList<String>();
        List<String> CPScheckedValuesEA = new ArrayList<String>();
        List<String> CPScheckedValuesSA = new ArrayList<String>();
        List<String> CPScheckedValuesOTH = new ArrayList<String>();
        List<String> CPSDescrCheckedValues = new ArrayList<String>();

        Enumeration enumDeterm = retrievedDeterms.enumerateCdIncmgDeterm();
        Enumeration enumType = retrievedDetermTypes.enumerateSzCdIncmgDetermType();

        while (enumDeterm.hasMoreElements()) {
          String type = (String) enumType.nextElement();
          String determination = (String) enumDeterm.nextElement();
          // String determination = ((String) enumDeterm.nextElement()).trim();
          if (type != null && IntakeConstants.DETERMINATION_FACTOR_PA.equals(type)) {
            CPScheckedValuesPA.add(determination.trim());
          } else if (type != null && IntakeConstants.DETERMINATION_FACTOR_NEG.equals(type)) {
            CPScheckedValuesNEG.add(determination);

          } else if (type != null && IntakeConstants.DETERMINATION_FACTOR_EA.equals(type)) {
            CPScheckedValuesEA.add(determination);

          } else if (type != null && IntakeConstants.DETERMINATION_FACTOR_SA.equals(type)) {
            CPScheckedValuesSA.add(determination);
          } else if (type != null && IntakeConstants.DETERMINATION_FACTOR_OTH.equals(type)) {
            CPScheckedValuesOTH.add(determination);

          } else if (type != null && "D".equals(type)) {
            CPSDescrCheckedValues.add(determination);
          }
        }
        request.setAttribute("CPScheckedValuesPA", CPScheckedValuesPA);
        request.setAttribute("CPScheckedValuesNEG", CPScheckedValuesNEG);
        request.setAttribute("CPScheckedValuesEA", CPScheckedValuesEA);
        request.setAttribute("CPScheckedValuesSA", CPScheckedValuesSA);
        request.setAttribute("CPScheckedValuesOTH", CPScheckedValuesOTH);
        request.setAttribute("CPSDescrCheckedValues", CPSDescrCheckedValues);

      } else if (determinationType.equals(CodesTables.CCLASS_APS)) {
        List<String> APScheckedValues = new ArrayList<String>();
        Enumeration enumDeterm = retrievedDeterms.enumerateCdIncmgDeterm();
        while (enumDeterm.hasMoreElements()) {
          APScheckedValues.add(((String) enumDeterm.nextElement()).trim());
        }
        request.setAttribute("APScheckedValues", APScheckedValues);
      }
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/> This submethod populates the Call Entry Retrieve Input Object.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   * @return callDcsnAUDIn
   */
  private static CallDcsnAUDIn populateCallDcsnAUDIn(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCallDcsnAUDIn()");

    HttpServletRequest request = context.getRequest();

    CallDcsnAUDIn callDcsnAUDIn = new CallDcsnAUDIn();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD callDcsnAUD = new gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUD();

    DetermListAUD determListAUD = new DetermListAUD();
    CdIncmgDeterm_ARRAY determinationArray = new CdIncmgDeterm_ARRAY();
    SzCdIncmgDetermType_ARRAY deterTypeArray = new SzCdIncmgDetermType_ARRAY();
    SpecHD specHD = new SpecHD();
    DetermCmntsAUD determCmntsAUD = new DetermCmntsAUD();
    String selSzCdStageClassification = ContextHelper.getStringSafe(request, "selSzCdStageClassification");
    callDcsnAUD.setSzCdStageClassification(selSzCdStageClassification);

    String selSzCdAllegType = ContextHelper.getStringSafe(request, "selSzCdAllegType");
    callDcsnAUD.setSzCdAllegType(selSzCdAllegType);
    callDcsnAUD.setSzCdIncmgAllegType(selSzCdAllegType);
    
    //STGAP00009957
    boolean noAllegOrAllegTypeOther  = isNoAllegationOrAllegationTypeOther(context);
    
    

    // Special Handling
    // When Intake was originally created, the input object was constructed
    // with duplicate fields for Special Handling. KRD confirms this appears to be a mistake.
    // We will continue to populate both sets of Special Handling fields though since the duplicate fields
    // do not seem to be interfering with performance so there is no reason to remove them..
    callDcsnAUD.setBIndIncmgSensitive(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSensitive"));
    callDcsnAUD.setBIndIncmgWorkerSafety(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseWorkerSafety"));
    callDcsnAUD.setSzCdIncmgSpecHandling(ContextHelper.getStringSafe(request, "selSzCdCaseSpeclHndlg"));
    callDcsnAUD.setTxtIncmgWorkerSafety(ContextHelper.getStringSafe(request, "txtTxtIncmgWorkerSafety"));
    callDcsnAUD.setTxtIncomgSensitive(ContextHelper.getStringSafe(request, "txtTxtIncomgSensitive"));
    // Sir 23720 Begin.
    callDcsnAUD.setBIndIncmgSuspMeth(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSuspMeth"));
    callDcsnAUD.setTxtIncomgSuspMeth(ContextHelper.getStringSafe(request, "txtTxtIncomgSuspMeth"));
    callDcsnAUD.setSzTxtStageSplInstrtCmnt(ContextHelper.getStringSafe(request, "txtSzTxtStageSpIns"));
    callDcsnAUD.setSzCdIncomingDisposition(ContextHelper.getStringSafe(request, "selSzCdDisp"));
    callDcsnAUD.setBIndMRLetter(CheckboxHelper.getCheckboxValue(request, "cbxBIndMandatedLetter"));
    callDcsnAUD.setCIndIncmgLawEnfInvol(ContextHelper.getStringSafe(request, "rbLawEnfInvolved"));
    callDcsnAUD.setUlIdRefferedResource(ContextHelper.getIntSafe(request, "hdnRefferedResourceId"));
    
    //CAPTA 4.3 - added policy violation radio button on Intake Action page
    callDcsnAUD.setCIndPolicyViolation(ContextHelper.getString(request, "rbIndPolicyViolation"));

    // Sir 23720 End.
    specHD.setBIndCaseSensitive(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSensitive"));
    specHD.setBIndCaseWorkerSafety(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseWorkerSafety"));
    specHD.setSzCdCaseSpeclHndlg(ContextHelper.getStringSafe(request, "selSzCdCaseSpeclHndlg"));
    specHD.setSzTxtCaseSensitiveCmnts(ContextHelper.getStringSafe(request, "txtTxtIncomgSensitive"));
    specHD.setSzTxtCaseWorkerSafety(ContextHelper.getStringSafe(request, "txtTxtIncmgWorkerSafety"));
    specHD.setUlIdCase(GlobalData.getUlIdCase(request));
    // Sir 23720 Begin.
    specHD.setBIndCaseSuspMeth(CheckboxHelper.getCheckboxValue(request, "cbxBIndCaseSuspMeth"));
    specHD.setSzTxtCaseSuspMeth(ContextHelper.getStringSafe(request, "txtTxtIncomgSuspMeth"));
    // Sir 23720 End.
    callDcsnAUD.setUlIdStage(GlobalData.getUlIdStage(request));
    callDcsnAUD.setSzCdStageInitialPriority(ContextHelper.getStringSafe(request, "selSzCdStageInitialPriority"));

    // If the current priority is blank, this means we are not in APPROVER mode and the current priority
    // field is disabled. In this case we should use the value for the Initial Priority.
    String currPriority = ContextHelper.getStringSafe(request, "selSzCdStageCurrPriority");
    if ("".equals(currPriority)) {
      currPriority = ContextHelper.getStringSafe(request, "selSzCdStageInitialPriority");
    }
    callDcsnAUD.setSzCdStageCurrPriority(currPriority);
    callDcsnAUD.setSzCdStageRsnPriorityChgd(ContextHelper.getStringSafe(request, "selSzCdStageRsnPriorityChgd"));
    // ochumd sir 22646 - Split value of stage name gotten from JSP to obtain person name and person id
    String name = ContextHelper.getStringSafe(request, NMSTAGE_STRING);
    if (StringHelper.isValid(name)) {
      callDcsnAUD.setSzNmStage(name);
    }
    callDcsnAUD.setSzTxtStagePriorityCmnts(ContextHelper.getStringSafe(request, "txtSzTxtStagePriorityCmnts"));
    
    String[] determinationFactors_PA = null;
    String[] determinationFactors_NEG = null;
    String[] determinationFactors_EA = null;
    String[] determinationFactors_SA = null;
    String[] determinationFactors_OTH = null;

    String noFactors = "";

    String classType = ContextHelper.getStringSafe(request, "hdnClassificationType");
    if (CodesTables.CCLASS_CPS.equals(classType)) {
      determinationFactors_PA = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsPA");
      determinationFactors_NEG = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsNEG");
      determinationFactors_EA = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsEA");
      determinationFactors_SA = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsSA");
      determinationFactors_OTH = CheckboxHelper.getCheckedValues(request, "CPSdeterminationFactorsOTH");
      noFactors = ContextHelper.getStringSafe(request, "CPSnoFactors");

    }
    //STGAP00009181:Added code to accomodate the population of new text fields
    determCmntsAUD.setTxtSzTxtOthCmnts(ContextHelper.getStringSafe(request, "txtSzTxtOthCmnts"));
    determCmntsAUD.setTxtSzTxtSxAbsCmnts(ContextHelper.getStringSafe(request, "txtSzTxtSxAbsCmnts"));
    determCmntsAUD.setTxtSzTxtEmAbsCmnts(ContextHelper.getStringSafe(request, "txtSzTxtEmAbsCmnts"));
    determCmntsAUD.setTxtSzTxtNegAbsCmnts(ContextHelper.getStringSafe(request, "txtSzTxtNegAbsCmnts"));
    determCmntsAUD.setTxtSzTxtPhyAbsCmnts(ContextHelper.getStringSafe(request, "txtSzTxtPhyAbsCmnts"));
    
    // STGAP00009181: Added code to check if the allegation being deleted is the
    // last one of that type in the list and if so delete all the determination
    // factors from the corresponding determination factor type. 
    // begin
    String hdnIndDelAlleg = ContextHelper.getStringSafe(request, "hdnIndDelAlleg");
    boolean indBtnDel = StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDeleteFromList.x"));
    if (ArchitectureConstants.N.equals(hdnIndDelAlleg)) {
      indBtnDel = true;
    }
    //This code kicks in when the delete button is pressed or when the user confirms the deletion.
    if (indBtnDel) {
      LasAllegOfTypeVariables lasAllegOfTypeVariables = null;
      // This call could have been avoided by passing the lasAllegOfTypeVariables to the
      // populateCallDcsnAUDIn function, but did not want to change the signature of the function
      // and create confusion as it is called in several places.
      lasAllegOfTypeVariables = lastAllegOfTypeCheck(context);
      if (lasAllegOfTypeVariables != null) {
        boolean allegIndicator = lasAllegOfTypeVariables.isAllegIndicator();
        int count = lasAllegOfTypeVariables.getCount();
        String allegDeleteType = lasAllegOfTypeVariables.getAllegationType();
        if (CodesTables.CABALTYP_OO.equals(allegDeleteType) && allegIndicator && count != 0) {
          determinationFactors_OTH = null;
        }
        if (allegIndicator) {
          if (CodesTables.CABALTYP_PP.equals(allegDeleteType)) {
            determinationFactors_PA = null;
          } else if (CodesTables.CABALTYP_NN.equals(allegDeleteType)) {
            determinationFactors_NEG = null;
          } else if (CodesTables.CABALTYP_EE.equals(allegDeleteType)) {
            determinationFactors_EA = null;
          } else if (CodesTables.CABALTYP_SS.equals(allegDeleteType)) {
            determinationFactors_SA = null;
          }
        }
      }
    }// STGAP00009181:end
    // The null check catches the case where classfication != (CPS or APS)
    if (determinationFactors_PA == null) {
      determinationFactors_PA = new String[0];
    }
    if (determinationFactors_NEG == null) {
      determinationFactors_NEG = new String[0];
    }
    if (determinationFactors_EA == null) {
      determinationFactors_EA = new String[0];
    }
    if (determinationFactors_SA == null) {
      determinationFactors_SA = new String[0];
    }

    boolean isEmergencyCareChecked = false;
    if (determinationFactors_OTH == null) {
      determinationFactors_OTH = new String[0];
    } else {
      List determFactors_OTH = Arrays.asList(determinationFactors_OTH);
      if (determFactors_OTH.contains(SHORT_TER_EMER_CARE_CODE)) {
        isEmergencyCareChecked = true;
      }
    }

    if ("".equals(noFactors)) {
      noFactors = ArchitectureConstants.N;
    }

    String disposition = ContextHelper.getStringSafe(request, "selSzCdDisp");
    String screenOutReason = ContextHelper.getStringSafe(request, "selSzCdScreentOutReason");
    if ((SCREEN_OUT_DISP_CODE.equals(disposition) || SCREEN_OUT_REF_DISP_CODE.equals(disposition))
        && NO_MALTREATMENT_SCREEN_OUT_REASON.equals(screenOutReason) && isEmergencyCareChecked) {
      callDcsnAUD.setSzCdStageReasonClosed(SCREEN_OUT_NO_MALTREATMENT_CODE);
    } else {
      callDcsnAUD.setSzCdStageReasonClosed(ContextHelper.getStringSafe(request, "selSzCdDisp"));
    }
    callDcsnAUD.setSzCdStageScroutReason(screenOutReason);

    callDcsnAUD.setBIndIncmgNoFactor(noFactors);
    // We are populating two arrays - the determination array and the determination
    // type array. We put all determination factors and determination descriptors into
    // the determination array. We add corresponding entries to the determination type
    // array telling us whether the element we added to the determination array was a
    // Factor or a Descriptor.
    for (int i = 0; i < determinationFactors_PA.length; i++) {
      determinationArray.addCdIncmgDeterm(determinationFactors_PA[i]);
      deterTypeArray.addSzCdIncmgDetermType(IntakeConstants.DETERMINATION_FACTOR_PA);
    }
    for (int i = 0; i < determinationFactors_NEG.length; i++) {
      determinationArray.addCdIncmgDeterm(determinationFactors_NEG[i]);
      deterTypeArray.addSzCdIncmgDetermType(IntakeConstants.DETERMINATION_FACTOR_NEG);
    }
    for (int i = 0; i < determinationFactors_EA.length; i++) {
      determinationArray.addCdIncmgDeterm(determinationFactors_EA[i]);
      deterTypeArray.addSzCdIncmgDetermType(IntakeConstants.DETERMINATION_FACTOR_EA);
    }
    for (int i = 0; i < determinationFactors_SA.length; i++) {
      determinationArray.addCdIncmgDeterm(determinationFactors_SA[i]);
      deterTypeArray.addSzCdIncmgDetermType(IntakeConstants.DETERMINATION_FACTOR_SA);
    }
    for (int i = 0; i < determinationFactors_OTH.length; i++) {
      // STGAP00009957: Add determinationfactors to the determinationArray only if
      // there is an allegation of type 'OTHER' or no allegations. This will make sure
      // that the 'OTHER' determination factors are not saved when an Allegation other than
      // type 'OTHER' is added to the Intake.
      if (noAllegOrAllegTypeOther) {
        determinationArray.addCdIncmgDeterm(determinationFactors_OTH[i]);
        deterTypeArray.addSzCdIncmgDetermType(IntakeConstants.DETERMINATION_FACTOR_OTH);
      }
    }

    String[] descriptors = CheckboxHelper.getCheckedValues(request, "cpsDescriptors");
    if (descriptors == null) {
      descriptors = new String[0];
    }
    for (int i = 0; i < descriptors.length; i++) {
      determinationArray.addCdIncmgDeterm(descriptors[i]);
      deterTypeArray.addSzCdIncmgDetermType(IntakeConstants.DETERMINATION_DESCRIPTOR);
    }

    // JMC - The ulPageSizeNbr was being set to 8 previously - we should have been
    // setting the ulPageSizeNbr to the total number of determination factors and
    // descriptors all along.
    input.setUlPageSizeNbr(determinationArray.getCdIncmgDetermCount());

    callDcsnAUD.setSzNmJurisdiction(ContextHelper.getStringSafe(request, "txtSzNmJurisdiction"));

    // Set everything into the input object
    determListAUD.setCdIncmgDeterm_ARRAY(determinationArray);
    determListAUD.setSzCdIncmgDetermType_ARRAY(deterTypeArray);

    callDcsnAUDIn.setArchInputStruct(input);
    callDcsnAUDIn.setSpecHD(specHD);
    callDcsnAUDIn.setDetermListAUD(determListAUD);
    callDcsnAUDIn.setCallDcsnAUD(callDcsnAUD);
    callDcsnAUDIn.setDetermCmntsAUD(determCmntsAUD);
    performanceTrace.exitScope();
    return callDcsnAUDIn;
  }

  /**
   * Every time the approver saves the Intake Actions page, we check to see if they have changed the priority. If the
   * priority has been changed, we set the PRIORITY_CHANGED indicator to true. This indicator is used in the
   * PopulateCallEntryAUDInRec.populate() method to determine how to set CSysIndEventToCreate. If we set it to TRUE a
   * new Priority Change event will be created. <p/> NOTE: There is an indicator (PRIORITY_EVENT_CREATED) that is set in
   * the PopulateCallEntryAUDInRec.java conversation that makes sure we only set the PRIORITY_CHANGED indicator into the
   * input object once, therefore ensuring we do not created multiple Priority Changed Events during one activity method
   * call (since CINT12S is called multiple times for some xa methods).
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  private static void setPriorityChangeIndicator(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setPriorityChangeIndicator()");

    HttpServletRequest request = context.getRequest();

    String origPriority = ContextHelper.getStringSafe(request, "hdnCurrPriority");
    String newPriority = ContextHelper.getStringSafe(request, "selSzCdStageCurrPriority");
    if (!origPriority.equals(newPriority) && (GlobalData.isApprovalMode(request))) {
      request.setAttribute(IntakeConstants.PRIORITY_CHANGED, ArchitectureConstants.TRUE);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method submits a resource search to the Resource Search JSP. It is called when the user clicks the resource
   * button.
   * 
   * @param context
   *          Context for the request
   */
  public void searchResource_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".SearchResource_xa()");
    HttpServletRequest request = context.getRequest();
    ResourceSearchPullBackInfo resourceSearchData = new ResourceSearchPullBackInfo();
    try {

      try {
        // Save Intake Actions before proceeding to the Allegation Detail page.
        saveIntakeActions(context, intake1);
      } catch (ServiceException we) {
        setPresentationBranch(ERROR_STRING, context);
        setErrorMessage(we.getErrorCode(), request);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
        processSevereException(context, e);
        return;
      }

      resourceSearchData.setDestinationUrl("/intake/IntakeActions/setResource");
      resourceSearchData.setResourceType(CodesTables.CRSCTYPE_02);
      // resourceSearchData.setResourceName(ContextHelper.getStringSafe(request, "txtSzNmJurisdiction"));
      resourceSearchData.setResourceStatus(IntakeConstants.ACTIVE);
      resourceSearchData.setLocationArea(IntakeConstants.LOCATION);

      request.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceSearchData);
      request.setAttribute("destinationUrl", "/intake/IntakeActions/setResource");

    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
      return;
    }

    performanceTrace.exitScope();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is used to perform the pullback on a Resource Search. It is called after the Search-Resource Method.
   * 
   * @param context
   *          Context for the request
   */
  public void setResource_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setResource_xa()");
    HttpServletRequest request = context.getRequest();

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    request.setAttribute("serviceProviderName", cres03so.getSzNmResource());
    request.setAttribute("typeOfService", cres03so.getSzCdRsrcType());
    request.setAttribute("refferedResourceId", String.valueOf(cres03so.getUlIdResource()));
    request.setAttribute("resourceSearch", ArchitectureConstants.TRUE);

    try {
      displayIntakeActions(context);
    }

    catch (Exception e) {

      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();

  }
  // STGAP00009181: Added this method to check if the intake is a special invesigation or special circumstances
  // or if there are allegations and the person search is not performed on all the pricipals then throw the person
  // search required message.
  private void checkPersonSearch(IntakeDataBean intake) {
    PersListRtrvStruct_ARRAY personListArray = intake.getPersonlistarray();
    CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntryData = callEntryRtrvOut
                                                                                                  .getCallEntrySvcStruct();
    ROWCINT76DO_ARRAY allegListArray = intake.getAllegListArray();
    boolean allegListHasRecords = false;
    if (allegListArray != null && allegListArray.getROWCINT76DOCount() > 0) {
      allegListHasRecords = true;
    }
    if (callEntryData != null) {
      callEntryData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
    }
    String spclCircumstances = FormattingHelper.formatString(callEntryData.getSzCdSpclCircumstances());
    String spcInvestigation = FormattingHelper.formatString(callEntryData.getSzCdSpclInvstgtn());
    if (personListArray != null
        && (!"".equals(spclCircumstances) || !"".equals(spcInvestigation) || allegListHasRecords)) {
      Enumeration e = personListArray.enumeratePersListRtrvStruct();
      PersListRtrvStruct personRow = new PersListRtrvStruct();
      while (e.hasMoreElements()) {
        personRow = (PersListRtrvStruct) e.nextElement();
        String type = FormattingHelper.formatString(personRow.getSzCdStagePersType());
        String searchInd = FormattingHelper.formatString(personRow.getSzCdStagePersSearchInd());
        if (type.equals(CodesTables.CPRSNTYP_PRN)) {
          if (CodesTables.CPRSNTYP_PRN.equals(type)
              && !((CodesTables.CSRCHSTA_V).equals(searchInd) || (CodesTables.CSRCHSTA_R).equals(searchInd) || (CodesTables.CSRCHSTA_U)
                                                                                                                                       .equals(searchInd))) {
            throw new ServiceException(Messages.MSG_INV_PERS_SEARCH_REQ);

          }
        }
      }
    }
  }

  // STGAP00009181: Added this function to check if the allegation being deleted is the
  // last one of that type in the list
  private static LasAllegOfTypeVariables lastAllegOfTypeCheck(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    boolean allegIndicator = true;
    String allegDeleteType = "";
    int count = 0;
    BaseSessionStateManager state = getSessionStateManager(context);
    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute("allegListArray", request);
    int index = ContextHelper.getIntSafe(request, "rbAllegList");
    ROWCINT76DO allegToDelete = allegListArray.getROWCINT76DO(index);
    allegDeleteType = allegToDelete.getSzCdIntakeAllegType();
    ROWCINT76DO allegListRow = null;
    Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();
    while (allegListEnum.hasMoreElements()) {
      allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
      if (allegToDelete != allegListRow) {
        String alegType = allegListRow.getSzCdIntakeAllegType();
        if (!CodesTables.CABALTYP_OO.equals(alegType)) {
          count++;
        }
        if (allegDeleteType.equals(alegType)) {
          allegIndicator = false;
        }
      }
    }
    LasAllegOfTypeVariables lasAllegOfTypeVariables = new LasAllegOfTypeVariables();
    lasAllegOfTypeVariables.setCount(count);
    lasAllegOfTypeVariables.setAllegIndicator(allegIndicator);
    lasAllegOfTypeVariables.setAllegationType(allegDeleteType);
    return lasAllegOfTypeVariables;
  }
  
  // STGAP00009957: Added Function to check if there exists any allegations, if there exists an allegation check if it
  // is type 'OTHER'

  private static boolean isNoAllegationOrAllegationTypeOther(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute(ALLEGLISTARRAY_STRING, request);
    boolean indNoallegOrTypeOther = false;
    List<ROWCINT76DO> allegationList = allegListArray.getROWCINT76DOAsReference();
    if (allegationList != null) {
      if (allegationList.isEmpty()) {
        indNoallegOrTypeOther = true;
      } else {
        Iterator allegationListIter = allegationList.iterator();

        while (allegationListIter.hasNext()) {
          ROWCINT76DO allegationRow = (ROWCINT76DO) allegationListIter.next();
          String allegationType = allegationRow.getSzCdIntakeAllegType();
          if (CodesTables.CABALTYP_OO.equals(allegationType)) {
            indNoallegOrTypeOther = true;
          }
        }
      }
    }
    return indNoallegOrTypeOther;
  }
  
  /**
   * This method checks to see if Maltreatment happened while the child was in care (in DFCS Care).
   * It uses the date of alleged incident and does a lookup on the LEGAL_STATUS_VIEW to see if at the
   * time of the incident if the child's legal status was one of the 'in DFCS Care'
   * 
   * @param idVictim
   * @param idCase
   * @param dtAllegedIncident
   * @param common
   * @return
   */
  public static boolean checkIfMaltreatmentInCare(int idVictim, String cdStageType, String cdMaltreatorRel, int idCase, Date dtAllegedIncident, Common common) {
    boolean isMaltreatmentInCare = false;
    CheckIfMaltreatmentInCareSI checkIfMaltreatmentInCareSI = new CheckIfMaltreatmentInCareSI();
    checkIfMaltreatmentInCareSI.setIdVictim(idVictim);
    checkIfMaltreatmentInCareSI.setIdCase(idCase);
    checkIfMaltreatmentInCareSI.setDtAllegedIncident(dtAllegedIncident);
    checkIfMaltreatmentInCareSI.setCdStageType(cdStageType);
    checkIfMaltreatmentInCareSI.setCdMaltreatorRel(cdMaltreatorRel);
    Map<String,Boolean> micMap = common.checkIfMaltreatmentInCare(checkIfMaltreatmentInCareSI);
    if(micMap != null && micMap.get("isMIC"))
    	isMaltreatmentInCare= ((Boolean)micMap.get("isMIC")).booleanValue();
    if (isMaltreatmentInCare) {
      isMaltreatmentInCare = true;
    }
    return isMaltreatmentInCare;
  }
 /**
  * This method loops throught the list of allegations and see if Maltreatement in care happens to any of the allegation.
  * If trial home visit indicator is "Y" then it is not a maltreatement in care record.
  * This flag is used to pre populate the "Is this alleged Maltreatment in Care?" radio button on Intake Action page.
  * @param allegListArray
  * @param indTrialHomeVisit
  * @return
  */
 /* private boolean isMaltreatmentInCareHappen(ROWCINT76DO_ARRAY allegListArray, String indTrialHomeVisit){
    boolean isMaltreatementInCare = false;
    if(allegListArray != null){
      Enumeration allegListEnum = allegListArray.enumerateROWCINT76DO();
      ROWCINT76DO allegListRow = null;
      
      while (allegListEnum.hasMoreElements()) {
        allegListRow = (ROWCINT76DO) allegListEnum.nextElement();
        if(allegListRow.getCIndIncmgMaltreatInCare() == "Y" && indTrialHomeVisit !=  "Y") {
          isMaltreatementInCare = true;
          break;
        }
      }
      
    }
    return isMaltreatementInCare;  
  }
  */
}
