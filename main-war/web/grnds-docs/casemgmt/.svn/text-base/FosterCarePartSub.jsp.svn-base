<%--
//*  JSP Name: FosterCarePartSub
//*  Created by:   Steven Thrasher
//*  Date Created: 2/2/2007
//*
//*  Description:
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*  08/10/09  arege             STGAP00014384: For Copied plans Add and Delete buttons on the Participantlist
//*                              Section should not display until initial Save.
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean"%>
<%//*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************

      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      FosterCareParticipantRetrieveSO fosterCarePart = (FosterCareParticipantRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "RETRIEVESO",
                                                                                                            request);

      int ulIdEvent = GlobalData.getUlIdEvent(request);
      String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);
      String formLabel = "";
      Iterator iter = null;
      int loopCounter = 0;
      String tabindexString = (String) request.getAttribute("tabIndex");
      int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
      int idEvent = fosterCarePart.getUlIdEvent();
      state.setAttribute("includingFormName", includingFormName, request);
      
      Boolean wtlpCopyClicked = (Boolean) state.getAttribute("WTLP_COPY_CLICKED", request);
      Boolean copyClicked = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
      if (wtlpCopyClicked == null) {
		  wtlpCopyClicked = false;
	  }
	  
	  if(copyClicked == null){
	     copyClicked = false;
	  }	  
	  
	  String disableAddBtn = ArchitectureConstants.FALSE; 
	  String disableDeleteBtn = ArchitectureConstants.FALSE; 
	  
	  if(idEvent == 0 || wtlpCopyClicked || copyClicked){
       disableAddBtn = ArchitectureConstants.TRUE ;
      }else{
      disableAddBtn = ArchitectureConstants.FALSE;  
      }
      
      disableDeleteBtn = disableAddBtn;

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************

      if ("frmFCCPFamilyDetail".equals(includingFormName)) {
        formLabel = "Foster Care Case Plan Participant List";
      } else if ("frmWTLP".equals(includingFormName)) {
        formLabel = "WTLP Participation";
      }
      state.setAttribute("fosterCareList", fosterCarePart, request);
      //******************
      //*** JAVASCRIPT ***
      //******************

      %>

<script language="Javascript">
function goToParticipantDetailPage(selectedParticipantId )
{
  document.<%= includingFormName %>.selectedParticipantId.value = selectedParticipantId;
  disableValidation( '<%= includingFormName %>' );
  submitValidateForm('<%= includingFormName %>', '/casemgmt/FosterCareParticipant/displayFosterCareParticipant');
  document.<%= includingFormName %>.isAddFCPart.value = 'false';
  document.<%= includingFormName %>.isDelFCPart.value = 'false';
}

function addFCPartDetail()
{
  document.<%= includingFormName %>.isAddFCPart.value = 'true';
  return true;
}

function delFCPartDetail()
{
  document.<%= includingFormName %>.isDelFCPart.value = 'true';
  return true;
}

function confirmRowSelected()
{
  var rowSelected = false;
  var fieldName = "document." + <%= includingFormName %> + ".rbParticipantId_CLEAN";
  
  // If the radio button group is an array (i.e., more than one radio
  // button), then loop through the array and check for a selected radio
  // button; otherwise, check the single radio button to see if it is
  // selected.
  if (document.<%= includingFormName %>.rbParticipantId_CLEAN[0])
  {
    for (var i = 0; i < document.<%= includingFormName %>.rbParticipantId_CLEAN.length; i++)
    {
      if (document.<%= includingFormName %>.rbParticipantId_CLEAN[i].checked)
      {
        rowSelected = true;
        break;
      }
    }
  }
  else
  {
    if (document.<%= includingFormName %>.rbParticipantId_CLEAN.checked)
    {
      rowSelected = true;
    }
  }

  if (rowSelected == false)
  {
    alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>");
    return false;
  }
  else
  {
    return confirm("<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>");
  }
  return false;
}
</script>
<impact:validateInput type="hidden" name="fcPartIndex" value="0" />
<impact:validateInput type="hidden" name="isAddFCPart" value="" />
<impact:validateInput type="hidden" name="isDelFCPart" value="" />
<impact:validateInput type="hidden" name="hdnIdEvent" value="<%idEvent%>"/>
<impact:validateInput
        type="hidden"
        name="selectedParticipantId"
        value=""/>

