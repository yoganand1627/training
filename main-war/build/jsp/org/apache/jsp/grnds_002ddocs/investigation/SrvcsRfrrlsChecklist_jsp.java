package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY;

public final class SrvcsRfrrlsChecklist_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*-----------------------------------------------------------------------------
//*  JSP Name:     SrvcRfrrlsChecklist
//*  Created by:   Merle A. Demo
//*  Date Created: 12/01/2002
//*
//*  Description:  This page captures the Referrals/Services provided by workers
//*                to their clients.  It is a requirement to complete this page
//*                prior to saving and submitting an investigation.  This page
//*                is accessible from the Navigation Metaphor, event list, Case
//*                ToDo list and Staff ToDo list. This page uses servers
//*                cinv54s.src and cinv55s.src to get and save data
//*
/* Change History:
  Date      User           Description
  --------  -------------  -----------------------------------------------------
  12/01/02  Merle A. Demo  Page created

  06/09/03  GRIMSHAN       SIR 16979 get pagemode from page mode instead of app
                           mode.

  06/09/03  Todd Reser     SIR 18140 Grabbed Parameter from Request so when
                           errors occur cbxIndSvcRefChklstNoRef stays checked

  07/21/03  CASDORJM       SIR 18904 - Removed duplicate javaScript function
                           disableServices1() and removed fix for SIR 18140. In
                           order to remove the duplicate javaScript function I
                           modified disableServices() to accept a parameter which
                           is used to determine whether the comments should be
                           cleared or not.  Also, the value of the checkbox was
                           getting set to whatever was retrieved from the database.
                           This meant that if we retrieved "N" (not checked) from
                           the database, then checked the checkbox, the value
                           submitted to the request was "N".  Since the fix for
                           18140 used whatever was in the request, this was causing
                           our main problem with the checkbox not staying checked.
                           Also removed editableMode from the checkbox tag.  When
                           the page loads in NEW mode, it was disabling the 'No
                           Services/Referrals' checkbox.
  07/02/04  RIOSJA         SIR 16114 - Do not display the Family's Response
                           section for any of the family stages.
  07/02/04  MCHILLMAN      STGAP00011649 - resrict Family's Response section display
*/
//*-----------------------------------------------------------------------------

      out.write("\r\n\r\n");

/*
Import xmlstructs used on the page. Xmlstructs hold the input and output data
for Tuxedo service calls.  Xml output structs corresponding to the services
called to retrieve data for this page should be used on this page and therefore
imported here
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
/* Import needed for Messages */ 
      out.write('\r');
      out.write('\n');
