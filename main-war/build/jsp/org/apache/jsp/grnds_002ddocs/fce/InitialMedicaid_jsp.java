package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IncomeResourceMedicaidSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrincipalsList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;

public final class InitialMedicaid_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    /**  JSP Name:    InitialMedicaid.jsp
       *  Created by:   Gautami Rout
      *  Date Created: 3/15/07
      *
      *
      * Change History:
      *
      * Date      User              Description
      * --------  ----------------  --------------------------------------------------
      * 4/13/09     cwells          Displaying all required and conditionaly required symbols. 
      * 5/14/09     cwells          STGAP00011727 - Decoding type for Income and resources for child section.     
      *
      *
      *
      **/

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n");

     String BUTTONATTRB = "buttonAttrb";
     String APPROVED_EVENT = "APRV";
     String PENDING_EVENT = "PEND";
     boolean bDisabledSignNow = false;
     int tabIndex = 1;
     boolean noChecked = false;
     BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
     String pageMode = PageMode.getPageMode(request);
     // Get the CCMN04SO output object out of the request
     MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO = (MedicaidApplicationRetrieveSO) state
                                                                           .getAttribute(
                                                                                         "MedicaidApplicationRetrieveSO",
                                                                                         request);
      if (medicaidApplicationRetrieveSO == null) {
        medicaidApplicationRetrieveSO = new MedicaidApplicationRetrieveSO();
      }
      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nwindow.attachEvent(\"onload\", initializePage);\r\n\r\nfunction initializePage(){\r\n  var x = document.frmInitialMedicaid;\r\n  if(x.indChildCoverage[0].checked == true){\r\n    enablePage();\r\n  }else{\r\n    disablePage();\r\n  }\r\n  if (x.indIcamaIcpc.checked == false) {\r\n  \ttoggleIcama();\r\n  }\r\n}\r\n\r\n\r\nfunction submitPersonDetail( idPerson )\r\n{\r\n    setIsDirtyCalled( true );\r\n    document.frmInitialMedicaid.hdnPersonDetailId.value = idPerson;\r\n    submitValidateForm( \"frmInitialMedicaid\", \"/fce/InitialMedicaid/forwardPersonDetail\" );\r\n}\r\n\r\nfunction disablePage()\r\n{\r\n  var x = document.frmInitialMedicaid;\r\n  x.indChild[0].disabled = true;\r\n  x.indChild[1].disabled = true;\r\n  x.cdType.disabled = true;\r\n  x.nmCompany.disabled = true;\r\n  x.nbrPolicy.disabled = true;\r\n  x.nbrGroup.disabled = true;\r\n  x.addrStLn1.disabled = true;\r\n");
      out.write("  x.addrStLn2.disabled = true;\r\n  x.addrCity.disabled = true;\r\n  x.addrState.disabled = true;\r\n  x.addrZip.disabled = true;\r\n  x.addrZipSuff.disabled = true;\r\n  x.nbrPhone.disabled = true;\r\n  x.nmPolicyHolder.disabled = true;\r\n  x.dtBegin.disabled = true;\r\n  x.dtEnd.disabled = true;\r\n  x.nmEmployer.disabled = true;\r\n  x.nmEmployeeName.disabled = true;\r\n}\r\n\r\nfunction enablePage()\r\n{\r\n  var x = document.frmInitialMedicaid;\r\n  x.indChild[0].disabled = false;\r\n  x.indChild[1].disabled = false;\r\n  x.cdType.disabled = false;\r\n  x.nmCompany.disabled = false;\r\n  x.nbrPolicy.disabled = false;\r\n  x.nbrGroup.disabled = false;\r\n  x.addrStLn1.disabled = false;\r\n  x.addrStLn2.disabled = false;\r\n  x.addrCity.disabled = false;\r\n  x.addrState.disabled = false;\r\n  x.addrZip.disabled = false;\r\n  x.addrZipSuff.disabled = false;\r\n  x.nbrPhone.disabled = false;\r\n  x.nmPolicyHolder.disabled = false;\r\n  x.dtBegin.disabled = false;\r\n  x.dtEnd.disabled = false;\r\n  x.nmEmployer.disabled = false;\r\n  x.nmEmployeeName.disabled = false;\r\n}\r\n");
      out.write("\r\nfunction toggleIcama()\r\n{\r\n  var x = document.frmInitialMedicaid;\r\n  if (x.cdIcamaState.disabled == true) {\r\n\tx.cdIcamaState.disabled = false;\r\n  } else {\r\n  \tx.cdIcamaState.disabled = true;\r\n  }\r\n  if (x.cdIcamaAsstType.disabled == true) {\r\n\tx.cdIcamaAsstType.disabled = false;\r\n  } else {\r\n  \tx.cdIcamaAsstType.disabled = true;\r\n  }\r\n  if (x.cdAdoptionType.disabled == true) {\r\n\tx.cdAdoptionType.disabled = false;\r\n  } else {\r\n  \tx.cdAdoptionType.disabled = true;\r\n  }\r\n  if (x.txtIcamaComments.disabled == true) {\r\n\tx.txtIcamaComments.disabled = false;\r\n  } else {\r\n  \tx.txtIcamaComments.disabled = true;\r\n  }\r\n}\r\n\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmInitialMedicaid");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fce/InitialMedicaid/displayInitialMedicaid");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.InitialMedicaidCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("idPerson");
          _jspx_th_impact_validateInput_0.setValue(String.valueOf(medicaidApplicationRetrieveSO.getIdPerson()));
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
          _jspx_th_impact_validateInput_1.setName("hdnPersonDetailId");
          _jspx_th_impact_validateInput_1.setValue(String.valueOf(medicaidApplicationRetrieveSO.getIdPerson()));
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
          _jspx_th_impact_validateInput_2.setName("hdnDtRemoval");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getRemvDate()));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\t\r\n");

     boolean signNowPressed = Boolean.parseBoolean(state.getAttribute(BUTTONATTRB, request) != null ? 
                                                  state.getAttribute(BUTTONATTRB, request).toString() :
                                                  (String)null);
                                                  
     if(medicaidApplicationRetrieveSO == null){
       medicaidApplicationRetrieveSO = new MedicaidApplicationRetrieveSO();
     }
     String healthZip = medicaidApplicationRetrieveSO.getAddrZip();
     String healthZipSuff = "";
     if(healthZip != null && healthZip != ""){
       if (healthZip.length() > 5) {
          healthZipSuff = healthZip.substring(5);
          healthZip = healthZip.substring(0, 5);
       }
     }
     UserProfile user = UserProfileHelper.getUserProfile(request);
     String cdEventStatus = medicaidApplicationRetrieveSO.getCdEventStatus();
     String bDisabled = "" + APPROVED_EVENT.equals(cdEventStatus);

