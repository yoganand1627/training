<%//*  JSP Name:     Income and Resources
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 11/10/2002
      //*
      //*  Description:
      //*  This JSP is used to maintain a Person's Income and Resource information
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       02/26/07  N .Hegde          Changed label from "Effective From" to Start Date
       and "Effective To" to End Date
       07/27/06  V. Vo             Changed txtSzTxtIncRsrcDesc label from
       "Description" to "Comments"
       Renamed "Source" to "Source/Employer"
       Added Date Modified 
       06/09/03  Todd Reser        SIR 18081 Changed txtSzTxtIncRsrcDesc label from
       "Comments" to "Description"
       08/26/03  A.Corley          SIR 19536 Cancel validation when deleting
       08/18/05  Todd Reser        SIR 23759 - Use new APS CINC2 and CRSRC2 Codes
       Tables when necessary
       */

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
       for Tuxedo service calls.  Xml output structs corresponding to the services
       called to retrieve data for this page should be used on this page and
       therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC29SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>

<%
      //Get the output object from the request
      ROWCCFC29SOG00 rowccfc29sog00 = (ROWCCFC29SOG00) request.getAttribute("ROWCCFC29SOG00");
      String lAmtIncRsrcMonth = (String) request.getAttribute("lAmtIncRsrcMonth");
      String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
      String szCdIncRsrcType = StringHelper.EMPTY_STRING;
      String szCdFrequency = StringHelper.EMPTY_STRING;

      //SIR 23759 - Added SzCdStageProgram in case we know the Stage Program Type
      String szCdStageProgram = GlobalData.getSzCdStageProgram(request);

      if (rowccfc29sog00 == null) {
        rowccfc29sog00 = new ROWCCFC29SOG00();
        if (request.getParameter("selSzCdIncRsrcType") != null) {
          szCdIncRsrcType = request.getParameter("selSzCdIncRsrcType");
        }
        if (request.getParameter("selSzCdFrequency") != null) {
          szCdFrequency = request.getParameter("selSzCdFrequency");
        }
      } else {
        szCdIncRsrcType = rowccfc29sog00.getSzCdIncRsrcType();
        szCdFrequency = rowccfc29sog00.getSzCdIncRsrcFreqType();
      }

      String pageModePassed = StringHelper.EMPTY_STRING;
      String overallPageMode = PageModeConstants.EDIT;

      if (request.getAttribute("pageMode") != null) {
        pageModePassed = (String) request.getAttribute("pageMode");
        if (pageModePassed.equals(PageModeConstants.MODIFY)) {
          overallPageMode = PageModeConstants.EDIT;
        } else if (pageModePassed.equals(PageModeConstants.NEW)) {
          overallPageMode = PageModeConstants.NEW;
        } else if (pageModePassed.equals(PageModeConstants.VIEW)) {
          overallPageMode = PageModeConstants.VIEW;
        }
      }
      boolean defaultButton = PageModeConstants.NEW.equals(overallPageMode);

      %>
<%// Start Javascript Section %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">

 //Start javascript funcitons here
  //Create javascript functions here for each action on the page
  //All form submits should use the submitValidateForm function to submit

<%
  //SIR 23759 - In case we don't have a Stage Program default to CINCRSRC  
  String incomeCodesTableString = CodesTables.CINC;
  String resourceCodesTableString = CodesTables.CRSRC;  
  String frequencyCodesTableString = CodesTables.CFREQ;

  //SIR 23759 - Use new APS Income and Resources if the Stage Program is APS
  /* 8/3/2006 - Not for GA
  if ("APS".equals(szCdStageProgram) || "AFC".equals(szCdStageProgram))
  {
    incomeCodesTableString = "CINC2";
    resourceCodesTableString = "CRSRC2";
  }
  //SIR 23759 - Use CPS Income and Resources if the Stage Program is CPS
  if ("CCL".equals(szCdStageProgram) || "CPS".equals(szCdStageProgram) ||
    "RCL".equals(szCdStageProgram)) {
    incomeCodesTableString = CodesTables.CINC;
    resourceCodesTableString = CodesTables.CRSRC;
  }*/
