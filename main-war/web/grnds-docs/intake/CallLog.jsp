<%
/*  JSP Name:     Call Log
//*  Created by:   Michael Ochu
//*  Date Created: 01/05/2003
//*
//*  Description:
//*  The Call Log page allows a user to search for a particular caller,
//*  collateral, principal, inregard to, or calls taken by an employee.  From
//*  this page, the user can navigate to intake call log (Call Summary) in modify mode via the
//*  New Using menu item or to Call Summary in browse mode via the caller hyperlink.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  08/04/03  CASDORJM          Added in a "return false;" to the generateReportParamList()
//**                              when the user got the alert warning them to complete
//**                              a search first.
//**  4/9/2004  gerryc            SIR 22589 - added tab index for hyperlink of caller name, this
//**                              goes in between the radio button and the New Using button
//**
//** 09/16/2004 Ochumd            Sir 22964 - Added new field I&R Type such that the user can
//**                              now search for an I&R by I&R Type.
//** 01/07/2005 Ochumd            Sir 22965 - Added Hyperlink of Classification. It is enabled
//**                              only When Classification is I&R.
//** 08/24/2005 ochumd            Sir 23788 - Currently, a call log search will return the name
//**                              of the reporter of a case, even if the case is marked sensitive.
//**                              Reporter name now blocked in sensitive cases.
*/

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>



<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallListSrchOutRec"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.CallLogConversation" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>

<%
  
  request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  if (FormValidation.pageHasValidationMessages("frmCallLog", request))
  {
    request.removeAttribute("CallListSrchOutRec");
    request.removeAttribute(CallLogConversation.NO_RESULTS_FOUND);
  }

  String pageMode = PageMode.getPageMode(request);

  String txtFirstName               = "";
  String txtMiddleInt               = "";
  String txtLastName                = "";
  String selszCdStagePersType       = "";
  String selszCdStageClassification = "";
  String txtidStage                 = "";
  String txtNbrUnit                 = "";
  String selszCdIncomingCounty      = "";
  String txtIncomingCallerCity      = "";
  String selszCdStageRegion         = "";
  String selszCdIncomingDisposition = "";
  String selCdStageCurrPriority     = "";
  String dtrangeFrom                = "";
  String dtrangeTo                  = "";
  String szScrTimeFrom              = "";
  String szScrTmTimeTo              = "";
  String selszCdStageNonIncType     = "";
  String onlyButton                 = "true";

  int tabIndex = 1;
  int loopCount = 0;
  Enumeration enumeration = null;

  UserProfile user = UserProfileHelper.getUserProfile(request);
  CallListSrchOutRec cint07so = null;
  cint07so = (CallListSrchOutRec) request.getAttribute("CallListSrchOutRec");

  CallListStruct_ARRAY callListArray = new CallListStruct_ARRAY();

  if (cint07so != null)
  {
    callListArray = cint07so.getCallListStruct_ARRAY();
  }


