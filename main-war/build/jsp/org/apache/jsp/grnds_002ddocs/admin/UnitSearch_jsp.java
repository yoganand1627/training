package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.UnitMaintConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class UnitSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**
 * JSP Name:     UnitSearch.jsp
 * Created by:   Paul Lang
 * Date Created: 11/01/02
 *
 * Description:
 * The Unit Maintenance Search page allows users with unit maintenance
 * responsibility to search for and select a unit in order to view or maintain
 * unit and member information on the Unit Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  ----------------------------------------------
  11/01/02  Paul Lang         Created Document
  08/01/03  Todd Reser        Modifed Change Log and Flowerbox Comments.
  09/02/03  A.Corley          SIR REG81 Make the Unit input field have a maxlength of 2
*/

      out.write("\r\n\r\n\r\n\r\n");

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 // Import State Management classes

      out.write("\r\n\r\n\r\n\r\n");
// Import PageMode and other utilities used on the page

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
// Import needed for Messages

      out.write("\r\n\r\n\r\n");
// Import needed for Form Launch

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//Set the page mode
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request ) != null )
  {
    pageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
  }

  // Get the CCMN24SO output object out of the request
  CCMN24SO ccmn24so = (CCMN24SO) request.getAttribute("CCMN24SO");

  // Initialize the row and array objects
  ROWCCMN24SOG01_ARRAY memberInfoRowArray = null;

  // Null catch for cres03so, if null set to blank (initialize)
  if ( ccmn24so == null )
  {
    ccmn24so = new CCMN24SO();
  }

  // Null catch for ROW objects, if not null get rows
  if ( ccmn24so.getROWCCMN24SOG01_ARRAY() != null )
  {
    memberInfoRowArray = ccmn24so.getROWCCMN24SOG01_ARRAY();
  } else
  {
    memberInfoRowArray = new ROWCCMN24SOG01_ARRAY();
  }

  //Declare and initialize control variables for the page
  String szCReqFuncCd = "";

  //Initialize the variables that will specify the display rules for individual fields
  String phoneTypeDisabled = "false";

  /* Assign tab-index */
  int tabIndex = 1;

  //Using variables passed in on the request, set the display for the page
  if( request.getParameter("cReqFuncCd") != null )
  {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

  UserProfile user = UserProfileHelper.getUserProfile( request );
  
  boolean disableAdd = true;
  String enableAdd = (String) request.getAttribute(UnitMaintConversation.ENABLE_ADD);
  if ( ArchitectureConstants.Y.equals(enableAdd)){
    disableAdd = false;
  }
  

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
 /* Start the form */ 
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmUnitSearch");
      _jspx_th_impact_validateForm_0.setDefaultButton( String.valueOf(disableAdd) );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/UnitMaint/searchUnit");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n <input type=\"hidden\" name=\"UlIdUnit\" >\r\n\r\n");
 // Get the users county and region
  String county = user.getUserCounty() != null ? user.getUserCounty() : "";
  String region = user.getUserRegion() != null ? user.getUserRegion() : "";
  String unit = user.getUserUnit() != null ? user.getUserUnit() : "";

          out.write("\r\n\r\n");
 // Begin Detail

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Unit Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setName("cboSzCdUnitCounty");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setDisabled( phoneTypeDisabled );
          _jspx_th_impact_validateSelect_0.setValue( county );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\"/>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setLabel("Region/Division");
          _jspx_th_impact_validateSelect_1.setName("cboSzCdUnitRegion");
          _jspx_th_impact_validateSelect_1.setCodesTable("CREGDIV");
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setDisabled( phoneTypeDisabled );
          _jspx_th_impact_validateSelect_1.setValue( region );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setConstraint("AlphaNumeric2Unit");
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtSzScrNbrUnitParent");
          _jspx_th_impact_validateInput_0.setLabel("Unit");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setSize("2");
          _jspx_th_impact_validateInput_0.setMaxLength("2");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setValue( unit );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
 // Include buttons for performing actions on the page

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddunit");
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmUnitSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/UnitMaint/displayUnitDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setDisabled( String.valueOf(disableAdd) );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\" width=\"5%\">\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSearch");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_1.setForm("frmUnitSearch");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/UnitMaint/searchUnit");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n\r\n");
 // Dynamically populating table to hold the results returned from the search.

          out.write('\r');
          out.write('\n');

  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
  

          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborderList\">\r\n    <tr>\r\n      <th class=\"thList\" >Unit</th>\r\n      <th class=\"thList\" >Unit Approver</th>\r\n      <th class=\"thList\" >Specialization</th>\r\n      <th class=\"thList\" >Parent Unit</th>\r\n    </tr>\r\n    \r\n    ");
 Enumeration e = memberInfoRowArray.enumerateROWCCMN24SOG01();
       int loopCount = 0;
       String rowCss = null;
       if (!e.hasMoreElements())
     { 
          out.write("   \r\n         <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n                <td colspan=\"10\">");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ));
          out.write("</td>\r\n         </tr>\r\n  ");

  } else{
    //if( e.hasMoreElements() )
    //
     while ( e.hasMoreElements() )
      {
       ROWCCMN24SOG01 memberInfoRow = (ROWCCMN24SOG01) e.nextElement();
       rowCss = FormattingHelper.getRowCss( loopCount + 1 );
       loopCount++;
   
          out.write("\r\n\r\n   <tr class=\"");
          out.print( rowCss );
          out.write("\">\r\n     <td>\r\n     ");
 int idUnit = memberInfoRow.getUlIdUnit();
        String nbrUnit = memberInfoRow.getSzNbrUnit();
        if(idUnit >= 0 && nbrUnit != null){
     
          out.write("\r\n       <a href=\"/admin/UnitMaint/displayUnitDetail?ulIdUnit=");
          out.print( memberInfoRow.getUlIdUnit() );
          out.write("\" >\r\n         ");
          out.print( memberInfoRow.getSzNbrUnit());
          out.write("\r\n       </a>\r\n     ");
 } else{ 
          out.write("\r\n       &nbsp;\r\n     ");
 } 
          out.write("\r\n     </td>\r\n     <td>\r\n       ");
          out.print( memberInfoRow.getSzNmPersonFull() != null ? memberInfoRow.getSzNmPersonFull() : "" );
          out.write("\r\n     </td>\r\n     <td>\r\n     ");
 if(memberInfoRow.getSzCdUnitSpecialization() != null){ 
          out.write("\r\n       ");
          out.print( ( memberInfoRow.getSzCdUnitSpecialization().length() != 0 ) ? Lookup.simpleDecode( CodesTables.CSPCUNTS, memberInfoRow.getSzCdUnitSpecialization() ) : "" );
          out.write("\r\n     ");
 } else{ 
          out.write("\r\n       ");
          out.print( "" );
          out.write("\r\n     ");
 } 
          out.write("\r\n     </td>\r\n     <td>\r\n       ");
          out.print( memberInfoRow.getSzScrNbrUnitParent() != null ? memberInfoRow.getSzScrNbrUnitParent() : "" );
          out.write("\r\n     </td>\r\n   </tr>\r\n");

  }
 }
} 

          out.write("\r\n</table>\r\n");
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
