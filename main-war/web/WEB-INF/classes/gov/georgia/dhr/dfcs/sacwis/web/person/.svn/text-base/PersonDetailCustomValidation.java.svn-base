package gov.georgia.dhr.dfcs.sacwis.web.person;

// -- architecture classes --

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO_ADD_PERSON_TO_STAGES_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;



/**
 * PersonDetail Custom validation class <p>Description:  This class verifies all of the information in the Person Detail
 * conversation </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: Accenture </p>
 *
 * @author Anna Grimshaw
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed Message Lookup 05/06/04
 *          CORLEYAN     SIR 22869 -- Make sure if the user has entered an Eth that a Race is entered, and vice versa.
 *          11/04/04  CORLEYAN     SIR 23247 -- Ensure that the user cannot delete a Primary Child (PC) 12/17/04
 *          CORLEYAN     SIR 23271 -- Require DOB or Age for all PRNs in CPS cases beyond INV.
 *          02/08/2010   mxpatel       CAPTA: Added validations for CAPTA changes
 *          03/16/2010   arege      SMS#47119: Removed Validation messages of MSG_CASA_GAL_ASSIGN_DATE_REQ, MSG_CASA_GAL_DATE_ASSIGNED_UNASSIGNED, 
 *                                  MSG_ASSIGN_UNASSIGN_DATE_FUTURE and MSG_CASA_GAL_INC_DATES from here to CustomValidation
 *          05/19/2011   arege      SMS#108263 Added validation message 'A person with Relationship of CASA, GAL Atty and GAL Non-Atty cannot be less than 18 yrs of age'
 *          09/12/2011   hnguyen    STGAP00017011: MR-092 Added validation Person Characteristics SSI related questions
 *          09/13/2011   schoi      STGAP00017013: MR-095 Added validation MSG_ERR_TYPE_AND_REL_REQ for Add Person to Active Stages section
 *          09/14/2011   hnguyen    STGAP00017011: MR-092 Update logic to not validate SSI question 
 *                                  if Person Characteristics section does not display.
 *          10/25/2011   hnguyen    STGAP00017375: Only validate SSI questions for primary child only.
 */

public class PersonDetailCustomValidation extends FormValidation {
  
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    RaceEthnicityBean reBean = new RaceEthnicityBean();

    String hdnSzCdStagePersType = ContextHelper.getStringSafe(request, "hdnSzCdStagePersType");
    String selSzCdStagePersType = ContextHelper.getStringSafe(request, "selSzCdStagePersType");
    String selSzCdStagePersRelInt = ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt");
    String cScrIndDupAlleg = ContextHelper.getStringSafe(request, "hdnCScrIndDupAlleg");
    String bIndActiveEvent = ContextHelper.getStringSafe(request, "hdnBIndActiveEvent");
    org.exolab.castor.types.Date dob = ContextHelper.getCastorDateSafe(request, "txtDateDtPersonBirth");
    org.exolab.castor.types.Date dod = ContextHelper.getCastorDateSafe(request, "txtDateDtPersonDeath");
    org.exolab.castor.types.Date dateLegRepAssigned = ContextHelper.getCastorDateSafe(request, "txtDateDtLegRepAssigned");
    org.exolab.castor.types.Date dateLegRepUnAssigned = ContextHelper.getCastorDateSafe(request,"txtDateDtLegRepUnassigned");
    String szCdStageProgram = ContextHelper.getStringSafe(request, "hdnSzCdStageProgram");
    String szCdStage = ContextHelper.getStringSafe(request, "hdnSzCdStage");
    String szCdPersonMaritalStatus = ContextHelper.getStringSafe(request, "selSzCdPersonMaritalStatus");
    String cSysIndHomeRemovePers = ContextHelper.getStringSafe(request, "hdnCSysIndHomeRemovePers");
    String szCdPersonDeath = ContextHelper.getStringSafe(request, "selSzCdPersonDeath");
    String first = ContextHelper.getStringSafe(request, "txtSzNmNameFirst");
    String middle = ContextHelper.getStringSafe(request, "txtSzNmNameMiddle");
    String last = ContextHelper.getStringSafe(request, "txtSzNmNameLast");
    String suffix = ContextHelper.getStringSafe(request, "selSzCdNameSuffix");
    // SIR 23247
    String szCdStagePersRole = ContextHelper.getStringSafe(request, "dspSzCdStagePersRole");
    // SIR 23271
    String lNbrPersonAge = ContextHelper.getStringSafe(request, "txtLNbrPersonAge");
    String bIndSafetyRsrcCase = ContextHelper.getStringSafe(request, "hdnBIndSafetyRsrcCase");
    String cdStage = GlobalData.getSzCdStage(request);
    
