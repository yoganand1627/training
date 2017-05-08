package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;

public final class FosterCareParticipant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      //*  JSP Name:     Foster Care Participant
      //*  Created by:   Steven Thrasher
      //*  Date Created: 1/31/07
      //*
      //*  Description:
      //*  This JSP displays the Foster Care Participant details.
      //*
      //*  Change History:
      //*  Date      User              Description
      //*  --------  ----------------  --------------------------------------------------
      //*  1/31/07  Steven Thrasher    Initial page development
      //* 11/24/08  charden	           STGAP00007572 - wrote code for page to reload when participant type is changed
      //* 01/07/09  mxpatel            STGAP00007572 - edited code not to show the popup message if the participant type changes
      //*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      //*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      FosterCarePartBean fcBeanRetrieve = null;
      int tabIndex = 1;
      String pageMode = PageMode.getPageMode(request);
      String apprvYes = ArchitectureConstants.FALSE;
      String apprvNo = ArchitectureConstants.FALSE;
      String txtApprvDt = FormattingHelper.formatString("");
      String txtPersonNotApprv = FormattingHelper.formatString("");
      String txtPartDt = FormattingHelper.formatString("");
      String txtSignedCpyDt = FormattingHelper.formatString("");
      String txtRelationshipInterest = FormattingHelper.formatString("");
      String txtParticipantName = FormattingHelper.formatString("");
      String selParticipantType = FormattingHelper.formatString("");
      String hdnPersonId = FormattingHelper.formatString("");
      String participantId = "";
      String radioDisable = ArchitectureConstants.FALSE;
      String hdnPlanPart = "";
      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      fcBeanRetrieve = (FosterCarePartBean) state.getAttribute("participant", request);
      String hdnIdEvent = String.valueOf(GlobalData.getUlIdEvent(request));
      String includingFormName = (String) request.getAttribute("includingFormName");

      if (fcBeanRetrieve != null) {
        if (ArchitectureConstants.Y.equals(fcBeanRetrieve.getIndApproval())) {
          apprvYes = ArchitectureConstants.TRUE;
          apprvNo = ArchitectureConstants.FALSE;
        } else if (ArchitectureConstants.N.equals(fcBeanRetrieve.getIndApproval())) {
          apprvNo = ArchitectureConstants.TRUE;
          apprvYes = ArchitectureConstants.FALSE;
        }
        if (fcBeanRetrieve.getIdPlanPart() != 0) {
          hdnPlanPart = FormattingHelper.formatInt(fcBeanRetrieve.getIdPlanPart());
        }
        participantId = FormattingHelper.formatInt(fcBeanRetrieve.getIdPlanPart());
        txtApprvDt = FormattingHelper.formatDate(fcBeanRetrieve.getDtApprv());
        txtPersonNotApprv = fcBeanRetrieve.getTxtNoApprv();
        txtPartDt = FormattingHelper.formatDate(fcBeanRetrieve.getDtPart());
        txtSignedCpyDt = FormattingHelper.formatDate(fcBeanRetrieve.getDtSigned());
        txtRelationshipInterest = fcBeanRetrieve.getSzCdRelInt();
        txtParticipantName = fcBeanRetrieve.getSzNmPart();
        selParticipantType = fcBeanRetrieve.getSzCdPartType();
        hdnPersonId = FormattingHelper.formatInt(fcBeanRetrieve.getIdPerson());
      }

      if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.EDIT.equals(pageMode)) {
        radioDisable = ArchitectureConstants.FALSE;
      } else if (PageModeConstants.VIEW.equals(pageMode)) {
        radioDisable = ArchitectureConstants.TRUE;
      }
      //******************
      //*** JAVASCRIPT ***
      //******************

      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nvar skipReload = false;\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\nif(!skipReload){\r\n  IsDirty();\r\n  }\r\n};\r\n\r\nfunction reloadWithoutDirty(){\r\nskipReload = true;\r\nreloadFCParticipant();\r\n}\r\n\r\nfunction reloadFCParticipant()\r\n{\r\n  disableValidation('frmFosterCareParticipant');\r\n  setState('frmFosterCareParticipant');\r\n  setValidationUrl('frmFosterCareParticipant','/casemgmt/FosterCareParticipant/reloadFCParticipant');\r\n  document.frmFosterCareParticipant.submit();\r\n}\r\n\r\nfunction confirmDelete()\r\n{\r\n  return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n}\r\n</script>\r\n\r\n");
