<%
/**
 * JSP Name:     LegalActions.jsp
 * Created by:   Carolyn Douglass
 * Date Created: 03/03/03
 *
 * Description:
 * The user will be able to enter, modify and browse the legal activity
 * information.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  04/13/04  C. Douglass       SIR 22658 - add new codes table CCAA, CCUU
  05/10/04  C. Douglass       SIR 22891 - end dated codes table items
                              not showing up in dropdowns.  Add value =
                              subtype to code arrays.
  06/17/04  C. Douglass       SIR 22873 - disable Date Filed and Outcome
                              for CPS to simplify entry
  09/12/06  abgoode           The page has been completely overhauled for
                              Release 1 of GA SACWIS
  11/04/08  arege             Per STGAP000010758 Legal Action and Outcome Detail Design Document.
                              The SaveAndSubmit button should not be displayed for the Supervisor in Approval Mode.
                              This will prevent an extra To-Do being created.
  05/05/09  hjbaptiste        STGAP00013538 - Added preventDoubleClick property to the Save and Save and Submit buttons. 
                              Also place the buttons into their own column    
  09/02/09  bgehlot           STGAP00015257: When copying legal action (Court Order Signed, Amendment to Court Order, 
                              Update to Previous Action )three checkboxes should be copied too  
  02/08/10  mxpatel           CAPTA: Added validations for CAPTA changes. Added new fields on the page                                                    
  02/10/10  mxpatel           STGAP00015776: Modify the label to display "CASA or Atty/GAL) Assigned" instead of "CASA or Atty/Gua Ad Litem) Appointed"
  03/16/10  arege             SMS#48132: Changed label No Representation Assigned on Legal Actions page.
  12/12/10  hnguyen           SMS#81144: Corrected population for Continuance Date.
  
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.LegalActionsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%
  String SPACES = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  
  String pageMode = PageModeConstants.VIEW;
  if( PageMode.getPageMode( request ) != null )
  {
    pageMode = PageMode.getPageMode( request );
  }

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile(request);
  
  //==================================================================================
  String eventStatus = "";
  String county = ContextHelper.getStringSafe(request, "selCounty");
  if("".equals(county)){
    county = user.getUserCounty();
  }
  String usState = ContextHelper.getStringSafe(request, "selState"); //-- NEW
  if("".equals(usState)){
    usState = CodesTables.CSTATE_GA;
  }
  
  int courtFileNumber = ContextHelper.getIntSafe(request, "ulCtFileNum");
  String dateFiled = ContextHelper.getStringSafe(request, "txtDtFiled");
  String courtCaseNumber = ContextHelper.getStringSafe(request, "ulCtCaseNum");
  String courtActionDate = ContextHelper.getStringSafe(request, "dtCtActDate");
  String courtType = ContextHelper.getStringSafe(request, "selCtType");
  String action = ContextHelper.getStringSafe(request, "selLegalAction");
  String hTypeCtOrder = ContextHelper.getStringSafe(request, "selHTypeCtOrder");
  String nxtCtHDate = ContextHelper.getStringSafe(request, "dtNxtCtHDate");
  String contDate = ContextHelper.getStringSafe(request, "dtContDate");
  String ctOrderDate = ContextHelper.getStringSafe(request, "dtCtOrderDate");
  String pubDate = ContextHelper.getStringSafe(request, "dtPubDate");
  String scaDate = ContextHelper.getStringSafe(request, "dtShelterCareAuth"); //-- NEW
  String scaTime = ContextHelper.getTimeSafe(request, "tmShelterCareAuth"); //-- NEW
  String ctOrderPrepBy = ContextHelper.getStringSafe(request, "szCtOrderPrepBy"); //-- NEW
  List outcomeList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbgOutcome_")); //-- NEW
  List ctOrdLangList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbgCtOrdLang_")); //-- NEW
  String szCdStage = GlobalData.getSzCdStage(request);
  String isUpdate = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxUpdate")))
  {
    isUpdate = "true";
  }
  
  String isInCaseFile = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "ckInCaseFile")))
  {
    isInCaseFile = "true";
  }
  
  String isComplete = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxComplete")))
  {
    isComplete = "true";
  }
  
  String isRepAppointed = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxBIndNoRepAppointed")))
  {
    isRepAppointed = "true";
  }
  
  String isSigned = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxCtOrderSigned"))) //-- NEW
  {
    isSigned = "true";
  }
  
  String isAmendment = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxAmendment"))) //-- NEW
  {
    isAmendment = "true";
  }
  
  AttendeePerson_Array attendees = null;  
  CSUB38SO csub38so = null;
  int tabIndex = 1;
  //==================================================================================

  String s;
  java.util.Date d = null;
  org.exolab.castor.types.Date cd = null;
  java.text.SimpleDateFormat df = DateHelper.SLASH_FORMAT;

  csub38so = (CSUB38SO) state.getAttribute("CSUB38SO", request);
  if(csub38so != null ){
    if(csub38so.getSzCdOutcome_Array() != null && csub38so.getSzCdOutcome_Array().getUlRowQty() > 0){
      outcomeList = Arrays.asList(csub38so.getSzCdOutcome_Array().getSzCdOutcome());
    }
    
    if(csub38so.getSzCdCrtLang_Array() != null && csub38so.getSzCdCrtLang_Array().getUlRowQty() > 0){
      ctOrdLangList = Arrays.asList(csub38so.getSzCdCrtLang_Array().getSzCdCrtLang());
    }
    
    if(csub38so.getAttendeePerson_Array() != null){
      attendees = csub38so.getAttendeePerson_Array();
    }
    
    if(csub38so.getROWCSUB38SOG00() != null){
      s = csub38so.getROWCSUB38SOG00().getSzCdEventStatus();
      if(s != null && !s.equals("")){
        eventStatus = s;
      }
    }
    
    if(csub38so.getROWCSUB38SOG01() != null){
      ROWCSUB38SOG01 legalAction = csub38so.getROWCSUB38SOG01();
      
      //county
      s = legalAction.getSzCdCounty();
      if(s != null && !s.equals("")){
        county = s;
      }
      
      //courtFileNumber
      int i = legalAction.getUlNbrCrtFile();
      courtFileNumber = i>0 ? i : courtFileNumber;
      
      //dateFiled
      cd = legalAction.getDtDtLegalActDateFiled();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        dateFiled = df.format(d);
      }
      
      //courtCaseNumber
      s = legalAction.getSzCdCrtCaseNbr();
      if(s != null && !s.equals("")){
        courtCaseNumber = s;
      }
      
      //courtActionDate
      cd = legalAction.getDtCrtActDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        courtActionDate = df.format(d);
      }
      
      //courtType
      s = legalAction.getSzCdCrtType();
      if(s != null && !s.equals("")){
        courtType = s;
      }
      
      //action
      s = legalAction.getSzCdLegalActAction();
      if(s != null && !s.equals("")){
        action = s;
      }
      
      //hTypeCtOrder
      s = legalAction.getSzCdHrTypCrtOrd();
      if(s != null && !s.equals("")){
        hTypeCtOrder = s;
      }
      
      //nxtCtHDate
      cd = legalAction.getDtNxtHearDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        nxtCtHDate = df.format(d);
      }
      
      //contDate
      cd = legalAction.getDtContinDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        contDate = df.format(d);
      }
      
      //ctOrderDate
      cd = legalAction.getDtCrtOrdDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        ctOrderDate = df.format(d);
      }
      
      //pubDate
      cd = legalAction.getDtPubDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        pubDate = df.format(d);
      }
      
      //usState
      s = legalAction.getSzCdState();
      if(s != null && !s.equals("")){
        usState = s;
      }
      
      //scaDate and scaTime
      d = legalAction.getTsDtShelterCareAuth();
      if(!DateHelper.isNull(d)){
        scaDate = df.format(d);
        scaTime = DateHelper.AM_PM_TIME_FORMAT.format(d);
      }
      
      //ctOrderPrepBy
      s = legalAction.getNmCrtOrdPrepBy();
      if(s != null && !s.equals("")){
        ctOrderPrepBy = s;
      }
      
      //isUpdate, isInCaseFile, isComplete      
      s = legalAction.getCIndLegalActDocsNCase();
      if(s != null && s.equals(LegalActionsConversation.INDICATOR_YES)){
        isInCaseFile = "true";
      }
      
      //STGAP00015257: When copying legal action below three checkboxes should be copied too.
      s = legalAction.getIndUpPrevAct();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isUpdate = "true";
      }
        
      s = legalAction.getIndCrtOrdSigned();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isSigned = "true";
      }
      
      s = legalAction.getBIndNoRepAppointed();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isRepAppointed = "true";
      }
        
      s = legalAction.getIndAmendment();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isAmendment = "true";
      }
      
      if(!(pageMode.equals(PageModeConstants.NEW_USING) || pageMode.equals(PageModeConstants.NEW))){
        s = legalAction.getIndComplete();
        if(LegalActionsConversation.INDICATOR_YES.equals(s) && !LegalActionsConversation.STATUS_PENDING.equals(eventStatus)){
          isComplete = "true";
        }
      }
    }
  }
  
  if(eventStatus.equals("")){
    eventStatus = LegalActionsConversation.STATUS_NEW;
  }
  
  // if Event Status is COMP, and pagemode is not NEW USING, page should be in INQUIRE mode
  if ((eventStatus.equals(LegalActionsConversation.STATUS_COMPLETE) || eventStatus.equals(LegalActionsConversation.STATUS_APPROVED)) && 
      !pageMode.equals(PageModeConstants.NEW_USING)){
    pageMode = PageModeConstants.INQUIRE;
  }
%>
<% /* Needed for Form Launch Custom tag */ %>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<% /* Start Javascript Section */ %>
<script type="text/javascript" language="JavaScript1.2">
  /*
   * This function is called before the page unloads. It creates the
   * "Are you sure you want to navigate away from this page..." pop-up message.
   */
