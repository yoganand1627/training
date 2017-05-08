package gov.georgia.dhr.dfcs.sacwis.web.exchange;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TooManyRowsReturnedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.ExchangeChildSearch;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
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
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to search exchange children in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 *   07/01/08  mchillman      creation
 *   09/26/08  vdevarak       Initial Implementation
 *   03/05/09  hjbaptiste     STGAP00012712: in displayExchangeChildDetail_xa, set the necessary context parameter
 *                                           key to show the Exchange Child Detail 3rd level tab
 *   04/02/09  mxpatel        STGAP00012694: Added code to verify if ECD is in NEW status and display an error message if it is.     
 *   11/19/09  arege          SMS#37251 Set cdCounty in the exchangeChildValueBean so that it can be pulled on the Exchange Child Search page
 *                            after you come back from a search.                                     
 * </pre>
 */
public class ExchangeChildSearchConversation extends BaseHiddenFieldStateConversation {
  public static final String PAGE_MODE = PageMode.PAGE_MODE_ATTRIBUTE_NAME;

  public static final String PULLBACK_RETURN_ATTRIBUTE_NAME = "selectedExchangeChildValueBeanList";

  public static final String PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME = "exchangeChildPullBackSearchBean";

  public static final int MAX_AGE_YR = 19;

  public static final int MIN_AGE_YR = 0;

  public static final int MAX_AGE_MO = 11;

  public static final int MIN_AGE_MO = 0;

  public static final String SEARCH_URL = "/exchange/ExchangeChildSearch/searchExchangeChild";

  public static final String DISPLAY_URL = "/exchange/ExchangeChildSearch/displayExchangeChildSearch";

  public static final String CONVERSATION_URL = "/exchange/ExchangeChildSearch/";

  public static final String EXCHANGE_CHILD_LIST = "ExchangeChildList";

  public static final String EXCHANGE_CHILD_SEARCH_BEAN = "ExchangeChildSearchBean";

  public static final int SEARCH_RESULTS_PER_PAGE = 20;
  
  public static final String EXCHANGE_CHILD_STATE = "exchangeChildSearchState";

  private CaseMgmt caseMgmt = null;

  ExchangeChildSearch exchangeChildSearch = null;

  public void setExchangeChildSearch(ExchangeChildSearch exchangeChildSearch) {
    this.exchangeChildSearch = exchangeChildSearch;
  }

