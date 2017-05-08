package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailCustomValidation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import java.util.Iterator;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public final class ToDoDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ToDoDetailDB toDoDetailDB = ToDoConversation.getToDoDetailDB( request, state );
  
  String pageMode = PageMode.getPageMode( request );

  int tabIndex = 1;
  String ToDoType;
  String initials = toDoDetailDB.getInitialsPersonCreator();
  String descriptionPrefix = initials != null && !"".equals(initials) ? initials + ToDoConversation.DASH_STRING : "";
  // SIR 19783 - set the variable to hide or show the select staff button
  boolean hidebtnSelectStaff = "true".equalsIgnoreCase(Sets.isInSetStr( ToDoConversation.DISABLE_STAFF_SERACH_BUTTON_SET, request ));

      out.write("\r\n<script language=\"Javascript\">\r\n  // SIR 19783 - Added the JS funtion to disable the button, once Save button is clicked. So that\r\n  //             they can't change the Assigned To person, once save button is clicked.\r\n  function disableStaffFinal()\r\n  {\r\n    ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( !hidebtnSelectStaff );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n      disableButton('btnSelectStaff');\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  }\r\n\r\n  function disableButton(buttonName)\r\n  {\r\n    eval(\"document.frmToDoDetail.\" + buttonName + \"IsEnabled.value='false';\");\r\n    eval(\"toggleVisibility('\" + buttonName + \"_EnableClick_Id', 'none');\");\r\n    eval(\"toggleVisibility('\" + buttonName + \"_DisableClick_Id', 'block');\");\r\n  }\r\n\r\n  function updateShortDesc()\r\n  {\r\n    var index = frmToDoDetail.selSzCdTask.selectedIndex;\r\n    var options = frmToDoDetail.selSzCdTask.options;\r\n    var option = options[index];\r\n    frmToDoDetail.txtSzTxtTodoDesc.value = \"");
      out.print(descriptionPrefix);
      out.write("\" + option.innerText;\r\n  }\r\n\r\n  function saveToDoDetail()\r\n  {\r\n");

  Map taskNewIndMap = toDoDetailDB.getTaskNewIndMap();
  // we only need to create this javascript in new using mode because taskNewIndMap is only populated on new using
  if( taskNewIndMap != null )
  {

      out.write("\r\n    var code = frmToDoDetail.selSzCdTask.value;\r\n    var cSysIndTaskNew = false;\r\n    var bLinkEvent = false;\r\n");

  // Create if conditions for each key of taskNewIndMap whose value indicates that we should prompt
  //The out.println's are generating javascript which runs on save
  out.println("    if (false) ");
  out.println("    {");
  //placeholder to make generating if code below easier
  out.println("    }");

  boolean firstLoop = true;
  Iterator taskNewIndMapIterator = taskNewIndMap.keySet().iterator();
  while( taskNewIndMapIterator.hasNext() )
  {
    String szCdTask = (String)taskNewIndMapIterator.next();
    String taskNewInd = (String)taskNewIndMap.get( szCdTask );
    String linkMessage = MessageLookup.getMessageByNumber( Messages.MSG_CMN_TASK_LIST_TODO );
    linkMessage = MessageLookup.addMessageParameter( linkMessage, "event" );

    //distilled from ccmn63w.win;
    //  makes sense when read in conjunction with ToDoConversation.getTaskNewIndMap()

    if( ToDoConversation.IND_TASK_NEW_TRUE.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      cSysIndTaskNew = true;");
      out.println("    }");
    }
    else if( ToDoConversation.IND_TASK_NEW_FALSE.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      cSysIndTaskNew = false;");
      out.println("    }");
    }
    else if( ToDoConversation.IND_TASK_MUST_LINK.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      cSysIndTaskNew = false;");
      out.println("      bLinkEvent = true;");
      out.println("    }");
    }
    else if( ToDoConversation.IND_TASK_NEW_PROMPT.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      bLinkEvent = confirm( '" + linkMessage + "' );");
      out.println("      cSysIndTaskNew = !bLinkEvent;");
      out.println("    }");
    }
   }

      out.write("\r\n    if( cSysIndTaskNew )\r\n    {\r\n      frmToDoDetail.hdnCSysIndTaskNew.value = \"");
      out.print(ToDoConversation.IND_TASK_NEW_TRUE);
      out.write("\";\r\n    }\r\n    else\r\n    {\r\n      frmToDoDetail.hdnCSysIndTaskNew.value = \"");
      out.print(ToDoConversation.IND_TASK_NEW_FALSE);
      out.write("\";\r\n    }\r\n    frmToDoDetail.bLinkEvent.value = bLinkEvent;\r\n");

  }
 
      out.write("\r\n    return true;\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmToDoDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/ToDo/displayToDoDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">To-Do Data</th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtDueDate");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex);
          _jspx_th_impact_validateDate_0.setLabel("Due Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled(ToDoConversation.getDisableDueDate( toDoDetailDB ));
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate( toDoDetailDB.getDtDtTodoDue() ));
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtCompletedDate");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex);
          _jspx_th_impact_validateDate_1.setLabel("Completed Date");
          _jspx_th_impact_validateDate_1.setDisabled(ToDoConversation.getDisableCompleted( toDoDetailDB ));
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate( toDoDetailDB.getDtDtTodoCompleted() ));
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          out.write("\r\n              <input type=\"hidden\" name=\"hdnIdPersAssigned\" value=\"");
          out.print( toDoDetailDB.getUlIdTodoPersAssigned() );
          out.write("\">\r\n              <span class=\"formRequiredText\">*</span>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzScrTodoAssignedTo");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Assigned To");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString( toDoDetailDB.getSzNmPersonFullAssigned() ));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n");