window.onbeforeunload = function ()
{
  IsDirty();
}
</script>
<%
//-- one boolean for each button to represent if the button should be displayed
boolean approvalStatus = true;
boolean narrative = true;
boolean save = true;
boolean saveAndSubmit = true;
boolean docExists = false;
//-- one String to represent if fields should be disabled
String disableFields = "false";
if( ArchitectureConstants.TRUE.equals( request.getAttribute( LegalActionsConversation.DOCEXISTS) ) )
{
    docExists = true;
}

    
String rej = (String) request.getAttribute("approvalRejected");
if( pageMode.equals(PageModeConstants.NEW) ||
    pageMode.equals(PageModeConstants.NEW_USING) ||
  (!eventStatus.equals(LegalActionsConversation.STATUS_PENDING) &&
   !eventStatus.equals(LegalActionsConversation.STATUS_APPROVED) &&
   !"true".equals(rej))){
    approvalStatus = false;
}
if(pageMode.equals(PageModeConstants.INQUIRE)){
  narrative = false;
  save = false;
  saveAndSubmit = false;
  disableFields = "true";
}

//-- The SaveAndSubmit button should not be displayed for the Supervisor in Approval Mode.
//-- This will prevent an extra To-Do being created.
//-- Per STGAP000010758 Legal Action and Outcome Detail Design Document.
if(GlobalData.isApprovalMode(request)){
saveAndSubmit = false;
}
%>
<impact:validateErrors/>
<impact:validateForm name="frmLegalActions"
  method="post"
  action="/subcare/LegalActions/displayLegalActions"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.LegalActionsCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
