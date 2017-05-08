package gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * This custom tag will take an codes table name and get the Collection of CodeAttributes objects from the Codes Table
 * Lookup Framework and will populate them into a table.  The options will be populated in the order they occur in the
 * table.
 *
 * @author Bradley Eilers, April 19, 2002
 */
public class CodesCheckboxesTag
        extends CheckboxesTag {

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
   * Sets the custom codesCheckbox tag attribute: excludeOptions
   *
   * @param options A List containing codes that will be excluded  from the checkbox group.
   */
  public void setExcludeCodes(List options) {
    GrndsTrace.enterScope(TRACE_TAG + ".setExcludeOptions");
    this.excludeCodes = options;
    GrndsTrace.exitScope();
  }

  /**
   * This method will accept the collection of codes that will be defaulted to checked.  The method is called through
   * the iterator attribute on the tag definition.  <prs:codesCheckbox name="city" <b>defaultCodes="<%= myCollection
   * %>"</b> />
   *
   * @param defaultCodes The collection of defaulted codes
   */
  public void setDefaultCodes(List defaultCodes) {
    super.setDefaultValues(defaultCodes);
  }

  public List getDefaultCodes() {
    return super.getDefaultValues();
  }

  /**
   * This method will set the name of the Codes table to be used in creating this list.  The codes table name is passed
   * into the tag as shown in this example: <prs:codesCheckbox name="city" <b>codesTableName="<%= codesTableName %>"</b>
   * />
   *
   * @param codesTableName The name of the codes table used in creating the list.
   */
  public void setCodesTableName(String codesTableName) {
    this.codesTableName = codesTableName;
  }

  public String getCodesTableName() {
    return codesTableName;
  }

  /**
   * Can be set to CodesCheckboxesTag.CODE (default) or CodesCheckboxesTag.DECODE Orders the checkboxes by either the
   * code or decode value
   */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  /**
   * This method creates the HTML output for the option box.  Both an iterator and a name should be set prior to this
   * method executing.
   *
   * @return int A constant value defining whether or not to display the body contained in this tag
   */
  public int doStartTag()
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    List checkboxList = null;
    try {
      if (orderBy.equals(DECODE)) {
        checkboxList = Lookup.getCategoryCollectionSortedByDecode(codesTableName);
      } else {
        checkboxList = Lookup.getCategoryCollection(codesTableName);
      }
      //Codes Table End Dating Enhancement
      //Loop through all of DefaultCodes and if not in codes table, check if in Expired codes.
//      Iterator defaultCodes = this.getDefaultCodes().iterator();
//      while( defaultCodes.hasNext() )
//      {

      //Always verify that the specified values are in the list of options
      //If not, use the expired codes or set value as both value and display.
      //Loop through defaultCodes
      if (this.getDefaultCodes() != null) {
        Iterator defaultCodesIterator = this.getDefaultCodes().iterator();

        //Create List of only codes from CodeAttributes for comparison against later
        List codeList = new ArrayList();
        Iterator checkboxListIterator = checkboxList.iterator();
        while (checkboxListIterator.hasNext()) {
          codeList.add(((CodeAttributes) checkboxListIterator.next()).getCode());
        }

        //Loop through all the defaultCodes
        while (defaultCodesIterator.hasNext()) {
          String keyString = (String) defaultCodesIterator.next();
          // If the code is not already in the checkbox list, see if it should be added.
          if (StringHelper.isValid(keyString) && (!codeList.contains(keyString))) {
            String value = null;
            String display = null;

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
                value = keyString;
                display = valueString;
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
              checkboxList.add(new CodeAttributes(this.codesTableName, value, display));
            } //end check if( value != null )
          } //end check if( StringHelper.isValid( keyString ) && ( !this.hasOptionCode( keyString ) ) )
        } //end while loop on options
      } //end check on selected options != null

//      }

    }
    catch (Throwable e) {
      throw new JspException
              ("Exception generating CodesCheckboxes from CodesCheckboxesTag, " +
               "see details: \n" + e.getMessage(),
               e);
    }

    // If the user has included a list of codes to be excluded, try to create
    //  a new instance of CodeAttributes from the code and the lookup, then
    //  remove that code/decode from the checkboxList list.
    if (this.excludeCodes != null && this.codesTableName != null) {
      Iterator excludeCodesIterator = this.excludeCodes.iterator();
      while (excludeCodesIterator.hasNext()) {
        // The List item is the code String.
        String excludedCode = (String) excludeCodesIterator.next();
        // Get the decode String through Lookup on the codesTableName
        String excludedDecode = Lookup.simpleDecodeSafe(this.codesTableName, excludedCode);
        // If a decode is returned, remove the pair from checkboxList.
        if (StringHelper.isValid(excludedDecode)) {
          CodeAttributes removeCodeDecode = new CodeAttributes(this.codesTableName, excludedCode, excludedDecode);
          checkboxList.remove(removeCodeDecode);
        }
      }
    }

    setCheckboxList(checkboxList);

    int returnValue = super.doStartTag();
    GrndsTrace.exitScope();
    return returnValue;
  }

  public static final String CODE = "code";
  public static final String DECODE = "decode";
  private static final String TRACE_TAG = "CodesCheckboxesTag";
  private String codesTableName;
  private String orderBy = CODE;
  private List excludeCodes = null;
  private boolean overrideDisplayBadCodes = false;
}