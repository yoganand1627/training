package gov.georgia.dhr.dfcs.sacwis.web.core.pagination;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RequestAttributes;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;

/**
 * This class factors out some of the most complicated code from the ResultsPaginationTag. It allows for easier testing
 * of the logic and keeps the tag as simple as possible.
 *
 * @author Randy O'Neil, October 12, 2001
 *         <p/>
 *         Modified July 25, 2002 by Sanjay Rana Added getCheckedListJavascript() methods to the class for use from
 *         Resource List page
 */
public class ResultsPaginationHelper {
  public static final String REQUESTED_PAGE_KEY = "page";
  private static final String TRACE_TAG = "ResultsPaginationHelper";
  private static final int DEFAULT_NUMBER_OF_RESULTS = 0;
  private static final int DEFAULT_REQUESTED_PAGE = 1;
  private static final int DEFAULT_RESULTS_PER_PAGE = 25;
  private static final int DEFAULT_NUMBER_OF_PAGE_LINKS = 10;

  // HTML table values
  private static final int TABLE_CELL_SPACING = 0;
  private static final int TABLE_CELL_PADDING = 3;
  private static final int TABLE_BORDER = 0;
  private static final String TABLE_WIDTH = "100%";

  private static final String JAVASCRIPT_METHOD_CALL_LINK = "<a href=\"javascript:hrefDirtyBypass=true;selectPage(";

  private static final Set<String> EXCLUDE_PARAMETERS = new HashSet<String>() {

    {
      add(ResultsPaginationHelper.REQUESTED_PAGE_KEY);
      add(ServerSideValidationUtility.FORM_VALIDATION_FLAG);
      add(ServerSideValidationUtility.FORM_VALIDATION_URL);
      add(ServerSideValidationUtility.FORM_VALIDATION_CANCEL);
      add(ServerSideValidationUtility.FORM_VALIDATION_DEFINITION);
      add(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);
      add(RequestAttributes.FORM_ATTRIBUTES_REQUEST_PARAM);
      add(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);

      /*SIR 15533 - the results pagination helper takes the order by and direction
    from an instance of this bean, which is set correctly from the request or not
    in the value bean helper.  There is no nead to set the order by and direction
    back into the request fields.  This was causing a problem when going from
    the payment approval page (sorted) to the invoice page (also sorted, and
    submits to itself).*/
      add(SortableColumnTag.DIRECTION_NAME);
      add(SortableColumnTag.ORDER_BY_NAME);
    }
  };

  /**
   * This method gets the search parameters from the request and stores them to a HashMap. This will allow the framework
   * to regenerate the same query for the page links.
   *
   * @param request
   * @param databaseResultDetails
   */
  public static void setUrlParameters(HttpServletRequest request, DatabaseResultDetails databaseResultDetails) {
    GrndsTrace.enterScope(TRACE_TAG + ".setUrlParameters");
    Map<String, String> requestParameters = new HashMap<String, String>();
    Enumeration keys = request.getParameterNames();
    while (keys.hasMoreElements()) {
      String thisKey = (String) keys.nextElement();
      Object value = request.getParameter(thisKey);
      // Do not append any old page values from previous requests or form validation parameters
      if (!EXCLUDE_PARAMETERS.contains(thisKey)) {
        if (value != null && !"".equals(value)) {
          requestParameters.put(thisKey, request.getParameter(thisKey));
        }
      }
    }
    databaseResultDetails.setUrlParameters(requestParameters);
    GrndsTrace.exitScope();
  }

