package gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.BaseHtmlTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * The CheckboxHelper is used to aid developers in working with checkboxes. It both helps developers create html for a
 * list of checkboxes and get a list of the checked values.
 *
 * @author Bradley Eilers,    April 27, 2002
 * @version :    1.1
 */
public class CheckboxHelper {
  protected static final String WIDGET_NAME = "";
  private static final String TRACE_TAG = "CheckboxHelper";

  /**
   * The action code for a checkbox that was checked, and is now unchecked. Is equivalent to
   * WtcHelper.REQ_FUNC_CD_DELETE, which is equal to "D".
   */
  public static final String DELETED = ServiceConstants.REQ_FUNC_CD_DELETE;
  /**
   * The action code for a checkbox that was unchecked, and is now checked. Is equivalent to WtcHelper.REQ_FUNC_CD_ADD,
   * which is equal to "A".
   */
  public static final String ADDED = ServiceConstants.REQ_FUNC_CD_ADD;
  /**
   * The action code for a checkbox whose status is unchanged. Is equivalent to WtcHelper.REQ_FUNC_CD_NO_ACTION, which
   * is equal to " ".
   */
  public static final String NO_ACTION = ServiceConstants.REQ_FUNC_CD_NO_ACTION;

  /** Private constructor to discourage instantiation */
  protected CheckboxHelper() {
  }

  /**
   * Used as static method in conversation action to get a collection of values of the checked checkboxes. So, for
   * example, lets say you have a series of checkboxes whose name and value attributes are as follows: <ul> <li> #1:
   * name="cbx_1" value="AA" </li> <li> #2: name="cbx_2" value="BB" </li> <li> #3: name="cbx_3" value="CC" </li> <li>
   * #4: name="cbx_4" value="DD" </li> </ul> If the user checks checkboxes cbx_1 and cbx_3, then the following code:
   * <p/>
   * String[] checkedValues = CheckboxHelper.getCheckedValues( request, "cbx_" ); </p> will return the String array
   * checked values with the following values:
   * <p/>
   * { "AA", "CC" } </p>
   *
   * @param request      The request in which the checkbox values have been submitted
   * @param checkboxName The stem of the name used to identify the checkboxes in the HTML/JSP code. For instance, if
   *                     your HTML code has a group of checkboxes named cbx_0, cbx_1, cbx_2, etc., then the stem name is
   *                     "cbx_", and that would be the value of this field
   * @return An array of Strings, where the strings are the value in the "value" attributes of the checkedboxes which
   *         are checked.
   */
  public static String[] getCheckedValues(HttpServletRequest request, String checkboxName) {
    /*        HashMap map = new HashMap();

            for( Enumeration e = request.getParameterNames(); e.hasMoreElements(); )
            {
                String parmName = (String)e.nextElement();
                map.put( parmName, request.getParameter( parmName ) );
            }
            return getCheckedValues( map, checkboxName );
    */
    return getCheckedValues(request.getParameterMap(), checkboxName);
  }

  /**
   * This method is not typically used from a conversation, but provides the actual implementation of the method. Gets a
   * list of the checked values from a group of checkboxes.
   * <p/>
   * public static String[] getCheckedValues(HttpServletRequest request, String checkboxName) </p> So, for example, lets
   * say you have a series of checkboxes whose name and value attributes are as follows: <ul> <li> #1: name="cbx_0"
   * value="AA" </li> <li> #2: name="cbx_1" value="BB" </li> <li> #3: name="cbx_2" value="CC" </li> <li> #4:
   * name="cbx_3" value="DD" </li> </ul> If the user checks checkboxes cbx_1 and cbx_3, then the following code:
   * <p/>
   * String[] checkedValues = CheckboxHelper.getCheckedValues( request, "cbx_" ); </p> will return the String array
   * checked values with the following values:
   * <p/>
   * { "BB", "DD" } </p>
   *
   * @param map          a Map of all the parameters in the request in which the checkbox values have been submitted.
   *                     Generally, this map is obtained only by calling request.getParameterMap();
   * @param checkboxName The stem of the name used to identify the checkboxes in the HTML/JSP code. For instance, if
   *                     your HTML code has a group of checkboxes named cbx_0, cbx_1, cbx_2, etc., then the stem name is
   *                     "cbx_", and that would be the value of this field
   * @return An array of Strings, where the strings are the value in the "value" attributes of the checkedboxes which
   *         are checked.
   */
  public static String[] getCheckedValues(Map map, String checkboxName) {
    GrndsTrace.enterScope(TRACE_TAG + ".getCheckedValues(" + checkboxName + ")");
    List<String> list = new ArrayList<String>();

    int checkboxNameLength = checkboxName.length();
    String parameterName;

    //Loop through the parameter names looking for specified checkbox
    for (Iterator i = map.keySet().iterator(); i.hasNext();) {
      parameterName = (String) i.next();
      if (parameterName == null) {
        continue;
      }

      //Do a quick compare on length to rule out most params AND then check the actual name.
      if ((parameterName.length() >= checkboxNameLength) &&
          parameterName.startsWith(checkboxName) &&
          !parameterName.endsWith("_changed")) {
        String existingParam = getExistingParameter(map, parameterName);
        if (StringHelper.isValid(existingParam)) {
          list.add(existingParam);
        }
      }
    }

    GrndsTrace.exitScope( /*list + ":" + list.size()*/);
    return list.toArray(new String[list.size()]);
  }

