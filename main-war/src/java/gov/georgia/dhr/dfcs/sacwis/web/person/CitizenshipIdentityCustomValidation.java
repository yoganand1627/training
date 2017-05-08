package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * ********************************************************************* PersonCitizenshipIdentity.jsp Custom validation
 * class
 * <p>
 * Description: This class checks citizenship and identity relationships
 * 
 * 
 * @author Barak Pinkston
 * @version 1.0 <p/> Change History: Date User Description -------- -----------
 *          ---------------------------------------------- <p/>
 *          ***********************************************************************
 */
public class CitizenshipIdentityCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "CitizenshipIdentityCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    String stage = GlobalData.getSzCdStage(request);

    // Birth Information
    String citizenshipStatus = ContextHelper.getStringSafe(request, "selSzCdCitizenshipStatus");
    String birthState = ContextHelper.getStringSafe(request, "selSzCdPersonBirthState");
    String birthCity = ContextHelper.getStringSafe(request, "txtSzCdPersonBirthCity");
    String outOfStateCounty = ContextHelper.getStringSafe(request, "txtSzCdOutOfStateCounty");
    String indUSCitizen = ContextHelper.getStringSafe(request, "cbxBIndUSCitizen");    
    Date dtDtEntryUS = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtEntryUS"));
    Date dtBirth = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "dtBirth"));
    int age = DateHelper.getAge(dtBirth);
    String motherMarried = ContextHelper.getStringSafe(request, "selSzCdMotherMarried");
    String[] chkMethodOfCitizenshipVerification = CheckboxHelper.getCheckedValues(request,
                                                                                  "chkMethodOfCitizenshipVerification");
    String[] chkUSCitizen = CheckboxHelper.getCheckedValues(request, "chkUSCitizen");
    String[] chkIdentityVerificationAdult = CheckboxHelper.getCheckedValues(request, "chkIdentityVerificationAdult");
    String[] chkIdentityVerificationUnder16Only = CheckboxHelper.getCheckedValues(request,
                                                                                  "chkIdentityVerificationUnder16Only");
    String[] chkPermResRefugee = CheckboxHelper.getCheckedValues(request, "chkPermResRefugee");
    String[] chkOtherQualifiedAlien = CheckboxHelper.getCheckedValues(request, "chkOtherQualifiedAlien");
    String[] chkUndetermined = CheckboxHelper.getCheckedValues(request, "chkUndetermined");
    int sizeChkMethodOfCitizenshipVerification = chkMethodOfCitizenshipVerification.length;
    int sizeChkUSCitizen = chkUSCitizen.length;
    int sizeChkIdentityVerificationAdult = chkIdentityVerificationAdult.length;
    int sizeChkIdentityVerificationUnder16Only = chkIdentityVerificationUnder16Only.length;
    int sizeChkPermResRefugee = chkPermResRefugee.length;
    int sizeChkOtherQualifiedAlien = chkOtherQualifiedAlien.length;
    int sizeChkUndetermined = chkUndetermined.length;

    // Stage is ADO or SUB and mother married at birth is not selected
    if (CodesTables.CSTAGES_ADO.equals(stage) || CodesTables.CSTAGES_SUB.equals(stage)) {
      if (StringHelper.EMPTY_STRING.equals(motherMarried)) {
        setErrorMessage(Messages.MSG_MOTHER_REQ_PRI);
      }
    }

    // if birthState and indUSCitizen are not entered then birthCity cannot be entered    
    if (StringHelper.EMPTY_STRING.equals(birthState) && StringHelper.EMPTY_STRING.equals(indUSCitizen)) {
      if (!StringHelper.EMPTY_STRING.equals(birthCity)) {
        setErrorMessage(Messages.MSG_CITY_ENTERED);    
      }
    }
    
    

    // if state selected is not GA then outOfStateCounty must be entered
    if (StringHelper.EMPTY_STRING.equals(outOfStateCounty)) {
      if (!StringHelper.EMPTY_STRING.equals(birthState) && !"GA".equals(birthState)) {
        setErrorMessage(Messages.MSG_OUT_OF_STATE_CNTY);
      }
    }

    // if indUSCitizen is entered dtDtEntryUS must be entered
    if (!StringHelper.EMPTY_STRING.equals(indUSCitizen)) {
      if (dtDtEntryUS == null) {
        setErrorMessage(Messages.MSG_CMN_ENTRY_DATE);
      }
    }

    // if dtBirth is blank, no age verification can be entered
    if (dtBirth == null) {
      if (sizeChkMethodOfCitizenshipVerification > 0) {
        setErrorMessage(Messages.MSG_DOB_VRFCTN_INVLD);
      }
    }

    // US Citizen = Citizenship Status
    if (!StringHelper.EMPTY_STRING.equals(citizenshipStatus) && CodesTables.CCTZNSTA_AMR.equals(citizenshipStatus)) {
      if (sizeChkPermResRefugee > 0 || sizeChkOtherQualifiedAlien > 0 || sizeChkUndetermined > 0) {
        setErrorMessage(Messages.MSG_STATUS_VERIFICATION_CONFLICT);
        if (sizeChkUSCitizen > 0) {
          setErrorMessage(Messages.MSG_CONFLICT_VERIF);
        }
      }
    }

    // Permanent Resident = Citizenship Status
    if (!StringHelper.EMPTY_STRING.equals(citizenshipStatus) && CodesTables.CCTZNSTA_PTR.equals(citizenshipStatus)) {
      if (sizeChkUSCitizen > 0 || sizeChkOtherQualifiedAlien > 0 || sizeChkUndetermined > 0) {
        setErrorMessage(Messages.MSG_STATUS_VERIFICATION_CONFLICT);
        if (sizeChkPermResRefugee > 0) {
          setErrorMessage(Messages.MSG_CONFLICT_VERIF);
        }
      }
    }

    // Undetermined Status = Citizenship Status
    if (!StringHelper.EMPTY_STRING.equals(citizenshipStatus) && CodesTables.CCTZNSTA_TMR.equals(citizenshipStatus)) {
      if (sizeChkUSCitizen > 0 || sizeChkOtherQualifiedAlien > 0 || sizeChkPermResRefugee > 0) {
        setErrorMessage(Messages.MSG_STATUS_VERIFICATION_CONFLICT);
        if (sizeChkUndetermined > 0) {
          setErrorMessage(Messages.MSG_CONFLICT_VERIF);
        }
      }
    }

    // Other Qualified Alien = Citizenship Status
    if (!StringHelper.EMPTY_STRING.equals(citizenshipStatus) && CodesTables.CCTZNSTA_VIS.equals(citizenshipStatus)) {
      if (sizeChkUSCitizen > 0 || sizeChkUndetermined > 0 || sizeChkPermResRefugee > 0) {
        setErrorMessage(Messages.MSG_STATUS_VERIFICATION_CONFLICT);
        if (sizeChkOtherQualifiedAlien > 0) {
          setErrorMessage(Messages.MSG_CONFLICT_VERIF);
        }
      }
    }

    // Person is over 16. select an adult identity type.
    if (age > 16) {
      if (sizeChkIdentityVerificationUnder16Only > 0) {
        setErrorMessage(Messages.MSG_CMN_IDENT_VERIF_AGE);
      }
    }

    if (sizeChkUSCitizen > 0) {
      boolean isUSP = false;
      for (int i = 0; i < sizeChkUSCitizen; i++) {
        if (CodesTables.CCERTVER_USP.equals(chkUSCitizen[i])) {
          isUSP = true;
        }
      }
      if (!isUSP) {
        if (sizeChkIdentityVerificationAdult <= 0 && sizeChkIdentityVerificationUnder16Only <= 0) {
          setErrorMessage(Messages.MSG_CMN_IDENT_VERIF_REQ);
        }
      }
    }    

    // citizenship status cannot be blank if any verification has been selected
    if (sizeChkMethodOfCitizenshipVerification > 0 || sizeChkUSCitizen > 0 || sizeChkIdentityVerificationAdult > 0
        || sizeChkIdentityVerificationUnder16Only > 0 || sizeChkPermResRefugee > 0 || sizeChkOtherQualifiedAlien > 0
        || sizeChkUndetermined > 0) {
      if ("".equals(citizenshipStatus) || citizenshipStatus == null) {
        setErrorMessage(Messages.MSG_CITIZEN_VERIF_INVALID);
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
