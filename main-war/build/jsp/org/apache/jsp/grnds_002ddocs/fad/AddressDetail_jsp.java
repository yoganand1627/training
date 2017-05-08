package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

public final class AddressDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     AddressDetail.jsp
//*  Created by:   Heather Dean
//*  Date Created: 2/21/03
//*
//*
//*  Description:
//*              This page allows a user to edit and delete the Address Detail
//*              information.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
  06/16/04  gerryc            SIR 16091 - Added VendorID constraint to Vendor
                              ID fields.  Vendor ID must be 14 characters,
                              starting with 11 numbers.  Using the resource
                              AddressDetailCustomValidation class for the form
                              validation.
  02/01/07  aodutayo          Making SHINES changes. Changed default State to GA
                              from GA.Removed School District from page
  09/12/11  charden           STGAP00017058 - Modified code so that Vendor ID is 
                              editable for Fiscal Ops users
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String addressSubmoduleName = "";
  AddressBean addressBean = new AddressBean(addressSubmoduleName);
  addressBean.setAddressSubmoduleName(addressSubmoduleName);
  String address1Name = addressBean.getAttributeName( AddressBean.ADDRESS1 );
  String address2Name = addressBean.getAttributeName( AddressBean.ADDRESS2 );
  String cityName = addressBean.getAttributeName( AddressBean.CITY );
  String stateName = addressBean.getAttributeName( AddressBean.STATE );
  String zipName = addressBean.getAttributeName( AddressBean.ZIP );
  String zipSuffName = addressBean.getAttributeName( AddressBean.ZIP_SUFF );
  String countyName = addressBean.getAttributeName( AddressBean.COUNTY );

  String TRACE_TAG = "AddressDetail.jsp";
  int txtUlIdResourceAddress = 0;
  int iIndex = 0;
  int iUlIdRsrcAddress = 0;
  Date dateTsLastUpdate = null;
  String txtSzAddrRsrcAddrAttn = "";
  String txtSzAddrRsrcAddrStLn1 = "";
  String txtSzAddrRsrcAddrStLn2 = "";
  String txtSzAddrRsrcAddrZip = "";
  String txtSzAddrRsrcAddrZipSuff = "";
  String txtSzAddrRsrcAddrCity = "";
  String txtSzCdFacilityState = "GA";
  String txtSzCdFacilityCounty = "";
  String txtSzCdRsrcAddrRegion = "";
  String onPageLoadVid = "";
  String txtSzNbrRsrcAddrVid = "";
  String txtszTxtRsrcAddrComments = "";
  String txtSzCdRsrcAddrType = "";
  String szCReqFuncCd = "";
  String classResource = "false";
  String fadResource = "false";
  String schoolResource = "false";
  String vendorId = "";
  String cbxCIndRsrcTransport = "0";
  String endDateMod = "N";
  String pageMode = PageModeConstants.VIEW;
  List excludePrimaryOption = new ArrayList();
  String limitedEdit = "false";
  String addressTypeDisabled = "false";
  String vendorIdDisabled = "false";
  String attentionDisabled = "false";
  String streetLn1Disabled = "false";
  String streetLn2Disabled = "false";
  String cityDisabled = "false";
  String stateDisabled = "false";
  String zipDisabled = "false";
  String countyDisabled = "false";
  String commentsDisabled = "false";
  String validated = "";
  String onlyButton = "false";
  boolean validateButtonHide = false;
  boolean saveButtonHide = false;
  boolean deleteButtonHide = false;
  boolean displayRegionField = true;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  boolean editPlusVendorId = false;

  if( PageMode.getPageMode( request ) != null ){
    pageMode = PageMode.getPageMode( request );
  }

  // STGAP00017058 - set pagemode to edit for fiscal ops users
  if(request.getAttribute("editPlus") != null){
    editPlusVendorId = true;
    pageMode = PageModeConstants.EDIT;
  }
  

  // Get fields from request in case of error being returned to page or page reloading to populate school district
  if( request.getParameter("txtSzAddrRsrcAddrAttn") != null )
  {
    txtSzAddrRsrcAddrAttn = request.getParameter("txtSzAddrRsrcAddrAttn");
  }
  if( request.getParameter(address1Name) != null )
  {
    txtSzAddrRsrcAddrStLn1 = request.getParameter(address1Name);
  }
  if( request.getParameter(address2Name) != null )
  {
    txtSzAddrRsrcAddrStLn2 = request.getParameter(address2Name);
  }
  if( request.getParameter(zipName) != null )
  {
    txtSzAddrRsrcAddrZip = request.getParameter(zipName);
  }
  if( request.getParameter(zipSuffName) != null )
  {
    txtSzAddrRsrcAddrZipSuff = request.getParameter(zipSuffName);
  }
  if( request.getParameter(cityName) != null )
  {
    txtSzAddrRsrcAddrCity = request.getParameter(cityName);
  }
  if( request.getParameter(stateName) != null )
  {
    txtSzCdFacilityState = request.getParameter(stateName);
  }
  if( request.getParameter(countyName) != null )
  {
    txtSzCdFacilityCounty = request.getParameter(countyName);
  }
  if( request.getParameter("txtNbrRsrcAddrVid") != null )
  {
    txtSzNbrRsrcAddrVid = request.getParameter("txtNbrRsrcAddrVid");
  }
  if( request.getParameter("txtszTxtRsrcAddrComments") != null )
  {
    txtszTxtRsrcAddrComments = request.getParameter("txtszTxtRsrcAddrComments");
  }
  if( request.getParameter("selCdRsrcAddrType") != null )
  {
    txtSzCdRsrcAddrType = request.getParameter("selCdRsrcAddrType");
  }

  /**-HIDDEN FIELDS-*/
    szCReqFuncCd = ContextHelper.getStringSafe( request, "szCReqFuncCd");

  if( request.getParameter("validated") != null )
  {
    validated = request.getParameter("validated");
  }
  else 
  {
    if ("U".equalsIgnoreCase(szCReqFuncCd) )
    {
      validated = "true";
    }
    else
    {
      validated = "false";
    }
  }
    txtUlIdResourceAddress = ContextHelper.getIntSafe( request, "txtUlIdResourceAddress" );
    iUlIdRsrcAddress = ContextHelper.getIntSafe( request, "iUlIdRsrcAddress" );
    dateTsLastUpdate = ContextHelper.getJavaDateSafe( request, "txtTsLastUpdate" );

    vendorId = ContextHelper.getStringSafe( request, "vendorId" );
    onPageLoadVid = ContextHelper.getStringSafe( request, "onPageLoadVendorId" );
    iIndex = ContextHelper.getIntSafe( request, "rbAddressRadioIndex" );

    cbxCIndRsrcTransport = ContextHelper.getStringSafe( request, "cbxCIndRsrcTransport" );


  CFAD07SO cfad07so = (CFAD07SO) state.getAttribute( "CFAD07SO" , request );

  if ( cfad07so != null )
  {
    endDateMod = cfad07so.getBIndEndDateMod();
  }

  if ("A".equalsIgnoreCase(szCReqFuncCd))
  {
    txtSzCdFacilityState = "GA";
  }

  ROWCFAD07SOG01 addressRow = (ROWCFAD07SOG01) state.getAttribute("currentAddress", request );

  // If address row has been returned from conversation
  if( addressRow != null )
  {
      txtUlIdResourceAddress = addressRow.getUlIdRsrcAddress();
      iIndex = ContextHelper.getIntSafe( request, "addressArrayIndex" );
      txtSzCdRsrcAddrType = addressRow.getSzCdRsrcAddrType();
      iUlIdRsrcAddress = addressRow.getUlIdRsrcAddress();
      dateTsLastUpdate = addressRow.getTsLastUpdate();
      txtSzAddrRsrcAddrAttn = addressRow.getSzAddrRsrcAddrAttn();
      txtSzAddrRsrcAddrStLn1 = addressRow.getSzAddrRsrcAddrStLn1();
      txtSzAddrRsrcAddrStLn2 = addressRow.getSzAddrRsrcAddrStLn2();
      txtSzAddrRsrcAddrZip = addressRow.getSzAddrRsrcAddrZip();
      if( txtSzAddrRsrcAddrZip.length() > 5 )
      {
        int dashIndex = 5;
        if( txtSzAddrRsrcAddrZip.indexOf("-") > 0)
        {
          dashIndex = txtSzAddrRsrcAddrZip.indexOf("-") + 1;
        }
        txtSzAddrRsrcAddrZipSuff = txtSzAddrRsrcAddrZip.substring( dashIndex, txtSzAddrRsrcAddrZip.length() );
        txtSzAddrRsrcAddrZip = txtSzAddrRsrcAddrZip.substring( 0, 5 );
      }
      txtSzAddrRsrcAddrCity = addressRow.getSzAddrRsrcAddrCity();
      txtSzCdFacilityState = addressRow.getSzCdFacilityState();
      if ("".equals(txtSzCdFacilityCounty) )
      {
       txtSzCdFacilityCounty = addressRow.getSzCdFacilityCounty();
      }
      //get the region given the county
      txtSzCdRsrcAddrRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, addressRow.getSzCdFacilityCounty()); 
      if(txtSzCdRsrcAddrRegion.startsWith("0")){
         txtSzCdRsrcAddrRegion = txtSzCdRsrcAddrRegion.substring(1);
      }
      
      txtSzNbrRsrcAddrVid = addressRow.getSzNbrRsrcAddrVid();

      txtszTxtRsrcAddrComments = addressRow.getSzTxtRsrcAddrComments();
      //Capture the Vid on page load
      onPageLoadVid = txtSzNbrRsrcAddrVid;
  }
  else
  {
    deleteButtonHide = true;
  }
    //If address type is primary make address type field disabled.
    if( txtSzCdRsrcAddrType.equals( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY ) && "U".equals(szCReqFuncCd) )
    {
      addressTypeDisabled = "true";
      deleteButtonHide = true;
    }

    if( ("A".equals(szCReqFuncCd) ) || ("U".equals(szCReqFuncCd) &&
                                        !txtSzCdRsrcAddrType.equals( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY )) )
    {
      excludePrimaryOption.add( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY );
      deleteButtonHide = true;
    }

  //Hide delete button in Add mode
  if("A".equals(szCReqFuncCd) )
  {
    deleteButtonHide = true;
    displayRegionField = false;
  }
  //Hide buttons if in view mode
  if( pageMode.equals(PageModeConstants.VIEW) )
  {
    deleteButtonHide = true;
    saveButtonHide = true;
    validateButtonHide = true;
  }

  int tabIndex = 1;

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n<script language=\"JavaScript\">\r\n\r\nfunction unValidate()\r\n{\r\n  document.frmAddressDetail.validated.value=\"false\";\r\n}\r\n\r\nfunction checkState()\r\n{\r\n  if (document.frmAddressDetail.selCdFacilityState.value != 'GA')\r\n  {\r\n    document.frmAddressDetail.selCdFacilityCounty.value = 999;\r\n  }\r\n  else\r\n  {\r\n    document.frmAddressDetail.selCdFacilityCounty.value = '';\r\n  }\r\n}\r\n\r\n\r\n\r\n\r\n /*\r\n  *This function is called before the page unloads.\r\n  */\r\nwindow.onbeforeunload = function ()\r\n{\r\n    IsDirty();\r\n};\r\n\r\n// STGAP00017058 - creating confirmation message\r\nvar editPlus = ");
      out.print( editPlusVendorId );
      out.write(";\r\nfunction confirmVendorIdEdit(){\r\n  if(editPlus){\r\n\tif(confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_UPDT_VERIF) );
      out.write("')){\r\n\t\treturn validateAddressOnSave('frmAddressDetail', '/fad/HomeInfrmtn/saveAddressDetail', '");
      out.print( addressBean.getAddressSubmoduleName() );
      out.write("', 'btnSaveAddressRow');\r\n\t}else{\r\n\t\treturn false;\r\n\t}\r\n  }else{\r\n  \t\treturn validateAddressOnSave('frmAddressDetail', '/fad/HomeInfrmtn/saveAddressDetail', '");
      out.print( addressBean.getAddressSubmoduleName() );
      out.write("', 'btnSaveAddressRow');\r\n  }\r\n}\r\n\r\n\r\n\r\nfunction openValidateWindowValidate()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  x.hdnSaveOrValidate.value = 'validate';\r\n  openValidateWindow();\r\n}\r\n\r\nfunction openValidateWindowSave()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  x.hdnSaveOrValidate.value = 'save';\r\n  openValidateWindow();\r\n}\r\n\r\n/*\r\n *This function opens the address validation window.\r\n */\r\nfunction openValidateWindow()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  var streetLn1 = escape( x.txtSzAddrRsrcAddrStLn1.value.replace('#', ' '));\r\n  var streetLn2 = escape( x.txtSzAddrRsrcAddrStLn2.value.replace('#', ' '));\r\n  var city = escape( x.txtSzAddrRsrcAddrCity.value.replace('#', ' '));\r\n  var zip = escape( x.txtSzAddrRsrcAddrZip.value.replace('#', ' '));\r\n  window.open('/common/AddressValidation/validate?txtSzAddrRsrcAddrStLn1='+streetLn1+'&txtSzAddrRsrcAddrStLn2='+streetLn2+'&txtSzAddrRsrcAddrCity='+city+'&selCdFacilityState='+x.selCdFacilityState.value+'&txtSzAddrRsrcAddrZip='+zip+'&selCdFacilityCounty='+x.selCdFacilityCounty.value+'&frmWindowName='+x.frmWindowName.value+'&addressMultCounty='+x.addressMultCounty.value+'&");
      out.print( AddressBean.SAVE_OR_VALIDATE );
      out.write("='+x.hdnSaveOrValidate.value,\r\n              'newWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=400,height=250');\r\n}\r\n\r\nfunction saveWithValidate()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  if ( x.validated.value == 'false')\r\n  {\r\n    openValidateWindowSave();\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    return saveAddressDetailWindow();\r\n  }\r\n}\r\n\r\n /*\r\n  *This function is called when address detail is saved.\r\n  */\r\nfunction saveAddressDetailWindow()\r\n{\r\n  window.onbeforeunload = null;\r\n  var x = document.frmAddressDetail;\r\n\r\n  if( (x.vendorId.value != \"\") && (x.txtNbrRsrcAddrVid.value != \"\") && (x.vendorId.value != x.txtNbrRsrcAddrVid.value) )\r\n  {\r\n    //MSG - This Vendor ID already exists for the resource and cannot be repeated.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_RES_UNIQUE_VID ));
      out.write("\");\r\n  }\r\n\r\n  else\r\n  {\r\n    if ( x.countyChanged.value == 'true' && x.endDateMod == 'Y' )\r\n    {\r\n      alert(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FAD_OVERWRITE_CONTRACT ) );
      out.write("\");\r\n    }\r\n    x.action = \"/fad/HomeInfrmtn/displayAddressDetail\";\r\n    submitValidateForm( \"frmAddressDetail\", \"/fad/HomeInfrmtn/saveAddressDetail\" );\r\n    return false;\r\n  }\r\n\r\n  return false;\r\n}\r\n\r\n /*\r\n  *This function is called when an address is deleted.\r\n  */\r\nfunction deleteAddressRow()\r\n{\r\n  var doDelete = false;\r\n  window.onbeforeunload = null;\r\n  var x = document.frmAddressDetail;\r\n  if( x.txtNbrRsrcAddrVid.value != \"\" )\r\n  {\r\n    //MSG - An address record with a Vendor ID may not be deleted.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_RES_VID_ADDR));
      out.write("\");\r\n  }\r\n  else if( x.selCdRsrcAddrType.value ==  HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY  )\r\n  {\r\n    //MSG - You may not delete the primary address of a resource.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_ADDRESS_NO_DELETE));
      out.write("\");\r\n  }\r\n  else\r\n  {\r\n      var confirm = window.confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("\")\r\n      if(confirm)\r\n      {\r\n        disableValidation(\"frmAddressDetail\");\r\n        x.cReqFuncCd.value =\"D\";\r\n        doDelete = true;\r\n      }\r\n  }\r\n\r\n  return doDelete;\r\n}\r\n\r\n\r\n</script>\r\n\r\n");

  if ( deleteButtonHide )
  {
    onlyButton = "true";
  }

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAddressDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/HomeInfrmtn/saveAddressDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.AddressDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("validated");
          _jspx_th_impact_validateInput_0.setValue( validated );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("iUlIdRsrcAddress");
          _jspx_th_impact_validateInput_2.setValue(String.valueOf(iUlIdRsrcAddress));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("txtUlIdResourceAddress");
          _jspx_th_impact_validateInput_3.setValue(String.valueOf(txtUlIdResourceAddress));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("rbAddressRadioIndex");
          _jspx_th_impact_validateInput_4.setValue(String.valueOf(iIndex));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("szCReqFuncCd");
          _jspx_th_impact_validateInput_6.setValue(szCReqFuncCd);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("txtTsLastUpdate");
          _jspx_th_impact_validateInput_7.setValue(String.valueOf(dateTsLastUpdate));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("vendorId");
          _jspx_th_impact_validateInput_11.setValue(vendorId);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnCdFacilityCounty");
          _jspx_th_impact_validateInput_12.setValue(StringHelper.getNonNullString(txtSzCdFacilityCounty));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("endDateMod");
          _jspx_th_impact_validateInput_13.setValue( endDateMod );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          if (_jspx_meth_impact_validateInput_14(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("onPageLoadVendorId");
          _jspx_th_impact_validateInput_15.setValue(onPageLoadVid);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("fadResource");
          _jspx_th_impact_validateInput_16.setValue(fadResource);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("cbxCIndRsrcTransport");
          _jspx_th_impact_validateInput_17.setValue(cbxCIndRsrcTransport);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     \r\n\r\n");
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n   <tr>\r\n     <th colspan = \"6\">\r\n       Address Information\r\n     </th>\r\n   </tr>\r\n   <tr>\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCdRsrcAddrType");
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setDisabled(addressTypeDisabled );
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludePrimaryOption);
          _jspx_th_impact_validateSelect_0.setCodesTable("CRSCADDR");
          _jspx_th_impact_validateSelect_0.setValue(txtSzCdRsrcAddrType);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>&nbsp;</td>\r\n     <td>&nbsp;</td>\r\n   </tr>\r\n   ");

   //STGAP00017058 - make vendor id modifiable for fiscal ops
   if(!editPlusVendorId){
   
          out.write("\r\n   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("txtNbrRsrcAddrVid");
          _jspx_th_impact_validateInput_19.setValue(txtSzNbrRsrcAddrVid);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setName("txtNbrRsrcAddrVidDisplay");
          _jspx_th_impact_validateInput_20.setLabel("Vendor ID");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setValue(txtSzNbrRsrcAddrVid);
          _jspx_th_impact_validateInput_20.setConstraint("VendorID");
          _jspx_th_impact_validateInput_20.setDisabled("true");
          _jspx_th_impact_validateInput_20.setMaxLength("8");
          _jspx_th_impact_validateInput_20.setSize("8");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          out.write("\r\n    </td>\r\n    ");
 
    }else{
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("vidChanged");
          _jspx_th_impact_validateInput_21.setValue( editPlusVendorId == true ? "true" : "false" );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setName("txtNbrRsrcAddrVid");
          _jspx_th_impact_validateInput_22.setLabel("Vendor ID");
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setValue(txtSzNbrRsrcAddrVid);
          _jspx_th_impact_validateInput_22.setDisabled("false");
          _jspx_th_impact_validateInput_22.setConstraint("VendorID");
          _jspx_th_impact_validateInput_22.setMaxLength("8");
          _jspx_th_impact_validateInput_22.setSize("8");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    ");
 
    }
    
          out.write("\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setName("txtSzAddrRsrcAddrAttn");
          _jspx_th_impact_validateInput_23.setLabel("Attention");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setValue(txtSzAddrRsrcAddrAttn);
          _jspx_th_impact_validateInput_23.setConstraint("Name");
          _jspx_th_impact_validateInput_23.setDisabled(attentionDisabled);
          _jspx_th_impact_validateInput_23.setSize("30");
          _jspx_th_impact_validateInput_23.setMaxLength("30");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n");

  String addressOnChange = "javascript:changeValidAddress('frmAddressDetail', '"+ addressBean.getAddressSubmoduleName() +"')";

          out.write("   \r\n   <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("text");
          _jspx_th_impact_validateInput_24.setRequired("true");
          _jspx_th_impact_validateInput_24.setName( address1Name );
          _jspx_th_impact_validateInput_24.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_24.setLabel("Address Ln 1");
          _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setDisabled(streetLn1Disabled);
          _jspx_th_impact_validateInput_24.setConstraint("Address");
          _jspx_th_impact_validateInput_24.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn1));
          _jspx_th_impact_validateInput_24.setSize("30");
          _jspx_th_impact_validateInput_24.setMaxLength("30");
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("text");
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_25.setName( address2Name );
          _jspx_th_impact_validateInput_25.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_25.setLabel("Address Ln 2");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setDisabled(streetLn2Disabled);
          _jspx_th_impact_validateInput_25.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn2));
          _jspx_th_impact_validateInput_25.setSize("30");
          _jspx_th_impact_validateInput_25.setConstraint("Address");
          _jspx_th_impact_validateInput_25.setMaxLength("30");
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("text");
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setRequired("true");
          _jspx_th_impact_validateInput_26.setName( cityName );
          _jspx_th_impact_validateInput_26.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_26.setLabel("City");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setDisabled(cityDisabled);
          _jspx_th_impact_validateInput_26.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrCity));
          _jspx_th_impact_validateInput_26.setConstraint("City");
          _jspx_th_impact_validateInput_26.setSize("20");
          _jspx_th_impact_validateInput_26.setMaxLength("20");
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n   <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName( stateName );
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setOnChange( addressOnChange +"; checkState();");
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_1.setDisabled(stateDisabled);
          _jspx_th_impact_validateSelect_1.setValue(StringHelper.getNonNullString(txtSzCdFacilityState));
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("text");
          _jspx_th_impact_validateInput_27.setName( zipName );
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_27.setLabel("Zip");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setRequired("true");
          _jspx_th_impact_validateInput_27.setDisabled(zipDisabled);
          _jspx_th_impact_validateInput_27.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrZip));
          _jspx_th_impact_validateInput_27.setConstraint("Digit5");
          _jspx_th_impact_validateInput_27.setMaxLength("5");
          _jspx_th_impact_validateInput_27.setSize("5");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        -\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("text");
          _jspx_th_impact_validateInput_28.setName( zipSuffName );
          _jspx_th_impact_validateInput_28.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setDisabled(zipDisabled);
          _jspx_th_impact_validateInput_28.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrZipSuff));
          _jspx_th_impact_validateInput_28.setConstraint("Digit4");
          _jspx_th_impact_validateInput_28.setMaxLength("4");
          _jspx_th_impact_validateInput_28.setSize("4");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  ");
