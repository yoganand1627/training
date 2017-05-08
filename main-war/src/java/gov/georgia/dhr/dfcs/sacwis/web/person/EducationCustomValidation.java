package gov.georgia.dhr.dfcs.sacwis.web.person;

// -- architecture classes --

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Income Resource Custom validation class
 * <p>
 * Description: This class verifies all of the information in the Education Detail Page
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Anna Grimshaw
 * @version 1.0 
 * 
 * <p/> 
 * <pre>
 *  Change History: 
 * 
 *  Date     User          Description 
 *  -------- -----------   ---------------------------------------------- 
 *  10/14/03 CORLEYAN      SIR 19857 -- ContextHelper.get... replaces getInputValue(), 
 *                         removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *                         
 *  09/12/08 alwilliams    STGAP00007157 - Updated method validateForm. 
 *                         Added a new error message to indicates that School/Day Care Name is 
 *                         required when Education Type is Day Care, Head Start or School. 
 * 
 * </pre>                       
 *                        
 */
public class EducationCustomValidation extends FormValidation {

  /**
   * Override the validateForm() method for the FormValidation class to do custom validation on the frmEduDetail form
   * before calling the save command
   * 
   * @return boolean - true if form is valid and false if it is not
   */
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    org.exolab.castor.types.Date enrollDate = ContextHelper.getCastorDateSafe(request, "txtDtDtEdhistEnrollDate");
    org.exolab.castor.types.Date withdrawnDate = ContextHelper.getCastorDateSafe(request, "txtDtDtEdhistWithdrawnDate");
    String withdrawnGrade = ContextHelper.getStringSafe(request, "selSzCdEdhistWithdrawnGrade");
    String isResource = ContextHelper.getStringSafe(request, "hdnIsResource");
    String inState = ContextHelper.getStringSafe(request, "rbCIndEdhistTeaSchool");
    String hasEdNeeds = ContextHelper.getStringSafe(request, "rbSpecialEdNeeds");
    String hasEdServices = ContextHelper.getStringSafe(request, "rbSpecialEdSvc");
    String hasEdCmmnts = ContextHelper.getStringSafe(request, "szTxtSpecialEdCmnts");
    String hasInterventionNeeds = ContextHelper.getStringSafe(request, "rbChildServices");
    String hasPrevInterventionNeeds = ContextHelper.getStringSafe(request, "rbPrevChildSvc");
    String hasInterventionCmmnts = ContextHelper.getStringSafe(request, "szTxtChildSvcComments");
    
    // STGAP00005624 - if In State selected and no-resource-performed error has been caught, do not validate 
    // School/Day care name since it is not neccessary and to avoid using another hdn field to reference school
    // name's value (the field is disabled so txtSzNmEdhistSchool = "", causing th error msg not display the field name)
    boolean resSearchErr = false;
    
    // Withdrawn must be greater than Enrolled
    if (enrollDate != null && withdrawnDate != null && DateHelper.isBefore(withdrawnDate, enrollDate)) {
      setErrorMessage(Messages.SSM_CFC_ENROLL_DATE);
      result = false;
    }
    // Enrolled date cannot be after today's date
    if (enrollDate != null && DateHelper.isAfterToday(enrollDate)) {
      setErrorMessage("txtDtDtEdhistEnrollDate", Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
    }
    // Withdrawn date cannot be after today's date
    if (withdrawnDate != null && DateHelper.isAfterToday(withdrawnDate)) {
      setErrorMessage("txtDtDtEdhistWithdrawnDate", Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
    }
    // If Withdrawn Date has been entered, withdrawn grade must be entered
    if (withdrawnDate != null && "".equals(withdrawnGrade)) {
      setErrorMessage(Messages.MSG_WITH_NO_GRADE);
      result = false;
    }
    // If Withdrawn Grade has been entered, withdrawn date must be entered
    if (withdrawnDate == null && !"".equals(withdrawnGrade)) {
      setErrorMessage(Messages.MSG_WITH_NO_DATE);
      result = false;
    }
    // If InState has been selected, a resource search must be performed
    if ("I".equals(inState) && "false".equals(isResource)) {
      setErrorMessage(Messages.MSG_RES_SRCH_REQ);
      result = false;
      resSearchErr = true;
    }
    // STGAP00004330
    String txtSzNmEdhistSchool = ContextHelper.getStringSafe(request, "txtSzNmEdhistSchool");
    String szCdEdhistType = ContextHelper.getStringSafe(request, "szCdEdhistType");
    // STGAP00005624 - added resSearchErr condition, see explanation where variable is defined
    // STGAP00007157 - Added a new message, MSG_ED_HIST_SCHOOL_NAME_REQUIRED
    if (!resSearchErr && !CodesTables.CEDTYPE_NIS.equals(szCdEdhistType) && !CodesTables.CEDTYPE_HMS.equals(szCdEdhistType) && !StringHelper.isValid(txtSzNmEdhistSchool)) {
      setErrorMessage("txtSzNmEdhistSchool", Messages.MSG_ED_HIST_SCHOOL_NAME_REQUIRED);
      result = false;
    }
    // end STGAP00004330
    

    // Validation: child needs or has received special educational services without providing required explanation

  /* if (("Y".equals(hasEdNeeds) || "Y".equals(hasEdServices)) && ("".equals(hasEdCmmnts))) {
     setErrorMessage(Messages.MSG_SPEC_EDU_EXPL_REQ);
    result = false;

    }*/
    // Validation: Child is receiving or has received early intervention services without providing the required
    // explanation
   /* if (("Y".equals(hasInterventionNeeds) || "Y".equals(hasPrevInterventionNeeds))
        && ("".equals(hasInterventionCmmnts))) {
      setErrorMessage(Messages.MSG_EARLY_INV_SERV_EXPL_REQ);
      result = false;

    }*/

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }

  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "EducationCustomValidation";
  
}