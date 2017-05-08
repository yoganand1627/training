<%--
JSP Name:     Detail Template
Created by:   Stephan Brauchli
Date Created: 10/01/02

Description:
This JSP serves as a source of clean code that can be used to build other JSPs.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>

<%
  //Set the page mode (hardcoded -- use PageMode.getPageMode(request) in real JSPs).
  String pageMode = PageModeConstants.EDIT;

  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;

  // Get the CRES03SO output object out of the request
  CRES03SO cres03so = (CRES03SO) request.getAttribute("CRES03SO");
  // Null catch for cres03so, if null set to blank (initialize)
  if (cres03so == null) {
    cres03so = new CRES03SO();
  }
  // Null catch for ROW objects, if not null get rows
  ROWCRES03SOG00_ARRAY rowcres03sog00_array;
  if (cres03so.getROWCRES03SOG00_ARRAY() != null) {
    rowcres03sog00_array = cres03so.getROWCRES03SOG00_ARRAY();
  } else {
    rowcres03sog00_array = new ROWCRES03SOG00_ARRAY();
  }

  //Initialize the variables that will specify the display rules for individual fields
  //EXAMPLE
//  boolean bChecked = false;
//  boolean bRequired = true;
//  boolean bPhoneTypeDisabled = true;
//  boolean bSaveButtonHide = false;
//  boolean bDeleteButtonHide = false;

  //Using variables passed in on the request, set the display for the page
  //EXAMPLE
  String szCReqFuncCd = ServiceConstants.REQ_FUNC_CD_LIST; // Default value, for if the request parameter isn't set.
  if (request.getParameter("cReqFuncCd") != null) {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

  // Get the user profile, if needed.
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // Some variables to display data types for which resources do not contain examples; ususally, these values would
  //   be populated from GlobalData, request attributes, or request parameters.
  String blank = "";
  String nonBlank = "something";
  String dateOfBirth = "07/01/1970";
  String dateOfReBirth = "04/01/1998";

  // Some fake pre-computed values; ususally these would be determined from values in GlobalData, request attributes
  //   or request parameters.
  boolean bDeleteButtonHide = request.getAttribute("doesNotExist") == null;
  boolean bSaveButtonHide = "FakeValue".equals(GlobalData.getSzCdStage(request));
%>
<%-- Needed for Form Launch Custom tag --%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>

<%--
Create javascript functions here for page specific actions on the page. All form submits should use the
  submitValidateForm function to submit which is included in the JavaScript files included in index.jsp.
--%>
<script type="text/javascript" language="JavaScript1.2">

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  };

  // Custom function to handle submitting the form via links in a list
  function submitFormDetailTemplate(counter, updateIndicator, rbValue)
  {
    // Add logic here to do something with parameters passed
    // then call submitValidateForm()
  }

  //Submit the form with the correct cReqFuncCd for deleting.
  function deletePhoneRow()
  {
    bRetValue = confirm('<%= MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") %>')
    if (bRetValue)
    {
      disableValidation("frmDetailTemplate");
    }
    else
    {
      enableValidation("frmDetailTemplate");
    }
    return bRetValue;
  }

  //Assign the corrective action codes table CCORACTN to the static variable correctiveActionCodesTable
  <impact:codeArray codeName="CCORACTN" arrayName="correctiveActionCodesTable" blankValue="false"/>

  function populateCorrectiveAction()
  {
    //Check to see if the Recommended Action is Corrective Action
    if (frmDetailTemplate.selSzCdStageReasonClosed.options.value == '20')
    {
      //Call the populateDropdown method (from impact.js) to attach the codes table.
      populateDropdown(frmDetailTemplate.selSzCdLicngInvstCoractn, "", correctiveActionCodesTable);
    }
    //if anything other than Corrective Action was selected for Recommended Action the codes table should be removed.
    else
    {
      //Call the clearDropdown method (from impact.js) to remove the codes table.
      clearDropdown(frmDetailTemplate.selSzCdLicngInvstCoractn);
    }
  }
</script>
<%-- Include custom tag for displaying errors on the page --%>
<impact:validateErrors/>
<%-- Start the form - See the Form Validation Cookbook or Custom Tag list for details
       on the attributes of the validateForm tag --%>
