<%--
JSP Name:     Safety Resource Child
Created by:   Josh Dorsey
Date Created: 06/17/2008

Description:
This JSP is the child page of Safety Resource and Safety Resource Child Detail,
which are used to record placements for children who are moved from their homes
but do not enter DFCS custody.  This child page captures the dates and relationships
for specific children.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
06172008  Patrick Coogan    Updated and checked in for Georgia SHINES release 
                            2.5
--%>

<%-- Imports --%>

<%@taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@page import="java.util.List"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>

<% 

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************

     BaseSessionStateManager state = 
           (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //Set the page mode to the mode that is passed in
      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) 
      {
        pageMode = PageMode.getPageMode(request);
      }

      String szDisabled = "false";
      String szDeleteDisabled = "true";
      String szSecondaryDisabled = "false";
      
      if (pageMode.equals(PageModeConstants.VIEW)) 
      {
          szDisabled = "true";
          szSecondaryDisabled = "true";
      }
      
      //Initialize the display variables for the page
      int tabIndex = 1;
      SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = 
        (SafetyResourceChildRetrieveSO) state.getAttribute("SafetyResourceChildRetrieveSO",request);
      List<SafetyResourcePersonBean> safetyResourceChildList = 
                                     safetyResourceChildRetrieveSO.getSafetyResourceChildList();
      
      String szDtStart = "";
      String szDtEnd = "";
      String szNmPrimRel = "";
      String szNmSecRel = "";
      String selPrimaryRelationship = "";
      String selSecondaryRelationship = "";
      int ulIdEvent = safetyResourceChildRetrieveSO.getUlIdEvent();
      int ulIdSrChild = safetyResourceChildRetrieveSO.getUlIdSrChild();
      String szChecked = "";
      
      if (ulIdSrChild != 0) 
      {
         szChecked = "true";
         
         if (szDisabled.equals("false")){
           szDeleteDisabled = "false";
         }
      }
      
      if (safetyResourceChildRetrieveSO.getDtStart()!=null) 
      {
         szDtStart = FormattingHelper.formatDate(safetyResourceChildRetrieveSO.getDtStart());
      }
      
      if (safetyResourceChildRetrieveSO.getDtEnd() != null) 
      {
         szDtEnd = FormattingHelper.formatDate(safetyResourceChildRetrieveSO.getDtEnd());
      }
      
      if (safetyResourceChildRetrieveSO.getNmPrimarySafetyResource() != null) 
      {
         szNmPrimRel = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getNmPrimarySafetyResource());
      }
      
      if (safetyResourceChildRetrieveSO.getNmSecondarySafetyResource() != null) 
      {
         szNmSecRel = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getNmSecondarySafetyResource());
      }
      
      if (safetyResourceChildRetrieveSO.getCdRelationshipPrimary() != null) 
      {
         selPrimaryRelationship = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getCdRelationshipPrimary());
      }
      
      if (safetyResourceChildRetrieveSO.getCdRelationshipSecondary() != null) 
      {
         selSecondaryRelationship = FormattingHelper.formatString(safetyResourceChildRetrieveSO.getCdRelationshipSecondary());
      }
      
      if ("".equals(szNmSecRel) && "false".equals(szSecondaryDisabled)){
      
         szSecondaryDisabled = "true";
      
      }
      
%>

<%-- Javascript section --%>

<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
}
</script>

<%-- End Javascript section --%>

