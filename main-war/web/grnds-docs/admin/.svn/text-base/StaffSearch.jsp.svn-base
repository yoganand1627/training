<%
/**
 * JSP Name:     StaffSearch.jsp
 * Created by:   Jeff Chambers
 * Date Created: 10/07/02
 *
 * Description:
 * The Staff Search page is used to search for, browse, and maintain PRS
 * employees information.  The page is also "D:/Documents and Settings/gautami.rout/Local Settings/Temporary Internet Files/Content.IE5/RCDW4LU5/SHINES_Header[1].jpg"used to search for PRS employees to
 * populate data fields in other pages.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  06/10/03  dickmaec          SIR 17964 -- staffSearchInput object will remain
                              in state, this will allow the user to have
                              original search criteria on the Staff Search page
                              after returning from the Staff Sec Mnt page
  08/01/03  Todd Reser        Added ChangeLog, and modified FlowerBox comments.
  08/21/03  Eric Dickman      Fixed the tab index for the Search Results.
  11/06/03  Todd Reser        SIR 19794 - Added Sets.H for PPTParticipant so
                              when going to Staff Search from PPTParticipant
                              Radio Buttons are used instead of Checkboxes.
  4/12/2004  gerryc            SIR 16271 - added mail code field to the advanced
                              search.  It is an exact match.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.String"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>


<%

  UserProfile user = UserProfileHelper.getUserProfile( request );

  //Set the page mode
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );


  // This initially checks the Staff Radio Buttons
  String allStaff = "true";
  String actvStaff = "false";

  //SIR 19794 - Added Sets.H
  if (Sets.isInSet(Sets.A | Sets.C | Sets.D | Sets.E | Sets.F | Sets.G | Sets.H, request))
  {
    allStaff = "false";
    actvStaff = "true";
  }

  // Check the request, if a search has been performed pull it out of there
  if ( request.getParameter("rbCScrIndActive") != null )
  {
    if ("actv".equalsIgnoreCase(request.getParameter("rbCScrIndActive")))
    {
      allStaff = "false";
      actvStaff = "true";
    }
    else if ("all".equalsIgnoreCase(request.getParameter("rbCScrIndActive")))
    {
      allStaff = "true";
      actvStaff = "false";
    }
  }

  //  Declare variables
  int tabIndex = 1;
  int loopCount = 0;
  String onlyButton = "true";
  String program = "";
  String region = "";
  String firstNm = "";
  String middleNm = "";
  String lastNm = "";
  String unit = "";
  String personId = "";
  String ssn = "";
  String officeCity = "";
  String county = "";
  String unitSpec = "";
  String mailCode = ""; //16271
  String officeLocation = "";

  //SIR 17964 -- staffSearchInput object will remain in state, this will allow
  //the user to have original search criteria on the Staff Search page after returning
  //from the Staff Sec Mnt page

  // If coming from StaffDetail.jsp do NOT look into the request for field values.
  if (Boolean.TRUE.equals(request.getAttribute("LOAD_INPUT_FROM_STATE")))
  {
    CCMN03SI ccmn03si =(CCMN03SI)state.getAttribute("CCMN03SI", request);

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNmNameFirst()))
    {
      firstNm = ccmn03si.getStfSrchCrtInStruct().getSzNmNameFirst();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNmNameMiddle()))
    {
      middleNm = ccmn03si.getStfSrchCrtInStruct().getSzNmNameMiddle();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNmNameLast()))
    {
      lastNm = ccmn03si.getStfSrchCrtInStruct().getSzNmNameLast();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzCdUnitProgram()))
    {
      program = ccmn03si.getStfSrchCrtInStruct().getSzCdUnitProgram();
    }

    if (ccmn03si.getStfSrchCrtInStruct().getUlIdPerson() != 0)
    {
      personId = "" + ccmn03si.getStfSrchCrtInStruct().getUlIdPerson();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNbrPersonIdNumber()))
    {
      ssn = ccmn03si.getStfSrchCrtInStruct().getSzNbrPersonIdNumber();
    }

    if (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzNbrUnit()))
    {
      unit = ccmn03si.getStfSrchCrtInStruct().getSzNbrUnit();
    }

    if ( (StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzCdUnitRegion())))
    {
      region = ccmn03si.getStfSrchCrtInStruct().getSzCdUnitRegion();
    }
    //SIR 16271 added mail code
    if ((StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCode())))
    {
      mailCode = ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCode();
    }
    if ((StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCodeCity())))
    {
      officeCity = ccmn03si.getStfSrchCrtInStruct().getSzAddrMailCodeCity();
    }
  //if ((StringHelper.isValid(ccmn03si.getStfSrchCrtInStruct())))
   // {
   //   mailCode = ccmn03si.getStfSrchCrtInStruct().getSzNmOfficeName();
   // }

  }
  else if (request.getParameter("hdnFromDetail") == null)
  {
    //if (request.getParameter("cboSzCdUnitProgram") != null)
    //{
    //  program = request.getParameter("cboSzCdUnitProgram");
    //}
    //else if (request.getParameter("cboSzCdUnitProgram") == null)
    //{
    //  program = user.getUserProgram();
    //}

 //   if (request.getParameter("cboSzCdUnitRegion") != null)
 //   {
 //     region = request.getParameter("cboSzCdUnitRegion");
 //   }
 //   else if (request.getParameter("cboSzCdUnitRegion") == null)
 //   {
 //     region = user.getUserRegion();
 //   }

    if (StringHelper.isValid(request.getParameter("txtSzNmNameFirst")))
    {
      firstNm = request.getParameter("txtSzNmNameFirst");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNmNameMiddle")))
    {
      middleNm = request.getParameter("txtSzNmNameMiddle");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNmNameLast")))
    {
      lastNm = request.getParameter("txtSzNmNameLast");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNbrUnit")))
    {
      unit = request.getParameter("txtSzNbrUnit");
    }
    if (StringHelper.isValid(request.getParameter("txtUlIdPerson")))
    {
      personId = request.getParameter("txtUlIdPerson");
    }
    if (StringHelper.isValid(request.getParameter("txtSzSysTxtGenericSSN")))
    {
      ssn = request.getParameter("txtSzSysTxtGenericSSN");
    }
    if (StringHelper.isValid(request.getParameter("txtSzNmOfficeName")))
    {
      officeCity = request.getParameter("txtSzNmOfficeName");
    }
    /*SIR 16271 added mail code*/
    if (StringHelper.isValid(request.getParameter("txtSzAddrMailCode")))
    {
      mailCode = request.getParameter("txtSzAddrMailCode");
    }
  }
  else
  {
    //program = user.getUserProgram();
    //region = user.getUserRegion();
  }

  if (StringHelper.isValid(request.getParameter("txtSzCdOfficeCounty")))
  {
    county = request.getParameter("txtSzCdOfficeCounty");
  }
  if (StringHelper.isValid(request.getParameter("cboSzCdUnitSpecialization")))
  {
    unitSpec = request.getParameter("cboSzCdUnitSpecialization");
  }
  if (StringHelper.isValid(request.getParameter("cboSzCdUnitRegion")))
  {
    region = request.getParameter("cboSzCdUnitRegion");
  }

  


