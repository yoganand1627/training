<%
//*  JSP Name:     Case List
//*  Created by:   Jonathan Hardy
//*  Date Created: 1/08/03
//*
//*  Description:
//*  This JSP displays the results of a Case Search or a search for cases associated
//*  with a particular user.  If the case is not sensitive, or if it is and the user
//*  can view sensitive cases, the Case ID is included in the list as a hyperlink
//*  that takes the user to Case Summary.
//*
//** Change History:
//**  Date        User              Description
//**  --------    ----------------  --------------------------------------------------
//**  3-21-2002   Eric Dickman      QA Sweep/
//**  6-18-2003   LAURAMC           sir 18133 - corrected Program type from APSFAC to
//**                                AFC by removing the decode request in the td for
//**                                addressRow.getSzCdCaseProgram()
//**  8-08-2005   CASDORJM          SIR 22559 - Added sort capabilities on list
//**  11/21/2008  arege             Per STGAP00010463 changed the style attribute to fix the
//**                                formatting problem.
//**  02/05/2010  wcochran          SMS #43758: Added variable indUseStageCode for use
//**                                in determining which order by clause to use when
//**                                sorting by stage.
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSearchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  //Set the page mode
  String pageMode = PageModeConstants.EDIT;

  // Replacing the old with the below status string as of 07/28/2006
  String status = "";

  int personId = 0;
  int tabIndex = 1;
  try
  {
    Integer personIdFromAttr = (Integer)request.getAttribute("SearchCasePersonID");
    if (personIdFromAttr != null)
    {
      personId = personIdFromAttr;
    }
    else
    {
      String personIdFromParam = request.getParameter("txtUlIdPerson");
      if ((personIdFromParam != null) && !"".equals(personIdFromParam))
      {
        personId = Integer.parseInt(personIdFromParam);
      }
    }
  }
  catch (Exception e)
  {
    %><!-- An exception occured trying to retrieve personID from the session. --><%
  }

  String txtUlIdCase = ContextHelper.getStringSafe(request, "txtUlIdCase");
  String txtSzNmCase = ContextHelper.getStringSafe(request, "txtSzNmCase");
  String txtSzNmCaseLast = ContextHelper.getStringSafe(request, "txtSzNmCaseLast");
  String txtSzNmCaseFirst = ContextHelper.getStringSafe(request, "txtSzNmCaseFirst");
  String txtSzNmCaseMiddle = ContextHelper.getStringSafe(request, "txtSzNmCaseMiddle");
  String selSzCdCaseCounty = ContextHelper.getStringSafe(request, "selSzCdCaseCounty");
  String selSzCdCaseProgram = ContextHelper.getStringSafe(request, "selSzCdCaseProgram");
  String selSzCdCaseRegion = ContextHelper.getStringSafe(request, "selSzCdCaseRegion");
  String hdnSzAddrCity = ContextHelper.getStringSafe(request, "hdnSzAddrCity");
  String txtUlIdCaseManager = ContextHelper.getStringSafe( request, "txtUlIdCaseManager");
  String txtSzNmCaseManagerFirst = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerFirst");
  String txtSzNmCaseManagerLast = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerLast");
  String txtDtDtLastUpdate = ContextHelper.getStringSafe( request, "txtDtDtLastUpdate");
  String selSzCdCpsInvstDtlOvrllDisptn = ContextHelper.getStringSafe( request, "selSzCdCpsInvstDtlOvrllDisptn");
  String selSzCdStage = ContextHelper.getStringSafe( request, "selSzCdStage");
  String txtSzNbrUnit = ContextHelper.getStringSafe( request, "txtSzNbrUnit");
  String selRbOpenClose = ContextHelper.getStringSafe( request, "selRbOpenClose");
  String strIndUseStageCode = (String) request.getAttribute("indUseStageCode");
%>

<impact:validateForm name="frmCaseList"
  method="post"
  action="/workload/CaseSearch/displayCaseSummary"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<impact:validateErrors formName="frmCaseList"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="hdnUlIdCase"/>
