<%
/**
 * JSP Name:     Contact Standards
 * Created by:   Herve Jean-Baptiste
 * Date Created: 02/13/2010
 *
 * <pre>
 * Description:
 * This page displays the Contact Standards page.
 *
 * Change History:
 * Date      User                    Description
 * --------  ---------------------   -----------------------------------------------
 * 02/13/10  hjbaptistre             Initial Creation
 * 02/18/10  bgehlot                 Adding business logic for pre-population of Parent Contact Rules from the Person Detail,
 *                                   and logic for all the other buttons on the Page.
 * 03/08/10  bgehlot                 Added the Copy Logic.
 * 03/11/10  hjbaptiste              MR-62: Display the children in the Contact For section in two columns instead of 1 column
 *                                   per row decreasing the amount of landscape needed to show the list of children.     
 * 03/17/10  bgehlot                 Formatting issue Fixed.
 * 05/26/10  bgehlot                 SMS#55249 Display Approval Status button in APRV status also
 * </pre>                          
 */
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSummarySO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBeanComparator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactForBeanComparator" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.util.*"%>
<% int tabIndex=1; 
   BaseSessionStateManager state = (BaseSessionStateManager)
          request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  ContactStandardsRetrieveSO contactStandardsRetrieveSO = 
              (ContactStandardsRetrieveSO) state.getAttribute("contactStandardsRetrieveSO", request); 

  //Set Page Mode and related variables for display
  String pageMode = PageMode.getPageMode(request);
  String cdEventStatus = contactStandardsRetrieveSO.getCdEventStatus();
  String szDisabled = "false";
  
  String evtsLastUpdate = StringHelper.EMPTY_STRING;

  evtsLastUpdate = DateHelper.toISOStringSafe(contactStandardsRetrieveSO.getDtEventLastUpdate());
	
  if(CodesTables.CEVTSTAT_APRV.equals(cdEventStatus) || PageModeConstants.VIEW.equals(pageMode)){
     szDisabled = "true";
  }

  String indSuperApproval = "";
    
  if(ArchitectureConstants.Y.equals(contactStandardsRetrieveSO.getIndSuperApproval())){
      indSuperApproval = "true";
    }else{
      indSuperApproval = "false";
  }
  
  List<ContactRuleBean> parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
  
  List<Map<String, Object>> personsManuallyAddedMapList = contactStandardsRetrieveSO.getPersonsManuallyAddedMapList(); 
  List<Option> personNameList = new ArrayList<Option>();  
  if(personsManuallyAddedMapList != null && !personsManuallyAddedMapList.isEmpty()){
     Iterator<Map<String, Object>> iterParent = personsManuallyAddedMapList.iterator();
      while (iterParent.hasNext()) {
        Map<String, Object> map = (Map<String, Object>) iterParent.next();
        personNameList.add(new Option(String.valueOf((Integer)map.get("idPerson")),(String)map.get("nmPersonFull")));
      }
  }
  personNameList.add(new Option(CodesTables.CUNPRENT_UM, Lookup.simpleDecodeSafe(CodesTables.CUNPRENT, CodesTables.CUNPRENT_UM)));
  personNameList.add(new Option(CodesTables.CUNPRENT_UF, Lookup.simpleDecodeSafe(CodesTables.CUNPRENT, CodesTables.CUNPRENT_UF)));
  
  state.setAttribute("personNameList", personNameList,request);
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<% /* Start Javascript Section */ %>
<script type="text/javascript" language="JavaScript1.2">
  
  /*
   * This function is called before the page loads. It disables
   * the Add and the Delete buttons since the record hasn't been inserted yet.
   */
window.onload = function ()
{
  disabbleAddAndDelete ();
}

