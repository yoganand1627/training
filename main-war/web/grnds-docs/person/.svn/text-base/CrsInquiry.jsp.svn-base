<%--
* JSP Name:    CrsInquiry.jsp
*  Created by:   Kapil Aggarwal
*  Date Created: 02/26/07
*
*  Description:
*  This page allows enter the details to invoke a CRS Web Service that returns
*  back matching results for the entered information for a client.
*  Our interest is to obtain the CRS ID that serves as a reference to all the
*  other external systems with this CRS ID as the reference.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersConversation" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.exolab.castor.types.Date" %>


<%
  //  Declare variables
  int tabIndex = 1;
  String last = StringHelper.EMPTY_STRING;
  String first = StringHelper.EMPTY_STRING;
  String middle = StringHelper.EMPTY_STRING;
  String suffix = StringHelper.EMPTY_STRING;
  String gender = StringHelper.EMPTY_STRING;
  String ssn = StringHelper.EMPTY_STRING;
  Date dob = null;
  String afAmer = StringHelper.EMPTY_STRING;
  String ntvAmer = StringHelper.EMPTY_STRING;
  String white = StringHelper.EMPTY_STRING;
  String pcCislander = StringHelper.EMPTY_STRING;
  String asian = StringHelper.EMPTY_STRING;

  // Get the state to get what mode is the page showing in
  BaseSessionStateManager state =
          (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = (String) state.getAttribute(PersonIdentifiersConversation.PAGE_MODE_KEY, request);
  String hdnWebServiceError = (String) state.getAttribute("hdnWebServiceError", request);
  boolean showWsError = hdnWebServiceError != null;
  String screened = (String) state.getAttribute("hdnScreened", request);

  boolean blnScreened = Boolean.valueOf(screened);

  // Retrieve the Person Info
  CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);

  // If screening has been performed then retrieve the results
  PaginatedHibernateList<CrsScreeningSO.ReturnItem> results =
          (PaginatedHibernateList<CrsScreeningSO.ReturnItem>) state.getAttribute("crsScreeningResults", request);
  boolean recordsFound = (null != results);

  // If Inquiry not performed then get data from Person object else display the info last entered on the form
  if (!blnScreened) {
    if (cinv04so != null) {
      last = FormattingHelper.formatString(cinv04so.getSzNmNameLast());
      first = FormattingHelper.formatString(cinv04so.getSzNmNameFirst());
      middle = cinv04so.getSzNmNameMiddle();
      suffix = cinv04so.getSzCdNameSuffix();
      dob = cinv04so.getDtDtPersonBirth();
      gender = cinv04so.getCCdPersonSex();
      ssn = (String) request.getAttribute("txtSzSysTxtGenericSSN");
    }
  } else {
    last = request.getParameter("txtSzNmNameLast");
    first = request.getParameter("txtSzNmNameFirst");
    middle = request.getParameter("txtSzNmNameMiddle");
    suffix = request.getParameter("cboCcdPersonSuffix");
    //String rqDob = request.getParameter("txtDtDtPersonBirth");
    dob = ContextHelper.getCastorDateSafe(request, "txtDtDtPersonBirth");
    gender = request.getParameter("cboCcdPersonSex");
    ssn = request.getParameter("txtSzSysTxtGenericSSN");
  }

  //  We will enable the Registration Button as a default for now
  blnScreened = true;

%>

<impact:validateForm name="frmCrsInquiry" method="post"
                     action="/person/PersonIdentifiers/performCrsInquiry" schema="/WEB-INF/Constraints.xsd"
                     redisplayParameters="true" pageMode="<%=pageMode%>"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.CrsCustomValidation">


