package gov.georgia.dhr.dfcs.sacwis.web.intake;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnConversation;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * Change History:
*  Date      User         Description
*  --------  --------     --------------------------------------------------
* 07/13/04 ochumd         Sir 22934 - Replaced all references to cint19d with cint76d.
* 07/14/08  mxpatel       STGAP00009374: Edited and inserted some code in the method making sure that the user can not insert a duplicate record for allegation.
                            uncommented: String allegType = ContextHelper.getStringSafe(request, "selSzCdIntakeAllegType");
                                         (allegType.equals(row.getSzCdIntakeAllegType()))
                             inserted: (maltreatorRel.equals(row.getSzCdMaltreatorRel()))
                             Edited: (allegMalCode.equals(row.getSzCdIntakeAllegMalCode())) - changed this from (row.getSzCdIntakeAllegType()) to (row.getSzCdIntakeAllegMalCode())

* 09/08/2009  bgehlot     STGAP00015366:Removed the message MSG_MAL_REL_REQUIRED. 
* 05/26/2010  hjbaptiste  SMS#51977-MR66-Maltreatment In Care: Added method checkIfMaltreatmentInCare() to set an indicator to display
*                         a confirmation message
* 06/11/2010  hjbaptiste  SMS#51977-MR66-Maltreatment In Care: Added null check of maltreator relationship for duplicate Allegation check.  
* <pre>
*/

/**
 * <p>This class validates data submitted from the Intake Allegation Detail page.</p>
 * <p/>
 * <p>Error Message Summaries are as follows:</p> <blockquote> <ol> <li>Saving a duplicate allegation</li> <li>Saving
 * more than 30 allegations</li> </ol> </blockquote>
 *
 * @author Jenn M Casdorph 11/25/2002
 */

