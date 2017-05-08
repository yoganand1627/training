package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.PlacementDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.web.fce.ApplicationAndBackgroundConversation;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

public final class AppAndBG_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     AppAndBG.jsp
      //*  Created by:   Jonathan Hardy
      //*  Date Created: 3/11/03
      //*
      //*  Description:
      //*  This page allows a user to enter a Foster Care Application or Reapplication
      //*  which includes Child Information, Address of the Home of Removal, List of
      //*  Principals, Responsibility for Child Care, Health Insurance, and Most
      //*  Recent Placements.
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
       11/29/10  Hai Nguyen        SMS#81144: MR-053 Moved case manager info section from
                                   income and expenditures page to this page.  Added page logic
                                   for amended application type. Removed LC column from List 
                                   of Principals.
       01/07/11  Hai Nguyen        SMS#81144: Modified page to force user to choose application type
                                   if event is NEW and if it is an Amended or NOC.  Consequently, 
                                   data will be prefilled accordingly.
       02/04/11  Hai Nguyen        SMS#95235: Disable Amended Application radio if not MES worker,
                                   which prevents case managers from creating an Amended app.
       */

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
String pageMode = PageMode.getPageMode(request);
      int tabIndex = 1;

      ApplicationBackgroundDB populateBean = (ApplicationBackgroundDB) request.getAttribute("AppAndBGDB");
      if (populateBean == null) {
        populateBean = new ApplicationBackgroundDB();
      }
      UserProfile user = UserProfileHelper.getUserProfile(request);
      String eventStatus = populateBean.getCdEventStatus();

      boolean certGroupVisible = EventHelper.PENDING_EVENT.equals(eventStatus)
                                 || EventHelper.COMPLETE_EVENT.equals(eventStatus)
                                 || EventHelper.APPROVED_EVENT.equals(eventStatus);

      boolean certGroupEditable = ((PageModeConstants.EDIT.equals(pageMode)) && ((EventHelper.PENDING_EVENT
                                                                                                           .equals(eventStatus)) || (EventHelper.COMPLETE_EVENT
                                                                                                                                                               .equals(eventStatus))));

      String remZip = populateBean.getAddrRemovalAddrZip();
      String remZipSuff = "";
      if (remZip.length() > 5) {
        remZipSuff = remZip.substring(6);
        remZip = remZip.substring(0, 5);
      }

      String healthZip = populateBean.getAddrHealthAddrZip();
      String healthZipSuff = "";
      if (healthZip.length() > 5) {
        healthZipSuff = healthZip.substring(6);
        healthZip = healthZip.substring(0, 5);
      }

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n\r\nfunction submitPersonDetail( idPerson )\r\n{\r\n    setIsDirtyCalled( true );\r\n    document.frmAppAndBG.hdnPersonDetailId.value = idPerson;\r\n    submitValidateForm( \"frmAppAndBG\", \"/fce/ApplicationAndBackground/forwardPersonDetail\" );\r\n}\r\n\r\n\r\nfunction forwardPlacementLog()\r\n{\r\n  setIsDirtyCalled( true );\r\n  submitValidateForm('frmAppAndBG', '/fce/ApplicationAndBackground/forwardPlacementLog');\r\n}\r\n\r\n");

    // MR-053
    // the following code is to determine if this is a new application or saved application
    // if new application then it does not display app type selection and forces user to select one to prefill data
    // if saved application then check to see if and changes to app type was made, if so prefill accordingly
    // Keep in mind that any existing data will be replaced with prefilled data, hence the confirmation
    String cdApp = populateBean.getCdApplication();
    String prefilled = (String)request.getAttribute("prefilled");
    if((EventHelper.NEW_EVENT.equals(eventStatus) && "true".equals(prefilled))
        || !EventHelper.NEW_EVENT.equals(eventStatus) ){
        cdApp = populateBean.getCdApplication();
    }else{
        cdApp = StringHelper.EMPTY_STRING;
    }

      out.write("\r\nfunction doDataPrefill()\r\n{\r\n  var originalAppType = \"");
      out.print( cdApp );
      out.write("\";\r\n  \r\n  var currentSelection = document.getElementsByName(\"cdApplication\");\r\n  for( var i = 0; i < currentSelection.length; i++)\r\n  {\r\n    if(currentSelection[i].checked )\r\n    {\r\n      currentSelection = currentSelection[i].value;\r\n    }\r\n  }\r\n  \r\n  // If same code when first displayed then do nothing\r\n  if (currentSelection == originalAppType){\r\n   return false;\r\n  } else {\r\n    // Need to confirm with user that all data will be replaced\r\n    if ( confirm(\"Changing application type will replace all current information entered, do you wish to continue?\") ){\r\n      setIsDirtyCalled( true );\r\n      document.frmAppAndBG.doPrefill.value = \"true\";\r\n      disableValidation(\"frmAppAndBG\");\r\n      submitValidateForm( \"frmAppAndBG\", \"/fce/ApplicationAndBackground/displayAppAndBG\" );\r\n    }else{\r\n      // user cancelled app type change, so set app type back to previous\r\n      document.frmAppAndBG.doPrefill.value = \"false\";\r\n      \r\n      var oRadio = document.getElementsByName(\"cdApplication\");\r\n      for( var i = 0; i < oRadio.length; i++)\r\n");
      out.write("      {\r\n        if(oRadio[i].value == originalAppType)\r\n        {\r\n          // set it back to original value\r\n          oRadio[i].checked = true;\r\n        }else{\r\n          // clear if not a match to original, there may not be a select for NEW event\r\n          oRadio[i].checked = false;\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\nfunction updateAmendedIndicator()\r\n{\r\n    document.frmAppAndBG.indAmendedApp.value = 'true';\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAppAndBG");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fce/ApplicationAndBackground/displayAppAndBG");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.ApplicationAndBackgroundCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_0.setValue(populateBean.getIdLastUpdatePersonString());
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idEvent");
          _jspx_th_impact_validateInput_1.setValue(populateBean.getIdEventString());
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("idFceApplication");
          _jspx_th_impact_validateInput_2.setValue(populateBean.getIdFceApplicationString());
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("idFceEligibility");
          _jspx_th_impact_validateInput_3.setValue(populateBean.getIdFceEligibilityString());
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("idPerson");
          _jspx_th_impact_validateInput_4.setValue(populateBean.getIdPersonString());
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("idStage");
          _jspx_th_impact_validateInput_5.setValue(populateBean.getIdStageString());
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("fceApplicationDtLastUpdate");
          _jspx_th_impact_validateInput_6.setValue(String.valueOf(populateBean.getFceApplicationDtLastUpdate()));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("fceApplicationDtLastUpdateTime");
          _jspx_th_impact_validateInput_7.setValue(String.valueOf(populateBean.getFceApplicationDtLastUpdateTime()));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_8.setValue( "" + BasePrsConversation.getUserID(request) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnPersonDetailId");
          _jspx_th_impact_validateInput_9.setValue(populateBean.getIdPersonString());
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("indAmendedApp");
          _jspx_th_impact_validateInput_11.setValue(populateBean.getIndAmendedAppString());
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp; <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n      </td>\r\n    </tr>\r\n\r\n\r\n  </table>\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=10>\r\n        Status\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setRequired("true");
          _jspx_th_impact_validateInput_12.setChecked( String.valueOf( ApplicationAndBackgroundConversation.APPLICATION_TYPE.equals(populateBean.getCdApplication()) ) );
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_12.setValue(ApplicationAndBackgroundConversation.APPLICATION_TYPE);
          _jspx_th_impact_validateInput_12.setName("cdApplication");
          _jspx_th_impact_validateInput_12.setLabel( (populateBean.getIndAmendedApp() ? "Amended Application" : "Initial Application"));
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setOnClick( (populateBean.getIndAmendedApp() ? "doDataPrefill();" : "")  );
          _jspx_th_impact_validateInput_12.setDisabled(String.valueOf(!user.hasRight(UserProfile.SEC_REG_FAM_INDP_STF) 
                                      && !user.hasRight(UserProfile.SEC_REG_FAM_INDP_MGMNT_STF) 
                                      && populateBean.getIndAmendedApp()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setChecked( String.valueOf( ApplicationAndBackgroundConversation.REAPPLICATION_TYPE.equals(populateBean.getCdApplication()) ) );
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setValue(ApplicationAndBackgroundConversation.REAPPLICATION_TYPE);
          _jspx_th_impact_validateInput_13.setName("cdApplication");
          _jspx_th_impact_validateInput_13.setLabel("Notification of Change");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setOnClick("updateAmendedIndicator(); doDataPrefill();");
          _jspx_th_impact_validateInput_13.setDisabled(String.valueOf(!populateBean.getIndAmendedApp()) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n        <th colspan=\"10\">\r\n            Case Manager Information\r\n        </th>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName(ApplicationBackgroundDB.NM_EMPLOYEE_PERSON_FULL);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Case Manager's Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(populateBean.getNmEmployeePersonFull());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName(ApplicationBackgroundDB.NBR_EMPLOYEE_PERSON_PHONE);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Case Manager's Phone");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatPhone(populateBean.getNbrEmployeePersonPhone()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n            ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName(ApplicationBackgroundDB.TXT_EMPLOYEE_COMMENTS);
          _jspx_th_impact_validateTextArea_0.setCols("90");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setColspan("8");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n                ");
              out.print(populateBean.getTxtEmployeeComments());
              out.write("\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n    </tr>\r\n    <tr>\r\n      <th colspan=10>\r\n        Child Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("ChildName");
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Child's Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(populateBean.getNmPersonFull());
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dtBirth");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Date of Birth");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( populateBean.getDtBirthString());
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("nbrSocialSecurity");
          _jspx_th_impact_validateDisplayOnlyField_4.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Social Security Number");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(populateBean.getNbrSocialSecurity());
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("nbrCrsId");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("CRS ID");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(populateBean.getNbrCrsId());
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("mhnNumber");
          _jspx_th_impact_validateDisplayOnlyField_6.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("MHN Number");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(populateBean.getNbrMhn());
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("medicaidAppMonth");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Medicaid Application Month");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(populateBean.getMedAppMonth());
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n        <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("idPerson");
          _jspx_th_impact_validateDisplayOnlyField_8.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Person ID");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(String.valueOf(populateBean.getIdPerson()));
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
String detailButtonFunction = "document.frmAppAndBG.hdnPersonDetailId.value='" + populateBean.getIdPersonString()
                                    + "'";
      String bDisableDetail = EventHelper.APPROVED_EVENT.equals(eventStatus) ? "true" : "false";

      
          out.write("\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnChildDetail");
          _jspx_th_impact_ButtonTag_0.setImg("btnDetail");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmAppAndBG");
          _jspx_th_impact_ButtonTag_0.setAction("/fce/ApplicationAndBackground/forwardPersonDetail");
          _jspx_th_impact_ButtonTag_0.setFunction(detailButtonFunction);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( bDisableDetail );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <th colspan=10>\r\n        Address of Home of Removal\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setDisabled("true");
          _jspx_th_impact_validateInput_14.setLabel("Street");
          _jspx_th_impact_validateInput_14.setColspan("8");
          _jspx_th_impact_validateInput_14.setConstraint("Address");
          _jspx_th_impact_validateInput_14.setName("addrRemovalStLn1");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setValue(populateBean.getAddrRemovalStLn1());
          _jspx_th_impact_validateInput_14.setSize("30");
          _jspx_th_impact_validateInput_14.setMaxLength("");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setDisabled("true");
          _jspx_th_impact_validateInput_15.setLabel("");
          _jspx_th_impact_validateInput_15.setColspan("8");
          _jspx_th_impact_validateInput_15.setConstraint("Address");
          _jspx_th_impact_validateInput_15.setName("addrRemovalStLn2");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setValue(populateBean.getAddrRemovalStLn2());
          _jspx_th_impact_validateInput_15.setSize("30");
          _jspx_th_impact_validateInput_15.setMaxLength("");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setDisabled("true");
          _jspx_th_impact_validateInput_16.setLabel("City");
          _jspx_th_impact_validateInput_16.setConstraint("City");
          _jspx_th_impact_validateInput_16.setName("addrRemovalCity");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setValue(populateBean.getAddrRemovalCity());
          _jspx_th_impact_validateInput_16.setSize("20");
          _jspx_th_impact_validateInput_16.setMaxLength("");
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
  // default the state to Georgia, override default if the state is set
          String stateDefault = CodesTables.CSTATE_GA;
          if ( StringHelper.isValid( populateBean.getCdRemovalAddrState()) )
          {
            stateDefault = populateBean.getCdRemovalAddrState();
          }
      
          out.write("\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setDisabled("true");
          _jspx_th_impact_validateSelect_0.setLabel("State");
          _jspx_th_impact_validateSelect_0.setName("cdRemovalAddrState");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString( stateDefault ));
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setDisabled("true");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setName("cdRemovalAddrCounty");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setValue(populateBean.getCdRemovalAddrCounty());
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setDisabled("true");
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setLabel("Zip");
          _jspx_th_impact_validateInput_17.setConstraint("Zip");
          _jspx_th_impact_validateInput_17.setName("addrRemovalAddrZip");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setValue(remZip);
          _jspx_th_impact_validateInput_17.setSize("5");
          _jspx_th_impact_validateInput_17.setMaxLength("5");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        -\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setDisabled("true");
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_18.setName("addrRemovalAddrZipSuff");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue(remZipSuff);
          _jspx_th_impact_validateInput_18.setSize("4");
          _jspx_th_impact_validateInput_18.setMaxLength("4");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnChildDetail");
          _jspx_th_impact_ButtonTag_1.setImg("btnDetail");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmAppAndBG");
          _jspx_th_impact_ButtonTag_1.setAction("/fce/ApplicationAndBackground/forwardPersonDetail");
          _jspx_th_impact_ButtonTag_1.setFunction(detailButtonFunction);
          _jspx_th_impact_ButtonTag_1.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setDisabled( bDisableDetail );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
/*  Begin Expandable Section with List Table */

      
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setAnchor("test");
          _jspx_th_impact_ExpandableSectionTag_0.setName("PrincipalsList");
          _jspx_th_impact_ExpandableSectionTag_0.setId("PrincipalsList");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("List of Principals");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <div id=\"scrollBar\" style=\"height:250;width:100%;overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n        <tr>\r\n          <th class=\"thList\">\r\n            Living In Home\r\n            <br>\r\n            of Removal\r\n          </th>\r\n          <th class=\"thList\">\r\n            Name\r\n          </th>\r\n          <th class=\"thList\">\r\n            Relationship\r\n          </th>\r\n          <th class=\"thList\">\r\n            Date of Birth\r\n          </th>\r\n          <th class=\"thList\">\r\n            Current Address\r\n          </th>\r\n          ");
if (certGroupVisible) {

      
              out.write("\r\n          <th class=\"thList\">\r\n            Member of\r\n            <br>\r\n            Assistance Unit\r\n          </th>\r\n          ");
}

      
              out.write("\r\n        </tr>\r\n        ");
List principals = populateBean.getPrinciples();
      if (principals == null || principals.size() == 0) {

              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"7\">\r\n            ");
              out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
} else {

        for (int i = 0; i < principals.size(); i++) {
          String livingCbxName = "cbLivingInHome_" + i;
          String certCbxName = "cbMemCertGrp_" + i;
          String hiddenPersonIdName = "principalPersonId_" + i;
          String hiddenFcePersonIdName = "principalFcePersonId_" + i;
          String hiddenTsLastUpdateName = "principalLastUpdate_" + i;
          String relationName = "cdRelInt_" + i;
          String hiddenRelationName = "hdnRelInt_" + i;
          FcePersonDB principal = (FcePersonDB) principals.get(i);

          String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", principal.getCdRelInt());
          if ("".equals(relationDecode)) {
            relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", principal.getCdRelInt());
          }
          String checkedString = principal.getIndCertifiedGroupString();

          
              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( i + 1 ));
              out.write("\" valign=\"top\">\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setType("hidden");
              _jspx_th_impact_validateInput_19.setName(hiddenPersonIdName);
              _jspx_th_impact_validateInput_19.setValue(principal.getIdPersonString());
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setType("hidden");
              _jspx_th_impact_validateInput_20.setName(hiddenFcePersonIdName);
              _jspx_th_impact_validateInput_20.setValue(principal.getIdFcePersonString());
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_21.setType("hidden");
              _jspx_th_impact_validateInput_21.setName(hiddenTsLastUpdateName);
              _jspx_th_impact_validateInput_21.setValue(String.valueOf(principal.getDtLastUpdateTime()));
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("hidden");
              _jspx_th_impact_validateInput_22.setName(hiddenRelationName);
              _jspx_th_impact_validateInput_22.setValue(principal.getCdRelInt());
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setType("checkbox");
              _jspx_th_impact_validateInput_23.setChecked( principal.getIndPersonHmRemovalString());
              _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_23.setName( livingCbxName );
              _jspx_th_impact_validateInput_23.setValue( String.valueOf( i ) );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n            <a href=\"javascript: submitPersonDetail( '");
              out.print( principal.getIdPersonString() );
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"setIsDirtyCalled(true)\">");
              out.print(principal.getNmPersonFull());
              out.write("</a>\r\n          </td>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_9.setName(relationName);
              _jspx_th_impact_validateDisplayOnlyField_9.setValue( relationDecode );
              int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(principal.getDtBirthString());
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(principal.getAddrPersonStLn1());
              out.write("\r\n            <br>\r\n            ");
              out.print(principal.getAddrPersonCity());
              out.write("\r\n            ,\r\n            ");
              out.print(principal.getCdPersonState());
              out.write("&nbsp;\r\n            ");
              out.print(principal.getAddrPersonZip());
              out.write("\r\n          </td>\r\n          ");
if (certGroupEditable) {

            
              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setType("checkbox");
              _jspx_th_impact_validateInput_24.setChecked( checkedString );
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_24.setName( certCbxName );
              _jspx_th_impact_validateInput_24.setValue( String.valueOf( i ) );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          ");
} else if (certGroupVisible) {
            if (StringHelper.isTrue(checkedString)) {

            
              out.write("\r\n          <td align=\"center\" valign=\"center\">\r\n            <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n          </td>\r\n          ");
} else {

            
              out.write("\r\n          <td>\r\n            &nbsp;\r\n          </td>\r\n          ");
}
          }

        
              out.write("\r\n        </tr>\r\n        ");
} // end while
      }

      
              out.write("\r\n      </table>\r\n    </div>\r\n    ");
/* this is where the "scrollBar" div tag ends */

      
              out.write("\r\n    <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n      <tr>\r\n        <td colspan=\"4\" class=\"tableBG\">\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_2.setName("btnAdd1");
              _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_2.setForm("frmAppAndBG");
              _jspx_th_impact_ButtonTag_2.setAction("/fce/ApplicationAndBackground/forwardPersonSearch");
              _jspx_th_impact_ButtonTag_2.setAlign("right");
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
/* this is where the "xpandListTable" div tag ends end ESLT */

      
          out.write("\r\n  <br>\r\n  <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=6>\r\n        Care and Custody Information\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"15%\">\r\n        ");

        boolean yesChecked = false;
      boolean noChecked = false;
      Boolean indMinorParent = populateBean.getIndMinorParentObject();
      
      if (indMinorParent != null) {
        yesChecked = populateBean.getIndMinorParent();
        noChecked = !populateBean.getIndMinorParent();
      }

      
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setId("rbLiveWithMinorParentYes");
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_25.setName("indMinorParent");
          _jspx_th_impact_validateInput_25.setValue("true");
          _jspx_th_impact_validateInput_25.setLabel("Yes");
          _jspx_th_impact_validateInput_25.setChecked(String.valueOf( yesChecked ));
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setId("rbLiveWithMinorParentNo");
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_26.setName("indMinorParent");
          _jspx_th_impact_validateInput_26.setValue("false");
          _jspx_th_impact_validateInput_26.setLabel("No");
          _jspx_th_impact_validateInput_26.setChecked(String.valueOf( noChecked ));
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td colspan=\"5\">\r\n        ");
/* SIR 22492 PRS --> FPS */

      
          out.write("\r\n        Does the child live with a minor parent who is in DFCS custody? If yes, forward a copy of the most recent court order documenting the minor parent's custody status.\r\n      </td>\r\n    </tr>\r\n    <tr class=\"even\">\r\n      <td width=\"15%\">\r\n        ");
Boolean indHospital = populateBean.getIndHospitalObject();
      if (indHospital == null) {
        yesChecked = false;
        noChecked = false;
      } else {
        yesChecked = populateBean.getIndHospital();
        noChecked = !populateBean.getIndHospital();
      }

      
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setId("rbChildInHospitalYes");
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_27.setName("indHospital");
          _jspx_th_impact_validateInput_27.setValue("true");
          _jspx_th_impact_validateInput_27.setLabel("Yes");
          _jspx_th_impact_validateInput_27.setChecked(String.valueOf( yesChecked ));
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setId("rbChildInHospitalNo");
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_28.setName("indHospital");
          _jspx_th_impact_validateInput_28.setValue("false");
          _jspx_th_impact_validateInput_28.setLabel("No");
          _jspx_th_impact_validateInput_28.setChecked(String.valueOf( noChecked ));
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td colspan=\"5\">\r\n        Was the child in a hospital when DFCS obtained custody?\r\n      </td>\r\n    </tr>\r\n    <tr class=\"even\">\r\n      <td colspan=\"6\">\r\n        <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n          <tr>\r\n            <td width=\"15%\">\r\n              &nbsp;\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtHospitalAdmissionString");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Admission Date");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue(populateBean.getDtHospitalAdmissionString());
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtHospitalDischargeString");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setLabel("Discharge Date");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setValue(populateBean.getDtHospitalDischargeString());
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"15%\">\r\n        ");
Boolean indManagCvs = populateBean.getIndManagingCvsObject();
      if (indManagCvs == null) {
        yesChecked = false;
        noChecked = false;
      } else {
        yesChecked = populateBean.getIndManagingCvs();
        noChecked = !populateBean.getIndManagingCvs();
      }

      
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setId("rbIndManagingCvsYes");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_29.setName("indManagingCvs");
          _jspx_th_impact_validateInput_29.setValue("true");
          _jspx_th_impact_validateInput_29.setLabel("Yes");
          _jspx_th_impact_validateInput_29.setChecked( String.valueOf( yesChecked ) );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setId("rbIndManagingCvsNo");
          _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_30.setName("indManagingCvs");
          _jspx_th_impact_validateInput_30.setValue("false");
          _jspx_th_impact_validateInput_30.setLabel("No");
          _jspx_th_impact_validateInput_30.setChecked( String.valueOf( noChecked ) );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td colspan=\"3\">\r\n        Was medical assistance needed for the child within the 3 months prior to removal?\r\n      </td>\r\n    </tr>\r\n    <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("text");
          _jspx_th_impact_validateInput_31.setLabel("Months");
          _jspx_th_impact_validateInput_31.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_31.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_31.setColspan("8");
          _jspx_th_impact_validateInput_31.setName("txtPriorRemovalMonths");
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setValue(populateBean.getTxtPriorRemovalMonths());
          _jspx_th_impact_validateInput_31.setSize("50");
          _jspx_th_impact_validateInput_31.setMaxLength("");
          _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    </td>\r\n      </table>\r\n  <br />\r\n  ");