<!--- Begin Detail Table --->
<impact:validateErrors formName="frmCrsInquiry"/>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <th colspan="7">
      Person Information
    </th>
  </tr>
  <tr>
    <td>
      <impact:validateInput name="txtSzNmNameLast" type="text" label="Last" constraint="Name22"
                            conditionallyRequired="true" cssClass="formInput" value="<%=last%>" size="30" maxLength="22"
                            tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:validateInput name="txtSzNmNameFirst" type="text" label="First" constraint="Name12"
                            cssClass="formInput" value="<%=first%>" size="15" maxLength="12"
                            tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:validateInput name="txtSzNmNameMiddle" type="text" label="Middle" constraint="Name12"
                            cssClass="formInput" value="<%=middle%>" size="15" maxLength="12"
                            tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>

  <tr>
    <td>
      <impact:validateSelect name="cboCcdPersonSuffix" label="Suffix" codesTable="CSUFFIX"
                             value="<%=suffix%>" tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:validateSelect name="cboCcdPersonSex" label="Gender" conditionallyRequired="true"
                             codesTable="CSEX" value="<%=gender%>" tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:validateDate name="txtDtDtPersonBirth" label="Date of Birth" constraint="Date"
                           value="<%=FormattingHelper.formatDate(dob)%>" size="8" tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput name="txtSzSysTxtGenericSSN" type="text" label="SSN"
                            constraint="SocialSecurityNumber" conditionallyRequired="true" cssClass="formInput"
                            value="<%=ssn%>" size="11" maxLength="11" tabIndex="<%=tabIndex++%>"/>
    </td>
      <%--  <td>
       <impact:validateSelect name="cboSzCdAddrCounty" label="County"
         tabIndex="<%=tabIndex++%>" codesTable="CCOUNT" value="<%=county%>" />
     </td> --%>
  </tr>
</table>
<%
  RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
  raceEthnicitySubDB.setTabIndex(tabIndex);
  raceEthnicitySubDB.setIsExpanded(true);
  RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);
%>
<%@ include file="/grnds-docs/person/RaceEthnicitySub.jsp" %>
<%
  tabIndex = raceEthnicitySubDB.getTabIndex();
  RaceEthnicitySubDB.removeFromRequest(request);
%>
<impact:ExpandableSectionTag name="NameSSNResults" label="Name/SSN Results"
                             tabIndex="<%=tabIndex++%>" isExpanded="<%=recordsFound%>" id="btnInquire_Id">
<impact:pagination saveState="false" submitUrl="/person/PersonIdentifiers/performCrsInquiry">
<div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>
  <th class="thList">
    &nbsp;
  </th>
  <th class="thList">
    Client ID&nbsp;
  </th>
  <th class="thList">
    Name&nbsp;
  </th>
  <th class="thList">
    DOB&nbsp;
  </th>
  <th class="thList">
    Gender&nbsp;
  </th>
  <th class="thList">
    Race&nbsp;
  </th>
  <th class="thList">
    Ethnicity&nbsp;
  </th>
  <th class="thList">
    SSN&nbsp;
  </th>
</tr>
<%
  if (results != null) {
%>
<%
  int loopCount = 0;
  Iterator<CrsScreeningSO.ReturnItem> iterator = results.iterator();

  if (results.size() == 0) {
%>

<tr class="odd">
  <td colspan="10">
    <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
  </td>
</tr>
<%
} else {
  while (iterator.hasNext()) {
    CrsScreeningSO.ReturnItem rowCrsscreeningSO = iterator.next();
%>
<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
  <%
    String radioId = "rbCrsInquiry_CLEAN" + loopCount;
    boolean checked = false;
  %>
  <%
    String onClick = "javascript:onClickRB( '" + loopCount + "' )";
  %>
  <td>
    <impact:validateInput type="radio" id="<%=radioId%>" tabIndex="<%=tabIndex++%>"
                          name="rbCrsInquiry_CLEAN" value="<%=String.valueOf(loopCount)%>"
                          checked="<%=String.valueOf(checked)%>" editableMode="<%=EditableMode.ALL%>"
                          onClick="<%=onClick%>"/>
  </td>

  <td>
      <%--Start copy--%>
    <%=rowCrsscreeningSO.getLnIrnClientId()%>
  </td>
  <%
    String firstName = StringHelper.getSafeString(rowCrsscreeningSO.getSzFName());
    String middleName = StringHelper.getSafeString(rowCrsscreeningSO.getSzMName());
    String lastName = StringHelper.getSafeString(rowCrsscreeningSO.getSzLName());
    String fullName = FormattingHelper.formatFullName(firstName, middleName, lastName);
  %>
  <td>
    <%=fullName%>
  </td>
	<%
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date DOB = null;
		try {
			DOB = format.parse(rowCrsscreeningSO.getUlDob() + StringHelper.EMPTY_STRING);
		}
		catch(Exception e) {
			//date values from the gta webservice may have zeros in them so just show nothing if it fails to parse
		}
		//Date DOB = new Date((rowCrsscreeningSO.getUlDob()));
	%>
	<td>
		<%=FormattingHelper.formatDate(DOB)%>
	</td>
  <td>
    <%=rowCrsscreeningSO.getSzSexCode()%>
  </td>
  <%
    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnAfAmerican())) {
      afAmer = RaceEthnicityHelper.RACE_BLACK;
    }
    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnNtvAmerican())) {
      ntvAmer = RaceEthnicityHelper.RACE_AMERIND;
    }
    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnWhite())) {
      white = RaceEthnicityHelper.RACE_WHITE;
    }
    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnPcfcislander())) {
      pcCislander = RaceEthnicityHelper.RACE_HAWAIIAN;
    }
    if ("Y".equalsIgnoreCase(rowCrsscreeningSO.getSzBlnAsian())) {
      asian = RaceEthnicityHelper.RACE_ASIAN;
    }
    String races = (afAmer + " " + ntvAmer + " " + white + " " + pcCislander + " " + asian + " ");
  %>
  <td>
    <%=races%>
  </td>
  <td>
    <%=StringHelper.getNonNullString(rowCrsscreeningSO.getSzEthnCode())%>
  </td>
  <%
    String ssnDisplay = StringHelper.EMPTY_STRING;
    if (rowCrsscreeningSO.getUlSsn() != 0) {
      ssnDisplay = FormattingHelper.formatSSN(FormattingHelper.formatLong(rowCrsscreeningSO.getUlSsn()));
    }
  %>
  <td>
    <%=ssnDisplay%>
  </td>
