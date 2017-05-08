<%--
  JSP Name:     Family Plan Permanency Goals
  Created by:   Jason Rios
  Date Created: 09/18/03

  Description:
  This JSP displays the Family Plan Permanency Goals for each child in the plan.

  Change History:
  Date      User              Description
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  //*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
  int loopCounter = 0;
  int tabIndex = 1;

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);

  FamilyPlanValueBean familyPlanBean = (FamilyPlanValueBean) state.getAttribute("familyPlanBean", request);
  List childrenInPlanInSubcare = (List) state.getAttribute("childrenInPlanInSubcare", request);
  String eventStatus = (String) request.getAttribute(FamilyPlanConversation.EVENT_STATUS_FIELD_NAME);

//*********************
//*** SET PAGE MODE ***
//*********************
  String pageMode = PageModeConstants.VIEW;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }
%>

<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
</script>

<impact:validateErrors/>

<%
  //*********************************************
//**** FORM (PERMANENCY GOALS) STARTS HERE ****
//*********************************************
%>
<impact:validateForm
        name="frmPermanencyGoals"
        method="post"
        action="/serviceDelivery/FamilyPlan/savePermanencyGoals"
        pageMode="<%= pageMode %>"
        schema="/WEB-INF/Constraints.xsd">

<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr>
    <th>Permanency Goals</th>
  </tr>
  <tr>
    <td>
      <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderList">
        <tr>
          <th class="thList">Name</th>
          <th class="thList">Permanency Goal</th>
          <th class="thList" width="30%">Target Date</th>
        </tr>
        <%
          if (childrenInPlanInSubcare.size() > 0) {
            // Iterate through the principals for then event and display
            // the children since only they will have a permanency goal.
            loopCounter = 0;
            Iterator iter = childrenInPlanInSubcare.iterator();
            while (iter.hasNext()) {
              PersonValueBean personBean = (PersonValueBean) iter.next();
        %>
        <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
          <td><%= personBean.getFullName() %></td>
          <td>
            <%
              // The child's person id will be used in the Permanency
              // Goal field name so that the field names will be unique
              // and easily associated with the child.
              String fieldName = "selPermGoal" + FormattingHelper.formatInt(personBean.getPersonId());
            %>
            <impact:validateSelect
                    name="<%= fieldName %>"
                    value="<%= FormattingHelper.formatString( personBean.getPermanencyGoalCode() ) %>"
                    codesTable="CCPPRMGL"
                    conditionallyRequired="true"
                    label=""
                    tabIndex="<%=tabIndex++%>"/>
          </td>
          <td>
              <%


              String dateAsString = "";
              if ( personBean.getPermanencyGoalTargetDate() != null )
              {
                dateAsString = FormattingHelper.formatDate( personBean.getPermanencyGoalTargetDate() );
              }

              // The child's person id will be used in the Target Date
              // field name so that the field names will be unique and
              // easily associated with the child.
              fieldName = "txtTargetDate" + FormattingHelper.formatInt(personBean.getPersonId());


              %>
              <impact:validateDate
                      label=""
                      name="<%= fieldName %>"
                      type="text"
                      value="<%= dateAsString %>"
                      size="10"
                      conditionallyRequired="true"
                      tabIndex="<%= tabIndex++ %>"
                      constraint="Date"/>
        </tr>
        <%
            loopCounter++;
          } // end while ( iter.hasNext() )
        } else {%>
        <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
          <td colspan="2">
            <%=MessageLookup.getMessageByNumber(Messages.MSG_FP_PERM_GOAL_NOT_REQ)%>
          </td>
        </tr>
        <%
          }
        %>
      </table>
    </td>
  </tr>
  <%
    if (childrenInPlanInSubcare.size() > 0) {%>
  <tr><td><br>Goal Comment, only if necessary:</td></tr>
  <tr>
    <td>
      <impact:validateTextArea
              name="txtPermanencyGoalsComment"
              colspan="1"
              rows="3"
              cols="148"
              tabIndex="<%= tabIndex++ %>"
              maxLength="500"
              constraint="Paragraph500">
        <%= FormattingHelper.formatString(familyPlanBean.getPermanencyGoalsComment()) %>
      </impact:validateTextArea>
    </td>
  </tr>
  <%
    }
  %>
</table>

<%
  //*****************
//**** BUTTONS ****
//*****************
%>

<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <%
        // Display the Save button only if children are listed on this page and
        // the event has not been approved; otherwise, display a Cancel button.
        if (childrenInPlanInSubcare.size() > 0 &&
            !CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {%>
      <impact:ButtonTag
              name="btnSave"
              img="btnSave"
              align="right"
              form="frmPermanencyGoals"
              action="/serviceDelivery/FamilyPlan/savePermanencyGoals"
              restrictRepost="true"
              preventDoubleClick="true"
              tabIndex="<%= tabIndex++ %>"/>
      <%
      } else {%>
      <impact:ButtonTag
              name="btnContinue"
              img="btnContinue"
              align="right"
              form="frmPermanencyGoals"
              action="/serviceDelivery/FamilyPlan/displayFamilyPlan"
              preventDoubleClick="true"
              editableMode="<%= EditableMode.ALL %>"
              tabIndex="<%= tabIndex++ %>"/>
      <%
        }
      %>
    </td>
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
  //********************************************
//**** FORM (PERMANENCY GOALS) ENDS HERE ****
//********************************************
%>
