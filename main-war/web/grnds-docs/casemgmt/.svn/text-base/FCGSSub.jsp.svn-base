<%--
//*  JSP Name: FCGSSub
//*  Created by:   Vishala Devarakonda
//*  Date Created: 12/13/2006
//*
//*  Description:
//*  The Goals List section will provide a facility
//*  for users to store multiple Goals for a given case. The information will be a sub section on
//*  Foster Care Case Plan Child Detail, Foster Care Case Plan Family Detail and WTLP pages.
//*  Code to include this submodule:
//*     <impact:include page="/submodule/FCGSSubmoduleConversation/displayGoals" callingPage="/casemgmt/FCCPChildDetail/displayFccpChildDetail_xa()"
//*     tabIndex="<%= tabIndex++ %>" includingForm="frmFCCPFamilyDetail"> 
//*     <impact:attribute name="<%= FCGSSubmoduleConversation.PAGE_MODE_KEY %>" value="<%= overallPageMode %>" />
//*     </impact:include>
//*
//*  where parentPage has been set to a value of 'FCCPChildDetail' or 'FCCPFamilyDetail' or 'WLTP'
//*
//*  Note: If the parentPage attribute is not included, an error will be displayed.
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*  04/16/09  cwells			 STGAP00010974 Save button for Secondary goal should be displayed only after the page
//*                              has been saved already. 
//*  06/15/09  mxpatel           STGAP00013838: when we access "Foster Care Goal/Step Detail" page 
//*			                     through "WTLP" page or "Foster Care Case Plan Child" page  there is no update button, hence 
//*			                     we have to initialize "updateClicked" to false and make sure we are coming form the frmFCCPFamilyDetail page.
//*                              Also added code so that if COPY is clicked the ADD button will only show after saving the page.
//*
//*
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FCGSSubmoduleConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyDetailConversation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      FCGSRetrieveSO fcgsretso = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);

      int count = 0;
      int idEvent = fcgsretso.getUlIdEvent();
      int loopCount = 0;
      int size = 0;
      List<GoalsBean> goalBeanList = fcgsretso.getGoalBeanList();
      List<GoalsBean> specficGoalList = new ArrayList<GoalsBean>();
      List<GoalsBean> specficGoalListNre = new ArrayList<GoalsBean>();
      List<String> existingRsnList = new ArrayList<String>();
      String editableMode = ArchitectureConstants.TRUE;
      String goalReason = "";
      String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);
      String pageMode = PageModeConstants.MODIFY;
      String planType = "";
      String selGReason = "";
      String tabindexString = (String) request.getAttribute("tabIndex");
      int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);

      if (idEvent != 0) {
        GlobalData.setUlIdEvent(idEvent, request);
      }
      if ((String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request) != null
          || (String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request) != "") {
        pageMode = (String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request);
      }
      if (PageModeConstants.MODIFY.equals(pageMode)) {
        editableMode = "false";
      }

      planType = (String) state.getAttribute(FCCPFamilyDetailConversation.CASE_PLAN_MODE, request);
%>

<script language="Javascript">
function launchFCGSDetail( index, indicator)
{
  document.<%= includingFormName %>.hdnNreIndicator.value = indicator;
  document.<%= includingFormName %>.fcgsIndex.value = index;
  document.<%= includingFormName %>.isAddFCGS.value = 'false';
  disableValidation( '<%= includingFormName %>' );
  submitValidateForm('<%= includingFormName %>', '/casemgmt/FCGSDetail/displayFCGSDetail');
  
}
function addFCGSDetail()
{
  document.<%= includingFormName %>.isAddFCGS.value = 'true';
  return true;
}

