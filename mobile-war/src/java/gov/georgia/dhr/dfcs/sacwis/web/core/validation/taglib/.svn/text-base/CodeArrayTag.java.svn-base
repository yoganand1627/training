package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsRuntimeException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * The CodeArrayTag class creates a javaScript array for the values of the Code Table requested and the iterator is used
 * to populate a Java Script array which is used in turn to populate dynamic drop down lists.
 *
 * @author Sanjay Rana
 */
public class CodeArrayTag extends TagSupport {
  private static final String TRACE_TAG = "IteratorArrayTag";

  private String arrayName;
  private String codeName = null;
  private String orderBy = "code";
  private boolean blankValue;
  private String value;
  private Collection excludeOptions;
  private Collection options = null;

  /**
   * Sets the arrayName attribute
   *
   * @param arrayName name of Java Script array to used to contain values of Code table
   */
  public void setArrayName(String arrayName) {
    this.arrayName = arrayName;
  }

  /**
   * Sets the codeName attribute, which is the name of the codes table. Mutually exclusive from the setOptions
   *
   * @param codeName of codes table
   */
  public void setCodeName(String codeName) {
    if (this.options != null) {
      throw new BasePrsRuntimeException("Cannot set both OptionsList and CodeName attributes in the CodeArrayTag", 1);
    }
    this.codeName = codeName;
  }

  public void setBlankValue(String str) {
    if ("true".equalsIgnoreCase(str)) {
      this.blankValue = true;
    }
  }

  /**
   * Sets the codeName attribute, which is the name of the codes table. Mutually exclusive from the setOptions
   *
   * @param codeName of codes table
   */
  public void setOrderBy(String orderBy) {
    if (orderBy != null && "decode".equals(orderBy)) {
      this.orderBy = orderBy;
    }
  }

  /**
   * Override the parent definition of setValue to take in collections See the <a href="http://www.w3.org/TR/html4/">HTML
   * 4.01 specification</a>
   *
   * @param value a String value of the selected option for single-select boxes or a Collection of Strings for a
   *              multiple-select box.
   */
  public void setValue(String value) {
    GrndsTrace.enterScope(TRACE_TAG + ".setValue");

    if (StringHelper.isValid(value)) {
      this.value = value;
    }

    GrndsTrace.exitScope( /*value*/);
  }

  /**
   * Sets the custom select tag attribute: excludeOptions
   *
   * @param options A Collection containing key pairs that correspond to the value of the options.  These will be
   *                excluded  from the select box.
   */
  public void setExcludeOptions(Collection options) {
    GrndsTrace.enterScope(TRACE_TAG + ".setExcludeOptions");
    this.excludeOptions = options;
    GrndsTrace.exitScope();
  }

  /**
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag()
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".startTag");

    JspWriter out = this.pageContext.getOut();

    try {
      String html = this.createHtml();
      out.print(html);
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();
    //This tag should have no body
    return super.SKIP_BODY;
  }

  /**
   * Creates the HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createHtml() {

    GrndsTrace.enterScope(TRACE_TAG + ".createHtml");

    StringBuffer buffer = new StringBuffer("");
    try {
      Iterator codeIterator = null;
      if (this.codeName != null) {
        if ("decode".equals(this.orderBy)) {
          codeIterator = Lookup.getCategoryCollectionSortedByDecode(codeName).iterator();
        } else {
          codeIterator = Lookup.getCategoryListing(codeName);
        }
      } else if (this.options != null) {
        codeIterator = options.iterator();
      } else {
        throw new BasePrsRuntimeException(
                "You must set either the codeName or the options attribute in the CodeArrayTag", 1);
      }
      int i = 0;

      buffer.append("var ");
      buffer.append(arrayName);
      buffer.append(" = new Array();");

      if (blankValue) {
        buffer.append(arrayName);
        buffer.append("[");
        buffer.append(i);
        buffer.append("]= \"|\";");
        i++;
      }

      while (codeIterator.hasNext()) {
        Mapping columns = (Mapping) codeIterator.next();
        String decode = columns.getValue();
        String code = columns.getKey();

        if (excludeOptions == null || (excludeOptions != null && !excludeOptions.contains(code))) {
          //populate array to be used to populate the Facility Type drop-down box
          buffer.append(arrayName);
          buffer.append("[");
          buffer.append("").append(i);
          buffer.append("]= \"");
          buffer.append(StringEscapeUtils.escapeJavaScript(code));
          buffer.append("\"+\"|\"+\"");
          buffer.append(StringEscapeUtils.escapeJavaScript(decode));
          buffer.append("\";");
          i++;
        }
      }

      if (Lookup.isValidExpiredCode(this.codeName, this.value)) {
        String code = this.value;
        String decode = Lookup.simpleDecodeSafe(this.codeName, this.value);

        if (excludeOptions == null || (excludeOptions != null && !excludeOptions.contains(code))) {
          GrndsTrace.msg(TRACE_TAG, 10, "DONALD: not excluded");
          //populate array to be used to populate the Facility Type drop-down box
          buffer.append(arrayName);
          buffer.append("[");
          buffer.append("").append(i);
          buffer.append("]= \"");
          buffer.append(StringEscapeUtils.escapeJavaScript(code));
          buffer.append("\"+\"|\"+\"");
          buffer.append(StringEscapeUtils.escapeJavaScript(decode));
          buffer.append("\";");
        }
      }
    }
    catch (LookupException le) {
      GrndsTrace.msg(TRACE_TAG, 5, "Lookup Exception retrieving Codes Table for category: "
                                   + codeName + " Error: " + le.getMessage());
    }

    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Mutually exclusive from setCodeName. Takes a Collection of objects implementing the Mapping interface
   *
   * @param optionsList a Collection of objects implementing the Mapping interface
   */
  public void setOptions(Collection options) {
    if (this.codeName != null) {
      throw new BasePrsRuntimeException("Cannot set both OptionsList and CodeName attributes in the CodeArrayTag", 1);
    }
    this.options = options;
  }

  /**
   * Returns a Collection of objects implementing the Mapping interface
   *
   * @return a Collection of objects implementing the Mapping interface
   */
  public Collection getOptions() {
    return options;
  }
}
