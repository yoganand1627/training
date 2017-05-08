package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.RepostCodeMismatchException;

/**
 * This validation verifies that the user did not hit refresh or resubmit the page by clicking back and clicking on a
 * button again.  It uses the RepostCheckUtility for this verification.
 *
 * @author Jonathan Hardy
 */
public class RestrictRepostButtonValidation extends InputValidation {

  /**
   * Constructs a new RestrictRepostButtonValidation Object. This validation verifies that the user did not hit refresh
   * or resubmit the page by clicking back and clicking on a button again.  It uses the RepostCheckUtility for this
   * verification.
   *
   * @param name       a String conatinaing the name of this input field
   * @param constraint a String containing the name of the constraint used to validate this input field.  The constraint
   *                   must be defined in the Validator object used by the IputValidation.
   * @param required   a boolean indication whether this input field is a required field in the form. If the input is
   *                   not 'required' a null value will be considered valid.
   */
  public RestrictRepostButtonValidation(String name,
                                        String constraint,
                                        boolean required) {
    super(name, constraint, required);
  }

  /**
   * Overrides the InputValidation validate method to verify the page was not re-posted
   *
   * @param validator the list of constraints - not used by this implementation.
   * @param request   the request object, ignored unless using RestrictRepostButtonValidation objects
   */
  public void validate(Validator validator, HttpServletRequest request) {
    //Verify that the value is not null or blank
    if (this.getValue() != null && !"".equals(this.getValue())) {
      try {
        //Validate that the request was not a re-post
        RepostCheckUtility.validateRepostSubmit(this.getName().substring(0, this.getName().length() - 2), request);
      }
      catch (RepostCodeMismatchException we) {
        //Set the error message to be displayed by the validation framework
        this.errorMessage = we.getMessage();
        //Set an attribute so that the buttons with RestrictRepostValidation will
        //be disabled when the page is redisplayed.  This prevents users from
        //saving something twice.
        request.setAttribute(restrictRepostDisableButtons, Boolean.TRUE);
        GrndsTrace.msg(this.CHILD_TRACE_TAG, 7, "element " + this.getName() +
                                                " failed validation with error message " +
                                                this.errorMessage);
      }
    }
  }

  private static String CHILD_TRACE_TAG = "RestrictRepostButtonValidation";
  public static String restrictRepostDisableButtons = "restrictRepostDisableButtons";

}