package gov.georgia.dhr.dfcs.sacwis.web.core.personalization;

import java.util.List;

import javax.servlet.jsp.JspException;

import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

/**
 * This tag will allow developers to easily personalize pages the user will see based on the rights they have.  The tag
 * may be used independently, or as an embedded tag within the PersonalizationCriteriaTag.
 */
public class PersonalizeOnRightTag extends BasePersonalizeOnCriteriaTag {

  /**
   * This method contains the logic to use an outer tag and determine if the user has the correct rights to view the
   * contents of this tag.
   *
   * @param user The UserProfile object for the current user.
   * @return boolean Whether or not the user has the rights to view the contents of this tag.
   */
  boolean checkCriteriaAsSubTag(UserProfile user) throws JspException {
    boolean allowUserToViewContent = false;

    boolean match = super.getMatch();
    List newList = super.getCriteriaAsSubTag();

    if (match) {
      allowUserToViewContent =
              PersonalizationHelper.isStringFromCollectionInSet(newList, user.getRights());
    } else {
      allowUserToViewContent =
              !PersonalizationHelper.isStringFromCollectionInSet(newList, user.getRights());
    }

    return allowUserToViewContent;
  }

  /**
   * This method contains the logic to independently determine if the user has the correct rights to view the contents
   * of this tag.
   *
   * @param user The UserProfile object for the current user.
   * @return boolean Whether or not the user has the rights to view the contents of this tag.
   */
  boolean checkCriteriaAsIndependentTag(UserProfile user) throws JspException {
    boolean allowUserToViewContent = false;

    if (super.useEqualTo()) {
      allowUserToViewContent = PersonalizationHelper.isStringFromCollectionInSet(
              super.getEqualToValues(), user.getRights());
    } else // use notEqualTo
    {
      allowUserToViewContent = !PersonalizationHelper.isStringFromCollectionInSet(
              super.getNotEqualToValues(), user.getRights());
    }

    return allowUserToViewContent;
  }
}












