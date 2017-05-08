package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonIncidentAFCARSInformationSO;

public final class NonIncidentAFCARSInformation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  
  NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO = (NonIncidentAFCARSInformationSO) state.getAttribute("nonIncidentAFCARSInformationSO", request);
  Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );
  List motherRaceValues = new ArrayList<String>();
  List fatherRaceValues = new ArrayList<String>();
  List raceValues = new ArrayList<String>();
  

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\n// make sure that the race checkboxes are cleared if the undecided checkbox is checked\r\nfunction clearRaces( paramCbx, paramGroup )\r\n{\r\n  var raceLen = ");
      out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
      out.write(";\r\n\r\n  if ( paramCbx.checked == true )\r\n  {\r\n    // if you checked the Unable to Determine checkbox, make sure that all the others\r\n    // are unchecked\r\n    if ( paramCbx.value == \"");
      out.print( CodesTables.CRACE_UD  );
      out.write("\" )\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = paramGroup + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value != \"");
      out.print( CodesTables.CRACE_UD );
      out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n    // else, if you checked any others, make sure Unable to Determine is unchecked\r\n    else\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = paramGroup + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value == \"");
      out.print( CodesTables.CRACE_UD );
      out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmNonIncidentAFCARSInformation");
      _jspx_th_impact_validateForm_0.setAction("/person/NonIncidentAFCARSInformation/saveAFCARSInformation");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.NonIncidentAFCARSInformationCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t<!-- Child Information HTML Table -->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\twidth=\"100%\" id=\"TABLE1\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"3\">\r\n\t\t\t\tChild Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date Application Sent");
          _jspx_th_impact_validateDate_0.setName("dtApplicationSent");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtApplicationSent()));
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled("true");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\tDFCS County: ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CCOUNT, nonIncidentAFCARSInformationSO.getCdPlacmentCounty()));
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"3\">\r\n\t\t\t\tCase Worker: ");
          out.print( nonIncidentAFCARSInformationSO.getNmEmployee() );
          out.write("&nbsp; ");
          out.print( nonIncidentAFCARSInformationSO.getEmployeePhone());
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<!-- End Child Information Table -->\r\n\r\n\t<!-- Child Characteristics HTML Table -->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\twidth=\"100%\" id=\"TABLE3\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tSpecial Needs Characteristics\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\tPrimary Special Need?\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td colspan=\"4\">\r\n\t               ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("szCdPrmSpcNeed");
          _jspx_th_impact_validateSelect_0.setLabel("");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setCodesTable("CPRSPCLN");
          _jspx_th_impact_validateSelect_0.setValue( nonIncidentAFCARSInformationSO.getCdPrimSpecNeed() );
          _jspx_th_impact_validateSelect_0.setDisabled("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \t\t\t\r\n\t\t\t</td>\t\t\t\r\n\t\t</tr>\t\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setName("cbxMntlRetard");
          _jspx_th_impact_validateInput_0.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01));
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setChecked( ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndMentRetard()))?"true":"false" );
          _jspx_th_impact_validateInput_0.setValue("Y");
          _jspx_th_impact_validateInput_0.setDisabled("true");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("szCdMntRetSevLevel");
          _jspx_th_impact_validateSelect_1.setLabel("");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setCodesTable("CADSEVER");
          _jspx_th_impact_validateSelect_1.setValue( nonIncidentAFCARSInformationSO.getCdSevMentRetard() );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\t\t\t\t\t\t\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setName("cbxVislHearImp");
          _jspx_th_impact_validateInput_1.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02));
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setChecked( ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndVisHearImp()))?"true":"false" );
          _jspx_th_impact_validateInput_1.setValue("Y");
          _jspx_th_impact_validateInput_1.setDisabled("true");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("szCdVisHearSevLevel");
          _jspx_th_impact_validateSelect_2.setLabel("");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setCodesTable("CADSEVER");
          _jspx_th_impact_validateSelect_2.setValue( nonIncidentAFCARSInformationSO.getCdSevVisHearImp());
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\t\t\t\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setName("cbxPhyDisabled");
          _jspx_th_impact_validateInput_2.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03));
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setChecked( ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndPhyDisabled()))?"true":"false");
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setDisabled("true");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("szCdPhyDisSevLevel");
          _jspx_th_impact_validateSelect_3.setLabel("");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setCodesTable("CADSEVER");
          _jspx_th_impact_validateSelect_3.setValue( nonIncidentAFCARSInformationSO.getCdSevPhyDisabled());
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setName("cbxEmtDisturbed");
          _jspx_th_impact_validateInput_3.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04));
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setChecked( ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndEmtDisturbed()))?"true":"false" );
          _jspx_th_impact_validateInput_3.setValue("Y");
          _jspx_th_impact_validateInput_3.setDisabled("true");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("szCdEmtDistSevLevel");
          _jspx_th_impact_validateSelect_4.setLabel("");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setCodesTable("CADSEVER");
          _jspx_th_impact_validateSelect_4.setValue( nonIncidentAFCARSInformationSO.getCdSevEmtDisturbed() );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName("cbxOthMedDiag");
          _jspx_th_impact_validateInput_4.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05));
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setChecked( ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndOthMedDiag()))?"true":"false" );
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setDisabled("true");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setName("szCdOthMedDiagSevLevel");
          _jspx_th_impact_validateSelect_5.setLabel("");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setCodesTable("CADSEVER");
          _jspx_th_impact_validateSelect_5.setValue( nonIncidentAFCARSInformationSO.getCdSevOthMedDiag());
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\t\t\t\r\n\t\t</tr>\r\n\t</table>\r\n\t<!-- End Child Characteristics Table -->\r\n    <br>\r\n\r\n\t<!-- Birth Parents Expandable/Collapsable Section -->\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("BirthParents");
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Birth Parents");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\r\n\t\t<!-- Child Birth Name Table -->\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"tableborder\">\r\n\t\t  <tr><td>\r\n\t\t  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">  \r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"8\">\r\n\t\t\t\t\tChild Birth Name\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("text");
              _jspx_th_impact_validateInput_5.setLabel("First Name");
              _jspx_th_impact_validateInput_5.setConstraint("Name12");
              _jspx_th_impact_validateInput_5.setName("txtSzNmBirthNameFirst");
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              _jspx_th_impact_validateInput_5.setValue( nonIncidentAFCARSInformationSO.getNmBirthNameFirst() );
              _jspx_th_impact_validateInput_5.setSize("12");
              _jspx_th_impact_validateInput_5.setMaxLength("12");
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setType("text");
              _jspx_th_impact_validateInput_6.setLabel("Middle Name");
              _jspx_th_impact_validateInput_6.setConstraint("Name12");
              _jspx_th_impact_validateInput_6.setName("txtSzNmBirthNameMiddle");
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              _jspx_th_impact_validateInput_6.setValue( nonIncidentAFCARSInformationSO.getNmBirthNameMiddle() );
              _jspx_th_impact_validateInput_6.setSize("12");
              _jspx_th_impact_validateInput_6.setMaxLength("12");
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("text");
              _jspx_th_impact_validateInput_7.setLabel("Last name");
              _jspx_th_impact_validateInput_7.setConstraint("Name22");
              _jspx_th_impact_validateInput_7.setName("txtSzNmBirthNameLast");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              _jspx_th_impact_validateInput_7.setValue( nonIncidentAFCARSInformationSO.getNmBirthNameLast() );
              _jspx_th_impact_validateInput_7.setSize("22");
              _jspx_th_impact_validateInput_7.setMaxLength("22");
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t  </table>\r\n\t\t  <!-- End Child Birth Name Table -->\r\n\t\t  \r\n\t\t  \r\n\t\t <!-- Birth Mother Table --> \r\n\t\t <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t  <tr>\r\n\t\t    <th colspan=\"4\">Birth Mother</th>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t\t<td>\r\n\t\t\t\tMother Married At Child's Birth:\r\n\t\t\t</td>\r\n\t\t  \t<td>\r\n\t\t  \t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CMOTHMAR, nonIncidentAFCARSInformationSO.getIndBMMarriedAtChildBrth()));
              out.write("\r\n\t\t  \t</td>\r\n\t\t  \t<td colspan=\"2\">\r\n\t\t  \t</td>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t    <td>\r\n\t\t        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_1.setName("txtDtBMDOB");
              _jspx_th_impact_validateDate_1.setLabel("Date of Birth");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthMotherDOB()) );
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t    </td>\r\n\t\t    <td>\r\n\t\t       \t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setName("szCdBMTermType");
              _jspx_th_impact_validateSelect_6.setLabel("Termination Type");
              _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_6.setCodesTable("CTRMTYPE");
              _jspx_th_impact_validateSelect_6.setValue( nonIncidentAFCARSInformationSO.getCdBirthMotherTermType());
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t    <td>\r\n\t\t        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_2.setName("txtDtBMRightsTerm");
              _jspx_th_impact_validateDate_2.setLabel("Date Rights Terminated");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthMotherRightsTerm()) );
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("    \r\n\t\t    </td>\r\n\t\t    <td>&nbsp;</td>\r\n\t\t    <td>&nbsp;</td>\r\n\t\t  </tr>\r\n\t\t</table>\r\n\t\t<!-- End Birth Mother Table -->\r\n\t\t  \r\n\t\t\r\n\t\t  <!-- Birth Mother's Race/Ethnicity Table -->\r\n\t\t  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"8\">\r\n\t\t\t\t\tBirth Mother's Race\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes( nonIncidentAFCARSInformationSO.getBMRaceList() );
              _jspx_th_impact_codesCheckbox_0.setName("cbxMotherRace");
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_0.setOnClick("clearRaces(this,'cbxMotherRace')");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tBirth Mother's Ethnicity\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n            <tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t");

                               for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
                               {
                                   Mapping ethnicity = (Mapping) ethIterator.next();
                            
              out.write("\r\n\t\t\t\t\t\t\t       <td>\r\n\t\t\t\t\t\t\t\t        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_8.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setName("rbMotherEthnicity");
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setChecked( String.valueOf( ethnicity.getKey().equals( nonIncidentAFCARSInformationSO.getCdBMEthnicity()) ) );
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t        ");
              out.print( ethnicity.getValue() );
              out.write("\r\n\t\t\t\t\t\t\t      </td>\r\n\t\t\t\t\t\t\t");

                               }
                            
              out.write("\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t<!-- End Birth Mother's Race/Ethnicity Table -->\r\n\t\t\r\n\t\t<!-- Birth Father Table --> \r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t  <tr>\r\n\t\t    <th colspan=\"4\">Birth Father</th>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t    <td>\r\n\t\t        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_3.setName("txtDtBFDOB");
              _jspx_th_impact_validateDate_3.setLabel("Date of Birth");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              _jspx_th_impact_validateDate_3.setValue( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthFatherDOB()));
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t    </td>\r\n\t\t    <td>\r\n\t\t       \t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setName("szCdBFTermType");
              _jspx_th_impact_validateSelect_7.setLabel("Termination Type");
              _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_7.setCodesTable("CTRMTYPE");
              _jspx_th_impact_validateSelect_7.setValue( nonIncidentAFCARSInformationSO.getCdBirthFatherTermType());
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t    <td>\r\n\t\t        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_4.setName("txtDtBFRightsTerm");
              _jspx_th_impact_validateDate_4.setLabel("Date Rights Terminated");
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              _jspx_th_impact_validateDate_4.setValue( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthFatherRightsTerm()));
              _jspx_th_impact_validateDate_4.setSize("10");
              _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("    \r\n\t\t    </td>\r\n\t\t    <td>&nbsp;</td>\r\n\t\t    <td>&nbsp;</td>\r\n\r\n\t\t  </tr>\r\n\t\t</table>\r\n\t\t<!-- End Birth Father Table --> \r\n\t\t\r\n\t\t<!-- Birth Father's Race/Ethnicity Table -->\r\n\t\t  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"8\">\r\n\t\t\t\t\tBirth Father's Race\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes( nonIncidentAFCARSInformationSO.getBFRaceList() );
              _jspx_th_impact_codesCheckbox_1.setName("cbxFatherRace");
              _jspx_th_impact_codesCheckbox_1.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_1.setOnClick("clearRaces(this,'cbxFatherRace')");
              _jspx_th_impact_codesCheckbox_1.setColumns(3);
              _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tBirth Father's Ethnicity\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n            <tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t");

                               for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
                               {
                                   Mapping ethnicity = (Mapping) ethIterator.next();
                            
              out.write("\r\n\t\t\t\t\t\t\t       <td>\r\n\t\t\t\t\t\t\t\t        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setName("rbFatherEthnicity");
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setChecked( String.valueOf( ethnicity.getKey().equals( nonIncidentAFCARSInformationSO.getCdBFEthnicity()) ) );
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t        ");
              out.print( ethnicity.getValue() );
              out.write("\r\n\t\t\t\t\t\t\t      </td>\r\n\t\t\t\t\t\t\t");

                               }
                            
              out.write("\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\t\t\r\n\t\t<!-- End Birth Father's Race/Ethnicity Table -->\t\r\n\t\t</td></tr>\r\n      </table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <!-- End Birth Parents Expandable/Collapsable Section -->\r\n    <br>\r\n\r\n    <!-- Adoptive Parents Expandable/Collapsable Section -->\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("AdoptiveParents");
          _jspx_th_impact_ExpandableSectionTag_1.setId("");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Adoptive Parents");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"tableborder\">\r\n\t\t   <tr class=\"subDetail\"><td>\r\n\t\t       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t          <tr>\r\n\t\t             <td>Family Structure:&nbsp;");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CMARSTAT,nonIncidentAFCARSInformationSO.getCdMaritalStatus()) );
              out.write("</td>\r\n\t\t             <td>&nbsp;</td>\r\n\t\t             <td>&nbsp;</td>\r\n\t\t             <td>&nbsp;</td>\r\n\t\t          </tr>\r\n\t\t          <tr>\r\n\t\t             <td>Child Placed From:&nbsp;");
              out.print(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getCdPlacementFrom()) );
              out.write("</td>\r\n\t\t             <td>&nbsp;</td>\r\n\t\t             <td>Child Placed By:&nbsp;");
              out.print(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getCdPlcmtBy()) );
              out.write("</td>\r\n\t\t             <td>&nbsp;</td>\r\n\t\t          </tr>\t\t       \r\n\t\t       </table>\r\n\t\t       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t          <tr>\r\n\t\t             <th colspan=\"12\">Adoptive Parent Is</th>\r\n\t\t          </tr>\r\n\t\t          <tr class=\"subDetail\">\r\n\t\t             <td>\r\n\t\t                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_10.setType("checkbox");
              _jspx_th_impact_validateInput_10.setLabel("Non-Relative Caretaker");
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setChecked(nonIncidentAFCARSInformationSO.getIndAPNonRelative() );
              _jspx_th_impact_validateInput_10.setValue("Y");
              _jspx_th_impact_validateInput_10.setName("cbxAdoPlaceInfo1");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              _jspx_th_impact_validateInput_10.setDisabled("true");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t             </td>\r\n\t\t             <td>\r\n\t\t                ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_11.setType("checkbox");
              _jspx_th_impact_validateInput_11.setLabel("Prior Foster Parent");
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_11.setChecked(nonIncidentAFCARSInformationSO.getIndAPPriorFP());
              _jspx_th_impact_validateInput_11.setValue("Y");
              _jspx_th_impact_validateInput_11.setName("cbxAdoPlaceInfo2");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setDisabled("true");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t             </td>\r\n\t\t          </tr>\r\n\t\t          <tr class=\"subDetail\">\r\n\t\t             <td>\r\n\t\t                 ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_12.setType("checkbox");
              _jspx_th_impact_validateInput_12.setLabel("Other Relative-Birth/Marriage");
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_12.setChecked(nonIncidentAFCARSInformationSO.getIndAPOtherRelative());
              _jspx_th_impact_validateInput_12.setValue("Y");
              _jspx_th_impact_validateInput_12.setName("cbxAdoPlaceInfo3");
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setDisabled("true");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t             </td>\r\n\t\t             <td>\r\n\t\t                 ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_13.setType("checkbox");
              _jspx_th_impact_validateInput_13.setLabel("Stepparent Caretaker");
              _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_13.setChecked(nonIncidentAFCARSInformationSO.getIndAPStepParent());
              _jspx_th_impact_validateInput_13.setValue("Y");
              _jspx_th_impact_validateInput_13.setName("cbxAdoPlaceInfo4");
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setDisabled("true");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("  \r\n\t\t             </td>\r\n\t\t          </tr>\t\t       \r\n\t\t       </table>\r\n\t\t       \t\r\n\t\t       <!-- Adoptive Mother Table -->\t   \r\n\t\t       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t          <tr>\r\n\t\t             <th>Adoptive Mother</th>\r\n\t\t          </tr>\r\n\t\t          <tr class=\"subDetail\">\r\n\t\t             <td>Date of Birth: ");
              out.print( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtAdoptiveMotherDOB()));
              out.write("<br>\r\n\t\t                 Ethnicity: ");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, nonIncidentAFCARSInformationSO.getCdAMEthnicity()) );
              out.write("\r\n\t\t             </td>\r\n\t\t          </tr>\t\t       \r\n\t\t       </table>\t\r\n\t\t       <!-- End Adoptive Mother Table -->\t   \r\n\t\t   \r\n\t\t   \r\n\t\t      <!-- Adoptive Mother's Race Table -->\r\n\t\t\t  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t\t    <tr>\r\n\t\t\t\t   <th colspan=\"8\">\r\n\t\t\t\t\t  Adoptive Mother's Race\r\n\t\t\t\t   </th>\r\n\t\t\t    </tr>\r\n\t\t\t    <tr class=\"subDetail\">\r\n\t\t\t\t   <td>\r\n\t\t\t\t\t ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_codesCheckbox_2.setDefaultCodes( nonIncidentAFCARSInformationSO.getAmRaceList() );
              _jspx_th_impact_codesCheckbox_2.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_2.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_2.setOnClick("");
              _jspx_th_impact_codesCheckbox_2.setColumns(3);
              _jspx_th_impact_codesCheckbox_2.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_codesCheckbox_2.setDisabled("true");
              int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
              if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t   </td>\r\n\t\t\t    </tr>\r\n\t\t      </table>\r\n\t\t      <!-- End Adoptive Mother's Race Table -->\r\n              <!-- Adoptive Father Table -->\r\n\t          <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t          <tr>\r\n\t\t             <th>Adoptive Father</th>\r\n\t\t          </tr>\r\n\t\t          <tr class=\"subDetail\">\r\n\t\t             <td>Date of Birth: ");
              out.print( FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtAdoptiveFatherDOB()));
              out.write("<br>\r\n\t\t                 Ethnicity: ");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, nonIncidentAFCARSInformationSO.getCdAFEthnicity()) );
              out.write("</td>\r\n\t\t          </tr>\t\t       \r\n\t\t      </table>\r\n\t\t      <!-- End Adoptive Father Table --> \r\n\t\t     \t\t   \r\n\t\t      <!-- Adoptive Father's Race Table -->\r\n\t\t      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n\t\t\t    <tr>\r\n\t\t\t\t   <th colspan=\"8\">\r\n\t\t\t\t\tAdoptive Father's Race\r\n\t\t\t\t   </th>\r\n\t\t\t    </tr>\r\n\t\t\t    <tr class=\"subDetail\">\r\n\t\t\t\t   <td>\r\n\t\t\t\t\t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_codesCheckbox_3.setDefaultCodes( nonIncidentAFCARSInformationSO.getAfRaceList() );
              _jspx_th_impact_codesCheckbox_3.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_3.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_3.setOnClick("");
              _jspx_th_impact_codesCheckbox_3.setColumns(3);
              _jspx_th_impact_codesCheckbox_3.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_codesCheckbox_3.setDisabled("true");
              int _jspx_eval_impact_codesCheckbox_3 = _jspx_th_impact_codesCheckbox_3.doStartTag();
              if (_jspx_th_impact_codesCheckbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t   </td>\r\n\t\t\t    </tr>\r\n\t          </table>\r\n\t          <!-- End Adoptive Father's Race Table -->\t\t  \r\n\t       </td></tr>\r\n        </table>\t\t  \r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <!-- End Adoptive Parents Expandable/Collapsable Section -->\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<br>\r\n\t\t\t\t<hr>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t");

      if (!PageModeConstants.VIEW.equals(pageMode)) {
    
          out.write("\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmNonIncidentAFCARSInformation");
          _jspx_th_impact_ButtonTag_0.setAction("/person/NonIncidentAFCARSInformation/saveAFCARSInformation");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

      }
    
          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmNonIncidentAFCARSInformation");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
