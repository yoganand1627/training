<%--
JSP Name:     Youth Detail
Created by:   Hong-Van Vo
Date Created: 01/12/2007

Description: This page records detail about a child's education background and other skills acquired 
             to prepare for independent living transition when a child is reaching 14.
             Page has 5 sections: General Information, School and GED Information, Post Secondary Education, 
             Youth Report List and NYTD User Information.


Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
10/15/2008 hanguyen         STGAP00010605 Modify GED Program Name field to limit
                            field maxlength to 20 characters
12/5/2008  charden		    STGAP00010609                    
08/17/2010 wjcochran        SMS #44630: Fixed radio buttons for "Life Skill Training Received",
                            "Employment Services Received", and "Health Services Received". Due to
                            a copy/paste error, these radio buttons were all linked together.   
08/18/2010 schoi            SMS #66384: MR-067 Updated code to display the NYTD User Information section
                            as the last expandable section only if the person is a NYTD User                                                     
08/21/2010 schoi			SMS #66384: MR-067 Updated code to hide Add button to all users 
							including ILP Coordinators   
09/23/2010 schoi			SMS #66384: MR-067 Separated the Add button hide logic for adding Youth Report
							from existing code							                       
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.YouthDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamSummary"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportSummary" %>
<%@ page import="java.util.Iterator"%>
<%
  // Conversation handles page mode logic
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  int loopCount = 0;
  boolean yesIsChecked = false;
  boolean noIsChecked = false;
  boolean isChecked = false;
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  YouthDetailRetrieveSO youthDetailRetrieveSO = (YouthDetailRetrieveSO) state.getAttribute("YOUTH_DETAIL", request);
  if (youthDetailRetrieveSO == null) { // case retrieve service returns null when no youth detail exists for this person
    youthDetailRetrieveSO = new YouthDetailRetrieveSO();
  } 
  
  // SMS #66384: MR-067 Set a flag for NYTD User
  boolean isNytdUser = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndNytdUser()); 
  
  String zip = youthDetailRetrieveSO.getTxtGEDProgZipCode();
  String zipSuff = "";
  if (StringHelper.isValid(zip) && zip.indexOf('-') > 0) {
    zipSuff = zip.substring(zip.indexOf('-')+1);
  }
 
  // Get the user profile, if needed.
  //UserProfile user = UserProfileHelper.getUserProfile(request);

  // Non YDP coordinator can't add new report if the latest report is current
  // YDP Coordinator has SEC_REGIONAL_SS_STF attribute
  boolean bAddReportButtonHide = false;
  if (!DateHelper.isNull(youthDetailRetrieveSO.getDtCurrRptPeriod())) {
    bAddReportButtonHide = DateHelper.isAfterToday(youthDetailRetrieveSO.getDtCurrRptPeriod()) && !YouthDetailConversation.isUserYDPCoordinator(request);
  }
  // = DateHelper.isAfterToday(youthDetailRetrieveSO.getDtCurrRptPeriod()) && !user.hasRight(UserProfile.SEC_ADO_VIEW);

  // SMS #66384: MR-067 
  // All users including ILP Coordinator(YDP Coordinator) cannot add new Youth Report if the latest Report is in the current reporting period
  // per NYTD survey. Previously, ILP Coordinator(YDP Coordinator) had ability to add multiple Youth Report per reporing period.
  boolean bAddYouthReportButtonHide = false;
  if (!DateHelper.isNull(youthDetailRetrieveSO.getDtCurrRptPeriod())) {
    bAddYouthReportButtonHide = DateHelper.isAfterToday(youthDetailRetrieveSO.getDtCurrRptPeriod());
  }
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty(); 
  };

  // Custom function to handle submitting the form via links in exam list, for both Highschool and GED exams
  function displayExamDetailPage(counter, linkValue, examType)
  {
    //var dtNextReviewField = eval(document.getElementById("dtNextReview_Id"));
    document.frmYouthDetail.hdnExamCat.value = examType;
    document.frmYouthDetail.hdnExamId.value = linkValue;
    disableValidation( 'frmYouthDetail' );
    submitValidateForm('frmYouthDetail', '/person/ExamDetail/displayExamDetail');
  }
  
  // Custom function to handle submitting the form via links in College Entrance Exam list
  function displayCeExamDetailPage(counter, linkValue)
  {
    document.frmYouthDetail.hdnCeExamId.value = linkValue;
    disableValidation( 'frmYouthDetail' );
    submitValidateForm('frmYouthDetail', '/person/CollegeEntranceExam/displayCollegeEntranceExam'); 
  }
  
  // Custom function to handle submitting the form via links in Youth Report list
  function displayYouthReportDetailPage(counter, linkValue)
  {
    document.frmYouthDetail.hdnReportId.value = linkValue;
    disableValidation( 'frmYouthDetail' );
    submitValidateForm('frmYouthDetail', '/person/YouthReportDetail/displayReportDetail');
  }
  
  // functions to set the value for exam type: Highschool or GED so Exam Detail page can load appropriate codes table 
  function setHsExamCat() {
    document.frmYouthDetail.hdnExamCat.value='HS';
    disableValidation( 'frmYouthDetail' );
    return true;
  }
  function setGedExamCat() {
    document.frmYouthDetail.hdnExamCat.value='GED';
    disableValidation( 'frmYouthDetail' );
    return true;
  }

