<%--
//*  JSP Name: CollegeEntranceExamDetail.jsp
//*  Created by:   Steven Thrasher
//*  Date Created: 4/17/2007
//*
//*  Description:
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamRetrieveSO"%>
<%//*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
boolean approvalStatus = false;
BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
UserProfile user = UserProfileHelper.getUserProfile(request);
String cdExamType = FormattingHelper.formatString("");
String hdnPersonId = FormattingHelper.formatString("");
int tabIndex = 1;
String dtActTestTaken= "";
String nbrActEnglishScore= "";
String nbrActMathScore= "";
String nbrActReadingScore = "";
String nbrActScienceScore = "";
String nbrActWritingScore = "";
String nbrActTotalScore = "";
String dtSatTestTaken = "";
String nbrSatMathScore= "";
String nbrSatVerbalScore= "";
String nbrSatWritingScore= "";
String nbrSatTotalScore= "";
String hdnIdCollegeExam = "";


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
CollegeEntranceExamRetrieveSO collegeExam = null;
collegeExam = (CollegeEntranceExamRetrieveSO) state.getAttribute("RETRIEVESO", request);

String pageMode = PageMode.getPageMode(request);

if (collegeExam != null) {
  cdExamType = collegeExam.getCdExamType();
  hdnPersonId = FormattingHelper.formatInt(collegeExam.getIdPerson());
  hdnIdCollegeExam = FormattingHelper.formatInt(collegeExam.getIdCollegeExam());
  
  if("ACT".equals(cdExamType)){  
    dtActTestTaken = FormattingHelper.formatDate(collegeExam.getDtTestTaken());
	nbrActEnglishScore = FormattingHelper.formatInt(collegeExam.getNbrEnglishScore());
	nbrActMathScore = FormattingHelper.formatInt(collegeExam.getNbrMathScore());
	nbrActReadingScore = FormattingHelper.formatInt(collegeExam.getNbrReadingScore());
	nbrActScienceScore = FormattingHelper.formatInt(collegeExam.getNbrScienceScore());
	nbrActWritingScore = FormattingHelper.formatInt(collegeExam.getNbrWritingScore());
	nbrActTotalScore = FormattingHelper.formatInt(collegeExam.getNbrTotalScore());
  } else if ("SAT".equals(cdExamType)){
    dtSatTestTaken = FormattingHelper.formatDate(collegeExam.getDtTestTaken());
	nbrSatMathScore = FormattingHelper.formatInt(collegeExam.getNbrMathScore());
	nbrSatVerbalScore = FormattingHelper.formatInt(collegeExam.getNbrVerbalScore());
	nbrSatWritingScore = FormattingHelper.formatInt(collegeExam.getNbrWritingScore());
	nbrSatTotalScore = FormattingHelper.formatInt(collegeExam.getNbrTotalScore());
  }
} 

hdnPersonId = FormattingHelper.formatInt(GlobalData.getUlIdPerson(request));

    
    
    
//****************** 
//*** JAVASCRIPT ***
//******************

%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.onbeforeunload = function ()
{
  IsDirty();
};

</script>
<%//*************************
  //*** VALIDATION ERRORS ***
  //*************************
%>
<impact:validateErrors />
<%
      //********************************************
      //**** FORM (Payment of Care) STARTS HERE ****
      //********************************************

      %>
<impact:validateForm 
  name="frmCollegeEntranceExam" 
  method="post" 
  action="person/CollegeEntranceExam/displayCollegeExam" 
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.CollegeEntranceExamCustomValidation" 
  pageMode="<%= pageMode %>" 
  schema="/WEB-INF/Constraints.xsd">
	
	
<input type="hidden" name="hdnPersonId" value="<%=hdnPersonId%>">
<input type="hidden" name="hdnIdCollegeExam" value="<%=hdnIdCollegeExam%>">

<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
<tr><th colspan="4">ACT Test</th></tr>

    <tr>
         <td>
            <impact:validateDate
                label="Test Taken"
                name="dtActTestTaken"
                type="text"
                value="<%= dtActTestTaken %>"
                size="10"
                conditionallyRequired="true"
                tabIndex="<%= tabIndex++ %>"
                constraint="Date"/>
          </td>
    </tr>
    <tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="English Score" 
			  name="nbrActEnglishScore" 
			  value="<%= nbrActEnglishScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Math Score" 
			  name="nbrActMathScore" 
			  value="<%= nbrActMathScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Reading Score" 
			  name="nbrActReadingScore" 
			  value="<%= nbrActReadingScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Science Score" 
			  name="nbrActScienceScore" 
			  value="<%= nbrActScienceScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Writing Score" 
			  name="nbrActWritingScore" 
			  value="<%= nbrActWritingScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Total Score" 
			  name="nbrActTotalScore" 
			  value="<%= nbrActTotalScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
<tr><th colspan="4" class="tableBorder">SAT Test</th></tr>
	<tr>
         <td>
            <impact:validateDate
                label="Test Taken"
                name="dtSatTestTaken"
                type="text"
                value="<%= dtSatTestTaken %>"
                size="10"
                conditionallyRequired="true"
                tabIndex="<%= tabIndex++ %>"
                constraint="Date"/>
          </td>
    </tr>
    <tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Math Score" 
			  name="nbrSatMathScore" 
			  value="<%= nbrSatMathScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Verbal Score" 
			  name="nbrSatVerbalScore" 
			  value="<%= nbrSatVerbalScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Writing Score" 
			  name="nbrSatWritingScore" 
			  value="<%= nbrSatWritingScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
	<tr>
        <td>
			<impact:validateInput 
			  type="text" 
			  label="Total Score" 
			  name="nbrSatTotalScore" 
			  value="<%= nbrSatTotalScore %>" 
			  tabIndex="<%= tabIndex++ %>" 
			  maxLength="6" 
			  size="10" />
		</td>
	</tr>
</table>	
<%
//*****************
//**** BUTTONS ****
//*****************
%>
<hr>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
	<tr>
	  <td class="alignRight">
		<impact:ButtonTag 
		  name="btnSave" 
		  img="btnSave"
		  align="right" 
		  restrictRepost="true" 
		  form="frmCollegeEntranceExam" 
		  action="/person/CollegeEntranceExam/saveCollegeEntranceExam" 
		  preventDoubleClick="true" 
		  tabIndex="<%= tabIndex++ %>" />
      </td>
	</tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>