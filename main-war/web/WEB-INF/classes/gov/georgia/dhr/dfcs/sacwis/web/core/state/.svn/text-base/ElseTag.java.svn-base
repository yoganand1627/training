package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/* Careful: IfTag ALWAYS evaluates the body
* ThenTag: only evaluates if IfTag was True
* ElseTag: only evaluates if IfTag was False
*/

public class ElseTag
        extends TagSupport {
  public int doStartTag()
          throws JspException {
    IfTag tag = (IfTag) findAncestorWithClass(this, IfTag.class);
    if (tag == null) {
      throw new IllegalStateException("ElseTag must be nested within an IfTag");
    }
    if (tag.getTest() == false) {
      return EVAL_BODY_INCLUDE;
    }
    return SKIP_BODY;
  }
}