/*  Begin Expandable Section with List Table */

      
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setAnchor("test");
          _jspx_th_impact_ExpandableSectionTag_1.setName("Placements");
          _jspx_th_impact_ExpandableSectionTag_1.setId("Placements");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Placements");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n\r\n    <div id=\"scrollBar\" style=\"height:80;width:100%;overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n        <tr>\r\n          <th class=\"thList\">\r\n            Date Entered\r\n          </th>\r\n          <th class=\"thList\">\r\n            Status\r\n          </th>\r\n          <th class=\"thList\">\r\n            Description\r\n          </th>\r\n          <th class=\"thList\">\r\n            Entered By\r\n          </th>\r\n        </tr>\r\n        ");
List placements = populateBean.getPlacements();
      if (placements == null || placements.size() == 0) {

              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"7\">\r\n            ");
              out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
} else {
        for (int i = 0; i < placements.size(); i++) {
          PlacementDB placement = (PlacementDB) placements.get(i);

              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( i + 1 ));
              out.write("\" valign=\"top\">\r\n          <td>\r\n            ");
              out.print(placement.getDtEventOccurredString());
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(placement.getCdEventStatus());
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(placement.getTxtDescription());
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(placement.getNmPersonFull());
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
} // end while
      }

      
              out.write("\r\n      </table>\r\n    </div>\r\n    ");
/* this is where the "scrollBar" div tag ends */

      
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
/* this is where the "xpandListTable" div tag ends end ESLT */

      
          out.write("\r\n  <hr />\r\n\r\n  <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setForm("frmAppAndBG");
          _jspx_th_impact_ButtonTag_3.setAction("/fce/ApplicationAndBackground/saveAppAndBG");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nexpandCollapsed('expandedPrincipalsList', 'collapsedPrincipalsList');\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("doPrefill");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
