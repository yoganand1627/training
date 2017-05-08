<%
//*--------------------------------------------------------------------------------
//*  JSP Name:     APS Outcome Matrix Detail
//*  Created by:   Jenn Casdorph
//*  Date Created: 12/18/2002
//*
//*  Description:
//*  This JSP displays the details for a given APS Outcome Matrix Row. Depending upon
//*  the user's privileges, the user can use this page to view, update, or add
//*  factors to the APS Outcome Matrix on the APS Service Plan Page.
//*  PageModes are as follows:  NEW, EDIT, and VIEW
//*
//*   Change History:
//*   Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*  05/23/2002  CAWTHOCW        SIR 17629 - Added Spell check button for the two
//*                              comment fields on the detail page.
//*
//*  05/14/2003  CASDORJM        SIR 17323 - Change the page so that the date would
//*                              not prefill.  Also added restrictRepost="true" to the
//*                              button tags.
//*
//*  05/04/2005  CORLEYAN        SIR 23530 - Added Information about the new care
//*                              codes tables.
//*
//*  06/28/05    dejuanr         changes related to SIR 23723
//*
//*  07/21/05    brauchs         Fixed colspan issues 
//*
//*  07/21/05    yeehp           took the spellcheck button out.
//*
//*  07/24/05    brauchs         Aligned label TDs 
//*
//*  08/12/05    pisharrk        SIR 23899 - The 'Spell Check' button to be hidden in MPS
//*
//*  08/16/05    marallh         SIR 23816 - Change the name of the date field for the
//*                              problem on the Outcome Matrix page.  Change the name to
//*                              "Date Problem Entered"
//*
//*  09/19/05    Todd Reser      SIR 23937 - Removed If Statement that hid spell check button
//*                              in MPS
//*  09/22/05    Todd Reser      Re-added an "if !care" statement that was erroneously deleted
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<% /* Import State Management classes */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<% /* Import PageMode and other utilities used on the page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%/* Import needed for Messages */ %>
<%/* Import needed for Form Launch */ %>
<%/* impact classes */%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int tabIndex = 1;
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
//*********************
//*** SET PAGE MODE ***
//*********************

//  Check to see if APS Service Plan passed us a page mode through the request
//  We will either pass PageMode.EDIT or PageMode.NEW depending on how the page was accessed.
String pageMode = (String)request.getAttribute("pageMode");
pageMode = pageMode != null ? pageMode : PageModeConstants.VIEW;

//  If APS Service Plan was in VIEW mode this page should ALWAYS be in VIEW mode too!
if ( PageMode.getPageMode(request).equals(PageModeConstants.VIEW) )
{
  pageMode = PageModeConstants.VIEW;
}

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
ROWCSVC09DO problemRow = (ROWCSVC09DO) state.getAttribute("rowcsvc09do", request);
problemRow = problemRow != null ? problemRow : new ROWCSVC09DO();

// SIR 23530 - Determine if the domain is a part of the
// Care codes tables, this indicator will be used to
// set other information on the page.
 Set domainCodes = new HashSet(Lookup.getCategoryCodesCollection(
          CodesTables.CCAREDOM));

  boolean care = domainCodes.contains(problemRow.getSzCdDomain());
%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>

<%/* Needed for Form Launch Custom tag */%>
<script src="/grnds-docs/js/document/document.js"></script>

<%/* Needed for IsDirty() functionality */%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<%/* BEGIN: JavaScript function definitions */%>
<script type="text/javascript" language="JavaScript1.2">

<% if ( !pageMode.equals(PageModeConstants.VIEW))
{

%>
  window.onload = function ()
{
   filterDropDownByCategory( frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeActnCateg,
                             frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction, 1, true );
<%
  //  We filter the Action Sub-Category drop down box every time we load the page.
  //  If the user enters the page and Action Sub-Category is blank, and then the user
  //  enters an Action Sub-Category and attempts to save the page but the page FAILS
  //  validation, we need to use the value for Action Sub-Category that was submitted
  //  to the request when the form was submitted.
  String action = "";
  if ( request.getParameter("selSzCdApsOutcomeAction") != null )
  {
    action = request.getParameter("selSzCdApsOutcomeAction");
  }
  else
  {
    action = problemRow.getSzCdApsOutcomeAction();
  }
%>
  frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction.options.value = '<%= action %>';
  CleanSelect(frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction);

};
<%}%>

// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
        IsDirty();
};

