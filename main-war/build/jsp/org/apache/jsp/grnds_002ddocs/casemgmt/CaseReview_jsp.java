package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewQuestionsSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.casemgmt.CaseReviewConversation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import org.apache.commons.lang.StringUtils;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewCbxQuestionsSO;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;

public final class CaseReview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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
 
      out.write("\r\n  \t");
      out.write("\r\n\t<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\t");
      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n\t<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n  \r\n  function savePageAdd()\r\n  {\r\n    if (document.frmCaseReview.cbxComplete.checked == true){\r\n      if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CSR_CFRM_COMP));
      out.write("') == true){\r\n         return true;\r\n      }\r\n    }else{\r\n      return true;\r\n    }  \r\n  }\r\n  \r\n  function disableMainQues(mainQuesName, fieldName, quesType){\r\n   if(quesType == \"D\"){ \r\n    var decisionQues = eval(\"document.getElementsByName(\\\"\" + fieldName + \"\\\")\");\r\n    var mainQues = eval(\"document.getElementsByName(\\\"\" + mainQuesName + \"\\\")\");\r\n    if(decisionQues[1].checked == true){\r\n     if(mainQues.length > 0){\r\n      mainQues[1].checked = true;\r\n      mainQues[0].disabled = true;\r\n      mainQues[1].disabled = true;\r\n      mainQues[2].disabled = true;\r\n     }\r\n      document.frmCaseReview.isMainDisabled.value = \"true\";\r\n    }\r\n   }\r\n  }\r\n  ");
 out.println("var myArray = [];"); 
     int startIndex = 0;
     int endIndex = 0;
      out.write("\r\n  function enableMainQues(mainQuesName, startIndex, endIndex, quesType){\r\n    var startIndexInt = parseInt(startIndex) ;\r\n    var endIndexInt = parseInt(endIndex) ;\r\n    if(quesType == \"D\"){\r\n     var isDecisionNo = false;\r\n     for(var i=startIndexInt; i < endIndexInt; i++){\r\n      var mainQues = eval(\"document.getElementsByName(\\\"\" + mainQuesName + \"\\\")\");\r\n      var decisionQues = eval(\"document.getElementsByName(\\\"\" + myArray[i] + \"\\\")\");\r\n      \r\n      if(decisionQues[1].checked == true){\r\n        isDecisionNo = true;\r\n        break; \r\n      }\r\n    }\r\n    if(isDecisionNo == false){\r\n     if(mainQues.length > 0){\r\n      mainQues[1].checked = false;\r\n      mainQues[0].disabled = false;\r\n      mainQues[1].disabled = false;\r\n      mainQues[2].disabled = false;\r\n     }\r\n      document.frmCaseReview.isMainDisabled.value = \"false\";\r\n    }else{\r\n      document.frmCaseReview.isMainDisabled.value = \"true\";\r\n    }  \r\n   }\r\n  }\r\n  \r\n  window.onload = function ()\r\n  {\r\n   ");
  
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
      
      out.write("\r\n      ");
 if(currentQuesItemType != null && currentQuesItemType.equals(mainQuesItemType)){
      out.write("\r\n          ");
      out.print( disableMainInner );
      out.write("\r\n      ");
}
      }
     }
   }
      out.write("\r\n }\r\n  \r\n\r\n</script>\r\n");

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

      out.write("\r\n\r\n\r\n");