//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

//****************************************************
//**** FORM (Foster Care Participant) STARTS HERE ****
//****************************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFosterCareParticipant");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/casemgmt/FosterCareParticipant/displayFosterCareParticipant");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FosterCareParticipantCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        \r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("includingFormName");
          _jspx_th_impact_validateInput_0.setValue(includingFormName);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

// The user must begin by selecting a Participant Type.
if ("".equals(selParticipantType) )
{
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr><th colspan=\"2\">Foster Care Participant Detail</th></tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Participant Type");
          _jspx_th_impact_validateSelect_0.setName("selParticipantType");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CPARTYPE );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue("");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td width=\"50%\">&nbsp;</td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmFosterCareParticipant");
          _jspx_th_impact_ButtonTag_0.setAction("/casemgmt/FosterCareParticipant/reloadFCParticipant");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}
else
{
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIdEvent");
          _jspx_th_impact_validateInput_1.setValue( hdnIdEvent );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnPersonId");
          _jspx_th_impact_validateInput_2.setValue( hdnPersonId );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnPlanPart");
          _jspx_th_impact_validateInput_3.setValue( hdnPlanPart );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n           <th colspan=\"4\">Foster Care Participant Detail</th>\r\n          </tr>\r\n          <tr>\r\n            ");

            //------------------------
            //--- Participant Type ---
            //------------------------
            // Once the participant record has been saved to the database,
            // the Participant Type cannot be changed.
            if ("".equals(participantId) )
            {
          out.write("\r\n              <td width=\"20%\">\r\n                ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Participant Type");
          _jspx_th_impact_validateSelect_1.setName("selParticipantType");
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CPARTYPE );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( selParticipantType );
          _jspx_th_impact_validateSelect_1.setOnChange("reloadWithoutDirty()");
          _jspx_th_impact_validateSelect_1.setColspan("3");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td width=\"20%\">\r\n                ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Participant Type");
          _jspx_th_impact_validateSelect_2.setName("selParticipantType");
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CPARTYPE );
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setValue( selParticipantType );
          _jspx_th_impact_validateSelect_2.setDisabled("true");
          _jspx_th_impact_validateSelect_2.setColspan("3");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            
          out.write("\r\n          </tr>\r\n          <tr>\r\n            ");

            //------------------------
            //--- Participant Name ---
            //------------------------
            // If the Participant Type is "Person in Case" or "Staff", the
            // Participant Name field can only be modified by performing a
            // Person Search or Staff Search, accordingly.
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
                 selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Name");
          _jspx_th_impact_validateInput_4.setName("txtParticipantName");
          _jspx_th_impact_validateInput_4.setValue( txtParticipantName );
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setReadOnly("true");
          _jspx_th_impact_validateInput_4.setWidth("25%");
          _jspx_th_impact_validateInput_4.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Name");
          _jspx_th_impact_validateInput_5.setName("txtParticipantName");
          _jspx_th_impact_validateInput_5.setValue( txtParticipantName );
          _jspx_th_impact_validateInput_5.setRequired("true");
          _jspx_th_impact_validateInput_5.setMaxLength("25");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            
          out.write("\r\n\r\n            ");

            //---------------------------
            //--- Person/Staff Button ---
            //---------------------------
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) )
            {
          out.write("\r\n              <td colspan=\"2\">\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnPerson");
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setForm("frmFosterCareParticipant");
          _jspx_th_impact_ButtonTag_1.setAction("/casemgmt/FosterCareParticipant/performPersonListPullback");
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmFosterCareParticipant')");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else if ( selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
             
          out.write("\r\n              <td colspan=\"2\">\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnStaff");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmFosterCareParticipant");
          _jspx_th_impact_ButtonTag_2.setAction("/casemgmt/FosterCareParticipant/performStaffSearch");
          _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmFosterCareParticipant')");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td colspan=\"2\">&nbsp;</td>\r\n            ");

            }
            
          out.write("\r\n          </tr>\r\n            ");

            //-----------------------------
            //--- Relationship/Interest ---
            //-----------------------------
            // If the Participant Type is "Person in Case" or "Staff", the
            // Relationship/Interest field can only be modified by performing
            // a Person Search or Staff Search, accordingly.
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
                 selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
          out.write("\r\n            <tr>\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Relationship/Interest");
          _jspx_th_impact_validateInput_6.setName("txtRelationshipInterest");
          _jspx_th_impact_validateInput_6.setMaxLength("20");
          _jspx_th_impact_validateInput_6.setValue( txtRelationshipInterest );
          _jspx_th_impact_validateInput_6.setRequired("true");
          _jspx_th_impact_validateInput_6.setReadOnly("true");
          _jspx_th_impact_validateInput_6.setCssClass("readonly");
          _jspx_th_impact_validateInput_6.setColspan("3");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            ");

            }
            else
            {
          out.write("\r\n            <tr>\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Relationship/Interest");
          _jspx_th_impact_validateInput_7.setName("txtRelationshipInterest");
          _jspx_th_impact_validateInput_7.setMaxLength("20");
          _jspx_th_impact_validateInput_7.setValue( txtRelationshipInterest );
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setColspan("3");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            ");

            }
            
          out.write("\r\n          <tr>\r\n      <td>\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Signed Copy of Receipt");
          _jspx_th_impact_validateDate_0.setName("txtSignedCpyDt");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( txtSignedCpyDt );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n    </tr>\r\n    <tr>\r\n          <td>\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Participation Date");
          _jspx_th_impact_validateDate_1.setName("txtPartDt");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( txtPartDt );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n    </tr>\r\n    <tr>\r\n          <td>Person Approves: </td>\r\n            <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setDisabled( radioDisable );
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setId("Yes");
          _jspx_th_impact_validateInput_8.setName("scrIndPrsnApprv");
          _jspx_th_impact_validateInput_8.setValue("Y");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setChecked( apprvYes );
          _jspx_th_impact_validateInput_8.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setDisabled( radioDisable );
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setId("No");
          _jspx_th_impact_validateInput_9.setName("scrIndPrsnApprv");
          _jspx_th_impact_validateInput_9.setValue("N");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setChecked( apprvNo );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n           <td>\r\n           ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Date of Approval");
          _jspx_th_impact_validateDate_2.setName("txtApprvDt");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setValue( txtApprvDt );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n  </tr>\r\n  <tr>\r\n  \t<td colspan=\"2\">\r\n  \t If person does not approve, please explain why:\r\n  \t</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"4\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtPersonNotApprv");
          _jspx_th_impact_validateTextArea_0.setCols("90");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setColspan("4");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print( FormattingHelper.formatString(txtPersonNotApprv));
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n  </tr>\r\n </table>\r\n\r\n  ");

  //*****************
  //**** BUTTONS ****
  //*****************
  
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      ");

      if ( !("".equals(participantId) ))
      {
          out.write("\r\n        <td>\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnDelete");
          _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_3.setAlign("left");
          _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_3.setForm("frmFosterCareParticipant");
          _jspx_th_impact_ButtonTag_3.setAction("/casemgmt/FosterCareParticipant/deleteFCParticipant");
          _jspx_th_impact_ButtonTag_3.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      ");

      }
      
          out.write("\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmFosterCareParticipant");
          _jspx_th_impact_ButtonTag_4.setAction("/casemgmt/FosterCareParticipant/saveFCParticipant");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}

          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
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
