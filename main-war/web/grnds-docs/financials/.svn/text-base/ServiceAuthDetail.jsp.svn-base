<%//*  JSP Name:     Service Authorization Detail
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 02/19/2003
      //*
      //*  Description:
      //*  This JSP is used to maintain Service Authorization Information
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  06/19/03  GRIMSHAN          SIR 18387 Change javascript logic so that amount
      //**                              will be displayed correctly.
      //**  06/23/03  GRIMSHAN          SIR 18391 Change javascript logic so that auth type
      //**                              will only be over written if it has not been saved.
      //**  06/26/03  GRIMSHAN          SIR 18549 Change javascript logic so that the float
      //**                              returned for unit rate will be formatted with two
      //**                              decimal places
      //**  08/26/03  GRIMSHAN          SIR 19611 Round the amount calculated to 2 digits.
      //**  08/27/03  A.Corley          SIR 19520 Don't run javascript if there is no value
      //**                              in the dropdown
      //**  08/27/03  A.Corley          SIR 19517 If the amount calculated is NaN display 0.00
      //**  09/15/03  A.Corley          SIR 19611 remove a bad "break" from javascript
      //**  01/21/04  A.Corley          SIR 22539 Make sure that the for loop defining the Unit Type
      //**                              is inside the if checking to see if the one selected is the one
      //**                              to be displayed.
      //**  07/15/04  CORLEYAN          SIR 15664 - We are now editing that if they are saving an
      //**                              existing service auth and trying to overlap dates, (ie update)
      //**                              it will not be allowed.  This was confusing to the user b/c
      //**                              the terminate field was displaying as the old terminate instead
      //**                              of the end date.  This is switched on save to the end date, so
      //**                              we will display it as such when you switch from term to update
      //**  08/26/05  thompswa          SIR 23662 Added hidden field for primaryClient
      //**                              and restricted Person(s) list to the PC for,
      //**                              required field, Service of CSVCCODE_96K.
      //**  09/27/05  Ochumd            Sir 23580 - Added a confirmation message to reminding staff
      //**                              to send an updated service authorization form to the provider
      //**                              when an early termination or an update to the authorization is made.
      //**  06/11/2008 arege            STGAP00006593  Invalid Requested Units Error Message on Save.
      //**                              Added hidden field hdnFlag. hdnFlag is set to true when the event
      //**                              is in APRV status
      //**  07/16/2008 mxpatel          STGAP00006627:  Service Authorization Detail: Service Provider Accepted radio button reverts to yes after save.
      //**                              Corrected the logic in method where validation is done.
      //**                              Edited the code so that "yes" is no longer default.
      //**  01/07/08  charden		    STGAP00010533: Removed onChange attribute from Service Provider Accepted. When 
      //**                              checking yes, Authorization Type should not be cleared 
      //**  01/14/2009 arege            STGAP00010534 Modified UpdateAuthType function so that Service Provider Accepted  No radio button
      //**                              changes the  terminate date to Begin date.
      //**  06/11/2009 mxpatel          STGAP00013508: Added onload function to retrieve "Authorization Type" when page loads.                            
      //**  01/25/2010 mxpatel          SMS #44063: added code so that Begin Date on the Service Auth Detail page is saved and displayed correctly.
      //**  02/25/2010 mxpatel          SMS #45293: Modified code so that values can be populated correctly.
      //**  02/25/2010 mchillman        SMS #45293: Modified code so that non 510 512 values can be populated correctly.
      //**  01/19/2012  vcollooru		STGAP00017831: MR-102: Modified to make the following Service Authorization Detail changes
      //**										i) added new field Reason for Referral/Other Comments.
      //**										ii) modified the Comments field length to 1000 characters.
