package gov.georgia.dhr.dfcs.sacwis.web.fad;

import java.io.StringReader;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD14SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00_ARRAY;
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
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;

/**
 * This is the Conversation class used to view and maintain the Home History Information for an F/A Home
 *
 * @author J Heather Dean, January 3, 2002 04/18/05  Hadjimh    SIR#23327. added Certify Entity
 */

public class FAHomeHistoryConversation extends BaseHiddenFieldStateConversation {
  // Static Constants
  public static final String TRACE_TAG = "FAHomeHistoryConversation";

  public static final String CODE_BASIC = CodesTables.CFAHMTYP_B;

  public static final String CODE_HABILITATIVE = CodesTables.CFAHMTYP_H;

  public static final String CODE_THERAPEUTIC = CodesTables.CFAHMTYP_P;

  public static final String CODE_PMN = CodesTables.CFAHMTYP_R;

  public static final String CODE_GROUP = CodesTables.CFAHMTYP_U;

  public static final String CODE_KIN_GP = CodesTables.CFAHMTYP_X;

  public static final String CODE_KIN_AU = CodesTables.CFAHMTYP_Y;

  public static final String CODE_KIN_OF = CodesTables.CFAHMTYP_Z;

  public static final String CODE_STATUS_INQUIRY = CodesTables.CFAHMSTA_010;

  public static final String CODE_STATUS_RECRUIT = CodesTables.CFAHMSTA_020;

  public static final String CODE_STATUS_APPLICANT = CodesTables.CFAHMSTA_030;

  public static final String CODE_STATUS_APPROVED_ACTIVE = CodesTables.CFAHMSTA_040;

  public static final String CODE_STATUS_APPROVED_INACTIVE = CodesTables.CFAHMSTA_050;

  public static final String CODE_STATUS_PENDING_APPROVAL = CodesTables.CFAHMSTA_060;

  public static final String CODE_STATUS_CLOSED = CodesTables.CFAHMSTA_070;

  public static final String CODE_STATUS_PENDING_CLOSURE = CodesTables.CFAHMSTA_080;

  public static final String CODE_STATUS_CLOSED_DUPLICATE = CodesTables.CFAHMSTA_090;

  public static final String CODE_ADOPTIVE = CodesTables.CFACATEG_A;

  public static final String CODE_KINSHIP = CodesTables.CFACATEG_K;

  public static final int NUM_ROWS_PER_PAGE = 40;

  public static final int FAD_MAX_AGE_YR = 19;

  public static final int FAD_MIN_AGE_YR = 0;

  public static final int FAD_MAX_AGE_MO = 11;

  public static final int FAD_MIN_AGE_MO = 0;

  public static final String EVENT_DESCR_TEXT = "Change to F/A Home History Effective ";

  public static final String EVENT_STATUS_COMP = "COMP";

  public static final String EVENT_TYPE_HME = "HME";

  public static final String IND_WRITE_HIST = "Y";

  public static final String STATUS_ACTIVE = "01";

  public static final String STATUS_INACTIVE = "02";

  public static final String FAD_DEFAULT_TIME = "12:00 AM";

  public static final String HIST_LITERAL_DATE = "date.";

  public static final String IND_YES = "Y";

  public static final String IND_NO = "N";

  public static final String ID_RSRC_HIST = "ulIdResourceHistory";

  public static final String SVC_CFAD13S = "CFAD13S";

  public static final String OUTPUTOBJ_CFAD13 = "cfad13so";

  public static final String ERROR_BRANCH = "error";

  public static final String DISP_DETAIL_URL = "/fad/FAHomeHistory/displayHomeHistoryDetail";

