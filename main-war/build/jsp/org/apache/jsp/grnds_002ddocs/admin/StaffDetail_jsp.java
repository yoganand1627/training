package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

public final class StaffDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/person/RaceEthnicitySub.jsp");
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
 * JSP Name:     StaffDetail.jsp
 * Created by:   Jeff Chambers
 * Date Created: 10/15/02
 *
 * Description:
 * This page is used to view and maintain staff information.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  05/29/03  C Douglass        SIR 17614 - If the user doesn't have maintain
                              staff security, they shouldn't have a link on
                              start date to get to job history
  05/29/03  C Douglass        SIR 17835 - added expand all and collapse all
  06/25/03  C Douglass        remove Lead from dropdown - the only place to set
                              a lead is in unit maintenance to make sure that
                              there is always only 1 lead per unit & change to
                              only allow delete of current job history when row
                              is not confirmed by HR
  07/13/03  C Douglass        SIR 18841-corrected pendingHrmis and
                              confirmedHrmis flags
  07/21/03  C Douglass        SIR 19016 - allow users in browse mode to access
                              job history page in browse mode.
  08/01/03  Todd Reser        Modified Change Log and Flowerbox comments.
  10/02/03  C Douglass        SIR 19930 - Trying to access job history for
                              for terminated employees gives error.  Can't access
                              job history for terminated employees in CAPS, so
                              remove hyperlink.
  11/05/03  Todd Reser        SIR 22345 - Had to switch from == to .equals() so
                              the if statement would correctly compare pageMode
                              to PageMode.Edit
  3/26/04   C Douglass        SIR 22542 - added logic to make FTE% required in
                              NEW mode.
  4/7/2004  gerryc            SIR 22808 - added hidden field for the termination date
                              coming from the database.  It is compared to the term
                              date entered in the custom validation.
  3/1/2005  C Douglass        SIR 23024 - remove the ability to delete an employee
  2/27/2008 cjgerry			  STGAP00005269 - allow hire date to be modified by someone with maintain staff security
  5/8/2008  arege             STGAP00005045 - Prevent the user from clicking on the Save button multiple times. This prevents 
                              Staff(people)being created multiple times as a result of clicking save button multiple times.
