package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.IncomeExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.service.fce.IncomeExpenditures;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AlertMesWorkerIfSESI;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * User: mkw Date: Mar 5, 2003 Time: 11:30:17 AM
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 03/15/05  Todd Reser        SIR 23307 - Set Person Detail Page mode to edit or view depending on the current page's
 *                                         pageMode
 * 07/11/05  Todd Reser        SIR 23036 - Added Income Auto Select options
 * 07/22/05  Todd Reser        SIR 23543 - All SSI Income for a child needs to be Unearned and Exempt
 * 07/24/05  werlem            SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 * 08/02/05 Todd Reser         SIR 23036 - Added !CodesTables.CINCRSRC_XXX.equals (fceIncomeDB.getCdType()) to if
 *                                         statement so "Other" would never set a default value
 * 11/22/10  hjbaptiste        SMS#81144 - MR-053 Eligibility Changes. Added Allocation and Deeming sections
 * 11/30/10  hnguyen           SMS#81144 - MR-053 Removed Case Manager Information section 
 *                                         and moved to App and Background                                       
 * </pre>
 */

public class IncomeExpendituresConversation extends FceConversation {

  public static final String TRACE_TAG = "IncomeExpendituresConversation";
  public static final String FCE_APPLICATION_PAGE_MODE = "fceApplicationPageMode";
  public static final String INCOME_EXPENDITURES_DB_KEY = TRACE_TAG + ".INCOME_EXPENDITURES_DB_KEY";
  public static final String INCOME_EXPENDITURES_DETAIL_DB_KEY = TRACE_TAG + ".INCOME_EXPENDITURES_DB_KEY";

  public static final int SAVE_SET = Sets.A;
  public static final int SUBMIT_SET = Sets.B;
  public static final int CALCULATE_SET = Sets.C;
  public static final int INCOMES_SET = Sets.D;

  public static final String ID_PERSON_SELECTED = "IdPersonSelected";
  public static final String IND_NONE_SET = "IndNoneSet";

  public static final String CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE = "_CHILD_INCOME_";
  public static final String CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE = "_CHILD_RESOURCE_";
  public static final String FAMILY_INCOME_CONTROL_NAME_SUFFIX_BASE = "_FAMILY_INCOME_";
  public static final String FAMILY_RESOURCE_CONTROL_NAME_SUFFIX_BASE = "_FAMILY_RESOURCE_";

  public static final String CBX_DELETE_FAMILY_INCOME_PREFIX = "cbxDeleteFamilyIncome_";
  public static final String CBX_DELETE_FAMILY_RESOURCE_PREFIX = "cbxDeleteFamilyResource_";

  public static final String SERVLET = "/fce";
  public static final String CONVERSATION = SERVLET + "/IncomeExpenditures";

  public static final String DISPLAY_COMMAND = CONVERSATION + "/displayIncomeExpenditures";
  public static final String DISPLAY_PERSON_DETAIL_COMMAND = CONVERSATION + "/displayPersonDetail";
  public static final String SAVE_INCOME_EXPENDITURES_DETAIL_COMMAND = CONVERSATION + "/saveIncomeExpendituresDetail";
  public static final String SUBMIT_APPLICATION_COMMAND = CONVERSATION + "/submitApplication";
  public static final String CALCULATE_COMMAND = CONVERSATION + "/calculate";
  public static final String INCOME_EXPENDITURES_BEAN_NAME = "IncomeExpenditures";
  public static final long MAX_AGE_MONTHLY_DEDUC = 13;
  public static final String ELIGIBILITY_WORKSHEET = "FCA";
  
  private Fce fce;

  private IncomeExpenditures incomeExpenditures;
  
  public void setIncomeExpenditures(IncomeExpenditures incomeExpenditures) {
    this.incomeExpenditures = incomeExpenditures;
  }
  
  public void setFce(Fce fce) {
    this.fce = fce;
  }

  public IncomeExpendituresConversation() {
    super(TRACE_TAG);
  }

  @SuppressWarnings({"unchecked"})
  public void displayIncomeExpenditures_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayIncomeExpenditures_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      clearState(context);
      FceUtility.setApplicationFceTabState(request);

      IncomeExpendituresDB incomeExpendituresDB = incomeExpenditures.read(GlobalData.getUlIdStage(request),
                                                                          GlobalData.getUlIdEvent(request),
                                                                          getUserID(request));
      setPageModeAndSets(request, incomeExpendituresDB);
      //Get the list of all members of the certified group (AU) for the Allocation Member dropdowns
      List<Option> aUMembersOptionsList = new ArrayList<Option>();
      List<FcePersonDB> aUMembersList = (List<FcePersonDB>) incomeExpendituresDB.getAUMembers();
      if (aUMembersList != null && aUMembersList.size() > 0) {
        Iterator<FcePersonDB> aUMembersList_it = aUMembersList.iterator();
        while (aUMembersList_it.hasNext()) {
          FcePersonDB aUMember = aUMembersList_it.next();
          if (aUMember.getCdRelInt() != null) {
            aUMembersOptionsList.add(new Option(aUMember.getIdPersonString(),
                                         aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst() + aUMember.getNmPersonMiddle() + " - " + 
                                         Lookup.simpleDecodeSafe(CodesTables.CRELVICT, (String) aUMember.getCdRelInt())));
          } else {
            aUMembersOptionsList.add(new Option(aUMember.getIdPersonString(),
                                         aUMember.getNmPersonLast() + ", " + aUMember.getNmPersonFirst()));
          }
        }
      }
      
      //Get the list of all members who are not part of the certified group (AU) for the Deeming Responsible Individuals dropdowns
      List<Option> nonAUMembersOptionsList = new ArrayList<Option>();
      List<FcePersonDB> nonAUMembersList = (List<FcePersonDB>) incomeExpendituresDB.getNonAUMembers();
      if (nonAUMembersList != null && nonAUMembersList.size() > 0) {
        Iterator<FcePersonDB> nonAUMembersList_it = nonAUMembersList.iterator();
        while (nonAUMembersList_it.hasNext()) {
          FcePersonDB nonAUMember = nonAUMembersList_it.next();
          if (nonAUMember.getCdRelInt() != null) {
            nonAUMembersOptionsList.add(new Option(nonAUMember.getIdPersonString(),
                                         nonAUMember.getNmPersonLast() + ", " + nonAUMember.getNmPersonFirst() + nonAUMember.getNmPersonMiddle() + " - " + 
                                         Lookup.simpleDecodeSafe(CodesTables.CRELVICT, (String) nonAUMember.getCdRelInt())));
          } else {
            nonAUMembersOptionsList.add(new Option(nonAUMember.getIdPersonString(),
                                         nonAUMember.getNmPersonLast() + ", " + nonAUMember.getNmPersonFirst()));
          }
        }
      }
      
      state.setAttribute("aUMembersOptionsList", aUMembersOptionsList, request);
      state.setAttribute("nonAUMembersOptionsList", nonAUMembersOptionsList, request);
      state.setAttribute(INCOME_EXPENDITURES_DB_KEY, incomeExpendituresDB, request);
      FceUtility.setCdEventStatus(incomeExpendituresDB, request);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void displayPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        save(incomeExpenditures, context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }

