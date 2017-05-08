package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesCustomValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import org.apache.commons.lang.StringUtils;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public final class NeedsAndOutcomes_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  

//*********************
//*** SET PAGE MODE ***
//*********************

       String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
      }

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
      
  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  String assessorName =  "";
  String assessorTitle = "";
  String referralDate = "";
  String assessmentCompletionDate = "";
  String cCFARecUnused = "";
  String cCFAEduAssmt = "";
  String generalRec = "";
  String placementRec = "";
  String isAdd = "";
  String tsLastUpdate = "";
  String saTsLastUpdate = "";
  String agencyName = "";
  String cCFAAgency = "";
  String cCFAEduAssmtDate = "";
  String txtBelowSchoolAge = "";
  String txtUnderFour = "";
  int size = 0;
  int uIdEvent = 0;
  int uIdStage = 0;
  int loopCount = 0;
  String personNm = null;

  List<NeedsAndOutcomesList> needsOutcomesDetail = new ArrayList();
  int arrayIndex = ContextHelper.getIntSafe(request, "needsoutcomesIndex");
  
  
 //***********************************
 //*** RETRIEVE HIDDEN STATE FIELD ***
 //***********************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
              
              
                                                                       
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************                                                                      

    String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);
   NeedsAndOutcomesRetrieveSO needsOutcomes = (NeedsAndOutcomesRetrieveSO) state.getAttribute("NeedsAndOutcomesRetrieveSO", request);
   if(needsOutcomes.getNaoBeanList() != null)
   {
     needsOutcomesDetail =needsOutcomes.getNaoBeanList();
     size = needsOutcomesDetail.size();
   }
  
   
   //check for approval status

 boolean approvalStatus = true;
      // Get the Needs and outcomes bean from the request
      if (state.getAttribute("NeedsAndOutcomesRetrieveSO", request) != null) {
        needsOutcomes = (NeedsAndOutcomesRetrieveSO) state.getAttribute("NeedsAndOutcomesRetrieveSO", request);
        if (needsOutcomes.getROWCCMN45DO() != null) {
          tsLastUpdate = DateHelper.toISOString(needsOutcomes.getROWCCMN45DO().getTsLastUpdate());
          saTsLastUpdate = DateHelper.toISOString(needsOutcomes.getDtLastUpdate());
        }
        ROWCCMN45DO eventDetails = needsOutcomes.getROWCCMN45DO();
        if ((eventDetails == null)
            || pageMode.equals(PageModeConstants.NEW)
            || (!NeedsAndOutcomesConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !NeedsAndOutcomesConversation.EVENT_STATUS_APPROVED
                                                                                                                                                                .equals(eventDetails
                                                                                                                                                                .getSzCdEventStatus()))) {
          approvalStatus = false;
        }
      }
   
    
    if(needsOutcomes!=null)
     {
        assessorName = needsOutcomes.getTxtAssessorName();
        assessorTitle = needsOutcomes.getTxtAssessorTitle();
        uIdEvent = needsOutcomes.getUlIdEvent();
        uIdStage = needsOutcomes.getUlIdStage();
        referralDate = FormattingHelper.formatDate(needsOutcomes.getDtReferral());
        assessmentCompletionDate = FormattingHelper.formatDate(needsOutcomes.getDtAssessmentCompletion());
        cCFAEduAssmtDate = FormattingHelper.formatDate(needsOutcomes.getDtCCFAEduAssmt());
        if(needsOutcomes.getTxtCCFARecNotUsed()!=null)
        {
          cCFARecUnused =needsOutcomes.getTxtCCFARecNotUsed();
        }
        if(needsOutcomes.getTxtGeneralRec()!=null)  
        {
          generalRec = needsOutcomes.getTxtGeneralRec() ;
        }
        if( needsOutcomes.getTxtPlacementRec()!=null)
        {
         placementRec = needsOutcomes.getTxtPlacementRec();
        } 
        if( needsOutcomes.getNMResource()!=null)
        {
          agencyName =  needsOutcomes.getNMResource();
        }
        if( needsOutcomes.getTxtCCFAEduAssmt()!=null)
        {
          cCFAEduAssmt = needsOutcomes.getTxtCCFAEduAssmt();
        } 
        if(needsOutcomes.getIndCCFAAgency()!=null)
         {  
          cCFAAgency = needsOutcomes.getIndCCFAAgency();
        }  
        
        if(needsOutcomes.getTxtUnder4NoDevSrcCmnt()!=null)
        {  
          txtUnderFour = needsOutcomes.getTxtUnder4NoDevSrcCmnt();
        }  
        
        if(needsOutcomes.getTxtUndSchoolageNoDevAss()!=null)
        {  
          txtBelowSchoolAge = needsOutcomes.getTxtUndSchoolageNoDevAss();
        }  
     }
    personNm = GlobalData.getSzNmPersonFull(request);
    
     if(needsOutcomes.getUlIdEvent()==0)
      {
        uIdEvent = GlobalData.getUlIdEvent(request);
        uIdStage = GlobalData.getUlIdStage(request);
     }
     
   //Get Data for CCFA Eucational Assessment Ind  
   String cCFAEdu_Yes = ArchitectureConstants.FALSE;
   String cCFAEdu_No = ArchitectureConstants.FALSE; 
  
   String ind_CCFAEdu= needsOutcomes.getIndCCFAEduAssmt();
   if (ind_CCFAEdu != null)
     {
        if (ind_CCFAEdu.equals(ArchitectureConstants.N)) {
           cCFAEdu_No = ArchitectureConstants.TRUE;
            } else {
           cCFAEdu_Yes = ArchitectureConstants.TRUE;
          }
      }  
  String personIdForPullback = StringUtils.defaultString(needsOutcomes.getPersonIdForPullback());
  String resourceIdForPullback = StringUtils.defaultString(needsOutcomes.getResourceIdForPullback());  
  String resourceName = StringUtils.defaultString(needsOutcomes.getNMResource());  


      out.write("\r\n\r\n\r\n");