</script>
<%-- Include custom tag for displaying errors on the page --%>
<impact:validateErrors/>
<%-- Start the form - See the Form Validation Cookbook or Custom Tag list for details
       on the attributes of the validateForm tag --%>
<impact:validateForm name="frmYouthDetail" method="post" action="/person/YouthDetail/saveYouthDetail"
                     pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.YouthDetailCustomValidation">
<%-- Include any hidden fields needed on the page
       Hidden fields are used for variables passed into the page as request parameters
       AND for hidden fields that need to be used for saving or deleting the detail on this page. --%>
<impact:validateInput type="hidden" name="hdnExamCat" value=""/>
<impact:validateInput type="hidden" name="hdnExamId" value=""/>
<impact:validateInput type="hidden" name="hdnCeExamId" value=""/>
<impact:validateInput type="hidden" name="hdnReportId" value=""/>
<%-- Do not use FormattingHelper here --%> 
<impact:validateInput type="hidden" name="hdnDtLastUpdateYouthDetail" 
                      value="<%= DateHelper.toISOString(youthDetailRetrieveSO.getDtLastUpdate()) %>"/>

<%-- Start the HTML for the page --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
        <%-- Use descriptive IDs for your Table and Tag identifiers :
             Javascript code would be better inside a function that is called from here,
               but for ease of use I have put the code here --%>
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
    </td>
  </tr>
</table>
<%-- Begin Detail --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="8">General Information</th>
</tr>
<tr>
  <td colspan="2">
    <impact:validateSelect label="Parental Status" name="selSzCdParentStat" tabIndex="<%= tabIndex++ %>"
                           codesTable="CPARSTAT" 
                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getCdParentalStatus() )%>"/></td>
</tr>
<tr>
  <td colspan="2">
    <impact:validateDate name="dtEmanDisc" disabled="false" label="Emancipation Discussion Date" 
                         value="<%= FormattingHelper.formatDate(youthDetailRetrieveSO.getDtEmancipationDiscussionDate()) %>" 
                         size="8" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
  </td>
  <td>&nbsp;</td>
  <td valign="middle"><!--- Text Area Custom Tag --->
    <impact:validateTextArea name="txtEmanDiscCmnt" colspan="3" label="Comments" rows="4" cols="50"
                             tabIndex="<%= tabIndex++ %>"
                             constraint="Comments">
    <%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtEmancipationDiscussionCmnt()) %>

    </impact:validateTextArea>
  </td>
</tr>
<tr>
  <td>
  <span></span>Life Skill Training Received
  </td>
  <td>&nbsp;</td>
  <td>
    <%
    yesIsChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndLifeSkillsTrainingRecvd());
    noIsChecked = ArchitectureConstants.N.equals(youthDetailRetrieveSO.getIndLifeSkillsTrainingRecvd());
    %>
    <impact:validateInput tabIndex="<%= tabIndex++ %>" 
                          checked="<%=String.valueOf(yesIsChecked)%>" 
                          value="<%= ArchitectureConstants.Y %>"
                          type="radio" name="rbLST_Recvd"
                          label="Yes" cssClass="formInput"/>
    <impact:validateInput tabIndex="<%= tabIndex++ %>" 
                          checked="<%=String.valueOf(noIsChecked)%>" 
                          value="<%= ArchitectureConstants.N %>"
                          type="radio" name="rbLST_Recvd"
                          label="No" cssClass="formInput"/>
  </td>
  <td>&nbsp;</td>
  <td valign="middle"><!--- Text Area Custom Tag --->
    <impact:validateTextArea name="txtLSTCmnt" colspan="3" label="Comments" rows="4" cols="50"
                             tabIndex="<%= tabIndex++ %>"
                             constraint="Comments">
      <%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndLifeSkillsTrainingRecvd() )%>
    </impact:validateTextArea>
  </td>
