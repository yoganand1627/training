package org.apache.jsp.grnds_002ddocs.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactStandardsSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactForBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactRuleBeanComparator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactForBeanComparator;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import java.util.*;

public final class ContactStandards_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 int tabIndex=1; 
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

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n");
 /* Start Javascript Section */ 
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  \r\n  /*\r\n   * This function is called before the page loads. It disables\r\n   * the Add and the Delete buttons since the record hasn't been inserted yet.\r\n   */\r\nwindow.onload = function ()\r\n{\r\n  disabbleAddAndDelete ();\r\n}\r\n\r\nfunction disabbleAddAndDelete () {\r\n  var x = document.frmContactStd;\r\n  if ('NEW' == '");
      out.print(cdEventStatus);
      out.write("') {\r\n    x.btnAdd.disabled = true;\r\n    x.btnDelete.disabled = true;\r\n  }\r\n}\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  }\r\n  \r\n  function confirmDelete(){\r\n  ");

    int size = 0;
    if(parentContactRuleBeanList != null && !parentContactRuleBeanList.isEmpty()){
      size=parentContactRuleBeanList.size();
    }
   
      out.write("\r\n    for(var i = 0; i < ");
      out.print(size);
      out.write("; i++){\r\n      var delCheckBox = \"delCheckBox_\" + i;\r\n      if(eval(\"document.frmContactStd.\" + delCheckBox + \".checked\") == true){\r\n          if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CS_PCR_DELETE));
      out.write("') == true){\r\n            return true;\r\n          }else{\r\n            return false;\r\n          }\r\n       }\r\n    }\r\n    return true;\r\n  }\r\n  \r\n  function confirmChildNbrContactsPerMonth(){\r\n  // User enters zero for # of Contacts per Month in Child Contact Rules Section and clicks on Save and Submit\r\n  // button.\r\n  ");
 List<ContactRuleBean> childContactRuleBeanList1 = contactStandardsRetrieveSO.getChildContactRuleBeanList();
     int size1 = 0;
     if(childContactRuleBeanList1 != null && !childContactRuleBeanList1.isEmpty()){
      size1=childContactRuleBeanList1.size();
    }
  
      out.write("\r\n   var isConfirm = false;\r\n   var persons = \"\";\r\n   \r\n   for(var i = 0; i < ");
      out.print(size1);
      out.write("; i++){\r\n      var nbrChildContactsPerMonth = \"nbrChildContactsPerMonth\" + i;\r\n      var nmChild = \"nmChild\" + i;\r\n      if(eval(\"document.frmContactStd.\" + nbrChildContactsPerMonth + \".value\") == 0){\r\n          var e = eval(\"document.frmContactStd.\" + nmChild + \".value\"); \r\n            persons = persons + e + \" \";\r\n            isConfirm = true;\r\n       }\r\n    }\r\n    if(isConfirm == true){\r\n     var message = '");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CS_CHILD_CONTACT_RULE_ZERO));
      out.write("';\r\n     var newMessage = message.replace(\"%s\",persons)\r\n     if (confirm(newMessage) == true){\r\n            return true;\r\n          }else{\r\n            return false;\r\n        }\r\n    }else{\r\n   return true;\r\n   }\r\n  }\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContactStd");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/contacts/ContactStandards/displayContactStandards");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactStandardsCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n                     \r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n<input type=\"hidden\" name=\"evtsLastUpdate\" value=\"");
          out.print(evtsLastUpdate);
          out.write("\">\r\n");

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

          out.write("\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmContactStd");
          _jspx_th_impact_ButtonTag_0.setAction(action);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n    </table>\r\n");
} 
          out.write("\r\n\t<br>\r\n");
          out.write('\r');
          out.write('\n');

