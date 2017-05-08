<%--
JSP Name:     ExchangeChildSearch.jsp
Date Created: 03/27/08

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
07/01/08  mchillman         JSP creation
04/15/09  hjbaptiste        STGAP00012912 - Added the form attribute defaultButton='true' to execute the search 
                            when the enter button is pressed
06/05/09  hjbaptiste        STGAP00013455: Set the constraint for Number of Children to 'Numeric'  
11/19/09  arege             SMS#37251 Modified function populateCounty() so that the county drowpdown holds value even after you come back with the 
                            Search results.
11/29/09  mxpatel           37253: Added code to add columns for first name and last name on the page.
04/11/12  kpressl           STGAP00018067 - Removed tag references to regions 16 and 17 for regional drop downs                                                            
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.SortedMap"%>
<%@ page import="java.util.TreeMap" %> 
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchCustomValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="java.util.ArrayList"%>


<%
  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  Object results = null;

  String formName = "frmExchangeChildSerach";

  SortedMap years = new TreeMap();
  if (state.getAttribute("yearsrange", request) != null) {
    years = (SortedMap) state.getAttribute("yearsrange", request);
  }
  SortedMap months = new TreeMap();
  if (state.getAttribute("monthsrange", request) != null) {
    months = (SortedMap) state.getAttribute("monthsrange", request);
  }

  Collection yearOptions = years.values();
  Collection monthOptions = months.values();

  ExchangeChildValueBean childSearchValueBean = (ExchangeChildValueBean) request
                                                                                .getAttribute(ExchangeChildSearchConversation.EXCHANGE_CHILD_SEARCH_BEAN);
  int nbrResults = 0;
  boolean indPullBackMode = false;
  String pullBackMode = (String) state.getAttribute("pullBackMode", request);
  if (pullBackMode != null && ArchitectureConstants.TRUE.equals(pullBackMode)) {
    indPullBackMode = true;
  }
  int maleMaxMonths = childSearchValueBean.getMaleMaxRangeInMonths();
  int maleMinMonths = childSearchValueBean.getMaleMinRangeInMonths();
  int femaleMaxMonths = childSearchValueBean.getFemaleMaxRangeInMonths();
  int femaleMinMonths = childSearchValueBean.getFemaleMinRangeInMonths();

  List<ExchangeChildValueBean> excChildList = null;

  if (request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME) != null) {
    results = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
  }

  if (request.getAttribute(ExchangeChildSearchConversation.EXCHANGE_CHILD_LIST) != null) {
    excChildList = ((PaginationResultBean) results).getResults();
  }
  if (ArchitectureConstants.Y.equals(state.getAttribute("indReturnError", request))) {
    excChildList = new ArrayList<ExchangeChildValueBean>();
    state.removeAttribute("indReturnError", request);
  }

  String resultsPerPageName = DatabaseResultDetails.RESULTS_PER_PAGE_NAME;
  String resultsPerPage = "25";
%>

<script language="JavaScript">

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction() {
  if (document.getElementById("exchangeChildSearchResults")) {
  	document.getElementById("exchangeChildSearchResults").focus();
  }
}

function checkRowSelected(numberOfRows) {
  var rbSelected = false;
  for ( i = 0; i < numberOfRows ; i++ ) {
  	var cbx = document.getElementById("ckName_Link" + i);
    rbSelected = cbx.checked;
    if ( rbSelected ) {
     break;
    }
  }
  if ( !rbSelected )  {
    alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
  }
  return rbSelected
}
function getExchangeChildDetail(recordIndex, idStage)
{
   <%=formName%>.hdnRowIndex.value = recordIndex;
   <%=formName%>.hdnIdStage.value = idStage;
  submitValidateForm( "<%=formName%>", "/exchange/ExchangeChildSearch/displayExchangeChildDetail" );
}

function getPersonDetail(recordIndex, idStage) {
   <%=formName%>.hdnRowIndex.value = recordIndex;
   <%=formName%>.hdnIdStage.value = idStage;
  submitValidateForm(  "<%=formName%>", "/exchange/ExchangeChildSearch/displayPersonDetail" );
}