function disabbleAddAndDelete () {
  var x = document.frmContactStd;
  if ('NEW' == '<%=cdEventStatus%>') {
    x.btnAdd.disabled = true;
    x.btnDelete.disabled = true;
  }
}

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  }
  
  function confirmDelete(){
  <%
    int size = 0;
    if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
      size=parentContactRuleBeanList.size();
    }
   %>
    for(var i = 0; i < <%=size%>; i++){
      var delCheckBox = "delCheckBox_" + i;
      if(eval("document.frmContactStd." + delCheckBox + ".checked") == true){
          if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CS_PCR_DELETE)%>') == true){
            return true;
          }else{
            return false;
          }
       }
    }
    return true;
  }
  
  function confirmChildNbrContactsPerMonth(){
  // User enters zero for # of Contacts per Month in Child Contact Rules Section and clicks on Save and Submit
  // button.
  <% List<ContactRuleBean> childContactRuleBeanList1 = contactStandardsRetrieveSO.getChildContactRuleBeanList();
     int size1 = 0;
     if(childContactRuleBeanList1 != null && !childContactRuleBeanList1.isEmpty()){
      size1=childContactRuleBeanList1.size();
    }
  %>
   var isConfirm = false;
   var persons = "";
   
   for(var i = 0; i < <%=size1%>; i++){
      var nbrChildContactsPerMonth = "nbrChildContactsPerMonth" + i;
      var nmChild = "nmChild" + i;
      if(eval("document.frmContactStd." + nbrChildContactsPerMonth + ".value") == 0){
          var e = eval("document.frmContactStd." + nmChild + ".value"); 
            persons = persons + e + " ";
            isConfirm = true;
       }
    }
    if(isConfirm == true){
     var message = '<%=MessageLookup.getMessageByNumber(Messages.MSG_CS_CHILD_CONTACT_RULE_ZERO)%>';
     var newMessage = message.replace("%s",persons)
     if (confirm(newMessage) == true){
            return true;
          }else{
            return false;
        }
    }else{
   return true;
   }
  }
</script>

<impact:validateErrors />

<impact:validateForm name="frmContactStd"
                     method="post"
                     action="/contacts/ContactStandards/displayContactStandards"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactStandardsCustomValidation"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">
                     
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
<input type="hidden" name="evtsLastUpdate" value="<%=evtsLastUpdate%>">
<%
if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)) && !PageModeConstants.NEW_USING.equals(pageMode)) {
	String action = ApprovalStatusConversation.DISPLAY_URI;
	//SMS#55249 Display Approval Status button in APRV status also
	String disableApprovalStatus = ArchitectureConstants.TRUE;
	if (CaseUtility.hasBeenSubmittedForApproval(GlobalData
					.getUlIdEvent(request))) {
				disableApprovalStatus = ArchitectureConstants.FALSE;
			}
    int editableMode = EditableMode.NEW + EditableMode.MODIFY;
    if (PageModeConstants.VIEW.equals(pageMode)) {
		editableMode = EditableMode.NONE;
	}
	
	if (GlobalData.isApprovalMode(request)) {
	        action = "/contacts/ContactStandards/submitApproval";
	}
%>
    <table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
				<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmContactStd" action="<%=action%>"
				    navAwayCk="true" disabled="<%=disableApprovalStatus%>" editableMode="<%=EditableMode.ALL%>" 
					tabIndex="<%=tabIndex%>" />
			</td>
		</tr>
    </table>
<%} %>
	<br>
<%-- Begin Case Information--%>
<%
ContactStandardsSummarySO contactStandardsSummarySO = 
              (ContactStandardsSummarySO) state.getAttribute("contactStandardsSummarySO", request); 
 %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="5">Parent Contact Rules Summary</th>
  </tr>
  <tr>
    <td width="16%" class="thList">Child</td>
    <td width="21%" class="thList">Father</td>
    <td width="21%" class="thList">Mother</td>
    <td width="21%" class="thList">Caretaker</td>
    <td width="9%" class="thList">Complete?</td>
  </tr>
  <tr>
 <%
