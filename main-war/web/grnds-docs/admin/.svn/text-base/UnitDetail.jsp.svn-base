<%/**
       * JSP Name:     UnitDetail.jsp
       * Created by:   Paul Lang
       * Date Created: 11/01/02
       *
       * Description:
       * The Unit Detail page allows users to view or maintain unit and member
       * information.
       **/
      /*
       Change History:
       Date      User              Description
       --------  ----------------  ----------------------------------------------
       11/01/02  Paul Lang         Added Methods and imports to the file.
       06/26/03  Todd Reser        SIR 18465 - Added pagination.
       08/01/03  Todd Reser        Modified Flowerbox Comments.
       09/02/03  A.Corley          SIR REG82 Make the Parent input field have a maxlength of 2
       09/02/03  A.Corley          SIR REG83 set navAwayCk=false on delete pushbutton
       09/14/06  abgoode           Program replaced by County for GA SACWIS - Release 1
       */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG02"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.UnitMaintConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.RestrictRepostButtonValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>

<%@ page import="java.util.Enumeration"%>

<script Language="JavaScript">

  function cancelValidation ()
  {
    document.frmUnitDetail.FormValidationCancel.value="true";
  }

  function deleteUnitDetail()
  {
    bRetValue = confirm('<%= MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") %>')
    return bRetValue;
  }

  function setTotalCount()
  {
    var totalCount = document.frmUnitDetail.totalCount.value;
    if ( totalCount == 50 )
    {
      alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_TOO_MANY_LB_ROWS) %>");
      return false;
    }
    cancelValidation();
    return true;
  }
</script>

<%try {
        Boolean badRepost = (Boolean) request.getAttribute(RestrictRepostButtonValidation.restrictRepostDisableButtons);
        if(badRepost != null && badRepost) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
        String pageMode = PageMode.getPageMode(request);

        BaseSessionStateManager state = UnitMaintConversation.getSessionStateManager(request);
        boolean hasMaintainUnitProfile = UserProfileHelper.getUserProfile(request).hasRight(UserProfile.SEC_MNTN_UNIT);
        boolean showMembersSection = true;
        boolean showDeleteButton = false;
        boolean showSaveButton = true;

        CCMN23SO ccmn23so = (CCMN23SO) state.getAttribute("CCMN23SO", request);

        if (ccmn23so == null) {
          ccmn23so = new CCMN23SO();
        }

        ROWCCMN23SOG01_ARRAY memberInfoRowArray = ccmn23so.getROWCCMN23SOG01_ARRAY();

        if (memberInfoRowArray == null || memberInfoRowArray.getROWCCMN23SOG01Count() < 1) {
          showMembersSection = !PageModeConstants.NEW.equals(pageMode);
          if(showMembersSection) {
            showSaveButton = false;
            if(!PageModeConstants.VIEW.equals(pageMode)) {
              UnitMaintConversation.setInformationalMessage(Messages.MSG_CMN_UNIT_NO_MOD, request);
            }
          }
          memberInfoRowArray = new ROWCCMN23SOG01_ARRAY();
        }

        ROWCCMN23SOG02 unitInfoRow = ccmn23so.getROWCCMN23SOG02();
        if (unitInfoRow == null) {
          unitInfoRow = new ROWCCMN23SOG02();
        }

        String szCdUnitCounty = FormattingHelper.formatString(unitInfoRow.getSzCdUnitCounty());
        String szCdUnitRegion = FormattingHelper.formatString(unitInfoRow.getSzCdUnitRegion());
        String szNbrUnit = FormattingHelper.formatString(unitInfoRow.getSzNbrUnit());
        String szCdUnitSpecialization = FormattingHelper.formatString(unitInfoRow.getSzCdUnitSpecialization());
        String szCdParentUnitCounty = FormattingHelper.formatString(unitInfoRow.getSzCdParentUnitCounty());
        String szCdParentUnitRegion = FormattingHelper.formatString(unitInfoRow.getSzCdParentUnitRegion());
        String szNbrParentUnit = FormattingHelper.formatString(unitInfoRow.getSzNbrParentUnit()); 
        int ulIdUnit = unitInfoRow.getUlIdUnit();
        int ulIdUnitParent = unitInfoRow.getUlIdUnitParent();
        int ulIdPerson = unitInfoRow.getUlIdPerson();
        int tabIndex = 1;
        %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>

<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
}
</script>

<impact:validateErrors />

