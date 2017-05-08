package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG02;
import gov.georgia.dhr.dfcs.sacwis.web.admin.UnitMaintConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RestrictRepostButtonValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import java.util.Enumeration;

public final class UnitDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
       * JSP Name:     UnitDetail.jsp
       * Created by:   Paul Lang
       * Date Created: 11/01/02
       *
       * Description:
       * The Unit Detail page allows users to view or maintain unit and member
       * information.
       **/
      /*
       Change History:
       Date      User              Description
       --------  ----------------  ----------------------------------------------
       11/01/02  Paul Lang         Added Methods and imports to the file.
       06/26/03  Todd Reser        SIR 18465 - Added pagination.
       08/01/03  Todd Reser        Modified Flowerbox Comments.
       09/02/03  A.Corley          SIR REG82 Make the Parent input field have a maxlength of 2
       09/02/03  A.Corley          SIR REG83 set navAwayCk=false on delete pushbutton
       09/14/06  abgoode           Program replaced by County for GA SACWIS - Release 1
       */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<script Language=\"JavaScript\">\r\n\r\n  function cancelValidation ()\r\n  {\r\n    document.frmUnitDetail.FormValidationCancel.value=\"true\";\r\n  }\r\n\r\n  function deleteUnitDetail()\r\n  {\r\n    bRetValue = confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") );
      out.write("')\r\n    return bRetValue;\r\n  }\r\n\r\n  function setTotalCount()\r\n  {\r\n    var totalCount = document.frmUnitDetail.totalCount.value;\r\n    if ( totalCount == 50 )\r\n    {\r\n      alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_TOO_MANY_LB_ROWS) );
      out.write("\");\r\n      return false;\r\n    }\r\n    cancelValidation();\r\n    return true;\r\n  }\r\n</script>\r\n\r\n");
try {
        Boolean badRepost = (Boolean) request.getAttribute(RestrictRepostButtonValidation.restrictRepostDisableButtons);
        if(badRepost != null && badRepost) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
        String pageMode = PageMode.getPageMode(request);

        BaseSessionStateManager state = UnitMaintConversation.getSessionStateManager(request);
        boolean hasMaintainUnitProfile = UserProfileHelper.getUserProfile(request).hasRight(UserProfile.SEC_MNTN_UNIT);
        boolean showMembersSection = true;
        boolean showDeleteButton = false;
        boolean showSaveButton = true;

        CCMN23SO ccmn23so = (CCMN23SO) state.getAttribute("CCMN23SO", request);

        if (ccmn23so == null) {
          ccmn23so = new CCMN23SO();
        }

        ROWCCMN23SOG01_ARRAY memberInfoRowArray = ccmn23so.getROWCCMN23SOG01_ARRAY();

        if (memberInfoRowArray == null || memberInfoRowArray.getROWCCMN23SOG01Count() < 1) {
          showMembersSection = !PageModeConstants.NEW.equals(pageMode);
          if(showMembersSection) {
            showSaveButton = false;
            if(!PageModeConstants.VIEW.equals(pageMode)) {
              UnitMaintConversation.setInformationalMessage(Messages.MSG_CMN_UNIT_NO_MOD, request);
            }
          }
          memberInfoRowArray = new ROWCCMN23SOG01_ARRAY();
        }

        ROWCCMN23SOG02 unitInfoRow = ccmn23so.getROWCCMN23SOG02();
        if (unitInfoRow == null) {
          unitInfoRow = new ROWCCMN23SOG02();
        }

        String szCdUnitCounty = FormattingHelper.formatString(unitInfoRow.getSzCdUnitCounty());
        String szCdUnitRegion = FormattingHelper.formatString(unitInfoRow.getSzCdUnitRegion());
        String szNbrUnit = FormattingHelper.formatString(unitInfoRow.getSzNbrUnit());
        String szCdUnitSpecialization = FormattingHelper.formatString(unitInfoRow.getSzCdUnitSpecialization());
        String szCdParentUnitCounty = FormattingHelper.formatString(unitInfoRow.getSzCdParentUnitCounty());
        String szCdParentUnitRegion = FormattingHelper.formatString(unitInfoRow.getSzCdParentUnitRegion());
        String szNbrParentUnit = FormattingHelper.formatString(unitInfoRow.getSzNbrParentUnit()); 
        int ulIdUnit = unitInfoRow.getUlIdUnit();
        int ulIdUnitParent = unitInfoRow.getUlIdUnitParent();
        int ulIdPerson = unitInfoRow.getUlIdPerson();
        int tabIndex = 1;
        
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmUnitDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.UnitCustomValidation");
      _jspx_th_impact_validateForm_0.setAction("/admin/UnitMaint/saveUnitDetail ");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("ulIdUnitParent");
          _jspx_th_impact_validateInput_0.setValue( String.valueOf( ulIdUnitParent ));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("ulIdPerson");
          _jspx_th_impact_validateInput_1.setValue( String.valueOf( ulIdPerson ));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("ulIdUnit");
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( ulIdUnit ));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tUnit Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\r\n\t\t");
 if (!hasMaintainUnitProfile || (ulIdUnit != 0) ) { 
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("szCdUnitCounty");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_0.setWidth("15%");
          _jspx_th_impact_validateDisplayOnlyField_0.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( szCdUnitCounty );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("szCdUnitRegion");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Region/Division");
          _jspx_th_impact_validateDisplayOnlyField_1.setWidth("15%");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( szCdUnitRegion );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("szNbrUnit");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Unit");
          _jspx_th_impact_validateDisplayOnlyField_2.setWidth("25%");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( szNbrUnit );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t");
 } else { 
          out.write("\r\n\r\n\t\t<tr>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("szCdUnitCounty");
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setWidth("15%");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setValue( CodesTables.CCOUNT_XXX );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("szCdUnitRegion");
          _jspx_th_impact_validateSelect_1.setLabel("Region/Division");
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.CODES);
          _jspx_th_impact_validateSelect_1.setCodesTable(CodesTables.CREGDIV);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setValueType( SelectTag.CODES );
          _jspx_th_impact_validateSelect_1.setWidth("15%");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( szCdUnitRegion );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setName("szNbrUnit");
          _jspx_th_impact_validateInput_3.setLabel("Unit");
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setWidth("25%");
          _jspx_th_impact_validateInput_3.setSize("2");
          _jspx_th_impact_validateInput_3.setMaxLength("2");
          _jspx_th_impact_validateInput_3.setConstraint("AlphaNumeric2Unit");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setValue( szNbrUnit );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t");
 } 
          out.write("\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Specialization");
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setColspan("3");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setName("szCdUnitSpecialization");
          _jspx_th_impact_validateSelect_2.setCodesTable("CSPCUNTS");
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf(!showSaveButton) );
          _jspx_th_impact_validateSelect_2.setValue( szCdUnitSpecialization );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tParent Unit Information\r\n\t\t\t</th>\t\t\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("szCdParentUnitCounty");
          _jspx_th_impact_validateSelect_3.setLabel("County");
          _jspx_th_impact_validateSelect_3.setWidth("15%");
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setValue( szCdParentUnitCounty );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("szCdParentUnitRegion");
          _jspx_th_impact_validateSelect_4.setLabel("Region/Division");
          _jspx_th_impact_validateSelect_4.setContentType( SelectTag.CODES);
          _jspx_th_impact_validateSelect_4.setCodesTable(CodesTables.CREGDIV);
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setValueType( SelectTag.CODES );
          _jspx_th_impact_validateSelect_4.setWidth("15%");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setValue( szCdParentUnitRegion );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"15%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName("szNbrParentUnit");
          _jspx_th_impact_validateInput_4.setLabel("Parent Unit");
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setWidth("25%");
          _jspx_th_impact_validateInput_4.setSize("2");
          _jspx_th_impact_validateInput_4.setMaxLength("2");
          _jspx_th_impact_validateInput_4.setConstraint("AlphaNumeric2Unit");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setValue( szNbrParentUnit );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');

  int loopCount = 0;
  if(showMembersSection) {

          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/admin/UnitMaint/displayUnitDetail");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tMembers\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n\t\t\t\t\t\t<tr class=\"thList\">\r\n\t\t\t\t\t\t\t<td width=\"5%\">&nbsp;</td>\r\n\t\t\t\t\t\t\t<td>Name</td>\r\n\t\t\t\t\t\t\t<td>Role</td>\r\n\t\t\t\t\t\t\t<td>In Unit</td>\r\n\t\t\t\t\t\t\t<td>ERS</td>\r\n\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t\t");
