<%--
/**
 * The Codes Table Detail JSP displays all the code, decode and end date combinations of the 
 * code type selected on the Codes table List page. <p/> <p/>
 * 
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTablesStruct" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.CodesTablesMntConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  int tabIndex = 1;
  String pageMode = PageModeConstants.EDIT;
  CodesTableDetailRetrieveSO codesTableDtl = (CodesTableDetailRetrieveSO) state.getAttribute("codesTableDtl",
                                                                                             request);
  List<CodesTablesStruct> codesTblStructList = null;
  String codeType = "";
  String transType = "";
  String description = "";
  String disabled = "false";
  if (codesTableDtl != null) {
    codesTblStructList = codesTableDtl.getCodesTablesStructList();
    codeType = FormattingHelper.formatString(codesTableDtl.getCodeType());
    transType = FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCTUPDT,
                                                                      codesTableDtl.getTransType()));
    description = FormattingHelper.formatString(codesTableDtl.getDesc());
    if (CodesTables.CCTUPDT_L.equals(codesTableDtl.getTransType())) {
      disabled = "true";
    }
  }
  Iterator codeTblIterator = codesTblStructList != null ? codesTblStructList.iterator() : null;
%>
<script type="text/javascript" language="javascript">
function setArrayIndex(code)
  {
    frmCodesTableDetail.hdnCode.value = code;
  }
function edit()
{
    var bChecked = false;
    var rs = <%=codesTblStructList.size()%>;
      if ( rs <= 1 )
      {
        if ( frmCodesTableDetail.rbCodesTableDetail.checked == false )
        {
          alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
        }
        else
        {
          bChecked = true;
        }

      } else {

        for ( var i = 0; i < rs; i++ )
        {
          if (frmCodesTableDetail.rbCodesTableDetail[i].checked)
          {
             bChecked = true;
          }
        }

        if ( bChecked == false )
        {
          alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
        }
      }
      return bChecked;
  }
</script>
<impact:validateForm 
    name="frmCodesTableDetail"
    method="post"
    pageMode="<%=pageMode%>"
    action="/admin/CodesTablesMnt/displayCodesTableDetail"
    schema="/WEB-INF/Constraints.xsd" >
    
	<impact:validateInput type="hidden" name="hdnCode" value= "" />
    <impact:validateErrors/>
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
            value="<%=codeType%>"/>
            </td>
        </tr>
        <tr>
            <td>
            <impact:validateDisplayOnlyField 
            name="dspTransType" 
            label="Transaction Type" 
            value="<%=transType%>"/>
            </td>
        </tr>
        <tr>
            <td>
            <impact:validateDisplayOnlyField 
            name="dspDescription" 
            label="Description" 
            value="<%=description%>"/>
            </td>
        </tr>
    </table>
    <impact:pagination submitUrl="/admin/CodesTablesMnt/displayCodesTableDetail" >
    <div id="scrollBar2" style="height:210px;width:100%;overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">	
        <tr>
             <th class="thList" style="white-space: nowrap;">&nbsp;</th>
             <th class="thList" style="white-space: nowrap;">
            Code
       <impact:sortableColumnHeader orderBy="<%=CodesTablesMntConversation.SORT_BY_CODE%>" />
             </th>
             <th class="thList" style="white-space: nowrap;">
            Decode
       <impact:sortableColumnHeader orderBy="<%=CodesTablesMntConversation.SORT_BY_DECODE%>" />
             </th>
             <th class="thList" style="white-space: nowrap;">
          End Date
       <impact:sortableColumnHeader orderBy="<%=CodesTablesMntConversation.SORT_BY_END_DATE%>" />
             </th>
        </tr>
<%
  int counter = 0;
      if (codeTblIterator != null && codeTblIterator.hasNext()) {
        while (codeTblIterator.hasNext()) {
          CodesTablesStruct codesTablesStruct = (CodesTablesStruct) codeTblIterator.next();
          String radioId = "rbCodesTableDetail_" + counter;
          String onClick = "setArrayIndex( '" + codesTablesStruct.getCode() + "')";
%>
        <tr class="<%=FormattingHelper.getRowCss(counter + 1)%>" valign="top">
            <td>
            <impact:validateInput 
               type="radio" 
               id="<%=radioId%>" 
               tabIndex="<%=tabIndex++%>" 
               onClick="<%=onClick%>" 
               name="rbCodesTableDetail" 
               value="<%=String.valueOf(counter)%>"/>
            </td>
            <td><%=FormattingHelper.formatString(codesTablesStruct.getCode())%></td>
            <td><%=FormattingHelper.formatString(codesTablesStruct.getDecode())%></td>                          
            <td><%=FormattingHelper.formatDate(codesTablesStruct.getEndDate())%></td>
        </tr>

 <%
   }
       }
 %>
    </table>
    </div><% /* this is where the "scrollBar" div tag ends */ %>
    </impact:pagination>
    <table border="0" cellpadding="3" class="tableNoBorder" width="100%" >
        <tr>
            <td class="alignRight">
            <impact:ButtonTag
                name="btnUpdateCancel"
                img="btnCancel"
                form="frmCodesTableDetail"
                action="/admin/CodesTablesMnt/cancel"
                disabled="false"
                tabIndex="<%=tabIndex++%>"/>

            <impact:ButtonTag
                name="btnCodeEdit"
                img="btnEdit"
                form="frmCodesTableDetail"
                function="return edit();"
                action="/admin/CodesTablesMnt/displayCodeDetail"
                disabled="false"
                tabIndex="<%=tabIndex++%>"/>
            <impact:ButtonTag
                name="btnAdd"
                img="btnAdd"
                form="frmCodesTableDetail"
                action="/admin/CodesTablesMnt/displayCodeDetail"
                disabled="<%=disabled%>"
                tabIndex="<%=tabIndex++%>"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
