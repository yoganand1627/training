<%
//*  JSP Name:     Person Merge/Split Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 11/10/2002
//*
//*  Description:
//*  This JSP is used to Merge and Split people
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC13SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation"  %>
<%

  final String FORWARD = "1";
  final String CLOSED = "0";

  //Get the output object from the request
  ROWCCFC13SOG00 rowccfc13sog00 = (ROWCCFC13SOG00) request.getAttribute("ROWCCFC13SOG00");
  CCFC23SO ccfc23so = (CCFC23SO) request.getAttribute("CCFC23SO");
  String bIndActiveStatus = (String) request.getAttribute("bIndActiveStatus");
  String cSysIndPrimaryWorker = (String) request.getAttribute("cSysIndPrimaryWorker");
  String cWcdPersonPassedIn = (String) request.getAttribute("cWcdPersonPassedIn");
  String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
  String ulIdPersonClosed = "";
  String ulIdPersonForward = "";
  String szNmPersonFullForward = "";
  String szNmPersonFullClosed = "";
  String bIndValidate = "";
  int ulIdPerson = 0;
  String cSysIndError = "";
  // Initialize the booleans for enabling and disabling
  // the ID Person Forward and ID Person closed text fields
  String disableIDPersonClosed = "false";
  String disableIDPersonForward = "false";

  if (request.getAttribute("bIndValidate") != null)
  {
    bIndValidate = (String)request.getAttribute("bIndValidate");
  }

  if (GlobalData.getUlIdPerson( request ) != 0)
  {
    ulIdPerson = GlobalData.getUlIdPerson( request );
  }

  if (ccfc23so != null)
  {
    cSysIndError = ccfc23so.getCSysIndError();
  }
  if (rowccfc13sog00 == null) {
    rowccfc13sog00 = new ROWCCFC13SOG00();
  }

  //If the ReqFuncCd is equal to Update, place all of the correct infomation into the
  //Correct place from the row
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE))
  {
    ulIdPersonForward = FormattingHelper.formatString(String.valueOf(rowccfc13sog00.getUlIdPersMergeForward()));
    ulIdPersonClosed = FormattingHelper.formatString(String.valueOf(rowccfc13sog00.getUlIdPersMergeClosed()) );
    szNmPersonFullForward =  FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMergeForward());
    szNmPersonFullClosed =FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMergeClosed());
    disableIDPersonClosed = "true";
    disableIDPersonForward = "true";
  }

  //If the ReqFucCd is equal to Add, place the person passed in information in the correct
  //place, depending on if the person passed in is an employee or not.  Else, set the
  //information to what is returned from rowccfc13sog00
  if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD))
  {
    //If the Person passed is going to be the forward person
    //place it in the forward division and the Forward ID Person
    //Input field will be disabled
    if (cWcdPersonPassedIn.equals(FORWARD))
    {
      if (ulIdPerson != 0)
      {

        ulIdPersonForward = String.valueOf(ulIdPerson);
        disableIDPersonClosed = "false";
        disableIDPersonForward = "true";
      }

      String szNmPersonFull = (String) request.getAttribute("szNmPersonFull");
      if (szNmPersonFull != null)
      {
        szNmPersonFullForward = szNmPersonFull;
      }
      ulIdPersonClosed = "";
      szNmPersonFullClosed = "";
    }
    // Else put the information in the closed Person ID block, and disable the
    // closed Person ID input field
    else
    {
      if (ulIdPerson != 0)
      {
        ulIdPersonClosed = String.valueOf(ulIdPerson);
        disableIDPersonClosed = "true";
        disableIDPersonForward = "false";
      }
      String szNmPersonFull = (String) request.getAttribute("szNmPersonFull");
      if (szNmPersonFull != null)
      {
        szNmPersonFullClosed = szNmPersonFull;
      }
      ulIdPersonForward = "";
      szNmPersonFullForward = "";
    }
  }
  else if (cReqFuncCd.equals(PersonDetailConversation.VALIDATE))
  {
    //If the ReqFuncCd is "V", we are returning from the validate method,
    //the IDs and Names need to be gotten from the request, and the
    //reqFuncCd needs to be re-set to Add.
    cReqFuncCd = (ServiceConstants.REQ_FUNC_CD_ADD);
    // If the Person being validated is the Closed Person (I.E. the person forward already has
    // the name associated with him/her), the szNmPersonFull returned
    // from the service is the person name for the closed person, so populate the closed
    // person name from the service output
    if (cWcdPersonPassedIn.equals(FORWARD))
    {

      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "false";
        disableIDPersonForward = "true";
      }

      String szNmPersonFullF = (String) request.getAttribute("dspSzScrNmPersMergeForward");
      if (szNmPersonFullF != null)
      {
        szNmPersonFullForward = szNmPersonFullF;
      }
      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      String szNmPersonFullC = FormattingHelper.formatString(ccfc23so.getSzNmPersonFull());
      if (szNmPersonFullC != null)
      {
        szNmPersonFullClosed = szNmPersonFullC;
      }
    }
    // Else, the Person passed in is the closed person, and the person forward is the
    // person being validated, so put the forward full name as the service output
    else
    {

      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "true";
        disableIDPersonForward = "false";
      }

      String szNmPersonFullF = FormattingHelper.formatString(ccfc23so.getSzNmPersonFull());
      if (szNmPersonFullF != null)
      {
        szNmPersonFullForward = szNmPersonFullF;
      }
      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      String szNmPersonFullC = (String) request.getAttribute("dspSzScrNmPersMergeClosed");
      if (szNmPersonFullC != null)
      {
        szNmPersonFullClosed = szNmPersonFullC;
      }
    }
  }
  else if (cReqFuncCd.equals(PersonDetailConversation.SWITCH))
  {

    //If the ReqFuncCd is "S", it has been set in the Switch Method to this,
    // so the reqFuncCd needs to be changed back to add, and the id persons, and names
    // need to be switched.
    cReqFuncCd = (ServiceConstants.REQ_FUNC_CD_ADD);
    if (cWcdPersonPassedIn.equals(FORWARD))
    {
      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "false";
        disableIDPersonForward = "true";
      }

      String szNmPersonFullF = (String) request.getAttribute("dspSzScrNmPersMergeClosed");
      if (szNmPersonFullF != null)
      {
        szNmPersonFullForward = szNmPersonFullF;
      }
      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      szNmPersonFullClosed = "";
    }
    else
    {

      String ulIdPersonF = (String) request.getAttribute("txtUlIdPersMergeClosed");
      if (ulIdPersonF != null)
      {
        ulIdPersonForward = ulIdPersonF;
        disableIDPersonClosed = "true";
        disableIDPersonForward = "false";
      }

      szNmPersonFullForward = "";

      String ulIdPersonC = (String) request.getAttribute("txtUlIdPersMergeForward");
      if (ulIdPersonC != null)
      {
        ulIdPersonClosed = ulIdPersonC;
      }
      String szNmPersonFullC = (String) request.getAttribute("dspSzScrNmPersMergeForward");
      if (szNmPersonFullC != null)
      {
        szNmPersonFullClosed = szNmPersonFullC;
      }
    }
  }//End if reqfunccd = "S" (switch)

