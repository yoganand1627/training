<%
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  03/26/09  Van Vo            MR-026 STGAP00013024: add Non Re-billable checkbox and enable it for denied and rejected
//**                              claim and to user in Medicaid Billing unit. 
//**                              

%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimsSearchSI"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimsSearchSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.TCMClaimsSearchConversation"%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%
      BaseSessionStateManager state = TCMClaimsSearchConversation.getSessionStateManager(request);
      String pageMode = PageModeConstants.EDIT;
      int tabIndex = 1;
      String idStaff = ContextHelper.getStringSafe(request, "txtIdStaff");
      String idClient = ContextHelper.getStringSafe(request, "txtIdClient");
      String county = ContextHelper.getStringSafe(request, "selCdCounty");
      String unit = ContextHelper.getStringSafe(request, "txtUnit");
      String month = ContextHelper.getStringSafe(request, "txtMonth");
      String year = ContextHelper.getStringSafe(request, "txtYear");
      String status = ContextHelper.getStringSafe(request, "selStatus");
      
      List countyOptions = (List) state.getAttribute(TCMClaimsSearchConversation.COUNTY_OPTIONS_NAME, request);
      if(countyOptions == null) {
        //-- this should never happen
        countyOptions = new ArrayList();
      }

      TCMClaimsSearchSI searchCriteria = (TCMClaimsSearchSI) state.getAttribute(TCMClaimsSearchConversation.SEARCH_CRITERIA_NAME, request);
      if(searchCriteria != null) {
        idStaff = FormattingHelper.formatInt(searchCriteria.getUlIdStaff());
        idClient = FormattingHelper.formatInt(searchCriteria.getIdClient());
        county = FormattingHelper.formatString(searchCriteria.getSzCdCounty());
        unit = FormattingHelper.formatString(searchCriteria.getSzUnit());
        month = FormattingHelper.formatInt(searchCriteria.getMonth());
        year = FormattingHelper.formatInt(searchCriteria.getUlYear());
        status = FormattingHelper.formatString(searchCriteria.getSzCdStatus());
      }

