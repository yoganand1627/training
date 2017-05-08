<%--
//*  JSP Name: Foster Care Secondary Goals Sub
//*  Created by:   Nandita Hegde
//*  Date Created: 02/21/2006
//*
//*  Description:
//*  This submodule retrieves the information from foster care secondary goals
//*
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
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.MedicationRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FosterCareSecGoalsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FosterCareSecGoalsSubConversation"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.ArrayList"%>


<%

 List<FosterCareSecGoalsList> fosterCareSecGoal = new ArrayList();
 String tabindexString = (String) request.getAttribute("tabIndex");
 int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
 int size = 0;
 int loopCount = 0;
 int idEvent = GlobalData.getUlIdEvent(request);
 
//*********************
//*** SET PAGE MODE ***
//*********************

   String pageMode = PageModeConstants.EDIT;
   if (PageMode.getPageMode(request) != null) {
   pageMode = PageMode.getPageMode(request);
  }
      
 
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************     
      
 BaseSessionStateManager state = (BaseSessionStateManager) request
        .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);

//**************************
//*** RETRIEVE PAGE DATA ***
//************************** 
   FosterCareSecGoalsRetrieveSO fosterCareSecGoals = (FosterCareSecGoalsRetrieveSO) state.getAttribute("FosterCareSecGoalsRetrieveSO", request);
   if(fosterCareSecGoals.getSecGoalsList() != null)
   {
     fosterCareSecGoal =fosterCareSecGoals.getSecGoalsList();
     size = fosterCareSecGoal.size();
   }

%>

<!--<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>-->
<!--<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>-->
<!--<script type="text/javascript" language="JavaScript1.2">-->

<script language="Javascript">

function submitSecondaryGoals( idPlanSecGoals){
  document.<%= includingFormName %>.hdnIdFosterCareSecGoals.value = idPlanSecGoals;
  submitValidateForm( '<%= includingFormName %>', '/serviceDelivery/FosterCareSecGoals/displayFosterCareSecGoals' );
  }

</script>


<impact:validateInput type="hidden" name="hdnIdFosterCareSecGoals" value="0" />


<div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborderList">
    <tr>
      <th colspan="8">
        Secondary Goals
      </th>
    </tr>
    <tr></tr>
    <tr>
      <th class="thList">
        Status
      </th>
      <th class="thList">
        Goal Text
      </th>
    </tr>

    <%
          if (!FormValidation.pageHasErrorMessages(request)) {
          if (size == 0 && idEvent != 0) {
         %>
    <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
      <td colspan="10">
        <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
      </td>
    </tr>
    <%} else {
          for (Iterator<FosterCareSecGoalsList> it = fosterCareSecGoal.iterator(); it.hasNext();) {
          FosterCareSecGoalsList fosterGoals = (FosterCareSecGoalsList) it.next();
          String idPlanSecGoals = String.valueOf(fosterGoals.getIdPlanSecGoals());
              
       %>
    <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
      <td>
        <%
                  String status = "";
                  status = FormattingHelper.formatString( fosterGoals.getSelStatus());
                 %>
        <a href="javascript:submitSecondaryGoals('<%= idPlanSecGoals %>')"><%=status%></a>
      </td>
      <td>
        <%= FormattingHelper.formatString(fosterGoals.getTxtDesc())%>
      </td>

    </tr>
    <%loopCount++;
       }
           } //end big else
      } // end !FormValidation.pageHasErrorMessages

      %>
  </table>
</div>

<%if (!pageMode.equals(PageModeConstants.VIEW)) {
// STGAP00010974 Displaying add button only after the page has been saved first.   
  String displayAddBtn; 
			  Boolean updateClicked = (Boolean) state.getAttribute("BTN_UPDATE_CLICKED", request);
			   Boolean copyClicked = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
			   
			   //STGAP00013838: when we access "Foster Care Goal/Step Detail" page 
			        //through "WTLP" page or "Foster Care Case Plan Child" page  there is no update button, hence 
			        //we have to initialize "updateClicked" to false.
			        if (updateClicked == null) {
			          updateClicked = false;
			        }
			        if (copyClicked == null) {
			          copyClicked = false;
			        }
			        
         		 if(idEvent == 0 || updateClicked || copyClicked){
         				displayAddBtn = ArchitectureConstants.TRUE ;
          			}else{
          					displayAddBtn = ArchitectureConstants.FALSE;  
          				 }
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td align="right">
      <impact:ButtonTag name="btnAddNewSecGoals"
                        restrictRepost="true"
                        navAwayCk="true"
                        img="btnAdd"
                        align="right"
                        form="<%= includingFormName %>"
                        action="/serviceDelivery/FosterCareSecGoals/addFosterCareSecGoals"
                        disabled ="<%= displayAddBtn %>"
                        tabIndex="<%= tabIndex %>" />
    </td>
  </tr>
</table>
<%}

  %>




