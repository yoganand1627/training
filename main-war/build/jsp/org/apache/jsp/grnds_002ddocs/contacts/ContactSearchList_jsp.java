package org.apache.jsp.grnds_002ddocs.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS03SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSYS04SO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicContactDAO;
import java.util.Date;
import java.util.Enumeration;
import java.util.Arrays;
import java.util.List;

public final class ContactSearchList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

 /**
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


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


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


      out.write('\r');
      out.write('\n');
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n \r\n window.onload = function()\r\n {\r\n   checked = '");
      out.print( cbxUlIsCase );
      out.write("';\r\n   if (checked == 'true') {\r\n     document.frmContactSearchList.cbxUlIsCase.checked = true;\r\n     ");
 cbxUlIsCase = "on"; 
      out.write("\r\n   }\r\n }\r\n  \r\n  function launchContactDetail( contactIndex, contactType )\r\n  {\r\n    document.frmContactSearchList.hdnUlRowSelected.value = contactIndex;\r\n    document.frmContactSearchList.selSzCdContactType.value = contactType;\r\n    submitValidateForm('frmContactSearchList', '/contacts/ContactSearchListDetail/displayContact');\r\n  }\r\n\r\n  function setHdnContactType( aString )\r\n  {\r\n    frmContactSearchList.hdnContactType.value = aString;\r\n  }\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContactSearchList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/contacts/ContactSearchListDetail/displayContactSearchList");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnCanAddContact");
          _jspx_th_impact_validateInput_2.setValue( strIndCanAddContact );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write('\r');
            out.write('\n');
            //  impact:ExpandableSectionTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
            _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_0);
            _jspx_th_impact_ExpandableSectionTag_0.setName("ContactSearch");
            _jspx_th_impact_ExpandableSectionTag_0.setId("ctSearchOpen");
            _jspx_th_impact_ExpandableSectionTag_0.setLabel("Contact Search");
            _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
            int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
            if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr class=\"subDetail\">\r\n    <th colspan=\"4\">Search Parameters</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td class=\"formlabel\">\r\n      ");
                //  impact:validateDate
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateDate_0.setLabel("Date From");
                _jspx_th_impact_validateDate_0.setConstraint("Date");
                _jspx_th_impact_validateDate_0.setName("dtScrSearchDateFrom");
                _jspx_th_impact_validateDate_0.setDisabled("false");
                _jspx_th_impact_validateDate_0.setValue( dtScrSearchDateFrom );
                _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
                _jspx_th_impact_validateDate_0.setSize("8");
                _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
                _jspx_th_impact_validateDate_0.setEditableMode(EditableMode.ALL);
                int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
                if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>\r\n    <td class=\"formlabel\">\r\n      ");
                //  impact:validateDate
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateDate_1.setLabel("Date To");
                _jspx_th_impact_validateDate_1.setConstraint("Date");
                _jspx_th_impact_validateDate_1.setName("dtScrSearchDateTo");
                _jspx_th_impact_validateDate_1.setDisabled("false");
                _jspx_th_impact_validateDate_1.setValue( dtScrSearchDateTo );
                _jspx_th_impact_validateDate_1.setSize("8");
                _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
                _jspx_th_impact_validateDate_1.setEditableMode(EditableMode.ALL);
                int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
                if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td class=\"formlabel\">\r\n      ");
                //  impact:validateSelect
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateSelect_0.setLabel("Type");
                _jspx_th_impact_validateSelect_0.setName("selSzCdContactType");
                _jspx_th_impact_validateSelect_0.setDisabled("false");
                _jspx_th_impact_validateSelect_0.setOptions( ContactSearchListDetailConversation.getTypeOptions(request) );
                _jspx_th_impact_validateSelect_0.setValue( selSzCdContactType );
                _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
                _jspx_th_impact_validateSelect_0.setEditableMode(EditableMode.ALL);
                _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 175");
                int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
                if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>\r\n    <td class=\"formlabel\">\r\n      ");
                //  impact:validateSelect
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateSelect_1.setLabel("Location");
                _jspx_th_impact_validateSelect_1.setName("selSzCdContactLocation");
                _jspx_th_impact_validateSelect_1.setCodesTable("CCNCTLOC");
                _jspx_th_impact_validateSelect_1.setDisabled("false");
                _jspx_th_impact_validateSelect_1.setValue( selSzCdContactLocation );
                _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
                _jspx_th_impact_validateSelect_1.setStyle("width: 150px");
                _jspx_th_impact_validateSelect_1.setEditableMode(EditableMode.ALL);
                int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
                if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">    \r\n    <td class=\"formlabel\">\r\n      ");
                //  impact:validateSelect
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateSelect_2.setLabel("Method");
                _jspx_th_impact_validateSelect_2.setName("selSzCdContactMethod");
                _jspx_th_impact_validateSelect_2.setDisabled("false");
                _jspx_th_impact_validateSelect_2.setOptions( ContactSearchListDetailConversation.getMethodOptions(request, false) );
                _jspx_th_impact_validateSelect_2.setValue( selSzCdContactMethod );
                _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
                _jspx_th_impact_validateSelect_2.setOnChange("populateLocation()");
                _jspx_th_impact_validateSelect_2.setEditableMode(EditableMode.ALL);
                int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
                if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>\r\n     <td class=\"formlabel\">\r\n      ");
                //  impact:validateSelect
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateSelect_3.setLabel("Others Contacted");
                _jspx_th_impact_validateSelect_3.setName("selSzCdContactOthers");
                _jspx_th_impact_validateSelect_3.setCodesTable("COTHCNCT");
                _jspx_th_impact_validateSelect_3.setDisabled("false");
                _jspx_th_impact_validateSelect_3.setValue( selSzCdContactOthers );
                _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
                _jspx_th_impact_validateSelect_3.setEditableMode(EditableMode.ALL);
                _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 175");
                int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
                if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>  \r\n  </tr>\r\n  <tr class=\"subDetail\">   \r\n    <td colspan=\"4\">\r\n      ");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateInput_3.setLabel("All contacts in the case");
                _jspx_th_impact_validateInput_3.setName("cbxUlIsCase");
                _jspx_th_impact_validateInput_3.setType("checkbox");
                _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.ALL);
                _jspx_th_impact_validateInput_3.setChecked( cbxUlIsCaseChecked );
                _jspx_th_impact_validateInput_3.setValue( cbxUlIsCase );
                _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
                int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
                if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n    </td>\r\n  </tr>\r\n  <!--  \r\n  <tr class=\"subDetail\">\r\n    <th colspan=\"4\">Advanced Search</th>\r\n  </tr>\r\n  -->\r\n  \r\n</table>\r\n\r\n<table>\r\n<tr>\r\n    <th colspan=\"4\">Purpose</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n   <td colspan=\"4\"> \r\n      ");
                //  impact:codesCheckbox
                gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
                _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_codesCheckbox_0.setName("cbxContactPurpose");
                _jspx_th_impact_codesCheckbox_0.setColumns(3);
                _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CCNTPURP );
                _jspx_th_impact_codesCheckbox_0.setDisabled("false");
                _jspx_th_impact_codesCheckbox_0.setEditableMode(EditableMode.ALL);
                _jspx_th_impact_codesCheckbox_0.setTabIndex(tabIndex++ );
                int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
                if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n      </td>\r\n</tr>\r\n</table>\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Search by Principals/Collaterals Contacted or Discussed/In Reference To</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td colspan=\"4\">\r\n      <div id=\"scroll4\" style=\"width:100%; height:125px; overflow:auto\" class=\"tableBorderList\">\r\n        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n          <tr class=\"thList\">\r\n            <td width=\"25%\">Name</td>\r\n            <td>Contacted</td>\r\n            <td>Discussed/In Reference To</td>\r\n            <td>Type</td>\r\n            <td>Role</td>\r\n            <td>Relation/Interest</td>\r\n          </tr>\r\n          ");

            if( !csys03sog01Enumeration.hasMoreElements() )
            {
          
                out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"4\">\r\n              ");
                out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
                out.write("\r\n            </td>\r\n          </tr>\r\n          ");

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
          
                out.write("\r\n          <tr ");
 if( loopCount % 2 == 1 ) { 
                out.write("class=\"altcolor\"");
 } 
                out.write(" >\r\n            <td>\r\n              ");
                out.print( csys03sog01Row.getSzNmPersonFull() );
                out.write("\r\n            </td>\r\n            <td>\r\n              ");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
                _jspx_th_impact_validateInput_4.setValue( cbxUlIdPersonValue );
                _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.ALL);
                _jspx_th_impact_validateInput_4.setType("checkbox");
                _jspx_th_impact_validateInput_4.setName( "cbxUlIdPerson" + loopCount );
                int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
                if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("              \r\n            </td>\r\n            <td>\r\n              ");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
                _jspx_th_impact_validateInput_5.setValue( cbxUlIdPersonValue );
                _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.ALL);
                _jspx_th_impact_validateInput_5.setType("checkbox");
                _jspx_th_impact_validateInput_5.setName( "cbxDiscussed" + loopCount );
                int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
                if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n            </td>\r\n            <td>");
                out.print( Lookup.simpleDecodeSafe( "CPRSNTYP", csys03sog01Row.getSzCdStagePersType() ) );
                out.write("</td>\r\n            <td>");
                out.print( Lookup.simpleDecodeSafe( "CINVROLE", csys03sog01Row.getSzCdStagePersRole() ) );
                out.write("</td>\r\n            <td>");
                out.print( Lookup.simpleDecodeSafe( "CRPTRINT", csys03sog01Row.getSzCdStagePersRelInt() ) );
                out.write("</td>\r\n          </tr>\r\n          ");

                loopCount++;
              } // end while csys03sog01Enumeration.hasMoreElements()
            } // end else !csys03sog01Enumeration.hasMoreElements()
          
                out.write("\r\n        </table>\r\n      </div>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 /* SIR 18155 -- moved search button outside of table */ 
                out.write("\r\n<table width=\"100%\" cellpadding=\"3\" border=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n        <td>\r\n");
                //  impact:ButtonTag
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
                _jspx_th_impact_ButtonTag_0.setName("btnSearch");
                _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
                _jspx_th_impact_ButtonTag_0.setForm("frmContactSearchList");
                _jspx_th_impact_ButtonTag_0.setAction("/contacts/ContactSearchListDetail/displayContactSearchList");
                _jspx_th_impact_ButtonTag_0.setAlign("right");
                _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
                _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
                int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
                if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n</td>\r\n        </tr>\r\n        </table>\r\n");
                int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n<br>\r\n");
          }
          if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<a name=\"SearchResultsAnchor\"/>\r\n");

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

          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/contacts/ContactSearchListDetail/displayContactSearchList");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table id=\"results1\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <td><div id=\"scroll3\" style=\"width:100%; height:220; overflow:auto\" class=\"tableBorderList\">\r\n        <table id=\"results2\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr class=\"thList\">\r\n            <td width=\"20%\">Date ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy( DynamicContactDAO.CONTACT_DATE_SORT );
              _jspx_th_impact_sortableColumnHeader_0.setIsDefault("true");
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" </td>\r\n            <td width=\"20%\">Type</td>\r\n            <td width=\"20%\">Purpose</td>\r\n            <td width=\"20%\">Name</td>\r\n            <td width=\"20%\">Stage</td>\r\n            <td>Discussed/In Reference To</td>\r\n          </tr>\r\n            ");

              loopCount = 0;
              if( !csys04soEnumeration.hasMoreElements() )
              {
                // SIR 18462 Disable New Using when there are no Contacts.
                disableNewUsing = true;
            
              out.write("\r\n          <tr class=\"odd\">\r\n            <td colspan=\"6\">\r\n              ");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("\r\n            </td>\r\n          </tr>\r\n          ");

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
          
              out.write("\r\n          <tr ");
 if( loopCount % 2 == 1 ) { 
              out.write("class=\"altcolor\"");
 } 
              out.write(" >\r\n            ");

              // We have to create a string because the compiler won't work
              // properly. For some reason the less than percent equals HAS to
              // be the first thing after a quote or the compiler won't evaluate
              // it properly.
              String hdnStageCodeFn = "setHdnContactType('" + contactTypeSubstring + "')";
              String szCdContactType = csys04soRow.getSzCdContactType();
            
              out.write("\r\n            ");
if (idEvent != idPrevEvent){ 
            if(ArchitectureConstants.Y.equals(csys04soRow.getCIndRsrcSvcShowRow())) {
              out.write("\r\n            <td>");
              //  impact:ifServerImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
              _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
              if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
                _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
                _jspx_th_impact_validateInput_6.setValue( String.valueOf(loopCount) );
                _jspx_th_impact_validateInput_6.setType("radio");
                _jspx_th_impact_validateInput_6.setName("ulRowSelected");
                _jspx_th_impact_validateInput_6.setOnClick( hdnStageCodeFn );
                _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.MODIFY);
                int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
                if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n              ");
              }
              if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              out.print( FormattingHelper.formatDate( csys04soRow.getDtDTContactOccurred() ) );
              out.write("\r\n            </td>\r\n            ");

            	} else {
            
              out.write("\r\n            <td> ");
              out.print( FormattingHelper.formatDate( csys04soRow.getDtDTContactOccurred() ) );
              out.write("</td>\r\n            ");

            	}
            	}
             
              out.write("\r\n          \r\n            \r\n            ");
 
            if(idEvent != idPrevEvent){
            	if(ArchitectureConstants.Y.equals(csys04soRow.getCIndRsrcSvcShowRow())) {
            
              out.write("\r\n            \t<td><a href=\"javascript:launchContactDetail(");
              out.print( loopCount );
              out.write(',');
              out.write(' ');
              out.write('\'');
              out.print( szCdContactType );
              out.write("')\" tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\">\r\n              \t");
              out.print( Lookup.simpleDecodeSafe( "CCNTCTYP", szCdContactType ));
              out.write("</a></td>\r\n            ");

            	} else {
            
              out.write("\r\n            \t<td>");
              out.print( Lookup.simpleDecodeSafe( "CCNTCTYP", szCdContactType ) );
              out.write("</td>\r\n            ");

            	}
            	}
             
              out.write("\r\n            \r\n          ");
