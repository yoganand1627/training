<%//*--------------------------------------------------------------------------------
      //*  JSP Name:     Foster Care Participant
      //*  Created by:   Steven Thrasher
      //*  Date Created: 1/31/07
      //*
      //*  Description:
      //*  This JSP displays the Foster Care Participant details.
      //*
      //*  Change History:
      //*  Date      User              Description
      //*  --------  ----------------  --------------------------------------------------
      //*  1/31/07  Steven Thrasher    Initial page development
      //* 11/24/08  charden	           STGAP00007572 - wrote code for page to reload when participant type is changed
      //* 01/07/09  mxpatel            STGAP00007572 - edited code not to show the popup message if the participant type changes
      //*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean"%>
<%
      //*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      FosterCarePartBean fcBeanRetrieve = null;
      int tabIndex = 1;
      String pageMode = PageMode.getPageMode(request);
      String apprvYes = ArchitectureConstants.FALSE;
      String apprvNo = ArchitectureConstants.FALSE;
      String txtApprvDt = FormattingHelper.formatString("");
      String txtPersonNotApprv = FormattingHelper.formatString("");
      String txtPartDt = FormattingHelper.formatString("");
      String txtSignedCpyDt = FormattingHelper.formatString("");
      String txtRelationshipInterest = FormattingHelper.formatString("");
      String txtParticipantName = FormattingHelper.formatString("");
      String selParticipantType = FormattingHelper.formatString("");
      String hdnPersonId = FormattingHelper.formatString("");
      String participantId = "";
      String radioDisable = ArchitectureConstants.FALSE;
      String hdnPlanPart = "";
      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      fcBeanRetrieve = (FosterCarePartBean) state.getAttribute("participant", request);
      String hdnIdEvent = String.valueOf(GlobalData.getUlIdEvent(request));
      String includingFormName = (String) request.getAttribute("includingFormName");

      if (fcBeanRetrieve != null) {
        if (ArchitectureConstants.Y.equals(fcBeanRetrieve.getIndApproval())) {
          apprvYes = ArchitectureConstants.TRUE;
          apprvNo = ArchitectureConstants.FALSE;
        } else if (ArchitectureConstants.N.equals(fcBeanRetrieve.getIndApproval())) {
          apprvNo = ArchitectureConstants.TRUE;
          apprvYes = ArchitectureConstants.FALSE;
        }
        if (fcBeanRetrieve.getIdPlanPart() != 0) {
          hdnPlanPart = FormattingHelper.formatInt(fcBeanRetrieve.getIdPlanPart());
        }
        participantId = FormattingHelper.formatInt(fcBeanRetrieve.getIdPlanPart());
        txtApprvDt = FormattingHelper.formatDate(fcBeanRetrieve.getDtApprv());
        txtPersonNotApprv = fcBeanRetrieve.getTxtNoApprv();
        txtPartDt = FormattingHelper.formatDate(fcBeanRetrieve.getDtPart());
        txtSignedCpyDt = FormattingHelper.formatDate(fcBeanRetrieve.getDtSigned());
        txtRelationshipInterest = fcBeanRetrieve.getSzCdRelInt();
        txtParticipantName = fcBeanRetrieve.getSzNmPart();
        selParticipantType = fcBeanRetrieve.getSzCdPartType();
        hdnPersonId = FormattingHelper.formatInt(fcBeanRetrieve.getIdPerson());
      }

      if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.EDIT.equals(pageMode)) {
        radioDisable = ArchitectureConstants.FALSE;
      } else if (PageModeConstants.VIEW.equals(pageMode)) {
        radioDisable = ArchitectureConstants.TRUE;
      }
      //******************
      //*** JAVASCRIPT ***
      //******************

      %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

var skipReload = false;

window.onbeforeunload = function ()
{
if(!skipReload){
  IsDirty();
  }
};

function reloadWithoutDirty(){
skipReload = true;
reloadFCParticipant();
}

function reloadFCParticipant()
{
  disableValidation('frmFosterCareParticipant');
  setState('frmFosterCareParticipant');
  setValidationUrl('frmFosterCareParticipant','/casemgmt/FosterCareParticipant/reloadFCParticipant');
  document.frmFosterCareParticipant.submit();
}

function confirmDelete()
{
  return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
}
</script>

