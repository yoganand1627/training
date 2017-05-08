package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import org.apache.commons.lang.StringEscapeUtils;

/* Change History:
  Date        User              Description
  --------    ----------------  --------------------------------------------------
  03/28/2005  gerryc            SIR 23328 - changed the create opening html method
                                so that if an option is excluded, yet that option
                                is the saved value, that value will still display
                                in the list.
*/

/**
 * The SelectTag Class replaces the standard HTML select and options tags to perfom validation of each form input upon
 * submission.
 *
 * @author Kelly J. Mayes
 */
public class SelectTag extends BaseFormElementTag {
  /** Default Constructor. */
  public SelectTag() {
    super();
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
//BEE    this.options = null;
//BEE    this.selectedOptions = null;
//BEE    this.bBlankValue = true;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom select tag attribute: overrideDisplayBadCodes
   *
   * @param overrideDisplayBadCodes A boolean indicating whether or not to override display of bad codes.  By default,
   *                                they are displayed, so this should only be called when the override is set to true.
   *                                Otherwise the call is redundant.
   */
  public void setOverrideDisplayBadCodes(boolean overrideDisplayBadCodes) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOverrideDisplayBadCodes");
    this.overrideDisplayBadCodes = overrideDisplayBadCodes;
    GrndsTrace.exitScope();
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
   * Sets whether to use codes or decodes for the values of the generated option tags.
   *
   * @param valueType A String that takes one of two values, "CODES" or "DECODES"; these constants are defined in this
   *                  class.
   */
  public void setValueType(int valueType) {
    GrndsTrace.enterScope(TRACE_TAG + ".setExcludeOptions");
    this.valueTypeFlag = valueType;
    GrndsTrace.exitScope();
  }

  /**
   * Sets whether to use codes or decodes for the content of the generated option tags.
   *
   * @param contentType A String that takes one of two values, "CODES" or "DECODES"; these constants are defined in this
   *                    class.
   */
  public void setContentType(int contentType) {
    GrndsTrace.enterScope(TRACE_TAG + ".setExcludeOptions");
    this.contentTypeFlag = contentType;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom select tag attribute: options
   *
   * @param options A Collection containing key-value pairs that correspond to the value and display strings of the
   *                options.
   */
  public void setOptions(Collection options) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOptions");
    this.options = options;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom select tag attribute: options
   *
   * @param codesTableName The name of a codes table.  The values will be set into the options for this tag.
   */
  public void setCodesTable(String codesTableName)
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".setCodesTable");
    //Get codes table values and put into options.
    Collection codesOptions = null;
    if (codesTableName != null) {
      try {
        if (orderBy.equals(DECODE_ORDERBY)) {
          codesOptions = Lookup.getCategoryCollectionSortedByDecode(codesTableName);
        } else {
          codesOptions = Lookup.getCategoryCollection(codesTableName);
        }
      }
      catch (LookupException le) {
        GrndsTrace.msg(TRACE_TAG, 7, "Unable to get data from Codes Table - Throwing exception");
        throw new JspException("Unable to get data from Codes Table", le);
      }
    }

    this.codesTableName = codesTableName;
    this.options = codesOptions;
    GrndsTrace.exitScope( /*options*/);
  }