//******************
  //*** JAVASCRIPT ***
  //******************
 
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\n //Message for when a user wants to delete a needs outcomes and gives the user an alert, the if the\r\n  //radio button was not selected by the user.\r\n  function Delete()\r\n  {\r\n    var cont;\r\n    if( checkForSelection('document.frmNeedsAndOutcomes.rbNeedsIndex'))\r\n    {\r\n         cont = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("');\r\n    }\r\n    else\r\n    {\r\n         alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("');\r\n         cont = false;\r\n    }\r\n    return cont;\r\n  }\r\n\r\n  \r\n //Allows for the needs outcomes to be selected out of the radio button\r\n  function checkForSelection( objName )\r\n  {\r\n    var buttonChecked = false;\r\n    var obj = eval(objName);\r\n\r\n    if (obj != null)\r\n    {\r\n      if (obj.length == null)\r\n      {\r\n        if (obj.checked != false)\r\n          buttonChecked = true;\r\n      }\r\n      else\r\n      {\r\n        for (var i = 0; i < obj.length; ++i)\r\n        {\r\n          buttonChecked = buttonChecked || obj[i].checked;\r\n        }\r\n      }\r\n    }\r\n\r\n  return (buttonChecked);\r\n} \r\n\r\nfunction submitNeedsOutcomeDetail( idNeedsOutcome, idEvent, idStage, personNm ){\r\n  document.frmNeedsAndOutcomes.hdnIdNeedsOutcomes.value = idNeedsOutcome;\r\n  document.frmNeedsAndOutcomes.hdnUIdEvent.value = idEvent;\r\n  document.frmNeedsAndOutcomes.hdnUIdStage.value = idStage;\r\n  document.frmNeedsAndOutcomes.hdnPersonNm.value = personNm;\r\n  submitValidateForm( \"frmNeedsAndOutcomes\", \"/subcare/NeedsAndOutcomes/displayNeedsAndOutcomesDetail\" );\r\n");
      out.write("  }\r\n  \r\n</script>\r\n\r\n\r\n\r\n\r\n");
    //**************************
      //**** FORM STARTS HERE ****
      //**************************

 
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmNeedsAndOutcomes");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/NeedsAndOutcomes/displayNeedsAndOutcomes");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_0.setValue( tsLastUpdate );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"hdnResourceIdForPullback\" value=\"");
          out.print(resourceIdForPullback);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnPersonIdForPullback\" value=\"");
          out.print(personIdForPullback);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnResourceName\" value=\"");
          out.print(resourceName);
          out.write("\" />\r\n  <input type=\"hidden\" name=\"hdnPageName\" value=\"NeedsOutcomes\" />\r\n  <input type=\"hidden\" name=\"hdnIdNeedsOutcomes\">\r\n  <input type=\"hidden\" name=\"hdnUIdEvent\" value=\"");
          out.print(uIdEvent);
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnUIdStage\" value=\"");
          out.print(uIdStage);
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnPersonNm\" value=\"");
          out.print(personNm);
          out.write("\">\r\n  <input type=\"hidden\" name=\"hdnSize\" value=\"");
          out.print(size);
          out.write("\">\r\n\r\n\r\n  ");
 // Begin Detail

          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      ");
