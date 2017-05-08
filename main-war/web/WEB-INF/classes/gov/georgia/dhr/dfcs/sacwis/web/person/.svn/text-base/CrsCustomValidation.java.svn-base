package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class verifies information in Crs Inquiry and Registration Pages
 * <p/>
 * Copyright: Copyright (c) 2007
 * <p/>
 * Company: Accenture
 * <pre>
 * Change History:
 * Date      User         Description
 * --------  -----------  --------------------------------------------------------------------------------------------
 * 
 * </pre>
 *
 *
 *
 * @author Kapil Aggarwal
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CrsCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "CrsCustomValidation";

  /**
   * Unlike most pages, this validation class makes dynamic use of the contraint validator; to do this, it needs to get
   * the Validator object out of request and create an InputValidation object of the correct type (the type is based on
   * the code type that was selected).
   * 
   * 
   * @return Whether or not the data entered was valid
   */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    GrndsExchangeContext context = getGrndsExchangeContext();
    HttpServletRequest request = context.getRequest();
    boolean isAddToCrsClicked = StringHelper.isValid(request.getParameter("btnCrsRegister" + ".x"));

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


    if (isAddToCrsClicked ) {
      performRegistrationValidation(context, validator);
    }
    else {
      performScreeningValidation(context, validator);
    }
    performanceTrace.exitScope();
    // check to see if there are any error messages and return success if there are none
    return getErrorMessages().isEmpty();
  }


  private void performRegistrationValidation(GrndsExchangeContext context, Validator validator) {

    HttpServletRequest request = context.getRequest();
    String constraint = null;
    String inputFieldName = null;
    String inputValue = StringHelper.EMPTY_STRING;
    boolean fieldsMissing = false;

    // Get some input values that will be used for validation
    String last = request.getParameter("txtSzNmNameLast");
    String first = request.getParameter("txtSzNmNameFirst");
    String gender = request.getParameter("cboCcdPersonSex");
    String county = request.getParameter("cboSzCdAddrCounty");
    
    inputValue = FormattingHelper.formatString(last);
    inputFieldName = "txtSzNmNameLast";
    if(!performValidation(validator, inputFieldName, inputValue, "Name20",true, request))
      fieldsMissing = true;

    inputValue = FormattingHelper.formatString(first);
    inputFieldName = "txtSzNmNameFirst";
    if(!performValidation(validator, inputFieldName, inputValue, "Name20",true, request))
      fieldsMissing = true;

    inputValue = FormattingHelper.formatString(gender);
    inputFieldName = "cboCcdPersonSex";
    if(!performValidation(validator, inputFieldName, inputValue, "Letter",true, request))
      fieldsMissing = true;

    inputValue = FormattingHelper.formatString(county);
    inputFieldName = "cboSzCdAddrCounty";
    if(!performValidation(validator, inputFieldName, inputValue, "Name",true, request))
      fieldsMissing = true;

    RaceEthnicityBean reBean = extractRaceEthnicity(request);
    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )  {
      raceValues = races.getStringVector();
      int noOfRaces = raceValues.size();
      if(noOfRaces == 0) {
        inputValue = "";
        inputFieldName = "Race";
        setErrorMessage("Race : " + InputValidation.REQUIRED_ERROR_MESSAGE);
        fieldsMissing = true;
      }
    }
    
    if(fieldsMissing) {
      setErrorMessage("Please navigate to Person Details Page and enter these values");
    }

    // Check to see if on exists with the same type and number; if so, we fail.
    // Note that we check by checking hdnIsNew, so even if there is one that is identical,
    // you can't update it unless you clicked on it from the list, as that is the only way to set "isNew" to false
    CINT14WLB cint14wlb;
    CINT14WLB_ARRAY cint14wlb_array = PersonIdentifiersConversation.getCINT14WLB_ARRAY(context, getEjb(Person.class));

    // Get some input values that will be used more than once
    String codeType = ContextHelper.getStringSafe(request, "selSzCdPersonIdType");
    String txtSzNbrPersonIdNumber = ContextHelper.getStringSafe(request, "txtSzNbrPersonIdNumber");
    
    if (cint14wlb_array != null && fieldsMissing == false) {
      String isNew = ContextHelper.getStringSafe(request, "hdnIsNew");
      if ("true".equals(isNew)) {
        Enumeration enumeration = cint14wlb_array.enumerateCINT14WLB();
        while (enumeration.hasMoreElements()) {
          cint14wlb = (CINT14WLB) enumeration.nextElement();
          org.exolab.castor.types.Date endDate = cint14wlb.getDtPersonIDEnd();
          // We need to check and see if the existing one is not end-dated, that the codeType is the same and that the
          // number is the same; if so, we are trying to add a new one that has the same number as an existing one.
          if ((endDate == null) && cint14wlb.getSzCdPersonIdType().equals(codeType) &&
                          PersonIdentifiersConversation.comparePersonIds(codeType, cint14wlb.getSzNbrPersonIdNumber(),
                                                                         txtSzNbrPersonIdNumber)) {
            setErrorMessage("txtSzNbrPersonIdNumber", Messages.MSG_INT_ROW_EXISTS);
          }
        }
      }
    }
  }


  private void performScreeningValidation(GrndsExchangeContext context, Validator validator) {
    
    HttpServletRequest request = context.getRequest();
    String ssn = request.getParameter("txtSzSysTxtGenericSSN");
    String last = request.getParameter("txtSzNmNameLast");
    String gender = request.getParameter("cboCcdPersonSex");

    String constraint = null;
    String inputFieldName = null;
    String inputValue = StringHelper.EMPTY_STRING;
    boolean genderSelected = false;
    
    // The code below validates the conditional requirment on both the CrsInquiry as well as CrsRegistration page
    // If SSN exists and is valid then we can go ahead and perform the search 
    if (ssn != null && ssn.trim().length() > 0) {
      inputValue = FormattingHelper.formatSSN(ssn);
      inputFieldName = "txtSzSysTxtGenericSSN";
      performValidation(validator, inputFieldName, inputValue, "SocialSecurityNumber",false, request);
    }
    else if( (last != null && last.trim().length()>0) && (gender!=null && gender.trim().length()>0) ) {
      inputValue = last.trim();
      inputFieldName = "txtSzNmNameLast";
      performValidation(validator, inputFieldName, inputValue, "Name20",false, request); 
      inputValue = gender;
      inputFieldName = "cboCcdPersonSex";
      performValidation(validator,inputFieldName, inputValue, "Letter", false, request);
    }
    else {
      setErrorMessage("Either SSN or a combination of Last Name and Gender must be entered");
    }
  }


  private boolean performValidation(Validator validator, String inputFieldName, String inputValue, String constraint, boolean b, HttpServletRequest request) {

    // We will now validate the the fields and if invalid then set the error message
    InputValidation inputValidation = new InputValidation(inputFieldName, constraint, b);
    inputValidation.setValue(inputValue);
    inputValidation.validate(validator, request);
    if (!inputValidation.isValid()) {
      setErrorMessage(inputFieldName, inputValidation.getErrorMessage());
      return false;
    }
    else {
      return true;
    }
  }


  private RaceEthnicityBean extractRaceEthnicity(HttpServletRequest currentRequest) {

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( currentRequest ) ) {
      reBean = RaceEthnicityHelper.getFromRequest( currentRequest );
    }
    else if ( RaceEthnicityHelper.isInState( currentRequest ) )    {
      reBean = RaceEthnicityHelper.getFromState( currentRequest );
    }
    return reBean;
  }
}



