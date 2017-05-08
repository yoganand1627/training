package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.StageClosureConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.Iterator;
import java.text.SimpleDateFormat;

public final class StageReopen_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int ulIdEvent = 0;
  int ulIdStage = 0;
  String cdTask = "";
  String tsLastUpdate ="";
  int tabIndex = 1;
  boolean sDisableField = false;

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  
  // Get the whole output object here from the request and get the individual pieces later.
  StageReopenRetrieveSO stageReopenRetrieveSO = (StageReopenRetrieveSO) state.getAttribute("stageReopenRetrieveSO", request); 
  //Set the page mode
  String pageMode = PageMode.getPageMode(request);
  
  if (pageMode.equals(PageModeConstants.VIEW)) {
    sDisableField = true;
  }
  
  if(CodesTables.CEVTSTAT_COMP.equals(stageReopenRetrieveSO.getCdEventStatus())){
    sDisableField = true;
  }
  
  if(ArchitectureConstants.N.equals(stageReopenRetrieveSO.getBIndStageReopen())){
    sDisableField = true;
  }
  
  if (stageReopenRetrieveSO.getUlIdEvent() != 0) {
      tsLastUpdate = DateHelper.toISOString(stageReopenRetrieveSO.getDtLastUpdate());
  }
  
  SimpleDateFormat SLASH_FORMAT = new SimpleDateFormat("MM/dd/yyyy");


 
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.attachEvent('onbeforeunload', checkIsDirty);\r\n\r\nfunction checkIsDirty()\r\n{\r\n  IsDirty();\r\n}\r\n\r\nfunction savePageAdd()\r\n{\r\n    if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFRM_SAVE));
      out.write("') == true){\r\n       return true;\r\n    } \r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStageReopen");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/StageReopen/saveStageReopen");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.StageReopenCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <input type=\"hidden\" name=\"ulIdEvent\" value=\"");
          out.print(ulIdEvent);
          out.write("\">\r\n  <input type=\"hidden\" name=\"ulIdStage\" value=\"");
          out.print(ulIdStage);
          out.write("\">\r\n  <input type=\"hidden\" name=\"szCdTask\" value=\"");
          out.print(cdTask);
          out.write("\">\r\n  <input type=\"hidden\" name=\"idRequestedBy\" value=\"");
          out.print(stageReopenRetrieveSO.getIdRequestedBy() );
          out.write("\">\r\n  <input type=\"hidden\" name=\"idPerformedBy\" value=\"");
          out.print(stageReopenRetrieveSO.getIdPerformedBy());
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnSzClosureReason\" value=\"");
          out.print(stageReopenRetrieveSO.getSzClosureReason());
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnDtStageClosure\" value=\"");
          out.print(DateHelper.toJavaDate(FormattingHelper.formatDate(stageReopenRetrieveSO.getDtStageClosure()), SLASH_FORMAT));
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnTxtClosureComments\" value=\"");
          out.print(stageReopenRetrieveSO.getTxtClosureComments());
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnNmApprover\" value=\"");
          out.print(stageReopenRetrieveSO.getNmApprover());
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnDtApproval\" value=\"");
          out.print(stageReopenRetrieveSO.getDtApproval());
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnTxtApproversComments\" value=\"");
          out.print(stageReopenRetrieveSO.getTxtApproversComments());
          out.write("\">\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_0.setValue(tsLastUpdate);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Previous Stage Closure Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("szClosureReason");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Closure Reason");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(stageReopenRetrieveSO.getSzClosureReason()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dtStageClosure");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Closure Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatDate(stageReopenRetrieveSO.getDtStageClosure()) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtClosureComments");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Closure Comments");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(stageReopenRetrieveSO.getTxtClosureComments()) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("nmApprovedBy");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Closure Approved By");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatString(stageReopenRetrieveSO.getNmApprover()) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dtApproval");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Closure Approval Date");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatDate(stageReopenRetrieveSO.getDtApproval()) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("txtApproversComments");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Closure Approver's Comments");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatString(stageReopenRetrieveSO.getTxtApproversComments()) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Stage Reopen Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("txtDtDtStageReopen");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Date");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatDate(stageReopenRetrieveSO.getDtStageReopened()) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("szNmPerformedBy");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Performed By");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatString(stageReopenRetrieveSO.getSzNmPerformedBy()) );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"35%\">\r\n      <b style=\"color: red; font-size: 15pt;\">*</b>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("szNmRequestedBy");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Requested By");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatString(stageReopenRetrieveSO.getSzNmRequestedBy()) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t<td>\r\n\t          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setForm("frmStageReopen");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/StageReopen/performStaffSearch");
          _jspx_th_impact_ButtonTag_0.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmStageReopen');");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

 Collection<CodeAttributes> reopenReasons = Lookup.getCategoryCollection(CodesTables.CRREOPEN);
 List reopenReasonListTemp = new ArrayList(reopenReasons);
 List reopenReasonList = new ArrayList();
 //STGAP00014941: Checkboxes are displayed depending on the stage type
 if(reopenReasonListTemp != null){
   for(Iterator<CodeAttributes> it = reopenReasonListTemp.iterator(); it.hasNext();){
     CodeAttributes ca = it.next();
     reopenReasonList.add(ca);
     if(CodesTables.CRREOPEN_APE.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_APC.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PFC.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_DPC.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PFC.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_UPL.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PFC.equals(GlobalData.getSzCdStage(request)) ||
        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_AFC.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request)) ||
        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
   }
 }
 List<String> checkedCheckboxesList = new ArrayList<String>(); 
 if(stageReopenRetrieveSO.getCheckedCheckboxes() != null){
     checkedCheckboxesList = Arrays.asList(stageReopenRetrieveSO.getCheckedCheckboxes());
  }
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">\r\n      <b style=\"color: red; font-size: 15pt;\">*</b>\r\n         Reopen Reasons\r\n    </th>\r\n  </tr>\r\n   <tr>\r\n       <td>\r\n          ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_castorCheckbox_0.setCastorEnum( Collections.enumeration(reopenReasonList) );
          _jspx_th_impact_castorCheckbox_0.setName("chkReopenReasons");
          _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("Code");
          _jspx_th_impact_castorCheckbox_0.setValuePropertyName("Decode");
          _jspx_th_impact_castorCheckbox_0.setCheckedValues( checkedCheckboxesList );
          _jspx_th_impact_castorCheckbox_0.setColumns(3);
          _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_0.setIsHorizontal(false);
          _jspx_th_impact_castorCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_castorCheckbox_0.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
          if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("selSzTxtStageReopenCmnts");
          _jspx_th_impact_validateTextArea_0.setLabel("Justification");
          _jspx_th_impact_validateTextArea_0.setRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n        ");
              out.print(stageReopenRetrieveSO.getSzTxtStageReopenCmnts() != null ? stageReopenRetrieveSO.getSzTxtStageReopenCmnts() : "");
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"80%\">&nbsp;</td>\r\n    ");
if(!sDisableField){ 
          out.write("\r\n\t    <td width=\"10%\" class=\"alignRight\">\r\n\t      ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmStageReopen");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck("selSzTxtStageReopenCmnts");
          _jspx_th_impact_spellCheck_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t    </td>\r\n  ");
} 
          out.write("\r\n  <td width=\"10%\" class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmStageReopen");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/workload/StageReopen/saveStageReopen");
          _jspx_th_impact_ButtonTag_1.setFunction("return savePageAdd();");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Hidden fields to persist state\r\n !------------------------------------------------------------------------------------------------>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
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
}