<%//*************************
//*** VALIDATION ERRORS ***
//*************************
%>
<impact:validateErrors/>
<%
//****************************************************
//**** FORM (Foster Care Participant) STARTS HERE ****
//****************************************************
%>
<impact:validateForm
        name="frmFosterCareParticipant"
        method="post"
        action="/casemgmt/FosterCareParticipant/displayFosterCareParticipant"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FosterCareParticipantCustomValidation"
        pageMode="<%= pageMode %>"
        schema="/WEB-INF/Constraints.xsd">
        
<impact:validateInput
        type="hidden"
        name="includingFormName"
        value="<%=includingFormName%>"/>
<%
// The user must begin by selecting a Participant Type.
if ("".equals(selParticipantType) )
{%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
    <tr><th colspan="2">Foster Care Participant Detail</th></tr>
    <tr>
      <td>
        <table border="0" cellpadding="3" cellspacing="0" width="100%">
          <tr>
            <td>
              <impact:validateSelect
                label="Participant Type"
                name="selParticipantType"
                codesTable="<%= CodesTables.CPARTYPE %>"
                required="true"
                value=""
                tabIndex="<%= tabIndex++ %>"/>
            </td>
            <td width="50%">&nbsp;</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>

  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td>
        <impact:ButtonTag
          name="btnContinue"
          img="btnContinue"
          align="right"
          form="frmFosterCareParticipant"
          action="/casemgmt/FosterCareParticipant/reloadFCParticipant"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
else
{%>
  <impact:validateInput
    type="hidden"
    name="hdnIdEvent"
    value="<%= hdnIdEvent %>"/>
  <impact:validateInput
    type="hidden"
    name="hdnPersonId"
    value="<%= hdnPersonId %>"/>
  <impact:validateInput
    type="hidden"
    name="hdnPlanPart"
    value="<%= hdnPlanPart %>"/>

        <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
          <tr>
           <th colspan="4">Foster Care Participant Detail</th>
          </tr>
          <tr>
            <%
            //------------------------
            //--- Participant Type ---
            //------------------------
            // Once the participant record has been saved to the database,
            // the Participant Type cannot be changed.
            if ("".equals(participantId) )
            {%>
              <td width="20%">
                <impact:validateSelect
                  label="Participant Type"
                  name="selParticipantType"
                  codesTable="<%= CodesTables.CPARTYPE %>"
                  required="true"
                  value="<%= selParticipantType %>"
                  onChange= "reloadWithoutDirty()"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            else
            {%>
              <td width="20%">
                <impact:validateSelect
                  label="Participant Type"
                  name="selParticipantType"
                  codesTable="<%= CodesTables.CPARTYPE %>"
                  required="true"
                  value="<%= selParticipantType %>"
                  disabled="true"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            %>
          </tr>
          <tr>
            <%
            //------------------------
            //--- Participant Name ---
            //------------------------
            // If the Participant Type is "Person in Case" or "Staff", the
            // Participant Name field can only be modified by performing a
            // Person Search or Staff Search, accordingly.
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
                 selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {%>
              <td>
                <impact:validateInput
                  type="text"
                  label="Name"
                  name="txtParticipantName"
                  value="<%= txtParticipantName %>"
                  required="true"
                  tabIndex="<%= tabIndex++ %>"
                  readOnly="true"
                  width="25%"
                  constraint="Name25"/>
              </td>
            <%
            }
            else
            {%>
              <td>
                <impact:validateInput
                  type="text"
                  label="Name"
                  name="txtParticipantName"
                  value="<%= txtParticipantName %>"
                  required="true"
                  maxLength="25"
                  tabIndex="<%= tabIndex++ %>"
                  constraint="Name25"/>
              </td>
            <%
            }
            %>

            <%
            //---------------------------
            //--- Person/Staff Button ---
            //---------------------------
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) )
            {%>
              <td colspan="2">
                <impact:ButtonTag
                  name="btnPerson"
                  img="btnSelectPerson"
                  align="left"
                  form="frmFosterCareParticipant"
                  action="/casemgmt/FosterCareParticipant/performPersonListPullback"
                  function="disableValidation('frmFosterCareParticipant')"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            else if ( selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {
             %>
              <td colspan="2">
                <impact:ButtonTag
                  name="btnStaff"
                  img="btnSelectStaff"
                  align="left"
                  form="frmFosterCareParticipant"
                  action="/casemgmt/FosterCareParticipant/performStaffSearch"
                  function="disableValidation('frmFosterCareParticipant')"
                  tabIndex="<%= tabIndex++ %>"/>
              </td>
            <%
            }
            else
            {%>
              <td colspan="2">&nbsp;</td>
            <%
            }
            %>
          </tr>
            <%
            //-----------------------------
            //--- Relationship/Interest ---
            //-----------------------------
            // If the Participant Type is "Person in Case" or "Staff", the
            // Relationship/Interest field can only be modified by performing
            // a Person Search or Staff Search, accordingly.
            if ( selParticipantType.equals( CodesTables.CPARTYPE_PIC ) ||
                 selParticipantType.equals( CodesTables.CPARTYPE_STA ) )
            {%>
            <tr>
              <td>
                <impact:validateInput
                  type="text"
                  label="Relationship/Interest"
                  name="txtRelationshipInterest"
                  maxLength="20"
                  value="<%= txtRelationshipInterest %>"
                  required="true"
                  readOnly="true"
                  cssClass="readonly"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"
                  cssClass="formInput"/>
              </td>
            </tr>
            <%
            }
            else
            {%>
            <tr>
              <td>
                <impact:validateInput
                  type="text"
                  label="Relationship/Interest"
                  name="txtRelationshipInterest"
                  maxLength="20"
                  value="<%= txtRelationshipInterest %>"
                  required="true"
                  colspan="3"
                  tabIndex="<%= tabIndex++ %>"
                  cssClass="formInput"/>
              </td>
            </tr>
            <%
            }
            %>
          <tr>
      <td>
            <impact:validateDate
                label="Signed Copy of Receipt"
                name="txtSignedCpyDt"
                type="text"
                value="<%= txtSignedCpyDt %>"
                size="10"
                conditionallyRequired="true"
                tabIndex="<%= tabIndex++ %>"
                constraint="Date"/>
          </td>
    </tr>
    <tr>
          <td>
            <impact:validateDate
                label="Participation Date"
                name="txtPartDt"
                type="text"
                value="<%= txtPartDt %>"
                size="10"
                conditionallyRequired="true"
                tabIndex="<%= tabIndex++ %>"
                constraint="Date"/>
          </td>
    </tr>
    <tr>
          <td>Person Approves: </td>
            <td>
                <impact:validateInput type="radio" disabled="<%= radioDisable %>" label="Yes" id="Yes" name="scrIndPrsnApprv" value="Y" cssClass="formInput" checked="<%= apprvYes %>" editableMode="<%=EditableMode.ALL%>" tabIndex="<%= tabIndex++ %>"/>

                <impact:validateInput type="radio" disabled="<%= radioDisable %>" label="No" id="No" name="scrIndPrsnApprv" value="N" cssClass="formInput" checked="<%= apprvNo %>" tabIndex="<%= tabIndex++ %>"/>
           </td>
           <td>
           <impact:validateDate
                label="Date of Approval"
                name="txtApprvDt"
                type="text"
                value="<%= txtApprvDt %>"
                size="10"
                conditionallyRequired="true"
                tabIndex="<%= tabIndex++ %>"
                constraint="Date"/>
           </td>
  </tr>
  <tr>
  	<td colspan="2">
  	 If person does not approve, please explain why:
  	</td>
  </tr>
  <tr>
    <td colspan="4">
        <impact:validateTextArea
               name="txtPersonNotApprv"
               cols="90" rows="4"
               colspan="4"
               tabIndex="<%= tabIndex++ %>"
               maxLength="300"><%= FormattingHelper.formatString(txtPersonNotApprv)%></impact:validateTextArea>
      </td>
  </tr>
 </table>

  <%
  //*****************
  //**** BUTTONS ****
  //*****************
  %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <%
      if ( !("".equals(participantId) ))
      {%>
        <td>
          <impact:ButtonTag
            name="btnDelete"
            img="btnDelete"
            align="left"
            navAwayCk="true"
            form="frmFosterCareParticipant"
            action="/casemgmt/FosterCareParticipant/deleteFCParticipant"
            function="return confirmDelete()"
            tabIndex="<%= tabIndex++ %>"/>
        </td>
      <%
      }
      %>
      <td>
        <impact:ButtonTag
          name="btnSave"
          img="btnSave"
          align="right"
          form="frmFosterCareParticipant"
          action="/casemgmt/FosterCareParticipant/saveFCParticipant"
          restrictRepost="true"
          preventDoubleClick="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>