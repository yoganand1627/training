<%-- 
JSP Name:     Case Review
Created by:   Bhavna Gehlot
Date Created: 3/10/2009

Description:
This JSP Displays the Case Review detail.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
06/09/2009  bgehlot         STGAP00014146: Users should be able to save the Targeted Case Review  and 
                            mark as complete with a limited amount of questions answered.	
08/17/2009  bgehlot         STGAP00015113: Changed the Comments field length to 500 characters     
09/03/2009  bgehlot         STGAP00015183: Display Delete button in NEW status too.           
10/09/2009  bgehlot         SMS#38872 Extend the length of text areas on the Case Review Detail page to be 4,000 characters.
							Add a hard stop when character limit is reached.Add Spell Check button,
							Change the 'Complete'checkbox to read 'Review Complete'.
							Add a new display field to the Case Review Detail page which displays the date the case review was marked 'Review Complete'
							Change the 'Date of Review' field to read 'Date Review Began'.
12/23/2009 bgehlot        SMS#42495: Display Question numbers in front of the Question text							

   
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewQuestionsSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.CaseReviewConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewCbxQuestionsSO"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.HashMap" %>

<%
  //Set the page mode 
  String pageMode = PageMode.getPageMode(request);

  boolean sDisableField = false;
  boolean sdisableDtCorrectionComplete = false;
  boolean sdisableSaveButton = true;

  if (pageMode.equals(PageModeConstants.VIEW)) {
    sDisableField = true;
    sdisableDtCorrectionComplete = true;
    sdisableSaveButton = true;
  }
  
  ROWCCMN45DO eventDetails = null;

  // Get the user profile, if needed.
  UserProfile user = UserProfileHelper.getUserProfile(request);
  
  if(!(user.hasRight(UserProfile.SEC_CASE_REVIEW))){
    sDisableField = true;
    sdisableDtCorrectionComplete = true;
    sdisableSaveButton = true;
  }
  
  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  int numOfQuestions = 0;
  int numOfCategories = 0;
  List<CaseReviewQuestionsSO> questionsInSameCategory = new ArrayList<CaseReviewQuestionsSO>();
  List<List<CaseReviewQuestionsSO>> questionsByCategory = new ArrayList<List<CaseReviewQuestionsSO>>();
  CaseReviewQuestionsSO currentQuestion = null;
  CaseReviewQuestionsSO nextQuestion = null;
  CaseReviewQuestionsSO question = null;
  int loopCounter = 0;
  String fieldName = StringHelper.EMPTY_STRING;
  String yIsChecked = "false";
  String nIsChecked = "false";
  String uIsChecked = "false";
  String previousItem = StringHelper.EMPTY_STRING;
  Boolean quesIsComplete = Boolean.FALSE;
  String expandedDivName = StringHelper.EMPTY_STRING;
  String collapsedDivName = StringHelper.EMPTY_STRING;
  Map<String, Boolean> completionCheckMap = null;
  String textQuesColor = StringHelper.EMPTY_STRING;
  String crTsLastUpdate = StringHelper.EMPTY_STRING;
  Boolean performCompletionCheck = Boolean.FALSE;
  String EVENT_STATUS_COMP = "COMP";
  String EVENT_STATUS_PROC = "PROC";
  String EVENT_STATUS_NEW = "NEW";
  String isComplete = "false";
  String tsLastUpdate ="";
  boolean btnDeleteDisplay = false;
  boolean btnDeleteDisplayForSecAttr = false;
  String msgConfirm = MessageLookup.getMessageByNumber(Messages.MSG_CSR_CFRM_COMP);
  Map<String, String> prepopulatedData = null;
  String cdReviewType = ContextHelper.getStringSafe(request, "selReviewType");
  boolean sdisableReviewType = false;
  //Set up the exclude array.
  ArrayList<String> excludeOptions = new ArrayList<String>();
  boolean exclamationMark = false;
  int ulIdStage = GlobalData.getUlIdStage( request );
  String mainQuesName = StringHelper.EMPTY_STRING;
  String disableMain = StringHelper.EMPTY_STRING;
  String enableMain = StringHelper.EMPTY_STRING;
  List<String> decisionFieldNames = new ArrayList<String>();
  int arrayIndex = 0;
  String isMainDisabled = "false";
  //SMS#38872
  String fieldsToCheck = "";
  
  if ("on".equals(ContextHelper.getStringSafe(request, "cbxComplete"))) {
    isComplete = "true";
  }

  // Get the output object out of the request
  CaseReviewRetrieveSO caseReviewRetrieveSO = (CaseReviewRetrieveSO) request.getAttribute("CaseReviewRetrieveSO");
  if (caseReviewRetrieveSO != null) {
    cdReviewType = caseReviewRetrieveSO.getCdReviewType();
    if(StringHelper.EMPTY_STRING.equals(cdReviewType)){
     cdReviewType = ContextHelper.getStringSafe(request, "selReviewType");
    }
    if(CodesTables.CCSRTYPE_RT4.equals(cdReviewType)){
      sdisableReviewType = true;
    }else{
       //Exclude -Sample Review-.
       excludeOptions.add(CodesTables.CCSRTYPE_RT4);
    }
 
    if(ArchitectureConstants.Y.equals(caseReviewRetrieveSO.getIndComplete())){
      isComplete = "true";
    }else{
      isComplete = "false";
    }
    crTsLastUpdate = DateHelper.toISOString(caseReviewRetrieveSO.getDtLastUpdate());
   
    eventDetails = caseReviewRetrieveSO.getROWCCMN45DO();
     if (eventDetails != null && eventDetails.getUlIdEvent() != 0) {
      tsLastUpdate = DateHelper.toISOString(eventDetails.getTsLastUpdate());
      //If event is in COMP status all the fields are disabled or all the users with general view access
      if(EVENT_STATUS_COMP.equals(eventDetails.getSzCdEventStatus())){
          sDisableField = true;
          sdisableDtCorrectionComplete = true;
      }
     
     //If event is in COMP status all the fields are disabled other than the date Correction Complete and Save button
     // for th eReviewer and the Primary Case Manager. Updating a case review in 'COMP' status is restricted to the 
     // person who first saved the review.
     if(EVENT_STATUS_COMP.equals(eventDetails.getSzCdEventStatus()) && 
            (user.getUserID() == caseReviewRetrieveSO.getIdReviewer() ||
             user.getUserID() == caseReviewRetrieveSO.getIdCaseWorker())){
          sdisableSaveButton = false;
          sdisableDtCorrectionComplete = false;
     }
      
     //If th event status is NEW and the user is not the one who has the To Do for that event then all the fields are
     // disabled
     if(EVENT_STATUS_NEW.equals(eventDetails.getSzCdEventStatus()) &&
            caseReviewRetrieveSO.getDisableCdReviewType()){
        sDisableField = true;
        sdisableDtCorrectionComplete = true;
      }
      
      //If the event is PROC and the user is not the Reviewer then disable all the fields as
      // Updating a case review in 'PROC' status is restricted to the person who first saved the review.
      if(EVENT_STATUS_PROC.equals(eventDetails.getSzCdEventStatus()) 
         && user.getUserID() != caseReviewRetrieveSO.getIdReviewer()){
          sDisableField = true;
         sdisableDtCorrectionComplete = true;
      }
      
      //If the status is 'PROC' and the Case Review is Reviewer initiated then display the delete button
      if(EVENT_STATUS_PROC.equals(eventDetails.getSzCdEventStatus()) && 
            user.getUserID() == caseReviewRetrieveSO.getIdReviewer() &&
            caseReviewRetrieveSO.getReviewerInitiatedCaseReview()){
        btnDeleteDisplay = true;
      }
      
      //Display the delete button if the user has the DELETE_CASE_REVIEW security attribute and the event is in PROC or NEW status
      // as the Case Reviews can now be deleted when in PROC or NEW status as per STGAP00015183
     if(user.hasRight(UserProfile.SEC_DELETE_CASE_REVIEW) && (EVENT_STATUS_PROC.equals(eventDetails.getSzCdEventStatus())
       || EVENT_STATUS_NEW.equals(eventDetails.getSzCdEventStatus()))){
          btnDeleteDisplayForSecAttr = true;
      }
      
     if(!(user.hasRight(UserProfile.SEC_CASE_REVIEW))){
	    sDisableField = true;
	    sdisableDtCorrectionComplete = true;
	    sdisableSaveButton = true;
     }
   }
    
   
    //---------------------------------------
    //--- GROUP THE QUESTIONS BY CATEGORY ---
    //---------------------------------------
    // Iterate through the questions for this Case Review and display
    // each the data as needed. The Question Array will contain data pertaining
    // to the question and the Category and Item to which the question belongs.
    List<CaseReviewQuestionsSO> caseReviewQuestionList = new ArrayList<CaseReviewQuestionsSO>();
    caseReviewQuestionList = caseReviewRetrieveSO.getCaseReviewQuestionsList();
    if (caseReviewQuestionList != null && !caseReviewQuestionList.isEmpty()) {
      numOfQuestions = caseReviewQuestionList.size();

      for (int i = 0; i < numOfQuestions; i++) {
        // Get the current question.
        currentQuestion = (CaseReviewQuestionsSO) caseReviewQuestionList.get(i);
      

        // Get the next question if one is available.
        nextQuestion = null;
        if (i < (numOfQuestions - 1)) {
          nextQuestion = (CaseReviewQuestionsSO) caseReviewQuestionList.get(i + 1);
        }

        // If this is the first iteration through the loop, then add the current
        // question to the array of questionsInSameCategory. It will be the first
        // question in the array.
        if (i == 0) {
          questionsInSameCategory.add(currentQuestion);
        }
        // If the current question is the last question in the questions array,
        // or if the next question is in a different Area from the current question
        // , then the current question is the final question to be added the
        // questionsInSameCategory array. Add the question to the array, and add the array
        // to the questionsByCategory parent array.
        else if (nextQuestion == null || !currentQuestion.getSzCdCategory().equals(nextQuestion.getSzCdCategory())) {
          questionsInSameCategory.add(currentQuestion);
          questionsByCategory.add(questionsInSameCategory);

          // If the current question is not the last question in the questions
          // array, then reset the questionsInSameCategory array so that we can start
          // adding questions to it during the next iteration through the loop.
          questionsInSameCategory = null;
          if (nextQuestion != null) {
            questionsInSameCategory = new ArrayList<CaseReviewQuestionsSO>();
          }
        }
        // Add the current question to the questionsInSameCategory array.
        else {
          questionsInSameCategory.add(currentQuestion);
        }
      }// end for loop
    }
  }
  //if null set to blank (initialize)
  else {
    caseReviewRetrieveSO = new CaseReviewRetrieveSO();
  }
 %>
  	<%-- Needed for Form Launch Custom tag --%>
	<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
	<%--
       Create javascript functions here for page specific actions on the page. All form submits should use the
       submitValidateForm function to submit which is included in the JavaScript files included in index.jsp.
    --%>
