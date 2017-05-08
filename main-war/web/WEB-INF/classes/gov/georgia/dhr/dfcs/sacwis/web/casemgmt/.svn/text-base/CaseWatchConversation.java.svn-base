package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWatchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Stage;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

/**
 * This is the Conversation class used for the display of the SHINES Case Watch page.
 *
 * @author
 * Patrick Coogan, November 12, 2009
 *
 *  Change History:
 *  Date        User              Description
 *  --------    ---------------   --------------------------------------------------
 *  11/12/09    Patrick Coogan    Created conversation to support the Case Watch page as a part of
 *                                SHINES Every Child Every Month enhancements. 
 */


public class CaseWatchConversation extends BaseHiddenFieldStateConversation {

  public static final int ONE = 1;
  
  private CaseMgmt casemgmt;

  public void setCaseMgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }
  
  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }
    
  /**
   * ***************************************************************************
   * Activity method to display the case watch page in SHINES.
   * 
   * @param context Contains the session, state, and request objects to get data from 
   * jsps
   * ***************************************************************************
   */
  public void displayCaseWatch_xa(GrndsExchangeContext context) {
    
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseWatch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //We set to edit here so that radio buttons and select person button for NCANDS are always modifiable.
    //Page mode for navigations off of the page are reset individually where required based on stage access.
    PageMode.setPageMode(PageModeConstants.EDIT, request);
        
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    try {
            
      CaseWatchSI caseWatchSI = new CaseWatchSI();
      caseWatchSI.setIdCase(GlobalData.getUlIdCase(request));
      caseWatchSI.setIdStage(GlobalData.getUlIdStage(request));
      caseWatchSI.setSzStageCd(GlobalData.getSzCdStage(request));
      caseWatchSI.setIdUser(user.getUserID());
      
      //We will set this to the NCANDS person.  For other stages, we reset this to the primary child
      //for the stage once we enter the service.  Since we use getInt safe, this will be set to
      //zero when the element does not exist.
      int NcandsPerson = ContextHelper.getIntSafe(request, "NCANDS_CHILDREN");
      
      caseWatchSI.setIdPerson(NcandsPerson);
      
      CaseWatchSO caseWatchSO = casemgmt.retrieveCaseWatch(caseWatchSI);
      
      request.setAttribute("caseWatchSO", caseWatchSO);
      
      //If the child is 18 or over in foster care or adoptions, we want to display the 
      //informational message that not all factors may be appropriate
      
      if(CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||
                      CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
      
        Integer age = caseWatchSO !=null ? (caseWatchSO.getNbrPersonAge() != null ? caseWatchSO.getNbrPersonAge(): 0): 0 ;
        
        if (age >=18){       
          setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CH_OVER_18),request);  
        }
      }
    }
    catch (ServiceException we) {
      handleServiceError(we, context);
    }
    catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      handleError(ve, context);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
  }
  
  /**
   * ***************************************************************************
   * Activity method called from the Case Watch page to jump into other pages
   * for Case Watch, AFCARS, and NCANDS factors.
   * 
   * @param context Contains the session, state, and request objects to get data from 
   * jsps
   * ***************************************************************************
   */
  public void caseWatchNavigation_xa(GrndsExchangeContext context) {
    
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".caseWatchNavigation_xa");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //Get the selected hyperlink
    String navigationValue = ContextHelper.getStringSafe(request, "hdnNavigationValue")!=null?ContextHelper.getStringSafe(request, "hdnNavigationValue"):"";
    //Get the hidden person from the CaseWatchSO object to support navigation
    int idPerson = ContextHelper.getIntSafe(request, "hdnUlIdPerson"); 
    int idAdoStage = ContextHelper.getIntSafe(request, "hdnIdAdoStage");
    int idFccStage = ContextHelper.getIntSafe(request, "hdnIdFccStage");
    int idCustodyEvent = ContextHelper.getIntSafe(request, "hdnIdCustodyEvent") ;
    int idCustodyEventStage = ContextHelper.getIntSafe(request, "hdnIdCustodyEventStage") ;
    int idFadHomeStage = ContextHelper.getIntSafe(request, "hdnIdFadHomeStage") ;
    int idFamilyPlanEvent = ContextHelper.getIntSafe(request, "hdnIdFamilyPlanEvent") ;
    int idFamilyPlanEventStage = ContextHelper.getIntSafe(request, "hdnIdFamilyPlanEventStage") ;
    int idLegalStatusEvent = ContextHelper.getIntSafe(request, "hdnIdLegalStatusEvent") ;
    int idLegalStatusEventStage = ContextHelper.getIntSafe(request, "hdnIdLegalStatusEventStage") ;
    int idResource = ContextHelper.getIntSafe(request, "hdnIdResource") ;
    int idPlcmtEvent = ContextHelper.getIntSafe(request, "hdnIdPlcmtEvent") ;
    int idPlcmtEventStage = ContextHelper.getIntSafe(request, "hdnIdPlcmtEventStage") ;
    
    try {
    
    String url = "";
    
    if (NAV_PERSON_DETAIL.equals(navigationValue)) {
      
      if (idPerson > 0) {
      url = PERSON_DETAIL;
      PersonHelper.setPersonDetailPageMode(request, GlobalData.getAppMode(request));
      GlobalData.setUlIdPerson(idPerson, request);
      } else {
        url = CASE_WATCH;
        setInformationalMessage("The Case Watch page could not identify a person ID for the navigation to the Person Detail page.",request);
      }
    }
    if (NAV_PERSON_LIST.equals(navigationValue)) {
      url = PERSON_LIST;    
    }
    if (NAV_PERSON_CHARACTERISTICS.equals(navigationValue)) {
      
      if (idPerson > 0){
      url = PERSON_CHARACTERISTICS;
      PersonHelper.setPersonDetailPageMode(request, GlobalData.getAppMode(request));
      
      if (!(GlobalData.hasStageAccess(request))){
        request.setAttribute("pageMode",PageModeConstants.VIEW);
      }
      
      GlobalData.setUlIdPerson(idPerson, request);
      
      CINV04SI cinv04si = populateCINV04SI_Retrieve(context);
      
      CINV04SO cinv04so = person.retrievePersonDetail(cinv04si);
      
      CINV24SI cinv24si = populateCINV24SI_Retrieve(context);
      CINV24SO cinv24so = person.retrievePerson(cinv24si);
      state.setAttribute("CINV24SO", cinv24so, request);
      state.setAttribute("CINV04SO", cinv04so, request);
      int age = DateHelper.getAge(cinv04so.getDtDtPersonBirth());
      
      request.setAttribute("lNbrPersonAge", age);
      request.setAttribute("szCdStagePersRelInt", cinv04so.getSzCdStagePersRelInt());
      } else {
        url = CASE_WATCH;
        setInformationalMessage("The Case Watch page could not identify a person or the navigation to the Characteristics page.",request);
      }
    }
    if (NAV_FAD_HOME_PERSON_LIST.equals(navigationValue)){
      
      if(idFadHomeStage>0){
   
      resetStage(idFadHomeStage,context);   
      url = PERSON_LIST;
      } else {
        url = CASE_WATCH;
        setInformationalMessage("The Case Watch page could not identify a FAD stage for navigation to the FAD person list.",request);
      }
    }
    if (NAV_CUSTODY.equals(navigationValue)) {
      
      if ((idCustodyEvent > 0)&&(idCustodyEventStage > 0)) {
        url = CUSTODY;
        if (idCustodyEventStage != GlobalData.getUlIdStage(request)){
          resetStage(idCustodyEventStage,context);  
        }
        GlobalData.setUlIdEvent(idCustodyEvent, request);
        GlobalData.setSzCdTask(CaseUtility.getEvent(idCustodyEvent).getCdTask(), request);
      
      } else {
        url = CUSTODY_LIST;
        if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
          
          url = url+"?taskCD="+CUSTODY_LIST_INV;
          
        } else if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
          
          url = url+"?taskCD="+CUSTODY_LIST_FPR;
          
        } else {
          List<Stage> stages = CaseUtility.getAllStages(GlobalData.getUlIdCase(request));
          
          boolean stageFound = false;
          for (Iterator<Stage> It = stages.iterator(); It.hasNext();) {
            
            Stage stage = It.next();
            if (CodesTables.CSTAGES_FSU.equals(stage.getCdStage())) {
              resetStage(stage.getIdStage(),context);
              stageFound = true;
            }
          }
          if (stageFound){
          url = url+"?taskCD="+CUSTODY_LIST_FSU; 
          } else {
            url = CASE_WATCH;
          }
        }
        
        setInformationalMessage("The Case Watch page could not identify a specific Custody event.",request);
      }
    }
    if (NAV_LEGAL_ACTION_OUTCOME_LIST.equals(navigationValue)) {
      
        url = LEGAL_ACTION_OUTCOME_LIST;
        if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
          url = url+"?taskCD="+LEGAL_ACTION_OUTCOME_LIST_SUB;
        } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))&&(idFccStage>0)){
          resetStage(idFccStage,context);
          url = url+"?taskCD="+LEGAL_ACTION_OUTCOME_LIST_SUB;
        } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
          url = url+"?taskCD="+LEGAL_ACTION_OUTCOME_LIST_ADO;
        } else if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))){
          url = url+"?taskCD="+LEGAL_ACTION_OUTCOME_LIST_FPR;
        } else if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
          url = url+"?taskCD="+LEGAL_ACTION_OUTCOME_LIST_INV;
        }
      
    }
    if (NAV_TEAM_MEETINGS_REVIEWS_LIST.equals(navigationValue)) {
      
      url = TEAM_MEETINGS_REVIEWS_LIST;
      if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
      
        List<Stage> stages = CaseUtility.getAllStages(GlobalData.getUlIdCase(request));
        
        boolean stageFound = false;
        for (Iterator<Stage> It = stages.iterator(); It.hasNext();) {
          
          Stage stage = It.next();
          if (CodesTables.CSTAGES_FSU.equals(stage.getCdStage())) {
            resetStage(stage.getIdStage(),context);
            stageFound = true;
          }
        }
        if (stageFound){
          url = url+"?taskCD="+TEAM_MEETINGS_REVIEWS_LIST_FSU;
        } else {
          url = CASE_WATCH;
          setInformationalMessage("The Case Watch page could not identify a FCF stage for navigation to the Team Meetings/Reviews List.",request);
        }
          
      } else if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
        url = url+"?taskCD="+TEAM_MEETINGS_REVIEWS_LIST_FPR;
      }
   }
   if (NAV_PLACEMENT_LIST.equals(navigationValue)) {
      
      url = PLACEMENT_LIST;
      if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
        url = url+"?taskCD="+PLACEMENT_LIST_SUB;
      } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
        url = url+"?taskCD="+PLACEMENT_LIST_ADO;
      } 
   }
   if (NAV_HEALTH_LOG.equals(navigationValue)) {
     
     if (idPerson > 0) {
     url = HEALTH_LOG;
     PersonHelper.setPersonDetailPageMode(request, GlobalData.getAppMode(request));
     GlobalData.setUlIdPerson(idPerson, request);
     if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+HEALTH_LOG_SUB;
     } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+HEALTH_LOG_ADO;
     } 
     } else {
       url = CASE_WATCH;
       setInformationalMessage("The Case Watch page could not identify a person ID for the navigation to the Health Log page.",request);
     }
   }
   if (NAV_ELGIBILITY_SUMMARY_LIST.equals(navigationValue)) {
     
     url = ELIGIBILITY_SUMMARY_LIST;
     if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+ELIGIBILITY_SUMMARY_LIST_SUB;
     } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))&&(idFccStage>0)){
       resetStage(idFccStage,context);
       url = url+"?taskCD="+ELIGIBILITY_SUMMARY_LIST_SUB;
     } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+ELIGIBILITY_SUMMARY_LIST_ADO;
     } 
   }
   if (NAV_LEGAL_STATUS_DETAIL.equals(navigationValue)) {
     
     if ((idLegalStatusEvent > 0)&&(idLegalStatusEventStage > 0)) {
       url = LEGAL_STATUS_DETAIL;
       if (idLegalStatusEventStage != GlobalData.getUlIdStage(request)){
         resetStage(idLegalStatusEventStage,context);  
       }
       GlobalData.setUlIdEvent(idLegalStatusEvent, request);
       GlobalData.setSzCdTask(CaseUtility.getEvent(idLegalStatusEvent).getCdTask(), request);
     
     } else {
       url = LEGAL_STATUS_LIST;
       if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
         url = url+"?taskCD="+LEGAL_STATUS_LIST_SUB;
       } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))&&(idFccStage>0)){
         resetStage(idFccStage,context);
         url = url+"?taskCD="+LEGAL_STATUS_LIST_SUB;
       }else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
         url = url+"?taskCD="+LEGAL_STATUS_LIST_ADO;
       }
       setInformationalMessage("The Case Watch page could not identify a specific Legal Status event.",request);
     }
   }
   if (NAV_ONG_FAMILY_PLAN_DETAIL.equals(navigationValue)) {
     
     if ((idFamilyPlanEvent > 0)) {
       url = ONG_FAMILY_PLAN_DETAIL;
    
       GlobalData.setUlIdEvent(idFamilyPlanEvent, request);
       GlobalData.setSzCdTask(CaseUtility.getEvent(idFamilyPlanEvent).getCdTask(), request);
     
     } else {
       url = ONG_FAMILY_PLAN_LIST;
       url = url+"?taskCD="+FAMILY_PLAN_LIST_FPR;
       setInformationalMessage("The Case Watch page could not identify a specific Ongoing Family Plan event.",request);
     }
   }
   if (NAV_LEGAL_STATUS_LIST.equals(navigationValue)) {
     
       url = LEGAL_STATUS_LIST;
       if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
         url = url+"?taskCD="+LEGAL_STATUS_LIST_SUB;
       } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))&&(idFccStage>0)){
         resetStage(idFccStage,context);
         url = url+"?taskCD="+LEGAL_STATUS_LIST_SUB;
       } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
         url = url+"?taskCD="+LEGAL_STATUS_LIST_ADO;
       }
   }
   if (NAV_CARETAKER_INFO.equals(navigationValue)) {
     
     if (idResource > 0) {
     url = CARETAKER_INFO;
     GlobalData.setUlIdResource(idResource, request);
     } else {
       url = CASE_WATCH;
       setInformationalMessage("The Case Watch page could not identify a placement Resource ID for the navigation to the Caretaker Information page.",request);
     }
   }
   if (NAV_HOME_INFO.equals(navigationValue)){
     
     if(idFadHomeStage>0){
  
     resetStage(idFadHomeStage,context);   
     url = HOME_INFO;
     } else {
       url = CASE_WATCH;
       setInformationalMessage("The Case Watch page could not identify a FAD stage for navigation to the Home Info page.",request);
     }
   }
   if (NAV_ADOPTION_ASSISTANCE_LIST.equals(navigationValue)) {
     
     url = ADOPTION_ASSISTANCE_LIST;
     if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
       if(idAdoStage>0){
       
       resetStage(idAdoStage,context);  
       url = url+"?taskCD="+ADOPTION_ASSISTANCE_LIST_ADO;
       } else {
         url = CASE_WATCH;
         setInformationalMessage("The Case Watch page could not identify an ADO stage for navigation to the Adoption Assistance List.",request);
       }
     } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+ADOPTION_ASSISTANCE_LIST_ADO;
     }
   }
   if (NAV_PLACEMENT.equals(navigationValue)) {
     
     if ((idPlcmtEvent > 0)&&(idPlcmtEventStage > 0)) {
       url = PLACEMENT;
       if (idPlcmtEventStage != GlobalData.getUlIdStage(request)){
         resetStage(idPlcmtEventStage,context);  
       }
       GlobalData.setUlIdEvent(idPlcmtEvent, request);
       GlobalData.setSzCdTask(CaseUtility.getEvent(idPlcmtEvent).getCdTask(), request);
     
     } else {
       url = PLACEMENT_LIST;
       if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
         url = url+"?taskCD="+PLACEMENT_LIST_SUB;
       } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
         url = url+"?taskCD="+PLACEMENT_LIST_ADO;
       }
       setInformationalMessage("The Case Watch page could not identify a specific Placement event.",request);
     }
   }
   if (NAV_FOSTER_FAMILY_PLAN_DETAIL_AFCARS.equals(navigationValue)) {
     
     if ((idFamilyPlanEvent > 0)&&(idFamilyPlanEventStage > 0)) {
       url = FOSTER_FAMILY_PLAN_DETAIL;
       if (idFamilyPlanEventStage != GlobalData.getUlIdStage(request)){
         resetStage(idFamilyPlanEventStage,context);  
       }
       GlobalData.setUlIdEvent(idFamilyPlanEvent, request);
       GlobalData.setSzCdTask(CaseUtility.getEvent(idFamilyPlanEvent).getCdTask(), request);
     
     } else {
       
       List<Stage> stages = CaseUtility.getAllStages(GlobalData.getUlIdCase(request));
       
       boolean stageFound = false;
       for (Iterator<Stage> It = stages.iterator(); It.hasNext();) {
         
         Stage stage = It.next();
         if (CodesTables.CSTAGES_FSU.equals(stage.getCdStage())) {
           resetStage(stage.getIdStage(),context);
           stageFound = true;
         }
       }
       if (stageFound){
       url = FOSTER_FAMILY_PLAN_LIST+"?taskCD="+FOSTER_FAMILY_PLAN_LIST_FSU; 
       } else {
         url = CASE_WATCH;
       }
       setInformationalMessage("The Case Watch page could not identify a specific case plan.",request);
     }
   }
   if (NAV_SVC_AUTH_LIST.equals(navigationValue)) {
     
     url = SVC_AUTH_LIST;
     if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+SVC_AUTH_LIST_INV;
     } else if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+SVC_AUTH_LIST_FPR;
     }
   }
   if (NAV_SAFETY_RESOURCE_LIST.equals(navigationValue)) {
     
     url = SAFETY_RESOURCE_LIST;
     if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+SAFETY_RESOURCE_LIST_INV;
     } else if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+SAFETY_RESOURCE_LIST_FPR;
     }
   }
  if (NAV_CHILD_PLAN_LIST.equals(navigationValue)) {
     
     url = CHILD_PLAN_LIST;
     if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+CHILD_PLAN_LIST_SUB;
     } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
       url = url+"?taskCD="+CHILD_PLAN_LIST_ADO;
     }
   }
  if (NAV_WTLP_LIST.equals(navigationValue)) {
    
    url = WTLP_LIST;
    if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))){
      url = url+"?taskCD="+WTLP_LIST_SUB;
    } else if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))){
      url = url+"?taskCD="+WTLP_LIST_ADO;
    }
  }
   if (NAV_CASE_SUMMARY.equals(navigationValue)) {
     url = CASE_SUMMARY;
   }
   if (NAV_EVENT_LIST.equals(navigationValue)) {
     url = EVENT_LIST;
   }
   if (NAV_EVENT_LIST_INT.equals(navigationValue)) {
     url = EVENT_LIST;
     List<Stage> stages = CaseUtility.getAllStages(GlobalData.getUlIdCase(request));
     
     for (Iterator<Stage> It = stages.iterator(); It.hasNext();) {
       
       Stage stage = It.next();
       if (CodesTables.CSTAGES_INT.equals(stage.getCdStage())) {
         resetStage(stage.getIdStage(),context);
         
       }
     }
   }
   if (NAV_CONTACT_SEARCH_LIST.equals(navigationValue)) {
     url = CONTACT_SEARCH_LIST;
     GlobalData.setSzCdTask(CaseUtility.getEventByStageAndEventType(GlobalData.getUlIdStage(request), "CON").getCdTask(), request);
   }
   if (NAV_RISK_REASSESSMENT_LIST.equals(navigationValue)) {
     url = RISK_REASSESSMENT_LIST+"?taskCD="+RISK_REASSESSMENT_LIST_FPR;
   }
   if (NAV_ALLEGATION_LIST.equals(navigationValue)) {
     url = ALLEGATION_LIST;
     
     if (!CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
       
       Stage invStage = CaseUtility.getInvStage(GlobalData.getUlIdStage(request));
       resetStage(invStage.getIdStage(),context);
     }
     
   }
   if (NAV_CASE_MAINTENANCE.equals(navigationValue)) {
     url = CASE_MAINTENANCE;
   }
   if (NAV_INV_CONCLUSION.equals(navigationValue)) {
     url = INV_CONCLUSION;
     
     if (!CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
       
       Stage invStage = CaseUtility.getInvStage(GlobalData.getUlIdStage(request));
       resetStage(invStage.getIdStage(),context);
     }
     
   }
   if (NAV_INTAKE_ACTIONS.equals(navigationValue)) {
     url = INTAKE_ACTIONS;
     
     if (!CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
       
       Stage invStage = CaseUtility.getInvStage(GlobalData.getUlIdStage(request));
       resetStage(invStage.getIdStage(),context);
     }
     
   }
   
      forward(url, request, context.getResponse());
    
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
  }

  /**
   * ************************************************************************************* 
   * This helper method handles
   * all the WTC Exceptions thrown by this conversation 
   * **************************************************************************************
   */
  private void handleServiceError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
      
      case Messages.SQL_NOT_FOUND:
        // handled by the JSP - No results returned
        break;
      default:
        setErrorMessage("The Case Watch page could not display",request);
        try {
        forward(CASE_MAINTENANCE, request, context.getResponse());
        } catch (Exception e) {
          processSevereException(context, e);
        }
        break;
    }
  }
  
  /**
   * ************************************************************************************* 
   * This helper method handles
   * all the other exceptions thrown by this conversation 
   * **************************************************************************************
   */
  private void handleError(Exception ve, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    setErrorMessage("The Case Watch page could not display", request);
    try {
      forward(CASE_MAINTENANCE, request, context.getResponse());
    } catch (Exception e) {
      processSevereException(context, e);
    }

  }
  
  /**
   * ************************************************************************************* This helper method resets
   * global data stage data prior to a navigation from the Case Watch page to a new stage.
   * **************************************************************************************
   */
  private void resetStage(int idStage, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    Stage stage = CaseUtility.getStage(idStage);
    GlobalData.setUlIdCase(stage.getIdCase(), request);
    GlobalData.setUlIdStage(idStage, request);
    GlobalData.setSzNmStage(stage.getNmStage(), request);
    GlobalData.setSzNmCase(stage.getNmCase(), request);
    GlobalData.setDtDtStageStart(stage.getDtStart(), request);
    GlobalData.setSzCdStage(stage.getCdStage(), request);
    GlobalData.setSzCdStageType(stage.getCdStageType(), request);
    
  }
  
  /**
   * populateCINV24SI_Retrieve <p/> This method is used to populate the input structure for retrieving the Person
   * Characteristics information
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv24si
   */
  private CINV24SI populateCINV24SI_Retrieve(GrndsExchangeContext context) {
    CINV24SI cinv24si = new CINV24SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(100);
    cinv24si.setArchInputStruct(input);
    cinv24si.setDtScrDtCharEffDate(null);
    cinv24si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    return cinv24si;
  }

  /**
   * populateCINV04SI_Retrieve <p/> This method is used to populate the input structure for retrieving person detail
   * information.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv04si
   */
  public CINV04SI populateCINV04SI_Retrieve(GrndsExchangeContext context) {
    CINV04SI cinv04si = new CINV04SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(10);

    cinv04si.setArchInputStruct(input);
    cinv04si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    cinv04si.setSzSysCdWinMode(PersonHelper.getPersonDetailPageMode(request));
    cinv04si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv04si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    // SIR 14516
    cinv04si.setUlIdCase(GlobalData.getUlIdCase(request));
    return cinv04si;
  }
  