/*
     if ((pageMode.equals(PageModeConstants.VIEW))
       && ((APPROVED_EVENT.equals(cdEventStatus)) || 
       ((user.hasRight(UserProfile.SEC_ELIGIBILITY) || user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST)) && 
       ((PENDING_EVENT.equals(cdEventStatus)))))) {
*/
     if (((pageMode.equals(PageModeConstants.VIEW)) && (APPROVED_EVENT.equals(cdEventStatus))) ||
     	((user.hasRight(UserProfile.SEC_ELIGIBILITY) && (PENDING_EVENT.equals(cdEventStatus))))) {
    
          out.write("\r\n \r\n\t<br>\r\n\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"5\">\r\n\t\t\t\tEligibility Specialist Confirmation\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\tPlease confirm:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtProcessed");
          _jspx_th_impact_validateDate_0.setLabel("Date Processed");
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateDate_0.setDisabled( bDisabled );
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtProcessed()));
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtComments");
          _jspx_th_impact_validateTextArea_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateTextArea_0.setDisabled( bDisabled );
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(StringHelper.isValid(medicaidApplicationRetrieveSO.getTxtComments()) ? medicaidApplicationRetrieveSO.getTxtComments() : "");
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSaveConfirmation");
          _jspx_th_impact_ButtonTag_0.setImg("btnSaveConfirmation");
          _jspx_th_impact_ButtonTag_0.setForm("frmInitialMedicaid");
          _jspx_th_impact_ButtonTag_0.setAction("/fce/InitialMedicaid/saveConfirmationInitialMedicaid");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setDisabled( bDisabled );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
}
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp; <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\r\n\t\t<tr>\r\n\t\t\t<th colspan=10>\r\n\t\t\t\tChild Information\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("ChildName");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Child's Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getChildName()) ? medicaidApplicationRetrieveSO.getChildName() : "");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("gender");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Gender");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getGender()) ? Lookup.simpleDecodeSafe("CSEX", medicaidApplicationRetrieveSO.getGender()) : "");
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("race");
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Race");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getRace())? Lookup.simpleDecodeSafe("CRACE", medicaidApplicationRetrieveSO.getRace()) : "");
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dtBirth");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Date of Birth");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDob()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("nbrSocialSecurity");
          _jspx_th_impact_validateDisplayOnlyField_4.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Social Security Number");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getSsn()) ? medicaidApplicationRetrieveSO.getSsn(): "" );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("indCitizenshipStatus");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Citizenship Status");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getCitizenship())? Lookup.simpleDecodeSafe("CCTZNSTA", medicaidApplicationRetrieveSO.getCitizenship()) : "");
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("cdCounty");
          _jspx_th_impact_validateDisplayOnlyField_6.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getCounty())? Lookup.simpleDecodeSafe("CCOUNT", medicaidApplicationRetrieveSO.getCounty()) : "");
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dtRemoval");
          _jspx_th_impact_validateDisplayOnlyField_7.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Removal Date");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getRemvDate()));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("childPregnancy");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Child Pregnant?");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getChildPregnancy()) ? medicaidApplicationRetrieveSO.getChildPregnancy() : " ");
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("idPerson");
          _jspx_th_impact_validateDisplayOnlyField_9.setColspan("2");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Person ID");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(String.valueOf(medicaidApplicationRetrieveSO.getIdPerson() != 0 ? medicaidApplicationRetrieveSO.getIdPerson(): ""));
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnChildDetail");
          _jspx_th_impact_ButtonTag_1.setImg("btnDetail");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmInitialMedicaid");
          _jspx_th_impact_ButtonTag_1.setAction("/fce/InitialMedicaid/forwardPersonDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t");
