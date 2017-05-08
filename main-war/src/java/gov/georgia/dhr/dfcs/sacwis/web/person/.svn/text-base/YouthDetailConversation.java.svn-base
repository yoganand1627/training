package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for resources from the Resource Search page and refine a search,
 * conduct a new search, and display selected list from the Resource List page.
 * <p/>
 * Declare your conversation class and have it extend BaseHiddenFieldStateConversation class.
 * <p/>
 * Note that the "<code>&lt;pre&gt;</code>" tag below is necessary to prevent the change history from being reformatted
 * by code formatting tools.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class YouthDetailConversation extends BaseHiddenFieldStateConversation {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static final String TRACE_TAG = "YouthDetailConversation";
  public static final int YOUTH_DETAIL_AGE = 13;
  public static final List<String> YDP_UNIT_SPECIALIZATION = Arrays.asList(CodesTables.CSPCUNTS_ILP);

  /**
   * Create a private field for each service EJB used.
   * <p/>
   * <i>Please make sure that they are in alphabetical order!</i>
   */
  private Person person = null;

  /**
   * Create a public setter for each service EJB used.
   * <p/>
   * <i>Please make sure that they are in alphabetical order!</i>
   *
   * @param resource
   */
  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * <p/>
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveYouthDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveYouthDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    try {
      YouthDetailSaveSI youthDetailToSave = populateSaveSI(request);
      person.saveYouthDetail(youthDetailToSave);
      // set page mode to modify in case it was NEW
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }


  /**
   * <p/>
   * This service calls the RetrieveYouthDetail service to get details about a child based on child's id.  It
   * retrieves the id person in question from GlobalData.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayYouthDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayYouthDetail_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String pageMode = PageMode.getPageMode(request);
    state.removeAllAttributes(request);
    
    try {
      YouthDetailRetrieveSI youthDetailRetrieveSI = populateRetrieveSI(request);
      YouthDetailRetrieveSO youthDetailRetrieveSO = person.retrieveYouthDetail(youthDetailRetrieveSI);
      state.setAttribute("YOUTH_DETAIL", youthDetailRetrieveSO, request);
      
      //-- page mode logic
      boolean ydpCoordinator = isUserYDPCoordinator(request);
      boolean stageAccess = hasStageAccess(request);
      // SMS #74114: MR-067
      boolean isEmpClassILC = youthDetailRetrieveSO.getIsUserEmpClassILC();
      if (youthDetailRetrieveSO.getIdPerson() == 0) {
        pageMode = PageModeConstants.NEW;
      } else if (ydpCoordinator || stageAccess || isEmpClassILC) {
        pageMode = PageModeConstants.EDIT;
      }  
      if (!stageAccess && !ydpCoordinator && !isEmpClassILC) {
        pageMode = PageModeConstants.VIEW;
      }
      PageMode.setPageMode(pageMode, request);
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  public static boolean isUserYDPCoordinator(HttpServletRequest request) {
    UserProfile user = UserProfileHelper.getUserProfile(request);
    if(!user.hasRight(UserProfile.SEC_REGIONAL_SS_STF)) {
      return false; //-- no point in performing logic below if user does not have this sec attr
    }
    
    boolean ydpUnitSpecialization = false;
    BaseSessionStateManager state = getSessionStateManager(request);
    YouthDetailRetrieveSO so = (YouthDetailRetrieveSO) state.getAttribute("YOUTH_DETAIL", request);
    if(so != null) {
      String cdUserUnitSpec = so.getCdUserUnitSpecialization();
      ydpUnitSpecialization = YDP_UNIT_SPECIALIZATION.contains(cdUserUnitSpec);
    }
    return ydpUnitSpecialization;
  }
  
  public static boolean hasStageAccess(HttpServletRequest request) {
    int ulIdStage = GlobalData.getUlIdStage(request);
    int userID = UserProfileHelper.getUserProfile(request).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }
  
  private YouthDetailRetrieveSI populateRetrieveSI(HttpServletRequest request) {
    YouthDetailRetrieveSI youthRetrieveSI = new YouthDetailRetrieveSI();
    youthRetrieveSI.setIdPerson(GlobalData.getUlIdPerson(request)); 
    
    UserProfile user = UserProfileHelper.getUserProfile(request);
    youthRetrieveSI.setIdUser(user.getUserID());
    
    return youthRetrieveSI;
  }
  
  private YouthDetailSaveSI populateSaveSI(HttpServletRequest request) {
    YouthDetailSaveSI youthDetailToSave = new YouthDetailSaveSI();
    youthDetailToSave.setIdPerson(GlobalData.getUlIdPerson(request)); 
    youthDetailToSave.setCdParentalStatus(ContextHelper.getStringSafe(request, "selSzCdParentStat"));
    youthDetailToSave.setDtEmancipationDiscussionDate(ContextHelper.getJavaDateSafe(request, "dtEmanDisc"));
    youthDetailToSave.setTxtEmancipationDiscussionCmnt(ContextHelper.getStringSafe(request, "txtEmanDiscCmnt"));
    youthDetailToSave.setIndLifeSkillsTrainingRecvd(ContextHelper.getStringSafe(request, "rbLST_Recvd"));
    youthDetailToSave.setTxtIndLifeSkillsTrainingRecvd(ContextHelper.getStringSafe(request, "txtLSTCmnt"));
    youthDetailToSave.setIndEmploymentServiceRecvd(ContextHelper.getStringSafe(request, "rbES_Recvd"));
    youthDetailToSave.setTxtIndEmploymntServiceRecvd(ContextHelper.getStringSafe(request, "txtESCmnt"));
    youthDetailToSave.setIndHealthServiceRecvd(ContextHelper.getStringSafe(request, "rbHS_Recvd"));
    youthDetailToSave.setTxtIndHealthServiceRecvd(ContextHelper.getStringSafe(request, "txtHSCmnt"));
    // Highschool Information section
    youthDetailToSave.setTxtHiSchoolName(ContextHelper.getStringSafe(request, "txtHsName"));
    youthDetailToSave.setDtExpectdHiSchoolGradtn(ContextHelper.getJavaDateSafe(request, "dtExpectedHsGrad"));
    youthDetailToSave.setCdAcademicTrack(ContextHelper.getStringSafe(request, "selAcademicTrack"));
    youthDetailToSave.setTxtCreditsRequired(ContextHelper.getStringSafe(request, "txtHsCreditsReq"));
    youthDetailToSave.setTxtCreditsEarned(ContextHelper.getStringSafe(request, "txtHsCreditsEarned"));
    youthDetailToSave.setTxtHsCurrentGPA(ContextHelper.getStringSafe(request, "txtHsCurrentGPA"));
    youthDetailToSave.setTxtHsCumulativeGPA(ContextHelper.getStringSafe(request, "txtHsCumulativeGPA"));
    youthDetailToSave.setIndHsGraduate(ContextHelper.getStringSafe(request, "cbxIndHsGrad"));
    youthDetailToSave.setTxtIndHsGradteCmnt(ContextHelper.getStringSafe(request, "txtHsGradCmnt"));
    // GED Information section
    youthDetailToSave.setTxtGEDProgramName(ContextHelper.getStringSafe(request, "txtGEDProgName"));
    youthDetailToSave.setIndInGEDProgram(ContextHelper.getStringSafe(request, "cbxIndGEDProg"));
    youthDetailToSave.setTxtGEDProgAddressLine1(ContextHelper.getStringSafe(request, "txtGEDProgAddressLine1"));
    youthDetailToSave.setTxtGEDProgAddressLine2(ContextHelper.getStringSafe(request, "txtGEDProgAddressLine2"));
    youthDetailToSave.setTxtGEDProgCity(ContextHelper.getStringSafe(request, "txtGEDProgCity"));
    youthDetailToSave.setCdGEDProgState(ContextHelper.getStringSafe(request, "selGEDProgCdState"));
    String zipCode = ContextHelper.getStringSafe(request, "txtGEDProgZip");
    String zipSuff = ContextHelper.getStringSafe(request, "txtGEDProgZipSuff");
    if (StringHelper.isValid(zipSuff)) {
      zipCode = zipCode + "-" + zipSuff;
    }
    youthDetailToSave.setTxtGEDProgZipCode(zipCode);
    youthDetailToSave.setTxtGEDProgPhoneNum(ContextHelper.getPhoneSafe(request, "txtGEDProgPhoneNumber"));
    youthDetailToSave.setTxtGEDProgFaxNum(ContextHelper.getPhoneSafe(request, "txtGEDProgFaxNumber"));
    youthDetailToSave.setDtExpectdGEDProgramComp(ContextHelper.getJavaDateSafe(request, "dtExpectedGEDComp"));
    youthDetailToSave.setDtActualGEDProgramComp(ContextHelper.getJavaDateSafe(request, "dtActualGEDComp"));
    // Post secondary education section
    youthDetailToSave.setTxtPostInstitutionName(ContextHelper.getStringSafe(request, "txtPostInstitutionName"));
    youthDetailToSave.setCdPostEduGoal(ContextHelper.getStringSafe(request, "selPostCdEduGoal"));
    youthDetailToSave.setCdPostClassification(ContextHelper.getStringSafe(request, "selPostCdClassif"));
    youthDetailToSave.setTxtPostAreaofStudy(ContextHelper.getStringSafe(request, "txtPostAreaStudy"));
    youthDetailToSave.setTxtPostCurrentGPA(ContextHelper.getStringSafe(request, "txtPostCurrentGPA"));
    youthDetailToSave.setTxtPostCumulativeGPA(ContextHelper.getStringSafe(request, "txtPostCumulativeGPA"));
    youthDetailToSave.setTxtPostReqdCreditsforGradtn(ContextHelper.getStringSafe(request, "txtPostCreditsReqGrad"));
    youthDetailToSave.setTxtPostEarndCreditsforGradtn(ContextHelper.getStringSafe(request, "txtPostCreditsEarnedGrad"));
    youthDetailToSave.setDtPostExpectdGradtn(ContextHelper.getJavaDateSafe(request, "dtExpectedPostGrad"));
    youthDetailToSave.setDtPostActualGradtn(ContextHelper.getJavaDateSafe(request, "dtActualPostGrad"));
    
    Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, "hdnDtLastUpdateYouthDetail");
    youthDetailToSave.setDtLastUpdate(dtLastUpdate);
    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      youthDetailToSave.setCReqFunc(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      youthDetailToSave.setCReqFunc(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    return youthDetailToSave;
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

}