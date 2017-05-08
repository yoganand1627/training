<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB"%>


<%
{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  List _resourcesList = (List) request.getAttribute("resourcesList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");
%>
<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
  <table width="100%" cellspacing="0" cellpadding="3" border="0">
    <tr>
      <th class="thList">Name</th>
      <th class="thList">Type</th>
      <th class="thList">Amount</th>
      <th class="thList">Source</th>
      <th class="thList">Verification Method</th>
      <th class="thList">Accessible?</th>
      <th class="thList">Countable/Exempt</th>
    </tr>
<%  
  if (_resourcesList == null)
  {
%>
    <tr class="odd">
      <td colspan="7">
        <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
      </td>
    </tr>
<%
  }
  else
  {
    int _loopCount = 0;
    Iterator _iterator = _resourcesList.iterator();
    while(_iterator.hasNext())
    {
      FceIncomeDB fceIncomeDB = (FceIncomeDB)_iterator.next();
      String nameSuffix = _baseNameSuffix + _loopCount;
%>
    <tr class="<%= FormattingHelper.getRowCss(_loopCount + 1) %>">
      <td>
        <a tabIndex="<%=_tabIndex++%>" 
           href="javascript:navigateToPersonDetail(<%=fceIncomeDB.getIdPerson() %>)"
           onclick="setIsDirtyCalled(true)">
          <%= fceIncomeDB.getNmPersonFull() %>
        </a>
      </td>
      <td>
        <%= Lookup.simpleDecodeSafe(CodesTables.CRSRC, fceIncomeDB.getCdType()) %>
      </td>
      <td>
        <%= FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome()) %>
      </td>
      <td>
        <%= fceIncomeDB.getTxtSource() %>
      </td>
      <td>
        <%= fceIncomeDB.getTxtVerificationMethod() %>
      </td>
      <% // STGAP00004122 - change col label from Inaccessible (above) to Accessible and modify display logic accordingly %>
      <td>
        <%= fceIncomeDB.getIndNotAccessible() ? "No" : "Yes" %>
      </td>
      <td>
        <impact:validateInput type="radio"
                              label="Countable"
                              name="<%=FceIncomeDB.IND_COUNTABLE + nameSuffix %>"
                              disabled='<%= _disableRadios %>'
                              value="<%=ArchitectureConstants.TRUE%>"
                              tabIndex="<%=_tabIndex++%>"
                              checked='<%= "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) %>' />
        <br/>
        <impact:validateInput type="radio"
                              label="Exempt"
                              name="<%=FceIncomeDB.IND_COUNTABLE + nameSuffix %>"
                              disabled='<%= _disableRadios %>'
                              value="<%=ArchitectureConstants.FALSE%>"
                              tabIndex="<%=_tabIndex++%>"
                              checked='<%= "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) %>' />
      </td>
    </tr>
<%
      _loopCount++;
    }
  }
%>
  </table>
</div>
<%
 request.setAttribute("tabIndex", _tabIndex);
}
%>
