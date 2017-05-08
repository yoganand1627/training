<%
//*--------------------------------------------------------------------------------
//*  JSP Name:     Policy Violation
//*  Created by:   ssubram
//*  Date Created: 06/05/08
//*
//*  Description:
//*  This JSP displays the Policy Violation.
//*
//*  Change History:
//*  Date      User       Description
//*  --------  ---------- ---------------------------------------------------------
//*  03/19/08  ssubram   - Initial Development
//*  08/26/08  vvo       - STGAP00009837 - change Violation Date field to be required field
//*  05/19/2010 arege    SMS#52234  SaveAndSubmit button should not be available if the page mode is VIEW
//*--------------------------------------------------------------------------------
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.NcCbx" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.CorrectiveActionPlanConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.PolicyViolationConversation"%>
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
  String homeType = ContextHelper.getStringSafe(request, "homeType");
  String dateAchievement = ContextHelper.getStringSafe(request, "txtDtFiled");
  String editableMode = ContextHelper.getStringSafe(request, "editableMode");
  String resultsDesc =  ContextHelper.getStringSafe(request, "resultsDesc");
  String violationDate = ContextHelper.getStringSafe(request, "dtViolation");
  String effectFromDate = ContextHelper.getStringSafe(request, "dtEffectFrom");
  String effectToDate = ContextHelper.getStringSafe(request, "dtEffectTo");
  String dtLastUpdate = ContextHelper.getStringSafe(request, "dtLastUpdate");
  Iterator iter = null;
  int loopCounter = 0;
  Map<Integer, String> childrenInHomeHashmap = null;
  List policyViolationList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxPolViolation_")); //-- NEW
  List<String> polVioList = new ArrayList<String>();
  String isDocumentCompleted = "false";
  String isStOffCon = "false";
  boolean isSecStCpaCon = false;
  boolean bProtectForm = (Boolean) state.getAttribute(PolicyViolationConversation.PROTECT_FORM, request);
  if("on".equals(ContextHelper.getStringSafe(request, "cbxDocumentCompleted"))) //-- NEW
  {
    isDocumentCompleted = "true";
  }
  
  int tabIndex = 1;
  //==================================================================================

  String s;
  java.util.Date d = null;
  java.text.SimpleDateFormat df = DateHelper.SLASH_FORMAT;
  NonComplianceSO nonComplianceSO = null;
  nonComplianceSO = (NonComplianceSO) state.getAttribute("nonComplianceSO",request);
  
  // Create a hashmap for the Children in the Home. The map will be
  // used to determine whether or not a child should selected in the
  // "Children in the Home" listbox.
  childrenInHomeHashmap = new HashMap<Integer, String>();
  if ( nonComplianceSO.getChildrenInHome() != null ){
	iter = nonComplianceSO.getChildrenInHome().iterator();
	while ( iter.hasNext() ){
	  NcPerson ncPerson = (NcPerson)iter.next();
	  childrenInHomeHashmap.put(ncPerson.getIdPerson(), ncPerson.getNmPersonFull());
	}
  }
  
  if (nonComplianceSO != null){
  	//Populate page from the retrieved data
  	//Home Type
  	s = nonComplianceSO.getHomeType();
  	if(s != null && !s.equals("")){
      homeType = s;
    }
  	//Achievement Date
  	d = nonComplianceSO.getDtTracking();
  	if(!DateHelper.isNull(d)){
  	  dateAchievement = df.format(d);
  	}
  	//Violation Date
  	d = nonComplianceSO.getDtOfViolation();
  	if(!DateHelper.isNull(d)){
  	  violationDate = df.format(d);
  	}
  	//Effect From Date
  	d = nonComplianceSO.getDtEffectFrom();
  	if(!DateHelper.isNull(d)){
  	  effectFromDate = df.format(d);
  	}
  	//Effect To Date
  	d = nonComplianceSO.getDtEffectTo();
  	if(!DateHelper.isNull(d)){
  	  effectToDate = df.format(d);
  	}
  	//Date Last Update
  	d = nonComplianceSO.getDtLastUpdate();
  	if(!DateHelper.isNull(d)){
  	  dtLastUpdate = df.format(d);
  	}  	
  	//Result Description
  	s = nonComplianceSO.getTxtComments();
  	if(s != null && !s.equals("")){
      resultsDesc = s;
    }
    //County
    s = nonComplianceSO.getCdCounty();
    if(s != null && !s.equals("")){
      county = s;
    }
    //Document Completed
    s = nonComplianceSO.getIndDocCompleted();
    if(s != null && !s.equals("")){
      if (s.equalsIgnoreCase("Y")){
        isDocumentCompleted = "true";
      }else{
        isDocumentCompleted = "false";
      }
    }
    //State Office Concurrence
    s = nonComplianceSO.getIndStOffCon();
    if(s != null && !s.equals("")){
      if (s.equalsIgnoreCase("Y")){
        isStOffCon = "true";
      }else{
        isStOffCon = "false";
      }
    }   
	//Get the Security Attribute for State office Concurrence
	s = nonComplianceSO.getSecurityStCpaCon();
	if(s != null && !s.equals("")){
      if (s.equalsIgnoreCase("Y")){
        isSecStCpaCon = false;
      }else{
        isSecStCpaCon = true;
      }
    }   
    //Get the Policy Violation list
    if(nonComplianceSO.getNcCbx() != null && nonComplianceSO.getNcCbx().size() > 0){
     
     iter = nonComplianceSO.getNcCbx().iterator();
	 while ( iter.hasNext() ){
	   NcCbx ncCbx = (NcCbx)iter.next();
	   polVioList.add(ncCbx.getCdNonComplianceCbx());
	 }
     // policyViolationList = Arrays.asList(PolVioList);
    }
    //Get Event Status
    if (nonComplianceSO.getNcEvent() != null){
	    s = nonComplianceSO.getNcEvent().getEventStatusCode();
	    if(s != null && !s.equals("")){
	      eventStatus = s;
	    }else{
	      eventStatus = "";
	    }
    }else {
    	eventStatus = "";
    }
  }
  
  if(eventStatus.equals("")){
    eventStatus = CodesTables.CEVTSTAT_NEW;
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
boolean save = true;
boolean saveAndSubmit = true;
boolean docExists = false;
boolean bDocCompleted = false;
boolean bDtAchieved = false;
boolean bResultsDesc = false;
boolean bProtectFormDocument = false;

//-- one String to represent if fields should be disabled
String disableFields = "false";
if( ArchitectureConstants.TRUE.equals( request.getAttribute( CorrectiveActionPlanConversation.DOCEXISTS) ) )
{
    docExists = true;
}

    
String rej = (String) request.getAttribute("approvalRejected");
if( pageMode.equals(PageModeConstants.NEW) ||
    pageMode.equals(PageModeConstants.NEW_USING) ||
  (!eventStatus.equals(CodesTables.CEVTSTAT_PEND) &&
   !eventStatus.equals(CodesTables.CEVTSTAT_APRV) &&
   !"true".equals(rej))){
    approvalStatus = false;
}
if(eventStatus.equals(CodesTables.CEVTSTAT_COMP)){
	bDocCompleted = true;
}
if(eventStatus.equals(CodesTables.CEVTSTAT_APRV)){
  saveAndSubmit = false;
  bDocCompleted = true;
  bDtAchieved = false;
  bResultsDesc = false;
  isSecStCpaCon = true;
  disableFields = "true";
}
if(eventStatus.equals(CodesTables.CEVTSTAT_PEND)){
  saveAndSubmit = false;
  bDocCompleted = true;
}

if(PageModeConstants.VIEW.equals(pageMode)){
saveAndSubmit = false;
}
%>
<impact:validateErrors/>
<impact:validateForm 
  name="frmPolViolation"
  method="post"
  action="/fad/PolicyViolation/displayPolicyViolation"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.fad.PolicyViolationCustomValidation"
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
        form="frmPolViolation"
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
<table border="0" cellspacing="0" cellpadding="2" width="100%" class="tableBorder">
<tr>
  <th colspan="<%= entireColspan + 1%>">Policy Violation Report</th>
</tr>
<tr>
  <td>
    Home Type:
  </td>
  <td>
    <%=homeType %>
  </td>
</tr>
<tr>
  <td>
    <%
    //----------------------------------
    //--- Staffing Date ---
    //----------------------------------
    %>
    <impact:validateDate
      name="txtDtAchievement"
      tabIndex="<%= tabIndex++ %>"
      label="Staffing Date"
      size="7"
      constraint="Date"
      disabled="<%= String.valueOf(bDtAchieved) %>"
      value="<%= dateAchievement %>"
    />
  </td>
   <td>
    <%
    //----------------------------------
    //--- Document Completed ---
    //----------------------------------
    %>
    <impact:validateInput
      name="cbxDocumentCompleted"
      tabIndex="<%= tabIndex++ %>"
      label="Document Completed"
      type="checkbox"
      checked="<%= isDocumentCompleted %>"
      disabled="<%= String.valueOf(bDocCompleted) %>"
    />
  </td>
   <td>
    <%
    //----------------------------------
    //--- State Office Concurrence ---
    //----------------------------------
    %>
    <impact:validateInput
      name="cbxIndStOffCon"
      tabIndex="<%= tabIndex++ %>"
      label="State Office Concurrence"
      type="checkbox"
      checked="<%= isStOffCon %>"
      disabled="<%= String.valueOf(isSecStCpaCon) %>"
    />
  </td>
</tr>
<tr>
  <td>
    <%
    //----------------------------------
    //--- Staffing Outcomes ---
    //----------------------------------
    %>
    <impact:validateTextArea
      name="txtResultsDescription"
      label="Staffing Outcomes"
      title="Staffing Outcomes"
      colspan="4"
      rows="6"
      cols="130"
      maxLength="1000"
      editableMode="<%= EditableMode.ALL %>"
      tabIndex="<%= tabIndex++ %>"
      disabled="<%= String.valueOf(bResultsDesc) %>"
      constraint="Paragraph1000">
    <%= FormattingHelper.formatString( resultsDesc ) %>
    </impact:validateTextArea>
  </td>
</tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tr>
  <td>
    <%
    //----------------------------------
    //--- County of Violation ---
    //----------------------------------
    %>  
    <impact:validateSelect
      name="countyOfViolation"
      tabIndex="<%= tabIndex++ %>"
      label="County of Violation"
      codesTable="<%= CodesTables.CCOUNT %>"
      required="true"
      blankValue="true"
      value="<%= county %>"
      disabled="<%= disableFields %>"
    />
  </td>
  <td>
    <%
    //----------------------------------
    //--- Violation Date ---
    //----------------------------------
    // STGAP00009837 - change this field to be required field
    %>   
    <impact:validateDate
      name="txtDtViolation"
      tabIndex="<%= tabIndex++ %>"
      label="Violation Date"
      size="7"
      constraint="Date"
      required="true"
      value="<%= violationDate %>"
      disabled="<%= disableFields %>"
    />
  </td>  
</tr>
</table>


<table border="0" cellspacing="0" cellpadding="2" width="100%" class="tableBorder">
	<tr>
	  <td width="50%">
	    <table border="0" cellpadding="2" cellspacing="0" width="100%" height="135" class="tableborder">
	      <tr>
		<th>Children in the Home</th>
	      </tr>
	      <tr>
		<td colspan="2">
		  <div style="overflow:auto; WIDTH: 375px; HEIGHT: 135px" class="tableborderList">
		    <table border="0" cellpadding="3" cellspacing="0" width="100%" >
		      <tr>
				<th class="thList">Name</th>
				<th class="thList">Involved In<br>Violation</th>
				<th class="thList">In Adoptive<br>Process</th>
		      </tr>
                <%
	                //------------------------------
	                //--- Children in the Home ---
	                //------------------------------
	                // Iterate through the Children and display.
	                loopCounter = 0;
	                String isSelectedHV = null;
	                String isSelectedAP = null;
	                iter = nonComplianceSO.getChildrenInHome().iterator();
	                while ( iter.hasNext() ){
	                  NcPerson ncPerson = (NcPerson)iter.next();
	                  isSelectedHV = ncPerson.getIndHomeViolation();
	                  isSelectedAP = ncPerson.getIndAdoptiveProcess();
	                  String checkboxHomeViolation = "cbxHomeViolation_" + loopCounter;
	                  String checkboxAdoptiveProcess = "cbxAdoptiveProcess_" + loopCounter;
                %>
                <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
                  <td><%= ncPerson.getNmPersonFull() %></td>
                  <td>
                      <impact:validateInput
                        type="checkbox"
                        name="<%= checkboxHomeViolation %>"
                        value="<%= String.valueOf( ncPerson.getIdPerson() ) %>"
                        checked="<%= isSelectedHV %>"
                        editableMode="<%= EditableMode.ALL %>"
                        tabIndex="<%= tabIndex++ %>"
                        disabled="<%= disableFields %>"
                        cssClass="formInput"/>
                  </td>
                  <td>
                      <impact:validateInput
                        type="checkbox"
                        name="<%= checkboxAdoptiveProcess %>"
                        value="<%= String.valueOf( ncPerson.getIdPerson() ) %>"
                        checked="<%= isSelectedAP %>"
                        editableMode="<%= EditableMode.ALL %>"
                        tabIndex="<%= tabIndex++ %>"
                        disabled="<%= disableFields %>"
                        cssClass="formInput"/>
                  </td>                  
                </tr>
                <%
                  loopCounter++;
                } // end while ( iter.hasNext() )
                %>	                	      
		    </table>
		  </div>
		</td>
	      </tr>
	    </table>
	  </td>
	  <td width="50%">
	    <table border="0" cellpadding="2" cellspacing="0" width="100%" height="135" class="tableborder">
	      <tr>
		<th><span class="formRequiredText">*</span>Policy Violation</th>
	      </tr>
	      <tr>
		<td colspan="2">
		  <div style="overflow:auto; WIDTH: 375px; HEIGHT: 135px" class="tableborderList">
		    <table border="0" cellpadding="3" cellspacing="0" width="100%" >
				<tr>
				  <td colspan="<%= entireColspan %>">
				    <impact:codesCheckbox
				      name="cbxPolViolation_"
				      tabIndex="<%= tabIndex++ %>"
				      codesTableName="<%= CodesTables.CPOLVIOL %>"
				      columns="1"
				      disabled="<%= disableFields %>"
				      defaultCodes="<%= polVioList %>"
				    />
				  </td>
				</tr>
		    </table>
		  </div>
		</td>
	      </tr>
	    </table>
	  </td>  
	</tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tr>
  <td>
    <%
    //----------------------------------
    //--- Last Update Date ---
    //----------------------------------
    %>
    Last Update Date: &nbsp;&nbsp; <%= dtLastUpdate %>
  </td>
</tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>
  <td>
  </td>
  <td>
    <div class="alignRight">
      <%= SPACES %>
<%
if(saveAndSubmit){
%>
      <impact:ButtonTag
        name="btnSaveAndSubmit"
        tabIndex="<%= tabIndex++ %>"
        img="btnSaveAndSubmit"
        editableMode="<%= EditableMode.ALL %>"
        form="frmPolViolation"
        restrictRepost="true"
        action="/fad/PolicyViolation/saveSubmitPolicyViolation"
      />
<%
} else{
%><%= SPACES %><%
}
%>
<%
if(save){
%>
      <impact:ButtonTag
        name="btnSave"
        tabIndex="<%= tabIndex++ %>"
        img="btnSave"
        restrictRepost="true"
        form="frmPolViolation"
        action="/fad/PolicyViolation/savePolicyViolation"
      />
<%
} else{
  out.print(SPACES);
}
%>
    </div>
  </td>
</tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<table>
<tr><td>

<impact:documentButton pageMode="<%= pageMode %>"
                               buttonUrl="/grnds-docs/images/shared/btnDocument.gif"
                               tabIndex="<%= tabIndex++ %>"
                               accessKey="W" >
                               
       <impact:document displayName="Policy Violation Document"
                    protectDocument="<%= bProtectForm %>"
                    checkForNewMode="true"
                    docType="cfa09o00"
                    preFillAlways="true"
                    docExists="<%= docExists %>" >
                    <impact:documentParameter name="pCase"
                               value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>  
                    <impact:documentParameter name="pStage"
                               value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/> 
                    <impact:documentParameter name="pEvent"
                               value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>   
                               
                     <impact:documentParameter name="pNonCompliance"
                               value="<%= String.valueOf(nonComplianceSO.getIdNonCompliance()) %>"/>                                                                                
                    <impact:documentParameter name="sEvent"
                               value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>               
                    <impact:documentParameter name="sCase"
                               value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>   

            </impact:document>
    </impact:documentButton>
</td></tr>

</table>