<impact:validateForm name="frmDetailTemplate" method="post" action="/template/DetailTemplate/save"
                     pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">
<%-- Include any hidden fields needed on the page
       Hidden fields are used for variables passed into the page as request parameters
       AND for hidden fields that need to be used for saving or deleting the detail on this page. --%>
<impact:validateInput type="hidden" name="ulIdResource" value="<%= String.valueOf( cres03so.getUlIdResource() ) %>"/>
<impact:validateInput type="hidden" name="cReqFuncCd" value="<%= szCReqFuncCd %>"/>
<impact:validateInput type="hidden" name="tsLastUpdate"
                      value="<%= SerializationHelper.serializeObject( cres03so.getTsLastUpdate() ) %>"/>
<%-- Start the HTML for the page --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
        <%-- Use descriptive IDs for your Table and Tag identifiers :
             Javascript code would be better inside a function that is called from here,
               but for ease of use I have put the code here --%>
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
    </td>
  </tr>
</table>
<%-- Begin Detail --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="4">Table Title (copy from "Begin Detail" to "End Detail")</th>
</tr>
<tr>
    <%-- Note that there cannot be spaces inside <td></td>, or the cell does not render correctly. --%>
  <td><impact:validateInput required="true" type="text" label="Name" constraint="Name50" name="txtSzNmResource"
                            cssClass="formInput" value="<%= String.valueOf( cres03so.getSzNmResource() ) %>"
                            size="30" maxLength="50" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:validateInput type="text" editableMode="<%= EditableMode.EDIT %>" label="Label 3 (EditableMode.NONE)"
                            constraint="Digit16Less" name="txtLNbrRsrcFacilAcclaim" cssClass="formInput"
                            value="<%= String.valueOf( cres03so.getLNbrRsrcFacilAcclaim() ) %>" size="10"
                            maxLength="10" tabIndex="<%= tabIndex++ %>"/></td>
</tr>
<tr>
  <td><impact:validateSelect label="Label 3 (disabled=true)" colspan="3" name="selSzCdRsrcFacilType"
                             tabIndex="<%= tabIndex++ %>" codesTable="CRSCPHON" disabled="true"
                             value="<%= cres03so.getSzCdRsrcFacilType() %>"/></td>
</tr>
<tr>
  <th colspan="4">Subsection Title</th>
</tr>
<tr>
  <td><impact:validateSelect label="Label 4" name="selSzCdFacilPhoneType" tabIndex="<%= tabIndex++ %>"
                             codesTable="CRSCPHON" value="<%= cres03so.getSzCdRsrcFacilType() %>"/></td>
  <td><impact:validateSelect label="Label 5" name="selSzCdFacilPhoneType" tabIndex="<%= tabIndex++ %>"
                             codesTable="CRSCPHON" value="<%= cres03so.getSzCdRsrcFacilType() %>"/></td>
</tr>
<tr>
  <td valign="top"><!--- Text Area Custom Tag --->
    <impact:validateTextArea name="txtTxtRsrcComments" colspan="3" label="Comments" rows="4" cols="50"
                             tabIndex="<%= tabIndex++ %>"
                             constraint="Comments"><%-- put value here using the = expression --%>
    </impact:validateTextArea>
  </td>
</tr>
<tr>
  <th colspan="4">Checkbox and radiobutton Examples</th>
</tr>
  <%--
  <tr>
    <td colspan="4">
      <impact:validateInput tabIndex="<%= tabIndex++ %>" value="false" editableMode="<%= EditableMode.NONE %>"
                            type="checkbox" checked="false" name="cbxName" label="Label 7 (EditableMode.NONE)"
                            conditionallyRequired="true" cssClass="formInput"/>

      <impact:validateInput checked="false" tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.CREATE %>"
                            value="false" type="radio" name="rbSameName" label="Label 8 (EditableMode.CREATE)"
                            conditionallyRequired="true" cssClass="formInput"/>

      <impact:validateInput tabIndex="<%= tabIndex++ %>" checked="true" value="false"
                            editableMode="<%= EditableMode.EDIT %>" type="radio" name="rbSameName"
                            label="Label 9 (EditableMode.EDIT)" conditionallyRequired="true" cssClass="formInput"/>
    </td>
  </tr>
  --%>
