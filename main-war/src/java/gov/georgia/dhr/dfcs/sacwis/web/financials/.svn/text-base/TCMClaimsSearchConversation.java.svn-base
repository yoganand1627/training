package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimsSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitHierarchyRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierarchicalUnit;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimValidateSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimsSearchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnitHierarchyRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * 
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  ----------------------------------------------
 * 03/26/09  Van Vo      MR-026 STGAP00013024: adding new claim status Non Re-billable for denied or rejected claim that 
 *                       should not be attempted re-bill. 
 * 06/09/10  hnguyen     SMS# 37382: Updated so validation service is called only when denied/rejected status claim is 
 *                       resubmitted with Resubmit checkbox selected, not when Non-Rebillable is selected.                     
 * </pre>
 *
 */

@SuppressWarnings("serial")
public class TCMClaimsSearchConversation extends BaseHiddenFieldStateConversation {

  public static final String STATUS_CODES_TABLES = CodesTables.CTCMSTAT;
// MR-026 STGAP00013024 - ADD NRB: NON RE-BILLABLE TO STATUS THAT CAN BE RESUBMITTED
  public static final List<String> RESUBMIT_STATUS_LIST = Arrays.asList(new String[] { CodesTables.CTCMSTAT_DND,
                                                                                      CodesTables.CTCMSTAT_REJ,
                                                                                      CodesTables.CTCMSTAT_NRB });
// LIST OF STATUS THAT NON RE-BILLABLE IS ENABLED TO
  public static final List<String> NO_REBILL_STATUS_LIST = Arrays.asList(new String[] { CodesTables.CTCMSTAT_DND,
                                                                                       CodesTables.CTCMSTAT_REJ });

  public static final String NO_REBILL_STATUS = CodesTables.CTCMSTAT_NRB;

  public static final String DENIAL_REASON_CODES_TABLES = CodesTables.CTCMDEN;

  public static final String DISPLAY_TCM_CLAIMS = "/financials/TCMClaimsSearch/displayTCMClaims";

  public static final String COUNTY_OPTIONS_NAME = "TCMCountyOptions";

  public static final String SEARCH_RESULTS_NAME = "TCMClaimsList";

  public static final String SEARCH_CRITERIA_NAME = "TCMClaimsSearchSI";

  public static final int USER_CLASS_CASE_MGR = 1;

  public static final int USER_CLASS_SUPERVISOR = 2;

  public static final int USER_CLASS_BILLING_UNIT = 3;

  private Common common;

  private Financials financials;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  /**
   * Called when the user clicks the TCM Claims tab
   * 
   * @param context
   */
  public void displayTCMClaims_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayTCMClaims_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(context.getRequest());

    HttpServletRequest request = context.getRequest();
    List<CodeAttributes> countyOptions = getCountyOptions(request);
    state.setAttribute(COUNTY_OPTIONS_NAME, countyOptions, request);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Called when the user clicks on the search button on the TCM Claims page
   * 
   * @param context
   */
  public void searchTCMClaims_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchTCMClaims_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    state.removeAttribute(SEARCH_RESULTS_NAME, request);
    performSearch(context, state, false);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  @SuppressWarnings("unchecked")
  public void resubmitTCMClaims_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".resubmitTCMClaims_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String[] claimResubmitIndexArray = CheckboxHelper.getCheckedValues(request, "cbxResubmit_");
    String[] claimNoRebillIndexArray = CheckboxHelper.getCheckedValues(request, "cbxNoRebill_");
    String[] claimIndexArray;
    int resubmitIndexArrayLen = claimResubmitIndexArray.length;
    int noRebillIndexArrayLen = claimNoRebillIndexArray.length;
    // MR-026 STGAP00013024
    if (resubmitIndexArrayLen > 0 && noRebillIndexArrayLen > 0) {
      setInformationalMessage(Messages.MSG_TCM_MULTPL_CBX_VAL, request);
      return;
    }

    if (resubmitIndexArrayLen < 1 && noRebillIndexArrayLen < 1) {
      setInformationalMessage(Messages.MSG_SELECT_ROW_ACTION, request);
      return;
    }

    if (resubmitIndexArrayLen > 0) {
      claimIndexArray = claimResubmitIndexArray.clone();
    } else {
      claimIndexArray = claimNoRebillIndexArray.clone();
    }
    // end MR-026 STGAP00013024

