
<%--
JSP Name:     NonIncidentAFCARSInformation.jsp
Date Created: 03/27/08

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------------------------------------
07/01/08  mchillman         JSP creation
10/1/08   sroberts          Updated JSP per the design spec for R3.0
02/04/09  wjcochran         STGAP00012148: Added Mother Married at Birth Information
02/26/09  wjcochran         STGAP00012148: Changed Mother Married at Birth information to be
                            a non-editable field
02/03/10  hjbaptiste  		SMS#44783: MR-60 Changes, Primary Special Needs drop down, new types added.                               
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.NonIncidentAFCARSInformationSO"%>


<%
  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  
  NonIncidentAFCARSInformationSO nonIncidentAFCARSInformationSO = (NonIncidentAFCARSInformationSO) state.getAttribute("nonIncidentAFCARSInformationSO", request);
  Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );
  List motherRaceValues = new ArrayList<String>();
  List fatherRaceValues = new ArrayList<String>();
  List raceValues = new ArrayList<String>();
  
%>

<script language="JavaScript">

// make sure that the race checkboxes are cleared if the undecided checkbox is checked
function clearRaces( paramCbx, paramGroup )
{
  var raceLen = <%= Lookup.getCategoryCollection( CodesTables.CRACE ).size() %>;

  if ( paramCbx.checked == true )
  {
    // if you checked the Unable to Determine checkbox, make sure that all the others
    // are unchecked
    if ( paramCbx.value == "<%= CodesTables.CRACE_UD  %>" )
    {
      for ( var i = 1; i <= raceLen; i++ )
      {
        var cbxId = paramGroup + i + "_id";
        var currentCbx = document.getElementById( cbxId );
        if ( currentCbx.value != "<%= CodesTables.CRACE_UD %>" )
        {
          currentCbx.checked = false;
          currentCbx.fireEvent("onClick");
        }
      }
    }
    // else, if you checked any others, make sure Unable to Determine is unchecked
    else
    {
      for ( var i = 1; i <= raceLen; i++ )
      {
        var cbxId = paramGroup + i + "_id";
        var currentCbx = document.getElementById( cbxId );
        if ( currentCbx.value == "<%= CodesTables.CRACE_UD %>" )
        {
          currentCbx.checked = false;
          currentCbx.fireEvent("onClick");
        }
      }
    }
  }
}

</script>