if (contactStandardsSummarySO == null) {
  contactStandardsSummarySO = new ContactStandardsSummarySO();
}
// Get the two dimensional array and populate the Contact Standards Summary section
String[][] contactStandardsSummary = contactStandardsSummarySO.getContactStandardsSummary();
String nmChildFull = "";
String nmFatherFull = "";
String nmMotherFull = "";
String nmCaretakerFull = "";
String indRuleComplete = "";
String indContactStandardsComplete = contactStandardsSummarySO.getIndContactStandardsComplete();

if(contactStandardsSummary != null){
for (int i = 0; i < contactStandardsSummary.length; i++) {
// Alternate the color of the rows base on the loop index being an even or odd number
String tableRowClass = FormattingHelper.getRowCss(i + 1);
%>
<tr class="<%=tableRowClass%>">
<%
  for (int j = 0; j < contactStandardsSummary[i].length; j++) {
    switch (j) {
       case 0:
         nmChildFull = contactStandardsSummary[i][j];
%> 
         <td width="16%"><%=nmChildFull%></td>
<%         
         break;
       case 1:
         nmFatherFull = contactStandardsSummary[i][j];
%>         
         <td width="21%"><%=nmFatherFull%></td>
<%          
         break;
       case 2:
         nmMotherFull = contactStandardsSummary[i][j];
%>       
         <td width="21%"><%=nmMotherFull%></td>
<%           
         break;
       case 3:
         nmCaretakerFull = contactStandardsSummary[i][j];
%>
         <td width="21%"><%=nmCaretakerFull%></td>
<%        
         break;
       case 4:
         indRuleComplete = contactStandardsSummary[i][j];
         // If the Complete column is set with a 'Y', display the checkmark image or else
         // display an empty column
         if (ArchitectureConstants.Y.equals(indRuleComplete)) {
%>
           <td width="9%">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif">
           </td>
<%       } else {
%>
           <td width="10%">&nbsp;</td>
<%          
         }
         break;
       default:
       break;
    }    
  }
%>
</tr>
<%  
} 
}
%>   

</table>
<input type="hidden" name="indContactStandardsComplete" value="<%=indContactStandardsComplete%>">
<%-- End Summary --%>
<br/>

<%-- Begin Contact Standard Detail --%>

<table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
   <tr>
      <th colspan="6" class="thList">Parent Contact Rules</th>
   </tr>
   