</tr>
<tr>
  <td>
  <span></span>Employment Services Received
  </td>
  <td>&nbsp;</td>
  <td>
    <%
    yesIsChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndEmploymentServiceRecvd());
    noIsChecked = ArchitectureConstants.N.equals(youthDetailRetrieveSO.getIndEmploymentServiceRecvd());
    %>
      <impact:validateInput tabIndex="<%= tabIndex++ %>" 
        checked="<%=String.valueOf(yesIsChecked)%>" 
        value="<%= ArchitectureConstants.Y %>"
        type="radio" name="rbES_Recvd"
        label="Yes" cssClass="formInput"/>
      <impact:validateInput tabIndex="<%= tabIndex++ %>" 
        checked="<%=String.valueOf(noIsChecked)%>" 
        value="<%= ArchitectureConstants.N %>"
        type="radio" name="rbES_Recvd"
        label="No" cssClass="formInput"/>
  </td>
  <td>&nbsp;</td>
  <td valign="middle"><!--- Text Area Custom Tag --->
    <impact:validateTextArea name="txtESCmnt" colspan="3" label="Comments" rows="4" cols="50"
                             tabIndex="<%= tabIndex++ %>"
                             constraint="Comments">
      <%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndEmploymntServiceRecvd() )%>
    </impact:validateTextArea>
  </td>
</tr>
<tr>
  <td>
  <span></span>Health Services Received
  </td>
  <td>&nbsp;</td>
  <td>
    <%
    yesIsChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndHealthServiceRecvd());
    noIsChecked = ArchitectureConstants.N.equals(youthDetailRetrieveSO.getIndHealthServiceRecvd());
    %>
    <impact:validateInput tabIndex="<%= tabIndex++ %>" 
                          checked="<%=String.valueOf(yesIsChecked)%>" 
                          value="<%= ArchitectureConstants.Y %>"
                          type="radio" name="rbHS_Recvd"
                          label="Yes" cssClass="formInput"/>
    <impact:validateInput tabIndex="<%= tabIndex++ %>" 
                          checked="<%=String.valueOf(noIsChecked)%>" 
                          value="<%= ArchitectureConstants.N %>"
                          type="radio" name="rbHS_Recvd"
                          label="No" cssClass="formInput"/>
  </td>
  <td>&nbsp;</td>
  <td valign="middle"><!--- Text Area Custom Tag --->
    <impact:validateTextArea name="txtHSCmnt" colspan="3" label="Comments" rows="4" cols="50"
                             tabIndex="<%= tabIndex++ %>"
                             constraint="Comments">
      <%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndHealthServiceRecvd() )%>
  </impact:validateTextArea>
  </td>
