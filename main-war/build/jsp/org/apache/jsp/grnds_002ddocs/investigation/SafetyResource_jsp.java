package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceHshldMemberBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class SafetyResource_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
  
  BaseSessionStateManager state = (BaseSessionStateManager)
          request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  
  SafetyResourceRetrieveSO safetyResourceRetrieveSO = 
              (SafetyResourceRetrieveSO) state.getAttribute("safetyResourceRetrieveSO", request); 
              
              
              
  boolean isStageClosed = (Boolean) state.getAttribute("isStageClosed", request);
              
              
  
  //Set Page Mode and related variables for display
  String pageMode = PageMode.getPageMode(request);
  boolean bIsEditable = !pageMode.equals(PageModeConstants.VIEW);
  boolean bIsNew = (safetyResourceRetrieveSO.getUlIdEvent()==0);
  String cdEventStatus = safetyResourceRetrieveSO.getCdEventStatus();
  String tsLastUpdate ="";
  boolean bDocumentExists = false;
  
  String szDisabled = "false";
  String szDeleteIsNotVisible = "false";
  String szAddIsNotVisible = "false";
  String saveAndSubmit = "false";
    
  if (!bIsEditable){  
     szDisabled = "true";
  }
 
  if ((!bIsEditable) || bIsNew) {
     szAddIsNotVisible = "true";
     szDeleteIsNotVisible = "true";
     saveAndSubmit = "true";
  }
  
  // SMS 77962 removing the add placement button if the stage is closed. 
  if(isStageClosed){
  szAddIsNotVisible = "true";
  }
  if(CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)){
     szDisabled = "true";
     szDeleteIsNotVisible = "true";
     saveAndSubmit = "true";
  }
  
  if(CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)){
     szDeleteIsNotVisible = "true";
 //SMS 113884 4.3 Capta Removing the save and submitt button while the page is in approval mode. 
     if (GlobalData.isApprovalMode(request)){
     saveAndSubmit = "true";
     }
  }
  
  if (safetyResourceRetrieveSO.getUlIdEvent() != 0) {
      tsLastUpdate = DateHelper.toISOString(safetyResourceRetrieveSO.getDtLastUpdate());
  }
  
  if (ArchitectureConstants.Y.equals(safetyResourceRetrieveSO.getIndBLOBExistsInDatabase()))
  {
    bDocumentExists = true;
  }

  //Initialize the display variables for the page
  int tabIndex = 1;
  
  //Populate key return objects for the display
  List<SafetyResourcePersonBean> personSafetyResourceList =  safetyResourceRetrieveSO.getPersonSafetyResource();
  List<Integer> householdMemberList = safetyResourceRetrieveSO.getHshldMembers();
  List<SafetyResourceHshldMemberBean> principalsCollateralList = safetyResourceRetrieveSO.getPrincipalsCollaterals();
  List<SafetyResourceChildRetrieveSO> savedPlacementsList = safetyResourceRetrieveSO.getSrChildren();
  
  //STGAP00014329: Added new section " Children Considered For Placement"
  List<Integer> childrenConsideredList = safetyResourceRetrieveSO.getChildrenConsideredList();
  List<SafetyResourceHshldMemberBean> memeberPKHouseHoldUnder18List = safetyResourceRetrieveSO.getMemeberPKHouseHoldUnder18List();
  state.setAttribute("childrenConsideredList", childrenConsideredList, request);
  state.setAttribute("memeberPKHouseHoldUnder18List", memeberPKHouseHoldUnder18List, request);
  
  //Set attributes back into state that will be needed to process updates and perform validation
  state.setAttribute("savedHouseholdMemberList", householdMemberList, request);
  state.setAttribute("principalsCollateralList", principalsCollateralList, request);
  state.setAttribute("savedPlacementsList", savedPlacementsList, request);

  //Declare specific option list to show the names of persons over 18 for safety resources
  List<Option> resourceList = new ArrayList<Option>();
  
  //Populate list of potential safety resources
  if (!personSafetyResourceList.isEmpty()){
  
      for (Iterator<SafetyResourcePersonBean> it = personSafetyResourceList.iterator(); it.hasNext();) {
          SafetyResourcePersonBean safetyResourcePersonBean = it.next();
          String idPerson = "";
          idPerson = String.valueOf(safetyResourcePersonBean.getUlIdChild());
          String nmPerson = "";
          nmPerson = safetyResourcePersonBean.getNmChildFull();
          resourceList.add(new Option(idPerson, nmPerson));
       }
  
  }
  
  //If safety resource have already been selected, set the value to default the option and
  //disable the dropdown
  String szIdPrimaryRsrc = "";
  String szIdSecondaryRsrc = ""; 
  String primaryDisable = szDisabled;
  String secondaryDisable = szDisabled;

  if ((((Integer) safetyResourceRetrieveSO.getUlIdPrimary()) != null) && 
                                          (safetyResourceRetrieveSO.getUlIdPrimary() != 0)) 
  {
  
    szIdPrimaryRsrc = String.valueOf(safetyResourceRetrieveSO.getUlIdPrimary());
    primaryDisable = "true";
  }
  
  if (((Integer)(safetyResourceRetrieveSO.getUlIdSecondary()) != null) && 
                                         (safetyResourceRetrieveSO.getUlIdSecondary() != 0)) 
  {
  
    szIdSecondaryRsrc  = String.valueOf(safetyResourceRetrieveSO.getUlIdSecondary());
    secondaryDisable = "true";
  }
  
  //STGAP00014329: Added new dates to the page as per MR-20
  String dtRequestReceived = "";
  String dtHomeVisit = "";
  String txtComments = "";
  String indRecommend = "";
  String cdDenialReason= "";
  String indRecommend_yes = "false";
  String indRecommend_no = "false";
      
      String rb_indRecommend = safetyResourceRetrieveSO.getIndRecommendation();
      if("Y".equals(rb_indRecommend)){
        indRecommend_yes = "true";
      }
      else if("N".equals(rb_indRecommend)){
        indRecommend_no = "true";
      }
      
      
    if (safetyResourceRetrieveSO.getCdDenialReason() != null){  
    cdDenialReason =   safetyResourceRetrieveSO.getCdDenialReason();
  } 
  
   if (safetyResourceRetrieveSO.getTxtComments() != null){  
    txtComments =   safetyResourceRetrieveSO.getTxtComments();
  }  
      
  
  if (safetyResourceRetrieveSO.getDtRequestReceived() != null) 
  {  
    dtRequestReceived =   FormattingHelper.formatDate(safetyResourceRetrieveSO.getDtRequestReceived());
  }
  if (safetyResourceRetrieveSO.getDtHomeVisit() != null) 
  {  
    dtHomeVisit =   FormattingHelper.formatDate(safetyResourceRetrieveSO.getDtHomeVisit());
  }

   

      out.write("\r\n\r\n");
      out.write("\r\n\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");
      out.write(" \r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n\r\nwindow.onload = function ()\r\n{\r\n  frmSafetyResource.hdnUlIdSrChild.value = 0;\r\n}\r\n\r\n");
      out.write("\r\n\r\nfunction safetyResourceChild(ulIdSrChild)\r\n{\r\n  cancelValidation();\r\n  frmSafetyResource.hdnUlIdSrChild.value = ulIdSrChild;\r\n  submitValidateForm( 'frmSafetyResource', '/investigation/SafetyResource/displaySafetyResourceChild' );\r\n}\r\n\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmSafetyResource');\r\n}\r\n\r\n</script>\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSafetyResource");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/SafetyResource/displaySafetyChild");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyResourceCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n \r\n ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_0.setValue(tsLastUpdate);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n \r\n ");
