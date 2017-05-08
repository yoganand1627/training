package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation; 

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * Used to perform the custom validation for PPT Information procedures.
 *
 * @author Jason Rios 03/13/2003
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  dejuanr      SIR 19857 -- No changes needed
 */
public class PPTCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "PPTCustomValidation";

  /**
   * <p>This method contains custom validation that is checked when the user searches for on-call schedules.</p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException
   *
   */
  protected boolean validateForm()
          throws RuntimeWrappedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValid = true;

    try {
      // Validation for save on PPT Information page.
      if (super.isButtonPressed(PPTConversation.SAVE_BUTTON_ON_PPT_PAGE)) {
        org.exolab.castor.types.Date meetingDate = ContextHelper.getCastorDateSafe(request, "txtMeetingDate");
        org.exolab.castor.types.Date dtHearingReq = ContextHelper.getCastorDateSafe(request, "txtDateHearingReq");
        org.exolab.castor.types.Date dtOutcomeDiscussed = ContextHelper.getCastorDateSafe(request, "txtOutcomeDiscussed");
        String meetingType = ContextHelper.getString(request, "txtMeetingType");

        if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request,PPTConversation.IND_TRAN_PLAN_COMP))){
          BasePrsConversation.setInformationalMessage("Record information on the transition plan in the narrative.", request);
        }
        //'Meeting Date' must be before or same as 'Date Hearing Requested' date.
        if ("ADM".equals(meetingType) && meetingDate != null && dtHearingReq != null &&
            DateHelper.isAfter(dtHearingReq, meetingDate)){
          isValid = false;
          setErrorMessage("txtDateHearingReq", Messages.MSG_DATE_REQ);
        }
        
        //'Outcome Discussed' has to be after meeting date and date hearing requested.
        if ("ADM".equals(meetingType) && meetingDate != null && dtOutcomeDiscussed != null &&
            (DateHelper.isAfter(meetingDate, dtOutcomeDiscussed) ||
            DateHelper.isAfter(dtHearingReq, dtOutcomeDiscussed))){
          isValid = false;
          setErrorMessage("txtOutcomeDiscussed", Messages.MSG_DATE_OUTCOME_DISCUSSED);
        }
      } // end if (super.isButtonPressed(PPTConversation.SAVE_BUTTON_ON_PPT_PAGE))

      // Validation for save on PPT Participant Detail page.
      if (super.isButtonPressed(PPTConversation.SAVE_BUTTON_ON_PARTICIPANT_PAGE)) {
        CSUB29SO csub29so = (CSUB29SO) state.getAttribute("CSUB29SO", request);
        org.exolab.castor.types.Date notifiedDate = ContextHelper.getCastorDateSafe(request, "txtNotifiedDate");

        // 'Notified Date' must be before or same as 'Meeting Date'.
        if (notifiedDate != null && csub29so != null &&
            csub29so.getCSUB29SOG00().getDtDtPptDate() != null &&
            DateHelper.isAfter(notifiedDate, csub29so.getCSUB29SOG00().getDtDtPptDate())) {
          isValid = false;
          setErrorMessage("txtNotifiedDate", Messages.SSM_SUB_NOTF_BEF_SAME_MEET);
        }

        // Check for duplicate participant records. If the 'Participant Type'
        // is "Person in Case" or "Staff", compare the participant id's and the
        // person id's. Otherwise, compare the three required fields.
        CSUB27SO csub27so = (CSUB27SO) state.getAttribute("CSUB27SO", request);
        String selParticipantType = ContextHelper.getStringSafe(request, "selParticipantType");
        if (selParticipantType.equals(CodesTables.CPARTYPE_PIC) ||
            selParticipantType.equals(CodesTables.CPARTYPE_STA)) {
          int newParticipantId = ContextHelper.getIntSafe(request, "hdnParticipantId");
          int newPersonId = ContextHelper.getIntSafe(request, "hdnPersonId");
          Enumeration enumeration = csub27so.getROWCSUB27SOG00_ARRAY().enumerateROWCSUB27SOG00();
          while (enumeration.hasMoreElements()) {
            ROWCSUB27SOG00 existingParticipant = (ROWCSUB27SOG00) enumeration.nextElement();
            // If the person id from the PPT Participant Detail page is the same
            // as an existing participant's person id, the two participant id's
            // also must be the same. If they are different, this is a duplicate
            // record.
            if (newPersonId == existingParticipant.getUlIdPerson() &&
                newParticipantId != existingParticipant.getUlIdPptPart()) {
              isValid = false;
              setErrorMessage(Messages.MSG_DUPLICATE_RECORD);
              break;
            }
          }
        } else if (selParticipantType.equals(CodesTables.CPARTYPE_OTH)) {
          String txtParticipantName = ContextHelper.getStringSafe(request, "txtParticipantName");
          String txtRelationshipInterest = ContextHelper.getStringSafe(request, "txtRelationshipInterest");
          // JMC - SIR 18627 - When the user attempted to modify the participant information
          // for Participant Type == Other they would recieve the "Duplicate Records Exist" error.
          // We added a check to make sure the user was not attempting to update an existing
          // record.
          int hdnParticipantId = ContextHelper.getIntSafe(request, "hdnParticipantId");
          Enumeration enumeration = csub27so.getROWCSUB27SOG00_ARRAY().enumerateROWCSUB27SOG00();
          while (enumeration.hasMoreElements()) {
            ROWCSUB27SOG00 participant = (ROWCSUB27SOG00) enumeration.nextElement();
            if (participant.getSzCdPptPartType().equalsIgnoreCase(CodesTables.CPARTYPE_OTH) &&
                participant.getSzNmPptPartFull().equalsIgnoreCase(txtParticipantName) &&
                participant.getSzSdsPptPartRelationship().equalsIgnoreCase(txtRelationshipInterest) &&
                participant.getUlIdPptPart() != hdnParticipantId) {
              isValid = false;
              setErrorMessage(Messages.MSG_DUPLICATE_RECORD);
              break;
            }
          }
        } // end else if (selParticipantType.equals(CodesTables.CPARTYPE_OTH))
      } // end if (super.isButtonPressed(PPTConversation.SAVE_BUTTON_ON_PPT_PAGE))
    }
    catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }

    performanceTrace.exitScope();
    return isValid;
  }
}