%>
      
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  //Get the output object from the request
  CCON18SO ccon18so = (CCON18SO) state.getAttribute("CCON18SO", request);
  CCON22SO ccon22so = (CCON22SO) request.getAttribute("CCON22SO");
  int editableMode = EditableMode.NONE;
  int loopCount = 0;
  int primaryClient = ContextHelper.getIntSafe(request, "primaryClient");/*SIR 23662*/
  int rowccon22Size = 0;
  int fieldEditableMode = EditableMode.NEW + EditableMode.EDIT;
  org.exolab.castor.types.Date dtDtSvcAuthDtlBegin = new org.exolab.castor.types.Date();
  org.exolab.castor.types.Date dtDtSvcAuthDtlEnd = new org.exolab.castor.types.Date();
  ROWCCON22SOG00_ARRAY personArray = (ROWCCON22SOG00_ARRAY) state.getAttribute("ROWCCON22SOG00_ARRAY", request);
  ROWCCON22SOG01 rowccon22sog01 = new ROWCCON22SOG01();
  ROWCCON22SOG02_ARRAY rowccon22sog02_array = new ROWCCON22SOG02_ARRAY();
  Set excludeViews = (Set) state.getAttribute("excludeViews", request);
  String casePlanSvc_No = ArchitectureConstants.FALSE;
  String casePlanSvc_Yes = ArchitectureConstants.FALSE;
  String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
  String EVENT_STATUS_APPROVE = CodesTables.CEVTSTAT_APRV;
  String pageModePassed = (String) request.getAttribute("pageMode");
  String servAcpt_No = ArchitectureConstants.FALSE;
  String servAcpt_Yes = ArchitectureConstants.FALSE;//mxpatel chnaged this to false.
  String szCdSvcAuthDtlSvc = "";
  String hdnFlag = "";

  //STGAP00006593 if the Event Status is APRV, set hdnFlag to true
  if (EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {
    hdnFlag = ArchitectureConstants.TRUE;
  }

  // If we are in view mode, we do not want to exlude any options.  The service does not
  // return the exclude views array when view mode is passed into it, so re-set excude views to null
  if (pageModePassed.equals(PageModeConstants.VIEW)) {
    excludeViews = null;
  }
  if (ccon22so == null) {
    ccon22so = new CCON22SO();
  } else {
    if (ccon22so.getROWCCON22SOG01() == null) {
      rowccon22sog01 = new ROWCCON22SOG01();
    } else {
      rowccon22sog01 = ccon22so.getROWCCON22SOG01();
    }
    rowccon22sog02_array = ccon22so.getROWCCON22SOG02_ARRAY();
    rowccon22Size = rowccon22sog02_array.getROWCCON22SOG02Count();
  }
  
  szCdSvcAuthDtlSvc = rowccon22sog01.getSzCdSvcAuthDtlSvc();
  dtDtSvcAuthDtlEnd = rowccon22sog01.getDtDtSvcAuthDtlEnd();
  
  if (PageModeConstants.NEW.equals(pageModePassed)) {
    dtDtSvcAuthDtlBegin = ccon18so.getDtDtSvcAuthEff();
    if(rowccon22sog01.getUlIdAdopAssistAppl() > 0) {
       dtDtSvcAuthDtlBegin = rowccon22sog01.getDtDtSvcAuthDtlBegin();
    }
  } else {
    szCdSvcAuthDtlSvc = rowccon22sog01.getSzCdSvcAuthDtlSvc();
    dtDtSvcAuthDtlBegin = rowccon22sog01.getDtDtSvcAuthDtlBegin();
    String status = ccon18so.getROWCCMN01UIG00().getSzCdEventStatus();
    if (EVENT_STATUS_APPROVE.equals(status)) {
      editableMode = EditableMode.EDIT;
      fieldEditableMode = EditableMode.NONE;
    }
  }
  
  if (ArchitectureConstants.Y.equals(rowccon22sog01.getIndServAcpt())) {
    servAcpt_Yes = ArchitectureConstants.TRUE;
    servAcpt_No = ArchitectureConstants.FALSE;
  } else if (ArchitectureConstants.N.equals(rowccon22sog01.getIndServAcpt())) {//mxpatel changed this from .getIndCasePlanSvc to .getIndServAcpt
    servAcpt_Yes = ArchitectureConstants.FALSE;
    servAcpt_No = ArchitectureConstants.TRUE;
  }
  if (ArchitectureConstants.Y.equals(rowccon22sog01.getIndCasePlanSvc())) {
    casePlanSvc_Yes = ArchitectureConstants.TRUE;
    casePlanSvc_No = ArchitectureConstants.FALSE;
  } else if (ArchitectureConstants.N.equals(rowccon22sog01.getIndCasePlanSvc())) {
    casePlanSvc_Yes = ArchitectureConstants.FALSE;
    casePlanSvc_No = ArchitectureConstants.TRUE;
  }
%>
<%
  // Start Javascript Section
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
<impact:codeArray codeName="CCONUNIT" arrayName="unitTypeCodes"/>
// Create an array for looping through service to determine the unit type to be displayed.
// This will also set variables so that if a service selected has a variable unit rate payment type
// Requested Units can be set to 1.00, Suggested Units can be set to 1.00 and Amount can be set
// to Unit Rate returned as a dollar value.

var serviceDetailArray = new Array(<%=rowccon22Size%>);
var amtReqOriginal = <%=rowccon22sog01.getLAmtSvcAuthDtlAmtReq()%>;
<%
  for (int i=0; i<rowccon22Size; i++)
  {
    ROWCCON22SOG02 rowObject = rowccon22sog02_array.getROWCCON22SOG02(i);
    out.println("serviceDetailArray[" + i + "] = new Array(2);");
    out.println("serviceDetailArray[" + i + "][0] = '" + rowObject.getSzCdCnsvcService() + "';");
    out.println("serviceDetailArray[" + i + "][1] = '" + rowObject.getSzNbrCnsvcUnitType() + "';");
    out.println("serviceDetailArray[" + i + "][2] = '" + rowObject.getSzCdCnsvcPaymentType() + "';");
    out.println("serviceDetailArray[" + i + "][3] = '" + rowObject.getUlNbrCnsvcLineItem() + "';");
    out.println("serviceDetailArray[" + i + "][4] = '" + FormattingHelper.formatDouble( rowObject.getUlNbrCnsvcUnitRate(), 2)  + "';");
    out.println("serviceDetailArray[" + i + "][5] = '" + FormattingHelper.formatMoney(rowObject.getUlNbrCnsvcUnitRate()) + "';");
  }
%>

function setPageState()
{
  for (j=0; j<serviceDetailArray.length; j++)
  {
    // Whenever the service dropdown is changed, change the payment type, unit rate, and line
    // item hidden fields to match those in the row where the service is located.
    // If the Payment Type is Variable Unit Rate (VUR) and Unit Type is One - Time, set Suggested Units to 1, Units
    // requested to 1.00 (and make it read only).  
    // SIR 19520 don't run the javascript if the dropdown doesn't  have a value.
  if (document.frmServiceDetail.selSzCdSvcAuthDtlSvc.value != "")
  {
    if (serviceDetailArray[j][0] == document.frmServiceDetail.selSzCdSvcAuthDtlSvc.value)
    {
      document.frmServiceDetail.hdnUlNbrSvcAuthDtlLineItm.value = serviceDetailArray[j][3];
      document.frmServiceDetail.hdnLNbrSvcAuthDtlUnitRate.value = serviceDetailArray[j][4];
      document.frmServiceDetail.hdnSzCdCnsvcPaymentType.value = serviceDetailArray[j][2];
      if (serviceDetailArray[j][2] == "VUR")
      {
       document.frmServiceDetail.ulNbrCnsvcUnitRate.disabled = false;
       if(serviceDetailArray[j][1] == "ONE"){
        //Also set the values in to the display fields, as well as coordinating hidden fields
        //so that the values will be available upon save.
        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.value = "1.00";
        document.frmServiceDetail.hdnLNbrSvcAuthDtlUnitReq.value = "1.00";
        var unit = "1";
        document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = unit;
        changeSpanUnit(unit);
        // Only change the value of the Amount Requested and the hidden value for
        // amount requested if the page is not coming back from validation (page does
        // not have an error)
        // SIR 18387 -- Check the value of the hdn Error field instead of just the field
        // itself, this will allow the logic to fall into this if statement and
        // display Amount correctly. Also only replace the value if there is not currently
        // a value in the field
        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.disabled = true;
        }else{
        calculateSuggUnits()
        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.disabled = false;
        }
        var unitRate = eval("document.getElementById(\"ulNbrCnsvcUnitRate_Id\")");
        var unitReq = eval("document.getElementById(\"txtLNbrSvcAuthDtlUnitReq_Id\")");
        var cdSvcAuthDtlSvc = document.frmServiceDetail.selSzCdSvcAuthDtlSvc.value;
        if(cdSvcAuthDtlSvc == "51033a" || cdSvcAuthDtlSvc == "51033b" || cdSvcAuthDtlSvc == "51033c" || cdSvcAuthDtlSvc == "51217" || cdSvcAuthDtlSvc == "51257a"
         || cdSvcAuthDtlSvc == "51257b" || cdSvcAuthDtlSvc == "51258a" || cdSvcAuthDtlSvc == "51258b" || cdSvcAuthDtlSvc == "51258c" || cdSvcAuthDtlSvc == "51258d"
         || cdSvcAuthDtlSvc == "51260" || cdSvcAuthDtlSvc == "51277a" ||cdSvcAuthDtlSvc == "51277b"){
	        if(isNaN(amtReqOriginal)){
	         var amtReq = unitRate.value * unitReq.value;
	        }else {
	           if(unitRate.value == 0.00){
	              var amtReq = amtReqOriginal;
	           }else {
	               var amtReq = unitRate.value * unitReq.value;
	           }
	        }
        } else {
        	var amtReq = unitRate.value * unitReq.value;
        }
        
        if (isNaN(amtReq))
        {
          amtReq = 0.00;
        }
        var amtReqString = formatAsMoney(amtReq);
        amtReqString = "$ " + amtReqString;
        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.value = amtReqString;
        document.frmServiceDetail.hdnLAmtSvcAuthDtlAmtReq.value = amtReqString;
        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.disabled = true;
        
      }
      // Else the Service is Not "VUR", set Amount Requested to Unit Requested times Unit Rate
      // If Frequency is 0, set Units Suggested to 0, otherwise do calculation for sugg
      // units if the correct fields are available for calculation, otherwose set Units suggested to 0
      else
      {
        document.frmServiceDetail.ulNbrCnsvcUnitRate.value = serviceDetailArray[j][4];
        document.frmServiceDetail.ulNbrCnsvcUnitRate.disabled = true;
        var amountReq = document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.value * serviceDetailArray[j][4];
        // SIR 19517 if Amount req is NaN, display 0.00
        if (isNaN(amountReq))
        {
          amountReq = 0.00;
        }
        // SIR 19611 round the amount calculated to 2 decimal places.
        var amountReqString = formatAsMoney(amountReq);
        amountReqString = "$ " + amountReqString;
        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.value = amountReqString;
        //Also set the value in to corresponding hidden fields, so that if the field is
        //not available from the request, it will be from the hidden field
        document.frmServiceDetail.hdnLAmtSvcAuthDtlAmtReq.value = amountReqString;
        document.frmServiceDetail.txtLNbrSvcAuthDtlUnitReq.disabled = false;
        document.frmServiceDetail.txtLAmtSvcAuthDtlAmtReq.disabled = true;
        calculateSuggUnits();
      }

  // Select the Unit Type that is returned from the same row for the service that was selected
  for(i=0; i<unitTypeCodes.length; i++)
  {
    subString =  unitTypeCodes[i].substring(0,unitTypeCodes[i].indexOf("|"));
    secondSubString = unitTypeCodes[i].substring(unitTypeCodes[i].indexOf("|")+1,unitTypeCodes[i].length);
    if (subString == serviceDetailArray[j][1])
    {
    var unitTypeDisplay= secondSubString;
    document.frmServiceDetail.hdnSzCdSvcAuthDtlUnitType.value = subString;
    //document.frmServiceDetail.dspUnitType.value = subString;
    changeSpanType(unitTypeDisplay);
    break;
    }
  }
 }// end if this is the service selected
}// end if the dropdown is not blank
}// end for
}// end set page state

  function calculateSuggUnits()
  {
   //If Frequency is 0 set suggested units to 0
        if (document.frmServiceDetail.txtUNbrSvcAuthDtlFreq.value == 0)
        {
          var unit = "0";
          document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = unit;
          changeSpanUnit(unit);
        }
        // if Period is not "", Begin date is not "" and End date is not ""
        // do complicated calculation to get the units suggested
        else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value != "" &&
                 document.frmServiceDetail.txtDtDtSvcAuthDtlBegin.value != "" &&
                 document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value != "")
        {
          // First get the value of the period
          var period = getPeriod();
          // Now get the value of the difference of days
          var days = getDays();
          if (days == 0)
          {
            days = 1;
          }
          // Calculate Suggested units
          var suggUnit = (days * document.frmServiceDetail.txtUNbrSvcAuthDtlFreq.value)/period;
          var roundSugg = Math.ceil(suggUnit);
          // SIR 19517 if suggested units is NaN, display 0.00
          if (isNaN(roundSugg))
          {
           roundSugg = 0;
          }
          document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = roundSugg;
          changeSpanUnit(roundSugg);
        }
        // Suggested Units will still be 0 since all of the fields have not been filled out
        else
        {
          var unit = "0";
          document.frmServiceDetail.hdnLNbrSvcAuthDtlSugUnit.value = unit;
          changeSpanUnit(unit);
        }
  }
  function viewModeUnit()
  {
   // Display the decode for the Unit type that was returned for the service
   for(i=0; i<unitTypeCodes.length; i++)
   {
    subString =  unitTypeCodes[i].substring(0,unitTypeCodes[i].indexOf("|"));
    secondSubString = unitTypeCodes[i].substring(unitTypeCodes[i].indexOf("|")+1,unitTypeCodes[i].length);
    if (subString == "<%=rowccon22sog01.getSzCdSvcAuthDtlUnitType()%>")
    {
     var unitTypeDisplay= secondSubString;
     document.frmServiceDetail.hdnSzCdSvcAuthDtlUnitType.value = subString;
     changeSpanType(unitTypeDisplay);
     break;
    }
   }
 }
