
<%
       /** JSP Name:     CrsRegistration.jsp
       *  Created by:   Kapil Aggarwal
       *  Date Created: 02/26/07
       *
       *  Description:
       *  This page allows the user to register the client in SHINES with the CRS
       *  system and obtain back a CRS ID that serves as a reference to all the 
       *  other external system.
       **/

      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="org.exolab.castor.types.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CrsScreeningSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB"%>

<%
      //  Declare variables
      int tabIndex = 1;
      String radioId = "";
      String lastNm = StringHelper.EMPTY_STRING;
      String firstNm = StringHelper.EMPTY_STRING;
      String middleNm = StringHelper.EMPTY_STRING;
      String suffix = StringHelper.EMPTY_STRING;
      String gender = StringHelper.EMPTY_STRING;
      String cdDOBVer = StringHelper.EMPTY_STRING;
      String cdSSNVer = StringHelper.EMPTY_STRING;
      String ssn = StringHelper.EMPTY_STRING;
      Date dob = null;
      String county = StringHelper.EMPTY_STRING;
      String afAmer = StringHelper.EMPTY_STRING;
      String ntvAmer = StringHelper.EMPTY_STRING;
      String white = StringHelper.EMPTY_STRING;
      String pcCislander = StringHelper.EMPTY_STRING;
      String asian = StringHelper.EMPTY_STRING;
      int idPerson = 0;
      
      String screened = StringHelper.EMPTY_STRING;
      boolean blnScreened = false;
      List<CrsScreeningSO.ReturnItem> results = null;
      String hdnWebServiceError = StringHelper.EMPTY_STRING;
      boolean showWsError = false;


      // To perform screening valid input fields must be present
      boolean recordsFound = false;

      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      String pageMode = PageModeConstants.VIEW;
      CINV04SO cinv04so = (CINV04SO) state.getAttribute("CINV04SO", request);

      // Has Screening been performed once
      screened = (String)state.getAttribute("hdnScreened", request);
      blnScreened = (screened!=null) && Boolean.valueOf(screened).booleanValue();
	  hdnWebServiceError = (String)state.getAttribute("hdnWebServiceError", request);
	  showWsError = hdnWebServiceError != null;
      results = (List<CrsScreeningSO.ReturnItem>) state.getAttribute("crsScreeningResults", request);
      recordsFound = (null != results);
      county = Lookup.simpleDecodeSafe("CCOUNT", (String) request.getAttribute("cboSzCdAddrCounty"));
      
      // Use notNew to determine if we can assume that cint14wlb will be non-null
      int ulIdPersonId = ContextHelper.getIntSafe(request, "hdnUlIdPersonId");
      CINT14WLB cint14wlb = (CINT14WLB) state.getAttribute("cint14wlb", request);
      boolean notNew = ulIdPersonId > 0 && cint14wlb != null;
      org.exolab.castor.types.Date endDate = notNew ? cint14wlb.getDtPersonIDEnd() : null;
      // Use hasEndDate to disable editing when there is an end date saved
      boolean hasEndDate = endDate != null ? true : false;
      
      
      
      
      if (cinv04so != null) {
        lastNm = FormattingHelper.formatString(cinv04so.getSzNmNameLast());
        firstNm = FormattingHelper.formatString(cinv04so.getSzNmNameFirst());
        middleNm = cinv04so.getSzNmNameMiddle();
        suffix = cinv04so.getSzCdNameSuffix();
        dob = cinv04so.getDtDtPersonBirth();
        gender = cinv04so.getCCdPersonSex();
        cdDOBVer = (String) request.getAttribute("txtDOBVer");
        cdSSNVer = (String) request.getAttribute("txtSSNVer");
        ssn = (String) request.getAttribute("txtSzSysTxtGenericSSN");
        idPerson = cinv04so.getUlIdPerson();
      }

