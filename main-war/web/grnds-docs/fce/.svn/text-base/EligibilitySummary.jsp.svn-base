<%--
/**
 * JSP Name:    EligibilitySummary.jsp
 * Created by:   Matt McClaim
 * Date Created: 03/03/03
 *
 * Description:
 * This page captures the summary information for the eligibility determination.
 * The Eligibility Specialist will enter the appropriate information regarding
 * the eligibility type for the child and the dates of the selected eligibility.
 *
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
  08/20/04  Todd Reser        SIR 23012 - Set the review date to the 8th day of
                              the month after their birthday if the child is 18
                              or older.  Added informational Message.  Added
                              hidden BirthDate field.
  08/31/04  Todd Reser        It was decided that the review date will be set
                              the same for children over 17.
  10/14/04  Todd Reser        Added over 20 Error message MSG_FCE_DENIED_20
  10/15/04  Todd Reser        Added code to handle when Event Status is New or
                              not to calculate the review date and show messages
  10/18/04  Todd Reser        Added if Statment to default the review date to
                              the 8th day of the month or 1 year from the start
                              date, whichever is sooner
  10/29/04  Todd Reser        SIR 23283 - Added && age > 16 to if statement to
                              avoid a javascript error.
  02/28/04  Todd Reser        SIR 23034 - Create an array list of exclusions for
                              the Actual Eligibility box and supress MAO Code 30
  03/07/05  Todd Reser        SIR23345 - Added ability to edit page if event
                              status is PROCESS_EVENT.
  09/16/05  berkime           SIR 23890 renamed BLOC to BSL
  09/27/05  Todd Reser        SIR 23719 - Changed over20 to overMaxAge, changed 
                              age from 20 to 22 and MSG_FCE_DENIED_20 to
                              MSG_FCE_DENIED_MAX_AGE
  01/17/11  hjbaptiste        SMS#81144: set hidden indicator that indicates if Reimbursability has been created                            
*/
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilitySummaryConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility" %>

<%!
  public static final String MEDICAID_ELIGIBILITY_CODE_TABLE = CodesTables.CELIGMED;
  public static final String ELIGIBILITY_CODE_TABLE = CodesTables.CELIGIBI;
  public static final String REASON_ELIGIBILITY_CODE_TABLE = CodesTables.CELIGCHG;