</tr>
</table>
<%-- End Detail --%>
<br>
<impact:ExpandableSectionTag name="SchoolAndGedDetailTable" id="SchGedInfo_Id"
                             label="School and GED Information" tabIndex="<%= tabIndex++ %>">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
   <tr class="subDetail"><td><table border="0" width="100%" cellSpacing="0" cellPadding="1">
    <tr class="subDetail">
      <td><impact:validateDisplayOnlyField name="txtHsName" colspan="3" label="School Name"
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtHiSchoolName() )%>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td width="17%">
        <impact:validateDate name="dtExpectedHsGrad" disabled="false" label="Expected Highschool Graduation"
                             value="<%= FormattingHelper.formatDate( youthDetailRetrieveSO.getDtExpectdHiSchoolGradtn() )%>" 
                             size="8" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" 
                               value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getCdAcademicTrack() )%>" 
                               name="selAcademicTrack"
                               label="Academic Track" codesTable="CATRACK" blankValue="true" />
      </td>
    </tr>
    <tr class="subDetail">
      <td>  
        <impact:validateInput type="text" label="Credits Required" name="txtHsCreditsReq"
                            cssClass="formInput" constraint="Numeric"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtCreditsRequired() ) %>"
                            size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateInput type="text" label="Credits Earned" name="txtHsCreditsEarned"
                            cssClass="formInput" constraint="Numeric"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtCreditsEarned() )%>"
                            size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="Current GPA" name="txtHsCurrentGPA"
                            cssClass="formInput" constraint="GPA"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtHsCurrentGPA() )%>"
                            size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateInput type="text" label="Cumulative GPA" name="txtHsCumulativeGPA"
                            cssClass="formInput" constraint="GPA"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtHsCumulativeGPA() )%>"
                            size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td colspan="2">
    <%
    isChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndHsGraduate());
    %>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%=ArchitectureConstants.Y%>" 
                            type="checkbox" 
                            checked="<%=String.valueOf(isChecked)%>" 
                            name="cbxIndHsGrad" label="High School Graduate"
                            cssClass="formInput"/>
      </td>
      <td valign="middle"><!--- Text Area Custom Tag --->
        <impact:validateTextArea name="txtHsGradCmnt" colspan="3" label="Comments" rows="4" cols="50"
                             tabIndex="<%= tabIndex++ %>"
                             constraint="Comments">
                             <%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndHsGradteCmnt() )%>
        </impact:validateTextArea>
      </td>
    </tr>
   </table></td></tr>
    <tr><th>Georgia Graduation Test Dates</th></tr>
    <tr class="subDetail">
      <td>
        <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
          <table border="0" cellpadding="3" cellspacing="0" width="100%">
            <tr><th class="thList">Examination Type</th>
                <th class="thList">Date</th>
                <th class="thList">First Taken?</th>
                <th class="thList">Passed?</th>
                <th class="thList">Score</th>
            </tr>
            <%
            loopCount = 0;
            Iterator itrHsExamList = youthDetailRetrieveSO.getHsExamList().iterator();
            while (itrHsExamList.hasNext()) {
              ExamDetailList hsExam = (ExamDetailList) itrHsExamList.next(); 
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
              <td>
                <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
                <a href="javascript: displayExamDetailPage( '<%= loopCount %>', '<%= hsExam.getIdExamDetail()%>', 'HS' )" 
                   tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;" id="HS" 
                  ><%=Lookup.simpleDecodeSafe("CGRAD", hsExam.getCdExamType()) %></a>
              </td>
              <td><%= FormattingHelper.formatDate(hsExam.getDtExam()) %></td>
              <td><%= FormattingHelper.formatString(hsExam.getIndFirstAtmpt()) %></td>
              <td><%= FormattingHelper.formatString(hsExam.getIndPassed()) %></td>
              <td><%= FormattingHelper.formatInt(hsExam.getNbrScore()) %></td>
            </tr>
            <%
              loopCount++;
            }
            %>
          </table>
        </div>
      </td>
    </tr>
    <tr class="subDetail">
      <td align="right">
        <impact:ButtonTag name="btnAddHsExams" img="btnAdd" form="frmYouthDetail" 
                          function="return setHsExamCat();" action="/person/ExamDetail/addExamDetail"
                          editableMode="<%=EditableMode.EDIT%>" 
                          navAwayCk="true" restrictRepost="true" 
                          align="right" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <!-- GED Section -->
   <tr><td><table border="0" width="100%" cellSpacing="0" cellPadding="3">
    <tr><th colspan="4">GED Information</th></tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="GED Program Name" constraint="Name20" name="txtGEDProgName"
                            cssClass="formInput" 
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgramName() )%>" 
                            size="30" maxLength="20" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td colspan="2">
    <%
    isChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndInGEDProgram());
    %>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" value="<%=ArchitectureConstants.Y%>" 
                            type="checkbox" 
                            checked="<%=String.valueOf(isChecked)%>" 
                            name="cbxIndGEDProg" label="In GED Program"
                            cssClass="formInput" />
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="Address Line 1" constraint="Address" name="txtGEDProgAddressLine1"
                            cssClass="formInput" colspan="3"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgAddressLine1() )%>" 
                            size="30" maxLength="30" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="Address Line 2" constraint="Address2" name="txtGEDProgAddressLine2"
                            cssClass="formInput" colspan="3"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgAddressLine2() )%>" 
                            size="30" maxLength="30" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <!-- td colspan="5">&nbsp;</td -->
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="City" constraint="City" name="txtGEDProgCity"
                            cssClass="formInput" colspan="3"
                            value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgCity() )%>" 
                            size="20" maxLength="30" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" 
                               value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getCdGEDProgState() )%>" 
                               name="selGEDProgCdState"
                               label="State" codesTable="CSTATE" blankValue="true"  />
      </td>
      <td colspan="2">
       <table border="0" cellspacing="0" cellpadding="0"><tr><td width="30px">
        <impact:validateInput type="text" label="Zip" constraint="Zip" name="txtGEDProgZip"
                            cssClass="formInput" 
                            value="<%= zip %>"  
                            size="5" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
        -
        <impact:validateInput type="text" constraint="ZipSuff" name="txtGEDProgZipSuff"
                              cssClass="formInput" 
                              value="<%= zipSuff %>"
                              size="4" maxLength="4" tabIndex="<%= tabIndex++ %>"/>
       </td></tr></table>
      </td>
      <!-- td colspan="3">&nbsp;</td -->
    </tr>
    <tr class="subDetail">
    <%
    String phoneNumber = FormattingHelper.formatString(youthDetailRetrieveSO.getTxtGEDProgPhoneNum());
    if (!"".equals(phoneNumber)) {
      phoneNumber = FormattingHelper.formatPhone(phoneNumber);
    }
    %>
      <td>
        <impact:validateInput type="text" label="Phone" constraint="Phone" name="txtGEDProgPhoneNumber"
                            cssClass="formInput" 
                            value="<%= phoneNumber%>" 
                            size="15" maxLength="14" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <%
    String faxNumber = FormattingHelper.formatString(youthDetailRetrieveSO.getTxtGEDProgFaxNum());
    if (!"".equals(faxNumber)) {
      faxNumber = FormattingHelper.formatPhone(faxNumber);
    }
    %>
      <td colspan="2">
       <table border="0" cellspacing="0" cellpadding="0"><tr><td width="30px">
        <impact:validateInput type="text" label="Fax" constraint="Phone" name="txtGEDProgFaxNumber"
                            cssClass="formInput" 
                            value="<%= faxNumber %>" 
                            size="15" maxLength="14" tabIndex="<%= tabIndex++ %>"/>
       </td></tr></table>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateDate name="dtExpectedGEDComp" disabled="false" label="Expected GED Program Completion" 
                             value="<%= FormattingHelper.formatDate( youthDetailRetrieveSO.getDtExpectdGEDProgramComp() )%>" 
                             size="8" constraint="Date" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td colspan="2">
       <table border="0" cellspacing="0" cellpadding="0"><tr><td width="40%">
        <impact:validateDate name="dtActualGEDComp" disabled="false" label="Actual GED Program Completion" 
                             value="<%= FormattingHelper.formatDate( youthDetailRetrieveSO.getDtActualGEDProgramComp() )%>"
                             size="8" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
       </td></tr></table>
      </td>
    </tr>
   </table></td></tr>
    <tr><th nowrap="nowrap">GED Test Dates</th></tr>
    <tr class="subDetail">
      <td>
        <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
          <table border="0" cellpadding="3" cellspacing="0" width="100%">
            <tr><th class="thList">Examination Type</th>
                <th class="thList">Date</th>
                <th class="thList">First Taken?</th>
                <th class="thList">Passed?</th>
                <th class="thList">Score</th>
            </tr>
            <%
            loopCount = 0;
            Iterator itrGedExamList = youthDetailRetrieveSO.getGedExamList().iterator();
            while (itrGedExamList.hasNext()) {
              ExamDetailList gedExam = (ExamDetailList) itrGedExamList.next(); 
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
              <td>
                <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
                <a href="javascript: displayExamDetailPage( '<%= loopCount %>', '<%= gedExam.getIdExamDetail()%>', 'GED' )" 
                   tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;" id="GED" 
                  ><%=Lookup.simpleDecodeSafe("CGED", gedExam.getCdExamType()) %></a>
              </td>
              <td><%= FormattingHelper.formatDate(gedExam.getDtExam()) %></td>
              <td><%= FormattingHelper.formatString(gedExam.getIndFirstAtmpt()) %></td>
              <td><%= FormattingHelper.formatString(gedExam.getIndPassed()) %></td>
              <td><%= FormattingHelper.formatInt(gedExam.getNbrScore()) %></td>
            </tr>
            <%
              loopCount++;
            }
            %>
          </table>
        </div>
      </td>
    </tr>
    <tr class="subDetail">
      <td align="right">
        <impact:ButtonTag name="btnAddGEDExams" img="btnAdd" form="frmYouthDetail" 
                          function="return setGedExamCat();" action="/person/ExamDetail/addExamDetail"
                          editableMode="<%=EditableMode.EDIT%>" 
                          navAwayCk="true" restrictRepost="true" 
                          align="right" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<br>
