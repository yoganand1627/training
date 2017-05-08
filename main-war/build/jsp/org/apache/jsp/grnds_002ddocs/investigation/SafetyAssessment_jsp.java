package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DrugExposedNewBornRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ReasonableEffortsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyAssessmentConversation;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

public final class SafetyAssessment_jsp extends org.apache.jasper.runtime.HttpJspBase
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

/**--------------------------------------------------------------------------------
       *
       * JSP Name:     Safety Assessment
       * Created by:   Modeste Ngom
       * Date Created: 09/06/2006
       *
       * Description:
       * This JSP displays the details for a given Safety Assessment. Depending upon
       * the user's privileges, the user can use this page to view and update Safety Assessments.
      
       Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       11-09-06  abgoode           SIR 934 - Added a third hidden field eplTsLastUpdate so
                                   that attempts to delete the record in EventPersonLink work.
                                   Also cleaned up the code a little.
       11-21-06  abgoode           Removed the hidden field eplTsLastUpdate since data is no
                                   longer being saved to the EventPersonLink table.
       
       12-12-06  srollins        Added the forms drop-down and launch button so that when
                        the launch button is the click the Safety Assessment Form
                        will display in a separate  window.
                        
       7/10/08   cwells           Added a new method for the approval status button that saves the 
       							  page then upon a successful save navigates to the Approval status page  
       							  
       10/10/08  charden          STGAP00005341 - Added code to keep overall decision from dirtying page
       
       11/14/08  arege            STGAP00010758 - Modified code so that the SaveAndSubmit button is not displayed for the 
                                                  Supervisor in approval mode.  
                                                  
       05/04/09  cwells           STGAP00013413 - If we are in approval mode call save and then approval status display in the conversation.  But
       											  if we are not in approval mode then just display approval staus page.                                        
                                                                    
       */

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
//*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      int tabIndex = 1;
      SafetyAssessmentRetrieveSO safetyAssessment = new SafetyAssessmentRetrieveSO();

      boolean bShowDeleteButton = false;
      boolean bShowDrugExposedNewborns = false;

      String tsLastUpdate = "";
      String saTsLastUpdate = "";
      String selOverallSafetyDecision= "";

      //***********************************
      //*** RETRIEVE HIDDEN STATE FIELD ***
      //***********************************
      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //*********************
      //*** SET PAGE MODE ***
      //*********************
      String pageMode = PageModeConstants.VIEW;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }
      boolean bShowSaveAndSubmitButton = true;
      if(GlobalData.isApprovalMode(request)){
      bShowSaveAndSubmitButton = false;
      }

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      boolean approvalStatus = true;
      // Get the Safety Assessment bean from the request
      if (state.getAttribute("SafetyAssessmentRetrieveSO", request) != null) {
        safetyAssessment = (SafetyAssessmentRetrieveSO) state.getAttribute("SafetyAssessmentRetrieveSO", request);
        if (safetyAssessment.getROWCCMN45DO() != null) {
          tsLastUpdate = DateHelper.toISOString(safetyAssessment.getROWCCMN45DO().getTsLastUpdate());
          saTsLastUpdate = DateHelper.toISOString(safetyAssessment.getDtLastUpdate());
        }
        ROWCCMN45DO eventDetails = safetyAssessment.getROWCCMN45DO();
        if ((eventDetails == null)
            || pageMode.equals(PageModeConstants.NEW)
            || (!SafetyAssessmentConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !SafetyAssessmentConversation.EVENT_STATUS_APPROVED
                                                                                                                                                                .equals(eventDetails
                                                                                                                                                                                    .getSzCdEventStatus()))) {
          approvalStatus = false;
        }
      }

      //to do later - add in pending approval check
      if (safetyAssessment.getUlIdEvent() != 0) {
        bShowDeleteButton = true;
      }

      if (safetyAssessment.getIsDrugExposedNewBorn()) {
        bShowDrugExposedNewborns = true;
      }


   if( request.getParameter("selOverallSafetyDecision") != null )
    {
      selOverallSafetyDecision = request.getParameter("selOverallSafetyDecision");
    }else
    {
      selOverallSafetyDecision =safetyAssessment.getSzTxtOverallSafetyDecision();
    }

      // Check the request to see if the "pageSaved" indicator
      // has been passed to this page. If the indicator has been passed to
      // this page and is "true", this page needs to display the appropriate messages.


      out.write("\r\n\r\n");
