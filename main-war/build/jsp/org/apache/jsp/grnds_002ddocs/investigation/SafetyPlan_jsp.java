package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO.RowCasePersonResponsible;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyPlanConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonResonsibleSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

public final class SafetyPlan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
       * JSP Name:     Safety Plan
       * Created by:   Amit Patel
       * Date Created: 03/02/2007
       *
       * Description:
       * This JSP displays the details for a given Safety Plan. Depending upon
       * the user's privileges, the user can use this page to view and update Safety Pla
   
    
      /* Change History:
       * DATE		NAME		CHANGES
       * 11/4/08    charden		STGAP00010129 - do not show save and submit button when in approval status 
       *
       *
      */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      //Set the page mode to the mode that is passed in
      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }

      boolean approvalStatus = true;
      SafetyPlanRetrieveSO safetyPlanRetrieveSO = (SafetyPlanRetrieveSO) request.getAttribute("SafetyPlanRetrieveSO");

      ROWCCMN45DO eventDetails = safetyPlanRetrieveSO.getRowccmn45do();
      if ((eventDetails == null)
          || pageMode.equals(PageModeConstants.NEW)
          || (!SafetyPlanConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !SafetyPlanConversation.EVENT_STATUS_APRV
                                                                                                                                              .equals(eventDetails
                                                                                                                                                                  .getSzCdEventStatus()))) {
        approvalStatus = false;
      }

      //Initialize the display variables for the page
      int tabIndex = 1;
      int idSftyFctr = 0;

      String txtSafetyFactor = "";
      String txtChangetoMitigateSafetyFactor = "";
      String firstName = "";
      String middleName = "";
      String lastName = "";
      String fieldsToBeSpellChecked = "";
      String append = "";
      Date dtToBeCompletedBy = null;

      Date dtTsSafetyPlanLastUpdate = safetyPlanRetrieveSO.getDtLastUpdate();

      Date dtTsEventLastUpdate = null;
      if (safetyPlanRetrieveSO.getRowccmn45do() != null) {
        dtTsEventLastUpdate = safetyPlanRetrieveSO.getRowccmn45do().getTsLastUpdate();
      }
      Date dtTsSafetyFactorLastUpdate = null;

      boolean saveAndSubmit = true;
      boolean isApproval = GlobalData.isApprovalMode(request);
      //STGAP00010129 - do not show save and submit button when in approval status 
      if(isApproval){
        saveAndSubmit = false;
      }
      boolean save = true;
      boolean bShowReportDropDown = true;
      
      boolean bRowClose  = false;
      
      String careTakerAgree_Yes = "true";
      String careTakerAgree_No = "false";

      String txtActions = "";
      String txtComments = "";
      Date dtDiscWithCrtkr = safetyPlanRetrieveSO.getDtDiscWithCrtkr();

      careTakerAgree_Yes = "true";
      careTakerAgree_No = "false";

      String ind_careTaker = safetyPlanRetrieveSO.getIndCrtkrAgreesSp();
      if (ArchitectureConstants.N.equals(ind_careTaker)) {
        careTakerAgree_No = "true";
      } else {
        careTakerAgree_Yes = "true";
      }

      int factorRow = 0;
      int row = 0;

      
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\n\r\n//-- Called by Save button (function attribute)\r\n//-- Called by Save and Submit button (onClick attribute)\r\n\r\nfunction deleteThisSection(index)\r\n{\r\n  var bUserResponse ='true';\r\n    disableValidation(\"frmSafetyPlan\");\r\n    frmSafetyPlan.deleteFactorArrayIndex.value = index;\r\n  return bUserResponse;\r\n}\r\n\r\n\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSafetyPlan");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/SafetyPlan/saveSafetyPlan");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      ");
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
          _jspx_th_impact_ButtonTag_0.setForm("frmSafetyPlan");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/displayStatus");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      ");
} else {

      
          out.write("\r\n      <td class=\"alignLeft\" width=\"85%\">\r\n        &nbsp;\r\n      </td>\r\n      ");
}

      
          out.write("\r\n    </tr>\r\n  </table>\r\n\r\n <!--  <br>-->\r\n <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n    <tr>\r\n      <th colspan=\"4\">\r\n        Safety Plan\r\n      </th>\r\n    </tr>\r\n     \r\n    \r\n  ");