function addReFCGSDetail()
{
  document.<%= includingFormName %>.isAddFCGS.value = 'true';
  document.<%= includingFormName %>.hdnCDGoalRsnNre.value="";
  document.<%= includingFormName %>.hdnNreIndicator.value = 'false';
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsn);
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsnNre);
  return true;
}
function addNreFCGSDetail()
{
  document.<%= includingFormName %>.isAddFCGS.value = 'true';
  document.<%= includingFormName %>.hdnCDGoalRsn.value="";
  document.<%= includingFormName %>.hdnNreIndicator.value = 'true';
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsn);
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsnNre);
  return true;
}
function updateReasonRe()
{
   var type = "REU";
   var selGReason = document.<%= includingFormName %>.szCdGoalRsn.value;
   document.<%= includingFormName %>.hdnCDGoalRsn.value=selGReason;
   document.<%= includingFormName %>.hdnGoalType.value=type;
   CleanSelect(document.<%= includingFormName %>.szCdGoalRsn);
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsnNre);
}
function updateReason()
{
   var selGReason = document.<%= includingFormName %>.szCdGoalRsn.value;
   document.<%= includingFormName %>.hdnCDGoalRsn.value=selGReason;
   CleanSelect(document.<%= includingFormName %>.szCdGoalRsn);
}
function updateReasonNre()
{
  var type = "NRE";
  var selGReason = document.<%= includingFormName %>.szCdGoalRsnNre.value;
  document.<%= includingFormName %>.hdnCDGoalRsnNre.value=selGReason; 
  document.<%= includingFormName %>.hdnGoalType.value=type;
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsn);
  CleanSelect(document.<%= includingFormName %>.szCdGoalRsnNre);
}

