package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonProtectiveServiceAlertList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

@SuppressWarnings("serial")
public class ProtectiveServiceAlertConversation extends BaseHiddenFieldStateConversation {

  private Common common;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void displayProtectiveServiceAlert_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayProtectiveServiceAlert_xa()");
    performanceTrace.enterScope();

    // define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // clear state at the beginning of the conversation
    state.removeAllAttributes(request);

    //-- (1)perform retrieve
    ProtectiveServiceAlertRetrieveSI psaRetrieveSI = populateProtectiveServiceAlertRetrieveSI(context);
    ProtectiveServiceAlertRetrieveSO psaRetrieveSO = null;
    try {
      psaRetrieveSO = common.retrieveProtectiveServiceAlert(psaRetrieveSI);
    } catch (ServiceException se) {
      handleError(se, context);
    }

    //-- (2)set output object into state
    UserProfile user = UserProfileHelper.getUserProfile(request);
    boolean previouslySaved = psaRetrieveSO.getIdPSA() > 0;

    String titleDecode;
    if (!previouslySaved) {
      //-- if not previously saved for the current stage, default display fields to current user
      psaRetrieveSO.setCdStage(GlobalData.getSzCdStage(request));
      psaRetrieveSO.setNmUserCreatedBy(user.getUserFullName());
      titleDecode = Lookup.simpleDecodeSafe(CodesTables.CEMPJBCL, user.getUserClass());
      //-- these are needed by the save input object
      psaRetrieveSO.setIdUserCreatedBy(user.getUserID());
      psaRetrieveSO.setIdStage(GlobalData.getUlIdStage(request));
    } else {
      titleDecode = Lookup.simpleDecodeSafe(CodesTables.CEMPJBCL, psaRetrieveSO.getCdTitle());
      //-- the following are needed if we access the page from Person Detail
      GlobalData.setUlIdStage(psaRetrieveSO.getIdStage(), request);
      GlobalData.setUlIdCase(psaRetrieveSO.getIdCase(), request);
      GlobalData.setSzNmStage(psaRetrieveSO.getNmStage(), request);
    }

    psaRetrieveSO.setTitleDecode(titleDecode);
    state.setAttribute("ProtectiveServiceAlertRetrieveSO", psaRetrieveSO, request);

    //-- (3)the rest is for determining correct page mode
    int mode = 0; //-- default to view
    String level2Tab = ContextHelper.getStringSafe(request, "level2Tab");

    //PERSON_PERSONSEARCH or CONTACTS_SUMMARIES_CONTACTSEARCH
    if ("CONTACTS_SUMMARIES_CONTACTSEARCH".equals(level2Tab)) {
      if (CaseUtility.hasStageAccess(user.getUserID(), GlobalData.getUlIdStage(request))) {
        if (previouslySaved) {
          mode = 1; //-- modify
          // STGAP00003596- Checks to see if user has rights to deactivate service alerts 
          if(user.hasRight(UserProfile.SEC_PROTECTIVE_SERVICE_ALERT)){
            state.setAttribute("deactivationRights", "true", request);
          }
          //-----------------------------------------------------------
        } else {
          mode = 2; //-- new
        }
      }
    } else if ("PERSON_PERSONSEARCH".equals(level2Tab)) {
      if (user.hasRight(UserProfile.SEC_PROTECTIVE_SERVICE_ALERT) && previouslySaved) {
        mode = 1; //-- modify (with deactivation rights)
        state.setAttribute("deactivationRights", "true", request);
      }
    }

