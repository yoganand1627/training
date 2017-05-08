package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.admin.VendorStaffListConversation;

public final class VendorStaffList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


/**  JSP Name:     Vendor Staff List
  *  Created by:   Patrick Coogan
  *  Date Created: October 2009
  *
  *  Description:
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/10/09    Patrick Coogan    Created page to support administrative functions of the
  *                                SHINES Vendor Portal.  
  */


      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String PORTAL_STAFF_LIST = "portalActive";
  String PORTAL_PENDING_STAFF_LIST = "portalPending";
  //Note: the following are only used in SHINES
  String SHINES_STAFF_LIST = "shinesActive";
  String SHINES_PENDING_STAFF_LIST = "shinesPending";
  String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //HttpServletRequest request = context.getRequest();
  //Set the page mode
  //String pageMode =  (String) request.getAttribute("pageMode" );//PageModeConstants.VIEW;
   String pageMode = PageMode.getPageMode(request);
  
     // create the output object
    RetrieveVendorStaffListSO retrieveVendorStaffListSO = ( RetrieveVendorStaffListSO ) request.getAttribute( "retrieveVendorStaffListSO" );
  
     //initialize the array
    List<RetrieveVendorStaffListBean> retrieveVendorStaffList = new ArrayList<RetrieveVendorStaffListBean>();
     //null catch
    if ( retrieveVendorStaffListSO == null )
    {
      retrieveVendorStaffListSO = new RetrieveVendorStaffListSO() ;
    }
     //null catch for row objects, if not null, get rows
    if ( retrieveVendorStaffListSO.getVendorStaffList() != null )
    {
      retrieveVendorStaffList = retrieveVendorStaffListSO.getVendorStaffList();
    }
    
    String screenName = (String) request.getAttribute( "screenName" );

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  UserProfile user = UserProfileHelper.getUserProfile ( request );
  

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function displayVendorStaffDetail(idUser) {\r\n    document.frmVendorStaffListList.hdnUlIdUser.value = idUser;\r\n    submitValidateForm(\"frmVendorStaffListList\", \"/admin/VendorStaffDetail/displayVendorStaffDetail\");\r\n  }\r\n  function displayPendingVendorStaffDetail(idUser) {\r\n    document.frmVendorStaffListList.hdnUlIdUser.value = idUser;\r\n    submitValidateForm(\"frmVendorStaffListList\", \"/admin/VendorStaffDetail/displayPendingVendorStaffDetail\");\r\n  }  \r\n</script>\r\n  \r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmVendorStaffListList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/VendorStaffList/displayVendorStaffList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnScrNm");
          _jspx_th_impact_validateInput_1.setValue(screenName);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 // begin pagination

  TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request.getAttribute(
          PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

  if (tuxPagination != null) {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  } else {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(20); 
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
  }
  

          out.write("\r\n\r\n");

//SIR 19651 - set url based on if it is in resource or search context.  This
//will allow for the correct screen definitions to be loaded.  Case context
//should show Case Name, Resource context should show Resource Name
String submitUrl = "";

if (PORTAL_STAFF_LIST.equals(screenName)){
submitUrl="/admin/VendorStaffList/displayVendorStaffList";
} else {
submitUrl="/admin/VendorStaffList/displayPendingVendorStaffList";
}

          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl(submitUrl);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\">\r\n<div class=\"formInstruct\">Scroll for more information --></div>\r\n</div>\r\n<div id=\"scrollBar2\" style=\"height:210px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\r\n       ");
              out.write("\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"150%\" >\r\n         <tr>\r\n             <th class=\"thList\">Name</th>\r\n             <th class=\"thList\">User Type</th>\r\n             <th class=\"thList\">Resource Name</th>\r\n             <th class=\"thList\">Resource ID</th>\r\n             <th class=\"thList\">Status</th>\r\n             <th class=\"thList\">Start</th>\r\n             <th class=\"thList\">End</th>\r\n             <th class=\"thList\">E-mail</th>\r\n             <th class=\"thList\">Phone</th>        \r\n         </tr>\r\n              \r\n");
 // within the table, display the data
     
     if (retrieveVendorStaffList.isEmpty()){

              out.write("     \r\n              <tr class=\"odd\">\r\n                 <td colspan=\"7\">\r\n                  ");
              out.print(  MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n                 </td>\r\n              </tr>\r\n     \r\n       \r\n");

   }  // else there is a least one row.  While there are more rows, create a new rows and display the data
else
{
   for (Iterator<RetrieveVendorStaffListBean> it = retrieveVendorStaffList.iterator(); it.hasNext();) {               
        RetrieveVendorStaffListBean resource = it.next();


              out.write("\r\n         <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"center\">\r\n         \r\n           <td>\r\n\t           ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_0.setTest((screenName.equals(PORTAL_STAFF_LIST)) );
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t           <a href=\"javascript:displayVendorStaffDetail('");
                  out.print(FormattingHelper.formatString(String.valueOf(resource.getUlIdUser())));
                  out.write("')\">");
                  out.print(FormattingHelper.formatString(resource.getSzStaffName()));
                  out.write("</a>\r\n\t           ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t           ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_1.setTest((screenName.equals(PORTAL_PENDING_STAFF_LIST)) );
              int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
              if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t           <a href=\"javascript:displayPendingVendorStaffDetail('");
                  out.print(FormattingHelper.formatString(String.valueOf(resource.getUlIdUser())));
                  out.write("')\">");
                  out.print(FormattingHelper.formatString(resource.getSzStaffName()));
                  out.write("</a>\r\n\t           ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\t           \r\n           </td>\r\n                   \r\n                <td>\r\n                ");
              out.print(Lookup.simpleDecodeSafe("CUSRTYP", FormattingHelper.formatString(resource.getCdUserType())));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print(FormattingHelper.formatString(resource.getSzNmResource()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print(FormattingHelper.formatLong(resource.getUlIdResource()));
              out.write("\r\n                </td>\r\n                 <td> ");
              out.print(Lookup.simpleDecodeSafe("CUSRSTAT", FormattingHelper.formatString(resource.getCdStatus())));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print(FormattingHelper.formatDate(resource.getDtStart()));
              out.write("\r\n                </td>\r\n                 ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_2.setTest( (resource.getDtEnd()!=null));
              int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
              if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                <td>\r\n                ");
                  out.print(FormattingHelper.formatDate(resource.getDtEnd()));
                  out.write("\r\n                </td>\r\n                ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_3.setTest((resource.getDtEnd()==null) );
              int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
              if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                <td>\r\n                &nbsp;\r\n                </td>\r\n                ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                <td>\r\n                ");
              out.print(FormattingHelper.formatString(resource.getSzStaffEmail() != null ? resource.getSzStaffEmail() : ""));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print(FormattingHelper.formatPhone(resource.getNbrStaffPhone() != null ? resource.getNbrStaffPhone(): ""));
              out.write("\r\n                </td>\r\n          </tr>\r\n         ");
// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          
              out.write("\r\n\r\n        </table>\r\n  \r\n </div>\r\n ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write(' ');
          out.write("\r\n<br/>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnUlIdUser");
    _jspx_th_impact_validateInput_0.setValue("-1");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
