<%
//*  JSP Name:     Home History Detail
//*  Created by:   Heather Dean
//*  Date Created: 1/3/03
//*
//*  Description:
//*   Displays and saves detail information for Home History rows.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  01/03/03  Heather Dean      Initial jsp creation
  04/22/03  Heather Dean      Post Code Review cleanup
  07/09/03  Todd Reser        SIR 18710 - Added call to CategoryChange() on load
                              so the appropriate widgets will be enabled or
                              disabled.  Added logic to CategoryChange to
                              Disable widgets in the Foster Home Type Section if
                              the category is "A" - Adoptive.  Added call to
                              onChange to selCategory widget.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.SortedMap" %>
<%@ page import="java.util.Set" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>

<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<!--Start Main Content-->
<% BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );%>

<impact:validateErrors />


<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="Javascript1.2">
  // Check for changes before navigating off
  window.onbeforeunload = function ()
{
  IsDirty();
};

function deleteRow()
{
 disableValidation( "frmHomeHistoryDetail" );
 bRetValue = confirm('<%= MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") %>')
 return bRetValue;
}

<%
// SIR 18710 - We have to disable and clear the widgets in the Foster Home
// Type Section if the category is "A" - Adoptive
%>
function categoryChange()
{
  var numOfTypes = <%= Lookup.getCategoryListingArray(CodesTables.CFAHMTYP ).length %>;
  var loopCount = 1;

  var isCategoryA = false;
  if (document.frmHomeHistoryDetail.selCategory != undefined)
  {
    isCategoryA = document.frmHomeHistoryDetail.selCategory.value == "<%= CodesTables.CFACATEG_A %>";
  }
  else if (document.frmHomeHistoryDetail.selCategory_Disabled != undefined)
  {
    isCategoryA = document.frmHomeHistoryDetail.selCategory_Disabled.value == "<%= CodesTables.CFACATEG_A %>";
  }

  while ( loopCount <= numOfTypes )
  {
    var cbxName = getCheckbox(loopCount);
    if ( cbxName != undefined )
    {
      if ( isCategoryA )
      {
        cbxName.disabled = true;
        cbxName.checked = false;
      }
      else
      {
        cbxName.disabled = false;
      }
    }
    loopCount++;
  }
}


function getCheckbox(loopCount)
{
  if (document.frmHomeHistoryDetail.famTypes1 != undefined)
  {
    return eval( 'document.frmHomeHistoryDetail.famTypes' + loopCount );
  }
  else if (document.frmHomeHistoryDetail.famTypes1_Disabled != undefined)
  {
    return eval( 'document.frmHomeHistoryDetail.famTypes' + loopCount + '_Disabled');
  }
  //if this happens, you'll get a javascript error
  return null;
}
</script>

<%
int tabIndex = 1;
boolean bHideSaveButton = false;
boolean bHideDeleteButton = false;
boolean bDisableAllFields = false;
org.exolab.castor.types.Date today = DateHelper.toCastorDate( new java.util.Date() );
String tsLastUpdate = null;
String pageMode = PageModeConstants.VIEW;
String isAdd = "";
ROWCFAD12SOG00 currentRow = new ROWCFAD12SOG00();
int intArrayIndex = ContextHelper.getIntSafe( request, "arrayIndex" );
int intResourceHistoryID = 0;
org.exolab.castor.types.Date nextStartDate = null;
org.exolab.castor.types.Date previousEndDate = null;
String reloadValue = (String) request.getAttribute( "isReload" );
boolean bIsReload = false;

// SPB SIR 19610: Do not set page mode to App Mode ( GlobalData.getAppMode( request ) )
// as this overwrites the logic in the conversation. Instead, get it from Page Mode:
  pageMode = PageMode.getPageMode( request );
%>
<script language="Javascript1.2">
  var pMode = <%= pageMode %>;
</script>
<%
if ( reloadValue != null )
{
  if ("true".equals(reloadValue) )
  {
    bIsReload = true;
  }
}


if ( request.getAttribute( "nextStartDate" ) != null )
{
  nextStartDate = (org.exolab.castor.types.Date) request.getAttribute( "nextStartDate" );
}
if ( request.getAttribute( "previousEndDate" ) != null )
{
  previousEndDate = (org.exolab.castor.types.Date) request.getAttribute( "previousEndDate" );
}