  /**
   * Gets a "Y" or "N" based on whether a given single checkbox is checked or not. For example, if a checkbox named
   * cbxFoo was checked on the JSP page, the following statement:
   * <p/>
   * String foo = getCheckboxValue(request, "cbxFoo"); </p> would return foo = "Y". If cbxFoo was unchecked, foo would
   * be equal to "N". "Y" and "N" values are used instead of true and false, because the IMPACT servers are based on
   * CAPS servers, which often used Y or N to indicate true or false
   *
   * @param request      the request in which the checkbox's value is stored
   * @param checkboxName the value of the name attribute for the checkbox in the HTML/JSP page. This is the name by
   *                     which the parameter is stored in the request.
   * @return Y if the named checkbox is checked (that is, it has a value in the request), or N if it is not checked
   *         (that is, a getParameter from the request for this checkboxName returns null)
   */
  public static String getCheckboxValue(HttpServletRequest request, String checkboxName) {
    String changedString = request.getParameter(checkboxName + "_changed");
    String checkedString = "N";
    if (changedString != null) {
      if (changedString.startsWith("A") || changedString.startsWith(" Y")) {
        checkedString = "Y";
      }
    }
    return checkedString;
  }

  /**
   * Creates html for a table of checkboxes based on a Castor Array. This code is used by the class
   * gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag to do the actual generation of the HTML.
   *
   * @param castor_ARRAY      a castor class that represents an array of castor objects. these castor classes will
   *                          typically be of the naming pattern ROWCXXX##SOG##_ARRAY, though there are deviations from
   *                          this pattern.
   * @param checkboxName      the stem of the name of the checkbox to be generated. Generated checkboxes will use this
   *                          stem plus an ascending number for their name. For example, if this parameter is equal to
   *                          "cbxFoo", the "name" attribute of the checkboxes generated will be cbxFoo1, cbxFoo2,
   *                          cbxFoo3, etc. Note, checkbox numbers begin with 1, NOT 0.
   * @param checkedValues     a Collection of the values that need to be defaulted as checked. This Collection contains
   *                          String objects.
   * @param labelPropertyName the name of a property in the castor class in the castor_ARRAY. The property named by this
   *                          parameter will be used to create the label mapping for the checkbox. So, for instance, if
   *                          you pass "szNmPerson" to this parameter, the checkboxes generated by this call will be
   *                          labelled according to the values gotten by calling getSzNamePerson() on the objects in the
   *                          castor_ARRAY passed to the method.
   * @param valuePropertyName the name of a value property in the castor class in the castor_ARRAY. The property named
   *                          by this parameter will be used in the value mapping of the checkbox. So, for example, if
   *                          you pass "szCdRace" to this parameter, the "value" attribute of the checkbox widget will
   *                          be populated by calling getSzCdRace() on the objects in the castor_ARRAY passed to this
   *                          method.
   * @param columns           the number of columns the checkboxes should be displayed in
   * @param isRuled           whether or not to put rules(lines) between each row of checkboxes
   * @param isHorizontal      isHorizontal whether the items should flow horizontally or vertically
   * @return a string of html for the checkboxes
   * @throws CheckboxHelperException if the castor_ARRAY, labelPropertyName, valuePropertyName, are incorrect and
   *                                 generate intropsection exceptions.
   */
  public static String createCheckBoxGroupHtml(XmlValueBean castor_ARRAY, String checkboxName, List checkedValues,
                                               String labelPropertyName, String valuePropertyName, int columns,
                                               boolean isRuled, boolean isHorizontal, String formName,
                                               Map<Object, Object> htmlAttributes, FormTag parent, Map parameters)
          throws CheckboxHelperException {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createCheckBoxGroupHtml - Castor array");

    // start the method trace
    performanceTrace.enterScope();
    try {
      List boxList = CastorArrayHelper.getOptionsVector(castor_ARRAY, labelPropertyName, valuePropertyName);

      String output = createCheckBoxGroupHtml(checkedValues, checkboxName, boxList, columns, isRuled, isHorizontal,
                                              formName, htmlAttributes, parent, parameters);

      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
      return output;
    } catch (IntrospectionException e) {
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
      throw new CheckboxHelperException("createCheckBoxGroup", e);
    }
  }

  /**
   * The class does the actual implementation of creating the HTML code for the checkboxes for a castor class, and is
   * called by
   *
   * @param castorEnum        an enumeration returned from an enumerateROWCXXX##SOG## method.  That is, an enumeration
   *                          of castor classes
   * @param checkboxName      The name of the checkboxes to generate though there are deviations from this form
   * @param checkedValues     Contains strings of the name of the values to be checked. These strings should match
   *                          strings in the property named by valuePropertyName
   * @param labelPropertyName this is the name of the property in the class contained in the enumeration that should be
   *                          used to generate the labels of the checkboxes
   * @param valuePropertyName this is the name of the property in the class in the enumeration that should be used to
   *                          generate the values of the checkboxes
   * @param columns           parameter for createCheckBoxGroupHtml
   * @param isRuled           parameter for createCheckBoxGroupHtml
   * @param isHorizontal      parameter for createCheckBoxGroupHtml
   * @return The HTML code for a group of checkboxes
   * @throws CheckboxHelperException -
   */
  public static String createCheckBoxGroupHtml(Enumeration castorEnum, String checkboxName, List checkedValues,
                                               String labelPropertyName, String valuePropertyName, int columns,
                                               boolean isRuled, boolean isHorizontal, String formName,
                                               Map<Object, Object> htmlAttributes, FormTag parent, Map parameters)
          throws CheckboxHelperException {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createCheckBoxGroupHtml - Enumeration");

    // start the method trace
    performanceTrace.enterScope();
    try {
      List boxList = CastorArrayHelper.getOptionsVector(castorEnum, labelPropertyName, valuePropertyName);
      String output = createCheckBoxGroupHtml(checkedValues, checkboxName, boxList, columns, isRuled, isHorizontal,
                                              formName, htmlAttributes, parent, parameters);

      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
      return output;
    } catch (IntrospectionException e) {
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
      throw new CheckboxHelperException("createCheckBoxGroup", e);
    }
  }

