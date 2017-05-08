<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
//*  JSP Name:     CaseMnt
//*  Created by:   Merle Demo
//*  Date Created: 12/16/2002
//*
//*  Description:* In combines the old ccmn62w.win and ccmn74w.win.
//*           Allows an authorized user to change the name of the
//*               case and and/or its stages. Whenever the name of the case is
//*               changed, all stages of service within that case will also
//*               be changed (except any SUB,ADO, PAL, and PAD stages). If the
//*               selected stage of service is in the list above and the Change
//*               Name window is called, only that stage will be changed.
//*          The Change County window allows the user to change the
//*               county of a stage.  It also changes the county on the
//*               CAPS_CASE table.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
%>


<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SzNmPersonFull_ARRAY"%>

<% /* Import State Management classes - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<% /* Import PageMode and other utilities used on the page - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%

  String pageMode = PageModeConstants.VIEW;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  if (GlobalData.getAppMode(request) != null)
  {
    pageMode = GlobalData.getAppMode(request);
  }

  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  }
  /* Everything above this point should be in EVERY PAGE. *****************************************************************/
%>
<%
  // Get the CCMN85SO output object out of the request
  CCMN85SO ccmn85so = (CCMN85SO)state.getAttribute("CCMN85SO", request);

  // Initialize the row and array objects
  if ( ccmn85so == null )
  {
    ccmn85so = new CCMN85SO();
  }



  //Declare and initialize display variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

  //Initialize the variables that will specify the display rules for individual fields
  String selCdStageCnty = "";
  String txtDecodeStageCnty = "";
  SzNmPersonFull_ARRAY  stageNamesArray = null;

  //Load array for the New Name of the case
  if(ccmn85so.getSzNmPersonFull_ARRAY() != null )
  {
     stageNamesArray = ccmn85so.getSzNmPersonFull_ARRAY();
  }

  if(state.getAttribute("txtDecodeStageCnty",request) != null)
  {
    txtDecodeStageCnty = (String)state.getAttribute("txtDecodeStageCnty",request);
  }

  Map peopleNames = (Map)state.getAttribute("peopleNames", request);
  ArrayList excludeCCountList = new ArrayList();
  excludeCCountList.add("XXX");

%>

<% /* Needed for Form Launch Custom tag */ %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<% /* Start Javascript Section */ %>
<script type="text/javascript" language="JavaScript1.2">


  window.onbeforeunload = function ()
  {
      IsDirty();
  };


//End Java Script
</script>
<% /* Include custom tag for displaying errors on the page */ %>
<impact:validateErrors/>
<% /* Start the form - See the Form Validation Cookbook or Custom Tag list for details
    on the attributes of the validateForm tag */ %>

<impact:validateForm name="frmCaseMnt"
  method="post"
  defaultButton="true"
  action="/workload/CaseMnt/displayCaseMnt"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseMntCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<% /* Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page. */ %>

<% /* Start the HTML for the page */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">

</table>
<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="5"><%=request.getAttribute( "txtLabelName" )%></th>
  </tr>
  <tr>
     <td width="15%">
         <impact:validateDisplayOnlyField name="txtNmPersonHistFull"
         label="Current Name"
     width="20%"
         value="<%=ccmn85so.getNmPersonHistFull()%>" />
     </td>
     <td width="5%">&nbsp;</td>
     <td width="13%">
         <impact:validateSelect
         options="<%=peopleNames.values()%>"
         name="selNmPersonHistFull"
         blankValue="true"
         label="New Name"
         style="WIDTH: 180px"
         tabIndex="<%= tabIndex++ %>"/>
     </td>
  </tr>

</table>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
      <th colspan="5">Change County</th>
  </tr>
  <tr>
    <td width="15%">
         <impact:validateDisplayOnlyField
           name="txtDecodeStageCnty"
           label="Current County"
           width="20%"
           value="<%=txtDecodeStageCnty%>" />
    </td>
    <td width="5%">&nbsp;</td>
     <td width="13%">
         <impact:validateSelect tabIndex="<%= tabIndex++ %>"
         value="<%=selCdStageCnty%>"
         name="selCdStageCnty"
         codesTable="CCOUNT"
         excludeOptions="<%=excludeCCountList%>"
         style="WIDTH: 180px"
         label="New County"/>
    </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
    <td width="90%">&nbsp;</td>
    <td class="alignRight" width="10%">
      <impact:ButtonTag name="btnSave" img="btnSave" align="right"
        form="frmCaseMnt"
        action="/workload/CaseMnt/saveCaseMnt"
        tabIndex="<%= tabIndex++ %>"/>
    </td>
    </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>







