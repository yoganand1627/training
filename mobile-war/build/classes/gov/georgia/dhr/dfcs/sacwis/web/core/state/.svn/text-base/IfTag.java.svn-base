package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/* Careful: IfTag ALWAYS evaluates the body
* ThenTag: only evaluates if IfTag was True
* ElseTag: only evaluates if IfTag was False
*/

public class IfTag
        extends TagSupport {
  public static final String TRACE_TAG = "IfTag";
  protected boolean test = false;

  public void setTest(boolean test) {
    this.test = test;
  }

  public boolean getTest() {
    return test;
  }

  public int doStartTag()
          throws JspException {
//          GrndsTrace.enterScope(TRACE_TAG + ".doStartTag, test = " + test);
    return EVAL_BODY_INCLUDE;
  }

  public int doEndTag()
          throws JspException {
//          GrndsTrace.exitScope(TRACE_TAG + ".doEndTag");
    return EVAL_PAGE;
  }
}
