package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.lang.String;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;

public final class StaffSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     StaffSearch.jsp
 * Created by:   Jeff Chambers
 * Date Created: 10/07/02
 *
 * Description:
 * The Staff Search page is used to search for, browse, and maintain PRS
 * employees information.  The page is also "D:/Documents and Settings/gautami.rout/Local Settings/Temporary Internet Files/Content.IE5/RCDW4LU5/SHINES_Header[1].jpg"used to search for PRS employees to
 * populate data fields in other pages.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  06/10/03  dickmaec          SIR 17964 -- staffSearchInput object will remain
                              in state, this will allow the user to have
                              original search criteria on the Staff Search page
                              after returning from the Staff Sec Mnt page
  08/01/03  Todd Reser        Added ChangeLog, and modified FlowerBox comments.
  08/21/03  Eric Dickman      Fixed the tab index for the Search Results.
  11/06/03  Todd Reser        SIR 19794 - Added Sets.H for PPTParticipant so
                              when going to Staff Search from PPTParticipant
                              Radio Buttons are used instead of Checkboxes.
  4/12/2004  gerryc            SIR 16271 - added mail code field to the advanced
                              search.  It is an exact match.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  UserProfile user = UserProfileHelper.getUserProfile( request );

  //Set the page mode
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );


  // This initially checks the Staff Radio Buttons
  String allStaff = "true";
  String actvStaff = "false";

  //SIR 19794 - Added Sets.H
  if (Sets.isInSet(Sets.A | Sets.C | Sets.D | Sets.E | Sets.F | Sets.G | Sets.H, request))
  {
    allStaff = "false";
    actvStaff = "true";
  }

  // Check the request, if a search has been performed pull it out of there
  if ( request.getParameter("rbCScrIndActive") != null )
  {
    if ("actv".equalsIgnoreCase(request.getParameter("rbCScrIndActive")))
    {
      allStaff = "false";
      actvStaff = "true";
    }
    else if ("all".equalsIgnoreCase(request.getParameter("rbCScrIndActive")))
    {
      allStaff = "true";
      actvStaff = "false";
    }
  }

  //  Declare variables
  int tabIndex = 1;
  int loopCount = 0;
  String onlyButton = "true";
  String program = "";
  String region = "";
  String firstNm = "";
  String middleNm = "";
  String lastNm = "";
  String unit = "";
  String personId = "";
  String ssn = "";
  String officeCity = "";
  String county = "";
  String unitSpec = "";
  String mailCode = ""; //16271
  String officeLocation = "";

  //SIR 17964 -- staffSearchInput object will remain in state, this will allow
  //the user to have original search criteria on the Staff Search page after returning
  //from the Staff Sec Mnt page

  // If coming from StaffDetail.jsp do NOT look into the request for field values.
  if (Boolean.TRUE.equals(request.getAttribute("LOAD_INPUT_FROM_STATE")))
  {
    CCMN03SI ccmn03si =(CCMN03SI)state.getAttribute("CCMN03SI", request);

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNmNameFirst()))
    {
      firstNm = ccmn03si.getStfSrchCrtInStruct().getSzNmNameFirst();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNmNameMiddle()))
    {
      middleNm = ccmn03si.getStfSrchCrtInStruct().getSzNmNameMiddle();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNmNameLast()))
    {
      lastNm = ccmn03si.getStfSrchCrtInStruct().getSzNmNameLast();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzCdUnitProgram()))
    {
      program = ccmn03si.getStfSrchCrtInStruct().getSzCdUnitProgram();
    }

    if (ccmn03si.getStfSrchCrtInStruct().getUlIdPerson() != 0)
    {
      personId = "" + ccmn03si.getStfSrchCrtInStruct().getUlIdPerson();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNbrPersonIdNumber()))
    {
      ssn = ccmn03si.getStfSrchCrtInStruct().getSzNbrPersonIdNumber();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNbrUnit()))
    {
      unit = ccmn03si.getStfSrchCrtInStruct().getSzNbrUnit();
    }

    if ( (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzCdUnitRegion())))
    {
      region = ccmn03si.getStfSrchCrtInStruct().getSzCdUnitRegion();
    }
    //SIR 16271 added mail code
    if ((StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCode())))
    {
      mailCode = ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCode();
    }
    if ((StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCodeCity())))
    {
      officeCity = ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCodeCity();
    }
  //if ((StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct())))
   // {
   //   mailCode = ccmn03si.getStfSrchCrtInStruct().getSzNmOfficeName();
   // }

  }
  else if (request.getParameter("hdnFromDetail") == null)
  {
    //if (request.getParameter("cboSzCdUnitProgram") != null)
    //{
    //  program = request.getParameter("cboSzCdUnitProgram");
    //}
    //else if (request.getParameter("cboSzCdUnitProgram") == null)
    //{
    //  program = user.getUserProgram();
    //}

 //   if (request.getParameter("cboSzCdUnitRegion") != null)
 //   {
 //     region = request.getParameter("cboSzCdUnitRegion");
 //   }
 //   else if (request.getParameter("cboSzCdUnitRegion") == null)
 //   {
 //     region = user.getUserRegion();
 //   }

    if (StringHelper.isValid(request.getParameter("txtSzNmNameFirst")))
    {
      firstNm = request.getParameter("txtSzNmNameFirst");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNmNameMiddle")))
    {
      middleNm = request.getParameter("txtSzNmNameMiddle");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNmNameLast")))
    {
      lastNm = request.getParameter("txtSzNmNameLast");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNbrUnit")))
    {
      unit = request.getParameter("txtSzNbrUnit");
    }
    if (StringHelper.isValid(request.getParameter("txtUlIdPerson")))
    {
      personId = request.getParameter("txtUlIdPerson");
    }
    if (StringHelper.isValid(request.getParameter("txtSzSysTxtGenericSSN")))
    {
      ssn = request.getParameter("txtSzSysTxtGenericSSN");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNmOfficeName")))
    {
      officeCity = request.getParameter("txtSzNmOfficeName");
    }
    /*SIR 16271 added mail code*/
    if (StringHelper.isValid(request.getParameter("txtSzAddrMailCode")))
    {
      mailCode = request.getParameter("txtSzAddrMailCode");
    }
  }
  else
  {
    //program = user.getUserProgram();
    //region = user.getUserRegion();
  }

  if (StringHelper.isValid(request.getParameter("txtSzCdOfficeCounty")))
  {
    county = request.getParameter("txtSzCdOfficeCounty");
  }
  if (StringHelper.isValid(request.getParameter("cboSzCdUnitSpecialization")))
  {
    unitSpec = request.getParameter("cboSzCdUnitSpecialization");
  }
  if (StringHelper.isValid(request.getParameter("cboSzCdUnitRegion")))
  {
    region = request.getParameter("cboSzCdUnitRegion");
  }

  



      out.write("\r\n\r\n");

  // Get the CCMN03SO output object out of the request
  CCMN03SO staffsearch = (CCMN03SO) state.getAttribute("StaffSearch", request);
  // Initialize the row and array objects
  ROWCCMN50DO_ARRAY staffArray = null;
  // If StaffSearch result object is null, try to get object from StaffSecurity in state
  if ( Sets.isInSet( Sets.E | Sets.F , request ) )
  {
    staffsearch = (CCMN03SO) state.getAttribute("StaffSecurity", request);
  }

  if ( staffsearch == null )
  {
    staffsearch = new CCMN03SO();
  }

  // Null catch for ROW objects, if not null get rows
  if ( staffsearch.getROWCCMN50DO_ARRAY() != null )
  {
    staffArray = staffsearch.getROWCCMN50DO_ARRAY();
  } else
  {
    staffArray = new ROWCCMN50DO_ARRAY();
  }

  //REG050 -- This will allow the Default Button to exist, when the Search
  // Button is the only push button to display on the page.
  boolean enableAddButton = (Sets.isInSet(Sets.D, request));
  //SIR 19794 - Added Sets.H
  boolean enableContinueCheckRow = (Sets.isInSet( Sets.B | Sets.E | Sets.G | Sets.F | Sets.H, request));
  boolean enableContinueCheckBoxRow = (Sets.isInSet( Sets.C, request));
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
    if( enableAddButton || enableContinueCheckRow || enableContinueCheckBoxRow)
    {
      onlyButton = "false";
    }
    else
    {
      onlyButton = "true";
    }
  }

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n\r\n  function staffSearch()\r\n  {\r\n    submitValidateForm( \"frmStaffSearch\", \"/admin/StaffSearch/displayStaffSearch\" );\r\n  }\r\n  function submitStaffSearch(personId)\r\n  {\r\n    document.frmStaffSearch.hdnUlIdPerson.value = personId;\r\n    document.frmStaffSearch.hdnDisplayType.value = \"Modify\";\r\n    submitValidateForm( \"frmStaffSearch\", \"/admin/StaffSearch/displayStaffDetail\" );\r\n  }\r\n  function getPersonId(personId)\r\n  {\r\n    alert(\"Person Id: \" + personId);\r\n    document.frmStaffSearch.hdnUlIdPerson.value = personId;\r\n  }\r\n  function addStaff()\r\n  {\r\n    document.frmStaffSearchResults.hdnCReqFuncCd.value = \"");
      out.print( ServiceConstants.REQ_FUNC_CD_ADD );
      out.write("\";\r\n    document.frmStaffSearchResults.hdnDisplayType.value = \"Add\";\r\n  }\r\n\r\n  // make sure at least one race checkbox is checked\r\n  function checkBoxRow()\r\n  {\r\n    var rs = ");
      out.print( staffArray.getROWCCMN50DOCount() );
      out.write(";\r\n    var count = countChecked(\"cbx_\", rs);\r\n\r\n    if ( count < 1 )\r\n    {\r\n      alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n      return false;\r\n    }\r\n    return true;\r\n  }\r\n\r\n  function checkRow()\r\n  {\r\n    var bChecked = false;\r\n    var rs = ");
      out.print( staffArray.getROWCCMN50DOCount() );
      out.write(";\r\n\r\n      if ( rs <= 1 )\r\n      {\r\n        if ( frmStaffSearchResults.rbRowsIndex.checked == false )\r\n        {\r\n          alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n        }\r\n        else\r\n        {\r\n          bChecked = true;\r\n        }\r\n\r\n      } else {\r\n\r\n        for ( var i = 0; i < rs; i++ )\r\n        {\r\n          if (frmStaffSearchResults.rbRowsIndex[i].checked)\r\n          {\r\n             bChecked = true;\r\n          }\r\n        }\r\n\r\n        if ( bChecked == false )\r\n        {\r\n          alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) );
      out.write("');\r\n        }\r\n      }\r\n      return bChecked;\r\n  }\r\n\r\n</Script>\r\n\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStaffSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/StaffSearch/staffSearch");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setDefaultButton( onlyButton );
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");

  if (Sets.isInSet(Sets.B, request))
  {
  
          out.write("\r\n    Staff Search is complete.  Results are listed below.\r\n  ");

  }

          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  <td>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n        <th colspan=\"6\">Staff Search</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("First");
          _jspx_th_impact_validateInput_4.setConstraint("Name12");
          _jspx_th_impact_validateInput_4.setRequired("false");
          _jspx_th_impact_validateInput_4.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( firstNm );
          _jspx_th_impact_validateInput_4.setSize("15");
          _jspx_th_impact_validateInput_4.setMaxLength("12");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Middle");
          _jspx_th_impact_validateInput_5.setConstraint("Name12");
          _jspx_th_impact_validateInput_5.setRequired("false");
          _jspx_th_impact_validateInput_5.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue( middleNm );
          _jspx_th_impact_validateInput_5.setSize("15");
          _jspx_th_impact_validateInput_5.setMaxLength("12");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Last");
          _jspx_th_impact_validateInput_6.setConstraint("Name22");
          _jspx_th_impact_validateInput_6.setRequired("false");
          _jspx_th_impact_validateInput_6.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue( lastNm );
          _jspx_th_impact_validateInput_6.setSize("30");
          _jspx_th_impact_validateInput_6.setMaxLength("22");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n <tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setName("txtSzAddrMailCode");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateSelect_0.setValue( mailCode );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Office Location");
          _jspx_th_impact_validateSelect_1.setOrderBy("decode");
          _jspx_th_impact_validateSelect_1.setRequired("false");
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setName("txtSzCdOfficeCounty");
          _jspx_th_impact_validateSelect_1.setCodesTable("COFCNM");
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateSelect_1.setValue( county );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Office City");
          _jspx_th_impact_validateInput_7.setConstraint("City");
          _jspx_th_impact_validateInput_7.setRequired("false");
          _jspx_th_impact_validateInput_7.setName("txtSzNmOfficeName");
          _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue( officeCity );
          _jspx_th_impact_validateInput_7.setSize("20");
          _jspx_th_impact_validateInput_7.setMaxLength("20");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("Person ID");
          _jspx_th_impact_validateInput_8.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_8.setRequired("false");
          _jspx_th_impact_validateInput_8.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue( personId );
          _jspx_th_impact_validateInput_8.setSize("10");
          _jspx_th_impact_validateInput_8.setMaxLength("16");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Unit");
          _jspx_th_impact_validateInput_9.setConstraint("AlphaNumeric2");
          _jspx_th_impact_validateInput_9.setRequired("false");
          _jspx_th_impact_validateInput_9.setName("txtSzNbrUnit");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue( unit );
          _jspx_th_impact_validateInput_9.setSize("4");
          _jspx_th_impact_validateInput_9.setMaxLength("2");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setDisabled( Sets.isNotInSetStr( Sets.A | Sets.D, request ) );
          _jspx_th_impact_validateInput_10.setLabel("Active Staff Only");
          _jspx_th_impact_validateInput_10.setId("Active_Staff");
          _jspx_th_impact_validateInput_10.setName("rbCScrIndActive");
          _jspx_th_impact_validateInput_10.setValue("actv");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setChecked( actvStaff );
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setDisabled( Sets.isNotInSetStr( Sets.A | Sets.D, request ) );
          _jspx_th_impact_validateInput_11.setLabel("All Staff");
          _jspx_th_impact_validateInput_11.setId("All_Staff");
          _jspx_th_impact_validateInput_11.setName("rbCScrIndActive");
          _jspx_th_impact_validateInput_11.setValue("all");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setChecked( allStaff );
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n  </tr>\r\n  </table>\r\n  </td>\r\n  </tr>\r\n <tr>\r\n  <td>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Unit Specialization");
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setRequired("false");
          _jspx_th_impact_validateSelect_2.setName("cboSzCdUnitSpecialization");
          _jspx_th_impact_validateSelect_2.setCodesTable("CSPCUNTS");
          _jspx_th_impact_validateSelect_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateSelect_2.setValue( unitSpec );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   <td></td><td></td>\r\n  </tr>\r\n  <tr>\r\n       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Reg/Div");
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setRequired("false");
          _jspx_th_impact_validateSelect_3.setName("cboSzCdUnitRegion");
          _jspx_th_impact_validateSelect_3.setCodesTable("CREGDIV");
          _jspx_th_impact_validateSelect_3.setContentType( SelectTag.CODES_DECODES );
          _jspx_th_impact_validateSelect_3.setValue( region );
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td></td><td></td>\r\n   </tr>\r\n</table>\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n");
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmStaffSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/StaffSearch/staffSearch");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setBackSafe("false");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n<br/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");

  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmStaffSearchResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/admin/StaffSearch/staffSearch");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_1.setDefaultButton("false");
      _jspx_th_impact_validateForm_1.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_14(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_16.setValue( firstNm );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_17.setValue( middleNm );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_18.setValue( lastNm );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("cboSzCdUnitProgram");
          _jspx_th_impact_validateInput_19.setValue( program );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("cboSzCdUnitRegion");
          _jspx_th_impact_validateInput_20.setValue( region );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("txtSzNbrUnit");
          _jspx_th_impact_validateInput_21.setValue( unit );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_22.setValue( personId );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("txtSzSysTxtGenericSSN");
          _jspx_th_impact_validateInput_23.setValue( ssn );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 String hiddenRbValue = "true".equals(actvStaff)?"actv":"all"; 
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("rbCScrIndActive");
          _jspx_th_impact_validateInput_24.setValue( hiddenRbValue);
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("txtSzCdOfficeCounty");
          _jspx_th_impact_validateInput_25.setValue( county );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("txtSzNmOfficeName");
          _jspx_th_impact_validateInput_26.setValue( officeCity );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName("cboSzCdUnitSpecialization");
          _jspx_th_impact_validateInput_27.setValue( unitSpec );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_28.setType("hidden");
          _jspx_th_impact_validateInput_28.setName("txtSzAddrMailCode");
          _jspx_th_impact_validateInput_28.setValue( mailCode );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSaveState("false");
          _jspx_th_impact_pagination_0.setSubmitUrl("/admin/StaffSearch/staffSearch");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<!--- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->\r\n<div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\" border=\"0\">\r\n      <tr>\r\n         <td class=\"tableBG\">\r\n        <div id=\"horizontalScrollResults\" style=\"height:300px; width:762px; overflow:auto\" class=\"tableborderList\">\r\n           <table width=\"1000\" cellspacing=\"0\" cellpadding=\"3\">\r\n             <tr>\r\n               <th class=\"thList\">&nbsp;</th>\r\n               <th class=\"thList\">Name</th>\r\n\r\n               <th class=\"thList\">Title</th>\r\n               <th class=\"thList\">County</th>\r\n               <th class=\"thList\">Work Phone</th>\r\n               <th class=\"thList\">Ext</th>\r\n               <th class=\"thList\">Person ID</th>\r\n               <th class=\"thList\">Office Location</th>\r\n");
              out.write("              </tr>\r\n");

  Enumeration e = staffArray.enumerateROWCCMN50DO();
  //Display the results if the array is not empty
  if (!e.hasMoreElements())
  {
    
              out.write("\r\n              <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                <td colspan=\"10\">");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_CMN_SEARCH_NOT_FOUND ));
              out.write("</td>\r\n              </tr>\r\n  ");

  }
  else
  {
    boolean checked = false;
    while (e.hasMoreElements())
    {
      ROWCCMN50DO listDetail = (ROWCCMN50DO)e.nextElement();
      String phoneExtension = listDetail.getLNbrPhoneExtension();
      if(phoneExtension == null){
         phoneExtension = "";
      }
      
      String cbxRowsIndex = "cbx_" + (loopCount+1);
     
              out.write("\r\n               <tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n                  <td width=\"2%\">\r\n                  ");
 if ( Sets.isInSet(Sets.C, request) ) { 
              out.write("\r\n                       ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_29.setType("checkbox");
              _jspx_th_impact_validateInput_29.setChecked( String.valueOf(checked) );
              _jspx_th_impact_validateInput_29.setName( cbxRowsIndex );
              _jspx_th_impact_validateInput_29.setValue( String.valueOf( loopCount ));
              _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");

                    // SIR 19794 - Added Sets.H
                     } else if ( Sets.isInSet(Sets.B | Sets.E | Sets.F | Sets.G | Sets.H, request) ) { 
              out.write("\r\n                       ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_30.setType("radio");
              _jspx_th_impact_validateInput_30.setName("rbRowsIndex");
              _jspx_th_impact_validateInput_30.setChecked( String.valueOf(checked) );
              _jspx_th_impact_validateInput_30.setValue( String.valueOf( loopCount ) );
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                  ");
 } else { 
              out.write("\r\n                       &nbsp;\r\n                  ");
 } 
              out.write("\r\n                  ");
 if ( Sets.isInSet(Sets.A | Sets.D, request) ) { 
              out.write("\r\n                  <td><a href=\"javascript:submitStaffSearch( '");
              out.print( listDetail.getUlIdPerson());
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( listDetail.getSzNmPersonFull() );
              out.write("</a></td>\r\n                  ");
 } else { 
              out.write("\r\n                  <td>");
              out.print( listDetail.getSzNmPersonFull() );
              out.write("</td>\r\n                  ");
 } 
              out.write("\r\n                  <td>");
              out.print( Lookup.simpleDecodeSafe("CTITLEA", listDetail.getSzCdEmployeeClass()) );
              out.write("</td>\r\n                  <td>");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", listDetail.getSzCdUnitCounty()) );
              out.write("</td>\r\n                  <td>");
              out.print( FormattingHelper.formatPhone(listDetail.getLSysNbrPersPhoneWork()) );
              out.write("</td>\r\n                  <td>");
              out.print( phoneExtension );
              out.write("</td>\r\n                  <td>");
              out.print( listDetail.getUlIdPerson() );
              out.write("</td>\r\n                  <td>");
              out.print( listDetail.getSzNmOfficeName() );
              out.write("</td>\r\n                </tr>\r\n");
     loopCount++; 
              out.write('\r');
              out.write('\n');
   } // End the while

              out.write('\r');
              out.write('\n');
 } // End the else

              out.write("\r\n             </table>\r\n           </div>\r\n  </td>\r\n      </tr>\r\n   </table>\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

  //Sets D
  if ( enableAddButton )
  {

          out.write("\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmStaffSearchResults'); addStaff()");
          _jspx_th_impact_ButtonTag_1.setForm("frmStaffSearchResults");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/StaffSearch/displayStaffDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

  }
  //Sets B, E, F contunie button 1
  else if ( enableContinueCheckRow )
  {

          out.write("\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setFunction("return checkRow()");
          _jspx_th_impact_ButtonTag_2.setForm("frmStaffSearchResults");
          _jspx_th_impact_ButtonTag_2.setAction("/admin/StaffSearch/continueStaffSearch");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

  }
  //Set C, continue button 2
  else if ( enableContinueCheckBoxRow )
  {

          out.write("\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_3.setName("btnContinue");
          _jspx_th_impact_ButtonTag_3.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setFunction("return checkBoxRow()");
          _jspx_th_impact_ButtonTag_3.setForm("frmStaffSearchResults");
          _jspx_th_impact_ButtonTag_3.setAction("/admin/StaffSearch/continueStaffSearch");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

  }

          out.write("\r\n  </tr>\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
 } // End the display If

      out.write("\r\n\r\n\r\n<!--- End Detail Table --->\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmStaffSearch");
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
    _jspx_th_impact_validateInput_1.setName("hdnUlIdPerson");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnDisplayType");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateErrors_1.setFormName("frmStaffSearchResults");
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("hdnUlIdPerson");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_14.setType("hidden");
    _jspx_th_impact_validateInput_14.setName("hdnDisplayType");
    int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
    if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_15.setValue("");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
