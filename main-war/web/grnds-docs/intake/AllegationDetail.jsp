<%
//*  JSP Name:    Intake Allegation Detail JSP
//*  Created by:   Jenn Casdorph
//*  Date Created: 02/11/2003
//*
//*  Description:
//*  Allegation Detail - The user will enter allegations
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  03/29/04  resertg           SIR 22616 -- Grabbed Classification from state,
                              added items to Exclude array as necessary.
  03/30/04  resertg           Added comparison of Classification to Empty_String
                              and null.
  07/12/04  ochumd            Sir 22934 -- Replaced cint19d with cint76d.
  05/09/05  nallavs           Sir 23547 -- Removed System.out.println
  08/09/08  arege			  STGAP00005876  In Modify mode Called the function filterMaltreatmentCode()
                              to filter the MaltreatmentCode values according to the MaltreatmentType 
                              that was previously saved.
  09/08/2009  bgehlot         STGAP00015366:Removed the Alleged Maltreator and changed the label for Maltreator Relationship 
  09/17/2009  bgehlot         STGAP00015386: If INT stage is closed the Ralationship field on Allegation
                              Detail is not displayed.
  05/26/2010  hjbaptiste      SMS#51977-MR66-Maltreatment In Care: Added additional field to indicate that Maltreatment took
                              place while the child was/is in DFCS custody. Allow user to open popup html for help. User has
                              to confirm maltreatment in care
  07/08/2010  hjbaptiste      SMS#61470: MR66-Maltreatment In Care - Remapped the location of maltreatments to the DFCS Facility 
                              description pop-up anchors      
  07/11/2011  arege           SMS#114232: CAPTA 4.3 - Allegation Detail/Allegation Detail (Intake) - Relationship Drop-Down Not Wide Enough
                              Removed style="width:150px" attribute from the field Alleged Maltreatment Relationship                        