function getAdoptionInfo(recordIndex, idStage) {
   <%=formName%>.hdnRowIndex.value = recordIndex;
   <%=formName%>.hdnIdStage.value = idStage;
  submitValidateForm(  "<%=formName%>", "/exchange/ExchangeChildSearch/displayAdoInfo" );
}

  //STGAP00018067 - Removed references to regions 16 and 17
  //Get county code/decode array with all data
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT" blankValue="true"/>
  //Get county code/decode array filtered for region 01
  <impact:codeArray codeName="CCOUNT01" arrayName="CCOUNT01" blankValue="true"/>
  //Get county code/decode array filtered for region 02
  <impact:codeArray codeName="CCOUNT02" arrayName="CCOUNT02" blankValue="true"/>
  //Get county code/decode array filtered for region 03
  <impact:codeArray codeName="CCOUNT03" arrayName="CCOUNT03" blankValue="true"/>  
  //Get county code/decode array filtered for region 04
  <impact:codeArray codeName="CCOUNT04" arrayName="CCOUNT04" blankValue="true"/>
  //Get county code/decode array filtered for region 05
  <impact:codeArray codeName="CCOUNT05" arrayName="CCOUNT05" blankValue="true"/>
  //Get county code/decode array filtered for region 06
  <impact:codeArray codeName="CCOUNT06" arrayName="CCOUNT06" blankValue="true"/>
  //Get county code/decode array filtered for region 07
  <impact:codeArray codeName="CCOUNT07" arrayName="CCOUNT07" blankValue="true"/>
  //Get county code/decode array filtered for region 08
  <impact:codeArray codeName="CCOUNT08" arrayName="CCOUNT08" blankValue="true"/>
  //Get county code/decode array filtered for region 09
  <impact:codeArray codeName="CCOUNT09" arrayName="CCOUNT09" blankValue="true"/>
  //Get county code/decode array filtered for region 10
  <impact:codeArray codeName="CCOUNT10" arrayName="CCOUNT10" blankValue="true"/>
  //Get county code/decode array filtered for region 11
  <impact:codeArray codeName="CCOUNT11" arrayName="CCOUNT11" blankValue="true"/>
  //Get county code/decode array filtered for region 12
  <impact:codeArray codeName="CCOUNT12" arrayName="CCOUNT12" blankValue="true"/>
  //Get county code/decode array filtered for region 13
  <impact:codeArray codeName="CCOUNT13" arrayName="CCOUNT13" blankValue="true"/>
  //Get county code/decode array filtered for region 14
  <impact:codeArray codeName="CCOUNT14" arrayName="CCOUNT14" blankValue="true"/>
  //Get county code/decode array filtered for region 15
  <impact:codeArray codeName="CCOUNT15" arrayName="CCOUNT15" blankValue="true"/>
  //Get county code/decode array filtered for region 98
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT98" blankValue="true"/>

function populateCounty(onPageLoad) {
 if ( <%=formName%>.szCdRegion.value == <%=CodesTables.CCOUNT_099%> ||
       <%=formName%>.szCdRegion.value == "") {
    clearDropdown ( <%=formName%>.szCdCounty );
    } else {    
      <% String dropdown = childSearchValueBean.getCdCounty()==null?request.getParameter("szCdCounty"):childSearchValueBean.getCdCounty(); %>
      var dropdownValue = "<%=dropdown%>";    
      populateDropdown(<%=formName%>.szCdCounty, dropdownValue, eval("CCOUNT"+<%=formName%>.szCdRegion.value) );
}
}
</script>

