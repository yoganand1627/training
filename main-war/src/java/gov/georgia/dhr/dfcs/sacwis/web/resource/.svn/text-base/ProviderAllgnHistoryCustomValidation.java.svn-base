package gov.georgia.dhr.dfcs.sacwis.web.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;


import javax.servlet.http.HttpServletRequest;

public class ProviderAllgnHistoryCustomValidation extends FormValidation {
//static constants
  public static final String TRACE_TAG = "ProviderAllgtnHistoryCustomValidation";

  
  /**
   * This method validates the Records Check Summary page
   */
  protected boolean validateForm(){
    // add trace info
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    
    // log time and exit method scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return true;
  }
}
