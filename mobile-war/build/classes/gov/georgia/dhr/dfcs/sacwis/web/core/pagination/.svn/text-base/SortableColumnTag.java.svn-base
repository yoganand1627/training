package gov.georgia.dhr.dfcs.sacwis.web.core.pagination;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.BasePaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;

/**
 * This tag will create a sortable column-name link with an orderBy value that will be used in the creation of a new SQL
 * statement.  The implementation of the SQL statement in a DAO (data access object) will need to be performed by the
 * developer, and the returned values should be sorted in the newly generated table.
 */
public class SortableColumnTag extends TagSupport {

  /**
   * This parameter may be set to define a sortable column as the default sort.  This will result in the column being
   * displayed with the "sorted" icon when the page is loaded.  It also means that if someone chooses to sort by this
   * column right after the page is loaded, then it will sort in escending order.
   *
   * @param isDefault A text value equally "true" or "false"
   */
  public void setIsDefault(String isDefault) {
    if ("true".equalsIgnoreCase(isDefault)) {
      this.isDefault = true;
    }
  }

  /**
   * This parameter MUST be set to define what table column to use for the "ORDER BY" portion of the SQL statement that
   * will return the results.  This value can be retrieved in a Data Access Object from the DatabaseResultDetails object
   * in order to compose the query.
   *
   * @param orderBy The database column name to do the sort by
   */
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  /**
   * This method creates the HTML output for sorting database results in a table.
   *
   * @return int A constant value telling the page to ignore the contents of this tag
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(SortableColumnTag.TRACE_TAG + ".doStartTag");

    JspWriter out = pageContext.getOut();
    ServletRequest request = pageContext.getRequest();
    int returnValue = TagSupport.SKIP_BODY;

    BasePaginationValueBean bean;
    DatabaseResultDetails databaseResultDetails;

    Object temporaryObject = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

    if (temporaryObject != null && temporaryObject instanceof BasePaginationValueBean) {
      bean = (BasePaginationValueBean) temporaryObject;
      databaseResultDetails = bean.getResultDetails();

      if (databaseResultDetails != null) {
        try {
          out.write(this.generateHtml(databaseResultDetails));
        }
        catch (IOException ex) {
          GrndsTrace.msg(TRACE_TAG, 3,
                         "Exception generating sort link for table from ResultsPaginationTag in doStartTag()");
          throw new JspException("Exception generating sort link for table"
                                 + " from ResultsPaginationTag in doStartTag(), see details: \n" + ex.getMessage(), ex);
        }
      } else {
        throw new JspException("Exception generating orderBy link because the "
                               + "DatabaseResultDetails object is missing.");
      }
    } else {
      throw new JspException("Exception generating orderBy link because a bean "
                             + "extending BasePaginationValueBean could not be found in the HttpServletRequest");
    }
    GrndsTrace.exitScope(returnValue);
    return returnValue;
  }  // doStartTag()

  /** This required method does nothing other than to tell the page to continue evaluating the rest of the JSP page. */
  public int doEndTag() throws JspException {
    return TagSupport.EVAL_PAGE;
  }

  String createUrl(DatabaseResultDetails databaseResultDetails) {
    String oldDirection = databaseResultDetails.getOrderByDirection();
    String oldOrderBy = databaseResultDetails.getOrderBy();

    String newDirection = this.determineDirection(oldOrderBy, oldDirection);

    StringBuffer buffer = new StringBuffer();
    buffer.append("javascript:setOrderBy( '");
    buffer.append(this.orderBy);
    buffer.append("', '");
    buffer.append(newDirection);
    buffer.append("' )");

    return buffer.toString();
/*          url = this.removeOldParameter( url, this.ORDER_BY_NAME, "&" );
          url = this.removeOldParameter( url, this.DIRECTION_NAME, "&" );

          String returnValue = "";

          if( url != null )
          {
               StringBuffer buffer = new StringBuffer( url );
               buffer.append( "&" );
               buffer.append( this.ORDER_BY_NAME );
               buffer.append( "=" );
               buffer.append( this.orderBy );
               if( newDirection != null )
               {
                    buffer.append( "&" );
                    buffer.append( this.DIRECTION_NAME );
                    buffer.append( "=" );
                    buffer.append( newDirection );
               }
               returnValue = buffer.toString();
          }
          return returnValue;  */
  }

  String determineDirection(String oldOrderBy,
                            String oldDirection) {
    this.direction = ServiceConstants.SORT_ASCENDING;

    //If the user has clicked the same column, change the order
    if (oldDirection == null && this.isDefault) {
      this.direction = ServiceConstants.SORT_DESCENDING;
    } else if (this.orderBy.equals(oldOrderBy) &&
               ServiceConstants.SORT_ASCENDING.equals(oldDirection)) {
      this.direction = ServiceConstants.SORT_DESCENDING;
    }

    return this.direction;
  }

  String removeOldParameter(String url,
                            String firstItem,
                            String secondItem) {

    int indexOfFirstItem = url.indexOf("&" + firstItem);

    if (indexOfFirstItem < 0) {
      indexOfFirstItem = url.indexOf(firstItem);
    }

    if (indexOfFirstItem > 0) {
      int indexOfSecondItem = url.indexOf(secondItem, indexOfFirstItem + 1);

      StringBuffer temporaryBuffer = new StringBuffer(url);

      if (indexOfSecondItem > 0) {
        temporaryBuffer.delete(indexOfFirstItem, indexOfSecondItem);
      } else {
        temporaryBuffer.delete(indexOfFirstItem, temporaryBuffer.length());
      }

      url = temporaryBuffer.toString();
    }

    return url;
  }

  /**
   * This method will generate the actual HTML link that will go on the page.
   *
   * @param databaseResultDetails The details object to get information from
   * @throws JspException if there is an error generating the link
   */
  String generateHtml(DatabaseResultDetails databaseResultDetails)
          throws JspException {
    String html;
    String url = this.createUrl(databaseResultDetails);

    String oldOrderBy = databaseResultDetails.getOrderBy();
    //make use of image
    if ((oldOrderBy == null && this.isDefault) ||
        (oldOrderBy != null && oldOrderBy.equals(this.orderBy))) {
      html = this.createLink(url, SortableColumnTag.SORTED_IMAGE, SORTED_IMAGE_ALT);
    } else {
      html = this.createLink(url, SortableColumnTag.NOT_SORTED_IMAGE, NOT_SORTED_IMAGE_ALT);
    }

    return html;
  }

  String createLink(String url, String image, String altText) {
    StringBuffer sbLink = new StringBuffer();

    sbLink.append("<a href=\"");
    sbLink.append(url);
    sbLink.append("\" tabindex=\"-1\"><img src=\"");
    sbLink.append(image);
    sbLink.append("\" alt=\"");
    sbLink.append(altText);
    sbLink.append("\" tabindex=\"-1\" border=\"0\" hspace=\"5\"/></a>");

    return sbLink.toString();
  }

  // instance variables
  private String orderBy;
  private String direction;
  private boolean isDefault = false;

  // static constants
  public static final String ORDER_BY_NAME = "orderBy";
  public static final String DIRECTION_NAME = "orderByDirection";
  private static final String TRACE_TAG = "SortableColumnTag"; //for tracing
  private static final String SORTED_IMAGE = "/grnds-docs/images/shared/sortDescending.gif";
  private static final String NOT_SORTED_IMAGE = "/grnds-docs/images/shared/sortDescending_empty.gif";
  private static final String SORTED_IMAGE_ALT = "Sorted";
  private static final String NOT_SORTED_IMAGE_ALT = "Not Sorted";

}

