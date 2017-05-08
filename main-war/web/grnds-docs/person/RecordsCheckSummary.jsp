<%
   /**
       * Records Check Summary (Summary View, Add-By-Person View, Add-By-Type View)
       * Author: Corey Harden
       * Date: 06/03/2011
       * 
       * 					Change History
       *
       *   Date          User				              Description
       * --------  ----------------  --------------------------------------------------
       * 06/29/11  cwells			  113723 Added logic to display 10 checks for children with no DOB
       * 07/07/11  hnguyen           SMS#113889: Fixed issue with selected History checkbox not persisting after validation error.
       * 07/07/11  hnguyen           SMS#114348: Removed Requested By maxlength constraint to fix name truncation.
       *
       *
       *
   */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Croleall"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crelvict"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>

<%
  // get the state map
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  // retrieve the Service Out (SO) object from the request
  RecordsCheckSummarySO recordsCheckSummarySO = (RecordsCheckSummarySO) request.getAttribute("recordsCheckSummarySO");

  // get list of person data for each principle on the stage
  @SuppressWarnings("unchecked")
  List<RecordsCheckPersonBean> personList = recordsCheckSummarySO.getPersonList();

  // get list of Records Check types required for each age group
  Map<String, List<String>> ageTypeMap = recordsCheckSummarySO.getAgeTypeMap();

  // this map is of type Map<Integer, Map<String, RecordsCheckBean>>
  @SuppressWarnings("unchecked")
  Map<Integer, Map> filteredListsMap = recordsCheckSummarySO.getFilteredListsMap();

  // list of person id's
  List<Integer> personIdList = recordsCheckSummarySO.getPersonIdList();

  // get the user profile for display rule logic
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // get map containing list of missing types and a map of persons missing those types
  @SuppressWarnings("unchecked")
  Map missingMap = recordsCheckSummarySO.getMissingTypesMap();
  
  // get map used to determine if a person has history
  Map<Integer, Map<String, Boolean>> historyMap = recordsCheckSummarySO.getHistoryMap();

  // get list of missing types
  @SuppressWarnings("unchecked")
  List<String> missingTypesList = (List<String>) missingMap.get(recordsCheckSummarySO.getMissingTypesList());

  // get map of missing types to persons
  @SuppressWarnings("unchecked")
  Map<String, Map<Integer, RecordsCheckBean>> missingTypesMap = (Map<String, Map<Integer, RecordsCheckBean>>) missingMap.get(recordsCheckSummarySO.getMissingTypesToPerson());
  
  // get the add-by type from the request
  String addType = (String) request.getAttribute("addType");

  // get map of Records Check website url's
  Map<String, String> rcSiteMap = recordsCheckSummarySO.getRcSiteMap();

  // create date for auto population of date of request fields
  String today = DateHelper.toString(new Date(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING));

  // get the primary key of the stage
  int ulIdStage = GlobalData.getUlIdStage(request);

  // use stage id to determine whether the current user has access to the stage
  boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), ulIdStage);

  // create page mode variable based on stage access
  String pageMode = hasStageAccess ? PageModeConstants.MODIFY : PageModeConstants.INQUIRE;

  // get the current person
  RecordsCheckPersonBean addPerson = new RecordsCheckPersonBean();

  // loop thru list to match person
  for (RecordsCheckPersonBean tempPerson : personList) {
    // match the person id's
    if ((GlobalData.getUlIdPerson(request)) == (tempPerson.getPersonId())) {
      // set the current person and break outta loop
      addPerson = tempPerson;
      break;
    }
  }
%>