<impact:ExpandableSectionTag name="PostSecondaryEducationTable" id="PostSecEdu_Id"
                             label="Post Secondary Education" tabIndex="<%= tabIndex++ %>">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="Institution Name" constraint="Name50" name="txtPostInstitutionName"
                              cssClass="formInput" 
                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostInstitutionName() ) %>" 
                              colspan="2"
                              size="20" maxLength="50" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" name="selPostCdEduGoal"
                               value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getCdPostEduGoal() ) %>" 
                               label="Education Goal" codesTable="CEDUGOAL" blankValue="true" colspan="2" />
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" name="selPostCdClassif"
                               value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getCdPostClassification() ) %>" 
                               label="Classification" codesTable="CCLSSFCT" blankValue="true" colspan="2" />
      </td>
      <td>
        <impact:validateInput type="text" label="Area Study" constraint="Name50" name="txtPostAreaStudy"
                              cssClass="formInput" 
                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostAreaofStudy() ) %>" 
                              colspan="2"
                              size="20" maxLength="50" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="Current GPA" name="txtPostCurrentGPA"
                              cssClass="formInput" constraint="GPA"
                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostCurrentGPA() ) %>"                         colspan="2"
                              size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateInput type="text" label="Cumulative GPA" name="txtPostCumulativeGPA"
                              cssClass="formInput" constraint="GPA"
                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostCumulativeGPA() ) %>" 
                              colspan="2"
                              size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput type="text" label="Credits Required for Graduation" name="txtPostCreditsReqGrad"
                              cssClass="formInput" constraint="Numeric"
                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostReqdCreditsforGradtn() ) %>" 
                              colspan="2"
                              size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td>
        <impact:validateInput type="text" label="Earned Credits for Graduation" name="txtPostCreditsEarnedGrad"
                              cssClass="formInput" constraint="Numeric"
                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostEarndCreditsforGradtn() ) %>" 
                              colspan="2"
                              size="8" maxLength="5" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateDate name="dtExpectedPostGrad" disabled="false" label="Expected Graduation" 
                             value="<%= FormattingHelper.formatDate( youthDetailRetrieveSO.getDtPostExpectdGradtn() ) %>" 
                             size="8" constraint="Date" tabIndex="<%= tabIndex++ %>" colspan="2"/>
      </td>
      <td>
        <impact:validateDate name="dtActualPostGrad" disabled="false" label="Actual Graduation" 
                             value="<%= FormattingHelper.formatDate( youthDetailRetrieveSO.getDtPostActualGradtn() ) %>" 
                             size="8" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
    <tr><th><span></span>College Entrance Exams</th></tr>
    <tr class="subDetail">
      <td colspan="6">
        <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
          <table border="0" cellpadding="3" cellspacing="0" width="100%">
            <tr><th class="thList">Date Taken</th>
                <th class="thList">Examination Type</th>
                <th class="thList">&nbsp;</th>
                <th class="thList">&nbsp;</th>
                <th class="thList">&nbsp;</th>
            </tr>
            <%
            loopCount = 0;
            Iterator itrCeExamList = youthDetailRetrieveSO.getCeExamList().iterator();
            while (itrCeExamList.hasNext()) {
              CollegeEntranceExamSummary ceExam = (CollegeEntranceExamSummary) itrCeExamList.next(); 
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
              <td>
                <%-- Note that the formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
                <a href="javascript: displayCeExamDetailPage( '<%= loopCount %>', '<%= ceExam.getIdExam()%>' )" 
                   tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;"  
                  ><%= FormattingHelper.formatDate(ceExam.getDtExamTaken()) %></a>
              </td>
              <td><%=FormattingHelper.formatString(ceExam.getCdExamType()) %></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <%
              loopCount++;
            }
            %>
          </table>
        </div>
      </td>
    </tr>
    <tr class="subDetail">
      <td align="right" colspan="6">
        <impact:ButtonTag name="btnAddCExams" img="btnAdd" form="frmYouthDetail" action="/person/CollegeEntranceExam/addCollegeEntranceExam" 
                          function="disableValidation('frmYouthDetail');"
                          align="right" tabIndex="<%= tabIndex++ %>" 
                          navAwayCk="true" restrictRepost="true" disabled = "<%= String.valueOf(bAddReportButtonHide) %>" 
                          editableMode="<%=EditableMode.EDIT%>"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