List<SafetyFactorSO> safetyFactorList = null;
      safetyFactorList = safetyPlanRetrieveSO.getSafetyFactorList();

      if (safetyFactorList == null || safetyFactorList.size() == 0) {
        safetyFactorList = new ArrayList<SafetyFactorSO>();
        safetyFactorList.add(new SafetyFactorSO());
        safetyPlanRetrieveSO.setSafetyFactorList(safetyFactorList);
         bShowReportDropDown= false;
      }
      factorRow = 0;
      if (safetyPlanRetrieveSO.getSafetyFactorList() != null) {
        Iterator safetyFactorListIt = safetyFactorList.iterator();
        while (safetyFactorListIt.hasNext()) {
          factorRow++;
         
          SafetyFactorSO safetyFactorSO = (SafetyFactorSO) safetyFactorListIt.next();
          idSftyFctr = safetyFactorSO.getIdSftyFctr();
          txtSafetyFactor = safetyFactorSO.getSzTxtSftyFctrDesc();
          txtChangetoMitigateSafetyFactor = safetyFactorSO.getSzTxtSftyFctrMitigate();
          firstName = safetyFactorSO.getNmFirstOthrResp();
          middleName = safetyFactorSO.getNmMiddleOthrResp();
          lastName = safetyFactorSO.getNmLastOthrResp();
          dtToBeCompletedBy = safetyFactorSO.getDtCompltdBy();
          txtActions = safetyFactorSO.getSzTxtDescActions();
          txtComments = safetyFactorSO.getSzTxtSftyFctrComments();
          dtTsSafetyFactorLastUpdate = safetyFactorSO.getDtLastUpdate();

          
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idSftyFctr" + factorRow );
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(idSftyFctr) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("dtTsSafetyFactorLastUpdate" + factorRow );
          _jspx_th_impact_validateInput_2.setValue( DateHelper.toISOString(dtTsSafetyFactorLastUpdate) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t<tr> \r\n    <td>\r\n    <table border=\"0\"  cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" > \r\n      <tr>\r\n        <td colspan=\"3\" style=\"background-color: #C0C0C0\">\r\n          Safety Factor:\r\n        </td>\r\n      </tr>\r\n\r\n      <tr>\r\n        ");
if ("".equals(fieldsToBeSpellChecked)) {
            fieldsToBeSpellChecked = "txtSafetyFactor" + factorRow + append;
          } else {
            fieldsToBeSpellChecked = fieldsToBeSpellChecked +", "+ "txtSafetyFactor" + factorRow + append  ;
          }

          
          out.write("\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setValue( txtSafetyFactor );
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("txtSafetyFactor" + factorRow  );
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setSize("100");
          _jspx_th_impact_validateInput_3.setMaxLength("80");
          _jspx_th_impact_validateInput_3.setConstraint("Comments");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n      </tr>\r\n\r\n      <tr>\r\n        <td colspan=\"3\">\r\n          Change to mitigate safety factor:\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        ");
fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", "+ "txtChangetoMitigateSafetyFactor" + factorRow + append;

          
          out.write("\r\n        <td>\r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtChangetoMitigateSafetyFactor" + factorRow );
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n            ");
              out.print(FormattingHelper.formatString(txtChangetoMitigateSafetyFactor));
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
          out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    </td>\r\n    </tr>\r\n    <tr>\r\n     <td> \r\n     <table  cellspacing=\"0\" cellpadding=\"4\" width=\"100%\" >\r\n      <tr>\r\n        <td colspan=\"4\" style=\"background-color: #C0C0C0\">\r\n          Person(s) Responsible:\r\n        </td>\r\n      </tr>\r\n      \r\n      ");
List casePersonResponsibleList = safetyPlanRetrieveSO.getCasePersonResponsibleList();
          row = 0;
          
          if (casePersonResponsibleList != null) {
            Iterator casePersonResponsibleListIt = casePersonResponsibleList.iterator();
            RowCasePersonResponsible rowCasePersonResponsible = null;
            while (casePersonResponsibleListIt.hasNext()) {
              String personSelected = ArchitectureConstants.FALSE;
              rowCasePersonResponsible = (RowCasePersonResponsible) casePersonResponsibleListIt.next();
              row++;
              List<PersonResonsibleSO> personResonsibleList = safetyFactorSO.getPersonResonsibleList();
              if (personResonsibleList != null) {
                Iterator personResonsibleListIt = personResonsibleList.iterator();
                while (personResonsibleListIt.hasNext()) {
                  PersonResonsibleSO personResonsibleSO = (PersonResonsibleSO) personResonsibleListIt.next();
                  if (personResonsibleSO.getIdPerson() == rowCasePersonResponsible.getIdPerson()) {
                    personSelected = ArchitectureConstants.TRUE;
                  }
                }
              }

              
          out.write("\r\n\r\n\r\n      ");
if (((row-1) % 2 == 0)) {
     		 bRowClose=true;

              
          out.write("\r\n      <tr>\r\n        ");
}

	              
          out.write("\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setLabel(rowCasePersonResponsible.getName());
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatInt(rowCasePersonResponsible.getIdPerson())  );
          _jspx_th_impact_validateInput_4.setChecked(personSelected);
          _jspx_th_impact_validateInput_4.setName("chkRespPerson" + factorRow +row );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        ");
if (((row-1) % 2 != 0)) {
				bRowClose=false;
              
          out.write("\r\n      \t\t</tr>\r\n    \t");

      		}
         
          out.write("\r\n      ");

       }
      
       if (bRowClose) {
     		 bRowClose=false;

              
          out.write("\r\n      \t\t</tr>\r\n        ");

          }
       	 
         }  
          
          out.write("\r\n    \r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("personRow" + factorRow );
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatInt(row));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </table>\r\n    </td> \r\n    </tr>\r\n    <!-- <br>-->\r\n    <tr>\r\n    <td> \r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          Other:\r\n        </td>\r\n      </tr>\r\n\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setValue( firstName );
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("txtFirst"+ factorRow );
          _jspx_th_impact_validateInput_6.setLabel("First");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setSize("12");
          _jspx_th_impact_validateInput_6.setMaxLength("12");
          _jspx_th_impact_validateInput_6.setConstraint("Name12");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setValue( middleName  );
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("txtMiddle" + factorRow);
          _jspx_th_impact_validateInput_7.setLabel("Middle");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setSize("12");
          _jspx_th_impact_validateInput_7.setMaxLength("12");
          _jspx_th_impact_validateInput_7.setConstraint("Name12");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n\r\n\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setValue( lastName  );
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("txtLast" +factorRow);
          _jspx_th_impact_validateInput_8.setLabel("Last");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setSize("22");
          _jspx_th_impact_validateInput_8.setMaxLength("22");
          _jspx_th_impact_validateInput_8.setConstraint("Name22");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      <tr class=\"subDetail\">\r\n        <td>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setColspan("3");
          _jspx_th_impact_validateDate_0.setLabel("To be completed by");
          _jspx_th_impact_validateDate_0.setName("dtToBeCompletedBy" +factorRow);
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(dtToBeCompletedBy) );
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setRequired("false");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    </td>\r\n    </tr>\r\n    <!-- <br>-->\r\n    <tr>\r\n    <td>\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n\r\n      <tr>\r\n        <td colspan=\"3\">\r\n          Description of Actions:\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n\r\n          ");
fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", "+  "txtActions" + factorRow + append;

          
          out.write("\r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtActions"+ factorRow);
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("100");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n            ");
              out.print(FormattingHelper.formatString(txtActions));
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
          out.write("\r\n        </td>\r\n      </tr>\r\n\r\n      <tr>\r\n\r\n        <td colspan=\"3\">\r\n          Comments:\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n\r\n          ");