<script src="/grnds-docs/js/document/document.js"></script>
	<script type="text/javascript" language="JavaScript1.2">

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  };
  
  function savePageAdd()
  {
    if (document.frmCaseReview.cbxComplete.checked == true){
      if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CSR_CFRM_COMP)%>') == true){
         return true;
      }
    }else{
      return true;
    }  
  }
  
  function disableMainQues(mainQuesName, fieldName, quesType){
   if(quesType == "D"){ 
    var decisionQues = eval("document.getElementsByName(\"" + fieldName + "\")");
    var mainQues = eval("document.getElementsByName(\"" + mainQuesName + "\")");
    if(decisionQues[1].checked == true){
     if(mainQues.length > 0){
      mainQues[1].checked = true;
      mainQues[0].disabled = true;
      mainQues[1].disabled = true;
      mainQues[2].disabled = true;
     }
      document.frmCaseReview.isMainDisabled.value = "true";
    }
   }
  }
  <% out.println("var myArray = [];"); 
     int startIndex = 0;
     int endIndex = 0;%>
  function enableMainQues(mainQuesName, startIndex, endIndex, quesType){
    var startIndexInt = parseInt(startIndex) ;
    var endIndexInt = parseInt(endIndex) ;
    if(quesType == "D"){
     var isDecisionNo = false;
     for(var i=startIndexInt; i < endIndexInt; i++){
      var mainQues = eval("document.getElementsByName(\"" + mainQuesName + "\")");
      var decisionQues = eval("document.getElementsByName(\"" + myArray[i] + "\")");
      
      if(decisionQues[1].checked == true){
        isDecisionNo = true;
        break; 
      }
    }
    if(isDecisionNo == false){
     if(mainQues.length > 0){
      mainQues[1].checked = false;
      mainQues[0].disabled = false;
      mainQues[1].disabled = false;
      mainQues[2].disabled = false;
     }
      document.frmCaseReview.isMainDisabled.value = "false";
    }else{
      document.frmCaseReview.isMainDisabled.value = "true";
    }  
   }
  }
  
  window.onload = function ()
  {
   <%  
     ROWCCMN45DO eventDetailsInner = caseReviewRetrieveSO.getROWCCMN45DO();
     String eventStatusInner = "";
     if (eventDetailsInner != null && eventDetailsInner.getUlIdEvent() != 0) {
       eventStatusInner = eventDetailsInner.getSzCdEventStatus();
     }
     String fieldNameInner = "";
     String mainQuesNameInner = "";
     String quesTypeInner = "";
     String disableMainInner = "";
     String mainQuesItemType = "";
     String currentQuesItemType = "";
     if(sDisableField == false){
	   if (caseReviewRetrieveSO.getCaseReviewQuestionsList() != null && !caseReviewRetrieveSO.getCaseReviewQuestionsList().isEmpty()) {
	     Iterator<CaseReviewQuestionsSO> iterInner = caseReviewRetrieveSO.getCaseReviewQuestionsList().iterator();
	     while(iterInner.hasNext()){
	      CaseReviewQuestionsSO currentQuestionInner = (CaseReviewQuestionsSO) iterInner.next();
	      fieldNameInner = "rb" + currentQuestionInner.getSzCdQuestion() + "Response";
	      currentQuesItemType = currentQuestionInner.getSzCdItem();
	      quesTypeInner = currentQuestionInner.getIndQuestionType();
		    if("M".equals(currentQuestionInner.getIndQuestionType())){
		    mainQuesItemType = currentQuesItemType;
	        if(currentQuestionInner.getMainQuestionDisabled()){
	          mainQuesNameInner = fieldNameInner+ "_Disabled";
	        }else{
	          mainQuesNameInner = fieldNameInner;
	        }
	      }
       disableMainInner = "disableMainQues('" + mainQuesNameInner + "', '" + fieldNameInner + "', '" + quesTypeInner + "');";
      %>
      <% if(currentQuesItemType != null && currentQuesItemType.equals(mainQuesItemType)){%>
          <%= disableMainInner %>
      <%}
      }
     }
   }%>
 }
  