</br>
<impact:ExpandableSectionTag name="YouthReportTable" id="YouthReport_Id"
                             label="Youth Report List" tabIndex="<%= tabIndex++ %>">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr class="subDetail">
      <td colspan="6">
        <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
          <table border="0" cellpadding="3" cellspacing="0" width="100%">
            <tr><th class="thList">Reporting Period</th>
                <th class="thList">Age Class</th>
                <th class="thList">Current Outcome Status</th>
                <th class="thList">Outcome Date</th>
                <th class="thList">&nbsp;</th>
            </tr>
            <%
            loopCount = 0;
            Iterator itrYouthReportList = youthDetailRetrieveSO.getYouthReportList().iterator();
            while (itrYouthReportList.hasNext()) {
              YouthReportSummary report = (YouthReportSummary) itrYouthReportList.next(); 
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
              <td>
                <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
                <a href="javascript: displayYouthReportDetailPage( '<%= loopCount %>', '<%= report.getIdYouthReport()%>' )" 
                   tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;"  
                  ><%= FormattingHelper.formatDate(report.getDtReportingPeriod()) %></a>
              </td>
              <td><%=Lookup.simpleDecodeSafe("CAGECLSS", report.getCdAgeClass()) %></td>
              <td><%= Lookup.simpleDecodeSafe("COUTSTAT", report.getCdOutcomeStatus()) %></td>
              <td><%= FormattingHelper.formatDate(report.getDtOutcomeDate()) %></td>
              <td></td>
            </tr>
            <%
              loopCount++;
            }
            %>
          </table>
        </div>
      </td>
    </tr>
    <tr class="subDetail">
      <td align="right" colspan="6">
        <impact:ButtonTag name="btnAddReport" img="btnAdd" form="frmYouthDetail" action="/person/YouthReportDetail/addReportDetail" 
                          align="right" tabIndex="<%= tabIndex++ %>" 
                          function="disableValidation('frmYouthDetail');"
                          navAwayCk="true" restrictRepost="true" 
                          disabled="<%=String.valueOf(bAddYouthReportButtonHide)%>"
                          editableMode="<%=EditableMode.EDIT%>"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<!-- SMS #66384: MR-067 Added NYTD User Information as the last expandable section  --> 
