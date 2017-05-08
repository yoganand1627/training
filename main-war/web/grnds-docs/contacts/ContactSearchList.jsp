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
  06/01/10  arege             SMS#52234: SAU_SEALED users should not be able to add Contacts unless assigned to the stage.
  08/14/10  bgehlot           SMS#66380: MR072 08/16/10  bgehlot           66380 MR072 Add new field Discussed/In Reference to 
  
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
  //CAPTA 4.3
  String strAllowAdd = (String) state.getAttribute("allowContactAddForDeputyDtr", request);

  // SIR 22596 fixes a bug introduced by SIR 18956.  "24 Hour Contact" and
  // "Initial Face To Face" were erroneously shown twice.

  // Create an array list of exclusions for the Type Select box
  //List excludeType = new ArrayList();

  // Supress the extra listings from the select box.
  // Hide C24H & CFTF if it's a SVC or AOC Case
  //if( CodesTables.CSTAGES_SVC.equals( szCdStage ) ||
  //    CodesTables.CSTAGES_AOC.equals( szCdStage ) )
  //{
    //excludeType.add( CodesTables.CCNTCTYP_C24H ); // Hide C24H
    //excludeType.add( CodesTables.CCNTCTYP_CFTF ); // Hide CFTF
  //}
  // Hide C24N & CIFF if it's an INV stage
  //if( CodesTables.CSTAGES_INV.equals( szCdStage ) )
  //{
    //excludeType.add( CodesTables.CCNTCTYP_C24N ); // Hide C24N
    //excludeType.add( CodesTables.CCNTCTYP_CIFF ); // Hide CIFF
  //}

  // SIR 23272 - excluded ALIC from Contracts Type Dropdown, from CPS program and INV stages
  //if( CodesTables.CSTAGES_INV.equals( szCdStage ) &&
  //    CodesTables.CPGRMS_CPS.equals( szCdStageProgram ) )
  //{
    //excludeType.add( CodesTables.CCNTCTYP_ALIC ); // Hide ALIC
  //}

