package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.Validator;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.net.URL;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class verifies all of the information in the Person Identifiers conversation
 * <p/>
 * Copyright: Copyright (c) 2002
 * <p/>
 * Company: Accenture
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  --------------------------------------------------------------------------------------------
 * 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed message lookup
 * 09/27/05  berkime      SIR 23827 user has to enter comments if they change a DHS interface SSN.
 *                        Put the error message for SIR 23446 in custom validation.
 * 12/08/08  charden      STGAP00007204 - checking if CRSID number is required field to determine the message thrown                                                
 * </pre>
 *
 * @author Michael Werle
 * @version 1.0
 */
public class PersonIdentifiersCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "PersonDetailCustomValidation";
  public static final String SSN_VERIFIED = "SSA verified via DHS RECEIVE Interface";

  /**
   * Unlike most pages, this validation class makes dynamic use of the contraint validator; to do this, it needs to get
   * the Validator object out of request and create an InputValidation object of the correct type (the type is based on
   * the code type that was selected).  Also unusual is the fact that this validator actually has to call a service
   * (CINT19S) to get enough data to preform validation; this is done through the call to:
   * <code>PersonIdentifiersConversation.getCINT14WLB_ARRAY( context );</code>  If this call fails, it will return null
   * unless there is a severe exception (in which case, something in the data is <i>very</i> broken or the system is
   * down); if null is returned, there is no need to do a check, so we are fine.
   *
   * @return Whether or not the data entered was valid
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    GrndsExchangeContext context = getGrndsExchangeContext();
    HttpServletRequest request = getRequest();

    // Get the current Validator object so we can use it to create our own ValidateInput objects and validate them
    String schemaUrl = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_DEFINITION);
    Validator validator = null;
    try {
      URL url = ServerSideValidationUtility.locateResource(context.getServletContext(), schemaUrl);
      validator = Validator.getInstance(url);
    } catch (JspException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Custom validation class '" + getClass().getName() +
                                   "' failed to find the Validator resource:" + e.getMessage());
      BasePrsConversation.processSevereException(context, e);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Custom validation class '" + getClass().getName() +
                                   "' failed to find a Validator instance:" + e.getMessage());
      BasePrsConversation.processSevereException(context, e);
    }

    // Get some input values that will be used more than once
    String codeType = ContextHelper.getStringSafe(request, "selSzCdPersonIdType");
    String txtSzNbrPersonIdNumber = ContextHelper.getStringSafe(request, "txtSzNbrPersonIdNumber");
    boolean isCrsBtnClicked = StringHelper.isValid(request.getParameter("btnCrsId" + ".x"));
    String newCRS =  ContextHelper.getStringSafe(request, "newCRSString");

    if (codeType != null && codeType.trim().length() > 0) {
      // these if statements must cover every value for code type CNUMTYPE!!!
      // if one is missing, it will throw an error in "inputValidation.validate()" below
      String constraint = null;
      // If the ID Type is CRS ID and the user is attempting to Get CRS ID then don't validate
      if (codeType.equals(CodesTables.CNUMTYPE_CRS_IDNUMBER) && isCrsBtnClicked) {
        return getErrorMessages().isEmpty();
      } else if (codeType.equals(CodesTables.CNUMTYPE_ARREST_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_CARE_ID) ||
                 codeType.equals(CodesTables.CNUMTYPE_MHMR_EMPLOYEE_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_OTHER_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_PAROLE_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_PRISONER_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_PROBATION_ID) ||
                 codeType.equals(CodesTables.CNUMTYPE_UNION_NUMBER))  {
        constraint = "Any15";
      } else if (codeType.equals(CodesTables.CNUMTYPE_TDHS_CLIENT_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_PA_CASE_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_MEDICAID_NUMBER) ||
                 codeType.equals(CodesTables.CNUMTYPE_FOOD_STAMP_NUMBER) 
                 /*||(codeType.equals(CodesTables.CNUMTYPE_CRS_IDNUMBER) && !isCrsBtnClicked)*/ ){
        constraint = "Digit9";
      } else if (codeType.equals(CodesTables.CNUMTYPE_MEDICAIDMHN_NUMBER)) {
             constraint = "Digit12";
      } else if (codeType.equals(CodesTables.CNUMTYPE_COMP_VENDOR_ID)) {
        constraint = "AlphaNumeric14";
      } else if (codeType.equals(CodesTables.CNUMTYPE_MEDICARE_NUMBER)) {
        constraint = "MedicareNumber";
      } else if (codeType.equals(CodesTables.CNUMTYPE_PACE_PROJECT_CLIENT)) {
        constraint = "PaceProjectClientNumber";
      } else if (codeType.equals(CodesTables.CNUMTYPE_SSN)) {
        constraint = "SocialSecurityNumber";
      } else if (codeType.equals(CodesTables.CNUMTYPE_RSDI_CLAIM_NUMBER)) {
        constraint = "AlphaNumeric13";
      } else if (codeType.equals(CodesTables.CNUMTYPE_DRIVERS_LICENSE_NUMBER)) {
        constraint = "DriversLicense";
      }
      InputValidation inputValidation = new InputValidation("txtSzNbrPersonIdNumber", constraint, true);
      inputValidation.setValue(txtSzNbrPersonIdNumber);
      inputValidation.validate(validator, request);
      if (!inputValidation.isValid()) {
        setErrorMessage("txtSzNbrPersonIdNumber", inputValidation.getErrorMessage());
      }
    }

    // check to see if we comments if other is selected
    String comments = ContextHelper.getStringSafe(request, "txtSzDescPersonID");

    if (codeType.equals(CodesTables.CNUMTYPE_OTHER_NUMBER) && (comments == null || comments.trim().length() == 0)) {
      setErrorMessage(Messages.MSG_NO_COMMENTS_OTH_SARC);
    }

    // Check to see if on exists with the same type and number; if so, we fail.
    // Note that we check by checking hdnIsNew, so even if there is one that is identical,
    // you can't update it unless you clicked on it from the list, as that is the only way to set "isNew" to false
    CINT14WLB cint14wlb;
    // CINT14WLB_ARRAY cint14wlb_array = PersonIdentifiersConversation.getCINT14WLB_ARRAY(context);
    // PersonIdentifiersConversation pic = new PersonIdentifiersConversation();
    // CINT14WLB_ARRAY cint14wlb_array = PersonIdentifiersConversation.getCINT14WLB_ARRAY(context, person);

    CINT14WLB_ARRAY cint14wlb_array = PersonIdentifiersConversation.getCINT14WLB_ARRAY(context, getEjb(Person.class));
    if (cint14wlb_array != null) {
      String isNew = ContextHelper.getStringSafe(request, "hdnIsNew");
      if ("true".equals(isNew)) {
        Enumeration enumeration = cint14wlb_array.enumerateCINT14WLB();
        while (enumeration.hasMoreElements()) {
          cint14wlb = (CINT14WLB) enumeration.nextElement();
          org.exolab.castor.types.Date endDate = cint14wlb.getDtPersonIDEnd();
          // We need to check and see if the existing one is not end-dated, that the codeType is the same and that the
          // number is the same; if so, we are trying to add a new one that has the same number as an existing one.
          if ((endDate == null)
              && cint14wlb.getSzCdPersonIdType().equals(codeType)
              && PersonIdentifiersConversation.comparePersonIds(codeType, cint14wlb.getSzNbrPersonIdNumber(),
                                                                txtSzNbrPersonIdNumber)) {
            if (newCRS != null && "false".equals(newCRS)) {
              setErrorMessage("txtSzNbrPersonIdNumber", Messages.MSG_INT_ROW_EXISTS);
            } else {
              setErrorMessage(Messages.MSG_INT_ROW_EXISTS);
            }
          }
        }
      }
    }
    //SIR 23827 The error message is used when there are no comments, SSN has been verified through dhs,
    //  SSN has been modified, and the drop down is SSN
    String cbVerifiedInt = CheckboxHelper.getCheckboxValue(request, "cbxBIndVerifiedInterface");
    String isSSNModified = ContextHelper.getStringSafe(request, "hdnSSN");
    if (codeType.equals(CodesTables.CNUMTYPE_SSN) && "Y".equals(cbVerifiedInt) &&
        !(isSSNModified.equals(txtSzNbrPersonIdNumber)) && "".equals(comments)) {
      setErrorMessage(Messages.MSG_CMMTS_DHS_SSN);
    }
    //SIR 23827 Put the error message for SIR 23446 in custom validation.
    // If either the drop down is SSN, SSN has not been verified, and comments are "SSA verified via DHS RECEIVE
    //   Interface" or drop down is SSN, SSN has been verified, SSN has been modified, and comments are "SSA verified
    //   via DHS RECEIVE Interface" then set the error messasge.
    if ((codeType.equals(CodesTables.CNUMTYPE_SSN) && "N".equals(cbVerifiedInt) && comments.equals(SSN_VERIFIED)) ||
        (codeType.equals(CodesTables.CNUMTYPE_SSN) && "Y".equals(cbVerifiedInt) &&
         !(isSSNModified.equals(txtSzNbrPersonIdNumber)) && comments.equals(SSN_VERIFIED))) {
      setErrorMessage(Messages.MSG_EXCLUSIVE_USE_SSN);
    }
    performanceTrace.exitScope();
    // check to see if there are any error messages and return success if there are none
    return getErrorMessages().isEmpty();
  }
}
