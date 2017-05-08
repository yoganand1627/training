package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation;
import java.util.ArrayList;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ResourceDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     ResourceDetail.jsp
 * Created by:   Habib
 * Date Created: 07/30/02
 *
 * Description:
 * The Resource Detail page will display detailed information for the resource
 * selected on the Resource Search Results page. The page will be divided into
 * four sections: Resource Detail, Address List, Phone List, and Subcontractor
 * List. The last three sections are expandable and will be hidden until the
 * corresponding bar is clicked.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  08/29/03  Eric Dickman      Moved the Save Push Button to the bottom of the page
                              and added a HR.
  08/29/03  Eric Dickman      Added a MaxLength of 300 to the comments box and aligned
                              Type field in the Phone List and Address List.
  03/19/04  Linda Reed        SIR 22639 - added Resource LEGAL NAME field.
  07/01/05  piazzat           Changes to support MPS
  08/03/05  floresrj      SIR 23859 - added width 80 to phone comments header column;
                              Added a separate div tag to the expandable address list for 
                              impact, and changing the width to 764px
  08/12/05  floresrj          SIR 23808 Comments column in address and phone expandable
                              sections should not be visible.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String RSRC_TYPE_SCHOOL = "04";
  String RSRC_TYPE_MHMR   = "05";
  String RSRC_TYPE_OTHER  = "06";

  //String FAC_TYPE_CPA = "60";
  String FAC_TYPE_FAH = "70";
  String FAC_TYPE_PAA = "71";

  //String TRACE_TAG = "ResourceDetail.jsp";
  String includingFormName = "frmResourceDetail";
  String classResource = "false";
  String fadResource = "false";
  //SR- String schoolResource = "false";

  //Page state variables
  String resourceNameDisabled = "false";
  String legalNameDisabled = "false";
  String statusDisabled = "false";
  String ownershipDisabled = "false";
  String campusTypeDisabled = "false";
  String maintainerDisabled = "false";
  String contactDisabled = "false";
  String facilityTypeDisabled = "false";
  String hubDisabled = "false";
  String mhmrDisabled = "false";
  String transportDisabled = "false";
  String nationalProviderNumberDisabled= "false";
  String emailAddressDisabled= "false";
  String webAddressDisabled="false";
  
  
  boolean facilityDetailButtonHide = false;
  boolean saveResourceButtonHide = false;
  boolean addAddressButtonHide = false;
  boolean deleteAddressButtonHide = false;
  boolean addPhoneButtonHide = false;
  boolean deletePhoneButtonHide = false;
  boolean addOrsFacButtonHide = true;
  boolean deleteOrsFacButtonHide = true;
  String transport = "false";
  String prime = "false";
  String sub = "false";
  ROWCRES03SOG00_ARRAY addressArray = null;
  ROWCRES03SOG01_ARRAY phoneArray = null;
  ROWCRES03SOG02_ARRAY orsFacArray = null;
 
BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );//SR-
CRES03SO cres03so = (CRES03SO) state.getAttribute( ResourceDetailConversation.CRES03SO_ATTRIBUTE_NAME, request);//SR-
if ( cres03so == null )
{
  cres03so = new CRES03SO();
}

    if( "1".equals( cres03so.getCIndRsrcTransport() ) )
    {
      transport = "true";
    }
    if( "Y".equals( cres03so.getCScrIndRsrcPrime() ) )
    {
      prime = "true";
    }
    if( "Y".equals( cres03so.getCScrIndRsrcSub() ) )
    {
      sub = "true";
    }
    addressArray = cres03so.getROWCRES03SOG00_ARRAY();
    phoneArray = cres03so.getROWCRES03SOG01_ARRAY();
    orsFacArray = cres03so.getROWCRES03SOG02_ARRAY();
    
  // Get the pageMode.	
  String pageMode = PageMode.getPageMode(request);

  if( PageModeConstants.VIEW.equals( pageMode ) )
  {
    saveResourceButtonHide = true;
    addAddressButtonHide = true;
    deleteAddressButtonHide = true;
    addPhoneButtonHide = true;
    deletePhoneButtonHide = true;
  }
  // If resource type is MHMR
  if( RSRC_TYPE_MHMR.equals( cres03so.getSzCdRsrcType() ) )
  {
    //SR- mhmrResource = "true";
    campusTypeDisabled = "true";
  }
  // If resource type is Other
  if( RSRC_TYPE_OTHER.equals( cres03so.getSzCdRsrcType() ) )
  {
    campusTypeDisabled = "true";
    mhmrDisabled = "true";
  }
  // If resource type is not Other or MHMR
  if( !RSRC_TYPE_OTHER.equals(cres03so.getSzCdRsrcType()) && !RSRC_TYPE_MHMR.equals(cres03so.getSzCdRsrcType()) )
  {
    campusTypeDisabled = "true";
    facilityTypeDisabled = "true";
    mhmrDisabled = "true";
    facilityDetailButtonHide = true;
  }

  // If resource type is school
  if( RSRC_TYPE_SCHOOL.equals( cres03so.getSzCdRsrcType() ) )
  {
    //SR- schoolResource = "true";
    campusTypeDisabled = "false";
  }

  // If facility type is PRS F/A Homes or Private Agency Adoptive
  String facilType = cres03so.getSzCdRsrcFacilType();
  if( FAC_TYPE_FAH.equals(facilType) || FAC_TYPE_PAA.equals(facilType) )
  {
    fadResource = "true";
    //pageMode = PageMode.VIEW;
    saveResourceButtonHide = true;
    addAddressButtonHide = true;
    deleteAddressButtonHide = true;
    addPhoneButtonHide = true;
    deletePhoneButtonHide = true;
  }

  // If it's a CLASS resource
  if( cres03so.getLNbrRsrcFacilAcclaim() != 0 )
  {
    classResource = "true";
    resourceNameDisabled = "true";
    statusDisabled = "true";
    ownershipDisabled = "true";
    campusTypeDisabled = "true";
    maintainerDisabled = "true";
    facilityTypeDisabled = "true";
    hubDisabled = "false";
    mhmrDisabled = "true";
    deleteAddressButtonHide = true;
    deletePhoneButtonHide = true;
  }
  
  if( "1".equals( cres03so.getBIndORSAssociateToShines()))
  {
  	addOrsFacButtonHide = false;
    deleteOrsFacButtonHide = false;
  }

   ArrayList excludeOutOfStateOption = new ArrayList();
   excludeOutOfStateOption.add(CodesTables.CREGIONS_97);

  // SPB SIR 19972 - Always exclude FPS FA/Home
  // & Private Agency Adoptive Home when in modify mode
   ArrayList excludeFacilityOptions = new ArrayList();
   if( PageModeConstants.EDIT.equals( pageMode ) )
   {
    excludeFacilityOptions.add( CodesTables.CFACTYP4_70 );
    excludeFacilityOptions.add( CodesTables.CFACTYP4_71 );
   }

  // Variable to hold the css class for the each row in the lists
  String rowCss = "altColor";

  int tabIndex = 1;

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n\r\n// Get faciltiy type code/decode array for Resource Type of MHMR\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n /*\r\n  *This function is called when the page unloads.\r\n  */\r\n  window.attachEvent('onload', checkTransport );\r\n  function checkTransport()\r\n  {\r\n  ");
if( request.getParameter( "cbxCIndRsrcTransport" ) != null &&
        "1".equals( request.getParameter( "cbxCIndRsrcTransport" ) ) )
    {
      out.write("\r\n    document.frmResourceDetail.cbxCIndRsrcTransport.checked = true;\r\n    document.frmResourceDetail.cbxCIndRsrcTransport.defaultChecked = true;\r\n  ");
}
      out.write("\r\n  }\r\n\r\n /*\r\n  *This function is called before the page unloads.\r\n  */\r\n  window.attachEvent('onbeforeunload', setDirty );\r\n  function setDirty()\r\n  {\r\n    IsDirty();\r\n  }\r\n /*\r\n  *This function submits the form to bring up facility detail page.\r\n  */\r\n  function submitFacilityDetail()\r\n  {\r\n   disableValidation( \"frmResourceDetail\" );\r\n   submitValidateForm( \"frmResourceDetail\", \"/resource/ResourceDetail/addORSResource\" );\r\n  }\r\n\r\n /*\r\n  *This function submits the form to bring up services by area page.\r\n  */\r\n  function submitServicesByArea()\r\n  {\r\n   disableValidation( \"frmResourceDetail\" );\r\n   submitValidateForm( \"frmResourceDetail\", \"/resource/ServicesByArea/\" );\r\n  }\r\n\r\n /*\r\n  *This function submits the form to bring up phone detail page.\r\n  */\r\nfunction submitFormToPhoneDetailWindow( indexNum, cReqFuncCd)\r\n{\r\n  var x = document.frmResourceDetail;\r\n  x.indexNum.value = indexNum;\r\n  x.cReqFuncCd.value = cReqFuncCd;\r\n \r\n  if( x.cbxCIndRsrcTransport.checked )\r\n  {\r\n    x.cbxCIndRsrcTransport.value = \"1\";\r\n");
      out.write("  }\r\n\r\n  disableValidation( \"frmResourceDetail\" );\r\n\r\n  if (cReqFuncCd == 'A')\r\n  {\r\n    return true;\r\n  }\r\n  else\r\n  {\r\n    submitValidateForm( \"frmResourceDetail\", \"/resource/ResourceDetail/displayPhoneDetail\" );\r\n  }\r\n}\r\n\r\n /*\r\n  *This function submits the form to bring up address detail page.\r\n  */\r\nfunction submitFormAddressDetail( indexNum, creqFunc, contracted)\r\n{\r\n  var x = document.frmResourceDetail;\r\n  ");