// Used disableIDPersonClosed and disableIDPersonForward to disable the ID text boxes
// in the appropriate manner in the above ifs.  However, if we are not in set A, we want
// to disable them regardless.

  if (!Sets.isInSet(Sets.A, request))
  {
    disableIDPersonClosed = "true";
    disableIDPersonForward = "true";
  }

  /**
  *  Page Mode Logic
  *
  *   1.  VIEW - Will have the following sets:
  *       a.  If the person has Maintain Person, or Merge Person
  *           Security attributes
  *   2.  EDIT -- Will have the following sets:
  *       a.  If the Person is the Primary worker, or in the Primary
  *           Hierarchy
  *
  * All of the Person Detail page modes other than View will be treated as Edit.
  *
  */

  String pageModePassed = "";
  String overallPageMode = PageModeConstants.EDIT;

   if (request.getAttribute("pageMode") != null )
   {
     pageModePassed = (String) request.getAttribute("pageMode");
     if (pageModePassed.equals(PageModeConstants.MODIFY))
     {
       overallPageMode = PageModeConstants.EDIT;
     }
     else if (pageModePassed.equals(PageModeConstants.VIEW))
     {
       overallPageMode = PageModeConstants.VIEW;
     }
 }

%>
<% // Start Javascript Section
 %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">
