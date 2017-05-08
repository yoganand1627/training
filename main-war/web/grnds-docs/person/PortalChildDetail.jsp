<%
/**  JSP Name:     Portal Child Detail
  *  Created by:   Patrick Coogan
  *  Date Created: 10/18/2009
  *
  *  Description:
  *
  * Change History:
  *  Date        User              Description
  *  --------    ---------------   --------------------------------------------------
  *  10/18/09    pcoogan           Created new JSP to support SHINES Portal 
  */

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PortalChildRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCharacteristicsBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PortalContactBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PortalChildDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>



<%
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile ( request );
  String pageMode = PageMode.getPageMode(request);

  // create the output object
  PortalChildRetrieveSO portalChildRetrieveSO = ( PortalChildRetrieveSO ) request.getAttribute( "portalChildRetrieveSO" );
  
  List<PersonCharacteristicsBean> childCharacteristics = null;
  List<PortalContactBean> contactList = null;

  if (portalChildRetrieveSO != null) {  
  	childCharacteristics = portalChildRetrieveSO.getChildCharacteristicsList();
  }
  
  if (portalChildRetrieveSO != null) {  
  	contactList = portalChildRetrieveSO.getContactsList();
  }
  
  if (portalChildRetrieveSO == null) {
    portalChildRetrieveSO = new PortalChildRetrieveSO();
  }
      
  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  String submitUrl="/person/PortalChildDetail/displayPortalChildDetail";
  
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="JavaScript">
function displayChildList()
{
  disableValidation('frmPortalChildDetail');
  submitValidateForm( "frmPortalChildDetail", "/workload/PortalChildList/displayChildList" );
}

function cancelValidation()
{
  disableValidation('frmPortalChildDetail');
}
function displayContactDetail( idEvent )
{
  document.frmPortalChildDetail.hdnUlIdEvent.value = idEvent;
  disableValidation('frmPortalChildDetail');
  submitValidateForm( "frmPortalChildDetail", "/contacts/PortalContactDetail/displayContact" );
}

</script>


  <impact:validateErrors/>
  <impact:validateForm
       name="frmPortalChildDetail"
       method="post"
       action="/person/PortalChildDetail/displayPortalChildDetail"
       pageMode="<%=pageMode%>"
       schema="/WEB-INF/Constraints.xsd">
<%
   TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request.getAttribute(
          PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

  if (tuxPagination != null) {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  } else {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(100); //SIR 19651 changed from 10 to 100
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
  }

%>
<table width="100%"><tr><td>
<a href="javascript:displayChildList()">Back to Child List</a>
</td></tr></table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="6">Person Demographics</th>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="test" colspan="1" label="Person ID"
                                       value="<%= FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdPerson()) %>"/></td>
</tr>

<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="First Name"
                                       value="<%= FormattingHelper.formatString(portalChildRetrieveSO.getNmPersonFirst()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Middle Name"
                                       value="<%= FormattingHelper.formatString(portalChildRetrieveSO.getNmPersonMiddle()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Last Name"
                                       value="<%= FormattingHelper.formatString(portalChildRetrieveSO.getNmPersonLast()) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Case ID"
                                       value="<%= FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdCase()) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Gender"
                                       value="<%= FormattingHelper.formatString(
                      Lookup.simpleDecodeSafe( "CSEX", portalChildRetrieveSO.getCdGender() ) ) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="DOB"
                                       value="<%= FormattingHelper.formatDate(portalChildRetrieveSO.getDtChildBirth()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Age"
                                       value="<%= FormattingHelper.formatLong(portalChildRetrieveSO.getUlChildAge()) %>"/></td>
</tr>

</table>
<br/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="4">Current Placement</th>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Resource Name"
                                       value="<%= FormattingHelper.formatString(portalChildRetrieveSO.getSzNmRsrcFacil()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Resource ID"
                                       value="<%= FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdResource()) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Placement Start Date"
                                       value="<%= FormattingHelper.formatDate(portalChildRetrieveSO.getDtPlcmtStart()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="End Date"
                                       value="<%= FormattingHelper.formatDate(portalChildRetrieveSO.getDtPlcmtEnd()) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Removal Reason"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRMRSNAC",portalChildRetrieveSO.getCdRemovalRsn())) %>"/></td>