  private Resource resource;

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  /**
   * This method is called by the GRNDS controller when a user opens the FA Home History List page
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayHomeHistoryList_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayHomeHistoryList_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      if (state != null) {
        state.removeAllAttributes(request);
      }

      //Page mode Initialize
      if (GlobalData.getAppMode(request) != null) {
        PageMode.setPageMode(GlobalData.getAppMode(request), request);
      }

      // Pagination
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(NUM_ROWS_PER_PAGE);

      //get the id of the logged on user
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      String userName = "";
      int userID = 0;


      CFAD12SI cfad12si = populateCFAD12SI_Retrieve(context, tuxPagination);

      //call the Tuxedo service using the WtcHelper object
      //CFAD12SO cfad12so = CFAD12SO.unmarshal(new StringReader(WtcHelper.callService("CFAD12S", cfad12si)));
      CFAD12SO cfad12so = resource.retrieveFAHomeHistory(cfad12si);
      state.setAttribute("CFAD12SO", cfad12so, request);
      int rowSize = cfad12so.getROWCFAD12SOG00_ARRAY().getROWCFAD12SOG00Count();

      tuxPagination.setPaginationInformation(cfad12so.getArchOutputStruct(), rowSize);
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
      //this.storePaginationBeanToRequest(context, tuxPagination);
    } catch (Exception e) {
      handleException(e, context, "displayHomeHistoryList_xa");
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called by the displayHomeHistoryList_xa to populate the input object for the cfad12s retrieve
   * service.
   *
   * @param context The GrndeExchangeContext
   */
  private CFAD12SI populateCFAD12SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD12SI_Retrieve");
    performanceTrace.enterScope();
    //Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    //get the id of the logged on user
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String user = "";
    if (userProfile != null) {
      user = userProfile.getUserLogonID();
    }

    //Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CFAD12SI cfad12si = new CFAD12SI();

    //Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    input.setSzUserId(user);
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(NUM_ROWS_PER_PAGE);