%>

  
<impact:validateForm name="frmCrsRegistration" method="post"
	action="/person/PersonIdentifiers/performCrsRegistration" schema="/WEB-INF/Constraints.xsd"
	redisplayParameters="true" pageMode="<%=pageMode%>" 
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.CrsCustomValidation" >
  

  <!--- Begin Detail Table --->
  <impact:validateErrors formName="frmCrsRegistration" />

  <table border="0" cellspacing="0" cellpadding="3" width="100%" style="">
    <tr>
      <th colspan="7">
        Person Information
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateInput name="txtSzNmNameLast" type="text" conditionallyRequired="true"
          label="Last" constraint="Name20" cssClass="formInput" required="true"
          value="<%=FormattingHelper.formatString(lastNm)%>" size="20"
          maxLength="20" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateInput name="txtSzNmNameFirst" type="text" required="true"
          label="First" constraint="Name12" cssClass="formInput"
          value="<%=FormattingHelper.formatString(firstNm)%>" size="15"
          maxLength="15" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateInput name="txtSzNmNameMiddle" type="text"
          label="Middle" constraint="Name12" cssClass="formInput"
          value="<%=FormattingHelper.formatString(middleNm)%>" size="12"
          maxLength="12" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>

    <tr>
      <td>
        <impact:validateSelect name="cboCcdPersonSuffix" label="Suffix"
          codesTable="CSUFFIX" value="<%=FormattingHelper.formatString(suffix)%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateSelect name="cboCcdPersonSex" label="Gender" conditionallyRequired="true"
          codesTable="CSEX" required="true"
          value="<%=FormattingHelper.formatString(gender)%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateSelect name="cboSzCdAddrCounty" required="true"
        	label="County" tabIndex="<%=tabIndex++%>"
            codesTable="CCOUNT" 
            value="<%=FormattingHelper.formatString(county)%>"/>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput name="txtSzSysTxtGenericSSN" type="text" conditionallyRequired="true"
          label="SSN" constraint="SocialSecurityNumber" 
          cssClass="formInput"
          value="<%=FormattingHelper.formatString(ssn)%>" size="11"
          maxLength="11" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateSelect name="txtSSNVer" label="Verification Code" 
          codesTable="CSEX" value="<%=FormattingHelper.formatString(cdSSNVer)%>"
          tabIndex="<%=tabIndex++%>" />
     </td>
    </tr>
    <tr>
     <td>
        <impact:validateDate name="txtDtDtPersonBirth" label="Date of Birth" 
        	constraint="Date"
            value="<%=FormattingHelper.formatDate(dob)%>" size="8"
            tabIndex="<%=tabIndex++%>" />
     </td>
     <td>
        <impact:validateSelect name="txtDOBVer" label="Verification Code" 
          codesTable="CSEX" value="<%=FormattingHelper.formatString(cdDOBVer)%>"
          tabIndex="<%=tabIndex++%>" />
     </td>
   </tr>
  </table>
  <%
        RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
        raceEthnicitySubDB.setTabIndex(tabIndex);
        raceEthnicitySubDB.setIsExpanded(true);
        RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);
  %>
  <%@ include file="/grnds-docs/person/RaceEthnicitySub.jsp"%>
  <%
        tabIndex = raceEthnicitySubDB.getTabIndex();
        RaceEthnicitySubDB.removeFromRequest(request);
  %>

 <impact:ExpandableSectionTag name="NameSSNResults" 
 					label="Name/SSN Results" 
 					tabIndex="<%=tabIndex++%>" 
 					isExpanded="<%=Boolean.valueOf(recordsFound)%>"	id="btnInquire_Id" >
	<impact:pagination saveState="false" submitUrl="/person/PersonIdentifiers/performCrsScreening">
  <div id="scrollBar" style="height:165;width:100%;overflow:auto" class="tableborderList">
   <table border="0" cellspacing="0" cellpadding="3" width="100%">
       	<tr>
           	 <th class="thList">&nbsp;</th>
             <th class="thList">Client ID&nbsp;</th>
             <th class="thList">Name&nbsp;</th>
             <th class="thList">DOB&nbsp;</th>
             <th class="thList">Gender&nbsp;</th>
             <th class="thList">Race&nbsp;</th>
             <th class="thList">Ethnicity&nbsp;</th>
             <th class="thList">SSN&nbsp;</th>
           </tr> 
  <%
   if (results != null) {
   %>             
   <%
                        int loopCount = 0;
                        CrsScreeningSO.ReturnItem rowCrsscreeningSO = null;
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
                          rowCrsscreeningSO = (CrsScreeningSO.ReturnItem) iterator.next();
              %>
			<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
				<%
				            radioId = "rbCrsRegistration_CLEAN" + loopCount;
				            boolean checked = false;
				%>
				<%
				String onClick = "javascript:onClickRB( '" + loopCount + "' )";
				%>
				<td>
					<impact:validateInput type="radio" id="<%=radioId%>" tabIndex="<%=tabIndex++%>"
						name="rbCrsRegistration_CLEAN" value="<%=String.valueOf(loopCount)%>"
						checked="<%=String.valueOf(checked)%>" editableMode="<%=EditableMode.ALL%>"
						onClick="<%=onClick%>" />
				</td>

				
								<td> <%--Start copy--%>
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
					%>
				<td>
					<%=FormattingHelper.formatDate(DOB)%>
				</td>
				<td>
					<%=rowCrsscreeningSO.getSzSexCode()%>
				</td>
				<%
		  		String races= "";
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
				   races = (afAmer + " " + ntvAmer + " " + white + " " + pcCislander + " " + asian + " ");
				%>
				<td>
					<%=races%>
				</td>
				<td>
					<%=rowCrsscreeningSO.getSzEthnCode()%>
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
			</tr>   <%-- End Copy--%>         

              <%
                                 loopCount++;
                                 } // end while
                               }
                             } else {
                       %>
       <tr><td>&nbsp;</td></tr>
       <%
       }
       %>	 
        </table>
      </div>
      </impact:pagination>
   </impact:ExpandableSectionTag>
   
  
  <Table align="right">
    <Tr>
      <td>
        <impact:ButtonTag name="btnScreenCrs" img="btnScreening"
          restrictRepost="true" tabIndex="<%=tabIndex++%>" align="right"
          form="frmCrsRegistration" function='return onClickScreening();'
          editableMode="<%=EditableMode.ALL%>"
          action="/person/PersonIdentifiers/performCrsScreening" />
      </td>

      <td>
        <impact:ButtonTag name="btnSelectCrsId" img="btnSelect"
          restrictRepost="true" tabIndex="<%=tabIndex++%>" align="right"
		  disabled="<%=String.valueOf(!recordsFound)%>" form="frmCrsRegistration"
          editableMode="<%=EditableMode.ALL%>" function="return onClickSelect(); disableValidation('frmCrsRegistration');"
          action="/person/PersonIdentifiers/selectCrsId" />
      </td>

      <td>
        <impact:ButtonTag name="btnCrsRegister" img="btnAddToCRS"
          restrictRepost="true" tabIndex="<%=tabIndex++%>" align="right" editableMode="<%=EditableMode.ALL%>"
          disabled="<%=String.valueOf(!blnScreened)%>" form="frmCrsRegistration" function="return confirmAddToCRS(false);"
          action="/person/PersonIdentifiers/performCrsRegistration" />
      </td>
    </Tr>
  </Table>

  <%-- This hidden field is used within the impact:validateForm tag to generate client-side state information --%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <input type="hidden" name="hdnWebServiceError" value="">
  <impact:validateInput type="hidden" name="hdnScreened" value="<%=screened%>" />
  <input type="hidden" name="hdnLoopCount" >
  <input type="hidden" name="hdnInqPressed" >
  <impact:validateInput type="hidden" name="hdnIncludingPageDisplayCommand" value='<%=(String) request.getAttribute("includingPageDisplayCommand")%>'/>
  <impact:validateInput type="hidden" name="hdnUlIdPersonId" />
  <impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%=FormattingHelper.formatInt(idPerson)%>"/>
  <impact:validateInput type="hidden" name="hdnIsNew" value="true" />
