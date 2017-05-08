package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

// -- java classes --

import java.text.ParseException;

import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * The DateTag class replaces the HTML for an input field with a calendar icon.
 *
 * @author Lingam Rao
 *         <p/>
 *         <pre>
 *                         Change History:
 *                          Date        User      Description
 *                          ----------  --------  --------------------------------------------------
 *                          10/14/2004  dejuanr   SIR 23138 - Fixed Date Tag so that is only creates one
 *                                                version of the div and frame calendar.  It will now
 *                                                keep tell if this is the first tag on the page and
 *                                                use the calendarID variable to make sure the mininum
 *                                                number of tags are created.
 *                         </pre>
 */
public class DateTag
        extends InputTag {

  /** Default Constructor. */
  public DateTag() {
    super();
    super.setConstraint("Date");
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    this.bDoNotReuse = false;
    GrndsTrace.exitScope();
  }

  public void setDoNotReuse(String str) {
    if (StringHelper.isTrue(str)) {
      this.bDoNotReuse = true;
    }
  }

  /**
   * Creates the HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml");
    divID = "div_calendar_" + calendarID; // SIR 23138
    frameID = "frame_calendar_" + calendarID; // SIR 23138
    StringBuffer buffer = new StringBuffer();

    //If not editable, set disabled attribute
    if (!super.isEditable()) {
      super.setAttribute("disabled", "");
    }
    //Only remove the attribute if it is Editable and Disabled was not explicity set.
    else if (!super.getDisabledInd()) {
      super.removeAttribute("disabled");
    }

    //If disabled, set boolean to not show calendar icon
    if (super.getAttribute("disabled") == null) {
      this.showCalendar = true;
    } else {
      this.showCalendar = false;
    }

    buffer.append(super.createLabelHtml());
    GrndsTrace.msg(TRACE_TAG, 7, "   About to start creating date tag.");
    if (this.showCalendar) {
      // SIR 23138 Start
      if ("".equals(calendarID) || this.bDoNotReuse) {
        calendarID = this.getName();
        divID += calendarID;
        frameID += calendarID;
        buffer.append("<div id=\"");
        buffer.append(divID);
        buffer.append(
                "\" style=\"BORDER-BOTTOM: 2px ridge; z-index: 5; BORDER-LEFT: 2px ridge; BORDER-RIGHT: 2px ridge; BORDER-TOP: 2px ridge; POSITION: absolute; VISIBILITY: hidden; WIDTH: 10px\">");
        buffer.append(ArchitectureConstants.LINE_BREAK);
        buffer.append("<iframe frameborder=\"0\" height=\"188\" name=\"");
        buffer.append(frameID);
        buffer.append("\" scrolling=\"no\" src=\"/grnds-docs/js/shared/popcjs.htm\" width=\"183\"></iframe>");
        buffer.append(ArchitectureConstants.LINE_BREAK);
        buffer.append("</div>");
      }
      buffer.append("<script>document.attachEvent('onclick', hide_");
      // SIR 23138 End
      buffer.append(divID);
      buffer.append(" ); function hide_");
      buffer.append(divID);
      buffer.append("(){ ");
      buffer.append(divID);
      buffer.append(".style.visibility = \"hidden\";  }</script>");
      buffer.append(ArchitectureConstants.LINE_BREAK);
    }

    buffer.append(" <input type=\"text\" maxlength=\"10\" value=\"");
    buffer.append(super.getValue());
    buffer.append("\" name=\"");
    buffer.append(this.getName());
    //If field is disabled, field will not be submitted.  Append disabled to
    //field name and create hidden field with real value
    if (getAttribute("disabled") != null) {
      buffer.append("_Disabled");
    }
    buffer.append("\" size=\"8\" title=\"");
    buffer.append(getAttribute("title"));
    buffer.append("\" id=\"");
    buffer.append(super.getId());
    buffer.append("\" ");

    buffer.append(super.listAttributes());
    buffer.append("> ");

    //BEE - For view mode with disabled fields, create hidden field to hold value
    if (getAttribute("disabled") != null) {
      buffer.append(super.createViewModeHiddenField());
    }

    if (this.showCalendar) {
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("<script language=\"JavaScript\">");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append(
              "if(navigator.appName==\"Microsoft Internet Explorer\" && parseFloat(navigator.appVersion)>=4 ) { ");
      buffer.append("document.write('");
      buffer.append("<span id=\"cal_img_").append(divID).append("\" >");
      buffer.append("<a href=\"\" tabindex=\"-1\" onclick=\"");
      buffer.append(frameID);
      buffer.append(".fPopCalendar(");
      buffer.append(this.getName());
      buffer.append(",");
      buffer.append(this.getName());
      buffer.append(",");
      buffer.append(divID);
      buffer.append(");return false\">");
      buffer.append("<IMG tabindex=\"");
      buffer.append("-1"); // DO NOT WANT TO TAB TO CALENDAR
      //buffer.append( this.getAttribute( "tabindex" ) );
      buffer.append(
              "\" border=\"0\" src=\"/grnds-docs/images/shared/calendar.gif\" align=\"absmiddle\" alt=\"Calendar\"></a>");
      buffer.append("</span>");
      buffer.append("'); }");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append(" </script>");
    }
    GrndsTrace.exitScope();

    //SIR 23138 - Reset bDoNotReuse to false for next use of tag object
    this.bDoNotReuse = false;

    //cjg - for SHINES, reset to blank for more than one date on a page
    calendarID = "";

    return buffer.toString();
  }

  protected void createInput()
          throws JspException {
    super.createInput();
    //If date is not null or blank and does not contain a slash ("/")
    if (StringHelper.isValid(super.getValue()) && super.getValue().indexOf("/") <= 0) {
      //Convert it into a date and then format it.
      try {
        super.setValue(FormattingHelper.formatDate(DateHelper.toJavaDateFromInput(super.getValue())));
      }
      catch (ParseException ex) {
        //Ignore parsing exception
        GrndsTrace.msg(TRACE_TAG, 7, "Ignore Parsing Exception ");
      }
    }
  }

  private static final String TRACE_TAG = "DateTag";
  private String divID = "";
  private String frameID = "";
  private boolean showCalendar = false;
  private String calendarID = "";  // SIR 23138
  private boolean bDoNotReuse = false;

}