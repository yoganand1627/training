package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
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


/**
 * JSP Name:     AddressDetail.jsp
 * Created by:   Habib
 * Date Created: 07/30/02
 *
 * Description:
 * The Address Detail page displays detailed address information for the
 * resource selected on the Resource Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  05/04/04  gerryc            SIR 16091 - Added VendorID constraint to Vendor ID
                              field.  Vendor ID must be 14 characters, starting
                              with 11 numbers.
  09/12/11  charden           STGAP00017058 - Modified code so that Vendor ID is 
                              editable for Fiscal Ops users
  *** abgoode ********************************************************************
  NOTE: CURRENT VERSION OF SAVING STILL EXECUTES CUSTOM VALIDATION AND CONSTRAINTS
  VALIDATION (AND DOES NOT SAVE IF INVALID), BUT BECAUSE OF A JAVASCRIPT ERROR ON
  THE PAGE, THE ERROR MESSAGES DO NOT DISPLAY.
  ********************************************************************************
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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


  //String TRACE_TAG = "AddressDetail.jsp";
  ROWCRES03SOG00 addressRow = (ROWCRES03SOG00)request.getAttribute( "addressDetail" );
// SR- retain this in case of validaiton failure -->request.removeAttribute( "addressDetail" );
  int txtUlIdResource = 0;
  String iIndex = "";
  int iUlIdRsrcAddress = 0;
  Date dateTsLastUpdate = null;
  String txtSzAddrRsrcAddrAttn = "";
  String txtSzAddrRsrcAddrStLn1 = "";
  String txtSzAddrRsrcAddrStLn2 = "";
  String txtSzAddrRsrcAddrZip = "";
  String txtSzAddrRsrcAddrZipSuff = "";
  String txtSzAddrRsrcAddrCity = "";
  String txtSzCdFacilityState = "";
  String txtSzCdFacilityCounty = "";
  String txtSzCdRsrcAddrRegion = "";
  String onPageLoadVid = "";
  String txtSzNbrRsrcAddrVid = "";
  String txtszTxtRsrcAddrComments = "";
  String txtSzCdRsrcAddrType = "";
  String szCReqFuncCd = "";
  String classResource = "false";
  String fadResource = "false";
  String vendorId = "";
  String contracted = "";
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
  String schoolDistrictDisabled = "false";
  String commentsDisabled = "false";
  String validated = "";
  boolean validateButtonHide = false;
  boolean saveButtonHide = false;
  boolean deleteButtonHide = false;
  boolean displayRegionField = true;
  boolean editPlusVendorId = false;

  String pageMode = PageMode.getPageMode(request);


  //STGAP00017058 - set page mode if user is in Fiscal Ops security class
  if(request.getAttribute("editPlus") != null){
    editPlusVendorId = true;
    pageMode = PageModeConstants.EDIT;
  }
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
  if( request.getParameter("cReqFuncCd") != null )
  {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

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

  txtUlIdResource = GlobalData.getUlIdResource( request );
  if( request.getParameter("iUlIdRsrcAddress") != null && !"".equals(request.getParameter("iUlIdRsrcAddress")) )
  {
    iUlIdRsrcAddress = new Integer(request.getParameter("iUlIdRsrcAddress"));
  }

  if( request.getParameter("txtTsLastUpdate") != null )
  {
    dateTsLastUpdate = (Date) SerializationHelper.deserializeObject(request.getParameter("txtTsLastUpdate"));
  }

  if( request.getParameter("vendorId") != null )
  {
    vendorId = request.getParameter("vendorId");
  }
  if( request.getParameter("onPageLoadVendorId") != null )
  {
    onPageLoadVid = request.getParameter("onPageLoadVendorId");
  }
  if( StringHelper.isValid(request.getParameter("rbAddressRadioIndex")) )
  {
    iIndex = request.getParameter("rbAddressRadioIndex");
  }
  if( request.getParameter("contracted") != null )
  {
    contracted = request.getParameter("contracted");
  }

  // If address row has been returned from conversation
  if( addressRow != null )
  {
    if ("A".equalsIgnoreCase(szCReqFuncCd))
    {
      txtSzCdFacilityState = "GA";
    } else
    {
      txtUlIdResource = addressRow.getUlIdResource();
      iIndex = request.getParameter("indexNum");
      txtSzCdRsrcAddrType = addressRow.getSzCdRsrcAddrType();
      iUlIdRsrcAddress = addressRow.getUlIdRsrcAddress();
      dateTsLastUpdate = addressRow.getTsLastUpdate();
      txtSzAddrRsrcAddrAttn = addressRow.getSzAddrRsrcAddrAttn();
      txtSzAddrRsrcAddrStLn1 = addressRow.getSzAddrRsrcAddrStLn1();
      txtSzAddrRsrcAddrStLn2 = addressRow.getSzAddrRsrcAddrStLn2();
      txtSzAddrRsrcAddrZip = addressRow.getSzAddrRsrcAddrZip();
      if( txtSzAddrRsrcAddrZip.length() > 5 )
      {
        int dashIndex = 6;
        if( txtSzAddrRsrcAddrZip.indexOf("-") > 0)
        {
          dashIndex = txtSzAddrRsrcAddrZip.indexOf("-") + 1;
        }
        txtSzAddrRsrcAddrZipSuff = txtSzAddrRsrcAddrZip.substring( dashIndex, txtSzAddrRsrcAddrZip.length() );
        txtSzAddrRsrcAddrZip = txtSzAddrRsrcAddrZip.substring( 0, 5 );
      }
      txtSzAddrRsrcAddrCity = addressRow.getSzAddrRsrcAddrCity();
      txtSzCdFacilityState = addressRow.getSzCdFacilityState();
      txtSzCdFacilityCounty = addressRow.getSzCdFacilityCounty();
      //get the region given the county
      txtSzCdRsrcAddrRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, addressRow.getSzCdFacilityCounty()); 
      if(txtSzCdRsrcAddrRegion.length() == 3 && txtSzCdRsrcAddrRegion.startsWith("0")){
         txtSzCdRsrcAddrRegion = txtSzCdRsrcAddrRegion.substring(1);
      }      
      txtSzNbrRsrcAddrVid = addressRow.getSzNbrRsrcAddrVid();

      txtszTxtRsrcAddrComments = addressRow.getSzTxtRsrcAddrComments();
      contracted = addressRow.getCScrIndRsrcContracted();
      //Capture the Vid on page load
      onPageLoadVid = txtSzNbrRsrcAddrVid;
    }
  }

    //If address type is primary make address type field disabled.
    if("01".equals(txtSzCdRsrcAddrType) )
    {
      addressTypeDisabled = "true";
      deleteButtonHide = true;
    }
    //If in Add mode for a CLASS resource
     if( "true".equalsIgnoreCase( request.getParameter("classResource") ) && "A".equalsIgnoreCase(szCReqFuncCd) )
    {
      classResource = "true";
      deleteButtonHide = true;
    }
    //If in update mode for a CLASS resource
    if(  "true".equalsIgnoreCase( request.getParameter("classResource") ) && "U".equalsIgnoreCase(szCReqFuncCd) )
    {
      classResource = "true";
      limitedEdit = "true";
      addressTypeDisabled = "true";
      streetLn1Disabled = "true";
      streetLn2Disabled = "true";
      cityDisabled = "true";
      stateDisabled = "true";
      zipDisabled = "true";
      countyDisabled = "true";
      validateButtonHide = true;
      deleteButtonHide = true;
    }
    if( ("A".equals(szCReqFuncCd) ) || ("U".equals(szCReqFuncCd) && !"01".equals(txtSzCdRsrcAddrType)) )
    {
      excludePrimaryOption.add("01");
      schoolDistrictDisabled = "true";
    }

    //If in update mode for a FAD resource
    if( request.getParameter("fadResource") != null && "true".equals(request.getParameter("fadResource"))  )
    {
      fadResource = "true";
      addressTypeDisabled = "true";
      vendorIdDisabled = "true";
      attentionDisabled = "true";
      streetLn1Disabled = "true";
      streetLn2Disabled = "true";
      cityDisabled = "true";
      stateDisabled = "true";
      zipDisabled = "true";
      countyDisabled = "true";
      commentsDisabled = "true";
      schoolDistrictDisabled = "true";
      validateButtonHide = true;
      saveButtonHide = true;
      deleteButtonHide = true;
      //limitedEdit = "true";
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

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n<script language=\"JavaScript\">\r\n\r\nfunction unValidate()\r\n{\r\n  document.frmAddressDetail.validated.value=\"false\";\r\n}\r\n\r\n\r\n /*\r\n  *This function is called before the page unloads.\r\n  */\r\nwindow.onbeforeunload = function ()\r\n{\r\n    IsDirty();\r\n};\r\n\r\n\r\n//STGAP00017058 - created confirmation message\r\nvar editPlus = ");
      out.print( editPlusVendorId );
      out.write("\r\nfunction confirmVendorIdEdit(){\r\n  if(editPlus){\r\n\treturn confirm('Have you checked your updates before saving?');\r\n  }\r\n}\r\n\r\n\r\n\r\nfunction openValidateWindowValidate()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  x.hdnSaveOrValidate.value = 'validate';\r\n  openValidateWindow();\r\n}\r\n\r\nfunction openValidateWindowSave()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  x.hdnSaveOrValidate.value = 'save';\r\n  openValidateWindow();\r\n}\r\n\r\n/*\r\n *This function opens the address validation window.\r\n */\r\nfunction openValidateWindow()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  var streetLn1 = escape( x.txtSzAddrRsrcAddrStLn1.value.replace('#', ' '));\r\n  var streetLn2 = escape( x.txtSzAddrRsrcAddrStLn2.value.replace('#', ' '));\r\n  var city = escape( x.txtSzAddrRsrcAddrCity.value.replace('#', ' '));\r\n  var zip = escape( x.txtSzAddrRsrcAddrZip.value.replace('#', ' '));\r\n  window.open('/common/AddressValidation/validate?txtSzAddrRsrcAddrStLn1='+streetLn1+'&txtSzAddrRsrcAddrStLn2='+streetLn2+'&txtSzAddrRsrcAddrCity='+city+'&selCdFacilityState='+x.selCdFacilityState.value+'&txtSzAddrRsrcAddrZip='+zip+'&selCdFacilityCounty='+x.selCdFacilityCounty.value+'&frmWindowName='+x.frmWindowName.value+'&addressMultCounty='+x.addressMultCounty.value+'&");
      out.print( AddressBean.SAVE_OR_VALIDATE );
      out.write("='+x.hdnSaveOrValidate.value,\r\n              'newWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=400,height=250');\r\n}\r\n\r\nfunction saveWithValidate()\r\n{\r\n  var x = document.frmAddressDetail;\r\n  if ( x.validated.value == 'false')\r\n  {\r\n    openValidateWindowSave();\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    return saveAddressDetailWindow();\r\n  }\r\n}\r\n\r\n /*\r\n  *This function is called when address detail is saved.\r\n  */\r\nfunction saveAddressDetailWindow()\r\n{\r\n  window.onbeforeunload = null;\r\n  var x = document.frmAddressDetail;\r\n  //disableValidation(\"frmAddressDetail\");\r\n\r\n  if( (x.vendorId.value != \"\") && (x.txtNbrRsrcAddrVid.value != \"\") && (x.vendorId.value != x.txtNbrRsrcAddrVid.value) )\r\n  {\r\n    //MSG - This Vendor ID already exists for the resource and cannot be repeated.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_RES_UNIQUE_VID"));
      out.write("\");\r\n  }\r\n\r\n  else if( x.contracted.value == \"Y\" && x.onPageLoadVendorId.value != \"\" && x.txtNbrRsrcAddrVid.value == \"\" )\r\n  {\r\n    //MSG - Save Failed: Cannot remove VID from address record with an active contract.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_RSRC_CONTRACTED_NO_VID"));
      out.write("\");\r\n    x.txtNbrRsrcAddrVid.value = x.onPageLoadVendorId.value;\r\n  }\r\n  else\r\n  {\r\n    x.action = \"/resource/ResourceDetail/displayAddressDetail\";\r\n    submitValidateForm( \"frmAddressDetail\", \"/resource/ResourceDetail/saveAddressDetail\" );\r\n    return false;\r\n  }\r\n\r\n  return false;\r\n}\r\n\r\n /*\r\n  *This function is called when an address is deleted.\r\n  */\r\nfunction deleteAddressRow()\r\n{\r\n  var doDelete = false;\r\n  window.onbeforeunload = null;\r\n  var x = document.frmAddressDetail;\r\n  if( x.txtNbrRsrcAddrVid.value != \"\" )\r\n  {\r\n    //MSG - An address record with a Vendor ID may not be deleted.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_RES_VID_ADDR"));
      out.write("\");\r\n  }\r\n  else if( x.selCdRsrcAddrType.value == \"01\" )\r\n  {\r\n    //MSG - You may not delete the primary address of a resource.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_CMN_PRIMARY_ADDRESS_NO_DELETE"));
      out.write("\");\r\n  }\r\n  else\r\n  {\r\n      var confirm = window.confirm(\"");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("\")\r\n      if(confirm)\r\n      {\r\n        disableValidation(\"frmAddressDetail\");\r\n        x.cReqFuncCd.value =\"D\";\r\n        doDelete = true;\r\n      }\r\n  }\r\n\r\n  return doDelete;\r\n}\r\n\r\n\r\n</script>\r\n");
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
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/saveAddressDetail");
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
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("iUlIdRsrcAddress");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatInt(iUlIdRsrcAddress));
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
          _jspx_th_impact_validateInput_4.setValue(iIndex);
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
          _jspx_th_impact_validateInput_6.setName("cReqFuncCd");
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
          _jspx_th_impact_validateInput_7.setValue(SerializationHelper.serializeObject(dateTsLastUpdate));
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
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("vendorId");
          _jspx_th_impact_validateInput_10.setValue(vendorId);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("onPageLoadVendorId");
          _jspx_th_impact_validateInput_11.setValue(onPageLoadVid);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("classResource");
          _jspx_th_impact_validateInput_12.setValue(classResource);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("fadResource");
          _jspx_th_impact_validateInput_13.setValue(fadResource);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("contracted");
          _jspx_th_impact_validateInput_14.setValue(contracted);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("          \r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnAdd1Name");
          _jspx_th_impact_validateInput_15.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn1));
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnAdd2Name");
          _jspx_th_impact_validateInput_16.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn2));
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnZipName");
          _jspx_th_impact_validateInput_17.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrZip));
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("hdnZipSuffName");
          _jspx_th_impact_validateInput_18.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrZipSuff));
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("hdnCityName");
          _jspx_th_impact_validateInput_19.setValue(StringHelper.getNonNullString(txtSzAddrRsrcAddrCity));
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("hdnStateName");
          _jspx_th_impact_validateInput_20.setValue(StringHelper.getNonNullString(txtSzCdFacilityState));
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("hdnCntyName");
          _jspx_th_impact_validateInput_21.setValue(StringHelper.getNonNullString(txtSzCdFacilityCounty));
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     \r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n   <tr>\r\n     <th colspan=\"4\">Address Information</th>\r\n   </tr>\r\n   <tr>\r\n     <td>");
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

   //STGAP00017058 - making vendorID editable for Fiscal Ops users
   if(!editPlusVendorId){
   
          out.write("\r\n   ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("txtNbrRsrcAddrVid");
          _jspx_th_impact_validateInput_22.setValue(txtSzNbrRsrcAddrVid);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setName("txtNbrRsrcAddrVidDisplay");
          _jspx_th_impact_validateInput_23.setLabel("Vendor ID");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setValue(txtSzNbrRsrcAddrVid);
          _jspx_th_impact_validateInput_23.setDisabled("true");
          _jspx_th_impact_validateInput_23.setConstraint("VendorID");
          _jspx_th_impact_validateInput_23.setMaxLength("8");
          _jspx_th_impact_validateInput_23.setSize("8");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    ");
 
    }else{
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("vidChanged");
          _jspx_th_impact_validateInput_24.setValue( editPlusVendorId == true ? "true" : "false" );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("text");
          _jspx_th_impact_validateInput_25.setName("txtNbrRsrcAddrVid");
          _jspx_th_impact_validateInput_25.setLabel("Vendor ID");
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setValue(txtSzNbrRsrcAddrVid);
          _jspx_th_impact_validateInput_25.setDisabled("false");
          _jspx_th_impact_validateInput_25.setConstraint("VendorID");
          _jspx_th_impact_validateInput_25.setMaxLength("8");
          _jspx_th_impact_validateInput_25.setSize("8");
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    ");
 
    }
    
          out.write("          \r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("text");
          _jspx_th_impact_validateInput_26.setName("txtSzAddrRsrcAddrAttn");
          _jspx_th_impact_validateInput_26.setLabel("Attention");
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setValue(txtSzAddrRsrcAddrAttn);
          _jspx_th_impact_validateInput_26.setConstraint("Name");
          _jspx_th_impact_validateInput_26.setDisabled(attentionDisabled);
          _jspx_th_impact_validateInput_26.setSize("30");
          _jspx_th_impact_validateInput_26.setMaxLength("30");
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n");

  String addressOnChange = "javascript:changeValidAddress('frmAddressDetail', '"+ addressBean.getAddressSubmoduleName() +"')";

          out.write("\r\n   <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("text");
          _jspx_th_impact_validateInput_27.setRequired("true");
          _jspx_th_impact_validateInput_27.setName( address1Name );
          _jspx_th_impact_validateInput_27.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_27.setLabel("Address Ln 1");
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setDisabled(streetLn1Disabled);
          _jspx_th_impact_validateInput_27.setConstraint("Address");
          _jspx_th_impact_validateInput_27.setValue(txtSzAddrRsrcAddrStLn1);
          _jspx_th_impact_validateInput_27.setSize("21");
          _jspx_th_impact_validateInput_27.setMaxLength("30");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n   </tr>\r\n   <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("text");
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_28.setName( address2Name );
          _jspx_th_impact_validateInput_28.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_28.setLabel("Address Ln 2");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setDisabled(streetLn2Disabled);
          _jspx_th_impact_validateInput_28.setValue(txtSzAddrRsrcAddrStLn2);
          _jspx_th_impact_validateInput_28.setSize("21");
          _jspx_th_impact_validateInput_28.setConstraint("Address");
          _jspx_th_impact_validateInput_28.setMaxLength("60");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("text");
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_29.setRequired("true");
          _jspx_th_impact_validateInput_29.setName( cityName );
          _jspx_th_impact_validateInput_29.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_29.setLabel("City");
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setDisabled(cityDisabled);
          _jspx_th_impact_validateInput_29.setValue(txtSzAddrRsrcAddrCity);
          _jspx_th_impact_validateInput_29.setConstraint("City");
          _jspx_th_impact_validateInput_29.setSize("21");
          _jspx_th_impact_validateInput_29.setMaxLength("20");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n   <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName( stateName );
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setOnChange( addressOnChange );
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_1.setDisabled(stateDisabled);
          _jspx_th_impact_validateSelect_1.setValue(txtSzCdFacilityState);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("text");
          _jspx_th_impact_validateInput_30.setName( zipName );
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_30.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_30.setLabel("Zip");
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          _jspx_th_impact_validateInput_30.setRequired("true");
          _jspx_th_impact_validateInput_30.setDisabled(zipDisabled);
          _jspx_th_impact_validateInput_30.setValue(txtSzAddrRsrcAddrZip);
          _jspx_th_impact_validateInput_30.setConstraint("Digit5");
          _jspx_th_impact_validateInput_30.setMaxLength("5");
          _jspx_th_impact_validateInput_30.setSize("5");
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        -\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("text");
          _jspx_th_impact_validateInput_31.setName( zipSuffName );
          _jspx_th_impact_validateInput_31.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setDisabled(zipDisabled);
          _jspx_th_impact_validateInput_31.setValue(txtSzAddrRsrcAddrZipSuff);
          _jspx_th_impact_validateInput_31.setConstraint("Digit4");
          _jspx_th_impact_validateInput_31.setMaxLength("4");
          _jspx_th_impact_validateInput_31.setSize("4");
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
if( !validateButtonHide ){
      String function = "javascript:setIsDirtyCalled(true);" +
                        "launchAddressValidate('frmAddressDetail', 'validate', '" +
                        addressBean.getAddressSubmoduleName() + "');return false;";
  
          out.write("\r\n    &nbsp;\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidateAddressRow");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setAction("#");
          _jspx_th_impact_ButtonTag_0.setFunction(function);
          _jspx_th_impact_ButtonTag_0.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setOnBlur("setIsDirtyCalled(false);");
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
          _jspx_th_impact_validateSelect_2.setValue(txtSzCdFacilityCounty);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>\r\n       ");
if(displayRegionField){
          out.write("\r\n        ");
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
          out.write("\r\n       ");
} else{
          out.write("\r\n        &nbsp;&nbsp;\r\n       ");
}
          out.write("\r\n      </td>\r\n   </tr>\r\n   <tr>\r\n     <td class=\"formLabel\" colspan=\"1\" valign=\"top\">Comments:</td>\r\n     <td colspan=3>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtszTxtRsrcAddrComments");
          _jspx_th_impact_validateTextArea_0.setCols("75");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled(commentsDisabled);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph80");
          _jspx_th_impact_validateTextArea_0.setMaxLength(80);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n                     ");
              out.print( FormattingHelper.formatString(txtszTxtRsrcAddrComments) );
              out.write("\r\n                   ");
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
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return deleteAddressRow();");
          _jspx_th_impact_ButtonTag_1.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceDetail/deleteAddressDetail");
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
      String saveFunction = "return confirmVendorIdEdit(); validateAddressOnSave('frmAddressDetail', '/resource/ResourceDetail/saveAddressDetail', '"+ addressBean.getAddressSubmoduleName() +"', 'btnSaveAddressRow');";
    
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAddressRow");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setFunction( saveFunction );
          _jspx_th_impact_ButtonTag_2.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/resource/ResourceDetail/saveAddressDetail");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
} else{
          out.write("\r\n     &nbsp;\r\n   ");
}
          out.write("\r\n  </td>\r\n </tr>\r\n</table>\r\n");
          if (_jspx_meth_impact_validateInput_32(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_33(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("hidden");
          _jspx_th_impact_validateInput_34.setName( AddressBean.ADDRESS_SUBMODULE_NAME );
          _jspx_th_impact_validateInput_34.setValue( addressBean.getAddressSubmoduleName() );
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
          _jspx_th_impact_validateInput_35.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_35.setValue("true");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("hidden");
          _jspx_th_impact_validateInput_36.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
          _jspx_th_impact_validateInput_36.setValue("true");
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("hidden");
          _jspx_th_impact_validateInput_37.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_37.setValue("");
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("hidden");
          _jspx_th_impact_validateInput_38.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_38.setValue("");
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("addressMultCounty");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_32(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_32.setType("hidden");
    _jspx_th_impact_validateInput_32.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_32.setValue("0");
    int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
    if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_33(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_33.setType("hidden");
    _jspx_th_impact_validateInput_33.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_33.setValue("0");
    int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
    if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
