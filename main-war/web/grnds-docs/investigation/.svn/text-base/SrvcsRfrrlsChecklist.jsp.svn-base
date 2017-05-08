<%
//*-----------------------------------------------------------------------------
//*  JSP Name:     SrvcRfrrlsChecklist
//*  Created by:   Merle A. Demo
//*  Date Created: 12/01/2002
//*
//*  Description:  This page captures the Referrals/Services provided by workers
//*                to their clients.  It is a requirement to complete this page
//*                prior to saving and submitting an investigation.  This page
//*                is accessible from the Navigation Metaphor, event list, Case
//*                ToDo list and Staff ToDo list. This page uses servers
//*                cinv54s.src and cinv55s.src to get and save data
//*
/* Change History:
  Date      User           Description
  --------  -------------  -----------------------------------------------------
  12/01/02  Merle A. Demo  Page created

  06/09/03  GRIMSHAN       SIR 16979 get pagemode from page mode instead of app
                           mode.

  06/09/03  Todd Reser     SIR 18140 Grabbed Parameter from Request so when
                           errors occur cbxIndSvcRefChklstNoRef stays checked

  07/21/03  CASDORJM       SIR 18904 - Removed duplicate javaScript function
                           disableServices1() and removed fix for SIR 18140. In
                           order to remove the duplicate javaScript function I
                           modified disableServices() to accept a parameter which
                           is used to determine whether the comments should be
                           cleared or not.  Also, the value of the checkbox was
                           getting set to whatever was retrieved from the database.
                           This meant that if we retrieved "N" (not checked) from
                           the database, then checked the checkbox, the value
                           submitted to the request was "N".  Since the fix for
                           18140 used whatever was in the request, this was causing
                           our main problem with the checkbox not staying checked.
                           Also removed editableMode from the checkbox tag.  When
                           the page loads in NEW mode, it was disabling the 'No
                           Services/Referrals' checkbox.
  07/02/04  RIOSJA         SIR 16114 - Do not display the Family's Response
                           section for any of the family stages.
  07/02/04  MCHILLMAN      STGAP00011649 - resrict Family's Response section display
*/
//*-----------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
/*
Import xmlstructs used on the page. Xmlstructs hold the input and output data
for Tuxedo service calls.  Xml output structs corresponding to the services
called to retrieve data for this page should be used on this page and therefore
imported here
*/
%>
<%@ page import="java.util.ArrayList,java.util.Date,java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY"%>
<%/* Import needed for Messages */ %>
<%/* Import needed for Form Launch */ %>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  // SIR 16979 Get page mode from page mode instead of app mode
  String pageMode = "";
  pageMode = PageMode.getPageMode( request );

  //Initialize all display variables for the page
   int tabIndex = 1;
   int nbrUlIdEvent;
   int nbrUlIdStage;
   Date dateLastUpdate = null;
   String familyResponse = "";
   String one = "1";
   String two = "2";
   String three = "3";
   String comments = "";
   String dtDtFirstReferral = "";

  CINV54SO cinv54so = (CINV54SO) state.getAttribute("CINV54SO",request);
  List checkedValues = (List) state.getAttribute("checkedValues",request);

  ROWCINV54SOG00 infoSrvcRfrrl = null;
  ROWCINV54SOG01_ARRAY servicesArray = null;

  if ( cinv54so == null ) { cinv54so = new CINV54SO(); }

  if ( cinv54so.getROWCINV54SOG01_ARRAY() != null )
  {
    servicesArray = cinv54so.getROWCINV54SOG01_ARRAY();
  }
  else
  {
    servicesArray = new ROWCINV54SOG01_ARRAY();
  }

  if ( checkedValues == null ) { checkedValues = new ArrayList(); }

  String indSvcRefChklstNoRef = "Y";

  if ( !cinv54so.getROWCINV54SOG00().equals(null) )
  {
    infoSrvcRfrrl = cinv54so.getROWCINV54SOG00();
    indSvcRefChklstNoRef = infoSrvcRfrrl.getCIndSvcRefChklstNoRef();
  }
  else
  {
    infoSrvcRfrrl = new ROWCINV54SOG00();
  }

   if( !"".equals(infoSrvcRfrrl.getSzCdFamilyResponse()) )
   {
      familyResponse = infoSrvcRfrrl.getSzCdFamilyResponse();
      if (familyResponse == null) 
      {
        familyResponse = "";
      }
   }

   dtDtFirstReferral = FormattingHelper.formatDate(infoSrvcRfrrl.getDtDtFirstReferral());

   //  Start the Comments section
   if( infoSrvcRfrrl.getSzTxtChklstComments() != null )
   {
     comments = infoSrvcRfrrl.getSzTxtChklstComments();
    }
  int loopCount = 0;
  //  Start the hidden fields loading
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="JavaScript1.2">


  // The following javaScript function is called every time the page loads.
  // It is necessary to cycle through all the Services, Referrals, and Family
  // Responses and clear and disable them if the "No Services/Referrals" checkbox
  // has been selected.
  window.attachEvent('onload', myOnloadFunction );
  function myOnloadFunction()
  {
   //If no services/referrals checkbox is checked, disable all other fields.
   if ( document.frmSrvcsRfrrlsChecklist.cbxIndSvcRefChklstNoRef.checked == true )
   {
     disableServices( false );
   }
  }


  // This javaScript function is called onLoad of the page and also any time
  // the user changes the value of the "No Service/Referrals" checkbox.  If
  // the user checks the checkbox, all other fields are cleared and disabled.
  // If the user is unchecking the checkbox, the other fields are enabled.
  // If this function is called onLoad of the page, we do not want to clear the
  // comments and will pass false in to the function.  If this is onChange of
  // the checkbox, the comments should be cleared and we pass in true.
  function disableServices( clearComments )
  {
    var cbxValue = "";
    var txtD = "D";

    txtComments = eval("document.frmSrvcsRfrrlsChecklist.txtChklstComments");
    dtFirstReferred = eval("document.frmSrvcsRfrrlsChecklist.dtDtFirstReferral");

    if ( clearComments )
    {
      txtComments.value = "";
    }

    // If the user has checked the checkbox, clear and disable the date,
    // the family responses, and the Services/Referrals.
    if(document.frmSrvcsRfrrlsChecklist.cbxIndSvcRefChklstNoRef.checked)
    {
      dtFirstReferred.value = ""
      dtFirstReferred.disabled = true;

      document.frmSrvcsRfrrlsChecklist.dtDtFirstReferral.value = cbxValue;

      <%
      // RIOSJA, SIR 16114 - The Family's Response section is not displayed
      // on the page for any family stages, so do not clear and disable the
      // fields.
      if(!CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FRE.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FSU.equals( GlobalData.getSzCdStage( request ) ))
      {%>
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[0].checked = false;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[1].checked = false;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[2].checked = false;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[0].disabled = true;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[1].disabled = true;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[2].disabled = true;
      <%
      }
      %>

      // When we clear and disable the Services/Referrals Provided, we also have to
      // reset the _changed field.<%
      for(int n = 1; n <= (Lookup.getCategoryCollection( "CSRCKLST" )).size() ; n++ )
      {%>
        cbxServicesRefered = eval("document.frmSrvcsRfrrlsChecklist.cbxCIndSvcRefChklstNoRef" + "<%=n%>" + "_Id");
        cbxServiceReferedChanged = eval("document.frmSrvcsRfrrlsChecklist.cbxCIndSvcRefChklstNoRef" + "<%=n%>" + "_changed");
        cbxValue = eval("cbxServiceReferedChanged.value");
        if (cbxValue.charAt(cbxValue.length-4) == "Y")
        {
          cbxServiceReferedChanged.value = txtD.concat(cbxValue.slice(1,5));
        }
        if(cbxServicesRefered.checked)
        {
          cbxServicesRefered.checked = false;
        }
        cbxServicesRefered.disabled = true;
      <%
      }
      %>
    }
    // When the user unchecks the "No Services/Referrals" Checkbox, we want to
    // enable the date, Family Responses and Services/Referrals Provided.
    else if(!document.frmSrvcsRfrrlsChecklist.cbxIndSvcRefChklstNoRef.checked)
    {
      dtFirstReferred.disabled = false;

      <%
      // RIOSJA, SIR 16114 - The Family's Response section is not displayed
      // on the page for any family stages, so do not clear and disable the
      // fields.
      if(!CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FRE.equals( GlobalData.getSzCdStage( request ) ) &&
         !CodesTables.CSTAGES_FSU.equals( GlobalData.getSzCdStage( request ) ))
      {%>
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[0].disabled = false;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[1].disabled = false;
        document.frmSrvcsRfrrlsChecklist.rbCdFamilyResponse[2].disabled = false;
      <%
      }
      %>
      <%
      for(int n = 1; n <= (Lookup.getCategoryCollection( "CSRCKLST" )).size() ; n++ )
      {%>
        cbxServicesRefered = eval("document.frmSrvcsRfrrlsChecklist.cbxCIndSvcRefChklstNoRef" + "<%=n%>" + "_Id");
        cbxServicesRefered.disabled = false;
      <%
      }
      %>
    }
  }

