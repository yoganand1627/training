package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.workload.StageProgressionConversation;
import java.util.SortedMap;

public final class StageProgression_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------------
//*   JSP Name:    Stage Progression
//*  Created by:   Carolyn Douglass
//*  Date Created: 12/09/02
//*
//*  Description:
//*  This JSP displays the Stage Progression page.
//*
//*   Change History:
//*   Date      User              Description
//*
//* 5/26/05  DUNAWAKL           SIR 13544 - Added logic to check the age of person and
//*                            determine if they are the right age for the stage selected
//* 9/16/05  DOUGLACS          SIR 23781 - AOC stages will now go to the workload of
//*                            of the person who stage progresses.
//*--------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = StageProgressionConversation.getSessionStateManager(request);

  String pageMode = PageModeConstants.EDIT;
  String szCdStage = GlobalData.getSzCdStage( request );
  String nmPerson = (String) request.getAttribute("nmPerson");
  if (nmPerson == null) {
    nmPerson = "";
  }

  SortedMap stages = (SortedMap) state.getAttribute("stages", request);
  String newStage = (String) state.getAttribute("selNewStage", request);
  //If there is only 1 stage in the create new stage dropdown, default to that stage
  if ( stages.size() == 1) {
    newStage = stages.firstKey().toString();
  }

  /* Assign tab-index */
  int tabIndex = 1;
  String currStage = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, szCdStage) +" - "+ Lookup.simpleDecodeSafe( "CSTAGES", szCdStage);

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  /*\r\n   *This function is called before the page unloads. It creates the\r\n   *\"Are you sure you want to navigate away from this page...\" pop-up message.\r\n   */\r\n  window.onbeforeunload = function () {\r\n    IsDirty();\r\n  }\r\n\r\n  //This function checks to see if the stage should not have a person selected\r\n  function checkPerson(bSaveButtonPressed) {\r\n    var newStage = new String(document.frmStageProgression.selNewStage.value);\r\n    \r\n    if ( newStage != null && newStage != \"\") {\r\n      var stageName = new String(document.frmStageProgression.nmPerson.value);\r\n      var currStage = new String(document.frmStageProgression.szCdCurrStage.value);\r\n      try {\r\n        currStage = currStage.substr(0,3);\r\n      } catch(e) {}\r\n      \r\n      if ( ((currStage == \"");
      out.print(StageProgressionConversation.INT_STAGE);
      out.write("\" ||\r\n            currStage == \"");
      out.print(StageProgressionConversation.FPR_ONG_STAGE);
      out.write("\" ||\r\n            currStage == \"");
      out.print(StageProgressionConversation.FSU_FCF_STAGE);
      out.write("\") &&\r\n            newStage != \"");
      out.print(StageProgressionConversation.SUB_STAGE);
      out.write("\" &&\r\n            newStage != \"");
      out.print(StageProgressionConversation.ADO_STAGE);
      out.write("\" &&\r\n            newStage != \"");
      out.print(StageProgressionConversation.PAD_STAGE);
      out.write("\" &&\r\n            newStage != \"");
      out.print(StageProgressionConversation.PFC_STAGE);
      out.write("\")\r\n           ||\r\n           (currStage == \"");
      out.print(StageProgressionConversation.SUB_FCC_STAGE);
      out.write("\" ||\r\n            currStage == \"");
      out.print(StageProgressionConversation.ADO_STAGE);
      out.write("\" ||\r\n            currStage == \"");
      out.print(StageProgressionConversation.PAD_STAGE);
      out.write("\" ||\r\n            currStage == \"");
      out.print(StageProgressionConversation.PFC_STAGE);
      out.write("\") ) {\r\n        //-- cannot have person selected\r\n        if(!bSaveButtonPressed) {\r\n          alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_PERSON_NEEDED ) );
      out.write("\" );\r\n          return false;\r\n        } else {\r\n          //-- verify no person selected\r\n          if(stageName != null && stageName != \"\") {\r\n            alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_PERSON_NEEDED ) );
      out.write("\" );\r\n            return false;\r\n          }\r\n        }\r\n      } else if(bSaveButtonPressed) {\r\n        //-- must have person selected\r\n        if(stageName == null || stageName == \"\") {\r\n          alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_PERSON_NEEDED ) );
      out.write("\" );\r\n          return false;\r\n        }\r\n      }\r\n    } else {\r\n      //-- must select new stage before selecting person or saving\r\n      alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ) );
      out.write("\" );\r\n      return false;\r\n    }\r\n    return true; //-- no alerts displayed; continue person selection or save\r\n  }\r\n\r\n  //Begin SIR 13544\r\n  // This function verifies that the age of the person selected is right\r\n  // for the phase being moved into and if so calls the confirmStageProgress function\r\n  function confirmStageAgeAndProgress() {\r\n    var bCheckBday = ");
      out.print( state.getAttribute(StageProgressionConversation.CHECK_BDAY, request) );
      out.write(";\r\n    \r\n    if(bCheckBday != null && bCheckBday) {\r\n      var strAge = ");
      out.print( state.getAttribute(StageProgressionConversation.PERSON_AGE, request) );
      out.write(";\r\n      var strStage = new String(document.frmStageProgression.selNewStage.value);\r\n      var strBirthday = ");
      out.print( state.getAttribute(StageProgressionConversation.PERSON_BDAY, request) );
      out.write(";\r\n      \r\n      if (strBirthday != null && (strAge == \"\" || strAge == null || strAge == 0)) {\r\n        strAge = 1;\r\n      }\r\n          \r\n      if ( strStage == \"");
      out.print( StageProgressionConversation.SUB_STAGE );
      out.write("\" ||\r\n           strStage == \"");
      out.print( StageProgressionConversation.ADO_STAGE );
      out.write("\" ||\r\n           strStage == \"");
      out.print( StageProgressionConversation.PAD_STAGE );
      out.write("\" ||\r\n           strStage == \"");
      out.print( StageProgressionConversation.FSU_STAGE );
      out.write("\" ||\r\n           strStage == \"");
      out.print( StageProgressionConversation.PFC_STAGE );
      out.write("\" ||\r\n           strStage == \"");
      out.print( StageProgressionConversation.DIV_STAGE );
      out.write("\" ||\r\n           strStage == \"");
      out.print( StageProgressionConversation.FPR_STAGE );
      out.write("\" ) {\r\n        if (strAge != \"\" && strAge != null ) {\r\n          if (strAge < 26) {\r\n            return confirmStageProgress();\r\n          } else {\r\n            alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_AGE_TOO_OLD));
      out.write("\");\r\n            return false;\r\n          }\r\n        } else {\r\n          return confirm(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NO_BIRTHDAY));
      out.write("\");\r\n        }\r\n      }\r\n    }\r\n    return confirmStageProgress();\r\n  }\r\n  //end SIR 13544\r\n\r\n  //SIR 13558////////////////\r\n  // This function gives the user a message to reassign the stage before saving\r\n  // and to require a person be entered for certain stage progressions\r\n  function confirmStageProgress() {\r\n    var newStage = new String(document.frmStageProgression.selNewStage.value);\r\n    \r\n    if ( newStage != null && newStage != \"\") {\r\n      var currStage = new String(document.frmStageProgression.szCdCurrStage.value);\r\n      try {\r\n        currStage = currStage.substr(0,3);\r\n      } catch(e) {}\r\n      \r\n      //check to see if new stage requires a person\r\n      if(!checkPerson(true)) {\r\n        return false;\r\n      }\r\n      \r\n      // Give the user a confirmation message that the new stage will need to be reassigned.\r\n      bRetValue = confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CMN_STAGE_PROGRESS ) );
      out.write("\" );\r\n      if( bRetValue ) {\r\n        disableValidation( \"frmStageProgression\" );\r\n      } else {\r\n        enableValidation( \"frmStageProgression\" );\r\n      }\r\n      return bRetValue;\r\n    } else {\r\n      //-- must select new stage before saving\r\n      alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ) );
      out.write("\" );\r\n      return false;\r\n    }\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStageProgression");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/StageProgression/displayStageProgression");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=3>Stage Progression</th>\r\n    </tr>\r\n    <tr>\r\n      <td width=\"20%\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("szCdCurrStage");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Current Stage");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(currStage);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Create New Stage");
          _jspx_th_impact_validateSelect_0.setName("selNewStage");
          _jspx_th_impact_validateSelect_0.setValue(newStage);
          _jspx_th_impact_validateSelect_0.setOptions(stages.values());
          _jspx_th_impact_validateSelect_0.setStyle("width:200");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("nmPerson");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Stage Name");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(nmPerson);
          _jspx_th_impact_validateDisplayOnlyField_1.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnPerson");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_0.setFunction("return checkPerson(false)");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmStageProgression");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/StageProgression/createPersonList");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmStageAgeAndProgress();");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmStageProgression");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/StageProgression/saveStageProgression");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
