package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * CnsrvtrshpRemovalCustomValidation - validation for the Conservatorship Removal Conversation.
 * 
 * @author Bryon Jacob
 * @version 1.0 <p/> Change History: Date User Description -------- -----------
 *          ---------------------------------------------- 10/14/03 dejuanr SIR 19857 -- No changes needed 10/14/03
 *          CORLEYAN SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed
 *          InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *          12/1/2010 htvo         SMS#8114 AFCARS: remove error on caretaker checkbox (the section removed);
 *                                 child characteristics (section display only);
 *                                 exclude Short Term Emergency Care removal type from removal reason validation 
 *          12/27/10 htvo          SMS#87941: Used hidden field to tell whether at least a removal reason is selected 
 *                                 (b/c it can be disabled thus the name is changed)                           
 *          10/08/11 schoi         STGAP00017013: MR-095 Added validation MSG_PRN_REQ_FOR_REM_CHILD_ERR 
 *                                 for Foster Care Principal List for FCC Stage section                      
 */
public class CnsrvtrshpRemovalCustomValidation extends FormValidation {
  /**
   * This method checks for required fields.
   * 
   * @return boolean isValid
   */
  protected boolean validateForm() {
    boolean isValid = true;
    HttpServletRequest request = getRequest();

    // when we are saving...
    if (isButtonPressed("btnSave")) {
      // if the date or either of the "age" fields is empty, show the error message.
      String dtDtRemoval = request.getParameter("dtDtRemoval");
      String labelRemovalAgeYears = request.getParameter("labelRemovalAgeYears");
      String labelRemovalAgeMonths = request.getParameter("labelRemovalAgeMonths");
      if (nullOrEmpty(dtDtRemoval) || nullOrEmpty(labelRemovalAgeYears) || nullOrEmpty(labelRemovalAgeMonths)) {
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED));
        isValid = false;
      }

      String removalType = request.getParameter("rbRemovalType");
      if (removalType == null || "".equals(removalType)) {
        setErrorMessage("Removal Type - This field is required.");
        isValid = false;
      }
      // SMS#81140 MR-074 AFCARS: removed, caretaker removed, child is display only
      // if there are no child chars checked, show the error message
     /* String[] checkedChildChars = CheckboxHelper.getCheckedValues(request, "cbxChildChars");
      if (checkedChildChars.length == 0) {
        setErrorMessage(Messages.MSG_CHILD_CHAR_NA);
        // setErrorMessage( "You must select at least one Child Characteristic or N/A before saving." );
        isValid = false;
      }*/

      // if there are no care taker chars checked, show the error message
      /*String[] checkedCareTakerChars = CheckboxHelper.getCheckedValues(request, "cbxCareTakerChars");
      if (checkedCareTakerChars.length == 0) {
        setErrorMessage(Messages.MSG_CARE_TKR_CHAR_NA_REQ);
        // setErrorMessage( "You must select at least one Care Taker Characteristic or N/A before saving." );
        isValid = false;
      }*/

      // if there are no removal reasons checked, show the error message
      // MR-074 AFCARS: enforce this validation only for removals other than Short Term Emergency Care (ST)
      String sHdnCbxReason = request.getParameter("hdnCbxReason");
      if ((sHdnCbxReason.compareToIgnoreCase("N") == 0) && !CodesTables.CREMT_ST.equals(removalType)) {
        setErrorMessage(Messages.MSG_SEL_RMVL_REASON);
        isValid = false;
      }
      // SIR#19196. if there are no principals displayed in the Persons Living in Home At Removal
      // section, show the error message
      String sHdnCbxPersonsAtHome = request.getParameter("hdnCbxPersonsAtHome");
      if (sHdnCbxPersonsAtHome.compareToIgnoreCase("N") == 0) {
        setErrorMessage(Messages.MSG_PERS_LIVING_HM_REM);
        // setErrorMessage( "You must complete the persons living in the home at removal section." );
        isValid = false;
      }
      String desc = request.getParameter("txtFactualDesc");
      if (desc == null || "".equals(desc)) {
        setErrorMessage("Factual Description of incident precipitating removal - This field is required.");
        isValid = false;
      }

      // STGAP00017013: MR-095
      BaseSessionStateManager state = getState();
      //CSUB14SO csub14so = (CSUB14SO) state.getAttribute("csub14so", request);
      CSUB80SO csub80so = (CSUB80SO) state.getAttribute("csub80so", request);
      if (csub80so != null) {
        ROWCSUB80SOG00_ARRAY rowcsub80SOG00_array = csub80so.getROWCSUB80SOG00_ARRAY();
        int i = 0;
        if (rowcsub80SOG00_array != null) {
          Enumeration e = rowcsub80SOG00_array.enumerateROWCSUB80SOG00();
          while (e.hasMoreElements()) {
            ROWCSUB80SOG00 row = (ROWCSUB80SOG00) e.nextElement();

            String cdStagePersRelInt = "selSzCdStagePersRelInt_" + (i + 1);

            String selSzCdStagePersRelInt = request.getParameter(cdStagePersRelInt);

            if (selSzCdStagePersRelInt == null || "".equals(selSzCdStagePersRelInt)) {
              setErrorMessage(Messages.MSG_PRN_REQ_FOR_REM_CHILD_ERR);
              isValid = false;
              break;
            }
            i++;
          }
        }
      }
      // End STGAP00017013: MR-095
    }

    return isValid;
  }

  /**
   * returns true if the given string is null or the empty string, false otherwise.
   * 
   * @param string
   *          the string to check
   * @return true if the given string is null or the empty string, false otherwise
   */
  private static boolean nullOrEmpty(String string) {
    return string == null || "".equals(string.trim());
  }
}