<tr>
  <th colspan="4">Calendar Date Field and Time Field Example</th>
</tr>
<tr>
  <td>
    <impact:validateTime label="Time of Birth" colspan="3" name="txtTimeBirth" value='<%= "12:22 PM" %>'
                         tabIndex="<%= tabIndex++ %>"/>
  </td>
</tr>
<tr>
  <td><impact:validateDate name="txtDateBirth" disabled="false" label="Date of Birth" required="true"
                           value="<%= dateOfBirth %>" size="8" constraint="Date" tabIndex="<%= tabIndex++ %>"/>
  </td><!--- Need the closing and opening TDs here, since the custom tag only creates the inner TDs --->
  <td>
    <impact:validateDate name="txtDateReBirth" label="Date of Re-birth" value="<%= dateOfReBirth %>" size="8"
                         constraint="Date" tabIndex="<%= tabIndex++ %>"/>
  </td>
</tr>
<tr>
  <th colspan="4">Select Box Populating another Select box when "Corrective Action" is chosen</th>
</tr>
<%
  /*  Example of one select box populating another -- Instructions: See tips and FAQs document under Adding a select box which populates another  */
%>
<%
  String corActCodesTable = "";
  String selSzCdStageReasonClosed = "";
  String selSzCdLicngInvstCoractn = "";
  //Check to see onload of the page if there is a Corrective Action and if so, attach the correct codes table
  if (StringHelper.isValid(selSzCdLicngInvstCoractn)) {
    corActCodesTable = "CCORACTN";
  }
%>
<tr>
  <td><impact:validateSelect colspan="3" label="Recommended Action" name="selSzCdStageReasonClosed"
                             tabIndex="<%= tabIndex++ %>" codesTable="CLCRECAT" onChange="populateCorrectiveAction()"
                             value="<%= selSzCdStageReasonClosed %>"/>
  </td>
</tr>
<tr>
  <td><impact:validateSelect colspan="3" label="Corrective Action" name="selSzCdLicngInvstCoractn"
                             tabIndex="<%= tabIndex++ %>" codesTable="<%= corActCodesTable %>"
                             value="<%= selSzCdLicngInvstCoractn %>" style="WIDTH: 200px"/>
  </td>
</tr>
<tr>
  <th colspan="4">Display only fields</th>
</tr>
<tr>
  <td><impact:validateDisplayOnlyField name="displayOnlyInput" colspan="3" label="Display-only Label"
                                       value="<%= dateOfBirth %>"/></td>
</tr>
</table>
<%-- Include buttons for performing actions on the page --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
      <%if (!bDeleteButtonHide) {%>
        <%--
        Button Tag:
        o Always pass a tabIndex and the img attribute as well as a unique name
        o Always pass form="yourFORMNAME" and action="/servlet/conversation/command"
        o If you are submitting an impact:validateForm set validate="true" (almost all cases)
        o If you need to call a custom function see the delete button example
        o If you want your button to align right pass align="right" (left is default)
        o If you want want the "Are you sure you want to navigate away from this page..." pop-up to appear
        o Set navAwayCk to true (accepts boolean or "true").
        --%>
      <impact:ButtonTag name="btnDelete1" img="btnDelete"
                        function="return deletePhoneRow(); alert('next function is called before submit');"
                        form="frmDetailTemplate" action="/template/DetailTemplate/save" tabIndex="<%= tabIndex++ %>"/>
      <%} else {%>
      &nbsp;
      <%}%>
    </td><%-- TDs are needed here otherwise the Save button would not align vertically --%>
    <td>
      <% if (!bSaveButtonHide) {%>
      <impact:ButtonTag name="btnSaveFirst" img="btnSave" align="right" form="frmDetailTemplate"
                        action="/template/DetailTemplate/delete" tabIndex="<%= tabIndex++ %>"/>
      <%} else {%>
      &nbsp;
      <%}%>
    </td>
  </tr>
