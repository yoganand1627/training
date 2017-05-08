<%--
JSP Name:     Needs And Outcomes Detail
Created by:   Nandita Hegde
Date Created: 12/19/06

Description:


Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>


<%//*********************
      //*** SET PAGE MODE ***
      //*********************
      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }

      // Create a 1-based tab index variable that can be used to set tab indices down the page.
      int tabIndex = 1;

      //*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      NeedsAndOutcomesRetrieveSO needsOutcomes = null;
      String identifiedNeed = "";
      String comments = "";
      String cCFANeed = "";
      String serviceRecommended = "";
      String serviceProvided = "";
      String servNotProvidedRsn = "";
      String needMet = "";
      String needNotMetRsn = "";
      int idNeedsOutcomes = 0;
      int ulIdEvent = 0;
      int ulIdStage = 0;

      //***********************************
      //*** RETRIEVE HIDDEN STATE FIELD ***
      //***********************************
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************  
      needsOutcomes = (NeedsAndOutcomesRetrieveSO) state.getAttribute("NeedsAndOutcomesRetrieveSO", request);
      if (needsOutcomes != null) {
        ulIdEvent = needsOutcomes.getUlIdEvent();

        if (needsOutcomes.getTxtIdentifiedNeed() != null) {
          identifiedNeed = needsOutcomes.getTxtIdentifiedNeed();
        }
        if (needsOutcomes.getTxtComments() != null) {
          comments = needsOutcomes.getTxtComments();
        }
        if (needsOutcomes.getIndCCFANeed() != null) {
          cCFANeed = needsOutcomes.getIndCCFANeed();
        }
        if (needsOutcomes.getTxtServiceRecommended() != null) {
          serviceRecommended = needsOutcomes.getTxtServiceRecommended();
        }
        if (needsOutcomes.getIndServiceProvided() != null) {
          serviceProvided = needsOutcomes.getIndServiceProvided();
        }
        if (needsOutcomes.getTxtServRecdNotProvidedRsn() != null) {
          servNotProvidedRsn = needsOutcomes.getTxtServRecdNotProvidedRsn();
        }
        if (needsOutcomes.getIndNeedMet() != null) {
          needMet = needsOutcomes.getIndNeedMet();
        }
        if (needsOutcomes.getTxtNeedNotMetRsn() != null) {
          needNotMetRsn = needsOutcomes.getTxtNeedNotMetRsn();
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

<%//**************************
      //**** FORM STARTS HERE ****
      //**************************

      %>

<impact:validateErrors />
<impact:validateForm name="frmNeedsAndOutcomesDetail" method="post" action="/subcare/NeedsAndOutcomes/displayNeedsAndOutcomesDetail" validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesCustomValidation" pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

  <%/*  Always include this hidden field in your form */

      %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <input type="hidden" name="hdnPageName" value="NeedsOutcomesDetail" />
  <input type="hidden" name="hdnUIdEvent">
  <input type="hidden" name="hdnUlIdStage">



  <%// Begin Detail

      %>


  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="8" align="left">
        Needs and Outcomes Detail
      </th>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateInput type="text" label=" Identified Need" name="txtIdentifiedNeed" constraint="Paragraph50" required="true" value="<%=identifiedNeed %>" />
      </td>
      <td>
        Comments
      </td>
      <td colspan="1">
        <impact:validateTextArea name="txtComments" tabIndex="<%= tabIndex++ %>" constraint="Comments" maxLength="300" colspan="2" cols="70" rows="5">
          <%=comments%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>

      <td>
        <impact:validateInput type="checkbox" cssClass="formInput" label="CCFA Need" checked="<%= (("".equals(cCFANeed)) || (ArchitectureConstants.N.equals(cCFANeed))) ? "false" : "true" %>" tabIndex="<%= tabIndex++ %>" value="Y" name="chkCCFANeed" cssClass="formInput" />
      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateInput type="text" label=" Service Recommended" name="txtServiceRecommended"  tabIndex="<%= tabIndex++ %>" constraint="Paragraph50" required="true" value="<%=serviceRecommended %>" />
      </td>
    </tr>
    <tr>

      <td>
        <impact:validateInput type="checkbox" cssClass="formInput" label="Service Provided" checked="<%= (("".equals(serviceProvided)) || (ArchitectureConstants.N.equals(serviceProvided))) ? "false" : "true" %>" tabIndex="<%= tabIndex++ %>" value="Y" name="chkServiceProvided"
          cssClass="formInput" />
      </td>
      <td>
        &nbsp;
      </td>
      <td colspan="1">
        <impact:validateTextArea label="Why service was not provided for need" name="txtServNotProvidedRsn" tabIndex="<%= tabIndex++ %>" constraint="Paragraph300" conditionallyRequired="true" maxLength="300" colspan="2" cols="70" rows="5">
          <%=servNotProvidedRsn%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>

      <td>
        <impact:validateInput type="checkbox" cssClass="formInput" label="Need Met" checked="<%= (("".equals(needMet)) || (ArchitectureConstants.N.equals(needMet))) ? "false" : "true" %>" tabIndex="<%= tabIndex++ %>" value="Y" name="chkNeedMet" cssClass="formInput" />
      </td>
      <td>
        &nbsp;
      </td>
      <td colspan="1">
        <impact:validateTextArea name="txtNeedNotMetRsn" label="Why Need was not met" tabIndex="<%= tabIndex++ %>" constraint="Paragraph300" conditionallyRequired="true" maxLength="300" colspan="2" cols="70" rows="5">
          <%=needNotMetRsn%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>

  <%//*****************
      //**** BUTTONS ****
      //*****************
      // Display the Save and Submit and Save buttons unless the page mode is VIEW. %>
     
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
    <% if ((!pageMode.equals(PageModeConstants.VIEW)) && (!pageMode.equals(PageModeConstants.NEW))) {%>
      <td class="alignLeft">
        <impact:ButtonTag name="btnDelete" align="left" img="btnDelete" form="frmNeedsAndOutcomesDetail" action="/subcare/NeedsAndOutcomes/deleteNeedsAndOutcomes" restrictRepost="true" preventDoubleClick="true" function="return Delete()"
          tabIndex="<%= tabIndex++ %>" />
      </td>
    <%}
    if (!pageMode.equals(PageModeConstants.VIEW)) {%>
      <td class="alignRight">
        <impact:ButtonTag name="btnSaveDetail" align="right" img="btnSave" form="frmNeedsAndOutcomesDetail" action="/subcare/NeedsAndOutcomes/saveNeedsAndOutcomesDetail" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    <%}%>
    </tr>
  </table>


  <br>
</impact:validateForm>