//**************************
//**** FORM STARTS HERE ****
//**************************

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseReview");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/casemgmt/CaseReview/saveCaseReview");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.casemgmt.CaseReviewCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_0.setValue(tsLastUpdate);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("crTsLastUpdate");
          _jspx_th_impact_validateInput_1.setValue(crTsLastUpdate);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("isMainDisabled");
          _jspx_th_impact_validateInput_2.setValue(isMainDisabled);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"#\" onClick=\"expandAll();\">Expand\r\n\t\t\t\t\tAll</a>\r\n\t\t\t\t<a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"#\" onClick=\"collapseAll();\">Collapse\r\n\t\t\t\t\tAll</a>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
  //----------------------------------------------
        //--- DISPLAY THE Review Information SECTION ---
        //---------------------------------------------- 
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"12\">\r\n\t\t\t\tReview Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("szNmReviewer");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Reviewed by(Name and Position)");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(caseReviewRetrieveSO.getNmReviewer()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("idCase");
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Case ID");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatInt(caseReviewRetrieveSO.getIdCase()) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("szNmCase");
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Case Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString(caseReviewRetrieveSO.getNmCase()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("szNmCaseWorker");
          _jspx_th_impact_validateDisplayOnlyField_3.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Case Worker");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatString(caseReviewRetrieveSO.getNmCaseWorker() ));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("szCdRegion");
          _jspx_th_impact_validateDisplayOnlyField_4.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Region");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatString(caseReviewRetrieveSO.getCdRegion()) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("szCdCounty");
          _jspx_th_impact_validateDisplayOnlyField_5.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatString(caseReviewRetrieveSO.getCdCounty()) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("reviewPeriod");
          _jspx_th_impact_validateDisplayOnlyField_6.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Review Period");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatString(caseReviewRetrieveSO.getReviewPeriod()) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dtDtCaseOpened");
          _jspx_th_impact_validateDisplayOnlyField_7.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Open Date");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatDate(caseReviewRetrieveSO.getDtStageOpened()) );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("dtDtReview");
          _jspx_th_impact_validateDisplayOnlyField_8.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Date Review Began");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatDate(caseReviewRetrieveSO.getDtReview()) );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("szCdCaseProgram");
          _jspx_th_impact_validateDisplayOnlyField_9.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Case Program");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(FormattingHelper.formatString(caseReviewRetrieveSO.getCdCaseProgram()) );
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n            <td colspan=\"3\" nowrap>\r\n              ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Review Type");
          _jspx_th_impact_validateSelect_0.setName("selReviewType");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setDisabled( Boolean.toString(sDisableField || sdisableReviewType));
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCSRTYPE");
          _jspx_th_impact_validateSelect_0.setValue(cdReviewType );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeOptions);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("dtDtReviewComplete");
          _jspx_th_impact_validateDisplayOnlyField_10.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Date Review Completed");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(FormattingHelper.formatDate(caseReviewRetrieveSO.getDtReviewComplete()) );
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n \t\t</tr>\r\n\t</table>\r\n\t\r\n");

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

          out.write("\r\n\t<br>\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdCategory());
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzTxtCategory());
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setAnchor(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdCategory());
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n\t\t");

          // Display the header for this Category's first Item.
        
              out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"\r\n\t\t\tclass=\"tableBorderExpand\">\r\n\t\t\t<tr class=\"thList\">\r\n\t\t\t\t<th>\r\n\t\t\t\t\t<a name=\"");
              out.print(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem());
              out.write("\"></a>\r\n\t\t\t\t\t");
              out.print(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzTxtItem());
              out.write("\r\n\t\t\t\t</th>\r\n\t\t    </tr>\r\n\t\t\t\t");
if("WLLIT3".equals(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem())){
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
                     
                 
              out.write("\r\n              <tr>\r\n                 <td colspan=\"12\">\r\n\t\t\t\t   ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_1.setName("ContactLog");
              _jspx_th_impact_ExpandableSectionTag_1.setId("");
              _jspx_th_impact_ExpandableSectionTag_1.setLabel("Contact Log");
              _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
              _jspx_th_impact_ExpandableSectionTag_1.setAnchor(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem());
              int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                      <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>       \r\n                      <div id=\"horizontalScrollResults\" style=\"width:740px; height:210px; overflow:auto\" class=\"tableborderList\">\r\n                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n                         <tr>\r\n                           <td>\r\n                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"1200\">\r\n                              <tr class=\"thList\">\r\n                                <th class=\"thList\">Name</th>\r\n                                <th class=\"thList\">Relationship</th>\r\n                                ");
 for(int i = 0; i<6 ; i++){ 
                  out.write("\r\n                                  <th class=\"thList\">");
                  out.print(pastSixMonths.get(i));
                  out.write("</th>\r\n                                ");
 } 
                  out.write("\r\n                              </tr>\r\n                             ");
  int contactCount = 1; 
                                 if (contactSummaryList != null && !contactSummaryList.isEmpty()) {
                                  Iterator<Map<String,Object>> itcontactSummaryList = contactSummaryList.iterator();
                                  while (itcontactSummaryList.hasNext()) {
                                    Map<String,Object> map = itcontactSummaryList.next(); 
                                    String tableRowClassContact = FormattingHelper.getRowCss(contactCount++);
                  out.write("\r\n                                    <tr class=\"");
                  out.print(tableRowClassContact);
                  out.write("\">\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("nmPersonFull")));
                  out.write("</td>\r\n                                      <td>");
                  out.print( Lookup.simpleDecodeSafe( "CRPTRINT", (String) map.get("cdStagePersRelInt")));
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month1"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month2"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month3"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month4"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month5"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month6"))  );
                  out.write("</td>\r\n                                   </tr>\r\n                                 ");

                                  }//While
                                 }//If 
                  out.write("\r\n                            </table>\r\n                          </td>\r\n                         </tr>\r\n                       </table>\r\n                     </div>\r\n                   ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n             </tr>\r\n\t\t\t\t");
 } 
              out.write("\r\n\r\n\r\n\t\t\t");

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
             
              out.write("\r\n\t\t\t<tr class=\"");
              out.print(tableRowClass);
              out.write("\">\r\n\t\t\t");

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
             
              out.write("\r\n             ");

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
             
              out.write("\r\n\t\t        <td ");
              out.print(textQuesColor );
              out.write(" title=\"");
              out.print(currentQuestion.getTxtQuesHelp());
              out.write("\" >\r\n\t\t\t        ");
 
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
 			        
              out.write("\r\n \t\t\t        ");
