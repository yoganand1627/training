package gov.georgia.dhr.dfcs.sacwis.web.exchange;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.ExchangeHomeSearch;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to search exchange homes in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 *   07/01/08  mchillman      creation
 *   02/20/09  hjbaptiste     STGAP00012437: in displayExchangeHomeDetail_xa, set the necessary context parameter
 *                                           key to show the Exchange Home 3rd level tab
 * </pre>
 */

public class ExchangeHomeSearchConversation extends BaseHiddenFieldStateConversation {
  public static final String PAGE_MODE = PageMode.PAGE_MODE_ATTRIBUTE_NAME;
  public static final int FAD_MAX_AGE_YR = 19;
  public static final int FAD_MIN_AGE_YR = 0;
  public static final int FAD_MAX_AGE_MO = 11;
  public static final int FAD_MIN_AGE_MO = 0;
  
  public static final String SEARCH_PAGE = "/exchange/ExchangeHomeSearch/searchExchangeHome";
  public static final String DISPLAY_SEARCH_PAGE = "/exchange/ExchangeHomeSearch/displayExchangeHomeSearch";
  public static final String EX_HOME_CONVERSATION_URL = "/exchange/ExchangeHomeSearch/";
  public static final String EXCHANGE_HOME_LIST = "ExchangeHomeList";
  public static final String EXCHANGE_HOME_SEARCH_BEAN = "ExchangeHomeSearchBean";
  public static final String PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME = "exchangeHomePullBackSearchBean";
  public static final String PULLBACK_RETURN_ATTRIBUTE_NAME = "exchangeHomePullBackInfo";
  public static final String PULLBACK_RETURN_ATTRIBUTE_NAME_FROM_STATE= "exchangeHomePullBackInfoFromState";
  public static final String EXCHANGE_HOME_STATE = "exchangeHomeSearchState";
  
  public static final int SEARCH_RESULTS_PER_PAGE = 20;
  public static final String FAD = "FAD";
  public static final String CPS = "CPS";
  public static final String EXC_HOME_TASK = "8085";
  
  ExchangeHomeSearch exchangeHomeSearch = null;
  
  public void setExchangeHomeSearch(ExchangeHomeSearch exchangeHomeSearch) {
    this.exchangeHomeSearch = exchangeHomeSearch;
  }
  
  public void displayExchangeHomeSearch_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExchangeHomeSearch_xa()");
    performanceTrace.enterScope();
    
