package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.DomicileDeprivationDB;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewConversation;
import gov.georgia.dhr.dfcs.sacwis.web.fce.DomicileDeprivationConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import java.util.ArrayList;
import java.util.List;

public final class DeprivationBothSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  10/18/04  Todd Reser        SIR 23056 - Added many JavaScript functions,
                              onClick commands added to certain fields, and
                              added additional comments & change log.
  10/22/04  Todd Reser        Had to add null checks to JavaScript functions
                              and call Show functions depending on values in
                              other fields because initial page display wasn't
                              functioning if the page was not in editable mode.
                              Also added ** comment to display on page.
  11/09/04  Todd Reser        Added null check for indParentDisabled to stop a
                              JS error when checking it's values upon page load.
  04/29/05  wadesa            SIR 23304 - Modified wordage is Question: "Was the
                              PE unemployed during the month of removal?" to
                              "Is the PE currently unemployed?"
  11/16/10  Hai Nguyen        SMS#81144: MR-053 Added additional questions
                              Added dropdown for selection of Principal Earner.
  11/30/10  Hai Nguyen        SMS#81144: Corrected some page display issues with
                              javascript.
  12/12/10  Hai Nguyen        SMS#86169: Updated wording for question.
                              
*/

{
  String _bgColor = "#F0FFFF";
  // SIR 23056 - We need to see which page is calling this sub so we use the
  // right form name
  String localFormName = "";
  if ("DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION".equals(request.getAttribute("level3Tab")))
  {
    localFormName = "frmDomicile";
  }
  if ("FC_REVIEW_APPLICATION_FOSTERCAREDETAIL".equals(request.getAttribute("level3Tab")) ||
      "FC_REVIEW_APPLICATION_FOSTERCAREREVIEW".equals(request.getAttribute("level3Tab")) )
  {
    localFormName = "frmReview";
  }
  String localPageMode = PageMode.getPageMode(request);
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableDeprivation = "" + (Boolean) request.getAttribute("disableDeprivation");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  DomicileDeprivationDB domicileDepDB = (DomicileDeprivationDB) request.getAttribute(DomicileDeprivationConversation.DOMICILEDB);

  //SIR 23056 - We have to see if the data is prior to the re-wording, contains
  //an N/A answer and not editable
  boolean lockedNA = false;
  if ( ( localPageMode.equals(PageModeConstants.INQUIRE) || localPageMode.equals(PageModeConstants.VIEW) ) &&
       ( FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) ||
         FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweIrregularUnder100())  ) )
  {
    lockedNA = true;
  }

  //Default amtPweIncomeString to nothing if there wasn't a value > 1 and not lockedNA.
  String amtPweIncomeString = "";
  if (_fceEligibilityDB.getAmtPweIncome()  >= 1 || lockedNA)
  {
    amtPweIncomeString = FormattingHelper.formatMoney(_fceEligibilityDB.getAmtPweIncome());
  }

  // SIR 23056 - The following Javascript functions show or hide the appropriate
  // sections.

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction showWasNotDisabled()\r\n{\r\n  var section = document.getElementById('wasNotDisabledSource');\r\n  section.style.display = 'block';\r\n  \r\n  if ( ( document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100[0] != null &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100[0].checked == true ) ||\r\n       ( document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100 != null &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100.value == 'Y' ) )\r\n  {\r\n    showWasNotEmployed();\r\n  }\r\n  else if ( ( document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100[1] != null &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100[1].checked == true ) ||\r\n       ( document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100 != null &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweSteadyUnder100.value == 'N' ) )\r\n  {\r\n    showWasEmployed();\r\n  }\r\n}\r\n\r\nfunction hideWasNotDisabled()\r\n{\r\n  hideWasNotEmployed();\r\n  hideWasEmployed();\r\n\r\n  var section = document.getElementById('wasNotDisabledSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWasDisabled()\r\n{\r\n  var section = document.getElementById('wasDisabledSource');\r\n  section.style.display = 'block';\r\n  \r\n  var e = document.getElementsByName('cdVerifMethod');\r\n  var v = getRadioButtonGroupValue('cdVerifMethod');\r\n\r\n  if( e != null && v == '");
      out.print( CodesTables.CVERMETH_D );
      out.write("' )\r\n  {\r\n    showVerifDocType();\r\n  } else if ( e != null && v == '");
      out.print( CodesTables.CVERMETH_M );
      out.write("' )\r\n  {\r\n    showMedicalEvidence();\r\n  }\r\n}\r\n\r\nfunction hideWasDisabled()\r\n{\r\n  var e = document.getElementsByName('cdVerifMethod');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideVerifDocType();\r\n  hideMedicalEvidence();\r\n\r\n  var section = document.getElementById('wasDisabledSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showMedicalEvidence()\r\n{\r\n  var section = document.getElementById('medicalEvidence');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction hideMedicalEvidence()\r\n{\r\n  var section = document.getElementById('medicalEvidence');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showVerifDocType()\r\n{\r\n  var section = document.getElementById('verifDocType');\r\n  section.style.display = 'block';\r\n  \r\n  var e = document.getElementsByName('cdVerifDocType');\r\n  var v = getRadioButtonGroupValue('cdVerifDocType');\r\n  \r\n  if( e != null && (v == '");
      out.print( CodesTables.CDOCTYPE_RR );
      out.write("' ||\r\n                    v == '");
      out.print( CodesTables.CDOCTYPE_RS );
      out.write("' ))\r\n  {\r\n    showRecvRrRsdi();\r\n  } else if ( e != null && v == '");
      out.print( CodesTables.CDOCTYPE_VA );
      out.write("' )\r\n  {\r\n    showRecv100PctVa();\r\n  }\r\n}\r\n\r\nfunction hideVerifDocType()\r\n{\r\n  var e = document.getElementsByName('cdVerifDocType');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideRecvRrRsdi();\r\n  hideRecv100PctVa();\r\n\r\n  var section = document.getElementById('verifDocType');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showRecvRrRsdi()\r\n{\r\n  var section = document.getElementById('recvRrRsdi');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction hideRecvRrRsdi()\r\n{\r\n  var e = document.getElementsByName('indRecvRrRsdi');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  var section = document.getElementById('recvRrRsdi');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showRecv100PctVa()\r\n{\r\n  var section = document.getElementById('recv100PctVa');\r\n  recv100PctVa.style.display = 'block';\r\n}\r\n\r\nfunction hideRecv100PctVa()\r\n{\r\n  var e = document.getElementsByName('indRecv100PctVa');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n");
      out.write("    e[i].checked = false;\r\n  }\r\n  var section = document.getElementById('recv100PctVa');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWasNotEmployed()\r\n{\r\n  var section = document.getElementById('wasNotEmployedSource');\r\n  section.style.display = 'block';\r\n  \r\n  var e = document.getElementsByName('indPeRecvUnemp');\r\n  var v = getRadioButtonGroupValue('indPeRecvUnemp');\r\n\r\n  if ( e != null && v == 'true' )\r\n  {\r\n    showEduTrnRejected();\r\n  }\r\n  else if ( e != null && v == 'false' )\r\n  {\r\n    showEduTrn();\r\n  }\r\n}\r\n\r\nfunction hideWasNotEmployed()\r\n{\r\n  var e = document.getElementsByName('indPeRecvUnemp');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideEduTrn();\r\n  hideEduTrnRejected();\r\n\r\n  var section = document.getElementById('wasNotEmployedSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWasEmployed()\r\n{\r\n  var section = document.getElementById('wasEmployedSource');\r\n  section.style.display = 'block';\r\n\r\n  if ( ( document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100[0] != null &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100[0].checked == true ) ||\r\n       ( document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100 != null  &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100.value == 'Y' ) ){\r\n      showWorksUnder100();\r\n  } else if ( ( document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100[1] != null &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100[1].checked == true ) ||\r\n       ( document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100 != null  &&\r\n         document.");
      out.print( localFormName );
      out.write(".cdPweIrregularUnder100.value == 'N' ) ){\r\n      showWorksOver100();\r\n  }\r\n}\r\n\r\nfunction hideWasEmployed()\r\n{\r\n  var e = document.getElementsByName('indPeRecvUnemp');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideEduTrnRejected();\r\n\r\n  var section = document.getElementById('wasEmployedSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWorksOver100()\r\n{\r\n  var section = document.getElementById('worksOver100Source');\r\n  section.style.display = 'block';\r\n  hideWorksUnder100();\r\n}\r\n\r\nfunction hideWorksOver100()\r\n{\r\n  var e = document.getElementsByName('cdPweSteadyOver100');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n\r\n  var section = document.getElementById('worksOver100Source');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showWorksUnder100()\r\n{\r\n  var section = document.getElementById('worksUnder100Source');\r\n  section.style.display = 'block';\r\n  hideWorksOver100();\r\n}\r\n\r\nfunction hideWorksUnder100()\r\n{\r\n  hideEduTrnRejected();\r\n");
      out.write("\r\n  var section = document.getElementById('worksUnder100Source');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showEduTrn()\r\n{\r\n  var section = document.getElementById('eduTrn');\r\n  section.style.display = 'block';\r\n\r\n  var e = document.getElementsByName('indPeWrkEngEduTrn');\r\n  var v = getRadioButtonGroupValue('indPeWrkEngEduTrn');\r\n  \r\n  if ( e != null && v == 'true' )\r\n  {\r\n    showEduTrnRejected();\r\n  }\r\n}\r\n\r\nfunction hideEduTrn()\r\n{\r\n  var e = document.getElementsByName('indPeWrkEngEduTrn');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n  hideEduTrnRejected();\r\n\r\n  var section = document.getElementById('eduTrn');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction showEduTrnRejected()\r\n{\r\n  var section = document.getElementById('eduTrnRejected');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction hideEduTrnRejected()\r\n{\r\n  var e = document.getElementsByName('indPeNotAcptEmpTrn');\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    e[i].checked = false;\r\n  }\r\n");
      out.write("\r\n  var section = document.getElementById('eduTrnRejected');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction getRadioButtonGroupValue( rboGroup )\r\n{\r\n  var e = document.getElementsByName(rboGroup);\r\n  for( var i = 0; e != null && i < e.length; i++ ){\r\n    if( e[i].checked == true )\r\n    {\r\n      return e[i].value;\r\n    }\r\n  }\r\n  return null;\r\n}\r\n\r\n</script>\r\n\r\n");

  // SIR 23056 - We have added onClicks to many of the fields so they will call
  // the hide or show functions when appropriate.

      out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n  <tr>\r\n    <td width=\"25\"></td>\r\n    <td>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\" bgcolor=\"");
      out.print( _bgColor );
      out.write("\">\r\n  <tr>\r\n    <td width=\"80%\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is either parent disabled or incapacitated?</td>\r\n    <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setName("indParentDisabled");
      _jspx_th_impact_validateInput_0.setLabel("Yes");
      _jspx_th_impact_validateInput_0.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndParentDisabledString())) );
      _jspx_th_impact_validateInput_0.setValue("true");
      _jspx_th_impact_validateInput_0.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_0.setType("radio");
      _jspx_th_impact_validateInput_0.setId("1");
      _jspx_th_impact_validateInput_0.setCssClass("formInput");
      _jspx_th_impact_validateInput_0.setOnClick("showWasDisabled();hideWasNotDisabled();");
      _jspx_th_impact_validateInput_0.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n    <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setName("indParentDisabled");
      _jspx_th_impact_validateInput_1.setLabel("No");
      _jspx_th_impact_validateInput_1.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndParentDisabledString())) );
      _jspx_th_impact_validateInput_1.setValue("false");
      _jspx_th_impact_validateInput_1.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_1.setType("radio");
      _jspx_th_impact_validateInput_1.setId("2");
      _jspx_th_impact_validateInput_1.setCssClass("formInput");
      _jspx_th_impact_validateInput_1.setOnClick("hideWasDisabled();showWasNotDisabled();");
      _jspx_th_impact_validateInput_1.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"3\">\r\n      <div id=\"wasDisabledSource\" style=\"display: none\">\r\n        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n          <tr>\r\n            <td width=\"80%\" colspan=\"3\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the months in which deprivation occurred due to disability or incapacity.</td>\r\n            <td width= \"20%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setType("text");
      _jspx_th_impact_validateInput_2.setConstraint("Paragraph80");
      _jspx_th_impact_validateInput_2.setName("txtMonthsDepDisabled");
      _jspx_th_impact_validateInput_2.setCssClass("formInput");
      _jspx_th_impact_validateInput_2.setValue( _fceEligibilityDB.getTxtMonthsDepDisabled() );
      _jspx_th_impact_validateInput_2.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_2.setSize("20");
      _jspx_th_impact_validateInput_2.setMaxLength("80");
      _jspx_th_impact_validateInput_2.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"50%\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Select the appropriate option to specify how you verified it.</td>\r\n            <td width= \"15%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_3.setParent(null);
      _jspx_th_impact_validateInput_3.setName("cdVerifMethod");
      _jspx_th_impact_validateInput_3.setLabel("Documentation");
      _jspx_th_impact_validateInput_3.setChecked( Boolean.toString(CodesTables.CVERMETH_D.equals(_fceEligibilityDB.getCdVerifMethod())) );
      _jspx_th_impact_validateInput_3.setValue( CodesTables.CVERMETH_D );
      _jspx_th_impact_validateInput_3.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_3.setType("radio");
      _jspx_th_impact_validateInput_3.setCssClass("formInput");
      _jspx_th_impact_validateInput_3.setOnClick("showVerifDocType();hideMedicalEvidence();");
      _jspx_th_impact_validateInput_3.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
      if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n            <td width=\"15%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_4.setParent(null);
      _jspx_th_impact_validateInput_4.setName("cdVerifMethod");
      _jspx_th_impact_validateInput_4.setLabel("Observation");
      _jspx_th_impact_validateInput_4.setChecked( Boolean.toString(CodesTables.CVERMETH_O.equals(_fceEligibilityDB.getCdVerifMethod())) );
      _jspx_th_impact_validateInput_4.setValue( CodesTables.CVERMETH_O );
      _jspx_th_impact_validateInput_4.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_4.setType("radio");
      _jspx_th_impact_validateInput_4.setCssClass("formInput");
      _jspx_th_impact_validateInput_4.setOnClick("hideVerifDocType();hideMedicalEvidence();");
      _jspx_th_impact_validateInput_4.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
      if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n            <td width=\"20%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_5.setParent(null);
      _jspx_th_impact_validateInput_5.setName("cdVerifMethod");
      _jspx_th_impact_validateInput_5.setLabel("Medical Evidence*");
      _jspx_th_impact_validateInput_5.setChecked( Boolean.toString(CodesTables.CVERMETH_M.equals(_fceEligibilityDB.getCdVerifMethod())) );
      _jspx_th_impact_validateInput_5.setValue( CodesTables.CVERMETH_M );
      _jspx_th_impact_validateInput_5.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_5.setType("radio");
      _jspx_th_impact_validateInput_5.setCssClass("formInput");
      _jspx_th_impact_validateInput_5.setOnClick("hideVerifDocType();showMedicalEvidence();");
      _jspx_th_impact_validateInput_5.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
      if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n          </tr>\r\n        </table>\r\n\t      <div id=\"medicalEvidence\" style=\"display: none\">\r\n\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t          <tr>\r\n\t            <td colspan=\"4\" align=\"right\"><span style=\"font-style: italic; font-size:xx-small\">* A Doctor's Letter must verify the disability and inability of the parent to work for at least 30 days.</span></td>\r\n\t          </tr>\r\n\t        </table>\r\n\t      </div>\r\n\t      <div id=\"verifDocType\" style=\"display: none\">\r\n\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Select the appropriate documentation type and provide award letter to Eligibility Specialist.</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_6.setParent(null);
      _jspx_th_impact_validateInput_6.setName("cdVerifDocType");
      _jspx_th_impact_validateInput_6.setLabel("Railroad Retirement");
      _jspx_th_impact_validateInput_6.setChecked( Boolean.toString(CodesTables.CDOCTYPE_RR.equals(_fceEligibilityDB.getCdVerifDocType())) );
      _jspx_th_impact_validateInput_6.setValue( CodesTables.CDOCTYPE_RR );
      _jspx_th_impact_validateInput_6.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_6.setType("radio");
      _jspx_th_impact_validateInput_6.setCssClass("formInput");
      _jspx_th_impact_validateInput_6.setOnClick("showRecvRrRsdi();hideRecv100PctVa();");
      _jspx_th_impact_validateInput_6.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
      if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_7.setParent(null);
      _jspx_th_impact_validateInput_7.setName("cdVerifDocType");
      _jspx_th_impact_validateInput_7.setLabel("RSDI");
      _jspx_th_impact_validateInput_7.setChecked( Boolean.toString(CodesTables.CDOCTYPE_RS.equals(_fceEligibilityDB.getCdVerifDocType())) );
      _jspx_th_impact_validateInput_7.setValue( CodesTables.CDOCTYPE_RS );
      _jspx_th_impact_validateInput_7.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_7.setType("radio");
      _jspx_th_impact_validateInput_7.setCssClass("formInput");
      _jspx_th_impact_validateInput_7.setOnClick("showRecvRrRsdi();hideRecv100PctVa();");
      _jspx_th_impact_validateInput_7.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
      if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_8.setParent(null);
      _jspx_th_impact_validateInput_8.setName("cdVerifDocType");
      _jspx_th_impact_validateInput_8.setLabel("SSI");
      _jspx_th_impact_validateInput_8.setChecked( Boolean.toString(CodesTables.CDOCTYPE_SS.equals(_fceEligibilityDB.getCdVerifDocType())) );
      _jspx_th_impact_validateInput_8.setValue( CodesTables.CDOCTYPE_SS );
      _jspx_th_impact_validateInput_8.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_8.setType("radio");
      _jspx_th_impact_validateInput_8.setCssClass("formInput");
      _jspx_th_impact_validateInput_8.setOnClick("hideRecvRrRsdi();hideRecv100PctVa();");
      _jspx_th_impact_validateInput_8.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
      if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_9.setParent(null);
      _jspx_th_impact_validateInput_9.setName("cdVerifDocType");
      _jspx_th_impact_validateInput_9.setLabel("Veteran's Disability");
      _jspx_th_impact_validateInput_9.setChecked( Boolean.toString(CodesTables.CDOCTYPE_VA.equals(_fceEligibilityDB.getCdVerifDocType())) );
      _jspx_th_impact_validateInput_9.setValue( CodesTables.CDOCTYPE_VA );
      _jspx_th_impact_validateInput_9.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_9.setType("radio");
      _jspx_th_impact_validateInput_9.setCssClass("formInput");
      _jspx_th_impact_validateInput_9.setOnClick("hideRecvRrRsdi();showRecv100PctVa();");
      _jspx_th_impact_validateInput_9.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
      if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_10.setParent(null);
      _jspx_th_impact_validateInput_10.setName("cdVerifDocType");
      _jspx_th_impact_validateInput_10.setLabel("Worker Compensation");
      _jspx_th_impact_validateInput_10.setChecked( Boolean.toString(CodesTables.CDOCTYPE_WC.equals(_fceEligibilityDB.getCdVerifDocType())) );
      _jspx_th_impact_validateInput_10.setValue( CodesTables.CDOCTYPE_WC );
      _jspx_th_impact_validateInput_10.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_10.setType("radio");
      _jspx_th_impact_validateInput_10.setCssClass("formInput");
      _jspx_th_impact_validateInput_10.setOnClick("hideRecvRrRsdi();hideRecv100PctVa();");
      _jspx_th_impact_validateInput_10.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
      if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t          </tr>\r\n\t          <tr>\r\n\t            <td>\r\n\t\t\t      <div id=\"recvRrRsdi\" style=\"display: none\">\r\n\t\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t          <tr>\r\n\t\t\t            <td width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is the disabled or incapacitated parent receiving RR or RSDI due to a disability?</td>\r\n\t\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_11.setParent(null);
      _jspx_th_impact_validateInput_11.setName("indRecvRrRsdi");
      _jspx_th_impact_validateInput_11.setLabel("Yes");
      _jspx_th_impact_validateInput_11.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndRecvRrRsdiString())) );
      _jspx_th_impact_validateInput_11.setValue("true");
      _jspx_th_impact_validateInput_11.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_11.setType("radio");
      _jspx_th_impact_validateInput_11.setCssClass("formInput");
      _jspx_th_impact_validateInput_11.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
      if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_12.setParent(null);
      _jspx_th_impact_validateInput_12.setName("indRecvRrRsdi");
      _jspx_th_impact_validateInput_12.setLabel("No");
      _jspx_th_impact_validateInput_12.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndRecvRrRsdiString())) );
      _jspx_th_impact_validateInput_12.setValue("false");
      _jspx_th_impact_validateInput_12.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_12.setType("radio");
      _jspx_th_impact_validateInput_12.setCssClass("formInput");
      _jspx_th_impact_validateInput_12.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
      if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t\t          </tr>\r\n\t\t\t        </table>\r\n\t\t\t      </div>\r\n\t\t\t      <div id=\"recv100PctVa\" style=\"display: none\">\r\n\t\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t          <tr>\r\n\t\t\t            <td width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is the disabled or incapacitated parent receiving 100% VA?</td>\r\n\t\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_13.setParent(null);
      _jspx_th_impact_validateInput_13.setName("indRecv100PctVa");
      _jspx_th_impact_validateInput_13.setLabel("Yes");
      _jspx_th_impact_validateInput_13.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndRecv100PctVaString())) );
      _jspx_th_impact_validateInput_13.setValue("true");
      _jspx_th_impact_validateInput_13.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_13.setType("radio");
      _jspx_th_impact_validateInput_13.setCssClass("formInput");
      _jspx_th_impact_validateInput_13.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
      if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_14.setParent(null);
      _jspx_th_impact_validateInput_14.setName("indRecv100PctVa");
      _jspx_th_impact_validateInput_14.setLabel("No");
      _jspx_th_impact_validateInput_14.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndRecv100PctVaString())) );
      _jspx_th_impact_validateInput_14.setValue("false");
      _jspx_th_impact_validateInput_14.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_14.setType("radio");
      _jspx_th_impact_validateInput_14.setCssClass("formInput");
      _jspx_th_impact_validateInput_14.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
      if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t\t          </tr>\r\n\t\t\t        </table>\r\n\t\t\t      </div>\r\n\t            </td>\r\n\t          </tr>\r\n\t        </table>\r\n\t      </div>\r\n      </div>\r\n    ");

      List exOptions = new ArrayList();
        exOptions.add(_fceEligibilityDB.getIdFcePersonString());
    
      out.write("\r\n      <div id=\"wasNotDisabledSource\" style=\"display: none\">\r\n        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n          <tr>\r\n            <td width=\"80%\" colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Who is the Principal Earner* (PE) in the home of removal?</td>\r\n            <td width=\"20%\" colspan=\"2\">");
      //  impact:validateSelect
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
      _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateSelect_0.setParent(null);
      _jspx_th_impact_validateSelect_0.setName("idPrnEarner");
      _jspx_th_impact_validateSelect_0.setLabel("");
      _jspx_th_impact_validateSelect_0.setValue( _fceEligibilityDB.getIdPrnEarnerString());
      _jspx_th_impact_validateSelect_0.setOptions( FceUtility.getOptionsFromPrinciples(domicileDepDB.getPrinciples()));
      _jspx_th_impact_validateSelect_0.setExcludeOptions(exOptions);
      _jspx_th_impact_validateSelect_0.setTabIndex( _tabIndex++ );
      _jspx_th_impact_validateSelect_0.setBlankValue("true");
      int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
      if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"4\" align=\"right\"><span style=\"font-style: italic; font-size:xx-small\">* Principal Earner is defined as the parent who has earned the most income in the last two years.</span></td>\r\n          </tr>\r\n          <tr>\r\n            ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
            if (lockedNA) { 
      out.write("\r\n              <td width=\"70%\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;If the PE has <b>steady</b> employment, does the PE work less than 100 hours per month?</td>\r\n            ");
 } else { 
      out.write("\r\n            ");
// SIR 23304 - Modified wordage in question below. 
      out.write("\r\n              <td width=\"80%\" colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE been <b>unemployed</b> for 30 consecutive days prior to the date of removal?</td>\r\n            ");
 } 
      out.write("\r\n            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_15.setParent(null);
      _jspx_th_impact_validateInput_15.setName("cdPweSteadyUnder100");
      _jspx_th_impact_validateInput_15.setLabel("Yes");
      _jspx_th_impact_validateInput_15.setChecked( "" + FosterCareReviewConversation.YES.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) );
      _jspx_th_impact_validateInput_15.setValue("Y");
      _jspx_th_impact_validateInput_15.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_15.setType("radio");
      _jspx_th_impact_validateInput_15.setId("1");
      _jspx_th_impact_validateInput_15.setCssClass("formInput");
      _jspx_th_impact_validateInput_15.setOnClick("hideWasEmployed();showWasNotEmployed();");
      _jspx_th_impact_validateInput_15.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
      if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_16.setParent(null);
      _jspx_th_impact_validateInput_16.setName("cdPweSteadyUnder100");
      _jspx_th_impact_validateInput_16.setLabel("No");
      _jspx_th_impact_validateInput_16.setChecked( "" + FosterCareReviewConversation.NO.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) );
      _jspx_th_impact_validateInput_16.setValue("N");
      _jspx_th_impact_validateInput_16.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_16.setType("radio");
      _jspx_th_impact_validateInput_16.setId("2");
      _jspx_th_impact_validateInput_16.setCssClass("formInput");
      _jspx_th_impact_validateInput_16.setOnClick("hideWasNotEmployed();showWasEmployed();");
      _jspx_th_impact_validateInput_16.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
      if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n            ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
            if (lockedNA) { 
      out.write("\r\n            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_17.setParent(null);
      _jspx_th_impact_validateInput_17.setName("cdPweSteadyUnder100");
      _jspx_th_impact_validateInput_17.setLabel("N/A");
      _jspx_th_impact_validateInput_17.setChecked( "" + FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweSteadyUnder100()) );
      _jspx_th_impact_validateInput_17.setValue("A");
      _jspx_th_impact_validateInput_17.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_17.setType("radio");
      _jspx_th_impact_validateInput_17.setId("3");
      _jspx_th_impact_validateInput_17.setCssClass("formInput");
      _jspx_th_impact_validateInput_17.setOnClick("showWasEmployed();hideWasNotEmployed();");
      _jspx_th_impact_validateInput_17.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
      if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n            ");
 } 
      out.write("\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"4\">\r\n\t\t      <div id=\"wasNotEmployedSource\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the months in which deprivation occurred due to unemployment.</td>\r\n\t\t            <td width=\"20%\" colspan=\"2\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_18.setParent(null);
      _jspx_th_impact_validateInput_18.setType("text");
      _jspx_th_impact_validateInput_18.setConstraint("Paragraph80");
      _jspx_th_impact_validateInput_18.setName("txtMonthsDepUnemp");
      _jspx_th_impact_validateInput_18.setCssClass("formInput");
      _jspx_th_impact_validateInput_18.setValue( _fceEligibilityDB.getTxtMonthsDepUnemp() );
      _jspx_th_impact_validateInput_18.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_18.setSize("20");
      _jspx_th_impact_validateInput_18.setMaxLength("80");
      _jspx_th_impact_validateInput_18.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
      if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t          </tr>\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Does the PE now or has the PE within the last 12 months received Unemployment Compensation benefits?</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_19.setParent(null);
      _jspx_th_impact_validateInput_19.setName("indPeRecvUnemp");
      _jspx_th_impact_validateInput_19.setLabel("Yes");
      _jspx_th_impact_validateInput_19.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndPeRecvUnempString())) );
      _jspx_th_impact_validateInput_19.setValue("true");
      _jspx_th_impact_validateInput_19.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_19.setType("radio");
      _jspx_th_impact_validateInput_19.setId("1");
      _jspx_th_impact_validateInput_19.setCssClass("formInput");
      _jspx_th_impact_validateInput_19.setOnClick("hideEduTrn();showEduTrnRejected();");
      _jspx_th_impact_validateInput_19.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
      if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_20.setParent(null);
      _jspx_th_impact_validateInput_20.setName("indPeRecvUnemp");
      _jspx_th_impact_validateInput_20.setLabel("No");
      _jspx_th_impact_validateInput_20.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndPeRecvUnempString())) );
      _jspx_th_impact_validateInput_20.setValue("false");
      _jspx_th_impact_validateInput_20.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_20.setType("radio");
      _jspx_th_impact_validateInput_20.setId("2");
      _jspx_th_impact_validateInput_20.setCssClass("formInput");
      _jspx_th_impact_validateInput_20.setOnClick("showEduTrn();hideEduTrnRejected();");
      _jspx_th_impact_validateInput_20.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
      if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t          </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n\t\t      <div id=\"eduTrn\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE worked or been engaged in Education training activities within the last 12 months?</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_21.setParent(null);
      _jspx_th_impact_validateInput_21.setName("indPeWrkEngEduTrn");
      _jspx_th_impact_validateInput_21.setLabel("Yes");
      _jspx_th_impact_validateInput_21.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndPeWrkEngEduTrnString())) );
      _jspx_th_impact_validateInput_21.setValue("true");
      _jspx_th_impact_validateInput_21.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_21.setType("radio");
      _jspx_th_impact_validateInput_21.setId("1");
      _jspx_th_impact_validateInput_21.setCssClass("formInput");
      _jspx_th_impact_validateInput_21.setOnClick("showEduTrnRejected();");
      _jspx_th_impact_validateInput_21.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
      if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_22.setParent(null);
      _jspx_th_impact_validateInput_22.setName("indPeWrkEngEduTrn");
      _jspx_th_impact_validateInput_22.setLabel("No");
      _jspx_th_impact_validateInput_22.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndPeWrkEngEduTrnString())) );
      _jspx_th_impact_validateInput_22.setValue("false");
      _jspx_th_impact_validateInput_22.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_22.setType("radio");
      _jspx_th_impact_validateInput_22.setId("2");
      _jspx_th_impact_validateInput_22.setCssClass("formInput");
      _jspx_th_impact_validateInput_22.setOnClick("hideEduTrnRejected();");
      _jspx_th_impact_validateInput_22.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
      if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t          </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n\t\t      <div id=\"eduTrnRejected\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE failed to accept an offer of employment or training for employment within 30 consecutive days prior to removal?</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_23.setParent(null);
      _jspx_th_impact_validateInput_23.setName("indPeNotAcptEmpTrn");
      _jspx_th_impact_validateInput_23.setLabel("Yes");
      _jspx_th_impact_validateInput_23.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndPeNotAcptEmpTrnString())) );
      _jspx_th_impact_validateInput_23.setValue("true");
      _jspx_th_impact_validateInput_23.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_23.setType("radio");
      _jspx_th_impact_validateInput_23.setId("1");
      _jspx_th_impact_validateInput_23.setCssClass("formInput");
      _jspx_th_impact_validateInput_23.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
      if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_24.setParent(null);
      _jspx_th_impact_validateInput_24.setName("indPeNotAcptEmpTrn");
      _jspx_th_impact_validateInput_24.setLabel("No");
      _jspx_th_impact_validateInput_24.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndPeNotAcptEmpTrnString())) );
      _jspx_th_impact_validateInput_24.setValue("false");
      _jspx_th_impact_validateInput_24.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_24.setType("radio");
      _jspx_th_impact_validateInput_24.setId("2");
      _jspx_th_impact_validateInput_24.setCssClass("formInput");
      _jspx_th_impact_validateInput_24.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
      if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t          </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n\t\t      <div id=\"wasEmployedSource\" style=\"display: none\">\r\n\t\t        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t          <tr>\r\n\t\t          ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
		          if (lockedNA) { 
      out.write("\r\n\t\t            <td width=\"70%\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;If the PE works <b>irregularly</b>, does the PE work less than 100 hours per month on average?</td>\r\n\t\t          ");
 } else { 
      out.write("\r\n\t\t            <td width=\"80%\" colspan=\"2\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;Has the PE worked less than 100 hours (underemployed) in 30 consecutive days prior to the date of removal and continues to work <b>less</b> than 100 hours?</td>\r\n\t\t          ");
 } 
      out.write("\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_25.setParent(null);
      _jspx_th_impact_validateInput_25.setName("cdPweIrregularUnder100");
      _jspx_th_impact_validateInput_25.setLabel("Yes");
      _jspx_th_impact_validateInput_25.setChecked( "" + FosterCareReviewConversation.YES.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) );
      _jspx_th_impact_validateInput_25.setValue("Y");
      _jspx_th_impact_validateInput_25.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_25.setType("radio");
      _jspx_th_impact_validateInput_25.setId("1");
      _jspx_th_impact_validateInput_25.setCssClass("formInput");
      _jspx_th_impact_validateInput_25.setOnClick("showWorksUnder100();");
      _jspx_th_impact_validateInput_25.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
      if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_26.setParent(null);
      _jspx_th_impact_validateInput_26.setName("cdPweIrregularUnder100");
      _jspx_th_impact_validateInput_26.setLabel("No");
      _jspx_th_impact_validateInput_26.setChecked( "" + FosterCareReviewConversation.NO.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) );
      _jspx_th_impact_validateInput_26.setValue("N");
      _jspx_th_impact_validateInput_26.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_26.setType("radio");
      _jspx_th_impact_validateInput_26.setId("2");
      _jspx_th_impact_validateInput_26.setCssClass("formInput");
      _jspx_th_impact_validateInput_26.setOnClick("hideWorksUnder100();");
      _jspx_th_impact_validateInput_26.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
      if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t            ");
 //SIR 23056 - We have to display the legacy questions if it's old data.
		            if (lockedNA) { 
      out.write("\r\n\t\t            <td width=\"10%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_27.setParent(null);
      _jspx_th_impact_validateInput_27.setName("cdPweIrregularUnder100");
      _jspx_th_impact_validateInput_27.setLabel("N/A");
      _jspx_th_impact_validateInput_27.setChecked( "" + FosterCareReviewConversation.NA.equals(_fceEligibilityDB.getCdPweIrregularUnder100()) );
      _jspx_th_impact_validateInput_27.setValue("A");
      _jspx_th_impact_validateInput_27.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_27.setType("radio");
      _jspx_th_impact_validateInput_27.setId("3");
      _jspx_th_impact_validateInput_27.setCssClass("formInput");
      _jspx_th_impact_validateInput_27.setOnClick("showWorksOver100();");
      _jspx_th_impact_validateInput_27.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
      if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t            ");
 } 
      out.write("\r\n\t\t          </tr>\r\n\t\t          <tr>\r\n\t\t\t        <td colspan=\"4\">\r\n\t\t\t          <div id=\"worksUnder100Source\" style=\"display: none\">\r\n\t\t\t            <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t\t\t              <tr>\r\n\t\t\t                <td width=\"80%\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;List the months in which deprivation occurred due to underemployment.</td>\r\n\t\t\t                <td width= \"20%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_28.setParent(null);
      _jspx_th_impact_validateInput_28.setType("text");
      _jspx_th_impact_validateInput_28.setConstraint("Paragraph80");
      _jspx_th_impact_validateInput_28.setName("txtMonthsDepUnderEmpl");
      _jspx_th_impact_validateInput_28.setCssClass("formInput");
      _jspx_th_impact_validateInput_28.setValue( _fceEligibilityDB.getTxtMonthsDepUnderEmpl() );
      _jspx_th_impact_validateInput_28.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_28.setSize("20");
      _jspx_th_impact_validateInput_28.setMaxLength("80");
      _jspx_th_impact_validateInput_28.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
      if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n\t\t\t              </tr>\r\n\t\t\t            </table>\r\n\t\t\t          </div>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t        </table>\r\n\t\t      </div>\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n");
 //SIR 23056 - We have to display the legacy questions if it's old data.
if (lockedNA) { 
      out.write("\r\n  <tr>\r\n    <td colspan=\"3\">\r\n      <div id=\"worksOver100Source\" style=\"display: none\">\r\n        <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n          <tr>\r\n            <td width=\"70%\">&nbsp;&nbsp;&nbsp;<span class=\"formCondRequiredText\">&#135;</span>&nbsp;What is his/her gross monthly earned income?</td>\r\n            <td width=\"30%\">");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_29.setParent(null);
      _jspx_th_impact_validateInput_29.setName("amtPweIncomeMoney");
      _jspx_th_impact_validateInput_29.setValue( amtPweIncomeString );
      _jspx_th_impact_validateInput_29.setDisabled( _disableDeprivation );
      _jspx_th_impact_validateInput_29.setType("text");
      _jspx_th_impact_validateInput_29.setCssClass("formInput");
      _jspx_th_impact_validateInput_29.setSize("13");
      _jspx_th_impact_validateInput_29.setConstraint("Money11");
      _jspx_th_impact_validateInput_29.setMaxLength("13");
      _jspx_th_impact_validateInput_29.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
      if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n          </tr>\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n");
 } 
      out.write("\r\n</table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 //  Sir 23056 - Since the form fields are now generated and the browser has
   // populated them we can now call the appropriate Show fuction

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nif ( ( document.");
      out.print( localFormName );
      out.write(".indParentDisabled != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indParentDisabled[0] != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indParentDisabled[0].checked == true ) ||\r\n     ( document.");
      out.print( localFormName );
      out.write(".indParentDisabled != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indParentDisabled.value == 'true') )\r\n{\r\n  showWasDisabled();\r\n}\r\n\r\nif ( ( document.");
      out.print( localFormName );
      out.write(".indParentDisabled != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indParentDisabled[1] != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indParentDisabled[1].checked == true ) ||\r\n     ( document.");
      out.print( localFormName );
      out.write(".indParentDisabled != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indParentDisabled.value == 'false') )\r\n{\r\n  showWasNotDisabled();\r\n}\r\n</script>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

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
}