if (idEvent != idPrevEvent){ 
              out.write("\r\n            <td>");
              out.print( Lookup.simpleDecodeSafe( "CCNTPURP", csys04soRow.getSzCdContactPurpose() ) );
              out.write("</td>\r\n            ");

             } else {
              
              out.write("\r\n            <td></td><td></td><td>");
              out.print( Lookup.simpleDecodeSafe( "CCNTPURP", csys04soRow.getSzCdContactPurpose() ) );
              out.write("</td>\r\n            <td> </td> <td> </td><td></td>\r\n             ");
 }
              
              out.write("\r\n             ");
if (idEvent != idPrevEvent){ 
              out.write("\r\n            <td>");
              out.print( FormattingHelper.formatString( csys04soRow.getSzScrNmContact1() ) );
              out.write("</td>\r\n            <td>");
              out.print( Lookup.simpleDecodeSafe( "CSTAGES", csys04soRow.getSzCdStage() ) );
              out.write("</td>\r\n             ");
 }
              
              out.write("\r\n               ");
if (idEvent != idPrevEvent){ 
              out.write("\r\n            <td>");
              out.print( FormattingHelper.formatString( csys04soRow.getSzDiscussedPersons()) );
              out.write("</td>\r\n             ");
 }
              
              out.write("\r\n           </tr>\r\n          ");

                idPrevEvent = idEvent;
                loopCount++;
              } // end while
            } // end if !csys04soEnumeration.hasMoreElements()
          
              out.write("\r\n        </table>\r\n      </div>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
 /* SIR 18155 -- moved pagionation tag outside of table */ 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");

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
      
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setForm("frmContactSearchList");
          _jspx_th_impact_ButtonTag_1.setAction("/contacts/ContactSearchListDetail/displayContact");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.MODIFY );
          _jspx_th_impact_ButtonTag_1.setDisabled(disableNewUsing ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnAdd");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setForm("frmContactSearchList");
          _jspx_th_impact_ButtonTag_2.setAction("/contacts/ContactSearchListDetail/addContact");
          _jspx_th_impact_ButtonTag_2.setDisabled( disableAddButton ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE );
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setEditableMode( showAddButton );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");

        }
      
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      //  impact:ifServerImpact
      gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
      _jspx_th_impact_ifServerImpact_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifServerImpact_2.setParent(null);
      int _jspx_eval_impact_ifServerImpact_2 = _jspx_th_impact_ifServerImpact_2.doStartTag();
      if (_jspx_eval_impact_ifServerImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\r');
        out.write('\n');

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

        out.write("\r\n \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    ");
        out.write("\r\n    <th colspan=\"4\">Form Launch</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
        //  impact:documentList
        gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
        _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
        _jspx_th_impact_documentList_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_2);
        _jspx_th_impact_documentList_0.setPageMode("2");
        _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
        int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
        if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n          ");
            //  impact:document
            gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
            _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
            _jspx_th_impact_document_0.setDisplayName("Log of Contact Narratives");
            _jspx_th_impact_document_0.setProtectDocument(true);
            _jspx_th_impact_document_0.setCheckForNewMode(false);
            _jspx_th_impact_document_0.setDocType("CFSD0700");
            _jspx_th_impact_document_0.setDocExists(false);
            int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
            if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_0.setName("pStage");
                _jspx_th_impact_documentParameter_0.setValue( FormattingHelper.formatInt( ulIdStage ) );
                int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
                if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_1.setName("pDtSampleFrom");
                _jspx_th_impact_documentParameter_1.setValue(FROM_DATE);
                int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
                if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_2.setName("pDtSampleTo");
                _jspx_th_impact_documentParameter_2.setValue(TO_DATE);
                int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
                if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n       ");
                int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("              \r\n       ");
            if (_jspx_meth_impact_document_1(_jspx_th_impact_documentList_0, _jspx_page_context))
              return;
            out.write("   \r\n       ");
            //  impact:document
            gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
            _jspx_th_impact_document_2.setPageContext(_jspx_page_context);
            _jspx_th_impact_document_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
            _jspx_th_impact_document_2.setDisplayName("SPW Interview Questions");
            _jspx_th_impact_document_2.setProtectDocument(true);
            _jspx_th_impact_document_2.setCheckForNewMode(false);
            _jspx_th_impact_document_2.setDocType("SPWBNARRQUES");
            _jspx_th_impact_document_2.setDocExists(false);
            int _jspx_eval_impact_document_2 = _jspx_th_impact_document_2.doStartTag();
            if (_jspx_eval_impact_document_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
                _jspx_th_impact_documentParameter_3.setName("pCase");
                _jspx_th_impact_documentParameter_3.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
                int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
                if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
                _jspx_th_impact_documentParameter_4.setName("pStage");
                _jspx_th_impact_documentParameter_4.setValue(String.valueOf(ulIdStage));
                int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
                if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
                _jspx_th_impact_documentParameter_5.setName("pCdStage");
                _jspx_th_impact_documentParameter_5.setValue(String.valueOf(GlobalData.getSzCdStage(request)));
                int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
                if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n       ");
                int evalDoAfterBody = _jspx_th_impact_document_2.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_impact_document_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n      ");
            int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        out.write("\r\n      </td>\r\n      ");
        out.write("\r\n  </tr>\r\n</table>\r\n\r\n<br>\r\n");
 /* end Forms and Reports */ 
        out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  //populateType();\r\n  //populatePurpose();\r\n  //populateOthers();\r\n  //populateLocation();\r\n  //populateMethod();\r\n");

    // If the the date field is not null then the user has performed a search so
    // jump to the Results Anchor.
    if (StringHelper.isValid(dtScrSearchDateFrom))
    {

        out.write("\r\n  SearchResultsAnchor.click();\r\n");

    }

        out.write("\r\n</script>\r\n");
      }
      if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnContactType");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnUlRowSelected");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_document_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_documentList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:document
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
    _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
    _jspx_th_impact_document_1.setDisplayName("SPW Guide");
    _jspx_th_impact_document_1.setProtectDocument(true);
    _jspx_th_impact_document_1.setCheckForNewMode(false);
    _jspx_th_impact_document_1.setDocType("SPWBNARRGUIDE");
    _jspx_th_impact_document_1.setDocExists(false);
    int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
    if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n       ");
        int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