%>
<impact:codeArray codeName="<%=incomeCodesTableString%>" arrayName="incomeCodes" blankValue="true"/>
<impact:codeArray codeName="<%=resourceCodesTableString%>" arrayName="resourceCodes" blankValue="true"/>
<impact:codeArray codeName="<%=frequencyCodesTableString%>" arrayName="frequencyCodes" blankValue="true"/>

 function updateType( )
 {
   var buttonGroup = document.frmIncRsrcDetail.rbSzCdIncRsrcIncome;
   var radioValue = getSelectedRadioValue( buttonGroup );
   if ( radioValue == "INC" )
   {
     populateDropdown( frmIncRsrcDetail.selSzCdIncRsrcType , frmIncRsrcDetail.selSzCdIncRsrcType.value , incomeCodes );        
   }
   else
   {
     populateDropdown( frmIncRsrcDetail.selSzCdIncRsrcType , frmIncRsrcDetail.selSzCdIncRsrcType.value, resourceCodes );      
   }
   populateDropdown( frmIncRsrcDetail.selSzCdFrequency , frmIncRsrcDetail.selSzCdFrequency.value , frequencyCodes );
 }
 function populateFrequency() 
 {
   populateDropdown( frmIncRsrcDetail.selSzCdFrequency , frmIncRsrcDetail.selSzCdFrequency.value , frequencyCodes );
 }

 function deleteRow()
 {
   var bRow = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
   return bRow;
 }

function isInState()
{
    return false;
}

 //  Called onUnload of page to remind user unsaved data will be lost
 window.onbeforeunload = function ()
 {
   IsDirty();
 }


//End Java Script
</script>

<%//Declare and initialize control variables for the page
      /* Assign tab-index */
      int tabIndex = 1;

      boolean bIncome = true;
      boolean bResource = false;
      if (rowccfc29sog00 != null && rowccfc29sog00.getSzCdIncRsrcIncome() != null
          && "INC".equals(rowccfc29sog00.getSzCdIncRsrcIncome())) {
        bIncome = true;        
      } else if (rowccfc29sog00 != null && rowccfc29sog00.getSzCdIncRsrcIncome() != null
                 && "RES".equals(rowccfc29sog00.getSzCdIncRsrcIncome())) {
        bResource = true;
        bIncome = false;        
      }

      AdminAddressPhoneBean addressPhoneBean = new AdminAddressPhoneBean();
      addressPhoneBean.setAddress1(rowccfc29sog00.getSzTxtIncRsrcSrcAddrStLn1());
      addressPhoneBean.setAddress2(rowccfc29sog00.getSzTxtIncRsrcSrcAddrStLn2());
      addressPhoneBean.setZipAndSuff(rowccfc29sog00.getSzTxtIncRsrcSrcAddrZip());
      addressPhoneBean.setCity(rowccfc29sog00.getSzTxtIncRsrcSrcAddrCity());
      addressPhoneBean.setState(rowccfc29sog00.getSzTxtIncRsrcSrcAddrState());
      addressPhoneBean.setCounty(rowccfc29sog00.getSzCdIncRsrcSrcAddrCounty());
      addressPhoneBean.setComments(rowccfc29sog00.getSzTxtIncRsrcSrcAddrCmnts());
      addressPhoneBean.setPhone(rowccfc29sog00.getSzTxtIncRsrcSrcPhoneNum());
      addressPhoneBean.setPhoneExt(rowccfc29sog00.getSzTxtIncRsrcSrcPhoneExt());
      addressPhoneBean.addToRequest(request);

      %>

