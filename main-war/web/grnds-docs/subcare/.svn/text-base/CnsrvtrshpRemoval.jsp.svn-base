<%
  //*  JSP Name:     Conservatorship Removal JSP
//*  Created by:   Bryon Jacob
//*  Date Created: 1/8/2003
//*
//*  Description:
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  05/05/02  DEMOMA (mad)      Changed lookup table(line 548) from CRELVICT to CRPTRINT
//**                              appears to be error in DataDictionary wrong code table used
//**  10/26/04  gerryc      SIR 23063 - changed the setupPage function so that
//**                              it only calls the selectedNA function if the checkbox
//**                              fields are not already disabled.  Once they are
//**                              disabled, their name changes from cbxCareTakerChars1
//**                              to cbxCareTakerChars1_Disabled, which results in a
//**                              javascript null or not an object error on load of the
//**                              page.
//**  12/04/08  alwilliams        STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseInt
//** 							  The calendar date picker does not put a leading zero on single digit
//** 							  months. However the user is allowed to enter single digits months with a leading
//** 							  zero. parseInt processes number with leading zero as an octal number;
//**  05/26/2010  hjbaptiste      SMS#51977-MR66-Maltreatment In Care: Added function to have the user confirm that the removal
//**                              date is prior any of the child's allegation incident date
//**  12/03/2010  hnguyen         SMS#81144: MR53 Added confirmation message if removal year is not the same as current date year.
//**  12/03/2010  htvo            SMS#81140 MR-074 AFCARS 1: 
//**                              1. remap the removal reasons, make caretaker and child characteristics removal reasons
//**                                 child characteristics display only 
//**                              2. replace castorCheckbox with manual iteration so can customize individual checkbox, 
//**                              3. auto-select reason relinquish and disable it when removal type is voluntary surrender; 
//**                                 caretaker's inability when removal type is voluntary placement. 
//**                              4. enable help text to Neglect, Relinquishment, and Caretaker's Inability
//**  12/16/2010 hanguyen         SMS#87256: Corrected logic to not validate removal year if field is already disabled after 45 days.
//**  12/27/2010 hanguyen         SMS#87949: Corrected javascript to check removal year only if date is entered and valid.
//**  12/27/2010 htvo             SMS#87941: Used hidden field to tell whether at least a removal reason is selected (b/c it can be disabled thus the name is changed)            
//**  01/20/2011 schoi            SMS #92680: MR-074 Sort Child Characteristics section to display alphabetically 
//**                              by decode value using CodeAttributesComparator  
//**  09/20/2011 schoi            STGAP00017013: MR-095 Added new section Foster Care Principal List for FCC Stage
//**  10/02/2011 schoi            STGAP00017013: MR-095 Added additional logic for new section Foster Care Principal List for FCC Stage 
//**  10/08/2011 schoi            STGAP00017013: MR-095 Added validation for any update and pre-population logic
//**                              for the Caregiver/Parental Relationship for Child section on the Person Detail page
//**  10/10/2011 schoi            STGAP00017013: MR-095 Corrected the new section name to Foster Care Principal List for FCC Stage
//**  10/11/2011 schoi            STGAP00017169: MR-095 Updated the condition to display Foster Care Principal List for FCC Stage section
//**                              for copying existing Custody event in addition to adding new Custody event 
//**  11/01/2011 schoi            STGAP00017499: MR-095 Added onClick="hrefDirtyBypass=true to bypass unnecessary pop-up window
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.CnsrvtrshpRemovalConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.CodeAttributesComparator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="org.exolab.castor.types.Date" %>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);

  String pageMode = PageMode.getPageMode(request);
