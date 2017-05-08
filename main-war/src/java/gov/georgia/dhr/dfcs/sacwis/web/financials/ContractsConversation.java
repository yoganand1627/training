package gov.georgia.dhr.dfcs.sacwis.web.financials;

//import java.io.StringReader;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cconpay;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BatchContractServiceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON06SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON06SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON08SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON10SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON10SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON12SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON14SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveProgramCodeServicesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BatchContractServiceSI.BatchContractServiceRow;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveProgramCodeServicesSO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to view, create, maintain, and delete contracts.
 *
 * @author Paul Lang, February 01, 2003
 */
/*
 * Change History: Date User Description -------- ---------- -------------------------------------------------- 05/13/03
 * GRIMSHAN SIR #17245 In populate ccon08, check to see if the checkbox is available from the request. If it is, use
 * that value, otherwise use the hidden field value. 05/16/03 GRIMSHAN SIR 17253 -- Set the current action into the
 * request for displaying the contract version detail. This is done so that the page will know what action the user is
 * currently trying to perform. 05/28/03 GRIMSHAN SIR 17595 -- Set indicator to Y in populate CCON06 so that the Period
 * effective date will always match the Version start date 06/09/03 Todd Reser SIR 18077 -- Had to clear the CCON07SO
 * object from state upon pressing the Delete button so the Detail Page would not erroneously display a deleted
 * Version's information. 06/15/03 Eric Dickman SIR 17911 -- The variables being set in the
 * saveContractCostRmbrsmntDetailOrUnitRate_xa were not correct. 06/16/03 Eric Dickman SIR 18190 -- The Cost Reimb page
 * will now save the values from the Contract Service list not zero. 06/23/03 Eric Dickman SIR 18427--Added logic to the
 * rowccon11sog00Array, to verify the Array was not equal to zero. 06/25/03 GRIMSHAN SIR 18509 -- Set an indicator to
 * let the contract header know if the resource has been validated. 06/26/03 Eric Dickman SIR 18544 -- Added one (+1) to
 * the CSLI. 06/27/03 GRIMSHAN SIR 18533 -- Changed the way Early term date is saved in populate CCON06SI 07/12/03 Eric
 * Dickman SIR 18739 -- When a user clicks on the 3rd level tab of Contracts, the Contract header page will now load
 * with the period selected. I removed the Period attribute from the request to state. 09/11/03 Eric Dickman Sir 19670 --
 * The setBSysIndVersionLockMod should be set to "N" not "Y". Previous version should have already been locked. 11/10/03
 * Todd Reser SIR 22413 - Changed UlPageSizeNumber of CCON05 from 15 to 50 so it will display more than 15 Contract
 * Periods. 11/12/03 Todd Reser Updated Javadocs and comments. 11/10/03 CORLEYAN SIR 22527 - Changed UlPageSizeNumber of
 * CCON05 and CCON07 to 99 since that is what CAPS did. 04/20/04 CORLEYAN SIR 22577 - Changed ccon08s populate to set
 * the value of budget limit to the hdnContractBudgetLimit from the version detail page. 01/03/05 OCHUMD SIR 23303 -
 * changed UlPageSizeNbr of CCON11S from 50 to 100 so that contract service list can display up to 100 service lines.
 * 02/18/05 CORLEYAN SIR 23111 - Set version closure date using early term into request for all closed contracts
 * 05/09/05 NALLAVS SIR 23547 - Removed Console Output Statements. 06/13/05 Ochumd Sir#23430 - Added a legal identifier
 * field for contracts. NbrLegalIdentifier is now part of the save process.
 *
 * 06/30/2008 arege  Per STGAP00008089   Resolved the defect where Contracts are being generated with duplicated CSLI. 
 *                                       Added case Messages.MSG_CSLI_EXISTS: in the saveContractServiceDetail_xa method
 *                                       This displays the Error message when a Service exception is thrown in the SaveContractListImpl.java
 *
 * 09/11/2011 charden   STGAP00017058    added code in displayContractPeriod_xa() and displayContractVersion_xa() method 
 *                                       to check for most recent period and to check for fiscal security class to set edit plus mode
 */
@SuppressWarnings("serial")
public class ContractsConversation extends BaseHiddenFieldStateConversation {

  public static final String VERSION_NOT_LOCKED = "MOST_RECENT_PERIOD_VERSION_NOT_LOCKED";
  public static final String FISC_OPS_MAINT = "FISC_OPS_MAINT";
  private static final String BATCH_SAVE_COMPLETE = "batchSaveComplete";
  private static final String UNIT_RATE_REQ = "Unit Rate is required when chosen as the Payment Type";

