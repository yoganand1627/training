package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class IncRsrcDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/admin/AdminAddressPhoneSub.jsp");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
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

//*  JSP Name:     Income and Resources
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 11/10/2002
      //*
      //*  Description:
      //*  This JSP is used to maintain a Person's Income and Resource information
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       02/26/07  N .Hegde          Changed label from "Effective From" to Start Date
       and "Effective To" to End Date
       07/27/06  V. Vo             Changed txtSzTxtIncRsrcDesc label from
       "Description" to "Comments"
       Renamed "Source" to "Source/Employer"
       Added Date Modified 
       06/09/03  Todd Reser        SIR 18081 Changed txtSzTxtIncRsrcDesc label from
       "Comments" to "Description"
       08/26/03  A.Corley          SIR 19536 Cancel validation when deleting
       08/18/05  Todd Reser        SIR 23759 - Use new APS CINC2 and CRSRC2 Codes
       Tables when necessary
       */

      
      out.write("\r\n\r\n\r\n");
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
       for Tuxedo service calls.  Xml output structs corresponding to the services
       called to retrieve data for this page should be used on this page and
       therefore imported here */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      //Get the output object from the request
      ROWCCFC29SOG00 rowccfc29sog00 = (ROWCCFC29SOG00) request.getAttribute("ROWCCFC29SOG00");
      String lAmtIncRsrcMonth = (String) request.getAttribute("lAmtIncRsrcMonth");
      String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
      String szCdIncRsrcType = StringHelper.EMPTY_STRING;
      String szCdFrequency = StringHelper.EMPTY_STRING;

      //SIR 23759 - Added SzCdStageProgram in case we know the Stage Program Type
      String szCdStageProgram = GlobalData.getSzCdStageProgram(request);

      if (rowccfc29sog00 == null) {
        rowccfc29sog00 = new ROWCCFC29SOG00();
        if (request.getParameter("selSzCdIncRsrcType") != null) {
          szCdIncRsrcType = request.getParameter("selSzCdIncRsrcType");
        }
        if (request.getParameter("selSzCdFrequency") != null) {
          szCdFrequency = request.getParameter("selSzCdFrequency");
        }
      } else {
        szCdIncRsrcType = rowccfc29sog00.getSzCdIncRsrcType();
        szCdFrequency = rowccfc29sog00.getSzCdIncRsrcFreqType();
      }

      String pageModePassed = StringHelper.EMPTY_STRING;
      String overallPageMode = PageModeConstants.EDIT;

      if (request.getAttribute("pageMode") != null) {
        pageModePassed = (String) request.getAttribute("pageMode");
        if (pageModePassed.equals(PageModeConstants.MODIFY)) {
          overallPageMode = PageModeConstants.EDIT;
        } else if (pageModePassed.equals(PageModeConstants.NEW)) {
          overallPageMode = PageModeConstants.NEW;
        } else if (pageModePassed.equals(PageModeConstants.VIEW)) {
          overallPageMode = PageModeConstants.VIEW;
        }
      }
      boolean defaultButton = PageModeConstants.NEW.equals(overallPageMode);

      
      out.write('\r');
      out.write('\n');
