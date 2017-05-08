package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

import javax.servlet.http.HttpServletRequest;

public class CollegeEntranceExamCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "CollegeEntranceExamCustomValidation";

  /**
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException
   * 
   */
  protected boolean validateForm() throws RuntimeWrappedException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();
    boolean isValid = true;
    HttpServletRequest request = super.getRequest();
    String actEnglsh = request.getParameter(CollegeEntranceExamDetailConversation.NBR_ACT_ENGLISH);
    String actMath = request.getParameter(CollegeEntranceExamDetailConversation.NBR_ACT_MATH);
    String actReading = request.getParameter(CollegeEntranceExamDetailConversation.NBR_ACT_READING);
    String actScience = request.getParameter(CollegeEntranceExamDetailConversation.NBR_ACT_SCIENCE);
    String actWriting = request.getParameter(CollegeEntranceExamDetailConversation.NBR_ACT_WRITING);
    String actTotal = request.getParameter(CollegeEntranceExamDetailConversation.NBR_ACT_TOTAL);
    String dtAct = request.getParameter(CollegeEntranceExamDetailConversation.DT_ACT_TAKEN);
    String dtSat = request.getParameter(CollegeEntranceExamDetailConversation.DT_SAT_TAKEN);
    String satMath = request.getParameter(CollegeEntranceExamDetailConversation.NBR_SAT_MATH);
    String satVerbal = request.getParameter(CollegeEntranceExamDetailConversation.NBR_SAT_VERBAL);
    String satWriting = request.getParameter(CollegeEntranceExamDetailConversation.NBR_SAT_WRITING);
    String satTotal = request.getParameter(CollegeEntranceExamDetailConversation.NBR_SAT_TOTAL);
       
    try {
      if (super.isButtonPressed(CollegeEntranceExamDetailConversation.SAVE_ON_COLLEGE_ENTRANCE_EXAM)) {
        if ((!"".equals(dtAct) || !"".equals(actEnglsh) || !"".equals(actMath) || !"".equals(actReading) || !"".equals(actScience)
             || !"".equals(actWriting) || !"".equals(actTotal))
                        && (!"".equals(dtSat) || !"".equals(satMath) || !"".equals(satVerbal) || !"".equals(satWriting) || !"".equals(satTotal))){
          isValid = false;
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_ONE_TEST));  
        }else if (("".equals(dtAct)) && (!"".equals(actEnglsh) || !"".equals(actMath) || !"".equals(actReading) || !"".equals(actScience)
                        || !"".equals(actWriting) || !"".equals(actTotal))){
          isValid = false;
          setErrorMessage(CollegeEntranceExamDetailConversation.DT_ACT_TAKEN, Messages.MSG_TEST_DATE);
        } else if (("".equals(dtSat)) && (!"".equals(satMath) || !"".equals(satVerbal) || !"".equals(satWriting) || !"".equals(satTotal))){
          isValid = false;
          setErrorMessage(CollegeEntranceExamDetailConversation.DT_SAT_TAKEN,Messages.MSG_TEST_DATE);
        } else if ("".equals(dtAct) && "".equals(actEnglsh) && "".equals(actMath) && "".equals(actReading) && "".equals(actScience)
                        && "".equals(actWriting) && "".equals(actTotal) && "".equals(dtSat) && "".equals(satMath) && "".equals(satVerbal) 
                        && "".equals(satWriting) && "".equals(satTotal)){
          isValid = false;
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_TEST_DATE));
        }
      }
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }

    performanceTrace.exitScope();
    return isValid;
  }  
}