package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.ArrayList;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class CaseMnt_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");

//*  JSP Name:     CaseMnt
//*  Created by:   Merle Demo
//*  Date Created: 12/16/2002
//*
//*  Description:* In combines the old ccmn62w.win and ccmn74w.win.
//*           Allows an authorized user to change the name of the
//*               case and and/or its stages. Whenever the name of the case is
//*               changed, all stages of service within that case will also
//*               be changed (except any SUB,ADO, PAL, and PAD stages). If the
//*               selected stage of service is in the list above and the Change
//*               Name window is called, only that stage will be changed.
//*          The Change County window allows the user to change the
//*               county of a stage.  It also changes the county on the
//*               CAPS_CASE table.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**

      out.write("\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n");
 /* Import State Management classes - Should be on every page */ 
      out.write("\r\n\r\n\r\n");
 /* Import PageMode and other utilities used on the page - Should be on every page */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  String pageMode = PageModeConstants.VIEW;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  if (GlobalData.getAppMode(request) != null)
  {
    pageMode = GlobalData.getAppMode(request);
  }

  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  }
  /* Everything above this point should be in EVERY PAGE. *****************************************************************/

      out.write('\r');
      out.write('\n');

  // Get the CCMN85SO output object out of the request
  CCMN85SO ccmn85so = (CCMN85SO)state.getAttribute("CCMN85SO", request);

  // Initialize the row and array objects
  if ( ccmn85so == null )
  {
    ccmn85so = new CCMN85SO();
  }



  //Declare and initialize display variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

  //Initialize the variables that will specify the display rules for individual fields
  String selCdStageCnty = "";
  String txtDecodeStageCnty = "";
  SzNmPersonFull_ARRAY  stageNamesArray = null;

  //Load array for the New Name of the case
  if(ccmn85so.getSzNmPersonFull_ARRAY() != null )
  {
     stageNamesArray = ccmn85so.getSzNmPersonFull_ARRAY();
  }

  if(state.getAttribute("txtDecodeStageCnty",request) != null)
  {
    txtDecodeStageCnty = (String)state.getAttribute("txtDecodeStageCnty",request);
  }

  Map peopleNames = (Map)state.getAttribute("peopleNames", request);
  ArrayList excludeCCountList = new ArrayList();
  excludeCCountList.add("XXX");


      out.write("\r\n\r\n");
 /* Needed for Form Launch Custom tag */ 
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n");
 /* Start Javascript Section */ 
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\n  window.onbeforeunload = function ()\r\n  {\r\n      IsDirty();\r\n  };\r\n\r\n\r\n//End Java Script\r\n</script>\r\n");
 /* Include custom tag for displaying errors on the page */ 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
 /* Start the form - See the Form Validation Cookbook or Custom Tag list for details
    on the attributes of the validateForm tag */ 
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseMnt");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/workload/CaseMnt/displayCaseMnt");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.CaseMntCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
 /* Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page. */ 
          out.write("\r\n\r\n");
 /* Start the HTML for the page */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n</table>\r\n");
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"5\">");
          out.print(request.getAttribute( "txtLabelName" ));
          out.write("</th>\r\n  </tr>\r\n  <tr>\r\n     <td width=\"15%\">\r\n         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtNmPersonHistFull");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Current Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setWidth("20%");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(ccmn85so.getNmPersonHistFull());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td width=\"5%\">&nbsp;</td>\r\n     <td width=\"13%\">\r\n         ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setOptions(peopleNames.values());
          _jspx_th_impact_validateSelect_0.setName("selNmPersonHistFull");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setLabel("New Name");
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 180px");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n  </tr>\r\n\r\n</table>\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n      <th colspan=\"5\">Change County</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"15%\">\r\n         ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtDecodeStageCnty");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Current County");
          _jspx_th_impact_validateDisplayOnlyField_1.setWidth("20%");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(txtDecodeStageCnty);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"5%\">&nbsp;</td>\r\n     <td width=\"13%\">\r\n         ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setValue(selCdStageCnty);
          _jspx_th_impact_validateSelect_1.setName("selCdStageCnty");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setExcludeOptions(excludeCCountList);
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 180px");
          _jspx_th_impact_validateSelect_1.setLabel("New County");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n    <td width=\"90%\">&nbsp;</td>\r\n    <td class=\"alignRight\" width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseMnt");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/CaseMnt/saveCaseMnt");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
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
}