  public void displayExchangeChildSearch_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExchangeChildSearch_xa()");
    performanceTrace.enterScope();
    makeMaleFemaleMaxMinAgeDropdowns(context);
    ExchangeChildValueBean excChildValueBean = new ExchangeChildValueBean();
    request.setAttribute(EXCHANGE_CHILD_SEARCH_BEAN, excChildValueBean);
    PageMode.setPageMode(PageModeConstants.EDIT, request);
    performanceTrace.exitScope();
  }

  public void exchangeChildSearch_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".exchangeChildSearch_xa()");
    performanceTrace.enterScope();
    try {
      // Get the destination URL if it was passed in by the calling page and set it into state.
      ExchangeChildValueBean excChildValueBean = (ExchangeChildValueBean) request
                                                                                 .getAttribute(PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME);
      String sortColumn = request.getParameter(SortableColumnTag.ORDER_BY_NAME);
      String requestedPage = request.getParameter(ResultsPaginationHelper.REQUESTED_PAGE_KEY);
      
      BaseSessionStateManager state = getSessionStateManager(context);
      if (excChildValueBean != null) {
        state.setAttribute("destinationURL", ((ExchangeChildSearchPullBack) excChildValueBean).getDestinationUrl(),
                           request);
        ValueBeanHelper.populateDefaultValues(context, excChildValueBean);
        state.setAttribute("pullBackMode", ArchitectureConstants.TRUE, request);
        state.removeAttribute(PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME, request);
      } else {
        //check if coming from sort or pagination
        if(StringHelper.isValid(sortColumn) || StringHelper.isValid(requestedPage)){
          excChildValueBean = (ExchangeChildValueBean) state.getAttribute(EXCHANGE_CHILD_STATE, request);
          ValueBeanHelper.populateDefaultValues(context, excChildValueBean);
          state.removeAttribute(EXCHANGE_CHILD_STATE, request);
        } else {
          excChildValueBean = populateChildValueBean(context);
        }

      }
      request.setAttribute(EXCHANGE_CHILD_SEARCH_BEAN, excChildValueBean);
      PaginationResultBean paginationResultBean = exchangeChildSearch.searchExchangeChild(excChildValueBean);
      if (paginationResultBean != null) {
        List vTmp = paginationResultBean.getResults();
        request.setAttribute(EXCHANGE_CHILD_LIST, vTmp);
        state.setAttribute(EXCHANGE_CHILD_LIST, vTmp, request);
        state.setAttribute(EXCHANGE_CHILD_STATE, excChildValueBean, request);
        paginationResultBean.getResultDetails()
                            .setResultsPerPage(ExchangeChildSearchConversation.SEARCH_RESULTS_PER_PAGE);

        storePaginationBeanToRequest(context, paginationResultBean);
      }

    } catch (TooManyRowsReturnedException tme) {
      this.setPresentationBranch("error", context);
      String errorMessage = MessageLookup.getMessageByName("MSG_TOO_MANY_ROWS_RETURNED");
      setErrorMessage(errorMessage, DISPLAY_URL, request);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void displayAdoInfo_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdoInfo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String rowIndex = StringHelper.getSafeString(request.getParameter("hdnRowIndex"));
    String idStageStr = StringHelper.getSafeString(request.getParameter("hdnIdStage"));
    int indexSelected = 0;
    int idStage = 0;
    if (rowIndex != null) {
      indexSelected = Integer.parseInt(rowIndex);
    }
    if (idStageStr != null) {
      idStage = Integer.parseInt(idStageStr);
    }
    List<ExchangeChildValueBean> exchangeChildList = (List<ExchangeChildValueBean>) state
                                                                                         .getAttribute(
                                                                                                       EXCHANGE_CHILD_LIST,
                                                                                                       request);
    if (exchangeChildList != null && exchangeChildList.size() > 0) {
      ExchangeChildValueBean childValueBean = (ExchangeChildValueBean) exchangeChildList.get(indexSelected);

      int idEvent = childValueBean.getIdExchangeChildEvent();
      CaseUtility.Event childRegEvent = CaseUtility.getEvent(idEvent);
      CaseUtility.Stage childRegStage = CaseUtility.getStage(idStage);
      GlobalData.setUlIdStage(idStage, request);
      String nmCase = childRegStage.getNmCase();
      GlobalData.setSzNmCase(nmCase, request);
      GlobalData.setUlIdCase(CaseUtility.getStage(idStage).getIdCase(), request);
      GlobalData.setSzCdStage(childRegStage.getCdStage(), request);
      GlobalData.setSzNmStage(childRegStage.getNmStage(), request);
      GlobalData.setSzCdStageProgram("CPS", request);
      GlobalData.setSzCdTask(childRegEvent.getCdTask(), request);
      AdoptionInformationRetrieveSI adoptioninformationRetrieveSI = new AdoptionInformationRetrieveSI();
      adoptioninformationRetrieveSI.setUlIdCase(CaseUtility.getStage(idStage).getIdCase());
      adoptioninformationRetrieveSI.setUlIdChildRegEvent(idEvent);
      adoptioninformationRetrieveSI.setUlIdStage(idStage);
      adoptioninformationRetrieveSI.setUlIdEvent(0);
      AdoptionInformationRetrieveSO adoptioninformationRetrieveSO = caseMgmt
                                                                            .retrieveAdoptionInformation(adoptioninformationRetrieveSI);
      if (adoptioninformationRetrieveSO == null) {
        adoptioninformationRetrieveSO = new AdoptionInformationRetrieveSO();
      }
      state.setAttribute("AdoptionInformationRetrieveSO", adoptioninformationRetrieveSO, request);
    }
    performanceTrace.exitScope();
  }

  public void displayPersonDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String rowIndex = ContextHelper.getStringSafe(request, "hdnRowIndex");
    int indexSelected = 0;
    if (rowIndex != null) {
      indexSelected = Integer.parseInt(rowIndex);
    }
    List<ExchangeChildValueBean> exchangeChildList = (List<ExchangeChildValueBean>) state
                                                                                         .getAttribute(
                                                                                                       EXCHANGE_CHILD_LIST,
                                                                                                       request);
    if (exchangeChildList != null) {
      ExchangeChildValueBean childValueBean = (ExchangeChildValueBean) exchangeChildList.get(indexSelected);

      int idPerson = childValueBean.getIdChild();
      int idStage = ContextHelper.getIntSafe(request, "hdnIdStage");
      CaseUtility.Stage childRegStage = CaseUtility.getStage(idStage);
      GlobalData.setUlIdStage(idStage, request);
      String nmCase = childRegStage.getNmCase();
      GlobalData.setSzNmCase(nmCase, request);
      GlobalData.setUlIdCase(CaseUtility.getStage(idStage).getIdCase(), request);
      GlobalData.setUlIdPerson(idPerson, request);
      GlobalData.setSzCdStage(childRegStage.getCdStage(), request);
      GlobalData.setSzNmStage(childRegStage.getNmStage(), request);
      GlobalData.setSzCdStageProgram("CPS", request);
    }
    performanceTrace.exitScope();
  }

  public void displayExchangeChildDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String rowIndex = ContextHelper.getStringSafe(request, "hdnRowIndex");
    int indexSelected = 0;
    if (rowIndex != null) {
      indexSelected = Integer.parseInt(rowIndex);
    }
    List<ExchangeChildValueBean> exchangeChildList = (List<ExchangeChildValueBean>) state
                                                                                         .getAttribute(
                                                                                                       EXCHANGE_CHILD_LIST,
                                                                                                       request);
    if (exchangeChildList != null) {
      ExchangeChildValueBean childValueBean = (ExchangeChildValueBean) exchangeChildList.get(indexSelected);

      int idEvent = childValueBean.getIdExchangeChildEvent();
      int idStage = ContextHelper.getIntSafe(request, "hdnIdStage");
      int idChild = childValueBean.getIdChild();
      CaseUtility.Event childRegEvent = CaseUtility.getEvent(idEvent);
      CaseUtility.Stage childRegStage = CaseUtility.getStage(idStage);
      GlobalData.setUlIdStage(idStage, request);
      String nmCase = childRegStage.getNmCase();
      GlobalData.setSzNmCase(nmCase, request);
      GlobalData.setUlIdPerson(idChild, request);
      GlobalData.setUlIdCase(CaseUtility.getStage(idStage).getIdCase(), request);
      GlobalData.setUlIdEvent(idEvent, request);
      GlobalData.setSzCdStage(childRegStage.getCdStage(), request);
      GlobalData.setSzNmStage(childRegStage.getNmStage(), request);
      GlobalData.setSzCdStageProgram("CPS", request);
      GlobalData.setSzCdTask(childRegEvent.getCdTask(), request);
      GlobalData.setSzNmPersonFull(childValueBean.getNmFull(), request);
      // STGAP00012712: Show the Exchange Child Detail 3rd level tab so user can access the Exchange Child List Page
      state.setContextParameter("_exchangeChildDetailAvailable" + childValueBean.getIdChild(), ArchitectureConstants.Y, request);
    }
    
    performanceTrace.exitScope();
  }

  /**
   * Creates the Male and Female Age Range dropdown options.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  private void makeMaleFemaleMaxMinAgeDropdowns(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "makeMaleFemaleMaxMinAgeDropdowns");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      SortedMap<Integer, Option> years = new TreeMap<Integer, Option>();
      SortedMap<Integer, Option> months = new TreeMap<Integer, Option>();
      int yearCount = MIN_AGE_YR;
      int monthCount = MIN_AGE_MO;
      Option anOption;

      while (yearCount <= MAX_AGE_YR) {
        anOption = new Option(String.valueOf(yearCount), String.valueOf(yearCount));
        years.put(yearCount++, anOption);
      }

      state.setAttribute("yearsrange", years, request);

      while (monthCount <= MAX_AGE_MO) {
        anOption = new Option(String.valueOf(monthCount), String.valueOf(monthCount));
        months.put(monthCount++, anOption);
      }
      state.setAttribute("monthsrange", months, request);
    } catch (Exception e) {
      handleException(e, context, "makeMaleFemaleMaxMinAgeDropdowns");
    }

    performanceTrace.exitScope();
  }

  private ExchangeChildValueBean populateChildValueBean(GrndsExchangeContext context) {
    ExchangeChildValueBean exchangeChildValueBean = new ExchangeChildValueBean();
    HttpServletRequest request = context.getRequest();
    List<String> countyList = new ArrayList<String>();
    // Child Locate section
    //If region is entered on the search criteria get the counties for that region and set the list
    //into the value bean
    String cdCounty = (ContextHelper.getStringSafe(request, "szCdCounty"));
    if(!"".equals(cdCounty)){
      countyList.add(cdCounty); 
    }
    String region = ContextHelper.getStringSafe(request, "szCdRegion");
    exchangeChildValueBean.setCdRegion(region);
    try {
      if (!"".equals(region) && "".equals(cdCounty)) {
        List<CodeAttributes> codeAttrCollection = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
        if (codeAttrCollection != null) {
          Iterator it = codeAttrCollection.iterator();
          while (it.hasNext()) {
            CodeAttributes codeAttr = (CodeAttributes) it.next();
            if (region.equals(codeAttr.getDecode())) {
              countyList.add(codeAttr.getCode());
            }
          }
        }
      }
    } catch (LookupException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    if (countyList.size() > 0) {
      exchangeChildValueBean.setLstCountysFromRegion(countyList);
    }
    //SMS#37251 Set cdCounty in the exchangeChildValueBean so that it can be pulled 
    //          on the Exchange Child Search page after you come back from a search.  
    exchangeChildValueBean.setCdCounty(cdCounty);    	
    exchangeChildValueBean.setNmFirst(ContextHelper.getStringSafe(request, "txtNmFirst"));
    exchangeChildValueBean.setNmLast(ContextHelper.getStringSafe(request, "txtNmLast"));
    exchangeChildValueBean.setNmMiddle(ContextHelper.getStringSafe(request, "txtNmMiddle"));
    // Sibling Group locate section
    exchangeChildValueBean.setIdSiblingGrp(ContextHelper.getIntSafe(request, "txtIdSibGroup"));
    // Male age range section
    int minMaleYear = ContextHelper.getIntSafe(context, "selMaleMinYearInt");
    int minMaleMonth = ContextHelper.getIntSafe(context, "selMaleMinMonthInt");
    int maleMinimumAgeInMonths = (minMaleYear * 12) + minMaleMonth;
    int maxMaleYear = ContextHelper.getIntSafe(context, "selMaleMaxYearInt");
    int maxMaleMonth = ContextHelper.getIntSafe(context, "selMaleMaxMonthInt");
    int maleMaximumAgeInMonths = (maxMaleYear * 12) + maxMaleMonth;
    exchangeChildValueBean.setMaleMaxRangeInMonths(maleMaximumAgeInMonths);
    exchangeChildValueBean.setMaleMinRangeInMonths(maleMinimumAgeInMonths);

    // Female age range section
    int minFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMinYearInt");
    int minFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMinMonthInt");
    int femaleMinimumAgeInMonths = (minFemaleYear * 12) + minFemaleMonth;
    int maxFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMaxYearInt");
    int maxFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMaxMonthInt");
    int femaleMaximumAgeInMonths = (maxFemaleYear * 12) + maxFemaleMonth;
    exchangeChildValueBean.setFemaleMaxRangeInMonths(femaleMaximumAgeInMonths);
    exchangeChildValueBean.setFemaleMinRangeInMonths(femaleMinimumAgeInMonths);
    exchangeChildValueBean.setNumChildren(ContextHelper.getIntSafe(request, "txtNbrChildren"));
    exchangeChildValueBean.setIndLegalRisk(ContextHelper.getStringSafe(request, "rbIndLegalRisk"));

    // Special Needs Section
    exchangeChildValueBean.setIndMentalRet(CheckboxHelper.getCheckboxValue(request, "cbxMntlRetard"));
    exchangeChildValueBean.setIndVisHearImp(CheckboxHelper.getCheckboxValue(request, "cbxVislHearImp"));
    exchangeChildValueBean.setIndEmotDist(CheckboxHelper.getCheckboxValue(request, "cbxEmtDisturbed"));
    exchangeChildValueBean.setIndPhyDisabled(CheckboxHelper.getCheckboxValue(request, "cbxPhyDisabled"));
    exchangeChildValueBean.setIndOthMedDiag(CheckboxHelper.getCheckboxValue(request, "cbxOthMedDiag"));
    exchangeChildValueBean.setCdMentRetSev(ContextHelper.getStringSafe(request, "szCdMntRetSevLevel"));
    exchangeChildValueBean.setCdVisHearImpSev(ContextHelper.getStringSafe(request, "szCdVisHearSevLevel"));
    exchangeChildValueBean.setCdEmotDistSev(ContextHelper.getStringSafe(request, "szCdEmtDistSevLevel"));
    exchangeChildValueBean.setCdPhyDisbldSev(ContextHelper.getStringSafe(request, "szCdPhyDisSevLevel"));
    exchangeChildValueBean.setCdOthDiagSev(ContextHelper.getStringSafe(request, "szCdOthMedDiagSevLevel"));

    // Back ground factors
    exchangeChildValueBean.setIndFamHxMr(CheckboxHelper.getCheckboxValue(request, "cbxFamHxMR"));
    exchangeChildValueBean.setIndChildHxSexAbuse(CheckboxHelper.getCheckboxValue(request, "cbxChHxSxAbuse"));
    exchangeChildValueBean.setIndFamHxMentIll(CheckboxHelper.getCheckboxValue(request, "cbxFamHxMentIll"));
    exchangeChildValueBean.setIndFamHxDrAlc(CheckboxHelper.getCheckboxValue(request, "cbxFamHxDrgAlcohol"));

    // Race Section
    String[] cbxRaceList = CheckboxHelper.getCheckedValues(request, "cbxRace");
    exchangeChildValueBean.setLstRacePrefs(cbxRaceList != null && cbxRaceList.length > 0 ? Arrays.asList(cbxRaceList)
                                                                                        : null);

    // Ethnicity Section
    String[] cbxEthnicityList = CheckboxHelper.getCheckedValues(request, "cbxEthnicity");
    exchangeChildValueBean
                          .setLstEthnicityPrefs(cbxEthnicityList != null && cbxEthnicityList.length > 0 ? Arrays
                                                                                                                .asList(cbxEthnicityList)
                                                                                                       : null);

    // Non-Availability Section
    String[] cbxNonAvailList = CheckboxHelper.getCheckedValues(request, "cbxNonAvlCodes");
    exchangeChildValueBean
                          .setLstNonAvailCodes(cbxNonAvailList != null && cbxNonAvailList.length > 0 ? Arrays
                                                                                                             .asList(cbxNonAvailList)
                                                                                                    : null);
    ValueBeanHelper.populateDefaultValues(context, exchangeChildValueBean);

    return exchangeChildValueBean;
  }

  public void pullBackExchangeChildDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".pullBackExchangeChildDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      String[] rowsSelected = CheckboxHelper.getCheckedValues(request, "ckName_Link");
      boolean isEventStatusNew = false;//mxpatel added this for defect #STGAP00012694
      List<ExchangeChildValueBean> exchangeChildList = (List<ExchangeChildValueBean>) state
                                                                                           .getAttribute(
                                                                                                         EXCHANGE_CHILD_LIST,
                                                                                                         request);
      if (exchangeChildList != null) {
        List<ExchangeChildValueBean> selectedChildrenList = new ArrayList<ExchangeChildValueBean>();
        for (int i = 0; i < rowsSelected.length; i++) {
          int indexRowsSelected = Integer.parseInt(rowsSelected[i]);
          if (indexRowsSelected < exchangeChildList.size()) {
            ExchangeChildValueBean childValueBean = new ExchangeChildValueBean();
            childValueBean = exchangeChildList.get(indexRowsSelected);
            // mxpatel added this to check for ECD in "NEW" status for defect #STGAP00012694
            int idEvent = childValueBean.getIdExchangeChildEvent();
            CaseUtility.Event childRegEvent = CaseUtility.getEvent(idEvent);
            String cdEventStatus = null;
            if (childRegEvent != null) {
              cdEventStatus = childRegEvent.getCdEventStatus();
            }
            if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
              String childName = childValueBean.getNmFull();
              String errorMessage = MessageLookup.getMessageByName("MSG_XCHANGE_CHILD_SAV_REQ");
              errorMessage = MessageLookup.addMessageParameter(errorMessage, childName);
              setErrorMessage(errorMessage, SEARCH_URL, request);
              isEventStatusNew = true;
            } else {
              selectedChildrenList.add(childValueBean);
            }
          }
        }
        request.setAttribute(PULLBACK_RETURN_ATTRIBUTE_NAME, selectedChildrenList);
      }
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
      handleException(e, context, "pullBackExchangeChildDetail_xa");
    }
    performanceTrace.exitScope();
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
      case Messages.MSG_TOO_MANY_ROWS_RETURNED:
      case Messages.MSG_SELECT_ROW_ACTION:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, SEARCH_URL, request);
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

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

}
