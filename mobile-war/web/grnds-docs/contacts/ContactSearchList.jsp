<% /**
   * JSP Name:     Contact Search List
   * Created by:   Todd Reser
   * Date Created: 01/06/03
   *
   * Description:
   * This page displays the Contact Search List page using CSYS03S & CSYS04S.
   *
   **/
/* Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  01/06/03  Todd Reser        Initial page creation
  01/14/03  Todd Reser        Fixed mispelling for cbxUlIsCase
  01/15/03  Todd Reser        Implemented passing of search parameters to
                              display page
  01/17/03  Todd Reser        Dramatically increased code readability.  Fixed
                              search to filter by principals/collaterals
  01/20/03  Todd Reser        Added filtering to Type select box
  01/21/03  Todd Reser        Added filtering to Others and Purpose select
                              boxes.  Added pagination to search results.
                              Implemented forms and reports.
  01/22/03  Todd Reser        Implemented error messages when filtering of
                              select boxes fails to find a match.
  01/24/03  Todd Reser        Fixed misspelling of "Detail"
  01/27/03  Todd Reser        Removed extrenous checkmark from Expandable
                              Section.  Reformatted all tables to line up
                              properly.  Fixed color errors in tables.  Added
                              Search Results Header.  Set selects values
                              after filtering occurs.
  01/30/03  Todd Reser        Added Approval Status Button.  Implemented
                              functionality to allow CustomValidation to check
                              if ulRowSelected is valid for a New Using.
  01/31/03  Todd Reser        Optimized Imports
  02/03/03  Todd Reser        Removed Approval Status Button.
  02/04/03  Todd Reser        Reformatted tables to "proper layout standards"
  02/07/03  Todd Reser        Put ROWCSYS04SO into state
  02/08/03  Todd Reser        Now uses ContactSearchListDetailConversation.
  02/10/03  Todd Reser        Changed button actions to reflect merging of
                              conversations
  02/13/03  Todd Reser        Updated JavaDoc comments.
  02/28/03  Todd Reser        Fixed bug in Hyperlink to a contact detail causing
                              it to not pass the ulRowSelected.
  03/10/03  Todd Reser        Added PageMode Import.
  03/10/03  Stephan Brauchli  Fixed formatting of page.
  03/15/03  Todd Reser        Added deletedDetail functionality to allow page to
                              display properly after being navigated to from
                              the Detail page after Delete is pressed.
  03/19/03  Todd Reser        Implemented PageModes.
  03/20/03  Todd Reser        Switched displayContact to use hdnUlRowSelected.
                              Implemented style guide quick fixes.
  03/25/03  Todd Reser        Added SearchResultsAnchor.
  03/26/03  Todd Reser        QA Sweep.
  04/08/03  Todd Reser        Fixed bug in Form Launch "asking to press save."
  04/14/03  Todd Reser        Removed RestrictRepost from Add button to stop
                              erroneous errors because the Add button doesn't
                              perform a save on this page.
  05/02/03  Todd Reser        Changed Forms parameter dtDtSampleTo to
                              pDtSampleTo. Added EditableMode=ALL to Search.
  05/05/03  Todd Reser        Set EditableMode to All on New Using and Add
                              buttons, added logic to only show buttons when not
                              entering from Case Summ in browse mode, and F/A
                              List in any mode.  Changed filtering of Others to
                              use key "K" for ARI & ARF, added key K to
                              filtering of Purpose.
  05/16/03  Todd Reser        Rewrote rwocsys04so get routine.
  05/21/03  Todd Reser        Recoded PopulateType(), PopulateLocation(),
                              PopulateOthers() and PopulateMethod() because PAL
                              was missing, and Location wasn't clearing.
  05/27/03  Todd Reser        Set EditableMode.Modify on Contact Add, New Using
                              and Radio Buttons, unless the stage is closed.
  06/10/03  Todd Reser        SIR 18155 -- moved pagionation tags and search
                              button outside of table, switched add and new
                              using buttons.
  06/26/03  Todd Reser        SIR 18462 added disableNewUsing to btnNewUsing.
  07/25/03  Todd Reser        Modified imports to be one import per line.
                              SIR 19074 - Removed if statement that was hiding
                              search results when there was an error message.
  08/12/03  Todd Reser        Added Anchor to top of form so when an error is
                              thrown upon form or report launch we can refocus
                              on the anchor so the error message will be
                              noticed.  Added function to get the From and To
                              dates if they exist.  If they don't default To
                              today. If From is missing display an error.
                              (SIR 19320)
  08/18/03  Todd Reser        In launchFormReport set first parameter of
                              setErrorMsg call to an empty string so that it
                              would not keep adding to the error message, and
                              reworded error message.
  08/21/03  Eric Dickman      Sir 19562 -- Changed how the TO_DATE is populated.
                              Then changed the date into a string.
  08/29/03  Todd Reser        Removed Top Anchor, removed Error message display
                              when Form or Report is launched without having a
                              From date.  Defaulted From date to CASTOR_DATE_MIN
  02/09/04  Todd Reser        SIR 22596 - fixes a bug introduced by SIR 18956.
                              "24 Hour Contact" and "Initial Face To Face" were
                              erroneously shown twice.
  02/03/05  Hari Maralla      SIR 23272 - excluded ALIC (Licensing Investigation Report)
                              Contracts Type (DropDown) for CPS Program and INV Stage.
  07/24/05    Mike Werle      SIR 23728 For MPS, hide Add when pending approval.
  09/08/08  charden			  STGAP00010137 - changed SzCdStagePersRole() to use CINVROLE 
  							  instead of CINTROLE so that PC's would show up in the FCC stage
  10/31/09  mchillman         STGAP00010898 Added code for ADO Sealing
  
  06/01/09  cwells            STGAP00013826 Checking to see if user was ever assigned to a case if so
      						  we want to display the add button even if the stage is closed
  07/04/09  arege             STGAP00014326 MR-024 Changes to include Purpose options on the Contact Search List page
  07/09/09  arege             STGAP00014327 MR-024 Changes
  07/25/09  arege             STGAP00014327 Set All Contacts in Case Checkbox to be selected by default.
  07/28/09  arege             STGAP00014866 Removed Contact Visitation Form option from the Forms Launch Drop Down.
  07/30/09  arege             STGAP00014857 CaseWorkers with SAU Sealed Attribute should be able to add and modify
                              contacts
  09/14/09  arege             STGAP00015358 MR-024 Contact Search List Page Purpose fields disabled for persons not assigned to case.
                              Added editableMode to cbxContactPurpose tag.
  02/17/10  swroberts         Added sortable feature for contact date column.
  01/19/11  wcochran          Fixed formatting for contacts with multiple purposes
*/

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.DynamicContactDAO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%

  ServerSideValidationUtility.setBRefreshWidgetsFromRequest( request, true );
  BaseSessionStateManager state = (BaseSessionStateManager)
          request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //Setup csys03 objects (Principals/Collaterals contacted)
  CSYS03SO csys03so = (CSYS03SO)request.getAttribute( "CSYS03SO" );
  if( csys03so == null )
  {
    csys03so = new CSYS03SO();
  }
  ROWCSYS03SOG01_ARRAY rowcsys03sog01Array;
  if( csys03so.getROWCSYS03SOG01_ARRAY() != null )
  {
    rowcsys03sog01Array = csys03so.getROWCSYS03SOG01_ARRAY();
  }
  else
  {
    rowcsys03sog01Array = new ROWCSYS03SOG01_ARRAY();
  }
  ROWCSYS03SOG01 csys03sog01Row;
  Enumeration csys03sog01Enumeration = rowcsys03sog01Array.enumerateROWCSYS03SOG01();

  //Setup csys04 objects (Search results)
  ROWCSYS04SO_ARRAY rowcsys04soArray = (ROWCSYS04SO_ARRAY)state.getAttribute( "rowcsys04soArray", request );
  rowcsys04soArray = rowcsys04soArray != null ? rowcsys04soArray : new ROWCSYS04SO_ARRAY();

  ROWCSYS04SO csys04soRow;
  Enumeration csys04soEnumeration = rowcsys04soArray.enumerateROWCSYS04SO();

  //Declare Constants and initialize Page Variables
  int tabIndex = 1;
  int loopCount = 0;
  String pageMode = PageMode.getPageMode( request );
  int ulIdStage = GlobalData.getUlIdStage( request );
  String szFormCdContactTypePVC = "PVC";
  String szCdStage = GlobalData.getSzCdStage( request );
  String szCdStageProgram = GlobalData.getSzCdStageProgram( request );
  String dtScrSearchDateFrom = FormattingHelper.formatDate(
          ContextHelper.getCastorDateSafe( request, "dtScrSearchDateFrom" ) );
  String dtScrSearchDateTo = FormattingHelper.formatDate(
          ContextHelper.getCastorDateSafe( request, "dtScrSearchDateTo" ) );
  
  String selSzCdContactType = ContextHelper.getStringSafe( request, "selSzCdContactType" );
  List<String> checkedPurposeList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxContactPurpose")); // STGAP00014326 MR-024 
  String selSzCdContactMethod = ContextHelper.getStringSafe( request, "selSzCdContactMethod" );
  String selSzCdContactLocation = ContextHelper.getStringSafe( request, "selSzCdContactLocation" );
  String selSzCdContactOthers = ContextHelper.getStringSafe( request, "selSzCdContactOthers" );

  String fromDetailPage = ContextHelper.getStringSafe( request, "hdbDetailPage" );
   String previousURL = ContextHelper.getPreviousUrl(request);
   if(previousURL.equals(ContactSearchListDetailConversation.DISPLAY_DETAIL_PAGE)) {
    fromDetailPage = "true";
   	selSzCdContactType = "";
   	checkedPurposeList = new ArrayList<String>();
   	selSzCdContactMethod = "";
   	selSzCdContactLocation = "";
   	selSzCdContactOthers = "";
   }
  
  
  
 // String cbxUlIsCase = "false";
  String cbxUlIsCase = null;
  String cbxUlIsCaseChecked = "false";
  String strIndCanAddContact = (String) state.getAttribute("allowContactAdd", request);

  if(request.getParameter("cbxUlIsCase") == null){
   cbxUlIsCase = "on";
  }else{
   cbxUlIsCase = ContextHelper.getStringSafe( request, "cbxUlIsCase" );
  }
  if("true".equals(request.getAttribute("SEARCH_ENTIRE_CASE"))){
  cbxUlIsCase = "true";
  }
    if("on".equals(cbxUlIsCase)){
   cbxUlIsCaseChecked = "true";
  }
  if( request.getAttribute( "deletedDetail" ) != null )
  {
    dtScrSearchDateFrom = "";
    dtScrSearchDateTo = "";
    selSzCdContactType = "";
    selSzCdContactMethod = "";
    selSzCdContactLocation = "";
    selSzCdContactOthers = "";
    cbxUlIsCase = "";
  }

  UserProfile user = UserProfileHelper.getUserProfile( request );