<impact:validateErrors formName="frmIncRsrcDetail" />
<impact:validateForm name="frmIncRsrcDetail" 
                     method="post" 
                     action="/person/PersonDetail/saveIncRsrc" 
                     pageMode="<%= overallPageMode %>" 
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.IncRsrcCustomValidation" 
                     schema="/WEB-INF/Constraints.xsd">
	<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>
	<impact:validateInput type="hidden" name="hdnTsIncomeLastUpdate" value="<%= DateHelper.toISOString(rowccfc29sog00.getTsLastUpdate()) %>" />
	<impact:validateInput type="hidden" name="hdnUlIdIncRsrc" value="<%= FormattingHelper.formatInt(rowccfc29sog00.getUlIdIncRsrc())%>" />
	<impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>" />
	<%/* Begin Detail */

      %>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th colspan="4">
				Income and Resources
			</th>
		</tr>
		<tr>
			<td></td>
			<td>
				<impact:validateInput checked="<%= String.valueOf( bIncome ) %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" onClick="updateType();" value="INC" type="radio" name="rbSzCdIncRsrcIncome" label="Income"
					cssClass="formInput" />
				<impact:validateInput checked="<%= String.valueOf( bResource ) %>" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" onClick="updateType();" value="RES" type="radio" name="rbSzCdIncRsrcIncome" label="Resource"
					cssClass="formInput" />
			</td>
			<td></td>
			<td>
				<impact:validateInput tabIndex="<%= tabIndex++ %>" checked="<%= FormattingHelper.formatString(rowccfc29sog00.getCIndIncRsrcNotAccess()) %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" type="checkbox" name="cbxCIndIncRsrcNotAccess"
					label="Not Accessible" cssClass="formInput" />
			</td>
		</tr>
		<tr>
			<%/* If the page is in browse mode, display a static field with the database value
       else, display the dynamically populated dropdown If the Inc/Rsrc is income,
       lookup the decode for income, else look up the decode for resource*/
      if (overallPageMode.equals(PageModeConstants.VIEW)) {
        if (bIncome) {
%>
			<td>
				<impact:validateInput type="text" label="Type" value='<%= Lookup.simpleDecode( incomeCodesTableString, szCdIncRsrcType ) %>' name="selSzCdIncRsrcType" cssClass="formInput" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
			</td>
			<%} else {
%>
			<td>
				<impact:validateInput type="text" label="Type" value='<%=  Lookup.simpleDecode( resourceCodesTableString, szCdIncRsrcType )  %>' name="selSzCdIncRsrcType" cssClass="formInput" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
			</td>
			<%}
      } else {
%>
			<td>
				<impact:validateSelect label="Type" name="selSzCdIncRsrcType" style="WIDTH: 160px" required="true" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" codesTable="" value="<%=szCdIncRsrcType%>" />
			</td>
			<%}
%>
			<td>
				<impact:validateInput type="text" label="Source/Employer" constraint="Paragraph" name="txtSzSdsIncRrcsSource" cssClass="formInput" value="<%=FormattingHelper.formatString(rowccfc29sog00.getSzSdsIncRrcsSource())%>"
					editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Amount/Value" constraint="Money11" required="true" name="txtLAmtIncRsrc" cssClass="formInput" value="<%=FormattingHelper.formatMoney(rowccfc29sog00.getLAmtIncRsrc())%>"
					editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>" />
			</td>
			<%/* If the page is in browse mode, display a static field with the database value else, display the populated dropdown */
      if (overallPageMode.equals(PageModeConstants.VIEW)) {
        if (szCdFrequency != null && szCdFrequency.length() != 0) {
%>
			<td>
				<impact:validateInput type="text" label="Frequency" value='<%= Lookup.simpleDecode( frequencyCodesTableString, szCdFrequency ) %>' name="selSzCdFrequency" required="true" cssClass="formInput" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />

			</td>
			<%} else {

          %>
			<td>
				<impact:validateInput type="text" label="Frequency" value='<%= "" %>' name="selSzCdFrequency" cssClass="formInput" size="20" maxLength="20" required="true" tabIndex="<%= tabIndex++ %>" />

			</td>
			<%}
%>
			<%} else {
%>
			<td>
				<impact:validateSelect label="Frequency" 
				                       name="selSzCdFrequency" 
				                       style="WIDTH: 160px" 
				                       tabIndex="<%= tabIndex++ %>" 
				                       editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" 
				                       conditionallyRequired="true"
					                   disabled="false" 
					                   codesTable="" 
					                   value="<%=szCdFrequency%>" />

			</td>
			<%}
