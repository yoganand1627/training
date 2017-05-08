/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.reports;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hong-van.t.vo
 *          Date      User         Description 
 *          --------  -----------  ----------------------------------------------
 *          04/14/09  htvo         STGAP00013329 -  add validation for Invoice report that at least one of the conditionally
 *                                 parameters (resourceID, personID, region) requires input.
 *          
*/
@SuppressWarnings("serial")
public class ReportsCustomValidation extends FormValidation {

  // static constants
  public static final String TRACE_TAG = "ReportsCustomValidation";
  private static final String UDR_CASE_WATCH_ACTIVITY_REPORT = "UDRCaseWatchActRept";
  @SuppressWarnings("unchecked")
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    boolean isValid = true;
    String nmRptSqrName = (String) state.getAttribute("hdnNmRptSqrName", request); 
    String txtRptParmListStr = URLHelper.decode(ContextHelper.getStringSafe(request, ReportTag.PARAMETER_LIST));
    int[] paramPosArray = new int[10]; // define a max number of report's parameters for used in this page only - may be changed if needed to
    int txtRptParmListStrLen = txtRptParmListStr.length();
    int i = -1;
    int k = 0;
    while (i <= txtRptParmListStrLen) {
      i = txtRptParmListStr.indexOf("^", i+1);
      if (-1 == i) {
        break;
      } else {
        paramPosArray[k] = i;
        k++;
      }
    }
    // Invoice report has 7 parameters in the order: begin month, end month, person ID, resource ID, region, county and UAS program. 
    // Jsp will send a param string with a fixed format param1^param2^param3^param4^param5^param6^param7^
    // so there should always 7 '^'s; if a parameter is not entered, the value is '0'
    if ("InvoiceList".equals(nmRptSqrName)) {
      if (paramPosArray.length < 7) {
        isValid = false;
        setErrorMessage("Parameter string not encoded correctly. Please contact SHINES Help Desk for technical support.");
        return isValid;
      } else {
        String personId = txtRptParmListStr.substring((paramPosArray[1]+1), (paramPosArray[2]));
        String resourceId = txtRptParmListStr.substring((paramPosArray[2]+1), (paramPosArray[3]));
        String region = txtRptParmListStr.substring((paramPosArray[3]+1), (paramPosArray[4]));
        if ("0".equals(personId) && "0".equals(resourceId) && "0".equals(region)) {
          isValid = false;
          setErrorMessage(Messages.MSG_RPRT_COND_PARAM_REQ);
        }
      }
    }
    // UDR Case Watch Activity Report Validations
    if (UDR_CASE_WATCH_ACTIVITY_REPORT.equals(nmRptSqrName)) {

      String errorsAndWarnings = txtRptParmListStr.substring((paramPosArray[3]+1), (paramPosArray[4]));
      String openClosedStages = txtRptParmListStr.substring((paramPosArray[4]+1), (paramPosArray[5]));
      org.exolab.castor.types.Date fromDate = DateHelper.toCastorDateSafe(
                                txtRptParmListStr.substring((paramPosArray[6]+1), (paramPosArray[7])));
      org.exolab.castor.types.Date toDate = DateHelper.toCastorDateSafe(
                                txtRptParmListStr.substring((paramPosArray[7]+1), (paramPosArray[8])));
      
      // Error Active From Date must be less than To Date.
      if (fromDate != null && DateHelper.isAfter(fromDate, toDate)) {
        setErrorMessage(Messages.MSG_SVC_FROM_BEFORE_TO);
        isValid = false;
      }
      // The user entered a Date From that is in the future.
      if (fromDate != null && DateHelper.isAfterToday(fromDate)) {
        setErrorMessage(Messages.MSG_SVC_NO_FUTURE_FROM_DATE);
        isValid = false;
      }
      // The user attempts to generate the report having entered only an active from 
      // or active to date, but not both.
      if ((fromDate == null && toDate != null)||
                      (fromDate != null && toDate == null)){
        setErrorMessage(Messages.MSG_FROM_TO);
        isValid = false;        
      }
      // The user attempts to do an activity search with the Active 
      // From and To dates without selecting 'Errors Only.' 
      if (fromDate != null && toDate != null && !CodesTables.CERRWARN_ERR.equals(errorsAndWarnings) ){
        setErrorMessage(Messages.MSG_UDR_CW_ERR_FOR_DATE);
        isValid = false;        
      } 
      //The user attempts to do an activity search with the Active From and To 
      //dates without selecting 'All' for open/closed stages.
      if (fromDate != null && toDate != null && !CodesTables.COPCLSTG_ALL.equals(openClosedStages) ){
        setErrorMessage(Messages.MSG_UDR_CW_ALL_FOR_DATE);
        isValid = false;        
      }
      //User attempts to select 'All' for open and closed stages without entering 
      //active from and to dates.
      if(CodesTables.COPCLSTG_ALL.equals(openClosedStages) &&
                      (fromDate == null && toDate == null)){
        setErrorMessage(Messages.MSG_UDR_CW_DATE_FOR_ALL);
        isValid = false;        
      }
    }    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return isValid;

  }
}
