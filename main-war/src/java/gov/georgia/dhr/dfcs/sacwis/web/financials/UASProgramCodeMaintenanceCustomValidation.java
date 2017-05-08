/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.web.financials;

import java.util.ArrayList;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hong-van.t.vo
 *
 */
@SuppressWarnings("serial")
public class UASProgramCodeMaintenanceCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "UASProgramCodeMaintenanceCustomValidation";
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    boolean isValid = true;
    int nbrDisplayEntCodeRows;

    String cdProgramType = ContextHelper.getStringSafe(request, "selSzCdProgType");
    String indServAuth = ContextHelper.getStringSafe(request, "rbServAuth");
    String indCCI = ContextHelper.getStringSafe(request, "rbCCI");
    String indPSSF = ContextHelper.getStringSafe(request, "rbPSSF");
    String indInvAddOn = ContextHelper.getStringSafe(request, "rbInvAddOn");
    String indCPA = ContextHelper.getStringSafe(request, "rbCPA");
    ArrayList limitExceededTest = new ArrayList();

    
    // Service Authorization and PSSF fields are required for Delivered Services service types.
    if (CodesTables.CINVSRTP_DUR.equals(cdProgramType)) {
      if (StringHelper.EMPTY_STRING.equals(indServAuth) || StringHelper.EMPTY_STRING.equals(indPSSF)) {
        setErrorMessage(Messages.MSG_REQ_SRV_AUTH_PSSF);
        isValid = false; 
      }
    }

    // Invoice Add-On field is required when the service type is Delivered Service or Adoptions.
    if (CodesTables.CINVSRTP_DUR.equals(cdProgramType) || CodesTables.CINVSRTP_ADS.equals(cdProgramType)) {
      if (StringHelper.EMPTY_STRING.equals(indInvAddOn)) {
        setErrorMessage(Messages.MSG_REQ_INV_ADD);
        isValid = false; 
      }
    }

    // Invoice Add-On field is required to be a value of Yes when the service type is Foster Care or Relative Care.
    if (CodesTables.CINVSRTP_FSC.equals(cdProgramType) || CodesTables.CINVSRTP_RCS.equals(cdProgramType)) {
      if (!ArchitectureConstants.Y.equals(indInvAddOn)) {
        setErrorMessage(Messages.MSG_REQ_INV_ADD_YES);
        isValid = false; 
      }
    }

    // Service Authorization field is required to be a value of No when the service type is Relative Care.
    if (CodesTables.CINVSRTP_RCS.equals(cdProgramType)) {
      if (!ArchitectureConstants.N.equals(indServAuth)) {
        setErrorMessage(Messages.MSG_RCS_SVC_AUTH_NO);
        isValid = false; 
      }
    }

    // You have indicated the code as PSSF but did not indicate the code as available as a Service Authorization.
    if (ArchitectureConstants.Y.equals(indPSSF)) {
      if (!ArchitectureConstants.Y.equals(indServAuth)) {
        setErrorMessage(Messages.MSG_PSSF_AND_SVC_AUTH);
        isValid = false; 
      }
    }

    // Relative Care, Delivered Service and Adoption types must not be categorized as CCI or CPA.
    if (CodesTables.CINVSRTP_RCS.equals(cdProgramType) || CodesTables.CINVSRTP_DUR.equals(cdProgramType) 
                    || CodesTables.CINVSRTP_ADS.equals(cdProgramType)) {
      if (ArchitectureConstants.Y.equals(indCCI) || ArchitectureConstants.Y.equals(indCPA)) {
        setErrorMessage(Messages.MSG_NO_CCI_CPA);
        isValid = false; 
      }
    }

    // The code can only be indicated as PSSF if the type is also Delivered Service.
    if (ArchitectureConstants.Y.equals(indPSSF)) {
      if (!CodesTables.CINVSRTP_DUR.equals(cdProgramType)) {
        setErrorMessage(Messages.MSG_DEL_SVC_MUST_PSSF);
        isValid = false; 
      }
    }

    if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "hdnAddProgramCodeMode")) ||
        StringHelper.isTrue(ContextHelper.getStringSafe(request, "hdnAddEntitlementCodeMode")))
      nbrDisplayEntCodeRows = 10;
    else
      nbrDisplayEntCodeRows = ContextHelper.getIntSafe(request, "hdnNbrDisplayEntCodeRows");

    for (int i=0; i<nbrDisplayEntCodeRows; i++) {
      // CheckboxHelper.getCheckboxValue() returns either a Y or N, not ""
      String cbxIndHeader = (CheckboxHelper.getCheckboxValue(request, "cbxIndEntHeader"+i) == ArchitectureConstants.Y) 
                             ? ArchitectureConstants.Y : StringHelper.EMPTY_STRING;
      String cdEntCode = ContextHelper.getStringSafe(request, "txtSzEntCode"+i);
      String txtEntAlpha = ContextHelper.getStringSafe(request, "txtSzTxtEntAlpha"+i);
      String txtEntDesc = ContextHelper.getStringSafe(request, "txtSzTxtEntDesc"+i);
      String dtEntEff = ContextHelper.getStringSafe(request, "txtDtDtEntEff"+i);
      String amtEntRate = ContextHelper.getStringSafe(request, "txtAmtEntRate"+i);
      String cdEntPymtType = ContextHelper.getStringSafe(request, "selSzCdEntPymtType"+i);
      String cdEntUnitType = ContextHelper.getStringSafe(request, "selSzCdEntUnitType"+i);
      String cbxIndEntMileage = (CheckboxHelper.getCheckboxValue(request, "cbxIndEntMileage"+i) == ArchitectureConstants.Y) 
                              ? ArchitectureConstants.Y : StringHelper.EMPTY_STRING;  
      String amtEntCBL = ContextHelper.getStringSafe(request, "txtDAmtEntCBL"+i);
      String amtEntLIL = ContextHelper.getStringSafe(request, "txtDAmtEntLIL"+i);

      String entRowInfo = cbxIndHeader + cdEntCode +txtEntAlpha + txtEntDesc +dtEntEff + amtEntRate + cdEntPymtType + cdEntUnitType 
                           + cbxIndEntMileage + amtEntCBL + amtEntLIL;
      String unitPayInfo = amtEntRate + cdEntPymtType + cdEntUnitType;
      boolean validEntRow = !StringHelper.EMPTY_STRING.equals(cdEntCode) 
                            && !StringHelper.EMPTY_STRING.equals(txtEntDesc) 
                            && !StringHelper.EMPTY_STRING.equals(dtEntEff);
                            
      // Entitlement Code, Description, or Effective Date values are required for one or more records and have not been entered.
      if (!StringHelper.EMPTY_STRING.equals(entRowInfo)) {
        if (StringHelper.EMPTY_STRING.equals(cdEntCode) 
                        || StringHelper.EMPTY_STRING.equals(txtEntDesc) 
                        || StringHelper.EMPTY_STRING.equals(dtEntEff)) {
          setErrorMessage(Messages.MSG_REQ_ENT_CD_INFO);
          isValid = false;
        }
      }

      // When the service is CCI or CPA the Unit Rate, Payment Type, or Unit Type is required 
      // and has not been entered for one or more records.
      if ((ArchitectureConstants.Y.equals(indCCI) || ArchitectureConstants.Y.equals(indCPA)) && validEntRow){
        if (StringHelper.EMPTY_STRING.equals(unitPayInfo)) {
          setErrorMessage(Messages.MSG_REQ_UNIT_PAY_INFO);
          isValid = false;
        }
      }
      
      // Entitlement code cannot be “01” or “02”. 
      if ("01".equals(cdEntCode) || "02".equals(cdEntCode)) {
        setErrorMessage(Messages.MSG_ERR_ENT_CODE);
        isValid = false;
      }
      
      // Entitlement Code cannot be “99” when the service type is Foster Care, Relative Care or Adoption 
      // and it is not indicated that the Program Code is an Invoice Add On.
      if ((CodesTables.CINVSRTP_FSC.equals(cdProgramType) 
                      || CodesTables.CINVSRTP_RCS.equals(cdProgramType) 
                      || CodesTables.CINVSRTP_ADS.equals(cdProgramType))
                      && !ArchitectureConstants.Y.equals(indInvAddOn)){
        if ("99".equals(cdEntCode)) {
          setErrorMessage(Messages.MSG_ERR_ENT_CD_99);
          isValid = false; 
        }
      }
      
      // You have entered an invalid dollar amount.
      if (validEntRow && !StringHelper.EMPTY_STRING.equals(amtEntRate)) {
        if (ContextHelper.getMoneyAsDoubleSafe(request, "txtAmtEntRate"+i) <= 0.00) {
          setErrorMessage(Messages.MSG_INV_DOLL_VALUE);
          isValid = false;
        }
      }
      
    }

    performanceTrace.exitScope();
    return isValid;
  }

}
