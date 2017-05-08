package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * The NonIncidentAFCARSInformationCustomValidation class is used to provide validation for
 * the Non-Incident AFCARS Information page.
 * 
 * 
 * @author Stephen Roberts, October 1, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public class NonIncidentAFCARSInformationCustomValidation extends FormValidation {
  
  
  protected boolean validateForm() {
    boolean isValid = true;
    
    HttpServletRequest request = getRequest();
    
    String indMntlRetard = CheckboxHelper.getCheckboxValue(request, "cbxMntlRetard");
    String indVisHearImp = CheckboxHelper.getCheckboxValue(request, "cbxVislHearImp");
    String indPhyDisabled = CheckboxHelper.getCheckboxValue(request, "cbxPhyDisabled");
    String indEmtDisturbed = CheckboxHelper.getCheckboxValue(request, "cbxEmtDisturbed");
    String indOthMedDiag = CheckboxHelper.getCheckboxValue(request, "cbxOthMedDiag");
    
    String cdMntRetSevLevel = ContextHelper.getStringSafe(request, "szCdMntRetSevLevel");
    String cdSevVisHearImp = ContextHelper.getStringSafe(request, "szCdVisHearSevLevel");
    String cdSevPhyDisabled = ContextHelper.getStringSafe(request, "szCdPhyDisSevLevel");
    String cdSevEmtDisturbed = ContextHelper.getStringSafe(request, "szCdEmtDistSevLevel");
    String cdSevOthMedDiag = ContextHelper.getStringSafe(request, "szCdOthMedDiagSevLevel");
    
    if ((ArchitectureConstants.Y.equals(indMntlRetard) && StringHelper.EMPTY_STRING.equals(cdMntRetSevLevel)) ||
                    (!ArchitectureConstants.Y.equals(indMntlRetard) && !StringHelper.EMPTY_STRING.equals(cdMntRetSevLevel)))
                        isValid = false;

    if ((ArchitectureConstants.Y.equals(indVisHearImp) && StringHelper.EMPTY_STRING.equals(cdSevVisHearImp)) ||
                    (!ArchitectureConstants.Y.equals(indVisHearImp) && !StringHelper.EMPTY_STRING.equals(cdSevVisHearImp)))
                        isValid = false;
                                    
    if ((ArchitectureConstants.Y.equals(indPhyDisabled) && StringHelper.EMPTY_STRING.equals(cdSevPhyDisabled)) ||
                    (!ArchitectureConstants.Y.equals(indPhyDisabled) && !StringHelper.EMPTY_STRING.equals(cdSevPhyDisabled)))
                        isValid = false;

    if ((ArchitectureConstants.Y.equals(indEmtDisturbed) && StringHelper.EMPTY_STRING.equals(cdSevEmtDisturbed)) ||
                    (!ArchitectureConstants.Y.equals(indEmtDisturbed) && !StringHelper.EMPTY_STRING.equals(cdSevEmtDisturbed)))
                        isValid = false;
    
    if ((ArchitectureConstants.Y.equals(indOthMedDiag) && StringHelper.EMPTY_STRING.equals(cdSevOthMedDiag)) ||
                    (!ArchitectureConstants.Y.equals(indOthMedDiag) && !StringHelper.EMPTY_STRING.equals(cdSevOthMedDiag)))
                        isValid = false;
                    
    if (!isValid){
      setErrorMessage(Messages.MSG_NO_SEVERITY);
    }
    return isValid;
  }
}
