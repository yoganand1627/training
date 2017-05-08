<%--
//*  JSP Name:     Income and Expenditures
//*  Created by:   Michael Werle
//*  Date Created: 03/05/2003
//*
//*  Description:
//*  This JSP is used to maintain Income and Expenditure data related to Federal Title IV-E Assistance
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/22/05  Todd Reser        SIR 23543 - Set an indicator if the Income Type is
//**                              SSI and they are in the Certified Group so
//**                              CustomValidation can throw an error message
//**  11/22/10  hjbaptiste        SMS#81144 - MR-053 Eligibility Changes. Added Allocation and Deeming sections
//**  01/05/11  hnguyen           SMS#89483: hide allocation/deeming section for NOC.
//**  01/10/11  hjbaptiste        SMS#86172: Replaced window.onload with window.attachEvent to get the ErrorList
//**                              to show up 
//**  01/12/11  hjbaptiste        SMS#90712: Calling setupAllocationSection()and setupDeemingSection() at the bottom
                                  of the page so that the elements will be available to the functions               
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.IncomeExpendituresDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.IncomeExpendituresConversation"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper" %>

<%String pageMode = PageMode.getPageMode(request);
UserProfile user = UserProfileHelper.getUserProfile(request);
String fceApplicationPageMode = (String)
    request.getAttribute(IncomeExpendituresConversation.FCE_APPLICATION_PAGE_MODE);

      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      IncomeExpendituresDB incomeExpendituresDB = (IncomeExpendituresDB) state
                                                                              .getAttribute(
                                                                                            IncomeExpendituresConversation.INCOME_EXPENDITURES_DB_KEY,
                                                                                            request);
      List<Option> aUMembersOptionsList = (List<Option>) state.getAttribute("aUMembersOptionsList", request);
      List<Option> nonAUMembersOptionsList = (List<Option>) state.getAttribute("nonAUMembersOptionsList", request);                                                                                             

      int tabIndex = 1;
      int loopCount = 0;
      String radioWidth = "7%";
      boolean indSSIForChild = false;
%>

<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.onbeforeunload = function ()
{
  IsDirty();
};

function showDhsWorkerNotified()
{
  var workerNotified = document.getElementById( "dhsWorkerNotified" );
  workerNotified.style.display = 'block';
}

function hideDhsWorkerNotified()
{
  var x = document.frmIncomeExpenditures;
  var workerNotified = document.getElementById( "dhsWorkerNotified" );
  workerNotified.style.display = 'none';
  x.<%= IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER %>[0].checked = false;
  x.<%= IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER %>[1].checked = true;
  x.<%=IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST%>.value = '';
  x.<%=IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_MIDDLE%>.value = '';
  x.<%=IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST%>.value = '';
  x.<%= IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN %>.value = '';
  x.<%=IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING%>.value = '';
}

function showCostCareExceedSection()
{
  var childCostCareExceed = document.getElementById( "costCareExceed" );
  childCostCareExceed.style.display = 'block';
}

function hideCostCareExceedSection()
{
  var x = document.frmIncomeExpenditures;
  var childCostCareExceed = document.getElementById( "costCareExceed" );
  childCostCareExceed.style.display = 'none';
}

function setupAllocationSection()
{
  // Display the correct rows and blank out the selected/entered data in the 
  // related fields based on the Allocation Type
  var x = document.frmIncomeExpenditures;
  var allocType = '';
<%
if ((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus())))) {
%> 
  allocType = x.<%=IncomeExpendituresDB.CD_ALLOC_TYPE%>.value;
<%
} else {
%>
  allocType = x.<%=IncomeExpendituresDB.CD_ALLOC_TYPE%>[x.<%=IncomeExpendituresDB.CD_ALLOC_TYPE%>.selectedIndex].value;
<%
}
%>
  var allocSingleMultiple = document.getElementById( "allocSingleMultiple" );
  var allocMutual = document.getElementById( "allocMutual" );
  var allocMultiple = document.getElementById( "allocMultiple" );
 
  // Single Parent Allocation
  if ('SGLP' == allocType) {       
    allocSingleMultiple.style.display = 'block';
    allocMutual.style.display = 'none';
    allocMultiple.style.display = 'none';  
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL%>.value = '';
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2%>.value = '';
  } 
  // Mutual Parents Allocation
  else if ('MUTP' == allocType) {
    allocSingleMultiple.style.display = 'none';
    allocMutual.style.display = 'block';
    allocMultiple.style.display = 'none';  
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1%>.value = '';
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2%>.value = '';
  }
  // Multiple Parents Allocation
  else if ('MULP' == allocType) {
    allocSingleMultiple.style.display = 'block';
    allocMutual.style.display = 'none';
    allocMultiple.style.display = 'block';  
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL%>.value = '';
  } 
  // Mutual Parents and Single Parent Allocation
  else if ('MSGL' == allocType) {
    allocSingleMultiple.style.display = 'block';
    allocMutual.style.display = 'block';
    allocMultiple.style.display = 'none';  
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2%>.value = '';
  }
  // Mutual Parents and Multiple Parents Allocation
  else if ('MMUL' == allocType) {
    allocSingleMultiple.style.display = 'block';
    allocMutual.style.display = 'block';
    allocMultiple.style.display = 'block';  
  } 
  // No selection has been made. Blank/hide all of the fields
  else {
    allocSingleMultiple.style.display = 'none';
    allocMutual.style.display = 'none';
    allocMultiple.style.display = 'none'; 
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1%>.value = '';
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL%>.value = '';
    x.<%=IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2%>.value = '';
  }
}

