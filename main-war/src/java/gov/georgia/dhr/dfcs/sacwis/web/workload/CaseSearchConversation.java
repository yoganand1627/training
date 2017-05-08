package gov.georgia.dhr.dfcs.sacwis.web.workload;

// -- java classes --

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Code1InStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CodeCounty_ARRAY_CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for cases from the Case Search page. It also provides validation for
 * city/county agreement of user input through a service call.
 *
 * @author Jonathan Hardy, January 6, 2003
 */
/*
 * Change History: 
 *  Date         User              Description 
 * --------   ----------         ------------------------------------------------------
 * 03/16/04   Todd Reser         SIR 22757 - Added informational message MSG_CLIST_CLICK_HYPERLINK to 
 *                               searchCase_xa. While I was in here, added changelog, fixed javadocs 
 *                               and PMD errors. 03/26/04 Todd Reser Moved informational message to
 *                               callSearchService and only display it if there are rows returned.
 * 
 * 08/18/05   casdorjm           SIR 22559 - Most of the sort logic was already in place in this 
 *                               conversation, really all i had to do was define the new STATIC 
 *                               constants and also make sure the tuxPagination was passed to all 
 *                               the methods that needed it.
 * 
 * 03/19/08   charden            STGAP00007581 - Changed the validatCityCcounty method and did an 
 *                               override of the callSearchService method so that the counties brought 
 *                               back by the DAO could be saved in order to do a search in the database 
 *                               for the counties related to the city passed in.  Search will now work 
 *                               if a city is the only search criteria passed in by the user.
 * 
 * 02/05/2010 Joel Cochran       SMS #43758 - Pulls variable indUseStageCode from the request and adds
 *                               the value to the CCMN20SI object to send to the RetriveCaseList service.
 */

@SuppressWarnings("serial")
public class CaseSearchConversation extends BaseHiddenFieldStateConversation {

  public static String PREVIOUS_URI_PARAM_NAME = "hdnPreviousURI";

  public static String PREVIOUS_URI_PERSON_DETAIL = "/person/PersonDetail/displayPersonDetail";

  public static String CASE_SUMMARY_CALLED = "/workload/CaseSummary/displayCaseSummary";

  private Admin admin;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * This method is called by the GRNDS controller when a user performs a Case Search. Validation of City/County
   * agreement should take place before this service call is made. See validateCityCounty_xa.
   *
   * @param context The GrndsExchangeContext object.
   */

  public void searchCase_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchCase_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    // Pagination
    int resultsPerPage = 10;
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(resultsPerPage);

    int pageRequested = tuxPagination.getResultDetails().getRequestedPage();

    String userID = UserProfileHelper.getUserProfile(request).getUserLogonID();

    int personID = 0;
    CCMN20SI ccmn20si;