  /**
   * Creates html for a table of checkboxes based on a Codes Table. This method is used to actually generate the HTML
   * code for gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag.
   *
   * @param checkedValues a collection of the values that need to be defaulted as checked.
   * @param checkboxName  the base name of the checkbox that will be created
   * @param columns       the number of columns the checkboxes should be displayed in
   * @param isRuled       whether or not to put rules(lines) between each row of checkboxes
   * @param isHorizontal  whether the items should flow horizontally or vertically
   * @return a string of html for the checkboxes
   * @throws CheckboxHelperException if the castor_ARRAY, labelPropertyName, valuePropertyName, are incorrect and
   *                                 generate intropsection exceptions.
   */
  public static String createCheckBoxGroupHtml(List checkedValues, String checkboxName, List boxList, int columns,
                                               boolean isRuled, boolean isHorizontal, String formName,
                                               Map<Object, Object> htmlAttributes, FormTag parent, Map parameters)
          throws CheckboxHelperException {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createCheckBoxGroupHtml - List");

    // start the method trace
    performanceTrace.enterScope();

    //create buffer with a table
    StringBuffer buffer = new StringBuffer("<table width=\"100%\"> \n");

    if (boxList == null) {
      return null;
    }

    //call createTable method
    if (isHorizontal == true) {
      performanceTrace.msg(TRACE_TAG, 10, "Flow Horizontally.");
      buffer.append(createTableHorizontal(boxList, checkedValues, checkboxName, columns, isRuled, formName,
                                          htmlAttributes, parent, parameters));
    } else {
      performanceTrace.msg(TRACE_TAG, 7, "Flow Vertically.");
      buffer.append(createTableVertical(boxList, checkedValues, checkboxName, columns, isRuled, formName,
                                        htmlAttributes, parent, parameters));
    }

    buffer.append("</table>");

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Creates html for a table of checkboxes flowing horizontally
   *
   * @param boxList       a collection of the codes to be populated in the table
   * @param checkedValues a collection of the values that need to be defaulted as checked.
   * @param checkboxName  the base name of the checkbox that will be created
   * @param columns       the number of columns the checkboxes should be displayed in
   * @param isRuled       whether or not to put rules(lines) between each row of checkboxes
   * @return a string of html for the checkboxes
   */
  protected static String createTableHorizontal(List boxList, Collection checkedValues, String checkboxName,
                                                int columns, boolean isRuled, String formName,
                                                Map<Object, Object> htmlAttributes, FormTag parent, Map parameters) {
    GrndsTrace.enterScope(TRACE_TAG + ".createTableHorizontal");
    StringBuffer buffer = new StringBuffer();
    int rowNum = 0;
    Mapping mapping;
    int size = boxList.size();
    int i;
    String rowCss = "";
    int columnWidth = 100 / columns;

    //for each code/decode combination
    for (i = 0; i < size; i++) {
      //if columns > 1 and column % columns == 0, create table row
      if ((i % columns) == 0) {
        FormattingHelper.getRowCss(rowNum + 1);
        buffer.append("<tr class=\"").append(rowCss).append("\">");
        rowNum++;
      }

      //if isRuled, put rule between rows make class for td = odd
      if (isRuled) {
        buffer.append("<td align=\"center\" width=\"4%\">");
      } else {
        buffer.append("<td align=\"center\" width=\"4%\">");
      }

      mapping = (Mapping) boxList.get(i);
      buffer.append(createCheckbox(checkboxName + (i + 1), formName, mapping.getKey(), mapping.getValue(),
                                   ((columnWidth > 10) ? columnWidth - 4 : 4), htmlAttributes, parent, checkedValues,
                                   parameters));
      buffer.append("</td>\n");

      //close out table row if needed
      if ((columns == 1) || (((i + 1) % columns) == 0)) {
        buffer.append("</tr>\n");
      }
    }

    //close out table
    while ((i % columns) != 0) {
      //keep adding columns
      buffer.append("<td></td>\n");

      //close out table row if needed
      if (((i + 1) % columns) == 0) {
        buffer.append("</tr>\n");
      }
      i++;
    }

    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Used as static method in a conversation action to get a HashMap of paired sets of a name and an action. The name is
   * the value in the "value" attribute of a checkbox on an HTML page. The action is either CheckboxHelper.ADD ("A") if
   * the box was not checked when the page was loaded, and was checked when it was submitted; or CheckboxHelper.DELETE
   * ("D") if the page was checked before the page was loaded and is not checked now. By default this does not return
   * any codes for checkboxes that have not changed.
   *
   * @param request      The request in which the checkbox values have been submitted
   * @param checkboxName The stem of the name used to identify the checkboxe group in the HTML code. If your checkboxes
   *                     are named cbxFoo1, cbxFoo2, etc. use "cbxFoo".
   * @return HashMap where the keys are the names and the values are the indictors, either CheckboxHelper.DELETE ("D")
   *         or CheckboxHelper.DELETE ("D") for add or delete
   */
  public static Map<String, String> getCheckedIndicators(HttpServletRequest request, String checkboxName) {
    return getCheckedIndicators(request.getParameterMap(), checkboxName, false);
  }

  /**
   * Used as static method in a conversation action to get a HashMap of paired sets of a name and and action. The name
   * is the value in the "value" attribute of a checkbox on an HTML page. The action is either CheckboxHelper.ADD ("A")
   * if the box was not checked when the page was loaded, and was checked when it was submitted; or
   * CheckboxHelper.DELETE ("D") if the page was checked before the page was loaded and is not checked now. By default
   * this does not return any codes for checkboxes that have not changed.
   *
   * @param map          a Map of the attributes obtained in request, usually obtained using request.getParameterMap();
   * @param checkboxName The stem of the name used to identify the checkboxe group in the HTML code. If your checkboxes
   *                     are named cbxFoo1, cbxFoo2, etc. use "cbxFoo".
   * @return HashMap where the keys are the names and the values are the indictors, either CheckboxHelper.ADD ("A") or
   *         CheckboxHelper.DELETE ("D") for add or delete.
   */
  public static Map<String, String> getCheckedIndicators(Map map, String checkboxName) {
    return CheckboxHelper.getCheckedIndicators(map, checkboxName, false);
  }

  /**
   * Used as static method in a conversation action to get a HashMap of paired sets of a name, and and action. The name
   * is the value in the "value" attribute of a checkbox on an HTML page. The action is either CheckboxHelper.ADD ("A")
   * if the box was not. Checked when the page was loaded, and was checked when it was submitted; or
   * CheckboxHelper.DELETE ("D") if the page was checked before the page was loaded and is not checked now. This method
   * also allows for the value CheckboxHelper.NO_ACTION (" ") to be returned if no action has been performed. No action
   * has been performed if the checkbox was checked on page display and is still checked, or the checkbox was unchecked
   * on page display and is still unchecked.
   *
   * @param map            a Map of the attributes obtained in request, usually obtained using
   *                       request.getParameterMap();
   * @param checkboxName   The stem of the name used to identify the checkboxe group in the HTML code. If your
   *                       checkboxes are named cbxFoo1, cbxFoo2, etc. use "cbxFoo".
   * @param returnNoAction If this value is true, then the HashMap will include entries for checkboxes upon which no
   *                       action has been taken. These entries will contain the action value CheckboxHelper.NO_ACTION
   *                       (" ")
   * @return HashMap where the keys are the names and the values are the indictors, either CheckboxHelper.ADD ("A") or
   *         CheckboxHelper.DELETE ("D") for add or delete and optionally CheckboxHelper.NO_ACTION (" ") for checkboxes
   *         upon which no action has been performed
   */
  public static Map<String, String> getCheckedIndicators(Map map, String checkboxName, boolean returnNoAction) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getCheckedIndicators()");
    performanceTrace.enterScope();

    Map<String, String> results = new HashMap<String, String>();

    int checkboxNameLength = checkboxName.length();
    String parameterName;

    //Loop through the parameter names looking for specified checkbox
    for (Iterator i = map.keySet().iterator(); i.hasNext();) {
      parameterName = (String) i.next();

      //Do a quick compare on length to rule out most params AND then check the actual name.
      if ((parameterName.length() >= checkboxNameLength) &&
          parameterName.startsWith(checkboxName) &&
          parameterName.endsWith("_changed")) {
        //If its valid, add a new entry with its name and the indicator value.
        String existingParameter = getExistingParameter(map, parameterName);
        if ((existingParameter != null) && (existingParameter.length() > 2)) {
          String fieldIndicator = existingParameter.substring(0, 1);
          if (" ".equals(fieldIndicator) && returnNoAction) {
            results.put(existingParameter.substring(2), NO_ACTION);
          } else if (!" ".equals(fieldIndicator)) {
            results.put(existingParameter.substring(2), fieldIndicator);
          }
        }
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope(results);
    return results;
  }

  /**
   * Creates html for a table of checkboxes flowing vertically
   *
   * @param boxList       a collection of the codes to be populated in the table
   * @param checkedValues a collection of the values that need to be defaulted as checked.
   * @param checkboxName  the base name of the checkbox that will be created
   * @param columns       the number of columns the checkboxes should be displayed in
   * @param isRuled       whether or not to put rules(lines) between each row of checkboxes
   * @return a string of html for the checkboxes
   */
  protected static String createTableVertical(List boxList, Collection checkedValues, String checkboxName, int columns,
                                              boolean isRuled, String formName, Map<Object, Object> htmlAttributes,
                                              FormTag parent, Map parameters) {
    GrndsTrace.enterScope(TRACE_TAG + ".createTableVertical");
    StringBuffer buffer = new StringBuffer();
    int rowNum = 0;
    Mapping mapping;
    int size = boxList.size();
    int columnNum;
    int totalRows = size / columns;
    totalRows = ((size % columns) == 0) ? totalRows : (totalRows + 1);
    int index;
    int i;
    int totalLoops = totalRows * columns;
    int columnWidth = 100 / columns;

    //for each code/decode combination
    for (i = 0; i < totalLoops; i++) {
      columnNum = i % columns;

      //if columnNum == 0, create table row
      if (columnNum == 0) {
        buffer.append("<tr");

        //If table should be ruled, put in css class
        if (isRuled) {
          buffer.append(" class=\"").append(FormattingHelper.getRowCss(totalLoops)).append("\"");
        }
        buffer.append(">");
        rowNum++;
      }

      //Start table cell
      buffer.append("<td width=\"4%\">");
      //buffer.append( "<td width=\"" + columnWidth / 6 + "%\">" );

      /*
      ** Calculate the index - since the table is created in a Horizontal
      ** manner, but it needs to flow vertically, the index must be
      ** calculated.
      */
      index = (totalRows * columnNum) + (rowNum - 1);
      GrndsTrace.msg(TRACE_TAG, 10, "index " + index);
      if (index < size) {
        mapping = (Mapping) boxList.get(index);
        buffer.append(createCheckbox(checkboxName + (i + 1), formName, mapping.getKey(), mapping.getValue(),
                                     ((columnWidth > 10) ? columnWidth - 4 : 4), htmlAttributes, parent, checkedValues,
                                     parameters));
      }
      buffer.append("</td>\n");

      //close out table row if needed
      if ((columns == 1) || (((i + 1) % columns) == 0)) {
        buffer.append("</tr>\n");
      }
    }

    GrndsTrace.exitScope();

    //close out table
    return buffer.toString();
  }

  /**
   * Creates the HTML tag for a single checkbox. This code is used by the createCheckbox() methods to generate HTML code
   * for the widgets themselves. This method not only creates a checkbox, but creates a hidden field in which to store
   * the actions performed upon the checkbox so that the getCheckedInidcators() method can determine if a checkbox has
   * been changed. It also creates an onClick attribute for the checkbox input widget. The onClick event calls the
   * setCbxChange() javascript function, which updates the hidden field. This defaults the width in table cells to 0;
   *
   * @param name           name of the checkbox. This will go in the "name" attribute of the html input tag.
   * @param formName       name of the form the checkbox is located in. This is used for validation
   * @param code           the value that is stored in the "value" attribute of the html input tag.
   * @param decode         the value that is used to lable the checkbox widget
   * @param htmlAttributes a map of all the html attributes that are not explicitly handled by this tag.
   * @param parent         object representing the form named by the formName parameter
   * @param checkedValues  list of all the checkboxes that should be checked. The matchin criterea for whether a given
   *                       box is checked is given in isChecked()
   * @param parameters     a list of all the parameters in the request obtained by using request.getParameterMap();
   * @return String containing HTML for the checkbox
   */

  public static String createCheckbox(String name, String formName, String code, String decode,
                                      Map<Object, Object> htmlAttributes, FormTag parent, Collection checkedValues,
                                      Map parameters) {
    return createCheckbox(name, formName, code, decode, 0, htmlAttributes, parent, checkedValues, parameters);
  }

  /**
   * Creates the HTML tag for a single checkbox. This code is used by the createCheckbox() methods to generate HTML code
   * for the widgets themselves. This method not only creates a checkbox, but creates a hidden field in which to store
   * the actions performed upon the checkbox so that the getCheckedInidcators() method can determine if a checkbox has
   * been changed. It also creates an onClick attribute for the checkbox input widget. The onClick event calls the
   * setCbxChange() javascript function, which updates the hidden field.
   *
   * @param name           name of the checkbox. This will go in the "name" attribute of the html input tag.
   * @param formName       name of the form the checkbox is located in. This is used for validation
   * @param code           the value that is stored in the "value" attribute of the html input tag.
   * @param decode         the value that is used to lable the checkbox widget
   * @param width          the number of table cells (tds) that the widget takes up (minimum of 1) the label will always
   *                       take up one more cell than that.
   * @param htmlAttributes a map of all the html attributes that are not explicitly handled by this tag.
   * @param parent         object representing the form named by the formName parameter
   * @param checkedValues  list of all the checkboxes that should be checked. The matchin criterea for whether a given
   *                       box is checked is given in isChecked()
   * @param parameters     a list of all the parameters in the request obtained by using request.getParameterMap();
   * @return String containing HTML for the checkbox
   */
  public static String createCheckbox(String name, String formName, String code, String decode, int width,
                                      Map<Object, Object> htmlAttributes, FormTag parent, Collection checkedValues,
                                      Map parameters) {
    GrndsTrace.enterScope(TRACE_TAG + ".createCheckbox ");

    StringBuffer buffer = new StringBuffer();
    boolean isChecked = isChecked(code, name, parent, checkedValues, parameters);

    //Get the changed field value
    String changedIndFieldValue;
    String changedIndFieldName = (name + "_changed");
    String existingParameter = getExistingParameter(parameters, changedIndFieldName);
    String parentValue = parent.getInputValue(changedIndFieldName);
    GrndsTrace.msg(TRACE_TAG, 10, "existing parameter:" + existingParameter + " parentValue:" +
                                  parentValue);

    // DWW 05/13/2003 SIR 17222:
    // added the hidden- field to the cbx if the cbx is both checked and disabled
    boolean disabled = (htmlAttributes != null) && (htmlAttributes.containsKey("disabled"));

    changedIndFieldValue = getChangedIndFieldValue(code, parent, isChecked, existingParameter);

    //Start creating the checkbox
    buffer.append("<input type=\"checkbox\"");
    buffer.append(" name=\"");
    buffer.append(name);
    // DWW 05/13/2003 SIR 17222:
    // added the hidden- field to the cbx if the cbx is both checked and disabled
    if (disabled) {
      buffer.append("_Disabled");
    }
    buffer.append("\" id=\"");
    buffer.append(name).append("_Id");
    buffer.append("\"");
    buffer.append(" value=\"");
    buffer.append(code);
    buffer.append("\"");

    if (isChecked) {
      GrndsTrace.msg(TRACE_TAG, 10, "append checked");
      buffer.append(" checked ");
    }
    buffer.append(" onClick=\"setCbxChange( '");
    buffer.append(formName);
    buffer.append("', this); ");

    //Remove onClick and put it into the onClick attribute.
    if (htmlAttributes != null) {
      String onClick = String.valueOf(htmlAttributes.remove("onClick"));
      if (onClick != null) {
        buffer.append(onClick);
      }
      buffer.append("\" ");

      //List all attributes, with exception of onClick.
      buffer.append(BaseHtmlTag.listAttributes(htmlAttributes));

      //After listing all attributes, add onClick back into attribute list.
      if (onClick != null) {
        htmlAttributes.put("onClick", onClick);
      }
    } else {
      buffer.append("\" ");
    }

    //BEE- 11/20 Added hidden field for checked indicator
    buffer.append("/>");

    // DWW 05/13/2003 SIR 17222:
    // added the hidden- field to the cbx if the cbx is both checked and disabled
    if (disabled && isChecked) {
      buffer.append("<input type=\"hidden\" name=\"");
      buffer.append(name);
      buffer.append("\" value=\"");
      buffer.append(code);
      buffer.append("\">");
    }

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(name);
    buffer.append("_changed\" value=\"");
    buffer.append(changedIndFieldValue);
    buffer.append("\" id=\"");
    buffer.append(name).append("_changed_Id");
    buffer.append("\">&nbsp;&nbsp;");
    if (width > 0) {
      buffer.append("</td><td align=left width=").append(width).append("%>");
    }
    buffer.append(decode);

    GrndsTrace.exitScope( /*buffer*/);

    return buffer.toString();
  }

  /**
   * Used to generate the value contained in the hidden field associated with a checkbox generated by createCheckbox().
   *
   * @param value             the value set into the "value" attribute in the custom tag
   * @param parent            the object representing the form that contains the checkbox
   * @param isChecked         indicates whether the checked field on this checkbox is set to true
   * @param existingParameter the value that was gotten out of the request if this page was reposted. This parameter
   *                          will be used to set the value if parent.getBWidgetsRefreshFromRequest() == true ( which
   *                          usually means that the page is refreshing due to an error condition ).
   * @return the string is of the form "_X&lt;val&gt;" where _ is a space, X is a "Y" if the field is checked, "N" if
   *         the field is not checked, and &lt;val&gt; is the "value" attribute, as passed in in the value parameter.
   *         the space at the beginning is used to hold the action code (ADD, DELETE, NO_ACTION), and starts out as
   *         NO_ACTION (that is the meaning of the space).
   */
  public static String getChangedIndFieldValue(String value, FormTag parent, boolean isChecked,
                                               String existingParameter) {
    String changedIndFieldValue;

    //DWW - 1/9/03 - If conversation error, redisplay existing
    //String conversationError = (String)request.getAttribute( ServerSideValidationUtility.FORM_VALIDATION_CONVERSATION_ERROR );
    //boolean bConversationError = ( conversationError != null && conversationError.equals( "true" ) );
    if ((existingParameter != null) &&
        parent.getBWidgetsRefreshFromRequest()) //&& existingParameter.equals( parentValue ) )
    {
      changedIndFieldValue = existingParameter;
      GrndsTrace.msg(TRACE_TAG, 7, "Using previously entered parameter for changed field ind:" +
                                   changedIndFieldValue);
    } else {
      //Set the changed field based on the specified default values
      changedIndFieldValue = " ";
      if (isChecked) {
        changedIndFieldValue += "Y";
      } else {
        changedIndFieldValue += "N";
      }
      changedIndFieldValue += value;
      GrndsTrace.msg(TRACE_TAG, 10, "Setting Changed Ind value from field value:" +
                                    changedIndFieldValue);
    }
    return changedIndFieldValue;
  }

  /**
   * Determines whether or not a checkbox should be checked depending on the custom tag's "checked" attribute and the
   * previous parameters. The pseudocode for determining of a checkbox is checked looks like this:
   * <p/>
   * if (!parent.getBWidgetsRefreshFromRequest())<br> isChecked = checkedValues.contains(code); <br> else if
   * ((parameters != null) && (parameters.get(name) != null)) <br> isChecked = true; <br> </p> Generally,
   * parent.getBWidgetsRefreshFromRequest() is true if the page is refreshing from an error condition.
   *
   * @param code          value for the checkbox
   * @param name          name of the checkbox
   * @param parent        object representing the parent form which contains this checkbox
   * @param checkedValues collection of checked values
   * @param parameters    parameter map from the request
   * @return checked True or False depending on whether it should be checked
   */
  private static boolean isChecked(String code, String name, FormTag parent, Collection checkedValues, Map parameters) {
    GrndsTrace.enterScope(TRACE_TAG + ".isChecked()");

    GrndsTrace.msg(TRACE_TAG, 10, "sub cnt:" + parent.getBWidgetsRefreshFromRequest() +
                                  " parm val:" + (parameters != null ? parameters.get(name) : null));

    boolean isChecked = false;

    //DWW - 01/15/03 - changed this from sumissionCount to isBConversationError()
    if (!parent.getBWidgetsRefreshFromRequest()) {
      //If value is in the collection of checkedValues, put checked into tag
      if (checkedValues != null) {
        isChecked = checkedValues.contains(code);
        GrndsTrace.msg(TRACE_TAG, 10, "checkbox: " + name + "isChecked(checkedValues):" + isChecked + ";");
      }
    } else if ((parameters != null) && (parameters.get(name) != null)) {
      //If it is being redisplayed after a failed validation, and was checked before, check it
      isChecked = true;
      GrndsTrace.msg(TRACE_TAG, 10, "checkbox: " + name + "isChecked(parentValue):" + isChecked + ";");
    }
    GrndsTrace.exitScope(isChecked);
    return isChecked;
  }

  /**
   * Passing the castorClassName is no longer necessary, so this method has been replaced by
   * <p/>
   * public static Collection getChangedValues(HttpServletRequest request, String checkboxName, XmlValueBean values,
   * Class castorClass, String valuePropertyName) </p> In which the Class object of the castor object is passed in. This
   * value can be obtained by using the &lt;objectname&gt;.class method. For instance CFIN19S.class.
   *
   * @param request
   * @param checkboxName
   * @param values
   * @param castorClassName
   * @param valuePropertyName
   * @return
   * @throws CheckboxHelperException
   * @deprecated
   */
  public static Collection getChangedValues(HttpServletRequest request, String checkboxName, XmlValueBean values,
                                            String castorClassName, String valuePropertyName)
          throws CheckboxHelperException {
    try {
      return getChangedValues(request, checkboxName, values, Class.forName(castorClassName), valuePropertyName);
    } catch (ClassNotFoundException e) {
      throw new CheckboxHelperException("Error getting class name '" +
                                        castorClassName + "'", e);
    }
  }

  /**
   * This is the preferred method for getting the changed values from the request, associated with checkboxes. This
   * method takes a list of objects (usually obtained from state), and a checkbox group, and returns a Collection of
   * pairs of those objects and action codes on what to do with those objects upon a save. The returned Collection
   * contains CheckboxHelper.ObjectActionCodePair objects. These objects contain the object associated with a checkbox,
   * and the task code assocated with the checkbox. The returned Collection can be used to easily create a service input
   * (SI) object, using the following pseudocode:
   * <p/>
   * <code> CastorOutObject_ARRAY mySOArray = state.getAttribute( "mySO", request );<br> Collection changedValues =
   * getChangedValues(request, "myCbx", mySOArray, CastorObject.class, "szValue");<br> <br> CastorInObject_ARRAY
   * mySIArray = new CastorInObject_ARRAY();<br> for ( Iterator i = changedValues.iterator(); i.hasNext(); )<br> {<br>
   * CheckboxHelper.ObjectActionCodePair pair = (CheckboxHelper.ObjectActionCodePair ) i.next();<br> CastorOutObject
   * mySO = (CastorObject) pair.getObject();<br> String actionCode = pair.getActionCode();<br> <br> CastorInObject mySI
   * = new CastorInObject();<br> mySI.setSzCdScrDataAction( actionCode );<br> mySI.setSzValue( mySO.getSzValue() );<br>
   * mySI.setA( mySO.getA() );<br> mySI.setB( mySO.getB() );<br> mySI.setC( mySO.getC() );<br> mySI.setD( mySO.getD()
   * );<br> <br> mySIArray.add( mySI );<br> }<br> </code> </p>
   *
   * @param request           the request where the checkbox parameters have been posted
   * @param checkboxName      the stem of the name used for the checkboxes in this checkbox group. If your checkboxes
   *                          are named cbxFoo1, cbxFoo2, etc, then the value of this parameter should be "cbxFoo".
   * @param values            a Castor ARRAY object of Castor objects containing values associated with the checkboxes.
   * @param castorClass       This value can be obtained by using the &lt;objectname&gt;.class method. For instance
   *                          CFIN19S.class.
   * @param valuePropertyName the name of the property used to populate the "value" attribute in the checkboxes. This
   *                          value is used to uniquely identify the obhects in the Castor ARRAY object passed in the
   *                          "values" parameter, and associate them with a checkbox value.
   * @return A Collection of CheckboxHelper.ObjectActionCodePair objects. Each object contains a Castor object and a
   *         String representing the ActionCodes.
   * @throws CheckboxHelperException if there are any problems with the introspection
   */
  public static Collection<ObjectActionCodePair> getChangedValues(HttpServletRequest request, String checkboxName,
                                                                  XmlValueBean values, Class castorClass,
                                                                  String valuePropertyName)
          throws CheckboxHelperException {
    Map checkedIndicators = getCheckedIndicators(request, checkboxName);
    Collection<ObjectActionCodePair> changedValues;
    if (valuePropertyName.startsWith("ul")) {
      changedValues = getChangedIntValues(checkedIndicators, castorClass, values, valuePropertyName);
    } else {
      changedValues = getChangedStringValues(checkedIndicators, castorClass, values, valuePropertyName);
    }
    return changedValues;
  }

  /**
   * @param checkedIndicators
   * @param castorClass
   * @param values
   * @param valuePropertyName
   * @return
   * @throws CheckboxHelperException
   */
  private static Collection<ObjectActionCodePair> getChangedStringValues(Map checkedIndicators, Class castorClass,
                                                                         XmlValueBean values, String valuePropertyName)
          throws CheckboxHelperException {
    try {
      Collection<ObjectActionCodePair> objectActionCodeArray = new ArrayList<ObjectActionCodePair>();

      // get a copy of the set() method for the nameProperty
      String setValueMethodName = "set" + FormattingHelper.initCaps(valuePropertyName);
      String getValueMethodName = "get" + FormattingHelper.initCaps(valuePropertyName);
      Class[] parameterTypes = {java.lang.String.class};
      Method setNameMethod = castorClass.getMethod(setValueMethodName, parameterTypes);
      Method getNameMethod = castorClass.getMethod(getValueMethodName);

      if ((checkedIndicators != null) && !checkedIndicators.isEmpty()) {
        // populate deletes only
        Enumeration objects = CastorArrayHelper.getEnumeration(values); //this will contain objects
        while (objects.hasMoreElements()) {
          XmlValueBean object = (XmlValueBean) objects.nextElement();
          String name = (String) getNameMethod.invoke(object);
          String indicator = (String) checkedIndicators.get(name);
          if ((indicator != null) && indicator.equals(CheckboxHelper.DELETED)) {
            ObjectActionCodePair pair = new ObjectActionCodePair(object, CheckboxHelper.DELETED);
            objectActionCodeArray.add(pair);
          }
        }

        // populate adds and unchanged unchecked boxes
        for (Iterator checkboxNames = checkedIndicators.entrySet().iterator();
             checkboxNames.hasNext();) {
          Map.Entry checkboxInd = (Map.Entry) checkboxNames.next();
          String name = (String) checkboxInd.getKey();
          String indicator = (String) checkboxInd.getValue();
          if ((indicator != null) && indicator.equals(CheckboxHelper.ADDED)) {
            Object[] parameters = {name};
            XmlValueBean object = (XmlValueBean) castorClass.newInstance();
            setNameMethod.invoke(object, parameters);
            ObjectActionCodePair pair = new ObjectActionCodePair(object, CheckboxHelper.ADDED);
            objectActionCodeArray.add(pair);
          }
        }
      }
      return objectActionCodeArray;
    } catch (Exception e) {
      throw new CheckboxHelperException("createCheckBoxGroup", e);
    }
  }

  /**
   * @param checkedIndicators
   * @param values
   * @param valuePropertyName
   * @return
   * @throws CheckboxHelperException
   */
  private static Collection<ObjectActionCodePair> getChangedIntValues(Map checkedIndicators, Class castorClass,
                                                                      XmlValueBean values, String valuePropertyName)
          throws CheckboxHelperException {
    try {
      Collection<ObjectActionCodePair> objectActionCodeArray = new ArrayList<ObjectActionCodePair>();

      // get a copy of the set() method for the nameProperty
      String setValueMethodName = "set" + FormattingHelper.initCaps(valuePropertyName);
      String getValueMethodName = "get" + FormattingHelper.initCaps(valuePropertyName);
      Class[] parameterTypes = {java.lang.Integer.TYPE};//java.lang.String.class };
      Method setNameMethod = castorClass.getMethod(setValueMethodName, parameterTypes);
      Method getNameMethod = castorClass.getMethod(getValueMethodName);

      if ((checkedIndicators != null) && !checkedIndicators.isEmpty()) {

        // populate deletes only
        Enumeration objects = CastorArrayHelper.getEnumeration(values); //this will contain objects
        while (objects.hasMoreElements()) {
          //populating deletes
          XmlValueBean object = (XmlValueBean) objects.nextElement();
          //String name = (String) getNameMethod.invoke(object, null);

          String name = getNameMethod.invoke(object).toString();
          String indicator = (String) checkedIndicators.get(name);
          if ((indicator != null) && indicator.equals(CheckboxHelper.DELETED)) {
            ObjectActionCodePair pair = new ObjectActionCodePair(object, CheckboxHelper.DELETED);
            objectActionCodeArray.add(pair);
          }
        }

        // populate adds and unchanged unchecked boxes
        for (Iterator checkboxNames = checkedIndicators.entrySet().iterator();
             checkboxNames.hasNext();) {
          //populating adds
          Map.Entry checkboxInd = (Map.Entry) checkboxNames.next();
          String name = (String) checkboxInd.getKey();
          String indicator = (String) checkboxInd.getValue();
          if ((indicator != null) && indicator.equals(CheckboxHelper.ADDED)) {
            Object[] parameters = {new Integer(name)};
            XmlValueBean object = (XmlValueBean) castorClass.newInstance();
            setNameMethod.invoke(object, parameters);
            ObjectActionCodePair pair = new ObjectActionCodePair(object, CheckboxHelper.ADDED);
            objectActionCodeArray.add(pair);
          }
        }
      }
      return objectActionCodeArray;
    } catch (Exception e) {
      throw new CheckboxHelperException("createCheckBoxGroup", e);
    }
  }

  /**
   * Get the existing parameter out of the parameter map.  If it is not a string( ie its a StringArray), get the first
   * element in the array
   *
   * @param parameters parameter map from the request
   * @param name       name of the attribute to get from the parameter map
   * @return existingParameter The parameter
   */
  private static String getExistingParameter(Map parameters, String name) {
    String changedIndFieldValue = "";
    String existingParameter = null;
    if ((parameters.get(name) != null) &&
        (parameters.get(name).getClass().equals(changedIndFieldValue.getClass()))) {
      existingParameter = (String) parameters.get(name);
    } else {
      if (parameters.get(name) != null) {
        String[] stringArray;
        stringArray = (String[]) parameters.get(name);
        existingParameter = stringArray[0];
        GrndsTrace.msg(TRACE_TAG, 10, "param value is not a:" +
                                      changedIndFieldValue.getClass() + ", it is: " +
                                      parameters.get(name).getClass());
      }
    }
    return existingParameter;
  }

  public static class ObjectActionCodePair
          implements Serializable {
    private XmlValueBean object = null;
    private String actionCode = "";

    public ObjectActionCodePair() {
    }

    public ObjectActionCodePair(XmlValueBean object, String actionCode) {
      setObject(object);
      setActionCode(actionCode);
    }

    public XmlValueBean getObject() {
      return this.object;
    }

    public String getActionCode() {
      return this.actionCode;
    }

    public void setObject(XmlValueBean object) {
      this.object = object;
    }

    public void setActionCode(String actionCode) {
      this.actionCode = actionCode;
    }
  }
}
