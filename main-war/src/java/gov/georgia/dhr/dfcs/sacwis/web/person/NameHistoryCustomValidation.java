package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * ********************************************************************* NameHistoryDetail.jsp Custom validation class
 * <p>Description:  This class checks if either first or last name is completed when submitting a name to the save
 * service. Also checks if a duplicate row is being attempted. </p> <p>Copyright: Copyright (c) 2002</p> <p>Company:
 * </p>
 *
 * @author J. Heather Dean
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  ----------- ----------------------------------------------
 *          10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get... replaces getInputValue(), Removed message lookup
 *          <p/>
 *          ***********************************************************************
 */
public class NameHistoryCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "NameHistoryCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();

    String lastName = ContextHelper.getStringSafe(request, "txtNameHistLast");
    String middleName = ContextHelper.getStringSafe(request, "txtNameHistMiddle");
    String firstName = ContextHelper.getStringSafe(request, "txtNameHistFirst");
    String suffix = ContextHelper.getStringSafe(request, "selNameHistSuffix");
    // STGA00004856
    String endDate = ContextHelper.getStringSafe(request, "dspEndDate");
    String cbxPrimaryFromReq = ContextHelper.getStringSafe(request, "cbxPrimary");
    String cbxInvalidFromReq = ContextHelper.getStringSafe(request, "cbxInvalid");
    Boolean primarySelected = StringHelper.isTrue(cbxPrimaryFromReq);
    Boolean invalidSelected = StringHelper.isTrue(cbxInvalidFromReq);
    Boolean cbxPrimaryFromState = ContextHelper.getBooleanSafe(request, "hdnIsPrimary");
    Boolean cbxInvalidFromState = ContextHelper.getBooleanSafe(request, "hdnIsInvalid");
    // Name is active non-Primary (neither Primary or Invalid) and user checked both Primary and Invalid
    if ((!cbxPrimaryFromState && !cbxInvalidFromState) && (primarySelected && invalidSelected)) {
      setErrorMessage(Messages.MSG_NM_MULTIPLE_ACTN_ERR);
    }
    // Name is active Primary and user checked Invalid
    if (cbxPrimaryFromState && !StringHelper.isValid(endDate) && invalidSelected) {
      setErrorMessage(Messages.MSG_NM_INVALID_PRIMARY_ERR);
    }
    // end STGA00004856

    //If both first name and last name are blank, throw this error
    if (("".equals(firstName)) &&
        ("".equals(lastName))) {
      if (!"".equals(middleName)) {
        setErrorMessage("txtNameHistFirst", Messages.MSG_MDL_NO_FIRST_LAST);
      } else if (!"".equals(suffix)) {
        setErrorMessage("txtNameHistFirst", Messages.MSG_FIRST_LAST_NM_REQ);
      } else {
        setErrorMessage("txtNameHistFirst", Messages.MSG_FIRST_LAST_NM_REQ);
      }
    }

    if (!"".equals(ContextHelper.getStringSafe(request, "isAdd"))) {
      if (!checkDuplicateRow(request)) {
        setErrorMessage("txtNameHistFirst", Messages.MSG_INT_DUPLICATE_ROW);
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }

  /**
   * ********************************************************************* This helper method is called by the
   * saveNameHistory_xa method to populate the GlobalData object from the request's input parameters
   *
   * @return true or false **********************************************************************
   */
  private boolean checkDuplicateRow(HttpServletRequest request) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "checkDuplicateRow");
    performanceTrace.enterScope();

    ROWCINV25SOG00_ARRAY rowArray = null;
    try {
      rowArray = (ROWCINV25SOG00_ARRAY)
              SerializationHelper.deserializeObject(ContextHelper.getStringSafe(request, "cinv25so_array"));
    }
    catch (IOException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure deserializing ROWCINV25SOG00_ARRAY in " +
                                   TRACE_TAG + ".checkDuplicateRow():" + e.getMessage());
      super.setErrorMessage(e.getMessage());
      return false;
    }
    Enumeration nameEnumeration1 = rowArray.enumerateROWCINV25SOG00();
    String firstName = ContextHelper.getStringSafe(request, "txtNameHistFirst");
    String middleName = ContextHelper.getStringSafe(request, "txtNameHistMiddle");
    String lastName = ContextHelper.getStringSafe(request, "txtNameHistLast");
    String suffix = ContextHelper.getStringSafe(request, "selNameHistSuffix");
    String endDate = ContextHelper.getStringSafe(request, "dspEndDate");

    ROWCINV25SOG00 nameRow = null;
    if (!nameEnumeration1.hasMoreElements()) {
      return true;
    } else {
      while (nameEnumeration1.hasMoreElements()) {
        nameRow = (ROWCINV25SOG00) nameEnumeration1.nextElement();
        if (firstName.equals(StringHelper.getNonNullString(nameRow.getSzNmNameFirst())) &&
            middleName.equals(StringHelper.getNonNullString(nameRow.getSzNmNameMiddle())) &&
            lastName.equals(StringHelper.getNonNullString(nameRow.getSzNmNameLast())) &&
            suffix.equals(StringHelper.getNonNullString(nameRow.getSzCdNameSuffix())) &&
            "".equals(endDate) &&
            (nameRow.getDtDtNameEndDate() == null || DateHelper.MAX_CASTOR_DATE.equals(nameRow.getDtDtNameEndDate()))) {
          return false;
        }
      }
    }

    performanceTrace.exitScope();
    return true;
  }
}
