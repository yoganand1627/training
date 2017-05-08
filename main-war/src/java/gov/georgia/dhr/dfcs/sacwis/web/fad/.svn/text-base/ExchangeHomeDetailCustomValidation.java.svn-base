package gov.georgia.dhr.dfcs.sacwis.web.fad;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


/*Change History:
    Date           User                 Description
    --------       ----------------     --------------------------------------------------
    05/15/2009     mxpatel              STGAP00013292: added to code to display message to unlink all children before
                                        closing an exchange home.
    12/14/2009     arege                SMS#37206 Modified code so that error message to unlink all childeren is not displayed
                                        displayed for codes of 09, 10, 12, 15 and 16.
  */
public class ExchangeHomeDetailCustomValidation extends FormValidation {

  protected boolean validateForm() {
    boolean isValid = true;
    HttpServletRequest request = super.getRequest();

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxMentalRetardation"))) {
      String selSzCdMentalRetardation = ContextHelper.getStringSafe(request, "selSzCdMentalRetardation");
      if (selSzCdMentalRetardation == null || "".equals(selSzCdMentalRetardation)) {
        setErrorMessage("cbxMentalRetardation", Messages.MSG_NO_SEVERITY);
        isValid = false;
      }
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxVisualHearingImpairments"))) {
      String selSzCdVisualHearingImpairments = ContextHelper.getStringSafe(request, "selSzCdVisualHearingImpairments");
      if (selSzCdVisualHearingImpairments == null || "".equals(selSzCdVisualHearingImpairments)) {
        setErrorMessage("cbxVisualHearingImpairments", Messages.MSG_NO_SEVERITY);
        isValid = false;
      }
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxPhysicallyDisabled"))) {
      String selSzCdPhysicallyDisabled = ContextHelper.getStringSafe(request, "selSzCdPhysicallyDisabled");
      if (selSzCdPhysicallyDisabled == null || "".equals(selSzCdPhysicallyDisabled)) {
        setErrorMessage("cbxPhysicallyDisabled", Messages.MSG_NO_SEVERITY);
        isValid = false;
      }
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxEmotionallyDisturbed"))) {
      String selSzCdEmotionallyDisturbed = ContextHelper.getStringSafe(request, "selSzCdEmotionallyDisturbed");
      if (selSzCdEmotionallyDisturbed == null || "".equals(selSzCdEmotionallyDisturbed)) {
        setErrorMessage("cbxEmotionallyDisturbed", Messages.MSG_NO_SEVERITY);
        isValid = false;
      }
    }

    if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxOtherMedicalDiagnoses"))) {
      String selSzCdOtherMedicalDiagnoses = ContextHelper.getStringSafe(request, "selSzCdOtherMedicalDiagnoses");
      if (selSzCdOtherMedicalDiagnoses == null || "".equals(selSzCdOtherMedicalDiagnoses)) {
        setErrorMessage("cbxOtherMedicalDiagnoses", Messages.MSG_NO_SEVERITY);
        isValid = false;
      }
    }

    Date dtRegistered = ContextHelper.getJavaDateSafe(request, "dateRegistered");
    if(dtRegistered != null) {
      Date dtApproved = ContextHelper.getJavaDateSafe(request, "txtDateApproved");
      
      if (dtApproved == null || DateHelper.isBefore(dtRegistered, dtApproved)) {
        setErrorMessage("dateRegistered", Messages.MSG_REG_DT_BEFORE_APPROVED);
        isValid = false;
      }
    }
    
    Date dtReRegistered = ContextHelper.getJavaDateSafe(request, "dateReRegistered");
    if(dtReRegistered != null) {      
      if (dtRegistered == null || DateHelper.isBefore(dtReRegistered, dtRegistered)) {
        setErrorMessage("dateReRegistered", Messages.MSG_REREG_DT_BEFORE_REG);
        isValid = false;
      }
    }
    

    Date dateClosedNP = ContextHelper.getJavaDateSafe(request, "dateClosedNP");
    if(dateClosedNP != null) {   
      String selSzCdResaonClosed = ContextHelper.getStringSafe(request, "selSzCdResaonClosed");
      if (selSzCdResaonClosed == null || "".equals(selSzCdResaonClosed)) {
        setErrorMessage("selSzCdResaonClosed", Messages.MSG_EXH_REASON_REQ_CLOSED);
        isValid = false;
      }
    }
    
    String selSzCdResaonClosed = ContextHelper.getStringSafe(request, "selSzCdResaonClosed");
    if (selSzCdResaonClosed != null && selSzCdResaonClosed.length() > 0) {
      if (dateClosedNP == null) {
        setErrorMessage("dateClosedNP", Messages.MSG_EXH_DATE_REQ_CLOSED);
        isValid = false;
      }
    }
    
    String nonAvaReason = ContextHelper.getStringSafe(request, "selSzCdNonAvReasonHA");
    List<String> nolongerAviableCodes = new ArrayList<String>();
    //SMS#37206 Removed  codes 09,10,12, 15, 16 from the nolongerAviableCodes list.
    nolongerAviableCodes.add(CodesTables.CANONAV_11); //Closed/No Placement
    nolongerAviableCodes.add(CodesTables.CANONAV_17); //Reunify W/Other Parent
    if(nolongerAviableCodes.contains(nonAvaReason)) {
      int nonSelSize = ContextHelper.getIntSafe(request, ExchangeHomeDetailConversation.LINK_COUNT);
      if (nonSelSize > 0) {
        setErrorMessage("selSzCdNonAvReasonHA", Messages.MSG_EXH_UNLINK_REQ_CLOSED);
        isValid = false;
      }
    }
    if (selSzCdResaonClosed != null && selSzCdResaonClosed.length() > 0) {
      // mxpatel added this code to display message to unlink all children before closing the home per defect
      // #STGAP00013292
      int nonSelSize = ContextHelper.getIntSafe(request, ExchangeHomeDetailConversation.LINK_COUNT);
      if (nonSelSize > 0) {
        setErrorMessage("selSzCdResaonClosed", Messages.MSG_EXH_UNLINK_REQ_CLOSED);
        isValid = false;
      }
    }
    
    return isValid;
  }
}