// Start Javascript Section 
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n //Start javascript funcitons here\r\n  //Create javascript functions here for each action on the page\r\n  //All form submits should use the submitValidateForm function to submit\r\n\r\n");

  //SIR 23759 - In case we don't have a Stage Program default to CINCRSRC  
  String incomeCodesTableString = CodesTables.CINC;
  String resourceCodesTableString = CodesTables.CRSRC;  
  String frequencyCodesTableString = CodesTables.CFREQ;

  //SIR 23759 - Use new APS Income and Resources if the Stage Program is APS
  /* 8/3/2006 - Not for GA
  if ("APS".equals(szCdStageProgram) || "AFC".equals(szCdStageProgram))
  {
    incomeCodesTableString = "CINC2";
    resourceCodesTableString = "CRSRC2";
  }
  //SIR 23759 - Use CPS Income and Resources if the Stage Program is CPS
  if ("CCL".equals(szCdStageProgram) || "CPS".equals(szCdStageProgram) ||
    "RCL".equals(szCdStageProgram)) {
    incomeCodesTableString = CodesTables.CINC;
    resourceCodesTableString = CodesTables.CRSRC;
  }*/

      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName(incomeCodesTableString);
      _jspx_th_impact_codeArray_0.setArrayName("incomeCodes");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_1.setParent(null);
      _jspx_th_impact_codeArray_1.setCodeName(resourceCodesTableString);
      _jspx_th_impact_codeArray_1.setArrayName("resourceCodes");
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_2.setParent(null);
      _jspx_th_impact_codeArray_2.setCodeName(frequencyCodesTableString);
      _jspx_th_impact_codeArray_2.setArrayName("frequencyCodes");
      _jspx_th_impact_codeArray_2.setBlankValue("true");
      int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
      if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n function updateType( )\r\n {\r\n   var buttonGroup = document.frmIncRsrcDetail.rbSzCdIncRsrcIncome;\r\n   var radioValue = getSelectedRadioValue( buttonGroup );\r\n   if ( radioValue == \"INC\" )\r\n   {\r\n     populateDropdown( frmIncRsrcDetail.selSzCdIncRsrcType , frmIncRsrcDetail.selSzCdIncRsrcType.value , incomeCodes );        \r\n   }\r\n   else\r\n   {\r\n     populateDropdown( frmIncRsrcDetail.selSzCdIncRsrcType , frmIncRsrcDetail.selSzCdIncRsrcType.value, resourceCodes );      \r\n   }\r\n   populateDropdown( frmIncRsrcDetail.selSzCdFrequency , frmIncRsrcDetail.selSzCdFrequency.value , frequencyCodes );\r\n }\r\n function populateFrequency() \r\n {\r\n   populateDropdown( frmIncRsrcDetail.selSzCdFrequency , frmIncRsrcDetail.selSzCdFrequency.value , frequencyCodes );\r\n }\r\n\r\n function deleteRow()\r\n {\r\n   var bRow = confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n   return bRow;\r\n }\r\n\r\nfunction isInState()\r\n{\r\n    return false;\r\n}\r\n\r\n //  Called onUnload of page to remind user unsaved data will be lost\r\n window.onbeforeunload = function ()\r\n {\r\n   IsDirty();\r\n }\r\n\r\n\r\n//End Java Script\r\n</script>\r\n\r\n");
//Declare and initialize control variables for the page
      /* Assign tab-index */
      int tabIndex = 1;

      boolean bIncome = true;
      boolean bResource = false;
      if (rowccfc29sog00 != null && rowccfc29sog00.getSzCdIncRsrcIncome() != null
          && "INC".equals(rowccfc29sog00.getSzCdIncRsrcIncome())) {
        bIncome = true;        
      } else if (rowccfc29sog00 != null && rowccfc29sog00.getSzCdIncRsrcIncome() != null
                 && "RES".equals(rowccfc29sog00.getSzCdIncRsrcIncome())) {
        bResource = true;
        bIncome = false;        
      }

      AdminAddressPhoneBean addressPhoneBean = new AdminAddressPhoneBean();
      addressPhoneBean.setAddress1(rowccfc29sog00.getSzTxtIncRsrcSrcAddrStLn1());
      addressPhoneBean.setAddress2(rowccfc29sog00.getSzTxtIncRsrcSrcAddrStLn2());
      addressPhoneBean.setZipAndSuff(rowccfc29sog00.getSzTxtIncRsrcSrcAddrZip());
      addressPhoneBean.setCity(rowccfc29sog00.getSzTxtIncRsrcSrcAddrCity());
      addressPhoneBean.setState(rowccfc29sog00.getSzTxtIncRsrcSrcAddrState());
      addressPhoneBean.setCounty(rowccfc29sog00.getSzCdIncRsrcSrcAddrCounty());
      addressPhoneBean.setComments(rowccfc29sog00.getSzTxtIncRsrcSrcAddrCmnts());
      addressPhoneBean.setPhone(rowccfc29sog00.getSzTxtIncRsrcSrcPhoneNum());
      addressPhoneBean.setPhoneExt(rowccfc29sog00.getSzTxtIncRsrcSrcPhoneExt());
      addressPhoneBean.addToRequest(request);

      
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmIncRsrcDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonDetail/saveIncRsrc");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.IncRsrcCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnTsIncomeLastUpdate");
          _jspx_th_impact_validateInput_0.setValue( DateHelper.toISOString(rowccfc29sog00.getTsLastUpdate()) );
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
          _jspx_th_impact_validateInput_1.setName("hdnUlIdIncRsrc");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(rowccfc29sog00.getUlIdIncRsrc()));
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
          _jspx_th_impact_validateInput_2.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_2.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