//******************
      //*** JAVASCRIPT ***
      //******************

      
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nvar previousIndex =0;\r\nvar previousLength =0;\r\nvar msg=true;\r\n\r\n\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\nfunction documentAlert()\r\n{\r\n  alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_ARC_SAVE_PAGE) );
      out.write("');\r\n  return false;\r\n}\r\n\r\nwindow.onload = function() {\r\nisSafetyFactorCheckedYes();\r\nsetTheDefaultValue();\r\n}\r\n\r\n\r\nfunction isSafetyFactorCheckedYes(){\r\nvar yesIsChecked = false;\r\nvar radionElement;\r\nfor (i=0;i<document.frmSafetyAssessment.elements.length;i++) {\r\n    var elementType = document.frmSafetyAssessment.elements[i].type;\r\n    if (elementType=='radio'){\r\n      var checkBoxName = document.frmSafetyAssessment.elements[i].name;\r\n      if (document.frmSafetyAssessment.elements[i].checked && checkBoxName.substring(0,4)=='rbSF' ) {\r\n          var choice = document.frmSafetyAssessment.elements[i];\r\n          if (choice.value=='Y'){\r\n            yesIsChecked = true;\r\n            break;\r\n          }\r\n      }\r\n  }\r\n  }\r\n  if (yesIsChecked==true){\r\n    resetSelOverallSafetyDecision('Y');\r\n  }else{\r\n    resetSelOverallSafetyDecision('N');\r\n  }\r\n}\r\n\r\nfunction resetSelOverallSafetyDecision(choice)\r\n{\r\n    var listObj = document.frmSafetyAssessment.selOverallSafetyDecision;\r\n    if (listObj!=null && listObj.selectedIndex!=null){\r\n");
      out.write("      previousIndex = listObj.selectedIndex;\r\n      if (listObj.options!=null){\r\n         previousLength = listObj.options.length;\r\n      } else {\r\n        previousLength = 4;\r\n      }\r\n    }else {\r\n      previousIndex = 0;\r\n    }\r\n    \r\n    msg = true;\r\n    if (previousIndex==2 && previousLength==4 && choice=='Y') {\r\n      msg =  confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_ASSMT_SA_CLEAR_OVRL_DECISION ) );
      out.write("\" );\r\n      if (!msg) {\r\n          return false;\r\n      }\r\n    }\r\n    \r\n    if (listObj!=null && listObj.options!=null){\r\n      listObj.options.length=0;\r\n        if (choice=='Y'){\r\n      listObj.options[0] = new Option('','');\r\n         listObj.options[1] = new Option('Conditionally Safe','CS');\r\n        listObj.options[2] = new Option('Unsafe','US');\r\n      } else if (choice=='N'){\r\n         listObj.options[0] = new Option('','');\r\n        listObj.options[1] = new Option('Conditionally Safe','CS');\r\n        listObj.options[2] = new Option('Safe','SF');\r\n        listObj.options[3] = new Option('Unsafe','US');\r\n      } \r\n    }\r\n     \r\n\r\n}\r\n\r\nfunction setCurrentValue(){\r\n\r\n    if (msg){\r\n    var listObj = document.frmSafetyAssessment.selOverallSafetyDecision;\r\n    var currentLength=listObj.options.length;\r\n\r\n      if (previousIndex==0){\r\n       listObj.options[0].selected = true;\r\n      }\r\n      if (previousIndex==1){\r\n       listObj.options[1].selected=true;\r\n      }\r\n\r\n      if (previousIndex==3){\r\n          if (currentLength==3){\r\n");
      out.write("           listObj.options[2].selected = true;\r\n          }else {\r\n             if (currentLength==4){\r\n                listObj.options[3].selected=true;\r\n             }\r\n          }\r\n      }\r\n            \r\n      if (previousIndex==2){\r\n        \r\n        if (previousLength==3 && currentLength==4){\r\n           listObj.options[3].selected = true;\r\n        }else {\r\n           if (previousLength==3 && currentLength==3){\r\n             listObj.options[2].selected= true;\r\n           } \r\n        }\r\n      }\r\n   }\r\n   \r\n   return msg;\r\n}\r\n\r\nfunction setTheDefaultValue(){\r\nvar selectedValue = '");
      out.print(FormattingHelper.formatString( selOverallSafetyDecision ));
      out.write("';\r\nvar listObj = document.frmSafetyAssessment.selOverallSafetyDecision;\r\nif (listObj!=null && listObj.options!=null){\r\nfor (i = 0 ; i < listObj.options.length ; i++){\r\n        if (listObj.options[i].value==selectedValue){\r\n          listObj.options[i].selected = true;\r\n          listObj.options[i].defaultSelected = true;\r\n        }\r\n    }\r\n    }\r\n}\r\n\r\nfunction checkTheOther(radioBtn,indexToCheck){\r\n var radioGroupSelected = document.getElementsByName(radioBtn.name);\r\n radioGroupSelected[indexToCheck].checked=true;\r\n}\r\n\r\nfunction radioBtnFunction(radioBtn,indexToCheck){\r\n\r\nisSafetyFactorCheckedYes();\r\nsetCurrentValue(); \r\nif (!msg) {\r\n  checkTheOther(radioBtn,indexToCheck);\r\n}\r\n\r\n}\r\n\r\n</script>\r\n\r\n");
//**************************
      //**** FORM STARTS HERE ****
      //**************************

      
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSafetyAssessment");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/SafetyAssessment/displaySafetyAssessment");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyAssessmentCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      ");
if (approvalStatus) {
        String action = ApprovalStatusConversation.DISPLAY_URI;
        if (GlobalData.isApprovalMode(request)) {
	        action = "/investigation/SafetyAssessment/submitApproval";
	      }
        
          out.write("\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setForm("frmSafetyAssessment");
          _jspx_th_impact_ButtonTag_0.setAction(action);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
} else { 
          out.write("\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        &nbsp;\r\n      </td>\r\n      ");
 } 
          out.write("\r\n\r\n      <td align=\"right\">\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp; <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n      </td>\r\n\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("SafetyFactorsTable");
          _jspx_th_impact_ExpandableSectionTag_0.setId("Safety_Factor");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Safety Factors");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n\r\n      ");
Map<String, Collection<SafetyFactorsRetrieveSO>> map = safetyAssessment.getSafetyFactors();
      
      //-- null check
      if(map == null){
        map = new HashMap<String, Collection<SafetyFactorsRetrieveSO>>();
      }
      
      Iterator<String> mapIterator = map.keySet().iterator();

      List<String> keyList = new ArrayList<String>();

      while (mapIterator.hasNext()) {
        String nextItem = mapIterator.next();
        keyList.add(nextItem);
      }

      //sort the keys and add to a collections item

      Collections.sort(keyList);

      Iterator<String> listIter = keyList.iterator();

      while (listIter.hasNext()) {

        String code = listIter.next();
        
        if (!SafetyAssessmentConversation.OTHER_QUESTION.equals(code)) {

          
              out.write("\r\n      <tr class=\"altColor\">\r\n        <td colspan=\"4\">\r\n          ");
              out.print(Lookup.simpleDecodeSafe(SafetyAssessmentConversation.SAFETY_FACTORS_CODES_TABLES, code));
              out.write("\r\n        </td>\r\n      </tr>\r\n\r\n      <tr class=\"altColor\">\r\n        <td>\r\n          <b>Caretaker</b>\r\n        </td>\r\n        <td>\r\n          <b>Child</b>\r\n        </td>\r\n        <td>\r\n          <b>Yes</b>\r\n        </td>\r\n        <td>\r\n          <b>No</b>\r\n        </td>\r\n      </tr>\r\n      ");
Collection<SafetyFactorsRetrieveSO> coll = map.get(code);
          
          //-- null check
          if(coll == null){
            coll = new ArrayList<SafetyFactorsRetrieveSO>();
          }
          
          Iterator<SafetyFactorsRetrieveSO> safetyFactorIterator = coll.iterator();
          while (safetyFactorIterator.hasNext()) {
            SafetyFactorsRetrieveSO sa = safetyFactorIterator.next();
            String rbFieldName = "rbSF" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
            String idFieldName = "id" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
            String dtFieldName = "dt" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
            String yIsChecked = "false";
            String nIsChecked = "true";
            if ("Y".equals(sa.getSzCdSafetyFactorResponse())) {
              yIsChecked = "true";
              nIsChecked = "false";
            }

            
              out.write("\r\n      <tr class=\"odd\">\r\n        <td>\r\n          ");
              out.print(sa.getTxtCaretaker());
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              out.print(sa.getTxtChild());
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_0.setType("radio");
              _jspx_th_impact_validateInput_0.setOnClick("radioBtnFunction(this,1);");
              _jspx_th_impact_validateInput_0.setChecked(yIsChecked);
              _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_0.setValue("Y");
              _jspx_th_impact_validateInput_0.setName(rbFieldName);
              _jspx_th_impact_validateInput_0.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_1.setType("radio");
              _jspx_th_impact_validateInput_1.setOnClick("radioBtnFunction(this,0);");
              _jspx_th_impact_validateInput_1.setChecked(nIsChecked);
              _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_1.setValue("N");
              _jspx_th_impact_validateInput_1.setName(rbFieldName);
              _jspx_th_impact_validateInput_1.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <input type=\"hidden\" name=\"");
              out.print(idFieldName);
              out.write("\" value=\"");
              out.print(sa.getUlIdSafetyFactor());
              out.write("\">\r\n        <input type=\"hidden\" name=\"");
              out.print(dtFieldName);
              out.write("\" value=\"");
              out.print(DateHelper.toISOString(sa.getDtDtLastUpdateDt()));
              out.write("\">\r\n      </tr>\r\n      ");
} // end of SafetyFactorsCollection

        
              out.write("\r\n      ");
} // end of if Other

      } 
              out.write("\r\n\r\n      <tr class=\"altColor\">\r\n        <td colspan=\"4\">\r\n          Other(specify):\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_2.setType("text");
              _jspx_th_impact_validateInput_2.setLabel("");
              _jspx_th_impact_validateInput_2.setWidth("60");
              _jspx_th_impact_validateInput_2.setConstraint("Paragraph80");
              _jspx_th_impact_validateInput_2.setName("txtOtherSafetyFactor");
              _jspx_th_impact_validateInput_2.setCssClass("formInput");
              _jspx_th_impact_validateInput_2.setValue(safetyAssessment.getSzTxtOtherSafetyFactor());
              _jspx_th_impact_validateInput_2.setSize("90");
              _jspx_th_impact_validateInput_2.setMaxLength("80");
              _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++ );
              int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
              if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"altColor\">\r\n        <td>\r\n          <b>Caretaker</b>\r\n        </td>\r\n        <td>\r\n          <b>Child</b>\r\n        </td>\r\n        <td>\r\n          <b>Yes</b>\r\n        </td>\r\n        <td>\r\n          <b>No</b>\r\n        </td>\r\n      </tr>\r\n      ");