<%-- Start Form --%>

 <impact:validateErrors />
 <impact:validateForm 
  name="frmSafetyResourceChild" 
  method="post" 
  action="/investigation/SafetyResource/displaySafetyResourceChild" 
  pageMode="<%=pageMode%>" 
  schema="/WEB-INF/Constraints.xsd"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyResourceChildCustomValidation">
 

 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
    <tr>
      <th colspan="4">
        Safety Resource Child Detail
      </th>
    </tr>
    <tr>
    <td>
    
    </td>
    </tr>
       <tr>
     <td>
      <impact:validateDate
        label="Start Date of Safety Resource Placement"
        type="text"
        size="10"
        value="<%=szDtStart%>"
        name="txtDtStart"
        tabIndex="<%= tabIndex++ %>"
        required="true"
        disabled = "<%= szDisabled %>"
        constraint="Date"/>  
     </td>
   </tr>
      <tr>
       <td>
        <impact:validateDisplayOnlyField name="PrimSafetyResource_DISPLAY_ONLY"
          label="Primary Safety Resource" value="<%=szNmPrimRel%>" />
      </td>
    </tr>  
    <tr> 
     <td>
     <impact:validateSelect
        label="Primary Safety Resource Relationship to Children"
        name="selPrimaryRelationship"
        codesTable="CRPTRINT"
        value="<%=selPrimaryRelationship%>"
        disabled = "<%= szDisabled %>"
        required="true"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
     
   </tr> 
   <tr>
       <td>
        <impact:validateDisplayOnlyField name="SecSafetyResource_DISPLAY_ONLY"
          label="Secondary Safety Resource" value="<%=szNmSecRel%>" />
      </td>
    </tr>  
       <tr> 
     <td>
      <impact:validateSelect
        label="Secondary Safety Resource Relationship to Children"
        name="selSecondaryRelationship"
        codesTable="CRPTRINT"
        value="<%=selSecondaryRelationship%>"
        disabled = "<%= szSecondaryDisabled %>"
        conditionallyRequired="true"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
   </tr>   
       <tr>
     <td>
      <impact:validateDate
        label="End Date of Safety Resource Placement"
        type="text"
        size="10"
        value="<%=szDtEnd%>"
        name="txtDtEnd"
        tabIndex="<%= tabIndex++ %>"
        disabled = "<%= szDisabled %>"
        required="false"
        constraint="Date"/>  
     </td>
   </tr>
  </table>  
  <br>
  <br>
    <tr>
    <td colspan="2">
<div id="scrollBar" style="height:100;width:762px;overflow:auto" class="tableborderList">
<table width="100%" cellspacing="0" cellpadding="2" border="0" class="tableborder">
  <tr class="subDetail">
    <th colspan = "2"><span class="formRequiredText">*</span>Children Placed</th>
  </tr>
   
<%if (safetyResourceChildList.isEmpty() || safetyResourceChildList == null) {
  //if there are no children in the case, display cleanly
%>        
	<tr class="odd">
		<td colspan="10">
		<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
		</td>
   </tr>

<% } else {
    //iterate through the children returned to populate selections.  Will be 1 if this is display of
    //existing, or will be all principals under 18 for new 
    int loopCount = 0;
   
    for (Iterator <SafetyResourcePersonBean> it = safetyResourceChildList.iterator(); it.hasNext();) {      

            SafetyResourcePersonBean safetyResourceChildBean = it.next();
           
%>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
		    <%
		       String checkId = "cbx_" + loopCount;
            %>
			<td>
			   <impact:validateInput 
			    type="checkbox" 
			    value="<%= String.valueOf(loopCount) %>" 
			    name="<%= checkId %>" 
			    disabled = "<%= szChecked %>" 
			    checked = "<%= szChecked %>" 
			    tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<%=FormattingHelper.formatString(safetyResourceChildBean.getNmChildFull())%>
			</td>						
			</tr>
			<%loopCount++;
          }  // close iterator
        }  %>
     
</table></td></tr>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr> 
<td width="20%" align="left">
<impact:ButtonTag 
 name="btnDelete" 
 img="btnDelete" 
 align="left" 
 form="frmSafetyResourceChild" 
 action="/investigation/SafetyResource/deleteSafetyResourceChild" 
 tabIndex="<%= tabIndex++ %>" 
 accessKey="S" 
 restrictRepost="true" 
 preventDoubleClick="true"
 disabled = "<%= szDeleteDisabled %>"
 function="" />

<td width="80%" align="right">

<impact:ButtonTag 
 name="btnSave" 
 img="btnSave" 
 align="right" 
 form="frmSafetyResourceChild" 
 action="/investigation/SafetyResource/saveSafetyResourceChild" 
 tabIndex="<%= tabIndex++ %>" 
 accessKey="S" 
 restrictRepost="true" 
 preventDoubleClick="true"
 disabled = "<%= szDisabled %>"
 function="" />

   </td>
   </tr>
</table>

<%-- Hidden fields section --%>
  
  <impact:validateInput type="hidden" name="hdnUlIdEvent" value="<%=Integer.toString(ulIdEvent)%>" />
  <impact:validateInput type="hidden" name="hdnUlIdSrChild" value="<%=Integer.toString(ulIdSrChild)%>" /> 	  
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />

<%-- Close form --%>

</impact:validateForm>
  