%>
<script type="text/javascript" language="JavaScript1.2">
 
 window.onload = function()
 {
   checked = '<%= cbxUlIsCase %>';
   if (checked == 'true') {
     document.frmContactSearchList.cbxUlIsCase.checked = true;
     <% cbxUlIsCase = "on"; %>
   }
 }
  
  function launchContactDetail( contactIndex, contactType )
  {
    document.frmContactSearchList.hdnUlRowSelected.value = contactIndex;
    document.frmContactSearchList.selSzCdContactType.value = contactType;
    submitValidateForm('frmContactSearchList', '/contacts/ContactSearchListDetail/displayContact');
  }

  function setHdnContactType( aString )
  {
    frmContactSearchList.hdnContactType.value = aString;
  }
  
  function caseSummaryHyperlink()
  {
    disableValidation("frmContactSearchList");
    submitValidateForm("frmContactSearchList", "/workload/CaseSummary/displayCaseSummary");
  }
  
  function stageSummaryHyperlink()
  {
    disableValidation("frmContactSearchList");
    submitValidateForm("frmContactSearchList", "/workload/StageSummary/displayStage");
  }
  
</script>

<impact:validateErrors/>
<impact:validateForm name="frmContactSearchList" method="post"
                     action="/contacts/ContactSearchListDetail/displayContactSearchList"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListCustomValidation"
                     pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