String code = SafetyAssessmentConversation.OTHER_QUESTION;
      Collection<SafetyFactorsRetrieveSO> coll = map.get(code);
      
      //-- null check
      if(coll == null){
        coll = new ArrayList<SafetyFactorsRetrieveSO>();
      }
      
      Iterator<SafetyFactorsRetrieveSO> safetyFactorIterator = coll.iterator();
      while (safetyFactorIterator.hasNext()) {
        SafetyFactorsRetrieveSO sa = safetyFactorIterator.next();
        String rbFieldName = "rbSF" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
        String idFieldName = "id" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
        String dtFieldName = "dt" + sa.getSzCdSafetyFactor() + "_" + sa.getIdCaretaker() + "_" + sa.getIdChild();
        String yIsChecked = "false";
        String nIsChecked = "true";
        if ("Y".equals(sa.getSzCdSafetyFactorResponse())) {
          yIsChecked = "true";
          nIsChecked = "false";
        }

        
              out.write("\r\n      <tr class=\"odd\">\r\n        <td>\r\n          ");
              out.print(sa.getTxtCaretaker());
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              out.print(sa.getTxtChild());
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setOnClick("radioBtnFunction(this,1);");
              _jspx_th_impact_validateInput_3.setChecked(yIsChecked);
              _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_3.setValue("Y");
              _jspx_th_impact_validateInput_3.setName(rbFieldName);
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setType("radio");
              _jspx_th_impact_validateInput_4.setOnClick("radioBtnFunction(this,0);");
              _jspx_th_impact_validateInput_4.setChecked(nIsChecked);
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_4.setValue("N");
              _jspx_th_impact_validateInput_4.setName(rbFieldName);
              _jspx_th_impact_validateInput_4.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <input type=\"hidden\" name=\"");
              out.print(idFieldName);
              out.write("\" value=\"");
              out.print(sa.getUlIdSafetyFactor());
              out.write("\">\r\n        <input type=\"hidden\" name=\"");
              out.print(dtFieldName);
              out.write("\" value=\"");
              out.print(DateHelper.toISOString(sa.getDtDtLastUpdateDt()));
              out.write("\">\r\n      </tr>\r\n      ");
 } 
              out.write("\r\n      <tr class=\"altColor\">\r\n        <td colspan=\"4\">\r\n          Additional Comments:\r\n        </td>\r\n      </tr>\r\n      <tr class=\"altColor\">\r\n        <td valign=\"top\" colspan=\"4\">\r\n          ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_0.setName("txtAddtnlCommnts");
              _jspx_th_impact_validateTextArea_0.setColspan("4");
              _jspx_th_impact_validateTextArea_0.setLabel("");
              _jspx_th_impact_validateTextArea_0.setRows("4");
              _jspx_th_impact_validateTextArea_0.setCols("100");
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n            ");
                  out.print(FormattingHelper.formatString(safetyAssessment.getSzTxtAddtnlCommnts()));
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <br>\r\n  ");
if (bShowDrugExposedNewborns) { 
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("DrugExposedNewbornTable");
          _jspx_th_impact_ExpandableSectionTag_1.setId("Drug_Exposed");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Drug Exposed Newborn");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n\r\n      ");
Iterator<DrugExposedNewBornRetrieveSO> iteratorDEN = safetyAssessment.getDrugExposedNewborn().iterator();
        while (iteratorDEN.hasNext()) {
          DrugExposedNewBornRetrieveSO dEN = iteratorDEN.next();
          String codeDEN = dEN.getSzCdDrugExpNb();
          String fieldNameDEN = "rb" + codeDEN;
          String hdnDENId = "id" + codeDEN;
          String hdbDtLastUpdate = "dt" + codeDEN;
          String yIsCheckedDEN = "false";
          String nIsCheckedDEN = "false";
          if ("Y".equals(dEN.getSzCdDrugExpNbRps())) {
            yIsCheckedDEN = "true";
          } else if ("N".equals(dEN.getSzCdDrugExpNbRps())) {
            nIsCheckedDEN = "true";
          }

          
              out.write("\r\n      <tr class=\"odd\">\r\n        <td>\r\n          ");
              out.print(Lookup.simpleDecodeSafe(SafetyAssessmentConversation.DRUG_EXPOSED_NEW_BORNS, codeDEN));
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_5.setType("radio");
              _jspx_th_impact_validateInput_5.setChecked(yIsCheckedDEN);
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setValue("Y");
              _jspx_th_impact_validateInput_5.setName(fieldNameDEN);
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          Yes\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_6.setType("radio");
              _jspx_th_impact_validateInput_6.setChecked(nIsCheckedDEN);
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_6.setValue("N");
              _jspx_th_impact_validateInput_6.setName(fieldNameDEN);
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          No\r\n        </td>\r\n        <input type=\"hidden\" value=\"");
              out.print(dEN.getUIdDrugExposedNewborn());
              out.write("\" name=\"");
              out.print(hdnDENId);
              out.write("\">\r\n        <input type=\"hidden\" value=\"");
              out.print(DateHelper.toISOString(dEN.getDtLastUpdateDt()));
              out.write("\" name=\"");
              out.print(hdbDtLastUpdate);
              out.write("\">\r\n      </tr>\r\n      ");
}
              out.write("\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <br>\r\n  ");
 } 
          out.write("\r\n\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("ReasonableEfforts");
          _jspx_th_impact_ExpandableSectionTag_2.setId("Reasonable_Efforts");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Reasonable Efforts");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n\r\n      ");