function getPeriod()
{
  var period = 0;
  if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == "DAY")
  {
    period = 1;
  }
  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == "CWK")
  {
    period = 7;
  }
  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == "MBI")
  {
    period = 15;
  }
  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == "MMO")
  {
    period = 30;
  }
  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == "MSI")
  {
    period = 180;
  }
  else if (document.frmServiceDetail.selSzCdSvcAuthDtlPeriod.value == "MTH")
  {
    period = 90;
  }
  else
  {
    period = 365;
  }
  return period;
}

function formatAsMoney(mnt) {
    mnt -= 0;
    mnt = (Math.round(mnt*100))/100;
    return (mnt == Math.floor(mnt)) ? mnt + '.00': ( (mnt*10 == Math.floor(mnt*10)) ? mnt + '0' : mnt);
 }

//mxpatel added this function for defect #STGAP00013508 to retrieve "Authorization Type" when page loads
window.onload = function()
{
  document.frmServiceDetail.hdnSzCdSvcAuthDtlAuthType.value = "<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType())%>";
}

function getDays()
{

  date1AsString = validateDateString( document.frmServiceDetail.txtDtDtSvcAuthDtlBegin.value ) ;
  date2AsString = validateDateString( document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value ) ;

  // turn the date string into a Date object
  date1 = new Date( Date.parse( date1AsString ) );
  date2 = new Date( Date.parse( date2AsString ) );

  var days = diffDates( date1, date2 );
  // The difference of days in this calculation does not
  // include the start day as a whole day and it should for suggested units
  var days = days + 1;
  return days;
}

