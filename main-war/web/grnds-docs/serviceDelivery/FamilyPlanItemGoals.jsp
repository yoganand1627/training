<%
//*--------------------------------------------------------------------------------
//*  JSP Name:     Family Plan Item Goals
//*  Created by:   Jason Rios
//*  Date Created: 02/05/03
//*
//*  Description:
//*  This JSP displays the Family Plan Item Goals for each area of concern.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
FamilyPlanValueBean familyPlanBean = null;
FamilyPlanItemValueBean familyPlanItemBean = null;
Map goalsToAreaOfConcernLookup = null;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

familyPlanBean = ( FamilyPlanValueBean )state.getAttribute( "familyPlanBean", request );
familyPlanItemBean = ( FamilyPlanItemValueBean )state.getAttribute( "familyPlanItemBean", request );

goalsToAreaOfConcernLookup = ( Map )state.getAttribute( "goalsToAreaOfConcernLookup", request );

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageModeConstants.VIEW;
if ( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}
%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
</script>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <a tabindex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
      <a tabindex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
    </td>
  </tr>
</table>

<%
//**********************************************
//**** FORM (FAMILY PLAN GOALS) STARTS HERE ****
//**********************************************
%>
<impact:validateForm
  name="frmFamilyPlanGoals"
  method="post"
  action="/serviceDelivery/FamilyPlan/displayFamilyPlanGoals"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <%
  // Iterate through the family plan items in the family plan bean to get
  // each area of concern. For each area of concern, display the area of
  // concern description, then display the each of the goals that apply.
  loopCounter = 0;
  Collection familyPlanItems = familyPlanBean.getFamilyPlanItemList();
  Iterator itemsIter = familyPlanItems.iterator();
  while ( itemsIter.hasNext() )
  {
    FamilyPlanItemValueBean itemBean = ( FamilyPlanItemValueBean )itemsIter.next();
    %>
    <tr>
      <td>
        <impact:ExpandableSectionTag
          name="<%= itemBean.getAreaOfConcernCode() %>"
          label="<%= itemBean.getAreaOfConcernText() %>"
          tabIndex="<%= tabIndex++ %>">

          <table border="0" cellpadding="3" cellspacing="0" width="100%" class="subDetail">
          <%
          // Display each goal.
          List goalsVector = ( List )goalsToAreaOfConcernLookup.get( itemBean.getAreaOfConcernCode() );
          Iterator goalsIter = goalsVector.iterator();
          while ( goalsIter.hasNext() )
          {
            String goalCode = ( String )goalsIter.next();
            String fieldName = "cbxGoals_" + loopCounter;
            String fieldValue = Lookup.simpleDecodeSafe( "CSPGOLLD", goalCode );
            %>
            <tr>
              <td valign="top">
                <impact:validateInput
                  label=""
                  name="<%= fieldName %>"
                  type="checkbox"
                  value="<%= fieldValue %>"
                  cssClass="formInput"
                  tabIndex="<%= tabIndex++ %>" />
              </td>
              <td valign="top">
                <impact:validateDisplayOnlyField
                  name="txtGoal"
                  label=""
                  value="<%= fieldValue %>" />
              </td>
            </tr>
            <%
            loopCounter++;
          } // end while ( goalsIter.hasNext() )
          %>
          </table>
        </impact:ExpandableSectionTag>
      </td>
    </tr>
  <%
  } // end while ( areaOfConcernIter.hasNext() )
  %>
</table>

<%
//*****************
//**** BUTTONS ****
//*****************
%>
<hr>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <impact:ButtonTag
        name="btnContinue"
        img="btnContinue"
        align="right"
        form="frmFamilyPlanGoals"
        action="/serviceDelivery/FamilyPlan/appendFamilyPlanGoals"
        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
//********************************************
//**** FORM (FAMILY PLAN GOALS) ENDS HERE ****
//********************************************
%>