<%
if(approvalStatus){
%>
    <td>
      <impact:ButtonTag
        name="btnApprovalStatus"
        tabIndex="<%= tabIndex++ %>"
        img="btnApprovalStatus"
        editableMode="<%= EditableMode.ALL %>"
        form="frmLegalActions"
        action="/workload/ApprovalStatus/displayStatus"
      />
    </td>
<%
} else{
%>
    <td>&nbsp;</td>
<%
}
%>
    <%--/* Used for debug purposes
      <td>
        Page Mode: <%= pageMode %>
      </td>
      <td>
        Event Status: <%= eventStatus %>
      </td>
    */--%>
  </tr>
</table>
<%
if(approvalStatus){
%>
<br>
<%
}
int entireColspan = 4; //-- this must be even
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="<%= entireColspan %>">Legal Action</th>
</tr>
<tr>
  <td>
    <impact:validateSelect
      name="selCounty"
      tabIndex="<%= tabIndex++ %>"
      label="County"
      codesTable="<%= CodesTables.CCOUNT %>"
      blankValue="true"
      value="<%= county %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateSelect
      name="selState"
      tabIndex="<%= tabIndex++ %>"
      label="State"
      codesTable="<%= CodesTables.CSTATE %>"
      blankValue="false"
      contentType="<%= SelectTag.CODES %>"
      value="<%= usState %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateDate
      name="txtDtFiled"
      tabIndex="<%= tabIndex++ %>"
      label="Date Filed"
      size="7"
      constraint="Date"
      value="<%= dateFiled %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateInput
      name="ulCtFileNum"
      tabIndex="<%= tabIndex++ %>"
      label="Court File Number"
      type="text"
      size="8"
      maxLength="10"
      constraint="Digit10"
      value="<%= courtFileNumber <= 0 ? "" : ""+courtFileNumber %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateDate
      name="dtCtActDate"
      tabIndex="<%= tabIndex++ %>"
      label="Court/Action Date"
      size="7"
      constraint="Date"
      required="true"
      value="<%= courtActionDate %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateInput
      name="ulCtCaseNum"
      tabIndex="<%= tabIndex++ %>"
      label="Court Case Number"
      type="text"
      size="17"
      maxLength="15"
      constraint="Any15"
      value="<%= courtCaseNumber %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateSelect
      name="selLegalAction"
      tabIndex="<%= tabIndex++ %>"
      label="Action"
      codesTable="<%= CodesTables.CLEGCPS %>"
      blankValue="true"
      required="true"
      value="<%= action %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateSelect
      name="selHTypeCtOrder"
      tabIndex="<%= tabIndex++ %>"
      label="Hearing Type/Court Order"
      codesTable="<%= CodesTables.CLHECOT %>"
      blankValue="true"
      conditionallyRequired="true"
      value="<%= hTypeCtOrder %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateDate
      name="dtShelterCareAuth"
      tabIndex="<%= tabIndex++ %>"
      label="Date Shelter Care Authorized"
      conditionallyRequired="true"
      size="7"
      constraint="Date"
      value="<%= scaDate %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateTime
      name="tmShelterCareAuth"
      tabIndex="<%= tabIndex++ %>"
      label="Time Shelter Care Authorized"
      conditionallyRequired="true"
      value="<%= scaTime %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateDate
      name="dtNxtCtHDate"
      tabIndex="<%= tabIndex++ %>"
      label="Next Court Hearing Date"
      size="7"
      constraint="Date"
      value="<%= nxtCtHDate %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateSelect
      name="selCtType"
      tabIndex="<%= tabIndex++ %>"
      label="Court Type"
      codesTable="<%= CodesTables.CCRTTYPE %>"
      blankValue="true"
      value="<%= courtType %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateDate
      name="dtContDate"
      tabIndex="<%= tabIndex++ %>"
      label="Continuance Date"
      size="7"
      constraint="Date"
      value="<%= contDate %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateDate
      name="dtPubDate"
      tabIndex="<%= tabIndex++ %>"
      label="Publication Start Date"
      size="7"
      constraint="Date"
      value="<%= pubDate %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td>
    <impact:validateInput
      name="szCtOrderPrepBy"
      tabIndex="<%= tabIndex++ %>"
      label="Court Order Prepared By"
      type="text"
      size="27"
      maxLength="40"
      constraint="Name40"
      value="<%= ctOrderPrepBy %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <impact:validateDate
      name="dtCtOrderDate"
      tabIndex="<%= tabIndex++ %>"
      label="Court Order Date"
      size="7"
      constraint="Date"
      value="<%= ctOrderDate %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td colspan="<%= entireColspan/2 %>">
    <impact:validateInput
      name="cbxCtOrderSigned"
      tabIndex="<%= tabIndex++ %>"
      label="Court Order Signed"
      type="checkbox"
      checked="<%= isSigned %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td colspan="<%= entireColspan/2 %>">
    <impact:validateInput
      name="cbxAmendment"
      tabIndex="<%= tabIndex++ %>"
      label="Amendment to Court Order"
      type="checkbox"
      checked="<%= isAmendment %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr>
  <td colspan="<%= entireColspan/2 %>">
    <impact:validateInput
      name="ckInCaseFile"
      tabIndex="<%= tabIndex++ %>"
      label="Document in Case File"
      type="checkbox"
      checked="<%= isInCaseFile %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td colspan="<%= entireColspan/2 %>">
    <impact:validateInput
      name="cbxUpdate"
      tabIndex="<%= tabIndex++ %>"
      label="Update to Previous Action"
      type="checkbox"
      checked="<%= isUpdate %>"
      disabled="<%= disableFields %>"
    />
  </td>
