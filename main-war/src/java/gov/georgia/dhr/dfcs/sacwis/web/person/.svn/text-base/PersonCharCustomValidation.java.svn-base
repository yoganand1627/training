package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

/**
 * PersonChar Custom validation class
 * <p>
 * Description: This class verifies all of the information in the Person Detail conversation
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Anna Grimshaw
 * @version 1.0 <p/> Change History: Date User Description -------- -----------
 *          ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *          getInputValue();
 */
/* Change History:
 *  Date        User              Description
 *  --------    ----------------  -------------------------------------------------------------------------
 *  12/01/2010  schoi             SMS #81140: MR-074 Added code to validate two new conditional fields                                      
 *  10/24/2011  hnguyen           STGAP00017351:MR-092 Added IVE in prior adoption validation if previously adopted.
 *
 */

public class PersonCharCustomValidation extends FormValidation {

  // static constants
  private static final String IND_PREV_ADOPT = "rbPrevAdopt";

  private static final String IND_PUB_ADOPT = "rbAdoptType";

  private static final String SEL_STATE = "cdState";

  private static final String SEL_COUNTY = "cdCounty";

  private static final String SEL_CNTRY = "cdCountry";
  
  private static final String PRE_ADPT = "txtPrevAdopt";
  
  private static final String ADOPT_DIS = "chkAdoptDislutn";
  
  private static final String DT_DIS = "txtDissolutionDate";
  
  // SMS #81140: MR-074 
  private static final String IND_SINGLE_PR_ADO = "rbSinglePrAdo";
  
  private static final String CD_SINGLE_MOTHER_FATHER = "rbSingleMomOrFar";
  
  protected boolean validateForm() {
    boolean result = true;

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    int hdnLNbrPersonAge = ContextHelper.getIntSafe(request, "hdnLNbrPersonAge");
    // The aged field is set to "Y" when the "No Characteristics" is selected, and
    // the aged checkbox was previously selected
    String aged = ContextHelper.getStringSafe(request, "aged");

    Map checkedValues = CheckboxHelper.getCheckedIndicators(this.getInputMap(), "cbxCAP");
    // If The Aged Checkbox was de-selected by clicking the "No Characteristics" checkbox
    // determine if it can be de-selected
    if ("Y".equals(aged) && hdnLNbrPersonAge > 64) {
      setErrorMessage(Messages.MSG_INT_AGED_UPDATE_REQUIRED);
      result = false;
    }
    // If the aged checkbox has been changed checked values will contain the 04 key
    else if (checkedValues.containsKey("04")) {
      String value = (String) checkedValues.get("04");
      // If the Aged Checkbox has been selected, determine if it can be selected
      if (value.equals(ServiceConstants.REQ_FUNC_CD_ADD) && hdnLNbrPersonAge < 65) {
        setErrorMessage(Messages.MSG_INT_AGED_INVALID);
        result = false;
      }
      // If the Aged Checkbox has been de-selected, determine if it can be
      else if (value.equals(ServiceConstants.REQ_FUNC_CD_DELETE) && hdnLNbrPersonAge > 64) {
        setErrorMessage(Messages.MSG_INT_AGED_UPDATE_REQUIRED);
        result = false;
      }
    }

    // Adoption fields
    String isDispAdopt = ContextHelper.getStringSafe(request, "hdndisplayChildInvest");
    
    String chkAdoptDislutn = ContextHelper.getStringSafe(request, ADOPT_DIS);
    String prevAdopt = ContextHelper.getStringSafe(request, IND_PREV_ADOPT);
    String adoptType = ContextHelper.getStringSafe(request, IND_PUB_ADOPT);
    String selState = ContextHelper.getStringSafe(request, SEL_STATE);
    String selCounty = ContextHelper.getStringSafe(request, SEL_COUNTY);
    String selCntry = ContextHelper.getStringSafe(request, SEL_CNTRY);
    String dtDissolutionDate = ContextHelper.getStringSafe(request, DT_DIS);
    String txPrevAdopt = ContextHelper.getStringSafe(request, PRE_ADPT);
    // SMS #81140: MR-074
    String singleParAdopt = ContextHelper.getStringSafe(request, IND_SINGLE_PR_ADO);
    String singleMotherOrFather = ContextHelper.getStringSafe(request, CD_SINGLE_MOTHER_FATHER);
    String iVEPriorAdopt = ContextHelper.getStringSafe(request, PersonDetailConversation.RADIO_IVE_PRIOR_ADOPTION);

    if (super.isButtonPressed("btnSave")) {
      if("Y".equals(isDispAdopt)){
      if ("".equals(prevAdopt)) {
        setErrorMessage(Messages.MSG_PER_PREV_ADOPT_REQ);
        result = false;
      }

      if ((("Y").equals(prevAdopt)) && (("".equals(txPrevAdopt)))) {
        setErrorMessage(Messages.MSG_PRE_ADO_DATE_REQ);
        result = false;
      }

      // SMS #81140: MR-074
      if ((ArchitectureConstants.Y.equals(prevAdopt)) && (!StringHelper.isValid(singleParAdopt))) {
        setErrorMessage(Messages.MSG_ADO_SINGLE_PARENT_REQ);
        result = false;
      }
      
      if ((ArchitectureConstants.Y.equals(singleParAdopt)) && (!StringHelper.isValid(singleMotherOrFather))) {
        setErrorMessage(Messages.MSG_ADO_SINGLE_PARENT_ERR);
        result = false;
      } 
      
      if ((StringHelper.isValid(singleMotherOrFather)) && (!StringHelper.isValid(singleParAdopt))) {
        setErrorMessage(Messages.MSG_ADO_SINGLE_PARENT_IND_ERR);
        result = false;
      }
      // End of SMS #81140: MR-074
      
      // MR-092
      if ((ArchitectureConstants.Y.equals(prevAdopt)) && (!StringHelper.isValid(iVEPriorAdopt))) {
        setErrorMessage(Messages.MSG_ADO_IVE_PRIOR_ADOPTION);
        result = false;
      }
      // end MR-092
      if ((("Y").equals(chkAdoptDislutn)) && (("".equals(dtDissolutionDate)))) {
        setErrorMessage(Messages.MSG_ADO_DISS_DATE_REQ);
        result = false;
      }
      

      if (("P".equals(adoptType)) && ("".equals(selState))) {
        setErrorMessage(Messages.MSG_PER_ADO_STATE_REQ);
        result = false;
      }
      
      if (("R".equals(adoptType)) && ("".equals(selState))) {
        setErrorMessage(Messages.MSG_PER_ADO_STATE_REQ);
        result = false;
      }

      if (("GA".equals(selState)) && ("".equals(selCounty))) {
        setErrorMessage(Messages.MSG_PER_ADO_COUNTY_REQ);
        result = false;
      }
      if (("I".equals(adoptType)) && ("".equals(selCntry))) {
        setErrorMessage(Messages.MSG_PER_ADO_COUNTRY_REQ);
        result = false;
      }
      }

    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }

  public static final String TRACE_TAG = "PersonCharCustomValidation";
}
