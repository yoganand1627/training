
<%
      //*  JSP Name:     Person Search JSP
      //*  Created by:   Jeff Chambers
      //*  Date Created: 12/06/02
      //*
      //*  Description:
      //*  The Person Search Page is used to search for persons in the IMPACT system
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  04/21/03  DWW               SIR #16829 added fire event to make sure that
      //**                              the checkbox hidden fields are correctly updated.
      //**                              This in turn make the checkbox show up as checked
      //**                              in the server code, so that the additional
      //**                              parameters search is done correctlyV9
      //**  04/22/03  Grimshan          SIR #16840 changed Mode of the Page to PageMode.getPageMode
      //**                              since the page mode change based on security (set by the
      //**                              conversation).
      //**  05/08/03  GRIMSHAN          SIR #17351 changed condition around search and relate push
      //**                              buttons to ensure that they would not appear when intake
      //**                              is using the page.  Also changed the way Case Context is
      //**                              determined
      //**  05/13/03  GRIMSHAN          SIR #17450 Added case context condition around add and relate
      //**                              pushbuttons
      //**  07/01/03  GRIMSHAN          SIR 18667 MaxLength and size of city should be 20
      //**  07/22/03  GRIMSHAN          SIR 19040 Format the name to escape out of special characters when
      //**                              submitting to javascript
      //**  08/13/03  GRIMSHAN          SIR 19304 If the county is available, display the decode instead of the
      //**                              code
      //**  08/20/03  GRIMSHAN          SIR 19577 Use lookup.getSimpleDecodeSafe so JSP won't blow up if there
      //**                              is a bad code in the database.
      //**  08/20/03  GRIMSHAN          SIR 19581 Set a variable on click of the hyperlink using the javascript so
      //**                              that if the person selected is a former employee the information will not
      //**                              be displayed on the person detail page.
      //**  11/24/03  CORLEYAN          SIR 22416 If there are not two buttons on the page regardless of
      //**                              search results, allow the user to hit enter and resubmit the search
      //**  09/20/04  CODREAA            SIR 23030 Commented out java script comments so that no extraneous
      //**                              information is added.
      //**  6/10/08	  cjgerry           STGAP00009183 - added javascript validation if the user has selected a person
      //**	                            from the search results, but clicked Add New Person.  Also changed the 
      //**                              button names from Add to Add New Person and Relate to Relate to Case.
      //**  12/31/08  SSUBRAM			STGAP00011764: Added SAU Sealed Attribute checking to the adopted child.
      //**  10/25/09  mxpatel           38626: removed caseContext in order to display person search results from Person 
      //**                              search page 
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonSearchInRec"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonSearchConversation"%>
<%@ page import="org.exolab.castor.types.Date"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
                                                                       BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      PrsnSearchOutRec_ARRAY personArray = null;
      PersonSearchOutRec personSearchOutRec = null;
      String defaultButton = ArchitectureConstants.FALSE;

      // Get the PersonSearchOutRec output object out of the request
      personSearchOutRec = (PersonSearchOutRec) state.getAttribute("CINT09SO", request);

      //  Declare variables
      int tabIndex = 1;
      boolean caseContext = false;
      String searchType = "PHO";
      String firstNm = "";
      String middleNm = "";
      String lastNm = "";
      Date dob = new Date();
      int age = 0;
      String gender = "";
      String street = "";
      String county = "";
      String city = "";
      String addrState = "GA";
      String zip = "";
      String zip2 = "";
      String ssn = "";
      int personId = 0;
      String phone = "";
      int loopCount = 0;
      int intReportID = 0;
      int medaidNO = 0;

      String disableContinuePB = "false";
      boolean showContinueBtn = true;

      if (request.getAttribute(IntakeConstants.SEARCH_INTAKE) != null) {
        // set object in state for reuse
        state.setAttribute("IntakeObject", IntakeConstants.SEARCH_INTAKE, request);
      }

      // If comming from intake or person list use the data being passed in to perform the search
      if (request.getAttribute(IntakeConstants.SEARCH_INTAKE) != null || request.getAttribute("indPersonList") != null) {
        if (request.getAttribute("txtUlIdPerson") != null) {
          personId = Integer.parseInt((String) request.getAttribute("txtUlIdPerson"));
        } else {
          personId = 0;
        }
        firstNm = (String) request.getAttribute("txtSzNmNameFirst");
        middleNm = (String) request.getAttribute("txtSzNmNameMiddle");
        lastNm = (String) request.getAttribute("txtSzNmNameLast");
        dob = (Date) request.getAttribute("dtDtPersonBirth");
        if (request.getAttribute("txtlNbrPersonAge") != null) {
          age = Integer.parseInt((String) request.getAttribute("txtlNbrPersonAge"));
        } else {
          age = 0;
        }
        gender = (String) request.getAttribute("selCcdPersonSex");
        //-- SIR STGAP00000887
        String genderSpecified = (String) state
                                               .getContextParameter(
                                                                    IntakeConstants.GENDER_SPECIFIED_BY_USER + personId,
                                                                    request);
        if (CodesTables.CSEX_U.equals(gender) && ArchitectureConstants.N.equals(genderSpecified)) {
          gender = "";
        }
        //-- end SIR fix
        street = (String) request.getAttribute("txtSzAddrPersAddrStLn1");
        county = (String) request.getAttribute("selSzCdAddrCounty");
        city = (String) request.getAttribute("txtSzCdAddrCity");
        addrState = (String) request.getAttribute("selSzCdAddrState");
        zip = (String) request.getAttribute("txtSzCdAddrZip");
        zip2 = (String) request.getAttribute("txtSzCdAddrZip2");
        ssn = (String) request.getAttribute("txtSzSysTxtGenericSSN");
        phone = (String) request.getAttribute("txtlNbrPhone");

        // GA Shines: 2 new fields here
        if (request.getAttribute("txtIntReportID") != null) {
          intReportID = Integer.parseInt((String) request.getAttribute("txtIntReportID"));
        }
        if (request.getAttribute("txtMedaidNO") != null) {
          medaidNO = Integer.parseInt((String) request.getAttribute("txtMedaidNO"));
        }
      }

      //  If the user came from Task List then they are in then they are in the case context.
      if (request.getAttribute("CaseContext") != null && "Y".equals(request.getAttribute("CaseContext"))) {
        caseContext = true;
      } else {
        caseContext = false;
      }

      /// SIR 22416 If person search out rec is still null, set default button value to true if we have
      // a results set, but are not in case context and have no intake object set the default button
      // to true, otherwise set it to false

      if (personSearchOutRec == null) {
        defaultButton = ArchitectureConstants.TRUE;
      } else if (!caseContext && state.getAttribute("IntakeObject", request) == null) {
        defaultButton = ArchitectureConstants.TRUE;
      } else {
        defaultButton = ArchitectureConstants.FALSE;
      }

      //If coming from Placement Referral Detail page then show only continue button and hide the other buttons.
      //This hdnContinueBtn attribute is coming from Placement Referral Detail Page.
      String hdnContinueBtn = (String) state.getAttribute("hdnContinueBtn", request);
      if (ArchitectureConstants.TRUE.equals(hdnContinueBtn)) {
        showContinueBtn = true;
      } else {
        showContinueBtn = false;
      }