<impact:validateErrors formName="frmExchangeChildSerach" />
<impact:validateForm name="frmExchangeChildSerach" 
    defaultButton="true"
	action="/exchange/ExchangeChildSearch/searchExchangeChild"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchCustomValidation"
	pageMode="<%=pageMode%>"
	schema="/WEB-INF/Constraints.xsd">
    <impact:validateInput type="hidden" name="hdnIdStage" value="" />
    <impact:validateInput type="hidden" name="hdnRowIndex" value="" />
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
	<tr>
			<th colspan="12">
				Child Locate
			</th>
	</tr>
	<tr class = "subDetail">
	<td>
	<impact:validateInput name="txtNmFirst" label="First"
						cssClass="formInput" size="12" maxLength="12"
						constraint="Paragraph30" type="text" tabIndex="<%=tabIndex++%>"
						conditionallyRequired = "true"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getNmFirst())%>" />
	</td>
		<td>
	<impact:validateInput name="txtNmMiddle" label="Middle"
						cssClass="formInput" size="12" maxLength="12"
						constraint="Paragraph30" type="text" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getNmMiddle())%>" />
	</td>
	<td>
		<impact:validateInput name="txtNmLast" label="Last"
						cssClass="formInput" size="22" maxLength="22"
						constraint="Paragraph30" type="text" tabIndex="<%=tabIndex++%>"
						conditionallyRequired = "true"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getNmLast())%>" />
	</td>
	</tr>
	<tr class = "subDetail">
   	<td>
	<impact:validateSelect name="szCdRegion" label="Region"
						tabIndex="<%=tabIndex++%>"
						codesTable="CREGIONS"
						conditionallyRequired = "true"
						onChange="populateCounty(false)"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdRegion())%>" />
	</td>
	<td>
	<impact:validateSelect name="szCdCounty" label="County"
						tabIndex="<%=tabIndex++%>"
						codesTable="CCOUNT"
						conditionallyRequired = "true"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdCounty())%>" />
	</td>
	</tr>
	</table>
	<%-- End Child Locate --%>
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
	<tr>
			<th colspan="12">
				Sibling Group Locate
			</th>
	</tr>
	<tr class = "subDetail">
	<td>
	<impact:validateInput name="txtIdSibGroup" label="Sibling Group ID"
						cssClass="formInput" size="16" maxLength="16"
						constraint="Paragraph30" type="text" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatInt(childSearchValueBean.getIdSiblingGrp())%>" />
	</td>
	</tr>
	</table>
	<%-- End Sibling Group Locate --%>
	<br>
	<%-- Begin Search Family Preferences section --%>
	<impact:ExpandableSectionTag name="FamilyPreferenceInfo"
	label="Search Family Preferences" tabIndex="<%=tabIndex++%>" id="">
   <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
	<tr>
	<th colspan="12"> Demographics </th>
	</tr>
	</table>
 <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
  <tr>
    <th colspan="12">Male Age Range</th>
  </tr>
  <tr class="subDetail">
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selMaleMinYearInt"
               label="Min Year"
               blankValue="false"
               disabled="false"
               options="<%=yearOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(maleMinMonths / 12)%>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selMaleMinMonthInt"
               label="Min Month"
               blankValue="false"
               disabled="fasle"
               options="<%=monthOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(maleMinMonths % 12)%>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selMaleMaxYearInt"
               label="Max Year"
               blankValue="false"
               disabled="false"
               options="<%=yearOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(maleMaxMonths / 12)%>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selMaleMaxMonthInt"
               label="Max Month"
               blankValue="false"
               disabled="false"
               options="<%=monthOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(maleMaxMonths % 12)%>"/>
            </td>
          </tr>
          </table>
        <table width="100%" class ="tableborder" cellspacing="0" cellpadding="3">
        <tr>
          <th colspan="12"> Female Age Range</th>
          </tr>
          <tr class="subDetail">
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selFemaleMinYearInt"
               label="Min Year"
               blankValue="false"
               disabled="false"
               options="<%=yearOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(femaleMinMonths / 12)%>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               value=""
               name="selFemaleMinMonthInt"
               label="Min Month"
               blankValue="false"
               disabled="false"
               options="<%=monthOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(femaleMinMonths % 12)%>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selFemaleMaxYearInt"
               label="Max Year"
               blankValue="false"
               disabled="false"
               options="<%=yearOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(femaleMaxMonths / 12)%>"/>
            </td>
            <td><impact:validateSelect
               tabIndex="<%=tabIndex++%>"
               name="selFemaleMaxMonthInt"
               label="Max Month"
               blankValue="false"
               disabled="fasle"
               options="<%=monthOptions%>"
               conditionallyRequired="true"
               value="<%=String.valueOf(femaleMaxMonths % 12)%>"/>
            </td>
          </tr>
  
  </table>
  	<table border="0" cellspacing="0" cellpadding="3" width="100%">
  			<tr class = "subDetail">
  			<td>
  			<impact:validateInput name="txtNbrChildren" label="Number of Children"
						cssClass="formInput" size="2" maxLength="2"
						constraint="Numeric" type="text" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatInt(childSearchValueBean.getNumChildren())%>" />
  			</td>
			<td>
				Legal Risk?
				<impact:validateInput
					checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndLegalRisk())) ? "true"
                                                                                                                           : "false"%>"
					cssClass="formInput" disabled="false" id="indLegalRisk_Yes"
					label="Yes" name="rbIndLegalRisk" tabIndex="<%=tabIndex++%>"
					type="radio" value="Y" />

				<impact:validateInput
					checked="fasle"
					cssClass="formInput" disabled="false" id="indLegalRisk_No"
					label="No" name="rbIndLegalRisk" tabIndex="<%=tabIndex++%>"
					type="radio" value="N" />
			</td>
		</tr>
  	</table>
  <%-- End Demographics --%>
  <%-- Begin Special Needs --%>
          <tr>
          <th colspan="12"> Special Needs</th>
          </tr>
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder"
			width="100%" id="TABLE3">
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxMntlRetard"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndMentalRet())) ? "true"
                                                                                                                           : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdMntRetSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdMentRetSev())%>" />
				</td>
				<td colspan="2" style="font-weight: bold">
					Background Factors:
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxVislHearImp"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y.equals(childSearchValueBean.getIndVisHearImp()) ? "true" : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdVisHearSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdVisHearImpSev())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxFamHxDrgAlcohol"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndFamHxDrAlc())) ? "true"
                                                                                                                            : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxPhyDisabled"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndPhyDisabled())) ? "true"
                                                                                                                             : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdPhyDisSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdPhyDisbldSev())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxFamHxMentIll"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndFamHxMentIll())) ? "true"
                                                                                                                              : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxEmtDisturbed"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndEmotDist())) ? "true"
                                                                                                                          : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdEmtDistSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdEmotDistSev())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxFamHxMR"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean.getIndFamHxMr())) ? "true"
                                                                                                                         : "false"%>"
						value="Y" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput name="cbxOthMedDiag"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndOthMedDiag())) ? "true"
                                                                                                                            : "false"%>"
						value="Y" />
				</td>
				<td colspan="2">
					<impact:validateSelect name="szCdOthMedDiagSevLevel" label=""
						tabIndex="<%=tabIndex++%>" codesTable="CADSEVER"
						value="<%=FormattingHelper.formatString(childSearchValueBean.getCdOthDiagSev())%>" />
				</td>
				<td colspan="2">
					<impact:validateInput name="cbxChHxSxAbuse"
						label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09)%>"
						cssClass="formInput" type="checkbox" tabIndex="<%=tabIndex++%>"
						checked="<%=ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndChildHxSexAbuse())) ? "true"
                                                                                                                                 : "false"%>"
						value="Y" />
				</td>
			</tr>
		</table>
	<%-- End Special Needs --%>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
   <th colspan="12">Race</th>
  </tr>
  <tr class="subDetail">
    <td>
      <impact:codesCheckbox
      name="cbxRace"
      codesTableName="CADRACE"
      defaultCodes="<%=childSearchValueBean.getLstRacePrefs()%>"
      columns="3"
      isHorizontal="true"
      tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  </table>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr>
   <th colspan="12">Ethnicity</th>
  </tr>
            <tr>
	        	<th colspan="4">Child Ethnicity</th>
	  		</tr>
	  		<tr class="subDetail">
		  		 <td>
			      <impact:codesCheckbox
			      name="cbxEthnicity"
			      codesTableName="<%=CodesTables.CINDETHN%>"
			      defaultCodes="<%=childSearchValueBean.getLstEthnicityPrefs()%>"
			      columns="3"
			      isHorizontal="true"
			      disabled="false"/>
			   	</td>
	  		</tr>
        </table>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
         <tr>
   <th colspan="12">Non-Avail Codes</th>
  </tr>
  <tr class="subDetail">
    <td>
      <impact:codesCheckbox
      name="cbxNonAvlCodes"
      codesTableName="CANONAV"
      defaultCodes="<%=childSearchValueBean.getLstNonAvailCodes()%>"
      columns="3"
      isHorizontal="true"
      tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
     </impact:ExpandableSectionTag>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">

    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnSearch"
	                        img="btnSearch"
	                        align="right"
	                        form="frmExchangeChildSerach"
	                        action="/exchange/ExchangeChildSearch/searchExchangeChild"
	                        tabIndex="<%=tabIndex++%>"/>
      </td>
    </tr>
   </table>
	<%-- End Search Family Preferences section --%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />  
