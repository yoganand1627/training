package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * The FormValidation class contains all information pertaining to a single form and contains methods necessary for the
 * validation of that form. The FormValidation contains an InputValidation object for each form input.
 *
 * @author Kelly J. Mayes
 */
public class FormValidation implements BaseValidation, Serializable {
  /** //Static constant */
  private static final String TRACE_TAG = "FormValidation";
  /** int errorCount */
  private static int errorCount = 0;

  /** Instance variables */
  private Map<String, InputValidation> inputs = new HashMap<String, InputValidation>();
  /** Map errors */
  private Map<String, String> errors = new HashMap<String, String>();
  /** boolean valid */
  private boolean valid = false;
  /** String name */
  private String name = "";
  /** int unNamedInputErrorCount */
  private int unNamedInputErrorCount = 0;
  /** GrndsExchangeContext _context */
  private GrndsExchangeContext context = null;

  private transient WebApplicationContext webApplicationContext = null;

  @SuppressWarnings({"unchecked"})
  protected <T extends Object> T getEjb(Class<T> aClass) {
    if (this.webApplicationContext == null) {
      this.webApplicationContext =
              WebApplicationContextUtils.getWebApplicationContext(this.context.getServletContext());
    }
    String simpleName = aClass.getSimpleName();
    String beanName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    return (T) webApplicationContext.getBean(beanName);
  }