</tr>
<tr><td colspan="<%= entireColspan %>"><br></td></tr>
<tr class="tableBG">
  <th colspan="<%= entireColspan %>">Court Order Language</th>
</tr>
<tr>
  <td colspan="<%= entireColspan %>">
    <impact:codesCheckbox
      name="cbgCtOrdLang_"
      tabIndex="<%= tabIndex++ %>"
      codesTableName="<%= CodesTables.CCRTLANG %>"
      columns="1"
      defaultCodes="<%= ctOrdLangList %>"
    />
  </td>
</tr>
<tr><td colspan="<%= entireColspan %>"><br></td></tr>
<tr class="tableBG">
  <th colspan="<%= entireColspan %>">Outcomes</th>
</tr>
<tr>
  <td colspan="<%= entireColspan %>">
    <impact:codesCheckbox
      name="cbgOutcome_"
      tabIndex="<%= tabIndex++ %>"
      codesTableName="<%= CodesTables.CLEGLOUT %>"
      columns="3"
      defaultCodes="<%= outcomeList %>"
    />
  </td>
</tr>
<tr><td colspan="<%= entireColspan %>"><br></td></tr>
<tr class="tableBG">
  <th colspan="<%= entireColspan %>">Attendees/Involved Parties</th>
</tr>
<tr>
  <td colspan="<%= entireColspan %>">
    <div id="scrollableList" style="height:130px;width:100%;overflow-x:hidden;overflow-y:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