/*  Begin Expandable Section with List Table */

      
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setAnchor("test");
          _jspx_th_impact_ExpandableSectionTag_0.setName("PrincipalsList");
          _jspx_th_impact_ExpandableSectionTag_0.setId("PrincipalsList");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Child's Parent Information (Please select the appropriate mother & father applicant of the child)");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<div id=\"scrollBar\" style=\"height:250;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tParent?\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tName\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tPat.\r\n\t\t\t\t\t\t<br>\r\n\t\t\t\t\t\tEst?\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tRelationship\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tDate of Birth\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tCurrent Address\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tSSN\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tMarital\r\n\t\t\t\t\t\t<br>\r\n\t\t\t\t\t\tStatus\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tRace\r\n\t\t\t\t\t</th>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");
List principals = medicaidApplicationRetrieveSO.getPrincipalsBeanList();
                 if (principals == null || principals.size() == 0) {
                 
              out.write("\r\n\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t<td colspan=\"9\">\r\n\t\t\t\t\t\t");
              out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");
} else {

                  for (int i = 0; i < principals.size(); i++) {
                    String indParentCbxName = "indParent_" + i;
                    String hiddenPersonIdName = "principalPersonId_" + i;
                    String hiddenTsLastUpdateName = "principalLastUpdate_" + i;
                    String hiddenEventIdName = "initialMedicaidEventId_" + i;
                    PrincipalsList principal = (PrincipalsList) principals.get(i);
                
              out.write("\r\n\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss( i + 1 ));
              out.write("\" valign=\"top\">\r\n\t\t\t\t    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setType("hidden");
              _jspx_th_impact_validateInput_3.setName(hiddenPersonIdName);
              _jspx_th_impact_validateInput_3.setValue(String.valueOf(principal.getIdPerson()));
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setType("hidden");
              _jspx_th_impact_validateInput_4.setName(hiddenTsLastUpdateName);
              _jspx_th_impact_validateInput_4.setValue(String.valueOf(principal.getDtLastUpdateTime()));
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    \t\t\t\t\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("checkbox");
              _jspx_th_impact_validateInput_5.setChecked( ArchitectureConstants.Y.equals(principal.getIndParent()) ? "true" : "false" );
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setName( indParentCbxName );
              _jspx_th_impact_validateInput_5.setValue( String.valueOf( i ) );
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t<a href=\"javascript: submitPersonDetail( '");
              out.print(String.valueOf(principal.getIdPerson()));
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\"  onclick=\"setIsDirtyCalled(true)\">");
              out.print(principal.getNmPrincipals());
              out.write("</a>\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t");
  String value=principal.getIndPersonPaternityEst();
                        value=value.trim();

                        if(value != null && (value.compareTo("Y")==0))
                        {
                     
              out.write("\r\n                          <td align=\"center\" valign=\"middle\">\r\n                             <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n                          </td>\r\n                      ");
}
                        else{ 
              out.write("\r\n                          <td align=\"center\" valign=\"middle\">\r\n                          </td>\r\n                    ");
}
              out.write("\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(principal.getCdStagePersRelInt() != null ? Lookup.simpleDecodeSafe("CRELVICT", principal.getCdStagePersRelInt()) : "&nbsp;");
              out.write("\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(principal.getDob());
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(principal.getAddrPersonStLn1());
              out.write("\r\n\t\t\t\t\t\t<br>\r\n\t\t\t\t\t\t");
              out.print(principal.getAddrPersonCity());
              out.write("\r\n\t\t\t\t\t\t");
              out.print(principal.getCdPersonState());
              out.write("\r\n\t\t\t\t\t\t");
              out.print(principal.getAddrPersonZip());
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(principal.getNbrPersonIdNumber());
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(principal.getCdPersonMaritalStatus() != null ? Lookup.simpleDecodeSafe("CMARSTAT", principal.getCdPersonMaritalStatus()) : "&nbsp;");
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(principal.getRace());
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");
} // end for
      }

      
              out.write("\r\n\t\t\t</table>\r\n\t\t</div>\r\n\t\t");
/* this is where the "scrollBar" div tag ends */

      
              out.write('\r');
              out.write('\n');
              out.write('	');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
/* this is where the "xpandListTable" div tag ends end ESLT */

      
          out.write("\r\n\t<br>\r\n\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=6>\r\n\t\t\t\tMedicaid Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t");
 boolean isPregnant = "Yes".equals(medicaidApplicationRetrieveSO.getChildPregnancy());
		   if(isPregnant){
         
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td width=\"15%\">\r\n\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setId("rbLiveWithMinorParentYes");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setName("indChildPregnent");
          _jspx_th_impact_validateInput_6.setValue("true");
          _jspx_th_impact_validateInput_6.setLabel("Yes");
          _jspx_th_impact_validateInput_6.setChecked(String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildPregnancy() != null?  medicaidApplicationRetrieveSO.getIndChildPregnancy() : "")));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setId("rbLiveWithMinorParentNo");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setName("indChildPregnent");
          _jspx_th_impact_validateInput_7.setValue("false");
          _jspx_th_impact_validateInput_7.setLabel("No");
          _jspx_th_impact_validateInput_7.setChecked(String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndChildPregnancy() != null?  medicaidApplicationRetrieveSO.getIndChildPregnancy() : "")));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"5\">\r\n    \t\t\tIs the child's pregnancy verified and documented?\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtEstDeliveryDate");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setLabel("Est. Delivery Date");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtEstDeliveryDate()));
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\t\t");
}
          out.write("\r\n\t\t<tr class=\"even\">\r\n\t\t\t<td width=\"15%\">\r\n\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setId("rbIndSupportOrderYes");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setName("indChildSupportOrder");
          _jspx_th_impact_validateInput_8.setValue("true");
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setChecked(String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildSupportOrder() != null ? medicaidApplicationRetrieveSO.getIndChildSupportOrder() : "")));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setId("rbIndSupportOrderYes");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setName("indChildSupportOrder");
          _jspx_th_impact_validateInput_9.setValue("false");
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setChecked(String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndChildSupportOrder() != null ? medicaidApplicationRetrieveSO.getIndChildSupportOrder() : "" )));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t<span class=\"formRequiredText\">*</span> Has Child Support been ordered in the juvenile court?\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"even\">\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"15%\">\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"15%\">\r\n\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setId("rbIndMedicalAssistChildYes");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setName("indMedicalAssistChild");
          _jspx_th_impact_validateInput_10.setValue("true");
          _jspx_th_impact_validateInput_10.setLabel("Yes");
          _jspx_th_impact_validateInput_10.setChecked(String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndMedicalAsstChild() != null ? medicaidApplicationRetrieveSO.getIndMedicalAsstChild() : "")));
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setId("rbIndMedicalAssistChildNo");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setName("indMedicalAssistChild");
          _jspx_th_impact_validateInput_11.setValue("false");
          _jspx_th_impact_validateInput_11.setLabel("No");
          _jspx_th_impact_validateInput_11.setChecked(String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndMedicalAsstChild() != null ? medicaidApplicationRetrieveSO.getIndMedicalAsstChild() : "")));
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"3\">\r\n\t\t\t\t<span class=\"formRequiredText\">*</span> Was medical assistance needed for the child prior to removal? (If requesting prior months, please provide proof of medical services.\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("Months");
          _jspx_th_impact_validateInput_12.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_12.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_12.setColspan("8");
          _jspx_th_impact_validateInput_12.setName("txtMonths");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue(medicaidApplicationRetrieveSO.getTxtMonths() != null ? medicaidApplicationRetrieveSO.getTxtMonths(): "");
          _jspx_th_impact_validateInput_12.setSize("50");
          _jspx_th_impact_validateInput_12.setMaxLength("");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tIncome for Child\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tType\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tAmount\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tSource\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");