    makeMaxMinAgeDropdowns(context);
    ExchangeHomeValueBean exHomeValueBean = new ExchangeHomeValueBean();
    request.setAttribute(EXCHANGE_HOME_SEARCH_BEAN, exHomeValueBean);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    performanceTrace.exitScope();
  }
  
  public void exchangeHomeSearch_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".exchangeHomeSearch_xa()");
    performanceTrace.enterScope();
      
    try {
      
      //Get the destination URL if it was passed in by the calling page and set it into state.
      ExchangeHomeValueBean exHomeValueBean = (ExchangeHomeValueBean) request.getAttribute(PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME);
      String sortColumn = request.getParameter(SortableColumnTag.ORDER_BY_NAME);
      String requestedPage = request.getParameter(ResultsPaginationHelper.REQUESTED_PAGE_KEY);
      
      if (exHomeValueBean != null) {
        state.setAttribute("destinationURL", ((ExchangeHomeSearchPullBack) exHomeValueBean).getDestinationUrl(), request);
        state.setAttribute("pullBackMode", ArchitectureConstants.TRUE, request);
        state.removeAttribute(PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME, request);
      } else {
        //check if coming from sort or pagination
        if(StringHelper.isValid(sortColumn) || StringHelper.isValid(requestedPage)){
          exHomeValueBean = (ExchangeHomeValueBean) state.getAttribute(EXCHANGE_HOME_STATE, request);
          ValueBeanHelper.populateDefaultValues(context, exHomeValueBean);
          state.removeAttribute(EXCHANGE_HOME_STATE, request);
        } else {
          exHomeValueBean = populateExchangeHomeValueBean(context);
        }
      }    
      boolean bSearch = ContextHelper.getString(request, "btnSearch.x") != null;
      if (!bSearch) {
        List<ExchangeHomeValueBean> returnHomeList = getSelectedHomesList(context);
        state.setAttribute(PULLBACK_RETURN_ATTRIBUTE_NAME_FROM_STATE, returnHomeList, request);
      }else{
        state.removeAttribute(PULLBACK_RETURN_ATTRIBUTE_NAME_FROM_STATE, request);
      }
      PaginationResultBean prb = exchangeHomeSearch.searchExchangeHome(exHomeValueBean);
      request.setAttribute(EXCHANGE_HOME_SEARCH_BEAN, exHomeValueBean);
            
      if (prb != null) {
        List vTmp = prb.getResults();
        state.setAttribute(EXCHANGE_HOME_LIST, vTmp, request);
        request.setAttribute(EXCHANGE_HOME_LIST, vTmp);
        state.setAttribute(EXCHANGE_HOME_STATE, exHomeValueBean, request);
        prb.getResultDetails().setResultsPerPage(ExchangeHomeSearchConversation.SEARCH_RESULTS_PER_PAGE);
        storePaginationBeanToRequest(context, prb);
      }
      
    } catch (TooManyRowsReturnedException tme) {
      this.setPresentationBranch("TooManyRowsReturned", context);
      String errorMessage = MessageLookup.getMessageByName("MSG_TOO_MANY_ROWS_RETURNED");
      setErrorMessage(errorMessage, DISPLAY_SEARCH_PAGE, request);
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  public void displayHomeInformationDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomeInformationDetail_xa()");
    performanceTrace.enterScope();
   
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String recordNumber = StringHelper.getSafeString(request.getParameter("indexNum"));
    int iRecordNumber = 0;
    if (recordNumber != null) {
      iRecordNumber = Integer.parseInt(recordNumber);
    }

    ExchangeHomeValueBean homeSearchValueBean = null;
    List<ExchangeHomeValueBean> exchangeHomeList = (List<ExchangeHomeValueBean>) state.getAttribute(EXCHANGE_HOME_LIST, request);
    if (exchangeHomeList != null) {
      homeSearchValueBean = (ExchangeHomeValueBean) exchangeHomeList.get(iRecordNumber);
    }
    
    getPageMode(request, homeSearchValueBean.getCdFAHomeStatus());
    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, getPageMode(request, null), request);
    Integer idStage = homeSearchValueBean.getIdHomeStage();
    GlobalData.setUlIdStage(idStage, request);
    CaseUtility.Stage myStage = CaseUtility.getStage(idStage);
    String caseName = myStage.getNmCase();
    GlobalData.setSzNmCase(caseName, request);
    GlobalData.setUlIdCase(CaseUtility.getStage(idStage).getIdCase(), request);
    GlobalData.setSzCdStage(FAD, request);
    GlobalData.setSzNmStage(myStage.getNmStage(), request);
    GlobalData.setSzCdStageProgram(CPS, request);

    performanceTrace.exitScope();
  }
  
  public void displayExchangeHomeDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomeInformationDetail_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String recordNumber = StringHelper.getSafeString(request.getParameter("indexNum"));
    int iRecordNumber = 0;
    if (recordNumber != null) {
      iRecordNumber = Integer.parseInt(recordNumber);
    }

    ExchangeHomeValueBean homeSearchValueBean = null;
    List<ExchangeHomeValueBean> exchangeHomeList = (List) state.getAttribute(EXCHANGE_HOME_LIST, request);
    if (exchangeHomeList != null) {
      homeSearchValueBean = (ExchangeHomeValueBean) exchangeHomeList.get(iRecordNumber);
    }
    
    getPageMode(request, homeSearchValueBean.getCdFAHomeStatus());
    state.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, getPageMode(request, null), request);
    Integer idStage = homeSearchValueBean.getIdHomeStage();
    GlobalData.setUlIdStage(idStage, request);
    CaseUtility.Stage myStage = CaseUtility.getStage(idStage);
    String caseName = myStage.getNmCase();
    GlobalData.setSzNmCase(caseName, request);
    GlobalData.setUlIdCase(CaseUtility.getStage(idStage).getIdCase(), request);
    GlobalData.setSzCdStage(FAD, request);
    GlobalData.setSzNmStage(myStage.getNmStage(), request);
    GlobalData.setSzCdStageProgram(CPS, request);
    GlobalData.setUlIdEvent(homeSearchValueBean.getIdExchangeHome(), request);
    GlobalData.setSzCdTask(EXC_HOME_TASK, request);
    GlobalData.setUlIdResource(homeSearchValueBean.getIdResource(), request);
    // STGAP00012437: Show the Exchange Home 3rd level tab so user can access the Exchange Home List Page
    state.setContextParameter("_exchangeHomeDetailAvailable" + homeSearchValueBean.getIdResource(), ArchitectureConstants.Y, request);
    
    performanceTrace.exitScope();
  }
  
  public void pullBackExchangeHomeDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".pullBackExchangeHomeDetail_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      List<ExchangeHomeValueBean> returnHomeList = getSelectedHomesList(context);
      request.setAttribute(PULLBACK_RETURN_ATTRIBUTE_NAME, returnHomeList);
      state.removeAttribute(PULLBACK_RETURN_ATTRIBUTE_NAME_FROM_STATE, request);
      String destinationURL = (String) state.getAttribute("destinationURL", request);
      if (destinationURL == null || destinationURL.length() == 0) {
        throw new IllegalArgumentException("The destination Url is null");
      } else {
        destinationURL = (String) state.getAttribute("destinationURL", request);
        state.removeAttribute("destinationURL", request);
      }
      // Forward the conversation to the destinationURL passed in from the
      // calling page!
      forward(destinationURL, request, context.getResponse());
    } catch (Exception e) {
      handleException(e, context, "pullBackExchangeHomeDetail_xa");
    }
    performanceTrace.exitScope();
  }
  
  /**
   * Creates the Male and Female Age Range dropdown options.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void makeMaxMinAgeDropdowns(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "makeMaleFemaleMaxMinAgeDropdowns");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      SortedMap<Integer, Option> years = new TreeMap<Integer, Option>();
      SortedMap<Integer, Option> months = new TreeMap<Integer, Option>();
      int yearCount = FAD_MIN_AGE_YR;
      int monthCount = FAD_MIN_AGE_MO;
      Option anOption;

      while (yearCount <= FAD_MAX_AGE_YR) {
        anOption = new Option(String.valueOf(yearCount), String.valueOf(yearCount));
        years.put(yearCount++, anOption);
      }

      state.setAttribute("yearsrange", years, request);

      while (monthCount <= FAD_MAX_AGE_MO) {
        anOption = new Option(String.valueOf(monthCount), String.valueOf(monthCount));
        months.put(monthCount++, anOption);
      }
      state.setAttribute("monthsrange", months, request);
    } catch (Exception e) {
      handleException(e, context, "makeMaxMinAgeDropdowns");
    }

    performanceTrace.exitScope();
  }
  
  private ExchangeHomeValueBean populateExchangeHomeValueBean(GrndsExchangeContext context) {
    ExchangeHomeValueBean exchangeHomeBean = new ExchangeHomeValueBean();
    HttpServletRequest request = context.getRequest();
    
    exchangeHomeBean.setHomeName(request.getParameter("txtHomeName"));
    exchangeHomeBean.setIdResource(ContextHelper.getIntSafe(request, "txtResourceId"));
    exchangeHomeBean.setCdStatus(request.getParameter("selSzCdRsrcFaHomeStatus"));
    exchangeHomeBean.setCdCategory(request.getParameter("selSzCdRsrcCategory"));
    exchangeHomeBean.setCdCounty(request.getParameter("selSzCdRsrcCnty"));
    exchangeHomeBean.setCdRegion(request.getParameter("selSzCdRsrcRegion"));
    exchangeHomeBean.setAgency(request.getParameter("selSzAgecy"));
    exchangeHomeBean.setAgencyCode(request.getParameter("txtAgencyCode"));
    exchangeHomeBean.setDtInquired(ContextHelper.getJavaDateSafe(request, "dtInquiry"));
    exchangeHomeBean.setNumOfChildren(ContextHelper.getIntSafe(request, "txtNbrOfChldrn"));
    
    String[] nonAvaCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbNonAvailCodes");    
    exchangeHomeBean.setLstCdNonAvaCodes((nonAvaCheckedBoxes != null && nonAvaCheckedBoxes.length > 0) ? Arrays.asList(nonAvaCheckedBoxes) : null);
        
    String cbxMentalRetardation = request.getParameter("cbxMentalRetardation");
    exchangeHomeBean.setIndMentalRetardation(cbxMentalRetardation);
    exchangeHomeBean.setCdLevelMentalRetardation(("".equals(cbxMentalRetardation) || cbxMentalRetardation == null)? null : request.getParameter("selSzCdMentalRetardation"));
    String cbxVisualHearingImpairments = request.getParameter("cbxVisualHearingImpairments");
    exchangeHomeBean.setIndVisualHearingImpairments(cbxVisualHearingImpairments);
    exchangeHomeBean.setCdLevelVisualHearingImpairments(("".equalsIgnoreCase(cbxVisualHearingImpairments) || cbxVisualHearingImpairments == null) ? null :request.getParameter("selSzCdVisualHearingImpairments"));
    String cbxPhysicallyDisabled = request.getParameter("cbxPhysicallyDisabled");
    exchangeHomeBean.setIndPhysicallyDisabled(cbxPhysicallyDisabled);
    exchangeHomeBean.setCdLevelPhysicallyDisabled(("".equals(cbxPhysicallyDisabled) ||cbxPhysicallyDisabled == null) ? null : request.getParameter("selSzCdPhysicallyDisabled"));
    String cbxEmotionallyDisturbed = request.getParameter("cbxEmotionallyDisturbed");
    exchangeHomeBean.setIndEmotionallyDisturbed(cbxEmotionallyDisturbed);
    exchangeHomeBean.setCdLevelEmotionallyDisturbed(("".equals(cbxEmotionallyDisturbed) || cbxEmotionallyDisturbed == null) ? null :request.getParameter("selSzCdEmotionallyDisturbed"));
    String cbxOtherMedicalDiagnoses = request.getParameter("cbxOtherMedicalDiagnoses");
    exchangeHomeBean.setIndOtherMedicalDiagnoses(cbxOtherMedicalDiagnoses);
    exchangeHomeBean.setCdlevelOtherMedicalDiagnoses(("".equals(cbxOtherMedicalDiagnoses) || cbxOtherMedicalDiagnoses == null) ? null : request.getParameter("selSzCdOtherMedicalDiagnoses"));
    
    exchangeHomeBean.setIndFamilyHxofDrugsAlcohol(request.getParameter("cbxFamilyHxofDrugsAlcohol"));
    exchangeHomeBean.setIndFamilyHxofMentalIllness(request.getParameter("cbxFamilyHxofMentalIllness"));
    exchangeHomeBean.setIndFamilyHxofMR(request.getParameter("cbxFamilyHxofMR"));
    exchangeHomeBean.setIndChilsHxofSexualAbuse(request.getParameter("cbxChilsHxofSexualAbuse"));
    exchangeHomeBean.setNumOfChildren(ContextHelper.getIntSafe(context, "txtNbrOfChldrn"));
    
    String[] raceCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbxRace");
    exchangeHomeBean.setChildRacePref((raceCheckedBoxes != null && raceCheckedBoxes.length > 0) ? Arrays.asList(raceCheckedBoxes) : null);
    
    String[] ethnicityCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbxEth");  
    exchangeHomeBean.setChildEthnicityPerf((ethnicityCheckedBoxes != null && ethnicityCheckedBoxes.length > 0) ? Arrays.asList(ethnicityCheckedBoxes) : null);
    
    exchangeHomeBean.setCdGender(request.getParameter("selSzCdGender"));
    
    int minYear = ContextHelper.getIntSafe(context, "selMinYear");
    int minMonth = ContextHelper.getIntSafe(context, "selMinMonth");
    int minimumAgeInMonths = (minYear * 12) + minMonth;
    int maxYear = ContextHelper.getIntSafe(context, "selMaxYear");
    int maxMonth = ContextHelper.getIntSafe(context, "selMaxMonth");
    int maximumAgeInMonths = (maxYear * 12) + maxMonth;
    exchangeHomeBean.setMaxRangeInMonths(maximumAgeInMonths);
    exchangeHomeBean.setMinRangeInMonths(minimumAgeInMonths);
    
  
    ValueBeanHelper.populateDefaultValues(context, exchangeHomeBean);
    
    return exchangeHomeBean;
  }
  
  private void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    String stackTrace = BasePrsException.getStackTrace(e);
    HttpServletRequest request = context.getRequest();
    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "ServiceException " + we.getClass() + " " + we.getMessage());
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, DISPLAY_SEARCH_PAGE, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "General Exception " + e.getClass() + " " + e.getMessage()
                                                      + stackTrace);
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  //STGAP00011426: This method generates the selected homes list across the paginated pages
  private List<ExchangeHomeValueBean> getSelectedHomesList(GrndsExchangeContext context) {

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String[] selectedChildren = CheckboxHelper.getCheckedValues(request, "cbContinue_");
    List<ExchangeHomeValueBean> returnHomeList = new ArrayList<ExchangeHomeValueBean>();
    //This is the Exchange home list that is being currently displayed on the page
    List<ExchangeHomeValueBean> exchangeHomeList = (List<ExchangeHomeValueBean>) state.getAttribute(EXCHANGE_HOME_LIST,
                                                                                                    request);
    //This is the list of selected homes that are already selected in other pages before coming to the current page if any
    List<ExchangeHomeValueBean> selectedHomesList = (List<ExchangeHomeValueBean>) state
                                                                                       .getAttribute(
                                                                                                     PULLBACK_RETURN_ATTRIBUTE_NAME_FROM_STATE,
                                                                                                     request);
    // This if block is to refresh the selected homes list with current selection in the scenario where the user selects some 
    // homes on a page and comes back to the same page.What the code does here is remove all the homes selected previously on 
    // this page. The new selections or same selections if the user does not make any changes are added to the return list in 
    // the second for loop in this block.
    if (selectedHomesList != null && selectedHomesList.size() > 0) {
      for (int j = 0; j < selectedHomesList.size(); j++) {
        boolean indPrevSelected = false;
        ExchangeHomeValueBean exHmValueBn = selectedHomesList.get(j);
        for(int k=0; k<exchangeHomeList.size(); k++){
          if(exHmValueBn.getIdResource().equals(exchangeHomeList.get(k).getIdResource())){
            indPrevSelected = true;
            break;
          }
        }
        if (!indPrevSelected) {
          returnHomeList.add(exHmValueBn);
        }
      }
    }
    for (int i = 0; i < selectedChildren.length; i++) {
      int indexSelected = Integer.parseInt(selectedChildren[i]);
      returnHomeList.add(exchangeHomeList.get(indexSelected));
    }
    return returnHomeList;
  }
  
  protected static String getPageMode(HttpServletRequest request, String sHomeStatus) {
    String pageMode = PageModeConstants.VIEW;
    
    return pageMode;
  }
}