//get data from the state to populate the search criteria after a search has
// been performed.
  if (request.getParameter("txtFirstName") != null)
  {
    txtFirstName = request.getParameter("txtFirstName");
  }

  if (request.getParameter("txtMiddleInt") != null)
  {
    txtMiddleInt = request.getParameter("txtMiddleInt");
  }

  if (request.getParameter("txtLastName") != null)
  {
    txtLastName = request.getParameter("txtLastName");
  }

  selszCdStagePersType = ContextHelper.getStringSafe(request, "selszCdStagePersType");

  if (request.getAttribute("selszCdStagePersType") != null)
  {
    selszCdStagePersType = (String) request.getAttribute("selszCdStagePersType");
  }

  if (request.getParameter("selszCdStageClassification") != null)
 {
    selszCdStageClassification = request.getParameter("selszCdStageClassification");
    // 5/23/03
 }

  if (request.getParameter("txtIncomingCallerCity") != null)
  {
   txtIncomingCallerCity = request.getParameter("txtIncomingCallerCity");
  }

  if (request.getParameter("txtUlidStage") != null)
  {
    txtidStage = request.getParameter("txtUlidStage");
  }

  if (request.getParameter("txtNbrUnit") != null)
  {
    txtNbrUnit = request.getParameter("txtNbrUnit");
  }

  if (request.getParameter("selszCdIncomingCounty") != null)
  {
    selszCdIncomingCounty = request.getParameter("selszCdIncomingCounty");
  }

  if (request.getParameter("selszCdStageRegion") != null)
  {
    selszCdStageRegion = request.getParameter("selszCdStageRegion");
  }

  if (request.getParameter("selszCdIncomingDisposition") != null)
  {
    selszCdIncomingDisposition = request.getParameter("selszCdIncomingDisposition");
  }

  if (request.getParameter("selCdStageCurrPriority") != null)
  {
    selCdStageCurrPriority = request.getParameter("selCdStageCurrPriority");
  }

  if (request.getParameter("dtrangeFrom") != null)
  {
    dtrangeFrom = request.getParameter("dtrangeFrom");
  }

  if (request.getParameter("dtrangeTo") != null)
  {
    dtrangeTo = request.getParameter("dtrangeTo");
  }

  if (request.getParameter("szScrTimeFrom") != null)
  {
    szScrTimeFrom = request.getParameter("szScrTimeFrom");
  }

  if (request.getParameter("szScrTmTimeTo") != null)
  {
    szScrTmTimeTo = request.getParameter("szScrTmTimeTo");
  }

  if (request.getParameter("selszCdStageNonIncType") != null)
  {
    selszCdStageNonIncType = request.getParameter("selszCdStageNonIncType");
  }


%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">



function submitStage_ID(stageId,personId)
{
  document.frmCallLog.stageId.value = stageId;
  document.frmCallLog.personId.value = personId;
  document.frmCallLog.displayIntakeActionsFromIntakeReportLog.value = "<%=ArchitectureConstants.Y%>";
  document.frmCallLog.intakeActionsPageMode.value = "<%=PageModeConstants.VIEW%>";
  submitValidateForm("frmCallLog", "/intake/IntakeActions/displayIntakeActions");
}

// This function passes the report parameters to the report architecture. First
// it verifies that a search was performed and rows were returned and the Start
// Date and End Date are not empty.
function generateReportParamList()
{
  <%
  enumeration = callListArray.enumerateCallListStruct();
  if ( enumeration.hasMoreElements())
  {%>
    document.frmCallLog.hdnReportParamRangeFrom.value = document.frmCallLog.dtrangeFrom.value;
    document.frmCallLog.hdnReportParamRangeTo.value = document.frmCallLog.dtrangeTo.value;
    document.frmCallLog.hdnReportParamTimeFrom.value = document.frmCallLog.szScrTimeFrom.value;
    document.frmCallLog.hdnReportParamTimeTo.value = document.frmCallLog.szScrTmTimeTo.value;

    if (document.frmCallLog.hdnReportParamRangeFrom.value == "" ||
         document.frmCallLog.hdnReportParamRangeTo.value == "")
    {
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_RANGE_TOO_LONG)%>");
      return  false;
    }

    // Pass stage classification value.
    if (document.frmCallLog.hdnReportParamStageClassification.value != "")
    {
      setReportParameters("StageClassification", document.frmCallLog.hdnReportParamStageClassification.value);
    }
    else
    {
      setReportParameters("StageClassification", "");
    }
    // Pass stage id value.
    if (document.frmCallLog.hdnReportParamIdStage.value != "")
    {
      addReportParameter("IdStage", document.frmCallLog.hdnReportParamIdStage.value);
    }
    else
    {
      addReportParameter("IdStage", "");
    }
    // Pass caller city value.
    if (document.frmCallLog.hdnReportParamIncomingCallerCity.value != "")
    {
      addReportParameter("IncomingCallerCity", document.frmCallLog.hdnReportParamIncomingCallerCity.value);
    }
    else
    {
      addReportParameter("IncomingCallerCity", "");
    }
    // Pass incoming county value.
    if (document.frmCallLog.hdnReportParamIncomingCounty.value != "")
    {
      addReportParameter("IncomingCounty", document.frmCallLog.hdnReportParamIncomingCounty.value);
    }
    else
    {
      addReportParameter("IncomingCounty", "");
    }
    // Pass current priority value.
    if (document.frmCallLog.hdnReportParamStageCurrPriority.value != "")
    {
      addReportParameter("CurrPriority", document.frmCallLog.hdnReportParamStageCurrPriority.value);
    }
    else
    {
      addReportParameter("CurrPriority", "");
    }
    // Pass region value.
    if (document.frmCallLog.hdnReportParamStageRegion.value != "")
    {
      addReportParameter("Region", document.frmCallLog.hdnReportParamStageRegion.value);
    }
    else
    {
      addReportParameter("Region", "");
    }
    // Pass unit value.
    if (document.frmCallLog.hdnReportParamNbrUnit.value != "")
    {
      addReportParameter("Unit", document.frmCallLog.hdnReportParamNbrUnit.value);
    }
    else
    {
      addReportParameter("Unit", "");
    }

    // Pass date from value.
    addReportParameter("DateFrom", document.frmCallLog.hdnReportParamRangeFrom.value);

    // Pass time from value.
    if (document.frmCallLog.hdnReportParamTimeFrom.value != "")
    {
      addReportParameter("TimeFrom", document.frmCallLog.hdnReportParamTimeFrom.value);
    }
    else
    {
      addReportParameter("TimeFrom", "");
    }

    // Pass date to value.
    addReportParameter("DateTo", document.frmCallLog.hdnReportParamRangeTo.value);

    // Pass time to value.
    if (document.frmCallLog.hdnReportParamTimeTo.value != "")
    {
      addReportParameter("TimeTo", document.frmCallLog.hdnReportParamTimeTo.value);
    }
    else
    {
      addReportParameter("TimeTo", "");
    }

    return true;
  <%
  }
  else
  {%>
    alert("You must perform a search.");
    return false;
  <%
  }
  %>
}


