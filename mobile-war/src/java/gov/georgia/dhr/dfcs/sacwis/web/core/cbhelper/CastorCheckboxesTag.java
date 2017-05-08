package gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper;

// java classes

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.BaseFormElementTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag;

/**
 * This custom tag will take an enumeration of castor defined Java Beans, create an array of checkboxes based on those
 * beans, and then populate them into a table. The options will be populated in the order they occur in the table.
 *
 * @author Bradley Eilers, April 19, 2002
 */
public class CastorCheckboxesTag extends BaseFormElementTag {
  /**
   * This method will accept the base name of the checkbox.  The method is called through the name attribute on the tag
   * definition.  The name is set to "city" in this example: <impact:castorCheckbox <b>name="baseCheckboxName"</b> ...
   * />
   *
   * @param name The name to define for the resulting checkbox
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method will accept the List of codes that will be defaulted to checked. The method is called through the
   * iterator attribute on the tag definition. <impact:castorCheckbox name="baseCheckboxName" <b>defaultCodes="<%=
   * myCollection %>"</b> />
   *
   * @param checkedValues Contains strings of the name of the values to be checked. These strings should match strings
   *                      in the property named by valuePropertyName
   */
  public void setCheckedValues(List checkedValues) {
    this.checkedValues = checkedValues;
  }

  /**
   * This method will set the name of the Castor Class to be used in creating this list. The Castor Class name is passed
   * into the tag as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b> castorClassName="<%=
   * castorClassName %>"</b> />
   *
   * @deprecated
   */
  public void setCastorClassName(String castorClassName) {
  }

  /**
   * This method will set the name of the Label Property to be used in creating this list. The Label Property name is
   * passed into the tag as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b>
   * labelPropertyName="<%= labelPropertyName %>"</b> />
   */
  public void setLabelPropertyName(String labelPropertyName) {
    this.labelPropertyName = labelPropertyName;
  }

  /**
   * This method will set the name of the Value Property to be used in creating this list. The Value Property name is
   * passed into the tag as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b>
   * valuePropertyName="<%= valuePropertyName %>"</b> />
   */
  public void setValuePropertyName(String valuePropertyName) {
    this.valuePropertyName = valuePropertyName;
  }

  /**
   * This method will set the Castor Enumeration to be used in creating this list. The Castor Enumeration is passed into
   * the tag as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b> castorEnum="<%= castorEnum
   * %>"</b> />
   */
  public void setCastorEnum(Enumeration castorEnum) {
    this.castorEnum = castorEnum;
  }

  /**
   * This method will set the number of columns for this list of checkboxes The number of columns is passed into the tag
   * as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b>columns="2"</b> />
   *
   * @param columns The name of the codes table used in creating the list.
   */
  public void setColumns(int columns) {
    this.columns = columns;
  }

  /**
   * This method will set whether or not rules (lines) separeate the rows of checkboxes. The isRuled parameter is passed
   * into the tag as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b>isRuled="true"</b> />
   *
   * @param isRuled Whether or not to put rules (lines) between the rows.
   */
  public void setIsRuled(boolean isRuled) {
    this.isRuled = isRuled;
  }

  /**
   * This method will set whether or not rules (lines) separeate the rows of checkboxes. The isRuled parameter is passed
   * into the tag as shown in this example: <impact:castorCheckbox name="baseCheckboxName" <b>isRuled="true"</b> />
   */
  public void setIsHorizontal(boolean isHorizontal) {
    this.isHorizontal = isHorizontal;
  }

  /**
   * This method creates the HTML output for the option box.  Both an iterator and a name should be set prior to this
   * method executing.
   *
   * @return int A constant value defining whether or not to display the body contained in this tag
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    JspWriter out = pageContext.getOut();
    FormTag parent = getParentFormTag(pageContext.getRequest(), this);

    try {
      if (!super.isEditable()) {
        super.setAttribute("disabled", "");
      }
      //Only remove the attribute if it is Editable and Disabled was not explicity set.
      else if (!super.getDisabledInd()) {
        super.removeAttribute("disabled");
      }
      out.println(CheckboxHelper.createCheckBoxGroupHtml(castorEnum, name, checkedValues, labelPropertyName,
                                                         valuePropertyName, columns, isRuled, isHorizontal,
                                                         parent.getName(), super.getAttributes(), parent,
                                                         this.pageContext.getRequest().getParameterMap()));
    }
    catch (IOException e) {
      throw new JspException(
              "Exception generating CodesCheckboxes from CodesCheckboxesTag, see details: \n" + e.getMessage(), e);
    }
    catch (CheckboxHelperException che) {
      throw new JspException(
              "Exception generating CodesCheckboxes from CodesCheckboxesTag, see details: \n" + che.getMessage(), che);
    }

    GrndsTrace.exitScope();
    return super.SKIP_BODY;
  }

  /** Don't need to use this, but need the other methods in the superclass. */
  protected void createInput() throws JspException {
  }

  /** static constants */
  private static final String TRACE_TAG = "CodesCheckboxesTag"; //for tracing

  /** instance variables */
  private String name;
  private List checkedValues;
  private int columns;
  private boolean isRuled = false;
  private boolean isHorizontal = false;
  private Enumeration castorEnum;
  private String labelPropertyName;
  private String valuePropertyName;
}


