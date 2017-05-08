package gov.georgia.dhr.dfcs.sacwis.web.person;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Income Resource Custom validation class <p>Description:  This class verifies all of the information in the Income and
 * Resource Page </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD, removed message lookup
 */

public class IncRsrcCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    org.exolab.castor.types.Date effFrom = ContextHelper.getCastorDateSafe(request, "txtDtDtIncRsrcFrom");
    org.exolab.castor.types.Date effTo = ContextHelper.getCastorDateSafe(request, "txtDtDtIncRsrcTo");

    //SIR 19174
    double resourceAmt = ContextHelper.getMoneyAsDoubleSafe(request, "txtLAmtIncRsrc");

    //Effective To must be Greater than or equal to Effective from
    if (effFrom != null && effTo != null && DateHelper.isBefore(effTo, effFrom)) {
      setErrorMessage(Messages.SSM_CFC_EFFECTIVE_FROM_DT);
      result = false;
    }

    //SIR 19174: Income Resource Amount must be greater than zero
    if (resourceAmt <= 0) {
      setErrorMessage("txtLAmtIncRsrc", Messages.MSG_RSRC_GT_ZERO);
      result = false;
    }
    
    String rbSzCdIncRsrcIncome = ContextHelper.getString(request, "rbSzCdIncRsrcIncome");
    String selSzCdFrequency = ContextHelper.getString(request, "selSzCdFrequency");
    if("INC".equals(rbSzCdIncRsrcIncome) && "".equals(selSzCdFrequency)){
      setErrorMessage("selSzCdFrequency", Messages.MSG_INC_RSRC_FREQ);
      result = false;
    }
    
    String addressComments = ContextHelper.getString(request, "addressComments");
    if(addressComments != null && addressComments.length() > 80)
    {
      setErrorMessage("addressComments", Messages.MSG_ARC_CONSTR_PARA80);
      result = false;
    }
    

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "IncRsrcCustomValidation";
}