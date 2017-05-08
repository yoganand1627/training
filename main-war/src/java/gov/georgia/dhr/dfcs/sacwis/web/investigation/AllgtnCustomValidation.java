//Declare your class pacakge
package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to perform the custom validation on Allegation Detail, Facility Allegation Detail, and Injury
 * Detail when the user chooses to Saves.
 *
 * @author Rodrigo DeJuana 11/19/2002
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/15/03  dickmaec     SIR 19857 -- ContextHelper.get...
 *         replaces getInputValue();
 *         <p/>
 *         10/15/03  dickmaec     As part of SIR 19857, all messages where shorted from
 *         MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX. 6/11/2004
 *         gerryc       SIR 22950 - reversed date check so the error message MSG_INV_INCDNT_BEFORE_INCMG displays if the
 *         incident date is after the incoming call date.  Previously it was showing if the incident date was before the
 *         incoming call date.
 *         05/26/2010  hjbaptiste SMS#51977-MR66-Maltreatment In Care: Added additional validation to check for Maltreatment 
 *                                in Care
 */

/**
 * Change History:
*  Date      User      Description
*  --------  --------  --------------------------------------------------
* 09/08/2009  bgehlot  STGAP00015366: Removed the message MSG_MAL_REL_REQUIRED.  
* 01/20/2012  habraham STGAP00017829 - MR-097 : Unsubstantiated MIC - The method signature for the checkIfMaltreatmentInCare 
 *                         						   to the Common bean has changed and added the logic for unSubstantiated MIC
* <pre>
*/
public class AllgtnCustomValidation extends FormValidation {

  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean maltreatmentInCare = false;
    String pageType = ContextHelper.getStringSafe(request, "pageType");
    if ("FacAllgtnDetail".equals(pageType)) {
      validateFacAllgtnDetail();
    } else if ("AllgtnDetail".equals(pageType)) {
      validateAllgtnDetail();
    } else if ("InjuryDetail".equals(pageType)) {
      validateInjuryDetail();
    }
    // EXTREMELY IMPORTANT: Always keep this call to checkIfMaltreatmentInCare() last, prior to returning. All other messages need
    // to be set prior to setting Messages.MSG_DUMMY_MSG. This dummy message has no text and is only set to 
    // force the return to the jsp to force the user to confirm Maltreatment in Care
    if (this.getErrorMessages().isEmpty()) {
      maltreatmentInCare = checkIfMaltreatmentInCare(state);
    }
    return (this.getErrorMessages().isEmpty() && !maltreatmentInCare);
  }

  private void validateAllgtnDetail() {
    HttpServletRequest request = super.getRequest();
    
    boolean result = true;

    // If program is CPS and Disposition is Reason to Believe, Severity is required
    boolean bCPS = "CPS".equals(ContextHelper.getStringSafe(request, "hdnSzCdStageProgram"));
    String disp = ContextHelper.getStringSafe(request, "selCdAllegDisposition");
    String severity = ContextHelper.getStringSafe(request, "selSzCdAllegSeverity");
    
    if ("RTB".equals(disp) && "".equals(severity) && bCPS) {
      setErrorMessage("selSzCdAllegSeverity", Messages.MSG_SEVERITY_RTB_REQ);
    }

    // If Victim equals AP and the program is CPS, RCL, or CCL, then the victim can not equal the AP.
    String Victim = ContextHelper.getStringSafe(request, "selUlIdVictim");
    String AP = ContextHelper.getStringSafe(request, "selUlIdAllegedPerpetrator");
    String Program = ContextHelper.getStringSafe(request, "hdnSzCdStageProgram");
    String Mode = ContextHelper.getStringSafe(request, "hdnMode");
    if ((Victim.equals(AP)) &&
        ("CPS".equals(Program) || "RCL".equals(Program) || "CCL".equals(Program)) &&
        (!"Multi".equals(Mode))) {
      setErrorMessage("selUlIdAllegedPerpetrator", Messages.MSG_INT_VC_AP_NOT_SAME);
    }
    
    //If Maltreatment code is O1 then the disposition is Unsubstantiated.
    
    String maltreatmentCode = ContextHelper.getStringSafe(request, "selSzCdAllegMalCode");
    if(maltreatmentCode.equals("O1"))
    {
      String disposition = ContextHelper.getStringSafe(request, "selCdAllegDisposition");
      if(!disposition.equals("UNS"))
      {
        setErrorMessage("selCdAllegDisposition",Messages.MSG_INV_MAL_CODE_SUBST);
        result = false;
      }
    }
    //CAPTA Changes Added
    String indSevChildDeath = ContextHelper.getStringSafe(request, "indSevChildDeath");
    Date dtPriorNearFatalMaltrtmnt = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request,
                                                                      "dtPriorNearFatalMaltrtmnt"));
    
    //User attempts to save the allegation after entering the disposition without entering a severity.
    //Throwing Error "Severity is required when entering disposition."
    if ((disp != null && disp.trim().length() > 0) && 
                    (severity == null || (severity != null && severity.trim().length() <= 0))){
      setErrorMessage("selSzCdAllegSeverity",Messages.MSG_INV_SEV_REQ);
      result = false;      
    }
    
    //User attempts to save with Severity of Child Death without answering question regarding 
    //if the death was due to prior near fatality.
    //Throwing Error "If the child has died, enter whether or not the death was due to a 
    //prior maltreatment recorded as a Near Fatality."
    if ((severity != null && CodesTables.CSEVERTY_FT.equals(severity)) && 
                      (indSevChildDeath == null || (indSevChildDeath != null && 
                                      indSevChildDeath.trim().length() <= 0))){ 
      setErrorMessage(Messages.MSG_INV_PRIOR_NEAR_FATALITY_REQ);
      result = false;      
    }
    
    //User attempts to Save with Yes selected for prior near fatality on a maltreatment with a 
    //severity of Child Death without entering the date of the prior near fatality maltreatment.
    //Throwing Error "Yes has been recorded that child death was due to prior maltreatment 
    //recorded as a Near Fatality.  Please enter date of the prior maltreatment."
    if ((severity != null && CodesTables.CSEVERTY_FT.equals(severity)) && 
                    (indSevChildDeath != null && indSevChildDeath.equals("Y")) &&
                    (dtPriorNearFatalMaltrtmnt == null)){ 
      setErrorMessage("dtPriorNearFatalMaltrtmnt",Messages.MSG_INV_PRIOR_NEAR_FATALITY_DATE_REQ);
      result = false;      
    }
    
    //User attempts to save the page with the prior near fatality radio button selected as 
    //yes and/or date of prior maltreatment entered but with a severity of other than Child Death.
    //Throwing Error "Child Death has not been marked as the Severity.  Ensure that Yes has not been 
    //selected for child death was due to prior maltreatment and that no date of prior 
    //maltreatment has been entered."
    if ((severity != null && !CodesTables.CSEVERTY_FT.equals(severity)) && 
                    ((indSevChildDeath != null && indSevChildDeath.equals("Y")) ||
                    dtPriorNearFatalMaltrtmnt != null)){ 
      setErrorMessage("selSzCdAllegSeverity",Messages.MSG_INV_INC_PRIOR_NEAR_FATALITY_INFO);
      result = false;      
    }
    
    //User enters a maltreatment with a severity of Child Death and that no prior near fatality 
    //maltreatment is applicable, but enters a date of applicable prior near fatality maltreatment.
    //Throwing Error "You have recorded that Child Death was not due to prior Near Fatality maltreatment.  
    //Do not enter a value for the date of prior near fatality maltreatment."
    if ((severity != null && CodesTables.CSEVERTY_FT.equals(severity)) && 
                    (indSevChildDeath != null && !indSevChildDeath.equals("Y")) &&
                    (dtPriorNearFatalMaltrtmnt != null)){ 
      setErrorMessage("dtPriorNearFatalMaltrtmnt",Messages.MSG_INV_INC_PRIOR_NEAR_FATALITY_DATE);
      result = false;      
    }
  }

  private void validateFacAllgtnDetail() {
    HttpServletRequest request = super.getRequest();

    org.exolab.castor.types.Date dtIncomingCall = ContextHelper.getCastorDateSafe(request, ("hdnDtDtIncomingCall"));
    org.exolab.castor.types.Date dtAllgtn = ContextHelper.getCastorDateSafe(request, "txtDtDtFacilAllegIncident");
    org.exolab.castor.types.Date dtInv = ContextHelper.getCastorDateSafe(request, "txtDtDtFacilAllegInvstgtr");
    org.exolab.castor.types.Date dtSuper = ContextHelper.getCastorDateSafe(request, "txtDtDtFacilAllegSuprReply");

    // Allegation Date is before date of incoming call.
    // SIR 22950 corrected the order in the isBefore method call
    if (dtIncomingCall != null && dtAllgtn != null && DateHelper.isBefore(dtIncomingCall, dtAllgtn)) {
      setErrorMessage("txtDtDtFacilAllegIncident", Messages.MSG_INV_INCDNT_BEFORE_INCMG);
    }
    // Investigators Findings date is after incomgin call and before today
    if (dtIncomingCall != null && dtInv != null &&
        DateHelper.isBefore(dtInv, dtIncomingCall)) {
      setErrorMessage("txtDtDtFacilAllegInvstgtr", Messages.MSG_INV_FIND_DT_BEFORE_INCMNG);
    }

    if (dtInv != null && DateHelper.isAfterToday(dtInv)) {
      setErrorMessage("txtDtDtFacilAllegInvstgtr", Messages.MSG_INV_FINDINGS_FUTURE);
    }

    // Supervisors Findings date is after incomgin call and before today
    if (dtIncomingCall != null && dtSuper != null &&
        DateHelper.isBefore(dtSuper, dtIncomingCall)) {
      setErrorMessage("txtDtDtFacilAllegSuprReply", Messages.MSG_INV_FIND_DT_BEFORE_INCMNG);
    }
    if (dtSuper != null && DateHelper.isAfterToday(dtSuper)) {
      setErrorMessage("txtDtDtFacilAllegSuprReply", Messages.MSG_INV_FINDINGS_FUTURE);
    }

    // If Neglect is the allegation selected, Neglect Type is required.
    String Allgtn = ContextHelper.getStringSafe(request, "selSzCdAllegType");
    String NegType = ContextHelper.getStringSafe(request, "selSzCdFacilAllegNeglType");
    if ("NEGL".equals(Allgtn) && "".equals(NegType)) {
      setErrorMessage("selSzCdFacilAllegNeglType", Messages.MSG_NEGLECT_TYPE_REQ);
    }

    // For both findings sections, either all fields must be entered or none at all.
    boolean bInvDate = "".equals(ContextHelper.getStringSafe(request, "txtDtDtFacilAllegInvstgtr"));
    boolean bInvDisp = "".equals(ContextHelper.getStringSafe(request, "selCdAllegDisposition"));
    boolean bInvClass = "".equals(ContextHelper.getStringSafe(request, "selSzFacilAllegInvClass"));
    boolean bInvSrc = "".equals(ContextHelper.getStringSafe(request, "selSzCdFacilAllegSrc"));
    if (!((bInvDate && bInvDisp && bInvClass && bInvSrc) ||
          (!bInvDate && !bInvDisp && !bInvClass && !bInvSrc))) {
      setErrorMessage("txtDtDtFacilAllegInvstgtr", Messages.MSG_INV_FINDINGS_INFO);
    }

    boolean bSupDate = "".equals(ContextHelper.getStringSafe(request, "txtDtDtFacilAllegSuprReply"));
    boolean bSupDisp = "".equals(ContextHelper.getStringSafe(request, "selSzCdFacilAllegDispSupr"));
    boolean bSupClass = "".equals(ContextHelper.getStringSafe(request, "selSzCdFacilAllegClssSupr"));
    boolean bSupSrc = "".equals(ContextHelper.getStringSafe(request, "selSzCdFacilAllegSrcSupr"));
    if (!((bSupDate && bSupDisp && bSupClass && bSupSrc) ||
          (!bSupDate && !bSupDisp && !bSupClass && !bSupSrc))) {
      setErrorMessage("txtDtDtFacilAllegSuprReply", Messages.MSG_INV_FINDINGS_INFO);
    }

    // If an Injury exists, Seriousness of Injuries can not be N/A
    boolean bInjSer = "NTA".equals(ContextHelper.getStringSafe(request, "selSzCdFacilAllegInjSer"));
    boolean InjuryFlag = "true".equals(ContextHelper.getStringSafe(request, "hdnInjuryFlag"));
    if (bInjSer && InjuryFlag) {
      setErrorMessage("selSzCdFacilAllegInjSer", Messages.MSG_INV_INJ_NO_PHYS);
    }

    if (super.isButtonPressed("btnDeleteInjury") &&
        ContextHelper.getStringSafe(request, "rbRowIndex").length() == 0) {
      setErrorMessage("You must select an injury to perform this action.");
    }
  }

  private void validateInjuryDetail() {
    HttpServletRequest request = super.getRequest();

    // Injury date must be prior to today and after 9/1/1992.
    org.exolab.castor.types.Date dtPast = DateHelper.toCastorDateSafe("9/1/1992");
    org.exolab.castor.types.Date dtInjury = ContextHelper.getCastorDateSafe(request, "txtDtFacilInjuryDtrmntn");
    if (!"".equals(ContextHelper.getStringSafe(request, "txtDtFacilInjuryDtrmntn"))) {
      if (dtInjury != null && DateHelper.isAfterToday(dtInjury)) {
        setErrorMessage("txtDtFacilInjuryDtrmntn", Messages.MSG_MED_DTR_DT_GRTR_CUR_DT);
      }
      if (dtInjury != null && DateHelper.isBefore(dtInjury, dtPast)) {
        setErrorMessage("txtDtFacilInjuryDtrmntn", Messages.MSG_MED_DTR_DT_BEFORE_SEPT92);
      }
    }

  }
  
  private boolean checkIfMaltreatmentInCare(BaseSessionStateManager state) {
    HttpServletRequest request = super.getRequest();
    int idCase = GlobalData.getUlIdCase(request);
    boolean maltreatmentInCare = false;
    
    boolean isMIC= false;
    boolean isUnSubMIC =false;
    state.removeAttribute("indMaltreatInCare", request);
    String cdAllegDisposition = ContextHelper.getStringSafe(request, "selCdAllegDisposition");
    String cdStageType = CodesTables.CSTAGES_INV;
    
    String cdMaltreatorRel = ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel");
    // Once the Disposition is entered the Malreator relationship dropdown is hidden. 
    if(StringHelper.EMPTY_STRING.equals(cdMaltreatorRel)){
      cdMaltreatorRel = ContextHelper.getStringSafe(request, "hdnSzCdMaltreatorRel");
    }
    // The variable hdnUpdateMaltreatInCare is to tell you whether you need to re_check the Maltreatment in Care Popup message.
      if (!ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnUpdateMaltreatInCare"))) {
      state.removeAttribute("warnMaltreatmentInCare", request);
      if (super.isButtonPressed("btnSave")) {
    	  
    	  //MR-097 changes    - 01/17/2012    
    	  //The  methodsignature is chaned to return a Map which contins the indicator for Maltreatment in care 
    	  //and the Unsubstantiated MIC 
    	
    	Map<String, Boolean> mapMIC = AllgtnConversation.checkIfMaltreatmentInCare(ContextHelper.getIntSafe(request, "selUlIdVictim"), idCase,
                DateHelper.toJavaDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "dtDtAllegedIncident"))),
                getEjb(Common.class), cdAllegDisposition, cdStageType, cdMaltreatorRel);
    	if (mapMIC !=null  && mapMIC.get("isMIC")!=null)
    		   isMIC = mapMIC.get("isMIC");
    	if (mapMIC !=null  && mapMIC.get("isUnSubMIC")!=null)
    		isUnSubMIC = mapMIC.get("isUnSubMIC");
    	
        if (isMIC){
          state.setAttribute("warnMaltreatmentInCare", ArchitectureConstants.Y, request);
          state.setAttribute("indMaltreatInCare", ArchitectureConstants.Y, request);
          state.setAttribute("indUnSubstantiatedMIC", ArchitectureConstants.N, request);
          maltreatmentInCare = true;
        }else if(isUnSubMIC){
    		state.setAttribute("warnMaltreatmentInCare", ArchitectureConstants.Y, request);
    		state.setAttribute("indUnSubstantiatedMIC", ArchitectureConstants.Y, request);
    		state.setAttribute("indMaltreatInCare", ArchitectureConstants.N, request);
    		maltreatmentInCare = true;
    	}else {
          state.setAttribute("warnMaltreatmentInCare", ArchitectureConstants.N, request);
          state.setAttribute("indMaltreatInCare", ArchitectureConstants.N, request);
          state.setAttribute("indUnSubstantiatedMIC", ArchitectureConstants.N, request);
        }
      }
    }else {
      if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnIndMaltreatInCare"))) {
        state.setAttribute("indMaltreatInCare", ArchitectureConstants.Y, request);
        state.setAttribute("indUnSubstantiatedMIC", ArchitectureConstants.N, request);
      }else  if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnIndUnSubstantiatedMIC"))) {
          state.setAttribute("indMaltreatInCare", ArchitectureConstants.N, request);
          state.setAttribute("indUnSubstantiatedMIC", ArchitectureConstants.Y, request);
       }
      
      else {
        state.setAttribute("indMaltreatInCare", ArchitectureConstants.N, request);
        state.setAttribute("indUnSubstantiatedMIC", ArchitectureConstants.N, request);
      }
    }		
    return maltreatmentInCare;
  }
}