<% 
List<ContactForBean> contactForBeanList = new ArrayList<ContactForBean>();
parentContactRuleBeanList = contactStandardsRetrieveSO.getParentContactRuleBeanList();
if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
int loopCounter = 1;
int i=0;
Iterator<ContactRuleBean> iterParent = parentContactRuleBeanList.iterator();
      while (iterParent.hasNext()) {
        ContactRuleBean contactRuleBean = (ContactRuleBean) iterParent.next();
        String tableRowClass = FormattingHelper.getRowCss(loopCounter++);
        String tableRowClassNext = FormattingHelper.getRowCss(loopCounter);
        int idParentContactRule = contactRuleBean.getUlIdContactRule();
        String nmPerson = "nmPerson" + i;
        // Not all Parent Contact Rules are for person with an id_person. If the id_person is set to zero,
        // 'Unknown Mother' or 'Unknown Father' needs to be displayed base on the user's selection 
        String nmPersonValue = FormattingHelper.formatString(String.valueOf(contactRuleBean.getUlIdPerson()));
        if(!ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated())){
          if (contactRuleBean.getCdUnknownParent() != null && contactRuleBean.getUlIdPerson() == 0) {
             nmPersonValue = contactRuleBean.getCdUnknownParent();
          } else if (contactRuleBean.getCdUnknownParent() == null && contactRuleBean.getUlIdPerson() == 0) {
             nmPersonValue = "";
          } 
          else {
            nmPersonValue = FormattingHelper.formatString(String.valueOf(contactRuleBean.getUlIdPerson()));
          }
        }
        String cdPersonRole = "cdPersonRole" + i;
        String nbrParentContactsPerMonth = "nbrParentContactsPerMonth" + i;
        String indByFaceToFace = "indByFaceToFace_" + i;
        String indByTelephone = "indByTelephone_" + i;
        String indByEmailCorrspndnce = "indByEmailCorrspndnce_" + i;
        String cdContactNotRequired = "cdContactNotRequired" + i;
        String txtJustification = "txtJustification" + i;
        String delCheckBox = "delCheckBox_" + i;
        
        String contactForDisabled  = "";
        if(ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated()) || StringHelper.isTrue(szDisabled)){
	      contactForDisabled = "true";
	    }
	    
        String indByFaceToFaceVal = "";
        String indByTelephoneVal = "";
        String indByEmailCorrspndnceVal = "";
          
	    if(ArchitectureConstants.Y.equals(contactRuleBean.getIndByFaceToFace())){
	      indByFaceToFaceVal = "true";
	      }else{
	      indByFaceToFaceVal = "false";
	    }
	  
	    if(ArchitectureConstants.Y.equals(contactRuleBean.getIndByTelephone())){
	      indByTelephoneVal = "true";
	      }else{
	      indByTelephoneVal = "false";
	    }
	  
	    if(ArchitectureConstants.Y.equals(contactRuleBean.getIndByEmailCorrspndnce())){
	      indByEmailCorrspndnceVal = "true";
	      }else{
	      indByEmailCorrspndnceVal = "false";
	    }
	    
	    String nbrParentContactsPerMonthVal = "";
           String cdStage = GlobalData.getSzCdStage(request);
           if (CodesTables.CSTAGES_FSU.equals(cdStage) && CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)
               && !CodesTables.CCONNREQ_DEC.equals(contactRuleBean.getCdContactNotRequired())
               && !CodesTables.CCONNREQ_NRU.equals(contactRuleBean.getCdContactNotRequired())) {
             nbrParentContactsPerMonthVal = "1";
           } else if (CodesTables.CSTAGES_FSU.equals(cdStage) && CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)
                      && contactRuleBean.getCdUnknownParent() == null && contactRuleBean.getUlIdPerson() == 0) {
             nbrParentContactsPerMonthVal = "1";
           } else {
             nbrParentContactsPerMonthVal = String.valueOf(contactRuleBean.getNbrContactsPerMonth());
           }

%>
   <tr class="<%=tableRowClass%>">
   <td  colspan="6">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
     <tr>
      <td width="4%">
         <impact:validateInput type="checkbox" name="<%=delCheckBox%>" disabled="false"  checked="N" value="Y"/>
      </td>