<impact:validateInput type="hidden" name="hdnContactType"/>
<impact:validateInput type="hidden" name="hdnUlRowSelected"/>
<impact:validateInput type="hidden" name="hdnCanAddContact" value="<%= strIndCanAddContact %>"/>
<impact:validateInput type="hidden" name="hdbDetailPage" value="<%= fromDetailPage %>"/>

<div id="caseStageHeaderInfo">
  <span id="caseNameInfo">
		Case: <a href='<%="javascript:caseSummaryHyperlink();"%>'
                               onClick="window.onBeforeUnload=null;" tabIndex="0"
          ><%=GlobalData.getSzNmCase( request )%>
   </a>
  </span>
  <span id="stageNameInfo">
		 Stage: <a href='<%="javascript:stageSummaryHyperlink();"%>'
                               onClick="window.onBeforeUnload=null;" tabIndex="0"
          >
		 <%=GlobalData.getSzNmStage( request )%>, <%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage( request ))%>
		 </a>
  </span>
</div>

<div id="pageNav">
<ul>
	<li class="lvl2NavSelect tab">Contact Search</li>
</ul>
</div>
<impact:ifServerImpact>
<impact:ExpandableSectionTag name="ContactSearch"
                             id="ctSearchOpen" label="Contact Search" tabIndex="<%=tabIndex++%>">
                             
                             

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr class="subDetail">
    <th colspan="2">Search Parameters</th>
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
      <impact:validateDate label="Date From"
                           constraint="Date"
                           name="dtScrSearchDateFrom"
                           disabled="false"
                           value="<%= dtScrSearchDateFrom %>"
                           conditionallyRequired="true"
                           size="8"
                           tabIndex="<%=tabIndex++%>"
                           editableMode="<%=EditableMode.ALL%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
      <impact:validateDate label="Date To"
                           constraint="Date"
                           name="dtScrSearchDateTo"
                           disabled="false"
                           value="<%= dtScrSearchDateTo %>"
                           size="8"
                           tabIndex="<%=tabIndex++%>"
                           editableMode="<%=EditableMode.ALL%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
      <impact:validateSelect label="Type"
                             name="selSzCdContactType"
                             disabled="false"
                             options="<%= ContactSearchListDetailConversation.getTypeOptions(request) %>"
                             value="<%= selSzCdContactType %>"
                             tabIndex="<%=tabIndex++%>"
                             editableMode="<%=EditableMode.ALL%>"/>
    </td>
  </tr>
  <tr class="subDetail">
    <td class="formlabel">
      <impact:validateSelect label="Location"
                             name="selSzCdContactLocation"
                             codesTable="CCNCTLOC"
                             disabled="false"
                             value="<%= selSzCdContactLocation %>"
                             tabIndex="<%=tabIndex++%>"
                             editableMode="<%=EditableMode.ALL%>"/>
    </td>
  </tr>
  <tr class="subDetail">    
    <td class="formlabel">
      <impact:validateSelect label="Method"
                             name="selSzCdContactMethod"
                             disabled="false"
                             options="<%= ContactSearchListDetailConversation.getMethodOptions(request, false) %>"
                             value="<%= selSzCdContactMethod %>"
                             tabIndex="<%=tabIndex++%>"
                             onChange="populateLocation()"
                             editableMode="<%=EditableMode.ALL%>"/>
    </td>
    </tr>
  <tr class="subDetail">
     <td class="formlabel">
      <impact:validateSelect label="Others Contacted"
                             name="selSzCdContactOthers"
                             codesTable="COTHCNCT"
                             disabled="false"
                             value="<%= selSzCdContactOthers %>"
                             tabIndex="<%=tabIndex++%>"
                             editableMode="<%=EditableMode.ALL%>"/>
    </td>  
  </tr>
  <tr class="subDetail">   
    <td colspan="2">
      <impact:validateInput label="All contacts in the case"
                            name="cbxUlIsCase"
                            type="checkbox"
                            editableMode="<%=EditableMode.ALL%>"
                            checked='<%= cbxUlIsCaseChecked %>'
                            value='<%= cbxUlIsCase %>'
                            tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>  
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
  <tr>
    <th colspan="4">Search by Principals/Collaterals Contacted</th>
  </tr>
  <tr class="subDetail">
    <td colspan="4">
     
        <table width="100%" border="0" cellspacing="0" cellpadding="3">
          <tr class="thList">
            <td width="25%">Name</td>
            <td>Type</td>
            <td>Role</td>
            <td>Relation/Interest</td>
          </tr>
          <%
            if( !csys03sog01Enumeration.hasMoreElements() )
            {
          %>
          <tr class="odd">
            <td colspan="4">
              <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
            </td>
          </tr>
          <%
          }
          else
          {
            while( csys03sog01Enumeration.hasMoreElements() )
            {
              csys03sog01Row = (ROWCSYS03SOG01)csys03sog01Enumeration.nextElement();
              String cbxUlIdPersonValue = null;
              if( request.getAttribute( "deletedDetail" ) == null )
              {
                cbxUlIdPersonValue = FormattingHelper.formatInt( csys03sog01Row.getUlIdPerson() );
              }//STGAP00010137 - changed SzCdStagePersRole() to use CINVROLE instead of CINTROLE so that PC's would
              //show up in the FCC stage
          %>
          <tr <% if( loopCount % 2 == 1 ) { %>class="altcolor"<% } %> >
            <td>
              <impact:validateInput tabIndex="<%= tabIndex++ %>"
                                    value="<%= cbxUlIdPersonValue %>"
                                    editableMode="<%=EditableMode.ALL%>"
                                    type="checkbox"
                                    name='<%= "cbxUlIdPerson" + loopCount %>'/>
              <%= csys03sog01Row.getSzNmPersonFull() %>
            </td>
            <td><%= Lookup.simpleDecodeSafe( "CPRSNTYP", csys03sog01Row.getSzCdStagePersType() ) %></td>
            <td><%= Lookup.simpleDecodeSafe( "CINVROLE", csys03sog01Row.getSzCdStagePersRole() ) %></td>
            <td><%= Lookup.simpleDecodeSafe( "CRPTRINT", csys03sog01Row.getSzCdStagePersRelInt() ) %></td>
          </tr>
          <%
                loopCount++;
              } // end while csys03sog01Enumeration.hasMoreElements()
            } // end else !csys03sog01Enumeration.hasMoreElements()
          %>
        </table>
    </td>
  </tr>
