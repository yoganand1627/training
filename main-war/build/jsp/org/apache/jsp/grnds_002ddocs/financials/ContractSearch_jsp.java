package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.financials.ContractSearchConversation;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;

public final class ContractSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*   JSP Name:     ContractSearch.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 01/10/02
//*
//*
//*   The contract search window is used to enter search criteria
//*   to derive a list of contracts to populate the search results section of the page
//*   The criteria includes Contract ID, Resouce ID, Functional Type, Program Type,
//*   Region, Budget, Limit, and the From and To date ranges.
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  01/10/02  Eric Dickman      Created initial docuement.
//**  06/01/02  Eric Dickman      SIR 17846 -- Added the SSM_CON_NO_VID_EXISTS
//**                              message.
//**  06/16/03  Eric Dickman      SIR 18205 -- The page will now submit when the user
//**                              clicks enter to perform a search.

      out.write("\r\n\r\n\r\n\r\n");
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

    CCON01SO ccon01so = (CCON01SO) request.getAttribute("CCON01SO");

    boolean showResults = true;
    // Initialize the row and array objects
    ROWCCON01SOG00_ARRAY contractSearchResultsArray = null;

    // Null catch for contractSearchResultsArray, if null set to blank (initialize)
    if ( ccon01so == null )
    {
      ccon01so = new CCON01SO();
      showResults = false;
    }

    // Null catch for ROW objects, if not null get rows
    if ( ccon01so.getROWCCON01SOG00_ARRAY() != null )
    {
      contractSearchResultsArray = ccon01so.getROWCCON01SOG00_ARRAY();
    }
    else
    {
      contractSearchResultsArray = new ROWCCON01SOG00_ARRAY();
    }

    UserProfile userProfile = UserProfileHelper.getUserProfile( request );

    //Sets page mode to Edit
    String pageMode = PageModeConstants.EDIT;

    //Sets disabledAddButton to null
    String disabledAddButton = null;

   //Sets the security on the page, when the user enters the page.
   if(((userProfile.hasRight(UserProfile.SEC_CPS_POS_CONTRACT)) ||
      (userProfile.hasRight(UserProfile.SEC_FAC_CONTRACT)) ||
      (userProfile.hasRight(UserProfile.SEC_FAD_CONTRACT))) &&
      (!userProfile.getUserMaintainedRegions().isEmpty()))
    {
      disabledAddButton =  "false";
    }
    else
    {
      disabledAddButton = "true";
    }

      out.write('\r');
      out.write('\n');

    //Remove Checkbox Default Defect 4462.
    //Setting variables to hold the values in the textbox, drop down menu and checkboxes after the Search_xa is performed.
    String budgetLimitChecked = "false";
    //String programType = "";
    String resourceId = "";
    String contractId = "";
    String fromDate = "";
    String toDate = "";
    String functionType = "";
    String region = "";
    String county = "";

  // Exclude APS POS from the selection
  List<String> excludeOptions = new ArrayList<String>();
  if ( !PageModeConstants.VIEW.equals( pageMode ) )
  {
    excludeOptions.add( CodesTables.CCONFUNC_APS );
  }




