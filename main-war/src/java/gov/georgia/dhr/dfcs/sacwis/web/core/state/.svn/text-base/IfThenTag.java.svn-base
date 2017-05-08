package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/*
* IfThen evaluates the body if true
*/

public class IfThenTag
        extends TagSupport {
  public static final String TRACE_TAG = "IfThenTag";
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
    if (test) {
      return EVAL_BODY_INCLUDE;
    }
    return SKIP_BODY;
  }

  public int doEndTag()
          throws JspException {
//          GrndsTrace.exitScope(TRACE_TAG + ".doEndTag");
    return EVAL_PAGE;
  }
}