//Navigation Constants
  private static final String NAV_INV_CONCLUSION = "navInvConclusion";
  private static final String NAV_ONG_FAMILY_PLAN_DETAIL = "navOngFamPlanDtl";
  private static final String NAV_LEGAL_STATUS_DETAIL = "navLegalStatDetail";
  private static final String NAV_LEGAL_STATUS_LIST = "navLegalStatList";
  private static final String NAV_CONTACT_SEARCH_LIST = "navContactSearchList";
  private static final String NAV_INTAKE_ACTIONS = "navIntakeActions";
  private static final String NAV_SAFETY_RESOURCE_LIST = "navSafetyResourceList";
  private static final String NAV_TEAM_MEETINGS_REVIEWS_LIST = "navTeamMeetingsRevList";
  private static final String NAV_RISK_REASSESSMENT_LIST = "navRiskReAssessmentList";
  private static final String NAV_LEGAL_ACTION_OUTCOME_LIST = "navLegalActionOutcomeList";
  private static final String NAV_ELGIBILITY_SUMMARY_LIST = "navEligibilitySummaryList";
  private static final String NAV_CHILD_PLAN_LIST = "navChildPlanList";
  private static final String NAV_HEALTH_LOG = "navHealthLog";
  private static final String NAV_WTLP_LIST = "navWTLPList";
  private static final String NAV_PERSON_DETAIL = "navPersonDetail";
  private static final String NAV_PERSON_LIST = "navPersonList";
  private static final String NAV_CUSTODY = "navCustody";
  private static final String NAV_PLACEMENT = "navPlacement";
  private static final String NAV_PERSON_CHARACTERISTICS = "navPersonChar";
  private static final String NAV_HOME_INFO = "navHomeInfo";
  private static final String NAV_CARETAKER_INFO = "navCaretakerInfo";
  private static final String NAV_ADOPTION_ASSISTANCE_LIST = "navAdoptionAssistanceList";
  private static final String NAV_CASE_MAINTENANCE = "navCaseMaintenance";
  private static final String NAV_CASE_SUMMARY = "navCaseSummary";
  private static final String NAV_ALLEGATION_LIST = "navAllegationList";
  private static final String NAV_SVC_AUTH_LIST = "navSvcAuthList";
  private static final String NAV_PLACEMENT_LIST = "navPlacementList";
  private static final String NAV_FOSTER_FAMILY_PLAN_DETAIL_AFCARS = "navFosterFamPlanDtlAfcars";
  private static final String NAV_FAD_HOME_PERSON_LIST = "navFadHomePersonList";
  private static final String NAV_EVENT_LIST = "navEventList";
  private static final String NAV_EVENT_LIST_INT = "navEventListInt";

  //Navigation URLS
  private static final String INV_CONCLUSION = "/investigation/CPSInvCnclsn/displayCPSInvCnclsn";
  private static final String ONG_FAMILY_PLAN_LIST = "/workload/EventSearch/displayEventList";
  private static final String ONG_FAMILY_PLAN_DETAIL = "/serviceDelivery/FamilyPlan/displayFamilyPlan";
  private static final String FOSTER_FAMILY_PLAN_DETAIL = "/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail";
  private static final String FOSTER_FAMILY_PLAN_LIST = "/workload/EventSearch/displayEventList";
  private static final String LEGAL_STATUS_DETAIL = "/subcare/LegalStatus/displayLegalStatus";
  private static final String LEGAL_STATUS_LIST = "/workload/EventSearch/displayEventList";
  private static final String CONTACT_SEARCH_LIST = "/contacts/ContactSearchListDetail/displayContactSearchList";
  private static final String INTAKE_ACTIONS = "/intake/IntakeActions/displayIntakeActions";
  private static final String SAFETY_RESOURCE_LIST = "/workload/EventSearch/displayEventList";
  private static final String TEAM_MEETINGS_REVIEWS_LIST = "/workload/EventSearch/displayEventList";
  private static final String RISK_REASSESSMENT_LIST = "/workload/EventSearch/displayEventList";
  private static final String LEGAL_ACTION_OUTCOME_LIST = "/workload/EventSearch/displayEventList";
  private static final String ELIGIBILITY_SUMMARY_LIST = "/workload/EventSearch/displayEventList";
  private static final String CHILD_PLAN_LIST = "/workload/EventSearch/displayEventList";
  private static final String HEALTH_LOG = "/workload/EventSearch/displayEventList";
  private static final String WTLP_LIST = "/workload/EventSearch/displayEventList";
  private static final String PERSON_DETAIL = "/person/PersonDetail/displayPersonDetail";
  private static final String PERSON_LIST = "/person/PersonList/displayPersonList";
  private static final String CUSTODY = "/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemoval";
  private static final String PLACEMENT = "/subcare/Placement/displayPlacement";
  private static final String PERSON_CHARACTERISTICS = "/person/PersonDetail/displayPersonChar";
  private static final String HOME_INFO = "/fad/HomeInfrmtn/displayInitHomeInformation";
  private static final String CARETAKER_INFO = "/resource/Caretaker/displayCaretakerInformation";
  private static final String ADOPTION_ASSISTANCE_LIST = "/workload/EventSearch/displayEventList";
  private static final String CASE_MAINTENANCE = "/workload/CaseMnt/displayCaseMnt";
  private static final String CASE_SUMMARY = "/workload/CaseSummary/displayCaseSummary";
  private static final String ALLEGATION_LIST = "/investigation/Allegation/displayAllgtnList";
  private static final String SVC_AUTH_LIST = "/workload/EventSearch/displayEventList";
  private static final String PLACEMENT_LIST = "/workload/EventSearch/displayEventList";
  private static final String CUSTODY_LIST = "/workload/EventSearch/displayEventList";
  private static final String CASE_WATCH = "/casemgmt/CaseWatch/displayCaseWatch";
  private static final String EVENT_LIST = "/workload/EventSearch/displayEventList";

  //Task Codes
  private static final String FAMILY_PLAN_LIST_FPR = "7080";
  private static final String FOSTER_FAMILY_PLAN_LIST_FSU = "7065";
  private static final String LEGAL_STATUS_LIST_SUB = "3050"; 
  private static final String LEGAL_STATUS_LIST_ADO = "8560";
  private static final String SAFETY_RESOURCE_LIST_INV = "2277"; 
  private static final String SAFETY_RESOURCE_LIST_FPR = "7331";
  private static final String TEAM_MEETINGS_REVIEWS_LIST_SUB = "3180";
  private static final String TEAM_MEETINGS_REVIEWS_LIST_ADO = "8680";
  private static final String TEAM_MEETINGS_REVIEWS_LIST_FSU = "5960";
  private static final String TEAM_MEETINGS_REVIEWS_LIST_FPR = "5940";
  private static final String RISK_REASSESSMENT_LIST_FPR = "7385";
  private static final String LEGAL_ACTION_OUTCOME_LIST_SUB = "3030";
  private static final String LEGAL_ACTION_OUTCOME_LIST_ADO = "8540";
  private static final String LEGAL_ACTION_OUTCOME_LIST_INV = "2355";
  private static final String LEGAL_ACTION_OUTCOME_LIST_FPR = "7210";
  private static final String ELIGIBILITY_SUMMARY_LIST_SUB = "3120";
  private static final String ELIGIBILITY_SUMMARY_LIST_ADO = "8620";
  private static final String CHILD_PLAN_LIST_SUB = "3160"; 
  private static final String CHILD_PLAN_LIST_ADO = "8660";
  private static final String HEALTH_LOG_SUB = "3240";
  private static final String HEALTH_LOG_ADO = "8740";
  private static final String WTLP_LIST_SUB = "9510"; 
  private static final String WTLP_LIST_ADO = "8580";
  private static final String ADOPTION_ASSISTANCE_LIST_ADO = "9115";
  private static final String SVC_AUTH_LIST_INV = "2310";
  private static final String SVC_AUTH_LIST_FPR = "7100";
  private static final String PLACEMENT_LIST_SUB = "3080";
  private static final String PLACEMENT_LIST_ADO = "8590";
  private static final String CUSTODY_LIST_INV = "2350"; 
  private static final String CUSTODY_LIST_FPR = "7190"; 
  private static final String CUSTODY_LIST_FSU = "4330";

}
