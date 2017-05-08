package gov.georgia.dhr.dfcs.sacwis.web.fad;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeChildrenSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeHomeDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeDetailSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchPullBack;
import gov.georgia.dhr.dfcs.sacwis.web.person.ExchangeChildDetailConversation;

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
 * This is the conversation class used to maintain exchange home detail in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   07/01/08  mchillman creation
 *   10/28/08  mchillman STGAP00010799 Change to pass exchangeChildDetailRetSI object on child detail display 
 *   07/28/09  mchillman STGAP00012942 Alter code to perform null pointer check for age ranges when building the search object
 *   05/21/09  mchillman STGAP00012047 added delete buttons for deletion of linked records
 *   05/22/09  mchillman MR-50 for sau the page can always be modified    
 *   10/22/09  mxpatel   37363: added code to make sure that child's hyperlink on the EHD page successfully navigates
 *                       user to the ECD page in the Child's ADO stage
 *   11/23/09  arege     SMS#37439 Added method to populate the max min age dropdowns on the Exchange Child Search page when coming via
 *                       EHD page using Match button.
 *   12/15/09  mxpatel  SMS# 40849: set pagination information for the page in order make the NAC and Date_out columns sortable. 
 * 
 * </pre>
 */

public class ExchangeHomeDetailConversation extends BaseHiddenFieldStateConversation {

  public static final String PAGE_MODE = PageMode.PAGE_MODE_ATTRIBUTE_NAME;

  public static final String EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME = "ExchangeHomeDetail";

  public static final String EXCHANGE_HOME_DETAIL_UNLINKED_CHILDREN_ATTRIBUTE_NAME = "ExchangeHomeDetailUnlinkedChildren";

  public static final String DISPLAY_EXCHANGE_HOME_URL = "/fad/ExchangeHomeDetail/saveExchangeHomeDetail";

  public static final String SELECTED_EXCHANGE_CHILD_EVENT = "selectedExchangeChildEvent";

  public static final String SELECTED_EXCHANGE_CHILD_ID = "selectedExchangeChildID";
  
  public static final String SELECTED_EXCHANGE_CHILD_NAME = "selectedExchangeChildName";

  public static final String LINK_COUNT = "linkCount";

  public static final String RETURN_URL = "/fad/ExchangeHomeDetail/setMatchedChildren";
  
  public static final String BRANCH_EVENT_LIST = "EventList";

  public static final int FAD_MAX_AGE_YR = 19;

  public static final int FAD_MIN_AGE_YR = 0;

  public static final int FAD_MAX_AGE_MO = 11;

  public static final int FAD_MIN_AGE_MO = 0;

  public static final String SORT_BY_NON_AVAIL_RSN_CODE = "CT.DECODE";

  public static final String SORT_BY_DT_OUT = "DT_OUT";

  public static final int PAGE_SIZE = 100;

  private AdoExchange adoExchange;

  public void setAdoExchange(AdoExchange adoExchange) {
    this.adoExchange = adoExchange;
  }