  private Financials financials;
  private Common common;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }

  /**
   * display Contract Search Activity Method <p/> This activity method performs the display for the Contract ServiceList
   * .jsp
   *
   * @param context
   *          Context for the request
   */

  public void displayContractServiceList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayContractServiceList_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CCON11SI ccon11si = populateCCON11SI_List(context);
      // CCON11SO ccon11so = (CCON11SO)WtcHelper.callService("CCON11S", ccon11si, CCON11SO.class);
      CCON11SO ccon11so = financials.findContractService(ccon11si);

      // STGAP00017058
      UserProfile user = UserProfileHelper.getUserProfile(request);
      if(common.hasSecurityClass(user.getUserID(), FISC_OPS_MAINT)){
        // set page mode to edit and add attribute to state to signify that we are in edit plus mode
        //PageMode.setPageMode(PageModeConstants.EDIT, request);
        state.setAttribute("editPlus", true, request);
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
      state.setAttribute("CCON11SO", ccon11so, request);
      
      int idResouce = ContextHelper.getIntSafe(request, "txtUlIdResource");
      if(idResouce != 0){
        GlobalData.setUlIdResource(idResouce, request);
      }
      // End STGAP00017058
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      case Messages.SQL_NOT_FOUND:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;
      case Messages.MSG_CON_NO_SVC_CODE:
      case Messages.MSG_NO_SVC_DECODE:
        setErrorMessage(errorCode, "/financials/Contracts/displayContractServiceList", request);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  /**
   * This method is called to populate the input object when thew user opens the Contract Service List page in order for
   * the list box to be populated.
   *
   * @param context
   *          Context for the request
   * @return ccon11si
   */

  private CCON11SI populateCCON11SI_List(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCCON11SI_List()");

    HttpServletRequest request = context.getRequest();

    CCON11SI ccon11si = new CCON11SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(100);
    input.setSzUserId(user.getUserLogonID());
    ccon11si.setArchInputStruct(input);

    // Fields that are passed in from the request on the Contract Version List
    // page CCON05W set ccon11si input parameters
    int contractId = GlobalData.getUlIdContract(request);
    ccon11si.setUlIdContract(contractId);

    int resourceId = ContextHelper.getIntSafe(request, "txtUlIdResource");

    if (resourceId == 0) {
      resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");
    }

    ccon11si.setUlIdResource(resourceId);

    int period = GlobalData.getUlNbrCnperPeriod(request);
    ccon11si.setUlNbrCnperPeriod(period);

    int version = ContextHelper.getIntSafe(request, "hdnContractVersion");
    if (version == 0) {
      version = GlobalData.getUlNbrCnverVersion(request);
    }
    ccon11si.setUlNbrCnverVersion(version);
    GlobalData.setUlNbrCnverVersion(version, request);

    ccon11si.setUlPageSizeNbr(300);

    performanceTrace.exitScope();

    return ccon11si;
  }

  /**
   * This method populates the input object in order for a list of counties available for a given service to be
   * returned.
   *
   * @param context
   *          The GrndsExchangeContext object.
   * @param serviceType
   *          String
   * @param CSLI
   *          int
   * @return ccon13si
   */
  private CCON13SI populateCCON13SI_List(GrndsExchangeContext context, String serviceType, int CSLI) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCCON13SI_List()");

    HttpServletRequest request = context.getRequest();

    CCON13SI ccon13si = new CCON13SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(260);
    ccon13si.setArchInputStruct(input);

    int contractId = GlobalData.getUlIdContract(request);
    ccon13si.setUlIdContract(contractId);

    int period = GlobalData.getUlNbrCnperPeriod(request);
    ccon13si.setUlNbrCncntyPeriod(period);

    int version = GlobalData.getUlNbrCnverVersion(request);
    ccon13si.setUlNbrCncntyVersion(version);

    int resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");
    ccon13si.setUlIdResource(resourceId);

    org.exolab.castor.types.Date countyEffective = DateHelper
                                                             .toCastorDateSafe(ContextHelper
                                                                                            .getStringSafe(request,
                                                                                                           "hdndtDtCncntyEffective"));
    ccon13si.setDtDtCncntyEffective(countyEffective);

    org.exolab.castor.types.Date countyEnd = DateHelper
                                                       .toCastorDateSafe(ContextHelper
                                                                                      .getStringSafe(request,
                                                                                                     "hdndtDtCncntyEnd"));
    ccon13si.setDtDtCncntyEnd(countyEnd);

    ccon13si.setUlNbrCncntyLineItem(CSLI);
    ccon13si.setSzCdRsrcSvcService(serviceType);

    performanceTrace.exitScope();

    return ccon13si;
  }

  /**
   * This method is used to display the Contract Cost Reiumbursement Detail page.
   *
   * @param context
   *          Context for the request
   */
  public void displayContractCostRmbrsmntDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    ".displayContractCostRmbrsmntDetail_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      int index = 0;
      // get the line item number from the hidden field of hdnulNbrCnsvcLineItem

      // set the index equal to the array. the line item number starts at one
      // and the array begins at zero
      index = ContextHelper.getIntSafe(context, "hdnulNbrCnsvcLineItem");

      CCON11SO ccon11so = (CCON11SO) state.getAttribute("CCON11SO", request);
      ROWCCON11SOG00_ARRAY rowccon11sog00Array = ccon11so.getROWCCON11SOG00_ARRAY();
      // get the individual row out of the array
      ROWCCON11SOG00 rowccon11sog00 = rowccon11sog00Array.getROWCCON11SOG00(index);
      request.setAttribute("rowccon11sog00", rowccon11sog00);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method saves the contract Cost reimbursement page. It calles the populteCCON12SI_SAVE...Method.
   *
   * @param context
   *          Context for the request
   */
  public void saveContractCostRmbrsmntDetailOrUnitRate_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveContractCostRmbrsmntDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      CCON12SI ccon12si = populateCCON12SI_SAVE_COST_REMBRSMENT_DETAIL_OR_UNIT_RATE(context);
      // call tuxedo service to save the cost reimbursement or unit rate page
      // WtcHelper.callService("CCON12S", ccon12si);
      financials.saveContractList(ccon12si);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;

      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, "/financials/Contracts/displayCostRmbrsmentOrUnitRate",
                        request);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  
  // Begin STGAP00017058
  /**
   * This method displays the ContractServicesDetailAdd.jsp page
   * @param context
   */
  public void displayContractServiceDetailAdd_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayContractServiceDetailAdd_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    try{
      RetrieveProgramCodeServicesSI retrieveProgramCodeServicesSI = new RetrieveProgramCodeServicesSI();
      retrieveProgramCodeServicesSI.setIdResource(GlobalData.getUlIdResource(request));
      RetrieveProgramCodeServicesSO retrieveProgramCodeServicesSO = financials.retrieveProgramCodeServices(retrieveProgramCodeServicesSI);
      state.setAttribute("retrieveProgramCodeServicesSO", retrieveProgramCodeServicesSO, request);
    }catch(Exception e){
      e.printStackTrace();
    }
    performanceTrace.exitScope();
  }
  
  
  public void getProgramCodeCounties_xa(GrndsExchangeContext context){
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "getProgramCodeCounties_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try{
      // get parameters for service
      boolean isProgCodeSelect = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "progCodeSelect"));
      boolean isServiceSelect = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "serviceSelect"));
      boolean isServiceSaveAndContinue = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "serviceSaveContinue"));
      boolean isServiceSave = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "serviceSave"));
      
      if(isServiceSelect){
        String szCdRsrcSvcCategRsrc = ContextHelper.getStringSafe(request, "progCode");
        int idResource = ContextHelper.getIntSafe(request, "idResource");
        
        // get the contract counties
        CCON13SI ccon13si = new CCON13SI();
        ccon13si.setUlIdResource(GlobalData.getUlIdResource(request));
        ccon13si.setIndAllCounties(ArchitectureConstants.Y);
        ccon13si.setSzCdRsrcSvcCategRsrc(szCdRsrcSvcCategRsrc);
        CCON13SO ccon13so = financials.retrieveCounties(ccon13si);
        
        state.setAttribute("CCON13SO", ccon13so, request);
        request.setAttribute("progCode", szCdRsrcSvcCategRsrc);
      }
    }catch(Exception e){
      
    }
  }
  
  
  public void getBackgroundData_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "getBackgroundData_xa()");
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    String programCode = ContextHelper.getStringSafe(request, "szProgCode");
    
    request.setAttribute("programCode", programCode);
  }
  
  public void setServices_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setServices_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    try{
      String programCode = ContextHelper.getStringSafe(request, "szProgCode");
      int idResource = GlobalData.getUlIdResource(request);
      
      // get the contract counties
      CCON13SI ccon13si = new CCON13SI();
      ccon13si.setUlIdResource(idResource);
      ccon13si.setIndAllCounties(ArchitectureConstants.Y);
      ccon13si.setSzCdRsrcSvcCategRsrc(programCode);
      CCON13SO ccon13so = financials.retrieveCounties(ccon13si);
      
      state.setAttribute("CCON13SO", ccon13so, request);
      request.setAttribute("programCode", programCode);
      
      // setup service pagination
      String[] checkedValues = (String[]) state.getAttribute("checkedValues", request);
      List<String> paginateList = new ArrayList<String>();
      Arrays.sort(checkedValues);
      
      if(checkedValues.length > 10){
        // cache service codes for pagination
        for(int i = 10; i < checkedValues.length; i++){
          paginateList.add(checkedValues[i]);
        }
        state.setAttribute("paginateList", paginateList, request);
        request.setAttribute("isPaginated", "Y");
        String[] page = { checkedValues[0], checkedValues[1], checkedValues[2], checkedValues[3], checkedValues[4],
                         checkedValues[5], checkedValues[6], checkedValues[7], checkedValues[8], checkedValues[9] };
        request.setAttribute("checkedValues", page);
      } else {
        request.setAttribute("checkedValues", checkedValues);
      }
      state.removeAttribute("checkedValues", request);
    }catch(Exception e){
      e.printStackTrace();
    }
    
    performanceTrace.exitScope();
  }
  
  
  /**
   * This method fills asynchronous requests from ContractServicesDetailAdd.jsp
   * @param context
   */
  @SuppressWarnings("unchecked")
  public void saveContractServiceBatch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "getBackgroundData_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

      try {
        String programCode = ContextHelper.getStringSafe(request, "szProgCode");
        if("".equals(programCode)){
          // when save and continue has been selected, the program code dropdown is removed from the page
          // so instead get the program code from the hidden variable
          programCode = ContextHelper.getStringSafe(request, "hdnProgCode");
        }
        
        request.setAttribute("programCode", programCode);
        boolean isSaveAndContinue = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(context, "continue"));
        
        //populate the input object
        BatchContractServiceSI batchContractServiceSI = populateBatchContractService(request);
        financials.saveBatchContractServiceRows(batchContractServiceSI);
        
        // if the save and continue button was clicked, it means that there 
        // are more services cached so perform pagination
        if(isSaveAndContinue){
          List<String> paginateList = (List<String>) state.getAttribute("paginateList", request);
          List<String> newPaginateList = new ArrayList<String>();
          if(paginateList != null && paginateList.size() > 10){
            for(int i = 10; i < paginateList.size(); i++){
              newPaginateList.add(paginateList.get(i));
            }
            state.setAttribute("paginateList", newPaginateList, request);
            request.setAttribute("isPaginated", "Y");
            String[] page = { paginateList.get(0), paginateList.get(1), paginateList.get(2), paginateList.get(3), paginateList.get(4),
                              paginateList.get(5), paginateList.get(6), paginateList.get(7), paginateList.get(8), paginateList.get(9) };
             request.setAttribute("checkedValues", page);
          }else{
            request.setAttribute("checkedValues", paginateList.toArray());
          }
        }else{
          super.setPresentationBranch(BATCH_SAVE_COMPLETE, context);
        }
      } catch (ServiceException we) {
        int errorCode = we.getErrorCode();
        switch (errorCode) {
        case Messages.MSG_NO_EQUIV_CONTRACT:
        case Messages.MSG_DUPLICATE_RECORD:
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.MSG_CON_NO_COUNTY:
        case Messages.MSG_CSLI_EXISTS:
          super.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage(errorCode, request);
          break;
        case Messages.MSG_CON_SVC_UNIT:
          super.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage("Unit Rate is " + MessageLookup.getMessageByNumber(Messages.MSG_CON_SVC_UNIT), request);
          break;
        case Messages.MSG_CRS_RFME_NBR:
          super.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage("Unit Type - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED), request);
          break;
        case Messages.SSM_COMPLETE_REQUIRED:
          super.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage("Payment Type - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED), request);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
        }
      }

      catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }

      
      performanceTrace.exitScope();
  }
  
  
  
  private BatchContractServiceSI populateBatchContractService(HttpServletRequest request){
    List<BatchContractServiceRow> batchContractServiceRowList = new ArrayList<BatchContractServiceRow>();
    BatchContractServiceSI batchContractServiceSI = new BatchContractServiceSI();
    BaseSessionStateManager state = getSessionStateManager(request);
    //CCON11SO ccon11so = (CCON11SO) state.getAttribute("CCON11SO", request);
    int numRows = ContextHelper.getIntSafe(request, "numRows");
    UserProfile user = UserProfileHelper.getUserProfile(request);
    ArchInputStruct input = new ArchInputStruct();
    org.exolab.castor.types.Date countyEffective = ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEffective");
    org.exolab.castor.types.Date countyEnd = ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEnd");
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(0);
    input.setUlPageSizeNbr(1);
    
    Map<String, String> cbxCheckedMap = new HashMap<String, String>();
    String [] checkedValues = CheckboxHelper.getCheckedValues(request.getParameterMap(), "cbxBatchProgCodeService");
    if(checkedValues != null){
      for(String str : checkedValues){
        cbxCheckedMap.put(str, str);
      }
    }
    for(int i = 0; i < numRows; i++){
      String serviceCode = ContextHelper.getStringSafe(request, "cbxBatchProgCodeService" + i);
      if(cbxCheckedMap.containsKey(serviceCode)){
        // pull parameters in row
        BatchContractServiceRow batchContractServiceRow = batchContractServiceSI.getBatchContractServiceRow();
        batchContractServiceRow.setFederalMatch(ContextHelper.getIntSafe(request, "ulNbrCnsvcFedMatch" + i));
        batchContractServiceRow.setLocalMatch(ContextHelper.getIntSafe(request, "ulNbrCnsvcLocalMatch" + i));
        batchContractServiceRow.setPaymentType(ContextHelper.getStringSafe(request, "szNbrCnsvcPaymentType" + i));
        batchContractServiceRow.setServiceCode(serviceCode);
        batchContractServiceRow.setUnitRate(ContextHelper.getMoneyAsDoubleSafe(request, "ulNbrCnsvcUnitRate" + i));
        batchContractServiceRow.setUnitType(ContextHelper.getStringSafe(request, "szNbrCnsvcUnitType" + i));
        
        // check for errors
        if ((Cconpay.CCONPAY_URT.equals(batchContractServiceRow.getPaymentType()) ||
                        Cconpay.CCONPAY_VUR.equals(batchContractServiceRow.getPaymentType())) &&
                        batchContractServiceRow.getUnitRate() < 0.01) {
          throw new ServiceException(Messages.MSG_CON_SVC_UNIT);
        }
        
        if("".equals(batchContractServiceRow.getPaymentType())){
          throw new ServiceException(Messages.SSM_COMPLETE_REQUIRED);
        }
        if("".equals(batchContractServiceRow.getUnitType())){
          throw new ServiceException(Messages.MSG_CRS_RFME_NBR);
        }
        
        // set row into list
        batchContractServiceRowList.add(batchContractServiceRow);
      }
    }
    
      
    // set data into SI object
    batchContractServiceSI.setBatchContractServiceRowList(batchContractServiceRowList);
    batchContractServiceSI.setInput(input);
    batchContractServiceSI.setUserId(user.getUserID());
    batchContractServiceSI.setIdContract(GlobalData.getUlIdContract(request));
    batchContractServiceSI.setUlNbrContractPeriod(GlobalData.getUlNbrCnperPeriod(request));
    batchContractServiceSI.setUlNbrContractVersion(GlobalData.getUlNbrCnverVersion(request));
    batchContractServiceSI.setContractFunctionType(ContextHelper.getStringSafe(request, "hdnContractFunctionType"));
    batchContractServiceSI.setCountyEffective(DateHelper.isValidDate(countyEffective) ? DateHelper.toJavaDate(countyEffective) : null);
    batchContractServiceSI.setCountyEnd(DateHelper.isValidDate(countyEnd) ? DateHelper.toJavaDate(countyEnd) : null);
    batchContractServiceSI.setIdResource(GlobalData.getUlIdResource(request));
    
    return batchContractServiceSI;
  }