//  boolean modifyMode = PageMode.MODIFY.equals(pageMode);
  boolean birthDateNull = false;
  boolean ageMonsNull = false;
  boolean ageYrsNull = false;
  boolean bEventStatusComp = false;
  boolean bEventStatusAprv = false;
  String strAgeMons = "";
  String strAgeYrs = "";
  String removalType_DP;
  String removalType_VO;
  String removalType_VP;
  String removalType_ST;
  String commentsFactualDesc = "";
  // STGAP00017013: MR-095
  String szCdStagePersRelInt = StringHelper.EMPTY_STRING;
  
  int tabIndex = 1;

  Date todayDate = DateHelper.getTodayCastorDate();
  UserProfile user = UserProfileHelper.getUserProfile(request);

  String warnRemovalPriorAllegIncident = (String) state.getAttribute("warnRemovalPriorAllegIncident", request);
  CSUB14SO csub14so = (CSUB14SO) state.getAttribute("csub14so", request);
  CSUB48SO csub48so = (CSUB48SO) state.getAttribute("csub48so", request);
  // STGAP00017013: MR-095
  CSUB80SO csub80so = (CSUB80SO) state.getAttribute("csub80so", request); 
  
  //The birthday is not returned in csub14 when the Removal is existing
  Date birthDate = csub14so.getDtDtPersonBirth();
  // MR-074
  ROWCSUB14SOG00 rowcsub14sog00 = csub14so.getROWCSUB14SOG00();
  String personCharNA = rowcsub14sog00.getCIndRemovalNaChild();
  HashMap<String, String> removalReasonNameMap = new HashMap<String, String>();

  // STGAP00017013: MR-095
  // Filter Relationship dropdown to exclude Primary Caretaker, Self and Self/Minor Parent
  List excludeRel = new ArrayList();
  excludeRel.add(CodesTables.CRELVICT_PK);
  excludeRel.add(CodesTables.CRELVICT_SL);
  excludeRel.add(CodesTables.CRELVICT_SM);

  //Can not change anything if event has been approved
  if ("APRV".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus())) {
    bEventStatusAprv = true;
  }
  if (birthDate == null) {
    birthDateNull = true;
  }
  if (Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo()) == null
      && Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo()) == null) {
    ageYrsNull = true;
    ageMonsNull = true;
  } else {
    strAgeYrs = Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeYr());
    strAgeMons = Integer.toString(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo());
  }

  String strRemovalDate = ContextHelper.getStringSafe(request, "dtDtRemoval");
  Date dtDtPersonRemoval = csub14so.getROWCSUB14SOG00().getDtDtRemoval();
  if ("".equals(strRemovalDate)) {
    if (dtDtPersonRemoval != null) {
      strRemovalDate = FormattingHelper.formatDate(dtDtPersonRemoval);
    }
  }

  // Can not change removal date if already saved "Comp" status
  if ("COMP".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus())) {
    bEventStatusComp = true;
  }
  // SPB - SIR 22484
  // If stage removal was recorded in is open and less than 45 days have passed
  // since the removal was recorded make date field editable.
  CaseUtility.Stage thisStage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
  String strIndClosed = thisStage.getIndStageClose();
  if ("N".equals(strIndClosed)) {
    Date currentDate = DateHelper.getTodayCastorDate();
    Date compDate = DateHelper.addToDate(currentDate, 0, 0, -46);

    if ((DateHelper.isNull(dtDtPersonRemoval) == false) &&
        (DateHelper.isBefore(compDate, dtDtPersonRemoval))) {
      bEventStatusComp = false;
    }
  }

  String labelRemovalAgeYears = ContextHelper.getStringSafe(request, "labelRemovalAgeYears");
  if ("".equals(labelRemovalAgeYears)) {
    labelRemovalAgeYears = String.valueOf(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeYr());
    if (labelRemovalAgeYears == null || "0".equals(labelRemovalAgeYears)) {
      labelRemovalAgeYears = " ";
    }
  }

  String labelRemovalAgeMonths = ContextHelper.getStringSafe(request, "labelRemovalAgeMonths");
  if ("".equals(labelRemovalAgeMonths)) {
    labelRemovalAgeMonths = String.valueOf(csub14so.getROWCSUB14SOG00().getLNbrRemovalAgeMo());
    if (labelRemovalAgeMonths == null || "0".equals(labelRemovalAgeMonths)) {
      labelRemovalAgeMonths = " ";
    }
  }
  // SMS#81140 MR-074: replaced castor tag with manual iterator so don't need this collection
  // And add child-related removal reasons
  //Collection<CodeAttributes> removalReasons = Lookup.getCategoryCollection(CodesTables.CREMFRHR);
  List checkedRemovalReasons = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_REMOVAL_REASONS);
  // SMS#81140 MR-074: add child-related removal reasons
  Collection<CodeAttributes> removalReasonsChild = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CCREMRSN);
  //List checkedRemovalReasonsChild = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_REMOVAL_REASONS_CHILD);

  List checkedChildChars = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_CHILD_CHARS);
  List<CodeAttributes> childCharList = new ArrayList<CodeAttributes>();
  // SMS#81140 MR-074: only add N/A when it was selected in Person Characteristics page
  if (ArchitectureConstants.Y.equals(personCharNA)) {
    childCharList.add(new CodeAttributes(null, "NA", "N/A"));
  }

  if (csub14so.getROWCSUB14SOG02_ARRAY() != null) {
    Enumeration en = csub14so.getROWCSUB14SOG02_ARRAY().enumerateROWCSUB14SOG02();
    while (en.hasMoreElements()) {
      ROWCSUB14SOG02 row = (ROWCSUB14SOG02) en.nextElement();
      String childChar = row.getSzCdRemovChildChar();
      //int i = 0;
      //while (i < childChar.length() && childChar.charAt(i) != '0') {
        
      //String childChars = childChar.substring(i);
      try {
        childCharList.add(Lookup.decode(CodesTables.CPM, childChar));
      } catch (LookupException lookupException1) {
        try {
          childCharList.add(Lookup.decode(CodesTables.CHB, childChar));
        } catch (LookupException lookupException2) {
          try {
            childCharList.add(Lookup.decode(CodesTables.CME, childChar));
          } catch (LookupException lookupException3) {
            try {
              childCharList.add(Lookup.decode(CodesTables.OTH, childChar));
            } catch (LookupException lookupException4) {
              childCharList.add(Lookup.expiredDecode(CodesTables.CPM, row.getSzCdRemovChildChar()));
              }
            }
          }
          }
        //i++;
      //}
    }
  }
  // SMS#81140 MR-074: removed, caretaker factors are now part of removal reasons
  //List checkedCareTakerChars = (List) request.getAttribute(CnsrvtrshpRemovalConversation.CHECKED_CARE_TAKER_CHARS);
  Collection<CodeAttributes> careTakerChars = Lookup.getCategoryCollection(CodesTables.CREMCHCT);
  List<CodeAttributes> careTakerCharList = new ArrayList<CodeAttributes>(careTakerChars);
  //careTakerCharList.add(0, new CodeAttributes(null, "NA", "N/A"));

  int ulIdEvent = csub14so.getROWCSUB14SOG04().getUlIdEvent();

  boolean onReload = "true".equals(request.getParameter("hdnReloadingCnsrvtrshpRemoval"));

  // FIXME: Never used.
  String rbRemovalType;
  if (csub14so.getROWCSUB14SOG00().getRbRemovalType() != null) {
    rbRemovalType = csub14so.getROWCSUB14SOG00().getRbRemovalType();
  }

  String parentNotified = FormattingHelper.formatString(csub14so.getROWCSUB14SOG00().getCbParentNotified());

  if (csub14so.getROWCSUB14SOG00().getTxtFactualDesc() != null) {
    commentsFactualDesc = csub14so.getROWCSUB14SOG00().getTxtFactualDesc();
  }
%>


<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

var isPersonsAtHomeChanged = true;

