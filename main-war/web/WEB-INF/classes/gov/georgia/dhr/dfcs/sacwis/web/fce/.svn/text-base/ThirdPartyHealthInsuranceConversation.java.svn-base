package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.ThirdPartyHealthInsurance;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class used to create or modify Child Health Insurance Information for Foster Care Child.
 * 
 * @author Gautami Rout, Dec 21, 2006 <p/>
 * 
 * <pre>
 *                   Change History:
 *                   Date      User              Description
 *                   --------  ----------------  -------------------------------------------------
 * 
 */
public class ThirdPartyHealthInsuranceConversation extends FceConversation {
  private ThirdPartyHealthInsurance thirdPartyHealthInsurance;

  public void setThirdPartyHealthInsurance(ThirdPartyHealthInsurance thirdPartyHealthInsurance) {
    this.thirdPartyHealthInsurance = thirdPartyHealthInsurance;
  }
  
  public ThirdPartyHealthInsuranceConversation() {
    super(TRACE_TAG);
  }

  /**
   * <p>
   * This method displays the 3rd Party Health Insurance Detail page.
   * </p> * <blockquote>
   * <ul>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayThirdPartyHealthInsurance_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayThirdPartyHealthInsurance_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    clearState(context);
    FceUtility.setApplicationFceTabState(request);

    try {
      GlobalData.setSzCdTask(null, request);
      
      // Use saveBean to call Service save method

      ThirdPartyHealthInsuranceDB populateBean = thirdPartyHealthInsurance
                                                                          .read(
                                                                                GlobalData.getUlIdStage(request),
                                                                                GlobalData.getUlIdEvent(request),
                                                                                UserProfileHelper
                                                                                                 .getUserProfile(
                                                                                                                 request)
                                                                                                 .getUserID());
      request.setAttribute("ThirdPartyHealthInsuranceDB", populateBean);
      state.setAttribute("ListOfPrinciples", populateBean.getPrinciples(), request);

      GlobalData.setUlIdEvent((int) populateBean.getIdEvent(), request);
      String fcePageMode = FceUtility.getFceApplicationPageMode(request, populateBean);

      PageMode.setPageMode(fcePageMode, request);
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method is called when the user clicks on the Save Button. It Calls the saveThirdPartyHealthInsurance method
   * and passes the information it needs to save.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void saveThirdPartyHealthInsurance_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveThirdPartyHealthInsurance_xa");

    try {
      // clearState(context);
      saveThirdPartyHealthInsurance(context);
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Saves the ThirdPartyHealthInsuranceDB through the ThirdPartyHealthInsurance EJB.
   */
  protected void saveThirdPartyHealthInsurance(GrndsExchangeContext context) throws Exception {
    HttpServletRequest request = context.getRequest();

    ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB = readFromRequest(request);
    trace("thirdPartyHealthInsuranceDB: " + thirdPartyHealthInsuranceDB);
    
    thirdPartyHealthInsuranceDB = populateSaveBeanLists(thirdPartyHealthInsuranceDB, context);
    // Use saveBean to call Service save method
    thirdPartyHealthInsurance.save(thirdPartyHealthInsuranceDB);
  }

  
  protected static final void trace(String string) {
    FceUtility.trace(TRACE_TAG, string);
  }
  
  /** @return Input parameter ApplicationBackgroundDB object, populated with principals rows from the page. */
  private ThirdPartyHealthInsuranceDB populateSaveBeanLists(ThirdPartyHealthInsuranceDB saveBean, GrndsExchangeContext context)
          throws ParseException {
    HttpServletRequest request = context.getRequest();
    List<FcePersonDB> principals = new ArrayList<FcePersonDB>();
    // Loop through principal list inputs.
    for (int i = 0; ; i++) {
      String thirdPartyHealthInsString = "cbThirdPartyHealthIns_" + i + "_changed";
      // Break when we can't find the next input.
      if (!request.getParameterMap().containsKey(thirdPartyHealthInsString)) {
        break;
      }

      //MDM, 5/28/2003, This used to just send the changed ones;
      //unfortunately, that would complicate creating a count
      FcePersonDB principal = new FcePersonDB();
      principal.setIndThirdPartyInsurance(CheckboxHelper.getCheckboxValue(request, "cbThirdPartyHealthIns_" + i));
      principal.setIdPerson(ContextHelper.getLongSafe(request, "principalPersonId_" + i));
      principal.setDtLastUpdateTime(ContextHelper.getLongSafe(request, "principalLastUpdate_" + i));
      principal.setIdFcePerson(ContextHelper.getLongSafe(request, "principalFcePersonId_" + i));
      principal.setIdFceEligibility(saveBean.getIdFceEligibility());
      principals.add(principal);
    }

    saveBean.setPrinciples(principals);
    return saveBean;
  }
  