%>
<%

  String hdnCSupRefOutboundErrors = (String)request.getAttribute("cSupRefOutboundErrors");
  boolean showCSupRefOutboundErrors = (hdnCSupRefOutboundErrors!=null);
  EligibilitySummaryDB eligibilitySummaryDB =
          (EligibilitySummaryDB) request.getAttribute("EligibilitySummaryDB");
  boolean isPrevEligCSupSend = eligibilitySummaryDB.getIndEligCsupSend();
  boolean isEligibilitySpecialist = FceUtility.isEligibilitySpecialist(request);
  boolean isBillingSpecialist = FceUtility.isBillingSpecialist(request);
  String eventStatus = eligibilitySummaryDB.getCdEventStatus();
  String pageMode = PageMode.getPageMode(request);
  boolean endDated = (!(eligibilitySummaryDB.getDtEligEnd() == null) && !DateHelper.MAX_JAVA_DATE.equals(eligibilitySummaryDB.getDtEligEnd()));

  boolean actualEligibilityDisabled = true;
  boolean medicaidEligibilityDisabled = true;
  boolean selectedEligibilityDisabled = true;
  boolean startDateDisabled = true;
  boolean endDateDisabled = true;
  boolean redeterminationDateDisabled = true;
  boolean eligibilityReasonDisabled = true;
  boolean childSupportQuestionDisabled = true;
  boolean childSupportReferralDateDisabled = true;
  boolean commentsDisabled = true;
  boolean passwordDisabled = true;
  boolean saveDisabled = true;
  boolean deleteDisabled = true;
  //STGAP00006420:Added the if check to see if the user has special access to modify
  // an approved Eligibility Summary.
  boolean modifyEndDateAccess = false;
  UserProfile user = UserProfileHelper.getUserProfile(request);
      if(user.hasRight(UserProfile.SEC_MODIFY_END_DATED_ELLIG)){
           modifyEndDateAccess = true;
      }
  
  //SIR23345 - Added ability to edit page if event status is in progress.
  if (PageModeConstants.EDIT.equals(pageMode)) {
    if (((isBillingSpecialist) ||
        (isEligibilitySpecialist)) &&
         ((eventStatus.equals(EventHelper.NEW_EVENT)) || (eventStatus.equals(EventHelper.APPROVED_EVENT) && !endDated))) {
      actualEligibilityDisabled = false;
      medicaidEligibilityDisabled = false;
      selectedEligibilityDisabled = false;
      startDateDisabled = false;
      endDateDisabled = false;
      redeterminationDateDisabled = false;
      eligibilityReasonDisabled = false;      
      childSupportQuestionDisabled = false;
      childSupportReferralDateDisabled = false;
      commentsDisabled = false;
      passwordDisabled = false;
      saveDisabled = false;
    }
    if ((isBillingSpecialist == false) &&
        (isEligibilitySpecialist) &&
        (eventStatus.equals(EventHelper.APPROVED_EVENT) && !endDated)) {
      endDateDisabled = false;
      commentsDisabled = false;
      passwordDisabled = false;
      saveDisabled = false;
    }
    if (eligibilitySummaryDB.getIndEligCsupSend()){
      childSupportQuestionDisabled = true;
      childSupportReferralDateDisabled = true;
    }
    if (!saveDisabled && eventStatus.equals(EventHelper.NEW_EVENT)) {
      int age = DateHelper.getAge(eligibilitySummaryDB.getDtChildBirth());
      // SIR 23012 - If the child is over 16
      if (age > 16) {
%>
<script type="text/javascript" language="javascript">
  var over17 = true;
</script>
<%
    //SIR 23719 - Changed age to 22
  }
  if (age >= 22) {

    //SIR 23719 - Changed over20 to overMaxAge
%>
<script type="text/javascript" language="javascript">
  var overMaxAge = true;
</script>
<%
      }
    }
    if (((isEligibilitySpecialist) || (isBillingSpecialist)) &&
        (eventStatus.equals(EventHelper.NEW_EVENT))) {
      deleteDisabled = false;
    }
  }

  //Keep comments section editable always, for scrollbars
  commentsDisabled = false;
  //STGAP00006420:Added the if check to see if the user has special access to modify
  // an approved Eligibility Summary and enable the appropriate set of fields.
  boolean commentsDisabled1 = commentsDisabled;
  if(modifyEndDateAccess){
      if (!endDated && GlobalData.hasStageAccess(request)) {
          //STGAP00008339 : Added this check so that a user who is a secondary worker to the stage and has the special
          //modify attribute can edit all the fields (including the comments field)when the record is not end dated.
          //All the fields are enabled in this mode already
        } else {
          medicaidEligibilityDisabled = false;
          selectedEligibilityDisabled = false;
          redeterminationDateDisabled = false;
          eligibilityReasonDisabled = false;
          actualEligibilityDisabled = false;
          passwordDisabled = false;
          commentsDisabled1 = true;
          startDateDisabled = false;
          endDateDisabled = false;
          saveDisabled = false;
        }
  }
  
  int tabIndex = 1;
  String formName = "EligibilitySummary";