</impact:validateForm>

  <%-- Begin Search Results Form --%>
  
<impact:validateForm name="frmExchangeChildResult" 
method="post" 
action="/exchange/ExchangeChildSearch/searchExchangeChild" 
pageMode="<%=pageMode%>" 
schema="/WEB-INF/Constraints.xsd">
  <%
    if (!FormValidation.pageHasErrorMessages(request)
          && !FormValidation.pageHasValidationMessages("frmExchangeChildResult", request)) {
        if (ExchangeChildSearchConversation.SEARCH_URL.equals(ContextHelper.getPreviousUrl(request))
            || ExchangeChildSearchConversation.DISPLAY_URL.equals(ContextHelper.getPreviousUrl(request))
            || indPullBackMode) {
  %>

  <impact:pagination submitUrl="<%=ExchangeChildSearchConversation.SEARCH_URL%>">

	<input type="hidden"  name="requestFromListPage" value="ExchangeChildSearch"/>
    <div class="alignRight">
      <div class="formInstruct">
        Scroll for more information -->
      </div>
    </div>
    <div id="exchangeChildSearchResults" style="height:200px; width:765px; overflow:auto" class="tableborderList">
      <table border="0" cellpadding="3" cellspacing="0" width="100%" id="TABLEEXCH">
        <%
          ExchangeChildValueBean childRow = null;
                  int iLoopCounter = 0;
                  if (excChildList == null || excChildList.isEmpty()) {
        %>
        <tr>
             <th class="thList">&nbsp;</th>
             <th class="thList">Last Name</th>
             <th class="thList">First Name</th>
             <th class="thList">Person ID</th>
             <th class="thList">Sibling Grp ID</th>
             <th class="thList">Availability Code</th>
             <th class="thList">County</th>
             <th class="thList">Date Out</th>
        </tr>
        <tr class="tableBG">
          <td colspan="9" class="subDetail">
            <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
          </td>
        </tr>
        <%
          } else {
        %>
        <tr>
             <th class="thList">&nbsp;</th>
             <th class="thList">Last Name<impact:sortableColumnHeader orderBy="NM_PERSON_LAST"/></th>
             <th class="thList">First Name<impact:sortableColumnHeader orderBy="NM_PERSON_FIRST"/></th>
             <th class="thList">Person ID<impact:sortableColumnHeader orderBy="ID_PERSON"/></th>
             <th class="thList">Sibling Grp ID<impact:sortableColumnHeader orderBy="ID_SIBLING_GROUP"/></th>
             <th class="thList">Availability Code<impact:sortableColumnHeader orderBy="CD_NON_AVAIL_STATUS"/></th>
             <th class="thList">County<impact:sortableColumnHeader orderBy="CD_LEGAL_STAT_CNTY"/></th>
             <th class="thList">Date Out<impact:sortableColumnHeader orderBy="DT_OUT"/></th>
             
        </tr>
        <%
          nbrResults = excChildList.size();
                    for (int count = 0; count < nbrResults; count++) {
                      ExchangeChildValueBean childValueBean = excChildList.get(count);
        %>
        	<tr>
         <%
           if (indPullBackMode) {
                         String chckBoxName = "ckName_Link" + count;
         %>
            <td>
            <impact:validateInput value="<%=String.valueOf(count)%>"
              type="checkbox" checked="false"
              name="<%=chckBoxName%>"
              tabIndex="<%=tabIndex++%>"
              cssClass="formInput" />
		    </td>
         			<%
         			  } else {
         			%>
         				<td><nobr></nobr></td>
         			<%
         			  }
         			              if (!indPullBackMode) {
         			%>
            <td>
            <a href="javascript:getExchangeChildDetail('<%=count%>', '<%=childValueBean.getIdStage()%>')" onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
		          <%=FormattingHelper.formatString(childValueBean.getNmLast())%>
		    </a></td>
		    <td>
            <a href="javascript:getExchangeChildDetail('<%=count%>', '<%=childValueBean.getIdStage()%>')" onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
		          <%=FormattingHelper.formatString(childValueBean.getNmFirst()) + " " + ((childValueBean.getNmMiddle() == null) || ("".equals(childValueBean.getNmMiddle())) ? "" : FormattingHelper.formatString(childValueBean.getNmMiddle().substring(0,1)))%>
		    </a></td>
            <td><a href="javascript:getPersonDetail('<%=count%>', '<%=childValueBean.getIdStage()%>')" onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
		          <%=FormattingHelper.formatInt(childValueBean.getIdChild())%>
		    </a></td>
		    <%
		      if (childValueBean.getIdSiblingGrp() > 0) {
		    %>
		    <td><a href="javascript:getAdoptionInfo('<%=count%>', '<%=childValueBean.getIdStage()%>')" onclick="setIsDirtyCalled(true)" tabIndex="<%=tabIndex++%>">
		          <%=FormattingHelper.formatInt(childValueBean.getIdSiblingGrp())%>
		    </a></td>
		    <%
		      } else {
		    %>
            <td></td>
            <%
              }
                          } else {
            %>
            <td><%=FormattingHelper.formatString(childValueBean.getNmLast())%></td>
            <td><%=FormattingHelper.formatString(childValueBean.getNmFirst()) + " " + ((childValueBean.getNmMiddle() == null) || ("".equals(childValueBean.getNmMiddle())) ? "" : FormattingHelper.formatString(childValueBean.getNmMiddle().substring(0,1)))%></td>
            <td><%=FormattingHelper.formatInt(childValueBean.getIdChild())%></td>
            <td><%=FormattingHelper.formatInt(childValueBean.getIdSiblingGrp())%></td>
            <%
              }
            %>
            <td><%=Lookup.simpleDecodeSafe(CodesTables.CANONAV, childValueBean.getNonAvailCode())%></td>                          
            <td><%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, childValueBean.getCdCounty())%></td>
            <td><%=FormattingHelper.formatDate(childValueBean.getDtOut())%></td>
        </tr>

<%
  }
          }
%>
        </table>
    </div><%
      /* this is where the "scrollBar" div tag ends */
    %>
    </impact:pagination>
<input type="hidden" name="<%=resultsPerPageName%>" value="<%=resultsPerPage%>"/> 
     <%
        String functionString = "disableValidation('frmExchangeChildResult'); return checkRowSelected( "
                                      + nbrResults + ");";
              if (indPullBackMode && nbrResults != 0) {
      %> 
    	<table border="0" cellspacing="0" cellpadding="3" width="100%">

    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnContinue"
	                        img="btnContinue"
	                        align="right"
	                        form="frmExchangeChildResult"
	                        function = "<%=functionString%>"
	                        action="/exchange/ExchangeChildSearch/pullBackExchangeChildDetail"
	                        tabIndex="<%=tabIndex++%>"/>
      </td>
    </tr>
   </table>
     <%
       }
           }
         }
     %>
  <br>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />  
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  populateCounty(true);
</script>