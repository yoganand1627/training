<%
//*  JSP Name:     FA Home Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 11/13/2002
//*
//*  Description:
//*  This JSP is used to maintain a Person's FA Home Member Training Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  08/26/03  A.Corley          SIR 19538 Disable validation when deleting
//**  03/19/08  charden		      Changed the size of the agency field to 40
//**

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SOG00" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<% // Import State Management classes - Should be on every page
 %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%// Import PageMode and other utilities used on the page - Should be on every page
%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%// Import needed for Messages
%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%// Import needed for Form Launch
%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%
//Get the output object from the request
BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
UserProfile user = UserProfileHelper.getUserProfile( request );
CFAD32SOG00 cfad32sog00 = (CFAD32SOG00) state.getAttribute("CFAD32SOG00", request);
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");

if (cfad32sog00 == null)
{
 cfad32sog00 = new CFAD32SOG00();
}
%>
<% // Start Javascript Section
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
function cancelValidation ()
{
    disableValidation('frmFAHomeDetail');
}

function deleteRow()
{
  var bRow = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
  return bRow;
}

//  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
  IsDirty();
}

</script>
<% //End Javascript Section
%>

<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

  //Initialize the variables that will specify the display rules for individual fields
  String pageModePassed = "";
  String overallPageMode = PageModeConstants.EDIT;
  // SIR 19350
  String onlyButton = "false";
  String hideFAFlag = ArchitectureConstants.TRUE;

   if (request.getAttribute("pageMode") != null )
   {
     pageModePassed = (String) request.getAttribute("pageMode");
     if (pageModePassed.equals(PageModeConstants.MODIFY))
     {
       overallPageMode = PageModeConstants.EDIT;
     }
     else if (pageModePassed.equals(PageModeConstants.NEW))
     {
       overallPageMode = PageModeConstants.NEW;
       onlyButton = "true";   // SIR 19350
     }
     else if (pageModePassed.equals(PageModeConstants.VIEW))
     {
       overallPageMode = PageModeConstants.VIEW;
     }
   }
   
   // STGAP00003018 - removed Maintain Resource sec attr as condition on modifying F/A Home
   hideFAFlag = overallPageMode.equals(PageModeConstants.VIEW) ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE;
%>
<impact:validateErrors/>
<impact:validateForm name="frmFAHomeDetail"
  method="post"
  action="/person/PersonDetail/saveFAHome"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.FAHomeCustomValidation"
  pageMode="<%= overallPageMode %>"
  defaultButton="<%= onlyButton %>"
  schema="/WEB-INF/Constraints.xsd">
<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>
  <impact:validateInput type="hidden" name="hdnTsFALastUpdate" value="<%= DateHelper.toISOString(cfad32sog00.getTsLastUpdate()) %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdIndivTraining" value="<%= FormattingHelper.formatInt(cfad32sog00.getUlIdIndivTraining())%>"/>
  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>