//called to make sure the persons at home have been completed, if the section PersonAt Home
// has been touched do not ask user
function CheckPersonsAtHome()
{
  // SIR#19196. if there are no  principals displayed in the Persons Living in Home at Removal
  // section, show the error message
  var x = document.frmCnsrvtrshpRemoval;
  var txtPersonsDoneMessage = "<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_PHR_REMINDER)%>";
  var cbxPersonAtHomeChecked = false;
  x.hdnCbxPersonsAtHome.value = "N";
  for (var i = 0; i < x.elements.length; i++)
  {
    sElementName = new String(x.elements[i].name);
    if (x.elements[i].type == "checkbox" && sElementName.substring(0, 16) == "cbxPersonsAtHome")
    {
      if (x.elements[i].checked)
      {
        x.hdnCbxPersonsAtHome.value = "Y";
        break;
      }
    }
  }
  
  // MR-074 AFCARS: Set hidden value for removal reason b/c they can be disabled depend on removal type
  // Y: at least one removal reason has been checked
  x.hdnCbxReason.value = "N";
  for (var i = 0; i < x.elements.length; i++)
  {
    sElementName = new String(x.elements[i].name);
    if (x.elements[i].type == "checkbox" && sElementName.substring(0, 17) == "cbxRemovalReasons")
    {
      if (x.elements[i].checked)
      {
        x.hdnCbxReason.value = "Y";
        break;
      }
    }
  }
  
  return true;
}

function setRemovalConfirmed()
{
  document.frmCnsrvtrshpRemoval.hdnRemovalConfirmed.value = 'N';
}

function updatePersonsAtHome()
{
  isPersonsAtHomeChanged = false;
}
//called to clear removal are information
function clearAge(removalYears, removalMonths)
{
  removalYears.innerText = "";
  removalMonths.innerText = "";
  frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = "";
  frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = "";
}

// called whenever Save button is clicked
function confirmRemovalDate()
{
      var iTodayYear = <%= (100 * todayDate.getCentury()) + todayDate.getYear()%>;

      var sRemovalDate = validateDateString(frmCnsrvtrshpRemoval.dtDtRemoval.value);

      var valid = validateDate(sRemovalDate);

      if (valid)
      {
        frmCnsrvtrshpRemoval.dtDtRemoval.value = sRemovalDate;
     
        var pos = sRemovalDate.search('/');
        
        sRemovalDate = sRemovalDate.substring(pos + 1, sRemovalDate.length);
        pos = sRemovalDate.search('/');
        
        // Specify the decimal number system (radix parameter = 10) when using parseIn
        var iRYear = parseInt(sRemovalDate.substring(pos + 1, sRemovalDate.length),10);

        if( iTodayYear != iRYear && '<%=String.valueOf(bEventStatusComp)%>' == 'false')
        {
		  if(confirm('<%=MessageLookup.getMessageByNumber( Messages.MSG_REMOVAL_YEAR_NOT_CURRENT )%>' ) )
		  {
		      return true;
		  }
		  else
		  {
		      return false;
		  }
        }
      }
      
      return true;
}

// called whenever the removal date is changed
function recomputeAge()
{
  if (( (frmCnsrvtrshpRemoval.dtDtRemoval.value).length > 0 ) || (frmCnsrvtrshpRemoval.dtDtRemoval.value == null))
  {
    var removalYears = document.getElementById("labelRemovalAgeYears_id");
    var removalMonths = document.getElementById("labelRemovalAgeMonths_id");

    <%
    if (birthDateNull)
    {
      if (ageYrsNull &&  ageMonsNull)
    {
    %>
      removalYears.innerText = "";
      removalMonths.innerText = "";
    <%  
    }
    else
    {
    %>
      removalYears.innerText = <%=strAgeYrs%>;
      removalMonths.innerText = <%=strAgeMons%>;
      frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = <%=strAgeYrs%>;
      frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = <%=strAgeMons%>;
    <%  
    }

    }
    else
    {
    %>
      // initialize variables for the birthdate of the person being removed
      var iTodayYear = <%= (100 * todayDate.getCentury()) + todayDate.getYear()%>;
      var iTodayMonth = <%=todayDate.getMonth()%>;
      var iTodayDay = <%=todayDate.getDay()%>;

      // initialize variables for the birthdate of the person being removed
      var iBDYear = <%= (100 * birthDate.getCentury()) + birthDate.getYear()%>;
      var iBDMonth = <%=birthDate.getMonth()%>;
      var iBDDay = <%=birthDate.getDay()%>;

      // get the date from the date control, and parse it into M/D/Y parts
      //  var sRemovalDate = frmCnsrvtrshpRemoval.dtDtRemoval.value;
      var sRemovalDate = validateDateString(frmCnsrvtrshpRemoval.dtDtRemoval.value);

      var valid = validateDate(sRemovalDate);
      if (!valid)
      {
        alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_DATE)%>");
        frmCnsrvtrshpRemoval.dtDtRemoval.value = "";
        clearAge(removalYears, removalMonths);
      }
      else
      {
        frmCnsrvtrshpRemoval.dtDtRemoval.value = sRemovalDate;
     
        var pos = sRemovalDate.search('/');
        
        // STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseIn
        var iRMonth = parseInt(sRemovalDate.substring(0, pos),10);
        
        sRemovalDate = sRemovalDate.substring(pos + 1, sRemovalDate.length);
        pos = sRemovalDate.search('/');
        
        // STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseIn
        var iRDay = parseInt(sRemovalDate.substring(0, pos),10);
        
        // STGAP00010451: Specify the decimal number system (radix parameter = 10) when using parseIn
        var iRYear = parseInt(sRemovalDate.substring(pos + 1, sRemovalDate.length),10);

        // compute the number of full months between the two dates
        var months = (iRYear - iBDYear) * 12 + (iRMonth - iBDMonth);
        if (iRDay < iBDDay)
        {
          months--;
        }

        // years = trunc(months / 12)
        var years = ((months - (months % 12)) / 12);

        // months = months % 12
        months = (months % 12);

        // make sure the removal date isn't after today
        if ((iRYear > iTodayYear) ||
            (iRYear == iTodayYear &&
             ( (iRMonth > iTodayMonth) ||
               ( ( iRMonth == iTodayMonth ) && ( iRDay > iTodayDay ) ) ) ))
        {
          alert("<%=MessageLookup.getMessageByNumber(Messages.SSM_DATE_BEFORE_SAME_CURR)%>");
          frmCnsrvtrshpRemoval.dtDtRemoval.value = "";
          clearAge(removalYears, removalMonths);

          /** @todo remove old commented out code */
          //frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = "";
          //frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = "";
        }
        else
        {
          // if the person is too old...
          if (years >= 18)
          {
            // alert the user to the error, and clear both widgets (date and age)
            alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SUB_CHILD_OVER_18)%>");
            frmCnsrvtrshpRemoval.dtDtRemoval.value = "";
            clearAge(removalYears, removalMonths);

            /** @todo remove old commented out code */
            //frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = "";
            //frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = "";
          }
          // otherwise, if we calculated a valid (i.e. non-negative) age...
          else if (years >= 0 && months >= 0)
          {
            // set the value of the widget

            removalYears.innerText = years;
            removalMonths.innerText = months;
            frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = years;
            frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = months;
          }
          // otherwise...
          else
          {
            // alert the user to the error, and clear both widgets (date and age)
            alert("The Removal Date cannot be before the Birthdate of the removed Child.");
            frmCnsrvtrshpRemoval.dtDtRemoval.value = "";
            clearAge(removalYears, removalMonths);
            /** @todo remove old commented out code */
            //frmCnsrvtrshpRemoval.labelRemovalAgeYears.value = "";
            //frmCnsrvtrshpRemoval.labelRemovalAgeMonths.value = "";
          }
        }
      }
    <%}%>
  }
}