      // Set any information that needs to go into GlobalData for PersonDetail page.
      //  Event List should have already provided stage code and program code.
      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(request, ID_PERSON_SELECTED), request);

      // SIR 23307 - Set Person Detail Page mode to edit or view depending on
      // the current page's pageMode
      PersonHelper.setPersonDetailPageMode(request, pageMode);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  public void saveIncomeExpendituresDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveIncomeExpendituresDetail_xa()");
    performanceTrace.enterScope();

    try {
      save(incomeExpenditures, context);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  public void submitApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".submitApplication_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idUser = user.getUserID();

    try {
      IncomeExpendituresDB incomeExpendituresDB = populateIncomeExpendituresDB(context);
      state.removeAttribute(INCOME_EXPENDITURES_DB_KEY, request);

      incomeExpenditures.save(incomeExpendituresDB);
      // We need to do a read after the save in order to ensure that the last update date is in sync.
      // Note that, if someone were actually able to read and save between the last line and the next, the data
      //  could be different.  Generally, this should be impossible, as the time between these calls will be
      // milli-seconds, and even a fast web transaction is 1-2 seconds.
      /*incomeExpendituresDB = incomeExpenditures.read(incomeExpendituresDB.getIdStage(),
                                                     incomeExpendituresDB.getIdEvent(),
                                                     getUserID(request));*/

      
      int[] errors = incomeExpenditures.submitApplication(incomeExpendituresDB, UserProfile.SEC_MES_PROGRAM_ASSIST);
      if (errors != null) {
        ErrorList.setErrors(errors, request);
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        for(int i=0; i<errors.length; i++){
          setErrorMessage(errors[i], DISPLAY_COMMAND, context.getRequest());
        }
      } else {
        int idStage = GlobalData.getUlIdStage(request); 
        int idPerson = fce.retrieveMesProgramAssistant(idStage, UserProfile.SEC_MES_PROGRAM_ASSIST);
        int idCase = GlobalData.getUlIdCase(request);
        String[] secAttributesMESWorker = {UserProfile.SEC_REG_FAM_INDP_STF, UserProfile.SEC_REG_FAM_INDP_MGMNT_STF};
        AlertMesWorkerIfSESI alertMesWorkerIfSESI = new AlertMesWorkerIfSESI();
        alertMesWorkerIfSESI.setIdCase(idCase);
        alertMesWorkerIfSESI.setIdStage(idStage);
        alertMesWorkerIfSESI.setIdUser(idUser);
        alertMesWorkerIfSESI.setIdMesProgAssist(idPerson);
        alertMesWorkerIfSESI.setSecurityAttributesMESWorker(secAttributesMESWorker);
        // STGAP00005948: check if a secondary MES Worker already exists for the stage. If secondary 
        // MES Worker already exists, generate an alert for all MES Workers currently 
        // assigned as a secondary and generate an alert for the MES Program Assistant.  
        // If there is no MES Worker already assigned then BAU - generate the alert 
        // for the MES Program Assistant
        if(!fce.alertMesWorkerIfAlreadySE(alertMesWorkerIfSESI)){
          fce.eligibilityRouting(idStage, idUser, idPerson, ELIGIBILITY_WORKSHEET);
        }
        int ulIdEvent = (int) incomeExpendituresDB.getIdEvent();
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, (int) incomeExpendituresDB.getIdCase(),
                                                     (int) incomeExpendituresDB.getIdStage(),
                                                     EventHelper.FCE_APPLICATION_TASK_CODE);
        toDoDetailDB.setUlIdEvent(ulIdEvent); // need to set the event here so we link to it properly
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      }
      List expenditures = incomeExpendituresDB.getExpenditures();
      List principals = incomeExpendituresDB.getPrincipals();
      boolean displayMesg = false;
      long age = 0;
      for (Iterator expendituresIterator = expenditures.iterator(); expendituresIterator.hasNext();) {
        FceExpendituresDB fceExpendituresDB = (FceExpendituresDB) expendituresIterator.next();
        long idPersonCareReceive = fceExpendituresDB.getIdPersonCareReceive();
        for (Iterator principalsIterator = principals.iterator(); principalsIterator.hasNext();) { 
          FcePersonDB fcePersonDB = (FcePersonDB) principalsIterator.next();
          if(fcePersonDB.getIdPerson() == idPersonCareReceive){
            age = fcePersonDB.getNbrAge();
            break;
          }
        }
        if(age >= MAX_AGE_MONTHLY_DEDUC){
          displayMesg = true;
          break;
        }
      }
      if(displayMesg){
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_FCE_VERIF_DISABL), request);
      }
      GlobalData.setSzCdTask(EventHelper.FCE_APPLICATION_TASK_CODE, request);
     } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  public void calculate_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".calculate_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      IncomeExpendituresDB incomeExpendituresDB = populateIncomeExpendituresDB(context);
      state.removeAttribute(INCOME_EXPENDITURES_DB_KEY, request);

      incomeExpenditures.save(incomeExpendituresDB);
      // We need to do a read after the save in order to ensure that the last update date is in sync.
      // Note that, if someone were actually able to read and save between the last line and the next, the data
      //  could be different.  Though, this should be impossible, as the time between these calls will be milli-seconds,
      //  and even a fast web transaction is 1-2 seconds.
      /*incomeExpendituresDB = incomeExpenditures.read(incomeExpendituresDB.getIdStage(),
                                                     incomeExpendituresDB.getIdEvent(),
                                                     getUserID(request));*/

      int[] errors = incomeExpenditures.calculate(incomeExpendituresDB, UserProfile.SEC_MES_PROGRAM_ASSIST);
      if (errors != null && errors.length > 0) {
        ErrorList.setErrors(errors, request);
        // Stay on IncomeExpenditures if there are errors
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        for(int i=0; i<errors.length; i++){
          setErrorMessage(errors[i], DISPLAY_COMMAND, context.getRequest());
        }
      }
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Unlike normal "populate" methods, this one cannot reconstruct its data completely with what is in the request; it
   * requires that the incomeExpendituresDB produced in the display method be stored in state.  If it cannot find
   * incomeExpendituresDB in state, it will throw a PopulationException.
   *
   * @param context The <tt>GrndsExchangeContext</tt> object.
   * @return An IncomeExpendituresDB representing the information stored in state overridden by the information set in
   *         the request.
   * @throws PopulationException If it cannot find an IncomeExpendituresDB in state.
   */
  private static IncomeExpendituresDB populateIncomeExpendituresDB(GrndsExchangeContext context)
          throws PopulationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".preserveIncomeExpendituresData()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    IncomeExpendituresDB incomeExpendituresDB = (IncomeExpendituresDB)
            state.getAttribute(INCOME_EXPENDITURES_DB_KEY, request);

    if (incomeExpendituresDB == null) {
      throw new PopulationException("IncomeExpendituresDB not found in state.");
    }
    populateWithRequest(incomeExpendituresDB, request);

    // phone numbers aren't handled well by the default populate; overwrite the value that is populated for the
    // notified worker's phone number
    if (request.getParameter(IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN) != null) {
      String nbrNotifiedDhsWorkerPhn = ContextHelper.getPhoneSafe(request,
                                                                  IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN);

      incomeExpendituresDB.setNbrNotifiedDhsWrkrPhn(nbrNotifiedDhsWorkerPhn);
    }

    //we don't want to accidentally save $0.00 if the user does not enter it.
    Map parameterMap = request.getParameterMap();
    if ((parameterMap.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_ALIMONY_MONEY)) &&
        ("".equals(ContextHelper.getStringSafe(request, IncomeExpendituresDB.AMT_STEPPARENT_ALIMONY_MONEY)))) {
      incomeExpendituresDB.setAmtStepparentAlimony(null);
    }
    if ((parameterMap.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) &&
        ("".equals(ContextHelper.getStringSafe(request, IncomeExpendituresDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)))) {
      incomeExpendituresDB.setAmtStepparentOutsidePmnt(null);
    }

    //because the default read saves 0 as null
    String nbrStepparentChildren = ContextHelper.getStringSafe(request, "nbrStepparentChildren");
    if ("".equals(nbrStepparentChildren)) {
      incomeExpendituresDB.setNbrStepparentChildren(null);
    } else {
      int children = ContextHelper.getIntSafe(request, "nbrStepparentChildren");
      incomeExpendituresDB.setNbrStepparentChildren(new Long(children));
    }

    // Need to populate FceIncome objects for income and resources for principles
    // 1) Get the list of incomes or resources for the child or family.
    // 2) Populate it with the request data.
    // 3) Set the list back into the incomeExpendituresDB so that the incomeExpendituresDB knows to update the list
    List childIncomes = incomeExpendituresDB.getIncomeForChild();
    childIncomes = populateIncomesWithRequest(childIncomes, CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE, request);
    incomeExpendituresDB.setIncomeForChild(childIncomes);

    List familyIncomes = incomeExpendituresDB.getIncomeForFamily();
    familyIncomes = populateIncomesWithRequest(familyIncomes, FAMILY_INCOME_CONTROL_NAME_SUFFIX_BASE, request);
    incomeExpendituresDB.setIncomeForFamily(familyIncomes);

    List childResources = incomeExpendituresDB.getResourcesForChild();
    childResources = populateResourcesWithRequest(childResources, CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE, request);
    incomeExpendituresDB.setResourcesForChild(childResources);

    List familyResources = incomeExpendituresDB.getResourcesForFamily();
    familyResources = populateResourcesWithRequest(familyResources, FAMILY_RESOURCE_CONTROL_NAME_SUFFIX_BASE,
                                                   request);
    incomeExpendituresDB.setResourcesForFamily(familyResources);
    
    //  Need to populate FceExpenditures objects for Expenditures
    // 1) Get the list of Expenditures.
    // 2) Populate it with the request data.
    // 3) Set the list back into the incomeExpendituresDB so that the incomeExpendituresDB knows to update the list
    List expenditures = incomeExpendituresDB.getExpenditures();
    expenditures = populateExpendituresWithRequest(expenditures, incomeExpendituresDB.getIdFceEligibility(), request, state);
    incomeExpendituresDB.setExpenditures(expenditures);

    performanceTrace.exitScope();

    return incomeExpendituresDB;
  }

  //This is used by FosterCareReviewConversation too
  //!!! move this to FceUtility?
  public static List populateIncomesWithRequest(List incomeList, String nameSuffixBase, HttpServletRequest request)
          throws PopulationException {
    try {
      for (int i = 0; i < incomeList.size(); i++) {
        FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeList.get(i);
        Map parameterMap = request.getParameterMap();
        //SIR 23036 - Default indEarned if it doesn't exist
        if (!fceIncomeDB.getIndEarned()) {
          if (CodesTables.CINCRSRC_GRS.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_SLF.equals(fceIncomeDB.getCdType())) {
            fceIncomeDB.setIndEarned(true);
          }
          if (CodesTables.CINCRSRC_CSP.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_IDI.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_RET.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_RSD.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_TAN.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_VAB.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_ASB.equals(fceIncomeDB.getCdType())) {
            fceIncomeDB.setIndEarned(false);
          }
        }

        //SIR 23036 - Default indCountable if it doesn't exist
        if (!fceIncomeDB.getIndCountable()) {
          if (CodesTables.CINCRSRC_CSP.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_GRS.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_IDI.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_RET.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_RSD.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_VAB.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_SLF.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_ASB.equals(fceIncomeDB.getCdType())) {
            fceIncomeDB.setIndCountable(true);
          }
          if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_TAN.equals(fceIncomeDB.getCdType())) {
            fceIncomeDB.setIndCountable(false);
          }
        }

        // IND_NONE gets set unconditionally because there's no way to detect the difference between an accidentally
        //   unchecked and an intentionally unchecked checkbox.
        String indNone = FceIncomeDB.IND_NONE + nameSuffixBase + i;
        fceIncomeDB.setIndNone(ContextHelper.getBooleanSafe(request, indNone));

        double amountIncome = fceIncomeDB.getAmtIncome();

        if (amountIncome > 0.0) {
          String indEarned = FceIncomeDB.IND_EARNED + nameSuffixBase + i;
          if (parameterMap.containsKey(indEarned)) {
            fceIncomeDB.setIndEarned(ContextHelper.getBoolean(request, indEarned));
          }

          String indCountable = FceIncomeDB.IND_COUNTABLE + nameSuffixBase + i;
          if (parameterMap.containsKey(indCountable)) {
            fceIncomeDB.setIndCountable(ContextHelper.getBoolean(request, indCountable));
          }
        } else {
          fceIncomeDB.setIndEarned((Boolean) null);
          fceIncomeDB.setIndCountable((Boolean) null);
        }
        //SIR 23543 - All SSI Income for a child needs to be Unearned and Exempt
        if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType())) {
          fceIncomeDB.setIndEarned(false);
          fceIncomeDB.setIndCountable(false);
        }

      }
    } catch (InformationalPrsException e) {
      throw new PopulationException("Failure setting child incomes: " + e.getMessage(), e);
    }
    return incomeList;
  }

  //This is used by FosterCareReviewConversation too
  //!!! move this to FceUtility?
  public static List populateResourcesWithRequest(List incomeList, String nameSuffixBase, HttpServletRequest request)
          throws PopulationException {
    try {
      for (int i = 0; i < incomeList.size(); i++) {
        FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeList.get(i);
        Map parameterMap = request.getParameterMap();

        double amount = fceIncomeDB.getAmtIncome();
        if (amount > 0.0) {
          String indCountable = FceIncomeDB.IND_COUNTABLE + nameSuffixBase + i;
          if (parameterMap.containsKey(indCountable)) {
            fceIncomeDB.setIndCountable(ContextHelper.getBoolean(request, indCountable));
          }
        } else {
          fceIncomeDB.setIndCountable((Boolean) null);
        }
        //SIR 23036 - Set default values for countable if there are none
        if (!fceIncomeDB.getIndCountable() && !CodesTables.CINCRSRC_XXX.equals(fceIncomeDB.getCdType())) {
          //SIR 23036 - FOS, HOM, NOT, PBR and TRS are not countable by default
          if (CodesTables.CINCRSRC_FOS.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_HOM.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_NOT.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_PBR.equals(fceIncomeDB.getCdType()) ||
              CodesTables.CINCRSRC_TRS.equals(fceIncomeDB.getCdType())) {
            fceIncomeDB.setIndCountable(false);
          } else {
            //SIR 23036 - All other types are defaulted to countable if not accessible
            if (fceIncomeDB.getIndNotAccessible()) {
              fceIncomeDB.setIndCountable(false);
            } else {
              fceIncomeDB.setIndCountable(true);
            }
          }
        }
      }
    } catch (InformationalPrsException e) {
      throw new PopulationException("Failure setting child incomes: " + e.getMessage(), e);
    }
    return incomeList;
  }
  
  @SuppressWarnings( { "unchecked" })
  public static List populateExpendituresWithRequest(List expenditures, long idFceEligibility, HttpServletRequest request, BaseSessionStateManager state) {
    int size = expenditures.size();    
    for (int i = 0; i < size; i++) {
      FceExpendituresDB fceExpendituresDB = (FceExpendituresDB) expenditures.get(0);
      expenditures.remove(fceExpendituresDB);
    }
    for(int i = 0; i < 5 ; i++){
      String principalsId = IncomeExpendituresDB.PRINCIPALS + i;
      String personCareReceiveId = IncomeExpendituresDB.ID_PERSON_CARE_RECEIVE + i;
      String nmServiceProviderId = FceExpendituresDB.NM_SERVICE_PROVIDER + i;
      String amtPdMonthlyId = FceExpendituresDB.AMT_PD_MONTHLY + i;
      FceExpendituresDB fceExpendituresDB = new FceExpendituresDB();
      fceExpendituresDB.setAmtPdMonthly(ContextHelper.getMoneyAsDoubleSafe(request, amtPdMonthlyId));
      fceExpendituresDB.setNmServiceProvider(ContextHelper.getStringSafe(request, nmServiceProviderId));
      fceExpendituresDB.setIdPersonCareReceive(ContextHelper.getLongSafe(request, personCareReceiveId));
      fceExpendituresDB.setIdPerson(ContextHelper.getLongSafe(request, principalsId));
      fceExpendituresDB.setIdFceEligibility(idFceEligibility);
      if(fceExpendituresDB.getIdPerson() != 0){
        expenditures.add(fceExpendituresDB);
      }
    }
    return expenditures;
  }

  private void setPageModeAndSets(HttpServletRequest request, IncomeExpendituresDB incomeExpendituresDB) {
    String fcePageMode = FceUtility.getFceApplicationPageMode(request, incomeExpendituresDB);

    PageMode.setPageMode(fcePageMode, request);

    // Start with no sets
    int pageSet = Sets.NONE;
    if (fcePageMode.equals(PageModeConstants.EDIT)) {
      pageSet |= SAVE_SET;
      String eventStatus = incomeExpendituresDB.getCdEventStatus();
      UserProfile user = UserProfileHelper.getUserProfile(request);
      boolean eligibilityRight = user.hasRight(UserProfile.SEC_ELIGIBILITY);
      
      if (eventStatus.equals(EventHelper.NEW_EVENT) ||
          eventStatus.equals(EventHelper.PROCESS_EVENT) ||
          (eventStatus.equals(EventHelper.PENDING_EVENT) && !eligibilityRight)) {
        pageSet |= SUBMIT_SET;
      } else if (((eventStatus.equals(EventHelper.PENDING_EVENT)) ||
                  (eventStatus.equals(EventHelper.COMPLETE_EVENT))) &&
                                                                    (eligibilityRight)) {//Added the check for Secondary Assignment
        pageSet |= CALCULATE_SET;
        pageSet |= INCOMES_SET;
      }
    }
    Sets.setPageSet(pageSet, request);
  }

  protected static void save(IncomeExpenditures incomeExpenditures, GrndsExchangeContext context)
          throws PopulationException, EjbValidationException, RemoteException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    IncomeExpendituresDB incomeExpendituresDB = populateIncomeExpendituresDB(context);
    state.removeAttribute(INCOME_EXPENDITURES_DB_KEY, request);
    incomeExpenditures.save(incomeExpendituresDB);
  }
  
  public void isMesProgramAssistantExists(IncomeExpendituresDB incomeExpendituresDB){
    
  }

  static void populateWithRequest(IncomeExpendituresDB incomeExpendituresDB, HttpServletRequest request) {
    Map map = request.getParameterMap();
    if (map.containsKey(IncomeExpendituresDB.ADDR_HEALTH_ADDR_CITY)) {
      incomeExpendituresDB.setAddrHealthAddrCity(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.ADDR_HEALTH_ADDR_CITY));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_HEALTH_ADDR_ST_LN1)) {
      incomeExpendituresDB.setAddrHealthAddrStLn1(ContextHelper.getStringSafe(request,
                                                                              IncomeExpendituresDB.ADDR_HEALTH_ADDR_ST_LN1));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_HEALTH_ADDR_ST_LN2)) {
      incomeExpendituresDB.setAddrHealthAddrStLn2(ContextHelper.getStringSafe(request,
                                                                              IncomeExpendituresDB.ADDR_HEALTH_ADDR_ST_LN2));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_HEALTH_ADDR_ZIP)) {
      incomeExpendituresDB.setAddrHealthAddrZip(ContextHelper.getStringSafe(request,
                                                                            IncomeExpendituresDB.ADDR_HEALTH_ADDR_ZIP));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_REMOVAL_ADDR_ZIP)) {
      incomeExpendituresDB.setAddrRemovalAddrZip(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.ADDR_REMOVAL_ADDR_ZIP));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_REMOVAL_CITY)) {
      incomeExpendituresDB.setAddrRemovalCity(ContextHelper.getStringSafe(request,
                                                                          IncomeExpendituresDB.ADDR_REMOVAL_CITY));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_REMOVAL_ST_LN1)) {
      incomeExpendituresDB.setAddrRemovalStLn1(ContextHelper.getStringSafe(request,
                                                                           IncomeExpendituresDB.ADDR_REMOVAL_ST_LN1));
    }
    if (map.containsKey(IncomeExpendituresDB.ADDR_REMOVAL_ST_LN2)) {
      incomeExpendituresDB.setAddrRemovalStLn2(ContextHelper.getStringSafe(request,
                                                                           IncomeExpendituresDB.ADDR_REMOVAL_ST_LN2));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_APPLICATION)) {
      incomeExpendituresDB.setCdApplication(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_APPLICATION));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_COUNTY_HOSPITAL)) {
      incomeExpendituresDB.setCdCountyHospital(ContextHelper.getStringSafe(request,
                                                                           IncomeExpendituresDB.CD_COUNTY_HOSPITAL));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_HEALTH_ADDR_STATE)) {
      incomeExpendituresDB.setCdHealthAddrState(ContextHelper.getStringSafe(request,
                                                                            IncomeExpendituresDB.CD_HEALTH_ADDR_STATE));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_LIVING_MONTH_REMOVAL)) {
      incomeExpendituresDB.setCdLivingMonthRemoval(ContextHelper.getStringSafe(request,
                                                                               IncomeExpendituresDB.CD_LIVING_MONTH_REMOVAL));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_NOTA_MOST_RECENT)) {
      incomeExpendituresDB.setCdNotaMostRecent(ContextHelper.getStringSafe(request,
                                                                           IncomeExpendituresDB.CD_NOTA_MOST_RECENT));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_REMOVAL_ADDR_COUNTY)) {
      incomeExpendituresDB.setCdRemovalAddrCounty(ContextHelper.getStringSafe(request,
                                                                              IncomeExpendituresDB.CD_REMOVAL_ADDR_COUNTY));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_REMOVAL_ADDR_STATE)) {
      incomeExpendituresDB.setCdRemovalAddrState(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.CD_REMOVAL_ADDR_STATE));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_STATE)) {
      incomeExpendituresDB.setCdState(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_STATE));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_APPLICATION_COMPLETE_STRING)) {
      incomeExpendituresDB.setDtApplicationCompleteString(ContextHelper.getStringSafe(request,
                                                                                      IncomeExpendituresDB.DT_APPLICATION_COMPLETE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_APPLICATION_COMPLETE_TIME)) {
      incomeExpendituresDB.setDtApplicationCompleteTime(ContextHelper.getLongSafe(request,
                                                                                  IncomeExpendituresDB.DT_APPLICATION_COMPLETE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HEALTH_BEGIN_DATE_STRING)) {
      incomeExpendituresDB.setDtHealthBeginDateString(ContextHelper.getStringSafe(request,
                                                                                  IncomeExpendituresDB.DT_HEALTH_BEGIN_DATE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HEALTH_BEGIN_DATE_TIME)) {
      incomeExpendituresDB.setDtHealthBeginDateTime(ContextHelper.getLongSafe(request,
                                                                              IncomeExpendituresDB.DT_HEALTH_BEGIN_DATE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HEALTH_END_DATE_STRING)) {
      incomeExpendituresDB.setDtHealthEndDateString(ContextHelper.getStringSafe(request,
                                                                                IncomeExpendituresDB.DT_HEALTH_END_DATE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HEALTH_END_DATE_TIME)) {
      incomeExpendituresDB.setDtHealthEndDateTime(ContextHelper.getLongSafe(request,
                                                                            IncomeExpendituresDB.DT_HEALTH_END_DATE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HOSPITAL_ADMISSION_STRING)) {
      incomeExpendituresDB.setDtHospitalAdmissionString(ContextHelper.getStringSafe(request,
                                                                                    IncomeExpendituresDB.DT_HOSPITAL_ADMISSION_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HOSPITAL_ADMISSION_TIME)) {
      incomeExpendituresDB.setDtHospitalAdmissionTime(ContextHelper.getLongSafe(request,
                                                                                IncomeExpendituresDB.DT_HOSPITAL_ADMISSION_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HOSPITAL_DISCHARGE_STRING)) {
      incomeExpendituresDB.setDtHospitalDischargeString(ContextHelper.getStringSafe(request,
                                                                                    IncomeExpendituresDB.DT_HOSPITAL_DISCHARGE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_HOSPITAL_DISCHARGE_TIME)) {
      incomeExpendituresDB.setDtHospitalDischargeTime(ContextHelper.getLongSafe(request,
                                                                                IncomeExpendituresDB.DT_HOSPITAL_DISCHARGE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING)) {
      incomeExpendituresDB.setFceApplicationDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                           IncomeExpendituresDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME)) {
      incomeExpendituresDB.setFceApplicationDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                       IncomeExpendituresDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING)) {
      incomeExpendituresDB.setDtNotifiedWorkerString(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_NOTIFIED_WORKER_TIME)) {
      incomeExpendituresDB.setDtNotifiedWorkerTime(ContextHelper.getLongSafe(request,
                                                                             IncomeExpendituresDB.DT_NOTIFIED_WORKER_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_STRING)) {
      incomeExpendituresDB.setDtProofAgeSentEsString(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_TIME)) {
      incomeExpendituresDB.setDtProofAgeSentEsTime(ContextHelper.getLongSafe(request,
                                                                             IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING)) {
      incomeExpendituresDB.setDtProofCitizenshipSentEsString(ContextHelper.getStringSafe(request,
                                                                                         IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME)) {
      incomeExpendituresDB.setDtProofCitizenshipSentEsTime(ContextHelper.getLongSafe(request,
                                                                                     IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_CASE)) {
      incomeExpendituresDB.setIdCase(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_CASE));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_EVENT)) {
      incomeExpendituresDB.setIdEvent(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_EVENT));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_FCE_APPLICATION)) {
      incomeExpendituresDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                         IncomeExpendituresDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_FCE_ELIGIBILITY)) {
      incomeExpendituresDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                         IncomeExpendituresDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_LAST_UPDATE_PERSON)) {
      incomeExpendituresDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                           IncomeExpendituresDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_MNGNG_CVS_PERSON)) {
      incomeExpendituresDB.setIdMngngCvsPerson(ContextHelper.getLongSafe(request,
                                                                         IncomeExpendituresDB.ID_MNGNG_CVS_PERSON));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_OTHER_RELATIVE_PERSON)) {
      incomeExpendituresDB.setIdOtherRelativePerson(ContextHelper.getLongSafe(request,
                                                                              IncomeExpendituresDB.ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON)) {
      incomeExpendituresDB.setIdPerson(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_STAGE)) {
      incomeExpendituresDB.setIdStage(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_STAGE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_JUSTIFIED_EVAL)) {
      incomeExpendituresDB.setIndAgeJustifiedEval(ContextHelper.getBooleanSafe(request,
                                                                               IncomeExpendituresDB.IND_AGE_JUSTIFIED_EVAL));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_BAPTISM_CERT)) {
      incomeExpendituresDB.setIndAgeVrfdBaptismCert(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_AGE_VRFD_BAPTISM_CERT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_FOREIGN_CERT)) {
      incomeExpendituresDB.setIndAgeVrfdForeignCert(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_AGE_VRFD_FOREIGN_CERT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_HOSPITAL_CERT)) {
      incomeExpendituresDB.setIndAgeVrfdHospitalCert(ContextHelper.getBooleanSafe(request,
                                                                                  IncomeExpendituresDB.IND_AGE_VRFD_HOSPITAL_CERT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_NTRLZTN_CERT)) {
      incomeExpendituresDB.setIndAgeVrfdNtrlztnCert(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_AGE_VRFD_NTRLZTN_CERT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_PASSPORT)) {
      incomeExpendituresDB.setIndAgeVrfdPassport(ContextHelper.getBooleanSafe(request,
                                                                              IncomeExpendituresDB.IND_AGE_VRFD_PASSPORT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_RESIDENT_CARD)) {
      incomeExpendituresDB.setIndAgeVrfdResidentCard(ContextHelper.getBooleanSafe(request,
                                                                                  IncomeExpendituresDB.IND_AGE_VRFD_RESIDENT_CARD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_AGE_VRFD_US_BIRTH_CERT)) {
      incomeExpendituresDB.setIndAgeVrfdUsBirthCert(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_AGE_VRFD_US_BIRTH_CERT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDER)) {
      incomeExpendituresDB.setIndChildSupportOrder(ContextHelper.getBooleanSafe(request,
                                                                                IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDER));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_EVALUATION_CONCLUSION)) {
      incomeExpendituresDB.setIndEvaluationConclusion(ContextHelper.getBooleanSafe(request,
                                                                                   IncomeExpendituresDB.IND_EVALUATION_CONCLUSION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_HOSPITAL)) {
      incomeExpendituresDB.setIndHospital(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_HOSPITAL));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_INCOME_ASSISTANCE)) {
      incomeExpendituresDB.setIndIncomeAssistance(ContextHelper.getBooleanSafe(request,
                                                                               IncomeExpendituresDB.IND_INCOME_ASSISTANCE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_LEGAL_DOCS_SENT_ES)) {
      incomeExpendituresDB.setIndLegalDocsSentEs(ContextHelper.getBooleanSafe(request,
                                                                              IncomeExpendituresDB.IND_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_LIVING_RELATIVE_SIX_MONTH)) {
      incomeExpendituresDB.setIndLivingRelativeSixMonth(ContextHelper.getBooleanSafe(request,
                                                                                     IncomeExpendituresDB.IND_LIVING_RELATIVE_SIX_MONTH));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_MANAGING_CVS)) {
      incomeExpendituresDB.setIndManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                          IncomeExpendituresDB.IND_MANAGING_CVS));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_MINOR_PARENT)) {
      incomeExpendituresDB.setIndMinorParent(ContextHelper.getBooleanSafe(request,
                                                                          IncomeExpendituresDB.IND_MINOR_PARENT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER)) {
      incomeExpendituresDB.setIndNotifiedDhsWorker(ContextHelper.getBooleanSafe(request,
                                                                                IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_OTHER_HEALTH_INSURANCE)) {
      incomeExpendituresDB.setIndOtherHealthInsurance(ContextHelper.getBooleanSafe(request,
                                                                                   IncomeExpendituresDB.IND_OTHER_HEALTH_INSURANCE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PROOF_AGE_SENT_ES)) {
      incomeExpendituresDB.setIndProofAgeSentEs(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PROOF_CITIZENSHIP_SENT_ES)) {
      incomeExpendituresDB.setIndProofCitizenshipSentEs(ContextHelper.getBooleanSafe(request,
                                                                                     IncomeExpendituresDB.IND_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_COURT_MONTH)) {
      incomeExpendituresDB.setNbrCourtMonth(ContextHelper.getLongSafe(request, IncomeExpendituresDB.NBR_COURT_MONTH));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_COURT_YEAR)) {
      incomeExpendituresDB.setNbrCourtYear(ContextHelper.getLongSafe(request, IncomeExpendituresDB.NBR_COURT_YEAR));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_HEALTH_GROUP)) {
      incomeExpendituresDB.setNbrHealthGroup(ContextHelper.getStringSafe(request,
                                                                         IncomeExpendituresDB.NBR_HEALTH_GROUP));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_HEALTH_POLICY)) {
      incomeExpendituresDB.setNbrHealthPolicy(ContextHelper.getStringSafe(request,
                                                                          IncomeExpendituresDB.NBR_HEALTH_POLICY));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_LIVING_AT_HOME)) {
      incomeExpendituresDB.setNbrLivingAtHome(ContextHelper.getLongSafe(request,
                                                                        IncomeExpendituresDB.NBR_LIVING_AT_HOME));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN)) {
      incomeExpendituresDB.setNbrNotifiedDhsWrkrPhn(ContextHelper.getStringSafe(request,
                                                                                IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_HEALTH_COMPANY)) {
      incomeExpendituresDB.setNmHealthCompany(ContextHelper.getStringSafe(request,
                                                                          IncomeExpendituresDB.NM_HEALTH_COMPANY));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_HEALTH_EMPLOYEE_NM)) {
      incomeExpendituresDB.setNmHealthEmployeeNm(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.NM_HEALTH_EMPLOYEE_NM));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_HEALTH_EMPLOYER_NM)) {
      incomeExpendituresDB.setNmHealthEmployerNm(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.NM_HEALTH_EMPLOYER_NM));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_HEALTH_POLICY_HLDR_NM)) {
      incomeExpendituresDB.setNmHealthPolicyHldrNm(ContextHelper.getStringSafe(request,
                                                                               IncomeExpendituresDB.NM_HEALTH_POLICY_HLDR_NM));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_HOSPITAL)) {
      incomeExpendituresDB.setNmHospital(ContextHelper.getStringSafe(request, IncomeExpendituresDB.NM_HOSPITAL));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_HOSPITAL_CITY)) {
      incomeExpendituresDB.setNmHospitalCity(ContextHelper.getStringSafe(request,
                                                                         IncomeExpendituresDB.NM_HOSPITAL_CITY));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_MOTHER_MAIDEN)) {
      incomeExpendituresDB.setNmMotherMaiden(ContextHelper.getStringSafe(request,
                                                                         IncomeExpendituresDB.NM_MOTHER_MAIDEN));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST)) {
      incomeExpendituresDB.setNmNotifiedDhsWrkrFirst(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST)) {
      incomeExpendituresDB.setNmNotifiedDhsWrkrLast(ContextHelper.getStringSafe(request,
                                                                                IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_MIDDLE)) {
      incomeExpendituresDB.setNmNotifiedDhsWrkrMiddle(ContextHelper.getStringSafe(request,
                                                                                  IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_MIDDLE));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_INCOME_DTRMNTN_COMMENTS)) {
      incomeExpendituresDB.setTxtIncomeDtrmntnComments(ContextHelper.getStringSafe(request,
                                                                                   IncomeExpendituresDB.TXT_INCOME_DTRMNTN_COMMENTS));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_LEGAL_DOCS_SENT_ES)) {
      incomeExpendituresDB.setTxtLegalDocsSentEs(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.TXT_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_MEETS_DD_OR_NOT_COMMENTS)) {
      incomeExpendituresDB.setTxtMeetsDdOrNotComments(ContextHelper.getStringSafe(request,
                                                                                  IncomeExpendituresDB.TXT_MEETS_DD_OR_NOT_COMMENTS));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_NO_INCOME_EXPLANATION)) {
      incomeExpendituresDB.setTxtNoIncomeExplanation(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.TXT_NO_INCOME_EXPLANATION));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_PROOF_AGE_SENT_ES)) {
      incomeExpendituresDB.setTxtProofAgeSentEs(ContextHelper.getStringSafe(request,
                                                                            IncomeExpendituresDB.TXT_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_PROOF_CITIZENSHIP_SENT_ES)) {
      incomeExpendituresDB.setTxtProofCitizenshipSentEs(ContextHelper.getStringSafe(request,
                                                                                    IncomeExpendituresDB.TXT_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_COUNTABLE_INCOME)) {
      incomeExpendituresDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                             IncomeExpendituresDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_COUNTABLE_INCOME_MONEY)) {
      incomeExpendituresDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    IncomeExpendituresDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_DEEM_ALIMONY_OUTSIDE_HH)) {
      incomeExpendituresDB.setAmtDeemAlimonyOutsideHh(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         IncomeExpendituresDB.AMT_DEEM_ALIMONY_OUTSIDE_HH));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_DEEM_TAX_DEPEND_OUT_HH)) {
      incomeExpendituresDB.setAmtDeemTaxDependOutHh(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         IncomeExpendituresDB.AMT_DEEM_TAX_DEPEND_OUT_HH));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      incomeExpendituresDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                 IncomeExpendituresDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      incomeExpendituresDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        IncomeExpendituresDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      incomeExpendituresDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                                   IncomeExpendituresDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      incomeExpendituresDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          IncomeExpendituresDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_INCOME_LIMIT)) {
      incomeExpendituresDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request,
                                                                         IncomeExpendituresDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_INCOME_LIMIT_MONEY)) {
      incomeExpendituresDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                IncomeExpendituresDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_PWE_INCOME)) {
      incomeExpendituresDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request, IncomeExpendituresDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_PWE_INCOME_MONEY)) {
      incomeExpendituresDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                              IncomeExpendituresDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_SSI)) {
      incomeExpendituresDB.setAmtSsi(ContextHelper.getDoubleSafe(request, IncomeExpendituresDB.AMT_SSI));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_SSI_MONEY)) {
      incomeExpendituresDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, IncomeExpendituresDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_ALIMONY)) {
      incomeExpendituresDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                               IncomeExpendituresDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      incomeExpendituresDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      IncomeExpendituresDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_ALLOWANCE)) {
      incomeExpendituresDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                                 IncomeExpendituresDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      incomeExpendituresDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        IncomeExpendituresDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      incomeExpendituresDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                     IncomeExpendituresDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      incomeExpendituresDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                            IncomeExpendituresDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      incomeExpendituresDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                     IncomeExpendituresDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      incomeExpendituresDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                            IncomeExpendituresDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_GROSS_EARNED)) {
      incomeExpendituresDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                                   IncomeExpendituresDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      incomeExpendituresDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          IncomeExpendituresDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      incomeExpendituresDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                                   IncomeExpendituresDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      incomeExpendituresDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                          IncomeExpendituresDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      incomeExpendituresDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                                  IncomeExpendituresDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      incomeExpendituresDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         IncomeExpendituresDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      incomeExpendituresDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                                  IncomeExpendituresDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      incomeExpendituresDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                         IncomeExpendituresDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_ALLOC_TYPE)) {
      incomeExpendituresDB.setCdAllocType(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_ALLOC_TYPE));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_DEEM_INDIV_REL_1)) {
      incomeExpendituresDB.setCdDeemIndivRel1(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_DEEM_INDIV_REL_1));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_DEEM_INDIV_REL_2)) {
      incomeExpendituresDB.setCdDeemIndivRel2(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_DEEM_INDIV_REL_2));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_BLOC_CHILD)) {
      incomeExpendituresDB.setCdBlocChild(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_ELIGIBILITY_ACTUAL)) {
      incomeExpendituresDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                              IncomeExpendituresDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_ELIGIBILITY_SELECTED)) {
      incomeExpendituresDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                                IncomeExpendituresDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      incomeExpendituresDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                    IncomeExpendituresDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(IncomeExpendituresDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP)) {
      incomeExpendituresDB.setFceEligibilityCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                            IncomeExpendituresDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_PWE_IRREGULAR_UNDER100)) {
      incomeExpendituresDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_PWE_STEADY_UNDER100)) {
      incomeExpendituresDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                              IncomeExpendituresDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_ELIGIBILITY_END_STRING)) {
      incomeExpendituresDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_ELIGIBILITY_END_TIME)) {
      incomeExpendituresDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                             IncomeExpendituresDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_ELIG_DTRMNTN_START_STRING)) {
      incomeExpendituresDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                                   IncomeExpendituresDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_ELIG_DTRMNTN_START_TIME)) {
      incomeExpendituresDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                               IncomeExpendituresDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      incomeExpendituresDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                           IncomeExpendituresDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      incomeExpendituresDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                       IncomeExpendituresDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      incomeExpendituresDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                      IncomeExpendituresDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      incomeExpendituresDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                                  IncomeExpendituresDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_REVIEW_DATE_STRING)) {
      incomeExpendituresDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                             IncomeExpendituresDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_REVIEW_DATE_TIME)) {
      incomeExpendituresDB.setDtReviewDateTime(ContextHelper.getLongSafe(request,
                                                                         IncomeExpendituresDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      incomeExpendituresDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                        IncomeExpendituresDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      incomeExpendituresDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                    IncomeExpendituresDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_ELIGIBILITY_EVENT)) {
      incomeExpendituresDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request,
                                                                           IncomeExpendituresDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_FCE_PERSON)) {
      incomeExpendituresDB.setIdFcePerson(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_FCE_PERSON));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_FCE_REVIEW)) {
      incomeExpendituresDB.setIdFceReview(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1)) {
      incomeExpendituresDB.setIdPersonAllocMutual1(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2)) {
      incomeExpendituresDB.setIdPersonAllocMutual2(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1)) {
      incomeExpendituresDB.setIdPersonAllocSngl1(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2)) {
      incomeExpendituresDB.setIdPersonAllocSngl2(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_1)) {
      incomeExpendituresDB.setIdPersonDeemIndiv1(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_1));
    }
    if (map.containsKey(IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2)) {
      incomeExpendituresDB.setIdPersonDeemIndiv2(ContextHelper.getLongSafe(request, IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      incomeExpendituresDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                                  IncomeExpendituresDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_DEPORTED)) {
      incomeExpendituresDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_DESERTED)) {
      incomeExpendituresDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_DIED)) {
      incomeExpendituresDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request,
                                                                         IncomeExpendituresDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_DIVORCED)) {
      incomeExpendituresDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_FATHER)) {
      incomeExpendituresDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request,
                                                                           IncomeExpendituresDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_HOSPITALIZED)) {
      incomeExpendituresDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_INCARCERATED)) {
      incomeExpendituresDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_MILITARY_WORK)) {
      incomeExpendituresDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_MOTHER)) {
      incomeExpendituresDB.setIndAbsentMother(ContextHelper.getBooleanSafe(request,
                                                                           IncomeExpendituresDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_SEPARATED)) {
      incomeExpendituresDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                              IncomeExpendituresDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ABSENT_WORK_RELATED)) {
      incomeExpendituresDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                                IncomeExpendituresDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      incomeExpendituresDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                    IncomeExpendituresDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      incomeExpendituresDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                    IncomeExpendituresDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDERED)) {
      incomeExpendituresDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                                  IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_UNDER18)) {
      incomeExpendituresDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request,
                                                                           IncomeExpendituresDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      incomeExpendituresDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      incomeExpendituresDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      incomeExpendituresDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      incomeExpendituresDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      incomeExpendituresDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_CHLD_FOUND)) {
      incomeExpendituresDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      incomeExpendituresDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      incomeExpendituresDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      incomeExpendituresDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_EVALUATION)) {
      incomeExpendituresDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      incomeExpendituresDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      incomeExpendituresDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      incomeExpendituresDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      incomeExpendituresDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      incomeExpendituresDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      incomeExpendituresDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      incomeExpendituresDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_PASSPORT)) {
      incomeExpendituresDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_REFUGEE)) {
      incomeExpendituresDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_RESIDENT_CARD)) {
      incomeExpendituresDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      incomeExpendituresDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      incomeExpendituresDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_US_ID_CARD)) {
      incomeExpendituresDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      incomeExpendituresDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      incomeExpendituresDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_STUDENT_VISA)) {
      incomeExpendituresDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      incomeExpendituresDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,IncomeExpendituresDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_DEEM_RESP_TYPE)) {
      incomeExpendituresDB.setCdDeemRespType(ContextHelper.getStringSafe(request,IncomeExpendituresDB.CD_DEEM_RESP_TYPE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ELIGIBILITY_COURT_MONTH)) {
      incomeExpendituresDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                    IncomeExpendituresDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ELIGIBLE)) {
      incomeExpendituresDB.setIndEligible(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_ELIGIBLE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_EQUITY)) {
      incomeExpendituresDB.setIndEquity(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_EQUITY));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_EQUITY)) {
      incomeExpendituresDB.setIndChildEquity(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_CHILD_EQUITY));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_FATHER_PWE)) {
      incomeExpendituresDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_FATHER_PWE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      incomeExpendituresDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                    IncomeExpendituresDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_MEETS_DP_OR_NOT_ES)) {
      incomeExpendituresDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      incomeExpendituresDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_MOTHER_PWE)) {
      incomeExpendituresDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request, IncomeExpendituresDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_NARRATIVE_APPROVED)) {
      incomeExpendituresDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                                IncomeExpendituresDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_OTHER_VERIFICATION)) {
      incomeExpendituresDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                                IncomeExpendituresDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PARENTAL_DEPRIVATION)) {
      incomeExpendituresDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                                  IncomeExpendituresDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PARENT_DISABLED)) {
      incomeExpendituresDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PRS_MANAGING_CVS)) {
      incomeExpendituresDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                             IncomeExpendituresDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_REMOVAL_CHILD_ORDERED)) {
      incomeExpendituresDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                                  IncomeExpendituresDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_RSDI_VERIFICATION)) {
      incomeExpendituresDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                               IncomeExpendituresDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      incomeExpendituresDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                     IncomeExpendituresDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_SSI_VERIFICATION)) {
      incomeExpendituresDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                              IncomeExpendituresDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_CERTIFIED_GROUP)) {
      incomeExpendituresDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_DEEM_CHILD_NOT_IN_AU)) {
      incomeExpendituresDB.setNbrDeemChildNotInAU(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_DEEM_CHILD_NOT_IN_AU));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV)) {
      incomeExpendituresDB.setNbrDeemResponseIndiv(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_DEEM_TAX_DEPEND_NOT_IN_AU)) {
      incomeExpendituresDB.setNbrDeemTaxDependNotInAU(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_DEEM_TAX_DEPEND_NOT_IN_AU));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL)) {
      incomeExpendituresDB.setNbrIneligChildAllocMutual(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1)) {
      incomeExpendituresDB.setNbrIneligChildAllocSngl1(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2)) {
      incomeExpendituresDB.setNbrIneligChildAllocSngl2(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL)) {
      incomeExpendituresDB.setNbrIneligSpouseAllocMutual(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1)) {
      incomeExpendituresDB.setNbrIneligSpouseAllocSngl1(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2)) {
      incomeExpendituresDB.setNbrIneligSpouseAllocSngl2(ContextHelper.getLongSafe(request,
                                                                          IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_PARENTS_HOME)) {
      incomeExpendituresDB.setNbrParentsHome(ContextHelper.getLongSafe(request, IncomeExpendituresDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_DETERMINATION_COMMENTS)) {
      incomeExpendituresDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                                   IncomeExpendituresDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(IncomeExpendituresDB.CD_EVENT_STATUS)) {
      incomeExpendituresDB.setCdEventStatus(ContextHelper.getStringSafe(request, IncomeExpendituresDB.CD_EVENT_STATUS));
    }
    if (map.containsKey(IncomeExpendituresDB.NBR_STEPPARENT_CHILDREN)) {
      incomeExpendituresDB.setNbrStepparentChildren(ContextHelper.getLongSafe(request,
                                                                              IncomeExpendituresDB.NBR_STEPPARENT_CHILDREN));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_CHILD_CARE)) {
      incomeExpendituresDB.setIndChildCare(ContextHelper.getBooleanSafe(request,
                                                                        IncomeExpendituresDB.IND_CHILD_CARE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_OUT_HOME_CARE)) {
      incomeExpendituresDB.setIndOutOfHomeCare(ContextHelper.getBooleanSafe(request,
                                                                            IncomeExpendituresDB.IND_OUT_HOME_CARE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_EMANCIPATION)) {
      incomeExpendituresDB.setIndEmancipation(ContextHelper.getBooleanSafe(request,
                                                                           IncomeExpendituresDB.IND_EMANCIPATION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_ADOPTION)) {
      incomeExpendituresDB.setIndAdoption(ContextHelper.getBooleanSafe(request,
                                                                       IncomeExpendituresDB.IND_ADOPTION));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PAY_FOR_CARE)) {
      incomeExpendituresDB.setIndPayForCare(ContextHelper.getBooleanSafe(request,
                                                                         IncomeExpendituresDB.IND_PAY_FOR_CARE));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PROOF_CHILD_ID_SENT_ES)) {
      incomeExpendituresDB.setIndProofChildIdSentEs(ContextHelper.getBooleanSafe(request,
                                                                                 IncomeExpendituresDB.IND_PROOF_CHILD_ID_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.NM_SERVICE_PROVIDER)) {
      incomeExpendituresDB.setNmServiceProvider(ContextHelper.getStringSafe(request,
                                                                        IncomeExpendituresDB.NM_SERVICE_PROVIDER));
    }
    if (map.containsKey(IncomeExpendituresDB.AMT_PD_MONTHLY)) {
      incomeExpendituresDB.setAmtPdMonthly(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                        IncomeExpendituresDB.AMT_PD_MONTHLY));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_PROOF_CHILD_ID_SENT_ES_STRING)) {
      incomeExpendituresDB.setDtProofChildIdSentEsString(ContextHelper.getStringSafe(request,
                                                                               IncomeExpendituresDB.DT_PROOF_CHILD_ID_SENT_ES_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_PROOF_CHILD_ID_SENT_ES)) {
      incomeExpendituresDB.setTxtProofChildIdSentEs(ContextHelper.getStringSafe(request,
                                                                                IncomeExpendituresDB.TXT_PROOF_CHILD_ID_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.IND_PROOF_PREGNANCY_SENT_ES)) {
      incomeExpendituresDB.setIndProofPregnancySentEs(ContextHelper.getBooleanSafe(request,
                                                                                   IncomeExpendituresDB.IND_PROOF_PREGNANCY_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_PROOF_PREGNANCY_SENT_ES_STRING)) {
      incomeExpendituresDB.setDtProofPregnancySentEsString(ContextHelper.getStringSafe(request,
                                                                                 IncomeExpendituresDB.DT_PROOF_PREGNANCY_SENT_ES_STRING));
    }
    if (map.containsKey(IncomeExpendituresDB.TXT_PROOF_PREGNANCY_SENT_ES)) {
      incomeExpendituresDB.setTxtProofPregnancySentEs(ContextHelper.getStringSafe(request,
                                                                                  IncomeExpendituresDB.TXT_PROOF_PREGNANCY_SENT_ES));
    }
    if (map.containsKey(IncomeExpendituresDB.DT_LEGAL_DOCS_SENT_ES_STRING)) {
      incomeExpendituresDB.setDtLegalDocsSentEsString(ContextHelper.getStringSafe(request,
                                                                               IncomeExpendituresDB.DT_LEGAL_DOCS_SENT_ES_STRING));
    }
  }
}
