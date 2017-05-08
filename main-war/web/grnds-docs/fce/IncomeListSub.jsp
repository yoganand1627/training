<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB"%>


<%
{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  boolean _disableNoIncome =
          Boolean.valueOf((String) request.getAttribute("disableNoIncome"));

  List _incomeList = (List) request.getAttribute("incomeList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");
%>
<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
  <table width="100%" cellspacing="0" cellpadding="3" border="0">
    <tr>
      <th class="thList">Name</th>
      <th class="thList">Type</th>
      <th class="thList">Amount</th>
      <th class="thList">Source</th>
      <th class="thList">No&nbsp;Income</th>
      <th class="thList">Earned/Unearned</th>
      <th class="thList">Countable/Exempt</th>
    </tr>
<%
  Iterator _iterator = _incomeList.iterator();
  int _loopCount = 0;
  while (_iterator.hasNext())
  {
    FceIncomeDB _fceIncomeDB = (FceIncomeDB) _iterator.next();
    boolean incomeZero = (_fceIncomeDB.getAmtIncome() == 0.0);
    boolean disableIncome = _disableNoIncome || (incomeZero == false);

    String nameSuffix = _baseNameSuffix + _loopCount;
%>
    <tr class="<%= FormattingHelper.getRowCss(_loopCount + 1) %>">
      <td>
        <a href="javascript:navigateToPersonDetail(<%= _fceIncomeDB.getIdPerson() %>)" 
           onclick="setIsDirtyCalled(true)" 
           tabIndex="<%= _tabIndex++ %>">
          <%=_fceIncomeDB.getNmPersonFull()%>
        </a>
      </td>
      <td>
        <%= Lookup.simpleDecodeSafe(CodesTables.CINC, _fceIncomeDB.getCdType()) %>
      </td>
      <td>
        <%= FormattingHelper.formatMoney(_fceIncomeDB.getAmtIncome()) %>
      </td>
      <td>
        <%= _fceIncomeDB.getTxtSource() %>
      </td>
      <td>
        <impact:validateInput type="checkbox"
                              name="<%= FceIncomeDB.IND_NONE + nameSuffix %>"
                              tabIndex="<%= _tabIndex++ %>"
                              checked="<%= _fceIncomeDB.getIndNoneString() %>"
                              disabled="<%= String.valueOf(disableIncome) %>"
                              value="<%= ArchitectureConstants.TRUE %>"/>
      </td>
      <td>
        <impact:validateInput type="radio"
                              label="Earned"
                              name="<%= FceIncomeDB.IND_EARNED + nameSuffix %>"
                              value="<%= ArchitectureConstants.TRUE %>" 
                              tabIndex="<%= _tabIndex++ %>"
                              disabled="<%= _disableRadios %>"
                              checked='<%= "" + _fceIncomeDB.getIndEarned() %>' />
        <br/>
        <impact:validateInput type="radio"
                              label="Unearned"
                              name="<%= FceIncomeDB.IND_EARNED + nameSuffix %>"
                              value="<%= ArchitectureConstants.FALSE %>" 
                              tabIndex="<%= _tabIndex++ %>"
                              disabled="<%= _disableRadios %>"
                              checked='<%= "" + Boolean.FALSE.equals(_fceIncomeDB.getIndEarnedObject()) %>' />
      </td>
      <td>
        <impact:validateInput type="radio"
                              label="Countable"
                              name="<%= FceIncomeDB.IND_COUNTABLE + nameSuffix %>"
                              value="<%= ArchitectureConstants.TRUE %>" 
                              tabIndex="<%= _tabIndex++ %>"
                              disabled="<%= _disableRadios %>"
                              checked='<%= "" + Boolean.TRUE.equals(_fceIncomeDB.getIndCountableObject()) %>' />
        <br/>
        <impact:validateInput type="radio"
                              label="Exempt"
                              name="<%= FceIncomeDB.IND_COUNTABLE + nameSuffix %>"
                              value="<%= ArchitectureConstants.FALSE %>" 
                              tabIndex="<%= _tabIndex++ %>"
                              disabled="<%= _disableRadios %>"
                              checked='<%= "" + Boolean.FALSE.equals(_fceIncomeDB.getIndCountableObject()) %>' />
      </td>
    </tr>
<%
    _loopCount++;
  }
%>
  </table>
</div>
<%
 request.setAttribute("tabIndex", _tabIndex);
}
%>