</table>
<%-- End Detail --%>
<%--  Start ESD --%>
<%-- Begin Expandable Section with Detail --%>
</br>
<impact:ExpandableSectionTag isComplete="true" name="DetailTable" id="Resource_Status1"
                             label="Expandable Section with Detail" tabIndex="<%= tabIndex++ %>">
  <table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
    <tr>
      <th colSpan="4">Table Title 1
      </th>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" label="Active" type="radio" id="Resource_Status1"
                              name="rbResourceStatus" cssClass="formInput" checked="true"/>
      </td>
      <td>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" label="Inactive" type="radio" id="Resource_Status2"
                              name="rbResourceStatus" value="<%= nonBlank %>" cssClass="formInput" checked="false"/>
      </td>
      <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
      <th colSpan="4">Table Title 2</th>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" value="<%= blank %>" name="selResourceFacilityType"
                               blankValue="true" label="Facility Type" onChange="populateLOC()" style="WIDTH: 200px"/>
      </td>
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" value="<%= blank %>" name="selResourceLoc"
                               label="Level of Care" blankValue="true" style="WIDTH: 50px"/>
      </td>
    </tr>
    <tr>
      <th colSpan="4">Table Title 3
      </th>
    </tr>
    <tr class="subDetail">
      <td><%-- because of the custom tag this one spans 2 table cells --%>
        <impact:validateInput tabIndex="<%= tabIndex++ %>" type="text" name="txtResourceAge" label="Age"
                              cssClass="formInput" maxLength="4" size="4" constraint="Numeric"/>
      </td>
      <td colspan="2" class="subDetail">&nbsp;</td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" value="<%= blank  %>" name="selResourceGender"
                               label="Gender" codesTable="CRSRCSEX" blankValue="true"/>
      </td>
      <td colspan="2" class="subDetail">&nbsp;</td>
    </tr>
    <tr class="subDetail">
      <td>
        <impact:validateSelect tabIndex="<%= tabIndex++ %>" value="<%= blank %>" name="selResourceCharacteristics"
                               label="Characteristics" codesTable="CLNCHAR2" blankValue="true"/>
      </td>
      <td colspan="2" class="subDetail">&nbsp;</td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<%--  End xpandDetailTable div --%>
<%-- End ESD --%>
<%-- start ESLT */%>

<br/>
<%--  Begin Expandable Section with List Table --%>
<impact:ExpandableSectionTag anchor="test" name="ListTable" id="rbAddressIndex1_0"
                             label="Expandable Section with List Table" tabIndex="<%= tabIndex++ %>">


  <div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">&nbsp;</th>
        <th class="thList">Type</th>
        <th class="thList">Vendor ID</th>
        <th class="thList">Attention</th>
        <th class="thList">Address</th>
        <th class="thList">County</th>
        <th class="thList" width="80">Comments</th>
      </tr>
      <%
        // We need a loop counter to alternate highlighting properly.
        int loopCount = 0;
        Enumeration addressEnumeration1 = rowcres03sog00_array.enumerateROWCRES03SOG00();
        if (!addressEnumeration1.hasMoreElements()) {
      %>
      <tr class="odd">
        <td colspan="7">
          <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
        </td>
      </tr>
      <%
      } else {
        while (addressEnumeration1.hasMoreElements()) {
          ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration1.nextElement();
      %>
      <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
        <% String radioId = "rbAddressIndex1_" + loopCount; %>
        <td><impact:validateInput type="radio" id="<%= radioId %>" tabIndex="<%= tabIndex++ %>" name="rbAddressIndex1"
                                  value="<%= String.valueOf( loopCount ) %>"/></td>
        <td>
            <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
          <a href="javascript: submitFormDetailTemplate( '<%= loopCount %>','U', '<%= rowcres03sog00.getCScrIndRsrcContracted()%>')"
             tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;"
                  ><%=Lookup.simpleDecodeSafe("CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) %></a>
        </td>
        <td><%= rowcres03sog00.getSzNbrRsrcAddrVid() %></td>
        <td><%= rowcres03sog00.getSzAddrRsrcAddrAttn() %></td>
        <td><%= rowcres03sog00.getSzAddrRsrcAddrStLn1() %>
          <%= rowcres03sog00.getSzAddrRsrcAddrStLn2() %>
          <%= rowcres03sog00.getSzAddrRsrcAddrCity() %>,
          <%= rowcres03sog00.getSzCdFacilityState() %>
          <%= rowcres03sog00.getSzAddrRsrcAddrZip() %></td>
        <td><%= Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) %></td>
        <td align="center">
          <%
            if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
          %>
          <IMG src="/grnds-docs/images/shared/checkMark.gif">
          <%
            }
          %>
        </td>
      </tr>
      <%
            loopCount++;
          }
        }
      %>
    </table>
  </div><%-- this is where the "scrollBar" div tag ends --%>
  <table cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td colspan="4" class="tableBG">
          <%--
          Button Tag:
          o Always pass a tabIndex and the img attribute as well as a unique name
          o Always pass form="yourFORMNAME" and action="/servlet/conversation/command"
          o If you are submitting an impact:validateForm set validate="true" (almost all cases)
          o If you need to call a custom function see the delete button example
          o If you want your button to align right pass align="right" (left is default)
          o If you want want the "Are you sure you want to navigate away from this page..." pop-up to appear
          o Set navAwayCk to true (accepts boolean or "true").
          --%>
        <impact:ButtonTag name="btnAdd1" img="btnAdd" form="frmDetailTemplate" action="/template/DetailTemplate/add"
                          align="right" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<%-- this is where the "xpandListTable" div tag ends end ESLT --%>