</table>
<% /* SIR 18155 -- moved search button outside of table */ %>
<table width="100%" cellpadding="3" border="0" cellspacing="0">
        <tr>
        <td>
<impact:ButtonTag name="btnSearch"
                  img="btnSearch"
                  form="frmContactSearchList"
                  action="/contacts/ContactSearchListDetail/displayContactSearchList"
                  align="right"
                  editableMode="<%= EditableMode.ALL %>"
                  tabIndex="<%= tabIndex++ %>"/>
</td>
        </tr>
        </table>
</impact:ExpandableSectionTag>
<br>
</impact:ifServerImpact>
<a name="SearchResultsAnchor"/>
<%
  // SIR 18462 Default disableNewUsing to false.
  // For MPS, new using is ALWAYS disabled, so or-in the platform constant to force it to be disabled on MPS.
  boolean disableNewUsing = false || PlatformConstants.MOBILE_IMPACT;
  boolean disableAddButton = false;
  int showAddButton = EditableMode.MODIFY;

  // SIR 23728 For MPS, hide Add when pending approval.
  String conclTaskCode = "6010";
  if( CodesTables.CSTAGES_INV.equals( GlobalData.getSzCdStage( request ) ) )
  {
     conclTaskCode = "2120";
  }

  CaseUtility.Event apsCnclEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
          conclTaskCode);
  boolean pendStageProg = (apsCnclEvent.getCdEventStatus() != null ?
          CodesTables.CEVTSTAT_PEND.equals(apsCnclEvent.getCdEventStatus()): false);
  disableAddButton = pendStageProg && PlatformConstants.MOBILE_IMPACT;

  // SIR 19074 - Removed if statement that was hiding the search results when
  // there was an error message.
  // if( !FormValidation.pageHasErrorMessages( request ) &&
  //    !FormValidation.pageHasValidationMessages( "frmContactSearchList", request ) )

  /* SIR 18155 -- moved pagionation tag outside of table */