function setupPage()
{
<%--'these two functions are used to disable all other checkboxes if
the N/A box has been saved as checked.'--%>

<%--'SIR 23063 - only call this if the checkboxes are not already disabled,
otherwise there is a javascript error because that field
document.frmCnsrvtrshpRemoval.cbxChildChars1 does not exist'--%>
  if (document.frmCnsrvtrshpRemoval.cbxChildChars1)
  {
    if (document.frmCnsrvtrshpRemoval.cbxChildChars1.checked)
    {
      selectedNA('cbxChildChars', <%=String.valueOf(childCharList.size())%>, true);
    }
  }
<%--'SIR 23063 - only call this if the checkboxes are not already disabled,
otherwise there is a javascript error because that field
document.frmCnsrvtrshpRemoval.cbxChildChars1 does not exist'--%>
  if (document.frmCnsrvtrshpRemoval.cbxCareTakerChars1)
  {
    if (document.frmCnsrvtrshpRemoval.cbxCareTakerChars1.checked)
    {
      selectedNA('cbxCareTakerChars', <%=String.valueOf(careTakerCharList.size())%>, true);
    }
  }
  recomputeAge();
}

window.attachEvent('onload', setupPage);

function confirmRemovalPriorAllegIncident()
{
  if(confirm('<%=MessageLookup.getMessageByNumber( Messages.MSG_SUB_REM_DATE_WARN )%>' ) )
  {
    document.frmCnsrvtrshpRemoval.hdnRemovalConfirmed.value = 'Y';
    if ('true' == saveClicked) {
      submitValidateForm('frmCnsrvtrshpRemoval', '/subcare/CnsrvtrshpRemoval/save');
    }
  }
}

function verifyReport()
{
  if (isFormChanged(frmCnsrvtrshpRemoval))
  {
    alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARC_DATA_CHANGED)%>');
    return false;
  }
  else
  {
    return true;
  }
}

window.onbeforeunload = function ()
{
  IsDirty();
};

function selectedNA(controlName, numCbx, checked)
{
  for (i = 2; i <= numCbx; i++)
  {
    var cbx = document.getElementsByName(controlName + i);
    if (checked)
    {
      if (cbx[0].checked)
      {
        cbx[0].click();
      }
      cbx[0].disabled = true;
    }
    else
    {
      cbx[0].disabled = false;
    }
  }
}

function clickNA(controlName, numCbx)
{
  var val = event.srcElement.value;

  if (val == "NA")
  {
    var checked = event.srcElement.checked;
    selectedNA(controlName, numCbx, checked);
  }
}
// MR-074: 2 new functions to enable help text to Neglect, Relinquishment, and Caretaker's Inability  
function stayHere() {

  var vertScroll = document.body.scrollTop
  document.body.scrollTop = vertScroll;
}

function displayReasonHelpText(txt) {

  frmCnsrvtrshpRemovalHelp.HelpTxtName.value=txt;
  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=yes,resizable=yes,width=600,height=350');
  frmCnsrvtrshpRemovalHelp.target = "txtWin";
  if( window.focus ) {
    errorList.focus();
  }
  frmCnsrvtrshpRemovalHelp.submit();
  }

// MR-074: set the current checkbox value before change
function setCurrentReasonBeforeChange(value) {
  var hdnCbxPrevReason = document.frmCnsrvtrshpRemoval.hdnCbxPrevReason;
  hdnCbxPrevReason.value = value;
  eval(hdnCbxPrevReason);
}

// STGAP00017013: MR-095 Check for the relationship of the person selected 
// in the Caregiver/Parental Relationship Information for Child section on the Person Detail page
// has been updated in Foster Care Principal List for FCC Stage section on the Custody page 
function checkForCpPersonRelUpdate(){
  var errorCode = '<%= (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") %>';
  if (errorCode == '<%= Messages.MSG_CONFIRM_CP_SECTION_MISMATCH %>')
    {
      if (confirm( '<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_CP_SECTION_MISMATCH)%>' )) {
        document.frmCnsrvtrshpRemoval.hdnBIndCpValueCheck.value = 'N';
        cancelValidation();
        submitValidateForm('frmCnsrvtrshpRemoval', '/subcare/CnsrvtrshpRemoval/save');
      } else {
        document.frmCnsrvtrshpRemoval.hdnBIndCpValueCheck.value = 'Y';
      }
  }
}