ContactStandardsSummarySO contactStandardsSummarySO = 
              (ContactStandardsSummarySO) state.getAttribute("contactStandardsSummarySO", request); 
 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"5\">Parent Contact Rules Summary</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"16%\" class=\"thList\">Child</td>\r\n    <td width=\"21%\" class=\"thList\">Father</td>\r\n    <td width=\"21%\" class=\"thList\">Mother</td>\r\n    <td width=\"21%\" class=\"thList\">Caretaker</td>\r\n    <td width=\"9%\" class=\"thList\">Complete?</td>\r\n  </tr>\r\n  <tr>\r\n ");

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

          out.write("\r\n<tr class=\"");
          out.print(tableRowClass);
          out.write("\">\r\n");

  for (int j = 0; j < contactStandardsSummary[i].length; j++) {
    switch (j) {
       case 0:
         nmChildFull = contactStandardsSummary[i][j];

          out.write(" \r\n         <td width=\"16%\">");
          out.print(nmChildFull);
          out.write("</td>\r\n");
         
         break;
       case 1:
         nmFatherFull = contactStandardsSummary[i][j];

          out.write("         \r\n         <td width=\"21%\">");
          out.print(nmFatherFull);
          out.write("</td>\r\n");
          
         break;
       case 2:
         nmMotherFull = contactStandardsSummary[i][j];

          out.write("       \r\n         <td width=\"21%\">");
          out.print(nmMotherFull);
          out.write("</td>\r\n");
           
         break;
       case 3:
         nmCaretakerFull = contactStandardsSummary[i][j];

          out.write("\r\n         <td width=\"21%\">");
          out.print(nmCaretakerFull);
          out.write("</td>\r\n");
        
         break;
       case 4:
         indRuleComplete = contactStandardsSummary[i][j];
         // If the Complete column is set with a 'Y', display the checkmark image or else
         // display an empty column
         if (ArchitectureConstants.Y.equals(indRuleComplete)) {

          out.write("\r\n           <td width=\"9%\">\r\n              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n           </td>\r\n");
       } else {

          out.write("\r\n           <td width=\"10%\">&nbsp;</td>\r\n");
          
         }
         break;
       default:
       break;
    }    
  }

          out.write("\r\n</tr>\r\n");
  
} 
}

          out.write("   \r\n\r\n</table>\r\n<input type=\"hidden\" name=\"indContactStandardsComplete\" value=\"");
          out.print(indContactStandardsComplete);
          out.write("\">\r\n");
          out.write("\r\n<br/>\r\n\r\n");
          out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n   <tr>\r\n      <th colspan=\"6\" class=\"thList\">Parent Contact Rules</th>\r\n   </tr>\r\n   \r\n");
 
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


          out.write("\r\n   <tr class=\"");
          out.print(tableRowClass);
          out.write("\">\r\n   <td  colspan=\"6\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n     <tr>\r\n      <td width=\"4%\">\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setName(delCheckBox);
          _jspx_th_impact_validateInput_0.setDisabled("false");
          _jspx_th_impact_validateInput_0.setChecked("N");
          _jspx_th_impact_validateInput_0.setValue("Y");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n");
if(ArchitectureConstants.Y.equals(contactRuleBean.getIndPrepopulated())){ 
          out.write("\r\n  \t  <td class=\"aligLeft\">\r\n    \t ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Name");
          _jspx_th_impact_validateSelect_0.setName(nmPerson);
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(contactRuleBean.getNmPersonFull()));
          _jspx_th_impact_validateSelect_0.setDisabled("true");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t </td>\r\n");
}else{ 
          out.write("\r\n    <td class=\"aligLeft\">\r\n    \t ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Name");
          _jspx_th_impact_validateSelect_1.setName(nmPerson);
          _jspx_th_impact_validateSelect_1.setValue(nmPersonValue);
          _jspx_th_impact_validateSelect_1.setOptions(personNameList);
          _jspx_th_impact_validateSelect_1.setDisabled(szDisabled );
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setRequired("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t </td>\r\n");
} 
          out.write("\r\n     <td class=\"alignLeft\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Parental Role");
          _jspx_th_impact_validateDisplayOnlyField_0.setName(cdPersonRole);
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(Lookup.simpleDecodeSafe( CodesTables.CPARROLE, contactRuleBean.getCdPersonRole()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t </td>\r\n  </tr>\r\n  <tr>\r\n     <td>&nbsp;</td>\r\n  \t <td class=\"alignLeft\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("# of Contacts per Month");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setName(nbrParentContactsPerMonth);
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue(nbrParentContactsPerMonthVal);
          _jspx_th_impact_validateInput_1.setSize("2");
          _jspx_th_impact_validateInput_1.setMaxLength("2");
          _jspx_th_impact_validateInput_1.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     <td colspan=\"2\">\r\n           <span class=\"formCondRequiredText\">&#135;</span><span style=\"align:middle\"> Contact Methods: </span>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setName(indByFaceToFace);
          _jspx_th_impact_validateInput_2.setChecked(indByFaceToFaceVal);
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setLabel("");
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           <img align=\"bottom\" alt=\"By Face to Face\" src=\"/grnds-docs/images/shared/face2face_icon.jpg\">\r\n           &nbsp;\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setName(indByTelephone);
          _jspx_th_impact_validateInput_3.setChecked(indByTelephoneVal);
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setLabel("");
          _jspx_th_impact_validateInput_3.setValue("Y");
          _jspx_th_impact_validateInput_3.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           <img align=\"bottom\" alt=\"By Telephone\" src=\"/grnds-docs/images/shared/phone_icon.jpg\">\r\n           &nbsp;\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName(indByEmailCorrspndnce);
          _jspx_th_impact_validateInput_4.setChecked(indByEmailCorrspndnceVal);
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setLabel("");
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           <img align=\"bottom\" alt=\"By Email/Correspondence\" src=\"/grnds-docs/images/shared/mail_icon.jpg\">\r\n     </td>\r\n     </tr>     \r\n     </table>\r\n     </td>\r\n   </tr>\r\n\r\n   <tr class=\"");
          out.print(tableRowClass);
          out.write("\">\r\n   \r\n    <td width=\"4%\">&nbsp;</td>\r\n   \t<td colspan=\"3\" width=\"50%\">\r\n \r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"2\">\r\n\t\t\t\t\t\t\tContact Not Required:\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("");
          _jspx_th_impact_validateSelect_2.setName(cdContactNotRequired);
          _jspx_th_impact_validateSelect_2.setCodesTable("CCONNREQ");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(contactRuleBean.getCdContactNotRequired()));
          _jspx_th_impact_validateSelect_2.setDisabled(szDisabled );
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                        </td>\t\t\t\t\t\r\n\t\t\t\t\t</tr>\r\n        \t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Justification:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName(txtJustification);
          _jspx_th_impact_validateTextArea_0.setTitle("Justification");
          _jspx_th_impact_validateTextArea_0.setColspan("1");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("65");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled(szDisabled );
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\t\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(contactRuleBean.getTxtJustification()));
              out.write("\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t</table>\r\n    \r\n    </td>\r\n\r\n    \r\n   \t<td colspan=\"2\">\r\n\t\t\t<!-- Start Contact For Block-->\r\n\t\t<div style=\"overflow:auto; WIDTH: 365px; HEIGHT: 129px\" class=\"tableborderList\">\r\n\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"2\"  width=\"100%\" class=\"thList\">\r\n\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span>Contact For:\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\r\n");
                    
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

          out.write("\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t    <td width=\"50%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setName(cbxIndContactFor);
          _jspx_th_impact_validateInput_5.setChecked(indContactFor);
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setLabel("");
          _jspx_th_impact_validateInput_5.setValue(idChild);
          _jspx_th_impact_validateInput_5.setDisabled(contactForDisabled);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t");
          out.print( contactForBean.getNmPersonFull() );
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n");
 				        
						if (!iterContactFor.hasNext()) {
						

          out.write("\t\t\t\t\t\t\t\r\n                          <td>&nbsp;</td>\r\n\t\t\t\t\t\t</tr>\r\n");
		  
				         } 
				       } else {

          out.write("\r\n                       <td width=\"50%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setName(cbxIndContactFor);
          _jspx_th_impact_validateInput_6.setChecked(indContactFor);
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setLabel("");
          _jspx_th_impact_validateInput_6.setValue(idChild);
          _jspx_th_impact_validateInput_6.setDisabled(contactForDisabled);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t");
          out.print( contactForBean.getNmPersonFull() );
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t    </tr>\r\n");

					   }				       
				    j++;
				             }
				          }

          out.write("\r\n\t\t\t</table>\r\n\t\t</div>\r\n\t\t\t\t<!-- End table PRN -->\r\n\t</td>\r\n\t</tr>\r\n");
