package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class CaseToDo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String pageMode = PageMode.getPageMode( request );

  int tabIndex = 1;

  int toDoStateInfoId = Integer.parseInt( (String)request.getAttribute( ToDoConversation.TODO_STATE_ID_KEY ) );
  ToDoHelper.ToDoStateInfo toDoStateInfo = ToDoHelper.getToDoStateInformation( request, toDoStateInfoId );

  String fromDate = FormattingHelper.formatDate( toDoStateInfo.getFromDate() );
  String toDate = FormattingHelper.formatDate( toDoStateInfo.getToDate() );

  // get the row array
  BaseSessionStateManager state
          = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  List rowccmn42doList = (List)state.getAttribute( ToDoConversation.ROWCCMN42DO_LIST_KEY, request );

  // Get the toDoIterator so we can check to see if we have results
  boolean toDoExists = true;
  Iterator toDoIterator = rowccmn42doList != null ? rowccmn42doList.iterator() : null;
  if ( toDoIterator == null || !toDoIterator.hasNext() )
  {
    toDoExists = false;
  }

  // get the session id to support showing which links have been visited
  String sessionId = session.getId();

  // get the list of open stages for the current case
  int ulIdCase = GlobalData.getUlIdCase( request );
  String idCase = String.valueOf( ulIdCase );
  List stageList = idCase != null ? CaseUtility.getOpenStages( idCase ) : null;
  boolean openStageExists = stageList != null && stageList.size() > 0;

  //SIR 23986 - Determine if APS and pending approval

  String INV_CONCL_TASK_CODE = "2120";
  String SVC_CONCL_TASK_CODE = "6010";
  String AOC_CONCL_TASK_CODE = "5090";

  String conclTaskCode = SVC_CONCL_TASK_CODE;
  if( CodesTables.CSTAGES_INV.equals( GlobalData.getSzCdStage( request ) ) )
  {
     conclTaskCode = INV_CONCL_TASK_CODE;
  }
  else if( CodesTables.CSTAGES_AOC.equals( GlobalData.getSzCdStage( request ) ) )
  {
     conclTaskCode = AOC_CONCL_TASK_CODE;
  }

  CaseUtility.Event apsCnclEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
                                                        conclTaskCode);

  boolean pendStageProg = (apsCnclEvent.getCdEventStatus() != null &&
          CodesTables.CEVTSTAT_PEND.equals( apsCnclEvent.getCdEventStatus()));


      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"Javascript\">\r\n  function navigate( index, sessionId )\r\n  {\r\n    frmCaseToDoResults.hdnIdTodo.value = index;\r\n    disableValidation( \"frmCaseToDoResults\" );\r\n    submitValidateForm( \"frmCaseToDoResults\", \"/workload/ToDo/displayCaseToDoActionPage\" );\r\n  }\r\n\r\n  function newUsing()\r\n  {\r\n    if( ");
      out.print(toDoExists);
      out.write(" )\r\n    {\r\n      var idTodo = getSelectedRadioValue( frmCaseToDoResults.rbIdToDo );\r\n      if( idTodo == \"\" || idTodo == null )\r\n      {\r\n        alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NO_ROW_SELECTED_CONTINUE ));
      out.write("' );\r\n        return false;\r\n      }\r\n      var isTask = eval( \"frmCaseToDoResults.isTask_\" + idTodo ).value;\r\n      if( isTask != \"true\" )\r\n      {\r\n        alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NEW_USING_REQUIRES_TASK_TODO ));
      out.write("\" );\r\n        return false;\r\n      }\r\n      var isApproval = eval( \"frmCaseToDoResults.isApproval_\" + idTodo ).value;\r\n      if( isApproval == \"true\" )\r\n      {\r\n        alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_CMN_ADDL_APPRV ));
      out.write("\" );\r\n        return false;\r\n      }\r\n      frmCaseToDoResults.hdnIdTodo.value = idTodo;\r\n      disableValidation( \"frmCaseToDoResults\" );\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_NO_NEW_USING_TO_DO ));
      out.write("\" );\r\n      return false;\r\n    }\r\n  }\r\n\r\n  function addToDo()\r\n  {\r\n    if( ");
      out.print(openStageExists);
      out.write(" )\r\n    {\r\n      var idStage = getSelectedRadioValue( frmCaseToDoResults.rbIdStage );\r\n      if( idStage == \"\" || idStage == null )\r\n      {\r\n        alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ));
      out.write("' );\r\n        return false;\r\n      }\r\n      frmCaseToDoResults.hdnIdStage.value = idStage;\r\n      frmCaseToDoResults.hdnCdStage.value = eval( \"frmCaseToDoResults.dspCdStage_\" + idStage ).value;\r\n      frmCaseToDoResults.hdnCdStageProgram.value = eval( \"frmCaseToDoResults.hdnCdStageProgram_\" + idStage ).value;\r\n      disableValidation( \"frmCaseToDoResults\" );\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      alert( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_ADD_TO_DO_NO_STAGES ));
      out.write("\" );\r\n      return false;\r\n    }\r\n  }\r\n\r\n  function display( index, sessionId )\r\n  {\r\n    frmCaseToDoResults.hdnIdTodo.value = index;\r\n    disableValidation( \"frmCaseToDoResults\" );\r\n    submitValidateForm( \"frmCaseToDoResults\", \"/workload/ToDo/displayCaseToDoDetail\" );\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseToDo");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(ToDoConversation.DISPLAY_CASE_TODO_LIST_URI);
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
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
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearchFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseToDo");
          _jspx_th_impact_ButtonTag_0.setAction(ToDoConversation.DISPLAY_CASE_TODO_LIST_URI);
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
      _jspx_th_impact_validateForm_1.setName("frmCaseToDoResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction(ToDoConversation.DISPLAY_CASE_TODO_LIST_URI);
      _jspx_th_impact_validateForm_1.setPageMode(pageMode);
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl(ToDoConversation.DISPLAY_CASE_TODO_LIST_URI);
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <div id=\"noScrollResults\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">&nbsp;</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">Type</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Due Date\r\n            ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(ToDoConversation.CASE_TODO_SORT_BY_DATE);
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Assigned\r\n            ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(ToDoConversation.CASE_TODO_SORT_BY_ASSIGNED);
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Created By\r\n            ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(ToDoConversation.CASE_TODO_SORT_BY_CREATOR);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">Description</th>\r\n        </tr>\r\n");

  if ( !toDoExists )
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
      ROWCCMN42DO rowccmn42do = (ROWCCMN42DO)toDoIterator.next();
      String toDoTypeCode = rowccmn42do.getSzCdTodoType();
      String toDoTypeDecode = Lookup.simpleDecodeSafe( CodesTables.CTODOTYP, toDoTypeCode );
      String idTodo = String.valueOf( rowccmn42do.getLdIdTodo() );
      // Only Task To-Do's can be used for New Using
      String isTaskName = "isTask_" + idTodo;
      String isApprovalName = "isApproval_" + idTodo;
      // Need to use TaskInit to figure out if we have an approval todo
      String taskCode = rowccmn42do.getSzCdTask();
      String todoTaskType;
      try
      {
        todoTaskType = StringHelper.isValid( taskCode ) ?
                       TaskInit.getTaskColumnString( taskCode, TaskInit.CD_TASK_EVENT_TYPE ) : null;
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_5.setType("radio");
              _jspx_th_impact_validateInput_5.setName("rbIdToDo");
              _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_5.setValue(idTodo);
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
              out.write("\r\n          </td>\r\n          <td>\r\n");

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
              out.write("' );\">\r\n              ");
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
              out.print(FormattingHelper.formatDate( rowccmn42do.getDtDtTodoDue() ));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatString( rowccmn42do.getSzScrTodoAssignedTo() ));
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              out.print(FormattingHelper.formatString( rowccmn42do.getSzScrTodoCreated() ));
              out.write("\r\n          </td>\r\n          <td>\r\n            <div>\r\n              ");
              out.write("\r\n              <a href=\"javascript:display( '");
              out.print(idTodo);
              out.write("', '");
              out.print(sessionId);
              out.write("' );\">\r\n                ");
              out.print(FormattingHelper.formatString( rowccmn42do.getSzTxtTodoDesc() ));
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

  // SIR 23986 - Hide Add Case To-Do for checked out stages.
  if( Sets.isInSet( ToDoConversation.CASE_TODO_BUTTON_SET, request)
  && !(CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))&&
      !( pendStageProg || CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request)))))
  {

          out.write("\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ExpandableSectionTag_0.setName("addCaseToDo");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Add Alert");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <div id=\"noScrollResults\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableborderList\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">&nbsp;</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">Stage Code</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">Stage Name</th>\r\n          <th class=\"thList\" style=\"white-space: nowrap;\">Date Created</th>\r\n        </tr>\r\n");

    Iterator stageIterator = stageList != null ? stageList.iterator() : null;
    if ( stageIterator == null || !stageIterator.hasNext() )
    {
      toDoExists = true;

              out.write("\r\n        <tr class=\"odd\">\r\n          <td colspan=\"4\">\r\n            ");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("\r\n          </td>\r\n        </tr>\r\n");

    }
    else
    {
      int loopCount = 0;
      while( stageIterator.hasNext() )
      {
        CaseUtility.Stage stage = (CaseUtility.Stage)stageIterator.next();
        String idStage = FormattingHelper.formatInt( stage.getIdStage() );
        String cdStage = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, stage.getCdStage());
        String cdStageProgram = FormattingHelper.formatString( stage.getCdStageProgram() );
        String nmStage = FormattingHelper.formatString( stage.getNmStage() );
        String dtStart = FormattingHelper.formatDate( stage.getDtStart() );

              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setName("rbIdStage");
              _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_9.setValue(idStage);
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("dspCdStage_" + idStage );
              _jspx_th_impact_validateDisplayOnlyField_0.setValue(cdStage);
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setType("hidden");
              _jspx_th_impact_validateInput_10.setName("hdnCdStageProgram_" + idStage );
              _jspx_th_impact_validateInput_10.setValue(cdStageProgram);
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>");
              out.print(nmStage);
              out.write("</td>\r\n          <td>");
              out.print(dtStart);
              out.write("</td>\r\n        </tr>\r\n");

        loopCount++;
      }
    }

              out.write("\r\n      </table>\r\n    </div>\r\n    <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <td align=\"right\">\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnAddFinal");
              _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_1.setForm("frmCaseToDoResults");
              _jspx_th_impact_ButtonTag_1.setAction("/workload/ToDo/addCaseToDo");
              _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
              _jspx_th_impact_ButtonTag_1.setFunction("return addToDo()");
              _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnIdTodo");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnIdStage");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setName("hdnCdStage");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnCdStageProgram");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnAddAlert");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