<%
      int ulIdPersonC = 0;
      int ulIdPersonF = 0;
      if ( StringHelper.isValid(ulIdPersonClosed))
      {
        ulIdPersonC = Integer.parseInt(ulIdPersonClosed);
      }
      if ( StringHelper.isValid(ulIdPersonForward))
      {
        ulIdPersonF = Integer.parseInt(ulIdPersonForward);
      }

%>

  function mergePerson()
  {
      if (frmMergeSplitDetail.hdnBIndValidate.value == "Y")
      {
        <%
        String message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_MERGE) ;
        message = MessageLookup.addMessageParameter( message, ulIdPersonC );
        message = MessageLookup.addMessageParameter( message, ulIdPersonF );
        %>
        bMerge = confirm("<%= message %> ")
        return bMerge;
      }
      else
      {
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_VAL_MERGE) %>');
        return false;
      }
    }
    function splitPerson()
    {
        <%
        message = "";
        message = MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_SPLIT) ;
        message = MessageLookup.addMessageParameter( message, ulIdPersonC );
        message = MessageLookup.addMessageParameter( message, ulIdPersonF );
        %>
        bMerge = confirm("<%= message %> ")
        return bMerge;
    }
    function notValid()
    {
      frmMergeSplitDetail.hdnBIndValidate.value="N";
    }

    //  Called onUnload of page to remind user unsaved data will be lost
    window.onbeforeunload = function ()
    {
       IsDirty();
    }

</script>


<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;
%>

<impact:validateErrors/>
<impact:validateForm name="frmMergeSplitDetail"
  method="post"
  action="/person/PersonDetail/saveMergeSplit"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.MergeSplitCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>
  <impact:validateInput type="hidden" name="hdnBIndActiveStatus" value="<%=FormattingHelper.formatString(bIndActiveStatus)  %>"/>
  <impact:validateInput type="hidden" name="hdnCSysIndPrimaryWorker" value="<%= FormattingHelper.formatString(cSysIndPrimaryWorker)%>"/>
  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
  <impact:validateInput type="hidden" name="hdnCWcdPersonPassedIn" value="<%= FormattingHelper.formatString(cWcdPersonPassedIn)  %>"/>
  <impact:validateInput type="hidden" name="hdnTsMergeLastUpdate" value="<%= DateHelper.toISOStringSafe(rowccfc13sog00.getTsLastUpdate())  %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdPersMergeWrkr" value="<%= FormattingHelper.formatInt(rowccfc13sog00.getUlIdPersMergeWrkr()) %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdPersonMerge" value="<%= FormattingHelper.formatInt(rowccfc13sog00.getUlIdPersonMerge())%>"/>
  <impact:validateInput type="hidden" name="hdnBIndValidate" value="<%= FormattingHelper.formatString(bIndValidate)  %>"/>
  <impact:validateInput type="hidden" name="hdnCSysIndError" value="<%= FormattingHelper.formatString(cSysIndError)%>"/>
  
 
 <% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="4">Forward</th>
  </tr>
  <tr>
    <td><impact:validateInput type="text" label="Person ID" constraint="ID" name="txtUlIdPersMergeForward" cssClass="formInput" disabled="<%=disableIDPersonForward%>" editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" value="<%= FormattingHelper.formatString(ulIdPersonForward)  %>" size="10" maxLength="10" tabIndex="<%= tabIndex++ %>"/>
    </td>
  <td><impact:validateDisplayOnlyField name="dspSzScrNmPersMergeForward" label="Name" value="<%= FormattingHelper.formatString(szNmPersonFullForward)  %>" /></td>
  </tr>
  <th colspan="4">Closed</th>
  <tr>
    <td><impact:validateInput type="text" label="Person ID" constraint="ID" name="txtUlIdPersMergeClosed" cssClass="formInput" disabled="<%=disableIDPersonClosed %>" editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" value="<%= FormattingHelper.formatString(ulIdPersonClosed)  %>" size="10" maxLength="10" tabIndex="<%= tabIndex++ %>"/>
    </td>
  <td><impact:validateDisplayOnlyField name="dspSzScrNmPersMergeClosed" label="Name" value="<%= FormattingHelper.formatString(szNmPersonFullClosed)  %>" /></td>
  </tr>
  <th colspan="4">Merge Information</th>
  <tr>
  <td><impact:validateDisplayOnlyField name="dspSzScrNmPersMergeWrkr" label="Staff Name Merge" value="<%=FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMergeWrkr())%>" /></td>
  <td><impact:validateDisplayOnlyField name="dspDtDtPersMerge" label="Date Merge" value="<%=FormattingHelper.formatDate(rowccfc13sog00.getDtDtPersMerge())%>" /></td>
  </tr>
  <th colspan="4">Split Information</th>
  <tr>
  <td><impact:validateDisplayOnlyField name="dspSzScrNmPersMrgSpltWrkr" label="Staff Name Split" value="<%=FormattingHelper.formatString(rowccfc13sog00.getSzScrNmPersMrgSpltWrkr())%>" /></td>
  <td><impact:validateDisplayOnlyField name="dspDtDtPersMergeSplit" label="Date Split" value="<%=FormattingHelper.formatDate(rowccfc13sog00.getDtDtPersMergeSplit())%>" /></td>
  </tr>