function cancelValidation ()
{
  disableValidation('frmCnsrvtrshpRemoval');
}

// End STGAP00017013: MR-095

</script>

<!-------------------------------------------------------------------------------------------------
!- Form - frmCnsrvtrshpRemoval
!-
!- the main form for the page, containing all controls
!------------------------------------------------------------------------------------------------>
<impact:validateErrors/>

<%
  removalType_DP = "false";
  removalType_VO = "false";
  removalType_VP = "false";
  removalType_ST = "false";
  String ind_removalType = csub14so.getROWCSUB14SOG00().getRbRemovalType();
  if (ind_removalType != null) {
    if ("DP".equals(ind_removalType)) {
      removalType_DP = "true";
    } else if ("VO".equals(ind_removalType)) {
      removalType_VO = "true";
    } else if ("VP".equals(ind_removalType)) {
      removalType_VP = "true";
    } else {
      removalType_ST = "true";
    }
  } else {
    ind_removalType = StringHelper.EMPTY_STRING;
  }
%>


<impact:validateForm
        name="frmCnsrvtrshpRemoval" method="post" action=""
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.CnsrvtrshpRemovalCustomValidation"
        schema="/WEB-INF/Constraints.xsd"
        pageMode="<%=pageMode%>">

<impact:validateInput name="hdnReloadingCnsrvtrshpRemoval" type="hidden" value="true"></impact:validateInput>
<impact:validateInput name="hdnCbxPersonsAtHome" type="hidden"></impact:validateInput>
<impact:validateInput type="hidden" name="hdnRemovalConfirmed" value="" />
<impact:validateInput type="hidden" name="hdnLocationAnchor" value="" />
<impact:validateInput type="hidden" name="hdnRLM_autoselect" value="false" />
<impact:validateInput type="hidden" name="hdnCbxPrevReason" value="<%= ind_removalType %>" />
<impact:validateInput type="hidden" name="hdnCbxReason" />
<!-- STGAP00017013: MR-095 -->
<impact:validateInput type="hidden" name="hdnBIndCpValueCheck" value="Y"/>
<!-- End STGAP00017013: MR-095 -->
<input type="hidden" name="HelpTxtName" value="" />