/* Import needed for Form Launch */ 
      out.write("\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  // SIR 16979 Get page mode from page mode instead of app mode
  String pageMode = "";
  pageMode = PageMode.getPageMode( request );

  //Initialize all display variables for the page
   int tabIndex = 1;
   int nbrUlIdEvent;
   int nbrUlIdStage;
   Date dateLastUpdate = null;
   String familyResponse = "";
   String one = "1";
   String two = "2";
   String three = "3";
   String comments = "";
   String dtDtFirstReferral = "";

  CINV54SO cinv54so = (CINV54SO) state.getAttribute("CINV54SO",request);
  List checkedValues = (List) state.getAttribute("checkedValues",request);

  ROWCINV54SOG00 infoSrvcRfrrl = null;
  ROWCINV54SOG01_ARRAY servicesArray = null;

  if ( cinv54so == null ) { cinv54so = new CINV54SO(); }

  if ( cinv54so.getROWCINV54SOG01_ARRAY() != null )
  {
    servicesArray = cinv54so.getROWCINV54SOG01_ARRAY();
  }
  else
  {
    servicesArray = new ROWCINV54SOG01_ARRAY();
  }

  if ( checkedValues == null ) { checkedValues = new ArrayList(); }

  String indSvcRefChklstNoRef = "Y";

  if ( !cinv54so.getROWCINV54SOG00().equals(null) )
  {
    infoSrvcRfrrl = cinv54so.getROWCINV54SOG00();
    indSvcRefChklstNoRef = infoSrvcRfrrl.getCIndSvcRefChklstNoRef();
  }
  else
  {
    infoSrvcRfrrl = new ROWCINV54SOG00();
  }

   if( !"".equals(infoSrvcRfrrl.getSzCdFamilyResponse()) )
   {
      familyResponse = infoSrvcRfrrl.getSzCdFamilyResponse();
      if (familyResponse == null) 
      {
        familyResponse = "";
      }
   }

   dtDtFirstReferral = FormattingHelper.formatDate(infoSrvcRfrrl.getDtDtFirstReferral());

   //  Start the Comments section
   if( infoSrvcRfrrl.getSzTxtChklstComments() != null )
   {
     comments = infoSrvcRfrrl.getSzTxtChklstComments();
    }
  int loopCount = 0;
  //  Start the hidden fields loading

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n\r\n\r\n  // The following javaScript function is called every time the page loads.\r\n  // It is necessary to cycle through all the Services, Referrals, and Family\r\n  // Responses and clear and disable them if the \"No Services/Referrals\" checkbox\r\n  // has been selected.\r\n  window.attachEvent('onload', myOnloadFunction );\r\n  function myOnloadFunction()\r\n  {\r\n   //If no services/referrals checkbox is checked, disable all other fields.\r\n   if ( document.frmSrvcsRfrrlsChecklist.cbxIndSvcRefChklstNoRef.checked == true )\r\n   {\r\n     disableServices( false );\r\n   }\r\n  }\r\n\r\n\r\n  // This javaScript function is called onLoad of the page and also any time\r\n  // the user changes the value of the \"No Service/Referrals\" checkbox.  If\r\n  // the user checks the checkbox, all other fields are cleared and disabled.\r\n  // If the user is unchecking the checkbox, the other fields are enabled.\r\n  // If this function is called onLoad of the page, we do not want to clear the\r\n");
      out.write("  // comments and will pass false in to the function.  If this is onChange of\r\n  // the checkbox, the comments should be cleared and we pass in true.\r\n  function disableServices( clearComments )\r\n  {\r\n    var cbxValue = \"\";\r\n    var txtD = \"D\";\r\n\r\n    txtComments = eval(\"document.frmSrvcsRfrrlsChecklist.txtChklstComments\");\r\n    dtFirstReferred = eval(\"document.frmSrvcsRfrrlsChecklist.dtDtFirstReferral\");\r\n\r\n    if ( clearComments )\r\n    {\r\n      txtComments.value = \"\";\r\n    }\r\n\r\n    // If the user has checked the checkbox, clear and disable the date,\r\n    // the family responses, and the Services/Referrals.\r\n    if(document.frmSrvcsRfrrlsChecklist.cbxIndSvcRefChklstNoRef.checked)\r\n    {\r\n      dtFirstReferred.value = \"\"\r\n      dtFirstReferred.disabled = true;\r\n\r\n      document.frmSrvcsRfrrlsChecklist.dtDtFirstReferral.value = cbxValue;\r\n\r\n      ");

      // RIOSJA, SIR 16114 - The Family's Response section is not displayed
      // on the page for any family stages, so do not clear and disable the
      // fields.
      if(!CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FRE.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FSU.equals( GlobalData.getSzCdStage( request ) ))
      {
      out.write("\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[0].checked = false;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[1].checked = false;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[2].checked = false;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[0].disabled = true;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[1].disabled = true;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[2].disabled = true;\r\n      ");

      }
      
      out.write("\r\n\r\n      // When we clear and disable the Services/Referrals Provided, we also have to\r\n      // reset the _changed field.");

      for(int n = 1; n <= (Lookup.getCategoryCollection( "CSRCKLST" )).size() ; n++ )
      {
      out.write("\r\n        cbxServicesRefered = eval(\"document.frmSrvcsRfrrlsChecklist.cbxCIndSvcRefChklstNoRef\" + \"");
      out.print(n);
      out.write("\" + \"_Id\");\r\n        cbxServiceReferedChanged = eval(\"document.frmSrvcsRfrrlsChecklist.cbxCIndSvcRefChklstNoRef\" + \"");
      out.print(n);
      out.write("\" + \"_changed\");\r\n        cbxValue = eval(\"cbxServiceReferedChanged.value\");\r\n        if (cbxValue.charAt(cbxValue.length-4) == \"Y\")\r\n        {\r\n          cbxServiceReferedChanged.value = txtD.concat(cbxValue.slice(1,5));\r\n        }\r\n        if(cbxServicesRefered.checked)\r\n        {\r\n          cbxServicesRefered.checked = false;\r\n        }\r\n        cbxServicesRefered.disabled = true;\r\n      ");

      }
      
      out.write("\r\n    }\r\n    // When the user unchecks the \"No Services/Referrals\" Checkbox, we want to\r\n    // enable the date, Family Responses and Services/Referrals Provided.\r\n    else if(!document.frmSrvcsRfrrlsChecklist.cbxIndSvcRefChklstNoRef.checked)\r\n    {\r\n      dtFirstReferred.disabled = false;\r\n\r\n      ");

      // RIOSJA, SIR 16114 - The Family's Response section is not displayed
      // on the page for any family stages, so do not clear and disable the
      // fields.
      if(!CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FRE.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FSU.equals( GlobalData.getSzCdStage( request ) ))
      {
      out.write("\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[0].disabled = false;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[1].disabled = false;\r\n        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[2].disabled = false;\r\n      ");

      }
      
      out.write("\r\n      ");

      for(int n = 1; n <= (Lookup.getCategoryCollection( "CSRCKLST" )).size() ; n++ )
      {
      out.write("\r\n        cbxServicesRefered = eval(\"document.frmSrvcsRfrrlsChecklist.cbxCIndSvcRefChklstNoRef\" + \"");
      out.print(n);
      out.write("\" + \"_Id\");\r\n        cbxServicesRefered.disabled = false;\r\n      ");

      }
      
      out.write("\r\n    }\r\n  }\r\n\r\nwindow.attachEvent( 'onbeforeunload', IsDirty );\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSrvcsRfrrlsChecklist");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/SrvcsRfrrlsChecklist/saveSrvcsRfrrlsChecklist");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.SrvcsRfrrlsChecklistCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n<!--    Start of Services and Referrals section      -->\r\n  <tr>\r\n    <th colspan=\"3\">Services and Referrals</th>\r\n  </tr>\r\n   <tr>\r\n     <td width=\"25%\">\r\n       ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date of First Service/Referral");
          _jspx_th_impact_validateDate_0.setName("dtDtFirstReferral");
          _jspx_th_impact_validateDate_0.setValue(dtDtFirstReferral);
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setWidth("25%");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td  width=\"50%\">\r\n       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setLabel("No Services/Referrals");
          _jspx_th_impact_validateInput_0.setName("cbxIndSvcRefChklstNoRef");
          _jspx_th_impact_validateInput_0.setOnClick("disableServices( true )");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setValue("Y");
          _jspx_th_impact_validateInput_0.setChecked( indSvcRefChklstNoRef );
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n  </tr>\r\n</table>\r\n<!--    End of Services and Referrals section      -->\r\n<br>\r\n<!---------------------------------------------------------------------------------------->\r\n<!--    Start of Services/Referrals Provided section THE ARRAY     -->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n  <tr>\r\n     <th>Services and Referrals Provided</th>\r\n  </tr>\r\n\r\n  <tr>\r\n     <td>\r\n      ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxCIndSvcRefChklstNoRef");
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes( checkedValues );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName("CSRCKLST");
          _jspx_th_impact_codesCheckbox_0.setColumns(2);
          _jspx_th_impact_codesCheckbox_0.setIsRuled(false);
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_codesCheckbox_0.setDisabled( String.valueOf( EditableMode.isCompatibleWith(pageMode, EditableMode.VIEW) ) );
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(false);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n  </tr>\r\n</table>\r\n<!--  End of Services/Referrals The checkbox area for services provided    -->\r\n<br>\r\n<!--    Start of Family's Response section      -->\r\n");

