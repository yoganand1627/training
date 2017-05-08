package gov.georgia.dhr.dfcs.sacwis.web.admin;

/**
 * Created on July 14, 2008 by Vishala Devarakonda
 */

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodeDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodesTableDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodeTypesRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to perform the Codes Tables Maintenance updates. <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date          User                    Description
 *                           ----------    --------------------    ----------------------
 *                           07/14/2008     vdevarakonda           Initial class creation
 */

public class CodesTablesMntConversation extends BaseHiddenFieldStateConversation {

  private Admin admin;

  public static final String SORT_BY_CODE = "1";

  public static final String SORT_BY_DECODE = "2";

  public static final String SORT_BY_END_DATE = "3";

  public static final int PAGE_SIZE = 50;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * displayCodesTypesList Method <p/> This method is called by the GRNDS controller when the user clicks the
   * CodesTables Maintenance second level tab.
   * 
   * @param context
   *                Context for the request
   */
  public void displayCodesTablesList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCodesTablesList_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      List<CodeTypesRetrieveSO> codeTypesList = admin.retrieveCodeTypesList();
      state.setAttribute("codeTypesList", codeTypesList, request);
    } catch (ServiceException we) {
      processSevereException(context, we);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * displayCodeTypeDetail Method <p/> This method is called by the GRNDS controller when the user clicks the Edit
   * button on the Code Types List page.
   * 
   * @param context
   *                Context for the request
   */
  public void displayCodesTableDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCodeTypesList_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
      String codeType = ContextHelper.getStringSafe(context, "hdnCodeType");
      if ("".equals(codeType)) {
        codeType = (String) state.getAttribute("codeType", request) == null ? ""
                                                                           : (String) state.getAttribute("codeType",
                                                                                                         request);
      }
      CodesTableDetailRetrieveSI codeTblDtlRetSI = populate_CodesTblDtlRetSI(context, tuxPagination);
      codeTblDtlRetSI.setCodeType(codeType);
      CodesTableDetailRetrieveSO codesTableDtl = admin.retrieveCodesTableDetail(codeTblDtlRetSI);
      state.setAttribute("codesTableDtl", codesTableDtl, request);
      tuxPagination.setPaginationInformation(codesTableDtl.getArchOutputStruct(),
                                             codesTableDtl.getCodesTablesStructList().size());
      state.setAttribute("codeType", codeType, request);
      storePaginationBeanToRequest(context, tuxPagination);
    } catch (ServiceException we) {
      processSevereException(context, we);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
  }

  private CodesTableDetailRetrieveSI populate_CodesTblDtlRetSI(GrndsExchangeContext context,
                                                               TuxedoPaginationValueBean tuxPagination)
                                                                                                       throws MarshalException,
                                                                                                       ValidationException,
                                                                                                       DataFormatException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCFIN19SI_RETRIEVE()");
    performanceTrace.enterScope();

    // define a new service object
    CodesTableDetailRetrieveSI codesTblDtlRetSI = new CodesTableDetailRetrieveSI();

    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());

    codesTblDtlRetSI.setArchInputStruct(input);

    // -- These are hidden inputs dynamically created by the ending impact:pagination tag on JSP.
    // -- They are given values by Java script called when clicking on the sort arrows generated via
    // -- the sortableColumnHeader tag.
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    if ("".equals(orderBy)) {
      orderBy = SORT_BY_CODE;
    }
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
    if ("".equals(sortDir)) {
      sortDir = ServiceConstants.SORT_ASCENDING;
    }
    // -- Set into input object and also into tuxPagination so that logic for determining sortDir
    // -- in SortableColumnTag works.
    codesTblDtlRetSI.setBWcdCdSortBy(orderBy);
    codesTblDtlRetSI.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return codesTblDtlRetSI;

  } // end populate_RETRIEVE_CodesTblDtlRetSI

  /**
   * displayCodeDetail Method <p/> This method is called by the GRNDS controller when the user clicks Edit button or Add
   * button on the Codes Table Detail page.
   * 
   * @param context
   *                Context for the request
   */
  public void displayCodeDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCodeDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String btnAdd = ContextHelper.getStringSafe(context, "btnAdd.x");
    String codeType = (String) state.getAttribute("codeType", request);
    String code = ContextHelper.getStringSafe(context, "hdnCode");
    CodesTableDetailRetrieveSI codesTblDtlRtrvSI = new CodesTableDetailRetrieveSI();
    codesTblDtlRtrvSI.setCodeType(codeType);
    codesTblDtlRtrvSI.setCode(code);
    // If add button is pressed the indicator is set to 'Y'
    // else it is set to empty.The Jsp will check the indicator
    // to display the page in add or modify mode
    if (StringHelper.isValid(btnAdd)) {
      codesTblDtlRtrvSI.setCdReqFunc(ServiceConstants.REQ_FUNC_CD_ADD);
      String indAdd = ArchitectureConstants.Y;
      state.setAttribute("indAdd", indAdd, request);
    } else {
      state.setAttribute("indAdd", "", request);
    }
    try {
      CodesTableDetailRetrieveSO codesTableDetailRetrieveSO = admin.retrieveCodeDetail(codesTblDtlRtrvSI);
      state.setAttribute("codesTableDetailRetrieveSO", codesTableDetailRetrieveSO, request);
    } catch (ServiceException we) {
      processSevereException(context, we);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * cancel Method <p/> This method is called by the GRNDS controller when the user clicks the Cancel button on the
   * Codes Table Detail pages.
   * 
   * @param context
   *                Context for the request
   */
  public void cancel_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".cancel()");
    performanceTrace.enterScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * saveCodeDetaill Method <p/> This method is called by the GRNDS controller when the user clicks the Save button on
   * the Code Detail page.
   * 
   * @param context
   *                Context for the request
   */
  public void saveCodeDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCodeDetail()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      CodeDetailSaveSI codeDetailSaveSI = populateCodeDetailSaveSI(context);
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      admin.saveCodeDetail(codeDetailSaveSI);
      setPresentationBranch("stay", context);
    } catch (ServiceException we) {
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      setPresentationBranch("error", context);
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
        break;
      case Messages.MSG_CODES_TABLE_CODE_EXISTS:
        setErrorMessage(Messages.MSG_CODES_TABLE_CODE_EXISTS, request);
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private CodeDetailSaveSI populateCodeDetailSaveSI(GrndsExchangeContext context) {
    CodeDetailSaveSI codeDetailSaveSI = new CodeDetailSaveSI();
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    String code = ContextHelper.getStringSafe(request, "txtCode");
    String indAdd = ContextHelper.getStringSafe(request, "hdnIndAdd");
    request.removeAttribute("hdnIndAdd");
    String cdReqFunc = ServiceConstants.REQ_FUNC_CD_UPDATE;
    if (ArchitectureConstants.Y.equals(indAdd)) {
      cdReqFunc = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    if ("".equals(code)) {
      code = ContextHelper.getStringSafe(request, "txtCode_Disabled");
    }
    codeDetailSaveSI.setCdReqFunc(cdReqFunc);
    codeDetailSaveSI.setCode(code);
    codeDetailSaveSI.setDecode(ContextHelper.getStringSafe(request, "txtDecode"));
    codeDetailSaveSI.setCodeType(ContextHelper.getStringSafe(request, "dspCodesTableName"));
    codeDetailSaveSI.setTransType(Lookup.simpleEncodeSafe(CodesTables.CCTUPDT,
                                                          ContextHelper.getStringSafe(request, "dspTransType")));
    codeDetailSaveSI.setDtEnd(ContextHelper.getJavaDateSafe(request, "dtEndDate"));
    codeDetailSaveSI.setDesc(ContextHelper.getStringSafe(request, "dspDescription"));
    codeDetailSaveSI.setIdEmployee(user.getUserID());
    return codeDetailSaveSI;
  }

}