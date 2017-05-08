package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


/**
 * ********************************************************************* MedicationDetail.jsp Custom validation class
 * <p>Description:  This class checks if the name of the medication, Dosage and Reason are entered when submitting the
 * medication information to the save service. It also checks if a duplicate row is being attempted. </p> <p>Copyright:
 * Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Vishala Devarakonda
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ----------------------------------------------
 *          <p/>
 *          ***********************************************************************
 */
public class MedicationCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "MedicationCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();

    Date datePresc = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "szDtMedctnPresc"));
    Date endDate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "szDtMedctnEndDate"));
    String allergies = ContextHelper.getStringSafe(request, "szIndMedctnAllergies");
    String allergyDesc = ContextHelper.getStringSafe(request, "szTxtMedctnDescrip");
    

    if (allergies.equals("Y") && ("".equals(allergyDesc))) {
      setErrorMessage("szTxtMedctnDescrip", Messages.MSG_MED_ALL_DESC);
    }
    else if (allergies.equals("N") && !("".equals(allergyDesc))) {
      setErrorMessage("szDtMedctnPresc", Messages.MSG_MED_ALL_DESC_YES);
    }
    else
    {
    }
    if(DateHelper.isBefore(endDate, datePresc))
    {
      setErrorMessage("szDtMedctnEndDate", Messages.MSG_MED_DATE_PRES_EARL);
    }
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
    /*performanceTrace.exitScope();
    return true;*/
  }
}
