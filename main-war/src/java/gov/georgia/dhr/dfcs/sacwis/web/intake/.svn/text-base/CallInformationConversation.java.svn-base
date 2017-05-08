package gov.georgia.dhr.dfcs.sacwis.web.intake;

//Do not import!  Specify entire package.
//import gov.georgia.dhr.dfcs.sacwis.structs.output.StageRow;

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
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.service.common.PersonUtility;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveRaceAndEthnicity;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SavePersonList;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilityDetailInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdIDInStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN31SI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN44SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINT02SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV26SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzNmPersonFull_ARRAY_CINT35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnrelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegRtrvRecOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT26SO_OTHER_RELATIONSHIP_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD; // STGAP00008020
import gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD; // STGAP00008020
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreateCallOutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacilRtrvOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT48DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT52DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelatePersonOutRec;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
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
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressSave;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSave;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.AssignConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.beans.IntrospectionException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to display, save, and process the Call Information page.
 * 
 * @author Jenn Casdorph, January 2003
 *         <p/>
 *         <p/>
 *         Change History: Date User Description -------- ----------- ----------------------------------------------
 *         07/15/03 CASDORJM SIR 18937 - Added logic in the populate for a newUsing to set the ulIdPerson correctly.
 *         07/21/03 CASDORJM SIR 19026 - When a new using was performed, the ulIdCase from the existing Intake was being
 *         retrieved and saved for the new Intake. Added code to set the callEntrySvcStruct ulIdCase to O this will
 *         eliminate the error. 08/07/03 CASDORJM SIR 19332 - Added retrieve for most recent data into the Call PErson
 *         Detail save method. 09/22/03 CASDORJM SIR 19855 - We were setting DOD into the async person search parameters
 *         instead of DOB. 11/18/03 dejuanr SIR 22412 - Check to see if stage exists on the stage table. If it doesnt,
 *         run auto save to create it. 12/02/03 dejuanr SIR 22467 - Need to blank out situation id so it dosent try to
 *         modify an existing one for another case when creating a new intake. 04/08/04 corleyan SIR 22694 - Only
 *         display the approval messages if the event actually has been submitted for approval. 04/29/04 dejuanr SIR
 *         22327 - Set the incoming worker id and office for all new intakes. 05/11/04 dejuanr SIR 22534 & 22693 - Added
 *         the DOB, Marital Status, SSN, and Race/Ethnicity to the use incoming address/phone button. 07/13/04 ochumd
 *         Sir 22934 - Replaced all references to cint19d with cint76d. 07/21/04 dejuanr SIR 22534 & 22693 - Added code
 *         to replace race and ethnicity if they are unknown 09/09/04 dejuanr SIR 23110 - Added code to keep track of
 *         validated address that are coming from E-Report intakes. 10/11/04 ochumd Sir 23115 A child under 10 years of
 *         age can not be designated as an APs for CPS, RCL and RCCL intakes. 10/11/04 ochumd Sir 22961 if an SWI worker
 *         enters a P1, P2, or PN and submits it to a supervisor for approval, and the supervisor decides the intake is
 *         not a report and rejects it back to the worker so it can be changed to an I&R. Added code so that the SWI
 *         worker is unable to close it as an I&R. 07/15/04 ochumd Sir 23711 - we loope through the person list counting
 *         PRNs with Role of Client. if more than one exist we put the count in state so that intakeActionValidation can
 *         be done. 08/04/05 ochumd Sir23843 - put special Request into state so that callPersonDetail can filter on it.
 *         <p/>
 *         07/05/05 florerj SIR 23727 - Refactored for Mobile implementation.
 *         <p/>
 *         08/01/05 ochumd Sir 23810 - Removed code for sir 23711 and used Dam instead. 08/03/05 ochumd Sir23843 - This
 *         field is being set to null here because it affects what happens to the Demographics Type drop down in the
 *         callPersonDetail page. 09/27/05 dunawakl SIR 24002 - added szCdDisasterRlf field for disaster field on
 *         callPersonDetail page. 12/20/07 - hjbaptiste STGAP 6848 Modified so that a child under 18 years of age can
 *         not be designated as an APs for CPS, RCL and RCCL intakes if they are not the Primary Caretaker(PK).
 *         <p/>
 *         <p/>
 * 
 *         04/14/08 schoi STGAP00008020 - Added 8 validations in saveAndSubmitIntake_xa and submitApproval_xa. If the
 *         User attempts to Save and Submit Intake Informations when a Non-Incident Request is selected and any
 *         Allegations, Dispositions, Determination Factors, or Response Times has been saved, the system generates
 *         error messages.
 * 
 *         <pre>
 * savePersonSearchIndicator
 * 
 *         06/02/2008 arege STGAP00008255          Added method deleteDisposition_xa. 
 *                                                 This method clears the Disposition field on the IntakeActions page
 *         08/19/2008 arege STGAP00008251          In case of an IR Intake that was submitted for approval and then the supervisor 
 *                                                 clicked SaveAndClose Button in the approval mode, we set the NmStage variable in 
 *                                                 callentrysvcstruct object , so that the CaseName is populated in the Caps_Case table
 *                                                 This update on Caps_Case table takes place in SaveCallEntry Service.
 *         08/29/2008 arege STGAP00009889          If a user is assigned to the case, or is the supervisor of the case manager,
 *                                                 or is anyone up the security hierarchy of that county, they have modify access
 *                                                 to an Open or Pending Intake.
 *         09/30/2009 bgehlot STGAP00015485:       MR-056 Changes Added new field &quot;Member of Primary CAretaker's household&quot;
 *         05/07/2010 hanguyen SMS#37187           Updated method to save new intake info in state for display after saving temporary
 *                                                 stage person link of the new intake.
 *         05/12/2010 wjcochran    SMS#38679 Updated methods for populating race and ethnicity to prevent null pointers.
 *         04/30/2010 bgehlot SMS#51977            MR-066 Changes     
 *         06/08/10  mxpatel                       MR-066.1:  added code to avoid adding duplicate persons.
 *         06/28/2010 bhgehlot                     SMS 59936 Null Check for Provider Name
 *         06/18/2010 bgehlot   SMS# 57787 Changed the duplicate message.
 *         06/30/2010 bgehlot   SMS# 60651 End dated the CD, SI and NF code and created CDNC, SINC and NFNC codes. Replaced the old ones with new ones.
 *         08/11/2010 wjcochran SMS# 50402: Update county and region in submitApproval_xa to capture any changed values. Converted
 *                                          Enumerations, etc. to Java 5 conventions.
 */