*/

      out.write("\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n");

  //Set the page mode
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile( request );

  String personId = request.getParameter("hdnUlIdPerson");
  String displayType = request.getParameter("hdnDisplayType");


      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  /*\r\n  *This function is called before the page unloads. It creates the\r\n  *\"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n  function changeDisplayType()\r\n  {\r\n    frmStaffDetail.hdnDisplayType.value = \"Saved\";\r\n  }\r\n\r\n  function deleteJobHistory()\r\n  {\r\n    return confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CMN_DELETE_JOB) );
      out.write("');\r\n  }\r\n\r\n</script>\r\n\r\n");


  CCMN04SO ccmn04so = new CCMN04SO();

  if (!PageModeConstants.NEW.equalsIgnoreCase( pageMode ))
  {
    // Get the CCMN04SO output object out of the request
    ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

  }

  // Initialize the row and array objects
  ROWCCMN04SOG00 row00 = null;
  ROWCCMN04SOG01 row01 = null;
  ROWCCMN04SOG04 row04 = null;
  ROWCCMN04SOG05 row05 = null;
  ROWCCMN04SOG06 row06 = null;

  ROWCCMN04SOG02 jobDescription = null;
  String cReqFuncCd = (String) request.getAttribute("hdnCReqFuncCd");
  //String office = "";

  // Null catch for ccmn04so, if null set to blank (initialize)
  if ( ccmn04so == null )
  {
    ccmn04so = new CCMN04SO();
  }

  // Null catch for ROW objects, if not null get rows
  if ( ccmn04so.getROWCCMN04SOG00() != null )
  {
    row00 = ccmn04so.getROWCCMN04SOG00();
    //office = ccmn04so.getSzNmOfficeName();
  } else {
    row00 = new ROWCCMN04SOG00();
  }
  if ( ccmn04so.getROWCCMN04SOG01() != null )
  {
    row01 = ccmn04so.getROWCCMN04SOG01();
  } else {
    row01 = new ROWCCMN04SOG01();
  }
  if ( ccmn04so.getROWCCMN04SOG04() != null )
  {
    row04 = ccmn04so.getROWCCMN04SOG04();
  } else {
    row04 = new ROWCCMN04SOG04();
  }
  if ( ccmn04so.getROWCCMN04SOG05() != null )
  {
    row05 = ccmn04so.getROWCCMN04SOG05();
  } else {
    row05 = new ROWCCMN04SOG05();
  }
  if ( ccmn04so.getROWCCMN04SOG06() != null )
  {
    row06 = ccmn04so.getROWCCMN04SOG06();
  } else {
    row06 = new ROWCCMN04SOG06();
  }
  if ( ccmn04so.getROWCCMN04SOG02() != null )
  {
    jobDescription = ccmn04so.getROWCCMN04SOG02();
  } else {
    jobDescription = new ROWCCMN04SOG02();
  }


  String staffDetailDisabled = "false";
  String hireDateDisabled = "true";
  int tabIndex = 1;

  // If the user does not have the maintain staff security attribute
  // make the hire date field disabled 
  if (user.hasRight( UserProfile.SEC_MNTN_STAFF_GEN ) )
  {
    hireDateDisabled = "false";
  }
  else   
  {
  	//set the ssn number to blank - not used anymore
  	row05.setSzNbrPersonIdNumber("");
  }
  


  if ( ccmn04so.getROWCCMN04SOG00() != null )
  {
    hireDateDisabled = "false";

    
  }


//6/25/03 CSD - remove Lead from dropdown - the only place to set a lead is in unit maintenance
//to make sure that there is always only 1 lead per unit
//6/27/03 - also since the only place to set a lead is in unit maintenence, should not
//let the user change a lead to something else
  String roleCodeType = CodesTables.CUNMBRRL;
  String role = row04.getSzCdUnitMemberRole();
  boolean roleDisabled = CodesTables.CUNMBRRL_40.equals(role);

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStaffDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/StaffSearch/displayStaffDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.StaffDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<!--- Begin Personal Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n         <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n         <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"6\">Personal</th>\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("First");
          _jspx_th_impact_validateInput_0.setConstraint("Name12");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_0.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setValue( row01.getSzNmNameFirst() );
          _jspx_th_impact_validateInput_0.setSize("15");
          _jspx_th_impact_validateInput_0.setMaxLength("12");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Middle");
          _jspx_th_impact_validateInput_1.setConstraint("Name12");
          _jspx_th_impact_validateInput_1.setRequired("false");
          _jspx_th_impact_validateInput_1.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_1.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue( row01.getSzNmNameMiddle() );
          _jspx_th_impact_validateInput_1.setSize("10");
          _jspx_th_impact_validateInput_1.setMaxLength("12");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Last");
          _jspx_th_impact_validateInput_2.setConstraint("Name22");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_2.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setValue( row01.getSzNmNameLast() );
          _jspx_th_impact_validateInput_2.setSize("15");
          _jspx_th_impact_validateInput_2.setMaxLength("22");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Gender");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setName("cbocCdPersonSex");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_0.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateSelect_0.setValue( row06.getCCdPersonSex() );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n</table>\r\n\r\n<!--- Begin Unit Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"4\">Unit</th>\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setName("cboSzCdCounty");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateSelect_1.setValue( ccmn04so.getSzCdCounty() );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Reg/Div");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setName("cboSzCdUnitRegion");
          _jspx_th_impact_validateSelect_2.setCodesTable("CREGDIV");
          _jspx_th_impact_validateSelect_2.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_2.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateSelect_2.setValue( row04.getSzCdUnitRegion() );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setLabel("Unit");
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setConstraint("AlphaNumeric");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setName("txtSzNbrUnit");
          _jspx_th_impact_validateInput_3.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue( row04.getSzNbrUnit() );
          _jspx_th_impact_validateInput_3.setSize("4");
          _jspx_th_impact_validateInput_3.setMaxLength("2");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Role");
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setName("cboSzCdUnitMemberRole");
          _jspx_th_impact_validateSelect_3.setCodesTable( roleCodeType );
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf(roleDisabled) );
          _jspx_th_impact_validateSelect_3.setValue( role );
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n</table>\r\n<!--- Begin Work Information Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"5\">Work Information</th>\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtSzNmOfficeName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Office City");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( ccmn04so.getSzAddrMailCodeCity() != null ? ccmn04so.getSzAddrMailCodeCity() : "" );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Office Location");
          _jspx_th_impact_validateSelect_4.setOrderBy("decode");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setName("cboSzCdOfficeLocation");
          _jspx_th_impact_validateSelect_4.setCodesTable("COFCNM");
          _jspx_th_impact_validateSelect_4.setDisabled( staffDetailDisabled );
          _jspx_th_impact_validateSelect_4.setValue( ccmn04so.getSzNmOfficeName() );
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   <td width=\"25%\">&nbsp;</td>\r\n   </tr>\r\n</table>\r\n<!--- Begin Active Status Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"6\">Active Status</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtJobHire");
          _jspx_th_impact_validateDate_0.setLabel("Hire Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled( hireDateDisabled  );
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(row00.getDtDtEmpHire()) );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDtJobTerm");
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(row00.getDtDtEmpTermination()) );
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n</table>\r\n<!-- Begin of Job Description -->\r\n");

  // Declare variables for Job History Detail Section

  String ers = "";
  String jobTitle = "";
  String caseAssignable = "";
  int jobDescriptionId = 0;
  int supervisorId = 0;

  if (PageModeConstants.NEW.equals(pageMode))
  {
    String jobDescriptionDisabled = "false";


          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <th colspan=\"8\">Job Description</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("ERS");
          _jspx_th_impact_validateInput_4.setConstraint("AlphaNumeric8");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setName("txtSzTextERS");
          _jspx_th_impact_validateInput_4.setDisabled( jobDescriptionDisabled );
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( ers );
          _jspx_th_impact_validateInput_4.setSize("15");
          _jspx_th_impact_validateInput_4.setMaxLength("8");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Title");
          _jspx_th_impact_validateSelect_5.setOrderBy("decode");
          _jspx_th_impact_validateSelect_5.setRequired("true");
          _jspx_th_impact_validateSelect_5.setName("cboSzCdJobTitle");
          _jspx_th_impact_validateSelect_5.setCodesTable("CEMPJBCL");
          _jspx_th_impact_validateSelect_5.setDisabled( jobDescriptionDisabled );
          _jspx_th_impact_validateSelect_5.setValue( jobTitle );
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td colspan=\"2\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"5\">&nbsp;</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setValue( caseAssignable );
          _jspx_th_impact_validateInput_5.setDisabled( jobDescriptionDisabled );
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setChecked( caseAssignable );
          _jspx_th_impact_validateInput_5.setName("cbxbIndCaseAssignable");
          _jspx_th_impact_validateInput_5.setLabel("Case Assignable");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n</table>\r\n");
 } // Close the if for PageMode.New 
          out.write("\r\n\r\n");


  String endDated = "N";
if ( !EditableMode.isCompatibleWith( pageMode, EditableMode.NEW ) )
{


          out.write("\r\n\r\n<!-- Begin Job Description Table -->\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n          <th colspan=\"4\" class=\"thList\">Job Description</th>\r\n       </tr>\r\n\r\n\r\n");

  int loopCount = 0;
  //Enumeration e = jobDescription.enumerateROWCCMN04SOG02();

 //Display the results if the array is not empty
  //if (!e.hasMoreElements())
  if ( jobDescription == null )
  {
  
          out.write("\r\n      <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n        <td colspan=\"4\">");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ));
          out.write("</td>\r\n      </tr>\r\n     </table>\r\n  ");

  }
  else
  {
    jobDescriptionId = jobDescription.getUlIdEmpJobHistory();
    supervisorId = jobDescription.getUlIdJobPersSupv();
  
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n     ");
 String startId = "startId_" + loopCount; 
          out.write("\r\n     ");
  //compares value with NULL_JAVA_DATE which used in SHINES to represent a null date
       if ( row00.getDtDtEmpTermination() == null )
       {
     
          out.write("\r\n         ");
 if (pageMode.equalsIgnoreCase(PageModeConstants.MODIFY)) { 
          out.write("\r\n     <td>Title:&nbsp;&nbsp;<a id=\"JobDescription_");
          out.print( startId );
          out.write("\" onClick=\"hrefDirtyByPass=true; hrefNavAwayCheckByPass=true;\"\r\n            href=\"javascript:disableValidation('frmStaffDetail');submitValidateForm('frmStaffDetail', '/admin/StaffSearch/displayJobDescriptionDetail?jobHistoryId=");
          out.print(jobDescriptionId);
          out.write("')\">");
          out.print( Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()) );
          out.write("</a></td>\r\n         ");
 } else if (pageMode.equalsIgnoreCase(PageModeConstants.VIEW)){ 
          out.write("\r\n           <td>Title:&nbsp;&nbsp;");
          out.print( Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()) );
          out.write("</td>\r\n         ");
 } else { 
          out.write("\r\n       <td>Title:&nbsp;&nbsp;<a id=\"JobDescription_");
          out.print( startId );
          out.write("\" onClick=\"hrefDirtyByPass=true; hrefNavAwayCheckByPass=true;\"\r\n             href=\"javascript:disableValidation('frmStaffDetail');submitValidateForm('frmStaffDetail', '/admin/StaffSearch/displayJobDescriptionDetail?jobHistoryId=");
          out.print(jobDescriptionId);
          out.write("')\">");
          out.print( Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()));
          out.write("</a></td>\r\n     ");
     } 
        }
        else
        {
     
          out.write("\r\n            <td>Title:&nbsp;&nbsp;");
          out.print( Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()) );
          out.write("</td>\r\n     ");
 } 
          out.write("\r\n     <td>&nbsp;</td>\r\n     <td>&nbsp;</td>\r\n     <td>Supervisor:&nbsp;&nbsp;");
          out.print( FormattingHelper.formatString(jobDescription.getSzNmPersonFull()) );
          out.write("</td>\r\n    </tr>\r\n    </table><!-- This is where Job Description table ends--> \r\n");

    //loopCount++;
  //} //Close the loop

          out.write('\r');
          out.write('\n');
 } // end if for no results section
          out.write('\r');
          out.write('\n');

  }// end if ( not in add mode )

          out.write("\r\n\r\n");
 if ( !PageModeConstants.NEW.equalsIgnoreCase( pageMode ) && user.hasRight( UserProfile.SEC_MNTN_STAFF_GEN ) ) { 
          out.write("\r\n<br>\r\n");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/AddressListSubmodule/displayAddressList");
          _jspx_th_impact_include_0.setCallingPage("/admin/StaffSearch/displayStaffDetail");
          _jspx_th_impact_include_0.setIncludingForm("frmStaffDetail");
          _jspx_th_impact_include_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName( ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME );
              _jspx_th_impact_attribute_0.setValue( String.valueOf(true) );
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_1.setName( AddressListConversation.PAGE_MODE_KEY );
              _jspx_th_impact_attribute_1.setValue( pageMode );
              int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
              if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_2.setName( AddressListConversation.ADDRESS_LIST_INCLUDE_PAGE_ATTR );
              _jspx_th_impact_attribute_2.setValue( AddressListConversation.STAFF_DETAIL_WINDOW );
              int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
              if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 } // End if 
          out.write("\r\n\r\n");
 if ( PageModeConstants.EDIT.equalsIgnoreCase( pageMode ) ) { 
          out.write("\r\n<br>\r\n");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_1.setPage( PhoneSubmoduleConversation.PHONE_SUB );
          _jspx_th_impact_include_1.setCallingPage("/admin/StaffSearch/displayStaffDetail");
          _jspx_th_impact_include_1.setIncludingForm("frmStaffDetail");
          _jspx_th_impact_include_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_include_1 = _jspx_th_impact_include_1.doStartTag();
          if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_1.doInitBody();
            }
            do {
              out.write('\r');
              out.write('\n');
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_1);
              _jspx_th_impact_attribute_3.setName( ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME );
              _jspx_th_impact_attribute_3.setValue( String.valueOf(true) );
              int _jspx_eval_impact_attribute_3 = _jspx_th_impact_attribute_3.doStartTag();
              if (_jspx_th_impact_attribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_include_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 } // End if 
          out.write("\r\n\r\n");
 if ( !PageModeConstants.VIEW.equalsIgnoreCase( pageMode ) ) { 
          out.write("\r\n<br>\r\n       ");

  RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
  raceEthnicitySubDB.setTabIndex( tabIndex );
  RaceEthnicitySubDB.setIntoRequest( raceEthnicitySubDB, request );

          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    boolean isExpanded = false;
    RaceEthnicitySubDB raceEthnicitySubRaceEthnicitySubDB = RaceEthnicitySubDB.getFromRequest( request );
    int raceEthnicitySubDBTabIndex = raceEthnicitySubRaceEthnicitySubDB.getTabIndex();
    isExpanded = raceEthnicitySubRaceEthnicitySubDB.getIsExpanded();

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else if ( RaceEthnicityHelper.isInState( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else
    {
      reBean = new RaceEthnicityBean();
    }

    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )
    {
      raceValues = races.getStringVector();
    }
    else
    {
      raceValues = new ArrayList();
    }
    String personEthnicity = reBean.getEthnicity();

    Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );

          out.write("\r\n\r\n<script language=\"javascript\">\r\n// make sure at least one race checkbox is checked\r\nfunction isRaceChecked()\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n  var cbxGroupName = \"");
          out.print(RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\";\r\n  var bRace = areAnyChecked( cbxGroupName, raceLen );\r\n  return bRace;\r\n}\r\n\r\n// make sure that a radiobutton from the ethnicity radio button group is checked\r\nfunction isEthnicityChecked()\r\n{\r\n  var ethLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CINDETHN ).size() );
          out.write(";\r\n  var bEth = false;\r\n  var ethnicityRb = document.getElementsByName(\"");
          out.print( RaceEthnicityHelper.ETHNICITY_RB_NAME );
          out.write("\");\r\n  for ( i = 0; i < ethLen ; i++ )\r\n  {\r\n    bEth = ethnicityRb[i].checked;\r\n    if ( bEth )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  return bEth;\r\n}\r\n\r\n// make sure at least one race checkbox is checked or\r\n// a radiobutton from the ethnicity radio button group is checked\r\nfunction isRaceOrEthnicityChecked()\r\n{\r\n  var bRaceOrEth = false;\r\n  bRaceOrEth = ( isEthnicityChecked() || isRaceChecked() );\r\n  return bRaceOrEth;\r\n}\r\n// make sure that the race checkboxes are cleared if the undecided checkbox is checked\r\nfunction clearRaces( paramCbx )\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n\r\n  if ( paramCbx.checked == true )\r\n  {\r\n    // if you checked the Unable to Determine checkbox, make sure that all the others\r\n    // are unchecked\r\n    if ( paramCbx.value == \"");
          out.print( CodesTables.CRACE_UD  );
          out.write("\" )\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value != \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n    // else, if you checked any others, make sure Unable to Determine is unchecked\r\n    else\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value == \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n</script>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("RaceEthnicity");
          _jspx_th_impact_ExpandableSectionTag_0.setId( RaceEthnicityHelper.RACE_CB_NAME + "1_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Race/Ethnicity Detail");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( raceEthnicitySubDBTabIndex );
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded(Boolean.valueOf(isExpanded).booleanValue());
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <span class=\"formInstruct\">Race/Ethnicity should never be determined by DFCS staff. Whenever possible, this information must come from the person, if a child, from a parent.</span>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n   <th>Race</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(raceValues);
              _jspx_th_impact_codesCheckbox_0.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_0.setOnClick("clearRaces(this)");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( raceEthnicitySubDBTabIndex );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <th>Ethnicity</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      <table width=\"100%\">\r\n        <tr>\r\n");

    for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
    {
      Mapping ethnicity = (Mapping) ethIterator.next();

              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_6.setTabIndex( raceEthnicitySubDBTabIndex );
              _jspx_th_impact_validateInput_6.setName( RaceEthnicityHelper.ETHNICITY_RB_NAME );
              _jspx_th_impact_validateInput_6.setType("radio");
              _jspx_th_impact_validateInput_6.setChecked( String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) );
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              out.print( ethnicity.getValue() );
              out.write("\r\n          </td>\r\n");

    }

              out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("hidden");
              _jspx_th_impact_validateInput_7.setName( RaceEthnicityHelper.OLD_ETHNICITY_NAME );
              _jspx_th_impact_validateInput_7.setValue( personEthnicity );
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    raceEthnicitySubRaceEthnicitySubDB.setTabIndex( raceEthnicitySubDBTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');

  tabIndex = raceEthnicitySubDB.getTabIndex();
  RaceEthnicitySubDB.removeFromRequest( request );

          out.write("\r\n\r\n");
 } // End if 
          out.write("\r\n<br>\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n    ");
 //SIR 22345 - had to change from == to .equals
       if ( pageMode.equals( PageModeConstants.EDIT ) ) { 
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setFunction("enableValidation('frmStaffDetail');");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmStaffDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/StaffSearch/saveStaffDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
  } else { 
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setFunction("changeDisplayType();enableValidation('frmStaffDetail');");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.NEW );
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmStaffDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/StaffSearch/addStaffDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
  } 
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_9.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnEndDated");
          _jspx_th_impact_validateInput_10.setValue( endDated );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_11.setValue( personId );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnDisplayType");
          _jspx_th_impact_validateInput_12.setValue( displayType );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnUlIdJobPersSupv");
          _jspx_th_impact_validateInput_13.setValue( String.valueOf( supervisorId ) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnUlIdEmpJobHistory");
          _jspx_th_impact_validateInput_14.setValue( String.valueOf( jobDescriptionId ) );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_16(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnlNbrEmpActivePct");
          _jspx_th_impact_validateInput_17.setValue( String.valueOf( row00.getLNbrEmpActivePct() ));
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("hdnDtPrevTermDate");
          _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatDate(row00.getDtDtEmpTermination()));
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateErrors_0.setFormName("frmStaffDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("hdnFromDetail");
    _jspx_th_impact_validateInput_15.setValue("Y");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_16(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_16.setType("hidden");
    _jspx_th_impact_validateInput_16.setName("hdnTsLastUpdate");
    _jspx_th_impact_validateInput_16.setValue("");
    int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
    if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