%>
<impact:pagination submitUrl="/contacts/ContactSearchListDetail/displayContactSearchList" saveState="false">
  <table id="results1" border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
     
        <table id="results2" border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr class="thList">
            <td width="33%">Date <impact:sortableColumnHeader orderBy="<%= DynamicContactDAO.CONTACT_DATE_SORT %>" isDefault="true"/> </td>
            <td width="33%">Purpose</td>
            <td width="33%">Name</td>
          </tr>
            <%
              loopCount = 0;
              if( !csys04soEnumeration.hasMoreElements() )
              {
                // SIR 18462 Disable New Using when there are no Contacts.
                disableNewUsing = true;
            %>
          <tr class="odd">
            <td colspan="5">
              <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
            </td>
          </tr>
          <%
          } else {
            int idPrevEvent = 0;
            while (csys04soEnumeration.hasMoreElements() ) {              
              csys04soRow = (ROWCSYS04SO)csys04soEnumeration.nextElement();
              int idEvent = csys04soRow.getUlIdEvent();  // STGAP00014326 MR-024 
              String contactTypeSubstring = "";
              String fullContactType = csys04soRow.getSzCdContactType();
              if(fullContactType != null && fullContactType.length() > 3)  {
                contactTypeSubstring = fullContactType.substring( 1, 4 );
              }
          %>
          <tr <% if( loopCount % 2 == 1 ) { %>class="altcolor"<% } %> >
            <%
              // We have to create a string because the compiler won't work
              // properly. For some reason the less than percent equals HAS to
              // be the first thing after a quote or the compiler won't evaluate
              // it properly.
              String hdnStageCodeFn = "setHdnContactType('" + contactTypeSubstring + "')";
              String szCdContactType = csys04soRow.getSzCdContactType();
            %>
            <%if (idEvent != idPrevEvent){ %>
            <td><impact:ifServerImpact><impact:validateInput tabIndex="<%= tabIndex++ %>"
                                                             value="<%= String.valueOf(loopCount) %>"
                                                             type="radio" name="ulRowSelected"
                                                             onClick="<%= hdnStageCodeFn %>"
                                                             editableMode="<%=EditableMode.MODIFY%>"/>
              </impact:ifServerImpact>
              <a href="javascript:launchContactDetail(<%= loopCount %>, '<%= szCdContactType %>')" tabIndex="<%= tabIndex++ %>">
              	<%= FormattingHelper.formatDate( csys04soRow.getDtDTContactOccurred() ) %></a>
            </td>
            <%} %>
            
            
            
          <%if (idEvent != idPrevEvent){ %>
            <td><%= Lookup.simpleDecodeSafe( "CCNTPURP", csys04soRow.getSzCdContactPurpose() ) %></td>
            <%
             } else {
              %>
            <td></td><td><%= Lookup.simpleDecodeSafe( "CCNTPURP", csys04soRow.getSzCdContactPurpose() ) %></td>
            <td> </td> <td> </td>
             <% }
              %>
             <%if (idEvent != idPrevEvent){ %>
            <td><%= FormattingHelper.formatString( csys04soRow.getSzScrNmContact1() ) %></td>
             <% }
              %>
           </tr>
          <%
                idPrevEvent = idEvent;
                loopCount++;
              } // end while
            } // end if !csys04soEnumeration.hasMoreElements()
          %>
        </table>
  
      </td>
    </tr>
  </table>
  <% /* SIR 18155 -- moved pagionation tag outside of table */ %>
