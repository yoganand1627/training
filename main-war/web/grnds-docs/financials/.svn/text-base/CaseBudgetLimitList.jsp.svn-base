<%//*  JSP Name:     Case Budget Limit List JSP
      //*  Created by:   Vishala Devarakonda
      //*  Date Created: 04/06/07
      //*
      //*  Description:
      //* The Case Budget Limit List page contains display only information regarding current Case Budget Limits.  
      //* The information contained in the list is populated by several different pieces of financial processing
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------

      %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      /*  GET OBJECTS FROM REQUEST */
      CaseBudgetLimitRetrieveSO caseBudgetLimitRetrieveSO = (CaseBudgetLimitRetrieveSO) state.getAttribute("caseBudgetLimitRetrieveSO", request);
      List<CaseBudgetLimitBean> caseBudgetLimitBeanList = caseBudgetLimitRetrieveSO.getCaseBudgetLimitList();

      %>

<impact:validateForm name="frmCaseBdgtList" method="post" action="/financials/CaseBudgetLimitList/displayCaseBudgetLimit" schema="/WEB-INF/Constraints.xsd">
	<%/* Changed to 100% width for SIR 23639 */

      %>
	<impact:pagination submitUrl="/financials/CaseBudgetLimitList/displayCaseBudgetLimit">
		<div id="scrollBar2" style="height:210px;width:763px;overflow:auto" class="tableborderList">
			<table width="100%" cellspacing="0" cellpadding="3" border="0">
				<tr>
					<th class="thList">
						UAS Code
					</th>
					<th class="thList">
						Entitlement/Service Code
					</th>
					<th class="thList">
						Budgeted Amount
					</th>
					<th class="thList">
						Amount Spent
					</th>
					<th class="thList">
						Remaining Amount Authorized
					</th>
					<th class="thList">
						Waiver Amount
					</th>
					<th class="thList">
						Amount Pending Authorization
					</th>
					<th class="thList">
						Remaining Balance
					</th>
				</tr>
				<%if (caseBudgetLimitBeanList == null || caseBudgetLimitBeanList.isEmpty()) {
%>
				<tr class="odd">
					<td colspan="14">
						<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
					</td>
				</tr>
				<%} else {
        for (Iterator it = caseBudgetLimitBeanList.iterator(); it.hasNext();) {
          CaseBudgetLimitBean caseBudgetLimitBean = (CaseBudgetLimitBean) it.next();
          String svcCode = FormattingHelper.formatString(caseBudgetLimitBean.getCdSvcCode());
          String uasCode = svcCode.substring(0, 3);
          String uasDecode = Lookup.simpleDecodeSafe("CPRGCODE", uasCode);
          String entCode = svcCode.substring(3);
          String entDecode = "";
          // STGAP00010529  UAS code should show even if its a line number 
          if (svcCode.length() == 6) {
            entDecode = Lookup.simpleDecodeSafe("CSVCCODE", svcCode).substring(3);
          } else {
            entDecode = Lookup.simpleDecodeSafe("CENTCODE", entCode);
          }
%>
				<tr valign="top">
					<td>
						<%=FormattingHelper.formatString(uasDecode)%>
					</td>
					<td>
						<%=FormattingHelper.formatString(entDecode)%>
					</td>
					<td>
						<%=FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtBudgt())%>
					</td>
					<td>
						<%=FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtSpent())%>
					</td>
					<td>
						<%=FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtRemain())%>
					</td>
					<td>
						<%=FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtWaiver())%>
					</td>
					<td>
						<%=FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtPendAuth())%>
					</td>
					<td>
						<%=FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtBalance())%>
					</td>
				</tr>
				<%}

      }%>
			</table>
		</div>
	</impact:pagination>
	<impact:validateInput type="hidden" name="hdnPersonLoopCount" value="" />
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