  /**
   * Can be set to SelectTag.CODE_ORDERBY (default) or SelectTag.DECODE_ORDERBY Orders the select options by either the
   * code or decode value
   */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public void setBlankValue(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setBlankValue");
    if ("true".equalsIgnoreCase(str)) {
      this.bBlankValue = true;
    } else {
      this.bBlankValue = false;
    }
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom select tag attribute: multiple
   *
   * @param str True or False
   */
  public void setMultiple(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setMultiple");
    if ("true".equalsIgnoreCase(str)) {
      super.setAttribute("multiple", "");
    } else {
      super.removeAttribute("multiple");
    }
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML input tag attribute: size See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str Initial width of the input
   */
  public void setSize(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setSize");
    super.setAttribute("size", str);
    GrndsTrace.exitScope();
  }

  /**
   * Writes the HTMLfor this tag.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag()
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    JspWriter out = super.pageContext.getOut();

    try {
      this.createInput();
      out.print(this.createOpeningHtml());
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }
    catch (JspException jspe) {
      throw new JspException(jspe.getMessage(), jspe);
    }

    GrndsTrace.exitScope();
    //This tag should have no body
    return BaseFormElementTag.SKIP_BODY;
  }

  /**
   * Creates the opening HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml()
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml");

    StringBuffer buffer = new StringBuffer();
    buffer.append(super.createLabelHtml());

    //If the tag's editable mode is compatible with the parent form tag's page mode, dump html...
    /*BEE - If we later change view mode to display as text only, use this code
      if (super.isEditable())
      {
    */
    //For now, view mode will simply have the select box disabled.
    if (!super.isEditable()) {
      super.setAttribute("disabled", "");
    }
    //Only remove the attribute if it is Editable and Disabled was not explicity set.
    else if (!super.getDisabledInd()) {
      super.removeAttribute("disabled");
    }

    buffer.append("<select name=\"");
    buffer.append(super.getName());
    //If field is disabled, field will not be submitted.  Append disabled to
    //field name and create hidden field with real value
    if (getAttribute("disabled") != null) {
      buffer.append("_Disabled");
    } else {
      super.removeAttribute("disabled");
    }

    buffer.append("\"");
    buffer.append(" id=\"");
    buffer.append(super.getId());
    buffer.append("\"");
    buffer.append(super.listAttributes());
    buffer.append(">");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    // insert a blank value as the first option of the select box if specified
    if (bBlankValue) {
      buffer.append("<option value=\"\"");
      // if we have no other values selected by default, select this blank entry by default
      if (this.selectedOptions == null || (this.selectedOptions.contains(""))) {
        buffer.append(" selected");
      }
      buffer.append("></option>");
      buffer.append(ArchitectureConstants.LINE_BREAK);
    }

    //create the list of options
    if (this.options != null) {
      Iterator iterator = this.options.iterator();

      //Loop through all of the options, creating html for each
      while (iterator.hasNext()) {
        Mapping entry = (Mapping) iterator.next();
        String keyString = entry.getKey();
        String valueString = entry.getValue();

        //Default to content=DECODES, value=CODES
        String display = getDisplayString(keyString, valueString);
        String value = getValueString(keyString, valueString);

        // always check for the code, not the decode
        if (excludeOptions == null || (excludeOptions != null && !excludeOptions.contains(keyString))) {
          buffer.append(this.createOptionHtml(display, value));
          buffer.append(ArchitectureConstants.LINE_BREAK);
        }
      }
    }

    //Always verify that the specified value is one of the options
    //If it is not, set value as both value and display.
    //Loop through selectedOptions - usually just one.
    if (this.selectedOptions != null) {
      Iterator selectedOptionsIterator = this.selectedOptions.iterator();
      while (selectedOptionsIterator.hasNext()) {
        String keyString = (String) selectedOptionsIterator.next();

        String value = null;
        String display = null;

        // If the code is already in the options list, it can be skipped.
        if (StringHelper.isValid(keyString) && (!this.hasOptionCode(keyString))) {
          //If a codes table was specified, check the expired options
          if (this.codesTableName != null) {
            // If the code is in the expired list, it wouldn't currently be
            // in the options list, so we need to add it.
            if (Lookup.isValidExpiredCode(this.codesTableName, keyString)) {
              // Lookup.simpleDecodeSafe will find either current codes OR expired
              // codes, so a simple call to it will get the expired code here if
              // there is one.
              String valueString = Lookup.simpleDecodeSafe(this.codesTableName, keyString);

              //Default to content=DECODES, value=CODES
              value = getValueString(keyString, valueString);
              display = getDisplayString(keyString, valueString);
            }
          }

          //if value was not already set and OverrideDisplayBadCode is false
          if (value == null && !this.overrideDisplayBadCodes) {
            //Set value and display to the code
            value = keyString;
            display = keyString;
          }

          //If value is not null
          if (value != null) {
            //Append the new option to the html output buffer
            buffer.append(this.createOptionHtml(display, value));
            buffer.append(ArchitectureConstants.LINE_BREAK);
          } //end check if( value != null )
        } //end check if( StringHelper.isValid( keyString ) && ( !this.hasOptionCode( keyString ) ) )

        // SIR 23328 - added additional condition not to add back the excluded
        // option if it is the selected value
        if (excludeOptions != null && excludeOptions.contains(keyString)) {
          String valueString = Lookup.simpleDecodeSafe(this.codesTableName, keyString);

          //Default to content=DECODES, value=CODES
          display = getDisplayString(keyString, valueString);
          value = getValueString(keyString, valueString);

          //If value is not null
          if (value != null) {
            //Append the new option to the html output buffer
            buffer.append(this.createOptionHtml(display, value));
            buffer.append(ArchitectureConstants.LINE_BREAK);
          }
        }//end 23328

      } //end while loop on options
    } //end check on selected options != null

    buffer.append("</select>");
    /*BEE - If we later change view mode to display as text only, use this code
      }
      else //display in view mode
      if (this.selectedOptions != null)
      {
      GrndsTrace.msg(TRACE_TAG, 10, "7");
      Iterator iterator = this.selectedOptions.iterator();

      while (iterator.hasNext())
      {
      String selectedValue = (String) iterator.next();
      super.value = selectedValue;
      buffer.append(this.getDisplay(selectedValue));
      buffer.append(super.createViewModeHiddenField());
      }
      }
    */
    //BEE - No reason to clear the ID
    //super.setId("");
    //BEE - For view mode with disabled fields, create hidden field to hold value
    if (getAttribute("disabled") != null) {
      buffer.append(super.createViewModeHiddenField());
    }

    GrndsTrace.exitScope();

    return buffer.toString();
  }

  private String getDisplayString(String keyString, String valueString) {
    String display = valueString;

    if (this.contentTypeFlag != DECODES) {
      //Set display to either CODE(keyString) or CODE DECODE
      display = (this.contentTypeFlag == CODES) ? keyString : keyString + " " + valueString;
    }

    return display;
  }

  private String getValueString(String keyString, String valueString) {
    String value = keyString;

    //If value type is not CODES
    if (this.valueTypeFlag != CODES) {
      //Set the value to either CODE(keystring) or CODE DECODE
      value = (this.valueTypeFlag == DECODES) ? valueString : keyString + " " + valueString;
    }

    return value;
  }

  private boolean hasOptionCode(String value) {
    GrndsTrace.enterScope(TRACE_TAG + ".hasOptionCode");

    if (this.options != null) {
      Iterator it1 = this.options.iterator();
      while (it1.hasNext()) {
        Mapping en = (Mapping) it1.next();
        String ks = en.getKey();

        if (ks.equals(value)) {
          return true;
        }
      }
    }

    GrndsTrace.exitScope( /*options*/);

    return false;
  }

  /**
   * creates the html for an option in the select list.
   *
   * @param display the string to display in the list
   * @param value   the value for that option
   */
  protected String createOptionHtml(String display,
                                    String value) {
    StringBuffer buffer = new StringBuffer("<option ");

    display = StringEscapeUtils.escapeHtml(display);
    value = StringEscapeUtils.escapeHtml(value);

    if (this.selectedOptions != null &&
        this.selectedOptions.contains(value)) {
      buffer.append(" selected ");
    }
    buffer.append("value=\"");
    buffer.append(value);
    buffer.append("\">");
    buffer.append(display);
    buffer.append("</option>");

    return (buffer.toString());
  }

  /**
   * Creates the InputValidation object to hold all information about this drop down and adds it to the parent form.
   * Overrides BaseFormElement.createInput
   *
   * @throws JspException if anything goes wrong
   */
  protected void createInput()
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createInput");

    FormTag parent = getParentFormTag(pageContext.getRequest(), this);

    //check that parent not null
    if (parent == null) {
      throw new JspException("Select Tag may only be used within a Form Tag");
    }
    InputValidation input = new InputValidation(super.getName(), super.getConstraint(), super.getRequiredBoolean());

    ServletRequest request = this.pageContext.getRequest();
    String[] httpValues = request.getParameterValues(super.getName());
    List parentValue = parent.getInputValues(super.getName());
    List existingParameter = null;

    if (httpValues != null) {
      existingParameter = Arrays.asList(httpValues);
    }
    //DWW - 1/17/03 - If conversation error, redisplay existing
    //DWW - 3/06/03 - removed the condition that checks that the value is the same
    //String conversationError = (String)request.getAttribute( ServerSideValidationUtility.FORM_VALIDATION_CONVERSATION_ERROR );
    //boolean bConversationError = ( conversationError != null && conversationError.equals( "true" ) );

    if (existingParameter != null &&
        //existingParameter.equals( parentValue ) &&
        parent.getBWidgetsRefreshFromRequest()) {
      this.selectedOptions = existingParameter;
      GrndsTrace.msg(TRACE_TAG, 7,
                     "using previously entered parameter " + super.getName() + "=" + this.selectedOptions);
    } else {
      //MDM 07/08/2003, moved from setValue to here
      List selectedValue = new ArrayList();
      if (StringHelper.isValid(super.getValue())) {
        selectedValue.add(super.getValue());
      } else {
        selectedValue.add("");
      }
      this.selectedOptions = selectedValue;
    }

    input.setValue(this.selectedOptions);
    parent.addInput(input);

    GrndsTrace.exitScope();
  }

  /**
   * gets the display name from the options list given a String value
   *
   * @param value
   * @return display
   */
  String getDisplay(String value) {
    String display = "";

    if (this.options != null) {
      Iterator iterator = this.options.iterator();

      while (iterator.hasNext()) {
        Mapping entry = (Mapping) iterator.next();

        if (entry.getKey().equals(value)) {
          display = entry.getValue();
          break;
        }
      }
    }
    return display;
  }

  private boolean overrideDisplayBadCodes = false;
  public static final int CODES = 1;
  public static final int DECODES = 2;
  public static final int CODES_DECODES = 3;
  private static final String TRACE_TAG = "SelectTag";
  public static final String CODE_ORDERBY = "code";
  public static final String DECODE_ORDERBY = "decode";
  private Collection excludeOptions = null;
  private Collection options = null;
  private Collection selectedOptions = null;
  private boolean bBlankValue = true;
  public int valueTypeFlag = 1;
  public int contentTypeFlag = 2;
  private String codesTableName;
  private String orderBy = CODE_ORDERBY;
}