%>
<script type="text/javascript" language="javascript">
  function toDate(string) {
    if ((string == null) ||
        (string == "")) {
      return null;
    }
    return new Date(string);
  }

  function compareDate(date1, date2) {
    var difference = (date1.getYear() - date2.getYear());
    if (difference != 0) {
      return difference;
    }
    difference = (date1.getMonth() - date2.getMonth());
    if (difference != 0) {
      return difference;
    }
    difference = (date1.getDate() - date2.getDate());
    return difference;
  }

  function deleteSummary() {
    disableValidation('<%= formName %>');
  }

  function saveEligibilitySummary() {
    var form = document.all["<%= formName %>"];

  <impact:ifThen test="<%= (eventStatus.equals(EventHelper.NEW_EVENT) == false) %>">
    //?From csub23w.win
    //  If the Billing Specialist
    //      changes the selectedEligibility
    //      or changes the medicaidEligibility
    //      or makes the startDate > previousStartDate
    //      or (makes the endDate < currentDate && endDate < previousEndDate)
    //  Billing Specialist is prompted with the MSG_SUB_AFFECT_PYMT confirmation

    //don't trust the client's system date
    var currentDate = new Date("<%= FormattingHelper.formatDate(new Date()) %>");

    var onLoadSelectedEligibility = form.onLoadSelectedEligibility.value;
    var onLoadMedicaid = form.onLoadMedicaid.value;
    var onLoadStartDate = toDate(form.onLoadStartDate.value);
    var onLoadEndDate = toDate(form.onLoadEndDate.value);

    var selectedEligibility = form.cdEligSelected.value;
    var medicaidEligibility = form.cdEligMedEligGroup.value;
    var startDate = toDate(form.dtEligStartString.value);
    var endDate = toDate(form.dtEligEndString.value);

    var selectedEligibilityChanged =
            ((onLoadSelectedEligibility != null) &&
             (onLoadSelectedEligibility != "") &&
             (onLoadSelectedEligibility != selectedEligibility));

    var medicaidEligibilityChanged =
            ((onLoadMedicaid != null) &&
             (onLoadMedicaid != "") &&
             (onLoadMedicaid != medicaidEligibility));

    //      or makes the startDate > previousStartDate
    var startDateCheck =
            ((onLoadStartDate != null) &&
             (compareDate(startDate, onLoadStartDate) > 0));

    //      or (makes the endDate < currentDate && endDate < previousEndDate)
    var endDateCheck =
            ((endDate != null) &&
             (compareDate(endDate, currentDate) < 0) &&
             ((onLoadEndDate == null) || (compareDate(endDate, onLoadEndDate) < 0)))

    if ((selectedEligibilityChanged) ||
        (medicaidEligibilityChanged) ||
        (startDateCheck) ||
        (endDateCheck)) {
      var message =
              "<%= MessageLookup.getMessageByNumber(Messages.MSG_SUB_AFFECT_PYMT) %>";

      if (window.confirm(message) == false) {
        return false;
      }
      form.indEligWriteHistory.value = "true";
    }
  </impact:ifThen>
    enableValidation('<%= formName %>');
    return true;
  }
  
  function populateCsupRefDate (){
    if( document.EligibilitySummary.indEligCsupSend[0].checked){
<% 
  Date currentDate = new Date();
  String reffDate = FormattingHelper.formatDate(currentDate);
%>      
      document.EligibilitySummary.dtEligCsupReferralString.value = "<%= reffDate %>";
    } else {
      document.EligibilitySummary.dtEligCsupReferralString.value = "";
    }
  }
</script>
<impact:validateForm name="<%= formName %>"
                     defaultButton="<%= String.valueOf(deleteDisabled) %>"
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilitySummaryCustomValidation"
                     action='/not/a/real/path'
                     schema="/WEB-INF/Constraints.xsd">

<impact:validateErrors/>

<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.CD_APPLICATION %>"
                      value="<%= eligibilitySummaryDB.getCdApplication() %>"/>

<impact:ifThen test="<%= (eligibilitySummaryDB.getIndEligibleObject() != null) %>">
  <impact:validateInput type="hidden"
                        name="<%= EligibilitySummaryDB.IND_ELIGIBLE %>"
                        value="<%= eligibilitySummaryDB.getIndEligibleString() %>"/>
</impact:ifThen>

<impact:validateInput type="hidden"
                      name="onLoadSelectedEligibility"
                      value="<%= eligibilitySummaryDB.getCdEligSelected() %>"/>
<impact:validateInput type="hidden"
                      name="onLoadMedicaid"
                      value="<%= eligibilitySummaryDB.getCdEligMedEligGroup() %>"/>
<impact:validateInput type="hidden"
                      name="onLoadStartDate"
                      value="<%= eligibilitySummaryDB.getDtEligStartString() %>"/>