// finds the number of days between 2 dates. The value will be
// positive if date1 is after date2
// negative if date2 is after date1
function diffDates(date2, date1)
{
  var ms = date1.getTime() - date2.getTime();
  var sec = ms / 1000;
  var min = sec / 60;
  var hours = min / 60;
  var days = hours / 24;
  return days;
}

// Sir 23580 this function will be called onClick of the save botton
// if Auth Type is Update or Terminate to remind user to send a revised service
// authorization form to the provider to prevent future payment issues.
function isEarlyTerminate()
{
  if ((document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value == "TRM") ||
      (document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value == "UPD"))
  {
    alert( "<%=MessageLookup.getMessageByNumber(Messages.MSG_FIN_SVC_EARLY_TERM)%>" );
  }
}

function isTerminate()
{
  if (document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value == "TRM")
  {
    enableDateField (frmServiceDetail, frmServiceDetail.txtDtDtSvcAuthDtlTerm);
  }
  else
  {
    //SIR 15664 if the value isn't  TRM, then set the Term Date to the end date.
    var end = document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value;
    document.frmServiceDetail.txtDtDtSvcAuthDtlTerm.value = end;
    disableDateField (frmServiceDetail, frmServiceDetail.txtDtDtSvcAuthDtlTerm);
  }
}