// This function confirms that the user has selected a row in
// the list box before continuing with the  'New Using'
// procedure.
function confirmRowSelected()
{
  var rowSelected = false;

  //If there is only one radio button, there isn't an array so length is undefined
  if ((document.frmCallLog.rbAddressIndex4.length == undefined) &&
      (document.frmCallLog.rbAddressIndex4.checked))
  {
    rowSelected = true;
  }
  //This handles an array of radio buttons
  for (var i = 0; i < document.frmCallLog.rbAddressIndex4.length; i++)
  {
    if (document.frmCallLog.rbAddressIndex4[i].checked)
    {
      rowSelected = true;
      break;
    }
  }

  if (rowSelected == false)
  {
    alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>");
    return false;
  }
  return true;
}
function setFields(stageId, personId, indicatorSensitive, stageClassification, incomingPriority)

{
  document.frmCallLog.stageId.value = stageId;
  document.frmCallLog.personId.value = personId;
  document.frmCallLog.indicatorSensitive.value = indicatorSensitive;
  document.frmCallLog.stageClassification.value = stageClassification;
  document.frmCallLog.incomingPriority.value = incomingPriority;
}
</script>
<%
// SPB - SIR 19753
boolean noResultsFound = ArchitectureConstants.TRUE.equals(request.getAttribute(CallLogConversation.NO_RESULTS_FOUND));
boolean noPhoneticResultsReturned = ArchitectureConstants.TRUE.equals(request.getAttribute(CallLogConversation.NO_PHONETIC_RESULTS_RETURNED));
if ( request.getAttribute(CallLogConversation.NO_RESULTS_FOUND) != null )
{
  onlyButton = String.valueOf( noResultsFound );
}
else
{
  onlyButton = ArchitectureConstants.TRUE;
}
%>
<impact:validateForm name="frmCallLog"
  method="post"
  action="/intake/CallLog/displayCallLog"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.intake.CallLogCustomValidation"
  pageMode="<%= pageMode %>"
  defaultButton="<%= onlyButton %>"
  schema="/WEB-INF/Constraints.xsd">