<impact:validateErrors formName="frmNonIncidentAFCARSInformation" />
<impact:validateForm name="frmNonIncidentAFCARSInformation"
	action="/person/NonIncidentAFCARSInformation/saveAFCARSInformation"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.NonIncidentAFCARSInformationCustomValidation"
	pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">

	<!-- Child Information HTML Table -->
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%" id="TABLE1">
		<tr>
			<th colspan="3">
				Child Information
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate label="Date Application Sent"
					name="dtApplicationSent" constraint="Date" value="<%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtApplicationSent())%>" type="text"
					size="10" tabIndex="<%=tabIndex++%>" 
					disabled="true" />
			</td>
			<td>
				DFCS County: <%= Lookup.simpleDecodeSafe(CodesTables.CCOUNT, nonIncidentAFCARSInformationSO.getCdPlacmentCounty())%>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				Case Worker: <%= nonIncidentAFCARSInformationSO.getNmEmployee() %>&nbsp; <%= nonIncidentAFCARSInformationSO.getEmployeePhone()%>
			</td>
		</tr>
	</table>
	<!-- End Child Information Table -->

	<!-- Child Characteristics HTML Table -->
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
		width="100%" id="TABLE3">
		<tr>
			<th colspan="4">
				Special Needs Characteristics
			</th>
		</tr>
		<tr class="subDetail">
			<td colspan="4">
				Primary Special Need?
			</td>
		</tr>
		<tr class="subDetail">
			<td colspan="4">
	               <impact:validateSelect name="szCdPrmSpcNeed"
					     label="" tabIndex="<%=tabIndex++%>"
					     codesTable="CPRSPCLN" value="<%= nonIncidentAFCARSInformationSO.getCdPrimSpecNeed() %>" disabled="true"/> 			
			</td>			
		</tr>	
			<td>
				<impact:validateInput name="cbxMntlRetard"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01)%>"
					cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
					checked="<%= ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndMentRetard()))?"true":"false" %>" value="Y" 
					disabled="true" />
			</td>
			<td>
				<impact:validateSelect name="szCdMntRetSevLevel" label=""
					tabIndex="<%=tabIndex++%>" codesTable="CADSEVER" value="<%= nonIncidentAFCARSInformationSO.getCdSevMentRetard() %>" />
			</td>
			<td colspan="2">
				&nbsp;
			</td>						
		</tr>
		<tr class="subDetail">
			<td>
				<impact:validateInput name="cbxVislHearImp"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02)%>"
					cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
					checked="<%= ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndVisHearImp()))?"true":"false" %>" value="Y" 
					disabled="true" />
			</td>
			<td>
				<impact:validateSelect name="szCdVisHearSevLevel" label=""
					tabIndex="<%=tabIndex++%>" codesTable="CADSEVER" value="<%= nonIncidentAFCARSInformationSO.getCdSevVisHearImp()%>" />
			</td>
			<td colspan="2">
				&nbsp;
			</td>			
		</tr>
		<tr class="subDetail">

			<td>
				<impact:validateInput name="cbxPhyDisabled"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03)%>"
					cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
					checked="<%= ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndPhyDisabled()))?"true":"false"%>" value="Y" 
					disabled="true"/>
			</td>
			<td>
				<impact:validateSelect name="szCdPhyDisSevLevel" label=""
					tabIndex="<%=tabIndex++%>" codesTable="CADSEVER" value="<%= nonIncidentAFCARSInformationSO.getCdSevPhyDisabled()%>" />
			</td>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>
		<tr class="subDetail">

			<td>
				<impact:validateInput name="cbxEmtDisturbed"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04)%>"
					cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
					checked="<%= ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndEmtDisturbed()))?"true":"false" %>" value="Y" 
					disabled="true" />
			</td>
			<td>
				<impact:validateSelect name="szCdEmtDistSevLevel" label=""
					tabIndex="<%=tabIndex++%>" codesTable="CADSEVER" value="<%= nonIncidentAFCARSInformationSO.getCdSevEmtDisturbed() %>" />
			</td>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>
		<tr class="subDetail">

			<td>
				<impact:validateInput name="cbxOthMedDiag"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05)%>"
					cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
					checked="<%= ArchitectureConstants.Y.equals(FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getIndOthMedDiag()))?"true":"false" %>" value="Y" 
					disabled="true" />
			</td>
			<td>
				<impact:validateSelect name="szCdOthMedDiagSevLevel" label=""
					tabIndex="<%=tabIndex++%>" codesTable="CADSEVER" value="<%= nonIncidentAFCARSInformationSO.getCdSevOthMedDiag()%>" />
			</td>
			<td colspan="2">
				&nbsp;
			</td>			
		</tr>
	</table>
	<!-- End Child Characteristics Table -->
    <br>

	<!-- Birth Parents Expandable/Collapsable Section -->
	<impact:ExpandableSectionTag name="BirthParents" id=""
		label="Birth Parents" tabIndex="<%=tabIndex++%>">
		
		<!-- Child Birth Name Table -->
		<table border="0" cellspacing="0" cellpadding="0" width="100%" class="tableborder">
		  <tr><td>
		  <table border="0" cellspacing="0" cellpadding="3" width="100%">  
			<tr>
				<th colspan="8">
					Child Birth Name
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateInput type="text" label="First Name"
						constraint="Name12" name="txtSzNmBirthNameFirst" cssClass="formInput"
						value="<%= nonIncidentAFCARSInformationSO.getNmBirthNameFirst() %>" size="12" maxLength="12" tabIndex="<%= tabIndex++ %>" />
				</td>
				<td>
					<impact:validateInput type="text" label="Middle Name"
						constraint="Name12" name="txtSzNmBirthNameMiddle" cssClass="formInput"
						value="<%= nonIncidentAFCARSInformationSO.getNmBirthNameMiddle() %>" size="12" maxLength="12" tabIndex="<%= tabIndex++ %>" />
				</td>
				<td>
					<impact:validateInput type="text" label="Last name"
						constraint="Name22" name="txtSzNmBirthNameLast" cssClass="formInput"
						value="<%= nonIncidentAFCARSInformationSO.getNmBirthNameLast() %>" size="22" maxLength="22" tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>
		  </table>
		  <!-- End Child Birth Name Table -->
		  
		  
		 <!-- Birth Mother Table --> 
		 <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
		  <tr>
		    <th colspan="4">Birth Mother</th>
		  </tr>
		  <tr class="subDetail">
			<td>
				Mother Married At Child's Birth:
			</td>
		  	<td>
		  		<%=Lookup.simpleDecodeSafe(CodesTables.CMOTHMAR, nonIncidentAFCARSInformationSO.getIndBMMarriedAtChildBrth())%>
		  	</td>
		  	<td colspan="2">
		  	</td>
		  </tr>
		  <tr class="subDetail">
		    <td>
		        <impact:validateDate name="txtDtBMDOB"
                              label="Date of Birth"
                              constraint="Date"
                              value="<%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthMotherDOB()) %>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>
		    </td>
		    <td>
		       	<impact:validateSelect name="szCdBMTermType" label="Termination Type"
					tabIndex="<%=tabIndex++%>" codesTable="CTRMTYPE" value="<%= nonIncidentAFCARSInformationSO.getCdBirthMotherTermType()%>" />
		    </td>
		  </tr>
		  <tr class="subDetail">
		    <td>
		        <impact:validateDate name="txtDtBMRightsTerm"
                              label="Date Rights Terminated"
                              constraint="Date"
                              value="<%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthMotherRightsTerm()) %>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>    
		    </td>
		    <td>&nbsp;</td>
		    <td>&nbsp;</td>
		  </tr>
		</table>
		<!-- End Birth Mother Table -->
		  
		
		  <!-- Birth Mother's Race/Ethnicity Table -->
		  <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
			<tr>
				<th colspan="8">
					Birth Mother's Race
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:codesCheckbox defaultCodes="<%= nonIncidentAFCARSInformationSO.getBMRaceList() %>"
						name="cbxMotherRace"
						codesTableName="<%= CodesTables.CRACE %>"
						onClick="clearRaces(this,'cbxMotherRace')" columns="3" isHorizontal="true"
						tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>
			<tr>
				<th>
					Birth Mother's Ethnicity
				</th>
			</tr>
            <tr class="subDetail">
				<td>
					<table width="100%">
						<tr>
							<%
                               for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
                               {
                                   Mapping ethnicity = (Mapping) ethIterator.next();
                            %>
							       <td>
								        <impact:validateInput value="<%= ethnicity.getKey() %>"
									      tabIndex="<%= tabIndex++ %>"
									      name="rbMotherEthnicity"
									      type="radio" checked="<%= String.valueOf( ethnicity.getKey().equals( nonIncidentAFCARSInformationSO.getCdBMEthnicity()) ) %>" />
								        <%= ethnicity.getValue() %>
							      </td>
							<%
                               }
                            %>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- End Birth Mother's Race/Ethnicity Table -->
		
		<!-- Birth Father Table --> 
		<table border="0" cellspacing="0" cellpadding="3" width="100%"> 
		  <tr>
		    <th colspan="4">Birth Father</th>
		  </tr>
		  <tr class="subDetail">
		    <td>
		        <impact:validateDate name="txtDtBFDOB"
                              label="Date of Birth"
                              constraint="Date"
                              value="<%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthFatherDOB())%>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>
		    </td>
		    <td>
		       	<impact:validateSelect name="szCdBFTermType" label="Termination Type"
					tabIndex="<%=tabIndex++%>" codesTable="CTRMTYPE" value="<%= nonIncidentAFCARSInformationSO.getCdBirthFatherTermType()%>" />
		    </td>
		  </tr>
		  <tr class="subDetail">
		    <td>
		        <impact:validateDate name="txtDtBFRightsTerm"
                              label="Date Rights Terminated"
                              constraint="Date"
                              value="<%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtBirthFatherRightsTerm())%>"
                              size="10"
                              tabIndex="<%= tabIndex++ %>"/>    
		    </td>
		    <td>&nbsp;</td>
		    <td>&nbsp;</td>

		  </tr>
		</table>
		<!-- End Birth Father Table --> 
		
		<!-- Birth Father's Race/Ethnicity Table -->
		  <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
			<tr>
				<th colspan="8">
					Birth Father's Race
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:codesCheckbox defaultCodes="<%= nonIncidentAFCARSInformationSO.getBFRaceList() %>"
						name="cbxFatherRace"
						codesTableName="<%= CodesTables.CRACE %>"
						onClick="clearRaces(this,'cbxFatherRace')" columns="3" isHorizontal="true"
						tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>
			<tr>
				<th>
					Birth Father's Ethnicity
				</th>
			</tr>
            <tr class="subDetail">
				<td>
					<table width="100%">
						<tr>
							<%
                               for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
                               {
                                   Mapping ethnicity = (Mapping) ethIterator.next();
                            %>
							       <td>
								        <impact:validateInput value="<%= ethnicity.getKey() %>"
									      tabIndex="<%= tabIndex++ %>"
									      name="rbFatherEthnicity"
									      type="radio" checked="<%= String.valueOf( ethnicity.getKey().equals( nonIncidentAFCARSInformationSO.getCdBFEthnicity()) ) %>" />
								        <%= ethnicity.getValue() %>
							      </td>
							<%
                               }
                            %>
						</tr>
					</table>
				</td>
			</tr>
		</table>		
		<!-- End Birth Father's Race/Ethnicity Table -->	
		</td></tr>
      </table>
	</impact:ExpandableSectionTag>
    <!-- End Birth Parents Expandable/Collapsable Section -->
    <br>

    <!-- Adoptive Parents Expandable/Collapsable Section -->
	<impact:ExpandableSectionTag name="AdoptiveParents" id=""
		label="Adoptive Parents" tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="0" width="100%" class="tableborder">
		   <tr class="subDetail"><td>
		       <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
		          <tr>
		             <td>Family Structure:&nbsp;<%=Lookup.simpleDecodeSafe(CodesTables.CMARSTAT,nonIncidentAFCARSInformationSO.getCdMaritalStatus()) %></td>
		             <td>&nbsp;</td>
		             <td>&nbsp;</td>
		             <td>&nbsp;</td>
		          </tr>
		          <tr>
		             <td>Child Placed From:&nbsp;<%=FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getCdPlacementFrom()) %></td>
		             <td>&nbsp;</td>
		             <td>Child Placed By:&nbsp;<%=FormattingHelper.formatString(nonIncidentAFCARSInformationSO.getCdPlcmtBy()) %></td>
		             <td>&nbsp;</td>
		          </tr>		       
		       </table>
		       <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
		          <tr>
		             <th colspan="12">Adoptive Parent Is</th>
		          </tr>
		          <tr class="subDetail">
		             <td>
		                <impact:validateInput type="checkbox" label="Non-Relative Caretaker" tabIndex="<%= tabIndex++ %>" 
                           checked="<%=nonIncidentAFCARSInformationSO.getIndAPNonRelative() %>" value="Y" name="cbxAdoPlaceInfo1" cssClass="formInput" disabled="true" />
		             </td>
		             <td>
		                <impact:validateInput type="checkbox" label="Prior Foster Parent" tabIndex="<%= tabIndex++ %>" 
                           checked="<%=nonIncidentAFCARSInformationSO.getIndAPPriorFP()%>" value="Y" name="cbxAdoPlaceInfo2" cssClass="formInput" disabled="true" />
		             </td>
		          </tr>
		          <tr class="subDetail">
		             <td>
		                 <impact:validateInput type="checkbox" label="Other Relative-Birth/Marriage" tabIndex="<%= tabIndex++ %>" 
                            checked="<%=nonIncidentAFCARSInformationSO.getIndAPOtherRelative()%>" value="Y" name="cbxAdoPlaceInfo3" cssClass="formInput" disabled="true"  />
		             </td>
		             <td>
		                 <impact:validateInput type="checkbox" label="Stepparent Caretaker" tabIndex="<%= tabIndex++ %>" 
                            checked="<%=nonIncidentAFCARSInformationSO.getIndAPStepParent()%>" value="Y" name="cbxAdoPlaceInfo4" cssClass="formInput" disabled="true" />  
		             </td>
		          </tr>		       
		       </table>
		       	
		       <!-- Adoptive Mother Table -->	   
		       <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
		          <tr>
		             <th>Adoptive Mother</th>
		          </tr>
		          <tr class="subDetail">
		             <td>Date of Birth: <%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtAdoptiveMotherDOB())%><br>
		                 Ethnicity: <%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, nonIncidentAFCARSInformationSO.getCdAMEthnicity()) %>
		             </td>
		          </tr>		       
		       </table>	
		       <!-- End Adoptive Mother Table -->	   
		   
		   
		      <!-- Adoptive Mother's Race Table -->
			  <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
			    <tr>
				   <th colspan="8">
					  Adoptive Mother's Race
				   </th>
			    </tr>
			    <tr class="subDetail">
				   <td>
					 <impact:codesCheckbox defaultCodes="<%= nonIncidentAFCARSInformationSO.getAmRaceList() %>"
					 	 name="<%= RaceEthnicityHelper.RACE_CB_NAME %>"
						 codesTableName="<%= CodesTables.CRACE %>"
						 onClick="" columns="3" isHorizontal="true"
						 tabIndex="<%= tabIndex++ %>" disabled="true" />
				   </td>
			    </tr>
		      </table>
		      <!-- End Adoptive Mother's Race Table -->
              <!-- Adoptive Father Table -->
	          <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
		          <tr>
		             <th>Adoptive Father</th>
		          </tr>
		          <tr class="subDetail">
		             <td>Date of Birth: <%= FormattingHelper.formatDate(nonIncidentAFCARSInformationSO.getDtAdoptiveFatherDOB())%><br>
		                 Ethnicity: <%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, nonIncidentAFCARSInformationSO.getCdAFEthnicity()) %></td>
		          </tr>		       
		      </table>
		      <!-- End Adoptive Father Table --> 
		     		   
		      <!-- Adoptive Father's Race Table -->
		      <table border="0" cellspacing="0" cellpadding="3" width="100%"> 
			    <tr>
				   <th colspan="8">
					Adoptive Father's Race
				   </th>
			    </tr>
			    <tr class="subDetail">
				   <td>
					  <impact:codesCheckbox defaultCodes="<%= nonIncidentAFCARSInformationSO.getAfRaceList() %>"
						 name="<%= RaceEthnicityHelper.RACE_CB_NAME %>"
						 codesTableName="<%= CodesTables.CRACE %>"
						 onClick="" columns="3" isHorizontal="true"
						 tabIndex="<%= tabIndex++ %>" disabled="true"  />
				   </td>
			    </tr>
	          </table>
	          <!-- End Adoptive Father's Race Table -->		  
	       </td></tr>
        </table>		  
	</impact:ExpandableSectionTag>
    <!-- End Adoptive Parents Expandable/Collapsable Section -->

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td colspan="4">
				<br>
				<hr>
			</td>
		</tr>
		<tr>
			<%
      if (!PageModeConstants.VIEW.equals(pageMode)) {
    %>
			<td class="alignRight">
				<impact:ButtonTag name="btnSave" align="right" img="btnSave"
					form="frmNonIncidentAFCARSInformation"
					action="/person/NonIncidentAFCARSInformation/saveAFCARSInformation"
					restrictRepost="true" preventDoubleClick="true"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
      }
    %>
		</tr>
	</table>
	<br>
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>