<%-- start ESSLT --%>

<br/><% // Begin Expandable Section with Scrolling List Table  %>
<impact:ExpandableSectionTag name="Scroll" id="rbAddressIndex2_0" label="Expandable Section with Scrolling List Table"
                             tabIndex="<%= tabIndex++ %>">
  <div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>

  <div id="scrollBar2" style="height:165px;width:752px;overflow:auto" class="tableborderList">
    <table width="900" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">&nbsp;</th>
        <th class="thList">Type</th>
        <th class="thList">Vendor ID</th>
        <th class="thList">Attention</th>
        <th class="thList">Address</th>
        <th class="thList">County</th>
        <th class="thList" width="80">Comments</th>
      </tr>
      <%
        // We need a loop counter to alternate highlighting properly.
        int loopCount = 0;
        Enumeration addressEnumeration2 = rowcres03sog00_array.enumerateROWCRES03SOG00();
        if (!addressEnumeration2.hasMoreElements()) {
      %>
      <tr class="odd">
        <td colspan="7">
          <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
        </td>
      </tr>
      <%
      } else {
        while (addressEnumeration2.hasMoreElements()) {
          ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration2.nextElement();
      %>
      <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
        <% String radioId2 = "rbAddressIndex2_" + loopCount; %>
        <td><impact:validateInput type="radio" id="<%= radioId2 %>" tabIndex="<%= tabIndex++ %>" name="rbAddressIndex2"
                                  value="<%= String.valueOf( loopCount ) %>"/></td>
        <td>
            <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
          <a href="javascript:submitFormDetailTemplate( '<%= loopCount %>','U', '<%= rowcres03sog00.getCScrIndRsrcContracted()%>')"
             tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;"
                  ><%=Lookup.simpleDecodeSafe("CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) %></a>
        </td>
        <td><%= rowcres03sog00.getSzNbrRsrcAddrVid() %></td>
        <td><%= rowcres03sog00.getSzAddrRsrcAddrAttn() %></td>
        <td><%= rowcres03sog00.getSzAddrRsrcAddrStLn1() %>
          <%= rowcres03sog00.getSzAddrRsrcAddrStLn2() %>
          <%= rowcres03sog00.getSzAddrRsrcAddrCity() %>,
          <%= rowcres03sog00.getSzCdFacilityState() %>
          <%= rowcres03sog00.getSzAddrRsrcAddrZip() %></td>
        <td><%= Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) %></td>
        <td align="center">
          <%
            if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
          %>
          <IMG src="/grnds-docs/images/shared/checkMark.gif">
          <%
            }
          %>
        </td>
      </tr>
      <%
            loopCount++;
          }
        }
      %>
    </table>
  </div><%-- this is where the "scrollBar" div tag ends --%>
  <table cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td colspan="4" class="tableBG">
          <%--
          Button Tag:
          o Always pass a tabIndex and the img attribute as well as a unique name
          o Always pass form="yourFORMNAME" and action="/servlet/conversation/command"
          o If you are submitting an impact:validateForm set validate="true" (almost all cases)
          o If you need to call a custom function see the delete button example
          o If you want your button to align right pass align="right" (left is default)
          o If you want want the "Are you sure you want to navigate away from this page..." pop-up to appear
          o Set navAwayCk to true (accepts boolean or "true").
          --%>
        <impact:ButtonTag name="btnAdd2" img="btnAdd" form="frmDetailTemplate" action="/template/DetailTemplate/add"
                          align="right" tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
