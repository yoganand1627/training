package gov.georgia.dhr.dfcs.sacwis.web.core.personalization;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * This class is used primarily to hold criteria that an embedded tag will use for personalization. This tag doesn't
 * have any functionality and is only worth using when embedded tags will use the criteria in an if-else fashion (one
 * tag will specify what to show if the criteria is a match, the other will specify what to display if the criteria does
 * not match).  If a tag is not going to be used in an if-else fashion, it can be used independently of this outer tag.
 */
public class PersonalizationCriteriaTag extends TagSupport {

  /**
   * This method is executed when the start tag is reached for this tag.  Since there is no logic to this method, it
   * simply returns a flag telling the page to evaluate the body of the tag.
   *
   * @return int The integer telling the page to evaluate the contents of the tag.
   */
  public int doStartTag() {
    return TagSupport.EVAL_BODY_INCLUDE;
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
   * This method is used to set the criteria for this tag.  The criteria are set to the attribute equalTo on the tag --
   * the tag then takes that string value and breaks it up into a Set of values.
   *
   * @param value The String from the HTML tag attribute 'equalTo'
   */
  public void setEqualTo(String value) {
    this.criteria = PersonalizationHelper.parseCriteria(value);
  }

  /**
   * This method is used by the embedded tag to get the criteria that was set.
   *
   * @return Set The set of criteria values.
   */
  public List getCriteria() {
    return this.criteria;
  }

  //instance variables
  private List criteria = new ArrayList();

}












