package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

//!!! do you really need to check isValidDate() as validateDate with constraint="Date"
// already checks if it's "valid"; only thing it doesn't check is whether it's after 1850

/**
 * This class is used to validate FCE Application Background information.
 *
 * @author Jonathan Hardy, January 8, 2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class ApplicationAndBackgroundCustomValidation
        extends FormValidation {
  public ApplicationAndBackgroundCustomValidation() {
    super();
  }

  @SuppressWarnings( { "unchecked" })
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm");
    performanceTrace.enterScope();

    GrndsExchangeContext context = super.getGrndsExchangeContext();

    boolean isValid = true;

    HttpServletRequest request = super.getRequest();

    ApplicationBackgroundDB applicationBackgroundDB =
            ApplicationAndBackgroundConversation.readFromRequest(request);

    boolean indHospital = applicationBackgroundDB.getIndHospital();
    boolean indManagingCvs = applicationBackgroundDB.getIndManagingCvs();
    Date admitDate = applicationBackgroundDB.getDtHospitalAdmission();
    Date dischargeDate = applicationBackgroundDB.getDtHospitalDischarge();
    String admitDateString = applicationBackgroundDB.getDtHospitalAdmissionString();
    String dischargeDateString = applicationBackgroundDB.getDtHospitalDischargeString();
    String months = applicationBackgroundDB.getTxtPriorRemovalMonths();
    
    long idPerson = applicationBackgroundDB.getIdPerson();
    if (!indHospital &&
        ((admitDate != null) ||
         (dischargeDate != null))) {
      super.setErrorMessage(Messages.MSG_YES_REQUIRED);
      isValid = false;
    }

    // Button for child in hospital indicates "Yes", but no admit date
    //  entered by user.
    if (indHospital &&
        (admitDate == null)) {
      super.setErrorMessage("dtHospitalAdmissionString", Messages.MSG_ADMIN_DT_REQ);
      isValid = false;
    }

    // Button for child in hospital indicates "Yes" and admit date
    //  entered by user, but admit date is after today
    if (DateHelper.isValidDate(admitDateString) &&
        DateHelper.isAfterToday(admitDate)) {
      super.setErrorMessage("dtHospitalAdmissionString", Messages.MSG_DT_ADMISSION);
      isValid = false;
    }

    // Button for child in hospital indicates "Yes" and admit date and discharge
    //  date entered by user, but admit date is after discharge date
    if (indHospital &&
        DateHelper.isValidDate(admitDateString) &&
        DateHelper.isValidDate(dischargeDateString) &&
        DateHelper.isAfter(admitDate, dischargeDate)) {
      super.setErrorMessage("dtHospitalAdmissionString", Messages.MSG_DT_ADMIN_DISCHARGE);
      isValid = false;
    }
    
    // Userhas indicated medical assistance was needed for the child within the 3 months prior to removal
    // but did not enter any data in months field
    if(indManagingCvs && months.length() <= 0 ){
      super.setErrorMessage("txtPriorRemovalMonths", Messages.MSG_FCE_TXT_RML_MONTHS);
      isValid = false;
    }
    
    if (this.isButtonPressed("btnSave")) {
      int loopCount = 0;
      boolean childMarkedAsSelf = false;
      boolean morePrincipalsInList = true;
      Map relations = new HashMap();
      while (morePrincipalsInList) {
        // This while loop will continue until there are no more principals
        // in the 'List of Principals' to check.
        String relation = ContextHelper.getStringSafe(request, "cdRelInt_" + loopCount);
        if (relation == null || "".equals(relation)) {
          morePrincipalsInList = false;
          break;
        }

        long principalId = ContextHelper.getLongSafe(context, "principalPersonId_" + loopCount);
        if (relation.equals(Lookup.simpleDecodeSafe("CRELVICT", "SL"))) {
          if (principalId == idPerson) {
            // When looping through the principals list, the victim
            //  has been listed as "Self".
            childMarkedAsSelf = true;
          }
          if (relations.get(relation) != null) {
            // When looping through the principals list, more than one person
            //  has been listed as "Self" in relation to victim.
            super.setErrorMessage(Messages.MSG_MORE_THAN_SELF);
            isValid = false;
          }
          // Put this principal into map to indicate marked as "Self".
          relations.put(relation, relation);
        }
        String livingInHomeOfRemoval =
                CheckboxHelper.getCheckboxValue(request, "cbLivingInHome_" + loopCount);

        if ((ArchitectureConstants.Y.equals(livingInHomeOfRemoval)) &&
            (relation.equals(Lookup.simpleDecodeSafe("CRELVICT", "XX")))) {
          // When looping through the principals list, at least one person
          //  has been listed as "Other" in relation to victim.
          super.setErrorMessage(Messages.MSG_OTHER_INVALID);
          isValid = false;
        }

        if ((ArchitectureConstants.Y.equals(livingInHomeOfRemoval)) &&
            (relation.equals(Lookup.simpleDecodeSafe("CRELVICT", "AB")))) {
          // When looping through the principals list, at least one person
          //  listed as "Absent Parent" in relation to victim is check as
          //  Living in Home of Removal
          super.setErrorMessage(Messages.MSG_ABS_PAR_LIVING_IN_HOME);
          isValid = false;
        }

        String certifiedGroup =
                CheckboxHelper.getCheckboxValue(request, "cbMemCertGrp_" + loopCount);

        if ((ArchitectureConstants.Y.equals(certifiedGroup)) &&
            (ArchitectureConstants.Y.equals(livingInHomeOfRemoval) == false)) {
          super.setErrorMessage(Messages.MSG_CERTIFIED_GROUP_NOT_LIVING_IN_HOME);
          isValid = false;
        }

        loopCount++;
      }
      if (!childMarkedAsSelf) {
        // When looping through the principals list, the relation of the child
        //  was not listed as "Self".
        super.setErrorMessage(Messages.MSG_CHILD_MUST_BE_SELF);
        isValid = false;
      }
    }

    // If at least part of an address has been entered, but not all the required
    //  fields have been filled out, can't save yet.
    // STGAP00007077
    // This is no longer a valid message - Address now comes from Person Detail Address.
    // User can no longer edit these fields

    /*if (( OR's with address fields FILLED logic 
         !"".equals(applicationBackgroundDB.getAddrRemovalStLn1()) ||
         !"".equals(applicationBackgroundDB.getAddrRemovalStLn2()) ||
         !"".equals(applicationBackgroundDB.getAddrRemovalCity()) ||
         !"".equals(applicationBackgroundDB.getCdRemovalAddrState()) ||
         !"".equals(applicationBackgroundDB.getCdRemovalAddrCounty()) ||
         !"".equals(applicationBackgroundDB.getAddrRemovalAddrZip()) ||
         !"".equals(ContextHelper.getStringSafe(request, "addrRemovalAddrZipSuff"))
    ) &&
      ( OR's with address fields EMPTY logic 
       "".equals(applicationBackgroundDB.getAddrRemovalStLn1()) ||
       "".equals(applicationBackgroundDB.getAddrRemovalCity()) ||
       "".equals(applicationBackgroundDB.getCdRemovalAddrState()) ||
       "".equals(applicationBackgroundDB.getCdRemovalAddrCounty()) ||
       "".equals(applicationBackgroundDB.getAddrRemovalAddrZip())
      )) {
      super.setErrorMessage(Messages.MSG_COMPLETE_ADDR);
      isValid = false;
    }*/

    if (applicationBackgroundDB.getIndOtherHealthInsurance() &&
        DateHelper.isValidDate(applicationBackgroundDB.getDtHealthBeginDateString()) &&
        DateHelper.isValidDate(applicationBackgroundDB.getDtHealthEndDateString()) &&
        DateHelper.isAfter(applicationBackgroundDB.getDtHealthBeginDate(),
                           applicationBackgroundDB.getDtHealthEndDate())) {
      super.setErrorMessage("dtHealthBeginDateString", Messages.SSM_CON_BEG_BEFORE_END);
      isValid = false;
    }

    performanceTrace.exitScope();
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "ApplicationAndBackgroundCustomValidation";

}