    BaseSessionStateManager state = getSessionStateManager(context);
    List<TCMClaimsSearchSO> tcmClaimsList = (List<TCMClaimsSearchSO>) state.getAttribute(SEARCH_RESULTS_NAME, request);

    // try {
    for (String index : claimIndexArray) {
      TCMClaimsSearchSO searchSO = tcmClaimsList.get(Integer.parseInt(index));
      TCMClaimSaveSI si = new TCMClaimSaveSI();
      TCMClaimValidateSO so = null;

      if (resubmitIndexArrayLen > 0) { // MR-026 STGAP00013024: resubmit action: continue with normal (existing) flow
        /* SMS# 37382: validation service to be called when Denied/Rejected/Non Rebillable status 
        *  claim is submitted with Resubmit
        */
        try {
          // -- first validate
          si.setIdEvent(searchSO.getUlIdEvent());
          so = financials.validateTCMClaim(si);
        } catch (ServiceException se) {
          int errorCode = se.getErrorCode();
          switch (errorCode) {
          case Messages.MSG_SVC_TCM_EXISTS_RSU:
          case Messages.MSG_SVC_TCM_DOB_RSU:
          case Messages.MSG_SVC_TCM_ID_RSU:
            setErrorMessage(addMessageParameters(MessageLookup.getMessageByNumber(errorCode), searchSO), request);
            break;
          default:
            processSevereException(context, se);
            break;
          }
          continue;
        } catch (Throwable t) {
          processSevereException(context, t);
        }
        // -- if validation passes, update status of old TCM claim and create new
        si.setNbrTCN(searchSO.getUlTCNNumber());
        si.setIdTcmClaimResubmitted(searchSO.getUlIdTcmClaim());
        populateResubmitSI(si, so);
      } else { // MR-026 STGAP00013024: no rebill action: only need the claim ID and the indicator 'no rebill' for Save service
        si.setIdTcmClaimResubmitted(searchSO.getUlIdTcmClaim());
        si.setNoRebill(true);
      }
      try {
        financials.saveTCMClaim(si);
      } catch (Throwable t) {
        processSevereException(context, t);
      }
    }
    performSearch(context, state, true);
    // } catch(ServiceException se) {
    // int errorCode = se.getErrorCode();
    // switch(errorCode) {
    // case Messages.MSG_SVC_TCM_EXISTS:
    // case Messages.MSG_SVC_TCM_DOB:
    // case Messages.MSG_SVC_TCM_ID:
    // setErrorMessage(errorCode, request);
    // break;
    // default:
    // processSevereException(context, se);
    // break;
    // }
    // } catch(Throwable t) {
    // processSevereException(context, t);
    // }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public static int getTCMUserClass(HttpServletRequest request) {
    UserProfile user = UserProfileHelper.getUserProfile(request);
    if (user.hasRight(UserProfile.SEC_RESUBMIT_TCM_CLAIMS)) {
      return USER_CLASS_BILLING_UNIT;
    } else if (user.getSysSupervisorAccess()) {
      return USER_CLASS_SUPERVISOR;
    } else {
      return USER_CLASS_CASE_MGR;
    }
  }

  private List<CodeAttributes> getCountyOptions(HttpServletRequest request) {
    int userClass = getTCMUserClass(request);
    if (userClass == USER_CLASS_BILLING_UNIT) {
      try {
        return Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCOUNT);
      } catch (LookupException le) {
        throw new IllegalStateException("Lookup for CCOUNT codes table failed", le);
      }
    } else if (userClass == USER_CLASS_SUPERVISOR) {
      UnitHierarchyRetrieveSO so = common.retrieveUnitHierarchy(populateUnitHierarchyRetrieveSI(request));
      List<CodeAttributes> options = createCountyOptions(so);
      if (options.isEmpty()) {
        options.add(getUserCounty(request));
      }
      return options;
    } else {
      List<CodeAttributes> options = new ArrayList<CodeAttributes>();
      options.add(getUserCounty(request));
      return options;
    }
  }

  private UnitHierarchyRetrieveSI populateUnitHierarchyRetrieveSI(HttpServletRequest request) {
    UserProfile user = UserProfileHelper.getUserProfile(request);
    UnitHierarchyRetrieveSI si = new UnitHierarchyRetrieveSI(UnitHierarchyRetrieveSI.UNIT_APPROVER_ID, user.getUserID());
    return si;
  }

  private List<CodeAttributes> createCountyOptions(UnitHierarchyRetrieveSO so) {
    List<CodeAttributes> countyOptions = new ArrayList<CodeAttributes>();

    if (so != null) {
      Set<HierarchicalUnit> units = so.getUnits();
      if (units != null && !units.isEmpty()) {
        Set<String> counties = new TreeSet<String>();
        for (HierarchicalUnit hUnit : units) {
          addCountyToSet(counties, hUnit);
        }

        // -- convert Set<String> to List<Mapping>
        for (String county : counties) {
          countyOptions.add(decodeCountySafe(county));
        }
      }
    }

    return countyOptions;
  }

  private void addCountyToSet(Set<String> counties, HierarchicalUnit hUnit) {
    String county = hUnit.getCdCounty();
    if (county != null && !counties.contains(county)) {
      counties.add(county);
    }

    Set<HierarchicalUnit> childUnits = hUnit.getChildUnits();
    if (childUnits != null && !childUnits.isEmpty()) {
      for (HierarchicalUnit childUnit : childUnits) {
        addCountyToSet(counties, childUnit);
      }
    }
  }

  private CodeAttributes getUserCounty(HttpServletRequest request) {
    UserProfile user = UserProfileHelper.getUserProfile(request);
    return decodeCountySafe(user.getUserCounty());
  }

  private CodeAttributes decodeCountySafe(String cdCounty) {
    try {
      return Lookup.decode(CodesTables.CCOUNT, cdCounty);
    } catch (LookupException le) {
      throw new IllegalStateException("Decoding value \"" + cdCounty + "\" against CCOUNT codes table failed", le);
    }
  }

  private String addMessageParameters(String message, TCMClaimsSearchSO searchSO) {
    String m1 = MessageLookup.addMessageParameter(message, searchSO.getSzNmClient());
    return MessageLookup.addMessageParameter(m1, searchSO.getUlIdPerson());
  }

  private void performSearch(GrndsExchangeContext context, BaseSessionStateManager state, boolean resubmit) {
    // Get the search input object
    HttpServletRequest request = context.getRequest();
    TCMClaimsSearchSI tcmClaimsSearchSI;
    if (resubmit) {
      tcmClaimsSearchSI = (TCMClaimsSearchSI) state.getAttribute(SEARCH_CRITERIA_NAME, request);
    } else {
      tcmClaimsSearchSI = populateTCMClaimsSearchSI(context);
      state.setAttribute(SEARCH_CRITERIA_NAME, tcmClaimsSearchSI, request);
    }
    // Retrieve a list of TCM Claims based on search input object
    List<TCMClaimsSearchSO> result = financials.retrieveTCMClaimsList(tcmClaimsSearchSI);
    // Set the list of TCM Claims in the state
    state.setAttribute(SEARCH_RESULTS_NAME, result, request);
  }

  private void populateResubmitSI(TCMClaimSaveSI si, TCMClaimValidateSO so) {
    si.setDtService(so.getDtService());
    si.setIdPerson(so.getIdPerson());
    si.setIdStaff(so.getIdStaff());
    si.setIdStage(so.getIdStage());
    si.setNbrMedicaid(so.getNbrMedicaid());
  }

  // This method populates the TCM Claims search input object it takes GrndsExchangeContext as parameter
  // and returns a TCMClaimsSearchSI
  private TCMClaimsSearchSI populateTCMClaimsSearchSI(GrndsExchangeContext context) {
    TCMClaimsSearchSI si = new TCMClaimsSearchSI();
    si.setUlIdStaff(ContextHelper.getIntSafe(context, "txtIdStaff"));
    si.setIdClient(ContextHelper.getIntSafe(context, "txtIdClient"));
    si.setSzCdCounty(ContextHelper.getStringSafe(context, "selCdCounty"));
    si.setSzUnit(ContextHelper.getStringSafe(context, "txtUnit").toUpperCase());
    si.setMonth(ContextHelper.getIntSafe(context, "txtMonth"));
    si.setUlYear(ContextHelper.getIntSafe(context, "txtYear"));
    si.setSzCdStatus(ContextHelper.getStringSafe(context, "selStatus"));
    return si;
  }

}