function setupDeemingSection()
{
  var x = document.frmIncomeExpenditures;
  var deemType = '';
  <%
if ((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus())))) {
%> 
  deemType = x.<%=IncomeExpendituresDB.CD_DEEM_RESP_TYPE%>.value;
<%
} else {
%>
  deemType = x.<%=IncomeExpendituresDB.CD_DEEM_RESP_TYPE%>[x.<%=IncomeExpendituresDB.CD_DEEM_RESP_TYPE%>.selectedIndex].value;
<%
}
%>
  var deemIndiv1Label = document.getElementById( "deemIndiv1Label" );
  var deemIndiv1 = document.getElementById( "deemIndiv1" );
  var deemIndiv2Label = document.getElementById( "deemIndiv2Label" );
  var deemIndiv2 = document.getElementById( "deemIndiv2" );
  var rowNbrDeemChildNotInAU = document.getElementById( "rowNbrDeemChildNotInAU" );
  var rowNbrDeemTaxDependNotInAU = document.getElementById( "rowNbrDeemTaxDependNotInAU" );
  var rowNbrDeemResponseIndiv = document.getElementById( "rowNbrDeemResponseIndiv" );
  var rowAmtDeemTaxDependOutHh = document.getElementById( "rowAmtDeemTaxDependOutHh" );
  var rowAmtDeemAlimonyOutsideHh = document.getElementById( "rowAmtDeemAlimonyOutsideHh" );

    // One Responsible Individual deeming. Hide the second person responsible for deeming 
    // and blank out the selected/entered data in the related fields
  if ('ONE' == deemType) {
    deemIndiv1Label.style.display = 'block';
    deemIndiv1.style.display = 'block';   
    deemIndiv2Label.style.display = 'none';
    deemIndiv2.style.display = 'none';
    rowNbrDeemChildNotInAU.style.display = 'block';  
    rowNbrDeemTaxDependNotInAU.style.display = 'block';  
    rowNbrDeemResponseIndiv.style.display = 'block';  
    rowAmtDeemTaxDependOutHh.style.display = 'block';  
    rowAmtDeemAlimonyOutsideHh.style.display = 'block';  
    x.<%=IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.CD_DEEM_INDIV_REL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV%>.value = '1';
  } 
  // Two Responsible Individuals deeming. Show the second person responsible for deeming 
    // and the related fields
  else if ('TWO' == deemType) {
    deemIndiv1Label.style.display = 'block';
    deemIndiv1.style.display = 'block';   
    deemIndiv2Label.style.display = 'block';
    deemIndiv2.style.display = 'block';
    rowNbrDeemChildNotInAU.style.display = 'block';  
    rowNbrDeemTaxDependNotInAU.style.display = 'block';  
    rowNbrDeemResponseIndiv.style.display = 'block';  
    rowAmtDeemTaxDependOutHh.style.display = 'block';  
    rowAmtDeemAlimonyOutsideHh.style.display = 'block';
    x.<%=IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV%>.value = '2';  
  }
  // No selection is made. Hide both persons responsible for deeming 
  // and blank out the selected/entered data in all of the fields
  else {
    deemIndiv1Label.style.display = 'none';
    deemIndiv1.style.display = 'none';   
    deemIndiv2Label.style.display = 'none';        
    deemIndiv2.style.display = 'none';
    rowNbrDeemChildNotInAU.style.display = 'none';
    rowNbrDeemTaxDependNotInAU.style.display = 'none';
    rowNbrDeemResponseIndiv.style.display = 'none';
    rowAmtDeemTaxDependOutHh.style.display = 'none';
    rowAmtDeemAlimonyOutsideHh.style.display = 'none';
    x.<%=IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.CD_DEEM_INDIV_REL_2%>.selectedIndex = 0;
    x.<%=IncomeExpendituresDB.NBR_DEEM_CHILD_NOT_IN_AU%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_DEEM_TAX_DEPEND_NOT_IN_AU%>.value = '';
    x.<%=IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV%>.value = '';
    x.<%=IncomeExpendituresDB.AMT_DEEM_TAX_DEPEND_OUT_HH%>.value = '';
    x.<%=IncomeExpendituresDB.AMT_DEEM_ALIMONY_OUTSIDE_HH%>.value = '';
  }
}

function emptyQuestions()
{
  var x = document.frmIncomeExpenditures;
  x.<%=IncomeExpendituresDB.IND_OUT_HOME_CARE%>.value = '';
  x.<%=IncomeExpendituresDB.IND_EMANCIPATION%>.value = '';
  x.<%=IncomeExpendituresDB.IND_ADOPTION%>.value = '';
}

function navigateToPersonDetail(idPerson)
{
  setIsDirtyCalled(true);
  frmIncomeExpenditures.<%=IncomeExpendituresConversation.ID_PERSON_SELECTED%>.value = idPerson;
  disableValidation('frmIncomeExpenditures');
  submitValidateForm('frmIncomeExpenditures', '<%=IncomeExpendituresConversation.DISPLAY_PERSON_DETAIL_COMMAND%>');
  return false;
}
</script>

