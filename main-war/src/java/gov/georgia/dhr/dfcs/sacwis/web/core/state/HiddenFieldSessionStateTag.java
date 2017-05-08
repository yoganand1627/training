package gov.georgia.dhr.dfcs.sacwis.web.core.state;

// -- Java classes --

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * This tag class provides a convenient way for page designers to insert the hidden field that contains persisted keys
 * and values across multiple pages into the form on the current page. For example: <br> <input type="hidden"
 * name="hiddenField" value=""> <br> The way the tag is used is simply add this line inside a form definition on a jsp
 * page: <br> <tagprefix:tagname /> <br> Where tagprefix references the taglib declaration on the JSP and tagname
 * references the name which is associated with this class in the tld file.
 */
public class HiddenFieldSessionStateTag extends TagSupport {
  public int doStartTag() throws JspException {
    JspWriter out = super.pageContext.getOut();
    HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();

    String encodedSessionState = this.getEncodedSessionState(request);

    try {
      out.print("<input type=\"hidden\" name=\"" +
                HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY + "\" value=\"");
      out.print(encodedSessionState);
      out.print("\">");
    }
    catch (IOException e) {
      throw new JspException("IOException occured while creating session management hidden field", e);
    }
    return (TagSupport.SKIP_BODY);
  }

  public String getEncodedSessionState(HttpServletRequest request) throws JspException {
    HiddenFieldSessionStateManager stateManager =
            (HiddenFieldSessionStateManager) request.getAttribute(
                    HiddenFieldSessionStateManager.STATE_MANAGER_KEY);

    String encodedSessionState = null;
    if (stateManager != null) {
      try {
        encodedSessionState = stateManager.encodeAttributesMap(request);
      }
      catch (StateException e) {
        throw new JspException("Problems encoding session state for hidden field", e);
      }
    }
    return encodedSessionState;
  }
}










