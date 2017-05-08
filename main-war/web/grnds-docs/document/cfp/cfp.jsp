<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.util.Set"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>

<%
try
{
  int tabIndex = 1;
  String formName = "cfp";
  StageDB stageDB = (StageDB) request.getAttribute(CfpConversation.CFP_STAGE);

  DocumentTypeDB[] documentTypes = (DocumentTypeDB[])
    request.getAttribute(CfpConversation.CFP_DOCUMENT_TYPES);
%>

<%@ include file="/grnds-docs/document/cfp/OpenQueueStatus.jsp" %>

<script type="text/javascript" language="JavaScript1.2">
<!--Insert Java Script here
function selectAll()
{
  var cfpForm = document.all['<%= formName %>'];
  for (var i = 0; i < cfpForm.outputCode.length; i++)
  {
    cfpForm.outputCode[i].checked = true;
  }
  return false;
}


function deselectAll()
{
  var cfpForm = document.all['<%= formName %>'];
  for (var i = 0; i < cfpForm.outputCode.length; i++)
  {
    cfpForm.outputCode[i].checked = false;
  }
  return false;
}
//End Java Script-->
</script>


<impact:validateForm name="<%= formName %>"
                     action='<%= CfpConversation.SUBMIT_CFP %>'
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden"
                        name="<%= ServerSideValidationUtility.FORM_VALIDATION_PREV_URL %>"
                        value="<%= ContextHelper.getStringSafe(request, ServerSideValidationUtility.FORM_VALIDATION_PREV_URL) %>"/>

<impact:validateErrors/>
<table border="0" width="100%" cellpadding="3" cellspacing="0" class="tableBorder">
  <tr>
    <th colspan="2">Type</th>
  </tr>
  <tr>
    <td colspan="2">
      <table width="100%" cellpadding="0" cellspacing="0" border="0">
       <tr>
         <td class="formLabel" width="70">Program:</td>
         <td><%= stageDB.getProgramName() %></td>

<impact:ifThen test="<%= stageDB.getStageCode() != null %>">
         <td class="formLabel" width="60">Stage:</td>
         <td><%= Lookup.simpleDecodeSafe("CSTAGES", stageDB.getStageCode()) %></td>
</impact:ifThen>
       </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <table width="100%" cellpadding="3" cellspacing="0">
        <tr>
          <th class="thList" colspan="2">Outputs</th>
        </tr>
      </table>
      <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
          <td>
            <div id="reports" style="height:155; width:100%; overflow:auto" class="tableborderList">
              <table width="100%" cellpadding="3" cellspacing="0">
<%
  String[] outputCodes = (String[])
  request.getAttribute(CfpConversation.CFP_OUTPUT_CODES);

  Set outputCodesSet = CfpConversation.arrayToSet(outputCodes);

  for (int i = 0; i < documentTypes.length; i++)
  {
    String outputCode = documentTypes[i].getOutputCode();
    String checked = "";
    if (outputCodesSet.contains(outputCode))
    {
      checked = "checked";
    }
    String trClass = "odd";
    if (i % 2 == 1)
    {
      trClass = "even";
    }
%>
    <tr class="<%= trClass %>"><!-- used regular checkboxes here so I can get array of selected -->
      <td><input tabIndex="<%= tabIndex++ %>"
                 type="checkbox"
                 <%= checked %>
                 name="outputCode"
                 value="<%= outputCode %>"/></td>
      <td colspan="2"><%= documentTypes[i].getOutputName() %></td>
    </tr>
<%
  }
%>
              </table>
            </div>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td>
      <impact:ButtonTag name="QueueStatus"
                        tabIndex='<%= tabIndex++ %>'
                        function='return openQueueStatus();'
                        action='/not/a/real/path'
                        form='<%= formName %>'
                        img="btnQueueViewer"
                        editableMode='<%= EditableMode.EDIT %>' />
    </td>
    <td class="alignRight">
      <impact:ButtonTag name="SelectAll"
                        tabIndex='<%= tabIndex++ %>'
                        function='return selectAll();'
                        action='/not/a/real/path'
                        form='<%= formName %>'
                        img="btnSelectAll"
                        editableMode='<%= EditableMode.EDIT %>' />

      <impact:ButtonTag name="DeselectAll"
                        tabIndex='<%= tabIndex++ %>'
                        function='return deselectAll();'
                        action='/not/a/real/path'
                        form='<%= formName %>'
                        img="btnDeselectAll"
                        editableMode='<%= EditableMode.EDIT %>' />

      <impact:ButtonTag name="Launch"
                        tabIndex='<%= tabIndex++ %>'
                        action='<%= CfpConversation.SUBMIT_CFP %>'
                        form='<%= formName %>'
                        img="btnLaunch"
                        editableMode='<%= EditableMode.EDIT %>' />
    </td>
  </tr>
</table>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>
<%
}
catch(Throwable e)
{
  out.println("<pre>");
  e.printStackTrace(new PrintWriter(out));
  out.println("</pre>");
}
%>