  /**
   * Sets the input name
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
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
   * Determines if the form is valid
   *
   * @return true if the form is valid
   */
  public boolean isValid() {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".isValid");
    GrndsTrace.exitScope(this.valid);
    return this.valid;
  }

  /** Resets the form to the initial state. */
  public void invalidate() {
    this.valid = false;
  }

  /**
   * The validate method performs validation on each of the form inputs and also calls the validateForm method to
   * perform sub-class specific validation. Each InputValidation conatined in the form validates itself using the form's
   * Validator object.
   *
   * @param validator the list of constraints
   */
  public final void validate(Validator validator) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".validate");
    this.errors.clear();

    this.valid = this.validateElements(validator) && this.validateForm();

    GrndsTrace.exitScope();
  }

  /**
   * This method adds an input element to the form.
   *
   * @param input an InputValidation that contains the input name and constraint (but not the value)
   */
  public void addInput(InputValidation input) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".addInput");
    this.inputs.put(input.getName(), input);
    GrndsTrace.exitScope();
  }

  /**
   * This method sets the values of all form inputs.
   *
   * @param parameterNames A set of parameter names that are used for input validation. If a name is specified in the
   *                       parametermap that does not come from a validation tag, it will be ignored.
   * @param request        the current request object
   */
  public void setInputValues(Set parameterNames, HttpServletRequest request) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".setInputValues");

    for (Iterator elements = parameterNames.iterator(); elements.hasNext();) {
      String name = (String) elements.next();
      String value = request.getParameter(name);
      InputValidation element = inputs.get(name);

      // 6/24 MKW: This block makes no sense
      //if( element == null )
      //{
      //  //if no input element is defined, create a new one that is always valid
      //  element = new InputValidation( name, null, false );
      //  //BEE - 11/19/02 Set all inputs into hashmap
      //  //BEE - 12/5/02 Don't put all inputs in map.  Use Request to get inputMap.
      //  //addInput(element);
      //}

      if (element != null) {
        GrndsTrace.msg(FormValidation.TRACE_TAG, 7, "Adding " + name + " = " + value + " to form inputs");
        element.setValue(value);
      }
    }

    GrndsTrace.exitScope();
  }

  /**
   * This method returns the current value for any input of the form. Subclasses can use this method to obtain the value
   * of a named form input for custom validation.
   *
   * @param inputName the name of the form input element
   * @return String the value of the form input element
   */
  public String getInputValue(String inputName) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getInputValue");
    String result = null;
    InputValidation input = this.inputs.get(inputName);

    if (input != null) {
      result = input.getValue();
    }

    GrndsTrace.exitScope();
    return result;
  }

  /**
   * Returns true if the given button name is in the request, thus indicating that the button was pressed; false
   * otherwise. This method is the equivalent of the code <br> StringHelper.isValid(getInputValue(buttonName + ".x"));
   *
   * @param buttonName the name of the button you want to know if it is pressed; typically of the form "btnAdd",
   *                   "btnDelete", etc.
   * @return true if the button named by the buttonName parameter was the button pressed (that is, it is in the
   *         request), false otherwise.
   */
  public boolean isButtonPressed(String buttonName) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getInputValue");
    boolean result;
    //07/18/2003, Matthew McClain
    //changed this to look directly at the request because getInputValue()
    // does wierd things with preserving previous values
    //This was broken with  ContactSearchList (New Using followed by Search)
    HttpServletRequest request = getRequest();
    result = StringHelper.isValid(request.getParameter(buttonName + ".x"));
    GrndsTrace.exitScope();
    return result;
  }

  /**
   * This method returns the current value for any input of the form. Subclasses can use this method to obtain the value
   * of a named form input for custom validation.
   *
   * @param inputName the name of the form input element
   * @return List the values of the form input element (for multiple-selects and checkbox arrays)
   */
  public List<? extends Object> getInputValues(String inputName) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getInputValue");
    List<? extends Object> result = null;
    InputValidation input = this.inputs.get(inputName);
    if (input != null) {
      result = input.getValues();
    }
    GrndsTrace.exitScope();
    return result;
  }

  /**
   * This method returns the constraints for all inputs of the form.
   *
   * @return Propeties the name-constraint pairs of the form input elements
   */
  public Map<String, String> getInputConstraints() {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getInputsConstraints");
    Map<String, String> result = new HashMap<String, String>();
    for (Iterator<InputValidation> iterator = this.inputs.values().iterator(); iterator.hasNext();) {
      InputValidation input = iterator.next();
      String name = input.getName();
      String constraint = input.getConstraint();
      result.put(name, constraint);
    }
    GrndsTrace.exitScope();
    return result;
  }

  /**
   * This method returns the inputs for the form
   *
   * @return inputs - inputs for the form
   */
  public Map<? extends Object, ? extends Object> getInputMap() {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getInputMap");
    //BEE 12/5/02 Changed to pull parameter map from request because InputMap
    //  has old values for checkboxes if checked before, but not checked now.
    Map<? extends Object, ? extends Object> result = this.getRequest().getParameterMap();
    GrndsTrace.exitScope( /*result*/);
    return result;
  }

  /**
   * This method returns the inputs for the form
   *
   * @return inputs - inputs for the form
   */
  public Map<? extends String, ? extends InputValidation> getInstanceInputMap() {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getInstanceInputMap");
    Map<? extends String, ? extends InputValidation> result = this.inputs;
    GrndsTrace.exitScope( /*result*/);
    return result;
  }

  /**
   * This method returns all error messages generated by the form.
   *
   * @return Properties where the key is the name of the form input that was invalid and the value is the error message
   *         to be displayed to the user.
   */
  public Map<? extends String, ? extends String> getErrorMessages() {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".getErrorMessages");
    GrndsTrace.exitScope();
    return this.errors;
  }

  /**
   * Subclasses should use this method to add an error message to display to the user describing why the form is not
   * valid.
   *
   * @param inputName     the form input field that will be highlighted when the user clicks on the error message.
   * @param messageNumber the error message that will be displayed to the user.
   */
  protected void setErrorMessage(String inputName, int messageNumber) {
    setErrorMessage(inputName, MessageLookup.getMessageByNumber(messageNumber));
  }

  /**
   * Subclasses should use this method to add an error message to display to the user describing why the form is not
   * valid.
   *
   * @param inputName the form input field that will be highlighted when the user clicks on the error message.
   * @param message   the error message that will be displayed to the user.
   */
  protected void setErrorMessage(String inputName, String message) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".setErrorMessage");
    inputName = getErrorCount() + "_" + inputName;
    this.errors.put(inputName, message);
    GrndsTrace.exitScope();
  }

  /**
   * Subclasses should use this method to add an error message to display to the user describing why the form is not
   * valid.
   *
   * @param messageNumber the error message that will be displayed to the user.
   */
  protected void setErrorMessage(int messageNumber) {
    setErrorMessage(MessageLookup.getMessageByNumber(messageNumber));
  }

  /**
   * Subclasses should use this method to add an error message to display to the user describing why the form is not
   * valid.
   *
   * @param message the error message that will be displayed to the user.
   */
  protected void setErrorMessage(String message) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".setErrorMessage");
    unNamedInputErrorCount++;
    this.errors.put(InputValidation.UNSPECIFIED_INPUT_FIELD + unNamedInputErrorCount, message);
    GrndsTrace.exitScope();
  }

  /**
   * getErrorCount
   *
   * @return the returned int
   */
  private static int getErrorCount() {
    errorCount++;
    return errorCount % 10000;
  }

  /**
   * Subclasses should override this method to perform custom form validation.
   *
   * @return true if the form is valid
   */
  protected boolean validateForm() {
    return true;
  }

  /**
   * This method validates each input in the form according to the form's Validator. The form will keep track of any
   * error mesasages generated by each input.
   *
   * @param validator the set of constraints
   * @return true if all elements are valid, false otherwise.
   */
  boolean validateElements(Validator validator) {
    GrndsTrace.enterScope(FormValidation.TRACE_TAG + ".validateElements");
    boolean allElementsValid = true;

    Iterator<InputValidation> formElements = this.inputs.values().iterator();

    while (formElements.hasNext()) {
      InputValidation currentElement = formElements.next();
      currentElement.validate(validator, this.getRequest());

      if (!currentElement.isValid()) {
        if (currentElement instanceof RestrictRepostButtonValidation) {
          // If an add page is reloaded/reposted, all other messages don't matter.
          this.errors.clear();
          String buttonName = currentElement.getName();

          //buttonName returned is actually "<myButtonName>.x", so trim .x
          buttonName = buttonName.substring(0, buttonName.length() - 2);

          //Also, buttons aren't in pageFormName.elements in page DOM, so
          // prepend with "all."
          buttonName = "all." + buttonName;

          this.errors.put(buttonName, currentElement.errorMessage);
          allElementsValid = false;

          // Don't care about other errors in this case, so break.
          break;
        }
        this.errors.put(currentElement.getName(), currentElement.getErrorMessage());
        allElementsValid = false;
      }
    }
    //EILERSBE - SIR 22350 - After validation is complete, Remove all post codes submitted in this request
    RepostCheckUtility.removeSubmittedRepostCodesFromSession(this.getRequest());
    GrndsTrace.exitScope(allElementsValid);
    return allElementsValid;
  }

  /**
   * Sets the context for use by the custom validation class
   *
   * @param context this context
   */
  public void setGrndsExchangeContext(GrndsExchangeContext context) {
    this.context = context;
  }

  /** Removes the context from the custom validation class.  ...Should be called before this class is serialized. */
  public void removeGrndsExchangeContext() {
    //noinspection AssignmentToNull
    this.context = null;
  }

  /**
   * Gets the request object associated with this custom validation class
   *
   * @return request Request associated with this custom validation class
   */
  public HttpServletRequest getRequest() {
    return this.context.getRequest();
  }

  /**
   * Gets the context object associated with this custom validation class
   *
   * @return context <code>GrndsExchangeContext</code> associated with this custom validation class
   */
  public GrndsExchangeContext getGrndsExchangeContext() {
    return this.context;
  }

  /**
   * State for this request
   *
   * @return state State for this request
   */
  public BaseSessionStateManager getState() {
    BaseSessionStateManager state;
    if (getRequest() != null) {
      state = (BaseSessionStateManager) getRequest().getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      if (state == null) {
        state = new HiddenFieldSessionStateManager(getRequest());
      }
    } else {
      state = new HiddenFieldSessionStateManager();
    }

    return state;
  }

  /**
   * Checks to see if error messages were set in the activity method
   *
   * @param request parameter for pageHasErrorMessages
   * @return the returned boolean
   */
  public static boolean pageHasErrorMessages(HttpServletRequest request) {
    Map errorMap = (Map) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
    return errorMap != null;
  }

  /**
   * Checks to see if error messages were set in the validation or custom validation
   *
   * @param formName parameter for pageHasValidationMessages
   * @param request  parameter for pageHasValidationMessages
   * @return the returned boolean
   */
  public static boolean pageHasValidationMessages(String formName, HttpServletRequest request) {
    boolean hasErrors = false;
    FormValidation form = (FormValidation) request.getAttribute(formName);
    if (form != null) {
      Map<? extends String, ? extends String> errorMap = form.getErrorMessages();
      hasErrors = errorMap != null && !errorMap.isEmpty();
    }
    return hasErrors;
  }

  /**
   * Checks to see if popup messages were set in the activity method
   *
   * @param request parameter for pageHasPopupMessages
   * @return the returned boolean
   */
  public static boolean pageHasPopupMessages(HttpServletRequest request) {
    Map errorMap = (Map) request.getAttribute(BasePrsConversation.POPUP_MESSAGES);
    return errorMap != null;
  }

  /**
   * Checks to see if Informational messages were set in the activity method
   *
   * @param request parameter for pageHasInformationalMessages
   * @return the returned boolean
   */
  public static boolean pageHasInformationalMessages(HttpServletRequest request) {
    Map errorMap = (Map) request.getAttribute(BasePrsConversation.INFO_MESSAGES);
    return errorMap != null;
  }
}