/* Begin Detail */

      
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tIncome and Resources\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setChecked( String.valueOf( bIncome ) );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_3.setOnClick("updateType();");
          _jspx_th_impact_validateInput_3.setValue("INC");
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rbSzCdIncRsrcIncome");
          _jspx_th_impact_validateInput_3.setLabel("Income");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setChecked( String.valueOf( bResource ) );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_4.setOnClick("updateType();");
          _jspx_th_impact_validateInput_4.setValue("RES");
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setName("rbSzCdIncRsrcIncome");
          _jspx_th_impact_validateInput_4.setLabel("Resource");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setChecked( FormattingHelper.formatString(rowccfc29sog00.getCIndIncRsrcNotAccess()) );
          _jspx_th_impact_validateInput_5.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setName("cbxCIndIncRsrcNotAccess");
          _jspx_th_impact_validateInput_5.setLabel("Not Accessible");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t");
/* If the page is in browse mode, display a static field with the database value
       else, display the dynamically populated dropdown If the Inc/Rsrc is income,
       lookup the decode for income, else look up the decode for resource*/
      if (overallPageMode.equals(PageModeConstants.VIEW)) {
        if (bIncome) {

          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Type");
          _jspx_th_impact_validateInput_6.setValue( Lookup.simpleDecode( incomeCodesTableString, szCdIncRsrcType ) );
          _jspx_th_impact_validateInput_6.setName("selSzCdIncRsrcType");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setSize("20");
          _jspx_th_impact_validateInput_6.setMaxLength("20");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
} else {

          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Type");
          _jspx_th_impact_validateInput_7.setValue(  Lookup.simpleDecode( resourceCodesTableString, szCdIncRsrcType )  );
          _jspx_th_impact_validateInput_7.setName("selSzCdIncRsrcType");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setSize("20");
          _jspx_th_impact_validateInput_7.setMaxLength("20");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
}
      } else {

          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setName("selSzCdIncRsrcType");
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_0.setCodesTable("");
          _jspx_th_impact_validateSelect_0.setValue(szCdIncRsrcType);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
}

          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("Source/Employer");
          _jspx_th_impact_validateInput_8.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_8.setName("txtSzSdsIncRrcsSource");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatString(rowccfc29sog00.getSzSdsIncRrcsSource()));
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_8.setSize("20");
          _jspx_th_impact_validateInput_8.setMaxLength("20");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Amount/Value");
          _jspx_th_impact_validateInput_9.setConstraint("Money11");
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setName("txtLAmtIncRsrc");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatMoney(rowccfc29sog00.getLAmtIncRsrc()));
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setSize("11");
          _jspx_th_impact_validateInput_9.setMaxLength("11");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