</script>
<%
//***********************************
//****      COMPLETION CHECK     ****
//***********************************

// Check the request to see if the "performCompletionCheck" indicator
// has been passed to this page. If the indicator has been passed to
// this page and is "true", then a completion check is being performed.

if ( request.getAttribute("performCompletionCheck") != null )
{
  performCompletionCheck = ( Boolean )request.getAttribute("performCompletionCheck");
}
%>


<%
//**************************
//**** FORM STARTS HERE ****
//**************************
%>

<impact:validateErrors />
<impact:validateForm name="frmCaseReview" method="post"
	action="/casemgmt/CaseReview/saveCaseReview" pageMode="<%=pageMode%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.CaseReviewCustomValidation"
	schema="/WEB-INF/Constraints.xsd">
	
    <impact:validateInput type="hidden" name="tsLastUpdate"
		value="<%=tsLastUpdate%>" />
	<impact:validateInput type="hidden" name="crTsLastUpdate"
		value="<%=crTsLastUpdate%>" />
    <impact:validateInput type="hidden" name="isMainDisabled"
		value="<%=isMainDisabled%>" />

		
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<a tabIndex="<%=tabIndex++%>" href="#" onClick="expandAll();">Expand
					All</a>
				<a tabIndex="<%=tabIndex++%>" href="#" onClick="collapseAll();">Collapse
					All</a>
			</td>
		</tr>
	</table>
	<%  //----------------------------------------------
        //--- DISPLAY THE Review Information SECTION ---
        //---------------------------------------------- %>
	<%-- Start the HTML for the page --%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="12">
				Review Information
			</th>
		</tr>
		<tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="szNmReviewer" colspan="3"
					label="Reviewed by(Name and Position)" value="<%=FormattingHelper.formatString(caseReviewRetrieveSO.getNmReviewer()) %>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="idCase" colspan="3"
					label="Case ID" value="<%=FormattingHelper.formatInt(caseReviewRetrieveSO.getIdCase()) %>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="szNmCase" colspan="3"
					label="Case Name" value="<%= FormattingHelper.formatString(caseReviewRetrieveSO.getNmCase())%>" />
			</td>

		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="szNmCaseWorker" colspan="3"
					label="Case Worker" value="<%=FormattingHelper.formatString(caseReviewRetrieveSO.getNmCaseWorker() )%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="szCdRegion" colspan="3"
					label="Region" value="<%= FormattingHelper.formatString(caseReviewRetrieveSO.getCdRegion()) %>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="szCdCounty" colspan="3"
					label="County" value="<%=FormattingHelper.formatString(caseReviewRetrieveSO.getCdCounty()) %>" />
			</td>

		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="reviewPeriod" colspan="3"
					label="Review Period" value="<%=FormattingHelper.formatString(caseReviewRetrieveSO.getReviewPeriod()) %>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dtDtCaseOpened" colspan="3"
					label="Open Date" value="<%=FormattingHelper.formatDate(caseReviewRetrieveSO.getDtStageOpened()) %>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dtDtReview" colspan="3"
					label="Date Review Began" value="<%=FormattingHelper.formatDate(caseReviewRetrieveSO.getDtReview()) %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="szCdCaseProgram" colspan="3"
					label="Case Program" value="<%=FormattingHelper.formatString(caseReviewRetrieveSO.getCdCaseProgram()) %>" />
			</td>
            <td colspan="3" nowrap>
              <impact:validateSelect 
                label="Review Type" 
                name="selReviewType" 
                tabIndex="<%= tabIndex++ %>" 
                disabled='<%= Boolean.toString(sDisableField || sdisableReviewType)%>'
                orderBy="decode" 
                codesTable="CCSRTYPE" 
                value="<%=cdReviewType %>" 
                required="true"
                excludeOptions="<%=excludeOptions%>" />
            </td>
            <td>
				<impact:validateDisplayOnlyField name="dtDtReviewComplete" colspan="3"
					label="Date Review Completed" value="<%=FormattingHelper.formatDate(caseReviewRetrieveSO.getDtReviewComplete()) %>" />
			</td>
 		</tr>
	</table>
	