<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="4">F/A Home Member Training</th>
  </tr>
  <tr>
    <td><impact:validateDate type="text"
                             name="txtDtDtIndivTrn"
                             label="Date Completed"
                             constraint="Date"
                             required="true"
                             value="<%= FormattingHelper.formatDate(cfad32sog00.getDtDtIndivTrn()) %>"
                             disabled="<%= hideFAFlag %>"
                             editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                             size="10"
                             tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td><impact:validateInput type="text"
                              label="Title"
                              constraint="Paragraph"
                              name="txtSzTxtIndivTrnTitle"
                              required="true"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatString(cfad32sog00.getSzTxtIndivTrnTitle()) %>"
                              disabled="<%= hideFAFlag %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              size="50"
                              maxLength="50"
                              tabIndex="<%= tabIndex++ %>" />
    </td>
  </tr>
  <tr>
    <td><impact:validateSelect label="Type"
                               name="selSzCdIncRsrcType"
                               required="true"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="CFATRAIN"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= hideFAFlag %>"
                               value="<%=cfad32sog00.getSzCdIndivTrnType()%>"/>
    </td>
    <td></td>
    <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                              checked="<%= FormattingHelper.formatString(cfad32sog00.getCIndIndivTrnEc()) %>"
                              type="checkbox"
                              name="cbxCIndIndivTrnEc"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              label="Documentation Received"
                              cssClass="formInput" />
    </td>
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                              label="Agency"
                              constraint="Paragraph"
                              name="txtNmAgency"
                              required="true"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatString(cfad32sog00.getNmAgency()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="40"
                              maxLength="40"
                              tabIndex="<%= tabIndex++ %>" />
    </td>
    <td></td>
      <td><impact:validateInput tabIndex="<%= tabIndex++ %>"
                      checked="<%= FormattingHelper.formatString(cfad32sog00.getLdIndCoTrain()) %>"
                              type="checkbox"
                              name="cbxLdIndCoTrain"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              label="Co-Trained With DFCS"
                              cssClass="formInput" />
        </td>
  </tr>
  
  <tr>
    <td><impact:validateInput type="text"
                              label="Session"
                              constraint="Digit2Less"
                              name="txtSNbrIndivTrnSession"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatInt(cfad32sog00.getSNbrIndivTrnSession()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="2"
                              maxLength="2"
                              tabIndex="<%= tabIndex++ %>" />
    </td>
    <td><impact:validateInput type="text"
                              label="Hours"
                              name="txtLdNbrIndivTrnHrs"
                              cssClass="formInput"
                              value="<%= String.valueOf(cfad32sog00.getLdNbrIndivTrnHrs()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="3"
                              maxLength="3"
                              tabIndex="<%= tabIndex++ %>" />
    </td>
 </table>

 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="4">Trainer Names</th>
  </tr>
  <tr>
      <td><impact:validateInput type="text"
                              label="Trainer 1"
                              constraint="Paragraph"
                              name="txtldNmTrain1"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatString(cfad32sog00.getLdNmTrain1()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="30"
                              maxLength="30"
                              tabIndex="<%= tabIndex++ %>" />
      </td>
      <td><impact:validateSelect label="Role"
                               name="selldCdTrain1Role"
                               required="false"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="CFAROLE"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= hideFAFlag %>"
                               value="<%=cfad32sog00.getLdCdTrain1Role()%>"/>
      </td>
    </tr>
    <tr>
      <td><impact:validateInput type="text"
                              label="Trainer 2"
                              constraint="Paragraph"
                              name="txtldNmTrain2"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatString(cfad32sog00.getLdNmTrain2()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="30"
                              maxLength="30"
                              tabIndex="<%= tabIndex++ %>" />
      </td>
      <td><impact:validateSelect label="Role"
                               name="selldCdTrain2Role"
                               required="false"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="CFAROLE"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= hideFAFlag %>"
                               value="<%=cfad32sog00.getLdCdTrain2Role()%>"/>
      </td>
    </tr>
    <tr>
      <td><impact:validateInput type="text"
                              label="Trainer 3"
                              constraint="Paragraph"
                              name="txtldNmTrain3"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatString(cfad32sog00.getLdNmTrain3()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="30"
                              maxLength="30"
                              tabIndex="<%= tabIndex++ %>" />
      </td>
      <td><impact:validateSelect label="Role"
                               name="selldCdTrain3Role"
                               required="false"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="CFAROLE"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= hideFAFlag %>"
                               value="<%=cfad32sog00.getLdCdTrain3Role()%>"/>
      </td>
    </tr>
    <tr>
      <td><impact:validateInput type="text"
                              label="Trainer 4"
                              constraint="Paragraph"
                              name="txtldNmTrain4"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatString(cfad32sog00.getLdNmTrain4()) %>"
                              editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                              disabled="<%= hideFAFlag %>"
                              size="30"
                              maxLength="30"
                              tabIndex="<%= tabIndex++ %>" />
      </td>
      <td><impact:validateSelect label="Role"
                               name="selldCdTrain4Role"
                               required="false"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="CFAROLE"
                               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                               disabled="<%= hideFAFlag %>"
                               value="<%=cfad32sog00.getLdCdTrain4Role()%>"/>
      </td>
    </tr>
 </table>

<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
  <!-- 
  <td>
         <impact:ButtonTag name="btnDelete"
                           img="btnDelete"
                           restrictRepost="true"
                           function="cancelValidation(); return deleteRow()"
                           form="frmFAHomeDetail"
                           editableMode="<%= EditableMode.EDIT %>"
                           action="/person/PersonDetail/deleteFAHome"
                           tabIndex="<%= tabIndex++ %>"/>
    </td> 
   -->
  
    <td class="alignRight">
         <impact:ButtonTag name="btnSave"
                           img="btnSave"
                           restrictRepost="true"
                           form="frmFAHomeDetail"
                           action="/person/PersonDetail/saveFAHome"
                           disabled="<%=hideFAFlag %>"
                           editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                           tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
</table>

<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>
  
     