    // MR-092
    // get pageMode for validation
    String overallPageMode = PageMode.getPageMode(request);
    
    // Person Characteristics: SSI related question for child under 18
    String indSsiAppSubmitted = ContextHelper.getStringSafe(request, "rbSsiAppSubmitted");
    String indSsiMedDsbltyReqMet = ContextHelper.getStringSafe(request, "rbSsiMedDsbltyReqMet");
    String indSsiRecipient = ContextHelper.getStringSafe(request, "rbSsiRecipient");
    String indSsiDfcsPayee = ContextHelper.getStringSafe(request, "rbSsiDfcsPayee");

    if (super.isButtonPressed("btnSave")) {    
      if ((CodesTables.CSRCRPTR_CS.equals(selSzCdStagePersRelInt)
                      || CodesTables.CSRCRPTR_GX.equals(selSzCdStagePersRelInt) || CodesTables.CSRCRPTR_GY
                                                                                                          .equals(selSzCdStagePersRelInt))) {
        if (dob != null) {
          int age = DateHelper.getAge(dob);
          if (age < 18) {
            setErrorMessage("txtLNbrPersonAge", Messages.MSG_AGE_18_REQD);
            result = false;
          }
        }
      }
      if (CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_SUB.equals(cdStage)) { 
        
     // When adding a person with a rel of CASA or GAL Atty or GAL Non-Atty Date Representation Assigned is required
        if ((CodesTables.CSRCRPTR_CS.equals(selSzCdStagePersRelInt)
             || CodesTables.CSRCRPTR_GX.equals(selSzCdStagePersRelInt) || CodesTables.CSRCRPTR_GY
                                                                                                 .equals(selSzCdStagePersRelInt))) {
          if ((dateLegRepAssigned == null)) {
            setErrorMessage("txtDateDtLegRepAssigned", Messages.MSG_CASA_GAL_ASSIGN_DATE_REQ);
            result = false;
          }

          // Date Unassigned should be greater than or equal to Date Representation Assigned.
          if (!DateHelper.isNull(dateLegRepUnAssigned) && DateHelper.isBefore(dateLegRepUnAssigned, dateLegRepAssigned)) {
            setErrorMessage(Messages.MSG_CASA_GAL_DATE_ASSIGNED_UNASSIGNED);
            result = false;
          }

          // Date assigned or unassigned should not be greater than the current date
          if (!DateHelper.isNull(dateLegRepUnAssigned) || !DateHelper.isNull(dateLegRepAssigned)) {
            if (DateHelper.isAfter(dateLegRepAssigned, DateHelper.getTodayCastorDate())
                || DateHelper.isAfter(dateLegRepUnAssigned, DateHelper.getTodayCastorDate())) {
              setErrorMessage(Messages.MSG_ASSIGN_UNASSIGN_DATE_FUTURE);
              result = false;
            }
          }
        }
              
    // Date assigned or unassigned may only be used for relationships of CASA or GAL Atty or GAL Non-Atty
        if (!(CodesTables.CSRCRPTR_CS.equals(selSzCdStagePersRelInt)
              || CodesTables.CSRCRPTR_GX.equals(selSzCdStagePersRelInt) || CodesTables.CSRCRPTR_GY
                                                                                                  .equals(selSzCdStagePersRelInt))
            && (dateLegRepAssigned != null) /* || (cinv05si.getDtDtLegRepUnassigned() != null) */
        ) {
          setErrorMessage(Messages.MSG_CASA_GAL_INC_DATES);
          result = false;
        }
    
   }//End of if ADO or SUB stage
      
      /*
      ** Check to see if the original type was prinicpal, if so we need to
      ** check to that it can be changed.  A person must remain as principal
      ** if they are involved in an allegation, they are involved in an event,
      ** or they were at home at the time of removal.
      */
      if ("PRN".equals(hdnSzCdStagePersType) && "COL".equals(selSzCdStagePersType)) {
        /*
         ** Inform the user that the person cannot be deleted and exit
         ** call back.  NOTE bIndActiveEvent is flag returned from
         ** the service which indicates where or not a person is active
         ** in any non approved events. CScrIndDupAlleg
         ** is returned from a service to indicate if a person is
         ** in a Allegation
        */
        if (cScrIndDupAlleg.equals(ArchitectureConstants.Y)) {
          setErrorMessage("selSzCdStagePersType", Messages.MSG_INV_ALLEG_COLL);
          result = false;
        }
        if (bIndActiveEvent.equals(ArchitectureConstants.Y)) {
          setErrorMessage("selSzCdStagePersType", Messages.MSG_INV_EVT_COLL);
          result = false;
        }
        if (cSysIndHomeRemovePers.equals(ArchitectureConstants.Y)) {
          setErrorMessage("selSzCdStagePersType", Messages.MSG_PERS_REMOVAL_PRINCPL);
          result = false;
        }

      }//End if type is being changed from prn

      if ("PRN".equals(selSzCdStagePersType)) {
        if (szCdStageProgram.equals(PersonDetailConversation.CPS) &&
            !szCdStage.equals(PersonDetailConversation.INT)) {
          if (szCdPersonMaritalStatus.equals(StringHelper.EMPTY_STRING)) {
            setErrorMessage("selSzCdPersonMaritalStatus",
                            Messages.MSG_INV_NO_MAR_STAT);
            result = false;
          }
          if (!(RaceEthnicityHelper.isEthnicityChecked(request) &&
                RaceEthnicityHelper.isRaceChecked(request))) {
            setErrorMessage(Messages.MSG_INV_NO_RAC_STAT);
            result = false;
          }
        }

        // SIR 23271 - If it is CPS Case, and is in a stage beyond INV
        // (not INV OR INT), DOB is required for all PRNs.
        if (szCdStageProgram.equals(PersonDetailConversation.CPS) &&
            !szCdStage.equals(PersonDetailConversation.INT) &&
            !szCdStage.equals(PersonDetailConversation.INV) &&
            dob == null &&
            "".equals(lNbrPersonAge)) {
          setErrorMessage("txtDateDtPersonBirth", Messages.MSG_DOB_REQ);
          result = false;
        }
        
        // MR-092 if Person Characteristics section does not display then do not validate
        // validation only for primary child
        if (!(Sets.isInSet(Sets.E, request) 
        		|| overallPageMode.equals(PageModeConstants.NEW) 
        		|| Sets.isInSet(Sets.F, request))
            && CodesTables.CROLEALL_PC.equals(szCdStagePersRole)) {

          if (StringHelper.isEmptyOrNull(indSsiAppSubmitted)) {
            setErrorMessage(Messages.MSG_SSI_APP_SUBMITTED_REQ);
            result = false;
          } else if (ArchitectureConstants.Y.equals(indSsiAppSubmitted)
                     && StringHelper.isEmptyOrNull(indSsiMedDsbltyReqMet)) {
            setErrorMessage(Messages.MSG_SSI_ELIGIBLE_REQ);
            result = false;
          } else if (ArchitectureConstants.Y.equals(indSsiAppSubmitted)
                     && ArchitectureConstants.Y.equals(indSsiMedDsbltyReqMet)
                     && StringHelper.isEmptyOrNull(indSsiRecipient)) {
            setErrorMessage(Messages.MSG_RECV_SSI_PMT_REQ);
            result = false;
          } else if (ArchitectureConstants.Y.equals(indSsiAppSubmitted)
                     && ArchitectureConstants.Y.equals(indSsiMedDsbltyReqMet)
                     && ArchitectureConstants.Y.equals(indSsiRecipient) && StringHelper.isEmptyOrNull(indSsiDfcsPayee)) {
            setErrorMessage(Messages.MSG_DFCS_SSI_PAYEE_REQ);
            result = false;
          }
        }

      }//End if type is prn

      // SIR 22869
      if ((RaceEthnicityHelper.isEthnicityChecked(request) && !RaceEthnicityHelper.isRaceChecked(request)) ||
          (!RaceEthnicityHelper.isEthnicityChecked(request) && RaceEthnicityHelper.isRaceChecked(request))) {
        setErrorMessage(Messages.SSM_ETHNIC_AND_RACE);
        result = false;
      }
      
      //DOD and DOB must be on or before today's date
      if (dob != null && DateHelper.isAfterToday(dob)) {
        setErrorMessage("txtDateDtPersonBirth", Messages.MSG_INV_DT_BIRTH);
        result = false;
      }

      if (dod != null && DateHelper.isAfterToday(dod)) {
        setErrorMessage("txtDateDtPersonDeath", Messages.MSG_INV_DT_DEATH_GT_TODAY);
        result = false;
      }
      //DOD must be Greater than or equal to DOB
      if (dob != null && dod != null && DateHelper.isBefore(dod, dob)) {
        setErrorMessage(Messages.MSG_INV_DT_DEATH_LT_DT_BIRTH);
        result = false;
      }
      //DOD has been entered, Reason for death is required
      if (dod != null && szCdPersonDeath.equals(StringHelper.EMPTY_STRING)) {
        setErrorMessage("selSzCdPersonDeath", Messages.MSG_REAS_DEATH);
        result = false;
      }
      //DOD has been entered, DOB is required
      if (dod != null && dob == null) {
        setErrorMessage("txtDateDtPersonBirth", Messages.MSG_DOB);
        result = false;
      }
      //Reason For death has been entered, DOB and DOD are required
      if (!szCdPersonDeath.equals(StringHelper.EMPTY_STRING) && dod == null && dob == null) {
        setErrorMessage(Messages.MSG_DOD_DOB_REA);
        result = false;
      }
      //Middle Name has been entered, First Name or Last Name is required
      if (!middle.equals(StringHelper.EMPTY_STRING) && first.equals(StringHelper.EMPTY_STRING) &&
          last.equals(StringHelper.EMPTY_STRING)) {
        setErrorMessage(Messages.MSG_MDL_NO_FIRST_LAST);
        result = false;
      }
      //Suffix has been entered, First Name or Last Name is required
      if (!suffix.equals(StringHelper.EMPTY_STRING) && first.equals(StringHelper.EMPTY_STRING) &&
          last.equals(StringHelper.EMPTY_STRING)) {
        setErrorMessage(Messages.MSG_SFX_NO_FIRST_LAST);
        result = false;
      }
      
      // STGAP00017013: MR-095
      BaseSessionStateManager state = super.getState();
      CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);
      CINV04SO_ADD_PERSON_TO_STAGES_ARRAY cinv04so_add_person_to_stages_array = cinv04so.getCINV04SO_ADD_PERSON_TO_STAGES_ARRAY();
      int i = 0;
      if (cinv04so_add_person_to_stages_array != null) {
        Enumeration e = cinv04so_add_person_to_stages_array.enumerateCINV04SO_ADD_PERSON_TO_STAGES();
        while (e.hasMoreElements()) {
          CINV04SO_ADD_PERSON_TO_STAGES row = (CINV04SO_ADD_PERSON_TO_STAGES) e.nextElement();

          String cbxName = "cbxName_" + ( i + 1 );
          String cdStagePersTypeAddPerson = "selSzCdStagePersTypeAddPerson_" + ( i + 1 );
          String cdStagePersRelIntHistory = "selSzCdStagePersRelIntHistory_" + ( i + 1 );
          
          // Get the Type and Relationship values from the request for setting the value 
          // to the dropdown when the page is re-loaded after error happens
          String selSzCdStagePersTypeAddPerson = request.getParameter(cdStagePersTypeAddPerson);
          String selSzCdStagePersRelIntHistory = request.getParameter(cdStagePersRelIntHistory); 
          boolean stageChecked = "on".equals(request.getParameter(cbxName));
                  
          if (stageChecked) {
            if (selSzCdStagePersTypeAddPerson == null || "".equals(selSzCdStagePersTypeAddPerson) || selSzCdStagePersRelIntHistory == null 
                            || "".equals(selSzCdStagePersRelIntHistory)) {
              setErrorMessage(Messages.MSG_ERR_TYPE_AND_REL_REQ);
              result = false;
              break;
            }
          }
          i++;
        }        
      }      
      // End STGAP00017013: MR-095
      
    }//End if btnSave pressed

    if (super.isButtonPressed("btnDeletePer"))
      /*
       ** Inform the user that the person cannot be deleted and exit
       ** call back.  NOTE bIndActiveEvent is flag returned from
       ** the service which indicates where or not a person is active
       ** in any non approved events. CScrIndDupAlleg
       ** is returned from a service to indicate if a person is
       ** in a Allegation
      */ {
      if (cScrIndDupAlleg.equals(ArchitectureConstants.Y)) {
        setErrorMessage(Messages.MSG_INV_ALLEG_DELETE);
        result = false;
      }
      if (bIndActiveEvent.equals(ArchitectureConstants.Y)) {
        setErrorMessage(Messages.MSG_INV_EVT_DELETE);
        result = false;
      }
      if (cSysIndHomeRemovePers.equals(ArchitectureConstants.Y)) {
        setErrorMessage(Messages.MSG_PERS_REMOVAL_DELETE);
        result = false;
      }
      // SIR 23247
      if ("PC".equals(szCdStagePersRole)) {
        setErrorMessage(Messages.MSG_PC_NO_DELETE);
        result = false;
      }
      if ((szCdStage.equals(PersonDetailConversation.INV)|| szCdStage.equals(PersonDetailConversation.FPR))&& bIndSafetyRsrcCase.equals(ArchitectureConstants.Y)) {
        setErrorMessage(Messages.MSG_SRP_PERSON_DELETE);
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
  public static final String TRACE_TAG = "PersonDetailCustomValidation";
}