function changeSpanType(unitTypeDisplay)
 {
   var sp = document.getElementById("dspUnitType_id");
   sp.innerText = unitTypeDisplay;
 }

 function changeSpanUnit(unitSuggDisplay)
  {
    var sp = document.getElementById("dspLNbrSvcAuthDtlSugUnit_id");
    sp.innerText = unitSuggDisplay;
 }


function cancelValidation ()
{
    disableValidation('frmServiceDetail');
}

function updateAuthType(index)
{
  var fieldId = "rbIndServAcpt" +"_Id" + index;
  var rBtnField = eval("document.getElementById(\"" + fieldId + "\")");
  var checked = rBtnField.checked;
  var empty = "";
  if(checked)
  {
    if(index == 1)
    {
     document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value = "";
     var endDate = document.frmServiceDetail.txtDtDtSvcAuthDtlEnd.value;
     document.frmServiceDetail.txtDtDtSvcAuthDtlTerm.value = endDate;
      
    }else if(index == 2){
      document.frmServiceDetail.selSzCdSvcAuthDtlAuthType.value = "TRM";
        <%  //Per STGAP00010534 Added following line. 
        %>
      enableDateField (frmServiceDetail, frmServiceDetail.txtDtDtSvcAuthDtlTerm);
      var date = document.frmServiceDetail.txtDtDtSvcAuthDtlBegin.value;
      document.frmServiceDetail.txtDtDtSvcAuthDtlTerm.value = date;
    }
    
  }
}

//  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
     {
      IsDirty();
     }
</script>
<%
  //End Javascript Section
%>

<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;
%>