List incomeList = medicaidApplicationRetrieveSO.getIncomeResourceList();
                          if (incomeList == null || incomeList.size() == 0) {
                        
          out.write("\r\n\t\t\t\t          <tr class=\"odd\">\r\n\t\t\t\t\t        <td colspan=\"9\">\r\n\t\t\t\t\t\t       ");
          out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
          out.write("\r\n\t\t\t\t\t        </td>\r\n\t\t\t\t         </tr>\r\n\t\t\t\t        ");
} else {
                             for (int i = 0; i < incomeList.size(); i++) {
                               IncomeResourceMedicaidSI incomeResourceMedicaidSI = (IncomeResourceMedicaidSI) incomeList.get(i);
						       if((CodesTables.CINCORES_INC).equals(incomeResourceMedicaidSI.getCdIncRsrcIncome())){
						
          out.write("\r\n\t\t\t\t\t\t <tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<a href=\"javascript: submitPersonDetail( '");
          out.print(String.valueOf(medicaidApplicationRetrieveSO.getIdPerson()));
          out.write("')\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\"  onclick=\"setIsDirtyCalled(true)\">");
          out.print(medicaidApplicationRetrieveSO.getChildName() != null ? medicaidApplicationRetrieveSO.getChildName(): " " );
          out.write("</a>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print( incomeResourceMedicaidSI.getCdIncRsrcType() != null ? Lookup.simpleDecodeSafe(CodesTables.CINCRSRC, incomeResourceMedicaidSI.getCdIncRsrcType()): " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getAmtIncRsrc() != null? FormattingHelper.formatMoney(incomeResourceMedicaidSI.getAmtIncRsrc()) : " " );
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getSdsIncRsrcSource() != null ? incomeResourceMedicaidSI.getSdsIncRsrcSource() : " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t   ");
 }
					     } 
					    }
          out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tResource for Child\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tType\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tAmount\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tSource\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tVerification Method\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tInaccessible?\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");