</tr>
  <%-- End Copy--%>

<%
      loopCount++;
    } // end while
  }
} else {
%>
<tr>
  <td>
    &nbsp;
  </td>
</tr>
<%
  }
%>
</table>
</div>
</impact:pagination>
</impact:ExpandableSectionTag>


<table align="right">
  <Tr>
    <td>
      <impact:ButtonTag name="btnInquire" img="btnInquire" restrictRepost="false"
                        tabIndex="<%=tabIndex++%>" align="right" function='return onClickInquiry();'
                        form="frmCrsInquiry" action="/person/PersonIdentifiers/performCrsInquiry"/>
    </td>
    <td>
      <impact:ButtonTag name="btnSelect" img="btnSelect" restrictRepost="false"
                        tabIndex="<%=tabIndex++%>" align="right"
                        function="return onClickSelect();disableValidation('frmCrsInquiry');"
                        disabled="<%=String.valueOf(!recordsFound)%>" form="frmCrsInquiry"
                        action="/person/PersonIdentifiers/selectCrsId"/>
    </td>
    <td>
      <impact:ButtonTag name="btnCrsRegistration" img="btnRegistration" restrictRepost="false"
                        tabIndex="<%=tabIndex++%>" align="right" disabled="<%=String.valueOf(!blnScreened)%>"
                        function="javascript:disableValidation('frmCrsInquiry');"
                        form="frmCrsInquiry" action="/person/PersonIdentifiers/displayCrsRegistration"/>
    </td>
  </Tr>
</Table>
<%-- This hidden field is used within the impact:validateForm tag to generate client-side state information --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<input type="hidden" name="hdnWebServiceError">
<input type="hidden" name="hdnLoopCount">
<input type="hidden" name="hdnInqPressed">
<impact:validateInput type="hidden" name="hdnScreened" value="<%=screened%>"/>
<%-- <impact:validateInput type="hidden" name="hdnCrsID" value="<%=cRSID%>" /> --%>
<impact:validateInput type="hidden" name="hdnIncludingPageDisplayCommand"
                      value='<%=(String) request.getAttribute("includingPageDisplayCommand")%>'/>
</impact:validateForm>


<script type="text/javascript" language="JavaScript1.2">

  window.onload = function ()
  {
    if (<%=showWsError%>) {
      alert('<%=hdnWebServiceError%>');
    }
  };

  function onClickRB(loopCount)
  {
    document.frmCrsInquiry.hdnLoopCount.value = loopCount;
  }

  function onClickInquiry()
  {
    document.frmCrsInquiry.hdnLoopCount.value = -1;
    document.frmCrsInquiry.hdnInqPressed.value = true;
  <%--<% blnScreened = true;
     state.setAttribute("hdnScreened", "true", request); %>--%>
    return true;
  }

  function onClickSelect()
  {
    if (document.frmCrsInquiry.hdnLoopCount.value < 0 || document.frmCrsInquiry.hdnLoopCount.value == "") {
      alert("Please select a row from the \"Name/SSN Results\" before clicking the \"Select\" button");
      return false;
    }
    else {
      return true;
    }
  }

</script>