<impact:validateInput
        type="hidden"
        name="includingFormName"
        value="<%=includingFormName%>"/>
        
  <impact:ExpandableSectionTag name="<%= includingFormName %>" id="fcPart_0" label="<%= formLabel %>" tabIndex="<%= tabIndex++ %>">
        <div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">
            <table width="100%" cellspacing="0" cellpadding="3" border="0">
              <tr>
                <th class="thList">&nbsp;</th>
                <th class="thList">Name</th>
                <th class="thList">Rel/Int</th>
                <th class="thList">Participation</th>
                <th class="thList">Signed Receipt of Copy</th>
                <th class="thList">Agreed?</th>
        <th class="thList">Date Agreed</th>
              </tr>
              <%
              iter = fosterCarePart.getFosterCarePartList().iterator();
              while (iter.hasNext())
              {
               FosterCarePartBean participant = 
                   (FosterCarePartBean)iter.next();
                %>
                <tr class="<%= FormattingHelper.getRowCss(loopCounter + 1) %>">
                  <td>
                    <%
                    // The name of this radio button ends in "_CLEAN" so that the
                    // radio group will be excluded from the 'isDirty' check. We
                    // don't want the user to get the message "Your unsaved data
                    // will be lost" just because they selected a radio button.
                    %>
                    <impact:validateInput
                        type="radio"
                        tabIndex="<%= tabIndex++ %>"
                        value="<%= FormattingHelper.formatInt(participant.getIdPlanPart()) %>"
                        name="rbParticipantId_CLEAN"
                        cssClass="formInput"/>
                  </td>
                  <td><a href="JavaScript:goToParticipantDetailPage(<%= FormattingHelper.formatInt(participant.getIdPlanPart()) %>);"><%= participant.getSzNmPart() %> </a></td>
                  <td><%= FormattingHelper.formatString(participant.getSzCdRelInt()) %></td>
           
          <td><%= FormattingHelper.formatDate(participant.getDtPart()) %></td>
                  <td><%= FormattingHelper.formatDate(participant.getDtSigned()) %></td>
                  <td><%= FormattingHelper.formatString(participant.getIndApproval()) %></td>
                  <td><%= FormattingHelper.formatDate(participant.getDtApprv()) %></td>
                </tr>
                <%
                loopCounter++;
              } // end while (iter.hasNext())
              %>
            </table>
          </div>
    <table border="0" cellpadding="3" cellspacing="0" width="100%">
            <tr>
            <% if (loopCounter != 0) {%>
              <td>
                <impact:ButtonTag
                    name="btnDelete"
                    img="btnDelete"
                    align="left"
                    form="<%= includingFormName %>"
                    action="/casemgmt/FosterCareParticipant/deleteFCParticipant"
                    function="return confirmRowSelected()"
                    navAwayCk="true"
                    disabled="<%= disableDeleteBtn %>"
                    tabIndex="<%= tabIndex++ %>"/>
              </td>
              <%} //delete button%>
              <td>
                <impact:ButtonTag
                    name="btnAdd"
                    img="btnAdd"
                    align="right"
                    form="<%= includingFormName %>"
                    action="/casemgmt/FosterCareParticipant/addFosterCareParticipant"
                    navAwayCk="true"
                    restrictRepost="true"
                    disabled="<%= disableAddBtn %>" 
                    tabIndex="<%=tabIndex++ %>"/>
            </tr>
          </table>
</impact:ExpandableSectionTag>

