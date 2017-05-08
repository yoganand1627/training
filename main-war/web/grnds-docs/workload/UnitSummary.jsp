
<%
  //*  JSP Name:     Unit Summary
  //*  Created by:   Michael Ochu
  //*  Date Created: 12/14/2002
  //*
  //*  Description:
  //*  This JSP is used by users with appropriate security profile
  //* and approval responsibility for a unit to view their unit's current activity.
  //* The user can then enter their workers' To-Do List and Assigned Workload in order to
  //* view or modify anything within their unit's responsibility
  //*
  //** Change History:
  //**  Date      User              Description
  //**  --------  ----------------  --------------------------------------------------
  //**  05/27/03  GRIMSHAN          SIR 17787 -- Make the list box one long section
  //**                              that does not scroll
  //**
  //**  07/09/03  DOUGLACS          SIR 18728 - hyperlink doesn't work if name includes
  //**                              apostrophe
  //**
  //**  03/07/05  thompswa          SIR 18096 - Unit field on Unit Summary page
  //**                              should default to user's unit.
  //**
  //**  06/29/05  casdorjm          SIR 23689 - added two new columns INV+30 and SVC+60
  //**                              and hyperlinks on both.  Also modified the submitPersonId()
  //**                              method to include the filterBy parameter.  These new links
  //**                              will only be displayed for APS units
  //**
  //**  08/23/06  abgoode        Updates for GA SACWIS completed, including:
  //**                - Program replaced by County
  //**                - Assignments per stage added to search results, sortable
  //**  03/17/08 	aroberts		  Renamed the RD_COLUMN to FAD_COLUMN and added the PFC COLUMN to be displayed
  //**  07/17/08  wjcochran		   Added 'Direct Reporting Units' information as per MR-017
  //**	12/03/08  wjcochran		   STGAP00010660: modified direct reporting region to read from the
  //**								actual unit region and not the region of the currently displayed unit.

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN29SOG01"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN29SOG01_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.workload.UnitSummaryConversation"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.workload.UnitSummarySearchBean"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.DynamicUnitEmpLinkDAO"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);

  String szCdUnitCounty = userProfile.getUserCounty();
  String szCdUnitRegion = userProfile.getUserRegion();
  String txtszNbrUnit = userProfile.getUserUnit(); // SIR 18096
  String rbSameName = "";
  String primaryAssignment = "false";
  String totalAssignment = "false";
  boolean hasChildUnits = true;

  UnitSummarySearchBean unitSummarySearchBean = (UnitSummarySearchBean) request
                                                                               .getAttribute(UnitSummaryConversation.UNIT_SUMMARY_BEAN);

  if (unitSummarySearchBean != null) {
    szCdUnitCounty = unitSummarySearchBean.getCounty();
    szCdUnitRegion = unitSummarySearchBean.getRegion();
    txtszNbrUnit = unitSummarySearchBean.getUnit();
    rbSameName = unitSummarySearchBean.getAssignments();
    //UnitSummarySearchBean is already in global data, if the search was successful
    //since we no longer need the value in the request, we remove it
    request.removeAttribute(UnitSummaryConversation.UNIT_SUMMARY_BEAN);
  }

  if ("1".equals(rbSameName)) {
    primaryAssignment = "false";
    totalAssignment = "true";
  } else if ("2".equals(rbSameName)) {
    totalAssignment = "false";
    primaryAssignment = "true";
  }

  int tabIndex = 1;
  int loopCount = 0;

  CCMN29SO ccmn29so = (CCMN29SO) state.getAttribute("CCMN29SO", request);
  ROWCCMN29SOG01_ARRAY unitArray = null;
  if (ccmn29so == null) {
    ccmn29so = new CCMN29SO();
  }
  if (ccmn29so.getROWCCMN29SOG01_ARRAY() != null) {
    unitArray = ccmn29so.getROWCCMN29SOG01_ARRAY();
  } else {
    unitArray = new ROWCCMN29SOG01_ARRAY();
  }
  
  // Contains child unit information
  CCMN24SO ccmn24so = (CCMN24SO) state.getAttribute("CCMN24SO", request);

  // Initialize the row and array objects
  if (ccmn24so == null) {
	ccmn24so = new CCMN24SO();
	hasChildUnits = false;
  }

  ROWCCMN24SOG01_ARRAY reportingUnitsInfoRowArray = null;

  // Null catch for ROW objects, if not null get rows
  if ( ccmn24so.getROWCCMN24SOG01_ARRAY() != null 
  		&& ccmn24so.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01Count() > 0)
  {
    reportingUnitsInfoRowArray = ccmn24so.getROWCCMN24SOG01_ARRAY();
  } else
  {
    reportingUnitsInfoRowArray = new ROWCCMN24SOG01_ARRAY();
    hasChildUnits = false;
  }
  
  
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// This function is used to pass the person id and person name to the assigned
// workload page.
function submitPersonID( personId, personNmWorkload, filter )
{
  document.frmUnitSummary.personId.value = personId;
  document.frmUnitSummary.personNmWorkload.value = personNmWorkload;
  document.frmUnitSummary.filterBy.value = filter;
  disableValidation( "frmUnitSummary" );
  submitValidateForm( "frmUnitSummary", "/workload/UnitSummary/callAssignedWorkload" );
}

