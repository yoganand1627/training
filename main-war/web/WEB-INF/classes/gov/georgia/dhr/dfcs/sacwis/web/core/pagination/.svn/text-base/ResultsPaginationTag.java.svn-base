package gov.georgia.dhr.dfcs.sacwis.web.core.pagination;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.BaseHtmlTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag;

/**
 * This class will create the navigation bar for navigating multiple pages of return results.  It will output the
 * current set of results being viewed out of the total and allow the user to navigate to the previous or next page as
 * well as jump to any page.  This tag will utilize the ResulsPaginationHelper which contains most of the complicated
 * logic for this tag.
 *
 * @author Randy O'Neil, October 12, 2001
 */
public class ResultsPaginationTag extends TagSupport {

  /**
   * Required input value for this tag
   *
   * @param submitUrl DOCUMENT ME!
   */
  public void setSubmitUrl(String submitUrl) {
    this.submitUrl = submitUrl;
  }

  /**
   * Optional input value for this tag.
   *
   * @param saveState DOCUMENT ME!
   */
  public void setSaveState(String saveState) {
    Boolean save = new Boolean(saveState);
    this.saveState = save;
  }

  /**
   * Optional input value for this tag.
   *
   * @param addSelected DOCUMENT ME!
   */
  public void setAddSelected(String addSelected) {
    this.addSelected = addSelected;
  }

  /**
   * Optional input value for this tag.
   *
   * @param onClickPrev the javascript command to execute for the onClick event of the "Previous" button
   */
  public void setOnClickPrev(String onClickPrev) {
    this.onClickPrev = onClickPrev;
  }

  /**
   * Optional input value for this tag.
   *
   * @param onClickNext the javascript command to execute for the onClick event of the "Next" button
   */
  public void setOnClickNext(String onClickNext) {
    this.onClickNext = onClickNext;
  }

  /**
   * This method creates the HTML output for navigating a number of database result pages.  This output appears above
   * the results.
   *
   * @return int A constant value defining whether or not to display the body contained in this tag.
   * @throws JspException DOCUMENT ME!
   */
  public int doStartTag()
          throws JspException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
      JspWriter out = pageContext.getOut();
      HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
      Object temporaryObject = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

      FormTag parent = BaseHtmlTag.getParentFormTag(pageContext.getRequest(), this);
      this.formName = parent.getName();

      if (temporaryObject != null &&
          temporaryObject instanceof BasePaginationValueBean) {
        BasePaginationValueBean bean = (BasePaginationValueBean) temporaryObject;
        this.databaseResultDetails = bean.getResultDetails();
      } else {
        this.databaseResultDetails = helper.createEmptyResultsInfo();
      }
      String form = helper.getFormOutput(submitUrl, databaseResultDetails);
      out.write(form);

      databaseResultDetails.createUrl(submitUrl);

      printPagination(out, request);

      if (this.saveState) {
        Map parameters = databaseResultDetails.getUrlParameters();
        String parameterFields = helper.getParameterFields(parameters,
                                                           request,
                                                           false);
        out.write(parameterFields);
        out.write("<impact:validateInput type=\"hidden\" name=\"" + HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY +
                  "\"/> ");
      }

      return EVAL_BODY_INCLUDE;
    }
    catch (IOException e) {
      throw new JspException(e);
    }
  } // doStartTag()

  /**
   * This method creates the HTML output for navigating a number of database result  pages. This output appears below
   * the results.
   *
   * @return int A constant value defining whether or not to display the body of  contained in this tag.
   * @throws JspException DOCUMENT ME!
   */
  public int doEndTag()
          throws JspException {
    GrndsTrace.enterScope(ResultsPaginationTag.TRACE_TAG + ".doEndTag");
    JspWriter out = pageContext.getOut();
    try {
      HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
      printPagination(out, request);

      if (addSelected != null) {
        int i = addSelected.indexOf(",");
        int j = addSelected.length();
        int totalListSize = new Integer(addSelected.substring(0, i));
        String form = addSelected.substring(i + 1, j);
        String checkedListJavascript = helper.getCheckedListJavascript(totalListSize, form, this.submitUrl);
        out.write(checkedListJavascript);
        out.write(helper.getSetOrderMethod(this.formName, this.submitUrl));
      } else {
        out.write(helper.getJavascript(this.formName, this.submitUrl));
      }
    }
    catch (IOException ex) {
      throw new JspException("Exception generating Pagination details for database results" +
                             "from ResultsPaginationTag in doEndTag(), see details: \n" + ex.getMessage(), ex);
    }

    GrndsTrace.exitScope();
    return TagSupport.EVAL_PAGE;
  }

  protected void printPagination(JspWriter out,
                                 HttpServletRequest request)
          throws IOException {
    int pageValue = databaseResultDetails.getRequestedPage();
    int maxPage = databaseResultDetails.getNumberOfResultPages();

    if ((pageValue > 1) &&
        (pageValue > maxPage)) {
      out.write(helper.getMaxOutputOptions(pageValue));
    } else if (ResultsPaginationHelper.showPreviousNext(databaseResultDetails)) {
      out.write(helper.getOutputOptions(databaseResultDetails, onClickPrev, onClickNext));
    }
  }

  // static constants
  private static final String TRACE_TAG = "ResultsPaginationTag"; //for tracing
  // instance variables
  private String submitUrl;
  private String addSelected;
  private boolean saveState = false;
  private String formName;
  private DatabaseResultDetails databaseResultDetails;
  private ResultsPaginationHelper helper = new ResultsPaginationHelper();
  private String onClickPrev = null;
  private String onClickNext = null;
}