window.attachEvent( 'onbeforeunload', IsDirty );
</script>
<impact:validateErrors formName="frmSrvcsRfrrlsChecklist"/>
<impact:validateForm name="frmSrvcsRfrrlsChecklist"
   method="post"
   action="/investigation/SrvcsRfrrlsChecklist/saveSrvcsRfrrlsChecklist"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.SrvcsRfrrlsChecklistCustomValidation"
   pageMode="<%=pageMode%>"
   schema="/WEB-INF/Constraints.xsd">

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
<!--    Start of Services and Referrals section      -->
  <tr>
    <th colspan="3">Services and Referrals</th>
  </tr>
   <tr>
     <td width="25%">
       <impact:validateDate
         label="Date of First Service/Referral"
         name="dtDtFirstReferral"
         value="<%=dtDtFirstReferral%>"
         conditionallyRequired="true"
         constraint="Date"
         width="25%"
         tabIndex="<%= tabIndex++ %>"/>
     </td>
     <td  width="50%">
       <impact:validateInput
         label="No Services/Referrals"
         name="cbxIndSvcRefChklstNoRef"
         onClick="disableServices( true )"
         tabIndex="<%= tabIndex++ %>"
         value="Y"
         checked="<%= indSvcRefChklstNoRef %>"
         type="checkbox"
         cssClass="formInput" />
      </td>
  </tr>