<%
if(attendees != null)
{
%>
      <tr>
        <th class="thList">Name</th>
        <th class="thList">Type</th>
        <th class="thList">Role</th>
        <th class="thList">Relation/Interest</th>
      </tr>
<%
  int i = 0;
  for(Enumeration e=attendees.enumerateAttendeePerson(); e.hasMoreElements();)
  {
    AttendeePerson person = (AttendeePerson) e.nextElement();
%>
      <tr class="<%= FormattingHelper.getRowCss(i++) %>">
        <td>
          <% String cbxId = "cbxAttendee"+i; %>
          <impact:validateInput
            name="<%= cbxId %>"
            tabIndex="<%= tabIndex++ %>"
            type="checkbox"
            checked="<%= person.getUlIndIsAttendee() == 0 ? "false" : "true" %>"
            disabled="<%= disableFields %>"
          /><%= person.getSzNmPersonFull() %>
        </td>
        <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe(CodesTables.CPRSNTYP, person.getSzCdStagePersType())) %></td>
        <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe(CodesTables.CROLEALL, person.getSzCdStagePersRole())) %></td>
        <td><%= FormattingHelper.changeCase(Lookup.simpleDecodeSafe(CodesTables.CRPTRINT, person.getSzCdStagePersRelInt())) %></td>
      </tr>
<%
  }
}
else
{
%>
      <tr><td class="formInstruct">No attendees/involved parties associated to the legal action.</td></tr>
<%
}
%>
    </table>
    </div>
  </td>