/* If the page is in browse mode, display a static field with the database value else, display the populated dropdown */
      if (overallPageMode.equals(PageModeConstants.VIEW)) {
        if (szCdFrequency != null && szCdFrequency.length() != 0) {

          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setLabel("Frequency");
          _jspx_th_impact_validateInput_10.setValue( Lookup.simpleDecode( frequencyCodesTableString, szCdFrequency ) );
          _jspx_th_impact_validateInput_10.setName("selSzCdFrequency");
          _jspx_th_impact_validateInput_10.setRequired("true");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setSize("20");
          _jspx_th_impact_validateInput_10.setMaxLength("20");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t\t");
} else {

          
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setLabel("Frequency");
          _jspx_th_impact_validateInput_11.setValue( "" );
          _jspx_th_impact_validateInput_11.setName("selSzCdFrequency");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setSize("20");
          _jspx_th_impact_validateInput_11.setMaxLength("20");
          _jspx_th_impact_validateInput_11.setRequired("true");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t\t");
}

          out.write("\r\n\t\t\t");
} else {

          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Frequency");
          _jspx_th_impact_validateSelect_1.setName("selSzCdFrequency");
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setDisabled("false");
          _jspx_th_impact_validateSelect_1.setCodesTable("");
          _jspx_th_impact_validateSelect_1.setValue(szCdFrequency);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t\t");
}

          out.write("\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("txtDtDtIncRsrcFrom");
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(rowccfc29sog00.getDtDtIncRsrcFrom()) );
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("txtDtDtIncRsrcTo");
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(rowccfc29sog00.getDtDtIncRsrcTo()) );
          _jspx_th_impact_validateDate_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("Verify Method");
          _jspx_th_impact_validateInput_12.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_12.setName("txtSzSdsIncRsrcVerfMethod");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString(rowccfc29sog00.getSzSdsIncRsrcVerfMethod()));
          _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_12.setSize("20");
          _jspx_th_impact_validateInput_12.setMaxLength("20");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtIncRsrcDesc");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("45");
          _jspx_th_impact_validateTextArea_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(80);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph80");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(rowccfc29sog00.getSzTxtIncRsrcDesc()));
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
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<TD>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setName("txtDtDtModified");
          _jspx_th_impact_validateDate_2.setLabel("Date Modified");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setRequired("true");
          _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate(rowccfc29sog00.getDtDtIncRsrcModified()) );
          _jspx_th_impact_validateDate_2.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</TD>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspLAmtIncRsrcMonth");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Current Monthly Income");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(lAmtIncRsrcMonth);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br />\r\n\t");
/* BEGIN Admin Address Phone Submodule */
          out.write('\r');
          out.write('\n');
          out.write('	');
AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
      adminAddressPhoneSubDB.setFormName("frmIncRsrcDetail");
      adminAddressPhoneSubDB.setPageMode(overallPageMode);
      adminAddressPhoneSubDB.setAddressPhoneSectionHeader("Address and Phone Information");
      adminAddressPhoneSubDB.setAddressRequired(false);
      adminAddressPhoneSubDB.setAddressDisabled(overallPageMode.equals(PageModeConstants.VIEW));
      adminAddressPhoneSubDB.setCommentsVisible(true);
      adminAddressPhoneSubDB.setCommentsRequired(false);
      adminAddressPhoneSubDB.setCommentsDisabled(overallPageMode.equals(PageModeConstants.VIEW));
      adminAddressPhoneSubDB.setPhoneRequired(false);
      adminAddressPhoneSubDB.setPhoneDisabled(overallPageMode.equals(PageModeConstants.VIEW));
      adminAddressPhoneSubDB.setAddressSubmoduleName("");
      adminAddressPhoneSubDB.setTabIndex(tabIndex);
      AdminAddressPhoneSubDB.setIntoRequest(adminAddressPhoneSubDB, request);

      
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    AdminAddressPhoneSubDB adminAddressPhoneSubAdminAddressPhoneSubDB = AdminAddressPhoneSubDB.getFromRequest( request );
    String adminAddressPhoneSubFormName = adminAddressPhoneSubAdminAddressPhoneSubDB.getFormName();
    String adminAddressPhoneSubPageMode = adminAddressPhoneSubAdminAddressPhoneSubDB.getPageMode();
    String adminAddressPhoneSubAddressPhoneSectionHeader = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressPhoneSectionHeader();
    boolean adminAddressPhoneSubAddressRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressRequired();
    boolean adminAddressPhoneSubAddressDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressDisabled();
    boolean adminAddressPhoneSubCommentsVisible = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsVisible();
    boolean adminAddressPhoneSubCommentsRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsRequired();
    boolean adminAddressPhoneSubCommentsDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsDisabled();
    boolean adminAddressPhoneSubPhoneRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneRequired();
    boolean adminAddressPhoneSubPhoneDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneDisabled();
    String adminAddressPhoneSubAddressSubmoduleName = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressSubmoduleName();
    String expandableSectionName = adminAddressPhoneSubAddressSubmoduleName + "addPhone";
    int adminAddressPhoneSubTabIndex = adminAddressPhoneSubAdminAddressPhoneSubDB.getTabIndex();

