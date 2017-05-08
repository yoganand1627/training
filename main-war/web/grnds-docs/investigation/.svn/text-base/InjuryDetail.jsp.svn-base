<%
//*  JSP Name:     Injury Detail
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 11/19/02
//*
//*  Description:
//*   The Injury Detail page will allow the user to add, edit, and browse information
//*   about a specific injury.  The Inury List has been moved to the Facility
//*   Allegation Detail page.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/08/2003 CASDORJM         Removed all references of CINV08SO from this page.  The
//**                              Injury List hyperlink used to save the Fac Allegation Dtl
//**                              before loading the Injury Detail page but due to technical
//**                              errors (problems with the back button) it was decided that the
//**                              hyperlink would no longer autosave.  Since we are no longer
//**                              saving, we can use the tsLastUpdate that was orinigally retrieved
//**                              when the Fac Allegation Dtl page was loaded.  We no longer
//**                              need to use CINV08SO to get the tsLastUpdate.
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV08SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG01_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SOG02_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnConversation" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
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
  //Everything above this point should be in every page.
  int tabIndex = 1;
%>
<%
  CINV07SOG01 injuryDetail = (CINV07SOG01) state.getAttribute( "injuryDetail" , request);
  CINV07SOG02 personDetail = (CINV07SOG02) state.getAttribute( "personDetail" , request);

  if( injuryDetail == null )
  {
    injuryDetail = new CINV07SOG01();
  }
  if( personDetail == null )
  {
    personDetail = new CINV07SOG02();
  }

  String hdnOverallDisp = FormattingHelper.formatString( (String) request.getAttribute( "hdnOverallDisp") );
  String hdnInjuryID = FormattingHelper.formatString( (String) request.getAttribute( "hdnInjuryID" ) );
  String ulIdAllegation = FormattingHelper.formatString( (String) request.getAttribute( "hdnUlIdAllegation" ) );
  String hdnMode = FormattingHelper.formatString( (String) request.getAttribute( "hdnMode" ) );
  if ("".equals(hdnMode) )
  {
    hdnOverallDisp = FormattingHelper.formatString( request.getParameter( "hdnOverallDisp") );
    hdnInjuryID = FormattingHelper.formatString( request.getParameter( "hdnInjuryID" ) );
    ulIdAllegation = FormattingHelper.formatString( request.getParameter( "hdnUlIdAllegation" ) );
    hdnMode = FormattingHelper.formatString( request.getParameter( "hdnMode" ) );
  }

  String victimName = "";
  victimName = personDetail.getSzNmPersonFull();

  boolean bDelete = false;
  boolean bAdd = false;
  boolean bContinue = false;

  String audMode = "";
  if (hdnMode.equals( AllgtnConversation.ADD )) {
    audMode = AllgtnConversation.ADD_SER;
    bDelete = true;
  } else if (hdnMode.equals( AllgtnConversation.UPDATE )) {
    audMode = AllgtnConversation.UPDATE_SER;
  }


  if ( !( GlobalData.getAppMode( request ).equals( PageModeConstants.NEW ) ) &&
       !( GlobalData.getAppMode( request ).equals( PageModeConstants.MODIFY ) ) )
  {
    pageMode = PageModeConstants.VIEW;
    bDelete = true;
    bAdd = true;
    bContinue = true;
  }


  String txtDtFacilInjuryDtrmntn = "";
  if (null != injuryDetail.getDtFacilInjuryDtrmntn())
  {
    txtDtFacilInjuryDtrmntn = FormattingHelper.formatDate( injuryDetail.getDtFacilInjuryDtrmntn() );
  }



%>
<impact:validateErrors/>

<impact:validateForm name="frmInjuryDetail"
  method="post"
  action="/investigation/Allegation/saveInjury"
  pageMode="<%=pageMode%>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnCustomValidation"
  schema="/WEB-INF/Constraints.xsd">


<impact:validateInput type="hidden" name="pageType" value="InjuryDetail"/>
<impact:validateInput type="hidden" name="hdnOverallDisp" value="<%= hdnOverallDisp %>"/>
<impact:validateInput type="hidden" name="hdnMode" value="<%= hdnMode%>"/>

<!-- Detail Variables -->



<!-- Field Variables -->

<!-- Injury Variables -->

<impact:validateInput type="hidden" name="hdnUlIdFacilityInjury" value="<%=String.valueOf( injuryDetail.getUlIdFacilityInjury())%>"/>
<impact:validateInput type="hidden" name="hdnInjuryID" value="<%= hdnInjuryID %>"/>
<impact:validateInput type="hidden" name="hdnCReqFuncCdInj" value="<%= audMode %>"/>


<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Injury Detail</th>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField name="dspVicName" label="Victim" value="<%= victimName %>" /></td>
    <td><impact:validateDate type="text" name="txtDtFacilInjuryDtrmntn" label="Date" value="<%=txtDtFacilInjuryDtrmntn%>" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Side" required="true" name="selSzCdFacilInjurySide" tabIndex="<%= tabIndex++ %>" codesTable="CSDOBODY" value="<%=injuryDetail.getSzCdFacilInjurySide()%>" blankValue="true"/></td>
    <td><impact:validateSelect label="Type" required="true" name="selSzCdFacilInjuryType" tabIndex="<%= tabIndex++ %>" codesTable="CTYPEINJ" value="<%=injuryDetail.getSzCdFacilInjuryType()%>" blankValue="true"/></td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Area" required="true" name="selSzCdFacilInjuryBody" tabIndex="<%= tabIndex++ %>" codesTable="CBDYAREA" value="<%=injuryDetail.getSzCdFacilInjuryBody()%>" blankValue="true"/></td>
    <td><impact:validateSelect label="Cause" required="true" name="selSzCdFacilInjuryCause" tabIndex="<%= tabIndex++ %>" codesTable="CCAUSINJ" value="<%=injuryDetail.getSzCdFacilInjuryCause()%>" blankValue="true"/></td>
  </tr>
  <tr>
    <td>Comments:</td>
    <td colspan="3"><impact:validateTextArea name="txtaSzTxtFacilInjuryCmnts" colspan="3" maxLength="80" rows="4" cols="40" tabIndex="<%= tabIndex++ %>" ><%=injuryDetail.getSzTxtFacilInjuryCmnts()%></impact:validateTextArea></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
      <impact:ButtonTag name="btnDeleteInj" img="btnDelete" form="frmInjuryDetail" disabled="<%= String.valueOf( bDelete ) %>" action="/investigation/Allegation/deleteInjury" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td class="alignRight">
      <impact:ButtonTag name="btnAddInj" img="btnAdd" form="frmInjuryDetail" disabled="<%= String.valueOf( bAdd ) %>" action="/investigation/Allegation/saveInjury" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
      <impact:ButtonTag name="btnContinueInj" img="btnContinue" form="frmInjuryDetail" disabled="<%= String.valueOf( bContinue ) %>" action="/investigation/Allegation/saveInjury" restrictRepost="true" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