<!-- JAVASCRIPT SECTION -->
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

	/**
	* This function pre-populates the Request date of the passed-in element when triggered
	* @param elem - the element whose value to update with the current date
	*/
	function prePopulateRequestDate(id){
		var val = document.getElementById(id).value;
		if('' == val){
			document.getElementById(id).value = document.getElementById('hdnDate').value;
		}
	}
	
	/**
	* This function sets the number of rows into a hidden variable for later retrieval
	* @param count - the number of rows
	*/
	function setTrackCount(count){
		document.getElementById('hdnRowCount').value = count;
	}
	
	/**
	* This function is responsible for writing out an informational message to the user
	* when there are no missing records checks to display.
	* @param count - the number of rows displayed on the page
	*/
	function isInformationalNeeded(count){
		if(count == 1){
			var message = '<%=MessageLookup.getMessageByNumber(Messages.MSG_REC_ALL_COMPLETED)%>';
			var inform = '<table width="100%" style="background-color: #FFFF7E; height: 60px"><tr><td align="center"><b><font color="blue" size="2">' + message + '</font></b></td></tr></table>';
			document.getElementById('informational').innerHTML = inform;
			document.getElementById('btnSave_Id').style.visibility = 'hidden';
			document.getElementById('headerRow').style.visibility = 'hidden';
		}
	}
	
	/**
	* This function sets data into hidden fields and submits the form to display
	* the Reoords Check detail page
	* @param index - the index of the Record Check
	* @param type - the type of the Records Check
	* @param dtReq - the date of Request of the Records Check
	* @param dtComp - the date of Completion of the Records Check
	* @param id - the primary key of the Records Check
	* @param personId - the primary key of the person
	* @param name - the full name of the person
	*/
   function passFieldsToRcrdChckDtl( index, type, dtReq, dtComp, id, personId, name) {
  		document.getElementById('hdnIndex').value = index;
  		document.getElementById('hdnType').value = type;
  		document.getElementById('hdnDtReq').value = dtReq;
  		document.getElementById('hdnDtComp').value = dtComp;
  		document.getElementById('hdnUlIdRecCheck').value = id;
  		document.getElementById('hdnIdPerson').value = personId;
		document.getElementById('hdnNmPerson').value = name;
  		submitValidateForm('frmRecordsCheckSummaryList', '/person/RecordsCheckSummary/displayRecordsCheckDetail');
	}
	
	/**
	* This function adds data to hidden variables and submits the summary list form
	* @param personId - the id of the person
	* @param name - the name of the person
	*/
	function displayRecordsCheckList(personId, name){
		document.getElementById('hdnIdPerson').value = personId;
		document.getElementById('hdnNmPerson').value = name;
		submitValidateForm('frmRecordsCheckSummaryList', '/person/RecordsCheckSummary/displayRecordsCheckList');
	}
	
	function disableDropdown(radioBtn){
		var elem = document.getElementById('selPersonByIdRecCheckPerson_id');
		if('addBySearchType' == radioBtn){
			elem.disabled = true;
		}else{
			elem.disabled = false;
		}
	}
		
	
</script>
<!-- END JAVASCRIPT SECTION -->



<!-- ERROR DISPLAY AREA -->
<impact:validateErrors />
<!-- END ERROR DISPLAY AREA -->


<!-- INFORMATIONAL MESSAGE AREA -->
<div id="informational"></div>
<!-- END INFORMATIONAL MESSAGE AREA -->