i++;
 } //while end
} //If end 
          out.write("\r\n<!-- Save & Delete Buttons -->\r\n");
 
  if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {

          out.write("\r\n\t<tr>\r\n\t\t<td colspan=\"6\">\r\n\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t\t<tr>\t\t\t\r\n\t\t\t\t\t<td width=\"80%\">\r\n    \t\t\t\t\t&nbsp;\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAddContactRule");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setForm("frmContactStd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setAction("/contacts/ContactStandards/addContactRule");
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_1.setOnClick("IsDirty()");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnDelete");
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setForm("frmContactStd");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setAction("/contacts/ContactStandards/deleteContactRules");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_2.setFunction("return confirmDelete();");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\t\r\n\t\t\t</table>\r\n\t\t</td>\r\n\t</tr>\r\n");
 } else {
          out.write("\r\n   <tr>\r\n\t\t<td colspan=\"6\">&nbsp;</td>\r\n   </tr>\r\n");
 }
          out.write("\r\n\r\n</table>\r\n\r\n");
          out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n   <tr>\r\n      <th colspan=\"4\" class=\"thList\">Child Contact Rules</th>\r\n   </tr>\r\n   \t");
 
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
    
          out.write("    \r\n   <tr>\r\n     <td width=\"35%\">\r\n     ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName(nmChild);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( contactRuleBean.getNmPersonFull() );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n     </td>\r\n     <td width=\"35%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("# Face to Face Contacts per Month");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setName(nbrChildContactsPerMonth);
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue(nbrParentContactsPerMonthVal);
          _jspx_th_impact_validateInput_7.setSize("2");
          _jspx_th_impact_validateInput_7.setMaxLength("2");
          _jspx_th_impact_validateInput_7.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>\r\n   ");
 i++;
    }
   } 
          out.write("\r\n</table>\t\t\t\t\r\n\r\n<br>\r\n\r\n");
          out.write('\r');
          out.write('\n');