// Clears the Outcome Sub-Category when Action Category or Sub-Category is changed
function clearOutcomeSub()
{
  document.frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeResult.value = "";
  document.frmAPSOutcomeMatrixDetail.dtDtApsOutcomeRecord.value = "";
  <% // SIR 23530, this field will not exist for care, so only run this
     // javascript if this is not a CARE item.
     if (!care) { %>
      document.frmAPSOutcomeMatrixDetail.txtSzTxtApsOutcomeResult.value = "";
  <% } %>
}

// Clears the Action Sub-Category when the Action Category is changed
function clearActionSub()
{
  document.frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction.value = null;
}

//  Filters the Action Sub-Category Select Drop Down box based on what is
//  selected in the Action Category box.

//  Create a codeArray for every dropdown box that needs to be filtered on the page
//  SIR 23530 - use the CARE codes table for the dropdown for care items
<impact:codeArray codeName="CACTITYP" arrayName="CACTITYP" blankValue="true"/>;
<impact:codeArray codeName="CACTITP2" arrayName="CACTITP2" blankValue="true"/>;
function filterDropDownByCategory(selectBoxChanged, selectBoxToFilter, keyLength, blankValue )
{
  <% if (care) {%>
  codeArray = CACTITP2;
  <% } else { %>
  codeArray = CACTITYP;
  <% } %>
  //  Get the filter key from what has been selected in the 'parent' select box
  var filterOn = selectBoxChanged.options.value;
  var key = filterOn.substring( 0, keyLength );
  populateFilteredDropdown(key, selectBoxToFilter, codeArray, blankValue );
}

</script>

<%
//*************************
//*** VALIDATION ERRORS ***
//*************************
%>
<%/* Include custom tag for displaying errors on the page */%>
<impact:validateErrors/>


<%
//**************************
//**** FORM STARTS HERE ****
//**************************
%>
<impact:validateForm name="frmAPSOutcomeMatrixDetail"
        method="post"
        action="/investigation/APSServicePlan/displayAPSOutcomeMatrixDetail"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.APSOutcomeMatrixDetailCustomValidation"
        pageMode="<%= pageMode %>"
        schema="/WEB-INF/Constraints.xsd">
<%
//*****************
//**** PROBLEM  ***
//*****************
%>
<input type="hidden" name="hdnNewDuplicateFactor" value='<%= (String)request.getAttribute("hdnNewDuplicateFactor") %>'>

<%
//*****************
//**** PROBLEM  ***
//*****************
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
     <th colspan="2">Problem</th>
  </tr>
<% // SIR 23530 - Domain is only displayed for CARE.
    if (care)
    { %>
  <tr>
    <td><impact:validateDisplayOnlyField
                name="txtSzCdDomain"
                label="Domain"
                value="<%= Lookup.simpleDecodeSafe( CodesTables.CCAREDOM , problemRow.getSzCdDomain() )%>" /></td>
  </tr>
<% } %>
  <tr>
    <td width="150"><impact:validateDisplayOnlyField
                name="txtCCdApsClientFactor"
                label="Category"
                value="<%= Lookup.simpleDecodeSafe( care ? CodesTables.CCARECAT : CodesTables.CPROCATG , problemRow.getCCdApsClientFactor() )%>" /></td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField
                name="txtSzCdApsClientFactor"
                label="Sub-Category"
                value="<%= Lookup.simpleDecodeSafe( care ? CodesTables.CCAREFAC : CodesTables.CPROBTYP, problemRow.getSzCdApsClientFactor() ) %>" /></td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField
                name="dtDtApsOutcomeProblem"
                label="Date Problem Entered"
                value="<%=FormattingHelper.formatDate( problemRow.getDtDtApsOutcomeProblem() )%>" /></td>
  </tr>
<% // SIR 23530 - Comments boxes will only be available for non care items.
   if (!care)
   {
%>
  <tr>
    <td><impact:validateDisplayOnlyField
                name="txtSzTxtApsCltFactorCmnts"
                label="Comments"
                value="<%=FormattingHelper.formatString(problemRow.getSzTxtApsCltFactorCmnts())%>" /></td>
  </tr>
<% } %>
</table>
<%
//*****************
//**** ACTION ****
//*****************
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
     <th colspan="4">Action</th>
  </tr>
  <tr>
    <td  width="150"><impact:validateSelect
                label="Category"
                name="selSzCdApsOutcomeActnCateg"
                tabIndex="<%= tabIndex++ %>"
                codesTable="<%= care ? CodesTables.CACTCTG2 : CodesTables.CACTCATG %>"
                blankValue="true"
                onChange="clearOutcomeSub(); clearActionSub(); filterDropDownByCategory( frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeActnCateg, frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction, 1, true )"
                conditionallyRequired="true"
                value="<%= problemRow.getSzCdApsOutcomeActnCateg() %>" /></td>
  </tr>
  <tr>
    <td><impact:validateSelect
                label="Sub-Category"
                name="selSzCdApsOutcomeAction"
                tabIndex="<%= tabIndex++ %>"
                codesTable="<%= care ? CodesTables.CACTITP2 : CodesTables.CACTITYP %>"
                blankValue="true"
                onChange="clearOutcomeSub()"
                conditionallyRequired="true"
                value="<%= problemRow.getSzCdApsOutcomeAction() %>" style="WIDTH: 275"/></td>
  </tr>
  <tr>
    <td><impact:validateDate
                type="text"
                name="dtDtApsOutcomeAction"
                label="Date"
                constraint="Date"
                conditionallyRequired="true"
                value="<%= FormattingHelper.formatDate( problemRow.getDtDtApsOutcomeAction() ) %>"
                size="8"
                tabIndex="<%= tabIndex++ %>" /></td>
  </tr>
