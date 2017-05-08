package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchDB;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class EventSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
   * JSP Name:     EventSearch.jsp
   * Created by:   Matt McClaim
   * Date Created: 12/17/02
   *
   * Description:
   * The Event Search page allows a user to search for events within the context
   * of a case, stage, or person.
   *
   **/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    int tabIndex = 1;
    String formName = "EventSearch";

    String caseName = GlobalData.getSzNmCase(request);
    String stageCode = GlobalData.getSzCdStage(request);

    EventSearchDB eventSearchDB = EventSearchConversation.getEventSearchDB(request);

    String personName = StringHelper.getNonNullString(eventSearchDB.getPersonName());
    String staffName = StringHelper.getNonNullString(eventSearchDB.getStaffName());
    String startDate = StringHelper.getNonNullString(eventSearchDB.getStartDateString());

    String endDate = eventSearchDB.getEndDateString();
    if (endDate == null) {
      endDate = FormattingHelper.formatDate(new Date());
    }
    List checkedEventTypes = eventSearchDB.getEventTypeCodesList();
    List checkedStages = eventSearchDB.getStageCodesList();

    //Matthew McClain 06/25/2003
    //EventSearch was designed to precheck the stage code of the
    //stage id being used; this really never limited the search
    //in any way; but with a couple radio buttons which limit
    //options either to case or stage, it'd be painful or confusing
    //to remember to either uncheck the stage type or have it done
    //automatically.
    boolean searchReturnedNoResults =
            EventSearchConversation.searchReturnedNoResults(request);

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  <!--Insert Java Script here\r\nfunction promptToClear()\r\n{\r\n  var MSG_EVNT_SRCH_NO_RSLTS =\r\n  \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_EVNT_SRCH_NO_RSLTS) );
      out.write("\";\r\n\r\n  var form = document.all[");
      out.print( formName );
      out.write("];\r\n  if (window.confirm(MSG_EVNT_SRCH_NO_RSLTS))\r\n  {\r\n    disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n    submitValidateForm('");
      out.print( formName );
      out.write("',\r\n                       '");
      out.print( EventSearchConversation.EVENT_SEARCH + "?clear=true" );
      out.write("');\r\n  }\r\n}\r\n\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( searchReturnedNoResults );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\nwindow.onload = function()\r\n{\r\n  promptToClear();\r\n}\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\nfunction openPersonList()\r\n{\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  return true;\r\n}\r\n\r\n\r\nfunction openStaffList()\r\n{\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  return true;\r\n}\r\n//End Java Script-->\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( formName );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setAction( EventSearchConversation.EVENT_LIST );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName( EventSearchConversation.CALLER );
          _jspx_th_impact_validateInput_0.setValue( EventSearchConversation.CALLER_EVENT_SEARCH );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td colspan=\"2\"\r\n        align=\"right\"\r\n        valign=\"bottom\"><a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"javascript:expandAll()\">Expand All</a>\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"javascript:collapseAll()\">Collapse All</a></td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr>\r\n    <th colspan=\"7\">Search Criteria</th>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td class=\"formLabel\" width=\"15%\">Case Name:</td>\r\n    <td width=\"33%\">");
          out.print( caseName );
          out.write("</td>\r\n    <td width=\"4%\">&nbsp;</td>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setLabel("Search Entire Case?");
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setId("searchEntireCase");
          _jspx_th_impact_validateInput_1.setName("searchEntireCase");
          _jspx_th_impact_validateInput_1.setChecked( "" + (eventSearchDB.getSearchEntireCase()) );
          _jspx_th_impact_validateInput_1.setValue("true");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setName("startDate");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue( startDate );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n    <td width=\"15%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setName("endDate");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue( endDate );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\">Person:</td>\r\n    <td>\r\n      <table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <td width=\"70%\">");
          out.print( personName );
          out.write("&nbsp;</td>\r\n          <td width=\"30%\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("PersonList");
          _jspx_th_impact_ButtonTag_0.setAccessKey("P");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setAction( EventSearchConversation.PERSON_LIST );
          _jspx_th_impact_ButtonTag_0.setForm( formName );
          _jspx_th_impact_ButtonTag_0.setFunction( "return openPersonList();" );
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n    <td>&nbsp;</td>\r\n    <td class=\"formLabel\">Staff:</td>\r\n    <td>\r\n      <table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <td width=\"70%\">");
          out.print( staffName );
          out.write("&nbsp;</td>\r\n          <td width=\"30%\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("StaffList");
          _jspx_th_impact_ButtonTag_1.setAccessKey("T");
          _jspx_th_impact_ButtonTag_1.setBackSafe("true");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setAction( EventSearchConversation.STAFF_LIST );
          _jspx_th_impact_ButtonTag_1.setForm( formName );
          _jspx_th_impact_ButtonTag_1.setFunction( "return openStaffList();" );
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setId("eventTypeCode1");
          _jspx_th_impact_ExpandableSectionTag_0.setName("eventTypesTag");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Event Types");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n      <td class=\"subDetail\">\r\n        ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes( checkedEventTypes );
              _jspx_th_impact_codesCheckbox_0.setName("eventTypeCode");
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CEVNTTYP );
              _jspx_th_impact_codesCheckbox_0.setOrderBy( CodesCheckboxesTag.DECODE );
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(false);
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setId("stageCode1");
          _jspx_th_impact_ExpandableSectionTag_1.setName("stagesTag");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Stages");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");

    //ordering as in ccmn50w.win
     @SuppressWarnings("unchecked")
    List list = new ArrayList(16);
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_INT));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_INV));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_DIV));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_ADO));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_PAD));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_ARI));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_FAD));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_SUB));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_PFC));
  
              out.write("\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n      <td class=\"subDetail\">\r\n        ");
              //  impact:checkbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxesTag _jspx_th_impact_checkbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxesTag();
              _jspx_th_impact_checkbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_checkbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_checkbox_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_checkbox_0.setDefaultValues( checkedStages );
              _jspx_th_impact_checkbox_0.setName("stageCode");
              _jspx_th_impact_checkbox_0.setCheckboxList( list );
              _jspx_th_impact_checkbox_0.setColumns(3);
              _jspx_th_impact_checkbox_0.setIsHorizontal(false);
              int _jspx_eval_impact_checkbox_0 = _jspx_th_impact_checkbox_0.doStartTag();
              if (_jspx_th_impact_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

  String enableValidation = "enableValidation('" + formName + "');";

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\" colspan=\"4\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("Search");
          _jspx_th_impact_ButtonTag_2.setAccessKey("S");
          _jspx_th_impact_ButtonTag_2.setBackSafe("true");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setAction( EventSearchConversation.EVENT_LIST );
          _jspx_th_impact_ButtonTag_2.setFunction( enableValidation );
          _jspx_th_impact_ButtonTag_2.setForm( formName );
          _jspx_th_impact_ButtonTag_2.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_1.setParent(null);
      _jspx_th_impact_ifThen_1.setTest( (GlobalData.getUlIdStage(request) == 0) );
      int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
      if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  //Matthew McClain 06/26/2003\r\n  //I didn't do this using the disabled attribute on the tag,\r\n  //because that would rename the input field\r\n  var form = document.all[\"");
          out.print( formName );
          out.write("\"];\r\n  form.searchEntireCase.disabled = true;\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n</script>\r\n\r\n\r\n");

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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
