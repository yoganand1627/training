<%--
JSP Name:     Assigned Workload JSP
Created by:   Jenn Casdorph
Date Created: 11/20/02

Description:
The Assigned Workload page displays a list of current
assignments for a particular worker, and allows the worker
to navigate to areas regarding their assignements.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
3/7/2003  Stephan Brauchli  Added L1 constant for eventList hyperlinks
02/06/04  corleyan          SIR 19749 - Added workload report
05/19/04  corleyan          SIR 22876 The workload report needs to sort by current
                            sort on page, add parameter to report and hidden field for
                            value.
06/29/05  casdorjm          SIR 23689 - added new column OPENED and hidden field for
                            filterBy parameter (used when sorting workload)
07/11/05  yeehp             SIR 23750 - Added if statement for the checkbox.  If a case is
                            checked out in MPS then the checkbox will not appear.
07/14/05  Nallavs           SIR 23265 - Added new column Rcvm to display O,M or O/M
                            so that flag new cases when there have been at least two cases
                            on the same client within the preivous 12 months and also
                            flag new cases when there's an open case on the same client
01/14/10  ssubram			Adding Errors and Warnings to the Assigned Workload page.                     
02/23/11  Hai Nguyen        SMS#97850: MR-075 Added FAD IV-E and FA Home Status columns. Added
                            logic to display home status tooltip hover.
03/03/11  Hai Nguyen        SMS#97850: MR-075 Corrected table width so table header will not wrap sort arrow.
03/26/11  Hai Nguyen        SMS#97850: MR-075 Update for SO element name change.
04/28/11  schoi             SMS #107181: MR-075 Added a reportParameter value='0' because of the Assigned Workload report error 
							when launched from the Assigned Workload page. The error was generated on the DB server 
							by the Report Launcher that states user input is required.   
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.DynamicWorkloadDAO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.AssignedWorkloadConversation" %>
<%
  BaseSessionStateManager state
          = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // PAGE MODE LOGIC BEGIN
  String pageMode;
  pageMode = user.hasRight(UserProfile.SEC_ASSIGN_WORKLOAD) ? PageModeConstants.EDIT : PageModeConstants.VIEW;

  //  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH

  CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);

  if (ccmn14so == null) {
    ccmn14so = new CCMN14SO();
  }
  ROWCCMN37DO_ARRAY rowccmn37doArray;
  rowccmn37doArray =
          ccmn14so.getROWCCMN37DO_ARRAY() != null ? ccmn14so.getROWCCMN37DO_ARRAY() : new ROWCCMN37DO_ARRAY();

  // SIR 19749 get the variables from state so the workload report can generate
  Integer workloadPersonID = (Integer) state.getAttribute("workloadPersonID", request);
  String workloadPersonName = (String) state.getAttribute("workloadPersonName", request);
  // SIR 22876 add sort order to the report
  String workloadSortOrder = (String) state.getAttribute("workloadSortOrder", request);

  int tabIndex = 1;
  int loopCount;

  String focusElement = null;
  if (FormValidation.pageHasErrorMessages(request) ||
      FormValidation.pageHasValidationMessages("frmAssignedWorkload", request)) {
    Enumeration params = request.getParameterNames();
    while (params.hasMoreElements()) {
      String paramName = (String) params.nextElement();
      if (paramName.startsWith("cbx") && !paramName.endsWith("_changed")) {
        focusElement = paramName;
        break;
      }
    }
  }


%>
<impact:validateErrors/>

<script type="text/javascript" language="JavaScript1.2">
  //  This function is called when the user clicks a hyperlink in the list for a stage with a Case ID.
  //  It takes the user to the Call Summary page.  Sir 17116 - lauramc added stageId to caseSummaryHyperlink
  function caseSummaryHyperlink(index, stageId)
  {
    disableValidation("frmAssignedWorkload");
    submitValidateForm("frmAssignedWorkload", "/workload/AssignedWorkload/callCaseSummary?index=" + index);
  }
  //  This function is called when the user clicks a hyperlink in the list for a stage without a Case ID.
  //    It takes the user to the Event List page.
  function eventListHyperlink(index)
  {
    disableValidation("frmAssignedWorkload");
    submitValidateForm("frmAssignedWorkload", "/workload/AssignedWorkload/callEventListNoCaseId?index=" + index);
  }

</script>
<impact:validateForm name="frmAssignedWorkload"
                     method="post"
                     action="/workload/AssignedWorkload/displayAssignedWorkload"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.AssignedWorkloadCustomValidation"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">
<%
  String paginationDestination = "/workload/AssignedWorkload/displayAssignedWorkload";
  String currentCommand = (String) request.getAttribute("grnds_command");
  if ("displayOtherAssignedWorkload".equals(currentCommand)) {
    paginationDestination = "/workload/AssignedWorkload/displayOtherAssignedWorkload";
  }
%>
<input type="hidden" name="filterBy" value="<%=request.getAttribute("filterBy")%>">
<impact:pagination submitUrl="<%=paginationDestination%>">
<div class="alignRight">
  <div class="formInstruct">Scroll for more information --></div>