if(exclamationMark && "D".equals(currentQuestion.getIndQuestionType())){
              out.write("\r\n \t\t\t           <b style=\"color: red; font-size: 16;\" >!</b> ");
              out.print(currentQuestion.getTxtQuestionNum());
              out.print(txtQuestion);
              out.write("\r\n \t\t\t        ");
}else if("M".equals(currentQuestion.getIndQuestionType())){ 
              out.write("\r\n \t\t\t           <b style=\"font-size: 14;\">");
              out.print(currentQuestion.getTxtQuestionNum());
              out.print(txtQuestion);
              out.write("</b>\r\n \t\t\t        ");
}else{
              out.write("\t\r\n \t\t\t           ");
              out.print(currentQuestion.getTxtQuestionNum());
              out.print(txtQuestion);
              out.write("\r\n \t\t\t         ");
} 
              out.write("\t\t\t\t\r\n\t\t\t\t\t");
 // If the question has checkboxes display them
					   if(ArchitectureConstants.Y.equals(currentQuestion.getIndCbx())){
					    List<String> checkedCheckboxesList = new ArrayList<String>();
					    if(currentQuestion.getCheckedCheckboxes() != null){
					       checkedCheckboxesList = Arrays.asList(currentQuestion.getCheckedCheckboxes());
					    }

              out.write("\r\n\t\t\t\t\t    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n                            <tr>\r\n                                <td>\r\n                                   ");
              //  impact:castorCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
              _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_castorCheckbox_0.setCastorEnum( Collections.enumeration(currentQuestion.getCaseReviewCbxQuestionsList()) );
              _jspx_th_impact_castorCheckbox_0.setName("chkQuestion");
              _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("Code");
              _jspx_th_impact_castorCheckbox_0.setValuePropertyName("Decode");
              _jspx_th_impact_castorCheckbox_0.setCheckedValues( checkedCheckboxesList );
              _jspx_th_impact_castorCheckbox_0.setDisabled(String.valueOf(sDisableField));
              _jspx_th_impact_castorCheckbox_0.setColumns(2);
              _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
              _jspx_th_impact_castorCheckbox_0.setIsHorizontal(false);
              _jspx_th_impact_castorCheckbox_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
              if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                                </td>\r\n                           </tr>\r\n                      </table>\r\n\t\t\t\t   ");
} 
              out.write("\r\n\t\t\t    </td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setChecked(yIsChecked);
              _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_3.setValue("0");
              _jspx_th_impact_validateInput_3.setName(fieldName);
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              _jspx_th_impact_validateInput_3.setDisabled(String.valueOf(sDisableField || mainQuesDisabled));
              _jspx_th_impact_validateInput_3.setOnClick(enableMain);
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>Yes</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setType("radio");
              _jspx_th_impact_validateInput_4.setChecked(nIsChecked);
              _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_4.setValue("1");
              _jspx_th_impact_validateInput_4.setName(fieldName);
              _jspx_th_impact_validateInput_4.setCssClass("formInput");
              _jspx_th_impact_validateInput_4.setDisabled(String.valueOf(sDisableField || mainQuesDisabled));
              _jspx_th_impact_validateInput_4.setOnClick(disableMain);
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>No</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("radio");
              _jspx_th_impact_validateInput_5.setChecked(uIsChecked);
              _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_5.setValue("2");
              _jspx_th_impact_validateInput_5.setName(fieldName);
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              _jspx_th_impact_validateInput_5.setDisabled(String.valueOf(sDisableField || mainQuesDisabled));
              _jspx_th_impact_validateInput_5.setOnClick(enableMain);
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>N/A</td>\r\n\t\t\t</tr>\r\n\r\n\t\t");

         // If a new Item will start in the next iteration of the loop,
        // then display the Item header here.
        if (nextQuestion != null && !currentQuestion.getSzCdItem().equals(nextQuestion.getSzCdItem())) {
          loopCounter = 1;
          exclamationMark = false;
        
              out.write("\r\n           <tr class=\"");
              out.print(tableRowClassNext);
              out.write("\">\r\n              <td colspan=\"12\">\r\n                 <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n                  <tr>\r\n                     <td> \r\n                        ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_0.setLabel("Comments");
              _jspx_th_impact_validateTextArea_0.setName( "txt" + currentQuestion.getSzCdItem() + "comments" );
              _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph4000");
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_0.setDisabled(String.valueOf(sDisableField));
              _jspx_th_impact_validateTextArea_0.setCols("100");
              _jspx_th_impact_validateTextArea_0.setRows("5");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(currentQuestion.getTxtComments()));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                     </td>\r\n                     ");
 if("".equals(fieldsToCheck)){ //SMS#38872 Spell Check text boxes
                          fieldsToCheck = "txt" + currentQuestion.getSzCdItem() + "comments";
                        }else{
                          fieldsToCheck = fieldsToCheck + ", " + "txt" + currentQuestion.getSzCdItem() + "comments";
                        }
              out.write("\r\n                   </tr>\r\n                 </table>\r\n              </td>\r\n            </tr>\r\n \t\t\t<tr class=\"thList\">\r\n\t\t\t\t<th>\r\n\t\t\t\t\t<a name=\"");
              out.print(nextQuestion.getSzCdItem());
              out.write("\"></a>\r\n\t\t\t\t\t");
              out.print(nextQuestion.getSzTxtItem());
              out.write("\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n            ");
if("WLLIT3".equals(nextQuestion.getSzCdItem())){
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
                     
                 
              out.write("\r\n              <tr>\r\n                 <td colspan=\"12\">\r\n\t\t\t\t   ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_2.setName("ContactLog");
              _jspx_th_impact_ExpandableSectionTag_2.setId("");
              _jspx_th_impact_ExpandableSectionTag_2.setLabel("Contact Log");
              _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
              _jspx_th_impact_ExpandableSectionTag_2.setAnchor(((CaseReviewQuestionsSO) questionsInSameCategory.get(0)).getSzCdItem());
              int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                      <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>       \r\n                      <div id=\"horizontalScrollResults\" style=\"width:740px; height:210px; overflow:auto\" class=\"tableborderList\">\r\n                      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n                         <tr>\r\n                           <td>\r\n                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"1200\">\r\n                              <tr class=\"thList\">\r\n                                <th class=\"thList\">Name</th>\r\n                                <th class=\"thList\">Relationship</th>\r\n                                ");
 for(int i = 0; i<6 ; i++){ 
                  out.write("\r\n                                  <th class=\"thList\">");
                  out.print(pastSixMonths.get(i));
                  out.write("</th>\r\n                                ");
 } 
                  out.write("\r\n                              </tr>\r\n                             ");
  int contactCount = 1; 
                                 if (contactSummaryList != null && !contactSummaryList.isEmpty()) {
                                  Iterator<Map<String,Object>> itcontactSummaryList = contactSummaryList.iterator();
                                  while (itcontactSummaryList.hasNext()) {
                                    Map<String,Object> map = itcontactSummaryList.next(); 
                                    String tableRowClassContact = FormattingHelper.getRowCss(contactCount++);
                  out.write("\r\n                                    <tr class=\"");
                  out.print(tableRowClassContact);
                  out.write("\">\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("nmPersonFull")) );
                  out.write("</td>\r\n                                      <td>");
                  out.print( Lookup.simpleDecodeSafe( "CRPTRINT", (String) map.get("cdStagePersRelInt")));
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month1"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month2"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month3"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month4"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month5"))  );
                  out.write("</td>\r\n                                      <td>");
                  out.print( FormattingHelper.formatString((String) map.get("Month6"))  );
                  out.write("</td>\r\n                                   </tr>\r\n                                 ");

                                  }//While
                                 }//If 
                  out.write("\r\n                            </table>\r\n                          </td>\r\n                         </tr>\r\n                       </table>\r\n                     </div>\r\n                   ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n             </tr>\r\n\t\t\t\t");
 } 
              out.write("\r\n\r\n\t\t\t");

         }// end if 
              out.write("\r\n     ");
 }// end for
       // Each iteration through the parent loop will create a new Category
       // expandable section. End the expandable section here.
       String tableRowClass = FormattingHelper.getRowCss(loopCounter);
    
              out.write("\r\n           <tr class=\"");
              out.print(tableRowClass);
              out.write("\">\r\n              <td colspan=\"12\">\r\n                 <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n                  <tr>\r\n                     <td> \r\n                        ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setName( "txt" + currentQuestion.getSzCdItem() + "comments" );
              _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph4000");
              _jspx_th_impact_validateTextArea_1.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_1.setDisabled(String.valueOf(sDisableField));
              _jspx_th_impact_validateTextArea_1.setCols("100");
              _jspx_th_impact_validateTextArea_1.setRows("5");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(currentQuestion.getTxtComments()));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                     </td>\r\n                     ");
 fieldsToCheck = fieldsToCheck + ", " + "txt" + currentQuestion.getSzCdItem() + "comments"; 
              out.write("\r\n                   </tr>\r\n                 </table>\r\n              </td>\r\n            </tr>\r\n    </table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }//end for

          out.write("\r\n<br>\r\n");

   //-------------------------------
   //DISPLAY  THE Summary SECTION
   //-------------------------------
 
          out.write('\r');
          out.write('\n');
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"16\">\r\n\t\t\t\tSummary\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<tr>\r\n\t\t  <td colspan=\"16\">\r\n            <table border=\"0\" cellspacing=\"3\" cellpadding=\"3\" width=\"100%\">\r\n              <tr valign=\"top\">\r\n\t\t\t\t   <td width=\"33%\">\r\n\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtStaffedWithWorker");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setLabel("Date Staffed With Worker");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(caseReviewRetrieveSO.getDtStaffedWithWorker()));
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t   </td>\r\n\t\t\t       <td width=\"33%\">\r\n\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtCorrectionsDue");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setLabel("Date Corrections Due");
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(caseReviewRetrieveSO.getDtCorrectionDue()));
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t   </td>\t\r\n\t\t\t\t   <td width=\"33%\">\r\n\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("dtCorrectionsComplete");
          _jspx_th_impact_validateDate_2.setDisabled("false");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setLabel("Date Corrections Completed");
          _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(caseReviewRetrieveSO.getDtCorrectionComplete()));
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setDisabled(String.valueOf(sdisableDtCorrectionComplete));
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t   </td>\r\n\t\t      </tr>\r\n\t\t    </table>\r\n\t\t  </td>\r\n\t\t </tr> \r\n\t\t<tr>\r\n            <td colspan=\"16\"> \r\n               <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n                  <tr>\r\n                     <td> \r\n                        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setLabel("Feedback");
          _jspx_th_impact_validateTextArea_2.setName( "txtSummaryComment" );
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_2.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_2.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateTextArea_2.setCols("100");
          _jspx_th_impact_validateTextArea_2.setRows("5");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.print( FormattingHelper.formatString(caseReviewRetrieveSO.getTxtSummaryComment()));
              out.write("\r\n                        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                     </td>\r\n                     ");
