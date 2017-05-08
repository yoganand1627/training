/**
 * User: mkw
 * Date: Nov 11, 2002
 * Time: 3:24:13 PM
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

public class ParamTag extends TagSupport {
  public ParamTag() {
    super();
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    GrndsTrace.exitScope();
  }

  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    Tag parent = getParent();
    if (parent instanceof IncludeTag) {
      IncludeTag includeTag = (IncludeTag) parent;
      includeTag.addParameter(name, value);
      GrndsTrace.exitScope();
      return Tag.SKIP_BODY;
    } else {
      throw new JspException("The param tag must appear within the include tag.");
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setValue(String value) {
    this.value = value;
  }

  private String name = null;
  private String value = null;

  private static final String TRACE_TAG = "ParamTag";
}