fieldsToBeSpellChecked = fieldsToBeSpellChecked +  ", "+ "txtComments" + factorRow + append;

          
          out.write("\r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtComments" +factorRow);
          _jspx_th_impact_validateTextArea_2.setRows("3");
          _jspx_th_impact_validateTextArea_2.setCols("100");
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_2.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n            ");
              out.print(FormattingHelper.formatString(txtComments));
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
          out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    </td>\r\n    </tr>\r\n    \r\n    <tr>\r\n    <td>\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n       <tr> \r\n        <td align=\"right\">\r\n\r\n          ");
if (safetyFactorList.size() == factorRow) {

            
          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd" + factorRow );
          _jspx_th_impact_ButtonTag_1.setImg("btnAddFactor");
          _jspx_th_impact_ButtonTag_1.setForm("frmSafetyPlan");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/SafetyPlan/addSafetyFactor");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setAccessKey("N");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
}
          if ((safetyFactorList.size() != factorRow) || ((safetyFactorList.size() == factorRow) && (idSftyFctr != 0))) {

            
          out.write("\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnDelete" + factorRow );
          _jspx_th_impact_ButtonTag_2.setImg("btnDeleteFactor");
          _jspx_th_impact_ButtonTag_2.setForm("frmSafetyPlan");
          _jspx_th_impact_ButtonTag_2.setAction("/investigation/SafetyPlan/deleteSafetyFactor");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setFunction("return deleteThisSection('"+factorRow+"');");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
}

        
          out.write("\r\n\r\n        </td>\r\n       </tr> \r\n\r\n      </table>\r\n    </td>  \r\n    </tr>  \r\n\t\r\n      ");
}
      }

      
          out.write("\r\n\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("factorRowsCount");
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatInt(factorRow));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <!-- <hr> -->\r\n      <tr>\r\n      <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"  >\r\n        <tr>\r\n          <td colspan=\"3\" width=\"40%\">\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Date Safety Plan was discussed with caretaker");
          _jspx_th_impact_validateDate_1.setName("dtDiscWithCrtkr");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(dtDiscWithCrtkr) );
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n          </td>\r\n        <tr>\r\n        <tr>\r\n\r\n          <td colspan=\"3\" width=\"25%\">\r\n            Caretaker agree with plan\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setLabel("Yes");
          _jspx_th_impact_validateInput_10.setId("CareTakerAgree_Yes");
          _jspx_th_impact_validateInput_10.setName("rbCareTaker");
          _jspx_th_impact_validateInput_10.setValue("Y");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setChecked( careTakerAgree_Yes );
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("No");
          _jspx_th_impact_validateInput_11.setId("CareTakerAgree_No");
          _jspx_th_impact_validateInput_11.setName("rbCareTaker");
          _jspx_th_impact_validateInput_11.setValue("N");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setChecked( careTakerAgree_No );
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n\r\n        </tr>\r\n\r\n\r\n      </table>\r\n      </td>\r\n      </tr>\r\n\r\n      \r\n      \r\n      \r\n      <tr>\r\n      <td>  \r\n       <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" >\r\n\r\n        <tr>\r\n\t\t <hr>\r\n\t\t ");
 if (GlobalData.getUlIdEvent(request) > 0) { 
          out.write("\r\n\t\t <td align=\"left\" width=\"5%\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnDeleteSafetyPlan");
          _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_3.setForm("frmSafetyPlan");
          _jspx_th_impact_ButtonTag_3.setAction("/investigation/SafetyPlan/deleteSafetyPlan");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         </td>\r\n         ");
 } 
          out.write("\r\n          <td width=\"80%\" align=\"right\">\r\n            ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmSafetyPlan");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck( fieldsToBeSpellChecked );
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td align=\"right\" width=\"10%\">\r\n            ");
if (saveAndSubmit) {

        
          out.write("\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_4.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_4.setForm("frmSafetyPlan");
          _jspx_th_impact_ButtonTag_4.setAction("/investigation/SafetyPlan/saveAndSubmitSafetyPlan");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n          </td>\r\n          ");
}
      if (save) {

        
          out.write("\r\n          <td align=\"right\" width=\"5%\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSave");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setForm("frmSafetyPlan");
          _jspx_th_impact_ButtonTag_5.setAction("/investigation/SafetyPlan/saveSafetyPlan");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          ");
}

      
          out.write("\r\n        </tr>\r\n      </table>\r\n      \r\n      </tr>\r\n     </table> \r\n\t  \r\n      <INPUT type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("dtTsSafetyPlanLastUpdate");
          _jspx_th_impact_validateInput_12.setValue(DateHelper.toISOString(dtTsSafetyPlanLastUpdate)  );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("dtTsEventLastUpdate");
          _jspx_th_impact_validateInput_13.setValue(DateHelper.toISOString(dtTsEventLastUpdate) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  \r\n \r\n<br>\r\n<br>\r\n \r\n ");
 if (bShowReportDropDown) { 
      out.write(" \r\n \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Forms Launch</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    <td>\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("2");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Safety Plan");
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("FAS03O00");
          _jspx_th_impact_document_0.setDocExists(false);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n         ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pStage");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pEvent");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  </tr>\r\n</table>\r\n");
 } 
      out.write("\r\n\r\n");
 /* end Forms and Reports */ 
      out.write("\r\n      <script language=\"JavaScript\" type=\"text/javascript\">\r\n   \r\n</script>");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("deleteFactorArrayIndex");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
