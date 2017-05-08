package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExchangeChildDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SiblingGroupSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SiblingGroupSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeHomeSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeHomeSearchPullBack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain exchange child detail in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User           Description
 *   --------  --------       --------------------------------------------------
 *   07/01/08  mchillman      creation
 *   08/29/08  vdevarak       Initial Implementation
 *   10/28/08  mchillman      STGAP00010799 Change to check for exchangeChildDetailRetSI object on display that would be passed from
 *                            the exchange home link
 *   01/30/09  mchillman      STGAP00012134: reworked launch of Home Detail 
 *   o3/18/09  hjbaptiste     STGAP00012883: In populate_SaveSI(), converted dspIndBioLeg page field to 1 character long from 3 since column in 
 *                            the table holds 1 character 
 *   04/08/09  wjcochran      STGAP00012984: Set the global idResource in displayHomeDetail for use in displaying the Placement Log
 *   05/15/09  hjbaptiste     STGAP00013455: Fixed an error in setting the min and max age in months for sibling group. Set the races, ethnicities, 
 *                            background factors and max severity of all checked special needs characteristic of all children in the sibling group
 *   05/22/09  mchillman      MR-50 added delete buttons for linked children and for sau the page can always be modified   
 *   06/11/09  hjbaptiste     STGAP00013455: Set the number in the sibling group to the NBR_AVAIL in the DB
 *   12/05/09  mxpatel        SMS # 37348: Wrote code to set the hidden variable - hdnCdReasonClosed to yes if reason closed valued
 *                            changes from pre populated to blank.
 *   12/04/09  arege          SMS#40965 The Dissolution Date in the Closed With Placement section should be modifiable with a Date ticker.    
 *   12/15/09  mxpatel        SMS# 37447: modified the code to check if the value of birth name has changed on the page. If yes, set the 
 *                            IndBirthNameChanged to Y otherwise N.  
 *   4/12/10   cwells         SMS# 37365: If the rsn closed was changed to blank then whenever we re-access the page the reason should be blank and 
 *                            not continue to pull from the most recent legal status                         
 *  02/18/2011 arege           SMS#49672: Race selection issue on exchange home search page 
 *  01/21/2011 htvo           SMS#97845 MR-074-2: added constant MULTI_PUTATIVE_FATHER to be used in the new section Putative Father
 *  05/26/2011 hnguyen        SMS#109405: MR-083 Updated SaveSI population of recruitment activities date to be more dynamic. 
 * </pre>
 */

public class ExchangeChildDetailConversation extends BaseHiddenFieldStateConversation {
  public static final String PAGE_MODE = PageMode.PAGE_MODE_ATTRIBUTE_NAME;

  public static final String DISPLAY_EXCHANGE_CHILD = "/person/ExchangeChildDetail/displayExchangeChildDetail";

  public static final String EXCHANGE_CHILD_DETAIL = "exchangeChildDetailRetSO";

  public static final String PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME = "exchangeHomePullBackSearchBean";

  public static final String EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME = "ExchangeHomeDetail";

  public static final String CHILD_LINK_STRUCT = "childLinkStructList";

  public static final String RETURN_URL = "/person/ExchangeChildDetail/setMatchedHomes";

  public static final int PAGE_SIZE = 100;

  public static final String SORT_BY_NON_AVAIL_RSN_CODE = "1";

  public static final String SORT_BY_DT_OUT = "2";

  public static final String PULLBACK_RETURN_ATTRIBUTE_NAME = "exchangeHomePullBackInfo";
  
  public static final String EXCHANGE_HOME_LAUNCH_VARS = "ExchangeHomeLaunchVars"; 
  
  public static final String MULTI_PUTATIVE_FATHER = "Multiple Putative Fathers";

  private AdoExchange adoExchange = null;

  private CaseMgmt caseMgmt = null;

  public void setAdoExchange(AdoExchange adoExchange) {
    this.adoExchange = adoExchange;
  }

  /**
   * *************************************************************************** This method is called to display
   * Exchange Child Detail page
   */
  public void displayExchangeChildDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayExchangeChildDetail_xa()");
    performanceTrace.enterScope();
    try {
      String pageMode = PageModeConstants.MODIFY;
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
      ExchangeChildDetailRetrieveSI exchangeChildDetailRetSI = (ExchangeChildDetailRetrieveSI) state.getAttribute(EXCHANGE_HOME_LAUNCH_VARS, request);
      if(exchangeChildDetailRetSI != null) {
        exchangeChildDetailRetSI = populate_RetrieveSI_FromSI(exchangeChildDetailRetSI, context, tuxPagination);
        state.removeAttribute(EXCHANGE_HOME_LAUNCH_VARS, request);
      } else {
        exchangeChildDetailRetSI = populate_RetrieveSI(context, tuxPagination);
      }
      ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO = adoExchange
                                                                          .retrieveExchangeChildDetail(exchangeChildDetailRetSI);
      if (exchangeChildDetailRetSO != null && exchangeChildDetailRetSO.getChildLinkStructList().size() > 0) {
        tuxPagination.setPaginationInformation(exchangeChildDetailRetSO.getArchOutputStruct(),
                                               exchangeChildDetailRetSO.getChildLinkStructList().size());
      }
      CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
      if(ArchitectureConstants.Y.equals(stage.getIndStageClose())){
        pageMode = PageModeConstants.VIEW;
      }
      
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
      storePaginationBeanToRequest(context, tuxPagination);

      state.setAttribute(EXCHANGE_CHILD_DETAIL, exchangeChildDetailRetSO, request);
      performanceTrace.exitScope();
    } catch (ServiceException we) {
      processSevereException(context, we);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
  }

