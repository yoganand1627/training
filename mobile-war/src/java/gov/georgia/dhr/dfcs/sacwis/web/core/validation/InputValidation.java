package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.ConstraintNotFoundException;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;

/**
 * The InputValidationImpl class contains all information pertaining to a single form input field and contains methods
 * necessary for the validation of that input.
 *
 * @author Kelly J. Mayes
 */
public class InputValidation implements BaseValidation, Serializable {

  /**
   * Constructs a new InputValidationImpl Object.
   *
   * @param name       a String conatinaing the name of this input field
   * @param constraint a String containing the name of the constraint used to validate tis input field.  The constraint
   *                   must be defined in the Validator object used by the IputValidationImpl.
   * @param required   a boolean indication whether this input field is a required field in the form. If the input is
   *                   not 'required' a null value will be considiered valid.
   */
  public InputValidation(String name, String constraint, boolean required) {
    GrndsTrace.enterScope(InputValidation.TRACE_TAG + ".constructor");

    this.name = name;
    this.value = null;
    this.constraint = constraint;
    this.required = required;

    //If no named constraint is defined the input will always be valid,
    //otherwise the initial state is invalid.
    if (constraint != null) {
      this.errorMessage = InputValidation.INITIAL_ERROR_MESSAGE;
    }

    GrndsTrace.exitScope();
  }

  /**
   * Sets the value
   *
   * @param value the value
   */
  public void setValue(Object value) {
    this.value = value;
  }

  /**
   * Gets a String value
   *
   * @return the value
   */
  public String getValue() {
    String returnValue = null;
    if (this.value != null) {
      if (this.value instanceof List) {
        returnValue = (String) ((List) this.value).get(0);
      } else {
        returnValue = this.value.toString();
      }
    }
    return returnValue != null ? returnValue.trim() : "";
  }

  /**
   * Gets a list of values ( for multiple-selects or checkbox arrays )
   *
   * @return the values
   */
  public List getValues() {
    List result;

    if (this.value instanceof List) {
      result = (List) this.value;
    } else {
      result = new ArrayList();
      result.add(this.getValue());
    }

    return result;
  }

  /**
   * Gets the input name
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the constraint name
   *
   * @return the name
   */
  public String getConstraint() {
    return this.constraint;
  }

  /**
   * Checks to see if this input is required
   *
   * @return true if the inputis required
   */
  public boolean isRequired() {
    return this.required;
  }

  /**
   * Gets the error message
   *
   * @return the error message
   */
  public String getErrorMessage() {
    return this.errorMessage;
  }

  /**
   * Determines if the input is valid
   *
   * @return true if the input is valid
   */
  public boolean isValid() {
    //The input is valid if it has no error mesage associates with it.
    return (!StringHelper.isValid(this.errorMessage));
  }

  /** Resets the input message to the initial state. */
  public void invalidate() {
    if (this.constraint != null) {
      this.errorMessage = InputValidation.INITIAL_ERROR_MESSAGE;
    }
  }

  public void validate(Validator validator) {
    //Few places besides FormValidation call .validate, but for those, passthrough
    validate(validator, null);
  }

  /**
   * The validate method uses the named constraint on the Validator object to determine if the value of this input is
   * valid. If the input is not required, a null or empty String value will be considered valid, otherwise a null or
   * empty String i s invalid.  If no named constraint is defined the value is assumed to be valid.
   *
   * @param validator the list of constraints
   * @param request   the request object, ignored unless using RestrictRepostButtonValidation objects
   */
  public void validate(Validator validator, HttpServletRequest request) {
    //request was added here so all validate calls in FormValidation use this
    // method signature.  The RestrictRepostButtonValidation objects will use the request

    GrndsTrace.enterScope(InputValidation.TRACE_TAG + ".validate");
    this.errorMessage = null;
    boolean elementPopulated = false;
    List elementValues = this.getValues();

    if (elementValues.size() > 1) {
      Iterator iterator = elementValues.iterator();
      while (iterator.hasNext()) {
        String input = (String) iterator.next();
        elementPopulated = StringHelper.isValid(input);

        if (!elementPopulated) {
          break;
        }
      }
    } else {
//BEE      elementPopulated = ( StringHelper.isValid( this.getValue() ) );
      if (request != null) {
        elementPopulated = this.isInRequest(request);
      }
      //BEE - might need to add else statement setting elementPopulated base on this.getValue()
      //      not adding it now because it could cause problems on pages where input
      //      is populated and then the value is removed by user and form submitted.
      //      This would cause this.getValue() to falsely indicate that the element is populated.
    }

    //Ignore inputs that are not required and have no value.
    if (this.isRequired() || elementPopulated) {
      // Set an error mesage if the field is required and has not been set.
      if (!elementPopulated) {
        this.errorMessage = InputValidation.REQUIRED_ERROR_MESSAGE;
      }

      //Only auto validate elements that have a named constraint defined.
      else {
        if (this.constraint != null) {
          GrndsTrace.msg(InputValidation.TRACE_TAG, 7, "Auto validating element '" +
                                                       this.name + "' with value '" + this.value +
                                                       "' and constraint '" + this.constraint + "'");
          try {
            validator.isValid(this.constraint, this.getValue());
          }
          catch (DataFormatException dfe) //The data is invalid.
          {
            this.errorMessage = dfe.getMessage();
            GrndsTrace.msg(InputValidation.TRACE_TAG, 7, "element " + this.name +
                                                         " failed validation with error message " +
                                                         this.errorMessage);
          }
          catch (ConstraintNotFoundException cnfe)//The named constraint was not found in the Validator.
          {
            this.errorMessage = "constraint " + this.constraint + " not found in schema";
            GrndsTrace.msg(InputValidation.TRACE_TAG, 7, this.errorMessage);
          }
        }
      }

    }

    GrndsTrace.exitScope();
  }

  /**
   * Returns whether or not the input has a value in the request.
   *
   * @return boolean - whether or not the input has a value in the request.
   */
  public boolean isInRequest(HttpServletRequest request) {
    boolean isInRequest = false;
    if (StringHelper.isValid(request.getParameter(this.getName()))) {
      isInRequest = true;
    }
    return isInRequest;
  }

  //Static constants
  private static final String TRACE_TAG = "InputValidation";
  private static final String INITIAL_ERROR_MESSAGE = "This element has not been validated";
  public static final String REQUIRED_ERROR_MESSAGE = "Field is required.  Please enter a value.";
  public static final String UNSPECIFIED_INPUT_FIELD = "UnspecifiedInputField";

  // Instance variables
  private boolean required;
  private String constraint;
  private String name;
  private Object value;
  protected String errorMessage;

}