<%
  //-----------------------------------
  //--- DISPLAY THE QUESTIONS ---
  //-----------------------------------
  // Get the total number of categories in the Case Review.
  numOfCategories = questionsByCategory.size();

  // Loop through the array of questionsByCategory. Get each questionsInSameCategory
  // array which contains all the questions in the same category. Then loop through each
  // of those arrays and display the Category one at a time. Each Category
  // will appear in its own expandable section.
  for (int j = 0; j < numOfCategories; j++) {
  mainQuesName = StringHelper.EMPTY_STRING;
    loopCounter = 1;
    exclamationMark = false;
    questionsInSameCategory = questionsByCategory.get(j);

    // Each iteration through the parent loop will create a new Category
    // expandable section. Start the expandable section here.
%>
	<br>
	<impact:ExpandableSectionTag
		name="<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdCategory()%>"
		id=""
		label="<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzTxtCategory()%>"
		tabIndex="<%=tabIndex++%>"
		anchor="<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdCategory()%>">

		<%
          // Display the header for this Category's first Item.
        %>
		<table border="0" cellpadding="3" cellspacing="0" width="100%"
			class="tableBorderExpand">
			<tr class="thList">
				<th>
					<a name="<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem()%>"></a>
					<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzTxtItem()%>
				</th>
		    </tr>
				<%if("WLLIT3".equals(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem())){
				     List<Map<String,Object>> contactSummaryList = caseReviewRetrieveSO.getContactSummaryList();
				     Calendar cal = new GregorianCalendar();
                     cal.setTime( new java.util.Date() );
				    // Set to current year unless month is January, then set to Year - 1
                     int month = cal.get( Calendar.MONTH );
                     int year = cal.get( Calendar.YEAR );
                     String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", 
                                           "September", "October", "November", "December"}; 
                     List<String> pastSixMonths = new ArrayList<String>();
                     for(int i = 2; i<=7 ; i++){
                       if((month - i) >= 0){
                          pastSixMonths.add(monthName[month - i] + " - " + year);
                       }else{
                          pastSixMonths.add(monthName[(month - i) + 12] + " - " + (year - 1));
                       }
                     }
                     
                 %>
              <tr>
                 <td colspan="12">
				   <impact:ExpandableSectionTag name="ContactLog"
                             id="" label="Contact Log" tabIndex="<%=tabIndex++%>" anchor="<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem()%>">
                      <div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>       
                      <div id="horizontalScrollResults" style="width:740px; height:210px; overflow:auto" class="tableborderList">
                      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
                         <tr>
                           <td>
                            <table border="0" cellspacing="0" cellpadding="3" width="1200">
                              <tr class="thList">
                                <th class="thList">Name</th>
                                <th class="thList">Relationship</th>
                                <% for(int i = 0; i<6 ; i++){ %>
                                  <th class="thList"><%=pastSixMonths.get(i)%></th>
                                <% } %>
                              </tr>
                             <%  int contactCount = 1; 
                                 if (contactSummaryList != null && !contactSummaryList.isEmpty()) {
                                  Iterator<Map<String,Object>> itcontactSummaryList = contactSummaryList.iterator();
                                  while (itcontactSummaryList.hasNext()) {
                                    Map<String,Object> map = itcontactSummaryList.next(); 
                                    String tableRowClassContact = FormattingHelper.getRowCss(contactCount++);%>
                                    <tr class="<%=tableRowClassContact%>">
                                      <td><%= FormattingHelper.formatString((String) map.get("nmPersonFull"))%></td>
                                      <td><%= Lookup.simpleDecodeSafe( "CRPTRINT", (String) map.get("cdStagePersRelInt"))%></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month1"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month2"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month3"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month4"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month5"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month6"))  %></td>
                                   </tr>
                                 <%
                                  }//While
                                 }//If %>
                            </table>
                          </td>
                         </tr>
                       </table>
                     </div>
                   </impact:ExpandableSectionTag>
                </td>
             </tr>
				<% } %>


			<%
              numOfQuestions = questionsInSameCategory.size();
              for (int k = 0; k < numOfQuestions; k++) {
                // Get the current question.
                currentQuestion = (CaseReviewQuestionsSO) questionsInSameCategory.get(k);

                // Get the next question if one is available.
                nextQuestion = null;
                if (k < (numOfQuestions - 1)) {
                  nextQuestion = (CaseReviewQuestionsSO) questionsInSameCategory.get(k + 1);
                }

                // Display the current question. 
                String tableRowClass = FormattingHelper.getRowCss(loopCounter++);
                String tableRowClassNext = FormattingHelper.getRowCss(loopCounter);
             %>
			<tr class="<%=tableRowClass%>">
			<%
               // Dynamically create the name to be used for the Question's
              // possible responses radio buttons.
              fieldName = "rb" + currentQuestion.getSzCdQuestion() + "Response";
              // Set the "is checked" indicator for each possible response
              // based upon the response value retrieved from the database.
              yIsChecked = "false";
              nIsChecked = "false";
              uIsChecked = "false";
              
              //prepopulating questions depending on rules
              prepopulatedData = caseReviewRetrieveSO.getPrepopulatedData();
              if(prepopulatedData != null ){
                String prepopulatedResponse = prepopulatedData.get(currentQuestion.getSzCdQuestion());
                if(prepopulatedResponse != null ){
                   if ("0".equals(prepopulatedResponse)) {
                      yIsChecked = "true";
                   } else if ("1".equals(prepopulatedResponse)) {
                      nIsChecked = "true";
                   } else if ("2".equals(prepopulatedResponse)) {
                      uIsChecked = "true";
                   }
                }
              }
               
              if (currentQuestion.getSzCdQuestionResponse() != null) {
                if ("0".equals(currentQuestion.getSzCdQuestionResponse())) {
                  yIsChecked = "true";
                } else if ("1".equals(currentQuestion.getSzCdQuestionResponse())) {
                  nIsChecked = "true";
                } else if ("2".equals(currentQuestion.getSzCdQuestionResponse())) {
                  uIsChecked = "true";
                }
              }
             %>
             <%
              //If Performing completion check set the text color for the question to RED if that question is not 
              // answered.
              if (performCompletionCheck )
              {  //STGAP00014146 
                 if (!caseReviewRetrieveSO.getIndCaseReviewComplete() && !CodesTables.CCSRTYPE_RT1.equals(ContextHelper.getStringSafe(request, "selReviewType")))
                 {
                   completionCheckMap = caseReviewRetrieveSO.getReviewCompletionStatus();
                   if(completionCheckMap != null){
                     quesIsComplete = ( Boolean )completionCheckMap.get( currentQuestion.getSzCdQuestion() );
                     if ( quesIsComplete != null && !quesIsComplete ){
                       textQuesColor = "style=\"color: red;\"";
                     }else{
                       textQuesColor = StringHelper.EMPTY_STRING;
                     }
                   }
                 }
              }
             %>
		        <td <%=textQuesColor %> title="<%=currentQuestion.getTxtQuesHelp()%>" >
			        <% 
			        out.println("<script>");
			           String txtQuestion = currentQuestion.getSzTxtQuestion();
			           //Disable main question if the decision question is answered No.
			           boolean mainQuesDisabled = currentQuestion.getMainQuestionDisabled();
			           //If there is Main Question then Red Exclamatory Mark must precede the Decision Question
			           if("M".equals(currentQuestion.getIndQuestionType())){
			             exclamationMark = true;
			             if(mainQuesDisabled){
			               mainQuesName = fieldName+ "_Disabled";
			             }else{
			               mainQuesName = fieldName;
			             }
			             startIndex = endIndex;
			             if (caseReviewRetrieveSO.getCaseReviewQuestionsList() != null && !caseReviewRetrieveSO.getCaseReviewQuestionsList().isEmpty()) {
                           Iterator<CaseReviewQuestionsSO> iterInner = caseReviewRetrieveSO.getCaseReviewQuestionsList().iterator();
                           while(iterInner.hasNext()){
                            CaseReviewQuestionsSO currentQuestionInner = (CaseReviewQuestionsSO) iterInner.next();
                            String cdItem = currentQuestion.getSzCdItem();
                            if("D".equals(currentQuestionInner.getIndQuestionType()) && cdItem.equals(currentQuestionInner.getSzCdItem())){
                              decisionFieldNames.add("rb" + currentQuestionInner.getSzCdQuestion() + "Response");
                             out.println("myArray[" + arrayIndex + "] = 'rb" + currentQuestionInner.getSzCdQuestion() + "Response';");
                             arrayIndex++;
                            }
                          }
                            endIndex = arrayIndex;
                         }
			           }
			           out.println("</script>");
			           disableMain = "disableMainQues('" + mainQuesName + "', '" + fieldName + "', '" + currentQuestion.getIndQuestionType() + "');";
			           enableMain = "enableMainQues('" + mainQuesName + "', '" + startIndex + "', '" + endIndex + "', '" + currentQuestion.getIndQuestionType() + "');";
 			        %>
 			        <%if(exclamationMark && "D".equals(currentQuestion.getIndQuestionType())){%>
 			           <b style="color: red; font-size: 16;" >!</b> <%=currentQuestion.getTxtQuestionNum()%><%=txtQuestion%>
 			        <%}else if("M".equals(currentQuestion.getIndQuestionType())){ %>
 			           <b style="font-size: 14;"><%=currentQuestion.getTxtQuestionNum()%><%=txtQuestion%></b>
 			        <%}else{%>	
 			           <%=currentQuestion.getTxtQuestionNum()%><%=txtQuestion%>
 			         <%} %>				
					<% // If the question has checkboxes display them
					   if(ArchitectureConstants.Y.equals(currentQuestion.getIndCbx())){
					    List<String> checkedCheckboxesList = new ArrayList<String>();
					    if(currentQuestion.getCheckedCheckboxes() != null){
					       checkedCheckboxesList = Arrays.asList(currentQuestion.getCheckedCheckboxes());
					    }
%>
					    <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
                            <tr>
                                <td>
                                   <impact:castorCheckbox
                                        castorEnum="<%= Collections.enumeration(currentQuestion.getCaseReviewCbxQuestionsList()) %>"
                                        name="chkQuestion"
                                        labelPropertyName="Code"
                                        valuePropertyName="Decode"
                                        checkedValues="<%= checkedCheckboxesList %>"
                                        disabled="<%=String.valueOf(sDisableField)%>"
                                        columns="2"
                                        isRuled="false"
                                        isHorizontal="false"                
                                        tabIndex="<%= tabIndex++ %>"/>
                                </td>
                           </tr>
                      </table>
				   <%} %>
			    </td>
				<td>
					<impact:validateInput type="radio" checked="<%=yIsChecked%>"
						tabIndex="<%=tabIndex++%>" value="0" name="<%=fieldName%>" 
						cssClass="formInput" disabled="<%=String.valueOf(sDisableField || mainQuesDisabled)%>" 
						onClick="<%=enableMain%>"/>
				</td>
				<td>Yes</td>
				<td>
					<impact:validateInput type="radio" checked="<%=nIsChecked%>"
						tabIndex="<%=tabIndex++%>" value="1" name="<%=fieldName%>" 
						cssClass="formInput" disabled="<%=String.valueOf(sDisableField || mainQuesDisabled)%>" 
						onClick="<%=disableMain%>"/>
				</td>
				<td>No</td>
				<td>
					<impact:validateInput type="radio" checked="<%=uIsChecked%>"
						tabIndex="<%=tabIndex++%>" value="2" name="<%=fieldName%>"
						cssClass="formInput" disabled="<%=String.valueOf(sDisableField || mainQuesDisabled)%>" 
						onClick="<%=enableMain%>"/>
				</td>
				<td>N/A</td>
			</tr>

		<%
         // If a new Item will start in the next iteration of the loop,
        // then display the Item header here.
        if (nextQuestion != null && !currentQuestion.getSzCdItem().equals(nextQuestion.getSzCdItem())) {
          loopCounter = 1;
          exclamationMark = false;
        %>
           <tr class="<%=tableRowClassNext%>">
              <td colspan="12">
                 <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>
                     <td> 
                        <impact:validateTextArea 
                           label = "Comments"
                           name="<%= "txt" + currentQuestion.getSzCdItem() + "comments" %>"
                           constraint="Paragraph4000"
                           tabIndex="<%= tabIndex++ %>"
                           maxLength="4000"
                           disabled="<%=String.valueOf(sDisableField)%>"
                           cols = "100"
                           rows = "5"><%= FormattingHelper.formatString(currentQuestion.getTxtComments())%></impact:validateTextArea>
                     </td>
                     <% if("".equals(fieldsToCheck)){ //SMS#38872 Spell Check text boxes
                          fieldsToCheck = "txt" + currentQuestion.getSzCdItem() + "comments";
                        }else{
                          fieldsToCheck = fieldsToCheck + ", " + "txt" + currentQuestion.getSzCdItem() + "comments";
                        }%>
                   </tr>
                 </table>
              </td>
            </tr>
 			<tr class="thList">
				<th>
					<a name="<%=nextQuestion.getSzCdItem()%>"></a>
					<%=nextQuestion.getSzTxtItem()%>
				</th>
			</tr>
            <%if("WLLIT3".equals(nextQuestion.getSzCdItem())){
				     List<Map<String,Object>> contactSummaryList = caseReviewRetrieveSO.getContactSummaryList();
				     Calendar cal = new GregorianCalendar();
                     cal.setTime( new java.util.Date() );
				    // Set to current year unless month is January, then set to Year - 1
                     int month = cal.get( Calendar.MONTH );
                     int year = cal.get( Calendar.YEAR );
                     String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", 
                                           "September", "October", "November", "December"}; 
                     List<String> pastSixMonths = new ArrayList<String>();
                     for(int i = 2; i<=7 ; i++){
                       if((month - i) >= 0){
                          pastSixMonths.add(monthName[month - i] + " - " + year);
                       }else{
                          pastSixMonths.add(monthName[(month - i) + 12] + " - " + (year - 1));
                       }
                     }
                     
                 %>
              <tr>
                 <td colspan="12">
				   <impact:ExpandableSectionTag name="ContactLog"
                             id="" label="Contact Log" tabIndex="<%=tabIndex++%>" anchor="<%=((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem()%>">
                      <div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>       
                      <div id="horizontalScrollResults" style="width:740px; height:210px; overflow:auto" class="tableborderList">
                      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
                         <tr>
                           <td>
                            <table border="0" cellspacing="0" cellpadding="3" width="1200">
                              <tr class="thList">
                                <th class="thList">Name</th>
                                <th class="thList">Relationship</th>
                                <% for(int i = 0; i<6 ; i++){ %>
                                  <th class="thList"><%=pastSixMonths.get(i)%></th>
                                <% } %>
                              </tr>
                             <%  int contactCount = 1; 
                                 if (contactSummaryList != null && !contactSummaryList.isEmpty()) {
                                  Iterator<Map<String,Object>> itcontactSummaryList = contactSummaryList.iterator();
                                  while (itcontactSummaryList.hasNext()) {
                                    Map<String,Object> map = itcontactSummaryList.next(); 
                                    String tableRowClassContact = FormattingHelper.getRowCss(contactCount++);%>
                                    <tr class="<%=tableRowClassContact%>">
                                      <td><%= FormattingHelper.formatString((String) map.get("nmPersonFull")) %></td>
                                      <td><%= Lookup.simpleDecodeSafe( "CRPTRINT", (String) map.get("cdStagePersRelInt"))%></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month1"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month2"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month3"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month4"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month5"))  %></td>
                                      <td><%= FormattingHelper.formatString((String) map.get("Month6"))  %></td>
                                   </tr>
                                 <%
                                  }//While
                                 }//If %>
                            </table>
                          </td>
                         </tr>
                       </table>
                     </div>
                   </impact:ExpandableSectionTag>
                </td>
             </tr>
				<% } %>

			<%
         }// end if %>
     <% }// end for
       // Each iteration through the parent loop will create a new Category
       // expandable section. End the expandable section here.
       String tableRowClass = FormattingHelper.getRowCss(loopCounter);
    %>
           <tr class="<%=tableRowClass%>">
              <td colspan="12">
                 <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>
                     <td> 
                        <impact:validateTextArea 
                           label = "Comments"
                           name="<%= "txt" + currentQuestion.getSzCdItem() + "comments" %>"
                           tabIndex="<%= tabIndex++ %>"
                           constraint="Paragraph4000"
                           maxLength="4000"
                           disabled="<%=String.valueOf(sDisableField)%>"
                           cols = "100"
                           rows = "5"><%= FormattingHelper.formatString(currentQuestion.getTxtComments())%></impact:validateTextArea>
                     </td>
                     <% fieldsToCheck = fieldsToCheck + ", " + "txt" + currentQuestion.getSzCdItem() + "comments"; %>
                   </tr>
                 </table>
              </td>
            </tr>
    </table>
	</impact:ExpandableSectionTag>