//  boolean commentsVisible = true;

    AdminAddressPhoneBean aapBean = null;
    if ( AdminAddressPhoneBean.isInRequest( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromRequest( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else if ( AdminAddressPhoneBean.isInState( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromState( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else
    {
      aapBean = new AdminAddressPhoneBean();
    }

          out.write("\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName( expandableSectionName );
          _jspx_th_impact_ExpandableSectionTag_0.setId(AdminAddressPhoneBean.PHONE + "_Id" );
          _jspx_th_impact_ExpandableSectionTag_0.setLabel( adminAddressPhoneSubAddressPhoneSectionHeader );
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( adminAddressPhoneSubTabIndex );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr>\r\n          <td width=\"10%\">\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) );
              _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatPhone( aapBean.getPhone() ) );
              _jspx_th_impact_validateInput_13.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_13.setType("text");
              _jspx_th_impact_validateInput_13.setRequired( String.valueOf( adminAddressPhoneSubPhoneRequired ));
              _jspx_th_impact_validateInput_13.setLabel("Phone");
              _jspx_th_impact_validateInput_13.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setConstraint("Phone");
              _jspx_th_impact_validateInput_13.setWidth("45%");
              _jspx_th_impact_validateInput_13.setSize("14");
              _jspx_th_impact_validateInput_13.setMaxLength("14");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"15%\">\r\n             ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_14.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) );
              _jspx_th_impact_validateInput_14.setValue( aapBean.getPhoneExt() );
              _jspx_th_impact_validateInput_14.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_14.setType("text");
              _jspx_th_impact_validateInput_14.setLabel("Extension");
              _jspx_th_impact_validateInput_14.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_14.setWidth("30%");
              _jspx_th_impact_validateInput_14.setSize("8");
              _jspx_th_impact_validateInput_14.setMaxLength("8");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n     </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n");
/* BEGIN Address Submodule */
              out.write('\r');
              out.write('\n');

    AddressSubDB adminAddressPhoneAddressSubDB = new AddressSubDB();
    adminAddressPhoneAddressSubDB.setFormName( adminAddressPhoneSubFormName );
    adminAddressPhoneAddressSubDB.setPageMode( adminAddressPhoneSubPageMode );
    adminAddressPhoneAddressSubDB.setAddressSubmoduleName( adminAddressPhoneSubAddressSubmoduleName );
    adminAddressPhoneAddressSubDB.setCommentsVisible( adminAddressPhoneSubCommentsVisible );
    adminAddressPhoneAddressSubDB.setCommentsRequired( adminAddressPhoneSubCommentsRequired );
    adminAddressPhoneAddressSubDB.setCommentsDisabled( adminAddressPhoneSubCommentsDisabled );
    adminAddressPhoneAddressSubDB.setAddressRequired( adminAddressPhoneSubAddressRequired );
    adminAddressPhoneAddressSubDB.setAddressDisabled( adminAddressPhoneSubAddressDisabled );
    adminAddressPhoneAddressSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
    AddressSubDB.setIntoRequest( adminAddressPhoneAddressSubDB, request );

              out.write("\r\n        ");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_15.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_15.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_15.setType("text");
              _jspx_th_impact_validateInput_15.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_15.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_15.setLabel("Street");
              _jspx_th_impact_validateInput_15.setWidth("45%");
              _jspx_th_impact_validateInput_15.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setConstraint("Address");
              _jspx_th_impact_validateInput_15.setSize("50");
              _jspx_th_impact_validateInput_15.setMaxLength("30");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_16.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_16.setType("text");
              _jspx_th_impact_validateInput_16.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_16.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setConstraint("Address");
              _jspx_th_impact_validateInput_16.setSize("50");
              _jspx_th_impact_validateInput_16.setMaxLength("30");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_17.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_17.setType("text");
              _jspx_th_impact_validateInput_17.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_17.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_17.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_17.setLabel("City");
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setConstraint("City");
              _jspx_th_impact_validateInput_17.setMaxLength("20");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_2.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_2.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_2.setOnChange( onChange );
              _jspx_th_impact_validateSelect_2.setLabel("State");
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_18.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_18.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_18.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_18.setType("text");
              _jspx_th_impact_validateInput_18.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_18.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_18.setLabel("Zip");
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setConstraint("Zip");
              _jspx_th_impact_validateInput_18.setMaxLength("5");
              _jspx_th_impact_validateInput_18.setSize("5");
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_19.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_19.setType("text");
              _jspx_th_impact_validateInput_19.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_19.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_19.setMaxLength("4");
              _jspx_th_impact_validateInput_19.setSize("4");
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_3.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_3.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_3.setBlankValue("true");
              _jspx_th_impact_validateSelect_3.setLabel("County");
              _jspx_th_impact_validateSelect_3.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_3.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_3.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_1.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_1.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_1.setCols("125");
              _jspx_th_impact_validateTextArea_1.setRows("4");
              _jspx_th_impact_validateTextArea_1.setColspan("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_0.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_0.setAction("#");
              _jspx_th_impact_ButtonTag_0.setFunction(onclick);
              _jspx_th_impact_ButtonTag_0.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_0.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_0.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_20(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_21(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("hidden");
              _jspx_th_impact_validateInput_22.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_22.setValue("true");
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setType("hidden");
              _jspx_th_impact_validateInput_23.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_23.setValue("true");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setType("hidden");
              _jspx_th_impact_validateInput_24.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_24.setValue("");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_25.setType("hidden");
              _jspx_th_impact_validateInput_25.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_25.setValue("");
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write('\r');
              out.write('\n');

    adminAddressPhoneSubTabIndex = adminAddressPhoneAddressSubDB.getTabIndex();
    AddressSubDB.removeFromRequest( request );

              out.write('\r');
              out.write('\n');
/* END Address Submodule */
              out.write("\r\n     </td>\r\n   </tr>\r\n </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    adminAddressPhoneSubAdminAddressPhoneSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write('	');
tabIndex = adminAddressPhoneSubDB.getTabIndex();
      AdminAddressPhoneSubDB.removeFromRequest(request);

      
          out.write('\r');
          out.write('\n');
          out.write('	');
/* END Admin Address Phone Submodule */
          out.write("\r\n\t<br />\r\n\t<hr>\r\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setForm("frmIncRsrcDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/person/PersonDetail/saveIncRsrc");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t");
/*  Always include this hidden field in your form */

      
          out.write("\r\n\t<input type=\"hidden\" name=\"");
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
/* Close Validate Form Custom Tag */

      
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");

  if ( !( overallPageMode.equals(PageModeConstants.VIEW) ) )
  {

      out.write("\r\n  updateType();\r\n  frmIncRsrcDetail.selSzCdIncRsrcType.value='");
      out.print(szCdIncRsrcType);
      out.write("';\r\n  CleanSelect( frmIncRsrcDetail.selSzCdIncRsrcType );\r\n//End Java Script\r\n");
  } 
      out.write("\r\n</script>\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmIncRsrcDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_20(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_20.setType("hidden");
    _jspx_th_impact_validateInput_20.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_20.setValue("0");
    int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
    if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_21(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    _jspx_th_impact_validateInput_21.setType("hidden");
    _jspx_th_impact_validateInput_21.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_21.setValue("0");
    int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
    if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