%>

<%
  // Get the CCMN03SO output object out of the request
  CCMN03SO staffsearch = (CCMN03SO) state.getAttribute("StaffSearch", request);
  // Initialize the row and array objects
  ROWCCMN50DO_ARRAY staffArray = null;
  // If StaffSearch result object is null, try to get object from StaffSecurity in state
  if ( Sets.isInSet( Sets.E | Sets.F , request ) )
  {
    staffsearch = (CCMN03SO) state.getAttribute("StaffSecurity", request);
  }

  if ( staffsearch == null )
  {
    staffsearch = new CCMN03SO();
  }

  // Null catch for ROW objects, if not null get rows
  if ( staffsearch.getROWCCMN50DO_ARRAY() != null )
  {
    staffArray = staffsearch.getROWCCMN50DO_ARRAY();
  } else
  {
    staffArray = new ROWCCMN50DO_ARRAY();
  }

  //REG050 -- This will allow the Default Button to exist, when the Search
  // Button is the only push button to display on the page.
  boolean enableAddButton = (Sets.isInSet(Sets.D, request));
  //SIR 19794 - Added Sets.H
  boolean enableContinueCheckRow = (Sets.isInSet( Sets.B | Sets.E | Sets.G | Sets.F | Sets.H, request));
  boolean enableContinueCheckBoxRow = (Sets.isInSet( Sets.C, request));
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
    if( enableAddButton || enableContinueCheckRow || enableContinueCheckBoxRow)
    {
      onlyButton = "false";
    }
    else
    {
      onlyButton = "true";
    }
  }