List resourceList = medicaidApplicationRetrieveSO.getIncomeResourceList();
                          if (resourceList == null || resourceList.size() == 0) {
                        
          out.write("\r\n\t\t\t\t          <tr class=\"odd\">\r\n\t\t\t\t\t        <td colspan=\"9\">\r\n\t\t\t\t\t\t       ");
          out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
          out.write("\r\n\t\t\t\t\t        </td>\r\n\t\t\t\t         </tr>\r\n\t\t\t\t        ");
} else {
                             for (int i = 0; i < resourceList.size(); i++) {
                               IncomeResourceMedicaidSI incomeResourceMedicaidSI = (IncomeResourceMedicaidSI) resourceList.get(i);
						       if((CodesTables.CINCORES_RES).equals(incomeResourceMedicaidSI.getCdIncRsrcIncome())){
						
          out.write("\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<a href=\"javascript: submitPersonDetail( '");
          out.print(String.valueOf(medicaidApplicationRetrieveSO.getIdPerson()));
          out.write("')\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\"  onclick=\"setIsDirtyCalled(true)\">");
          out.print(medicaidApplicationRetrieveSO.getChildName() != null ?  medicaidApplicationRetrieveSO.getChildName(): " ");
          out.write("</a>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getCdIncRsrcType() != null ? Lookup.simpleDecodeSafe(CodesTables.CINCRSRC, incomeResourceMedicaidSI.getCdIncRsrcType()) : " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getAmtIncRsrc() != null? FormattingHelper.formatMoney(incomeResourceMedicaidSI.getAmtIncRsrc()): " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getSdsIncRsrcSource() != null ? incomeResourceMedicaidSI.getSdsIncRsrcSource() : " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getSdsIncRsrcVerfMethod() != null ? incomeResourceMedicaidSI.getSdsIncRsrcVerfMethod() : " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          out.print(incomeResourceMedicaidSI.getIndIncRsrcNotAccess() != null ? incomeResourceMedicaidSI.getIndIncRsrcNotAccess() : " ");
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");
 } 
						  }
						 }
          out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=6>\r\n\t\t\t\tChild's Health Insurance Coverage\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t");
String indChildCoverage = medicaidApplicationRetrieveSO.getIndChildCoverage();
	      noChecked = false;

          if (indChildCoverage == null) {
            noChecked = false;
          } else {
            noChecked = ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildCoverage())? false : true;
         }
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"15%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setId("rbChildCoverageYes");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setName("indChildCoverage");
          _jspx_th_impact_validateInput_13.setValue("true");
          _jspx_th_impact_validateInput_13.setLabel("Yes");
          _jspx_th_impact_validateInput_13.setChecked(String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndChildCoverage() != null ? medicaidApplicationRetrieveSO.getIndChildCoverage() : "")));
          _jspx_th_impact_validateInput_13.setOnClick("enablePage()");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setId("rbChildCoverageNo");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_14.setName("indChildCoverage");
          _jspx_th_impact_validateInput_14.setValue("false");
          _jspx_th_impact_validateInput_14.setLabel("No");
          _jspx_th_impact_validateInput_14.setChecked(String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndChildCoverage())));
          _jspx_th_impact_validateInput_14.setOnClick("disablePage()");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span> Is the child covered by any health insurance other than Medicaid?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=6>\r\n\t\t\t\tIf yes, please complete the following section:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"6\">\r\n\t\t\t\t<table width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"15%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setId("rbHealthYes");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setName("indChild");
          _jspx_th_impact_validateInput_15.setValue("true");
          _jspx_th_impact_validateInput_15.setLabel("Yes");
          _jspx_th_impact_validateInput_15.setChecked(String.valueOf(ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndHealthInsuranceCard())));
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setId("rbHealthNo");
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_16.setName("indChild");
          _jspx_th_impact_validateInput_16.setValue("false");
          _jspx_th_impact_validateInput_16.setLabel("No");
          _jspx_th_impact_validateInput_16.setChecked(String.valueOf(ArchitectureConstants.N.equals(medicaidApplicationRetrieveSO.getIndHealthInsuranceCard())));
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>&nbsp; Is a copy of health insurance card available?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setName("cdType");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CINSTYPE");
          _jspx_th_impact_validateSelect_0.setValue(medicaidApplicationRetrieveSO.getCdType());
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setLabel("Company Name");
          _jspx_th_impact_validateInput_17.setName("nmCompany");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getNmCompany()) ?  medicaidApplicationRetrieveSO.getNmCompany() : "");
          _jspx_th_impact_validateInput_17.setSize("30");
          _jspx_th_impact_validateInput_17.setMaxLength("50");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setLabel("Policy No.");
          _jspx_th_impact_validateInput_18.setName("nbrPolicy");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getNbrPolicy()) ? medicaidApplicationRetrieveSO.getNbrPolicy() : "");
          _jspx_th_impact_validateInput_18.setSize("20");
          _jspx_th_impact_validateInput_18.setMaxLength("20");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setLabel("Group No.");
          _jspx_th_impact_validateInput_19.setName("nbrGroup");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getNbrGroup()) ? medicaidApplicationRetrieveSO.getNbrGroup() : "");
          _jspx_th_impact_validateInput_19.setSize("20");
          _jspx_th_impact_validateInput_19.setMaxLength("20");
          _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setLabel("Street");
          _jspx_th_impact_validateInput_20.setConstraint("Address");
          _jspx_th_impact_validateInput_20.setName("addrStLn1");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrStreetLn1()) ? medicaidApplicationRetrieveSO.getAddrStreetLn1() : "");
          _jspx_th_impact_validateInput_20.setSize("30");
          _jspx_th_impact_validateInput_20.setMaxLength("");
          _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("text");
          _jspx_th_impact_validateInput_21.setLabel("");
          _jspx_th_impact_validateInput_21.setConstraint("Address");
          _jspx_th_impact_validateInput_21.setName("addrStLn2");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrStreetLn2()) ? medicaidApplicationRetrieveSO.getAddrStreetLn2() : "");
          _jspx_th_impact_validateInput_21.setSize("30");
          _jspx_th_impact_validateInput_21.setMaxLength("");
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setLabel("City");
          _jspx_th_impact_validateInput_22.setConstraint("City");
          _jspx_th_impact_validateInput_22.setName("addrCity");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrCity()) ? medicaidApplicationRetrieveSO.getAddrCity() : "");
          _jspx_th_impact_validateInput_22.setSize("20");
          _jspx_th_impact_validateInput_22.setMaxLength("");
          _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setName("addrState");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_1.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getAddrState()) ? medicaidApplicationRetrieveSO.getAddrState() : "");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setLabel("Zip");
          _jspx_th_impact_validateInput_23.setConstraint("Zip");
          _jspx_th_impact_validateInput_23.setName("addrZip");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setValue(StringHelper.isValid(healthZip) ? healthZip : "");
          _jspx_th_impact_validateInput_23.setSize("5");
          _jspx_th_impact_validateInput_23.setMaxLength("5");
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("text");
          _jspx_th_impact_validateInput_24.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_24.setName("addrZipSuff");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setValue(StringHelper.isValid(healthZipSuff) ? healthZipSuff : "");
          _jspx_th_impact_validateInput_24.setSize("4");
          _jspx_th_impact_validateInput_24.setMaxLength("4");
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("text");
          _jspx_th_impact_validateInput_25.setLabel("Phone");
          _jspx_th_impact_validateInput_25.setConstraint("Phone");
          _jspx_th_impact_validateInput_25.setName("nbrPhone");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getNbrPhone()) ? FormattingHelper.formatPhone(medicaidApplicationRetrieveSO.getNbrPhone()) : "");
          _jspx_th_impact_validateInput_25.setSize("12");
          _jspx_th_impact_validateInput_25.setMaxLength("");
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t    ");
 List principals1 = medicaidApplicationRetrieveSO.getAllPrincipalsBeanList();
	       List policyHolderNameList = new ArrayList();
	        if (principals1 == null || principals1.size() == 0) {
                 
          out.write("\r\n\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t<td colspan=\"9\">\r\n\t\t\t\t\t\t");
          out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t   ");
} else {
               for (int i = 0; i < principals1.size(); i++) {
                 PrincipalsList principal = (PrincipalsList) principals1.get(i);
                 policyHolderNameList.add(new Option(String.valueOf(principal.getNmPrincipals()), principal.getNmPrincipals()));
               }
           }
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Policy Holder");
          _jspx_th_impact_validateSelect_2.setName("nmPolicyHolder");
          _jspx_th_impact_validateSelect_2.setOptions(policyHolderNameList);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setValue(medicaidApplicationRetrieveSO.getNmPolicyHolder());
          _jspx_th_impact_validateSelect_2.setStyle("WIDTH: 180px");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("dtBegin");
          _jspx_th_impact_validateDate_2.setDisabled("false");
          _jspx_th_impact_validateDate_2.setLabel("Begin Date");
          _jspx_th_impact_validateDate_2.setRequired("false");
          _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtBegin()));
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("dtEnd");
          _jspx_th_impact_validateDate_3.setDisabled("false");
          _jspx_th_impact_validateDate_3.setLabel("End Date");
          _jspx_th_impact_validateDate_3.setRequired("false");
          _jspx_th_impact_validateDate_3.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtEnd()));
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("text");
          _jspx_th_impact_validateInput_26.setColspan("2");
          _jspx_th_impact_validateInput_26.setLabel("Employer's Name");
          _jspx_th_impact_validateInput_26.setName("nmEmployer");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getNmEmployer()) ? medicaidApplicationRetrieveSO.getNmEmployer() : "");
          _jspx_th_impact_validateInput_26.setSize("30");
          _jspx_th_impact_validateInput_26.setMaxLength("50");
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setColspan("2");
          _jspx_th_impact_validateInput_27.setType("text");
          _jspx_th_impact_validateInput_27.setLabel("Employee's Name");
          _jspx_th_impact_validateInput_27.setName("nmEmployeeName");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setValue(StringHelper.isValid(medicaidApplicationRetrieveSO.getNmEmployeeName()) ? medicaidApplicationRetrieveSO.getNmEmployeeName() : "" );
          _jspx_th_impact_validateInput_27.setSize("30");
          _jspx_th_impact_validateInput_27.setMaxLength("50");
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\t\t\tFinal/ICAMA\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setType("checkbox");
          _jspx_th_impact_validateInput_28.setName("indIcamaIcpc");
          _jspx_th_impact_validateInput_28.setChecked( ArchitectureConstants.Y.equals(medicaidApplicationRetrieveSO.getIndIcamaIcpc()) ? "true" : "false" );
          _jspx_th_impact_validateInput_28.setValue("Y");
          _jspx_th_impact_validateInput_28.setLabel("Child Receives Out of State Assistance");
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_28.setOnClick("toggleIcama()");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setColspan("1");
          _jspx_th_impact_validateSelect_3.setLabel("State");
          _jspx_th_impact_validateSelect_3.setName("cdIcamaState");
          _jspx_th_impact_validateSelect_3.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setValue( medicaidApplicationRetrieveSO.getCdIcamaState() );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td align=\"left\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setColspan("1");
          _jspx_th_impact_validateSelect_4.setLabel("Type of Assistance");
          _jspx_th_impact_validateSelect_4.setName("cdIcamaAsstType");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_4.setCodesTable("COSATYPE");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setValue( medicaidApplicationRetrieveSO.getCdIcamaAsstType() );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Adoption Type");
          _jspx_th_impact_validateSelect_5.setName("cdAdoptionType");
          _jspx_th_impact_validateSelect_5.setCodesTable("CAICTYPE");
          _jspx_th_impact_validateSelect_5.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setValue( medicaidApplicationRetrieveSO.getCdAdoptionType() );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t             ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setColspan("3");
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setName("txtIcamaComments");
          _jspx_th_impact_validateTextArea_1.setRows("5");
          _jspx_th_impact_validateTextArea_1.setCols("105");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setDisabled("false");
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t             \t");
              out.print( medicaidApplicationRetrieveSO.getTxtIcamaComments() != null ?  medicaidApplicationRetrieveSO.getTxtIcamaComments() : " " );
              out.write("\r\n\t\t\t             ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t             </td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\t\t\tCase Manager Signature\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\tIf you chose to use the GA SHINES system application to apply for Foster Care Medicaid you may submit the application using an electronic signature by clicking the \"Sign Now\" button below. By clicking the \"Sign Now\" button you are under penalty of\r\n\t\t\t\t\t\t\tperjury\" of law and accept responsibility for the information being submitted. If you chose to complete the system application, you will be able to review and check your answers at any point during the application process. At the end of the\r\n\t\t\t\t\t\t\tapplication process you will be able to Save and Submit the application to be assigned to a Medicaid Eligibility Specialist (MES) for Initial Medicaid Determination. If you want a copy of this Initial Application page for the case record, you may\r\n");
          out.write("\t\t\t\t\t\t\tprint this page for proof of this application. Clicking on the \"Sign Now\" button means that you accept responsibility for the correctness for all the information given on this application. Clicking on the \"Sign Now\" button allows the Medicaid\r\n\t\t\t\t\t\t\tEligibility Specialist to accept and finish working on this system application. If you do not click the \"Sign Now\" button, the MES will not be able to process this application. If you do not submit the system application within 48 hours, the\r\n\t\t\t\t\t\t\tApplicant will not receive proof of a current Medicaid Number in the Person Identifiers section of Persons Detail. The Medicaid Number will be listed as a Person Identifier in the GA SHINES system (Medicaid/MHN # or Temp Medicaid #).\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");
