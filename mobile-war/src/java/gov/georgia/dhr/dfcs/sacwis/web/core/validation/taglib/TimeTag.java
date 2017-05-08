package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * The DateTag class replaces the HTML for an input field with a calendar icon.
 * <p/>
 * Creates an input field with maxlength of 5 followed by a select box with AM and PM options. Takes a full time string
 * such as 12:34 AM as the value, which is parsed, setting the values into both fields. If disabled or not editable
 * creates a hidden field with the "XX:YY AA" value
 * <pre>
 * Change History:
 * Date        User      Description
 * --------    -------- --------------------------------------------------
 * 07/25/05    ROBERTSW   SIR 23728 - Fixed TimeTag so not to use pooled custom tag value for MPS.
 * 2/14/08     cjgerry   STGAP00007422 - trim trailing white space before getting time string to avoid ParseException
 * </pre>
 *
 * @author Stephan Brauchli
 */
public class TimeTag extends InputTag {

  public static final DateFormat dateWithAMPM = new SimpleDateFormat("hh:mm aa");
  public static final DateFormat dateWithoutAMPM = new SimpleDateFormat("hh:mm");
  public static final DateFormat dateAMPM = new SimpleDateFormat("aa");

  {
    // Make it so these do not parse times leniently.
    dateWithAMPM.setLenient(false);
    dateWithoutAMPM.setLenient(false);
    dateAMPM.setLenient(false);
  }

  private static final String TRACE_TAG = "DateTag";

  private String time = "";
  private String ampm = "";
  private String selectValue = "";
  private String defaultAmPm = "AM";

  public TimeTag() {
    super.setConstraint("Time");
    GrndsTrace.enterScope(TRACE_TAG + ".constructor time tag");
    GrndsTrace.exitScope();
  }

  /**
   * Creates the HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml in TimeTag");
    ServletRequest request = this.pageContext.getRequest();
    StringBuffer buffer = new StringBuffer();
    String strTime = super.getValue();
    String selectName = "sel" + this.getName();
    this.selectValue = request.getParameter(selectName);

    try {
      this.validateTime(strTime);
    } catch (Exception e) {
      // Ignore this.
    }
    boolean disabled;
    if (!this.isEditable() || super.getAttribute("disabled") != null) {
      disabled = true;
      //SPB 5/27/2003 - if a value was specified, create the hidden fields.
      if (StringHelper.isValid(this.time)) {
        buffer.append("<input type=\"hidden\"");
        buffer.append(" value=\"");
        buffer.append(this.time);
        buffer.append("\" name=\"");
        buffer.append(this.getName());
        buffer.append("\" >");
        buffer.append(ArchitectureConstants.LINE_BREAK);
        buffer.append("<input type=\"hidden\"");
        buffer.append(" value=\"");
        buffer.append(this.ampm);
        buffer.append("\" name=\"");
        buffer.append("sel").append(this.getName());
        buffer.append("\" >");
      }
    } else {
      // SWR - Set explicitly to false.  JBoss was retaining class value because
      // of custom tag pooling.  Changed for MPS.
      disabled = false;
    }

    buffer.append(super.createLabelHtml());
    buffer.append("<input type=\"text\"");
    if (disabled) {
      super.setAttribute("disabled", "");
    }
    //Only remove the attribute if it is Editable and Disabled was not explicity set.
    else if (!super.getDisabledInd()) {
      super.removeAttribute("disabled");
    }

    buffer.append(" value=\"");
    buffer.append(this.time);
    buffer.append("\" name=\"");
    buffer.append(this.getName());
    if (disabled) {
      buffer.append("_Disabled");
    }
    buffer.append("\" ");
    buffer.append("size=\"5\" maxlength=\"5\" ");
    buffer.append("\" id=\"");
    buffer.append(super.getId());
    buffer.append("\" ");
    buffer.append(super.listAttributes());
    buffer.append(" >");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<select");
    if (disabled) {
      buffer.append(" disabled ");
    }
    buffer.append(" tabindex=\"").append(super.getAttribute("tabindex")).append("\"");
    buffer.append(" name=\"");
    buffer.append(selectName);
    buffer.append("\">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<option value=\"AM\" ");
    if ("AM".equalsIgnoreCase(this.ampm)) {
      buffer.append("selected>AM</option>");
    } else {
      buffer.append(">AM</option>");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<option value=\"PM\" ");
    if ("PM".equalsIgnoreCase(this.ampm)) {
      buffer.append("selected>PM</option>");
    } else {
      buffer.append(">PM</option>");
    }
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("</select>");
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  public static String getCorrectTimeString(String time, String ampm) throws ParseException {
    //STGAP00007422:cjg - need to trim of trailing space to avoid ParseException
    String newTime = time.trim();
    // Added 5/21/2003 SPB SIR # 17723
    if (newTime != null && !"".equals(newTime)) {
      // if the time string does not contain a :
      if (newTime.indexOf(":") == -1) {
        if (newTime.length() == 3) {
          newTime = '0' + newTime;
        }
        if (newTime.length() == 4) {
          String strHours = newTime.substring(0, 2) + ':';
          newTime = strHours + newTime.substring(2, 4);
        }
      } else {
        // there is a :
        // if this uses a 1 digit hour, you need to add a leading zero
        // the best way to tell if this needs a leading zero is to see if the
        // colon is the character in position 2. If not, add the leading zero.
        if (newTime.charAt(2) != ':') {
          newTime = '0' + newTime;
        }
      }
      if (ampm != null && !"".equals(ampm)) {
        newTime += " " + ampm;
        // parse the time field to generate an exception if the time isn't valid
        TimeTag.dateWithAMPM.parse(newTime);
      } else {
        TimeTag.dateWithoutAMPM.parse(newTime);
      }

    }
    return newTime;
  }

  public Date parseTime(String timeString) {
    try {
      String ampm = null;
      timeString = TimeTag.getCorrectTimeString(timeString, ampm);
      if (timeString == null || timeString.trim().length() != 5) {
        return null;
      }
      return dateWithoutAMPM.parse(timeString);
    } catch (ParseException e) {
      GrndsTrace.msg(TRACE_TAG, 9, "Caught ParseException");
    }
    return null;
  }

  public Date parseTimeAMPM(String timeString) {
    timeString = timeString.trim();
    if (timeString == null || timeString.length() != 8) {
      return null;
    }
    try {
      return dateWithAMPM.parse(timeString);
    } catch (ParseException e) {
    }
    return null;
  }

  protected void validateTime(String timeString) {
    Date dateTimeAMPM = parseTimeAMPM(timeString);
    // if coming from DB as value attribute to custom tag
    if (dateTimeAMPM != null) {
      this.time = dateWithoutAMPM.format(dateTimeAMPM);
      this.ampm = dateAMPM.format(dateTimeAMPM);
    } else {
      Date dateTime = parseTime(timeString);
      // if coming from text input
      if (dateTime != null) {
        this.time = dateWithoutAMPM.format(dateTime);
        this.ampm = this.selectValue;
      } else {
        this.time = "";
        //this.ampm = "AM";
        this.ampm = this.defaultAmPm;
      }
    }

  }

  public void setDefaultAmPm(String dampm) {
    defaultAmPm = dampm;
  }

  public String getDefaultAmPm() {
    return defaultAmPm;
  }
}