package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.web.resource.VendorStaffDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;

public final class VendorStaffDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Initialize tabIndex
  int tabIndex = 1;
  String disableTxtOther = "false";
  int resourceCount = 0;
  //Same as in the VendorStaffDetailConversation.java
    //Note: the following are only used in SHINES
  String SHINES_STAFF_LIST = "shinesActive";
  
  String SHINES_PENDING_STAFF_LIST = "shinesPending";
  
  String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  
  String SEC_VENDOR_STAFF_ACCESS = "SEC_VENDOR_STAFF_ACCESS";

  String FROM_LIST_PAGE = "FROM_LIST_PAGE";
  
  String FROM_RSRC_SEARCH = "FROM_RSRC_SEARCH";
  // Get the serialized request
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
  List resourceIDList = new ArrayList();
  String idVendor = StringHelper.EMPTY_STRING;
  String nmUserFirst = StringHelper.EMPTY_STRING;
  String nmUserMiddle = StringHelper.EMPTY_STRING;
  String nmUserLast = StringHelper.EMPTY_STRING;
  String disableStatus = "false";
  String disableAssocVndrRadio = "false";
  String txtTitle = StringHelper.EMPTY_STRING;
  String txtUserEmail = StringHelper.EMPTY_STRING;
  String nbrUserPhone = StringHelper.EMPTY_STRING;
  String nbrUserPhoneExtension = StringHelper.EMPTY_STRING;
  String addrUserAddrStLn1 = StringHelper.EMPTY_STRING;
  String addrUserAddrStLn2 = StringHelper.EMPTY_STRING;
  String addrUserAddrCity = StringHelper.EMPTY_STRING;
  String addrUserAddrZip = StringHelper.EMPTY_STRING;
  String addrUserAddrZipStuff = StringHelper.EMPTY_STRING;
  String cdUserAddrState = StringHelper.EMPTY_STRING;
  String cdUserAddrCounty = StringHelper.EMPTY_STRING;
  String selectedPuvlId = StringHelper.EMPTY_STRING;
  String selectedRsrcNm = StringHelper.EMPTY_STRING;
  String selectedRsrcId = StringHelper.EMPTY_STRING;
  String selectedType = StringHelper.EMPTY_STRING;
  String selectedStatus = StringHelper.EMPTY_STRING;
  String selectedStartDt = StringHelper.EMPTY_STRING;
  String selectedEndDt = StringHelper.EMPTY_STRING;
  String populateFields = StringHelper.EMPTY_STRING;
  String userAccessType = StringHelper.EMPTY_STRING;
  String cdReqType = StringHelper.EMPTY_STRING;
  String txtOther = StringHelper.EMPTY_STRING;
  String selectFlagVal = StringHelper.BOOLEAN_TRUE;
  String addFlagVal = StringHelper.BOOLEAN_FALSE;
  String destinationUrl = StringHelper.EMPTY_STRING;
  String radioRsrcChecked = StringHelper.EMPTY_STRING;
  if (retrieveVendorStaffDetailSO!=null){
  	resourceIDList = retrieveVendorStaffDetailSO.getResourceList();
  	if (resourceIDList != null && resourceIDList.size() > 0){
  	  Option option = (Option)resourceIDList.get(0);
  	  idVendor = String.valueOf(option.getKey());
  	}
  	if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST))){
  	  if (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST)){
  	   destinationUrl = "/resource/VendorStaffDetail/setResourcePending";
  	  }else if (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST)){
  	   destinationUrl = "/resource/VendorStaffDetail/setResource";
  	  }else if (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)){
  	   destinationUrl = "/resource/VendorStaffDetail/setResourceStaff";
  	  }
  	  disableStatus = (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST)||
  	  					retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST))?
  	  																				"true":"false";		 
  	  userAccessType = retrieveVendorStaffDetailSO.getUserAccessType();
  	  cdReqType = retrieveVendorStaffDetailSO.getCdRequestType();
  	  nmUserFirst = retrieveVendorStaffDetailSO.getNmUserFirst();
  	  nmUserMiddle = retrieveVendorStaffDetailSO.getNmUserMiddle();
  	  nmUserLast = retrieveVendorStaffDetailSO.getNmUserLast();
  	  txtTitle = retrieveVendorStaffDetailSO.getTxtTitle();
  	  txtUserEmail = retrieveVendorStaffDetailSO.getTxtUserEmail();
  	  nbrUserPhone = retrieveVendorStaffDetailSO.getNbrUserPhone();
  	  nbrUserPhoneExtension = retrieveVendorStaffDetailSO.getNbrUserPhoneExtension();
  	  addrUserAddrStLn1 = retrieveVendorStaffDetailSO.getAddrUserAddrStLn1();
  	  addrUserAddrStLn2 = retrieveVendorStaffDetailSO.getAddrUserAddrStLn2();
  	  addrUserAddrCity = retrieveVendorStaffDetailSO.getAddrUserAddrCity();
  	  txtOther = retrieveVendorStaffDetailSO.getTxtOther();
  	  if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 9) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  	addrUserAddrZipStuff = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(5);
  	  }else if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() < 9 
  	  				&& retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 5) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  }
  	  
  	  cdUserAddrState = retrieveVendorStaffDetailSO.getCdUserAddrState();
  	  cdUserAddrCounty = retrieveVendorStaffDetailSO.getCdUserAddrCounty();
  	}
  }  

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction nameContains(eElem, str) {\r\n  var bContains = false;\r\n  bContains = (-1 != (eElem.name.indexOf(str)));\r\n  return bContains;\r\n}\r\n\r\n/*\r\n*  Function Name:  CheckWidget\r\n*  Parameters:  eElem - HTML Widget\r\n*  Returns:  Boolean - True if widget changed, False if widget is the same\r\n*\r\n*  Description:  Evaluates present value of widget against default value to determine\r\n*  if there has been a change. Exludes any widget that end in the _CLEAN Suffix\r\n*  so that certain fields will not dirty the page.\r\n*/\r\nfunction CheckWidget(eElem) {\r\n\r\n  // Variable which is returned\r\n  var booChange = false;\r\n  // if this variable has a _CLEAN in the name, do nothing\r\n  if (!nameContains(eElem, \"CLEAN\")) {\r\n    if (\"text\" == eElem.type || \"TEXTAREA\" == eElem.tagName) {\r\n      if ((\"dtStart\"!=eElem.name && \"dtEnd\"!=eElem.name) && eElem.value != eElem.defaultValue) {\r\n        booChange = true;\r\n");
      out.write("      }\r\n    } else if (\"SELECT\" == eElem.tagName) {\r\n      var cOpts = eElem.options;\r\n      var iNumOpts = cOpts.length;\r\n      for (var j = 0; j < iNumOpts; j++) {\r\n        var eOpt = cOpts[j];\r\n        if ((\"selStatus\"!= eElem.name && \"selUserType\"!= eElem.name) && eOpt.selected != eOpt.defaultSelected) {\r\n          booChange = true;\r\n\r\n        }\r\n      }\r\n    }\r\n  }\r\n\r\n  return booChange;\r\n}\r\n\r\n/*\r\n*  Function Name:  isFormChanged\r\n*  Parameters:  None\r\n*  Returns:  Boolean\r\n*\r\n*  Description:  Evaluates a form to see if anything in the form has changed.\r\n*  Returns true if something has changed.\r\n*/\r\nfunction isFormChanged(form) {\r\n  var booDirtyForm = false;\r\n  var iNumElements = form.elements.length;\r\n\r\n  //  Loop through the form elements\r\n  for (x = 0; x < iNumElements; x++) {\r\n    if (!form.elements[x].disabled && CheckWidget(form.elements[x])) {\r\n      //alert ('Widget changed!!!');\r\n      booDirtyForm = true;\r\n      break;\r\n    }\r\n  }\r\n  return booDirtyForm;\r\n}\r\n\r\n/*\r\n*  Function Name:  isFormChanged\r\n");
      out.write("*  Parameters:  None\r\n*  Returns:  Boolean\r\n*\r\n*  Description:  Evaluates a form to page has changed by looping through all\r\n*  the forms to see if they have changed.\r\n*  Returns true if something has changed.\r\n*/\r\nfunction isPageChanged() {\r\n  var iNumForms = document.forms.length;\r\n  var booDirtyForm = false;\r\n  //  For each form loop through its elements\r\n  for (i = 0; i < iNumForms; i++) {\r\n    if (isFormChanged(document.forms[i])) {\r\n      //alert ('Form changed!!!');\r\n      booDirtyForm = true;\r\n      break;\r\n    }\r\n  }\r\n  return booDirtyForm;\r\n}\r\n\r\n/*\r\n*  User can set page to present IsDirty popup message by calling\r\n*  setPageDirtyFlag( true );  Useful for pullbacks where page\r\n*  loads clean but data has actually changed prior to pullback, \r\n*  or for display-only field changes.\r\n*/\r\nvar pageDirtyFlag = false;\r\n\r\nfunction setPageDirtyFlag(dirty) {\r\n  pageDirtyFlag = dirty;\r\n}\r\n\r\n/*\r\n*  Function Name:  IsDirty\r\n*  Parameters:  None\r\n*  Returns:  None\r\n*\r\n*  Description:  Evaluates all the forms on a web page.  If the form's elements have\r\n");
      out.write("*  changed from their default state the user is prompted to save before leaving the page.\r\n*  The isDirtyCalled var is available from impact.js.  It was moved there to ensure its\r\n*  availability on every page, since dirtyForm.js isn't used on each page.  The button\r\n*  tag now references this var instead of nulling the onbeforeunload method.\r\n*/\r\nfunction IsDirtyhere() {\r\n  if (!hrefDirtyBypass) {\r\n    // Variable to hold all the forms on a page\r\n    var booDirtyForm = false;\r\n    booDirtyForm = isPageChanged();\r\n    var vendorDetailDirty = false;\r\n    vendorDetailDirty = checkIsDirty();    \r\n    /*\r\n    * If the form is dirty prompt the user before leaving the page.\r\n    */\r\n    if (( pageDirtyFlag || booDirtyForm || vendorDetailDirty ) && !isDirtyCalled) {\r\n      event.returnValue = \"Your unsaved data will be lost.\";\r\n      //MessageBox.show(\"Version: Visual J++ 6.0\", \"MyNotepad\");\r\n    }\r\n    isDirtyCalled = false;\r\n  }\r\n  hrefDirtyBypass = false;\r\n}\r\n  rbSelected = new Boolean(false);\r\n  function populateFields(idPuvl, nmResource, idResource, cdAccessType, cdStatus, dtStart, dtEnd) {\r\n");
      out.write("    document.frmVndrStaffDtl.hdnSelectedPuvlId.value = idPuvl;\r\n    document.frmVndrStaffDtl.hdnSelectedRsrcNm.value = nmResource;\r\n\tdocument.frmVndrStaffDtl.hdnSelectedRsrcId.value = idResource;\r\n\tdocument.frmVndrStaffDtl.hdnSelUserType.value = cdAccessType;\r\n\tdocument.frmVndrStaffDtl.hdnSelStatus.value = cdStatus;\r\n\tdocument.frmVndrStaffDtl.hdnDtStart.value = dtStart;\r\n\tdocument.frmVndrStaffDtl.hdnDtEnd.value = dtEnd;\r\n  }\r\n  \r\n  // This function is called before the page unloads.\r\n\twindow.onbeforeunload = function ()\r\n\t{\r\n    \tIsDirtyhere();\r\n\t}\r\n  function fillFields(){\r\n  \t//disableValidation(\"frmVndrStaffDtl\");\r\n\tif (checkIsDirty()){\r\n\t\tif (!confirm(\"Your unsaved data will be lost.\")){\r\n\t\t\treturn false;\r\n\t\t}\r\n\t}\r\n\t//Set the Select Flag True and Add Flag False to mark for Update\r\n\tdocument.frmVndrStaffDtl.hdnSelectFlag.value = \"");
      out.print( StringHelper.BOOLEAN_TRUE );
      out.write("\";\r\n\tdocument.frmVndrStaffDtl.hdnAddFlag.value = \"");
      out.print( StringHelper.BOOLEAN_FALSE );
      out.write("\";\r\n\t//Rewriting the inner HTML to display the Resource Name and Resource ID  \t\r\n  \tdocument.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;\r\n\tdocument.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;\r\n\t//Setting the New selected Row\r\n\tdocument.frmVndrStaffDtl.selUserType.value = document.frmVndrStaffDtl.hdnSelUserType.value;\r\n\tdocument.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;\r\n\tdocument.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;\r\n\tdocument.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;\r\n\t//Setting the new selecte row value to the display hidden variables\r\n\tdocument.frmVndrStaffDtl.hdnDisplayPuvlId.value = document.frmVndrStaffDtl.hdnSelectedPuvlId.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;\r\n");
      out.write("\tdocument.frmVndrStaffDtl.hdnDisplayUserType.value = document.frmVndrStaffDtl.hdnSelUserType.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;   \r\n  }\r\n  function checkIsDirty(){\r\n  \tvar booDirty = false;\r\n    if (document.frmVndrStaffDtl.selUserType.value != document.frmVndrStaffDtl.hdnDisplayUserType.value||\r\n    \tdocument.frmVndrStaffDtl.selStatus.value != document.frmVndrStaffDtl.hdnDisplayStatus.value ||\r\n    \tdocument.frmVndrStaffDtl.dtStart.value != document.frmVndrStaffDtl.hdnDisplayDtStart.value ||\r\n    \tdocument.frmVndrStaffDtl.dtEnd.value != document.frmVndrStaffDtl.hdnDisplayDtEnd.value){\r\n    \tbooDirty = true;\r\n    } \r\n    return booDirty; \t\r\n  }\r\n  \r\n  function getResource(){\r\n    var selNewRsrc = document.frmVndrStaffDtl.selNewVendor.value;\r\n    var selNewRsrcNm = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n    var selNewRsrcId = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n    if (selNewRsrc.length > 0){\r\n    \tvar commaLocation = selNewRsrc.search(\",\");\r\n    \tif (commaLocation > 0){\r\n    \t\tselNewRsrcNm = selNewRsrc.substring(commaLocation+1);\r\n    \t\tselNewRsrcId = selNewRsrc.substring(0,commaLocation);\r\n    \t}\r\n    }\r\n    document.frmVndrStaffDtl.hdnAddNewRsrcNm.value = selNewRsrcNm;\r\n\tdocument.frmVndrStaffDtl.hdnAddNewRsrcId.value = selNewRsrcId;\r\n\t//Set default as User and status as Pending  \r\n\tdocument.frmVndrStaffDtl.hdnAddNewUserType.value = \"");
      out.print( CodesTables.CUSRTYP_PUS );
      out.write("\";\r\n\tdocument.frmVndrStaffDtl.hdnAddNewStatus.value = \"");
      out.print( CodesTables.CUSRSTAT_PEN );
      out.write("\";\r\n\tdocument.frmVndrStaffDtl.hdnAddNewDtStart.value = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n\tdocument.frmVndrStaffDtl.hdnAddNewDtEnd.value = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\"; \t\r\n  }\r\n  \r\n  function setNewResource(){\r\n    if (document.frmVndrStaffDtl.selNewVendor.value.length <= 0){\r\n    \talert(\"Please Choose a vendor before continue...\");\r\n    \treturn false;\r\n    }\r\n    //Set the Select Flag False and Add Flag True to mark for Insert\r\n\tdocument.frmVndrStaffDtl.hdnSelectFlag.value = \"");
      out.print( StringHelper.BOOLEAN_FALSE );
      out.write("\";\r\n\tdocument.frmVndrStaffDtl.hdnAddFlag.value = \"");
      out.print( StringHelper.BOOLEAN_TRUE );
      out.write("\";\r\n\t//Rewriting the inner HTML to display the Resource Name and Resource ID  \t\r\n  \tdocument.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;\r\n\tdocument.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;\r\n\t//Setting the New selected Row\r\n\tdocument.frmVndrStaffDtl.selUserType.value = document.frmVndrStaffDtl.hdnAddNewUserType.value;\r\n\tdocument.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;\r\n\tdocument.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;\r\n\tdocument.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;\r\n\t//Setting the new selecte row value to the display hidden variables\r\n\tdocument.frmVndrStaffDtl.hdnDisplayPuvlId.value = \"0\";\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayUserType.value = document.frmVndrStaffDtl.hdnAddNewUserType.value;\r\n");
      out.write("\tdocument.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;\t  \r\n  }\r\n  function disableValidate(){\r\n \tdisableValidation(\"frmVndrStaffDtl\");\r\n  }\r\n  function warnPasswordReset()\r\n  {\r\n    disableValidate();\r\n    var returnVal = true;\r\n    returnVal = confirm( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_REST_WARN ));
      out.write("\" );\r\n    return returnVal;\r\n  }\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmVndrStaffDtl");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/VendorStaffDetail/saveVendorStaffDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.VendorStaffDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n<table border=\"0\"  cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n\t<tr>\r\n\t  <td>                   \r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t  \t<tr>\r\n\t\t    \t<th colspan=\"6\">Basic Data</th>\r\n\t\t  \t</tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setConstraint("Name");
          _jspx_th_impact_validateInput_0.setName("txtFirstName");
          _jspx_th_impact_validateInput_0.setLabel("First Name");
          _jspx_th_impact_validateInput_0.setSize("12");
          _jspx_th_impact_validateInput_0.setMaxLength("12");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString(nmUserFirst));
          _jspx_th_impact_validateInput_0.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setConstraint("Name");
          _jspx_th_impact_validateInput_1.setName("txtMiddleInitial");
          _jspx_th_impact_validateInput_1.setLabel("Middle Initial");
          _jspx_th_impact_validateInput_1.setSize("2");
          _jspx_th_impact_validateInput_1.setMaxLength("1");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString(nmUserMiddle));
          _jspx_th_impact_validateInput_1.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setConstraint("Name");
          _jspx_th_impact_validateInput_2.setName("txtLastName");
          _jspx_th_impact_validateInput_2.setLabel("Last Name");
          _jspx_th_impact_validateInput_2.setSize("22");
          _jspx_th_impact_validateInput_2.setMaxLength("22");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(nmUserLast));
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setConstraint("Name");
          _jspx_th_impact_validateInput_3.setName("txtTitle");
          _jspx_th_impact_validateInput_3.setLabel("Title");
          _jspx_th_impact_validateInput_3.setSize("20");
          _jspx_th_impact_validateInput_3.setMaxLength("20");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(txtTitle));
          _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setConstraint("Email");
          _jspx_th_impact_validateInput_4.setName("txtEmail");
          _jspx_th_impact_validateInput_4.setLabel("Email");
          _jspx_th_impact_validateInput_4.setSize("50");
          _jspx_th_impact_validateInput_4.setMaxLength("320");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString(txtUserEmail));
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setConstraint("Phone");
          _jspx_th_impact_validateInput_5.setName("txtPhoneNumber");
          _jspx_th_impact_validateInput_5.setLabel("Phone Number");
          _jspx_th_impact_validateInput_5.setSize("15");
          _jspx_th_impact_validateInput_5.setMaxLength("15");
          _jspx_th_impact_validateInput_5.setRequired("true");
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatPhone(nbrUserPhone));
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_6.setName("txtPhoneExtension");
          _jspx_th_impact_validateInput_6.setLabel("Ext");
          _jspx_th_impact_validateInput_6.setSize("10");
          _jspx_th_impact_validateInput_6.setMaxLength("10");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatString(nbrUserPhoneExtension));
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setConstraint("Address");
          _jspx_th_impact_validateInput_7.setName("txtAddress1");
          _jspx_th_impact_validateInput_7.setLabel("Office Address");
          _jspx_th_impact_validateInput_7.setSize("30");
          _jspx_th_impact_validateInput_7.setMaxLength("30");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatString(addrUserAddrStLn1));
          _jspx_th_impact_validateInput_7.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td></td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setConstraint("Address2");
          _jspx_th_impact_validateInput_8.setName("txtAddress2");
          _jspx_th_impact_validateInput_8.setSize("30");
          _jspx_th_impact_validateInput_8.setMaxLength("30");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatString(addrUserAddrStLn2));
          _jspx_th_impact_validateInput_8.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>                                            \r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setConstraint("City");
          _jspx_th_impact_validateInput_9.setName("txtCity");
          _jspx_th_impact_validateInput_9.setLabel("City");
          _jspx_th_impact_validateInput_9.setSize("20");
          _jspx_th_impact_validateInput_9.setMaxLength("20");
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatString(addrUserAddrCity));
          _jspx_th_impact_validateInput_9.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setName("selState");
          _jspx_th_impact_validateSelect_0.setLabel("State");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(cdUserAddrState));
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t     </tr>\r\n\t\t     <tr>                                            \r\n\t\t       <td>\r\n\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setConstraint("Zip");
          _jspx_th_impact_validateInput_10.setName("txtZip");
          _jspx_th_impact_validateInput_10.setLabel("Zip");
          _jspx_th_impact_validateInput_10.setSize("5");
          _jspx_th_impact_validateInput_10.setMaxLength("5");
          _jspx_th_impact_validateInput_10.setRequired("true");
          _jspx_th_impact_validateInput_10.setValue(FormattingHelper.formatString(addrUserAddrZip));
          _jspx_th_impact_validateInput_10.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t       \t&nbsp;&nbsp; - &nbsp;&nbsp;\r\n\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_11.setName("txtZipSuff");
          _jspx_th_impact_validateInput_11.setSize("4");
          _jspx_th_impact_validateInput_11.setMaxLength("4");
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatString(addrUserAddrZipStuff));
          _jspx_th_impact_validateInput_11.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t       </td>\r\n\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setName("selCounty");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(cdUserAddrCounty));
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>       \r\n\t\t     </tr> \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest((retrieveVendorStaffDetailSO.getScreenName()!=null &&
    							!retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)) );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    \t\t\t\t\t\t\t\r\n\t\t<tr>\r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"2\">Access Request</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_2.setName("selReqType");
              _jspx_th_impact_validateSelect_2.setLabel("Request Type");
              _jspx_th_impact_validateSelect_2.setCodesTable("CUSRTYP");
              _jspx_th_impact_validateSelect_2.setDisabled("true");
              _jspx_th_impact_validateSelect_2.setValue(cdReqType );
              _jspx_th_impact_validateSelect_2.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t    </tr>\r\n\t\t\t\t  <tr>    \r\n\t\t\t\t    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 160px");
              _jspx_th_impact_validateSelect_3.setLabel("Vendor");
              _jspx_th_impact_validateSelect_3.setName("selVendor");
              _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 240px");
              _jspx_th_impact_validateSelect_3.setOverrideDisplayBadCodes(true);
              _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(idVendor));
              _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_3.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_validateSelect_3.setDisabled("true");
              _jspx_th_impact_validateSelect_3.setOptions(resourceIDList);
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t    </td>    \r\n\t\t\t\t  </tr>\t\t\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_validateInput_12.setType("text");
              _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_12.setConstraint("Address");
              _jspx_th_impact_validateInput_12.setName("txtOther");
              _jspx_th_impact_validateInput_12.setLabel("Other");
              _jspx_th_impact_validateInput_12.setSize("30");
              _jspx_th_impact_validateInput_12.setMaxLength("30");
              _jspx_th_impact_validateInput_12.setValue(txtOther);
              _jspx_th_impact_validateInput_12.setEditableMode(EditableMode.ALL );
              _jspx_th_impact_validateInput_12.setDisabled("true");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t    </tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td colspan=2>\r\n\t\t\t     \tIf you work for multiple resources under an umbrella organization, please submit a registration for access to one resource first. Your administrator will then be able to link you to multiple resources.\r\n\t\t\t     </td>\r\n\t\t\t     </tr>     \r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\r\n\t");
 
		if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST))){
  			List<RetrieveVendorStaffLinkDetailBean> resourceListForUser = retrieveVendorStaffDetailSO.getResourceListforUser();
  	
          out.write("\r\n\t<tr>      \r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t  \t<tr>\r\n\t\t  \t\t<td></td>\r\n\t\t  \t\t<td width=\"100%\">\r\n\t\t  \t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Save");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmVndrStaffDtl");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/VendorStaffDetail/saveVendorStaffDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t  \t\t</td>\r\n\t\t  \t</tr>\r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>  \t\r\n\t<tr>\r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" width=\"100%\" align=\"center\">\r\n\t\t    <tr>\r\n\t\t    \t<th>Associated Vendors</th>\r\n\t\t  \t</tr>\r\n\t\t  \t<tr>\r\n\t\t  \t  <td>\r\n\t\t  \t    <div id=\"noScrollResults\" style=\"height:190px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t      <tr>\r\n\t\t\t\t        <th class=\"thList\">&nbsp;</th>\r\n\t\t\t\t        <th class=\"thList\">Resource Name</th>\r\n\t\t\t\t        <th class=\"thList\">Resource ID</th>\r\n\t\t\t\t        <th class=\"thList\">Type</th>\r\n\t\t\t\t        <th class=\"thList\">Status</th>\r\n\t\t\t\t        <th class=\"thList\">Start Date</th>\r\n\t\t\t\t        <th class=\"thList\">End Date</th>\r\n\t\t\t\t      </tr>\r\n\t\t\t      ");

			         if (resourceListForUser.size() <= 0){
			      
          out.write("\r\n\t\t\t          <tr class=\"odd\">\r\n\t\t\t            <td colspan=\"4\">\r\n\t\t\t              \r\n\t\t\t            </td>\r\n\t\t\t          </tr>\r\n\t\t\t      \t<tr>\r\n\t\t\t          ");

			      		} else {
			      			for (Iterator<RetrieveVendorStaffLinkDetailBean> it = resourceListForUser.iterator();it.hasNext();){
					          RetrieveVendorStaffLinkDetailBean vendorStaffLinkDetBean = 
					          			(RetrieveVendorStaffLinkDetailBean) it.next();
							  radioRsrcChecked = "false";					          			
					          //Get the first row and load it during the initial load
					          if (resourceCount == 0){
					            radioRsrcChecked = "true";
					            selectedPuvlId = FormattingHelper.formatString(
	  														String.valueOf(vendorStaffLinkDetBean.getIdPortalUserVendorLink()));
			            	  	selectedRsrcNm = vendorStaffLinkDetBean.getNmResource();
	  							selectedRsrcId = FormattingHelper.formatString(
	  														String.valueOf(vendorStaffLinkDetBean.getIdResource()));
						  	  	selectedType = vendorStaffLinkDetBean.getCdAccessType();
						  	  	selectedStatus = vendorStaffLinkDetBean.getCdStatus();
						  	  	selectedStartDt = FormattingHelper.formatString(
						  	  						String.valueOf(vendorStaffLinkDetBean.getDtStart()).equals("null")?
						  	  						StringHelper.EMPTY_STRING:String.valueOf(DateHelper.SLASH_FORMAT.format(vendorStaffLinkDetBean.getDtStart())));
						  	  	selectedEndDt = FormattingHelper.formatString(
						  	  						String.valueOf(vendorStaffLinkDetBean.getDtEnd()).equals("null")?
						  	  						StringHelper.EMPTY_STRING:String.valueOf(DateHelper.SLASH_FORMAT.format(vendorStaffLinkDetBean.getDtEnd())));
					          }
					          String rowCss = FormattingHelper.getRowCss(resourceCount + 1);
					          populateFields = "populateFields('" + String.valueOf( vendorStaffLinkDetBean.getIdPortalUserVendorLink() )
					          								+ "','"+ FormattingHelper.formatString(vendorStaffLinkDetBean.getNmResource()).replaceAll("'","") 
					          								+ "','"+String.valueOf( vendorStaffLinkDetBean.getIdResource() )
					          								+ "','"+FormattingHelper.formatString(vendorStaffLinkDetBean.getCdAccessType())
					          								+ "','"+FormattingHelper.formatString(vendorStaffLinkDetBean.getCdStatus())
					          								+ "','"+FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtStart())
					          								+ "','"+FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtEnd())
					          								+ "');";
			      	  
          out.write("\r\n\t\t\t      <tr class=\"");
          out.print(rowCss);
          out.write("\">\r\n\t\t\t        <td width=\"5%\">\r\n\t\t\t          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setName("rbResource");
          _jspx_th_impact_validateInput_13.setChecked(radioRsrcChecked);
          _jspx_th_impact_validateInput_13.setValue( String.valueOf( vendorStaffLinkDetBean.getIdPortalUserVendorLink() ) );
          _jspx_th_impact_validateInput_13.setOnClick(populateFields);
          _jspx_th_impact_validateInput_13.setDisabled(disableAssocVndrRadio);
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t        <td>");
          out.print( FormattingHelper.formatString(vendorStaffLinkDetBean.getNmResource()) );
          out.write("\r\n\t\t\t        </td>\r\n\t\t\t        <td>");
          out.print( FormattingHelper.formatString(String.valueOf(vendorStaffLinkDetBean.getIdResource())) );
          out.write("\r\n\t\t\t        </td>\r\n\t\t\t        <td>");
          out.print( vendorStaffLinkDetBean.getCdAccessType() != null ?
                			Lookup.simpleDecodeSafe("CUSRTYP", vendorStaffLinkDetBean.getCdAccessType()) : "&nbsp;" );
          out.write("\r\n\t\t\t        </td>\r\n\t\t\t        <td>");
          out.print( vendorStaffLinkDetBean.getCdStatus() != null ?
                			Lookup.simpleDecodeSafe("CUSRSTAT", vendorStaffLinkDetBean.getCdStatus()) : "&nbsp;" );
          out.write("\r\n\t\t\t        </td>\r\n\t\t\t        <td>");
          out.print( FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtStart()) );
          out.write("</td>\r\n\t\t\t        <td>");
          out.print( FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtEnd()) );
          out.write("</td>\r\n\t\t\t      </tr>\r\n\t\t\t      ");

			        resourceCount++;
			      	}
			        }
          out.write("\r\n\t\t\t    </table>\r\n\t\t\t  </div>\t\r\n\t\t\t </td>\r\n\t\t    </tr>   \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n    ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest((resourceListForUser.size() > 0 && userAccessType.equals(SEC_VENDOR_STAFF_ACCESS)) );
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t<img align=\"left\" src=\"/grnds-docs/images/shared/btnSelect.gif\" name=\"select\" \r\n\t\t\t  \t\t\t\t\tonclick=\"return fillFields();\" >\r\n\t\t\t        </td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_ButtonTag_1.setName("Delete");
              _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_1.setAlign("right");
              _jspx_th_impact_ButtonTag_1.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_1.setAction("/resource/VendorStaffDetail/deleteVendor");
              _jspx_th_impact_ButtonTag_1.setFunction("disableValidate();");
              _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n   \t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest((userAccessType.equals(SEC_VENDOR_STAFF_ACCESS)) );
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write(" \r\n    ");

    	//Set the Resource Name and Resource ID if the page pulled back from the Resource Search
    	//Otherwise use the default Retrieved resource Name and ID from the DB
    	if (FROM_RSRC_SEARCH.equals(retrieveVendorStaffDetailSO.getFromPage())){
    		selectedRsrcNm = FormattingHelper.formatString(
    							retrieveVendorStaffDetailSO.getNmResource()!=null?
    							retrieveVendorStaffDetailSO.getNmResource():selectedRsrcNm);
    		selectedRsrcId = retrieveVendorStaffDetailSO.getIdResource()!=null?
    						String.valueOf(retrieveVendorStaffDetailSO.getIdResource()):selectedRsrcId;
    		selectedType = StringHelper.EMPTY_STRING;
    		selectedStatus = retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)?CodesTables.CUSRSTAT_ACT:CodesTables.CUSRSTAT_PEN;
    		selectFlagVal = StringHelper.BOOLEAN_FALSE;
    		addFlagVal = StringHelper.BOOLEAN_TRUE;
  			selectedStartDt = StringHelper.EMPTY_STRING;
  			selectedEndDt = StringHelper.EMPTY_STRING;
    	}
     
              out.write("\r\n\t\t<tr>\r\n\t\t  <td>                   \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t  \t<tr>\r\n\t\t\t    \t<th colspan=\"6\">Selected Vendor Detail</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t     <tr>\r\n\t\t\t       <td>\r\n\t\t\t       \t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("rsrcNm");
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Resource Name");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue(selectedRsrcNm );
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\t\t       \r\n\t\t\t       \t\t\r\n\t\t\t\t\t</td>\r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\r\n\t\t\t       \t<td>\r\n\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateDisplayOnlyField_1.setName("rsrcId");
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Resource ID");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue(selectedRsrcId );
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\t\t                                            \r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\r\n\t\t\t       <td></td>\r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\t\t                                            \r\n\t       \t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_4.setName("selUserType");
              _jspx_th_impact_validateSelect_4.setLabel("User Type");
              _jspx_th_impact_validateSelect_4.setCodesTable("CUSRTYP");
              _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_4.setValue(selectedType);
              _jspx_th_impact_validateSelect_4.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\t\t                                            \r\n\t       \t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_5.setName("selStatus");
              _jspx_th_impact_validateSelect_5.setLabel("Status");
              _jspx_th_impact_validateSelect_5.setCodesTable("CUSRSTAT");
              _jspx_th_impact_validateSelect_5.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_5.setOptions( VendorStaffDetailConversation.getMethodOptions(retrieveVendorStaffDetailSO.getScreenName() !=null ? retrieveVendorStaffDetailSO.getScreenName(): "") );
              _jspx_th_impact_validateSelect_5.setValue(selectedStatus);
              _jspx_th_impact_validateSelect_5.setDisabled(disableStatus );
              _jspx_th_impact_validateSelect_5.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     </tr>\t\t     \r\n\t\t\t     <tr>\r\n\t\t\t       <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateDate_0.setName("dtStart");
              _jspx_th_impact_validateDate_0.setLabel("Start Date");
              _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_0.setValue(selectedStartDt);
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\r\n\t\t\t       <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateDate_1.setName("dtEnd");
              _jspx_th_impact_validateDate_1.setLabel("End Date");
              _jspx_th_impact_validateDate_1.setValue(selectedEndDt);
              _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     </tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\t<td>\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_ButtonTag_2.setName("SelectResource");
              _jspx_th_impact_ButtonTag_2.setImg("btnSelectResource");
              _jspx_th_impact_ButtonTag_2.setAlign("left");
              _jspx_th_impact_ButtonTag_2.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_2.setAction("/resource/VendorStaffDetail/selectResource");
              _jspx_th_impact_ButtonTag_2.setFunction("disableValidate()");
              _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_ButtonTag_3.setName("Save");
              _jspx_th_impact_ButtonTag_3.setImg("btnSave");
              _jspx_th_impact_ButtonTag_3.setAlign("right");
              _jspx_th_impact_ButtonTag_3.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_3.setAction("/resource/VendorStaffDetail/saveVendorStaffDetail");
              _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_ifThen_3.setTest((retrieveVendorStaffDetailSO.getScreenName()!=null && 
	  							retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)));
              int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
              if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t<tr>\r\n\t\t\t  <td>                   \r\n\t\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t\t  \t<tr>\r\n\t\t\t\t    \t<th colspan=\"6\">Password Reset</th>\r\n\t\t\t\t  \t</tr>\r\n\t\t\t\t     <tr>\t\t                                            \r\n\t\t\t\t\t     <td align=\"left\">\r\n\t\t\t\t\t        Click the reset button to reset this user's password with a temporary password and e-mail the temporary password to the e-mail address above.\r\n\t\t\t\t\t     </td>\r\n\t\t\t\t  \t\t<td>\r\n\t\t\t\t  \t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
                  _jspx_th_impact_ButtonTag_4.setName("Reset");
                  _jspx_th_impact_ButtonTag_4.setImg("btnReset");
                  _jspx_th_impact_ButtonTag_4.setAlign("right");
                  _jspx_th_impact_ButtonTag_4.setForm("frmVndrStaffDtl");
                  _jspx_th_impact_ButtonTag_4.setAction("/resource/VendorStaffDetail/resetPassword");
                  _jspx_th_impact_ButtonTag_4.setFunction("return warnPasswordReset();");
                  _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
                  if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t  \t\t</td>\r\n\t\t\t\t  \t </tr>\t\t     \t\t  \t\r\n\t\t\t\t  </table>\r\n\t\t\t  </td>\r\n\t\t\t</tr>  \r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\t\t\r\n    \t");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_ifThen_4.setTest((retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST))) );
              int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
              if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write(" \t\t\r\n\t\t\t<tr>\r\n\t\t\t  <td>\r\n\t\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t\t  \t<tr>\r\n\t\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t\t  \t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
                  _jspx_th_impact_ButtonTag_5.setName("Approve");
                  _jspx_th_impact_ButtonTag_5.setImg("btnApprove");
                  _jspx_th_impact_ButtonTag_5.setAlign("right");
                  _jspx_th_impact_ButtonTag_5.setForm("frmVndrStaffDtl");
                  _jspx_th_impact_ButtonTag_5.setAction("/resource/VendorStaffDetail/approveVendorStaffDetail");
                  _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
                  if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t        </td>\r\n\t\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t\t  \t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
                  _jspx_th_impact_ButtonTag_6.setName("Disapprove");
                  _jspx_th_impact_ButtonTag_6.setImg("btnDisapprove");
                  _jspx_th_impact_ButtonTag_6.setAlign("right");
                  _jspx_th_impact_ButtonTag_6.setForm("frmVndrStaffDtl");
                  _jspx_th_impact_ButtonTag_6.setAction("/resource/VendorStaffDetail/disapproveVendorStaffDetail");
                  _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_6.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
                  if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t  \t\t</td>\r\n\t\t\t\t  \t</tr>\r\n\t\t\t\t  </table>\r\n\t\t\t  </td>\r\n\t\t\t</tr>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\t\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\t\t\t\t \t  \t\r\n\t");

		}
  	
          out.write("  \t\r\n</table>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnScreenName");
          _jspx_th_impact_validateInput_14.setValue( retrieveVendorStaffDetailSO.getScreenName() );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnSelectFlag");
          _jspx_th_impact_validateInput_15.setValue( selectFlagVal );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("hdnAddFlag");
          _jspx_th_impact_validateInput_16.setValue( addFlagVal );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("hdnSelectedPuvlId");
          _jspx_th_impact_validateInput_17.setValue( selectedPuvlId );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("hdnSelectedRsrcNm");
          _jspx_th_impact_validateInput_18.setValue( selectedRsrcNm );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("hdnSelectedRsrcId");
          _jspx_th_impact_validateInput_19.setValue( selectedRsrcId );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("hdnSelUserType");
          _jspx_th_impact_validateInput_20.setValue( selectedType );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("hdnSelStatus");
          _jspx_th_impact_validateInput_21.setValue( selectedStatus );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("hdnDtStart");
          _jspx_th_impact_validateInput_22.setValue( selectedStartDt );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("hdnDtEnd");
          _jspx_th_impact_validateInput_23.setValue( selectedEndDt );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnDisplayPuvlId");
          _jspx_th_impact_validateInput_24.setValue( selectedPuvlId );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("hdnDisplayRsrcNm");
          _jspx_th_impact_validateInput_25.setValue( selectedRsrcNm );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName("hdnDisplayRsrcId");
          _jspx_th_impact_validateInput_26.setValue( selectedRsrcId );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName("hdnDisplayUserType");
          _jspx_th_impact_validateInput_27.setValue( selectedType );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("hidden");
          _jspx_th_impact_validateInput_28.setName("hdnDisplayStatus");
          _jspx_th_impact_validateInput_28.setValue( selectedStatus );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("hidden");
          _jspx_th_impact_validateInput_29.setName("hdnDisplayDtStart");
          _jspx_th_impact_validateInput_29.setValue( selectedStartDt );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName("hdnDisplayDtEnd");
          _jspx_th_impact_validateInput_30.setValue( selectedEndDt );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("hidden");
          _jspx_th_impact_validateInput_31.setName("hdnAddNewRsrcNm");
          _jspx_th_impact_validateInput_31.setValue( selectedRsrcNm );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("hidden");
          _jspx_th_impact_validateInput_32.setName("hdnAddNewRsrcId");
          _jspx_th_impact_validateInput_32.setValue( selectedRsrcId );
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("hidden");
          _jspx_th_impact_validateInput_33.setName("hdnAddNewUserType");
          _jspx_th_impact_validateInput_33.setValue( selectedType );
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("hidden");
          _jspx_th_impact_validateInput_34.setName("hdnAddNewStatus");
          _jspx_th_impact_validateInput_34.setValue( selectedStatus );
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("hidden");
          _jspx_th_impact_validateInput_35.setName("hdnAddNewDtStart");
          _jspx_th_impact_validateInput_35.setValue( selectedStartDt );
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("hidden");
          _jspx_th_impact_validateInput_36.setName("hdnAddNewDtEnd");
          _jspx_th_impact_validateInput_36.setValue( selectedEndDt );
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("  \r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("hidden");
          _jspx_th_impact_validateInput_37.setName("destinationUrl");
          _jspx_th_impact_validateInput_37.setValue( destinationUrl );
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    \r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  document.frmVndrStaffDtl.txtFirstName.focus();\r\n  //Rewriting the inner HTML to display the Resource Name and Resource ID  \t\r\n  document.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;\r\n  document.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;\r\n</script>");
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
