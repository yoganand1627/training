package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

public final class StaffToDo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     StaffToDo.jsp
 * Created by:   Michael K. Werle
 * Date Created: 01/08/03
 *
 * Description:
 * This page shows a worker's To-Do List and allows them to navigate to the
 * items they have to do.
 *
 * 6/1/04     Hadjimh  SIR#22902   added a report dropdown list box to the page
 * 7/7/05     Fraserkr SIR23559   Allow report dropdown from the StaffToDoSummary
 *                              page also.
 * 10/2/2008  arege    STGAP00009233 Modified an if condition that will not allow 
 *                                   deletion of any Task from the Staff To-Do list.
 *
 * 12/4/2009  wjcochran  SMS #37449: Add Select/Deselect All buttons
 * 01/6/2010  wjcochran  SMS #37449: Modified Select All to select only Alerts
 * 
 * 
**/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;

  String formName = "frmStaffToDo";
  String formNameResults = "frmStaffToDoResults";
  
  int toDoStateInfoId = Integer.parseInt( (String)request.getAttribute( ToDoConversation.TODO_STATE_ID_KEY ) );
  ToDoHelper.ToDoStateInfo toDoStateInfo = ToDoHelper.getToDoStateInformation( request, toDoStateInfoId );

  String fromDate = FormattingHelper.formatDate( toDoStateInfo.getFromDate() );
  String toDate = FormattingHelper.formatDate( toDoStateInfo.getToDate() );

  // get the row array
  BaseSessionStateManager state
          = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  List rowccmn17doList = (List)state.getAttribute( ToDoConversation.ROWCCMN17DO_LIST_KEY, request );

  // get the session id to support showing which links have been visited
  String sessionId = session.getId();

  // get the current display uri so we can display both as staff to-do and summary to-do
  String currentDisplayURI = ToDoHelper.getReturnToToDoListURI( request );

  // Begin SIR#22902
  // because StaffToDo page is the same as StaffToDoSummary, we need to make sure the
  // report section displays only on StaffToDo page
  // SIR23559 - commented out next two lines of code, no longer needed
  //boolean bStaffToDo = false;
  //bStaffToDo = currentDisplayURI.compareToIgnoreCase("/workload/ToDo/displayStaffToDo") == 0;
  // note by fraserkr:  user is needed for report list to set personId
  UserProfile user = UserProfileHelper.getUserProfile( request );
  // End SIR#22902

  // SIR23559 report section can display for both StaffToDo and StaffToDoSummary pages
  //  leaving boolean value to drive report conditional in case useful for future maintenance
  boolean bStaffToDo = true;

  boolean missingResults = false;

  Iterator toDoIterator = rowccmn17doList != null ? rowccmn17doList.iterator() : null;
  if ( toDoIterator == null || !toDoIterator.hasNext() )
  {
    missingResults = true;
  }
  String searchDefaultButton = "" + missingResults;

      out.write("\r\n\r\n<script language=\"Javascript\">\r\n\r\n  function navigate( idTodo, sessionId )\r\n  {\r\n    frmStaffToDoResults.hdnIdTodo.value = idTodo;\r\n    disableValidation( \"frmStaffToDoResults\" );\r\n    submitValidateForm( \"frmStaffToDoResults\", \"/workload/ToDo/displayStaffToDoActionPage\" );\r\n  }\r\n\r\n  function newToDoUsing()\r\n  {\r\n    if( frmStaffToDo.hdnMissingResults != \"true\" )\r\n    {\r\n      var todoCount = 0;\r\n      var idTodo = -1;\r\n      for( var i = 0; i < ");
      out.print(ToDoConversation.RESULTS_PER_PAGE);
      out.write("; i++ )\r\n      {\r\n        var cb = eval( \"frmStaffToDoResults.cbIdToDo_\" + i );\r\n        if( cb == null )\r\n        {\r\n          break;\r\n        }\r\n        if( cb.checked )\r\n        {\r\n          todoCount++;\r\n          idTodo = cb.value;\r\n        }\r\n      }\r\n      // New Using requires that exactly 1 item be selected.\r\n      if( todoCount < 1 )\r\n      {\r\n        alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NO_ROW_SELECTED_CONTINUE ));
      out.write("' );\r\n        return false;\r\n      }\r\n      if( todoCount > 1 )\r\n      {\r\n        alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_ONLY_ONE_ROW_NEW_USING ));
      out.write("' );\r\n        return false;\r\n      }\r\n      var isTask = eval( \"frmStaffToDoResults.isTask_\" + idTodo ).value;\r\n      if( isTask != \"true\" )\r\n      {\r\n        alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NEW_USING_REQUIRES_TASK_TODO ));
      out.write("\" );\r\n        return false;\r\n      }\r\n      var isApproval = eval( \"frmStaffToDoResults.isApproval_\" + idTodo ).value;\r\n      if( isApproval == \"true\" )\r\n      {\r\n        alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_CMN_ADDL_APPRV ));
      out.write("\" );\r\n        return false;\r\n      }\r\n      frmStaffToDoResults.hdnIdTodo.value = idTodo;\r\n      disableValidation( \"frmStaffToDoResults\" );\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NO_NEW_USING_TO_DO ));
      out.write("\" );\r\n      return false;\r\n    }\r\n  }\r\n\r\n  function display( idTodo, sessionId )\r\n  {\r\n    frmStaffToDoResults.hdnIdTodo.value = idTodo;\r\n    disableValidation( \"frmStaffToDoResults\" );\r\n    submitValidateForm( \"frmStaffToDoResults\", \"/workload/ToDo/displayStaffToDoDetail\" );\r\n  }\r\n\r\n  function deleteToDo()\r\n  {\r\n    var selectedCount = 0;\r\n    for( var i = 0; i < ");
      out.print(ToDoConversation.RESULTS_PER_PAGE);
      out.write("; i++ )\r\n    {\r\n      var cb = eval( \"frmStaffToDoResults.cbIdToDo_\" + i );\r\n      if( cb == null )\r\n      {\r\n        // there was not a full page; just break\r\n        break;\r\n      }\r\n      if( cb.checked )\r\n      {\r\n        selectedCount++;\r\n        var canBeDeleted = eval( \"frmStaffToDoResults.hdnCanBeDeletedName_\" + i ).value;\r\n        if( canBeDeleted != \"true\" )\r\n        {\r\n          alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_CHG_INVALID_TODO ));
      out.write("' );\r\n          return false;\r\n        }\r\n      }\r\n    }\r\n    if( selectedCount < 1 )\r\n    {\r\n      alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NO_ROW_SELECTED_CONTINUE ));
      out.write("' );\r\n      return false;\r\n    }\r\n    if( selectedCount > ");
      out.print(ToDoConversation.MAX_DELETE);
      out.write(" )\r\n    {\r\n      alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_TO_DO_MAX_DELETE ));
      out.write("' );\r\n      return false;\r\n    }\r\n    if( confirm( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ));
      out.write("' ) )\r\n    {\r\n      disableValidation( \"frmStaffToDoResults\" );\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n\r\n/*\r\n * SMS #37449: Add Select/Deselect All functionality\r\n */\r\nfunction selectAll()\r\n{\r\n  for( var i = 0; i < ");
      out.print(ToDoConversation.RESULTS_PER_PAGE);
      out.write("; i++ )\r\n  {\r\n    var cb = eval( \"frmStaffToDoResults.cbIdToDo_\" + i );\r\n    var canBeDel = eval( \"frmStaffToDoResults.hdnCanBeDeletedName_\" + i);\r\n    if( cb == null )\r\n    {\r\n      // there was not a full page; just break\r\n      break;\r\n    }\r\n    if (canBeDel.value == \"true\")\r\n    {\r\n\t  cb.checked = true;\r\n    }\r\n    \r\n  }\r\n  return false;\r\n}\r\n\r\n\r\nfunction deselectAll()\r\n{\r\n  for( var i = 0; i < ");
      out.print(ToDoConversation.RESULTS_PER_PAGE);
      out.write("; i++ )\r\n  {\r\n    var cb = eval( \"frmStaffToDoResults.cbIdToDo_\" + i );\r\n    if( cb == null )\r\n    {\r\n      // there was not a full page; just break\r\n      break;\r\n    }\r\n    cb.checked = false;\r\n  }\r\n  return false;\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName(formName);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(currentDisplayURI);
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoCustomValidation");
      _jspx_th_impact_validateForm_0.setDefaultButton( searchDefaultButton );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnCurrentDisplayURI");
          _jspx_th_impact_validateInput_1.setValue(currentDisplayURI);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">Search Criteria</th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtFrom");
          _jspx_th_impact_validateDate_0.setValue(fromDate);
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setLabel("From");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtTo");
          _jspx_th_impact_validateDate_1.setValue(toDate);
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setLabel("To");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\" align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearchFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setForm("frmStaffToDo");
          _jspx_th_impact_ButtonTag_0.setAction(currentDisplayURI);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName(formNameResults);
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction(currentDisplayURI);
      _jspx_th_impact_validateForm_1.setPageMode(PageModeConstants.EDIT);
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnCurrentDisplayURI");
          _jspx_th_impact_validateInput_3.setValue(currentDisplayURI);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  if( !missingResults )
  {

          out.write("\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n    <tr>\r\n      <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("SelectAll");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setFunction("return selectAll();");
          _jspx_th_impact_ButtonTag_1.setAction("/not/a/real/path");
          _jspx_th_impact_ButtonTag_1.setForm( formName );
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectAll");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("DeselectAll");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setFunction("return deselectAll();");
          _jspx_th_impact_ButtonTag_2.setAction("/not/a/real/path");
          _jspx_th_impact_ButtonTag_2.setForm( formName );
          _jspx_th_impact_ButtonTag_2.setImg("btnDeselectAll");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

  }

          out.write("\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl(currentDisplayURI);
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <div id=\"noScrollResults\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">&nbsp;</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">Type</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n             Due Date\r\n            ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(ToDoConversation.STAFF_TODO_SORT_BY_DATE);
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Stage Name\r\n            ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(ToDoConversation.STAFF_TODO_SORT_BY_CASE);
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Created By\r\n            ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(ToDoConversation.STAFF_TODO_SORT_BY_CREATOR);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n          Description\r\n          ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy(ToDoConversation.STAFF_TODO_SORT_BY_DESCRIPTION);
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n        </tr>\r\n");

  if (missingResults)
  {

              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"6\">\r\n            ");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("\r\n          </td>\r\n        </tr>\r\n");

  }
  else
  {
    int loopCount = 0;
    while( toDoIterator.hasNext() )
    {
      ROWCCMN17DO rowccmn17do = (ROWCCMN17DO)toDoIterator.next();
      String cbName = "cbIdToDo_" + loopCount;
      String canBeDeletedName = "hdnCanBeDeletedName_" + loopCount;
      String toDoTypeCode = rowccmn17do.getSzCdTodoType();
      String toDoCreator = FormattingHelper.formatString( rowccmn17do.getSzScrTodoCreated() );
      String taskCode = rowccmn17do.getSzCdTask();
      // A to-do can be deleted if it satisfies any of the following:
      // 1) a non-task to-do
      // 2) a system to-do with no task code
      String canBeDeleted = !CodesTables.CTODOTYP_T.equals( toDoTypeCode )
             // Per STGAP00009233 arege Commented out the following line 
             // ( !toDoCreator.equals( ToDoConversation.CREATED_NAME_SYSTEM )
              || !StringHelper.isValid( taskCode )
              ? "true" : "false";
      String toDoTypeDecode = StringHelper.isValid( toDoTypeCode )
              ? Lookup.simpleDecode( CodesTables.CTODOTYP, toDoTypeCode ) : "";
      String idTodo = String.valueOf( rowccmn17do.getLdIdTodo() );
      // Only Task To-Do's that are not approvals can be used for New Using
      String isTaskName = "isTask_" + idTodo;
      String isApprovalName = "isApproval_" + idTodo;
      // Need to use TaskInit to figure out if we have an approval todo
      String todoTaskType = null;
      try
      {
        todoTaskType = StringHelper.isValid( taskCode )
                    ? TaskInit.getTaskColumnString( taskCode, TaskInit.CD_TASK_EVENT_TYPE )
                    : null;
      }
      catch( IllegalStateException e )
      {
        todoTaskType = null; // redundant, but just to be clear
      }
      String isApproval
              = StringHelper.isValid( taskCode ) && CodesTables.CEVNTTYP_APP.equals( todoTaskType ) ? "true" : "false";

              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_4.setType("checkbox");
              _jspx_th_impact_validateInput_4.setName(cbName);
              _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_4.setValue(idTodo);
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_5.setType("hidden");
              _jspx_th_impact_validateInput_5.setName(canBeDeletedName);
              _jspx_th_impact_validateInput_5.setValue(canBeDeleted);
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_6.setType("hidden");
              _jspx_th_impact_validateInput_6.setName(isApprovalName);
              _jspx_th_impact_validateInput_6.setValue(isApproval);
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');

      if( toDoTypeCode.equals( CodesTables.CTODOTYP_T ) && todoTaskType != null )
      {
        // include both the idTodo and the session id to make sure that the link is only marked
        //   as visited when the user navigates to that todo detail

              out.write("\r\n            ");
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_7.setType("hidden");
              _jspx_th_impact_validateInput_7.setName(isTaskName);
              _jspx_th_impact_validateInput_7.setValue("true");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            <a href=\"javascript:navigate( '");
              out.print(idTodo);
              out.write("', '");
              out.print(sessionId);
              out.write("' );\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\">\r\n              ");
              out.print(FormattingHelper.formatString( toDoTypeDecode ));
              out.write("\r\n            </a>\r\n");

      }
      else
      {

              out.write("\r\n            ");
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_8.setType("hidden");
              _jspx_th_impact_validateInput_8.setName(isTaskName);
              _jspx_th_impact_validateInput_8.setValue("false");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              out.print(FormattingHelper.formatString( toDoTypeDecode ));
              out.write('\r');
              out.write('\n');

      }

              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatDate( rowccmn17do.getDtDtTodoDue() ));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatString( rowccmn17do.getSzNmStage() ));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(toDoCreator);
              out.write("\r\n          </td>\r\n          <td>\r\n            <div>\r\n              ");
              out.write("\r\n              <a href=\"javascript:display( '");
              out.print(idTodo);
              out.write("', '");
              out.print(sessionId);
              out.write("' );\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\">\r\n                ");
              out.print(FormattingHelper.formatString( rowccmn17do.getSzTxtTodoDesc() ));
              out.write("\r\n              </a>\r\n            </div>\r\n          </td>\r\n        </tr>\r\n");

      loopCount++;
    }
  }

              out.write("\r\n      </table>\r\n    </div>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  if( !missingResults )
  {

          out.write("\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_3.setName("btnDeleteFinal");
          _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_3.setForm("frmStaffToDoResults");
          _jspx_th_impact_ButtonTag_3.setAction("/workload/ToDo/deleteStaffToDo");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_3.setFunction("return deleteToDo()");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_4.setName("btnNewUsingFinal");
          _jspx_th_impact_ButtonTag_4.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_4.setForm("frmStaffToDoResults");
          _jspx_th_impact_ButtonTag_4.setAction("/workload/ToDo/newUsingStaffToDo");
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_4.setFunction("return newToDoUsing()");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

  }

          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
 /* sir#22902. added the dropdown list box for report. Begin Forms and Reports  */ 
      out.write('\r');
      out.write('\n');
// if (bStaffToDo)
      out.write('\r');
      out.write('\n');
//{
      out.write('\r');
      out.write('\n');
//<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder"
      out.write('\r');
      out.write('\n');
//<tr>
      out.write("\r\n    ");
//<th colspan="4"> Reports </th>
      out.write("\r\n  ");
//</tr>
      out.write("\r\n  ");
//<tr>
      out.write("\r\n\r\n  ");
//<td>
      out.write("\r\n       ");
//<% String emailMessageString = ""; 
      out.write("\r\n       ");
//<impact:reportList tabIndex="<%= tabIndex++ /%/>" personId="<%= user.getUserID() /%/>">
      out.write("\r\n\r\n          ");
//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Due Date" ; 
      out.write("\r\n          ");
//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Due Date" emailMessage="</%/= emailMessageString /%/>" >
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf("1") /%/>'/>
      out.write("\r\n          ");
//</impact:report>
      out.write("\r\n\r\n          ");
//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Case ID" ; 
      out.write("\r\n          ");
//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Case ID" emailMessage="<%= emailMessageString /%/>" >
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf("2") /%/>'/>
      out.write("\r\n          ");
//</impact:report>
      out.write("\r\n\r\n          ");
//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Stage Name" ; 
      out.write("\r\n          ");
//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Stage Name" emailMessage="<%= emailMessageString /%/>" >
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf("3") /%/>'/>
      out.write("\r\n          ");
//</impact:report>
      out.write("\r\n\r\n          ");
//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Creator Initials" ; /%/>
      out.write("\r\n          ");
//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Creator Initials" emailMessage="<%= emailMessageString /%/>">
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />
      out.write("\r\n             ");
//<impact:reportParameter value='<%= String.valueOf("4") /%/>'/>
      out.write("\r\n          ");
//</impact:report>
      out.write("\r\n\r\n       ");
//</impact:reportList>
      out.write("\r\n    ");
//</td>
      out.write("\r\n  ");
//</tr>/%/>
      out.write('\r');
      out.write('\n');
//</table>
      out.write('\r');
      out.write('\n');
//}
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
    _jspx_th_impact_validateInput_0.setName("hdnIdTodo");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnIdTodo");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