<impact:validateErrors formName="frmIncomeExpenditures" />
<impact:validateForm name="frmIncomeExpenditures" method="post" validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.IncomeExpendituresCustomValidation" action="/fce/IncomeExpenditures/displayIncomeExpenditures" schema="/WEB-INF/Constraints.xsd"
  redisplayParameters="true" pageMode="<%= pageMode %>" onSubmit="if (this.submitted) return false; this.submitted = true; return true" >
  <impact:validateInput type="hidden" name="<%=IncomeExpendituresConversation.ID_PERSON_SELECTED%>" />
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th>
        Received Income Assistance at Time of Removal
      </th>
    </tr>
    <tr>
      <td>
        Removal Date: <b><%=incomeExpendituresDB.getDtRemovalDateString()%></b>
      </td>
    </tr>
    <tr>
      <td>
        <table border="0" cellspacing="0" cellpadding="0" width="100%">
          <tr>
            <td width="<%= radioWidth %>">
              <impact:validateInput type="radio" label="Yes" name="<%=IncomeExpendituresDB.IND_INCOME_ASSISTANCE%>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>" onClick="showDhsWorkerNotified()"
                checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndIncomeAssistanceString()) %>' />
            </td>
            <td width="<%= radioWidth %>">
              <impact:validateInput type="radio" label="No" onClick="hideDhsWorkerNotified()" name="<%=IncomeExpendituresDB.IND_INCOME_ASSISTANCE%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
                checked='<%= "" +
       ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndIncomeAssistanceString()) %>' />
            </td>
            <td>
              Did the child receive Income Assistance during that month? (TANF, Food Stamps, Medicaid)
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td>
        <div id="dhsWorkerNotified" style="display:none">
          <table border="0" cellspacing="0" cellpadding="0" width="100%">
            <tr>
              <td width="<%= radioWidth %>">
                <impact:validateInput type="radio" label="Yes" name="<%= IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER %>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
                  onClick="javascript:expandCollapsed('expandednotifiedInformation', 'collapsednotifiedInformation');" checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndNotifiedDhsWorkerString()) %>' />
              </td>
              <td width="<%= radioWidth %>">
                <impact:validateInput type="radio" label="No" name="<%=IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
                  onClick="javascript:collapseExpanded('expandednotifiedInformation', 'collapsednotifiedInformation');" checked='<%= "" +
       ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndNotifiedDhsWorkerString()) %>' />
              </td>
              <td>
                Was the Family Independence Case Manager notified of child's removal from the home?
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <impact:ExpandableSectionTag name="notifiedInformation" tabIndex="<%= tabIndex++ %>" isExpanded="<%= incomeExpendituresDB.getIndNotifiedDhsWorker() %>" label="Family Independence Case Manager Notified Information">
                  <table cellPadding="3" cellSpacing="0" width="100%" class="tableBorder">
                    <tr class="subDetail">
                      <td>
                        <impact:validateInput type="text" name="<%=IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST%>" size="12" maxLength="12" constraint="Name12" tabIndex="<%=tabIndex++%>" label="First" conditionallyRequired="true"
                          value="<%=incomeExpendituresDB.getNmNotifiedDhsWrkrFirst()%>" />
                      </td>
                      <td>
                        <impact:validateInput type="text" name="<%=IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_MIDDLE%>" size="12" maxLength="12" constraint="Name12" tabIndex="<%=tabIndex++%>" label="Middle" value="<%=incomeExpendituresDB.getNmNotifiedDhsWrkrMiddle()%>" />
                      </td>
                      <td>
                        <impact:validateInput type="text" name="<%=IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST%>" size="22" maxLength="22" constraint="Name22" tabIndex="<%=tabIndex++%>" label="Last" conditionallyRequired="true"
                          value="<%=incomeExpendituresDB.getNmNotifiedDhsWrkrLast()%>" />
                      </td>
                    </tr>
                    <tr class="subDetail">
                      <td>
                        <impact:validateInput type="text" name="<%= IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN %>" size="14" maxLength="14" constraint="Phone" tabIndex="<%=tabIndex++%>" label="Phone Number"
                          value="<%=FormattingHelper.formatPhone(incomeExpendituresDB.getNbrNotifiedDhsWrkrPhn())%>" />
                      </td>
                      <td colspan="2">
                        &nbsp;
                      </td>
                      <td>
                        <impact:validateDate name="<%=IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING%>" size="10" constraint="Date" tabIndex="<%=tabIndex++%>" label="Date Notified" conditionallyRequired="true"
                          value="<%=incomeExpendituresDB.getDtNotifiedWorkerString()%>" />
                      </td>
                    </tr>
                  </table>
                </impact:ExpandableSectionTag>
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
  </table>
  <br />
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th>
        Income for Child
      </th>
    </tr>
    <tr>
      <td>
        <%request.setAttribute("tabIndex", tabIndex);

      request.setAttribute("disableRadios", "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request));

      request.setAttribute("disableNoIncome", "false");
      request.setAttribute("incomeList", incomeExpendituresDB.getIncomeForChild());
      request.setAttribute("baseNameSuffix", IncomeExpendituresConversation.CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE);
      List incomeForChildList = incomeExpendituresDB.getIncomeForChild();
      if (incomeForChildList != null) {
        Iterator incomeForChildIterator = incomeForChildList.iterator();
        while (incomeForChildIterator.hasNext()) {
          FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeForChildIterator.next();
          //Set an indicator if the Income Type is SSI
          if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType())) {
           indSSIForChild= true;
           //STGAP00004272  - Set an indicator if the Income Type is SSI and the child is in the
           //Certified Group(Assistance Unit) so CustomValidation can throw an error message
           if (fceIncomeDB.getIndCertifiedGroup()) {%>
                <impact:validateInput type="hidden" name="indSSI" value="true" />
           <%  }
           break;
          }
          
        }
      }
      %>
        <%@ include file="/grnds-docs/fce/IncomeListSub.jsp"%>
        <%tabIndex = (Integer) request.getAttribute("tabIndex");

      %>
      </td>
    </tr>
  </table>
  <br />
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">
        Income for Family
      </th>
    </tr>
    <tr>
      <td colspan="2">
        <div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
          <table width="100%" cellspacing="0" cellpadding="3" border="0">
            <tr>
              <th class="thList">
                Name
              </th>
              <th class="thList">
                Relationship
                <br />
                to Child
              </th>
              <th class="thList">
                Age
              </th>
              <th class="thList">
                Type
              </th>
              <th class="thList">
                Amount
              </th>
              <th class="thList">
                Source
              </th>
              <th class="thList">
                No
                <br />
                Income
              </th>
              <th class="thList">
                Earned/
                <br />
                Unearned
              </th>
              <th class="thList">
                Countable/
                <br />
                Exempt
              </th>
            </tr>
            <%List incomeForFamilyList = incomeExpendituresDB.getIncomeForFamily();
      loopCount = 0;
      if (incomeForFamilyList == null) {
%>
            <tr class="odd">
              <td colspan="9">
                <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
              </td>
            </tr>
            <%} else {
        Iterator incomeForFamilyIterator = incomeForFamilyList.iterator();
        while (incomeForFamilyIterator.hasNext()) {
          FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeForFamilyIterator.next();
          String nameSuffix = IncomeExpendituresConversation.FAMILY_INCOME_CONTROL_NAME_SUFFIX_BASE + loopCount;

          //copied from AppAndBG.jsp
          String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", fceIncomeDB.getCdRelInt());
          if ("".equals(relationDecode)) {
            relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", fceIncomeDB.getCdRelInt());
          }
%>
            <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>">
              <td>
                <a tabIndex="<%=tabIndex++%>" href="javascript:navigateToPersonDetail(<%=fceIncomeDB.getIdPerson() %>)" onclick="setIsDirtyCalled(true)"> <%=fceIncomeDB.getNmPersonFull()%> </a>
              </td>
              <td>
                <%=relationDecode%>
              </td>
              <td>
                <%=fceIncomeDB.getNbrAgeString()%>
              </td>
              <td>
                <%//SIR 23543 - Set an indicator if the Income Type is SSI and they are in the
          //Certified Group so CustomValidation can throw an error message
          if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType()) && fceIncomeDB.getIndCertifiedGroup()) {%>
                <impact:validateInput type="hidden" name="indSSI" value="true" />
                <%}%>
                <%=Lookup.simpleDecodeSafe(CodesTables.CINC, fceIncomeDB.getCdType())%>
              </td>
              <td>
                <%=FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome())%>
              </td>
              <td>
                <%=fceIncomeDB.getTxtSource()%>
              </td>
              <td>
                <impact:validateInput type="checkbox" name="<%=FceIncomeDB.IND_NONE + nameSuffix%>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>" disabled='<%= "" + (fceIncomeDB.getAmtIncome() != 0) %>'
                  checked='<%= "" + fceIncomeDB.getIndNone() %>' />
              </td>
              <td>
                <table width="100%" cellspacing="0" cellpadding="0" border="0">
                  <tr>
                    <td>
                      <impact:validateInput type="radio" label="Earned" name="<%=FceIncomeDB.IND_EARNED + nameSuffix%>" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) %>' value="<%=ArchitectureConstants.TRUE%>"
                        tabIndex="<%=tabIndex++%>" checked='<%= "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndEarnedString()) %>' />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <impact:validateInput type="radio" label="Unearned" name="<%=FceIncomeDB.IND_EARNED + nameSuffix%>" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) %>' value="<%=ArchitectureConstants.FALSE%>"
                        tabIndex="<%=tabIndex++%>" checked='<%= "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndEarnedString()) %>' />
                    </td>
                  </tr>
                </table>
              </td>
              <td>
                <table width="100%" cellspacing="0" cellpadding="0" border="0">
                  <tr>
                    <td>
                      <impact:validateInput type="radio" label="Countable" name="<%=FceIncomeDB.IND_COUNTABLE + nameSuffix%>" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) %>' value="<%=ArchitectureConstants.TRUE%>"
                        tabIndex="<%=tabIndex++%>" checked='<%= "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) %>' />
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <impact:validateInput type="radio" label="Exempt" name="<%=FceIncomeDB.IND_COUNTABLE + nameSuffix%>" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) %>' value="<%=ArchitectureConstants.FALSE%>"
                        tabIndex="<%=tabIndex++%>" checked='<%= "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) %>' />
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
            <%loopCount++;
        }
      }