SortedMap years = (SortedMap) request.getAttribute( "years"  );
SortedMap months = (SortedMap) request.getAttribute( "months"  );
Collection yearOptions = new ArrayList();
Collection monthOptions = new ArrayList();

if ( years != null )
{
  yearOptions = years.values();
}

if ( months != null )
{
  monthOptions = months.values();
}

if ( request.getAttribute( "currentRow"  ) != null )
  {
   currentRow = (ROWCFAD12SOG00) request.getAttribute( "currentRow" );
   double d1 = currentRow.getUlIdResourceHistory();
   Double d = d1;
   intResourceHistoryID = d.intValue();
   if ( currentRow.getDtDtRshsEnd() == null )
   {
     bDisableAllFields = true;
     bHideDeleteButton = true;
     if ( !bIsReload )
     {%>
      <script language="Javascript1.2">
        alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_FAD_CURRENT_RECORD )%>' );
      </script>
   <%}
   }
  }

List checkedHomeTypes = new ArrayList(8);
if ( currentRow != null )
{
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType1() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType2() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType3() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType4() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType5() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType6() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType7() );
}

CFAD13SO cfad13so = new CFAD13SO();
if ( state.getAttribute( "cfad13so", request ) != null )
{
  cfad13so = (CFAD13SO) state.getAttribute( "cfad13so", request );
}

%>

<impact:validateForm name="frmHomeHistoryDetail"
          method="post"
          action="/fad/FAHomeHistory/saveHomeHistory"
          validationClass="gov.georgia.dhr.dfcs.sacwis.web.fad.FAHomeHistoryCustomValidation"
          pageMode="<%= pageMode %>"
          schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="ulIdResourceHistory" value="<%= String.valueOf( intResourceHistoryID ) %>"/>
<impact:validateInput type="hidden" name="arrayIndex" value="<%= String.valueOf( intArrayIndex ) %>"/>
<impact:validateInput type="hidden" name="nextStartDate" value="<%= String.valueOf( nextStartDate ) %>"/>
<impact:validateInput type="hidden" name="previousEndDate" value="<%= String.valueOf( previousEndDate ) %>"/>
<impact:validateInput type="hidden" name="timestamp" value="<%= String.valueOf( cfad13so.getTsLastUpdate() ) %>"/>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

<table width="100%" class="tableborder" border="0" cellspacing="0" cellpadding="3">
<th colspan="8">Home Information</th>
<tr>
          <td><impact:validateDate
               size="10"
               value="<%= FormattingHelper.formatDate( currentRow.getDtDtRshsEffective() ) %>"
               name="startDate"
               tabIndex="<%= tabIndex++%>"
               label="Start Date"
               required="true"
               colspan="2"
               constraint="Date"/>
          </td>
          <td><impact:validateDate
               size="10"
               value="<%= FormattingHelper.formatDate( currentRow.getDtDtRshsEnd() ) %>"
               name="endDate"
               tabIndex="<%= tabIndex++%>"
               label="End Date"
               required="<%= String.valueOf( !bDisableAllFields ) %>"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               colspan="2"
               constraint="Date"/>
          </td>
          <td><impact:validateInput
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsFacilCapacity() ) %>"
               type="text"
               name="txtCapacity"
               label="Capacity"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               cssClass="formInput"
               size="4"
               maxLength="4"
               constraint="Numeric"/>
             </td>
          </tr>
          <tr>
