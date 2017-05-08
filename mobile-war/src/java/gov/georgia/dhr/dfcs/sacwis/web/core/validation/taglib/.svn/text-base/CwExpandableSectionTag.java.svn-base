package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

// -- java classes

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.ExpandableSectionHelper;

/**
 * The CwExpandableSectionTag class creates the HTML code which creates the expandable sections with the associated JS
 * calls and div tags.  This extends the normal expandable section tag to allow style formatting of the text to red
 * or blue in support of the case watch page.
 *
 * @author Patrick Coogan 12/5/2009
 */
public class CwExpandableSectionTag extends BaseHtmlTag {
  /** Default Constructor. */
  public CwExpandableSectionTag() {
    super();
    GrndsTrace.enterScope(CwExpandableSectionTag.TRACE_TAG + ".constructor");
    GrndsTrace.exitScope();
  }

  /**
   * Creates a FormValidation object to hold all data for this form and prints the form opening HTML tag to the output
   * stream.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    try {
      String startHtmlTable = this.createOpeningHtml();
      JspWriter out = super.pageContext.getOut();

      out.println(startHtmlTable);
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    //evaluate the body content of this tag
    return BaseHtmlTag.EVAL_BODY_INCLUDE;
  }

  /**
   * Prints the form closing HTML tag to the output stream along with HTML for custom hidden fields and javascript
   * validation if necessary.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doEndTag() throws JspException {
    // GrndsTrace.enterScope( TRACE_TAG + ".doEndTag" );
    JspWriter out = super.pageContext.getOut();

    try {
      String endHtmlTable = this.createClosingHtml();
      out.println(endHtmlTable);
    }
    catch (java.io.IOException ioe) {
      throw new JspException("Unable to write to JSP output");
    }
    catch (JspException jspe) {
      throw new JspException(jspe.getMessage());
    }

    GrndsTrace.exitScope();

    //Evaluate the rest of the page.
    return BaseHtmlTag.EVAL_PAGE;

  }

  /**
   * Sets the standard HTML input tag tabIndex attribute. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   */
  public void setTabIndex(int tabIndex) {
    GrndsTrace.enterScope(TRACE_TAG + ".setTabIndex");
    super.setAttribute("tabindex", String.valueOf(tabIndex));
    GrndsTrace.exitScope();
  }

