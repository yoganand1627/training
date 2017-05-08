package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

/**
 * The FormErrorTag creates the placeholder for the form validation error messages. Each error is displayed on its own
 * line in a standard style, and highlights the offending input when clicked.
 *
 * @author Kelly J. Mayes
 */
public class FormErrorTag extends TagSupport {
  /** Default constructor. */
  public FormErrorTag() {
    super();
    formName = null;
  }

  /**
   * Do not set the form name as it will not be used in this tag. The logic for displaying the error messages is now in
   * the closing html of the form tag
   *
   * @param formName the name of the form to display errors for.
   */
  public void setFormName(String formName) {
    this.formName = formName;
  }

  /**
   * Creates a placeholder for the form error messages
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    try {
      JspWriter out = this.pageContext.getOut();
      // SPB SIR 18845 - reversed order of errors
      out.println("<table width=\"100%\">\n<tr>\n<td id=\"errorMsg\">\n</td>\n</tr>\n</table>");
      out.println("<table width=\"100%\">\n<tr>\n<td id=\"infoMsg\">\n</td>\n</tr>\n</table>");
    }
    catch (java.io.IOException e) {
      throw new JspException("Could not write validation error place holder to output");
    }
    GrndsTrace.exitScope();
    //The body of this tag is irrelevant.
    return super.SKIP_BODY;
  }

  //Static Constants
  private static final String TRACE_TAG = "FormErrorTag";
  //Instance variables
  private String formName;
}