%>

<script type="text/javascript" language="JavaScript">

  function staffSearch()
  {
    submitValidateForm( "frmStaffSearch", "/admin/StaffSearch/displayStaffSearch" );
  }
  function submitStaffSearch(personId)
  {
    document.frmStaffSearch.hdnUlIdPerson.value = personId;
    document.frmStaffSearch.hdnDisplayType.value = "Modify";
    submitValidateForm( "frmStaffSearch", "/admin/StaffSearch/displayStaffDetail" );
  }
  function getPersonId(personId)
  {
    alert("Person Id: " + personId);
    document.frmStaffSearch.hdnUlIdPerson.value = personId;
  }
  function addStaff()
  {
    document.frmStaffSearchResults.hdnCReqFuncCd.value = "<%= ServiceConstants.REQ_FUNC_CD_ADD %>";
    document.frmStaffSearchResults.hdnDisplayType.value = "Add";
  }

  // make sure at least one race checkbox is checked
  function checkBoxRow()
  {
    var rs = <%= staffArray.getROWCCMN50DOCount() %>;
    var count = countChecked("cbx_", rs);

    if ( count < 1 )
    {
      alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
      return false;
    }
    return true;
  }

  function checkRow()
  {
    var bChecked = false;
    var rs = <%= staffArray.getROWCCMN50DOCount() %>;

      if ( rs <= 1 )
      {
        if ( frmStaffSearchResults.rbRowsIndex.checked == false )
        {
          alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
        }
        else
        {
          bChecked = true;
        }

      } else {

        for ( var i = 0; i < rs; i++ )
        {
          if (frmStaffSearchResults.rbRowsIndex[i].checked)
          {
             bChecked = true;
          }
        }

        if ( bChecked == false )
        {
          alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
        }
      }
      return bChecked;
  }

</Script>



<impact:validateForm name="frmStaffSearch"
   method="post"
   action="/admin/StaffSearch/staffSearch"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchCustomValidation"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   defaultButton="<%= onlyButton %>"
   redisplayParameters="true">
<impact:validateErrors formName="frmStaffSearch"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnUlIdPerson"/>
<impact:validateInput type="hidden" name="hdnDisplayType"/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>

<%
  if (Sets.isInSet(Sets.B, request))
  {
  %>
    Staff Search is complete.  Results are listed below.
  <%
  }
%>

<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
        <th colspan="6">Staff Search</th>
  </tr>
  <tr>
    <td><impact:validateInput type="text" label="First" constraint="Name12" required="false" name="txtSzNmNameFirst" cssClass="formInput" value="<%= firstNm %>" size="15" maxLength="12" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" label="Middle" constraint="Name12" required="false" name="txtSzNmNameMiddle" cssClass="formInput" value="<%= middleNm %>" size="15" maxLength="12" tabIndex="<%= tabIndex++ %>"/></td>
     <td><impact:validateInput type="text" label="Last" constraint="Name22" required="false" name="txtSzNmNameLast" cssClass="formInput" value="<%= lastNm %>" size="30" maxLength="22" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
 <tr>
      <td><impact:validateSelect label="County" required="false" blankValue="true" name="txtSzAddrMailCode" codesTable="CCOUNT" editableMode="<%= EditableMode.EDIT %>" value="<%= mailCode %>" tabIndex="<%= tabIndex++ %>"/></td>
      <td><impact:validateSelect label="Office Location" orderBy="decode" required="false" blankValue="true" name="txtSzCdOfficeCounty" codesTable="COFCNM" editableMode="<%= EditableMode.EDIT %>" value="<%= county %>" tabIndex="<%= tabIndex++ %>"/></td>
      <td><impact:validateInput type="text" label="Office City" constraint="City" required="false" name="txtSzNmOfficeName" editableMode="<%= EditableMode.EDIT %>" cssClass="formInput" value="<%= officeCity %>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" label="Person ID" constraint="Digit16Less" required="false" name="txtUlIdPerson" cssClass="formInput" value="<%= personId %>" size="10" maxLength="16" tabIndex="<%= tabIndex++ %>"/></td>
       <td><impact:validateInput type="text" label="Unit" constraint="AlphaNumeric2" required="false" name="txtSzNbrUnit" cssClass="formInput" value="<%= unit %>" size="4" maxLength="2" tabIndex="<%= tabIndex++ %>"/></td>
       <td><impact:validateInput type="radio" disabled="<%= Sets.isNotInSetStr( Sets.A | Sets.D, request ) %>" label="Active Staff Only" id="Active_Staff" name="rbCScrIndActive" value="actv" cssClass="formInput" checked="<%= actvStaff %>" tabIndex="<%= tabIndex++ %>"/></td>
                <td><impact:validateInput type="radio" disabled="<%= Sets.isNotInSetStr( Sets.A | Sets.D, request ) %>" label="All Staff" id="All_Staff" name="rbCScrIndActive" value="all" cssClass="formInput" checked="<%= allStaff %>" tabIndex="<%= tabIndex++ %>"/>
      </td>
  </tr>
  </table>
  </td>
  </tr>
 <tr>
  <td>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
      <td><impact:validateSelect label="Unit Specialization" blankValue="true" required="false" name="cboSzCdUnitSpecialization" codesTable="CSPCUNTS" editableMode="<%= EditableMode.EDIT %>" value="<%= unitSpec %>" tabIndex="<%= tabIndex++ %>"/></td>
   <td></td><td></td>
  </tr>
  <tr>
       <td><impact:validateSelect label="Reg/Div" blankValue="true" required="false" name="cboSzCdUnitRegion" codesTable="CREGDIV" contentType="<%= SelectTag.CODES_DECODES %>" value="<%= region %>" tabIndex="<%= tabIndex++ %>"/></td>
  <td></td><td></td>
   </tr>
