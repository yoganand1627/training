package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.FacAgencyHomesListConversation;

public final class FacAgencyHomesList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**  JSP Name:     Facility/Agency - Homes List
  *  Created by:   Patrick Coogan   
  *  Date Created: Octoberish 2009
  *
  *  Description:
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  11/09/09    Patrick Coogan    Updated comments.
  */


      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String pageMode = PageMode.getPageMode(request);

     // create the output object
    RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesListSO = ( RetrieveFacAgencyHomesListSO ) request.getAttribute( "retrieveFacAgencyHomesListSO" );
  
     //initialize the array
    List<RetrieveFacAgencyHomesListBean> retrieveFacAgencyHomesList = new ArrayList<RetrieveFacAgencyHomesListBean>();
     //null catch
    if ( retrieveFacAgencyHomesListSO == null )
    {
      retrieveFacAgencyHomesListSO = new RetrieveFacAgencyHomesListSO() ;
    }
     //null catch for row objects, if not null, get rows
    if ( retrieveFacAgencyHomesListSO.getFacilityAgencyList() != null )
    {
      retrieveFacAgencyHomesList = retrieveFacAgencyHomesListSO.getFacilityAgencyList();
    } 

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  UserProfile user = UserProfileHelper.getUserProfile ( request );

      out.write("\r\n<script language=\"JavaScript\">\r\nfunction displayChildList( idResource )\r\n{\r\n  if ((document.frmFacAgencyHomesList.hdnUlIdRsrcParent.value == \"\")||(document.frmFacAgencyHomesList.hdnUlIdRsrcParent.value == \"0\")) {\r\n     document.frmFacAgencyHomesList.hdnUlIdRsrcParent.value = idResource;\r\n  } else {\r\n     document.frmFacAgencyHomesList.hdnUlIdRsrcChild.value = idResource;\r\n  }\r\n  \r\n  disableValidation('frmFacAgencyHomesList');\r\n  submitValidateForm( \"frmFacAgencyHomesList\", \"/workload/PortalChildList/displayChildList\" );\r\n}\r\n</script>\r\n\r\n  ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFacAgencyHomesList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/FacAgencyHomesList/displayFacAgencyHomesList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
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


String submitUrl = "";

if (!("".equals(GlobalData.getUlIdParentRsrcAsString(request)))&&!("0".equals(GlobalData.getUlIdParentRsrcAsString(request)))){
submitUrl="/resource/FacAgencyHomesList/displayHomesList";
} else {
submitUrl= "/resource/FacAgencyHomesList/displayFacAgencyList";
}

          out.write("\r\n<input type=\"hidden\" name=\"hdnUlIdResource\" value=\"\" />\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl(submitUrl);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\">\r\n  <div class=\"formInstruct\">Scroll for more information --></div>\r\n</div>\r\n<div id=\"scrollBar2\" style=\"height:210px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\r\n       ");
              out.write("\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"150%\" >\r\n         <tr>\r\n             <th class=\"thList\">Resource Name&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy( FacAgencyHomesListConversation.SORT_NAME );
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n             <th class=\"thList\">Resource ID</th>\r\n             <th class=\"thList\">Status</th>\r\n             <th class=\"thList\">Resource Type&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy( FacAgencyHomesListConversation.SORT_TYPE );
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n             <th class=\"thList\">Type</th>\r\n             <th class=\"thList\">Address</th>\r\n             <th class=\"thList\">City&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy( FacAgencyHomesListConversation.SORT_CITY);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n             <th class=\"thList\">County&nbsp;");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy( FacAgencyHomesListConversation.SORT_COUNTY );
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n             <th class=\"thList\">Phone</th>\r\n             <th class=\"thList\">Ext</th>             \r\n         </tr>\r\n              \r\n");
 // within the table, display the data
     
     if (retrieveFacAgencyHomesList.isEmpty()){

              out.write("     \r\n              <tr class=\"odd\">\r\n                 <td colspan=\"7\">\r\n                  ");
              out.print(  MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
              out.write("\r\n                 </td>\r\n              </tr>\r\n     \r\n       \r\n");

   }  // else there is a least one row.  While there are more rows, create a new rows and display the data
else
{
   for (Iterator<RetrieveFacAgencyHomesListBean> it = retrieveFacAgencyHomesList.iterator(); it.hasNext();) {               
        RetrieveFacAgencyHomesListBean resource = it.next();


              out.write("\r\n         <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"center\">\r\n         \r\n           <td><a href=\"javascript:displayChildList('");
              out.print(FormattingHelper.formatString(String.valueOf(resource.getUlIdRsrc())));
              out.write("');\">\r\n                                                            ");
              out.print(FormattingHelper.formatString(resource.getNmResource()));
              out.write("</a></td>\r\n                   \r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatLong(resource.getUlIdRsrc()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRSCSTAT",resource.getCdStatus())));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRSCTYPE",resource.getCdrscType())));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CFACTYP4",resource.getSzCdIncRsrcType())));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(resource.getCdAddress()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(resource.getSzAddrCity()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCOUNT",resource.getCdCounty())));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatPhone(resource.get1NbrFacilPhoneNumber()));
              out.write("\r\n                </td>\r\n                <td>\r\n                ");
              out.print( FormattingHelper.formatString(resource.getlNbrPhoneExtension()));
              out.write("\r\n                </td>\r\n                \r\n          </tr>\r\n         ");
// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          
              out.write("\r\n\r\n        </table>\r\n\r\n </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         ");
          out.write("\r\n<br/>\r\n\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnUlIdRsrcParent");
          _jspx_th_impact_validateInput_0.setValue(GlobalData.getUlIdParentRsrcAsString(request));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("ulIdResource");
          _jspx_th_impact_validateInput_2.setValue( ContextHelper.getStringSafe( request, "ulIdResource" ));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("ulIdStage");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( GlobalData.getUlIdStage( request) ));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <input type=\"hidden\" name=\"");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnUlIdRsrcChild");
    _jspx_th_impact_validateInput_1.setValue("0");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