<%if(ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated())){ %>
  	  <td class="aligLeft">
    	 <impact:validateSelect
            label="Name"
            name="<%=nmPerson%>"
            value="<%=FormattingHelper.formatString(contactRuleBean.getNmPersonFull())%>"
            disabled="true"
            tabIndex="<%=tabIndex++%>"
            required="true"/>
  	 </td>
<%}else{ %>
    <td class="aligLeft">
    	 <impact:validateSelect
            label="Name"
            name="<%=nmPerson%>"
            value="<%=nmPersonValue%>"
            options="<%=personNameList%>"
            disabled="<%=szDisabled %>"
            tabIndex="<%=tabIndex++%>"
            required="true"/>
  	 </td>
<%} %>
     <td class="alignLeft">
        <impact:validateDisplayOnlyField
           label="Parental Role"
           name="<%=cdPersonRole%>"
           value="<%=Lookup.simpleDecodeSafe( CodesTables.CPARROLE, contactRuleBean.getCdPersonRole())%>"
           />
  	 </td>
  </tr>
  <tr>
     <td>&nbsp;</td>
  	 <td class="alignLeft">
        <impact:validateInput 
           type="text"
           label="# of Contacts per Month"
           required="true"
           name="<%=nbrParentContactsPerMonth%>"
           cssClass="formInput"
           value="<%=nbrParentContactsPerMonthVal%>"
           size="2"
           maxLength="2"
           disabled="<%=szDisabled %>"
           tabIndex="<%= tabIndex++ %>"/>
     </td>
     <td colspan="2">
           <span class="formCondRequiredText">&#135;</span><span style="align:middle"> Contact Methods: </span>
           <impact:validateInput name="<%=indByFaceToFace%>" checked="<%=indByFaceToFaceVal%>" type="checkbox" label="" value="Y" disabled="<%=szDisabled %>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
           <img align="bottom" alt="By Face to Face" src="/grnds-docs/images/shared/face2face_icon.jpg">
           &nbsp;
           <impact:validateInput name="<%=indByTelephone%>" checked="<%=indByTelephoneVal%>" type="checkbox" label="" value="Y" disabled="<%=szDisabled %>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
           <img align="bottom" alt="By Telephone" src="/grnds-docs/images/shared/phone_icon.jpg">
           &nbsp;
           <impact:validateInput name="<%=indByEmailCorrspndnce%>" checked="<%=indByEmailCorrspndnceVal%>" type="checkbox" label="" value="Y" disabled="<%=szDisabled %>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
           <img align="bottom" alt="By Email/Correspondence" src="/grnds-docs/images/shared/mail_icon.jpg">
     </td>
     </tr>     
     </table>
     </td>
   </tr>

   <tr class="<%=tableRowClass%>">
   
    <td width="4%">&nbsp;</td>
   	<td colspan="3" width="50%">
 
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
					<tr>
						<th colspan="2">
							Contact Not Required:
						</th>
					</tr>
					<tr>
						<td colspan="2">
							<impact:validateSelect
                        	label=""
            				name="<%=cdContactNotRequired%>"
            				codesTable="CCONNREQ"
            				value="<%=FormattingHelper.formatString(contactRuleBean.getCdContactNotRequired())%>"
            				disabled="<%=szDisabled %>"
            				tabIndex="<%=tabIndex++%>"
            				conditionallyRequired="true"/>
                        </td>					
					</tr>
        			<tr>
						<td>
							<span class="formCondRequiredText">&#135;</span>Justification:
						</td>
						<td>&nbsp;
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<impact:validateTextArea name="<%=txtJustification%>"
								title="Justification"
								colspan="1" rows="3" cols="65" maxLength="1000"
								tabIndex="<%=tabIndex++%>"
								disabled="<%=szDisabled %>"
								constraint="Paragraph1000">	
								<%=FormattingHelper.formatString(contactRuleBean.getTxtJustification())%>							
							</impact:validateTextArea>
						</td>
					</tr>

		</table>
    
    </td>

    
   	<td colspan="2">
			<!-- Start Contact For Block-->
		<div style="overflow:auto; WIDTH: 365px; HEIGHT: 129px" class="tableborderList">
			<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<tr>
						<th colspan="2"  width="100%" class="thList">
							<span class="formRequiredText">*</span>Contact For:
						</th>
					</tr>

<%                    
                      int idContactRule = contactRuleBean.getUlIdContactRule(); 
				      contactForBeanList = contactRuleBean.getChildContactForBeanList();
				      ContactForBeanComparator comparator = new ContactForBeanComparator(); 
				      if(contactForBeanList != null && !contactForBeanList.isEmpty()){
				        Collections.sort(contactForBeanList, comparator);
				        Iterator<ContactForBean> iterContactFor = contactForBeanList.iterator();
				        int j = 0;
				        while (iterContactFor.hasNext()) {
				        ContactForBean contactForBean = (ContactForBean) iterContactFor.next();			
				        String idChild = "" + contactForBean.getUlIdChild();
				        String cbxIndContactFor = "cbxIndContactFor" + i + "_" + j;
				        String indContactFor = "";
                        if(ArchitectureConstants.Y.equals(contactForBean.getIndContactFor())){
	                       indContactFor = "true";
	                    }else{
	                       indContactFor = "false";
	                  }
	                  int rem = 0;
                      if ((rem = (j+1)%2) != 0 ){
%>
						<tr>
						    <td width="50%">
								<impact:validateInput name="<%=cbxIndContactFor%>" checked="<%=indContactFor%>" type="checkbox" label="" value="<%=idChild%>" disabled="<%=contactForDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
								<%= contactForBean.getNmPersonFull() %>
							</td>
<% 				        
						if (!iterContactFor.hasNext()) {
						
%>							
                          <td>&nbsp;</td>
						</tr>
<%		  
				         } 
				       } else {
%>
                       <td width="50%">
								<impact:validateInput name="<%=cbxIndContactFor%>" checked="<%=indContactFor%>" type="checkbox" label="" value="<%=idChild%>" disabled="<%=contactForDisabled%>" tabIndex="<%=tabIndex++%>" cssClass="formInput" />
								<%= contactForBean.getNmPersonFull() %>
							</td>
					    </tr>
<%
					   }				       
				    j++;
				             }
				          }
