package gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.BaseFormElementTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag;

public class CheckboxesTag
        extends BaseFormElementTag {
  /**
   * This method will accept the base name of the checkbox.  The method is called through the name attribute on the tag
   * definition.  The name is set to "city" in this example: <prs:codesCheckbox <b>name="baseName"</b> ... />
   *
   * @param name The name to define for the resulting checkbox
   */
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  /**
   * This method will accept the collection of codes that will be defaulted to checked.  The method is called through
   * the iterator attribute on the tag definition.  <prs:codesCheckbox name="city" <b>defaultValues="<%= myCollection
   * %>"</b> />
   *
   * @param defaultValues The collection of defaulted codes
   */
  public void setDefaultValues(List defaultValues) {
    this.defaultValues = defaultValues;
  }

  public List getDefaultValues() {
    return defaultValues;
  }

  /**
   * This method will set the number of columns for this list of checkboxes The number of columns is passed into the tag
   * as shown in this example: <prs:codesCheckbox name="city" <b>columns="2"</b> />
   *
   * @param columns The name of the codes table used in creating the list.
   */
  public void setColumns(int columns) {
    this.columns = columns;
  }

  public int getColumns() {
    return columns;
  }

  /**
   * This method will set whether or not rules (lines) separeate the rows of checkboxes.  The isRuled parameter is
   * passed into the tag as shown in this example: <prs:codesCheckbox name="city" <b>isRuled="true"</b> />
   *
   * @param isRuled Whether or not to put rules (lines) between the rows.
   */
  public void setIsRuled(boolean isRuled) {
    this.isRuled = isRuled;
  }

  public boolean isRuled() {
    return isRuled;
  }

  /**
   * This method will set whether or not rules (lines) separeate the rows of checkboxes.  The isRuled parameter is
   * passed into the tag as shown in this example: <prs:codesCheckbox name="city" <b>isRuled="true"</b> />
   *
   * @param isHorizontal Whether or not to put rules (lines) between the rows.
   */
  public void setIsHorizontal(boolean isHorizontal) {
    this.isHorizontal = isHorizontal;
  }

  public boolean isHorizontal() {
    return isHorizontal;
  }

  /**
   *
   */
  public void setCheckboxList(List checkboxList) {
    this.checkboxList = checkboxList;
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

    JspWriter out = pageContext.getOut();
    FormTag parent = getParentFormTag(pageContext.getRequest(), this);

    if (!super.isEditable()) {
      super.setAttribute("disabled", "");
    }
    //Only remove the attribute if it is Editable and Disabled was not explicity set.
    else if (!super.getDisabledInd()) {
      super.removeAttribute("disabled");
    }
    try {
      out.println(CheckboxHelper.createCheckBoxGroupHtml(defaultValues,
                                                         name,
                                                         checkboxList,
                                                         columns,
                                                         isRuled,
                                                         isHorizontal,
                                                         parent.getName(),
                                                         super.getAttributes(),
                                                         parent,
                                                         this.pageContext.getRequest().getParameterMap()));
    }
    catch (Exception e) {
      throw new JspException
              ("Exception generating Checkboxes, " +
               "see details: \n" + e.getMessage(),
               e);
    }

    GrndsTrace.exitScope();
    return super.SKIP_BODY;
  }

  //Don't need to use this, but need the other methods in the superclass.
  protected void createInput()
          throws JspException {
  }

  private static final String TRACE_TAG = "CheckboxesTag";
  private String name;
  private List defaultValues;
  private int columns;
  private boolean isRuled = false;
  private boolean isHorizontal = false;
  private List checkboxList = null;
}
