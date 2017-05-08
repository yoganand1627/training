<%--
//*  JSP Name:     Home History List
//*  Created by:   Heather Dean
//*  Date Created: 1/2/03
//*
//*  Description:
//*               F/A Home List window retrieves the historical home records
//*               from the database for the Foster or Adoptive home selected
//*               on the F/A Home List window or the Home the worker has
//*               selected from their assigned work load. Workers will be able
//*               to view the home's historical changes in a list.
//*               The worker will use the page to view the licensing and
//*               status changes that have been made to the Home. Workers can
//*               select a row and navigate to the Detail page if they have
//*               Home maintainance rights. Worker can generate the F/A Home
//*               History Report for the home selected.
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  -----------------------------------------------
//*  1/2/03  Heather Dean        Initial jsp creation
//*  4/22/03 Heather Dean        Post Code Review Cleanup
//*  4/29/04 gerryc              SIR 22864 - changed code table for marital
//*                              status from CMARSTAT to CFAMSTRC so that
//*                              marital status would display.
//*  4/18/05 Hadjimh            SIR#23327. added CertifyEntity.
//*  2/24/10 hnguyen             SMS#97850: MR-075 Added new Reimbursability fields
//*  3/25/10 hnguyen             SMS#97850: MR-075 Updated name change.

--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00_ARRAY"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>

<%
                                                                       BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      CFAD12SO cfad12so = (CFAD12SO) state.getAttribute("CFAD12SO", request);

      ROWCFAD12SOG00_ARRAY rowArray = cfad12so.getROWCFAD12SOG00_ARRAY();

      //Iterator historyListIterator= rowArray.iterateROWCFAD12SOG00();

      Enumeration historyEnumeration1 = rowArray.enumerateROWCFAD12SOG00();

      String pageMode = PageModeConstants.VIEW;

      UserProfile user = UserProfileHelper.getUserProfile(request);
      int userID = 0;
      if (user != null) {
        userID = user.getUserID();
      }
      boolean hasAdminRights = false;
      if (user.hasRight(UserProfile.SEC_ADMIN_REVIEW)) {
        hasAdminRights = true;
      } else {
        hasAdminRights = false;
      }

      int loopCount = 0;
      int tabIndex = 1;
%>

<script type="text/javascript" language="JavaScript1.2">
function launchDetail( index, id )
{
  frmHomeHistoryList.arrayIndex.value = index;
  document.frmHomeHistoryList.selected.value = '';
  document.frmHomeHistoryList.ulIdResourceHistory.value = id;
  disableValidation( 'frmHomeHistoryList' );
  submitValidateForm('frmHomeHistoryList', '/fad/FAHomeHistory/displayHomeHistoryDetail');
}

function setDeleteParms( resourceHistoryID )
{
  document.frmHomeHistoryList.selected.value = 'true';
  document.frmHomeHistoryList.ulIdResourceHistory.value = resourceHistoryID;
}

function checkSelectedStatus()
{
  if (!(document.frmHomeHistoryList.selected.value == 'true'))
  {
    alert ('<%=MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>');
    return false;
  } else {
    document.frmHomeHistoryList.FormValidateCancel = 'true';
    return true;
  }
}

function deleteRow()
{
  if ( checkSelectedStatus() )
  {
  bRetValue = confirm('<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>')
  return bRetValue;
  } else
    return false;
}

