package gov.georgia.dhr.dfcs.sacwis.web.core.personalization;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

/**
 * This parent class defines the logic to determine whether or not to display part of a page to the user depending on
 * parameters on the UserProfile object.
 */
public abstract class BasePersonalizeOnCriteriaTag extends TagSupport {

  /**
   * This method is executed when the start tag is reached for this tag.  It will check to see whether the user should
   * be able to view the content of the tag and return a flag indicating that the body should be displayed or not
   * displayed.
   *
   * @return int Flag indicating whether the contents of the tag should be displayed or not.
   */
  public int doStartTag() throws JspException {
    int returnValue = TagSupport.EVAL_BODY_INCLUDE;

    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    if (!this.canUserViewContent(user)) {
      returnValue = TagSupport.SKIP_BODY;
    }

    return returnValue;
  }

  /**
   * This method is executed when the end tag is reached for this tag.  Since there is no real logic to this method, it
   * simply returns a flag telling the page to evaluate the rest of the page following the tag.
   *
   * @return int The integer telling the page to evaluate the page after the tag.
   */
  public int doEndTag() {
    return TagSupport.EVAL_PAGE;
  }

  /**
   * This method is used to set whether this tag should match on criteria from an outer tag.  If the value is set to
   * false then it will match on criteria that does not match the criteria of the outer tag.  If the value is set to
   * true then it will match on the criteria.  If it is not set then the tag will behave independently of any external
   * tags.  <b>NOTE:</b>  If the value is set to false then it is legal to set more notEqualTo values on top of those
   * contained in the outer tag.  In addition, if the value is set to true then it is legal to set more equalTo values
   * on top of those contained in the outer tag.
   *
   * @param match The String from the HTML tag attribute 'equalTo'
   */
  public void setMatch(String match) {
    this.match = Boolean.valueOf(match);
  }

  /**
   * This method is used to set the criteria for this tag.  The criteria are set to the attribute equalTo on the tag --
   * the tag then takes that string value and breaks it up into a Set of values.  The equalTo attribute cannot be set in
   * conjunction with a notEqualTo attribute -- this will cause a JspException to be thrown.
   *
   * @param value The String from the HTML tag attribute 'equalTo'
   * @throws JspException If the notEqualTo attribute has already been set.
   */
  public void setEqualTo(String value) throws JspException {
    if (this.notEqualTo != null) {
      throw new JspException("Attempted to set both an equalTo and notEqualTo value, "
                             + "this is not legal.");
    }

    this.equalTo = PersonalizationHelper.parseCriteria(value);
  }

  /**
   * This method is used to set the criteria for this tag.  The criteria are set to the attribute notEqualTo on the tag
   * -- the tag then takes that string value and breaks it up into a Set of values.  The notEqualTo attribute cannot be
   * set in conjunction with a equalTo attribute -- this will cause a JspException to be thrown.
   *
   * @param value The String from the HTML tag attribute 'equalTo'
   * @throws JspException If the equalTo attribute has already been set.
   */
  public void setNotEqualTo(String value) throws JspException {
    if (this.equalTo != null) {
      throw new JspException("Attempted to set both an equalTo and notEqualTo value, "
                             + "this is not legal.");
    }

    this.notEqualTo = PersonalizationHelper.parseCriteria(value);
  }

  /**
   * This method determines whether the tag is being used independently or in conjunction with an outer tag.  It then
   * calls the appropriate method to see if the user can view the content.  These methods must be defined in a sub-class
   * because it will be specific to a certain type of criteria.
   *
   * @param user The user object to get values from to compare to the criteria.
   * @return boolean Whether or not the user is allowed to view the content.
   */
  boolean canUserViewContent(UserProfile user) throws JspException {
    boolean allowUserToViewContent = false;

    if (this.match == null) {
      allowUserToViewContent = this.checkCriteriaAsIndependentTag(user);
    } else {
      allowUserToViewContent = this.checkCriteriaAsSubTag(user);
    }

    return allowUserToViewContent;
  }

  /**
   * This method will get the appropriate criteria from the outer tag and add it to any additional criteria that may be
   * on this specific tag.  This method is called by the sub-class if it determines that it is being used as an embedded
   * tag.  It returns the resulting list that contains both the criteria from the outer tag as well as any additional
   * criteria that may have been specified on this tag.
   *
   * @return List The list of criteria to use.
   * @throws JspException If the page developer entered attribute values that cannot be used together.
   */
  List getCriteriaAsSubTag() throws JspException {

    List newList = PersonalizationHelper.getCriteriaFromOutsideTag(this);
    boolean match = this.match;

    if (!match && this.equalTo == null) {
      if (this.notEqualTo != null) {
        newList.addAll(this.notEqualTo);
      }
    } else if (match && this.notEqualTo == null) {
      if (this.equalTo != null) {
        newList.addAll(this.equalTo);
      }
    } else if (!match && this.equalTo != null) {
      throw new JspException("Attribute settings must make sense.  Setting 'match' to false "
                             + "and then specifying 'equalTo' values is not allowed.");
    } else if (match && this.notEqualTo != null) {
      throw new JspException("Attribute settings must make sense.  Setting 'match' to true "
                             + "and then specifying 'notEqualTo' values is not allowed.");
    }

    return newList;
  }

  /**
   * This method will return "true" if the equalTo value is set and the notEqualTo value is null.  The result of this
   * check will determine whether the checkCriteriaAsIndependentTag() method will return true or false if a match is
   * found.
   *
   * @return boolean Whether the equalTo value is being used.
   * @throws JspException if neither the equalTo or notEqualTo attribute has been set.
   */
  boolean useEqualTo() throws JspException {
    boolean returnValue = (this.equalTo != null && this.notEqualTo == null);

    if (this.equalTo == null && this.notEqualTo == null) {
      throw new JspException("Either the 'equalTo' or 'notEqualTo' attribute must be set.");
    }

    return returnValue;
  }

  /**
   * This method allows sub-classes to access the notEqualTo attribute list.
   *
   * @return Collection The list 'not equal to' of attributes.
   */
  Collection getNotEqualToValues() {
    return this.notEqualTo;
  }

  /**
   * This method allows sub-classes to access the equalTo attribute list.
   *
   * @return Collection The list 'equal to' of attributes.
   */
  Collection getEqualToValues() {
    return this.equalTo;
  }

  /**
   * This method allows sub-classes to access the match attribute.
   *
   * @return Boolean The attribute signifying whether to match on or not on the criteria of the outer tag.
   */
  Boolean getMatch() {
    return this.match;
  }

  /**
   * This method must be defined in a sub-class.  It will define how the tag decides if the user meets the criteria of
   * this tag independently.
   */
  abstract boolean checkCriteriaAsIndependentTag(UserProfile user) throws JspException;

  /**
   * This method must be defined in a sub-class.  It will define how the tag decides if the user meets the criteria set
   * in the PersonalizationCriteriaTag as well as any criteria defined in this tag.
   */
  abstract boolean checkCriteriaAsSubTag(UserProfile user) throws JspException;

  //instance variables
  private Boolean match;
  private Collection equalTo;
  private Collection notEqualTo;
}