    // If entering this conversation from the Person Details page, search on Person ID
    if (PREVIOUS_URI_PERSON_DETAIL.equals(ContextHelper.getStringSafe(context, PREVIOUS_URI_PARAM_NAME))) {
      personID = GlobalData.getUlIdPerson(request);
      request.setAttribute("SearchCasePersonID", personID);
      ccmn20si = populateSearchStruct(personID, pageRequested, tuxPagination, resultsPerPage, 0,
                                      StringHelper.EMPTY_STRING, 0, StringHelper.EMPTY_STRING, context);
      callSearchService(tuxPagination, context, ccmn20si);
      // From Person Detail, page mode set to INQUIRE. Currently ignored in JSP.
      request.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, PageModeConstants.INQUIRE);
    } else if (ContextHelper.getIntSafe(context, "txtUlIdPerson") != 0) {
      personID = ContextHelper.getIntSafe(context, "txtUlIdPerson");
      request.removeAttribute("SearchCasePersonID");
      ccmn20si = populateSearchStruct(personID, pageRequested, tuxPagination, resultsPerPage, 0,
                                      StringHelper.EMPTY_STRING, 0, StringHelper.EMPTY_STRING, context);
      callSearchService(tuxPagination, context, ccmn20si);
    } else {
      Map retMap = validateCityCounty(context, userID);
      boolean isValid = (Boolean) retMap.get("isValid");
      if (isValid) {
        // Fill in the structure for the search here
        // Allocate the structures

        // From Case Search, page mode set to EDIT. Currently ignored in JSP.
        request.setAttribute(PageMode.PAGE_MODE_ATTRIBUTE_NAME, PageModeConstants.EDIT);

        // Get search criteria input from user
        int ulIdCase = ContextHelper.getIntSafe(context, "txtUlIdCase");
        String szNmCase = ContextHelper.getStringSafe(context, "txtSzNmCase");
        int ulIdCaseManager = ContextHelper.getIntSafe(request, "txtUlIdCaseManager");

        String szNmCaseManagerFirst = ContextHelper.getStringSafe(context, "txtSzNmCaseManagerFirst");
        String szNmCaseManagerMiddle = StringHelper.EMPTY_STRING;
        String szNmCaseManagerLast = ContextHelper.getStringSafe(context, "txtSzNmCaseManagerLast");
        String szNmCaseManager = FormattingHelper.formatFullName(FormattingHelper.changeCase(szNmCaseManagerFirst),
                                                                 FormattingHelper.changeCase(szNmCaseManagerMiddle),
                                                                 FormattingHelper.changeCase(szNmCaseManagerLast));

        // Apply logic to determine which search parameters to use
        // If Case ID exists, use only that. If not, use Facility Name
        // (which is szNmCase). If that also doesn't exist, bring in
        // First, Middle, and Last names, concatenate as Last,First M
        // and send as szNmCase parameter.
        if (ulIdCase != 0) {
          // Use only Case ID, clear Name, Case Manager Name, Case Manager ID
          szNmCase = StringHelper.EMPTY_STRING;
          szNmCaseManager = StringHelper.EMPTY_STRING;
          ulIdCaseManager = 0;
        } else if (StringHelper.EMPTY_STRING.equals(szNmCase)) {
          // If no Case ID, use Facility Name from szNmCase.
          // But if Facility Name is blank, fill szNmCase with
          // Case Name info.
          String lastName = ContextHelper.getStringSafe(context, "txtSzNmCaseLast");
          String firstName = ContextHelper.getStringSafe(context, "txtSzNmCaseFirst");
          String middleName = ContextHelper.getStringSafe(context, "txtSzNmCaseMiddle");
          // SIR 19040 format the names with change case so that they will be formatted in a way
          // that the service can find them.
          szNmCase = FormattingHelper.formatFullName(FormattingHelper.changeCase(firstName),
                                                     FormattingHelper.changeCase(middleName),
                                                     FormattingHelper.changeCase(lastName));
        }
        if (ulIdCaseManager != 0) {
          szNmCase = StringHelper.EMPTY_STRING;
        }

        ccmn20si = populateSearchStruct(personID, pageRequested, tuxPagination, resultsPerPage, ulIdCase,
                                        szNmCase, ulIdCaseManager, szNmCaseManager, context);
        
        //Saves the counties brought back from validateCityCounty into a list
        List countiesList = (ArrayList) retMap.get("counties");
        callSearchService(tuxPagination, context, ccmn20si, countiesList);

      }
      // Log the performance trace info

      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
      return;
    }
  }

  protected CCMN20SI populateSearchStruct(int personID, int usPageNbr, TuxedoPaginationValueBean tuxPagination,
                                          int ulPageSizeNbr, int ulIdCase, String szNmCase, int ulIdCaseManager,
                                          String szNmCaseManager, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String strIndUseStageCode = (String)request.getAttribute("indUseStageCode");
    if (StringHelper.isEmptyOrNull(strIndUseStageCode)) {
      strIndUseStageCode = ContextHelper.getStringSafe(context, "indUseStageCode");
    }
    if (StringHelper.isNotEmptyOrNull(strIndUseStageCode)) {
      request.setAttribute("indUseStageCode", strIndUseStageCode);
    }
    CCMN20SI populatedCcmn20si = new CCMN20SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);
    input.setSzUserId(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());

    if (ArchitectureConstants.Y.equals(strIndUseStageCode)) {
      populatedCcmn20si.setIndUseStageCode(ArchitectureConstants.Y);
    }
    
    // The window code seems to create the UlIdPerson array regardless of whether
    // a personID has been specified as part of the search criteria. Create it
    // here, fill it with the personID (which is 0 if not entered by the user),
    // then add a second element for the user ID.
    UlIdPerson_ARRAY_CCMN20SI a = new UlIdPerson_ARRAY_CCMN20SI();
    a.addUlIdPerson(personID);
    a.addUlIdPerson(UserProfileHelper.getUserProfile(context.getRequest()).getUserID());
    populatedCcmn20si.setUlIdPerson_ARRAY_CCMN20SI(a);

    populatedCcmn20si.setArchInputStruct(input);
    populatedCcmn20si.setUlIdCase(ulIdCase);
    populatedCcmn20si.setSzNmCase(szNmCase);
    populatedCcmn20si.setUlIdCaseManager(ContextHelper.getIntSafe(context, "txtUlIdCaseManager"));
    populatedCcmn20si.setSzNmCaseManager(szNmCaseManager);
    populatedCcmn20si.setSzCdCaseCounty(ContextHelper.getStringSafe(context, "selSzCdCaseCounty"));
    populatedCcmn20si.setSzCdCaseRegion(ContextHelper.getStringSafe(context, "selSzCdCaseRegion"));
    populatedCcmn20si.setSzAddrMailCodeCity(ContextHelper.getStringSafe(context, "txtSzAddrCity"));
    populatedCcmn20si.setSzCdStage(ContextHelper.getStringSafe(context, "selSzCdStage"));
    populatedCcmn20si.setSzNbrUnit(ContextHelper.getStringSafe(context, "txtSzNbrUnit"));
    populatedCcmn20si.setDtDtLastUpdate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context,
                                                                                                "txtDtDtLastUpdate")));
    populatedCcmn20si.setSelRbOpenClose(ContextHelper.getStringSafe(context, "selRbOpenClose"));
    populatedCcmn20si.setSzCdCpsInvstDtlOvrllDisptn(ContextHelper.getStringSafe(context,
                                                                                "selSzCdCpsInvstDtlOvrllDisptn"));
    //String sortOrder;
    //if (tuxPagination.getResultDetails().getOrderBy() != null) {
    //  sortOrder = tuxPagination.getResultDetails().getOrderBy();
    //} else {
    //  sortOrder = SORT_BY_CASE_NAME;
    //}
    //populatedCcmn20si.setBWcdCdSortBy(tuxPagination.getResultDetails().getOrderBy());
    //populatedCcmn20si.setBWcdCdSortBy(sortOrder);
    
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    //-- following line only necessary because the service calls Integer.parseInt using this value
    //-- particular number represented is irrelevant since dao uses its own default ordering
    orderBy = "".equals(orderBy) ? SORT_BY_CASE_NAME : orderBy;
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
    populatedCcmn20si.setBWcdCdSortBy(orderBy);
    populatedCcmn20si.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);
    return populatedCcmn20si;
  }

  protected void callSearchService(TuxedoPaginationValueBean tuxPagination, GrndsExchangeContext context,
                                   CCMN20SI ccmn20si) {
    HttpServletRequest request = context.getRequest();
    // SIR 22757 - Added noRows
    boolean noRows = false;
    try {
      // CCMN20SO ccmn20so = CCMN20SO.unmarshal(new StringReader(WtcHelper.callService("CCMN20S", ccmn20si)));
      CCMN20SO ccmn20so = admin.findCaseListInformation(ccmn20si);
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn20so.getBMoreDataInd());
      ccmn20so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccmn20so.getArchOutputStruct(),
                                             ccmn20so.getROWCCMN13DO_ARRAY().getROWCCMN13DOCount());
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

      // Put the output object into the request.
      request.setAttribute("CCMN20SO", ccmn20so);
      this.setPresentationBranch("CASE_LIST", context);
    } catch (ServiceException se) {
      switch (se.getErrorCode()) {
        case(Messages.MSG_NO_ROWS_RETURNED): {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_ROWS_RETURNED);
          // SIR 22757 - If we threw and error set noRows true
          noRows = true;
          setInformationalMessage(errorMessage, "/workload/CaseSearch/searchCase", request);
          break;
        }
        // SIR 18300 this message will now be thrown by the service.
        case(Messages.MSG_TOO_MANY_ROWS_RETURNED): {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_TOO_MANY_ROWS_RETURNED);
          setInformationalMessage(errorMessage, "/workload/CaseSearch/searchCase", request);
          break;
        }

        default: {
          super.processSevereException(context, se);
        }
      }
    } catch (Exception e) {
      super.processSevereException(context, e);
    }
    if (!noRows) {
      // SIR 22757 - Added informational message MSG_CLIST_CLICK_HYPERLINK
      setInformationalMessage(Messages.MSG_CLIST_CLICK_HYPERLINK, request);
    }
  }

  //new method that overrides the old callSearchService method
  protected void callSearchService(TuxedoPaginationValueBean tuxPagination, GrndsExchangeContext context,
                                   CCMN20SI ccmn20si, List countiesList) {
    HttpServletRequest request = context.getRequest();
    // SIR 22757 - Added noRows
    boolean noRows = false;
    try {
      // CCMN20SO ccmn20so = CCMN20SO.unmarshal(new StringReader(WtcHelper.callService("CCMN20S", ccmn20si)));
      
      //iterates through and performs search based on the counties passed in by the validateCityCounty method
      if(countiesList != null && countiesList.size() > 0){
        CodeCounty_ARRAY_CCMN20SI codeCounty_ARRAY_CCMN20SI = new CodeCounty_ARRAY_CCMN20SI();
        Iterator countiesList_it = countiesList.iterator();
        while (countiesList_it.hasNext()){
          String codeCounty = new String();
          codeCounty = (String) countiesList_it.next();
          codeCounty_ARRAY_CCMN20SI.addSzCdCaseCounty(codeCounty);
        }
       ccmn20si.setCodeCounty_ARRAY_CCMN20SI(codeCounty_ARRAY_CCMN20SI);
      }
      
      //performs search based on the county passed in by the user
      CCMN20SO ccmn20so = admin.findCaseListInformation(ccmn20si);
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn20so.getBMoreDataInd());
      ccmn20so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccmn20so.getArchOutputStruct(),
                                             ccmn20so.getROWCCMN13DO_ARRAY().getROWCCMN13DOCount());
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

      // Put the output object into the request.
      request.setAttribute("CCMN20SO", ccmn20so);
      this.setPresentationBranch("CASE_LIST", context);
    } catch (ServiceException se) {
      switch (se.getErrorCode()) {
        case(Messages.MSG_NO_ROWS_RETURNED): {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_ROWS_RETURNED);
          // SIR 22757 - If we threw and error set noRows true
          noRows = true;
          setInformationalMessage(errorMessage, "/workload/CaseSearch/searchCase", request);
          break;
        }
        // SIR 18300 this message will now be thrown by the service.
        case(Messages.MSG_TOO_MANY_ROWS_RETURNED): {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_TOO_MANY_ROWS_RETURNED);
          setInformationalMessage(errorMessage, "/workload/CaseSearch/searchCase", request);
          break;
        }

        default: {
          super.processSevereException(context, se);
        }
      }
    } catch (Exception e) {
      super.processSevereException(context, e);
    }
    if (!noRows) {
      // SIR 22757 - Added informational message MSG_CLIST_CLICK_HYPERLINK
      setInformationalMessage(Messages.MSG_CLIST_CLICK_HYPERLINK, request);
    }
  }

  /**
   * This method is called by the searchCase method to validate City/County agreement when a user performs a Case
   * Search. If validation fails, the user is returned to the search page and no search service call is made. The user
   * is presented with an error message indicating the source of the problem.
   *
   * @param context The GrndsExchangeContext object.
   * @param userID  String
   * @return isValide boolean
   */

  protected Map validateCityCounty(GrndsExchangeContext context, String userID) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateCityCounty()");
    performanceTrace.enterScope();

    // Allocate the structures
    Code1InStruct code1instruct = new Code1InStruct();
    ArchInputStruct input = new ArchInputStruct();
    CCMN87SI ccmn87si = new CCMN87SI();

    boolean isValid = true;
    String strCity = StringHelper.EMPTY_STRING;
    String strCounty = StringHelper.EMPTY_STRING;

    // Get City/County values from user input
    strCity = ContextHelper.getStringSafe(context, "txtSzAddrCity");
    strCounty = ContextHelper.getStringSafe(context, "selSzCdCaseCounty");
    
    
    Map retMap = new HashMap();
    //if there is a city passed in but no county or if there is a city and a county passed in by user
    if ((!StringHelper.EMPTY_STRING.equals(strCity) && StringHelper.EMPTY_STRING.equals(strCounty)) ||
                    (!StringHelper.EMPTY_STRING.equals(strCity) && !StringHelper.EMPTY_STRING.equals(strCounty))) {
      // Set the values for the ArchInputStruct
      input.setCReqFuncCd(" ");
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(10);
      // Get user logon id to set in input data structure
      input.setSzUserId(userID);

      code1instruct.setSzAddrPersAddrStLn1(StringHelper.EMPTY_STRING);
      code1instruct.setSzAddrPersAddrStLn2(StringHelper.EMPTY_STRING);
      code1instruct.setSzAddrCity(strCity);
      code1instruct.setSzCdAddrState(StringHelper.EMPTY_STRING);
      code1instruct.setLAddrZip(StringHelper.EMPTY_STRING);
      code1instruct.setSzCdAddrCounty(StringHelper.EMPTY_STRING);

      ccmn87si.setArchInputStruct(input);
      ccmn87si.setCode1InStruct(code1instruct);

      // If a city and county were both entered, we set isValid = false until
      // we find out whether they match or not.
      isValid = false;
      

      try {

        // call the Tuxedo service using the WtcHelper object
        // CCMN87SO ccmn87so = CCMN87SO.unmarshal(new StringReader(WtcHelper.callService("CCMN87S", ccmn87si)));
        CCMN87SO ccmn87so = admin.findCountiesLinkedToCity(ccmn87si);
        Code1OutStruct_ARRAY code1osarray = ccmn87so.getCode1OutStruct_ARRAY();

        // If there are counties returned for the city name, the city/county
        // agreement may fail, so isValid is false until a match is found.
        // Then cycle through the returned county codes and if no county was passed in
        // by the user, save the counties from the search and set isValid to true.  
        // Else, compare to the countyselected by the user. If a match is found, set 
        // isValid to true and exit the loop.
        //
        // If there are NO counties returned for the city name, the city/county
        // agreement automatically fails, so just keep isValid false.
        List countiesList = new ArrayList();
        if (code1osarray.getUlRowQty() > 0) {
          Enumeration rows = code1osarray.enumerateCode1OutStruct();
          isValid = false;
          while (rows.hasMoreElements()) {
            Code1OutStruct outStruct = (Code1OutStruct) rows.nextElement();
            String countyCode = outStruct.getSzSysCode1CntyCode();
            if ((!StringHelper.isValid(strCounty)) && outStruct != null){
              countiesList.add(outStruct.getSzSysCode1CntyCode());
              isValid = true;
            } else if (strCounty.equals(countyCode)) {
              isValid = true;
              break;
            }
          }
          //saves list of counties in a map to be returned with isValid
          retMap.put("counties", countiesList);
        }
      } catch (ServiceException se) {
        GrndsTrace.msg(TRACE_TAG + "." + "validateCityCounty", 7, se.getErrorMessage());
        processSevereException(context, se);
      } catch (Exception e) {
        processSevereException(context, e);
      }
     }
    //} // End if for !StringHelper.EMPTY_STRING.equals(strCity)

    if (!isValid) {
      // Navigation has changed, and the search page (formerly error branch) is the default page
      // this.setPresentationBranch( "error", context );
      String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_CITY);
      setErrorMessage(errorMessage, "/workload/CaseSearch/searchCase", context.getRequest());
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    retMap.put("isValid", isValid);
    return retMap;
  }

  public void displayCaseSummary_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCaseDetails_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    int ulIdCase = ContextHelper.getIntSafe(context, "hdnUlIdCase");

    // If ulIdCase has been received correctly, send to case summary page
    if (ulIdCase != 0) {
      GlobalData.setUlIdCase(ulIdCase, request);
      // SIR 19528 - Navigating through person Case List maintains previously
      // displayed Stage's info. Clear Stage ID and Stage Code from GlobalData.
      GlobalData.setUlIdStage(0, request);
      GlobalData.setSzCdStage(StringHelper.EMPTY_STRING, request);

      // Add further information from page to GlobalData
      GlobalData.setSzCdStageProgram(ContextHelper.getStringSafe(context, "hdnSzCdCaseProgram"), request);
      GlobalData.setSzNmCase(ContextHelper.getStringSafe(context, "hdnSzNmCase"), request);

      try {
        forward(this.CASE_SUMMARY_CALLED, request, context.getResponse());
      } catch (ServletException se) {
        processSevereException(context, se);
      } catch (Exception e) {
        processSevereException(context, e);
      }
    }
    // If not, some sort of error
    else {
      processSevereException(
              context,
              new Exception("DEBUG:CaseSearchConversation -- Can't send to Case Summary without Case ID"));
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  // static constants
  public static final String TRACE_TAG = "CaseSearchConversation";

  // As per GA Modifications case list is soretd only on Case Manager and Date Case closed or opened.
  /*public static final String SORT_BY_PROGRAM = "1";

  public static final String SORT_BY_UTC = "2";

  public static final String SORT_BY_STATUS = "3";

  public static final String SORT_BY_CASE_NAME = "4";

  public static final String SORT_BY_COUNTY = "5";*/

  public static final String SORT_BY_CASE_MANAGER = "1";

  public static final String SORT_BY_DATE = "2";

  public static final String SORT_BY_STAGE = "3";

  public static final String SORT_BY_CASE_NAME = "4";

}
