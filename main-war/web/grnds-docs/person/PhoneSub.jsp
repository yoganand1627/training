<%
//*-----------------------------------------------------------------------------
//*      JSP Name: Phone Sub
//*  Created by:   Matthew McClain
//*  Date Created: 03/01/2003
//*
//*   General:
//*   ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE
//*  PhoneSub.jsp--Mobile FOR NECESSARY MOBILE CHANGES
//*
//*  Description:
//*  The Phone List/Detail sub-module will provide an application-wide facility
//*  for users to store multiple phone numbers for persons (e.g., principals,
//*  collaterals, employees).  The information will be an expandable section on
//*  the including page and will display a list of the phone numbers for a given
//*  person.
//*
//*  Change History:
//*  Date      User           Description
//*  --------  -------------  --------------------------------------------------
//*  07/01/03  GRIMSHAN       SIR 18659 if there is no phone avaliable, put in
//*                           spaces so that a hyperlink will still appear.
//*  08/06/03  Todd Reser     Added Description.
//*  08/15/04  RIOSJA         SIR 19126 - If a string from the database is used
//*                           to create a JavaScript object and the string contains
//*                           a newline character (\n), the newline character must
//*                           be replaced with its string equivalent ("\\n") before
//*                           assigning it to the JavaScript object; otherwise an
//*                           Unterminated String Contstant error will occur since
//*                           the newline character causes the string to split onto
//*                           separate lines.
//*  12/31/03 RIOSJA          SIR 22456 - Updated "addPhone()" JavaScript function
//*                           to use the constant defined in PhoneConversation
//*                           (PhoneConversation.PAGE_MODE) when accessing the
//*                           hidden field that contains the page mode to be used
//*                           for the submodule.
//*  08/26/05  floresrj        SIR 23936 Modified to reconcile both IMPACT and Mobile versions.
//*                            Implemented Mobile Phase II changes in IMPACT.  The Mobile
//*                           version of PhoneSub.jsp  is scheduled to no longer be used
//*                           in the future, since the problem with submodules has been
//*                           resolved. ****** But until such notice, any changes to either
//*                           version must be duplicated in the other PhoneSub.jsp file *****.
//* 08/29/05   anandv          Added MOBILE-IMPACT comments at the General section.
//*
//*-----------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation"%>
<%@ page import="org.exolab.castor.types.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  // Because this is a submodule, tabIndexes are relative.
  String tabIndexString = (String) request.getAttribute("tabIndex");

  int tabIndex = PhoneConversation.stringToInt(tabIndexString);

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  String parentPage = (String)
    state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY,
                       request);

  String formName = (String)
    request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);

  String phoneExpandableSectionLabel = (String)
    request.getAttribute(PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL);

  if ((phoneExpandableSectionLabel == null) ||
      ("".equals(phoneExpandableSectionLabel.trim())))
  {
    phoneExpandableSectionLabel = "Phone";
  }

  List list = (List) request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_PHONES);

  String pageMode = (String) request.getAttribute(PhoneSubmoduleConversation.PAGE_MODE);

  boolean navAwayCk =
    StringHelper.isTrue((String) request.getAttribute(ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME));

  String phoneArrayName = (String)
    request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_NAME);

  if (phoneArrayName == null)
  {
    phoneArrayName = "phoneArray";
  }
%>

<script type="text/javascript" language="JavaScript1.2">
  var <%= phoneArrayName %> = new Array(<%= list.size() %>);
<%
  int i = -1;
  Iterator iterator = list.iterator();
  while (iterator.hasNext())
  {
    i++;
    PhoneDB phoneDB = (PhoneDB) iterator.next();
%>
    <%= phoneArrayName %>[<%= i %>] = new Object();
    <%= phoneArrayName %>[<%= i %>].comments = "<%=
        FormattingHelper.formatStringConvertTabNewLineToString
        (FormattingHelper.formatStringSpecialChars(phoneDB.getComments(), "\\\"")) %>";
    <%= phoneArrayName %>[<%= i %>].endDate = "<%= phoneDB.getEndDateString() %>";
    <%= phoneArrayName %>[<%= i %>].extension = "<%= phoneDB.getExtension() %>";
    <%= phoneArrayName %>[<%= i %>].invalid = "<%= phoneDB.getInvalid() %>";
    <%= phoneArrayName %>[<%= i %>].lastUpdate = "<%= phoneDB.getLastUpdateTime() %>";
    <%= phoneArrayName %>[<%= i %>].number = "<%= phoneDB.getNumber() %>";
    <%= phoneArrayName %>[<%= i %>].phoneId = "<%= phoneDB.getPhoneId() %>";
    <%= phoneArrayName %>[<%= i %>].phoneType = "<%= phoneDB.getPhoneType() %>";
    <%= phoneArrayName %>[<%= i %>].primary = "<%= phoneDB.getPrimary() %>";
    <%= phoneArrayName %>[<%= i %>].startDate = "<%= phoneDB.getStartDateString() %>";
<%
  }
