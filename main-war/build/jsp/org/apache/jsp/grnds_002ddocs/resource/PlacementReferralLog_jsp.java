package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogList;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public final class PlacementReferralLog_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      Integer idPlacementReferral = 0;
      Date dtLastUpdate = null;
      Integer idPerson = 0;
      Integer idResource = 0;
      Integer idEmployee = 0;
      Date dtBegin = null;
      Date dtExpiration = null;
      String cdStatus = null;
      String cdPlacementType = null;
      String nmPersonFull = null;
      String nmEmployeeFull = null;
      Integer nbrPersonAge = 0;
      String cdPersonSex = null;
      Date dtPersonBirth = null;

      boolean showAddPB = true;
      String hdnIdPlacementReferral = null;

      PlacementReferralLogRetrieveSO placementReferralLogRetrieveSO;

      //get the RetrieveSO object from state
      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      placementReferralLogRetrieveSO = (PlacementReferralLogRetrieveSO) state.getAttribute("PlacementReferralLogRetrieveSO", request);

      //handle the null object
      if (placementReferralLogRetrieveSO == null) {
        placementReferralLogRetrieveSO = new PlacementReferralLogRetrieveSO();

      }

      if (placementReferralLogRetrieveSO.getPlacementReferralLogList() != null) {
        idResource = placementReferralLogRetrieveSO.getIdResource();
      }
      String pageMode = PageModeConstants.VIEW;

      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }

      if (pageMode.equals(PageModeConstants.VIEW)) {
        showAddPB = false;
      }

      int tabIndex = 1;
      int loopCount = 0;
      
      String context = "";
      String displayReferralDetailURL = "";
      String displayPersonDetailURL = "";
      String submitURL = "";
      if (CodesTables.CSTAGES_FAD.equals(GlobalData.getSzCdStage(request))){
        context = "/fad";
      }
      else{
        context = "/resource";
      }
      displayReferralDetailURL = context+"/PlacementReferralDetail/displayPlacementReferralDetail";
      submitURL = context+"/PlacementReferralLog/displayPlacementReferralLog";
      displayPersonDetailURL = context+"/PlacementReferralLog/callPersonDetail";

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\"> \r\n  \r\n  function displayPlacementReferralDetail(idPlacementReferral, displayReferralDetailURL)\r\n  {\r\n    document.frmPlacementReferralLog.hdnIdPlacementReferral.value = idPlacementReferral;\r\n    disableValidation(\"frmPlacementReferralLog\");\r\n    submitValidateForm(\"frmPlacementReferralLog\", displayReferralDetailURL);\r\n  }\r\n  \r\n  function submitToPersonDetail(personId, name, displayInfo,displayPersonDetailURL )\r\n  {\r\n    document.frmPlacementReferralLog.hdnUlIdPerson.value = personId;\r\n    document.frmPlacementReferralLog.hdnFullName.value = name;\r\n    document.frmPlacementReferralLog.bSysIndViewPersonInfo.value = displayInfo;\r\n    submitValidateForm( \"frmPlacementReferralLog\", displayPersonDetailURL );\r\n  }\r\n  \r\n  </script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPlacementReferralLog");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(submitURL);
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl(submitURL);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <div id=\"scrollBar2\" style=\"height:210px;width:100%;overflow:auto\"\r\n      class=\"tableborderList\">\r\n\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n        <tr>\r\n          <th class=\"thList\">\r\n            Begin Date\r\n          </th>\r\n          <th class=\"thList\">\r\n            Expiration Date\r\n          </th>\r\n          <th class=\"thList\">\r\n            Status\r\n          </th>\r\n          <th class=\"thList\">\r\n            Person ID\r\n          </th>\r\n          <th class=\"thList\">\r\n            Name\r\n          </th>\r\n          <th class=\"thList\">\r\n            Gender\r\n          </th>\r\n          <th class=\"thList\">\r\n            DOB\r\n          </th>\r\n          <th class=\"thList\">\r\n            Age\r\n          </th>\r\n          <th class=\"thList\">\r\n            Placement Type\r\n          </th>\r\n          <th class=\"thList\">\r\n            Last Updated By\r\n          </th>\r\n\r\n        </tr>\r\n        ");

                                                                                                  List<PlacementReferralLogList> pReferralLogList = placementReferralLogRetrieveSO
                                                                                                  .getPlacementReferralLogList();
                  if (pReferralLogList == null || pReferralLogList.size() < 1) {
        
              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"8\">\r\n            ");
              out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");

                    } else {
                    int counter = 1;
                    Iterator<PlacementReferralLogList> it = pReferralLogList.iterator();
                    while (it.hasNext()) {
                      PlacementReferralLogList prLogList = it.next();
                      idPlacementReferral = prLogList.getIdPlacementReferral();
        
              out.write("\r\n        <tr>\r\n          <td>\r\n            <a\r\n              href=\"javascript:displayPlacementReferralDetail('");
              out.print(idPlacementReferral);
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print(displayReferralDetailURL);
              out.write("')\"\r\n              tabIndex=\"");
              out.print(tabIndex++);
              out.write('"');
              out.write('>');
              out.write(' ');
              out.print(DateHelper.isNull(prLogList.getDtBegin()) ? ""
                                                                      : DateHelper.SLASH_FORMAT.format(prLogList.getDtBegin()));
              out.write("\r\n          </td>\r\n\r\n          <td>\r\n            ");
              out.print(DateHelper.isNull(prLogList.getDtExpiration()) ? "" : DateHelper.SLASH_FORMAT.format(prLogList.getDtExpiration()));
              out.write("\r\n          </td>\r\n\r\n          <td>\r\n            ");
              out.print((prLogList.getCdStatus() == null) ? "" : FormattingHelper.formatString(prLogList.getCdStatus()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((prLogList.getIdPerson() == 0) ? "" : FormattingHelper.formatInt(prLogList.getIdPerson()));
              out.write("\r\n          </td>\r\n          <td>\r\n            <a\r\n              href=\"javascript:disableValidation('frmPlacementReferralLog'); submitToPersonDetail( '");
              out.print(prLogList.getIdPerson());
              out.write("', '");
              out.print(prLogList.getNmPersonFull());
              out.write("', '");
              out.print(ArchitectureConstants.Y);
              out.write('\'');
              out.write(',');
              out.write('\'');
              out.print(displayPersonDetailURL);
              out.write("' )\">\r\n              ");
              out.print((prLogList.getNmPersonFull() == null) ? ""  : FormattingHelper.formatString(prLogList.getNmPersonFull()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((prLogList.getCdPersonSex() == null) ? "" : FormattingHelper.formatString(prLogList.getCdPersonSex()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(DateHelper.isNull(prLogList.getDtPersonBirth()) ? "" : DateHelper.SLASH_FORMAT.format(prLogList.getDtPersonBirth()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((prLogList.getNbrPersonAge() == 0) ? "" : FormattingHelper.formatInt(prLogList.getNbrPersonAge()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((prLogList.getCdPlacementType() == null) ? "" : FormattingHelper.formatString(prLogList.getCdPlacementType()));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print((prLogList.getNmEmployeeFull() == null) ? "" : FormattingHelper.formatString(prLogList.getNmEmployeeFull()));
              out.write("\r\n          </td>\r\n\r\n          ");

                      loopCount++;
                      }
          
              out.write("\r\n        </tr>\r\n        ");

        }
        
              out.write("\r\n\r\n      </table>\r\n    </div>\r\n\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

  if (showAddPB) {
  
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignRight\" width=\"8%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAdd");
          _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmPlacementReferralLog");
          _jspx_th_impact_ButtonTag_0.setAction(displayReferralDetailURL);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </tr>\r\n  </table>\r\n\r\n  ");

  }
  
          out.write("\r\n\r\n  <input type=\"hidden\"\r\n    name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n  ");
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
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
    _jspx_th_impact_validateInput_0.setName("hdnIdPlacementReferral");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_1.setName("hdnIdResource");
    _jspx_th_impact_validateInput_1.setValue(" <%=idResource%> ");
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
    _jspx_th_impact_validateInput_2.setName("hdnUlIdPerson");
    _jspx_th_impact_validateInput_2.setValue("");
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
    _jspx_th_impact_validateInput_3.setName("hdnFullName");
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
    _jspx_th_impact_validateInput_4.setName("hdnUlIdStage");
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
    _jspx_th_impact_validateInput_5.setName("bIndActiveStatus");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("bSysIndViewPersonInfo");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
