<%
/**
 * JSP Name:     UnitSearch.jsp
 * Created by:   Paul Lang
 * Date Created: 11/01/02
 *
 * Description:
 * The Unit Maintenance Search page allows users with unit maintenance
 * responsibility to search for and select a unit in order to view or maintain
 * unit and member information on the Unit Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  ----------------------------------------------
  11/01/02  Paul Lang         Created Document
  08/01/03  Todd Reser        Modifed Change Log and Flowerbox Comments.
  09/02/03  A.Corley          SIR REG81 Make the Unit input field have a maxlength of 2
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.UnitMaintConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<% // Import State Management classes
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%// Import PageMode and other utilities used on the page
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%// Import needed for Messages
%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%// Import needed for Form Launch
%>
<%@ page import="org.grnds.facility.log.GrndsTrace" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%
//Set the page mode
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request ) != null )
  {
    pageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
  }

  // Get the CCMN24SO output object out of the request
  CCMN24SO ccmn24so = (CCMN24SO) request.getAttribute("CCMN24SO");

  // Initialize the row and array objects
  ROWCCMN24SOG01_ARRAY memberInfoRowArray = null;

  // Null catch for cres03so, if null set to blank (initialize)
  if ( ccmn24so == null )
  {
    ccmn24so = new CCMN24SO();
  }

  // Null catch for ROW objects, if not null get rows
  if ( ccmn24so.getROWCCMN24SOG01_ARRAY() != null )
  {
    memberInfoRowArray = ccmn24so.getROWCCMN24SOG01_ARRAY();
  } else
  {
    memberInfoRowArray = new ROWCCMN24SOG01_ARRAY();
  }

  //Declare and initialize control variables for the page
  String szCReqFuncCd = "";

  //Initialize the variables that will specify the display rules for individual fields
  String phoneTypeDisabled = "false";

  /* Assign tab-index */
  int tabIndex = 1;

  //Using variables passed in on the request, set the display for the page
  if( request.getParameter("cReqFuncCd") != null )
  {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

  UserProfile user = UserProfileHelper.getUserProfile( request );
  
  boolean disableAdd = true;
  String enableAdd = (String) request.getAttribute(UnitMaintConversation.ENABLE_ADD);
  if ( ArchitectureConstants.Y.equals(enableAdd)){
    disableAdd = false;
  }
  
%>

<impact:validateErrors/>
<% /* Start the form */ %>

<impact:validateForm name="frmUnitSearch"
                     defaultButton="<%= String.valueOf(disableAdd) %>"
                     method="post"
                     action="/admin/UnitMaint/searchUnit"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
                     pageMode="<%= pageMode %>"
                     schema="/WEB-INF/Constraints.xsd">

<% /*  Always include this hidden field in your form */ %>
 <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
 <input type="hidden" name="UlIdUnit" >

<% // Get the users county and region
  String county = user.getUserCounty() != null ? user.getUserCounty() : "";
  String region = user.getUserRegion() != null ? user.getUserRegion() : "";
  String unit = user.getUserUnit() != null ? user.getUserUnit() : "";
%>

<% // Begin Detail
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Unit Information</th>
  </tr>
  <tr>
    <td><impact:validateSelect blankValue="true"
                               conditionallyRequired="true" 
                               label="County"
                               name="cboSzCdUnitCounty"
                               codesTable="CCOUNT"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= phoneTypeDisabled %>"
                               value="<%= county %>"/>
    </td>
    <td colspan="2"/>
  </tr>
  <tr>
    <td><impact:validateSelect blankValue="true"
                               conditionallyRequired="true" 
                               label="Region/Division"
                               name="cboSzCdUnitRegion"
                               codesTable="CREGDIV"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= phoneTypeDisabled %>"
                               value="<%= region %>"/>
    </td>
    <td><impact:validateInput constraint="AlphaNumeric2Unit"
                              type="text"
                              name="txtSzScrNbrUnitParent"
                              label="Unit"
                              cssClass="formInput"
                              size="2"
                              maxLength="2"
                              tabIndex="<%= tabIndex++ %>"
                              value="<%= unit %>"/>
    </td>
  </tr>
</table>

<% // Include buttons for performing actions on the page
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
     <impact:ButtonTag name="btnAddunit"
                       img="btnAdd"
                       align="right"
                       form="frmUnitSearch"
                       action="/admin/UnitMaint/displayUnitDetail"
                       restrictRepost="true"
                       disabled="<%= String.valueOf(disableAdd) %>"
                       tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td class="alignRight" width="5%">
       <impact:ButtonTag name="btnSearch"
                         align="right"
                         img="btnSearch"
                         form="frmUnitSearch"
                         action="/admin/UnitMaint/searchUnit"
                         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<br>


<% // Dynamically populating table to hold the results returned from the search.
%>
<%
  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
  
%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborderList">
    <tr>
      <th class="thList" >Unit</th>
      <th class="thList" >Unit Approver</th>
      <th class="thList" >Specialization</th>
      <th class="thList" >Parent Unit</th>
    </tr>
    
    <% Enumeration e = memberInfoRowArray.enumerateROWCCMN24SOG01();
       int loopCount = 0;
       String rowCss = null;
       if (!e.hasMoreElements())
     { %>   
         <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                <td colspan="10"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED )%></td>
         </tr>
  <%
  } else{
    //if( e.hasMoreElements() )
    //
     while ( e.hasMoreElements() )
      {
       ROWCCMN24SOG01 memberInfoRow = (ROWCCMN24SOG01) e.nextElement();
       rowCss = FormattingHelper.getRowCss( loopCount + 1 );
       loopCount++;
   %>

   <tr class="<%= rowCss %>">
     <td>
     <% int idUnit = memberInfoRow.getUlIdUnit();
        String nbrUnit = memberInfoRow.getSzNbrUnit();
        if(idUnit >= 0 && nbrUnit != null){
     %>
       <a href="/admin/UnitMaint/displayUnitDetail?ulIdUnit=<%= memberInfoRow.getUlIdUnit() %>" >
         <%= memberInfoRow.getSzNbrUnit()%>
       </a>
     <% } else{ %>
       &nbsp;
     <% } %>
     </td>
     <td>
       <%= memberInfoRow.getSzNmPersonFull() != null ? memberInfoRow.getSzNmPersonFull() : "" %>
     </td>
     <td>
     <% if(memberInfoRow.getSzCdUnitSpecialization() != null){ %>
       <%= ( memberInfoRow.getSzCdUnitSpecialization().length() != 0 ) ? Lookup.simpleDecode( CodesTables.CSPCUNTS, memberInfoRow.getSzCdUnitSpecialization() ) : "" %>
     <% } else{ %>
       <%= "" %>
     <% } %>
     </td>
     <td>
       <%= memberInfoRow.getSzScrNbrUnitParent() != null ? memberInfoRow.getSzScrNbrUnitParent() : "" %>
     </td>
   </tr>
<%
  }
 }
} 
%>
</table>
</impact:validateForm>