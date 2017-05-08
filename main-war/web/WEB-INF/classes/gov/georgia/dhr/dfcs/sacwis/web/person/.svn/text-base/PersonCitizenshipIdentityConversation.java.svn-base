package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentitySaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <pre>
 *    Change History:
 *    Date      User              Description
 *    --------  ----------------  --------------------------------------------------
 *    11/25/2008  arege           STGAP00009538 Set the correct pageMode, User navigates to the 
 *                                Citizenship and Identity page from within a case they are assigned to,
 *                                and that page should be editable. 
 *    04/02/2009  cwells          STGAP00013120- Setting the page to read only when the user is a SAU.                             
 *                                
 * </pre>
 */
public class PersonCitizenshipIdentityConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "PersonCitizenshipIdentityConversation";

  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  public static final String FCC_STAGE = "SUB";

  private Person person;

  private Fce fce;

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setFce(Fce fce) {
    this.fce = fce;
  }

  /**
   * Display Person Detail Identity<p/> This method is used to display the entire person detail identity page.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  @SuppressWarnings( { "unchecked" })
  public void displayCitizenshipIdentity_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCitizenshipIdentity_xa()");
    performanceTrace.enterScope();

    displayCitizenshipIdentity(context);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Saves the person citizenship identity.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void savePersonCitizenshipIdentity_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePersonCitizenshipIdentity_xa()");
    performanceTrace.enterScope();

    PersonCitizenshipIdentitySaveSI personCitizenshipIdentitySaveSI = new PersonCitizenshipIdentitySaveSI();
    personCitizenshipIdentitySaveSI = populateCitizenshipIdentitySaveSI_AU(context, "save");
    person.saveCitizenshipIdentity(personCitizenshipIdentitySaveSI);
    displayCitizenshipIdentity(context);

    performanceTrace.exitScope();
    performanceTrace.getTotalTime();
    return;
  }

  /**
   * Retrieve the citizenship and identity details.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  private PersonCitizenshipIdentityRetrieveSI populatePersonCitizenshipIdentityRetrieveSI_Retrieve(
                                                                                                   GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             "populatePersonCitizenshipIdentityRetrieveSI_Retrieve");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    PersonCitizenshipIdentityRetrieveSI personCitizenshipIdentityRetrieveSI = new PersonCitizenshipIdentityRetrieveSI();
    personCitizenshipIdentityRetrieveSI.setUlIdPerson(GlobalData.getUlIdPerson(request));
    if (GlobalData.getUlIdPerson(request) == 0 && FCC_STAGE.equals(GlobalData.getSzCdStage(request))) {
      // Get the idPerson of the child and set it to the SI object. This is done specifically when coming
      // from Error List Hyperlink from Income and Expenditures page.
      long idPrimaryChild = fce.findPrimaryChildForStage(GlobalData.getUlIdStage(request), "PC");
      personCitizenshipIdentityRetrieveSI.setUlIdPerson((int) idPrimaryChild);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return personCitizenshipIdentityRetrieveSI;
  }

  /**
   * Populate the child plan details in SaveSI object.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   * @param method
   *                The caller method name to see whether its save or Complete.
   */

  private PersonCitizenshipIdentitySaveSI populateCitizenshipIdentitySaveSI_AU(GrndsExchangeContext context,
                                                                               String method) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCitizenshipIdentitySaveSI_AU");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    PersonCitizenshipIdentityList personCitizenshipIdentityBean = new PersonCitizenshipIdentityList();

    // Birth Information
    personCitizenshipIdentityBean.setSzCdPersonBirthState(ContextHelper.getStringSafe(request,
                                                                                      "selSzCdPersonBirthState"));
    personCitizenshipIdentityBean.setSzCdBirthCity(ContextHelper.getStringSafe(request, "txtSzCdPersonBirthCity"));
    personCitizenshipIdentityBean.setOutOfStateCounty(ContextHelper.getStringSafe(request, "txtSzCdOutOfStateCounty"));

    if (StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "cbxBIndUSCitizen"))) {
      personCitizenshipIdentityBean.setIndNonUSBorn(ArchitectureConstants.N);
    } else {
      personCitizenshipIdentityBean.setIndNonUSBorn(ArchitectureConstants.Y);
    }

    personCitizenshipIdentityBean
                                 .setBirthDate(DateHelper
                                                         .toJavaDateSafe(ContextHelper
                                                                                      .getStringSafe(request, "dtBirth")));
    personCitizenshipIdentityBean.setSzCdCntryOfOrigin(ContextHelper.getStringSafe(request, "selSzCdCntryOfOrigin"));
    personCitizenshipIdentityBean.setSzCdBirthCounty(ContextHelper.getStringSafe(request, "selSzCdPersonBirthCounty"));
    personCitizenshipIdentityBean.setSzCdCitizenshipStatus(ContextHelper.getStringSafe(request,
                                                                                       "selSzCdCitizenshipStatus"));

    personCitizenshipIdentityBean
                                 .setDtEntryUS(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                                                     "txtDtDtEntryUS")));
    personCitizenshipIdentityBean.setSzCdMotherMarried(ContextHelper.getStringSafe(request, "selSzCdMotherMarried"));
    personCitizenshipIdentityBean
                                 .setMethodAgeVerifications(CheckboxHelper
                                                                          .getCheckedValues(request,
                                                                                            "chkMethodOfCitizenshipVerification"));
    personCitizenshipIdentityBean.setUSCitizenVerifications(CheckboxHelper.getCheckedValues(request, "chkUSCitizen"));
    personCitizenshipIdentityBean
                                 .setIdentityAdultVerifications(CheckboxHelper
                                                                              .getCheckedValues(request,
                                                                                                "chkIdentityVerificationAdult"));
    personCitizenshipIdentityBean
                                 .setIdentityUnder16Verifications(CheckboxHelper
                                                                                .getCheckedValues(request,
                                                                                                  "chkIdentityVerificationUnder16Only"));
    personCitizenshipIdentityBean.setPermanentResidentRefugee(CheckboxHelper.getCheckedValues(request,
                                                                                              "chkPermResRefugee"));
    personCitizenshipIdentityBean.setOtherQualifiedAlien(CheckboxHelper.getCheckedValues(request,
                                                                                         "chkOtherQualifiedAlien"));
    personCitizenshipIdentityBean.setUndeterminedStatus(CheckboxHelper.getCheckedValues(request, "chkUndetermined"));

    PersonCitizenshipIdentitySaveSI personCitizenshipIdentitySaveSI = new PersonCitizenshipIdentitySaveSI();
    personCitizenshipIdentitySaveSI.setUlIdPerson(GlobalData.getUlIdPerson(request));
    if(GlobalData.getUlIdPerson(request) == 0 && FCC_STAGE.equals(GlobalData.getSzCdStage(request))) {
      // Get the idPerson of the child and set it to the SI object. This is done specifically when coming
      // from Error List Hyperlink from Income and Expenditures page.
      long idPrimaryChild = fce.findPrimaryChildForStage(GlobalData.getUlIdStage(request), "PC");
      personCitizenshipIdentitySaveSI.setUlIdPerson((int) idPrimaryChild);
    }
    personCitizenshipIdentitySaveSI.setPersonCitizenshipIdentityBean(personCitizenshipIdentityBean);

    performanceTrace.exitScope();
    return personCitizenshipIdentitySaveSI;
  }

  private void displayCitizenshipIdentity(GrndsExchangeContext context) {
    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // STGAP00009538 Set the correct pageMode, User navigates to the Citizenship and Identity page
      // from within a case they are assigned to, and that page should be editable.

      // get page mode from request
      String pageMode = PageMode.getPageMode(request);
      if (request.getAttribute(pageMode) != null) {
        pageMode = (String) request.getAttribute(pageMode);
        PageMode.setPageMode(pageMode, request);
      }

      // check if user has rights to modify this page
      Boolean rights = hasStageAccessRights(context);
      if (!pageMode.equals(PageModeConstants.NEW_USING)) {
        if (rights) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        } else {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }
      // state.setAttribute(PAGE_MODE_KEY, pageMode, request);

      PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
      PersonCitizenshipIdentityRetrieveSI personCitizenshipIdentityRetrieveSI = populatePersonCitizenshipIdentityRetrieveSI_Retrieve(context);
      personCitizenshipIdentitylRetrieveSO = person.retrieveCitizenshipIdentity(personCitizenshipIdentityRetrieveSI);
      state.setAttribute("PersonCitizenshipIdentitylRetrieveSO", personCitizenshipIdentitylRetrieveSO, request);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }

  /*
   * determines whether the user has access rights to modify the stage
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    UserProfile userProfile = UserProfileHelper.getUserProfile(context.getRequest());
    // STGAP00013120 If the user has the Adoption View Access or SAU_STAFF attribute then the citizenship and Identity page should be View only
    if(userProfile.hasRight(UserProfile.SEC_ADO_VIEW) || userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE)){
      return false;
    }else{
    return CaseUtility.hasStageAccess(userID, ulIdStage);
    }
  }
}