<impact:validateInput type="hidden"
                      name="onLoadEndDate"
                      value="<%= eligibilitySummaryDB.getDtEligEndString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.IND_ELIG_WRITE_HISTORY %>"
                      value="<%= eligibilitySummaryDB.getIndEligWriteHistoryString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.IND_REVIEW_CREATED %>"
                      value="<%= eligibilitySummaryDB.getIndReviewCreatedString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.ID_CASE %>"
                      value="<%= eligibilitySummaryDB.getIdCaseString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.ID_STAGE %>"
                      value="<%= eligibilitySummaryDB.getIdStageString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.ID_ELIGIBILITY_EVENT %>"
                      value="<%= eligibilitySummaryDB.getIdEligibilityEventString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.ID_FCE_APPLICATION %>"
                      value="<%= eligibilitySummaryDB.getIdFceApplicationString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.ID_FCE_ELIGIBILITY %>"
                      value="<%= eligibilitySummaryDB.getIdFceEligibilityString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.ID_FCE_REVIEW %>"
                      value="<%= eligibilitySummaryDB.getIdFceReviewString() %>"/>
<impact:validateInput type="hidden"
                      name="<%= EligibilitySummaryDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME %>"
                      value='<%= "" + eligibilitySummaryDB.getFceEligibilityDtLastUpdateTime() %>'/>
<impact:validateInput type="hidden"
                      name="BirthDate"
                      value='<%= "" + eligibilitySummaryDB.getDtChildBirth() %>'/>
<impact:validateInput type="hidden"
                      name="<%=EligibilitySummaryDB.DT_CHILD_BIRTH_STRING%>"
                      value='<%= "" + DateHelper.toCastorDate(eligibilitySummaryDB.getDtChildBirth()) %>'/>


<table border="0" width="100%" class="tableBorder" cellspacing="0" cellpadding="3">
  <tr>
    <th>System Derived Eligibility</th>
  </tr>
  <%
    boolean isCaps = FceConstants.CAPS.equals(eligibilitySummaryDB.getCdApplication());
    boolean isNtsc = FceConstants.NEW_TO_SUBCARE.equals(eligibilitySummaryDB.getCdApplication());
  %>

  <impact:if test="<%= (isCaps || isNtsc) %>">
    <impact:then>
      <tr>
        <td>A System Derived Eligibility is not available at this time.</td>
      </tr>
      <tr>
        <td><%= (isNtsc) ? "Child is new to subcare." : "Child has a Redetermination." %>
        </td>
      </tr>
    </impact:then>

    <impact:else>
    <% if (eligibilitySummaryDB.getIndEligibleObject() != null) { %>
      <tr>
        <td>At initial Determination, this child is <b><%= eligibilitySummaryDB.getIndEligible() ? "" : "not " %>eligible</b> for Title IV-E
          Assistance.
        </td>
      </tr>
      <impact:ifThen test="<%= (eligibilitySummaryDB.getIndEligible() == false) %>">
        <tr>
          <td>
            <table width="100%" cellpadding="3" cellspacing="0" class="tableBorderList">
              <tr>
                <th class="thList">Reasons Not Eligible</th>
              </tr>
              <%
                int i = 0;
                List reasonsNotEligible = eligibilitySummaryDB.getReasonsNotEligible();
                //for Conversion, there will not be a list of reasons not eligible
                if (reasonsNotEligible != null && reasonsNotEligible.size() > 0){
                  reasonsNotEligible = FceUtility.getPastTenseReasonsNotEligible(reasonsNotEligible, eligibilitySummaryDB.getCdApplication());
                  Iterator iterator = reasonsNotEligible.iterator();
                  while (iterator.hasNext()) {
                    String reason = (String) iterator.next();

                    i++;

                    String trClass = "odd";
                    if (i % 2 == 0) {
                      trClass = "even";
                    }
              %>
              <tr class="<%= trClass %>">
                <td><%= reason %>
                </td>
              </tr>
              <%
                  }
                }
              %>
            </table>
          </td>
        </tr>
      </impact:ifThen>
      <% }else{ %>
      <tr>
        <td>N/A</td>
      </tr>
      <%}%>
    </impact:else>
  </impact:if>
