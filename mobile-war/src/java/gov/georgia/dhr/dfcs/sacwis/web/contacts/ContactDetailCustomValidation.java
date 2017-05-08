package gov.georgia.dhr.dfcs.sacwis.web.contacts;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Title: Contact Detail Custom Validation
 * </p>
 * <p>
 * Description: This page is used to make sure that a user has filled in all the appropriate fields when they are
 * required.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: TDPRS
 * </p>
 * 
 * <pre>
 *  Change History:
 *  Date      User              Description
 *  --------  ----------------  ----------------------------------------------
 *  02/11/03  Todd Reser        Initial Revision.
 *  02/12/03  Todd Reser        Fixed error with checking values of Dates when
 *                              they didn't exist on the submitted form.
 *  02/14/03  Todd Reser        Added validation so Method is not allowed to be
 *                              blank if purpose is a TCM, added validation to make
 *                              sure location isn't empty if specific methods were
 *                              selected.
 *  02/17/03  Todd Reser        Added checking to make sure Save and Submit was
 *                              used instead of Save when appropriate.
 *  02/19/03  Todd Reser        Added code to get hdnIntakeDate from form.
 *  02/20/03  Todd Reser        Added checking of Vics &amp; Perps.
 *  02/21/03  Todd Reser        Switched Vic &amp; Purp to Y/N instead of true/false.
 *  03/26/03  Todd Reser        QA Sweep.
 *  05/06/03  Todd Reser        Added usesSummaryDates to Summary Mode If.
 *  05/15/03  Todd Reser        Added check if != initial, case = APS and time = ''
 *  05/28/03  Todd Reser        Fixed saveSubmit and saveSubmitFAD array values.
 *  05/29/03  Todd Reser        Removed saveSubmit and saveSubmitFAD arrays and
 *                              code because we no longer should throw an error
 *                              when someone presses Save.  Saves are required on
 *                              all pages to allow a Narrative to be entered.
 *  06/19/03  Todd Reser        SIR 18371 - MSG_SVC_NO_PERSON_CONTACTED not being
 *                              thrown if cbxBIndContactAttempted is checked.
 *  06/20/03  Todd Reser        Switched tcmArray to CodesTables Constants.
 *                              SIR 18433 - Switched to Architecture Constants,
 *                              CodesTable Constants and changed if logic because
 *                              it wasn't working properly.
 *  06/15/03  Todd Reser        SIR 18887 - Changed hardcoded errorMessage
 *                              displayed to MSG_SYS_MULT_PRNOTE.
 *  10/28/03  Todd Reser        SIR 22360 - Got SzCdStage from Global data.
 *  10/29/03  Todd Reser        SIR 22361 - Added logic for EREG, EIFF and EREV to
 *                               complain if Time is null.
 *  03/01/05  Hari Maralla      SIR: 23410 - Select atleast one Principals/Collaterals Contacted (required).
 *  07/24/05  werlem            SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *  03/12/08  arege             STGAP00011640: Modified code so that Contact Date and time is not before
 *                              the intake Date and time.
 *  03/19/08  arege             STGAP00011640: Added null check.
 *  06/20/09  arege             STGAP00014326 MR-024 Changes
 *  09/07/09  arege             STGAP00015300: Name of Agency field conditionally required when the  
 *                              CPA/CCI Authorized Designee radio button is selected.
 *  05/26/11  schoi             SMS #109398: MR-086 Added a new message MSG_DISCUSSED_REQ  
 *  
 * </pre>
 * 
 * @author Todd Reser
 */