</impact:pagination>

<table width="100%" border="0" cellpadding="3" cellspacing="0">
  <tr>
    <td align="right">
      <%
        // Do not display the buttons if the user has come from Case Summary and is in
        // browse mode or if the user has come from F/A Home List.
        String prevUrl = ContextHelper.getPreviousUrl( request );
        if( ( !"/fad/FAHomeSearch/faHomeSearch".equals( prevUrl ) &&
              !"/workload/CaseSummary/displayCaseSummary".equals( prevUrl ) ) ||
            ( "/workload/CaseSummary/displayCaseSummary".equals( prevUrl ) && !pageMode.equals( PageModeConstants.VIEW ) ) )
        {
          // The Add button has an editable mode of all so that you can add a Closed
          // Stage Addendum.  The Detail page will catch anyone who tries to add to a
          // stage that is not closed and they don't have access

          // JMC - SIR 17663 - In VIEW mode, the add button should only show up if the stage is
          // closed.  if the stage is open and we are in view mode, we disable the add button.
          if( ArchitectureConstants.N.equals( request.getAttribute( "stageIsClosed" ) ) &&
              PageModeConstants.VIEW.equals( pageMode )
               )
          {
            disableAddButton = true;
          }

          /* SIR 18155 -- switched add and new using buttons */
          // SIR 18462 added disableNewUsing to New Using button.

          // MKW -- disable the Add and New Using buttons if we are in approval mode for a stage closure event
          if( GlobalData.isStageClosureBeingApproved( request ) )
          {
            disableAddButton = true;
            disableNewUsing = true;
          }
          // STGAP00014023 If the case Manager was ever assigned to the stage then we want to 
          //  allow them to add a contact to that closed stage.  Setting the EditableMode attribute
          // will display the button even if the page mode of the form has been set to VIEW. 
          
          //For a given tag, the <code>editableMode</code> attribute supersedes the definition given by the
          //* <code>FormTag</code>'s <code>pageMode</code> attribute.
                  
         if(ArchitectureConstants.Y.equals(state.getAttribute( "allowAddOnClosedStage", request )) ||
            ArchitectureConstants.TRUE.equals((String) state.getAttribute("SAUSEALEDHOMEANDWORKER",request))){
          showAddButton = EditableMode.ALL;
          }
          
      //SMS#52234: SAU_SEALED users should not be able to add Contacts if not assigned to the stage     
          if(!GlobalData.hasStageAccess(request)){
          disableAddButton = true;
          }
      %>
      <impact:ButtonTag name="btnNewUsing"
                        img="btnNewUsing"
                        form="frmContactSearchList"
                        action="/contacts/ContactSearchListDetail/displayContact"
                        editableMode="<%= EditableMode.MODIFY %>"
                        disabled='<%=disableNewUsing ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE%>'
                        tabIndex="<%= tabIndex++ %>"/>
      <impact:ButtonTag name="btnAdd"
                        img="btnAdd"
                        form="frmContactSearchList"
                        action="/contacts/ContactSearchListDetail/addContact"
                        disabled="<%= disableAddButton ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE %>"
                        tabIndex="<%= tabIndex++ %>"
                        editableMode="<%= showAddButton %>"/>
      <%
        }
      %>
    </td>
  </tr>
</table>
<br>
</impact:validateForm>