</script>
<impact:validateForm name="frmHomeHistoryList" method="post"
	action="/fad/FAHomeHistory/displayHomeHistoryDetail"
	schema="/WEB-INF/Constraints.xsd" redisplayParameters="true"
	pageMode="<%=pageMode%>">

	<impact:validateInput type="hidden" name="arrayIndex" value="" />
	<impact:validateInput type="hidden" name="selected" value="" />
	<impact:validateInput type="hidden" name="ulIdResourceHistory" value="" />
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />

	<impact:pagination
		submitUrl="/fad/FAHomeHistory/displayHomeHistoryList"
		saveState="false">
		<div class="alignRight">
			<div class="formInstruct">
				Scroll for more information -->
			</div>
		</div>
		<table width="100%" cellspacing="0" cellpadding="3"
			class="tableborder">
			<tr>
				<td class="tableBG">
					<div id="horizontalScrollResults"
						style="height:335px; width:765px; overflow:auto"
						class="tableborderList">
						<table width="3000" cellspacing="0" cellpadding="3">
							<tr>
								<th class="thList">
									&nbsp;
								</th>
								<th class="thList">
									Effective Date
								</th>
								<th class="thList">
									End Date
								</th>
								<th class="thList">
									Category
								</th>
								<th class="thList">
									Status
								</th>
								<!-- <th class="thList">Foster Type</th> -->
								<th class="thList">
									Approval Begin Date
								</th>
								<th class="thList">
									Approval End Date
								</th>
                                <th class="thList">
                                    IV-E<br/>Reimbursable
                                </th>
                                <th class="thList">
                                    Reimbursable<br/>Effective Date
                                </th>
                                <th class="thList">
                                    Reimbursable<br/>End Date
                                </th>
								<th class="thList">
									AD Exchg
								</th>
								<th class="thList">
									Home Type
								</th>
								<th class="thList">
									Capacity
								</th>
								<th class="thList">
									M Min Year
								</th>
								<th class="thList">
									M Max Year
								</th>
								<th class="thList">
									F Min Year
								</th>
								<th class="thList">
									F Max Year
								</th>
								<!-- <th class="thList">Closure Reason</th>  -->
								<th class="thList">
									Status Reason
								</th>
								<th class="thList">
									Recommend Reopening
								</th>
								<th class="thList">
									Vol/Invol Closure
								</th>
								<th class="thList">
									Race and Ethnicity
								</th>
								<th class="thList">
									Language
								</th>
								<th class="thList">
									Religion
								</th>
								<!-- <th class="thList">Annual Income</th> -->
								<th class="thList">
									Marital Status
								</th>
								<th class="thList">
									Marriage Date
								</th>
								<!-- Removed from R2 release due to complexity. The values of this field are stored in HOME_APPLICANT_CBX table. -->
								<!-- <th class="thList">Inquiry Source</th> -->
								<th class="thList">
									Respite
								</th>
								<!-- <th class="thList">Non-FPS Home</th> <% /* SIR 22492 PRS --> FPS */ %> -->
								<th class="thList">
									Non-DFCS Home
								</th>
								<!-- <th class="thList">Certify Entity</th> <% /* SIR 23327 */ %> -->
								<th class="thList">
									Non-DFCS Certify Entity
								</th>
								<!-- <th class="thList">Ind Study</th> -->
								<!-- <th class="thList">Inhome Care</th> -->
							</tr>
							<%
							      ROWCFAD12SOG00 homeHistoryRow = null;
							      if (!historyEnumeration1.hasMoreElements()) {
							%>
							<tr class="odd">
								<td colspan="7">
									<a href="#" id="nameHistoryItem_0"><%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
									</a>
								</td>
							</tr>
							<%
							        } else {
							        while (historyEnumeration1.hasMoreElements()) {
							          homeHistoryRow = (ROWCFAD12SOG00) historyEnumeration1.nextElement();
							          double d1 = homeHistoryRow.getUlIdResourceHistory();
							          Double d = d1;
							          int intResourceHistoryID = d.intValue();
							          String onClickString = "setDeleteParms( '" + intResourceHistoryID + "' )";
							%>
							<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>">
								<%
								if (loopCount == 0) {
								%>
								<td>
									&nbsp;
								</td>
								<%
								} else {
								%>
								<td>
									<%
									if (pageMode.equals(PageModeConstants.MODIFY) && homeHistoryRow.getDtDtRshsEnd() != null) {
									%>
									<impact:validateInput tabIndex="<%=tabIndex++%>" value=""
										onClick="<%=onClickString%>" type="radio"
										name="rbItemSelect" cssClass="formInput" />
									<%
									}
									%>
								</td>
								<%
								}
								%>
								<td>
									<!-- hyperlink for effective date is removed in R2 release -->
									<!-- <% //if ( pageMode.equals( PageModeConstants.MODIFY ) ) {%>
 <a href="javascript:launchDetail(<%=loopCount%> , <%=intResourceHistoryID%>)"><%=FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsEffective())%></a>
  <%//} else {%>
  -->
									<%=FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsEffective())%>
									<!-- <%//}%> -->
								</td>
								<td>
									<%=FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsEnd())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFACATEG, homeHistoryRow.getSzCdRshsCategory())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, homeHistoryRow.getSzCdRshsFaHomeStatus())%>
								</td>

								<!--  Added for R2 release, Start-->
								<td>
									<%=FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsLicBegin())%>
								</td>
								<td>
									<%=FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsLicEnd())%>
								</td>
                                <td>
                                    <%= homeHistoryRow.getBIndHomeIveReimbursable() != null ? homeHistoryRow.getBIndHomeIveReimbursable() : "&nbsp;" %>
                                </td>
                                <td>
                                    <%=FormattingHelper.formatDate(homeHistoryRow.getDtDtReimbursableEffective())%>
                                </td>
                                <td>
                                    <%=FormattingHelper.formatDate(homeHistoryRow.getDtDtReimbursableEnd())%>
                                </td>

								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CADEXCHG, homeHistoryRow.getCCdRshsExchnageStat())%>
								</td>
								<!--  Added for R2 release, End -->


								<td>
									<%
									          String fosterTypeDecode = "";
									          String tempString = "";

									          if (homeHistoryRow.getCCdRshsFaHomeType1() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType1())) {
									            tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType1());
									            fosterTypeDecode = fosterTypeDecode + "  " + tempString;

									            if (homeHistoryRow.getCCdRshsFaHomeType2() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType2())) {
									              tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType2());
									              fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									              if (homeHistoryRow.getCCdRshsFaHomeType3() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType3())) {
									                tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType3());
									                fosterTypeDecode = fosterTypeDecode + ",  " + tempString;
									              }
									              if (homeHistoryRow.getCCdRshsFaHomeType4() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType4())) {
									                tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType4());
									                fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									                if (homeHistoryRow.getCCdRshsFaHomeType5() != null
									                    && !"".equals(homeHistoryRow.getCCdRshsFaHomeType5())) {
									                  tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType5());
									                  fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									                  if (homeHistoryRow.getCCdRshsFaHomeType6() != null
									                      && !"".equals(homeHistoryRow.getCCdRshsFaHomeType6())) {
									                    tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType6());
									                    fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									                    //FaHomeType7 is not used in R2 Release.

									                    // if ( homeHistoryRow.getCCdRshsFaHomeType7() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType7()) )
									                    // {
									                    //   tempString = Lookup.simpleDecodeSafe( CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType7() );
									                    //   fosterTypeDecode = fosterTypeDecode + ",  " + tempString;
									                    // }
									                  }
									                }
									              }
									            }
									          }
									%>
									<%=fosterTypeDecode%>
								</td>

								<td>
									<%=homeHistoryRow.getUNbrRshsFacilCapacity()%>
								</td>
								<td>
									<%=homeHistoryRow.getUNbrRshsAMaAgeMin() / 12%>
								</td>
								<td>
									<%=homeHistoryRow.getUNbrRshsAMaAgeMax() / 12%>
								</td>
								<td>
									<%=homeHistoryRow.getUNbrRshsAFeAgeMin() / 12%>
								</td>
								<td>
									<%=homeHistoryRow.getUNbrRshsAFeAgeMax() / 12%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFACLOSE, homeHistoryRow.getSzCdRshsClosureRsn())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFARCMND, homeHistoryRow.getSzCdRshsRecmndReopen())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFACLSTP, homeHistoryRow.getSzCdRshsInvolClosure())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CETHNIC, homeHistoryRow.getSzCdRshsEthnicity())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CLANG, homeHistoryRow.getSzCdRshsLanguage())%>
								</td>
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CRELIGNS, homeHistoryRow.getSzCdRshsReligion())%>
								</td>
								<!-- Removed in R2 -->
								<!-- <td><%=FormattingHelper.formatMoney(homeHistoryRow.getDNbrRshsAnnualIncome())%>
 </td> -->
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFAMSTRC, homeHistoryRow.getSzCdRshsMaritalStatus())%>
								</td>
								<td>
									<%=FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsMarriage())%>
								</td>
								<!-- Removed from R2 release. The HOME_APPLICANT_CBX table is used to store the values of Source Inquiry. -->
								<!-- <td><%=Lookup.simpleDecodeSafe(CodesTables.CFASRCIN, homeHistoryRow.getSzCdRshsSourceInquiry())%>
 </td> -->
								<td>
									<%=Lookup.simpleDecodeSafe(CodesTables.CFARSPIT, homeHistoryRow.getSzCdRshsRespite())%>
								</td>
								<%
								          String nonDFCSHome = "";
								          if (ArchitectureConstants.Y.equals(homeHistoryRow.getCIndRshsNonDFCSHome())) {
								            nonDFCSHome = ArchitectureConstants.YES;
								          } else if (ArchitectureConstants.N.equals(homeHistoryRow.getCIndRshsNonDFCSHome())) {
								            nonDFCSHome = ArchitectureConstants.NO;

								          }
								%>
								<td>
									<%=nonDFCSHome%>
								</td>
								<%
								// SIR#23327. added CertifyEntity
								%>
								<!-- removing the codes value as this field is textbox now -->
								<!-- <td><%=Lookup.simpleDecodeSafe(CodesTables.CERTENT, homeHistoryRow.getSzTxtNdfcsCertEntity())%>  </td>-->
								<td>
									<%=homeHistoryRow.getSzTxtNdfcsCertEntity() != null ? homeHistoryRow.getSzTxtNdfcsCertEntity()
                                                                         : ""%>
								</td>
								<!-- <td><%=homeHistoryRow.getCIndCurrHomeStudyExists()%>
 </td> -->
								<!-- <td><%=homeHistoryRow.getCIndRshsCareProv()%>
 </td> -->

							</tr>
							<%
							        loopCount++;
							        } //end while
							      } //end else
							%>

						</table>
					</div>
		</table>
	</impact:pagination>
</impact:validateForm>