  /**
   * Return the header HTML that tells the user what group of results they are looking at and how many total results
   * there are.
   *
   * @param resultsInfo the DatabaseResultDetails object that contains the details to display
   * @return String the header HTML
   */
  public String getOutputHeader(DatabaseResultDetails resultsInfo) throws IOException {
    GrndsTrace.enterScope(ResultsPaginationHelper.TRACE_TAG + ".getOutputHeader");
    String returnValue = "";

    int currentPage = resultsInfo.getRequestedPage();
    int maxPage = resultsInfo.getNumberOfResultPages();
    int totalResults = resultsInfo.getNumberOfResults();
    int firstResult = ((currentPage - 1) * resultsInfo.getResultsPerPage()) + 1;

    int lastResult;
    if (currentPage == maxPage) {
      lastResult = totalResults;
    } else {
      lastResult = (currentPage * resultsInfo.getResultsPerPage());
    }

    // Check that the page number makes sense
    if ((currentPage > 0) && (currentPage <= maxPage)) {
      StringBuffer buffer = this.getTableHeaderBuffer();
      this.appendLine(buffer, "</td>");
      this.appendLine(buffer, "</tr>");
      this.appendLine(buffer, "<tr>");
      this.appendLine(buffer, "<th noWrap align=\"left\"> Search Results Summary</th>");
      this.appendLine(buffer, "<th noWrap align=\"right\">");
      buffer.append("<div align=\"right\">");

      buffer.append("Results ");
      buffer.append(firstResult);
      buffer.append(" - ");
      buffer.append(lastResult);
      buffer.append(" of ");
      buffer.append(totalResults);
      buffer.append("</div>");

      this.appendLine(buffer, "</th>");
      this.appendLine(buffer, "</tr>");
      this.appendLine(buffer, "</table>");

      returnValue = buffer.toString();
    }
    GrndsTrace.exitScope(/*returnValue*/);
    return returnValue;
  }

  /**
   * This method generates the output to create a form for the pagination data.
   *
   * @param url     The url to submit the form to.
   * @param details The DatabaseResultDetails object to get information from for the orderBy fields.
   */
  public String getFormOutput(String url, DatabaseResultDetails details) throws IOException {
    StringBuffer output = new StringBuffer();

    createHiddenField("page", "" + details.getRequestedPage(), output);

    createHiddenField("formPaginated", "true", output);

    createOrderByFields(details, output);
    return output.toString();
  }

  /**
   * This will create a hidden field for each parameter currently in the request.  This will allow the search criteria
   * to be resubmitted in order to regenerate the query for each page.  It will also create the hidden field state
   * management tag, if the page state needs to be maintained.
   *
   * @param parameters A HashMap of all the parameters from the request object.
   * @param request    The request object, in case we need to create the state hidden field
   * @param saveState  Whether or not the pagination page should maintain application state.
   */
  public String getParameterFields(Map parameters, HttpServletRequest request, boolean saveState)
          throws IOException, JspException {
    Set keys = parameters.keySet();
    Iterator keyIterator = keys.iterator();
    StringBuffer fields = new StringBuffer();

    while (keyIterator.hasNext()) {
      String key = (String) keyIterator.next();
      if (!"checkedResource".equals(key) &&
          !"formName".equals(key)) {
        String value = (String) parameters.get(key);
        this.createHiddenField(key, value, fields);
      }
    }

    if (saveState) {
      this.createHiddenField(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY,
                             new HiddenFieldSessionStateTag().getEncodedSessionState(request), fields);
    }

    return fields.toString();
  }

  public static boolean showPreviousNext(DatabaseResultDetails resultsInfo) {
    int maxPage = resultsInfo.getNumberOfResultPages();
    return (maxPage > 1);
  }

  /*
    SPB - 9/8/2003
    NEED TO KEEP TXT BOX WHEN PAGE ENTERED IS GREATER THAN MAXPAGE
  */
  public String getMaxOutputOptions(int currentPage) {
    StringBuffer buffer = this.getTableHeaderBuffer();
    this.appendLine(buffer, "Previous");
    this.appendLine(buffer, "<input type=\"text\" size=\"1\" maxlength=\"3\" name=\"txtPage\" " +
                            " class=\"paginate\" value=\"" +
                            currentPage +
                            "\" " +
                            " onKeyDown=\"hrefDirtyBypass=true;paginateOnEnter(this.value)\" >");
    this.appendLine(buffer, "Next");
    this.appendLine(buffer, getTableFooter());
    return buffer.toString();
  }

