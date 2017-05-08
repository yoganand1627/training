package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FCGSSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public final class FCGSDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!--Start Main Content-->\r\n");
BaseSessionStateManager state =
      //(BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      FCGSSubmoduleConversation.getSessionStateManager(request);

      
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"Javascript1.2\">\r\n  // Check for changes before navigating off\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n</script>\r\n");
List<StepBean> stepBeanList = new ArrayList<StepBean>();
      List<StepBean> savedStepBeanList = new ArrayList<StepBean>();
      List<StepBean> newStepBeanList = new ArrayList<StepBean>();
      List<StepBean> remStepBeanList = new ArrayList<StepBean>();
      String editableMode = ArchitectureConstants.TRUE;
      String stepCodesTable = "";
      String cgCodesTable = "";
      String fieldsToBeSpellChecked = "txtGoals";
      String goalText = "";
      String goalId = "";
      String other = "";
      int arrayIndex = ContextHelper.getIntSafe(request, "fcgsIndex");
      int loopCounter = 0;
      int numSteps = 0;
      int tabIndex = 1;
      boolean displayReset = true;
      boolean displayDelete = false;

      // Get the page mode that was passed to the FCGS submodule by the including JSP.
      String pageMode = (String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request);
      if (pageMode == null) {
        pageMode = PageModeConstants.MODIFY;
      }

      if (pageMode.equals(PageModeConstants.MODIFY)) {
        editableMode = ArchitectureConstants.FALSE;
        displayDelete = true;
      }
      //addStepIndicator indicates if the user wishes to add a new step (which is not predefined)
      String addStepIndicator = (String) state.getAttribute("addStepIndicator", request);
      String deleteStepIndicator = (String) state.getAttribute("deleteStepIndicator", request);
      GoalsBean selectedGoal = (GoalsBean) state.getAttribute("GoalsBean", request);
      String isAdd = (String) state.getAttribute("isAddFCGS", request);
      //The or condition in the if statement is added to accomodate the scenario where the goaltext is changed 
      //in add mode and the add a step button is clicked with out saving

      if (!ArchitectureConstants.TRUE.equals(isAdd) || ArchitectureConstants.Y.equals(addStepIndicator)) {
        goalText = FormattingHelper.formatString(selectedGoal.getLdTxtGoal());
        goalId = Integer.toString(selectedGoal.getIdGoal());
        other = FormattingHelper.formatString(selectedGoal.getLdTxtOth());
        savedStepBeanList = selectedGoal.getStepBeanList();
      }

      String goalReason = FormattingHelper.formatString(selectedGoal.getCdGoalRsn());
      String goalType = FormattingHelper.formatString(selectedGoal.getCdGoalTyp());
      String goalTypeDecoded = "";
      String fgcsTsLastUpdate = DateHelper.toISOString(selectedGoal.getDtLastUpdate());
      String codesTableRsn = "";
      if ("REU".equals(goalType)) {
        codesTableRsn = "CRURSN";
        goalTypeDecoded = "Reunification";
      } else if ("NRE".equals(goalType)) {
        codesTableRsn = "CNRRSN";
        goalTypeDecoded = "Nonreunification";
      } else if ("WTL".equals(goalType)) {
        codesTableRsn = "CWTLPGLS";
        goalTypeDecoded = "WTLP";
      } else if ("DFC".equals(goalType)) { // subsection DFCS in Child Plans does not have Goal reason so no code table
        codesTableRsn = "";
        goalTypeDecoded = "DFCS";
      } else if ("AFC".equals(goalType)) {
        codesTableRsn = "";
        goalTypeDecoded = "Aftercare";
      }
      String goalReasonDecoded = Lookup.simpleDecodeSafe(codesTableRsn, goalReason);

      //Setting the appropriate codes tables for the different goal type and goal reason combinations.
      if ("DFC".equals(goalType)) {
        cgCodesTable = "CCGDFCS";
        stepCodesTable = "CDFCSSG";
      } else if ("REU".equals(goalType)) {
        cgCodesTable = "CCGRU";
        if ("PHY".equals(goalReason)) {
          stepCodesTable = "CRUPA";
        } else if ("SXA".equals(goalReason)) {
          stepCodesTable = "CRUSA";
        } else if ("EMO".equals(goalReason)) {
          stepCodesTable = "CRUEA";
        } else if ("NEG".equals(goalReason)) {
          stepCodesTable = "CRUN";
        } else if ("MED".equals(goalReason)) {
          stepCodesTable = "CRUMN";
        } else if ("EDU".equals(goalReason)) {
          stepCodesTable = "CRUEDN";
        } else if ("ABA".equals(goalReason)) {
          stepCodesTable = "CRUA";
        } else if ("SUA".equals(goalReason)) {
          stepCodesTable = "CRUSAP";
        } else if ("MPP".equals(goalReason)) {
          stepCodesTable = "CRUMPIP";
        } else if ("OTH".equals(goalReason)) {
          stepCodesTable = "";
        }
      } else if ("NRE".equals(goalType)) {
        cgCodesTable = "CCGNRUN";
        if ("GUA".equals(goalReason)) {
          stepCodesTable = "CNRG";
        } else if ("LTF".equals(goalReason)) {
          stepCodesTable = "CNRPPLFC";
        } else if ("EMA".equals(goalReason)) {
          stepCodesTable = "CNRPPLE";
        } else if ("FWR".equals(goalReason)) {
          stepCodesTable = "CNRULFLR";
        } else if ("ADO".equals(goalReason)) {
          stepCodesTable = "CNRA";
        } else if ("XXX".equals(goalReason)) {
          stepCodesTable = "";
        }
      } else if ("AFC".equals(goalType)) {
        cgCodesTable = "";
        stepCodesTable = "";
      } else if ("WTL".equals(goalType)) {
        cgCodesTable = "CCGWTLP";
        if ("LSA".equals(goalReason)) {
          stepCodesTable = "CWLSSO";
        } else if ("WES".equals(goalReason)) {
          stepCodesTable = "CWWEJS";
        } else if ("WEE".equals(goalReason)) {
          stepCodesTable = "CWWEE";
        } else if ("HIS".equals(goalReason)) {
          stepCodesTable = "CWHSSO";
        } else if ("GED".equals(goalReason)) {
          stepCodesTable = "CWSO";
        } else if ("MHS".equals(goalReason)) {
          stepCodesTable = "CWMHSFF";
        } else if ("LSK".equals(goalReason)) {
          stepCodesTable = "CWLSFF";
        } else if ("PSP".equals(goalReason)) {
          stepCodesTable = "CWPSEP";
        } else if ("PSA".equals(goalReason)) {
          stepCodesTable = "CWPSEA";
        } else if ("OTH".equals(goalReason)) {
          stepCodesTable = "";
        }
      }
      //Getting the default goal text for the selected Goal Type from the codes 
      //table while adding a new Goal. 
      if (ArchitectureConstants.TRUE.equals(isAdd) && !ArchitectureConstants.Y.equals(addStepIndicator)) {
        displayDelete = false;
        if (cgCodesTable != null && !"".equals(cgCodesTable)) {
          Iterator cgCodeIterator = Lookup.getCategoryCollectionSortedByDecode(cgCodesTable).iterator();
          while (cgCodeIterator.hasNext()) {
            Mapping cgColumns = (Mapping) cgCodeIterator.next();
            String cgDecode = cgColumns.getValue();
            String cgCode = cgColumns.getKey();
            if ("DFC".equals(goalType)) {
              goalText = cgDecode;
              break;
            }
            if (cgCode.equals(goalReason)) {
              goalText = cgDecode;
              break;
            }
          }

        }
      }
      //Getting all the predefined steps from the codes table for the selected Type Reason combination and replacing
      //default values for each step with the saved values if any.
      int numOfAddedSteps = 0;
      if (request.getAttribute("numOfAddedSteps") != null) {
        numOfAddedSteps = (Integer) request.getAttribute("numOfAddedSteps");
      }
      if (!ArchitectureConstants.Y.equals(addStepIndicator) && !ArchitectureConstants.Y.equals(deleteStepIndicator)) {
       //STGAP00008108: Here we remove all the steps that are not predefined, but added and saved by the user from the 
       //savedStepBeanList and save them in the newStepBeanList.In the end this newStepBeanList will be appended to the
       //step list that will be displayed on the page.This is to make sure the added steps are displayed at the bottom 
       //of the list after all the predefined steps.
       //Begin
        if (savedStepBeanList != null) {
          Iterator it = savedStepBeanList.iterator();
          while (it.hasNext()) {
            StepBean savedStep = (StepBean) it.next();
            if (!StringHelper.isValid(savedStep.getLdCdStepCode())) {
              newStepBeanList.add(savedStep);
              remStepBeanList.add(savedStep);
            }
          }
          if (!remStepBeanList.isEmpty()) {
            for (int i = 0; i < remStepBeanList.size(); i++) {
              savedStepBeanList.remove(remStepBeanList.get(i));
            }
          }
        }
        //End
        if (stepCodesTable != null && !"".equals(stepCodesTable)) {
        //Here all the predefined steps are accessed as the codeIterator collection from the codes table
        //and looped through.The inner while loop loops through the savedStepBeanList and checks if any
        //of the saved step code matches with the predefined step code. If it does than the saved step is 
        //assigned to the StepBean and the StepBean is saved to the stepBeanList.We are doing this because
        //even if only some of the predefined steps are selected and saved on the page, when the page is 
        //displayed all the predefined steps should be displayed in the same order with the saved steps
        //having the updated information.
          Iterator codeIterator = Lookup.getCategoryCollectionSortedByDecode(stepCodesTable).iterator();
          while (codeIterator.hasNext()) {
            Mapping columns = (Mapping) codeIterator.next();
            String decode = columns.getValue();
            String code = columns.getKey();
            StepBean stepBean = new StepBean();
            stepBean.setLdCdStepCode(code);
            stepBean.setLdTxtStep(decode);
            if (savedStepBeanList != null) {
              Iterator it = savedStepBeanList.iterator();
              while (it.hasNext()) {
                StepBean savedStep = (StepBean) it.next();
                if (code.equals(savedStep.getLdCdStepCode())) {
                  stepBean = savedStep;
                  break;
                }
              }
            }
            stepBeanList.add(stepBean);
          }
        } else if (("AFC".equals(goalType) || "XXX".equals(goalReason) || "OTH".equals(goalReason))
                   && !ArchitectureConstants.TRUE.equals(isAdd)) {
          stepBeanList = selectedGoal.getStepBeanList();
        }
        if (numOfAddedSteps > 0) {

          for (int i = 0; i < numOfAddedSteps; i++) {
            StepBean newStepBean = new StepBean();
            stepBeanList.add(newStepBean);
          }
        }
        //Here newStepBeanList which contains all the steps that are not predefined but added and saved by the user
        //is added to the list so that all the added steps can be displayed at the end after the predefined steps.
        if (newStepBeanList != null) {
          for (Iterator it = newStepBeanList.iterator(); it.hasNext();) {
            StepBean newStep = (StepBean) it.next();
            stepBeanList.add(newStep);
          }
        }
      } else {
        stepBeanList = selectedGoal.getStepBeanList();
      }

      //After displaying the added step need to set the indicator to null.
      if (ArchitectureConstants.Y.equals(addStepIndicator)) {
        state.setAttribute("addStepIndicator", null, request);
      }
      selectedGoal.setStepBeanList(stepBeanList);

      state.setAttribute("GoalsBean", selectedGoal, request);

      
      out.write("\r\n<script type=\"text/JavaScript\" language=\"Javascript\">\r\n\r\n  \r\n  //This function enables or disables the step fields for all steps dynamically\r\n  //depending on the checked or unchecked status of the Selected check box.\r\n  function enableStepFields(f0, f1, f2, f3, f4, f5, f8, f9, f10, f11, f12)\r\n  {\r\n    var cbxfield = eval(\"document.getElementById(\\\"\" + f0 + \"_Id\\\")\");\r\n    var field1 = eval(\"document.getElementById(\\\"\" + f1 + \"_Id\\\")\");\r\n    var field2 = eval(\"document.getElementById(\\\"\" + f2 + \"_Id\\\")\");\r\n    var field3 = eval(\"document.getElementById(\\\"\" + f3 + \"_Id\\\")\");\r\n    var field4 = eval(\"document.getElementById(\\\"\" + f4 + \"_Id\\\")\");\r\n    var field5 = eval(\"document.getElementById(\\\"\" + f5 + \"_Id\\\")\");\r\n    var field8 = eval(\"document.getElementById(f8)\");\r\n    var field9 = eval(\"document.getElementById(f9)\");\r\n    var field11 = eval(\"document.getElementById(\\\"\" + f11 + \"_Id\\\")\");\r\n    var field12 = eval(\"document.getElementById(\\\"\" + f12 + \"_Id\\\")\");\r\n    var disabled = cbxfield.checked;\r\n    if (disabled) {\r\n");
      out.write("      field1.disabled = false;\r\n      field2.disabled = false;\r\n      field3.disabled = false;\r\n      field4.disabled = false;\r\n      field5.disabled = false;\r\n      field11.disabled = false;\r\n      field12.disabled = false;\r\n      if (f10 == 'true') {\r\n        field8.style.display = '';\r\n        field9.style.display = 'none';\r\n      } else {\r\n        field9.style.display = '';\r\n        field8.style.display = 'none';\r\n      }\r\n    } else {\r\n      field1.disabled = true;\r\n      field2.disabled = true;\r\n      field3.disabled = true;\r\n      field4.disabled = true;\r\n      field5.disabled = true;\r\n      field11.disabled = true;      \r\n      field12.disabled = true;\r\n      field11.value=\"\";\r\n      field12.value=\"\";\r\n      if (f10 == 'true') {\r\n        field8.style.display = 'none';\r\n\r\n      } else {\r\n        field9.style.display = 'none';\r\n\r\n      }\r\n\r\n    }\r\n\r\n  }\r\n  function confirmDeleteThisSection()\r\n  {\r\n    var bUserResponse = confirm(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\");\r\n    if (bUserResponse)\r\n    {\r\n      disableValidation(\"frmFCGSDetail\");\r\n    }\r\n    return bUserResponse;\r\n  }\r\n  function confirmDeleteThisStep(indexOfTask)\r\n  {\r\n    var bUserResponse = confirm(\"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\");\r\n    if (bUserResponse)\r\n    {\r\n      document.frmFCGSDetail.hdnDelIndex.value = indexOfTask;\r\n      disableValidation(\"frmFCGSDetail\");\r\n    }\r\n    return bUserResponse;\r\n  }\r\n  //This function resets the step text when the reset button is clicked.\r\n  function setStepText(stName, hOriStepTxt)\r\n  {\r\n    var tfName = eval(\"document.getElementById(\\\"\" + stName + \"_Id\\\")\");\r\n    var hfOriStepTxt = eval(\"document.getElementById(\\\"\" + hOriStepTxt + \"_Id\\\")\"); \r\n    var oriStepTxt = hfOriStepTxt.value;\r\n    tfName.value = oriStepTxt;\r\n    return false;\r\n  }\r\n  //This function enables or disables the date fields on load based on if the checkbox selected is checked for that step\r\n  \r\n  function disableDateFields()\r\n  {\r\n    var loop = eval(\"document.getElementById(\\\"\" + \"numOfSteps_Id\\\")\");\r\n  \t\r\n    for (var q = 0; q < loop.value; q++) {    \r\n      var cbxName = eval(\"document.getElementById(\\\"\" + \"cbxSelected\" + q + \"_Id\\\")\");      \r\n      var dateAnt = eval(\"document.getElementById(\\\"\" + \"txtDtAntComp\" + q + \"_Id\\\")\");\r\n");
      out.write("      var dateAct = eval(\"document.getElementById(\\\"\" + \"txtDtActComp\" + q + \"_Id\\\")\");\r\n      var checked = cbxName.checked;\r\n      if (!checked) {            \r\n        dateAnt.disabled = true;\r\n        dateAct.disabled = true;\r\n      } else {\r\n        dateAnt.disabled = false;\r\n        dateAct.disabled = false;\r\n      }\r\n    }\r\n    return false;\r\n  }\r\n  \r\n  window.attachEvent('onload', disableDateFields);\r\n  //This function sets the hidden step id value when the delete button for the\r\n  //step is clicked.\r\n  function setDeleteParams(fnStepId) {\r\n    var stepId = eval(\"document.getElementById(\\\"\" + fnStepId + \"_Id\\\")\");\r\n    document.frmFCGSDetail.hdnDelStepId.value = stepId.value;\r\n  }\r\n\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFCGSDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/casemgmt/FCGSDetail/saveFCGSDetail");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FCGSCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("isAddFCGS");
          _jspx_th_impact_validateInput_0.setValue( isAdd );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("fcgsIndex");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(arrayIndex) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnGoalId");
          _jspx_th_impact_validateInput_2.setValue( goalId );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnGoalType");
          _jspx_th_impact_validateInput_3.setValue( goalType );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCDGoalRsn");
          _jspx_th_impact_validateInput_4.setValue( goalReason );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("fgcsTsLastUpdate");
          _jspx_th_impact_validateInput_7.setValue( fgcsTsLastUpdate );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