    switch (mode) {
      case 2:
        PageMode.setPageMode(PageModeConstants.NEW, request);
        break;
      case 1:
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
        break;
      default:
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        break;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void displayPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    int personId = ContextHelper.getIntSafe(context, "hdnUlIdPerson");
    GlobalData.setUlIdPerson(personId, request);

    PersonHelper.setPersonDetailPageMode(request, PageModeConstants.EDIT);

    //Forward user to PersonDetail.jsp
    try {
      forward("/person/PersonDetail/displayPersonDetail", request, context.getResponse());
    }
    catch (ServletException ex) {
      processSevereException(context, ex);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Save Protective Service Alert
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveProtectiveServiceAlert_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveProtectiveServiceAlert_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    String pageMode = PageMode.getPageMode(request);
    ProtectiveServiceAlertSaveSI psaSaveSI = populateProtectiveServiceAlertSaveSI(pageMode, context);
    try {
      common.saveProtectiveServiceAlert(psaSaveSI);
    } catch (ServiceException se) {
      handleError(se, context);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    displayProtectiveServiceAlert_xa(context);
  }

  private ProtectiveServiceAlertSaveSI populateProtectiveServiceAlertSaveSI(String pageMode,
                                                                            GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateProtectiveServiceAlertSaveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ProtectiveServiceAlertSaveSI psaSaveSI = new ProtectiveServiceAlertSaveSI();

    //-- pull objects from state
    ProtectiveServiceAlertRetrieveSO psaRetrieveSO = (ProtectiveServiceAlertRetrieveSO) state.getAttribute(
            "ProtectiveServiceAlertRetrieveSO", request);
    String deactivationRights = (String) state.getAttribute("deactivationRights", request);
    boolean userCanDeactivate = "true".equals(deactivationRights);
    
    //-- get persons, set psaNewlyActive
    boolean noPersonsCheckedAsAbsconded = true;
    List<PersonProtectiveServiceAlertList> persons = psaRetrieveSO.getPersons();
    Iterator<PersonProtectiveServiceAlertList> it = persons.iterator();
    for (int i = 1; it.hasNext(); i++) {
      PersonProtectiveServiceAlertList person = it.next();
      String checked = CheckboxHelper.getCheckboxValue(request, "cbxPersonsAbsconded_" + i);
      if(ArchitectureConstants.Y.equals(checked)){
        person.setPsaNewlyActive(true);
        noPersonsCheckedAsAbsconded = false;
      } else{
        //-- if person if currentlyActive, user is attempting deactivation; check if they have permissions
        if(person.isPsaCurrentlyActive() && userCanDeactivate){
          person.setPsaNewlyActive(false);
        }
      }
    }
    psaSaveSI.setPersons(persons);
    
    //-- form inputs
    Date psaDate = ContextHelper.getJavaDateSafe(request, "psaDate");
    String psaTime = ContextHelper.getTimeSafe(request, "psaTime");
    Date dateAbsconded = ContextHelper.getJavaDateSafe(request, "dateAbsconded");
    String selReasonForAlert = ContextHelper.getStringSafe(request, "selReasonForAlert");
    String cbxAllPersonsLocated = CheckboxHelper.getCheckboxValue(request, "cbxAllPersonsLocated");
    String txtComments = ContextHelper.getStringSafe(request, "txtComments");
    psaSaveSI.setDateAndTime(DateHelper.toJavaDateSafe(psaDate, psaTime));
    psaSaveSI.setDateAbsconded(dateAbsconded);
    psaSaveSI.setCdReasonForAlert(selReasonForAlert);
    if(ArchitectureConstants.Y.equals(cbxAllPersonsLocated) && noPersonsCheckedAsAbsconded && userCanDeactivate){
      psaSaveSI.setIndAllPersonsLocated(ArchitectureConstants.Y);
    } else{
      psaSaveSI.setIndAllPersonsLocated(ArchitectureConstants.N);
    }
    psaSaveSI.setComments(txtComments);

    //-- rest from retrieve output object
    psaSaveSI.setIdStage(psaRetrieveSO.getIdStage());
    psaSaveSI.setIdUserCreatedBy(psaRetrieveSO.getIdUserCreatedBy());
    psaSaveSI.setCdStage(psaRetrieveSO.getCdStage());

    //-- ArchInputStruct (function code)
    ArchInputStruct ais = new ArchInputStruct();
    int idPSA = 0;
    if (psaRetrieveSO.getIdPSA() > 0 && PageModeConstants.MODIFY.equals(pageMode)) {
      ais.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      idPSA = psaRetrieveSO.getIdPSA();
    } else if (psaRetrieveSO.getIdPSA() > 0 || PageModeConstants.MODIFY.equals(pageMode)) {
      ais.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_NO_ACTION); //-- inconsistent page state
    } else {
      if (PageModeConstants.NEW.equals(pageMode)) {
        ais.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      } else {
        ais.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
      }
    }

    psaSaveSI.setIdPSA(idPSA);
    psaSaveSI.setArchInputStruct(ais);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return psaSaveSI;
  }

  private ProtectiveServiceAlertRetrieveSI populateProtectiveServiceAlertRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateProtectiveServiceAlertRetrieveSI");
    performanceTrace.enterScope();

    //-- we need to try to pull isStage and idPerson from GlobalData since we can access this page from
    //-- the context of a case's stage or from the Person Detail page, in which case the service will
    //-- find the correct idStage based off of idPerson
    int idStage = GlobalData.getUlIdStage(context.getRequest());
    int idPerson = GlobalData.getUlIdPerson(context.getRequest());
    ProtectiveServiceAlertRetrieveSI psaRetrieveSI = new ProtectiveServiceAlertRetrieveSI(idStage, idPerson);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return psaRetrieveSI;
  }

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + we.getMessage());
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CONFIRM_ON_EXIT:
      case Messages.MSG_FAD_SUBMIT_SUM:
      case Messages.MSG_SVC_CONTACT_DOESNT_EXIST:
      case Messages.MSG_SVC_DELETE_CONTACT:
      case Messages.MSG_SVC_NO_SUMMARY_DATES:
      case Messages.MSG_SVC_STRUCTURED_NARR:
        setErrorMessage(errorCode, request);
        break;
      default:
        processSevereException(context, we);
        break;
    }
  }
}