// Custom function to handle submitting the form via links in a list
function submitFormUnitSummary( counter )
{
    document.frmUnitSummary.counter.value = counter;
        // then call submitValidateForm()
    submitValidateForm( "frmUnitSummary", "/workload/UnitSummary/displayUnitSummary" );
}

</script>

<impact:validateForm name="frmUnitSummary" defaultButton="true"
	method="post" action="/workload/UnitSummary/searchUnitSummary"
	schema="/WEB-INF/Constraints.xsd" redisplayParameters="true"
	pageMode="<%=PageModeConstants.EDIT%>">

	<impact:validateErrors formName="frmUnitSummary" />


	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%">
		<tr>
			<th colspan="4">
				Search Criteria
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateSelect name="selCounty" label="County"
					codesTable="CCOUNT" required="true" value="<%=szCdUnitCounty%>"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateSelect name="selRegDiv" label="Reg/Div"
					codesTable="CREGDIV" required="true" value="<%=szCdUnitRegion%>"
					contentType="<%=SelectTag.CODES_DECODES%>"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateInput tabIndex="<%=tabIndex++%>" value="1"
					checked="<%=totalAssignment%>" type="radio" name="rbSameName"
					label="" cssClass="formInput" />
				Total Assignments
			</td>
			<td colspan="2">
				<table border="0" cellspacing="0" cellpadding="3" width="100%">
					<tr>
						<td>
							<impact:validateInput tabIndex="<%=tabIndex++%>" value="2"
								checked="<%=primaryAssignment%>" type="radio" name="rbSameName"
								label="" cssClass="formInput" />
							Total Primary Assignments
						</td>
						<td>
							<impact:validateInput type="text" name="txtszNbrUnit"
								constraint="AlphaNumeric2Unit" label="Unit" required="true"
								value="<%=txtszNbrUnit%>" size="2" maxLength="2"
								tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag name="btnSearchFinal" img="btnSearch"
					backSafe="true" align="right" form="frmUnitSummary"
					action="/workload/UnitSummary/searchUnitSummary"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>

	<%
	  ROWCCMN29SOG01_ARRAY rowccmn29sog01_array = ccmn29so.getROWCCMN29SOG01_ARRAY();
	    if ((rowccmn29sog01_array != null) && (rowccmn29sog01_array.getUlRowQty() > 0)) {
	%>
	<br>
	<%
	  /* Begin Result List Division  */
	      // SIR 17787 GRIMSHAN Remove the scroll bar, make it one long displayed section
	%>
	<impact:pagination submitUrl="/workload/UnitSummary/displayUnitSummary">
		<table width="100%" cellspacing="0" cellpadding="3"
			class="tableborder">
			<tr>
				<td class="tableBG">
					<table width="100%" cellspacing="0" cellpadding="3"
						class="tableborderList">
						<tr>
							<th class="thList">
								Name
							</th>
							<th class="thList" align="center">
								In Unit
							</th>
						    <th class="thList">
						  	  <span style="color:red">E</span>&nbsp;/&nbsp;<span style="color:blue">W</span>&nbsp;
						    </th>							
							<th class="thList">
								INT&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.INT_COLUMN%>"
									isDefault="true" />
							</th>
							<th class="thList">
								INV&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.INV_COLUMN%>" />
							</th>
							<th class="thList">
								DIV&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.DIV_COLUMN%>" />
							</th>
							<th class="thList">
								ONG&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.ONG_COLUMN%>" />
							</th>
							<th class="thList">
								FC&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.FC_COLUMN%>" />
							</th>
							<th class="thList">
								ADO&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.ADO_COLUMN%>" />
							</th>
							<th class="thList">
								PAD&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.PAD_COLUMN%>" />
							</th>
							<%
							  // STGAP00006019 Change the RD heading to FAD and add PFC stage  to view
							%>
							<th class="thList">
								FAD&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.FAD_COLUMN%>" />
							</th>
							<th class="thList">
								PFC&nbsp;
								<impact:sortableColumnHeader
									orderBy="<%=DynamicUnitEmpLinkDAO.PFC_COLUMN%>" />
							</th>
							<th class="thList">
								Total
							</th>
							<th class="thListRight">
								Staff ID
							</th>
						</tr>
						<%
						  loopCount = 0;
						        Enumeration unitEnumeration5 = unitArray.enumerateROWCCMN29SOG01();
						        ROWCCMN29SOG01 unitRow = null;

						        while (unitEnumeration5.hasMoreElements()) {
						          unitRow = (ROWCCMN29SOG01) unitEnumeration5.nextElement();
						          //SIR 18728 - hyperlink doesn't work with names that include apostrophe
						          StringBuffer strTemp = new StringBuffer();
						          StringTokenizer split = new StringTokenizer(unitRow.getSzNmPersonFull(), "'");
						          strTemp.append(split.nextToken());
						          while (split.hasMoreTokens()) {
						            strTemp.append("\\'");
						            strTemp.append(split.nextToken());
						          }
						%>
						<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>"
							valign="top">
							<td>
								<a
									href="javascript: submitPersonID('<%=unitRow.getUlIdPerson()%>' , '<%=strTemp%>', '' )"><%=unitRow.getSzNmPersonFull()%></a>
							</td>
							<td align="center">
								<%
								  if ("IN".equalsIgnoreCase(unitRow.getSzCdUnitMemberInOut())) {
								%><img
									alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif"
									border="0">
								<%
								  }
								%>
							</td>
						    <%-- Adding Errors and Numbers--%>
						    <td width=60px>
						      <impact:ifThen test='<%=((unitRow.getNbrErrors() > 0)||(unitRow.getNbrWarnings() > 0))%>'>
						  	    <span style="color:red"><%=unitRow.getNbrErrors() > 0 ? unitRow.getNbrErrors() : "0"%></span>&nbsp;/&nbsp;
						  	    <span style="color:blue"><%=unitRow.getNbrWarnings() > 0 ? unitRow.getNbrWarnings() : "0"%></span>
						      </impact:ifThen> 
						    </td>							
							<td>
								<%
								  //-- a value of -1 in these fields represents "data not found or available"
								          //-- refer to RetrieveUnitSummaryImpl.findUnitEmp
								          if (unitRow.getUlNbrINT() != -1) {
								%><%=unitRow.getUlNbrINT()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrINV() != -1) {
								%><%=unitRow.getUlNbrINV()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrDIV() != -1) {
								%><%=unitRow.getUlNbrDIV()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrONG() != -1) {
								%><%=unitRow.getUlNbrONG()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrFC() != -1) {
								%><%=unitRow.getUlNbrFC()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrADO() != -1) {
								%><%=unitRow.getUlNbrADO()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrPAD() != -1) {
								%><%=unitRow.getUlNbrPAD()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrFAD() != -1) {
								%><%=unitRow.getUlNbrFAD()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if (unitRow.getUlNbrPFC() != -1) {
								%><%=unitRow.getUlNbrPFC()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
							<td>
								<%
								  if ("true".equals(primaryAssignment) || "true".equals(totalAssignment)) {
								%>
								<%=unitRow.getUsScrNbrTotPAssignments()%>
								<%
								  }
								%>
							</td>
							<td align="right">
								<%
								  if (unitRow.getUlIdPerson() != -1) {
								%><%=unitRow.getUlIdPerson()%>
								<%
								  } else {
								%>n/a<%
								  }
								%>
							</td>
						</tr>
						<%
						  loopCount++;
						        } // end while
						%>
					</table>
				</td>
			</tr>
		</table>
	</impact:pagination>
	<br>

	<%
	  }
	%>
	<input type="hidden" name="filterBy" value="">
	<input type="hidden" name="personId" value="">
	<input type="hidden" name="personNmWorkload" value="">
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

<%
  if (hasChildUnits) {
%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborderList">
			<tr>
				<th colspan="5">
					Direct Reporting Units
				</th>
			<tr>
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
						<tr>
							<td class="thList">
								Unit
							</td>
							<td class="thList">
								Unit Approver
							</td>
							<td class="thList">
								Specialization
							</td>
						</tr>
						<%int reportingUnitsLoopCount = 0;
						for (Enumeration<ROWCCMN24SOG01> e = reportingUnitsInfoRowArray.enumerateROWCCMN24SOG01(); e.hasMoreElements();) {
          ROWCCMN24SOG01 reportingUnitsInfoRow =  e.nextElement();
          String ruSzNmPersonFull = FormattingHelper.formatString(reportingUnitsInfoRow.getSzNmPersonFull());
 		  String ruSzCdUnitSpecialization = FormattingHelper.formatString(reportingUnitsInfoRow.getSzCdUnitSpecialization());
          %>
						<tr class="<%= FormattingHelper.getRowCss( reportingUnitsLoopCount + 1 ) %>">
					      <td>
					      <% int ruIdUnit = reportingUnitsInfoRow.getUlIdUnit();
        					 String ruNbrUnit = reportingUnitsInfoRow.getSzNbrUnit();
        					 String ruCounty = reportingUnitsInfoRow.getSzCdUnitCounty();
        					 // Need to get ru Region, using the user's region could cause errors
        					 // in case of viewing regional directors' units
        					 String ruRegion = reportingUnitsInfoRow.getSzCdUnitRegion();
        				 	 if(ruIdUnit >= 0 && ruNbrUnit != null){
					      %>
				          <a href="/workload/UnitSummary/searchUnitSummary?txtszNbrUnit=<%= ruNbrUnit %>&selCounty=<%= ruCounty %>&selRegDiv=<%= ruRegion %>" >
				            <%= ruNbrUnit %>
				          </a>
                          <% } else{ %>
                               &nbsp;
                          <% } %>
                          </td>
                          <td>
                          <%  if (ruSzNmPersonFull.equals("") || ruSzNmPersonFull == null) { %>
                                 &nbsp;
                          <%  } else { %>
                                <%= ruSzNmPersonFull %>
                          <%  } %>
                          </td>
                          <td>
                          <% if(ruSzCdUnitSpecialization != null){ %>
                          <%= ( ruSzCdUnitSpecialization.length() != 0 ) ? Lookup.simpleDecode( CodesTables.CSPCUNTS, ruSzCdUnitSpecialization ) : "" %>
                          <% } else{ %>
                          <%= "" %>
                          <% } %>
                          </td>
						</tr>

<%
          reportingUnitsLoopCount++;
        }
%>
					</table>
				</td>
			</tr>
	</table>
<%
  }
%>

</impact:validateForm>
<%
  /* Close Validate Form Custom Tag */
%>