if( !validateButtonHide ){
      String function = "javascript:setIsDirtyCalled(true);" +
                        "launchAddressValidate('frmAddressDetail', 'validate', '" +
                        addressBean.getAddressSubmoduleName() + "');return false;";
  
          out.write("  \r\n    &nbsp;");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidateAddressRow");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction(function);
          _jspx_th_impact_ButtonTag_0.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/fad/HomeInfrmtn/displayAddressDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
}
          out.write("\r\n    </td>\r\n   </tr>\r\n   <tr>\r\n     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName( countyName );
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setDisabled(countyDisabled);
          _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_2.setOnChange( addressOnChange );
          _jspx_th_impact_validateSelect_2.setValue(StringHelper.getNonNullString(txtSzCdFacilityCounty));
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td>\r\n       ");
if(displayRegionField){
          out.write("\r\n       ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtRegion");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Region");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(txtSzCdRsrcAddrRegion);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
} else{
          out.write("\r\n        &nbsp;&nbsp;\r\n        ");
}
          out.write("\r\n     </td>\r\n   </tr>\r\n   <tr>\r\n     <td class=\"formLabel\" colspan=\"1\" valign=\"top\">Comments:</td>\r\n     <td colspan=3>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtszTxtRsrcAddrComments");
          _jspx_th_impact_validateTextArea_0.setCols("120");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled(commentsDisabled);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph80");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(StringHelper.getNonNullString(txtszTxtRsrcAddrComments));
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n <tr>\r\n  <td align=\"left\">\r\n    ");
if( !deleteButtonHide ){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDeleteAddressRow");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setFunction("return deleteAddressRow();");
          _jspx_th_impact_ButtonTag_1.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/fad/HomeInfrmtn/deleteAddressRow");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
} else{
          out.write("\r\n       &nbsp;\r\n    ");
}
          out.write("\r\n  </td>\r\n  <td align=\"right\">\r\n    ");