// RIOSJA, SIR 16114 - Do not display the Family's Response section
// for any of the family stages.
// STGAP00011649 should not be avaiable for ADO or PAD stages
if ( !CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_FRE.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_FSU.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_ADO.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_PAD.equals( GlobalData.getSzCdStage( request ) ))
{
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n    <tr>\r\n      <th>Family's Response</th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setChecked( String.valueOf(familyResponse.equals(one)) );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setValue( one );
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName("rbCdFamilyResponse");
          _jspx_th_impact_validateInput_1.setLabel("At least one family member agreed to seek/accept one or more services/resources");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setChecked( String.valueOf(familyResponse.equals(two)) );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setValue( two );
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setName("rbCdFamilyResponse");
          _jspx_th_impact_validateInput_2.setLabel("No family member agreed to seek or accept any of the services/resources offered");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setChecked(String.valueOf(familyResponse.equals(three)));
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setValue( three );
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rbCdFamilyResponse");
          _jspx_th_impact_validateInput_3.setLabel("Other (explain in Comments)");
          _jspx_th_impact_validateInput_3.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n");

}

          out.write("\r\n<!--    End of Family's Response section      -->\r\n<!--    Start of COMMENTS     -->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" >\r\n  <tr>\r\n    <th colspan=\"2\">Comments </th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"14%\" >\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtChklstComments");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("125");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write(' ');
              out.print(comments);
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<!--    End of COMMENTS       -->\r\n<hr>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmSrvcsRfrrlsChecklist");
          _jspx_th_impact_ButtonTag_0.setAction("/investigation/SrvcsRfrrlsChecklist/saveSrvcsRfrrlsChecklist");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>\r\n</table>\r\n\r\n");
 /*  Always include this hidden field in your form */ 
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("txtUlIdEvent");
          _jspx_th_impact_validateInput_4.setValue(String.valueOf(infoSrvcRfrrl.getUlIdEvent()));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("txtUlIdStage");
          _jspx_th_impact_validateInput_5.setValue(String.valueOf(infoSrvcRfrrl.getUlIdStage()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("txtUlIdCase");
          _jspx_th_impact_validateInput_6.setValue(String.valueOf(infoSrvcRfrrl.getUlIdCase()) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("txtUlIdCpsChecklist");
          _jspx_th_impact_validateInput_7.setValue(String.valueOf(infoSrvcRfrrl.getUlIdCpsChecklist()) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("txtdtDtCPSInvstDtlBegun");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatDate(infoSrvcRfrrl.getDtDtCPSInvstDtlBegun()));
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
          _jspx_th_impact_validateInput_9.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_9.setValue(DateHelper.toISOString(infoSrvcRfrrl.getTsLastUpdate()));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmSrvcsRfrrlsChecklist");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