if( PageModeConstants.EDIT.equals(pageMode) ){
      out.write("\r\n  if( contracted == \"Y\")\r\n  {\r\n    //MSG - You are Modifying a Resource Address that is linked to a Contract.\r\n    alert(\"");
      out.print(MessageLookup.getMessageByName("MSG_RSRC_ADDR_CONTRACTED"));
      out.write("\");\r\n  }\r\n  ");
}
      out.write("\r\n  x.indexNum.value=indexNum;\r\n  x.cReqFuncCd.value = creqFunc;\r\n  \r\n\r\n  if( x.cbxCIndRsrcTransport.checked )\r\n  {\r\n    x.cbxCIndRsrcTransport.value = \"1\";\r\n  }\r\n\r\n  disableValidation( \"frmResourceDetail\" );\r\n\r\n  if (creqFunc == 'A')\r\n  {\r\n    return true;\r\n  }\r\n  else\r\n  {\r\n    submitValidateForm( \"frmResourceDetail\", \"/resource/ResourceDetail/displayAddressDetail\" );\r\n  }\r\n}\r\n\r\n /*\r\n  *This function submits the form to bring up ors facilityId detail page.\r\n  */\r\nfunction submitResourceORSDetail(facilityId)\r\n{\r\n  document.frmResourceDetail.");
      out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      out.write(".value = \"\";\r\n  document.frmResourceDetail.");
      out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
      out.write(".value = facilityId;\r\n  \r\n  disableValidation(\"frmResourceDetail\");\r\n  submitValidateForm(\"frmResourceDetail\", \"/resource/ResourceORSDetail/displayORSResourceDetail\");\r\n}\r\n /*\r\n  *This function submits the form to save resource detail.\r\n  */\r\nfunction saveResourceDetailWindow( creqFunc )\r\n{\r\n  window.onbeforeunload = null;\r\n  var x = document.frmResourceDetail;\r\n  var save = false;\r\n  \r\n    //Set checkbox values\r\n    if( x.cbxCIndRsrcTransport.checked )\r\n    {\r\n       x.cbxCIndRsrcTransport.value = \"1\";\r\n    }\r\n    if( x.cbxCScrIndRsrcPrime.checked )\r\n    {\r\n       x.cbxCScrIndRsrcPrime.value = \"Y\";\r\n    }\r\n    if( x.cbxCScrIndRsrcSub.checked )\r\n    {\r\n       x.cbxCScrIndRsrcSub.value = \"Y\";\r\n    }\r\n    x.cReqFuncCd.value = creqFunc;\r\n    x.validationOverride.value = 'false';\r\n    x.action = \"/resource/ResourceDetail/displayResourceDetail\";\r\n    save = true;\r\n // }\r\n  return save;\r\n}\r\n\r\n /*\r\n  *This function iterates through an array of radio buttons or checkmarks to see if any have been selected.\r\n  */\r\nfunction checkForSelection( radioObj )\r\n");
      out.write("{\r\n  var buttonChecked = false;\r\n  for (var i = 0; i < radioObj.length; ++i)\r\n  {\r\n    buttonChecked = buttonChecked || radioObj[i].checked;\r\n  }\r\n  return buttonChecked;\r\n}\r\n\r\n /*\r\n  *This function submits the form to delete a phone, address, or multiple subcontractor records.\r\n  */\r\nfunction submitFormToDelete( action )\r\n{\r\n  var doDelete = false;\r\n  var x = document.frmResourceDetail;\r\n  var rowSelected = false;\r\n\r\n  switch (action)\r\n  {\r\n      case \"/resource/ResourceDetail/deleteSubcontractorDetail\":\r\n        rowSelected = true;\r\n        break;\r\n\r\n      case \"/resource/ResourceDetail/deletePhoneDetail\":\r\n        if( x.rbPhoneRadioIndex != null && x.rbPhoneRadioIndex.length >1 ){\r\n          var buttonChecked = false;\r\n          var buttonIndex = 0;\r\n          for (var i = 0; i < x.rbPhoneRadioIndex.length; ++i)\r\n          {\r\n            buttonChecked = buttonChecked || x.rbPhoneRadioIndex[i].checked;\r\n            if(buttonChecked)\r\n            {\r\n              buttonIndex = i;\r\n              rowSelected = true;\r\n");
      out.write("              break;\r\n            }\r\n          }\r\n          for (var i = 0; i < x.rbPhoneRadioIndex.length; ++i)\r\n          {\r\n            x.rbPhoneRadioIndex[i].defaultChecked = x.rbPhoneRadioIndex[i].checked;\r\n          }\r\n          x.rbPhoneRadioIndex.value = buttonIndex;\r\n        }else if( x.rbPhoneRadioIndex != null && x.rbPhoneRadioIndex.value != null && x.rbPhoneRadioIndex.checked )\r\n        {\r\n          rowSelected =  x.rbPhoneRadioIndex.value;\r\n          x.rbPhoneRadioIndex.defaultChecked = x.rbPhoneRadioIndex.checked;\r\n        }\r\n        break;\r\n\r\n      case \"/resource/ResourceDetail/deleteAddressDetail\":\r\n        if( x.rbAddressRadioIndex != null && x.rbAddressRadioIndex.length >1 )\r\n        {\r\n          var buttonChecked = false;\r\n          var buttonIndex = 0;\r\n          for (var i = 0; i < x.rbAddressRadioIndex.length; ++i)\r\n          {\r\n            buttonChecked = buttonChecked || x.rbAddressRadioIndex[i].checked;\r\n            if(buttonChecked)\r\n            {\r\n              buttonIndex = i;\r\n              rowSelected = true;\r\n");
      out.write("              break;\r\n            }\r\n          }\r\n          for (var i = 0; i < x.rbAddressRadioIndex.length; ++i)\r\n          {\r\n            x.rbAddressRadioIndex[i].defaultChecked = x.rbAddressRadioIndex[i].checked;\r\n          }\r\n          x.rbAddressRadioIndex.value = buttonIndex;\r\n\r\n        }else if( x.rbAddressRadioIndex != null && x.rbAddressRadioIndex.value != null && x.rbAddressRadioIndex.checked )\r\n        {\r\n          rowSelected = x.rbAddressRadioIndex.value;\r\n          x.rbAddressRadioIndex.defaultChecked = x.rbAddressRadioIndex.checked;\r\n        }\r\n        break;\r\n        \r\n      case \"/resource/ResourceDetail/deleteOrsFacility\":\r\n        if( x.rbORSRadioIndex != null && x.rbORSRadioIndex.length >1 )\r\n        {\r\n          var buttonChecked = false;\r\n          var buttonIndex = 0;\r\n          for (var i = 0; i < x.rbORSRadioIndex.length; ++i)\r\n          {\r\n            buttonChecked = buttonChecked || x.rbORSRadioIndex[i].checked;\r\n            if(buttonChecked)\r\n            {\r\n              buttonIndex = i;\r\n");
      out.write("              rowSelected = true;\r\n              break;\r\n            }\r\n          }\r\n          for (var i = 0; i < x.rbORSRadioIndex.length; ++i)\r\n          {\r\n            x.rbORSRadioIndex[i].defaultChecked = x.rbORSRadioIndex[i].checked;\r\n          }\r\n          x.rbORSRadioIndex.value = buttonIndex;\r\n\r\n        }else if( x.rbORSRadioIndex != null && x.rbORSRadioIndex.value != null && x.rbORSRadioIndex.checked )\r\n        {\r\n          rowSelected = x.rbORSRadioIndex.value;\r\n          x.rbORSRadioIndex.defaultChecked = x.rbORSRadioIndex.checked;\r\n        }\r\n        break;\r\n  }\r\n\r\n  // Alert user if they click a Delete button without selecting an item to delete\r\n  if( !rowSelected )\r\n  {\r\n    //MSG - Please select at least one row to perform this action.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("\");\r\n  }\r\n  else\r\n  {\r\n    var cnfrm = window.confirm(\"");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("\")\r\n    if(cnfrm)\r\n    {\r\n      x.cReqFuncCd.value = 'D';\r\n      disableValidation( \"frmResourceDetail\" );\r\n      doDelete = true;\r\n    }\r\n  }\r\n\r\n  return doDelete;\r\n}\r\n\r\n /*\r\n  *This function pupulates the contact number display.\r\n  */\r\nfunction populateContactPhone( phoneNumber )\r\n{\r\n  document.all.contactNumber_id.innerHTML = phoneNumber;\r\n}\r\n\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmResourceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/saveResourceDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatInt( cres03so.getUlIdResource() ));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("classResource");
          _jspx_th_impact_validateInput_5.setValue(classResource);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("fadResource");
          _jspx_th_impact_validateInput_6.setValue(fadResource);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
          _jspx_th_impact_validateInput_7.setValue(pageMode);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n         ");
 /* Use descriptive IDs for your Table and Tag identifiers :
         Javascript code would be better inside a function that is called from here,
         but for ease of use I have put the code here */ 
          out.write("\r\n            <a href=\"#\" onClick=\"expandAll();\">Expand All</a>&nbsp;\r\n            <a href=\"#\" onClick=\"collapseAll();\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("resName");
          _jspx_th_impact_validateInput_9.setValue(cres03so.getSzNmLegal());
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("contactName");
          _jspx_th_impact_validateInput_10.setValue(cres03so.getSzNmRsrcContact());
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <tr>\r\n            <th colspan=\"4\">Resource Detail</th>\r\n  </tr>\r\n        <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setValue(cres03so.getSzNmResource());
          _jspx_th_impact_validateInput_11.setName("txtNmResource");
          _jspx_th_impact_validateInput_11.setDisabled(resourceNameDisabled);
          _jspx_th_impact_validateInput_11.setLabel("Resource Name");
          _jspx_th_impact_validateInput_11.setRequired("true");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setMaxLength("30");
          _jspx_th_impact_validateInput_11.setSize("30");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td class=\"formLabel\" > Resource ID: </td>\r\n            <td> ");
          out.print(FormattingHelper.formatInt( cres03so.getUlIdResource() ));
          out.write("</td>\r\n             ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setEditableMode(EditableMode.EDIT);
          _jspx_th_impact_validateInput_12.setName("resourceId");
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatInt(cres03so.getUlIdResource()));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </tr>\r\n\r\n        <tr>\r\n            <!--SIR 22639 Add LEGAL NAME -->\r\n            <td >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setColspan("3");
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setValue(cres03so.getSzNmLegal());
          _jspx_th_impact_validateInput_13.setName("txtNmLegal");
          _jspx_th_impact_validateInput_13.setDisabled(legalNameDisabled);
          _jspx_th_impact_validateInput_13.setRequired("true");
          _jspx_th_impact_validateInput_13.setLabel("Legal Name");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setMaxLength("45");
          _jspx_th_impact_validateInput_13.setSize("45");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n        </tr>\r\n\r\n        <tr>\r\n            <td class=\"formLabel\" > Resource Type: </td>\r\n            <td>\r\n              ");
          out.print(Lookup.simpleDecodeSafe("CRSCTYPE", cres03so.getSzCdRsrcType() ));
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setEditableMode(EditableMode.EDIT);
          _jspx_th_impact_validateInput_14.setName("selCdRsrcType");
          _jspx_th_impact_validateInput_14.setValue(cres03so.getSzCdRsrcType());
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        \t<!-- Per defect STGAP00002641, removed exclusion of Statewide option -->\r\n        \t");
          out.write("\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCdRsrcMaintainer");
          _jspx_th_impact_validateSelect_0.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeOutOfStateOption);
          _jspx_th_impact_validateSelect_0.setValue(cres03so.getSzCdRsrcMaintainer());
          _jspx_th_impact_validateSelect_0.setDisabled(maintainerDisabled);
          _jspx_th_impact_validateSelect_0.setLabel("Maintainer");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n        <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selCdRsrcStatus");
          _jspx_th_impact_validateSelect_1.setValue(cres03so.getSzCdRsrcStatus());
          _jspx_th_impact_validateSelect_1.setCodesTable("CRSCSTAT");
          _jspx_th_impact_validateSelect_1.setDisabled(statusDisabled);
          _jspx_th_impact_validateSelect_1.setLabel("Status");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setValue(cres03so.getSzNmRsrcContact());
          _jspx_th_impact_validateInput_15.setDisabled(contactDisabled);
          _jspx_th_impact_validateInput_15.setName("txtNmRsrcContact");
          _jspx_th_impact_validateInput_15.setLabel("Contact Name");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setMaxLength("25");
          _jspx_th_impact_validateInput_15.setSize("25");
          _jspx_th_impact_validateInput_15.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n        </tr>\r\n\r\n      <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selCdRsrcOwnership");
          _jspx_th_impact_validateSelect_2.setCodesTable("COWNSHIP");
          _jspx_th_impact_validateSelect_2.setDisabled(ownershipDisabled);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setLabel("Ownership");
          _jspx_th_impact_validateSelect_2.setValue(cres03so.getSzCdRsrcOwnership());
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            \r\n             <td >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setValue(cres03so.getSzNmRsrcContactTitle());
          _jspx_th_impact_validateInput_16.setDisabled(contactDisabled);
          _jspx_th_impact_validateInput_16.setName("txtNmRsrcContactTitle");
          _jspx_th_impact_validateInput_16.setLabel("Contact Title");
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setMaxLength("30");
          _jspx_th_impact_validateInput_16.setSize("30");
          _jspx_th_impact_validateInput_16.setConstraint("Name30");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n            \r\n          \r\n        </tr>\r\n        \r\n          <tr>\r\n            <td>\r\n               ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("selCdRsrcFacilType");
          _jspx_th_impact_validateSelect_3.setLabel("Facility Type");
          _jspx_th_impact_validateSelect_3.setCodesTable("CFACTYP4");
          _jspx_th_impact_validateSelect_3.setExcludeOptions(excludeFacilityOptions);
          _jspx_th_impact_validateSelect_3.setDisabled(facilityTypeDisabled);
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(cres03so.getSzCdRsrcFacilType()));
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 180px");
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n                   \r\n            <td class=\"formLabel\">Contact Phone:</td>\r\n            <td id=\"contactNumber_id\"> </td>\r\n        </tr>\r\n        \r\n         <tr>\r\n            <td >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setValue(cres03so.getSzNbrRsrcNtnlProvider());
          _jspx_th_impact_validateInput_17.setDisabled(nationalProviderNumberDisabled);
          _jspx_th_impact_validateInput_17.setName("txtNationalProviderNumber");
          _jspx_th_impact_validateInput_17.setLabel("National Provider Number");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setMaxLength("20");
          _jspx_th_impact_validateInput_17.setSize("20");
          _jspx_th_impact_validateInput_17.setConstraint("AlphaNumeric");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n             <td >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setValue(cres03so.getSzAddrRsrcEmail());
          _jspx_th_impact_validateInput_18.setDisabled(emailAddressDisabled);
          _jspx_th_impact_validateInput_18.setName("txtEmailAddress");
          _jspx_th_impact_validateInput_18.setLabel("Email Address");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setMaxLength("50");
          _jspx_th_impact_validateInput_18.setSize("50");
          _jspx_th_impact_validateInput_18.setConstraint("Email");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        \r\n        <tr>\r\n           <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setColspan("3");
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setValue(cres03so.getSzAddrRsrcWebsite());
          _jspx_th_impact_validateInput_19.setDisabled(webAddressDisabled);
          _jspx_th_impact_validateInput_19.setName("txtWebAddress");
          _jspx_th_impact_validateInput_19.setLabel("Web Address");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setMaxLength("100");
          _jspx_th_impact_validateInput_19.setSize("100");
          _jspx_th_impact_validateInput_19.setConstraint("URL");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n             \r\n        </tr>\r\n        <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("selCdSchoolType");
          _jspx_th_impact_validateSelect_4.setCodesTable("CSCHTYPE");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(cres03so.getSzCdSchoolType()));
          _jspx_th_impact_validateSelect_4.setLabel("School Type");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setName("selCdSchoolDist");
          _jspx_th_impact_validateSelect_5.setCodesTable("CSCHDSTR");
          _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(cres03so.getSzCdSchoolDistrict()));
          _jspx_th_impact_validateSelect_5.setLabel("School District");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            \r\n        </tr>\r\n        <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setName("selPaymentDelivery");
          _jspx_th_impact_validateSelect_6.setCodesTable("CPAYDELI");
          _jspx_th_impact_validateSelect_6.setValue(FormattingHelper.formatString(cres03so.getSzCdPaymentDelivery()));
          _jspx_th_impact_validateSelect_6.setLabel("Payment Method");
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_6.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td></td>\r\n            \r\n        </tr>\r\n       \r\n     <tr>\r\n      <td class=\"formLabel\" colspan=\"2\" >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("checkbox");
          _jspx_th_impact_validateInput_20.setName("cbxCIndRsrcTransport");
          _jspx_th_impact_validateInput_20.setChecked(transport);
          _jspx_th_impact_validateInput_20.setValue("0");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              Transportation Provided\r\n            </td>\r\n       \r\n            <td class=\"formLabel\" >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("checkbox");
          _jspx_th_impact_validateInput_21.setName("cbxCScrIndRsrcPrime");
          _jspx_th_impact_validateInput_21.setChecked(prime);
          _jspx_th_impact_validateInput_21.setDisabled("true");
          _jspx_th_impact_validateInput_21.setValue("N");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              Prime\r\n            </td>\r\n            <td class=\"formLabel\" >\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("checkbox");
          _jspx_th_impact_validateInput_22.setName("cbxCScrIndRsrcSub");
          _jspx_th_impact_validateInput_22.setChecked(sub);
          _jspx_th_impact_validateInput_22.setDisabled("true");
          _jspx_th_impact_validateInput_22.setValue("N");
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              Sub\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td class=\"formLabel\">Last Updated On:</td>\r\n            <td>");
          out.print(FormattingHelper.formatDate( cres03so.getTsLastUpdate() ));
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("txtLastUpdate");
          _jspx_th_impact_validateInput_23.setValue(SerializationHelper.serializeObject( cres03so.getTsLastUpdate() ));
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td class=\"formLabel\">Last Updated By:</td>\r\n            <td>");
          out.print(cres03so.getSzNmRsrcLastUpdate());
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("txtNmRsrcLastUpdate");
          _jspx_th_impact_validateInput_24.setValue(cres03so.getSzNmRsrcLastUpdate());
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\r\n        <tr>\r\n            <td class=\"formLabel\">Comments:</td>\r\n            <td colspan=\"3\">\r\n              ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtTxtRsrcComments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("120");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n                 ");
              out.print(cres03so.getSzTxtRsrcComments()!= null?FormattingHelper.formatString(cres03so.getSzTxtRsrcComments()):StringHelper.EMPTY_STRING);
              out.write("\r\n              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n    </table>\r\n<!-- End Resource Detail --><!-- BEGIN THE ADDRESS/PHONE DETAIL NOW -->\r\n<br>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("addressDetail");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Address List");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  <!-- SIR 23859 Impact needs to have a width in px mobile % -->\r\n  ");
              if (_jspx_meth_impact_ifServerImpact_0(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n  ");
              if (_jspx_meth_impact_ifMobileImpact_0(_jspx_th_impact_ExpandableSectionTag_0, _jspx_page_context))
                return;
              out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <th class=\"thList\" width=\"5%\">&nbsp;</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Vendor ID</th>\r\n        <th class=\"thList\">Attention</th>\r\n        <th class=\"thList\">Address</th>\r\n        <th class=\"thList\">County</th>\r\n   ");

    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
        {
     
              out.write("\r\n        <th class=\"thList\" width=\"80\">Comments</th>\r\n     ");

    } else {
     
              out.write("\r\n        <th class=\"thList\" width=\"80\"></th>\r\n     ");

    }
         // SIR 23730 Phase II Mobile End
     
              out.write("\r\n      </tr>\r\n\r\n      ");

        int loopCount = 0;
        ROWCRES03SOG00 addressRow = null;
        // String primaryExists = "false";

        Enumeration eAddresses = addressArray.enumerateROWCRES03SOG00();
        if (eAddresses.hasMoreElements())
        {
          while (eAddresses.hasMoreElements())
          {
            addressRow = (ROWCRES03SOG00) eAddresses.nextElement();
            rowCss = FormattingHelper.getRowCss( loopCount + 1 );
      
              out.write("\r\n\r\n      <tr class=\"");
              out.print(rowCss);
              out.write("\" valign=\"top\">\r\n    ");
// SIR 23730 Phase II Mobile
        if( PlatformConstants.MOBILE_IMPACT )
        {
        
              out.write(" \r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_25.setType("radio");
              _jspx_th_impact_validateInput_25.setName("rbAddressRadioIndex");
              _jspx_th_impact_validateInput_25.setValue( String.valueOf( loopCount ) );
              _jspx_th_impact_validateInput_25.setTabIndex( tabIndex );
              _jspx_th_impact_validateInput_25.setDisabled("true");
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    ");

        } else {
        
              out.write("\r\n        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_26.setType("radio");
              _jspx_th_impact_validateInput_26.setName("rbAddressRadioIndex");
              _jspx_th_impact_validateInput_26.setValue( String.valueOf( loopCount ) );
              _jspx_th_impact_validateInput_26.setTabIndex( tabIndex );
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n        ");
     } 
              out.write("\r\n   ");

        if( PlatformConstants.MOBILE_IMPACT )
        {
     
              out.write("\r\n          <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CRSCADDR", addressRow.getSzCdRsrcAddrType() ));
              out.write("&nbsp;&nbsp;</nobr></td>\r\n     ");

    } else {
     
              out.write("\r\n           <td><nobr><a tabindex=");
              out.print(tabIndex++);
              out.write(" href=\"javascript:submitFormAddressDetail( '");
              out.print(loopCount);
              out.write("','U', '");
              out.print(addressRow.getCScrIndRsrcContracted());
              out.write("')\">");
              out.print(Lookup.simpleDecodeSafe("CRSCADDR", addressRow.getSzCdRsrcAddrType() ));
              out.write("</a>&nbsp;&nbsp;</nobr></td>   \r\n     ");

                }
         // SIR 23730 Phase II Mobile End
     
              out.write("\r\n        <td><nobr>");
              out.print(addressRow.getSzNbrRsrcAddrVid()!= null?addressRow.getSzNbrRsrcAddrVid():StringHelper.EMPTY_STRING );
              out.write("&nbsp;&nbsp;</td>\r\n        <td><nobr>");
              out.print(addressRow.getSzAddrRsrcAddrAttn()!= null?addressRow.getSzAddrRsrcAddrAttn():StringHelper.EMPTY_STRING );
              out.write("&nbsp;&nbsp;</td>\r\n        <td><nobr>");
              out.print(addressRow.getSzAddrRsrcAddrStLn1()!= null?addressRow.getSzAddrRsrcAddrStLn1():StringHelper.EMPTY_STRING );
              out.write("\r\n                  ");
              out.print(addressRow.getSzAddrRsrcAddrStLn2()!= null?addressRow.getSzAddrRsrcAddrStLn2():StringHelper.EMPTY_STRING);
              out.write(",\r\n                  ");
              out.print(addressRow.getSzAddrRsrcAddrCity()!= null?addressRow.getSzAddrRsrcAddrCity():StringHelper.EMPTY_STRING);
              out.write(",\r\n                  ");
              out.print(addressRow.getSzCdFacilityState()!= null?addressRow.getSzCdFacilityState():StringHelper.EMPTY_STRING);
              out.write("\r\n                  ");
              out.print(addressRow.getSzAddrRsrcAddrZip()!=null?addressRow.getSzAddrRsrcAddrZip():StringHelper.EMPTY_STRING);
              out.write("&nbsp;&nbsp;</td>\r\n        <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CCOUNT", addressRow.getSzCdFacilityCounty()));
              out.write("&nbsp;&nbsp;</td>\r\n   ");

    // SIR 23808 Phase II
        if( !PlatformConstants.MOBILE_IMPACT )
        {
     
              out.write("\r\n        <td align=\"center\">");
if( addressRow.getSzTxtRsrcAddrComments() != null && !StringHelper.EMPTY_STRING.equals(addressRow.getSzTxtRsrcAddrComments()) ){
              out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
              out.write("</td>\r\n     ");
 } else 
          {  
              out.write("\r\n             <td>&nbsp;</td>\r\n        ");
} 
              out.write("   \r\n      </tr>\r\n      ");

            loopCount++;
          } // end while
        } // end if
      
              out.write("\r\n     \r\n    </table>\r\n  </div>\r\n\r\n  <table width=\"100%\">\r\n    <tr>\r\n        <td align=\"left\" colspan=\"2\">\r\n        ");

    // SIR 23730 Phase II Mobile
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !deleteAddressButtonHide ){
              out.write("\r\n            ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_0.setName("btnDeleteAddressDetail");
              _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_0.setFunction("return submitFormToDelete( '/resource/ResourceDetail/deleteAddressDetail' );");
              _jspx_th_impact_ButtonTag_0.setForm("frmResourceDetail");
              _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceDetail/deleteAddressDetail");
              _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
  }
      }
      
              out.write("\r\n        </td>\r\n        <td align=\"right\" colspan=\"3\">\r\n        ");

    // SIR 23730 Phase II Mobile
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !addAddressButtonHide ){
              out.write("\r\n            ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnAddAddressDetail");
              _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_1.setAlign("right");
              _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_1.setFunction("return submitFormAddressDetail('0' , 'A', 'N');");
              _jspx_th_impact_ButtonTag_1.setForm("frmResourceDetail");
              _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceDetail/displayAddressDetail");
              _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
   }
      }
      
              out.write("\r\n        </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("phoneDetail");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Phone List");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  <div id=\"ResourceDtlPhoneScroll\" style=\"OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px\" class=\"tableBorder\">\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <th class=\"thList\" width=\"5%\">&nbsp;</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Phone</th>\r\n        <th class=\"thList\">Ext</th>\r\n  ");

    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
        {
    
              out.write("\r\n            <!-- SIR 23859 - added width 80 in order for checkmarks to be centered correctly  -->\r\n          <th class=\"thList\" width=\"80\">Comments</th>\r\n     ");

    } else {
         // SIR 23730 Phase II Mobile End
     
              out.write("\r\n      <!-- SIR 23859 - added width 80 for consistencey -->\r\n             <th class=\"thList\" width=\"80\"></th>\r\n     ");

    }
     
              out.write("\r\n      </tr>\r\n\r\n  ");

    int phoneLoopCount = 0;
    Enumeration ephoneArray =phoneArray.enumerateROWCRES03SOG01();
    if (ephoneArray.hasMoreElements())
    {
      ROWCRES03SOG01 phoneRow = null;
       while (ephoneArray.hasMoreElements())
       {
       
        phoneRow = (ROWCRES03SOG01) ephoneArray.nextElement();
       rowCss = FormattingHelper.getRowCss( phoneLoopCount+1 );
        String formatedPhone = "";
        if( phoneRow.getLNbrFacilPhoneNumber().length() == 10 )
        {
          formatedPhone = FormattingHelper.formatPhone(phoneRow.getLNbrFacilPhoneNumber());
        }
        else
        {
          formatedPhone = phoneRow.getLNbrFacilPhoneNumber();
        }
        //  If contact phone has been populated display it
        //  in the Resource Detail section of the page
        //
        if( "15".equals( phoneRow.getSzCdFacilPhoneType() ) )
        {
          
              out.write("\r\n          <SCRIPT LANGUAGE=JavaScript>\r\n      populateContactPhone(\"");
              out.print(formatedPhone);
              out.write("\");\r\n    </SCRIPT>\r\n    ");

        }
  
              out.write("\r\n      <tr class=\"");
              out.print(rowCss);
              out.write("\" valign=\"top\">\r\n    ");
 // SIR 23729 Phase II Mobile
        if( PlatformConstants.MOBILE_IMPACT )
        {
        
              out.write(" \r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_27.setType("radio");
              _jspx_th_impact_validateInput_27.setName("rbPhoneRadioIndex");
              _jspx_th_impact_validateInput_27.setValue( String.valueOf(phoneLoopCount) );
              _jspx_th_impact_validateInput_27.setTabIndex(tabIndex );
              _jspx_th_impact_validateInput_27.setDisabled("true");
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    ");

        } else {
        
              out.write("\r\n        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_28.setType("radio");
              _jspx_th_impact_validateInput_28.setName("rbPhoneRadioIndex");
              _jspx_th_impact_validateInput_28.setValue( String.valueOf( phoneLoopCount) );
              _jspx_th_impact_validateInput_28.setTabIndex(tabIndex );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      ");
     } 
              out.write("\r\n  ");

    // SIR 23730 Phase II Mobile Start
        if( PlatformConstants.MOBILE_IMPACT )
        {   
     
              out.write("\r\n           <td><nobr>");
              out.print(Lookup.simpleDecodeSafe("CRSCPHON", phoneRow.getSzCdFacilPhoneType() ));
              out.write("</nobr></td>\r\n     ");

    } else {
     
              out.write("\r\n             <td><nobr><a tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" href=\"javascript:submitFormToPhoneDetailWindow( '");
              out.print(phoneLoopCount);
              out.write("', 'U')\">");
              out.print(Lookup.simpleDecodeSafe("CRSCPHON", phoneRow.getSzCdFacilPhoneType() ));
              out.write(" </a></td>\r\n     ");
        }
         // SIR 23730 Phase II Mobile End
     
              out.write("\r\n       <td><nobr>");
              out.print(formatedPhone);
              out.write("</td>\r\n        <td><nobr>");
              out.print(phoneRow.getLNbrFacilPhoneExtension()!= null? phoneRow.getLNbrFacilPhoneExtension():StringHelper.EMPTY_STRING );
              out.write("</td>\r\n   ");

     // SIR 23808 - Comments column should not be visible on Mobile
         if( !PlatformConstants.MOBILE_IMPACT )
       {
     
              out.write("\r\n     <td align=\"center\"><nobr>");
if( phoneRow.getSzTxtRsrcPhoneComments()!=null && !StringHelper.EMPTY_STRING.equals( phoneRow.getSzTxtRsrcPhoneComments() ) ){
              out.write("<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >");
}
              out.write("</td>\r\n  ");
    } else
          { 
              out.write("\r\n             <td>&nbsp;</td>\r\n  ");
      } 
              out.write("\r\n      </tr>\r\n  ");
 
   phoneLoopCount ++;
   }
   
  }
  else
  {
  
              out.write("\r\n      <tr class=\"odd\"><td colspan=\"4\">No Results Found</td></tr>\r\n");
}
              out.write("\r\n \r\n    </table>\r\n  </div>\r\n\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n        <td align=\"left\" colspan=\"2\">\r\n        ");
 
    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !deletePhoneButtonHide ){
              out.write("\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_2.setName("btnDeletePhoneDetail");
              _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_2.setFunction("return submitFormToDelete( '/resource/ResourceDetail/deletePhoneDetail' );");
              _jspx_th_impact_ButtonTag_2.setForm("frmResourceDetail");
              _jspx_th_impact_ButtonTag_2.setAction("/resource/ResourceDetail/deletePhoneDetail");
              _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
  }
      }// Phase II Mobile End
    
              out.write("\r\n        </td>\r\n        <td align=\"right\" colspan=\"3\">\r\n        ");

    // SIR 23730 Phase II Mobile Start
         if( !PlatformConstants.MOBILE_IMPACT )
      {
          if( !addPhoneButtonHide  ){
              out.write("\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_3.setName("btnAddPhoneDetail");
              _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_3.setAlign("right");
              _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_3.setFunction("return submitFormToPhoneDetailWindow( '0' , 'A');");
              _jspx_th_impact_ButtonTag_3.setForm("frmResourceDetail");
              _jspx_th_impact_ButtonTag_3.setAction("/resource/ResourceDetail/displayPhoneDetail");
              _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
  }
      }// SIR 23730 Phase II Mobile End
    
              out.write("\r\n        </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n");
 // SIR 23730 Phase II Mobile Start  
  if( !PlatformConstants.MOBILE_IMPACT )
  {

          out.write("\r\n     ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/SubcontractorSub/displaySubcontractorList");
          _jspx_th_impact_include_0.setCallingPage("/resource/ResourceDetail/displayResourceDetail");
          _jspx_th_impact_include_0.setIncludingForm("frmResourceDetail");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n\r\n       ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName("SubcontractorSubvidResource");
              _jspx_th_impact_attribute_0.setValue(FormattingHelper.formatInt( cres03so.getUlIdResource() ));
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       ");
              if (_jspx_meth_impact_attribute_1(_jspx_th_impact_include_0, _jspx_page_context))
                return;
              out.write("\r\n       ");
              if (_jspx_meth_impact_attribute_2(_jspx_th_impact_include_0, _jspx_page_context))
                return;
              out.write("\r\n       ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_3.setName("SubcontractorSubvfacilityType");
              _jspx_th_impact_attribute_3.setValue(cres03so.getSzCdRsrcFacilType());
              int _jspx_eval_impact_attribute_3 = _jspx_th_impact_attribute_3.doStartTag();
              if (_jspx_th_impact_attribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_4.setName("SubcontractorSubvfacilityNumber");
              _jspx_th_impact_attribute_4.setValue(FormattingHelper.formatInt( cres03so.getLNbrRsrcFacilAcclaim() ));
              int _jspx_eval_impact_attribute_4 = _jspx_th_impact_attribute_4.doStartTag();
              if (_jspx_th_impact_attribute_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     ");
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
  }  // SIR 23730 Phase II Mobile End 
          out.write("\r\n\r\n<br>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("orsFacList");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("ORS Facility List");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n  <div id=\"ResourceDtlOrsFacScroll\" style=\"OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px\" class=\"tableBorder\">\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <th class=\"thList\" width=\"5%\">&nbsp;</th>\r\n        <th class=\"thList\">ORS Facility Name</th>\r\n        <th class=\"thList\">ORS Facility ID</th>\r\n        <th class=\"thList\">ORS Facility Status</th>\r\n      </tr>\r\n\r\n  ");

    int orsFacLoopCount = 0;
    if (orsFacArray != null && orsFacArray.enumerateROWCRES03SOG02().hasMoreElements())
    {
      Enumeration eOrsFacArray =orsFacArray.enumerateROWCRES03SOG02();
      ROWCRES03SOG02 orsFacRow = null;
       while (eOrsFacArray.hasMoreElements())
       {
       
	        orsFacRow = (ROWCRES03SOG02) eOrsFacArray.nextElement();
	        rowCss = FormattingHelper.getRowCss(orsFacLoopCount + 1);
	        String orsFacName = orsFacRow.getSzNmOrsFacilName();
  
              out.write("\r\n\t      <tr class=\"");
              out.print(rowCss);
              out.write("\" valign=\"top\">\r\n\t        ");
 // SIR 23729 Phase II Mobile
	        if( PlatformConstants.MOBILE_IMPACT )
	        {
	        
              out.write(" \r\n\t          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_29.setType("radio");
              _jspx_th_impact_validateInput_29.setName("rbORSRadioIndex");
              _jspx_th_impact_validateInput_29.setValue( String.valueOf(orsFacLoopCount) );
              _jspx_th_impact_validateInput_29.setTabIndex(tabIndex );
              _jspx_th_impact_validateInput_29.setDisabled("true");
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t        ");

	        } else {
	        
              out.write("\r\n\t        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_30.setType("radio");
              _jspx_th_impact_validateInput_30.setName("rbORSRadioIndex");
              _jspx_th_impact_validateInput_30.setValue( String.valueOf(orsFacLoopCount) );
              _jspx_th_impact_validateInput_30.setTabIndex(tabIndex );
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t      ");
     } 
              out.write("\r\n\t      ");

	      // SIR 23730 Phase II Mobile Start
	        if( PlatformConstants.MOBILE_IMPACT )
	        {   
	      
              out.write("\r\n\t          <td><nobr>");
              out.print(orsFacName);
              out.write("</nobr></td>\r\n\t      ");

	        } else {
	      
              out.write("\r\n\t          <td><nobr><a tabIndex=\"");
              out.print(tabIndex++);
              out.write("\" href=\"javascript:submitResourceORSDetail( '");
              out.print(orsFacRow.getSzNbrOrsRsrcId());
              out.write("')\">");
              out.print(orsFacName);
              out.write(" </a></td>\r\n\t     ");
        }
	         // SIR 23730 Phase II Mobile End
	     
              out.write("\r\n\t          <td><nobr>");
              out.print(orsFacRow.getSzNbrOrsRsrcId()!= null ? orsFacRow.getSzNbrOrsRsrcId():StringHelper.EMPTY_STRING );
              out.write("</td>\r\n\t          <td><nobr>");
              out.print(orsFacRow.getSzTxtOrsFacStatus()!=null ? orsFacRow.getSzTxtOrsFacStatus() : "&nbsp;");
              out.write("</td>\r\n\t    </tr>\r\n\t    ");
 
	     orsFacLoopCount ++;
       }
   
    }
    else
    {
      
              out.write("\r\n      <tr class=\"odd\"><td colspan=\"4\">No Results Found</td></tr>\r\n  ");
}
              out.write("\r\n   </table>\r\n </div>\r\n\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n        <td align=\"left\" colspan=\"2\">\r\n        ");
 
    // SIR 23730 Phase II Mobile Start
        if( !PlatformConstants.MOBILE_IMPACT )
      {
      if( !deleteOrsFacButtonHide ){
              out.write("\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_4.setName("btnDeleteOrsFacility");
              _jspx_th_impact_ButtonTag_4.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_4.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_4.setFunction("return submitFormToDelete( '/resource/ResourceDetail/deleteOrsFacility' );");
              _jspx_th_impact_ButtonTag_4.setForm("frmResourceDetail");
              _jspx_th_impact_ButtonTag_4.setAction("/resource/ResourceDetail/deleteOrsFacility");
              _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
  }
      }// Phase II Mobile End
    
              out.write("\r\n        </td>\r\n        <td align=\"right\" colspan=\"3\">\r\n        ");

    // SIR 23730 Phase II Mobile Start
         if( !PlatformConstants.MOBILE_IMPACT )
      {
          if( !addOrsFacButtonHide  ){
              out.write("\r\n              ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_5.setName("btnAddOrsFacility");
              _jspx_th_impact_ButtonTag_5.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_5.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_5.setAlign("right");
              _jspx_th_impact_ButtonTag_5.setEditableMode( EditableMode.EDIT );
              _jspx_th_impact_ButtonTag_5.setFunction("return submitFacilityDetail();");
              _jspx_th_impact_ButtonTag_5.setForm("frmResourceDetail");
              _jspx_th_impact_ButtonTag_5.setAction("/resource/ResourceDetail/addORSResource");
              _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
              if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
  }
      }// SIR 23730 Phase II Mobile End
    
              out.write("\r\n        </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
if( !saveResourceButtonHide ){
          out.write("\r\n  <table width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        <hr>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td align=\"right\" colspan=\"11\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSaveResourceDetail");
          _jspx_th_impact_ButtonTag_6.setImg("btnSave");
          _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_6.setAlign("right");
          _jspx_th_impact_ButtonTag_6.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_6.setFunction("return saveResourceDetailWindow('U');");
          _jspx_th_impact_ButtonTag_6.setForm("frmResourceDetail");
          _jspx_th_impact_ButtonTag_6.setAction("/resource/ResourceDetail/saveResourceDetail");
          _jspx_th_impact_ButtonTag_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
}
          out.write("\r\n\r\n\r\n     <!--EndMain Content-->\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n<input type=\"hidden\" name=\"");
          out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
          out.write("\"/>\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CFACTYP4");
    _jspx_th_impact_codeArray_0.setArrayName("facilitytype4");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
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
    _jspx_th_impact_validateInput_0.setName("indexNum");
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
    _jspx_th_impact_validateInput_1.setName("cReqFuncCd");
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
    _jspx_th_impact_validateInput_2.setName("WindowName");
    _jspx_th_impact_validateInput_2.setValue("ResourceDetail");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("txtuIdRsrcLinkParent");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_8.setName("validationOverride");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifServerImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifServerImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
    _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
    if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n  <div id=\"ResourceDtlAddressScroll\" style=\"OVERFLOW:auto;  WIDTH:764px; HEIGHT:100px\" class=\"tableBorder\">\r\n  ");
    }
    if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
    int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n  <div id=\"ResourceDtlAddressScroll\" style=\"OVERFLOW:auto;  WIDTH:100%; HEIGHT:100px\" class=\"tableBorder\">\r\n  ");
    }
    if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_attribute_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_include_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:attribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
    _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
    _jspx_th_impact_attribute_1.setName("SubcontractorSubvpredisplay");
    _jspx_th_impact_attribute_1.setValue(new String("true"));
    int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
    if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_attribute_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_include_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:attribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
    _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
    _jspx_th_impact_attribute_2.setName("SubcontractorSubvviewOnly");
    _jspx_th_impact_attribute_2.setValue(new String("false"));
    int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
    if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
