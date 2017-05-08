<%--
JSP Name:     Examination Detail
Created by:   Nandita Hegde
Date Created: 03/19/07


Description:
  This JSP is used to collect and display data about Examination Detail

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------

--%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.ExamDetailConversation" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<%
//*********************
//*** SET PAGE MODE ***
//*********************

  String pageMode = PageMode.getPageMode(request);

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
  int tabIndex = 1;
  String examDate = "";
  String examType = "";
  String score ="";
  String passed = "";
  String firstAttempt = "";
  String examTypeCat = "";
  String codesTable = "";
    
  
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
                                                                       
                                                     
  
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************   
  ExamDetailRetrieveSO examDetail = (ExamDetailRetrieveSO) state.getAttribute("ExamDetailRetrieveSO", request);
  String hdnExamType = (String) request.getParameter("hdnExamCat");
  String hdnExamId = (String) request.getParameter("hdnExamId");
  if(examDetail!=null) {
    if (ArchitectureConstants.Y.equals(examDetail.getIndGed())) {
      examTypeCat = ExamDetailConversation.GED_EXAM;
    } else if (ArchitectureConstants.N.equals(examDetail.getIndGed())) {
      examTypeCat = ExamDetailConversation.HS_EXAM;
    }
    if(examDetail.getCdExamType()!=null) {
      examType = examDetail.getCdExamType();
    }
    if(examDetail.getDtExam()!=null) {  
      examDate = FormattingHelper.formatDate(examDetail.getDtExam());
    }
    if(examDetail.getNbrScore()!= 0) {
      score = FormattingHelper.formatInt(examDetail.getNbrScore());
    }
    if(examDetail.getIndPassed()!= null) {
      passed = examDetail.getIndPassed();
    }
    if(examDetail.getIndFirstAtmpt()!= null) {
      firstAttempt = examDetail.getIndFirstAtmpt();
    }
  } else {
    examTypeCat = hdnExamType;
  }
  
                 
%>


<%

//**************************
//**** FORM STARTS HERE ****
//**************************
 %>

<impact:validateErrors />
<impact:validateForm name="frmExamDetail" method="post" action="/person/ExamDetail/displayExamDetail" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.ExamDetailCustomValidation" schema="/WEB-INF/Constraints.xsd">

  <% /*  Always include this hidden field in your form */ %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

  <%// Begin Detail

      %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="8" align="left">
        Examination
      </th>
    </tr>
    <tr></tr>
    <tr>
    <% if(ExamDetailConversation.GED_EXAM.equals(examTypeCat)) { 
         codesTable = CodesTables.CGED;
       } else {
         codesTable = CodesTables.CGRAD;
       }
    %>
      <td colspan="1">
        <impact:validateSelect 
           tabIndex="<%= tabIndex++ %>" 
           label="Exam Type" 
           id="cdExamType" 
           name="cdExamType" 
           width="20%" 
           value="<%=examType %>" 
           required="true" 
           codesTable="<%=codesTable %>"  />
      </td>
        
      <td colspan="1">
        <impact:validateDate
           label="Date Of Exam"
           name="dtExam"
           value="<%=examDate%>"
           required="true"
           constraint="Date"
           width="20%"
           tabIndex="<%= tabIndex++ %>"/>
      </td> 
      <td colspan="1">
        <impact:validateInput type="text" 
            label=" Score" 
            name="txtScore" 
            constraint="Digit3Less" 
            maxLength = "3"
            conditionallyRequired="true"
            value="<%=score %>" />
      </td>  
     </tr>   
     <tr>
      <td>
        <impact:validateInput 
          type="checkbox" 
          label="First Attempt" 
          checked="<%= (("".equals(firstAttempt)) || (ArchitectureConstants.N.equals(firstAttempt))) ? "false" : "true" %>" 
          tabIndex="<%= tabIndex++ %>" 
          value="Y"
          name="cbxFirstAtmpt" 
          cssClass="formInput" />
      </td>
      <td></td>
     <td>
        <impact:validateInput 
            type="checkbox" 
            label="Passed" 
            checked="<%= (("".equals(passed)) || (ArchitectureConstants.N.equals(passed))) ? "false" : "true" %>" 
            tabIndex="<%= tabIndex++ %>" 
            value="Y"
            name="cbxPassed" 
            cssClass="formInput" />
        </td> 
       </tr>
  </table>

  <%//*****************
    //**** BUTTONS ****
    //*****************
    // Display the Save and delete buttons unless the page mode is VIEW.  %>

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td colspan="4">
        <br>
        <hr>
      </td>
    </tr>
    <tr>
    <% if (!PageModeConstants.VIEW.equals(pageMode)) {%>
      <td class="alignRight">
        <impact:ButtonTag 
           name="btnSave" 
           align="right" 
           img="btnSave" 
           form="frmExamDetail" 
           action="/person/ExamDetail/saveExamDetail" 
           restrictRepost="true" 
           preventDoubleClick="true" 
           tabIndex="<%= tabIndex++ %>" />
      </td>
    <%}%>
    </tr>
  </table>
  <br>
</impact:validateForm>



