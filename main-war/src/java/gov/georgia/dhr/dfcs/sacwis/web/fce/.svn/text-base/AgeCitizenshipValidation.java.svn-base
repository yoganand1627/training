package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to validate  parameters entered on FCE Age Citizenship page.
 *
 * @author Michael Ochu, Nov., 2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class AgeCitizenshipValidation extends FceCustomValidation {
  /**
   * This method performs custom validation on the data submitted on the Age and Citizenship Page
   *
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace =
            new PerformanceTrace(TRACE_TAG, "validateForm()");

    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    AgeCitizenshipDB ageCitizenshipDB =
            AgeCitizenshipConversation.readFromRequest(request);

    boolean isValid = true;
    String personDateOfBirth = ContextHelper.getStringSafe(request, "dtBirth");

    boolean personDateOfBirthFilled = personDateOfBirth.length() > 0;
    boolean verifiedAge = verifiedAge(ageCitizenshipDB);
    boolean verifiedEligibilitySpecialist = verifiedEligibilitySpecialist(ageCitizenshipDB);
    
    //if the Date of birth is not null then at least one of the indicators must be checked.
    if ((!verifiedAge && !verifiedEligibilitySpecialist) &&
                    (personDateOfBirthFilled)) {
                  setErrorMessage(Messages.MSG_VERIF_DOB_REQ);
                  isValid = false;
    }
    
    FceEligibilityDB fceEligibilityDB = ageCitizenshipDB.getFceEligibility();
    if (validateCitizenship(fceEligibilityDB,
                            fceEligibilityDB.getCdPersonCitizenship()) == false) {
      isValid = false;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is" + isValid);
    return isValid;
  }

  public static boolean verifiedAge(AgeCitizenshipDB ageCitizenshipDB) {
    return 
           (ageCitizenshipDB.getIndAgeVrfdUsBirthCert()) ||
           (ageCitizenshipDB.getIndAgeVrfdForeignCert()) ||
           (ageCitizenshipDB.getIndAgeVrfdHospitalCert()) ||
           (ageCitizenshipDB.getIndAgeVrfdPassport()) ||
           (ageCitizenshipDB.getIndAgeVrfdBaptismCert()) ||
           (ageCitizenshipDB.getIndAgeVrfdResidentCard()) ||
           (ageCitizenshipDB.getIndAgeVrfdNtrlztnCert()) ||
           (ageCitizenshipDB.getIndAgeJustifiedEval());
  }
  
  public static boolean verifiedEligibilitySpecialist(AgeCitizenshipDB ageCitizenshipDB) {
    return
            (ageCitizenshipDB.getIndAgeVrfdSaveSystem()) ||
            (ageCitizenshipDB.getIndAgeVrfdSuccessSystem());
  }
  // static constants
  public static final String TRACE_TAG = "AgeCitizenshipValidation";

}