%>
          </table>
        </div>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        If the family has $0 monthly income, explain how the family's monthly living expenses including housing, food and, clothing are met. Case Manager should use best judgment based on observation of the home environment and social history to
        determine how the family's needs are being met. (For example, do they receive government benefits or cash contributions from someone outside the home, or does someone else they live with provide their living expenses.) Comments:
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_NO_INCOME_EXPLANATION%>" cols="145" rows="2" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
          <%=incomeExpendituresDB.getTxtNoIncomeExplanation()%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        Specify how the family's and child's income(s) were determined:
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_INCOME_DTRMNTN_COMMENTS%>" cols="145" rows="2" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
          <%=incomeExpendituresDB.getTxtIncomeDtrmntnComments()%>
        </impact:validateTextArea>
      </td>
    </tr>
    <%if (Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request)) {
%>
    <tr>
      <td width="30%">
        Total Living in the Removal Home:
      </td>
      <td width="70%">
        <%=incomeExpendituresDB.getNbrLivingAtHomeString()%>
      </td>
    </tr>
    <tr>
      <td>
        Total Number in Assistance Unit (AU):
      </td>
      <td>
        <%=incomeExpendituresDB.getNbrCertifiedGroupObject() != null ? incomeExpendituresDB.getNbrCertifiedGroupString() : "0"%>
      </td>
    </tr>
    <%}

      %>
  </table>
  <br />
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th>
        Resources for Child
      </th>
    </tr>
    <tr>
      <td>
        <%request.setAttribute("tabIndex", tabIndex);

      request.setAttribute("disableRadios", "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request));

      request.setAttribute("resourcesList", incomeExpendituresDB.getResourcesForChild());
      request.setAttribute("baseNameSuffix", IncomeExpendituresConversation.CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE);

      %>
        <%@ include file="/grnds-docs/fce/ResourceListSub.jsp"%>
        <%tabIndex = (Integer) request.getAttribute("tabIndex");

      %>
      </td>
    </tr>   
  </table>
  <br />
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th>
        Resources for Family
      </th>
    </tr>
    <tr>
      <td>
        <%request.setAttribute("tabIndex", tabIndex);

      request.setAttribute("disableRadios", "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request));

      request.setAttribute("resourcesList", incomeExpendituresDB.getResourcesForFamily());
      request.setAttribute("baseNameSuffix", IncomeExpendituresConversation.FAMILY_RESOURCE_CONTROL_NAME_SUFFIX_BASE);

      %>
        <%@ include file="/grnds-docs/fce/ResourceListSub.jsp"%>
        <%tabIndex = (Integer) request.getAttribute("tabIndex");

      %>
      </td>
    </tr>
  <%if (indSSIForChild == true){ %>
    <tr>
      <td>
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
          <tr>
            <th>
              Child's Cost of Care
            </th>
          </tr>
          <tr>
            <td>
              <impact:validateInput type="radio" label="Yes" name="<%= IncomeExpendituresDB.IND_CHILD_CARE %>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>" onClick="showCostCareExceedSection();"
                checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndChildCareString()) %>' />
              &nbsp;
              <impact:validateInput type="radio" label="No" name="<%=IncomeExpendituresDB.IND_CHILD_CARE%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>" onClick="hideCostCareExceedSection(); emptyQuestions();"
                checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndChildCareString()) %>' />
              &nbsp; Does the child's cost of care exceed $853.00?
            </td>
          </tr>
          <tr>
            <td>
              <div id="costCareExceed" style="display:none">
                <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
                  <tr class="subDetail">
                    <td>
                      <impact:validateInput type="radio" label="Yes" name="<%= IncomeExpendituresDB.IND_OUT_HOME_CARE %>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
                        checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndOutOfHomeCareString()) %>' />
                      &nbsp;
                      <impact:validateInput type="radio" label="No" name="<%=IncomeExpendituresDB.IND_OUT_HOME_CARE%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
                        checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndOutOfHomeCareString()) %>' />
                      &nbsp; Is the child expected to be in out-of-home care for a short period of time?
                  </tr>
                  <tr class="subDetail">
                    <td>
                      <impact:validateInput type="radio" label="Yes" name="<%= IncomeExpendituresDB.IND_EMANCIPATION %>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
                        checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndEmancipationString()) %>' />
                      &nbsp;
                      <impact:validateInput type="radio" label="No" name="<%=IncomeExpendituresDB.IND_EMANCIPATION%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
                        checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndEmancipationString()) %>' />
                      &nbsp; Is the child approaching emancipation?
                  </tr>
                  <tr class="subDetail">
                    <td>
                      <impact:validateInput type="radio" label="Yes" name="<%= IncomeExpendituresDB.IND_ADOPTION %>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
                        checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndAdoptionString()) %>' />
                      &nbsp;
                      <impact:validateInput type="radio" label="No" name="<%=IncomeExpendituresDB.IND_ADOPTION%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
                        checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndAdoptionString()) %>' />
                      &nbsp; Is the child in the process of being adopted?
                  </tr>
                </table>
              </div>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <%}%>
    <tr>
      <td>
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
          <tr>
            <th>
              Child Care/Disabled Adult Care Section
            </th>
          </tr>
          <tr>
            <td>
              <impact:validateInput type="radio" label="Yes" name="<%= IncomeExpendituresDB.IND_PAY_FOR_CARE %>" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
                onClick="javascript:expandCollapsed('expandedexpendituresInformation', 'collapsedexpendituresInformation');" checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndPayForCareString()) %>' />
              &nbsp;
              <impact:validateInput type="radio" label="No" name="<%=IncomeExpendituresDB.IND_PAY_FOR_CARE%>" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
                onClick="javascript:collapseExpanded('expandedexpendituresInformation', 'collapsedexpendituresInformation');" checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndPayForCareString()) %>' />
              &nbsp; Does anyone working in the removal home, pay for child care or for the care of a disabled adult living in the removal home?
          </tr>
          <tr>
            <td colspan="3">
              <impact:ExpandableSectionTag name="expendituresInformation" tabIndex="<%= tabIndex++ %>" isExpanded="<%= incomeExpendituresDB.getIndPayForCare() %>" label="Expenditures Information">
                <table cellPadding="3" cellSpacing="0" width="100%" class="tableBorder">
                  <tr>
                    <th class="thList">
                      Person Responsible for Payment
                    </th>
                    <th class="thList">
                      Person Receiving Care
                    </th>
                    <th class="thList">
                      Service Provider Name
                    </th>
                    <th class="thList">
                      Monthly Amount Paid
                    </th>
                  </tr>
                  <%List principals = incomeExpendituresDB.getPrincipals();
      List personNameList = new ArrayList();
      List personCareReceiveNameList = new ArrayList();
      for (int i = 0; i < principals.size(); i++) {
        FcePersonDB principal = (FcePersonDB) principals.get(i);
        personNameList.add(new Option(String.valueOf(principal.getIdPerson()), principal.getNmPersonFull()));
        personCareReceiveNameList.add(new Option(String.valueOf(principal.getIdPerson()), principal.getNmPersonFull()));
      }

      List expendituresList = incomeExpendituresDB.getExpenditures();
      FceExpendituresDB fceExpendituresArray[] = new FceExpendituresDB[5];
      if (!expendituresList.isEmpty() && expendituresList != null) {
        int count = 0;
        Iterator expendituresIterator = expendituresList.iterator();
        while (expendituresIterator.hasNext()) {
          FceExpendituresDB fceExpendituresDB = (FceExpendituresDB) expendituresIterator.next();
          fceExpendituresArray[count] = fceExpendituresDB;
          count++;
        }
      }
      for (int i = 0; i < 5; i++) {
        String principalsId = IncomeExpendituresDB.PRINCIPALS + i;
        String personCareReceiveId = IncomeExpendituresDB.ID_PERSON_CARE_RECEIVE + i;
        String nmServiceProviderId = FceExpendituresDB.NM_SERVICE_PROVIDER + i;
        String amtPdMonthlyId = FceExpendituresDB.AMT_PD_MONTHLY + i;
        if (fceExpendituresArray[i] != null) {
      %>
									<tr class="subDetail">
										<td>
											<impact:validateSelect name="<%=principalsId%>" options="<%=personNameList%>" blankValue="true" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatLong(fceExpendituresArray[i].getIdPerson())%>" style="WIDTH: 180px" />
										</td>
										<td>
											<impact:validateSelect name="<%=personCareReceiveId%>" options="<%=personCareReceiveNameList%>" blankValue="true" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatLong(fceExpendituresArray[i].getIdPersonCareReceive())%>" style="WIDTH: 180px" />
										</td>
										<td>
											<impact:validateInput type="text" name="<%=nmServiceProviderId%>" size="40" maxLength="40" constraint="Paragraph40" tabIndex="<%=tabIndex++%>" value="<%=fceExpendituresArray[i].getNmServiceProvider()%>" />
										</td>
										<td>
											<impact:validateInput type="text" name="<%=amtPdMonthlyId%>" size="13" maxLength="13" constraint="Money11" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatMoney(fceExpendituresArray[i].getAmtPdMonthly())%>" />
										</td>
									</tr>
									 
									<%} else {
         %>
									<tr class="subDetail">
										<td>
											<impact:validateSelect name="<%=principalsId%>" options="<%=personNameList%>" blankValue="true" tabIndex="<%=tabIndex++%>" style="WIDTH: 180px" />
										</td>
										<td>
											<impact:validateSelect name="<%=personCareReceiveId%>" options="<%=personCareReceiveNameList%>" blankValue="true" tabIndex="<%=tabIndex++%>" style="WIDTH: 180px" />
										</td>
										<td>
											<impact:validateInput type="text" name="<%=nmServiceProviderId%>" size="40" maxLength="40" constraint="Paragraph40" tabIndex="<%=tabIndex++%>" value=" " />
										</td>
										<td>
											<impact:validateInput type="text" name="<%=amtPdMonthlyId%>" size="13" maxLength="13" constraint="Money11" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatMoney(0)%>" />
										</td>
									</tr>
									<%}

      }%>
                </table>
              </impact:ExpandableSectionTag>
            </td>
          </tr>
        </table>
      </td>
    </tr>
	</table>
	<br />
	
