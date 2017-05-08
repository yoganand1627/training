package org.apache.jsp.grnds_002ddocs.multipart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV23SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;

public final class ExternalDcmnttnDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//*  JSP Name:     ExternalDcmnttnDetail
      //*  Created by:   Rodrigo DeJuana
      //*  Date Created: 11/19/02
      //*
      //*  Description:
      //*   This page allows the user to create, modify, or delete
      //*   allegations during the Investigation stage of service.
      //*   Allegations may be created or deleted individually and
      //*   modified either individually or as a group.
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       03/25/03  Todd Reser        QA Sweep.
       04/16/03  Todd Reser        Switched to ServiceConstants.REQ_FUNC_CD_ADD, added
       Confirm Delete fuction.
       04/17/03  Todd Reser        Added Spell Check.
       04/22/03  Todd Reser        Added tabinxed to Spell Check.
       05/07/03  Todd Reser        Changed Confirm Delete message.
       06/16/03  Merle A Demo      Replaced old pageMode with newer GlobalData.getPageMode
       10/03/03  CORLEYAN        SIR 19951 This page should always be in modify mode regardless
       of the app mode
       11/28/04  Hadjimh           SIR#22839. Currently, the worker clicks the add button,
       selects one item and saves and this action takes user to
       Ext Doc List page and the actions are repeated
       for each item that is being documented. SaveAndStay
       button is added to make this task smoother.
       09/12/05  PISHARRK          SIR 23953 - MPS Phase III enhancement to display 
       Ext. Doc List/Details using EJB/DAO service(replacing existing DAMs)
       for both MPS and IMPACT  
       09/23/05  cooganpj          SIR 23966 - MPS Phase III Lockdown changes - updated to read in the page
       mode from the conversation.    
       11/05/09  pcoogan           SMS 39073 - Removed pagination tag in page causing various navigation and data loss errors
       01/30/12	 vcollooru		   STGAP00017827 MR-085 Modified to add new checkbox for marking ICPC Documents                                                        
       */
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  CINV23SO _cinv23so = (CINV23SO) state.getAttribute("CINV23SO", request);
  if (_cinv23so == null) {
    _cinv23so = new CINV23SO();
  }

  //Everything above this point should be in every page.
  int tabIndex = 1;
  String modifyDisabled = "false";

  ROWCINV23SOG00 ExtDocDetail2 = (ROWCINV23SOG00) request.getAttribute("ExtDocDetail");

  //Get Stage Closed Ind and Stage Closed Date
  boolean stageClosed = (Boolean) state.getAttribute("stageClosed", request);
  Date stageClosureDate = (Date) state.getAttribute("stageClosureDate", request);
  //Disabling Radio button for External Documents added prior to the stage closure.
  Date weekAfterStageClosed = (Date) state.getAttribute("weekAfterStageClosed", request);
  if (stageClosed && stageClosureDate != null) {
    weekAfterStageClosed = DateHelper.addToDate(stageClosureDate, 0, 0, 7);
  }

  // PAGE MODE LOGIC BEGIN
  String pageMode = PageModeConstants.EDIT;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }
  String cdDocType = "";

      out.write("\r\n\r\n");

  CINV23SO ExtDocList = (CINV23SO) state.getAttribute("CINV23SO", request);
  if (ExtDocList == null) {
    ExtDocList = new CINV23SO();
  }
  ROWCINV23SOG00 ExtDocDetail = (ROWCINV23SOG00) request.getAttribute("ExtDocDetail");
  ROWCINV23SOG02 ExtDocPersonCheck = new ROWCINV23SOG02();

  String sFileName = ExtDocDetail.getSzTxtFileName();
  String hdnAUMode = (String) request.getAttribute("hdnAUMode");
  Date dtToday = new Date();
  boolean bSaveNStayButton = false;
  boolean bSaveButton = false;
  boolean bViewButton = sFileName != null && !sFileName.equalsIgnoreCase("");
  String displayViewButton = bViewButton ? "inline" : "none";

  //STGAP00017906: Default the Item Location to "Uploaded" if none present.
  String extDocLocation = ExtDocDetail.getSzTxtExtDocLocation();
  if (("").equals(extDocLocation) || extDocLocation == null) {
    extDocLocation = "UPL";
  }

  if (pageMode.equals(PageModeConstants.VIEW)) {
    bSaveNStayButton = true;
    bSaveButton = true;
  }
  
  String bDelete = ServiceConstants.REQ_FUNC_CD_ADD.equals(hdnAUMode) ? "true" : "false";

  Date weekAfterDocAdded = new Date();

  if (stageClosed && stageClosureDate != null) {
    weekAfterDocAdded = DateHelper.addToDate(DateHelper.toJavaDate(ExtDocDetail.getDtDtExtDocAdded()), 0, 0, 7);
    bDelete = "true";
    if (DateHelper.isBefore(new Date(), weekAfterDocAdded)) {
      bSaveNStayButton = false;
      bSaveButton = false;
    } else {
      bSaveNStayButton = true;
      bSaveButton = true;
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }
  }

      out.write("\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onbeforeunload = function() {\r\n    IsDirty();\r\n  };\r\n  \r\n  window.onload = function ()\r\n  {\r\n   \tupdateForViewButton();\r\n   \tupdateCodeType();\r\n  };\r\n  \r\n  function confirmDelete() {\r\n    disableValidation(\"frmExtDocDetail\");\r\n    return confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("\")\r\n  }\r\n\r\n  function confirmUpload() {\r\n  \tif(fileSelected()){\r\n  \t\tif(testFileExtension('SAVE')){\r\n  \t\t\tif(");
      out.print(ExtDocDetail.getSzTxtFileName().length() > 0);
      out.write("){\r\n\t\t    \treturn confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_EXT_DOC_UPLOAD_CONFIRM));
      out.write("\");\r\n\t\t    }\r\n\t\t} \r\n\t\telse {\r\n\t\t    return false;\r\n\t\t}\r\n\t }\r\n\t return true;\r\n  }\r\n  \r\n  function fileSelected(){\r\n  \tvar filename = document.frmExtDocDetail.txttSzTxtExtFile.value;\r\n  \treturn filename.length>0;\r\n  }\r\n  \r\n\r\n  function viewFile() {\r\n  ");

     String ulIdExtDoc = URLHelper.encode(String.valueOf(ExtDocDetail.getUlIdExtSitInfo()));
     String fileName = URLHelper.encode(String.valueOf(ExtDocDetail.getSzTxtFileName()));
     String fileType = URLHelper.encode(String.valueOf(ExtDocDetail.getSzTxtFormatType()));
   
      out.write("\r\n    window.open('/multipart/ExternalDcmnttn/viewExtDoc?UlIdExtDoc=");
      out.print(ulIdExtDoc);
      out.write("&fileName=");
      out.print(fileName);
      out.write("&fileType=");
      out.print(fileType);
      out.write("', 'ViewFile', 'toolbar=no,location=no,scrollbars=auto,resizable=yes');\r\n  }\r\n\r\n  function testFileExtension(calledFrom) {\r\n    var correctType = false;\r\n    var filename = document.frmExtDocDetail.txttSzTxtExtFile.value;\r\n    if (filename.length > 0) {\r\n      var indexOf = filename.indexOf('.');\r\n      var dotIndex = filename.length-4;\r\n      if(indexOf != dotIndex){\r\n      \tindexOf = dotIndex;\r\n      }\r\n      if (indexOf != -1) {\r\n        var start = indexOf + 1;\r\n        var ext = filename.substr(start, filename.length);\r\n        ext = ext.toLowerCase();\r\n        if (calledFrom == \"BROWSE\"){\r\n        \talert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_EXT_DOC_UPLOAD_WARN));
      out.write("\");\r\n        }\r\n       if ('jpg' == ext || 'pdf' == ext || 'jpeg' == ext) {\r\n          correctType = true;\r\n        }\r\n        else {\r\n          alert(\"Uploads can only be Pictures .jpg or Adobe PDFs .pdf files\");\r\n        }\r\n      }\r\n      else {\r\n        alert(\"Uploads can only be Pictures .jpg or Adobe PDFs .pdf files\");\r\n      }\r\n    }\r\n    else {\r\n      alert(\"Please enter a filename\");\r\n      correctType = false;\r\n    }\r\n<!--    if(correctType){-->\r\n<!--\t}-->\r\n\r\n    return correctType;\r\n  }\r\n  \r\n  function updateForViewButton()\r\n  {\r\n  \tvar displayView = '");
      out.print(displayViewButton);
      out.write("';\r\n  \tbtnViewSpanId.style.display=displayView;\r\n  }\r\n  \r\n \r\n  //Get county code/decode array filtered for Adoptions Information\r\n  ");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for Case Data\r\n  ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for Court/Legal Information\r\n  ");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write("  \r\n  //Get county code/decode array filtered for Foster/Adoptive Home Information\r\n  ");
      if (_jspx_meth_impact_codeArray_3(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for Home Information\r\n  ");
      if (_jspx_meth_impact_codeArray_4(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for Person Information\r\n  ");
      if (_jspx_meth_impact_codeArray_5(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for Other\r\n  ");
      if (_jspx_meth_impact_codeArray_6(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for Other\r\n  ");
      if (_jspx_meth_impact_codeArray_7(_jspx_page_context))
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_codeArray_8(_jspx_page_context))
        return;
      out.write("\r\n  \r\n  function filterDocumentType()\r\n  {\r\n    var DocClassFilter = document.frmExtDocDetail.selSzcdDocClass.value;\r\n   if ( DocClassFilter == \"\" )\r\n   {\r\n      clearDropdown( frmExtDocDetail.selSzCdExtDocType );\r\n   }\r\n   else\r\n    {\r\n     if(frmExtDocDetail.selSzcdDocClass.value == \"AI\")\r\n     {\r\n     populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCAI);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"CD\")\r\n    {\r\n     populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCCD);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"CI\")\r\n    {\r\n     populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCCL);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"FA\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCFA);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"HI\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCHI);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"PI\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCPI);\r\n");
      out.write("    }else if(frmExtDocDetail.selSzcdDocClass.value == \"XX\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCXX);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"CH\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDORST);\r\n    }\r\n }\r\n }\r\n \r\n function updateCodeType()\r\n{\r\nvar DocClass = frmExtDocDetail.selSzcdDocClass.value;\r\nvar DocType = frmExtDocDetail.selSzCdExtDocType.value;\r\nif(DocType==\"\"){\r\n//New mode so do not need to filter the document type dropdown\r\npopulateDropdown( frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOTYP );\r\n}else\r\n    {\r\n     if(frmExtDocDetail.selSzcdDocClass.value == \"AI\")\r\n     {\r\n     populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCAI);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"CD\")\r\n    {\r\n     populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCCD);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"CI\")\r\n    {\r\n     populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCCL);\r\n");
      out.write("    }else if(frmExtDocDetail.selSzcdDocClass.value == \"FA\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCFA);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"HI\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCHI);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"PI\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCPI);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"XX\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDOCXX);\r\n    }else if(frmExtDocDetail.selSzcdDocClass.value == \"CH\")\r\n    {\r\n    populateDropdown(frmExtDocDetail.selSzCdExtDocType , \"\", CEXDORST);\r\n    }\r\n    document.frmExtDocDetail.selSzCdExtDocType.value=DocType;\r\n }\r\n}\r\n\r\n \r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExtDocDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/multipart/ExternalDcmnttn/saveExtDocDetail");
      _jspx_th_impact_validateForm_0.setPageMode(PageMode.getPageMode(request));
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.multipart.ExternalDcmnttnCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setEncType("multipart/form-data");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n\t<!-- Hidden Fields -->\r\n\t");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdExtSitInfo");
          _jspx_th_impact_validateInput_1.setValue(String.valueOf(ExtDocDetail.getUlIdExtSitInfo()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnDtDtCaseOpened");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatDate(ExtDocList.getDtDtCaseOpened()));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnDtDtExtDocAdded");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatDate(ExtDocDetail.getDtDtExtDocAdded()));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnAUMode");
          _jspx_th_impact_validateInput_5.setValue(hdnAUMode);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<!--- Begin Detail Table --->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtExtDocObtained");
          _jspx_th_impact_validateDate_0.setLabel("Date Obtained");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(ExtDocDetail.getDtDtExtDocObtained()));
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setName("txtSzCdExtDocSort");
          _jspx_th_impact_validateInput_6.setLabel("Sort Order");
          _jspx_th_impact_validateInput_6.setValue(ExtDocDetail.getSzCdExtDocSort() != null ? ExtDocDetail.getSzCdExtDocSort() : "");
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setSize("2");
          _jspx_th_impact_validateInput_6.setMaxLength("2");
          _jspx_th_impact_validateInput_6.setConstraint("AlphaNumeric2");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzcdDocClass");
          _jspx_th_impact_validateSelect_0.setLabel("Document Class");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setValue(ExtDocDetail.getSzCdDocClass());
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CEXDOCLA);
          _jspx_th_impact_validateSelect_0.setOnChange("filterDocumentType();");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtDtDtExtDocUploaded");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Upload Date");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatDate(ExtDocDetail.getDtExtDocUploaded()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selSzCdExtDocType");
          _jspx_th_impact_validateSelect_1.setLabel("Type");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(ExtDocDetail.getSzCdExtDocType());
          _jspx_th_impact_validateSelect_1.setValueType(SelectTag.CODES);
          _jspx_th_impact_validateSelect_1.setContentType(SelectTag.DECODES);
          _jspx_th_impact_validateSelect_1.setOnChange("updateCodeType();");
          _jspx_th_impact_validateSelect_1.setCodesTable(CodesTables.CEXDOTYP);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<!-- STGAP00017827: Added the checkbox for marking ICPC Document -->\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setName("selIndICPCDoc");
          _jspx_th_impact_validateInput_7.setLabel("ICPC Document");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setValue("N");
          _jspx_th_impact_validateInput_7.setChecked("Y".equals(ExtDocDetail.getBIndICPCDoc()) ? "true" : "false");
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("txttSzTxtExtDocLocation");
          _jspx_th_impact_validateSelect_2.setLabel("Item Location");
          _jspx_th_impact_validateSelect_2.setValue(extDocLocation);
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setCodesTable("CITEMLOC");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setBlankValue(Lookup.simpleDecodeSafe("CITEMLOC", "CAS"));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setName("selIndSigned");
          _jspx_th_impact_validateInput_8.setLabel("Signed?");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setValue("N");
          _jspx_th_impact_validateInput_8.setChecked("Y".equals(ExtDocDetail.getBIndExtDocSigned()) ? "true" : "false");
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtaSzTxtExtDocDetails");
          _jspx_th_impact_validateTextArea_0.setLabel("Details");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(ExtDocDetail.getSzTxtExtDocDetails()));
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
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t<input name=\"txttSzTxtExtFile\" type=\"file\" size=\"30\"\r\n\t\t\t\t\tonchange=\"testFileExtension('BROWSE');\" />\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtDtDtExtDocFileName");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("File Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(ExtDocDetail.getSzTxtFileName()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtDtDtExtDocFileType");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("File Type");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatString((String) state.getAttribute("txtFileType", request)));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\r\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\t<font class='formRequiredText'> *</font>Persons\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\" class=\"thList\" width=\"20%\">\r\n\t\t\t\tNames\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<td width=\"100%\" class=\"formlabel\">\r\n\t\t\t<div id=\"scroll3\" style=\"width: 100%; height: 125px; overflow: auto\"\r\n\t\t\t\tclass=\"tableBorder\">\r\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setName("selIndNaChecked");
          _jspx_th_impact_validateInput_9.setLabel("N/A");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setValue("N");
          _jspx_th_impact_validateInput_9.setChecked("Y".equals(ExtDocDetail.getBIndNaChecked()) ? "true" : "false");
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t");

            ROWCINV23SOG01_ARRAY rowcin23soArray = ExtDocList.getROWCINV23SOG01_ARRAY();
              if (rowcin23soArray == null) {
                rowcin23soArray = new ROWCINV23SOG01_ARRAY();
              }

              Enumeration<ROWCINV23SOG01> cinv23soEnumeration = rowcin23soArray.enumerateROWCINV23SOG01();

              if (!cinv23soEnumeration.hasMoreElements()) {
          
          out.write("\r\n\t\t\t\t\t\r\n\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t");

            } else {
                int i = 0;
                while (cinv23soEnumeration.hasMoreElements()) {
                  ROWCINV23SOG01 cinv23soRow = (ROWCINV23SOG01) cinv23soEnumeration.nextElement();
                  if (i % 2 == 0) {
                    out.println("<tr class=\"altcolor\">");
                  } else {
                    out.println("<tr class=\"subDetail\">");
                  }

                  // do not add a <tr> here plz they are genereated in the code above
                  state.setAttribute("savedExtDocPerson", _cinv23so.getROWCINV23SOG01_ARRAY(), request);
          
          out.write("\r\n\t\t\t\t\t\t");

             String cbxName = "cbxUlIdPerson" + (i + 1);
                   String indPersonChecked = "false";

                   ROWCINV23SOG02_ARRAY rowPerCheckArray = ExtDocDetail.getROWCINV23SOG02_ARRAY();
                   if (rowPerCheckArray == null) {
                     rowPerCheckArray = new ROWCINV23SOG02_ARRAY();
                   }

                   Enumeration<ROWCINV23SOG02> perCheckEnumeration = rowPerCheckArray.enumerateROWCINV23SOG02();

                   while (perCheckEnumeration.hasMoreElements()) {
                     ROWCINV23SOG02 rowPerCheckso = (ROWCINV23SOG02) perCheckEnumeration.nextElement();
                     if (rowPerCheckso.getUlIdPerson() == cinv23soRow.getUlIdPerson()) {
                       indPersonChecked = "true";
                     }
                   }
           
          out.write("\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setChecked(indPersonChecked);
          _jspx_th_impact_validateInput_10.setValue(String.valueOf(i));
          _jspx_th_impact_validateInput_10.setName(cbxName);
          _jspx_th_impact_validateInput_10.setDisabled(modifyDisabled);
          _jspx_th_impact_validateInput_10.setEditableMode(EditableMode.DEFAULT);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t\t\t\t");
          out.print(FormattingHelper.formatString(cinv23soRow.getSzNmPersonFull()));
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

          i++;
              }
            }
        
          out.write("\r\n\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"85%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_0.setForm("frmExtDocDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/multipart/ExternalDcmnttn/saveExtDocDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setDisabled(bDelete);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<span id=\"btnViewSpanId\" style='display: \"'> ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnView");
          _jspx_th_impact_ButtonTag_1.setImg("btnView");
          _jspx_th_impact_ButtonTag_1.setDisabled(String.valueOf(!bViewButton));
          _jspx_th_impact_ButtonTag_1.setAction("/multipart/ExternalDcmnttn/displayExtDocDetail");
          _jspx_th_impact_ButtonTag_1.setForm("frmExtDocDetail");
          _jspx_th_impact_ButtonTag_1.setFunction("viewFile();");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</span>\r\n\t\t\t</td>\r\n\r\n\r\n\t\t\t<td>\r\n\t\t\t\t<!--- SIR#22839 --->\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAndStay");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndStay");
          _jspx_th_impact_ButtonTag_2.setDisabled(String.valueOf(bSaveNStayButton));
          _jspx_th_impact_ButtonTag_2.setForm("frmExtDocDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/multipart/ExternalDcmnttn/saveExtDocDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td align=\"right\" width=\"10%\">\r\n\t\t\t\t");

        if (!pageMode.equals(PageModeConstants.VIEW)) {
      
          out.write("\r\n\t\t\t\t");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmExtDocDetail");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck("txtaSzTxtExtDocDetails");
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

        }
      
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"right\" width=\"5%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setDisabled(String.valueOf(bSaveButton));
          _jspx_th_impact_ButtonTag_3.setForm("frmExtDocDetail");
          _jspx_th_impact_ButtonTag_3.setFunction("return confirmUpload();");
          _jspx_th_impact_ButtonTag_3.setAction("/multipart/ExternalDcmnttn/saveExtDocDetail");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<!--- End Detail Table --->\r\n\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CEXDOCAI");
    _jspx_th_impact_codeArray_0.setArrayName("CEXDOCAI");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CEXDOCCD");
    _jspx_th_impact_codeArray_1.setArrayName("CEXDOCCD");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CEXDOCCL");
    _jspx_th_impact_codeArray_2.setArrayName("CEXDOCCL");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_3.setParent(null);
    _jspx_th_impact_codeArray_3.setCodeName("CEXDOCFA");
    _jspx_th_impact_codeArray_3.setArrayName("CEXDOCFA");
    _jspx_th_impact_codeArray_3.setBlankValue("true");
    int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
    if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_4.setParent(null);
    _jspx_th_impact_codeArray_4.setCodeName("CEXDOCHI");
    _jspx_th_impact_codeArray_4.setArrayName("CEXDOCHI");
    _jspx_th_impact_codeArray_4.setBlankValue("true");
    int _jspx_eval_impact_codeArray_4 = _jspx_th_impact_codeArray_4.doStartTag();
    if (_jspx_th_impact_codeArray_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_5.setParent(null);
    _jspx_th_impact_codeArray_5.setCodeName("CEXDOCPI");
    _jspx_th_impact_codeArray_5.setArrayName("CEXDOCPI");
    _jspx_th_impact_codeArray_5.setBlankValue("true");
    int _jspx_eval_impact_codeArray_5 = _jspx_th_impact_codeArray_5.doStartTag();
    if (_jspx_th_impact_codeArray_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_6.setParent(null);
    _jspx_th_impact_codeArray_6.setCodeName("CEXDOCXX");
    _jspx_th_impact_codeArray_6.setArrayName("CEXDOCXX");
    _jspx_th_impact_codeArray_6.setBlankValue("true");
    int _jspx_eval_impact_codeArray_6 = _jspx_th_impact_codeArray_6.doStartTag();
    if (_jspx_th_impact_codeArray_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_7.setParent(null);
    _jspx_th_impact_codeArray_7.setCodeName("CEXDORST");
    _jspx_th_impact_codeArray_7.setArrayName("CEXDORST");
    _jspx_th_impact_codeArray_7.setBlankValue("true");
    int _jspx_eval_impact_codeArray_7 = _jspx_th_impact_codeArray_7.doStartTag();
    if (_jspx_th_impact_codeArray_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_8.setParent(null);
    _jspx_th_impact_codeArray_8.setCodeName("CEXDORST");
    _jspx_th_impact_codeArray_8.setArrayName("CEXDOTYP");
    _jspx_th_impact_codeArray_8.setBlankValue("true");
    int _jspx_eval_impact_codeArray_8 = _jspx_th_impact_codeArray_8.doStartTag();
    if (_jspx_th_impact_codeArray_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
    _jspx_th_impact_validateInput_0.setValue("ExtDocDetail");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnSzTxtFileName");
    _jspx_th_impact_validateInput_2.setValue("Winter.jpg");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_1.setName("txtSzAttachFile");
    _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Attach File");
    int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