<impact:validateErrors formName="frmCallLog"/>

 <% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
     <th colspan="8">Intake Report Query Search Criteria</th>
  </tr>
  <tr>
     <td width="220px"><impact:validateInput type="text"
                               editableMode="<%= EditableMode.EDIT %>"
                               label="Last"
                               conditionallyRequired="true"
                               constraint="Name30"
                               name="txtLastName"
                               cssClass="formInput"
                               value="<%= txtLastName %>"
                               size="22"
                               maxLength="22"
                               tabIndex="<%= tabIndex++ %>"/></td>
                               
     <td width="120px"><impact:validateInput type="text"
                               label="First"
                               constraint="Name30"
                               name="txtFirstName"
                               conditionallyRequired="true"
                               cssClass="formInput"
                               value="<%= txtFirstName %>"
                               size="12"
                               maxLength="12"
                               tabIndex="<%= tabIndex++ %>"/></td>

     <td width="300px"><impact:validateInput type="text"
                               editableMode="<%= EditableMode.EDIT %>"
                               label="Middle"
                               constraint="Name30"
                               name="txtMiddleInt"
                               conditionallyRequired="true"
                               cssClass="formInput"
                               value="<%= txtMiddleInt %>"
                               size="12"
                               maxLength="12"
                               tabIndex="<%= tabIndex++ %>"/></td>    
  </tr>
 <tr>
   <td><impact:validateSelect label="Person Type"
                             name="selszCdStagePersType"
                             tabIndex="<%=tabIndex++%>"
                             codesTable="CCALLLOG"
                             value="<%=selszCdStagePersType%>"/>
    </td>
  <td width="300px"><impact:validateInput type="text"
                               editableMode="<%= EditableMode.EDIT %>"
                               label="Intake Report ID"
                               constraint="Digit16Less"
                               name="txtUlidStage"
                               cssClass="formInput"
                               value="<%= txtidStage %>"
                               size="10"
                               maxLength="10"
                               conditionallyRequired="true"
                               tabIndex="<%= tabIndex++ %>"/>
                               
     <td> <impact:validateSelect
                    label="Program Area"
                    name="selszCdStageClassification"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CCLASS"
                    conditionallyRequired="false"
                    value="<%= selszCdStageClassification %>"/>
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                               label="City"
                               constraint="Name20"
                               name="txtIncomingCallerCity"
                               conditionallyRequired="true"
                               cssClass="formInput"
                               value="<%= txtIncomingCallerCity %>"
                               size="20"
                               maxLength="20"
                               tabIndex="<%= tabIndex++ %>"/>
    </td>                               
    <td><impact:validateSelect
                    label="County"
                    name="selszCdIncomingCounty"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CCOUNT"
                    conditionallyRequired="true"
                    value="<%= selszCdIncomingCounty %>"/>
    </td>
   <td> <impact:validateSelect
                    label="Region"
                    name="selszCdStageRegion"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CREGIONS"
                    conditionallyRequired="true"
                    value="<%= selszCdStageRegion %>"/></td>
  <tr>
  <td> <impact:validateSelect
                    label="Disposition"
                    name="selszCdIncomingDisposition"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CDISP"
                    conditionallyRequired="false"
                    value="<%= selszCdIncomingDisposition %>"/>
  </td>
   <td> <impact:validateSelect
                    label="Response Time"
                    name="selCdStageCurrPriority"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CPRIORTY"
                    conditionallyRequired="false"
                    value="<%= selCdStageCurrPriority %>"/>
                    
  <td><impact:validateInput type="text"
                               label="Unit #"
                               name="txtNbrUnit"
                               conditionallyRequired="false"
                               cssClass="formInput"
                               value="<%= txtNbrUnit %>"
                               size="2"
                               maxLength="2"
                               tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td>
                        <impact:validateDate
                                label="Date From"
                                type="text"
                                size="8"
                                value="<%= dtrangeFrom %>"
                                name="dtrangeFrom"
                                tabIndex="<%= tabIndex++ %>"
                                conditionallyRequired="false"
                                constraint="Date"/>
    </td>
    <td>
                        <impact:validateDate
                                label="Date To"
                                type="text"
                                size="8"
                                value="<%= dtrangeTo %>"
                                name="dtrangeTo"
                                tabIndex="<%= tabIndex++ %>"
                                conditionallyRequired="false"
                                constraint="Date"/>
   </td>
   <td>
                        <impact:validateTime
                                label="Time From"
                                name="szScrTimeFrom"
                                value="<%= szScrTimeFrom %>"
                                tabIndex="<%= tabIndex++ %>"
                                conditionallyRequired="false"/>
    </td>
    <td>
                        <impact:validateTime
                                label="Time To"
                                name="szScrTmTimeTo"
                                value="<%= szScrTmTimeTo %>"
                                tabIndex="<%= tabIndex++ %>"
                                conditionallyRequired="false"/>
    </td>
  </tr>
 <tr>
    <td> <impact:validateSelect
                    label="Non Incident Type"
                    name="selszCdStageNonIncType"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CNIRTYPE"
                    conditionallyRequired="false"
                    value="<%= selszCdStageNonIncType %>"/>

 </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3"  width="100%">
  <tr>
    <td class="alignRight">
     <impact:ButtonTag name="btnSearchFinal"
                       img="btnSearch"
                       backSafe="true"
                       align="right"
                       form="frmCallLog"
                       action="/intake/CallLog/searchCallLog"
                       tabIndex="<%= tabIndex++ %>"/>
   </td>
 </tr>