  /**
   * Return the HTML that is composed of links of the various pages the user can jump to.
   *
   * @param resultsInfo the DatabaseResultDetails object that contains the details to display
   * @param onClickPrev the javascript command to execute for the onClick event of the "Previous" link
   * @param onClickNext the javascript command to execute for the onClick event of the "Next" link
   * @return String the HTML with the page links
   */
  public String getOutputOptions(DatabaseResultDetails resultsInfo, String onClickPrev, String onClickNext)
          throws IOException {
    GrndsTrace.enterScope(ResultsPaginationHelper.TRACE_TAG + ".getOutputOptions");
    String returnValue = "";
    int currentPage = resultsInfo.getRequestedPage();
    int maxPage = resultsInfo.getNumberOfResultPages();

    if (showPreviousNext(resultsInfo)) {
      StringBuffer buffer = this.getTableHeaderBuffer();

      if (currentPage > 1) {
        String output =
                this.generateLinkHtml(String.valueOf(resultsInfo.getRequestedPage() - 1), "Previous", onClickPrev);

        this.appendLine(buffer, output);
      } else {
        if (maxPage == 1) {
          this.appendLine(buffer, "&nbsp;");
        } else {
          this.appendLine(buffer, "Previous");
        }
      }

      this.appendLine(buffer, "<input type=\"text\" size=\"1\" maxlength=\"3\" name=\"txtPage\" " +
                              " class=\"paginate\" value=\"" + currentPage + "\" " +
                              " onKeyDown=\"hrefDirtyBypass=true;paginateOnEnter(this.value)\" >");

      //BEE - Only display Prev Next in pagination navigation - no page numbers
      //this.populatePageNumbers(buffer, resultsInfo);
      if (currentPage < maxPage) {
        String output = this.generateLinkHtml(String.valueOf(resultsInfo.getRequestedPage() + 1), "Next", onClickNext);

        this.appendLine(buffer, output);
      } else {
        if (maxPage == 1) {
          this.appendLine(buffer, "&nbsp;");
        } else {
          this.appendLine(buffer, "Next");
        }
      }
      this.appendLine(buffer, getTableFooter());

      returnValue = buffer.toString();
    }
    GrndsTrace.exitScope(/*returnValue*/);
    return returnValue;
  }

  /** This method will return the Javascript that is used to submit the pagination form. */
  public String getJavascript(String formName, String formAction) {
    StringBuffer output = new StringBuffer();
    output.append(this.getSetPageMethod(formName, formAction));
    output.append(this.getSetOrderMethod(formName, formAction));

    return output.toString();
  }

  /**
   * This method will return the Javascript that is used to submit the pagination form and the selected resources for
   * display selected funtionality.
   */
  public String getCheckedListJavascript(int totalListSize, String form, String formAction) {
    StringBuffer output = new StringBuffer();
    output.append("\n<input type=\"hidden\" class=\"nomargins\" name=\"checkedResource\" value=\"\"/>");
    output.append(this.getOpenMethod("selectPage(page)"));
    output.append("\n");
    output.append("document.");
    output.append(form);
    output.append(".page.value = page;");

    //output.append(this.getSetPageMethod());
    //StringBuffer output = this.getOpenMethod("selectPage(page)");
    output.append("\n");
    output.append("var valueString = \"\";");
    output.append("\n");
    output.append("var j = 0;");
    for (int i = 0; i < totalListSize; i++) {
      output.append("\n");
      output.append("if (document.");
      output.append(form);
      output.append(".cbxCheckedResource_");
      output.append(i);
      output.append(".checked == true){");
      output.append("\n");
      output.append("  valueString += document.");
      output.append(form);
      output.append(".cbxCheckedResource_");
      output.append(i);
      output.append(".value;");
      output.append("\n");
      output.append("  valueString += \",\";");
      output.append("\n");
      output.append("  j ++;");
      output.append("\n");
      output.append("}");
    }
    output.append("\n");

    /*       output.append("valueString += \",\";");
             output.append("\n");
             output.append("var numberChecked = new String(j);");
             output.append("\n");
             output.append("valueString += numberChecked;");**/
    output.append("\n");
    output.append("document.");
    output.append(form);
    output.append(".checkedResource");
    output.append(".value += ");
    output.append("valueString;");
    this.addJavascriptSubmitLine(output, form, formAction);

    return output.toString();
  }