//If the Copy button is clicked do not copy the Reason For change and the Case Manager Acknowledment checkbox
 String txtReasonForChange = "";
 String indCmAcknowledge = "";
 if(!PageModeConstants.NEW_USING.equals(pageMode)){
   txtReasonForChange = FormattingHelper.formatString(contactStandardsRetrieveSO.getTxtReasonForChange());
   indCmAcknowledge = contactStandardsRetrieveSO.getIndCmAcknowledge();  
 }
 
          out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n   <tr>\r\n      <th><span class=\"formRequiredText\">*</span>Reason for change in Contact Standards: (Use n/a for initial contact standards)</th>\r\n   </tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtReasonForChange");
          _jspx_th_impact_validateTextArea_1.setTitle("Reason for Change in Contact Standards (Use n/a for initial contact standards)");
          _jspx_th_impact_validateTextArea_1.setColspan("1");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("80");
          _jspx_th_impact_validateTextArea_1.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setDisabled(szDisabled );
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print(txtReasonForChange);
              out.write("\t\t\t\t\t\t\t\r\n\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n \t <td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setId("indCmAcknowledge");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setName("indCmAcknowledge");
          _jspx_th_impact_validateInput_8.setValue("Y");
          _jspx_th_impact_validateInput_8.setLabel("I understand that child safety maybe greatly impacted by my decision");
          _jspx_th_impact_validateInput_8.setChecked(indCmAcknowledge);
          _jspx_th_impact_validateInput_8.setDisabled(szDisabled );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\t\r\n<br/>\r\n\r\n");
          out.write('\r');
          out.write('\n');
 
String isCurrentApprover = String.valueOf(contactStandardsRetrieveSO.isCurrentApprover());
String supApprovalDisabled = "";
if ("false".equals(isCurrentApprover) || StringHelper.isTrue(szDisabled)) {
  supApprovalDisabled = "true";
}
if((CodesTables.CEVTSTAT_PEND.equals(cdEventStatus) || CodesTables.CEVTSTAT_APRV.equals(cdEventStatus))){
          out.write("\r\n\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n\t   <tr>\r\n\t      <th class=\"thList\">Supervisor Approval</th>\r\n\t   </tr>\r\n\t\r\n\t   <tr>\r\n\t   <td>\r\n\t  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setId("indSuperApproval");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setName("indSuperApproval");
          _jspx_th_impact_validateInput_9.setValue("Y");
          _jspx_th_impact_validateInput_9.setLabel("I acknowledge that I have addressed Safety Threats, Child Vulnerability and Parent Protective Capacity prior to approving the established contact standards.");
          _jspx_th_impact_validateInput_9.setChecked(indSuperApproval);
          _jspx_th_impact_validateInput_9.setDisabled(supApprovalDisabled);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t  </td>\r\n\t </tr>\r\n\t</table>\r\n");
} 
          out.write("\r\n\t\t\t\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr>\r\n\t<td width=\"75%\">\r\n    \t&nbsp;\r\n\t</td>\r\n");
 
  if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus) && !CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {

          out.write("  \r\n\t<td align=\"right\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setForm("frmContactStd");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setAction("/contacts/ContactStandards/saveSubmitContactStandards");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_3.setFunction("return confirmChildNbrContactsPerMonth();");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n");
 }
          out.write("\t\r\n\t<td align=\"right\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setForm("frmContactStd");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setAction("/contacts/ContactStandards/saveContactStandards");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t\r\n</tr>\r\n</table>\r\n\t\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
