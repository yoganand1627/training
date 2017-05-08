package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to perform the custom validation on Legal Status when the user attempts Save.
 *
 * @author Carolyn Douglass 2/20/03
 *         <p/>
 *         Change History: 
 *         Date      User         Description --------  -----------
 *         ---------------------------------------------- 
 *         10/14/03  dejuanr      SIR 19857 -- ContextHelper.get...
 *                                replaces getInputValue(); 6/17/04   C.Douglass   SIR 22873 - Date Filed and Outcome will no longer be used in
 *                                CPS.
 *         03/03/09  mxpatel      STGAP00012021: removed quotes from  Messages.MSG_TPR_REQ to display the message properly.  
 *         07/10/09  cwells       STGAP00014337 : added check court order signed and court order date when RCO is the action                
 *         03/01/11  schoi        SMS #97845: MR-074-2 Added logic to include the TPR Putative Father in MSG_TPR_REQ
 */
public class LegalActionsCustomValidation extends FormValidation {
  /**
   * <p>This method contains custom validation that is checked when the user tries to Save.</p>
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean result = true;
    String selAction = ContextHelper.getStringSafe(request, "selLegalAction");
    
    if (super.isButtonPressed(SAVE_BUTTON)) {
      if ("on".equals(ContextHelper.getStringSafe(request, "cbxComplete"))) {
        if (CodesTables.CLEGCPS_FCP.equals(selAction) ||
            CodesTables.CLEGCPS_LAR.equals(selAction)) {
          setErrorMessage(Messages.MSG_INVALID_SAVE_AND_COMPLETE);
          result = false;
        }
      }
    }
    String selHrTypCrtOrd = ContextHelper.getStringSafe(request, "selHTypeCtOrder");
    String dtCtOrderDate = ContextHelper.getStringSafe(request, "dtCtOrderDate"); 
    String cbxCtOrderSigned = ContextHelper.getStringSafe(request, "cbxCtOrderSigned"); 
    
    if(CodesTables.CLEGCPS_HRG.equals(selAction) || CodesTables.CLEGCPS_RCO.equals(selAction) || CodesTables.CLEGCPS_COF.equals(selAction)){
      if("".equals(selHrTypCrtOrd)){
        //-- use the following line when the message is added to the db 
        setErrorMessage("selHTypeCtOrder", Messages.MSG_HR_TYP_CRT_ORD_REQ);
        result = false;
      }
    }
    // STGAP00014337 User attempts to save a legal action of Receive Court Order but has not entered a court order date and/or selected the court order signed checkbox
    if(CodesTables.CLEGCPS_RCO.equals(selAction)&& (!"on".equals(cbxCtOrderSigned) ||  dtCtOrderDate == null || "".equals(dtCtOrderDate) )  ){
      setErrorMessage(Messages.MSG_REC_COURT_ORDER);
      result = false;
    }
    
    if(CodesTables.CLEGCPS_RSC.equals(selAction)){
      String dtShelterCareAuth = ContextHelper.getStringSafe(request, "dtShelterCareAuth");
      if("".equals(dtShelterCareAuth)){
        setErrorMessage("dtShelterCareAuth", "Field is required when Action is 'Request For Shelter Care.'");
        result = false;
      }
      
      String tmShelterCareAuth = ContextHelper.getTimeSafe(request, "tmShelterCareAuth");
      if("".equals(tmShelterCareAuth)){
        setErrorMessage("tmShelterCareAuth", "Field is required when Action is 'Request For Shelter Care.'");
        result = false;
      }
    }
    // SMS #97845: MR-074-2
    // Added TPR-Putative Father (CLHECOT_TPP) to the condition
    if(CodesTables.CLEGCPS_COF.equals(selAction) && !CodesTables.CLHECOT_TPM.equals(selHrTypCrtOrd)
                    && !CodesTables.CLHECOT_TFL.equals(selHrTypCrtOrd)
                    && !CodesTables.CLHECOT_TFF.equals(selHrTypCrtOrd)
                    && !CodesTables.CLHECOT_TFB.equals(selHrTypCrtOrd)
                    && !CodesTables.CLHECOT_TPA.equals(selHrTypCrtOrd)
                    && !CodesTables.CLHECOT_TFA.equals(selHrTypCrtOrd)
                    && !CodesTables.CLHECOT_TPP.equals(selHrTypCrtOrd)){
      setErrorMessage("selHTypeCtOrder", Messages.MSG_TPR_REQ);//mxpatel 12021
      result = false;
    }
    /*
    org.exolab.castor.types.Date dtFiled = ContextHelper.getCastorDateSafe(request, "txtDtFiled");
    org.exolab.castor.types.Date dtOutcomeCourt = ContextHelper.getCastorDateSafe(request, "dtOutcomeCourt");
    String selLegalAction = ContextHelper.getStringSafe(request, "selLegalAction");
    String selOutcome = ContextHelper.getStringSafe(request, "selOutcome");

    if (super.isButtonPressed(SAVE_BUTTON)) {
      // Date Filed cannot be after today
      if (!dtFiled.equals(DateHelper.NULL_CASTOR_DATE) &&
          DateHelper.isAfterToday(dtFiled)) {
        setErrorMessage("txtDtFiled", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }

      // Outcome Court Date cannot be after today
      if (!dtOutcomeCourt.equals(DateHelper.NULL_CASTOR_DATE) &&
          DateHelper.isAfterToday(dtOutcomeCourt)) {
        setErrorMessage("dtOutcomeCourt", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      //SIR 22873 - this edit is no longer needed, since date filed is not
      //used for CPS anymore
      //if Legal Action is CCHE - Hearing (CPS), Date Filed cannot be entered
      //if( selLegalAction.equals( LegalActionsConversation.CPS_SUB_CCHE_TABLE )  &&
      //    !dtFiled.equals( DateHelper.NULL_CASTOR_DATE) )
      //{
      //    setErrorMessage( "txtDtFiled", Messages.MSG_NO_DATE_FILED );
      //    result = false;
      //}

      //SIR 22873 - Date Filed is required for APS
      if (GlobalData.getSzCdStageProgram(request).equals(LegalActionsConversation.APS_PROGRAM) &&
          dtFiled.equals(DateHelper.NULL_CASTOR_DATE)) {
        setErrorMessage("txtDtFiled", Messages.MSG_DATE_FILED_REQUIRED);
        result = false;
      }

      //if Outcome is entered, Outcome Date is also required
      if (!"".equals(selOutcome) &&
          dtOutcomeCourt.equals(DateHelper.NULL_CASTOR_DATE)) {
        setErrorMessage("dtOutcomeCourt", Messages.SSM_COMPLETE_REQUIRED_CON);
        result = false;
      }

      //SIR 22873 - Outcome isn't used for CPS anymore
      //if outcome is not filled, neither should outcome court date
      if (GlobalData.getSzCdStageProgram(request).equals(LegalActionsConversation.CPS_PROGRAM) &&
          dtOutcomeCourt.equals(DateHelper.NULL_CASTOR_DATE)) {
        setErrorMessage("dtOutcomeCourt", Messages.MSG_OTCOME_DT_COND_REQ);
        result = false;
      }

      //SIR 22873 - Outcome isn't used for CPS anymore
      //if outcome is not filled, neither should outcome court date
      if (GlobalData.getSzCdStageProgram(request).equals(LegalActionsConversation.APS_PROGRAM) &&
          "".equals(selOutcome) &&
          !dtOutcomeCourt.equals(DateHelper.NULL_CASTOR_DATE)) {
        setErrorMessage("dtOutcomeCourt", Messages.MSG_NO_OUTCOME_DATE);
        result = false;
      }
      //Outcome Court Date cannot be > Date Filed
      if (!dtFiled.equals(DateHelper.NULL_CASTOR_DATE) &&
          !dtOutcomeCourt.equals(DateHelper.NULL_CASTOR_DATE) &&
          DateHelper.isBefore(dtOutcomeCourt, dtFiled)) {
        setErrorMessage("dtOutcomeCourt", Messages.SSM_SUB_OUTCOME_LESS_FILED);
        result = false;
      }
    }
    */
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "LegalStatusCustomValidation";
  public static final String SAVE_BUTTON = "btnSave";
}