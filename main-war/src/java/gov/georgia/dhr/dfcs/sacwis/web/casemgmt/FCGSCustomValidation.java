package gov.georgia.dhr.dfcs.sacwis.web.casemgmt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * FCGSDetail.jsp Custom validation class
 * <p/>
 * Description: This class checks if the It also checks if a duplicate row is being attempted. </p>
 * <p/>
 * Copyright: Copyright (c) 2002 </p>
 * <p/>
 * Company: </p>
 *
 * @author Vishala Devarakonda
 * @version 1.0
 */
public class FCGSCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "FCGSCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    boolean result = true;
    String reason = ContextHelper.getStringSafe(request, "hdnCDGoalRsn");
    String other = ContextHelper.getStringSafe(request, "szTxtOther");

    if ("OTH".equals(reason)) {
      if ("".equals(other) || other == null) {
        setErrorMessage("szTxtOther", Messages.MSG_GOAL_OTH_EXP_REQ);
        result = false;
      }
    }

    int numOfAddedSteps = 0;
    int numOfSteps = ContextHelper.getIntSafe(request, "numOfSteps");
    for (int i = 0; i < numOfSteps; i++) {
      String fieldName = "cbxSelected" + i;
      String checkboxValue = CheckboxHelper.getCheckboxValue(request, fieldName);
      if ("Y".equals(checkboxValue)) {

        fieldName = "hdnStepId" + i;
        int stepId = 0;
        //need to check to see if fieldname exists on the jsp, then check the value
        if (ContextHelper.isParameterPresent(request, fieldName)) {
          stepId = ContextHelper.getIntSafe(request, fieldName);
        }

        fieldName = "hdnStepCode" + i;
        String stepCode = "";
        //need to check to see if fieldname exists on the jsp, then check the value
        if (ContextHelper.isParameterPresent(request, fieldName)) {
          stepCode = ContextHelper.getStringSafe(request, fieldName);
        }

        fieldName = "txtDtAntComp" + i;
        //need to check to see if fieldname exists on the jsp, then check the value
        if (ContextHelper.isParameterPresent(request, fieldName)) {
          Date antComp = ContextHelper.getJavaDateSafe(request, fieldName);
          if (DateHelper.isNull(antComp)) {
            setErrorMessage(fieldName, Messages.MSG_ANT_COMP_REQ);
            result = false;
          }
        } else {
          setErrorMessage(fieldName, Messages.MSG_ANT_COMP_REQ);
          result = false;
        }

        if (stepId != 0) {

          fieldName = "szTxtRspns" + i;
          //need to check to see if fieldname exists on the jsp, then check the value
          if (ContextHelper.isParameterPresent(request, fieldName)) {
            String rspns = ContextHelper.getStringSafe(request, fieldName);
            if ("".equals(rspns) || rspns == null) {
              setErrorMessage(fieldName, Messages.MSG_RESPON_STEP_REQ);
              result = false;
            }
          }

          fieldName = "txtStep" + i;
          //need to check to see if fieldname exists on the jsp, then check the value
          if (ContextHelper.isParameterPresent(request, fieldName)) {
            String stepText = ContextHelper.getStringSafe(request, fieldName);
            if ("".equals(stepText) || stepText == null) {
              setErrorMessage(fieldName, Messages.MSG_STEP_STEP_REQ);
              result = false;
            }
          }

          fieldName = "szCdStatus" + i;
          //need to check to see if fieldname exists on the jsp, then check the value
          if (ContextHelper.isParameterPresent(request, fieldName)) {
            String status = ContextHelper.getStringSafe(request, fieldName);
            if ("".equals(status) || status == null) {
              setErrorMessage(fieldName, Messages.MSG_STEP_STAT_REQ);
              result = false;
            }
          }

        } else {
          fieldName = "szTxtRspns" + i + "_Disabled";
          //need to check to see if fieldname exists on the jsp, then check the value
          if (ContextHelper.isParameterPresent(request, fieldName)) {
            String rspns = ContextHelper.getStringSafe(request, fieldName);
            if ("".equals(rspns) || rspns == null) {
              setErrorMessage(fieldName, Messages.MSG_RESPON_STEP_REQ);
              result = false;
            }
          } else {
            setErrorMessage(fieldName, Messages.MSG_RESPON_STEP_REQ);
          }
          fieldName = "txtStep" + i + "_Disabled";
          //need to check to see if fieldname exists on the jsp, then check the value
          if (ContextHelper.isParameterPresent(request, fieldName)) {
            String stepText = ContextHelper.getStringSafe(request, fieldName);
            if ("".equals(stepText) || stepText == null) {
              setErrorMessage(fieldName, Messages.MSG_RESPON_STEP_REQ);
              result = false;
            }
          } else {
            setErrorMessage(fieldName, Messages.MSG_RESPON_STEP_REQ);
            result = false;
          }

          fieldName = "szCdStatus" + i + "_Disabled";
          //need to check to see if fieldname exists on the jsp, then check the value
          if (ContextHelper.isParameterPresent(request, fieldName)) {
            String status = ContextHelper.getStringSafe(request, fieldName);
            if ("".equals(status) || status == null) {
              setErrorMessage(fieldName, Messages.MSG_STEP_STAT_REQ);
              result = false;
            }
          } else {
            setErrorMessage(fieldName, Messages.MSG_STEP_STAT_REQ);
            result = false;
          }
           String index = "errorIndex" + i;
            request.setAttribute(index, "true");
            if ("".equals(stepCode)) {
              numOfAddedSteps++;
            }
        }
      }
    }
    request.setAttribute("numOfAddedSteps", numOfAddedSteps);
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();

  }
}