</table>
<!--SIR 23890 renamed BLOC to BSL -->
<table width="100%" cellpadding="3" cellspacing="0" class="tableBorder">
<tr>
  <th colspan="4">Actual</th>
</tr>
<tr>
  <td>
    <impact:validateSelect label="Actual Eligibility"
                           tabIndex="<%= tabIndex++ %>"
                           required="true"
                           disabled='<%= "" + actualEligibilityDisabled %>'
                           codesTable="<%= ELIGIBILITY_CODE_TABLE %>"
                           name="<%= EligibilitySummaryDB.CD_ELIG_ACTUAL %>"
                           width="20%"
                           value="<%= eligibilitySummaryDB.getCdEligActual() %>"/>
  </td>
</tr>
<tr>
  <th colspan="4">Reimbursability</th>
</tr>
<tr>
  <td class="formlabel">SSI:</td>
  <td><%= FormattingHelper.formatMoney(eligibilitySummaryDB.getAmtSsi()) %>
  </td>
    <td colspan="2">&nbsp;</td>
 <tr>
  <td class="formlabel">SUCCESS Class of Assistance Date:</td>
  <td><%= eligibilitySummaryDB.getDtSuccClassAssistanceString() %>
  </td>
  <td class="formlabel">SUCCESS Class of Assistance:</td>
  <td><%= StringHelper.isValid(eligibilitySummaryDB.getCdSuccessClassAssistance()) ? eligibilitySummaryDB.getCdSuccessClassAssistance() : "" %>
  </td>
  <tr>
    <td width="20%">
      <impact:validateSelect label="Selected Eligibility"
                             tabIndex="<%= tabIndex++ %>"
                             required="true"
                             disabled='<%= "" + selectedEligibilityDisabled %>'
                             codesTable="<%= ELIGIBILITY_CODE_TABLE %>"
                             name="<%= EligibilitySummaryDB.CD_ELIG_SELECTED %>"
                             value="<%= eligibilitySummaryDB.getCdEligSelected() %>"/>
    </td>
    <td width="20%">
      <impact:validateSelect label="Medicaid Class of Assistance"
                             tabIndex="<%= tabIndex++ %>"
                             conditionallyRequired="true"
                             disabled='<%= "" + medicaidEligibilityDisabled %>'
                             codesTable="<%= MEDICAID_ELIGIBILITY_CODE_TABLE %>"
                             name="<%= EligibilitySummaryDB.CD_ELIG_MED_ELIG_GROUP %>"
                             value="<%= eligibilitySummaryDB.getCdEligMedEligGroup() %>"/>
    </td>
  </tr>
  <tr>
    <th colspan="4"> Eligibility Dates</th>
  </tr>
  <tr>
    <td>
      <impact:validateDate tabIndex="<%= tabIndex++ %>"
                           size="10"
                           label="Start Date"
                           required="true"
                           disabled='<%= "" + startDateDisabled %>'
                           name="<%= EligibilitySummaryDB.DT_ELIG_START_STRING %>"
                           constraint="Date"
                           value="<%= eligibilitySummaryDB.getDtEligStartString() %>"/>
    </td>
    <td>
      <impact:validateDate tabIndex="<%= tabIndex++ %>"
                           size="10"
                           label="End Date"
                           name="<%= EligibilitySummaryDB.DT_ELIG_END_STRING %>"
                           disabled='<%= "" + endDateDisabled %>'
                           constraint="Date"
                           value="<%= eligibilitySummaryDB.getDtEligEndString() %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDate tabIndex="<%= tabIndex++ %>"
                           size="10"
                           label="Re-determination Date"
                           name="<%= EligibilitySummaryDB.DT_ELIG_REVIEW_STRING %>"
                           disabled='<%= "" + redeterminationDateDisabled %>'
                           constraint="Date"
                           value="<%= eligibilitySummaryDB.getDtEligReviewString() %>"/>
    </td>
    <td>
      <impact:validateSelect label="Reason"
                             tabIndex="<%= tabIndex++ %>"
                             conditionallyRequired="true"
                             disabled='<%= "" + eligibilityReasonDisabled %>'
                             codesTable="<%= REASON_ELIGIBILITY_CODE_TABLE %>"
                             name="<%= EligibilitySummaryDB.CD_FCE_ELIG_REASON %>"
                             value="<%= eligibilitySummaryDB.getCdFceEligReason() %>"/>
    </td>
  </tr>
  <tr>
    <td colspan="4">
      <table cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
        <tr>
          <th colspan="2">Child Support Referral</th>
        </tr>
        <tr>
          <td width="16%"><impact:validateInput
               name="<%= EligibilitySummaryDB.IND_ELIG_CSUP_SEND %>"
               label="Yes"
               checked='<%= eligibilitySummaryDB.getIndEligCsupSendString() %>'
               value="true"
               disabled='<%= "" + childSupportQuestionDisabled %>'
               type="radio"
               id="1"
               cssClass="formInput"
               onClick="populateCsupRefDate();"
               tabIndex="<%= tabIndex++ %>"/>
               <impact:validateInput
               name="<%= EligibilitySummaryDB.IND_ELIG_CSUP_SEND %>"
               label="No"
               checked='<%=  "" + ArchitectureConstants.FALSE.equals(eligibilitySummaryDB.getIndEligCsupSendString()) %>'
               value="false"
               disabled='<%= "" + childSupportQuestionDisabled %>'
               type="radio"
               id="2"
               cssClass="formInput"
               onClick="populateCsupRefDate();"
               tabIndex="<%= tabIndex++ %>"/></td>
          <td><span class="formCondRequiredText">&#135;</span>&nbsp;Is this child being referred to child support</td>
        </tr>
        <tr>
          <td>
            <impact:validateInput name="<%= EligibilitySummaryDB.DT_ELIG_CSUP_REFERRAL_STRING %>"
                              label="Date of Referral"
                              value="<%= eligibilitySummaryDB.getDtEligCsupReferralString() %>"
                              required="false"
                              type="text"
                              cssClass="formInput"
                              constraint="Date"
                              size="10"
                              maxLength="10"
                              disabled='<%= "" + childSupportReferralDateDisabled %>'
                              tabIndex="<%= tabIndex++ %>"/>
          </td>
       </tr>
       <tr>
         <td valign="top">
           <impact:validateTextArea label="Comments"
                               tabIndex="<%= tabIndex++ %>"
                               name="<%= EligibilitySummaryDB.TXT_CHILD_SUPP_REF_COMMENT %>"
                               maxLength="300"
                               constraint="Comments"
                               disabled='<%= "" + commentsDisabled1 %>'
                               conditionallyRequired="true"
                               rows="2"
                               cols="110"><%= eligibilitySummaryDB.getTxtChildSuppRefComment() %>
      </impact:validateTextArea>
    </td>
      </table>
    </td>
  </tr>