%>


<Script Language="JavaScript">

  function personSearch()
  {
    submitValidateForm( "frmPersonSearch", "/person/PersonSearch/displayPersonSearch" );
  }

  function submitToPersonDetail(personId, name, status, displayInfo, psaActive, age)
  {
    document.frmPersonSearch.hdnUlIdPerson.value = personId;
    document.frmPersonSearch.hdnFullName.value = name;
    document.frmPersonSearch.bIndActiveStatus.value = status;
    document.frmPersonSearch.bSysIndViewPersonInfo.value = displayInfo;
    //-- SIR 1165 ---------
    document.frmPersonSearch.hdnIndPsa.value = psaActive;
    //---------------------
    document.frmPersonSearch.hdnPersonAge.value = age;
    submitValidateForm( "frmPersonSearch", "/person/PersonSearch/displayPersonDetail" );
  }

  function checkAddl()
  {
<%--
    // Only click the additional parameters checkbox if they are not clearing out a value
--%>
    if (frmPersonSearch.txtSzSysTxtGenericSSN.value != "" ||
        frmPersonSearch.txtUlIdPerson.value != "" ||
        frmPersonSearch.txtlNbrPhone.value != "" ||
        frmPersonSearch.txtMedaidNO.value != "" ||
        frmPersonSearch.txtIntReportID.value != "" )
    {
    document.frmPersonSearch.cbxAdditionalParams.checked = true;
<%--
    // DWW SIR #16829
    // added fire event to make sure that the checkbox hidden fields are correctly
    // updated. This in turn make the checkbox show up as checked in
    // the server code, so that the additional parameters search is done correctly
--%>
    document.frmPersonSearch.cbxAdditionalParams.fireEvent("onClick");
    }
  }



