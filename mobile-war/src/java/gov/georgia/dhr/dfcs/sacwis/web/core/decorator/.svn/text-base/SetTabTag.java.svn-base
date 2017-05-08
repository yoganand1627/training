package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

/** This tag is used to include Tab parameters into the presentation template. */
public class SetTabTag extends InsertTag {

  private static final String TRACE_TAG = "SetTabTag";

  private String parameter = null;
  private Parameter parameterRef = null;
  private Screen screen = null;

  /** Set the parameter to be included */
  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  /** Override the doStartTag of the parent class */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    try {
      screen = (Screen) pageContext.getRequest().getAttribute(ScreenDefinitionsXmlDao.SCREEN);
      GrndsTrace.msg(TRACE_TAG, 5, "Screen: " + screen);
    } catch (NullPointerException e) {
      throw new JspException("Decorator Exception: Error extracting screenManager from session.", e);
    }

    if ((screen != null) && (parameter != null)) {
      parameterRef = screen.getParameter(parameter);
    } else if (screen == null) {
      GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: Screen definition not found in request");
      throw new JspException("Decorator Exception: Screen definition not found in request");
    } else {
      GrndsTrace.msg(TRACE_TAG, 7, "Decorator Exception: Screen parameter is null");
      throw new JspException("Decorator Exception: Screen parameter is null");
    }
    //Set the parameter onto the request as a attribute so the metaphor can use it.
    if (parameterRef != null) {
      pageContext.getRequest().setAttribute(parameterRef.getKey(), parameterRef.getValue());
    }
    GrndsTrace.exitScope();
    return SKIP_BODY;
  }
}