</impact:ExpandableSectionTag>
<%-- end ESSLT --%>
<br/>
<HR>
<br/>

<div class="pageTitle">List Page Examples (Pagination occurs when enough results are returned):</div>
<%-- start HSLD  --%>
<br/>
<%-- Begin Horizontally Scrolling List Division (Copy from //start HSLD to //end HSLD) --%>
<%-- start pagination custom tag  -- closed after table --%>
<impact:pagination submitUrl="/template/DetailTemplate/detail?ulIdResource=18007205" saveState="false">
  <%-- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --%>
  <div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>
  <table width="100%" cellspacing="0" cellpadding="3" class="tableborder">
    <tr>
      <td class="tableBG">
        <div id="horizontalScrollResults" style="height:335px; width:752px; overflow:auto" class="tableborderList">
          <table width="900" cellspacing="0" cellpadding="3">
            <tr>
              <th class="thList">&nbsp;</th>
              <th class="thList">Type</th>
              <th class="thList">Vendor ID</th>
              <th class="thList">Attention</th>
              <th class="thList">Address</th>
              <th class="thList">County</th>
              <th class="thList" width="80">Comments</th>
            </tr>
            <%
              // We need a loop counter to alternate highlighting properly.
              int loopCount = 0;
              Enumeration addressEnumeration3 = rowcres03sog00_array.enumerateROWCRES03SOG00();
              if (!addressEnumeration3.hasMoreElements()) {
            %>
            <tr class="odd">
              <td colspan="7">
                <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
              </td>
            </tr>
            <%
            } else {
              while (addressEnumeration3.hasMoreElements()) {
                ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration3.nextElement();
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
              <% String radioId3 = "rbAddressIndex3_" + loopCount; %>
              <td><impact:validateInput type="radio" id="<%= radioId3 %>" tabIndex="<%= tabIndex++ %>"
                                        name="rbAddressIndex3" value="<%= String.valueOf( loopCount ) %>"/></td>
              <td>
                  <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
                <a href="javascript:submitFormDetailTemplate( '<%= loopCount %>','U', '<%= rowcres03sog00.getCScrIndRsrcContracted()%>')"
                   tabIndex="<%= tabIndex++ %>" onclick="window.onBeforeUnload=null;"
                        ><%=Lookup.simpleDecodeSafe("CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) %></a></td>
              <td><%= rowcres03sog00.getSzNbrRsrcAddrVid() %></td>
              <td><%= rowcres03sog00.getSzAddrRsrcAddrAttn() %></td>
              <td><%= rowcres03sog00.getSzAddrRsrcAddrStLn1() %><br>
                <%= rowcres03sog00.getSzAddrRsrcAddrStLn2() %><br>
                <%= rowcres03sog00.getSzAddrRsrcAddrCity() %>,
                <%= rowcres03sog00.getSzCdFacilityState() %>
                <%= rowcres03sog00.getSzAddrRsrcAddrZip() %></td>
              <td><%= Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) %></td>
              <td align="center">
                <%
                  if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
                %>
                <IMG src="/grnds-docs/images/shared/checkMark.gif">
                <%
                  }
                %>
              </td>
            </tr>
            <%
                  loopCount++;
                }
              }
            %>
          </table>
        </div>
      </td>
    </tr>
  </table>
  <%-- CLOSE thE ROW thAT HOLDS thE SCROLL BOX --%>
  <%-- close pagination custom tag --%>
</impact:pagination>
<% // END HSLD --%>

<HR width="50%">