<!-- ------------------------------------------------------BEGIN RECORDS CHECK SUMMARY VIEW---------------------------------------------- -->
<%
  if (addType == null) {
%>
<!-- ADD RECORDS CHECK BY TYPE AREA -->
<impact:validateForm name="frmRecordsCheckSummaryAdd" method="post" action="/person/RecordsCheckSummary/addRequiredRecordsCheck" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation" pageMode="pageMode" schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <impact:validateInput type="hidden" id="hdnIdStage" name="hdnIdStage" value="<%= GlobalData.getUlIdStageAsString(request) %>" />
  <impact:validateInput type="hidden" id="hdnIdCase" name="hdnIdCase" value="<%= GlobalData.getUlIdCaseAsString(request) %>" />

<%
  if (PageModeConstants.MODIFY.equals(pageMode) && !personList.isEmpty()) {
%>
	<div style="border: solid black 1px; width: 100%">
		<table border="0" cellspacing="0" cellpadding="3" width="100%">
			<tr>
				<th class="thList">
					Add Records Check
				</th>
			</tr>
			<tr class="odd" valign="top">
				<td>
					<table cellspacing="10" cellpadding="3">
						<tr style="border-bottom: solid black 1px;">
							<!-- this is the radio button section to select the add type -->
							<td>
								<input id="addByPerson" type="radio" tabIndex="1" value="addByPerson" onclick="disableDropdown('addByPerson')" name="add_type">
								Add By Person
							</td>
							<td>
								<input id="addBySearchType" checked type="radio" tabIndex="1" value="addBySearchType" onclick="disableDropdown('addBySearchType')" name="add_type">
								Add By Search Type
							</td>
							<td></td>
						</tr>
						<tr style="border-top: solid black 1px">
							<td>
								<!-- create dropdown list of persons to Add by -->
								<select title="Program Area" tabindex="12" disabled id="selPersonByIdRecCheckPerson_id" name="selPersonByIdRecCheckPerson">
									<option value=""></option>
									<!-- create a java loop here to loop thru the list of persons and add each person to the dropdown  -->
									<%
									  for (RecordsCheckPersonBean person : personList) {
									%>
									<option value="<%=person.getPersonId()%>">
										<%=person.getDisplayNameFull()%>
									</option>
									<%
									  }
									%>
								</select>
							</td>
							<td></td>
							<!-- create add button -->
							<td>
								<input border="0" type="image" onclick="" alt="Add" name="btnAdd" src="/grnds-docs/images/shared/btnAdd.gif" id="btnAdd_Id" tabindex="8" class="md">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<p>&nbsp</p>
<%
  }
%>
</impact:validateForm>
<!-- END ADD RECORDS CHECK BY TYPE AREA -->





<!-- RECORDS CHECK LIST AREA -->
<impact:validateForm name="frmRecordsCheckSummaryList" method="post" action="/person/RecordsCheckSummary/displayRecordsCheckList" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation" pageMode="" schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <impact:validateInput type="hidden" id="hdnIdPerson" name="hdnIdPerson" value="" />
  <impact:validateInput type="hidden" id="hdnNmPerson" name="hdnNmPerson" value="" />
  <impact:validateInput type="hidden" id="hdnIndex" name="hdnIndex" value="" />
  <impact:validateInput type="hidden" id="hdnType" name="hdnType" value="" />
  <impact:validateInput type="hidden" id="hdnDtReq" name="hdnDtReq" value="" />
  <impact:validateInput type="hidden" id="hdnDtComp" name="hdnDtComp" value="" />
  <impact:validateInput type="hidden" id="hdnUlIdRecCheck" name="hdnUlIdRecCheck" value="" />
<%
  for (RecordsCheckPersonBean person : personList) {
%>
    <div style="width: 100%;">
    	<table style="width: 100%; position: relative; top: 20px">
    		<tr style=" background-color: white; height: 30px">
    			<td>
    				<span>
    					<b>Name: <%=person.getDisplayNameFull()%> | Person ID: <%=person.getPersonId()%> | <%=person.getCdStagePersonType()%> | <%=Lookup.simpleDecodeSafe(Crelvict.CRELVICT, person.getCdStagePersRelInt())%> | <%=person.getAge()%> | <%=Lookup.simpleDecode(Croleall.CROLEALL, person.getCdStagePersonRole())%></b>
    				</span>	
    			</td>
    			<td width="70px"></td>
    			<td>
    				<a href="javascript: displayRecordsCheckList('<%= person.getPersonId() %>', '<%= person.getDisplayNameFull() %>')">view all</a>
    			</td>
    		</tr>
    	</table>
    	<table border="0" cellspacing="0" cellpadding="3" style="width: 100%; height: 40px; position: relative; top: 20px">
    		<tr>
    			<th class="thList">
					Search Type
				</th>
				<th class="thList">
					Date of Request
				</th>
				<th class="thList">
					Date Completed
				</th>
				<th class="thList">
					Requested By
				</th>
				<th class="thList">
					History
				</th>
    		</tr>
    	<%
    	  //determine required Records Check types by person age
    	  // SMS 113723 If the Person does not have an age then we are checking for 10 records 
    	  
    	      List<String> tempTypeListByAge = person.getAge() < 17 && person.getDateOfBirth() != null ? ageTypeMap.get(recordsCheckSummarySO.getLtSeventeen()) : ageTypeMap.get(recordsCheckSummarySO.getGtSeventeen());

    	      //get map of Records Checks for person
    	      @SuppressWarnings("unchecked")
    	      Map<String, RecordsCheckBean> recordsCheckMap = filteredListsMap.get(person.getPersonId());

    	      //create counter to alternate row coloring
    	      int rowCount = 1;

    	      //check for existence of Records Check types for each person
    	      if (recordsCheckMap.isEmpty()) {
    	        //loop thru list to write out missing Records Checks
    	        for (String str : tempTypeListByAge) {
    	%>
    	<!-- DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->
    		<tr class=<%=rowCount % 2 == 0 ? "even" : "odd"%> style="position: relative; top: 20px">
    			<td style="color: red"><%=Lookup.simpleDecode(Cchktype.CCHKTYPE, str)%></td>
    			<td></td>
    			<td></td>
    			<td></td>
    			<td></td>
    		</tr>
    	<!-- END DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->
    	<%
    	  rowCount++;
    	        }
    	        rowCount = 1;
    	      } else {
    	        //loop thru list to pull out each Records Check required type to write out missing checks
    	        for (String str : tempTypeListByAge) {
    	          //check for existence of Records Check
    	          if (!recordsCheckMap.containsKey(str)) {
    	%>
    	<!-- DISPLAY MISSING RECORDS CHECKS IN ROWS -->
    		<tr class=<%=rowCount % 2 == 0 ? "even" : "odd"%> style="position: relative; top: 20px">
    			<td style="color: red"><%=Lookup.simpleDecode(Cchktype.CCHKTYPE, str)%></td>
    			<td></td>
    			<td></td>
    			<td></td>
    			<td></td>
    		</tr>
		<%
					rowCount++;
				}else if(recordsCheckMap.get(str).getDtRecCheckCompleted() == null){
					//retrieve Records Check record from map
    	            RecordsCheckBean rcBean = recordsCheckMap.get(str);
		%>
    		<tr class=<%=rowCount % 2 == 0 ? "even" : "odd"%> style="position: relative; top: 20px">
    			<td style="color: red"><%=Lookup.simpleDecode(Cchktype.CCHKTYPE, str)%></td>
    			<td><%=DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING))%></td>
    			<td><%=DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING))%></td>
    			<td><%=rcBean.getPersonByIdRecCheckRequestor()%></td>
    	<%
    	  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())) {
    	%>
    			<td align="center"><img src="/grnds-docs/images/shared/checkMark.gif" /></td>
    	<%
    	  } else {
    	%>
    	 		<td></td>
    	<%
    	  }
    	%>
    		</tr>
    	<!-- END DISPLAY MISSING RECORDS CHECKS IN ROWS -->
    	<%
    	  rowCount++;
    	          }
    	        }
    	        //loop thru list again to pull out each Records Check required type to write out completed checks
    	        for (String str : tempTypeListByAge) {
    	          //check for existence of Records Check
    	          if (recordsCheckMap.containsKey(str) && recordsCheckMap.get(str).getDtRecCheckCompleted() != null) {
    	            //retrieve Records Check record from map
    	            RecordsCheckBean rcBean = recordsCheckMap.get(str);
    	%>
    	<!-- POPULATE COMPLETED RECORDS CHECK ROWS -->
    		<tr class=<%=rowCount % 2 == 0 ? "even" : "odd"%> style="position: relative; top: 20px">
    			<td><a href="javascript: passFieldsToRcrdChckDtl( '<%= rowCount %>', '<%= str %>', '<%=DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING))%>', '<%=DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING))%>', '<%= rcBean.getIdRecCheck() %>', '<%= person.getPersonId() %>', '<%= person.getDisplayNameFull() %>' )"><%=Lookup.simpleDecode(Cchktype.CCHKTYPE, str)%></a></td>
    			<td><%=DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING))%></td>
    			<td><%=DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING))%></td>
    			<td><%=rcBean.getPersonByIdRecCheckRequestor()%></td>
    	<%
    	  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())) {
    	%>
    			<td align="center"><img src="/grnds-docs/images/shared/checkMark.gif" /></td>
    	<%
    	  } else {
    	%>
    	 		<td></td>
    	<%
    	  }
    	%>
    		</tr>
    	<!-- END POPULATE COMPLETED RECORDS CHECK ROWS -->
    	<%
    	  rowCount++;
    	          }
    	        }
    	      }
    	%>
    	</table>
    </div>
    <p>&nbsp</p><p>&nbsp</p><p>&nbsp</p>