// Check the hidden field to detrmine where to assign the variables from
if ( request.getParameter("hdnPageLoad") != null )
{
    // budget limit checkbox
    if ( request.getParameter("cbxIndCntrctBudgLimit") != null )
    {
      budgetLimitChecked = "true";
    }
    else
    {
      budgetLimitChecked = "false";
    }

    //resource id
    if (StringHelper.isValid(request.getParameter("txtIdResource")))
    {
    resourceId = request.getParameter("txtIdResource");
    }

    //program type
    //if (StringHelper.isValid(request.getParameter("selCdCntrctProgramType")))
    //{
    //  programType = request.getParameter("selCdCntrctProgramType");
    //}

    //contract id
    if (StringHelper.isValid(request.getParameter("txtIdContract")))
    {
      contractId = request.getParameter("txtIdContract");
    }

    //region
    if (StringHelper.isValid(request.getParameter("selCdCntrct")))
    {
      region = request.getParameter("selCdCntrct");
    }

    //county
    if (StringHelper.isValid(request.getParameter("selCdCounty")))
    {
      county = request.getParameter("selCdCounty");
      
    }

    //function type
    if (StringHelper.isValid(request.getParameter("selCdCntrctRegion")))
    {
      functionType = request.getParameter("selCdCntrctRegion");
    }

    //from date
    if (StringHelper.isValid(request.getParameter("txtDtCnperStart")))
    {
      fromDate = request.getParameter("txtDtCnperStart");
    }

    //to date
    if (StringHelper.isValid(request.getParameter("txtDtCnperTerm")))
    {
      toDate = request.getParameter("txtDtCnperTerm");
    }
}


    int tabIndex = 1;
    int loopCount = 0;
    //String radioId = "";

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  //Forwards the user to the Contract Header page via the add push button or\r\n  // the hyperlink in the pagination section.\r\n  function submitContractID(contractID) {\r\n    document.frmContractSearch.hdnContractID.value = contractID;\r\n    submitValidateForm('frmContractSearch', '/financials/ContractSearch/forwardContractHeader');\r\n  }\r\n</script>\r\n");

