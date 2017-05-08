<%--
/**
 * The Code Detail JSP displays code, decode and end date values for the selected code on the 
 * Codes Table Detail page. <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date          User                    Description
 *                           ----------    --------------------    ----------------------
 *                           07/21/2008     Vishala Devarakonda    Initial JSP creation
 */
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTablesStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="java.util.Date"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  int tabIndex = 1;
  String pageMode = PageModeConstants.EDIT;
  CodesTableDetailRetrieveSO codesTblDtlReteSO = (CodesTableDetailRetrieveSO) state
                                                                                   .getAttribute(
                                                                                                 "codesTableDetailRetrieveSO",
                                                                                                 request);
  String indAdd = FormattingHelper.formatString((String) state.getAttribute("indAdd", request));
  String codeType = "";
  String transType = "";
  String description = "";
  String code = "";
  String decode = "";
  Date dtEnd = null;
  String codeDisabled = "true";
  String dtEndDisabled = "false";
  if (codesTblDtlReteSO != null) {
    codeType = FormattingHelper.formatString(codesTblDtlReteSO.getCodeType());
    transType = FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCTUPDT,
                                                                      codesTblDtlReteSO.getTransType()));
    description = FormattingHelper.formatString(codesTblDtlReteSO.getDesc());
    if (codesTblDtlReteSO.getCodesTablesStructList() != null && codesTblDtlReteSO.getCodesTablesStructList().size() > 0
        && codesTblDtlReteSO.getCodesTablesStructList().get(0) != null) {
      CodesTablesStruct cdTblStruct = codesTblDtlReteSO.getCodesTablesStructList().get(0);
      code = FormattingHelper.formatString(cdTblStruct.getCode());
      decode = FormattingHelper.formatString(cdTblStruct.getDecode());
      dtEnd = cdTblStruct.getEndDate();
    } else {
      if (CodesTables.CCTUPDT_F.equals(codesTblDtlReteSO.getTransType())) {
        codeDisabled = "false";
      }
    }
    if (CodesTables.CCTUPDT_L.equals(codesTblDtlReteSO.getTransType())) {
      dtEndDisabled = "true";
    }
  }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript"  language="JavaScript1.2">
function setAddInd(ind)
  {
    frmCodeDetail.hdnIndAdd.value = ind;
    return true;
  }
window.onbeforeunload = function ()
 {
           IsDirty();
 };
</script>
<impact:validateForm 
    name="frmCodeDetail" 
    method="post"
	pageMode="<%=pageMode%>"
	action="/admin/CodesTablesMnt/saveCodeDetail"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.CodesTablesMntCustomValidation"
	schema="/WEB-INF/Constraints.xsd">
	
	<impact:validateInput type="hidden" name="hdnIndAdd" value= "" />
	<impact:validateErrors />
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th class="thList">&nbsp;</th>
			<th class="thList"></th>
			<th class="thList"></th>
			<th class="thList"></th>
		</tr>
		<tr>
			<td>
			<impact:validateDisplayOnlyField 
			    name="dspCodesTableName"
				label="Codes Table Name" 
				value="<%=codeType%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField 
				    name="dspTransType"
					label="Transaction Type" 
					value="<%=transType%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField 
				    name="dspDescription"
					label="Description" 
					value="<%=description%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput 
				    name="txtCode" 
				    label="Code"
					maxLength="20" 
					value="<%=code%>" 
					disabled="<%=codeDisabled%>" 
					constraint= "Paragraph30"
					required = "true"
					type="text"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea 
				    label="Decode" 
				    name="txtDecode" 
				    rows="3" cols="100" 
				    disabled="false"
				    constraint="Paragraph500" 
				    maxLength="370" 
				    required="true" 
				    tabIndex="<%= tabIndex++ %>">
				    <%=decode%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				    label="End Date" 
				    type="text" 
				    size="10"
					value="<%=FormattingHelper.formatDate(dtEnd)%>" 
					name="dtEndDate"
					disabled="<%=dtEndDisabled%>" 
					tabIndex="<%=tabIndex++%>" 
					constraint="Date" />
			</td>
		</tr>
	</table>
<%
  String function = "return setAddInd( '" + indAdd + "')";
%>
	<table border="0" cellpadding="3" class="tableNoBorder" width="100%">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag 
				    name="btnUpdateCancel" 
				    img="btnCancel"
					form="frmCodeDetail"
					action="/admin/CodesTablesMnt/displayCodesTableDetail"
					disabled="false" 
					function="disableValidation('frmCodeDetail');"
					tabIndex="<%=tabIndex++%>" />
					
				<impact:ButtonTag 
				    name="btnSave" 
				    img="btnSave" 
				    form="frmCodeDetail"
				    action="/admin/CodesTablesMnt/saveCodeDetail" 
				    disabled="false"
				    function = "<%=function%>"
				    tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
