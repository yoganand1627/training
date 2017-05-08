<%
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
                        						   
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV46SOG1_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnConversation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>

<%
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
%>

<%
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
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>

<script type="text/javascript" language="JavaScript1.2">
  window.onbeforeunload = function ()
  {
      IsDirty();
  };

  function confirmMaltreatmentInCare()
  {
    if(confirm('<%=MessageLookup.getMessageByNumber( Messages.MSG_ALLEG_DT_MALTREAT_IN_CARE )%>' ) )
    {
      //setting the values to the hidden variables based on the selection from the confirm message
      document.frmAllgtnDetail.hdnIndMaltreatInCare.value = '<%= indMaltreatInCare %>';
      document.frmAllgtnDetail.hdnIndUnSubstantiatedMIC.value = '<%= indUnSubstantiatedMIC %>';
      document.frmAllgtnDetail.hdnUpdateMaltreatInCare.value = 'Y';
      if ('true' == saveClicked) {
        submitValidateForm('frmAllgtnDetail', '/investigation/Allegation/saveAllgtn');
      } else if ('true' == saveMultiClicked) {
        submitValidateForm('frmAllgtnDetail', '/investigation/Allegation/saveAllgtnMulti');
      }
    }
  }
 
  function saveConfirm()
  {
    OverallDisp = '<%= hdnOverallDisp %>';
    if ( OverallDisp.length > 0 )
    {
      if(!confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_BLANK_OA_DISP ) %>')){
        return false;
      }else{
        if(saveConfirmMalRel()){
          return true;
        }else{
          return false;
        }
      }
    }
    if(saveConfirmMalRel()){
       return true;
    }else{
       return false;
    }
    document.frmAllgtnDetail.hdnUpdateMaltreatInCare.value = 'N';
    return true;
  }

  function deleteConfirm()
  {
    disableValidation("frmAllgtnDetail");
    if (confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>'))
    {
      OverallDisp = '<%= hdnOverallDisp %>';
      if ( OverallDisp.length > 0 )
      {
        return confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_BLANK_OA_DISP ) %>');
      }
      return true;
    }
    return false;
  }
  
