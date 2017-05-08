package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ProtectiveServiceAlertCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "ProtectiveServiceAlertCustomValidation";
  
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();
    
    boolean valid = true;
    HttpServletRequest request = super.getRequest();
    
    //-- date/time AND dateAbsconded cannot be future
    //Messages.MSG_SVC_NO_FUTURE_DATE
    Date now = new Date();
    Date psaDate = ContextHelper.getJavaDateSafe(request, "psaDate");
    String psaTime = ContextHelper.getTimeSafe(request, "psaTime");
    Date date = DateHelper.toJavaDateSafe(psaDate, psaTime);
    if(date.compareTo(now) > 0){
      this.setErrorMessage("psaDate", Messages.MSG_SVC_NO_FUTURE_DATE);
      valid = false;
    }
    
    Date dateAbsconded = ContextHelper.getJavaDateSafe(request, "dateAbsconded");
    if(!DateHelper.isNull(dateAbsconded) && dateAbsconded.compareTo(now) > 0){
      this.setErrorMessage("dateAbsconded", Messages.MSG_SVC_NO_FUTURE_DATE);
      valid = false;
    }
    
    //-- if page mode is NEW, at least one person from list must be selected
    //Messages.MSG_PSA_ONE_PERSON
    String pageMode = PageMode.getPageMode(request);
    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPersonsAbsconded_");
    if(PageModeConstants.NEW.equals(pageMode) && checkedValues.length < 1){
      this.setErrorMessage(Messages.MSG_PSA_ONE_PERSON);
      valid = false;
    }
    
    //-- page mode is MODIFY and all checkboxes are not checked
    //Messages.MSG_PSA_DEACT_PSA
    else if(PageModeConstants.MODIFY.equals(pageMode) && checkedValues.length < 1){
      String cbxAllPersonsLocated = CheckboxHelper.getCheckboxValue(request, "cbxAllPersonsLocated");
      if(ArchitectureConstants.N.equals(cbxAllPersonsLocated)){
        this.setErrorMessage(Messages.MSG_PSA_DEACT_PSA);
        valid = false;
      }
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return valid;
  }
}
