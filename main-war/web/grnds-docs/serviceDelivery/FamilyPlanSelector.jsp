<%
//*--------------------------------------------------------------------------
//*  JSP Name:     Family Plan Selector
//*  Created by:   Jason Rios
//*  Date Created: 06/04/03
//*
//*  Description:
//*  This JSP displays the list of approved Family Plans.
//*
//*  Change History:
//*  Date      User         Description
//*  --------  -----------  -------------------------------------------------
//*  06/23/04  RIOSJA       SIR 19002 - If the worker attempts to create an
//*                         evaluation in an older stage for a family plan
//*                         created in a newer stage, display a confirmation
//*                         message and notify them.
//*--------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
ArrayList approvedFamilyPlans = null;
FamilyPlanValueBean familyPlanBean = null;
/* RIOSJA, SIR 19002 */
CaseUtility.Stage currentStage = null;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

if ( state.getAttribute( "approvedFamilyPlans", request ) != null )
{
  approvedFamilyPlans = ( ArrayList )state.getAttribute( "approvedFamilyPlans", request );
}

/* RIOSJA, SIR 19002 */
if ( state.getAttribute( "currentStage", request ) != null )
{
  currentStage = (CaseUtility.Stage)state.getAttribute( "currentStage", request );
}

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
/*
** RIOSJA, SIR 19002 - If the worker attempts to create an evaluation
** in an older stage for a family plan created in a newer stage, display
** a confirmation message and notify them.
*/
function selectPlan( selectedFamilyPlanEventId, bPlanIsFromNewerStage )
{
  if( bPlanIsFromNewerStage )
  {
    if( confirm("<%= MessageLookup.getMessageByNumber( Messages.MSG_FP_IN_NEWER_STAGE ) %>") )
    {
      document.frmFamilyPlanList.selectedFamilyPlanEventId.value = selectedFamilyPlanEventId;
      setState('frmFamilyPlanList');
      setValidationUrl('frmFamilyPlanList', '/serviceDelivery/FamilyPlan/displayFamilyPlan');
      document.frmFamilyPlanList.submit();
    }
    return;
  }
  else
  {
    document.frmFamilyPlanList.selectedFamilyPlanEventId.value = selectedFamilyPlanEventId;
    setState('frmFamilyPlanList');
    setValidationUrl('frmFamilyPlanList', '/serviceDelivery/FamilyPlan/displayFamilyPlan');
    document.frmFamilyPlanList.submit();
  }
}

</script>

<impact:validateErrors/>

<impact:validateForm
  name="frmFamilyPlanList"
  method="post"
  action="/serviceDelivery/FamilyPlan/listFamilyPlansForEval"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateInput
  type="hidden"
  name="selectedFamilyPlanEventId"
  value=""/>

<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr class="formInstruct">
    <td>
      Select the plan you would like to evaluate.
    </td>
    <td>
      <div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div>
    </td>
  </tr>
</table>

<div id="scroll" style="width:767px; height:250px; overflow:auto" class="tableborderList">
  <table border="0" cellpadding="3" cellspacing="0" width="900">
    <tr class="thList">
      <td nowrap width="10%">Date Entered</td>
      <td nowrap width="8%">Status</td>
      <td nowrap width="10%">Type</td>
      <td nowrap width="35%">Description</td>
      <td nowrap width="20%">Entered By</td>
      <td nowrap width="10%">Event ID</td>
    </tr>
    <%
    // If there are approved family plans for the stage, list them. Otherwise,
    // display a "No records found" message.
    if ( approvedFamilyPlans != null &&
         approvedFamilyPlans.size() > 0 )
    {
      Iterator iter = approvedFamilyPlans.iterator();
      while ( iter.hasNext() )
      {
        familyPlanBean = ( FamilyPlanValueBean )iter.next();
        EventValueBean eventBean = familyPlanBean.getFamilyPlanEvent();
        %>
        <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
          <td><%= FormattingHelper.formatDate( eventBean.getDateEventOccurred() ) %></td>
          <td><%= eventBean.getEventStatusCode() %></td>
          <%
          // RIOSJA, SIR 19002 - If the worker attempts to create an
          // evaluation in an older stage for a family plan created in a
          // newer stage, display a confirmation message and notify them.
          String bPlanIsFromNewerStage = "false";
          if( currentStage.getDtStart() != null &&
              familyPlanBean.getDateStageStarted() != null &&
              DateHelper.isBefore( currentStage.getDtStart(), familyPlanBean.getDateStageStarted() ) )
          {
            bPlanIsFromNewerStage = "true";
          }
          %>
          <td><a href="JavaScript:selectPlan(<%= eventBean.getEventId() %>, <%=bPlanIsFromNewerStage%>);">Plan</a></td>
          <td><%= eventBean.getEventDescription() %></td>
          <td><%= eventBean.getCreatorsLastName() %>,&nbsp;<%= eventBean.getCreatorsFirstName() %></td>
          <td><%= eventBean.getEventId() %></td>
        </tr>
      <%
      loopCounter++;
      } // end while ( iter.hasNext )
    }
    else
    {%>
      <tr><td colspan="8"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %></td></tr>
    <%
    } // end if ( approvedFamilyPlans != null &&...
    %>
  </table>
</div>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