<impact:validateInput type="hidden" name="hdnSzCdStage"/>
<impact:validateInput type="hidden" name="hdnSzNmCase"/>
<impact:validateInput type="hidden" name="hdnSzCdCaseProgram"/>
<impact:validateInput type="hidden" name="hdnCopyCheckedNum" value="0"/>
<impact:validateInput type="hidden" name="txtUlIdPerson" value="<%=String.valueOf(personId)%>"/>
<impact:validateInput type="hidden" name="txtUlIdCase" value="<%=txtUlIdCase%>"/>
<impact:validateInput type="hidden" name="txtSzNmCase" value="<%=txtSzNmCase%>"/>
<impact:validateInput type="hidden" name="txtSzNmCaseLast" value="<%=txtSzNmCaseLast%>"/>
<impact:validateInput type="hidden" name="txtSzNmCaseFirst" value="<%=txtSzNmCaseFirst%>"/>
<impact:validateInput type="hidden" name="txtSzNmCaseMiddle" value="<%=txtSzNmCaseMiddle%>"/>
<impact:validateInput type="hidden" name="selSzCdCaseCounty" value="<%=selSzCdCaseCounty%>"/>
<impact:validateInput type="hidden" name="selSzCdCaseProgram" value="<%=selSzCdCaseProgram%>"/>
<impact:validateInput type="hidden" name="selSzCdCaseRegion" value="<%=selSzCdCaseRegion%>"/>
<impact:validateInput type="hidden" name="hdnSzAddrCity" value="<%=hdnSzAddrCity%>"/>
<impact:validateInput type="hidden" name="txtUlIdCaseManager" value="<%=txtUlIdCaseManager%>"/>
<impact:validateInput type="hidden" name="txtSzNmCaseManagerFirst" value="<%=txtSzNmCaseManagerFirst%>"/>
<impact:validateInput type="hidden" name="txtSzNmCaseManagerLast" value="<%=txtSzNmCaseManagerLast%>"/>
<impact:validateInput type="hidden" name="txtDtDtLastUpdate" value="<%=txtDtDtLastUpdate%>"/>
<impact:validateInput type="hidden" name="selSzCdStage" value="<%=selSzCdStage%>"/>
<impact:validateInput type="hidden" name="txtSzNbrUnit" value="<%=txtSzNbrUnit%>"/>
<impact:validateInput type="hidden" name="selSzCdCpsInvstDtlOvrllDisptn" value="<%=selSzCdCpsInvstDtlOvrllDisptn%>"/>
<impact:validateInput type="hidden" name="indUseStageCode" value="<%=strIndUseStageCode %>"/>

<TEXTAREA ID="holdtext" STYLE="display:none;">
</TEXTAREA>
<%
  // Get the CCMN20SO output object out of the request
  CCMN20SO ccmn20so = (CCMN20SO) request.getAttribute("CCMN20SO");
  // Initialize the row and array objects
  ROWCCMN13DO_ARRAY addressArray = null;
  // Null catch for ccmn20so, if null set to blank (initialize)
  if ( ccmn20so == null )
  {
    ccmn20so = new CCMN20SO();
  }
  // Null catch for ROW objects, if not null get rows
  if ( ccmn20so.getROWCCMN13DO_ARRAY() != null )
  {
    addressArray = ccmn20so.getROWCCMN13DO_ARRAY();
  } else
  {
    addressArray = new ROWCCMN13DO_ARRAY();
  }


  // Assign tabIndex
  //unused
  //int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;

  UserProfile user = UserProfileHelper.getUserProfile( request );
  //unused
  //boolean canViewSensitiveCases = user.hasRight(user.SEC_SENSITIVE_CASE_ACCESS);
  //boolean canViewPADStage = user.hasRight(user.)

%>