//Assign the corrective action codes table CMALCODE to the static variable maltreatmentCodeCodesTable
<impact:codeArray codeName="<%= CodesTables.CMALCODE %>" arrayName="<%= CodesTables.CMALCODE %>" blankValue="true"/>
<impact:codeArray codeName="<%= CodesTables.CABALTYP %>" arrayName="<%= CodesTables.CABALTYP %>" blankValue="true"/>


 function resetAllegMalCode()
 {
   if ( document.frmAllgtnDetail.selSzCdAllegType.value != null)
   {
     var malCode = document.frmAllgtnDetail.selSzCdAllegType.value;
       
     var codeArray1 = <%= CodesTables.CMALCODE %>;       
     var codeArray2 = <%= CodesTables.CABALTYP %>;
     
     for (var q=0; q < codeArray1.length; q++)
     {
      var code = codeArray1[q].substring(0,codeArray1[q].indexOf("|"));
      var decode = codeArray1[q].substring( codeArray1[q].indexOf("|")+1, codeArray1[q].length);
         if ( code ==  malCode )
          {
            document.frmAllgtnDetail.selSzCdAllegMalCode.value = code;
          }
     } 
          
     populateDropdown( frmAllgtnDetail.selSzCdAllegType , "", <%= CodesTables.CABALTYP %> );
          
     for (var q=0; q < codeArray2.length; q++)
     {
      var code = codeArray2[q].substring(0,codeArray2[q].indexOf("|"));
      var decode = codeArray2[q].substring( codeArray2[q].indexOf("|")+1, codeArray2[q].length);
         if ( code.substring( 0, 1 ) ==  malCode.substring( 0, 1 ) )
          {
            document.frmAllgtnDetail.selSzCdAllegType.value = code;
          }
      }
    }  
 } 

 function filterMaltreatmentCode()
 { 
        
   var maltreatmentTypeFilter = document.frmAllgtnDetail.selSzCdAllegType.value;
   
   if ( maltreatmentTypeFilter == "" )
   {
      clearDropdown( frmAllgtnDetail.selSzCdAllegMalCode );
   }
   else
    {
     populateDropdownDecode( frmAllgtnDetail.selSzCdAllegMalCode , "", <%= CodesTables.CMALCODE %>, true );
       
     var codeArray = <%= CodesTables.CMALCODE %>;
     var count = 1;
     
     for (var q=0; q < codeArray.length; q++)
     {
       //  Get the code from the codeArray we are filtering
      var code = codeArray[q].substring(0,codeArray[q].indexOf("|"));
      //  Get the decode from the codeArray we are filtering
      var decode = codeArray[q].substring( codeArray[q].indexOf("|")+1, codeArray[q].length);
      //  If the code contains the filter key and the key is not empty string
      //  add the code to the filtered list
         if ( code.substring( 0, 1 ) ==  maltreatmentTypeFilter.substring( 0, 1 ) )
          {
           //  Add the code and decode to the filtered list
            document.frmAllgtnDetail.selSzCdAllegMalCode.options[count].value = code;
            document.frmAllgtnDetail.selSzCdAllegMalCode.options[count].text  = code + " " + decode;
            count++;
          }
     }
         document.frmAllgtnDetail.selSzCdAllegMalCode.options.length = count;
    }
 }
 
 function displayODISPolicy() {
  var descriptor = "";
  descriptor += "width=700,";
  descriptor += "height=475,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=0,";
  descriptor += "fullscreen=0,";
  descriptor += "location=0,";
  descriptor += "menubar=0,";
  descriptor += "resizable=0,";
  descriptor += "scrollbars=1,";
  descriptor += "status=0,";
  descriptor += "toolbar=0";
  if (document.frmAllgtnDetail.hdnLocationAnchor.value != "") {
    return window.open('/investigation/Allegation/displayLocOfMalHelp'+'#'+document.frmAllgtnDetail.hdnLocationAnchor.value, "_blank", descriptor);
  }
 }
 
 function setAnchor() {
   var anchorPoint = "";
   var malLocation = document.frmAllgtnDetail.szCdAllegedMalLocation.value;
   if (malLocation == '011' || malLocation == '020') {
     anchorPoint = 'resFacilities';
   } else if (malLocation == '007' || malLocation == '010' || malLocation == '012' || malLocation == '014' 
                                   || malLocation == '016' || malLocation == '018') {
     anchorPoint = 'dfcsHomes';
   } else if (malLocation == '008' || malLocation == '019') {
     anchorPoint = 'nonDfcsHomes';
   } else if (malLocation == '009') {
     anchorPoint = 'schools';
   } else if (malLocation == '013') {
     anchorPoint = 'nonResFacilities';
   } else {
   	 anchorPoint = 'dfcsHomes';
   }
   document.frmAllgtnDetail.hdnLocationAnchor.value = anchorPoint;
 }
 
 /*STGAP00015366:Added this method to pop uo a message when disposition and Relationship are entered*/
 function saveConfirmMalRel()
  {
   <%if(!StringHelper.isValid(cinv46so.getCdAllegDisposition())){%>
    var disposition = document.frmAllgtnDetail.selCdAllegDisposition.value;
    if ( disposition.length > 0)
    {
      if( confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_INV_CONFIRM_MAL_REL ) %>') == true){
        return true;
      }else{
        return false;
     }
    }
    <%}%>
    return true;
  }

</script>

<% if (!"Y".equals(warnMaltreatmentInCare)) { %>
<impact:validateErrors/>
<%} %>
<impact:validateForm name="frmAllgtnDetail"
  method="post"
  action="/investigation/Allegation/saveDetail"
  pageMode="<%=pageMode%>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnCustomValidation"
  schema="/WEB-INF/Constraints.xsd">


