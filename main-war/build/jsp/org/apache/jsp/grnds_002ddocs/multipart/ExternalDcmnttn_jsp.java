package org.apache.jsp.grnds_002ddocs.multipart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV23SI01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import java.util.Enumeration;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public final class ExternalDcmnttn_jsp extends org.apache.jasper.runtime.HttpJspBase
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


  //*  JSP Name:     Allegation List
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 11/19/02
//*
//*  Description:
//*   Displays a listing of all allegations for a given stage.
//*   Also calculates overall roles and the stage's overall
//*   disposition if all allegations in the stage have been
//*   addressed.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  03/25/03  Todd Reser        QA Sweep.
  04/16/03  Todd Reser        Added Confirm Delete fuction, removed unused code.
  04/30/03  Todd Reser        Changed Confirm Delete message, added rbSelected
                              to determine if a rb was selected.
  05/29/03  Todd Reser        Added emailMessage parameter to report.
  10/03/03  CORLEYAN          SIR 19951 This page should always be in modify mode regardless
                              of the app mode
  09/12/05  PISHARRK          SIR 23953 - Starting MPS Phase III enhancement to display 
                              Ext. Doc List/Details using EJB/DAO service(replacing existing DAMs) 
                              for both MPS and IMPACT
  09/23/05  cooganpj          SIR 23966 - MPS Phase III Lockdown changes - updated to read in the page
                              mode from the conversation.
  09/10/09  ssubram           STGAP00015066: Added Search Capability and additional validation     
  09/15/09  ssubram           STGAP00015066: Sort Functionality has been added. Note: In order to make
  							  the SortableColumnHeader to work, USE a separate form from the search one.
  11/05/09  pcoogan           SMS 39107: Added sort key for document class		
  11/22/09  pcoogan           SMS 40847: Removed unncessary radio button index causing delete to fail.
  01/30/12	vcollooru		  STGAP00017827 MR-085 Modified to add new checkbox in search criteria for filtering the results for ICPC Document.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);

  int tabIndex = 1;
  int extDocCount = 0;
  // PAGE MODE LOGIC BEGIN
  String pageMode = PageModeConstants.VIEW;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }

      out.write("\r\n\r\n");

  String modifyDisabled = "false";
  CINV23SO ExtDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
  ROWCINV23SOG00_ARRAY ExtDocArray = new ROWCINV23SOG00_ARRAY();
  if (ExtDocList == null) {
    ExtDocList = new CINV23SO();
  }
  if (ExtDocList.getROWCINV23SOG00_ARRAY() != null) {
    ExtDocArray = ExtDocList.getROWCINV23SOG00_ARRAY();
  }
  Enumeration ExtDocEnum = ExtDocArray.enumerateROWCINV23SOG00();

  ROWCINV23SOG00 ExtDocDetail = (ROWCINV23SOG00) request.getAttribute("ExtDocDetail");
  boolean bDeleteButton;
  boolean bAddButton;
  if (pageMode.equals(PageModeConstants.VIEW)) {
    bDeleteButton = true;
    bAddButton = true;
  } else {
    bDeleteButton = false;
    bAddButton = false;
  }
  //Get Stage Closed Ind and Stage Closed Date
  boolean stageClosed = (Boolean)state.getAttribute("stageClosed", request);
  Date stageClosureDate = (Date)state.getAttribute("stageClosureDate", request);
  //Disabling Radio button for External Documents added prior to the stage closure.
  Date weekAfterStageClosed = null;
 
  if (stageClosed){
     bDeleteButton = true;
  }
  //Redisplay the search criteria while sorting
  CINV23SI cinv23si = (CINV23SI) state.getAttribute("CINV23SI", request);
  List<String> checkedAdoList = new ArrayList<String>();
  List<String> checkedCaseDataList = new ArrayList<String>();
  List<String> checkedCrtLegalList = new ArrayList<String>();
  List<String> checkedFstAdoHmList = new ArrayList<String>();
  List<String> checkedHlthList = new ArrayList<String>();
  List<String> checkedPrsnList = new ArrayList<String>();
  List<String> checkedOthList = new ArrayList<String>();
  String dtScrSearchDateFrom = "";
  String dtScrSearchDateTo = "";
  String txtSzCdExtDocSort = "";
  String txtSzTxtExtDocLocation = "";
  String cbxICPCDocument = "";
  //Check if the sort button is pressed so that the search parameters will be filled from state SI object
  if (cinv23si != null && ArchitectureConstants.Y.equals(cinv23si.getBIndSort())){
    dtScrSearchDateFrom = FormattingHelper.formatDate(cinv23si.getDtScrSearchDateFrom());
    dtScrSearchDateTo = FormattingHelper.formatDate(cinv23si.getDtScrSearchDateTo());
    txtSzCdExtDocSort = cinv23si.getSzCdExtDocSort();
    cbxICPCDocument = cinv23si.getBIndICPCDoc();
    txtSzTxtExtDocLocation = cinv23si.getSzTxtExtDocLocation();
    ROWCINV23SI01_ARRAY rowCinv23si01Array = cinv23si.getROWCINV23SI01_ARRAY();
    for (int i=0; i < rowCinv23si01Array.getUlRowQty(); i++){
	   	ROWCINV23SI01 rowCinv23si01 = rowCinv23si01Array.getROWCINV23SI01(i);
	   	if(CodesTables.CEXDOCLA_AI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedAdoList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_CD.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedCaseDataList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_CI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedCrtLegalList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_FA.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedFstAdoHmList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_HI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedHlthList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_PI.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedPrsnList.add(rowCinv23si01.getSzCdExtDocType());
	   	}else if(CodesTables.CEXDOCLA_XX.equals(rowCinv23si01.getSzCdDocClass())){
	   		checkedOthList.add(rowCinv23si01.getSzCdExtDocType());
	   	}
    }
  }else {
	  //Declare Constants and initialize Page Variables
	  int loopCount = 0;
	  int ulIdStage = GlobalData.getUlIdStage( request );
	  dtScrSearchDateFrom = FormattingHelper.formatDate(
	          ContextHelper.getCastorDateSafe( request, "dtScrSearchDateFrom" ) );
	  dtScrSearchDateTo = FormattingHelper.formatDate(
	          ContextHelper.getCastorDateSafe( request, "dtScrSearchDateTo" ) );
	  txtSzCdExtDocSort = ContextHelper.getStringSafe( request, "txtSzCdExtDocSortInList" );
	  checkedAdoList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxAdoInfo"));
	  checkedCaseDataList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxCaseData"));
	  checkedCrtLegalList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxCrtLegalInfo"));
	  checkedFstAdoHmList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxFstAdoHmInfo"));
	  checkedHlthList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxHlthInfo"));
	  checkedPrsnList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxPrsnInfo"));
	  checkedOthList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxOth")); 
	  txtSzTxtExtDocLocation = ContextHelper.getStringSafe( request, "txtSzTxtExtDocLocation" );
	  cbxICPCDocument =  CheckboxHelper.getCheckboxValue( request, "cbxICPCDocument" );
  }

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  rbSelected = new Boolean(false);\r\n\r\n  function displayExtDocDetail(idExtDoc) {\r\n    document.frmExtDocListResults.hdnUlIdExtDoc.value = idExtDoc;\r\n    submitValidateForm(\"frmExtDocListResults\", \"/multipart/ExternalDcmnttn/displayExtDocDetail\");\r\n  }\r\n\r\n  function confirmDelete() {\r\n    if (rbSelected) {\r\n      //disableValidation(\"frmExtDocList\");\r\n      //submitValidateForm(\"frmExtDocList\", \"/multipart/ExternalDcmnttn/saveExtDocDetail\");\r\n      return confirm(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\")\r\n    } else {\r\n      //return true so CustomValidation can handle that a row wasn't selected\r\n      return true;\r\n    }\r\n  }\r\n  function checkAll(field)\r\n  {\r\n    for (i = 0; i < field.length; i++)\r\n\t  field[i].checked = true ;\r\n  }\r\n\r\n  function uncheckAll(field)\r\n  {\r\n    for (i = 0; i < field.length; i++)\r\n\t  field[i].checked = false ;\r\n  }\r\n  \r\n  checked=false;\r\n  function checkedAll (FieldName) {\r\n\tvar index = 1;\r\n\tvar objCheckBoxes = document.getElementsByName(FieldName + index++);\r\n\t if (checked == false)\r\n          {\r\n           checked = true\r\n          }\r\n        else\r\n          {\r\n          checked = false\r\n          }\r\n\twhile (objCheckBoxes.length > 0) {\r\n\t\tobjCheckBoxes[0].checked = checked;\r\n\t\tobjCheckBoxes = document.getElementsByName(FieldName + index++);\r\n\t}\r\n  }\r\n\r\n  function SetAllCheckBoxes(FieldName, CheckValue)\r\n  {\r\n\tvar inputElements=document.getElementsByTagName(\"input\");\r\n    for(var i = 0, inp; inp = inputElements[i]; i++){\r\n      if(inp.type.toLowerCase() == 'checkbox' && inp.name.indexOf(FieldName) == 0){\r\n");
      out.write("         inp.checked = CheckValue;\r\n      }\r\n    }\r\n  }\r\n  \r\n  function stayHere() {\r\n\r\n  var vertScroll = document.body.scrollTop\r\n  document.body.scrollTop = vertScroll;\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExtDocList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/multipart/ExternalDcmnttn/saveExtDocDetail");
      _jspx_th_impact_validateForm_0.setPageMode(PageMode.getPageMode(request));
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <!-- Hidden Fields -->\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("ExtDocSearch");
          _jspx_th_impact_ExpandableSectionTag_0.setId("ctSearchOpen");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("External Documentation Search");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr class=\"subDetail\">\r\n    <th colspan=\"4\">Search Parameters</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td class=\"formlabel\">\r\n      ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setLabel("Date From");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setName("dtScrSearchDateFrom");
              _jspx_th_impact_validateDate_0.setDisabled("false");
              _jspx_th_impact_validateDate_0.setValue( dtScrSearchDateFrom );
              _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_0.setSize("8");
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_0.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td class=\"formlabel\">\r\n      ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_1.setLabel("Date To");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setName("dtScrSearchDateTo");
              _jspx_th_impact_validateDate_1.setDisabled("false");
              _jspx_th_impact_validateDate_1.setValue( dtScrSearchDateTo );
              _jspx_th_impact_validateDate_1.setSize("8");
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_1.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td class=\"formlabel\">\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_2.setName("txtSzCdExtDocSortInList");
              _jspx_th_impact_validateInput_2.setLabel("Sort Order");
              _jspx_th_impact_validateInput_2.setValue( txtSzCdExtDocSort );
              _jspx_th_impact_validateInput_2.setType("text");
              _jspx_th_impact_validateInput_2.setCssClass("formInput");
              _jspx_th_impact_validateInput_2.setSize("2");
              _jspx_th_impact_validateInput_2.setMaxLength("2");
              _jspx_th_impact_validateInput_2.setConstraint("AlphaNumeric2");
              _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
              if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td></td>\r\n    <td></td>    \r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td class=\"formlabel\">\r\n      ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_0.setName("txtSzTxtExtDocLocation");
              _jspx_th_impact_validateSelect_0.setLabel("Item Location");
              _jspx_th_impact_validateSelect_0.setValue(txtSzTxtExtDocLocation );
              _jspx_th_impact_validateSelect_0.setCodesTable("CITEMLOC");
              _jspx_th_impact_validateSelect_0.setDisabled("false");
              _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_0.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td colspan=\"2\">\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setLabel("ICPC Document");
              _jspx_th_impact_validateInput_3.setName("cbxICPCDocument");
              _jspx_th_impact_validateInput_3.setType("checkbox");
              _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.ALL);
              _jspx_th_impact_validateInput_3.setChecked( "Y".equals(cbxICPCDocument) ? "true" : "false" );
              _jspx_th_impact_validateInput_3.setValue( cbxICPCDocument );
              _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table>\r\n<tr>\r\n    <th colspan=\"4\">Document Type</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Adoption Information</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxAdoInfo', true);\">Select All Adoption Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxAdoInfo', false);\">Deselect All Adoption Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setName("cbxAdoInfo");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CEXDOCAI );
              _jspx_th_impact_codesCheckbox_0.setDisabled("false");
              _jspx_th_impact_codesCheckbox_0.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes( checkedAdoList );
              _jspx_th_impact_codesCheckbox_0.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Case Data</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxCaseData', true);\">Select All Case Data</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxCaseData', false);\">Deselect All Case Data</a>\r\n\t\t    </td>\r\n\t\t  </tr>\t\t  \r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_1.setName("cbxCaseData");
              _jspx_th_impact_codesCheckbox_1.setColumns(3);
              _jspx_th_impact_codesCheckbox_1.setCodesTableName( CodesTables.CEXDOCCD );
              _jspx_th_impact_codesCheckbox_1.setDisabled("false");
              _jspx_th_impact_codesCheckbox_1.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes( checkedCaseDataList );
              _jspx_th_impact_codesCheckbox_1.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Court/Legal Information</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxCrtLegalInfo', true);\">Select All Court/Legal Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxCrtLegalInfo', false);\">Deselect All Court/Legal Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\t\t  \r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_2.setName("cbxCrtLegalInfo");
              _jspx_th_impact_codesCheckbox_2.setColumns(3);
              _jspx_th_impact_codesCheckbox_2.setCodesTableName( CodesTables.CEXDOCCL );
              _jspx_th_impact_codesCheckbox_2.setDisabled("false");
              _jspx_th_impact_codesCheckbox_2.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_2.setDefaultCodes( checkedCrtLegalList );
              _jspx_th_impact_codesCheckbox_2.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
              if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Foster/Adoptive Home Information</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxFstAdoHmInfo', true);\">Select All Foster/Adoptive Home Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxFstAdoHmInfo', false);\">Deselect All Foster/Adoptive Home Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\t\t  \r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_3.setName("cbxFstAdoHmInfo");
              _jspx_th_impact_codesCheckbox_3.setColumns(3);
              _jspx_th_impact_codesCheckbox_3.setCodesTableName( CodesTables.CEXDOCFA );
              _jspx_th_impact_codesCheckbox_3.setDisabled("false");
              _jspx_th_impact_codesCheckbox_3.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_3.setDefaultCodes( checkedFstAdoHmList );
              _jspx_th_impact_codesCheckbox_3.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_3 = _jspx_th_impact_codesCheckbox_3.doStartTag();
              if (_jspx_th_impact_codesCheckbox_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Health Information</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxHlthInfo', true);\">Select All Health Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxHlthInfo', false);\">Deselect All Health Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\t\t  \r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_4.setName("cbxHlthInfo");
              _jspx_th_impact_codesCheckbox_4.setColumns(3);
              _jspx_th_impact_codesCheckbox_4.setCodesTableName( CodesTables.CEXDOCHI );
              _jspx_th_impact_codesCheckbox_4.setDisabled("false");
              _jspx_th_impact_codesCheckbox_4.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_4.setDefaultCodes( checkedHlthList );
              _jspx_th_impact_codesCheckbox_4.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_4 = _jspx_th_impact_codesCheckbox_4.doStartTag();
              if (_jspx_th_impact_codesCheckbox_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Person Information</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxPrsnInfo', true);\">Select All Person Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxPrsnInfo', false);\">Deselect All Person Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\t\t  \r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_5.setName("cbxPrsnInfo");
              _jspx_th_impact_codesCheckbox_5.setColumns(3);
              _jspx_th_impact_codesCheckbox_5.setCodesTableName( CodesTables.CEXDOCPI );
              _jspx_th_impact_codesCheckbox_5.setDisabled("false");
              _jspx_th_impact_codesCheckbox_5.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_5.setDefaultCodes( checkedPrsnList );
              _jspx_th_impact_codesCheckbox_5.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_5 = _jspx_th_impact_codesCheckbox_5.doStartTag();
              if (_jspx_th_impact_codesCheckbox_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"3\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n\t      <tr>\r\n\t    \t<th colspan=\"4\">Other</th>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxOth', true);\">Select All Other Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t    <td>\r\n\t\t    <a href=\"javascript:stayHere()\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"SetAllCheckBoxes('cbxOth', false);\">Deselect All Other Information</a>\r\n\t\t    </td>\r\n\t\t  </tr>\t\t  \r\n\t      <tr>\r\n\t       <td>\r\n\t      \t  ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_6.setName("cbxOth");
              _jspx_th_impact_codesCheckbox_6.setColumns(3);
              _jspx_th_impact_codesCheckbox_6.setCodesTableName( CodesTables.CEXDOCXX );
              _jspx_th_impact_codesCheckbox_6.setDisabled("false");
              _jspx_th_impact_codesCheckbox_6.setTabIndex(tabIndex++ );
              _jspx_th_impact_codesCheckbox_6.setDefaultCodes( checkedOthList );
              _jspx_th_impact_codesCheckbox_6.setEditableMode(EditableMode.ALL);
              int _jspx_eval_impact_codesCheckbox_6 = _jspx_th_impact_codesCheckbox_6.doStartTag();
              if (_jspx_th_impact_codesCheckbox_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t       \t</td>\r\n\t       </tr>\r\n       </table>\r\n    </td>\r\n</tr>\r\n</table>\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n     <th colspan=\"4\">Search By Persons Associated to External Documentation</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n  <tr> \r\n    <th colspan =\"4\" class=\"thList\" width=\"20%\">Names</th>\r\n  </tr>\r\n  <tr>\r\n  <td width=\"100%\" class=\"formlabel\">\r\n    <div id=\"scroll3\" style=\"width:100%; height:125px; overflow:auto\" class=\"tableBorder\">\r\n     <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  \r\n      <tr>\r\n          ");

            ROWCINV23SOG01_ARRAY rowcin23soArray = ExtDocList.getROWCINV23SOG01_ARRAY();
            if( rowcin23soArray == null )
            {
              rowcin23soArray = new ROWCINV23SOG01_ARRAY();
            }

            Enumeration cinv23soEnumeration = rowcin23soArray.enumerateROWCINV23SOG01();

            if( !cinv23soEnumeration.hasMoreElements() )
            {
          
              out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"4\">\r\n              ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n            </td>\r\n          </tr>\r\n      <tr>\r\n          ");

          }
          else
          {
            String checkedVal = "false";
            int i = 0;
            while( cinv23soEnumeration.hasMoreElements() )
            {
              ROWCINV23SOG01 cinv23soRow = (ROWCINV23SOG01)cinv23soEnumeration.nextElement();
              checkedVal = cinv23soRow.getCSysIndNameChecked() != null ? (cinv23soRow.getCSysIndNameChecked() == "Y" ? "true":"false"):"false";
              if( i % 2 == 0 )
              {
                out.println( "<tr class=\"subDetail\">" );
              }
              else
              {
                out.println( "<tr class=\"altcolor\">" );
              }
              
              // do not add a <tr> here plz they are genereated in the code above
              state.setAttribute("savedExtDocPerson", ExtDocList.getROWCINV23SOG01_ARRAY(), request);
          
              out.write("\r\n         ");
String cbxName = "cbxUlIdPersons" + ( i + 1 );
          String indPersonChecked = "false";
         
              out.write(" \t \t\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_4.setType("checkbox");
              _jspx_th_impact_validateInput_4.setValue( String.valueOf(cinv23soRow.getUlIdPerson()) );
              _jspx_th_impact_validateInput_4.setName( cbxName );
              _jspx_th_impact_validateInput_4.setDisabled( modifyDisabled );
              _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_validateInput_4.setChecked( checkedVal );
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \r\n            ");
              out.print( FormattingHelper.formatString( cinv23soRow.getSzNmPersonFull() ) );
              out.write("\r\n          </td>\r\n     </tr>\r\n        ");

          i++;
           }
          }
        
              out.write("\r\n     </table>\r\n    </div>\r\n  </td>\r\n </tr>\r\n <tr>\r\n </tr>\r\n</table>\r\n\r\n<table width=\"100%\" cellpadding=\"3\" border=\"0\" cellspacing=\"0\">\r\n      <tr>\r\n        <td>\r\n\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_0.setName("btnSearch");
              _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
              _jspx_th_impact_ButtonTag_0.setForm("frmExtDocList");
              _jspx_th_impact_ButtonTag_0.setAction("/multipart/ExternalDcmnttn/displayExtDocList");
              _jspx_th_impact_ButtonTag_0.setAlign("right");
              _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t</td>\r\n      </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmExtDocListResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/multipart/ExternalDcmnttn/displayExtDocList");
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnCustomValidation");
      _jspx_th_impact_validateForm_1.setPageMode(PageMode.getPageMode(request));
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl("/multipart/ExternalDcmnttn/displayExtDocList");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <!-- Hidden Fields -->\r\n  ");
              if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n  ");
              if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n  <div id=\"noScrollResults\" style=\"height:190px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n      <tr>\r\n        <th class=\"thList\">&nbsp;</th>\r\n        <th class=\"thList\">Sort</th>\r\n        <th class=\"thList\">Date Obtained &nbsp;\r\n        \t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(ExternalDcmnttnConversation.SORT_BY_DATE_OBTAINED);
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </th>\r\n        <th class=\"thList\">Document Class &nbsp;\r\n        ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(ExternalDcmnttnConversation.SORT_BY_DOC_CLASS);
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </th>\r\n        <th class=\"thList\">Document Type &nbsp;\r\n        \t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(ExternalDcmnttnConversation.SORT_BY_DOC_TYPE);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </th>\r\n        <th class=\"thList\">Item Location\r\n        </th>\r\n        <th class=\"thList\" width=\"10%\">Comments</th>\r\n      </tr>\r\n      ");

      
         if( !ExtDocEnum.hasMoreElements() )
            {
      
              out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"4\">\r\n              ");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_SVC_NO_EXT_DOC_MATCH ) );
              out.write("\r\n            </td>\r\n          </tr>\r\n      \t<tr>\r\n          ");

      		} else {
		        while (ExtDocEnum.hasMoreElements()) {
		          ExtDocDetail = (ROWCINV23SOG00) ExtDocEnum.nextElement();
		          String rowCss = FormattingHelper.getRowCss(extDocCount + 1);
		          String CommentSubstring = "";
                  String Comment = FormattingHelper.formatString(ExtDocDetail.getSzTxtExtDocDetails());
              if(Comment.length() > 35 )  {
               CommentSubstring = Comment.substring( 0, 35 );
              }
              else{
              CommentSubstring = Comment;
              }
      
              out.write("\r\n      <tr class=\"");
              out.print(rowCss);
              out.write("\">\r\n        <td width=\"5%\">\r\n          ");
 if (pageMode.equals(PageModeConstants.VIEW)) {
          
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_7.setType("radio");
              _jspx_th_impact_validateInput_7.setName("rbExtDoc");
              _jspx_th_impact_validateInput_7.setValue( String.valueOf( ExtDocDetail.getUlIdExtSitInfo() ) );
              _jspx_th_impact_validateInput_7.setOnClick("javascript:rbSelected=true;");
              _jspx_th_impact_validateInput_7.setDisabled("true");
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
} else {
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setName("rbExtDoc");
              _jspx_th_impact_validateInput_8.setValue( String.valueOf( ExtDocDetail.getUlIdExtSitInfo() ) );
              _jspx_th_impact_validateInput_8.setOnClick("javascript:rbSelected=true;");
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");

            }
          
              out.write("</td>\r\n        <td>");
              out.print( FormattingHelper.formatString(ExtDocDetail.getSzCdExtDocSort()) );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( FormattingHelper.formatDate(ExtDocDetail.getDtDtExtDocObtained()) );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( ExtDocDetail.getSzCdDocClass() != null ?
                Lookup.simpleDecodeSafe("CEXDOCLA", ExtDocDetail.getSzCdDocClass()) : "&nbsp;" );
              out.write("\r\n        </td>\r\n        <td><a href=\"#\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" onClick=\"displayExtDocDetail(");
              out.print( extDocCount++ );
              out.write(");\">");
              out.print(
        Lookup.simpleDecodeSafe("CEXDOTYP", ExtDocDetail.getSzCdExtDocType()) );
              out.write("\r\n        </a></td>\r\n        <td>");
              out.print( ExtDocDetail.getSzTxtExtDocLocation() != null ?
                Lookup.simpleDecodeSafe("CITEMLOC", ExtDocDetail.getSzTxtExtDocLocation()) : "&nbsp;" );
              out.write("\r\n        </td>\r\n      <td>");
              out.print( CommentSubstring );
              out.write("</td>\r\n      </tr>\r\n      ");
}
        }
              out.write("\r\n    </table>\r\n  </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n<table cellspacing=\"0\" cellPadding=\"3\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignLeft\">\r\n      ");
 if (extDocCount > 0) { 
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnDelete");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setDisabled( String.valueOf( bDeleteButton ) );
          _jspx_th_impact_ButtonTag_1.setForm("frmExtDocListResults");
          _jspx_th_impact_ButtonTag_1.setAction("/multipart/ExternalDcmnttn/saveExtDocDetail");
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
 } else { 
          out.write("\r\n      &nbsp;\r\n      ");
 } 
          out.write("\r\n    </td>\r\n    ");

      //SIR 19201 -- If the mode is not equal to approval, the add push button will
      //be hidden.
      if (!GlobalData.isApprovalMode(request)) {
    
          out.write("\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnAdd");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setDisabled( String.valueOf( bAddButton ) );
          _jspx_th_impact_ButtonTag_2.setForm("frmExtDocListResults");
          _jspx_th_impact_ButtonTag_2.setAction("/multipart/ExternalDcmnttn/displayExtDocDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");

      }
    
          out.write("\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnPageName");
    _jspx_th_impact_validateInput_0.setValue("ExtDocList");
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
    _jspx_th_impact_validateInput_1.setName("hdnUlIdExtDoc");
    _jspx_th_impact_validateInput_1.setValue("-1");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnPageName");
    _jspx_th_impact_validateInput_5.setValue("ExtDocList");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnUlIdExtDoc");
    _jspx_th_impact_validateInput_6.setValue("-1");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
