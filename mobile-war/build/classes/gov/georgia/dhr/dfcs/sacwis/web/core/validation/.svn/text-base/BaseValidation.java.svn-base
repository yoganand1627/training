package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

/**
 * The BaseValidation interface must be implemented by all Objects that are able to perform self-validation.
 *
 * @author Kelly J. Mayes
 */
public interface BaseValidation {
  /**
   * Method used by external objects to determine if the implementing class is currently valid.  The method should
   * return 'false' unless the 'validate' method has already been called.
   */
  public boolean isValid();

  /** Method used to perform validation logic on the implementing class. */
  public void validate(Validator validator);

  /** Method used reset the object back to its default (invalid) state. */
  public void invalidate();
}