<% /* SIR 18710 - Added call to onChange to selCategory widget. */ %>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= currentRow.getSzCdRshsCategory() %>"
               name="selCategory"
               label="Category"
               onChange="categoryChange()"
               codesTable="<%= CodesTables.CFACATEG %>"
               required="<%= String.valueOf( !bDisableAllFields ) %>"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"/></td>
            <td>&nbsp;</td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= currentRow.getSzCdRshsFaHomeStatus() %>"
               name="selStatus"
               label="Status"
               codesTable="<%= CodesTables.CFAHMSTA %>"
               required="<%= String.valueOf( !bDisableAllFields ) %>"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"/>
            </td>
          </tr>
          <tr> </tr>
        </table>

      <BR>

        <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
          <th colspan="8">Male Age Range Approved</th>
          <tr>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAMaAgeMin()/12 ) %>"
               name="selMaleMinYear"
               label="Min Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAMaAgeMin()%12 ) %>"
               name="selMaleMinMonth"
               label="Min Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAMaAgeMax()/12 ) %>"
               name="selMaleMaxYear"
               label="Max Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAMaAgeMax()%12 ) %>"
               name="selMaleMaxMonth"
               label="Max Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
          </tr>
        </Table>

      <BR>
        <table width="100%" class ="tableborder" cellspacing="0" cellpadding="3">
          <th colspan="8">Female Age Range Approved</th>
          <tr>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAFeAgeMin()/12 ) %>"
               name="selFemaleMinYear"
               label="Min Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAFeAgeMin()%12 ) %>"
               name="selFemaleMinMonth"
               label="Min Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAFeAgeMax()/12 ) %>"
               name="selFemaleMaxYear"
               label="Max Year"
               options="<%= yearOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%= tabIndex++ %>"
               value="<%= String.valueOf( currentRow.getUNbrRshsAFeAgeMax()%12 ) %>"
               name="selFemaleMaxMonth"
               label="Max Month"
               options="<%= monthOptions %>"
               blankValue="false"
               disabled="<%= String.valueOf( bDisableAllFields ) %>"
               conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
            </td>
          </tr>
          </table>
   <br>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
    <tr><th colspan = "8"> Foster Home Type </th></tr>
     <tr>
     <td>
    <impact:codesCheckbox
      name="famTypes"
      defaultCodes="<%=checkedHomeTypes%>"
      codesTableName="<%= CodesTables.CFAHMTYP %>"
      columns="2"
      isHorizontal="true"
      disabled="<%= String.valueOf( bDisableAllFields ) %>"
      tabIndex="<%= tabIndex++ %>"/>
     </td>
     </tr>
  </table>

<br>

 <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
    <th colspan="6">Closure Information</th>
   <tr>
    <td><impact:validateSelect
       tabIndex="<%= tabIndex++ %>"
       value="<%= currentRow.getSzCdRshsClosureRsn() %>"
       name="selClosureReason"
       label="Closure Reason"
       codesTable="<%= CodesTables.CFACLOSE %>"
       disabled="<%= String.valueOf( bDisableAllFields ) %>"
       conditionallyRequired="<%= String.valueOf( !bDisableAllFields ) %>"/>
    </td>
    <td><impact:validateSelect
       tabIndex="<%= tabIndex++ %>"
       value="<%= currentRow.getSzCdRshsRecmndReopen() %>"
       name="selRecReopen"
       label="Recommend Re-opening"
       disabled="<%= String.valueOf( bDisableAllFields ) %>"
       codesTable="<%= CodesTables.CFARCMND %>"/>
   </td>
   </tr>
   <tr>
    <td><impact:validateSelect
       tabIndex="<%= tabIndex++ %>"
       value="<%= currentRow.getSzCdRshsInvolClosure() %>"
       name="selInvolClosure"
       label="Involuntary Closure"
       disabled="<%= String.valueOf( bDisableAllFields ) %>"
       codesTable="<%= CodesTables.CFACLSTP %>"/>
    </td>
  </tr>
</table>
<br>
<hr>
<table width="100%" cellspacing="0" cellpadding="3">
<tr>
    <% if ( !bHideDeleteButton )
    {%>
        <td>
        <impact:ButtonTag
             name="btnDelete1"
             img="btnDelete"
             form="frmHomeHistoryDetail"
             function="return deleteRow();"
             restrictRepost="true"
             action="/fad/FAHomeHistory/deleteHomeHistoryDetail"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
    <%}
      if ( !bHideSaveButton )
    {%>

        <td align="right">
        <impact:ButtonTag
             name="btnSave1"
             img="btnSave"
             form="frmHomeHistoryDetail"
             restrictRepost="true"
             action="/fad/FAHomeHistory/saveHomeHistory"
             tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%}%>
    </table>

</impact:validateForm>
<%
 // SIR 18710 - We have to Call CategoryChange() so the appropriate widgets will
 // be enabled or disabled in the Foster Home Type Section upon page load.
%>
<script language="Javascript1.2">
  categoryChange();
</script>