<%-- Start RLD --%>
<br/><%-- Begin Result List Division (copy from  // Start RLD to // end RLD) --%>
<%-- start pagination custom tag  -- closed after table --%>
<impact:pagination submitUrl="/template/DetailTemplate/detail?ulIdResource=18007205" saveState="false">
  <table width="100%" cellspacing="0" cellpadding="3" class="tableborder">
    <tr>
      <td class="tableBG">
        <div id="noScrollResults" style="height:100%; width:100%; overflow:auto" class="tableborderList">
          <table width="100%" cellspacing="0" cellpadding="3">
            <tr>
              <th class="thList">&nbsp;</th>
              <th class="thList">Type</th>
              <th class="thList">Vendor ID</th>
              <th class="thList">Attention</th>
              <th class="thList">Address</th>
              <th class="thList">County</th>
              <th class="thList" width="80">Comments</th>
            </tr>
            <%
              int loopCount = 0;
              Enumeration addressEnumeration5 = rowcres03sog00_array.enumerateROWCRES03SOG00();
              if (!addressEnumeration5.hasMoreElements()) {
            %>
            <tr class="odd">
              <td colspan="7">
                <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
              </td>
            </tr>
            <%
            } else {
              while (addressEnumeration5.hasMoreElements()) {
                ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration5.nextElement();
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
              <% int tabIndexLoop4 = tabIndex++;
                String radioId4 = "rbAddressIndex4_" + loopCount; %>
              <td><impact:validateInput type="radio" name="rbAddressIndex4" id="<%= radioId4 %>"
                                        tabIndex="<%= tabIndexLoop4 %>"
                                        value="<%= String.valueOf( loopCount ) %>"/></td>
              <td>
                  <%-- Note that thee formatting is awkward here because there cannot be spaces inside the anchor tag. --%>
                <a href="javascript:submitFormDetailTemplate( '<%= loopCount %>','U', '<%= rowcres03sog00.getCScrIndRsrcContracted()%>')"
                   tabIndex="<%= tabIndexLoop4 %>" onclick="window.onBeforeUnload=null;"><%=Lookup.simpleDecodeSafe(
                        "CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) %></a></td>
              <td><%= rowcres03sog00.getSzNbrRsrcAddrVid() %></td>
              <td><%= rowcres03sog00.getSzAddrRsrcAddrAttn() %></td>
              <td><%= rowcres03sog00.getSzAddrRsrcAddrStLn1() %>
                <%= rowcres03sog00.getSzAddrRsrcAddrStLn2() %>
                <%= rowcres03sog00.getSzAddrRsrcAddrCity() %>,
                <%= rowcres03sog00.getSzCdFacilityState() %>
                <%= rowcres03sog00.getSzAddrRsrcAddrZip() %></td>
              <td><%= Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) %></td>
              <td align="center">
                <%
                  if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
                %>
                <IMG src="/grnds-docs/images/shared/checkMark.gif">
                <%
                  }
                %>
              </td>
            </tr>
            <%
                  loopCount++;
                }
              }
            %>
          </table>
        </div><%-- end div noScrollResults --%>
      </td>
    </tr>
  </table>
  <%-- CLOSE thE ROW thAT HOLDS thE SCROLL BOX --%>
  <%-- close pagination custom tag --%>
</impact:pagination>
<%-- end RLD --%>
<br/>
<%/* BEGIN Race Ethnicity Submodule */%>
<%
  RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
  raceEthnicitySubDB.setTabIndex(tabIndex);
  RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);
%>
<%@ include file="/grnds-docs/person/RaceEthnicitySub.jsp" %>
<%
  tabIndex = raceEthnicitySubDB.getTabIndex();
  RaceEthnicitySubDB.removeFromRequest(request);
%>
<%/* END Race Ethnicity Submodule */%>
<br>
<%/* BEGIN Admin Address Phone Submodule */%>
<%
  AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
  adminAddressPhoneSubDB.setFormName("frmDetailTemplate");
  adminAddressPhoneSubDB.setPageMode(pageMode);
  adminAddressPhoneSubDB.setAddressPhoneSectionHeader("Admin Address Phone Submodule");
  adminAddressPhoneSubDB.setAddressRequired(false);
  adminAddressPhoneSubDB.setAddressDisabled(false);
  adminAddressPhoneSubDB.setCommentsVisible(true);
  adminAddressPhoneSubDB.setCommentsRequired(false);
  adminAddressPhoneSubDB.setCommentsDisabled(false);
  adminAddressPhoneSubDB.setPhoneRequired(false);
  adminAddressPhoneSubDB.setPhoneDisabled(false);
  adminAddressPhoneSubDB.setAddressSubmoduleName("first");
  adminAddressPhoneSubDB.setTabIndex(tabIndex);
  AdminAddressPhoneSubDB.setIntoRequest(adminAddressPhoneSubDB, request);
