package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailRetrieveSO;

public final class PlacementReferralDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      Date dtBegin = null;
      Date dtExpiration = null;
      String cdPlacementType = null;
      String nmPersonFull = null;
      
      int defaultExpirationDays_180 = 180;
      int defaultExpirationDays_30 = 30;

      boolean showButton = false;
      String disableField = "true";

      String ICPCAdoptive = CodesTables.CPLMNTYP_ICA;
      String ICPCFoster = CodesTables.CPLMNTYP_ICF;
      String ICPCRelative = CodesTables.CPLMNTYP_ICR;

      // Create a 1-based tab index variable that can be used to set tab indices down the page.
      int tabIndex = 1;

      //get the RetrieveSO object from state
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      PlacementReferralDetailRetrieveSO placementReferralDetailRetrieveSO = (PlacementReferralDetailRetrieveSO) state
                                                                                                                     .getAttribute(
                                                                                                                                   "PlacementReferralDetailRetrieveSO",
                                                                                                                                   request);

      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      } else {
        pageMode = (String) state.getAttribute("PageMode", request);
      }
      //for EDIT and MODIFY mode, enable all fields and show button, otherwise
      //disable fields and hide button.
      if (pageMode.equals(PageModeConstants.EDIT) || pageMode.equals(PageModeConstants.MODIFY)) {
        showButton = true;
        disableField = "false";
      } else {
        showButton = false;
        disableField = "true";
      }

      //handle the null object
      if (placementReferralDetailRetrieveSO == null) {
        placementReferralDetailRetrieveSO = new PlacementReferralDetailRetrieveSO();

      } else {
        dtBegin = placementReferralDetailRetrieveSO.getDtBegin();
        nmPersonFull = placementReferralDetailRetrieveSO.getNmPersonFull();
        cdPlacementType = placementReferralDetailRetrieveSO.getCdPlacementType();
        dtExpiration = placementReferralDetailRetrieveSO.getDtExpiration();
        
      }

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nfunction getDafaultExpirationDate(){\r\nvar placementType = document.frmPlacementReferralDetail.selCdPlacementType.value;\r\n\r\n  if(placementType != null){\r\n    if( ");
      out.print(disableField.equals("false"));
      out.write(") {\r\n      var defaultExpirationDate;\r\n\r\n      if(placementType == '");
      out.print(ICPCAdoptive);
      out.write("' || placementType == '");
      out.print(ICPCFoster);
      out.write("'\r\n                          || placementType == '");
      out.print(ICPCRelative);
      out.write("' ) {\r\n\r\n        defaultExpirationDate = '");
      out.print(FormattingHelper.formatDate(DateHelper.addToDate(new Date(), 0, 0, defaultExpirationDays_180)));
      out.write("';\r\n      }else {\r\n        defaultExpirationDate = '");
      out.print(FormattingHelper.formatDate(DateHelper.addToDate(new Date(), 0, 0, defaultExpirationDays_30)));
      out.write("';\r\n      }\r\n      document.frmPlacementReferralDetail.txtDtExpiration.value = defaultExpirationDate;\r\n\r\n    }\r\n\r\n  }\r\n}\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPlacementReferralDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/PlacementReferralDetail/displayPlacementReferralDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n    class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"6\">\r\n        Placement Referral Detail\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspPersonName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(nmPersonFull));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");

      if (showButton) {
      
          out.write("\r\n      <td align=\"right\" width=\"10%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelectPerson");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmPlacementReferralDetail');");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/PlacementReferralDetail/displayPersonList");
          _jspx_th_impact_ButtonTag_0.setForm("frmPlacementReferralDetail");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.EDIT);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");

      }
      
          out.write("\r\n      <td>\r\n        &nbsp;&nbsp;&nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCdPlacementType");
          _jspx_th_impact_validateSelect_0.setLabel("Placement Type");
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CPLMNTYP);
          _jspx_th_impact_validateSelect_0.setValue(cdPlacementType);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setDisabled(disableField);
          _jspx_th_impact_validateSelect_0.setOnChange("return getDafaultExpirationDate();");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspBiginDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Begin Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatDate(dtBegin));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;&nbsp;&nbsp;\r\n      </td>\r\n      <td></td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtExpiration");
          _jspx_th_impact_validateDate_0.setLabel("Expiration Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dtExpiration));
          _jspx_th_impact_validateDate_0.setDisabled(disableField);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n  </table>\r\n  ");

  if (showButton) {
  
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\" width=\"10%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/PlacementReferralDetail/savePlacementReferralDetail");
          _jspx_th_impact_ButtonTag_1.setForm("frmPlacementReferralDetail");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");

  }
  
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
      out.write("\r\n\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnContinueBtn");
    _jspx_th_impact_validateInput_0.setValue("true");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