  /**
   * *************************************************************************** This method is called when the user
   * clicks the save button on the Exchange Child Detail page.
   */
  public void saveExchangeChildDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveExchangeChildDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      ExchangeChildDetailSaveSI exchangeChildDetailSaveSI = new ExchangeChildDetailSaveSI();
      populate_SaveSI(context, exchangeChildDetailSaveSI);
      ExchangeChildDetailSaveSO exchangeChildDetailSaveSO = adoExchange
                                                                       .saveExchangeChildDetail(exchangeChildDetailSaveSI);
      setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, DISPLAY_EXCHANGE_CHILD, request);
      GlobalData.setUlIdEvent(exchangeChildDetailSaveSO.getIdEvent(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "saveExchangeChildDetail_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * *************************************************************************** This method is called when the user
   * clicks the match button on the Exchange Child Detail page.
   */
  public void matchHomes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".matchHomes_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      ExchangeHomeSearchPullBack exHomeValueBean = new ExchangeHomeSearchPullBack();
      populateExchangeHomeValueBean(context, exHomeValueBean);
      exHomeValueBean.setDestinationUrl(RETURN_URL);
      forward(ExchangeHomeSearchConversation.SEARCH_PAGE, request, context.getResponse());
    } catch (Exception e) {
      handleException(e, context, "matchHomes_xa");
    }
    performanceTrace.exitScope();
  }

  public void setMatchedHomes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setMatchedHomes_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      List<ExchangeHomeValueBean> selectedHomesList = (List<ExchangeHomeValueBean>) request
                                                                                           .getAttribute(PULLBACK_RETURN_ATTRIBUTE_NAME);
      ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                                    .getAttribute(
                                                                                                                  EXCHANGE_CHILD_DETAIL,
                                                                                                                  request);
      if (exchangeChildDetailRetSO != null) {
        List<ChildLinkStruct> childLinkStructList = new ArrayList<ChildLinkStruct>();
        int idChildEvent = exchangeChildDetailRetSO.getExchangeChildStruct() == null ? 0
                                                                                    : exchangeChildDetailRetSO
                                                                                                              .getExchangeChildStruct()
                                                                                                              .getIdChildEvent();
        if (selectedHomesList != null && selectedHomesList.size() > 0) {
          Iterator it = selectedHomesList.iterator();
          while (it.hasNext()) {
            ChildLinkStruct childLinkStruct = new ChildLinkStruct();
            ExchangeHomeValueBean selectedHome = (ExchangeHomeValueBean) it.next();
            childLinkStruct.setIdResource(selectedHome.getIdResource());
            childLinkStruct.setNmResource(selectedHome.getHomeName());
            childLinkStruct.setNonAvlRsnCode(selectedHome.getCdNonAvaCode());
            childLinkStruct.setIdHomeEvent(selectedHome.getIdExchangeHome());
            childLinkStruct.setCounty(selectedHome.getCdCounty());
            childLinkStruct.setDtOut(selectedHome.getDateOut());
            childLinkStruct.setIdChildEvent(idChildEvent);
            childLinkStructList.add(childLinkStruct);
          }
          if (exchangeChildDetailRetSO.getChildLinkStructList() != null) {
            exchangeChildDetailRetSO.getChildLinkStructList().addAll(childLinkStructList);
          } else {
            exchangeChildDetailRetSO.setChildLinkStructList(childLinkStructList);
          }
        }
        state.setAttribute(CHILD_LINK_STRUCT, childLinkStructList, request);
      }
      String pageMode = PageModeConstants.MODIFY;
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
      if (exchangeChildDetailRetSO != null && exchangeChildDetailRetSO.getChildLinkStructList().size() > 0) {
        tuxPagination.setPaginationInformation(exchangeChildDetailRetSO.getArchOutputStruct(),
                                               exchangeChildDetailRetSO.getChildLinkStructList().size());
      }
      if(GlobalData.getUlIdEvent(request)!=0){
        CaseUtility.Event event = CaseUtility.getEvent(GlobalData.getUlIdEvent(request));
        if (CodesTables.CEVTSTAT_COMP.equals(event.getCdEventStatus())) {
          pageMode = PageModeConstants.VIEW;
        }
      }
      PageMode.setPageMode(pageMode, request);
      storePaginationBeanToRequest(context, tuxPagination);
      state.setAttribute(EXCHANGE_CHILD_DETAIL, exchangeChildDetailRetSO, request);
    } catch (Exception e) {
      handleException(e, context, "setMatchedHomes_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * *************************************************************************** This method is called when the user
   * clicks the Link button on the Exchange Child Detail page.
   */
  public void linkHomes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".linkHomes_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    List<ChildLinkStruct> childLinkStructList = new ArrayList<ChildLinkStruct>();
    // Get the list of homes that need to be linked from the request
    childLinkStructList = (List<ChildLinkStruct>) state.getAttribute(CHILD_LINK_STRUCT, request);
    if (childLinkStructList != null && childLinkStructList.size() > 0) {
      // Set the first record in the list with the non-availability reason code and the date out selected
      // on the page. While setting the db object in the save service all the link records are set with
      // these values.
      childLinkStructList.get(0).setNonAvlRsnCode(ContextHelper.getStringSafe(request, "szCdNonAvailRsn"));
      childLinkStructList.get(0).setDtOut(ContextHelper.getJavaDateSafe(request, "txtDtOutLink"));
      adoExchange.saveExChildFamLink(childLinkStructList);
    }
    state.removeAttribute(CHILD_LINK_STRUCT, request);
    performanceTrace.exitScope();
  }

  /**
   * *************************************************************************** This method is called when the user
   * clicks the Unlink button on the Exchange Child Detail page.
   */
  public void unLinkHomes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".unLinkHomes_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    ExchangeChildDetailRetrieveSO excChildRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                       .getAttribute(
                                                                                                     EXCHANGE_CHILD_DETAIL,
                                                                                                     request);
    if (excChildRetSO != null) {
      List<ChildLinkStruct> childLinkStructList = excChildRetSO.getChildLinkStructList();
      if (childLinkStructList != null && childLinkStructList.size() > 0) {
        List<ChildLinkStruct> unlinkList = new ArrayList<ChildLinkStruct>();
        int count = 0;
        Iterator it = childLinkStructList.iterator();
        while (it.hasNext()) {
          ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();
          String nmCbx = "cbxUnLink" + count;
          String valCbx = CheckboxHelper.getCheckboxValue(request, nmCbx);
          if (ArchitectureConstants.Y.equals(valCbx)) {
            ChildLinkStruct unlinkRecord = new ChildLinkStruct();
            unlinkRecord.setIdChildEvent(childLinkStruct.getIdChildEvent());
            unlinkRecord.setIdHomeEvent(childLinkStruct.getIdHomeEvent());
            unlinkRecord.setDtLastUpdate(childLinkStruct.getDtLastUpdate());
            unlinkRecord.setNonAvlRsnCode(ContextHelper.getStringSafe(request, "szCdNonAvailRsn"));
            unlinkRecord.setNonSelRsn(ContextHelper.getStringSafe(request, "szCdNonSelRsn"));
            unlinkRecord.setDtOut(ContextHelper.getJavaDateSafe(request, "txtDtOutLink"));
            unlinkRecord.setIndLinked(false);
            unlinkList.add(unlinkRecord);
          }
          count++;
        }
        adoExchange.saveExChildFamUnlink(unlinkList);
      }
    }
    performanceTrace.exitScope();
  }
  
  public void deleteNowConsidering_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteNowConsidering_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    ExchangeChildDetailRetrieveSO excChildRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                       .getAttribute(
                                                                                                     EXCHANGE_CHILD_DETAIL,
                                                                                                     request);
    if (excChildRetSO != null) {
      List<ChildLinkStruct> childLinkStructList = excChildRetSO.getChildLinkStructList();
      if (childLinkStructList != null && childLinkStructList.size() > 0) {
        List<ChildLinkStruct> unlinkList = new ArrayList<ChildLinkStruct>();
        int count = 0;
        Iterator <ChildLinkStruct>it = childLinkStructList.iterator();
        while (it.hasNext()) {
          ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();
          String nmCbx = "cbxUnLink" + count;
          String valCbx = CheckboxHelper.getCheckboxValue(request, nmCbx);
          if (ArchitectureConstants.Y.equals(valCbx)) {
            ChildLinkStruct unlinkRecord = new ChildLinkStruct();
            unlinkRecord.setIdChildEvent(childLinkStruct.getIdChildEvent());
            unlinkRecord.setIdHomeEvent(childLinkStruct.getIdHomeEvent());
            unlinkRecord.setIdExchangeChildFamLink(childLinkStruct.getIdExchangeChildFamLink());
            unlinkList.add(unlinkRecord);
          }
          count++;
        }
        adoExchange.deleteExChildFamUnlink(unlinkList);
      }
    }
    performanceTrace.exitScope();
  }
  
  public void deleteHasConsidered_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteHasConsidered_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    ExchangeChildDetailRetrieveSO excChildRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                       .getAttribute(
                                                                                                     EXCHANGE_CHILD_DETAIL,
                                                                                                     request);
    if (excChildRetSO != null) {
      List<ChildLinkStruct> childLinkStructList = excChildRetSO.getHasBeenChildLinkStructList();
      if (childLinkStructList != null && childLinkStructList.size() > 0) {
        List<ChildLinkStruct> unlinkList = new ArrayList<ChildLinkStruct>();
        int count = 0;
        Iterator <ChildLinkStruct>it = childLinkStructList.iterator();
        while (it.hasNext()) {
          ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();
          String nmCbx = "cbxDelete" + count;
          String valCbx = CheckboxHelper.getCheckboxValue(request, nmCbx);
          if (ArchitectureConstants.Y.equals(valCbx)) {
            ChildLinkStruct unlinkRecord = new ChildLinkStruct();
            unlinkRecord.setIdChildEvent(childLinkStruct.getIdChildEvent());
            unlinkRecord.setIdHomeEvent(childLinkStruct.getIdHomeEvent());
            unlinkRecord.setIdExchangeChildFamLink(childLinkStruct.getIdExchangeChildFamLink());
            unlinkList.add(unlinkRecord);
          }
          count++;
        }
        adoExchange.deleteExChildFamUnlink(unlinkList);
      }
    }
    performanceTrace.exitScope();
  }


  public void displayHomeDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomeDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String selectedIdHmEventStr = StringHelper.getSafeString(request.getParameter("hdnIdHomeEvent"));
    Integer ulIdResource = StringHelper.toInteger(request.getParameter("hdnIdResource"));
    GlobalData.setUlIdResource(ulIdResource, request);
    if (selectedIdHmEventStr != null) {
      try {
        int idHomeEvent = Integer.parseInt(selectedIdHmEventStr);
        CaseUtility.Event excEvent = CaseUtility.getEvent(idHomeEvent);
        CaseUtility.Stage excStage = CaseUtility.getStage(excEvent.getIdStage());
              
        String paramString = "actionEventId=" + idHomeEvent + "&actionStageCode=" + excStage.getCdStage() + "&actionStageName=" + 
        excStage.getNmStage() + "&actionTaskCode=" + "8085" + "&actionCaseId=" + excStage.getIdCase() + "&actionStageId=" +excEvent.getIdStage();
        GlobalData.setSzNmPersonFull(StringHelper.getSafeString(request.getParameter("hdnIdHomeName")), request);
        GlobalData.setSzNmCase(StringHelper.getSafeString(request.getParameter("hdnIdHomeName")), request); 
        
        String forwardUrl = "/workload/EventSearch/displayEventDetail?" + paramString;
        forward(forwardUrl, request, context.getResponse());
        
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        handleException(e, context, "displayHomeDetail_xa");
      }
    }
    performanceTrace.exitScope();
  }

  public void displayAdoInfo_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdoInfo_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String idStageStr = StringHelper.getSafeString(request.getParameter("hdnIdStage"));
    int idStage = 0;
    if (idStageStr != null) {
      idStage = Integer.parseInt(idStageStr);
    }
    int idEvent = ContextHelper.getIntSafe(request, "hdnIdChildEvent");
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
    performanceTrace.exitScope();
  }

  private void populate_SaveSI(GrndsExchangeContext context, ExchangeChildDetailSaveSI exchangeChildDetailSaveSI) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    ExchangeChildDetailRetrieveSO excChildRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                       .getAttribute(
                                                                                                     EXCHANGE_CHILD_DETAIL,
                                                                                                     request);
    Date dtOut = ContextHelper.getJavaDateSafe(request, "dspDtOut");
    if (excChildRetSO != null && excChildRetSO.getExchangeChildStruct() != null) {
      exchangeChildDetailSaveSI.setDtLastUpdate(excChildRetSO.getExchangeChildStruct().getDtLastUpdate());
      exchangeChildDetailSaveSI.setDtEventLastUpdate(excChildRetSO.getExchangeChildStruct().getDtEventLastUpdate());
      exchangeChildDetailSaveSI.setDtEventOccurred(excChildRetSO.getExchangeChildStruct().getDtEventOccurred());
    }
    exchangeChildDetailSaveSI.setDtOut(dtOut);
    String cdReasonClosedTemp = ContextHelper.getStringSafe(request, "hdnCdReasonClosed");
    exchangeChildDetailSaveSI.setCdReasonClosed(ContextHelper.getStringSafe(request, "szCdRsnClosed"));
    //37348: If changed the value of the reason closed from the pre-populated value to blank, set the indicator to Y.
    if ((!cdReasonClosedTemp.equals("")) && (exchangeChildDetailSaveSI.getCdReasonClosed().equals(""))) {
      exchangeChildDetailSaveSI.setIndRsnClosedChanged(ArchitectureConstants.Y);
      //SMS# 37365: If the rsn closed was changed to blank then whenever we re-access the page the reason should be blank and 
      // not continue to pull from the most recent legal status    
    } else if(ArchitectureConstants.Y.equals(excChildRetSO.getExchangeChildStruct().getIndRsnClosedChanged())){
      exchangeChildDetailSaveSI.setIndRsnClosedChanged(ArchitectureConstants.Y);
    }
    else{
      exchangeChildDetailSaveSI.setIndRsnClosedChanged(ArchitectureConstants.N);
    }
    exchangeChildDetailSaveSI.setCdNonAvailStatus(ContextHelper.getStringSafe(request, "szCdNonAvailRsnCode"));
    exchangeChildDetailSaveSI.setCdSevEmotionallyDist(ContextHelper.getStringSafe(request, "szCdEmtDistSevLevel"));
    exchangeChildDetailSaveSI.setCdSevMentalRetardation(ContextHelper.getStringSafe(request, "szCdMntRetSevLevel"));
    exchangeChildDetailSaveSI.setCdSevOtherMed(ContextHelper.getStringSafe(request, "szCdOthMedDiagSevLevel"));
    exchangeChildDetailSaveSI.setCdSevPhysicallyDisabled(ContextHelper.getStringSafe(request, "szCdPhyDisSevLevel"));
    exchangeChildDetailSaveSI.setCdSevVisualHearingImp(ContextHelper.getStringSafe(request, "szCdVisHearSevLevel"));
    exchangeChildDetailSaveSI.setDtApproved(ContextHelper.getJavaDateSafe(request, "dspDtApproved"));
    exchangeChildDetailSaveSI.setDtClose(ContextHelper.getJavaDateSafe(request, "txtDtClosedNP"));
    exchangeChildDetailSaveSI.setDtFinal(ContextHelper.getJavaDateSafe(request, "txtDtFinalCWP"));
    exchangeChildDetailSaveSI.setDtFinalEntered(ContextHelper.getJavaDateSafe(request, "txtDtFinalEnteredCWP"));
    exchangeChildDetailSaveSI.setDtNotified(ContextHelper.getJavaDateSafe(request, "dspDtNotified"));
    exchangeChildDetailSaveSI.setDtOut(dtOut);
    exchangeChildDetailSaveSI.setDtRegistered(ContextHelper.getJavaDateSafe(request, "txtDtRegistered"));
    exchangeChildDetailSaveSI.setDtReRegistered(ContextHelper.getJavaDateSafe(request, "txtDtReRegistered"));
    exchangeChildDetailSaveSI.setIdPerson(GlobalData.getUlIdPerson(request));
    exchangeChildDetailSaveSI.setIdStage(GlobalData.getUlIdStage(request));
    exchangeChildDetailSaveSI.setIdEvent(GlobalData.getUlIdEvent(request));
    exchangeChildDetailSaveSI.setIdCase(GlobalData.getUlIdCase(request));
    exchangeChildDetailSaveSI.setIdCaseWorker(user.getUserID());
    String indBioIsLegFather =  ContextHelper.getStringSafe(request, "dspIndBioLeg") == CodesTables.CPARSTAT_YES ? ArchitectureConstants.Y : ArchitectureConstants.N;
    // Size of column in table is 1 character
    exchangeChildDetailSaveSI.setIndBioIsLegFather(indBioIsLegFather);
    exchangeChildDetailSaveSI.setIndChHxSexualAbuse(ContextHelper.getStringSafe(request, "cbxChHxSxAbuse"));
    exchangeChildDetailSaveSI.setIndEmotionallyDist(ContextHelper.getStringSafe(request, "cbxEmtDisturbed"));
    exchangeChildDetailSaveSI.setIndFamHxDrugsAlcohol(ContextHelper.getStringSafe(request, "cbxFamHxDrgAlcohol"));
    exchangeChildDetailSaveSI.setIndFamHxMentalIll(ContextHelper.getStringSafe(request, "cbxFamHxMentIll"));
    exchangeChildDetailSaveSI.setIndFamHxMr(ContextHelper.getStringSafe(request, "cbxFamHxMR"));
    exchangeChildDetailSaveSI.setIndLegalRisk(ContextHelper.getStringSafe(request, "rbIndLegalRisk"));
    exchangeChildDetailSaveSI.setIndMentalRetardation(ContextHelper.getStringSafe(request, "cbxMntlRetard"));
    exchangeChildDetailSaveSI.setIndOtherMed(ContextHelper.getStringSafe(request, "cbxOthMedDiag"));
    exchangeChildDetailSaveSI.setIndPhysicallyDisabled(ContextHelper.getStringSafe(request, "cbxPhyDisabled"));
    exchangeChildDetailSaveSI.setIndVisualHearingImp(ContextHelper.getStringSafe(request, "cbxVislHearImp"));
    exchangeChildDetailSaveSI.setNbrAfile(ContextHelper.getStringSafe(request, "txtAFileNumCWP"));
    exchangeChildDetailSaveSI.setTxtAvailComments(ContextHelper.getStringSafe(request, "txtChAvlCmnts"));
    String txtBirthNameTemp = ContextHelper.getStringSafe(request, "hdnTxtBirthName");
  //37447: check if the value of birth name has changed on the page. If yes, set the IndBirthNameChanged to Y otherwise N.
    if((txtBirthNameTemp != null)&& (!txtBirthNameTemp.equals(exchangeChildDetailSaveSI.getTxtBirthName()))){
      exchangeChildDetailSaveSI.setIndBirthNameChanged(ArchitectureConstants.Y);
    } else {
      exchangeChildDetailSaveSI.setIndBirthNameChanged(ArchitectureConstants.N);
    }
    exchangeChildDetailSaveSI.setTxtBirthName(ContextHelper.getStringSafe(request, "txtNmBirth"));
    exchangeChildDetailSaveSI.setTxtChildIsLinked(ContextHelper.getStringSafe(request, "txtChLnkCmnts"));
    exchangeChildDetailSaveSI.setDtDissolutionCWP(ContextHelper.getJavaDateSafe(request, "dtDissolutionCWP")); //Added for SMS#40965
    exchangeChildDetailSaveSI.setTxtChildPlacedWith(ContextHelper.getStringSafe(request, "txtChPlcWithCmnts"));
    exchangeChildDetailSaveSI.setTxtExplanationNoPlcmt(ContextHelper.getStringSafe(request, "txtExplNpCmnts"));
    exchangeChildDetailSaveSI.setTxtRecruitComment(ContextHelper.getStringSafe(request, "txtRecActCmnts"));
    exchangeChildDetailSaveSI.setCdTask(GlobalData.getSzCdTask(request));
    exchangeChildDetailSaveSI.setNmChild(GlobalData.getSzNmPersonFull(request));
    exchangeChildDetailSaveSI.setTxtSpclNdsCmnts(ContextHelper.getStringSafe(request, "txtSpclNeedsCmnts"));
    // MR-083 radio button to indicate State is actively recruiting for child
    exchangeChildDetailSaveSI.setCdStateActivelyRecruiting(ContextHelper.getStringSafe(request, "rbStateActRecruiting"));
    // Setting the recruitment Activities dates from request.
    Collection<String> actList = new ArrayList<String>();
    Map<String, List<ExcChildAdoInfoCbxStruct>> modifiedRecActivitiesDates = new HashMap<String, List<ExcChildAdoInfoCbxStruct>>();
    Map<String, Date> newRecActivityDate = new HashMap<String, Date>();
    
    try{
      // get all possible recruitment activity codes
      actList = Lookup.getCategoryCodesCollection(CodesTables.CADRACS);
      
      if(actList != null && !actList.isEmpty()){
        Iterator<String> it = actList.iterator();
        
        // loop through each activity code
        while(it.hasNext()){
          String actCode = it.next();

          // get the date calendar field value if any
          Date newRecActDate = ContextHelper.getJavaDateSafe(request, "dtRecActState" + actCode);
          newRecActivityDate.put(actCode, newRecActDate);
          
          // get the each of the recruitment activities 10 date fields for any updates or additions
          List<ExcChildAdoInfoCbxStruct> recActList = new ArrayList<ExcChildAdoInfoCbxStruct>();

          // loop through each set of 10 dates that ends with actCode
          for(int i = 0; i < 10; i++){
            String attrNameId = "Date#_idInfoChar" + actCode;
            attrNameId = attrNameId.replace("#", String.valueOf(i));

            String attrName = "Date#_dtRecActState" + actCode;
            attrName = attrName.replace("#", String.valueOf(i));
            
            // retrieve each recruitment activity date from request and add to list in order
            Date dtRecAct = ContextHelper.getJavaDateSafe(request, attrName);
            int idRecAct = ContextHelper.getIntSafe(request, attrNameId);

            ExcChildAdoInfoCbxStruct excChildAdoInfoCbxStruct = null;
            
            // if no date entered AND field was not populated initially
            // then excChildAdoInfoCbxSO should remain null
            if( !(dtRecAct == null && idRecAct == 0)){
              excChildAdoInfoCbxStruct = new ExcChildAdoInfoCbxStruct();
              excChildAdoInfoCbxStruct.setIdInfoChar(idRecAct);
              excChildAdoInfoCbxStruct.setIdEvent(GlobalData.getUlIdEvent(request));
              excChildAdoInfoCbxStruct.setCdCbxCodeType(CodesTables.CADRACS);
              excChildAdoInfoCbxStruct.setCdAdoInfoCbx(actCode);
              excChildAdoInfoCbxStruct.setDtPerformed(dtRecAct);
            }
            
            recActList.add(excChildAdoInfoCbxStruct);
          } // end for loop
          modifiedRecActivitiesDates.put(actCode, recActList);
        } // end while it
      } // end if
    } catch (LookupException e){
      // if lookup exception then no changes should be made. Set maps to null to indicate 
      // something went wrong and we do not want to delete existing 
      // dates. There is a difference between null maps vs maps with null values.
      // Save service need to check for state of these maps.
      newRecActivityDate = null;
      modifiedRecActivitiesDates = null;
    }
    
    exchangeChildDetailSaveSI.setNewRecActivityDate(newRecActivityDate);
    exchangeChildDetailSaveSI.setModifiedRecActivitiesDates(modifiedRecActivitiesDates);
  }

  private ExchangeChildDetailRetrieveSI populate_RetrieveSI(GrndsExchangeContext context,
                                                            TuxedoPaginationValueBean tuxPagination)
                                                                                                    throws MarshalException,
                                                                                                    ValidationException,
                                                                                                    DataFormatException {
    HttpServletRequest request = context.getRequest();
    ExchangeChildDetailRetrieveSI exchangeChildDetailRetSI = new ExchangeChildDetailRetrieveSI();
    exchangeChildDetailRetSI.setUlIdCase(GlobalData.getUlIdCase(request));
    exchangeChildDetailRetSI.setUlIdStage(GlobalData.getUlIdStage(request));
    exchangeChildDetailRetSI.setUlIdChild(GlobalData.getUlIdPerson(request));
    exchangeChildDetailRetSI.setCdStage(GlobalData.getSzCdStage(request));
    exchangeChildDetailRetSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    
    return populate_RetrieveSI_FromSI(exchangeChildDetailRetSI, context, tuxPagination);
  }

  private void populateExchangeHomeValueBean(GrndsExchangeContext context, ExchangeHomeSearchPullBack exHomeValueBean) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String nonAvailRsnCode = ContextHelper.getStringSafe(request, "szCdNonAvailRsnCode");
    String cdCategory = ContextHelper.getStringSafe(request, "rbIndLegalRisk");
    if(ArchitectureConstants.Y.equals(cdCategory)){
      exHomeValueBean.setCdCategory(CodesTables.CFACATEG_L);
    }
    List<String> lstNonAvailCodes = new ArrayList<String>();
    lstNonAvailCodes.add(CodesTables.CANONAV_00);
    lstNonAvailCodes.add(CodesTables.CANONAV_03);
    exHomeValueBean.setLstCdNonAvaCodes(lstNonAvailCodes);
    String cbxMentalRetardation = request.getParameter("cbxMntlRetard");
    exHomeValueBean.setIndMentalRetardation(cbxMentalRetardation);
    exHomeValueBean
                   .setCdLevelMentalRetardation(("".equals(cbxMentalRetardation) || cbxMentalRetardation == null) ? null
                                                                                                                 : request
                                                                                                                          .getParameter("szCdMntRetSevLevel"));
    String cbxVisualHearingImpairments = request.getParameter("cbxVislHearImp");
    exHomeValueBean.setIndVisualHearingImpairments(cbxVisualHearingImpairments);
    exHomeValueBean
                   .setCdLevelVisualHearingImpairments(("".equalsIgnoreCase(cbxVisualHearingImpairments) || cbxVisualHearingImpairments == null) ? null
                                                                                                                                                : request
                                                                                                                                                         .getParameter("szCdVisHearSevLevel"));
    String cbxPhysicallyDisabled = request.getParameter("cbxPhyDisabled");
    exHomeValueBean.setIndPhysicallyDisabled(cbxPhysicallyDisabled);
    exHomeValueBean
                   .setCdLevelPhysicallyDisabled(("".equals(cbxPhysicallyDisabled) || cbxPhysicallyDisabled == null) ? null
                                                                                                                    : request
                                                                                                                             .getParameter("szCdPhyDisSevLevel"));
    String cbxEmotionallyDisturbed = request.getParameter("cbxEmtDisturbed");
    exHomeValueBean.setIndEmotionallyDisturbed(cbxEmotionallyDisturbed);
    exHomeValueBean
                   .setCdLevelEmotionallyDisturbed(("".equals(cbxEmotionallyDisturbed) || cbxEmotionallyDisturbed == null) ? null
                                                                                                                          : request
                                                                                                                                   .getParameter("szCdEmtDistSevLevel"));
    String cbxOtherMedicalDiagnoses = request.getParameter("cbxOthMedDiag");
    exHomeValueBean.setIndOtherMedicalDiagnoses(cbxOtherMedicalDiagnoses);
    exHomeValueBean
                   .setCdlevelOtherMedicalDiagnoses(("".equals(cbxOtherMedicalDiagnoses) || cbxOtherMedicalDiagnoses == null) ? null
                                                                                                                             : request
                                                                                                                                      .getParameter("szCdOthMedDiagSevLevel"));

    exHomeValueBean.setIndFamilyHxofDrugsAlcohol(request.getParameter("cbxFamHxDrgAlcohol"));
    exHomeValueBean.setIndFamilyHxofMentalIllness(request.getParameter("cbxFamHxMentIll"));
    exHomeValueBean.setIndFamilyHxofMR(request.getParameter("cbxFamHxMR"));
    exHomeValueBean.setIndChilsHxofSexualAbuse(request.getParameter("cbxChHxSxAbuse"));
    //SMS#49672
    String childRaceString = ContextHelper.getStringSafe(request, "dspRace");
    List<String> childRaceList = new ArrayList<String>();
    String childRaceDecode = StringHelper.EMPTY_STRING;
    String BLKANDWHITE = "Black and White";
    if (BLKANDWHITE.equals(childRaceString)) {
      childRaceList.add(CodesTables.CADRACE_BW);
      exHomeValueBean.setChildRacePref(childRaceList);
    } else {
      while (childRaceString.indexOf(',') > -1) { // if the childRaceString contains a comma i.e the child has two races
                                                  // checked
        int beginIndex = 0;
        int endIndex = childRaceString.indexOf(',');
        childRaceDecode = childRaceString.substring(beginIndex, endIndex);
        childRaceDecode = childRaceDecode.trim();
        String childRace = Lookup.simpleEncodeSafe(CodesTables.CRACE, childRaceDecode); // this will give the code
        if (StringHelper.isValid(childRace)) {
          childRaceList.add(childRace);
        }
        childRaceString = childRaceString.substring(endIndex + 1); // now remove the above code from childRaceString
        childRaceString = childRaceString.trim();
      }
      childRaceDecode = childRaceString.trim();
      String childRace = Lookup.simpleEncodeSafe(CodesTables.CRACE, childRaceDecode); // this will give the code
      if (StringHelper.isValid(childRace)) {
        childRaceList.add(childRace);
        exHomeValueBean.setChildRacePref(childRaceList);
      }
    }
    String childEthnicity = Lookup.simpleEncodeSafe(CodesTables.CINDETHN, ContextHelper.getStringSafe(request,
                                                                                                      "dspEthnicity"));
    List<String> childEthnicityList = new ArrayList<String>();
    if (StringHelper.isValid(childEthnicity)) {
      childEthnicityList.add(childEthnicity);
      exHomeValueBean.setChildEthnicityPerf(childEthnicityList);
    }
    String gender = Lookup.simpleEncodeSafe(CodesTables.CRSRCSEX, ContextHelper.getStringSafe(request, "dspGender"));
    exHomeValueBean.setCdGender(gender);
    int idSiblingGrp = ContextHelper.getIntSafe(request, "hdnIdSiblGroup");
    if (idSiblingGrp > 0) {
      SiblingGroupSI siblingGroupSI = new SiblingGroupSI();
      siblingGroupSI.setIdSiblingGroup(idSiblingGrp);
      siblingGroupSI.setCdPersonSex(gender);
      SiblingGroupSO siblingGroupSO = adoExchange.retrieveSiblingGroup(siblingGroupSI);
      if (siblingGroupSO != null) {
        exHomeValueBean.setNumOfChildren(siblingGroupSO.getNbrAvail());
        if (siblingGroupSO.getMaxPersonDob() != null) {
          int ageMaxInMonths = DateUtility.getAgeInMonths(siblingGroupSO.getMaxPersonDob(), new Date());
          // Set the minimum age in months to the youngest child in the sibling group. The youngest child would have
          // the max date of birth and therefore the lowest age in months when calculated using today's date
          exHomeValueBean.setMinRangeInMonths(ageMaxInMonths);
        }
        if (siblingGroupSO.getMinPersonDob() != null) {
          int ageMinInMonths = DateUtility.getAgeInMonths(siblingGroupSO.getMinPersonDob(), new Date());
          // Set the maximum age in months to the oldest child in the sibling group. The oldest child would have
          // the min date of birth and therefore the highest age in months when calculated using today's date
          exHomeValueBean.setMaxRangeInMonths(ageMinInMonths);
        }
        // Set the overall gender of all of the children in the Sibling Group
        if (siblingGroupSO.getCdOverallGender() != null) {
          exHomeValueBean.setCdGender(siblingGroupSO.getCdOverallGender());
        }
        // Set the list of all of the races of all of the children in the Sibling Group
        if (siblingGroupSO.getSiblingGroupRaces() != null && siblingGroupSO.getSiblingGroupRaces().size() > 0) {
          exHomeValueBean.setChildRacePref(siblingGroupSO.getSiblingGroupRaces());
        }
        // Set the list of all of the ethnicities of all of the children in the Sibling Group
        if (siblingGroupSO.getSiblingGroupEthnicities() != null && siblingGroupSO.getSiblingGroupEthnicities().size() > 0) {
          exHomeValueBean.setChildEthnicityPerf(siblingGroupSO.getSiblingGroupEthnicities());
        }
        // Set the background factors of all of the children in the Sibling Group
        if (siblingGroupSO.getSiblingGroupBackgroundFactors() != null && !siblingGroupSO.getSiblingGroupBackgroundFactors().isEmpty()) {
          Map<String, String> siblingGroupBackgroundFactors = siblingGroupSO.getSiblingGroupBackgroundFactors();
          if (ArchitectureConstants.Y.equals(siblingGroupBackgroundFactors.get("indFamHxDrugsAlcohol"))) {
            exHomeValueBean.setIndFamilyHxofDrugsAlcohol(siblingGroupBackgroundFactors.get("indFamHxDrugsAlcohol"));
          }
          if (ArchitectureConstants.Y.equals(siblingGroupBackgroundFactors.get("indFamHxMentalIll"))) {
            exHomeValueBean.setIndFamilyHxofMentalIllness(siblingGroupBackgroundFactors.get("indFamHxMentalIll"));
          }
          if (ArchitectureConstants.Y.equals(siblingGroupBackgroundFactors.get("indFamHxMr"))) {
            exHomeValueBean.setIndFamilyHxofMR(siblingGroupBackgroundFactors.get("indFamHxMr"));
          }
          if (ArchitectureConstants.Y.equals(siblingGroupBackgroundFactors.get("indChHxSexualAbuse"))) {
            exHomeValueBean.setIndChilsHxofSexualAbuse(siblingGroupBackgroundFactors.get("indChHxSexualAbuse"));
          }
        }
        // Set the maximum severity of each special needs characteristic of all of the children in the Sibling Group
        if (siblingGroupSO.getMaxSevSpecialNeedsCharacteristics()!= null && !siblingGroupSO.getMaxSevSpecialNeedsCharacteristics().isEmpty()) {
          Map<String, String> maxSevSpecialNeedsCharacteristics = siblingGroupSO.getMaxSevSpecialNeedsCharacteristics();
          if (StringHelper.isValid(maxSevSpecialNeedsCharacteristics.get("cdSevMentalRetardation"))) {
            exHomeValueBean.setIndMentalRetardation(ArchitectureConstants.Y);
            exHomeValueBean.setCdLevelMentalRetardation(maxSevSpecialNeedsCharacteristics.get("cdSevMentalRetardation"));
          }
          if (StringHelper.isValid(maxSevSpecialNeedsCharacteristics.get("cdSevVisualHearingImp"))) {
            exHomeValueBean.setIndVisualHearingImpairments(ArchitectureConstants.Y);
            exHomeValueBean.setCdLevelVisualHearingImpairments(maxSevSpecialNeedsCharacteristics.get("cdSevVisualHearingImp"));
          }
          if (StringHelper.isValid(maxSevSpecialNeedsCharacteristics.get("cdSevPhysicallyDisabled"))) {
            exHomeValueBean.setIndPhysicallyDisabled(ArchitectureConstants.Y);
            exHomeValueBean.setCdLevelPhysicallyDisabled(maxSevSpecialNeedsCharacteristics.get("cdSevPhysicallyDisabled"));
          }
          if (StringHelper.isValid(maxSevSpecialNeedsCharacteristics.get("cdSevEmotionallyDist"))) {
            exHomeValueBean.setIndEmotionallyDisturbed(ArchitectureConstants.Y);
            exHomeValueBean.setCdLevelEmotionallyDisturbed(maxSevSpecialNeedsCharacteristics.get("cdSevEmotionallyDist"));
          }
          if (StringHelper.isValid(maxSevSpecialNeedsCharacteristics.get("cdSevOtherMed"))) {
            exHomeValueBean.setIndOtherMedicalDiagnoses(ArchitectureConstants.Y);
            exHomeValueBean.setCdlevelOtherMedicalDiagnoses(maxSevSpecialNeedsCharacteristics.get("cdSevOtherMed"));
          }
        }
      }
    } else {
      Date dtChildDob = ContextHelper.getJavaDateSafe(request, "dspDtBirth");
      Date dtToday = new Date();
      int ageInMonths = DateUtility.getAgeInMonths(dtChildDob, dtToday);
      exHomeValueBean.setMaxRangeInMonths(ageInMonths);
      exHomeValueBean.setMinRangeInMonths(ageInMonths);
    }
    ValueBeanHelper.populateDefaultValues(context, exHomeValueBean);
    request.setAttribute(PULLBACK_SEARCH_BEAN_ATTRIBUTE_NAME, exHomeValueBean);
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
      case Messages.MSG_UNLINK_BEFORE_PLACEMENT:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, DISPLAY_EXCHANGE_CHILD, request);
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
  
  private ExchangeChildDetailRetrieveSI populate_RetrieveSI_FromSI(ExchangeChildDetailRetrieveSI exchangeChildDetailRetSI, 
                                                                   GrndsExchangeContext context,
                                                            TuxedoPaginationValueBean tuxPagination)
                                                                                                    throws MarshalException,
                                                                                                    ValidationException,
                                                                                                    DataFormatException {
    
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());

    exchangeChildDetailRetSI.setArchInput(input);

    // -- These are hidden inputs dynamically created by the ending impact:pagination tag on JSP.
    // -- They are given values by Java script called when clicking on the sort arrows generated via
    // -- the sortableColumnHeader tag.
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    if ("".equals(orderBy)) {
      orderBy = SORT_BY_DT_OUT;
    }
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
    if ("".equals(sortDir)) {
      sortDir = ServiceConstants.SORT_ASCENDING;
    }
    // -- Set into input object and also into tuxPagination so that logic for determining sortDir
    // -- in SortableColumnTag works.
    exchangeChildDetailRetSI.setBWcdCdSortBy(orderBy);
    exchangeChildDetailRetSI.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);
    return exchangeChildDetailRetSI;
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

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }
}
