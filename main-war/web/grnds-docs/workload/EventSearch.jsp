<%
  /**
   * JSP Name:     EventSearch.jsp
   * Created by:   Matt McClaim
   * Date Created: 12/17/02
   *
   * Description:
   * The Event Search page allows a user to search for events within the context
   * of a case, stage, or person.
   *
   **/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
  {
    int tabIndex = 1;
    String formName = "EventSearch";

    String caseName = GlobalData.getSzNmCase(request);
    String stageCode = GlobalData.getSzCdStage(request);

    EventSearchDB eventSearchDB = EventSearchConversation.getEventSearchDB(request);

    String personName = StringHelper.getNonNullString(eventSearchDB.getPersonName());
    String staffName = StringHelper.getNonNullString(eventSearchDB.getStaffName());
    String startDate = StringHelper.getNonNullString(eventSearchDB.getStartDateString());

    String endDate = eventSearchDB.getEndDateString();
    if (endDate == null) {
      endDate = FormattingHelper.formatDate(new Date());
    }
    List checkedEventTypes = eventSearchDB.getEventTypeCodesList();
    List checkedStages = eventSearchDB.getStageCodesList();

    //Matthew McClain 06/25/2003
    //EventSearch was designed to precheck the stage code of the
    //stage id being used; this really never limited the search
    //in any way; but with a couple radio buttons which limit
    //options either to case or stage, it'd be painful or confusing
    //to remember to either uncheck the stage type or have it done
    //automatically.
    boolean searchReturnedNoResults =
            EventSearchConversation.searchReturnedNoResults(request);
%>

<script type="text/javascript" language="JavaScript1.2">
  <!--Insert Java Script here
function promptToClear()
{
  var MSG_EVNT_SRCH_NO_RSLTS =
  "<%= MessageLookup.getMessageByNumber(Messages.MSG_EVNT_SRCH_NO_RSLTS) %>";

  var form = document.all[<%= formName %>];
  if (window.confirm(MSG_EVNT_SRCH_NO_RSLTS))
  {
    disableValidation("<%= formName %>");
    submitValidateForm('<%= formName %>',
                       '<%= EventSearchConversation.EVENT_SEARCH + "?clear=true" %>');
  }
}

<impact:ifThen test="<%= searchReturnedNoResults %>">
window.onload = function()
{
  promptToClear();
}
</impact:ifThen>


function openPersonList()
{
  var form = document.all["<%= formName %>"];
  disableValidation("<%= formName %>");
  return true;
}


function openStaffList()
{
  var form = document.all["<%= formName %>"];
  disableValidation("<%= formName %>");
  return true;
}
//End Java Script-->
</script>

<impact:validateForm name="<%= formName %>"
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchCustomValidation"
                     action='<%= EventSearchConversation.EVENT_LIST %>'
                     schema="/WEB-INF/Constraints.xsd">

<impact:validateErrors/>

<impact:validateInput type="hidden"
                      name='<%= EventSearchConversation.CALLER %>'
                      value='<%= EventSearchConversation.CALLER_EVENT_SEARCH %>'/>

<table border="0" width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td colspan="2"
        align="right"
        valign="bottom"><a tabIndex="<%= tabIndex++ %>" href="javascript:expandAll()">Expand All</a>
      <a tabIndex="<%= tabIndex++ %>" href="javascript:collapseAll()">Collapse All</a></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr>
    <th colspan="7">Search Criteria</th>
  </tr>

  <tr>
    <td class="formLabel" width="15%">Case Name:</td>
    <td width="33%"><%= caseName %></td>
    <td width="4%">&nbsp;</td>
    <td colspan="2">
      <impact:validateInput
              tabIndex="<%= tabIndex++ %>"
              label="Search Entire Case?"
              type="checkbox"
              id="searchEntireCase"
              name="searchEntireCase"
              checked='<%= "" + (eventSearchDB.getSearchEntireCase()) %>'
              value='true'/>
    </td>
  </tr>

  <tr>
    <td><impact:validateDate tabIndex="<%= tabIndex++ %>"
                             size="10"
                             label="Start Date"
                             name="startDate"
                             constraint="Date"
                             value="<%= startDate %>"/>
    </td>
    <td>&nbsp;</td>
    <td width="15%"><impact:validateDate tabIndex="<%= tabIndex++ %>"
                                         size="10"
                                         label="End Date"
                                         name="endDate"
                                         constraint="Date"
                                         value="<%= endDate %>"/>
    </td>
  </tr>
  <tr>
    <td class="formLabel">Person:</td>
    <td>
      <table border="0" width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <td width="70%"><%= personName %>&nbsp;</td>
          <td width="30%">
            <impact:ButtonTag name="PersonList"
                              accessKey="P"
                              align="left"
                              backSafe="true"
                              tabIndex='<%= tabIndex++ %>'
                              action='<%= EventSearchConversation.PERSON_LIST %>'
                              form='<%= formName %>'
                              function='<%= "return openPersonList();" %>'
                              img="btnSelectPerson"
                              editableMode='<%= EditableMode.EDIT %>'/>
          </td>
        </tr>
      </table>
    </td>
    <td>&nbsp;</td>
    <td class="formLabel">Staff:</td>
    <td>
      <table border="0" width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <td width="70%"><%= staffName %>&nbsp;</td>
          <td width="30%">
            <impact:ButtonTag name="StaffList"
                              accessKey="T"
                              backSafe="true"
                              align="left"
                              tabIndex='<%= tabIndex++ %>'
                              action='<%= EventSearchConversation.STAFF_LIST %>'
                              form='<%= formName %>'
                              function='<%= "return openStaffList();" %>'
                              img="btnSelectStaff"
                              editableMode='<%= EditableMode.EDIT %>'/>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<br>
<impact:ExpandableSectionTag id="eventTypeCode1" name="eventTypesTag" label="Event Types" tabIndex="<%= tabIndex++ %>">
  <table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
    <tr>
      <td class="subDetail">
        <impact:codesCheckbox tabIndex="<%= tabIndex++ %>"
                              defaultCodes="<%= checkedEventTypes %>"
                              name="eventTypeCode"
                              codesTableName="<%= CodesTables.CEVNTTYP %>"
                              orderBy="<%= CodesCheckboxesTag.DECODE %>"
                              columns="3"
                              isHorizontal="false"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<br>

<impact:ExpandableSectionTag id="stageCode1" name="stagesTag" label="Stages" tabIndex="<%= tabIndex++ %>">
  <%
    //ordering as in ccmn50w.win
     @SuppressWarnings("unchecked")
    List list = new ArrayList(16);
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_INT));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_INV));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_DIV));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_ADO));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_PAD));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_ARI));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_FAD));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_SUB));
    list.add(Lookup.decode(CodesTables.CSTAGES, CodesTables.CSTAGES_PFC));
  %>
  <table width="100%" cellspacing="0" cellpadding="3" class="tableBorder">
    <tr>
      <td class="subDetail">
        <impact:checkbox tabIndex="<%= tabIndex++ %>"
                         defaultValues="<%= checkedStages %>"
                         name="stageCode"
                         checkboxList="<%= list %>"
                         columns="3"
                         isHorizontal="false"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>

<%
  String enableValidation = "enableValidation('" + formName + "');";
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right" colspan="4">
      <impact:ButtonTag name="Search"
                        accessKey="S"
                        backSafe="true"
                        tabIndex='<%= tabIndex++ %>'
                        action='<%= EventSearchConversation.EVENT_LIST %>'
                        function='<%= enableValidation %>'
                        form='<%= formName %>'
                        img="btnSearch"
                        editableMode='<%= EditableMode.EDIT %>'/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>


<script type="text/javascript" language="JavaScript1.2">
  <impact:ifThen test='<%= (GlobalData.getUlIdStage(request) == 0) %>'>
  //Matthew McClain 06/26/2003
  //I didn't do this using the disabled attribute on the tag,
  //because that would rename the input field
  var form = document.all["<%= formName %>"];
  form.searchEntireCase.disabled = true;
  </impact:ifThen>
</script>


<%
  }
%>