%>
</script>


<impact:ifThen test="<%= (request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_CREATED_FORM_FIELDS) == null) %>">
  <script type="text/javascript" language="JavaScript1.2">
  function submitPhoneDetail(phoneArrayName, phoneIndex)
  {
    var form = document.all["<%= formName %>"];
    form.phonePersonId.value = eval("form." + phoneArrayName + "_phonePersonId.value");
    form.phonePersonName.value = eval("form." + phoneArrayName + "_phonePersonName.value");
    form.phoneComments.value = eval(phoneArrayName + "[" + phoneIndex + "].comments");
    form.phoneEndDate.value = eval(phoneArrayName + "[" + phoneIndex + "].endDate");
    form.phoneExtension.value = eval(phoneArrayName + "[" + phoneIndex + "].extension");
    form.phoneInvalid.value = eval(phoneArrayName + "[" + phoneIndex + "].invalid");
    form.phoneLastUpdate.value = eval(phoneArrayName + "[" + phoneIndex + "].lastUpdate");
    form.phoneNumber.value = eval(phoneArrayName + "[" + phoneIndex + "].number");
    form.phoneId.value = eval(phoneArrayName + "[" + phoneIndex + "].phoneId");
    form.phoneType.value = eval(phoneArrayName + "[" + phoneIndex + "].phoneType");
    form.phonePrimary.value = eval(phoneArrayName + "[" + phoneIndex + "].primary");
    form.phoneStartDate.value = eval(phoneArrayName + "[" + phoneIndex + "].startDate");
    disableValidation("<%= formName %>");
    submitValidateForm('<%= formName %>','<%= PhoneConversation.PHONE_DETAIL %>');
  }


  function addPhone(phoneArrayName)
  {
    var form = document.all["<%= formName %>"];
    form.phonePersonId.value = eval("form." + phoneArrayName + "_phonePersonId.value");
    form.phonePersonName.value = eval("form." + phoneArrayName + "_phonePersonName.value");
    form.<%= PhoneConversation.PAGE_MODE %>.value = "<%= PageModeConstants.EDIT %>";
    form.phoneComments.value = "";
    form.phoneEndDate.value = "";
    form.phoneExtension.value = "";
    form.phoneInvalid.value = "";
    form.phoneLastUpdate.value = "";
    form.phoneNumber.value = "";
    form.phoneId.value = "0";
    form.phoneType.value = "";
    form.phonePrimary.value = "";
    form.phoneStartDate.value = "";
    disableValidation("<%= formName %>");
    return true;
  }
  </script>

  <impact:validateInput type="hidden" name="<%=PhoneConversation.PAGE_MODE%>" value="<%= pageMode %>"/>
  <impact:validateInput type="hidden" name="phonePersonId" value=""/>
  <impact:validateInput type="hidden" name="phonePersonName" value=""/>
  <impact:validateInput type="hidden" name="phoneComments" value=""/>
  <impact:validateInput type="hidden" name="phoneEndDate" value=""/>
  <impact:validateInput type="hidden" name="phoneExtension" value=""/>
  <impact:validateInput type="hidden" name="phoneInvalid" value=""/>
  <impact:validateInput type="hidden" name="phoneLastUpdate" value=""/>
  <impact:validateInput type="hidden" name="phoneNumber" value=""/>
  <impact:validateInput type="hidden" name="phoneId" value=""/>
  <impact:validateInput type="hidden" name="phoneType" value=""/>
  <impact:validateInput type="hidden" name="phonePrimary" value=""/>
  <impact:validateInput type="hidden" name="phoneStartDate" value=""/>
  <impact:validateInput type="hidden" name="<%= PhoneConversation.RETURN_URL %>" value="<%= parentPage %>"/>