</table>
<%
   //Only display Validate, Switch and Merge if the user is adding a row.  Else,
   //only display the split button if we are updating a row, and the row has not been
   //previously split, also only display any of these pushbuttons if we are in set A
%>
      <table width="100%" cellpadding="3" cellspacing="0">
          <tr>
          <td width="80%"></td>
          <% if (cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD))
            { %>
          <td>
               <div class="alignRight"><impact:ButtonTag name="btnValidate" img="btnValidate" disabled="<%= Sets.isNotInSetStr(Sets.A, request) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" form="frmMergeSplitDetail" action="/person/PersonDetail/validateMerge" tabIndex="<%= tabIndex++ %>"/></div>
           </td>
           <td>
              <div class="alignRight"><impact:ButtonTag name="btnSwitch" restrictRepost="true" img="btnSwitch" disabled="<%= Sets.isNotInSetStr(Sets.A, request) %>" editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" form="frmMergeSplitDetail" action="/person/PersonDetail/switchMerge" tabIndex="<%= tabIndex++ %>"/></div>
           </td>
           <td>
              <div class="alignRight"><impact:ButtonTag name="btnMerge" restrictRepost="true" img="btnMerge" disabled="<%= Sets.isNotInSetStr(Sets.A, request) %>" editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" function="return mergePerson()" form="frmMergeSplitDetail" action="/person/PersonDetail/saveMergeSplit" tabIndex="<%= tabIndex++ %>"/></div>
           </td>
           <% } else if ( cReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE) && rowccfc13sog00.getUlIdPersMergeSplitWrkr() == 0 ) { %>
             <td>
              <div class="alignRight"><impact:ButtonTag name="btnSplit" restrictRepost="true" img="btnSplit" disabled="<%= Sets.isNotInSetStr(Sets.A, request) %>" editableMode="<%= EditableMode.EDIT + EditableMode.VIEW %>" function="return splitPerson()" form="frmMergeSplitDetail" action="/person/PersonDetail/saveMergeSplit" tabIndex="<%= tabIndex++ %>"/></div>
           </td>
           <% } %>
      </tr>
      </table>
<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>


<script type="text/javascript" language="JavaScript1.2">
</script>