  /**
   * This method will create the OrderBy hidden fields if they do not exist.  It is possible that if a previous
   * selection occurred, the fields will exist because they'll be pulled from the values on the request.  If so, this
   * method will output nothing.
   *
   * @param details The DatabaseResultDetails object to get the orderBy information from.
   * @param output  The StringBuffer to append the hidden fields to.
   */
  protected void createOrderByFields(DatabaseResultDetails details, StringBuffer output) {
    Map parameters = details.getUrlParameters();

    String orderBy = details.getOrderBy();
    if (parameters.get(SortableColumnTag.ORDER_BY_NAME) != null) {
      orderBy = (String) parameters.get(SortableColumnTag.ORDER_BY_NAME);
    }

    this.createHiddenField(SortableColumnTag.ORDER_BY_NAME, orderBy, output);

    String orderByDirection = details.getOrderByDirection();
    if (parameters.get(SortableColumnTag.DIRECTION_NAME) != null) {
      orderByDirection = (String) parameters.get(SortableColumnTag.DIRECTION_NAME);
    }

    this.createHiddenField(SortableColumnTag.DIRECTION_NAME, orderByDirection, output);
  }

  /**
   * This method will create a hidden field.  If the value is null, no value will be set.
   *
   * @param name   The name for the field
   * @param value  The value to set to the field
   * @param output The StringBuffer to append this text to.
   */
  protected void createHiddenField(String name, String value, StringBuffer output) {
    output.append("\n");
    output.append("<input type=\"hidden\" class=\"nomargins\" name=\"");
    output.append(name);

    if (value != null) {
      output.append("\" value=\"");
      output.append(value);
      output.append("\" />");
    } else {
      output.append("\" />");
    }
  }

  /**
   * This method will generate the text for the Javascript setOrderBy() method.  This Javascript method will be executed
   * by the sort icon links on the table.
   *
   * @return String The setOrderBy() method.
   */
  protected String getSetOrderMethod(String formName, String formAction) {
    StringBuffer output = this.getOpenMethod(" setOrderBy(orderBy, direction)");
    this.addJavascriptSetFieldValue("orderBy", "orderBy", output, formName);
    this.addJavascriptSetFieldValue("orderByDirection", "direction", output, formName);
    this.addJavascriptSetFieldValue("page", "'1'", output, formName);
    this.addJavascriptSubmitLine(output, formName, formAction);

    return output.toString();
  }

  /**
   * This method will generate the text for the Javascript setPage() method.  This Javascript method will be executed by
   * the previous, next, and page links.
   *
   * @return String The setPage() method.
   */
  protected String getSetPageMethod(String formName, String formAction) {
    StringBuffer output = this.getOpenMethod("selectPage(page)");
    this.addJavascriptSetFieldValue("page", "page", output, formName);
    this.addJavascriptSubmitLine(output, formName, formAction);

    return output.toString();
  }

  /**
   * This method will create the HTML necessary to create the opening line of a Javascript method.
   *
   * @param methodDeclaration A String representing the method name and parameters.
   */
  protected StringBuffer getOpenMethod(String methodDeclaration) {
    StringBuffer output = new StringBuffer("<script language=\"JavaScript\">");
    output.append("\n");
    output.append("<!--");
    output.append("\n");
    output.append("function ");
    output.append(methodDeclaration);
    output.append("\n");
    output.append("{");

    return output;
  }