</impact:ifThen>

  <impact:validateInput type="hidden"
                        name='<%= phoneArrayName + "_phonePersonId" %>'
                        value='<%= (String) request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_PERSON_ID) %>'/>

  <impact:validateInput type="hidden"
                        name='<%= phoneArrayName + "_phonePersonName" %>'
                        value='<%= (String) request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_PERSON_NAME) %>'/>

  <impact:ExpandableSectionTag
    id="<%= phoneArrayName + 0 %>"
    name="<%= phoneArrayName %>"
    label="<%= phoneExpandableSectionLabel %>"
    tabIndex="<%= tabIndex %>" >

    <div id="phoneSubScrollBar" style="height:165;width:100%;overflow:auto" class="tableBorderList">
      <table border="0" cellspacing="0" cellpadding="3" width="100%">
        <tr>
          <th class="thList">Primary</th>
          <th class="thList">Invalid</th>
          <th class="thList">Type</th>
          <th class="thList">Number</th>
          <th class="thList">Extension</th>
          <th class="thList">Start Date</th>
          <th class="thList">End Date</th>
          <th class="thList">Comments</th>
        </tr>
<%
        i = -1;
        if (list.isEmpty())
        {
%>
          <tr>
            <td colspan="8" class="odd">
              <%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %>
            </td>
          </tr>
<%
        }
        else
        {
          iterator = list.iterator();
          while (iterator.hasNext())
          {
            i++;
            PhoneDB phoneDB = (PhoneDB) iterator.next();
            String trClass = "class=\"odd\"";
            if (i % 2 == 1)
            {
              trClass = "class=\"even\"";
            }
            String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
            String UNCHECKED = "&nbsp;";
%>
            <tr <%= trClass %>>
              <td><%= phoneDB.getPrimary() ? CHECKED : UNCHECKED %></td>
              <td><%= phoneDB.getInvalid() ? CHECKED : UNCHECKED %></td>
               <td><a id="<%= phoneArrayName + i %>"
                tabIndex="<%= tabIndex %>"
                href='javascript:submitPhoneDetail("<%= phoneArrayName %>", "<%= i %>");'<% if (!navAwayCk) { %> onClick="setIsDirtyCalled(true);"<% } %>
                 ><%= Lookup.simpleDecodeSafe("CPHNTYP", phoneDB.getPhoneType()) %></td>
              <!-- SIR 23936  -->
            <impact:ifServerImpact>
                <td>
        <% // SIR 18659 If there is no phone number available, put in spaces so
                // the link will still appear.
                if (phoneDB.getNumber() == null || "".equals( phoneDB.getNumber())) { %>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <% } else { %>
                <%= FormattingHelper.formatPhone(phoneDB.getNumber()) %>
                <% } %></td>
             </impact:ifServerImpact>
           <impact:ifMobileImpact>
               <td>
                   <% if (phoneDB.getNumber() == null || "".equals( phoneDB.getNumber() ) )
                      { %>
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <%} else
                       { %>
                         <%= FormattingHelper.formatPhone(phoneDB.getNumber()) %>
                    <% }
                    %>
               </td>
            </impact:ifMobileImpact>
              <td><%= phoneDB.getExtension()!= null ? phoneDB.getExtension():StringHelper.EMPTY_STRING  %></td>
              <td><%= phoneDB.getStartDateString() %></td>
                  <%
                  Date endDate = DateHelper.toCastorDate( phoneDB.getEndDateString() );
                  if (endDate==null || DateHelper.MAX_CASTOR_DATE.equals(endDate) )
                  {
                %>
                  <td>&nbsp;</td>
                <% } else
                     { %>
                      <td><%= phoneDB.getEndDateString() %></td>
                   <%}%>
                  
        <td><%= phoneDB.getComments()!= null ? phoneDB.getComments():StringHelper.EMPTY_STRING  %></td>
<%
          } // end while (iterator.hasNext())
        }
%>
      </table>
    </div>

<%
    if (PageModeConstants.EDIT.equals(pageMode))
    {
      String functionToCall = "return addPhone('" + phoneArrayName + "');";
%>
      <table width="100%">
        <tr>
          <td align="right">
         <impact:ifServerImpact>
            <impact:ButtonTag
              name="AddPhone"
              tabIndex='<%= tabIndex %>'
              action='<%= PhoneConversation.PHONE_DETAIL %>'
              form='<%= formName %>'
              function='<%= functionToCall %>'
              navAwayCk='<%=navAwayCk%>'
              editableMode="<%= EditableMode.ALL %>"
              img="btnAdd"/>
         </impact:ifServerImpact>
          </td>
        </tr>
      </table>
<%
    }
%>
  </impact:ExpandableSectionTag>