</table>
<!--    End of Services and Referrals section      -->
<br>
<!---------------------------------------------------------------------------------------->
<!--    Start of Services/Referrals Provided section THE ARRAY     -->
<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
  <tr>
     <th>Services and Referrals Provided</th>
  </tr>

  <tr>
     <td>
      <impact:codesCheckbox name="cbxCIndSvcRefChklstNoRef"
       defaultCodes="<%= checkedValues %>" codesTableName="CSRCKLST"
       columns="2" isRuled="false" tabIndex="<%= tabIndex++ %>"
       disabled="<%= String.valueOf( EditableMode.isCompatibleWith(pageMode, EditableMode.VIEW) ) %>"
       isHorizontal="false" />
     </td>
  </tr>
</table>
<!--  End of Services/Referrals The checkbox area for services provided    -->
<br>
<!--    Start of Family's Response section      -->
<%
// RIOSJA, SIR 16114 - Do not display the Family's Response section
// for any of the family stages.
// STGAP00011649 should not be avaiable for ADO or PAD stages
if ( !CodesTables.CSTAGES_FPR.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_FRE.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_FSU.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_ADO.equals( GlobalData.getSzCdStage( request ) ) &&
     !CodesTables.CSTAGES_PAD.equals( GlobalData.getSzCdStage( request ) ))
{%>
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
    <tr>
      <th>Family's Response</th>
    </tr>
    <tr>
      <td>
        <impact:validateInput
                checked="<%= String.valueOf(familyResponse.equals(one)) %>"
                tabIndex="<%= tabIndex++ %>"
                value="<%= one %>"
                type="radio"
                name="rbCdFamilyResponse"
                label="At least one family member agreed to seek/accept one or more services/resources"
                conditionallyRequired="false"
                cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput
                checked="<%= String.valueOf(familyResponse.equals(two)) %>"
                tabIndex="<%= tabIndex++ %>"
                value="<%= two %>"
                type="radio"
                name="rbCdFamilyResponse"
                label="No family member agreed to seek or accept any of the services/resources offered"
                conditionallyRequired="false"
                cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput
                checked="<%=String.valueOf(familyResponse.equals(three))%>"
                tabIndex="<%= tabIndex++ %>"
                value="<%= three %>"
                type="radio"
                name="rbCdFamilyResponse"
                label="Other (explain in Comments)"
                conditionallyRequired="false"
                cssClass="formInput" />
      </td>
    </tr>
  </table>
  <br>
<%
}
%>
<!--    End of Family's Response section      -->
<!--    Start of COMMENTS     -->
<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
  <tr>
    <th colspan="2">Comments </th>
  </tr>
  <tr>
    <td width="14%" >
      <impact:validateTextArea name="txtChklstComments"
            label="Comments"
            maxLength="1000"
            conditionallyRequired="true"
            rows="3" cols="125" tabIndex="<%= tabIndex++ %>" constraint="Paragraph1000" > <%=comments%>
          </impact:validateTextArea>
    </td>
  </tr>
</table>
<!--    End of COMMENTS       -->
<hr>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignRight">
         <impact:ButtonTag name="btnSave" img="btnSave" align="right"
         form="frmSrvcsRfrrlsChecklist"
         action="/investigation/SrvcsRfrrlsChecklist/saveSrvcsRfrrlsChecklist"
         tabIndex="<%= tabIndex++ %>"/>
     </td>
   </tr>
</table>

<% /*  Always include this hidden field in your form */ %>
<impact:validateInput type="hidden" name="txtUlIdEvent" value="<%=String.valueOf(infoSrvcRfrrl.getUlIdEvent())%>"/>
<impact:validateInput type="hidden" name="txtUlIdStage" value="<%=String.valueOf(infoSrvcRfrrl.getUlIdStage()) %>"/>
<impact:validateInput type="hidden" name="txtUlIdCase" value="<%=String.valueOf(infoSrvcRfrrl.getUlIdCase()) %>"/>
<impact:validateInput type="hidden" name="txtUlIdCpsChecklist" value="<%=String.valueOf(infoSrvcRfrrl.getUlIdCpsChecklist()) %>"/>
<impact:validateInput type="hidden" name="txtdtDtCPSInvstDtlBegun" value="<%=FormattingHelper.formatDate(infoSrvcRfrrl.getDtDtCPSInvstDtlBegun())%>"/>
<impact:validateInput type="hidden" name="tsLastUpdate" value="<%=DateHelper.toISOString(infoSrvcRfrrl.getTsLastUpdate())%>"/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>