*/

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile, java.util.List, java.util.ArrayList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeActionsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINT76DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%
{
  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  // SIR 22616  Create and Exclude if the Classification type is Child Care
  // Licensing (LCC) or Residential Licensing (LRC)
  List excludeAlleg = new ArrayList();
  String Classification = (String)state.getAttribute("selSzCdStageClassification", request);

  if (!Classification.equals(CodesTables.CCLASS_LRC) &&
      !Classification.equals(CodesTables.CCLASS_LCC) &&
      !Classification.equals(StringHelper.EMPTY_STRING) &&
      !Classification.equals(null) )
  {
    excludeAlleg.add(CodesTables.CABALTYP_EXPC); // Hide Explotation (Lic Only)
  }

  int tabIndex = 1;
  int loopCount = 0;
  Date tempDate = new Date();
  
  String widgetRefresh = (String) request
  						.getAttribute(ServerSideValidationUtility.REFRESH_WIDGETS_FROM_REQUEST);
  				widgetRefresh = widgetRefresh == null ? "false"
						: widgetRefresh;
						
  String pageMode = PageMode.getPageMode(request);

  String warnMaltreatmentInCare = (String) state.getAttribute("warnMaltreatmentInCare", request);
  String indMaltreatInCare = (String) state.getAttribute("indMaltreatInCare", request);
  ROWCINT76DO allegListRow = (ROWCINT76DO) request.getAttribute("allegListRow");
if (allegListRow == null)
  {
    allegListRow = new ROWCINT76DO();
  }

// ochumd - sir 22934 get the sel value id and name
String victSel= allegListRow.getSzScrPersVictim()  + "|" + String.valueOf(allegListRow.getUlIdVictim());

  List allegedVictimVector = (List)state.getAttribute("allegedVictimVector", request);
  if (allegedVictimVector == null)
  {
    allegedVictimVector = new ArrayList();
  }

  // If this is a new allegation and there is only one row in the Alleged Victim Vector,
  // the Alleged Victim field should prefill.
  if ((allegListRow.getUlIdAllegation() == 0) &&
      (allegedVictimVector.size() == 1))
  {
    Option op = (Option)allegedVictimVector.get(0);
 /**   int i = 0;
    try
    {

      i = Integer.parseInt(op.getCode());
    }
    catch (Exception e)
    {
      i = 0;
    }*/
    //allegListRow.setUlIdVictim(i);
     victSel = op.getCode();
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

%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

function confirmMaltreatmentInCare()
{ 
    if ('true' == saveAndAddButtonClicked || 'true' == saveAndContClicked) { 
      if(confirm('<%=MessageLookup.getMessageByNumber( Messages.MSG_ALLEG_DT_MALTREAT_IN_CARE )%>' ) )
      {
        document.frmAllegationDetail.hdnIndIncmgMaltreatInCare.value = 'Y';
        document.frmAllegationDetail.hdnUpdateMaltreatInCare.value = 'Y';
        if ('true' == saveAndAddButtonClicked) {
          submitValidateForm('frmAllegationDetail', '/intake/IntakeActions/saveAndAddAllegation');
        } else if ('true' == saveAndContClicked) {
          submitValidateForm('frmAllegationDetail', '/intake/IntakeActions/saveAndContinueAllegation');
        }
      }
    }
}

function deleteAllegationConfirm()
{
  return confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
}

  //Assign the corrective action codes table CMALCODE to the static variable maltreatmentCodeCodesTable
<impact:codeArray codeName="<%= CodesTables.CMALCODE %>" arrayName="<%= CodesTables.CMALCODE %>" blankValue="true"/>
<impact:codeArray codeName="<%= CodesTables.CABALTYP %>" arrayName="<%= CodesTables.CABALTYP %>" blankValue="true"/>

 function resetAllegMalCode()
 {
   if ( document.frmAllegationDetail.selSzCdIntakeAllegType.value != null)
   {
     var malCode = document.frmAllegationDetail.selSzCdIntakeAllegType.value;
     
     if ( document.frmAllegationDetail.maltreatmentType.value != "" )
     {
       malCode = document.frmAllegationDetail.maltreatmentType.value;
     }
       
     var codeArray1 = <%= CodesTables.CMALCODE %>;       
     var codeArray2 = <%= CodesTables.CABALTYP %>;
     
     for (var q=0; q < codeArray1.length; q++)
     {
      var code = codeArray1[q].substring(0,codeArray1[q].indexOf("|"));
      var decode = codeArray1[q].substring( codeArray1[q].indexOf("|")+1, codeArray1[q].length);
         if ( code ==  malCode )
          {
            document.frmAllegationDetail.selSzCdIntakeAllegMalCode.value = code;
            
           
          }
     } 
          
     //populateDropdown( frmAllegationDetail.selSzCdIntakeAllegType , "", <%= CodesTables.CABALTYP %> );
     populateDropdownDecode(frmAllegationDetail.selSzCdIntakeAllegType, <%= request.getParameter("selSzCdIntakeAllegType")%> ,  <%= CodesTables.CABALTYP %>, true);
          
     for (var q=0; q < codeArray2.length; q++)
     {
      var code = codeArray2[q].substring(0,codeArray2[q].indexOf("|"));
      var decode = codeArray2[q].substring( codeArray2[q].indexOf("|")+1, codeArray2[q].length);
         if ( code.a( 0, 1 ) ==  malCode.substring( 0, 1 ) )
          {
            document.frmAllegationDetail.selSzCdIntakeAllegType.value = code;
           
          }
      }
    }  
 } 

 function filterMaltreatmentCode()
 {  
 
   var maltreatmentTypeFilter = document.frmAllegationDetail.selSzCdIntakeAllegType.value;
   
   if ( maltreatmentTypeFilter == "" )
   {
      clearDropdown( frmAllegationDetail.selSzCdAllegMalCode );
   }
   else
    {
     //populateDropdown( frmAllegationDetail.selSzCdIntakeAllegMalCode , "", <%= CodesTables.CMALCODE %> );
       
       populateDropdownDecode(frmAllegationDetail.selSzCdIntakeAllegMalCode, "" ,  <%= CodesTables.CMALCODE %>, true);     
       
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
            document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options[count].value = code;
            document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options[count].text  = code+ " " +decode;
            //document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options[count].value=codeArray[q];
            count++;
          }
     }
         document.frmAllegationDetail.selSzCdIntakeAllegMalCode.options.length = count;
         
    }
    
 }
 
 function setUpdateMaltreatInCare() {
   document.frmAllegationDetail.hdnUpdateMaltreatInCare.value = 'N';
   return true;
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
  if (document.frmAllegationDetail.hdnLocationAnchor.value != "") {
    return window.open('/intake/IntakeActions/displayLocOfMalHelp'+'#'+document.frmAllegationDetail.hdnLocationAnchor.value, "DFCS_FACILITY_DESC", descriptor);
  }
 }
 
 function setAnchor() {
   var anchorPoint = "";
   var malLocation = document.frmAllegationDetail.selSzCdAllegedMalLocation.value;
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
   } else{
   	 anchorPoint = 'dfcsHomes';
   }
   document.frmAllegationDetail.hdnLocationAnchor.value = anchorPoint;
 }
 <%