%>
		</tr>
		<tr>
			<td>
				<impact:validateDate type="text" name="txtDtDtIncRsrcFrom" label="Start Date" constraint="Date" required="true" value="<%= FormattingHelper.formatDate(rowccfc29sog00.getDtDtIncRsrcFrom()) %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
					size="10" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateDate type="text" name="txtDtDtIncRsrcTo" label="End Date" constraint="Date" value="<%= FormattingHelper.formatDate(rowccfc29sog00.getDtDtIncRsrcTo()) %>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="10"
					tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Verify Method" constraint="Paragraph" name="txtSzSdsIncRsrcVerfMethod" cssClass="formInput" value="<%=FormattingHelper.formatString(rowccfc29sog00.getSzSdsIncRsrcVerfMethod())%>"
					editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
			</td>
			<td>
				<impact:validateTextArea name="txtSzTxtIncRsrcDesc" label="Comments" rows="3" cols="45" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" maxLength="80" constraint="Paragraph80">
					<%=FormattingHelper.formatString(rowccfc29sog00.getSzTxtIncRsrcDesc())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<TD>
				<impact:validateDate type="text" name="txtDtDtModified" label="Date Modified" constraint="Date" required="true" value="<%= FormattingHelper.formatDate(rowccfc29sog00.getDtDtIncRsrcModified()) %>"
					editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="10" tabIndex="<%= tabIndex++ %>" />
			</TD>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspLAmtIncRsrcMonth" label="Current Monthly Income" value="<%=lAmtIncRsrcMonth%>" />
			</td>
		</tr>
	</table>
	<br />
	<%/* BEGIN Admin Address Phone Submodule */%>
	<%AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
      adminAddressPhoneSubDB.setFormName("frmIncRsrcDetail");
      adminAddressPhoneSubDB.setPageMode(overallPageMode);
      adminAddressPhoneSubDB.setAddressPhoneSectionHeader("Address and Phone Information");
      adminAddressPhoneSubDB.setAddressRequired(false);
      adminAddressPhoneSubDB.setAddressDisabled(overallPageMode.equals(PageModeConstants.VIEW));
      adminAddressPhoneSubDB.setCommentsVisible(true);
      adminAddressPhoneSubDB.setCommentsRequired(false);
      adminAddressPhoneSubDB.setCommentsDisabled(overallPageMode.equals(PageModeConstants.VIEW));
      adminAddressPhoneSubDB.setPhoneRequired(false);
      adminAddressPhoneSubDB.setPhoneDisabled(overallPageMode.equals(PageModeConstants.VIEW));
      adminAddressPhoneSubDB.setAddressSubmoduleName("");
      adminAddressPhoneSubDB.setTabIndex(tabIndex);
      AdminAddressPhoneSubDB.setIntoRequest(adminAddressPhoneSubDB, request);

      %>
	<%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp"%>
	<%tabIndex = adminAddressPhoneSubDB.getTabIndex();
      AdminAddressPhoneSubDB.removeFromRequest(request);

      %>
	<%/* END Admin Address Phone Submodule */%>
	<br />
	<hr>
	<table width="100%" border="0" cellspacing="0" cellpadding="3">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag name="btnSave" img="btnSave" form="frmIncRsrcDetail" restrictRepost="true" action="/person/PersonDetail/saveIncRsrc" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	</table>

	<%/*  Always include this hidden field in your form */

      %>
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%/* Close Validate Form Custom Tag */

      %>

<script type="text/javascript" language="JavaScript1.2">
<%
  if ( !( overallPageMode.equals(PageModeConstants.VIEW) ) )
  {
%>
  updateType();
  frmIncRsrcDetail.selSzCdIncRsrcType.value='<%=szCdIncRsrcType%>';
  CleanSelect( frmIncRsrcDetail.selSzCdIncRsrcType );
//End Java Script
<%  } %>
</script>