</Script>

<impact:validateForm name="frmPersonSearch"
	defaultButton="<%=defaultButton%>" method="post"
	action="/person/PersonSearch/displayPersonSearch"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.PersonSearchCustomValidation"
	pageMode="<%=PageMode.getPageMode(request)%>"
	schema="/WEB-INF/Constraints.xsd" redisplayParameters="true">

	<impact:validateErrors formName="frmPersonSearch" />

	<%-- Hidden Fields --%>
	<impact:validateInput type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<impact:validateInput type="hidden" name="hdnUlIdPerson" value="" />
	<impact:validateInput type="hidden" name="hdnFullName" />
	<impact:validateInput type="hidden" name="hdnUlIdStage" value="" />
	<impact:validateInput type="hidden" name="bIndActiveStatus" value="" />
	<impact:validateInput type="hidden" name="bSysIndViewPersonInfo"
		value="" />
	<impact:validateInput type="hidden" name="hdnSzCdStageProgram"
		value="<%=GlobalData.getSzCdStageProgram(request)%>" />
	<impact:validateInput type="hidden" name="hdnSzCdStage"
		value="<%=GlobalData.getSzCdStage(request)%>" />
	<impact:validateInput type="hidden" name="hdnSzCdTask"
		value="<%=GlobalData.getSzCdTask(request)%>" />
	<impact:validateInput type="hidden" name="hdnIndPsa" value="" />
	<impact:validateInput type="hidden" name="hdnPersonAge" value="" />
	<!--- Begin Detail Table --->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="6">
				Person Information
			</th>
		</tr>
		<tr>
			<td colspan="6">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td width="23%">
							<impact:validateSelect name="cboSearchType"
								label="Person Information Search" required="false"
								codesTable="CPERSRCH" value="<%=searchType%>" colspan="5"
								tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="13%">
				<impact:validateInput name="txtSzNmNameLast" type="text"
					label="Last" constraint="Name22" required="false"
					conditionallyRequired="true" cssClass="formInput"
					value="<%=FormattingHelper.formatString(lastNm)%>" size="30"
					maxLength="22" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtSzNmNameFirst" type="text"
					label="First" constraint="Name12" required="false"
					cssClass="formInput"
					value="<%=FormattingHelper.formatString(firstNm)%>" size="15"
					maxLength="12" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtSzNmNameMiddle" type="text"
					label="Middle" constraint="Name12" required="false"
					cssClass="formInput"
					value="<%=FormattingHelper.formatString(middleNm)%>" size="15"
					maxLength="12" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="txtDtDtPersonBirth" label="Date of Birth"
					constraint="Date" conditionallyRequired="true"
					value="<%=FormattingHelper.formatDate(dob)%>" size="8"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtlNbrPersonAge" type="text"
					label="Age" constraint="Digit3Less" required="false"
					cssClass="formInput"
					value="<%=FormattingHelper.formatInt(age)%>" size="3"
					maxLength="3" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateSelect name="cboCcdPersonSex" label="Gender"
					required="false" codesTable="CSEX"
					value="<%=FormattingHelper.formatString(gender)%>"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<th colspan="6">
				Address
			</th>
		</tr>
		<tr>
			<td colspan="8">
				<impact:validateInput type="checkbox" label=" Address Search"
					checked="" name="cbxAddressSearch" value="Y"
					tabIndex="<%=tabIndex++%>" cssClass="formInput" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtSzAddrPersAddrStLn1" type="text"
					label="Street" constraint="Paragraph30"
					conditionallyRequired="true" cssClass="formInput"
					value="<%=FormattingHelper.formatString(street)%>" size="30"
					maxLength="30" colspan="3" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateSelect name="cboSzCdAddrCounty" label="County"
					required="false" tabIndex="<%=tabIndex++%>" codesTable="CCOUNT"
					value="<%=FormattingHelper.formatString(county)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtSzCdAddrCity" type="text"
					label="City" constraint="Name20" cssClass="formInput"
					value="<%=FormattingHelper.formatString(city)%>" size="20"
					maxLength="20" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateSelect name="cbxSzCdAddrState" label="State"
					required="false" codesTable="CSTATE"
					value="<%=FormattingHelper.formatString(addrState)%>"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtlAddrZip" type="text" label="Zip"
					constraint="Digit5" required="false" cssClass="formInput"
					value="<%=FormattingHelper.formatString(zip)%>" size="5"
					maxLength="5" tabIndex="<%=tabIndex++%>" />
				-
				<impact:validateInput type="text" constraint="Digit4"
					required="false" name="txtlAddrZip2" cssClass="formInput"
					value="<%=FormattingHelper.formatString(zip2)%>" size="4"
					maxLength="4" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<th colspan="6">
				Additional Parameters
			</th>
		</tr>
		<tr>
			<td colspan="6">
				<impact:validateInput type="checkbox"
					label=" Additional Parameters Search" checked=""
					name="cbxAdditionalParams" value="Y" tabIndex="<%=tabIndex++%>"
					cssClass="formInput" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtSzSysTxtGenericSSN" type="text"
					label="SSN" onChange="checkAddl()"
					constraint="SocialSecurityNumber" conditionallyRequired="true"
					cssClass="formInput"
					value="<%=FormattingHelper.formatString(ssn)%>" size="11"
					maxLength="11" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtUlIdPerson" type="text"
					label="Person ID" onChange="checkAddl()" constraint="ID"
					conditionallyRequired="true" cssClass="formInput" size="10"
					maxLength="10" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtlNbrPhone" type="text" label="Phone"
					onChange="checkAddl()" constraint="Phone"
					conditionallyRequired="true" cssClass="formInput"
					value="<%=FormattingHelper.formatString(phone)%>" size="14"
					maxLength="14" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtMedaidNO" type="text"
					label="CRS or Medicaid/MHN Number" onChange="checkAddl()"
					constraint="Numeric" conditionallyRequired="true"
					cssClass="formInput"
					value="<%=FormattingHelper.formatInt(medaidNO)%>" size="12"
					maxLength="12" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateInput name="txtIntReportID" type="text"
					label="Intake Report ID" onChange="checkAddl()" constraint="ID"
					conditionallyRequired="true" cssClass="formInput"
					value="<%=FormattingHelper.formatInt(intReportID)%>" size="10"
					maxLength="10" tabIndex="<%=tabIndex++%>" />
			</td>

		</tr>
	</table>

	<%--Search Button--%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag name="btnSearch" img="btnSearch" align="right"
					form="frmPersonSearch"
					action="/person/PersonSearch/searchPersonSearch" backSafe="true"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>

	<%-- Result Set for Person Search --%>
	<br />

