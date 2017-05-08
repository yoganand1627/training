package gov.georgia.dhr.dfcs.sacwis.web.person;

// -- architecture classes --

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * PersonSearch.jsp Custom validation class <p>Description:  This class checks that if the First OR Middle names are
 * filled out a Last name is required. </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Jeff Chambers
 * @version 1.0
 *          <p/>
 *          <pre>
 *                   Change History:
 *                    Date      User              Description
 *                    --------  ----------------  --------------------------------------------------
 *                    07/16/03  GRIMSHAN          SIR 18946 -- Only required street if no other
 *                                                search type has been selected
 *          <p/>
 *                    10/14/03  CORLEYAN          SIR 19857 -- ContextHelper.get... replaces
 *                                                getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD
 *                                                removed message lookup
 */
public class PersonSearchCustomValidation extends FormValidation {

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    String first = ContextHelper.getStringSafe(request, "txtSzNmNameFirst");
    String last = ContextHelper.getStringSafe(request, "txtSzNmNameLast");
    String searchType = ContextHelper.getStringSafe(request, "cboSearchType");
    String dob = ContextHelper.getStringSafe(request, "txtDtDtPersonBirth");
    String street = ContextHelper.getStringSafe(request, "txtSzAddrPersAddrStLn1");
    String city = ContextHelper.getStringSafe(request, "txtSzCdAddrCity");
    String ssn = ContextHelper.getStringSafe(request, "txtSzSysTxtGenericSSN");
    String personId = ContextHelper.getStringSafe(request, "txtUlIdPerson");
    String phone = ContextHelper.getStringSafe(request, "txtlNbrPhone");
    String intakeReportId = ContextHelper.getStringSafe(request, "txtIntReportID");
    String medicaidNbr = ContextHelper.getStringSafe(request, "txtMedaidNO");
    String additionalParams = CheckboxHelper.getCheckboxValue(request, "cbxAdditionalParams");
    String addressParams = CheckboxHelper.getCheckboxValue(request, "cbxAddressSearch");
    // Added for Mobile
    String hdnMobileIdSearch = ContextHelper.getStringSafe(request, "hdnMobileIdSearch");

    boolean result = true;

    // If search type, additional parameters, or address have not been selected display a message
    if (("".equals(searchType) && "N".equals(additionalParams) && "N".equals(addressParams))
        && !ArchitectureConstants.Y.equals(hdnMobileIdSearch)) {
      setErrorMessage(Messages.MSG_SEARCH_TYP_REQ);
      result = false;
    }

    // If user selects Additional Parameters for the search type, SSN,
    //Person ID or Phone are required
    if ("Y".equals(additionalParams)) {
      if ((ssn.equalsIgnoreCase(StringHelper.EMPTY_STRING))
          && (personId.equalsIgnoreCase(StringHelper.EMPTY_STRING))
          && (phone.equalsIgnoreCase(StringHelper.EMPTY_STRING))
          && (intakeReportId.equalsIgnoreCase(StringHelper.EMPTY_STRING))
          && (medicaidNbr.equalsIgnoreCase(StringHelper.EMPTY_STRING))
              ) {
        setErrorMessage(Messages.MSG_ADDL_SEARCH);
        result = false;
      }
    }
    // SIR 18946 If user selects Address for the search type, Street must be entered if there is no search type entered.
    else if (("Y".equals(addressParams) && "".equals(searchType))
             && (street.equalsIgnoreCase(StringHelper.EMPTY_STRING))) {
      setErrorMessage("txtSzAddrPersAddrStLn1", Messages.MSG_ADDR_SEARCH);
      result = false;
    } else {
      // If user selects Phonetic search type, Last Name is required
      if ("PHO".equalsIgnoreCase(searchType)
          && (last.equals(StringHelper.EMPTY_STRING))) {
        setErrorMessage("txtSzNmNameLast", Messages.MSG_PHO_SEARCH);
        result = false;
      }

      // If user selects Full Name or Partial First and Last for the search type, but does not
      // enter either a first or last name.
      if (("FUL".equalsIgnoreCase(searchType) || "PAR".equalsIgnoreCase(searchType)) &&
          ((first.equals(StringHelper.EMPTY_STRING))
           || (last.equals(StringHelper.EMPTY_STRING)))) {
        setErrorMessage(Messages.MSG_NAME_SEARCH);
        result = false;
      }

      // If user selects Date of Birth for the search type, one must be entered to search
      if (("DOB".equals(searchType) && dob.equals(StringHelper.EMPTY_STRING))) {
        setErrorMessage("txtDtDtPersonBirth", Messages.MSG_DOB_SEARCH);
        result = false;
      }
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
  public static final String TRACE_TAG = "PersonSearchCustomValidation";
}