</tr>
</table>
<%// Display these Options dropdown only if we are in FCC or ADO stage
      if ("SUB".equals(szCdStage) || "ADO".equals(szCdStage)) {
%>
<tr>
<td class="alignLeft"  width="30%" valign="bottom">
      <impact:validateInput
        name="cbxBIndNoRepAppointed"
        tabIndex="<%= tabIndex++ %>"
        label="No Representation (CASA or GAL Atty or GAL Non-Atty) Assigned"
        type="checkbox"
        checked="<%= isRepAppointed %>"
        disabled="<%= disableFields %>"
      />
      <%= SPACES %>
  </td> 
</tr>	
<%}
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>
  <td width="50%">
  </td>
  <td class="alignRight"  width="30%" valign="bottom">
      <impact:validateInput
        name="cbxComplete"
        tabIndex="<%= tabIndex++ %>"
        label="Complete"
        type="checkbox"
        checked="<%= isComplete %>"
        disabled="<%= disableFields %>"
      />
      <%= SPACES %>
  </td>      
<%
if(saveAndSubmit){
%>
   <td class="alignRight" width="6%">
      <impact:ButtonTag
        name="btnSaveAndSubmit"
        tabIndex="<%= tabIndex++ %>"
        img="btnSaveAndSubmit"
        editableMode="<%= EditableMode.ALL %>"
        form="frmLegalActions"
        preventDoubleClick="true"
        restrictRepost="true"
        action="/subcare/LegalActions/saveAndSubmitLegalActions"
      />
   </td>      
<%
} else{
%><%= SPACES %><%
}
%>
<%
if(save){
%>
   <td class="alignRight" width="6%">
      <impact:ButtonTag
        name="btnSave"
        tabIndex="<%= tabIndex++ %>"
        img="btnSave"
        preventDoubleClick="true"
        restrictRepost="true"
        form="frmLegalActions"
        action="/subcare/LegalActions/saveLegalActions"
      />
<%
} else{
  out.print(SPACES);
}
%>
  </td>
</tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<table>
<tr><td>

<impact:documentButton pageMode="<%= pageMode %>"
                               buttonUrl="/grnds-docs/images/shared/btnNarrative.gif"
                               tabIndex="<%= tabIndex++ %>"
                               accessKey="W" >
                               
       <impact:document displayName="Legal Actions Narrative"
                    protectDocument="<%= !PageModeConstants.VIEW.equals(pageMode) ? false : true  %>"
                    checkForNewMode="true"
                    docType="leg01o00"
                    windowName="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"
                    docExists="<%= docExists %>" >
                    <impact:documentParameter name="sEvent"
                               value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>               
            </impact:document>
    </impact:documentButton>
</td></tr>

</table>
<%--/* Forms and Reports commented out for Release 1
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
          <th colspan="4">Reports</th>
  </tr>
  <tr>
        <td >
   <impact:reportList personId="<%= user.getUserID() %>" onClick="checkDirty()" tabIndex="<%= tabIndex++ %>" >
    <% if (bAPSLogReport )
      { %>
     <impact:report useHiddenParameters="false" reportName="csc01o00" emailMessage='<%="Person Name - " + state.getAttribute( "nmPersonFull", request  ) %>' >
        <impact:reportParameter value='<%= String.valueOf(state.getAttribute( "ulIdPerson", request ))%>'/>
        <impact:reportParameter value="<%=GlobalData.getUlIdCaseAsString( request )%>"/>
     </impact:report>
     <%
      }
      %>
      <%
      if (bCPSLogReport )
      { %>
     <impact:report useHiddenParameters="false" reportName="csc02o00" emailMessage='<%="Person Name - " + state.getAttribute( "nmPersonFull", request  )%>'>
        <impact:reportParameter value='<%= String.valueOf(state.getAttribute( "ulIdPerson", request ))%>'/>
     </impact:report>
      <%
      }
      %>
   </impact:reportList>
        </td>
  </tr>
</table>
<br>
*/--%>