</impact:validateForm>
<%
      //Display the results if the array is not empty, and only display the results if there is no validation error
      if (personSearchOutRec != null && !FormValidation.pageHasValidationMessages("frmPersonSearch", request)) {
%>
<impact:validateForm name="frmSearchResults" method="post"
	action="/person/PersonSearch/searchPersonSearch"
	pageMode="<%=PageModeConstants.EDIT%>"
	schema="/WEB-INF/Constraints.xsd" redisplayParameters="true">

	<impact:validateInput type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<impact:validateInput type="hidden" name="hdnUlIdPerson" value="" />
	<impact:validateInput type="hidden" name="hdnFullName" />
	<impact:validateInput type="hidden" name="hdnUlIdStage" value="" />
	<impact:validateInput type="hidden" name="bIndActiveStatus" value="" />
	<impact:validateInput type="hidden" name="bSysIndViewPersonInfo"
		value="" />
	<impact:validateInput type="hidden" name="hdnSzCdStageProgram"
		value="<%=GlobalData.getSzCdStageProgram(request)%>" />
	<impact:validateInput type="hidden" name="hdnSzCdStage"
		value="<%=GlobalData.getSzCdStage(request)%>" />
	<impact:validateInput type="hidden" name="hdnSzCdTask"
		value="<%=GlobalData.getSzCdTask(request)%>" />

	<impact:pagination saveState="true"
		submitUrl="/person/PersonSearch/searchPersonSearch">
		<%
		        //  Due to the way the the Person Search services work, it's possible
		        //  to return the same Id Person more than once.  Check if Id exists in
		        //  the list box before copying.
		        //  Create a set that will contain IdPersons that are currently in the listbox
		        Set hashSet = new HashSet();

		        // Null catch for ROW objects, if not null get rows
		        if (personSearchOutRec.getPrsnSearchOutRec_ARRAY() != null) {
		          personArray = personSearchOutRec.getPrsnSearchOutRec_ARRAY();
		        } else {
		          personArray = new PrsnSearchOutRec_ARRAY();
		        }
		        Enumeration e = personArray.enumeratePrsnSearchOutRec();
		%>


		<!--- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->
		<div class="alignRight">
			<div class="formInstruct">
				Scroll for more information -->
			</div>
		</div>
		<table width="100%" cellspacing="0" cellpadding="3"
			class="tableborder">
			<tr>
				<td class="tableBG">
					<div id="horizontalScrollResults"
						style="height:300px; width:764px; overflow:auto"
						class="tableborderList">
						<table width="1400" cellspacing="0" cellpadding="3">
							<tr>
								<th class="thList">
									&nbsp;
								</th>
								<th class="thList">
									Match
								</th>
								<th class="thList">
									Match Name
								</th>
								<th class="thList">
									Alert
								</th>
								<th class="thList">
									Score
								</th>
								<th class="thList">
									Mrg
								</th>
								<th class="thList">
									Age
								</th>
								<th class="thList">
									Gender
								</th>
								<th class="thList">
									Race/Ethnicity
								</th>
								<th class="thList">
									Person ID
								</th>
								<th class="thList">
									City
								</th>
								<th class="thList">
									County
								</th>
								<th class="thList">
									Street
								</th>
								<th class="thList">
									SSN
								</th>
								<th class="thList">
									Primary Name
								</th>
							</tr>
							<%
							if (!e.hasMoreElements()) {
							%>
							<tr class="odd">
								<td colspan="15">
									<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
								</td>
							</tr>
							<%
							          } else if (request.getAttribute("PrsnSearchInRec") != null) {
							          Object inRec = request.getAttribute("PrsnSearchInRec");
							          PrsnSearchInRec prsnsearchinrec = null;
							          if (inRec instanceof PrsnSearchInRec) {
							            prsnsearchinrec = (PrsnSearchInRec) inRec;
							          } else if (inRec instanceof PersonSearchInRec) {
							            prsnsearchinrec = ((PersonSearchInRec) inRec).getPrsnSearchInRec();
							          }

							          String matchType = PersonSearchConversation.calculateMatchType(prsnsearchinrec);

							          while (e.hasMoreElements()) {
							            PrsnSearchOutRec personSearchList = (PrsnSearchOutRec) e.nextElement();
							            // hide the record of an adopted child from user that does not have Adoption View or SAU Sealed attribute
							            // STGAP00011764: Added SAU Sealed Attribute checking to the adopted child.
							            if (ArchitectureConstants.Y.equals(personSearchList.getIndAdopted())
							                && !(user.hasRight(UserProfile.SEC_ADO_VIEW) || user.hasRight(UserProfile.SEC_SAU_SEALED))) {
							              continue;
							            }
							            // Only go through the process of displaying a row in the list box if the Person ID is not
							            // already being displayed.
							            //if ( !hashSet.contains( new Integer( personSearchList.getUlIdPerson() ) ) )
							            //{
							            String displayConcatNm = ""; // Current name
							            String displayAKANm = ""; // used-to-be name
							            String displayAlert = "";
							            int displayScore = personSearchList.getUsScrIndScore();
							            String displayMerge = personSearchList.getCWcdIndMerge();
							            int displayAge = personSearchList.getLNbrPersonAge();
							            String displayGender = personSearchList.getCCdPersonSex();
							            String displayEthnicGrp = "";
							            displayEthnicGrp = Lookup
							                                     .simpleDecodeSafe(CodesTables.CETHNIC, personSearchList.getSzCdPersonEthnicGroup());
							            int displayPersonId = personSearchList.getUlIdPerson();
							            hashSet.add(personSearchList.getUlIdPerson());
							            String displayCity = "";
							            String displayCounty = "";
							            String displayStreet = "";
							            String displaySsn = "";

							            //  Call calculateMatchType to determine how the result was matched
							            String displayMatch = "";

							            //  Overide matchType with "AKA" if this is true, also only display primary name if
							            //  this is true.
							            if (ArchitectureConstants.Y.equalsIgnoreCase(personSearchList.getSzScrCdPersonSearchHit())) {
							              displayMatch = "AKA";
							              displayAKANm = personSearchList.getSzNmIncmgPersFull();
							              displayConcatNm = personSearchList.getSzNmPersonFull();
							            } else {
							              displayMatch = matchType;
							              displayAKANm = personSearchList.getSzNmPersonFull();
							            }

							            // only display this information if we are in a case context, or if we are not in case context, and
							            // not an employee
							            // SIR 19581 also display this information only if BSysIndViewPersonInfo is "Y"
							            if(personSearchList.getBSysIndViewPersonInfo() == null) {
							            personSearchList.setBSysIndViewPersonInfo(ArchitectureConstants.Y);
							            }
							            if ((!ArchitectureConstants.Y.equalsIgnoreCase(personSearchList.getBIndActiveStatus()) && ArchitectureConstants.Y
							                                                                                                                                                .equalsIgnoreCase(personSearchList
							                                                                                                                                                                                  .getBSysIndViewPersonInfo()))) {
							              displayCity = personSearchList.getSzAddrCity();
							              // SIR 19304 GRIMSHAN if the county is valid, display the decode.
							              displayCounty = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, personSearchList.getSzCdCounty());
							              displayStreet = personSearchList.getSzAddrPersAddrStLn1();
							              displaySsn = personSearchList.getSzNbrPersonIdSsn();
							            }
							            // set value for alert
							            if (ArchitectureConstants.Y.equals(personSearchList.getIndPsa())) {
							              displayAlert = "!";
							            }
							%>
							<script type="text/javascript" language="JavaScript1.2">
<%--
// Set name string into a javascript variable here, because if it has double quotes, passing it
// directly into the javascript href as a String will terminate the href at the first double quote,
// even if it's escaped.  Passing it as a javascript variable circumvents this problem.
--%>
var personName<%=loopCount%> = '<%=FormattingHelper.formatStringSpecialChars(displayAKANm, "'\"\\")%>';
</script>
							<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>">
								<%
								if (caseContext || state.getAttribute("IntakeObject", request) != null) {
								%>
								<td width="2%">
									<impact:validateInput type="radio" name="rbRowsIndex"
										id='<%="incRadio" + loopCount%>'
										value="<%=String.valueOf(loopCount)%>" tabIndex="0"
										cssClass="formInput" />
								</td>
								<%
								} else {
								%>
								<td></td>
								<%
								}
								%>
								<td>
									<%=FormattingHelper.formatString(displayMatch)%>
								</td>
								<td>
									<a
										href="javascript:disableValidation('frmSearchResults'); submitToPersonDetail( '<%=personSearchList.getUlIdPerson()%>', personName<%=loopCount%>, '<%=personSearchList.getBIndActiveStatus()%>', '<%=personSearchList.getBSysIndViewPersonInfo()%>', '<%=personSearchList.getIndPsa()%>',  '<%=personSearchList.getLNbrPersonAge()%>')">
										<%=displayAKANm%>
									</a>
								</td>
								<td>
									<b><font color="red"> <%=FormattingHelper.formatString(displayAlert)%>
									</font>
									</b>
								</td>
								<td>
									<%=FormattingHelper.formatInt(displayScore)%>
								</td>
								<%
								if (ArchitectureConstants.Y.equalsIgnoreCase(displayMerge)) {
								%>
								<td>
									<img alt="checkmark"
										src="/grnds-docs/images/shared/checkMark.gif">
								</td>
								<%
								} else {
								%>
								<td>
									&nbsp;
								</td>
								<%
								}
								%>
								<td>
									<%=FormattingHelper.formatInt(displayAge)%>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayGender)%>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayEthnicGrp)%>
								</td>
								<td>
									<%=FormattingHelper.formatInt(displayPersonId)%>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayCity)%>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayCounty)%>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayStreet)%>
								</td>
								<td>
									<%=FormattingHelper.formatSSN(displaySsn)%>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayConcatNm)%>
								</td>
							</tr>
							<%
							            loopCount++;
							            //} // End If
							          } // End While
							        }
							%>
						</table>
					</div>
				</td>
			</tr>
		</table>

	</impact:pagination>
	<%-- Relate and Add Buttons --%>
	<% String functionStringRelate = "disableValidation('frmSearchResults'); return isRadioCheckedRelate( "
	                                      + loopCount + ", 'rbRowsIndex' );"; %>
	<% String functionStringAdd = "disableValidation('frmSearchResults'); return isRadioCheckedAdd( " + loopCount
	                                   + ", 'rbRowsIndex' );"; %>
	<%
	        // SIR 17351 GRIMSHAN -- If there is no Intake object display the first set of buttons
	        // SIR 17450 GRIMSHAN -- Only display the buttons if we are also in case context
	        if (state.getAttribute("IntakeObject", request) == null && caseContext) {
	%>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<%
			if (!showContinueBtn) {
			%>
			<td class="alignRight">
				<impact:ButtonTag name="btnRelateToCase" img="btnRelateToCase"
					align="right" form="frmSearchResults"
					function="<%=functionStringRelate%>" disabled=""
					action="/person/PersonSearch/relatePerson"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<td class="alignRight" width="50">
				<impact:ButtonTag name="btnAddNewPerson" img="btnAddNewPerson"
					align="right" form="frmSearchResults"
					function="<%=functionStringAdd%>" disabled=""
					action="/person/PersonSearch/addPerson"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%
			}
			%>

			<%
			if (showContinueBtn) {
			%>
			<td class="alignRight" width="8%">
				<impact:ButtonTag name="btnContinue" img="btnContinue" align="right"
					form="frmSearchResults" action="/person/PersonSearch/callContinue"
					tabIndex="<%=tabIndex++%>" disabled="<%=disableContinuePB%>" />
			</td>

			<%
			}
			%>

		</tr>
	</table>
	<%
	} // close the if on the hide buttons
	%>

	<%
	if (state.getAttribute("IntakeObject", request) != null) {
	%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag name="btnRelateToIntake" img="btnRelateToIntake" align="right"
					form="frmSearchResults" function="<%=functionStringRelate%>"
					disabled="" action="/person/PersonSearch/relatePersonIntake"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<%
	} // close the if on the hide buttons
	%>