<impact:validateForm name="frmUnitDetail" method="post" validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.UnitCustomValidation" 
	action="/admin/UnitMaint/saveUnitDetail " pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">

	<impact:validateInput type="hidden" name="ulIdUnitParent" value="<%= String.valueOf( ulIdUnitParent )%>" />
	<impact:validateInput type="hidden" name="ulIdPerson" value="<%= String.valueOf( ulIdPerson )%>" />
	<impact:validateInput type="hidden" name="ulIdUnit" value="<%= String.valueOf( ulIdUnit )%>" />

	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th colspan="6">
				Unit Information
			</th>
		</tr>

		<% if (!hasMaintainUnitProfile || (ulIdUnit != 0) ) { %>
		<tr>
			<td width="15%">
				<impact:validateDisplayOnlyField name="szCdUnitCounty" label="County" width="15%" codesTable="<%= CodesTables.CCOUNT %>" value="<%= szCdUnitCounty %>" />
			</td>
			<td width="15%">
				<impact:validateDisplayOnlyField name="szCdUnitRegion" label="Region/Division" width="15%" value="<%= szCdUnitRegion %>" />
			</td>
			<td width="15%">
				<impact:validateDisplayOnlyField name="szNbrUnit" label="Unit" width="25%" value="<%= szNbrUnit %>" />
			</td>
		</tr>

		<% } else { %>

		<tr>
			<td width="15%">
				<impact:validateSelect
				  name="szCdUnitCounty"
				  label="County"
				  width="15%"
				  codesTable="<%= CodesTables.CCOUNT %>"
				  required="true"
				  tabIndex="<%= tabIndex++ %>"
				  value="<%= CodesTables.CCOUNT_XXX %>"
				/>
			</td>
			<td width="15%">
				<impact:validateSelect
				  name="szCdUnitRegion"
				  label="Region/Division"
				  contentType="<%= SelectTag.CODES%>"
				  codesTable="<%=CodesTables.CREGDIV%>"
				  tabIndex="<%= tabIndex++ %>"
				  valueType="<%= SelectTag.CODES %>"
				  width="15%"
				  required="true"
				  value="<%= szCdUnitRegion %>"
				/>
			</td>
			<td width="15%">
				<impact:validateInput
				  name="szNbrUnit"
				  label="Unit"
				  type="text"
				  tabIndex="<%= tabIndex++ %>"
				  width="25%"
				  size="2"
				  maxLength="2"
				  constraint="AlphaNumeric2Unit"
				  required="true"
				  value="<%= szNbrUnit %>"
				/>
			</td>
		</tr>

		<% } %>

		<tr>
			<td>
				<impact:validateSelect
				  label="Specialization"
				  blankValue="true"
				  colspan="3"
				  required="true"
				  name="szCdUnitSpecialization"
				  codesTable="CSPCUNTS"
				  disabled="<%= String.valueOf(!showSaveButton) %>"
				  value="<%= szCdUnitSpecialization %>"
				  tabIndex="<%= tabIndex++ %>"
				/>
			</td>
		</tr>
		<tr>
			<th colspan="6">
				Parent Unit Information
			</th>		
		</tr>
		<tr>
			<td width="15%">
				<impact:validateSelect
				  name="szCdParentUnitCounty"
				  label="County"
				  width="15%"
				  codesTable="<%= CodesTables.CCOUNT %>"
				  required="true"
				  tabIndex="<%= tabIndex++ %>"
				  value="<%= szCdParentUnitCounty %>"
				/>
			</td>
			<td width="15%">
				<impact:validateSelect
				  name="szCdParentUnitRegion"
				  label="Region/Division"
				  contentType="<%= SelectTag.CODES%>"
				  codesTable="<%=CodesTables.CREGDIV%>"
				  tabIndex="<%= tabIndex++ %>"
				  valueType="<%= SelectTag.CODES %>"
				  width="15%"
				  required="true"
				  value="<%= szCdParentUnitRegion %>"
				/>
			</td>
			<td width="15%">
				<impact:validateInput
				  name="szNbrParentUnit"
				  label="Parent Unit"
				  type="text"
				  tabIndex="<%= tabIndex++ %>"
				  width="25%"
				  size="2"
				  maxLength="2"
				  constraint="AlphaNumeric2Unit"
				  required="true"
				  value="<%= szNbrParentUnit %>"
				/>
			</td>
		</tr>
	</table>
	<br>
	<%-- /* SIR 18465 - Added Pagination */ --%>