<Script Language="JavaScript">

  function submitCaseSearch(caseId, stageCd, caseNm, caseProgram)
  {
    document.frmCaseList.hdnUlIdCase.value = caseId;
    document.frmCaseList.hdnSzCdStage.value = stageCd;
    document.frmCaseList.hdnSzNmCase.value = caseNm;
    document.frmCaseList.hdnSzCdCaseProgram.value = caseProgram;
    submitValidateForm( "frmCaseList", "/workload/CaseSearch/displayCaseSummary" );
  }

  function verifyFiveOrLess(cbx)
  {
    var numChecked = document.frmCaseList.hdnCopyCheckedNum.value;
    if (cbx.checked)
    {
      if (numChecked == 5)
      {
        alert("You can select a maximum of 5 rows to copy into the clipboard.");
        cbx.checked = false;
      }
      else
      {
        document.frmCaseList.hdnCopyCheckedNum.value = ++numChecked;
      }
      return;
    }
    else
    {
      document.frmCaseList.hdnCopyCheckedNum.value = --numChecked;
    }
  }

  function populateClipboard()
  {
    var firstElement = true;

    if (document.frmCaseList.hdnCopyCheckedNum.value == 0)
    {
      alert("No Row Selected!");
    }
    else
    {
      var firstRow = true;
      var clipString = "";
      for (var i = 0; i < <%= addressArray.getUlRowQty() %>; i++)
      {
        var checkbox = eval("document.frmCaseList.caseCopy_" + i);
        if (checkbox.checked)
        {
          if (!firstRow)
          {
            clipString += "\n";
          }
          else
          {
            firstRow = false;
          }
          clipString += checkbox.value;
        }
      }
      var hiddenText = document.getElementById("holdText");
      hiddenText.value = clipString;
      Copied = hiddenText.createTextRange();
      // execCommand is an IE-specific method.  Not supported in Netscape.
      Copied.execCommand("Copy")
      alert("Data copied to Clipboard.");
    }
  }
</Script>


<% /* Begin Result List Division (copy from  // Start RLD to // end RLD) */ %>
<% /* start pagination custom tag  -- closed after table */ %>
<impact:pagination submitUrl="/workload/CaseSearch/searchCase">
<div id="noScrollResults" style="height:155px; width:767px; overflow:auto" class="tableborderList">
<!-- My original table -->
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <th class="thList">Copy</th>
    <th class="thList">!</th>
    <th class="thList">UTC</th>
    <th class="thList">Case ID</th>
    <th class="thList">Case Name</th><%//<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_CASE_NAME /%/>"/>%>
    <th class="thList">Mrg</th>
    <th class="thList">Status</th><%//<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_STATUS/%/>"/>%>
    <th class="thList">Date<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_DATE %>"/></th>
    <th class="thList">Stage<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_STAGE %>"/></th>
    <th class="thList">County</th><%//<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_COUNTY/%/>"/>%>
    <th class="thList">Region</th> 
    <th class="thList">Case Mgr<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_CASE_MANAGER%>"/></th>
  </tr>
<%

                  loopCount = 0;
                  ROWCCMN13DO addressRow = null;
                  Enumeration addressEnumeration1 = addressArray.enumerateROWCCMN13DO();
                  if ( !addressEnumeration1.hasMoreElements() )
                  {
%>
                      <tr class="odd">
                        <td colspan="7">
                           <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
                        </td>
                      </tr>
<%
                  }
                    else
                  {

                    while( addressEnumeration1.hasMoreElements() )
                    {
                      addressRow = (ROWCCMN13DO) addressEnumeration1.nextElement();

                      boolean linkRow = true;
                      boolean bUTC = "Y".equals( addressRow.getCScrIndCaseUTC() );
                      String caseName = FormattingHelper.formatStringSpecialChars( addressRow.getSzNmCase(), "'\"\\" );
                      if(addressRow.getDtDtCaseClosed() == null)
                      {
                        status = CodesTables.CINCMGST_OPN;
                      }else{
                        status = CodesTables.CINCMGST_CLD;
                      }
                      if ("Y".equalsIgnoreCase(addressRow.getBIndCaseSensitive()) && !user.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS))
                      {
                        linkRow = false;
                      }
                      if ("FAD".equals(addressRow.getSzCdStage()) && !user.hasRight(UserProfile.SEC_MTN_HOME))
                      {
                        linkRow = false;
                      }
                      String tab = "   ";
                      StringBuffer caseData = new StringBuffer();
                      caseData.append("N".equals(addressRow.getBIndCaseSensitive())?"   ":" !");
                      caseData.append(tab);
                      caseData.append( bUTC ? "UTC" : "       " );
                      caseData.append(tab);
                      caseData.append(addressRow.getUlIdCase());
                      caseData.append(tab);
                      caseData.append(caseName);
                      caseData.append(tab);
                      caseData.append("Y".equals(addressRow.getCScrIndStageMerged())?"MRG":"       ");
                      caseData.append(tab);
                      caseData.append(status);
                      caseData.append(tab);
                      caseData.append(CodesTables.CINCMGST_CLD.equals(status) ? addressRow.getDtDtCaseClosed() : addressRow.getDtDtCaseOpened());
                      caseData.append(tab);
                      caseData.append(Lookup.simpleDecodeSafe(CodesTables.CSTAGES, addressRow.getSzCdStage()));
                      caseData.append(tab);
                      caseData.append(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, addressRow.getSzCdCaseCounty()));
                      caseData.append(tab);
                      caseData.append(Lookup.simpleDecodeSafe(CodesTables.CREGIONS, addressRow.getSzCdCaseRegion()));
                      caseData.append(tab);
                      caseData.append(FormattingHelper.formatStringSpecialChars(addressRow.getSzScrWorkerPrim(), "'\""));
                      caseData.append(tab);
                      String cbNameData = caseData.toString();
                      String checkboxName = "caseCopy_"+loopCount;