<%
  }//end for
%>
<br>
<%
   //-------------------------------
   //DISPLAY  THE Summary SECTION
   //-------------------------------
 %>
<%--Summary Section  --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="16">
				Summary
			</th>
		</tr>
		<tr>
		<tr>
		  <td colspan="16">
            <table border="0" cellspacing="3" cellpadding="3" width="100%">
              <tr valign="top">
				   <td width="33%">
						<impact:validateDate name="dtStaffedWithWorker" disabled="false" type="text"
							label="Date Staffed With Worker" value="<%=FormattingHelper.formatDate(caseReviewRetrieveSO.getDtStaffedWithWorker())%>" size="10"
							constraint="Date" tabIndex="<%=tabIndex++%>" disabled="<%=String.valueOf(sDisableField)%>" />
				   </td>
			       <td width="33%">
						<impact:validateDate name="dtCorrectionsDue" disabled="false" type="text"
							label="Date Corrections Due" value="<%=FormattingHelper.formatDate(caseReviewRetrieveSO.getDtCorrectionDue())%>" size="10"
							constraint="Date" tabIndex="<%=tabIndex++%>" disabled="<%=String.valueOf(sDisableField)%>" />
				   </td>	
				   <td width="33%">
						<impact:validateDate name="dtCorrectionsComplete" disabled="false" type="text"
							label="Date Corrections Completed" value="<%=FormattingHelper.formatDate(caseReviewRetrieveSO.getDtCorrectionComplete())%>" size="10"
							constraint="Date" tabIndex="<%=tabIndex++%>"  disabled="<%=String.valueOf(sdisableDtCorrectionComplete)%>" />
				   </td>
		      </tr>
		    </table>
		  </td>
		 </tr> 
		<tr>
            <td colspan="16"> 
               <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>
                     <td> 
                        <impact:validateTextArea 
                           label = "Feedback"
                           name="<%= "txtSummaryComment" %>"
                           tabIndex="<%= tabIndex++ %>"
                           constraint="Paragraph4000"
                           maxLength="4000"
                           disabled="<%=String.valueOf(sDisableField)%>"
                           cols = "100"
                           rows = "5"><%= FormattingHelper.formatString(caseReviewRetrieveSO.getTxtSummaryComment())%>
                        </impact:validateTextArea>
                     </td>
                     <%fieldsToCheck = fieldsToCheck + ", " + "txtSummaryComment"; %>
                   </tr>
               </table>
            </td>
 		</tr>
	</table>