</table>
<br>
<table cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr>
    <th colspan="2">Foster Care Eligibility Approval</th>
  </tr>
  <tr>
    <td valign="top" width="20%">
      <impact:validateTextArea label="Comments"
                               tabIndex="<%= tabIndex++ %>"
                               name="<%= EligibilitySummaryDB.TXT_ELIG_COMMENT %>"
                               maxLength="300"
                               constraint="Comments"
                               disabled='<%= "" + commentsDisabled %>'
                               rows="2"
                               cols="110"><%= eligibilitySummaryDB.getTxtEligComment() %>
      </impact:validateTextArea>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput label="Password"
                            tabIndex="<%= tabIndex++ %>"
                            type="password"
                            name="password"
                            constraint="Password"
                            required="true"
                            disabled='<%= "" + passwordDisabled %>'
              />
    </td>
  </tr>
</table>
<br>
<hr>
<table cellspacing="0" cellpadding="3" width="100%">
  <tr>
   <td align="right">
      <impact:ButtonTag name="Save"
                        accessKey="S"
                        backSafe="true"
                        tabIndex='<%= tabIndex++ %>'
                        disabled='<%= "" + saveDisabled %>'
                        action='<%= EligibilitySummaryConversation.FCE_SUMMARY_SAVE %>'
                        function='<%= "return saveEligibilitySummary();" %>'
                        form='<%= formName %>'
                        img="btnSave"
                        editableMode='<%= EditableMode.EDIT %>'/>
    </td>
  </tr>