Map<String, Collection<ReasonableEffortsRetrieveSO>> mapRE = safetyAssessment.getReasonableEfforts();
      Iterator<String> iteratorRE = mapRE.keySet().iterator();
      while (iteratorRE.hasNext()) {
        String codeRE = iteratorRE.next();
        Collection<ReasonableEffortsRetrieveSO> collRE = mapRE.get(codeRE);

        
              out.write("\r\n      <tr class=\"altColor\">\r\n        <td colspan=\"4\">\r\n          ");
              out.print(Lookup.simpleDecodeSafe(SafetyAssessmentConversation.REASONABLE_EFFORTS, codeRE));
              out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"altColor\">\r\n        <td>\r\n          <b>Child</b>\r\n        </td>\r\n        <td>\r\n          <b>Yes</b>\r\n        </td>\r\n        <td>\r\n          <b>No</b>\r\n        </td>\r\n        <td>\r\n          <b>Comments</b>\r\n        </td>\r\n      </tr>\r\n      ");
Iterator<ReasonableEffortsRetrieveSO> iteratorCollRE = collRE.iterator();
        while (iteratorCollRE.hasNext()) {
          ReasonableEffortsRetrieveSO rE = iteratorCollRE.next();
          String rbFieldNameRE = "rb" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String txtFieldNameRE = "txt" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String idFieldNameRE = "id" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String dtFieldNameRE = "dt" + rE.getSzCdReasonableEfforts() + "_" + rE.getIdChild();
          String yIsCheckedRE = "false";
          String nIsCheckedRE = "false";
          if ("Y".equals(rE.getSzCdReasonableEffortsResponse())) {
            yIsCheckedRE = "true";
          } else if ("N".equals(rE.getSzCdReasonableEffortsResponse())) {
            nIsCheckedRE = "true";
          }

          
              out.write("\r\n      <tr class=\"odd\">\r\n        <td>\r\n          ");
              out.print(rE.getSzTxtChild());
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_7.setType("radio");
              _jspx_th_impact_validateInput_7.setChecked(yIsCheckedRE);
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_7.setValue("Y");
              _jspx_th_impact_validateInput_7.setName(rbFieldNameRE);
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setChecked(nIsCheckedRE);
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setValue("N");
              _jspx_th_impact_validateInput_8.setName(rbFieldNameRE);
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n          ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_1.setName( txtFieldNameRE );
              _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph80");
              _jspx_th_impact_validateTextArea_1.setMaxLength(80);
              _jspx_th_impact_validateTextArea_1.setCols("80");
              _jspx_th_impact_validateTextArea_1.setRows("2");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n            ");
                  out.print(rE.getSzTxtComments());
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <input type=\"hidden\" name=\"");
              out.print(idFieldNameRE);
              out.write("\" value=\"");
              out.print(rE.getUlIdReasonableEfforts());
              out.write("\">\r\n        <input type=\"hidden\" name=\"");
              out.print(dtFieldNameRE);
              out.write("\" value=\"");
              out.print(DateHelper.toISOString(rE.getDtDtLastUpdateDt()));
              out.write("\">\r\n      </tr>\r\n      ");
} // end of iteratorCollRE

      
              out.write("\r\n      ");
}
              out.write("\r\n      <tr class=\"altColor\">\r\n        <td colspan=\"4\">\r\n          Why responses 1-5 could not be used to keep children safe:\r\n        </td>\r\n      </tr>\r\n      <tr class=\"altColor\">\r\n        <td valign=\"top\" colspan=\"4\">\r\n          ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_2.setName("txtResponse");
              _jspx_th_impact_validateTextArea_2.setColspan("4");
              _jspx_th_impact_validateTextArea_2.setLabel("");
              _jspx_th_impact_validateTextArea_2.setRows("4");
              _jspx_th_impact_validateTextArea_2.setCols("100");
              _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n            ");
                  out.print(FormattingHelper.formatString(safetyAssessment.getSzTxtWhyResponses()));
                  out.write("\r\n          ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <br>\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("SafetyDecision");
          _jspx_th_impact_ExpandableSectionTag_3.setId("Safety_Decision");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Safety Decision");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n\r\n      <tr class=\"odd\">\r\n        <td>\r\n          ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_0.setLabel("Overall Safety Decision");
              _jspx_th_impact_validateSelect_0.setName("selOverallSafetyDecision");
              _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_0.setCodesTable("COVSFDSN");
              _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString( selOverallSafetyDecision ) );
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n  ");
//*****************
      //**** BUTTONS ****
      //*****************
      // Display the Save and Submit and Save buttons unless the page mode is VIEW. 
      if (!pageMode.equals(PageModeConstants.VIEW)) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\">\r\n        <br>\r\n        <hr>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      ");
