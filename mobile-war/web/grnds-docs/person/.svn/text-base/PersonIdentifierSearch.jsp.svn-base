

<%
      //*  JSP Name:     Person Identifier Search JSP
      //*  Created by:   Joel Cochran
      //*  Date Created: 11/01/2010
      //*
      //*  Description:
      //*  The Person Identifier Search Page is used to search for persons by an ID 
      //*  using the SHINES Mobile system
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.lang.String"%>
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

      String ssn = "";
      int personId = 0;
      String phone = "";
      int loopCount = 0;
      int intReportID = 0;
      int medaidNO = 0;
     

      String disableContinuePB = "false";
      boolean showContinueBtn = true;

      // If comming from intake or person list use the data being passed in to perform the search
      if (/*request.getAttribute(IntakeConstants.SEARCH_INTAKE) != null || */ request.getAttribute("indPersonList") != null) {
        if (request.getAttribute("txtUlIdPerson") != null) {
          personId = Integer.parseInt((String) request.getAttribute("txtUlIdPerson"));
        } else {
          personId = 0;
        }

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

  function SubmitCallNarrForm(name, address){
	document.addressmapform.hdnFullName.value = name;
	document.addressmapform.hdnAddress.value = address;
	document.addressmapform.submit();
  }
	//takes the name and address over to the new PersonSearchAddress.jsp page
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
	<impact:validateInput type="hidden" 
		name="hdnMobileIdSearch" value="Y" />
	<div id="pageNav">
	<ul>
		<li class="lvl2Nav tab"><a href="javascript:personSearch();">Person Search</a></li>
		<li class="lvl2NavSelect tab">Identifier Search</li>
	</ul>
	</div>
	<div id="persSrchDtlTbl">
    <table>
		<tr>
			<td>
				<impact:validateInput name="txtSzSysTxtGenericSSN" type="text"
					label="SSN"
					constraint="SocialSecurityNumber" conditionallyRequired="true"
					cssClass="formInput"
					value="<%=FormattingHelper.formatString(ssn)%>" size="14"
					maxLength="11" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtUlIdPerson" type="text"
					label="Person ID" constraint="ID"
					conditionallyRequired="true" cssClass="formInput" size="14"
					maxLength="10" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtlNbrPhone" type="text" label="Phone"
					constraint="Phone"
					conditionallyRequired="true" cssClass="formInput"
					value="<%=FormattingHelper.formatString(phone)%>" size="14"
					maxLength="14" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtMedaidNO" type="text"
					label="CRS or Medicaid/MHN Number"
					constraint="Numeric" conditionallyRequired="true"
					cssClass="formInput"
					value="<%=FormattingHelper.formatInt(medaidNO)%>" size="14"
					maxLength="12" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="txtIntReportID" type="text"
					label="Intake Report ID" constraint="ID"
					conditionallyRequired="true" cssClass="formInput"
					value="<%=FormattingHelper.formatInt(intReportID)%>" size="14"
					maxLength="10" tabIndex="<%=tabIndex++%>" />
			</td>

		</tr>
	</table>
	</div>
	<%--Search Button--%>
	<table border="0" cellspacing="12" cellpadding="3" width="100%">
		<tr>
			<td class="alignLeft">
				<input type="image" class="md" border="0"  tabindex="7"  id="btnSearch_Id" src="/grnds-docs/images/shared/btnSearch.gif" 
				onclick="javascript:defaultButtonOnSubmit();" name="btnSearch" alt="Search" >
				
<script type="text/javascript" language="JavaScript1.2">
  function defaultButtonOnSubmit()
  {
     setIsDirtyCalled(true); setValidationUrl('frmPersonSearch', '/person/PersonSearch/searchPersonIdentSearch'); 
  }
  frmPersonSearch.attachEvent("onsubmit", defaultButtonOnSubmit);
  
   
</script>
		</tr>
	</table>
<a href="javascript:personSearch();">Person Search</a>
	
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
	<impact:validateInput type="hidden" name="hdnAddress" />
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
		
		<!--- This is a way to use to styles.  The first one aligns right and the second formats the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->
<script type="text/javascript">
<!--
function gotoit()
{
window.location="#gohere";
}
//-->
</script>
<body onload="gotoit()">
<a name="gohere"></a>
</body>
		<table id="personSearchResults" cellspacing="0" cellpadding="2">
			<tr>
				<td>
					<table cellspacing="0" cellpadding="2">
							<tr>
								<th class="thList" colspan="30">
									Person Name
								</th>	
							</tr>
							<%
							if (!e.hasMoreElements()) {
							%>
							<tr class="odd">
								<td>
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
							            String displayAge = "";
							            displayAge = FormattingHelper.formatInt(personSearchList.getLNbrPersonAge());
							            String displayYouth = "";
							            String displayGender = FormattingHelper.formatString(Lookup
			                                     		.simpleDecodeSafe(CodesTables.CSEX, personSearchList.getCCdPersonSex()));
							            String displayEthnicGrp = "";
							            displayEthnicGrp = FormattingHelper.formatString(Lookup
							                            .simpleDecodeSafe(CodesTables.CETHNIC, personSearchList.getSzCdPersonEthnicGroup()));
							            String Age = "Age ";
							            String Gender = "Gender";
							            String Ethnicity = "Ethnicity";
							            //int displayYouth = 0;
							            String NA = " N/A";
							            String displaySex = "";
							            String displayRace = "";
							            if(displayAge.length() > 0) {
							            	  displayYouth= displayAge;
							            	  displayYouth = Age + displayYouth; 
							              }	else if (displayAge.length() == 0) {	 
							            	  displayYouth = Age + NA + ", ";
							              }
							              if(displayAge.length() > 0 && displayGender.length() > 0) {
							            	  displayYouth += ", "; // displayYouth = displayAddress + ", "
							              }
							              if(displayGender.length() > 0) {
							            	  displaySex = displayGender;
							              } else if(displayGender.length() == 0) {
							            	  displaySex = ", " + Gender + NA + ", ";
							              }
							              if(displayEthnicGrp.length() >0) {
							            	  displayRace = displayEthnicGrp;
							              }	else if(displayEthnicGrp.length() == 0) {
							            	  displayRace = ", " + Ethnicity + NA;
							              }
							              if(displayGender.length() > 0 && displayEthnicGrp.length() > 0) {
							            	  displaySex += ",";
							              }
							            // additional strings and if else statements created for formatting purposes in sacwis mobile
							            int displayPersonId = personSearchList.getUlIdPerson();
							            hashSet.add(personSearchList.getUlIdPerson());
							            String displayCity = "";
							            String displayCounty = "";
							            String displayStreet = "";
							            String displaySsn = "";
							            String displayAddress = "";
							            String displayTown = "";
							            String displayRegion = "";
							            //  Call calculateMatchType to determine how the result was matched
							            String displayMatch = "";
							            //  Overide matchType with "AKA" if this is true, also only display primary name if
							            //  this is true.
							            if (ArchitectureConstants.Y.equalsIgnoreCase(personSearchList.getSzScrCdPersonSearchHit())) {
							              displayMatch = "AKA";
							              displayAKANm = personSearchList.getSzNmIncmgPersFull();
							              displayConcatNm = personSearchList.getSzNmPersonFull();
							            } else {
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
							              displayCity = FormattingHelper.formatString(personSearchList.getSzAddrCity());
							              // SIR 19304 GRIMSHAN if the county is valid, display the decode.
							              displayCounty = FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, personSearchList.getSzCdCounty()));
							              displayStreet = FormattingHelper.formatString(personSearchList.getSzAddrPersAddrStLn1());
							              displaySsn = personSearchList.getSzNbrPersonIdSsn();
							              String Street = "Street ";
								          String City = "City";
								          String County = "County";
							              if(displayStreet.length() > 0) {
							            	  displayAddress = displayStreet;
							              } else if(displayStreet.length() == 0) {
							            	  displayAddress = Street + NA;
							              }
							              if(displayStreet.length() > 0 && displayCity.length() > 0) {
							            	  displayAddress += ", "; // displayAddress = displayAddress + ", "
							              }
							              if(displayCity.length() > 0) {
							            	  displayTown = displayCity;
							              } else if(displayCity.length() == 0 ) {
							            	  displayTown = ", " + City + NA ;
							              }
							              if(displayCity.length() == 0)
							            	  displayRegion = ", " + City + NA + ", ";
							              if(displayCounty.length() >0) {
							            	  displayRegion = "," + displayCounty;
							              } else if(displayCounty.length() == 0) {
							            	  displayRegion =  ", " + County + NA;
							              }
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
								<td>
									<%=displayAKANm%>
								</td>
								
								<td colspan="20"> 
									<%=displayYouth%><%=displaySex%> <%=displayRace%>
								</td>
							<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>">
								<td colspan="7">  
			<a href="javascript:SubmitCallNarrForm(personName<%=loopCount%>,'<%=displayAddress%><%=displayTown%>');"><%=displayAddress%><%=displayTown%> <%=displayRegion%></a>
								</td>
								<td>
									<%=FormattingHelper.formatString(displayConcatNm)%>
								</td>
								<td>
								</td>
								<td>
								</td>
								<td>
								</td>
								</tr>
							</tr>
							<%
							            loopCount++;
							            //} // End If
							          } // End While
							        }
							%>
						</table>
				</td>
			</tr>
		</table>
</script>
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
<form name='addressmapform' action="/person/PersonSearch/displayPersonSearchAddress" method="post" style="display:none" id="addressmapform" name="addressmapform"><input type="hidden" name="hdnFullName"><input type="hidden" name="hdnAddress"></form>

<!--- End Detail Table --->