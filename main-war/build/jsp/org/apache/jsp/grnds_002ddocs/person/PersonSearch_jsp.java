package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonSearchConversation;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class PersonSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

      //*  JSP Name:     Person Search JSP
      //*  Created by:   Jeff Chambers
      //*  Date Created: 12/06/02
      //*
      //*  Description:
      //*  The Person Search Page is used to search for persons in the IMPACT system
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  04/21/03  DWW               SIR #16829 added fire event to make sure that
      //**                              the checkbox hidden fields are correctly updated.
      //**                              This in turn make the checkbox show up as checked
      //**                              in the server code, so that the additional
      //**                              parameters search is done correctlyV9
      //**  04/22/03  Grimshan          SIR #16840 changed Mode of the Page to PageMode.getPageMode
      //**                              since the page mode change based on security (set by the
      //**                              conversation).
      //**  05/08/03  GRIMSHAN          SIR #17351 changed condition around search and relate push
      //**                              buttons to ensure that they would not appear when intake
      //**                              is using the page.  Also changed the way Case Context is
      //**                              determined
      //**  05/13/03  GRIMSHAN          SIR #17450 Added case context condition around add and relate
      //**                              pushbuttons
      //**  07/01/03  GRIMSHAN          SIR 18667 MaxLength and size of city should be 20
      //**  07/22/03  GRIMSHAN          SIR 19040 Format the name to escape out of special characters when
      //**                              submitting to javascript
      //**  08/13/03  GRIMSHAN          SIR 19304 If the county is available, display the decode instead of the
      //**                              code
      //**  08/20/03  GRIMSHAN          SIR 19577 Use lookup.getSimpleDecodeSafe so JSP won't blow up if there
      //**                              is a bad code in the database.
      //**  08/20/03  GRIMSHAN          SIR 19581 Set a variable on click of the hyperlink using the javascript so
      //**                              that if the person selected is a former employee the information will not
      //**                              be displayed on the person detail page.
      //**  11/24/03  CORLEYAN          SIR 22416 If there are not two buttons on the page regardless of
      //**                              search results, allow the user to hit enter and resubmit the search
      //**  09/20/04  CODREAA            SIR 23030 Commented out java script comments so that no extraneous
      //**                              information is added.
      //**  6/10/08	  cjgerry           STGAP00009183 - added javascript validation if the user has selected a person
      //**	                            from the search results, but clicked Add New Person.  Also changed the 
      //**                              button names from Add to Add New Person and Relate to Relate to Case.
      //**  12/31/08  SSUBRAM			STGAP00011764: Added SAU Sealed Attribute checking to the adopted child.
      //**  10/25/09  mxpatel           38626: removed caseContext in order to display person search results from Person 
      //**                              search page 

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

                                                                       BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      PrsnSearchOutRec_ARRAY personArray = null;
      PersonSearchOutRec personSearchOutRec = null;
      String defaultButton = ArchitectureConstants.FALSE;

      // Get the PersonSearchOutRec output object out of the request
      personSearchOutRec = (PersonSearchOutRec) state.getAttribute("CINT09SO", request);

      //  Declare variables
      int tabIndex = 1;
      boolean caseContext = false;
      String searchType = "PHO";
      String firstNm = "";
      String middleNm = "";
      String lastNm = "";
      Date dob = new Date();
      int age = 0;
      String gender = "";
      String street = "";
      String county = "";
      String city = "";
      String addrState = "GA";
      String zip = "";
      String zip2 = "";
      String ssn = "";
      int personId = 0;
      String phone = "";
      int loopCount = 0;
      int intReportID = 0;
      int medaidNO = 0;

      String disableContinuePB = "false";
      boolean showContinueBtn = true;

      if (request.getAttribute(IntakeConstants.SEARCH_INTAKE) != null) {
        // set object in state for reuse
        state.setAttribute("IntakeObject", IntakeConstants.SEARCH_INTAKE, request);
      }

      // If comming from intake or person list use the data being passed in to perform the search
      if (request.getAttribute(IntakeConstants.SEARCH_INTAKE) != null || request.getAttribute("indPersonList") != null) {
        if (request.getAttribute("txtUlIdPerson") != null) {
          personId = Integer.parseInt((String) request.getAttribute("txtUlIdPerson"));
        } else {
          personId = 0;
        }
        firstNm = (String) request.getAttribute("txtSzNmNameFirst");
        middleNm = (String) request.getAttribute("txtSzNmNameMiddle");
        lastNm = (String) request.getAttribute("txtSzNmNameLast");
        dob = (Date) request.getAttribute("dtDtPersonBirth");
        if (request.getAttribute("txtlNbrPersonAge") != null) {
          age = Integer.parseInt((String) request.getAttribute("txtlNbrPersonAge"));
        } else {
          age = 0;
        }
        gender = (String) request.getAttribute("selCcdPersonSex");
        //-- SIR STGAP00000887
        String genderSpecified = (String) state
                                               .getContextParameter(
                                                                    IntakeConstants.GENDER_SPECIFIED_BY_USER + personId,
                                                                    request);
        if (CodesTables.CSEX_U.equals(gender) && ArchitectureConstants.N.equals(genderSpecified)) {
          gender = "";
        }
        //-- end SIR fix
        street = (String) request.getAttribute("txtSzAddrPersAddrStLn1");
        county = (String) request.getAttribute("selSzCdAddrCounty");
        city = (String) request.getAttribute("txtSzCdAddrCity");
        addrState = (String) request.getAttribute("selSzCdAddrState");
        zip = (String) request.getAttribute("txtSzCdAddrZip");
        zip2 = (String) request.getAttribute("txtSzCdAddrZip2");
        ssn = (String) request.getAttribute("txtSzSysTxtGenericSSN");
        phone = (String) request.getAttribute("txtlNbrPhone");

        // GA Shines: 2 new fields here
        if (request.getAttribute("txtIntReportID") != null) {
          intReportID = Integer.parseInt((String) request.getAttribute("txtIntReportID"));
        }
        if (request.getAttribute("txtMedaidNO") != null) {
          medaidNO = Integer.parseInt((String) request.getAttribute("txtMedaidNO"));
        }
      }

      //  If the user came from Task List then they are in then they are in the case context.
      if (request.getAttribute("CaseContext") != null && "Y".equals(request.getAttribute("CaseContext"))) {
        caseContext = true;
      } else {
        caseContext = false;
      }

      /// SIR 22416 If person search out rec is still null, set default button value to true if we have
      // a results set, but are not in case context and have no intake object set the default button
      // to true, otherwise set it to false

      if (personSearchOutRec == null) {
        defaultButton = ArchitectureConstants.TRUE;
      } else if (!caseContext && state.getAttribute("IntakeObject", request) == null) {
        defaultButton = ArchitectureConstants.TRUE;
      } else {
        defaultButton = ArchitectureConstants.FALSE;
      }

      //If coming from Placement Referral Detail page then show only continue button and hide the other buttons.
      //This hdnContinueBtn attribute is coming from Placement Referral Detail Page.
      String hdnContinueBtn = (String) state.getAttribute("hdnContinueBtn", request);
      if (ArchitectureConstants.TRUE.equals(hdnContinueBtn)) {
        showContinueBtn = true;
      } else {
        showContinueBtn = false;
      }

      out.write("\r\n\r\n\r\n<Script Language=\"JavaScript\">\r\n\r\n  function personSearch()\r\n  {\r\n    submitValidateForm( \"frmPersonSearch\", \"/person/PersonSearch/displayPersonSearch\" );\r\n  }\r\n\r\n  function submitToPersonDetail(personId, name, status, displayInfo, psaActive, age)\r\n  {\r\n    document.frmPersonSearch.hdnUlIdPerson.value = personId;\r\n    document.frmPersonSearch.hdnFullName.value = name;\r\n    document.frmPersonSearch.bIndActiveStatus.value = status;\r\n    document.frmPersonSearch.bSysIndViewPersonInfo.value = displayInfo;\r\n    //-- SIR 1165 ---------\r\n    document.frmPersonSearch.hdnIndPsa.value = psaActive;\r\n    //---------------------\r\n    document.frmPersonSearch.hdnPersonAge.value = age;\r\n    submitValidateForm( \"frmPersonSearch\", \"/person/PersonSearch/displayPersonDetail\" );\r\n  }\r\n\r\n  function checkAddl()\r\n  {\r\n");
      out.write("\r\n    if (frmPersonSearch.txtSzSysTxtGenericSSN.value != \"\" ||\r\n        frmPersonSearch.txtUlIdPerson.value != \"\" ||\r\n        frmPersonSearch.txtlNbrPhone.value != \"\" ||\r\n        frmPersonSearch.txtMedaidNO.value != \"\" ||\r\n        frmPersonSearch.txtIntReportID.value != \"\" )\r\n    {\r\n    document.frmPersonSearch.cbxAdditionalParams.checked = true;\r\n");
      out.write("\r\n    document.frmPersonSearch.cbxAdditionalParams.fireEvent(\"onClick\");\r\n    }\r\n  }\r\n\r\n\r\n\r\n</Script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPersonSearch");
      _jspx_th_impact_validateForm_0.setDefaultButton(defaultButton);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonSearch/displayPersonSearch");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.PersonSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(PageMode.getPageMode(request));
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
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
          out.write('	');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnSzCdStageProgram");
          _jspx_th_impact_validateInput_6.setValue(GlobalData.getSzCdStageProgram(request));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnSzCdStage");
          _jspx_th_impact_validateInput_7.setValue(GlobalData.getSzCdStage(request));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnSzCdTask");
          _jspx_th_impact_validateInput_8.setValue(GlobalData.getSzCdTask(request));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t<!--- Begin Detail Table --->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tPerson Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"23%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("cboSearchType");
          _jspx_th_impact_validateSelect_0.setLabel("Person Information Search");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setCodesTable("CPERSRCH");
          _jspx_th_impact_validateSelect_0.setValue(searchType);
          _jspx_th_impact_validateSelect_0.setColspan("5");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"13%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setName("txtSzNmNameLast");
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setLabel("Last");
          _jspx_th_impact_validateInput_11.setConstraint("Name22");
          _jspx_th_impact_validateInput_11.setRequired("false");
          _jspx_th_impact_validateInput_11.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatString(lastNm));
          _jspx_th_impact_validateInput_11.setSize("30");
          _jspx_th_impact_validateInput_11.setMaxLength("22");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName("txtSzNmNameFirst");
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("First");
          _jspx_th_impact_validateInput_12.setConstraint("Name12");
          _jspx_th_impact_validateInput_12.setRequired("false");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString(firstNm));
          _jspx_th_impact_validateInput_12.setSize("15");
          _jspx_th_impact_validateInput_12.setMaxLength("12");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName("txtSzNmNameMiddle");
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setLabel("Middle");
          _jspx_th_impact_validateInput_13.setConstraint("Name12");
          _jspx_th_impact_validateInput_13.setRequired("false");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setValue(FormattingHelper.formatString(middleNm));
          _jspx_th_impact_validateInput_13.setSize("15");
          _jspx_th_impact_validateInput_13.setMaxLength("12");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtPersonBirth");
          _jspx_th_impact_validateDate_0.setLabel("Date of Birth");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dob));
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName("txtlNbrPersonAge");
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setLabel("Age");
          _jspx_th_impact_validateInput_14.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_14.setRequired("false");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatInt(age));
          _jspx_th_impact_validateInput_14.setSize("3");
          _jspx_th_impact_validateInput_14.setMaxLength("3");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("cboCcdPersonSex");
          _jspx_th_impact_validateSelect_1.setLabel("Gender");
          _jspx_th_impact_validateSelect_1.setRequired("false");
          _jspx_th_impact_validateSelect_1.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(gender));
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tAddress\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"8\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setLabel(" Address Search");
          _jspx_th_impact_validateInput_15.setChecked("");
          _jspx_th_impact_validateInput_15.setName("cbxAddressSearch");
          _jspx_th_impact_validateInput_15.setValue("Y");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setName("txtSzAddrPersAddrStLn1");
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setLabel("Street");
          _jspx_th_impact_validateInput_16.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_16.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString(street));
          _jspx_th_impact_validateInput_16.setSize("30");
          _jspx_th_impact_validateInput_16.setMaxLength("30");
          _jspx_th_impact_validateInput_16.setColspan("3");
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("cboSzCdAddrCounty");
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setRequired("false");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(county));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setName("txtSzCdAddrCity");
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setLabel("City");
          _jspx_th_impact_validateInput_17.setConstraint("Name20");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatString(city));
          _jspx_th_impact_validateInput_17.setSize("20");
          _jspx_th_impact_validateInput_17.setMaxLength("20");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("cbxSzCdAddrState");
          _jspx_th_impact_validateSelect_3.setLabel("State");
          _jspx_th_impact_validateSelect_3.setRequired("false");
          _jspx_th_impact_validateSelect_3.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(addrState));
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setName("txtlAddrZip");
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setLabel("Zip");
          _jspx_th_impact_validateInput_18.setConstraint("Digit5");
          _jspx_th_impact_validateInput_18.setRequired("false");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatString(zip));
          _jspx_th_impact_validateInput_18.setSize("5");
          _jspx_th_impact_validateInput_18.setMaxLength("5");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t-\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setConstraint("Digit4");
          _jspx_th_impact_validateInput_19.setRequired("false");
          _jspx_th_impact_validateInput_19.setName("txtlAddrZip2");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatString(zip2));
          _jspx_th_impact_validateInput_19.setSize("4");
          _jspx_th_impact_validateInput_19.setMaxLength("4");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tAdditional Parameters\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("checkbox");
          _jspx_th_impact_validateInput_20.setLabel(" Additional Parameters Search");
          _jspx_th_impact_validateInput_20.setChecked("");
          _jspx_th_impact_validateInput_20.setName("cbxAdditionalParams");
          _jspx_th_impact_validateInput_20.setValue("Y");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setName("txtSzSysTxtGenericSSN");
          _jspx_th_impact_validateInput_21.setType("text");
          _jspx_th_impact_validateInput_21.setLabel("SSN");
          _jspx_th_impact_validateInput_21.setOnChange("checkAddl()");
          _jspx_th_impact_validateInput_21.setConstraint("SocialSecurityNumber");
          _jspx_th_impact_validateInput_21.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setValue(FormattingHelper.formatString(ssn));
          _jspx_th_impact_validateInput_21.setSize("11");
          _jspx_th_impact_validateInput_21.setMaxLength("11");
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setLabel("Person ID");
          _jspx_th_impact_validateInput_22.setOnChange("checkAddl()");
          _jspx_th_impact_validateInput_22.setConstraint("ID");
          _jspx_th_impact_validateInput_22.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setSize("10");
          _jspx_th_impact_validateInput_22.setMaxLength("10");
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setName("txtlNbrPhone");
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setLabel("Phone");
          _jspx_th_impact_validateInput_23.setOnChange("checkAddl()");
          _jspx_th_impact_validateInput_23.setConstraint("Phone");
          _jspx_th_impact_validateInput_23.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setValue(FormattingHelper.formatString(phone));
          _jspx_th_impact_validateInput_23.setSize("14");
          _jspx_th_impact_validateInput_23.setMaxLength("14");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setName("txtMedaidNO");
          _jspx_th_impact_validateInput_24.setType("text");
          _jspx_th_impact_validateInput_24.setLabel("CRS or Medicaid/MHN Number");
          _jspx_th_impact_validateInput_24.setOnChange("checkAddl()");
          _jspx_th_impact_validateInput_24.setConstraint("Numeric");
          _jspx_th_impact_validateInput_24.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setValue(FormattingHelper.formatInt(medaidNO));
          _jspx_th_impact_validateInput_24.setSize("12");
          _jspx_th_impact_validateInput_24.setMaxLength("12");
          _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setName("txtIntReportID");
          _jspx_th_impact_validateInput_25.setType("text");
          _jspx_th_impact_validateInput_25.setLabel("Intake Report ID");
          _jspx_th_impact_validateInput_25.setOnChange("checkAddl()");
          _jspx_th_impact_validateInput_25.setConstraint("ID");
          _jspx_th_impact_validateInput_25.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setValue(FormattingHelper.formatInt(intReportID));
          _jspx_th_impact_validateInput_25.setSize("10");
          _jspx_th_impact_validateInput_25.setMaxLength("10");
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t");
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmPersonSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonSearch/searchPersonSearch");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t");
          out.write("\r\n\t<br />\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

      //Display the results if the array is not empty, and only display the results if there is no validation error
      if (personSearchOutRec != null && !FormValidation.pageHasValidationMessages("frmPersonSearch", request)) {

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmSearchResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/person/PersonSearch/searchPersonSearch");
      _jspx_th_impact_validateForm_1.setPageMode(PageModeConstants.EDIT);
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_1.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_27(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_28(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_29(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_30(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_31(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_32.setType("hidden");
          _jspx_th_impact_validateInput_32.setName("hdnSzCdStageProgram");
          _jspx_th_impact_validateInput_32.setValue(GlobalData.getSzCdStageProgram(request));
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_33.setType("hidden");
          _jspx_th_impact_validateInput_33.setName("hdnSzCdStage");
          _jspx_th_impact_validateInput_33.setValue(GlobalData.getSzCdStage(request));
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_34.setType("hidden");
          _jspx_th_impact_validateInput_34.setName("hdnSzCdTask");
          _jspx_th_impact_validateInput_34.setValue(GlobalData.getSzCdTask(request));
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSaveState("true");
          _jspx_th_impact_pagination_0.setSubmitUrl("/person/PersonSearch/searchPersonSearch");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t");

		        //  Due to the way the the Person Search services work, it's possible
		        //  to return the same Id Person more than once.  Check if Id exists in
		        //  the list box before copying.
		        //  Create a set that will contain IdPersons that are currently in the listbox
		        Set hashSet = new HashSet();

		        // Null catch for ROW objects, if not null get rows
		        if (personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
		          personArray = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
		        } else {
		          personArray = new PrsnSearchOutRec_ARRAY();
		        }
		        Enumeration e = personArray.enumeratePrsnSearchOutRec();
		
              out.write("\r\n\r\n\r\n\t\t<!--- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->\r\n\t\t<div class=\"alignRight\">\r\n\t\t\t<div class=\"formInstruct\">\r\n\t\t\t\tScroll for more information -->\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\t\tclass=\"tableborder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"tableBG\">\r\n\t\t\t\t\t<div id=\"horizontalScrollResults\"\r\n\t\t\t\t\t\tstyle=\"height:300px; width:764px; overflow:auto\"\r\n\t\t\t\t\t\tclass=\"tableborderList\">\r\n\t\t\t\t\t\t<table width=\"1400\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tMatch\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tMatch Name\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tAlert\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tScore\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tMrg\r\n");
              out.write("\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tAge\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tGender\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tRace/Ethnicity\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tPerson ID\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tCity\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tCounty\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tStreet\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tSSN\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tPrimary Name\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							if (!e.hasMoreElements()) {
							
              out.write("\r\n\t\t\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t\t\t<td colspan=\"15\">\r\n\t\t\t\t\t\t\t\t\t");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							          } else if (request.getAttribute("PrsnSearchInRec") != null) {
							          Object inRec = request.getAttribute("PrsnSearchInRec");
							          PrsnSearchInRec prsnsearchinrec = null;
							          if (inRec instanceof PrsnSearchInRec) {
							            prsnsearchinrec = (PrsnSearchInRec) inRec;
							          } else if (inRec instanceof PersonSearchInRec) {
							            prsnsearchinrec = ((PersonSearchInRec) inRec).getPrsnSearchInRec();
							          }

							          String matchType = PersonSearchConversation.calculateMatchType(prsnsearchinrec);

							          while (e.hasMoreElements()) {
							            PrsnSearchOutRec personSearchList = (PrsnSearchOutRec) e.nextElement();
							            // hide the record of an adopted child from user that does not have Adoption View or SAU Sealed attribute
							            // STGAP00011764: Added SAU Sealed Attribute checking to the adopted child.
							            if (ArchitectureConstants.Y.equals(personSearchList.getIndAdopted())
							                && !(user.hasRight(UserProfile.SEC_ADO_VIEW) || user.hasRight(UserProfile.SEC_SAU_SEALED))) {
							              continue;
							            }
							            // Only go through the process of displaying a row in the list box if the Person ID is not
							            // already being displayed.
							            //if ( !hashSet.contains( new Integer( personSearchList.getUlIdPerson() ) ) )
							            //{
							            String displayConcatNm = ""; // Current name
							            String displayAKANm = ""; // used-to-be name
							            String displayAlert = "";
							            int displayScore = personSearchList.getUsScrIndScore();
							            String displayMerge = personSearchList.getCWcdIndMerge();
							            int displayAge = personSearchList.getLNbrPersonAge();
							            String displayGender = personSearchList.getCCdPersonSex();
							            String displayEthnicGrp = "";
							            displayEthnicGrp = Lookup
							                                     .simpleDecodeSafe(CodesTables.CETHNIC, personSearchList.getSzCdPersonEthnicGroup());
							            int displayPersonId = personSearchList.getUlIdPerson();
							            hashSet.add(personSearchList.getUlIdPerson());
							            String displayCity = "";
							            String displayCounty = "";
							            String displayStreet = "";
							            String displaySsn = "";

							            //  Call calculateMatchType to determine how the result was matched
							            String displayMatch = "";

							            //  Overide matchType with "AKA" if this is true, also only display primary name if
							            //  this is true.
							            if (ArchitectureConstants.Y.equalsIgnoreCase(personSearchList.getSzScrCdPersonSearchHit())) {
							              displayMatch = "AKA";
							              displayAKANm = personSearchList.getSzNmIncmgPersFull();
							              displayConcatNm = personSearchList.getSzNmPersonFull();
							            } else {
							              displayMatch = matchType;
							              displayAKANm = personSearchList.getSzNmPersonFull();
							            }

							            // only display this information if we are in a case context, or if we are not in case context, and
							            // not an employee
							            // SIR 19581 also display this information only if BSysIndViewPersonInfo is "Y"
							            if(personSearchList.getBSysIndViewPersonInfo() == null) {
							            personSearchList.setBSysIndViewPersonInfo(ArchitectureConstants.Y);
							            }
							            if ((!ArchitectureConstants.Y.equalsIgnoreCase(personSearchList.getBIndActiveStatus()) && ArchitectureConstants.Y
							                                                                                                                                                .equalsIgnoreCase(personSearchList
							                                                                                                                                                                                  .getBSysIndViewPersonInfo()))) {
							              displayCity = personSearchList.getSzAddrCity();
							              // SIR 19304 GRIMSHAN if the county is valid, display the decode.
							              displayCounty = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, personSearchList.getSzCdCounty());
							              displayStreet = personSearchList.getSzAddrPersAddrStLn1();
							              displaySsn = personSearchList.getSzNbrPersonIdSsn();
							            }
							            // set value for alert
							            if (ArchitectureConstants.Y.equals(personSearchList.getIndPsa())) {
							              displayAlert = "!";
							            }
							
              out.write("\r\n\t\t\t\t\t\t\t<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
              out.write("\r\nvar personName");
              out.print(loopCount);
              out.write(" = '");
              out.print(FormattingHelper.formatStringSpecialChars(displayAKANm, "'\"\\"));
              out.write("';\r\n</script>\r\n\t\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\">\r\n\t\t\t\t\t\t\t\t");

								if (caseContext || state.getAttribute("IntakeObject", request) != null) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td width=\"2%\">\r\n\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_35.setType("radio");
              _jspx_th_impact_validateInput_35.setName("rbRowsIndex");
              _jspx_th_impact_validateInput_35.setId("incRadio" + loopCount);
              _jspx_th_impact_validateInput_35.setValue(String.valueOf(loopCount));
              _jspx_th_impact_validateInput_35.setTabIndex(0);
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								} else {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t\t");

								}
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayMatch));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<a\r\n\t\t\t\t\t\t\t\t\t\thref=\"javascript:disableValidation('frmSearchResults'); submitToPersonDetail( '");
              out.print(personSearchList.getUlIdPerson());
              out.write("', personName");
              out.print(loopCount);
              out.write(',');
              out.write(' ');
              out.write('\'');
              out.print(personSearchList.getBIndActiveStatus());
              out.write("', '");
              out.print(personSearchList.getBSysIndViewPersonInfo());
              out.write("', '");
              out.print(personSearchList.getIndPsa());
              out.write("',  '");
              out.print(personSearchList.getLNbrPersonAge());
              out.write("')\">\r\n\t\t\t\t\t\t\t\t\t\t");
              out.print(displayAKANm);
              out.write("\r\n\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<b><font color=\"red\"> ");
              out.print(FormattingHelper.formatString(displayAlert));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</font>\r\n\t\t\t\t\t\t\t\t\t</b>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatInt(displayScore));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								if (ArchitectureConstants.Y.equalsIgnoreCase(displayMerge)) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<img alt=\"checkmark\"\r\n\t\t\t\t\t\t\t\t\t\tsrc=\"/grnds-docs/images/shared/checkMark.gif\">\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								} else {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								}
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatInt(displayAge));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayGender));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayEthnicGrp));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatInt(displayPersonId));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayCity));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayCounty));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayStreet));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatSSN(displaySsn));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(displayConcatNm));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							            loopCount++;
							            //} // End If
							          } // End While
							        }
							
              out.write("\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write('\r');
          out.write('\n');
          out.write('	');
 String functionStringRelate = "disableValidation('frmSearchResults'); return isRadioCheckedRelate( "
	                                      + loopCount + ", 'rbRowsIndex' );"; 
          out.write('\r');
          out.write('\n');
          out.write('	');
 String functionStringAdd = "disableValidation('frmSearchResults'); return isRadioCheckedAdd( " + loopCount
	                                   + ", 'rbRowsIndex' );"; 
          out.write('\r');
          out.write('\n');
          out.write('	');

	        // SIR 17351 GRIMSHAN -- If there is no Intake object display the first set of buttons
	        // SIR 17450 GRIMSHAN -- Only display the buttons if we are also in case context
	        if (state.getAttribute("IntakeObject", request) == null && caseContext) {
	
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t");

			if (!showContinueBtn) {
			
          out.write("\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnRelateToCase");
          _jspx_th_impact_ButtonTag_1.setImg("btnRelateToCase");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmSearchResults");
          _jspx_th_impact_ButtonTag_1.setFunction(functionStringRelate);
          _jspx_th_impact_ButtonTag_1.setDisabled("");
          _jspx_th_impact_ButtonTag_1.setAction("/person/PersonSearch/relatePerson");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td class=\"alignRight\" width=\"50\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnAddNewPerson");
          _jspx_th_impact_ButtonTag_2.setImg("btnAddNewPerson");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmSearchResults");
          _jspx_th_impact_ButtonTag_2.setFunction(functionStringAdd);
          _jspx_th_impact_ButtonTag_2.setDisabled("");
          _jspx_th_impact_ButtonTag_2.setAction("/person/PersonSearch/addPerson");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			}
			
          out.write("\r\n\r\n\t\t\t");

			if (showContinueBtn) {
			
          out.write("\r\n\t\t\t<td class=\"alignRight\" width=\"8%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_3.setName("btnContinue");
          _jspx_th_impact_ButtonTag_3.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmSearchResults");
          _jspx_th_impact_ButtonTag_3.setAction("/person/PersonSearch/callContinue");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_3.setDisabled(disableContinuePB);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t");

			}
			
          out.write("\r\n\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	} // close the if on the hide buttons
	
          out.write("\r\n\r\n\t");

	if (state.getAttribute("IntakeObject", request) != null) {
	
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_4.setName("btnRelateToIntake");
          _jspx_th_impact_ButtonTag_4.setImg("btnRelateToIntake");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmSearchResults");
          _jspx_th_impact_ButtonTag_4.setFunction(functionStringRelate);
          _jspx_th_impact_ButtonTag_4.setDisabled("");
          _jspx_th_impact_ButtonTag_4.setAction("/person/PersonSearch/relatePersonIntake");
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	} // close the if on the hide buttons
	
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

} // close the if to hide the entire results section

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");

if ( personSearchOutRec != null )
{

      out.write('\r');
      out.write('\n');
      out.write("\r\nfunction isRadioCheckedRelate(arrayLength, buttonGroupName)\r\n{\r\n  var bRadio = false;\r\n  var listRb = document.getElementsByName(buttonGroupName);\r\n  for ( i = 0; i < arrayLength ; i++ )\r\n  {\r\n    bRadio = listRb[i].checked;\r\n    if ( bRadio )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  if ( !bRadio )\r\n  {\r\n    alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n  }\r\n  return bRadio;\r\n}\r\n");
      out.write("\r\nfunction isRadioCheckedAdd(arrayLength, buttonGroupName)\r\n{\r\n  var bRadio = false;\r\n  var listRb = document.getElementsByName(buttonGroupName);\r\n  for ( i = 0; i < arrayLength ; i++ )\r\n  {\r\n    //set boolean to true if checked\r\n    bRadio = listRb[i].checked;\r\n    if ( bRadio )\r\n    {\r\n      //if it is checked, give a warning message\r\n      alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_RELATE_NOT_ADD));
      out.write("');\r\n      return false;\r\n    }\r\n  }\r\n  return true;\r\n}\r\n\r\n");

}

      out.write("\r\n</script>\r\n");

personSearchOutRec = null;

      out.write("\r\n<!--- End Detail Table --->\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmPersonSearch");
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
    _jspx_th_impact_validateInput_1.setValue("");
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
    _jspx_th_impact_validateInput_2.setName("hdnFullName");
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
    _jspx_th_impact_validateInput_3.setName("hdnUlIdStage");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("bIndActiveStatus");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("bSysIndViewPersonInfo");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnIndPsa");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_10.setName("hdnPersonAge");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_27(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_27.setType("hidden");
    _jspx_th_impact_validateInput_27.setName("hdnUlIdPerson");
    _jspx_th_impact_validateInput_27.setValue("");
    int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
    if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_28(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_28.setType("hidden");
    _jspx_th_impact_validateInput_28.setName("hdnFullName");
    int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
    if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_29(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_29.setType("hidden");
    _jspx_th_impact_validateInput_29.setName("hdnUlIdStage");
    _jspx_th_impact_validateInput_29.setValue("");
    int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
    if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_30(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_30.setType("hidden");
    _jspx_th_impact_validateInput_30.setName("bIndActiveStatus");
    _jspx_th_impact_validateInput_30.setValue("");
    int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
    if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_31(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_31.setType("hidden");
    _jspx_th_impact_validateInput_31.setName("bSysIndViewPersonInfo");
    _jspx_th_impact_validateInput_31.setValue("");
    int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
    if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