<br>
<%
    //*****************
    //**** BUTTONS ****
    //*****************
    // Display the Complete and Save buttons unless the page mode is VIEW. If page
    // mode is VIEW, display a <br> to put a empty line above the Narrative button.
    if (!pageMode.equals(PageModeConstants.VIEW) && !sDisableField) {
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<%if(btnDeleteDisplay){ %>
					<td class="alignLeft">
						<impact:ButtonTag name="btnDelete" img="btnDelete" align="right"
							form="frmCaseReview"
							action="/casemgmt/CaseReview/deleteCaseReview"
							align="left" tabIndex="<%=tabIndex++%>" />
					</td>
			    <%} else {%>
			    	<td>
						&nbsp;
					</td>
			    <%}%>
			   <td>
			    <table border="0" cellpadding="3" cellspacing="0" width="100%">
		          <tr>
					<td align="right" width="85%">
						<impact:validateInput name="cbxComplete" tabIndex="<%=tabIndex++%>"
							label="Review Complete" type="checkbox" checked="<%=isComplete%>" 
							disabled="<%=String.valueOf(sDisableField)%>" />
					</td>
					<td>
						<impact:ButtonTag name="btnSave" img="btnSave" align="right"
							form="frmCaseReview" action="/casemgmt/CaseReview/saveCaseReview"
							restrictRepost="true" preventDoubleClick="true" 
							disabled="<%=String.valueOf(sDisableField)%>" 
							function="return savePageAdd();"
							tabIndex="<%=tabIndex++%>" />
					</td>
					<td class="alignRight">
	                      <impact:spellCheck
	                        formToSpellCheck="frmCaseReview"
	                        fieldsToSpellCheck="<%= fieldsToCheck %>"
	                        tabIndex="<%= tabIndex++ %>"
	                      />
	                </td>
			      </tr>
			    </table>
		      </td>
		</tr>
	</table>
<%
  //Display the Save button when Date Correction Completed is enabled
  } if (!sdisableSaveButton) {
%>
  	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
		<td align="right">
				<impact:ButtonTag name="btnSave" img="btnSave" align="right"
					form="frmCaseReview" action="/casemgmt/CaseReview/saveCaseReview"
					preventDoubleClick="true" 
					disabled="<%=String.valueOf(sdisableSaveButton)%>" 
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
<%} //Display the delete button for the user with the DELETE_CASE_REVIEW security attribute
    //STGAP00015183: Display delete button for NEW status also
   if(btnDeleteDisplayForSecAttr && ((EVENT_STATUS_PROC.equals(eventDetails.getSzCdEventStatus())&& !btnDeleteDisplay)
                                   || EVENT_STATUS_NEW.equals(eventDetails.getSzCdEventStatus()))){%>
  	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
		    <td class="alignLeft">
				<impact:ButtonTag name="btnDelete" img="btnDelete" align="right"
					form="frmCaseReview"
					action="/casemgmt/CaseReview/deleteCaseReview"
					align="left" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
<%} %>