if(signNowPressed || (medicaidApplicationRetrieveSO.getDtSigned() != null )){
					  bDisabledSignNow = true;
					}
          out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("checkbox");
          _jspx_th_impact_validateInput_29.setId("indCaseManagerApply");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_29.setName("indCaseManagerApply");
          _jspx_th_impact_validateInput_29.setValue("true");
          _jspx_th_impact_validateInput_29.setLabel("I choose to apply for Medicaid benefits for the applicant (Foster Child). I choose to apply using the system application and authorize processing of this system application with my electronic signature.");
          _jspx_th_impact_validateInput_29.setChecked(String.valueOf(medicaidApplicationRetrieveSO.getIndCaseManagerApply()));
          _jspx_th_impact_validateInput_29.setDisabled(String.valueOf(bDisabledSignNow));
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");
if(medicaidApplicationRetrieveSO.getDtSigned() != null ){
          out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("nmCmSigned");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Case Manager's Name");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(medicaidApplicationRetrieveSO.getNmCaseManager());
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("dtCmSigned");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Date Signed");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue(FormattingHelper.formatDate(medicaidApplicationRetrieveSO.getDtSigned()));
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");
}
          out.write("\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSignNow");
          _jspx_th_impact_ButtonTag_2.setImg("btnSignNow");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmInitialMedicaid");
          _jspx_th_impact_ButtonTag_2.setAction("/fce/InitialMedicaid/signNowApplication");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setDisabled(String.valueOf(bDisabledSignNow));
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

     if (!((pageMode.equals(PageModeConstants.VIEW)) && (APPROVED_EVENT.equals(cdEventStatus))) &&
     	!((user.hasRight(UserProfile.SEC_ELIGIBILITY)) && (PENDING_EVENT.equals(cdEventStatus)))) {
    
          out.write("\r\n\t<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\" width=\"95%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setForm("frmInitialMedicaid");
          _jspx_th_impact_ButtonTag_3.setAction("/fce/InitialMedicaid/saveInitialMedicaid");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\" width=\"5%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSubmitApplicationFinal");
          _jspx_th_impact_ButtonTag_4.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_4.setForm("frmInitialMedicaid");
          _jspx_th_impact_ButtonTag_4.setAction("/fce/InitialMedicaid/saveAndSubmitApplication");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
 } 
          out.write("\r\n\t<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nexpandCollapsed('expandedPrincipalsList', 'collapsedPrincipalsList');\r\n</script>\r\n");
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