//End STGAP00017058
  
  
  /**
   * This method is used to redisplay the Contract Service Detail page when the user selects a different service in the
   * Service dropdown. It reloads the page with a new county list based on the selected Service.
   *
   * @param context
   *          Context for the request
   */
  public void redisplayContractServiceDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "redisplayContractServiceDetail_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      String serviceType = ContextHelper.getStringSafe(request, "szNbrCnsvcService");
      request.setAttribute("szCdScrDataAction", ContextHelper.getStringSafe(request, "hdnszCdScrDataAction"));

      // SIR 17192 -- If the user has changed the service on the page, we want
      // to display county list regardless of whether or not there are counties
      // to be displayed.
      request.setAttribute("countyList", "Y");

      // set any selected widgets to the request, after redisplay those widgets
      // will re-display back to the page
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      // get the index of the line item from that will be displayed
      int CSLI = ContextHelper.getIntSafe(context, "dspUlNbrCnsvcLineItem");
      request.setAttribute("csliAdd", CSLI);

      CCON13SI ccon13si = populateCCON13SI_List(context, serviceType, CSLI);
      // CCON13SO ccon13so = CCON13SO.unmarshal(new StringReader(WtcHelper.callService("CCON13S", ccon13si)));
      CCON13SO ccon13so = financials.retrieveCounties(ccon13si);
      sortCounties(ccon13so);
      state.setAttribute("CCON13SO", ccon13so, request);
    }

    catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CON_NO_COUNTY:
        // Do not set error message, this is not really a error, it is just
        // displayed in the list box
        state.removeAttribute("CCON13SO", request);
        break;

      case Messages.MSG_CON_NO_SVC_CODE:
      case Messages.MSG_NO_SVC_DECODE:
        setErrorMessage(errorCode, "/financials/Contracts/displayContractServiceDetail", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;

      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  private void sortCounties(CCON13SO ccon13so) {
    ROWCCON13SOG_ARRAY array = ccon13so.getROWCCON13SOG_ARRAY();
    if(array.getROWCCON13SOGCount() > 0) {
      List<ROWCCON13SOG> rowList = array.getROWCCON13SOGAsReference();
      Collections.sort(rowList, new Comparator<ROWCCON13SOG>() {
        public int compare(ROWCCON13SOG one, ROWCCON13SOG two) {
          return one.getSzCdCncntyCounty().compareTo(two.getSzCdCncntyCounty());
        }
      });
    }
  }

  
  public void displayContractServiceDetailSection_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayContractServiceDetail_xa()");
    
    
    performanceTrace.exitScope();
  }
  
  
  /**
   * This Method is used to display the Contract Service Detail Page. It is called when a user selects a Contract
   * Service Line Item on the Contract Service List.
   *
   * @param context
   *          Context for the request
   */
  public void displayContractServiceDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayContractServiceDetailSection_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      List<Option> serviceOptions = new ArrayList<Option>();

      // Create a list of the available service types for this contract, based
      // on the data from the Contract Service List; this data will be used to
      // populate the Services dropdown. This happens whether the detail is new
      // or edit

      boolean add = StringHelper.isValid(ContextHelper.getStringSafe(context, "btnAdd.x"));
      CCON11SO ccon11so = (CCON11SO) state.getAttribute("CCON11SO", request);
      ROWCCON11SOG00_ARRAY rowccon11sog00Array = null;
      if (ccon11so != null) {
        ROWCCON11SOG01_ARRAY servicesArray = ccon11so.getROWCCON11SOG01_ARRAY();
        rowccon11sog00Array = ccon11so.getROWCCON11SOG00_ARRAY();
        Enumeration e = servicesArray.enumerateROWCCON11SOG01();
        List<String> excludedServiceOptions = new ArrayList<String>();

        ROWCCON11SOG01 serviceObject = null;

        // SIR 18427--Added logic to the rowccon11sog00Array, to verify
        // the Array was not equal to zero.
        if (rowccon11sog00Array.getROWCCON11SOG00Count() != 0) {
          int lineItem = ContextHelper.getIntSafe(request, "hdnulNbrCnsvcLineItem");
          // SIR 18190 -- The Cost Reimb page will now save the values from the
          // Contract Service list not zero.
          ROWCCON11SOG00 currentContractList = rowccon11sog00Array.getROWCCON11SOG00(lineItem);
          state.setAttribute("currentContractList", currentContractList, request);

          //-- add:    exclude all previously saved services
          //-- update: exclude all saved services except the one we are updating
          if (add) {
            for (ROWCCON11SOG00 currentService : rowccon11sog00Array.getROWCCON11SOG00()) {
              excludedServiceOptions.add(currentService.getSzCdCnsvcService());
            }
          } else {
            for (ROWCCON11SOG00 currentService : rowccon11sog00Array.getROWCCON11SOG00()) {
              String cdService = currentService.getSzCdCnsvcService();
              if (cdService != null && !cdService.equals(currentContractList.getSzCdCnsvcService())) {
                excludedServiceOptions.add(cdService);
              }
            }
          }
        }

        // gets the service type and passes that service object from the list page
        // to the detail page
        while (e.hasMoreElements()) {
          serviceObject = (ROWCCON11SOG01) e.nextElement();
          String cdService = serviceObject.getSzCdRsrcSvcService();
          if (!excludedServiceOptions.contains(cdService)) {
            Option option = new Option(cdService, Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, cdService));
            serviceOptions.add(option);
          }
        }
      }
      // Setting serviceOptions Array
      state.setAttribute("serviceOptions", serviceOptions, request);

      // Add Case: create a new object if the add button is pressed
      if (add) {
        request.setAttribute("szCdScrDataAction", ServiceConstants.REQ_FUNC_CD_ADD);
        // SIR 17192 If we are adding do not display the county list on first
        // display since no services will have been selected. Once they have
        // selected a service the countylist will be set to Y so the list will
        // be displayed.
        request.setAttribute("countyList", "N");
        int rowCount = 0;
        if (ccon11so != null) {
          rowCount = ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00Count();
        }

        Integer csli = 1;
        if (rowCount != 0) {
          // SIR 18544 -- Added one (+1) to the CSLI.
          csli = ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(rowCount - 1).getUlNbrCnsvcLineItem() + 1;
        }
        request.setAttribute("csliAdd", csli);
      }
      // Edit Case: Edit button not pressed, just get the list of counties for
      // this line item
      else {
        // get the index of the line item from that will be displayed
        int index = ContextHelper.getIntSafe(context, "hdnulNbrCnsvcLineItem");
        ROWCCON11SOG00 rowccon11sog00 = rowccon11sog00Array.getROWCCON11SOG00(index);
        request.setAttribute("szCdScrDataAction", ServiceConstants.REQ_FUNC_CD_UPDATE);
        request.setAttribute("ROWCCON11SOG00", rowccon11sog00);
        // SIR 17192 -- If we are displaying an already existing service detail,
        // display county list since a service has been previously selected
        request.setAttribute("countyList", "Y");
        // get the service type out of rowccon11sog00
        String serviceType = rowccon11sog00.getSzCdCnsvcService();
        // get the list of counties for the line item
        CCON13SI ccon13si = populateCCON13SI_List(context, serviceType, rowccon11sog00.getUlNbrCnsvcLineItem());
        // CCON13SO ccon13so = CCON13SO.unmarshal(new StringReader(WtcHelper.callService("CCON13S", ccon13si)));
        CCON13SO ccon13so = financials.retrieveCounties(ccon13si);
        sortCounties(ccon13so);
        // set county list on the request
        state.setAttribute("CCON13SO", ccon13so, request);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CON_NO_COUNTY:
        // This is not really an error message, it is just displayed in the
        // list box if no rows are returned
        state.removeAttribute("CCON13SO", request);
        break;

      case Messages.MSG_CON_NO_SVC_CODE:
      case Messages.MSG_NO_SVC_DECODE:
        setErrorMessage(errorCode, "/financials/Contracts/displayContractServiceDetail", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  
  public void selectProgramCode_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".selectProgramCode_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // get program code from request
    String programCode = ContextHelper.getStringSafe(request, "szProgCode");
    if(StringHelper.isNotEmptyOrNull(programCode)){
      // get list of services from state
      List<String> programCodeServicesList = (List<String>) state.getAttribute("programCodeServices", request);
      List<String> serviceList = new ArrayList<String>();
      if(programCodeServicesList != null){
        // get all services for the selected program code
        for(String programCodeService : programCodeServicesList){
          if(StringHelper.isNotEmptyOrNull(programCodeService) && programCode.equals(programCodeService.substring(0, 3))){
            serviceList.add(programCodeService);
          }
        }
        
        // place list of services into the request to build the service list section on the contract services detail page
        request.setAttribute("serviceList", serviceList);
      }
    }
    
    performanceTrace.exitScope();
  }

  /**
   * This method is used to Save the Contract Service Detail Page. It is called when the user clicks the Save button. It
   * calls the populateCCON12SI_UPDATE method
   *
   * @param context
   *          Context for the request
   */
  public void saveContractServiceDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveContractServiceDetail_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    //CCON13SO ccon13so = (CCON13SO) state.getAttribute("CCON13SO", request);
    try {
      // verify if the row is new or update
      //String szCdScrDataAction = ContextHelper.getStringSafe(request, "hdnszCdScrDataAction");

      CCON12SI ccon12si = populateCCON12SI_AU(context);
      //WtcTransactionHandle wth = null;
      try {
        // begin a transaction
        // wth = WtcHelper.getTransactionTuxedoConnection();
        // WtcHelper.callService("CCON12S", ccon12si.toString(), wth.getTuxedoConnection());
        financials.saveContractList(ccon12si);
        CCON14SI ccon14si = populateCCON14SI_AU_COUNTY_LIST(context);

        // If there were no changed checkbox values (ccon14si is null), do not
        // call the service.
        if (ccon14si != null) {
          // WtcHelper.callService("CCON14S", ccon14si.toString(),wth.getTuxedoConnection());
          financials.saveCountyList(ccon14si);
        }
      } finally {
        // end the transaction
        // WtcHelper.endTuxedoTransaction(wth);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_NO_EQUIV_CONTRACT:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CON_NO_COUNTY:
      case Messages.MSG_CSLI_EXISTS:

        super.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, request);

        state.removeAttribute("CCON13SO", request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }

    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is used to populated the input object for an Update of the Contract Service Detail page. It is called
   * by the saveContractServiceDetail_xa method after the user clicks the save button on the Contract Service Detail
   * page.
   *
   * @param context
   *          Context for the request
   * @return ccon12si
   */
  private CCON12SI populateCCON12SI_AU(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".populateCCON12SI_UPDATE()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCCON12SIG00 rowccon12sig00 = new ROWCCON12SIG00();
    //CCON11SO ccon11so = (CCON11SO) state.getAttribute("CCON11SO", request);
    CCON12SI ccon12si = new CCON12SI();

    String szCdScrDataAction = ContextHelper.getStringSafe(request, "hdnszCdScrDataAction");

    ROWCCON12SIG00_ARRAY rowccon12sig00_array = new ROWCCON12SIG00_ARRAY();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(0);
    input.setUlPageSizeNbr(1);

    ROWCCON11SOG00 currentContractList = (ROWCCON11SOG00) state.getAttribute("currentContractList", request);

    if (szCdScrDataAction.equals(ServiceConstants.REQ_FUNC_CD_UPDATE)) {
      // SIR 18190 -- The Cost Reimb page will now save the values from the
      // Contract Service list not zero.
      rowccon12sig00.setUlAmtCnsvcEquip(currentContractList.getUlAmtCnsvcEquip());
      rowccon12sig00.setUlAmtCnsvcFrgBenft(currentContractList.getUlAmtCnsvcFrgBenft());
      rowccon12sig00.setUlAmtCnsvcOther(currentContractList.getUlAmtCnsvcOther());
      rowccon12sig00.setUlAmtCnsvcSalary(currentContractList.getUlAmtCnsvcSalary());
      rowccon12sig00.setUlAmtCnsvcSupply(currentContractList.getUlAmtCnsvcSupply());
      rowccon12sig00.setUlAmtCnsvcTravel(currentContractList.getUlAmtCnsvcTravel());
    }

    if (szCdScrDataAction.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {

      rowccon12sig00.setUlAmtCnsvcUnitRate(0);
      rowccon12sig00.setUlAmtCnsvcEquip(0);
      rowccon12sig00.setUlAmtCnsvcFrgBenft(0);
      rowccon12sig00.setUlAmtCnsvcOther(0);
      rowccon12sig00.setUlAmtCnsvcSalary(0);
      rowccon12sig00.setUlAmtCnsvcSupply(0);
      rowccon12sig00.setUlAmtCnsvcTravel(0);
    } else {
      rowccon12sig00.setUlAmtCnsvcUnitRate(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcUnitRate"));
    }
    rowccon12sig00.setSzCdCnsvcPaymentType(ContextHelper.getStringSafe(request, "szNbrCnsvcPaymentType"));
    rowccon12sig00.setSzCdCnsvcService(ContextHelper.getStringSafe(request, "szNbrCnsvcService"));
    rowccon12sig00.setSzNbrCnsvcUnitType(ContextHelper.getStringSafe(request, "szNbrCnsvcUnitType"));

    if (szCdScrDataAction.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      rowccon12sig00.setCIndCnsvcNewRow("Y");
    } else {
      rowccon12sig00.setCIndCnsvcNewRow("N");
    }

    rowccon12sig00.setUlIdCnsvc(ContextHelper.getIntSafe(request, "hdnUlIdCnsvc"));
    rowccon12sig00.setUlNbrCnsvcFedMatch(ContextHelper.getIntSafe(request, "ulNbrCnsvcFedMatch"));

    rowccon12sig00.setUlNbrCnsvcLineItem(getCSLI(request));
    rowccon12sig00.setUlNbrCnsvcLocalMatch(ContextHelper.getIntSafe(request, "ulNbrCnsvcLocalMatch"));
    rowccon12sig00.setUlNbrCnsvcUnitRate(ContextHelper.getMoneyAsDoubleSafe(request, "ulNbrCnsvcUnitRate"));
    rowccon12sig00.setSzCdScrDataAction(ContextHelper.getStringSafe(request, "hdnszCdScrDataAction"));
    rowccon12sig00.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnLastUpdate"));

    ccon12si.setArchInputStruct(input);
    ccon12si.setSzCdCntrctFuncType(ContextHelper.getStringSafe(request, "hdnContractFunctionType"));
    ccon12si.setDtDtCncntyEffective(ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEffective"));
    ccon12si.setDtDtCncntyEnd(ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEnd"));
    ccon12si.setUlIdCntrctWkr(user.getUserID());
    ccon12si.setUlIdContract(GlobalData.getUlIdContract(request));
    ccon12si.setUlNbrCnsvcPeriod(GlobalData.getUlNbrCnperPeriod(request));
    ccon12si.setUlNbrCnsvcVersion(GlobalData.getUlNbrCnverVersion(request));

    rowccon12sig00_array.addROWCCON12SIG00(rowccon12sig00);

    ccon12si.setROWCCON12SIG00_ARRAY(rowccon12sig00_array);

    performanceTrace.exitScope();

    return ccon12si;
  }

  protected int getCSLI(HttpServletRequest request) {
    // SIR 18739-- Used a hidden field to populate the getCSLI.
    // dspUlNbrCnsvcLineItem is on the Contract Service List page.
    return ContextHelper.getIntSafe(request, "dspUlNbrCnsvcLineItem");
  }

  /**
   * This method is used to populated the input object for an Update of for the County List on the Contract Service
   * Detail page. It is called by the saveContractServiceDetail_xa * method after the user clicks the Save button on the
   * Contract Service Detail Page.
   *
   * @param context
   *          Context for the request
   * @return ccon14si
   * @throws CheckboxHelperException
   *           Exception CheckboxHelperException
   */
  private CCON14SI populateCCON14SI_AU_COUNTY_LIST(GrndsExchangeContext context) throws CheckboxHelperException {
    BaseSessionStateManager state = getSessionStateManager(context);

    HttpServletRequest request = context.getRequest();

    CCON13SO ccon13so = (CCON13SO) state.getAttribute("CCON13SO", request);
    ROWCCON13SOG_ARRAY rowccon13sog_array = new ROWCCON13SOG_ARRAY();
    if (ccon13so != null) {
      rowccon13sog_array = ccon13so.getROWCCON13SOG_ARRAY();
    }

    CCON14SI ccon14si = new CCON14SI();
    ArchInputStruct input = new ArchInputStruct();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    //String szCdScrDataAction = ContextHelper.getStringSafe(request, "hdnszCdScrDataAction");
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(0);

    ccon14si.setArchInputStruct(input);
    ccon14si.setSzCdRsrcSvcService(ContextHelper.getStringSafe(request, "szNbrCnsvcService"));
    ccon14si.setDtDtCncntyEffective(ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEffective"));
    ccon14si.setDtDtCncntyEnd(ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEnd"));
    ccon14si.setUlIdCntrctWkr(user.getUserID());
    ccon14si.setUlIdContract(GlobalData.getUlIdContract(request));
    ccon14si.setUlIdResource(ContextHelper.getIntSafe(request, "hdnUlIdResource"));
    ccon14si.setUlNbrCncntyLineItem(getCSLI(request));
    ccon14si.setUlNbrCncntyPeriod(GlobalData.getUlNbrCnperPeriod(request));
    ccon14si.setUlNbrCncntyVersion(GlobalData.getUlNbrCnverVersion(request));

    ROWCCON14SIG_ARRAY rowccon14sig_array = new ROWCCON14SIG_ARRAY();
    // setting up checkbox helper to get the check values
    Collection changedValues = CheckboxHelper.getChangedValues(request, "cbxCounty", rowccon13sog_array,
                                                               ROWCCON13SOG.class, "szCdCncntyCounty");
    java.util.Iterator i = changedValues.iterator();
    input.setUlPageSizeNbr(changedValues.size());

    // If no checkboxes have been changed, we do not want to call the service at
    // all, so return null here.
    if (i.hasNext() == false) {
      return null;
    }

    while (i.hasNext()) {
      CheckboxHelper.ObjectActionCodePair pair = (CheckboxHelper.ObjectActionCodePair) i.next();
      ROWCCON13SOG rowccon13sog = (ROWCCON13SOG) pair.getObject();
      ROWCCON14SIG rowccon14sig = new ROWCCON14SIG();

      rowccon14sig.setSzCdCncntyCounty(rowccon13sog.getSzCdCncntyCounty());
      rowccon14sig.setUlIdCncnty(rowccon13sog.getUlIdCncnty());
      rowccon14sig.setSzCdScrDataAction(pair.getActionCode());
      rowccon14sig.setTsLastUpdate(rowccon13sog.getTsLastUpdate());
      rowccon14sig_array.addROWCCON14SIG(rowccon14sig);
    }
    ccon14si.setROWCCON14SIG_ARRAY(rowccon14sig_array);

    return ccon14si;
  }

  /**
   * This method is used to display the Cost Reimbursement Detail or Unit Rate Detail pages. If SzCdCnsvcPaymentType
   * equals CRM then it opens the Cost Reimbursement detail page otherwise it opens the Unit Rate Detail page.
   *
   * @param context
   *          Context for the request
   */
  public void displayCostRmbrsmentOrUnitRate_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayUnitRateDetail_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // set rowccon11sog00 equal to null
    ROWCCON11SOG00 rowccon11sog00;

    try {
      int index;

      // set index equal to hdnulNbrCnsvcLineItem. then subtract one from
      // hdnulNbrCnsvcLineItem. subtracting one allows the the array and index to
      // be equal to the same number.
      index = ContextHelper.getIntSafe(context, "hdnulNbrCnsvcLineItem");

      CCON11SO ccon11so = (CCON11SO) state.getAttribute("CCON11SO", request);
      ROWCCON11SOG00_ARRAY rowccon11sog00Array = ccon11so.getROWCCON11SOG00_ARRAY();
      rowccon11sog00 = rowccon11sog00Array.getROWCCON11SOG00(index);

      // get rowccon11sog00 out of the request
      request.setAttribute("rowccon11sog00", rowccon11sog00);

      // Determines the next page UnitRateDetail or ContractCostRmbrsment
      if ("CRM".equals(rowccon11sog00.getSzCdCnsvcPaymentType())) {
        forward("/financials/Contracts/displayContractCostRmbrsmntDetail", request, context.getResponse());
      } else {
        forward("/financials/Contracts/displayUnitRate", request, context.getResponse());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is used to populated the input object for an Update of the Cost Reimbursement Detail or Unit Rate
   * detail pages. It is called by the saveContractCostReimbursementOrUnitRateDetail_xa method after the user clicks the
   * save button on either page.
   *
   * @param context
   *          Context for the request
   * @return ccon12si
   */
  private CCON12SI populateCCON12SI_SAVE_COST_REMBRSMENT_DETAIL_OR_UNIT_RATE(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG,
                                                                    ".populateCCON12SI_SAVE_COST_REMBRSMENT_DETAIL()");

    HttpServletRequest request = context.getRequest();

    ROWCCON12SIG00 rowccon12sig00 = new ROWCCON12SIG00();

    CCON12SI ccon12si = new CCON12SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCON12SIG00_ARRAY rowccon12sig00_array = new ROWCCON12SIG00_ARRAY();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(0);
    input.setUlPageSizeNbr(1);

    // get payment type out of the request
    String paymentType = (ContextHelper.getStringSafe(request, "hdnSzCnsvcPaymentType"));
    rowccon12sig00.setSzCdCnsvcPaymentType(paymentType);

    if ("CRM".equals(paymentType)) {
      // set the parameters if the page is cost reimbursement
      rowccon12sig00.setUlAmtCnsvcUnitRate(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcUnitRate"));
      rowccon12sig00.setUlAmtCnsvcEquip(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcEquip"));
      rowccon12sig00.setUlAmtCnsvcFrgBenft(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcFrgBenft"));
      rowccon12sig00.setUlAmtCnsvcOther(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcOther"));
      rowccon12sig00.setUlAmtCnsvcSalary(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcSalary"));
      rowccon12sig00.setUlAmtCnsvcSupply(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcSupply"));
      rowccon12sig00.setUlAmtCnsvcTravel(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcTravel"));
    } else {
      // set the parameters if the page is unit rate
      rowccon12sig00.setUlAmtCnsvcUnitRate(ContextHelper.getMoneyAsDoubleSafe(request, "ulAmtCnsvcUnitRate"));
      rowccon12sig00.setUlAmtCnsvcEquip(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcEquip"));
      rowccon12sig00.setUlAmtCnsvcFrgBenft(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcFrgBenft"));
      rowccon12sig00.setUlAmtCnsvcOther(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcOther"));
      rowccon12sig00.setUlAmtCnsvcSalary(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcSalary"));
      rowccon12sig00.setUlAmtCnsvcSupply(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcSupply"));
      rowccon12sig00.setUlAmtCnsvcTravel(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlAmtCnsvcTravel"));
    }

    // set common parameters for both the cost reimbursement and unit rate pages
    rowccon12sig00.setSzCdCnsvcService(ContextHelper.getStringSafe(request, "hdnSzCnsvcService"));
    rowccon12sig00.setSzNbrCnsvcUnitType(ContextHelper.getStringSafe(request, "hdnSzNbrCnsvcUnitType"));
    rowccon12sig00.setCIndCnsvcNewRow("N");
    rowccon12sig00.setUlIdCnsvc(ContextHelper.getIntSafe(request, "hdnUlIdCnsvc"));
    rowccon12sig00.setUlNbrCnsvcFedMatch(ContextHelper.getIntSafe(request, "hdnUlNbrCnsvcFedMatch"));
    rowccon12sig00.setUlNbrCnsvcLineItem(ContextHelper.getIntSafe(request, "hdnUlNbrCnsvcLineItem"));

    rowccon12sig00.setUlNbrCnsvcLocalMatch((ContextHelper.getIntSafe(request, "hdnUlNbrCnsvcLocalMatch")));
    rowccon12sig00.setUlNbrCnsvcUnitRate(ContextHelper.getMoneyAsDoubleSafe(request, "hdnUlNbrCnsvcUnitRate"));
    rowccon12sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    rowccon12sig00.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));

    // set common ccon12si for both the cost reimbursement and unit rate pages
    ccon12si.setArchInputStruct(input);
    ccon12si.setSzCdCntrctFuncType(ContextHelper.getStringSafe(request, "hdnContractFunctionType"));
    ccon12si.setDtDtCncntyEffective(ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEffective"));
    ccon12si.setDtDtCncntyEnd(ContextHelper.getCastorDateSafe(request, "hdndtDtCncntyEnd"));
    ccon12si.setUlIdCntrctWkr(user.getUserID());
    ccon12si.setUlIdContract(GlobalData.getUlIdContract(request));
    ccon12si.setUlNbrCnsvcPeriod(GlobalData.getUlNbrCnperPeriod(request));
    ccon12si.setUlNbrCnsvcVersion(GlobalData.getUlNbrCnverVersion(request));
    rowccon12sig00_array.addROWCCON12SIG00(rowccon12sig00);
    ccon12si.setROWCCON12SIG00_ARRAY(rowccon12sig00_array);

    performanceTrace.exitScope();

    return ccon12si;
  }

  /**
   * The setContractPageSet setStaffSearchPageSet method sets the PageSet based upon the conditions below.
   *
   * @param context
   *          Context for the request
   * @param ccon02so
   *          CCON02SO
   */
  protected void setContractPageSet(GrndsExchangeContext context, CCON02SO ccon02so) {
    HttpServletRequest request = context.getRequest();
    // BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    String functionType = FormattingHelper.formatString(ccon02so.getSzCdCntrctFuncType());
    String region = FormattingHelper.formatString(ccon02so.getSzCdCntrctRegion());
    List<String> userMaintainedRegions = user.getUserMaintainedRegions();

    // We have to check each possible value of Function Type and make sure the
    // user has the appropriate Security Attribute.

    if ((functionType.equals(CodesTables.CCONFUNC_CPS) && !(user.hasRight(UserProfile.SEC_CPS_POS_CONTRACT)))
        || (functionType.equals(CodesTables.CCONFUNC_FAC) && !(user.hasRight(UserProfile.SEC_FAC_CONTRACT)))
        || (functionType.equals(CodesTables.CCONFUNC_FAD) && !(user.hasRight(UserProfile.SEC_FAD_CONTRACT)))) {

      PageMode.setPageMode(PageModeConstants.VIEW, request);
    } else if(!userMaintainedRegions.contains(region)) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }
  }

  /**
   * This method is used to diplay the Contract Header page. If there is a Contract ID passed in from the Contract
   * Search page then it opens the page in either modfy or View mode depending on the page state passed in. If Add is
   * selected on the Contract Search page a zero is passed for contract ID and it opens in New mode.
   *
   * @param context
   *          Context for the request
   */
  public void displayContractHeader_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayContractHeader_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    int contractId = GlobalData.getUlIdContract(context.getRequest());

    int contractPeriod = -1;
    if (state.getAttribute("contractPeriod", request) != null) {
      contractPeriod = Integer.parseInt((String) state.getAttribute("contractPeriod", request));
    }

    CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
    String indValidate = (String) state.getAttribute("indValidate", request);

    state.removeAllAttributes(request);
    state.setAttribute("indValidate", indValidate, request);
    PageMode.setPageMode(GlobalData.getAppMode(request), request);

    if (contractPeriod != -1) {
      state.setAttribute("contractPeriod", "" + contractPeriod, request);
    }

    if (contractId != 0) {
      // SIR 18509 GRIMSHAN If page has been prevously saved, set indValidate to
      // "Y" so that the user will not be forced to validate again
      state.setAttribute("indValidate", "Y", request);

      String hdnContractPeriodParam = request.getParameter("hdnContractPeriod");
      if (hdnContractPeriodParam != null && !"".equals(hdnContractPeriodParam)) {
        contractPeriod = ContextHelper.getIntSafe(request, "hdnContractPeriod");
        state.setAttribute("contractPeriod", hdnContractPeriodParam, request);
      }
      try {

        ArchInputStruct HeaderInput1 = new ArchInputStruct();
        HeaderInput1.setSzUserId(user.getUserLogonID());
        HeaderInput1.setUsPageNbr(1);
        HeaderInput1.setUlPageSizeNbr(15);
        CCON02SI ccon02si = new CCON02SI();
        ccon02si.setArchInputStruct(HeaderInput1);
        ccon02si.setUlIdContract(contractId);

        ccon02so = financials.findContract(ccon02si);
        state.setAttribute("CCON02SO", ccon02so, request);

        // Get the Page Mode for Contract Header
        String pageMode = PageMode.getPageMode(request);

        if (PageModeConstants.EDIT.equals(pageMode)) {
          setContractPageSet(context, ccon02so);
        }

        ArchInputStruct HeaderInput2 = new ArchInputStruct();
        CCON05SI ccon05si = new CCON05SI();
        HeaderInput2.setSzUserId(user.getUserLogonID());
        HeaderInput2.setUsPageNbr(1);
        // SIR 22413 - Changed UlPageSizeNumber of CCON05 from 15 to 50
        HeaderInput2.setUlPageSizeNbr(99);
        ccon05si.setArchInputStruct(HeaderInput2);
        ccon05si.setUlIdContract(contractId);

        CCON05SO ccon05so = financials.findContractPeriod(ccon05si);
        state.setAttribute("CCON05SO", ccon05so, request);

        // enumerate through ROWCCON05SOG00_ARRAY in order to get the element
        // matching the selected period number in the Period Detail listbox on
        // the Contract Header page.
        ROWCCON05SOG00_ARRAY ary = ccon05so.getROWCCON05SOG00_ARRAY();
        CCON07SI ccon07si = new CCON07SI();
        if (ary != null && ary.getROWCCON05SOG00Count() > 0) {
          ArchInputStruct Headerinput2 = new ArchInputStruct();
          Headerinput2.setSzUserId(user.getUserLogonID());
          Headerinput2.setUsPageNbr(1);
          Headerinput2.setUlPageSizeNbr(99);
          ccon07si.setArchInputStruct(Headerinput2);
          ccon07si.setUlIdContract(contractId);
          ccon07si.setUlNbrCnverPeriod(ary.getROWCCON05SOG00Count());

          CCON07SO mostRecentPeriodVersions = financials.findContractVersion(ccon07si);
          ROWCCON07SOG00_ARRAY versionsArray = mostRecentPeriodVersions.getROWCCON07SOG00_ARRAY();

          // Any period should have at least one version, but the safeguards here
          // should keep the page from breaking if there are ever any bad data.
          if (versionsArray != null && versionsArray.getROWCCON07SOG00Count() > 0) {
            String mostRecentVersionLocked = versionsArray.getROWCCON07SOG00(0).getCIndCnverVerLock();
            if (!StringHelper.isTrue(mostRecentVersionLocked)) {
              request.setAttribute(VERSION_NOT_LOCKED, "true");
            }
          }
        }

        ROWCCON05SOG00 userRow;

        if (contractPeriod >= 0 && ary.getROWCCON05SOG00Count() > contractPeriod) {
          userRow = ary.getROWCCON05SOG00(contractPeriod);
          ccon07si.setUlNbrCnverPeriod(userRow.getUlNbrCnperPeriod());
          GlobalData.setUlNbrCnperPeriod(userRow.getUlNbrCnperPeriod(), request);

          CCON07SO ccon07so = financials.findContractVersion(ccon07si);
          state.setAttribute("CCON07SO", ccon07so, request);
        }
      } catch (ServiceException we) {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        int errorCode = we.getErrorCode();
        switch (errorCode) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_CON_NO_VID_EXISTS:
        case Messages.MSG_CON_RESOURCE_INVALID:
          setErrorMessage(errorCode, "/financials/Contracts/displayContractHeader", request);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
        }
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + e.getMessage());
        processSevereException(context, e);
      }

    } // End IF for (ContractId != 0) Start display Contract Header from an

    else {
      PageMode.setPageMode(PageModeConstants.NEW, request);
      // SIR 18509 GRIMSHAN If page mode is new, set indValidate to "N"
      // so that the user wil be forced to validate the resource ID.
      if (state.getAttribute("indValidate", request) == null) {
        state.setAttribute("indValidate", "N", request);
      }

    }

    if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null) {

      ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

      Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();

      int ulIdCntrctManager = 0;
      String szNmPersonFull = "";

      while (e.hasMoreElements()) {
        ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();

        ulIdCntrctManager = staff.getUlIdPerson(); // Not used but may need to
        // be if a service is called to get the manager name
        szNmPersonFull = staff.getSzNmPersonFull();
      }

      if (ccon02so == null) {
        ccon02so = new CCON02SO();
      }
      ccon02so.setUlIdCntrctManager(ulIdCntrctManager);
      ccon02so.setSzNmPersonFull(szNmPersonFull);

      state.setAttribute("CCON02SO", ccon02so, request);

    }

    performanceTrace.exitScope();
    return;
  }

  /**
   * validateHeader
   *
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void validateHeader_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateContract_xa()");
    performanceTrace.enterScope();
    try {
      UserProfile user = UserProfileHelper.getUserProfile(context);

      //PageMode.setPageMode(PageMode.getPageMode(request), request);
      CCON04SI ccon04si = new CCON04SI();
      int ResourceID = ContextHelper.getIntSafe(context, "txtUlIdResource");
      // Set widgets from request to true so that their values will not be lost
      // on validate

      try {
        ArchInputStruct ValidateInput1 = new ArchInputStruct();
        ValidateInput1.setSzUserId(user.getUserLogonID());
        ValidateInput1.setUsPageNbr(1);
        ValidateInput1.setUlPageSizeNbr(15);
        ccon04si.setArchInputStruct(ValidateInput1);
        ccon04si.setUlIdResource(ResourceID);

        CCON04SO ccon04so = financials.findResource(ccon04si);
        CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
        if (ccon02so == null) {
          ccon02so = new CCON02SO();
        }
        ccon02so.setROWCCON02SOG00_ARRAY(ccon04so.getROWCCON02SOG00_ARRAY());
        ccon02so.setSzNmResource(ccon04so.getSzNmResource());
        ccon02so.setUlIdResource(ResourceID);

        // SIR 18509 -- Make sure these fields do not dissapear on validate
        //if (ContextHelper.getStringSafe(request, "selSzCdCntrctProcureType") != null) {
          ccon02so.setSzCdCntrctProcureType(ContextHelper.getStringSafe(request, "selSzCdCntrctProcureType"));
        //}
        //if (ContextHelper.getStringSafe(request, "txtUlIdCntrctManager") != null) {
          ccon02so.setSzNmPersonFull(ContextHelper.getStringSafe(request, "txtUlIdCntrctManager"));
        //}
        if (ContextHelper.getIntSafe(request, "hdnTxtUlIdCntrctManager") != 0) {
          ccon02so.setUlIdCntrctManager(ContextHelper.getIntSafe(request, "hdnTxtUlIdCntrctManager"));
        }
        //if (ContextHelper.getStringSafe(request, "selSzCdCntrctRegion") != null) {
          ccon02so.setSzCdCntrctRegion(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion"));
        //}
        //if (ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType") != null) {
          ccon02so.setSzCdCntrctFuncType(ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType"));
        //}
        //if (ContextHelper.getStringSafe(request, "selSzCdCntrctProgramType") != null) {
          ccon02so.setSzCdCntrctProgramType("CPS");
        //}
        //if (ContextHelper.getStringSafe(request, "cbxCIndCntrctBudgLimit") != null) {
          ccon02so.setCIndCntrctBudgLimit(ContextHelper.getStringSafe(request, "cbxCIndCntrctBudgLimit"));
        //}

        state.setAttribute("CCON02SO", ccon02so, request);
        // SIR 18509 GRIMSHAN after validate has been successful, set
        // indValidate to "Y" so that the user will not be forced to validate
        // again
        state.setAttribute("indValidate", "Y", request);

      } catch (ServiceException we) {
        int errorCode = we.getErrorCode();
        switch (errorCode) {
        case Messages.SQL_NOT_FOUND:
        case Messages.MSG_CON_NO_VID_EXISTS:
        case Messages.MSG_CON_RESOURCE_INVALID:
          setErrorMessage(errorCode, "/financials/Contracts/displayContractHeader", request);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
        }
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method submits a resource search to the Resource Search JSP. It is called when the user clicks the resource
   * button.
   *
   * @param context
   *          Context for the request
   */
  public void searchResource_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".SearchResource_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // SIR 18509 set Validate to No when doing a new resource search.
    state.setAttribute("indValidate", "N", request);
    CCON02SO ccon02so = new CCON02SO();

    //if (ContextHelper.getStringSafe(request, "selSzCdCntrctProcureType") != null) {
      ccon02so.setSzCdCntrctProcureType(ContextHelper.getStringSafe(request, "selSzCdCntrctProcureType"));
    //}
    //if (ContextHelper.getStringSafe(request, "txtUlIdCntrctManager") != null) {
      ccon02so.setSzNmPersonFull(ContextHelper.getStringSafe(request, "txtUlIdCntrctManager"));
    //}
    // SIR 18509 get ulIdContractManager out so that it will persist when doing
    // a resource pullback
    if (ContextHelper.getIntSafe(request, "hdnTxtUlIdCntrctManager") != 0) {
      ccon02so.setUlIdCntrctManager(ContextHelper.getIntSafe(request, "hdnTxtUlIdCntrctManager"));
    }
    //if (ContextHelper.getStringSafe(request, "selSzCdCntrctRegion") != null) {
      ccon02so.setSzCdCntrctRegion(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion"));
    //}
    //if (ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType") != null) {
      ccon02so.setSzCdCntrctFuncType(ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType"));
    //}
    //if (ContextHelper.getStringSafe(request, "selSzCdCntrctProgramType") != null) {
      ccon02so.setSzCdCntrctProgramType("CPS");
    //}
    //if (ContextHelper.getStringSafe(request, "cbxCIndCntrctBudgLimit") != null) {
      ccon02so.setCIndCntrctBudgLimit(ContextHelper.getStringSafe(request, "cbxCIndCntrctBudgLimit"));
    //}

    state.setAttribute("CCON02SO", ccon02so, request);

    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is used to perform the pullback on a Resource Search. It is called after the Search-Resource Method.
   *
   * @param context
   *          Context for the request
   */
  public void setResource_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setResource_xa()");

    HttpServletRequest request = context.getRequest();

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    String resName = cres03so.getSzNmResource();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
    if (ccon02so == null) {
      ccon02so = new CCON02SO();
    }
    ccon02so.setUlIdResource(cres03so.getUlIdResource());
    ccon02so.setSzNmResource(resName);
    ROWCCON02SOG00_ARRAY inRowArray = new ROWCCON02SOG00_ARRAY();
    ccon02so.setROWCCON02SOG00_ARRAY(inRowArray);
    ROWCRES03SOG00_ARRAY outRowArray = cres03so.getROWCRES03SOG00_ARRAY();
    Enumeration enumeration = outRowArray.enumerateROWCRES03SOG00();
    while (enumeration.hasMoreElements()) {
      ROWCRES03SOG00 outRow = (ROWCRES03SOG00) enumeration.nextElement();
      inRowArray.addROWCCON02SOG00(copyCresG00ToCconG00(outRow));
    }
    state.setAttribute("CCON02SO", ccon02so, request);

    state.removeAttribute("CCON04SO", request);
    state.removeAttribute("ROWCCON02SOG00_ARRAY", request);

    performanceTrace.exitScope();

  }

  /**
   * @param outRow
   *          ROWCRES03SOG00 object
   * @return inRow
   */
  protected ROWCCON02SOG00 copyCresG00ToCconG00(ROWCRES03SOG00 outRow) {
    ROWCCON02SOG00 inRow = new ROWCCON02SOG00();

    // copy properties from CRES03SOG00 row to CCON02SOG00 row
    inRow.setSzAddrRsrcAddrStLn1(outRow.getSzAddrRsrcAddrStLn1());
    inRow.setSzNbrRsrcAddrVid(outRow.getSzNbrRsrcAddrVid());
    inRow.setUlIdRsrcAddress(outRow.getUlIdRsrcAddress());

    return inRow;
  }

  /**
   * This method is used to perform a Staff Search pullback. It is called when a user clicks the Staff push button. It
   * opens the Staff Search JSP which returns a selected Staff member to the Contract Manager field on Contrat Header.
   *
   * @param context
   *          Context for the request
   */
  public void searchStaff_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".SearchStaff_xa()");

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      StaffSearchInput io = new StaffSearchInput();

      io.setSourcePage(StaffSearchInput.OTHER);
      io.setDestinationUrl("/financials/Contracts/displayContractHeader");
      request.setAttribute("StaffSearchInput", io);
      CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
      if (ccon02so == null) {
        ccon02so = new CCON02SO();
      }

      // SIR 18509 make sure the fields are not lost on searching.
      //if (ContextHelper.getStringSafe(request, "selSzCdCntrctProcureType") != null) {
        ccon02so.setSzCdCntrctProcureType(ContextHelper.getStringSafe(request, "selSzCdCntrctProcureType"));
      //}
      //if (ContextHelper.getStringSafe(request, "txtUlIdCntrctManager") != null) {
        ccon02so.setSzNmPersonFull(ContextHelper.getStringSafe(request, "txtUlIdCntrctManager"));
      //}
      //if (ContextHelper.getStringSafe(request, "selSzCdCntrctRegion") != null) {
        ccon02so.setSzCdCntrctRegion(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion"));
      //}
      //if (ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType") != null) {
        ccon02so.setSzCdCntrctFuncType(ContextHelper.getStringSafe(request, "selSzCdCntrctFuncType"));
      //}
      //if (ContextHelper.getStringSafe(request, "selSzCdCntrctProgramType") != null) {
        ccon02so.setSzCdCntrctProgramType("CPS");
      //}
      //if (ContextHelper.getStringSafe(request, "cbxCIndCntrctBudgLimit") != null) {
        ccon02so.setCIndCntrctBudgLimit(ContextHelper.getStringSafe(request, "cbxCIndCntrctBudgLimit"));
      //}
      //if (ContextHelper.getStringSafe(request, "txtUlIdResource") != null) {
        ccon02so.setUlIdResource(ContextHelper.getIntSafe(request, "txtUlIdResource"));
      //}
      state.setAttribute("CCON02SO", ccon02so, request);
      //if (ContextHelper.getStringSafe(request, "hdnIndValidate") != null) {
        state.setAttribute("indValidate", ContextHelper.getStringSafe(request, "hdnIndValidate"), request);
      //}

      // forward the context to the staff search command
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception e) {
      e.printStackTrace();
    }

    performanceTrace.exitScope();
    return;
  }

  /**
   * This method saves the information on the Contract Header JSP. It calls the populateCCON03SI_Update method. It is
   * called when a user clicks the Save button.
   *
   * @param context
   *          Context for the request
   */
  public void saveContractHeader_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".SaveContractHeader_xa()");
    HttpServletRequest request = context.getRequest();

    CCON03SO ccon03so = null;
    try {
      // page data and validate service output populates and calls save service
      CCON03SI ccon03si = populateCCON03SI_Update(context);      
      ccon03so = financials.saveContract(ccon03si);
      GlobalData.setUlIdContract(ccon03so.getUlIdContract(), request);      
     
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_CON_NO_VID_EXISTS:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.SSM_NO_ROWS_RETURNED:
        setErrorMessage(errorCode, "/financials/Contracts/displayContractHeader", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
    return;

  }

  /**
   * This method is used to populate the input object for a Save. It is called by the saveContractHeader_xa method after
   * a user clicks the Save button.
   *
   * @param context
   *          Context for the request
   * @return ccon03si
   */
  private CCON03SI populateCCON03SI_Update(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);

    ROWCCON02SOG00_ARRAY rowccon02sog00_array = ccon02so.getROWCCON02SOG00_ARRAY();

    CCON03SI ccon03si = new CCON03SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlPageSizeNbr(15);
    input.setUsPageNbr(1);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    input.setSzUserId(user.getUserLogonID());
    ccon03si.setUlIdContract(GlobalData.getUlIdContract(request));
    ccon03si.setSzCdCntrctFuncType(ContextHelper.getStringSafe(context, "selSzCdCntrctFuncType"));
    ccon03si.setSzCdCntrctProcureType(ContextHelper.getStringSafe(context, "selSzCdCntrctProcureType"));
    ccon03si.setSzCdCntrctProgramType("CPS");
    ccon03si.setSzCdCntrctRegion(ContextHelper.getStringSafe(context, "selSzCdCntrctRegion"));
    ccon03si.setCIndCntrctBudgLimit(CheckboxHelper.getCheckboxValue(request, "cbxCIndCntrctBudgLimit"));
    ccon03si.setCIndCntrctedResource(CheckboxHelper.getCheckboxValue(request, "cbxCIndCntrctedResource"));
    ccon03si.setUlIdCntrctManager(ContextHelper.getIntSafe(context, "hdnTxtUlIdCntrctManager"));
    ccon03si.setUlIdCntrctWkr(UserProfileHelper.getUserProfile(request).getUserID());
    ccon03si.setUlIdResource(ContextHelper.getIntSafe(context, "txtUlIdResource"));
    int resourceAddress = 0;
    try {

      ROWCCON02SOG00 vendorRow = rowccon02sog00_array.getROWCCON02SOG00(ContextHelper.getIntSafe(context, "rbVendor"));
      resourceAddress = vendorRow.getUlIdRsrcAddress();

    } catch (Exception e) {
      e.printStackTrace();
    }
    ccon03si.setUlIdRsrcAddress(resourceAddress);

    if (ccon02so != null && ccon02so.getTsLastUpdate() != null) {
      ccon03si.setTsLastUpdate(ccon02so.getTsLastUpdate());
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      ccon03si.setTsLastUpdate(ccon02so.getTsLastUpdate());
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    ccon03si.setArchInputStruct(input);

    return ccon03si;

  }

  /**
   * This method is used to Delete a Contract Period from the Contract Period List. It calls the populateCCON06SI_Update
   * method. It is called when a user Selects a Contract Period and clicks the Delete button.
   *
   * @param context
   *          Context for the request
   */
  public void deleteContractPeriod_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".deleteContractPeriod_xa()");

    HttpServletRequest request = context.getRequest();
    // SIR 18077 Imported State and Cleared the CCON07SO object so the Detail
    // Page would not erroneously display a deleted Version's information.
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAttribute("CCON07SO", request);
    
    try {
      CCON06SI ccon06si = populateCCON06SI_Update(context, ServiceConstants.REQ_FUNC_CD_DELETE);
      financials.saveContractPeriod(ccon06si);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_INVALID_PARENT_UNIT:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(errorCode, "/financials/Contracts/displayContractPeriod", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is used to display the Contract Period Detail page. It is called when the user clicks a hyperlink in
   * the Contract Period List.
   *
   * @param context
   *          Context for the request
   */
  public void displayContractPeriod_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayContractPeriod_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
    // Added following line to prevent nullpointer exception
    if (ccon02so != null) {
      request.setAttribute("CntrctFuncType", ccon02so.getSzCdCntrctFuncType());
    }

    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }
    // Get Period Number from the hidden field on the JSP
    int periodNumber = ContextHelper.getIntSafe(context, "hdnContractPeriod");

    // Create object to hold the Period Detail information. Will get the element
    // from the array to populate the detail page
    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);

    ROWCCON05SOG00 periodDetail = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(periodNumber);
    request.setAttribute("periodDetail", periodDetail);
    GlobalData.setUlNbrCnperPeriod(periodDetail.getUlNbrCnperPeriod(), request);
    
    // STGAP00017058 - set page mode to edit for fiscal ops users
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // check to see if user is the Fiscal Operations State Office Maintainer
    if(periodDetail != null && common.hasSecurityClass(user.getUserID(), FISC_OPS_MAINT) && periodDetail.getUlNbrCnperPeriod() == ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00Count()){
      // set page mode to edit and add attribute to state to signify that we are in edit plus mode
      //PageMode.setPageMode(PageModeConstants.EDIT, request);
      request.setAttribute("editPlus", true);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }

    performanceTrace.exitScope();

  }

  /**
   * This method is used to display the Contract Version Detail page in New mode. It is called when the user clicks the
   * Add button in the Contract Version List.
   *
   * @param context
   *          Context for the request
   */
  public void displayNewContractVersion_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayNewContractVersion_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);

    int periodNumber = ContextHelper.getIntSafe(context, "hdnContractPeriod");
    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
    ROWCCON05SOG00 periodDetail = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(periodNumber);
    request.setAttribute("closureDateString", periodDetail.getDtDtCnperClosure().toDate().toString());
    if ("Y".equals(periodDetail.getCIndCnperSigned())) {
      request.setAttribute("periodSigned", "Y");
    }

    int versionNumber = 0;
    if (ccon07so != null && ccon07so.getROWCCON07SOG00_ARRAY() != null
        && ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00Count() > 0) {
      versionNumber = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00Count();
      ROWCCON07SOG00 previousVersionDetail = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(0);
      if (!"Y".equals(previousVersionDetail.getCIndCnverVerLock())) {
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CON_VER_NOT_LCKD), request);
        try {
          forward(DISPLAY_URI, request, context.getResponse());
        } catch (Exception e) {
          GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
          e.printStackTrace();
        }
        return;
      }
    }
    request.setAttribute("addVersionNumber", versionNumber);

    // SIR 23111 - If the period is closed, use the early term
    // date as the period end date (set as version end date in the page)
    // otherwise use the term date
    if (CodesTables.CCONSTAT_CLT.equals(periodDetail.getSzCdCnperStatus())) {
      request.setAttribute("periodEndDate", periodDetail.getDtDtCnperClosure());
    } else {
      request.setAttribute("periodEndDate", periodDetail.getDtDtCnperTerm());
    }
    // SIR 17253 Set this into the request so the page knows what mode it is in
    request.setAttribute("dataAction", ServiceConstants.REQ_FUNC_CD_ADD);

    PageMode.setPageMode(PageModeConstants.NEW, request);
    performanceTrace.exitScope();

  }

  /**
   * This method is used to display the Contract Period Detail page in New mode. It is called when the user clicks the
   * Add button in the Contract Period List.
   *
   * @param context
   *          Context for the request
   */

  public void displayNewContractPeriod_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayNewContractVersion_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);

    if (ccon05so != null && ccon05so.getROWCCON05SOG00_ARRAY() != null
        && ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00Count() > 0) {
      ROWCCON05SOG00 periodDetail = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(0);
      if (!"Y".equals(periodDetail.getCIndCnperSigned())) {
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_CON_PER_NOT_SIGN), request);
        try {
          forward(DISPLAY_URI, request, context.getResponse());
        } catch (Exception e) {
          GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
          e.printStackTrace();
        }
        return;
      }
      GlobalData.setUlNbrCnperPeriod(periodDetail.getUlNbrCnperPeriod() + 1, request);
    } else {
      GlobalData.setUlNbrCnperPeriod(1, request);
    }
    PageMode.setPageMode(PageModeConstants.NEW, context.getRequest());
    performanceTrace.exitScope();
  }

  /**
   * This method is used to display the Contract Version Detail page. It is called when the user clicks a hyperlink in
   * the Contract Version List.
   *
   * @param context
   *          Context for the request
   */
  public void displayContractVersion_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayContractVersion_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);

    // Set Version number into Global Data
    int versionNumber = ContextHelper.getIntSafe(context, "hdnContractVersion");
    GlobalData.setUlNbrCnverVersion(versionNumber, request);

    int loopCount = ContextHelper.getIntSafe(context, "hdnLoopCount");

    int periodNumber = ContextHelper.getIntSafe(context, "hdnContractPeriod");
    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
    ROWCCON05SOG00 periodDetail = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(periodNumber);
    request.setAttribute("closureDateString", periodDetail.getDtDtCnperClosure().toDate().toString());
    if ("Y".equals(periodDetail.getCIndCnperSigned())) {
      request.setAttribute("periodSigned", "Y");
    }

    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }
    
    // Create object to hold the Version Detail information. Will get the element
    // from the array to populate the detail page
    ROWCCON07SOG00 versionDetail = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(loopCount);
    
    //STGAP00017058 - set page in Edit mode for fiscal ops users
    // get the id of the current user
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // check to see if user is the Fiscal Operations State Office Maintainer
    if(versionDetail != null && common.hasSecurityClass(user.getUserID(), FISC_OPS_MAINT) && versionDetail.getUlNbrCnverVersion() == ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00Count()){
      // set page mode to edit and add attribute to state to signify that we are in edit plus mode
      //PageMode.setPageMode(PageModeConstants.EDIT, request);
      request.setAttribute("editPlus", true);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }

    request.setAttribute("versionDetail", versionDetail);
    // SIR 17253 Set this into the request so the page knows what mode it is in
    request.setAttribute("dataAction", ServiceConstants.REQ_FUNC_CD_UPDATE);

    performanceTrace.exitScope();
  }

  /**
   * This method is used to display the Budget Transfer page. It is called when the user selects a Period and clicks the
   * Transfer hyperlink.
   *
   * @param context
   *          Context for the request
   */
  public void displayBudgetTransfer_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayBudgetTransfer_xa()");

    CCON09SI ccon09si = new CCON09SI();
    ArchInputStruct budgetInput = new ArchInputStruct();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    budgetInput.setSzUserId(user.getUserLogonID());
    budgetInput.setUsPageNbr(1);
    budgetInput.setUlPageSizeNbr(50);
    CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);
    ROWCCON07SOG00 version = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(0);
    GlobalData.setUlNbrCnverVersion(version.getUlNbrCnverVersion(), request);

    ccon09si.setArchInputStruct(budgetInput);
    ccon09si.setUlIdContract(GlobalData.getUlIdContract(request));
    ccon09si.setUlNbrCnverPeriod(GlobalData.getUlNbrCnperPeriod(request));
    ccon09si.setUlNbrCnverVersion(GlobalData.getUlNbrCnverVersion(request));
    try {

      CCON09SO ccon09so = financials.retrieveBudgetTransfer(ccon09si);
      state.setAttribute("CCON09SO", ccon09so, request);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + e.getMessage());
    }

    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is used to Save the Contract Period Detail JSP. It is called when the user clicks the Save button on
   * the ontract Period Detail JSP. It calls the populateCCON06SI_Update method.
   *
   * @param context
   *          Context for the request
   */
  public void saveContractPeriodDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".SaveContractPeriodDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      String dataAction = "";
      // if the page was in new mode, this is an add
      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
        dataAction = ServiceConstants.REQ_FUNC_CD_ADD;
      } else {
        dataAction = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }

      // page data and validate service output populates and calls save service
      CCON06SI ccon06si = populateCCON06SI_Update(context, dataAction);
      financials.saveContractPeriod(ccon06si);

    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure in CCON06S:" + we.getMessage());

      this.setPresentationBranch("error", context);

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_CON_CLOSURE_AFTER_EFF:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CON_START_LAST_TERM:
      case Messages.MSG_CON_INVLD_PER:
      case Messages.MSG_CON_PER_SIGN_WO_SERV:
      case Messages.MSG_CON_COUNTY_VIOLATION:
      case Messages.MSG_CON_VERSION_UNLOCK:
      case Messages.SSM_INVD_CLOSURE_DT:
      case Messages.MSG_DATABASE_SAVE_FAIL:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, "/financials/Contracts/saveContractPeriodDetail", request);
        break;
      case Messages.MSG_SAME_EFF_AND_END_DT:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_SAME_EFF_AND_END_DT, request);
        break;
      case Messages.MSG_EFF_DT_SAME_PREV_EFF_DT:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_EFF_DT_SAME_PREV_EFF_DT, request);
        break;
      case Messages.MSG_END_DT_TWO_DAYS:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_END_DT_TWO_DAYS, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
    return;
  }

  /**
   * This Method is used to populate the input object for a Save on the Contract Period Detail page. It is called by the
   * saveContractPeriodDetail method.
   *
   * @param context
   *          Context for the request
   * @param dataAction
   *          dataAction
   * @return ccon06si
   */
  private CCON06SI populateCCON06SI_Update(GrndsExchangeContext context, String dataAction) {

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
    CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);

    ArchInputStruct input = new ArchInputStruct();
    CCON06SI ccon06si = new CCON06SI();
    ROWCCON06SIG00_ARRAY periodArrayIn = new ROWCCON06SIG00_ARRAY();
    ROWCCON06SIG00 periodRow = new ROWCCON06SIG00();
    //STGAP00017058
    String isEditPlusMode = (String) ContextHelper.getStringSafe(request, "isEditPlusMode");

    int index = 0;
    index = ContextHelper.getIntSafe(context, "hdnContractPeriod");

    input.setUlPageSizeNbr(1);
    input.setUsPageNbr(1);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    input.setSzUserId(user.getUserLogonID());
    int contractId = GlobalData.getUlIdContract(context.getRequest());
    ccon06si.setUlIdContract(contractId);
    ccon06si.setUlIdCntrctWkr(UserProfileHelper.getUserProfile(request).getUserID());
    // SIR 17595 GRIMSHAN, statically set the indicator to Y so that the
    // version's effective date will be over written with whatever is in the
    // start date of the period
    ccon06si.setCIndRsrcTransport("Y");
    ccon06si.setSzCdCntrctFuncType(ccon02so.getSzCdCntrctFuncType());

    // hdnContractPeriod is the array element number, which is 1 less than the
    // Period number
    
    // get the profile of the user
    UserProfile userProfile = UserProfileHelper.getUserProfile(context);

    String status = ContextHelper.getStringSafe(context, "cboStatus");
    periodRow.setDtDtCnperStart(ContextHelper.getCastorDateSafe(context, "txtStart"));
    periodRow.setDtDtCnperTerm(ContextHelper.getCastorDateSafe(context, "txtTerm"));
    periodRow.setSzCdCnperStatus(status);
    periodRow.setCIndCnperRenewal(CheckboxHelper.getCheckboxValue(context.getRequest(), "cbxRenewal"));
    periodRow.setCIndCnperSigned(CheckboxHelper.getCheckboxValue(context.getRequest(), "cbxSigned"));
    periodRow.setCSysIndCnperStartMod(ContextHelper.getStringSafe(context, "hdnCSysIndCnperStartMod"));
    periodRow.setCSysIndCnperTermMod(ContextHelper.getStringSafe(context, "hdnCSysIndCnperTermMod"));
    periodRow.setSzTxtCnperClosureCmt(ContextHelper.getStringSafe(context, "txtEarlyTermCmt"));
    periodRow.setTxtLastUpdatedBy(userProfile.getUserFullName());

    int numRows = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00Count();

    // Closure date has been changed to early term date in IMPACT.
    if (dataAction.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      periodRow.setUlNbrCnperPeriod(numRows + 1);
    } else {
      periodRow.setTsLastUpdate(ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(index).getTsLastUpdate());
      periodRow.setUlNbrCnperPeriod(ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(index).getUlNbrCnperPeriod());
    }
    // SIR 18533 GRIMSHAN -- If the period status is closed or pending
    // termination, save the early term date as the closure date, otherwise save
    // the termination date as the early termination date.
    if ("CLT".equals(status) || "PNT".equals(status)) {
      periodRow.setDtDtCnperClosure(ContextHelper.getCastorDateSafe(context, "txtEarly"));
    } else {
      periodRow.setDtDtCnperClosure(ContextHelper.getCastorDateSafe(context, "txtTerm"));
    }

    periodRow.setSzCdScrDataAction(dataAction);
    periodArrayIn.addROWCCON06SIG00(periodRow);
    ccon06si.setROWCCON06SIG00_ARRAY(periodArrayIn);
    ccon06si.setArchInputStruct(input);
    //STGAP00017058
    ccon06si.setBIndReview(isEditPlusMode != null ? isEditPlusMode : "N");

    return ccon06si;
  }

  /**
   * This method is used to Save the Contract Version Detail JSP. It is called when the user clicks the Save button on
   * the contract Version Detail JSP. It calls the populateCCON08SI_Update method.
   *
   * @param context
   *          Context for the request
   */
  public void saveContractVersionDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".SaveContractVersionDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      String actionCode = "";
      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
        actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
      } else {
        actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      }

      // page data and validate service output populates and calls save service
      CCON08SI ccon08si = populateCCON08SI_Update(context, actionCode);
      financials.saveContractVersion(ccon08si);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.SSM_VERS_BEFORE_CLOSURE:
      case Messages.MSG_CON_INVALID_BUDG:
      case Messages.MSG_CON_NO_SERVICES:
      case Messages.MSG_DATABASE_SAVE_FAIL:
      case Messages.MSG_CON_INVLD_PER:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, "/financials/Contracts/saveContractVersionDetail", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
    return;
  }

  /**
   * This Method is is used to populate the input object for a Save on the Contract Version Detail page. It is called by
   * the saveContractVersionDetail method.
   *
   * @param context
   *          Context for the request
   * @param dataAction
   *          dataAction
   * @return ccon08si
   */
  private CCON08SI populateCCON08SI_Update(GrndsExchangeContext context, String dataAction) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);

    if (ccon07so == null) {
      ccon07so = new CCON07SO();
    }

    ArchInputStruct input = new ArchInputStruct();
    CCON08SI ccon08si = new CCON08SI();
    ROWCCON08SIG00_ARRAY versionArrayIn = new ROWCCON08SIG00_ARRAY();
    ROWCCON08SIG00 versionRow = new ROWCCON08SIG00();

    // Save starts here
    input.setCReqFuncCd("");
    input.setUlPageSizeNbr(1);
    input.setUsPageNbr(0);
    input.setSzUserId(user.getUserLogonID());
    ccon08si.setArchInputStruct(input);

    int contractId = GlobalData.getUlIdContract(context.getRequest());
    // STGAP00017058
    String isEditPlusMode = (String) ContextHelper.getStringSafe(request, "isEditPlusMode");

    ccon08si.setUlIdContract(contractId);
    ccon08si.setUlIdCntrctWkr(UserProfileHelper.getUserProfile(request).getUserID());
    ccon08si.setUlNbrCnverPeriod(GlobalData.getUlNbrCnperPeriod(context.getRequest()));
    ccon08si.setCIndCntrctBudgLimit(ContextHelper.getStringSafe(request, "hdnContractBudgetLimit"));
    
    // STGAP00017058
    ccon08si.setBIndReview(isEditPlusMode != null ? isEditPlusMode : "N");

    if (request.getParameter("txtEffective") == null) {
      versionRow.setDtDtCnverEffective(ContextHelper.getCastorDateSafe(context, "hdnTxtEffective"));
    } else {
      versionRow.setDtDtCnverEffective(ContextHelper.getCastorDateSafe(context, "txtEffective"));
    }

    String indLocked = ArchitectureConstants.N;

    // SIR 17245 If the locked checkbox is available from the request, use that
    // value, else use the hidden field value if it is not blank, otherwise it
    // is left as "N"
    if (request.getParameter("cbxLocked") != null) {
      indLocked = CheckboxHelper.getCheckboxValue(request, "cbxLocked");
    } else if (!"".equals(ContextHelper.getStringSafe(request, "hdnLocked"))) {
      indLocked = ContextHelper.getStringSafe(request, "hdnLocked");
    }

    versionRow.setCIndCnverVerLock(indLocked);
    versionRow.setSzTxtCnverComment(ContextHelper.getStringSafe(context, "txtComment"));

    // SIR 17911 -- For adding a version row the service need "N" passed the the
    // following two variables: setBIndEndDateMod and setBSysIndVersionLockMod.
    versionRow.setBIndEndDateMod("N");
    versionRow.setBSysIndVersionLockMod("N");

    versionRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);

    //int numRowVer = 0;
    //if (ccon07so != null && ccon07so.getROWCCON07SOG00_ARRAY() != null) {
    //  numRowVer = ccon07so.getROWCCON07SOG00_ARRAY().getUlRowQty();
    //}

    if ("U".equals(dataAction)) {
      versionRow.setUlNbrCnverVersion(ContextHelper.getIntSafe(context, "txtVersion"));
      versionRow.setDtDtCnverEnd(ContextHelper.getCastorDateSafe(context, "txtEnd"));
      versionRow.setDtDtCnverCreate(ContextHelper.getCastorDateSafe(context, "txtCreated"));
      versionRow.setUlIdCnver(ContextHelper.getIntSafe(context, "hdnUlIdCnver"));
      versionRow.setTsLastUpdate(ContextHelper.getJavaDateSafe(context, "hdnTsLastUpdate"));
      // SIR 17911 -- For updating a version row the service needs "Y" passed
      // the the following two variables: setBIndEndDateMod and
      // setBSysIndVersionLockMod. This update will re-calculate balances on
      // the Contract Service List.
      versionRow.setBIndEndDateMod("Y");

      versionRow.setBSysIndVersionLockMod("N");
      //corey
      versionRow.setTxtLastUpdatedBy(user.getUserFullName());
      versionRow.setDtDtPrevCnverEffective(ContextHelper.getCastorDateSafe(context, "hdnTxtEffective"));
      if ("N".equals(request.getParameter("hdnLocked")) && request.getParameter("cbxLocked") != null) {
        versionRow.setBSysIndVersionLockMod("Y");
      }
    } else {
      versionRow.setUlNbrCnverVersion(ContextHelper.getIntSafe(context, "txtVersion"));
      versionRow.setDtDtCnverEnd(ContextHelper.getCastorDateSafe(context, "txtEnd"));
      versionRow.setDtDtCnverCreate(new org.exolab.castor.types.Date(new java.util.Date()));
      versionRow.setUlIdCnver(0);
      // If a new version has been added, update the previous version by setting
      // it's end date to one day prior to the added version's effective date.
      // And Set BIndEndDateMod to Y and update the previous row and add the new
      // row on save.

      ROWCCON07SOG00 previousVersionOutputRow = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(0);
      ROWCCON08SIG00 previousVersionInputRow = new ROWCCON08SIG00();
      previousVersionInputRow.setTsLastUpdate(previousVersionOutputRow.getTsLastUpdate());
      previousVersionInputRow.setUlNbrCnverVersion(previousVersionOutputRow.getUlNbrCnverVersion());
      previousVersionInputRow.setDtDtCnverEffective(previousVersionOutputRow.getDtDtCnverEffective());
      previousVersionInputRow.setDtDtCnverEnd(DateHelper.addToDate(versionRow.getDtDtCnverEffective(), 0, 0, -1));
      previousVersionInputRow.setDtDtCnverCreate(previousVersionOutputRow.getDtDtCnverCreate());
      previousVersionInputRow.setUlIdCnver(previousVersionOutputRow.getUlIdCnver());
      previousVersionInputRow.setCIndCnverVerLock(previousVersionOutputRow.getCIndCnverVerLock());
      previousVersionInputRow.setUlNbrCnverNoShowPct(previousVersionOutputRow.getUlNbrCnverNoShowPct());
      previousVersionInputRow.setSzTxtCnverComment(previousVersionOutputRow.getSzTxtCnverComment());
      previousVersionInputRow.setBIndEndDateMod("Y");
      // Sir 19670 -- The setBSysIndVersionLockMod should be set to "N" not "Y".
      // Previous version should have already been locked.
      previousVersionInputRow.setBSysIndVersionLockMod(ArchitectureConstants.N);
      previousVersionInputRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);

      versionArrayIn.addROWCCON08SIG00(previousVersionInputRow);
      input.setUlPageSizeNbr(2);

    }

    versionRow.setSzCdScrDataAction(dataAction);
    versionArrayIn.addROWCCON08SIG00(versionRow);
    ccon08si.setROWCCON08SIG00_ARRAY(versionArrayIn);

    return ccon08si;
  }

  /**
   * This method saves the information on the Budget Transfer JSP. It also performs the tranfer of money from one Budget
   * Expense category to another. It calls the populateCCON10SI_Update method. It is called when a user clicks the
   * Transfer button.
   *
   * @param context
   *          Context for the request
   */
  public void saveBudgetTransfer_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".saveBudgetTransfer_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    //CCON10SO ccon10so = new CCON10SO();
    try {

      // subString() used instead of StringTokenizer due to performance issues.
      String fromRow = ContextHelper.getStringSafe(request, "rbBudgetTransferFrom");
      String toRow = ContextHelper.getStringSafe(request, "rbBudgetTransferTo");
      double transferAmount = ContextHelper.getMoneyAsDoubleSafe(request, "txtUlIdTransferAmount");
      int fromIndex = Integer.parseInt(fromRow.substring(fromRow.indexOf("_") + 1, fromRow.length()));
      int toIndex = Integer.parseInt(toRow.substring(toRow.indexOf("_") + 1, toRow.length()));
      String fromRowType = fromRow.substring(0, fromRow.indexOf("_"));
      String toRowType = toRow.substring(0, toRow.indexOf("_"));

      // Here, get ccon09so out of state and get the row array off it.
      CCON09SO ccon09so = (CCON09SO) state.getAttribute("CCON09SO", request);
      ROWCCON09SOG00_ARRAY TranferRows = ccon09so.getROWCCON09SOG00_ARRAY();

      // Use the fromIndex and toIndex to get the proper row out of the array.
      ROWCCON09SOG00 fromRowItem = TranferRows.getROWCCON09SOG00(fromIndex);

      ROWCCON09SOG00 toRowItem = TranferRows.getROWCCON09SOG00(toIndex);
      // Use the fromRowType and toRowType to get the proper amount off the
      // respective rows. Math validation happens here, and if it fails, an
      // error message is set. If it doesn't fail, it sets the new values based
      // on the amount transfered, then it populates the ccon10si row array
      // with the rows from the ccon09 row array just changed.

      double fromBalance = 0;
      double fromBalanceUsed = 0;

      if ("Salary".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcSalary();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcSalaryUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcSalary(fromRowItem.getUlAmtCnsvcSalary() - transferAmount);
        }
      } else if ("Fringe".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcFrgBenft();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcFrgBenftUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcFrgBenft(fromRowItem.getUlAmtCnsvcFrgBenft() - transferAmount);
        }
      } else if ("Travel".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcTravel();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcTravelUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcTravel(fromRowItem.getUlAmtCnsvcTravel() - transferAmount);
        }
      } else if ("Supply".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcSupply();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcSupplyUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcSupply(fromRowItem.getUlAmtCnsvcSupply() - transferAmount);
        }
      } else if ("Equip".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcEquip();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcEquipUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcEquip(fromRowItem.getUlAmtCnsvcEquip() - transferAmount);
        }
      } else if ("Other".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcOther();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcOtherUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed - fromRowItem.getUlAmtCnsvcAdminAllUsed())) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcOther(fromRowItem.getUlAmtCnsvcOther() - transferAmount);
        }
      } else if ("UnitRate".equals(fromRowType)) {
        fromBalance = fromRowItem.getUlAmtCnsvcUnitRate();
        fromBalanceUsed = fromRowItem.getUlAmtCnsvcUnitRateUsed();
        if (transferAmount > (fromBalance - fromBalanceUsed)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_CON_INSUFFICIENT_BUDG),
                          "txtUlIdTransferAmount", request);
          return;
        } else {
          fromRowItem.setUlAmtCnsvcUnitRate(fromRowItem.getUlAmtCnsvcUnitRate() - transferAmount);
        }
      }

      if ("Salary".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcSalary(toRowItem.getUlAmtCnsvcSalary() + transferAmount);
      } else if ("Fringe".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcFrgBenft(toRowItem.getUlAmtCnsvcFrgBenft() + transferAmount);
      } else if ("Travel".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcTravel(toRowItem.getUlAmtCnsvcTravel() + transferAmount);
      } else if ("Supply".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcSupply(toRowItem.getUlAmtCnsvcSupply() + transferAmount);
      } else if ("Equip".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcEquip(toRowItem.getUlAmtCnsvcEquip() + transferAmount);
      } else if ("Other".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcOther(toRowItem.getUlAmtCnsvcOther() + transferAmount);
      } else if ("UnitRate".equals(toRowType)) {
        toRowItem.setUlAmtCnsvcUnitRate(toRowItem.getUlAmtCnsvcUnitRate() + transferAmount);
      }

      // use page data and output of validate service to populate and call save service
      CCON10SI ccon10si = populateCCON10SI_Update(context);
      financials.saveContractService(ccon10si);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_DATABASE_SAVE_FAIL:
        setErrorMessage(errorCode, "/financials/Contracts/displayContractPeriod", request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is used by the saveBudget Transfer_xa mehtod to populate the input object for the Budget Transfer
   * Save/Transfer after the user clicks the Transfer button.
   *
   * @param context
   *          Context for the request
   * @return ccon10si
   */
  private CCON10SI populateCCON10SI_Update(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCON09SO ccon09so = (CCON09SO) state.getAttribute("CCON09SO", request);
    ROWCCON09SOG00_ARRAY BudgetTransferArrayOut = ccon09so.getROWCCON09SOG00_ARRAY();

    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CCON10SI ccon10si = new CCON10SI();

    ROWCCON10SIG00_ARRAY BudgetTransferArrayIn = new ROWCCON10SIG00_ARRAY();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    input.setCReqFuncCd("");
    input.setUlPageSizeNbr(BudgetTransferArrayOut.getROWCCON09SOG00Count());

    input.setUsPageNbr(0);
    input.setSzUserId(user.getUserLogonID());
    ccon10si.setArchInputStruct(input);

    int i = 0;
    int loopCount = 0;

    // Loop through budget expense categories for update
    Enumeration e = BudgetTransferArrayOut.enumerateROWCCON09SOG00();
    while (e.hasMoreElements()) {
      ROWCCON09SOG00 outBudgetRow = (ROWCCON09SOG00) e.nextElement();

      ROWCCON10SIG00 inBudgetRow = new ROWCCON10SIG00();
      inBudgetRow.setUlIdCnsvc(outBudgetRow.getUlIdCnsvc());
      inBudgetRow.setSzCdCnsvcPaymentType(outBudgetRow.getSzCdCnsvcPaymentType());
      inBudgetRow.setSzCdCnsvcPaymentType(outBudgetRow.getSzCdCnsvcPaymentType());
      inBudgetRow.setSzCdCnsvcService(outBudgetRow.getSzCdCnsvcService());
      inBudgetRow.setUlAmtCnsvcSalary(outBudgetRow.getUlAmtCnsvcSalary());
      inBudgetRow.setUlAmtCnsvcFrgBenft(outBudgetRow.getUlAmtCnsvcFrgBenft());
      inBudgetRow.setUlAmtCnsvcTravel(outBudgetRow.getUlAmtCnsvcTravel());
      inBudgetRow.setUlAmtCnsvcSupply(outBudgetRow.getUlAmtCnsvcSupply());
      inBudgetRow.setUlAmtCnsvcEquip(outBudgetRow.getUlAmtCnsvcEquip());
      inBudgetRow.setUlAmtCnsvcOther(outBudgetRow.getUlAmtCnsvcOther());
      inBudgetRow.setUlAmtCnsvcUnitRate(outBudgetRow.getUlAmtCnsvcUnitRate());
      inBudgetRow.setTsLastUpdate(outBudgetRow.getTsLastUpdate());
      inBudgetRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      BudgetTransferArrayIn.addROWCCON10SIG00(inBudgetRow);
      loopCount++;
    }
    i++;

    ccon10si.setUlIdContract(GlobalData.getUlIdContract(request));
    ccon10si.setUlIdCntrctWkr(UserProfileHelper.getUserProfile(request).getUserID());
    ccon10si.setUlNbrCnsvcPeriod(GlobalData.getUlNbrCnperPeriod(context.getRequest()));
    ccon10si.setUlNbrCnsvcVersion(GlobalData.getUlNbrCnverVersion(context.getRequest()));
    ccon10si.setROWCCON10SIG00_ARRAY(BudgetTransferArrayIn);
    return ccon10si;
  }
  
  public static boolean optionsContainsCode(Collection<? extends Mapping> options, String code) {
    if(options == null || options.isEmpty()) {
      return false;
    }
    for(Mapping mapping : options) {
      if(mapping != null && mapping.getKey() != null && mapping.getKey().equals(code)) {
        return true;
      }
    }
    return false;
  }

  public static final String TRACE_TAG = "Contracts";

  public static final int RESULTS_PER_PAGE = 300;

  public static final String DISPLAY_URI = "/financials/Contracts/displayContractHeader";

  public static final String CONTRACT_BROWSE = "B";

  public static final String CONTRACT_MODIFY = "M";
}