  /**
   * This method adds the Javascript call used to submit our form.
   *
   * @param output The StringBuffer to append the submit call to.
   */
  protected void addJavascriptSubmitLine(StringBuffer output, String formName, String formAction) {
    output.append("\n");

    //BEE Set form stage before submitting
    output.append("setState('");
    output.append(formName);
    output.append("');");

    //BEE set form action before submitting.
    output.append("document.");
    output.append(formName);
    output.append(".");
    output.append(ServerSideValidationUtility.FORM_VALIDATION_URL);
    output.append(".value = '");
    output.append(formAction);
    output.append("';");
    output.append("\n");

    //End set form action before submitting
    //  JMC turn off form validation
    output.append("disableValidation('");
    output.append(formName);
    output.append("');");
    output.append("\n");

    output.append("document.");
    output.append(formName);
    output.append(".submit();");

    //close out the method
    output.append("\n");
    output.append("}");
    output.append("\n");
    output.append("//-->");
    output.append("\n");
    output.append("</script>");
  }

  /**
   * This method adds the Javascript call used to set a value to a field.
   *
   * @param field  The field name to set the value to.
   * @param value  The value to set to the field.
   * @param output The StringBuffer to append this call to.
   */
  protected void addJavascriptSetFieldValue(String field, String value, StringBuffer output, String formName) {
    output.append("\n");
    output.append("document.");
    output.append(formName);
    output.append(".");
    output.append(field);
    output.append(".value = ");
    output.append(value);
    output.append(";");
  }

  /**
   * Helper method to create an empty results object.
   *
   * @return DatabaseResultsInfo an empty results info object
   */
  public DatabaseResultDetails createEmptyResultsInfo() {
    DatabaseResultDetails resultsInfo = new DatabaseResultDetails();
    resultsInfo.setNumberOfResults(ResultsPaginationHelper.DEFAULT_NUMBER_OF_RESULTS);
    resultsInfo.setRequestedPage(ResultsPaginationHelper.DEFAULT_REQUESTED_PAGE);
    resultsInfo.setResultsPerPage(ResultsPaginationHelper.DEFAULT_RESULTS_PER_PAGE);

    return resultsInfo;
  }

  /**
   * Helper method to set the range of pages to be outputted.
   *
   * @param buffer      the buffer to write the text to
   * @param resultsInfo the DatabaseResultDetails object that contains the details to display
   */
  protected void populatePageNumbers(StringBuffer buffer, DatabaseResultDetails resultsInfo) throws IOException {
    int currentPage = resultsInfo.getRequestedPage();
    int maxPage = resultsInfo.getNumberOfResultPages();

    int topLimitation = this.getTopLimitation(maxPage, currentPage);

    int bottomLimitation = this.getBottomLimitation(maxPage, currentPage, topLimitation);

    for (int i = bottomLimitation; i <= topLimitation; i++) {
      // Check to make sure we're in the right range as our calculations prior may throw off the results
      if ((i > 0) && (i <= maxPage)) {
        this.getPageOutput(buffer, i, currentPage);
      }
    }
  }

  /**
   * This method will obtain the top limitation for the page links.  If the bottom limitation is constrained due to the
   * current page being close to #1 then the top limitation will be extended so that 10 page options will be displayed
   * (if the top limitation is not limited from extending by the maximum number of pages).
   *
   * @param maxPage     The last page of results
   * @param currentPage The page the use is currently viewing
   */
  protected int getTopLimitation(int maxPage, int currentPage) {
    //Determine the range to run
    int halfOfRange = ResultsPaginationHelper.DEFAULT_NUMBER_OF_PAGE_LINKS / 2;
    int bottomLimitation = Math.max(1, (currentPage - halfOfRange));
    int topLimitation = Math.min(maxPage, (currentPage + halfOfRange));

    // If we hit 1, then add whatever leftovers we have to the top limitation so we still display
    // <DEFAULT_NUMBER_OF_PAGE_LINKS> page options (if possible).
    if ((bottomLimitation == 1) && ((currentPage - halfOfRange) != 1)) {
      topLimitation += (halfOfRange - 1 - (currentPage - 1));
    }

    return topLimitation;
  }