for (Enumeration e = memberInfoRowArray.enumerateROWCCMN23SOG01(); e.hasMoreElements();) {
          ROWCCMN23SOG01 memberInfoRow = (ROWCCMN23SOG01) e.nextElement();
          String szNmPersonFull = FormattingHelper.formatString(memberInfoRow.getSzNmPersonFull());
          String szCdUnitMemberRole = FormattingHelper.formatString(memberInfoRow.getSzCdUnitMemberRole());
          String szCdUnitMemberInOut = FormattingHelper.formatString(memberInfoRow.getSzCdUnitMemberInOut());
          String szBjnJob = FormattingHelper.formatString(memberInfoRow.getSzBjnJob());
          boolean disableRole = false;

          
              out.write("\r\n\t\t\t\t\t\t<tr class=\"");
              out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
              out.write("\">\r\n\r\n\t\t\t\t\t\t\t");
              //  impact:if
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
              _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_if_0.setTest( ("IN".equalsIgnoreCase(szCdUnitMemberInOut)) );
              int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
              if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  if (_jspx_meth_impact_then_0(_jspx_th_impact_if_0, _jspx_page_context))
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  //  impact:else
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
                  _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
                  int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
                  if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n\t\t\t\t\t\t\t\t  ");
 showDeleteButton = true; disableRole = true; 
                      out.write("\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t");
                      //  impact:validateInput
                      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                      _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
                      _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_0);
                      _jspx_th_impact_validateInput_5.setValue( String.valueOf(loopCount) );
                      _jspx_th_impact_validateInput_5.setType("checkbox");
                      _jspx_th_impact_validateInput_5.setName( "cbxPersonIndex_CLEAN" + loopCount );
                      _jspx_th_impact_validateInput_5.setCssClass("formInput");
                      _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
                      _jspx_th_impact_validateInput_5.setChecked("false");
                      int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
                      if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                      out.write("\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              out.print(szNmPersonFull);
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t  ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateSelect_5.setBlankValue("false");
              _jspx_th_impact_validateSelect_5.setLabel("");
              _jspx_th_impact_validateSelect_5.setRequired("true");
              _jspx_th_impact_validateSelect_5.setName(  "szCdUnitMemberRole" + loopCount );
              _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_5.setCodesTable("CUNMBRRL");
              _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf(disableRole) );
              _jspx_th_impact_validateSelect_5.setValue( szCdUnitMemberRole );
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_0.setTest( (CodesTables.CUNMBRRL_40.equals(szCdUnitMemberRole)) );
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnLeadId\" value=\"");
                  out.print( memberInfoRow.getUlIdPerson() );
                  out.write("\">\r\n\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t");
              //  impact:if
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
              _jspx_th_impact_if_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_if_1.setTest( ("IN".equalsIgnoreCase(szCdUnitMemberInOut)) );
              int _jspx_eval_impact_if_1 = _jspx_th_impact_if_1.doStartTag();
              if (_jspx_eval_impact_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  if (_jspx_meth_impact_then_1(_jspx_th_impact_if_1, _jspx_page_context))
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t\t");
                  if (_jspx_meth_impact_else_1(_jspx_th_impact_if_1, _jspx_page_context))
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_if_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              out.print(szBjnJob);
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\r\n");

          loopCount++;
        }

              out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t");