%>
			</table>
		</div>
				<!-- End table PRN -->
	</td>
	</tr>
<%i++;
 } //while end
} //If end %>
<!-- Save & Delete Buttons -->
<% 
  if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
%>
	<tr>
		<td colspan="6">
			<table border="0" cellspacing="0" cellpadding="3" width="100%">
				<tr>			
					<td width="80%">
    					&nbsp;
					</td>
					<td align="right">
						<impact:ButtonTag name="btnAddContactRule" img="btnAdd" form="frmContactStd" align="right" action="/contacts/ContactStandards/addContactRule"
						preventDoubleClick="true" disabled="<%=szDisabled %>" onClick="IsDirty()" tabIndex="<%=tabIndex++%>"/>
					</td>
					<td align="right">
						<impact:ButtonTag name="btnDelete" img="btnDelete" form="frmContactStd" align="right" action="/contacts/ContactStandards/deleteContactRules"
						preventDoubleClick="true" disabled="<%=szDisabled %>"  function="return confirmDelete();" tabIndex="<%=tabIndex++%>"/>
					</td>
				</tr>	
			</table>
		</td>
	</tr>
<% } else {%>
   <tr>
		<td colspan="6">&nbsp;</td>
   </tr>
<% }%>

</table>

<%-- Begin Child Contact Standard --%>

<table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
   <tr>
      <th colspan="4" class="thList">Child Contact Rules</th>
   </tr>
   	<% 
     List<ContactRuleBean> childContactRuleBeanList = contactStandardsRetrieveSO.getChildContactRuleBeanList();
     ContactRuleBeanComparator ruleBeanComparator = new ContactRuleBeanComparator();
     if(childContactRuleBeanList != null && !childContactRuleBeanList.isEmpty()){
     Collections.sort(childContactRuleBeanList, ruleBeanComparator);
     int i=0;
     Iterator<ContactRuleBean> iterChild = childContactRuleBeanList.iterator();
      while (iterChild.hasNext()) {
        ContactRuleBean contactRuleBean = (ContactRuleBean) iterChild.next();
        String nbrChildContactsPerMonth = "nbrChildContactsPerMonth" + i;
        String nmChild = "nmChild" + i;
        String nbrParentContactsPerMonthVal = "";
	    String cdStage = GlobalData.getSzCdStage(request);
	    if((CodesTables.CSTAGES_FSU.equals(cdStage) || CodesTables.CSTAGES_FPR.equals(cdStage) )&& CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)){
	      nbrParentContactsPerMonthVal = "1";
	    }else{
	      nbrParentContactsPerMonthVal = String.valueOf(contactRuleBean.getNbrContactsPerMonth());
	    }
    %>    
   <tr>
     <td width="35%">
     <impact:validateDisplayOnlyField name="<%=nmChild%>" 
					label="" value="<%= contactRuleBean.getNmPersonFull() %>" />     
     </td>
     <td width="35%">
        <impact:validateInput 
          type="text"
          label="# Face to Face Contacts per Month"
          required="true"
          name="<%=nbrChildContactsPerMonth%>"
          cssClass="formInput"
          value="<%=nbrParentContactsPerMonthVal%>"
          size="2"
          maxLength="2"
          disabled="<%=szDisabled %>"
          tabIndex="<%= tabIndex++ %>"/>
     </td>
   </tr>
   <% i++;
    }
   } %>
