package gov.georgia.dhr.dfcs.sacwis.web.core.pagination;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;

/**
 * This tag should be used on any page that will be used to update currently existing data. This class will create a
 * hidden field to store the timestamps for the data being modified. It will place them in the request in a defined
 * location where the ValueBeanHelper knows how to get it and place it back on the bean after the page has been
 * submitted.
 *
 * @author Randy O'Neil, October 29, 2001
 */
public class TimestampHiddenFieldTag extends TagSupport {
  /**
   * This method creates the HTML output for the hidden field that will store the timestamp information
   *
   * @return A constant value (int) defining whether or not to display the body contained in this tag.
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TimestampHiddenFieldTag.TRACE_TAG + ".doStartTag");

    JspWriter out = pageContext.getOut();
    ServletRequest request = pageContext.getRequest();

    Object temporaryObject = request.getAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME);

    if (temporaryObject != null && temporaryObject instanceof BaseValueBean) {
      BaseValueBean bean = (BaseValueBean) temporaryObject;

      try {
        out.println(this.getUpdatedOnFields(bean));
        out.println(this.getCreatedOnField(bean));
        out.println(this.getCreatedByField(bean));
      }
      catch (IOException ex) {
        throw new JspException("Exception generating hidden timestamp fields from"
                               + " TimestampHiddenFieldTag in doStartTag(), see details: \n" + ex.getMessage(), ex);
      }
    }

    GrndsTrace.exitScope();
    return TagSupport.EVAL_BODY_INCLUDE;
  }

  /**
   * This helper method will create the timestamp hidden field(s) for the "updated on" time. "Updated on" timestamps are
   * stored in a hashmap in the bean, with table names serving as the keys for the hashmap, and timestamps serving as
   * values. This method will iterate through the hashmap, creating a new hidden field for each hashmap entry.
   *
   * @param bean The BaseValueBean to get the "updated on" timestamps from
   * @return String the HTML string to write to the JspWriter that will create the hidden field(s)
   */
  String getUpdatedOnFields(BaseValueBean bean) {
    // This will hold the entire HTML string as we build it up
    StringBuffer updatedOnTimestampsBuffer = new StringBuffer("");

    // This will hold portions of the HTML string as we build up updatedOnTimeStampsBuffer
    String htmlSnippet;

    // Get the full list of timestamps and associated table names from the bean
    Map updatedOnTimestampsHashMap = bean.getUpdatedOn();

    // Convert this hashmap into a collection, so we can iterate over it
    Set updatedOnTimestampsSet = updatedOnTimestampsHashMap.entrySet();

    // Iterate through the collection, passing key and value to this.getHiddenField(),
    // and getting an html string back. Concatenate these html strings in the stringbuffer.
    Iterator updatedOnTimestampsIterator = updatedOnTimestampsSet.iterator();
    Entry timestampEntry = null;
    String tableName = null;
    String hiddenFieldName = null;
    Timestamp timestamp = null;
    Long updatedOnTime;
    String updatedOnTimeAsString = null;
    String hiddenFieldValue = null;
    int counter = 0;

    while (updatedOnTimestampsIterator.hasNext()) {
      // Because we may be storing several hidden fields corresponding to
      // several Updated On timestamps (since there may be several entries
      // in the hashmap of Updated On timestamps), we will append a counter
      // number to the end of each parameter name.
      hiddenFieldName = BaseValueBean.UPDATED_ON_TIME_STAMP + counter;
      counter++;

      // We need to store the table name in the hidden field as well. Do this by
      // concatenating the table name, a period, and then the timestamp. We
      // will parse this later to pull apart the table name and the timestamp.
      timestampEntry = (Entry) updatedOnTimestampsIterator.next();
      timestamp = (Timestamp) timestampEntry.getValue();
      updatedOnTime = timestamp.getTime();
      updatedOnTimeAsString = updatedOnTime.toString();
      tableName = (String) timestampEntry.getKey();
      hiddenFieldValue = tableName + "." + updatedOnTimeAsString;

      htmlSnippet = this.getHiddenField(hiddenFieldName, hiddenFieldValue);
      updatedOnTimestampsBuffer = updatedOnTimestampsBuffer.append(htmlSnippet);
    }

    String updatedOnTimestamps = updatedOnTimestampsBuffer.toString();
    return updatedOnTimestamps;
  }

  /**
   * This helper method will create the timestamp hidden field for the "created on" time.
   *
   * @param bean The BaseValueBean to get the created on timestamp from.
   * @return String the HTML to write to the JspWriter that will create the hidden field
   */
  String getCreatedOnField(BaseValueBean bean) {
    Timestamp createdOnTimestamp = bean.getCreatedOn();
    String createdOnTimestampField = "";

    if (createdOnTimestamp != null) {
      long createdOnTime = createdOnTimestamp.getTime();
      createdOnTimestampField = this.getHiddenField(BaseValueBean.CREATED_ON_TIME_STAMP,
                                                    "" + createdOnTime);
    }

    return createdOnTimestampField;
  }

  /**
   * This helper method will create the timestamp hidden field for the "created by" user
   *
   * @param bean The BaseValueBean to get the created by information from.
   * @return String the HTML to write to the JspWriter that will create the hidden field
   */
  String getCreatedByField(BaseValueBean bean) {
    String createdByName = bean.getCreatedBy();
    String createdByTimestampField = "";

    if (createdByName != null) {
      createdByTimestampField = this.getHiddenField(BaseValueBean.CREATED_BY, createdByName);
    }

    return createdByTimestampField;
  }

  /**
   * This helper method will create the hidden field to hold the value in
   *
   * @param name  The name to call the field
   * @param value the value to save to the field
   * @return String the HTML corresponding to the hidden field
   */
  String getHiddenField(String name, String value) {
    String hiddenField = "";
    if (value != null) {
      StringBuffer buffer = new StringBuffer("<input type=\"hidden\" name=\"");
      buffer.append(name);
      buffer.append("\" value=\"");
      buffer.append(value);
      buffer.append("\"/><br/>");
      hiddenField = buffer.toString();
    }

    return hiddenField;
  }

  // static constants
  private static final String TRACE_TAG = "TimestampHiddenFieldTag"; //for tracing
}







