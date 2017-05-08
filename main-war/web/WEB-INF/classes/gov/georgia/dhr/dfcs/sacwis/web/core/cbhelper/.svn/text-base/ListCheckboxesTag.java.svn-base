package gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper;

import java.util.List;

import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

/**
 * This custom tag will take an codes table name and get the Collection of CodeAttributes objects from the Codes Table
 * Lookup Framework and will populate them into a table.  The options will be populated in the order they occur in the
 * table.
 *
 * @author Bradley Eilers, April 19, 2002
 */
public class ListCheckboxesTag
        extends CheckboxesTag {
  /**
   * This method will accept the collection of codes that will be defaulted to checked.  The method is called through
   * the iterator attribute on the tag definition.  <prs:listCheckbox name="city" <b>defaultCodes="<%= myCollection
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
   * into the tag as shown in this example: <prs:listCheckbox name="city" <b>codesTableName="<%= codesTableName %>"</b>
   * />
   *
   * @param codesTableName The name of the codes table used in creating the list.
   */
  public void setCodesList(List codesList) {
    this.codesList = codesList;
  }

  public List getCodesList() {
    return codesList;
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

    super.setCheckboxList(this.codesList);

    int returnValue = super.doStartTag();
    GrndsTrace.exitScope();
    return returnValue;
  }

  private static final String TRACE_TAG = "ListCheckboxesTag";
  private List codesList;
}