<!--- Begin Allocation and Deeming Table --->
<%
String bDisabled = "" + PageModeConstants.VIEW.equals(fceApplicationPageMode);
if (((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus()))) ||
     ((user.hasRight(UserProfile.SEC_ELIGIBILITY)) &&
      ((EventHelper.PENDING_EVENT.equals(incomeExpendituresDB.getCdEventStatus())) ||
       (EventHelper.COMPLETE_EVENT.equals(incomeExpendituresDB.getCdEventStatus())))))
       && "A".equals(incomeExpendituresDB.getCdApplication()))
{
%>
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
          <tr>
            <th colspan="4"  class="thList">
              Determination of Standard Of Need for Allocation Budget
            </th>
          </tr>
          <tr>
            <td colspan="4">
              Use this section when one or more members of the AU is allocationg money to individual(s) who are not eligibible to be part of the AU but were in the removal home at the time of  removal. All AU Members and at least one spouse or one child is required for each row if an Allocation Type is selected.
            </td>
          </tr>
          <tr>
		    <td>
		    <impact:validateSelect label="Allocation Type" name="<%= IncomeExpendituresDB.CD_ALLOC_TYPE %>" orderBy="decode" codesTable="CALOCTYP" onChange="setupAllocationSection()" value="<%=incomeExpendituresDB.getCdAllocType() %>" tabIndex="<%=tabIndex++%>" />
		    </td>
		    <td colspan="2"></td>
          </tr>
          <tr>
            <td colspan="2">AU Member responsible for Allocation</td>
			<td>Number of Ineligible Spouse</td>
			<td>Number of Ineligible Child(ren)</td>
          </tr> 
          <tr id="allocMutual" style="display: none">
			       <td rowspan="2"  colspan="2">
			  		 <impact:validateSelect name="<%= IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1 %>" options="<%=aUMembersOptionsList%>" blankValue="true"  value="<%=incomeExpendituresDB.getIdPersonAllocMutual1String() %>" tabIndex="<%=tabIndex++%>" /><br>
					 <impact:validateSelect name="<%= IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2 %>" options="<%=aUMembersOptionsList%>" blankValue="true"  value="<%=incomeExpendituresDB.getIdPersonAllocMutual2String() %>" tabIndex="<%=tabIndex++%>" />
				   </td>
			  	   <td>   
			  	     <impact:validateInput type="text" label="" name="<%= IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrIneligSpouseAllocMutualObject() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligSpouseAllocMutual() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
			       </td>
			       <td>
			         <impact:validateInput type="text" label="" name="<%= IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrIneligChildAllocMutualObject() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligChildAllocMutual() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
			       </td>
		  <tr>
			       <td colspan="2"></td>
		  </tr>
		  <tr id="allocSingleMultiple" style="display: none">
                   <td colspan="2">
                     <impact:validateSelect name="<%= IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1 %>" options="<%=aUMembersOptionsList%>" blankValue="true" value="<%=incomeExpendituresDB.getIdPersonAllocSngl1String() %>" tabIndex="<%=tabIndex++%>" />
                   </td>
			       <td>
			         <impact:validateInput type="text" label="" name="<%= IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1 %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrIneligSpouseAllocSngl1Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligSpouseAllocSngl1() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
			       </td>
                   <td>
                     <impact:validateInput type="text" label="" name="<%= IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1 %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrIneligChildAllocSngl1Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligChildAllocSngl1() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
                   </td>
          </tr>
	      <tr id="allocMultiple" style="display: none">
			  	   <td colspan="2">
                     <impact:validateSelect name="<%= IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2 %>" options="<%=aUMembersOptionsList%>" blankValue="true"  value="<%=incomeExpendituresDB.getIdPersonAllocSngl2String() %>" tabIndex="<%=tabIndex++%>" />
                   </td>
			       <td>
			         <impact:validateInput type="text" label="" name="<%= IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2 %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrIneligSpouseAllocSngl2Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligSpouseAllocSngl2() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
			       </td>
                   <td>
                     <impact:validateInput type="text" label="" name="<%= IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2 %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrIneligChildAllocSngl2Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligChildAllocSngl2() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
                   </td>
          </tr>
      </table>
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
          <tr>
            <th colspan="4">
              Determination Of Standard Of Need for Deeming Budget
            </th>
          </tr>
          <tr>
            <td colspan="4">
              Use this section when one or more responsible individuals, who is not part of the AU but were in the removal home at the time of  removal, is deeming money to the AU. The whole section is required if a Deeming Type is selected.
            </td>
          </tr>
          <tr>
      <td>
         <impact:validateSelect name="<%= IncomeExpendituresDB.CD_DEEM_RESP_TYPE %>" label="1. Deeming Type" orderBy="decode" codesTable="CDEEMTYP" onChange="setupDeemingSection()" value="<%=incomeExpendituresDB.getCdDeemRespType() %>" tabIndex="<%=tabIndex++%>" />
    </td>
    <td colspan="2"></td>
  </tr>
  <tr id="deemIndiv1Label" style="display: none">
     <td colspan="3">Select the Responsible Individual whose income is deemed into the AU</td>
    <td>Relationship</td>
  </tr>
  <tr id="deemIndiv1" style="display: none">
  <td colspan="3">
    <impact:validateSelect name="<%= IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_1 %>" options="<%=nonAUMembersOptionsList%>" blankValue="true"  value="<%=incomeExpendituresDB.getIdPersonDeemIndiv1String() %>" tabIndex="<%=tabIndex++%>" />
  </td>
  <td>
    <impact:validateSelect name="<%= IncomeExpendituresDB.CD_DEEM_INDIV_REL_1 %>" orderBy="decode" codesTable="CDEEMREL" value="<%=incomeExpendituresDB.getCdDeemIndivRel1() %>" tabIndex="<%=tabIndex++%>" />
  </td>
  </tr>
  <tr id="deemIndiv2Label" style="display: none">
     <td colspan="3">Select the Responsible Individual whose income is deemed into the AU</td>
    <td>Relationship</td>
  </tr>
   <tr id="deemIndiv2" style="display: none">
  <td colspan="3">
    <impact:validateSelect name="<%= IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2 %>" options="<%=nonAUMembersOptionsList%>" blankValue="true"  value="<%=incomeExpendituresDB.getIdPersonDeemIndiv2String() %>" tabIndex="<%=tabIndex++%>" />
  </td>
  <td>
    <impact:validateSelect name="<%= IncomeExpendituresDB.CD_DEEM_INDIV_REL_2 %>" codesTable="CDEEMREL" value="<%=incomeExpendituresDB.getCdDeemIndivRel2() %>" tabIndex="<%=tabIndex++%>" />
  </td>
  </tr> 
  <tr id="rowNbrDeemChildNotInAU" style="display: none">
     <td colspan="3" width="75%">
        <impact:validateInput type="text" label="2. Number of Responsible Individual's children who live in the home but are not included in the AU" name="<%= IncomeExpendituresDB.NBR_DEEM_CHILD_NOT_IN_AU %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrDeemChildNotInAUObject() != null ?
                                 "" + incomeExpendituresDB.getNbrDeemChildNotInAU() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
             </td>
          </tr>
          <tr id="rowNbrDeemTaxDependNotInAU" style="display: none">
            <td colspan="3">
              <impact:validateInput type="text" label="3. Number of other dependents in the home who are claimed or could be claimed as tax dependents and are not included in the AU" name="<%= IncomeExpendituresDB.NBR_DEEM_TAX_DEPEND_NOT_IN_AU %>" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrDeemTaxDependNotInAUObject() != null ?
                                 "" + incomeExpendituresDB.getNbrDeemTaxDependNotInAU() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
            </td>
          </tr>
          <tr id="rowNbrDeemResponseIndiv" style="display: none">
              <td colspan="3">
              <impact:validateInput type="text" label="4. Number of Responsible Individuals" name="<%= IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV %>" disabled="true" cssClass="formInput" value="<%=incomeExpendituresDB.getNbrDeemResponseIndivObject() != null ?
                                 "" + incomeExpendituresDB.getNbrDeemResponseIndiv() :
                                 StringHelper.EMPTY_STRING %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/>
			</td>
		</tr>
		<tr id="rowAmtDeemTaxDependOutHh" style="display: none">
              <td colspan="3">
              <impact:validateInput type="text" label="5. Amount paid to dependents outside the household who are claimed or could be claimed as tax dependents" name="<%= IncomeExpendituresDB.AMT_DEEM_TAX_DEPEND_OUT_HH %>" cssClass="formInput" value="<%=incomeExpendituresDB.getAmtDeemTaxDependOutHhObject() != null ?
                                 FormattingHelper.formatMoney(incomeExpendituresDB.getAmtDeemTaxDependOutHh()) :
                                 StringHelper.EMPTY_STRING %>" size="13" maxLength="13" tabIndex="<%= tabIndex++ %>"/>
			</td>
		</tr>
		<tr id="rowAmtDeemAlimonyOutsideHh" style="display: none">
              <td colspan="3">
              <impact:validateInput type="text" label="6. Alimony and/or child support paid to person(s) outside of the household" name="<%= IncomeExpendituresDB.AMT_DEEM_ALIMONY_OUTSIDE_HH %>" cssClass="formInput" value="<%=incomeExpendituresDB.getAmtDeemAlimonyOutsideHhObject() != null ?
                                 FormattingHelper.formatMoney(incomeExpendituresDB.getAmtDeemAlimonyOutsideHh()) :
                                 StringHelper.EMPTY_STRING %>" size="13" maxLength="13" tabIndex="<%= tabIndex++ %>"/>
			</td>
		</tr>
	</table>
	<br>
<%}%>
	<impact:ExpandableSectionTag name="documentationChecklist" label="Documentation Checklist" isExpanded="true" tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_AGE_SENT_ES%>" label="Yes" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofAgeSentEsString()) %>' />
					&nbsp;
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_AGE_SENT_ES%>" label="No" value="<%=ArchitectureConstants.FALSE%>" label="No" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofAgeSentEsString()) %>' />
					&nbsp; <span>Is the proof of birth/child's age being sent to the Eligibility Specialist?</span>
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateDate name="<%=IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_STRING%>" label="Date" value="<%=incomeExpendituresDB.getDtProofAgeSentEsString()%>" size="10" constraint="Date" tabIndex="<%=tabIndex++%>"
						conditionallyRequired="<%=ArchitectureConstants.TRUE%>" doNotReuse="true" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_PROOF_AGE_SENT_ES%>" cols="75" rows="2" label="Comments" maxLength="300" constraint="Comments" tabIndex="<%=tabIndex++%>" conditionallyRequired="<%=ArchitectureConstants.TRUE%>">
						<%=incomeExpendituresDB.getTxtProofAgeSentEs()%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_CITIZENSHIP_SENT_ES%>" label="Yes" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofCitizenshipSentEsString()) %>' />
					&nbsp;
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_CITIZENSHIP_SENT_ES%>" label="No" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofCitizenshipSentEsString()) %>' />
					&nbsp; <span>Are copies of all documents used to verify the child's Citizenship/Alien Status being sent to the Eligibility Specialist?</span>
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateDate name="<%=IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING%>" label="Date" value="<%=incomeExpendituresDB.getDtProofCitizenshipSentEsString()%>" size="10" constraint="Date" tabIndex="<%=tabIndex++%>"
						conditionallyRequired="<%=ArchitectureConstants.TRUE%>" doNotReuse="false" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_PROOF_CITIZENSHIP_SENT_ES%>" cols="75" rows="2" label="Comments" tabIndex="<%=tabIndex++%>" constraint="Comments" maxLength="300" conditionallyRequired="<%=ArchitectureConstants.TRUE%>">
						<%=incomeExpendituresDB.getTxtProofCitizenshipSentEs()%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_CHILD_ID_SENT_ES%>" label="Yes" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofChildIdSentEsString()) %>' />
					&nbsp;
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_CHILD_ID_SENT_ES%>" label="No" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofChildIdSentEsString()) %>' />
					&nbsp; <span>Are copies of all documents used to verify the child's Identity being provided to the Eligibility Specialist?</span>
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateDate name="<%=IncomeExpendituresDB.DT_PROOF_CHILD_ID_SENT_ES_STRING%>" label="Date" value="<%=incomeExpendituresDB.getDtProofChildIdSentEsString()%>" size="10" constraint="Date" tabIndex="<%=tabIndex++%>"
						conditionallyRequired="<%=ArchitectureConstants.TRUE%>" doNotReuse="false" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_PROOF_CHILD_ID_SENT_ES%>" cols="75" rows="2" label="Comments" tabIndex="<%=tabIndex++%>" constraint="Comments" maxLength="300" conditionallyRequired="<%=ArchitectureConstants.TRUE%>">
						<%=incomeExpendituresDB.getTxtProofChildIdSentEs()%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_LEGAL_DOCS_SENT_ES%>" label="Yes" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndLegalDocsSentEsString()) %>' />
					&nbsp;
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_LEGAL_DOCS_SENT_ES%>" label="No" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndLegalDocsSentEsString()) %>' />
					&nbsp; <span>Have all legal documents been sent to the Eligibility Specialist including the Affidavit, Petition, and Court Order?</span>
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateDate name="<%=IncomeExpendituresDB.DT_LEGAL_DOCS_SENT_ES_STRING%>" label="Date" value="<%=incomeExpendituresDB.getDtLegalDocsSentEsString()%>" size="10" constraint="Date" tabIndex="<%=tabIndex++%>"
						conditionallyRequired="<%=ArchitectureConstants.TRUE%>" doNotReuse="false" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_LEGAL_DOCS_SENT_ES%>" cols="75" rows="2" label="Comments" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments" conditionallyRequired="<%=ArchitectureConstants.TRUE%>">
						<%=incomeExpendituresDB.getTxtLegalDocsSentEs()%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_PREGNANCY_SENT_ES%>" label="Yes" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofPregnancySentEsString()) %>' />
					&nbsp;
					<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_PROOF_PREGNANCY_SENT_ES%>" label="No" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
						checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofPregnancySentEsString()) %>' />
					&nbsp; <span>Are copies of all documents used to verify the child's pregnancy being provided to the Eligibility Specialist? </span>
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateDate name="<%=IncomeExpendituresDB.DT_PROOF_PREGNANCY_SENT_ES_STRING%>" label="Date" value="<%=incomeExpendituresDB.getDtProofPregnancySentEsString()%>" size="10" constraint="Date" tabIndex="<%=tabIndex++%>"
						conditionallyRequired="<%=ArchitectureConstants.TRUE%>" doNotReuse="false" />
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					&nbsp;
				</td>
				<td>
					<impact:validateTextArea name="<%=IncomeExpendituresDB.TXT_PROOF_PREGNANCY_SENT_ES%>" cols="75" rows="2" label="Comments" tabIndex="<%=tabIndex++%>" constraint="Comments" maxLength="300" conditionallyRequired="<%=ArchitectureConstants.TRUE%>">
						<%=incomeExpendituresDB.getTxtProofPregnancySentEs()%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<br />
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th>
				Court Ordered Child Support
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDER%>" label="Yes" value="<%=ArchitectureConstants.TRUE%>" tabIndex="<%=tabIndex++%>"
					checked='<%= "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndChildSupportOrderString()) %>' />
				<impact:validateInput type="radio" name="<%=IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDER%>" label="No" value="<%=ArchitectureConstants.FALSE%>" tabIndex="<%=tabIndex++%>"
					checked='<%= "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndChildSupportOrderString()) %>' />
				&nbsp;&nbsp;&nbsp;Was child support court ordered?
			</td>
		</tr>
	</table>
	<br />
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
			    <impact:ButtonTag name="btnSaveFinal" img="btnSave" form="frmIncomeExpenditures" tabIndex="<%=tabIndex++%>" accessKey="S" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.SAVE_SET, request)%>'
			         action="<%=IncomeExpendituresConversation.SAVE_INCOME_EXPENDITURES_DETAIL_COMMAND%>"/>
			    <impact:ButtonTag name="btnSubmitApplicationFinal" img="btnSaveAndSubmit" form="frmIncomeExpenditures" tabIndex="<%=tabIndex++%>" accessKey="U" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.SUBMIT_SET, request)%>'
			         action="<%=IncomeExpendituresConversation.SUBMIT_APPLICATION_COMMAND%>"/>
				<impact:ButtonTag name="btnContinueFinal" img="btnContinue" form="frmIncomeExpenditures" tabIndex="<%=tabIndex++%>" accessKey="C" disabled='<%= "" + !Sets.isInSet(IncomeExpendituresConversation.CALCULATE_SET, request) %>'
					action="<%=IncomeExpendituresConversation.CALCULATE_COMMAND%>" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>


<script type="text/javascript" language="JavaScript1.2">
<impact:if test="<%= (pageMode.equals(PageModeConstants.VIEW) == false) %>">
  <impact:then>
if (document.frmIncomeExpenditures.indIncomeAssistance[0].checked)
{
  showDhsWorkerNotified();
}
  </impact:then>
  <impact:else>
    <impact:ifThen test="<%= incomeExpendituresDB.getIndIncomeAssistance() %>">
showDhsWorkerNotified();
    </impact:ifThen>
  </impact:else>
</impact:if>

// MR-053
<impact:if test="<%= ((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus()))) ||
     ((user.hasRight(UserProfile.SEC_ELIGIBILITY)) &&
      ((EventHelper.PENDING_EVENT.equals(incomeExpendituresDB.getCdEventStatus())) ||
       (EventHelper.COMPLETE_EVENT.equals(incomeExpendituresDB.getCdEventStatus()))))) %>">
  <impact:then>
    setupAllocationSection(); 
    setupDeemingSection();
  </impact:then>
</impact:if>
</script>