<!-- Hidden Fields -->
<!-- List Variables -->
<impact:validateInput type="hidden" name="pageType" value="AllgtnDetail"/>
<impact:validateInput type="hidden" name="hdnSzCdStageProgram" value="<%= GlobalData.getSzCdStageProgram( request ) %>" />
<impact:validateInput type="hidden" name="hdnOverallDisp" value="<%= hdnOverallDisp %>"/>
<impact:validateInput type="hidden" name="hdnSzCdMaltreatorRel" value="<%= hdnSzCdMaltreatorRel %>"/>

<!-- Detail Variables-->

<impact:validateInput type="hidden" name="hdnUlIdAllegation" value="<%= ulIdAllegation %>"/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= audMode%>"/>
<impact:validateInput type="hidden" name="hdnSzCdAllegStage" value="<%= txtSzCdAllegStage%>"/>
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= txtTsAllegation%>"/>
<impact:validateInput type="hidden" name="hdnMode" value="<%= hdnMode%>"/>

<impact:validateInput type="hidden" name="hdnLocationAnchor" value="schools" />
<impact:validateInput type="hidden" name="hdnUpdateMaltreatInCare" value="" />
<impact:validateInput type="hidden" name="hdnIndMaltreatInCare" value="<%= cinv46so.getCIndMaltreatInCare() %>" />
<impact:validateInput type="hidden" name="hdnIndUnSubstantiatedMIC" value="<%= cinv46so.getCIndUnsubMIC()%>" />