</table>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<input type="hidden" name="hdnPrevEligCSupSend" value="<%=isPrevEligCSupSend %>">



</impact:validateForm>
<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  <%  // SIR 19326 - Do not call isDirty() for modifiable textarea when saveDisabled is true
    if ( !saveDisabled ) {
  %>
  window.onbeforeunload = function() {
    return IsDirty();
  }
  <% } %>

  function promptToIgnoreErrorMessages() {
  <%
  //MDM: I could figure out which one of these my error message was supposed to go in
  // and then have the architecture change and none of this work:
  //   FormValidation form = (FormValidation) request.getAttribute(formName);
  //   Map errorMessages = form.getErrorMessages();
  //   Map nonValidationErrorMessages = (Map) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
  //   Map informationalMessages = (Map) request.getAttribute(BasePrsConversation.INFO_MESSAGES);
  //MDM: OR I can rely on variables explicitly set in the conversation (I choose to do this):

   Set ignoreMessages = EligibilitySummaryConversation.getIgnoreMessages(request);
   Set errorCodes = EligibilitySummaryConversation.getErrorCodes(request);
   Set checkConfirmationErrorCodes = new HashSet();
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_AFFECT_PYMT));
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_GAP_EXISTS_1));
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_GAP_EXISTS_2));
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_GAP_EXISTS_3));

   //performs intersection of errorCodes and checkConfirmationErrorCodes
   errorCodes.retainAll(checkConfirmationErrorCodes);

   if (errorCodes.isEmpty()) {
     out.println("return;");
   }

   Iterator it = errorCodes.iterator();
   while (it.hasNext()) {
     Integer integer = (Integer) it.next();
     int errorCode = integer;
     String errorMessage = MessageLookup.getMessageByNumber(errorCode);

     out.println(" if (confirm(\"" + errorMessage + "\") == false)");
     out.println(" {");
     out.println("   return;");
     out.println(" }");
   }

   String ignoreAllUrl = EligibilitySummaryConversation.FCE_SUMMARY_SAVE + "?";
   errorCodes.addAll(ignoreMessages);

   it = errorCodes.iterator();
   while (it.hasNext()) {
     Integer integer = (Integer) it.next();
     int errorCode = integer;

     ignoreAllUrl += "ignoreMessage=" + errorCode + "&";
   }
  %>
    enableValidation("<%= formName %>");
    submitValidateForm('<%= formName %>', '<%= ignoreAllUrl %>');

  }

  window.onload = function ()
  {
    if (<%=showCSupRefOutboundErrors%>) {
      alert('<%=hdnCSupRefOutboundErrors%>');
    }
    promptToIgnoreErrorMessages();
  };
  
</script>
<%
  //SIR 23283 - Added && age > 16 to if statement to avoid a javascript error.
  //Sir 23012 Show informational Message about setting the review date if event
  //is in New Status
  int age = DateHelper.getAge(eligibilitySummaryDB.getDtChildBirth());
  if (eventStatus.equals(EventHelper.NEW_EVENT) && age > 16) {
%>
<script type="text/javascript" language="JavaScript">
  if (over17 == true) {
    var sTotalMsgInfo = "<%= MessageLookup.getMessageByNumber (Messages.MSG_FCE_SPECIAL_REVIEW)%>";
    displayInfoMsgs(sTotalMsgInfo, EligibilitySummary);
  }
  <%
    //SIR 23719 - Changed over20 to overMaxAge and changed Error message Name
  %>
  if (overMaxAge == true) {
    var sTotalMsgInfo = "<%= MessageLookup.getMessageByNumber (Messages.MSG_FCE_DENIED_MAX_AGE)%>";
    displayInfoMsgs(sTotalMsgInfo, EligibilitySummary);
  }
</script>
<%
  }
%>