  public static ThirdPartyHealthInsuranceDB readFromRequest(HttpServletRequest request) {
    ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB = new ThirdPartyHealthInsuranceDB();
    populateWithRequest(thirdPartyHealthInsuranceDB, request);
    String addrZip = thirdPartyHealthInsuranceDB.getAddrZip() + thirdPartyHealthInsuranceDB.getAddrZipSuff();
    thirdPartyHealthInsuranceDB.setAddrZip(addrZip);
    return thirdPartyHealthInsuranceDB;
  }

  public static void populateWithRequest(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB,
                                         HttpServletRequest request) {

    Map map = request.getParameterMap();

    if (map.containsKey(ThirdPartyHealthInsuranceDB.ADDR_CITY)) {
      thirdPartyHealthInsuranceDB.setAddrCity(ContextHelper.getStringSafe(request,
                                                                          ThirdPartyHealthInsuranceDB.ADDR_CITY));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ADDR_ST_LN1)) {
      thirdPartyHealthInsuranceDB.setAddrStLn1(ContextHelper.getStringSafe(request,
                                                                           ThirdPartyHealthInsuranceDB.ADDR_ST_LN1));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ADDR_ST_LN2)) {
      thirdPartyHealthInsuranceDB.setAddrStLn2(ContextHelper.getStringSafe(request,
                                                                           ThirdPartyHealthInsuranceDB.ADDR_ST_LN2));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ADDR_ZIP)) {
      thirdPartyHealthInsuranceDB.setAddrZip(ContextHelper.getStringSafe(request,
                                                                         ThirdPartyHealthInsuranceDB.ADDR_ZIP));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ADDR_ZIP_SUFF)) {
      thirdPartyHealthInsuranceDB.setAddrZipSuff(ContextHelper.getStringSafe(request,
                                                                         ThirdPartyHealthInsuranceDB.ADDR_ZIP_SUFF));
    }

    if (map.containsKey(ThirdPartyHealthInsuranceDB.ADDR_STATE)) {
      thirdPartyHealthInsuranceDB.setAddrState(ContextHelper.getStringSafe(request,
                                                                           ThirdPartyHealthInsuranceDB.ADDR_STATE));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ID_FCE_APPLICATION)) {
      thirdPartyHealthInsuranceDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                                ThirdPartyHealthInsuranceDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ID_FCE_ELIGIBILITY)) {
      thirdPartyHealthInsuranceDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                                ThirdPartyHealthInsuranceDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ID_PERSON)) {
      thirdPartyHealthInsuranceDB.setIdPerson(ContextHelper.getLongSafe(request,
                                                                        ThirdPartyHealthInsuranceDB.ID_PERSON));
    }

    if (map.containsKey(ThirdPartyHealthInsuranceDB.NBR_GROUP)) {
      thirdPartyHealthInsuranceDB.setNbrGroup(ContextHelper.getStringSafe(request,
                                                                          ThirdPartyHealthInsuranceDB.NBR_GROUP));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NBR_POLICY)) {
      thirdPartyHealthInsuranceDB.setNbrPolicy(ContextHelper.getStringSafe(request,
                                                                           ThirdPartyHealthInsuranceDB.NBR_POLICY));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NM_COMPANY)) {
      thirdPartyHealthInsuranceDB.setNmCompany(ContextHelper.getStringSafe(request,
                                                                           ThirdPartyHealthInsuranceDB.NM_COMPANY));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NM_EMPLOYEE_NM)) {
      thirdPartyHealthInsuranceDB.setNmEmployeeNm(ContextHelper.getStringSafe(request,
                                                                              ThirdPartyHealthInsuranceDB.NM_EMPLOYEE_NM));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NM_EMPLOYER)) {
      thirdPartyHealthInsuranceDB.setNmEmployer(ContextHelper.getStringSafe(request,
                                                                            ThirdPartyHealthInsuranceDB.NM_EMPLOYER));
    }

    if (map.containsKey(ThirdPartyHealthInsuranceDB.IND_CHILD_COVERAGE)) {
      thirdPartyHealthInsuranceDB.setIndChildCoverage(ContextHelper.getBooleanSafe(request,
                                                                                  ThirdPartyHealthInsuranceDB.IND_CHILD_COVERAGE));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.CD_TYPE)) {
      thirdPartyHealthInsuranceDB.setCdType(ContextHelper.getStringSafe(request, ThirdPartyHealthInsuranceDB.CD_TYPE));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NBR_PHONE)) {
      thirdPartyHealthInsuranceDB.setNbrPhone(FormattingHelper.decodeFormattedPhoneString(ContextHelper.getStringSafe(request,
                                                                          ThirdPartyHealthInsuranceDB.NBR_PHONE)));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.IND_AUTH_RELEASE)) {
      thirdPartyHealthInsuranceDB.setIndAuthRelease(ContextHelper.getBooleanSafe(request,
                                                                                 ThirdPartyHealthInsuranceDB.IND_AUTH_RELEASE));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.IND_AUTH_ASSIGN)) {
      thirdPartyHealthInsuranceDB.setIndAuthAssign(ContextHelper.getBooleanSafe(request,
                                                                                ThirdPartyHealthInsuranceDB.IND_AUTH_ASSIGN));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.IND_CHANGE_CANCEL)) {
      thirdPartyHealthInsuranceDB.setIndChangeCancel(ContextHelper.getBooleanSafe(request,
                                                                                  ThirdPartyHealthInsuranceDB.IND_CHANGE_CANCEL));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.DT_AUTH_ASSIGN_DATE)) {
      thirdPartyHealthInsuranceDB.setDtAuthAssignDateString(ContextHelper.getStringSafe(
                                                                                        request,
                                                                                        ThirdPartyHealthInsuranceDB.DT_AUTH_ASSIGN_DATE));
    }

    if (map.containsKey(ThirdPartyHealthInsuranceDB.DT_AUTH_RELEASE_DATE)) {
      thirdPartyHealthInsuranceDB.setDtAuthReleaseDateString(ContextHelper.getStringSafe(request,
                                                                                         ThirdPartyHealthInsuranceDB.DT_AUTH_RELEASE_DATE));
    }

    if (map.containsKey(ThirdPartyHealthInsuranceDB.DT_CHANGE_CANCEL)) {
      thirdPartyHealthInsuranceDB.setDtChangeCancelString(ContextHelper.getStringSafe(request,
                                                                                      ThirdPartyHealthInsuranceDB.DT_CHANGE_CANCEL));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ID_EVENT)) {
      thirdPartyHealthInsuranceDB.setIdEvent(ContextHelper.getLongSafe(request,
                                                                       ThirdPartyHealthInsuranceDB.ID_EVENT));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ID_STAGE)) {
      thirdPartyHealthInsuranceDB.setIdStage(ContextHelper.getLongSafe(request, 
                                                                       ThirdPartyHealthInsuranceDB.ID_STAGE));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.CD_EVENT_STATUS)) {
      thirdPartyHealthInsuranceDB.setCdEventStatus(ContextHelper.getStringSafe(request,
                                                                               ThirdPartyHealthInsuranceDB.CD_EVENT_STATUS));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.ID_LAST_UPDATE_PERSON)) {
      thirdPartyHealthInsuranceDB.setIdLastUpdatePerson(ContextHelper.getLongSafe( request,
                                                                                  ThirdPartyHealthInsuranceDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING)) {
      thirdPartyHealthInsuranceDB.setFceApplicationDtLastUpdateString(ContextHelper.getStringSafe(
                                                                                                  request,
                                                                                                  ThirdPartyHealthInsuranceDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME)) {
      thirdPartyHealthInsuranceDB.setFceApplicationDtLastUpdateTime(ContextHelper.getLongSafe( request,
                                                                                              ThirdPartyHealthInsuranceDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.CD_POLICY_HLDR)) {
      thirdPartyHealthInsuranceDB.setCdPolicyHldr(ContextHelper.getStringSafe( request,
                                                                             ThirdPartyHealthInsuranceDB.CD_POLICY_HLDR));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.DT_BEGIN_STRING)) {
      thirdPartyHealthInsuranceDB.setDtBeginString(ContextHelper.getStringSafe( request,
                                                                             ThirdPartyHealthInsuranceDB.DT_BEGIN_STRING));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.DT_END_STRING)) {
      thirdPartyHealthInsuranceDB.setDtEndString(ContextHelper.getStringSafe( request,
                                                                             ThirdPartyHealthInsuranceDB.DT_END_STRING));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NM_EMPLOYEE_PERSON_FULL)) {
      thirdPartyHealthInsuranceDB.setNmEmployeePersonFull(ContextHelper.getStringSafe(request,
                                                                                     ThirdPartyHealthInsuranceDB.NM_EMPLOYEE_PERSON_FULL));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.NBR_EMPLOYEE_PERSON_PHONE)) {
      thirdPartyHealthInsuranceDB.setNbrEmployeePersonPhone(ContextHelper.getStringSafe(request,
                                                                                        ThirdPartyHealthInsuranceDB.NBR_EMPLOYEE_PERSON_PHONE));
    }
    if (map.containsKey(ThirdPartyHealthInsuranceDB.IND_OTHER_HEALTH_INSURANCE)) {
      thirdPartyHealthInsuranceDB.setIndOtherHealthInsurance(ContextHelper.getStringSafe(request,
                                                                                        ThirdPartyHealthInsuranceDB.IND_OTHER_HEALTH_INSURANCE));
    }
   
  }
 
}