</div>
<div id="scrollBar2" style="height:210px;width:763px;overflow:auto" class="tableborderList">
<table width="1300" cellspacing="0" cellpadding="3" border="0">
<tr>
    <%-- NOTE: There must be no spaces in these header rows, or they appear wrong,
so they are deliberately NOT wrapped like the rest of the file.  --%>
  <th class="thList">&nbsp;</th>
  <th class="thList">!</th>
  <th class="thList">P/S&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_PRIMARY_SECONDARY%>"/>
  </th>
  <th class="thList">Stage Name&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_STAGENAME%>"/>
  </th>
  <th class="thList">Stage&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_SERVICE_STAGE%>"/>
  </th>
  <th class="thList">FAD IV-E&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_FAD_IVE%>"/>
  </th>
  <th class="thList">Status&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_FA_HOME_STATUS%>"/>
  </th>
  <th class="thList">
  	<span style="color:red">E</span>&nbsp;/&nbsp;<span style="color:blue">W</span>&nbsp;
  </th>  
  <th class="thList">Level&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_LEVEL%>"/>
  </th>
  <th class="thList">RT&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_RT%>"/>
  </th>
  <th class="thList">Assigned&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_DATE%>"/>
  </th>
  <th class="thList">Case ID&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_CASE%>"/>
  </th>
  <th class="thList">County&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_COUNTY%>"/>
  </th>
  <th class="thList">Unit&nbsp;
    <impact:sortableColumnHeader orderBy="<%=DynamicWorkloadDAO.SORT_BY_UNIT%>"/>
  </th>
  <th class="thList">Region</th>
  <th class="thList">Stage ID</th>
</tr>
<%
  /* SIR 23265 */
  loopCount = 0;
  Enumeration workLoadEnum = rowccmn37doArray.enumerateROWCCMN37DO();
  ROWCCMN37DO workloadRow = null;
  if (workLoadEnum == null || !(workLoadEnum.hasMoreElements())) {
%>
<tr class="odd">
  <td colspan="14">
    <%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_EMPTY_WORKLOAD)%>
  </td>
</tr>
<%
} else {
  while (workLoadEnum.hasMoreElements()) {
    workloadRow = (ROWCCMN37DO) workLoadEnum.nextElement();

    String cdRecidivism = workloadRow.getSzCdRecidivism();
    String cdRcvm;
    if (CodesTables.CAPSRCM_1.equals(cdRecidivism)) {
      cdRcvm = "M";
    } else if (CodesTables.CAPSRCM_2.equals(cdRecidivism)) {
      cdRcvm = "O";
    } else if (CodesTables.CAPSRCM_3.equals(cdRecidivism)) {
      cdRcvm = "O/M";
    }


%>
<tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
  <%String checkId = "cbx_" + loopCount;%>
  <td>
      <%--
        SIR 23750 - 07/11/05 yeehp - Added if statement around the checkbox
      --%>
    <%
      if (!"OT".equals(workloadRow.getSzCdMobileStatus())) {
        if (pageMode.equals(PageModeConstants.VIEW)) {
    %>
    <impact:validateInput type="checkbox" value="<%=String.valueOf( loopCount )%>"
                          id="<%=checkId%>" name="<%=checkId%>" tabIndex="<%=tabIndex++%>" disabled="true"/>
    <%} else {%>
    <impact:validateInput type="checkbox" value="<%=String.valueOf( loopCount )%>"
                          id="<%=checkId%>" name="<%=checkId%>" tabIndex="<%=tabIndex++%>"/>

    <%
        }
      }
    %>
  </td>
  <td align="center"><%="Y".equals(workloadRow.getBIndCaseSensitive())
                        ? "<div class=\"formSensitiveText\">!</div>" : ""%>
  </td>
  <td><%="PR".equals(workloadRow.getSzCdStagePersRole()) ? "P" : "S"%>
  </td>
    <%--
      Sir 17116 - lauramc Added GlobalData, stage id to the hyperlink below

      Note that the closing > for the beginning of the anchor tag is dropped to make 0 spaces
        inside of it; this is because zero spaces is treated differently than one space in HTML.
    --%>
  <td><%=AssignedWorkloadConversation.NEW_INDICATORS.contains(workloadRow.getBIndStagePersEmpNew())
         ? "<b>#</b>" : ""%><a href='<%=workloadRow.getUlIdCase() != 0
                                              ? "javascript:caseSummaryHyperlink( \"" + loopCount + "\", \""
                                                + GlobalData.getUlIdStage( request ) + "\" );"
                                              : "javascript:eventListHyperlink( \"" + loopCount + "\" );"%>'
                               onClick="window.onBeforeUnload=null;" tabIndex="<%=tabIndex++%>"
          ><%=StringHelper.isValid(workloadRow.getSzNmStage())
              ? workloadRow.getSzNmStage() : TWENTY_FOUR_NON_BREAKING_SPACES%>
  </a></td>
  <td><%=workloadRow.getSzCdStage() != null ? Lookup.simpleDecodeSafe("CTXTOGA", workloadRow.getSzCdStage()) : "&nbsp;"%>
  </td>
  <td><%=workloadRow.getBIndHomeIveReimbursable() != null ? workloadRow.getBIndHomeIveReimbursable() : "&nbsp;"%>
  </td>
  <td><span title='<%=workloadRow.getSzCdRsrcFaHomeStatus() != null ? Lookup.simpleDecodeSafe("CFAHMSTA", workloadRow.getSzCdRsrcFaHomeStatus()) : "" %>'>
        <%=workloadRow.getSzCdRsrcFaHomeStatus() != null ? workloadRow.getSzCdRsrcFaHomeStatus() : "&nbsp;"%>
      </span>
  </td>
  <%-- Adding Errors and Numbers--%>
  <td>
    <impact:ifThen test='<%=((workloadRow.getNbrErrors() > 0)||(workloadRow.getNbrWarnings() > 0))%>'>
  	  <span style="color:red"><%=workloadRow.getNbrErrors() > 0 ? workloadRow.getNbrErrors() : "0"%></span>&nbsp;/&nbsp;
  	  <span style="color:blue"><%=workloadRow.getNbrWarnings() > 0 ? workloadRow.getNbrWarnings() : "0"%></span>
    </impact:ifThen> 
  </td> 

  <td><%=workloadRow.getSzCdRiskLvl() != null ? workloadRow.getSzCdRiskLvl() : "&nbsp;"%>
  </td>
  <td><%=workloadRow.getSzCdStageCurrPriority() != null ? workloadRow.getSzCdStageCurrPriority() : "&nbsp;"%>
  </td>
  <td><%=workloadRow.getDtDtStagePersLink() != null ? FormattingHelper.formatDate(workloadRow.getDtDtStagePersLink()) :
         "&nbsp;"%>
  </td>
  <td><%=workloadRow.getUlIdCase() != 0 ? FormattingHelper.formatInt(workloadRow.getUlIdCase()) : "&nbsp;"%>
  </td>
  <td><%=FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CCOUNT", workloadRow.getSzCdStageCnty()))%>
  </td>
  <td><%=workloadRow.getSzNbrUnit() != null ? workloadRow.getSzNbrUnit() : "&nbsp;"%>
  </td>
  <td><%=workloadRow.getSzCdStageRegion() != null ? workloadRow.getSzCdStageRegion() : "&nbsp;"%>
  </td>
  <td><%=workloadRow.getUlIdStage() != 0 ? FormattingHelper.formatInt(workloadRow.getUlIdStage()) : "&nbsp;" %>
  </td>
</tr>
<%
      loopCount++;
    }
  }