%>
    <impact:validateErrors formName="frmTCMClaimsSearch" />
    <impact:validateForm
      name="frmTCMClaimsSearch"
      method="post"
      action="/financials/TCMClaimsSearch/displayTCMClaims"
      validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.TCMClaimsSearchCustomValidation"
      pageMode="<%= pageMode %>"
      schema="/WEB-INF/Constraints.xsd"
      defaultButton="true"
    >
      <br>
      <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>" />
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
        <tr>
          <th colspan="8">TCM Claim Search</th>
        </tr>
        <tr>
          <td>
            <impact:validateInput
              type="text"
              label="Staff ID"
              constraint="ID"
              name="txtIdStaff"
              value="<%= idStaff %>"
              size="10"
              maxLength="10"
              conditionallyRequired="true"
              tabIndex="<%= tabIndex++ %>"
            />
          </td>
          <td>
            <impact:validateInput
              type="text"
              label="Client ID"
              name="txtIdClient"
              value="<%= idClient %>"
              constraint="ID"
              size="10"
              maxLength="10"
              conditionallyRequired="true"
              tabIndex="<%= tabIndex++ %>"
            />
          </td>
          <td>
            <impact:validateInput
              type="text"
              label="Month"
              constraint="MonthNumber"
              name="txtMonth"
              value="<%= month %>"
              size="2"
              maxLength="2"
              conditionallyRequired="true"
              tabIndex="<%= tabIndex++ %>"
            />
          </td>
          <td>
            <impact:validateInput
              type="text"
              label="Year"
              constraint="Year"
              name="txtYear"
              value="<%= year %>"
              size="4"
              maxLength="4"
              required="true"
              tabIndex="<%= tabIndex++ %>"
            />
          </td>
        </tr>
        <tr>
          <td>
            <impact:validateSelect
              label="County"
              name="selCdCounty"
              tabIndex="<%= tabIndex++ %>"
              conditionallyRequired="true"
              options="<%= countyOptions %>"
              value="<%= county %>"
            />
          </td>
          <td>
            <impact:validateInput
              type="text"
              label="Unit"
              constraint="AlphaNumeric2Unit"
              name="txtUnit"
              value="<%= unit %>"
              size="2"
              maxLength="2"
              conditionallyRequired="true"
              tabIndex="<%= tabIndex++ %>"
            />
          </td>
          <td>
            <impact:validateSelect
              label="Status"
              name="selStatus"
              colspan="3"
              tabIndex="<%= tabIndex++ %>"
              codesTable="CTCMSTAT"
              value="<%= status %>"
            />
          </td>
        </tr>
      </table>
      <table border="0" cellspacing="0" cellpadding="3" width="100%">
        <tr>
          <td>
            <impact:ButtonTag
              name="btnSearch"
              img="btnSearch"
              align="right"
              form="frmTCMClaimsSearch"
              action="/financials/TCMClaimsSearch/searchTCMClaims"
              tabIndex="<%= tabIndex++ %>"
            />
          </td>
        </tr>
      </table>
    </impact:validateForm>

    <br>
    <%
      List<TCMClaimsSearchSO> list1 = (List<TCMClaimsSearchSO>) state.getAttribute(TCMClaimsSearchConversation.SEARCH_RESULTS_NAME, request);
      if (list1 != null) {
        boolean resubmitEnabled = UserProfileHelper.getUserProfile(request).hasRight(UserProfile.SEC_RESUBMIT_TCM_CLAIMS);
        boolean atLeastOneCheckbox = false;
    %>

    <impact:validateForm name="frmTCMClaimsSearchResults" method="post" action="/financials/TCMClaimsSearch/searchTCMClaims" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">

      <impact:validateErrors formName="frmTCMClaimsSearchResults" />

      <impact:validateInput type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>" />
      <div class="alignRight">
        <div class="formInstruct">
          Scroll for more information -->
        </div>
      </div>
      <div id="horizontalScrollResults" style="width:764px; height:250px; overflow:auto" class="tableBorderList">
      <table width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <td class="tableBG">
            <table width="1000" cellspacing="0" cellpadding="3" border="0">
              <tr>
                <th class="thList">Staff ID</th>
                <th class="thList">Stage ID</th>
                <th class="thList">Client Name</th>
                <th class="thList">Medicaid #</th>
                <th class="thList">Status</th>
                <th class="thList">Denial Reason</th>
                <th class="thList"><div align="center">Resubmit</div></th>
                <th class="thList"><div align="center">Non Re-billable</div></th>
                <th class="thListRight">Status Date</th>
                <th class="thListRight">Service Date</th>
                <th class="thListRight">TCN Number</th>
              </tr>
              <%int loopCount = 0;
        TCMClaimsSearchSO tCMClaimsSearchRow = null;
        Iterator<TCMClaimsSearchSO> iterator = list1.iterator();

        if (list1.size() == 0) {

          %>
              <tr class="odd">
                <td colspan="10">
                  <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                </td>
              </tr>
              <%} else {
          while (iterator.hasNext()) {
            tCMClaimsSearchRow = (TCMClaimsSearchSO) iterator.next();
                  String statusCode = tCMClaimsSearchRow.getSzCdStatus();
                  String dReasonCode = tCMClaimsSearchRow.getSzCdDenialReason();
                  String resubmitName = "cbxResubmit_"+loopCount;
                  String noRebillName = "cbxNoRebill_"+loopCount;
            %>
              <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                <td>
                  <%=FormattingHelper.formatInt(tCMClaimsSearchRow.getUlIdStaff())%>
                </td>
                <td>
                  <%=FormattingHelper.formatInt(tCMClaimsSearchRow.getUlIdStage())%>
                </td>
                <td>
                  <%=FormattingHelper.formatString(tCMClaimsSearchRow.getSzNmClient())%>
                </td>
                <td>
                  <%=FormattingHelper.formatString(tCMClaimsSearchRow.getSzNbrMedicaid())%>
                </td>
                <td>
                  <%=Lookup.simpleDecodeSafe(TCMClaimsSearchConversation.STATUS_CODES_TABLES, statusCode)%>
                </td>
                <td>
                  <%-- =Lookup.simpleDecodeSafe(TCMClaimsSearchConversation.DENIAL_REASON_CODES_TABLES, dReasonCode) --%>
                  <%= FormattingHelper.formatString(dReasonCode) %>
                </td>
                <td align="center">
                  <impact:if test="<%= TCMClaimsSearchConversation.RESUBMIT_STATUS_LIST.contains(statusCode) %>">
                    <impact:then>
                      <% atLeastOneCheckbox = true; %>
                      <impact:validateInput
                        type="checkbox"
                        disabled="<%= String.valueOf(!resubmitEnabled) %>"
                        value="<%= String.valueOf(loopCount) %>"
                        tabIndex="<%= tabIndex++ %>"
                        
                        name="<%= resubmitName %>"
                      />
                    </impact:then>
                    <impact:else>&nbsp;</impact:else>
                  </impact:if>
                </td>
                <td align="center">
                  <impact:if test="<%= TCMClaimsSearchConversation.NO_REBILL_STATUS_LIST.contains(statusCode) %>">
                    <impact:then>
                      <% atLeastOneCheckbox = true; %>
                      <impact:validateInput
                        type="checkbox"
                        disabled="<%= String.valueOf(!resubmitEnabled) %>"
                        value="<%= String.valueOf(loopCount) %>"
                        tabIndex="<%= tabIndex++ %>"
                        
                        name="<%= noRebillName %>"
                      />
                    </impact:then>
                    <impact:else>&nbsp;</impact:else>
                  </impact:if>
                </td>
                <td class="alignRight">
                  <%=FormattingHelper.formatDate(tCMClaimsSearchRow.getDtStatusDate())%>
                </td>
                <td class="alignRight">
                  <%=FormattingHelper.formatDate(tCMClaimsSearchRow.getDtServiceDate())%>
                </td>
                <td class="alignRight">
                  <%=FormattingHelper.formatString(tCMClaimsSearchRow.getUlTCNNumber())%>
                </td>
              </tr>
              <%loopCount++;
          } // end while
        }

      %>
            </table>
          </td>
        </tr>
      </table>
      </div>
      
      <impact:ifThen test="<%= resubmitEnabled && atLeastOneCheckbox %>">
        <table border="0" cellspacing="0" cellpadding="3" width="100%"><tr><td>
        <div class="alignRight">
          <impact:ButtonTag
            name="btnSubmit"
            form="frmTCMClaimsSearchResults"
            tabIndex="<%= tabIndex++ %>"
            action="/financials/TCMClaimsSearch/resubmitTCMClaims"
            img="btnSubmit"
          />&nbsp;
        </div>
        </td></tr></table>
      </impact:ifThen>

    </impact:validateForm>

    <%
      }
    %>
