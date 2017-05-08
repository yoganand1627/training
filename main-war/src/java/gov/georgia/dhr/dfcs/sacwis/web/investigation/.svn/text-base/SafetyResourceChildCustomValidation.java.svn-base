package gov.georgia.dhr.dfcs.sacwis.web.investigation;


import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * This class is the custom validation class for Safety Resource Child Detail.  Only check
 * is that end date cannot be before start date for any child detail.
 * 
 * @author Joshua Dorsey
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  Patrick Coogan    Updated comments for final check in of Safety Resource
 *                             enhancement.
 * </pre>
 * 
 */
public class SafetyResourceChildCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "SafetyResourceChildCustomValidation";

  /**
   * This method performs custom form validation to verify that start date is not
   * after end date for safety resource placements.
   * 
   * @return boolean of form validation
   * 
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    boolean isValid = true;

    Date dtStart = ContextHelper.getJavaDateSafe(request, "txtDtStart");
    Date dtEnd = ContextHelper.getJavaDateSafe(request, "txtDtEnd");
    String nmSecondary = ContextHelper.getStringSafe(request, "SecSafetyResource_DISPLAY_ONLY");
    String szSelSecondaryRel = ContextHelper.getStringSafe(request, "selSecondaryRelationship");
    String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbx_");
    
    if (super.isButtonPressed("btnSave")){
        
      if (DateHelper.isAfter(dtStart, dtEnd)){
       
        isValid = false;
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SRP_START_EBEFORE_END));
        
      }
      
      if (cbxValues.length==0){
        
        isValid = false;
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
        
      }
      
      if ((!"".equals(nmSecondary))&&("".equals(szSelSecondaryRel))){
        
        isValid = false;
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SRP_SEC_REL));
        
      }
      
    }

    performanceTrace.exitScope();
    return isValid;
  }
}