%>
<%--
<script type="text/javascript" language="JavaScript1.2">
<impact:ifServerImpact>
 Stage = "<%= szCdStage %>";
  Program = "<%= szCdStageProgram %>";
  var sTotalMsg = '';
  ADO = "ADO";
  AFC = "AFC";
  AOC = "AOC";
  APS = "APS";
  ARI = "ARI";
  ARF = "ARF";
  CCL = "CCL";
  CPS = "CPS";
  FAD = "FAD";
  FPR = "FPR";
  FRE = "FRE";
  FSU = "FSU";
  INT = "INT";
  INV = "INV";
  PAD = "PAD";
  PAL = "PAL";
  RCL = "RCL";
  SUB = "SUB";
  SVC = "SVC";

  <% /* SIR 22596 - Had to add excludeOptions to codeArray */ %>
  <impact:codeArray codeName="CCNTCTYP" excludeOptions="<%= excludeType %>" arrayName="CCNTCTYP" blankValue="true"/>
  <impact:codeArray codeName="CCNTPURP" arrayName="CCNTPURP" blankValue="true"/>
  <impact:codeArray codeName="COTHCNCT" arrayName="COTHCNCT" blankValue="true"/>
  <impact:codeArray codeName="CCNCTLOC" arrayName="CCNCTLOC" blankValue="true"/>

  function populateMethod()
  {
    frmContactSearchList.selSzCdContactMethod.value = '<%= selSzCdContactMethod %>';
  }

  function populateType()
  {
    Key = null;

    if( Stage == "<%= CodesTables.CSTAGES_INV %>" &&
        ( Program == "<%= CodesTables.CPGRMS_CCL %>" ||
          Program == "<%= CodesTables.CPGRMS_RCL %>" ||
          Program == "<%= CodesTables.CPGRMS_CPS %>" ) )
    {
      // If we are in a CPS or CCL or RCL and Investigation filter on "A"
      Key = "A";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_FPR %>" ||
        Stage == "<%= CodesTables.CSTAGES_FRE %>" ||
        Stage == "<%= CodesTables.CSTAGES_FSU %>" )
    {
      // If Service Delivery and CPS
      Key = "B";
    }
    else if( ( Stage == "<%= CodesTables.CSTAGES_INV %>" ||
          Stage == "<%= CodesTables.CSTAGES_SVC %>" ||
          Stage == "<%= CodesTables.CSTAGES_AOC %>" )
            && Program == "<%= CodesTables.CPGRMS_APS %>" )
    {
      // If Service Delivery or Investigation and APS
      Key = "C";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_INT %>" )
    {
      // If Intake
      Key = "D";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_PAL %>" )
    {
      //If PAL
      Key = "J";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_INV %>" &&
        Program == "<%= CodesTables.CPGRMSFM_AFC %>" )
    {
      // If Investigation and Facilities
      Key = "E";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_SUB %>" )
    {
      // If Substitute Care or Preparation for Adult Living, PAL
      Key = "G";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_ADO %>" ||
             Stage == "<%= CodesTables.CSTAGES_PAD %>" )
    {
      // If Adoption
      Key = "H";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_FAD %>" )
    {
      // If Foster Adoptive Home
      Key = "I";
    }
    else if( Stage == "<%= CodesTables.CSTAGES_ARI %>" ||
             Stage == "<%= CodesTables.CSTAGES_ARF %>" )
    {
      // Admin Review
      Key = "K";
    }
    // If none of the program/stage combinations match the expected results,
    //   display an error message
    if( Key == null )
    {
      sTotalMsg = setErrorMsg(sTotalMsg,
              getFieldErrorMsg("Error occurred while returning data.  Contact Tech Support for assistance.",
                      frmContactSearchList, frmContactSearchList.selSzCdContactType));
      displayErrors(sTotalMsg, frmContactSearchList.selSzCdContactType);
    }
    else
    {
      populateFilteredDropdown(Key, frmContactSearchList.selSzCdContactType, CCNTCTYP, true);
      frmContactSearchList.selSzCdContactType.value = '<%= selSzCdContactType %>';
    }
  }

  function populatePurpose()
  {
    Key = null;
    // If APS or AFC Investigation or Service Delivery
    if( ( Stage == "<%= CodesTables.CSTAGES_INV %>" &&
          ( Program == "<%= CodesTables.CPGRMS_APS %>" ||
            Program == "<%= CodesTables.CPGRMS_AFC %>" ) ) ||
        ( Stage == "<%= CodesTables.CSTAGES_SVC %>" ||
          Stage == "<%= CodesTables.CSTAGES_AOC %>" ||
          Stage == "<%= CodesTables.CSTAGES_FPR %>" ) )
    {
      Key = "A";
    }
    // If Investigation - Licensing or CPS
    if( Stage == "<%= CodesTables.CSTAGES_INV %>" &&
        ( Program == "<%= CodesTables.CPGRMSFM_CCL %>" ||
          Program == "<%= CodesTables.CPGRMSFM_RCL %>" ||
          Program == "<%= CodesTables.CPGRMSFM_CPS %>" ) )
    {
      Key = "B";
    }
    // If PAL or Foster Adoptive Home
    if( Stage == "<%= CodesTables.CSTAGES_PAL %>" ||
        Stage == "<%= CodesTables.CSTAGES_FAD %>" )
    {
      Key = "I";
    }
    // If Intake
    if( Stage == "<%= CodesTables.CSTAGES_INT %>" )
    {
      Key = "D";
    }
    // If Adoption
    else if( Stage == "<%= CodesTables.CSTAGES_ADO %>" ||
             Stage == "<%= CodesTables.CSTAGES_PAD %>" )
    {
      Key = "H";
    }
    // If Substitute Care
    else if( Stage == "<%= CodesTables.CSTAGES_SUB %>" ||
             Stage == "<%= CodesTables.CSTAGES_FRE %>" ||
             Stage == "<%= CodesTables.CSTAGES_FSU %>" )
    {
      Key = "G";
    }
    // Admin Review
    else if( Stage == "<%= CodesTables.CSTAGES_ARI %>" ||
             Stage == "<%= CodesTables.CSTAGES_ARF %>" )
    {
      Key = "K";
    }
    // If none of the program/stage combinations match the expected results,
    // display an error message
    if( Key == null )
    {
      sTotalMsg = setErrorMsg(sTotalMsg,
              getFieldErrorMsg("Error occurred while returning data.  Contact Tech Support for assistance.",
                      frmContactSearchList, frmContactSearchList.selSzCdContactPurpose));
      displayErrors(sTotalMsg, frmContactSearchList.selSzCdContactPurpose);
    }
    else
    {
      populateFilteredDropdown(Key, frmContactSearchList.selSzCdContactPurpose, CCNTPURP, true);
      frmContactSearchList.selSzCdContactPurpose.value = '<%= selSzCdContactPurpose %>';
    }
  }

  function populateOthers()
  {
    Key = null;
    // If Service Delivery or Investigation and APS
    if( (Stage == "<%= CodesTables.CSTAGES_INV %>" ||
         Stage == "<%= CodesTables.CSTAGES_SVC %>" ||
         Stage == "<%= CodesTables.CSTAGES_AOC %>" ) &&
         Program == "<%= CodesTables.CPGRMSFM_APS %>" )
    {
      Key = "A";
    }
    // If Service Delivery, Investigation, CPS or Licensing
    else if( ( Stage == "<%= CodesTables.CSTAGES_INV %>" ||
               Stage == "<%= CodesTables.CSTAGES_FPR %>" ) &&
             ( Program == "<%= CodesTables.CPGRMS_CPS %>" ||
               Program == "<%= CodesTables.CPGRMS_RCL %>" ||
               Program == "<%= CodesTables.CPGRMS_CCL %>" ) )
    {
      Key = "B";
    }
    // If Investigation and Facilities
    else if( Stage == "<%= CodesTables.CSTAGES_INV %>" &&
             Program == "<%= CodesTables.CPGRMS_AFC %>" )
    {
      Key = "C";
    }
    // If Intake
    else if( Stage == "<%= CodesTables.CSTAGES_INT %>" )
    {
      Key = "D";
    }
    // If PAL
    else if( Stage == "<%= CodesTables.CSTAGES_PAL %>" )
    {
      Key = "H";
    }
    // If Foster Adoptive Home, Adoption, or Substitute Care
    else if( Stage == "<%= CodesTables.CSTAGES_ADO %>" ||
             Stage == "<%= CodesTables.CSTAGES_SUB %>" ||
             Stage == "<%= CodesTables.CSTAGES_FAD %>" ||
             Stage == "<%= CodesTables.CSTAGES_PAD %>" ||
             Stage == "<%= CodesTables.CSTAGES_FRE %>" ||
             Stage == "<%= CodesTables.CSTAGES_FSU %>" )
    {
      Key = "G";
    }
    // Admin Review
    if( Stage == "<%= CodesTables.CSTAGES_ARI %>" ||
        Stage == "<%= CodesTables.CSTAGES_ARF %>" )
    {
      Key = "K";
    }
    // If none of the program/stage combinations match the expected results,
    // display an error message
    if( Key == null )
    {
      sTotalMsg = setErrorMsg(sTotalMsg,
              getFieldErrorMsg("Error occurred while returning data.  Contact Tech Support for assistance. Stage=" +
                               Stage + " Program=" + Program,
                      frmContactSearchList, frmContactSearchList.selSzCdContactOthers));
      displayErrors(sTotalMsg, frmContactSearchList.selSzCdContactOthers);
    }
    else
    {
      populateFilteredDropdown(Key, frmContactSearchList.selSzCdContactOthers, COTHCNCT, true);
      frmContactSearchList.selSzCdContactOthers.value = '<%= selSzCdContactOthers %>';
    }
  }

  function populateLocation()
  {
    populateDropdown(frmContactSearchList.selSzCdContactLocation, "", CCNCTLOC);
    frmContactSearchList.selSzCdContactLocation.value = '<%= selSzCdContactLocation %>';
  }

</impact:ifServerImpact>
--%>
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
<impact:ifServerImpact>
<impact:ExpandableSectionTag name="ContactSearch"
                             id="ctSearchOpen" label="Contact Search" tabIndex="<%=tabIndex++%>">

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr class="subDetail">
    <th colspan="4">Search Parameters</th>
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
                             editableMode="<%=EditableMode.ALL%>"
                             style="WIDTH: 175"/>
    </td>
    <td class="formlabel">
      <impact:validateSelect label="Location"
                             name="selSzCdContactLocation"
                             codesTable="CCNCTLOC"
                             disabled="false"
                             value="<%= selSzCdContactLocation %>"
                             tabIndex="<%=tabIndex++%>"
                             style="width: 150px"
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
     <td class="formlabel">
      <impact:validateSelect label="Others Contacted"
                             name="selSzCdContactOthers"
                             codesTable="COTHCNCT"
                             disabled="false"
                             value="<%= selSzCdContactOthers %>"
                             tabIndex="<%=tabIndex++%>"
                             editableMode="<%=EditableMode.ALL%>"
                             style="WIDTH: 175"/>
    </td>  
  </tr>
  <tr class="subDetail">   
    <td colspan="4">
      <impact:validateInput label="All contacts in the case"
                            name="cbxUlIsCase"
                            type="checkbox"
                            editableMode="<%=EditableMode.ALL%>"
                            checked='<%= cbxUlIsCaseChecked %>'
                            value='<%= cbxUlIsCase %>'
                            tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <!--  
  <tr class="subDetail">
    <th colspan="4">Advanced Search</th>
  </tr>
  -->
  
</table>

<table>
<tr>
    <th colspan="4">Purpose</th>
</tr>
<tr class="subDetail">
   <td colspan="4"> 
      <impact:codesCheckbox 
                name="cbxContactPurpose"
                columns="3"
                codesTableName="<%= CodesTables.CCNTPURP %>"
                disabled="false"     
                editableMode="<%=EditableMode.ALL%>"
                tabIndex="<%=tabIndex++ %>" 
       />
      </td>
</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
  <tr>
    <th colspan="4">Search by Principals/Collaterals Contacted or Discussed/In Reference To</th>
  </tr>
  <tr class="subDetail">
    <td colspan="4">
      <div id="scroll4" style="width:100%; height:125px; overflow:auto" class="tableBorderList">
        <table width="100%" border="0" cellspacing="0" cellpadding="3">
          <tr class="thList">
            <td width="25%">Name</td>
            <td>Contacted</td>
            <td>Discussed/In Reference To</td>
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
              <%= csys03sog01Row.getSzNmPersonFull() %>
            </td>
            <td>
              <impact:validateInput tabIndex="<%= tabIndex++ %>"
                                    value="<%= cbxUlIdPersonValue %>"
                                    editableMode="<%=EditableMode.ALL%>"
                                    type="checkbox"
                                    name='<%= "cbxUlIdPerson" + loopCount %>'/>              
            </td>
            <td>
              <impact:validateInput tabIndex="<%= tabIndex++ %>"
                                    value="<%= cbxUlIdPersonValue %>"
                                    editableMode="<%=EditableMode.ALL%>"
                                    type="checkbox"
                                    name='<%= "cbxDiscussed" + loopCount %>'/>
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
      </div>
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
      <td><div id="scroll3" style="width:100%; height:220; overflow:auto" class="tableBorderList">
        <table id="results2" border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr class="thList">
            <td width="20%">Date <impact:sortableColumnHeader orderBy="<%= DynamicContactDAO.CONTACT_DATE_SORT %>" isDefault="true"/> </td>
            <td width="20%">Type</td>
            <td width="20%">Purpose</td>
            <td width="20%">Name</td>
            <td width="20%">Stage</td>
            <td>Discussed/In Reference To</td>
          </tr>
            <%
              loopCount = 0;
              if( !csys04soEnumeration.hasMoreElements() )
              {
                // SIR 18462 Disable New Using when there are no Contacts.
                disableNewUsing = true;
            %>
          <tr class="odd">
            <td colspan="6">
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
            <%if (idEvent != idPrevEvent){ 
            if(ArchitectureConstants.Y.equals(csys04soRow.getCIndRsrcSvcShowRow())) {%>
            <td><impact:ifServerImpact><impact:validateInput tabIndex="<%= tabIndex++ %>"
                                                             value="<%= String.valueOf(loopCount) %>"
                                                             type="radio" name="ulRowSelected"
                                                             onClick="<%= hdnStageCodeFn %>"
                                                             editableMode="<%=EditableMode.MODIFY%>"/>
              </impact:ifServerImpact>
              <%= FormattingHelper.formatDate( csys04soRow.getDtDTContactOccurred() ) %>
            </td>
            <%
            	} else {
            %>
            <td> <%= FormattingHelper.formatDate( csys04soRow.getDtDTContactOccurred() ) %></td>
            <%
            	}
            	}
             %>
          
            
            <% 
            if(idEvent != idPrevEvent){
            	if(ArchitectureConstants.Y.equals(csys04soRow.getCIndRsrcSvcShowRow())) {
            %>
            	<td><a href="javascript:launchContactDetail(<%= loopCount %>, '<%= szCdContactType %>')" tabIndex="<%= tabIndex++ %>">
              	<%= Lookup.simpleDecodeSafe( "CCNTCTYP", szCdContactType )%></a></td>
            <%
            	} else {
            %>
            	<td><%= Lookup.simpleDecodeSafe( "CCNTCTYP", szCdContactType ) %></td>
            <%
            	}
            	}
             %>
            
          <%if (idEvent != idPrevEvent){ %>
            <td><%= Lookup.simpleDecodeSafe( "CCNTPURP", csys04soRow.getSzCdContactPurpose() ) %></td>
            <%
             } else {
              %>
            <td></td><td></td><td><%= Lookup.simpleDecodeSafe( "CCNTPURP", csys04soRow.getSzCdContactPurpose() ) %></td>
            <td> </td> <td> </td><td></td>
             <% }
              %>
             <%if (idEvent != idPrevEvent){ %>
            <td><%= FormattingHelper.formatString( csys04soRow.getSzScrNmContact1() ) %></td>
            <td><%= Lookup.simpleDecodeSafe( "CSTAGES", csys04soRow.getSzCdStage() ) %></td>
             <% }
              %>
               <%if (idEvent != idPrevEvent){ %>
            <td><%= FormattingHelper.formatString( csys04soRow.getSzDiscussedPersons()) %></td>
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
      </div>
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
          //capta 4.3
          if(ArchitectureConstants.Y.equals(strAllowAdd)) {
          	showAddButton = EditableMode.ALL;
          	disableAddButton = false;
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

<impact:ifServerImpact>
<%
  // SIR 19320 - Grabbed From and To dates from what has been submitted to the
  //  form and if the To date is empty set it to today.
  String FROM_DATE = dtScrSearchDateFrom;
  String TO_DATE = dtScrSearchDateTo;
  if( TO_DATE.length() == 0 )
  {
    // Sir 19562 -- Changed how the date is populated. Then changed the date
    // into a string.
    TO_DATE = FormattingHelper.formatDate( new Date() );
  }

  // If the From date is empty set it to the begenning of time.
  if( FROM_DATE.length() == 0 )
  {
    FROM_DATE = FormattingHelper.formatDate( DateHelper.MIN_CASTOR_DATE );
  }
  
  String sDate = FormattingHelper.formatTimestamp(new Date());
%>
 
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <%-- th colspan="4">Form and Report Launch</th --%>
    <th colspan="4">Form Launch</th>
  </tr>
  <tr>
    <td>
      <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
          <impact:document displayName="Log of Contact Narratives"
                         protectDocument="true"
                         checkForNewMode="false"
                         docType="CFSD0700"
                         docExists="false">
          <impact:documentParameter name="pStage"
                                    value='<%= FormattingHelper.formatInt( ulIdStage ) %>'/>
          <impact:documentParameter name="pDtSampleFrom" value="<%=FROM_DATE%>"/>
          <impact:documentParameter name="pDtSampleTo" value="<%=TO_DATE%>"/>
       </impact:document>              
       <impact:document displayName="SPW Guide"
                         protectDocument="true"
                         checkForNewMode="false"
                         docType="SPWBNARRGUIDE"
                         docExists="false">
       </impact:document>   
       <impact:document displayName="SPW Interview Questions"
                         protectDocument="true"
                         checkForNewMode="false"
                         docType="SPWBNARRQUES"
                         docExists="false">
          <impact:documentParameter name="pCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>"/>
          <impact:documentParameter name="pStage" value="<%=String.valueOf(ulIdStage)%>"/>
          <impact:documentParameter name="pCdStage" value="<%=String.valueOf(GlobalData.getSzCdStage(request))%>"></impact:documentParameter>
       </impact:document>
      </impact:documentList>
      </td>
      <%-- td>
      <impact:reportList personId="<%= user.getUserID() %>"
                         tabIndex="<%= tabIndex++ %>">
        <impact:report useHiddenParameters="false"
                       reportName="cfsd0300"
                       emailMessage='<%= "Stage Name - " + GlobalData.getSzNmStage( request ) %>'>
          <impact:reportParameter value='<%= FormattingHelper.formatInt( ulIdStage ) %>'/>
          <impact:reportParameter value="<%=FROM_DATE%>"/>
          <impact:reportParameter value="<%= TO_DATE %>"/>
        </impact:report>
      </impact:reportList>
    </td --%>
  </tr>
</table>

<br>
<% /* end Forms and Reports */ %>

<script type="text/javascript" language="JavaScript1.2">
  //populateType();
  //populatePurpose();
  //populateOthers();
  //populateLocation();
  //populateMethod();
<%
    // If the the date field is not null then the user has performed a search so
    // jump to the Results Anchor.
    if (StringHelper.isValid(dtScrSearchDateFrom))
    {
%>
  SearchResultsAnchor.click();
<%
    }
%>
</script>
</impact:ifServerImpact>