</table>				

<br>

<%-- Begin Change Justification--%>
<%
//If the Copy button is clicked do not copy the Reason For change and the Case Manager Acknowledment checkbox
 String txtReasonForChange = "";
 String indCmAcknowledge = "";
 if(!PageModeConstants.NEW_USING.equals(pageMode)){
   txtReasonForChange = FormattingHelper.formatString(contactStandardsRetrieveSO.getTxtReasonForChange());
   indCmAcknowledge = contactStandardsRetrieveSO.getIndCmAcknowledge();  
 }
 %>
<table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
   <tr>
      <th><span class="formRequiredText">*</span>Reason for change in Contact Standards: (Use n/a for initial contact standards)</th>
   </tr>
	<tr>
		<td>
			<impact:validateTextArea name="txtReasonForChange"
					title="Reason for Change in Contact Standards (Use n/a for initial contact standards)"
					colspan="1" rows="3" cols="80" maxLength="1000"
					tabIndex="<%=tabIndex++%>"
					disabled="<%=szDisabled %>"
					constraint="Paragraph1000"><%=txtReasonForChange%>							
			</impact:validateTextArea>
		</td>
	</tr>
	<tr>
 	 <td>
		<impact:validateInput 
		  type="checkbox" 
		  id="indCmAcknowledge" 
		  tabIndex="<%= tabIndex++ %>" 
		  name="indCmAcknowledge" 
		  value="Y"
		  label="I understand that child safety maybe greatly impacted by my decision" 
		  checked="<%=indCmAcknowledge%>" 
		  disabled="<%=szDisabled %>" />
		</td>
	</tr>
</table>	
<br/>

<%-- Begin Supervisor Certification --%>
<% 
String isCurrentApprover = String.valueOf(contactStandardsRetrieveSO.isCurrentApprover());
String supApprovalDisabled = "";
if ("false".equals(isCurrentApprover) || StringHelper.isTrue(szDisabled)) {
  supApprovalDisabled = "true";
}
if((CodesTables.CEVTSTAT_PEND.equals(cdEventStatus) || CodesTables.CEVTSTAT_APRV.equals(cdEventStatus))){%>
	<table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
	   <tr>
	      <th class="thList">Supervisor Approval</th>
	   </tr>
	
	   <tr>
	   <td>
	  <impact:validateInput 
	    type="checkbox" 
	    id="indSuperApproval" 
	    tabIndex="<%= tabIndex++ %>" 
	    name="indSuperApproval" 
	    value="Y"
	    label="I acknowledge that I have addressed Safety Threats, Child Vulnerability and Parent Protective Capacity prior to approving the established contact standards." 
	    checked="<%=indSuperApproval%>" 
	    disabled="<%=supApprovalDisabled%>" />
	  </td>
	 </tr>
	</table>
<%} %>
			

<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>
	<td width="75%">
    	&nbsp;
	</td>
<% 
  if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus) && !CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {
%>  
	<td align="right">
		<impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit" form="frmContactStd" align="right" action="/contacts/ContactStandards/saveSubmitContactStandards"
		restrictRepost="true" preventDoubleClick="true" disabled="<%=szDisabled %>"  function="return confirmChildNbrContactsPerMonth();" tabIndex="<%=tabIndex++%>"/>
	</td>
<% }%>	
	<td align="right">
		<impact:ButtonTag name="btnSave" img="btnSave" form="frmContactStd" align="right" action="/contacts/ContactStandards/saveContactStandards"
		restrictRepost="true" preventDoubleClick="true" disabled="<%=szDisabled %>" tabIndex="<%=tabIndex++%>"/>
	</td>
	
</tr>
</table>
	
</impact:validateForm>