</script>
<impact:validateInput type="hidden" name="fcgsIndex" value="0" />
<impact:validateInput type="hidden" name="isAddFCGS" value="" />
<impact:validateInput type="hidden" name="hdnNreIndicator" value="" />
<%String goalType = "";
      //Depending on the page calling this sub the goal Type is set.
      if ("frmChildPlan".equals(includingFormName)) {
        goalType = "DFC";
      } else if ("frmFCCPFamilyDetail".equals(includingFormName)) {
        goalType = "REU";
        //In case of FCCPFamily Detail 2 sections with goal types REU and 
        //NRE should be displayed and hence the counter is incremented to 1.
        count = 1;
      } else if ("frmWTLP".equals(includingFormName)) {
        goalType = "WTL";
      }

      for (int i = 0; i <= count; i++) {

        if ("AFC".equals(planType) && i == 0) {
          count = 0;
          goalType = "AFC";
        }
        //When the parent page is FCCPFamily Detail first the reunification section is displayed and when it 
        //enters the for loop for the second time the goal type is set to NRE to display the Nonreunification section.
        if (i == 1) {
          goalType = "NRE";
          loopCount = 0;
        }

        if (goalBeanList != null) {
          //when it enters the for loop the second time for NRE the goal list still contains the REU goals 
          //So it is re-initialized
          if (i == 1 && !specficGoalList.isEmpty()) {
            specficGoalList = new ArrayList();
          }
          for (Iterator<GoalsBean> it = goalBeanList.iterator(); it.hasNext();) {
            GoalsBean goalRow = (GoalsBean) it.next();
            if (FormattingHelper.formatString(goalRow.getCdGoalTyp()).equals(goalType)) {
              specficGoalList.add(goalRow);
            }
          }
        }
        //As the reunification and nonreunification sections are displayed on the same parent page the NRE 
        //goals should be saved in the state with a different name.
        if ("NRE".equals(goalType)) {
          state.setAttribute("specficGoalListNre", specficGoalList, request);
        } else {
          state.setAttribute("specficGoalList", specficGoalList, request);
        }
        size = specficGoalList.size();
        String goalLabel = "";
        String codesTable = "";

        //Depending on the goal type the reason codes tables and the expandable section labels
        //are set.

        if (goalType.equals("REU")) {
          goalLabel = "Reunification";
          codesTable = "CRURSN";
        } else if (goalType.equals("NRE")) {
          goalLabel = "Non-reunification";
          codesTable = "CNRRSN";
        } else if (goalType.equals("WTL")) {
          goalLabel = "WTLP Goals";
          codesTable = "CWTLPGLS";
        } else if (goalType.equals("DFC")) {
          goalLabel = "DFCS Standard Goals";
        } else if (goalType.equals("AFC")) {
          goalLabel = "AFC Goals";
        }

        %>
<impact:ExpandableSectionTag name="<%= goalType %>" id="goalItem_0" label="<%= goalLabel %>" tabIndex="<%= tabIndex++ %>">
	<div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">

		<table width="100%" cellspacing="0" cellpadding="3" border="0">

			<tr>
				<th class="thList">
					Goal
				</th>
				<th class="thList">
					Change
				</th>
			</tr>
			<%if (!FormValidation.pageHasErrorMessages(request)) {
          if (size == 0) {
%>
			<tr class="odd">
				<td colspan="7">
					<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
				</td>
			</tr>
			<%} else {
            for (Iterator<GoalsBean> it = specficGoalList.iterator(); it.hasNext();) {
              GoalsBean goalRow = (GoalsBean) it.next();
              int idGoal = goalRow.getIdGoal();
%>
			<tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
				<td width="35%" align="left">
					<%String goalText = "";
              String rsnCodesTable = "";
              String goalReasonCode = "";
              if (goalType.equals("DFC")) {
                goalReason = "DFCS Standard";
              } else if (goalType.equals("AFC")) {
                goalReason = "AfterCare";
              } else {
                goalReasonCode = FormattingHelper.formatString(goalRow.getCdGoalRsn());
              }
              if ("NRE".equals(goalType)) {
                goalReason = Lookup.simpleDecodeSafe(CodesTables.CNRRSN, goalReasonCode);
              } else if ("REU".equals(goalType)) {
                goalReason = Lookup.simpleDecodeSafe(CodesTables.CRURSN, goalReasonCode);
              } else if ("WTL".equals(goalType)) {
                goalReason = Lookup.simpleDecodeSafe(CodesTables.CWTLPGLS, goalReasonCode);
              }
              //There can be only one goal per reason. So all the existing reasons are saved in the existingRsnList
              //and when the user tries to add another goal selecting the reason from the dropdown box, the selected reason is 
              //looked up against the list and if it already exists then an error message is displayed.
              existingRsnList.add(goalReason);
              //The Change column in the list section is populated by the first 100 characters of the goal text.
              String temp = FormattingHelper.formatString(goalRow.getLdTxtGoal());
              if (temp.length() > 100) {
                goalText = temp.substring(0, 100);
              } else {
                goalText = temp;
              }
              String goalReasonDisplay;
              if (goalReason.length() > 50) {
                goalReasonDisplay = goalReason.substring(0, 50);
              } else {
                goalReasonDisplay = goalReason;
              }
              String listItemId = "reunificationItem_" + loopCount;
              String nreIndicator = "";
              if ("NRE".equals(goalType)) {
                nreIndicator = "true";
              } else {
                nreIndicator = "false";
              }
%>
					<a href="javascript:launchFCGSDetail('<%= loopCount %>', '<%= nreIndicator %>');" tabIndex="<%= tabIndex %>" id="<%= listItemId %>"><%=goalReasonDisplay%></a>
				</td>
				<td nowrap="nowrap">
					<%=goalText%>
				</td>

			</tr>

			<%loopCount++;
            } // end while enumeration has more elements
            state.setAttribute("existingReasonList", existingRsnList, request);
          } //end big else
        } // end !FormValidation.pageHasErrorMessages

        %>
		</table>
	</div>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<%if (!"DFC".equals(goalType) && !"AFC".equals(goalType) && !"NRE".equals(goalType)) { %>

			<td>
				<%String functionCall = "";
          if ("REU".equals(goalType)) {
            functionCall = "updateReasonRe();";
          } else {
            functionCall = "updateReason();";
          }

          %>
				<impact:validateSelect tabIndex="<%= tabIndex++ %>" disabled="<%= "" %>" id="szCdGoalRsn" name="szCdGoalRsn" width="20%" onChange="<%= functionCall %>" value="" codesTable="<%= codesTable %>" />
			</td>
			<impact:validateInput type="hidden" name="hdnCDGoalRsn" value="<%= selGReason %>" />
			<%} else if ("NRE".equals(goalType)) {
          //As the reunification and the nonreunification sections are on the same page the drop down box and the Add button
          // should have a different name for nonreunification section.

          %>
			<td>
				<impact:validateSelect tabIndex="<%= tabIndex++ %>" disabled="<%= "" %>" id="szCdGoalRsnNre" name="szCdGoalRsnNre" width="20%" onChange="updateReasonNre()" value="" codesTable="<%= codesTable %>" />
			</td>
			<impact:validateInput type="hidden" name="hdnCDGoalRsnNre" value="<%= selGReason %>" />
			<%}

        %>

			<impact:validateInput type="hidden" name="hdnGoalType" value="<%= goalType %>" />




			<%if (!pageMode.equals(PageModeConstants.VIEW)) {
			// STGAP00010974 Displaying add button only after the page has been saved first. 
			  String displayAddBtn; 
			  Boolean updateClicked = (Boolean) state.getAttribute("BTN_UPDATE_CLICKED", request);
			  Boolean copyClicked = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
			  Boolean wtlpCopyClicked = (Boolean) state.getAttribute("WTLP_COPY_CLICKED", request);
			  
			  //STGAP00013838: when we access "Foster Care Goal/Step Detail" page 
			        //through "WTLP" page or "Foster Care Case Plan Child" page  there is no update button, hence 
			        //we have to initialize "updateClicked" to false.
			        if (updateClicked == null) {
			          updateClicked = false;
			        }
			        if (copyClicked == null) {
			          copyClicked = false;
			        }
			         if (wtlpCopyClicked == null) {
			          wtlpCopyClicked = false;
			        }
			        
         		 if(idEvent == 0 || updateClicked || copyClicked || wtlpCopyClicked){
         				displayAddBtn = ArchitectureConstants.TRUE ;
          			}else{
          					displayAddBtn = ArchitectureConstants.FALSE;  
          				 }
          if ("NRE".equals(goalType)) { 
         %>
			<td align="right">
				<impact:ButtonTag name="btnAddNewNreGoal" restrictRepost="true" navAwayCk="true" disabled="<%= displayAddBtn %>" img="btnAdd" align="right" form="<%= includingFormName %>"
					function="return addNreFCGSDetail();" action="/casemgmt/FCGSDetail/displayFCGSDetail" tabIndex="<%= tabIndex %>" />
			</td>
			<%} else {
            if ("REU".equals(goalType)) {%>
			<td align="right">
				<impact:ButtonTag name="btnAddNewGoal" restrictRepost="true" navAwayCk="true" disabled="<%= displayAddBtn %>" img="btnAdd" align="right" form="<%= includingFormName %>" function="return addReFCGSDetail();"
					action="/casemgmt/FCGSDetail/displayFCGSDetail" tabIndex="<%= tabIndex %>" />
			</td>
			<%} else {%>
			<td align="right">
				<impact:ButtonTag name="btnAddNewGoal" restrictRepost="true" navAwayCk="true" disabled="<%= displayAddBtn %>" img="btnAdd" align="right" form="<%= includingFormName %>" function="return addFCGSDetail();"
					action="/casemgmt/FCGSDetail/displayFCGSDetail" tabIndex="<%= tabIndex %>" />
			</td>

			<%}
           
			}
				} %>
		</tr>

	</table>

</impact:ExpandableSectionTag>
<%//This is to add a space bar between the two sections in case of FCCPFamily Detail.
        if ("REU".equals(goalType)) { %>
<br>
<%}
      } %>