%>

            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                <td>
                  <impact:validateInput type="checkbox"
                                        value="<%=cbNameData%>"
                                        id="<%=checkboxName%>"
                                        name="<%=checkboxName%>"
                                        tabIndex="<%=tabIndex++%>"
                                        onClick="verifyFiveOrLess(this)"/>
                </td>
                <td><% if ("N".equals(addressRow.getBIndCaseSensitive())) {%>&nbsp;<%} else {%>!<%}%></td>
                <td><%= bUTC ? "<img alt='UTC' src='/grnds-docs/images/shared/stopLight.gif'>" : "&nbsp;" %></td> 
                <td><% if ( linkRow ) { %>
          <script type="text/javascript" language="JavaScript1.2">
            var caseName<%=loopCount%> = '<%=caseName%>';
          </script>
                  <a href="javascript:submitCaseSearch('<%=addressRow.getUlIdCase()%>', '<%=addressRow.getSzCdStage()%>', caseName<%=loopCount%>, '<%=addressRow.getSzCdCaseProgram()%>')" tabIndex='<%=tabIndex++%>'><%= addressRow.getUlIdCase() %></a>
                  <% } else { %>
                  <%= addressRow.getUlIdCase() %> <% } %>
              </td>
                <td><%= addressRow.getSzNmCase() != null? addressRow.getSzNmCase(): "&nbsp;" %></td>
                <td><% if("Y".equals(addressRow.getCScrIndStageMerged())) { %>
                    <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif"> <% } else { %>&nbsp;<% } %>
                </td>
                <td><%= status %></td>
               <td><% if(CodesTables.CINCMGST_CLD.equals(status)) { %>
                  <%=  FormattingHelper.formatDate( addressRow.getDtDtCaseClosed() ) %> <% } else {%>
                  <%= FormattingHelper.formatDate( addressRow.getDtDtCaseOpened() ) %> <% }%>
               </td>
                <td><%= Lookup.simpleDecodeSafe(CodesTables.CSTAGES, addressRow.getSzCdStage()) %></td>
                <td><%= Lookup.simpleDecodeSafe(CodesTables.CCOUNT, addressRow.getSzCdCaseCounty()) %></td>
                <td><%= Lookup.simpleDecodeSafe(CodesTables.CREGIONS, addressRow.getSzCdCaseRegion())%></td>
                <td><%= addressRow.getSzScrWorkerPrim() %></td>
            </tr>
<%
                     loopCount++;
                    } // end while
                  }
%>
           </table>
</div><% /* end div noScrollResults */ %>
<% /* CLOSE thE ROW thAT HOLDS thE SCROLL BOX */ %>
<% /* close pagination custom tag */ %>
</impact:pagination>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <impact:ButtonTag name="copyToClipboardBottom"
                        img="btnCopyToClipboard"
                        form="frmCaseList"
                        action="/workload/CaseSearch/displayCaseSummary"
                        function="populateClipboard();return false;"
                        tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<% /* end RLD */ %>
<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<Script Language="JavaScript">
</Script>