</table>
<br>
<%


  if ((noResultsFound || noPhoneticResultsReturned) ||
       ((cint07so != null) &&
         (cint07so.getCallListStruct_ARRAY() != null)))
{%>

<br/>
<impact:pagination submitUrl="/intake/CallLog/searchCallLog" saveState="false">

   <table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
      <tr>
        <th colspan="6">Intake Report Query Search List</th>
      </tr>
      <tr>
         <td class="tableBG">
            <div id="scrollBar2" style="height:250px;width:765px;overflow:auto" class="tableborderList">
                <table width="100%" cellspacing="0" cellpadding="3">
                       <tr>
                           <th class="thList">SC</th>
                           <th class="thList">Reporter</th>
                           <th class="thList">Disposition</th>
                           <th class="thList">Intake Date</th>
                           <th class="thList">Intake Time</th>
                           <th class="thList">County</th>
                           <th class="thList">City</th>
                           <th class="thList">Staff Name</th>
                        </tr>
<%
                  if (noResultsFound)
                  {
%>
                     <tr class="odd">
                        <td colspan="8">
                           <%= MessageLookup.getMessageByNumber(Messages.MSG_INT_NO_MATCHES_FND)%>
                        </td>
                      </tr>
<%
                  } else if (noPhoneticResultsReturned)
                  {
%>
                     <tr class="odd">
                        <td colspan="8">
                           <%= MessageLookup.getMessageByNumber(Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED)%>
                        </td>
                      </tr>
<%
                  }
                    else
                  {
                      loopCount = 0;
                      Enumeration callListEnumeration = callListArray.enumerateCallListStruct();
                      CallListStruct callSearchRow = null;

                    while (callListEnumeration.hasMoreElements())
                    {
                      callSearchRow = (CallListStruct) callListEnumeration.nextElement();
                      
                      
%>
<%
     String checkmarkSpace = "&nbsp;";
    
%>
                        <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
                                        
                                     
                            <td><%if (ArchitectureConstants.Y.equals(callSearchRow.getBIndIncmgSensitive())) {%>
                                     <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" >
                                <%}else{%>
                                <%= checkmarkSpace %>
                                <%}%>                           
                            </td>              
                            
<%
    
// ochumd Sir 23788 - sensitive cases should not display caller name.

     String callerName = callSearchRow.getSzScrNmIncmgCaller();
     if ((callerName == null)    ||
         (StringHelper.EMPTY_STRING.equals(callerName)) ||
         (ArchitectureConstants.Y.equals(callSearchRow.getBIndIncmgSensitive())))
     {
       callerName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     }
%>

<%

%>
                            <td>
                            <%if (!ArchitectureConstants.Y.equals(callSearchRow.getBIndIncmgSensitive())) {%>
                               <a href="javascript:submitStage_ID('<%=callSearchRow.getUlIdStage()%>', '<%=callSearchRow.getUlIdIncomingWorker()%>')" tabIndex="<%=tabIndex++%>" ><%= callerName %></a>
                            <%}else{%>
                               <%= callSearchRow.getSzScrNmIncmgCaller() %>
                            <%}%>
                            </td>
                            <td><%= callSearchRow.getSzCdIncomingDisposition() %></td>
                            <td><%= callSearchRow.getDtDtIncomingCall() %></td>
                            <td>
                            <%if (callSearchRow.getTmTmIncmgCall().length() == 7) {%>
                                                        
                                &nbsp;&nbsp;<%= callSearchRow.getTmTmIncmgCall() %>
                            <%}else{%>
                               <%= callSearchRow.getTmTmIncmgCall() %>
                            <%}%>
                            </td>
                            <td><%= Lookup.simpleDecodeSafe("CCOUNT", callSearchRow.getSzCdAddrCounty()) %></td>                            
                            <td><%= callSearchRow.getSzAddrCity() %></td>
                            <td><%= callSearchRow.getSzScrPersonName() %></td>
                          </tr>
<%
                     loopCount++;
                    } // end while
                  }
%>
           </table>
           </div>
        </td>
      </tr>
   </table><% /* CLOSE thE ROW thAT HOLDS thE SCROLL BOX */ %>

</impact:pagination>

<br>
<%}%>