<impact:validateErrors />
<impact:validateForm name="frmServiceDetail" method="post" action="/financials/ServiceAuth/saveServiceAuthDetail" pageMode="<%=pageModePassed%>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthDetailCustomValidation"
	onSubmit="isEarlyTerminate()" schema="/WEB-INF/Constraints.xsd">
	<%
	  /* Begin Detail */
	%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th colspan="6">
				Service Authorization Information
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="Service Description" name="selSzCdSvcAuthDtlSvc" onChange="setPageState()" required="true" disabled="<%=Sets.isInSetStr(Sets.A, request)%>" value="<%=FormattingHelper.formatString(szCdSvcAuthDtlSvc)%>"
					contentType="<%=SelectTag.DECODES%>" editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>" excludeOptions="<%=excludeViews%>" tabIndex="<%=tabIndex++%>" codesTable="CSVCCODE" />
			</td>
			<%
			  // If the Service Auth has not been marked complete,
			    // attach a codes table with only One-Time and Initial in it
			    if (!EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {
			%>
			<td>
				<impact:validateSelect label="Authorization Type" name="selSzCdSvcAuthDtlAuthType" required="true" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType())%>" editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>"
					tabIndex="<%=tabIndex++%>" codesTable="CSVATYP1" />
			</td>
			<%
			  }
			    //Else, if the type is INI or ONT, attach the full codes table,
			    //but exclude the option that cannot be selected
			    else if (rowccon22sog01 != null
			             && (CodesTables.CSVATYPE_INI.equals(rowccon22sog01.getSzCdSvcAuthDtlAuthType()) || CodesTables.CSVATYPE_ONT
			                                                                                                                        .equals(rowccon22sog01
			                                                                                                                                              .getSzCdSvcAuthDtlAuthType()))) {

			      List excludedOptions = new ArrayList();
			      // When attaching the codes table, we want to hide the Option that they cannot select.
			      // I.E. if the Auth Type is Initial, only display Initial, Terminate and Update,
			      // if the Auth Type is One-Time, only display One-Time, Terminate, and Update
			      if (CodesTables.CSVATYPE_INI.equals(rowccon22sog01.getSzCdSvcAuthDtlAuthType())) {
			        excludedOptions.add(CodesTables.CSVATYPE_ONT);
			      } else {
			        excludedOptions.add(CodesTables.CSVATYPE_INI);
			      }
			%>
         
			<td>
				<impact:validateSelect label="Authorization Type" onChange="isTerminate()" name="selSzCdSvcAuthDtlAuthType" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType())%>" excludeOptions="<%=excludedOptions%>" required="true"
					editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>" tabIndex="<%=tabIndex++%>" codesTable="CSVATYPE" />
			</td>
			<%
			  }
			    //Else, attach the codes table with only Update and
			    //Terminate in it since those are the only valid options
			    else {
			%>
			<td>
				<impact:validateSelect label="Authorization Type" onChange="isTerminate()" name="selSzCdSvcAuthDtlAuthType" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType())%>" tabIndex="<%=tabIndex++%>" required="true"
					editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>" codesTable="CSVATYP2" />
			</td>
			<%
			  }
			%>
		<tr>
			<td>
				<impact:validateDate label="Begin" onBlur="setPageState()" name="txtDtDtSvcAuthDtlBegin" constraint="Date" required="true" disabled="<%=Sets.isInSetStr(Sets.A, request)%>" value="<%=FormattingHelper.formatDate(dtDtSvcAuthDtlBegin)%>"
					editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspUnitType" label="Unit Type" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlUnitType())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="txtDtDtSvcAuthDtlEnd" onBlur="setPageState()" label="End" constraint="Date" required="true" disabled="<%=Sets.isInSetStr(Sets.A, request)%>" editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>"
					value="<%=FormattingHelper.formatDate(dtDtSvcAuthDtlEnd)%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td>
				<impact:validateSelect label="Period" name="selSzCdSvcAuthDtlPeriod" required="true" onChange="setPageState()" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlPeriod())%>" editableMode="<%=fieldEditableMode%>"
					tabIndex="<%=tabIndex++%>" codesTable="CNPERIOD" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDate name="txtDtDtSvcAuthDtlTerm" label="Terminate" conditionallyRequired="true" constraint="Date" tabIndex="<%=tabIndex++%>" value="<%=FormattingHelper.formatDate(rowccon22sog01.getDtDtSvcAuthDtlTerm())%>"
					editableMode="<%=EditableMode.EDIT%>" />
			</td>
			<td>
				<impact:validateInput type="text" name="txtLNbrSvcAuthDtlUnitReq" onBlur="setPageState()" conditionallyRequired="true" label="Requested Units" constraint="DoubleToHundredths" size="7" maxLength="7"
					value="<%=FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitReq(), 2)%>" editableMode="<%=fieldEditableMode%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" required="true" name="txtUNbrSvcAuthDtlFreq" onChange="setPageState()" label="Frequency" size="4" maxLength="4" tabIndex="<%=tabIndex++%>" constraint="Digit4Less"
					value="<%=FormattingHelper.formatInt(rowccon22sog01.getUNbrSvcAuthDtlFreq())%>" editableMode="<%=fieldEditableMode%>" />
			</td>
			<td>
				<impact:validateInput type="text" conditionallyRequired="true" name="txtLAmtSvcAuthDtlAmtReq" label="Amount" constraint="Money" size="13" maxLength="13" tabIndex="<%=tabIndex++%>"
					value="<%=FormattingHelper.formatMoney(rowccon22sog01.getLAmtSvcAuthDtlAmtReq())%>" editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Unit Rate" name="ulNbrCnsvcUnitRate" onBlur="setPageState()" cssClass="formInput" value="<%=FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitRate(), 2)%>" constraint="DoubleToHundredths" conditionallyRequired="true"
					tabIndex="<%=tabIndex++%>" editableMode="<%=fieldEditableMode%>" maxLength="9" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspLNbrSvcAuthDtlSugUnit" label="Units Suggested" value="<%=FormattingHelper.formatInt(rowccon22sog01.getLNbrSvcAuthDtlSugUnit())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspLNbrSvcAuthDtlUnitUsed" label="Units Used" value="<%=FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitUsed(), 2)%>" />
			</td>
		</tr>
		<tr>
			<td colspan="4">

				<table class="tableBorder" width="100%" cellspacing="0" celpadding="3">
					<tr>
						<td class="tableBG">
							<table width="100%" cellspacing="0" cellpadding="3">
								<tr>
									<th class="thList"></th>
									<th class="thList">
										<span class="formRequiredText">*</span>Person(s)
									</th>
									<th class="thList">
										Rel/Int
									</th>
								</tr>
								<%
								  if (personArray != null && personArray.getROWCCON22SOG00Count() > 0) {

								      ROWCCON22SOG00 personRow = null;
								      Enumeration personEnumeration = personArray.enumerateROWCCON22SOG00();

								      if (!personEnumeration.hasMoreElements()) {
								%>
								<tr class="odd">
									<td colspan="10">
										<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
									</td>
								</tr>
								<%
								  } else {
								        while (personEnumeration.hasMoreElements()) {
								          personRow = (ROWCCON22SOG00) personEnumeration.nextElement();
								%>
								<tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
									<%
									  String checkId = "cbx_" + loopCount;
									%>
									<td>
										<impact:validateInput type="checkbox" value="<%=String.valueOf(loopCount)%>" editableMode="<%=EditableMode.NEW%>" name="<%=checkId%>" tabIndex="<%=tabIndex++%>" />
									</td>
									<td>
										<%=FormattingHelper.formatString(personRow.getSzNmPersonFull())%>
									</td>
									<td>
										<%=FormattingHelper.formatString(personRow.getSzCdStagePersRelInt())%>
									</td>
								</tr>
								<%
								  loopCount++;
								        } // end while
								      } // end else (Person Array has Elements)
								    } // end if Person Array's Count is > 0
								    else {
								%>
								<tr class="<%=FormattingHelper.getRowCss(1)%>" valign="top">
									<%
									  String checkId = "cbx_" + loopCount;
									%>
									<td>
										<impact:validateInput type="checkbox" checked="true" value="<%=String.valueOf(loopCount)%>" editableMode="<%=EditableMode.NEW%>" name="<%=checkId%>" tabIndex="<%=tabIndex++%>" />
									</td>
									<td>
										<%=FormattingHelper.formatString(rowccon22sog01.getSzNmPersonFull())%>
									</td>
									<td></td>
								</tr>
								<%
								  }
								%>
							</table>
						</td>
					</tr>
				</table>
						
			<table>				
				<tr>
					<td>
						<!-- STGAP00017831: Renamed the field label as below and increased the field size to 1000 characters -->
						<span> Reason for Referral/Other Comments (If applicable, please include a brief summary of the case including risk indicators, service needs, and other pertinent information.) </span>  						
                    </td>
				</tr>
				
				<tr>
					<td>
						<impact:validateTextArea name="szTxtCommentsAdditional" cols="112" rows="3" maxLength="1000" constraint="Paragraph1000" editableMode="<%=fieldEditableMode%>" tabIndex="<%=tabIndex++%>">
						<%=FormattingHelper.formatString(rowccon22sog01.getSzTxtCommentsAdditional())%>
						</impact:validateTextArea>
					</td>
				</tr>
			</table>
				
				
				
				
				
		<tr>
			<td colspan="4">
				<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<tr>
						<th colspan="6">
							Referral and Quality of Service
						</th>
					</tr>
					<tr>
						<td>
							Service Provider Accepted: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%
							  int index1 = 1;
							    String reset1 = "updateAuthType('" + index1 + "');";
							%>
							<impact:validateInput type="radio" label="Yes" id="servAcpt_Yes" name="rbIndServAcpt" value="Y" checked="<%=servAcpt_Yes%>" cssClass="formInput" editableMode="<%=editableMode%>" tabIndex="<%=tabIndex++%>" />
							<%
							  int index2 = 2;
							    String reset2 = "updateAuthType('" + index2 + "');";
							%>
							<impact:validateInput type="radio" label="No" id="servAcpt_No" name="rbIndServAcpt" value="N" onChange="<%=reset2%>" checked="<%=servAcpt_No%>" cssClass="formInput" editableMode="<%=editableMode%>" tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>

					<tr>
						<td>
							Service Required in Case Plan: &nbsp;&nbsp;
							<impact:validateInput type="radio" label="Yes" id="casePlanSvc_Yes" name="rbIndCasePlnSvc" editableMode="<%=editableMode%>" value="Y" checked="<%=casePlanSvc_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
							<impact:validateInput type="radio" label="No" id="casePlanSvc_No" name="rbIndCasePlnSvc" editableMode="<%=editableMode%>" value="N" checked="<%=casePlanSvc_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
						</td>
					</tr>

					<tr>
						<td>
							Quality of Service:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
							<impact:validateSelect tabIndex="<%=tabIndex++%>" style="WIDTH: 75px" editableMode="<%=editableMode%>" name="szCdSvcQlty" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcQlty())%>" codesTable="CSVCQLTY" />
						</td>
					</tr>
					<tr>
						<td>
							<span class="formCondRequiredText">&#8225;</span>Comments:
							<br>
							As applicable, document why the service provider rejected the service, why the service was terminated, or the overall quality and outcome of the service.
						</td>
					</tr>
					<tr>
						<td>
							<!-- STGAP00017831: Increased the field size to 1000 characters -->
							<impact:validateTextArea name="szTxtRefQltyCmnts" cols="112" rows="3" maxLength="1000" constraint="Paragraph1000" editableMode="<%=editableMode%>" tabIndex="<%=tabIndex++%>">
								<%=FormattingHelper.formatString(rowccon22sog01.getSzTxtRefQltyCmnts())%>
							</impact:validateTextArea>
						</td>
					</tr>

				</table>
			</td>
		</tr>
	</table>

	<table width="100%" cellpadding="3" cellspacing="0">
		<tr>

			<td>
				<impact:ButtonTag name="btnSave" img="btnSave" align="right" form="frmServiceDetail" action="/financials/ServiceAuth/saveServiceAuthDetail"
				 restrictRepost="true"  editableMode="<%=EditableMode.NEW + EditableMode.EDIT%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>




	<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>
	<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%=DateHelper.toISOString(rowccon22sog01.getTsLastUpdate())%>" />
	<impact:validateInput type="hidden" name="hdnUlIdSvcAuth" value="<%=FormattingHelper.formatInt(rowccon22sog01.getUlIdSvcAuthDtl())%>" />
	<impact:validateInput type="hidden" name="hdnSzCdSvcAuthDtlUnitType" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlUnitType())%>" />
	<impact:validateInput type="hidden" name="hdnSzCdCnsvcPaymentType" value="" />
	<impact:validateInput type="hidden" name="hdnLNbrSvcAuthDtlSugUnit" value="<%=FormattingHelper.formatInt(rowccon22sog01.getLNbrSvcAuthDtlSugUnit())%>" />
	<impact:validateInput type="hidden" name="hdnUlNbrSvcAuthDtlLineItm" value="<%=FormattingHelper.formatInt(rowccon22sog01.getUlNbrSvcAuthDtlLineItm())%>" />
	<impact:validateInput type="hidden" name="hdnLNbrSvcAuthDtlUnitRate" value="<%=FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitRate())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtSvcAuthDtl" value="<%=FormattingHelper.formatDate(rowccon22sog01.getDtDtSvcAuthDtl())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtStageStart" value="<%=FormattingHelper.formatDate(ccon22so.getDtDtStageStart())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtStageClose" value="<%=FormattingHelper.formatDate(ccon22so.getDtDtStageClose())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtSvcAuthEff" value="<%=FormattingHelper.formatDate(ccon18so.getDtDtSvcAuthEff())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtSituationOpened" value="<%=FormattingHelper.formatDate(ccon22so.getDtDtSituationOpened())%>" />
	<impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%=cReqFuncCd%>" />
	<impact:validateInput type="hidden" name="ulIdSvcAuthDtl" value="" />
	<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%=FormattingHelper.formatInt(rowccon22sog01.getUlIdPerson())%>" />
	<impact:validateInput type="hidden" name="hdnPrimaryClient" value="<%=FormattingHelper.formatInt(primaryClient)%>" />
	<%-- mxpatel added this for defect #STGAP00013508 hdnSzCdSvcAuthDtlAuthType hidden attribut to retrieve "Authorization Type" when page loads--%>
	<impact:validateInput type="hidden" name="hdnSzCdSvcAuthDtlAuthType" value="<%=FormattingHelper.formatString(rowccon22sog01.getSzCdSvcAuthDtlAuthType())%>" />
	<%-- SIR 23662 --%>
	<impact:validateInput type="hidden" name="hdnDtDtCnperStart" value="<%=FormattingHelper.formatDate(ccon18so.getDtDtCnperStart())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtCnperClosure" value="<%=FormattingHelper.formatDate(ccon18so.getDtDtCnperClosure())%>" />
	<impact:validateInput type="hidden" name="hdnCIndCnperRenewal" value="<%=FormattingHelper.formatString(ccon18so.getCIndCnperRenewal())%>" />
	<impact:validateInput type="hidden" name="hdnLNbrSvcAuthDtlUnitReq" value="<%=FormattingHelper.formatDouble(rowccon22sog01.getLNbrSvcAuthDtlUnitReq(), 2)%>" />
	<impact:validateInput type="hidden" name="hdnLAmtSvcAuthDtlAmtReq" value="<%=FormattingHelper.formatMoney(rowccon22sog01.getLAmtSvcAuthDtlAmtReq())%>" />
	<impact:validateInput type="hidden" name="hdnPageModePassed" value="<%=FormattingHelper.formatString(pageModePassed)%>" />
	<impact:validateInput type="hidden" name="hdnIndError" value="N" />
	<impact:validateInput type="hidden" name="hdnDtDtSvcAuthDtlTerm" value="<%=FormattingHelper.formatDate(rowccon22sog01.getDtDtSvcAuthDtlTerm())%>" />
	<impact:validateInput type="hidden" name="hdnFlag" value="<%=hdnFlag%>" />
	
	<%
		  /*  Always include this hidden field in your form */
		%>
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
<%
  /* Close Validate Form Custom Tag */
%>

<script type="text/javascript" language="JavaScript1.2">
<% // Only call all javascript if the page is not view mode
if (!PageModeConstants.VIEW.equals(pageModePassed))
{
  if ( FormValidation.pageHasErrorMessages( request ) ||
       FormValidation.pageHasValidationMessages( "frmServiceDetail", request ))
  {
  %>
  // If the page has errors, set a hidden field so that Amount will not
  // be re-set in the VUR section of the javascript
  frmServiceDetail.hdnIndError.value = "Y";
  
  <%}// End if the page has errors
  %>
  setPageState();
  CleanSelect( document.frmServiceDetail.selSzCdSvcAuthDtlAuthType );
  <%
   // Only call isTerminate if the page mode is not new
   if (!PageModeConstants.NEW.equals(pageModePassed))
   {
%>
    isTerminate();
   <%}

} // End if page Mode is not View
// call this javascript to display unit type if the page is in view mode
else{%>

  viewModeUnit();

<%}
%>

</script>