</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Placement Type"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CPLMNTYP",portalChildRetrieveSO.getCdPlcmtType())) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Sibling Placement"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CINVACAN",portalChildRetrieveSO.getCdSiblingPlcmt())) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Legal County"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCOUNT", portalChildRetrieveSO.getCdLegalCnty())) %>"/></td>
</tr>
<tr>
<td>
<impact:ifThen test='<%= (ArchitectureConstants.Y.equals(portalChildRetrieveSO.getCdIndCci()))%>'>
<impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="RBWO Program"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRBPROGI",portalChildRetrieveSO.getCdRbwoProg())) %>"/>
</impact:ifThen>
<impact:ifThen test='<%= (ArchitectureConstants.N.equals(portalChildRetrieveSO.getCdIndCci()))%>'>
<impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="RBWO Program"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRBPROGA",portalChildRetrieveSO.getCdRbwoProg())) %>"/>
</impact:ifThen>
<impact:ifThen test='<%= ("".equals(portalChildRetrieveSO.getCdIndCci()))%>'>
<impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="RBWO Program"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CRBPROGI",portalChildRetrieveSO.getCdRbwoProg())) %>"/>
</impact:ifThen>
</td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="RBWO Per Diem"
                                       value="<%= FormattingHelper.formatMoney(portalChildRetrieveSO.getDPerDiem()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Waiver Rate"
                                       value="<%= FormattingHelper.formatMoney(portalChildRetrieveSO.getDWaiverRate()) %>"/></td>
</tr>

</table>
<br/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="4">Case Manager/Supervisor Data</th>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Primary Case Manager Name"
                                       value="<%= FormattingHelper.formatString(portalChildRetrieveSO.getNmCaseManager()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Title"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CEMPJBCL",portalChildRetrieveSO.getCdCaseManagerJobTitle())) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Phone"
                                       value="<%= FormattingHelper.formatPhone(portalChildRetrieveSO.getSzCaseManagerPhone()) %>"/></td>

</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Office Location"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("COFCNM",portalChildRetrieveSO.getCdCaseManagerOfficeLoc())) %>"/></td>

</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Supervisor Name"
                                       value="<%= FormattingHelper.formatString(portalChildRetrieveSO.getNmSupervisor()) %>"/></td>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Title"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("CEMPJBCL",portalChildRetrieveSO.getCdSupervisorJobTitle())) %>"/></td>
</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Phone"
                                       value="<%= FormattingHelper.formatPhone(portalChildRetrieveSO.getSzSupervisorPhone()) %>"/></td>

</tr>
<tr>
<td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="1" label="Office Location"
                                       value="<%= FormattingHelper.formatString(Lookup.simpleDecodeSafe("COFCNM",portalChildRetrieveSO.getCdSupervisorOfficeLoc())) %>"/></td>

</tr>


</table>
<br/>
<impact:ExpandableSectionTag name="PersonChar" label="Person Characteristics" tabIndex="<%= tabIndex++ %>" id="btnAdd_Id" >
      <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
                 <table width="100%" cellspacing="0" cellpadding="3">
                           <tr>
                           <th class="thList">Category</th>
                           <th class="thList">Characteristic</th>
                           <th class="thList">&nbsp;</th>
                        </tr>
<%loopCount = 0;
        //If cinv04 is not null, then check to see if BCdPersonChar is equal to "2", if it is, then
        //No characteristics applicable is checked on the Person Char page, set hidden field equal to
        
        String persChar = portalChildRetrieveSO.getCdPersonChar();
        if ("2".equals(persChar)) {

        %>
                      <tr class="odd">
                        <td colspan="10">None Diagnosed
                        <impact:validateInput type="hidden" name="hdnBIndChar" value="N"/>
                        </td>
                      </tr>
<%}

        else if ("3".equals(persChar)) {

        %>
                      <tr class="odd">
                        <td colspan="10">Not Yet Diagnosed 
                        <impact:validateInput type="hidden" name="hdnBIndChar" value="N"/>
                        </td>
                      </tr> 
<%}
        //If the Characteristics array has no elemnts, then no characteristics have been selected
        //set hidden field equal to "N" for custom Validation
        else if ((childCharacteristics== null)||(childCharacteristics.isEmpty())) {
%>
                      <tr class="odd">
                        <td colspan="10">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                           <impact:validateInput type="hidden" name="hdnBIndChar" value="N"/>
                        </td>
                      </tr>
<%}
        //If Charactaristics have been selected, set the hidden field to "Y" for custom Validation
        else {
          Iterator<PersonCharacteristicsBean> iterator = childCharacteristics.iterator();
          while (iterator.hasNext()) {
            PersonCharacteristicsBean charRow = iterator.next();
%>
                        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>" valign="top">
                            <td><%=Lookup.simpleDecodeSafe("CCHRTCAT", charRow.getCdCharCategory())%></td>
                            <td>
                                <%=Lookup.simpleDecodeSafe(charRow.getCdCharCategory(), charRow.getCdCharacteristic())%>
                            <td>
                        </tr>
<%loopCount++;
          }
        }