// STGAP00005876 : 
// If we are in Modify mode,  onload of the Page should call the filterMaltreatmentCode()
// to filter the MaltreatmentCode values according to the MaltreatmentType 
// that was previously saved.
  if (pageMode.equals(PageModeConstants.MODIFY))
{
 
%>
   window.onload = function ()
{
var maltreatmentCode = document.frmAllegationDetail.selSzCdIntakeAllegMalCode.value;
filterMaltreatmentCode();
frmAllegationDetail.selSzCdIntakeAllegMalCode.value = maltreatmentCode;
}   
<%
}
%>
 
</script>

<% if (!"Y".equals(warnMaltreatmentInCare)) { %>
<impact:validateErrors/>
<%} %>

<impact:validateForm name="frmAllegationDetail"
        method="post"
        action="/intake/IntakeActions/displayAllegationDetail"
        pageMode="<%= pageMode %>"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.intake.AllegationDetailCustomValidation"
        schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="hdnCTxtIntakeAllegDuration" value="<%= FormattingHelper.formatString( allegListRow.getCTxtIntakeAllegDuration() )%>" />
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= FormattingHelper.formatDate( allegListRow.getTsLastUpdate() ) %>" />
<impact:validateInput type="hidden" name="hdnUlIdAllegation" value="<%= String.valueOf( allegListRow.getUlIdAllegation() ) %>" />
<impact:validateInput type="hidden" name="hdnUpdateMaltreatInCare" value="" />
<impact:validateInput type="hidden" name="hdnLocationAnchor" value="" />
<impact:validateInput type="hidden" name="hdnIndIncmgMaltreatInCare" value="<%= allegListRow.getCIndIncmgMaltreatInCare() %>" />

<%/* The hidden value incomingStatus is used on the Allegation Detail page.  If the user enters the intake
     in approval mode and they are NOT the approver, if the user saves the Allegation Detail page, we should
     invalidate the pending approval.  The allegation_AUD() method uses the value for hdnIncomingStatus
     to determine whether we should invalidate the pending approval or not.  This value is passed from
     a hidden field on the Intake Actions page. */%>
<impact:validateInput type="hidden" name="hdnIncomingStatus" value='<%= request.getParameter("hdnIncomingStatus") %>'/>
<%
//*******************************************************************************
//******************************** ALLEGATION  DETAIL ***************************
//*******************************************************************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr class="subDetail">
    <th colspan="4">Allegation Detail</th>
  </tr>
  <tr class="subDetail">
    <td width="23%"><impact:validateSelect
                               style="width:150px"
                               label="Alleged Maltreated Child"
                               name="selUlIdVictim"
                               overrideDisplayBadCodes="true"
                               required="true"
                               value="<%= victSel %>"
                               tabIndex="<%= tabIndex++ %>"
                               options="<%=allegedVictimVector%>"/>
     </td>
    <td><impact:validateDate label="&nbsp;&nbsp;&nbsp;&nbsp;Date of Alleged Incident"
                                   name="selDtDtAllegedIncident"
                                   value="<%= FormattingHelper.formatDate(allegListRow.getDtDtAllegedIncident()) %>"
                                   type="text"
                                   constraint="Date"
                                   size="10"
                                   tabIndex="<%= tabIndex++ %>"/>
   </td>
                              <%--  --%>
  </tr>
  <tr class="subDetail">
