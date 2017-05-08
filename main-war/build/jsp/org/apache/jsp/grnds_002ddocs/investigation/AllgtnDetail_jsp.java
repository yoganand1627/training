package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnConversation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public final class AllgtnDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Allegation Detail
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 11/19/02
//*
//*  Description:
//*   This page allows the user to create, modify, or delete
//*   allegations during the Investigation stage of service.
//*   Allegations may be created or deleted individually and
//*   modified either individually or as a group.
//*
//** Change  History:
//**  Date        User            Description
//**  --------    --------------  ---------------------------------------------------
//**  11/07/03    dejuanr         SIR 22343 - Enable the AP if its an INT allegation
//**                              in a CPS, CCL, or RCL stage.
//**  12/02/03    douglacs        SIR 15842 - add Expoitation-CCL to CCLICALT only
//**                              for CCL and RCL, exclude for CPS
//**  09/08/2009  bgehlot         STGAP00015366:Removed the Alleged Maltreator and changed the label for Maltreator Relationship
//**                              and added saveConfirmMalRel() function to pop up a message on Save
//**  02/15/2010  ssubram		  CAPTA requirement changes 3.1-3.10 
//**  05/26/2010  hjbaptiste      SMS#51977: MR66-Maltreatment In Care - Added additional field to indicate that Maltreatment took
//**                              place while the child was/is in DFCS custody. Allow user to open popup html for help. User has
//**                              to confirm maltreatment in care
//**  07/08/2010  hjbaptiste      SMS#61470: MR66-Maltreatment In Care - Remapped the location of maltreatments to the DFCS Facility 
//**                              description pop-up anchors
//** 06/29/2011   charden		  SMS#113377 - Added default to DFCS Facility informational popup to prevent link failure
//** 07/01/2011   arege	          SMS#113415: CAPTA 4.3 - Allegation Deatil - MIC Pop-Up Happens Twice
//** 01/20/2012   habraham        STGAP00017829 - MR-097 : Unsubstantiated MIC - Made the changes for unSubstantiated MIC, 
//**                              Added hidden variable, added the warning message.
                        						   

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
   //Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
  //  to see how the page functions, but it should always be initialized to view mode.
  //String pageMode = PageMode.VIEW;
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request ) != null )
  {
    pageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
  }
  
  //Everything above this point should be in every page.
  int tabIndex = 1;
  String cdAllegMalCode = "";

      out.write("\r\n\r\n");

  CINV46SO cinv46so = (CINV46SO) request.getAttribute( "CINV46SO" );
  CINV46SOG1_ARRAY personListArray = (CINV46SOG1_ARRAY) state.getAttribute( "personListArray" , request );
  String warnMaltreatmentInCare = (String) state.getAttribute("warnMaltreatmentInCare", request);
  String indMaltreatInCare = (String) state.getAttribute("indMaltreatInCare", request);
  String indUnSubstantiatedMIC = (String) state.getAttribute("indUnSubstantiatedMIC", request);
  cdAllegMalCode = cinv46so.getSzCdAllegType();
  String allegationType = "";
  String policyViolation = cinv46so.getCIndCpsPolicyViolation();
  
  //do calculation to get maltreatment type from the first character of the code
  if (cdAllegMalCode != null){
    if ("N".equals(cinv46so.getSzCdAllegType().substring(0, 1))){
      allegationType = CodesTables.CABALTYP_NN;
    }else if ("S".equals(cinv46so.getSzCdAllegType().substring(0, 1))){
      allegationType = CodesTables.CABALTYP_SS;
    }else if ("E".equals(cinv46so.getSzCdAllegType().substring(0, 1))){
      allegationType = CodesTables.CABALTYP_EE;
    }else if ("P".equals(cinv46so.getSzCdAllegType().substring(0, 1))){
      allegationType = CodesTables.CABALTYP_PP;
    }else if ("O".equals(cinv46so.getSzCdAllegType().substring(0, 1))){
      allegationType = CodesTables.CABALTYP_OO; 
    }
  }
  
  if ("Y".equals(policyViolation)){
     pageMode = PageModeConstants.EDIT;
  }
  
  List checkedValues = (List) state.getAttribute("checkedValues",request);
  if (checkedValues == null) {
    checkedValues = new ArrayList();
  }
 
  Enumeration personListEnum = null;
  if (cinv46so == null)
  {
    cinv46so = new CINV46SO();
  }
  if (personListArray == null)
  {
    personListArray = new CINV46SOG1_ARRAY();
  }
  if (personListArray.enumerateCINV46SOG1() != null)
  {
    personListEnum = personListArray.enumerateCINV46SOG1();
  }

  String hdnOverallDisp = FormattingHelper.formatString( (String) request.getAttribute( "hdnOverallDisp") );
  String ulIdAllegation = FormattingHelper.formatString( (String) request.getAttribute( "hdnUlIdAllegation" ) );
  String ulIdVictim = FormattingHelper.formatString( (String) request.getAttribute( "selUlIdVictim" ) );
  String hdnMode = FormattingHelper.formatString( (String) request.getAttribute( "hdnMode" ) );

  if ("".equals(hdnMode) )
  {
    hdnOverallDisp = FormattingHelper.formatString( request.getParameter( "hdnOverallDisp") );
    ulIdAllegation = FormattingHelper.formatString( request.getParameter( "hdnUlIdAllegation" ) );
    ulIdVictim = FormattingHelper.formatString( request.getParameter( "selUlIdVictim" ) );
    hdnMode = FormattingHelper.formatString( request.getParameter( "hdnMode" ) );
  }
  String txtSzCdAllegStage = FormattingHelper.formatString( cinv46so.getSzCdAllegIncidentStage() );

  String txtEvidenceSummary = "";
  String dtDtAllegedIncident = FormattingHelper.formatDate(cinv46so.getDtDtAllegedIncident());
  String szCdAllegedMalLocation = FormattingHelper.formatString(cinv46so.getSzCdAllegedMalLocation());
  //Adding code for CAPTA
  String dtPriorNearFatalMaltrtmnt = FormattingHelper.formatDate(cinv46so.getDtPriorNearFatalMaltrtmnt());
  boolean bSeverity = false;
  boolean bMulti = true;

  String saveMulti = "";
  String audMode = "";

  if (hdnMode.equals( AllgtnConversation.MULTI )) {
    bMulti = false;
    saveMulti = AllgtnConversation.MULTI;
  } else if (hdnMode.equals( AllgtnConversation.ADD )) {
    audMode = AllgtnConversation.ADD_SER;
    txtSzCdAllegStage = GlobalData.getSzCdStage( request );
  } else if (hdnMode.equals( AllgtnConversation.UPDATE )) {
    audMode = AllgtnConversation.UPDATE_SER;
  }

  String strAllgtnCodesTable = "";
  String strDispCodesTable = "";
  List exOptions = new ArrayList();
  List exOptionsAlleg = new ArrayList();
  boolean bAPreq = false;

  // The differnt programs have differnt codes tables.
  if ( GlobalData.getSzCdStageProgram( request ).equals( CodesTables.CPGRMS_APS )) {
    strAllgtnCodesTable = "CAPSALLG";
    strDispCodesTable = "CAPSALDP";
    bAPreq = !bMulti ? false : true; // If bMulti is false, the page is in multi mode.
    bSeverity = true;
  } else if ( GlobalData.getSzCdStageProgram( request ).equals( CodesTables.CPGRMS_CPS )) {
    strAllgtnCodesTable = "CMLTTYP";
    exOptionsAlleg.add( "EXPC" );
    strDispCodesTable = "CDISPSTN";
   } else if ( GlobalData.getSzCdStageProgram( request ).equals( CodesTables.CPGRMS_CCL )) {
    strAllgtnCodesTable = "CCLICALT";
    strDispCodesTable = "CLIVALDS";
    exOptions.add( "VNF" );
  } else if ( GlobalData.getSzCdStageProgram( request ).equals( CodesTables.CPGRMS_RCL )) {
    strAllgtnCodesTable = "CCLICALT";
    strDispCodesTable = "CLIVALDS";
    exOptions.add( "VNF" );
  }

  String txtTsAllegation = "";
  if (null != cinv46so.getTsLastUpdate())
  {
    txtTsAllegation = cinv46so.getTsLastUpdate().toString();
  }
  if ( audMode.equals( AllgtnConversation.ADD_SER ) )
  {
    txtTsAllegation = "";
  }

  // The victims and ap lists were created in the display method and set in state.
  List victimListOptions = (List) state.getAttribute("victimOptions", request);

  /*
   * SIR 22343 - Enable the AP and MR if its an INT allegation in a CPS, CCL, or RCL stage.
   */
  String bDisableAP =  Sets.isInSetStr( Sets.C + Sets.E , request );
  String bDisableMR =  Sets.isInSetStr( Sets.C + Sets.E , request );
  if ( CodesTables.CSTAGES_INT.equals( cinv46so.getSzCdAllegIncidentStage() ) &&
       ( CodesTables.CPGRMS_CPS.equals( GlobalData.getSzCdStageProgram( request ) ) ||
         CodesTables.CPGRMS_CCL.equals( GlobalData.getSzCdStageProgram( request ) ) ||
         CodesTables.CPGRMS_RCL.equals( GlobalData.getSzCdStageProgram( request ) ) )
     )
  {
    bDisableAP = "false";
    bDisableMR = "false";
  }
  /* 
   * END SIR 22343
   */

   //  Start the Comments section
   if( cinv46so.getSzTxtEvidenceSummary() != null )
   {
     txtEvidenceSummary = cinv46so.getSzTxtEvidenceSummary();
    }

  // Maltreator Relationship should be pulled from CRPTRINT, but exclude the following values:
  List excludeRelationship = new ArrayList();
  excludeRelationship.add(CodesTables.CRPTRINT_AA); // Case Reading
  excludeRelationship.add(CodesTables.CRPTRINT_AG); // Community Agency
  excludeRelationship.add(CodesTables.CRPTRINT_CT); // Court
  excludeRelationship.add(CodesTables.CRPTRINT_FV); // Family Viol. Shelter
  excludeRelationship.add(CodesTables.CRPTRINT_FI); // Financial Institute
  excludeRelationship.add(CodesTables.CRPTRINT_HC); // Hospital / Clinic
  excludeRelationship.add(CodesTables.CRPTRINT_IC); // Institut. Contracted
  excludeRelationship.add(CodesTables.CRPTRINT_IP); // Institut. Pers/vol.
  excludeRelationship.add(CodesTables.CRPTRINT_IN); // Institution
  excludeRelationship.add(CodesTables.CRPTRINT_NS); // Non-Parent Spouse
  excludeRelationship.add(CodesTables.CRPTRINT_NM); // Other Non-Mandated
  excludeRelationship.add(CodesTables.CRPTRINT_OS); // Other Shelter
  excludeRelationship.add(CodesTables.CRPTRINT_SA); // Other St. Agency
  excludeRelationship.add(CodesTables.CRPTRINT_PK); // Primary Caretaker
  excludeRelationship.add(CodesTables.CRPTRINT_SC); // Secondary Caretaker
  excludeRelationship.add(CodesTables.CRPTRINT_SL); // Self
  excludeRelationship.add(CodesTables.CRPTRINT_SP); // Spouse
  excludeRelationship.add(CodesTables.CRPTRINT_SR); // Step-Child
  excludeRelationship.add(CodesTables.CRPTRINT_TN); // TANF(Sanction Related)
  excludeRelationship.add(CodesTables.CRPTRINT_UF); // Unreg. Fam. Hom
  excludeRelationship.add(CodesTables.CRPTRINT_VC); // Victim
  
  //STGAP00015366:
  String hdnSzCdMaltreatorRel = "";
  if(StringHelper.isValid(cinv46so.getSzCdMaltreatorRel())){
    hdnSzCdMaltreatorRel = cinv46so.getSzCdMaltreatorRel();
  }

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onbeforeunload = function ()\r\n  {\r\n      IsDirty();\r\n  };\r\n\r\n  function confirmMaltreatmentInCare()\r\n  {\r\n    if(confirm('");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_ALLEG_DT_MALTREAT_IN_CARE ));
      out.write("' ) )\r\n    {\r\n      //setting the values to the hidden variables based on the selection from the confirm message\r\n      document.frmAllgtnDetail.hdnIndMaltreatInCare.value = '");
      out.print( indMaltreatInCare );
      out.write("';\r\n      document.frmAllgtnDetail.hdnIndUnSubstantiatedMIC.value = '");
      out.print( indUnSubstantiatedMIC );
      out.write("';\r\n      document.frmAllgtnDetail.hdnUpdateMaltreatInCare.value = 'Y';\r\n      if ('true' == saveClicked) {\r\n        submitValidateForm('frmAllgtnDetail', '/investigation/Allegation/saveAllgtn');\r\n      } else if ('true' == saveMultiClicked) {\r\n        submitValidateForm('frmAllgtnDetail', '/investigation/Allegation/saveAllgtnMulti');\r\n      }\r\n    }\r\n  }\r\n \r\n  function saveConfirm()\r\n  {\r\n    OverallDisp = '");
      out.print( hdnOverallDisp );
      out.write("';\r\n    if ( OverallDisp.length > 0 )\r\n    {\r\n      if(!confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_BLANK_OA_DISP ) );
      out.write("')){\r\n        return false;\r\n      }else{\r\n        if(saveConfirmMalRel()){\r\n          return true;\r\n        }else{\r\n          return false;\r\n        }\r\n      }\r\n    }\r\n    if(saveConfirmMalRel()){\r\n       return true;\r\n    }else{\r\n       return false;\r\n    }\r\n    document.frmAllgtnDetail.hdnUpdateMaltreatInCare.value = 'N';\r\n    return true;\r\n  }\r\n\r\n  function deleteConfirm()\r\n  {\r\n    disableValidation(\"frmAllgtnDetail\");\r\n    if (confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("'))\r\n    {\r\n      OverallDisp = '");
      out.print( hdnOverallDisp );
      out.write("';\r\n      if ( OverallDisp.length > 0 )\r\n      {\r\n        return confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_BLANK_OA_DISP ) );
      out.write("');\r\n      }\r\n      return true;\r\n    }\r\n    return false;\r\n  }\r\n  \r\n//Assign the corrective action codes table CMALCODE to the static variable maltreatmentCodeCodesTable\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName( CodesTables.CMALCODE );
      _jspx_th_impact_codeArray_0.setArrayName( CodesTables.CMALCODE );
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
      _jspx_th_impact_codeArray_1.setCodeName( CodesTables.CABALTYP );
      _jspx_th_impact_codeArray_1.setArrayName( CodesTables.CABALTYP );
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n function resetAllegMalCode()\r\n {\r\n   if ( document.frmAllgtnDetail.selSzCdAllegType.value != null)\r\n   {\r\n     var malCode = document.frmAllgtnDetail.selSzCdAllegType.value;\r\n       \r\n     var codeArray1 = ");
      out.print( CodesTables.CMALCODE );
      out.write(";       \r\n     var codeArray2 = ");
      out.print( CodesTables.CABALTYP );
      out.write(";\r\n     \r\n     for (var q=0; q < codeArray1.length; q++)\r\n     {\r\n      var code = codeArray1[q].substring(0,codeArray1[q].indexOf(\"|\"));\r\n      var decode = codeArray1[q].substring( codeArray1[q].indexOf(\"|\")+1, codeArray1[q].length);\r\n         if ( code ==  malCode )\r\n          {\r\n            document.frmAllgtnDetail.selSzCdAllegMalCode.value = code;\r\n          }\r\n     } \r\n          \r\n     populateDropdown( frmAllgtnDetail.selSzCdAllegType , \"\", ");
      out.print( CodesTables.CABALTYP );
      out.write(" );\r\n          \r\n     for (var q=0; q < codeArray2.length; q++)\r\n     {\r\n      var code = codeArray2[q].substring(0,codeArray2[q].indexOf(\"|\"));\r\n      var decode = codeArray2[q].substring( codeArray2[q].indexOf(\"|\")+1, codeArray2[q].length);\r\n         if ( code.substring( 0, 1 ) ==  malCode.substring( 0, 1 ) )\r\n          {\r\n            document.frmAllgtnDetail.selSzCdAllegType.value = code;\r\n          }\r\n      }\r\n    }  \r\n } \r\n\r\n function filterMaltreatmentCode()\r\n { \r\n        \r\n   var maltreatmentTypeFilter = document.frmAllgtnDetail.selSzCdAllegType.value;\r\n   \r\n   if ( maltreatmentTypeFilter == \"\" )\r\n   {\r\n      clearDropdown( frmAllgtnDetail.selSzCdAllegMalCode );\r\n   }\r\n   else\r\n    {\r\n     populateDropdownDecode( frmAllgtnDetail.selSzCdAllegMalCode , \"\", ");
      out.print( CodesTables.CMALCODE );
      out.write(", true );\r\n       \r\n     var codeArray = ");
      out.print( CodesTables.CMALCODE );
      out.write(";\r\n     var count = 1;\r\n     \r\n     for (var q=0; q < codeArray.length; q++)\r\n     {\r\n       //  Get the code from the codeArray we are filtering\r\n      var code = codeArray[q].substring(0,codeArray[q].indexOf(\"|\"));\r\n      //  Get the decode from the codeArray we are filtering\r\n      var decode = codeArray[q].substring( codeArray[q].indexOf(\"|\")+1, codeArray[q].length);\r\n      //  If the code contains the filter key and the key is not empty string\r\n      //  add the code to the filtered list\r\n         if ( code.substring( 0, 1 ) ==  maltreatmentTypeFilter.substring( 0, 1 ) )\r\n          {\r\n           //  Add the code and decode to the filtered list\r\n            document.frmAllgtnDetail.selSzCdAllegMalCode.options[count].value = code;\r\n            document.frmAllgtnDetail.selSzCdAllegMalCode.options[count].text  = code + \" \" + decode;\r\n            count++;\r\n          }\r\n     }\r\n         document.frmAllgtnDetail.selSzCdAllegMalCode.options.length = count;\r\n    }\r\n }\r\n \r\n function displayODISPolicy() {\r\n  var descriptor = \"\";\r\n");
      out.write("  descriptor += \"width=700,\";\r\n  descriptor += \"height=475,\";\r\n  descriptor += \"channelmode=0,\";\r\n  descriptor += \"dependent=0,\";\r\n  descriptor += \"directories=0,\";\r\n  descriptor += \"fullscreen=0,\";\r\n  descriptor += \"location=0,\";\r\n  descriptor += \"menubar=0,\";\r\n  descriptor += \"resizable=0,\";\r\n  descriptor += \"scrollbars=1,\";\r\n  descriptor += \"status=0,\";\r\n  descriptor += \"toolbar=0\";\r\n  if (document.frmAllgtnDetail.hdnLocationAnchor.value != \"\") {\r\n    return window.open('/investigation/Allegation/displayLocOfMalHelp'+'#'+document.frmAllgtnDetail.hdnLocationAnchor.value, \"_blank\", descriptor);\r\n  }\r\n }\r\n \r\n function setAnchor() {\r\n   var anchorPoint = \"\";\r\n   var malLocation = document.frmAllgtnDetail.szCdAllegedMalLocation.value;\r\n   if (malLocation == '011' || malLocation == '020') {\r\n     anchorPoint = 'resFacilities';\r\n   } else if (malLocation == '007' || malLocation == '010' || malLocation == '012' || malLocation == '014' \r\n                                   || malLocation == '016' || malLocation == '018') {\r\n");
      out.write("     anchorPoint = 'dfcsHomes';\r\n   } else if (malLocation == '008' || malLocation == '019') {\r\n     anchorPoint = 'nonDfcsHomes';\r\n   } else if (malLocation == '009') {\r\n     anchorPoint = 'schools';\r\n   } else if (malLocation == '013') {\r\n     anchorPoint = 'nonResFacilities';\r\n   } else {\r\n   \t anchorPoint = 'dfcsHomes';\r\n   }\r\n   document.frmAllgtnDetail.hdnLocationAnchor.value = anchorPoint;\r\n }\r\n \r\n /*STGAP00015366:Added this method to pop uo a message when disposition and Relationship are entered*/\r\n function saveConfirmMalRel()\r\n  {\r\n   ");
if(!StringHelper.isValid(cinv46so.getCdAllegDisposition())){
      out.write("\r\n    var disposition = document.frmAllgtnDetail.selCdAllegDisposition.value;\r\n    if ( disposition.length > 0)\r\n    {\r\n      if( confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_MAL_REL ) );
      out.write("') == true){\r\n        return true;\r\n      }else{\r\n        return false;\r\n     }\r\n    }\r\n    ");
}
      out.write("\r\n    return true;\r\n  }\r\n\r\n</script>\r\n\r\n");
 if (!"Y".equals(warnMaltreatmentInCare)) { 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
} 
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAllgtnDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/Allegation/saveDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n<!-- Hidden Fields -->\r\n<!-- List Variables -->\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnSzCdStageProgram");
          _jspx_th_impact_validateInput_1.setValue( GlobalData.getSzCdStageProgram( request ) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnOverallDisp");
          _jspx_th_impact_validateInput_2.setValue( hdnOverallDisp );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnSzCdMaltreatorRel");
          _jspx_th_impact_validateInput_3.setValue( hdnSzCdMaltreatorRel );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<!-- Detail Variables-->\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnUlIdAllegation");
          _jspx_th_impact_validateInput_4.setValue( ulIdAllegation );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_5.setValue( audMode);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnSzCdAllegStage");
          _jspx_th_impact_validateInput_6.setValue( txtSzCdAllegStage);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_7.setValue( txtTsAllegation);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnMode");
          _jspx_th_impact_validateInput_8.setValue( hdnMode);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("hdnIndMaltreatInCare");
          _jspx_th_impact_validateInput_11.setValue( cinv46so.getCIndMaltreatInCare() );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnIndUnSubstantiatedMIC");
          _jspx_th_impact_validateInput_12.setValue( cinv46so.getCIndUnsubMIC());
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Allegation Detail</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setDisabled( Sets.isInSetStr( Sets.E , request ));
          _jspx_th_impact_validateDate_0.setRequired("false");
          _jspx_th_impact_validateDate_0.setValue(dtDtAllegedIncident);
          _jspx_th_impact_validateDate_0.setName("dtDtAllegedIncident");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setLabel("Date of Alleged Incident");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td></td><td></td>\r\n  </tr>\r\n  \r\n    <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Alleged Maltreated Child");
          _jspx_th_impact_validateSelect_0.setRequired( String.valueOf( bMulti ) );
          _jspx_th_impact_validateSelect_0.setName("selUlIdVictim");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setOptions( victimListOptions );
          _jspx_th_impact_validateSelect_0.setDisabled( Sets.isInSetStr( Sets.C + Sets.E , request ));
          _jspx_th_impact_validateSelect_0.setValue( ulIdVictim);
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzCdAllegStage");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Stage");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( txtSzCdAllegStage);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td></td><td></td>\r\n  </tr>\r\n  ");
//STGAP00015366:Alleged Maltreator Relationship is not displayed once the disposition is entered 
   boolean doNotHideRelationship = !StringHelper.isValid(cinv46so.getCdAllegDisposition());
   String a = (String)request.getAttribute("doNotHideRalationship");
   if(request.getAttribute("doNotHideRalationship") !=  null && StringHelper.isTrue((String)request.getAttribute("doNotHideRalationship"))){
     doNotHideRelationship = true;
   }
   if(doNotHideRelationship){ 
          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Alleged Maltreator Relationship");
          _jspx_th_impact_validateSelect_1.setName("selSzCdMaltreatorRel");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CRPTRINT );
          _jspx_th_impact_validateSelect_1.setExcludeOptions( excludeRelationship );
          _jspx_th_impact_validateSelect_1.setDisabled( bDisableMR );
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( cinv46so.getSzCdMaltreatorRel() );
          _jspx_th_impact_validateSelect_1.setValueType( SelectTag.CODES);
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.CODES_DECODES);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td></td><td></td><td></td>\r\n  </tr>\r\n  ");
} 
          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Maltreatment Type");
          _jspx_th_impact_validateSelect_2.setRequired( String.valueOf( bMulti ) );
          _jspx_th_impact_validateSelect_2.setName("selSzCdAllegType");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CABALTYP );
          _jspx_th_impact_validateSelect_2.setExcludeOptions( exOptionsAlleg );
          _jspx_th_impact_validateSelect_2.setDisabled( Sets.isInSetStr( Sets.C + Sets.E , request ));
          _jspx_th_impact_validateSelect_2.setValue( allegationType );
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setOnChange("filterMaltreatmentCode();");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td></td><td></td><td></td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Maltreatment Code");
          _jspx_th_impact_validateSelect_3.setRequired( String.valueOf( bMulti ) );
          _jspx_th_impact_validateSelect_3.setContentType( SelectTag.CODES_DECODES);
          _jspx_th_impact_validateSelect_3.setName("selSzCdAllegMalCode");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CMALCODE );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setValue( cdAllegMalCode );
          _jspx_th_impact_validateSelect_3.setValueType( SelectTag.CODES);
          _jspx_th_impact_validateSelect_3.setDisabled( Sets.isInSetStr( Sets.C + Sets.E , request ));
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td></td><td></td><td></td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Where did the Maltreatment Occur?");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setName("szCdAllegedMalLocation");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setOnChange("setAnchor()");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setOrderBy( SelectTag.DECODE_ORDERBY );
          _jspx_th_impact_validateSelect_4.setCodesTable( CodesTables.CLOCMALT );
          _jspx_th_impact_validateSelect_4.setValue(szCdAllegedMalLocation);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    &nbsp;&nbsp;&nbsp;&nbsp;<strong><a href=\"#\" onClick = \"setIsDirtyCalled(true);displayODISPolicy()\">?</a></strong></td>\r\n  </tr>\r\n  <tr>\r\n     <td>Evidence Description:</td>\r\n      <td>\r\n      ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxEvidenceCode");
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes( checkedValues );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName(CodesTables.CEVDCD );
          _jspx_th_impact_codesCheckbox_0.setColumns(2);
          _jspx_th_impact_codesCheckbox_0.setIsRuled(false);
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_codesCheckbox_0.setDisabled( String.valueOf( EditableMode.isCompatibleWith(pageMode, EditableMode.VIEW) ) );
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(false);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n       <td></td><td></td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtEvidenceSummary");
          _jspx_th_impact_validateTextArea_0.setLabel("Evidence Summary");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write(' ');
              out.print(txtEvidenceSummary);
              out.write("\r\n\t ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td></td><td></td><td></td>\r\n  </tr>\r\n  ");

  	  String indCrimChrgsFiled_yes = "false";
      String indCrimChrgsFiled_no = "false";
      String rb_indCrimChrgsFiled = cinv46so.getIndCrimChrgsFiled();
      if("Y".equals(rb_indCrimChrgsFiled)){
        indCrimChrgsFiled_yes = "true";
      }
      else if("N".equals(rb_indCrimChrgsFiled)){
        indCrimChrgsFiled_no = "true";
      }
      
          out.write("\r\n  <tr>\r\n    <td>Were criminal charges filed?\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("Yes");
          _jspx_th_impact_validateInput_13.setName("indCrimChrgsFiled");
          _jspx_th_impact_validateInput_13.setValue("Y");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setChecked(indCrimChrgsFiled_yes);
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("No");
          _jspx_th_impact_validateInput_14.setName("indCrimChrgsFiled");
          _jspx_th_impact_validateInput_14.setValue("N");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setChecked(indCrimChrgsFiled_no);
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>  \r\n  \r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Disposition");
          _jspx_th_impact_validateSelect_5.setName("selCdAllegDisposition");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setCodesTable( strDispCodesTable );
          _jspx_th_impact_validateSelect_5.setExcludeOptions( exOptions );
          _jspx_th_impact_validateSelect_5.setValue( cinv46so.getCdAllegDisposition());
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setLabel("Severity");
          _jspx_th_impact_validateSelect_6.setName("selSzCdAllegSeverity");
          _jspx_th_impact_validateSelect_6.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_6.setCodesTable("CSEVERTY");
          _jspx_th_impact_validateSelect_6.setValue( cinv46so.getSzCdAllegSeverity());
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n    ");

      //Adding code for CAPTA
  	  String indSevChildDeath_yes = "false";
      String indSevChildDeath_no = "false";
      String rb_indSevChildDeath = cinv46so.getIndChildDeathSeverity();
      if("Y".equals(rb_indSevChildDeath)){
        indSevChildDeath_yes = "true";
      }
      else if("N".equals(rb_indSevChildDeath)){
        indSevChildDeath_no = "true";
      }
      
          out.write("\r\n  ");
          out.write("      \r\n  <tr>\r\n    <td colspan=2><span class=\"formCondRequiredText\">&#135;</span>If Severity is Child Death, is this death the direct result of a maltreatment sustained as a Near Fatality:\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setLabel("Yes");
          _jspx_th_impact_validateInput_15.setName("indSevChildDeath");
          _jspx_th_impact_validateInput_15.setValue("Y");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setChecked(indSevChildDeath_yes);
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setLabel("No");
          _jspx_th_impact_validateInput_16.setName("indSevChildDeath");
          _jspx_th_impact_validateInput_16.setValue("N");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setChecked(indSevChildDeath_no);
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setValue(dtPriorNearFatalMaltrtmnt);
          _jspx_th_impact_validateDate_1.setName("dtPriorNearFatalMaltrtmnt");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setLabel("Date of Prior Near Fatality Maltreatment");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  ");
          out.write("      \r\n</table>\r\n");
          out.write('\r');
          out.write('\n');

boolean bDisableDelete = CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request)) ? true : false;

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteConfirm();");
          _jspx_th_impact_ButtonTag_0.setForm("frmAllgtnDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/investigation/Allegation/deleteAllgtn");
          _jspx_th_impact_ButtonTag_0.setDisabled( Boolean.toString( Sets.isInSet( Sets.B + Sets.D + Sets.E , request ) || bDisableDelete ) );
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ifMobileImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
          _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
          if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n      ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_0);
            _jspx_th_impact_ButtonTag_1.setName("btnSaveAndStay");
            _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndStay");
            _jspx_th_impact_ButtonTag_1.setFunction("return saveConfirm();");
            _jspx_th_impact_ButtonTag_1.setForm("frmAllgtnDetail");
            _jspx_th_impact_ButtonTag_1.setAction("/investigation/Allegation/saveAllgtn");
            _jspx_th_impact_ButtonTag_1.setDisabled( Sets.isInSetStr( Sets.A + Sets.C + Sets.D + Sets.E , request ));
            _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
            _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
            int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
            if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n      ");
          }
          if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setFunction("return saveConfirm();");
          _jspx_th_impact_ButtonTag_2.setForm("frmAllgtnDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/investigation/Allegation/saveAllgtn");
          _jspx_th_impact_ButtonTag_2.setDisabled( Sets.isInSetStr( Sets.D + Sets.E , request ));
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <!-- impact:ifMobileImpact -->\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveMulti");
          _jspx_th_impact_ButtonTag_3.setFunction("return saveConfirm();");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setForm("frmAllgtnDetail");
          _jspx_th_impact_ButtonTag_3.setAction("/investigation/Allegation/saveAllgtnMulti");
          _jspx_th_impact_ButtonTag_3.setDisabled( Sets.isInSetStr( Sets.A + Sets.B + Sets.C + Sets.D , request ));
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <!--  /impact:ifMobileImpact -->\r\n    </td>\r\n  </tr>\r\n</table>\r\n<!--- End Detail Table --->\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n");
          out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n   \r\n   //filterMaltreatmentCode();\r\n   //resetAllegMalCode(); \r\n   \r\nvar saveClicked;\r\nvar saveMultiClicked;\r\nwindow.onload = function ()\r\n{\r\n  setAnchor();\r\n  ");

  String previousURL = (String) request.getParameter("FormValidationPrevUrl");
  if ("Y".equals(warnMaltreatmentInCare) && (!"/investigation/Allegation/displayAllgtnList".equals(previousURL))) {
  
          out.write("\r\n    document.frmAllgtnDetail.hdnIndMaltreatInCare.value = '");
          out.print( indMaltreatInCare );
          out.write("';\r\n    document.frmAllgtnDetail.hdnIndUnSubstantiatedMIC.value = '");
          out.print( indUnSubstantiatedMIC );
          out.write("';\r\n    saveClicked = '");
          out.print( StringHelper.isValid(request.getParameter("btnSave" + ".x")));
          out.write("';\r\n    saveMultiClicked = '");
          out.print( StringHelper.isValid(request.getParameter("btnSaveMulti" + ".x")));
          out.write("';\r\n    if ('true' == saveClicked || 'true' == saveMultiClicked){\r\n    confirmMaltreatmentInCare();\r\n    }\r\n  ");

  }
  
          out.write("\r\n}   \r\n</script>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

}

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
    _jspx_th_impact_validateInput_0.setName("pageType");
    _jspx_th_impact_validateInput_0.setValue("AllgtnDetail");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_9.setName("hdnLocationAnchor");
    _jspx_th_impact_validateInput_9.setValue("schools");
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
    _jspx_th_impact_validateInput_10.setName("hdnUpdateMaltreatInCare");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