</table>
</td>
</tr>
</table>



<%--Search Button--%>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag name="btnSearch"
                        img="btnSearch"
                        align="right"
                        form="frmStaffSearch"
                        action="/admin/StaffSearch/staffSearch"
                        tabIndex="<%= tabIndex++ %>"
                        backSafe="false"/>
    </td>
  </tr>
</table>
<%-- Result Set for Staff Search --%>
<br/>
</impact:validateForm>


<%
  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
%>

<impact:validateForm name="frmStaffSearchResults"
   method="post"
   action="/admin/StaffSearch/staffSearch"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   defaultButton="false"
   redisplayParameters="true">
<impact:validateErrors formName="frmStaffSearchResults"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnUlIdPerson"/>
<impact:validateInput type="hidden" name="hdnDisplayType"/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="txtSzNmNameFirst" value="<%= firstNm %>"/>
<impact:validateInput type="hidden" name="txtSzNmNameMiddle" value="<%= middleNm %>"/>
<impact:validateInput type="hidden" name="txtSzNmNameLast" value="<%= lastNm %>"/>
<impact:validateInput type="hidden" name="cboSzCdUnitProgram" value="<%= program %>"/>
<impact:validateInput type="hidden" name="cboSzCdUnitRegion" value="<%= region %>"/>
<impact:validateInput type="hidden" name="txtSzNbrUnit" value="<%= unit %>"/>
<impact:validateInput type="hidden" name="txtUlIdPerson" value="<%= personId %>"/>
<impact:validateInput type="hidden" name="txtSzSysTxtGenericSSN" value="<%= ssn %>"/>
<% String hiddenRbValue = "true".equals(actvStaff)?"actv":"all"; %>
<impact:validateInput type="hidden" name="rbCScrIndActive" value="<%= hiddenRbValue%>"/>
<impact:validateInput type="hidden" name="txtSzCdOfficeCounty" value="<%= county %>"/>
<impact:validateInput type="hidden" name="txtSzNmOfficeName" value="<%= officeCity %>"/>
<impact:validateInput type="hidden" name="cboSzCdUnitSpecialization" value="<%= unitSpec %>"/>
<impact:validateInput type="hidden" name="txtSzAddrMailCode" value="<%= mailCode %>"/>
<%--<impact:validateInput type="hidden" name="txtSzNmOfficeName" value="<%= mailCode /%/>"/>--%>

<impact:pagination  saveState="false" submitUrl="/admin/StaffSearch/staffSearch">

<!--- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->
<div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>
   <table width="100%" cellspacing="0" cellpadding="3" class="tableborder" border="0">
      <tr>
         <td class="tableBG">
        <div id="horizontalScrollResults" style="height:300px; width:762px; overflow:auto" class="tableborderList">
           <table width="1000" cellspacing="0" cellpadding="3">
             <tr>
               <th class="thList">&nbsp;</th>
               <th class="thList">Name</th>

               <th class="thList">Title</th>
               <th class="thList">County</th>
               <th class="thList">Work Phone</th>
               <th class="thList">Ext</th>
               <th class="thList">Person ID</th>
               <th class="thList">Office Location</th>
              </tr>
