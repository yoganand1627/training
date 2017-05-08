<%--
/**
 * The Codes Tables List JSP displays a list of modifiable code types along with the type 
 * of update that can be performed on that code type and a brief description of the code type. <p/> <p/>
 * <pre>
 *                          Change History:
 *                           Date          User                    Description
 *                           ----------    --------------------    ----------------------
 *                           07/14/2008     vdevarakonda           Initial JSP creation
 */
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CodeTypesRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY); 
   
   int tabIndex = 1;
   String pageMode = PageModeConstants.EDIT;
   List<CodeTypesRetrieveSO> codeTypesList = (List<CodeTypesRetrieveSO>) state.getAttribute("codeTypesList", request);
%>
<impact:validateErrors/>
<script type="text/javascript" language="javascript">
  function setArrayIndex(codeType)
  {
    frmCodesTablesList.hdnCodeType.value = codeType;
  }
  function edit()
  {
    var bChecked = false;
    var rs = <%= codeTypesList.size() %>;
      if ( rs <= 1 )
      {
        if ( frmCodesTablesList.rbRowsIndex.checked == false )
        {
          alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
        }
        else
        {
          bChecked = true;
        }

      } else {

        for ( var i = 0; i < rs; i++ )
        {
          if (frmCodesTablesList.rbRowsIndex[i].checked)
          {
             bChecked = true;
          }
        }

        if ( bChecked == false )
        {
          alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
        }
      }
      return bChecked;
  }
</script>
<impact:validateForm 
    name="frmCodesTablesList"
    method="post"
    pageMode="<%= pageMode %>"
    action="/admin/CodesTablesMnt/displayCodesTablesList"
    schema="/WEB-INF/Constraints.xsd">
    <impact:validateInput type="hidden" name="hdnCodeType" value= "" />
    <div id="scrollBar2" style="height:210px;width:100%;overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
		<tr>
			<th class="thList">&nbsp;</th>
			<th class="thList">Codes Table Name</th>
			<th class="thList">Transaction Type</th>
			<th class="thList">Description</th>
		</tr>
<% if(codeTypesList !=null && codeTypesList.size()>0){
int loopCount = 0;
Iterator<CodeTypesRetrieveSO> it = codeTypesList.iterator();
while(it.hasNext()){
       CodeTypesRetrieveSO codeTypesRetrieveSO = (CodeTypesRetrieveSO)it.next();
       String onClick = "setArrayIndex( '" + codeTypesRetrieveSO.getCodeType() + "')";
%>
		<tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
			<td>
				<impact:validateInput 
				    type="radio" 
				    name="rbRowsIndex" 
				    value="<%= String.valueOf( loopCount )%>" 
				    onClick="<%= onClick %>" 
				    tabIndex="<%= tabIndex++ %>" 
				    cssClass="formInput"/>
			</td>
			<td><%= FormattingHelper.formatString(codeTypesRetrieveSO.getCodeType()) %></td>
			<td><%= FormattingHelper.formatString( Lookup.simpleDecodeSafe(CodesTables.CCTUPDT, codeTypesRetrieveSO.getTransType())) %></td>                          
			<td><%= FormattingHelper.formatString( codeTypesRetrieveSO.getDesc() ) %></td>
		</tr>
 <%} 
 } %>
	</table>
	</div>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td class="alignRight" width="6%">
				<impact:ButtonTag 
				    name="Edit"
				    restrictRepost="true"
				    tabIndex='<%= tabIndex++ %>'
				    action="/admin/CodesTablesMnt/displayCodesTableDetail"
				    disabled="false"
				    function="return edit();"
				    form="frmCodesTablesList"
				    img="btnEdit"
				    editableMode='<%= EditableMode.EDIT %>'/>
			</td>
		</tr>
	</table>
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