  /**
   * This method will obtain the bottom limitation for the page links.  If the top limitation is constrained due to the
   * current page being close to the maximum number of pages then the bottom limitation will be extended so that 10 page
   * options will be displayed (if the bottom limitation is not limitted from extending by being too close to the first
   * page (#1).
   *
   * @param maxPage       The last page of results
   * @param currentPage   The page the use is currently viewing
   * @param topLimitation The top limitation as calculated in the getTopLimitation method
   */
  protected int getBottomLimitation(int maxPage, int currentPage, int topLimitation) {
    //Determine the range to run
    int halfOfRange = ResultsPaginationHelper.DEFAULT_NUMBER_OF_PAGE_LINKS / 2;
    int bottomLimitation = Math.max(1, (currentPage - halfOfRange + 1));

    // If we hit the max, then subtract whatever leftovers we have to the bottom limitation
    // so we still display <DEFAULT_NUMBER_OF_PAGE_LINKS> page options (if possible).
    if (topLimitation == maxPage) {
      bottomLimitation -= (halfOfRange - (maxPage - currentPage));
    }

    return bottomLimitation;
  }

  /**
   * This helper method actually generates the link for a specific page.
   *
   * @param buffer      the buffer to write the text out.
   * @param page        the page to output
   * @param currentPage the page the user is currently viewing.
   */
  protected void getPageOutput(StringBuffer buffer, int page, int currentPage) throws IOException {
    String pageString = String.valueOf(page);

    if (page != currentPage) {
      String output = this.generateLinkHtml(pageString, pageString);
      this.appendLine(buffer, output);
    } else {
      this.appendLine(buffer, pageString);
    }
  }

  /**
   * Generates a String representing the link for a specific page on the page selection bar.
   *
   * @param pageNumber the page number to use in the link
   * @param display    the display String that the user will see for the link
   */
  protected String generateLinkHtml(String pageNumber, String display) {
    return generateLinkHtml(pageNumber, display, null);
  }

  /**
   * Generates a String representing the link for a specific page on the page selection bar.
   *
   * @param pageNumber the page number to use in the link
   * @param display    the display String that the user will see for the link
   * @param onClick    the onClick event command for this link
   */
  protected String generateLinkHtml(String pageNumber, String display, String onClick) {
    StringBuffer buffer = new StringBuffer(ResultsPaginationHelper.JAVASCRIPT_METHOD_CALL_LINK);

    buffer.append("'");
    buffer.append(pageNumber);
    buffer.append("')\"");
    // if there is an onClick string provided, use it; otherwise, just close the tag
    buffer.append((onClick == null || "".equals(onClick)) ?
                  "" :
                  " onClick=\"" + onClick + "\"");
    // set the tabindex of the link to -1, to remove it from the tab order
    buffer.append(" tabindex=\"-1\">");
    buffer.append(display);
    buffer.append("</a>");

    return buffer.toString();
  }

  /**
   * This method returns a StringBuffer that starts the creation of a table. The HTML it generates ix reused in a couple
   * of places in this class.
   *
   * @return buffer the StringBuffer with the start of the table written to it.
   */
  protected StringBuffer getTableHeaderBuffer() {
    StringBuffer buffer = new StringBuffer("<table cellspacing=\"");
    buffer.append(ResultsPaginationHelper.TABLE_CELL_SPACING);
    buffer.append("\" cellpadding=\"");
    buffer.append(ResultsPaginationHelper.TABLE_CELL_PADDING);
    buffer.append("\" width=\"");
    buffer.append(ResultsPaginationHelper.TABLE_WIDTH);
    buffer.append("%\" border=\"");
    buffer.append(ResultsPaginationHelper.TABLE_BORDER);
    buffer.append("\">");
    buffer.append("\n");
    this.appendLine(buffer, "<tr>");
    this.appendLine(buffer, "<td align=right colspan=\"2\">");
    return buffer;
  }

  protected String getTableFooter() {
    return "</td></tr></table>";
  }

  /**
   * Helper method to append the string value to a buffer along with a line break.
   *
   * @param buffer the StringBuffer to append the text to
   * @param value  the text to append, followed by a line break
   */
  protected void appendLine(StringBuffer buffer, String value) {
    buffer.append(value);
    buffer.append("\n");
  }
}