<input type="hidden" name="hdnReportParamStageClassification" value="<%=selszCdStageClassification%>">
<input type="hidden" name="hdnReportParamIdStage" value="<%=txtidStage%>">
<input type="hidden" name="hdnReportParamIncomingCallerCity" value="<%=txtIncomingCallerCity%>">
<input type="hidden" name="hdnReportParamIncomingCounty" value="<%=selszCdIncomingCounty%>">
<input type="hidden" name="hdnReportParamIncomingDisposition" value="<%=selszCdIncomingDisposition%>">
<input type="hidden" name="hdnReportParamStageCurrPriority" value="<%=selCdStageCurrPriority%>">
<input type="hidden" name="hdnReportParamStageRegion" value="<%=selszCdStageRegion%>">
<input type="hidden" name="hdnReportParamNbrUnit" value="<%=txtNbrUnit%>">
<input type="hidden" name="hdnReportParamRangeFrom" value="<%=dtrangeFrom%>">
<input type="hidden" name="hdnReportParamRangeTo" value="<%=dtrangeTo%>">
<input type="hidden" name="hdnReportParamTimeFrom" value="<%=szScrTimeFrom%>">
<input type="hidden" name="hdnReportParamTimeTo" value="<%=szScrTmTimeTo%>">
<input type="hidden" name="hdnReportParamStageNonIncType" value="<%=selszCdStageNonIncType%>">

<input type="hidden" name="stageId" value="">
<input type="hidden" name="intakePageMode" value="">
<input type="hidden" name="personId" value="">
<input type="hidden" name="indicatorSensitive" value="">
<input type="hidden" name="stageClassification" value="">
<input type="hidden" name="incomingPriority" value="">
<input type="hidden" name="intakeActionsPageMode" value="">
<input type="hidden" name="displayIntakeActionsFromIntakeReportLog" value="">

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  
<%-- Comment out Reports for Release One

  <tr><th>Reports</th></tr>
  <tr>
     <td>
       <impact:reportList tabIndex="<%= tabIndex++ %>"
                          personId="<%= user.getUserID() %>"
                          onClick="generateReportParamList()">
                        <impact:report useHiddenParameters="<%=true%>" reportName="cin12o00"
                                       emailMessage='<%= "Unit - " + request.getParameter("hdnReportParamNbrUnit")%>'>
                        </impact:report>
       </impact:reportList>
     </td>
  </tr>
    
Comment out Reports for Release One --%>
</table>
<br>