%>
</table>
</div>
</impact:pagination>

<table border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField name="totalStages" label="Total Stages"
                                       value="<%= FormattingHelper.formatInt(ccmn14so.getUlWorkloadCount())%>"/>
    </td>
    <% if (ccmn14so.getBIndOverPolicyLimit() == true) {%>
    <td>*</td>
    <% } %>
  </tr>
</table>
<%
  //*****************
  //**** BUTTONS ****
  //*****************
  // Display the Assign and Stage Progression buttons unless the page mode is VIEW. If page
  // mode is VIEW, display a <br> to put a empty line.
  if (!pageMode.equals(PageModeConstants.VIEW)) {%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="72%">&nbsp;</td>
    <td class="alignRight" width="10%">
      <impact:ButtonTag name="btnAssign" img="btnAssign" align="right" form="frmAssignedWorkload"
                        action="/workload/AssignedWorkload/assignStage"
                        function="enableValidation( 'frmAssignedWorkload' );" tabIndex="<%=tabIndex++%>"/>
    </td>
    <td class="alignRight" width="18%">
      <impact:ButtonTag name="btnStageProgression" img="btnStageProgression" align="right" form="frmAssignedWorkload"
                        action="/workload/AssignedWorkload/stageProgression"
                        function="enableValidation( 'frmAssignedWorkload' );" tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<%
} else {%>
<br>
<%
  }
%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<%-- START - REINSERTED CODE FOR REPORTS MODULE --%>      
<br>      
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">      
  <tr>      
     <th colspan="4">Reports</th>      
   </tr>      
   <tr>      
     <td>      
       <impact:reportList personId="<%= user.getUserID() %>"      
                          tabIndex="<%= tabIndex++ %>">      
         <impact:report useHiddenParameters="false"      
                        reportName="WorkloadReport00"      
                        emailMessage='<%= "Workload Report: " + workloadPersonName %>'>      
           <impact:reportParameter value='<%= "" + workloadPersonID %>'/>         
           <impact:reportParameter value='0'/>       
         </impact:report>      
       </impact:reportList>      
     </td>      
   </tr>      
   </table>      
<%-- END --%>  

<%
  if (focusElement != null) {
%>
<script type="text/javascript" language="JavaScript1.2">
  function focusOnCheck()
  {
    document.frmAssignedWorkload.<%=focusElement%>.focus();
  }
  window.attachEvent("onload", focusOnCheck);
</script>
<%
  }
%>
<%!
  public static final String TWENTY_FOUR_NON_BREAKING_SPACES
          = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
%>