public class CallInformationConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "CallInformationConversation";

  private static final String ERROR_STRING = "error";

  public static String RESOURCE_DETAIL_CALLED = "/resource/ResourceDetail/displayResourceDetail";

  public static String HOME_INFORMATION_CALLED = "/fad/HomeInfrmtn/displayHomeInformation";

  private Intake intakeEjb;

  private Person personEjb;

  private PersonUtility personUtility;

  public void setIntakeEjb(Intake intakeEjb) {
    this.intakeEjb = intakeEjb;
  }

  public void setPersonEjb(Person personEjb) {
    this.personEjb = personEjb;
  }

  public void setPersonUtility(PersonUtility personUtility) {
    this.personUtility = personUtility;
  }

  /**
   * <p/>
   * This method is called when the user selects the INTAKE first level tab or chooses to Save and Close an Intake in
   * Progress.
   * </p>
   * <p/>
   * No services are called, this method just sets the page mode to PageMode.VIEW, sets the stage type to INT for the
   * metaphor, and clears any async person search results that have been stored in session, and displays a blank Call
   * Information page. The only action the user is allowed is clicking the Phone icon.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayNewIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayNewIntake_xa()");
    displayNewIntake(context);
    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method is called when the user clicks the Phone icon. The cint12s service is called and it will return a Stage
   * ID. We will put this Stage ID into Global Data and then display the Call Information page in NEW mode.
   * </p>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT12 - This service saves the data from Call Entry and modifies the workload. We call it now to create a new
   * intake.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void createNewIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".createNewIntake_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    state.removeAllAttributes(request);

    try {
      CallEntryAUDInRec callEntryAUDInRec = populateCallEntryAUDInRec_noStageID(context,
                                                                                ServiceConstants.REQ_FUNC_CD_ADD);

      CallEntryAUDOutRec callEntryAUDOutRec = PopulateDataBean.callCINT12S(callEntryAUDInRec, intakeEjb);

      CreateCallOutStruct createCallOutStruct = callEntryAUDOutRec.getCreateCallOutStruct();

      GlobalData.setUlIdStage(createCallOutStruct.getUlIdStage(), request);
      PageMode.setPageMode(PageModeConstants.NEW, request);

      CallEntryRtrvOut callEntryRtrvOut = PopulateDataBean.callCINT25S(context, intakeEjb);
      state.setAttribute("CallEntryRtrvOut", callEntryRtrvOut, request);

      displayCallInformation(context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will be called by the Call Log when the user clicks the "New Using" button on the Call Log page.
   * <p/>
   * It will
   * 
   * @param context
   */
  public void newUsingIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".newUsingIntake_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      CallEntryAUDInRec callEntryAUDInRec = populateCallEntryAUDInRec_noStageID(context, "G");

      CallEntryAUDOutRec callEntryAUDOutRec = PopulateDataBean.callCINT12S(callEntryAUDInRec, intakeEjb);

      CreateCallOutStruct createCallOutStruct = callEntryAUDOutRec.getCreateCallOutStruct();

      GlobalData.setUlIdStage(createCallOutStruct.getUlIdStage(), request);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      request.setAttribute("newUsing", ArchitectureConstants.TRUE);

      displayCallInformation(context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method is called when the user clicks the Continue button. The continue button is only visible when an Intake
   * is in new mode.
   * </p>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT12 - This service saves the data from Call Entry and modifies the workload. We call it now to save the Call
   * Entry portion of the Call Information page.</li>
   * <li>CINT02 - This service is called to save the Caller and IN RE person's to the Person List.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveInitialCallEntry_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveInitialCallEntry_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      // Save Call Entry
      CallEntryAUDInRec callEntryAUDInRec = populateCallEntryAUDInRec(context);

      // CallEntryAUDOutRec callEntryAUDOutRec =
      PopulateDataBean.callCINT12S(callEntryAUDInRec, intakeEjb);

      // Save the Caller/Reporter to the Person List
      // We will always save the Caller/Reporter. If there is nothing entered in the name fields,
      // the populate will fill the name person full field with '(reporter)'
      PersListAudInRec persListAudInRec1 = populatePersListAudInRec_Caller(context);
      intakeEjb.savePersonList(persListAudInRec1);
      // Save the IN RE to the Person List
      // Only save an in RE person if there is something entered in the IN RE First or Last Name field.
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingFirst"))
          || StringHelper.isValid(ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingLast"))) {
        PersListAudInRec persListAudInRec2 = populatePersListAudInRec_InRe(context);
        intakeEjb.savePersonList(persListAudInRec2);
      }

      PageMode.setPageMode(PageModeConstants.EDIT, request);
      displayCallInformation(context);
    } catch (ServiceException we) {
      // !!! setPresentationBranch ???
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This is basically a wrapper method for displayCallInformation(). displayCallInformation() is called throughout the
   * conversation by other activity methods. It is necessary to be able to call displayCallInformation() without
   * changing the page mode - hence the displayCallInformation_xa() wrapper method which sets PageMode to AppMode then
   * calls displayCallInformation().
   * 
   * @param context
   */
  public void displayCallInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayCallInformation_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      // In Intake, if we are navigating between any of the second level tabs, we want to automatically
      // save the previous page if any changes were made (excluding Call Log).
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "hdnSaveIntakeActions"))
          && (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "hdnIsIntakeActionsDirty")))) {
        try {
          IntakeActionsConversation.saveIntakeActions(context, intakeEjb);
        } catch (ServiceException we) {
          // !!! setPresentationBranch ??? ADD IN PRESENTATION BRANCH CALLED
          // this.setPresentationBranch( "IntakeActions", context );
          setErrorMessage(we.getErrorCode(), request);
          return;
        }
      }

      if (GlobalData.getUlIdStage(request) != 0) {
        PageMode.setPageMode(GlobalData.getAppMode(request), request);
        displayCallInformation(context);
      } else {
        displayNewIntake(context);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /** Calls saveCallInformation, catching any exception */
  public void autosaveCallInformation(GrndsExchangeContext context) {
    try {
      saveCallInformation(context, intakeEjb);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());

      // !!! if processSevereException happens, can we really continue?
      processSevereException(context, e);
    }
  }

  /**
   * <p/>
   * This method is called when the user clicks the Save button.
   * </p>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT12 - This service saves the data from Call Entry and modifies the workload. We call it now to save the Call
   * Entry page.</li>
   * <li>CINT11 - This service saves the data from the Facility Section. We call it now to save the Call Entry page.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveCallInformation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveCallInformation_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      saveCallInformation(context, intakeEjb);

      GlobalData.setUlIdStage(GlobalData.getUlIdStage(request), request);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * The following function handles 3 different situations in which the Call Person Detail page will display.
   * <p/>
   * 1. The user selects the Add button from Call Person List. 2. The user selects a Hyperlink from Call Person List or
   * the Detail button with only one checkbox selected. 3. The user selects the Detail button from the Call Person List
   * with multiple checkboxes selected.
   * <p/>
   * The method will call the following service(s): <blockquote>
   * <ul>
   * <li>CCMN95S - Retrieve Race/Ethnicity</li>
   * </ul>
   * </blockquote>
   * 
   * @param context
   */
  public void displayCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayCallPersonDetail_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // SIR 22412 - Check to see if stage exists on the stage table.
    CaseUtility.Stage currentStage = CaseUtility.getStage(GlobalData.getUlIdStage(request));

    if (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "hdnIsCallInfoDirty"))
        || (currentStage == null)) {
      autosaveCallInformation(context);
    }

    PersListRtrvStruct personListRow = null;

    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPerson");

    // We are getting hdnIndex out of the request as a String because if we use
    // ContextHelper.getIntSafe(), even if index is null, it will return 0, which is
    // a valid index. By using ContextHelper.getStringSafe() we can check to make
    // sure a value for hdnIndex was actually set first. If hdnIndex has a value
    // we know that the user clicked a hyperlink so we set the boolean
    // hyperlinkWasClicked to TRUE.
    String stringIndex = ContextHelper.getStringSafe(request, "hdnIndex");
    int index = 0;
    boolean hyperlinkWasClicked = false;

    if (!StringHelper.EMPTY_STRING.equals(stringIndex)) {
      index = Integer.parseInt(stringIndex);
      hyperlinkWasClicked = true;
    }

    // Situation 1: The user clicked the Add button.
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnAdd.x"))) {
      personListRow = new PersListRtrvStruct();
    }
    // Situation 2: The user clicked a hyperlink or selected the Detail button and only one checkbox
    else if ((hyperlinkWasClicked)
             || ((StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDetail.x"))) && (checkedValues.length == 1))) {
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDetail.x"))) {
        index = Integer.parseInt(checkedValues[0]);
      }
      PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                                 .getAttribute(
                                                                                               "PersListRtrvStruct_ARRAY",
                                                                                               request);

      if (personListArray == null) {
        personListArray = new PersListRtrvStruct_ARRAY();
      }

      if (index <= personListArray.getPersListRtrvStructCount()) {
        personListRow = personListArray.getPersListRtrvStruct(index);
      }
      if (CodesTables.CSRCHSTA_R.equals(personListRow.getSzCdStagePersSearchInd())) {
        request.setAttribute(ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL, ArchitectureConstants.Y);
      }

      if (isPersonInvolvedInAllegation(context, personListRow.getUlIdPerson())
          && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
        request.setAttribute(IntakeConstants.PERSON_IN_ALLEG, ArchitectureConstants.TRUE);

        setInformationalMessage(Messages.MSG_PERSON_IN_ALLEG, request);
      }

      // Set the address information from the list row into the address bean.
      // We will only populate the address bean if we are viewing the detail page
      // for a single existing person.
      AddressBean aapBean = new AddressBean();
      aapBean.setAddress1(personListRow.getSzAddrPersAddrStLn1());
      aapBean.setAddress2(personListRow.getSzAddrPersAddrStLn2());
      aapBean.setCity(personListRow.getSzAddrCity());
      aapBean.setState(personListRow.getSzCdAddrState());
      aapBean.setZipAndSuff(personListRow.getLAddrZip());
      aapBean.setCounty(personListRow.getSzCdAddrCounty());
      aapBean.addToRequest(request);
    }
    // Situation 3: The user selected the Detail button and multiple checkboxes
    else {
      personListRow = new PersListRtrvStruct();
      request.setAttribute("multipleModify", ArchitectureConstants.TRUE);
      state.setAttribute("checkedValues", checkedValues, request);
    }

    state.setAttribute("personListRow", personListRow, request);
    GlobalData.setUlIdPerson(personListRow.getUlIdPerson(), request);
    // SIR 19663
    GlobalData.setSzNmPersonFull(personListRow.getSzNmPersonFull(), request);

    // If this is a new person, there will be no race/ethnicity, so don't call the service
    if (personListRow.getUlIdPerson() != 0) {
      try {
        RaceEthnicityBean reBean = retrieveRaceEthnicityBean(personListRow.getUlIdPerson(), intakeEjb);
        RaceEthnicityHelper.addToRequest(reBean, request);
      } catch (ServiceException re) {
        int errorCode = re.getErrorCode();
        switch (errorCode) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        case Messages.MSG_SYS_MULT_INST:
          // !!! need setPresentationBranch ???
          setErrorMessage(errorCode, request);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + re.getMessage());
          processSevereException(context, re);
          break;
        }
      } catch (Exception re) {
        GrndsTrace.msg(TRACE_TAG, 7, "Race/Ethnicity: " + re.getMessage());
        processSevereException(context, re);
      }
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when a user attempts to return to the Call Person Detail page from a submodule detail page or
   * when the user clicks on the Call Person Detail tab. Since many of the submodule detail saves update information on
   * the Call Person Detail page we must recall the retrieve service for the Call Person List and get the newest
   * information for the person we are interested in.
   * 
   * @param context
   */
  public void redisplayCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".redisplayCallPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      // If we are coming from Incoming Person Detail, pageMode will be set to VIEW. We need
      // to reset the pageMode to AppMode here.
      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      redisplayCallPersonDetail(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method saves the Call Person Detail page and returns the user to the Call Information page.
   * </p>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT02 - This service saves the data from Call Person Detail page</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveAndContinueCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndContinueCallPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      saveCallPersonDetail(context);

      GlobalData.setUlIdPerson(0, request);

      displayCallInformation(context);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_INT_DUPLICATE_NOT_ALLOWED:
        setPresentationBranch("stay", context);
        request.setAttribute("errorCode", Messages.MSG_INT_DUPLICATE_NOT_ALLOWED);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      default:
        setPresentationBranch(ERROR_STRING, context);
        setErrorMessage(we.getErrorCode(), request);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user selects the Add button on the Call Person Detail page. We save the current
   * information and then populate the new person information by calling the submethod populateNewUsing().
   * 
   * @param context
   */
  public void saveAndAddCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndAddCallPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      saveCallPersonDetail(context);
      displayCallInformation(context);
      redisplayCallPersonDetail(context);

      GlobalData.setUlIdPerson(0, request);

      populateNewUsing(context);

      // JMC - SIR 18146 - The race/ethnicity bean is persisting in the request and
      // getting carried over when the user clicks the add button. In order to
      // keep this from happening, we set a blank rebean into the request to overwrite
      // any existing data.
      RaceEthnicityBean reBean = new RaceEthnicityBean();
      RaceEthnicityHelper.addToRequest(reBean, request);

      request.setAttribute(IntakeConstants.PAGE_MODE_NEW_USING, ArchitectureConstants.TRUE);
    } catch (ServiceException we) {
      // !!! setPresentationBranch ???
      int errorCode = we.getErrorCode();

      switch (errorCode) {
      // A Primary Caretaker already exists; multiple Primary Caretakers are not allowed.
      // Fixes SIR 529
      case Messages.MSG_INT_PK_EXIST:
        setInformationalMessage(errorCode, request);
        break;
      case Messages.MSG_INT_DUPLICATE_NOT_ALLOWED:
        setPresentationBranch("stay", context);
        request.setAttribute("errorCode", Messages.MSG_INT_DUPLICATE_NOT_ALLOWED);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user selects multiple persons from the Call Person List, clicks Detail and chooses
   * to save any changes made on the Call Person Detail page.
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT35 - This service updates multiple Person Detail records.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   */
  public void saveMultipleCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveMultipleCallPersonDetail()");

    HttpServletRequest request = context.getRequest();
    try {

      MUpdInRec multiplePersons = populateMUpdInRec(context);
      intakeEjb.saveCallPersonList(multiplePersons);
      displayCallInformation(context);
    } catch (ServiceException we) {

      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method saves the Call Person Detail page and allows the user to remain on the page. It also recalls the
   * retrieve for Person List and puts the row that was just added/updated into state. Then the method calls the
   * displayCallPersonDetail activity method.
   * </p>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT02 - This service saves the data from Call Person Detail page.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveAndStayCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndStayCallPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();
    try {
      saveCallPersonDetail(context);
      redisplayCallPersonDetail(context);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();

      switch (errorCode) {
      // A Primary Caretaker already exists; multiple Primary Caretakers are not allowed.
      // Fixes SIR 529
      case Messages.MSG_INT_PK_EXIST:
        setInformationalMessage(errorCode, request);
        break;
      case Messages.MSG_INT_DUPLICATE_NOT_ALLOWED:
        setPresentationBranch("stay", context);
        request.setAttribute("errorCode", Messages.MSG_INT_DUPLICATE_NOT_ALLOWED);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
        processSevereException(context, se);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method will be called from the Call Person List Delete button on the Call Information page and also from the
   * Delete button on the Call Person Detail page. A different submethod will be called to populate the delete input
   * object in each scenario. If the user is attempting to delete from the list, the populatePersListAudStructFromList()
   * will be used. If the user is attempting to delete from the detail page, the normal populatePersListAudStruct()
   * submethod will be called.
   * </p>
   * <li>CINT02 - This is the AUD service for Call Person Detail.</li> </ul> </blockquote> </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void deleteCallPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteCallPerson_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      PersListRtrvStruct personListRow = new PersListRtrvStruct();
      PersListAudStruct personToDelete = new PersListAudStruct();
      // If the use is attempting to delete a person from the Call Person List, we must
      // get the personListRow object out of state using the index of the selected Checkbox.
      // We get the selected row out of the person list and pass it to the submethod that
      // populates the personToDelete object.
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDeleteFromList.x"))) {
        autosaveCallInformation(context);

        PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                                   .getAttribute(
                                                                                                 "PersListRtrvStruct_ARRAY",
                                                                                                 request);

        if (personListArray == null) {
          personListArray = new PersListRtrvStruct_ARRAY();
        }

        String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPerson");
        int index = (checkedValues.length != 0) ? Integer.parseInt(checkedValues[0]) : 0;

        if (index < personListArray.getPersListRtrvStructCount()) {
          personListRow = personListArray.getPersListRtrvStruct(index);
        }
        // If we are attempting to delete from the list, check to make sure the person is not involved
        // in an allegation. If they are - display an error message. We do not need this logic in the
        // deleteFromDetail clause since the delete button is hidden if the person is involved in
        // in an allegation.
        if (isPersonInvolvedInAllegation(context, personListRow.getUlIdPerson())) {
          // If the user is attempting to delete from the Call Person Detail page
          // we have to set the error branch that has the Call Person Detail page as its presentation.
          setPresentationBranch(ERROR_STRING, context);
          setErrorMessage(Messages.MSG_DEL_PERSON_W_ALLEGS, request);
          return;
        }
        // Pass the personListRow we got out of the array to the populate submethod.
        personToDelete = populatePersListAudStructFromList(context, personListRow, ServiceConstants.REQ_FUNC_CD_DELETE);
      }
      // If we are deleting from the Call Person Detail page, a specific personListRow is already
      // in the state. Get that row out of state and pass it to the populate submethod to
      // populate the personToDelete input object.
      else if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnDeleteFromDetail.x"))) {
        personListRow = (PersListRtrvStruct) state.getAttribute("personListRow", request);

        personToDelete = populatePersListAudStruct(context, personListRow, ServiceConstants.REQ_FUNC_CD_DELETE);
      }

      PersListAudInRec persListAudInRec = new PersListAudInRec();
      persListAudInRec.setPersListAudStruct(personToDelete);
      intakeEjb.savePersonList(persListAudInRec);

      displayCallInformation(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will display a cached person search object if the object exists and if it does not it will pass the
   * search parameters to the Person Search page so the user can perform a new search. If the person search object is
   * cached, we will call the CINV50S update service to update the search indicator on the person list to 'V' for
   * viewed.
   * 
   * @param context
   */
  public void viewPersonSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".viewPersonSearch_xa()");

    HttpServletRequest request = context.getRequest();
    // HttpSession session = context.getSession();
    BaseSessionStateManager state = getSessionStateManager(context);

    autosaveCallInformation(context);

    // put an indicator in the request to tell the person search page we are coming from intake.
    request.setAttribute(IntakeConstants.SEARCH_INTAKE, ArchitectureConstants.TRUE);

    // Get the selected row out of the Person List Array
    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPerson");
    int index = Integer.parseInt(checkedValues[0]);
    // Get the Person List Array out of state and using the index we just found
    // get the person row in question out of the array.
    PersListRtrvStruct personListRow = null;
    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    if (index <= personListArray.getPersListRtrvStructCount()) {
      personListRow = personListArray.getPersListRtrvStruct(index);
    }
    if (personListRow == null) {
      personListRow = new PersListRtrvStruct();
    }

    // Set the person row into state
    state.setAttribute("personListRow", personListRow, request);

    try {
      // get the name of the search results and get it out of the session
      String searchPerformedName = IntakeConstants.SEARCH_PERFORMED + personListRow.getUlIdPerson();
      // String searchPerformed = (String) session.getAttribute(searchPerformedName);
      String searchPerformed = (String) state.getContextParameter(searchPerformedName, request);
      // AsynchCallBean searchResults = null;
      PersonSearchOutRec searchResults = null;
      if (!ArchitectureConstants.N.equals(searchPerformed)) {
        String searchResultsName = IntakeConstants.SEARCH_RESULTS + personListRow.getUlIdPerson();
        /*-- *************** THIS REPLACED ********************************
         searchResults = (AsynchCallBean) session.getAttribute(searchResultsName);
         //-- *************** WITH THIS ***********************************/
        // searchResults = (PersonSearchOutRec) session.getAttribute(searchResultsName);
        searchResults = (PersonSearchOutRec) state.getContextParameter(searchResultsName, request);
        // -- **************************************************************
      }

      // If asynchCallBean is null, this means the user has not kicked off an asynch
      // person search for this person, therefore we want to display a new Person Search window.
      if (searchResults == null) {
        setSearchParametersIntoRequest(context, personListRow);
        forward("/person/PersonSearch/displayPersonSearch", request, context.getResponse());
      }
      // If asynchCallBean is not null, we use the gotResponse() method
      // to see if the search has completed yet.
      else {

        PrsnSearchOutRec_ARRAY arrayResults = searchResults.getPrsnSearchOutRec_ARRAY();
        PrsnSrchListpInit_ARRAY resultsArray = convertPrsnSearchOutRec_ARRAYToPrsnSrchListpInit_ARRAY(arrayResults);
        // -- **************************************************************
        if (resultsArray == null) {
          resultsArray = new PrsnSrchListpInit_ARRAY();
        }

        // set the search parameters into the request to be displayed in the search field
        setSearchParametersIntoRequest(context, personListRow);

        // set search results into the request to be displayed as the search return
        request.setAttribute("asyncResults", resultsArray);

        // get the name of the search criteria and get it out of the session
        String searchCriteriaName = IntakeConstants.SEARCH_CRITERIA + personListRow.getUlIdPerson();
        // HierSrchInRec hiersrchinrec = (HierSrchInRec) request.getSession().getAttribute(searchCriteriaName);
        HierSrchInRec hiersrchinrec = (HierSrchInRec) state.getContextParameter(searchCriteriaName, request);

        // set the search criteria object
        request.setAttribute("searchCriteria", hiersrchinrec);

        // The person search indicator should be updated at this point because the
        // user is being taken to view the search results right now. Since the user is
        // not required to complete any actions on the Search Results page, we have to update
        // the indicator now.

        // Call the CINV50S service to update search flag
        CINV50SI cinv50si = populateCINV50S(context, personListRow.getUlIdPerson());
        // savePersonSearchIndicator.updatePersonSearchIndicator(cinv50si);
        personEjb.updatePersonSearchIndicator(cinv50si);
        // }
      }
    } catch (Exception ex) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception: " + ex.getMessage());
      processSevereException(context, ex);
    }

    performanceTrace.exitScope();
  }

  private PrsnSrchListpInit_ARRAY convertPrsnSearchOutRec_ARRAYToPrsnSrchListpInit_ARRAY(
                                                                                         PrsnSearchOutRec_ARRAY prsnSearchOutRec_ARRAY) {
    if (prsnSearchOutRec_ARRAY == null) {
      return null;
    }
    PrsnSrchListpInit_ARRAY returnArray = new PrsnSrchListpInit_ARRAY();
    Enumeration<PrsnSearchOutRec> e = prsnSearchOutRec_ARRAY.enumeratePrsnSearchOutRec();
    while (e.hasMoreElements()) {
      PrsnSearchOutRec in = e.nextElement();
      PrsnSrchListpInit out = new PrsnSrchListpInit();
      // -- five numbers in
      if (in.hasLNbrMedcaidNo()) {
        // int - not in out
      }
      if (in.hasLNbrPersonAge()) {
        out.setLNbrPersonAge(in.getLNbrPersonAge());
      }
      if (in.hasUlIdPerson()) {
        out.setUlIdPerson(in.getUlIdPerson());
      }
      if (in.hasUlIdStage()) {
        // int - not in out
      }
      if (in.hasUsScrIndScore()) {
        out.setUsScrIndScore(in.getUsScrIndScore());
      }

      // -- 21 others in
      out.setBIndActiveStatus(in.getBIndActiveStatus()); // string
      out.setBIndPersonDobApprox(in.getBIndPersonDobApprox()); // string
      boolean moreDataAvail = false;
      if (ArchitectureConstants.Y.equals(in.getBMoreDataInd())) { // string
        moreDataAvail = true;
      }
      out.setMoreDataAvailable(moreDataAvail);
      in.getBSysIndViewPersonInfo(); // string - not in out
      out.setCCdPersonSex(in.getCCdPersonSex()); // string
      out.setCWcdIndMerge(in.getCWcdIndMerge()); // string
      out.setDtDtNameEndDate(in.getDtDtNameEndDate()); // date
      out.setDtDtPersonBirth(in.getDtDtPersonBirth()); // date
      out.setDtDtPersonDeath(in.getDtDtPersonDeath()); // date
      out.setSzAddrCity(in.getSzAddrCity()); // string
      out.setSzAddrPersAddrStLn1(in.getSzAddrPersAddrStLn1()); // string
      out.setSzCdCounty(in.getSzCdCounty()); // string
      out.setSzCdPersonEthnicGroup(in.getSzCdPersonEthnicGroup()); // string
      out.setSzNbrPersonIdSsn(in.getSzNbrPersonIdSsn()); // string
      out.setSzNmIncmgPersFull(in.getSzNmIncmgPersFull()); // string
      out.setSzNmNameFirst(in.getSzNmNameFirst()); // string
      out.setSzNmNameLast(in.getSzNmNameLast()); // string
      out.setSzNmNameMiddle(in.getSzNmNameMiddle()); // string
      out.setSzNmPersonFull(in.getSzNmPersonFull()); // string
      out.setSzScrCdPersonSearchHit(in.getSzScrCdPersonSearchHit()); // string
      out.setSzScrNmGenericFullName(in.getSzScrNmGenericFullName()); // string

      returnArray.addPrsnSrchListpInit(out);
    }
    returnArray.setUlRowQty(returnArray.getPrsnSrchListpInit().length);
    return returnArray;
  }

  /**
   * This method is called when the user selects the New Using button on the Call Person List section of Call
   * Information. We simple call the populateNewUsing() submethod.
   * 
   * @param context
   */
  public void newUsingCallPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".newUsingCallPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();

    autosaveCallInformation(context);

    populateNewUsing(context);
    request.setAttribute(IntakeConstants.PAGE_MODE_NEW_USING, ArchitectureConstants.TRUE);

    performanceTrace.exitScope();
  }

  // TODO - Rewrite the try catch block to catch the call entry 'no rows returned' error right away.

  /**
   * <p/>
   * This method displays the Call Information page.
   * </p>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT25 - Retrieves Call Entry</li>
   * <li>CINT26 - Retrieves Person List</li>
   * <li>CINT26 - Retrieves Facility Detail</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  @SuppressWarnings( { "unchecked" })
  private void displayCallInformation(GrndsExchangeContext context) throws ServiceException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayCallInformation()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      // CALL ENTRY RETRIEVE
      CallEntryRtrvOut callEntryRtrvOut = PopulateDataBean.callCINT25S(context, intakeEjb);
      state.setAttribute("CallEntryRtrvOut", callEntryRtrvOut, request);

      // Unpack the returned object and use info to pass populate the address bean and
      // to pass Person List needed input parameters

      gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntryData = callEntryRtrvOut
                                                                                                    .getCallEntrySvcStruct();

      String incomingStatus = FormattingHelper.formatString(callEntryData.getCdIncmgStatus());
      state.setAttribute("incomingStatus", incomingStatus, request);
      String eventStatus = FormattingHelper.formatString(callEntryRtrvOut.getSzCdEventStatus());
      // ochumd Sir23843 set special request into state so callPerson can filter on it.
      // String specialRequest = FormattingHelper.formatString(callEntryData.getSzCdIncomingDisposition());
      // state.setAttribute("specialRequest", specialRequest, request);
      // If the incoming status is EVER closed, we want to set the app mode to VIEW
      int idStage = GlobalData.getUlIdStage(request);
      int UserId = UserProfileHelper.getUserProfile(request).getUserID();
      boolean hasStageAccess = CaseUtility.hasStageAccess(UserId, idStage);

      if ((CodesTables.CINCMGST_CLD).equals(incomingStatus) || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
        GlobalData.setAppMode(PageModeConstants.VIEW, request);
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }
      // SIR 22694 only display the messages if the event has actually been submitted
      // for approval
      else if (!GlobalData.isApprovalMode(request) && PageModeConstants.EDIT.equals(GlobalData.getAppMode(request))
               && CodesTables.CINCMGST_SBA.equals(incomingStatus) && CodesTables.CEVTSTAT_PEND.equals(eventStatus)
               && CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
        if (hasStageAccess) {
          // arege Per STGAP00009889 Added this if because the following message should not be displayed
          // for someone who does not have modify access to this page and thus he will never be able to modify this
          // page.
          setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);

          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
      // arege Per STGAP00009889 Page Mode should be set to View if the
      // Person logged in does not have access to the stage and it is not
      // a new intake.
      if (!PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
        if (!hasStageAccess) {
          GlobalData.setAppMode(PageModeConstants.VIEW, request);
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }

      // In order for GlobalData.isApprovalMode() to work, we have to have ulIdEvent set
      // into global data correctly. We do that here in the display helper method so that
      // any time the user access Intake after it has been saved the ulIdEvent will get set into
      // global data.
      GlobalData.setUlIdEvent(callEntryData.getUlIdEvent(), request);

      AddressBean aapBean = new AddressBean();
      aapBean.setAddressSubmoduleName("callEntryAddress");
      aapBean.setAddress1(callEntryData.getSzAddrIncmgStreetLn1());
      aapBean.setAddress2(callEntryData.getSzAddrIncmgStreetLn2());
      aapBean.setCity(callEntryData.getSzAddrIncomingCallerCity());
      aapBean.setState(callEntryData.getSzCdIncomingCallerState());
      aapBean.setZipAndSuff(callEntryData.getSzAddrIncmgZip());
      aapBean.setCounty(callEntryData.getSzCdIncomingCallerCounty());
      aapBean.addToRequest(request);

      // PERSON LIST RETRIEVE
      try {
        Date callDisposedDt = callEntryData.getTsIncmgCallDisp();

        PersListOutRec persListOutRec = PopulateDataBean
                                                        .callCINT26S(context, incomingStatus, callDisposedDt, intakeEjb);

        PersListRtrvStruct_ARRAY personListArray = persListOutRec.getPersListRtrvStruct_ARRAY();

        // This will set relationship information into a List for displaying on the jsp.
        List<Option> relationshipList = new ArrayList<Option>();
        CINT26SO_OTHER_RELATIONSHIP_ARRAY otherRelatonshipAray = persListOutRec.getCINT26SO_OTHER_RELATIONSHIP_ARRAY();
        CINT26SO_OTHER_RELATIONSHIP rowOtherRelationship;

        int thePKId = findPKPersonID(personListArray); // primary care id
        // ?bug
        if (otherRelatonshipAray != null) {
          Enumeration rowEnumerationOtherRelationship = otherRelatonshipAray.enumerateCINT26SO_OTHER_RELATIONSHIP();
          while (rowEnumerationOtherRelationship.hasMoreElements()) {
            rowOtherRelationship = (CINT26SO_OTHER_RELATIONSHIP) rowEnumerationOtherRelationship.nextElement();
            // don't add the primary care to the list
            if (thePKId != rowOtherRelationship.getUlIdPerson()) {
              relationshipList.add(new Option(String.valueOf(rowOtherRelationship.getUlIdPerson()),
                                              rowOtherRelationship.getSzNmPersonFull()));
            }
          }

          // -- check for message to display (expecting Messages.MSG_PCH_MORE_THAN_100_PRN or nothing)
          int message = otherRelatonshipAray.getError_message();
          if (message > 0) {
            setInformationalMessage(message, request);
          }
        }

        state.setAttribute("relationshipList", relationshipList, request);

        personListArray = IntakeUtils.sortCallPersonList(personListArray);

        state.setAttribute("PersListRtrvStruct_ARRAY", personListArray, request);
        // Ochumd - Sir 23115 A child under 18 years of age can not be designated
        // as an APs for CPS, RCL and RCCL intakes. The code below is put here becuase
        // at this point in the creation of an intake, the classification has not been
        // entered. Therefore, we get the list from state, loop through it to fine
        // out if atleast one AP is under 18 years and put that row in state to be
        // used in the intakeActionCustomvalidation by which time the classification
        // would have been entered.

        // Get the Person List Array out of state.
        PersListRtrvStruct intakePersonListRow = null;
        personListArray = (PersListRtrvStruct_ARRAY) state.getAttribute("PersListRtrvStruct_ARRAY", request);

        if (personListArray == null) {
          personListArray = new PersListRtrvStruct_ARRAY();
        }
        // get the person row in question out of the array.
        // int clientCount = 0;
        for (int i = 0; i < personListArray.getPersListRtrvStructCount(); i++) {
          if (0 != personListArray.getPersListRtrvStruct(i).getLNbrPersonAge()) {
            if ("AP".equals(personListArray.getPersListRtrvStruct(i).getSzCdStagePersRole())
                && (personListArray.getPersListRtrvStruct(i).getLNbrPersonAge() < 18)) {
              intakePersonListRow = personListArray.getPersListRtrvStruct(i);
            }
          }
          if (intakePersonListRow == null) {
            intakePersonListRow = new PersListRtrvStruct();
          }

          // Set the person row into state
          state.setAttribute("personListRow", intakePersonListRow, request);

        }

        // state.setAttribute("ClientCount", new Integer(clientCount).toString(), request);
        // SIR 23110 Start
        // Create the Hash Map that will keep track of address validation.
        // We will loop through the person list and map a "0" to every persons
        // id. The first element "0" is the call info address. When the address
        // is validated the "0" will be replaced with a "1". This code will only
        // fire if the validateEReport attribute is in state and there is no existing
        // map.
        boolean validateEReport = state.getAttribute("validateEReport", request) != null;
        Map validateMap = (Map) state.getAttribute("validateMap", request);

        if (validateEReport && (validateMap == null)) {
          validateMap = new HashMap();
          validateMap.put("0", "0");

          Enumeration personListEnum = personListArray.enumeratePersListRtrvStruct();
          while (personListEnum.hasMoreElements()) {
            PersListRtrvStruct personDetail = (PersListRtrvStruct) personListEnum.nextElement();
            validateMap.put(String.valueOf(personDetail.getUlIdPerson()), "0");
          }
          state.setAttribute("validateMap", validateMap, request);
        }
        // SIR 23110 End
      } catch (ServiceException pe) {
        switch (pe.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          // Don't do anything if no rows returned.
          break;
        case Messages.MSG_NO_ROWS_RETURNED:
          // Don't do anything if no rows returned.
          break;
        default:
          throw pe;
        }
      }
      // FACILITY RETRIEVE
      // Notice the use of "facEntryExists". This indicator is used by the facility detail save
      // populate submethod to determine if the cReqFuncCd should be an ADD or an UPDATE. If existing
      // data is not retrieved, facEntryExists will be set into state as FALSE. Then, when the user attempts
      // to save the Call Information page, if "facEntryExists == false" cReqFuncCd is set to ADD. Else,
      // cReqFuncCd is set to update.
      try {
        state.removeAttribute("facEntryExists", request);
        // Only call the facility retrieve if (page mode != new) and
        // !(page mode == view and stage id == 0).
        String pageMode = PageMode.getPageMode(request);
        boolean placementFoundForChild = false;
        if (!pageMode.equals(PageModeConstants.NEW)
            && !(pageMode.equals(PageModeConstants.VIEW) && (GlobalData.getUlIdStage(request) == 0))) {
          FacilRtrvInRec facilRtrvInRec = PopulateDataBean.populateFacilRtrvInRec_Retrieve(context);

          FacilRtrvOutRec facilRtrvOutRec = null;
          //get placement from incoming Facility.
          facilRtrvOutRec = intakeEjb.retrieveIncomingFacilityDetail(facilRtrvInRec);
          if (facilRtrvOutRec == null) {
            state.setAttribute("facEntryExists", "false", request);
            //CAPTA 4.3 start - if child is victim, get its placement.
            facilRtrvOutRec = intakeEjb.retrievePlacementForVictimChild(facilRtrvInRec);  
            //facilRtrvOutRec = new FacilRtrvOutRec();
            
          }
          if (facilRtrvOutRec != null && (facilRtrvOutRec.getFacDetailEntStruct().getUlIdResource() != 0 || StringHelper.isValid(facilRtrvOutRec.getFacDetailEntStruct().getNmIncmgFacilName()))) {
            state.setAttribute("FacilRtrvOutRec", facilRtrvOutRec, request);
            placementFoundForChild = true;
            state.setAttribute("PlacementFoundForChild", "true", request);
          }else {
            facilRtrvOutRec = new FacilRtrvOutRec();
            //state.setAttribute("facEntryExists", "false", request);
          }
          
        //CAPTA 4.3 end
          gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facDetailEntStruct = facilRtrvOutRec
                                                                                                            .getFacDetailEntStruct();

          if (facDetailEntStruct == null) {
            facDetailEntStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
          }

          AddressBean aapBean2 = new AddressBean();
          aapBean2.setAddressSubmoduleName("facilityAddress");
          aapBean2.setAddress1(facDetailEntStruct.getSzAddrIncmgFacilStLn1());
          aapBean2.setAddress2(facDetailEntStruct.getSzAddrIncmgFacilStLn2());
          aapBean2.setCity(facDetailEntStruct.getSzAddrIncmgFacilCity());
          aapBean2.setState(facDetailEntStruct.getSzCdIncmgFacilState());
          aapBean2.setZipAndSuff(facDetailEntStruct.getSzAddrIncmgFacilZip());
          aapBean2.setCounty(facDetailEntStruct.getSzCdIncmgFacilCnty());
          aapBean2.addToRequest(request);
          state.setAttribute("FacilRtrvOutRec", facilRtrvOutRec, request);
        }
      } catch (ServiceException me) {
        switch (me.getErrorCode()) {
        case Messages.SQL_NOT_FOUND:
          // don't do anything (error related) if no rows returned
        case Messages.MSG_NO_ROWS_RETURNED:
          // don't do anything (error related) if no rows returned
          state.setAttribute("facEntryExists", "false", request);
          break;
        default:
          throw me;
        }
      }

      // INTAKE NARRATIVE RETRIEVE
      request.setAttribute(IntakeConstants.NARRATIVE_EXISTS, ArchitectureConstants.N);
      if (PopulateDataBean.hasNarrative(context, intakeEjb)) {
        request.setAttribute(IntakeConstants.NARRATIVE_EXISTS, ArchitectureConstants.Y);
      }
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_NO_ROWS_RETURNED:
        // !!! setPresentationBranch ???
        setPresentationBranch(ERROR_STRING, context);
        setErrorMessage(Messages.MSG_INT_CALL_DELETED, request);
        break;
      default:
        throw we;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This submethod is called when to save the Call Entry and Facility sections of the page.
   * 
   * @param context
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   * @throws ValidationException
   * @throws MarshalException
   * @throws IntrospectionException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException
   * 
   */
  @SuppressWarnings( { "unchecked" })
  public static void saveCallInformation(GrndsExchangeContext context, Intake intake1) throws ServiceException,
                                                                                      ValidationException,
                                                                                      MarshalException,
                                                                                      IntrospectionException,
                                                                                      DataFormatException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveCallInformation()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // If this save was kicked off by the user clicking one of the Save && Whatever (including Save) Buttons
    // this means the user is exiting the Intake. We want to delete any person's that have not had a detail
    // page saved from the Call Person List. The reason for this is that in CAPS, if a person was not "made real"
    // they would simply "fall off of the Intake" when the Intake was exited. This is important because the
    // reporter and in re persons automatically get saved to the Call Person List. Instead of forcing
    // the user to delete these persons manually (for instance in an I&R where you can't have anyone on the person
    // list),
    // we can just auto-delete.
    // Note: We do not have to include the initial SaveAndXXX buttons since the person list is not available
    // at the save time they are (when the Intake is in new mode).
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndSubmit.x"))
        || StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndAssign.x"))
        || StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndClose.x"))
        || StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveCallInformation.x"))) {
      try {
        autoDeletePersonsOnSave(context, intake1);
      } catch (Exception ex) {
        // If the delete fails don't do anything. We don't want to ruin the save just because
        // the specified people did not "fall off" the intake.
      }
    }
    // CALL ENTRY SAVE
    if (IntakeUtils.hasCallEntryChanged(context) && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      CallEntryAUDInRec callEntryAUDInRec = populateCallEntryAUDInRec(context);
      intake1.saveCallEntry(callEntryAUDInRec);
    }
    // FACILITY SAVE
   /* if ((IntakeUtils.hasFacilityDetailChanged(context) || "true"
                    .equals(ContextHelper
                                         .getStringSafe(request,
                                                        "hdnResourceSearch")))
                             && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      */ 
      //capta 4.3 start
      //if placement found for victim child, save the facility.
    String placementFound = (String)ContextHelper.getStringSafe(request,"hdnPlacementFound");
    String resourceSearch = (String)ContextHelper.getStringSafe(request,"hdnResourceSearch");
    if (( IntakeUtils.hasFacilityDetailChanged(context) || 
                          "true".equals(resourceSearch) || 
                          "true".equals(placementFound))&& 
                          !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      
      FacilityDetailInRec facilDetail = populateFacilityDetailInRec_Save(context);
  
      try {
        // CINT11S
        intake1.saveIncomingFacilityDetail(facilDetail);
      } catch (ServiceException ex) {
        throw ex;
      }
      state.removeAttribute("facEntryExists", request);

    }
     // SIR 23110 Start
    // If the address was validated the mark the call info as "1"

    Map validateMap = (Map) state.getAttribute("validateMap", request);
    boolean validated = ContextHelper.getBooleanSafe(request, "callEntryAddressaddressIsValid");
    if (validateMap != null && validated) {
      validateMap.put("0", "1");
    }
    // SIR 23110 End

    performanceTrace.exitScope();
  }

  /**
   * This submethod saves the current Call Person Detail information. <blockquote>
   * <ul>
   * <li>CINT02S - Save for Call Person Detail</li>
   * <li>CINT26S - Retrieve for Call Person List</li>
   * </ul>
   * </blockquote>
   * 
   * @param context
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   * @throws Exception
   */
  @SuppressWarnings( { "unchecked" })
  private void saveCallPersonDetail(GrndsExchangeContext context) throws ServiceException, ValidationException,
                                                                 MarshalException, IntrospectionException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveCallPersonDetail()");

    HttpServletRequest request = context.getRequest();
    // HttpSession session = context.getSession();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Save the current person info
    PersListAudInRec persListAudInRec = populatePersListAudInRec_AUD(context);
    PersListAudOutRec person = intakeEjb.savePersonList(persListAudInRec);

    GlobalData.setUlIdPerson(person.getUlIdPerson(), request);

    // -- Get search criteria and set into session
    HierSrchInRec hierSrchInRec = populateHierSrchInRec(context);
    String searchCriteriaName = IntakeConstants.SEARCH_CRITERIA + person.getUlIdPerson();
    // session.setAttribute(searchCriteriaName, hierSrchInRec);
    state.setContextParameter(searchCriteriaName, hierSrchInRec, request);

    // -- SIR STGAP00000887
    // -- So as not to mislead the user when they view the search results, we determine if
    // -- the user specified the person's gender and put this value into session. Then, once
    // -- the user views the search results, the Person Search page will not populate the
    // -- "Gender" select box if no gender was specified by the user. This is a problem b/c
    // -- the gender is required for the database and defaults to "U" (Unknown) if none was
    // -- specified. But using this value from the Person Search page will cause no results
    // -- to return from the search when they otherwise would have without using the gender in
    // -- the search criteria.
    String genderSpecifiedName = IntakeConstants.GENDER_SPECIFIED_BY_USER + person.getUlIdPerson();
    if (StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "selCdPersonSex"))) {
      state.setContextParameter(genderSpecifiedName, ArchitectureConstants.N, request);
    } else {
      state.setContextParameter(genderSpecifiedName, ArchitectureConstants.Y, request);
    }

    // -- Initialize attribute name for search performed
    String searchPerformedName = IntakeConstants.SEARCH_PERFORMED + person.getUlIdPerson();

    // -- If the Perform Search checkbox is checked, call the person search and put results in session
    if ((ArchitectureConstants.Y).equals(ContextHelper.getStringSafe(request, "cbxSzCdStagePersSearchInd"))) {
      // -- get correct input object (not the asynchronous version) and call synchronous service
      PersonSearchInRec personSearchInRec = convertHierSrchInRecToPersonSearchInRec(hierSrchInRec);
      PersonSearchOutRec searchResults = personEjb.retrievePersonSearch(personSearchInRec);
      // AsynchCallBean searchResults = WtcHelper.callAsynchService("CINT05S", hierSrchInRec);

      // -- put search results in session and remove the search performed ("N") attribute
      String searchResultsName = IntakeConstants.SEARCH_RESULTS + person.getUlIdPerson();
      // session.setAttribute(searchResultsName, searchResults); // searchResults);
      // session.removeAttribute(searchPerformedName);
      state.setContextParameter(searchResultsName, searchResults, request);
      state.removeContextParameter(searchPerformedName, request);
    }
    // -- Else, put into session an attribute that lets us know the person search service has not been
    // -- called for this person
    else {
      // session.setAttribute(searchPerformedName, ArchitectureConstants.N);
      state.setContextParameter(searchPerformedName, ArchitectureConstants.N, request);
    }

    // SIR 23110 Start
    // Since the Call Person Detail pages have the code to force validation
    // we can assume that if the user is saving the page, the code has been
    // validated.
    Map validateMap = (Map) state.getAttribute("validateMap", request);
    if (validateMap != null) {
      validateMap.put(GlobalData.getUlIdPersonAsString(request), "1");
    }
    // SIR 23110 End

    performanceTrace.exitScope();
  }

  private PersonSearchInRec convertHierSrchInRecToPersonSearchInRec(HierSrchInRec hierSrchInRec) {
    if (hierSrchInRec == null) {
      return null;
    }
    PersonSearchInRec personSearchInRec = new PersonSearchInRec();

    personSearchInRec.setArchInputStruct(hierSrchInRec.getArchInputStruct());
    boolean moreDataAvail = false;
    if (ArchitectureConstants.Y.equals(hierSrchInRec.getBMoreDataInd())) {
      moreDataAvail = true;
    }
    personSearchInRec.setMoreDataAvailable(moreDataAvail);
    PrsnSearchInRec out = new PrsnSearchInRec();
    HierPersSrchRec in = hierSrchInRec.getHierPersSrchRec();
    if (in != null) {
      // -- two numbers in
      // STGAP00004281 Automatic search should not use gender or dob
      // if (in.hasLNbrPersonAge()) {
      // out.setLNbrPersonAge(in.getLNbrPersonAge());
      // }
      if (in.hasLSysNbrUniqueLBKey()) {
        // int - not in out
      }

      // -- 15 others in
      out.setBASearchFlag(in.getBASearchFlag()); // string
      boolean moreDataAvailable = false;
      if (ArchitectureConstants.Y.equals(in.getBMoreDataInd())) { // string
        moreDataAvailable = true;
      }
      out.setMoreDataAvailable(moreDataAvailable);
      // STGAP00004281 Automatic search should not use gender or dob
      // out.setCCdPersonSex(in.getCCdPersonSex()); // string
      out.setDtDtPersonBirth(in.getDtDtPersonBirth()); // date
      out.setLAddrZip(in.getLAddrZip()); // string
      out.setLNbrPhone(in.getLNbrPhone()); // string
      out.setSzAddrCity(in.getSzAddrCity()); // string
      out.setSzAddrPersAddrStLn1(in.getSzAddrPersAddrStLn1()); // string
      out.setSzAddrPersAddrStLn2(in.getSzAddrPersAddrStLn2()); // string
      out.setSzCdAddrCounty(in.getSzCdAddrCounty()); // string
      out.setSzCdAddrState(in.getSzCdAddrState()); // string
      out.setSzNbrPersonIdSsn(in.getSzNbrPersonIdSsn()); // string
      out.setSzNmNameFirst(in.getSzNmNameFirst()); // string
      out.setSzNmNameLast(in.getSzNmNameLast()); // string
      out.setSzNmNameMiddle(in.getSzNmNameMiddle()); // string

      // -- needed for out, but not given in
      out.setBScrPhoneticChk(ArchitectureConstants.Y);
      out.setBScrAddressChk(ArchitectureConstants.N);
      out.setBScrFullNameChk(ArchitectureConstants.N);
      out.setBScrAdditParametersChk(ArchitectureConstants.N);
    }

    personSearchInRec.setPrsnSearchInRec(out);
    return personSearchInRec;
  }

  /**
   * This submethod will call the Person List retrieve service and enumerate through the array until the Person Row we
   * are interested in is found. It will then stick this PersonListRow into state. <li>CINT26S - Retrieve for Call
   * Person List</li> <li>CCMN95S - Retrieve for Race/Ethnicity</li> </ul> </blockquote>
   * 
   * @param context
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   * @throws Exception
   */
  private void redisplayCallPersonDetail(GrndsExchangeContext context) throws ServiceException, ValidationException,
                                                                      MarshalException, IntrospectionException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".redisplayCallPersonDetail()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    PersListRtrvStruct personListRow = retrievePersonRowFromList(context, intakeEjb);

    state.setAttribute("personListRow", personListRow, request);

    if (CodesTables.CSRCHSTA_R.equals(personListRow.getSzCdStagePersSearchInd())) {
      request.setAttribute(ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL, ArchitectureConstants.Y);
    }

    // If we are not calling the redisplay method using the Add button,
    // check to see if the person is involved in an allegation. If they
    // are, set an indicator into the request and also an information message.
    if (!StringHelper.isValid(ContextHelper.getStringSafe(request, "btnSaveAndCopy.x"))
        && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      if (isPersonInvolvedInAllegation(context, personListRow.getUlIdPerson())) {
        request.setAttribute(IntakeConstants.PERSON_IN_ALLEG, ArchitectureConstants.TRUE);
        setInformationalMessage(Messages.MSG_PERSON_IN_ALLEG, request);
      }
    }
    // Set the address information from the list into the address bean.
    AddressBean aapBean = new AddressBean();
    aapBean.setAddress1(personListRow.getSzAddrPersAddrStLn1());
    aapBean.setAddress2(personListRow.getSzAddrPersAddrStLn2());
    aapBean.setCity(personListRow.getSzAddrCity());
    aapBean.setState(personListRow.getSzCdAddrState());
    aapBean.setZipAndSuff(personListRow.getLAddrZip());
    aapBean.setCounty(personListRow.getSzCdAddrCounty());
    aapBean.addToRequest(request);

    // Retrieve the Race/Ethnicity Data
    RaceEthnicityBean reBean = retrieveRaceEthnicityBean(personListRow.getUlIdPerson(), intakeEjb);
    RaceEthnicityHelper.addToRequest(reBean, request);

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user selects the Search button in the Facility section of Call Information. It will
   * copy all the current data into an object and kick off a Resource Search.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void getFacilityResource_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".getFacilityResource_xa()");

    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);

    autosaveCallInformation(context);

    ResourceSearchPullBackInfo resourceSearchData = new ResourceSearchPullBackInfo();
    resourceSearchData.setDestinationUrl("/intake/CallInformation/setFacilityResource");
    resourceSearchData.setFacilityType(ContextHelper.getStringSafe(request, "selResourceFacilityTypeSearch"));
    resourceSearchData.setResourceName(ContextHelper.getStringSafe(request, "txtNmIncmgFacilNameSearch"));

    // SMS#51977 MR-066Search by Resource ID
    resourceSearchData.setIdentificationNum(ContextHelper.getStringSafe(request, "txtResourceId"));
    if (resourceSearchData.getIdentificationNum() != null) {
      resourceSearchData.setIdentificationType("RSC");
    }
    // resourceSearchData.setResourceStatus(IntakeConstants.ACTIVE);
    resourceSearchData.setResourceStatus(CodesTables.CRSCSTAT_01);

    state.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceSearchData, request);

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the Resource Search after a search has been completed. We will get the object returned
   * from the Resource Search, unpack it, and set the new data (Facility Name, Phone Number, etc) into the facilityData
   * object that is displayed onLoad of the Call Information page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void setFacilityResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setResource_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    performanceTrace.msg(TRACE_TAG, 7, "cres03so: " + cres03so);

    try {
      displayCallInformation(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    // FACILITY DETAIL
    FacilRtrvOutRec facilRtrvOutRec = (FacilRtrvOutRec) state.getAttribute("FacilRtrvOutRec", request);
    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct facilityData = facilRtrvOutRec
                                                                                                .getFacDetailEntStruct();
    if (facilityData == null) {
      facilityData = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
    }

    facilityData.setUlIdStage(GlobalData.getUlIdStage(request));
    facilityData.setUlIdResource(cres03so.getUlIdResource());
    facilityData.setNmIncmgFacilName(cres03so.getSzNmResource());
    facilityData.setSzCdIncmgFacilType(cres03so.getSzCdRsrcFacilType());
    facilityData.setBIndIncmgFacilSearch(ArchitectureConstants.Y);
    facilityData.setSzCdIncFacilOperBy(cres03so.getSzCdIncFacilOperBy());
    facilityData.setSzCdRsrcType(cres03so.getSzCdRsrcType());

    // This will be set using the address submodule
    Enumeration<ROWCRES03SOG00> addressEnum = cres03so.getROWCRES03SOG00_ARRAY().enumerateROWCRES03SOG00();
    ROWCRES03SOG00 addressDetail = new ROWCRES03SOG00();
    while (addressEnum.hasMoreElements()) {
      addressDetail = addressEnum.nextElement();
      if (CodesTables.CRSCADDR_01.equals(addressDetail.getSzCdRsrcAddrType())) {
        break;
      }
    }

    AddressBean facilityAddress = new AddressBean();
    facilityAddress.setAddressSubmoduleName("facilityAddress");
    facilityAddress.setAddress1(addressDetail.getSzAddrRsrcAddrStLn1());
    facilityAddress.setAddress2(addressDetail.getSzAddrRsrcAddrStLn2());
    facilityAddress.setCity(addressDetail.getSzAddrRsrcAddrCity());
    facilityAddress.setState(addressDetail.getSzCdFacilityState());
    facilityAddress.setZipAndSuff(addressDetail.getSzAddrRsrcAddrZip());
    facilityAddress.setCounty(addressDetail.getSzCdFacilityCounty());
    facilityAddress.addToRequest(request);

    Enumeration<ROWCRES03SOG01> phoneEnum = cres03so.getROWCRES03SOG01_ARRAY().enumerateROWCRES03SOG01();
    ROWCRES03SOG01 phoneDetail = new ROWCRES03SOG01();
    while (phoneEnum.hasMoreElements()) {
      phoneDetail = phoneEnum.nextElement();
      if (CodesTables.CRSCPHON_01.equals(phoneDetail.getSzCdFacilPhoneType())) {
        break;
      }
    }

    facilityData.setSzNbrIncmgFacilPhone(phoneDetail.getLNbrFacilPhoneNumber());
    facilityData.setSzNbrIncmgFacilPhoneExt(phoneDetail.getLNbrFacilPhoneExtension());
    facilityData.setSzNmIncmgFacilSuprtdant(cres03so.getSzNmRsrcContact());
    
    facilityData.setSzNmIncmgFacilAffiliated(StringHelper.EMPTY_STRING);
    facilityData.setBIndIncmgFacilAbSupvd(StringHelper.EMPTY_STRING);
    facilityData.setBIndIncmgOnGrnds(StringHelper.EMPTY_STRING);
    facilityData.setSzNmUnitWard(StringHelper.EMPTY_STRING);
    facilityData.setSzTxtFacilCmnts(StringHelper.EMPTY_STRING);
    
    facilRtrvOutRec.setFacDetailEntStruct(facilityData);
    state.setAttribute("FacilRtrvOutRec", facilRtrvOutRec, request);

    request.setAttribute("resourceSearch", ArchitectureConstants.TRUE);

    performanceTrace.exitScope();
  }

  /**
   * This method will be called by the Person Search Relate function and will relate a person found during a person
   * search to an intake. It will check to make sure that the person we are trying to relate is not already involved
   * with the stage and it will also check to make sure the user is not trying to relate themselves. It the person
   * realted was an employee, an information message will appear telling the user an employee was related.
   * <p/>
   * <p/>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CINT08 - This service relates a person to a stage</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   */
  public void relatePerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".relatePerson_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // HttpSession session = context.getSession();

    // get the person to relate that is passed through the request from person search
    PrsnSearchOutRec relatedPerson = (PrsnSearchOutRec) request.getAttribute("relatedPerson");

    // get the selected row from the call person list
    PersListRtrvStruct person = (PersListRtrvStruct) state.getAttribute("personListRow", request);
    // check to make sure the person to relate is not already involved in the stage

    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }
    Enumeration<PersListRtrvStruct> enumeration = personListArray.enumeratePersListRtrvStruct();
    while (enumeration.hasMoreElements()) {
      PersListRtrvStruct row = enumeration.nextElement();
      if (row.getUlIdPerson() == relatedPerson.getUlIdPerson()) {
        setErrorMessage(Messages.MSG_INT_RELATE_SAME_STAGE, request);
        state.removeAllAttributes(request);
        return;
      }
    }

    // check to make sure the person to relate is not the user.
    if (relatedPerson.getUlIdPerson() == user.getUserID()) {
      setErrorMessage(Messages.MSG_CANT_RELATE_TO_WORKER, request);
      state.removeAllAttributes(request);
      return;
    }

    try {
      if ((relatedPerson.getUlIdPerson() == 0) || (person.getUlIdPerson() == 0)) {
        throw new RuntimeException();
      }
      // pass in the context, the personId, and the personIdRelated to the populate submethod
      RelatePersonInRec relatePersonInRec = populateRelatePersonInRec(context, person.getUlIdPerson(),
                                                                      relatedPerson.getUlIdPerson());
      RelatePersonOutRec relatePersonOutRec = intakeEjb.relatePerson(relatePersonInRec);

      ArchOutputStruct output = relatePersonOutRec.getArchOutputStruct();
      if (output == null) {
        output = new ArchOutputStruct();
      }

      // check to see if the person related was an employee by checking the dataInd
      // NOTE: This is a very peculiar way to use this indicator.
      if (ArchitectureConstants.Y.equals(output.getBMoreDataInd())) {
        setInformationalMessage(Messages.MSG_INT_RELATE_EMPLOYEE, ContextHelper.getPreviousUrl(request), request);
      }
      // Since you cannot view search results for a related person,
      // there is no use keeping the results in session
      String searchPerformedName = IntakeConstants.SEARCH_PERFORMED + person.getUlIdPerson();
      String searchResultsName = IntakeConstants.SEARCH_RESULTS + person.getUlIdPerson();
      String searchCriteriaName = IntakeConstants.SEARCH_CRITERIA + person.getUlIdPerson();
      String genderSpecifiedName = IntakeConstants.GENDER_SPECIFIED_BY_USER + person.getUlIdPerson();

      // session.removeAttribute(searchPerformedName);
      // session.removeAttribute(searchResultsName);
      // session.removeAttribute(searchCriteriaName);
      state.removeContextParameter(searchPerformedName, request);
      state.removeContextParameter(searchResultsName, request);
      state.removeContextParameter(searchCriteriaName, request);
      state.removeContextParameter(genderSpecifiedName, request);

      state.removeAllAttributes(request);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_INT_RELATE_ERROR:
        // !!! setPresentationBranch ???
        setPresentationBranch(ERROR_STRING, context);
        setErrorMessage(Messages.MSG_INT_RELATE_ERROR, request);
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

    performanceTrace.exitScope();
  }

  /**
   * This method will be called when the user selects a row from the Call Person List and selects Unrelate. It will
   * remove the related person from the Intake Stage and add the original person information back to the Intake.
   * 
   * @param context
   */
  public void unrelatePerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".unRelatePerson_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    autosaveCallInformation(context);

    // get the person out of the list
    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPerson");
    int index = Integer.parseInt(checkedValues[0]);

    // Get the Person List Array out of state and using the index we just found
    // get the person row in question out of the array.
    PersListRtrvStruct personListRow = null;
    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    if (index <= personListArray.getPersListRtrvStructCount()) {
      personListRow = personListArray.getPersListRtrvStruct(index);
    }
    if (personListRow == null) {
      personListRow = new PersListRtrvStruct();
    }
    try {
      // pass in the context and the personId to the populate submethod
      UnrelatePersonInRec unrelatePersonInRec = populateUnrelatePersonInRec(context, personListRow.getUlIdPerson());
      intakeEjb.saveUnrelatedPerson(unrelatePersonInRec);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will call the retrieve for the Incoming Person Detail information, then call the Address and Phone
   * Submodule Saves to invalidate any valid primary addresses and add the Incoming Person Detail Address and Phone info
   * as the new primary.
   * 
   * @param context
   */
  public void updateRelatedAddressPhoneInfo_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".updateRelatedAddressPhoneInfo_xa()");

    HttpServletRequest request = context.getRequest();

    try {

      // Call Incoming Person Detail retrieve
      ROWCINT52DO primaryIncPhone;
      ROWCINT48DO primaryIncAddress;
      ROWCINT51DO primaryIncDetail = new ROWCINT51DO();
      ROWCINT50DO_ARRAY primaryIncSSN = new ROWCINT50DO_ARRAY();
      CINT34SI cint34si = IncomingPersonDetailConversation.populateCINT34SI_Retrieve(context);
      CINT34SO cint34so = intakeEjb.retrieveIncomingPersonDetail(cint34si);
      if (cint34so == null) {
        cint34so = new CINT34SO();
      }
      primaryIncPhone = getPrimaryPhone(cint34so);
      if (primaryIncPhone == null) {
        primaryIncPhone = new ROWCINT52DO();
      }
      primaryIncAddress = getPrimaryAddress(cint34so);
      if (primaryIncAddress == null) {
        primaryIncAddress = new ROWCINT48DO();
      }

      // SIR 22534 - start
      // Call detail save
      if (cint34so.getROWCINT51DO() != null) {
        primaryIncDetail = cint34so.getROWCINT51DO();
      }
      if (cint34so.getROWCINT50DO_ARRAY() != null) {
        primaryIncSSN = cint34so.getROWCINT50DO_ARRAY();
      }
      detailSave(context, primaryIncDetail, primaryIncSSN);
      // SIR 22534 - end

      // Call the phone save if there is existing phone data
      if (primaryIncPhone.getSzCdIncmgPhoneType() != null
          && !StringHelper.EMPTY_STRING.equals(primaryIncPhone.getSzCdIncmgPhoneType())) {
        phoneSave(context, primaryIncPhone);
      }
      // Call the address save if there is existing address data
      if (primaryIncAddress.getSzCdIncmgAddrType() != null
          && !StringHelper.EMPTY_STRING.equals(primaryIncAddress.getSzCdIncmgAddrType())) {
        addressSave(context, primaryIncAddress);
      }

      redisplayCallPersonDetail(context);
    } catch (ServiceException we) {
      String errorMessage;
      // This errror is thrown by the populate method when the user
      // attempts to save a duplicate record. The service is
      // not actually called.
      if (we.getErrorCode() == Messages.MSG_DUPLICATE_RECORD) {
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
        setErrorMessage(errorMessage, request);
        return;
      }
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
        setErrorMessage(we.getErrorCode(), request);
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Save and Submit button on the Intake Actions page. It will Save the
   * Intake Actions page, validate the Intake calling the createErrorList() submethod, and then call the CINT02S AUD
   * service passing in cReqFuncCd == WtcHelper.REQ_FUNC_CD_SAVE_AND_SUBMIT.
   * <p/>
   * <p/>
   * The following services are called: <blockquote>
   * <ul>
   * <li>CINT25S - Call Decision/Call Entry Retrieve</li>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   */
  public void saveAndSubmitIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndSubmitIntake()");

    // STGAP00008020
    boolean bAllegationsExists = false;
    int allegationRows = 0;
    boolean hasActualErrors = false;
    // STGAP00008020

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      saveCallInformation(context, intakeEjb);

      // Populate the IntakeDataBean and pass it to the CreateErrorList.create() method.
      IntakeDataBean intake = PopulateDataBean.populate(context, intakeEjb);

      int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.SUBMIT_BUTTON);
      // Process the error list is any errors returned.
      if (errorArray.length > 0) {
        setPresentationBranch(ERROR_STRING, context);
        ErrorList.setErrors(errorArray, request);
        return;
      }

      // If we made it through the error list processing then we need to recall the cint12s save service
      // to save the intake to the workload passing in the SAVE_AND_SUBMIT function code.
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

      // ChooseCountryForAssignment
      String county = IntakeUtils.chooseCountyForAssignment(context, callDcsnAUD.getSzCdStageClassification(),
                                                            callEntrySvcStruct.getSzCdIncomingDisposition(),
                                                            facDetailEntStruct.getSzCdIncmgFacilCnty(),
                                                            callEntrySvcStruct.getSzCdIncomingCallerCounty(),
                                                            intake.getPersonlistarray());

      callEntrySvcStruct.setSzCdStageCnty(county);
      String region = FormattingHelper.convertRegionCode(Lookup.simpleDecodeSafe("CCNTYREG", county));
      callEntrySvcStruct.setSzCdStageRegion(region);
      String cdNonIncReqType = callEntrySvcStruct.getSzCdNonRsdntReqType();

      if (CodesTables.CNIRTYPE_IC.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_NI.equals(cdNonIncReqType)
          || CodesTables.CNIRTYPE_PA.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_PF.equals(cdNonIncReqType)) {
        callEntrySvcStruct.setSzCdStageReasonClosed(cdNonIncReqType);
      }

      // STGAP00008020
      // Validation for Allegation if it is a Non-Incident Request
      allegationRows = intake.getAllegListArray().getROWCINT76DOCount();
      bAllegationsExists = (allegationRows > 0) ? true : false;
      if (bAllegationsExists && StringHelper.isValid(cdNonIncReqType)) {
        hasActualErrors = true;
        setErrorMessage(Messages.MSG_INT_SAVE_NI_ALLEGS, request);
      }

      // Validation for Disposition if it is a Non-Incident Request
      String disposition = callEntrySvcStruct.getSzCdIncomingDisposition();
      // STGAP00008399: Added a check to see if the disposition is ACA, DIV, SCO, or SCR so that the error
      // message will be displayed only for those cases.
      boolean checkDisp = (CodesTables.CDISP_ACA.equals(disposition) || CodesTables.CDISP_DIV.equals(disposition)
                           || CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR.equals(disposition));
      if (StringHelper.isValid(cdNonIncReqType) && checkDisp) {
        hasActualErrors = true;
        setErrorMessage(Messages.MSG_INT_SAVE_NI_DISP, request);
      }

      // Validation for Determination Factors
      DetermListAUD determListAUD = callEntryRtrvOut.getDetermListAUD();

      // Add If condition to prevent Null Pointer Exception if nothing is selected in Determination Factors.
      if ((determListAUD != null) && (determListAUD.getSzCdIncmgDetermType_ARRAY() != null)) {
        String[] determinationFactors = determListAUD.getSzCdIncmgDetermType_ARRAY().getSzCdIncmgDetermType();

        if (StringHelper.isValid(cdNonIncReqType) && !(determinationFactors == null)) {
          hasActualErrors = true;
          setErrorMessage(Messages.MSG_INT_SAVE_NI_DETERM_FACTORS, request);
        }
      }

      // Validation for Response Time if it is a Non-Incident Request
      String initialResponseTime = callDcsnAUD.getSzCdStageInitialPriority();
      String currentResponseTime = callDcsnAUD.getSzCdStageCurrPriority();

      if (StringHelper.isValid(cdNonIncReqType)
          && (StringHelper.isValid(initialResponseTime) || (StringHelper.isValid(currentResponseTime)))) {
        hasActualErrors = true;
        setErrorMessage(Messages.MSG_INT_SAVE_NI_RESP_TIME, request);
      }

      if (hasActualErrors) {
        setPresentationBranch(ERROR_STRING, context);
        displayCallInformation(context);
        return;
      }
      // STGAP00008020

      if (CodesTables.CNIRTYPE_IC.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_NI.equals(cdNonIncReqType)
          || CodesTables.CNIRTYPE_PA.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_PF.equals(cdNonIncReqType)) {
        callEntrySvcStruct.setSzCdStageReasonClosed(cdNonIncReqType);
      }

      callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);

      // END POPULATE COUNTY

      CallEntryAUDOutRec callEntryAUDOutRec = PopulateDataBean.callCINT12S(callEntryAUDInRec, intakeEjb);

      CreateCallOutStruct out = callEntryAUDOutRec.getCreateCallOutStruct();

      GlobalData.setSzNmStage(GlobalData.getSzNmStage(request), request);

      ToDoDetailDB toDoDetailDB;

      if (!StringHelper.isValid(callEntrySvcStruct.getSzCdNonRsdntReqType())) {
        //  SMS# 60651 End dated the CD, SI and NF code and created CDNC, SINC and NFNC codes. Replaced the old ones with new ones.

        if ((CodesTables.CSPECREQ_CDNC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()) || CodesTables.CSPECREQ_CDIC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()))) {
          toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                          IntakeConstants.APPROVE_CALL_CD_TASK_CHILD_DEATH);
        } else if ((CodesTables.CSPECREQ_SINC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()) || CodesTables.CSPECREQ_SIIC.equals(callEntrySvcStruct.getSzCdSpclInvstgtn()))) {

          toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                          IntakeConstants.APPROVE_CALL_CD_TASK_SERIOUS_INJURY);

        } else {
          toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                          IntakeConstants.APPROVE_CALL_CD_TASK);
        }
      } else {

        toDoDetailDB = new ToDoDetailDB(out.getUlIdEvent(), out.getUlIdCase(), GlobalData.getUlIdStage(request),
                                        IntakeConstants.APPROVE_CALL_CD_TASK_NI);

      }

      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

      // The last thing we want to do before leaving this conversation is clear the async person
      // search results out of session.
      IntakeUtils.clearAsynchInfoFromSession(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Save and Assign button on the Intake Actions page. It will Save the
   * Intake Actions page, validate the Intake calling the createErrorList() submethod, and then call the CINT02S AUD
   * service passing in cReqFuncCd == WtcHelper.REQ_FUNC_CD_SAVE_AND_ASSIGN.
   * <p/>
   * <p/>
   * The following services are called: <blockquote>
   * <ul>
   * <li>CINT25S - Call Decision/Call Entry Retrieve</li>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   */
  public void saveAndAssignIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndAssignIntake_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    try {
      // Save the current data on Intake Actions.
      saveCallInformation(context, intakeEjb);

      // Populate the IntakeDataBean and pass it to the CreateErrorList.create() method.
      IntakeDataBean intake = PopulateDataBean.populate(context, intakeEjb);
      int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.ASSIGN_BUTTON);

      // Process the error list if any errors returned.
      if (errorArray.length > 0) {
        setPresentationBranch(ERROR_STRING, context);
        ErrorList.setErrors(errorArray, request);
        return;
      }

      CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
      if (callEntryRtrvOut == null) {
        callEntryRtrvOut = new CallEntryRtrvOut();
      }

      // Call the CINT12S save service
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

      // ChooseCountryForAssignment
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

      CallEntryAUDOutRec callEntryAUDOutRec = PopulateDataBean.callCINT12S(callEntryAUDInRec, intakeEjb);

      CreateCallOutStruct out = callEntryAUDOutRec.getCreateCallOutStruct();

      int[] stageIdArray = { GlobalData.getUlIdStage(request) };

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
      request.setAttribute(AssignConversation.STAGE_ID_ARRAY, stageIdArray);
      request.setAttribute(IntakeConstants.ASSIGN_INTAKE, ArchitectureConstants.TRUE);
      GlobalData.setSzCdStageProgram(callEntrySvcStruct.getSzCdStageProgram(), request);
      GlobalData.setUlIdPerson(user.getUserID(), request);
      GlobalData.setSzNmPersonFull(user.getUserFullName(), request);
      GlobalData.setUlIdStage(GlobalData.getUlIdStage(request), request);
      GlobalData.setUlIdCase(out.getUlIdCase(), request);
      GlobalData.setUlIdEvent(out.getUlIdEvent(), request);
      request.setAttribute(IntakeConstants.COUNTY, county);

      // The last thing we want to do before leaving this conversation is clear the async person
      // search results out of session.
      IntakeUtils.clearAsynchInfoFromSession(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Save and Close button on the Call Information page. It first saves
   * the Call Information page, then calls the createErrorList() submethod, and then calls the CINT02S AUD service
   * passing in cReqFuncCd == WtcHelper.REQ_FUNC_CD_SAVE_AND_CLOSE.
   * <p/>
   * We have to save the Call Information page first becuase the PopulateDataBean.populate
   * <p/>
   * <p/>
   * The following services are called: <blockquote>
   * <ul>
   * <li>CINT12S - Call Entry AUD - This is used to Save and Submit, Save and Assign, etc.</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   */
  public void saveAndCloseIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveAndCloseIntake_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    try {
      // Save the current data on Intake Actions.
      saveCallInformation(context, intakeEjb);

      // Populate the IntakeDataBean and pass it to the CreateErrorList.create() method.
      IntakeDataBean intake = PopulateDataBean.populate(context, intakeEjb);
      int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.CLOSE_BUTTON);

      // Process the error list is any errors returned.
      if (errorArray.length > 0) {
        setPresentationBranch(ERROR_STRING, context);
        ErrorList.setErrors(errorArray, request);
        return;
      }

      String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_SAVE_AND_CLOSE;

      CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
      if (callEntryRtrvOut == null) {
        callEntryRtrvOut = new CallEntryRtrvOut();
      }

      CallEntryAUDInRec callEntryAUDInRec = PopulateCallEntryAUDInRec.populate(context, callEntryRtrvOut, cReqFuncCd);

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

      // ChooseCountryForAssignment
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
      intakeEjb.saveCallEntry(callEntryAUDInRec);

      state.removeAllAttributes(request);
      // In all Save && Whatever methods we usually clear the async person search results.
      // This is not necessary in the Save && Close method because the async results are cleared
      // in the displayNewIntake method.

      displayNewIntake(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
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
    boolean hasActualErrors = false;
    // STGAP00008020

    HttpServletRequest request = context.getRequest();

    try {
      // Call the cint25s service to retrieve the Intake Incoming Status and the evnt status.
      // If the Intake Incoming Status is CLD or if the event status is already APRV
      // we do not want to call any of submittal services.
      CallEntryRtrvOut tempCallEntryRtrvOut = null;
      gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct tempCallEntryData = null;

      PopulateDataBean.populateCallEntryRtrvIn_Retrieve(context);
      tempCallEntryRtrvOut = PopulateDataBean.callCINT25S(context, intakeEjb);
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
        // saveIntakeActions(context, intakeEjb);
        saveCallInformation(context, intakeEjb);
        IntakeDataBean intake = PopulateDataBean.populate(context, intakeEjb);

        // START POPULATE COUNTY - The following code pertains to setting the new county
        // into the input object for the cint12s save.

        CallEntryRtrvOut callEntryRtrvOut = intake.getCallEntryDecision();
        if (callEntryRtrvOut == null) {
          callEntryRtrvOut = new CallEntryRtrvOut();
        }

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

        String cdNonIncReqType = callEntrySvcStruct.getSzCdNonRsdntReqType();
        
        // SMS #50402: Update the region and county values for the case
        callEntrySvcStruct.setSzCdStageCnty(county);
        String region = FormattingHelper.convertRegionCode(Lookup.simpleDecodeSafe("CCNTYREG", county));
        callEntrySvcStruct.setSzCdStageRegion(region);

        // STGAP00008020
        // Validation for Allegation if it is a Non-Incident Request
        allegationRows = intake.getAllegListArray().getROWCINT76DOCount();
        bAllegationsExists = (allegationRows > 0) ? true : false;

        if (bAllegationsExists && StringHelper.isValid(cdNonIncReqType) && (GlobalData.isApprovalMode(request))) {
          hasActualErrors = true;
          setErrorMessage(Messages.MSG_INT_SAVE_NI_ALLEGS, request);
        }

        // Validation for Disposition if it is a Non-Incident Request
        String disposition = callEntrySvcStruct.getSzCdIncomingDisposition();
        // STGAP00008399: Added a check to see if the disposition is ACA, DIV, SCO, or SCR so that the error
        // message will be displayed only for those cases.
        boolean checkDisp = (CodesTables.CDISP_ACA.equals(disposition) || CodesTables.CDISP_DIV.equals(disposition)
                             || CodesTables.CDISP_SCO.equals(disposition) || CodesTables.CDISP_SCR.equals(disposition));
        if ((GlobalData.isApprovalMode(request)) && StringHelper.isValid(cdNonIncReqType) && checkDisp) {
          hasActualErrors = true;
          setErrorMessage(Messages.MSG_INT_SAVE_NI_DISP, request);
        }

        // Validation for Determination Factors
        DetermListAUD determListAUD = callEntryRtrvOut.getDetermListAUD();

        // Add If condition to prevent Null Pointer Exception if nothing is selected in Determination Factors.
        if ((determListAUD != null) && (determListAUD.getSzCdIncmgDetermType_ARRAY() != null)) {
          String[] determinationFactors = determListAUD.getSzCdIncmgDetermType_ARRAY().getSzCdIncmgDetermType();

          if ((GlobalData.isApprovalMode(request)) && StringHelper.isValid(cdNonIncReqType)
              && !(determinationFactors == null)) {
            hasActualErrors = true;
            setErrorMessage(Messages.MSG_INT_SAVE_NI_DETERM_FACTORS, request);
          }
        }

        // Validation for Response Time if it is a Non-Incident Request
        String initialResponseTime = callDcsnAUD.getSzCdStageInitialPriority();
        String currentResponseTime = callDcsnAUD.getSzCdStageCurrPriority();

        if ((GlobalData.isApprovalMode(request)) && StringHelper.isValid(cdNonIncReqType)
            && (StringHelper.isValid(initialResponseTime) || (StringHelper.isValid(currentResponseTime)))) {
          hasActualErrors = true;
          setErrorMessage(Messages.MSG_INT_SAVE_NI_RESP_TIME, request);
        }

        if (hasActualErrors) {
          setPresentationBranch(ERROR_STRING, context);
          displayCallInformation(context);
          return;
        }
        // STGAP00008020

        if (CodesTables.CNIRTYPE_IC.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_NI.equals(cdNonIncReqType)
            || CodesTables.CNIRTYPE_PA.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_PF.equals(cdNonIncReqType)) {
          callEntrySvcStruct.setSzCdStageReasonClosed(cdNonIncReqType);
        }

        callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);

        saveCallInformation(context, intakeEjb);

        IntakeUtils.callCINT12SUpdateWorkload(context, intakeEjb);
        // int[] errorArray = CreateErrorList.create(intake, user, IntakeConstants.SUBMIT_BUTTON);
        // if (errorArray.length > 0) {
        // setPresentationBranch(ERROR_STRING, context);
        // ErrorList.setErrors(errorArray, request);
        // displayIntakeActions(context);
        // return;
        // }
      }
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This submethod will format a name and return the following: 1. If a first and last name exists, a full name in the
   * format Last, First Middle Initial. 2. If no first and last name exist and type = COL, a blank full name. 3. If no
   * first and last name exist and type = PRN, a full name in the following format - "Unknown #', where # is number of
   * unknowns that exists already + 1.
   * 
   * @param context
   * @return
   */
  private String formatName(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".formatUnknownName()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    String fullName;
    String first = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
    String middle = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));
    String last = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast"));

    if (!StringHelper.isValid(first) && !StringHelper.isValid(last)) {
      int numUnknown = 1;
      // Count the unknowns in the Call Person List
      PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                                 .getAttribute(
                                                                                               "PersListRtrvStruct_ARRAY",
                                                                                               request);

      if (personListArray == null) {
        personListArray = new PersListRtrvStruct_ARRAY();
      }

      if (personListArray != null) {
        Enumeration<PersListRtrvStruct> enumeration = personListArray.enumeratePersListRtrvStruct();
        while (enumeration.hasMoreElements()) {
          PersListRtrvStruct persListRow = enumeration.nextElement();
          String persName = persListRow.getSzNmPersonFull();
          if (persName.indexOf(IntakeConstants.UNKNOWN) >= 0) {
            numUnknown++;
          }
        }
      }
      fullName = IntakeConstants.NAME_UNKNOWN + " " + numUnknown;
    } else {
      fullName = FormattingHelper.formatFullName(first, middle, last);
    }

    performanceTrace.exitScope();
    return fullName;
  }

  /**
   * This is the populate for the Person List multiple update service.
   * 
   * @param context
   * @return
   */
  private MUpdInRec populateMUpdInRec(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateMUpdInRec()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    MUpdInRec multiplePersons = new MUpdInRec();
    MUpdStruct info = new MUpdStruct();
    SzNmPersonFull_ARRAY_CINT35SI fullNameArray = new SzNmPersonFull_ARRAY_CINT35SI();
    MUpdIDInStruct_ARRAY idArray = new MUpdIDInStruct_ARRAY();

    info.setSzNmNameLast(FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast")));
    String inLaw = ContextHelper.getStringSafe(request, "cbxBIndStagePersInLaw");
    if (StringHelper.EMPTY_STRING.equals(inLaw)) {
      inLaw = ArchitectureConstants.N;
    }

    info.setBIndStagePersInLaw(inLaw);
    info.setSzCdPersonLanguage(ContextHelper.getStringSafe(request, "selSzCdPersonLanguage"));

    /* SIR 24002 */
    info.setSzCdDisasterRlf(ContextHelper.getStringSafe(request, "selSzCdDisasterRlf"));
    /* SIR 24002 */

    info.setSzCdStagePersRelInt(ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt"));
    info.setSzCdStagePersRole(ContextHelper.getStringSafe(request, "selSzCdStagePersRole"));
    info.setSzCdStagePersType(ContextHelper.getStringSafe(request, "selSzCdStagePersType"));
    // Added new field Member of Primary Caretaker's Household
    info.setCdPKHouseholdMember(ContextHelper.getStringSafe(request, "selCdStagePersMbrPrimCareHhl"));

    AddressBean aapBean = AddressBean.getFromRequest(request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }

    info.setSzAddrPersAddrStLn1(aapBean.getAddress1());
    info.setSzAddrPersAddrStLn2(aapBean.getAddress2());
    info.setSzAddrCity(aapBean.getCity());
    info.setSzCdAddrState(aapBean.getState());
    info.setLAddrZip(aapBean.getZip());
    info.setSzCdAddrCounty(aapBean.getCounty());
    info.setSzCdPersAddrLinkType(ContextHelper.getStringSafe(request, "selSzCdPersAddrLinkType"));

    info.setLNbrPhone(ContextHelper.getPhoneSafe(request, "txtLBNbrPhone"));
    info.setLNbrPhoneExtension(ContextHelper.getPhoneSafe(request, "txtLNbrPhoneExtension"));
    info.setSzCdPhoneType(ContextHelper.getStringSafe(request, "selSzCdPhoneType"));
    info.setBIndPersCancelHist(ArchitectureConstants.Y);

    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    String[] checkedValues = (String[]) state.getAttribute("checkedValues", request);
    for (int i = 0; i < checkedValues.length; i++) {
      int index = Integer.parseInt(checkedValues[i]);
      PersListRtrvStruct person = personListArray.getPersListRtrvStruct(index);

      String currentLastName = ContextHelper.getStringSafe(request, "txtSzNmNameLast");
      if (!StringHelper.EMPTY_STRING.equals(currentLastName)) {
        fullNameArray.addSzNmPersonFull(FormattingHelper.formatFullName(person.getSzNmNameFirst(),
                                                                        person.getSzNmNameMiddle(), currentLastName));
      } else {
        fullNameArray.addSzNmPersonFull(person.getSzNmPersonFull());
      }

      MUpdIDInStruct idStruct = new MUpdIDInStruct();
      idStruct.setUlIdAddrPersonLink(person.getUlIdAddrPersonLink());
      idStruct.setUlIdPerson(person.getUlIdPerson());
      idStruct.setLdIdAddress(person.getLdIdAddress());
      idStruct.setUlIdPhone(person.getUlIdPhone());
      idStruct.setUlIdName(person.getUlIdName());
      idStruct.setUlIdStage(GlobalData.getUlIdStage(request));
      idArray.addMUpdIDInStruct(idStruct);
    }
    info.setSzNmPersonFull_ARRAY_CINT35SI(fullNameArray);
    multiplePersons.setMUpdIDInStruct_ARRAY(idArray);
    multiplePersons.setMUpdStruct(info);

    performanceTrace.exitScope();
    return multiplePersons;
  }

  /**
   * <p/>
   * There are three cases in which we call the cint12s service.
   * </p>
   * <ol>
   * <li>New Intakes when the user presses the Phone icon.</li>
   * <li>New Using cases when the page loads.</li>
   * <li>Regular saving of the Call Entry page.</li>
   * </ol>
   * We will call the populateCellEntryAUDInRec_noStageID() for all New Intakes. In addition, for New Intakes created
   * using "New Using", we will call populateExistingCallEntryInput()
   */
  private CallEntryAUDInRec populateCallEntryAUDInRec_noStageID(GrndsExchangeContext context, String cReqFuncCd)
                                                                                                                throws DataFormatException,
                                                                                                                MarshalException,
                                                                                                                ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace
                                                        .enterScope(TRACE_TAG, ".populateCellEntryAUDInRec_noStageID()");

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CallEntryAUDInRec callEntryAUDInRec = new CallEntryAUDInRec();
    ArchInputStruct input = new ArchInputStruct();
    CallEntrySvcStruct callEntrySvcStruct = new CallEntrySvcStruct();
    UnitStruct unitStruct = new UnitStruct();

    callEntryAUDInRec.setUlIdEmployee(UserProfileHelper.getUserProfile(request).getUserID());

    // 1. Populate input
    input.setCReqFuncCd(cReqFuncCd);

    // 2. Populate callEntrySvcStruct
    callEntrySvcStruct.setUlIdPerson(user.getUserID());
    callEntrySvcStruct.setSzNbrIncmgUnit(user.getUserUnit());
    callEntrySvcStruct.setSzCdIncmgRegion(FormattingHelper.convertRegionCode(user.getUserRegion()));

    String pageMode = PageMode.getPageMode(request);
    if (pageMode == null) {
      pageMode = PageModeConstants.VIEW;
    }

    if (pageMode.equals(PageModeConstants.Intake.NEW_USING_APS)
        || pageMode.equals(PageModeConstants.Intake.NEW_USING_CAR)
        || pageMode.equals(PageModeConstants.Intake.NEW_USING_CWA)
        || pageMode.equals(PageModeConstants.Intake.NEW_USING_OPEN)) {
      // We call the call entry retrieve service using the stage id that mike set into global data.
      // After we call the retrieve we want to clear the stage id.
      CallEntryRtrvOut callEntryRtrvOut = PopulateDataBean.callCINT25S(context, intakeEjb);
      GlobalData.setUlIdStage(0, request);

      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_SAVE;

      CallEntryAUDInRec callentry = PopulateCallEntryAUDInRec.populate(context, callEntryRtrvOut, cReqFuncCd);

      callEntrySvcStruct = callentry.getCallEntrySvcStruct();
      // JMC - SIR 18937 - The new ulIdPerson was not getting overwritten
      // in the above populate helper method. This resulted in the
      // new intake showing up on the workload of the
      // worker who recorded the original intake. Added
      // following line of code:
      callEntrySvcStruct.setUlIdPerson(user.getUserID());
      // JMC - SIR 18937 END

      // JMC - SIR 19026 - The ulIdCase from the existing Intake
      // was being retrieved and saved for the new Intake.
      callEntrySvcStruct.setUlIdCase(0);
      // JMC - SIR 19026 END

      // SIR 22467 - Need to blank out situation id so it dosent try to modify
      // an existing one for anothehr case.
      callEntrySvcStruct.setUlIdSituation(0);
      // SIR 22467 end

      // SIR 22327 - start
      // callEntrySvcStruct.setSzNmIncWkrName(user.getUserFullName());
      // callEntrySvcStruct.setSzAddrIncWkrCity(user.getUserOfficeCity());
      // SIR 22327 - end

      callEntrySvcStruct.setSzSysCdWinMode(pageMode);
      callEntrySvcStruct.setCdIncmgStatus(CodesTables.CINCMGST_OPN);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }

    // SIR 22327 - start - set the incoming worker id and office for all new intakes
    callEntrySvcStruct.setSzNmIncWkrName(user.getUserFullName());
    callEntrySvcStruct.setSzAddrIncWkrCity(user.getUserOfficeCity());
    callEntrySvcStruct.setSzCdIncmgWorkerRegion(user.getUserRegion());
    callEntrySvcStruct.setSzCdIncomingWorkerCounty(user.getUserCounty());

    // SIR 22327 - end

    // 3. Populate unitStruct
    unitStruct.setSzNbrUnit(user.getUserUnit());
    unitStruct.setSzCdUnitRegion(user.getUserRegion());
    unitStruct.setSzCdUnitProgram(user.getUserProgram());
    unitStruct.setSzCdUnitCounty(user.getUserCounty());

    // Set 1,2, and 3 into callEntryAUDInRec
    callEntryAUDInRec.setArchInputStruct(input);
    callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);
    callEntryAUDInRec.setUnitStruct(unitStruct);

    performanceTrace.exitScope();
    return callEntryAUDInRec;
  }

  private static CallEntryAUDInRec populateCallEntryAUDInRec(GrndsExchangeContext context) throws MarshalException,
                                                                                          ValidationException,
                                                                                          DataFormatException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCallEntryAUDInRec()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CallEntryAUDInRec callEntryAUDInRec = new CallEntryAUDInRec();
    ArchInputStruct input = new ArchInputStruct();
    UnitStruct unitStruct = new UnitStruct();

    callEntryAUDInRec.setUlIdEmployee(UserProfileHelper.getUserProfile(request).getUserID());

    // We should always pass in Save and Submit if the user is the approver.
    // This ensures that the pending approval does not get invalidated.
    String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_SAVE;
    if (GlobalData.isApprovalMode(request)) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT;
    }
    input.setCReqFuncCd(cReqFuncCd);

    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    unitStruct.setSzCdUnitProgram(user.getUserProgram());
    unitStruct.setSzNbrUnit(user.getUserUnit());
    unitStruct.setSzCdUnitRegion(user.getUserRegion());
    // STGAP00015116 - addition of unit county
    unitStruct.setSzCdUnitCounty(user.getUserCounty());

    CallEntrySvcStruct callEntrySvcStruct = populateCallEntrySvcStruct(context);
    // If the user is an approver we set WinMode to APPROVE to ensure that
    // the incoming status does not get invalidated.
    if (GlobalData.isApprovalMode(request)) {
      callEntrySvcStruct.setSzSysCdWinMode(PageModeConstants.APPROVE);
    }

    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);

    CallDcsnAUD callDcsnAUD = callEntryRtrvOut.getCallDcsnAUD();
    if (callDcsnAUD == null) {
      callDcsnAUD = new CallDcsnAUD();
    }

    callEntryAUDInRec.setSzCdEventStatus(callEntryRtrvOut.getSzCdEventStatus());
    callEntryAUDInRec.setSzCdStageCurrPriority(callDcsnAUD.getSzCdStageCurrPriority());

    // If we are in approval mode, we have to recalculate the county before we
    // save the intake. If we do not recalculate the county, it will be blanked out
    // on the workload.
    if (GlobalData.isApprovalMode(request)) {
      PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                                 .getAttribute(
                                                                                               "PersListRtrvStruct_ARRAY",
                                                                                               request);

      AddressBean facilityAddress = AddressBean.getFromRequest("facilityAddress", request);
      if (facilityAddress == null) {
        facilityAddress = new AddressBean();
      }

      String county = IntakeUtils.chooseCountyForAssignment(context, callDcsnAUD.getSzCdStageClassification(),
                                                            callEntrySvcStruct.getSzCdIncomingDisposition(),
                                                            facilityAddress.getCounty(),
                                                            callEntrySvcStruct.getSzCdIncomingCallerCounty(),
                                                            personListArray);
      callEntrySvcStruct.setSzCdStageCnty(county);
      String region = FormattingHelper.convertRegionCode(Lookup.simpleDecodeSafe("CCNTYREG", county));
      callEntrySvcStruct.setSzCdStageRegion(region);
    }

    callEntryAUDInRec.setArchInputStruct(input);
    callEntryAUDInRec.setUnitStruct(unitStruct);
    callEntryAUDInRec.setCallEntrySvcStruct(callEntrySvcStruct);
    performanceTrace.exitScope();

    return callEntryAUDInRec;
  }

  /** This is a helper method that is called to populate the main structure for the Call Entry save. */
  private static CallEntrySvcStruct populateCallEntrySvcStruct(GrndsExchangeContext context) throws MarshalException,
                                                                                            ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCallEntrySvcStruct()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);

    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct retrievedStruct = callEntryRtrvOut
                                                                                                    .getCallEntrySvcStruct();

    if (retrievedStruct == null) {
      retrievedStruct = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
    }

    String disposition = FormattingHelper.formatString(retrievedStruct.getSzCdIncomingDisposition());

    if (!StringHelper.EMPTY_STRING.equals(disposition)
        && (disposition.startsWith(IntakeConstants.NON_CASE_RELATED_PREFIX) || disposition
                                                                                          .startsWith(IntakeConstants.CASE_RELATED_SPECREQ_PREFIX))) {
      retrievedStruct.setSzCdSpclReq(disposition);
    } else if (!StringHelper.EMPTY_STRING.equals(disposition)) {
      retrievedStruct.setSzCdInfoAndRefrl(disposition);
    }

    // This was getting set to gibberish in the service so pass in null
    retrievedStruct.setTsIncmgCallDisp(null);

    CallDcsnAUD callDecision = callEntryRtrvOut.getCallDcsnAUD();
    if (callDecision == null) {
      callDecision = new CallDcsnAUD();
    }

    // First we make a carbon copy of what was retrieved
    CallEntrySvcStruct callentrysvcstruct = IntakeUtils.copyCallEntrySvcStructOutToIn(retrievedStruct);

    String callType = ContextHelper.getStringSafe(request, "callType");
    callentrysvcstruct.setSzCdIncomingCallType(callType);

    String txtNmIncomingCallerFirst = FormattingHelper
                                                      .changeCase(ContextHelper
                                                                               .getStringSafe(request,
                                                                                              "txtNmIncomingCallerFirst"));

    callentrysvcstruct.setNmIncomingCallerFirst(txtNmIncomingCallerFirst);

    String txtNmIncomingCallerMiddle = FormattingHelper
                                                       .changeCase(ContextHelper
                                                                                .getStringSafe(request,
                                                                                               "txtNmIncomingCallerMiddle"));

    callentrysvcstruct.setNmIncomingCallerMiddle(txtNmIncomingCallerMiddle);

    String txtNmIncomingCallerLast = FormattingHelper
                                                     .changeCase(ContextHelper.getStringSafe(request,
                                                                                             "txtNmIncomingCallerLast"));

    callentrysvcstruct.setNmIncomingCallerLast(txtNmIncomingCallerLast);

    String selCdIncomingCallerSuffix = ContextHelper.getStringSafe(request, "selCdIncomingCallerSuffix");
    callentrysvcstruct.setCdIncomingCallerSuffix(selCdIncomingCallerSuffix);

    String selszCdIncmgSex = ContextHelper.getStringSafe(request, "selszCdIncmgSex");
    callentrysvcstruct.setSzCdIncmgSex(selszCdIncmgSex);

    String selszCdIncmgCallerInt = ContextHelper.getStringSafe(request, "selszCdIncmgCallerInt");
    callentrysvcstruct.setSzCdIncmgCallerInt(selszCdIncmgCallerInt);

    String txtSzNmIncmgRegardingFirst = FormattingHelper
                                                        .changeCase(ContextHelper
                                                                                 .getStringSafe(request,
                                                                                                "txtSzNmIncmgRegardingFirst"));

    callentrysvcstruct.setSzNmIncmgRegardingFirst(txtSzNmIncmgRegardingFirst);

    String txtSzNmIncmgRegardingLast = FormattingHelper
                                                       .changeCase(ContextHelper
                                                                                .getStringSafe(request,
                                                                                               "txtSzNmIncmgRegardingLast"));

    callentrysvcstruct.setSzNmIncmgRegardingLast(txtSzNmIncmgRegardingLast);

    AddressBean aapBean = AddressBean.getFromRequest("callEntryAddress", request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }
    callentrysvcstruct.setSzAddrIncmgStreetLn1(aapBean.getAddress1());
    callentrysvcstruct.setSzAddrIncmgStreetLn2(aapBean.getAddress2());
    callentrysvcstruct.setSzAddrIncomingCallerCity(aapBean.getCity());
    callentrysvcstruct.setSzCdIncomingCallerState(aapBean.getState());
    callentrysvcstruct.setSzAddrIncmgZip(aapBean.getZipAndSuff());
    callentrysvcstruct.setSzCdIncomingCallerCounty(aapBean.getCounty());

    String selSzCdIncmgAddrType = ContextHelper.getStringSafe(request, "selSzCdIncmgAddrType");
    callentrysvcstruct.setSzCdIncmgAddrType(selSzCdIncmgAddrType);

    String txtSzNbrIncomingCallerPhone = ContextHelper.getPhoneSafe(request, "txtSzNbrIncomingCallerPhone");
    callentrysvcstruct.setSzNbrIncomingCallerPhone(txtSzNbrIncomingCallerPhone);

    String txtSzNbrIncmgCallerExt = ContextHelper.getStringSafe(request, "txtSzNbrIncmgCallerExt");
    callentrysvcstruct.setSzNbrIncmgCallerExt(txtSzNbrIncmgCallerExt);

    String selSzCdIncmgPhoneType = ContextHelper.getStringSafe(request, "selSzCdIncmgPhoneType");
    callentrysvcstruct.setSzCdIncmgPhoneType(selSzCdIncmgPhoneType);

    callentrysvcstruct.setSzCdIncmgAllegType(callDecision.getSzCdIncmgAllegType());

    callentrysvcstruct = PopulateCallEntryAUDInRec
                                                  .populateCallEntrySvcStructStageInfo(
                                                                                       callentrysvcstruct,
                                                                                       ContextHelper
                                                                                                    .getStringSafe(
                                                                                                                   request,
                                                                                                                   "selSzCdNonIncReqType"),
                                                                                       callDecision
                                                                                                   .getSzCdStageClassification(),
                                                                                       ContextHelper
                                                                                                    .getStringSafe(
                                                                                                                   request,
                                                                                                                   "selCdIncomingProgramType"),
                                                                                       ServiceConstants.REQ_FUNC_CD_SAVE,
                                                                                       callDecision
                                                                                                   .getSzCdIncmgAllegType(),
                                                                                       callDecision
                                                                                                   .getSzCdStageCurrPriority());
    // Ochumd - Sir 22961 if an SWI worker enters a P1, P2, or PN and submits it
    // to a supervisor for approval, and the supervisor decides the intake is
    // not a report and rejects it back to the worker so it can be changed to an
    // I&R, the SWI worker is unable to close it as an I&R. This is becuase, the
    // cdstage is not changed from int to I&R. As a result, the service does not
    // function properly.
    if (!StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "selSzCdInfoAndRefrl"))) {
      callentrysvcstruct.setSzCdStage("I&R");
    }
    // mcclaim, 06/16/2003, don't reset worker's information after initial save (NEW/NEW Using)
    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      callentrysvcstruct.setSzAddrIncWkrCity(user.getUserOfficeCity());
      callentrysvcstruct.setSzNmIncWkrName(user.getUserFullName());
      callentrysvcstruct.setSzCdIncmgWorkerRegion(user.getUserRegion());
      callentrysvcstruct.setSzCdIncomingWorkerCounty(user.getUserCounty());
    }
    callentrysvcstruct.setSzSysCdWinMode(PageMode.getPageMode(request));
    callentrysvcstruct.setSzNbrIncmgUnit(user.getUserUnit());
    // If the user is saving an intake with an incoming status SBA, we want to set the
    // incoming status to OPN to invalidate the approval unless the person is
    // the approver. In that case, we do not invalidate the incoming status.
    if (CodesTables.CINCMGST_SBA.equals(callentrysvcstruct.getCdIncmgStatus()) && !GlobalData.isApprovalMode(request)) {
      callentrysvcstruct.setCdIncmgStatus(CodesTables.CINCMGST_OPN);
    }
    callentrysvcstruct.setDtDtIncomingCall(ContextHelper.getCastorDateSafe(request, "dtDtIncomingCall"));
    callentrysvcstruct.setTmTmIncmgCall(ContextHelper.getTimeSafe(request, "txtTmTmIncmgCall"));
    String cdNonIncReqType = ContextHelper.getString(request, "selSzCdNonIncReqType");
    callentrysvcstruct.setSzCdNonRsdntReqType(cdNonIncReqType);
    callentrysvcstruct.setSzCdSpclInvstgtn(ContextHelper.getString(request, "selSzCdSplInvest"));
    callentrysvcstruct.setCIndCnfidntltyExplnd(ContextHelper.getString(request, "rdConfExpl"));
    callentrysvcstruct.setDtCnfidntltyExplntn(ContextHelper.getCastorDateSafe(request, "dtCnfidntltyExplntn"));
    callentrysvcstruct.setSzCdSpclCircumstances(ContextHelper.getString(request, "selSzCdSplCircum"));
    callentrysvcstruct.setUlIdResource(ContextHelper.getIntSafe(request, "idResource"));
    callentrysvcstruct.setSzCdStageClassification(ContextHelper.getStringSafe(request, "selSzCdStageClassification"));

    if (CodesTables.CNIRTYPE_IC.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_NI.equals(cdNonIncReqType)
        || CodesTables.CNIRTYPE_PA.equals(cdNonIncReqType) || CodesTables.CNIRTYPE_PF.equals(cdNonIncReqType)) {
      callentrysvcstruct.setSzCdStageReasonClosed(cdNonIncReqType);
    }

    // STGAP00008251 : In case of an IR Intake that was submitted for approval and then the supervisor
    // clicked SaveAndClose Button in the approval mode, we set the NmStage variable in
    // callentrysvcstruct object , so that the CaseName is populated in the Caps_Case table.
    if (CodesTables.CINCMGST_SBA.equals(callentrysvcstruct.getCdIncmgStatus()) && GlobalData.isApprovalMode(request)
        && CodesTables.CNIRTYPE_IR.equals(cdNonIncReqType)) {
      String szNmStage = GlobalData.getSzNmStage(request);
      callentrysvcstruct.setSzNmStage(szNmStage);
    }

    performanceTrace.exitScope();

    return callentrysvcstruct;
  }

  private static gov.georgia.dhr.dfcs.sacwis.structs.input.FacilityDetailInRec populateFacilityDetailInRec_Save(
                                                                                                                GrndsExchangeContext context)
                                                                                                                                             throws MarshalException,
                                                                                                                                             ValidationException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateFacilityDetailInRec_Save()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    FacilityDetailInRec facilitydetailinrec = new FacilityDetailInRec();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct facdetailentstruct = new gov.georgia.dhr.dfcs.sacwis.structs.input.FacDetailEntStruct(); // This
    // is
    // what
    // we
    // formerly
    // retrieved
    FacilRtrvOutRec facilRtrvOutRec = (FacilRtrvOutRec) state.getAttribute("FacilRtrvOutRec", request); // If
    // facilRtrvOutRec == null this means there is nothing in the request. So nothing was retrieved // from the database
    // in the last retrieve, therefore this must be a new facility detail, so we set //
    // cReqFuncCd to ADD. String
    String cReqFuncCd = StringHelper.EMPTY_STRING;
    if (StringHelper.isValid((String) state.getAttribute("facEntryExists", request))) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    } else {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }

    if (facilRtrvOutRec == null) {
      facilRtrvOutRec = new FacilRtrvOutRec();
    }
    gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct retrievedFacData = facilRtrvOutRec
                                                                                                    .getFacDetailEntStruct();
    if (retrievedFacData == null) {
      retrievedFacData = new gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct();
    }
    // Make a carbon copy of what we retrieved then
    // overwrite it with the new data entered on the jsp facdetailentstruct =
    IntakeUtils.copyFacDetailEntStructOutToIn(retrievedFacData); // Set the values for the ArchInputStruct
    input.setCReqFuncCd(cReqFuncCd);
    input.setSzUserId(user.getUserLogonID());

    facdetailentstruct.setUlIdStage(GlobalData.getUlIdStage(request));
    facdetailentstruct.setSzCdIncFacilOperBy(ContextHelper.getStringSafe(request, "selSzCdIncFacilOperBy"));
    String unsupervised = ContextHelper.getStringSafe(request, "cbxBIndIncmgFacilAbSupv");
    if (unsupervised.equals(ArchitectureConstants.Y)) {
      facdetailentstruct.setBIndIncmgFacilAbSupvd(ArchitectureConstants.Y);
    } else {
      facdetailentstruct.setBIndIncmgFacilAbSupvd(ArchitectureConstants.N);
    }

    String offGrounds = ContextHelper.getStringSafe(request, "cbxBIndIncmgOnGrnds");
    if (offGrounds.equals(ArchitectureConstants.Y)) {
      facdetailentstruct.setBIndIncmgOnGrnds(ArchitectureConstants.Y);
    } else {
      facdetailentstruct.setBIndIncmgOnGrnds(ArchitectureConstants.N);
    }

    String facilSearch = ContextHelper.getStringSafe(request, "hdnBIndIncmgFacilSearch"); // We want to set the search
    // indicator to Y if the user has performed a search in the past // or if a user is performing a search right now.
    if (facilSearch.equals(ArchitectureConstants.Y)
        || StringHelper.isValid(ContextHelper.getStringSafe(request, "btnFacilitySearch.y"))) {
      facdetailentstruct.setBIndIncmgFacilSearch(ArchitectureConstants.Y);
    } else {
      facdetailentstruct.setBIndIncmgFacilSearch(ArchitectureConstants.N);
    }

    AddressBean facilityAddress = AddressBean.getFromRequest("facilityAddress", request);
    if (facilityAddress == null) {
      facilityAddress = new AddressBean();
    }
    facdetailentstruct.setSzAddrIncmgFacilStLn1(facilityAddress.getAddress1());
    facdetailentstruct.setSzAddrIncmgFacilStLn2(facilityAddress.getAddress2());
    facdetailentstruct.setSzAddrIncmgFacilZip(facilityAddress.getZipAndSuff());
    facdetailentstruct.setSzCdIncmgFacilCnty(facilityAddress.getCounty());
    facdetailentstruct.setSzAddrIncmgFacilCity(facilityAddress.getCity());
    facdetailentstruct.setSzCdIncmgFacilState(facilityAddress.getState()); //
    
    //SMS 59296
    String txtNmIncmgFacilName = ContextHelper.getStringSafe(request, "txtNmIncmgFacilName");
    facdetailentstruct.setNmIncmgFacilName(txtNmIncmgFacilName);

    String previousFacilName = retrievedFacData.getNmIncmgFacilName();
    
    //SMS 59936 
    if(previousFacilName == null){
      previousFacilName = "";
    }
    
    //Check to see if the provider name is same as the one from the retrieved from the Search
    if(!previousFacilName.equals(txtNmIncmgFacilName)){
      //Use the resource Id from the request if the names are not same
      facdetailentstruct.setUlIdResource(ContextHelper.getIntSafe(request, "txtResourceId"));
    }else{
      //Else use the one retrieved from the Search
      facdetailentstruct.setUlIdResource(retrievedFacData.getUlIdResource());
    }
    
    String selSzCdIncmgFacilType = ContextHelper.getStringSafe(request, "selSzCdIncmgFacilType");
    facdetailentstruct.setSzCdIncmgFacilType(selSzCdIncmgFacilType);

    String txtSzNbrIncmgFacilPhone = ContextHelper.getPhoneSafe(request, "txtSzNbrIncmgFacilPhone");
    facdetailentstruct.setSzNbrIncmgFacilPhone(txtSzNbrIncmgFacilPhone);

    String txtSzNbrIncmgFacilPhoneExt = ContextHelper.getStringSafe(request, "txtSzNbrIncmgFacilPhoneExt");
    facdetailentstruct.setSzNbrIncmgFacilPhoneExt(txtSzNbrIncmgFacilPhoneExt);

    String txtSzNmUnitWard = ContextHelper.getStringSafe(request, "txtSzNmUnitWard");
    facdetailentstruct.setSzNmUnitWard(txtSzNmUnitWard);

    String txtSzNmIncmgFacilAffiliated = ContextHelper.getStringSafe(request, "txtSzNmIncmgFacilAffiliated");
    facdetailentstruct.setSzNmIncmgFacilAffiliated(txtSzNmIncmgFacilAffiliated);    

    String txtSzTxtFacilCmnts = ContextHelper.getStringSafe(request, "txtSzTxtFacilCmnts");
    facdetailentstruct.setSzTxtFacilCmnts(txtSzTxtFacilCmnts);

    String txtSzNmIncmgFacilSuprtdant = ContextHelper.getStringSafe(request, "txtSzNmIncmgFacilSuprtdant");
    facdetailentstruct.setSzNmIncmgFacilSuprtdant(txtSzNmIncmgFacilSuprtdant);

    facilitydetailinrec.setArchInputStruct(input);
    facilitydetailinrec.setFacDetailEntStruct(facdetailentstruct);

    performanceTrace.exitScope();
    return facilitydetailinrec;
  }

  /**
   * <p/>
   * This submethod populates the the input object that is passed to the Call Person Detail save service.
   * </p>
   * <p/>
   * It calls the following submethods to populate the input arrays for the submodules included on the page:
   * </p>
   * <blockquote>
   * <ul>
   * <li>populatePersListAudStruct()</li>
   * <li>populateRaceArray()</li>
   * <li>populateEthnicityArray()</li>
   * <li>populateAddressArray()</li>
   * <li>populatePhoneArray()</li>
   * <li>populateIDArray()</li>
   * <li>populateNameHistoryArray()</li>
   * </ul>
   * </blockquote>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  private PersListAudInRec populatePersListAudInRec_AUD(GrndsExchangeContext context) throws ServiceException,
                                                                                     ValidationException,
                                                                                     MarshalException,
                                                                                     IntrospectionException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populatePersListAudInRec_AUD()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // If the Intake has been submitted for approval and we are saving changes
    // and we are not the approver, we should update the workload to invalidate
    // the pending approval.
    String incomingStatus = (String) state.getAttribute("incomingStatus", request);
    if (CodesTables.CINCMGST_SBA.equals(incomingStatus) && !GlobalData.isApprovalMode(request)) {
      IntakeUtils.callCINT12SUpdateWorkload(context, intakeEjb);
      state.removeAttribute("incomingStatus", request);
    }

    // JMC - SIR 19332 - We recall the Person List Retrieve to ensure that
    // the user has the most up to date person information. During testing
    // the users were able to add multiple primary addresses and phones using
    // the Call Person Detail save, the back button, and the Address Detail
    // submodule (you don't even want to know how they achieved this). By passing
    // the most recent information to the populateXXX submethods, we ensure that
    // we will never ADD a new primary entry when one already exists.
    PersListRtrvStruct personListRow = retrievePersonRowFromList(context, intakeEjb);
    if (personListRow == null) {
      personListRow = new PersListRtrvStruct();
    }

    PersListAudInRec person = new PersListAudInRec();
    // If this is a new using, we want to clear the personListRow since all the
    // hasXXXchanged functions use personListRow as an indicator as to what has
    // been previously saved. In the instance of New Using, nothing has been
    // previously saved so personListRow should be blank.
    if (ContextHelper.getBooleanSafe(request, "newUsing")) {
      personListRow = new PersListRtrvStruct();
    }

    // POPULATE PERSON
    // In this segment we will populate the PersListAudStruct. This structure consists
    // mostly of the Name and Demographics section of the Call Person Detail Page. The
    // personDetail object also holds indicators that tell the service to update
    // Address, Phone, Name History, Person Identifiers, Race, and Ethnicity. We use
    // the hasXXXXchanged submethods to determine if the indicator should be set to YES
    // or NO. We will only populate the corresponding arrays if the data has changed since
    // the last save.
    String cReqFuncCd;
    if (personListRow.getUlIdPerson() != 0) {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    PersListAudStruct personDetail = populatePersListAudStruct(context, personListRow, cReqFuncCd);
    // The RaceEthnicityBean will calculate the person's Ethnicity Group for us. We get the bean out of
    // the request and set the value into the personDetail object. Then, instead of getting the
    // bean out of the request in the populateRaceArray() and populateEthnicityArray() helper methods,
    // we simply pass them reBean.
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    if (reBean == null) {
      reBean = new RaceEthnicityBean();
    }
    personDetail.setSzCdPersonEthnicGroup(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request));
    boolean bIndSsnConfirm = "true".equals(request.getParameter("hdnBIndSsnConfirm"));
    personDetail.setBIndSsnConfirm(bIndSsnConfirm);

    // ADDRESS LIST
    if (IntakeUtils.hasAddressChanged(context, personListRow)) {
      personDetail.setBScrIndAddrDataChange(ArchitectureConstants.Y);
      ROWCCMN44SIG00_ARRAY addressArray = populateAddressArray(context, personListRow);
      person.setROWCCMN44SIG00_ARRAY(addressArray);
    } else {
      personDetail.setBScrIndAddrDataChange(ArchitectureConstants.N);
    }

    // PHONE LIST
    if (IntakeUtils.hasPhoneChanged(context, personListRow)) {
      personDetail.setBScrIndPhoneDataChange(ArchitectureConstants.Y);
      ROWCCMN31SI_ARRAY phoneArray = populatePhoneArray(context, personListRow);
      person.setROWCCMN31SI_ARRAY(phoneArray);
    } else {
      personDetail.setBScrIndPhoneDataChange(ArchitectureConstants.N);
    }

    // RACE/ETHNICITY
    ROWCINT02SIG00_ARRAY raceArray = populateRaceArray(reBean);
    ROWCINT02SIG01_ARRAY ethnicityArray = populateEthnicityArray(reBean);
    if (IntakeUtils.hasRaceEthnicityChanged(raceArray, ethnicityArray)) {
      personDetail.setBScrIndRaceDataChange(ArchitectureConstants.Y);
      person.setROWCINT02SIG00_ARRAY(raceArray);
      person.setROWCINT02SIG01_ARRAY(ethnicityArray);
    } else {
      personDetail.setBScrIndRaceDataChange(ArchitectureConstants.N);
    }

    // PERSON IDENTIFIERS
    if (IntakeUtils.hasSSNchanged(context, personListRow, cReqFuncCd)) {
      personDetail.setBScrIndIDDataChange(ArchitectureConstants.Y);
      CINT14WLB_ARRAY idArray = populateIDArray(context, personListRow);
      person.setCINT14WLB_ARRAY(idArray);
    } else {
      personDetail.setBScrIndIDDataChange(ArchitectureConstants.N);
    }

    // NAME HISTORY
    if (IntakeUtils.hasNameChanged(context, personListRow)) {
      personDetail.setBScrIndNameDataChange(ArchitectureConstants.Y);
      ROWCINV26SIG00_ARRAY nameHistoryArray = populateNameHistoryArray(context, personListRow);
      person.setROWCINV26SIG00_ARRAY(nameHistoryArray);
    } else {
      personDetail.setBScrIndNameDataChange(ArchitectureConstants.N);
    }

    // SMS 57690 DOB Change
    if (IntakeUtils.hasDOBChanged(context, personListRow)) {
      personDetail.setBScrIndDOBDataChange(ArchitectureConstants.Y);
    } else {
      personDetail.setBScrIndDOBDataChange(ArchitectureConstants.N);
    }

    person.setPersListAudStruct(personDetail);
    performanceTrace.exitScope();
    return person;
  }

  /**
   * This submethod will get the ROWCINT52DO_ARRAY out of the CINT34SO object, enumerate through the ROWCINT52DO_ARRAY
   * and find the primary phone.
   * 
   * @param cint34so
   * @return
   */
  private ROWCINT52DO getPrimaryPhone(CINT34SO cint34so) {
    ROWCINT52DO_ARRAY rowcint52do_Array = cint34so.getROWCINT52DO_ARRAY();
    Enumeration<ROWCINT52DO> c = rowcint52do_Array.enumerateROWCINT52DO();
    while (c.hasMoreElements()) {
      ROWCINT52DO rowcint52doPrimary = c.nextElement();
      if (ArchitectureConstants.Y.equals(rowcint52doPrimary.getCIndIncmgPhonePrimary())
          && ArchitectureConstants.N.equals(rowcint52doPrimary.getCIndIncmgPhoneInvalid())) {
        return rowcint52doPrimary;
      }
    }
    return new ROWCINT52DO();
  }

  /**
   * This submethod will get the ROWCINT48DO_ARRAY out of the CINT34SO object, enumerate through the ROWCINT48DO_ARRAY
   * and find the primary address.
   * 
   * @param cint34so
   * @return
   */
  private ROWCINT48DO getPrimaryAddress(CINT34SO cint34so) {
    ROWCINT48DO_ARRAY rowcint48do_Array = cint34so.getROWCINT48DO_ARRAY();
    Enumeration<ROWCINT48DO> c = rowcint48do_Array.enumerateROWCINT48DO();
    while (c.hasMoreElements()) {
      ROWCINT48DO rowcint48doPrimary = c.nextElement();
      if (ArchitectureConstants.Y.equals(rowcint48doPrimary.getCIndIncmgAddrPrimary())
          && ArchitectureConstants.N.equals(rowcint48doPrimary.getCIndIncmgAddrInvalid())) {
        return rowcint48doPrimary;
      }
    }
    return new ROWCINT48DO();
  }

  /**
   * <p/>
   * This submethod is used to populate the input for the person detail save for the caller. This method is called by
   * the continueSaveCallEntry_xa activity method.
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  private PersListAudInRec populatePersListAudInRec_Caller(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace
                                                        .enterScope(TRACE_TAG, ".populatePersListAudInRec_CallerInfo()");

    HttpServletRequest request = context.getRequest();

    PersListAudInRec caller = new PersListAudInRec();
    PersListAudStruct callerInfo = new PersListAudStruct();
    ROWCCMN44SIG00_ARRAY addressArray = new ROWCCMN44SIG00_ARRAY();
    ROWCCMN44SIG00 address = new ROWCCMN44SIG00();
    ROWCCMN31SI_ARRAY phoneArray = new ROWCCMN31SI_ARRAY();
    ROWCCMN31SI phone = new ROWCCMN31SI();
    ROWCINV26SIG00_ARRAY nameArray = new ROWCINV26SIG00_ARRAY();
    ROWCINV26SIG00 name = new ROWCINV26SIG00();
    boolean nameHistoryEntry = true;

    String firstName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtNmIncomingCallerFirst"));

    String middleName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtNmIncomingCallerMiddle"));

    String lastName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtNmIncomingCallerLast"));

    callerInfo.setSzNmPersonFull(FormattingHelper.formatFullName(firstName, middleName, lastName));

    if (callerInfo.getSzNmPersonFull() == null || StringHelper.EMPTY_STRING.equals(callerInfo.getSzNmPersonFull())) {
      nameHistoryEntry = false;
      callerInfo.setSzNmPersonFull(IntakeConstants.REPORTER);
    }
    if (StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "selszCdIncmgSex"))) {
      callerInfo.setCCdPersonSex(CodesTables.CSEX_U);
    } else {
      callerInfo.setCCdPersonSex(ContextHelper.getStringSafe(request, "selszCdIncmgSex"));
    }
    callerInfo.setSzCdPersonLanguage(CodesTables.CLANG_EN);

    callerInfo.setBIndPersonDobApprox(ArchitectureConstants.N);
    callerInfo.setBIndStagePersReporter(ArchitectureConstants.Y);
    callerInfo.setSzCdNameSuffix(ContextHelper.getStringSafe(request, "selCdIncomingCallerSuffix"));
    callerInfo.setBIndStagePersInLaw(ArchitectureConstants.N);
    callerInfo.setBIndNamePrimary(ArchitectureConstants.Y);
    callerInfo.setUlIdStage(GlobalData.getUlIdStage(request));
    // Saving Person Type COL is only a workaround since we HAVE to enter a person type.
    // When the user views the Call Person Detail page for the caller or in re person
    // the person type will appear blank.
    callerInfo.setSzCdStagePersType(CodesTables.CPRSNTYP_COL);
    callerInfo.setCdPersonStatus(IntakeConstants.ACTIVE_STATUS);
    callerInfo.setSzCdCategoryCategory(IntakeConstants.CATEGORY_CAS);
    callerInfo.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    callerInfo.setBScrIndRaceDataChange(ArchitectureConstants.N);
    callerInfo.setBScrIndIDDataChange(ArchitectureConstants.N);
    callerInfo.setBScrIndNameDataChange(ArchitectureConstants.N);
    callerInfo.setBIndStagePersCaller(ArchitectureConstants.Y);
    callerInfo.setSzCdStagePersLstSort(IntakeConstants.CALLER_SORT);

    AddressBean aapBean = AddressBean.getFromRequest("callEntryAddress", request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }

    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdIncmgAddrType"))) {
      callerInfo.setBScrIndAddrDataChange(ArchitectureConstants.Y);
    } else {
      callerInfo.setBScrIndAddrDataChange(ArchitectureConstants.N);
    }

    address.setBIndPersAddrLinkPrimary(ArchitectureConstants.Y);
    address.setBIndPersAddrLinkInvalid(ArchitectureConstants.N);
    address.setSzCdPersAddrLinkType(ContextHelper.getStringSafe(request, "selSzCdIncmgAddrType"));
    address.setSzAddrPersAddrStLn1(aapBean.getAddress1());
    address.setSzAddrPersAddrStLn2(aapBean.getAddress2());
    address.setSzAddrCity(aapBean.getCity());
    address.setSzCdAddrState(aapBean.getState());
    address.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    address.setLAddrZip(aapBean.getZipAndSuff());
    address.setSzCdAddrCounty(aapBean.getCounty());
    address.setBSysIndAddrMedUpdate(ArchitectureConstants.N);

    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdIncmgPhoneType"))) {
      callerInfo.setBScrIndPhoneDataChange(ArchitectureConstants.Y);
    } else {
      callerInfo.setBScrIndPhoneDataChange(ArchitectureConstants.N);
    }
    phone.setSzCdPhoneType(ContextHelper.getStringSafe(request, "selSzCdIncmgPhoneType"));
    phone.setLNbrPhone(ContextHelper.getPhoneSafe(request, "txtSzNbrIncomingCallerPhone"));
    phone.setLNbrPhoneExtension(ContextHelper.getStringSafe(request, "txtSzNbrIncmgCallerExt"));
    phone.setBIndPersonPhonePrimary(ArchitectureConstants.Y);
    phone.setBIndPersonPhoneInvalid(ArchitectureConstants.N);
    phone.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);

    name.setSzCdNameSuffix(callerInfo.getSzCdNameSuffix());
    name.setBIndNameInvalid(ArchitectureConstants.N);
    name.setBIndNamePrimary(ArchitectureConstants.Y);
    name
        .setSzNmNameFirst(FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtNmIncomingCallerFirst")));
    name
        .setSzNmNameMiddle(FormattingHelper
                                           .changeCase(ContextHelper
                                                                    .getStringSafe(request, "txtNmIncomingCallerMiddle")));
    name.setSzNmNameLast(FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtNmIncomingCallerLast")));
    name.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);

    if (callerInfo.getBScrIndAddrDataChange().equals(ArchitectureConstants.Y)) {
      addressArray.addROWCCMN44SIG00(address);
    }

    phoneArray.addROWCCMN31SI(phone);

    if (nameHistoryEntry) {
      nameArray.addROWCINV26SIG00(name);
    }

    caller.setBSysIndUpdateFullName(ArchitectureConstants.N);
    caller.setBIndPersCancelHist(ArchitectureConstants.N);
    caller.setROWCCMN44SIG00_ARRAY(addressArray);
    caller.setROWCCMN31SI_ARRAY(phoneArray);
    caller.setROWCINV26SIG00_ARRAY(nameArray);
    caller.setPersListAudStruct(callerInfo);

    performanceTrace.exitScope();
    return caller;
  }

  /**
   * <p/>
   * This submethod is used to populate the input for the person detail save that saves the In RE information from the
   * call entry section of the page. This method is called by the continueSaveCallEntry_xa activity method.
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  private PersListAudInRec populatePersListAudInRec_InRe(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateInREPersonInfo()");

    HttpServletRequest request = context.getRequest();

    PersListAudInRec inREperson = new PersListAudInRec();
    PersListAudStruct inREinfo = new PersListAudStruct();
    ROWCINV26SIG00_ARRAY nameArray = new ROWCINV26SIG00_ARRAY();
    ROWCINV26SIG00 name = new ROWCINV26SIG00();

    String firstName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingFirst"));

    String lastName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingLast"));

    inREinfo.setSzNmPersonFull(FormattingHelper.formatFullName(firstName, StringHelper.EMPTY_STRING, lastName));

    inREinfo.setBIndStagePersReporter(ArchitectureConstants.N);
    inREinfo.setCCdPersonSex(IntakeConstants.UNKNOWN);
    inREinfo.setSzCdPersonLanguage(CodesTables.CLANG_EN);

    inREinfo.setBIndPersonDobApprox(ArchitectureConstants.N);
    inREinfo.setBIndNamePrimary(ArchitectureConstants.N);
    inREinfo.setUlIdStage(GlobalData.getUlIdStage(request));
    inREinfo.setCdPersonStatus(IntakeConstants.ACTIVE_STATUS);
    inREinfo.setSzCdCategoryCategory(IntakeConstants.CATEGORY_CAS);
    inREinfo.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    inREinfo.setBIndStagePersInLaw(ArchitectureConstants.N);
    inREinfo.setBScrIndAddrDataChange(ArchitectureConstants.N);
    inREinfo.setBScrIndPhoneDataChange(ArchitectureConstants.N);
    inREinfo.setBScrIndRaceDataChange(ArchitectureConstants.N);
    inREinfo.setBScrIndIDDataChange(ArchitectureConstants.N);
    inREinfo.setBScrIndNameDataChange(ArchitectureConstants.Y);
    // Saving Person Type COL is only a workaround since we HAVE to enter a person type.
    // When the user views the Call Person Detail page for the caller or in re person
    // the person type will appear blank.
    inREinfo.setSzCdStagePersType(CodesTables.CPRSNTYP_COL);
    inREinfo.setSzCdStagePersLstSort(IntakeConstants.OTHER_SORT);

    name.setBIndNameInvalid(ArchitectureConstants.N);
    name.setBIndNamePrimary(ArchitectureConstants.Y);
    name
        .setSzNmNameFirst(FormattingHelper
                                          .changeCase(ContextHelper
                                                                   .getStringSafe(request, "txtSzNmIncmgRegardingFirst")));

    name
        .setSzNmNameLast(FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmIncmgRegardingLast")));

    name.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    nameArray.addROWCINV26SIG00(name);

    inREperson.setBSysIndUpdateFullName(ArchitectureConstants.N);
    inREperson.setBIndPersCancelHist(ArchitectureConstants.N);
    inREperson.setROWCINV26SIG00_ARRAY(nameArray);
    inREperson.setPersListAudStruct(inREinfo);

    performanceTrace.exitScope();
    return inREperson;
  }

  /**
   * POPULATE PERSON DETAIL AUD
   * <p/>
   * In this segment we will populate the PersListAudStruct. This structure consists mostly of the Name and Demographics
   * section of the Call Person Detail Page.
   * 
   * @param context
   * @param personListRow
   * @return
   */
  private PersListAudStruct populatePersListAudStruct(GrndsExchangeContext context, PersListRtrvStruct personListRow,
                                                      String cReqFuncCd) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populatePersListAudStruct()");

    HttpServletRequest request = context.getRequest();

    PersListAudStruct personDetail = new PersListAudStruct();

    // If we are attempting to add a new principal, we call the formatName helper method.
    // If this is a new person of type principal and no name info has been entered,
    // formatName will return UnknownXXX.
    if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)
        && ContextHelper.getStringSafe(request, "selSzCdStagePersType").equals(CodesTables.CPRSNTYP_PRN)) {
      personDetail.setSzNmPersonFull(formatName(context));
    } else {
      String firstName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
      String middleName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));
      String lastName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast"));

      // SMS 57690 Duplicate person message should display when Last Name, First Name and/or DOB is changed for already
      // saved person
      personDetail.setSzNmNameFirst(firstName);
      personDetail.setSzNmNameLast(lastName);

      personDetail.setSzNmPersonFull(FormattingHelper.formatFullName(firstName, middleName, lastName));
    }

    // If we have entered reporter or unknown for full name we do not want to
    // overwrite it with null on resave.
    // Example: User adds a prn without a name. On initial save the SzNmPersonFull will be set correctly
    // to Unknown1 in the initial if. If the user attempts to resave the Unknown1 record without entering any name
    // information, the second time through the ELSE logic will be executed. Now, after the else
    // logic has completed, if personDetail.setSzNmPersonFull() is null we need to resave what
    // was initially passed in for full name (personListRow.getSzNmPersonFull) in case it was Unknown1.
    if ((personDetail.getSzNmPersonFull() == null)
        || (StringHelper.EMPTY_STRING.equals(personDetail.getSzNmPersonFull()))) {
      personDetail.setSzNmPersonFull(personListRow.getSzNmPersonFull());
    }

    personDetail.setSzCdNameSuffix(ContextHelper.getStringSafe(request, "selSzCdNameSuffix"));
    personDetail.setSzCdStagePersType(ContextHelper.getStringSafe(request, "selSzCdStagePersType"));
    personDetail.setSzCdStagePersRole(ContextHelper.getStringSafe(request, "selSzCdStagePersRole"));
    personDetail.setSzCdStagePersRelInt(ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt"));
    personDetail.setBIndStagePersReporter(CheckboxHelper.getCheckboxValue(request, "cbxBIndStagePersReporter"));
    // STGAP00015485: MR-056 Added new field Member of Primary Caretaker's Household
    personDetail.setCdPKHouseholdMember(ContextHelper.getStringSafe(request, "selCdStagePersMbrPrimCareHhl"));
    personDetail.setBIndStagePersInLaw(CheckboxHelper.getCheckboxValue(request, "cbxBIndStagePersInLaw"));

    // Set the date of birth into the input object then check to see if it is null. if the date of
    // birth has been entered, we will overwrite any age info entered on the page with the age calculated
    // from date of birth. If no date of birth was entered, save the age as it was entered on the page.
    // If there was an age entered (and no date of birth), calculate the date of birth using age.
    personDetail.setDtDtPersonBirth(ContextHelper.getCastorDateSafe(request, "txtDateDtPersonBirth"));
    if (personDetail.getDtDtPersonBirth() != null) {
      personDetail.setLNbrPersonAge(DateHelper.getAge(personDetail.getDtDtPersonBirth()));
      personDetail.setBIndPersonDobApprox(ArchitectureConstants.N);
    } else {
      personDetail.setBIndPersonDobApprox(null);
      personDetail.setLNbrPersonAge(ContextHelper.getIntSafe(request, "txtLNbrPersonAge"));
      if (personDetail.getLNbrPersonAge() != 0) {
        org.exolab.castor.types.Date txtLNbrPersonAge = DateHelper
                                                                  .getCastorDateFromAge(ContextHelper
                                                                                                     .getIntSafe(
                                                                                                                 request,
                                                                                                                 "txtLNbrPersonAge"));
        personDetail.setDtDtPersonBirth(txtLNbrPersonAge);
        personDetail.setBIndPersonDobApprox(ArchitectureConstants.Y);
      }
    }
    personDetail.setDtDtPersonDeath(ContextHelper.getCastorDateSafe(request, "txtDateDtPersonDeath"));

    String selSzCdPersonMaritalStatus = ContextHelper.getStringSafe(request, "selSzCdPersonMaritalStatus");
    personDetail.setSzCdPersonMaritalStatus(selSzCdPersonMaritalStatus);

    if (StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "selCdPersonSex"))) {
      personDetail.setCCdPersonSex(CodesTables.CSEX_U);
    } else {
      personDetail.setCCdPersonSex(ContextHelper.getStringSafe(request, "selCdPersonSex"));
    }

    personDetail.setSzCdPersonLanguage(ContextHelper.getStringSafe(request, "selSzCdPersonLanguage"));
    /* SIR 24002 */
    personDetail.setSzCdDisasterRlf(ContextHelper.getStringSafe(request, "selSzCdDisasterRlf"));
    /* SIR 24002 */
    personDetail.setSzTxtStagePersNotes(ContextHelper.getStringSafe(request, "txtSzTxtStagePersNotes"));
    // personDetail.setSzCdStagePersSearchInd(personListRow.getSzCdStagePersSearchInd());
    personDetail.setBIndNamePrimary(ArchitectureConstants.N);

    // While it would make sense to use the StagePersCaller indicator to tell if
    // the person was the Caller, it appears that when the services were originally
    // coded this indicator was not utilized. Instead, the PersLstSort variable
    // was used to determine whether the person was the caller or not. The StagePersCaller
    // indicator is not even returned from the service so we must use the PersLstSort.
    // This is important because if the person was the caller and the intake is not marked
    // as an IR or NCRSR, the user is not allowed to uncheck the "reporter" checkbox - which
    // translates into the user not being able to delete the caller.
    String sortType;
    if (personListRow.getSzCdStagePersLstSort() != null
        && personListRow.getSzCdStagePersLstSort().equals(IntakeConstants.CALLER_SORT)) {
      personDetail.setBIndStagePersCaller(ArchitectureConstants.Y);
      sortType = IntakeConstants.CALLER_SORT;
    } else {
      personDetail.setBIndStagePersCaller(ArchitectureConstants.N);
      if (personDetail.getBIndStagePersReporter() != null
          && personDetail.getBIndStagePersReporter().equals(ArchitectureConstants.Y)) {
        sortType = IntakeConstants.REPORTER_SORT;
      } else {
        sortType = IntakeConstants.OTHER_SORT;
      }
    }
    personDetail.setSzCdStagePersLstSort(sortType);
    personDetail.setLSysNbrUniqueLBKey(100);
    personDetail.setUlIdStage(GlobalData.getUlIdStage(request));
    personDetail.setUlIdPerson(GlobalData.getUlIdPerson(request));
    personDetail.setCdPersonStatus(IntakeConstants.ACTIVE_STATUS);
    personDetail.setSzCdCategoryCategory(IntakeConstants.CATEGORY_CAS);
    personDetail.setSzCdScrDataAction(cReqFuncCd);
    // Since we have access to the RaceEthnicityBean in the populatePersListAudInRec_AUD() method
    // that calls this method, we populate SzCdPersonEthnicGroup in the parent method
    // instead of passing populatePersListAudStruct() the RaceEthnicityBean.
    // personDetail.setSzCdPersonEthnicGroup();

    // JMC - SIR 17449 - We are no longer saving the "L" value from the person
    // detail page. If the user has checked the person search indicator checkbox,
    // we clear the value that has been saved to the database (unless the person
    // has been related) and the JSP will calculate whether to display "L" or not.
    if (!CodesTables.CSRCHSTA_R.equals(personListRow.getSzCdStagePersSearchInd())
        && (ArchitectureConstants.Y).equals(ContextHelper.getStringSafe(request, "cbxSzCdStagePersSearchInd"))) {
      personDetail.setSzCdStagePersSearchInd(StringHelper.EMPTY_STRING);
      // personDetail.setSzCdStagePersSearchInd("L");
    } else {
      personDetail.setSzCdStagePersSearchInd(personListRow.getSzCdStagePersSearchInd());
    }

    personDetail.setSzCdIncmgPersTitle(ContextHelper.getStringSafe(request, "selTitle"));
    personDetail.setSzCdPersonDeath(ContextHelper.getStringSafe(request, "selSzCdStageResForDeath"));
    personDetail.setBIndPersonDobApprox(ContextHelper.getStringSafe(request, "cbxBlndStageApprox"));
    personDetail.setSzCdIncmgPersMatchType(ContextHelper.getStringSafe(request, "selSzCdMatchtype"));
    personDetail.setSzCdIncmgPersPrfCitizenship(ContextHelper.getStringSafe(request, "selProofCtnshp"));
    personDetail.setCIndIncmgPersUsCitizen(ContextHelper.getStringSafe(request, "chkUsCitizen"));
    personDetail.setSzCdIncmgPersImmgrtnStatus(ContextHelper.getStringSafe(request, "selImmgrtnStatus"));
    personDetail.setSzCdIncmgPersCntryOrigin(ContextHelper.getStringSafe(request, "selCountryOfOrigin"));
    personDetail.setUlIdSecondaryCareGiver(ContextHelper.getIntSafe(request, "selSecondaryCaretaker"));
    personDetail.setSzTxtStagePersOthRelations(ContextHelper.getStringSafe(request, "txtOtherRelationships"));

    performanceTrace.exitScope();
    return personDetail;
  }

  /**
   * POPULATE PERSON DETAIL AUD - FROM LIST
   * <p/>
   * In this segment we will populate the PersListAudStruct using a person list row from the Call Person List. This
   * structure consists mostly of the Name and Demographics section of the Call Person Detail Page.
   * 
   * @param context
   * @param personListRow
   * @return
   */
  private static PersListAudStruct populatePersListAudStructFromList(GrndsExchangeContext context,
                                                                     PersListRtrvStruct personListRow, String cReqFuncCd) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populatePersListAudStructFromList()");

    HttpServletRequest request = context.getRequest();

    PersListAudStruct personDetail = new PersListAudStruct();

    personDetail.setSzNmPersonFull(personListRow.getSzNmPersonFull());
    personDetail.setSzCdNameSuffix(personListRow.getSzCdNameSuffix());
    personDetail.setSzCdStagePersType(personListRow.getSzCdStagePersType());
    personDetail.setSzCdStagePersRole(personListRow.getSzCdStagePersRole());
    personDetail.setSzCdStagePersRelInt(personListRow.getSzCdStagePersRelInt());
    // Added new field Member of Primary Caretaker's Household
    personDetail.setCdPKHouseholdMember(personListRow.getCdPKHouseholdMember());
    personDetail.setBIndStagePersReporter(personListRow.getBIndStagePersReporter());
    personDetail.setBIndStagePersInLaw(personListRow.getBIndStagePersInLaw());

    personDetail.setDtDtPersonBirth(personListRow.getDtDtPersonBirth());
    personDetail.setLNbrPersonAge(personListRow.getLNbrPersonAge());
    personDetail.setDtDtPersonDeath(personListRow.getDtDtPersonDeath());
    personDetail.setSzCdPersonMaritalStatus(personListRow.getSzCdPersonMaritalStatus());
    personDetail.setCCdPersonSex(personListRow.getCCdPersonSex());
    personDetail.setSzCdPersonLanguage(personListRow.getSzCdPersonLanguage());
    /* SIR 24002 */
    personDetail.setSzCdDisasterRlf(personListRow.getSzCdDisasterRlf());
    /* END SIR 24002 */
    personDetail.setSzTxtStagePersNotes(personListRow.getSzTxtStagePersNotes());
    personDetail.setSzCdStagePersSearchInd(personListRow.getSzCdStagePersSearchInd());
    personDetail.setBIndNamePrimary(ArchitectureConstants.N);
    personDetail.setBIndStagePersCaller(personListRow.getBIndStagePersCaller());
    personDetail.setSzCdStagePersLstSort(personListRow.getSzCdStagePersLstSort());
    personDetail.setLSysNbrUniqueLBKey(100);
    personDetail.setBIndPersonDobApprox(ArchitectureConstants.N);
    personDetail.setUlIdStage(GlobalData.getUlIdStage(request));
    personDetail.setUlIdPerson(personListRow.getUlIdPerson());
    personDetail.setCdPersonStatus(IntakeConstants.ACTIVE_STATUS);
    personDetail.setSzCdCategoryCategory(IntakeConstants.CATEGORY_CAS);
    personDetail.setSzCdScrDataAction(cReqFuncCd);
    personDetail.setSzCdPersonEthnicGroup(personListRow.getSzCdPersonEthnicGroup());

    performanceTrace.exitScope();
    return personDetail;
  }

  /**
   * POPULATE ADDRESS
   * <p/>
   * We will populate the address array with the primary address information entered in the common/AddressSub.jsp
   * include portion of Call Person Detail. The user must use the Address List Detail page to modify any other address
   * information.
   * 
   * @param context
   * @param personListRow
   * @return
   */
  private ROWCCMN44SIG00_ARRAY populateAddressArray(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateAddressArray()");

    HttpServletRequest request = context.getRequest();

    ROWCCMN44SIG00_ARRAY addressArray = new ROWCCMN44SIG00_ARRAY();
    ROWCCMN44SIG00 address = new ROWCCMN44SIG00();
    AddressBean aapBean = AddressBean.getFromRequest(request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }
    address.setBIndPersAddrLinkPrimary(ArchitectureConstants.Y);
    String linkInvalid = personListRow.getBIndPersAddrLinkInvalid();
    if (linkInvalid == null) {
      linkInvalid = ArchitectureConstants.N;
    }
    address.setBIndPersAddrLinkInvalid(linkInvalid);
    address.setSzCdPersAddrLinkType(ContextHelper.getStringSafe(request, "selSzCdPersAddrLinkType"));
    address.setSzAddrPersAddrStLn1(aapBean.getAddress1());
    address.setSzAddrPersAddrStLn2(aapBean.getAddress2());
    address.setSzAddrCity(aapBean.getCity());
    address.setSzCdAddrState(aapBean.getState());
    address.setLAddrZip(aapBean.getZipAndSuff());
    address.setSzCdAddrCounty(aapBean.getCounty());
    address.setLdIdAddress(personListRow.getLdIdAddress());
    address.setUlIdAddrPersonLink(personListRow.getUlIdAddrPersonLink());
    address.setDtDtPersAddrLinkStart(personListRow.getDtDtPersAddrLinkStart());
    address.setDtDtPersAddrLinkEnd(personListRow.getDtDtPersAddrLinkEnd());
    address.setSzTxtPersAddrCmnts(personListRow.getSzTxtPersAddrCmnts());
    address.setBSysIndAddrMedUpdate(ArchitectureConstants.N);

    if ((personListRow.getSzCdPersAddrLinkType() == null)
        || (StringHelper.EMPTY_STRING.equals(personListRow.getSzCdPersAddrLinkType()))) {
      address.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      address.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    addressArray.addROWCCMN44SIG00(address);

    performanceTrace.exitScope();
    return addressArray;
  }

  /**
   * POPULATE RACE ARRAY
   * 
   * @param reBean
   * @return
   */
  private ROWCINT02SIG00_ARRAY populateRaceArray(RaceEthnicityBean reBean) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateRaceArray()");

    ROWCINT02SIG00_ARRAY raceArray = new ROWCINT02SIG00_ARRAY();

    RaceEthnicityBean.Races races = reBean.getRaces();

    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
      ROWCINT02SIG00 raceRow = new ROWCINT02SIG00();
      raceRow.setSzCdPersonRace(race.getValue());
      raceRow.setSzCdScrDataAction(race.getActionCode());
      raceArray.addROWCINT02SIG00(raceRow);
    }

    performanceTrace.exitScope();
    return raceArray;
  }

  /**
   * POPULATE NAME HISTORY
   * <p/>
   * Any time there is a name entered in the Name section of Call Person Detail we will populate the Name History Array
   * to save the new or updated Name to the database.
   * 
   * @param context
   * @param personListRow
   * @return
   */
  private ROWCINV26SIG00_ARRAY populateNameHistoryArray(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateNameHistoryArray()");

    HttpServletRequest request = context.getRequest();

    ROWCINV26SIG00_ARRAY nameHistoryArray = new ROWCINV26SIG00_ARRAY();
    ROWCINV26SIG00 nameHistory = new ROWCINV26SIG00();

    nameHistory.setSzCdNameSuffix(ContextHelper.getStringSafe(request, "selSzCdNameSuffix"));
    nameHistory.setBIndNameInvalid(ArchitectureConstants.N);
    nameHistory.setBIndNamePrimary(ArchitectureConstants.Y);

    String txtSzNmNameFirst = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
    nameHistory.setSzNmNameFirst(txtSzNmNameFirst);

    String txtSzNmNameLast = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast"));
    nameHistory.setSzNmNameLast(txtSzNmNameLast);

    String txtSzNmNameMiddle = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));
    nameHistory.setSzNmNameMiddle(txtSzNmNameMiddle);

    // If this is a new name set the data action to ADD, otherwise set it to UPDATE
    String previousFirstName = personListRow.getSzNmNameFirst();
    String previousMiddleName = personListRow.getSzNmNameMiddle();
    String previousLastName = personListRow.getSzNmNameLast();
    String previousSuffix = personListRow.getSzCdNameSuffix();

    if (((previousFirstName == null) || (StringHelper.EMPTY_STRING.equals(previousFirstName)))
        && ((previousMiddleName == null) || (StringHelper.EMPTY_STRING.equals(previousMiddleName)))
        && ((previousLastName == null) || (StringHelper.EMPTY_STRING.equals(previousLastName)))
        && ((previousSuffix == null) || (StringHelper.EMPTY_STRING.equals(previousSuffix)))
        && (IntakeUtils.hasNameChanged(context, personListRow))) {
      nameHistory.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      nameHistory.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    nameHistory.setUlIdName(personListRow.getUlIdName());
    nameHistory.setUlIdPerson(GlobalData.getUlIdPerson(request));

    nameHistoryArray.addROWCINV26SIG00(nameHistory);

    performanceTrace.exitScope();

    return nameHistoryArray;
  }

  /**
   * POPULATE ETHNICITY ARRAY
   * 
   * @param reBean
   * @return
   */
  private ROWCINT02SIG01_ARRAY populateEthnicityArray(RaceEthnicityBean reBean) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateEthnicityArray()");

    ROWCINT02SIG01_ARRAY ethnicityArray = new ROWCINT02SIG01_ARRAY();

    // If the old ethnicity is equivalant to the new ethnicity
    // no need to resave the information. If they are not equal,
    // add the new Eth. The DAM automatically deletes the old eth.
    String ethnicity = reBean.getEthnicity();
    if (!ethnicity.equals(reBean.getOldEthnicity())) {
      ROWCINT02SIG01 ethRow = new ROWCINT02SIG01();
      ethRow.setSzCdPersonEthnicity(ethnicity);
      ethRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      ethnicityArray.addROWCINT02SIG01(ethRow);
    }

    performanceTrace.exitScope();
    return ethnicityArray;
  }

  /**
   * POPULATE PHONE ARRAY
   * <p/>
   * We will populate the phone array with the phone information entered in the phone section of Call Person Detail. The
   * user must use the Phone page to modify any other phone information.
   * 
   * @param context
   * @param personListRow
   * @return
   */
  private ROWCCMN31SI_ARRAY populatePhoneArray(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populatePhoneArray()");

    HttpServletRequest request = context.getRequest();

    // boolean saveIncomingInfo = false;

    ROWCCMN31SI_ARRAY phoneArray = new ROWCCMN31SI_ARRAY();
    ROWCCMN31SI phone = new ROWCCMN31SI();

    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "selSzCdPhoneType"))) {
      phone.setSzCdPhoneType(ContextHelper.getStringSafe(request, "selSzCdPhoneType"));
      phone.setLNbrPhone(ContextHelper.getPhoneSafe(request, "txtLBNbrPhone"));
      phone.setLNbrPhoneExtension(ContextHelper.getStringSafe(request, "txtLNbrPhoneExtension"));
      phone.setDtDtPersonPhoneStart(personListRow.getDtDtPersonPhoneStart());
      phone.setDtDtPersonPhoneEnd(personListRow.getDtDtPersonPhoneEnd());
      phone.setBIndPersonPhonePrimary(ArchitectureConstants.Y);

      String phoneInvalid = FormattingHelper.formatString(personListRow.getBIndPersonPhoneInvalid());
      if (StringHelper.EMPTY_STRING.equals(phoneInvalid)) {
        phoneInvalid = ArchitectureConstants.N;
      }

      phone.setBIndPersonPhoneInvalid(phoneInvalid);
      phone.setSzTxtPhoneComments(personListRow.getSzTxtPhoneComments());
      phone.setUlIdPhone(personListRow.getUlIdPhone());
      // If no phone type was retrieved this is a new Phone Entry.
      if (personListRow.getSzCdPhoneType() == null
          || StringHelper.EMPTY_STRING.equals(personListRow.getSzCdPhoneType())) {
        phone.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      } else {
        phone.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      }
    }

    phoneArray.addROWCCMN31SI(phone);

    performanceTrace.exitScope();
    return phoneArray;
  }

  /**
   * POPULATE PERSON IDENTIFIERS
   * <p/>
   * We need to be able to save the SSN from the Call Person Detail page. This means we must not only save the current
   * information entered, but if the user is updating the SSN, we must end date the previous SSN and add the new
   * information. There are three situations: 1. The SSN entered is a NEW SSN that we need to ADD. 2. The SSN is being
   * UPDATED so we need to end date the OLD SSN and ADD the new one. 3. An existing SSN is being deleted. We need to end
   * date the currect SSN.
   * 
   * @param context
   * @param personListRow
   * @return
   */
  private CINT14WLB_ARRAY populateIDArray(GrndsExchangeContext context, PersListRtrvStruct personListRow) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateIDArray()");

    HttpServletRequest request = context.getRequest();

    CINT14WLB_ARRAY idArray = new CINT14WLB_ARRAY();
    CINT14WLB id = new CINT14WLB();

    String previousSSN = FormattingHelper.formatString(personListRow.getSzNbrPersonIdNumber());
    String currentSSN = ContextHelper.getSSNSafe(request, "txtSzNbrPersonIdNumber");
    // Case 1: There is no existing SSN and we are entered a NEW SSN
    if (StringHelper.EMPTY_STRING.equals(previousSSN) && StringHelper.isValid(currentSSN)) {
      id.setSzCdPersonIdType(CodesTables.CNUMTYPE_SSN);
      id.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      id.setBIndPersonIDInvalid(ArchitectureConstants.N);
      id.setDtPersonIDStart(DateHelper.toCastorDate(new Date()));
      id.setSzNbrPersonIdNumber(currentSSN);
      idArray.addCINT14WLB(id);
    }
    // Case 2: There is an existing SSN and we are entering a NEW SSN.
    else if (!StringHelper.EMPTY_STRING.equals(previousSSN) && StringHelper.isValid(currentSSN)) {
      // END DATE THE PREVIOUS SSN
      CINT14WLB previousID = new CINT14WLB();
      previousID.setSzCdPersonIdType(CodesTables.CNUMTYPE_SSN);
      previousID.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      previousID.setBIndPersonIDInvalid(ArchitectureConstants.N);
      previousID.setDtPersonIDStart(personListRow.getDtPersonIDStart());
      previousID.setDtPersonIDEnd(DateHelper.toCastorDate(new Date()));
      previousID.setSzNbrPersonIdNumber(previousSSN);
      previousID.setUlIdPersonId(personListRow.getUlIdPersonId());
      // ADD THE CURRENT SSN
      id.setSzCdPersonIdType(CodesTables.CNUMTYPE_SSN);
      id.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      id.setBIndPersonIDInvalid(ArchitectureConstants.N);
      id.setDtPersonIDStart(DateHelper.toCastorDate(new Date()));
      id.setSzNbrPersonIdNumber(currentSSN);
      idArray.addCINT14WLB(previousID);
      idArray.addCINT14WLB(id);
    }
    // Case 3: There was an existing SSN and we are deleting end.
    else if (StringHelper.isValid(previousSSN) && !(StringHelper.isValid(currentSSN))) {
      id.setSzCdPersonIdType(CodesTables.CNUMTYPE_SSN);
      id.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      id.setBIndPersonIDInvalid(ArchitectureConstants.N);
      id.setDtPersonIDStart(personListRow.getDtPersonIDStart());
      id.setDtPersonIDEnd(DateHelper.toCastorDate(new Date()));
      id.setSzNbrPersonIdNumber(previousSSN);
      id.setUlIdPersonId(personListRow.getUlIdPersonId());
      idArray.addCINT14WLB(id);
    }

    performanceTrace.exitScope();
    return idArray;
  }

  /**
   * This submethod populates the CCMN95S object which is passed to the Race/Ethnicity submodule retrieve.
   * 
   * @param ulIdPerson
   * @return
   */
  private static CCMN95SI populateCCMN95SI(int ulIdPerson) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCCMN95SI()");

    CCMN95SI ccmn95si = new CCMN95SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(10);

    ccmn95si.setUlIdPerson(ulIdPerson);
    ccmn95si.setArchInputStruct(input);

    performanceTrace.exitScope();
    return ccmn95si;
  }

  /**
   * Populate the input object for the Asynchronous Person Search object.
   * 
   * @return
   */
  private HierSrchInRec populateHierSrchInRec(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateHierSrchInRec()");

    HttpServletRequest request = context.getRequest();
    AddressBean aapBean = AddressBean.getFromRequest(request);
    if (aapBean == null) {
      aapBean = new AddressBean();
    }
    UserProfile user = UserProfileHelper.getUserProfile(request);

    HierSrchInRec hierSrchInRec = new HierSrchInRec();
    HierPersSrchRec hierPersSrchRec = new HierPersSrchRec();
    ArchInputStruct input = new ArchInputStruct();

    input.setUlPageSizeNbr(65);
    input.setUsPageNbr(1);
    input.setSzUserId(user.getUserLogonID());

    String txtSzNmNameFirst = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
    hierPersSrchRec.setSzNmNameFirst(txtSzNmNameFirst);

    String txtSzNmNameMiddle = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));
    hierPersSrchRec.setSzNmNameMiddle(txtSzNmNameMiddle);

    String txtSzNmNameLast = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast"));
    hierPersSrchRec.setSzNmNameLast(txtSzNmNameLast);

    hierPersSrchRec.setSzNbrPersonIdSsn(ContextHelper.getSSNSafe(request, "txtSzNbrPersonIdNumber"));
    hierPersSrchRec.setSzAddrCity(aapBean.getCity());
    hierPersSrchRec.setSzAddrPersAddrStLn1(aapBean.getAddress1());
    hierPersSrchRec.setSzAddrPersAddrStLn2(aapBean.getAddress2());
    hierPersSrchRec.setLAddrZip(aapBean.getZipAndSuff());
    hierPersSrchRec.setSzCdAddrCounty(aapBean.getCounty());
    hierPersSrchRec.setSzCdAddrState(aapBean.getState());

    // STGAP00004281 Automatic search should not use gender or dob
    // CODE REMOVED
    hierPersSrchRec.setLNbrPhone(ContextHelper.getPhoneSafe(request, "txtLBNbrPhone"));
    // STGAP00004281 Automatic search should not use gender or dob
    // CODE REMOVED
    hierPersSrchRec.setBASearchFlag(ArchitectureConstants.N);
    hierSrchInRec.setArchInputStruct(input);
    hierSrchInRec.setHierPersSrchRec(hierPersSrchRec);

    performanceTrace.exitScope();
    return hierSrchInRec;
  }

  /**
   * This submethod will be called when the user selects the New Using button from the Call Person List on the Call
   * Information page. It is also called indirectly when the user selects the Add button on the Call Person Detail page.
   * 
   * @param context
   */
  private void populateNewUsing(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateNewUsing()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get the Person List out of State. Either we have selected the Add button on
    // Call Person Detail or we selected the New Using button on Call Information. If we
    // selected the New Using button on Call Information we want to get the row out of the list
    // array by the index. Otherwise, we use the personListRow that is already in state.
    PersListRtrvStruct existingPeep = new PersListRtrvStruct();
    if (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnNewUsing.x"))) {
      PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                                 .getAttribute(
                                                                                               "PersListRtrvStruct_ARRAY",
                                                                                               request);

      if (personListArray == null) {
        personListArray = new PersListRtrvStruct_ARRAY();
      }

      String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPerson");

      int index = 0;
      if (checkedValues.length != 0) {
        index = Integer.parseInt(checkedValues[0]);
      }
      if (index < personListArray.getPersListRtrvStructCount()) {
        existingPeep = personListArray.getPersListRtrvStruct(index);
      }
    } else // This is by default the Call Person Detail Add button
    {
      existingPeep = (PersListRtrvStruct) state.getAttribute("personListRow", request);
    }
    if (existingPeep == null) {
      existingPeep = new PersListRtrvStruct();
    }
    PersListRtrvStruct newPeep = new PersListRtrvStruct();

    newPeep.setSzNmNameLast(existingPeep.getSzNmNameLast());
    newPeep.setSzCdStagePersType(existingPeep.getSzCdStagePersType());
    newPeep.setSzCdStagePersRole(existingPeep.getSzCdStagePersRole());
    newPeep.setBIndStagePersReporter(existingPeep.getBIndStagePersReporter());
    newPeep.setBIndStagePersInLaw(existingPeep.getBIndStagePersInLaw());
    newPeep.setLNbrPhone(existingPeep.getLNbrPhone());
    newPeep.setLNbrPhoneExtension(existingPeep.getLNbrPhoneExtension());
    newPeep.setSzCdPhoneType(existingPeep.getSzCdPhoneType());
    newPeep.setSzCdPersAddrLinkType(existingPeep.getSzCdPersAddrLinkType());
    // SIR STGAP00000558
    newPeep.setSzCdPersonLanguage(existingPeep.getSzCdPersonLanguage());
    // STGAP00015485: Copy Primary caretaker household field too
    newPeep.setCdPKHouseholdMember(existingPeep.getCdPKHouseholdMember());

    // Set the address information from the prior person into the new person
    AddressBean aapBean = new AddressBean();
    aapBean.setAddress1(existingPeep.getSzAddrPersAddrStLn1());
    aapBean.setAddress2(existingPeep.getSzAddrPersAddrStLn2());
    aapBean.setCity(existingPeep.getSzAddrCity());
    aapBean.setState(existingPeep.getSzCdAddrState());
    aapBean.setZipAndSuff(existingPeep.getLAddrZip());
    aapBean.setCounty(existingPeep.getSzCdAddrCounty());
    aapBean.addToRequest(request);

    state.setAttribute("personListRow", newPeep, request);
    performanceTrace.exitScope();
  }

  /**
   * Populates the input object for the relate service.
   * 
   * @param context
   * @param idPerson
   * @param idRelatedPerson
   * @return
   */
  private RelatePersonInRec populateRelatePersonInRec(GrndsExchangeContext context, int idPerson, int idRelatedPerson) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateRelatePersonInRec()");

    HttpServletRequest request = context.getRequest();

    RelatePersonInStruct relatepersoninstruct = new RelatePersonInStruct();
    RelatePersonInRec relatepersoninrec = new RelatePersonInRec();
    ArchInputStruct input = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);

    relatepersoninstruct.setUlIdPerson(idPerson);
    relatepersoninstruct.setUlIdStage(GlobalData.getUlIdStage(request));
    relatepersoninstruct.setUlIdRelatedPerson(idRelatedPerson);

    relatepersoninrec.setArchInputStruct(input);
    relatepersoninrec.setRelatePersonInStruct(relatepersoninstruct);

    performanceTrace.exitScope();

    return relatepersoninrec;
  }

  /**
   * Populates the input object for the unrelate service.
   * 
   * @param context
   * @param idRelatedPerson
   * @return
   */
  private UnrelatePersonInRec populateUnrelatePersonInRec(GrndsExchangeContext context, int idRelatedPerson) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateRelatePersonInRec()");

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    UnrelatePersonInRec unrelatepersoninrec = new UnrelatePersonInRec();
    ArchInputStruct input = new ArchInputStruct();
    RelatePersonInStruct relatepersoninstruct = new RelatePersonInStruct();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    input.setSzUserId(user.getUserLogonID());

    // relatepersoninstruct.setUlIdPerson(11111);
    relatepersoninstruct.setUlIdStage(GlobalData.getUlIdStage(request));
    relatepersoninstruct.setUlIdRelatedPerson(idRelatedPerson);

    unrelatepersoninrec.setArchInputStruct(input);
    unrelatepersoninrec.setRelatePersonInStruct(relatepersoninstruct);

    performanceTrace.exitScope();
    return unrelatepersoninrec;
  }

  /**
   * This submethod retrieves the Allegation List and enumerates through it looking for the idPerson in question. If the
   * idPerson is found as idPerp or idVictim, the method will return true, indicating the Person is involved in an
   * Allegation.
   * 
   * @param context
   * @param idPerson
   * @return
   */
  private boolean isPersonInvolvedInAllegation(GrndsExchangeContext context, int idPerson) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".isPersonInvolvedInAllegation()");

    boolean allegationFound = false;

    // We must call the retrieve for Allegation List and check if the person
    // the user is attempting to delete is involved in an allegation. If the person
    // is involved in an allegation, display an error message stating to the user that
    // all allegations involving this person must be removed before the person can be deleted.

    try {
      AllegRtrvRecOut allegRtrvRecOut = PopulateDataBean.callCINT30S(context, intakeEjb);
      ROWCINT76DO_ARRAY allegListArray = allegRtrvRecOut.getROWCINT76DO_ARRAY();

      Enumeration<ROWCINT76DO> enumeration = allegListArray.enumerateROWCINT76DO();
      while (enumeration.hasMoreElements()) {
        ROWCINT76DO alleg = enumeration.nextElement();
        if ((idPerson == alleg.getUlIdVictim()) || (idPerson == alleg.getUlIdAllegedPerpetrator())) {
          allegationFound = true;
          break;
        }
      }
    } catch (Exception ae) {
      // The CINT30S service is coded such that no matter what it will return rc = SUCCESS;
      GrndsTrace.msg(TRACE_TAG, 7, "CINT30S Retrieve Failed: " + ae.getMessage());
    }

    performanceTrace.exitScope();
    return allegationFound;
  }

  /**
   * This method will display a new Intake. We will clear GlobalData, state, and clear session of all old async Person
   * Search Results before displaying the Call Information page.
   * 
   * @param context
   */
  private void displayNewIntake(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayNewIntake()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // When the user Save && Close's or Save's the Address Bean information is submitted into the request
    // and unless we set a blank address bean into the request as an attribute, when the Call Information
    // page loads with a new Intake, the address info from the last Intake will be carried over and displayed.
    AddressBean callEntryAddress = new AddressBean();
    callEntryAddress.setAddressSubmoduleName("callEntryAddress");
    callEntryAddress.addToRequest(request);

    // Clear GlobalData since every time we call this method it is like clicking on
    // the top level Intake tab.
    state.removeAllContextParameters(request);
    state.removeAllAttributes(request);
    request.removeAttribute("callEntryAddressaddressInRequest");
    // Remove all the async person search results from session before beginning
    // a new Intake.
    // --# following call unnecessary if search data stored in state rather than HttpSession
    // --# IntakeUtils.clearAsynchInfoFromSession(context);

    /** @todo - we should not have to clear ulidstage here. make sure the above code works before removing it though */
    // GlobalData.setUlIdStage(0, request);
    // The metaphor needs stage to be set into Global Data to function correctly so set
    // INT into Global Data here.
    GlobalData.setSzCdStage(CodesTables.CSTAGES_INT, request);
    GlobalData.setAppMode(PageModeConstants.EDIT, request);
    PageMode.setPageMode(PageModeConstants.VIEW, request);

    performanceTrace.exitScope();
  }

  /**
   * This method is used to set the person search parameters into the request when the user clicks the View Search
   * button.
   * 
   * @param context
   * @param person
   */
  private void setSearchParametersIntoRequest(GrndsExchangeContext context, PersListRtrvStruct person) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setSearchParametersIntoRequest()");

    HttpServletRequest request = context.getRequest();

    GlobalData.setUlIdPerson(person.getUlIdPerson(), request);
    request.setAttribute("txtUlIdPerson", String.valueOf(person.getUlIdPerson()));
    request.setAttribute("txtSzNmNameFirst", person.getSzNmNameFirst());
    request.setAttribute("txtSzNmNameMiddle", person.getSzNmNameMiddle());
    request.setAttribute("txtSzNmNameLast", person.getSzNmNameLast());
    request.setAttribute("txtSzAddrPersAddrStLn1", person.getSzAddrPersAddrStLn1());
    request.setAttribute("txtSzCdAddrCity", person.getSzAddrCity());
    request.setAttribute("selSzCdAddrState", person.getSzCdAddrState());
    request.setAttribute("selSzCdAddrCounty", person.getSzCdAddrCounty());

    String fullZip = person.getLAddrZip();
    if (fullZip == null) {
      fullZip = StringHelper.EMPTY_STRING;
    }
    String zip = StringHelper.EMPTY_STRING;
    String suff = StringHelper.EMPTY_STRING;

    int index = fullZip.indexOf("-");
    if (index == -1) {
      zip = fullZip;
    } else if (index == 5) {
      if (fullZip.length() == 10) {
        zip = fullZip.substring(0, index);
        suff = fullZip.substring(index + 1, fullZip.length());
      }
    }
    request.setAttribute("txtSzCdAddrZip", zip);
    request.setAttribute("txtSzCdAddrZip2", suff);
    request.setAttribute("dtDtPersonBirth", person.getDtDtPersonBirth());
    request.setAttribute("txtlNbrPersonAge", String.valueOf(person.getLNbrPersonAge()));
    request.setAttribute("selCcdPersonSex", person.getCCdPersonSex());
    request.setAttribute("txtSzSysTxtGenericSSN", person.getSzNbrPersonIdNumber());
    request.setAttribute("txtlNbrPhone", person.getLNbrPhone());

    performanceTrace.exitScope();
  }

  /**
   * This submethod is the populate for the cinv50s Search Indicator Update service.
   * 
   * @param context
   * @param ulIdPerson
   * @return
   */
  private CINV50SI populateCINV50S(GrndsExchangeContext context, int ulIdPerson) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Call the service and update the search flag.
    CINV50SI cinv50si = new CINV50SI();
    ArchInputStruct input = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);
    input.setSzUserId(user.getUserLogonID());

    // Set the ArchInputStruct
    cinv50si.setArchInputStruct(input);

    cinv50si.setSzCdStagePersSearchInd("V");

    // IMPACT change -- The DAM is now selecting based on UlIdPerson instead
    // of UlIdStagePerson, so pass in UlIdPerson in the place of UlIdStagePerson
    cinv50si.setUlIdStagePerson(ulIdPerson);
    cinv50si.setSzCdTask("1000");
    cinv50si.setUlIdStage(GlobalData.getUlIdStage(request));

    return cinv50si;
  }

  /**
   * This method will autodelete persons who have not had a detail page saved when the user chooses to Save && Whatever
   * (including Save && Exit).
   * 
   * @param context
   * @param savePersonList
   */
  public static void autoDeletePersonsOnSave(GrndsExchangeContext context, SavePersonList savePersonList) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".autoDeletePersonsOnSave()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PersListRtrvStruct_ARRAY personListArray = (PersListRtrvStruct_ARRAY) state
                                                                               .getAttribute(
                                                                                             "PersListRtrvStruct_ARRAY",
                                                                                             request);

    if (personListArray == null) {
      personListArray = new PersListRtrvStruct_ARRAY();
    }

    Enumeration<PersListRtrvStruct> personListEnum = personListArray.enumeratePersListRtrvStruct();
    while (personListEnum.hasMoreElements()) {
      PersListRtrvStruct personListRow = personListEnum.nextElement();
      // Since Role is a required field on Call Person Detail, if the user has
      // not saved the Detail page for the Person, the role will be blank or null.
      if ((personListRow.getSzCdStagePersRole() == null)
          || (StringHelper.EMPTY_STRING.equals(personListRow.getSzCdStagePersRole()))) {
        PersListAudStruct personToDelete = populatePersListAudStructFromList(context, personListRow,
                                                                             ServiceConstants.REQ_FUNC_CD_DELETE);
        PersListAudInRec persListAudInRec = new PersListAudInRec();
        persListAudInRec.setPersListAudStruct(personToDelete);
        savePersonList.savePersonList(persListAudInRec);
      }
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will retrieve the Race Ethnicity information by calling the CCMN95SO service.
   * 
   * @param personId
   * @return
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   * @throws MarshalException
   * @throws ValidationException
   * @throws IntrospectionException
   */
  public static RaceEthnicityBean retrieveRaceEthnicityBean(int personId,
                                                            RetrieveRaceAndEthnicity retrieveRaceAndEthnicity)
                                                                                                              throws ServiceException,
                                                                                                              MarshalException,
                                                                                                              ValidationException,
                                                                                                              IntrospectionException {
    CCMN95SI ccmn95si = populateCCMN95SI(personId);
    CCMN95SO ccmn95so = retrieveRaceAndEthnicity.findPersonRaceAndPersonEthnicity(ccmn95si);

    if (ccmn95so == null) {
      ccmn95so = new CCMN95SO();
    }
    // Set the Race/Eth informatin from the retrieve into the RaceEthnicity bean.
    ROWCCMN95SOG00_ARRAY raceList = ccmn95so.getROWCCMN95SOG00_ARRAY();
    if (raceList == null) {
      raceList = new ROWCCMN95SOG00_ARRAY();
    }
    ROWCCMN95SOG01_ARRAY ethnicityList = ccmn95so.getROWCCMN95SOG01_ARRAY();
    if (ethnicityList == null) {
      ethnicityList = new ROWCCMN95SOG01_ARRAY();
    }

    RaceEthnicityBean reBean = new RaceEthnicityBean();
    reBean.setRaces(raceList);
    reBean.setEthnicity(ethnicityList);
    return reBean;
  }

  /*
   * private static boolean hasPrimaryAlready(GrndsExchangeContext context, PersListRtrvStruct personListRow, String
   * primaryType) throws ServiceException, MarshalException, ValidationException, IntrospectionException {
   * HttpServletRequest request = context.getRequest(); BaseSessionStateManager state = getSessionStateManager(context);
   * 
   * return true; }
   */

  /**
   * This method will call the Person List retrieve, enumerate through the list until the Person we are concerned with
   * is found, and then return that Person Row to the calling method.
   * 
   * @param context
   * @return
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   * @throws MarshalException
   * @throws ValidationException
   * @throws IntrospectionException
   */
  private static PersListRtrvStruct retrievePersonRowFromList(GrndsExchangeContext context, Intake intake1)
                                                                                                           throws ServiceException,
                                                                                                           MarshalException,
                                                                                                           ValidationException,
                                                                                                           IntrospectionException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get the Call Entry Object out of State. We need incomingStatus and callDispDate to
    // populate the Call Person List Retrieve Object.
    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);

    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }

    gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct callEntryData = callEntryRtrvOut
                                                                                                  .getCallEntrySvcStruct();

    if (callEntryData == null) {
      callEntryData = new gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct();
    }

    String incomingStatus = FormattingHelper.formatString(callEntryData.getCdIncmgStatus());
    Date callDisposedDt = callEntryData.getTsIncmgCallDisp();

    // Call the retrieve service for Person List
    PersListOutRec persListOutRec = PopulateDataBean.callCINT26S(context, incomingStatus, callDisposedDt, intake1);

    PersListRtrvStruct_ARRAY personListArray = persListOutRec.getPersListRtrvStruct_ARRAY();

    state.setAttribute("PersListRtrvStruct_ARRAY", personListArray, request);

    // Enumerate through person list until we find the Person Row we are interesting in.
    Enumeration<PersListRtrvStruct> e = personListArray.enumeratePersListRtrvStruct();
    while (e.hasMoreElements()) {
      PersListRtrvStruct personListRow = e.nextElement();
      if (personListRow.getUlIdPerson() == GlobalData.getUlIdPerson(request)) {
        return personListRow;
      }
    }
    // If this is a new person, the above enumeration will never return
    // and we return a new person object.
    return new PersListRtrvStruct();
  }

  /**
   * @param context
   * @return
   */
  private String formatPersonNameFull(GrndsExchangeContext context) {

    HttpServletRequest request = context.getRequest();
    String personNameFull = StringHelper.EMPTY_STRING;
    String firstName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameFirst"));
    String middleName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameMiddle"));
    String lastName = FormattingHelper.changeCase(ContextHelper.getStringSafe(request, "txtSzNmNameLast"));
    FormattingHelper.formatFullName(firstName, middleName, lastName);
    return personNameFull;

  }

  /**
   * This helper method utilizes the PhoneDB conversation and will set the retrieved Primary Phone for the Incoming
   * Person into the input object for the Phone Detail save and execute the phone save.
   * 
   * @param context
   * @param primaryIncPhone
   */
  private void phoneSave(GrndsExchangeContext context, ROWCINT52DO primaryIncPhone) throws MarshalException,
                                                                                   ValidationException, ParseException {
    HttpServletRequest request = context.getRequest();

    PhoneDB phoneDB = new PhoneDB();
    phoneDB.setComments(primaryIncPhone.getSzTxtIncmgPhoneComments());
    phoneDB.setExtension(primaryIncPhone.getSzNbrIncmgPhoneExtension());
    phoneDB.setInvalid(false);
    phoneDB.setNumber(primaryIncPhone.getSzNbrIncmgPhone());
    phoneDB.setPersonFullName(formatPersonNameFull(context));
    phoneDB.setPersonId(GlobalData.getUlIdPerson(request));
    phoneDB.setPrimary(true);
    phoneDB.setPhoneType(primaryIncPhone.getSzCdIncmgPhoneType());
    phoneDB.setStartDate(new Date());

    PhoneSave phoneSave = new PhoneSave();
    phoneSave.setPersonId(GlobalData.getUlIdPerson(request));
    phoneSave.setStageId(GlobalData.getUlIdStage(request));
    phoneSave.setPhoneDB(phoneDB);
    phoneSave.execute(personEjb);
  }

  /**
   * This helper method utilizes the populate from the AddressDetailConversation to invalidate any current primary
   * addresses and save the new Primary Address information that was retrieved for the Incoming Person as the new
   * Primary. JENN was here
   * 
   * @param context
   * @param primaryIncAddress
   */
  private void addressSave(GrndsExchangeContext context, ROWCINT48DO primaryIncAddress) throws ServiceException,
                                                                                       MarshalException,
                                                                                       ValidationException {
    try {
      // HttpServletRequest request = context.getRequest();

      AddressSave addressSave = new AddressSave();

      // SIR 23729 Start - The refactored class AddressListConversation no longer has a
      // static method populateAddressList()
      // CCMN42SO ccmn42so = AddressListConversation.populateAddressList( context );
      AddressListConversation addressListConversation = new AddressListConversation();
      // STGAP00004886 - pass service interface here when calling public method in a different conversation
      CCMN42SO ccmn42so = addressListConversation.populateAddressList(context, personEjb);
      // SIR 23729 End
      if (ccmn42so == null) {
        ccmn42so = new CCMN42SO();
      }

      addressSave.setCCMN42SO(ccmn42so);
      addressSave.setCReqFuncCd(AddressListConversation.REQ_FUNC_CD_ADD);
      addressSave.setIndPrimary(ArchitectureConstants.Y);
      addressSave.setIndInvalid(primaryIncAddress.getCIndIncmgAddrInvalid());
      addressSave.setAttention(primaryIncAddress.getSzAddrIncmgAddrAttn());
      addressSave.setAddressType(primaryIncAddress.getSzCdIncmgAddrType());

      AddressBean addressBean = new AddressBean();
      addressBean.setAddress1(primaryIncAddress.getSzAddrIncmgAddrStLn1());
      addressBean.setAddress2(primaryIncAddress.getSzAddrIncmgAddrStLn2());
      addressBean.setCity(primaryIncAddress.getSzAddrIncmgAddrCity());
      addressBean.setComments(primaryIncAddress.getSzTxtIncmgAddrComments());
      addressBean.setCounty(primaryIncAddress.getSzCdIncmgAddrCounty());
      addressBean.setState(primaryIncAddress.getSzCdIncmgAddrState());
      addressBean.setZipAndSuff(primaryIncAddress.getSzAddrIncmgAddrZip());
      addressSave.setAddressBean(addressBean);
      CCMN44SI ccmn44si = AddressDetailConversation.populateCCMN44S_AUD(context, addressSave);
      // saveAddressListDetail.saveAddressListDetail(ccmn44si);
      personEjb.saveAddressListDetail(ccmn44si);
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_DUPLICATE_RECORD:
        // ignore
        break;

      default:
        throw e;
      }
    }
  }

  /**
   * This method will get the incoming detail info and apply it to the current person. This was created for SIR's 22534
   * and 22693. This method will get the information in the primary incoming detail information and primary SSN
   * information and update the person with this data. It will also use an EJB to make a call to the Incoming Race and
   * Ethnicity tables to retrieve this data.
   * 
   * @param context
   * @param primaryIncDetail
   * @param primaryIncSSN
   */
  private void detailSave(GrndsExchangeContext context, ROWCINT51DO primaryIncDetail, ROWCINT50DO_ARRAY primaryIncSSN)
                                                                                                                      throws IntrospectionException,
                                                                                                                      MarshalException,
                                                                                                                      ValidationException,
                                                                                                                      RemoteException {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".detailSave()");

    HttpServletRequest request = context.getRequest();

    // populate the PersListAudInRec with the data currently on the page.
    PersListAudInRec persListAudInRec = populatePersListAudInRec_AUD(context);

    PersListAudStruct personDetail = persListAudInRec.getPersListAudStruct();
    // CINT14WLB_ARRAY ssnArray = persListAudInRec.getCINT14WLB_ARRAY();

    // We aren't changing the Name on this save
    personDetail.setBScrIndNameDataChange(ArchitectureConstants.N);
    persListAudInRec.setROWCINV26SIG00_ARRAY(null);

    // We aren't changing the Phone on this save
    personDetail.setBScrIndPhoneDataChange(ArchitectureConstants.N);
    persListAudInRec.setROWCCMN31SI_ARRAY(null);

    // We aren't changing the Address on this save
    personDetail.setBScrIndAddrDataChange(ArchitectureConstants.N);
    persListAudInRec.setROWCCMN44SIG00_ARRAY(null);

    // If the DOB field on the page is empty, get the incoming one.
    String dob = ContextHelper.getString(request, "txtDateDtPersonBirth");
    if (!StringHelper.isValid(dob)) {
      personDetail.setDtDtPersonBirth(primaryIncDetail.getDtDtIncmgPersBirth());
      personDetail.setBIndPersonDobApprox(ArchitectureConstants.N);
    }

    // If the incoming marital status is valid, set it.
    if (StringHelper.isValid(primaryIncDetail.getSzCdIncmgPersMaritlStat())) {
      personDetail.setSzCdPersonMaritalStatus(primaryIncDetail.getSzCdIncmgPersMaritlStat());
    }

    // If the SSN field is blank, get the incoming one.
    String SSN = ContextHelper.getString(request, "txtSzNbrPersonIdNumber");
    if (!StringHelper.isValid(SSN)) {
      Enumeration<ROWCINT50DO> ssnEnum = primaryIncSSN.enumerateROWCINT50DO();
      while (ssnEnum.hasMoreElements()) {
        ROWCINT50DO ssnDetail = ssnEnum.nextElement();

        if (ArchitectureConstants.N.equals(ssnDetail.getCIndIncmgPersonIDInv())
            && CodesTables.CMATTYPE_SSN.equals(ssnDetail.getSzCdIncmgPersIdType())) {
          CINT14WLB_ARRAY cint14wlb_array = new CINT14WLB_ARRAY();
          CINT14WLB cint14wlb = new CINT14WLB();

          cint14wlb.setSzCdPersonIdType(CodesTables.CNUMTYPE_SSN);
          cint14wlb.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
          cint14wlb.setBIndPersonIDInvalid(ArchitectureConstants.N);
          cint14wlb.setDtPersonIDStart(DateHelper.toCastorDate(new java.util.Date()));
          cint14wlb.setSzNbrPersonIdNumber(ssnDetail.getSzNbrIncmgPersIdNumber());
          cint14wlb_array.addCINT14WLB(cint14wlb);

          personDetail.setBScrIndIDDataChange(ArchitectureConstants.Y);
          persListAudInRec.setCINT14WLB_ARRAY(null);
          persListAudInRec.setCINT14WLB_ARRAY(cint14wlb_array);

          break;
        } else {
          personDetail.setBScrIndIDDataChange(ArchitectureConstants.N);
        }
      }
    } else {
      personDetail.setBScrIndIDDataChange(ArchitectureConstants.N);
    }

    // The race/ethnicity data does not come over in the cint34 call. This EJB
    // call was added for this enhancement (SIR's 22534 and 22693).
    RaceEthnicityBean reb = personUtility.getPersonRaceEthnicity(primaryIncDetail.getUlIdIncmgPerson());

    // This is the existing bean, to check if there is any data in the page.
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    if (reBean == null) {
      reBean = new RaceEthnicityBean();
    }

    boolean groupFlag = false;

    if ((!StringHelper.isValid(reBean.getEthnicity()) || CodesTables.CINDETHN_UT.equals(reBean.getEthnicity()))
        && StringHelper.isValid(reb.getEthnicity())) {
      ROWCINT02SIG01_ARRAY ethnicArray = populateEthnicityArray(reb);

      persListAudInRec.setROWCINT02SIG01_ARRAY(ethnicArray);

      personDetail.setBScrIndRaceDataChange(ArchitectureConstants.Y);
      groupFlag = true;
    }

    boolean raceIsUD = CodesTables.CETHNIC_UH.equals(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request))
                       || CodesTables.CETHNIC_UI.equals(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request))
                       || CodesTables.CETHNIC_UN.equals(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request));

    // STGAP00004886 - added empty check to avoi possible NPE when both persons have no race and ethnicity data
    // races object is not null but actually emty and BScrIndRaceDataChange should not be set to Y
    if ((!RaceEthnicityHelper.isRaceChecked(request) || raceIsUD)
        && (reb.getRaces() != null && !reb.getRaces().isEmpty())) {
      ROWCINT02SIG00_ARRAY raceArray = populateRaceArray(reb);

      if (raceIsUD) {
        ROWCINT02SIG00 raceDetail = new ROWCINT02SIG00();

        raceDetail.setSzCdPersonRace(CodesTables.CRACE_UD);
        raceDetail.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);

        raceArray.addROWCINT02SIG00(raceDetail);
      }

      persListAudInRec.setROWCINT02SIG00_ARRAY(raceArray);

      personDetail.setBScrIndRaceDataChange(ArchitectureConstants.Y);
      groupFlag = true;
    }

    if (groupFlag) {
      personDetail.setSzCdPersonEthnicGroup(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request));
    }
    intakeEjb.savePersonList(persListAudInRec);

    performanceTrace.exitScope();
  }

  /** find the id of the primary care person */
  private int findPKPersonID(PersListRtrvStruct_ARRAY personListArray) {
    int pkID = 0;
    Enumeration<PersListRtrvStruct> personList = personListArray.enumeratePersListRtrvStruct();
    if (personList != null) {
      while (personList.hasMoreElements()) {
        PersListRtrvStruct persListRtrvStruct = personList.nextElement();
        if (persListRtrvStruct != null && persListRtrvStruct.getSzCdStagePersRelInt() != null
            && CodesTables.CRPTRINT_PK.equals(persListRtrvStruct.getSzCdStagePersRelInt())) {
          pkID = persListRtrvStruct.getUlIdPerson();
          break;
        }
      }
    }
    return pkID;
  }

  /**
   * This method clears the Disposition field on the IntakeActions page . Created to resolve defect STGAP00008255
   */
  public void deleteDisposition_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteDisposition_xa()");
    HttpServletRequest request = context.getRequest();
    try {
      CallEntryAUDInRec callEntryAUDInRec = populateCallEntryAUDInRec(context);
      CallEntrySvcStruct entryStruct = callEntryAUDInRec.getCallEntrySvcStruct();
      entryStruct.setSzCdIncomingDisposition(null);
      entryStruct.setSzCdStageReasonClosed(null);
      PopulateDataBean.callCINT12S(callEntryAUDInRec, intakeEjb);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      displayCallInformation(context);
    } catch (ServiceException we) {
      // !!! setPresentationBranch ???
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * SMS#51977 MR-066 This method displays displays the F/A Home Information page if a resource is associated with Home
   * else displays Resource Detail when Rsource ID hyperlink is clicked.
   * 
   * @param context
   */

  public void displayResourceDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayResourceDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    autosaveCallInformation(context);

    int ulIdResource = ContextHelper.getIntSafe(context, "idResource");
    int ulIdHomeStage = ContextHelper.getIntSafe(context, "hdnUlIdHomeStage");

    // If ulIdCase has been received correctly, send to case summary page
    if (ulIdResource != 0) {
      GlobalData.setUlIdResource(ulIdResource, request);
      try {
        if (ulIdHomeStage != 0) {
          GlobalData.setUlIdStage(ulIdHomeStage, request);
          GlobalData.setSzCdTask("8210", request);
          forward(HOME_INFORMATION_CALLED, request, context.getResponse());
        } else {
          forward(RESOURCE_DETAIL_CALLED, request, context.getResponse());
        }
      } catch (ServletException se) {
        processSevereException(context, se);
      } catch (Exception e) {
        processSevereException(context, e);
      }
    }
    // If not, some sort of error
    else {
      processSevereException(
                             context,
                             new Exception(
                                           "DEBUG:CallInformationConversation -- Can't send to Resource Deatil without Resource ID"));
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
}
