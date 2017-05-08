package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.person.DiligentSearchCustomValidation;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public final class DiligentSearchInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*-----------------------------------------------------------------------------
      //*  JSP Name:     Diligent Search Info
      //*  Created by:   Anand Kundrapu
      //*  Date Created: 
      //*
      //*  Description:
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  12/08/08  alwilliams        STGAP00010603 - Changed the "Was the person successfully 
      //**                              contacted?" field to a required field. 

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  //*********************
  //*** SET PAGE MODE ***
  //*********************   
   
  String pageMode = PageModeConstants.EDIT;
  if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
  }


 //*******************************
 //*** DECLARE LOCAL VARIABLES ***
 //*******************************
      
  int tabIndex = 1;
  List<DiligentSearchInfoList> dsilist = new ArrayList<DiligentSearchInfoList>();
  String EMPTY_STRING = "";
  String indIncludDilSrch = StringHelper.EMPTY_STRING;
  String indCaretakerPriorRemoval = StringHelper.EMPTY_STRING;
  String caretakerCmnts = EMPTY_STRING;
  String referralType = EMPTY_STRING;
  String otherDesc = EMPTY_STRING;
  String referrerName = EMPTY_STRING;
  String indSuccCont = EMPTY_STRING;
  String notContactedCmmnts = EMPTY_STRING;
  String currOutcomeContact = EMPTY_STRING;
  String indVisitationRsrc = EMPTY_STRING;
  String indPlcmtRsrc = EMPTY_STRING;
  String plcmtRsrcCmmnts = EMPTY_STRING;
  String dtRelCareSubDisc = EMPTY_STRING;
  String comments = EMPTY_STRING;
  String personName = EMPTY_STRING;
  String personId = EMPTY_STRING;
  String contactPerson = EMPTY_STRING;
  String succCont_No = "false";
  String succCont_Yes = "false";
  String plcmtRsrc_No = "false";
  String plcmtRsrc_Yes = "false";
  String visitationRsrc_No = "false";
  String visitationRsrc_Yes = "false";
  String isAdd = EMPTY_STRING;
  int arrayIndex = ContextHelper.getIntSafe(request, "diligentSearchIndex");
  
  
 //***********************************
 //*** RETRIEVE HIDDEN STATE FIELD ***
 //***********************************
 
 BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
 
                                                                     
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************   
  
       
   DiligentSearchInfoRetrieveSO dsiretso = (DiligentSearchInfoRetrieveSO) state.getAttribute("DiligentSearchInfoRetrieveSO", request);
   
 //personName = GlobalData.getSzNmPersonFull(request);
 //personName = (String)state.getAttribute("NM_CHILD", request);
 if(dsiretso!=null)
 {
    contactPerson = dsiretso.getNamePersonDetail();
    if(dsiretso.getNamePersonDetail() == null)
    {
      contactPerson = dsiretso.getPersonNameForPullback();
    }
 }
 personName = contactPerson;
 if(dsiretso.getDsiBeanList()!=null)
 {
   dsilist = dsiretso.getDsiBeanList();
    for (Iterator<DiligentSearchInfoList> it = dsilist.iterator(); it.hasNext();) {
           DiligentSearchInfoList dsiRow = (DiligentSearchInfoList) it.next();
           indIncludDilSrch = dsiRow.getIndIncludeDilSrch();
           indCaretakerPriorRemoval = dsiRow.getIndCaretakerPriorRemoval();
           caretakerCmnts = dsiRow.getTxtRemCmnts();
           referralType = dsiRow.getSelReferralType();
           otherDesc = dsiRow.getTxtOtherDesc();
           referrerName = dsiRow.getTxtReferrsNm();
           indSuccCont = dsiRow.getIndSuccContacted();
           if (indSuccCont != null)
             {
               if (indSuccCont.equals(ArchitectureConstants.N)) {
                succCont_No = "true";
                } else {
                succCont_Yes = "true";
              }
           }  
           notContactedCmmnts = dsiRow.getTxtNotContactedCmnts();
           currOutcomeContact = dsiRow.getSelCurrOutcomeContact();
           indVisitationRsrc = dsiRow.getIndVisitationRsrc();
           if (indVisitationRsrc != null)
             {
               if (indVisitationRsrc.equals(ArchitectureConstants.N)) {
                visitationRsrc_No = "true";
                } else {
                visitationRsrc_Yes = "true";
              }
           }  
           indPlcmtRsrc = dsiRow.getIndPlcmtRsrc();
           if (indPlcmtRsrc != null)
             {
               if (indPlcmtRsrc.equals(ArchitectureConstants.N)) {
                 plcmtRsrc_No = "true";
                } else {
                 plcmtRsrc_Yes = "true";
              }
           }  
           plcmtRsrcCmmnts = dsiRow.getTxtPlcmtRsrcCmnts();
           dtRelCareSubDisc = FormattingHelper.formatDate(dsiRow.getDtRelCareSubDisc());
           comments = dsiRow.getTxtCmnts();
          }
     }       
  
                 

      out.write("\r\n\r\n");
    //**************************
      //**** FORM STARTS HERE ****
      //**************************

 
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmDiligentSearchInfo");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/DiligentSearch/saveDiligentSearchInfo");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.DiligentSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("isAddDiligentSearch");
          _jspx_th_impact_validateInput_0.setValue( isAdd );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("diligentSearchInfoIndex");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(arrayIndex) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"hdnPersonNm\" value=\"");
          out.print(personName);
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnPersonIdForPullback\" value=\"");
          out.print(personId);
          out.write("\">\r\n\r\n\r\n  <table width=\"100%\" class=\"tableborder\" cellpadding=\"3\" cellspacing=\"0\">\r\n    <tr>\r\n      <th colspan=\"8\">\r\n        Diligent Search\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"0\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtContactPerson");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Contact Person");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( contactPerson );
          _jspx_th_impact_validateDisplayOnlyField_0.setCssClass("formInput");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setChecked(FormattingHelper.formatString(indIncludDilSrch));
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setName("cbIncludDilSrch");
          _jspx_th_impact_validateInput_2.setLabel("Include in Diligent Search Report");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setChecked(FormattingHelper.formatString(indCaretakerPriorRemoval));
          _jspx_th_impact_validateInput_3.setValue("Y");
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setName("cbCaretakerPriorRemoval");
          _jspx_th_impact_validateInput_3.setLabel("Caretaker Prior to Removal");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>If previous caretaker, describe why removed:\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_0.setLabel("");
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setName("txtCaretakerCmnts");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(caretakerCmnts));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setLabel("Referral Type");
          _jspx_th_impact_validateSelect_0.setId("szCdReferralType");
          _jspx_th_impact_validateSelect_0.setName("selReferralType");
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue(referralType );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CDSIREFL");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>If other, describe:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("");
          _jspx_th_impact_validateInput_4.setId("szCdOtherDesc");
          _jspx_th_impact_validateInput_4.setName("txtOtherDesc");
          _jspx_th_impact_validateInput_4.setSize("20");
          _jspx_th_impact_validateInput_4.setMaxLength("50");
          _jspx_th_impact_validateInput_4.setConstraint("Paragraph50");
          _jspx_th_impact_validateInput_4.setValue(otherDesc);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Referrer's Name");
          _jspx_th_impact_validateInput_5.setId("szCdReferrsNm");
          _jspx_th_impact_validateInput_5.setName("txtReferrsNm");
          _jspx_th_impact_validateInput_5.setSize("20");
          _jspx_th_impact_validateInput_5.setMaxLength("50");
          _jspx_th_impact_validateInput_5.setConstraint("Paragraph50");
          _jspx_th_impact_validateInput_5.setValue(referrerName );
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        <span class=\"formRequiredText\">*</span> Was the person successfully contacted?\r\n      </td>\r\n\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setChecked(succCont_Yes);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setValue("Y");
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setName("rbSuccContacted");
          _jspx_th_impact_validateInput_6.setId("succCont_Yes");
          _jspx_th_impact_validateInput_6.setLabel("Yes");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setChecked(succCont_No);
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setValue("N");
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setName("rbSuccContacted");
          _jspx_th_impact_validateInput_7.setId("succCont_No");
          _jspx_th_impact_validateInput_7.setLabel("No");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>If not contacted, why?\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setCols("80");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_1.setLabel("");
          _jspx_th_impact_validateTextArea_1.setName("txtNotContactedCmnts");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(notContactedCmmnts));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>Current Outcome of Contact:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setLabel("");
          _jspx_th_impact_validateSelect_1.setId("szCdCurrOutcomeContact");
          _jspx_th_impact_validateSelect_1.setName("selCurrOutcomeContact");
          _jspx_th_impact_validateSelect_1.setWidth("20%");
          _jspx_th_impact_validateSelect_1.setValue(currOutcomeContact);
          _jspx_th_impact_validateSelect_1.setCodesTable("CDSICONT");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>Is person willing to be a visitation resource?\r\n      </td>\r\n\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setChecked(visitationRsrc_Yes );
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setValue("Y");
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setName("rbVisitationRsrc");
          _jspx_th_impact_validateInput_8.setId("visitationRsrc_Yes");
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setChecked(visitationRsrc_No );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setValue("N");
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setName("rbVisitationRsrc");
          _jspx_th_impact_validateInput_9.setId("visitationRsrc_No");
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>Is the person a potential placement resource?\r\n      </td>\r\n\r\n\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setChecked(plcmtRsrc_Yes);
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setValue("Y");
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setName("rbPlcmtRsrc");
          _jspx_th_impact_validateInput_10.setId("plcmtRsrc_Yes");
          _jspx_th_impact_validateInput_10.setLabel("Yes");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setChecked( plcmtRsrc_No );
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setValue("N");
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setName("rbPlcmtRsrc");
          _jspx_th_impact_validateInput_11.setId("plcmtRsrc_No");
          _jspx_th_impact_validateInput_11.setLabel("No");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>If not, why?\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setCols("80");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_2.setLabel("");
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_2.setName("txtPlcmtRsrcCmnts");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(plcmtRsrcCmmnts));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>Date Relative Care Subsidies Discussed:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("dtRelCareSubDisc");
          _jspx_th_impact_validateDate_0.setLabel("");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue( dtRelCareSubDisc );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        Comments:\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_3.setCols("80");
          _jspx_th_impact_validateTextArea_3.setRows("4");
          _jspx_th_impact_validateTextArea_3.setMaxLength(300);
          _jspx_th_impact_validateTextArea_3.setLabel("");
          _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_3.setName("txtComments");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(comments));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  ");
//*****************
      //**** BUTTONS ****
      //*****************
      // Display the Save button unless the page mode is VIEW. 
      if (!pageMode.equals(PageModeConstants.VIEW)) {
          out.write("\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmDiligentSearchInfo");
          _jspx_th_impact_ButtonTag_0.setAction("/person/DiligentSearch/saveDiligentSearchInfo");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
