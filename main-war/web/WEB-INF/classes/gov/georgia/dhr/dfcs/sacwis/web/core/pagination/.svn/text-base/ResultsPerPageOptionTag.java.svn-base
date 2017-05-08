package gov.georgia.dhr.dfcs.sacwis.web.core.pagination;

// java classes

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;

/**
 * This custom tag simply generates an Option Box from which the user can select how many results should be displayed on
 * each page of a database search.
 *
 * @author Randy O'Neil, October 22, 2001
 */
public class ResultsPerPageOptionTag extends TagSupport {

  /**
   * This method will except an array of Integer objects to create the option box. This is an OPTIONAL field to set.  In
   * most cases the defaults should work fine without any changes.
   *
   * @param options The array of integer values to use for the options
   */
  public void setOptions(int[] options) {
    this.options = options;
  }

  /**
   * This method creates the HTML output for the option box.  It will either use user-defined options or, if none have
   * been defined, default values.
   *
   * @return int A constant value defining whether or not to display the body contained in this tag.
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(ResultsPerPageOptionTag.TRACE_TAG + ".doStartTag");
    JspWriter out = pageContext.getOut();
    ServletRequest request = pageContext.getRequest();

    String lastSelected = request.getParameter(DatabaseResultDetails.RESULTS_PER_PAGE_NAME);
    int last = 0;

    if (lastSelected != null && !"".equals(lastSelected)) {
      last = new Integer(lastSelected);
    }

    try {
      String start = this.getOptionBoxStartHtml();
      out.println(start);

      for (int i = 0; i < options.length; i++) {
        String option = this.getOptionHtml(options[i], last);
        if (option != null) {
          out.println(option);
        }
      }

      out.println("</select>");
    }
    catch (IOException ex) {
      throw new JspException("Exception generating ResultsPerPageOptionTag in "
                             + "doStartTag(), see details: \n" + ex.getMessage(), ex);
    }

    GrndsTrace.exitScope();
    return TagSupport.SKIP_BODY;
  }

  /**
   * This method returns the HTML code to generate the option box.
   *
   * @return String the HTML code to return
   */
  private String getOptionBoxStartHtml() {
    StringBuffer buffer = new StringBuffer("<select name=\"");
    buffer.append(DatabaseResultDetails.RESULTS_PER_PAGE_NAME);
    buffer.append("\">");

    return (buffer.toString());
  }

  /**
   * Creates and returns the HTML for an option that is part of the option box.
   *
   * @param intValue the number of results per page to display
   * @return String the HTML to create the option in the option box
   */
  private String getOptionHtml(int intValue, int last) {
    String returnValue = null;
    //don't display zero or negative options
    if (intValue > 0) {
      StringBuffer buffer = new StringBuffer();
      if (intValue == last) {
        buffer.append("<option selected value=\"");
      } else {
        buffer.append("<option value=\"");
      }
      buffer.append(intValue);
      buffer.append("\">");
      buffer.append(intValue);
      buffer.append("</option>");

      returnValue = buffer.toString();
    }

    return returnValue;
  }

  // static constants
  private static final String TRACE_TAG = "ResultsPerPageOptionTag"; //for tracing

  // instance variables
  private int[] options = new int[] {25, 50, 75, 100};

}