//  SIR 18205 -- The page will now submit when the user clicks enter (on the keyboard) to perform a search.

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContractSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton( String.valueOf(!showResults) );
      _jspx_th_impact_validateForm_0.setAction("/financials/ContractSearch/displayContractSearch");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ContractSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnPageLoad\" value=\"Y\">\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n  <tr>\r\n    <th colspan=\"6\">\r\n      Contract Search\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("Contract ID");
          _jspx_th_impact_validateInput_0.setConstraint("ID");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setName("txtIdContract");
          _jspx_th_impact_validateInput_0.setValue( contractId );
          _jspx_th_impact_validateInput_0.setSize("10");
          _jspx_th_impact_validateInput_0.setMaxLength("10");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Region");
          _jspx_th_impact_validateSelect_0.setName("selCdCntrct");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_0.setValue( region );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setName("selCdCounty");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setValue( county );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Resource ID");
          _jspx_th_impact_validateInput_1.setConstraint("ID");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_1.setName("txtIdResource");
          _jspx_th_impact_validateInput_1.setValue( resourceId );
          _jspx_th_impact_validateInput_1.setSize("10");
          _jspx_th_impact_validateInput_1.setMaxLength("10");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Function Type");
          _jspx_th_impact_validateSelect_2.setName("selCdCntrctRegion");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CCONFUNC");
          _jspx_th_impact_validateSelect_2.setExcludeOptions( excludeOptions );
          _jspx_th_impact_validateSelect_2.setValue( functionType );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setColspan("2");
          _jspx_th_impact_validateInput_2.setLabel("Budget Limit");
          _jspx_th_impact_validateInput_2.setValue("");
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setName("cbxIndCntrctBudgLimit");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setChecked(budgetLimitChecked);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue( fromDate );
          _jspx_th_impact_validateDate_0.setLabel("From");
          _jspx_th_impact_validateDate_0.setName("txtDtCnperStart");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( toDate );
          _jspx_th_impact_validateDate_1.setLabel("To");
          _jspx_th_impact_validateDate_1.setName("txtDtCnperTerm");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++);
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n </table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmContractSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/ContractSearch/searchContractSearch");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n  ");
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnViewMode");
          _jspx_th_impact_validateInput_4.setValue( disabledAddButton );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

   Enumeration contractSearchResultsEnumeration = contractSearchResultsArray.enumerateROWCCON01SOG00();
   //Display the results if the array is not empty

   if (showResults)
    {

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmContractSearchResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setDefaultButton( String.valueOf(!showResults) );
      _jspx_th_impact_validateForm_1.setAction("/financials/ContractSearch/displayContractSearch");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnPageLoad\" value=\"Y\">\r\n");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnViewMode");
          _jspx_th_impact_validateInput_6.setValue( disabledAddButton );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSaveState("true");
          _jspx_th_impact_pagination_0.setSubmitUrl("/financials/ContractSearch/searchContractSearch");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></div>\r\n   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n      <tr>\r\n         <td class=\"tableBG\">\r\n     <div id=\"scrollBar2\" style=\"height:300px;width:764px;overflow:auto\" class=\"tableborderList\">\r\n         <table width=\"1400\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n           <tr>\r\n             <th class=\"thList\">&nbsp;</th>\r\n             <th class=\"thList\">Resource Name</th>\r\n             <th class=\"thList\">Contract ID</th>\r\n             <th class=\"thList\">Vendor ID</th>\r\n             <th class=\"thList\">Contract Manager</th>\r\n             <th class=\"thList\">Region</th>\r\n             <th class=\"thList\">County</th>\r\n             <th class=\"thList\">Function Type</th>\r\n             <th class=\"thList\">Budget Limit</th>\r\n             <th class=\"thList\">Resource ID</th>\r\n           </tr>\r\n  ");

    //Enumerations contractSearchRow Array and prints out the search results
    loopCount = 0;
    ROWCCON01SOG00 contractSearchRow = null;

    if ( !contractSearchResultsEnumeration.hasMoreElements() )
{
  
              out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"10\">\r\n                ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n              </td>\r\n            </tr>\r\n  ");

    }
    else
    {
      while( contractSearchResultsEnumeration.hasMoreElements() )
      {   
      contractSearchRow = (ROWCCON01SOG00) contractSearchResultsEnumeration.nextElement();

        
  
              out.write("\r\n             <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n               ");
 //int tabindexLoop = tabIndex++;
                  //radioId = "rbAddressIndex_" + loopCount;
                  String cCode = contractSearchRow.getSzCdCntrctCounty();
                  String counties = Lookup.simpleDecodeSafe(ContractSearchConversation.COUNTY_CODES_TABLES, cCode);
                  if(counties == null || "".equals(counties)) {
                    counties = cCode;
                  }
                  String fCode = contractSearchRow.getSzCdCntrctFuncType();
               
              out.write("\r\n               <td>\r\n                 &nbsp;\r\n               </td>\r\n               <td>\r\n                 <a href=\"javascript:submitContractID('");
              out.print(FormattingHelper.formatInt(contractSearchRow.getUlIdContract()));
              out.write("');\">\r\n                   ");
              out.print( FormattingHelper.formatString(contractSearchRow.getSzNmResource()) );
              out.write("</a>\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( FormattingHelper.formatInt(contractSearchRow.getUlIdContract()) );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( FormattingHelper.formatString(contractSearchRow.getSzNbrRsrcAddrVid()) );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( FormattingHelper.formatString(contractSearchRow.getSzNmPersonFull()) );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( FormattingHelper.formatString(contractSearchRow.getSzCdCntrctRegion()) );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( counties );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( Lookup.simpleDecodeSafe(ContractSearchConversation.CCONFUNC_CODES_TABLES, fCode) );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( FormattingHelper.formatString(contractSearchRow.getCIndCntrctBudgLimit()) );
              out.write("\r\n               </td>\r\n               <td>\r\n                 ");
              out.print( FormattingHelper.formatInt(contractSearchRow.getUlIdResource()) );
              out.write("\r\n               </td>\r\n             </tr>\r\n               ");

                    loopCount++;
       } // end while
              }
               
              out.write("\r\n             </table>\r\n          </div>\r\n        </td>\r\n      </tr>\r\n   </table>\r\n");
 /* close pagination custom tag */ 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmContractSearchResults");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/ContractSearch/forwardContractHeader");
          _jspx_th_impact_ButtonTag_1.setFunction("document.frmContractSearchResults.hdnContractID.value = '0'");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setDisabled( disabledAddButton );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
 }  // close

      out.write("\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmContractSearch");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_3.setName("hdnContractID");
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
    _jspx_th_impact_validateErrors_1.setFormName("frmContractSearchResults");
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnContractID");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