if (approvalStatus) {

        
          out.write("\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setForm("frmNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/displayStatus");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
} else { 
          out.write("\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        &nbsp;\r\n      </td>\r\n      ");
 } 
          out.write("\r\n    </tr>\r\n  </table>\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborderList\">\r\n    <tr>\r\n      <th colspan=\"8\">\r\n        <span class=\"formRequiredText\">*</span> Needs And Outcomes List\r\n      </th>\r\n    </tr>\r\n    <tr></tr>\r\n    <tr>\r\n      <th class=\"thList\"></th>\r\n      <th class=\"thList\">\r\n        Identified Need\r\n      </th>\r\n      <th class=\"thList\">\r\n        CCFA Need\r\n      </th>\r\n      <th class=\"thList\">\r\n        Service Recommended\r\n      </th>\r\n      <th class=\"thList\">\r\n        Service Provided\r\n      </th>\r\n      <th class=\"thList\">\r\n        Need Met\r\n      </th>\r\n    </tr>\r\n\r\n    ");

          if (!FormValidation.pageHasErrorMessages(request)) {
          if (size == 0) {
         
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCount + 1 ) );
          out.write("\">\r\n      <td colspan=\"10\">\r\n        ");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
} else {
          for (Iterator<NeedsAndOutcomesList> it = needsOutcomesDetail.iterator(); it.hasNext();) {
          NeedsAndOutcomesList needsRow = (NeedsAndOutcomesList) it.next();
          String idNeedsOutcomes = String.valueOf( needsRow.getIdNeedsAndOutcomes());
         
       
          out.write("\r\n    <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName("rbNeedsIndex");
          _jspx_th_impact_validateInput_1.setValue( idNeedsOutcomes);
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print(FormattingHelper.formatString( needsRow.getTxtIdentifiedNeed()));
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatString( needsRow.getIndCCFANeed()));
          out.write("\r\n      </td>\r\n      <td align=\"left\">\r\n        ");

                  String serviceRecommended = "";
                  serviceRecommended = FormattingHelper.formatString(needsRow.getTxtServiceRecommended());
                  String listItemId = "needsItem_" + loopCount;
                 
          out.write("\r\n        <a href=\"javascript:submitNeedsOutcomeDetail('");
          out.print( idNeedsOutcomes );
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print(uIdEvent);
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print(uIdStage);
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print(personNm);
          out.write("')\">");
          out.print(serviceRecommended);
          out.write("</a>\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatString(needsRow.getIndServiceProvided()));
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatString(needsRow.getIndNeedMet()));
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    ");
loopCount++;
       }
           } //end big else
      } // end !FormValidation.pageHasErrorMessages

      
          out.write("\r\n  </table>\r\n\r\n\r\n  ");
 //*****************
      //**** BUTTONS ****
      //*****************

  if (!pageMode.equals(PageModeConstants.VIEW)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"left\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setForm("frmNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setName("delete");
          _jspx_th_impact_ButtonTag_1.setAction("/subcare/NeedsAndOutcomes/deleteNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_1.setFunction("return Delete()");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td width=\"80%\">\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setForm("frmNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setName("needs");
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/NeedsAndOutcomes/addNeedsAndOutcomesDetail");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}
          out.write("\r\n  <br/>\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"8\" align=\"left\">\r\n        CCFA Agency\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtAgencyNm");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Agency Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( agencyName );
          _jspx_th_impact_validateDisplayOnlyField_0.setCssClass("formInput");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      </td>\r\n      <td align=\"right\" colspan=\"2\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setForm("frmNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_3.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_3.setName("SelectResource");
          _jspx_th_impact_ButtonTag_3.setAction("/subcare/NeedsAndOutcomes/retrieveResource");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setLabel("CCFA Agency");
          _jspx_th_impact_validateInput_2.setChecked( (("".equals(cCFAAgency)) || (ArchitectureConstants.N.equals(cCFAAgency))) ? "false" : "true" );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setName("chkCCFAAgency");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("txtAssessorName");
          _jspx_th_impact_validateInput_3.setLabel("Assessor Name");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setSize("20");
          _jspx_th_impact_validateInput_3.setMaxLength("20");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setValue( assessorName );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setName("txtAssessorTitle");
          _jspx_th_impact_validateInput_4.setLabel("Assessor Title");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setSize("30");
          _jspx_th_impact_validateInput_4.setMaxLength("30");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setValue( assessorTitle );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"8\" align=\"left\">\r\n        CCFA Assessment\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Referral Date");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue( referralDate );
          _jspx_th_impact_validateDate_0.setName("dtReferral");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <!--     <td colspan=\"1\">Assessment Completion Date</td> -->\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setLabel("Assessment Completion Date");
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( assessmentCompletionDate );
          _jspx_th_impact_validateDate_1.setName("dtAssessmentCompletion");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        General Recommendations:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtGeneralRec");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setColspan("2");
          _jspx_th_impact_validateTextArea_0.setCols("60");
          _jspx_th_impact_validateTextArea_0.setRows("5");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(generalRec);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        Placement Recommendations:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtPlacementRec");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setColspan("2");
          _jspx_th_impact_validateTextArea_1.setCols("60");
          _jspx_th_impact_validateTextArea_1.setRows("5");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(placementRec);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        CCFA Recommendations that were not used as a step to accomplish the case plan:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtCCFARecUnused");
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setColspan("2");
          _jspx_th_impact_validateTextArea_2.setCols("60");
          _jspx_th_impact_validateTextArea_2.setRows("5");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(cCFARecUnused);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        Has the CCFA Educational Assessment been performed?\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setLabel("Yes");
          _jspx_th_impact_validateInput_5.setId("cCFAEdu_Yes");
          _jspx_th_impact_validateInput_5.setName("rbCCFAEdu");
          _jspx_th_impact_validateInput_5.setValue("Y");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setChecked( cCFAEdu_Yes );
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setLabel("No");
          _jspx_th_impact_validateInput_6.setId("cCFAEdu_No");
          _jspx_th_impact_validateInput_6.setName("rbCCFAEdu");
          _jspx_th_impact_validateInput_6.setValue("N");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setChecked( cCFAEdu_No );
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtCCFAEduAssmt");
          _jspx_th_impact_validateTextArea_3.setLabel("If no,explain");
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_3.setMaxLength(300);
          _jspx_th_impact_validateTextArea_3.setColspan("2");
          _jspx_th_impact_validateTextArea_3.setCols("60");
          _jspx_th_impact_validateTextArea_3.setRows("5");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(cCFAEduAssmt);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Date of CCFA Educational Assessment");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setValue( cCFAEduAssmtDate );
          _jspx_th_impact_validateDate_2.setName("dtCCFAEduAssmt");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        If the child is under 4 years old, and there has not been a Developmental Screening, explain:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName("txtUnderFour");
          _jspx_th_impact_validateTextArea_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph500");
          _jspx_th_impact_validateTextArea_4.setMaxLength(300);
          _jspx_th_impact_validateTextArea_4.setColspan("2");
          _jspx_th_impact_validateTextArea_4.setCols("60");
          _jspx_th_impact_validateTextArea_4.setRows("5");
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(txtUnderFour);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        If the child is below school age and there has not been a Developmental Assessment, explain:\r\n      </td>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setName("txtBelowSchoolAge");
          _jspx_th_impact_validateTextArea_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_5.setConstraint("Paragraph500");
          _jspx_th_impact_validateTextArea_5.setMaxLength(300);
          _jspx_th_impact_validateTextArea_5.setColspan("2");
          _jspx_th_impact_validateTextArea_5.setCols("60");
          _jspx_th_impact_validateTextArea_5.setRows("5");
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(txtBelowSchoolAge);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    \r\n\r\n  </table>\r\n\r\n  ");
//*****************
      //**** BUTTONS ****
      //*****************
     
      // Display the Save and Submit and Save buttons unless the page mode is VIEW.  
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"100%\">\r\n    <tr>\r\n      <td width=\"70%\">\r\n        &nbsp;\r\n      </td>\r\n      ");
  if ((!pageMode.equals(PageModeConstants.VIEW)) && (!approvalStatus) && (!pageMode.equals(PageModeConstants.NEW))) {
          out.write("\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_4.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_4.setForm("frmNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_4.setAction("/subcare/NeedsAndOutcomes/saveAndSubmitNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
} if (!pageMode.equals(PageModeConstants.VIEW)){ 
          out.write("\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSave");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setForm("frmNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_5.setAction("/subcare/NeedsAndOutcomes/saveNeedsAndOutcomes");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}
          out.write("\r\n\r\n  <br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");
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