public class AllegationDetailCustomValidation
        extends FormValidation {
  /** @return result - Returns false if the data fails validation.  Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();

    boolean result = true;

    ROWCINT76DO_ARRAY allegListArray = (ROWCINT76DO_ARRAY) state.getAttribute("allegListArray", request);
    if (allegListArray == null) {
      allegListArray = new ROWCINT76DO_ARRAY();
    }
    ROWCINT76DO row = null;
    int allegVictimId = 0;
    int allegPerpId = 0;
    // ochumd sir 22934 - Split value of victim name gotten from JSP to obtain person name and person id
    String nameVictimAndId = ContextHelper.getStringSafe(request, "selUlIdVictim");
    if (StringHelper.isValid(nameVictimAndId)) {
      String nameallegVict = (nameVictimAndId.substring(0, nameVictimAndId.indexOf("|")));
      String idVictimString = nameVictimAndId.substring(nameVictimAndId.indexOf("|") + 1, nameVictimAndId.length());
      if (idVictimString.length() > 0) {
        allegVictimId = Integer.parseInt(idVictimString);
      }
    }

    // ochumd sir 22934 - Split value of perpetrator name gotten from JSP to obtain person name and person id
    String namePerpetratorAndId = ContextHelper.getStringSafe(request, "selUlIdAllegedPerpetrator");
    String maltreatorRel = ContextHelper.getStringSafe(request, "selSzCdMaltreatorRel");
    if (StringHelper.isValid(namePerpetratorAndId)) {
      String nameperp = (namePerpetratorAndId.substring(0, namePerpetratorAndId.indexOf("|")));
      String idPerpetratorString = namePerpetratorAndId.substring(namePerpetratorAndId.indexOf("|") + 1,
                                                                  namePerpetratorAndId.length());
      if (idPerpetratorString.length() > 0) {
        allegPerpId = Integer.parseInt(idPerpetratorString);
      }
    }
    int allegationId = ContextHelper.getIntSafe(request, "hdnUlIdAllegation");
    String allegType = ContextHelper.getStringSafe(request, "selSzCdIntakeAllegType"); //mxpatel uncommented this
    String allegMalCode = ContextHelper.getStringSafe(request, "selSzCdIntakeAllegMalCode");
  
    ////////////////////////////////////////////////////////////////////////////////
    // Error Message 1:
    //
    //
    //  Condition:  The user is attempting to save a duplicate allegation.
    //
    //  Validation State:  Save
    ////////////////////////////////////////////////////////////////////////////////
    Enumeration allegEnum = allegListArray.enumerateROWCINT76DO();
    

    if ((super.isButtonPressed("btnAdd") || super.isButtonPressed("btnContinue")))

    {
      while (allegEnum.hasMoreElements()) {
        row = (ROWCINT76DO) allegEnum.nextElement();

        if ((allegVictimId == row.getUlIdVictim()) &&
            (allegType.equals(row.getSzCdIntakeAllegType())) && //mxpatel uncommented this
            (maltreatorRel.equals(row.getSzCdMaltreatorRel()) || //mxpatel inserted this
            (!StringHelper.isValid(maltreatorRel) && !StringHelper.isValid(row.getSzCdMaltreatorRel()))) && 
            (allegMalCode.equals(row.getSzCdIntakeAllegMalCode())) && //mxpatel changed this from (row.getSzCdIntakeAllegType()) to (row.getSzCdIntakeAllegMalCode())
            (allegPerpId == row.getUlIdAllegedPerpetrator()) &&
            (allegationId != row.getUlIdAllegation())) {
          setErrorMessage(Messages.MSG_INT_MOD_ALLG);
          result = false;
          break;
        }
      }
    }
    // R1 Bug Fix Defect number STGAP00001065 : Allegation Date entered must not be Greater than current date.
    org.exolab.castor.types.Date doa = ContextHelper.getCastorDateSafe(request, "selDtDtAllegedIncident");

    if (doa != null && DateHelper.isAfterToday(doa)) {
      setErrorMessage("selDtDtAllegedIncident", Messages.MSG_INTK_ALLG_INTK_DT_GT_TODAY);
      result = false;
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Error Message 2:
    //
    //
    //  Condition:  The user is attempting to save when 30 rows already exist
    //
    //  Validation State:  Save
    ////////////////////////////////////////////////////////////////////////////////
    if (super.isButtonPressed("btnAdd") || super.isButtonPressed("btnContinue")) {
      if (allegListArray.getROWCINT76DOCount() >= 30) {
        setErrorMessage(Messages.MSG_TOO_MANY_LB_ROWS);
        result = false;
      }
    }

    // EXTREMELY IMPORTANT: Always keep this call to checkIfMaltreatmentInCare() last, prior to returning. All other messages need
    // to be set prior to force the return to the jsp to force the user to confirm Maltreatment in Care
    if (result) {
      result = checkIfMaltreatmentInCare(allegVictimId, maltreatorRel, CodesTables.CSTAGES_INT, state);
    }
    
    performanceTrace.exitScope();
    return result;
  }
  
  private boolean checkIfMaltreatmentInCare(int allegVictimId, String cdMaltreatorRel,  String cdStageType, BaseSessionStateManager state) {
    HttpServletRequest request = super.getRequest();
    int idCase = GlobalData.getUlIdCase(request);
    boolean result = true;
    state.removeAttribute("indMaltreatInCare", request);
    if (!ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnUpdateMaltreatInCare"))) {
      state.removeAttribute("warnMaltreatmentInCare", request);
      if (super.isButtonPressed("btnAdd") || super.isButtonPressed("btnContinue")) {
        if (IntakeActionsConversation.checkIfMaltreatmentInCare(allegVictimId, cdStageType, cdMaltreatorRel, idCase,
                                                         DateHelper.toJavaDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "selDtDtAllegedIncident"))),
                                                         getEjb(Common.class))) {
          state.setAttribute("warnMaltreatmentInCare", ArchitectureConstants.Y, request);
          state.setAttribute("indMaltreatInCare", ArchitectureConstants.Y, request);
          result = false;
        } else {
          state.setAttribute("warnMaltreatmentInCare", ArchitectureConstants.N, request);
          state.setAttribute("indMaltreatInCare", ArchitectureConstants.N, request);
        }
      }
    } else {
      if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnIndIncmgMaltreatInCare"))) {
        state.setAttribute("indMaltreatInCare", ArchitectureConstants.Y, request);
      } else {
        state.setAttribute("indMaltreatInCare", ArchitectureConstants.N, request);
      }
    }
    return result;
  }

  public static final String TRACE_TAG = "AllegationDetailCustomValidation";
}
