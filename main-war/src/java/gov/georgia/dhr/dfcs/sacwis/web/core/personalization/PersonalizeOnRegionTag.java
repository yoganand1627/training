package gov.georgia.dhr.dfcs.sacwis.web.core.personalization;

import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspException;

import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

/**
 * This tag will allow developers to easily personalize pages the user will see based on the region they belong to.  The
 * tag may be used independently, or as an embedded tag within the PersonalizationCriteriaTag.
 */
public class PersonalizeOnRegionTag extends BasePersonalizeOnCriteriaTag {

  /**
   * This method contains the logic to use an outer tag and determine if the user is from the correct region to view the
   * contents of this tag.
   *
   * @param user The UserProfile object for the current user.
   * @return boolean Whether or not the user is from the correct region to view the contents of this tag.
   */
  boolean checkCriteriaAsSubTag(UserProfile user) throws JspException {
    boolean allowUserToViewContent = false;

    boolean match = super.getMatch();
    List newList = super.getCriteriaAsSubTag();

    if (match == true) {
      allowUserToViewContent = newList.contains(user.getUserRegion());
    } else {
      allowUserToViewContent = !newList.contains(user.getUserRegion());
    }

    return allowUserToViewContent;
  }

  /**
   * This method contains the logic to determine independently if the user is from the correct region to view the
   * contents of this tag.
   *
   * @param user The UserProfile object for the current user.
   * @return boolean Whether or not the user is from the correct region to view the contents of this tag.
   */
  boolean checkCriteriaAsIndependentTag(UserProfile user) throws JspException {
    boolean allowUserToViewContent = false;

    if (super.useEqualTo()) {
      Collection equalToValues = super.getEqualToValues();
      allowUserToViewContent = equalToValues.contains(user.getUserRegion());
    } else //use notEqualTo
    {
      Collection notEqualToValues = super.getNotEqualToValues();
      allowUserToViewContent = !notEqualToValues.contains(user.getUserRegion());
    }

    return allowUserToViewContent;
  }
}











