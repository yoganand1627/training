<%--
JSP Name:     Foster Care Secondary Goals
Created by:   Nandita Hegde
Date Created: 02/12/07


Description:
  This JSP is used to collect and display data about foster care secondary goals.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<%
//*********************
//*** SET PAGE MODE ***
//*********************

       String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
         pageMode = PageMode.getPageMode(request);
      }

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
  int tabIndex = 1;
  String desc = "";
  String status = "";
  String parentApproval = "";
  List<FosterCareSecGoalsList> secGoalsList = new ArrayList<FosterCareSecGoalsList>();
  
  
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
                                                                       
                                                     
  
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************   
  
       
FosterCareSecGoalsRetrieveSO fsecGoalsSO = (FosterCareSecGoalsRetrieveSO) state.getAttribute("FosterCareSecGoalsRetrieveSO", request);
   if(fsecGoalsSO!=null)
   {
    if(fsecGoalsSO.getTxtDesc()!=null)
    {
      desc = fsecGoalsSO.getTxtDesc();
    }
    if(fsecGoalsSO.getSelStatus()!=null)
     {  
       status = fsecGoalsSO.getSelStatus();
     }
     if(fsecGoalsSO.getIndParentApproval()!=null)
     {
      parentApproval = fsecGoalsSO.getIndParentApproval();
     }
   }     
 
                 
%>

<%//******************
  //*** JAVASCRIPT ***
  //******************
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">
 
 // This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
}

 //Message for when a user wants to delete a needs outcomes and gives the user an alert.
  function Delete()
   {
    var cont;
    cont = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>');
    return cont;
  }
 
  
 </script>




<%

//**************************
//**** FORM STARTS HERE ****
//**************************
 %>

<impact:validateErrors />
<impact:validateForm name="frmFosterCareSecGoals" method="post" action="/serviceDelivery/FosterCareSecGoals/displayFosterCareSecGoals" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">

  <% /*  Always include this hidden field in your form */ %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

  <%// Begin Detail

      %>


  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="8" align="left">
        Secondary Goals
      </th>
    </tr>
    <tr></tr>
    <tr>
      <td colspan="1">
        <impact:validateTextArea name="txtDesc" label="Description" tabIndex="<%= tabIndex++ %>" constraint="Paragraph1000" required="true" maxLength="1000" colspan="2" cols="70" rows="5">
          <%=desc%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" label="Status" id="selStatus" name="selStatus" width="20%" value="<%=status %>" required="true" codesTable="CSTATUS" />
      </td>
      <td>
        <impact:validateInput type="checkbox" cssClass="formInput" label="Parent Approval" checked="<%= (("".equals(parentApproval)) || (ArchitectureConstants.N.equals(parentApproval))) ? "false" : "true" %>" tabIndex="<%= tabIndex++ %>" value="Y"
          name="cbxParentApproval" cssClass="formInput" />
      </td>
    </tr>
  </table>

  <%//*****************
      //**** BUTTONS ****
      //*****************
      // Display the Save and delete buttons unless the page mode is VIEW.  %>

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
    <% if ((!PageModeConstants.VIEW.equals(pageMode)) && (!PageModeConstants.NEW.equals(pageMode))) {%>
      <td class="alignLeft">
        <impact:ButtonTag name="btnDelete" align="left" img="btnDelete" form="frmFosterCareSecGoals" action="/serviceDelivery/FosterCareSecGoals/deleteFosterCareSecGoals" preventDoubleClick="true" function="return Delete()" tabIndex="<%= tabIndex++ %>" />
      </td>
    <%}
    if (!PageModeConstants.VIEW.equals(pageMode)) {%>
      <td class="alignRight">
        <impact:ButtonTag name="btnSave" align="right" img="btnSave" form="frmFosterCareSecGoals" action="/serviceDelivery/FosterCareSecGoals/saveFosterCareSecGoals" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    <%}%>
    </tr>
  </table>

  <br>
</impact:validateForm>