<%
  Enumeration e = staffArray.enumerateROWCCMN50DO();
  //Display the results if the array is not empty
  if (!e.hasMoreElements())
  {
    %>
              <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                <td colspan="10"><%= MessageLookup.getMessageByNumber( Messages.MSG_CMN_SEARCH_NOT_FOUND )%></td>
              </tr>
  <%
  }
  else
  {
    boolean checked = false;
    while (e.hasMoreElements())
    {
      ROWCCMN50DO listDetail = (ROWCCMN50DO)e.nextElement();
      String phoneExtension = listDetail.getLNbrPhoneExtension();
      if(phoneExtension == null){
         phoneExtension = "";
      }
      
      String cbxRowsIndex = "cbx_" + (loopCount+1);
     %>
               <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                  <td width="2%">
                  <% if ( Sets.isInSet(Sets.C, request) ) { %>
                       <impact:validateInput type="checkbox"
                                             checked="<%= String.valueOf(checked) %>"
                                             name="<%= cbxRowsIndex %>"
                                             value="<%= String.valueOf( loopCount )%>"
                                             tabIndex="<%= tabIndex++ %>"
                                             cssClass="formInput" />
                  <%
                    // SIR 19794 - Added Sets.H
                     } else if ( Sets.isInSet(Sets.B | Sets.E | Sets.F | Sets.G | Sets.H, request) ) { %>
                       <impact:validateInput type="radio"
                                             name="rbRowsIndex"
                                             checked="<%= String.valueOf(checked) %>"
                                             value="<%= String.valueOf( loopCount ) %>"
                                             tabIndex="<%= tabIndex++ %>"
                                             cssClass="formInput"/>
                  <% } else { %>
                       &nbsp;
                  <% } %>
                  <% if ( Sets.isInSet(Sets.A | Sets.D, request) ) { %>
                  <td><a href="javascript:submitStaffSearch( '<%= listDetail.getUlIdPerson()%>')" tabIndex="<%= tabIndex++ %>"><%= listDetail.getSzNmPersonFull() %></a></td>
                  <% } else { %>
                  <td><%= listDetail.getSzNmPersonFull() %></td>
                  <% } %>
                  <td><%= Lookup.simpleDecodeSafe("CTITLEA", listDetail.getSzCdEmployeeClass()) %></td>
                  <td><%= Lookup.simpleDecodeSafe("CCOUNT", listDetail.getSzCdUnitCounty()) %></td>
                  <td><%= FormattingHelper.formatPhone(listDetail.getLSysNbrPersPhoneWork()) %></td>
                  <td><%= phoneExtension %></td>
                  <td><%= listDetail.getUlIdPerson() %></td>
                  <td><%= listDetail.getSzNmOfficeName() %></td>
                </tr>
<%     loopCount++; %>
<%   } // End the while
%>
<% } // End the else
%>
             </table>
           </div>
  </td>
      </tr>
   </table>

</impact:pagination>

<%-- Continue Button --%>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
<%
  //Sets D
  if ( enableAddButton )
  {
%>
    <td class="alignRight">
      <impact:ButtonTag name="btnAdd"
                        img="btnAdd"
                        align="right"
                        function="disableValidation('frmStaffSearchResults'); addStaff()"
                        form="frmStaffSearchResults"
                        action="/admin/StaffSearch/displayStaffDetail"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
<%
  }
  //Sets B, E, F contunie button 1
  else if ( enableContinueCheckRow )
  {
%>
    <td class="alignRight">
      <impact:ButtonTag name="btnContinue"
                        img="btnContinue"
                        align="right"
                        function="return checkRow()"
                        form="frmStaffSearchResults"
                        action="/admin/StaffSearch/continueStaffSearch"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
<%
  }
  //Set C, continue button 2
  else if ( enableContinueCheckBoxRow )
  {
%>
    <td class="alignRight">
      <impact:ButtonTag name="btnContinue"
                        img="btnContinue"
                        align="right"
                        function="return checkBoxRow()"
                        form="frmStaffSearchResults"
                        action="/admin/StaffSearch/continueStaffSearch"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
<%
  }
%>
  </tr>
</table>
</impact:validateForm>

<% } // End the display If
%>


<!--- End Detail Table --->
