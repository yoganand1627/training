package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.admin.VendorStaffDetailConversation;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Initialize tabIndex
  int tabIndex = 1;
  int resourceCount = 0;
  //Same as in the VendorStaffDetailConversation.java
  String PORTAL_STAFF_LIST = "portalActive";
  String PORTAL_PENDING_STAFF_LIST = "portalPending";  
  //Same as in the UserProfile.java
  String PLCMNT_PRV_ADMIN = UserProfile.PLCMNT_PRV_ADMIN;
  String PLCMNT_PRV_USRER = UserProfile.PLCMNT_PRV_USRER;
  // SMS #66384: MR-067
  String NYTD_USER = UserProfile.NYTD_USER;
  // Get the serialized request
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
  
  // Get the flag from conversation to display informational message after the save
  Boolean toSurveyPageFlag = (Boolean)request.getAttribute("navToSurveyFlag");
  Boolean isInSurveyPeriod = (Boolean)request.getAttribute("isSurveyPeriod");
  Boolean isSurveyComplete = (Boolean)request.getAttribute("isSurveyComp");
  Boolean isPassMessageToJsp = (Boolean)request.getAttribute("passMessageToJsp");
  

  List resourceIDList = new ArrayList();
  Map<Integer, String> activeRsrcListMap = new HashMap<Integer, String>();
  String idVendor = StringHelper.EMPTY_STRING;
  String nmUserFirst = StringHelper.EMPTY_STRING;
  String nmUserMiddle = StringHelper.EMPTY_STRING;
  String nmUserLast = StringHelper.EMPTY_STRING;
  String disableUsrTyp = "false";
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
  
  // SMS #66384: MR-067
  String txtUserFB = StringHelper.EMPTY_STRING;
  String txtUserMS = StringHelper.EMPTY_STRING;
  String txtUserTW = StringHelper.EMPTY_STRING;
  String txtOthrSt = StringHelper.EMPTY_STRING;
  String txtOthrStUsrNm = StringHelper.EMPTY_STRING;    
  String TxtUsrPhnBst = StringHelper.EMPTY_STRING;
  String TxtUsrPhnBstExt = StringHelper.EMPTY_STRING;
  String TxtUsrPhnBstType = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt1 = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt1Ext = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt1Type = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt2 = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt2Ext = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt2Type = StringHelper.EMPTY_STRING;
  String TxtCtByTxt = StringHelper.EMPTY_STRING;
  String TxtEmrContact = StringHelper.EMPTY_STRING;
  String TxtDtDOB = StringHelper.EMPTY_STRING;
  // End SMS #66384: MR-067
          
  String selectedPuvlId = StringHelper.EMPTY_STRING;
  String selectedRsrcNm = StringHelper.EMPTY_STRING;
  String selectedRsrcId = StringHelper.EMPTY_STRING;
  String selectedType = StringHelper.EMPTY_STRING;
  String selectedStatus = StringHelper.EMPTY_STRING;
  String selectedStartDt = StringHelper.EMPTY_STRING;
  String selectedEndDt = StringHelper.EMPTY_STRING;
  String populateFields = StringHelper.EMPTY_STRING;
  String userAccessType = StringHelper.EMPTY_STRING;
  String seqQues1 = StringHelper.EMPTY_STRING;
  String seqQues2 = StringHelper.EMPTY_STRING;
  String seqQues3 = StringHelper.EMPTY_STRING;
  String seqAns1 = StringHelper.EMPTY_STRING;
  String seqAns2 = StringHelper.EMPTY_STRING;
  String seqAns3 = StringHelper.EMPTY_STRING;
  String radioRsrcChecked = StringHelper.EMPTY_STRING;
  if (retrieveVendorStaffDetailSO!=null){
  	resourceIDList = retrieveVendorStaffDetailSO.getResourceList();
  	activeRsrcListMap = retrieveVendorStaffDetailSO.getActiveRsrcListMap();
  	if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_STAFF_LIST)||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST))){
  	  disableUsrTyp = "true";		 
  	  disableStatus = retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST)?"true":"false";
  	  userAccessType = retrieveVendorStaffDetailSO.getUserAccessType();
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
  	  if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 9) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  	addrUserAddrZipStuff = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(5);
  	  }else if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() < 9 
  	  				&& retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 5) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  }
  	  cdUserAddrState = retrieveVendorStaffDetailSO.getCdUserAddrState();
  	  cdUserAddrCounty = retrieveVendorStaffDetailSO.getCdUserAddrCounty();
  	  // SMS #66384: MR-067
  	  txtUserFB = retrieveVendorStaffDetailSO.getTxtUserFB();
  	  txtUserMS = retrieveVendorStaffDetailSO.getTxtUserMS();
  	  txtUserTW = retrieveVendorStaffDetailSO.getTxtUserTW();
      txtOthrSt = retrieveVendorStaffDetailSO.getTxtUserOthSite();
	  txtOthrStUsrNm = retrieveVendorStaffDetailSO.getTxtUserNameOthSite();
	  TxtUsrPhnBst = retrieveVendorStaffDetailSO.getTxtUserPhnBest();
	  TxtUsrPhnBstExt = retrieveVendorStaffDetailSO.getTxtUserPhnBestExt();
	  TxtUsrPhnBstType = retrieveVendorStaffDetailSO.getTxtUserPhnBestType();
	  TxtUsrPhnAlt1 = retrieveVendorStaffDetailSO.getTxtUserPhnAlt1();
	  TxtUsrPhnAlt1Ext = retrieveVendorStaffDetailSO.getTxtUserPhnAlt1Ext();
	  TxtUsrPhnAlt1Type = retrieveVendorStaffDetailSO.getTxtUserPhnAlt1Type();
	  TxtUsrPhnAlt2 = retrieveVendorStaffDetailSO.getTxtUserPhnAlt2();
	  TxtUsrPhnAlt2Ext = retrieveVendorStaffDetailSO.getTxtUserPhnAlt2Ext();
	  TxtUsrPhnAlt2Type = retrieveVendorStaffDetailSO.getTxtUserPhnAlt2Type();
	  TxtCtByTxt = retrieveVendorStaffDetailSO.getTxtCntctByText();   
	  TxtEmrContact = retrieveVendorStaffDetailSO.getTxtEmerContact(); 
	  TxtDtDOB = FormattingHelper.formatDate(retrieveVendorStaffDetailSO.getDtDOB());
      // End SMS #66384: MR-067
            	  
  	  if (retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_USRER)
  	  					|| retrieveVendorStaffDetailSO.getUserAccessType().equals(NYTD_USER)
  	  					|| (retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_ADMIN) &&
  										retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser()))){
  	  	disableAssocVndrRadio = "true";
  	  	seqQues1 = retrieveVendorStaffDetailSO.getCdQuestion1();
  	  	seqQues2 = retrieveVendorStaffDetailSO.getCdQuestion2();
  	  	seqQues3 = retrieveVendorStaffDetailSO.getCdQuestion3();
  	  	seqAns1 = retrieveVendorStaffDetailSO.getTxtAnswer1();
  	  	seqAns2 = retrieveVendorStaffDetailSO.getTxtAnswer2();
  	  	seqAns3 = retrieveVendorStaffDetailSO.getTxtAnswer3();
  	  }
  	}
  }  

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction nameContains(eElem, str) {\r\n  var bContains = false;\r\n  bContains = (-1 != (eElem.name.indexOf(str)));\r\n  return bContains;\r\n}\r\n\r\n/*\r\n*  Function Name:  CheckWidget\r\n*  Parameters:  eElem - HTML Widget\r\n*  Returns:  Boolean - True if widget changed, False if widget is the same\r\n*\r\n*  Description:  Evaluates present value of widget against default value to determine\r\n*  if there has been a change. Exludes any widget that end in the _CLEAN Suffix\r\n*  so that certain fields will not dirty the page.\r\n*/\r\nfunction CheckWidget(eElem) {\r\n\r\n  // Variable which is returned\r\n  var booChange = false;\r\n  // if this variable has a _CLEAN in the name, do nothing\r\n  if (!nameContains(eElem, \"CLEAN\")) {\r\n    if (\"text\" == eElem.type || \"TEXTAREA\" == eElem.tagName) {\r\n      if ((\"dtStart\"!=eElem.name && \"dtEnd\"!=eElem.name) && eElem.value != eElem.defaultValue) {\r\n        booChange = true;\r\n");
      out.write("      }\r\n    } else if (\"SELECT\" == eElem.tagName) {\r\n      var cOpts = eElem.options;\r\n      var iNumOpts = cOpts.length;\r\n      for (var j = 0; j < iNumOpts; j++) {\r\n        var eOpt = cOpts[j];\r\n        if ((\"selStatus\"!= eElem.name && \"selReqType\"!= eElem.name) && eOpt.selected != eOpt.defaultSelected) {\r\n          booChange = true;\r\n\r\n        }\r\n      }\r\n    }\r\n  }\r\n\r\n  return booChange;\r\n}\r\n\r\n/*\r\n*  Function Name:  isFormChanged\r\n*  Parameters:  None\r\n*  Returns:  Boolean\r\n*\r\n*  Description:  Evaluates a form to see if anything in the form has changed.\r\n*  Returns true if something has changed.\r\n*/\r\nfunction isFormChanged(form) {\r\n  var booDirtyForm = false;\r\n  var iNumElements = form.elements.length;\r\n\r\n  //  Loop through the form elements\r\n  for (x = 0; x < iNumElements; x++) {\r\n    if (!form.elements[x].disabled && CheckWidget(form.elements[x])) {\r\n      //alert ('Widget changed!!!');\r\n      booDirtyForm = true;\r\n      break;\r\n    }\r\n  }\r\n  return booDirtyForm;\r\n}\r\n\r\n/*\r\n*  Function Name:  isFormChanged\r\n");
      out.write("*  Parameters:  None\r\n*  Returns:  Boolean\r\n*\r\n*  Description:  Evaluates a form to page has changed by looping through all\r\n*  the forms to see if they have changed.\r\n*  Returns true if something has changed.\r\n*/\r\nfunction isPageChanged() {\r\n  var iNumForms = document.forms.length;\r\n  var booDirtyForm = false;\r\n  //  For each form loop through its elements\r\n  for (i = 0; i < iNumForms; i++) {\r\n    if (isFormChanged(document.forms[i])) {\r\n      //alert ('Form changed!!!');\r\n      booDirtyForm = true;\r\n      break;\r\n    }\r\n  }\r\n  return booDirtyForm;\r\n}\r\n\r\n/*\r\n*  User can set page to present IsDirty popup message by calling\r\n*  setPageDirtyFlag( true );  Useful for pullbacks where page\r\n*  loads clean but data has actually changed prior to pullback, \r\n*  or for display-only field changes.\r\n*/\r\nvar pageDirtyFlag = false;\r\n\r\nfunction setPageDirtyFlag(dirty) {\r\n  pageDirtyFlag = dirty;\r\n}\r\n\r\n/*\r\n*  Function Name:  IsDirty\r\n*  Parameters:  None\r\n*  Returns:  None\r\n*\r\n*  Description:  Evaluates all the forms on a web page.  If the form's elements have\r\n");
      out.write("*  changed from their default state the user is prompted to save before leaving the page.\r\n*  The isDirtyCalled var is available from impact.js.  It was moved there to ensure its\r\n*  availability on every page, since dirtyForm.js isn't used on each page.  The button\r\n*  tag now references this var instead of nulling the onbeforeunload method.\r\n*/\r\nfunction IsDirtyhere() {\r\n  if (!hrefDirtyBypass) {\r\n    // Variable to hold all the forms on a page\r\n    var booDirtyForm = false;\r\n    booDirtyForm = isPageChanged();\r\n    var vendorDetailDirty = false;\r\n    vendorDetailDirty = checkIsDirty();\r\n    /*\r\n    * If the form is dirty prompt the user before leaving the page.\r\n    */\r\n    if (( pageDirtyFlag || booDirtyForm || vendorDetailDirty ) && !isDirtyCalled) {\r\n      event.returnValue = \"Your unsaved data will be lost.\";\r\n      //MessageBox.show(\"Version: Visual J++ 6.0\", \"MyNotepad\");\r\n    }\r\n    isDirtyCalled = false;\r\n  }\r\n  hrefDirtyBypass = false;\r\n}\r\n  rbSelected = new Boolean(false);\r\n  function populateFields(idPuvl, nmResource, idResource, cdAccessType, cdStatus, dtStart, dtEnd) {\r\n");
      out.write("    document.frmVndrStaffDtl.hdnSelectedPuvlId.value = idPuvl;\r\n    document.frmVndrStaffDtl.hdnSelectedRsrcNm.value = nmResource;\r\n\tdocument.frmVndrStaffDtl.hdnSelectedRsrcId.value = idResource;\r\n\tdocument.frmVndrStaffDtl.hdnSelReqType.value = cdAccessType;\r\n\tdocument.frmVndrStaffDtl.hdnSelStatus.value = cdStatus;\r\n\tdocument.frmVndrStaffDtl.hdnDtStart.value = dtStart;\r\n\tdocument.frmVndrStaffDtl.hdnDtEnd.value = dtEnd;\r\n  }\r\n  \r\n  // This function is called before the page unloads.\r\n\twindow.onbeforeunload = function ()\r\n\t{\r\n    \tIsDirtyhere();\r\n\t}\r\n  function fillFields(){\r\n  \t//disableValidation(\"frmVndrStaffDtl\");\r\n\tif (checkIsDirty()){\r\n\t\tif (!confirm(\"Your unsaved data will be lost.\")){\r\n\t\t\treturn false;\r\n\t\t}\r\n\t}\r\n\t//Set the Select Flag True and Add Flag False to mark for Update\r\n\tdocument.frmVndrStaffDtl.hdnSelectFlag.value = \"");
      out.print( StringHelper.BOOLEAN_TRUE );
      out.write("\";\r\n\tdocument.frmVndrStaffDtl.hdnAddFlag.value = \"");
      out.print( StringHelper.BOOLEAN_FALSE );
      out.write("\";\r\n\t//Rewriting the inner HTML to display the Resource Name and Resource ID  \t\r\n  \tdocument.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;\r\n\tdocument.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;\r\n\t//Setting the New selected Row\r\n\tdocument.frmVndrStaffDtl.selReqType.value = document.frmVndrStaffDtl.hdnSelReqType.value;\r\n\tdocument.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;\r\n\tdocument.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;\r\n\tdocument.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;\r\n\t//Setting the new selecte row value to the display hidden variables\r\n\tdocument.frmVndrStaffDtl.hdnDisplayPuvlId.value = document.frmVndrStaffDtl.hdnSelectedPuvlId.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;\r\n");
      out.write("\tdocument.frmVndrStaffDtl.hdnDisplayReqType.value = document.frmVndrStaffDtl.hdnSelReqType.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;   \r\n  }\r\n  function checkIsDirty(){\r\n  \tvar booDirty = false;\r\n    if (document.frmVndrStaffDtl.selReqType.value != document.frmVndrStaffDtl.hdnDisplayReqType.value||\r\n    \tdocument.frmVndrStaffDtl.selStatus.value != document.frmVndrStaffDtl.hdnDisplayStatus.value ||\r\n    \tdocument.frmVndrStaffDtl.dtStart.value != document.frmVndrStaffDtl.hdnDisplayDtStart.value ||\r\n    \tdocument.frmVndrStaffDtl.dtEnd.value != document.frmVndrStaffDtl.hdnDisplayDtEnd.value){\r\n    \tbooDirty = true;\r\n    } \r\n    return booDirty; \t\r\n  }\r\n  \r\n  function getResource(){\r\n    var selNewRsrc = document.frmVndrStaffDtl.selNewVendor.value;\r\n    var selNewRsrcNm = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n    var selNewRsrcId = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n    if (selNewRsrc.length > 0){\r\n    \tvar commaLocation = selNewRsrc.search(\",\");\r\n    \tif (commaLocation > 0){\r\n    \t\tselNewRsrcNm = selNewRsrc.substring(commaLocation+1);\r\n    \t\tselNewRsrcId = selNewRsrc.substring(0,commaLocation);\r\n    \t}\r\n    }\r\n    document.frmVndrStaffDtl.hdnAddNewRsrcNm.value = selNewRsrcNm;\r\n\tdocument.frmVndrStaffDtl.hdnAddNewRsrcId.value = selNewRsrcId;\r\n\t//Set default as User and status as Pending  \r\n\tdocument.frmVndrStaffDtl.hdnAddNewReqType.value = \"");
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
      out.write("\";\r\n\t//Rewriting the inner HTML to display the Resource Name and Resource ID  \t\r\n  \tdocument.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;\r\n\tdocument.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;\r\n\t//Setting the New selected Row\r\n\tdocument.frmVndrStaffDtl.selReqType.value = document.frmVndrStaffDtl.hdnAddNewReqType.value;\r\n\tdocument.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;\r\n\tdocument.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;\r\n\tdocument.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;\r\n\t//Setting the new selecte row value to the display hidden variables\r\n\tdocument.frmVndrStaffDtl.hdnDisplayPuvlId.value = \"0\";\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayReqType.value = document.frmVndrStaffDtl.hdnAddNewReqType.value;\r\n");
      out.write("\tdocument.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;\r\n\tdocument.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;\t  \r\n  }\r\n  function disableValidate(){\r\n \tdisableValidation(\"frmVndrStaffDtl\");\r\n  }\r\n  function warnPasswordReset()\r\n  {\r\n    disableValidate();\r\n    var returnVal = true;\r\n    returnVal = confirm( \"");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_REST_WARN ));
      out.write("\" );\r\n    return returnVal;\r\n  }\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n<!--if default button set, action needs to to be updated depends on access type -->\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmVndrStaffDtl");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/VendorStaffDetail/saveVendorStaffDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.VendorStaffDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n<!-- SMS #66384: MR-067 User Profile Detail for NYTD User  --> \r\n");
 if (retrieveVendorStaffDetailSO.getUserAccessType().equals(NYTD_USER)) {
	
          out.write("\t       \r\n\t");
 if (toSurveyPageFlag != null) {
		
          out.write("\t\t\t\t\t\r\n\t\t");
 if (toSurveyPageFlag) {
		
          out.write("\r\n\t\t\t");
 if (isInSurveyPeriod && !isSurveyComplete) {
			
          out.write("\r\n\t\t\t\t");
 if (isPassMessageToJsp) {
				
          out.write("\r\n\t\t\t\t<table border=\"0\" cellspacing=\"3\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t      <tr>\r\n\t\t\t        <td>\r\n\t\t\t          <hr>\r\n\t\t\t          <span class=\"formInfoText\">Attention:</span>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t\t      <tr>\r\n\t\t\t      \t<td><font color=#0000ff><li>\r\n\t\t\t      \t<span class=\"formInfoText\">");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_UPDATE ) );
          out.write("</span></font>\r\n\t\t\t      \t</td>\r\n\t\t\t      </tr>\r\n\t\t\t      <tr>\r\n\t\t\t        <td><font color=#0000ff><li>\r\n\t\t\t          <span class=\"formInfoText\">Your User Profile information has been saved. Your NYTD survey response is not complete. Please <a href=\"/person/PortalSurveyDetail/displayPortalSurveyDetail\">click here</a> to complete the survey.</span></font>\r\n\t\t\t          <hr>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t\t    </table>\r\n\t\t\t\t");
 
				} else {
				
          out.write("\r\n\t\t\t \t<table border=\"0\" cellspacing=\"3\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t      <tr>\r\n\t\t\t        <td>\r\n\t\t\t          <hr>\r\n\t\t\t          <span class=\"formInfoText\">Attention:</span>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t\t      <tr>\r\n\t\t\t        <td><font color=#0000ff><li>\r\n\t\t\t          <span class=\"formInfoText\">Your User Profile information has been saved. Your NYTD survey response is not complete. Please <a href=\"/person/PortalSurveyDetail/displayPortalSurveyDetail\">click here</a> to complete the survey.</span></font>\r\n\t\t\t          <hr>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t\t    </table>\r\n\t\t\t    ");

			    } 
          out.write("\t\t\t\t\t\r\n\t\t");
 }
		else {
		
          out.write("\r\n\t\t\t\t");
 if (isPassMessageToJsp) {
				
          out.write("\r\n\t\t\t\t\t<table border=\"0\" cellspacing=\"3\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t      <tr>\r\n\t\t\t        <td>\r\n\t\t\t          <hr>\r\n\t\t\t          <span class=\"formInfoText\">Attention:</span>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t\t      <tr>\r\n\t\t\t      \t<td><font color=#0000ff><li>\r\n\t\t\t      \t<span class=\"formInfoText\">");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_UPDATE ) );
          out.write("</span></font>\r\n\t\t\t      \t</td>\r\n\t\t\t      </tr>\r\n\t\t\t      <tr>\r\n\t\t\t        <td><font color=#0000ff><li>\r\n\t\t\t\t\t    <span class=\"formInfoText\">Your User Profile information has been saved.</span></font>\r\n\t\t\t          <hr>\r\n\t\t\t        </td>\r\n\t\t\t      </tr>\r\n\t\t\t    </table>\r\n\t\t\t\t");
 
				} else {
				
          out.write("\r\n\t\t\t\t\t <table border=\"0\" cellspacing=\"3\" cellpadding=\"0\" width=\"100%\">\r\n\t\t\t\t\t     <tr>\r\n\t\t\t\t\t        <td>\r\n\t\t\t\t\t          <hr>\r\n\t\t\t\t\t          <span class=\"formInfoText\">Attention:</span>\r\n\t\t\t\t\t        </td>\r\n\t\t\t\t\t      </tr>\r\n\t\t\t\t\t      <tr>\r\n\t\t\t\t\t        <td><font color=#0000ff><li>\r\n\t\t\t\t\t          \t<span class=\"formInfoText\">Your User Profile information has been saved.</span></font>\t\t\t\t          \r\n\t\t\t\t\t          <hr>\r\n\t\t\t\t\t        </td>\r\n\t\t\t\t\t     </tr>\t\t\t\t     \r\n\t\t\t\t\t  </table>\r\n\t\t\t\t");
 }
				
          out.write("\r\n\t\t\t");
 }
			
          out.write("\t\r\n\t\t\t");
					
			request.removeAttribute("navToSurveyFlag"); 
			
          out.write("\r\n\t\t ");
 }
		 
          out.write('\r');
          out.write('\n');
 }
 
          out.write("\t \r\n<table border=\"0\"  cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n\t<tr>\r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t  \t<tr>\r\n\t\t    \t<th colspan=\"6\">Basic Data</th>\r\n\t\t  \t</tr>\r\n\t\t    <tr>\r\n\t\t     <td>\r\n\t\t      <table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n\t\t        <tr>\r\n\t\t\t\t       <td>");
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
          out.write("</td>\r\n\t\t\t\t       <td>");
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
          out.write("</td>\r\n\t\t\t\t       <td>");
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
          out.write("</td>\r\n\t\t\t\t</tr>\r\n\t\t        </table>\t\t                                           \r\n\t\t       </td>\r\n\t\t     </tr>\t\t     \r\n\t\t     <tr>\r\n\t\t      <td>                   \r\n\t\t\t\t  <table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t\t  \t<tr>\r\n\t\t\t\t    \t<th colspan=\"6\">Online Contact Information</th>\r\n\t\t\t\t  \t</tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setConstraint("Email");
          _jspx_th_impact_validateInput_3.setName("txtEmail");
          _jspx_th_impact_validateInput_3.setLabel("Email");
          _jspx_th_impact_validateInput_3.setSize("50");
          _jspx_th_impact_validateInput_3.setMaxLength("70");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(txtUserEmail));
          _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t     </tr>    \r\n\t                  <tr>\r\n\t\t\t             <td>\r\n\t      \t\t\t       <img align=\"bottom\" alt=\"Facebook User Name\" src=\"/grnds-docs/images/shared/facebookicon.jpg\"/>\r\n\t     \t\t\t     </td>\r\n\t\t\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setName("szTxtFacebook");
          _jspx_th_impact_validateInput_4.setSize("50");
          _jspx_th_impact_validateInput_4.setMaxLength("70");
          _jspx_th_impact_validateInput_4.setRequired("false");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString(txtUserFB));
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>     \t\t\t                                   \r\n\t\t\t          </tr>\r\n\t                  <tr>\r\n\t\t\t             <td>\r\n\t      \t\t\t       <img align=\"bottom\" alt=\"MySpace User Name\" src=\"/grnds-docs/images/shared/myspaceicon.gif\"/>\r\n\t     \t\t\t     </td>\r\n\t\t\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setName("szTxtMySpace");
          _jspx_th_impact_validateInput_5.setSize("50");
          _jspx_th_impact_validateInput_5.setMaxLength("70");
          _jspx_th_impact_validateInput_5.setRequired("false");
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatString(txtUserMS));
          _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>     \t\t\t                                   \r\n\t\t\t          </tr>\r\n\t                  <tr>\r\n\t\t\t             <td>\r\n\t      \t\t\t       <img align=\"bottom\" alt=\"Twitter User Name\" src=\"/grnds-docs/images/shared/twittericon.jpg\"/>\r\n\t     \t\t\t     </td>\r\n\t\t\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setName("szTxtTwitter");
          _jspx_th_impact_validateInput_6.setSize("50");
          _jspx_th_impact_validateInput_6.setMaxLength("70");
          _jspx_th_impact_validateInput_6.setRequired("false");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatString(txtUserTW));
          _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>     \t\t\t                                   \r\n\t\t\t          </tr>\t\t\t\t\t     \r\n\t\t\t\t      <tr>\r\n\t\t\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setName("szTxtOtherSite");
          _jspx_th_impact_validateInput_7.setLabel("Other Site");
          _jspx_th_impact_validateInput_7.setSize("50");
          _jspx_th_impact_validateInput_7.setMaxLength("70");
          _jspx_th_impact_validateInput_7.setRequired("false");
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatString(txtOthrSt));
          _jspx_th_impact_validateInput_7.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>     \t\t\t                                   \r\n\t\t\t             <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setLabel("User Name");
          _jspx_th_impact_validateInput_8.setName("szTxtUserName");
          _jspx_th_impact_validateInput_8.setSize("50");
          _jspx_th_impact_validateInput_8.setMaxLength("70");
          _jspx_th_impact_validateInput_8.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatString(txtOthrStUsrNm));
          _jspx_th_impact_validateInput_8.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>   \r\n\t\t\t          </tr>\t\t\t\t\t     \r\n\t\t\t\t  </table>\r\n\t\t\t  </td>\t\t   \r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t      <td>                   \r\n\t\t\t\t  <table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setConstraint("Phone");
          _jspx_th_impact_validateInput_9.setName("nbrPhoneBest");
          _jspx_th_impact_validateInput_9.setLabel("Best Contact Phone Number");
          _jspx_th_impact_validateInput_9.setSize("15");
          _jspx_th_impact_validateInput_9.setMaxLength("15");
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatPhone(TxtUsrPhnBst));
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                                                   \t\t\t             \t\t\t\t                                            \r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_10.setName("nbrPhoneExtBest");
          _jspx_th_impact_validateInput_10.setLabel("Ext.");
          _jspx_th_impact_validateInput_10.setSize("8");
          _jspx_th_impact_validateInput_10.setMaxLength("8");
          _jspx_th_impact_validateInput_10.setValue(FormattingHelper.formatString(TxtUsrPhnBstExt));
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t       <td>\t\t\t\t       \r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("Home");
          _jspx_th_impact_validateInput_11.setName("rbIndPhoneBest");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setChecked(String.valueOf(CodesTables.CUSRPHN_HM.equals(FormattingHelper.formatString(TxtUsrPhnBstType))));
          _jspx_th_impact_validateInput_11.setValue(CodesTables.CUSRPHN_HM);
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setLabel("Cell");
          _jspx_th_impact_validateInput_12.setName("rbIndPhoneBest");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setChecked(String.valueOf(CodesTables.CUSRPHN_CL.equals(FormattingHelper.formatString(TxtUsrPhnBstType))));
          _jspx_th_impact_validateInput_12.setValue(CodesTables.CUSRPHN_CL);
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("Work");
          _jspx_th_impact_validateInput_13.setName("rbIndPhoneBest");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setChecked(String.valueOf(CodesTables.CUSRPHN_WK.equals(FormattingHelper.formatString(TxtUsrPhnBstType))));
          _jspx_th_impact_validateInput_13.setValue(CodesTables.CUSRPHN_WK);
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\t\t\t\t       \r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t     \t<td><font color=\"#808080\" size=\"-1\">(###) ###-####</td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setConstraint("Phone");
          _jspx_th_impact_validateInput_14.setName("nbrPhoneAltOne");
          _jspx_th_impact_validateInput_14.setLabel("Alternate Phone Number 1");
          _jspx_th_impact_validateInput_14.setSize("15");
          _jspx_th_impact_validateInput_14.setMaxLength("15");
          _jspx_th_impact_validateInput_14.setRequired("false");
          _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatPhone(TxtUsrPhnAlt1));
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_15.setName("nbrPhoneExtAltOne");
          _jspx_th_impact_validateInput_15.setLabel("Ext.");
          _jspx_th_impact_validateInput_15.setSize("8");
          _jspx_th_impact_validateInput_15.setMaxLength("8");
          _jspx_th_impact_validateInput_15.setValue(FormattingHelper.formatString(TxtUsrPhnAlt1Ext));
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>  \t\t\t\t                                            \r\n\t\t\t\t       <td>\t\t\t\t       \r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setLabel("Home");
          _jspx_th_impact_validateInput_16.setName("rbIndPhoneAltOne");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setChecked(String.valueOf(CodesTables.CUSRPHN_HM.equals(FormattingHelper.formatString(TxtUsrPhnAlt1Type))));
          _jspx_th_impact_validateInput_16.setValue(CodesTables.CUSRPHN_HM);
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setLabel("Cell");
          _jspx_th_impact_validateInput_17.setName("rbIndPhoneAltOne");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setChecked(String.valueOf(CodesTables.CUSRPHN_CL.equals(FormattingHelper.formatString(TxtUsrPhnAlt1Type))));
          _jspx_th_impact_validateInput_17.setValue(CodesTables.CUSRPHN_CL);
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setLabel("Work");
          _jspx_th_impact_validateInput_18.setName("rbIndPhoneAltOne");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setChecked(String.valueOf(CodesTables.CUSRPHN_WK.equals(FormattingHelper.formatString(TxtUsrPhnAlt1Type))));
          _jspx_th_impact_validateInput_18.setValue(CodesTables.CUSRPHN_WK);
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\t\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t     \t<td><font color=\"#808080\" size=\"-1\">(###) ###-####</td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setConstraint("Phone");
          _jspx_th_impact_validateInput_19.setName("nbrPhoneAltTwo");
          _jspx_th_impact_validateInput_19.setLabel("Alternate Phone Number 2");
          _jspx_th_impact_validateInput_19.setSize("15");
          _jspx_th_impact_validateInput_19.setMaxLength("15");
          _jspx_th_impact_validateInput_19.setRequired("false");
          _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatPhone(TxtUsrPhnAlt2));
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_20.setName("nbrPhoneExtAltTwo");
          _jspx_th_impact_validateInput_20.setLabel("Ext.");
          _jspx_th_impact_validateInput_20.setSize("8");
          _jspx_th_impact_validateInput_20.setMaxLength("8");
          _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatString(TxtUsrPhnAlt2Ext));
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\t\r\n\t\t\t\t       <td>\t\t\t\t       \r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setLabel("Home");
          _jspx_th_impact_validateInput_21.setName("rbIndPhoneAltTwo");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setChecked(String.valueOf(CodesTables.CUSRPHN_HM.equals(FormattingHelper.formatString(TxtUsrPhnAlt2Type))));
          _jspx_th_impact_validateInput_21.setValue(CodesTables.CUSRPHN_HM);
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setLabel("Cell");
          _jspx_th_impact_validateInput_22.setName("rbIndPhoneAltTwo");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setChecked(String.valueOf(CodesTables.CUSRPHN_CL.equals(FormattingHelper.formatString(TxtUsrPhnAlt2Type))));
          _jspx_th_impact_validateInput_22.setValue(CodesTables.CUSRPHN_CL);
          _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setLabel("Work");
          _jspx_th_impact_validateInput_23.setName("rbIndPhoneAltTwo");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setChecked(String.valueOf(CodesTables.CUSRPHN_WK.equals(FormattingHelper.formatString(TxtUsrPhnAlt2Type))));
          _jspx_th_impact_validateInput_23.setValue(CodesTables.CUSRPHN_WK);
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\t       \t\t\t\t       \t\t\t                                            \r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t     \t<td><font color=\"#808080\" size=\"-1\">(###) ###-####</td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t     \t<td>\r\n\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Can DFCS contact you by text?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t    <td>\r\n\t\t\t        \t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setLabel("Yes");
          _jspx_th_impact_validateInput_24.setName("rbIndText");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setChecked(String.valueOf(ArchitectureConstants.Y.equals(TxtCtByTxt)) );
          _jspx_th_impact_validateInput_24.setValue( ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t        \t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setLabel("No");
          _jspx_th_impact_validateInput_25.setName("rbIndText");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setChecked(String.valueOf(ArchitectureConstants.N.equals(TxtCtByTxt)));
          _jspx_th_impact_validateInput_25.setValue( ArchitectureConstants.N );
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t      \t\t</td>\t                          \t\t      \t\t\r\n\t\t\t\t     </tr>\t\t\t\t     \r\n\t\t\t\t  </table>\r\n\t\t\t  </td>\t\t   \r\n\t\t     </tr>\t\t\t     \r\n\t\t     <tr>\r\n\t\t      <td>                   \r\n\t\t\t\t  <table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("text");
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setConstraint("Address");
          _jspx_th_impact_validateInput_26.setName("txtAddress1");
          _jspx_th_impact_validateInput_26.setLabel("Address");
          _jspx_th_impact_validateInput_26.setSize("30");
          _jspx_th_impact_validateInput_26.setMaxLength("30");
          _jspx_th_impact_validateInput_26.setRequired("false");
          _jspx_th_impact_validateInput_26.setValue(FormattingHelper.formatString(addrUserAddrStLn1));
          _jspx_th_impact_validateInput_26.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>\r\n\t\t\t\t       <td></td>\r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("text");
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setConstraint("Address2");
          _jspx_th_impact_validateInput_27.setName("txtAddress2");
          _jspx_th_impact_validateInput_27.setSize("30");
          _jspx_th_impact_validateInput_27.setMaxLength("30");
          _jspx_th_impact_validateInput_27.setValue(FormattingHelper.formatString(addrUserAddrStLn2));
          _jspx_th_impact_validateInput_27.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>                                            \r\n\t\t\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("text");
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_28.setConstraint("City");
          _jspx_th_impact_validateInput_28.setName("txtCity");
          _jspx_th_impact_validateInput_28.setLabel("City");
          _jspx_th_impact_validateInput_28.setSize("20");
          _jspx_th_impact_validateInput_28.setMaxLength("20");
          _jspx_th_impact_validateInput_28.setRequired("false");
          _jspx_th_impact_validateInput_28.setValue(FormattingHelper.formatString(addrUserAddrCity));
          _jspx_th_impact_validateInput_28.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setName("selState");
          _jspx_th_impact_validateSelect_0.setLabel("State");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(cdUserAddrState));
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t\t\t     </tr>\r\n\t\t\t\t     <tr>                                            \r\n\t\t\t\t       <td>\r\n\t\t\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("text");
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_29.setConstraint("Zip");
          _jspx_th_impact_validateInput_29.setName("txtZip");
          _jspx_th_impact_validateInput_29.setLabel("Zip");
          _jspx_th_impact_validateInput_29.setSize("5");
          _jspx_th_impact_validateInput_29.setMaxLength("5");
          _jspx_th_impact_validateInput_29.setRequired("false");
          _jspx_th_impact_validateInput_29.setValue(FormattingHelper.formatString(addrUserAddrZip));
          _jspx_th_impact_validateInput_29.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       \t&nbsp;&nbsp; - &nbsp;&nbsp;\r\n\t\t\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("text");
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_30.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_30.setName("txtZipSuff");
          _jspx_th_impact_validateInput_30.setSize("4");
          _jspx_th_impact_validateInput_30.setMaxLength("4");
          _jspx_th_impact_validateInput_30.setValue(FormattingHelper.formatString(addrUserAddrZipStuff));
          _jspx_th_impact_validateInput_30.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t       </td>\r\n\t\t\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setName("selCounty");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(cdUserAddrCounty));
          _jspx_th_impact_validateSelect_1.setRequired("false");
          _jspx_th_impact_validateSelect_1.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>       \r\n\t\t\t\t     </tr> \r\n\t\t\t\t  </table>\r\n\t\t\t  </td>\t\t   \r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t      <td>                   \r\n\t\t\t\t  <table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n\t\t\t\t     <tr>\r\n\t\t\t\t     \t<td>\r\n\t\t\t\t\t\t<span class=\"formRequiredText\">*</span>If we cannot locate you, who is a reliable adult who knows where you are? (Name and Contact Information):\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t      \t<tr>   \t\t\t\t     \r\n\t\t\t\t\t    <td><!--- Text Area Custom Tag --->\r\n\t\t\t\t\t    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtEmerContact");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("140");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t                             ");
              out.print( FormattingHelper.formatString(TxtEmrContact));
              out.write("\t\t\t\t                             \t\t\t\t\t      \r\n\t\t\t\t\t    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t  </td>\t \t\t\t\t                                            \r\n\t\t\t\t     </tr>\t \t\t\t     \r\n\t\t\t\t  </table>\r\n\t\t\t  </td>\t\t   \r\n\t\t     </tr>\t     \t     \t\t     \t     \t     \t\t     \r\n\t\t  </table>\r\n\t  </td>\t  \r\n\t</tr>\r\n \t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"3\">Current Password</th>\r\n\t\t\t  \t</tr>\t\r\n\t\t        <tr>\r\n\t            \t<td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("password");
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_31.setColspan("2");
          _jspx_th_impact_validateInput_31.setName("txtCurrentPassword");
          _jspx_th_impact_validateInput_31.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_31.setLabel("Password");
          _jspx_th_impact_validateInput_31.setMaxLength("20");
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>  \t\r\n\t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"3\">New Password</th>\r\n\t\t\t  \t</tr>\t\r\n\t\t        <tr>\r\n\t            \t<td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("password");
          _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_32.setColspan("2");
          _jspx_th_impact_validateInput_32.setName("txtNewPassword");
          _jspx_th_impact_validateInput_32.setLabel("New Password");
          _jspx_th_impact_validateInput_32.setMaxLength("20");
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          \t</tr>\r\n\t          \t<tr>\r\n\t            \t<td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("password");
          _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_33.setColspan("2");
          _jspx_th_impact_validateInput_33.setName("txtNewPasswordConfirm");
          _jspx_th_impact_validateInput_33.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_33.setLabel("Re-Enter New Password");
          _jspx_th_impact_validateInput_33.setMaxLength("20");
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t          \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"left\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"6\">Security Questions</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setName("selSecQues1");
          _jspx_th_impact_validateSelect_2.setCodesTable("CSECQUES");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setLabel("Question 1");
          _jspx_th_impact_validateSelect_2.setValue(seqQues1);
          _jspx_th_impact_validateSelect_2.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("text");
          _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_34.setName("txtSecAns1");
          _jspx_th_impact_validateInput_34.setSize("30");
          _jspx_th_impact_validateInput_34.setMaxLength("30");
          _jspx_th_impact_validateInput_34.setRequired("true");
          _jspx_th_impact_validateInput_34.setLabel("Answer 1");
          _jspx_th_impact_validateInput_34.setValue(seqAns1);
          _jspx_th_impact_validateInput_34.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t\t    </tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setName("selSecQues2");
          _jspx_th_impact_validateSelect_3.setCodesTable("CSECQUES");
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setLabel("Question 2");
          _jspx_th_impact_validateSelect_3.setValue(seqQues2);
          _jspx_th_impact_validateSelect_3.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("text");
          _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_35.setName("txtSecAns2");
          _jspx_th_impact_validateInput_35.setSize("30");
          _jspx_th_impact_validateInput_35.setMaxLength("30");
          _jspx_th_impact_validateInput_35.setRequired("true");
          _jspx_th_impact_validateInput_35.setLabel("Answer 2");
          _jspx_th_impact_validateInput_35.setValue(seqAns2);
          _jspx_th_impact_validateInput_35.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t\t    </tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setName("selSecQues3");
          _jspx_th_impact_validateSelect_4.setCodesTable("CSECQUES");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setLabel("Question 3");
          _jspx_th_impact_validateSelect_4.setValue(seqQues3);
          _jspx_th_impact_validateSelect_4.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("text");
          _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_36.setName("txtSecAns3");
          _jspx_th_impact_validateInput_36.setLabel("Answer 3");
          _jspx_th_impact_validateInput_36.setSize("30");
          _jspx_th_impact_validateInput_36.setMaxLength("30");
          _jspx_th_impact_validateInput_36.setRequired("true");
          _jspx_th_impact_validateInput_36.setValue(seqAns3);
          _jspx_th_impact_validateInput_36.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t\t    </tr>                     \r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\t<td></td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Save");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmVndrStaffDtl");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/VendorStaffDetail/saveUserProfileDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n</table>\t     \r\n");
 } else {  
          out.write("\r\n<table border=\"0\"  cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n\t<tr>\r\n\t  <td>                   \r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t  \t<tr>\r\n\t\t    \t<th colspan=\"6\">Basic Data</th>\r\n\t\t  \t</tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("text");
          _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_37.setConstraint("Name");
          _jspx_th_impact_validateInput_37.setName("txtFirstName");
          _jspx_th_impact_validateInput_37.setLabel("First Name");
          _jspx_th_impact_validateInput_37.setSize("12");
          _jspx_th_impact_validateInput_37.setMaxLength("12");
          _jspx_th_impact_validateInput_37.setRequired("true");
          _jspx_th_impact_validateInput_37.setValue(FormattingHelper.formatString(nmUserFirst));
          _jspx_th_impact_validateInput_37.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("text");
          _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_38.setConstraint("Name");
          _jspx_th_impact_validateInput_38.setName("txtMiddleInitial");
          _jspx_th_impact_validateInput_38.setLabel("Middle Initial");
          _jspx_th_impact_validateInput_38.setSize("2");
          _jspx_th_impact_validateInput_38.setMaxLength("1");
          _jspx_th_impact_validateInput_38.setValue(FormattingHelper.formatString(nmUserMiddle));
          _jspx_th_impact_validateInput_38.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setType("text");
          _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_39.setConstraint("Name");
          _jspx_th_impact_validateInput_39.setName("txtLastName");
          _jspx_th_impact_validateInput_39.setLabel("Last Name");
          _jspx_th_impact_validateInput_39.setSize("22");
          _jspx_th_impact_validateInput_39.setMaxLength("22");
          _jspx_th_impact_validateInput_39.setRequired("true");
          _jspx_th_impact_validateInput_39.setValue(FormattingHelper.formatString(nmUserLast));
          _jspx_th_impact_validateInput_39.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setType("text");
          _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_40.setConstraint("Name");
          _jspx_th_impact_validateInput_40.setName("txtTitle");
          _jspx_th_impact_validateInput_40.setLabel("Title");
          _jspx_th_impact_validateInput_40.setSize("20");
          _jspx_th_impact_validateInput_40.setMaxLength("20");
          _jspx_th_impact_validateInput_40.setRequired("true");
          _jspx_th_impact_validateInput_40.setValue(FormattingHelper.formatString(txtTitle));
          _jspx_th_impact_validateInput_40.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setType("text");
          _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_41.setConstraint("Email");
          _jspx_th_impact_validateInput_41.setName("txtEmail");
          _jspx_th_impact_validateInput_41.setLabel("Email");
          _jspx_th_impact_validateInput_41.setSize("50");
          _jspx_th_impact_validateInput_41.setMaxLength("70");
          _jspx_th_impact_validateInput_41.setRequired("true");
          _jspx_th_impact_validateInput_41.setValue(FormattingHelper.formatString(txtUserEmail));
          _jspx_th_impact_validateInput_41.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setType("text");
          _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_42.setConstraint("Phone");
          _jspx_th_impact_validateInput_42.setName("txtPhoneNumber");
          _jspx_th_impact_validateInput_42.setLabel("Phone Number");
          _jspx_th_impact_validateInput_42.setSize("15");
          _jspx_th_impact_validateInput_42.setMaxLength("15");
          _jspx_th_impact_validateInput_42.setRequired("true");
          _jspx_th_impact_validateInput_42.setValue(FormattingHelper.formatPhone(nbrUserPhone));
          _jspx_th_impact_validateInput_42.setCssClass("formInput");
          _jspx_th_impact_validateInput_42.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("text");
          _jspx_th_impact_validateInput_43.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_43.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_43.setName("txtPhoneExtension");
          _jspx_th_impact_validateInput_43.setLabel("Ext");
          _jspx_th_impact_validateInput_43.setSize("8");
          _jspx_th_impact_validateInput_43.setMaxLength("8");
          _jspx_th_impact_validateInput_43.setValue(FormattingHelper.formatString(nbrUserPhoneExtension));
          _jspx_th_impact_validateInput_43.setCssClass("formInput");
          _jspx_th_impact_validateInput_43.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("text");
          _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_44.setConstraint("Address");
          _jspx_th_impact_validateInput_44.setName("txtAddress1");
          _jspx_th_impact_validateInput_44.setLabel("Office Address");
          _jspx_th_impact_validateInput_44.setSize("30");
          _jspx_th_impact_validateInput_44.setMaxLength("30");
          _jspx_th_impact_validateInput_44.setRequired("true");
          _jspx_th_impact_validateInput_44.setValue(FormattingHelper.formatString(addrUserAddrStLn1));
          _jspx_th_impact_validateInput_44.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td></td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setType("text");
          _jspx_th_impact_validateInput_45.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_45.setConstraint("Address2");
          _jspx_th_impact_validateInput_45.setName("txtAddress2");
          _jspx_th_impact_validateInput_45.setSize("30");
          _jspx_th_impact_validateInput_45.setMaxLength("30");
          _jspx_th_impact_validateInput_45.setValue(FormattingHelper.formatString(addrUserAddrStLn2));
          _jspx_th_impact_validateInput_45.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>                                            \r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_46.setType("text");
          _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_46.setConstraint("City");
          _jspx_th_impact_validateInput_46.setName("txtCity");
          _jspx_th_impact_validateInput_46.setLabel("City");
          _jspx_th_impact_validateInput_46.setSize("20");
          _jspx_th_impact_validateInput_46.setMaxLength("20");
          _jspx_th_impact_validateInput_46.setRequired("true");
          _jspx_th_impact_validateInput_46.setValue(FormattingHelper.formatString(addrUserAddrCity));
          _jspx_th_impact_validateInput_46.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setName("selState");
          _jspx_th_impact_validateSelect_5.setLabel("State");
          _jspx_th_impact_validateSelect_5.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(cdUserAddrState));
          _jspx_th_impact_validateSelect_5.setRequired("true");
          _jspx_th_impact_validateSelect_5.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t     </tr>\r\n\t\t     <tr>                                            \r\n\t\t       <td>\r\n\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setType("text");
          _jspx_th_impact_validateInput_47.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_47.setConstraint("Zip");
          _jspx_th_impact_validateInput_47.setName("txtZip");
          _jspx_th_impact_validateInput_47.setLabel("Zip");
          _jspx_th_impact_validateInput_47.setSize("5");
          _jspx_th_impact_validateInput_47.setMaxLength("5");
          _jspx_th_impact_validateInput_47.setRequired("true");
          _jspx_th_impact_validateInput_47.setValue(FormattingHelper.formatString(addrUserAddrZip));
          _jspx_th_impact_validateInput_47.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
          if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t       \t&nbsp;&nbsp; - &nbsp;&nbsp;\r\n\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_48.setType("text");
          _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_48.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_48.setName("txtZipSuff");
          _jspx_th_impact_validateInput_48.setSize("4");
          _jspx_th_impact_validateInput_48.setMaxLength("4");
          _jspx_th_impact_validateInput_48.setValue(FormattingHelper.formatString(addrUserAddrZipStuff));
          _jspx_th_impact_validateInput_48.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
          if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t       </td>\r\n\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_6.setName("selCounty");
          _jspx_th_impact_validateSelect_6.setLabel("County");
          _jspx_th_impact_validateSelect_6.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_6.setValue(FormattingHelper.formatString(cdUserAddrCounty));
          _jspx_th_impact_validateSelect_6.setRequired("true");
          _jspx_th_impact_validateSelect_6.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>       \r\n\t\t     </tr> \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t");
 
		if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_STAFF_LIST)||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST))){
  			List<RetrieveVendorStaffLinkDetailBean> resourceListForUser = retrieveVendorStaffDetailSO.getResourceListforUser();
  			//If they are an active admin of any agency, we will restrict the right of the current user to reset the password
  			boolean isActiveAdmin = false;
  	
          out.write("\r\n\t<tr>      \r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t  \t<tr>\r\n\t\t  \t\t<td></td>\r\n\t\t  \t\t<td width=\"100%\">\r\n\t\t  \t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("Save");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmVndrStaffDtl");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/VendorStaffDetail/saveVendorStaffDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t  \t\t</td>\r\n\t\t  \t</tr>\r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>  \t\r\n\t<tr>\r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" width=\"100%\" align=\"center\">\r\n\t\t    <tr>\r\n\t\t    \t<th>Associated Vendors</th>\r\n\t\t  \t</tr>\r\n\t\t  \t<tr>\r\n\t\t  \t  <td>\r\n\t\t  \t    <div id=\"noScrollResults\" style=\"height:190px; width:100%; overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t      <tr>\r\n\t\t\t\t        <th class=\"thList\">&nbsp;</th>\r\n\t\t\t\t        <th class=\"thList\">Resource Name</th>\r\n\t\t\t\t        <th class=\"thList\">Resource ID</th>\r\n\t\t\t\t        <th class=\"thList\">Type</th>\r\n\t\t\t\t        <th class=\"thList\">Status</th>\r\n\t\t\t\t        <th class=\"thList\">Start Date</th>\r\n\t\t\t\t        <th class=\"thList\">End Date</th>\r\n\t\t\t\t      </tr>\r\n\t\t\t      ");

			         if (resourceListForUser.size() <= 0){
			      
          out.write("\r\n\t\t\t          <tr class=\"odd\">\r\n\t\t\t            <td colspan=\"4\">\r\n\t\t\t              ");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_SVC_NO_EXT_DOC_MATCH ) );
          out.write("\r\n\t\t\t            </td>\r\n\t\t\t          </tr>\r\n\t\t\t      \t<tr>\r\n\t\t\t          ");

			      		} else {
			      		    boolean firstEnabledRowSelected = false;
			      			for (Iterator<RetrieveVendorStaffLinkDetailBean> it = resourceListForUser.iterator();it.hasNext();){
			      			  boolean vendorAdmin = false;
					          RetrieveVendorStaffLinkDetailBean vendorStaffLinkDetBean = 
					          			(RetrieveVendorStaffLinkDetailBean) it.next();
					          //Disabling the radio button for not allowing to select if the user is not an admin
					          //for the resource

				          	  if ((activeRsrcListMap.containsKey(vendorStaffLinkDetBean.getIdResource())) 
		          					&& !(retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_USRER)
  										|| (retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_ADMIN) &&
												retrieveVendorStaffDetailSO.getIdUser().
 														equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())))){
 								disableAssocVndrRadio = "false";
				          		vendorAdmin = true;
				          	  }
					          if (!vendorAdmin){
					          	disableAssocVndrRadio = "true";
					          }
					          
					          //Determine if they are an active administrator of any agency
					          if ((CodesTables.CUSRTYP_PAD.equals(vendorStaffLinkDetBean.getCdAccessType() != null ? vendorStaffLinkDetBean.getCdAccessType() : ""))&&
					          (CodesTables.CUSRSTAT_ACT.equals(vendorStaffLinkDetBean.getCdStatus() != null ? vendorStaffLinkDetBean.getCdStatus() : ""))) {
					 
					             isActiveAdmin = true;
					 
					          }
					          
					          
					          radioRsrcChecked = "false";
					          //Get the first row and load it during the initial load
					          if (!firstEnabledRowSelected && vendorAdmin){
					            firstEnabledRowSelected = true;
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_49.setType("radio");
          _jspx_th_impact_validateInput_49.setName("rbResource");
          _jspx_th_impact_validateInput_49.setChecked(radioRsrcChecked);
          _jspx_th_impact_validateInput_49.setValue( String.valueOf( vendorStaffLinkDetBean.getIdPortalUserVendorLink() ) );
          _jspx_th_impact_validateInput_49.setOnClick(populateFields);
          _jspx_th_impact_validateInput_49.setDisabled(disableAssocVndrRadio);
          _jspx_th_impact_validateInput_49.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest((resourceListForUser.size() > 0 && userAccessType.equals(PLCMNT_PRV_ADMIN)
    						&& !retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())) );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t<img align=\"left\" src=\"/grnds-docs/images/shared/btnSelect.gif\" name=\"select\" \r\n\t\t\t  \t\t\t\t\tonclick=\"return fillFields();\" >\r\n\t\t\t        </td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_ButtonTag_2.setName("Delete");
              _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_2.setAlign("right");
              _jspx_th_impact_ButtonTag_2.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_2.setAction("/admin/VendorStaffDetail/deleteVendor");
              _jspx_th_impact_ButtonTag_2.setFunction("disableValidate();");
              _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n   \t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest((userAccessType.equals(PLCMNT_PRV_ADMIN)
    							&& !retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())) );
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write(" \r\n\t\t<tr>\r\n\t\t  <td>                   \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t  \t<tr>\r\n\t\t\t    \t<th colspan=\"6\">Selected Vendor Detail</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t     <tr>\r\n\t\t\t       <td>\r\n\t\t\t       \t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
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
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateDisplayOnlyField_1.setName("rsrcId");
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Resource ID");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue(selectedRsrcId );
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\t\t                                            \r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\r\n\t\t\t       <td></td>\r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\t\t                                            \r\n\t       \t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_7.setName("selReqType");
              _jspx_th_impact_validateSelect_7.setLabel("User Type");
              _jspx_th_impact_validateSelect_7.setCodesTable("CUSRTYP");
              _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_7.setValue(selectedType);
              _jspx_th_impact_validateSelect_7.setDisabled(disableUsrTyp);
              _jspx_th_impact_validateSelect_7.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     </tr>\r\n\t\t\t     <tr>\t\t                                            \r\n\t       \t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_8.setName("selStatus");
              _jspx_th_impact_validateSelect_8.setLabel("Status");
              _jspx_th_impact_validateSelect_8.setCodesTable("CUSRSTAT");
              _jspx_th_impact_validateSelect_8.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_8.setOptions( VendorStaffDetailConversation.getMethodOptions(retrieveVendorStaffDetailSO.getScreenName() !=null ? retrieveVendorStaffDetailSO.getScreenName(): "") );
              _jspx_th_impact_validateSelect_8.setValue(selectedStatus);
              _jspx_th_impact_validateSelect_8.setDisabled(disableStatus);
              _jspx_th_impact_validateSelect_8.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     </tr>\t\t     \r\n\t\t\t     <tr>\r\n\t\t\t       <td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
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
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
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
              out.write("</td>\r\n\t\t\t     </tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\t<td></td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_ButtonTag_3.setName("Save");
              _jspx_th_impact_ButtonTag_3.setImg("btnSave");
              _jspx_th_impact_ButtonTag_3.setAlign("right");
              _jspx_th_impact_ButtonTag_3.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_3.setAction("/admin/VendorStaffDetail/saveVendorStaffDetail");
              _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t  <td>                   \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t  \t<tr>\r\n\t\t\t    \t<th colspan=\"6\">Associate New Vendor</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t     <tr>\t\t                                            \r\n\t\t\t\t    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateSelect_9.setStyle("WIDTH: 160px");
              _jspx_th_impact_validateSelect_9.setLabel("New Vendor");
              _jspx_th_impact_validateSelect_9.setName("selNewVendor");
              _jspx_th_impact_validateSelect_9.setStyle("WIDTH: 240px");
              _jspx_th_impact_validateSelect_9.setValue(FormattingHelper.formatString(idVendor));
              _jspx_th_impact_validateSelect_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_9.setEditableMode( EditableMode.ALL );
              _jspx_th_impact_validateSelect_9.setDisabled("false");
              _jspx_th_impact_validateSelect_9.setOnChange("getResource();");
              _jspx_th_impact_validateSelect_9.setOptions(resourceIDList);
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t    </td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t<img align=\"right\" src=\"/grnds-docs/images/shared/btnAdd.gif\" name=\"add\" \r\n\t\t\t  \t\t\t\t\tonclick=\"return setNewResource();\" >\r\n\t\t\t        </td>\t\t\t    \r\n\t\t\t  \t </tr>\t\t     \t\t  \t\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest((retrieveVendorStaffDetailSO.getScreenName()!=null && 
  							(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_STAFF_LIST)) && 
  							(userAccessType.equals(PLCMNT_PRV_ADMIN))
  							&& !retrieveVendorStaffDetailSO.getIdUser().
 								equals(retrieveVendorStaffDetailSO.getIdLoggedInUser()) &&
 								!isActiveAdmin) );
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<tr>\r\n\t\t  <td>                   \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t  \t<tr>\r\n\t\t\t    \t<th colspan=\"6\">Password Reset</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t     <tr>\t\t                                            \r\n\t\t\t\t     <td align=\"left\">\r\n\t\t\t\t        Click the reset button to reset this user's password with a temporary password and e-mail the temporary password to the e-mail address above.\r\n\t\t\t\t     </td>\r\n\t\t\t  \t\t<td>\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_ButtonTag_4.setName("Reset");
              _jspx_th_impact_ButtonTag_4.setImg("btnReset");
              _jspx_th_impact_ButtonTag_4.setAlign("right");
              _jspx_th_impact_ButtonTag_4.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_4.setAction("/admin/VendorStaffDetail/resetPassword");
              _jspx_th_impact_ButtonTag_4.setFunction("return warnPasswordReset();");
              _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t </tr>\t\t     \t\t  \t\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>  \r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_3.setTest((userAccessType.equals(PLCMNT_PRV_ADMIN)
								&& !retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())) );
          int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
          if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write(" \t\r\n\t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"2\">Administrator Agreement</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td align=\"left\">\r\n\t\t\t        By clicking on the checkbox below, the administrator confirms that the person to whom they are granting access shall abide by all state and federal laws, rules, and regulations, and the Department of Human Services policy on respecting the confidentiality of an individual's records.  These citations include, but are not limited to, O.C.G.A Sections 49-4-14, 49-5-40, 49-5-41, 50-18-72, and 45 CFR 205.5.  The administrator understands that all records concerning children placed in the custody of the Department of Human Services or all individuals who are the subject of or are included in a child protective services investigation are made confidential by O.C.G.A  Section 49-5-40 and may not be released to anyone except in compliance with O.C.G.A Section 49-5-41.  The administrator also understands that information concerning recipients of TANF, Food Stamps, and Medicaid may only be disclosed pursuant to O.C.G.A Section 49-4-14.\r\n");
              out.write("\t\t\t     </td>\r\n\t\t\t    </tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>\r\n\t\t\t        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_3);
              _jspx_th_impact_validateInput_50.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_50.setLabel("I accept the agreement");
              _jspx_th_impact_validateInput_50.setType("checkbox");
              _jspx_th_impact_validateInput_50.setId("idUsrAgrmnt");
              _jspx_th_impact_validateInput_50.setName("cbxUsrAgrmnt");
              _jspx_th_impact_validateInput_50.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_50.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t     </td>\r\n\t\t\t    </tr>             \r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\r\n\t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_4.setTest((retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST))) );
          int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
          if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
              _jspx_th_impact_ButtonTag_5.setName("Approve");
              _jspx_th_impact_ButtonTag_5.setImg("btnApprove");
              _jspx_th_impact_ButtonTag_5.setAlign("right");
              _jspx_th_impact_ButtonTag_5.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_5.setAction("/admin/VendorStaffDetail/approveVendorStaffDetail");
              _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
              if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t        </td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
              _jspx_th_impact_ButtonTag_6.setName("Disapprove");
              _jspx_th_impact_ButtonTag_6.setImg("btnDisapprove");
              _jspx_th_impact_ButtonTag_6.setAlign("right");
              _jspx_th_impact_ButtonTag_6.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_6.setAction("/admin/VendorStaffDetail/disapproveVendorStaffDetail");
              _jspx_th_impact_ButtonTag_6.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
              if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\t\t\t\t\t \t  \t\r\n\t");

		}
  	
          out.write("  \t\r\n  \t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_5.setTest((userAccessType.equals(PLCMNT_PRV_USRER) 
  								|| (userAccessType.equals(PLCMNT_PRV_ADMIN) &&
  										retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser()))) );
          int _jspx_eval_impact_ifThen_5 = _jspx_th_impact_ifThen_5.doStartTag();
          if (_jspx_eval_impact_ifThen_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"3\">Current Password</th>\r\n\t\t\t  \t</tr>\t\r\n\t\t        <tr>\r\n\t            \t<td width=\"120\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateInput_51.setType("password");
              _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_51.setColspan("2");
              _jspx_th_impact_validateInput_51.setName("txtCurrentPassword");
              _jspx_th_impact_validateInput_51.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_51.setLabel("Password");
              _jspx_th_impact_validateInput_51.setMaxLength("20");
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t          \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>  \t\r\n\t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"3\">Password</th>\r\n\t\t\t  \t</tr>\t\r\n\t\t        <tr>\r\n\t            \t<td width=\"120\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateInput_52.setType("password");
              _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_52.setColspan("2");
              _jspx_th_impact_validateInput_52.setName("txtNewPassword");
              _jspx_th_impact_validateInput_52.setLabel("New Password");
              _jspx_th_impact_validateInput_52.setMaxLength("20");
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t          \t</tr>\r\n\t          \t<tr>\r\n\t            \t<td width=\"120\">");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateInput_53.setType("password");
              _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_53.setColspan("2");
              _jspx_th_impact_validateInput_53.setName("txtNewPasswordConfirm");
              _jspx_th_impact_validateInput_53.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_53.setLabel("Re-Enter New Password");
              _jspx_th_impact_validateInput_53.setMaxLength("20");
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t          \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>      \r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t  \t<tr>\r\n\t\t  \t\t<td></td>\r\n\t\t  \t\t<td width=\"100%\">\r\n\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_ButtonTag_7.setName("Save");
              _jspx_th_impact_ButtonTag_7.setImg("btnSave");
              _jspx_th_impact_ButtonTag_7.setAlign("right");
              _jspx_th_impact_ButtonTag_7.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_7.setAction("/admin/VendorStaffDetail/saveVendorStaffDetail");
              _jspx_th_impact_ButtonTag_7.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
              if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t  \t\t</td>\r\n\t\t  \t</tr>\r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t\t<tr>\r\n\t\t  <td>  \r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"left\">\r\n\t\t\t    <tr>\r\n\t\t\t    \t<th colspan=\"6\">Security Questions</th>\r\n\t\t\t  \t</tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_10.setName("selSecQues1");
              _jspx_th_impact_validateSelect_10.setCodesTable("CSECQUES");
              _jspx_th_impact_validateSelect_10.setRequired("true");
              _jspx_th_impact_validateSelect_10.setLabel("Question 1");
              _jspx_th_impact_validateSelect_10.setValue(seqQues1);
              _jspx_th_impact_validateSelect_10.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateInput_54.setType("text");
              _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_54.setName("txtSecAns1");
              _jspx_th_impact_validateInput_54.setSize("30");
              _jspx_th_impact_validateInput_54.setMaxLength("30");
              _jspx_th_impact_validateInput_54.setRequired("true");
              _jspx_th_impact_validateInput_54.setLabel("Answer 1");
              _jspx_th_impact_validateInput_54.setValue(seqAns1);
              _jspx_th_impact_validateInput_54.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>                                            \r\n\t\t\t    </tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setName("selSecQues2");
              _jspx_th_impact_validateSelect_11.setCodesTable("CSECQUES");
              _jspx_th_impact_validateSelect_11.setRequired("true");
              _jspx_th_impact_validateSelect_11.setLabel("Question 2");
              _jspx_th_impact_validateSelect_11.setValue(seqQues2);
              _jspx_th_impact_validateSelect_11.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateInput_55.setType("text");
              _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_55.setName("txtSecAns2");
              _jspx_th_impact_validateInput_55.setSize("30");
              _jspx_th_impact_validateInput_55.setMaxLength("30");
              _jspx_th_impact_validateInput_55.setRequired("true");
              _jspx_th_impact_validateInput_55.setLabel("Answer 2");
              _jspx_th_impact_validateInput_55.setValue(seqAns2);
              _jspx_th_impact_validateInput_55.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>                                            \r\n\t\t\t    </tr>\r\n\t\t\t    <tr>\r\n\t\t\t     <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setName("selSecQues3");
              _jspx_th_impact_validateSelect_12.setCodesTable("CSECQUES");
              _jspx_th_impact_validateSelect_12.setRequired("true");
              _jspx_th_impact_validateSelect_12.setLabel("Question 3");
              _jspx_th_impact_validateSelect_12.setValue(seqQues3);
              _jspx_th_impact_validateSelect_12.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t     <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_validateInput_56.setType("text");
              _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_56.setName("txtSecAns3");
              _jspx_th_impact_validateInput_56.setLabel("Answer 3");
              _jspx_th_impact_validateInput_56.setSize("30");
              _jspx_th_impact_validateInput_56.setMaxLength("30");
              _jspx_th_impact_validateInput_56.setRequired("true");
              _jspx_th_impact_validateInput_56.setValue(seqAns3);
              _jspx_th_impact_validateInput_56.setEditableMode(EditableMode.ALL );
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>                                            \r\n\t\t\t    </tr>                     \r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t\t<tr>      \r\n\t\t  <td>\r\n\t\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t\t  \t<tr>\r\n\t\t\t  \t\t<td></td>\r\n\t\t\t  \t\t<td width=\"100%\">\r\n\t\t\t  \t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_5);
              _jspx_th_impact_ButtonTag_8.setName("Save");
              _jspx_th_impact_ButtonTag_8.setImg("btnSave");
              _jspx_th_impact_ButtonTag_8.setAlign("right");
              _jspx_th_impact_ButtonTag_8.setForm("frmVndrStaffDtl");
              _jspx_th_impact_ButtonTag_8.setAction("/admin/VendorStaffDetail/saveVendorStaffDetail");
              _jspx_th_impact_ButtonTag_8.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
              if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t  \t\t</td>\r\n\t\t\t  \t</tr>\r\n\t\t\t  </table>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</table>\r\n");
 } 
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_57.setType("hidden");
          _jspx_th_impact_validateInput_57.setName("hdnScreenName");
          _jspx_th_impact_validateInput_57.setValue( retrieveVendorStaffDetailSO.getScreenName() );
          int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
          if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_58.setType("hidden");
          _jspx_th_impact_validateInput_58.setName("hdnSelectFlag");
          _jspx_th_impact_validateInput_58.setValue( StringHelper.BOOLEAN_TRUE );
          int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
          if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_59.setType("hidden");
          _jspx_th_impact_validateInput_59.setName("hdnAddFlag");
          _jspx_th_impact_validateInput_59.setValue( StringHelper.BOOLEAN_FALSE );
          int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
          if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_60.setType("hidden");
          _jspx_th_impact_validateInput_60.setName("hdnSelectedPuvlId");
          _jspx_th_impact_validateInput_60.setValue( selectedPuvlId );
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setType("hidden");
          _jspx_th_impact_validateInput_61.setName("hdnSelectedRsrcNm");
          _jspx_th_impact_validateInput_61.setValue( selectedRsrcNm );
          int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
          if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_62.setType("hidden");
          _jspx_th_impact_validateInput_62.setName("hdnSelectedRsrcId");
          _jspx_th_impact_validateInput_62.setValue( selectedRsrcId );
          int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
          if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_63.setType("hidden");
          _jspx_th_impact_validateInput_63.setName("hdnSelReqType");
          _jspx_th_impact_validateInput_63.setValue( selectedType );
          int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
          if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_64.setType("hidden");
          _jspx_th_impact_validateInput_64.setName("hdnSelStatus");
          _jspx_th_impact_validateInput_64.setValue( selectedStatus );
          int _jspx_eval_impact_validateInput_64 = _jspx_th_impact_validateInput_64.doStartTag();
          if (_jspx_th_impact_validateInput_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_65.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_65.setType("hidden");
          _jspx_th_impact_validateInput_65.setName("hdnDtStart");
          _jspx_th_impact_validateInput_65.setValue( selectedStartDt );
          int _jspx_eval_impact_validateInput_65 = _jspx_th_impact_validateInput_65.doStartTag();
          if (_jspx_th_impact_validateInput_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_66.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_66.setType("hidden");
          _jspx_th_impact_validateInput_66.setName("hdnDtEnd");
          _jspx_th_impact_validateInput_66.setValue( selectedEndDt );
          int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
          if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_67.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_67.setType("hidden");
          _jspx_th_impact_validateInput_67.setName("hdnDisplayPuvlId");
          _jspx_th_impact_validateInput_67.setValue( selectedPuvlId );
          int _jspx_eval_impact_validateInput_67 = _jspx_th_impact_validateInput_67.doStartTag();
          if (_jspx_th_impact_validateInput_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_68 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_68.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_68.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_68.setType("hidden");
          _jspx_th_impact_validateInput_68.setName("hdnDisplayRsrcNm");
          _jspx_th_impact_validateInput_68.setValue( selectedRsrcNm );
          int _jspx_eval_impact_validateInput_68 = _jspx_th_impact_validateInput_68.doStartTag();
          if (_jspx_th_impact_validateInput_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_69 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_69.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_69.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_69.setType("hidden");
          _jspx_th_impact_validateInput_69.setName("hdnDisplayRsrcId");
          _jspx_th_impact_validateInput_69.setValue( selectedRsrcId );
          int _jspx_eval_impact_validateInput_69 = _jspx_th_impact_validateInput_69.doStartTag();
          if (_jspx_th_impact_validateInput_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_70.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_70.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_70.setType("hidden");
          _jspx_th_impact_validateInput_70.setName("hdnDisplayReqType");
          _jspx_th_impact_validateInput_70.setValue( selectedType );
          int _jspx_eval_impact_validateInput_70 = _jspx_th_impact_validateInput_70.doStartTag();
          if (_jspx_th_impact_validateInput_70.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_71 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_71.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_71.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_71.setType("hidden");
          _jspx_th_impact_validateInput_71.setName("hdnDisplayStatus");
          _jspx_th_impact_validateInput_71.setValue( selectedStatus );
          int _jspx_eval_impact_validateInput_71 = _jspx_th_impact_validateInput_71.doStartTag();
          if (_jspx_th_impact_validateInput_71.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_72 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_72.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_72.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_72.setType("hidden");
          _jspx_th_impact_validateInput_72.setName("hdnDisplayDtStart");
          _jspx_th_impact_validateInput_72.setValue( selectedStartDt );
          int _jspx_eval_impact_validateInput_72 = _jspx_th_impact_validateInput_72.doStartTag();
          if (_jspx_th_impact_validateInput_72.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_73 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_73.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_73.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_73.setType("hidden");
          _jspx_th_impact_validateInput_73.setName("hdnDisplayDtEnd");
          _jspx_th_impact_validateInput_73.setValue( selectedEndDt );
          int _jspx_eval_impact_validateInput_73 = _jspx_th_impact_validateInput_73.doStartTag();
          if (_jspx_th_impact_validateInput_73.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_74 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_74.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_74.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_74.setType("hidden");
          _jspx_th_impact_validateInput_74.setName("hdnAddNewRsrcNm");
          _jspx_th_impact_validateInput_74.setValue( selectedRsrcNm );
          int _jspx_eval_impact_validateInput_74 = _jspx_th_impact_validateInput_74.doStartTag();
          if (_jspx_th_impact_validateInput_74.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_75 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_75.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_75.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_75.setType("hidden");
          _jspx_th_impact_validateInput_75.setName("hdnAddNewRsrcId");
          _jspx_th_impact_validateInput_75.setValue( selectedRsrcId );
          int _jspx_eval_impact_validateInput_75 = _jspx_th_impact_validateInput_75.doStartTag();
          if (_jspx_th_impact_validateInput_75.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_76 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_76.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_76.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_76.setType("hidden");
          _jspx_th_impact_validateInput_76.setName("hdnAddNewReqType");
          _jspx_th_impact_validateInput_76.setValue( selectedType );
          int _jspx_eval_impact_validateInput_76 = _jspx_th_impact_validateInput_76.doStartTag();
          if (_jspx_th_impact_validateInput_76.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_77 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_77.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_77.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_77.setType("hidden");
          _jspx_th_impact_validateInput_77.setName("hdnAddNewStatus");
          _jspx_th_impact_validateInput_77.setValue( selectedStatus );
          int _jspx_eval_impact_validateInput_77 = _jspx_th_impact_validateInput_77.doStartTag();
          if (_jspx_th_impact_validateInput_77.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_78 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_78.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_78.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_78.setType("hidden");
          _jspx_th_impact_validateInput_78.setName("hdnAddNewDtStart");
          _jspx_th_impact_validateInput_78.setValue( selectedStartDt );
          int _jspx_eval_impact_validateInput_78 = _jspx_th_impact_validateInput_78.doStartTag();
          if (_jspx_th_impact_validateInput_78.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_79 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_79.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_79.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_79.setType("hidden");
          _jspx_th_impact_validateInput_79.setName("hdnAddNewDtEnd");
          _jspx_th_impact_validateInput_79.setValue( selectedEndDt );
          int _jspx_eval_impact_validateInput_79 = _jspx_th_impact_validateInput_79.doStartTag();
          if (_jspx_th_impact_validateInput_79.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  document.frmVndrStaffDtl.txtFirstName.focus();\r\n  //Rewriting the inner HTML to display the Resource Name and Resource ID  \t\r\n  document.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;\r\n  document.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;\r\n\t  \r\n</script>");
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