<%
  }
%>
</impact:validateForm>
<!-- END RECORDS CHECK LIST AREA -->
<%
  }

  // -- ------------------------------------------------------END RECORDS CHECK SUMMARY VIEW------------------------------------------------







  // ------------------------------------------------------BEGIN RECORDS CHECK SUMMARY ADD BY TYPE VIEW-------------------------------------

  else if ("addBySearchType".equals(addType)) {
%>
<div style="border-top: solid 2px gray; width: 100%;"></div>
<impact:validateForm name="frmRecordsCheckSummaryAddByType" method="post" action="/person/RecordsCheckSummary/saveRecordsCheckSummary" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
	<impact:validateInput id="hdnDate" type="hidden" name="hdnDate" value="<%= today %>" />
	<impact:validateInput id="hdnRowCount" type="hidden" name="hdnRowCount" value="" />
	<impact:validateInput id="hdnType" type="hidden" name="hdnType" value="<%= addType %>" />
<%
  //create counters to alternate row coloring and track records
      int rowCount = 0;
      int trackCount = 1;

      // loop thru the missing types to build a table for each
      for (String type : missingTypesList) {
        //reset counter
        rowCount = 1;

        // get map of persons to Records Check records
        Map<Integer, RecordsCheckBean> recordsMap = missingTypesMap.get(type);
%>
    <div style="width: 100%;">
    	<table style="width: 80%; position: relative; top: 20px">
    		<tr style=" background-color: white; height: 30px">
    			<td>
    				<span>
    					<b>Name: <%=Lookup.simpleDecode(Cchktype.CCHKTYPE, type)%>
<%
  // if there is a url for this type, write out a link to the type's website
  if (rcSiteMap.containsKey(type)) {
%>
							| <a href="<%=rcSiteMap.get(type)%>" target="_blank">link to website</a>
<%
  }
%>    			
						</b>
    				</span>	
    			</td>
    		</tr>
    	</table>
    	<table border="0" cellspacing="0" cellpadding="3" style="width: 100%; position: relative; top: 20px">
    		<tr id="headerRow" style="background-color: #E2E1C3;">
    			<th class="thList">
					Person
				</th>
				<th class="thList">
					Date of Request
				</th>
				<th class="thList">
					Date Completed
				</th>
				<th class="thList">
					Requested By
				</th>
				<th class="thList">
					History
				</th>
    		</tr>
    	<%
    	  //loop thru list of persons to determine if they are missing the current type
    	        for (RecordsCheckPersonBean person : personList) {
    	          //get Records Check bean
    	          RecordsCheckBean rcBean = recordsMap.get(person.getPersonId());

				  // all saved Records Checks must have a date of request, so check date 
				  // of request to determine if this is a new or old Records Check
    	          if (rcBean != null && rcBean.getDtRecCheckRequest() == null) {
    	%>
			<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td><impact:validateInput id="hdnMetaData" type="hidden" name="<%= "hdnMetaData" + trackCount %>" value="<%= type + "=" + trackCount + "&person=" + person.getPersonId() + "&requestor=" + user.getUserID() + "&idRecCheck=0" + "&personName=" + person.getDisplayNameFull() %>" /><%=person.getDisplayNameFull()%></td>
				<td><impact:validateInput type="text"  id="<%="dtRecCheckRequest" + trackCount%>" onFocus="prePopulateRequestDate(this.id)" name="<%= "dtRecCheckRequest" + trackCount %>" value=""  maxLength="10" size="10"  /></td>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckCompleted" + trackCount %>" value="" maxLength="10" size="10" /></td>
				<td><impact:validateInput id="<%= "" + user.getUserID() %>" type="text" name="<%= "requestByFullName" + trackCount %>" value="<%= user.getUserFullName() %>" disabled="true" /></td>
		        <td align="left"><impact:validateInput type="checkbox" checked="false" name="<%= "indReccheckHistory" + trackCount %>" value="Y" /></td>
			</tr>
			<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td colspan="4">Comments: <impact:validateTextArea maxLength="500" cols="60" rows="2" name="<%= "txtRecCheckComments" + trackCount %>"></impact:validateTextArea></td>
				<td>&nbsp;</td>
			</tr>
		<%
		  //increment counters
		            rowCount++;
		            trackCount++;
		          } else if (rcBean != null && rcBean.getDtRecCheckRequest() != null) {
		%>
			<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td><impact:validateInput id="hdnMetaData" type="hidden" name="<%= "hdnMetaData" + trackCount %>" value="<%= type + "=" + trackCount + "&person=" + person.getPersonId() + "&requestor=" + rcBean.getPersonByIdRecCheckRequestor() + "&idRecCheck=" + rcBean.getIdRecCheck() + "&personName=" + person.getDisplayNameFull() %>" /><%=person.getDisplayNameFull()%></td>
				<td><impact:validateInput type="text" id="<%="dtRecCheckRequest" + trackCount%>" onFocus="prePopulateRequestDate(this.id)" name="<%= "dtRecCheckRequest" + trackCount %>" value="<%= rcBean.getDtRecCheckRequest() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) %>" maxLength="10" size="10" disabled="true" /></td>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckCompleted" + trackCount %>" value="<%= rcBean.getDtRecCheckCompleted() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) %>" maxLength="10" size="10" /></td>
				<td><impact:validateInput type="text" name="<%= "requestByFullName" + trackCount %>" value="<%= rcBean.getRequestByFullName() %>" disabled="true" /></td>
		<%
		  // check to see if the person has any history in the Shines/DFCS  system
		  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())) {
		%>
				<td align="left"><impact:validateInput type="checkbox" checked="true" name="<%= "indReccheckHistory" + trackCount %>" value="Y" /></td>
		<%
		  } else {
		%>
				<td align="left"><impact:validateInput type="checkbox" checked="false" name="<%= "indReccheckHistory" + trackCount %>" value="Y" /></td>
		<%
		  }
		%>
			</tr>
			<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td colspan="4">Comments: <impact:validateTextArea maxLength="500" cols="60" rows="2" name="<%= "txtRecCheckComments" + trackCount %>"> <%=rcBean.getTxtRecCheckComments() == null ? "" : rcBean.getTxtRecCheckComments()%> </impact:validateTextArea></td>
				<td>&nbsp;</td>
			</tr>
		<%
		            //increment counters
		            rowCount++;
		            trackCount++;
		          }
		        }
		%>		
			<tr class="odd">
				<td align="right" colspan="6">
					<input border="0" type="image" onclick="" alt="Save" name="btnSave" src="/grnds-docs/images/shared/btnSave.gif" id="btnSave_Id" tabindex="8" class="md">
				</td>
			</tr>			
    	</table>
    </div>
    <p>&nbsp</p>
