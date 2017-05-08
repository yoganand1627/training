package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;

public final class FosterCarePartSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
//*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************

      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      FosterCareParticipantRetrieveSO fosterCarePart = (FosterCareParticipantRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "RETRIEVESO",
                                                                                                            request);

      int ulIdEvent = GlobalData.getUlIdEvent(request);
      String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);
      String formLabel = "";
      Iterator iter = null;
      int loopCounter = 0;
      String tabindexString = (String) request.getAttribute("tabIndex");
      int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
      int idEvent = fosterCarePart.getUlIdEvent();
      state.setAttribute("includingFormName", includingFormName, request);
      
      Boolean wtlpCopyClicked = (Boolean) state.getAttribute("WTLP_COPY_CLICKED", request);
      Boolean copyClicked = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
      if (wtlpCopyClicked == null) {
		  wtlpCopyClicked = false;
	  }
	  
	  if(copyClicked == null){
	     copyClicked = false;
	  }	  
	  
	  String disableAddBtn = ArchitectureConstants.FALSE; 
	  String disableDeleteBtn = ArchitectureConstants.FALSE; 
	  
	  if(idEvent == 0 || wtlpCopyClicked || copyClicked){
       disableAddBtn = ArchitectureConstants.TRUE ;
      }else{
      disableAddBtn = ArchitectureConstants.FALSE;  
      }
      
      disableDeleteBtn = disableAddBtn;

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************

      if ("frmFCCPFamilyDetail".equals(includingFormName)) {
        formLabel = "Foster Care Case Plan Participant List";
      } else if ("frmWTLP".equals(includingFormName)) {
        formLabel = "WTLP Participation";
      }
      state.setAttribute("fosterCareList", fosterCarePart, request);
      //******************
      //*** JAVASCRIPT ***
      //******************

      
      out.write("\r\n\r\n<script language=\"Javascript\">\r\nfunction goToParticipantDetailPage(selectedParticipantId )\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".selectedParticipantId.value = selectedParticipantId;\r\n  disableValidation( '");
      out.print( includingFormName );
      out.write("' );\r\n  submitValidateForm('");
      out.print( includingFormName );
      out.write("', '/casemgmt/FosterCareParticipant/displayFosterCareParticipant');\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddFCPart.value = 'false';\r\n  document.");
      out.print( includingFormName );
      out.write(".isDelFCPart.value = 'false';\r\n}\r\n\r\nfunction addFCPartDetail()\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".isAddFCPart.value = 'true';\r\n  return true;\r\n}\r\n\r\nfunction delFCPartDetail()\r\n{\r\n  document.");
      out.print( includingFormName );
      out.write(".isDelFCPart.value = 'true';\r\n  return true;\r\n}\r\n\r\nfunction confirmRowSelected()\r\n{\r\n  var rowSelected = false;\r\n  var fieldName = \"document.\" + ");
      out.print( includingFormName );
      out.write(" + \".rbParticipantId_CLEAN\";\r\n  \r\n  // If the radio button group is an array (i.e., more than one radio\r\n  // button), then loop through the array and check for a selected radio\r\n  // button; otherwise, check the single radio button to see if it is\r\n  // selected.\r\n  if (document.");
      out.print( includingFormName );
      out.write(".rbParticipantId_CLEAN[0])\r\n  {\r\n    for (var i = 0; i < document.");
      out.print( includingFormName );
      out.write(".rbParticipantId_CLEAN.length; i++)\r\n    {\r\n      if (document.");
      out.print( includingFormName );
      out.write(".rbParticipantId_CLEAN[i].checked)\r\n      {\r\n        rowSelected = true;\r\n        break;\r\n      }\r\n    }\r\n  }\r\n  else\r\n  {\r\n    if (document.");
      out.print( includingFormName );
      out.write(".rbParticipantId_CLEAN.checked)\r\n    {\r\n      rowSelected = true;\r\n    }\r\n  }\r\n\r\n  if (rowSelected == false)\r\n  {\r\n    alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    return confirm(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("\");\r\n  }\r\n  return false;\r\n}\r\n</script>\r\n");
      if (_jspx_meth_impact_validateInput_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateInput_4(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_5.setParent(null);
      _jspx_th_impact_validateInput_5.setType("hidden");
      _jspx_th_impact_validateInput_5.setName("includingFormName");
      _jspx_th_impact_validateInput_5.setValue(includingFormName);
      int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
      if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n        \r\n  ");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName( includingFormName );
      _jspx_th_impact_ExpandableSectionTag_0.setId("fcPart_0");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel( formLabel );
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        <div id=\"scrollBar\" style=\"height:165px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n              <tr>\r\n                <th class=\"thList\">&nbsp;</th>\r\n                <th class=\"thList\">Name</th>\r\n                <th class=\"thList\">Rel/Int</th>\r\n                <th class=\"thList\">Participation</th>\r\n                <th class=\"thList\">Signed Receipt of Copy</th>\r\n                <th class=\"thList\">Agreed?</th>\r\n        <th class=\"thList\">Date Agreed</th>\r\n              </tr>\r\n              ");

              iter = fosterCarePart.getFosterCarePartList().iterator();
              while (iter.hasNext())
              {
               FosterCarePartBean participant = 
                   (FosterCarePartBean)iter.next();
                
          out.write("\r\n                <tr class=\"");
          out.print( FormattingHelper.getRowCss(loopCounter + 1) );
          out.write("\">\r\n                  <td>\r\n                    ");

                    // The name of this radio button ends in "_CLEAN" so that the
                    // radio group will be excluded from the 'isDirty' check. We
                    // don't want the user to get the message "Your unsaved data
                    // will be lost" just because they selected a radio button.
                    
          out.write("\r\n                    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatInt(participant.getIdPlanPart()) );
          _jspx_th_impact_validateInput_6.setName("rbParticipantId_CLEAN");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>\r\n                  <td><a href=\"JavaScript:goToParticipantDetailPage(");
          out.print( FormattingHelper.formatInt(participant.getIdPlanPart()) );
          out.write(");\">");
          out.print( participant.getSzNmPart() );
          out.write(" </a></td>\r\n                  <td>");
          out.print( FormattingHelper.formatString(participant.getSzCdRelInt()) );
          out.write("</td>\r\n           \r\n          <td>");
          out.print( FormattingHelper.formatDate(participant.getDtPart()) );
          out.write("</td>\r\n                  <td>");
          out.print( FormattingHelper.formatDate(participant.getDtSigned()) );
          out.write("</td>\r\n                  <td>");
          out.print( FormattingHelper.formatString(participant.getIndApproval()) );
          out.write("</td>\r\n                  <td>");
          out.print( FormattingHelper.formatDate(participant.getDtApprv()) );
          out.write("</td>\r\n                </tr>\r\n                ");

                loopCounter++;
              } // end while (iter.hasNext())
              
          out.write("\r\n            </table>\r\n          </div>\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n            <tr>\r\n            ");
 if (loopCounter != 0) {
          out.write("\r\n              <td>\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_0.setAction("/casemgmt/FosterCareParticipant/deleteFCParticipant");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmRowSelected()");
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setDisabled( disableDeleteBtn );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              ");
} //delete button
          out.write("\r\n              <td>\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm( includingFormName );
          _jspx_th_impact_ButtonTag_1.setAction("/casemgmt/FosterCareParticipant/addFosterCareParticipant");
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setDisabled( disableAddBtn );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </tr>\r\n          </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent(null);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("fcPartIndex");
    _jspx_th_impact_validateInput_0.setValue("0");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent(null);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("isAddFCPart");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent(null);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("isDelFCPart");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent(null);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnIdEvent");
    _jspx_th_impact_validateInput_3.setValue("<%idEvent%>");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent(null);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("selectedParticipantId");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