<% // SIR 23530 - Comments boxes will only be available for non care items.
   if (!care)
   {
%>
  <tr>
    <td><impact:validateTextArea
                name="txtSzTxtApsOutcomeAction"
                colspan="3"
                label="Comments"
                rows="3"
                cols="75"
                maxLength="300"
                tabIndex="<%= tabIndex++ %>"
                constraint="Comments"><%= FormattingHelper.formatString( problemRow.getSzTxtApsOutcomeAction() ) %></impact:validateTextArea>
    </td>
  </tr>
<% } %>
</table>
<%
//*****************
//**** OUTCOME ****
//*****************
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
     <th colspan="4">Outcome</th>
  </tr>

  <tr>
    <td width="150"><impact:validateSelect
                label="Sub-Category"
                name="selSzCdApsOutcomeResult"
                tabIndex="<%= tabIndex++ %>"
                codesTable="<%= CodesTables.COUTCTYP %>"
                conditionallyRequired="true"
                blankValue="true"
                value="<%=FormattingHelper.formatString( problemRow.getSzCdApsOutcomeResult() ) %>" /></td>
  </tr>
  <tr>
    <td><impact:validateDate
                type="text"
                name="dtDtApsOutcomeRecord"
                label="Date"
                constraint="Date"
                value="<%= FormattingHelper.formatDate( problemRow.getDtDtApsOutcomeRecord()) %>"
                conditionallyRequired="true"
                size="8"
                tabIndex="<%= tabIndex++ %>" /></td>
  </tr>
<% // SIR 23530 - Comments boxes will only be available for non care items.
   if (!care)
   {
%>
  <tr>
    <td><impact:validateTextArea
                name="txtSzTxtApsOutcomeResult"
                colspan="3"
                label="Comments"
                rows="3"
                cols="75"
                maxLength="300"
                tabIndex="<%= tabIndex++ %>"
                constraint="Comments"><%=FormattingHelper.formatString( problemRow.getSzTxtApsOutcomeResult() )%></impact:validateTextArea>
    </td>
  </tr>
<% } %>
</table>


<br>
<% /* BEGIN: Outcome Matrix Detail Buttons */ %>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
        <tr>
           <td width="90%"><impact:ButtonTag
                       name="btnDelete"
                       img="btnDelete"
                       align="left"
                       form="frmAPSOutcomeMatrixDetail"
                       action="/investigation/OutcomeMatrix/deleteOutcomeMatrixDetail"
                       disabled='<%= "Y".equals(problemRow.getCIndApsOutcomeOrigFctr()) ? "true" : "false" %>'
                       editableMode="<%= EditableMode.EDIT %>"
                       restrictRepost="true"
                       tabIndex="<%= tabIndex++ %>"/></td>
           <td width="10%">
             <% if (!care) { %>
<% /* SIR 23937 - Removed If Statement that hid spell check button in MPS */ %>
              <impact:spellCheck
              formToSpellCheck="frmAPSOutcomeMatrixDetail"
              fieldsToSpellCheck="txtSzTxtApsOutcomeAction, txtSzTxtApsOutcomeResult"
              tabIndex="<%= tabIndex++ %>"/>
             <% } %>
           </td>
           <td width="10%"><impact:ButtonTag
                       name="btnSave"
                       img="btnSave"
                       align="right"
                       form="frmAPSOutcomeMatrixDetail"
                       action="/investigation/OutcomeMatrix/saveOutcomeMatrixDetail"
                       restrictRepost="true"
                       tabIndex="<%= tabIndex++ %>"/></td>
        </tr>
</table>
<%/* END: Buttons */%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
//************************
//**** FORM ENDS HERE ****
//************************
%>