<% /* SIR 22616 -- Added ExcludeOptions */ %>
    <td width="23%"><impact:validateSelect style="width:180px"
                               excludeOptions="<%= excludeAlleg %>"
                               label="Maltreatment Type"
                               name="selSzCdIntakeAllegType"
                               required="true"
                               value="<%= allegListRow.getSzCdIntakeAllegType() %>"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CABALTYP %>"
                               contentType = "<%= SelectTag.CODES_DECODES%>"
                               onChange="filterMaltreatmentCode();"/>
   </td>                                   
    <td><impact:validateSelect style="width:220px"
                               label="Maltreatment Code"
                               name="selSzCdIntakeAllegMalCode"
                               blankValue="true"
                               required="true"
                               contentType = "<%= SelectTag.CODES_DECODES%>"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CMALCODE %>"
                               value="<%= allegListRow.getSzCdIntakeAllegMalCode()%>"/>
   </td>
                          <%-- value="<%= allegListRow.getSzCdIntakeAllegMalCode() %>" --%>
  </tr>
  <%boolean hideRelationship = false;
  if(request.getAttribute("INTStageClosed") !=  null && StringHelper.isTrue((String)request.getAttribute("INTStageClosed"))){
     hideRelationship = true;
   }
   %>
  <tr class="subDetail">
  <%if(!hideRelationship){  %>
    <td width="23%"><impact:validateSelect 
                               excludeOptions="<%= excludeRelationship %>"
                               label="&nbsp;&nbsp;&nbsp;&nbsp;Alleged Maltreator Relationship"
                               name="selSzCdMaltreatorRel"
                               value="<%= allegListRow.getSzCdMaltreatorRel() %>"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CRPTRINT %>"
                               contentType = "<%= SelectTag.CODES_DECODES%>"/>
   </td>
   <td colspan="2">&nbsp;</td>
   <%} %>
   </tr>
   <tr class="subDetail">
   <td colspan="4">
   <table border="0" cellpadding="1" cellspacing="0" width="100%">
     <tr>
       <td width="23%"><impact:validateSelect
                               label="Where did the Maltreatment occur?"
                               name="selSzCdAllegedMalLocation"
                               required="true"
                               value="<%= allegListRow.getSzCdAllegedMalLocation() %>"
                               onChange="setAnchor()"
                               tabIndex="<%= tabIndex++ %>"
                               orderBy="<%= SelectTag.DECODE_ORDERBY %>"
                               codesTable="<%= CodesTables.CLOCMAL %>"/>
                               
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="#" onClick = "displayODISPolicy()">?</a></strong>                               
      </td>                            
    </tr>
  </table>
  </td>
</tr>
</table>
                        
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
<%
String newAlleg = "false";
if (allegListRow.getUlIdAllegation() == 0)
{
  newAlleg = "true";
}
%>
    <td width="85%">
      <impact:ButtonTag name="btnDeleteFromDetail"
                               img="btnDelete"
                               align="left"
                               form="frmAllegationDetail"
                               action="/intake/IntakeActions/deleteAllegationFromDetail"
                               function="return deleteAllegationConfirm();"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= newAlleg %>"
                               restrictRepost="true"/>
    </td>
    <td width="5%">
      <impact:ButtonTag name="btnAdd"
                               img="btnAdd"
                               align="left"
                               form="frmAllegationDetail"
                               action="/intake/IntakeActions/saveAndAddAllegation"
                               function="return setUpdateMaltreatInCare();"
                               tabIndex="<%= tabIndex++ %>"
                               restrictRepost="true"/>
    </td>
    <td width="10%">
      <impact:ButtonTag name="btnContinue"
                               img="btnContinue"
                               align="left"
                               form="frmAllegationDetail"
                               action="/intake/IntakeActions/saveAndContinueAllegation"
                               function="return setUpdateMaltreatInCare();"
                               tabIndex="<%= tabIndex++ %>"
                               restrictRepost="false"/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">

<input type="hidden" name="maltreatmentType" value="<%= allegListRow.getSzCdIntakeAllegType() %>">

<%-- filterMaltreatmentCode() --%>
<script type="text/javascript" language="JavaScript1.2">
   
   //filterMaltreatmentCode();
   //resetAllegMalCode(); 
var saveAndAddButtonClicked;
var saveAndContClicked;
window.onload = function ()
{
  setAnchor();
  <%
  String previousURL = (String) request.getParameter("FormValidationPrevUrl");
  if ("Y".equals(warnMaltreatmentInCare) && (!"/intake/IntakeActions/displayIntakeActions".equals(previousURL))) {
  %>
    document.frmAllegationDetail.hdnIndIncmgMaltreatInCare.value = '<%= indMaltreatInCare %>';
    saveAndAddButtonClicked = '<%= StringHelper.isValid(request.getParameter("btnAdd" + ".x"))%>';
    saveAndContClicked = '<%= StringHelper.isValid(request.getParameter("btnContinue" + ".x"))%>';
    confirmMaltreatmentInCare();
  <%
  }
  %>
}
</script>

</impact:validateForm>

<%
}
%>