@SuppressWarnings("serial")
public class ContactDetailCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "ContactDetailCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    // !!! make static HashMaps
    String[] tcmArray = { CodesTables.CCNTPURP_AAMT, CodesTables.CCNTPURP_AMON, CodesTables.CCNTPURP_APLN,
                         CodesTables.CCNTPURP_AREA, CodesTables.CCNTPURP_GAMT, CodesTables.CCNTPURP_GMON,
                         CodesTables.CCNTPURP_GPLN, CodesTables.CCNTPURP_GREA, CodesTables.CCNTPURP_HAMT,
                         CodesTables.CCNTPURP_HAPR, CodesTables.CCNTPURP_HCPR, CodesTables.CCNTPURP_HPCN,
                         CodesTables.CCNTPURP_HPLD, CodesTables.CCNTPURP_HPLS, CodesTables.CCNTPURP_HPPC,
                         CodesTables.CCNTPURP_HPPR, CodesTables.CCNTPURP_HPSS };

    String[] methodArray = { "FTF", "STF", "XXX" };
    String type = ContextHelper.getStringSafe(request, "selSzCdContactType");
    String presentationMode = ContactSearchListDetailConversation.getPresentationMode(request);
    String stage = GlobalData.getSzCdStageProgram(request);
    String time = ContextHelper.getTimeSafe(request, "txtTmScrTmCntct");
    String method = ContextHelper.getStringSafe(request, "selSzCdContactMethod");
    String location = ContextHelper.getStringSafe(request, "selSzCdContactLocation");
    int ulIdPortalUser =  ContextHelper.getIntSafe(request, "hdnUlIdPortalUser");
    // MR-024
    String szCdContactedBy = ContextHelper.getStringSafe(request, "rbContactedBy");
    String szNmContactedBy = StringHelper.EMPTY_STRING;
    if (CodesTables.CCCONTBY_DFC.equals(szCdContactedBy)) {
      szNmContactedBy = ContextHelper.getStringSafe(request, "szNmContactedBy");
    } else if(CodesTables.CCCONTBY_CCA.equals(szCdContactedBy)) {
      szNmContactedBy = ContextHelper.getStringSafe(request, "szNmContactedByCCA");
    } else {
      szNmContactedBy = ContextHelper.getStringSafe(request, "szNmContactedByXXX");
    }
    String szNmAgencyName = ContextHelper.getStringSafe(request, "szNmAgencyName");
    // End MR-024

    // SIR 22361 - Added logic for EREG, EIFF and EREV.
    // Complain if the Time field is empty and it's an APS case OR it's an AFC
    // Contact (EREG), Initial Face to Face (EIFF) or Request for Review (EREV)
    if ("".equals(time)
        && (stage.equals(CodesTables.CPGRMSFM_APS) || (stage.equals(CodesTables.CPGRMSFM_AFC) && (type
                                                                                                      .equals(CodesTables.CCNTCTYP_EREG)
                                                                                                  || type
                                                                                                         .equals(CodesTables.CCNTCTYP_EIFF) || type
                                                                                                                                                   .equals(CodesTables.CCNTCTYP_EREG))))) {
      setErrorMessage("txtTmScrTmCntct", Messages.SSM_COMPLETE_REQUIRED);
    }

    if (isButtonPressed("btnSave")) {
      // SIR 18433 - Switched to Architecture Constants, CodesTable Constants
      // and changed if logic because it wasn't working properly.
      // Complain if save was pressed and a Victim was not selected

      String victimSelected = ContextHelper.getStringSafe(request, "hdnBVictimSelected");
      // SIR 22360 - Got SzCdStage from Global data.
      String szCdStage = GlobalData.getSzCdStage(request);

      if ((victimSelected.equals(ArchitectureConstants.N)) && (stage.equals(CodesTables.CPGRMSFM_AFC))
          && (szCdStage.equals(CodesTables.CSTAGES_INV))
          && ((type.equals(CodesTables.CCNTCTYP_CIFF)) || (type.equals(CodesTables.CCNTCTYP_EIFF)))) {
        setErrorMessage(Messages.MSG_VICTIM_NOT_SELECTED);
      }
    }

    // The Save & Save and Submit buttons are the only ones that need to check
    // all these field requirements for the Detial or Summary Pages.
    if (isButtonPressed("btnSave") || isButtonPressed("btnSaveAndSubmit")) {
      
      //MR-024 If Contacted by is CPA/CCI Authorized Designee (CCA) or Other (XXX) , then Contacted by name cannot be empty.
      if((CodesTables.CCCONTBY_CCA.equals(szCdContactedBy)||CodesTables.CCCONTBY_XXX.equals(szCdContactedBy)) && StringHelper.EMPTY_STRING.equals(szNmContactedBy)){
        setErrorMessage(Messages.MSG_CON_NM_REQ);
      }
      //MR-024 If method is ATF or UTF then location cannot be empty.
      if((CodesTables.CCNTMETH_UTF.equals(method)||CodesTables.CCNTMETH_ATF.equals(method)) && StringHelper.EMPTY_STRING.equals(location) ){
        setErrorMessage(Messages.MSG_CON_LOC_REQ);
      } 
      //MR-024 If Contacted by is CPA/CCI Authorized Designee (CCA), then Name of Agency cannot be empty.
      if(CodesTables.CCCONTBY_CCA.equals(szCdContactedBy) && StringHelper.EMPTY_STRING.equals(szNmAgencyName) ){
        setErrorMessage(Messages.MSG_NAME_AGENCY_REQ);
      }
      //End MR-024
      
      
      // If the Contacted Date is in the future
      /*
       * org.exolab.castor.types.Date contactDate = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
       * "txtDtDtContactOccurred"));
       * 
       * if (DateHelper.isAfterToday(contactDate)) { setErrorMessage("txtDtDtContactOccurred",
       * Messages.MSG_SVC_NO_FUTURE_DATE); }
       */

      Date now = new Date();
      Date contactDateAndTime = null;
      try {
        contactDateAndTime = DateHelper.toJavaDateFromInput(ContextHelper.getString(request, "txtDtDtContactOccurred"));
      } catch (ParseException pe) {
        setErrorMessage("txtDtDtContactOccurred", Messages.MSG_ARC_CONSTR_DATE);
      }

      contactDateAndTime = DateHelper.toJavaDateSafe(contactDateAndTime, time);

      boolean contactDateAndTimeNotNull = !DateHelper.isNull(contactDateAndTime);
      if (contactDateAndTimeNotNull && contactDateAndTime.after(now)) {
        setErrorMessage("txtDtDtContactOccurred", Messages.MSG_SVC_NO_FUTURE_DATE);
      }
      // if Intake Date is not null and the Contact Date is before the Intake date
      /*
       * org.exolab.castor.types.Date intakeDate = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
       * "hdnIntakeDate"));
       * 
       * if ((DateHelper.NULL_CASTOR_DATE.equals(intakeDate) == false) && DateHelper.isBefore(contactDate, intakeDate)) {
       * setErrorMessage("txtDtDtContactOccurred", Messages.MSG_CONTCT_DT_TOO_EARLY); }
       */
      // STGAP00011640: Get the intake time also for comparison. The Contact date and time
      // should not be before the intakeTime.
      String stringIntakeDate = ContextHelper.getStringSafe(request, "hdnIntakeDate");
      String stringIntakeTime = ContextHelper.getStringSafe(request, "hdnIntakeTime");
      Date intakeDate = null;
      intakeDate = DateHelper.toJavaDateSafe(stringIntakeDate);
      if (intakeDate != null) {
        intakeDate = DateHelper.toJavaDateSafe(intakeDate, stringIntakeTime);
      }
       
      if (contactDateAndTimeNotNull && !DateHelper.isNull(intakeDate) && contactDateAndTime.before(intakeDate)) {
        setErrorMessage("txtDtDtContactOccurred", Messages.MSG_CONTCT_DT_TOO_EARLY);
      }

      if (presentationMode.equals(ContactSearchListDetailConversation.DETAIL_CONTACT)) {
        // SIR 18317 Changed "cbx" to "cbxUlIdPerson" because checkboxHelper was
        // comparing only cbx which of course cbxBInd starts with it so it was
        // getting errouneously added to the Array.
        String[] collateralsPrincipalsArray = CheckboxHelper.getCheckedValues(request, "cbxUlIdPerson");

        // if Name of Agency entered but No Others Contact, complain
        String nmOfAgency = ContextHelper.getStringSafe(request, "szNmAgencyName");
        String others = ContextHelper.getStringSafe(request, "selSzCdContactOthers");

        if (!("".equals(nmOfAgency)) && "".equals(others) && ulIdPortalUser == 0 ) {
          setErrorMessage(Messages.MSG_OTHERS_CONT);
        }

        // If no principals or others were selected, complain
        if ((collateralsPrincipalsArray.length == 0) && ("".equals(others))) {
          setErrorMessage(Messages.MSG_SVC_NO_PERSON_CONTACTED);
        }

        // SIR 23410. Display an error message if Not even one collaterals or Principals are selected and
        // Contract Type: CLES or CLEV
        if ((collateralsPrincipalsArray.length == 0)
            && ((type.equals(CodesTables.CCNTCTYP_CLES)) || (type.equals(CodesTables.CCNTCTYP_CLEV)))) {
          setErrorMessage(Messages.MSG_SVC_NO_PERSON_SELECTED);
        }

        //String purpose = ContextHelper.getStringSafe(request, "selSzCdContactPurpose");
        //STGAP00014326 MR-024
        String[] checkedPurposeOptionsList = CheckboxHelper.getCheckedValues(request, "cbxContactPurpose");
        if (checkedPurposeOptionsList.length < 1 ) {
         setErrorMessage(Messages.MSG_PUR_REQ);
        }

        // SMS #109398: MR-086 
        // User selects a Purpose of Collateral without at least one person selected as Discussed/In Reference To
        String[] checkedDiscussedPersonsList = CheckboxHelper.getCheckedValues(request, "cbxDiscussed");
        for(int i=0; i < checkedPurposeOptionsList.length ; i++){
          if(CodesTables.CCNTPURP_CVS.equals(checkedPurposeOptionsList[i]) && checkedDiscussedPersonsList.length < 1){
            setErrorMessage(Messages.MSG_DISCUSSED_REQ);
            break;
          }
        }
        // End SMS #109398: MR-086 
        
        // If purpose is a TCM and Method is "" complain
        if ("".equals(method)) {
          for (int i = 0; i < tcmArray.length; i++) {
            // MR-024 Now the Purpose has multiple options So compare with each Purpose selected
            for (int j = 0; j < checkedPurposeOptionsList.length; j++) {
              String purpose = checkedPurposeOptionsList[j];
              if (purpose.equals(tcmArray[i])) {
                setErrorMessage("selSzCdContactMethod", Messages.SSM_COMPLETE_REQUIRED);
                break;
              }
            }
          }
        }
        
        

        // If method requires a location complain if it's empty
        
        if ("".equals(location)) {
          for (int i = 0; i < methodArray.length; i++) {
            if (method.equals(methodArray[i])) {
              setErrorMessage("selSzCdContactLocation", Messages.SSM_COMPLETE_REQUIRED);
            }
          }
        }

        // If more than 100 Principals/Collaterals were checked, yell at 'em about it!
        if (collateralsPrincipalsArray.length > 100) {
          setErrorMessage(Messages.MSG_SVC_TOO_MANY_CONCTACTS);
        }

        // -- Add TCM Information validation
        if (type.endsWith("TCM")) {
          String cdStage = GlobalData.getSzCdStage(request);
          String eligible = ContextHelper.getStringSafe(request, "selEligible");
          if (!CodesTables.CSTAGES_ADO.equals(cdStage) && !CodesTables.CSTAGES_SUB.equals(cdStage)) {
            if ("".equals(eligible)) {
              setErrorMessage("selEligible", Messages.MSG_SVC_TCM_ELIG);
            }
          }
          if (CodesTables.CINFPKRQ_Y.equals(eligible)) {
            String[] eligibleCbx = CheckboxHelper.getCheckedValues(request, "cbxEligProgs_");
            if (eligibleCbx.length < 1) {
              setErrorMessage(Messages.MSG_SVC_TCM_ELIG_PROG);
            }
          }
          if (CodesTables.CINVACAN_Y.equals(ContextHelper.getStringSafe(request, "selMedSvcs"))) {
            String[] medSvcsCbx = CheckboxHelper.getCheckedValues(request, "cbxSvcsProvided_");
            if (medSvcsCbx.length < 1) {
              setErrorMessage(Messages.MSG_SVC_TCM_SVC);
            }
          }
        }
      }

      boolean usesSummaryDates = ContextHelper.getBooleanSafe(request, "usesSummaryDates");

      if ((presentationMode.equals(ContactSearchListDetailConversation.SUMMARY_CONTACT)) && (usesSummaryDates)) {
        org.exolab.castor.types.Date fromDate = DateHelper
                                                          .toCastorDateSafe(ContextHelper
                                                                                         .getStringSafe(request,
                                                                                                        "txtDtDtMonthlySummBegin"));

        org.exolab.castor.types.Date toDate = DateHelper
                                                        .toCastorDateSafe(ContextHelper
                                                                                       .getStringSafe(request,
                                                                                                      "txtDtDtMonthlySummEnd"));

        // If the From or To dates are null complain
        if (fromDate == null) {
          setErrorMessage("txtDtDtMonthlySummEnd", Messages.SSM_COMPLETE_REQUIRED);
        }

        if (toDate == null) {
          setErrorMessage("txtDtDtMonthlySummBegin", Messages.SSM_COMPLETE_REQUIRED);
        }

        if (DateHelper.isAfter(fromDate, toDate)) {
          setErrorMessage("txtDtDtMonthlySummBegin", Messages.MSG_SVC_FROM_BEFORE_TO);
        }
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