<%
  int loopCount = 0;
  if(showMembersSection) {
%>
	<impact:pagination submitUrl="/admin/UnitMaint/displayUnitDetail" saveState="false">
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
			<tr>
				<th colspan="5">
					Members
				</th>
			</tr>
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
						<tr class="thList">
							<td width="5%">&nbsp;</td>
							<td>Name</td>
							<td>Role</td>
							<td>In Unit</td>
							<td>ERS</td>
						</tr>

						<%for (Enumeration e = memberInfoRowArray.enumerateROWCCMN23SOG01(); e.hasMoreElements();) {
          ROWCCMN23SOG01 memberInfoRow = (ROWCCMN23SOG01) e.nextElement();
          String szNmPersonFull = FormattingHelper.formatString(memberInfoRow.getSzNmPersonFull());
          String szCdUnitMemberRole = FormattingHelper.formatString(memberInfoRow.getSzCdUnitMemberRole());
          String szCdUnitMemberInOut = FormattingHelper.formatString(memberInfoRow.getSzCdUnitMemberInOut());
          String szBjnJob = FormattingHelper.formatString(memberInfoRow.getSzBjnJob());
          boolean disableRole = false;

          %>
						<tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">

							<impact:if test='<%= ("IN".equalsIgnoreCase(szCdUnitMemberInOut)) %>'>
								<impact:then>
									<td>
										&nbsp;
									</td>
								</impact:then>
								<impact:else>
								  <% showDeleteButton = true; disableRole = true; %>
									<td>
										<impact:validateInput value="<%= String.valueOf(loopCount) %>" type="checkbox" name='<%= "cbxPersonIndex_CLEAN" + loopCount %>' cssClass="formInput" tabIndex="<%= tabIndex++ %>" checked="false" />
									</td>
								</impact:else>
							</impact:if>

							<td>
								<%=szNmPersonFull%>
							</td>
							<td>
								  <impact:validateSelect
								    blankValue="false"
								    label=""
								    required="true"
								    name='<%=  "szCdUnitMemberRole" + loopCount %>'
								    tabIndex="<%= tabIndex++ %>"
								    codesTable="CUNMBRRL"
								    disabled="<%= String.valueOf(disableRole) %>"
								    value="<%= szCdUnitMemberRole %>"
								  />
							</td>

							<impact:ifThen test="<%= (CodesTables.CUNMBRRL_40.equals(szCdUnitMemberRole)) %>">
								<input type="hidden" name="hdnLeadId" value="<%= memberInfoRow.getUlIdPerson() %>">
							</impact:ifThen>
							<impact:if test='<%= ("IN".equalsIgnoreCase(szCdUnitMemberInOut)) %>'>
								<impact:then>
									<td>
										<img alt="checkmark" src="/grnds-docs/images/shared/checkMark_short.gif">
									</td>
								</impact:then>
								<impact:else>
									<td>
										&nbsp;
									</td>
								</impact:else>
							</impact:if>

							<td>
								<%=szBjnJob%>
							</td>
						</tr>

<%
          loopCount++;
        }
%>
					</table>
				</td>
			</tr>
		</table>
		<%/* SIR 18465 - Added Pagination */

        %>
	</impact:pagination>
<%
  }
%>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td>
				<impact:ButtonTag
				  function="return deleteUnitDetail();"
				  name="btnDelete"
				  img="btnDelete"
				  form="frmUnitDetail"
				  action="/admin/UnitMaint/deleteUnitDetail"
				  restrictRepost="true"
				  navAwayCk="false"
				  disabled="<%= String.valueOf(!showDeleteButton) %>"
				  tabIndex="<%= tabIndex++ %>"
				/>
			</td>
			<td class="alignRight">
				<impact:ButtonTag
				  name="btnAdd"
				  img="btnAdd"
				  align="right"
				  function="return setTotalCount();"
				  form="frmUnitDetail"
				  action="/admin/UnitMaint/addUnitDetail"
				  restrictRepost="true"
				  disabled="<%= String.valueOf(!(showMembersSection && showSaveButton)) %>"
				  tabIndex="<%= tabIndex++ %>"
				/>
			</td>
			<td class="alignRight" width="5%">
				<impact:ButtonTag
				  name="btnSaveDetail"
				  img="btnSave"
				  align="right"
				  form="frmUnitDetail"
				  action="/admin/UnitMaint/saveUnitDetail"
				  restrictRepost="true"
				  disabled="<%= String.valueOf(!showSaveButton) %>"
				  tabIndex="<%= tabIndex++ %>"
				/>
			</td>
		</tr>
	</table>


	<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
	<input type="hidden" name="totalCount" value="<%= loopCount %>">

</impact:validateForm>

<%} catch (Exception e) {
        e.printStackTrace();
      }

    %>
