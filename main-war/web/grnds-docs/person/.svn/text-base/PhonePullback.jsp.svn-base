<%
//*-----------------------------------------------------------------------------
//*      JSP Name:     Phone Pullback
//*  Created by:   Matthew McClain
//*  Date Created: 03/01/2003
//*
//*  Description:
//*  The Phone Pullback List portion of the Phone List/Detail Sub-module exists
//*  in the modify mode only.  It will provide a facility for users to copy
//*  phone numbers for persons sharing phones, such as the multiple members of
//*  families involved together in an IMPACT stage context.
//*
//*      Change History:
//*      Date      User              Description
//*  --------  ----------------  -----------------------------------------------
//*  08/06/03  Todd Reser        Removed commented out code.  Added Description.
//*-----------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
int tabIndex = 1;
String formName = "PhonePullback";
String returnUrl = request.getParameter(PhoneConversation.RETURN_URL);

List list = (List)
    request.getAttribute(PhoneConversation.PHONE_PULLBACK_PHONES);
%>


<script type="text/javascript" language="JavaScript1.2">
<!--Insert Java Script here
function selectRow( number, extension , type, comments )
{
    var form = document.all["<%= formName %>"];
    form.phoneNumber.value = number;
    form.phoneExtension.value = extension;
    form.phoneType.value = type;
    //comments dont get copied over, i put this here just in case they wanted it woudl be easier to add.
    form.phoneComments.value = comments;
}
//End Java Script-->
</script>


<impact:validateForm
        name="<%= formName %>"
        method="post"
        action="<%= PhoneConversation.PHONE_DETAIL %>"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.PhonePullbackCustomValidation"
        schema="/WEB-INF/Constraints.xsd"
        pageMode="<%= PageModeConstants.EDIT %>">

<impact:validateErrors/>


<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
        <tr>
          <th width="20" class="thList">&nbsp;</th>
          <th class="thList">Full Name</th>
          <th class="thList">Primary</th>
          <th class="thList">Type</th>
          <th class="thList">Number</th>
          <th class="thList">Extension</th>
          <th class="thList">Start Date</th>
        </tr>
<%
String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
String UNCHECKED = "&nbsp;";

Iterator iterator = list.iterator();
int i = -1;
while (iterator.hasNext())
{
    i++;
    PhoneDB phoneDB = (PhoneDB) iterator.next();
    String trClass = "class=\"odd\"";
    if (i % 2 == 1)
    {
      trClass = "class=\"even\"";
    }
    String onClick =
        "javascript:selectRow('" +
        phoneDB.getNumber() + "', '" +
        phoneDB.getExtension() + "', '" +
        phoneDB.getPhoneType() + "', '" +
        phoneDB.getComments() + "')";
%>
        <tr <%= trClass %>>
          <td>
             <impact:validateInput tabIndex="<%= tabIndex++ %>"
                    type="radio"
                    name="existingPhone"
                    value='<%= "" + phoneDB.getPhoneId() %>'
                    onClick='<%= onClick %>'/></td>
          <td><%= phoneDB.getPersonFullName() %></td>
          <td><%= phoneDB.getPrimary() ? CHECKED : UNCHECKED %></td>
          <td><%= Lookup.simpleDecodeSafe("CPHNTYP", phoneDB.getPhoneType()) %></td>
          <td><%= FormattingHelper.formatPhone(phoneDB.getNumber()) %></td>
          <td><%= PhoneConversation.safeString(phoneDB.getExtension()) %></td>
          <td><%= DateHelper.toString(phoneDB.getStartDate(), DateHelper.SLASH_FORMAT) %></td>
        </tr>
<%
}
%>
</table>
<table width="100%">
 <tr>
  <td align="right">
<impact:ButtonTag name="Continue"
                  tabIndex='<%= tabIndex++ %>'
                  action='<%= PhoneConversation.PHONE_DETAIL %>'
                  form='<%= formName %>'
                  img="btnContinue"
                  editableMode='<%= EditableMode.EDIT %>' />
  </td>
 </tr>
</table>


<impact:validateInput type="hidden" name="<%= PhoneConversation.RETURN_URL %>" value="<%= returnUrl %>"/>
<impact:validateInput type="hidden" name="phoneNumber"/>
<impact:validateInput type="hidden" name="phoneExtension"/>
<impact:validateInput type="hidden" name="phoneType"/>
<impact:validateInput type="hidden" name="phoneComments"/>
<impact:validateInput type="hidden" name="count" value='<%= "" + list.size() %>'/>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>