if (bShowDeleteButton) {
          out.write("\r\n      <td width=\"85%\" class=\"alignLeft\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnDelete");
          _jspx_th_impact_ButtonTag_1.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_1.setAlign("left");
          _jspx_th_impact_ButtonTag_1.setForm("frmSafetyAssessment");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/SafetyAssessment/deleteSafetyAssessment");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
} else {
          out.write("\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        &nbsp;\r\n      </td>\r\n      ");
}
          out.write("\r\n      ");
if(bShowSaveAndSubmitButton){
          out.write("\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmSafetyAssessment");
          _jspx_th_impact_ButtonTag_2.setAction("/investigation/SafetyAssessment/saveAndSubmitSafetyAssessment");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
}
       
          out.write("\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmSafetyAssessment");
          _jspx_th_impact_ButtonTag_3.setAction("/investigation/SafetyAssessment/saveSafetyAssessment");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}

          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_9.setValue( tsLastUpdate );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("saTsLastUpdate");
          _jspx_th_impact_validateInput_10.setValue( saTsLastUpdate );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      out.write("\r\n<br>\r\n");
 if (bShowDeleteButton) { 
      out.write('\r');
      out.write('\n');
      //  impact:ifServerImpact
      gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
      _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifServerImpact_0.setParent(null);
      int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
      if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Forms Launch\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
        //  impact:documentList
        gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
        _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
        _jspx_th_impact_documentList_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_0);
        _jspx_th_impact_documentList_0.setPageMode("2");
        _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
        int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
        if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n          ");
            //  impact:document
            gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
            _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
            _jspx_th_impact_document_0.setDisplayName("Safety Assessment");
            _jspx_th_impact_document_0.setProtectDocument(true);
            _jspx_th_impact_document_0.setCheckForNewMode(false);
            _jspx_th_impact_document_0.setDocType("FAS01O00");
            _jspx_th_impact_document_0.setDocExists(false);
            int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
            if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n            ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_0.setName("pCase");
                _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdCase(request) ) );
                int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
                if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n            ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_1.setName("pStage");
                _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData.getUlIdStage(request) ));
                int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
                if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n            ");
                //  impact:documentParameter
                gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
                _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
                _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
                _jspx_th_impact_documentParameter_2.setName("pEvent");
                _jspx_th_impact_documentParameter_2.setValue(String.valueOf(GlobalData.getUlIdEvent(request) ));
                int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
                if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n          ");
                int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n        ");
            int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <br>\r\n  ");
 /* end Forms */ 
        out.write("\r\n\r\n");
      }
      if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
 } 
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