//*********************************
      //**** FCGS DETAIL ****
      //*********************************

      
          out.write("\r\n\r\n\t");
if (!pageMode.equals(PageModeConstants.VIEW) && !ArchitectureConstants.TRUE.equals(isAdd)) {

          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeletethisSection");
          _jspx_th_impact_ButtonTag_0.setImg("btnDeletethisSection");
          _jspx_th_impact_ButtonTag_0.setForm("frmFCGSDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmFCGSDetail')");
          _jspx_th_impact_ButtonTag_0.setEditableMode( displayDelete ? EditableMode.ALL : EditableMode.NONE );
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setAction("/casemgmt/FCGSDetail/deleteGoal");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmDeleteThisSection()");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
}

          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"3\">\r\n\t\t\t\tGoal\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tGoal Type\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtGoalType");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( goalTypeDecoded );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");
if (!"DFC".equals(goalType) && !"AFC".equals(goalType)) {

          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tReason\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtGoalReason");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( goalReasonDecoded );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setLabel("If other, explain");
          _jspx_th_impact_validateInput_8.setName("szTxtOther");
          _jspx_th_impact_validateInput_8.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_8.setColspan("1");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setDisabled( editableMode );
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setSize("50");
          _jspx_th_impact_validateInput_8.setMaxLength("50");
          _jspx_th_impact_validateInput_8.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_8.setValue( other );
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");
}

          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setLabel("Change/Goal");
          _jspx_th_impact_validateTextArea_0.setName("szTxtGoal");
          _jspx_th_impact_validateTextArea_0.setRequired("true");
          _jspx_th_impact_validateTextArea_0.setColspan("1");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("103");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setDisabled( editableMode );
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(goalText);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");
//************************
      //**** Steps ****
      //************************

      
          out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderList\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"thList\" colspan=\"2\">\r\n\t\t\t\t\tSteps\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");
