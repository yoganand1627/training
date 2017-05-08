<%
/**
 * JSP Name: PhoneSubHolder
 * Created by:   Matthew McClain
 * Date Created: 12/13/2002
 *
 * Description:
 * This Stub page is an example page to show how to use PhoneSub in your page.
**/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
//    PageMode.setPageMode(PageMode.EDIT, request);
// PageMode.setPageMode(PageMode.VIEW, request);
  String pageMode = PageMode.getPageMode(request);
  String formName = "PhoneSubHolder";
  int tabIndex = 1;
%>

<table border="0" width="760" cellpadding="2" cellspacing="0">
  <tr>
    <td width="760" height="800" valign="top" align="left">

<impact:validateForm
        name="<%= formName %>"
        method="post"
        action="/not/a/real/link"
        schema="/WEB-INF/Constraints.xsd"
        pageMode="<%= pageMode %>">

<impact:include page='<%= PhoneSubmoduleConversation.PHONE_SUB %>'
                callingPage='<%= PhoneConversation.PHONE_SUB_HOLDER %>'
                tabIndex="<%= tabIndex++ %>"
                includingForm="<%= formName %>">

<!-- attributes are optional -->
<!-- by default, submodule will just print "Phone"; which was the original design -->
  <impact:attribute name="<%= PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL %>"
                    value='<%= "Phone <!-- I am a hidden demonstration of the optional title attribute -->" %>'/>

<!-- by default, submodule will just use PageMode.getPageMode(request) -->
  <impact:attribute name="<%= PhoneSubmoduleConversation.PAGE_MODE %>"
                    value='<%= PageModeConstants.EDIT %>'/>
</impact:include>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

</td>
</tr>
</table>


<script language="javascript">
//!!! nice for testing
expandCollapsed('expandedphoneTag', 'collapsedphoneTag');
</script>