<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Allegation Detail</th>
  </tr>
  <tr>
    <td><impact:validateDate type="text" size="10" disabled="false" disabled="<%= Sets.isInSetStr( Sets.E , request )%>"  required="false" value="<%=dtDtAllegedIncident%>" name="dtDtAllegedIncident" tabIndex="<%= tabIndex++ %>" label="Date of Alleged Incident" constraint="Date" /></td>
    <td></td><td></td>
  </tr>
  
    <tr>
    <td><impact:validateSelect label="Alleged Maltreated Child" required="<%= String.valueOf( bMulti ) %>" name="selUlIdVictim" tabIndex="<%=tabIndex++%>" options="<%= victimListOptions %>" disabled="<%= Sets.isInSetStr( Sets.C + Sets.E , request )%>" value="<%= ulIdVictim%>" blankValue="true"/></td>
    <td><impact:validateDisplayOnlyField name="dspSzCdAllegStage" label="Stage" value="<%= txtSzCdAllegStage%>" /></td>
    <td></td><td></td>
  </tr>
  <%//STGAP00015366:Alleged Maltreator Relationship is not displayed once the disposition is entered 
   boolean doNotHideRelationship = !StringHelper.isValid(cinv46so.getCdAllegDisposition());
   String a = (String)request.getAttribute("doNotHideRalationship");
   if(request.getAttribute("doNotHideRalationship") !=  null && StringHelper.isTrue((String)request.getAttribute("doNotHideRalationship"))){
     doNotHideRelationship = true;
   }
   if(doNotHideRelationship){ %>
  <tr>
    <td><impact:validateSelect label="Alleged Maltreator Relationship" 
                  name="selSzCdMaltreatorRel"
                  tabIndex="<%=tabIndex++%>"
                  codesTable="<%= CodesTables.CRPTRINT %>"
                  excludeOptions="<%= excludeRelationship %>"
                  disabled="<%= bDisableMR %>"
                  blankValue="true"
                  required="true"
                  value="<%= cinv46so.getSzCdMaltreatorRel() %>"
                  valueType = "<%= SelectTag.CODES%>"
                  contentType = "<%= SelectTag.CODES_DECODES%>"/></td>
    <td></td><td></td><td></td>
  </tr>
  <%} %>
  <tr>
    <td><impact:validateSelect label="Maltreatment Type" 
                  required="<%= String.valueOf( bMulti ) %>"
                  name="selSzCdAllegType"
                  tabIndex="<%=tabIndex++%>"
                  codesTable="<%= CodesTables.CABALTYP %>"
                  excludeOptions="<%= exOptionsAlleg %>"
                  disabled="<%= Sets.isInSetStr( Sets.C + Sets.E , request )%>" value="<%= allegationType %>"
                  blankValue="true"
                  onChange="filterMaltreatmentCode();"/></td>
    <td></td><td></td><td></td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Maltreatment Code" 
                  required="<%= String.valueOf( bMulti ) %>"
                  contentType = "<%= SelectTag.CODES_DECODES%>"
                  name="selSzCdAllegMalCode"
                  tabIndex="<%=tabIndex++%>"
                  codesTable="<%= CodesTables.CMALCODE %>"
                  blankValue="true"
                  required="true"
                  value="<%= cdAllegMalCode %>"
                  valueType = "<%= SelectTag.CODES%>"
                  disabled="<%= Sets.isInSetStr( Sets.C + Sets.E , request )%>"/></td>
    <td></td><td></td><td></td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Where did the Maltreatment Occur?" 
                               required="true" 
                               name="szCdAllegedMalLocation" tabIndex="<%=tabIndex++%>" 
                               onChange="setAnchor()"
                               tabIndex="<%= tabIndex++ %>"
                               orderBy="<%= SelectTag.DECODE_ORDERBY %>"
                               codesTable="<%= CodesTables.CLOCMALT %>" 
                               value="<%=szCdAllegedMalLocation%>"/>
    &nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "setIsDirtyCalled(true);displayODISPolicy()">?</a></strong></td>
  </tr>
  <tr>
     <td>Evidence Description:</td>
      <td>
      <impact:codesCheckbox name="cbxEvidenceCode"
       defaultCodes="<%= checkedValues %>" 
       codesTableName="<%=CodesTables.CEVDCD %>"
       columns="2" isRuled="false" tabIndex="<%= tabIndex++ %>"
       disabled="<%= String.valueOf( EditableMode.isCompatibleWith(pageMode, EditableMode.VIEW) ) %>"
       isHorizontal="false" />
       </td>
       <td></td><td></td>
  </tr>
  <tr>
    <td>
      <impact:validateTextArea name="txtEvidenceSummary"
            label="Evidence Summary"
            maxLength="300"
            conditionallyRequired="true"
            rows="3" cols="100" tabIndex="<%= tabIndex++ %>" constraint="Comments" > <%=txtEvidenceSummary%>
	 </impact:validateTextArea>
    </td>
    <td></td><td></td><td></td>
  </tr>
  <%
  	  String indCrimChrgsFiled_yes = "false";
      String indCrimChrgsFiled_no = "false";
      String rb_indCrimChrgsFiled = cinv46so.getIndCrimChrgsFiled();
      if("Y".equals(rb_indCrimChrgsFiled)){
        indCrimChrgsFiled_yes = "true";
      }
      else if("N".equals(rb_indCrimChrgsFiled)){
        indCrimChrgsFiled_no = "true";
      }
      %>
  <tr>
    <td>Were criminal charges filed?
      <impact:validateInput type="radio" label="Yes" name="indCrimChrgsFiled"  value="Y" cssClass="formInput" checked="<%=indCrimChrgsFiled_yes%>" tabIndex="<%= tabIndex++ %>"/>
      <impact:validateInput type="radio"  label="No" name="indCrimChrgsFiled"  value="N" cssClass="formInput" checked="<%=indCrimChrgsFiled_no%>" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>  
  
  <tr>
    <td><impact:validateSelect label="Disposition" name="selCdAllegDisposition" tabIndex="<%=tabIndex++%>" codesTable="<%= strDispCodesTable %>" excludeOptions="<%= exOptions %>" value="<%= cinv46so.getCdAllegDisposition()%>"/></td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Severity" name="selSzCdAllegSeverity" conditionallyRequired="true" tabIndex="<%=tabIndex++%>" codesTable="CSEVERTY" value="<%= cinv46so.getSzCdAllegSeverity()%>"/></td>
  </tr>
    <%
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
      %>
  <%--Adding code for CAPTA Starts here--%>      
  <tr>
    <td colspan=2><span class="formCondRequiredText">&#135;</span>If Severity is Child Death, is this death the direct result of a maltreatment sustained as a Near Fatality:
      <impact:validateInput type="radio" label="Yes" name="indSevChildDeath"  value="Y" cssClass="formInput" checked="<%=indSevChildDeath_yes%>" tabIndex="<%= tabIndex++ %>"/>
      <impact:validateInput type="radio"  label="No" name="indSevChildDeath"  value="N" cssClass="formInput" checked="<%=indSevChildDeath_no%>" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td><impact:validateDate type="text" size="10" 
    						 disabled="false" 
    						 conditionallyRequired="true" 
    						 value="<%=dtPriorNearFatalMaltrtmnt%>" 
    						 name="dtPriorNearFatalMaltrtmnt" 
    						 tabIndex="<%= tabIndex++ %>" 
    						 label="Date of Prior Near Fatality Maltreatment" 
    						 constraint="Date" />
    </td>
  </tr>
  <%--Adding code for CAPTA Ends here--%>      