fieldsToCheck = fieldsToCheck + ", " + "txtSummaryComment"; 
          out.write("\r\n                   </tr>\r\n               </table>\r\n            </td>\r\n \t\t</tr>\r\n\t</table>\r\n<br>\r\n");

    //*****************
    //**** BUTTONS ****
    //*****************
    // Display the Complete and Save buttons unless the page mode is VIEW. If page
    // mode is VIEW, display a <br> to put a empty line above the Narrative button.
    if (!pageMode.equals(PageModeConstants.VIEW) && !sDisableField) {

          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t");
if(btnDeleteDisplay){ 
          out.write("\r\n\t\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseReview");
          _jspx_th_impact_ButtonTag_0.setAction("/casemgmt/CaseReview/deleteCaseReview");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t    ");
} else {
          out.write("\r\n\t\t\t    \t<td>\r\n\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t</td>\r\n\t\t\t    ");
}
          out.write("\r\n\t\t\t   <td>\r\n\t\t\t    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t          <tr>\r\n\t\t\t\t\t<td align=\"right\" width=\"85%\">\r\n\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setName("cbxComplete");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setLabel("Review Complete");
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setChecked(isComplete);
          _jspx_th_impact_validateInput_6.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmCaseReview");
          _jspx_th_impact_ButtonTag_1.setAction("/casemgmt/CaseReview/saveCaseReview");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_ButtonTag_1.setFunction("return savePageAdd();");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td class=\"alignRight\">\r\n\t                      ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmCaseReview");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck( fieldsToCheck );
          _jspx_th_impact_spellCheck_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t                </td>\r\n\t\t\t      </tr>\r\n\t\t\t    </table>\r\n\t\t      </td>\r\n\t\t</tr>\r\n\t</table>\r\n");

  //Display the Save button when Date Correction Completed is enabled
  } if (!sdisableSaveButton) {

          out.write("\r\n  \t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmCaseReview");
          _jspx_th_impact_ButtonTag_2.setAction("/casemgmt/CaseReview/saveCaseReview");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setDisabled(String.valueOf(sdisableSaveButton));
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n");
} //Display the delete button for the user with the DELETE_CASE_REVIEW security attribute
    //STGAP00015183: Display delete button for NEW status also
   if(btnDeleteDisplayForSecAttr && ((EVENT_STATUS_PROC.equals(eventDetails.getSzCdEventStatus())&& !btnDeleteDisplay)
                                   || EVENT_STATUS_NEW.equals(eventDetails.getSzCdEventStatus()))){
          out.write("\r\n  \t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t    <td class=\"alignLeft\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnDelete");
          _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmCaseReview");
          _jspx_th_impact_ButtonTag_3.setAction("/casemgmt/CaseReview/deleteCaseReview");
          _jspx_th_impact_ButtonTag_3.setAlign("left");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n");
} 
          out.write("\r\n\r\n");
          out.write("\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br>\r\n\r\n");

    //*****************
    //****  Form   ****
    //*****************
 
      out.write('\r');
      out.write('\n');
      out.write(' ');

  String FROM_DATE = FormattingHelper.formatDate( DateHelper.MIN_CASTOR_DATE );
  String TO_DATE = FormattingHelper.formatDate( new Date() );

      out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Form Launch</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("2");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Log of Contact Narratives");
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("CFSD0700");
          _jspx_th_impact_document_0.setDocExists(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pStage");
              _jspx_th_impact_documentParameter_0.setValue( FormattingHelper.formatInt( ulIdStage ) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pDtSampleFrom");
              _jspx_th_impact_documentParameter_1.setValue(FROM_DATE);
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pDtSampleTo");
              _jspx_th_impact_documentParameter_2.setValue(TO_DATE);
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("      \r\n     ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("  \r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");

    //*****************
    //**** Reports ****
    //*****************
 
      out.write('\r');
      out.write('\n');
      out.write("      \r\n<br>      \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">      \r\n  <tr>      \r\n     <th colspan=\"4\">Reports</th>      \r\n   </tr>      \r\n   <tr>      \r\n     <td>      \r\n       ");
      //  impact:reportList
      gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag _jspx_th_impact_reportList_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag();
      _jspx_th_impact_reportList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_reportList_0.setParent(null);
      _jspx_th_impact_reportList_0.setPersonId( user.getUserID() );
      _jspx_th_impact_reportList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_reportList_0 = _jspx_th_impact_reportList_0.doStartTag();
      if (_jspx_eval_impact_reportList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("      \r\n         ");
          //  impact:report
          gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
          _jspx_th_impact_report_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_report_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
          _jspx_th_impact_report_0.setUseHiddenParameters(false);
          _jspx_th_impact_report_0.setReportName("PlacementLog00");
          int _jspx_eval_impact_report_0 = _jspx_th_impact_report_0.doStartTag();
          if (_jspx_eval_impact_report_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("      \r\n           ");
              //  impact:reportParameter
              gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
              _jspx_th_impact_reportParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_reportParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_0);
              _jspx_th_impact_reportParameter_0.setValue( GlobalData.getUlIdStageAsString(request));
              int _jspx_eval_impact_reportParameter_0 = _jspx_th_impact_reportParameter_0.doStartTag();
              if (_jspx_th_impact_reportParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("           \r\n         ");
              int evalDoAfterBody = _jspx_th_impact_report_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_report_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("      \r\n       ");
          int evalDoAfterBody = _jspx_th_impact_reportList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_reportList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("      \r\n     </td>      \r\n   </tr>      \r\n   </table>      \r\n\r\n");
      out.write("  \r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