<br> 


    <% // If the person is a NYTD User, display NYTD User Information section
    if (isNytdUser) {
      // Get the zip code format
      String zipPortalUser = youthDetailRetrieveSO.getTxtAddrUsrZip();
      String zipSuffPortalUser = "";
      if (StringHelper.isValid(zipPortalUser)) {           
	      if (zipPortalUser.length() > 5) {
	        zipSuffPortalUser = zipPortalUser.substring(5);
	        zipPortalUser = zipPortalUser.substring(0,5);
	        }
      }  
    %>
<impact:ExpandableSectionTag name="NYTDUserInformationTable" id="NYTDUser_Id"
                             label="NYTD User Information" tabIndex="<%= tabIndex++ %>">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  
  <tr class="subDetail">
        <td>         
            <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableborder">
  		     <tr class="subDetail">
		       <td width="25%"><impact:validateDisplayOnlyField name="txtFirstName" label="First Name"
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserFirstName() )%>"
                                           /></td>
     			 <td width="10%">
    					&nbsp;
				 </td>                           
		       <td width="20%"><impact:validateDisplayOnlyField name="txtMiddleInitial" label="Middle Initial"
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserMiddleInitial() )%>"
                                           /></td>
               <td width="10%">
    					&nbsp;
				 </td> 
		       <td width="25%"><impact:validateDisplayOnlyField name="txtLastName" label="Last Name"
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserLastName() )%>"
                                           /></td>                                                                                                                              
		       <td width="10%">
    					&nbsp;
			   </td>
		     </tr>   			    			    			
    	  </table>
       </td>
    </tr>
	     
     <tr class="subDetail">
        <td>         
            <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableborder">
              <tr>
              <th  colspan="8">Online Contact Information</th></tr>                 
    			<tr class="subDetail">
      			<td>
      			<impact:validateDisplayOnlyField name="txtUserEmail" label="Email"
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserEml() )%>"
                                           />
     			 </td>
    			</tr>
    			<tr class="subDetail">
      			<td>
      			<img align="bottom" alt="Facebook User Name" src="/grnds-docs/images/shared/facebookicon.jpg"/>
     			 </td>
     			<td><impact:validateDisplayOnlyField name="txtFacebookUserName"      									   
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserFB() )%>"
                                           />
                </td>                           
    			</tr>    			
    			<tr class="subDetail">
      			<td>
      			<img align="bottom" alt="MySpace User Name" src="/grnds-docs/images/shared/myspaceicon.gif"/>
      			</td>
      			<td>
      			<impact:validateDisplayOnlyField name="txtMyspaceUserName" 
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserMS() )%>"
                                           />
     			 </td>
    			</tr>
    			<tr class="subDetail">
      			<td>
      			<img align="bottom" alt="Twitter User Name" src="/grnds-docs/images/shared/twittericon.jpg"/>
      			</td>
      			<td>
      			<impact:validateDisplayOnlyField name="txtTwitterUserName"
                                           value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserTW() )%>"
                                           />
    			</tr>
   				 <tr class="subDetail">
			      <td>
			        <impact:validateDisplayOnlyField name="txtOtherSite" label="Other Site"
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserOthSite() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtOtherSiteUserName" label="User Name"
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserNameOthSite() )%>" 
			                              />
			      </td>
			    </tr>    			    			    			
    	  </table>
       </td>
    </tr> 
     <tr class="subDetail">
        <td>         
            <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableborder">
              <tr>
              <th colspan="8">Phone Contact Information</th>
              </tr>   			
   				 <tr class="subDetail">
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneBest" label="Best Contact Phone Number"
			                              value="<%= FormattingHelper.formatPhone( youthDetailRetrieveSO.getTxtUserPhnBest() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneBestExt" label="Ext."
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserPhnBestExt() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneBestType"
			                              value="<%= Lookup.simpleDecodeSafe("CUSRPHN", youthDetailRetrieveSO.getTxtUserPhnBestType() )%>"
			                              />
			      </td>			      
			     </tr>	
   				 <tr class="subDetail">
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneAlt1" label="Alternate Phone Number 1"
			                              value="<%= FormattingHelper.formatPhone( youthDetailRetrieveSO.getTxtUserPhnAlt1() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneAlt1Ext" label="Ext."
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserPhnAlt1Ext() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneAlt1Type"
			                              value="<%= Lookup.simpleDecodeSafe("CUSRPHN", youthDetailRetrieveSO.getTxtUserPhnAlt1Type() )%>"
			                              />
			      </td>			      
			     </tr>	
   				 <tr class="subDetail">
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneAlt2" label="Alternate Phone Number 2"
			                              value="<%= FormattingHelper.formatPhone( youthDetailRetrieveSO.getTxtUserPhnAlt2() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneAlt2Ext" label="Ext."
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserPhnAlt2Ext() )%>" 
			                              />
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtUserPhoneAlt2Type"
			                              value="<%= Lookup.simpleDecodeSafe("CUSRPHN", youthDetailRetrieveSO.getTxtUserPhnAlt2Type() )%>"
			                              />
			      </td>			      
			     </tr>	
   				 <tr class="subDetail">
			      <td>
			        <impact:validateDisplayOnlyField name="txtContactByText" label="Can DFCS contact you by text?"
			                              value="<%= Lookup.simpleDecodeSafe("CRISKYN", youthDetailRetrieveSO.getTxtCntctByText() )%>"
			                              />
			      </td>		      
			     </tr>				     				     			     		    			    			
    	  </table>
     </tr>
     <tr class="subDetail">
        <td>         
            <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableborder">
              <tr class="subDetail">
              <th colspan="8">Address Information</th>
              </tr>   			
   				 <tr class="subDetail">
			      <td>
                    <span>Address: </span>	      
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtAddrUserStLn1"
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrStLn1() )%>" 
			                              />
			      </td>			      	      
			     </tr>	
   				 <tr class="subDetail">
			      <td>
                    <span></span>	      
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtAddrUserStLn2"
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrStLn2() )%>" 
			                              />
			      </td>			      		      
			     </tr>	
   				 <tr class="subDetail">
			      <td>
                    <span>City: </span>	      
			      </td>
			      <td>
			        <impact:validateDisplayOnlyField name="txtAddrUserCity"
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrCity() )%>" 
			                              />
			      </td>
			      <td>
                    <span>State: </span>	      
			      </td>			      
			      <td>
			        <impact:validateDisplayOnlyField name="txtAddrUserState"
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrSt() )%>" 
			                              />
			      </td>		      
			     </tr>	
   				 <tr class="subDetail">
			      <td>
                    <span>Zip: </span>	      
			      </td>				      
			      <td>
			        <impact:validateDisplayOnlyField name="txtAddrUserZip"
			                              value="<%= FormattingHelper.formatString(zipPortalUser) %>" 			                              
			                              />
			      <% // If the zip code has extended ZIP+4 code, display extended code with a Hyphen
                  if (!"".equals(zipSuffPortalUser)) {
                  %>-
                  <impact:validateDisplayOnlyField name="txtAddrUserZipSuff"
			                              value="<%= FormattingHelper.formatString(zipSuffPortalUser) %>" 			                              
			                              /></td>
			      <% 
			      }
                  %>    			      
			      <td>
                    <span>County: </span>	      
			      </td>	
			      <td>
			        <impact:validateDisplayOnlyField name="txtAddrUserCounty"
			                              value="<%= Lookup.simpleDecodeSafe("CCOUNT", youthDetailRetrieveSO.getTxtAddrUsrCnty() )%>"                            />
			      </td>	
			     </tr> 
   				 <tr class="subDetail">	
                   <td colspan="4">
                    <span style="align:left"> If we cannot locate you, who is a reliable adult who knows where you are? (Name and Contact Information) </span>	      
			       </td>
			     </tr>	
			     <tr>
			       <td colspan="4">	      
			        <impact:validateDisplayOnlyField name="txtEmergencyContact" 
			                              value="<%= FormattingHelper.formatString( youthDetailRetrieveSO.getTxtEmerContact() )%>" 
			                              />
			       </td>                       
			     </tr>			     			     				     			     		    			    			
    	  </table>
     </td>
    </tr>    
  </table>
 