if( !saveButtonHide ){
    String saveFunction = "return confirmVendorIdEdit();";
    
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAddressRow");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setFunction( saveFunction );
          _jspx_th_impact_ButtonTag_2.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setAction("/fad/HomeInfrmtn/saveAddressDetail");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
} else{
          out.write("\r\n     &nbsp;\r\n   ");
}
          out.write("\r\n  </td>\r\n </tr>\r\n</table>\r\n");
          if (_jspx_meth_impact_validateInput_29(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_30(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("hidden");
          _jspx_th_impact_validateInput_31.setName( AddressBean.ADDRESS_SUBMODULE_NAME );
          _jspx_th_impact_validateInput_31.setValue( addressBean.getAddressSubmoduleName() );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("hidden");
          _jspx_th_impact_validateInput_32.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_32.setValue("true");
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("hidden");
          _jspx_th_impact_validateInput_33.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
          _jspx_th_impact_validateInput_33.setValue("true");
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("hidden");
          _jspx_th_impact_validateInput_34.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_34.setValue("");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("hidden");
          _jspx_th_impact_validateInput_35.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_35.setValue("");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
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
      out.write("\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnSaveOrValidate");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("WindowName");
    _jspx_th_impact_validateInput_5.setValue("frmAddressDetail");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("frmWindowName");
    _jspx_th_impact_validateInput_8.setValue("frmAddressDetail");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("validationOverride");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("isFirstLoad");
    _jspx_th_impact_validateInput_10.setValue("true");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_14.setType("hidden");
    _jspx_th_impact_validateInput_14.setName("countyChanged");
    _jspx_th_impact_validateInput_14.setValue("");
    int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
    if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_18.setType("hidden");
    _jspx_th_impact_validateInput_18.setName("addressMultCounty");
    _jspx_th_impact_validateInput_18.setValue("");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_29(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_29.setType("hidden");
    _jspx_th_impact_validateInput_29.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_29.setValue("0");
    int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
    if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_30(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_30.setType("hidden");
    _jspx_th_impact_validateInput_30.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_30.setValue("0");
    int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
    if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