    cfad12si.setArchInputStruct(input);
    cfad12si.setUlIdStage(GlobalData.getUlIdStage(request));

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cfad12si;
  }

  /**
   * This method is called by the GRNDS controller when a user opens the FA Home History Detail page
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayHomeHistoryDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayHomeHistoryDetail_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      CFAD12SO cfad12so = (CFAD12SO) state.getAttribute("CFAD12SO", request);
      if (cfad12so != null) {
        ROWCFAD12SOG00_ARRAY homeRowArray = cfad12so.getROWCFAD12SOG00_ARRAY();
        int arrayIndex = ContextHelper.getIntSafe(context, "arrayIndex");
        ROWCFAD12SOG00 selectedRow = homeRowArray.getROWCFAD12SOG00(arrayIndex);
        request.setAttribute("currentRow", selectedRow);
        /*SIR#18798: added two if conditions. decrement/increment arrayIndex */
        if (arrayIndex > 0) {
          ROWCFAD12SOG00 nextRow = homeRowArray.getROWCFAD12SOG00(arrayIndex - 1);
          request.setAttribute("nextStartDate", nextRow.getDtDtRshsEffective());
        }

        if (arrayIndex + 1 < cfad12so.getROWCFAD12SOG00_ARRAY().getUlRowQty()) {
          ROWCFAD12SOG00 previousRow = homeRowArray.getROWCFAD12SOG00(arrayIndex + 1);
          request.setAttribute("previousEndDate", previousRow.getDtDtRshsEnd());
        }
      }

      int ulIdResourceHistory = ContextHelper.getIntSafe(context, ID_RSRC_HIST);
      if (ulIdResourceHistory != 0) {
        //Allocate the structures
        CFAD13SI cfad13si = new CFAD13SI();
        ArchInputStruct input1 = new ArchInputStruct();
        CFAD13SO cfad13so = new CFAD13SO();

        //Set the values for the ArchInputStruct
        input1.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);

        cfad13si.setArchInputStruct(input1);
        cfad13si.setUlIdResourceHistory(ulIdResourceHistory);

        //call the Tuxedo service using the WtcHelper object
        //cfad13so = CFAD13SO.unmarshal(new StringReader(WtcHelper.callService(SVC_CFAD13S, cfad13si)));
        cfad13so = resource.retrieveResourceHistory(cfad13si);
        state.setAttribute(OUTPUTOBJ_CFAD13, cfad13so, request);
      }

      SortedMap years = new TreeMap();
      SortedMap months = new TreeMap();
      int yearCount = FAHomeHistoryConversation.FAD_MIN_AGE_YR;
      int monthCount = FAHomeHistoryConversation.FAD_MIN_AGE_MO;
      Option anOption = null;

      while (yearCount <= FAHomeHistoryConversation.FAD_MAX_AGE_YR) {
        anOption = new Option(String.valueOf(yearCount), String.valueOf(yearCount));
        years.put(yearCount++, anOption);
      }

      request.setAttribute("years", years);

      while (monthCount <= FAHomeHistoryConversation.FAD_MAX_AGE_MO) {
        anOption = new Option(String.valueOf(monthCount), String.valueOf(monthCount));
        months.put(monthCount++, anOption);
      }

      request.setAttribute("months", months);

      state.removeAttribute("CFAD12SO", request);
    } catch (Exception e) {
      handleException(e, context, "displayHomeHistoryDetail_xa");
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the Delete button on the Home History List page
   *
   * @param context The GrndsExchangeContext object.
   */
  /* public void deleteHomeHistoryRow_xa(GrndsExchangeContext context) {
   // Instantiate and start a new PerformanceTrace object
   PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteHomeHistoryRow_xa");
   performanceTrace.enterScope();

   HttpServletRequest request = context.getRequest();
   BaseSessionStateManager state = getSessionStateManager(context);

   try {
   int ulIdResourceHistory = ContextHelper.getIntSafe(context, ID_RSRC_HIST);
   if (ulIdResourceHistory != 0) {
   //Allocate the structures
   CFAD13SI cfad13si = new CFAD13SI();
   ArchInputStruct input1 = new ArchInputStruct();
   CFAD13SO cfad13so = new CFAD13SO();

   //Set the values for the ArchInputStruct
   input1.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);

   cfad13si.setArchInputStruct(input1);
   cfad13si.setUlIdResourceHistory(ulIdResourceHistory);

   //call the Tuxedo service using the WtcHelper object
   //cfad13so = CFAD13SO.unmarshal(new StringReader(WtcHelper.callService(SVC_CFAD13S, cfad13si)));
   cfad13so = resource.retrieveResourceHistory(cfad13si);
   state.setAttribute(OUTPUTOBJ_CFAD13, cfad13so, request);
   }

   CFAD14SI cfad14si = populateCFAD14SI_D(context);
   WtcHelper.callService("CFAD14S", cfad14si);
   //resource.saveResourceHistory();
   }
   catch (Exception e) {
   handleException(e, context, "deleteHomeHistoryRow_xa");
   }

   this.displayHomeHistoryList_xa(context);

   // Log the performance trace info
   performanceTrace.getTotalTime();
   performanceTrace.exitScope();
   }
   */
  /**
   * This method is called by the GRNDS controller 
   * when a user clicks the Delete button on the Home History List page.
   * 
   * @param context The GrndsExchangeContext object.
   */
  public void deleteHomeHistoryRow_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteHomeHistoryRow_xa");
    performanceTrace.enterScope();

    //Set the idResourceHistory in CFAD14SI object and call the delete service.
    CFAD14SI cfad14si = populate_CFAD14SI(context);

    String selected = ContextHelper.getStringSafe(context, "selected");
    if (ArchitectureConstants.TRUE.equals(selected)) {
      CFAD14SO cfad14SO = resource.deleteResourceHistory(cfad14si);
    }

    //Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  private CFAD14SI populate_CFAD14SI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populate_CFAD14SI");
    performanceTrace.enterScope();
    //Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();

    //Allocate the structures
    CFAD14SIG00 cfad14sig00 = new CFAD14SIG00();
    CFAD14SI cfad14si = new CFAD14SI();
    ArchInputStruct input = new ArchInputStruct();

    //Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());

    int idResourceHistory = ContextHelper.getIntSafe(context, ID_RSRC_HIST);

    cfad14sig00.setUlIdResourceHistory(idResourceHistory);
    cfad14si.setArchInputStruct(input);
    cfad14si.setCFAD14SIG00(cfad14sig00);

    //Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cfad14si;

  }

  /**
   * This method is called by the GRNDS controller when a user clicks the Delete button on the Home History Detail
   * page.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void deleteHomeHistoryDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "deleteHomeHistoryDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      //Allocate the structures
      CFAD13SI cfad13si = new CFAD13SI();
      ArchInputStruct input1 = new ArchInputStruct();
      CFAD13SO cfad13so = new CFAD13SO();

      if (state.getAttribute(OUTPUTOBJ_CFAD13, request) == null) {
        int ulIdResourceHistory = ContextHelper.getIntSafe(context, ID_RSRC_HIST);
        if (ulIdResourceHistory != 0) {

          //Set the values for the ArchInputStruct
          input1.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);

          cfad13si.setArchInputStruct(input1);
          cfad13si.setUlIdResourceHistory(ulIdResourceHistory);

          //call the Tuxedo service using the WtcHelper object
          cfad13so = CFAD13SO.unmarshal(new StringReader(WtcHelper.callService(SVC_CFAD13S, cfad13si)));
          state.setAttribute(OUTPUTOBJ_CFAD13, cfad13so, request);
        }
      } else {
        cfad13so = (CFAD13SO) state.getAttribute(OUTPUTOBJ_CFAD13, request);
      }

      CFAD14SI cfad14si = populateCFAD14SI_D(context);
      WtcHelper.callService("CFAD14S", cfad14si);
    } catch (Exception e) {
      handleException(e, context, "deleteHomeHistoryDetail_xa");
    }

    this.displayHomeHistoryList_xa(context);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks the 'Save' button on F/A Home History Detail
   * page.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveHomeHistory_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveHomeHistory_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      CFAD14SI cfad14si = populateCFAD14SI_AU(context);
      WtcHelper.callService("CFAD14S", cfad14si);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (Exception e) {
      handleException(e, context, "saveHomeHistory_xa");
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the saveHomeHistory_xa to populate the input object for the cfad14s save service.
   *
   * @param context The GrndeExchangeContext
   */
  private CFAD14SI populateCFAD14SI_AU(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD14SI_AU");
    performanceTrace.enterScope();
    //Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    //Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());

    //get the id of the logged on user
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String userName = "";
    int userID = 0;
    if (userProfile != null) {
      userName = userProfile.getUserLogonID();
      userID = userProfile.getUserID();
    }

    Date timestamp = ContextHelper.getJavaDateSafe(context, "timestamp");
    int ulIdResourceHistory = ContextHelper.getIntSafe(context, ID_RSRC_HIST);

    String cReqFuncCode = null;
    String indFosterTypeChange = IND_NO;
    String indLocChange = IND_NO;
    org.exolab.castor.types.Date closureDate = null;
    String overallStatus = "";

    boolean indTherapeutic = false;
    boolean indHabilitative = false;
    boolean indPMN = false;

    String fosterTypes = "";
    String[] checkedBoxes = CheckboxHelper.getCheckedValues(request, "famTypes");

    StringBuffer strbuff = new StringBuffer(8);
    for (int i = checkedBoxes.length - 1; i >= 0; i--) {
      strbuff.append(checkedBoxes[i]);
      if (checkedBoxes[i].equals(CODE_HABILITATIVE)) {
        indHabilitative = true;
      }
      if (checkedBoxes[i].equals(CODE_THERAPEUTIC)) {
        indTherapeutic = true;
      }
      if (checkedBoxes[i].equals(CODE_PMN)) {
        indPMN = true;
      }

    }

    fosterTypes = strbuff.toString();

    org.exolab.castor.types.Date startDate = ContextHelper.getCastorDateSafe(context, "startDate");
    org.exolab.castor.types.Date endDate = ContextHelper.getCastorDateSafe(context, "endDate");

    boolean bEffectiveDateHasChanged = false;
    boolean bEndDateHasChanged = false;

    String category = ContextHelper.getStringSafe(context, "selCategory");
    int capacity = ContextHelper.getIntSafe(context, "txtCapacity");
    String status = ContextHelper.getStringSafe(context, "selStatus");

    int minMaleYear = ContextHelper.getIntSafe(context, "selMaleMinYear");
    int minMaleMonth = ContextHelper.getIntSafe(context, "selMaleMinMonth");
    int maleMinimumAgeInMonths = (minMaleYear * 12) + minMaleMonth;
    int maxMaleYear = ContextHelper.getIntSafe(context, "selMaleMaxYear");
    int maxMaleMonth = ContextHelper.getIntSafe(context, "selMaleMaxMonth");
    int maleMaximumAgeInMonths = (maxMaleYear * 12) + maxMaleMonth;
    int minFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMinYear");
    int minFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMinMonth");
    int femaleMinimumAgeInMonths = (minFemaleYear * 12) + minFemaleMonth;
    int maxFemaleYear = ContextHelper.getIntSafe(context, "selFemaleMaxYear");
    int maxFemaleMonth = ContextHelper.getIntSafe(context, "selFemaleMaxMonth");
    int femaleMaximumAgeInMonths = (maxFemaleYear * 12) + maxFemaleMonth;
    String closureReason = ContextHelper.getStringSafe(context, "selClosureReason");
    String recReopen = ContextHelper.getStringSafe(context, "selRecReopen");
    String involClosure = ContextHelper.getStringSafe(context, "selInvolClosure");

    String strEffectiveDate = FormattingHelper.formatDate(startDate);
    String strEndDate = FormattingHelper.formatDate(endDate);
    boolean isCurrentRow = false;
    if ("".equals(strEndDate)) {
      strEndDate = HIST_LITERAL_DATE;
      isCurrentRow = true;
    }
    String eventDescription = EVENT_DESCR_TEXT + strEffectiveDate + " to " + strEndDate;

    //Allocate the structures
    CFAD14SIG00 cfad14sig00 = new CFAD14SIG00();
    CFAD14SI cfad14si = new CFAD14SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();

    CFAD13SO cfad13so = new CFAD13SO();

    if (state.getAttribute(OUTPUTOBJ_CFAD13, request) != null) {
      cfad13so = (CFAD13SO) state.getAttribute(OUTPUTOBJ_CFAD13, request);

      //Determine whether Effective Date or End Date have changed
      if (!startDate.equals(cfad13so.getDtDtRshsEffective())) {
        bEffectiveDateHasChanged = true;
        indLocChange = IND_YES;
      }

      if (!endDate.equals(cfad13so.getDtDtRshsEnd())) {
        bEndDateHasChanged = true;
        indLocChange = IND_YES;
      }

      //If status was closed or pending closure but is no longer closed or pending closure
      //set closure values to null
      if ((cfad13so.getSzCdRshsFaHomeStatus().equals(CODE_STATUS_CLOSED) || cfad13so
                                                                                    .getSzCdRshsFaHomeStatus()
                                                                                    .equals(CODE_STATUS_PENDING_CLOSURE))
          && (!status.equals(CODE_STATUS_CLOSED) && !status.equals(CODE_STATUS_PENDING_CLOSURE))) {
        closureReason = "";
        recReopen = "";
        involClosure = "";
        closureDate = null;
        overallStatus = STATUS_ACTIVE;
      }

      //If home is NOW closed but was previously open
      if (!cfad13so.getSzCdRshsFaHomeStatus().equals(CODE_STATUS_CLOSED) && status.equals(CODE_STATUS_CLOSED)) {
        closureDate = startDate;
        overallStatus = STATUS_INACTIVE;
      }

      //If home is NOW Adoptive don't save any Foster Types
      if (category.equals(CODE_ADOPTIVE) && !cfad13so.getSzCdRshsCategory().equals(CODE_ADOPTIVE)) {
        fosterTypes = "";
      }

      //If Foster Types have changed, set indFosterTypeChange to 'Y'
      if (!fosterTypes.equals(cfad13so.getCCdRshsFaHomeType1())) {
        indFosterTypeChange = IND_YES;
      }

      if (status.equals(CODE_STATUS_INQUIRY) || status.equals(CODE_STATUS_RECRUIT)
          || status.equals(CODE_STATUS_APPLICANT)) {
        indLocChange = IND_NO;
        //if status has changed, do the LOC Processing
      } else if (!status.equals(cfad13so.getSzCdRshsFaHomeStatus())) {
        indLocChange = IND_YES;
      }

      //If Foster Home was previously a basic/group and now contain at least one of the
      //following: habilitative, therapeutic or medical needs OR previously contained one
      //of the aforementioned three types and is now only a basic or group home, set
      //sysIndLocChange to true
      if (((cfad13so.getCCdRshsFaHomeType1().indexOf(CODE_BASIC) > -1 || cfad13so.getCCdRshsFaHomeType1()
                                                                                 .indexOf(CODE_GROUP) > -1) && (cfad13so
                                                                                                                        .getCCdRshsFaHomeType1()
                                                                                                                        .indexOf(
                                                                                                                                 CODE_HABILITATIVE) == -1
                                                                                                                && cfad13so
                                                                                                                           .getCCdRshsFaHomeType1()
                                                                                                                           .indexOf(
                                                                                                                                    CODE_THERAPEUTIC) == -1 && cfad13so
                                                                                                                                                                       .getCCdRshsFaHomeType1()
                                                                                                                                                                       .indexOf(
                                                                                                                                                                                CODE_PMN) == -1))
          && (indHabilitative || indTherapeutic || indPMN)) {
        indLocChange = IND_YES;
      }

      if ((cfad13so.getCCdRshsFaHomeType1().indexOf(CODE_HABILITATIVE) > -1
           || cfad13so.getCCdRshsFaHomeType1().indexOf(CODE_THERAPEUTIC) > -1 || cfad13so.getCCdRshsFaHomeType1()
                                                                                         .indexOf(CODE_PMN) > -1)
          && (!indHabilitative && !indTherapeutic && !indPMN)) {
        indLocChange = IND_YES;
      }

      //Set the values for the ArchInputStruct
      if (PageMode.getPageMode(request).equals(PageModeConstants.MODIFY)) {
        cReqFuncCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      } else {
        cReqFuncCode = ServiceConstants.REQ_FUNC_CD_ADD;
      }

      input.setCReqFuncCd(cReqFuncCode);
      input.setSzUserId(userName);

      if (!cReqFuncCode.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
        cfad14sig00.setUlIdResourceHistory(ulIdResourceHistory);
      }

      cfad14sig00.setTsLastUpdate(timestamp);

      cfad14sig00.setSzAddrRshsAttn(cfad13so.getSzAddrRshsAttn());
      cfad14sig00.setSzAddrRshsCity(cfad13so.getSzAddrRshsCity());
      cfad14sig00.setSzAddrRshsStLn1(cfad13so.getSzAddrRshsStLn1());
      cfad14sig00.setSzAddrRshsStLn2(cfad13so.getSzAddrRshsStLn2());
      cfad14sig00.setLAddrRshsZip(cfad13so.getLAddrRshsZip());
      cfad14sig00.setSzCdRshsCampusType(cfad13so.getSzCdRshsCampusType());
      cfad14sig00.setSzCdRshsCategory(category);
      cfad14sig00.setSzCdRshsCertBy(cfad13so.getSzCdRshsCertBy());

      cfad14sig00.setSzCdRshsClosureRsn(closureReason);

      cfad14sig00.setSzCdRshsCnty(cfad13so.getSzCdRshsCnty());
      cfad14sig00.setSzCdRshsEthnicity(cfad13so.getSzCdRshsEthnicity());

      cfad14sig00.setSzCdRshsFaHomeStatus(status);
      if (!isCurrentRow) {
        cfad14sig00.setCCdRshsFaHomeType1(fosterTypes);
      } else {
        cfad14sig00.setCCdRshsFaHomeType1(cfad13so.getCCdRshsFaHomeType1());
      }
      cfad14sig00.setSzCdRshsFacilType(cfad13so.getSzCdRshsFacilType());
      cfad14sig00.setSzCdRshsHub(cfad13so.getSzCdRshsHub());

      cfad14sig00.setSzCdRshsInvolClosure(involClosure);

      cfad14sig00.setSzCdRshsLanguage(cfad13so.getSzCdRshsLanguage());
      cfad14sig00.setSzCdRshsMaintainer(cfad13so.getSzCdRshsMaintainer());
      cfad14sig00.setSzCdRshsMaritalStatus(cfad13so.getSzCdRshsMaritalStatus());
      cfad14sig00.setSzCdRshsOperBy(cfad13so.getSzCdRshsOperBy());
      cfad14sig00.setSzCdRshsOwnership(cfad13so.getSzCdRshsOwnership());
      cfad14sig00.setSzCdRshsPayment(cfad13so.getSzCdRshsPayment());

      cfad14sig00.setSzCdRshsRecmndReopen(recReopen);

      cfad14sig00.setSzCdRshsRegion(cfad13so.getSzCdRshsRegion());
      cfad14sig00.setSzCdRshsReligion(cfad13so.getSzCdRshsReligion());
      cfad14sig00.setSzCdRshsRespite(cfad13so.getSzCdRshsRespite());
      cfad14sig00.setSzCdRshsSchDist(cfad13so.getSzCdRshsSchDist());
      cfad14sig00.setSzCdRshsSetting(cfad13so.getSzCdRshsSetting());
      cfad14sig00.setSzCdRshsSourceInquiry(cfad13so.getSzCdRshsSourceInquiry());
      cfad14sig00.setSzCdRshsState(cfad13so.getSzCdRshsState());

      cfad14sig00.setSzCdRshsStatus(overallStatus);

      cfad14sig00.setSzCdRshsType(cfad13so.getSzCdRshsType());
      cfad14sig00.setDtDtRshsCert(cfad13so.getDtDtRshsCert());
      cfad14sig00.setDtDtRshsClose(closureDate);

      cfad14sig00.setDtDtRshsEffective(startDate);
      cfad14sig00.setDtDtRshsEnd(endDate);

      cfad14sig00.setDtDtRshsMarriage(cfad13so.getDtDtRshsMarriage());
      cfad14sig00.setUlIdResource(cfad13so.getUlIdResource());
      cfad14sig00.setUlIdEvent(cfad13so.getUlIdEvent());
      cfad14sig00.setUlIdStage(cfad13so.getUlIdStage());
      cfad14sig00.setCIndRshsCareProv(cfad13so.getCIndRshsCareProv());
      cfad14sig00.setCIndRshsEmergPlace(cfad13so.getCIndRshsEmergPlace());
      cfad14sig00.setCIndRshsInactive(cfad13so.getCIndRshsInactive());
      cfad14sig00.setCIndCurrHomeStudyExists(cfad13so.getCIndCurrHomeStudyExists());
      cfad14sig00.setCIndRshsNonDFCSHome(cfad13so.getCIndRshsNonDFCSHome());
      /* SIR#23327. added CertifyEntity */
      cfad14sig00.setSzTxtNdfcsCertEntity(cfad13so.getSzTxtNdfcsCertEntity());
      cfad14sig00.setCIndRshsTransport(cfad13so.getCIndRshsTransport());
      cfad14sig00.setCIndRshsWriteHist(IND_WRITE_HIST);
      cfad14sig00.setDNbrRshsAnnualIncome(cfad13so.getDNbrRshsAnnualIncome());
      cfad14sig00.setLNbrRshsCampusNbr(cfad13so.getLNbrRshsCampusNbr());
      cfad14sig00.setLNbrRshsFacilAcclaim(cfad13so.getLNbrRshsFacilAcclaim());

      cfad14sig00.setUNbrRshsFacilCapacity(capacity);
      cfad14sig00.setUNbrRshsFMAgeMax(femaleMaximumAgeInMonths);
      cfad14sig00.setUNbrRshsFMAgeMin(femaleMinimumAgeInMonths);
      cfad14sig00.setUNbrRshsIntChildren(cfad13so.getUNbrRshsIntChildren());

      cfad14sig00.setUNbrRshsIntFeAgeMax(femaleMaximumAgeInMonths);
      cfad14sig00.setUNbrRshsIntFeAgeMin(femaleMinimumAgeInMonths);
      cfad14sig00.setUNbrRshsIntMaAgeMax(maleMaximumAgeInMonths);
      cfad14sig00.setUNbrRshsIntMaAgeMin(maleMinimumAgeInMonths);

      cfad14sig00.setUNbrRshsMaAgeMax(maleMaximumAgeInMonths);
      cfad14sig00.setUNbrRshsMaAgeMin(maleMinimumAgeInMonths);
      cfad14sig00.setSNbrRshsOpenSlots(cfad13so.getSNbrRshsOpenSlots());
      cfad14sig00.setSzNbrRshsPhn(cfad13so.getSzNbrRshsPhn());
      cfad14sig00.setLNbrRshsPhoneExtension(cfad13so.getLNbrRshsPhoneExtension());
      cfad14sig00.setSzNbrRshsVid(cfad13so.getSzNbrRshsVid());
      cfad14sig00.setSzNmRshsContact(cfad13so.getSzNmRshsContact());

      cfad14sig00.setSzNmRshsLastUpdate(userName);

      cfad14sig00.setSzNmRshsResource(cfad13so.getSzNmRshsResource());
      cfad14sig00.setSzTxtRshsAddrCmnts(cfad13so.getSzTxtRshsAddrCmnts());
      cfad14sig00.setSzTxtRshsComments(cfad13so.getSzTxtRshsComments());
      if (bEffectiveDateHasChanged) {
        cfad14sig00.setTmScrTmGeneric1(FAD_DEFAULT_TIME);
      } else {
        cfad14sig00.setTmScrTmGeneric1(cfad13so.getTmScrTmGeneric1());
      }
      if (bEndDateHasChanged) {
        cfad14sig00.setTmScrTmGeneric5(FAD_DEFAULT_TIME);
      } else {
        cfad14sig00.setTmScrTmGeneric5(cfad13so.getTmScrTmGeneric5());
      }
      cfad14si.setArchInputStruct(input);
      cfad14si.setCSysIndFosterTypeChange(indFosterTypeChange);
      cfad14si.setCSysIndLocChange(indLocChange);
      cfad14si.setCFAD14SIG00(cfad14sig00);
      cfad14si.setROWCCMN01UIG00(rowccmn01uig00);

      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowccmn01uig00.setSzCdEventType(EVENT_TYPE_HME);
      rowccmn01uig00.setSzCdTask(null); //not a navigable to-do, so task is always null
      rowccmn01uig00.setDtDtEventOccurred(today);
      rowccmn01uig00.setUlIdStage(cfad13so.getUlIdStage());
      rowccmn01uig00.setUlIdPerson(userID);
      rowccmn01uig00.setSzTxtEventDescr(eventDescription);

      rowccmn01uig01.setUlIdPerson(userID);

      //Add the struct to the array
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      //Set the array into the parent struct
      rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    } //end if cfad13so not null

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cfad14si;
  }

  /**
   * This helper method is called by the deleteHomeHistoryRow_xa and deleteHomeHistoryDetail_xa to populate the input
   * object for the cfad14s save service.
   *
   * @param context The GrndeExchangeContext
   */
  private CFAD14SI populateCFAD14SI_D(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD14SI_D");
    performanceTrace.enterScope();
    //Get the request object from context to make input data available to this method
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    //Get today's date
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());

    //get the id of the logged on user
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    String userName = "";
    if (userProfile != null) {
      userName = userProfile.getUserLogonID();
    }

    int ulIdResourceHistory = ContextHelper.getIntSafe(context, ID_RSRC_HIST);

    Date timestamp = ContextHelper.getJavaDateSafe(context, "timestamp");

    String selected = ContextHelper.getStringSafe(context, "selected");

    //Allocate the structures
    CFAD14SIG00 cfad14sig00 = new CFAD14SIG00();
    CFAD14SI cfad14si = new CFAD14SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();

    if (state.getAttribute(OUTPUTOBJ_CFAD13, request) != null) {
      CFAD13SO cfad13so = (CFAD13SO) state.getAttribute(OUTPUTOBJ_CFAD13, request);
      String effectiveDate = FormattingHelper.formatDate(cfad13so.getDtDtRshsEffective());
      String endDate = FormattingHelper.formatDate(cfad13so.getDtDtRshsEnd());
      String eventDescription = EVENT_DESCR_TEXT + effectiveDate + " to " + endDate;

      //Set the values for the ArchInputStruct
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
      input.setSzUserId(userName);

      cfad14sig00.setUlIdResourceHistory(ulIdResourceHistory);
      if ("true".equals(selected)) {
        cfad14sig00.setTsLastUpdate(cfad13so.getTsLastUpdate());
      } else {
        cfad14sig00.setTsLastUpdate(timestamp);
      }

      cfad14si.setArchInputStruct(input);
      cfad14si.setCFAD14SIG00(cfad14sig00);
      cfad14si.setROWCCMN01UIG00(rowccmn01uig00);

      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowccmn01uig00.setSzCdEventType(EVENT_TYPE_HME);
      rowccmn01uig00.setDtDtEventOccurred(today);
      rowccmn01uig00.setUlIdStage(cfad13so.getUlIdStage());
      rowccmn01uig00.setUlIdPerson(userProfile.getUserID());
      rowccmn01uig00.setSzTxtEventDescr(eventDescription);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cfad14si;
  }

  /**
   * This method is called by the other methods when an exception is caught.
   *
   * @param context    The GrndsExchangeContext object.
   * @param e          The Exception
   * @param methodName A String containing the method which threw the exception
   */
  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    String stackTrace = BasePrsException.getStackTrace(e);

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "WtcException " + we.getClass() + " " + we.getMessage());
      e.printStackTrace();
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        setErrorMessage(errorMessage1, DISP_DETAIL_URL, context.getRequest());
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
        setErrorMessage(errorMessage2, DISP_DETAIL_URL, context.getRequest());
        break;
      case Messages.MSG_SYS_STAGE_CLOSED:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage4 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
        setErrorMessage(errorMessage4, DISP_DETAIL_URL, context.getRequest());
        break;
      case Messages.MSG_DETAIL_DELETED:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage5 = MessageLookup.getMessageByNumber(Messages.MSG_DETAIL_DELETED);
        setErrorMessage(errorMessage5, "/fad/FAHomeHistory/displayHomeHistoryList", context.getRequest());
        break;
      case Messages.SSM_ADVISE_REFRESH:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage6 = MessageLookup.getMessageByNumber(Messages.SSM_ADVISE_REFRESH);
        setErrorMessage(errorMessage6, "/fad/FAHomeHistory/displayHomeHistoryList", context.getRequest());
        break;
      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage7 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
        setErrorMessage(errorMessage7, DISP_DETAIL_URL, context.getRequest());
        break;
      case Messages.MSG_CODE_NOT_FOUND:
        this.setPresentationBranch(ERROR_BRANCH, context);
        String errorMessage8 = MessageLookup.getMessageByNumber(Messages.MSG_CODE_NOT_FOUND);
        setErrorMessage(errorMessage8, DISP_DETAIL_URL, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } //end if WTC exception
    else {
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "General Exception " + e.getClass() + " " + e.getMessage()
                                                      + stackTrace);
      processSevereException(context, e);
    } //end else

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  } //end handle exception

}