// Display the Steps.
      if (!stepBeanList.isEmpty()) {
        Iterator iter = stepBeanList.iterator();
        while (iter.hasNext()) {
          StepBean stepBean = (StepBean) iter.next();

          String status = "";
          if (stepBean.getLdCdStatus() != null) {
            status = stepBean.getLdCdStatus();
          }
          if (stepBean.getLdCdStepCode() == null) {
            displayReset = false;

          }
          String isChecked;
          String stepEditableMode;
          String btnResVisibility;
          String btnDelVisibility;
          if ("Y".equals(stepBean.getIndSelected())) {
            isChecked = "true";
            stepEditableMode = "false";
            if (displayReset) {
              btnResVisibility = "";
              btnDelVisibility = "none";
            } else {
              btnDelVisibility = "";
              btnResVisibility = "none";
            }

          } else {
            btnResVisibility = "none";
            btnDelVisibility = "none";
            stepEditableMode = "true";
            isChecked = "false";
          }
          String append = "";
          String index = "errorIndex" + loopCounter;
          if (request.getAttribute(index) != null) {
            String eindex = (String) (request.getAttribute(index));
            if ("true".equals(eindex)) {
              stepEditableMode = "false";
              append = "_Disabled";
              if (displayReset) {
                btnResVisibility = "";
                btnDelVisibility = "none";
              } else {
                btnDelVisibility = "";
                btnResVisibility = "none";
              }

            }
          }

          out.write("\r\n\t\t\t<tr ");
          out.print( loopCounter % 2 == 1 ? "class='even'" : "" );
          out.write(">\r\n\t\t\t\t<td valign=\"top\">\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
String fieldName = "cbxSelected" + loopCounter;
          String fnSel = "cbxSelected" + loopCounter;
          String fnTxtPr = "szTxtPriority" + loopCounter;
          String fnTxtRsp = "szTxtRspns" + loopCounter;
          String fnTxtStep = "txtStep" + loopCounter;
          String fnTxtScmnt = "txtStepComm" + loopCounter;
          String fnStat = "szCdStatus" + loopCounter;
          String fnBtnRes = "resSpan" + loopCounter;
          String fnBtnDel = "delSpan" + loopCounter;
          String antCompDate = "txtDtAntComp" + loopCounter;
          String actCompDate = "txtDtActComp" + loopCounter;
          String IncOnClick = "enableStepFields('" + fnSel + "', '" + fnTxtPr + "', '" + fnTxtRsp + "', '" + fnTxtStep
                              + "', '" + fnTxtScmnt + "', '" + fnStat + "', '" + fnBtnRes + "', '" + fnBtnDel + "', '"
                              + displayReset + "', '" + antCompDate + "', '" + actCompDate + "');";

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setLabel("Selected");
          _jspx_th_impact_validateInput_9.setName( fieldName );
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setValue("Y");
          _jspx_th_impact_validateInput_9.setOnClick( IncOnClick );
          _jspx_th_impact_validateInput_9.setChecked( isChecked );
          _jspx_th_impact_validateInput_9.setDisabled( editableMode );
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
fieldName = "szTxtPriority" + loopCounter + append;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setLabel("Priority");
          _jspx_th_impact_validateInput_10.setName( fieldName );
          _jspx_th_impact_validateInput_10.setRequired("false");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setDisabled( stepEditableMode );
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setSize("2");
          _jspx_th_impact_validateInput_10.setMaxLength("2");
          _jspx_th_impact_validateInput_10.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatString( stepBean.getLdTxtPriority()) );
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
fieldName = "szTxtRspns" + loopCounter + append;
          fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", " + fieldName;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setLabel("Responsibility");
          _jspx_th_impact_validateInput_11.setName( fieldName );
          _jspx_th_impact_validateInput_11.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setDisabled( stepEditableMode );
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setSize("30");
          _jspx_th_impact_validateInput_11.setMaxLength("30");
          _jspx_th_impact_validateInput_11.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatString( stepBean.getLdTxtResponsibility()) );
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
// Step Id hidden field.
          fieldName = "hdnStepId" + loopCounter;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName( fieldName );
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatInt( stepBean.getIdStep()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t\t\t\t\t");
// Step Date Last Update hidden field.
          fieldName = "stepDtLastUpdate" + loopCounter + append;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName( fieldName );
          _jspx_th_impact_validateInput_13.setValue( DateHelper.toISOString( stepBean.getDtLastUpdate()) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t");
// Step Code hidden field.
          fieldName = "hdnStepCode" + loopCounter;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName( fieldName );
          _jspx_th_impact_validateInput_14.setValue( FormattingHelper.formatString( stepBean.getLdCdStepCode()) );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t");
// Original or Default step text hidden field.
          fieldName = "hdnOriStepTxt" + loopCounter;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName( fieldName );
          _jspx_th_impact_validateInput_15.setValue( Lookup.simpleDecodeSafe(stepCodesTable,stepBean.getLdCdStepCode()) );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t");
// Step Text hidden field.
          fieldName = "hdnStepText" + loopCounter;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName( fieldName );
          _jspx_th_impact_validateInput_16.setValue( FormattingHelper.formatString( stepBean.getLdTxtStep()) );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t");
//--------------------
          //--- Step ---
          //--------------------

          fieldName = "txtStep" + loopCounter + append;
          fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", " + fieldName;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setLabel("Step");
          _jspx_th_impact_validateTextArea_1.setName( fieldName );
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_1.setColspan("1");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("125");
          _jspx_th_impact_validateTextArea_1.setDisabled( stepEditableMode );
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(stepBean.getLdTxtStep()));
              out.write("\r\n\t\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
fieldName = "txtStepComm" + loopCounter + append;
          fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", " + fieldName;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setLabel("Comment");
          _jspx_th_impact_validateTextArea_2.setName( fieldName );
          _jspx_th_impact_validateTextArea_2.setRequired("false");
          _jspx_th_impact_validateTextArea_2.setColspan("1");
          _jspx_th_impact_validateTextArea_2.setRows("3");
          _jspx_th_impact_validateTextArea_2.setCols("125");
          _jspx_th_impact_validateTextArea_2.setOnBlur("if(this.value.length>1000){alert('Please enter no more than 300 characters of text in the Comment textbox.');}");
          _jspx_th_impact_validateTextArea_2.setDisabled( stepEditableMode );
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(stepBean.getLdTxtStepCmnts()));
              out.write("\r\n\t\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr ");
          out.print( loopCounter % 2 == 1 ? "class='even'" : "" );
          out.write(">\r\n\t\t\t\t<td colspan=\"2\" valign=\"top\">\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
fieldName = "szCdStatus" + loopCounter + append;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setLabel("Status");
          _jspx_th_impact_validateSelect_0.setDisabled(stepEditableMode );
          _jspx_th_impact_validateSelect_0.setName( fieldName );
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue(status);
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSTATUS");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t<td width=\"23%\">\r\n\t\t\t\t\t\t\t\t");
//------------------------------
          //--- Anticipated Completion ---
          //------------------------------
          String dateAsString = "";
          String cbxSelAnt = "cbxSelected" + loopCounter;
          if (stepBean.getDtAntComp() != null) {
            dateAsString = FormattingHelper.formatDate(stepBean.getDtAntComp());
          }

          fieldName = "txtDtAntComp" + loopCounter;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Anticipated Completion");
          _jspx_th_impact_validateDate_0.setName( fieldName );
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( dateAsString );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setWidth("15%");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t<td width=\"23%\">\r\n\t\t\t\t\t\t\t\t");
//------------------------------
          //--- Actual Completion ---
          //------------------------------
          dateAsString = "";
          String cbxSelAct = "cbxSelected" + loopCounter;
          if (stepBean.getDtActComp() != null) {
            dateAsString = FormattingHelper.formatDate(stepBean.getDtActComp());
          }
          fieldName = "txtDtActComp" + loopCounter;

          
          out.write("\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Actual Completion");
          _jspx_th_impact_validateDate_1.setName( fieldName );
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( dateAsString );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setWidth("15%");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t\t<tr>\r\n\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
String fieldNameRes;
          fieldNameRes = "resSpan" + loopCounter;

          // The Reset button should be displayed only if this
          // Step is editable.
          fieldName = "btnResetStep" + loopCounter;
          String fnhStext = "hdnStepText" + loopCounter;                              
          String sTextName = "txtStep" + loopCounter;  
          String hOriStepTxt = "hdnOriStepTxt" + loopCounter;            
          String resetFunctionString = "return setStepText('" + sTextName + "','" + hOriStepTxt + "');";

          
          out.write("\r\n\t\t\t\t\t\t\t\t<span id=\"");
          out.print(fieldNameRes);
          out.write("\" style=\"display:");
          out.print( btnResVisibility );
          out.write('"');
          out.write('>');
          out.write(' ');
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName( fieldName );
          _jspx_th_impact_ButtonTag_1.setImg("btnReset");
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setFunction( resetFunctionString );
          _jspx_th_impact_ButtonTag_1.setForm("frmFCGSDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/casemgmt/FCGSDetail/displayFCGSDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </span>\r\n\r\n\t\t\t\t\t\t\t\t");
String fieldNameDel;
          fieldNameDel = "delSpan" + loopCounter;
          out.write("\r\n\t\t\t\t\t\t\t\t");
fieldName = "btnDeleteStep" + loopCounter;
          String fnStepId = "hdnStepId" + loopCounter;
          String deleteFunctionString = "setDeleteParams('" + fnStepId + "');return confirmDeleteThisStep('"
                                        + loopCounter + "')";

          
          out.write("\r\n\t\t\t\t\t\t\t\t<span id=\"");
          out.print(fieldNameDel);
          out.write("\" style=\"display:");
          out.print( btnDelVisibility );
          out.write('"');
          out.write('>');
          out.write(' ');
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName( fieldName );
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setFunction( deleteFunctionString );
          _jspx_th_impact_ButtonTag_2.setForm("frmFCGSDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/casemgmt/FCGSDetail/deleteStep");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </span>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");
loopCounter++;
        } // end while ( iter.hasNext() )
      }//end if not empty

      
          out.write("\r\n\t\t</table>\r\n\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnAddStep");
          _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_3.setFunction("disableValidation('frmFCGSDetail')");
          _jspx_th_impact_ButtonTag_3.setDisabled( editableMode );
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmFCGSDetail");
          _jspx_th_impact_ButtonTag_3.setAction("/casemgmt/FCGSDetail/addGoalStep");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t<br>\r\n\t\t");
// The steps counter should be the number of steps in the
      // Collection plus 1 since the Collection is zero-based.
      numSteps = numSteps + loopCounter;

          out.write("\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("numOfSteps");
          _jspx_th_impact_validateInput_17.setValue( String.valueOf( loopCounter ) );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\t\t");
//*****************
      //**** BUTTONS ****
      //*****************

      
          out.write("\r\n\t\t<br>\r\n\t\t<hr>\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t");
// STGAP00004865 - it makes more sense to hide Spell Check when page is uneditable
      if (ArchitectureConstants.FALSE.equals(editableMode)) {

        
          out.write("\r\n\t\t\t\t<td width=\"90%\" align=\"right\">\r\n\t\t\t\t\t");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmFCGSDetail");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck( fieldsToBeSpellChecked );
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");
}

      
          out.write("\r\n\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnFCGSSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setForm("frmFCGSDetail");
          _jspx_th_impact_ButtonTag_4.setAction("/casemgmt/FCGSDetail/saveFCGSDetail");
          _jspx_th_impact_ButtonTag_4.setDisabled( editableMode );
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t");
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

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnDelStepId");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnDelIndex");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
