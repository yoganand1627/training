package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;

public final class DeprivationOneSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  04/01/05  Todd Reser        SIR 23310 - Added _showWorkRelated, Javascript
                              functions, onClick commands, div sections and
                              re-worded questions.
  04/25/05  wadesa        SIR 23141 - Fixed the radio button for which parent
                              the child was living with.  This was resolved by
                              switching the getter methods for the indAbsentMother
                              field(radioButton).
  11/16/10  Hai Nguyen        SMS#81144: MR-053 Updated labels.
  11/30/10  Hai Nguyen        SMS#81144: Corrected some page display issue with js.
*/

{
  String _bgColor = "#F0FFFF";
  // SIR 23310 - We need to see which page is calling this sub so we use the
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

  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  boolean _disableDeprivation = (Boolean) request.getAttribute("disableDeprivation");
  FceEligibilityDB _fceEligibilityDB = (FceEligibilityDB) request.getAttribute("fceEligibilityDB");
  // SIR 23310 Added _showWorkRelated so we can show the option if it's checked
  // compensating for legacy data.
  boolean _showWorkRelated = _fceEligibilityDB.getIndAbsentWorkRelated();

  //SIR 23310 - Added four Javascript Functions

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction showAbsentReasons()\r\n{\r\n  var section = document.getElementById('wasAbsentSource');\r\n  section.style.display = 'block';\r\n}\r\n\r\nfunction showNotAbsent()\r\n{\r\n  var section = document.getElementById('wasNotAbsentSource');\r\n  section.style.display = 'block';\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentDied != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentDied.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentDeported != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentDeported.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentDeserted != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentDeserted.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentDivorced != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentDivorced.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentHospitalized != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentHospitalized.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentIncarcerated != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentIncarcerated.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentNeverCohabitated != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentNeverCohabitated.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentAltrntCustody != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentAltrntCustody.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentSeparated != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentSeparated.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentWorkRelated != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentWorkRelated.checked = false;\r\n  }\r\n  if (document.");
      out.print( localFormName );
      out.write(".indAbsentTprVolRelinq != null)\r\n  {\r\n    document.");
      out.print( localFormName );
      out.write(".indAbsentTprVolRelinq.checked = false;\r\n  }\r\n}\r\n\r\nfunction hideAbsentReasons()\r\n{\r\n  var section = document.getElementById('wasAbsentSource');\r\n  section.style.display = 'none';\r\n}\r\n\r\nfunction hideNotAbsent()\r\n{\r\n  var section = document.getElementById('wasNotAbsentSource');\r\n  wasNotAbsentSource.style.display = 'none';\r\n}\r\n</script>\r\n\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n  <tr>\r\n    <td width=\"25\"></td>\r\n    <td>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\" bgcolor=\"");
      out.print( _bgColor );
      out.write("\">\r\n  <tr>");
      out.write("\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Which Parent?</td>\r\n    <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setName("indAbsentMother");
      _jspx_th_impact_validateInput_0.setLabel("Mother");
      _jspx_th_impact_validateInput_0.setChecked( _fceEligibilityDB.getIndAbsentFatherString() );
      _jspx_th_impact_validateInput_0.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_0.setValue("true");
      _jspx_th_impact_validateInput_0.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_0.setType("radio");
      _jspx_th_impact_validateInput_0.setId("1");
      _jspx_th_impact_validateInput_0.setCssClass("formInput");
      _jspx_th_impact_validateInput_0.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n    <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setName("indAbsentMother");
      _jspx_th_impact_validateInput_1.setLabel("Father");
      _jspx_th_impact_validateInput_1.setChecked( _fceEligibilityDB.getIndAbsentMotherString() );
      _jspx_th_impact_validateInput_1.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_1.setValue("false");
      _jspx_th_impact_validateInput_1.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_1.setType("radio");
      _jspx_th_impact_validateInput_1.setId("2");
      _jspx_th_impact_validateInput_1.setCssClass("formInput");
      _jspx_th_impact_validateInput_1.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n  </tr>\r\n  <tr>\r\n");
 //SIR 23310 Reworded absence question 
      out.write("\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is the other\r\n          parent's absence because of employment outside the community or active\r\n          military duty?</td>\r\n");
 // SIR 23310 - Added onclick command 
      out.write("\r\n    <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_2.setParent(null);
      _jspx_th_impact_validateInput_2.setName("indAbsentMilitaryWork");
      _jspx_th_impact_validateInput_2.setLabel("Yes");
      _jspx_th_impact_validateInput_2.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentMilitaryWorkString())) );
      _jspx_th_impact_validateInput_2.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_2.setValue("true");
      _jspx_th_impact_validateInput_2.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_2.setType("radio");
      _jspx_th_impact_validateInput_2.setId("1");
      _jspx_th_impact_validateInput_2.setCssClass("formInput");
      _jspx_th_impact_validateInput_2.setOnClick("hideAbsentReasons();showNotAbsent();");
      _jspx_th_impact_validateInput_2.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
      if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n");
 // SIR 23310 - Added onclick command 
      out.write("\r\n    <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_3.setParent(null);
      _jspx_th_impact_validateInput_3.setName("indAbsentMilitaryWork");
      _jspx_th_impact_validateInput_3.setLabel("No");
      _jspx_th_impact_validateInput_3.setChecked( Boolean.toString("false".equals(_fceEligibilityDB.getIndAbsentMilitaryWorkString())) );
      _jspx_th_impact_validateInput_3.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_3.setValue("false");
      _jspx_th_impact_validateInput_3.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_3.setType("radio");
      _jspx_th_impact_validateInput_3.setId("2");
      _jspx_th_impact_validateInput_3.setCssClass("formInput");
      _jspx_th_impact_validateInput_3.setOnClick("showAbsentReasons();hideNotAbsent();");
      _jspx_th_impact_validateInput_3.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
      if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"3\">\r\n");
 // SIR 23310 - Added div sections wasNotAbsentSource and wasAbsentSource 
      out.write("\r\n    <div id=\"wasNotAbsentSource\" style=\"display: none\">\r\n    <B>In this situation, complete the section for Living with Both Parents by\r\n    selecting the above radio button.</B>\r\n    </div>\r\n    <div id=\"wasAbsentSource\" style=\"display: none\">\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" bgcolor=\"");
      out.print( _bgColor );
      out.write("\">\r\n      <tr>\r\n        <td colspan=\"3\"><span class=\"formCondRequiredText\">&#135;</span>&nbsp;What is the reason for the parent's continued absence from the home?</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_4.setParent(null);
      _jspx_th_impact_validateInput_4.setName("indAbsentDied");
      _jspx_th_impact_validateInput_4.setLabel("Death");
      _jspx_th_impact_validateInput_4.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDiedString())) );
      _jspx_th_impact_validateInput_4.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_4.setValue("true");
      _jspx_th_impact_validateInput_4.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_4.setType("checkbox");
      _jspx_th_impact_validateInput_4.setCssClass("formInput");
      _jspx_th_impact_validateInput_4.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
      if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_5.setParent(null);
      _jspx_th_impact_validateInput_5.setName("indAbsentDeported");
      _jspx_th_impact_validateInput_5.setLabel("Deportation");
      _jspx_th_impact_validateInput_5.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDeportedString())) );
      _jspx_th_impact_validateInput_5.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_5.setValue("true");
      _jspx_th_impact_validateInput_5.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_5.setType("checkbox");
      _jspx_th_impact_validateInput_5.setCssClass("formInput");
      _jspx_th_impact_validateInput_5.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
      if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_6.setParent(null);
      _jspx_th_impact_validateInput_6.setName("indAbsentDeserted");
      _jspx_th_impact_validateInput_6.setLabel("Desertion");
      _jspx_th_impact_validateInput_6.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDesertedString())) );
      _jspx_th_impact_validateInput_6.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_6.setValue("true");
      _jspx_th_impact_validateInput_6.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_6.setType("checkbox");
      _jspx_th_impact_validateInput_6.setCssClass("formInput");
      _jspx_th_impact_validateInput_6.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
      if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n      </tr>\r\n      <tr>\r\n");
 //SIR 23310 Reworded absence question 
      out.write("\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_7.setParent(null);
      _jspx_th_impact_validateInput_7.setName("indAbsentDivorced");
      _jspx_th_impact_validateInput_7.setLabel("Divorce");
      _jspx_th_impact_validateInput_7.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentDivorcedString())) );
      _jspx_th_impact_validateInput_7.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_7.setValue("true");
      _jspx_th_impact_validateInput_7.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_7.setType("checkbox");
      _jspx_th_impact_validateInput_7.setCssClass("formInput");
      _jspx_th_impact_validateInput_7.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
      if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n");
 //SIR 23310 Reworded absence question 
      out.write("\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_8.setParent(null);
      _jspx_th_impact_validateInput_8.setName("indAbsentHospitalized");
      _jspx_th_impact_validateInput_8.setLabel("Hospitalized");
      _jspx_th_impact_validateInput_8.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentHospitalizedString())) );
      _jspx_th_impact_validateInput_8.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_8.setValue("true");
      _jspx_th_impact_validateInput_8.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_8.setType("checkbox");
      _jspx_th_impact_validateInput_8.setCssClass("formInput");
      _jspx_th_impact_validateInput_8.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
      if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n");
 //SIR 23310 Reworded absence question 
      out.write("\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_9.setParent(null);
      _jspx_th_impact_validateInput_9.setName("indAbsentIncarcerated");
      _jspx_th_impact_validateInput_9.setLabel("Incarcerated");
      _jspx_th_impact_validateInput_9.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentIncarceratedString())) );
      _jspx_th_impact_validateInput_9.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_9.setValue("true");
      _jspx_th_impact_validateInput_9.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_9.setType("checkbox");
      _jspx_th_impact_validateInput_9.setCssClass("formInput");
      _jspx_th_impact_validateInput_9.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
      if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_10.setParent(null);
      _jspx_th_impact_validateInput_10.setName("indAbsentNeverCohabitated");
      _jspx_th_impact_validateInput_10.setLabel("Never lived in the home");
      _jspx_th_impact_validateInput_10.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentNeverCohabitatedString())) );
      _jspx_th_impact_validateInput_10.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_10.setValue("true");
      _jspx_th_impact_validateInput_10.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_10.setType("checkbox");
      _jspx_th_impact_validateInput_10.setCssClass("formInput");
      _jspx_th_impact_validateInput_10.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
      if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_11.setParent(null);
      _jspx_th_impact_validateInput_11.setName("indAbsentSeparated");
      _jspx_th_impact_validateInput_11.setLabel("Separated");
      _jspx_th_impact_validateInput_11.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentSeparatedString())) );
      _jspx_th_impact_validateInput_11.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_11.setValue("true");
      _jspx_th_impact_validateInput_11.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_11.setType("checkbox");
      _jspx_th_impact_validateInput_11.setCssClass("formInput");
      _jspx_th_impact_validateInput_11.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
      if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_12.setParent(null);
      _jspx_th_impact_validateInput_12.setName("indAbsentTprVolRelinq");
      _jspx_th_impact_validateInput_12.setLabel("TPR/Voluntary Relinquishment");
      _jspx_th_impact_validateInput_12.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentTprVolRelinqString())) );
      _jspx_th_impact_validateInput_12.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_12.setValue("true");
      _jspx_th_impact_validateInput_12.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_12.setType("checkbox");
      _jspx_th_impact_validateInput_12.setCssClass("formInput");
      _jspx_th_impact_validateInput_12.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
      if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n      </tr>\r\n");
 if (_showWorkRelated) { 
      out.write("\r\n      <tr>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_13.setParent(null);
      _jspx_th_impact_validateInput_13.setName("indAbsentWorkRelated");
      _jspx_th_impact_validateInput_13.setLabel("Work Related");
      _jspx_th_impact_validateInput_13.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentWorkRelatedString())) );
      _jspx_th_impact_validateInput_13.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_13.setValue("true");
      _jspx_th_impact_validateInput_13.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_13.setType("checkbox");
      _jspx_th_impact_validateInput_13.setCssClass("formInput");
      _jspx_th_impact_validateInput_13.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
      if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n        <td>");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_14.setParent(null);
      _jspx_th_impact_validateInput_14.setName("indAbsentAltrntCustody");
      _jspx_th_impact_validateInput_14.setLabel("Separated with alternative custody");
      _jspx_th_impact_validateInput_14.setChecked( Boolean.toString("true".equals(_fceEligibilityDB.getIndAbsentAltrntCustodyString())) );
      _jspx_th_impact_validateInput_14.setNoCheckboxChange(true);
      _jspx_th_impact_validateInput_14.setValue("true");
      _jspx_th_impact_validateInput_14.setDisabled( "" + _disableDeprivation );
      _jspx_th_impact_validateInput_14.setType("checkbox");
      _jspx_th_impact_validateInput_14.setCssClass("formInput");
      _jspx_th_impact_validateInput_14.setTabIndex( _tabIndex++ );
      int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
      if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("</td>\r\n        <td>&nbsp;</td>\r\n      </tr>\r\n");
 } 
      out.write("\r\n        </table>\r\n        </div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 //  Sir 23310 - Since the form fields are now generated and the browser has
   // populated them we can now call the appropriate Show fuction

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nif ( ( document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork[0] != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork[0].checked == true ) ||\r\n     ( document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork.value == 'true') )\r\n{\r\n  showNotAbsent();\r\n}\r\n\r\nif ( ( document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork[1] != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork[1].checked == true ) ||\r\n     ( document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork != null &&\r\n       document.");
      out.print( localFormName );
      out.write(".indAbsentMilitaryWork.value == 'false') )\r\n{\r\n  showAbsentReasons();\r\n}\r\n</script>\r\n");

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
