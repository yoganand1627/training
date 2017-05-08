package gov.georgia.dhr.dfcs.sacwis.web.fce;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

/**
 * This class is used to perform the custom validation on the Legacy Application Information
 *
 * @author Rodrigo DeJuana, March 20, 2003
 */
public class LegacyApplicationCustomValidation
        extends FormValidation {
  public LegacyApplicationCustomValidation() {
    super();
  }

  protected boolean validateForm() {
    HttpServletRequest request = super.getRequest();

    LegacyApplicationDB legacyApplicationDB =
            readFromRequest(request);

    boolean anyChecked =
            ((legacyApplicationDB.getIndChildUnder18Object() != null) ||
             (legacyApplicationDB.getIndChildQualifiedCitizenObject() != null) ||
             (legacyApplicationDB.getIndParentalDeprivationObject() != null) ||
             (legacyApplicationDB.getIndChildLivingPrnt6MnthsObject() != null) ||
             (legacyApplicationDB.getIndHomeIncomeAfdcElgbltyObject() != null) ||
             (legacyApplicationDB.getIndEquityObject() != null) ||
             (legacyApplicationDB.getIndEligibilityCourtMonthObject() != null) ||
             (legacyApplicationDB.getIndRemovalChildOrderedObject() != null) ||
             (legacyApplicationDB.getIndRsnblEffortPrvtRemovalObject() != null) ||
             (legacyApplicationDB.getIndPrsManagingCvsObject() != null));

    boolean bSave = super.isButtonPressed("btnSave");

    if ((anyChecked == false) &&
        (bSave == true)) {
      setErrorMessage(Messages.MSG_FC_RSN_NT_ELIG_REQ);
      return false;
    }
    return true;
  }

  public static final String TRACE_TAG = "LegacyApplicationCustomValidation";

  public static LegacyApplicationDB readFromRequest(HttpServletRequest request) {
    LegacyApplicationDB legacyApplicationDB = new LegacyApplicationDB();
    LegacyApplicationConversation.populateWithRequest(legacyApplicationDB, request);
    return legacyApplicationDB;
  }
}