</impact:validateForm>
<%
} // close the if to hide the entire results section
%>
<script type="text/javascript" language="JavaScript1.2">
<%
if ( personSearchOutRec != null )
{
%>
<%--
// make sure that a radiobutton from button group is checked before relate.
--%>
function isRadioCheckedRelate(arrayLength, buttonGroupName)
{
  var bRadio = false;
  var listRb = document.getElementsByName(buttonGroupName);
  for ( i = 0; i < arrayLength ; i++ )
  {
    bRadio = listRb[i].checked;
    if ( bRadio )
    {
      break;
    }
  }
  if ( !bRadio )
  {
    alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
  }
  return bRadio;
}
<%--
// make sure that a radiobutton from button group is NOT checked before add.
// STGAP00009183
--%>
function isRadioCheckedAdd(arrayLength, buttonGroupName)
{
  var bRadio = false;
  var listRb = document.getElementsByName(buttonGroupName);
  for ( i = 0; i < arrayLength ; i++ )
  {
    //set boolean to true if checked
    bRadio = listRb[i].checked;
    if ( bRadio )
    {
      //if it is checked, give a warning message
      alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_RELATE_NOT_ADD)%>');
      return false;
    }
  }
  return true;
}

<%
}
%>
</script>
<%
personSearchOutRec = null;
%>
<!--- End Detail Table --->
