package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author piazzaat
 *         <p/>
 *         Tag used to include content only when web app is running on the server. Change History: Date        User
 *         Description --------    --------  -------------------------------------------------- 07/24/05    werlem
 *         SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */
public class IfServerImpact implements Tag {
  protected PageContext pageContext;
  private Tag parent;

  public void setPageContext(PageContext pageContext) {
    this.pageContext = pageContext;
  }

  public void setParent(Tag tag) {
    this.parent = tag;
  }

  public Tag getParent() {
    return this.parent;
  }

  public int doStartTag()
          throws JspException {
    return (PlatformConstants.SERVER_IMPACT ? EVAL_BODY_INCLUDE : SKIP_BODY);
  }

  public int doEndTag()
          throws JspException {
    return EVAL_PAGE;
  }

  public void release() {
    parent = null;
  }
}
