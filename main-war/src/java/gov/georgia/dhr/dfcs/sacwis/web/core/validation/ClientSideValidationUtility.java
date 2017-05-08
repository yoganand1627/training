package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;

/**
 * This class creates the client-side JavaScript validation functions.  The class contains static methods that will
 * create form specific JavaScript that utilize the the framework JavaScript file to verify that the input values of the
 * form are valid according to the constraints definied in the framework constraints file.
 *
 * @author Kelly J. Mayes
 */
public class ClientSideValidationUtility {
  /**
   * This method is called by the closing FormTag to create the JavaScript to validate the form data.  The method
   * creates the Script tags that will be interpreted by the client browser.
   *
   * @param formName      The name of the form to validate
   * @param formValidator
   * @param validator
   * @return String The JavaScript validation for the input form
   */
  public static String createValidationJavascript(String formName, FormValidation formValidator, Validator validator) {
    GrndsTrace.enterScope(TRACE_TAG + ".createValidationJavascript");
    StringBuffer buffer = new StringBuffer();

    Map inputConstraints = formValidator.getInputConstraints();
    GrndsTrace.msg(TRACE_TAG, 7, "input constraints = " + inputConstraints);

    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<script language=\"JavaScript\">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append(createFormValidationFunction(formName, inputConstraints));
    buffer.append(ArchitectureConstants.LINE_BREAK);

    Set inputSet = inputConstraints.keySet();
    //Loop through the inputs creating individual validation javascript functions
    for (Iterator iterator = inputSet.iterator(); iterator.hasNext();) {
      String inputName = (String) iterator.next();
      String constraintName = (String) inputConstraints.get(inputName);
      GrndsTrace.msg(TRACE_TAG, 7, "input = " + inputName);
      GrndsTrace.msg(TRACE_TAG, 7, "constraint = " + constraintName);

      //Create the individual field validation functions
      if (constraintName != null) {
        Constraint constraint = validator.getConstraint(constraintName);
        //Get error message from the constraint
        String errorMessage = constraint.getDescription();
        //If error message is not defined, set a generic message
        if (!StringHelper.isValid(errorMessage)) {
          errorMessage = "Value " + formValidator.getInputValue(inputName) + " on the form is invalid. " +
                         "Please correct the entry.";
        } else {
          errorMessage = errorMessage.trim();
        }

        buffer.append(createInputValidationFunction(formName, inputName, constraintName, errorMessage));
        buffer.append(ArchitectureConstants.LINE_BREAK);
      }
    } //end for loop

    //Close out javascript section
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("</script>");
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * This method creates the function that will evaluate the entire form. The validation function created by this method
   * will in turn call the methods that validate the individual fields of the form.  This method is called by the
   * createValidationJavascript function.
   *
   * @param formName         The name of the form to be validated
   * @param inputConstraints The input constraints for the form being validated
   * @return String The JavaScript function to validate the complete form
   */
  static String createFormValidationFunction(String formName, Map inputConstraints) {
    GrndsTrace.enterScope(TRACE_TAG + ".createFormValidationFunction");
    StringBuffer buffer = new StringBuffer();
    //function validateFormName()
    //{
    //  var sTotalMsg = "";
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("function validate");
    buffer.append(formName);
    buffer.append("()");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("{");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("  var sTotalMsg = \"\"; ");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("  resetErrors( ");
    buffer.append(formName);
    buffer.append(" );");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    for (Iterator iterator = inputConstraints.keySet().iterator(); iterator.hasNext();) {
      String inputName = (String) iterator.next();
      String constraintName = (String) inputConstraints.get(inputName);
      if (constraintName != null) {
        //                 sTotalMsg = setErrorMsg( sTotalMsg, validatepassword() );
        buffer.append("sTotalMsg = setErrorMsg( sTotalMsg, validate");
        buffer.append(inputName);
        buffer.append("() );");
        buffer.append(ArchitectureConstants.LINE_BREAK);
      }
    }
    //  return ( displayErrors( sTotalMsg, frmTest ) );
    //}
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("return ( displayErrors( sTotalMsg ) );");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("}");
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * This method is called for each of the constraints applicable to the form being validated.  For each constraint this
   * method constructs an javascript function that validates the specificed input.  The functions created by this method
   * will call the methods defined in the WebPageFormValidation js file.
   *
   * @param formName       The name of the form to be validated
   * @param inputName      The name of the specific input to validate
   * @param constraintName The constraint name associated with the input field
   * @return String The JavaScript function to validate the specific input
   */
  static String createInputValidationFunction(String formName, String inputName, String constraintName,
                                              String errorMessage) {
    GrndsTrace.enterScope(TRACE_TAG + ".createInputValidationFunction");
    StringBuffer buffer = new StringBuffer();

    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("function validate").append(inputName).append("()");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("{");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("var value = ").append(formName).append(".").append(inputName).append(".value;");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("var valid = ");
    buffer.append("isValid").append(constraintName).append("( value );");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append(createErrorFocus(formName, inputName, errorMessage));
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("return valid;");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("}");
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * This method is called by the createInputValidationFunction method.  This method creates the logic that will set the
   * browser focus to an invalid input field on the form.
   *
   * @param formName  The name of the form being validated
   * @param inputName The name of the input field being validated
   * @return String The JavaScript to return the browser focus to an invalid input field
   */
  static String createErrorFocus(String formName, String inputName, String errorMessage) {
    GrndsTrace.enterScope(TRACE_TAG + ".createErrorFunction");
    StringBuffer buffer = new StringBuffer();
//    if( !valid )
//          {
//            sMsg = "Value '" + value + "' on the form is invalid. Please correct the entry.";
//            return ( getErrorMsg( sMsg, frmTest, frmTest.InputName ) );
//          }
    buffer.append("if( !valid )");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("{");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("sMsg = \"");
    buffer.append(errorMessage);
    buffer.append("\";");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("return ( getErrorMsg( sMsg, ");
    buffer.append(formName);
    buffer.append(", ");
    buffer.append(formName);
    buffer.append(".");
    buffer.append(inputName);
    buffer.append(" ) );");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("}");
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  public static final String TRACE_TAG = "ClientSideValidationUtility";
}