<%
  }
%>

<script>
setTrackCount('<%=String.valueOf(trackCount)%>');
isInformationalNeeded(<%=trackCount%>);
</script>
</impact:validateForm>
<!-- END MISSING RECORDS CHECK LIST AREA -->

<%
  }

  //-- ---------------------------------------------------END RECORDS CHECK SUMMARY ADD BY TYPE VIEW---------------------------------------- 







  //-- ---------------------------------------------------BEGIN RECORDS CHECK SUMMARY ADD BY PERSON VIEW------------------------------------
  else if ("addByPerson".equals(addType)) {
%>


<!-- ADD RECORDS CHECK BY TYPE AREA -->
<impact:validateForm name="frmRecordsCheckSummaryAddByPerson" method="post" action="/person/RecordsCheckSummary/saveRecordsCheckSummary" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckSummaryCustomValidation" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <impact:validateInput type="hidden" name="hdnIndex" value="" />
  <impact:validateInput type="hidden" name="hdnIdCase" value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>" />
  <impact:validateInput type="hidden" name="hdnIdStage" value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>" />
  <impact:validateInput id="hdnDate" type="hidden" name="hdnDate" value="<%= today %>" />
  <impact:validateInput id="hdnRowCount" type="hidden" name="hdnRowCount" value="" />
  <impact:validateInput type="hidden" id="hdnType" name="hdnType" value="<%= addType %>" />


<%
  int trackCount = 1;
%>
    <div style="width: 100%; height: 100%">
    	<table border="0" cellspacing="0" cellpadding="3" style="width: 100%; height: 40px; ">
    		<tr id="headerRow" style="background-color: #E2E1C3;">
    			<th class="thList">
					Search Type
				</th>
				<th class="thList">
					Date of Request
				</th>
				<th class="thList">
					Date Completed
				</th>
				<th class="thList">
					Requested By
				</th>
				<th class="thList">
					History
				</th>
    		</tr>
    	<%
    	  //determine required Records Check types by person age
    	  // SMS 113723 If the Person does not have an age then we are checking for 10 records 
    	      List<String> tempTypeListByAge = addPerson.getAge() < 17 && addPerson.getDateOfBirth() != null ? ageTypeMap.get(recordsCheckSummarySO.getLtSeventeen()) : ageTypeMap.get(recordsCheckSummarySO.getGtSeventeen());

    	      //get map of Records Checks for person
    	      @SuppressWarnings("unchecked")
    	      Map<String, RecordsCheckBean> recordsCheckMap = filteredListsMap.get(addPerson.getPersonId());

    	      //create counter to alternate row coloring
    	      int rowCount = 1;

    	      //check for existence of Records Check types for each person
    	      if (recordsCheckMap.isEmpty()) {
    	        //loop thru list to write out missing Records Checks
    	        for (String str : tempTypeListByAge) {
    	%>
    	<!-- DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->
    		<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td><impact:validateInput id="hdnMetaData" type="hidden" name="<%= "hdnMetaData" + trackCount %>" value="<%= str + "=" + trackCount + "&person=" + addPerson.getPersonId() + "&requestor=" + user.getUserID() + "&idRecCheck=0" + "&personName=" + addPerson.getDisplayNameFull() %>" /> <%=Lookup.simpleDecode(Cchktype.CCHKTYPE, str)%>
				<%
				  if (rcSiteMap.containsKey(str)) {
				%>
							| <a href="<%=rcSiteMap.get(str)%>" target="_blank">link to website</a>
		<%
		  }
		%>    
				</td>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckRequest" + trackCount %>" value="" maxLength="10" size="10" onFocus="prePopulateRequestDate(this.id)" /></td>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckCompleted" + trackCount %>" value="" maxLength="10" size="10" /></td>
				<td><impact:validateInput id="<%= "" + user.getUserID() %>" type="text" name="<%= "requestByFullName" + trackCount %>" value="<%= user.getUserFullName() %>" disabled="true" /></td>
				<td align="center"><input type="checkbox" name="<%="indReccheckHistory" + trackCount%>" value="Y" /></td>
			</tr>
			<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td colspan="4">Comments: <impact:validateTextArea cols="60" rows="2" maxLength="500" name="<%= "txtRecCheckComments" + trackCount %>" ></impact:validateTextArea></td>
				<td>&nbsp;</td>
			</tr>
    	<!-- END DISPLAY ALL REQUIRED RECORDS CHECKS AS MISSING -->
    	<%
    	  rowCount++;
    	          trackCount++;
    	        }
    	        rowCount = 1;
    	      } else {
    	        //loop thru list to pull out each Records Check required type to write out incomplete checks
    	        for (String str : tempTypeListByAge) {
    	          //check for existence of Records Check
    	          if (!recordsCheckMap.containsKey(str) || recordsCheckMap.get(str).getDtRecCheckCompleted() == null) {
    	            // get Records Check bean
    	            RecordsCheckBean rcBean = recordsCheckMap.get(str) != null ? recordsCheckMap.get(str)
    	                                                                      : new RecordsCheckBean();
    	%>
    	<!-- DISPLAY MISSING RECORDS CHECKS IN ROWS -->
    		<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td><impact:validateInput id="hdnMetaData" type="hidden" name="<%= "hdnMetaData" + trackCount %>" value="<%= str + "=" + trackCount + "&person=" + addPerson.getPersonId() + "&requestor=" + (rcBean.getPersonByIdRecCheckRequestor() == 0 ? user.getUserID() : rcBean.getPersonByIdRecCheckRequestor()) + "&idRecCheck=" + (rcBean.getIdRecCheck() == null ? "0" : rcBean.getIdRecCheck()) + "&personName=" + addPerson.getDisplayNameFull() %>" /> <%=Lookup.simpleDecode(Cchktype.CCHKTYPE, str)%>
		<%
			if (rcSiteMap.containsKey(str)) {
		%>
				| <a href="<%=rcSiteMap.get(str)%>" target="_blank">link to website</a>
		<%
		  }
		%>    
				</td>
		<%
		  if (rcBean.getDtRecCheckRequest() == null) {
		%>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckRequest" + trackCount %>" value="<%= rcBean.getDtRecCheckRequest() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) %>" maxLength="10" size="10" onFocus="prePopulateRequestDate(this.id)" /></td>
		<%
		  } else {
		%>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckRequest" + trackCount %>"  disabled="true" value="<%= rcBean.getDtRecCheckRequest() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckRequest(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) %>" maxLength="10" size="10" onFocus="prePopulateRequestDate(this.id)" /></td>
		<%
		  }
		%>
				<td><impact:validateInput type="text" name="<%= "dtRecCheckCompleted" + trackCount %>" value="<%= rcBean.getDtRecCheckCompleted() == null ? "" : DateHelper.toString(rcBean.getDtRecCheckCompleted(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) %>" maxLength="10" size="10" /></td>
				<td><impact:validateInput type="text" name="<%= "requestByFullName" + trackCount %>" value="<%= rcBean.getRequestByFullName() == null ? user.getUserFullName() : rcBean.getRequestByFullName() %>" disabled="true" /></td>
		<%
		  if (ArchitectureConstants.Y.equals(rcBean.getIndReccheckHistory())){
		%>
				<td align="center"><impact:validateInput type="checkbox" checked="true" name="<%= "indReccheckHistory" + trackCount %>" value="Y" /></td>
		<%
		  } else {
		%>
				<td align="center"><impact:validateInput type="checkbox" checked="false" name="<%= "indReccheckHistory" + trackCount %>" value="Y" /></td>
		<%
		  }
		%>
			</tr>
			<tr class="<%=rowCount % 2 == 0 ? "even" : "odd"%>">
				<td colspan="4">Comments: <impact:validateTextArea maxLength="500" cols="60" rows="2" name="<%= "txtRecCheckComments" + trackCount %>"> <%=rcBean.getTxtRecCheckComments() == null ? "" : rcBean.getTxtRecCheckComments()%> </impact:validateTextArea></td>
				<td>&nbsp;</td>
			</tr>
    	<!-- END DISPLAY MISSING RECORDS CHECKS IN ROWS -->
    	<%
    	  rowCount++;
    	            trackCount++;
    	          }
    	        }
    	      }
    	%>
    		<tr class="odd">
				<td align="right" colspan="6">
					<input border="0" type="image" onclick="" alt="Save" name="btnSave" src="/grnds-docs/images/shared/btnSave.gif" id="btnSave_Id" tabindex="8" class="md">
				</td>
			</tr>
    	</table>
    </div>
    <p>&nbsp</p>
<script>
setTrackCount('<%=String.valueOf(trackCount)%>');
isInformationalNeeded(<%=trackCount%>);
</script>
</impact:validateForm>
<!-- END ADD RECORDS CHECK BY TYPE AREA -->

<%
  }
  //-- --------------------------------------------------END RECORDS CHECK SUMMARY ADD BY PERSON VIEW---------------------------------------
%>