%>
           </table>
       </div>
</impact:ExpandableSectionTag>
<br/>

<impact:ExpandableSectionTag name="ContactList" label="Contacts" tabIndex="<%= tabIndex++ %>" id="btnAdd_Id" >
<impact:pagination submitUrl="<%=submitUrl%>">
<div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
 <table width="100%" cellspacing="0" cellpadding="3">
                           <tr>
                           <th class="thList">Date</th>
                           <th class="thList">Method</th>
                           <th class="thList">Purpose</th>
                           <th class="thList">Name</th>
                           <th class="thList">Contacted By</th>
                           <th class="thList">Agency</th>
                        </tr>
<%
loopCount = 0;
if ((contactList== null)||(contactList.isEmpty())) {
%>
                      <tr class="odd">
                        <td colspan="6">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                          
                        </td>
                      </tr>
<%}
        
        else {
          Iterator<PortalContactBean> iterator = contactList.iterator();
          while (iterator.hasNext()) {
            PortalContactBean contact = iterator.next();
%>
                        <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>" valign="top">
                            <td><%=FormattingHelper.formatDate(contact.getDtContactDate())%></td>
                            <impact:ifThen test='<%= ("Y".equals(contact.getSzIndAccess()))%>'>
                            <td><a href="javascript:displayContactDetail('<%=FormattingHelper.formatInt(contact.getIdContactEvent())%>')"><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCNTMETH", contact.getCdCntctMethod()))%></a></td>
                            </impact:ifThen>
                            <impact:ifThen test='<%= ("N".equals(contact.getSzIndAccess()))%>'>
                            <td><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCNTMETH", contact.getCdCntctMethod()))%></td>
                            </impact:ifThen>
                            <td><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe("CCNTPURP", contact.getCdCntctPurpose()))%></td>
                            <td><%=FormattingHelper.formatFullName(portalChildRetrieveSO.getNmPersonFirst(),portalChildRetrieveSO.getNmPersonMiddle(),portalChildRetrieveSO.getNmPersonLast())%></td>
                            <td><%=FormattingHelper.formatString(contact.getSzContactedBy())%></td>
                            <td><%=FormattingHelper.formatString(contact.getSzContactAgency())%></td>
                            
                        </tr>
<%loopCount++;
          }
        }
%>
</table>
</div>
</impact:pagination>
<table width="100%" cellpadding="3" cellspacing="0">
          <tr>
            <td class="tableBG">
            <div class="alignRight"><impact:ButtonTag name="btnAdd" img="btnAdd" navAwayCk="false" function="cancelValidation()" form="frmPortalChildDetail" action="/contacts/PortalContactDetail/addContact" editableMode="<%= EditableMode.EDIT + EditableMode.NEW + EditableMode.VIEW%>" tabIndex="<%= tabIndex++ %>"/></div>
            </td>
          </tr>
</table>
</impact:ExpandableSectionTag>
<impact:validateInput type="hidden" name="hdnUlIdCase" value="<%= GlobalData.getUlIdCaseAsString(request)%>" />
<impact:validateInput type="hidden" name="hdnUlIdStage" value="<%= GlobalData.getUlIdStageAsString(request)%>"/>
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%= GlobalData.getUlIdPersonAsString(request)%>"/>
<impact:validateInput type="hidden" name="hdnUlIdPlcmtEvent" value="<%= GlobalData.getUlIdPlcmtEventAsString(request)%>"/>
<impact:validateInput type="hidden" name="hdnUlIdRsrcParent" value="<%= GlobalData.getUlIdParentRsrcAsString(request)%>" />
<impact:validateInput type="hidden" name="hdnUlIdRsrcChild" value="<%= GlobalData.getUlIdResourceAsString(request)%>"/>
<impact:validateInput type="hidden" name="hdnUlIdEvent" value="" />
<impact:validateInput type="hidden" name="hdnUlIdPlcmtFacil" value="<%= FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdResource())%>" />
<impact:validateInput type="hidden" name="hdnUlIdPlcmtAgency" value="<%= FormattingHelper.formatLong(portalChildRetrieveSO.getUlIdRsrcAgency())%>" />
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>