//STGAP00014329: Added Approval Status
  if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)) && 
       (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus) || CodesTables.CEVTSTAT_APRV.equals(cdEventStatus) ||
        CodesTables.CEVTSTAT_COMP.equals(cdEventStatus))) {
      String action = ApprovalStatusConversation.DISPLAY_URI;
      if (GlobalData.isApprovalMode(request)) {
        action = "/investigation/SafetyResource/submitApproval";
      }


          out.write("\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmSafetyResource");
          _jspx_th_impact_ButtonTag_0.setAction(action);
          _jspx_th_impact_ButtonTag_0.setDisabled("false");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write("\r\n <br>\r\n <br>\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Safety Resources <i style=\"color:red\">Dropdowns populated from Person Detail by selecting the Safety Resource checkbox.</i>\r\n      </th>\r\n    </tr>\r\n    <tr> \r\n     <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Primary Safety Resource");
          _jspx_th_impact_validateSelect_0.setName("selPrimaryResource");
          _jspx_th_impact_validateSelect_0.setId("selPrimaryResource");
          _jspx_th_impact_validateSelect_0.setOptions(resourceList);
          _jspx_th_impact_validateSelect_0.setDisabled( primaryDisable  );
          _jspx_th_impact_validateSelect_0.setValue( szIdPrimaryRsrc );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n      <td>\t\t  <span class=\"formRequiredText\">*</span>\r\n      \r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtRequestReceived");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Date Request Received");
          _jspx_th_impact_validateDate_0.setValue(dtRequestReceived);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled(szDisabled );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t</td>\r\n     \r\n   </tr> \r\n   \r\n   <tr> \t\r\n     <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Secondary Safety Resource");
          _jspx_th_impact_validateSelect_1.setName("selSecondaryResource");
          _jspx_th_impact_validateSelect_1.setId("selSecondaryResource");
          _jspx_th_impact_validateSelect_1.setOptions(resourceList);
          _jspx_th_impact_validateSelect_1.setDisabled( secondaryDisable  );
          _jspx_th_impact_validateSelect_1.setValue( szIdSecondaryRsrc );
          _jspx_th_impact_validateSelect_1.setRequired("false");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n\t\t  <td><span class=\"formRequiredText\">*</span>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtHomeVisit");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setLabel("Date of Home Visit");
          _jspx_th_impact_validateDate_1.setValue(dtHomeVisit);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setDisabled(szDisabled );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t  </td>\r\n\t\t  </tr>\r\n\t\t  <tr>\r\n\t\t  <td><span class=\"formRequiredText\">*</span>\r\n\t\t\t\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t        <td colspan=\"3\">\r\n\t\t\t \r\n      \t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setLabel("Yes");
          _jspx_th_impact_validateInput_1.setName("indRecommendation");
          _jspx_th_impact_validateInput_1.setValue("Y");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setChecked(indRecommend_yes);
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     \t\t\t\t ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setLabel("No");
          _jspx_th_impact_validateInput_2.setName("indRecommendation");
          _jspx_th_impact_validateInput_2.setValue("N");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setChecked(indRecommend_no);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    </tr>\r\n    <tr>\r\n    <td colspan=\"3\">\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Reason for denial?");
          _jspx_th_impact_validateSelect_2.setName("selDenialReason");
          _jspx_th_impact_validateSelect_2.setId("selDenialReason");
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CSRPLDEN );
          _jspx_th_impact_validateSelect_2.setValue(cdDenialReason);
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n           <td>\r\n\t             &nbsp;\r\n\t   \t</td>\r\n     </tr>\r\n     <tr>\r\n     <td>\r\n     <span class=\"formCondRequiredText\">&#135;</span>\r\n     <label for=\"txtComments\"> Comments:</label>\r\n     </td>\r\n     <td colspan=\"3\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtComments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setRows("3");
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
              out.write(' ');
              out.print(txtComments);
              out.write("\r\n\t ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n     </tr>\r\n\r\n  </table>  \r\n  <br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Children Considered for Safety Resource Placement<i style=\"color:red\"> Section populated from Person Detail by selecting Yes in the Member of Primary Caretaker's Household dropdown.</i>\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n    <td colspan=\"4\">\r\n    <div id=\"scrollBar\" style=\"height:100;width:762px;overflow:auto\" class=\"tableborderList\">\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"tableborder\">\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t    <th class=\"thList\"></th>\r\n\t\t    <th>Name</th>\r\n\t\t    <th>Role</th>\r\n\t\t    <th>Relation/Interest</th>\r\n\t\t   </tr> \r\n\t\t              \r\n\t\t          ");
 
		            if(memeberPKHouseHoldUnder18List.isEmpty())
		            {
		          
          out.write("\r\n\t\t          <tr class=\"odd\">\r\n\t\t            <td colspan=\"5\">\r\n\t\t              ");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("\r\n\t\t            </td>\r\n\t\t          </tr>\r\n\t\t          ");

		          }
		          else
		          {
		            // The following code displays all members of PK household and prefills the checkbox if selected
		            int loopCount = 0;
		            for (Iterator <SafetyResourceHshldMemberBean> it = memeberPKHouseHoldUnder18List.iterator(); it.hasNext();) {
		            
		                SafetyResourceHshldMemberBean memeberPKHouseHoldUnder18 = it.next();
		                Integer ulIntIdPerson = (Integer) memeberPKHouseHoldUnder18.getUlIdPerson();
		                String szChecked = "true";
		                
		                if (!childrenConsideredList.contains(ulIntIdPerson)){
		                     szChecked = "false";
		                 }
		                 
		                 String checkId = "cbxChildren_"+loopCount;
		              
		          
          out.write("\r\n\t\t          <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n\t\t            <td>\r\n\t\t            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf(loopCount) );
          _jspx_th_impact_validateInput_3.setName( checkId );
          _jspx_th_impact_validateInput_3.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_3.setChecked( szChecked );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("              \r\n\t\t            </td>\r\n\t\t            <td>");
          out.print( memeberPKHouseHoldUnder18.getNmPersonFull() );
          out.write("</td>\r\n\t\t            <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CROLEALL, memeberPKHouseHoldUnder18.getSzRole() ) );
          out.write("</td>\r\n\t\t            <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CRPTRINT, memeberPKHouseHoldUnder18.getSzRelationship() ) );
          out.write("</td>\r\n\t\t          </tr>\r\n\t\t          ");

		                loopCount++;
		              } // end iterator of member of PK household
		            } // end else
		          
          out.write("\r\n\t\t</table>\r\n\t</div>\r\n\t</td>\r\n\t</tr>\r\n</table>\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n   <tr>\r\n      <th colspan=\"4\">\r\n        Safety Resource Household Members\r\n      </th>\r\n   </tr>\r\n   <tr>\r\n   <td colspan=\"4\">\r\n   <div id=\"scrollBar\" style=\"height:200;width:762px;overflow:auto\" class=\"tableborderList\"> \r\n\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"tableborder\">\r\n\t      <tr>\r\n\t        <th class=\"thList\"></th>\r\n\t        <th class=\"thList\">Name</th>\r\n\t        <th class=\"thList\">Type</th>\r\n\t        <th class=\"thList\">Role</th>\r\n\t        <th class=\"thList\">Relation/Interest</th>\r\n\t      </tr>\r\n\t     \r\n\t          ");
 //handle cleanly if no principals or collaterals exist
	            if(principalsCollateralList.isEmpty())
	            {
	          
          out.write("\r\n\t          <tr class=\"odd\">\r\n\t            <td colspan=\"5\">\r\n\t              ");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("\r\n\t            </td>\r\n\t          </tr>\r\n\t          ");

	          }
	          else
	          {
	            // The following code displays all principals or collaterals and prefills the checkbox if selected
	            int loopCount = 0;
	            for (Iterator <SafetyResourceHshldMemberBean> it = principalsCollateralList.iterator(); it.hasNext();) {
	            
	                SafetyResourceHshldMemberBean principalCollateral = it.next();
	                Integer ulIntIdPerson = (Integer) principalCollateral.getUlIdPerson();
	                String szChecked = "true";
	                
	                if (!householdMemberList.contains(ulIntIdPerson)){
	                     szChecked = "false";
	                 }
	                 
	                 String checkId = "cbx_"+loopCount;
	              
	          
          out.write("\r\n\t          <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n\t            <td>\r\n\t            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf(loopCount) );
          _jspx_th_impact_validateInput_4.setName( checkId );
          _jspx_th_impact_validateInput_4.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_4.setChecked( szChecked );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("              \r\n\t            </td>\r\n\t            <td>");
          out.print( principalCollateral.getNmPersonFull() );
          out.write("</td>\r\n\t            <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CPRSNTYP, principalCollateral.getSzType() ) );
          out.write("</td>\r\n\t            <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CROLEALL, principalCollateral.getSzRole() ) );
          out.write("</td>\r\n\t            <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CRPTRINT, principalCollateral.getSzRelationship() ) );
          out.write("</td>\r\n\t          </tr>\r\n\t          ");

	                loopCount++;
	              } // end iterator of principals and collaterals
	            } // end else
	          
          out.write("\r\n\t    </table>\r\n    </div>\r\n    </td>\r\n    </tr>\r\n</table>\r\n<br>\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Children Placed With Safety Resource\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n    <td colspan=\"4\">\r\n    <div id=\"scrollBar\" style=\"height:100;width:762px;overflow:auto\" class=\"tableborderList\">\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"2\" border=\"0\" class=\"tableborder\">\r\n\t\t  <tr class=\"subDetail\">\r\n\t\t    <th>Child Name</th>\r\n\t\t    <th>Start Date</th>\r\n\t\t    <th>End Date</th>\r\n\t\t    <th>Primary SR Relationship</th>\r\n\t\t   </tr> \r\n\t\t          ");
// If no children have been placed with the current safety resource
		            if( savedPlacementsList.isEmpty())
		            {
		          
          out.write("\r\n\t\t          <tr class=\"odd\">\r\n\t\t            <td colspan=\"4\">\r\n\t\t              ");
          out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
          out.write("\r\n\t\t            </td>\r\n\t\t          </tr>\r\n\t\t          ");

		          }
		          else
		          { // Code iterates through the list of returned placements and displays to page
		            int loopCount = 0;
		            for (Iterator <SafetyResourceChildRetrieveSO> it = savedPlacementsList.iterator(); it.hasNext();) {
		            
		                SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = it.next();
		                List<SafetyResourcePersonBean> safetyResourceChildList = 
		                                               safetyResourceChildRetrieveSO.getSafetyResourceChildList();
		                SafetyResourcePersonBean safetyResourcePersonBean = safetyResourceChildList.get(0);
		              
		          
          out.write("\r\n\t\t          <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n\t\t            <td><a href=\"javascript:safetyResourceChild(' ");
          out.print(String.valueOf(safetyResourceChildRetrieveSO.getUlIdSrChild()) );
          out.write("')\" \r\n\t\t                   tabIndex=\"");
          out.print( tabIndex++ );
          out.write('"');
          out.write('>');
          out.print( safetyResourcePersonBean.getNmChildFull() );
          out.write("</a></td>\r\n\t\t            <td>");
          out.print( FormattingHelper.formatDate( safetyResourceChildRetrieveSO.getDtStart() ) );
          out.write("</td>\r\n\t\t            <td>");
          out.print( FormattingHelper.formatDate( safetyResourceChildRetrieveSO.getDtEnd() ) );
          out.write("</td>\r\n\t\t            <td>");
          out.print( Lookup.simpleDecodeSafe( CodesTables.CRPTRINT, safetyResourceChildRetrieveSO.getCdRelationshipPrimary() ) );
          out.write("</td>\r\n\t\t          </tr>\r\n\t\t          ");

		                loopCount++;
		              } // end iterator of safety resource child records
		            } // end else 
		          
          out.write("\r\n\t\t</table>\r\n\t</div>\r\n\t</td>\r\n\t</tr>\r\n</table>\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n     <tr> <td width=\"80%\">\r\n                  ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAddPlacement");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setDisabled(szAddIsNotVisible );
          _jspx_th_impact_ButtonTag_1.setForm("frmSafetyResource");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/SafetyResource/displaySafetyResourceChild");
          _jspx_th_impact_ButtonTag_1.setBackSafe("false");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   </tr>\r\n  </table>\r\n  <br>\r\n  \r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr> \r\n\t\t<td width=\"85%\" class=\"alignLeft\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnDelete");
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmSafetyResource");
          _jspx_th_impact_ButtonTag_2.setAction("/investigation/SafetyResource/deleteSafetyResource");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setDisabled(szDeleteIsNotVisible );
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t\t\r\n        ");
//STGAP00014329: Added save and submit
          out.write("\r\n        <td class=\"alignRight\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_3.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_3.setForm("frmSafetyResource");
          _jspx_th_impact_ButtonTag_3.setAction("/investigation/SafetyResource/saveSubmitSafetyResourceAssessment");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_3.setDisabled(saveAndSubmit);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td> \r\n          \r\n\t\t<td width=\"5%\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmSafetyResource");
          _jspx_th_impact_ButtonTag_4.setAction("/investigation/SafetyResource/saveSafetyResource");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n   </tr>\r\n  </table>\r\n<br> \r\n");
          out.write("\r\n \r\n");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnUlIdEvent");
          _jspx_th_impact_validateInput_6.setValue( String.valueOf(safetyResourceRetrieveSO.getUlIdEvent()) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnPreviousDenialReason");
          _jspx_th_impact_validateInput_7.setValue( String.valueOf(safetyResourceRetrieveSO.getCdDenialReason()) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \t  \r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  \r\n");
 /* start Forms and Reports */ 
      out.write('\r');
      out.write('\n');

boolean protectDoc = false;
boolean preFillAlways = true;

//STGAP00014329: After the page is saved for the first time, 
//the user is able to launch the Safety Resource Assessment form using the Document button 
if(pageMode.equals(PageModeConstants.VIEW) || (cdEventStatus != null && cdEventStatus != "")){ 
 
 //STGAP00014333 Document should be display only and should not prefill if the form is approved or user doesnt have stage access
  if(pageMode.equals(PageModeConstants.VIEW) || "APRV".equals(cdEventStatus))
  {
  protectDoc = true;
  preFillAlways = false;
  
  }  

      out.write("\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Safety Resource Assessment\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnDocument.gif");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n           ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Safety Resource Assessment");
          _jspx_th_impact_document_0.setName("frmDocumentTag");
          _jspx_th_impact_document_0.setProtectDocument( protectDoc );
          _jspx_th_impact_document_0.setPostInSameWindow(false);
          _jspx_th_impact_document_0.setPreFillAlways(false);
          _jspx_th_impact_document_0.setDocType("FAS05O00");
          _jspx_th_impact_document_0.setDocExists( bDocumentExists );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sCase");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdCase(request) ) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(safetyResourceRetrieveSO.getUlIdStage()));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("sEvent");
              _jspx_th_impact_documentParameter_2.setValue(String.valueOf(safetyResourceRetrieveSO.getUlIdEvent()));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t   ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
} 
      out.write("\r\n\r\n\r\n");
 /* end Forms and Reports */ 
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_validateDisplayOnlyField_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_0.setName("dspRepType");
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Are you recommending the Primary Safety Resource for Placement?");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_5.setName("hdnUlIdSrChild");
    _jspx_th_impact_validateInput_5.setValue("0");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