</table>
<%--Include buttons for performing actions on the page--%>
<%
boolean bDisableDelete = CodesTables.CSTAGES_ARI.equals(GlobalData.getSzCdStage(request)) ? true : false;
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
      <impact:ButtonTag name="btnDelete" img="btnDelete" function="return deleteConfirm();" form="frmAllgtnDetail" action="/investigation/Allegation/deleteAllgtn" disabled="<%= Boolean.toString( Sets.isInSet( Sets.B + Sets.D + Sets.E , request ) || bDisableDelete ) %>" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td class="alignRight">
      <impact:ifMobileImpact>
      <impact:ButtonTag name="btnSaveAndStay" img="btnSaveAndStay" function="return saveConfirm();" form="frmAllgtnDetail" action="/investigation/Allegation/saveAllgtn" disabled="<%= Sets.isInSetStr( Sets.A + Sets.C + Sets.D + Sets.E , request )%>" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
      </impact:ifMobileImpact>
      <impact:ButtonTag name="btnSave" img="btnSave" function="return saveConfirm();" form="frmAllgtnDetail" action="/investigation/Allegation/saveAllgtn" disabled="<%= Sets.isInSetStr( Sets.D + Sets.E , request )%>" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
      <!-- impact:ifMobileImpact -->
      <impact:ButtonTag name="btnSaveMulti" function="return saveConfirm();" align="right" img="btnSave" form="frmAllgtnDetail" action="/investigation/Allegation/saveAllgtnMulti" disabled="<%= Sets.isInSetStr( Sets.A + Sets.B + Sets.C + Sets.D , request )%>" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
      <!--  /impact:ifMobileImpact -->
    </td>
  </tr>
</table>
<!--- End Detail Table --->
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

<%-- filterMaltreatmentCode() --%>
<script type="text/javascript" language="JavaScript1.2">
   
   //filterMaltreatmentCode();
   //resetAllegMalCode(); 
   
var saveClicked;
var saveMultiClicked;
window.onload = function ()
{
  setAnchor();
  <%
  String previousURL = (String) request.getParameter("FormValidationPrevUrl");
  if ("Y".equals(warnMaltreatmentInCare) && (!"/investigation/Allegation/displayAllgtnList".equals(previousURL))) {
  %>
    document.frmAllgtnDetail.hdnIndMaltreatInCare.value = '<%= indMaltreatInCare %>';
    document.frmAllgtnDetail.hdnIndUnSubstantiatedMIC.value = '<%= indUnSubstantiatedMIC %>';
    saveClicked = '<%= StringHelper.isValid(request.getParameter("btnSave" + ".x"))%>';
    saveMultiClicked = '<%= StringHelper.isValid(request.getParameter("btnSaveMulti" + ".x"))%>';
    if ('true' == saveClicked || 'true' == saveMultiClicked){
    confirmMaltreatmentInCare();
    }
  <%
  }
  %>
}   
</script>
</impact:validateForm>
<%
}
%>