<!-- STGAP00017013: MR-095 Informational message for Foster Care Principal List for FCC Stage section -->
<% if ((pageMode.equals(PageModeConstants.NEW_USING) || pageMode.equals(PageModeConstants.NEW)) 
   && !"COMP".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus())) {
%>
<table border="0" cellspacing="3" cellpadding="0" width="100%">
  <tr>
	<td>
	  <hr>
	  <span class="formInfoText">Attention:</span>
    </td>
  </tr>
  <tr>
	<td><font color=#0000ff><li>
		<span class="formInfoText"><%= MessageLookup.getMessageByNumber( Messages.MSG_COMPLT_FC_PRN_LIST_WARN ) %></span></font>
	</td>
  </tr>
  <tr>
    <td>
      <hr>
    </td>
  </tr>
</table>
<% }
%>
<!-- End STGAP00017013: MR-095 -->
			    
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Removal Date</th>
  </tr>
  <tr>
    <td colspan="0">
      <impact:validateDate
              label="Removal Date"
              name="dtDtRemoval"
              value="<%=strRemovalDate%>"
              required="true"
              constraint="Date"
              disabled="<%=String.valueOf(bEventStatusComp)%>"
              onBlur="recomputeAge();"
              width="20%"
              tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      Age at Removal:
      <impact:validateDisplayOnlyField
              name="labelRemovalAgeYears"
              value="<%=labelRemovalAgeYears%>"
              />
      Years
      <impact:validateDisplayOnlyField
              name="labelRemovalAgeMonths"
              value="<%=labelRemovalAgeMonths%>"
              />
      Months
    </td>
  </tr>
  <tr>
    <td colspan="0">
      <span class="formRequiredText">*</span> Removal Type:
    </td>
    <td colspan="4">
      <impact:validateInput type="radio" label="Court Ordered" id="RemovalType_DP" name="rbRemovalType"
                            value="<%=CodesTables.CREMT_DP%>" cssClass="formInput" checked="<%= removalType_DP %>"
                            onClick="updateReason();" onChange="setCurrentReasonBeforeChange(this.value);"
                            tabIndex="<%= tabIndex++ %>"/>
      <impact:validateInput type="radio" label="Voluntary Surrender" id="RemovalType_VO" name="rbRemovalType"
                            value="<%=CodesTables.CREMT_VO%>" cssClass="formInput" checked="<%= removalType_VO %>"
                            onClick="updateReason();" onChange="setCurrentReasonBeforeChange(this.value);"
                            tabIndex="<%= tabIndex++ %>"/>
      <impact:validateInput type="radio" label="Voluntary Placement" id="RemovalType_VP" name="rbRemovalType"
                            value="<%=CodesTables.CREMT_VP%>" cssClass="formInput" checked="<%= removalType_VP %>"
                            onClick="updateReason();"  onChange="setCurrentReasonBeforeChange(this.value);"
                            tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td colspan="0"></td>
    <td colspan="2"> 
      <impact:validateInput type="radio" label="Short Term Emergency Care (Care up to 7 days)" id="RemovalType_ST" name="rbRemovalType"
                            value="<%=CodesTables.CREMT_ST%>" cssClass="formInput" checked="<%= removalType_ST %>"
                            onClick="updateReason(); disableAllRemovalReasons();" onChange="setCurrentReasonBeforeChange(this.value);"
                            tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td colspan="1">
      <impact:validateInput type="checkbox"
                            label="Parent Notified of 72 Hour Hearing at Removal"
                            checked="<%= (("".equals(parentNotified)) || ("N".equals(parentNotified))) ? "false" : "true" %>"
                            tabIndex="<%= tabIndex++ %>"
                            value="Y"
                            name="cbxParentNotified"
                            cssClass="formInput"/>
    </td>
  </tr>
  <tr>
    <th colspan="5"><span class="formCondRequiredText">&#135;</span> Removal Reason</th>
  </tr>
  <tr>
    <td colspan="5">
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
	    <tr>
	      <th>Caretaker-related</th>
	    </tr>
 		<tr>
		  <td>
		    <table width="100%">
		      <tr>
		        <td width="50%">
							<%
							  int i = 0;
							      Iterator<CodeAttributes> iterator = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CREMFRHR)
							                                                .iterator();
							      int size = Lookup.getCategoryCollection(CodesTables.CREMFRHR).size();
							      int half = size / 2 + 1; // this list is 11 elements
							      String helpText = "";
							%>
							<table border="0" width="100%" cellpadding="3" cellspacing="0">
								<%
								  for (i = 0; i <= half - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String cbxRemovalReason = "cbxRemovalReasonsAdult" + (i + 1);
								          String szCheckedRemovalReason = "false";

								          if (checkedRemovalReasons != null) {
								            if (checkedRemovalReasons.contains(code)) {
								              szCheckedRemovalReason = "true";
								            }
								          }
								          removalReasonNameMap.put(code, cbxRemovalReason);
									%>
								<tr>
									<td title="<%=title%>">
										<impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="<%=cbxRemovalReason%>"
											label="<%=decode%>" title="<%=title%>"
											checked="<%=szCheckedRemovalReason%>" value="<%=code%>"
											disabled="<%=String.valueOf(bEventStatusAprv)%>" />
									</td>
									<%
									if (decode.startsWith("Neglect")) {
									  helpText = "Neglect: Includes Domestic Violence, Emotional Abuse, Inadequate Food/Clothing/Shelter, Lack of Supervision, Medical Neglect, and Refusal to Assume ParentalResponsibility.";
									} else if (decode.startsWith("Caretaker")) { // Unable to Cope reason
									  helpText = "Caretaker\\'s Inability to Cope due to Illness or Other Reason: Includes Emotionally Disturbed, Safe Place for Newborn Act, and Voluntary Placement.";
									} else if (decode.startsWith("Relinquishment")) { 
									  helpText = "Relinquishment: Includes Voluntary Surrender.";
									} 
									if (decode.startsWith("Neglect") || decode.startsWith("Caretaker") || decode.startsWith("Relinquishment")) {
									%>									 								
									<td>	<a href="#" onClick="displayReasonHelpText('<%= helpText %>')">?</a>
									<%} %>
									</td>
								</tr>
								<%
								  }
								        i++;
								      }
								%>
							</table> <!-- end reason col 1 -->
				</td>
				<td width="50%">
					<table border="0" width="100%" cellpadding="3" cellspacing="0">
								<%
								  for (i = half; i <= size - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String cbxRemovalReason = "cbxRemovalReasonsAdult" + (i + 1);
								          String szCheckedRemovalReason = "false";

								          if (checkedRemovalReasons != null) {
								            if (checkedRemovalReasons.contains(code)) {
								              szCheckedRemovalReason = "true";
								            }
								          }
								          removalReasonNameMap.put(code, cbxRemovalReason);
								   %>
											<tr>
												<td align="left" title="<%=title%>">
													<impact:validateInput tabIndex="<%=tabIndex++%>"
														type="checkbox" name="<%=cbxRemovalReason%>"
														label="<%=decode%>" title="<%=title%>"
														checked="<%=szCheckedRemovalReason%>" value="<%=code%>"
														disabled="<%=String.valueOf(bEventStatusAprv)%>" />
												</td>
									<%
									if (decode.startsWith("Neglect")) {
									  helpText = "Neglect: Includes Domestic Violence, Emotional Abuse, Inadequate Food/Clothing/Shelter, Lack of Supervision, Medical Neglect, and Refusal to Assume Parental Responsibility.";
									} else if (decode.startsWith("Caretaker")) { // Unable to Cope reason
									  helpText = "Caretaker" + "'" + "s Inability to Cope due to Illness or Other Reason: Includes Emotionally Disturbed, Safe Place for Newborn Act, and Voluntary Placement.";
									} else if (decode.startsWith("Relinquishment")) { 
									  helpText = "Relinquishment: Includes Voluntary Surrender.";
									} 
									if (decode.startsWith("Neglect") || decode.startsWith("Caretaker") || decode.startsWith("Relinquishment")) {
									%>									 								
									<td>	<a href="#" onClick="displayReasonHelpText('<%= helpText %>')">?</a>
									<%} %>
												</td>
											</tr>
											<%
								  }
								        i++;
								      }
								%>
					</table><!-- end reason col 2 -->

		        </td>
		      </tr> <!-- end caretaker reasons -->
		    </table><!-- end caretaker reasons table-->
		  </td>
		</tr>
		<tr>
		  <th>Child-related</th>
		</tr>
		<tr>
		  <td>
		    <table width="100%">
		      <tr>
		        <td>
		            <impact:castorCheckbox
		              castorEnum="<%= Collections.enumeration(removalReasonsChild) %>"
		              checkedValues="<%= checkedRemovalReasons %>"
		              name="cbxRemovalReasonsChild"
		              labelPropertyName="Code"
		              valuePropertyName="Decode"
		              columns="2"
		              isRuled="false"
		              isHorizontal="false"
		              tabIndex="<%= tabIndex++ %>"
		              disabled="<%=String.valueOf(bEventStatusAprv)%>"
		              onClick=""/>
		        </td>
		      </tr>
		    </table>
		  </td>
		</tr>
	  </table>
	</td>
  </tr>
  
  <tr>
    <td>
      <span class="formRequiredText">*</span> Factual Description of incident precipitating removal
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <impact:validateTextArea
              name="txtFactualDesc"
              tabIndex="<%= tabIndex++ %>"
              constraint="Paragraph500"
              maxLength="500"
              colspan="2"
              cols="80"
              rows="5"><%=commentsFactualDesc%>
      </impact:validateTextArea>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th>Child Characteristics</th>
  </tr>
  <tr>
    <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		      <tr>
		        <td width="50%">
							<%							
							CodeAttributesComparator attributesComparator = new CodeAttributesComparator();
							Collections.sort(childCharList, attributesComparator);
							  i = 0;
							      iterator = childCharList.iterator();
							      size = childCharList.size();
							      half = size / 2 + size % 2; 
							%>
							<table border="0" width="100%" cellpadding="3" cellspacing="0">
								<%
								  for (i = 0; i <= half - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String txtChildChar = "txtChildChars" + (i + 1);
								%>
								<tr>
									<td title="<%=title%>">
										<impact:validateDisplayOnlyField 
											name="<%=txtChildChar%>"
											value="<%=decode%>"
											 />
									</td>
								</tr>
								<%
								  }
								        i++;
								      }
								%>
							</table> <!-- end char col 1 -->
				</td>
				<td width="50%">
					<table border="0" width="100%" cellpadding="3" cellspacing="0">
											<%
								  for (i = half; i <= size - 1;) {
								        String title = StringHelper.EMPTY_STRING;
								        if (iterator.hasNext()) {
								          CodeAttributes codeAttribute = iterator.next();
								          String code = codeAttribute.getCode();
								          String decode = codeAttribute.getDecode();
								          String txtChildChar = "txtChildChars" + (i + 1);
								%>
											<tr>
												<td align="left" title="<%=title%>">
													<impact:validateDisplayOnlyField 
														name="<%=txtChildChar%>"
														value="<%=decode%>"
														 />
												</td>
											</tr>
											<%
								  }
								        i++;
								      }
								%>
					</table><!-- end char col 2 -->

		        </td>
		      </tr> <!-- end child characteristics reasons -->

      </table>
    </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th><span class="formRequiredText">*</span> Persons Living In Home at Removal</th>
  </tr>
  <tr>
    <td>
      <div id="scrollBar" style="height:155px; width:760px; overflow:auto" class="tableborderList">
        <table cellspacing="0" border="0" cellpadding="3" width="100%">
          <tr>
            <th class="thList">&nbsp;</th>
            <th class="thList">Name</th>
            <th class="thList">Relationship</th>
            <th class="thList">DOB</th>
            <th class="thList">Sex</th>
          </tr>
          <%
            ROWCSUB48SOG00_ARRAY rowcsub48SOG00_array = csub48so.getROWCSUB48SOG00_ARRAY();
            if (rowcsub48SOG00_array != null) {
              int loopCount = 0;
              Enumeration enumeration = rowcsub48SOG00_array.enumerateROWCSUB48SOG00();
              while (enumeration.hasMoreElements()) {
                ROWCSUB48SOG00 row = (ROWCSUB48SOG00) enumeration.nextElement();
                String cbxName = "cbxPersonsAtHome_" + row.getUlIdPerson();
                boolean checked = onReload ?
                                  request.getParameter(cbxName) != null :
                                  "Y".equalsIgnoreCase(row.getCScrIndRefChildMatch());
          %>
          <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
            <td>
              <impact:validateInput name='<%=cbxName%>'
                                    type="checkbox"
                                    value="<%=String.valueOf(row.getUlIdPerson())%>"
                                    disabled="<%=String.valueOf(bEventStatusAprv)%>"
                                    tabIndex="<%= tabIndex++ %>"
                                    onChange="updatePersonsAtHome()"
                                    checked="<%=String.valueOf(checked)%>"/>
            </td>
            <td><%=row.getSzNmPersonFull()%>
            </td>
            <td><%=Lookup.simpleDecode(CodesTables.CRPTRINT, row.getSzCdPersonRelationship())%>
            </td>
            <td><%=FormattingHelper.formatDate(row.getDtDtPersonBirth())%>
            </td>
            <td><%=Lookup.simpleDecode(CodesTables.CSEX, row.getCCdPersonSex())%>
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

<!-- STGAP00017013: MR-095 Foster Care Principal List for FCC Stage section -->
<% if ((pageMode.equals(PageModeConstants.NEW_USING) || pageMode.equals(PageModeConstants.NEW)) 
   && !"COMP".equals(csub14so.getROWCSUB14SOG04().getSzCdEventStatus()))  {
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th><span class="formRequiredText">*</span> Foster Care Principal List for FCC Stage&nbsp;&nbsp;&nbsp;&nbsp;  <a href="javascript:void window.open ('/subcare/CnsrvtrshpRemoval/displayFosterCarePrnListHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')" onClick="hrefDirtyBypass=true;">  ?</a></span></th>
  </tr>
  <tr>
    <td>
      <div id="scrollBar" style="height:155px; width:760px; overflow:auto" class="tableborderList">
        <table cellspacing="0" border="0" cellpadding="3" width="100%">
          <tr>
            <th class="thList" width="7%"></th>
            <th class="thList" width="27%">Name</th>
            <th class="thList" width="32%">Person ID</th>
            <th class="thList" width="34%">Relationship</th>
          </tr>
          <%
            ROWCSUB80SOG00_ARRAY rowcsub80SOG00_array = csub80so.getROWCSUB80SOG00_ARRAY();
            if (rowcsub80SOG00_array != null) {
              int loopCount = 0;
              i = 0;
              Enumeration enumeration = rowcsub80SOG00_array.enumerateROWCSUB80SOG00();
              while (enumeration.hasMoreElements()) {
                ROWCSUB80SOG00 row = (ROWCSUB80SOG00) enumeration.nextElement();
                String cdStagePersRelInt = "selSzCdStagePersRelInt_" + ( i + 1 );
                
                // Initialize szCdStagePersRelInt to the actual value
                if (request.getParameter(cdStagePersRelInt) == null) {
                  szCdStagePersRelInt = FormattingHelper.formatString(row.getSzCdStagePersRelInt());
                } else{
                  szCdStagePersRelInt = request.getParameter(cdStagePersRelInt);
                }  
          %>
          <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
            <td>            
            </td>
            <td><%=row.getSzNmPersonFull()%>
            </td>
            <td><%=row.getUlIdPersonPrincipal()%>
            </td>
            <td><impact:validateSelect 
                              blankValue="true"
                              overrideDisplayBadCodes="true"
                              orderBy="decode"
                              codesTable="<%="CRELVICT"%>"
                              required="<%= ArchitectureConstants.FALSE %>"
                              name='<%= cdStagePersRelInt%>' 
                              excludeOptions="<%= excludeRel %>"
                              style="WIDTH: 160px"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= EditableMode.NEW_USING + EditableMode.NEW %>"
                              value="<%=FormattingHelper.formatString(szCdStagePersRelInt)%>"/>                              
            </td>
          </tr>
          <%
                loopCount++;
                i++;
              }
            }
          %>
        </table>
      </div>
    </td>
  </tr>
</table>
<% }
%>
<!-- End STGAP00017013: MR-095 -->

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <impact:ButtonTag
              action="/subcare/CnsrvtrshpRemoval/save"
              form="frmCnsrvtrshpRemoval"
              img="btnSave"
              function="return CheckPersonsAtHome() && confirmRemovalDate(); setRemovalConfirmed()"
              name="btnSave"
              disabled="<%=String.valueOf(bEventStatusAprv)%>"
              restrictRepost="true"
              preventDoubleClick="true"
              tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<br>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>

<script type="text/javascript" language="JavaScript1.2">
var saveClicked;
window.onload = function ()
{
  <%
  if ("Y".equals(warnRemovalPriorAllegIncident)) {
  %>
    saveClicked = '<%= StringHelper.isValid(request.getParameter("btnSave" + ".x"))%>';
    confirmRemovalPriorAllegIncident();
  <%
  }
  %>
  // MR-074: select and check Relinquish reason if removal type is Voluntary Surrender;
  // Caretaker's Inability reason if removal type is Voluntary Placement
  updateReason();
  disableAllRemovalReasons();
  
  // STGAP00017013: MR-095
  checkForCpPersonRelUpdate();
}   

// MR-074: put here so map can have values
function updateReason() {
   var removalType = document.frmCnsrvtrshpRemoval.rbRemovalType;
   var val = getSelectedRadioValue(removalType);
   var prev = document.frmCnsrvtrshpRemoval.hdnCbxPrevReason.value;
  <%
  String cbxRLMid = "";
  String cbxUNAid = "";

  if (removalReasonNameMap.containsKey("RLM")) {
    cbxRLMid = removalReasonNameMap.get("RLM")+"_Id"; // id java string is best constructed here 
  }
  if (removalReasonNameMap.containsKey("UNA")) {
    cbxUNAid = removalReasonNameMap.get("UNA")+"_Id";
  }
  %>
  var cbxRLM = document.getElementById("<%=cbxRLMid %>"); 
  var cbxUNA = document.getElementById("<%=cbxUNAid %>"); 
  
  if (val == "ST") {
    
    disableAllRemovalReasons();  // disable and clear
  }
  // Voluntary Surrender, auto-select Relinquish reason RLM
  else if (val == "VO") {
    // enable all other reasons
    enableAllRemovalReasons();
    if (cbxRLM.checked == false) {
      cbxRLM.click();
    }
    cbxRLM.disabled = true;
  } 
  // Voluntary Placement, auto-select Caretaker's Inability to Cope UNA
  else if (val == "VP") {
    // enable all other reasons
    enableAllRemovalReasons();
    if (cbxUNA.checked == false) {
      cbxUNA.click();
    }
    cbxUNA.disabled = true;
  } 
  // Court Ordered removal type selected, enable all reasons
  else if (val == "DP") {
    enableAllRemovalReasons();
  } 
  // if either Volunatarty Surrender or Voluntary Placement is deselected, clear the associated checkbox
  // all checkbxes already enabled by DP logic above
  if (prev == "VO") {
    if (cbxRLM.checked == true) {
      cbxRLM.click();
    } 
    //cbxRLM.disabled = false;
  } else if (prev == "VP") {
      if (cbxUNA.checked == true) {
        cbxUNA.click();
      }
    //  cbxUNA.disabled = false;
  }
}

function disableAllRemovalReasons() {
  var x = document.frmCnsrvtrshpRemoval;
  var removalType = document.frmCnsrvtrshpRemoval.rbRemovalType;
  var val = getSelectedRadioValue(removalType);
  // If this is Short Term Emergency Care removal, no removal reasons should be entered, disable and clear all removal reasons 
  if (val == "ST") {  
  for (var i = 0; i < x.elements.length; i++)
  {
    sElementName = new String(x.elements[i].name); 
    if (x.elements[i].type == "checkbox" && sElementName.substring(0, 17) == "cbxRemovalReasons")
    {
        x.elements[i].disabled = false;  // enable to clear fields w/o calling the changed name
        if (x.elements[i].checked) {
          x.elements[i].click(); // clear value
        }
        x.elements[i].disabled = true; // disable
    }
  }
  } 
}

function enableAllRemovalReasons() {
  var x = document.frmCnsrvtrshpRemoval;
  for (var i = 0; i < x.elements.length; i++)
  {
    sElementName = new String(x.elements[i].name); 
    if (x.elements[i].type == "checkbox" && sElementName.substring(0, 17) == "cbxRemovalReasons")
    {
        x.elements[i].disabled = false;
    }
  }
}

</script>
</impact:validateForm>

<form name="frmCnsrvtrshpRemovalHelp" method="post" action="/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemovalHelp">
  <input type="hidden" name="HelpTxtName" value="" />
</form>