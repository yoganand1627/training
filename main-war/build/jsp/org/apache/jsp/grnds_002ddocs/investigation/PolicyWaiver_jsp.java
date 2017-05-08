package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.PolicyWaiverConversation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import org.apache.commons.lang.StringUtils;
import java.util.Date;
import java.util.Hashtable;

public final class PolicyWaiver_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Set the page mode 
  String pageMode = PageMode.getPageMode(request);

  boolean sDisableWvrTypeOnly = false;
  boolean sDisableField = false;
  boolean sDisplayButtons = true;
  boolean sDisplaySave = true;
  boolean sDisplayNew = false;
  boolean bShowSaveAndSubmitButton = true;
  if (pageMode.equals(PageModeConstants.MODIFY)) {
    sDisableWvrTypeOnly = true;
    // sDisplayButtons = true;
  } else if (pageMode.equals(PageModeConstants.VIEW)) {
    sDisableWvrTypeOnly = true;
    sDisableField = true;
  }
  if (pageMode.equals(PageModeConstants.NEW)) {
    sDisplayButtons = false;
  }
  
  if(GlobalData.isApprovalMode(request)){
  bShowSaveAndSubmitButton = false;
  }

  String waiverType = "";
  String waiverReason = "";
  Date currentDate = new Date();
  String dateOfRequest = "";
  String timeOfRequest = "";
  String caseManager = "";
  String dateOfExpiration = "";
  String comments = "";
  String pwTsLastUpdate = "";
  String monthOfContact = "";
  String yearOfContact = "";
  String personByIdWvrPrnUnableCnct = "";
  String personIdForPullback = "";
  String resourceIdForPullback = "";
  String other = "";
  String waiverJustification = "";
  String waiverCapacity = "";
  String dateOfBegin = "";
  String dateOfEnd = "";
  String sleepingArrangements = "";
  String approvedPerDiem = "";
  String county = "";
  String ctyOfPmt = "";
  String UASCode = "";
  String etntCode = "";
  String svcDesc = "";
  String personByIdWvrPryCust = "";
  String capsResource = "";
  double amount = 0.00;
  double unit = 0.00;
  ROWCCMN45DO eventDetails = null;
  String tsLastUpdate = "";
  boolean bShowDeleteButton = false;
  String waiverTypeSelected = "";

  //Using variables passed in on the request, set the display for the page
  //EXAMPLE
  String szCReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD; // Default value, for if the request parameter isn't set.
  if (request.getParameter("cReqFuncCd") != null) {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }
  waiverTypeSelected = ContextHelper.getStringSafe(request, "hdnWaiverType");
  if ("".equalsIgnoreCase(waiverTypeSelected)) {
    sDisplayNew = true;
    sDisplaySave = false;
  }
  // Get the user profile, if needed.
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;

  // Get the CRES03SO output object out of the request
  PolicyWaiverRetrieveSO policyWaiverRetrieveSO = (PolicyWaiverRetrieveSO) request
                                                                                  .getAttribute("PolicyWaiverRetrieveSO");
  if (policyWaiverRetrieveSO != null) {
    // Some variables to display data types for which resources do not contain examples; ususally, these values would
    //   be populated from GlobalData, request attributes, or request parameters.
    waiverType = policyWaiverRetrieveSO.getSzCdWvrType();
    waiverReason = policyWaiverRetrieveSO.getSzCdWvrReason();
    if (!DateHelper.isNull(policyWaiverRetrieveSO.getDtDtWvrRequest())) {
      dateOfRequest = FormattingHelper.formatDate(policyWaiverRetrieveSO.getDtDtWvrRequest());
    }
    if (!DateHelper.isNull(policyWaiverRetrieveSO.getDtDtWvrRequest())) {
      timeOfRequest = FormattingHelper.formatTime(policyWaiverRetrieveSO.getDtDtWvrRequest());
    }
    caseManager = FormattingHelper.formatString(policyWaiverRetrieveSO.getSzNmCaseManager());
    dateOfExpiration = FormattingHelper.formatDate(policyWaiverRetrieveSO.getDtDtWvrExprtn());
    comments = FormattingHelper.formatString(policyWaiverRetrieveSO.getSzTxtWvrComments());
    pwTsLastUpdate = DateHelper.toISOString(policyWaiverRetrieveSO.getDtLastUpdate());
    monthOfContact = policyWaiverRetrieveSO.getMnthWvrCtct();
    yearOfContact = policyWaiverRetrieveSO.getYrWvrCtct();
    personByIdWvrPrnUnableCnct = StringUtils.defaultString(policyWaiverRetrieveSO.getPersonByIdWvrPrnUnableCnct());
    personIdForPullback = StringUtils.defaultString(policyWaiverRetrieveSO.getPersonIdForPullback());
    resourceIdForPullback = StringUtils.defaultString(policyWaiverRetrieveSO.getResourceIdForPullback());
    other = policyWaiverRetrieveSO.getTxtWvrOther();
    waiverJustification = policyWaiverRetrieveSO.getCdWvrJustification();
    waiverCapacity = policyWaiverRetrieveSO.getTxtWvrCapacity();
    dateOfBegin = FormattingHelper.formatDate(policyWaiverRetrieveSO.getDtWvrBegin());
    dateOfEnd = FormattingHelper.formatDate(policyWaiverRetrieveSO.getDtWvrEnd());
    sleepingArrangements = policyWaiverRetrieveSO.getTxtSlpArngmts();
    if (sleepingArrangements == null) {
      sleepingArrangements = "";
    }
    approvedPerDiem = FormattingHelper.formatDouble(policyWaiverRetrieveSO.getAmtAppPrdm());
    county = policyWaiverRetrieveSO.getCdWvrAuthCounty();
    ctyOfPmt = policyWaiverRetrieveSO.getCdWvrPmtCounty();
    UASCode = policyWaiverRetrieveSO.getCdWvrUasCd();
    etntCode = policyWaiverRetrieveSO.getCdWvrEntCd();
    svcDesc = policyWaiverRetrieveSO.getCdWvrSvcDesc();
    personByIdWvrPryCust = policyWaiverRetrieveSO.getPersonByIdWvrPryCust();
    capsResource = policyWaiverRetrieveSO.getCapsResource();
    //amount = Double.parseDouble(policyWaiverRetrieveSO.getAmtWvr());
    // unit = Double.parseDouble(policyWaiverRetrieveSO.getNbrWvrUnit());

    eventDetails = policyWaiverRetrieveSO.getROWCCMN45DO();
    if (eventDetails != null && eventDetails.getUlIdEvent() != 0) {
      tsLastUpdate = DateHelper.toISOString(eventDetails.getTsLastUpdate());
    }

    //Initialize the variables that will specify the display rules for individual fields
    if (policyWaiverRetrieveSO.getIdWvrEvent() != 0) {
      bShowDeleteButton = true;
    }
  }
  // Null catch for cres03so, if null set to blank (initialize)
  else {
    policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
  }

  boolean approvalStatus = true;
  if (pageMode.equals(PageModeConstants.NEW)
      || (!PolicyWaiverConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus())
          && !PolicyWaiverConversation.EVENT_STATUS_COMP.equals(eventDetails.getSzCdEventStatus()) && !PolicyWaiverConversation.EVENT_STATUS_APPROVED
                                                                                                                                                     .equals(eventDetails
                                                                                                                                                                         .getSzCdEventStatus()))) {
    approvalStatus = false;
  }

      out.write('\r');
      out.write('\n');
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n");
      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n window.attachEvent('onload', updateEntCodes);\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n\r\n  //Submit the form with the correct cReqFuncCd for deleting.\r\n  function deletePhoneRow()\r\n  {\r\n    bRetValue = confirm('");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("')\r\n    if (bRetValue)\r\n    {\r\n      disableValidation(\"frmDetailTemplate\");\r\n    }\r\n    else\r\n    {\r\n      enableValidation(\"frmDetailTemplate\");\r\n    }\r\n    return bRetValue;\r\n  }\r\n  function openPersonList()\r\n{\r\n  var form = document.all[\"frmPolicyWaiver\"];\r\n  disableValidation(\"frmPolicyWaiver\");\r\n  return true;\r\n}\r\n\r\n function displayWaiverDetailSection()\r\n {\r\n    var policyWaiverType = document.frmPolicyWaiver.selCdWvrType.value;\r\n    var action = '/investigation/PolicyWaiver/savePolicyWaiverType';\r\n    document.frmPolicyWaiver.hdnWaiverType.value = policyWaiverType;\r\n    disableValidation('frmPolicyWaiver');\r\n    submitValidateForm( 'frmPolicyWaiver', action);\r\n }\r\n var codes252 = new Array();\r\ncodes252[0]= \"|\"; \r\ncodes252[1]= \"00\"+\"|\"+\"00 - Other Costs\";\r\nvar codes253 = new Array();\r\ncodes253[0]= \"|\"; \r\ncodes253[1]= \"00\"+\"|\"+\"00 - Other Costs\";\r\nvar codes450 = new Array();\r\ncodes450[0]= \"|\"; \r\ncodes450[1]= \"00\"+\"|\"+\"00 - Other Costs\";\r\nvar codes456 = new Array();\r\ncodes456[0]= \"|\"; \r\ncodes456[1]= \"00\"+\"|\"+\"00 - Other Costs\";\r\n");
      out.write("// end STGAP00002833\r\nvar codes504 = new Array();\r\ncodes504[0]= \"|\"; \r\ncodes504[1]= \"00\"+\"|\"+\"00 - Other Costs\";\r\ncodes504[2]= \"10\"+\"|\"+\"10 - Unusual Medical/Burial\";\r\ncodes504[3]= \"11\"+\"|\"+\"11 - Child Restraint Device\";\r\nvar codes522 = new Array(); \r\ncodes522[1]= \"00\"+\"|\"+\"00 - Other Costs\";\r\ncodes522[2]= \"10\"+\"|\"+\"10 - Unusual Medical/Burial\";\r\ncodes522[3]= \"11\"+\"|\"+\"11 - Child Restraint Device\"; \r\ncodes522[4] = \"99\"+\"|\"+ \"99 - Written Waiver Item\";\r\nvar codes513 = new Array(); \r\ncodes513[0]= \"|\"; \r\ncodes513[1]= \"12\"+\"|\"+ \"12 - Other Reimbursable Costs\";\r\nvar codes511 = new Array(); \r\ncodes511[0]= \"|\"; \r\ncodes511[1]= \"00\"+\"|\"+ \"00 - Other Costs\";\r\ncodes511[2]= \"12\"+\"|\"+ \"12 - Other Reimbursable Costs\";\r\ncodes511[3]= \"19\"+\"|\"+\"19 - Medical Exams (CCFA/Child)\";\r\ncodes511[4]= \"29\"+\"|\"+\"29 - Assessments\";\r\ncodes511[5]= \"54\"+\"|\"+\"54 - Psychological Evaluation\";\r\ncodes511[6]= \"88\"+\"|\"+\"88 - Court Appearances\";\r\n// STGAP00008445 Added 518-80 below\r\nvar codes518 = new Array(); \r\ncodes518[0]= \"|\"; \r\ncodes518[1]= \"00\"+\"|\"+ \"00 - Other Costs\";\r\n");
      out.write("codes518[2]= \"12\"+\"|\"+ \"12 - Other Reimbursable Costs\";\r\ncodes518[3]= \"24\"+\"|\"+ \"24 - Crisis Intervention Prevent Disruption\";\r\ncodes518[4]= \"47\"+\"|\"+ \"47 - Crisis Intervention Behavior Management\";\r\ncodes518[5]= \"56\"+\"|\"+ \"56 - Transportation\";\r\ncodes518[6]= \"71\"+\"|\"+ \"71 - In Home Case Management\";\r\ncodes518[7]= \"80\"+\"|\"+ \"80 - Summer Enrichment\"\r\ncodes518[8]= \"88\"+\"|\"+ \"88 - Court Appearances\";\r\ncodes518[9]= \"95\"+\"|\"+ \"95 - In-Home Intensive Treatment\";\r\nvar codes521 = new Array();\r\ncodes521[0]= \"|\"; \r\ncodes521[1]= \"48\"+\"|\"+\"48 - Emergency Housing\";\r\ncodes521[2]= \"49\"+\"|\"+\"49 - Day Care Services\";\r\ncodes521[3]= \"50\"+\"|\"+\"50 - Counseling\";\r\ncodes521[4]= \"51\"+\"|\"+\"51 - Drug Screens\";\r\ncodes521[5]= \"52\"+\"|\"+\"52 - Substance Abuse\";\r\ncodes521[6]= \"53\"+\"|\"+\"53 - Medical/Dental Services\";\r\ncodes521[7]= \"54\"+\"|\"+\"54 - Psychological Evaluation\";\r\ncodes521[8]= \"56\"+\"|\"+\"56 - Transportation\";\r\nvar codes525 = new Array(); \r\ncodes525[0]= \"|\"; \r\ncodes525[1]= \"19\"+\"|\"+ \"19 - Medical Exams (CCFA/Child)\";\r\ncodes525[2]= \"20\"+\"|\"+ \"20 - Medical Exams - Adult\";\r\n");
      out.write("var codes531 = new Array(); \r\ncodes531[0]= \"|\"; \r\ncodes531[1]= \"06\"+\"|\"+ \"06 - Support Services\";\r\ncodes531[2]= \"67\"+\"|\"+ \"67 - IMPACT\";\r\ncodes531[3]= \"68\"+\"|\"+ \"68 - Continued Parent Development\";\r\nvar codes547 = new Array(); \r\ncodes547[0]= \"|\"; \r\ncodes547[1]= \"96\"+\"|\"+ \"96 - Family FC Emergency Beds\";\r\ncodes547[2]= \"97\"+\"|\"+ \"97 - IFC Emergency Beds\";\r\nvar codes551 = new Array(); \r\ncodes551[0]= \"|\"; \r\ncodes551[1]= \"79\"+\"|\"+ \"79 - Prevention Services\";\r\nvar codes571 = new Array(); \r\ncodes571[0]= \"|\"; \r\ncodes571[1]= \"29\"+\"|\"+ \"29 - Assessments\";\r\ncodes571[2]= \"61\"+\"|\"+ \"61 - Homestead Services\";\r\ncodes571[3]= \"62\"+\"|\"+ \"62 - Crisis Intervention Payment\";\r\nvar codes573 = new Array(); \r\ncodes573[0]= \"|\"; \r\ncodes573[1]= \"72\"+\"|\"+ \"72 - Parent Aide Services\";\r\nvar codes588 = new Array(); \r\ncodes588[0]= \"|\"; \r\ncodes588[1]= \"85\"+\"|\"+ \"85 - Intensive Family Services\";\r\ncodes588[2]= \"86\"+\"|\"+ \"86 - Preventive Family Services\";\r\nvar codes597 = new Array(); \r\ncodes597[0]= \"|\"; \r\ncodes597[1]= \"W1\"+\"|\"+ \"W1 - Level1\";\r\ncodes597[2]= \"W2\"+\"|\"+ \"W2 - Level2\";\r\n");
      out.write("var codes698 = new Array(); \r\ncodes698[0]= \"|\"; \r\ncodes698[1]= \"41\"+\"|\"+ \"41 - Emergency Benefits\";\r\nvar codes773 = new Array(); \r\ncodes773[0]= \"|\"; \r\ncodes773[1]= \"73\"+\"|\"+ \"73 - Family Preservation - Placement Prevention\";\r\ncodes773[2]= \"24\"+\"|\"+ \"24 - Crisis Intervention Prevent Disruption\";\r\nvar codes774 = new Array(); \r\ncodes774[0]= \"|\"; \r\ncodes774[1]= \"74\"+\"|\"+ \"74 - Diversion and Family Support Services\";\r\ncodes774[2]= \"C9\"+\"|\"+ \"C9 - CPPC Expenses\";\r\nvar codes783 = new Array(); \r\ncodes783[0]= \"|\"; \r\ncodes783[1]= \"83\"+\"|\"+ \"83 - Intervention and Support Services\";\r\nvar codes784 = new Array(); \r\ncodes784[0]= \"|\"; \r\ncodes784[1]= \"84\"+\"|\"+ \"84 - Adoption Promotion Activities\";\r\ncodes784[2]= \"57\"+\"|\"+ \"57 - Pre and Post Adoption and Support Services\";\r\nvar codes873 = new Array(); \r\ncodes873[0]= \"|\"; \r\ncodes873[1]= \"24\"+\"|\"+ \"24 - Crisis Intervention Prevent Disruption\";\r\ncodes873[2]= \"R1\"+\"|\"+ \"R1 - Residential After-Care Services\";\r\ncodes873[3]= \"R2\"+\"|\"+ \"R2 - Comprehensive Discharge Planning\";\r\ncodes873[4]= \"R3\"+\"|\"+ \"R3 - Placement Services\";\r\n");
      out.write("codes873[5]= \"R4\"+\"|\"+ \"R4 - Intensive Case Management\";\r\ncodes873[6]= \"R5\"+\"|\"+ \"R5 - Therapeutic Counseling\";\r\ncodes873[7]= \"R6\"+\"|\"+ \"R6 - Behavior Management\";\r\ncodes873[8]= \"R7\"+\"|\"+ \"R7 - 24-hour Crisis Intervention\";\r\ncodes873[9]= \"S7\"+\"|\"+ \"S7 - Relative Caregiver Support Services\";\r\nvar codes874 = new Array(); \r\ncodes874[0]= \"|\"; \r\ncodes874[1]= \"S5\"+\"|\"+ \"S5 - Parent Support Services Early Intervention\";\r\ncodes874[2]= \"S6\"+\"|\"+ \"S6 - Parent Support Services Placement Prevention\";\r\ncodes874[3]= \"S7\"+\"|\"+ \"S7 - Relative Caregiver Support Services \";\r\ncodes874[4]= \"S8\"+\"|\"+ \"S8 - Substance Abuse Treatment and Support Services\";\r\ncodes874[5]= \"S9\"+\"|\"+ \"S9 - Healthy Marriage and Co-Parenting Support Services\";\r\nvar codes883 = new Array(); \r\ncodes883[0]= \"|\"; \r\ncodes883[1]= \"83\"+\"|\"+ \"83 - Intervention and Support Services\";\r\ncodes883[2]= \"S3\"+\"|\"+ \"S3 - Family Access and Visitation Center Visits\";\r\ncodes883[3]= \"S4\"+\"|\"+ \"S4 - Transitional Support Services\";\r\nvar codes884 = new Array(); \r\ncodes884[0]= \"|\"; \r\n");
      out.write("codes884[1]= \"84\"+\"|\"+ \"84 - Adoption Promotion Activities\";\r\ncodes884[2]= \"S1\"+\"|\"+ \"S1 - Foster Care Transitional Support Services\";\r\ncodes884[3]= \"S2\"+\"|\"+ \"S2 - Foster Care Emancipation Support Services\";\r\nvar codes510 = new Array(); \r\ncodes510[0]= \"|\"; \r\ncodes510[1]= \"33\"+\"|\"+ \"33 - Non Recurring Adoption Expenses\";\r\nvar codes512 = new Array(); \r\ncodes512[0]= \"|\"; \r\ncodes512[1]= \"17\"+\"|\"+ \"17 - Supplemental Supervision\";\r\ncodes512[2]= \"57\"+\"|\"+ \"57 - Pre and Post Adoption and Support Services\";\r\ncodes512[3]= \"58\"+\"|\"+ \"58 - Special Services Adoption Assistance - Surgery, Therapy, Etc.\";\r\ncodes512[4]= \"60\"+\"|\"+ \"60 - Special Services Adoption Assistance  Respite Care\";\r\ncodes512[5]= \"77\"+\"|\"+ \"77 - Adoptive Placement Reimbursement Foster Parent Conversion\";\r\nvar codes582 = new Array(); \r\ncodes582[0]= \"|\"; \r\ncodes582[1]= \"28\"+\"|\"+ \"28 - Financial Literacy Training\";\r\ncodes582[2]= \"32\"+\"|\"+ \"32 - Independent Living Meetings\";\r\ncodes582[3]= \"42\"+\"|\"+ \"42 - Self Evaluation Meetings\";\r\ncodes582[4]= \"44\"+\"|\"+ \"44 - Diarist Payment\";\r\n");
      out.write("codes582[5]= \"87\"+\"|\"+ \"87 - Survey Stipend\";\r\ncodes582[6]= \"89\"+\"|\"+ \"89 - Half day Event\";\r\ncodes582[7]= \"93\"+\"|\"+ \"93 - Full day Event\";\r\nvar codes583 = new Array(); \r\ncodes583[0]= \"|\"; \r\ncodes583[1]= \"75\"+\"|\"+ \"75 - College Related Expenses\";\r\nvar codes585 = new Array(); \r\ncodes585[0]= \"|\"; \r\ncodes585[1]= \"76\"+\"|\"+ \"76 - Educational and Enrichment Expenses\";\r\ncodes585[2]= \"80\"+\"|\"+ \"80 - Summer Enrichment\";\r\nvar codes586 = new Array(); \r\ncodes586[0]= \"|\"; \r\ncodes586[1]= \"29\"+\"|\"+ \"29 - Assessments\";\r\ncodes586[2]= \"78\"+\"|\"+ \"78 - Transitional Living Related Expenses\";\r\nvar codes584 = new Array(); \r\ncodes584 = codes583;\r\nvar codes591 = new Array(); \r\ncodes591 = codes583;\r\nvar codes576 = new Array();\r\ncodes576=codes522;\r\nvar codes578 = new Array();\r\ncodes578=codes522;\r\nvar codes598 = new Array();\r\ncodes598 = codes597;\r\n\r\n/// These arrays are used to populate the service codes\r\n\r\n\r\n\r\n");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName( CodesTables.CSVCCODE );
      _jspx_th_impact_codeArray_0.setArrayName( CodesTables.CSVCCODE );
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      _jspx_th_impact_codeArray_0.setOrderBy("decode");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\nfunction updateEntCodes()\r\n{\r\nvar category = frmPolicyWaiver.cdWvrUasCd.value;\r\nvar service = frmPolicyWaiver.cdWvrEntCd.value;\r\nvar options = frmPolicyWaiver.cdWvrEntCd.options;\r\nif(category==\"\"){\r\n//New mode so do not need to filter the entitlement codes dropdown\r\npopulateDropdown( frmPolicyWaiver.cdWvrEntCd , \"\", entCodes );\r\n}else{\r\nvar codeArray = eval(\"codes\" + category);\r\n// This condition is added to skip the call to populate drop down \r\nif(options==null){\r\n// Field is disabled so no need to call the populate drop down\r\n                 }else{\r\npopulateDropdown( frmPolicyWaiver.cdWvrEntCd , \"\", codeArray );\r\n \t\t\t\t\t  }\r\ndocument.frmPolicyWaiver.cdWvrEntCd.value=service;\r\n    }\r\n    updateServiceDescription();\r\n}\r\n\r\n// STGAP00008188 This Method takes the UAS Code and creates a filter for \r\n// Service Description Based on the UAS code only.  \r\nfunction updateServiceDescription() \r\n{\r\nvar category = frmPolicyWaiver.cdWvrUasCd.value;\r\nvar service = frmPolicyWaiver.cdWvrEntCd.value;\r\nvar options = frmPolicyWaiver.cdWvrEntCd.options;\r\n");
      out.write("var codeArray = ");
      out.print( CodesTables.CSVCCODE );
      out.write(";\r\nvar categoryCodeArray = new Array();\r\nvar j = 1;\r\nif(category == null){\r\nclearDropdown(frmPolicyWaiver.cdWvrSvcDesc);\r\n}\r\nelse{\r\nif(service == null || service == \"\"){\r\n\r\ncategoryCodeArray[0] = \"|\";\r\n\r\nfor (var q=0; q < codeArray.length; q++)\r\n     {\r\n\r\n      var code = codeArray[q].substring(0,codeArray[q].indexOf(\"|\"));\r\n      var decode = codeArray[q].substring( codeArray[q].indexOf(\"|\")+1, codeArray[q].length);\r\n      var categoryCode = category.substring(0,3);\r\n      var codeSubString = code.substring(0,3);\r\n      \r\n      if(codeSubString == categoryCode){\r\n      categoryCodeArray[j] = code + \"|\" + decode;\r\n      j++; \r\n     }\r\n}\r\n populateDropdown(frmPolicyWaiver.cdWvrSvcDesc, \"\", categoryCodeArray);\r\n}\r\nelse{\r\nupdateServiceDescriptionFull();\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n\r\n//STGAP00008188  Function is used to filter service description with information \r\n// from UAS code and Entiltement code. \r\nfunction updateServiceDescriptionFull(){\r\nvar category = frmPolicyWaiver.cdWvrUasCd.value;\r\nvar description = frmPolicyWaiver.cdWvrSvcDesc.value;\r\n");
      out.write("var service = frmPolicyWaiver.cdWvrEntCd.value;\r\nvar fullCode = category + service;\r\nvar codeArray2 = ");
      out.print( CodesTables.CSVCCODE );
      out.write(";\r\nvar categoryCodeArray = new Array();\r\ncategoryCodeArray[0] = \"|\";\r\nvar j = 1;\r\nif(service !=null && service != \"\")\r\n{ \r\n  clearDropdown(frmPolicyWaiver.cdWvrSvcDesc);\r\nfor (var q=0; q < codeArray2.length; q++)\r\n     {\r\n      var decode = codeArray2[q].substring( codeArray2[q].indexOf(\"|\")+1, codeArray2[q].length);\r\n     var code = codeArray2[q].substring(0,codeArray2[q].indexOf(\"|\"));\r\n      var categoryCode = code.substring(0,5);\r\n      if(fullCode == categoryCode){\r\n      categoryCodeArray[j] = code + \"|\" + decode;\r\n      j++;\r\n      \t}\r\n      \r\n     }\r\npopulateDropdown(frmPolicyWaiver.cdWvrSvcDesc, \"\", categoryCodeArray);\r\ndocument.frmPolicyWaiver.cdWvrSvcDesc.value=description;\r\n}\r\nelse if(category != null)\r\n{\r\nupdateServiceDescription();\r\n}\r\n}\r\n \r\n \r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPolicyWaiver");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/PolicyWaiver/savePolicyWaiver");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.PolicyWaiverCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<input type=\"hidden\" name=\"hdnWaiverType\"\r\n\t\tvalue=\"");
          out.print(waiverTypeSelected);
          out.write("\" />\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_0.setValue(szCReqFuncCd);
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
          _jspx_th_impact_validateInput_1.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_1.setValue(tsLastUpdate);
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
          _jspx_th_impact_validateInput_2.setName("pwTsLastUpdate");
          _jspx_th_impact_validateInput_2.setValue(pwTsLastUpdate);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t");

			  if (approvalStatus) {
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/displayStatus");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"5\">\r\n\t\t\t\tPolicy Waiver Type\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Case Manager");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(caseManager);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dtDtWvrRequest");
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Request Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(dateOfRequest);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("tmWvrRequest");
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Time");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(timeOfRequest);
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  // ExcludeOptions for different stages.

		    Hashtable excludeList = new Hashtable();
		    excludeList.put("45 Day Investigation Waiver", CodesTables.CWVRTYP_WIV);
		    excludeList.put("Additional Services", CodesTables.CWVRTYP_WAS);
		    excludeList.put("Child Life History", CodesTables.CWVRTYP_WCL);
		    excludeList.put("Placement Waiver", CodesTables.CWVRTYP_WPW);
		    excludeList.put("Level of Care Provider", CodesTables.CWVRTYP_WLC);
		    excludeList.put("Contact Standards", CodesTables.CWVRTYP_WCS);
            excludeList.put("30 Day Grace Period Waiver", CodesTables.CWVRTYP_WGP);

		    if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_INV)) {
		      //inv - contact standards, 45 day and additional services
		      excludeList.remove("45 Day Investigation Waiver");
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Additional Services");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_SUB)) {
		      excludeList.remove("Child Life History");
		      excludeList.remove("Level of Care Provider");
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Additional Services");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FAD)) {
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Placement Waiver");
              excludeList.remove("30 Day Grace Period Waiver");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ADO)) {
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Child Life History");
		      excludeList.remove("Additional Services");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_DIV)) {
		      excludeList.remove("Additional Services");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FSU)) {
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Additional Services");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_PFC)) {
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Additional Services");
		    } else if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FPR)) {
		      excludeList.remove("Contact Standards");
		      excludeList.remove("Additional Services");
		    }
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Waiver Type");
          _jspx_th_impact_validateSelect_0.setName("selCdWvrType");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeList.values());
          _jspx_th_impact_validateSelect_0.setDisabled(String.valueOf(sDisableWvrTypeOnly));
          _jspx_th_impact_validateSelect_0.setCodesTable("CWVRTYP");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue(waiverType);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	  if (pageMode.equals(PageModeConstants.NEW)) {
	
          out.write("\r\n\t<table cellspacing=\"0\" cellPadding=\"3\" width=\"100%\" border=\"0\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignLeft\" width=\"85%\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnContinue");
          _jspx_th_impact_ButtonTag_1.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/PolicyWaiver/savePolicyWaiverType");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	  }
	
          out.write("\r\n\r\n\t");

	  if (sDisplayButtons) {
	
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"5\">\r\n\t\t\t\tPolicy Waiver Detail\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\r\n\t\t");

		  if ((CodesTables.CWVRTYP_WIV).equals(waiverType) || (CodesTables.CWVRTYP_WCL).equals(waiverType)) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t");

			  if ((CodesTables.CWVRTYP_WIV).equals(waiverType)) {
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Reason");
          _jspx_th_impact_validateSelect_1.setName("selCdWvrReason");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateSelect_1.setCodesTable("CWVRRSN");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(waiverReason);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  } else {
			
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Reason");
          _jspx_th_impact_validateSelect_2.setName("selCdWvrReason");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateSelect_2.setCodesTable("CWCLRSN");
          _jspx_th_impact_validateSelect_2.setRequired("false");
          _jspx_th_impact_validateSelect_2.setValue(waiverReason);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtDtWvrExprtn");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Expiration Date");
          _jspx_th_impact_validateDate_0.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateDate_0.setValue(dateOfExpiration);
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtWvrComments");
          _jspx_th_impact_validateTextArea_0.setColspan("5");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print(comments);
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

		  } else if ((CodesTables.CWVRTYP_WCS).equals(waiverType)) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Contact Month");
          _jspx_th_impact_validateSelect_3.setName("mnthWvrCtct");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setCodesTable("CMONTHS");
          _jspx_th_impact_validateSelect_3.setValue(monthOfContact);
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Contact Year");
          _jspx_th_impact_validateSelect_4.setName("yrWvrCtct");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setCodesTable("CYEAR");
          _jspx_th_impact_validateSelect_4.setValue(yearOfContact);
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("personByIdWvrPrnUnableCnct");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Person Unable to Contact");
          _jspx_th_impact_validateDisplayOnlyField_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(personByIdWvrPrnUnableCnct);
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<input type=\"hidden\" name=\"personIdForPullback\"\r\n\t\t\t\tvalue=\"");
          out.print(personIdForPullback);
          out.write("\" />\r\n\t\t\t<td>\r\n\t\t\t\t");

				  if (!sDisableField) {
				
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSelectPerson");
          _jspx_th_impact_ButtonTag_2.setAccessKey("P");
          _jspx_th_impact_ButtonTag_2.setBackSafe("true");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setAction("/investigation/PolicyWaiver/retrievePerson");
          _jspx_th_impact_ButtonTag_2.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmPolicyWaiver');");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_2.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  }
				
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<td width=\"20%\">\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setValue(other);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("txtWvrOther");
          _jspx_th_impact_validateInput_3.setLabel("Other");
          _jspx_th_impact_validateInput_3.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setSize("15");
          _jspx_th_impact_validateInput_3.setMaxLength("30");
          _jspx_th_impact_validateInput_3.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_3.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Reason");
          _jspx_th_impact_validateSelect_5.setName("selCdWvrReason");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setCodesTable("CWCSRSN");
          _jspx_th_impact_validateSelect_5.setRequired("true");
          _jspx_th_impact_validateSelect_5.setValue(waiverReason);
          _jspx_th_impact_validateSelect_5.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<span class=\"formRequiredText\">*</span>Comments:Note all attempted\r\n\t\t\t\tcontact dates and methods\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\" valign=\"top\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtSzTxtWvrComments");
          _jspx_th_impact_validateTextArea_1.setColspan("5");
          _jspx_th_impact_validateTextArea_1.setLabel("");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setCols("80");
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("false");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_1.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print(comments);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  } else if ((CodesTables.CWVRTYP_WPW).equals(waiverType)) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setLabel("Reason");
          _jspx_th_impact_validateSelect_6.setName("selCdWvrReason");
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_6.setCodesTable("CWPWRSN");
          _jspx_th_impact_validateSelect_6.setRequired("true");
          _jspx_th_impact_validateSelect_6.setValue(waiverReason);
          _jspx_th_impact_validateSelect_6.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setLabel("Justification");
          _jspx_th_impact_validateSelect_7.setName("cdWvrJustification");
          _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_7.setCodesTable("CWPWJTF");
          _jspx_th_impact_validateSelect_7.setRequired("true");
          _jspx_th_impact_validateSelect_7.setValue(waiverJustification);
          _jspx_th_impact_validateSelect_7.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtWvrBegin");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setLabel("Begin Date");
          _jspx_th_impact_validateDate_1.setValue(dateOfBegin);
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("dtWvrEnd");
          _jspx_th_impact_validateDate_2.setDisabled("false");
          _jspx_th_impact_validateDate_2.setLabel("End Date");
          _jspx_th_impact_validateDate_2.setValue(dateOfEnd);
          _jspx_th_impact_validateDate_2.setSize("8");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td width=\"20%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setValue(waiverCapacity);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setName("txtWvrCapacity");
          _jspx_th_impact_validateInput_4.setLabel("Waiver Capacity");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setSize("2");
          _jspx_th_impact_validateInput_4.setMaxLength("2");
          _jspx_th_impact_validateInput_4.setConstraint("Numeric");
          _jspx_th_impact_validateInput_4.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtSlpArngmts");
          _jspx_th_impact_validateTextArea_2.setColspan("5");
          _jspx_th_impact_validateTextArea_2.setLabel("Sleeping Arrangements");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setCols("80");
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph");
          _jspx_th_impact_validateTextArea_2.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.print(sleepingArrangements);
              out.write("\r\n\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtSzTxtWvrComments");
          _jspx_th_impact_validateTextArea_3.setColspan("5");
          _jspx_th_impact_validateTextArea_3.setLabel("Comments");
          _jspx_th_impact_validateTextArea_3.setRows("4");
          _jspx_th_impact_validateTextArea_3.setCols("80");
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_3.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.print(comments);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  } else if ((CodesTables.CWVRTYP_WLC).equals(waiverType)) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setLabel("Reason");
          _jspx_th_impact_validateSelect_8.setName("selCdWvrReason");
          _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_8.setCodesTable("CWLCRSN");
          _jspx_th_impact_validateSelect_8.setRequired("true");
          _jspx_th_impact_validateSelect_8.setValue(waiverReason);
          _jspx_th_impact_validateSelect_8.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setLabel("Justification");
          _jspx_th_impact_validateSelect_9.setName("cdWvrJustification");
          _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_9.setCodesTable("CWLCJTF");
          _jspx_th_impact_validateSelect_9.setRequired("true");
          _jspx_th_impact_validateSelect_9.setValue(waiverJustification);
          _jspx_th_impact_validateSelect_9.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("dtWvrBegin");
          _jspx_th_impact_validateDate_3.setDisabled("false");
          _jspx_th_impact_validateDate_3.setLabel("Begin Date");
          _jspx_th_impact_validateDate_3.setValue(dateOfBegin);
          _jspx_th_impact_validateDate_3.setSize("8");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_3.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setName("dtWvrEnd");
          _jspx_th_impact_validateDate_4.setDisabled("false");
          _jspx_th_impact_validateDate_4.setLabel("End Date");
          _jspx_th_impact_validateDate_4.setValue(dateOfEnd);
          _jspx_th_impact_validateDate_4.setSize("8");
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          _jspx_th_impact_validateDate_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_4.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td width=\"20%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setValue(approvedPerDiem);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName("amtAppPrdm");
          _jspx_th_impact_validateInput_5.setLabel("Approved Per Diem");
          _jspx_th_impact_validateInput_5.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setSize("15");
          _jspx_th_impact_validateInput_5.setMaxLength("30");
          _jspx_th_impact_validateInput_5.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_5.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName("txtSzTxtWvrComments");
          _jspx_th_impact_validateTextArea_4.setColspan("5");
          _jspx_th_impact_validateTextArea_4.setLabel("Comments");
          _jspx_th_impact_validateTextArea_4.setRows("4");
          _jspx_th_impact_validateTextArea_4.setCols("80");
          _jspx_th_impact_validateTextArea_4.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_4.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.print(comments);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  } else if ((CodesTables.CWVRTYP_WAS).equals(waiverType)) {
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setLabel("County");
          _jspx_th_impact_validateSelect_10.setName("cdWvrAuthCounty");
          _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_10.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_10.setRequired("true");
          _jspx_th_impact_validateSelect_10.setValue(county);
          _jspx_th_impact_validateSelect_10.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setLabel("County of payment");
          _jspx_th_impact_validateSelect_11.setName("cdWvrPmtCounty");
          _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_11.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_11.setRequired("true");
          _jspx_th_impact_validateSelect_11.setValue(ctyOfPmt);
          _jspx_th_impact_validateSelect_11.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_12.setLabel("UAS Code");
          _jspx_th_impact_validateSelect_12.setName("cdWvrUasCd");
          _jspx_th_impact_validateSelect_12.setOnChange("updateEntCodes();");
          _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_12.setCodesTable("CPRGCOD1");
          _jspx_th_impact_validateSelect_12.setRequired("true");
          _jspx_th_impact_validateSelect_12.setValue(UASCode);
          _jspx_th_impact_validateSelect_12.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateSelect_12.setStyle("WIDTH:220px");
          int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
          if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_13.setLabel("Entitlement Code");
          _jspx_th_impact_validateSelect_13.setName("cdWvrEntCd");
          _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_13.setCodesTable("CENTCODE");
          _jspx_th_impact_validateSelect_13.setRequired("false");
          _jspx_th_impact_validateSelect_13.setValue(etntCode);
          _jspx_th_impact_validateSelect_13.setOnChange("updateServiceDescriptionFull()");
          _jspx_th_impact_validateSelect_13.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
          if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setName("dtWvrBegin");
          _jspx_th_impact_validateDate_5.setDisabled("false");
          _jspx_th_impact_validateDate_5.setLabel("Begin Date");
          _jspx_th_impact_validateDate_5.setValue(dateOfBegin);
          _jspx_th_impact_validateDate_5.setSize("8");
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_5.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_6.setName("dtWvrEnd");
          _jspx_th_impact_validateDate_6.setDisabled("false");
          _jspx_th_impact_validateDate_6.setLabel("End Date");
          _jspx_th_impact_validateDate_6.setValue(dateOfEnd);
          _jspx_th_impact_validateDate_6.setSize("8");
          _jspx_th_impact_validateDate_6.setConstraint("Date");
          _jspx_th_impact_validateDate_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_6.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
          if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<input type=\"hidden\" name=\"personIdForPullback\"\r\n\t\t\t\tvalue=\"");
          out.print(personIdForPullback);
          out.write("\" />\r\n\t\t\t<!-- td width=\"20%\" -->\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("personByIdWvrPryCust");
          _jspx_th_impact_validateInput_6.setLabel("Primary Customer");
          _jspx_th_impact_validateInput_6.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue(personByIdWvrPryCust);
          _jspx_th_impact_validateInput_6.setSize("30");
          _jspx_th_impact_validateInput_6.setMaxLength("30");
          _jspx_th_impact_validateInput_6.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_6.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateInput_6.setReadOnly("true");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  if (!sDisableField) {
				
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSelectPerson");
          _jspx_th_impact_ButtonTag_3.setAccessKey("P");
          _jspx_th_impact_ButtonTag_3.setBackSafe("true");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_3.setAction("/investigation/PolicyWaiver/retrievePerson");
          _jspx_th_impact_ButtonTag_3.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_3.setFunction("disableValidation('frmPolicyWaiver');");
          _jspx_th_impact_ButtonTag_3.setImg("btnSelectPerson");
          _jspx_th_impact_ButtonTag_3.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  }
				
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<!- td width=\"20%\" -->\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("capsResource");
          _jspx_th_impact_validateInput_7.setLabel("Resource");
          _jspx_th_impact_validateInput_7.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue(capsResource);
          _jspx_th_impact_validateInput_7.setSize("30");
          _jspx_th_impact_validateInput_7.setMaxLength("30");
          _jspx_th_impact_validateInput_7.setConstraint("Paragraph");
          _jspx_th_impact_validateInput_7.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateInput_7.setReadOnly("true");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  if (!sDisableField) {
				
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSelectResource");
          _jspx_th_impact_ButtonTag_4.setAccessKey("P");
          _jspx_th_impact_ButtonTag_4.setBackSafe("true");
          _jspx_th_impact_ButtonTag_4.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_4.setFunction("disableValidation('frmPolicyWaiver');");
          _jspx_th_impact_ButtonTag_4.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_4.setAction("/investigation/PolicyWaiver/retrieveResource");
          _jspx_th_impact_ButtonTag_4.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  }
				
          out.write("\r\n\t\t\t\t<input type=\"hidden\" name=\"resourceIdForPullback\"\r\n\t\t\t\t\tvalue=\"");
          out.print(resourceIdForPullback);
          out.write("\" />\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_14.setLabel("Service Description");
          _jspx_th_impact_validateSelect_14.setName("cdWvrSvcDesc");
          _jspx_th_impact_validateSelect_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_14.setCodesTable("CSVCCODE");
          _jspx_th_impact_validateSelect_14.setRequired("false");
          _jspx_th_impact_validateSelect_14.setValue(svcDesc);
          _jspx_th_impact_validateSelect_14.setDisabled(String.valueOf(sDisableField));
          _jspx_th_impact_validateSelect_14.setStyle("WIDTH:400px");
          int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
          if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td width=\"20%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatDouble(policyWaiverRetrieveSO.getAmtWvr(), 2));
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("amtWvr");
          _jspx_th_impact_validateInput_8.setLabel("Amount");
          _jspx_th_impact_validateInput_8.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setSize("15");
          _jspx_th_impact_validateInput_8.setMaxLength("30");
          _jspx_th_impact_validateInput_8.setConstraint("DoubleToHundredths");
          _jspx_th_impact_validateInput_8.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td width=\"20%\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatDouble(policyWaiverRetrieveSO.getNbrWvrUnit(), 2));
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setName("nbrWvrUnit");
          _jspx_th_impact_validateInput_9.setLabel("Units");
          _jspx_th_impact_validateInput_9.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setSize("15");
          _jspx_th_impact_validateInput_9.setMaxLength("30");
          _jspx_th_impact_validateInput_9.setConstraint("DoubleToHundredths");
          _jspx_th_impact_validateInput_9.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setName("txtSzTxtWvrComments");
          _jspx_th_impact_validateTextArea_5.setColspan("5");
          _jspx_th_impact_validateTextArea_5.setLabel("Comments");
          _jspx_th_impact_validateTextArea_5.setRows("4");
          _jspx_th_impact_validateTextArea_5.setCols("80");
          _jspx_th_impact_validateTextArea_5.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_5.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.print(comments);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n        ");

          } else if ((CodesTables.CWVRTYP_WGP).equals(waiverType)) {
        
          out.write("\r\n        <tr>\r\n            <td>\r\n                ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_15.setLabel("Reason");
          _jspx_th_impact_validateSelect_15.setName("selCdWvrReason");
          _jspx_th_impact_validateSelect_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_15.setCodesTable("CWGPRSN");
          _jspx_th_impact_validateSelect_15.setRequired("true");
          _jspx_th_impact_validateSelect_15.setValue(waiverReason);
          _jspx_th_impact_validateSelect_15.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateSelect_15 = _jspx_th_impact_validateSelect_15.doStartTag();
          if (_jspx_th_impact_validateSelect_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td><label name=\"label_dtWvrBegin\" id=\"label_dtWvrBegin_Id\" class=\"formLabel\" value=\"Begin Date\">Begin Date:</label></td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dtWvrBegin");
          _jspx_th_impact_validateDisplayOnlyField_4.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(dateOfBegin);
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            <!-- <input type=\"text\" name=\"dtWvrBegin\" id=\"dtWvrBegin_Id\" maxlength=\"10\" size=\"8\" title=\"Begin Date\" value=\"");
          out.print(dateOfBegin);
          out.write("\" disabled/> --></td>\r\n            <td><label name=\"label_dtWvrEnd\" id=\"label_dtWvrEnd_Id\" class=\"formLabel\" value=\"End Date\">End Date:</label></td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dtWvrEnd");
          _jspx_th_impact_validateDisplayOnlyField_5.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(dateOfEnd);
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            <!-- <input type=\"text\" name=\"dtWvrEnd\" id=\"dtWvrEnd_Id\" maxlength=\"10\" size=\"8\" title=\"End Date\" value=\"");
          out.print(dateOfEnd);
          out.write("\" disabled/> --></td>\r\n        </tr>\r\n        <tr>\r\n            <td valign=\"top\">\r\n                ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_6.setName("txtSzTxtWvrComments");
          _jspx_th_impact_validateTextArea_6.setColspan("5");
          _jspx_th_impact_validateTextArea_6.setLabel("Comments");
          _jspx_th_impact_validateTextArea_6.setRows("4");
          _jspx_th_impact_validateTextArea_6.setCols("80");
          _jspx_th_impact_validateTextArea_6.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_6.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_6.setDisabled(String.valueOf(sDisableField));
          int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
          if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_6.doInitBody();
            }
            do {
              out.print(comments);
              out.write("\r\n                ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n\t\t");

		  }
		
          out.write("\r\n\t</table>\r\n\t");
          out.write("\r\n\t<table cellspacing=\"0\" cellPadding=\"3\" width=\"100%\" border=\"0\">\r\n\t\t<tr>\r\n\t\t\t");

			  if (bShowDeleteButton) {
			
          out.write("\r\n\t\t\t<td class=\"alignLeft\" width=\"85%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnDelete");
          _jspx_th_impact_ButtonTag_5.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_5.setAction("/investigation/PolicyWaiver/deletePolicyWaiver");
          _jspx_th_impact_ButtonTag_5.setAlign("left");
          _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  } else {
			
          out.write("\r\n\t\t\t<td class=\"alignLeft\" width=\"85%\">\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t\t");
 
			if(bShowSaveAndSubmitButton){
			
          out.write("\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_6.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_6.setAlign("right");
          _jspx_th_impact_ButtonTag_6.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_6.setAction("/investigation/PolicyWaiver/saveAndSubmitPolicyWaiver");
          _jspx_th_impact_ButtonTag_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			}
			 
          out.write("\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_7.setName("btnSave");
          _jspx_th_impact_ButtonTag_7.setImg("btnSave");
          _jspx_th_impact_ButtonTag_7.setAlign("right");
          _jspx_th_impact_ButtonTag_7.setForm("frmPolicyWaiver");
          _jspx_th_impact_ButtonTag_7.setAction("/investigation/PolicyWaiver/savePolicyWaiver");
          _jspx_th_impact_ButtonTag_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
          if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

	  }
	
          out.write("\r\n\r\n\r\n\r\n\t");
          out.write("\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br />");
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

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CENTCODE");
    _jspx_th_impact_codeArray_1.setArrayName("entCodes");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    _jspx_th_impact_codeArray_1.setOrderBy("decode");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