</impact:validateForm>






<script type="text/javascript" language="JavaScript1.2">

  window.onload = function ()
  {
    if(<%=showWsError%> == true){
   		alert('<%=hdnWebServiceError%>');
  	}
  };

 function onClickRB( loopCount )
  {
  	document.frmCrsRegistration.hdnLoopCount.value = loopCount;
  }
  
  function onClickScreening()
  {
  	document.frmCrsRegistration.hdnLoopCount.value = -1;
  	document.frmCrsRegistration.hdnInqPressed.value = true;
  	return true;
  }
  
  function onClickSelect() {
    if(document.frmCrsRegistration.hdnLoopCount.value < 0 || document.frmCrsRegistration.hdnLoopCount.value==""){
    	alert("Please select a row from the \"Name/SSN Results\" before clicking the \"Select\" button");
    	return false;
    }
    else {
   	   return true;
    }
  }
  
 function confirmAddToCRS(bHasEnddate)
  {
    var returnedValue = true;
    var type = '<%=CodesTables.CNUMTYPE_CRS_IDNUMBER%>';

	<%--returnedValue = confirm('You are about to create a CRS ID in the CRS System. Are you sure?');
	if(returnedValue == false){
		return false;
	}--%>
    var existingTypes = new Array( <%=(String) request.getAttribute("existingTypes")%> );
    for( var i = 0; i < existingTypes.length; i++ )
    {
      if( existingTypes[ i ] == type && !bHasEnddate)
      {
        <%--returnedValue = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_ACTIVE_TYPE_EXISTS)%>')--%>
        returnedValue = confirm('There is already an active identifier of type CRS ID#. Clicking OK will end date the old identifier.')
        if(returnedValue==true){
        	if( type == '<%=CodesTables.CNUMTYPE_CRS_IDNUMBER%>'){
        		returnedValue = confirm('This will create a duplicate or another CRS ID in the CRS System for the same person!  Are you sure ?');
        	}
        }
      }
      if(existingTypes[ i ] == type) {
      	break;
      }
    }
    
    return returnedValue;
  }
  
</script>