</impact:ExpandableSectionTag>
<%}

      %>
      
</br>
<!-- End SMS #66384: MR-067 -->
<hr>
<table cellspacing="0" cellPadding="3" width="100%" border="0">
  <tr>
    <td class="alignRight">
        <%--
        Button Tag:
        o Always pass a tabIndex and the img attribute as well as a unique name
        o Always pass form="yourFORMNAME" and action="/servlet/conversation/command"
        o If you are submitting an impact:validateForm set validate="true" (almost all cases)
        o If you need to call a custom function see the delete button example
        o If you want your button to align right pass align="right" (left is default)
        o If you want want the "Are you sure you want to navigate away from this page..." pop-up to appear
        o Set navAwayCk to true (accepts boolean or "true").
        --%>
      <impact:ButtonTag name="btnSaveFinal" editableMode="<%= EditableMode.EDIT %>"
                        img="btnSave" align="right" form="frmYouthDetail" action="/person/YouthDetail/saveYouthDetail"
                        tabIndex="<%= tabIndex++ %>" restrictRepost="true" 
                        editableMode="<%= EditableMode.EDIT+EditableMode.NEW %>"/>
    </td>
  </tr>
</table>
<%--  Always include this hidden field in your form --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<%-- Close Validate Form Custom Tag --%>
</impact:validateForm>

