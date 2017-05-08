package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceORSSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceDetailConversation;

public final class ResourceORSSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/*
 * JSP Name:     ResourceORSSearch.jsp
 * Created by:   ssubram
 * Date Created: 03/12/08
 *
 * Description:
 * This page allows a user to search for ORS resources in the Database by searching on
 * a Name, Facility ID or Legal Name.
 *
 *  Change History:
 *  Date      User              Description
 *  --------  ----------------  --------------------------------------------------
 *  03/12/06  ssubram           Initial Code 
 */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  ResourceORSSearchValueBean bean = new ResourceORSSearchValueBean();
  String resourceName = "";
  String facilityID = "";
  String legalName = "";
  String errorMessage = "";
  String destinationUrl = "";
    
  int tabIndex = 1;
  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  if( state.getAttribute( "checkedResources", request) != null )
  {
    state.removeAttribute( "checkedResources", request );
  }

  //Determine if an error message has been set for this page
  if( request.getAttribute( "errorMessage" ) != null )
  {
    errorMessage = (String)request.getAttribute( "errorMessage" );
    request.removeAttribute( "errorMessage" );
  }

  if( request.getAttribute( "destinationUrl" ) != null )
  {
    destinationUrl = (String)request.getAttribute( "destinationUrl" );
  }
  else if (request.getParameter( "destinationUrl" ) != null )
  {
    destinationUrl = request.getParameter( "destinationUrl" );
  }

//In case of validation failure, get values entered for dynamically populated drop downs and radio buttons to redisplay values previously entered

  if( request.getParameter("requestFromListPage") == null )
  {
    if(request.getParameter("txtResourceName")!=null){ resourceName = request.getParameter("txtResourceName");}
    if(request.getParameter("txtFacilityId")!=null){ facilityID = request.getParameter("txtFacilityId");}
    if(request.getParameter("txtLegalName")!=null){ legalName = request.getParameter("txtLegalName");}
  }
  //Get all search parameters entered previously on page for refining search
  else if( request.getAttribute( "searchBean" ) != null )
  {
    bean = (ResourceORSSearchValueBean)request.getAttribute( "searchBean" );
    if(bean.getResourceName()!=null){resourceName = bean.getResourceName();}
    if(bean.getFacilityID()!=null){facilityID = bean.getFacilityID();}
    if(bean.getLegalName()!=null){legalName = bean.getLegalName();}

    if(request.getParameter("destinationUrl")!=null ){
       destinationUrl = request.getParameter("destinationUrl");
    }
  }
  String personId = String.valueOf( userProfile.getUserID() );

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction()\r\n{\r\n  /** If an error message is received that is not from the validation framework make sure\r\n   *  on the second submit the form is submitted for validation */\r\n\r\n  ");
if( !"".equals(errorMessage) )
    {
      out.write("\r\n      document.frmResourceORSSearch.action = \"/resource/ResourceORSSearch/default\";\r\n  ");
}
      out.write("\r\n\r\n  setFocus();\r\n\r\n}\r\n\r\n//set the initial focus of the page\r\nfunction setFocus()\r\n{\r\n  document.frmResourceORSSearch.txtResourceName.focus();\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmResourceORSSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceORSSearch/results");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceORSSearchValidation");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n     <tr>\r\n      <th colspan=\"4\">Resource Details\r\n      </th>\r\n     </tr>\r\n     <tr>\r\n      <td colspan=\"4\" class=\"formInstruct\">When conducting a ORS resource search, one of the following must be entered: Resource Name, Facility ID or Legal Name.</td>\r\n     </tr>\r\n     <tr>\r\n      <td width=\"20%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setValue(resourceName);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtResourceName");
          _jspx_th_impact_validateInput_0.setLabel("Resource Name");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setSize("50");
          _jspx_th_impact_validateInput_0.setMaxLength("50");
          _jspx_th_impact_validateInput_0.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n      <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setValue(facilityID);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setName("txtFacilityId");
          _jspx_th_impact_validateInput_1.setLabel("Facility ID");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setMaxLength("16");
          _jspx_th_impact_validateInput_1.setSize("16");
          _jspx_th_impact_validateInput_1.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n      <tr>\r\n       <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setValue(legalName);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("txtLegalName");
          _jspx_th_impact_validateInput_2.setLabel("Legal Name");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setSize("80");
          _jspx_th_impact_validateInput_2.setMaxLength("80");
          _jspx_th_impact_validateInput_2.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n      </tr>\r\n    </table>\r\n\t<br>\r\n\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"0\">\r\n\t  <tr>\r\n\t    <td valign=\"top\" align=\"right\">\r\n\t      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmResourceORSSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceORSSearch/results");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t    </td>\r\n\t  </tr>\r\n\t</table>\r\n  <!-- <input type=\"hidden\" name=\"advSearchExpanded\" value=\"<!%=request.getParameter( \"advSearchExpanded\" )%>\">  -->\r\n  <input type=\"hidden\" name=\"");
          out.print(DatabaseResultDetails.RESULTS_PER_PAGE_NAME);
          out.write("\" value=\"25\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"destinationUrl\" value=\"");
          out.print(destinationUrl);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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
    _jspx_th_impact_validateErrors_0.setFormName("frmResourceORSSearch");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