  public void displayExchangeHomeDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
   
    ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                              .getAttribute(
                                                                                            EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                            request);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExchangeHomeDetail_xa()");
    performanceTrace.enterScope();
    try {
      String pageMode = PageMode.getPageMode(request);
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
      String orderBy = ContextHelper.getStringSafe(context, "orderBy");
      if ("".equals(orderBy)) {
        orderBy = SORT_BY_DT_OUT;
      }
      String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
      if ("".equals(sortDir)) {
        sortDir = ServiceConstants.SORT_ASCENDING;
      }
      tuxPagination.getResultDetails().setOrderBy(orderBy);
      tuxPagination.getResultDetails().setOrderByDirection(sortDir);
      ExchangeHomeDetailSI exchangeHomeDetailSI = new ExchangeHomeDetailSI();
      exchangeHomeDetailSI.setPrefill(PageModeConstants.NEW.equals(PageMode.getPageMode(request)));
      exchangeHomeDetailSI.setEvent(new ROWCCMN01UIG00());
      exchangeHomeDetailSI.getEvent().setUlIdEvent(GlobalData.getUlIdEvent(request));
      exchangeHomeDetailSI.getEvent().setUlIdStage(GlobalData.getUlIdStage(request));
      exchangeHomeDetailSI.getEvent().setUlIdPerson(getUserID(request));
      exchangeHomeDetailSI.setIdCase(GlobalData.getUlIdCase(request));
      exchangeHomeDetailSI.setOrderBy(orderBy);
      exchangeHomeDetailSI.setSortDir(sortDir);

      state.removeAllAttributes(request);

      exchangeHomeDetailSO = adoExchange.retrieveExchangeHomeDetail(exchangeHomeDetailSI);

      if (exchangeHomeDetailSO != null && exchangeHomeDetailSO.getChildrenConsideringList().size() > 0) {
        tuxPagination.getResultDetails().setNumberOfResults(exchangeHomeDetailSO.getChildrenConsideringList().size());
      }

      storePaginationBeanToRequest(context, tuxPagination);
      state.setAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, exchangeHomeDetailSO, request);
      if (GlobalData.getUlIdEvent(request) > 0) {
        // If user has Adoption View Access right then they can view only the Exchange pages
        if (hasAdoptionViewAccess(request)) {
          pageMode = PageModeConstants.VIEW;
        }
        //if Adoption Exchange Consultants, the page can always be modified
        if (isAdoptionExchangeConsultant(request)) {
          pageMode = PageModeConstants.MODIFY;
        }
      }
      PageMode.setPageMode(pageMode, request);
    
    } catch (ServiceException we) {
      handleDisplayError(we, context);
    }
  
    performanceTrace.exitScope();
  }

  public void saveExchangeHomeDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveExchangeHomeDetail_xa()");
    performanceTrace.enterScope();

    try {
      ExchangeHomeDetailSI exchangeChildDetailSI = populateExchangeHomeDetailSI(context);
      ExchangeHomeDetailSO exchangeHomeDetailSO = adoExchange.saveExchangeHomeDetail(exchangeChildDetailSI);
      GlobalData.setUlIdEvent(exchangeHomeDetailSO.getEvent().getUlIdEvent(), request);
      GlobalData.setUlIdPerson(exchangeHomeDetailSO.getEvent().getUlIdPerson(), request);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      state.setAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, exchangeHomeDetailSO, request);
      state.removeAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "saveExchangeHomeDetail_xa");
    }
    performanceTrace.exitScope();
  }

  public void matchExchangeChildren_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".matchExchangeChildren_xa()");
    performanceTrace.enterScope();

    try {
      ExchangeChildSearchPullBack exchangeChildValueBean = populateExchangeChildValueBean(context);
      exchangeChildValueBean.setDestinationUrl(RETURN_URL);
      request.setAttribute(ExchangeChildSearchConversation.PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME, exchangeChildValueBean);
      forward(ExchangeChildSearchConversation.SEARCH_URL, request, context.getResponse());
    } catch (Exception e) {
      handleException(e, context, "matchExchangeChildren_xa");
    }
  }

  public void setMatchedChildren_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setMatchedChildren_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {

      List<ExchangeChildValueBean> selectedChildrenList = (List<ExchangeChildValueBean>) request
                                                                                                .getAttribute(ExchangeChildSearchConversation.PULLBACK_RETURN_ATTRIBUTE_NAME);
      if (selectedChildrenList != null && selectedChildrenList.size() > 0) {
        List<ExchangeHomeChildrenSO> unlinkedList = new ArrayList<ExchangeHomeChildrenSO>();
        Iterator<ExchangeChildValueBean> itr = selectedChildrenList.iterator();
        while (itr.hasNext()) {
          ExchangeChildValueBean returnBean = itr.next();
          ExchangeHomeChildrenSO childConsideringNew = new ExchangeHomeChildrenSO();
          childConsideringNew.setLinkCurrent(null);
          childConsideringNew.setCdCounty(returnBean.getCdCounty());
          //childConsideringNew.setCdGender(returnBean.get);
          childConsideringNew.setCdNonAviReasonCode(returnBean.getNonAvailCode());
          // childConsideringNew.setDtDOB(returnBean.getDtDOB());
          // childConsideringNew.setFirstName(returnBean.getNmFirst());
          childConsideringNew.setLastName(returnBean.getNmFull());
          childConsideringNew.setIdExchangeChildEvent(returnBean.getIdExchangeChildEvent());
          childConsideringNew.setIdChild(returnBean.getIdChild());
          childConsideringNew.setIdExchangeHomeEvent(null);
          unlinkedList.add(childConsideringNew);
        }

        state.setAttribute(EXCHANGE_HOME_DETAIL_UNLINKED_CHILDREN_ATTRIBUTE_NAME, unlinkedList, request);
        ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                                .getAttribute(
                                                                                              EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                              request);
        List<ExchangeHomeChildrenSO> listCC = exchangeHomeDetailSO.getChildrenConsideringList();
        listCC.addAll(0, unlinkedList);
        exchangeHomeDetailSO.setChildrenConsideringList(listCC);
        TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
        ValueBeanHelper.populateDefaultValues(context, tuxPagination);
        tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
        
        if (exchangeHomeDetailSO != null && exchangeHomeDetailSO.getChildrenConsideringList().size() > 0) {
          tuxPagination.getResultDetails().setNumberOfResults(exchangeHomeDetailSO.getChildrenConsideringList().size());
        }
        storePaginationBeanToRequest(context, tuxPagination);
        state.setAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, exchangeHomeDetailSO, request);
      }
    } catch (Exception e) {
      handleException(e, context, "setMatchedChildren_xa");
    }
  }

  public void linkExchangeHomeDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".linkExchangeHomeDetail_xa()");
    performanceTrace.enterScope();
    try {
      ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                              .getAttribute(
                                                                                            EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                            request);
      List<ExchangeHomeChildrenSO> childrenSO = (List<ExchangeHomeChildrenSO>) state
                                                                                    .getAttribute(
                                                                                                  EXCHANGE_HOME_DETAIL_UNLINKED_CHILDREN_ATTRIBUTE_NAME,
                                                                                                  request);
      if (childrenSO != null && childrenSO.size() > 0) {
        List<ExchangeHomeChildrenSI> childrenToLinkSI = new ArrayList<ExchangeHomeChildrenSI>();
        Iterator<ExchangeHomeChildrenSO> itr = childrenSO.iterator();
        while (itr.hasNext()) {
          ExchangeHomeChildrenSO soChild = itr.next();
          ExchangeHomeChildrenSI newChild = new ExchangeHomeChildrenSI();
          newChild.setCdNonAviReasonCode(request.getParameter("selSzCdNonAvReasonChild"));
          newChild.setDtDateOut(ContextHelper.getJavaDateSafe(request, "dateOutHA"));
          newChild.setIdExchangeChildEvent(soChild.getIdExchangeChildEvent());
          newChild.setIdExchangeHomeEvent(exchangeHomeDetailSO.getEvent().getUlIdEvent());
          childrenToLinkSI.add(newChild);
        }

        adoExchange.saveLinkedExchangeHomeChildFamLink(childrenToLinkSI);
        adoExchange.updateExchangeHomeChildDateOuts(childrenToLinkSI);
      }
      state.removeAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "linkExchangeHomeDetail_xa");
    }
    performanceTrace.exitScope();
  }

  public void unLinkExchangeHomeDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".unLinkExchangeHomeDetail_xa()");
    performanceTrace.enterScope();
    try {
      ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                              .getAttribute(
                                                                                            EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                            request);
      List<ExchangeHomeChildrenSO> childrenSO = exchangeHomeDetailSO.getChildrenConsideringList();
      if (childrenSO != null && childrenSO.size() > 0) {
        List<ExchangeHomeChildrenSI> childrenToUnLinkSI = new ArrayList<ExchangeHomeChildrenSI>();
        int cbCount = 0;
        Iterator<ExchangeHomeChildrenSO> itr = childrenSO.iterator();
        while (itr.hasNext()) {
          ExchangeHomeChildrenSO soChild = itr.next();
          String cbName = "cbLinked_" + cbCount++;
          String cbValue = CheckboxHelper.getCheckboxValue(request, cbName);
          if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, cbName))) {
            ExchangeHomeChildrenSI newChild = new ExchangeHomeChildrenSI();
            newChild.setCdNonAviReasonCode(request.getParameter("selSzCdNonAvReasonChild"));
            newChild.setCdNonSelReasonCode(request.getParameter("selSzCdNonSelectionReasonChild"));
            newChild.setDtDateOut(soChild.getDtDateOut());
            newChild.setIdExchangeChildEvent(soChild.getIdExchangeChildEvent());
            newChild.setIdExchangeHomeEvent(soChild.getIdExchangeHomeEvent());
            newChild.setIdEvent(soChild.getIdEvent());
            newChild.setDtLastUpdate(soChild.getDtLastUpdate());
            newChild.setLinkCurrent(ArchitectureConstants.N);
            childrenToUnLinkSI.add(newChild);
          }
        }

        adoExchange.saveUnLinkedExchangeHomeChildFamLink(childrenToUnLinkSI);
        adoExchange.updateExchangeHomeChildDateOuts(childrenToUnLinkSI);
      }
      state.removeAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "unLinkExchangeHomeDetail_xa");
    }
    performanceTrace.exitScope();
  }
  
  
  public void deleteNowConsiderind_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteNowConsiderind_xa()");
    performanceTrace.enterScope();
    try {
      ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                              .getAttribute(
                                                                                            EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                            request);
      List<ExchangeHomeChildrenSO> childrenSO = exchangeHomeDetailSO.getChildrenConsideringList();
      if (childrenSO != null && childrenSO.size() > 0) {
        List<ExchangeHomeChildrenSI> childrenToUnLinkSI = new ArrayList<ExchangeHomeChildrenSI>();
        int cbCount = 0;
        Iterator<ExchangeHomeChildrenSO> itr = childrenSO.iterator();
        while (itr.hasNext()) {
          ExchangeHomeChildrenSO soChild = itr.next();
          String cbName = "cbLinked_" + cbCount++;
          if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, cbName))) {
            ExchangeHomeChildrenSI newChild = new ExchangeHomeChildrenSI();
            newChild.setCdNonAviReasonCode(request.getParameter("selSzCdNonAvReasonChild"));
            newChild.setCdNonSelReasonCode(request.getParameter("selSzCdNonSelectionReasonChild"));
            newChild.setDtDateOut(soChild.getDtDateOut());
            newChild.setIdExchangeChildEvent(soChild.getIdExchangeChildEvent());
            newChild.setIdExchangeHomeEvent(soChild.getIdExchangeHomeEvent());
            newChild.setIdEvent(soChild.getIdEvent());
            newChild.setDtLastUpdate(soChild.getDtLastUpdate());
            newChild.setLinkCurrent(ArchitectureConstants.N);
            childrenToUnLinkSI.add(newChild);
          }
        }

        adoExchange.deleteExchangeHomeChildFamLink(childrenToUnLinkSI);
      }
      state.removeAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "deleteNowConsiderind_xa");
    }
    performanceTrace.exitScope();
  }
  
  
  public void deleteHasBeenConsidered_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteHasBeenConsidered_xa()");
    performanceTrace.enterScope();
    try {
      ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                              .getAttribute(
                                                                                            EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                            request);
      List<ExchangeHomeChildrenSO> childrenSO = exchangeHomeDetailSO.getChildrenNonSelectedList();
      if (childrenSO != null && childrenSO.size() > 0) {
        List<ExchangeHomeChildrenSI> childrenToUnLinkSI = new ArrayList<ExchangeHomeChildrenSI>();
        int cbCount = 0;
        Iterator<ExchangeHomeChildrenSO> itr = childrenSO.iterator();
        while (itr.hasNext()) {
          ExchangeHomeChildrenSO soChild = itr.next();
          String cbName = "cbUnlinkedLinked_" + cbCount++;
          if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, cbName))) {
            ExchangeHomeChildrenSI newChild = new ExchangeHomeChildrenSI();
            newChild.setDtDateOut(soChild.getDtDateOut());
            newChild.setIdExchangeChildEvent(soChild.getIdExchangeChildEvent());
            newChild.setIdExchangeHomeEvent(soChild.getIdExchangeHomeEvent());
            newChild.setIdEvent(soChild.getIdEvent());
            newChild.setDtLastUpdate(soChild.getDtLastUpdate());
            newChild.setLinkCurrent(ArchitectureConstants.N);
            childrenToUnLinkSI.add(newChild);
          }
        }

        adoExchange.deleteExchangeHomeChildFamLink(childrenToUnLinkSI);
      }
      state.removeAttribute(EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "deleteHasBeenConsidered_xa");
    }
    performanceTrace.exitScope();
  }


  public void displayChildDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayChildDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String strIdECEvent = StringHelper.getSafeString(request.getParameter(SELECTED_EXCHANGE_CHILD_EVENT));
    String strIdChild = StringHelper.getSafeString(request.getParameter(SELECTED_EXCHANGE_CHILD_ID));
    if (strIdECEvent != null && strIdChild != null) {
      try {               
        int idChild = Integer.parseInt(strIdChild);
        int idECEvent = Integer.parseInt(strIdECEvent);
        CaseUtility.Event excEvent = CaseUtility.getEvent(idECEvent);
        ExchangeChildDetailRetrieveSI exchangeChildDetailSI = new ExchangeChildDetailRetrieveSI();
        exchangeChildDetailSI.setUlIdCase(CaseUtility.getStage(excEvent.getIdStage()).getIdCase());
        exchangeChildDetailSI.setUlIdChild(idChild);
        GlobalData.setUlIdPerson(idChild, request);
        GlobalData.setSzNmPersonFull(StringHelper.getSafeString(request.getParameter(SELECTED_EXCHANGE_CHILD_NAME)), request);
        exchangeChildDetailSI.setUlIdEvent(idECEvent);
        exchangeChildDetailSI.setUlIdStage(excEvent.getIdStage());
        CaseUtility.Stage excStage = CaseUtility.getStage(excEvent.getIdStage());
        state.setAttribute(ExchangeChildDetailConversation.EXCHANGE_HOME_LAUNCH_VARS, exchangeChildDetailSI, request);
        
        String paramString = "actionEventId=" + idECEvent + "&actionStageCode=" + excStage.getCdStage() + "&actionStageName=" + 
        excStage.getNmStage() + "&actionTaskCode=" + "9530" + "&actionCaseId=" + excStage.getIdCase() + "&actionStageId=" +excEvent.getIdStage();
        String forwardUrl = "/workload/EventSearch/displayEventDetail?" + paramString;
        forward(forwardUrl, request, context.getResponse());
        
       
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        handleException(e, context, "displayChildDetail_xa");
      }
    }
    performanceTrace.exitScope();
  }

  private ExchangeHomeDetailSI populateExchangeHomeDetailSI(GrndsExchangeContext context) {
    ExchangeHomeDetailSI exchangeHomeDetailSI = new ExchangeHomeDetailSI();
    exchangeHomeDetailSI.setEvent(new ROWCCMN01UIG00());
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                            .getAttribute(
                                                                                          EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                          request);

    exchangeHomeDetailSI.getEvent().setUlIdStage(GlobalData.getUlIdStage(request));
    exchangeHomeDetailSI.getEvent().setUlIdPerson(getUserID(request));
    exchangeHomeDetailSI.getEvent().setUlIdEvent(
                                                 ((exchangeHomeDetailSO != null) ? exchangeHomeDetailSO.getEvent()
                                                                                                       .getUlIdEvent()
                                                                                : null));
    exchangeHomeDetailSI
                        .getEvent()
                        .setDtDtEventOccurred(
                                              ((exchangeHomeDetailSO != null) ? exchangeHomeDetailSO
                                                                                                    .getEvent()
                                                                                                    .getDtDtEventOccurred()
                                                                             : null));

    exchangeHomeDetailSI.setIdCase(GlobalData.getUlIdCase(request));
    exchangeHomeDetailSI.setIdResource(((exchangeHomeDetailSO != null) ? exchangeHomeDetailSO.getIdResource() : null));
    exchangeHomeDetailSI.setName(request.getParameter("txtHomeName"));
    exchangeHomeDetailSI.setAgencyContractNumber(request.getParameter("txtAgencyContractCode"));
    exchangeHomeDetailSI.setPrivateAgencyCaseWorker(request.getParameter("txtAgencyCaseWorkerName"));
    exchangeHomeDetailSI.setPhoneNumber(request.getParameter("txtPhoneNumber"));
    exchangeHomeDetailSI.setPhoneExtension(request.getParameter("txtPhoneNumberExt"));
    exchangeHomeDetailSI.setDtReRegistered(ContextHelper.getJavaDateSafe(request, "dateReRegistered"));
    exchangeHomeDetailSI.setDtRegistered(ContextHelper.getJavaDateSafe(request, "dateRegistered"));
    exchangeHomeDetailSI
                        .setDtLastUpdate((exchangeHomeDetailSO != null) ? exchangeHomeDetailSO.getDtLastUpdate() : null);
    

    exchangeHomeDetailSI.setDtApproved(ContextHelper.getJavaDateSafe(request, "txtDateApproved"));
    String cbxMentalRetardation = request.getParameter("cbxMentalRetardation");
    exchangeHomeDetailSI.setIndMentalRetardation(cbxMentalRetardation);
    exchangeHomeDetailSI
                        .setCdLevelMentalRetardation(("".equals(cbxMentalRetardation) || cbxMentalRetardation == null) ? null
                                                                                                                      : request
                                                                                                                               .getParameter("selSzCdMentalRetardation"));
    String cbxVisualHearingImpairments = request.getParameter("cbxVisualHearingImpairments");
    exchangeHomeDetailSI.setIndVisualHearingImpairments(cbxVisualHearingImpairments);
    exchangeHomeDetailSI
                        .setCdLevelVisualHearingImpairments(("".equalsIgnoreCase(cbxVisualHearingImpairments) || cbxVisualHearingImpairments == null) ? null
                                                                                                                                                     : request
                                                                                                                                                              .getParameter("selSzCdVisualHearingImpairments"));
    String cbxPhysicallyDisabled = request.getParameter("cbxPhysicallyDisabled");
    exchangeHomeDetailSI.setIndPhysicallyDisabled(cbxPhysicallyDisabled);
    exchangeHomeDetailSI
                        .setCdLevelPhysicallyDisabled(("".equals(cbxPhysicallyDisabled) || cbxPhysicallyDisabled == null) ? null
                                                                                                                         : request
                                                                                                                                  .getParameter("selSzCdPhysicallyDisabled"));
    String cbxEmotionallyDisturbed = request.getParameter("cbxEmotionallyDisturbed");
    exchangeHomeDetailSI.setIndEmotionallyDisturbed(cbxEmotionallyDisturbed);
    exchangeHomeDetailSI
                        .setCdLevelEmotionallyDisturbed(("".equals(cbxEmotionallyDisturbed) || cbxEmotionallyDisturbed == null) ? null
                                                                                                                               : request
                                                                                                                                        .getParameter("selSzCdEmotionallyDisturbed"));
    String cbxOtherMedicalDiagnoses = request.getParameter("cbxOtherMedicalDiagnoses");
    exchangeHomeDetailSI.setIndOtherMedicalDiagnoses(cbxOtherMedicalDiagnoses);
    exchangeHomeDetailSI
                        .setCdlevelOtherMedicalDiagnoses(("".equals(cbxOtherMedicalDiagnoses) || cbxOtherMedicalDiagnoses == null) ? null
                                                                                                                                  : request
                                                                                                                                           .getParameter("selSzCdOtherMedicalDiagnoses"));

    exchangeHomeDetailSI.setIndFamilyHxofDrugsAlcohol(request.getParameter("cbxFamilyHxofDrugsAlcohol"));
    exchangeHomeDetailSI.setIndFamilyHxofMentalIllness(request.getParameter("cbxFamilyHxofMentalIllness"));
    exchangeHomeDetailSI.setIndFamilyHxofMR(request.getParameter("cbxFamilyHxofMR"));
    exchangeHomeDetailSI.setIndChilsHxofSexualAbuse(request.getParameter("cbxChilsHxofSexualAbuse"));
    exchangeHomeDetailSI.setNumOfChildren(ContextHelper.getIntSafe(context, "txtNbrOfChldrn"));

    exchangeHomeDetailSI.setCdNonAvReasonHA(request.getParameter("selSzCdNonAvReasonHA"));
    exchangeHomeDetailSI.setDateOutHA(ContextHelper.getJavaDateSafe(request, "txtDateOut"));
    exchangeHomeDetailSI.setCommentsHA(request.getParameter("txtCommentsHA"));
    exchangeHomeDetailSI.setFamilyIsLinkedHA(request.getParameter("txtFamilyIsLinkedHA"));
    exchangeHomeDetailSI.setHomePrefComments(request.getParameter("txtHomePrefComments"));

    exchangeHomeDetailSI.setDtClosedNP(ContextHelper.getJavaDateSafe(request, "dateClosedNP"));

    exchangeHomeDetailSI.setCdReasonClosed(request.getParameter("selSzCdResaonClosed"));
    exchangeHomeDetailSI.setExplanationNPComments(request.getParameter("txtExplanationNPComments"));

    exchangeHomeDetailSI.setAFileNumCWP(request.getParameter("txtAFileNumCWP"));
    exchangeHomeDetailSI.setChildrenPlacedWithCommentCWP(request.getParameter("txtChildrenPlacedWithCommentCW"));
    exchangeHomeDetailSI.setDtFinal(ContextHelper.getJavaDateSafe(request, "txtDateFinalCWP"));
    exchangeHomeDetailSI.setDtFinalEntered(ContextHelper.getJavaDateSafe(request, "txtDateFinalEnteredCWP"));

    return exchangeHomeDetailSI;
  }

  private ExchangeChildSearchPullBack populateExchangeChildValueBean(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ExchangeChildSearchPullBack exchangeChildValueBean = new ExchangeChildSearchPullBack();

    ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state
                                                                            .getAttribute(
                                                                                          EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME,
                                                                                          request);
    if (exchangeHomeDetailSO != null) {
      exchangeChildValueBean.setMaleMaxRangeInMonths(exchangeHomeDetailSO.getMaleMaxRangeInMonths() != null ? exchangeHomeDetailSO.getMaleMaxRangeInMonths() : 0);
      exchangeChildValueBean.setMaleMinRangeInMonths(exchangeHomeDetailSO.getMaleMinRangeInMonths() != null ? exchangeHomeDetailSO.getMaleMinRangeInMonths() : 0);
      exchangeChildValueBean.setFemaleMaxRangeInMonths(exchangeHomeDetailSO.getFemaleMaxRangeInMonths() != null ? exchangeHomeDetailSO.getFemaleMaxRangeInMonths() : 0);
      exchangeChildValueBean.setFemaleMinRangeInMonths(exchangeHomeDetailSO.getFemaleMinRangeInMonths() != null ? exchangeHomeDetailSO.getFemaleMinRangeInMonths() : 0);
    }

    exchangeChildValueBean.setNumChildren(ContextHelper.getIntSafe(context, "txtNbrOfChldrn"));

    String cbxMentalRetardation = request.getParameter("cbxMentalRetardation");
    exchangeChildValueBean.setIndMentalRet(cbxMentalRetardation);
    exchangeChildValueBean
                          .setCdMentRetSev(("".equals(cbxMentalRetardation) || cbxMentalRetardation == null) ? null
                                                                                                            : request
                                                                                                                     .getParameter("selSzCdMentalRetardation"));
    String cbxVisualHearingImpairments = request.getParameter("cbxVisualHearingImpairments");
    exchangeChildValueBean.setIndVisHearImp(cbxVisualHearingImpairments);
    exchangeChildValueBean
                          .setCdVisHearImpSev(("".equalsIgnoreCase(cbxVisualHearingImpairments) || cbxVisualHearingImpairments == null) ? null
                                                                                                                                       : request
                                                                                                                                                .getParameter("selSzCdVisualHearingImpairments"));
    String cbxPhysicallyDisabled = request.getParameter("cbxPhysicallyDisabled");
    exchangeChildValueBean.setIndPhyDisabled(cbxPhysicallyDisabled);
    exchangeChildValueBean
                          .setCdPhyDisbldSev(("".equals(cbxPhysicallyDisabled) || cbxPhysicallyDisabled == null) ? null
                                                                                                                : request
                                                                                                                         .getParameter("selSzCdPhysicallyDisabled"));
    String cbxEmotionallyDisturbed = request.getParameter("cbxEmotionallyDisturbed");
    exchangeChildValueBean.setIndEmotDist(cbxEmotionallyDisturbed);
    exchangeChildValueBean
                          .setCdEmotDistSev(("".equals(cbxEmotionallyDisturbed) || cbxEmotionallyDisturbed == null) ? null
                                                                                                                   : request
                                                                                                                            .getParameter("selSzCdEmotionallyDisturbed"));
    String cbxOtherMedicalDiagnoses = request.getParameter("cbxOtherMedicalDiagnoses");
    exchangeChildValueBean.setIndOthMedDiag(cbxOtherMedicalDiagnoses);
    exchangeChildValueBean
                          .setCdOthDiagSev(("".equals(cbxOtherMedicalDiagnoses) || cbxOtherMedicalDiagnoses == null) ? null
                                                                                                                    : request
                                                                                                                             .getParameter("selSzCdOtherMedicalDiagnoses"));

    exchangeChildValueBean.setIndFamHxDrAlc(request.getParameter("cbxFamilyHxofDrugsAlcohol"));
    exchangeChildValueBean.setIndFamHxMentIll(request.getParameter("cbxFamilyHxofMentalIllness"));
    exchangeChildValueBean.setIndFamHxMr(request.getParameter("cbxFamilyHxofMR"));
    exchangeChildValueBean.setIndChildHxSexAbuse(request.getParameter("cbxChilsHxofSexualAbuse"));

    String[] raceCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbxRace");
    exchangeChildValueBean
                          .setLstRacePrefs((raceCheckedBoxes != null && raceCheckedBoxes.length > 0) ? Arrays
                                                                                                             .asList(raceCheckedBoxes)
                                                                                                    : null);

    String[] ethnicityCheckedBoxes = CheckboxHelper.getCheckedValues(request, "cbxEth");
    exchangeChildValueBean
                          .setLstEthnicityPrefs((ethnicityCheckedBoxes != null && ethnicityCheckedBoxes.length > 0) ? Arrays
                                                                                                                            .asList(ethnicityCheckedBoxes)
                                                                                                                   : null);

    List<String> lstNonAvailCodes = new ArrayList<String>();
    lstNonAvailCodes.add(CodesTables.CANONAV_00);
    lstNonAvailCodes.add(CodesTables.CANONAV_03);
    exchangeChildValueBean.setLstNonAvailCodes(lstNonAvailCodes);
    //SMS#37439 Exchange Child Search via Match button on EHD did not populate the maxminage dropdowns on the ECS page.
    makeMaxMinAgeDropdowns(context);
    return exchangeChildValueBean;
  }
  
  private boolean isAdoptionExchangeConsultant(HttpServletRequest request) {
    boolean retValue = false;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_SAU_EXCHANGE);
    }
    return retValue;
  }
  
  private boolean hasAdoptionViewAccess(HttpServletRequest request) {
    boolean retValue = false;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_ADO_VIEW);
    }
    return retValue;
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
        setErrorMessage(errorCode, DISPLAY_EXCHANGE_HOME_URL, request);
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
  
  private void handleDisplayError(ServiceException we, GrndsExchangeContext context) {
    try {
      HttpServletRequest request = context.getRequest();
      String errorMessage;
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_ADO_EXH_APRV_FH_CONV_REQ:
          int[] errors = new int[] {errorCode};
          ErrorList.setErrors(errors, request);
          setPresentationBranch(BRANCH_EVENT_LIST, context);
          return;
        default:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
          displayMessagePage(errorMessage, context);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }
 
  // SMS#37439 Added this method to populate the max min age dropdowns when coming on Exchange Child Search via Match
  // button on EHD page.
  /**
   * Creates the Male and Female Age Range dropdown options.
   * 
   * @param context
   *                The GrndsExchangeContext object.
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
}