  /**
   * Sets the boolean isComplete which determines whether to put a checkmark in the exapndable section header. See the
   * HTML 4.01 specification at http://www.w3.org/TR/html4/
   */
  public void setIsComplete(boolean isComplete) {
    GrndsTrace.enterScope(TRACE_TAG + ".setIsComplete");
    this.isComplete = isComplete;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the boolean isExpanded which determines whether to load the exapndable section open or closed. See the HTML
   * 4.01 specification at http://www.w3.org/TR/html4/
   */
  public void setIsExpanded(boolean isExpanded) {
    GrndsTrace.enterScope(TRACE_TAG + ".setIsExpanded");
    this.isExpanded = isExpanded;
    GrndsTrace.exitScope();
  }

  /** Sets the anchorName attribute. See the HTML 4.01 specification at http://www.w3.org/TR/html4/ */
  public void setAnchor(String strAnchor) {
    GrndsTrace.enterScope(TRACE_TAG + ".setAnchor");
    this.anchorName = strAnchor;
    GrndsTrace.exitScope();
  }

  /**
   * The createLabelHtml method returns an HTML String which contains the beginning Table and div tags
   *
   * @return a String containing HTML for the label
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(CwExpandableSectionTag.TRACE_TAG + ".createLabelHtml");
    expHiddenFieldName = "xpand" + super.getName();

    HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();
    String strFormName = "";
    if (this.getParentFormTag(request, this) != null) {
      strFormName = (this.getParentFormTag(request, this)).getName();
    }
    String xpandKey = strFormName + this.getName();
    String xpandedState = "";
    if (ExpandableSectionHelper.getExpandableSectionState(super.pageContext.getSession(), xpandKey) != null) {
      xpandedState = String.valueOf(ExpandableSectionHelper.getExpandableSectionState(super.pageContext.getSession(),
                                                                                      xpandKey));
      if (xpandedState == null ||
          !"true".equals(xpandedState)) {
        xpandedState = "false";
      }
    } else {
      xpandedState = "false";
    }

//    if( xpandedState != null )
//    {
//      if( xpandedState.equals( "true" ) )
//      {
//        isExpanded = true;
//      }
//      else
//      {
//        isExpanded = false;
//      }
//    }
    StringBuffer buffer = new StringBuffer();

    this.expandedName = "expanded" + super.getName();
    this.collapsedName = "collapsed" + super.getName();
    this.imgId_1 = "img1_" + this.expandedName;
    this.imgId_2 = "img1_" + this.collapsedName;
    this.anchorName = "anchor" + super.getName();

    buffer.append(" <a href=\"\" name=\"").append(anchorName).append("\"");
    if (StringHelper.isValid(this.getAccessKey())) {
      buffer.append(" accessKey=\"").append(this.getAccessKey()).append("\"");
    }
    buffer.append(" onFocus=\"expandCollapsedWithFlag( '");
    buffer.append(this.expandedName);
    buffer.append("', '").append(this.collapsedName);
    buffer.append("', '").append(this.expHiddenFieldName).append("_Id' ");
    buffer.append(");document.getElementById( '").append(this.imgId_2).append("' ).focus();");
    buffer.append(" \" ></a>");
    buffer.append("<div id=\"");
    buffer.append(this.collapsedName);
    buffer.append("\" style=\"Display: ");
    if (isExpanded) {
      buffer.append("none\"; >");
    } else {
      if (Boolean.valueOf(xpandedState)) {
        buffer.append("none\"; >");
      } else {
        buffer.append("block\"; >");
      }
    }
    buffer.append("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" class=\"tableborderExpand\">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<tr onMouseOver=\"mouseOverTurndown(event.srcElement)\" onClick=\"expandCollapsedWithFlag( '");
    buffer.append(this.expandedName);
    buffer.append("', '").append(this.collapsedName);
    buffer.append("', '").append(this.expHiddenFieldName).append("_Id' ");
    buffer.append("); \">");
    if (isComplete) {
      buffer.append("<th width=\"75%\" class=\"thExpand\">");
    } else {
      buffer.append("<th class=\"thExpand\">");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<img id=\"");
    buffer.append(this.imgId_1);
    buffer.append("\" src=\"/grnds-docs/images/shared/arrowClosed.gif\" alt=\"Closed\" onkeydown=\"");
    buffer.append("document.getElementById( '").append(this.expHiddenFieldName).append("_Id' ).value = 'true'; ");
    buffer.append("return expandWithFocus('");
    buffer.append(this.imgId_2);
    buffer.append("','");
    buffer.append(this.expandedName);
    buffer.append("', '");
    buffer.append(this.collapsedName);
    buffer.append("');\" tabindex=\"");
    buffer.append(super.getAttribute("tabindex"));
    buffer.append("\">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("&nbsp;");
    if ("E".equals(error)){
      buffer.append("<span style=\"color:red\">");
      buffer.append(super.getAttribute("title")).append("</span></th>");
    } else if ("W".equals(error)) {
      buffer.append("<span style=\"color:blue\">");
      buffer.append(super.getAttribute("title")).append("</span></th>");
    } else {
      buffer.append(super.getAttribute("title")).append("</th>");
    }

    if (isComplete) {
      buffer.append("<th width=\"25%\" class=\"thExpand\">");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("</th>");
    } else if (rightLabel != null) {
      buffer.append("<th class=\"thExpandRight\">");
      buffer.append(rightLabel);
      buffer.append("</th>");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("</tr></table></div>");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<div id=\"");
    buffer.append(this.expandedName);
    buffer.append("\" style=\"Display: ");
    if (isExpanded) {
      buffer.append("block\"; >");
    } else {
      if (Boolean.valueOf(xpandedState)) {
        buffer.append("block\"; >");
      } else {
        buffer.append("none\"; >");
      }
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    if (!"none".equalsIgnoreCase(this.anchorName)) {
      buffer.append("<a name=\"");
      buffer.append(this.anchorName);
      buffer.append("\"></a>");
    }
    buffer.append("<table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" class=\"tableborderExpand\">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    //

    buffer.append("<tr onMouseOver=\"mouseOverTurndown(event.srcElement)\" ");
    buffer.append(" onClick=\"collapseExpandedWithFlag( '");
    buffer.append(this.expandedName);
    buffer.append("', '").append(this.collapsedName);
    buffer.append("', '").append(this.expHiddenFieldName).append("_Id' ");
    buffer.append("); \">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    if (isComplete) {
      buffer.append("<th width=\"75%\" class=\"thExpand\">");
    } else {
      buffer.append("<th class=\"thExpand\">");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<img id=\"").append(this.imgId_2).append("\" ");
    buffer.append("src=\"/grnds-docs/images/shared/arrowOpen.gif\" alt=\"Open\" onClick=\"collapseExpandedWithFlag( '");
    buffer.append(this.expandedName);
    buffer.append("', '");
    buffer.append(this.collapsedName);
    buffer.append("', '").append(this.expHiddenFieldName).append("_Id' ");
    buffer.append("); \" onkeydown=\"");
    buffer.append("return collapseWithFocus( '");
    buffer.append(this.imgId_1);
    buffer.append("', '");
    buffer.append(this.expandedName);
    buffer.append("', '");
    buffer.append(this.collapsedName);
    buffer.append("', '").append(this.expHiddenFieldName).append("_Id' ");
    buffer.append("); \" tabindex=\"");
    buffer.append(super.getAttribute("tabindex"));
    buffer.append("\">&nbsp;");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    if ("E".equals(error)){
      buffer.append("<span style=\"color:red\">");
      buffer.append(super.getAttribute("title")).append("</span></th>");
    } else if ("W".equals(error)) {
      buffer.append("<span style=\"color:blue\">");
      buffer.append(super.getAttribute("title")).append("</span></th>");
    } else {
      buffer.append(super.getAttribute("title")).append("</th>");
    }
    if (isComplete) {
      buffer.append("<th width=\"25%\" class=\"thExpand\">");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("<img src=\"/grnds-docs/images/shared/checkMark_short.gif\" alt=\"Checkmark\" border=\"0\">");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("</th>");
    } else if (rightLabel != null) {
      buffer.append("<th class=\"thExpandRight\">");
      buffer.append(rightLabel);
      buffer.append("</th>");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("</tr><tr>");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    if (isComplete || rightLabel != null) {
      buffer.append("<td class=\"tableBG\" colspan=\"2\">");
    } else {
      buffer.append("<td class=\"tableBG\">");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(this.expHiddenFieldName);
    buffer.append("\" value=\"");
    buffer.append(xpandedState);
    buffer.append("\" id=\"");
    buffer.append(this.expHiddenFieldName).append("_Id");
    buffer.append("\" >");
    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(this.expSectionHiddenFieldName);
    buffer.append("\" value=\"");
    buffer.append(this.getName());
    buffer.append("\" >");
    GrndsTrace.exitScope( /*buffer.toString()*/);
    return buffer.toString();
  }

  /**
   * Creates the HTML tags to close the table as well as the outer div tag
   *
   * @return String containing closing HTML
   */
  String createClosingHtml() throws JspException {
    StringBuffer buffer = new StringBuffer();
    buffer.append("</td>");
    buffer.append("</tr>");
    buffer.append("</table>");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("</div>");
    GrndsTrace.exitScope( /*buffer.toString()*/);
    return buffer.toString();
  }

  public void setRightLabel(String rightLabel) {
    this.rightLabel = rightLabel;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getAccessKey() {
    return accessKey;
  }
  
  public String getError() {
    return error;
  }
  
  public void setError(String error) {
    this.error = error;
  }

  // -- static constants --
  private static final String TRACE_TAG = "ExpandableSectionTag";
  /** // -- instance variables -- */
  protected String expHiddenFieldName = "";
  protected String expSectionHiddenFieldName = "expSectionHiddenFieldName";
  protected String expandedName = "";
  protected String collapsedName = "";
  protected String anchorName = "none";
  protected String focusId = "";
  protected String imgId_1 = "";
  protected String imgId_2 = "";
  protected boolean isComplete = false;
  protected boolean isExpanded = false;
  protected boolean isInRequest = false;

  protected String rightLabel = null;
  private String accessKey = "";
  private String error = "";
}