/* SIR 18465 - Added Pagination */

        
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteUnitDetail();");
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setForm("frmUnitDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/UnitMaint/deleteUnitDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(false);
          _jspx_th_impact_ButtonTag_0.setDisabled( String.valueOf(!showDeleteButton) );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setFunction("return setTotalCount();");
          _jspx_th_impact_ButtonTag_1.setForm("frmUnitDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/UnitMaint/addUnitDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setDisabled( String.valueOf(!(showMembersSection && showSaveButton)) );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td class=\"alignRight\" width=\"5%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveDetail");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmUnitDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/admin/UnitMaint/saveUnitDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setDisabled( String.valueOf(!showSaveButton) );
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\r\n\t<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n\t<input type=\"hidden\" name=\"totalCount\" value=\"");
          out.print( loopCount );
          out.write("\">\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
} catch (Exception e) {
        e.printStackTrace();
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

  private boolean _jspx_meth_impact_then_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:then
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
    _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
    int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
    if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_then_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:then
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
    _jspx_th_impact_then_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_then_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
    int _jspx_eval_impact_then_1 = _jspx_th_impact_then_1.doStartTag();
    if (_jspx_eval_impact_then_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\">\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_impact_then_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_then_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_else_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:else
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
    _jspx_th_impact_else_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_else_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
    int _jspx_eval_impact_else_1 = _jspx_th_impact_else_1.doStartTag();
    if (_jspx_eval_impact_else_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_impact_else_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_else_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