//SIR 19783 - added preventDoubleClick and restrictRepost so that button will disable once clicked.
          out.write("\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + hidebtnSelectStaff );
          _jspx_th_impact_ButtonTag_0.setFunction("javascript:disableValidation( 'frmToDoDetail' );");
          _jspx_th_impact_ButtonTag_0.setForm("frmToDoDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ToDo/displayStaffSearch");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\r\n\r\n            </td>\r\n            <td>&nbsp;</td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("txtSzTxtTodoDesc");
          _jspx_th_impact_validateInput_2.setLabel("Short Description");
          _jspx_th_impact_validateInput_2.setColspan("3");
          _jspx_th_impact_validateInput_2.setSize("80");
          _jspx_th_impact_validateInput_2.setMaxLength("80");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex);
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString( toDoDetailDB.getSzTxtTodoDesc() ));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td valign=\"top\">\r\n              ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtTodoLongDesc");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_0.setLabel("Description/Notes");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n                ");
              out.print(FormattingHelper.formatString( toDoDetailDB.getTxtTodoLongDesc() ));
              out.write("\r\n              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <th colspan=\"2\">Case Stage</th>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"50%\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr>\r\n            <td width=\"30%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspSzNmStage");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Stage");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatString( toDoDetailDB.getSzNmStage() ));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"30%\">\r\n           \r\n");
          out.write('\r');
          out.write('\n');
          out.write(' ');
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n      <td width=\"50%\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr>\r\n            <td width=\"30%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzNmPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Staff");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString( toDoDetailDB.getSzNmPersonFullWorker() ));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"30%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspDtDtTaskDue");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("To-Do Due Date");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate( toDoDetailDB.getDtDtTaskDue() ));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <th colspan=\"2\">Created By</th>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"50%\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr>\r\n            <td width=\"30%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspUlIdTodoPersCreator");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatString( toDoDetailDB.getSzNmPersonFullCreator() ));
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n");

  String createdByDate = FormattingHelper.formatDate( toDoDetailDB.getDtDtTodoCreated() );
  String createdByTime = toDoDetailDB.getTmTmTodoCreated();
  if(toDoDetailDB.getLdIdTodo() == 0){
    createdByDate = "";
    createdByTime = "";
  }

          out.write("\r\n        <td width=\"50%\">\r\n          <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n            <tr>\r\n            <td width=\"30%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspDtDtTodoCreated");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Date");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( createdByDate );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            \r\n            \r\n            <td width=\"30%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("timeDtDtTodoCreated");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Time");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( createdByTime );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>    \r\n            \r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n     \r\n  <br>\r\n  <div align=\"right\">\r\n  ");

    String saveAction = "/workload/ToDo/saveToDoDetail";
    String saveFunction = "disableStaffFinal();saveToDoDetail();";
    if(toDoDetailDB.isAlert()){
      saveAction = "/workload/ToDo/saveAlert";
      saveFunction = "";
    }
  
          out.write("\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setForm("frmToDoDetail");
          _jspx_th_impact_ButtonTag_1.setAction( saveAction );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setFunction( saveFunction );
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </div>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n\r\n  \r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<script language=\"Javascript\">\r\n");
      out.write('\r');
      out.write('\n');

  Object assignedToClassName = request.getAttribute( ToDoDetailCustomValidation.ASSIGNED_TO_CLASS_KEY );
  if( assignedToClassName != null )
  {

      out.write("\r\n  window.attachEvent( 'onload', updateAssignedToLabel );\r\n  function updateAssignedToLabel()\r\n  {\r\n    document.getElementById( \"label_dspSzScrTodoAssignedTo_id\" ).className=\"");
      out.print(assignedToClassName);
      out.write("\";\r\n  }\r\n");

  }

      out.write("\r\n</script>\r\n");
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
    _jspx_th_impact_validateInput_0.setName("hdnCSysIndTaskNew");
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
    _jspx_th_impact_validateInput_1.setName("bLinkEvent");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