<%--  Always include this hidden field in your form --%>
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<%-- Close Validate Form Custom Tag --%>
</impact:validateForm>
<br>

<%
    //*****************
    //****  Form   ****
    //*****************
 %>
 <%
  String FROM_DATE = FormattingHelper.formatDate( DateHelper.MIN_CASTOR_DATE );
  String TO_DATE = FormattingHelper.formatDate( new Date() );
%>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Form Launch</th>
  </tr>
  <tr>
    <td>
      <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
        <impact:document displayName="Log of Contact Narratives"
                         protectDocument="true"
                         checkForNewMode="false"
                         docType="CFSD0700"
                         docExists="true">
          <impact:documentParameter name="pStage"
                                    value='<%= FormattingHelper.formatInt( ulIdStage ) %>'/>
          <impact:documentParameter name="pDtSampleFrom" value="<%=FROM_DATE%>"/>
          <impact:documentParameter name="pDtSampleTo" value="<%=TO_DATE%>"/>
       </impact:document>      
     </impact:documentList>  
    </td>
  </tr>
</table>

<%
    //*****************
    //**** Reports ****
    //*****************
 %>
<%-- START - CODE FOR REPORTS MODULE --%>      
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
                        reportName="PlacementLog00">      
           <impact:reportParameter value='<%= GlobalData.getUlIdStageAsString(request)%>'/>           
         </impact:report>      
       </impact:reportList>      
     </td>      
   </tr>      
   </table>      

<%-- END --%>  