%>
<%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp" %>
<%
  tabIndex = adminAddressPhoneSubDB.getTabIndex();
  AdminAddressPhoneSubDB.removeFromRequest(request);
%>
<%/* END Admin Address Phone Submodule */%>

<%/* BEGIN Address Submodule */%>
<%
  AddressSubDB addressSubDB = new AddressSubDB();
  addressSubDB.setFormName("frmDetailTemplate");
  addressSubDB.setPageMode(pageMode);
  addressSubDB.setAddressSubmoduleName("second");
  addressSubDB.setCommentsVisible(true);
  addressSubDB.setCommentsRequired(false);
  addressSubDB.setCommentsDisabled(false);
  addressSubDB.setAddressRequired(false);
  addressSubDB.setAddressDisabled(false);
  addressSubDB.setTabIndex(tabIndex);
  AddressSubDB.setIntoRequest(addressSubDB, request);
%>
<%@ include file="/grnds-docs/common/AddressSub.jsp" %>
<%
  tabIndex = addressSubDB.getTabIndex();
  AddressSubDB.removeFromRequest(request);
%>
<%/* END Address Submodule */%>

<hr>
<table cellspacing="0" cellPadding="3" width="100%" border="0">
  <tr>
    <td class="alignRight">
        <%--
        Button Tag:
        o Always pass a tabIndex and the img attribute as well as a unique name
        o Always pass form="yourFORMNAME" and action="/servlet/conversation/command"
        o If you are submitting an impact:validateForm set validate="true" (almost all cases)
        o If you need to call a custom function see the delete button example
        o If you want your button to align right pass align="right" (left is default)
        o If you want want the "Are you sure you want to navigate away from this page..." pop-up to appear
        o Set navAwayCk to true (accepts boolean or "true").
        --%>
      <%
        String validate2AddressesOnSave = "return validate2AddressesOnSave( " +
                                          "'frmDetailTemplate', " +
                                          "'/template/DetailTemplate/save', " +
                                          "'first', " +
                                          "'second' );";
      %>
      <impact:ButtonTag name="btnSaveFinal" editableMode="<%= EditableMode.EDIT %>"
                        function="<%= validate2AddressesOnSave %>"
                        img="btnSave" align="right" form="frmDetailTemplate" action="/template/DetailTemplate/save"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<%--  Always include this hidden field in your form --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<%-- Close Validate Form Custom Tag --%>
</impact:validateForm>
<br/>
<hr/>
<%-- begin Forms and Reports

  ATTENTION!!!  FORMS AND REPORTS section CANNOT be within impact:validateForm tags; nested forms are not allowed
--%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Forms and Reports (Copy from "begin Forms and Reports" to "end Forms and Reports")</th>
  </tr>
  <tr>
    <td>
      <%-- Using the Forms and Reports custom tags requires you to import certain classes and javascript files.
           Be sure to contact Stephen Roberts for the latest info --%>
      <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
        <impact:document displayName="Call Narrative" protectDocument="false" checkStage="12132" docType="CALLNARR"
                         docExists="true">
          <impact:documentParameter name="pStage" value="12121"/>
        </impact:document>
        <impact:document displayName="Intake Report" protectDocument="true" checkStage="12132" docType="CSC34o00"
                         docExists="false">
          <impact:documentParameter name="pStage" value="23232"/>
        </impact:document>
      </impact:documentList>

    </td>
    <td>
      <impact:reportList personId="<%= user.getUserID() %>" tabIndex="<%= tabIndex++ %>">
        <impact:report useHiddenParameters="true" reportName="ccf02o00"/>
        <impact:report useHiddenParameters="true" reportName="ccf03o00"/>
        <impact:report useHiddenParameters="false" reportName="cfn51o01">
          <impact:reportParameter value="5600240"/>
        </impact:report>
        <impact:report useHiddenParameters="false" reportName="cfn05o01">
          <impact:reportParameter value="03"/>
          <impact:reportParameter value="/opt/impact/config/devl/applications/impact/xmlTest/reports"/>
        </impact:report>
      </impact:reportList>
    </td>
  </tr>
</table>
<%-- end Forms and Reports --%>
